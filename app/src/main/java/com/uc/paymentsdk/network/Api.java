package com.uc.paymentsdk.network;

import android.content.Context;
import com.uc.paymentsdk.commons.codec.MD5;
import com.uc.paymentsdk.network.ApiTask;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import com.uc.paymentsdk.util.Constants;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Api {
    public static void pay(Context paramContext, ApiTask.TaskHandler paramTaskHandler, PaymentInfo paramPaymentInfo, UPointPayInfo upayinfo) {
        HashMap<String, Object> localHashMap = new HashMap<>(9);
        localHashMap.put("user_id", upayinfo.getUserid());
        localHashMap.put("&cpid", upayinfo.getCpid());
        localHashMap.put("&gameid", upayinfo.getGameid());
        localHashMap.put("&optid", paramPaymentInfo.getmActionID());
        localHashMap.put("&u_money", Integer.valueOf(upayinfo.getUpoint()));
        localHashMap.put("&charge", Integer.valueOf(upayinfo.getUmoney()));
        localHashMap.put("&consume_id", upayinfo.getConsumeid());
        localHashMap.put("&ucid", upayinfo.getUsersession());
        localHashMap.put("&sign", upayinfo.getSign());
        localHashMap.put("&uc_token", upayinfo.getUctoken());
        localHashMap.put("&pay_pwd", upayinfo.getPaypwd());
        localHashMap.put("&consume_time", upayinfo.getTm());
        localHashMap.put("&tm", upayinfo.getTm());
        localHashMap.put("&eid", UPointPayInfo.getEid());
        localHashMap.put("&ch_code", upayinfo.getChcode());
        new ApiTask(paramContext, 3, paramTaskHandler, localHashMap, Constants.POST).execute(new Void[0]);
    }

    public static void confirmPayResult(Context paramContext, ApiTask.TaskHandler paramTaskHandler, String paramString1, String paramString2) {
        HashMap<String, Object> localHashMap = new HashMap<>(2);
        localHashMap.put("order_id", paramString1);
        localHashMap.put("app_key", paramString2);
        new ApiTask(paramContext, 5, paramTaskHandler, localHashMap, Constants.POST).execute(new Void[0]);
    }

    public static void queryUPointDiscount(Context paramContext, ApiTask.TaskHandler paramTaskHandler, String cpid, String gameid, int charge) {
        HashMap<String, Object> localHashMap = new HashMap<>(1);
        localHashMap.put("cpid", cpid);
        localHashMap.put("gameid", gameid);
        localHashMap.put("u_money", Integer.valueOf(charge));
        new ApiTask(paramContext, 18, paramTaskHandler, localHashMap, Constants.POST).execute(new Void[0]);
    }

    public static void syncChargeChannel(Context paramContext, ApiTask.TaskHandler paramTaskHandler) {
        HashMap<String, Object> localHashMap = new HashMap<>(1);
        localHashMap.put("action", "getRechargeChannels");
        new ApiTask(paramContext, 17, paramTaskHandler, localHashMap, Constants.POST).execute(new Void[0]);
    }

    public static void syncPayChannel(Context paramContext, ApiTask.TaskHandler paramTaskHandler) {
        HashMap<String, Object> localHashMap = new HashMap<>(0);
        new ApiTask(paramContext, 6, paramTaskHandler, localHashMap, Constants.POST).execute(new Void[0]);
    }

    public static void syncUPointDiscount(Context paramContext, ApiTask.TaskHandler paramTaskHandler, String cpid, String gameid, int charge) {
        HashMap<String, Object> localHashMap = new HashMap<>(1);
        localHashMap.put("cpid", cpid);
        localHashMap.put("gameid", gameid);
        localHashMap.put("u_money", Integer.valueOf(charge));
        new ApiTask(paramContext, 18, paramTaskHandler, localHashMap, Constants.POST).execute(new Void[0]);
    }

    public static void syncSmsInfo(Context paramContext, ApiTask.TaskHandler paramTaskHandler, String cpid, String gameid) {
        HashMap<String, Object> localHashMap = new HashMap<>(1);
        String usersession = Utils.getSessionID(paramContext);
        if (usersession == null) {
            usersession = Utils.createARanSessionid(8);
            PrefUtil.setUserSession(paramContext, usersession);
        }
        localHashMap.put("user_id", usersession);
        localHashMap.put("cpid", cpid);
        localHashMap.put("gameid", gameid);
        localHashMap.put("area", "");
        localHashMap.put("imsi", Utils.getSimNumber(paramContext));
        new ApiTask(paramContext, 7, paramTaskHandler, localHashMap, Constants.POST).execute(new Void[0]);
    }

    public static void postSmsPayment(Context paramContext, ApiTask.TaskHandler paramTaskHandler, String cpid, String gameid, String optid, int charge, String optobj, String sms_channel, String sms_port, String sms_content, int sms_type) {
        String usersession = Utils.getSessionID(paramContext);
        Object consumeid = Utils.createARanConsumeID(20);
        String sign = "";
        try {
            sign = MD5.getMD5(String.valueOf(usersession.length() <= 5 ? usersession : usersession.substring(0, 5)) + (cpid.length() <= 5 ? cpid : cpid.substring(0, 5)) + (gameid.length() <= 5 ? gameid : gameid.substring(0, 5)) + charge);
        } catch (Exception e) {
        }
        HashMap<String, Object> localHashMap = new HashMap<>(4);
        localHashMap.put("user_id", usersession);
        localHashMap.put("cpid", cpid);
        localHashMap.put("gameid", gameid);
        localHashMap.put("optid", optid);
        localHashMap.put("consume_id", consumeid);
        localHashMap.put("charge", Integer.valueOf(charge));
        localHashMap.put("optobj", optobj);
        localHashMap.put("sms_channel", sms_channel);
        localHashMap.put("sms_port", sms_port);
        localHashMap.put("sms_content", sms_content);
        localHashMap.put("sms_type", Integer.valueOf(sms_type));
        localHashMap.put("sendtime", Utils.getCurrentTime(false));
        localHashMap.put("sign", sign);
        new ApiTask(paramContext, 8, paramTaskHandler, localHashMap, Constants.POST).execute(new Void[0]);
    }
}
