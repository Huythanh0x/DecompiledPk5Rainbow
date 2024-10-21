package com.uc.paymentsdk.payment.sms;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.util.Constants;

/* loaded from: classes.dex */
public class SmsInfo {
    public static final String ACTION_SMS_SENT = "com.uc.androidsdk.SMS_SENT_ACTION";
    public boolean needconfirm = false;
    public String smsnumber = "";
    public String smsconfirmnumber = "";
    public String smsheader = "";
    public String smsconfirmheader = "";
    public String infobeforesend = "";
    public String extinfo = "";
    public int smstype = 0;
    public int money = 0;
    public String smschannelid = "";
    public String smsendtime = "";

    public void setExtInfo(PaymentInfo info) {
        String extinfostr = String.valueOf("") + info.getCpID();
        this.extinfo = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(extinfostr) + info.getmGameID()) + info.getmActionID()) + PaymentInfo.PHONETYPEID) + PaymentInfo.CHANNELID) + PaymentInfo.EXTINFO;
    }

    public String getExtInfo() {
        return this.extinfo;
    }

    public boolean isSuccess(String paramString) {
        return paramString.contains("确认支付");
    }

    public String getContent() {
        String smscontent = this.smsheader.replaceAll("\\(\\*\\)", "#");
        return String.valueOf(smscontent) + this.extinfo;
    }

    public String getSmsConfirmContent() {
        String smscontent = this.smsconfirmheader.replaceAll("\\(\\*\\)", "#");
        return String.valueOf(smscontent) + this.extinfo;
    }

    public static void sendSms(Context paramContext, String paramString1, String paramString2) throws SecurityException {
        SmsManager localSmsManager = SmsManager.getDefault();
        PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, new Intent(ACTION_SMS_SENT), 0);
        try {
            localSmsManager.sendTextMessage(paramString1, null, paramString2, localPendingIntent, null);
        } catch (SecurityException e) {
            throw e;
        }
    }

    public void sendFirstSms(Context paramContext) throws Exception {
        try {
            sendSms(paramContext, getSmsnumber(), getContent());
        } catch (Exception e) {
            throw e;
        }
    }

    public String parseConfirmSmsConfirmNumber(String paramString) {
        return paramString.substring(paramString.indexOf("请回复数字") + "请回复数字".length(), paramString.indexOf("确认支付"));
    }

    public boolean parseConfirmResultSms(String paramString) {
        return paramString.contains(Constants.TEXT_PAY_SMS_CONFRIM_RESULT_CONTAIN);
    }

    protected final String parseConfirmSmsSupportTelNumber(String paramString1, String paramString2) {
        try {
            return paramString1.substring(paramString1.lastIndexOf(paramString2) + paramString2.length());
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isNeedconfirm() {
        return this.needconfirm;
    }

    public void setSmsnumber(String smsnumber) {
        this.smsnumber = smsnumber;
    }

    public String getSmsConfirmNumber() {
        return this.smsconfirmnumber;
    }

    public void setSmsconfirmnumber(String smsconfirmnumber) {
        this.smsconfirmnumber = smsconfirmnumber;
    }

    public String getSmsheader() {
        return this.smsheader;
    }

    public void setSmsheader(String smsheader) {
        this.smsheader = smsheader;
    }

    public int getSmstype() {
        return this.smstype;
    }

    public void setSmstype(int smstype) {
        this.smstype = smstype;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getSmschannelid() {
        return this.smschannelid;
    }

    public void setSmschannelid(String smschannelid) {
        this.smschannelid = smschannelid;
    }

    public String getSmsendtime() {
        return this.smsendtime;
    }

    public void setSmsendtime(String smsendtime) {
        this.smsendtime = smsendtime;
    }

    public String getInfobeforesend() {
        return this.infobeforesend;
    }

    public void setInfobeforesend(String infobeforesend) {
        this.infobeforesend = infobeforesend;
    }

    public String getSmsconfirmheader() {
        return this.smsconfirmheader;
    }

    public void setSmsconfirmheader(String smsconfirmheader) {
        this.smsconfirmheader = smsconfirmheader;
    }

    public String getSmsnumber() {
        return this.smsnumber;
    }

    public String getSmsconfirmnumber() {
        return this.smsconfirmnumber;
    }

    public void setNeedconfirm(boolean needconfirm) {
        this.needconfirm = needconfirm;
    }
}
