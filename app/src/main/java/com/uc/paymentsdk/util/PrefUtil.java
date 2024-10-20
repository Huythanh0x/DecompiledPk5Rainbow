package com.uc.paymentsdk.util;

import android.content.Context;
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
   public static SharedPreferences sPref = null;

   public PrefUtil() {
      super();
   }

   public static void clearArriveCount(Context var0) {
      setArriveCount(var0, 0);
   }

   public static void clearPayedAmount(Context var0) {
      if (sPref == null) {
         init(var0);
      }

      String var1 = Utils.getPaymentInfo().getmActionID() + "_payedAmount";
      sPref.edit().remove(var1).commit();
   }

   public static void clearUCUserName(Context var0) {
      if (sPref == null) {
         init(var0);
      }

      SharedPreferences.Editor var1 = sPref.edit();
      var1.remove("pref.com.uc.androidsdk.username");
      var1.commit();
   }

   public static void clearUCUserPass(Context var0) {
      if (sPref == null) {
         init(var0);
      }

      SharedPreferences.Editor var1 = sPref.edit();
      var1.remove("pref.com.uc.androidsdk.passowrd");
      var1.commit();
   }

   public static void decreaseArriveCount(Context var0) {
      synchronized(PrefUtil.class){}

      label71: {
         Throwable var10000;
         label75: {
            int var1;
            boolean var10001;
            try {
               var1 = getArriveCount(var0);
            } catch (Throwable var7) {
               var10000 = var7;
               var10001 = false;
               break label75;
            }

            if (var1 <= 0) {
               break label71;
            }

            label66:
            try {
               setArriveCount(var0, var1 - 1);
               break label71;
            } catch (Throwable var6) {
               var10000 = var6;
               var10001 = false;
               break label66;
            }
         }

         Throwable var8 = var10000;
         throw var8;
      }

   }

   public static int getArriveCount(Context var0) {
      if (sPref == null) {
         init(var0);
      }

      return sPref.getInt("pref.com.uc.androidsdk.arrive", 0);
   }

   public static IType[] getAvailableChargeType(Context var0, boolean var1) {
      return getDefaultChargeType(var1);
   }

   public static ArrayList getAvailablePayType(Context var0, String var1) {
      return getDefaultPayType(var1);
   }

   public static String getDefaultChargeType(Context var0) {
      if (sPref == null) {
         init(var0);
      }

      return sPref.getString("pref.com.uc.androidsdk.defaultChargeType", (String)null);
   }

   private static IType[] getDefaultChargeType(boolean var0) {
      IType[] var1;
      if (var0) {
         var1 = new IType[]{TypeFactory.factory("alipay"), TypeFactory.factory("phonecard"), TypeFactory.factory("g")};
      } else {
         var1 = new IType[]{TypeFactory.factory("alipay"), TypeFactory.factory("phonecard")};
      }

      return var1;
   }

   private static ArrayList getDefaultPayType(String var0) {
      ArrayList var1 = new ArrayList();
      if ("overage".equals(var0) || "all".equals(var0)) {
         var1.add(TypeFactory.factory("upoint"));
      }

      if ("sms".equals(var0) || "all".equals(var0)) {
         var1.add(TypeFactory.factory("sms"));
      }

      return var1;
   }

   public static SharedPreferences.Editor getEditor() {
      SharedPreferences.Editor var0;
      if (sPref == null) {
         var0 = null;
      } else {
         var0 = sPref.edit();
      }

      return var0;
   }

   public static int getGFanUID(Context var0) {
      if (sPref == null) {
         init(var0);
      }

      return sPref.getInt("pref.com.uc.androidsdk.uid", -1);
   }

   public static int getPayedAmount(Context var0) {
      String var1 = Utils.getPaymentInfo().getmActionID() + "_payedAmount";
      if (sPref == null) {
         init(var0);
      }

      return sPref.getInt(var1, 0);
   }

   public static String getSmsInfo(Context var0) {
      if (sPref == null) {
         init(var0);
      }

      return sPref.getString("pref.com.uc.andoridsdk.smsinfo", (String)null);
   }

   public static String getSmsInfoVersion(Context var0) {
      if (sPref == null) {
         init(var0);
      }

      return sPref.getString("pref.com.uc.andoridsdk.smsinfo.version", (String)null);
   }

   public static String getUCUserName(Context var0) {
      if (sPref == null) {
         init(var0);
      }

      return sPref.getString("pref.com.uc.androidsdk.username", (String)null);
   }

   public static String getUCUserPass(Context var0) {
      if (sPref == null) {
         init(var0);
      }

      return sPref.getString("pref.com.uc.androidsdk.passowrd", (String)null);
   }

   public static String getUserSession(Context var0) {
      if (sPref == null) {
         init(var0);
      }

      return sPref.getString("pref.com.uc.androidsdk.usersession", (String)null);
   }

   public static void increaseArriveCount(Context var0) {
      synchronized(PrefUtil.class){}
      boolean var2 = false;

      try {
         var2 = true;
         setArriveCount(var0, getArriveCount(var0) + 1);
         var2 = false;
      } finally {
         if (var2) {
            ;
         }
      }

   }

   private static void init(Context var0) {
      synchronized(PrefUtil.class){}
      boolean var2 = false;

      try {
         var2 = true;
         if (sPref == null) {
            sPref = PreferenceManager.getDefaultSharedPreferences(var0);
         }

         sIsLogin = false;
         var2 = false;
      } finally {
         if (var2) {
            ;
         }
      }

   }

   public static boolean isLogin(Context var0) {
      if (sPref == null) {
         init(var0);
      }

      return sIsLogin;
   }

   public static void login(Context var0) {
      if (sPref == null) {
         init(var0);
      }

      sIsLogin = true;
   }

   public static void logout(Context var0) {
      if (sPref == null) {
         init(var0);
      }

      sIsLogin = false;
      SharedPreferences.Editor var1 = sPref.edit();
      var1.remove("pref.com.uc.androidsdk.uid");
      var1.commit();
   }

   private static void setArriveCount(Context var0, int var1) {
      synchronized(PrefUtil.class){}
      boolean var3 = false;

      try {
         var3 = true;
         if (sPref == null) {
            init(var0);
         }

         sPref.edit().putInt("pref.com.uc.androidsdk.arrive", var1).commit();
         var3 = false;
      } finally {
         if (var3) {
            ;
         }
      }

   }

   private static void setAvailableChargeType(Context var0, String[] var1) {
      if (sPref == null) {
         init(var0);
      }

      int var2 = 0;

      int var3;
      for(var3 = var1.length; var2 < var3; ++var2) {
         if ("g".equals(var1[var2])) {
            var1[var2] = var1[var3 - 1];
            var1[var3 - 1] = "g";
         } else if ("alipay".equals(var1[var2])) {
            var1[var2] = var1[0];
            var1[0] = "alipay";
         }
      }

      StringBuilder var4 = new StringBuilder();
      var2 = 0;

      for(var3 = var1.length; var2 < var3; ++var2) {
         var4.append(var1[var2]).append(",");
      }

      if (var4.indexOf(",") != -1) {
         var4.deleteCharAt(var4.length() - 1);
      }

      sPref.edit().putString("pref.com.uc.androidsdk.availableChargeType", var4.toString()).commit();
   }

   private static void setAvailablePayType(Context var0, String var1) {
      if (sPref == null) {
         init(var0);
      }

      String var4 = var1;
      if (var1.indexOf("sms") > var1.indexOf(var1)) {
         String[] var6 = var1.split(",");
         int var2 = 0;

         int var3;
         for(var3 = var6.length; var2 < var3; ++var2) {
            if ("sms".equals(var6[var2])) {
               var6[var2] = var6[var3 - 1];
               var6[var3 - 1] = "sms";
            } else if ("upoint".equals(var6[var2])) {
               var6[var2] = var6[0];
               var6[0] = "upoint";
            }
         }

         StringBuilder var5 = new StringBuilder();
         var2 = 0;

         for(var3 = var6.length; var2 < var3; ++var2) {
            var5.append(var6[var2]).append(",");
         }

         if (var5.indexOf(",") != -1) {
            var5.deleteCharAt(var5.length() - 1);
         }

         var4 = var5.toString();
      }

      sPref.edit().putString("pref.com.uc.androidsdk.availablePayType", var4).commit();
   }

   public static void setDefaultChargeType(Context var0, String var1) {
      if (sPref == null) {
         init(var0);
      }

      SharedPreferences.Editor var2 = sPref.edit();
      if (var1 == null) {
         var2.remove("pref.com.uc.androidsdk.defaultChargeType");
      } else {
         var2.putString("pref.com.uc.androidsdk.defaultChargeType", var1);
      }

      var2.commit();
   }

   public static void setGFanUID(Context var0, int var1) {
      if (sPref == null) {
         init(var0);
      }

      SharedPreferences.Editor var2 = sPref.edit();
      var2.putInt("pref.com.uc.androidsdk.uid", var1);
      var2.commit();
   }

   public static void setPayedAmount(Context var0, int var1) {
      if (sPref == null) {
         init(var0);
      }

      String var3 = Utils.getPaymentInfo().getmActionID() + "_payedAmount";
      int var2 = getPayedAmount(var0);
      sPref.edit().putInt(var3, var2 + var1).commit();
   }

   public static void setSmsInfo(Context var0, String var1) {
      if (sPref == null) {
         init(var0);
      }

      sPref.edit().putString("pref.com.uc.andoridsdk.smsinfo", var1).commit();
   }

   public static void setSmsInfoVersion(Context var0, String var1) {
      if (sPref == null) {
         init(var0);
      }

      sPref.edit().putString("pref.com.uc.andoridsdk.smsinfo.version", var1).commit();
   }

   public static void setUCUserName(Context var0, String var1) {
      if (sPref == null) {
         init(var0);
      }

      SharedPreferences.Editor var2 = sPref.edit();
      var2.putString("pref.com.uc.androidsdk.username", var1);
      var2.commit();
   }

   public static void setUCUserPass(Context var0, String var1) {
      if (sPref == null) {
         init(var0);
      }

      SharedPreferences.Editor var2 = sPref.edit();
      var2.putString("pref.com.uc.androidsdk.passowrd", var1);
      var2.commit();
   }

   public static void setUserSession(Context var0, String var1) {
      if (sPref == null) {
         init(var0);
      }

      SharedPreferences.Editor var2 = sPref.edit();
      var2.putString("pref.com.uc.androidsdk.usersession", var1);
      var2.commit();
   }

   public static boolean supportChargeType(Context var0, String var1) {
      IType[] var5 = getAvailableChargeType(var0, true);
      int var2 = 0;
      int var3 = var5.length;

      boolean var4;
      while(true) {
         if (var2 >= var3) {
            var4 = false;
            break;
         }

         if (var1.equals(var5[var2].getId())) {
            var4 = true;
            break;
         }

         ++var2;
      }

      return var4;
   }

   public static void syncChargeChannels(Context var0, String[] var1) {
      synchronized(PrefUtil.class){}
      boolean var3 = false;

      try {
         var3 = true;
         setAvailableChargeType(var0, var1);
         var3 = false;
      } finally {
         if (var3) {
            ;
         }
      }

   }

   public static void syncPayChannels(Context var0, String var1) {
      synchronized(PrefUtil.class){}
      boolean var3 = false;

      try {
         var3 = true;
         setAvailablePayType(var0, var1);
         var3 = false;
      } finally {
         if (var3) {
            ;
         }
      }

   }
}
