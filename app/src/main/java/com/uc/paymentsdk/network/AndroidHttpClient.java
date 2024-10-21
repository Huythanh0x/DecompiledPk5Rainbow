/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  com.uc.paymentsdk.network.AndroidHttpClient$LoggingConfiguration
 *  org.apache.http.Header
 *  org.apache.http.HttpEntity
 *  org.apache.http.HttpEntityEnclosingRequest
 *  org.apache.http.HttpHost
 *  org.apache.http.HttpRequest
 *  org.apache.http.HttpRequestInterceptor
 *  org.apache.http.HttpResponse
 *  org.apache.http.HttpResponseInterceptor
 *  org.apache.http.client.ClientProtocolException
 *  org.apache.http.client.CookieStore
 *  org.apache.http.client.HttpClient
 *  org.apache.http.client.ResponseHandler
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.client.params.HttpClientParams
 *  org.apache.http.conn.ClientConnectionManager
 *  org.apache.http.conn.params.ConnManagerParams
 *  org.apache.http.conn.params.ConnPerRoute
 *  org.apache.http.conn.params.ConnPerRouteBean
 *  org.apache.http.conn.routing.HttpRoute
 *  org.apache.http.conn.scheme.PlainSocketFactory
 *  org.apache.http.conn.scheme.Scheme
 *  org.apache.http.conn.scheme.SchemeRegistry
 *  org.apache.http.conn.scheme.SocketFactory
 *  org.apache.http.conn.ssl.SSLSocketFactory
 *  org.apache.http.entity.AbstractHttpEntity
 *  org.apache.http.entity.ByteArrayEntity
 *  org.apache.http.impl.client.DefaultHttpClient
 *  org.apache.http.impl.client.RequestWrapper
 *  org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager
 *  org.apache.http.params.BasicHttpParams
 *  org.apache.http.params.HttpConnectionParams
 *  org.apache.http.params.HttpParams
 *  org.apache.http.params.HttpProtocolParams
 *  org.apache.http.protocol.HttpContext
 */
package com.uc.paymentsdk.network;

import android.content.Context;
import android.util.Log;
import com.uc.paymentsdk.network.AndroidHttpClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
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
import org.apache.http.protocol.HttpContext;

public final class AndroidHttpClient
implements HttpClient {
    public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 0L;
    private static final String TAG = "AndroidHttpClient";
    private static final HttpRequestInterceptor sThreadCheckInterceptor;
    private volatile LoggingConfiguration curlConfiguration;
    private final DefaultHttpClient delegate;
    private boolean mIsLoadCookies = false;
    private RuntimeException mLeakedException = new IllegalStateException("AndroidHttpClient created and never closed");

    static {
        DEFAULT_SYNC_MIN_GZIP_BYTES = 256L;
        sThreadCheckInterceptor = new /* Unavailable Anonymous Inner Class!! */;
    }

    private AndroidHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.delegate = new /* Unavailable Anonymous Inner Class!! */;
    }

    static /* synthetic */ LoggingConfiguration access$0(AndroidHttpClient androidHttpClient) {
        return androidHttpClient.curlConfiguration;
    }

    static /* synthetic */ HttpRequestInterceptor access$1() {
        return sThreadCheckInterceptor;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    public static AbstractHttpEntity getCompressedEntity(byte[] object) throws IOException {
        void var0_2;
        if ((long)((byte[])object).length < AndroidHttpClient.getMinGzipSize()) {
            ByteArrayEntity byteArrayEntity = new ByteArrayEntity(object);
            return var0_2;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write((byte[])object);
        gZIPOutputStream.close();
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(byteArrayOutputStream.toByteArray());
        byteArrayEntity.setContentEncoding("gzip");
        return var0_2;
    }

    public static long getMinGzipSize() {
        return DEFAULT_SYNC_MIN_GZIP_BYTES;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static InputStream getUngzippedContent(HttpEntity var0) throws IOException {
        block3: {
            block2: {
                var1_1 = var0 /* !! */ .getContent();
                if (var1_1 == null) {
                    var0 /* !! */  = var1_1;
lbl4:
                    // 5 sources

                    return var0 /* !! */ ;
                }
                if ((var0 /* !! */  = var0 /* !! */ .getContentEncoding()) != null) break block2;
                var0 /* !! */  = var1_1;
                ** GOTO lbl4
            }
            var2_2 = var0 /* !! */ .getValue();
            if (var2_2 != null) break block3;
            var0 /* !! */  = var1_1;
            ** GOTO lbl4
        }
        var0 /* !! */  = var1_1;
        if (!var2_2.contains("gzip")) ** GOTO lbl4
        var0 /* !! */  = new GZIPInputStream(var1_1);
        ** while (true)
    }

    public static void modifyRequestContentType(HttpRequest httpRequest, String string) {
        httpRequest.addHeader("Content-Type", string);
    }

    public static void modifyRequestToAcceptGzipResponse(HttpRequest httpRequest) {
        httpRequest.addHeader("Accept-Encoding", "gzip");
    }

    public static AndroidHttpClient newInstance(String string) {
        return AndroidHttpClient.newInstance(string, null);
    }

    public static AndroidHttpClient newInstance(String string, Context context) {
        context = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled((HttpParams)context, (boolean)false);
        HttpConnectionParams.setConnectionTimeout((HttpParams)context, (int)60000);
        HttpConnectionParams.setSoTimeout((HttpParams)context, (int)60000);
        HttpConnectionParams.setSocketBufferSize((HttpParams)context, (int)8192);
        ConnManagerParams.setMaxTotalConnections((HttpParams)context, (int)60);
        ConnPerRouteBean connPerRouteBean = new ConnPerRouteBean(20);
        connPerRouteBean.setMaxForRoute(new HttpRoute(new HttpHost("locahost", 80)), 20);
        ConnManagerParams.setMaxConnectionsPerRoute((HttpParams)context, (ConnPerRoute)connPerRouteBean);
        HttpClientParams.setRedirecting((HttpParams)context, (boolean)false);
        HttpProtocolParams.setUserAgent((HttpParams)context, (String)string);
        string = new SchemeRegistry();
        string.register(new Scheme("http", (SocketFactory)PlainSocketFactory.getSocketFactory(), 80));
        string.register(new Scheme("https", (SocketFactory)SSLSocketFactory.getSocketFactory(), 443));
        return new AndroidHttpClient((ClientConnectionManager)new ThreadSafeClientConnManager((HttpParams)context, (SchemeRegistry)string), (HttpParams)context);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static String toCurl(HttpUriRequest var0, boolean var1_1) throws IOException {
        block8: {
            var6_2 = new StringBuilder();
            var6_2.append("curl ");
            var5_3 = var0 /* !! */ .getAllHeaders();
            var3_4 = ((Header[])var5_3).length;
            var2_5 = 0;
            block0: while (true) {
                if (var2_5 >= var3_4) {
                    var4_6 = var5_3 = var0 /* !! */ .getURI();
                    if (var0 /* !! */  instanceof RequestWrapper) {
                        var7_7 = ((RequestWrapper)var0 /* !! */ ).getOriginal();
                        var4_6 = var5_3;
                        if (var7_7 instanceof HttpUriRequest) {
                            var4_6 = ((HttpUriRequest)var7_7).getURI();
                        }
                    }
                    var6_2.append("\"");
                    var6_2.append(var4_6);
                    var6_2.append("\"");
                    if (var0 /* !! */  instanceof HttpEntityEnclosingRequest && (var0 /* !! */  = ((HttpEntityEnclosingRequest)var0 /* !! */ ).getEntity()) != null && var0 /* !! */ .isRepeatable()) {
                        if (var0 /* !! */ .getContentLength() >= 1024L) break block8;
                        var4_6 = new ByteArrayOutputStream();
                        var0 /* !! */ .writeTo((OutputStream)var4_6);
                        var0 /* !! */  = var4_6.toString();
                        var6_2.append(" --data-ascii \"").append((String)var0 /* !! */ ).append("\"");
                    }
lbl28:
                    // 4 sources

                    return var6_2.toString();
                }
                var4_6 = var5_3[var2_5];
                if (var1_1 || !var4_6.getName().equals("Authorization") && !var4_6.getName().equals("Cookie")) break;
lbl32:
                // 2 sources

                while (true) {
                    ++var2_5;
                    continue block0;
                    break;
                }
                break;
            }
            var6_2.append("--header \"");
            var6_2.append(var4_6.toString().trim());
            var6_2.append("\" ");
            ** while (true)
        }
        var6_2.append(" [TOO MUCH DATA TO INCLUDE]");
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return;
        }
        this.delegate.addRequestInterceptor(httpRequestInterceptor, this.delegate.getRequestInterceptorCount());
    }

    /*
     * Enabled force condition propagation
     */
    public void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return;
        }
        this.delegate.addResponseInterceptor(httpResponseInterceptor, this.delegate.getResponseInterceptorCount());
    }

    public void clearCookies() {
        if (this.delegate != null) {
            this.delegate.setCookieStore(null);
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

    public void enableCurlLogging(String string, int n) {
        if (string == null) {
            throw new NullPointerException("name");
        }
        if (n < 2 || n > 7) {
            throw new IllegalArgumentException("Level is out of range [2..7]");
        }
        this.curlConfiguration = new LoggingConfiguration(string, n, null);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return (T)this.delegate.execute(httpHost, httpRequest, responseHandler);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return (T)this.delegate.execute(httpHost, httpRequest, responseHandler, httpContext);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return (T)this.delegate.execute(httpUriRequest, responseHandler);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return (T)this.delegate.execute(httpUriRequest, responseHandler, httpContext);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return this.delegate.execute(httpHost, httpRequest);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        return this.delegate.execute(httpHost, httpRequest, httpContext);
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException {
        return this.delegate.execute(httpUriRequest);
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return this.delegate.execute(httpUriRequest, httpContext);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mLeakedException != null) {
            Log.e((String)TAG, (String)"Leak found", (Throwable)this.mLeakedException);
            this.mLeakedException = null;
        }
    }

    public ClientConnectionManager getConnectionManager() {
        return this.delegate.getConnectionManager();
    }

    /*
     * Enabled force condition propagation
     */
    public CookieStore getCookies() {
        if (this.delegate == null) return null;
        return this.delegate.getCookieStore();
    }

    public HttpParams getParams() {
        return this.delegate.getParams();
    }

    public boolean isLoadOwnCookies() {
        return this.mIsLoadCookies;
    }

    public void loadCookies(CookieStore cookieStore) {
        this.mIsLoadCookies = true;
        this.delegate.setCookieStore(cookieStore);
    }

    /*
     * Enabled force condition propagation
     */
    public void removeRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return;
        }
        this.delegate.removeRequestInterceptorByClass(httpRequestInterceptor.getClass());
    }

    /*
     * Enabled force condition propagation
     */
    public void removeResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return;
        }
        this.delegate.removeResponseInterceptorByClass(httpResponseInterceptor.getClass());
    }

    public void useCmwapConnection() {
        HttpHost httpHost = new HttpHost("10.0.0.172", 80, "http");
        this.delegate.getParams().setParameter("http.route.default-proxy", (Object)httpHost);
    }

    public void useDefaultConnection() {
        this.delegate.getParams().removeParameter("http.route.default-proxy");
    }
}
