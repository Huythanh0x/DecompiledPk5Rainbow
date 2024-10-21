package com.uc.paymentsdk.network;

import com.uc.paymentsdk.payment.upoint.UPointInfo;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import com.uc.paymentsdk.payment.sms.SmsInfos;
import com.uc.paymentsdk.util.Utils;
import java.io.Reader;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParserFactory;
import android.text.TextUtils;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class XMLParser
{
    private static final String RESPONSE = "response";
    
    public XMLParser() {
        super();
    }
    
    private static String getAttributeValue(final XmlPullParser xmlPullParser, final String s) {
        final String attributeValue = xmlPullParser.getAttributeValue("", s);
        String trim;
        if (attributeValue == null) {
            trim = "";
        }
        else {
            trim = attributeValue.trim();
        }
        return trim;
    }
    
    public static ArrayList<String> parseAccount(final String s) throws Exception {
        ArrayList<String> list;
        if (TextUtils.isEmpty((CharSequence)s)) {
            list = null;
        }
        else {
            final XmlPullParser pullParser = XmlPullParserFactory.newInstance().newPullParser();
            pullParser.setInput(new StringReader(s));
            list = new ArrayList<String>(3);
            pullParser.nextTag();
            pullParser.require(2, "", "response");
            while (pullParser.nextTag() == 2) {
                final String name = pullParser.getName();
                pullParser.require(2, "", name);
                if ("name".equals(name)) {
                    list.add(pullParser.nextText());
                }
                else if ("uid".equals(name)) {
                    list.add(pullParser.nextText());
                }
                else if ("email".equals(name)) {
                    list.add(pullParser.nextText());
                }
                else {
                    skipUnknownTag(pullParser);
                }
                pullParser.require(3, "", name);
            }
            pullParser.require(3, "", "response");
        }
        return list;
    }
    
    public static String parseAppname(String s) throws Exception {
        if (TextUtils.isEmpty((CharSequence)s)) {
            s = "";
        }
        else {
            final XmlPullParser pullParser = XmlPullParserFactory.newInstance().newPullParser();
            pullParser.setInput(new StringReader(s));
            pullParser.nextTag();
            pullParser.require(2, "", "response");
            while (pullParser.nextTag() == 2) {
                s = pullParser.getName();
                pullParser.require(2, "", s);
                if ("appname".equals(s)) {
                    s = pullParser.nextText();
                    return s;
                }
                skipUnknownTag(pullParser);
                pullParser.require(3, "", s);
            }
            pullParser.require(3, "", "response");
            s = "";
        }
        return s;
    }
    
    public static String parseChargePhoneCard(String attributeValue) throws Exception {
        if (TextUtils.isEmpty((CharSequence)attributeValue)) {
            attributeValue = null;
        }
        else {
            final XmlPullParser pullParser = XmlPullParserFactory.newInstance().newPullParser();
            pullParser.setInput(new StringReader(attributeValue));
            attributeValue = "";
            pullParser.nextTag();
            pullParser.require(2, "", "result");
            while (pullParser.nextTag() == 2) {
                final String name = pullParser.getName();
                pullParser.require(2, "", name);
                if ("pay_result".equals(name)) {
                    attributeValue = getAttributeValue(pullParser, "order_id");
                    pullParser.nextTag();
                }
                else {
                    skipUnknownTag(pullParser);
                }
                pullParser.require(3, "", name);
            }
            pullParser.require(3, "", "result");
        }
        return attributeValue;
    }
    
    public static String parsePayChannel(String s) throws Exception {
        if (TextUtils.isEmpty((CharSequence)s)) {
            s = null;
        }
        else {
            final XmlPullParser pullParser = XmlPullParserFactory.newInstance().newPullParser();
            pullParser.setInput(new StringReader(s));
            pullParser.nextTag();
            pullParser.require(2, "", "response");
            while (pullParser.nextTag() == 2) {
                s = pullParser.getName();
                pullParser.require(2, "", s);
                if ("channels".equals(s)) {
                    s = pullParser.nextText().replace("1", "upoint").replace("2", "sms");
                    return s;
                }
                skipUnknownTag(pullParser);
                pullParser.require(3, "", s);
            }
            pullParser.require(3, "", "response");
            s = null;
        }
        return s;
    }
    
    public static String parsePayOrder(String s) throws Exception {
        if (TextUtils.isEmpty((CharSequence)s)) {
            s = "";
        }
        return s;
    }
    
    public static int parsePhoneCardChargeResult(String name) throws Exception {
        int int1;
        if (TextUtils.isEmpty((CharSequence)name)) {
            int1 = -1;
        }
        else {
            final XmlPullParser pullParser = XmlPullParserFactory.newInstance().newPullParser();
            pullParser.setInput(new StringReader(name));
            int1 = -1;
            pullParser.nextTag();
            pullParser.require(2, "", "result");
            while (pullParser.nextTag() == 2) {
                name = pullParser.getName();
                pullParser.require(2, "", name);
                if ("pay_result".equals(name)) {
                    int1 = Utils.getInt(getAttributeValue(pullParser, "status"));
                    pullParser.nextTag();
                }
                else {
                    skipUnknownTag(pullParser);
                }
                pullParser.require(3, "", name);
            }
            pullParser.require(3, "", "result");
        }
        return int1;
    }
    
    public static SmsInfos parseSmsInfo(final String s) throws Exception {
        SmsInfos smsInfos;
        if (TextUtils.isEmpty((CharSequence)s)) {
            smsInfos = null;
        }
        else {
            final SmsInfos smsInfos2 = new SmsInfos();
            final String[] split = s.split("\\^\\|\\*");
            for (int i = 0; i < split.length; ++i) {
                final SmsInfo smsInfo = new SmsInfo();
                int int1;
                if (split[i].split("\\^\\$\\*").length < 2) {
                    int1 = 0;
                }
                else {
                    int1 = Integer.parseInt(split[i].split("\\^\\$\\*")[0]);
                }
                if (int1 == 1) {
                    smsInfo.needconfirm = true;
                }
                else {
                    smsInfo.needconfirm = false;
                }
                final String s2 = split[i];
                int beginIndex;
                if (split[i].indexOf("^$*") > 0) {
                    beginIndex = split[i].indexOf("^$*") + 3;
                }
                else {
                    beginIndex = 0;
                }
                final String[] split2 = s2.substring(beginIndex, split[i].indexOf("^&*")).split(",");
                if (split2 == null || split2.length < 2) {
                    smsInfos = null;
                    return smsInfos;
                }
                smsInfo.setMoney(Integer.parseInt(split2[4]));
                smsInfo.setSmstype(Integer.parseInt(split2[3].split("#")[0]));
                smsInfo.setSmschannelid(split2[0]);
                smsInfo.setSmsnumber(split2[1].split("#")[0]);
                if (int1 == 1) {
                    smsInfo.setSmsconfirmnumber(split2[1].split("#")[1]);
                }
                else {
                    smsInfo.setSmsconfirmnumber("");
                }
                smsInfo.setSmsheader(split2[2].split("#")[0]);
                if (int1 == 1) {
                    smsInfo.setSmsconfirmheader(split2[2].split("#")[1]);
                }
                else {
                    smsInfo.setSmsconfirmheader("");
                }
                if (split[i].indexOf("^&*") > 0) {
                    smsInfo.setInfobeforesend(split[i].substring(split[i].indexOf("^&*") + 3).split("#")[0]);
                }
                else {
                    smsInfo.setInfobeforesend("");
                }
                smsInfo.setSmsendtime(split2[5]);
                smsInfos2.add(smsInfo);
            }
            smsInfos = smsInfos2;
        }
        return smsInfos;
    }
    
    public static UPointInfo parseUPointInfo(final String s) throws Exception {
        UPointInfo uPointInfo;
        if (TextUtils.isEmpty((CharSequence)s)) {
            uPointInfo = null;
        }
        else {
            final UPointInfo uPointInfo2 = new UPointInfo();
            final String[] split = s.split("#");
            if (split[1].equals("none")) {
                uPointInfo2.setDiscount("\u65e0");
                uPointInfo2.setDiscounttext(new StringBuilder(String.valueOf(Utils.getPaymentInfo().getMoney())).toString());
            }
            else {
                uPointInfo2.setDiscount(split[1]);
                uPointInfo2.setDiscounttext(split[3]);
            }
            uPointInfo2.setDiscountinfo(split[2]);
            if (split[4] != null && split[4].length() > 0) {
                uPointInfo2.setUserphone(split[4]);
            }
            if (split[5] != null && !split[5].equals("none")) {
                uPointInfo2.setVipdiscount(split[5]);
            }
            if (split[6] != null && !split[6].equals("none")) {
                uPointInfo2.setDiscounttext(split[6]);
            }
            if (split[7] != null && !split[7].equals("none")) {
                uPointInfo2.setVipdiscounttime(split[7]);
            }
            uPointInfo = uPointInfo2;
        }
        return uPointInfo;
    }
    
    private static void skipUnknownTag(final XmlPullParser xmlPullParser) throws Exception {
        final String name = xmlPullParser.getName();
        while (xmlPullParser.next() > 0) {
            if (xmlPullParser.getEventType() == 3 && !xmlPullParser.getName().equals(name)) {
                continue;
            }
        }
    }
}
