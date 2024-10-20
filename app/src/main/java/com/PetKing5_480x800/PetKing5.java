/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  com.uc.paymentsdk.payment.PaymentInfo
 *  com.uc.paymentsdk.payment.PaymentsActivity
 *  javax.microedition.lcdui.CwaActivity
 *  javax.microedition.midlet.MIDlet
 *  main.GameRun
 *  main.SMSSender
 *  main.XConnection
 */
package com.PetKing5_480x800;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.payment.PaymentsActivity;
import java.io.Serializable;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.midlet.MIDlet;
import main.GameRun;
import main.SMSSender;
import main.XConnection;

public class PetKing5
extends CwaActivity {
    public static GameRun gr;
    public static Intent intent;
    AlertDialog ad;
    XConnection instance;

    static {
        intent = null;
        gr = null;
    }

    public PetKing5() {
        SMSSender.pk = this;
        PaymentsActivity.init((Context)this);
    }

    /*
     * Exception decompiling
     */
    protected void onActivityResult(int var1_1, int var2_2, Intent var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.IllegalStateException: Backjump on non jumping statement @NONE, blocks:[] lbl43 : TryStatement: try { 3[TRYBLOCK]
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

    public void onCreate(Bundle bundle) {
        this.setFullWindow(true);
        super.onCreate(bundle);
        this.instance = new XConnection();
        this.setMIDlet((MIDlet)this.instance);
        this.setContentView();
        intent = this.getIntent();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    /*
     * Unable to fully structure code
     */
    public void setSmshah() {
        switch (SMSSender.smsType) lbl-1000:
        // 6 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                return;
            }
            case 1: {
                var1_1 = new Intent(this.getApplicationContext(), PaymentsActivity.class);
                var1_1.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("\u8d2d\u4e705000\u91d1", "22", "01", "\u8eab\u4e3a\u56db\u5927\u5bb6\u65cf\u4e4b\u9996\u7684\u8d35\u516c\u5b50\uff0c\u6ca1\u94b1\u53ef\u4e0d\u884c\uff01\u7acb\u523b\u62e5\u67095000\u91d1\u3002", 20));
                this.startActivityForResult(var1_1, 0);
                ** GOTO lbl-1000
            }
            case 3: {
                var1_2 = new Intent(this.getApplicationContext(), PaymentsActivity.class);
                var1_2.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("\u8d2d\u4e7010\u5fbd\u7ae0", "22", "02", "\u8d2d\u4e70\u8be5\u7279\u6b8a\u9053\u5177\uff0c\u7acb\u523b\u62e5\u670910\u5fbd\u7ae0\uff0c\u80fd\u8d2d\u4e70\u53cc\u500d\u7ecf\u9a8c\uff0c\u5ba0\u7269\u6280\u80fd\uff0c\u5f3a\u5927\u7684\u5ba0\u7269\u6355\u83b7\u7403\u7b49\u5404\u79cd\u795e\u5947\u7684\u9053\u5177\u3002", 20));
                this.startActivityForResult(var1_2, 0);
                ** GOTO lbl-1000
            }
            case 4: {
                var1_3 = new Intent(this.getApplicationContext(), PaymentsActivity.class);
                var1_3.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("\u5ba0\u7269\u53475\u7ea7", "22", "03", "\u8ba9\u60a8\u968f\u8eab\u643a\u5e26\u7684\u5168\u90e8\u5ba0\u7269\u7acb\u523b\u53475\u7ea7\uff08\u8d85\u8fc770\u7ea7\u5ba0\u7269\u4e0d\u80fd\u518d\u5347\u7ea7\uff09", 20));
                this.startActivityForResult(var1_3, 0);
                ** GOTO lbl-1000
            }
            case 5: {
                var1_4 = new Intent(this.getApplicationContext(), PaymentsActivity.class);
                var1_4.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("\u8d2d\u4e70\u5947\u5f02\u517d", "22", "04", "\u8d2d\u4e70\u8be5\u7279\u6b8a\u9053\u5177\uff0c\u83b7\u5f97\u53ef\u7231\u7684\u5947\u5f02\u517d\uff0c\u79fb\u52a8\u901f\u5ea6\u53ef\u4ee5\u63d0\u9ad8\u4e00\u500d\uff0c\u4e14\u4e0d\u4f1a\u9047\u5230\u4efb\u4f55\u654c\u4eba\uff01\u65e0\u9650\u4f7f\u7528\uff0c\u5fc3\u52a8\u4e0d\u5982\u884c\u52a8\uff0c\u5feb\u8d2d\u4e70\u5427\uff01", 20));
                this.startActivityForResult(var1_4, 0);
                ** GOTO lbl-1000
            }
            case 6: {
                var1_5 = new Intent(this.getApplicationContext(), PaymentsActivity.class);
                var1_5.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("\u6b63\u7248\u9a8c\u8bc1", "22", "05", "\u6e38\u620f\u8bd5\u73a9\u7ed3\u675f\uff0c\u8d2d\u4e70\u6b64\u9879\u5c06\u5f00\u542f\u540e\u7eed\u6240\u6709\u6e38\u620f\u5185\u5bb9\u3001\u5730\u56fe\u3002\u540c\u65f6\u5c06\u514d\u8d39\u8d60\u9001\u60a85\u679a\u5fbd\u7ae0\uff08\u53ef\u8d2d\u4e70\u5f3a\u529b\u9053\u5177\uff09", 40));
                this.startActivityForResult(var1_5, 0);
                ** GOTO lbl-1000
            }
            case 7: 
        }
        var1_6 = new Intent(this.getApplicationContext(), PaymentsActivity.class);
        var1_6.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("\u5347\u7ea7\u590d\u6d3b", "22", "06", "\u8ba9\u60a8\u643a\u5e26\u7684\u6240\u6709\u5ba0\u7269\u5168\u6062\u590d\uff0c\u540c\u65f6\u7acb\u523b\u8ba9\u60a8\u643a\u5e26\u7684\u5ba0\u7269\u63d0\u53475\u7ea7\uff08\u8d85\u8fc770\u7ea7\u5ba0\u7269\u4e0d\u80fd\u518d\u5347\u7ea7\uff09\uff0c\u8ba9\u63a5\u4e0b\u6765\u7684\u6218\u6597\u53d8\u7684\u66f4\u8f7b\u677e\u3002", 20));
        this.startActivityForResult(var1_6, 0);
        ** while (true)
    }
}
