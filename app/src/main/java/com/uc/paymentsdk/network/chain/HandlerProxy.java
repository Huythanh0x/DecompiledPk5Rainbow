package com.uc.paymentsdk.network.chain.HandlerProxy;
import com.uc.paymentsdk.network.chain.Handler;
import android.content.Context;
import com.uc.paymentsdk.network.chain.SyncSmsInfoHandler;
import com.uc.paymentsdk.network.chain.Handler$OnFinishListener;

public class HandlerProxy extends Handler	// class@0000a6 from classes.dex
{
    private Handler handler;

    public void HandlerProxy(Context paramContext){
       super(paramContext);
       this.handler = new SyncSmsInfoHandler(paramContext);
    }
    public void HandlerProxy(Context paramContext,Handler$OnFinishListener paramOnFinishListener){
       super(paramContext);
       this.handler = new SyncSmsInfoHandler(paramContext, paramOnFinishListener);
    }
    public void handleRequest(){
       this.handler.handleRequest();
    }
}
