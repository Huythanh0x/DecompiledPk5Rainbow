package com.uc.paymentsdk.network.Api;
import java.lang.Object;
import android.content.Context;
import com.uc.paymentsdk.network.ApiTask$TaskHandler;
import java.lang.String;
import java.util.HashMap;
import com.uc.paymentsdk.network.ApiTask;
import java.lang.Void;
import android.os.AsyncTask;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import java.lang.Integer;
import com.uc.paymentsdk.util.Utils;
import java.lang.StringBuilder;
import com.uc.paymentsdk.commons.codec.MD5;
import com.uc.paymentsdk.util.PrefUtil;

public class Api	// class@00009e from classes.dex
{

    public void Api(){
       super();
    }
    public static void confirmPayResult(Context paramContext,ApiTask$TaskHandler paramTaskHandler,String paramString1,String paramString2){
       HashMap localHashMap = new HashMap(2);
       localHashMap.put("order_id", paramString1);
       localHashMap.put("app_key", paramString2);
       Void[] voidArray = new Void[0];
       new ApiTask(paramContext, 5, paramTaskHandler, localHashMap, "post").execute(voidArray);
    }
    public static void pay(Context paramContext,ApiTask$TaskHandler paramTaskHandler,PaymentInfo paramPaymentInfo,UPointPayInfo upayinfo){
       HashMap localHashMap = new HashMap(9);
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
       Void[] voidArray = new Void[0];
       new ApiTask(paramContext, 3, paramTaskHandler, localHashMap, "post").execute(voidArray);
    }
    public static void postSmsPayment(Context paramContext,ApiTask$TaskHandler paramTaskHandler,String cpid,String gameid,String optid,int charge,String optobj,String sms_channel,String sms_port,String sms_content,int sms_type){
       String sign;
       String usersession = Utils.getSessionID(paramContext);
       String consumeid = Utils.createARanConsumeID(20);
       try{
          sign = "";
          String str = (usersession.length() <= 5)? usersession: usersession.substring(0, 5);
          StringBuilder str1 = String.valueOf(str);
          str = (cpid.length() <= 5)? cpid: cpid.substring(0, 5);
          str1 = str1+str;
          str = (gameid.length() <= 5)? gameid: gameid.substring(0, 5);
          sign = MD5.getMD5(str1+str+charge);
       }catch(java.lang.Exception e3){
       }
       HashMap localHashMap = new HashMap(4);
       localHashMap.put("user_id", usersession);
       usersession = "cpid";
       localHashMap.put(usersession, cpid);
       cpid = "gameid";
       localHashMap.put(cpid, gameid);
       localHashMap.put("optid", optid);
       localHashMap.put("consume_id", consumeid);
       gameid = Integer.valueOf(charge);
       localHashMap.put("charge", gameid);
       localHashMap.put("optobj", optobj);
       localHashMap.put("sms_channel", sms_channel);
       localHashMap.put("sms_port", sms_port);
       localHashMap.put("sms_content", sms_content);
       localHashMap.put("sms_type", Integer.valueOf(sms_type));
       localHashMap.put("sendtime", Utils.getCurrentTime(false));
       localHashMap.put("sign", sign);
       sign = paramContext;
       paramContext = null;
       paramContext = new Conte[paramContext];
       new ApiTask(sign, 8, paramTaskHandler, localHashMap, "post").execute(paramContext);
       return;
    }
    public static void queryUPointDiscount(Context paramContext,ApiTask$TaskHandler paramTaskHandler,String cpid,String gameid,int charge){
       HashMap localHashMap = new HashMap(1);
       localHashMap.put("cpid", cpid);
       localHashMap.put("gameid", gameid);
       localHashMap.put("u_money", Integer.valueOf(charge));
       Void[] voidArray = new Void[0];
       new ApiTask(paramContext, 18, paramTaskHandler, localHashMap, "post").execute(voidArray);
    }
    public static void syncChargeChannel(Context paramContext,ApiTask$TaskHandler paramTaskHandler){
       HashMap localHashMap = new HashMap(1);
       localHashMap.put("action", "getRechargeChannels");
       Void[] voidArray = new Void[0];
       new ApiTask(paramContext, 17, paramTaskHandler, localHashMap, "post").execute(voidArray);
    }
    public static void syncPayChannel(Context paramContext,ApiTask$TaskHandler paramTaskHandler){
       HashMap localHashMap = new HashMap(0);
       Void[] voidArray = new Void[0];
       new ApiTask(paramContext, 6, paramTaskHandler, localHashMap, "post").execute(voidArray);
    }
    public static void syncSmsInfo(Context paramContext,ApiTask$TaskHandler paramTaskHandler,String cpid,String gameid){
       String usersession;
       HashMap localHashMap = new HashMap(1);
       if ((usersession = Utils.getSessionID(paramContext)) == null) {
          usersession = Utils.createARanSessionid(8);
          PrefUtil.setUserSession(paramContext, usersession);
       }
       localHashMap.put("user_id", usersession);
       localHashMap.put("cpid", cpid);
       localHashMap.put("gameid", gameid);
       localHashMap.put("area", "");
       localHashMap.put("imsi", Utils.getSimNumber(paramContext));
       Void[] voidArray = new Void[0];
       new ApiTask(paramContext, 7, paramTaskHandler, localHashMap, "post").execute(voidArray);
       return;
    }
    public static void syncUPointDiscount(Context paramContext,ApiTask$TaskHandler paramTaskHandler,String cpid,String gameid,int charge){
       HashMap localHashMap = new HashMap(1);
       localHashMap.put("cpid", cpid);
       localHashMap.put("gameid", gameid);
       localHashMap.put("u_money", Integer.valueOf(charge));
       Void[] voidArray = new Void[0];
       new ApiTask(paramContext, 18, paramTaskHandler, localHashMap, "post").execute(voidArray);
    }
}
