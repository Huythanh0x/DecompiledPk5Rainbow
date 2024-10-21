package com.uc.paymentsdk.network.AndroidHttpClient;
import org.apache.http.client.HttpClient;
import com.uc.paymentsdk.network.AndroidHttpClient$1;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import java.lang.Object;
import java.lang.IllegalStateException;
import java.lang.String;
import com.uc.paymentsdk.network.AndroidHttpClient$2;
import com.uc.paymentsdk.network.AndroidHttpClient$LoggingConfiguration;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import java.io.InputStream;
import org.apache.http.Header;
import java.lang.CharSequence;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpRequest;
import android.content.Context;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.client.methods.HttpUriRequest;
import java.lang.StringBuilder;
import java.net.URI;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.CookieStore;
import java.lang.NullPointerException;
import java.lang.IllegalArgumentException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.protocol.HttpContext;
import org.apache.http.HttpResponse;
import java.lang.Throwable;
import android.util.Log;
import java.lang.Class;

public final class AndroidHttpClient implements HttpClient	// class@00009d from classes.dex
{
    private AndroidHttpClient$LoggingConfiguration curlConfiguration;
    private final DefaultHttpClient delegate;
    private boolean mIsLoadCookies;
    private RuntimeException mLeakedException;
    public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 0x0;
    private static final String TAG = "AndroidHttpClient";
    private static final HttpRequestInterceptor sThreadCheckInterceptor;

    static {
       AndroidHttpClient.DEFAULT_SYNC_MIN_GZIP_BYTES = 256;
       AndroidHttpClient.sThreadCheckInterceptor = new AndroidHttpClient$1();
    }
    private void AndroidHttpClient(ClientConnectionManager paramClientConnectionManager,HttpParams paramHttpParams){
       super();
       this.mIsLoadCookies = false;
       this.mLeakedException = new IllegalStateException("AndroidHttpClient created and never closed");
       this.delegate = new AndroidHttpClient$2(this, paramClientConnectionManager, paramHttpParams);
    }
    static AndroidHttpClient$LoggingConfiguration access$0(AndroidHttpClient p0){
       return p0.curlConfiguration;
    }
    static HttpRequestInterceptor access$1(){
       return AndroidHttpClient.sThreadCheckInterceptor;
    }
    public static AbstractHttpEntity getCompressedEntity(byte[] paramArrayOfByte){
       ByteArrayEntity localByteArrayEntity;
       if (((long)paramArrayOfByte.length - AndroidHttpClient.getMinGzipSize()) < 0) {
          localByteArrayEntity = new ByteArrayEntity(paramArrayOfByte);
       }else {
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
          localGZIPOutputStream.write(paramArrayOfByte);
          localGZIPOutputStream.close();
          localByteArrayEntity = new ByteArrayEntity(localByteArrayOutputStream.toByteArray());
          localByteArrayEntity.setContentEncoding("gzip");
       }
       return localByteArrayEntity;
    }
    public static long getMinGzipSize(){
       return AndroidHttpClient.DEFAULT_SYNC_MIN_GZIP_BYTES;
    }
    public static InputStream getUngzippedContent(HttpEntity paramHttpEntity){
       InputStream localObject;
       Header localHeader;
       String str;
       if ((localObject = paramHttpEntity.getContent()) == null) {
          localObject = localObject;
       }else if((localHeader = paramHttpEntity.getContentEncoding()) == null){
          localObject = localObject;
       }else if((str = localHeader.getValue()) == null){
          localObject = localObject;
       }else if(str.contains("gzip")){
          localObject = new GZIPInputStream(localObject);
          localObject = localObject;
       }
       localObject = localObject;
       return localObject;
    }
    public static void modifyRequestContentType(HttpRequest paramHttpRequest,String paramString){
       paramHttpRequest.addHeader("Content-Type", paramString);
    }
    public static void modifyRequestToAcceptGzipResponse(HttpRequest paramHttpRequest){
       paramHttpRequest.addHeader("Accept-Encoding", "gzip");
    }
    public static AndroidHttpClient newInstance(String paramString){
       AndroidHttpClient localAndroidHttpClient = AndroidHttpClient.newInstance(paramString, null);
       return localAndroidHttpClient;
    }
    public static AndroidHttpClient newInstance(String paramString,Context paramContext){
       BasicHttpParams localBasicHttpParams = new BasicHttpParams();
       HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
       HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 0xea60);
       HttpConnectionParams.setSoTimeout(localBasicHttpParams, 0xea60);
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
    private static String toCurl(HttpUriRequest paramHttpUriRequest,boolean paramBoolean){
       HttpEntity localHttpEntity;
       StringBuilder localStringBuilder = "";
       localStringBuilder = localStringBuilder+"curl ";
       Header[] allHeaders = paramHttpUriRequest.getAllHeaders();
       int len = allHeaders.length;
       int i = 0;
       while (i < len) {
          Header aheader = allHeaders[i];
          if (paramBoolean || (!aheader.getName().equals("Authorization") || aheader.getName().equals("Cookie"))) {
             localStringBuilder = localStringBuilder.append("--header \"");
             localStringBuilder = localStringBuilder.append(aheader.toString().trim());
             localStringBuilder = localStringBuilder.append("\" ");
          }
          i = i + 1;
       }
       URI aurl = paramHttpUriRequest.getURI();
       if (paramHttpUriRequest instanceof RequestWrapper) {
          HttpRequest localObject2 = paramHttpUriRequest.getOriginal();
          if (localObject2 instanceof HttpUriRequest) {
             aurl = localObject2.getURI();
          }
       }
       localStringBuilder = localStringBuilder+"\"";
       localStringBuilder = localStringBuilder+aurl;
       localStringBuilder = localStringBuilder+"\"";
       if (paramHttpUriRequest instanceof HttpEntityEnclosingRequest) {
          HttpUriRequest localObject21 = paramHttpUriRequest;
          if ((localHttpEntity = localObject21.getEntity()) != null && localHttpEntity.isRepeatable()) {
             if ((localHttpEntity.getContentLength() - 1024) < 0) {
                ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                localHttpEntity.writeTo(localByteArrayOutputStream);
                String str = localByteArrayOutputStream.toString();
                StringBuilder localStringBuilder1 = localStringBuilder+" --data-ascii \"";
                localStringBuilder1 = localStringBuilder1+str+"\"";
             }else {
                localStringBuilder = localStringBuilder+" [TOO MUCH DATA TO INCLUDE]";
             }
          }
       }
       return localStringBuilder;
    }
    public void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor){
       if (paramHttpRequestInterceptor != null) {
          this.delegate.addRequestInterceptor(paramHttpRequestInterceptor, this.delegate.getRequestInterceptorCount());
       }
       return;
    }
    public void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor){
       if (paramHttpResponseInterceptor != null) {
          this.delegate.addResponseInterceptor(paramHttpResponseInterceptor, this.delegate.getResponseInterceptorCount());
       }
       return;
    }
    public void clearCookies(){
       if (this.delegate != null) {
          this.delegate.setCookieStore(null);
       }
       return;
    }
    public void close(){
       if (this.mLeakedException != null) {
          this.getConnectionManager().shutdown();
          this.mLeakedException = null;
       }
       return;
    }
    public void disableCurlLogging(){
       this.curlConfiguration = null;
    }
    public void enableCurlLogging(String paramString,int paramInt){
       if (paramString == null) {
          throw new NullPointerException("name");
       }
       if (paramInt < 2 || paramInt > 7) {
          throw new IllegalArgumentException("Level is out of range [2..7]");
       }
       this.curlConfiguration = new AndroidHttpClient$LoggingConfiguration(paramString, paramInt, null);
       return;
    }
    public Object execute(HttpHost paramHttpHost,HttpRequest paramHttpRequest,ResponseHandler paramResponseHandler){
       return this.delegate.execute(paramHttpHost, paramHttpRequest, paramResponseHandler);
    }
    public Object execute(HttpHost paramHttpHost,HttpRequest paramHttpRequest,ResponseHandler paramResponseHandler,HttpContext paramHttpContext){
       return this.delegate.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
    }
    public Object execute(HttpUriRequest paramHttpUriRequest,ResponseHandler paramResponseHandler){
       return this.delegate.execute(paramHttpUriRequest, paramResponseHandler);
    }
    public Object execute(HttpUriRequest paramHttpUriRequest,ResponseHandler paramResponseHandler,HttpContext paramHttpContext){
       return this.delegate.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext);
    }
    public HttpResponse execute(HttpHost paramHttpHost,HttpRequest paramHttpRequest){
       return this.delegate.execute(paramHttpHost, paramHttpRequest);
    }
    public HttpResponse execute(HttpHost paramHttpHost,HttpRequest paramHttpRequest,HttpContext paramHttpContext){
       return this.delegate.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
    }
    public HttpResponse execute(HttpUriRequest paramHttpUriRequest){
       return this.delegate.execute(paramHttpUriRequest);
    }
    public HttpResponse execute(HttpUriRequest paramHttpUriRequest,HttpContext paramHttpContext){
       return this.delegate.execute(paramHttpUriRequest, paramHttpContext);
    }
    protected void finalize(){
       super.finalize();
       if (this.mLeakedException != null) {
          Log.e("AndroidHttpClient", "Leak found", this.mLeakedException);
          this.mLeakedException = null;
       }
       return;
    }
    public ClientConnectionManager getConnectionManager(){
       return this.delegate.getConnectionManager();
    }
    public CookieStore getCookies(){
       CookieStore cookieStore = (this.delegate != null)? this.delegate.getCookieStore(): null;
       return cookieStore;
    }
    public HttpParams getParams(){
       return this.delegate.getParams();
    }
    public boolean isLoadOwnCookies(){
       return this.mIsLoadCookies;
    }
    public void loadCookies(CookieStore paramCookieStore){
       this.mIsLoadCookies = true;
       this.delegate.setCookieStore(paramCookieStore);
    }
    public void removeRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor){
       if (paramHttpRequestInterceptor != null) {
          this.delegate.removeRequestInterceptorByClass(paramHttpRequestInterceptor.getClass());
       }
       return;
    }
    public void removeResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor){
       if (paramHttpResponseInterceptor != null) {
          this.delegate.removeResponseInterceptorByClass(paramHttpResponseInterceptor.getClass());
       }
       return;
    }
    public void useCmwapConnection(){
       HttpHost localHttpHost = new HttpHost("10.0.0.172", 80, "http");
       this.delegate.getParams().setParameter("http.route.default-proxy", localHttpHost);
    }
    public void useDefaultConnection(){
       this.delegate.getParams().removeParameter("http.route.default-proxy");
    }
}
