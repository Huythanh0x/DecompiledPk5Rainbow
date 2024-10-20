package com.uc.paymentsdk.network;

import org.apache.http.HttpException;
import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.CookieStore;
import org.apache.http.HttpResponseInterceptor;
import java.net.URI;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.HttpHost;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.BasicHttpParams;
import android.content.Context;
import org.apache.http.Header;
import java.util.zip.GZIPInputStream;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import java.io.ByteArrayOutputStream;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.params.HttpParams;
import org.apache.http.conn.ClientConnectionManager;
import android.os.Looper;
import org.apache.http.protocol.HttpContext;
import org.apache.http.HttpRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.HttpClient;

public final class AndroidHttpClient implements HttpClient
{
    public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 0L;
    private static final String TAG = "AndroidHttpClient";
    private static final HttpRequestInterceptor sThreadCheckInterceptor;
    private volatile LoggingConfiguration curlConfiguration;
    private final DefaultHttpClient delegate;
    private boolean mIsLoadCookies;
    private RuntimeException mLeakedException;
    
    static {
        AndroidHttpClient.DEFAULT_SYNC_MIN_GZIP_BYTES = 256L;
        sThreadCheckInterceptor = (HttpRequestInterceptor)new HttpRequestInterceptor() {
            AndroidHttpClient$1() {
                super();
            }
            
            public void process(final HttpRequest httpRequest, final HttpContext httpContext) {
                if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                    throw new RuntimeException("This thread forbids HTTP requests");
                }
            }
        };
    }
    
    private AndroidHttpClient(final ClientConnectionManager clientConnectionManager, final HttpParams httpParams) {
        super();
        this.mIsLoadCookies = false;
        this.mLeakedException = new IllegalStateException("AndroidHttpClient created and never closed");
        this.delegate = new DefaultHttpClient(this, clientConnectionManager, httpParams) {
            final AndroidHttpClient this$0;
            
            AndroidHttpClient$2(final AndroidHttpClient this$0, final ClientConnectionManager clientConnectionManager, final HttpParams httpParams) {
                this.this$0 = this$0;
                super(clientConnectionManager, httpParams);
            }
            
            protected HttpContext createHttpContext() {
                final BasicHttpContext basicHttpContext = new BasicHttpContext();
                basicHttpContext.setAttribute("http.authscheme-registry", (Object)this.getAuthSchemes());
                basicHttpContext.setAttribute("http.cookiespec-registry", (Object)this.getCookieSpecs());
                basicHttpContext.setAttribute("http.auth.credentials-provider", (Object)this.getCredentialsProvider());
                basicHttpContext.setAttribute("http.cookie-store", (Object)this.getCookieStore());
                return (HttpContext)basicHttpContext;
            }
            
            protected BasicHttpProcessor createHttpProcessor() {
                final BasicHttpProcessor httpProcessor = super.createHttpProcessor();
                httpProcessor.addRequestInterceptor(sThreadCheckInterceptor);
                httpProcessor.addRequestInterceptor((HttpRequestInterceptor)this.this$0.new CurlLogger((CurlLogger)null));
                return httpProcessor;
            }
        };
    }
    
    static /* synthetic */ LoggingConfiguration access$0(final AndroidHttpClient androidHttpClient) {
        return androidHttpClient.curlConfiguration;
    }
    
    static /* synthetic */ HttpRequestInterceptor access$1() {
        return AndroidHttpClient.sThreadCheckInterceptor;
    }
    
    public static AbstractHttpEntity getCompressedEntity(final byte[] b) throws IOException {
        ByteArrayEntity byteArrayEntity;
        if (b.length < getMinGzipSize()) {
            byteArrayEntity = new ByteArrayEntity(b);
        }
        else {
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            final GZIPOutputStream gzipOutputStream = new GZIPOutputStream(out);
            gzipOutputStream.write(b);
            gzipOutputStream.close();
            byteArrayEntity = new ByteArrayEntity(out.toByteArray());
            byteArrayEntity.setContentEncoding("gzip");
        }
        return (AbstractHttpEntity)byteArrayEntity;
    }
    
    public static long getMinGzipSize() {
        return AndroidHttpClient.DEFAULT_SYNC_MIN_GZIP_BYTES;
    }
    
    public static InputStream getUngzippedContent(final HttpEntity httpEntity) throws IOException {
        final InputStream content = httpEntity.getContent();
        InputStream inputStream;
        if (content == null) {
            inputStream = content;
        }
        else {
            final Header contentEncoding = httpEntity.getContentEncoding();
            if (contentEncoding == null) {
                inputStream = content;
            }
            else {
                final String value = contentEncoding.getValue();
                if (value == null) {
                    inputStream = content;
                }
                else {
                    inputStream = content;
                    if (value.contains("gzip")) {
                        inputStream = new GZIPInputStream(content);
                    }
                }
            }
        }
        return inputStream;
    }
    
    public static void modifyRequestContentType(final HttpRequest httpRequest, final String s) {
        httpRequest.addHeader("Content-Type", s);
    }
    
    public static void modifyRequestToAcceptGzipResponse(final HttpRequest httpRequest) {
        httpRequest.addHeader("Accept-Encoding", "gzip");
    }
    
    public static AndroidHttpClient newInstance(final String s) {
        return newInstance(s, null);
    }
    
    public static AndroidHttpClient newInstance(final String s, final Context context) {
        final BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled((HttpParams)basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout((HttpParams)basicHttpParams, 60000);
        HttpConnectionParams.setSoTimeout((HttpParams)basicHttpParams, 60000);
        HttpConnectionParams.setSocketBufferSize((HttpParams)basicHttpParams, 8192);
        ConnManagerParams.setMaxTotalConnections((HttpParams)basicHttpParams, 60);
        final ConnPerRouteBean connPerRouteBean = new ConnPerRouteBean(20);
        connPerRouteBean.setMaxForRoute(new HttpRoute(new HttpHost("locahost", 80)), 20);
        ConnManagerParams.setMaxConnectionsPerRoute((HttpParams)basicHttpParams, (ConnPerRoute)connPerRouteBean);
        HttpClientParams.setRedirecting((HttpParams)basicHttpParams, false);
        HttpProtocolParams.setUserAgent((HttpParams)basicHttpParams, s);
        final SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", (SocketFactory)PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", (SocketFactory)SSLSocketFactory.getSocketFactory(), 443));
        return new AndroidHttpClient((ClientConnectionManager)new ThreadSafeClientConnManager((HttpParams)basicHttpParams, schemeRegistry), (HttpParams)basicHttpParams);
    }
    
    private static String toCurl(final HttpUriRequest httpUriRequest, final boolean b) throws IOException {
        final StringBuilder sb = new StringBuilder();
        sb.append("curl ");
        for (final Header header : httpUriRequest.getAllHeaders()) {
            if (b || (!header.getName().equals("Authorization") && !header.getName().equals("Cookie"))) {
                sb.append("--header \"");
                sb.append(header.toString().trim());
                sb.append("\" ");
            }
        }
        URI obj = httpUriRequest.getURI();
        if (httpUriRequest instanceof RequestWrapper) {
            final HttpRequest original = ((RequestWrapper)httpUriRequest).getOriginal();
            obj = obj;
            if (original instanceof HttpUriRequest) {
                obj = ((HttpUriRequest)original).getURI();
            }
        }
        sb.append("\"");
        sb.append(obj);
        sb.append("\"");
        if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
            final HttpEntity entity = ((HttpEntityEnclosingRequest)httpUriRequest).getEntity();
            if (entity != null && entity.isRepeatable()) {
                if (entity.getContentLength() < 1024L) {
                    final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    entity.writeTo((OutputStream)byteArrayOutputStream);
                    sb.append(" --data-ascii \"").append(byteArrayOutputStream.toString()).append("\"");
                }
                else {
                    sb.append(" [TOO MUCH DATA TO INCLUDE]");
                }
            }
        }
        return sb.toString();
    }
    
    public void addRequestInterceptor(final HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor != null) {
            this.delegate.addRequestInterceptor(httpRequestInterceptor, this.delegate.getRequestInterceptorCount());
        }
    }
    
    public void addResponseInterceptor(final HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor != null) {
            this.delegate.addResponseInterceptor(httpResponseInterceptor, this.delegate.getResponseInterceptorCount());
        }
    }
    
    public void clearCookies() {
        if (this.delegate != null) {
            this.delegate.setCookieStore((CookieStore)null);
        }
    }
    
    public void close() {
        if (this.mLeakedException != null) {
            this.getConnectionManager().shutdown();
            this.mLeakedException = null;
        }
    }
    
    public void disableCurlLogging() {
        this.curlConfiguration = null;
    }
    
    public void enableCurlLogging(final String s, final int n) {
        if (s == null) {
            throw new NullPointerException("name");
        }
        if (n < 2 || n > 7) {
            throw new IllegalArgumentException("Level is out of range [2..7]");
        }
        this.curlConfiguration = new LoggingConfiguration(s, n, null);
    }
    
    public <T> T execute(final HttpHost httpHost, final HttpRequest httpRequest, final ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return (T)this.delegate.execute(httpHost, httpRequest, (ResponseHandler)responseHandler);
    }
    
    public <T> T execute(final HttpHost httpHost, final HttpRequest httpRequest, final ResponseHandler<? extends T> responseHandler, final HttpContext httpContext) throws IOException, ClientProtocolException {
        return (T)this.delegate.execute(httpHost, httpRequest, (ResponseHandler)responseHandler, httpContext);
    }
    
    public <T> T execute(final HttpUriRequest httpUriRequest, final ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return (T)this.delegate.execute(httpUriRequest, (ResponseHandler)responseHandler);
    }
    
    public <T> T execute(final HttpUriRequest httpUriRequest, final ResponseHandler<? extends T> responseHandler, final HttpContext httpContext) throws IOException, ClientProtocolException {
        return (T)this.delegate.execute(httpUriRequest, (ResponseHandler)responseHandler, httpContext);
    }
    
    public HttpResponse execute(final HttpHost httpHost, final HttpRequest httpRequest) throws IOException {
        return this.delegate.execute(httpHost, httpRequest);
    }
    
    public HttpResponse execute(final HttpHost httpHost, final HttpRequest httpRequest, final HttpContext httpContext) throws IOException {
        return this.delegate.execute(httpHost, httpRequest, httpContext);
    }
    
    public HttpResponse execute(final HttpUriRequest httpUriRequest) throws IOException {
        return this.delegate.execute(httpUriRequest);
    }
    
    public HttpResponse execute(final HttpUriRequest httpUriRequest, final HttpContext httpContext) throws IOException {
        return this.delegate.execute(httpUriRequest, httpContext);
    }
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mLeakedException != null) {
            Log.e("AndroidHttpClient", "Leak found", (Throwable)this.mLeakedException);
            this.mLeakedException = null;
        }
    }
    
    public ClientConnectionManager getConnectionManager() {
        return this.delegate.getConnectionManager();
    }
    
    public CookieStore getCookies() {
        CookieStore cookieStore;
        if (this.delegate != null) {
            cookieStore = this.delegate.getCookieStore();
        }
        else {
            cookieStore = null;
        }
        return cookieStore;
    }
    
    public HttpParams getParams() {
        return this.delegate.getParams();
    }
    
    public boolean isLoadOwnCookies() {
        return this.mIsLoadCookies;
    }
    
    public void loadCookies(final CookieStore cookieStore) {
        this.mIsLoadCookies = true;
        this.delegate.setCookieStore(cookieStore);
    }
    
    public void removeRequestInterceptor(final HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor != null) {
            this.delegate.removeRequestInterceptorByClass((Class)httpRequestInterceptor.getClass());
        }
    }
    
    public void removeResponseInterceptor(final HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor != null) {
            this.delegate.removeResponseInterceptorByClass((Class)httpResponseInterceptor.getClass());
        }
    }
    
    public void useCmwapConnection() {
        this.delegate.getParams().setParameter("http.route.default-proxy", (Object)new HttpHost("10.0.0.172", 80, "http"));
    }
    
    public void useDefaultConnection() {
        this.delegate.getParams().removeParameter("http.route.default-proxy");
    }
    
    private class CurlLogger implements HttpRequestInterceptor
    {
        final AndroidHttpClient this$0;
        
        private CurlLogger(final AndroidHttpClient this$0) {
            this.this$0 = this$0;
            super();
        }
        
        CurlLogger(final AndroidHttpClient androidHttpClient, final CurlLogger curlLogger) {
            this(androidHttpClient);
        }
        
        public void process(final HttpRequest httpRequest, final HttpContext httpContext) throws HttpException, IOException {
            final LoggingConfiguration access$0 = curlConfiguration;
            if (access$0 != null && access$0.isLoggable() && httpRequest instanceof HttpUriRequest) {
                access$0.println(((HttpUriRequest)httpRequest).getURI().getPath());
            }
        }
    }
    
    private static class LoggingConfiguration
    {
        private final int level;
        private final String tag;
        
        private LoggingConfiguration(final String tag, final int level) {
            super();
            this.tag = tag;
            this.level = level;
        }
        
        LoggingConfiguration(final String s, final int n, final LoggingConfiguration loggingConfiguration) {
            this(s, n);
        }
        
        static /* synthetic */ boolean access$0(final LoggingConfiguration loggingConfiguration) {
            return loggingConfiguration.isLoggable();
        }
        
        static /* synthetic */ void access$1(final LoggingConfiguration loggingConfiguration, final String s) {
            loggingConfiguration.println(s);
        }
        
        private boolean isLoggable() {
            return Log.isLoggable(this.tag, this.level);
        }
        
        private void println(final String s) {
            Log.println(this.level, this.tag, s);
        }
    }
}
