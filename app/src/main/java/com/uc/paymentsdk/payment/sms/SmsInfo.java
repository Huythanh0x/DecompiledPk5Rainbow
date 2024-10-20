package com.uc.paymentsdk.payment.sms;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import com.uc.paymentsdk.payment.PaymentInfo;

public class SmsInfo {
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

    public boolean isSuccess(String paramString) {
        return paramString.contains("确认支付");
    }

    public boolean parseConfirmResultSms(String paramString) {
        return paramString.contains("通信账户支付");
    }

    public String parseConfirmSmsConfirmNumber(String paramString) {
        return paramString.substring(paramString.indexOf("请回复数字") + 5, paramString.indexOf("确认支付"));
    }

    protected final String parseConfirmSmsSupportTelNumber(String paramString1, String paramString2) {
        return paramString1.substring(paramString1.lastIndexOf(paramString2) + paramString2.length());
    }

    // Deobfuscation rating: LOW(30)
    public void sendFirstSms(Context paramContext) throws Exception {
        SmsManager.getDefault().sendTextMessage("", null, "", PendingIntent.getBroadcast(paramContext, 0, new Intent("com.uc.androidsdk.SMS_SENT_ACTION"), 0), null);
    }

    public static void sendSms(Context paramContext, String paramString1, String paramString2) throws SecurityException [...] // Inlined contents

    public void setExtInfo(PaymentInfo info) {
        this.extinfo = "" + info.getCpID() + info.getmGameID() + info.getmActionID() + "99" + "70" + "00";
    }

    public void setInfobeforesend(String infobeforesend) {
        this.infobeforesend = infobeforesend;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setNeedconfirm(boolean needconfirm) {
        this.needconfirm = needconfirm;
    }

    public void setSmschannelid(String smschannelid) {
        this.smschannelid = smschannelid;
    }

    public void setSmsconfirmheader(String smsconfirmheader) {
        this.smsconfirmheader = smsconfirmheader;
    }

    public void setSmsconfirmnumber(String smsconfirmnumber) {
        this.smsconfirmnumber = smsconfirmnumber;
    }

    public void setSmsendtime(String smsendtime) {
        this.smsendtime = smsendtime;
    }

    public void setSmsheader(String smsheader) {
        this.smsheader = smsheader;
    }

    public void setSmsnumber(String smsnumber) {
        this.smsnumber = smsnumber;
    }

    public void setSmstype(int smstype) {
        this.smstype = smstype;
    }
}

