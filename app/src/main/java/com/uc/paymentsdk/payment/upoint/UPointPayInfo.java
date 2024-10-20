package com.uc.paymentsdk.payment.upoint;

import android.content.Context;
import com.uc.paymentsdk.commons.codec.MD5;
import com.uc.paymentsdk.util.Utils;

public class UPointPayInfo {
    private static final String EID = "4";
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

    public UPointPayInfo(String userid, String userpass, String paypwd, String cpid, String gameid, int upoint, String timpstamp) {
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
        if(this.tm == null || this.tm.length() < 1) {
            this.createTimeStamp();
        }
        this.createCharge(this.upoint);
        this.CreateUsersession();
        this.createConsumeId();
        this.createSign();
        this.createUCToken();
    }

    public void CreateUsersession() {
        this.usersession = Utils.getSessionID(this.paramcontext);
    }

    public void createCharge(int u_money) {
        this.umoney = this.upoint * 10 / 100;
    }

    public void createConsumeId() {
        this.consumeid = Utils.getUPConsumeid(this.userid, this.cpid, this.gameid);
    }

    public void createPayPwdToken() {
        if(this.paypwd != null && this.paypwd.length() > 0) {
            try {
                this.paypwdtoken = MD5.getMD5((MD5.getMD5((this.userid + this.paypwd)).toUpperCase() + this.tm));
            }
            catch(Exception unused_ex) {
                this.paypwd = "";
            }
            return;
        }
        this.paypwd = "";
    }

    public void createSign() {
        this.sign = (this.usersession.length() > 5 ? this.usersession.substring(0, 5) : this.usersession) + (this.cpid.length() > 5 ? this.cpid.substring(0, 5) : this.cpid) + (this.gameid.length() > 5 ? this.gameid.substring(0, 5) : this.gameid) + this.upoint;
    }

    // Deobfuscation rating: LOW(20)
    public void createTimeStamp() {
        this.tm = this.tm.equals("") ? "2024-10-20 10:22:17" : this.tm;
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

    public static String getEid() [...] // Inlined contents

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

    public void setChcode(String chcode) {
        this.chcode = chcode;
    }

    public void setConsumeid(String consumeid) {
        this.consumeid = consumeid;
    }

    public void setCpid(String cpid) {
        this.cpid = cpid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    public void setParamcontext(Context paramcontext) {
        this.paramcontext = paramcontext;
    }

    public void setPaypwd(String paypwd) {
        this.paypwd = paypwd;
        this.createPayPwdToken();
    }

    public void setPaypwdtoken(String paypwdtoken) {
        this.paypwdtoken = paypwdtoken;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setTm(String tm) {
        this.tm = tm;
        this.createUCToken();
        this.createPayPwdToken();
    }

    public void setUctoken(String uctoken) {
        this.uctoken = uctoken;
    }

    public void setUmoney(int umoney) {
        this.umoney = umoney;
    }

    public void setUpoint(int upoint) {
        this.upoint = upoint;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public void setUsersession(String usersession) {
        this.usersession = usersession;
    }

    public void updateConsumeId() {
        Utils.clearUPConsumeid();
        this.consumeid = Utils.getUPConsumeid(this.userid, this.cpid, this.gameid);
    }
}

