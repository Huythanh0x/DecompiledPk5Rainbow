package com.uc.paymentsdk.payment.sms;

import com.uc.paymentsdk.payment.PaymentInfo;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.content.Context;

public class SmsInfo
{
    public static final String ACTION_SMS_SENT = "com.uc.androidsdk.SMS_SENT_ACTION";
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
    
    public SmsInfo() {
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
    
    public static void sendSms(final Context context, final String s, final String s2) throws SecurityException {
        final SmsManager default1 = SmsManager.getDefault();
        final PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("com.uc.androidsdk.SMS_SENT_ACTION"), 0);
        try {
            default1.sendTextMessage(s, (String)null, s2, broadcast, (PendingIntent)null);
        }
        catch (final SecurityException ex) {
            throw ex;
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
    
    public boolean isSuccess(final String s) {
        return s.contains("\u786e\u8ba4\u652f\u4ed8");
    }
    
    public boolean parseConfirmResultSms(final String s) {
        return s.contains("\u901a\u4fe1\u8d26\u6237\u652f\u4ed8");
    }
    
    public String parseConfirmSmsConfirmNumber(final String s) {
        return s.substring(s.indexOf("\u8bf7\u56de\u590d\u6570\u5b57") + "\u8bf7\u56de\u590d\u6570\u5b57".length(), s.indexOf("\u786e\u8ba4\u652f\u4ed8"));
    }
    
    protected final String parseConfirmSmsSupportTelNumber(String substring, final String str) {
        try {
            substring = substring.substring(substring.lastIndexOf(str) + str.length());
            return substring;
        }
        catch (final Exception ex) {
            substring = "";
            return substring;
        }
    }
    
    public void sendFirstSms(final Context context) throws Exception {
        try {
            sendSms(context, this.getSmsnumber(), this.getContent());
        }
        catch (final Exception ex) {
            throw ex;
        }
    }
    
    public void setExtInfo(final PaymentInfo paymentInfo) {
        this.extinfo = String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("")).append(paymentInfo.getCpID()).toString())).append(paymentInfo.getmGameID()).toString())).append(paymentInfo.getmActionID()).toString())).append("99").toString())).append("70").toString()) + "00";
    }
    
    public void setInfobeforesend(final String infobeforesend) {
        this.infobeforesend = infobeforesend;
    }
    
    public void setMoney(final int money) {
        this.money = money;
    }
    
    public void setNeedconfirm(final boolean needconfirm) {
        this.needconfirm = needconfirm;
    }
    
    public void setSmschannelid(final String smschannelid) {
        this.smschannelid = smschannelid;
    }
    
    public void setSmsconfirmheader(final String smsconfirmheader) {
        this.smsconfirmheader = smsconfirmheader;
    }
    
    public void setSmsconfirmnumber(final String smsconfirmnumber) {
        this.smsconfirmnumber = smsconfirmnumber;
    }
    
    public void setSmsendtime(final String smsendtime) {
        this.smsendtime = smsendtime;
    }
    
    public void setSmsheader(final String smsheader) {
        this.smsheader = smsheader;
    }
    
    public void setSmsnumber(final String smsnumber) {
        this.smsnumber = smsnumber;
    }
    
    public void setSmstype(final int smstype) {
        this.smstype = smstype;
    }
}
