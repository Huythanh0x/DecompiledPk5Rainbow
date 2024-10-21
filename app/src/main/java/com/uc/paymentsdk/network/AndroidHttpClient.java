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
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
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

public final class AndroidHttpClient implements HttpClient {
    class CurlLogger implements HttpRequestInterceptor {
        private CurlLogger() {
        }

        CurlLogger(CurlLogger androidHttpClient$CurlLogger0) {
        }

        public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
            LoggingConfiguration androidHttpClient$LoggingConfiguration0 = AndroidHttpClient.this.curlConfiguration;
            if(androidHttpClient$LoggingConfiguration0 != null && androidHttpClient$LoggingConfiguration0.isLoggable() && (paramHttpRequest instanceof HttpUriRequest)) {
                androidHttpClient$LoggingConfiguration0.println(((HttpUriRequest)paramHttpRequest).getURI().getPath());
            }
        }
    }

    static class LoggingConfiguration {
        private final int level;
        private final String tag;

        private LoggingConfiguration(String paramString, int paramInt) {
            this.tag = paramString;
            this.level = paramInt;
        }

        LoggingConfiguration(String s, int v, LoggingConfiguration androidHttpClient$LoggingConfiguration0) {
            this(s, v);
        }

        private boolean isLoggable() {
            return Log.isLoggable(this.tag, this.level);
        }

        private void println(String paramString) {
            Log.println(this.level, this.tag, paramString);
        }
    }

    public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 0L;
    private static final String TAG = "AndroidHttpClient";
    private volatile LoggingConfiguration curlConfiguration;
    private final DefaultHttpClient delegate;
    private boolean mIsLoadCookies;
    private RuntimeException mLeakedException;
    private static final HttpRequestInterceptor sThreadCheckInterceptor;

    static {
        AndroidHttpClient.DEFAULT_SYNC_MIN_GZIP_BYTES = 0x100L;
        AndroidHttpClient.sThreadCheckInterceptor = new HttpRequestInterceptor() {
            public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) {
                if(Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                    throw new RuntimeException("This thread forbids HTTP requests");
                }
            }
        };
    }

    private AndroidHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams) {
        this.mIsLoadCookies = false;
        this.mLeakedException = new IllegalStateException("AndroidHttpClient created and never closed");
        this.delegate = new DefaultHttpClient(paramClientConnectionManager, paramHttpParams) {
            protected HttpContext createHttpContext() {
                HttpContext localBasicHttpContext = new BasicHttpContext();
                ((BasicHttpContext)localBasicHttpContext).setAttribute("http.authscheme-registry", this.getAuthSchemes());
                ((BasicHttpContext)localBasicHttpContext).setAttribute("http.cookiespec-registry", this.getCookieSpecs());
                ((BasicHttpContext)localBasicHttpContext).setAttribute("http.auth.credentials-provider", this.getCredentialsProvider());
                ((BasicHttpContext)localBasicHttpContext).setAttribute("http.cookie-store", this.getCookieStore());
                return localBasicHttpContext;
            }

            protected BasicHttpProcessor createHttpProcessor() {
                BasicHttpProcessor basicHttpProcessor0 = super.createHttpProcessor();
                basicHttpProcessor0.addRequestInterceptor(AndroidHttpClient.sThreadCheckInterceptor);
                basicHttpProcessor0.addRequestInterceptor(new CurlLogger(AndroidHttpClient.this, null));
                return basicHttpProcessor0;
            }
        };
    }

    public void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor) {
        if(paramHttpRequestInterceptor == null) {
            return;
        }
        int v = this.delegate.getRequestInterceptorCount();
        this.delegate.addRequestInterceptor(paramHttpRequestInterceptor, v);
    }

    public void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor) {
        if(paramHttpResponseInterceptor == null) {
            return;
        }
        int v = this.delegate.getResponseInterceptorCount();
        this.delegate.addResponseInterceptor(paramHttpResponseInterceptor, v);
    }

    public void clearCookies() {
        if(this.delegate != null) {
            this.delegate.setCookieStore(null);
        }
    }

    public void close() {
        if(this.mLeakedException != null) {
            this.getConnectionManager().shutdown();
            this.mLeakedException = null;
        }
    }

    public void disableCurlLogging() {
        this.curlConfiguration = null;
    }

    public void enableCurlLogging(String paramString, int paramInt) {
        if(paramString == null) {
            throw new NullPointerException("name");
        }
        if(paramInt < 2 || paramInt > 7) {
            throw new IllegalArgumentException("Level is out of range [2..7]");
        }
        this.curlConfiguration = new LoggingConfiguration(paramString, paramInt, null);
    }

    public Object execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler responseHandler0) throws IOException, ClientProtocolException {
        return this.delegate.execute(paramHttpHost, paramHttpRequest, responseHandler0);
    }

    public Object execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler responseHandler0, HttpContext paramHttpContext) throws IOException, ClientProtocolException {
        return this.delegate.execute(paramHttpHost, paramHttpRequest, responseHandler0, paramHttpContext);
    }

    public Object execute(HttpUriRequest paramHttpUriRequest, ResponseHandler responseHandler0) throws IOException, ClientProtocolException {
        return this.delegate.execute(paramHttpUriRequest, responseHandler0);
    }

    public Object execute(HttpUriRequest paramHttpUriRequest, ResponseHandler responseHandler0, HttpContext paramHttpContext) throws IOException, ClientProtocolException {
        return this.delegate.execute(paramHttpUriRequest, responseHandler0, paramHttpContext);
    }

    public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest) throws IOException {
        return this.delegate.execute(paramHttpHost, paramHttpRequest);
    }

    public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws IOException {
        return this.delegate.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
    }

    public HttpResponse execute(HttpUriRequest paramHttpUriRequest) throws IOException {
        return this.delegate.execute(paramHttpUriRequest);
    }

    public HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext) throws IOException {
        return this.delegate.execute(paramHttpUriRequest, paramHttpContext);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if(this.mLeakedException != null) {
            Log.e("AndroidHttpClient", "Leak found", this.mLeakedException);
            this.mLeakedException = null;
        }
    }

    public static AbstractHttpEntity getCompressedEntity(byte[] paramArrayOfByte) throws IOException {
        if(((long)paramArrayOfByte.length) < AndroidHttpClient.getMinGzipSize()) {
            return new ByteArrayEntity(paramArrayOfByte);
        }
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
        localGZIPOutputStream.write(paramArrayOfByte);
        localGZIPOutputStream.close();
        AbstractHttpEntity localByteArrayEntity = new ByteArrayEntity(localByteArrayOutputStream.toByteArray());
        ((ByteArrayEntity)localByteArrayEntity).setContentEncoding("gzip");
        return localByteArrayEntity;
    }

    public ClientConnectionManager getConnectionManager() {
        return this.delegate.getConnectionManager();
    }

    public CookieStore getCookies() {
        return this.delegate == null ? null : this.delegate.getCookieStore();
    }

    public static long getMinGzipSize() {
        return AndroidHttpClient.DEFAULT_SYNC_MIN_GZIP_BYTES;
    }

    public HttpParams getParams() {
        return this.delegate.getParams();
    }

    public static InputStream getUngzippedContent(HttpEntity paramHttpEntity) throws IOException {
        InputStream localObject = paramHttpEntity.getContent();
        if(localObject == null) {
            return null;
        }
        Header header0 = paramHttpEntity.getContentEncoding();
        if(header0 == null) {
            return localObject;
        }
        String s = header0.getValue();
        if(s == null) {
            return localObject;
        }
        return s.contains("gzip") ? new GZIPInputStream(localObject) : localObject;
    }

    public boolean isLoadOwnCookies() {
        return this.mIsLoadCookies;
    }

    public void loadCookies(CookieStore paramCookieStore) {
        this.mIsLoadCookies = true;
        this.delegate.setCookieStore(paramCookieStore);
    }

    public static void modifyRequestContentType(HttpRequest paramHttpRequest, String paramString) {
        paramHttpRequest.addHeader("Content-Type", paramString);
    }

    public static void modifyRequestToAcceptGzipResponse(HttpRequest paramHttpRequest) {
        paramHttpRequest.addHeader("Accept-Encoding", "gzip");
    }

    public static AndroidHttpClient newInstance(String paramString) {
        return AndroidHttpClient.newInstance(paramString, null);
    }

    public static AndroidHttpClient newInstance(String paramString, Context paramContext) {
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(((HttpParams)localBasicHttpParams), false);
        HttpConnectionParams.setConnectionTimeout(((HttpParams)localBasicHttpParams), 60000);
        HttpConnectionParams.setSoTimeout(((HttpParams)localBasicHttpParams), 60000);
        HttpConnectionParams.setSocketBufferSize(((HttpParams)localBasicHttpParams), 0x2000);
        ConnManagerParams.setMaxTotalConnections(((HttpParams)localBasicHttpParams), 60);
        ConnPerRouteBean localConnPerRouteBean = new ConnPerRouteBean(20);
        localConnPerRouteBean.setMaxForRoute(new HttpRoute(new HttpHost("locahost", 80)), 20);
        ConnManagerParams.setMaxConnectionsPerRoute(((HttpParams)localBasicHttpParams), ((ConnPerRoute)localConnPerRouteBean));
        HttpClientParams.setRedirecting(((HttpParams)localBasicHttpParams), false);
        HttpProtocolParams.setUserAgent(((HttpParams)localBasicHttpParams), paramString);
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        localSchemeRegistry.register(new Scheme("http", ((SocketFactory)PlainSocketFactory.getSocketFactory()), 80));
        localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        return new AndroidHttpClient(((ClientConnectionManager)new ThreadSafeClientConnManager(((HttpParams)localBasicHttpParams), localSchemeRegistry)), ((HttpParams)localBasicHttpParams));
    }

    public void removeRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor) {
        if(paramHttpRequestInterceptor == null) {
            return;
        }
        Class class0 = paramHttpRequestInterceptor.getClass();
        this.delegate.removeRequestInterceptorByClass(class0);
    }

    public void removeResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor) {
        if(paramHttpResponseInterceptor == null) {
            return;
        }
        Class class0 = paramHttpResponseInterceptor.getClass();
        this.delegate.removeResponseInterceptorByClass(class0);
    }

    private static String toCurl(HttpUriRequest paramHttpUriRequest, boolean paramBoolean) throws IOException {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("curl ");
        Header[] arr_header = paramHttpUriRequest.getAllHeaders();
        for(int v = 0; v < arr_header.length; ++v) {
            Header aheader = arr_header[v];
            if(paramBoolean || !aheader.getName().equals("Authorization") && !aheader.getName().equals("Cookie")) {
                localStringBuilder.append("--header \"");
                localStringBuilder.append(aheader.toString().trim());
                localStringBuilder.append("\" ");
            }
        }
        URI aurl = paramHttpUriRequest.getURI();
        if((paramHttpUriRequest instanceof RequestWrapper)) {
            HttpRequest httpRequest0 = ((RequestWrapper)paramHttpUriRequest).getOriginal();
            if((httpRequest0 instanceof HttpUriRequest)) {
                aurl = ((HttpUriRequest)httpRequest0).getURI();
            }
        }
        localStringBuilder.append("\"");
        localStringBuilder.append(aurl);
        localStringBuilder.append("\"");
        if((paramHttpUriRequest instanceof HttpEntityEnclosingRequest)) {
            HttpEntity httpEntity0 = ((HttpEntityEnclosingRequest)paramHttpUriRequest).getEntity();
            if(httpEntity0 != null && httpEntity0.isRepeatable()) {
                if(httpEntity0.getContentLength() < 0x400L) {
                    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                    httpEntity0.writeTo(localByteArrayOutputStream);
                    localStringBuilder.append(" --data-ascii \"").append(localByteArrayOutputStream.toString()).append("\"");
                    return localStringBuilder.toString();
                }
                localStringBuilder.append(" [TOO MUCH DATA TO INCLUDE]");
                return localStringBuilder.toString();
            }
        }
        return localStringBuilder.toString();
    }

    public void useCmwapConnection() {
        HttpHost localHttpHost = new HttpHost("10.0.0.172", 80, "http");
        this.delegate.getParams().setParameter("http.route.default-proxy", localHttpHost);
    }

    public void useDefaultConnection() {
        this.delegate.getParams().removeParameter("http.route.default-proxy");
    }
}

