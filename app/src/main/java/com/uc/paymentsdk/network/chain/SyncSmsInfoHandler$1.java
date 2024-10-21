package com.uc.paymentsdk.network.chain;

class SyncSmsInfoHandler$1 implements Runnable {
    final SyncSmsInfoHandler this$0;
    
    SyncSmsInfoHandler$1(final SyncSmsInfoHandler this$0) {
        this.this$0 = this$0;
        super();
    }
    
    static /* synthetic */ SyncSmsInfoHandler access$0(final SyncSmsInfoHandler$1 runnable) {
        return runnable.this$0;
    }
    
    @Override
    public void run() {
        synchronized (SyncSmsInfoHandler.access$0(this.this$0)) {
            while (true) {
                try {
                    SyncSmsInfoHandler.access$0(this.this$0).wait();
                    monitorexit(SyncSmsInfoHandler.access$0(this.this$0));
                    this.this$0.mHandler.post((Runnable)new Runnable(this) {
                        final SyncSmsInfoHandler$1 this$1;
                        
                        SyncSmsInfoHandler$1$1(final SyncSmsInfoHandler$1 this$1) {
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