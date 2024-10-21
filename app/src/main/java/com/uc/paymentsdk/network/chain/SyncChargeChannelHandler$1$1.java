/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.network.chain.SyncChargeChannelHandler$1
 */
package com.uc.paymentsdk.network.chain;

import com.uc.paymentsdk.network.chain.SyncChargeChannelHandler;

class SyncChargeChannelHandler.1
implements Runnable {
    final SyncChargeChannelHandler.1 this$1;

    SyncChargeChannelHandler.1(SyncChargeChannelHandler.1 var1_1) {
        this.this$1 = var1_1;
    }

    @Override
    public void run() {
        SyncChargeChannelHandler.1.access$0(this.this$1).handleRequest();
    }
}
