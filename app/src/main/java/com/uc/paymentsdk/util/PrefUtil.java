package com.uc.paymentsdk.util.PrefUtil;
import java.lang.Object;
import android.content.Context;
import java.lang.StringBuilder;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.util.Utils;
import java.lang.String;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import com.uc.paymentsdk.model.IType;
import java.util.ArrayList;
import com.uc.paymentsdk.model.TypeFactory;
import android.preference.PreferenceManager;

public class PrefUtil	// class@0000d5 from classes.dex
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
    public void PrefUtil(){
       super();
    }
    public static void clearArriveCount(Context paramContext){
       PrefUtil.setArriveCount(paramContext, 0);
    }
    public static void clearPayedAmount(Context paramContext){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       String str = String.valueOf(Utils.getPaymentInfo().getmActionID())+"_payedAmount";
       PrefUtil.sPref.edit().remove(str).commit();
       return;
    }
    public static void clearUCUserName(Context paramContext){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       SharedPreferences$Editor localEditor = PrefUtil.sPref.edit();
       localEditor.remove("pref.com.uc.androidsdk.username");
       localEditor.commit();
       return;
    }
    public static void clearUCUserPass(Context paramContext){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       SharedPreferences$Editor localEditor = PrefUtil.sPref.edit();
       localEditor.remove("pref.com.uc.androidsdk.passowrd");
       localEditor.commit();
       return;
    }
    public static synchronized void decreaseArriveCount(Context paramContext){
       int i;
       _monitor_enter(PrefUtil.class);
       if ((i = PrefUtil.getArriveCount(paramContext)) > 0) {
          PrefUtil.setArriveCount(paramContext, (i - 1));
       }
       _monitor_exit(PrefUtil.class);
       return;
    }
    public static int getArriveCount(Context paramContext){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       return PrefUtil.sPref.getInt("pref.com.uc.androidsdk.arrive", 0);
    }
    public static IType[] getAvailableChargeType(Context paramContext,boolean paramBoolean){
       return PrefUtil.getDefaultChargeType(paramBoolean);
    }
    public static ArrayList getAvailablePayType(Context paramContext,String paramString){
       return PrefUtil.getDefaultPayType(paramString);
    }
    public static String getDefaultChargeType(Context paramContext){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       return PrefUtil.sPref.getString("pref.com.uc.androidsdk.defaultChargeType", null);
    }
    private static IType[] getDefaultChargeType(boolean paramBoolean){
       IType[] iTypeArray;
       if (paramBoolean) {
          iTypeArray = new IType[]{TypeFactory.factory("alipay"),TypeFactory.factory("phonecard"),TypeFactory.factory("g")};
       }else {
          iTypeArray = new IType[]{TypeFactory.factory("alipay"),TypeFactory.factory("phonecard")};
       }
       return iTypeArray;
    }
    private static ArrayList getDefaultPayType(String paramString){
       ArrayList localArrayList = new ArrayList();
       if ("overage".equals(paramString) || "all".equals(paramString)) {
          localArrayList.add(TypeFactory.factory("upoint"));
       }
       if ("sms".equals(paramString) || "all".equals(paramString)) {
          localArrayList.add(TypeFactory.factory("sms"));
       }
       return localArrayList;
    }
    public static SharedPreferences$Editor getEditor(){
       SharedPreferences$Editor uEditor = (PrefUtil.sPref == null)? null: PrefUtil.sPref.edit();
       return uEditor;
    }
    public static int getGFanUID(Context paramContext){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       return PrefUtil.sPref.getInt("pref.com.uc.androidsdk.uid", -1);
    }
    public static int getPayedAmount(Context paramContext){
       String str = String.valueOf(Utils.getPaymentInfo().getmActionID())+"_payedAmount";
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       return PrefUtil.sPref.getInt(str, 0);
    }
    public static String getSmsInfo(Context paramContext){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       return PrefUtil.sPref.getString("pref.com.uc.andoridsdk.smsinfo", null);
    }
    public static String getSmsInfoVersion(Context paramContext){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       return PrefUtil.sPref.getString("pref.com.uc.andoridsdk.smsinfo.version", null);
    }
    public static String getUCUserName(Context paramContext){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       return PrefUtil.sPref.getString("pref.com.uc.androidsdk.username", null);
    }
    public static String getUCUserPass(Context paramContext){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       return PrefUtil.sPref.getString("pref.com.uc.androidsdk.passowrd", null);
    }
    public static String getUserSession(Context paramContext){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       return PrefUtil.sPref.getString("pref.com.uc.androidsdk.usersession", null);
    }
    public static synchronized void increaseArriveCount(Context paramContext){
       _monitor_enter(PrefUtil.class);
       int i = PrefUtil.getArriveCount(paramContext);
       PrefUtil.setArriveCount(paramContext, (i + 1));
       _monitor_exit(PrefUtil.class);
    }
    private static synchronized void init(Context paramContext){
       _monitor_enter(PrefUtil.class);
       if (PrefUtil.sPref == null) {
          PrefUtil.sPref = PreferenceManager.getDefaultSharedPreferences(paramContext);
       }
       PrefUtil.sIsLogin = false;
       _monitor_exit(PrefUtil.class);
       return;
    }
    public static boolean isLogin(Context paramContext){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       return PrefUtil.sIsLogin;
    }
    public static void login(Context paramContext){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       PrefUtil.sIsLogin = true;
       return;
    }
    public static void logout(Context paramContext){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       PrefUtil.sIsLogin = false;
       SharedPreferences$Editor localEditor = PrefUtil.sPref.edit();
       localEditor.remove("pref.com.uc.androidsdk.uid");
       localEditor.commit();
       return;
    }
    private static synchronized void setArriveCount(Context paramContext,int paramInt){
       _monitor_enter(PrefUtil.class);
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       PrefUtil.sPref.edit().putInt("pref.com.uc.androidsdk.arrive", paramInt).commit();
       _monitor_exit(PrefUtil.class);
       return;
    }
    private static void setAvailableChargeType(Context paramContext,String[] paramArrayOfString){
       int ix = 1;
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       int i = 0;
       int j = paramArrayOfString.length;
       while (i < j) {
          if ("g".equals(paramArrayOfString[i])) {
             int ix1 = j - ix;
             paramArrayOfString[i] = paramArrayOfString[ix1];
             ix1 = j - ix;
             paramArrayOfString[ix1] = "g";
          }else if("alipay".equals(paramArrayOfString[i])){
             paramArrayOfString[i] = paramArrayOfString[0];
             paramArrayOfString[0] = "alipay";
          }
          i++;
       }
       StringBuilder localStringBuilder = "";
       int k = paramArrayOfString.length;
       for (j = 0; j < k; j++) {
          StringBuilder localStringBuilder1 = localStringBuilder.append(paramArrayOfString[j]);
          localStringBuilder1 = localStringBuilder1.append(",");
       }
       if (localStringBuilder.indexOf(",") != -1) {
          localStringBuilder.deleteCharAt((localStringBuilder.length() - ix));
       }
       PrefUtil.sPref.edit().putString("pref.com.uc.androidsdk.availableChargeType", localStringBuilder).commit();
       return;
    }
    private static void setAvailablePayType(Context paramContext,String paramString){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       if (paramString.indexOf("sms") > paramString.indexOf(paramString)) {
          String[] arrayOfString = paramString.split(",");
          int i = 0;
          int j = arrayOfString.length;
          while (i < j) {
             if ("sms".equals(arrayOfString[i])) {
                int ix = j - 1;
                arrayOfString[i] = arrayOfString[ix];
                ix = j - 1;
                arrayOfString[ix] = "sms";
             }else if("upoint".equals(arrayOfString[i])){
                arrayOfString[i] = arrayOfString[0];
                arrayOfString[0] = "upoint";
             }
             i++;
          }
          StringBuilder localStringBuilder = "";
          int k = arrayOfString.length;
          for (j = 0; j < k; j++) {
             StringBuilder localStringBuilder1 = localStringBuilder.append(arrayOfString[j]);
             localStringBuilder1 = localStringBuilder1.append(",");
          }
          if (localStringBuilder.indexOf(",") != -1) {
             localStringBuilder.deleteCharAt((localStringBuilder.length() - 1));
          }
          paramString = localStringBuilder;
       }
       PrefUtil.sPref.edit().putString("pref.com.uc.androidsdk.availablePayType", paramString).commit();
       return;
    }
    public static void setDefaultChargeType(Context paramContext,String paramString){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       SharedPreferences$Editor localEditor = PrefUtil.sPref.edit();
       if (paramString == null) {
          localEditor.remove("pref.com.uc.androidsdk.defaultChargeType");
       }else {
          localEditor.putString("pref.com.uc.androidsdk.defaultChargeType", paramString);
       }
       localEditor.commit();
       return;
    }
    public static void setGFanUID(Context paramContext,int paramInt){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       SharedPreferences$Editor localEditor = PrefUtil.sPref.edit();
       localEditor.putInt("pref.com.uc.androidsdk.uid", paramInt);
       localEditor.commit();
       return;
    }
    public static void setPayedAmount(Context paramContext,int paramInt){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       String str = String.valueOf(Utils.getPaymentInfo().getmActionID())+"_payedAmount";
       int i = PrefUtil.getPayedAmount(paramContext);
       PrefUtil.sPref.edit().putInt(str, (i + paramInt)).commit();
       return;
    }
    public static void setSmsInfo(Context paramContext,String paramString){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       PrefUtil.sPref.edit().putString("pref.com.uc.andoridsdk.smsinfo", paramString).commit();
       return;
    }
    public static void setSmsInfoVersion(Context paramContext,String paramString){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       PrefUtil.sPref.edit().putString("pref.com.uc.andoridsdk.smsinfo.version", paramString).commit();
       return;
    }
    public static void setUCUserName(Context paramContext,String paramString){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       SharedPreferences$Editor localEditor = PrefUtil.sPref.edit();
       localEditor.putString("pref.com.uc.androidsdk.username", paramString);
       localEditor.commit();
       return;
    }
    public static void setUCUserPass(Context paramContext,String paramString){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       SharedPreferences$Editor localEditor = PrefUtil.sPref.edit();
       localEditor.putString("pref.com.uc.androidsdk.passowrd", paramString);
       localEditor.commit();
       return;
    }
    public static void setUserSession(Context paramContext,String paramString){
       if (PrefUtil.sPref == null) {
          PrefUtil.init(paramContext);
       }
       SharedPreferences$Editor localEditor = PrefUtil.sPref.edit();
       localEditor.putString("pref.com.uc.androidsdk.usersession", paramString);
       localEditor.commit();
       return;
    }
    public static boolean supportChargeType(Context paramContext,String paramString){
       boolean b;
       IType[] arrayOfIType = PrefUtil.getAvailableChargeType(paramContext, true);
       int i = 0;
       int j = arrayOfIType.length;
       while (true) {
          if (i >= j) {
             b = false;
             break ;
          }else if(paramString.equals(arrayOfIType[i].getId())){
             b = true;
             break ;
          }else {
             i++;
          }
       }
       return b;
    }
    public static synchronized void syncChargeChannels(Context paramContext,String[] paramArrayOfString){
       _monitor_enter(PrefUtil.class);
       PrefUtil.setAvailableChargeType(paramContext, paramArrayOfString);
       _monitor_exit(PrefUtil.class);
    }
    public static synchronized void syncPayChannels(Context paramContext,String paramString){
       _monitor_enter(PrefUtil.class);
       PrefUtil.setAvailablePayType(paramContext, paramString);
       _monitor_exit(PrefUtil.class);
    }
}
