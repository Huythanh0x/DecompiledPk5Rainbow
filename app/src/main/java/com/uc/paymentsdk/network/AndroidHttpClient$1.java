package com.uc.paymentsdk.network;

import android.os.Looper;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

class AndroidHttpClient$1 implements HttpRequestInterceptor {
   AndroidHttpClient$1() {
      super();
   }

   public void process(HttpRequest var1, HttpContext var2) {
      if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
         throw new RuntimeException("This thread forbids HTTP requests");
      }
   }
}
