package com.uc.paymentsdk.network.chain.Handler;
import android.content.Context;
import java.lang.Object;
import android.os.Handler;

public abstract class Handler	// class@0000a5 from classes.dex
{
    protected Context mContext;
    protected Handler mHandler;
    private Handler mSuccessor;
    protected static final int STATUS_SYNCED = 2;
    protected static final int STATUS_SYNCING = 1;
    protected static final int STATUS_UNSYNC;

    public void Handler(Context paramContext){
       super();
       this.mContext = paramContext;
       this.mHandler = new Handler();
    }
    public Handler getSuccessor(){
       return this.mSuccessor;
    }
    public abstract void handleRequest();
    public Handler setSuccessor(Handler paramHandler){
       this.mSuccessor = paramHandler;
       return this;
    }
}
