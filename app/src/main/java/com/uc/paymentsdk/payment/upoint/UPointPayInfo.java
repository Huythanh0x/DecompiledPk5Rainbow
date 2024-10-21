package com.uc.paymentsdk.payment.upoint;

import com.uc.paymentsdk.commons.codec.MD5;
import com.uc.paymentsdk.util.Utils;
import android.content.Context;

public class UPointPayInfo
{
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
    
    public UPointPayInfo(final String userid, final String userpass, final String paypwd, final String cpid, final String gameid, final int upoint, final String tm) {
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
        this.setTm(tm);
        this.setUpoint(upoint);
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
    
    public void createCharge(final int n) {
        this.umoney = this.upoint * 10 / 100;
    }
    
    public void createConsumeId() {
        this.consumeid = Utils.getUPConsumeid(this.userid, this.cpid, this.gameid);
    }
    
    public void createPayPwdToken() {
        Label_0089: {
            if (this.paypwd == null || this.paypwd.length() <= 0) {
                break Label_0089;
            }
            try {
                this.paypwdtoken = MD5.getMD5(String.valueOf(MD5.getMD5(new StringBuilder(String.valueOf(this.userid)).append(this.paypwd).toString()).toUpperCase()) + this.tm);
                return;
            }
            catch (final Exception ex) {
                this.paypwd = "";
                return;
            }
        }
        this.paypwd = "";
    }
    
    public void createSign() {
        String obj;
        if (this.usersession.length() <= 5) {
            obj = this.usersession;
        }
        else {
            obj = this.usersession.substring(0, 5);
        }
        final StringBuilder sb = new StringBuilder(String.valueOf(obj));
        String str;
        if (this.cpid.length() <= 5) {
            str = this.cpid;
        }
        else {
            str = this.cpid.substring(0, 5);
        }
        final StringBuilder append = sb.append(str);
        String str2;
        if (this.gameid.length() <= 5) {
            str2 = this.gameid;
        }
        else {
            str2 = this.gameid.substring(0, 5);
        }
        this.sign = append.append(str2).append(this.upoint).toString();
    }
    
    public void createTimeStamp() {
        String tm;
        if (this.tm.equals("")) {
            tm = Utils.getCurrentTime(false);
        }
        else {
            tm = this.tm;
        }
        this.tm = tm;
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
    
    public void setChcode(final String chcode) {
        this.chcode = chcode;
    }
    
    public void setConsumeid(final String consumeid) {
        this.consumeid = consumeid;
    }
    
    public void setCpid(final String cpid) {
        this.cpid = cpid;
    }
    
    public void setGameid(final String gameid) {
        this.gameid = gameid;
    }
    
    public void setParamcontext(final Context paramcontext) {
        this.paramcontext = paramcontext;
    }
    
    public void setPaypwd(final String paypwd) {
        this.paypwd = paypwd;
        this.createPayPwdToken();
    }
    
    public void setPaypwdtoken(final String paypwdtoken) {
        this.paypwdtoken = paypwdtoken;
    }
    
    public void setSign(final String sign) {
        this.sign = sign;
    }
    
    public void setTm(final String tm) {
        this.tm = tm;
        this.createUCToken();
        this.createPayPwdToken();
    }
    
    public void setUctoken(final String uctoken) {
        this.uctoken = uctoken;
    }
    
    public void setUmoney(final int umoney) {
        this.umoney = umoney;
    }
    
    public void setUpoint(final int upoint) {
        this.upoint = upoint;
    }
    
    public void setUserid(final String userid) {
        this.userid = userid;
    }
    
    public void setUserpass(final String userpass) {
        this.userpass = userpass;
    }
    
    public void setUsersession(final String usersession) {
        this.usersession = usersession;
    }
    
    public void updateConsumeId() {
        Utils.clearUPConsumeid();
        this.consumeid = Utils.getUPConsumeid(this.userid, this.cpid, this.gameid);
    }
}
