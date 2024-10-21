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

    private static String getAttributeValue(XmlPullParser paramXmlPullParser, String paramString) {
        String s1 = paramXmlPullParser.getAttributeValue("", paramString);
        return s1 == null ? "" : s1.trim();
    }

    public static ArrayList parseAccount(String paramString) throws Exception {
        if(TextUtils.isEmpty(paramString)) {
            return null;
        }
        XmlPullParser xmlPullParser0 = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParser0.setInput(new StringReader(paramString));
        ArrayList localArrayList = new ArrayList(3);
        xmlPullParser0.nextTag();
        xmlPullParser0.require(2, "", "response");
        while(xmlPullParser0.nextTag() == 2) {
            String s1 = xmlPullParser0.getName();
            xmlPullParser0.require(2, "", s1);
            if("name".equals(s1)) {
                localArrayList.add(xmlPullParser0.nextText());
            }
            else if("uid".equals(s1)) {
                localArrayList.add(xmlPullParser0.nextText());
            }
            else if("email".equals(s1)) {
                localArrayList.add(xmlPullParser0.nextText());
            }
            else {
                XMLParser.skipUnknownTag(xmlPullParser0);
            }
            xmlPullParser0.require(3, "", s1);
        }
        xmlPullParser0.require(3, "", "response");
        return localArrayList;
    }

    public static String parseAppname(String paramString) throws Exception {
        if(TextUtils.isEmpty(paramString)) {
            return "";
        }
        XmlPullParser xmlPullParser0 = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParser0.setInput(new StringReader(paramString));
        xmlPullParser0.nextTag();
        xmlPullParser0.require(2, "", "response");
        while(true) {
            if(xmlPullParser0.nextTag() != 2) {
                xmlPullParser0.require(3, "", "response");
                return "";
            }
            String s1 = xmlPullParser0.getName();
            xmlPullParser0.require(2, "", s1);
            if("appname".equals(s1)) {
                return xmlPullParser0.nextText();
            }
            XMLParser.skipUnknownTag(xmlPullParser0);
            xmlPullParser0.require(3, "", s1);
        }
    }

    public static String parseChargePhoneCard(String paramString) throws Exception {
        if(TextUtils.isEmpty(paramString)) {
            return null;
        }
        XmlPullParser xmlPullParser0 = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParser0.setInput(new StringReader(paramString));
        String str1 = "";
        xmlPullParser0.nextTag();
        xmlPullParser0.require(2, "", "result");
        while(xmlPullParser0.nextTag() == 2) {
            String s2 = xmlPullParser0.getName();
            xmlPullParser0.require(2, "", s2);
            if("pay_result".equals(s2)) {
                str1 = XMLParser.getAttributeValue(xmlPullParser0, "order_id");
                xmlPullParser0.nextTag();
            }
            else {
                XMLParser.skipUnknownTag(xmlPullParser0);
            }
            xmlPullParser0.require(3, "", s2);
        }
        xmlPullParser0.require(3, "", "result");
        return str1;
    }

    public static String parsePayChannel(String paramString) throws Exception {
        if(TextUtils.isEmpty(paramString)) {
            return null;
        }
        XmlPullParser xmlPullParser0 = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParser0.setInput(new StringReader(paramString));
        xmlPullParser0.nextTag();
        xmlPullParser0.require(2, "", "response");
        while(true) {
            if(xmlPullParser0.nextTag() != 2) {
                xmlPullParser0.require(3, "", "response");
                return null;
            }
            String s1 = xmlPullParser0.getName();
            xmlPullParser0.require(2, "", s1);
            if("channels".equals(s1)) {
                return xmlPullParser0.nextText().replace("1", "upoint").replace("2", "sms");
            }
            XMLParser.skipUnknownTag(xmlPullParser0);
            xmlPullParser0.require(3, "", s1);
        }
    }

    // Deobfuscation rating: LOW(20)
    public static String parsePayOrder(String paramString) throws Exception {
        return TextUtils.isEmpty(paramString) ? "" : paramString;
    }

    public static int parsePhoneCardChargeResult(String paramString) throws Exception {
        if(TextUtils.isEmpty(paramString)) {
            return -1;
        }
        XmlPullParser xmlPullParser0 = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParser0.setInput(new StringReader(paramString));
        int i = -1;
        xmlPullParser0.nextTag();
        xmlPullParser0.require(2, "", "result");
        while(xmlPullParser0.nextTag() == 2) {
            String s1 = xmlPullParser0.getName();
            xmlPullParser0.require(2, "", s1);
            if("pay_result".equals(s1)) {
                i = Utils.getInt(XMLParser.getAttributeValue(xmlPullParser0, "status"));
                xmlPullParser0.nextTag();
            }
            else {
                XMLParser.skipUnknownTag(xmlPullParser0);
            }
            xmlPullParser0.require(3, "", s1);
        }
        xmlPullParser0.require(3, "", "result");
        return i;
    }

    public static SmsInfos parseSmsInfo(String usefulsmsinfo) throws Exception {
        if(TextUtils.isEmpty(usefulsmsinfo)) {
            return null;
        }
        SmsInfos localSmsInfos = new SmsInfos();
        String[] arr_s = usefulsmsinfo.split("\\^\\|\\*");
        for(int i = 0; true; ++i) {
            if(i >= arr_s.length) {
                return localSmsInfos;
            }
            SmsInfo localSmsInfo = new SmsInfo();
            int smsconfirm = arr_s[i].split("\\^\\$\\*").length >= 2 ? Integer.parseInt(arr_s[i].split("\\^\\$\\*")[0]) : 0;
            localSmsInfo.needconfirm = smsconfirm == 1;
            String[] arr_s1 = arr_s[i].substring((arr_s[i].indexOf("^$*") <= 0 ? 0 : arr_s[i].indexOf("^$*") + 3), arr_s[i].indexOf("^&*")).split(",");
            if(arr_s1 == null || arr_s1.length < 2) {
                return null;
            }
            localSmsInfo.setMoney(Integer.parseInt(arr_s1[4]));
            localSmsInfo.setSmstype(Integer.parseInt(arr_s1[3].split("#")[0]));
            localSmsInfo.setSmschannelid(arr_s1[0]);
            localSmsInfo.setSmsnumber(arr_s1[1].split("#")[0]);
            if(smsconfirm == 1) {
                localSmsInfo.setSmsconfirmnumber(arr_s1[1].split("#")[1]);
            }
            else {
                localSmsInfo.setSmsconfirmnumber("");
            }
            localSmsInfo.setSmsheader(arr_s1[2].split("#")[0]);
            if(smsconfirm == 1) {
                localSmsInfo.setSmsconfirmheader(arr_s1[2].split("#")[1]);
            }
            else {
                localSmsInfo.setSmsconfirmheader("");
            }
            if(arr_s[i].indexOf("^&*") > 0) {
                localSmsInfo.setInfobeforesend(arr_s[i].substring(arr_s[i].indexOf("^&*") + 3).split("#")[0]);
            }
            else {
                localSmsInfo.setInfobeforesend("");
            }
            localSmsInfo.setSmsendtime(arr_s1[5]);
            localSmsInfos.add(localSmsInfo);
        }
    }

    public static UPointInfo parseUPointInfo(String upointinfostr) throws Exception {
        if(TextUtils.isEmpty(upointinfostr)) {
            return null;
        }
        UPointInfo localUPointInfo = new UPointInfo();
        String[] arr_s = upointinfostr.split("#");
        if(arr_s[1].equals("none")) {
            localUPointInfo.setDiscount("无");
            localUPointInfo.setDiscounttext(String.valueOf(Utils.getPaymentInfo().getMoney()));
        }
        else {
            localUPointInfo.setDiscount(arr_s[1]);
            localUPointInfo.setDiscounttext(arr_s[3]);
        }
        localUPointInfo.setDiscountinfo(arr_s[2]);
        if(arr_s[4] != null && arr_s[4].length() > 0) {
            localUPointInfo.setUserphone(arr_s[4]);
        }
        if(arr_s[5] != null && !arr_s[5].equals("none")) {
            localUPointInfo.setVipdiscount(arr_s[5]);
        }
        if(arr_s[6] != null && !arr_s[6].equals("none")) {
            localUPointInfo.setDiscounttext(arr_s[6]);
        }
        if(arr_s[7] != null && !arr_s[7].equals("none")) {
            localUPointInfo.setVipdiscounttime(arr_s[7]);
        }
        return localUPointInfo;
    }

    private static void skipUnknownTag(XmlPullParser paramXmlPullParser) throws Exception {
        String s = paramXmlPullParser.getName();
        while(paramXmlPullParser.next() > 0) {
            if(paramXmlPullParser.getEventType() == 3 && !paramXmlPullParser.getName().equals(s)) {
            }
        }
    }
}

