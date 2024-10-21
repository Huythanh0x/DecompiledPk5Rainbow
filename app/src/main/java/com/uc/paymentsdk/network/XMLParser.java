package com.uc.paymentsdk.network.XMLParser;
import java.lang.Object;
import org.xmlpull.v1.XmlPullParser;
import java.lang.String;
import java.util.ArrayList;
import java.lang.CharSequence;
import android.text.TextUtils;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.StringReader;
import java.io.Reader;
import com.uc.paymentsdk.util.Utils;
import com.uc.paymentsdk.payment.sms.SmsInfos;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import java.lang.Integer;
import com.uc.paymentsdk.payment.upoint.UPointInfo;
import java.lang.StringBuilder;
import com.uc.paymentsdk.payment.PaymentInfo;

public class XMLParser	// class@0000a3 from classes.dex
{
    private static final String RESPONSE = "response";

    public void XMLParser(){
       super();
    }
    private static String getAttributeValue(XmlPullParser paramXmlPullParser,String paramString){
       String str;
       String strx = ((str = paramXmlPullParser.getAttributeValue("", paramString)) == null)? "": str.trim();
       return strx;
    }
    public static ArrayList parseAccount(String paramString){
       ArrayList uArrayList;
       if (TextUtils.isEmpty(paramString)) {
          uArrayList = null;
       }else {
          XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
          localXmlPullParser.setInput(new StringReader(paramString));
          ArrayList localArrayList = new ArrayList(3);
          localXmlPullParser.nextTag();
          localXmlPullParser.require(2, "", "response");
          while (localXmlPullParser.nextTag() == 2) {
             String str = localXmlPullParser.getName();
             localXmlPullParser.require(2, "", str);
             if ("name".equals(str)) {
                localArrayList.add(localXmlPullParser.nextText());
             }else if("uid".equals(str)){
                localArrayList.add(localXmlPullParser.nextText());
             }else if("email".equals(str)){
                localArrayList.add(localXmlPullParser.nextText());
             }else {
                XMLParser.skipUnknownTag(localXmlPullParser);
             }
             localXmlPullParser.require(3, "", str);
          }
          localXmlPullParser.require(3, "", "response");
          uArrayList = localArrayList;
       }
       return uArrayList;
    }
    public static String parseAppname(String paramString){
       String strx;
       if (TextUtils.isEmpty(paramString)) {
          strx = "";
       }else {
          XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
          localXmlPullParser.setInput(new StringReader(paramString));
          localXmlPullParser.nextTag();
          localXmlPullParser.require(2, "", "response");
          while (true) {
             if (localXmlPullParser.nextTag() != 2) {
                localXmlPullParser.require(3, "", "response");
                strx = "";
                break ;
             }else {
                String str = localXmlPullParser.getName();
                localXmlPullParser.require(2, "", str);
                if ("appname".equals(str)) {
                   strx = localXmlPullParser.nextText();
                   break ;
                }else {
                   XMLParser.skipUnknownTag(localXmlPullParser);
                   localXmlPullParser.require(3, "", str);
                }
             }
          }
       }
       return strx;
    }
    public static String parseChargePhoneCard(String paramString){
       String str;
       if (TextUtils.isEmpty(paramString)) {
          str = null;
       }else {
          XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
          localXmlPullParser.setInput(new StringReader(paramString));
          String str1 = "";
          localXmlPullParser.nextTag();
          localXmlPullParser.require(2, "", "result");
          while (localXmlPullParser.nextTag() == 2) {
             String str2 = localXmlPullParser.getName();
             localXmlPullParser.require(2, "", str2);
             if ("pay_result".equals(str2)) {
                str1 = XMLParser.getAttributeValue(localXmlPullParser, "order_id");
                localXmlPullParser.nextTag();
             }else {
                XMLParser.skipUnknownTag(localXmlPullParser);
             }
             localXmlPullParser.require(3, "", str2);
          }
          localXmlPullParser.require(3, "", "result");
          str = str1;
       }
       return str;
    }
    public static String parsePayChannel(String paramString){
       String strx;
       int i = 2;
       if (TextUtils.isEmpty(paramString)) {
          strx = null;
       }else {
          XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
          localXmlPullParser.setInput(new StringReader(paramString));
          localXmlPullParser.nextTag();
          localXmlPullParser.require(i, "", "response");
          while (true) {
             if (localXmlPullParser.nextTag() != i) {
                localXmlPullParser.require(3, "", "response");
                strx = null;
                break ;
             }else {
                String str = localXmlPullParser.getName();
                localXmlPullParser.require(i, "", str);
                if ("channels".equals(str)) {
                   strx = localXmlPullParser.nextText().replace("1", "upoint").replace("2", "sms");
                   break ;
                }else {
                   XMLParser.skipUnknownTag(localXmlPullParser);
                   localXmlPullParser.require(3, "", str);
                }
             }
          }
       }
       return strx;
    }
    public static String parsePayOrder(String paramString){
       String str = (TextUtils.isEmpty(paramString))? "": paramString;
       return str;
    }
    public static int parsePhoneCardChargeResult(String paramString){
       int ix;
       if (TextUtils.isEmpty(paramString)) {
          ix = -1;
       }else {
          XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
          localXmlPullParser.setInput(new StringReader(paramString));
          int i = -1;
          localXmlPullParser.nextTag();
          localXmlPullParser.require(2, "", "result");
          while (localXmlPullParser.nextTag() == 2) {
             String str = localXmlPullParser.getName();
             localXmlPullParser.require(2, "", str);
             if ("pay_result".equals(str)) {
                i = Utils.getInt(XMLParser.getAttributeValue(localXmlPullParser, "status"));
                localXmlPullParser.nextTag();
             }else {
                XMLParser.skipUnknownTag(localXmlPullParser);
             }
             localXmlPullParser.require(3, "", str);
          }
          localXmlPullParser.require(3, "", "result");
          ix = i;
       }
       return ix;
    }
    public static SmsInfos parseSmsInfo(String usefulsmsinfo){
       SmsInfos smsInfos;
       String[] smsinfoarr;
       if (TextUtils.isEmpty(usefulsmsinfo)) {
          smsInfos = null;
       }else {
          SmsInfos localSmsInfos = new SmsInfos();
          String[] smsarr = usefulsmsinfo.split("\\^\\|\\*");
          int i = 0;
          while (true) {
             if (i >= smsarr.length) {
                smsInfos = localSmsInfos;
                break ;
             }else {
                SmsInfo localSmsInfo = new SmsInfo();
                int smsconfirm = 0;
                smsconfirm = (smsarr[i].split("\\^\\$\\*").length < 2)? 0: Integer.parseInt(smsarr[i].split("\\^\\$\\*")[0]);
                localSmsInfo.needconfirm = (smsconfirm == 1)? true: false;
                object oobject = smsarr[i];
                int ix = (smsarr[i].indexOf("^$*") > 0)? smsarr[i].indexOf("^$*") + 3: 0;
                if ((smsinfoarr = oobject.substring(ix, smsarr[i].indexOf("^&*")).split(",")) != null && smsinfoarr.length >= 2) {
                   localSmsInfo.setMoney(Integer.parseInt(smsinfoarr[4]));
                   localSmsInfo.setSmstype(Integer.parseInt(smsinfoarr[3].split("#")[0]));
                   localSmsInfo.setSmschannelid(smsinfoarr[0]);
                   localSmsInfo.setSmsnumber(smsinfoarr[1].split("#")[0]);
                   if (smsconfirm == 1) {
                      localSmsInfo.setSmsconfirmnumber(smsinfoarr[1].split("#")[1]);
                   }else {
                      localSmsInfo.setSmsconfirmnumber("");
                   }
                   localSmsInfo.setSmsheader(smsinfoarr[2].split("#")[0]);
                   if (smsconfirm == 1) {
                      localSmsInfo.setSmsconfirmheader(smsinfoarr[2].split("#")[1]);
                   }else {
                      localSmsInfo.setSmsconfirmheader("");
                   }
                   if (smsarr[i].indexOf("^&*") > 0) {
                      ix = smsarr[i].indexOf("^&*") + 3;
                      String str = smsarr[i].substring(ix);
                      localSmsInfo.setInfobeforesend(str.split("#")[0]);
                   }else {
                      localSmsInfo.setInfobeforesend("");
                   }
                   localSmsInfo.setSmsendtime(smsinfoarr[5]);
                   localSmsInfos.add(localSmsInfo);
                   i++;
                }else {
                   smsInfos = null;
                   break ;
                }
             }
          }
       }
       return smsInfos;
    }
    public static UPointInfo parseUPointInfo(String upointinfostr){
       UPointInfo uPointInfo;
       if (TextUtils.isEmpty(upointinfostr)) {
          uPointInfo = null;
       }else {
          UPointInfo localUPointInfo = new UPointInfo();
          String[] infoarr = upointinfostr.split("#");
          if (infoarr[1].equals("none")) {
             localUPointInfo.setDiscount("\x65\x02");
             localUPointInfo.setDiscounttext(String.valueOf(Utils.getPaymentInfo().getMoney()));
          }else {
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
          uPointInfo = localUPointInfo;
       }
       return uPointInfo;
    }
    private static void skipUnknownTag(XmlPullParser paramXmlPullParser){
       String str = paramXmlPullParser.getName();
       while (paramXmlPullParser.next() > 0) {
       }
       return;
    }
}
