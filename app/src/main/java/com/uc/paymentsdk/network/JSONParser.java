package com.uc.paymentsdk.network;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
    public static ArrayList parseAlipayOrder(String paramString) throws JSONException {
        JSONObject localJSONObject = new JSONObject(paramString);
        if(1 == localJSONObject.getInt("resultCode")) {
            ArrayList localArrayList = new ArrayList(2);
            localArrayList.add(localJSONObject.getString("alipayParam"));
            localArrayList.add(localJSONObject.getString("orderNo"));
            return localArrayList;
        }
        return null;
    }

    public static int parseAlipayResult(String paramString) throws JSONException {
        return new JSONObject(paramString).getInt("resultCode");
    }

    public static String[] parseChargeChannel(String paramString) throws JSONException {
        JSONObject localJSONObject = new JSONObject(paramString);
        if(1 == localJSONObject.getInt("resultCode")) {
            JSONArray jSONArray0 = localJSONObject.getJSONArray("channels");
            String[] arrayOfString = new String[jSONArray0.length()];
            int v1 = jSONArray0.length();
            for(int j = 0; j < v1; ++j) {
                switch(jSONArray0.getInt(j)) {
                    case 1: {
                        arrayOfString[j] = "alipay";
                        break;
                    }
                    case 2: {
                        arrayOfString[j] = "g";
                        break;
                    }
                    case 3: {
                        arrayOfString[j] = "phonecard";
                    }
                }
            }
            return arrayOfString;
        }
        return null;
    }

    public static int parseChargeG(String paramString) throws JSONException {
        return new JSONObject(paramString).getInt("resultCode");
    }

    public static ArrayList parseJifengquanAndGBalance(String paramString) throws JSONException {
        JSONObject localJSONObject = new JSONObject(paramString);
        if(1 == localJSONObject.getInt("resultCode")) {
            ArrayList localArrayList = new ArrayList(2);
            localArrayList.add(Integer.valueOf(localJSONObject.getInt("gVolume")));
            localArrayList.add(Integer.valueOf(localJSONObject.getInt("gMoney")));
            return localArrayList;
        }
        return null;
    }
}

