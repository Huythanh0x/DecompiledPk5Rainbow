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
  
  public UPointPayInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6) {
    setUserid(paramString1);
    setUserpass(paramString2);
    setPaypwd(paramString3);
    setCpid(paramString4);
    setGameid(paramString5);
    setTm(paramString6);
    setUpoint(paramInt);
    if (this.tm == null || this.tm.length() < 1)
      createTimeStamp(); 
    createCharge(this.upoint);
    CreateUsersession();
    createConsumeId();
    createSign();
    createUCToken();
  }
  
  public static String getEid() {
    return "4";
  }
  
  public void CreateUsersession() {
    this.usersession = Utils.getSessionID(this.paramcontext);
  }
  
  public void createCharge(int paramInt) {
    this.umoney = this.upoint * 10 / 100;
  }
  
  public void createConsumeId() {
    this.consumeid = Utils.getUPConsumeid(this.userid, this.cpid, this.gameid);
  }
  
  public void createPayPwdToken() {
    if (this.paypwd != null && this.paypwd.length() > 0) {
      try {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        this(String.valueOf(this.userid));
        this(String.valueOf(MD5.getMD5(stringBuilder2.append(this.paypwd).toString()).toUpperCase()));
        this.paypwdtoken = MD5.getMD5(stringBuilder1.append(this.tm).toString());
      } catch (Exception exception) {
        this.paypwd = "";
      } 
      return;
    } 
    this.paypwd = "";
  }
  
  public void createSign() {
    String str;
    if (this.usersession.length() <= 5) {
      str = this.usersession;
    } else {
      str = this.usersession.substring(0, 5);
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str));
    if (this.cpid.length() <= 5) {
      str = this.cpid;
    } else {
      str = this.cpid.substring(0, 5);
    } 
    stringBuilder = stringBuilder.append(str);
    if (this.gameid.length() <= 5) {
      str = this.gameid;
    } else {
      str = this.gameid.substring(0, 5);
    } 
    this.sign = stringBuilder.append(str).append(this.upoint).toString();
  }
  
  public void createTimeStamp() {
    String str;
    if (this.tm.equals("")) {
      str = Utils.getCurrentTime(false);
    } else {
      str = this.tm;
    } 
    this.tm = str;
  }
  
  public void createUCToken() {
    this.uctoken = String.valueOf(this.tm) + "`" + this.userid + "`" + this.userpass;
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
  
  public void setChcode(String paramString) {
    this.chcode = paramString;
  }
  
  public void setConsumeid(String paramString) {
    this.consumeid = paramString;
  }
  
  public void setCpid(String paramString) {
    this.cpid = paramString;
  }
  
  public void setGameid(String paramString) {
    this.gameid = paramString;
  }
  
  public void setParamcontext(Context paramContext) {
    this.paramcontext = paramContext;
  }
  
  public void setPaypwd(String paramString) {
    this.paypwd = paramString;
    createPayPwdToken();
  }
  
  public void setPaypwdtoken(String paramString) {
    this.paypwdtoken = paramString;
  }
  
  public void setSign(String paramString) {
    this.sign = paramString;
  }
  
  public void setTm(String paramString) {
    this.tm = paramString;
    createUCToken();
    createPayPwdToken();
  }
  
  public void setUctoken(String paramString) {
    this.uctoken = paramString;
  }
  
  public void setUmoney(int paramInt) {
    this.umoney = paramInt;
  }
  
  public void setUpoint(int paramInt) {
    this.upoint = paramInt;
  }
  
  public void setUserid(String paramString) {
    this.userid = paramString;
  }
  
  public void setUserpass(String paramString) {
    this.userpass = paramString;
  }
  
  public void setUsersession(String paramString) {
    this.usersession = paramString;
  }
  
  public void updateConsumeId() {
    Utils.clearUPConsumeid();
    this.consumeid = Utils.getUPConsumeid(this.userid, this.cpid, this.gameid);
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/payment/upoint/UPointPayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */