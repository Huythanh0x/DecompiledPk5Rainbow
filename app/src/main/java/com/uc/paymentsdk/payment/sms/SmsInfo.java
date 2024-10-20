package com.uc.paymentsdk.payment.sms;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import com.uc.paymentsdk.payment.PaymentInfo;

public class SmsInfo {
  public static final String ACTION_SMS_SENT = "com.uc.androidsdk.SMS_SENT_ACTION";
  
  public String extinfo = "";
  
  public String infobeforesend = "";
  
  public int money = 0;
  
  public boolean needconfirm = false;
  
  public String smschannelid = "";
  
  public String smsconfirmheader = "";
  
  public String smsconfirmnumber = "";
  
  public String smsendtime = "";
  
  public String smsheader = "";
  
  public String smsnumber = "";
  
  public int smstype = 0;
  
  public static void sendSms(Context paramContext, String paramString1, String paramString2) throws SecurityException {
    SmsManager smsManager = SmsManager.getDefault();
    PendingIntent pendingIntent = PendingIntent.getBroadcast(paramContext, 0, new Intent("com.uc.androidsdk.SMS_SENT_ACTION"), 0);
    try {
      smsManager.sendTextMessage(paramString1, null, paramString2, pendingIntent, null);
      return;
    } catch (SecurityException securityException) {
      throw securityException;
    } 
  }
  
  public String getContent() {
    return String.valueOf(this.smsheader.replaceAll("\\(\\*\\)", "#")) + this.extinfo;
  }
  
  public String getExtInfo() {
    return this.extinfo;
  }
  
  public String getInfobeforesend() {
    return this.infobeforesend;
  }
  
  public int getMoney() {
    return this.money;
  }
  
  public String getSmsConfirmContent() {
    return String.valueOf(this.smsconfirmheader.replaceAll("\\(\\*\\)", "#")) + this.extinfo;
  }
  
  public String getSmsConfirmNumber() {
    return this.smsconfirmnumber;
  }
  
  public String getSmschannelid() {
    return this.smschannelid;
  }
  
  public String getSmsconfirmheader() {
    return this.smsconfirmheader;
  }
  
  public String getSmsconfirmnumber() {
    return this.smsconfirmnumber;
  }
  
  public String getSmsendtime() {
    return this.smsendtime;
  }
  
  public String getSmsheader() {
    return this.smsheader;
  }
  
  public String getSmsnumber() {
    return this.smsnumber;
  }
  
  public int getSmstype() {
    return this.smstype;
  }
  
  public boolean isNeedconfirm() {
    return this.needconfirm;
  }
  
  public boolean isSuccess(String paramString) {
    return paramString.contains("确认支付");
  }
  
  public boolean parseConfirmResultSms(String paramString) {
    return paramString.contains("通信账户支付");
  }
  
  public String parseConfirmSmsConfirmNumber(String paramString) {
    return paramString.substring(paramString.indexOf("请回复数字") + "请回复数字".length(), paramString.indexOf("确认支付"));
  }
  
  protected final String parseConfirmSmsSupportTelNumber(String paramString1, String paramString2) {
    String str;
    try {
      paramString1 = paramString1.substring(paramString1.lastIndexOf(paramString2) + paramString2.length());
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public void sendFirstSms(Context paramContext) throws Exception {
    try {
      sendSms(paramContext, getSmsnumber(), getContent());
      return;
    } catch (Exception exception) {
      throw exception;
    } 
  }
  
  public void setExtInfo(PaymentInfo paramPaymentInfo) {
    this.extinfo = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf("") + paramPaymentInfo.getCpID()) + paramPaymentInfo.getmGameID()) + paramPaymentInfo.getmActionID()) + "99") + "70") + "00";
  }
  
  public void setInfobeforesend(String paramString) {
    this.infobeforesend = paramString;
  }
  
  public void setMoney(int paramInt) {
    this.money = paramInt;
  }
  
  public void setNeedconfirm(boolean paramBoolean) {
    this.needconfirm = paramBoolean;
  }
  
  public void setSmschannelid(String paramString) {
    this.smschannelid = paramString;
  }
  
  public void setSmsconfirmheader(String paramString) {
    this.smsconfirmheader = paramString;
  }
  
  public void setSmsconfirmnumber(String paramString) {
    this.smsconfirmnumber = paramString;
  }
  
  public void setSmsendtime(String paramString) {
    this.smsendtime = paramString;
  }
  
  public void setSmsheader(String paramString) {
    this.smsheader = paramString;
  }
  
  public void setSmsnumber(String paramString) {
    this.smsnumber = paramString;
  }
  
  public void setSmstype(int paramInt) {
    this.smstype = paramInt;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/payment/sms/SmsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */