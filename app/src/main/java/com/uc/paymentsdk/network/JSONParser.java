package com.uc.paymentsdk.network;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class JSONParser
{
    public JSONParser() {
        super();
    }
    
    public static ArrayList<String> parseAlipayOrder(final String s) throws JSONException {
        final JSONObject jsonObject = new JSONObject(s);
        ArrayList list;
        if (1 == jsonObject.getInt("resultCode")) {
            list = new ArrayList(2);
            list.add(jsonObject.getString("alipayParam"));
            list.add(jsonObject.getString("orderNo"));
        }
        else {
            list = null;
        }
        return list;
    }
    
    public static int parseAlipayResult(final String s) throws JSONException {
        return new JSONObject(s).getInt("resultCode");
    }
    
    public static String[] parseChargeChannel(final String s) throws JSONException {
        final JSONObject jsonObject = new JSONObject(s);
        String[] array;
        if (1 == jsonObject.getInt("resultCode")) {
            final JSONArray jsonArray = jsonObject.getJSONArray("channels");
            array = new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); ++i) {
                switch (jsonArray.getInt(i)) {
                    case 1: {
                        array[i] = "alipay";
                        break;
                    }
                    case 2: {
                        array[i] = "g";
                        break;
                    }
                    case 3: {
                        array[i] = "phonecard";
                        break;
                    }
                }
            }
        }
        else {
            array = null;
        }
        return array;
    }
    
    public static int parseChargeG(final String s) throws JSONException {
        return new JSONObject(s).getInt("resultCode");
    }
    
    public static ArrayList<Integer> parseJifengquanAndGBalance(final String s) throws JSONException {
        final JSONObject jsonObject = new JSONObject(s);
        ArrayList list;
        if (1 == jsonObject.getInt("resultCode")) {
            list = new ArrayList(2);
            list.add(Integer.valueOf(jsonObject.getInt("gVolume")));
            list.add(Integer.valueOf(jsonObject.getInt("gMoney")));
        }
        else {
            list = null;
        }
        return list;
    }
}
