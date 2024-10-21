package com.uc.paymentsdk.network.chain;

import android.content.Context;
import android.text.TextUtils;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.network.ApiTask.TaskHandler;
import com.uc.paymentsdk.network.XMLParser;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import org.apache.http.HttpResponse;

public class SyncPayChannelHandler extends Handler implements TaskHandler {
    private final Integer LOCK;
    private OnFinishListener mOnFinishListener;
    private static int sStatus;

    public SyncPayChannelHandler(Context paramContext) {
        super(paramContext);
        this.LOCK = (int)0;
    }

    public SyncPayChannelHandler(Context paramContext, OnFinishListener paramOnFinishListener) {
        super(paramContext);
        this.LOCK = (int)0;
        this.mOnFinishListener = paramOnFinishListener;
    }

    @Override  // com.uc.paymentsdk.network.chain.Handler
    public void handleRequest() {
        switch(SyncPayChannelHandler.sStatus) {
            case 0: {
                SyncPayChannelHandler.sStatus = 1;
                Api.syncPayChannel(this.mContext, this);
                return;
            }
            case 1: {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized(SyncPayChannelHandler.this.LOCK) {
                            try {
                                SyncPayChannelHandler.this.LOCK.wait();
                            }
                            catch(InterruptedException interruptedException0) {
                                interruptedException0.printStackTrace();
                            }
                        }
                        SyncPayChannelHandler.this.mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                SyncPayChannelHandler.this.handleRequest();
                            }
                        });
                    }
                }).start();
                return;
            }
            case 2: {
                if(this.getSuccessor() == null) {
                    if(this.mOnFinishListener != null) {
                        this.mOnFinishListener.onFinish();
                        return;
                    }
                    return;
                }
                this.getSuccessor().handleRequest();
            }
        }
    }

    public static void init() {
        SyncPayChannelHandler.sStatus = 0;
    }

    @Override  // com.uc.paymentsdk.network.ApiTask$TaskHandler
    public void onError(int paramInt1, int paramInt2) {
        SyncPayChannelHandler.sStatus = 0;
        synchronized(this.LOCK) {
            this.LOCK.notifyAll();
        }
        if(this.getSuccessor() == null) {
            if(this.mOnFinishListener != null) {
                this.mOnFinishListener.onFinish();
            }
            return;
        }
        this.getSuccessor().handleRequest();
    }

    @Override  // com.uc.paymentsdk.network.ApiTask$TaskHandler
    public Object onPreHandle(int paramInt, HttpResponse paramHttpResponse) {
        String s = Utils.getBodyString(paramInt, paramHttpResponse);
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        try {
            return XMLParser.parsePayChannel(s);
        }
        catch(Exception unused_ex) {
            return null;
        }
    }

    @Override  // com.uc.paymentsdk.network.ApiTask$TaskHandler
    public void onSuccess(int paramInt, Object paramObject) {
        PrefUtil.syncPayChannels(this.mContext, ((String)paramObject));
        SyncPayChannelHandler.sStatus = 2;
        synchronized(this.LOCK) {
            this.LOCK.notifyAll();
        }
        if(this.getSuccessor() == null) {
            if(this.mOnFinishListener != null) {
                this.mOnFinishListener.onFinish();
            }
            return;
        }
        this.getSuccessor().handleRequest();
    }
}

