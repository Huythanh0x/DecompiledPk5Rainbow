/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.network.chain.SyncSmsInfoHandler$1
 */
package com.uc.paymentsdk.network.chain;

import com.uc.paymentsdk.network.chain.SyncSmsInfoHandler;

class SyncSmsInfoHandler.1
implements Runnable {
    final SyncSmsInfoHandler.1 this$1;

    SyncSmsInfoHandler.1(SyncSmsInfoHandler.1 var1_1) {
        this.this$1 = var1_1;
    }

    @Override
    public void run() {
        SyncSmsInfoHandler.1.access$0(this.this$1).handleRequest();
    }
}
