package com.uc.paymentsdk.payment;

import java.io.Serializable;

public class PaymentInfo implements Serializable
{
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
    
    public PaymentInfo(final String s, final String s2, final String s3, final String s4, final int n) {
        this(s, s2, s3, s4, n, "sms", null, null);
    }
    
    public PaymentInfo(final String s, final String s2, final String s3, final String s4, final int n, final String s5) {
        this(s, s2, s3, s4, n, "sms", s5, null);
    }
    
    public PaymentInfo(final String mPayName, final String mGameID, final String mActionID, final String mPayDesc, final int mMoney, final String mPayType, final String mOrderID, final String mUsername) {
        super();
        this.mPayName = mPayName;
        this.mPayDesc = mPayDesc;
        this.mMoney = mMoney;
        this.mPayType = mPayType;
        this.mOrderID = mOrderID;
        this.mUsername = mUsername;
        this.mGameID = mGameID;
        this.mActionID = mActionID;
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
    
    public void setAppkey(final String mAppkey) {
        this.mAppkey = mAppkey;
    }
    
    public void setCpID(final String mCpID) {
        this.mCpID = mCpID;
    }
    
    public void setMoney(final int mMoney) {
        this.mMoney = mMoney;
    }
    
    public void setOrderID(final String mOrderID) {
        this.mOrderID = mOrderID;
    }
    
    public void setPassword(final String mPassword) {
        this.mPassword = mPassword;
    }
    
    public void setPaydesc(final String mPayDesc) {
        this.mPayDesc = mPayDesc;
    }
    
    public void setPayname(final String mPayName) {
        this.mPayName = mPayName;
    }
    
    public void setPaytype(final String mPayType) {
        this.mPayType = mPayType;
    }
    
    public void setUsername(final String mUsername) {
        this.mUsername = mUsername;
    }
    
    public void setmActionID(final String mActionID) {
        this.mActionID = mActionID;
    }
    
    public void setmGameID(final String mGameID) {
        this.mGameID = mGameID;
    }
}
