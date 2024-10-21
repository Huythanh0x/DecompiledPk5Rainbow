/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.uc.paymentsdk.network.Api
 *  com.uc.paymentsdk.network.ApiTask$TaskHandler
 *  com.uc.paymentsdk.network.JSONParser
 *  com.uc.paymentsdk.network.chain.Handler
 *  com.uc.paymentsdk.network.chain.Handler$OnFinishListener
 *  com.uc.paymentsdk.util.PrefUtil
 *  com.uc.paymentsdk.util.Utils
 *  org.apache.http.HttpResponse
 *  org.json.JSONException
 */
package com.uc.paymentsdk.network.chain;

import android.content.Context;
import android.text.TextUtils;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.network.ApiTask;
import com.uc.paymentsdk.network.JSONParser;
import com.uc.paymentsdk.network.chain.Handler;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import org.apache.http.HttpResponse;
import org.json.JSONException;

public class SyncChargeChannelHandler
extends Handler
implements ApiTask.TaskHandler {
    private static int sStatus;
    private final Integer LOCK = 0;
    private Handler.OnFinishListener mOnFinishListener;

    public SyncChargeChannelHandler(Context context) {
        super(context);
    }

    public SyncChargeChannelHandler(Context context, Handler.OnFinishListener onFinishListener) {
        super(context);
        this.mOnFinishListener = onFinishListener;
    }

    static /* synthetic */ Integer access$0(SyncChargeChannelHandler syncChargeChannelHandler) {
        return syncChargeChannelHandler.LOCK;
    }

    public static void init() {
        sStatus = 0;
    }

    /*
     * Unable to fully structure code
     */
    public void handleRequest() {
        switch (SyncChargeChannelHandler.sStatus) lbl-1000:
        // 4 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                return;
            }
            case 2: {
                if (this.getSuccessor() != null) ** GOTO lbl10
                if (this.mOnFinishListener != null) {
                    this.mOnFinishListener.onFinish();
                }
                ** GOTO lbl-1000
lbl10:
                // 1 sources

                this.getSuccessor().handleRequest();
                ** GOTO lbl-1000
            }
            case 1: {
                new Thread((Runnable)new /* Unavailable Anonymous Inner Class!! */).start();
                ** GOTO lbl-1000
            }
            case 0: 
        }
        SyncChargeChannelHandler.sStatus = 1;
        Api.syncChargeChannel((Context)this.mContext, (ApiTask.TaskHandler)this);
        ** while (true)
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onError(int n, int n2) {
        sStatus = 0;
        Integer n3 = this.LOCK;
        // MONITORENTER : n3
        this.LOCK.notifyAll();
        // MONITOREXIT : n3
        if (this.getSuccessor() == null) {
            if (this.mOnFinishListener != null) {
                this.mOnFinishListener.onFinish();
            }
            return;
        }
        this.getSuccessor().handleRequest();
    }

    /*
     * Enabled force condition propagation
     */
    public Object onPreHandle(int n, HttpResponse object) {
        if (TextUtils.isEmpty((CharSequence)(object = Utils.getBodyString((int)n, (HttpResponse)object)))) {
            return null;
        }
        try {
            return JSONParser.parseChargeChannel((String)object);
        }
        catch (JSONException jSONException) {
            return null;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onSuccess(int n, Object object) {
        PrefUtil.syncChargeChannels((Context)this.mContext, (String[])((String[])object));
        sStatus = 2;
        Integer n2 = this.LOCK;
        // MONITORENTER : n2
        this.LOCK.notifyAll();
        // MONITOREXIT : n2
        if (this.getSuccessor() == null) {
            if (this.mOnFinishListener != null) {
                this.mOnFinishListener.onFinish();
            }
            return;
        }
        this.getSuccessor().handleRequest();
    }
}
