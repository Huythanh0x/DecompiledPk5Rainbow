package com.uc.paymentsdk.payment;

import java.io.Serializable;

/* loaded from: classes.dex */
public class PaymentInfo implements Serializable {
    public static final String CHANNELID = "70";
    public static final String EXTINFO = "00";
    public static final String PAYTYPE_ALL = "all";
    public static final String PAYTYPE_OVERAGE = "overage";
    public static final String PAYTYPE_SMS = "sms";
    public static final String PHONETYPEID = "99";
    private String mActionID;
    private String mAppkey;
    private String mCpID;
    private String mGameID;
    private int mMoney;
    private String mOrderID;
    private String mPassword;
    private String mPayDesc;
    private String mPayName;
    private String mPayType;
    private String mUsername;

    public PaymentInfo(String payname, String gameid, String actionid, String paydesc, int paymoney) {
        this(payname, gameid, actionid, paydesc, paymoney, "sms", null, null);
    }

    public PaymentInfo(String payname, String gameid, String actionid, String paydesc, int paymoney, String orderid) {
        this(payname, gameid, actionid, paydesc, paymoney, "sms", orderid, null);
    }

    public PaymentInfo(String payname, String gameid, String actionid, String paydesc, int paymoney, String paytype, String orderid, String username) {
        this.mPayName = payname;
        this.mPayDesc = paydesc;
        this.mMoney = paymoney;
        this.mPayType = paytype;
        this.mOrderID = orderid;
        this.mUsername = username;
        this.mGameID = gameid;
        this.mActionID = actionid;
    }

    public String getUsername() {
        return this.mUsername;
    }

    public void setUsername(String paramString) {
        this.mUsername = paramString;
    }

    public String getPayname() {
        return this.mPayName;
    }

    public void setPayname(String paramString) {
        this.mPayName = paramString;
    }

    public int getMoney() {
        return this.mMoney;
    }

    public void setMoney(int paramInt) {
        this.mMoney = paramInt;
    }

    public String getPaytype() {
        return this.mPayType;
    }

    public void setPaytype(String paramString) {
        this.mPayType = paramString;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public void setPassword(String paramString) {
        this.mPassword = paramString;
    }

    public String getPaydesc() {
        return this.mPayDesc;
    }

    public void setPaydesc(String paramString) {
        this.mPayDesc = paramString;
    }

    public String getAppkey() {
        return this.mAppkey;
    }

    public void setAppkey(String paramString) {
        this.mAppkey = paramString;
    }

    public String getOrderID() {
        return this.mOrderID;
    }

    public void setOrderID(String paramString) {
        this.mOrderID = paramString;
    }

    public String getCpID() {
        return this.mCpID;
    }

    public void setCpID(String paramString) {
        this.mCpID = paramString;
    }

    public String getmGameID() {
        return this.mGameID;
    }

    public void setmGameID(String mGameID) {
        this.mGameID = mGameID;
    }

    public String getmActionID() {
        return this.mActionID;
    }

    public void setmActionID(String mActionID) {
        this.mActionID = mActionID;
    }
}
