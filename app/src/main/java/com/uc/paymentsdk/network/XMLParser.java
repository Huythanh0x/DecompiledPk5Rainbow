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

   public XMLParser() {
      super();
   }

   private static String getAttributeValue(XmlPullParser var0, String var1) {
      String var2 = var0.getAttributeValue("", var1);
      if (var2 == null) {
         var2 = "";
      } else {
         var2 = var2.trim();
      }

      return var2;
   }

   public static ArrayList parseAccount(String var0) throws Exception {
      ArrayList var3;
      if (TextUtils.isEmpty(var0)) {
         var3 = null;
      } else {
         XmlPullParser var1 = XmlPullParserFactory.newInstance().newPullParser();
         var1.setInput(new StringReader(var0));
         var3 = new ArrayList(3);
         var1.nextTag();
         var1.require(2, "", "response");

         String var2;
         for(; var1.nextTag() == 2; var1.require(3, "", var2)) {
            var2 = var1.getName();
            var1.require(2, "", var2);
            if ("name".equals(var2)) {
               var3.add(var1.nextText());
            } else if ("uid".equals(var2)) {
               var3.add(var1.nextText());
            } else if ("email".equals(var2)) {
               var3.add(var1.nextText());
            } else {
               skipUnknownTag(var1);
            }
         }

         var1.require(3, "", "response");
      }

      return var3;
   }

   public static String parseAppname(String var0) throws Exception {
      if (TextUtils.isEmpty(var0)) {
         var0 = "";
      } else {
         XmlPullParser var1 = XmlPullParserFactory.newInstance().newPullParser();
         var1.setInput(new StringReader(var0));
         var1.nextTag();
         var1.require(2, "", "response");

         while(var1.nextTag() == 2) {
            var0 = var1.getName();
            var1.require(2, "", var0);
            if ("appname".equals(var0)) {
               var0 = var1.nextText();
               return var0;
            }

            skipUnknownTag(var1);
            var1.require(3, "", var0);
         }

         var1.require(3, "", "response");
         var0 = "";
      }

      return var0;
   }

   public static String parseChargePhoneCard(String var0) throws Exception {
      if (TextUtils.isEmpty(var0)) {
         var0 = null;
      } else {
         XmlPullParser var1 = XmlPullParserFactory.newInstance().newPullParser();
         var1.setInput(new StringReader(var0));
         var0 = "";
         var1.nextTag();
         var1.require(2, "", "result");

         String var2;
         for(; var1.nextTag() == 2; var1.require(3, "", var2)) {
            var2 = var1.getName();
            var1.require(2, "", var2);
            if ("pay_result".equals(var2)) {
               var0 = getAttributeValue(var1, "order_id");
               var1.nextTag();
            } else {
               skipUnknownTag(var1);
            }
         }

         var1.require(3, "", "result");
      }

      return var0;
   }

   public static String parsePayChannel(String var0) throws Exception {
      if (TextUtils.isEmpty(var0)) {
         var0 = null;
      } else {
         XmlPullParser var1 = XmlPullParserFactory.newInstance().newPullParser();
         var1.setInput(new StringReader(var0));
         var1.nextTag();
         var1.require(2, "", "response");

         while(var1.nextTag() == 2) {
            var0 = var1.getName();
            var1.require(2, "", var0);
            if ("channels".equals(var0)) {
               var0 = var1.nextText().replace("1", "upoint").replace("2", "sms");
               return var0;
            }

            skipUnknownTag(var1);
            var1.require(3, "", var0);
         }

         var1.require(3, "", "response");
         var0 = null;
      }

      return var0;
   }

   public static String parsePayOrder(String var0) throws Exception {
      if (TextUtils.isEmpty(var0)) {
         var0 = "";
      }

      return var0;
   }

   public static int parsePhoneCardChargeResult(String var0) throws Exception {
      int var1;
      if (TextUtils.isEmpty(var0)) {
         var1 = -1;
      } else {
         XmlPullParser var2 = XmlPullParserFactory.newInstance().newPullParser();
         var2.setInput(new StringReader(var0));
         var1 = -1;
         var2.nextTag();
         var2.require(2, "", "result");

         for(; var2.nextTag() == 2; var2.require(3, "", var0)) {
            var0 = var2.getName();
            var2.require(2, "", var0);
            if ("pay_result".equals(var0)) {
               var1 = Utils.getInt(getAttributeValue(var2, "status"));
               var2.nextTag();
            } else {
               skipUnknownTag(var2);
            }
         }

         var2.require(3, "", "result");
      }

      return var1;
   }

   public static SmsInfos parseSmsInfo(String var0) throws Exception {
      SmsInfos var7;
      if (TextUtils.isEmpty(var0)) {
         var7 = null;
      } else {
         SmsInfos var4 = new SmsInfos();
         String[] var5 = var0.split("\\^\\|\\*");
         int var1 = 0;

         while(true) {
            if (var1 >= var5.length) {
               var7 = var4;
               break;
            }

            SmsInfo var8 = new SmsInfo();
            int var2;
            if (var5[var1].split("\\^\\$\\*").length < 2) {
               var2 = 0;
            } else {
               var2 = Integer.parseInt(var5[var1].split("\\^\\$\\*")[0]);
            }

            if (var2 == 1) {
               var8.needconfirm = true;
            } else {
               var8.needconfirm = false;
            }

            String var6 = var5[var1];
            int var3;
            if (var5[var1].indexOf("^$*") > 0) {
               var3 = var5[var1].indexOf("^$*") + 3;
            } else {
               var3 = 0;
            }

            String[] var9 = var6.substring(var3, var5[var1].indexOf("^&*")).split(",");
            if (var9 == null || var9.length < 2) {
               var7 = null;
               break;
            }

            var8.setMoney(Integer.parseInt(var9[4]));
            var8.setSmstype(Integer.parseInt(var9[3].split("#")[0]));
            var8.setSmschannelid(var9[0]);
            var8.setSmsnumber(var9[1].split("#")[0]);
            if (var2 == 1) {
               var8.setSmsconfirmnumber(var9[1].split("#")[1]);
            } else {
               var8.setSmsconfirmnumber("");
            }

            var8.setSmsheader(var9[2].split("#")[0]);
            if (var2 == 1) {
               var8.setSmsconfirmheader(var9[2].split("#")[1]);
            } else {
               var8.setSmsconfirmheader("");
            }

            if (var5[var1].indexOf("^&*") > 0) {
               var8.setInfobeforesend(var5[var1].substring(var5[var1].indexOf("^&*") + 3).split("#")[0]);
            } else {
               var8.setInfobeforesend("");
            }

            var8.setSmsendtime(var9[5]);
            var4.add(var8);
            ++var1;
         }
      }

      return var7;
   }

   public static UPointInfo parseUPointInfo(String var0) throws Exception {
      UPointInfo var2;
      if (TextUtils.isEmpty(var0)) {
         var2 = null;
      } else {
         UPointInfo var1 = new UPointInfo();
         String[] var3 = var0.split("#");
         if (var3[1].equals("none")) {
            var1.setDiscount("\u65e0");
            var1.setDiscounttext(String.valueOf(Utils.getPaymentInfo().getMoney()));
         } else {
            var1.setDiscount(var3[1]);
            var1.setDiscounttext(var3[3]);
         }

         var1.setDiscountinfo(var3[2]);
         if (var3[4] != null && var3[4].length() > 0) {
            var1.setUserphone(var3[4]);
         }

         if (var3[5] != null && !var3[5].equals("none")) {
            var1.setVipdiscount(var3[5]);
         }

         if (var3[6] != null && !var3[6].equals("none")) {
            var1.setDiscounttext(var3[6]);
         }

         if (var3[7] != null && !var3[7].equals("none")) {
            var1.setVipdiscounttime(var3[7]);
         }

         var2 = var1;
      }

      return var2;
   }

   private static void skipUnknownTag(XmlPullParser var0) throws Exception {
      String var1 = var0.getName();

      while(var0.next() > 0) {
         if (var0.getEventType() == 3 && !var0.getName().equals(var1)) {
         }
      }

   }
}
