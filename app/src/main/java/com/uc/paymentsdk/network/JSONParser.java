/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.uc.paymentsdk.network;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
    /*
     * Enabled force condition propagation
     */
    public static ArrayList<String> parseAlipayOrder(String arrayList) throws JSONException {
        JSONObject jSONObject = new JSONObject(arrayList);
        if (1 != jSONObject.getInt("resultCode")) return null;
        arrayList = new ArrayList<E>(2);
        arrayList.add(jSONObject.getString("alipayParam"));
        arrayList.add(jSONObject.getString("orderNo"));
        return arrayList;
    }

    public static int parseAlipayResult(String string) throws JSONException {
        return new JSONObject(string).getInt("resultCode");
    }

    /*
     * Unable to fully structure code
     */
    public static String[] parseChargeChannel(String var0) throws JSONException {
        block10: {
            if (1 != (var0 = new JSONObject((String)var0)).getInt("resultCode")) break block10;
            var3_1 = var0.getJSONArray("channels");
            var0 = new String[var3_1.length()];
            var1_2 = 0;
            var2_3 = var3_1.length();
            block5: while (true) {
                if (var1_2 >= var2_3) lbl-1000:
                // 2 sources

                {
                    return var0;
                }
                switch (var3_1.getInt(var1_2)) lbl-1000:
                // 3 sources

                {
                    default: lbl-1000:
                    // 2 sources

                    {
                        while (true) {
                            ++var1_2;
                            continue block5;
                            break;
                        }
                    }
                    case 1: {
                        var0[var1_2] = "alipay";
                        ** GOTO lbl-1000
                    }
                    case 2: {
                        var0[var1_2] = "g";
                        ** GOTO lbl-1000
                    }
                    case 3: 
                }
                break;
            }
            var0[var1_2] = "phonecard";
            ** while (true)
        }
        var0 = null;
        ** while (true)
    }

    public static int parseChargeG(String string) throws JSONException {
        return new JSONObject(string).getInt("resultCode");
    }

    /*
     * Enabled force condition propagation
     */
    public static ArrayList<Integer> parseJifengquanAndGBalance(String arrayList) throws JSONException {
        JSONObject jSONObject = new JSONObject(arrayList);
        if (1 != jSONObject.getInt("resultCode")) return null;
        arrayList = new ArrayList<E>(2);
        arrayList.add(jSONObject.getInt("gVolume"));
        arrayList.add(jSONObject.getInt("gMoney"));
        return arrayList;
    }
}
