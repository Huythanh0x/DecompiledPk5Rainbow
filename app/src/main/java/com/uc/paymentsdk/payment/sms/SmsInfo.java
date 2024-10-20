/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.telephony.SmsManager
 *  com.uc.paymentsdk.payment.PaymentInfo
 */
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

    public static void sendSms(Context context, String string, String string2) throws SecurityException {
        SmsManager smsManager = SmsManager.getDefault();
        context = PendingIntent.getBroadcast((Context)context, (int)0, (Intent)new Intent(ACTION_SMS_SENT), (int)0);
        smsManager.sendTextMessage(string, null, string2, (PendingIntent)context, null);
        return;
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

    public boolean isSuccess(String string) {
        return string.contains("\u786e\u8ba4\u652f\u4ed8");
    }

    public boolean parseConfirmResultSms(String string) {
        return string.contains("\u901a\u4fe1\u8d26\u6237\u652f\u4ed8");
    }

    public String parseConfirmSmsConfirmNumber(String string) {
        return string.substring(string.indexOf("\u8bf7\u56de\u590d\u6570\u5b57") + "\u8bf7\u56de\u590d\u6570\u5b57".length(), string.indexOf("\u786e\u8ba4\u652f\u4ed8"));
    }

    /*
     * Enabled force condition propagation
     */
    protected final String parseConfirmSmsSupportTelNumber(String string, String string2) {
        try {
            return string.substring(string.lastIndexOf(string2) + string2.length());
        }
        catch (Exception exception) {
            return "";
        }
    }

    public void sendFirstSms(Context context) throws Exception {
        SmsInfo.sendSms(context, this.getSmsnumber(), this.getContent());
        return;
    }

    public void setExtInfo(PaymentInfo paymentInfo) {
        this.extinfo = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf("") + paymentInfo.getCpID()) + paymentInfo.getmGameID()) + paymentInfo.getmActionID()) + "99") + "70") + "00";
    }

    public void setInfobeforesend(String string) {
        this.infobeforesend = string;
    }

    public void setMoney(int n) {
        this.money = n;
    }

    public void setNeedconfirm(boolean bl) {
        this.needconfirm = bl;
    }

    public void setSmschannelid(String string) {
        this.smschannelid = string;
    }

    public void setSmsconfirmheader(String string) {
        this.smsconfirmheader = string;
    }

    public void setSmsconfirmnumber(String string) {
        this.smsconfirmnumber = string;
    }

    public void setSmsendtime(String string) {
        this.smsendtime = string;
    }

    public void setSmsheader(String string) {
        this.smsheader = string;
    }

    public void setSmsnumber(String string) {
        this.smsnumber = string;
    }

    public void setSmstype(int n) {
        this.smstype = n;
    }
}
