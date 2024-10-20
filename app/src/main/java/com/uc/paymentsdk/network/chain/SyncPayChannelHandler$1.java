package com.uc.paymentsdk.network.chain;

class SyncPayChannelHandler$1 implements Runnable {
    final SyncPayChannelHandler this$0;
    
    SyncPayChannelHandler$1(final SyncPayChannelHandler this$0) {
        this.this$0 = this$0;
        super();
    }
    
    static /* synthetic */ SyncPayChannelHandler access$0(final SyncPayChannelHandler$1 runnable) {
        return runnable.this$0;
    }
    
    @Override
    public void run() {
        synchronized (SyncPayChannelHandler.access$0(this.this$0)) {
            while (true) {
                try {
                    SyncPayChannelHandler.access$0(this.this$0).wait();
                    monitorexit(SyncPayChannelHandler.access$0(this.this$0));
                    this.this$0.mHandler.post((Runnable)new Runnable(this) {
                        final SyncPayChannelHandler$1 this$1;
                        
                        SyncPayChannelHandler$1$1(final SyncPayChannelHandler$1 this$1) {
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