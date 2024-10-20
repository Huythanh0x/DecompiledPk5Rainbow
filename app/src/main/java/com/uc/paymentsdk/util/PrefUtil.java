package com.uc.paymentsdk.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.uc.paymentsdk.model.IType;
import com.uc.paymentsdk.model.TypeFactory;
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
        PrefUtil.sPref = null;
    }

    public static void clearArriveCount(Context paramContext) {
        synchronized(PrefUtil.class) {
            if(PrefUtil.sPref == null) {
                PrefUtil.init(paramContext);
            }
            PrefUtil.sPref.edit().putInt("pref.com.uc.androidsdk.arrive", 0).commit();
        }
    }

    public static void clearPayedAmount(Context paramContext) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        PrefUtil.sPref.edit().remove(Utils.getPaymentInfo().getmActionID() + "_payedAmount").commit();
    }

    public static void clearUCUserName(Context paramContext) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        SharedPreferences.Editor sharedPreferences$Editor0 = PrefUtil.sPref.edit();
        sharedPreferences$Editor0.remove("pref.com.uc.androidsdk.username");
        sharedPreferences$Editor0.commit();
    }

    public static void clearUCUserPass(Context paramContext) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        SharedPreferences.Editor sharedPreferences$Editor0 = PrefUtil.sPref.edit();
        sharedPreferences$Editor0.remove("pref.com.uc.androidsdk.passowrd");
        sharedPreferences$Editor0.commit();
    }

    public static void decreaseArriveCount(Context paramContext) {
        synchronized(PrefUtil.class) {
            int v1 = PrefUtil.getArriveCount(paramContext);
            if(v1 > 0) {
                PrefUtil.setArriveCount(paramContext, v1 - 1);
            }
        }
    }

    public static int getArriveCount(Context paramContext) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        return PrefUtil.sPref.getInt("pref.com.uc.androidsdk.arrive", 0);
    }

    public static IType[] getAvailableChargeType(Context paramContext, boolean paramBoolean) {
        return PrefUtil.getDefaultChargeType(paramBoolean);
    }

    public static ArrayList getAvailablePayType(Context paramContext, String paramString) {
        return PrefUtil.getDefaultPayType(paramString);
    }

    public static String getDefaultChargeType(Context paramContext) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        return PrefUtil.sPref.getString("pref.com.uc.androidsdk.defaultChargeType", null);
    }

    // Deobfuscation rating: LOW(20)
    private static IType[] getDefaultChargeType(boolean paramBoolean) {
        return paramBoolean ? new IType[]{TypeFactory.factory("alipay"), TypeFactory.factory("phonecard"), TypeFactory.factory("g")} : new IType[]{TypeFactory.factory("alipay"), TypeFactory.factory("phonecard")};
    }

    private static ArrayList getDefaultPayType(String paramString) {
        ArrayList localArrayList = new ArrayList();
        if("overage".equals(paramString) || "all".equals(paramString)) {
            localArrayList.add(TypeFactory.factory("upoint"));
        }
        if("sms".equals(paramString) || "all".equals(paramString)) {
            localArrayList.add(TypeFactory.factory("sms"));
        }
        return localArrayList;
    }

    public static SharedPreferences.Editor getEditor() {
        return PrefUtil.sPref == null ? null : PrefUtil.sPref.edit();
    }

    public static int getGFanUID(Context paramContext) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        return PrefUtil.sPref.getInt("pref.com.uc.androidsdk.uid", -1);
    }

    public static int getPayedAmount(Context paramContext) {
        String s = Utils.getPaymentInfo().getmActionID() + "_payedAmount";
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        return PrefUtil.sPref.getInt(s, 0);
    }

    public static String getSmsInfo(Context paramContext) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        return PrefUtil.sPref.getString("pref.com.uc.andoridsdk.smsinfo", null);
    }

    public static String getSmsInfoVersion(Context paramContext) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        return PrefUtil.sPref.getString("pref.com.uc.andoridsdk.smsinfo.version", null);
    }

    public static String getUCUserName(Context paramContext) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        return PrefUtil.sPref.getString("pref.com.uc.androidsdk.username", null);
    }

    public static String getUCUserPass(Context paramContext) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        return PrefUtil.sPref.getString("pref.com.uc.androidsdk.passowrd", null);
    }

    public static String getUserSession(Context paramContext) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        return PrefUtil.sPref.getString("pref.com.uc.androidsdk.usersession", null);
    }

    public static void increaseArriveCount(Context paramContext) {
        synchronized(PrefUtil.class) {
            PrefUtil.setArriveCount(paramContext, PrefUtil.getArriveCount(paramContext) + 1);
        }
    }

    private static void init(Context paramContext) {
        synchronized(PrefUtil.class) {
            if(PrefUtil.sPref == null) {
                PrefUtil.sPref = PreferenceManager.getDefaultSharedPreferences(paramContext);
            }
            PrefUtil.sIsLogin = false;
        }
    }

    public static boolean isLogin(Context paramContext) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        return PrefUtil.sIsLogin;
    }

    public static void login(Context paramContext) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        PrefUtil.sIsLogin = true;
    }

    public static void logout(Context paramContext) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        PrefUtil.sIsLogin = false;
        SharedPreferences.Editor sharedPreferences$Editor0 = PrefUtil.sPref.edit();
        sharedPreferences$Editor0.remove("pref.com.uc.androidsdk.uid");
        sharedPreferences$Editor0.commit();
    }

    private static void setArriveCount(Context paramContext, int paramInt) [...] // Inlined contents

    private static void setAvailableChargeType(Context paramContext, String[] paramArrayOfString) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        for(int i = 0; i < paramArrayOfString.length; ++i) {
            if("g".equals(paramArrayOfString[i])) {
                paramArrayOfString[i] = paramArrayOfString[paramArrayOfString.length - 1];
                paramArrayOfString[paramArrayOfString.length - 1] = "g";
            }
            else if("alipay".equals(paramArrayOfString[i])) {
                paramArrayOfString[i] = paramArrayOfString[0];
                paramArrayOfString[0] = "alipay";
            }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        for(int j = 0; j < paramArrayOfString.length; ++j) {
            localStringBuilder.append(paramArrayOfString[j]).append(",");
        }
        if(localStringBuilder.indexOf(",") != -1) {
            localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        }
        PrefUtil.sPref.edit().putString("pref.com.uc.androidsdk.availableChargeType", localStringBuilder.toString()).commit();
    }

    private static void setAvailablePayType(Context paramContext, String paramString) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        if(paramString.indexOf("sms") > paramString.indexOf(paramString)) {
            String[] arr_s = paramString.split(",");
            for(int i = 0; i < arr_s.length; ++i) {
                if("sms".equals(arr_s[i])) {
                    arr_s[i] = arr_s[arr_s.length - 1];
                    arr_s[arr_s.length - 1] = "sms";
                }
                else if("upoint".equals(arr_s[i])) {
                    arr_s[i] = arr_s[0];
                    arr_s[0] = "upoint";
                }
            }
            StringBuilder localStringBuilder = new StringBuilder();
            for(int j = 0; j < arr_s.length; ++j) {
                localStringBuilder.append(arr_s[j]).append(",");
            }
            if(localStringBuilder.indexOf(",") != -1) {
                localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
            }
            paramString = localStringBuilder.toString();
        }
        PrefUtil.sPref.edit().putString("pref.com.uc.androidsdk.availablePayType", paramString).commit();
    }

    public static void setDefaultChargeType(Context paramContext, String paramString) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        SharedPreferences.Editor sharedPreferences$Editor0 = PrefUtil.sPref.edit();
        if(paramString == null) {
            sharedPreferences$Editor0.remove("pref.com.uc.androidsdk.defaultChargeType");
        }
        else {
            sharedPreferences$Editor0.putString("pref.com.uc.androidsdk.defaultChargeType", paramString);
        }
        sharedPreferences$Editor0.commit();
    }

    public static void setGFanUID(Context paramContext, int paramInt) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        SharedPreferences.Editor sharedPreferences$Editor0 = PrefUtil.sPref.edit();
        sharedPreferences$Editor0.putInt("pref.com.uc.androidsdk.uid", paramInt);
        sharedPreferences$Editor0.commit();
    }

    public static void setPayedAmount(Context paramContext, int paramInt) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        int v1 = PrefUtil.getPayedAmount(paramContext);
        PrefUtil.sPref.edit().putInt(Utils.getPaymentInfo().getmActionID() + "_payedAmount", v1 + paramInt).commit();
    }

    public static void setSmsInfo(Context paramContext, String paramString) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        PrefUtil.sPref.edit().putString("pref.com.uc.andoridsdk.smsinfo", paramString).commit();
    }

    public static void setSmsInfoVersion(Context paramContext, String paramString) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        PrefUtil.sPref.edit().putString("pref.com.uc.andoridsdk.smsinfo.version", paramString).commit();
    }

    public static void setUCUserName(Context paramContext, String paramString) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        SharedPreferences.Editor sharedPreferences$Editor0 = PrefUtil.sPref.edit();
        sharedPreferences$Editor0.putString("pref.com.uc.androidsdk.username", paramString);
        sharedPreferences$Editor0.commit();
    }

    public static void setUCUserPass(Context paramContext, String paramString) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        SharedPreferences.Editor sharedPreferences$Editor0 = PrefUtil.sPref.edit();
        sharedPreferences$Editor0.putString("pref.com.uc.androidsdk.passowrd", paramString);
        sharedPreferences$Editor0.commit();
    }

    public static void setUserSession(Context paramContext, String paramString) {
        if(PrefUtil.sPref == null) {
            PrefUtil.init(paramContext);
        }
        SharedPreferences.Editor sharedPreferences$Editor0 = PrefUtil.sPref.edit();
        sharedPreferences$Editor0.putString("pref.com.uc.androidsdk.usersession", paramString);
        sharedPreferences$Editor0.commit();
    }

    public static boolean supportChargeType(Context paramContext, String paramString) {
        IType[] arr_iType = PrefUtil.getAvailableChargeType(paramContext, true);
        for(int i = 0; true; ++i) {
            if(i >= arr_iType.length) {
                return false;
            }
            if(paramString.equals(arr_iType[i].getId())) {
                return true;
            }
        }
    }

    public static void syncChargeChannels(Context paramContext, String[] paramArrayOfString) {
        synchronized(PrefUtil.class) {
            PrefUtil.setAvailableChargeType(paramContext, paramArrayOfString);
        }
    }

    public static void syncPayChannels(Context paramContext, String paramString) {
        synchronized(PrefUtil.class) {
            PrefUtil.setAvailablePayType(paramContext, paramString);
        }
    }
}

