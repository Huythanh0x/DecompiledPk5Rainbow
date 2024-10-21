package com.uc.paymentsdk.network.chain;

import com.uc.paymentsdk.util.PrefUtil;
import org.json.JSONException;
import com.uc.paymentsdk.network.JSONParser;
import android.text.TextUtils;
import com.uc.paymentsdk.util.Utils;
import org.apache.http.HttpResponse;
import com.uc.paymentsdk.network.Api;
import android.content.Context;
import com.uc.paymentsdk.network.ApiTask;

public class SyncChargeChannelHandler extends Handler implements TaskHandler
{
    private static int sStatus;
    private final Integer LOCK;
    private OnFinishListener mOnFinishListener;
    
    public SyncChargeChannelHandler(final Context context) {
        super(context);
        this.LOCK = Integer.valueOf(0);
    }
    
    public SyncChargeChannelHandler(final Context context, final OnFinishListener mOnFinishListener) {
        super(context);
        this.LOCK = Integer.valueOf(0);
        this.mOnFinishListener = mOnFinishListener;
    }
    
    static /* synthetic */ Integer access$0(final SyncChargeChannelHandler syncChargeChannelHandler) {
        return syncChargeChannelHandler.LOCK;
    }
    
    public static void init() {
        SyncChargeChannelHandler.sStatus = 0;
    }
    
    @Override
    public void handleRequest() {
        switch (SyncChargeChannelHandler.sStatus) {
            case 2: {
                if (this.getSuccessor() != null) {
                    this.getSuccessor().handleRequest();
                    break;
                }
                if (this.mOnFinishListener != null) {
                    this.mOnFinishListener.onFinish();
                    break;
                }
                break;
            }
            case 1: {
                new Thread(new Runnable(this) {
                    final SyncChargeChannelHandler this$0;
                    
                    SyncChargeChannelHandler$1(final SyncChargeChannelHandler this$0) {
                        this.this$0 = this$0;
                        super();
                    }
                    
                    static /* synthetic */ SyncChargeChannelHandler access$0(final SyncChargeChannelHandler$1 runnable) {
                        return runnable.this$0;
                    }
                    
                    @Override
                    public void run() {
                        synchronized (LOCK) {
                            while (true) {
                                try {
                                    LOCK.wait();
                                    monitorexit(LOCK);
                                    this.this$0.mHandler.post((Runnable)new Runnable(this) {
                                        final SyncChargeChannelHandler$1 this$1;
                                        
                                        SyncChargeChannelHandler$1$1(final SyncChargeChannelHandler$1 this$1) {
                                            this.this$1 = this$1;
                                            super();
                                        }
                                        
                                        @Override
                                        public void run() {
                                            this$0.handleRequest();
                                        }
                                    });
                                }
                                catch (final InterruptedException ex) {
                                    ex.printStackTrace();
                                    continue;
                                }
                                break;
                            }
                        }
                    }
                }).start();
                break;
            }
            case 0: {
                SyncChargeChannelHandler.sStatus = 1;
                Api.syncChargeChannel(this.mContext, this);
                break;
            }
        }
    }
    
    @Override
    public void onError(final int n, final int n2) {
        while (true) {
            SyncChargeChannelHandler.sStatus = 0;
            synchronized (this.LOCK) {
                this.LOCK.notifyAll();
                monitorexit(this.LOCK);
                if (this.getSuccessor() == null) {
                    if (this.mOnFinishListener != null) {
                        this.mOnFinishListener.onFinish();
                    }
                    return;
                }
            }
            this.getSuccessor().handleRequest();
        }
    }
    
    @Override
    public Object onPreHandle(final int n, final HttpResponse httpResponse) {
        final String bodyString = Utils.getBodyString(n, httpResponse);
        Object chargeChannel;
        if (TextUtils.isEmpty((CharSequence)bodyString)) {
            chargeChannel = null;
        }
        else {
            try {
                chargeChannel = JSONParser.parseChargeChannel(bodyString);
            }
            catch (final JSONException ex) {
                chargeChannel = null;
            }
        }
        return chargeChannel;
    }
    
    @Override
    public void onSuccess(final int n, final Object o) {
        while (true) {
            PrefUtil.syncChargeChannels(this.mContext, (String[])o);
            SyncChargeChannelHandler.sStatus = 2;
            synchronized (this.LOCK) {
                this.LOCK.notifyAll();
                monitorexit(this.LOCK);
                if (this.getSuccessor() == null) {
                    if (this.mOnFinishListener != null) {
                        this.mOnFinishListener.onFinish();
                    }
                    return;
                }
            }
            this.getSuccessor().handleRequest();
        }
    }
}
