package com.uc.paymentsdk.network.chain;

import android.content.Context;

public class HandlerProxy extends Handler {
    private Handler handler;

    public HandlerProxy(Context paramContext) {
        super(paramContext);
        this.handler = new SyncSmsInfoHandler(paramContext);
    }

    public HandlerProxy(Context paramContext, OnFinishListener paramOnFinishListener) {
        super(paramContext);
        this.handler = new SyncSmsInfoHandler(paramContext, paramOnFinishListener);
    }

    @Override  // com.uc.paymentsdk.network.chain.Handler
    public void handleRequest() {
        this.handler.handleRequest();
    }
}

