package com.uc.paymentsdk.network.JSONParser;
import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;
import java.lang.Integer;

public class JSONParser	// class@0000a2 from classes.dex
{

    public void JSONParser(){
       super();
    }
    public static ArrayList parseAlipayOrder(String paramString){
       ArrayList uArrayList;
       JSONObject localJSONObject = new JSONObject(paramString);
       int i = localJSONObject.getInt("resultCode");
       if (1 == i) {
          ArrayList localArrayList = new ArrayList(2);
          localArrayList.add(localJSONObject.getString("alipayParam"));
          localArrayList.add(localJSONObject.getString("orderNo"));
          uArrayList = localArrayList;
       }else {
          uArrayList = null;
       }
       return uArrayList;
    }
    public static int parseAlipayResult(String paramString){
       JSONObject localJSONObject = new JSONObject(paramString);
       return localJSONObject.getInt("resultCode");
    }
    public static String[] parseChargeChannel(String paramString){
       String[] stringArray;
       JSONObject localJSONObject = new JSONObject(paramString);
       int i = localJSONObject.getInt("resultCode");
       if (1 == i) {
          JSONArray localJSONArray = localJSONObject.getJSONArray("channels");
          String[] arrayOfString = new String[localJSONArray.length()];
          int j = 0;
          int k = localJSONArray.length();
          while (j < k) {
             int m = localJSONArray.getInt(j);
             switch (m){
                 case 1:
                   arrayOfString[j] = "alipay";
                   break;
                 case 2:
                   arrayOfString[j] = "g";
                   break;
                 case 3:
                   arrayOfString[j] = "phonecard";
                   break;
             }
             j++;
          }
          stringArray = arrayOfString;
       }else {
          stringArray = null;
       }
       return stringArray;
    }
    public static int parseChargeG(String paramString){
       JSONObject localJSONObject = new JSONObject(paramString);
       return localJSONObject.getInt("resultCode");
    }
    public static ArrayList parseJifengquanAndGBalance(String paramString){
       ArrayList uArrayList;
       JSONObject localJSONObject = new JSONObject(paramString);
       int i = localJSONObject.getInt("resultCode");
       if (1 == i) {
          ArrayList localArrayList = new ArrayList(2);
          localArrayList.add(Integer.valueOf(localJSONObject.getInt("gVolume")));
          localArrayList.add(Integer.valueOf(localJSONObject.getInt("gMoney")));
          uArrayList = localArrayList;
       }else {
          uArrayList = null;
       }
       return uArrayList;
    }
}
