package com.uc.paymentsdk.network.chain;

import android.content.Context;

public abstract class Handler {
    public interface OnFinishListener {
        void onFinish();
    }

    protected static final int STATUS_SYNCED = 2;
    protected static final int STATUS_SYNCING = 1;
    protected static final int STATUS_UNSYNC;
    protected Context mContext;
    protected android.os.Handler mHandler;
    private Handler mSuccessor;

    public Handler(Context paramContext) {
        this.mContext = paramContext;
        this.mHandler = new android.os.Handler();
    }

    public Handler getSuccessor() {
        return this.mSuccessor;
    }

    public abstract void handleRequest();

    public Handler setSuccessor(Handler paramHandler) {
        this.mSuccessor = paramHandler;
        return this;
    }
}

