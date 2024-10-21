package com.uc.paymentsdk.network;

import android.content.Context;
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
import org.apache.http.protocol.HttpContext;

public final class AndroidHttpClient implements HttpClient {
   public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 256L;
   private static final String TAG = "AndroidHttpClient";
   private static final HttpRequestInterceptor sThreadCheckInterceptor = new AndroidHttpClient$1();
   private volatile AndroidHttpClient$LoggingConfiguration curlConfiguration;
   private final DefaultHttpClient delegate;
   private boolean mIsLoadCookies = false;
   private RuntimeException mLeakedException = new IllegalStateException("AndroidHttpClient created and never closed");

   private AndroidHttpClient(ClientConnectionManager var1, HttpParams var2) {
      super();
      this.delegate = new AndroidHttpClient$2(this, var1, var2);
   }

   // $FF: synthetic method
   static AndroidHttpClient$LoggingConfiguration access$0(AndroidHttpClient var0) {
      return var0.curlConfiguration;
   }

   // $FF: synthetic method
   static HttpRequestInterceptor access$1() {
      return sThreadCheckInterceptor;
   }

   public static AbstractHttpEntity getCompressedEntity(byte[] var0) throws IOException {
      ByteArrayEntity var3;
      if ((long)var0.length < getMinGzipSize()) {
         var3 = new ByteArrayEntity(var0);
      } else {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         GZIPOutputStream var2 = new GZIPOutputStream(var1);
         var2.write(var0);
         var2.close();
         var3 = new ByteArrayEntity(var1.toByteArray());
         var3.setContentEncoding("gzip");
      }

      return var3;
   }

   public static long getMinGzipSize() {
      return DEFAULT_SYNC_MIN_GZIP_BYTES;
   }

   public static InputStream getUngzippedContent(HttpEntity var0) throws IOException {
      InputStream var1 = var0.getContent();
      Object var3;
      if (var1 == null) {
         var3 = var1;
      } else {
         Header var4 = var0.getContentEncoding();
         if (var4 == null) {
            var3 = var1;
         } else {
            String var2 = var4.getValue();
            if (var2 == null) {
               var3 = var1;
            } else {
               var3 = var1;
               if (var2.contains("gzip")) {
                  var3 = new GZIPInputStream(var1);
               }
            }
         }
      }

      return (InputStream)var3;
   }

   public static void modifyRequestContentType(HttpRequest var0, String var1) {
      var0.addHeader("Content-Type", var1);
   }

   public static void modifyRequestToAcceptGzipResponse(HttpRequest var0) {
      var0.addHeader("Accept-Encoding", "gzip");
   }

   public static AndroidHttpClient newInstance(String var0) {
      return newInstance(var0, (Context)null);
   }

   public static AndroidHttpClient newInstance(String var0, Context var1) {
      BasicHttpParams var4 = new BasicHttpParams();
      HttpConnectionParams.setStaleCheckingEnabled(var4, false);
      HttpConnectionParams.setConnectionTimeout(var4, 60000);
      HttpConnectionParams.setSoTimeout(var4, 60000);
      HttpConnectionParams.setSocketBufferSize(var4, 8192);
      ConnManagerParams.setMaxTotalConnections(var4, 60);
      ConnPerRouteBean var2 = new ConnPerRouteBean(20);
      var2.setMaxForRoute(new HttpRoute(new HttpHost("locahost", 80)), 20);
      ConnManagerParams.setMaxConnectionsPerRoute(var4, var2);
      HttpClientParams.setRedirecting(var4, false);
      HttpProtocolParams.setUserAgent(var4, var0);
      SchemeRegistry var3 = new SchemeRegistry();
      var3.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      var3.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      return new AndroidHttpClient(new ThreadSafeClientConnManager(var4, var3), var4);
   }

   private static String toCurl(HttpUriRequest var0, boolean var1) throws IOException {
      StringBuilder var6 = new StringBuilder();
      var6.append("curl ");
      Header[] var5 = var0.getAllHeaders();
      int var3 = var5.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         Header var4 = var5[var2];
         if (var1 || !var4.getName().equals("Authorization") && !var4.getName().equals("Cookie")) {
            var6.append("--header \"");
            var6.append(var4.toString().trim());
            var6.append("\" ");
         }
      }

      URI var11 = var0.getURI();
      URI var10 = var11;
      if (var0 instanceof RequestWrapper) {
         HttpRequest var7 = ((RequestWrapper)var0).getOriginal();
         var10 = var11;
         if (var7 instanceof HttpUriRequest) {
            var10 = ((HttpUriRequest)var7).getURI();
         }
      }

      var6.append("\"");
      var6.append(var10);
      var6.append("\"");
      if (var0 instanceof HttpEntityEnclosingRequest) {
         HttpEntity var8 = ((HttpEntityEnclosingRequest)var0).getEntity();
         if (var8 != null && var8.isRepeatable()) {
            if (var8.getContentLength() < 1024L) {
               ByteArrayOutputStream var12 = new ByteArrayOutputStream();
               var8.writeTo(var12);
               String var9 = var12.toString();
               var6.append(" --data-ascii \"").append(var9).append("\"");
            } else {
               var6.append(" [TOO MUCH DATA TO INCLUDE]");
            }
         }
      }

      return var6.toString();
   }

   public void addRequestInterceptor(HttpRequestInterceptor var1) {
      if (var1 != null) {
         this.delegate.addRequestInterceptor(var1, this.delegate.getRequestInterceptorCount());
      }

   }

   public void addResponseInterceptor(HttpResponseInterceptor var1) {
      if (var1 != null) {
         this.delegate.addResponseInterceptor(var1, this.delegate.getResponseInterceptorCount());
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

   public void enableCurlLogging(String var1, int var2) {
      if (var1 == null) {
         throw new NullPointerException("name");
      } else if (var2 >= 2 && var2 <= 7) {
         this.curlConfiguration = new AndroidHttpClient$LoggingConfiguration(var1, var2, (AndroidHttpClient$LoggingConfiguration)null);
      } else {
         throw new IllegalArgumentException("Level is out of range [2..7]");
      }
   }

   public Object execute(HttpHost var1, HttpRequest var2, ResponseHandler var3) throws IOException, ClientProtocolException {
      return this.delegate.execute(var1, var2, var3);
   }

   public Object execute(HttpHost var1, HttpRequest var2, ResponseHandler var3, HttpContext var4) throws IOException, ClientProtocolException {
      return this.delegate.execute(var1, var2, var3, var4);
   }

   public Object execute(HttpUriRequest var1, ResponseHandler var2) throws IOException, ClientProtocolException {
      return this.delegate.execute(var1, var2);
   }

   public Object execute(HttpUriRequest var1, ResponseHandler var2, HttpContext var3) throws IOException, ClientProtocolException {
      return this.delegate.execute(var1, var2, var3);
   }

   public HttpResponse execute(HttpHost var1, HttpRequest var2) throws IOException {
      return this.delegate.execute(var1, var2);
   }

   public HttpResponse execute(HttpHost var1, HttpRequest var2, HttpContext var3) throws IOException {
      return this.delegate.execute(var1, var2, var3);
   }

   public HttpResponse execute(HttpUriRequest var1) throws IOException {
      return this.delegate.execute(var1);
   }

   public HttpResponse execute(HttpUriRequest var1, HttpContext var2) throws IOException {
      return this.delegate.execute(var1, var2);
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
      CookieStore var1;
      if (this.delegate != null) {
         var1 = this.delegate.getCookieStore();
      } else {
         var1 = null;
      }

      return var1;
   }

   public HttpParams getParams() {
      return this.delegate.getParams();
   }

   public boolean isLoadOwnCookies() {
      return this.mIsLoadCookies;
   }

   public void loadCookies(CookieStore var1) {
      this.mIsLoadCookies = true;
      this.delegate.setCookieStore(var1);
   }

   public void removeRequestInterceptor(HttpRequestInterceptor var1) {
      if (var1 != null) {
         this.delegate.removeRequestInterceptorByClass(var1.getClass());
      }

   }

   public void removeResponseInterceptor(HttpResponseInterceptor var1) {
      if (var1 != null) {
         this.delegate.removeResponseInterceptorByClass(var1.getClass());
      }

   }

   public void useCmwapConnection() {
      HttpHost var1 = new HttpHost("10.0.0.172", 80, "http");
      this.delegate.getParams().setParameter("http.route.default-proxy", var1);
   }

   public void useDefaultConnection() {
      this.delegate.getParams().removeParameter("http.route.default-proxy");
   }
}
