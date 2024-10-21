/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.network.chain.SyncSmsInfoHandler
 */
package com.uc.paymentsdk.network.chain;

import com.uc.paymentsdk.network.chain.SyncSmsInfoHandler;

class SyncSmsInfoHandler.1
implements Runnable {
    final SyncSmsInfoHandler this$0;

    SyncSmsInfoHandler.1(SyncSmsInfoHandler syncSmsInfoHandler) {
        this.this$0 = syncSmsInfoHandler;
    }

    static /* synthetic */ SyncSmsInfoHandler access$0(SyncSmsInfoHandler.1 var0) {
        return var0.this$0;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        var1_1 = SyncSmsInfoHandler.access$0((SyncSmsInfoHandler)this.this$0);
        // MONITORENTER : var1_1
        try {
            SyncSmsInfoHandler.access$0((SyncSmsInfoHandler)this.this$0).wait();
            // MONITOREXIT : var1_1
        }
        catch (InterruptedException var2_2) {
            var2_2.printStackTrace();
            ** continue;
        }
lbl9:
        // 2 sources

        while (true) {
            this.this$0.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
            return;
        }
    }
}
