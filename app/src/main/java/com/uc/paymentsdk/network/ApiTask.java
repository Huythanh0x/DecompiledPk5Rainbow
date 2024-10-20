/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.AsyncTask
 *  com.uc.paymentsdk.network.AndroidHttpClient
 *  com.uc.paymentsdk.network.ApiTask$TaskHandler
 *  com.uc.paymentsdk.network.HttpClientFactory
 */
package com.uc.paymentsdk.network;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import com.uc.paymentsdk.network.AndroidHttpClient;
import com.uc.paymentsdk.network.ApiTask;
import com.uc.paymentsdk.network.HttpClientFactory;
import java.util.HashMap;

public class ApiTask
extends AsyncTask<Void, Void, Object> {
    private static final String TAG = "pay";
    private String httpmethod;
    private AndroidHttpClient mClient;
    private Context mContext;
    private TaskHandler mHandler;
    private HashMap<String, Object> mParameter;
    private int mReuqestAction;

    ApiTask(Context context, int n, TaskHandler taskHandler, HashMap<String, Object> hashMap, String string) {
        this.mContext = context;
        this.mReuqestAction = n;
        this.mHandler = taskHandler;
        this.mParameter = hashMap;
        this.mClient = HttpClientFactory.get().getSDKHttpClient(null);
        this.httpmethod = string;
    }

    /*
     * Exception decompiling
     */
    protected Object doInBackground(Void[] var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.IllegalStateException: Backjump on non jumping statement @NONE, blocks:[] lbl50 : TryStatement: try { 5[TRYBLOCK]
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
     * Unable to fully structure code
     */
    protected void onPostExecute(Object var1_1) {
        block3: {
            block2: {
                if (this.mHandler == null) lbl-1000:
                // 5 sources

                {
                    return;
                }
                if (this.mContext instanceof Activity && ((Activity)this.mContext).isFinishing()) ** GOTO lbl-1000
                if (var1_1 != null) break block2;
                this.mHandler.onError(this.mReuqestAction, 500);
                ** GOTO lbl-1000
            }
            if (!(var1_1 instanceof Integer)) break block3;
            this.mHandler.onError(this.mReuqestAction, ((Integer)var1_1).intValue());
            ** GOTO lbl-1000
        }
        this.mHandler.onSuccess(this.mReuqestAction, var1_1);
        ** while (true)
    }
}
