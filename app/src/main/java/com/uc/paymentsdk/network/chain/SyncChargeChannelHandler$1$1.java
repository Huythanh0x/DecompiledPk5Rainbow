package com.uc.paymentsdk.network.chain;

class SyncChargeChannelHandler$1$1 implements Runnable {
    final SyncChargeChannelHandler$1 this$1;
    
    SyncChargeChannelHandler$1$1(final SyncChargeChannelHandler$1 this$1) {
        this.this$1 = this$1;
        super();
    }
    
    @Override
    public void run() {
        SyncChargeChannelHandler$1.access$0(this.this$1).handleRequest();
    }
}