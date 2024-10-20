package com.uc.paymentsdk.network.chain;

class SyncChargeChannelHandler$1 implements Runnable {
    final SyncChargeChannelHandler this$0;
    
    SyncChargeChannelHandler$1(final SyncChargeChannelHandler this$0) {
        this.this$0 = this$0;
        super();
    }
    
    static /* synthetic */ SyncChargeChannelHandler access$0(final SyncChargeChannelHandler$1 runnable) {
        return runnable.this$0;
    }
    
    @Override
    public void run() {
        synchronized (SyncChargeChannelHandler.access$0(this.this$0)) {
            while (true) {
                try {
                    SyncChargeChannelHandler.access$0(this.this$0).wait();
                    monitorexit(SyncChargeChannelHandler.access$0(this.this$0));
                    this.this$0.mHandler.post((Runnable)new Runnable(this) {
                        final SyncChargeChannelHandler$1 this$1;
                        
                        SyncChargeChannelHandler$1$1(final SyncChargeChannelHandler$1 this$1) {
                            this.this$1 = this$1;
                            super();
                        }
                        
                        @Override
                        public void run() {
                            this$0.handleRequest();
                        }
                    });
                }
                catch (final InterruptedException ex) {
                    ex.printStackTrace();
                    continue;
                }
                break;
            }
        }
    }
}