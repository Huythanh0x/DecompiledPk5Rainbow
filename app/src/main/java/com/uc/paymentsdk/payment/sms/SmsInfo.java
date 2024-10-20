package com.uc.paymentsdk.payment.sms.SmsInfo;
import java.lang.Object;
import android.content.Context;
import java.lang.String;
import android.telephony.SmsManager;
import android.content.Intent;
import android.app.PendingIntent;
import java.lang.StringBuilder;
import java.lang.CharSequence;
import com.uc.paymentsdk.payment.PaymentInfo;

public class SmsInfo	// class@0000b7 from classes.dex
{
    public String extinfo;
    public String infobeforesend;
    public int money;
    public boolean needconfirm;
    public String smschannelid;
    public String smsconfirmheader;
    public String smsconfirmnumber;
    public String smsendtime;
    public String smsheader;
    public String smsnumber;
    public int smstype;
    public static final String ACTION_SMS_SENT = "com.uc.androidsdk.SMS_SENT_ACTION";

    public void SmsInfo(){
       super();
       this.needconfirm = false;
       this.smsnumber = "";
       this.smsconfirmnumber = "";
       this.smsheader = "";
       this.smsconfirmheader = "";
       this.infobeforesend = "";
       this.extinfo = "";
       this.smstype = 0;
       this.money = 0;
       this.smschannelid = "";
       this.smsendtime = "";
    }
    public static void sendSms(Context paramContext,String paramString1,String paramString2){
       SmsManager localSmsManager = SmsManager.getDefault();
       PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, new Intent("com.uc.androidsdk.SMS_SENT_ACTION"), 0);
       String str = paramString1;
       try{
          int i = paramString2;
          localSmsManager.sendTextMessage(str, null, i, localPendingIntent, null);
          return;
       }catch(java.lang.SecurityException e6){
          throw e6;
       }
    }
    public String getContent(){
       String smscontent = this.smsheader.replaceAll("\\\(\\*\\\)", "#");
       smscontent = String.valueOf(smscontent)+this.extinfo;
       return smscontent;
    }
    public String getExtInfo(){
       return this.extinfo;
    }
    public String getInfobeforesend(){
       return this.infobeforesend;
    }
    public int getMoney(){
       return this.money;
    }
    public String getSmsConfirmContent(){
       String smscontent = this.smsconfirmheader.replaceAll("\\\(\\*\\\)", "#");
       smscontent = String.valueOf(smscontent)+this.extinfo;
       return smscontent;
    }
    public String getSmsConfirmNumber(){
       return this.smsconfirmnumber;
    }
    public String getSmschannelid(){
       return this.smschannelid;
    }
    public String getSmsconfirmheader(){
       return this.smsconfirmheader;
    }
    public String getSmsconfirmnumber(){
       return this.smsconfirmnumber;
    }
    public String getSmsendtime(){
       return this.smsendtime;
    }
    public String getSmsheader(){
       return this.smsheader;
    }
    public String getSmsnumber(){
       return this.smsnumber;
    }
    public int getSmstype(){
       return this.smstype;
    }
    public boolean isNeedconfirm(){
       return this.needconfirm;
    }
    public boolean isSuccess(String paramString){
       return paramString.contains("\x78\x02\x8b\x02\x65\x02\x4e\x02");
    }
    public boolean parseConfirmResultSms(String paramString){
       return paramString.contains("\x90\x02\x4f\x02\x8d\x02\x62\x02\x65\x02\x4e\x02");
    }
    public String parseConfirmSmsConfirmNumber(String paramString){
       return paramString.substring((paramString.indexOf("\x8b\x02\x56\x02\x59\x02\x65\x02\x5b\x02") + "\x8b\x02\x56\x02\x59\x02\x65\x02\x5b\x02".length()), paramString.indexOf("\x78\x02\x8b\x02\x65\x02\x4e\x02"));
    }
    protected final String parseConfirmSmsSupportTelNumber(String paramString1,String paramString2){
       String str;
       try{
          str = paramString1.substring((paramString1.lastIndexOf(paramString2) + paramString2.length()));
       }catch(java.lang.Exception e0){
          str = "";
       }
       return str;
    }
    public void sendFirstSms(Context paramContext){
       try{
          SmsInfo.sendSms(paramContext, this.getSmsnumber(), this.getContent());
          return;
       }catch(java.lang.Exception e1){
          Exception e = e1;
          throw e;
       }
    }
    public void setExtInfo(PaymentInfo info){
       String extinfostr = "";
       extinfostr = String.valueOf(extinfostr)+info.getCpID();
       extinfostr = String.valueOf(extinfostr)+info.getmGameID();
       extinfostr = String.valueOf(extinfostr)+info.getmActionID();
       extinfostr = String.valueOf(extinfostr)+"99";
       extinfostr = String.valueOf(extinfostr)+"70";
       extinfostr = String.valueOf(extinfostr)+"00";
       this.extinfo = extinfostr;
    }
    public void setInfobeforesend(String infobeforesend){
       this.infobeforesend = infobeforesend;
    }
    public void setMoney(int money){
       this.money = money;
    }
    public void setNeedconfirm(boolean needconfirm){
       this.needconfirm = needconfirm;
    }
    public void setSmschannelid(String smschannelid){
       this.smschannelid = smschannelid;
    }
    public void setSmsconfirmheader(String smsconfirmheader){
       this.smsconfirmheader = smsconfirmheader;
    }
    public void setSmsconfirmnumber(String smsconfirmnumber){
       this.smsconfirmnumber = smsconfirmnumber;
    }
    public void setSmsendtime(String smsendtime){
       this.smsendtime = smsendtime;
    }
    public void setSmsheader(String smsheader){
       this.smsheader = smsheader;
    }
    public void setSmsnumber(String smsnumber){
       this.smsnumber = smsnumber;
    }
    public void setSmstype(int smstype){
       this.smstype = smstype;
    }
}
