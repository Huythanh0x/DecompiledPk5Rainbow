package com.uc.paymentsdk.util;

import android.preference.PreferenceManager;
import com.uc.paymentsdk.model.TypeFactory;
import java.util.ArrayList;
import com.uc.paymentsdk.model.IType;
import android.content.SharedPreferences$Editor;
import android.content.Context;
import android.content.SharedPreferences;

public class PrefUtil
{
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
    
    public PrefUtil() {
        super();
    }
    
    public static void clearArriveCount(final Context context) {
        setArriveCount(context, 0);
    }
    
    public static void clearPayedAmount(final Context context) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        PrefUtil.sPref.edit().remove(String.valueOf(Utils.getPaymentInfo().getmActionID()) + "_payedAmount").commit();
    }
    
    public static void clearUCUserName(final Context context) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        final SharedPreferences$Editor edit = PrefUtil.sPref.edit();
        edit.remove("pref.com.uc.androidsdk.username");
        edit.commit();
    }
    
    public static void clearUCUserPass(final Context context) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        final SharedPreferences$Editor edit = PrefUtil.sPref.edit();
        edit.remove("pref.com.uc.androidsdk.passowrd");
        edit.commit();
    }
    
    public static void decreaseArriveCount(final Context context) {
        synchronized (PrefUtil.class) {
            final int arriveCount = getArriveCount(context);
            if (arriveCount > 0) {
                setArriveCount(context, arriveCount - 1);
            }
        }
    }
    
    public static int getArriveCount(final Context context) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        return PrefUtil.sPref.getInt("pref.com.uc.androidsdk.arrive", 0);
    }
    
    public static IType[] getAvailableChargeType(final Context context, final boolean b) {
        return getDefaultChargeType(b);
    }
    
    public static ArrayList<IType> getAvailablePayType(final Context context, final String s) {
        return getDefaultPayType(s);
    }
    
    public static String getDefaultChargeType(final Context context) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        return PrefUtil.sPref.getString("pref.com.uc.androidsdk.defaultChargeType", (String)null);
    }
    
    private static IType[] getDefaultChargeType(final boolean b) {
        IType[] array;
        if (b) {
            array = new IType[] { TypeFactory.factory("alipay"), TypeFactory.factory("phonecard"), TypeFactory.factory("g") };
        }
        else {
            array = new IType[] { TypeFactory.factory("alipay"), TypeFactory.factory("phonecard") };
        }
        return array;
    }
    
    private static ArrayList<IType> getDefaultPayType(final String s) {
        final ArrayList list = new ArrayList();
        if ("overage".equals(s) || "all".equals(s)) {
            list.add(TypeFactory.factory("upoint"));
        }
        if ("sms".equals(s) || "all".equals(s)) {
            list.add(TypeFactory.factory("sms"));
        }
        return list;
    }
    
    public static SharedPreferences$Editor getEditor() {
        SharedPreferences$Editor edit;
        if (PrefUtil.sPref == null) {
            edit = null;
        }
        else {
            edit = PrefUtil.sPref.edit();
        }
        return edit;
    }
    
    public static int getGFanUID(final Context context) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        return PrefUtil.sPref.getInt("pref.com.uc.androidsdk.uid", -1);
    }
    
    public static int getPayedAmount(final Context context) {
        final String string = String.valueOf(Utils.getPaymentInfo().getmActionID()) + "_payedAmount";
        if (PrefUtil.sPref == null) {
            init(context);
        }
        return PrefUtil.sPref.getInt(string, 0);
    }
    
    public static String getSmsInfo(final Context context) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        return PrefUtil.sPref.getString("pref.com.uc.andoridsdk.smsinfo", (String)null);
    }
    
    public static String getSmsInfoVersion(final Context context) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        return PrefUtil.sPref.getString("pref.com.uc.andoridsdk.smsinfo.version", (String)null);
    }
    
    public static String getUCUserName(final Context context) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        return PrefUtil.sPref.getString("pref.com.uc.androidsdk.username", (String)null);
    }
    
    public static String getUCUserPass(final Context context) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        return PrefUtil.sPref.getString("pref.com.uc.androidsdk.passowrd", (String)null);
    }
    
    public static String getUserSession(final Context context) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        return PrefUtil.sPref.getString("pref.com.uc.androidsdk.usersession", (String)null);
    }
    
    public static void increaseArriveCount(final Context context) {
        synchronized (PrefUtil.class) {
            setArriveCount(context, getArriveCount(context) + 1);
        }
    }
    
    private static void init(final Context context) {
        synchronized (PrefUtil.class) {
            if (PrefUtil.sPref == null) {
                PrefUtil.sPref = PreferenceManager.getDefaultSharedPreferences(context);
            }
            PrefUtil.sIsLogin = false;
        }
    }
    
    public static boolean isLogin(final Context context) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        return PrefUtil.sIsLogin;
    }
    
    public static void login(final Context context) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        PrefUtil.sIsLogin = true;
    }
    
    public static void logout(final Context context) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        PrefUtil.sIsLogin = false;
        final SharedPreferences$Editor edit = PrefUtil.sPref.edit();
        edit.remove("pref.com.uc.androidsdk.uid");
        edit.commit();
    }
    
    private static void setArriveCount(final Context context, final int n) {
        synchronized (PrefUtil.class) {
            if (PrefUtil.sPref == null) {
                init(context);
            }
            PrefUtil.sPref.edit().putInt("pref.com.uc.androidsdk.arrive", n).commit();
        }
    }
    
    private static void setAvailableChargeType(final Context context, final String[] array) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        for (int i = 0, length = array.length; i < length; ++i) {
            if ("g".equals(array[i])) {
                array[i] = array[length - 1];
                array[length - 1] = "g";
            }
            else if ("alipay".equals(array[i])) {
                array[i] = array[0];
                array[0] = "alipay";
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (int j = 0; j < array.length; ++j) {
            sb.append(array[j]).append(",");
        }
        if (sb.indexOf(",") != -1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        PrefUtil.sPref.edit().putString("pref.com.uc.androidsdk.availableChargeType", sb.toString()).commit();
    }
    
    private static void setAvailablePayType(final Context context, final String str) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        String string = str;
        if (str.indexOf("sms") > str.indexOf(str)) {
            final String[] split = str.split(",");
            for (int i = 0, length = split.length; i < length; ++i) {
                if ("sms".equals(split[i])) {
                    split[i] = split[length - 1];
                    split[length - 1] = "sms";
                }
                else if ("upoint".equals(split[i])) {
                    split[i] = split[0];
                    split[0] = "upoint";
                }
            }
            final StringBuilder sb = new StringBuilder();
            for (int j = 0; j < split.length; ++j) {
                sb.append(split[j]).append(",");
            }
            if (sb.indexOf(",") != -1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            string = sb.toString();
        }
        PrefUtil.sPref.edit().putString("pref.com.uc.androidsdk.availablePayType", string).commit();
    }
    
    public static void setDefaultChargeType(final Context context, final String s) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        final SharedPreferences$Editor edit = PrefUtil.sPref.edit();
        if (s == null) {
            edit.remove("pref.com.uc.androidsdk.defaultChargeType");
        }
        else {
            edit.putString("pref.com.uc.androidsdk.defaultChargeType", s);
        }
        edit.commit();
    }
    
    public static void setGFanUID(final Context context, final int n) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        final SharedPreferences$Editor edit = PrefUtil.sPref.edit();
        edit.putInt("pref.com.uc.androidsdk.uid", n);
        edit.commit();
    }
    
    public static void setPayedAmount(final Context context, final int n) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        PrefUtil.sPref.edit().putInt(String.valueOf(Utils.getPaymentInfo().getmActionID()) + "_payedAmount", getPayedAmount(context) + n).commit();
    }
    
    public static void setSmsInfo(final Context context, final String s) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        PrefUtil.sPref.edit().putString("pref.com.uc.andoridsdk.smsinfo", s).commit();
    }
    
    public static void setSmsInfoVersion(final Context context, final String s) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        PrefUtil.sPref.edit().putString("pref.com.uc.andoridsdk.smsinfo.version", s).commit();
    }
    
    public static void setUCUserName(final Context context, final String s) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        final SharedPreferences$Editor edit = PrefUtil.sPref.edit();
        edit.putString("pref.com.uc.androidsdk.username", s);
        edit.commit();
    }
    
    public static void setUCUserPass(final Context context, final String s) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        final SharedPreferences$Editor edit = PrefUtil.sPref.edit();
        edit.putString("pref.com.uc.androidsdk.passowrd", s);
        edit.commit();
    }
    
    public static void setUserSession(final Context context, final String s) {
        if (PrefUtil.sPref == null) {
            init(context);
        }
        final SharedPreferences$Editor edit = PrefUtil.sPref.edit();
        edit.putString("pref.com.uc.androidsdk.usersession", s);
        edit.commit();
    }
    
    public static boolean supportChargeType(final Context context, final String s) {
        final IType[] availableChargeType = getAvailableChargeType(context, true);
        for (int i = 0; i < availableChargeType.length; ++i) {
            if (s.equals(availableChargeType[i].getId())) {
                return true;
            }
        }
        return false;
    }
    
    public static void syncChargeChannels(final Context context, final String[] array) {
        synchronized (PrefUtil.class) {
            setAvailableChargeType(context, array);
        }
    }
    
    public static void syncPayChannels(final Context context, final String s) {
        synchronized (PrefUtil.class) {
            setAvailablePayType(context, s);
        }
    }
}
