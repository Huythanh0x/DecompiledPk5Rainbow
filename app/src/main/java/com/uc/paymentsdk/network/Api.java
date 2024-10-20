package com.uc.paymentsdk.network;

import android.content.Context;
import com.uc.paymentsdk.commons.codec.MD5;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import java.util.HashMap;

public class Api {
  public static void confirmPayResult(Context paramContext, ApiTask.TaskHandler paramTaskHandler, String paramString1, String paramString2) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(2);
    hashMap.put("order_id", paramString1);
    hashMap.put("app_key", paramString2);
    (new ApiTask(paramContext, 5, paramTaskHandler, (HashMap)hashMap, "post")).execute((Object[])new Void[0]);
  }
  
  public static void pay(Context paramContext, ApiTask.TaskHandler paramTaskHandler, PaymentInfo paramPaymentInfo, UPointPayInfo paramUPointPayInfo) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(9);
    hashMap.put("user_id", paramUPointPayInfo.getUserid());
    hashMap.put("&cpid", paramUPointPayInfo.getCpid());
    hashMap.put("&gameid", paramUPointPayInfo.getGameid());
    hashMap.put("&optid", paramPaymentInfo.getmActionID());
    hashMap.put("&u_money", Integer.valueOf(paramUPointPayInfo.getUpoint()));
    hashMap.put("&charge", Integer.valueOf(paramUPointPayInfo.getUmoney()));
    hashMap.put("&consume_id", paramUPointPayInfo.getConsumeid());
    hashMap.put("&ucid", paramUPointPayInfo.getUsersession());
    hashMap.put("&sign", paramUPointPayInfo.getSign());
    hashMap.put("&uc_token", paramUPointPayInfo.getUctoken());
    hashMap.put("&pay_pwd", paramUPointPayInfo.getPaypwd());
    hashMap.put("&consume_time", paramUPointPayInfo.getTm());
    hashMap.put("&tm", paramUPointPayInfo.getTm());
    hashMap.put("&eid", UPointPayInfo.getEid());
    hashMap.put("&ch_code", paramUPointPayInfo.getChcode());
    (new ApiTask(paramContext, 3, paramTaskHandler, (HashMap)hashMap, "post")).execute((Object[])new Void[0]);
  }
  
  public static void postSmsPayment(Context paramContext, ApiTask.TaskHandler paramTaskHandler, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2) {
    String str1;
    String str2 = Utils.getSessionID(paramContext);
    String str4 = Utils.createARanConsumeID(20);
    String str3 = "";
    try {
      StringBuilder stringBuilder = new StringBuilder();
      if (str2.length() <= 5) {
        str1 = str2;
      } else {
        str1 = str2.substring(0, 5);
      } 
      this(String.valueOf(str1));
      if (paramString1.length() <= 5) {
        str1 = paramString1;
      } else {
        str1 = paramString1.substring(0, 5);
      } 
      stringBuilder = stringBuilder.append(str1);
      if (paramString2.length() <= 5) {
        str1 = paramString2;
      } else {
        str1 = paramString2.substring(0, 5);
      } 
      str1 = MD5.getMD5(stringBuilder.append(str1).append(paramInt1).toString());
    } catch (Exception exception) {
      str1 = str3;
    } 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(4);
    hashMap.put("user_id", str2);
    hashMap.put("cpid", paramString1);
    hashMap.put("gameid", paramString2);
    hashMap.put("optid", paramString3);
    hashMap.put("consume_id", str4);
    hashMap.put("charge", Integer.valueOf(paramInt1));
    hashMap.put("optobj", paramString4);
    hashMap.put("sms_channel", paramString5);
    hashMap.put("sms_port", paramString6);
    hashMap.put("sms_content", paramString7);
    hashMap.put("sms_type", Integer.valueOf(paramInt2));
    hashMap.put("sendtime", Utils.getCurrentTime(false));
    hashMap.put("sign", str1);
    (new ApiTask(paramContext, 8, paramTaskHandler, (HashMap)hashMap, "post")).execute((Object[])new Void[0]);
  }
  
  public static void queryUPointDiscount(Context paramContext, ApiTask.TaskHandler paramTaskHandler, String paramString1, String paramString2, int paramInt) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
    hashMap.put("cpid", paramString1);
    hashMap.put("gameid", paramString2);
    hashMap.put("u_money", Integer.valueOf(paramInt));
    (new ApiTask(paramContext, 18, paramTaskHandler, (HashMap)hashMap, "post")).execute((Object[])new Void[0]);
  }
  
  public static void syncChargeChannel(Context paramContext, ApiTask.TaskHandler paramTaskHandler) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
    hashMap.put("action", "getRechargeChannels");
    (new ApiTask(paramContext, 17, paramTaskHandler, (HashMap)hashMap, "post")).execute((Object[])new Void[0]);
  }
  
  public static void syncPayChannel(Context paramContext, ApiTask.TaskHandler paramTaskHandler) {
    (new ApiTask(paramContext, 6, paramTaskHandler, new HashMap<String, Object>(0), "post")).execute((Object[])new Void[0]);
  }
  
  public static void syncSmsInfo(Context paramContext, ApiTask.TaskHandler paramTaskHandler, String paramString1, String paramString2) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
    String str2 = Utils.getSessionID(paramContext);
    String str1 = str2;
    if (str2 == null) {
      str1 = Utils.createARanSessionid(8);
      PrefUtil.setUserSession(paramContext, str1);
    } 
    hashMap.put("user_id", str1);
    hashMap.put("cpid", paramString1);
    hashMap.put("gameid", paramString2);
    hashMap.put("area", "");
    hashMap.put("imsi", Utils.getSimNumber(paramContext));
    (new ApiTask(paramContext, 7, paramTaskHandler, (HashMap)hashMap, "post")).execute((Object[])new Void[0]);
  }
  
  public static void syncUPointDiscount(Context paramContext, ApiTask.TaskHandler paramTaskHandler, String paramString1, String paramString2, int paramInt) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
    hashMap.put("cpid", paramString1);
    hashMap.put("gameid", paramString2);
    hashMap.put("u_money", Integer.valueOf(paramInt));
    (new ApiTask(paramContext, 18, paramTaskHandler, (HashMap)hashMap, "post")).execute((Object[])new Void[0]);
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/network/Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */