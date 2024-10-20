/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.network.chain.SyncPayChannelHandler
 */
package com.uc.paymentsdk.network.chain;

import com.uc.paymentsdk.network.chain.SyncPayChannelHandler;

class SyncPayChannelHandler.1
implements Runnable {
    final SyncPayChannelHandler this$0;

    SyncPayChannelHandler.1(SyncPayChannelHandler syncPayChannelHandler) {
        this.this$0 = syncPayChannelHandler;
    }

    static /* synthetic */ SyncPayChannelHandler access$0(SyncPayChannelHandler.1 var0) {
        return var0.this$0;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        var1_1 = SyncPayChannelHandler.access$0((SyncPayChannelHandler)this.this$0);
        // MONITORENTER : var1_1
        try {
            SyncPayChannelHandler.access$0((SyncPayChannelHandler)this.this$0).wait();
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
