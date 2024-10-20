package com.uc.paymentsdk.network.chain;

import android.content.Context;

public class HandlerProxy extends Handler
{
    private Handler handler;
    
    public HandlerProxy(final Context context) {
        super(context);
        this.handler = new SyncSmsInfoHandler(context);
    }
    
    public HandlerProxy(final Context context, final OnFinishListener onFinishListener) {
        super(context);
        this.handler = new SyncSmsInfoHandler(context, onFinishListener);
    }
    
    @Override
    public void handleRequest() {
        this.handler.handleRequest();
    }
}
