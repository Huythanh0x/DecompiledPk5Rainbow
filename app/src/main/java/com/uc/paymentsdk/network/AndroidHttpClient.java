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
  public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 256L;
  
  private static final String TAG = "AndroidHttpClient";
  
  private static final HttpRequestInterceptor sThreadCheckInterceptor = new HttpRequestInterceptor() {
      public void process(HttpRequest param1HttpRequest, HttpContext param1HttpContext) {
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper())
          throw new RuntimeException("This thread forbids HTTP requests"); 
      }
    };
  
  private volatile LoggingConfiguration curlConfiguration;
  
  private final DefaultHttpClient delegate;
  
  private boolean mIsLoadCookies = false;
  
  private RuntimeException mLeakedException = new IllegalStateException("AndroidHttpClient created and never closed");
  
  private AndroidHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams) {
    this.delegate = new DefaultHttpClient(paramClientConnectionManager, paramHttpParams) {
        final AndroidHttpClient this$0;
        
        protected HttpContext createHttpContext() {
          BasicHttpContext basicHttpContext = new BasicHttpContext();
          basicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
          basicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
          basicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
          basicHttpContext.setAttribute("http.cookie-store", getCookieStore());
          return (HttpContext)basicHttpContext;
        }
        
        protected BasicHttpProcessor createHttpProcessor() {
          BasicHttpProcessor basicHttpProcessor = super.createHttpProcessor();
          basicHttpProcessor.addRequestInterceptor(AndroidHttpClient.sThreadCheckInterceptor);
          basicHttpProcessor.addRequestInterceptor(new AndroidHttpClient.CurlLogger(null));
          return basicHttpProcessor;
        }
      };
  }
  
  public static AbstractHttpEntity getCompressedEntity(byte[] paramArrayOfbyte) throws IOException {
    if (paramArrayOfbyte.length < getMinGzipSize())
      return (AbstractHttpEntity)new ByteArrayEntity(paramArrayOfbyte); 
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
    gZIPOutputStream.write(paramArrayOfbyte);
    gZIPOutputStream.close();
    ByteArrayEntity byteArrayEntity = new ByteArrayEntity(byteArrayOutputStream.toByteArray());
    byteArrayEntity.setContentEncoding("gzip");
    return (AbstractHttpEntity)byteArrayEntity;
  }
  
  public static long getMinGzipSize() {
    return DEFAULT_SYNC_MIN_GZIP_BYTES;
  }
  
  public static InputStream getUngzippedContent(HttpEntity paramHttpEntity) throws IOException {
    InputStream inputStream2 = paramHttpEntity.getContent();
    if (inputStream2 == null)
      return inputStream2; 
    Header header = paramHttpEntity.getContentEncoding();
    if (header == null)
      return inputStream2; 
    String str = header.getValue();
    if (str == null)
      return inputStream2; 
    InputStream inputStream1 = inputStream2;
    if (str.contains("gzip"))
      inputStream1 = new GZIPInputStream(inputStream2); 
    return inputStream1;
  }
  
  public static void modifyRequestContentType(HttpRequest paramHttpRequest, String paramString) {
    paramHttpRequest.addHeader("Content-Type", paramString);
  }
  
  public static void modifyRequestToAcceptGzipResponse(HttpRequest paramHttpRequest) {
    paramHttpRequest.addHeader("Accept-Encoding", "gzip");
  }
  
  public static AndroidHttpClient newInstance(String paramString) {
    return newInstance(paramString, null);
  }
  
  public static AndroidHttpClient newInstance(String paramString, Context paramContext) {
    BasicHttpParams basicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled((HttpParams)basicHttpParams, false);
    HttpConnectionParams.setConnectionTimeout((HttpParams)basicHttpParams, 60000);
    HttpConnectionParams.setSoTimeout((HttpParams)basicHttpParams, 60000);
    HttpConnectionParams.setSocketBufferSize((HttpParams)basicHttpParams, 8192);
    ConnManagerParams.setMaxTotalConnections((HttpParams)basicHttpParams, 60);
    ConnPerRouteBean connPerRouteBean = new ConnPerRouteBean(20);
    connPerRouteBean.setMaxForRoute(new HttpRoute(new HttpHost("locahost", 80)), 20);
    ConnManagerParams.setMaxConnectionsPerRoute((HttpParams)basicHttpParams, (ConnPerRoute)connPerRouteBean);
    HttpClientParams.setRedirecting((HttpParams)basicHttpParams, false);
    HttpProtocolParams.setUserAgent((HttpParams)basicHttpParams, paramString);
    SchemeRegistry schemeRegistry = new SchemeRegistry();
    schemeRegistry.register(new Scheme("http", (SocketFactory)PlainSocketFactory.getSocketFactory(), 80));
    schemeRegistry.register(new Scheme("https", (SocketFactory)SSLSocketFactory.getSocketFactory(), 443));
    return new AndroidHttpClient((ClientConnectionManager)new ThreadSafeClientConnManager((HttpParams)basicHttpParams, schemeRegistry), (HttpParams)basicHttpParams);
  }
  
  private static String toCurl(HttpUriRequest paramHttpUriRequest, boolean paramBoolean) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("curl ");
    Header[] arrayOfHeader = paramHttpUriRequest.getAllHeaders();
    int i = arrayOfHeader.length;
    byte b = 0;
    while (true) {
      URI uRI;
      if (b >= i) {
        uRI = paramHttpUriRequest.getURI();
        URI uRI1 = uRI;
        if (paramHttpUriRequest instanceof RequestWrapper) {
          HttpRequest httpRequest = ((RequestWrapper)paramHttpUriRequest).getOriginal();
          uRI1 = uRI;
          if (httpRequest instanceof HttpUriRequest)
            uRI1 = ((HttpUriRequest)httpRequest).getURI(); 
        } 
        stringBuilder.append("\"");
        stringBuilder.append(uRI1);
        stringBuilder.append("\"");
        if (paramHttpUriRequest instanceof HttpEntityEnclosingRequest) {
          HttpEntity httpEntity = ((HttpEntityEnclosingRequest)paramHttpUriRequest).getEntity();
          if (httpEntity != null && httpEntity.isRepeatable()) {
            if (httpEntity.getContentLength() < 1024L) {
              ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
              httpEntity.writeTo(byteArrayOutputStream);
              String str = byteArrayOutputStream.toString();
              stringBuilder.append(" --data-ascii \"").append(str).append("\"");
              return stringBuilder.toString();
            } 
          } else {
            return stringBuilder.toString();
          } 
        } else {
          return stringBuilder.toString();
        } 
      } else {
        URI uRI1 = uRI[b];
        if (paramBoolean || (!uRI1.getName().equals("Authorization") && !uRI1.getName().equals("Cookie"))) {
          stringBuilder.append("--header \"");
          stringBuilder.append(uRI1.toString().trim());
          stringBuilder.append("\" ");
        } 
        b++;
        continue;
      } 
      stringBuilder.append(" [TOO MUCH DATA TO INCLUDE]");
      return stringBuilder.toString();
    } 
  }
  
  public void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor) {
    if (paramHttpRequestInterceptor != null)
      this.delegate.addRequestInterceptor(paramHttpRequestInterceptor, this.delegate.getRequestInterceptorCount()); 
  }
  
  public void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor) {
    if (paramHttpResponseInterceptor != null)
      this.delegate.addResponseInterceptor(paramHttpResponseInterceptor, this.delegate.getResponseInterceptorCount()); 
  }
  
  public void clearCookies() {
    if (this.delegate != null)
      this.delegate.setCookieStore(null); 
  }
  
  public void close() {
    if (this.mLeakedException != null) {
      getConnectionManager().shutdown();
      this.mLeakedException = null;
    } 
  }
  
  public void disableCurlLogging() {
    this.curlConfiguration = null;
  }
  
  public void enableCurlLogging(String paramString, int paramInt) {
    if (paramString == null)
      throw new NullPointerException("name"); 
    if (paramInt < 2 || paramInt > 7)
      throw new IllegalArgumentException("Level is out of range [2..7]"); 
    this.curlConfiguration = new LoggingConfiguration(paramString, paramInt, null);
  }
  
  public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler) throws IOException, ClientProtocolException {
    return (T)this.delegate.execute(paramHttpHost, paramHttpRequest, paramResponseHandler);
  }
  
  public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext) throws IOException, ClientProtocolException {
    return (T)this.delegate.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
  }
  
  public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler) throws IOException, ClientProtocolException {
    return (T)this.delegate.execute(paramHttpUriRequest, paramResponseHandler);
  }
  
  public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext) throws IOException, ClientProtocolException {
    return (T)this.delegate.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext);
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
  
  protected void finalize() throws Throwable {
    super.finalize();
    if (this.mLeakedException != null) {
      Log.e("AndroidHttpClient", "Leak found", this.mLeakedException);
      this.mLeakedException = null;
    } 
  }
  
  public ClientConnectionManager getConnectionManager() {
    return this.delegate.getConnectionManager();
  }
  
  public CookieStore getCookies() {
    return (this.delegate != null) ? this.delegate.getCookieStore() : null;
  }
  
  public HttpParams getParams() {
    return this.delegate.getParams();
  }
  
  public boolean isLoadOwnCookies() {
    return this.mIsLoadCookies;
  }
  
  public void loadCookies(CookieStore paramCookieStore) {
    this.mIsLoadCookies = true;
    this.delegate.setCookieStore(paramCookieStore);
  }
  
  public void removeRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor) {
    if (paramHttpRequestInterceptor != null)
      this.delegate.removeRequestInterceptorByClass(paramHttpRequestInterceptor.getClass()); 
  }
  
  public void removeResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor) {
    if (paramHttpResponseInterceptor != null)
      this.delegate.removeResponseInterceptorByClass(paramHttpResponseInterceptor.getClass()); 
  }
  
  public void useCmwapConnection() {
    HttpHost httpHost = new HttpHost("10.0.0.172", 80, "http");
    this.delegate.getParams().setParameter("http.route.default-proxy", httpHost);
  }
  
  public void useDefaultConnection() {
    this.delegate.getParams().removeParameter("http.route.default-proxy");
  }
  
  private class CurlLogger implements HttpRequestInterceptor {
    final AndroidHttpClient this$0;
    
    private CurlLogger() {}
    
    public void process(HttpRequest param1HttpRequest, HttpContext param1HttpContext) throws HttpException, IOException {
      AndroidHttpClient.LoggingConfiguration loggingConfiguration = AndroidHttpClient.this.curlConfiguration;
      if (loggingConfiguration != null && loggingConfiguration.isLoggable() && param1HttpRequest instanceof HttpUriRequest)
        loggingConfiguration.println(((HttpUriRequest)param1HttpRequest).getURI().getPath()); 
    }
  }
  
  private static class LoggingConfiguration {
    private final int level;
    
    private final String tag;
    
    private LoggingConfiguration(String param1String, int param1Int) {
      this.tag = param1String;
      this.level = param1Int;
    }
    
    private boolean isLoggable() {
      return Log.isLoggable(this.tag, this.level);
    }
    
    private void println(String param1String) {
      Log.println(this.level, this.tag, param1String);
    }
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/network/AndroidHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */