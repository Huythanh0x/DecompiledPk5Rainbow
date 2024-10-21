/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.uc.paymentsdk.network.chain.Handler
 *  com.uc.paymentsdk.network.chain.Handler$OnFinishListener
 *  com.uc.paymentsdk.network.chain.SyncSmsInfoHandler
 */
package com.uc.paymentsdk.network.chain;

import android.content.Context;
import com.uc.paymentsdk.network.chain.Handler;
import com.uc.paymentsdk.network.chain.SyncSmsInfoHandler;

public class HandlerProxy
extends Handler {
    private Handler handler;

    public HandlerProxy(Context context) {
        super(context);
        this.handler = new SyncSmsInfoHandler(context);
    }

    public HandlerProxy(Context context, Handler.OnFinishListener onFinishListener) {
        super(context);
        this.handler = new SyncSmsInfoHandler(context, onFinishListener);
    }

    public void handleRequest() {
        this.handler.handleRequest();
    }
}
