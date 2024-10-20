/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.uc.paymentsdk.commons.codec.MD5
 *  com.uc.paymentsdk.util.Utils
 */
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

    public UPointPayInfo(String string, String string2, String string3, String string4, String string5, int n, String string6) {
        this.setUserid(string);
        this.setUserpass(string2);
        this.setPaypwd(string3);
        this.setCpid(string4);
        this.setGameid(string5);
        this.setTm(string6);
        this.setUpoint(n);
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
        return EID;
    }

    public void CreateUsersession() {
        this.usersession = Utils.getSessionID((Context)this.paramcontext);
    }

    public void createCharge(int n) {
        this.umoney = this.upoint * 10 / 100;
    }

    public void createConsumeId() {
        this.consumeid = Utils.getUPConsumeid((String)this.userid, (String)this.cpid, (String)this.gameid);
    }

    /*
     * Enabled force condition propagation
     */
    public void createPayPwdToken() {
        if (this.paypwd != null && this.paypwd.length() > 0) {
            try {
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(this.userid));
                StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(MD5.getMD5((String)stringBuilder.append(this.paypwd).toString()).toUpperCase()));
                this.paypwdtoken = MD5.getMD5((String)stringBuilder2.append(this.tm).toString());
                return;
            }
            catch (Exception exception) {
                this.paypwd = "";
                return;
            }
        }
        this.paypwd = "";
    }

    /*
     * Unable to fully structure code
     */
    public void createSign() {
        block6: {
            block5: {
                if (this.usersession.length() <= 5) {
                    var1_1 = this.usersession;
lbl3:
                    // 2 sources

                    while (true) {
                        var2_2 = new StringBuilder(String.valueOf(var1_1));
                        if (this.cpid.length() > 5) break block5;
                        var1_1 = this.cpid;
lbl7:
                        // 2 sources

                        while (true) {
                            var2_2 = var2_2.append(var1_1);
                            if (this.gameid.length() <= 5) {
                                var1_1 = this.gameid;
lbl11:
                                // 2 sources

                                while (true) {
                                    this.sign = var2_2.append(var1_1).append(this.upoint).toString();
                                    return;
                                }
                            }
                            break block6;
                            break;
                        }
                        break;
                    }
                }
                var1_1 = this.usersession.substring(0, 5);
                ** while (true)
            }
            var1_1 = this.cpid.substring(0, 5);
            ** while (true)
        }
        var1_1 = this.gameid.substring(0, 5);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void createTimeStamp() {
        if (this.tm.equals("")) {
            var1_1 = Utils.getCurrentTime((boolean)false);
lbl3:
            // 2 sources

            while (true) {
                this.tm = var1_1;
                return;
            }
        }
        var1_1 = this.tm;
        ** while (true)
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

    public void setChcode(String string) {
        this.chcode = string;
    }

    public void setConsumeid(String string) {
        this.consumeid = string;
    }

    public void setCpid(String string) {
        this.cpid = string;
    }

    public void setGameid(String string) {
        this.gameid = string;
    }

    public void setParamcontext(Context context) {
        this.paramcontext = context;
    }

    public void setPaypwd(String string) {
        this.paypwd = string;
        this.createPayPwdToken();
    }

    public void setPaypwdtoken(String string) {
        this.paypwdtoken = string;
    }

    public void setSign(String string) {
        this.sign = string;
    }

    public void setTm(String string) {
        this.tm = string;
        this.createUCToken();
        this.createPayPwdToken();
    }

    public void setUctoken(String string) {
        this.uctoken = string;
    }

    public void setUmoney(int n) {
        this.umoney = n;
    }

    public void setUpoint(int n) {
        this.upoint = n;
    }

    public void setUserid(String string) {
        this.userid = string;
    }

    public void setUserpass(String string) {
        this.userpass = string;
    }

    public void setUsersession(String string) {
        this.usersession = string;
    }

    public void updateConsumeId() {
        Utils.clearUPConsumeid();
        this.consumeid = Utils.getUPConsumeid((String)this.userid, (String)this.cpid, (String)this.gameid);
    }
}
