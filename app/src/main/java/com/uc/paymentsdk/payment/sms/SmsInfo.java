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

   public SmsInfo() {
      super();
   }

   public static void sendSms(Context var0, String var1, String var2) throws SecurityException {
      SmsManager var3 = SmsManager.getDefault();
      PendingIntent var5 = PendingIntent.getBroadcast(var0, 0, new Intent("com.uc.androidsdk.SMS_SENT_ACTION"), 0);

      try {
         var3.sendTextMessage(var1, (String)null, var2, var5, (PendingIntent)null);
      } catch (SecurityException var4) {
         throw var4;
      }
   }

   public String getContent() {
      return this.smsheader.replaceAll("\\(\\*\\)", "#") + this.extinfo;
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
      return this.smsconfirmheader.replaceAll("\\(\\*\\)", "#") + this.extinfo;
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

   public boolean isSuccess(String var1) {
      return var1.contains("\u786e\u8ba4\u652f\u4ed8");
   }

   public boolean parseConfirmResultSms(String var1) {
      return var1.contains("\u901a\u4fe1\u8d26\u6237\u652f\u4ed8");
   }

   public String parseConfirmSmsConfirmNumber(String var1) {
      return var1.substring(var1.indexOf("\u8bf7\u56de\u590d\u6570\u5b57") + "\u8bf7\u56de\u590d\u6570\u5b57".length(), var1.indexOf("\u786e\u8ba4\u652f\u4ed8"));
   }

   protected final String parseConfirmSmsSupportTelNumber(String var1, String var2) {
      try {
         var1 = var1.substring(var1.lastIndexOf(var2) + var2.length());
      } catch (Exception var3) {
         var1 = "";
      }

      return var1;
   }

   public void sendFirstSms(Context var1) throws Exception {
      try {
         sendSms(var1, this.getSmsnumber(), this.getContent());
      } catch (Exception var2) {
         throw var2;
      }
   }

   public void setExtInfo(PaymentInfo var1) {
      this.extinfo = "" + var1.getCpID() + var1.getmGameID() + var1.getmActionID() + "99" + "70" + "00";
   }

   public void setInfobeforesend(String var1) {
      this.infobeforesend = var1;
   }

   public void setMoney(int var1) {
      this.money = var1;
   }

   public void setNeedconfirm(boolean var1) {
      this.needconfirm = var1;
   }

   public void setSmschannelid(String var1) {
      this.smschannelid = var1;
   }

   public void setSmsconfirmheader(String var1) {
      this.smsconfirmheader = var1;
   }

   public void setSmsconfirmnumber(String var1) {
      this.smsconfirmnumber = var1;
   }

   public void setSmsendtime(String var1) {
      this.smsendtime = var1;
   }

   public void setSmsheader(String var1) {
      this.smsheader = var1;
   }

   public void setSmsnumber(String var1) {
      this.smsnumber = var1;
   }

   public void setSmstype(int var1) {
      this.smstype = var1;
   }
}
