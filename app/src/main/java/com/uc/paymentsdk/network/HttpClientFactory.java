package com.uc.paymentsdk.network;

import java.util.WeakHashMap;
import org.apache.http.params.HttpProtocolParams;

public class HttpClientFactory {
   private static final int DEFAULT_SIZE = 2;
   private static final String SDK_CLIENT = "sdk";
   private static HttpClientFactory mInstance;
   private WeakHashMap mHttpClientMap;

   private HttpClientFactory() {
      // $FF: Couldn't be decompiled
   }

   public static HttpClientFactory get() {
      if (mInstance == null) {
         mInstance = new HttpClientFactory();
      }

      return mInstance;
   }

   public void close() {
      synchronized(this){}

      Throwable var10000;
      label120: {
         boolean var10001;
         label119: {
            AndroidHttpClient var1;
            try {
               if (!this.mHttpClientMap.containsKey("sdk")) {
                  break label119;
               }

               var1 = (AndroidHttpClient)this.mHttpClientMap.get("sdk");
            } catch (Throwable var13) {
               var10000 = var13;
               var10001 = false;
               break label120;
            }

            if (var1 != null) {
               try {
                  var1.close();
               } catch (Throwable var12) {
                  var10000 = var12;
                  var10001 = false;
                  break label120;
               }
            }
         }

         label111:
         try {
            this.mHttpClientMap.clear();
            mInstance = null;
            return;
         } catch (Throwable var11) {
            var10000 = var11;
            var10001 = false;
            break label111;
         }
      }

      Throwable var14 = var10000;
      throw var14;
   }

   public AndroidHttpClient getSDKHttpClient(String var1) {
      synchronized(this){}

      Throwable var10000;
      label84: {
         boolean var10001;
         AndroidHttpClient var9;
         label83: {
            AndroidHttpClient var2;
            try {
               if (!this.mHttpClientMap.containsKey("sdk")) {
                  break label83;
               }

               var2 = (AndroidHttpClient)this.mHttpClientMap.get("sdk");
            } catch (Throwable var8) {
               var10000 = var8;
               var10001 = false;
               break label84;
            }

            if (var2 != null) {
               var9 = var2;
               return var9;
            }
         }

         label77:
         try {
            var9 = AndroidHttpClient.newInstance(var1);
            this.mHttpClientMap.put("sdk", var9);
            return var9;
         } catch (Throwable var7) {
            var10000 = var7;
            var10001 = false;
            break label77;
         }
      }

      Throwable var10 = var10000;
      throw var10;
   }

   public void updateUserAgent(String var1) {
      AndroidHttpClient var2 = (AndroidHttpClient)this.mHttpClientMap.get("sdk");
      if (var2 != null) {
         HttpProtocolParams.setUserAgent(var2.getParams(), var1);
      }

   }
}
