package com.uc.paymentsdk.network;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JSONParser {
    public static ArrayList<String> parseAlipayOrder(String paramString) throws JSONException {
        JSONObject localJSONObject = new JSONObject(paramString);
        int i = localJSONObject.getInt("resultCode");
        if (1 != i) {
            return null;
        }
        ArrayList localArrayList = new ArrayList(2);
        localArrayList.add(localJSONObject.getString("alipayParam"));
        localArrayList.add(localJSONObject.getString("orderNo"));
        return localArrayList;
    }

    public static int parseAlipayResult(String paramString) throws JSONException {
        JSONObject localJSONObject = new JSONObject(paramString);
        return localJSONObject.getInt("resultCode");
    }

    public static int parseChargeG(String paramString) throws JSONException {
        JSONObject localJSONObject = new JSONObject(paramString);
        return localJSONObject.getInt("resultCode");
    }

    public static ArrayList<Integer> parseJifengquanAndGBalance(String paramString) throws JSONException {
        JSONObject localJSONObject = new JSONObject(paramString);
        int i = localJSONObject.getInt("resultCode");
        if (1 != i) {
            return null;
        }
        ArrayList localArrayList = new ArrayList(2);
        localArrayList.add(Integer.valueOf(localJSONObject.getInt("gVolume")));
        localArrayList.add(Integer.valueOf(localJSONObject.getInt("gMoney")));
        return localArrayList;
    }

    public static String[] parseChargeChannel(String paramString) throws JSONException {
        JSONObject localJSONObject = new JSONObject(paramString);
        int i = localJSONObject.getInt("resultCode");
        if (1 == i) {
            JSONArray localJSONArray = localJSONObject.getJSONArray("channels");
            String[] arrayOfString = new String[localJSONArray.length()];
            int k = localJSONArray.length();
            for (int j = 0; j < k; j++) {
                int m = localJSONArray.getInt(j);
                switch (m) {
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
            }
            return arrayOfString;
        }
        return null;
    }
}
