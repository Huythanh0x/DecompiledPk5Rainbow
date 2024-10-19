package com.uc.paymentsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.uc.paymentsdk.model.IType;
import com.uc.paymentsdk.model.TypeFactory;
import com.uc.paymentsdk.payment.PaymentInfo;
import java.util.ArrayList;

/* loaded from: classes.dex */
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
    public static SharedPreferences sPref = null;

    private static synchronized void init(Context paramContext) {
        synchronized (PrefUtil.class) {
            if (sPref == null) {
                sPref = PreferenceManager.getDefaultSharedPreferences(paramContext);
            }
            sIsLogin = false;
        }
    }

    public static SharedPreferences.Editor getEditor() {
        if (sPref == null) {
            return null;
        }
        return sPref.edit();
    }

    public static void setUCUserName(Context paramContext, String paramString) {
        if (sPref == null) {
            init(paramContext);
        }
        SharedPreferences.Editor localEditor = sPref.edit();
        localEditor.putString(P_USERNAME, paramString);
        localEditor.commit();
    }

    public static String getUCUserName(Context paramContext) {
        if (sPref == null) {
            init(paramContext);
        }
        return sPref.getString(P_USERNAME, null);
    }

    public static void clearUCUserName(Context paramContext) {
        if (sPref == null) {
            init(paramContext);
        }
        SharedPreferences.Editor localEditor = sPref.edit();
        localEditor.remove(P_USERNAME);
        localEditor.commit();
    }

    public static void setUCUserPass(Context paramContext, String paramString) {
        if (sPref == null) {
            init(paramContext);
        }
        SharedPreferences.Editor localEditor = sPref.edit();
        localEditor.putString(P_PASSWORD, paramString);
        localEditor.commit();
    }

    public static String getUCUserPass(Context paramContext) {
        if (sPref == null) {
            init(paramContext);
        }
        return sPref.getString(P_PASSWORD, null);
    }

    public static void clearUCUserPass(Context paramContext) {
        if (sPref == null) {
            init(paramContext);
        }
        SharedPreferences.Editor localEditor = sPref.edit();
        localEditor.remove(P_PASSWORD);
        localEditor.commit();
    }

    public static void setUserSession(Context paramContext, String paramString) {
        if (sPref == null) {
            init(paramContext);
        }
        SharedPreferences.Editor localEditor = sPref.edit();
        localEditor.putString(P_USER_SESSION, paramString);
        localEditor.commit();
    }

    public static String getUserSession(Context paramContext) {
        if (sPref == null) {
            init(paramContext);
        }
        return sPref.getString(P_USER_SESSION, null);
    }

    public static int getArriveCount(Context paramContext) {
        if (sPref == null) {
            init(paramContext);
        }
        return sPref.getInt(P_ARRIVE_COUNT, 0);
    }

    private static synchronized void setArriveCount(Context paramContext, int paramInt) {
        synchronized (PrefUtil.class) {
            if (sPref == null) {
                init(paramContext);
            }
            sPref.edit().putInt(P_ARRIVE_COUNT, paramInt).commit();
        }
    }

    public static void clearArriveCount(Context paramContext) {
        setArriveCount(paramContext, 0);
    }

    public static synchronized void increaseArriveCount(Context paramContext) {
        synchronized (PrefUtil.class) {
            int i = getArriveCount(paramContext);
            setArriveCount(paramContext, i + 1);
        }
    }

    public static synchronized void decreaseArriveCount(Context paramContext) {
        synchronized (PrefUtil.class) {
            int i = getArriveCount(paramContext);
            if (i > 0) {
                setArriveCount(paramContext, i - 1);
            }
        }
    }

    public static void setGFanUID(Context paramContext, int paramInt) {
        if (sPref == null) {
            init(paramContext);
        }
        SharedPreferences.Editor localEditor = sPref.edit();
        localEditor.putInt(P_UID, paramInt);
        localEditor.commit();
    }

    public static int getGFanUID(Context paramContext) {
        if (sPref == null) {
            init(paramContext);
        }
        return sPref.getInt(P_UID, -1);
    }

    public static boolean isLogin(Context paramContext) {
        if (sPref == null) {
            init(paramContext);
        }
        return sIsLogin;
    }

    public static void login(Context paramContext) {
        if (sPref == null) {
            init(paramContext);
        }
        sIsLogin = true;
    }

    public static void logout(Context paramContext) {
        if (sPref == null) {
            init(paramContext);
        }
        sIsLogin = false;
        SharedPreferences.Editor localEditor = sPref.edit();
        localEditor.remove(P_UID);
        localEditor.commit();
    }

    private static void setAvailableChargeType(Context paramContext, String[] paramArrayOfString) {
        if (sPref == null) {
            init(paramContext);
        }
        int j = paramArrayOfString.length;
        for (int i = 0; i < j; i++) {
            if ("g".equals(paramArrayOfString[i])) {
                paramArrayOfString[i] = paramArrayOfString[j - 1];
                paramArrayOfString[j - 1] = "g";
            } else if ("alipay".equals(paramArrayOfString[i])) {
                paramArrayOfString[i] = paramArrayOfString[0];
                paramArrayOfString[0] = "alipay";
            }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        for (String str : paramArrayOfString) {
            localStringBuilder.append(str).append(Constants.TERM);
        }
        if (localStringBuilder.indexOf(Constants.TERM) != -1) {
            localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        }
        sPref.edit().putString(P_AVAILABLE_CHARGE_TYPE, localStringBuilder.toString()).commit();
    }

    public static IType[] getAvailableChargeType(Context paramContext, boolean paramBoolean) {
        return getDefaultChargeType(paramBoolean);
    }

    private static void setAvailablePayType(Context paramContext, String paramString) {
        if (sPref == null) {
            init(paramContext);
        }
        if (paramString.indexOf("sms") > paramString.indexOf(paramString)) {
            String[] arrayOfString = paramString.split(Constants.TERM);
            int j = arrayOfString.length;
            for (int i = 0; i < j; i++) {
                if ("sms".equals(arrayOfString[i])) {
                    arrayOfString[i] = arrayOfString[j - 1];
                    arrayOfString[j - 1] = "sms";
                } else if (TypeFactory.TYPE_PAY_UPOINT.equals(arrayOfString[i])) {
                    arrayOfString[i] = arrayOfString[0];
                    arrayOfString[0] = TypeFactory.TYPE_PAY_UPOINT;
                }
            }
            StringBuilder localStringBuilder = new StringBuilder();
            for (String str : arrayOfString) {
                localStringBuilder.append(str).append(Constants.TERM);
            }
            if (localStringBuilder.indexOf(Constants.TERM) != -1) {
                localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
            }
            paramString = localStringBuilder.toString();
        }
        sPref.edit().putString(P_AVAILABLE_PAY_TYPE, paramString).commit();
    }

    public static ArrayList<IType> getAvailablePayType(Context paramContext, String paramString) {
        return getDefaultPayType(paramString);
    }

    public static String getDefaultChargeType(Context paramContext) {
        if (sPref == null) {
            init(paramContext);
        }
        return sPref.getString(P_DEFAULT_CHARGE_TYPE, null);
    }

    public static void setDefaultChargeType(Context paramContext, String paramString) {
        if (sPref == null) {
            init(paramContext);
        }
        SharedPreferences.Editor localEditor = sPref.edit();
        if (paramString == null) {
            localEditor.remove(P_DEFAULT_CHARGE_TYPE);
        } else {
            localEditor.putString(P_DEFAULT_CHARGE_TYPE, paramString);
        }
        localEditor.commit();
    }

    private static IType[] getDefaultChargeType(boolean paramBoolean) {
        return paramBoolean ? new IType[]{TypeFactory.factory("alipay"), TypeFactory.factory("phonecard"), TypeFactory.factory("g")} : new IType[]{TypeFactory.factory("alipay"), TypeFactory.factory("phonecard")};
    }

    private static ArrayList<IType> getDefaultPayType(String paramString) {
        ArrayList<IType> localArrayList = new ArrayList<>();
        if (PaymentInfo.PAYTYPE_OVERAGE.equals(paramString) || PaymentInfo.PAYTYPE_ALL.equals(paramString)) {
            localArrayList.add(TypeFactory.factory(TypeFactory.TYPE_PAY_UPOINT));
        }
        if ("sms".equals(paramString) || PaymentInfo.PAYTYPE_ALL.equals(paramString)) {
            localArrayList.add(TypeFactory.factory("sms"));
        }
        return localArrayList;
    }

    public static boolean supportChargeType(Context paramContext, String paramString) {
        IType[] arrayOfIType = getAvailableChargeType(paramContext, true);
        for (IType iType : arrayOfIType) {
            if (paramString.equals(iType.getId())) {
                return true;
            }
        }
        return false;
    }

    public static synchronized void syncChargeChannels(Context paramContext, String[] paramArrayOfString) {
        synchronized (PrefUtil.class) {
            setAvailableChargeType(paramContext, paramArrayOfString);
        }
    }

    public static synchronized void syncPayChannels(Context paramContext, String paramString) {
        synchronized (PrefUtil.class) {
            setAvailablePayType(paramContext, paramString);
        }
    }

    public static void setSmsInfoVersion(Context paramContext, String paramString) {
        if (sPref == null) {
            init(paramContext);
        }
        sPref.edit().putString(P_SMSINFO_VERSION, paramString).commit();
    }

    public static String getSmsInfoVersion(Context paramContext) {
        if (sPref == null) {
            init(paramContext);
        }
        return sPref.getString(P_SMSINFO_VERSION, null);
    }

    public static void setSmsInfo(Context paramContext, String paramString) {
        if (sPref == null) {
            init(paramContext);
        }
        sPref.edit().putString(P_SMSINFO, paramString).commit();
    }

    public static String getSmsInfo(Context paramContext) {
        if (sPref == null) {
            init(paramContext);
        }
        return sPref.getString(P_SMSINFO, null);
    }

    public static int getPayedAmount(Context paramContext) {
        String str = String.valueOf(Utils.getPaymentInfo().getmActionID()) + "_payedAmount";
        if (sPref == null) {
            init(paramContext);
        }
        return sPref.getInt(str, 0);
    }

    public static void setPayedAmount(Context paramContext, int paramInt) {
        if (sPref == null) {
            init(paramContext);
        }
        String str = String.valueOf(Utils.getPaymentInfo().getmActionID()) + "_payedAmount";
        int i = getPayedAmount(paramContext);
        sPref.edit().putInt(str, i + paramInt).commit();
    }

    public static void clearPayedAmount(Context paramContext) {
        if (sPref == null) {
            init(paramContext);
        }
        String str = String.valueOf(Utils.getPaymentInfo().getmActionID()) + "_payedAmount";
        sPref.edit().remove(str).commit();
    }
}
