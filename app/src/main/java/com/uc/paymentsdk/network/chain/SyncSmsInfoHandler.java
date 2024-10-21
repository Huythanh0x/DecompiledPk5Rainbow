package com.uc.paymentsdk.network.chain;

import android.content.Context;
import android.text.TextUtils;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.network.ApiTask.TaskHandler;
import com.uc.paymentsdk.network.XMLParser;
import com.uc.paymentsdk.payment.sms.SmsInfos;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import java.io.IOException;
import org.apache.http.HttpResponse;

public class SyncSmsInfoHandler extends Handler implements TaskHandler {
    private final Integer LOCK;
    private OnFinishListener mOnFinishListener;
    private static int sStatus;

    public SyncSmsInfoHandler(Context paramContext) {
        super(paramContext);
        this.LOCK = (int)0;
    }

    public SyncSmsInfoHandler(Context paramContext, OnFinishListener paramOnFinishListener) {
        super(paramContext);
        this.LOCK = (int)0;
        this.mOnFinishListener = paramOnFinishListener;
    }

    @Override  // com.uc.paymentsdk.network.chain.Handler
    public void handleRequest() {
        switch(SyncSmsInfoHandler.sStatus) {
            case 0: {
                SyncSmsInfoHandler.sStatus = 1;
                Api.syncSmsInfo(this.mContext, this, Utils.getPaymentInfo().getCpID(), Utils.getPaymentInfo().getmGameID());
                return;
            }
            case 1: {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized(SyncSmsInfoHandler.this.LOCK) {
                            try {
                                SyncSmsInfoHandler.this.LOCK.wait();
                            }
                            catch(InterruptedException interruptedException0) {
                                interruptedException0.printStackTrace();
                            }
                        }
                        SyncSmsInfoHandler.this.mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                SyncSmsInfoHandler.this.handleRequest();
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
        SyncSmsInfoHandler.sStatus = 0;
    }

    @Override  // com.uc.paymentsdk.network.ApiTask$TaskHandler
    public void onError(int paramInt1, int paramInt2) {
        SyncSmsInfoHandler.sStatus = 2;
        if(Utils.getSmsInfos() == null) {
            try {
                String s = PrefUtil.getSmsInfo(this.mContext);
                if(s == null) {
                    Utils.setSmsInfo(null);
                }
                else {
                    SmsInfos smsInfos0 = XMLParser.parseSmsInfo(s);
                    if(smsInfos0 == null) {
                        Utils.setSmsInfo(null);
                    }
                    else if(Utils.dateDiffByDay("", "2024-10-20", "yyyy-MM-dd") >= 0) {
                        Utils.setSmsInfo(null);
                    }
                    else {
                        Utils.setSmsInfo(smsInfos0);
                    }
                }
            }
            catch(IOException iOException0) {
                SyncSmsInfoHandler.sStatus = 0;
                iOException0.printStackTrace();
            }
            catch(Exception exception0) {
                SyncSmsInfoHandler.sStatus = 0;
                exception0.printStackTrace();
            }
        }
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
        SmsInfos smsInfos0;
        String s = Utils.getBodyString(paramInt, paramHttpResponse);
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        try {
            smsInfos0 = XMLParser.parseSmsInfo(s);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        PrefUtil.setSmsInfo(this.mContext, s);
        return smsInfos0;
    }

    @Override  // com.uc.paymentsdk.network.ApiTask$TaskHandler
    public void onSuccess(int paramInt, Object paramObject) {
        SyncSmsInfoHandler.sStatus = 2;
        Utils.setSmsInfo(((SmsInfos)paramObject));
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

