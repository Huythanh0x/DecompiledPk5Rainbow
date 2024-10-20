package com.uc.paymentsdk.network.chain;

class SyncChargeChannelHandler$1$1 implements Runnable {
   final SyncChargeChannelHandler$1 this$1;

   SyncChargeChannelHandler$1$1(SyncChargeChannelHandler$1 var1) {
      super();
      this.this$1 = var1;
   }

   public void run() {
      SyncChargeChannelHandler$1.access$0(this.this$1).handleRequest();
   }
}
