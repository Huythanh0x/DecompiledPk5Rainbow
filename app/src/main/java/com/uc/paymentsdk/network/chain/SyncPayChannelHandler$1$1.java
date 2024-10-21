/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.network.chain.SyncPayChannelHandler$1
 */
package com.uc.paymentsdk.network.chain;

import com.uc.paymentsdk.network.chain.SyncPayChannelHandler;

class SyncPayChannelHandler.1
implements Runnable {
    final SyncPayChannelHandler.1 this$1;

    SyncPayChannelHandler.1(SyncPayChannelHandler.1 var1_1) {
        this.this$1 = var1_1;
    }

    @Override
    public void run() {
        SyncPayChannelHandler.1.access$0(this.this$1).handleRequest();
    }
}
