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

   public PaymentInfo(String var1, String var2, String var3, String var4, int var5) {
      this(var1, var2, var3, var4, var5, "sms", (String)null, (String)null);
   }

   public PaymentInfo(String var1, String var2, String var3, String var4, int var5, String var6) {
      this(var1, var2, var3, var4, var5, "sms", var6, (String)null);
   }

   public PaymentInfo(String var1, String var2, String var3, String var4, int var5, String var6, String var7, String var8) {
      super();
      this.mPayName = var1;
      this.mPayDesc = var4;
      this.mMoney = var5;
      this.mPayType = var6;
      this.mOrderID = var7;
      this.mUsername = var8;
      this.mGameID = var2;
      this.mActionID = var3;
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

   public void setAppkey(String var1) {
      this.mAppkey = var1;
   }

   public void setCpID(String var1) {
      this.mCpID = var1;
   }

   public void setMoney(int var1) {
      this.mMoney = var1;
   }

   public void setOrderID(String var1) {
      this.mOrderID = var1;
   }

   public void setPassword(String var1) {
      this.mPassword = var1;
   }

   public void setPaydesc(String var1) {
      this.mPayDesc = var1;
   }

   public void setPayname(String var1) {
      this.mPayName = var1;
   }

   public void setPaytype(String var1) {
      this.mPayType = var1;
   }

   public void setUsername(String var1) {
      this.mUsername = var1;
   }

   public void setmActionID(String var1) {
      this.mActionID = var1;
   }

   public void setmGameID(String var1) {
      this.mGameID = var1;
   }
}
