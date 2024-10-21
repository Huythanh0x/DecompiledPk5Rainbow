package com.uc.paymentsdk.network;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes.dex */
public final class AndroidHttpClient implements HttpClient {
    private static final String TAG = "AndroidHttpClient";
    private volatile LoggingConfiguration curlConfiguration;
    private final DefaultHttpClient delegate;
    private boolean mIsLoadCookies = false;
    private RuntimeException mLeakedException = new IllegalStateException("AndroidHttpClient created and never closed");
    public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 256;
    private static final HttpRequestInterceptor sThreadCheckInterceptor = new HttpRequestInterceptor() { // from class: com.uc.paymentsdk.network.AndroidHttpClient.1
        @Override // org.apache.http.HttpRequestInterceptor
        public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) {
            if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                throw new RuntimeException("This thread forbids HTTP requests");
            }
        }
    };

    public static AndroidHttpClient newInstance(String paramString, Context paramContext) {
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 60000);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, 60000);
        HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
        ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 60);
        ConnPerRouteBean localConnPerRouteBean = new ConnPerRouteBean(20);
        HttpHost localHttpHost = new HttpHost("locahost", 80);
        localConnPerRouteBean.setMaxForRoute(new HttpRoute(localHttpHost), 20);
        ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, localConnPerRouteBean);
        HttpClientParams.setRedirecting(localBasicHttpParams, false);
        HttpProtocolParams.setUserAgent(localBasicHttpParams, paramString);
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ThreadSafeClientConnManager localThreadSafeClientConnManager = new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry);
        return new AndroidHttpClient(localThreadSafeClientConnManager, localBasicHttpParams);
    }

    public static AndroidHttpClient newInstance(String paramString) {
        AndroidHttpClient localAndroidHttpClient = newInstance(paramString, null);
        return localAndroidHttpClient;
    }

    public CookieStore getCookies() {
        if (this.delegate != null) {
            return this.delegate.getCookieStore();
        }
        return null;
    }

    private AndroidHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams) {
        this.delegate = new DefaultHttpClient(paramClientConnectionManager, paramHttpParams) { // from class: com.uc.paymentsdk.network.AndroidHttpClient.2
            @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
            protected BasicHttpProcessor createHttpProcessor() {
                BasicHttpProcessor localBasicHttpProcessor = super.createHttpProcessor();
                localBasicHttpProcessor.addRequestInterceptor(AndroidHttpClient.sThreadCheckInterceptor);
                localBasicHttpProcessor.addRequestInterceptor(new CurlLogger(AndroidHttpClient.this, null));
                return localBasicHttpProcessor;
            }

            @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
            protected HttpContext createHttpContext() {
                BasicHttpContext localBasicHttpContext = new BasicHttpContext();
                localBasicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
                localBasicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
                localBasicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
                localBasicHttpContext.setAttribute("http.cookie-store", getCookieStore());
                return localBasicHttpContext;
            }
        };
    }

    public void useCmwapConnection() {
        HttpHost localHttpHost = new HttpHost("10.0.0.172", 80, "http");
        this.delegate.getParams().setParameter("http.route.default-proxy", localHttpHost);
    }

    public void useDefaultConnection() {
        this.delegate.getParams().removeParameter("http.route.default-proxy");
    }

    public void loadCookies(CookieStore paramCookieStore) {
        this.mIsLoadCookies = true;
        this.delegate.setCookieStore(paramCookieStore);
    }

    public boolean isLoadOwnCookies() {
        return this.mIsLoadCookies;
    }

    public void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor) {
        if (paramHttpRequestInterceptor != null) {
            this.delegate.addRequestInterceptor(paramHttpRequestInterceptor, this.delegate.getRequestInterceptorCount());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor) {
        if (paramHttpRequestInterceptor != null) {
            this.delegate.removeRequestInterceptorByClass(paramHttpRequestInterceptor.getClass());
        }
    }

    public void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor) {
        if (paramHttpResponseInterceptor != null) {
            this.delegate.addResponseInterceptor(paramHttpResponseInterceptor, this.delegate.getResponseInterceptorCount());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor) {
        if (paramHttpResponseInterceptor != null) {
            this.delegate.removeResponseInterceptorByClass(paramHttpResponseInterceptor.getClass());
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mLeakedException != null) {
            Log.e(TAG, "Leak found", this.mLeakedException);
            this.mLeakedException = null;
        }
    }

    public static void modifyRequestToAcceptGzipResponse(HttpRequest paramHttpRequest) {
        paramHttpRequest.addHeader("Accept-Encoding", "gzip");
    }

    public static void modifyRequestContentType(HttpRequest paramHttpRequest, String paramString) {
        paramHttpRequest.addHeader("Content-Type", paramString);
    }

    public static InputStream getUngzippedContent(HttpEntity paramHttpEntity) throws IOException {
        Header localHeader;
        String str;
        InputStream localObject = paramHttpEntity.getContent();
        if (localObject != null && (localHeader = paramHttpEntity.getContentEncoding()) != null && (str = localHeader.getValue()) != null) {
            if (str.contains("gzip")) {
                localObject = new GZIPInputStream(localObject);
            }
            return localObject;
        }
        return localObject;
    }

    public void close() {
        if (this.mLeakedException != null) {
            getConnectionManager().shutdown();
            this.mLeakedException = null;
        }
    }

    @Override // org.apache.http.client.HttpClient
    public HttpParams getParams() {
        return this.delegate.getParams();
    }

    @Override // org.apache.http.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        return this.delegate.getConnectionManager();
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest paramHttpUriRequest) throws IOException {
        return this.delegate.execute(paramHttpUriRequest);
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext) throws IOException {
        return this.delegate.execute(paramHttpUriRequest, paramHttpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest) throws IOException {
        return this.delegate.execute(paramHttpHost, paramHttpRequest);
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws IOException {
        return this.delegate.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return (T) this.delegate.execute(httpUriRequest, responseHandler);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return (T) this.delegate.execute(httpUriRequest, responseHandler, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return (T) this.delegate.execute(httpHost, httpRequest, responseHandler);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return (T) this.delegate.execute(httpHost, httpRequest, responseHandler, httpContext);
    }

    public static AbstractHttpEntity getCompressedEntity(byte[] paramArrayOfByte) throws IOException {
        if (paramArrayOfByte.length < getMinGzipSize()) {
            return new ByteArrayEntity(paramArrayOfByte);
        }
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
        localGZIPOutputStream.write(paramArrayOfByte);
        localGZIPOutputStream.close();
        ByteArrayEntity localByteArrayEntity = new ByteArrayEntity(localByteArrayOutputStream.toByteArray());
        localByteArrayEntity.setContentEncoding("gzip");
        return localByteArrayEntity;
    }

    public static long getMinGzipSize() {
        return DEFAULT_SYNC_MIN_GZIP_BYTES;
    }

    public void enableCurlLogging(String paramString, int paramInt) {
        if (paramString == null) {
            throw new NullPointerException("name");
        }
        if (paramInt < 2 || paramInt > 7) {
            throw new IllegalArgumentException("Level is out of range [2..7]");
        }
        this.curlConfiguration = new LoggingConfiguration(paramString, paramInt, null);
    }

    public void disableCurlLogging() {
        this.curlConfiguration = null;
    }

    private static String toCurl(HttpUriRequest paramHttpUriRequest, boolean paramBoolean) throws IOException {
        HttpEntity localHttpEntity;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("curl ");
        for (Header aheader : paramHttpUriRequest.getAllHeaders()) {
            if (paramBoolean || (!aheader.getName().equals("Authorization") && !aheader.getName().equals("Cookie"))) {
                localStringBuilder.append("--header \"");
                localStringBuilder.append(aheader.toString().trim());
                localStringBuilder.append("\" ");
            }
        }
        URI aurl = paramHttpUriRequest.getURI();
        if (paramHttpUriRequest instanceof RequestWrapper) {
            HttpRequest localObject2 = ((RequestWrapper) paramHttpUriRequest).getOriginal();
            if (localObject2 instanceof HttpUriRequest) {
                aurl = ((HttpUriRequest) localObject2).getURI();
            }
        }
        localStringBuilder.append("\"");
        localStringBuilder.append(aurl);
        localStringBuilder.append("\"");
        if ((paramHttpUriRequest instanceof HttpEntityEnclosingRequest) && (localHttpEntity = ((HttpEntityEnclosingRequest) paramHttpUriRequest).getEntity()) != null && localHttpEntity.isRepeatable()) {
            if (localHttpEntity.getContentLength() < 1024) {
                ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                localHttpEntity.writeTo(localByteArrayOutputStream);
                String str = localByteArrayOutputStream.toString();
                localStringBuilder.append(" --data-ascii \"").append(str).append("\"");
            } else {
                localStringBuilder.append(" [TOO MUCH DATA TO INCLUDE]");
            }
        }
        return localStringBuilder.toString();
    }

    public void clearCookies() {
        if (this.delegate != null) {
            this.delegate.setCookieStore(null);
        }
    }

    /* loaded from: classes.dex */
    private class CurlLogger implements HttpRequestInterceptor {
        /* synthetic */ CurlLogger(AndroidHttpClient androidHttpClient, CurlLogger curlLogger) {
            this();
        }

        private CurlLogger() {
        }

        @Override // org.apache.http.HttpRequestInterceptor
        public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
            LoggingConfiguration localLoggingConfiguration = AndroidHttpClient.this.curlConfiguration;
            if (localLoggingConfiguration == null || !localLoggingConfiguration.isLoggable() || !(paramHttpRequest instanceof HttpUriRequest)) {
                return;
            }
            localLoggingConfiguration.println(((HttpUriRequest) paramHttpRequest).getURI().getPath());
        }
    }

    /* loaded from: classes.dex */
    private static class LoggingConfiguration {
        private final int level;
        private final String tag;

        private LoggingConfiguration(String paramString, int paramInt) {
            this.tag = paramString;
            this.level = paramInt;
        }

        /* synthetic */ LoggingConfiguration(String str, int i, LoggingConfiguration loggingConfiguration) {
            this(str, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isLoggable() {
            return Log.isLoggable(this.tag, this.level);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void println(String paramString) {
            Log.println(this.level, this.tag, paramString);
        }
    }
}
