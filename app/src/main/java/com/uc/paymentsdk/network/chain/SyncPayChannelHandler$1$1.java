package com.uc.paymentsdk.network.chain;

class SyncPayChannelHandler$1$1 implements Runnable {
   final SyncPayChannelHandler$1 this$1;

   SyncPayChannelHandler$1$1(SyncPayChannelHandler$1 var1) {
      super();
      this.this$1 = var1;
   }

   public void run() {
      SyncPayChannelHandler$1.access$0(this.this$1).handleRequest();
   }
}
