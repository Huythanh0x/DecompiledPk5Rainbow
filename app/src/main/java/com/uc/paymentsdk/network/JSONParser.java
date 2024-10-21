package com.uc.paymentsdk.network;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
  public static ArrayList<String> parseAlipayOrder(String paramString) throws JSONException {
    JSONObject jSONObject = new JSONObject(paramString);
    if (1 == jSONObject.getInt("resultCode")) {
      ArrayList<String> arrayList = new ArrayList(2);
      arrayList.add(jSONObject.getString("alipayParam"));
      arrayList.add(jSONObject.getString("orderNo"));
      return arrayList;
    } 
    return null;
  }
  
  public static int parseAlipayResult(String paramString) throws JSONException {
    return (new JSONObject(paramString)).getInt("resultCode");
  }
  
  public static String[] parseChargeChannel(String paramString) throws JSONException {
    null = new JSONObject(paramString);
    if (1 == null.getInt("resultCode")) {
      JSONArray jSONArray = null.getJSONArray("channels");
      String[] arrayOfString = new String[jSONArray.length()];
      byte b = 0;
      int i = jSONArray.length();
      while (true) {
        if (b < i) {
          switch (jSONArray.getInt(b)) {
            case 1:
              arrayOfString[b] = "alipay";
              b++;
              break;
            case 2:
              arrayOfString[b] = "g";
              b++;
              break;
            case 3:
              arrayOfString[b] = "phonecard";
              b++;
              break;
          } 
          continue;
        } 
        return arrayOfString;
      } 
    } 
    return null;
  }
  
  public static int parseChargeG(String paramString) throws JSONException {
    return (new JSONObject(paramString)).getInt("resultCode");
  }
  
  public static ArrayList<Integer> parseJifengquanAndGBalance(String paramString) throws JSONException {
    JSONObject jSONObject = new JSONObject(paramString);
    if (1 == jSONObject.getInt("resultCode")) {
      ArrayList<Integer> arrayList = new ArrayList(2);
      arrayList.add(Integer.valueOf(jSONObject.getInt("gVolume")));
      arrayList.add(Integer.valueOf(jSONObject.getInt("gMoney")));
      return arrayList;
    } 
    return null;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/network/JSONParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */