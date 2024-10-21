package com.uc.paymentsdk.network;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class AndroidHttpClient$CurlLogger implements HttpRequestInterceptor {
   final AndroidHttpClient this$0;

   private AndroidHttpClient$CurlLogger(AndroidHttpClient var1) {
      super();
      this.this$0 = var1;
   }

   // $FF: synthetic method
   AndroidHttpClient$CurlLogger(AndroidHttpClient var1, AndroidHttpClient$CurlLogger var2) {
      this(var1);
   }

   public void process(HttpRequest var1, HttpContext var2) throws HttpException, IOException {
      AndroidHttpClient$LoggingConfiguration var3 = AndroidHttpClient.access$0(this.this$0);
      if (var3 != null && AndroidHttpClient$LoggingConfiguration.access$0(var3) && var1 instanceof HttpUriRequest) {
         AndroidHttpClient$LoggingConfiguration.access$1(var3, ((HttpUriRequest)var1).getURI().getPath());
      }

   }
}
