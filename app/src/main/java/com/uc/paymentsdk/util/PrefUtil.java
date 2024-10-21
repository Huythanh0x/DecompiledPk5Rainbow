/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.preference.PreferenceManager
 *  com.uc.paymentsdk.model.IType
 *  com.uc.paymentsdk.model.TypeFactory
 *  com.uc.paymentsdk.util.Utils
 */
package com.uc.paymentsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.uc.paymentsdk.model.IType;
import com.uc.paymentsdk.model.TypeFactory;
import com.uc.paymentsdk.util.Utils;
import java.util.ArrayList;

public class PrefUtil {
    public static final String EXTRA_TYPE = "type";
    public static final String P_ARRIVE_COUNT = "pref.com.uc.androidsdk.arrive";
    public static final String P_AVAILABLE_CHARGE_TYPE = "pref.com.uc.androidsdk.availableChargeType";
    public static final String P_AVAILABLE_PAY_TYPE = "pref.com.uc.androidsdk.availablePayType";
    public static final String P_DEFAULT_CHARGE_TYPE = "pref.com.uc.androidsdk.defaultChargeType";
    public static final String P_PASSWORD = "pref.com.uc.androidsdk.passowrd";
    public static final String P_SMSINFO = "pref.com.uc.andoridsdk.smsinfo";
    public static final String P_SMSINFO_VERSION = "pref.com.uc.andoridsdk.smsinfo.version";
    public static final String P_UID = "pref.com.uc.androidsdk.uid";
    public static final String P_USERNAME = "pref.com.uc.androidsdk.username";
    public static final String P_USER_SESSION = "pref.com.uc.androidsdk.usersession";
    private static boolean sIsLogin;
    public static SharedPreferences sPref;

    static {
        sPref = null;
    }

    public static void clearArriveCount(Context context) {
        PrefUtil.setArriveCount(context, 0);
    }

    public static void clearPayedAmount(Context object) {
        if (sPref == null) {
            PrefUtil.init(object);
        }
        object = String.valueOf(Utils.getPaymentInfo().getmActionID()) + "_payedAmount";
        sPref.edit().remove((String)object).commit();
    }

    public static void clearUCUserName(Context context) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        context = sPref.edit();
        context.remove(P_USERNAME);
        context.commit();
    }

    public static void clearUCUserPass(Context context) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        context = sPref.edit();
        context.remove(P_PASSWORD);
        context.commit();
    }

    public static void decreaseArriveCount(Context context) {
        // MONITORENTER : com.uc.paymentsdk.util.PrefUtil.class
        int n = PrefUtil.getArriveCount(context);
        if (n > 0) {
            PrefUtil.setArriveCount(context, n - 1);
        }
        return;
    }

    public static int getArriveCount(Context context) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        return sPref.getInt(P_ARRIVE_COUNT, 0);
    }

    public static IType[] getAvailableChargeType(Context context, boolean bl) {
        return PrefUtil.getDefaultChargeType(bl);
    }

    public static ArrayList<IType> getAvailablePayType(Context context, String string) {
        return PrefUtil.getDefaultPayType(string);
    }

    public static String getDefaultChargeType(Context context) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        return sPref.getString(P_DEFAULT_CHARGE_TYPE, null);
    }

    /*
     * Enabled force condition propagation
     */
    private static IType[] getDefaultChargeType(boolean bl) {
        IType[] iTypeArray;
        if (bl) {
            iTypeArray = new IType[]{TypeFactory.factory((String)"alipay"), TypeFactory.factory((String)"phonecard"), TypeFactory.factory((String)"g")};
            return iTypeArray;
        }
        iTypeArray = new IType[]{TypeFactory.factory((String)"alipay"), TypeFactory.factory((String)"phonecard")};
        return iTypeArray;
    }

    private static ArrayList<IType> getDefaultPayType(String string) {
        ArrayList<IType> arrayList = new ArrayList<IType>();
        if ("overage".equals(string) || "all".equals(string)) {
            arrayList.add(TypeFactory.factory((String)"upoint"));
        }
        if ("sms".equals(string) || "all".equals(string)) {
            arrayList.add(TypeFactory.factory((String)"sms"));
        }
        return arrayList;
    }

    /*
     * Enabled force condition propagation
     */
    public static SharedPreferences.Editor getEditor() {
        if (sPref != null) return sPref.edit();
        return null;
    }

    public static int getGFanUID(Context context) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        return sPref.getInt(P_UID, -1);
    }

    public static int getPayedAmount(Context context) {
        String string = String.valueOf(Utils.getPaymentInfo().getmActionID()) + "_payedAmount";
        if (sPref == null) {
            PrefUtil.init(context);
        }
        return sPref.getInt(string, 0);
    }

    public static String getSmsInfo(Context context) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        return sPref.getString(P_SMSINFO, null);
    }

    public static String getSmsInfoVersion(Context context) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        return sPref.getString(P_SMSINFO_VERSION, null);
    }

    public static String getUCUserName(Context context) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        return sPref.getString(P_USERNAME, null);
    }

    public static String getUCUserPass(Context context) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        return sPref.getString(P_PASSWORD, null);
    }

    public static String getUserSession(Context context) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        return sPref.getString(P_USER_SESSION, null);
    }

    public static void increaseArriveCount(Context context) {
        // MONITORENTER : com.uc.paymentsdk.util.PrefUtil.class
        PrefUtil.setArriveCount(context, PrefUtil.getArriveCount(context) + 1);
        return;
    }

    private static void init(Context context) {
        // MONITORENTER : com.uc.paymentsdk.util.PrefUtil.class
        if (sPref == null) {
            sPref = PreferenceManager.getDefaultSharedPreferences((Context)context);
        }
        sIsLogin = false;
        return;
    }

    public static boolean isLogin(Context context) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        return sIsLogin;
    }

    public static void login(Context context) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        sIsLogin = true;
    }

    public static void logout(Context context) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        sIsLogin = false;
        context = sPref.edit();
        context.remove(P_UID);
        context.commit();
    }

    private static void setArriveCount(Context context, int n) {
        // MONITORENTER : com.uc.paymentsdk.util.PrefUtil.class
        if (sPref == null) {
            PrefUtil.init(context);
        }
        sPref.edit().putInt(P_ARRIVE_COUNT, n).commit();
        return;
    }

    /*
     * Unable to fully structure code
     */
    private static void setAvailableChargeType(Context var0, String[] var1_1) {
        block7: {
            if (PrefUtil.sPref == null) {
                PrefUtil.init((Context)var0);
            }
            var2_2 = 0;
            var3_3 = var1_1.length;
            block0: while (true) {
                if (var2_2 >= var3_3) {
                    var0 = new StringBuilder();
                    var2_2 = 0;
                    var3_3 = var1_1.length;
lbl10:
                    // 2 sources

                    while (true) {
                        if (var2_2 >= var3_3) {
                            if (var0.indexOf(",") != -1) {
                                var0.deleteCharAt(var0.length() - 1);
                            }
                            PrefUtil.sPref.edit().putString("pref.com.uc.androidsdk.availableChargeType", var0.toString()).commit();
                            return;
                        }
                        break block7;
                        break;
                    }
                }
                if (!"g".equals(var1_1[var2_2])) break;
                var1_1[var2_2] = var1_1[var3_3 - 1];
                var1_1[var3_3 - 1] = "g";
lbl22:
                // 3 sources

                while (true) {
                    ++var2_2;
                    continue block0;
                    break;
                }
                break;
            }
            if (!"alipay".equals(var1_1[var2_2])) ** GOTO lbl22
            var1_1[var2_2] = var1_1[0];
            var1_1[0] = "alipay";
            ** while (true)
        }
        var0.append(var1_1[var2_2]).append(",");
        ++var2_2;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private static void setAvailablePayType(Context var0, String var1_1) {
        block7: {
            if (PrefUtil.sPref == null) {
                PrefUtil.init((Context)var0);
            }
            var0 = var1_1;
            if (var1_1.indexOf("sms") <= var1_1.indexOf((String)var1_1)) ** GOTO lbl19
            var1_1 = var1_1.split(",");
            var2_2 = 0;
            var3_3 = var1_1.length;
            block0: while (true) {
                block8: {
                    if (var2_2 < var3_3) break block8;
                    var0 = new StringBuilder();
                    var2_2 = 0;
                    var3_3 = var1_1.length;
lbl13:
                    // 2 sources

                    while (true) {
                        if (var2_2 < var3_3) break block7;
                        if (var0.indexOf(",") != -1) {
                            var0.deleteCharAt(var0.length() - 1);
                        }
                        var0 = var0.toString();
lbl19:
                        // 2 sources

                        PrefUtil.sPref.edit().putString("pref.com.uc.androidsdk.availablePayType", (String)var0).commit();
                        return;
                    }
                }
                if (!"sms".equals(var1_1[var2_2])) break;
                var1_1[var2_2] = var1_1[var3_3 - 1];
                var1_1[var3_3 - 1] = "sms";
lbl26:
                // 3 sources

                while (true) {
                    ++var2_2;
                    continue block0;
                    break;
                }
                break;
            }
            if (!"upoint".equals(var1_1[var2_2])) ** GOTO lbl26
            var1_1[var2_2] = var1_1[0];
            var1_1[0] = "upoint";
            ** while (true)
        }
        var0.append(var1_1[var2_2]).append(",");
        ++var2_2;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public static void setDefaultChargeType(Context var0, String var1_1) {
        if (PrefUtil.sPref == null) {
            PrefUtil.init(var0);
        }
        var0 = PrefUtil.sPref.edit();
        if (var1_1 == null) {
            var0.remove("pref.com.uc.androidsdk.defaultChargeType");
lbl7:
            // 2 sources

            while (true) {
                var0.commit();
                return;
            }
        }
        var0.putString("pref.com.uc.androidsdk.defaultChargeType", var1_1);
        ** while (true)
    }

    public static void setGFanUID(Context context, int n) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        context = sPref.edit();
        context.putInt(P_UID, n);
        context.commit();
    }

    public static void setPayedAmount(Context context, int n) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        String string = String.valueOf(Utils.getPaymentInfo().getmActionID()) + "_payedAmount";
        int n2 = PrefUtil.getPayedAmount(context);
        sPref.edit().putInt(string, n2 + n).commit();
    }

    public static void setSmsInfo(Context context, String string) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        sPref.edit().putString(P_SMSINFO, string).commit();
    }

    public static void setSmsInfoVersion(Context context, String string) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        sPref.edit().putString(P_SMSINFO_VERSION, string).commit();
    }

    public static void setUCUserName(Context context, String string) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        context = sPref.edit();
        context.putString(P_USERNAME, string);
        context.commit();
    }

    public static void setUCUserPass(Context context, String string) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        context = sPref.edit();
        context.putString(P_PASSWORD, string);
        context.commit();
    }

    public static void setUserSession(Context context, String string) {
        if (sPref == null) {
            PrefUtil.init(context);
        }
        context = sPref.edit();
        context.putString(P_USER_SESSION, string);
        context.commit();
    }

    /*
     * Enabled force condition propagation
     */
    public static boolean supportChargeType(Context iTypeArray, String string) {
        iTypeArray = PrefUtil.getAvailableChargeType((Context)iTypeArray, true);
        int n = 0;
        int n2 = iTypeArray.length;
        while (n < n2) {
            if (string.equals(iTypeArray[n].getId())) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public static void syncChargeChannels(Context context, String[] stringArray) {
        // MONITORENTER : com.uc.paymentsdk.util.PrefUtil.class
        PrefUtil.setAvailableChargeType(context, stringArray);
        return;
    }

    public static void syncPayChannels(Context context, String string) {
        // MONITORENTER : com.uc.paymentsdk.util.PrefUtil.class
        PrefUtil.setAvailablePayType(context, string);
        return;
    }
}
