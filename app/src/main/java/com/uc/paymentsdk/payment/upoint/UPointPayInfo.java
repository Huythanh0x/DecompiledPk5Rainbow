package com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import java.lang.String;
import java.lang.Object;
import android.content.Context;
import com.uc.paymentsdk.util.Utils;
import java.lang.StringBuilder;
import com.uc.paymentsdk.commons.codec.MD5;

public class UPointPayInfo	// class@0000bb from classes.dex
{
    private String chcode;
    private String consumeid;
    private String cpid;
    private String gameid;
    private Context paramcontext;
    private String paypwd;
    private String paypwdtoken;
    private String sign;
    private String tm;
    private String uctoken;
    private int umoney;
    private int upoint;
    private String userid;
    private String userpass;
    private String usersession;
    private static final String EID = "4";

    public void UPointPayInfo(String userid,String userpass,String paypwd,String cpid,String gameid,int upoint,String timpstamp){
       super();
       this.userid = "";
       this.userpass = "";
       this.usersession = "";
       this.paypwd = "";
       this.paypwdtoken = "";
       this.cpid = "";
       this.gameid = "";
       this.sign = "";
       this.consumeid = "";
       this.uctoken = "";
       this.tm = "";
       this.chcode = "70";
       this.setUserid(userid);
       this.setUserpass(userpass);
       this.setPaypwd(paypwd);
       this.setCpid(cpid);
       this.setGameid(gameid);
       this.setTm(timpstamp);
       this.setUpoint(upoint);
       if (this.tm == null || this.tm.length() < 1) {
          this.createTimeStamp();
       }
       this.createCharge(this.upoint);
       this.CreateUsersession();
       this.createConsumeId();
       this.createSign();
       this.createUCToken();
       return;
    }
    public static String getEid(){
       return "4";
    }
    public void CreateUsersession(){
       this.usersession = Utils.getSessionID(this.paramcontext);
    }
    public void createCharge(int u_money){
       this.umoney = (this.upoint * 10) / 100;
    }
    public void createConsumeId(){
       this.consumeid = Utils.getUPConsumeid(this.userid, this.cpid, this.gameid);
    }
    public void createPayPwdToken(){
       try{
          this.paypwdtoken = (this.paypwd != null && this.paypwd.length() > 0)? MD5.getMD5(String.valueOf((MD5.getMD5(String.valueOf(this.userid)+this.paypwd)).toUpperCase())+this.tm): "";
       }catch(java.lang.Exception e1){
          Exception e = e1;
          this.paypwd = "";
       }
       return;
    }
    public void createSign(){
       String str1;
       UPointPayInfo tusersession = (this.usersession.length() <= 5)? this.usersession: this.usersession.substring(0, 5);
       StringBuilder str = String.valueOf(tusersession);
       tusersession = (this.cpid.length() <= 5)? this.cpid: this.cpid.substring(0, 5);
       str = str+tusersession;
       tusersession = (this.gameid.length() <= 5)? this.gameid: this.gameid.substring(0, 5);
       this.sign = str+tusersession+this.upoint;
       return;
    }
    public void createTimeStamp(){
       String currentTime = (this.tm.equals(""))? Utils.getCurrentTime(false): this.tm;
       this.tm = currentTime;
       return;
    }
    public void createUCToken(){
       this.uctoken = String.valueOf(this.tm)+"`"+this.userid+"`"+this.userpass;
    }
    public String getChcode(){
       return this.chcode;
    }
    public String getConsumeid(){
       return this.consumeid;
    }
    public String getCpid(){
       return this.cpid;
    }
    public String getGameid(){
       return this.gameid;
    }
    public Context getParamcontext(){
       return this.paramcontext;
    }
    public String getPaypwd(){
       return this.paypwd;
    }
    public String getPaypwdtoken(){
       return this.paypwdtoken;
    }
    public String getSign(){
       return this.sign;
    }
    public String getTm(){
       return this.tm;
    }
    public String getUctoken(){
       return this.uctoken;
    }
    public int getUmoney(){
       return this.umoney;
    }
    public int getUpoint(){
       return this.upoint;
    }
    public String getUserid(){
       return this.userid;
    }
    public String getUserpass(){
       return this.userpass;
    }
    public String getUsersession(){
       return this.usersession;
    }
    public void setChcode(String chcode){
       this.chcode = chcode;
    }
    public void setConsumeid(String consumeid){
       this.consumeid = consumeid;
    }
    public void setCpid(String cpid){
       this.cpid = cpid;
    }
    public void setGameid(String gameid){
       this.gameid = gameid;
    }
    public void setParamcontext(Context paramcontext){
       this.paramcontext = paramcontext;
    }
    public void setPaypwd(String paypwd){
       this.paypwd = paypwd;
       this.createPayPwdToken();
    }
    public void setPaypwdtoken(String paypwdtoken){
       this.paypwdtoken = paypwdtoken;
    }
    public void setSign(String sign){
       this.sign = sign;
    }
    public void setTm(String tm){
       this.tm = tm;
       this.createUCToken();
       this.createPayPwdToken();
    }
    public void setUctoken(String uctoken){
       this.uctoken = uctoken;
    }
    public void setUmoney(int umoney){
       this.umoney = umoney;
    }
    public void setUpoint(int upoint){
       this.upoint = upoint;
    }
    public void setUserid(String userid){
       this.userid = userid;
    }
    public void setUserpass(String userpass){
       this.userpass = userpass;
    }
    public void setUsersession(String usersession){
       this.usersession = usersession;
    }
    public void updateConsumeId(){
       Utils.clearUPConsumeid();
       this.consumeid = Utils.getUPConsumeid(this.userid, this.cpid, this.gameid);
    }
}
