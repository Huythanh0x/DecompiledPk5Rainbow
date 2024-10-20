package com.uc.paymentsdk.network;

import com.uc.paymentsdk.util.PrefUtil;
import java.io.Serializable;
import com.uc.paymentsdk.commons.codec.MD5;
import com.uc.paymentsdk.util.Utils;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import com.uc.paymentsdk.payment.PaymentInfo;
import java.util.HashMap;
import android.content.Context;

public class Api
{
    public Api() {
        super();
    }
    
    public static void confirmPayResult(final Context context, final ApiTask.TaskHandler taskHandler, final String value, final String value2) {
        final HashMap hashMap = new HashMap(2);
        hashMap.put("order_id", value);
        hashMap.put("app_key", value2);
        new ApiTask(context, 5, taskHandler, hashMap, "post").execute((Object[])new Void[0]);
    }
    
    public static void pay(final Context context, final ApiTask.TaskHandler taskHandler, final PaymentInfo paymentInfo, final UPointPayInfo uPointPayInfo) {
        final HashMap hashMap = new HashMap(9);
        hashMap.put("user_id", uPointPayInfo.getUserid());
        hashMap.put("&cpid", uPointPayInfo.getCpid());
        hashMap.put("&gameid", uPointPayInfo.getGameid());
        hashMap.put("&optid", paymentInfo.getmActionID());
        hashMap.put("&u_money", Integer.valueOf(uPointPayInfo.getUpoint()));
        hashMap.put("&charge", Integer.valueOf(uPointPayInfo.getUmoney()));
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
    
    public static void postSmsPayment(final Context context, final ApiTask.TaskHandler taskHandler, final String value, final String value2, final String value3, final int n, final String value4, final String value5, final String value6, final String value7, final int i) {
        final String sessionID = Utils.getSessionID(context);
        final String aRanConsumeID = Utils.createARanConsumeID(20);
        Serializable s = "";
        while (true) {
            try {
                String substring;
                if (sessionID.length() <= 5) {
                    substring = sessionID;
                }
                else {
                    substring = sessionID.substring(0, 5);
                }
                final StringBuilder sb = new StringBuilder(String.valueOf(substring));
                String substring2;
                if (value.length() <= 5) {
                    substring2 = value;
                }
                else {
                    substring2 = value.substring(0, 5);
                }
                final StringBuilder append = sb.append(substring2);
                String substring3;
                if (value2.length() <= 5) {
                    substring3 = value2;
                }
                else {
                    substring3 = value2.substring(0, 5);
                }
                final Serializable md5 = MD5.getMD5(append.append(substring3).append(n).toString());
                s = new HashMap<Object, Object>(4);
                ((HashMap<String, String>)s).put("user_id", sessionID);
                ((HashMap<String, Integer>)s).put("cpid", (Integer)value);
                ((HashMap<String, Integer>)s).put("gameid", (Integer)value2);
                ((HashMap<String, Integer>)s).put("optid", (Integer)value3);
                ((HashMap<String, Integer>)s).put("consume_id", (Integer)aRanConsumeID);
                ((HashMap<String, Integer>)s).put("charge", Integer.valueOf(n));
                ((HashMap<String, String>)s).put("optobj", value4);
                ((HashMap<String, String>)s).put("sms_channel", value5);
                ((HashMap<String, String>)s).put("sms_port", value6);
                ((HashMap<String, String>)s).put("sms_content", value7);
                ((HashMap<String, Integer>)s).put("sms_type", Integer.valueOf(i));
                ((HashMap<String, String>)s).put("sendtime", Utils.getCurrentTime(false));
                ((HashMap<String, Integer>)s).put("sign", (Integer)md5);
                new ApiTask(context, 8, taskHandler, (HashMap<String, Object>)s, "post").execute((Object[])new Void[0]);
            }
            catch (final Exception ex) {
                final Serializable md5 = s;
                continue;
            }
            break;
        }
    }
    
    public static void queryUPointDiscount(final Context context, final ApiTask.TaskHandler taskHandler, final String value, final String value2, final int i) {
        final HashMap hashMap = new HashMap(1);
        hashMap.put("cpid", value);
        hashMap.put("gameid", value2);
        hashMap.put("u_money", Integer.valueOf(i));
        new ApiTask(context, 18, taskHandler, hashMap, "post").execute((Object[])new Void[0]);
    }
    
    public static void syncChargeChannel(final Context context, final ApiTask.TaskHandler taskHandler) {
        final HashMap hashMap = new HashMap(1);
        hashMap.put("action", "getRechargeChannels");
        new ApiTask(context, 17, taskHandler, hashMap, "post").execute((Object[])new Void[0]);
    }
    
    public static void syncPayChannel(final Context context, final ApiTask.TaskHandler taskHandler) {
        new ApiTask(context, 6, taskHandler, new HashMap<String, Object>(0), "post").execute((Object[])new Void[0]);
    }
    
    public static void syncSmsInfo(final Context context, final ApiTask.TaskHandler taskHandler, final String value, final String value2) {
        final HashMap hashMap = new HashMap(1);
        String value3;
        if ((value3 = Utils.getSessionID(context)) == null) {
            value3 = Utils.createARanSessionid(8);
            PrefUtil.setUserSession(context, value3);
        }
        hashMap.put("user_id", value3);
        hashMap.put("cpid", value);
        hashMap.put("gameid", value2);
        hashMap.put("area", "");
        hashMap.put("imsi", Utils.getSimNumber(context));
        new ApiTask(context, 7, taskHandler, hashMap, "post").execute((Object[])new Void[0]);
    }
    
    public static void syncUPointDiscount(final Context context, final ApiTask.TaskHandler taskHandler, final String value, final String value2, final int i) {
        final HashMap hashMap = new HashMap(1);
        hashMap.put("cpid", value);
        hashMap.put("gameid", value2);
        hashMap.put("u_money", Integer.valueOf(i));
        new ApiTask(context, 18, taskHandler, hashMap, "post").execute((Object[])new Void[0]);
    }
}
