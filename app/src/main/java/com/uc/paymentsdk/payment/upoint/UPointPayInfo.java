package com.uc.paymentsdk.payment.upoint;

import android.content.Context;
import com.uc.paymentsdk.commons.codec.MD5;
import com.uc.paymentsdk.util.Utils;

public class UPointPayInfo {
   private static final String EID = "4";
   private String chcode = "70";
   private String consumeid = "";
   private String cpid = "";
   private String gameid = "";
   private Context paramcontext;
   private String paypwd = "";
   private String paypwdtoken = "";
   private String sign = "";
   private String tm = "";
   private String uctoken = "";
   private int umoney;
   private int upoint;
   private String userid = "";
   private String userpass = "";
   private String usersession = "";

   public UPointPayInfo(String var1, String var2, String var3, String var4, String var5, int var6, String var7) {
      super();
      this.setUserid(var1);
      this.setUserpass(var2);
      this.setPaypwd(var3);
      this.setCpid(var4);
      this.setGameid(var5);
      this.setTm(var7);
      this.setUpoint(var6);
      if (this.tm == null || this.tm.length() < 1) {
         this.createTimeStamp();
      }

      this.createCharge(this.upoint);
      this.CreateUsersession();
      this.createConsumeId();
      this.createSign();
      this.createUCToken();
   }

   public static String getEid() {
      return "4";
   }

   public void CreateUsersession() {
      this.usersession = Utils.getSessionID(this.paramcontext);
   }

   public void createCharge(int var1) {
      this.umoney = this.upoint * 10 / 100;
   }

   public void createConsumeId() {
      this.consumeid = Utils.getUPConsumeid(this.userid, this.cpid, this.gameid);
   }

   public void createPayPwdToken() {
      if (this.paypwd != null && this.paypwd.length() > 0) {
         try {
            StringBuilder var1 = new StringBuilder(String.valueOf(this.userid));
            StringBuilder var2 = new StringBuilder(String.valueOf(MD5.getMD5(var1.append(this.paypwd).toString()).toUpperCase()));
            this.paypwdtoken = MD5.getMD5(var2.append(this.tm).toString());
         } catch (Exception var3) {
            this.paypwd = "";
         }
      } else {
         this.paypwd = "";
      }

   }

   public void createSign() {
      String var1;
      if (this.usersession.length() <= 5) {
         var1 = this.usersession;
      } else {
         var1 = this.usersession.substring(0, 5);
      }

      StringBuilder var2 = new StringBuilder(String.valueOf(var1));
      if (this.cpid.length() <= 5) {
         var1 = this.cpid;
      } else {
         var1 = this.cpid.substring(0, 5);
      }

      var2 = var2.append(var1);
      if (this.gameid.length() <= 5) {
         var1 = this.gameid;
      } else {
         var1 = this.gameid.substring(0, 5);
      }

      this.sign = var2.append(var1).append(this.upoint).toString();
   }

   public void createTimeStamp() {
      String var1;
      if (this.tm.equals("")) {
         var1 = Utils.getCurrentTime(false);
      } else {
         var1 = this.tm;
      }

      this.tm = var1;
   }

   public void createUCToken() {
      this.uctoken = this.tm + "`" + this.userid + "`" + this.userpass;
   }

   public String getChcode() {
      return this.chcode;
   }

   public String getConsumeid() {
      return this.consumeid;
   }

   public String getCpid() {
      return this.cpid;
   }

   public String getGameid() {
      return this.gameid;
   }

   public Context getParamcontext() {
      return this.paramcontext;
   }

   public String getPaypwd() {
      return this.paypwd;
   }

   public String getPaypwdtoken() {
      return this.paypwdtoken;
   }

   public String getSign() {
      return this.sign;
   }

   public String getTm() {
      return this.tm;
   }

   public String getUctoken() {
      return this.uctoken;
   }

   public int getUmoney() {
      return this.umoney;
   }

   public int getUpoint() {
      return this.upoint;
   }

   public String getUserid() {
      return this.userid;
   }

   public String getUserpass() {
      return this.userpass;
   }

   public String getUsersession() {
      return this.usersession;
   }

   public void setChcode(String var1) {
      this.chcode = var1;
   }

   public void setConsumeid(String var1) {
      this.consumeid = var1;
   }

   public void setCpid(String var1) {
      this.cpid = var1;
   }

   public void setGameid(String var1) {
      this.gameid = var1;
   }

   public void setParamcontext(Context var1) {
      this.paramcontext = var1;
   }

   public void setPaypwd(String var1) {
      this.paypwd = var1;
      this.createPayPwdToken();
   }

   public void setPaypwdtoken(String var1) {
      this.paypwdtoken = var1;
   }

   public void setSign(String var1) {
      this.sign = var1;
   }

   public void setTm(String var1) {
      this.tm = var1;
      this.createUCToken();
      this.createPayPwdToken();
   }

   public void setUctoken(String var1) {
      this.uctoken = var1;
   }

   public void setUmoney(int var1) {
      this.umoney = var1;
   }

   public void setUpoint(int var1) {
      this.upoint = var1;
   }

   public void setUserid(String var1) {
      this.userid = var1;
   }

   public void setUserpass(String var1) {
      this.userpass = var1;
   }

   public void setUsersession(String var1) {
      this.usersession = var1;
   }

   public void updateConsumeId() {
      Utils.clearUPConsumeid();
      this.consumeid = Utils.getUPConsumeid(this.userid, this.cpid, this.gameid);
   }
}
