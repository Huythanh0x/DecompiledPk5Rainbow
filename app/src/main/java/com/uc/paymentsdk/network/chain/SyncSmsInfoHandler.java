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
 *  com.uc.paymentsdk.payment.sms.SmsInfos
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
import com.uc.paymentsdk.payment.sms.SmsInfos;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import org.apache.http.HttpResponse;

public class SyncSmsInfoHandler
extends Handler
implements ApiTask.TaskHandler {
    private static int sStatus;
    private final Integer LOCK = 0;
    private Handler.OnFinishListener mOnFinishListener;

    public SyncSmsInfoHandler(Context context) {
        super(context);
    }

    public SyncSmsInfoHandler(Context context, Handler.OnFinishListener onFinishListener) {
        super(context);
        this.mOnFinishListener = onFinishListener;
    }

    static /* synthetic */ Integer access$0(SyncSmsInfoHandler syncSmsInfoHandler) {
        return syncSmsInfoHandler.LOCK;
    }

    public static void init() {
        sStatus = 0;
    }

    /*
     * Unable to fully structure code
     */
    public void handleRequest() {
        switch (SyncSmsInfoHandler.sStatus) lbl-1000:
        // 4 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                return;
            }
            case 1: {
                new Thread((Runnable)new /* Unavailable Anonymous Inner Class!! */).start();
                ** GOTO lbl-1000
            }
            case 2: {
                if (this.getSuccessor() != null) ** GOTO lbl13
                if (this.mOnFinishListener != null) {
                    this.mOnFinishListener.onFinish();
                }
                ** GOTO lbl-1000
lbl13:
                // 1 sources

                this.getSuccessor().handleRequest();
                ** GOTO lbl-1000
            }
            case 0: 
        }
        SyncSmsInfoHandler.sStatus = 1;
        Api.syncSmsInfo((Context)this.mContext, (ApiTask.TaskHandler)this, (String)Utils.getPaymentInfo().getCpID(), (String)Utils.getPaymentInfo().getmGameID());
        ** while (true)
    }

    /*
     * Exception decompiling
     */
    public void onError(int var1_1, int var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.IllegalStateException: Backjump on non jumping statement @NONE, blocks:[] lbl25 : TryStatement: try { 3[TRYBLOCK]
         * 
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
         *     at org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:550)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:111)
         *     at java.base/java.lang.Thread.run(Thread.java:840)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled force condition propagation
     */
    public Object onPreHandle(int n, HttpResponse httpResponse) {
        String string = Utils.getBodyString((int)n, (HttpResponse)httpResponse);
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        try {
            httpResponse = XMLParser.parseSmsInfo((String)string);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        PrefUtil.setSmsInfo((Context)this.mContext, (String)string);
        return httpResponse;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onSuccess(int n, Object object) {
        sStatus = 2;
        Utils.setSmsInfo((SmsInfos)((SmsInfos)object));
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
