package com.uc.paymentsdk.network.chain;

import android.content.Context;

public class HandlerProxy extends Handler {
   private Handler handler;

   public HandlerProxy(Context var1) {
      super(var1);
      this.handler = new SyncSmsInfoHandler(var1);
   }

   public HandlerProxy(Context var1, Handler$OnFinishListener var2) {
      super(var1);
      this.handler = new SyncSmsInfoHandler(var1, var2);
   }

   public void handleRequest() {
      this.handler.handleRequest();
   }
}
