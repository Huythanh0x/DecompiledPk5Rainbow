/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 */
package com.uc.paymentsdk.network.chain;

import android.content.Context;

public abstract class Handler {
    protected static final int STATUS_SYNCED = 2;
    protected static final int STATUS_SYNCING = 1;
    protected static final int STATUS_UNSYNC = 0;
    protected Context mContext;
    protected android.os.Handler mHandler;
    private Handler mSuccessor;

    public Handler(Context context) {
        this.mContext = context;
        this.mHandler = new android.os.Handler();
    }

    public Handler getSuccessor() {
        return this.mSuccessor;
    }

    public abstract void handleRequest();

    public Handler setSuccessor(Handler handler) {
        this.mSuccessor = handler;
        return this;
    }
}
