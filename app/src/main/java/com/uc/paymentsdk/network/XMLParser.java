package com.uc.paymentsdk.network;

import android.text.TextUtils;
import com.uc.paymentsdk.model.TypeFactory;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import com.uc.paymentsdk.payment.sms.SmsInfos;
import com.uc.paymentsdk.payment.upoint.UPointInfo;
import com.uc.paymentsdk.util.Constants;
import com.uc.paymentsdk.util.Utils;
import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes.dex */
public class XMLParser {
    private static final String RESPONSE = "response";

    private static void skipUnknownTag(XmlPullParser paramXmlPullParser) throws Exception {
        String str = paramXmlPullParser.getName();
        while (paramXmlPullParser.next() > 0) {
            if (paramXmlPullParser.getEventType() != 3 || !paramXmlPullParser.getName().equals(str)) {
            }
        }
    }

    private static String getAttributeValue(XmlPullParser paramXmlPullParser, String paramString) {
        String str = paramXmlPullParser.getAttributeValue("", paramString);
        return str == null ? "" : str.trim();
    }

    public static ArrayList<String> parseAccount(String paramString) throws Exception {
        if (TextUtils.isEmpty(paramString)) {
            return null;
        }
        XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        localXmlPullParser.setInput(new StringReader(paramString));
        ArrayList localArrayList = new ArrayList(3);
        localXmlPullParser.nextTag();
        localXmlPullParser.require(2, "", RESPONSE);
        while (localXmlPullParser.nextTag() == 2) {
            String str = localXmlPullParser.getName();
            localXmlPullParser.require(2, "", str);
            if ("name".equals(str)) {
                localArrayList.add(localXmlPullParser.nextText());
            } else if ("uid".equals(str)) {
                localArrayList.add(localXmlPullParser.nextText());
            } else if ("email".equals(str)) {
                localArrayList.add(localXmlPullParser.nextText());
            } else {
                skipUnknownTag(localXmlPullParser);
            }
            localXmlPullParser.require(3, "", str);
        }
        localXmlPullParser.require(3, "", RESPONSE);
        return localArrayList;
    }

    public static String parseAppname(String paramString) throws Exception {
        if (TextUtils.isEmpty(paramString)) {
            return "";
        }
        XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        localXmlPullParser.setInput(new StringReader(paramString));
        localXmlPullParser.nextTag();
        localXmlPullParser.require(2, "", RESPONSE);
        while (localXmlPullParser.nextTag() == 2) {
            String str = localXmlPullParser.getName();
            localXmlPullParser.require(2, "", str);
            if ("appname".equals(str)) {
                return localXmlPullParser.nextText();
            }
            skipUnknownTag(localXmlPullParser);
            localXmlPullParser.require(3, "", str);
        }
        localXmlPullParser.require(3, "", RESPONSE);
        return "";
    }

    public static String parsePayOrder(String paramString) throws Exception {
        return TextUtils.isEmpty(paramString) ? "" : paramString;
    }

    public static String parseChargePhoneCard(String paramString) throws Exception {
        if (TextUtils.isEmpty(paramString)) {
            return null;
        }
        XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        localXmlPullParser.setInput(new StringReader(paramString));
        String str1 = "";
        localXmlPullParser.nextTag();
        localXmlPullParser.require(2, "", "result");
        while (localXmlPullParser.nextTag() == 2) {
            String str2 = localXmlPullParser.getName();
            localXmlPullParser.require(2, "", str2);
            if ("pay_result".equals(str2)) {
                str1 = getAttributeValue(localXmlPullParser, "order_id");
                localXmlPullParser.nextTag();
            } else {
                skipUnknownTag(localXmlPullParser);
            }
            localXmlPullParser.require(3, "", str2);
        }
        localXmlPullParser.require(3, "", "result");
        return str1;
    }

    public static int parsePhoneCardChargeResult(String paramString) throws Exception {
        if (TextUtils.isEmpty(paramString)) {
            return -1;
        }
        XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        localXmlPullParser.setInput(new StringReader(paramString));
        int i = -1;
        localXmlPullParser.nextTag();
        localXmlPullParser.require(2, "", "result");
        while (localXmlPullParser.nextTag() == 2) {
            String str = localXmlPullParser.getName();
            localXmlPullParser.require(2, "", str);
            if ("pay_result".equals(str)) {
                i = Utils.getInt(getAttributeValue(localXmlPullParser, "status"));
                localXmlPullParser.nextTag();
            } else {
                skipUnknownTag(localXmlPullParser);
            }
            localXmlPullParser.require(3, "", str);
        }
        localXmlPullParser.require(3, "", "result");
        return i;
    }

    public static String parsePayChannel(String paramString) throws Exception {
        if (TextUtils.isEmpty(paramString)) {
            return null;
        }
        XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        localXmlPullParser.setInput(new StringReader(paramString));
        localXmlPullParser.nextTag();
        localXmlPullParser.require(2, "", RESPONSE);
        while (localXmlPullParser.nextTag() == 2) {
            String str = localXmlPullParser.getName();
            localXmlPullParser.require(2, "", str);
            if ("channels".equals(str)) {
                return localXmlPullParser.nextText().replace("1", TypeFactory.TYPE_PAY_UPOINT).replace("2", "sms");
            }
            skipUnknownTag(localXmlPullParser);
            localXmlPullParser.require(3, "", str);
        }
        localXmlPullParser.require(3, "", RESPONSE);
        return null;
    }

    public static UPointInfo parseUPointInfo(String upointinfostr) throws Exception {
        if (TextUtils.isEmpty(upointinfostr)) {
            return null;
        }
        UPointInfo localUPointInfo = new UPointInfo();
        String[] infoarr = upointinfostr.split("#");
        if (infoarr[1].equals("none")) {
            localUPointInfo.setDiscount("无");
            localUPointInfo.setDiscounttext(new StringBuilder(String.valueOf(Utils.getPaymentInfo().getMoney())).toString());
        } else {
            localUPointInfo.setDiscount(infoarr[1]);
            localUPointInfo.setDiscounttext(infoarr[3]);
        }
        localUPointInfo.setDiscountinfo(infoarr[2]);
        if (infoarr[4] != null && infoarr[4].length() > 0) {
            localUPointInfo.setUserphone(infoarr[4]);
        }
        if (infoarr[5] != null && !infoarr[5].equals("none")) {
            localUPointInfo.setVipdiscount(infoarr[5]);
        }
        if (infoarr[6] != null && !infoarr[6].equals("none")) {
            localUPointInfo.setDiscounttext(infoarr[6]);
        }
        if (infoarr[7] != null && !infoarr[7].equals("none")) {
            localUPointInfo.setVipdiscounttime(infoarr[7]);
        }
        return localUPointInfo;
    }

    public static SmsInfos parseSmsInfo(String usefulsmsinfo) throws Exception {
        int smsconfirm;
        if (TextUtils.isEmpty(usefulsmsinfo)) {
            return null;
        }
        SmsInfos localSmsInfos = new SmsInfos();
        String[] smsarr = usefulsmsinfo.split("\\^\\|\\*");
        for (int i = 0; i < smsarr.length; i++) {
            SmsInfo localSmsInfo = new SmsInfo();
            if (smsarr[i].split("\\^\\$\\*").length < 2) {
                smsconfirm = 0;
            } else {
                smsconfirm = Integer.parseInt(smsarr[i].split("\\^\\$\\*")[0]);
            }
            if (smsconfirm == 1) {
                localSmsInfo.needconfirm = true;
            } else {
                localSmsInfo.needconfirm = false;
            }
            String[] smsinfoarr = smsarr[i].substring(smsarr[i].indexOf("^$*") > 0 ? smsarr[i].indexOf("^$*") + 3 : 0, smsarr[i].indexOf("^&*")).split(Constants.TERM);
            if (smsinfoarr == null || smsinfoarr.length < 2) {
                return null;
            }
            localSmsInfo.setMoney(Integer.parseInt(smsinfoarr[4]));
            localSmsInfo.setSmstype(Integer.parseInt(smsinfoarr[3].split("#")[0]));
            localSmsInfo.setSmschannelid(smsinfoarr[0]);
            localSmsInfo.setSmsnumber(smsinfoarr[1].split("#")[0]);
            if (smsconfirm == 1) {
                localSmsInfo.setSmsconfirmnumber(smsinfoarr[1].split("#")[1]);
            } else {
                localSmsInfo.setSmsconfirmnumber("");
            }
            localSmsInfo.setSmsheader(smsinfoarr[2].split("#")[0]);
            if (smsconfirm == 1) {
                localSmsInfo.setSmsconfirmheader(smsinfoarr[2].split("#")[1]);
            } else {
                localSmsInfo.setSmsconfirmheader("");
            }
            if (smsarr[i].indexOf("^&*") > 0) {
                localSmsInfo.setInfobeforesend(smsarr[i].substring(smsarr[i].indexOf("^&*") + 3).split("#")[0]);
            } else {
                localSmsInfo.setInfobeforesend("");
            }
            localSmsInfo.setSmsendtime(smsinfoarr[5]);
            localSmsInfos.add(localSmsInfo);
        }
        return localSmsInfos;
    }
}
