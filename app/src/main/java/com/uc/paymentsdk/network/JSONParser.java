package com.uc.paymentsdk.network;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
   public JSONParser() {
      super();
   }

   public static ArrayList parseAlipayOrder(String var0) throws JSONException {
      JSONObject var1 = new JSONObject(var0);
      ArrayList var2;
      if (1 == var1.getInt("resultCode")) {
         var2 = new ArrayList(2);
         var2.add(var1.getString("alipayParam"));
         var2.add(var1.getString("orderNo"));
      } else {
         var2 = null;
      }

      return var2;
   }

   public static int parseAlipayResult(String var0) throws JSONException {
      return (new JSONObject(var0)).getInt("resultCode");
   }

   public static String[] parseChargeChannel(String var0) throws JSONException {
      JSONObject var4 = new JSONObject(var0);
      String[] var5;
      if (1 == var4.getInt("resultCode")) {
         JSONArray var3 = var4.getJSONArray("channels");
         var5 = new String[var3.length()];
         int var1 = 0;

         for(int var2 = var3.length(); var1 < var2; ++var1) {
            switch (var3.getInt(var1)) {
               case 1:
                  var5[var1] = "alipay";
                  break;
               case 2:
                  var5[var1] = "g";
                  break;
               case 3:
                  var5[var1] = "phonecard";
            }
         }
      } else {
         var5 = null;
      }

      return var5;
   }

   public static int parseChargeG(String var0) throws JSONException {
      return (new JSONObject(var0)).getInt("resultCode");
   }

   public static ArrayList parseJifengquanAndGBalance(String var0) throws JSONException {
      JSONObject var1 = new JSONObject(var0);
      ArrayList var2;
      if (1 == var1.getInt("resultCode")) {
         var2 = new ArrayList(2);
         var2.add(var1.getInt("gVolume"));
         var2.add(var1.getInt("gMoney"));
      } else {
         var2 = null;
      }

      return var2;
   }
}
