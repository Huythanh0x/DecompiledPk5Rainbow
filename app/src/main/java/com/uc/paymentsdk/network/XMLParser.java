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
    null = paramXmlPullParser.getAttributeValue("", paramString);
    return (null == null) ? "" : null.trim();
  }
  
  public static ArrayList<String> parseAccount(String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString))
      return null; 
    XmlPullParser xmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
    xmlPullParser.setInput(new StringReader(paramString));
    ArrayList<String> arrayList = new ArrayList(3);
    xmlPullParser.nextTag();
    xmlPullParser.require(2, "", "response");
    while (true) {
      if (xmlPullParser.nextTag() != 2) {
        xmlPullParser.require(3, "", "response");
        return arrayList;
      } 
      String str = xmlPullParser.getName();
      xmlPullParser.require(2, "", str);
      if ("name".equals(str)) {
        arrayList.add(xmlPullParser.nextText());
      } else if ("uid".equals(str)) {
        arrayList.add(xmlPullParser.nextText());
      } else if ("email".equals(str)) {
        arrayList.add(xmlPullParser.nextText());
      } else {
        skipUnknownTag(xmlPullParser);
      } 
      xmlPullParser.require(3, "", str);
    } 
  }
  
  public static String parseAppname(String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    XmlPullParser xmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
    xmlPullParser.setInput(new StringReader(paramString));
    xmlPullParser.nextTag();
    xmlPullParser.require(2, "", "response");
    while (true) {
      if (xmlPullParser.nextTag() != 2) {
        xmlPullParser.require(3, "", "response");
        return "";
      } 
      paramString = xmlPullParser.getName();
      xmlPullParser.require(2, "", paramString);
      if ("appname".equals(paramString))
        return xmlPullParser.nextText(); 
      skipUnknownTag(xmlPullParser);
      xmlPullParser.require(3, "", paramString);
    } 
  }
  
  public static String parseChargePhoneCard(String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString))
      return null; 
    XmlPullParser xmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
    xmlPullParser.setInput(new StringReader(paramString));
    paramString = "";
    xmlPullParser.nextTag();
    xmlPullParser.require(2, "", "result");
    while (true) {
      if (xmlPullParser.nextTag() != 2) {
        xmlPullParser.require(3, "", "result");
        return paramString;
      } 
      String str = xmlPullParser.getName();
      xmlPullParser.require(2, "", str);
      if ("pay_result".equals(str)) {
        paramString = getAttributeValue(xmlPullParser, "order_id");
        xmlPullParser.nextTag();
      } else {
        skipUnknownTag(xmlPullParser);
      } 
      xmlPullParser.require(3, "", str);
    } 
  }
  
  public static String parsePayChannel(String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString))
      return null; 
    XmlPullParser xmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
    xmlPullParser.setInput(new StringReader(paramString));
    xmlPullParser.nextTag();
    xmlPullParser.require(2, "", "response");
    while (true) {
      if (xmlPullParser.nextTag() != 2) {
        xmlPullParser.require(3, "", "response");
        return null;
      } 
      paramString = xmlPullParser.getName();
      xmlPullParser.require(2, "", paramString);
      if ("channels".equals(paramString))
        return xmlPullParser.nextText().replace("1", "upoint").replace("2", "sms"); 
      skipUnknownTag(xmlPullParser);
      xmlPullParser.require(3, "", paramString);
    } 
  }
  
  public static String parsePayOrder(String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString))
      paramString = ""; 
    return paramString;
  }
  
  public static int parsePhoneCardChargeResult(String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString))
      return -1; 
    XmlPullParser xmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
    xmlPullParser.setInput(new StringReader(paramString));
    int i = -1;
    xmlPullParser.nextTag();
    xmlPullParser.require(2, "", "result");
    while (true) {
      if (xmlPullParser.nextTag() != 2) {
        xmlPullParser.require(3, "", "result");
        return i;
      } 
      paramString = xmlPullParser.getName();
      xmlPullParser.require(2, "", paramString);
      if ("pay_result".equals(paramString)) {
        i = Utils.getInt(getAttributeValue(xmlPullParser, "status"));
        xmlPullParser.nextTag();
      } else {
        skipUnknownTag(xmlPullParser);
      } 
      xmlPullParser.require(3, "", paramString);
    } 
  }
  
  public static SmsInfos parseSmsInfo(String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString))
      return null; 
    SmsInfos smsInfos = new SmsInfos();
    String[] arrayOfString = paramString.split("\\^\\|\\*");
    for (byte b = 0;; b++) {
      int i;
      boolean bool;
      if (b >= arrayOfString.length)
        return smsInfos; 
      SmsInfo smsInfo = new SmsInfo();
      if ((arrayOfString[b].split("\\^\\$\\*")).length < 2) {
        i = 0;
      } else {
        i = Integer.parseInt(arrayOfString[b].split("\\^\\$\\*")[0]);
      } 
      if (i == 1) {
        smsInfo.needconfirm = true;
      } else {
        smsInfo.needconfirm = false;
      } 
      String str = arrayOfString[b];
      if (arrayOfString[b].indexOf("^$*") > 0) {
        bool = arrayOfString[b].indexOf("^$*") + 3;
      } else {
        bool = false;
      } 
      String[] arrayOfString1 = str.substring(bool, arrayOfString[b].indexOf("^&*")).split(",");
      if (arrayOfString1 == null || arrayOfString1.length < 2)
        return null; 
      smsInfo.setMoney(Integer.parseInt(arrayOfString1[4]));
      smsInfo.setSmstype(Integer.parseInt(arrayOfString1[3].split("#")[0]));
      smsInfo.setSmschannelid(arrayOfString1[0]);
      smsInfo.setSmsnumber(arrayOfString1[1].split("#")[0]);
      if (i == 1) {
        smsInfo.setSmsconfirmnumber(arrayOfString1[1].split("#")[1]);
      } else {
        smsInfo.setSmsconfirmnumber("");
      } 
      smsInfo.setSmsheader(arrayOfString1[2].split("#")[0]);
      if (i == 1) {
        smsInfo.setSmsconfirmheader(arrayOfString1[2].split("#")[1]);
      } else {
        smsInfo.setSmsconfirmheader("");
      } 
      if (arrayOfString[b].indexOf("^&*") > 0) {
        smsInfo.setInfobeforesend(arrayOfString[b].substring(arrayOfString[b].indexOf("^&*") + 3).split("#")[0]);
      } else {
        smsInfo.setInfobeforesend("");
      } 
      smsInfo.setSmsendtime(arrayOfString1[5]);
      smsInfos.add(smsInfo);
    } 
  }
  
  public static UPointInfo parseUPointInfo(String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString))
      return null; 
    UPointInfo uPointInfo = new UPointInfo();
    String[] arrayOfString = paramString.split("#");
    if (arrayOfString[1].equals("none")) {
      uPointInfo.setDiscount("无");
      uPointInfo.setDiscounttext((new StringBuilder(String.valueOf(Utils.getPaymentInfo().getMoney()))).toString());
    } else {
      uPointInfo.setDiscount(arrayOfString[1]);
      uPointInfo.setDiscounttext(arrayOfString[3]);
    } 
    uPointInfo.setDiscountinfo(arrayOfString[2]);
    if (arrayOfString[4] != null && arrayOfString[4].length() > 0)
      uPointInfo.setUserphone(arrayOfString[4]); 
    if (arrayOfString[5] != null && !arrayOfString[5].equals("none"))
      uPointInfo.setVipdiscount(arrayOfString[5]); 
    if (arrayOfString[6] != null && !arrayOfString[6].equals("none"))
      uPointInfo.setDiscounttext(arrayOfString[6]); 
    if (arrayOfString[7] != null && !arrayOfString[7].equals("none"))
      uPointInfo.setVipdiscounttime(arrayOfString[7]); 
    return uPointInfo;
  }
  
  private static void skipUnknownTag(XmlPullParser paramXmlPullParser) throws Exception {
    String str = paramXmlPullParser.getName();
    while (true) {
      if (paramXmlPullParser.next() <= 0)
        return; 
      if (paramXmlPullParser.getEventType() != 3 || !paramXmlPullParser.getName().equals(str));
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/network/XMLParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */