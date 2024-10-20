/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.uc.paymentsdk.network.ApiTask
 *  com.uc.paymentsdk.network.ApiTask$TaskHandler
 *  com.uc.paymentsdk.payment.PaymentInfo
 *  com.uc.paymentsdk.payment.upoint.UPointPayInfo
 *  com.uc.paymentsdk.util.PrefUtil
 *  com.uc.paymentsdk.util.Utils
 */
package com.uc.paymentsdk.network;

import android.content.Context;
import com.uc.paymentsdk.network.ApiTask;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import java.util.HashMap;

public class Api {
    public static void confirmPayResult(Context context, ApiTask.TaskHandler taskHandler, String string, String string2) {
        HashMap<String, String> hashMap = new HashMap<String, String>(2);
        hashMap.put("order_id", string);
        hashMap.put("app_key", string2);
        new ApiTask(context, 5, taskHandler, hashMap, "post").execute((Object[])new Void[0]);
    }

    public static void pay(Context context, ApiTask.TaskHandler taskHandler, PaymentInfo paymentInfo, UPointPayInfo uPointPayInfo) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>(9);
        hashMap.put("user_id", uPointPayInfo.getUserid());
        hashMap.put("&cpid", uPointPayInfo.getCpid());
        hashMap.put("&gameid", uPointPayInfo.getGameid());
        hashMap.put("&optid", paymentInfo.getmActionID());
        hashMap.put("&u_money", uPointPayInfo.getUpoint());
        hashMap.put("&charge", uPointPayInfo.getUmoney());
        hashMap.put("&consume_id", uPointPayInfo.getConsumeid());
        hashMap.put("&ucid", uPointPayInfo.getUsersession());
        hashMap.put("&sign", uPointPayInfo.getSign());
        hashMap.put("&uc_token", uPointPayInfo.getUctoken());
        hashMap.put("&pay_pwd", uPointPayInfo.getPaypwd());
        hashMap.put("&consume_time", uPointPayInfo.getTm());
        hashMap.put("&tm", uPointPayInfo.getTm());
        hashMap.put("&eid", UPointPayInfo.getEid());
        hashMap.put("&ch_code", uPointPayInfo.getChcode());
        new ApiTask(context, 3, taskHandler, hashMap, "post").execute((Object[])new Void[0]);
    }

    /*
     * Exception decompiling
     */
    public static void postSmsPayment(Context var0, ApiTask.TaskHandler var1_1, String var2_2, String var3_3, String var4_4, int var5_5, String var6_6, String var7_7, String var8_8, String var9_9, int var10_10) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
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

    public static void queryUPointDiscount(Context context, ApiTask.TaskHandler taskHandler, String string, String string2, int n) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>(1);
        hashMap.put("cpid", string);
        hashMap.put("gameid", string2);
        hashMap.put("u_money", n);
        new ApiTask(context, 18, taskHandler, hashMap, "post").execute((Object[])new Void[0]);
    }

    public static void syncChargeChannel(Context context, ApiTask.TaskHandler taskHandler) {
        HashMap<String, String> hashMap = new HashMap<String, String>(1);
        hashMap.put("action", "getRechargeChannels");
        new ApiTask(context, 17, taskHandler, hashMap, "post").execute((Object[])new Void[0]);
    }

    public static void syncPayChannel(Context context, ApiTask.TaskHandler taskHandler) {
        new ApiTask(context, 6, taskHandler, new HashMap<K, V>(0), "post").execute((Object[])new Void[0]);
    }

    public static void syncSmsInfo(Context context, ApiTask.TaskHandler taskHandler, String string, String string2) {
        String string3;
        HashMap<String, String> hashMap = new HashMap<String, String>(1);
        String string4 = string3 = Utils.getSessionID((Context)context);
        if (string3 == null) {
            string4 = Utils.createARanSessionid((int)8);
            PrefUtil.setUserSession((Context)context, (String)string4);
        }
        hashMap.put("user_id", string4);
        hashMap.put("cpid", string);
        hashMap.put("gameid", string2);
        hashMap.put("area", "");
        hashMap.put("imsi", Utils.getSimNumber((Context)context));
        new ApiTask(context, 7, taskHandler, hashMap, "post").execute((Object[])new Void[0]);
    }

    public static void syncUPointDiscount(Context context, ApiTask.TaskHandler taskHandler, String string, String string2, int n) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>(1);
        hashMap.put("cpid", string);
        hashMap.put("gameid", string2);
        hashMap.put("u_money", n);
        new ApiTask(context, 18, taskHandler, hashMap, "post").execute((Object[])new Void[0]);
    }
}
