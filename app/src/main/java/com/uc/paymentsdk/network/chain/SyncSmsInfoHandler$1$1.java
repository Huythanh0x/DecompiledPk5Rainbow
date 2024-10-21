package com.uc.paymentsdk.network.chain;

class SyncSmsInfoHandler$1$1 implements Runnable {
   final SyncSmsInfoHandler$1 this$1;

   SyncSmsInfoHandler$1$1(SyncSmsInfoHandler$1 var1) {
      super();
      this.this$1 = var1;
   }

   public void run() {
      SyncSmsInfoHandler$1.access$0(this.this$1).handleRequest();
   }
}
