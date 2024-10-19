package com.uc.paymentsdk.payment.upoint;

import android.content.Context;
import com.uc.paymentsdk.commons.codec.MD5;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.util.Utils;

/* loaded from: classes.dex */
public class UPointPayInfo {
    private static final String EID = "4";
    private Context paramcontext;
    private int umoney;
    private int upoint;
    private String userid = "";
    private String userpass = "";
    private String usersession = "";
    private String paypwd = "";
    private String paypwdtoken = "";
    private String cpid = "";
    private String gameid = "";
    private String sign = "";
    private String consumeid = "";
    private String uctoken = "";
    private String tm = "";
    private String chcode = PaymentInfo.CHANNELID;

    public UPointPayInfo(String userid, String userpass, String paypwd, String cpid, String gameid, int upoint, String timpstamp) {
        setUserid(userid);
        setUserpass(userpass);
        setPaypwd(paypwd);
        setCpid(cpid);
        setGameid(gameid);
        setTm(timpstamp);
        setUpoint(upoint);
        if (this.tm == null || this.tm.length() < 1) {
            createTimeStamp();
        }
        createCharge(this.upoint);
        CreateUsersession();
        createConsumeId();
        createSign();
        createUCToken();
    }

    public Context getParamcontext() {
        return this.paramcontext;
    }

    public void setParamcontext(Context paramcontext) {
        this.paramcontext = paramcontext;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpass() {
        return this.userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getUsersession() {
        return this.usersession;
    }

    public void setUsersession(String usersession) {
        this.usersession = usersession;
    }

    public String getPaypwd() {
        return this.paypwd;
    }

    public void setPaypwd(String paypwd) {
        this.paypwd = paypwd;
        createPayPwdToken();
    }

    public String getPaypwdtoken() {
        return this.paypwdtoken;
    }

    public void setPaypwdtoken(String paypwdtoken) {
        this.paypwdtoken = paypwdtoken;
    }

    public String getCpid() {
        return this.cpid;
    }

    public void setCpid(String cpid) {
        this.cpid = cpid;
    }

    public String getGameid() {
        return this.gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    public int getUpoint() {
        return this.upoint;
    }

    public void setUpoint(int upoint) {
        this.upoint = upoint;
    }

    public int getUmoney() {
        return this.umoney;
    }

    public void setUmoney(int umoney) {
        this.umoney = umoney;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getConsumeid() {
        return this.consumeid;
    }

    public void setConsumeid(String consumeid) {
        this.consumeid = consumeid;
    }

    public String getUctoken() {
        return this.uctoken;
    }

    public void setUctoken(String uctoken) {
        this.uctoken = uctoken;
    }

    public String getTm() {
        return this.tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
        createUCToken();
        createPayPwdToken();
    }

    public String getChcode() {
        return this.chcode;
    }

    public void setChcode(String chcode) {
        this.chcode = chcode;
    }

    public static String getEid() {
        return EID;
    }

    public void createTimeStamp() {
        this.tm = this.tm.equals("") ? Utils.getCurrentTime(false) : this.tm;
    }

    public void CreateUsersession() {
        this.usersession = Utils.getSessionID(this.paramcontext);
    }

    public void createCharge(int u_money) {
        this.umoney = (this.upoint * 10) / 100;
    }

    public void createConsumeId() {
        this.consumeid = Utils.getUPConsumeid(this.userid, this.cpid, this.gameid);
    }

    public void updateConsumeId() {
        Utils.clearUPConsumeid();
        this.consumeid = Utils.getUPConsumeid(this.userid, this.cpid, this.gameid);
    }

    public void createSign() {
        this.sign = String.valueOf(this.usersession.length() <= 5 ? this.usersession : this.usersession.substring(0, 5)) + (this.cpid.length() <= 5 ? this.cpid : this.cpid.substring(0, 5)) + (this.gameid.length() <= 5 ? this.gameid : this.gameid.substring(0, 5)) + this.upoint;
    }

    public void createPayPwdToken() {
        if (this.paypwd != null && this.paypwd.length() > 0) {
            try {
                this.paypwdtoken = MD5.getMD5(String.valueOf(MD5.getMD5(String.valueOf(this.userid) + this.paypwd).toUpperCase()) + this.tm);
                return;
            } catch (Exception e) {
                this.paypwd = "";
                return;
            }
        }
        this.paypwd = "";
    }

    public void createUCToken() {
        this.uctoken = String.valueOf(this.tm) + "`" + this.userid + "`" + this.userpass;
    }
}
