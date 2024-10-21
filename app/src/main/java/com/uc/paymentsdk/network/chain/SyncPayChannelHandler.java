/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.uc.paymentsdk.network.Api
 *  com.uc.paymentsdk.network.ApiTask$TaskHandler
 *  com.uc.paymentsdk.network.XMLParser
 *  com.uc.paymentsdk.network.chain.Handler
 *  com.uc.paymentsdk.network.chain.Handler$OnFinishListener
 *  com.uc.paymentsdk.util.PrefUtil
 *  com.uc.paymentsdk.util.Utils
 *  org.apache.http.HttpResponse
 */
package com.uc.paymentsdk.network.chain;

import android.content.Context;
import android.text.TextUtils;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.network.ApiTask;
import com.uc.paymentsdk.network.XMLParser;
import com.uc.paymentsdk.network.chain.Handler;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import org.apache.http.HttpResponse;

public class SyncPayChannelHandler
extends Handler
implements ApiTask.TaskHandler {
    private static int sStatus;
    private final Integer LOCK = 0;
    private Handler.OnFinishListener mOnFinishListener;

    public SyncPayChannelHandler(Context context) {
        super(context);
    }

    public SyncPayChannelHandler(Context context, Handler.OnFinishListener onFinishListener) {
        super(context);
        this.mOnFinishListener = onFinishListener;
    }

    static /* synthetic */ Integer access$0(SyncPayChannelHandler syncPayChannelHandler) {
        return syncPayChannelHandler.LOCK;
    }

    public static void init() {
        sStatus = 0;
    }

    /*
     * Unable to fully structure code
     */
    public void handleRequest() {
        switch (SyncPayChannelHandler.sStatus) lbl-1000:
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
        SyncPayChannelHandler.sStatus = 1;
        Api.syncPayChannel((Context)this.mContext, (ApiTask.TaskHandler)this);
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
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public Object onPreHandle(int var1_1, HttpResponse var2_2) {
        if (TextUtils.isEmpty((CharSequence)(var2_2 /* !! */  = Utils.getBodyString((int)var1_1, (HttpResponse)var2_2 /* !! */ )))) {
            var2_2 /* !! */  = null;
lbl3:
            // 3 sources

            return var2_2 /* !! */ ;
        }
        try {
            var2_2 /* !! */  = XMLParser.parsePayChannel((String)var2_2 /* !! */ );
            ** GOTO lbl3
        }
        catch (Exception var2_3) {
            var2_2 /* !! */  = null;
            ** continue;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onSuccess(int n, Object object) {
        PrefUtil.syncPayChannels((Context)this.mContext, (String)((String)object));
        sStatus = 2;
        object = this.LOCK;
        // MONITORENTER : object
        this.LOCK.notifyAll();
        // MONITOREXIT : object
        if (this.getSuccessor() == null) {
            if (this.mOnFinishListener != null) {
                this.mOnFinishListener.onFinish();
            }
            return;
        }
        this.getSuccessor().handleRequest();
    }
}
