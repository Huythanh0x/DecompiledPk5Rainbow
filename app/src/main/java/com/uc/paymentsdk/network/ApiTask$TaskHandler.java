package com.uc.paymentsdk.network;

import org.apache.http.HttpResponse;

public interface ApiTask$TaskHandler {
   void onError(int var1, int var2);

   Object onPreHandle(int var1, HttpResponse var2);

   void onSuccess(int var1, Object var2);
}
