/*
 * Decompiled with CFR.
 */
package com.uc.paymentsdk.payment;

import java.io.Serializable;

public class PaymentInfo
implements Serializable {
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

    public PaymentInfo(String string, String string2, String string3, String string4, int n) {
        this(string, string2, string3, string4, n, PAYTYPE_SMS, null, null);
    }

    public PaymentInfo(String string, String string2, String string3, String string4, int n, String string5) {
        this(string, string2, string3, string4, n, PAYTYPE_SMS, string5, null);
    }

    public PaymentInfo(String string, String string2, String string3, String string4, int n, String string5, String string6, String string7) {
        this.mPayName = string;
        this.mPayDesc = string4;
        this.mMoney = n;
        this.mPayType = string5;
        this.mOrderID = string6;
        this.mUsername = string7;
        this.mGameID = string2;
        this.mActionID = string3;
    }

    public String getAppkey() {
        return this.mAppkey;
    }

    public String getCpID() {
        return this.mCpID;
    }

    public int getMoney() {
        return this.mMoney;
    }

    public String getOrderID() {
        return this.mOrderID;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public String getPaydesc() {
        return this.mPayDesc;
    }

    public String getPayname() {
        return this.mPayName;
    }

    public String getPaytype() {
        return this.mPayType;
    }

    public String getUsername() {
        return this.mUsername;
    }

    public String getmActionID() {
        return this.mActionID;
    }

    public String getmGameID() {
        return this.mGameID;
    }

    public void setAppkey(String string) {
        this.mAppkey = string;
    }

    public void setCpID(String string) {
        this.mCpID = string;
    }

    public void setMoney(int n) {
        this.mMoney = n;
    }

    public void setOrderID(String string) {
        this.mOrderID = string;
    }

    public void setPassword(String string) {
        this.mPassword = string;
    }

    public void setPaydesc(String string) {
        this.mPayDesc = string;
    }

    public void setPayname(String string) {
        this.mPayName = string;
    }

    public void setPaytype(String string) {
        this.mPayType = string;
    }

    public void setUsername(String string) {
        this.mUsername = string;
    }

    public void setmActionID(String string) {
        this.mActionID = string;
    }

    public void setmGameID(String string) {
        this.mGameID = string;
    }
}
