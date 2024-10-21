package com.uc.paymentsdk.network.chain;

import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.network.XMLParser;
import android.text.TextUtils;
import com.uc.paymentsdk.util.Utils;
import org.apache.http.HttpResponse;
import com.uc.paymentsdk.network.Api;
import android.content.Context;
import com.uc.paymentsdk.network.ApiTask;

public class SyncPayChannelHandler extends Handler implements TaskHandler
{
    private static int sStatus;
    private final Integer LOCK;
    private OnFinishListener mOnFinishListener;
    
    public SyncPayChannelHandler(final Context context) {
        super(context);
        this.LOCK = Integer.valueOf(0);
    }
    
    public SyncPayChannelHandler(final Context context, final OnFinishListener mOnFinishListener) {
        super(context);
        this.LOCK = Integer.valueOf(0);
        this.mOnFinishListener = mOnFinishListener;
    }
    
    static /* synthetic */ Integer access$0(final SyncPayChannelHandler syncPayChannelHandler) {
        return syncPayChannelHandler.LOCK;
    }
    
    public static void init() {
        SyncPayChannelHandler.sStatus = 0;
    }
    
    @Override
    public void handleRequest() {
        switch (SyncPayChannelHandler.sStatus) {
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
                    final SyncPayChannelHandler this$0;
                    
                    SyncPayChannelHandler$1(final SyncPayChannelHandler this$0) {
                        this.this$0 = this$0;
                        super();
                    }
                    
                    static /* synthetic */ SyncPayChannelHandler access$0(final SyncPayChannelHandler$1 runnable) {
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
                                        final SyncPayChannelHandler$1 this$1;
                                        
                                        SyncPayChannelHandler$1$1(final SyncPayChannelHandler$1 this$1) {
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
                SyncPayChannelHandler.sStatus = 1;
                Api.syncPayChannel(this.mContext, this);
                break;
            }
        }
    }
    
    @Override
    public void onError(final int n, final int n2) {
        while (true) {
            SyncPayChannelHandler.sStatus = 0;
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
        Object payChannel;
        if (TextUtils.isEmpty((CharSequence)bodyString)) {
            payChannel = null;
        }
        else {
            try {
                payChannel = XMLParser.parsePayChannel(bodyString);
            }
            catch (final Exception ex) {
                payChannel = null;
            }
        }
        return payChannel;
    }
    
    @Override
    public void onSuccess(final int n, final Object o) {
        while (true) {
            PrefUtil.syncPayChannels(this.mContext, (String)o);
            SyncPayChannelHandler.sStatus = 2;
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
