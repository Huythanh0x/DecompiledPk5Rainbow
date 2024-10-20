package com.uc.paymentsdk.network.chain;

import android.content.Context;
import android.text.TextUtils;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.network.ApiTask$TaskHandler;
import com.uc.paymentsdk.network.JSONParser;
import com.uc.paymentsdk.util.Utils;
import org.apache.http.HttpResponse;
import org.json.JSONException;

public class SyncChargeChannelHandler extends Handler implements ApiTask$TaskHandler {
   private static int sStatus;
   private final Integer LOCK = 0;
   private Handler$OnFinishListener mOnFinishListener;

   public SyncChargeChannelHandler(Context var1) {
      super(var1);
   }

   public SyncChargeChannelHandler(Context var1, Handler$OnFinishListener var2) {
      super(var1);
      this.mOnFinishListener = var2;
   }

   // $FF: synthetic method
   static Integer access$0(SyncChargeChannelHandler var0) {
      return var0.LOCK;
   }

   public static void init() {
      sStatus = 0;
   }

   public void handleRequest() {
      switch (sStatus) {
         case 0:
            sStatus = 1;
            Api.syncChargeChannel(this.mContext, this);
            break;
         case 1:
            (new Thread(new SyncChargeChannelHandler$1(this))).start();
            break;
         case 2:
            if (this.getSuccessor() == null) {
               if (this.mOnFinishListener != null) {
                  this.mOnFinishListener.onFinish();
               }
            } else {
               this.getSuccessor().handleRequest();
            }
      }

   }

   public void onError(int param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public Object onPreHandle(int var1, HttpResponse var2) {
      String var4 = Utils.getBodyString(var1, var2);
      String[] var5;
      if (TextUtils.isEmpty(var4)) {
         var5 = null;
      } else {
         try {
            var5 = JSONParser.parseChargeChannel(var4);
         } catch (JSONException var3) {
            var5 = null;
         }
      }

      return var5;
   }

   public void onSuccess(int param1, Object param2) {
      // $FF: Couldn't be decompiled
   }
}
