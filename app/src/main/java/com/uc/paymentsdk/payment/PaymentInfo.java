package com.uc.paymentsdk.payment;

import java.io.Serializable;

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
  
  public PaymentInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {
    this(paramString1, paramString2, paramString3, paramString4, paramInt, "sms", null, null);
  }
  
  public PaymentInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5) {
    this(paramString1, paramString2, paramString3, paramString4, paramInt, "sms", paramString5, null);
  }
  
  public PaymentInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7) {
    this.mPayName = paramString1;
    this.mPayDesc = paramString4;
    this.mMoney = paramInt;
    this.mPayType = paramString5;
    this.mOrderID = paramString6;
    this.mUsername = paramString7;
    this.mGameID = paramString2;
    this.mActionID = paramString3;
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
  
  public void setAppkey(String paramString) {
    this.mAppkey = paramString;
  }
  
  public void setCpID(String paramString) {
    this.mCpID = paramString;
  }
  
  public void setMoney(int paramInt) {
    this.mMoney = paramInt;
  }
  
  public void setOrderID(String paramString) {
    this.mOrderID = paramString;
  }
  
  public void setPassword(String paramString) {
    this.mPassword = paramString;
  }
  
  public void setPaydesc(String paramString) {
    this.mPayDesc = paramString;
  }
  
  public void setPayname(String paramString) {
    this.mPayName = paramString;
  }
  
  public void setPaytype(String paramString) {
    this.mPayType = paramString;
  }
  
  public void setUsername(String paramString) {
    this.mUsername = paramString;
  }
  
  public void setmActionID(String paramString) {
    this.mActionID = paramString;
  }
  
  public void setmGameID(String paramString) {
    this.mGameID = paramString;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/payment/PaymentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */