/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.network.chain.SyncChargeChannelHandler
 */
package com.uc.paymentsdk.network.chain;

import com.uc.paymentsdk.network.chain.SyncChargeChannelHandler;

class SyncChargeChannelHandler.1
implements Runnable {
    final SyncChargeChannelHandler this$0;

    SyncChargeChannelHandler.1(SyncChargeChannelHandler syncChargeChannelHandler) {
        this.this$0 = syncChargeChannelHandler;
    }

    static /* synthetic */ SyncChargeChannelHandler access$0(SyncChargeChannelHandler.1 var0) {
        return var0.this$0;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        var1_1 = SyncChargeChannelHandler.access$0((SyncChargeChannelHandler)this.this$0);
        // MONITORENTER : var1_1
        try {
            SyncChargeChannelHandler.access$0((SyncChargeChannelHandler)this.this$0).wait();
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
