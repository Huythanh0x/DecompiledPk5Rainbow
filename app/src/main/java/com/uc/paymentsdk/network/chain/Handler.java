package com.uc.paymentsdk.network.chain;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class Handler {
    protected static final int STATUS_SYNCED = 2;
    protected static final int STATUS_SYNCING = 1;
    protected static final int STATUS_UNSYNC = 0;
    protected Context mContext;
    protected android.os.Handler mHandler = new android.os.Handler();
    private Handler mSuccessor;

    /* loaded from: classes.dex */
    public interface OnFinishListener {
        void onFinish();
    }

    public abstract void handleRequest();

    public Handler(Context paramContext) {
        this.mContext = paramContext;
    }

    public Handler setSuccessor(Handler paramHandler) {
        this.mSuccessor = paramHandler;
        return this;
    }

    public Handler getSuccessor() {
        return this.mSuccessor;
    }
}
