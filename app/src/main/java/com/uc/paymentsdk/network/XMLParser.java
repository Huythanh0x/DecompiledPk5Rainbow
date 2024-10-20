/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.uc.paymentsdk.payment.sms.SmsInfo
 *  com.uc.paymentsdk.payment.sms.SmsInfos
 *  com.uc.paymentsdk.payment.upoint.UPointInfo
 *  com.uc.paymentsdk.util.Utils
 */
package com.uc.paymentsdk.network;

import android.text.TextUtils;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import com.uc.paymentsdk.payment.sms.SmsInfos;
import com.uc.paymentsdk.payment.upoint.UPointInfo;
import com.uc.paymentsdk.util.Utils;
import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class XMLParser {
    private static final String RESPONSE = "response";

    /*
     * Enabled force condition propagation
     */
    private static String getAttributeValue(XmlPullParser object, String string) {
        if ((object = object.getAttributeValue("", string)) != null) return ((String)object).trim();
        return "";
    }

    /*
     * Unable to fully structure code
     */
    public static ArrayList<String> parseAccount(String var0) throws Exception {
        block6: {
            block5: {
                if (TextUtils.isEmpty((CharSequence)var0)) {
                    var0 = null;
lbl3:
                    // 2 sources

                    return var0;
                }
                var1_1 = XmlPullParserFactory.newInstance().newPullParser();
                var1_1.setInput(new StringReader((String)var0));
                var0 = new ArrayList<E>(3);
                var1_1.nextTag();
                var1_1.require(2, "", "response");
                block1: while (true) {
                    if (var1_1.nextTag() != 2) {
                        var1_1.require(3, "", "response");
                        ** continue;
                    }
                    var2_2 = var1_1.getName();
                    var1_1.require(2, "", var2_2);
                    if (!"name".equals(var2_2)) break;
                    var0.add(var1_1.nextText());
lbl20:
                    // 4 sources

                    while (true) {
                        var1_1.require(3, "", var2_2);
                        continue block1;
                        break;
                    }
                    break;
                }
                if (!"uid".equals(var2_2)) break block5;
                var0.add(var1_1.nextText());
                ** GOTO lbl20
            }
            if (!"email".equals(var2_2)) break block6;
            var0.add(var1_1.nextText());
            ** GOTO lbl20
        }
        XMLParser.skipUnknownTag(var1_1);
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public static String parseAppname(String string) throws Exception {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return "";
        }
        XmlPullParser xmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParser.setInput(new StringReader(string));
        xmlPullParser.nextTag();
        xmlPullParser.require(2, "", RESPONSE);
        while (true) {
            if (xmlPullParser.nextTag() != 2) {
                xmlPullParser.require(3, "", RESPONSE);
                return "";
            }
            string = xmlPullParser.getName();
            xmlPullParser.require(2, "", string);
            if ("appname".equals(string)) {
                return xmlPullParser.nextText();
            }
            XMLParser.skipUnknownTag(xmlPullParser);
            xmlPullParser.require(3, "", string);
        }
    }

    /*
     * Unable to fully structure code
     */
    public static String parseChargePhoneCard(String var0) throws Exception {
        if (TextUtils.isEmpty((CharSequence)var0)) {
            var0 = null;
lbl3:
            // 2 sources

            return var0;
        }
        var1_1 = XmlPullParserFactory.newInstance().newPullParser();
        var1_1.setInput(new StringReader(var0));
        var0 = "";
        var1_1.nextTag();
        var1_1.require(2, "", "result");
        block1: while (true) {
            if (var1_1.nextTag() != 2) {
                var1_1.require(3, "", "result");
                ** continue;
            }
            var2_2 = var1_1.getName();
            var1_1.require(2, "", var2_2);
            if (!"pay_result".equals(var2_2)) break;
            var0 = XMLParser.getAttributeValue(var1_1, "order_id");
            var1_1.nextTag();
lbl21:
            // 2 sources

            while (true) {
                var1_1.require(3, "", var2_2);
                continue block1;
                break;
            }
            break;
        }
        XMLParser.skipUnknownTag(var1_1);
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public static String parsePayChannel(String string) throws Exception {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        XmlPullParser xmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParser.setInput(new StringReader(string));
        xmlPullParser.nextTag();
        xmlPullParser.require(2, "", RESPONSE);
        while (true) {
            if (xmlPullParser.nextTag() != 2) {
                xmlPullParser.require(3, "", RESPONSE);
                return null;
            }
            string = xmlPullParser.getName();
            xmlPullParser.require(2, "", string);
            if ("channels".equals(string)) {
                return xmlPullParser.nextText().replace("1", "upoint").replace("2", "sms");
            }
            XMLParser.skipUnknownTag(xmlPullParser);
            xmlPullParser.require(3, "", string);
        }
    }

    public static String parsePayOrder(String string) throws Exception {
        if (TextUtils.isEmpty((CharSequence)string)) {
            string = "";
        }
        return string;
    }

    /*
     * Unable to fully structure code
     */
    public static int parsePhoneCardChargeResult(String var0) throws Exception {
        if (TextUtils.isEmpty((CharSequence)var0)) {
            var1_1 = -1;
lbl3:
            // 2 sources

            return var1_1;
        }
        var2_2 = XmlPullParserFactory.newInstance().newPullParser();
        var2_2.setInput(new StringReader(var0));
        var1_1 = -1;
        var2_2.nextTag();
        var2_2.require(2, "", "result");
        block1: while (true) {
            if (var2_2.nextTag() != 2) {
                var2_2.require(3, "", "result");
                ** continue;
            }
            var0 = var2_2.getName();
            var2_2.require(2, "", var0);
            if (!"pay_result".equals(var0)) break;
            var1_1 = Utils.getInt((String)XMLParser.getAttributeValue(var2_2, "status"));
            var2_2.nextTag();
lbl21:
            // 2 sources

            while (true) {
                var2_2.require(3, "", var0);
                continue block1;
                break;
            }
            break;
        }
        XMLParser.skipUnknownTag(var2_2);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public static SmsInfos parseSmsInfo(String var0) throws Exception {
        block12: {
            block11: {
                if (TextUtils.isEmpty((CharSequence)var0)) {
                    var0 = null;
lbl3:
                    // 3 sources

                    return var0;
                }
                var4_1 = new SmsInfos();
                var5_2 = var0.split("\\^\\|\\*");
                var1_3 = 0;
                block1: while (true) {
                    block10: {
                        block9: {
                            block15: {
                                block14: {
                                    block13: {
                                        if (var1_3 < var5_2.length) break block13;
                                        var0 = var4_1;
                                        ** GOTO lbl3
                                    }
                                    var0 = new SmsInfo();
                                    if (var5_2[var1_3].split("\\^\\$\\*").length >= 2) break block14;
                                    var2_4 = 0;
lbl16:
                                    // 2 sources

                                    while (var2_4 == 1) {
                                        var0.needconfirm = true;
lbl18:
                                        // 2 sources

                                        block3: while (true) {
                                            var6_6 = var5_2[var1_3];
                                            if (var5_2[var1_3].indexOf("^$*") <= 0) break block9;
                                            var3_5 = var5_2[var1_3].indexOf("^$*") + 3;
lbl22:
                                            // 2 sources

                                            while ((var6_6 = var6_6.substring(var3_5, var5_2[var1_3].indexOf("^&*")).split(",")) == null || var6_6.length < 2) {
                                                var0 = null;
                                                ** continue;
lbl25:
                                                // 1 sources

                                                break block3;
                                            }
                                            break block10;
                                            break;
                                        }
                                        ** GOTO lbl3
                                    }
                                    break block15;
                                }
                                var2_4 = Integer.parseInt(var5_2[var1_3].split("\\^\\$\\*")[0]);
                                ** GOTO lbl16
                            }
                            var0.needconfirm = false;
                            ** continue;
                        }
                        var3_5 = 0;
                        ** GOTO lbl22
                    }
                    var0.setMoney(Integer.parseInt(var6_6[4]));
                    var0.setSmstype(Integer.parseInt(var6_6[3].split("#")[0]));
                    var0.setSmschannelid(var6_6[0]);
                    var0.setSmsnumber(var6_6[1].split("#")[0]);
                    if (var2_4 != 1) break;
                    var0.setSmsconfirmnumber(var6_6[1].split("#")[1]);
lbl45:
                    // 2 sources

                    while (true) {
                        var0.setSmsheader(var6_6[2].split("#")[0]);
                        if (var2_4 != 1) break block11;
                        var0.setSmsconfirmheader(var6_6[2].split("#")[1]);
lbl49:
                        // 2 sources

                        while (var5_2[var1_3].indexOf("^&*") > 0) {
                            var0.setInfobeforesend(var5_2[var1_3].substring(var5_2[var1_3].indexOf("^&*") + 3).split("#")[0]);
lbl51:
                            // 2 sources

                            while (true) {
                                var0.setSmsendtime(var6_6[5]);
                                var4_1.add((SmsInfo)var0);
                                ++var1_3;
                                continue block1;
                                break;
                            }
                            continue block1;
                        }
                        break block12;
                        break;
                    }
                    break;
                }
                var0.setSmsconfirmnumber("");
                ** while (true)
            }
            var0.setSmsconfirmheader("");
            ** GOTO lbl49
        }
        var0.setInfobeforesend("");
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public static UPointInfo parseUPointInfo(String var0) throws Exception {
        if (TextUtils.isEmpty((CharSequence)var0)) {
            var0 = null;
lbl3:
            // 2 sources

            return var0;
        }
        var1_1 = new UPointInfo();
        if ((var0 = var0.split("#"))[1].equals("none")) {
            var1_1.setDiscount("\u65e0");
            var1_1.setDiscounttext(String.valueOf(Utils.getPaymentInfo().getMoney()));
lbl9:
            // 2 sources

            while (true) {
                var1_1.setDiscountinfo(var0[2]);
                if (var0[4] != null && var0[4].length() > 0) {
                    var1_1.setUserphone(var0[4]);
                }
                if (var0[5] != null && !var0[5].equals("none")) {
                    var1_1.setVipdiscount(var0[5]);
                }
                if (var0[6] != null && !var0[6].equals("none")) {
                    var1_1.setDiscounttext((String)var0[6]);
                }
                if (var0[7] != null && !var0[7].equals("none")) {
                    var1_1.setVipdiscounttime((String)var0[7]);
                }
                var0 = var1_1;
                ** continue;
                break;
            }
        }
        var1_1.setDiscount(var0[1]);
        var1_1.setDiscounttext(var0[3]);
        ** while (true)
    }

    private static void skipUnknownTag(XmlPullParser xmlPullParser) throws Exception {
        String string = xmlPullParser.getName();
        while (xmlPullParser.next() > 0) {
            if (xmlPullParser.getEventType() != 3 || xmlPullParser.getName().equals(string)) continue;
        }
        return;
    }
}
