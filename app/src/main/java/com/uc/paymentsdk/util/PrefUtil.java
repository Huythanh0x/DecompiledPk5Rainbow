package com.uc.paymentsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
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
  
  public static void clearArriveCount(Context paramContext) {
    setArriveCount(paramContext, 0);
  }
  
  public static void clearPayedAmount(Context paramContext) {
    if (sPref == null)
      init(paramContext); 
    String str = String.valueOf(Utils.getPaymentInfo().getmActionID()) + "_payedAmount";
    sPref.edit().remove(str).commit();
  }
  
  public static void clearUCUserName(Context paramContext) {
    if (sPref == null)
      init(paramContext); 
    SharedPreferences.Editor editor = sPref.edit();
    editor.remove("pref.com.uc.androidsdk.username");
    editor.commit();
  }
  
  public static void clearUCUserPass(Context paramContext) {
    if (sPref == null)
      init(paramContext); 
    SharedPreferences.Editor editor = sPref.edit();
    editor.remove("pref.com.uc.androidsdk.passowrd");
    editor.commit();
  }
  
  public static void decreaseArriveCount(Context paramContext) {
    // Byte code:
    //   0: ldc com/uc/paymentsdk/util/PrefUtil
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic getArriveCount : (Landroid/content/Context;)I
    //   7: istore_1
    //   8: iload_1
    //   9: ifle -> 19
    //   12: aload_0
    //   13: iload_1
    //   14: iconst_1
    //   15: isub
    //   16: invokestatic setArriveCount : (Landroid/content/Context;I)V
    //   19: ldc com/uc/paymentsdk/util/PrefUtil
    //   21: monitorexit
    //   22: return
    //   23: astore_0
    //   24: ldc com/uc/paymentsdk/util/PrefUtil
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	23	finally
    //   12	19	23	finally
  }
  
  public static int getArriveCount(Context paramContext) {
    if (sPref == null)
      init(paramContext); 
    return sPref.getInt("pref.com.uc.androidsdk.arrive", 0);
  }
  
  public static IType[] getAvailableChargeType(Context paramContext, boolean paramBoolean) {
    return getDefaultChargeType(paramBoolean);
  }
  
  public static ArrayList<IType> getAvailablePayType(Context paramContext, String paramString) {
    return getDefaultPayType(paramString);
  }
  
  public static String getDefaultChargeType(Context paramContext) {
    if (sPref == null)
      init(paramContext); 
    return sPref.getString("pref.com.uc.androidsdk.defaultChargeType", null);
  }
  
  private static IType[] getDefaultChargeType(boolean paramBoolean) {
    if (paramBoolean) {
      IType[] arrayOfIType1 = new IType[3];
      arrayOfIType1[0] = TypeFactory.factory("alipay");
      arrayOfIType1[1] = TypeFactory.factory("phonecard");
      arrayOfIType1[2] = TypeFactory.factory("g");
      return arrayOfIType1;
    } 
    IType[] arrayOfIType = new IType[2];
    arrayOfIType[0] = TypeFactory.factory("alipay");
    arrayOfIType[1] = TypeFactory.factory("phonecard");
    return arrayOfIType;
  }
  
  private static ArrayList<IType> getDefaultPayType(String paramString) {
    ArrayList<IType> arrayList = new ArrayList();
    if ("overage".equals(paramString) || "all".equals(paramString))
      arrayList.add(TypeFactory.factory("upoint")); 
    if ("sms".equals(paramString) || "all".equals(paramString))
      arrayList.add(TypeFactory.factory("sms")); 
    return arrayList;
  }
  
  public static SharedPreferences.Editor getEditor() {
    return (sPref == null) ? null : sPref.edit();
  }
  
  public static int getGFanUID(Context paramContext) {
    if (sPref == null)
      init(paramContext); 
    return sPref.getInt("pref.com.uc.androidsdk.uid", -1);
  }
  
  public static int getPayedAmount(Context paramContext) {
    String str = String.valueOf(Utils.getPaymentInfo().getmActionID()) + "_payedAmount";
    if (sPref == null)
      init(paramContext); 
    return sPref.getInt(str, 0);
  }
  
  public static String getSmsInfo(Context paramContext) {
    if (sPref == null)
      init(paramContext); 
    return sPref.getString("pref.com.uc.andoridsdk.smsinfo", null);
  }
  
  public static String getSmsInfoVersion(Context paramContext) {
    if (sPref == null)
      init(paramContext); 
    return sPref.getString("pref.com.uc.andoridsdk.smsinfo.version", null);
  }
  
  public static String getUCUserName(Context paramContext) {
    if (sPref == null)
      init(paramContext); 
    return sPref.getString("pref.com.uc.androidsdk.username", null);
  }
  
  public static String getUCUserPass(Context paramContext) {
    if (sPref == null)
      init(paramContext); 
    return sPref.getString("pref.com.uc.androidsdk.passowrd", null);
  }
  
  public static String getUserSession(Context paramContext) {
    if (sPref == null)
      init(paramContext); 
    return sPref.getString("pref.com.uc.androidsdk.usersession", null);
  }
  
  public static void increaseArriveCount(Context paramContext) {
    // Byte code:
    //   0: ldc com/uc/paymentsdk/util/PrefUtil
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_0
    //   5: invokestatic getArriveCount : (Landroid/content/Context;)I
    //   8: iconst_1
    //   9: iadd
    //   10: invokestatic setArriveCount : (Landroid/content/Context;I)V
    //   13: ldc com/uc/paymentsdk/util/PrefUtil
    //   15: monitorexit
    //   16: return
    //   17: astore_0
    //   18: ldc com/uc/paymentsdk/util/PrefUtil
    //   20: monitorexit
    //   21: aload_0
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	17	finally
  }
  
  private static void init(Context paramContext) {
    // Byte code:
    //   0: ldc com/uc/paymentsdk/util/PrefUtil
    //   2: monitorenter
    //   3: getstatic com/uc/paymentsdk/util/PrefUtil.sPref : Landroid/content/SharedPreferences;
    //   6: ifnonnull -> 16
    //   9: aload_0
    //   10: invokestatic getDefaultSharedPreferences : (Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   13: putstatic com/uc/paymentsdk/util/PrefUtil.sPref : Landroid/content/SharedPreferences;
    //   16: iconst_0
    //   17: putstatic com/uc/paymentsdk/util/PrefUtil.sIsLogin : Z
    //   20: ldc com/uc/paymentsdk/util/PrefUtil
    //   22: monitorexit
    //   23: return
    //   24: astore_0
    //   25: ldc com/uc/paymentsdk/util/PrefUtil
    //   27: monitorexit
    //   28: aload_0
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	24	finally
    //   16	20	24	finally
  }
  
  public static boolean isLogin(Context paramContext) {
    if (sPref == null)
      init(paramContext); 
    return sIsLogin;
  }
  
  public static void login(Context paramContext) {
    if (sPref == null)
      init(paramContext); 
    sIsLogin = true;
  }
  
  public static void logout(Context paramContext) {
    if (sPref == null)
      init(paramContext); 
    sIsLogin = false;
    SharedPreferences.Editor editor = sPref.edit();
    editor.remove("pref.com.uc.androidsdk.uid");
    editor.commit();
  }
  
  private static void setArriveCount(Context paramContext, int paramInt) {
    // Byte code:
    //   0: ldc com/uc/paymentsdk/util/PrefUtil
    //   2: monitorenter
    //   3: getstatic com/uc/paymentsdk/util/PrefUtil.sPref : Landroid/content/SharedPreferences;
    //   6: ifnonnull -> 13
    //   9: aload_0
    //   10: invokestatic init : (Landroid/content/Context;)V
    //   13: getstatic com/uc/paymentsdk/util/PrefUtil.sPref : Landroid/content/SharedPreferences;
    //   16: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   21: ldc 'pref.com.uc.androidsdk.arrive'
    //   23: iload_1
    //   24: invokeinterface putInt : (Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   29: invokeinterface commit : ()Z
    //   34: pop
    //   35: ldc com/uc/paymentsdk/util/PrefUtil
    //   37: monitorexit
    //   38: return
    //   39: astore_0
    //   40: ldc com/uc/paymentsdk/util/PrefUtil
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	39	finally
    //   13	35	39	finally
  }
  
  private static void setAvailableChargeType(Context paramContext, String[] paramArrayOfString) {
    if (sPref == null)
      init(paramContext); 
    byte b = 0;
    int i = paramArrayOfString.length;
    while (true) {
      if (b >= i) {
        StringBuilder stringBuilder = new StringBuilder();
        b = 0;
        i = paramArrayOfString.length;
        while (true) {
          if (b >= i) {
            if (stringBuilder.indexOf(",") != -1)
              stringBuilder.deleteCharAt(stringBuilder.length() - 1); 
            sPref.edit().putString("pref.com.uc.androidsdk.availableChargeType", stringBuilder.toString()).commit();
            return;
          } 
          stringBuilder.append(paramArrayOfString[b]).append(",");
          b++;
        } 
        break;
      } 
      if ("g".equals(paramArrayOfString[b])) {
        paramArrayOfString[b] = paramArrayOfString[i - 1];
        paramArrayOfString[i - 1] = "g";
      } else if ("alipay".equals(paramArrayOfString[b])) {
        paramArrayOfString[b] = paramArrayOfString[0];
        paramArrayOfString[0] = "alipay";
      } 
      b++;
    } 
  }
  
  private static void setAvailablePayType(Context paramContext, String paramString) {
    if (sPref == null)
      init(paramContext); 
    String str = paramString;
    if (paramString.indexOf("sms") > paramString.indexOf(paramString)) {
      String[] arrayOfString = paramString.split(",");
      byte b = 0;
      int i = arrayOfString.length;
      while (true) {
        if (b >= i) {
          StringBuilder stringBuilder = new StringBuilder();
          b = 0;
          i = arrayOfString.length;
          while (true) {
            if (b >= i) {
              if (stringBuilder.indexOf(",") != -1)
                stringBuilder.deleteCharAt(stringBuilder.length() - 1); 
              str = stringBuilder.toString();
            } else {
              stringBuilder.append(str[b]).append(",");
              b++;
              continue;
            } 
            sPref.edit().putString("pref.com.uc.androidsdk.availablePayType", str).commit();
            return;
          } 
          break;
        } 
        if ("sms".equals(str[b])) {
          str[b] = str[i - 1];
          str[i - 1] = "sms";
        } else if ("upoint".equals(str[b])) {
          str[b] = str[0];
          str[0] = "upoint";
        } 
        b++;
      } 
    } 
    sPref.edit().putString("pref.com.uc.androidsdk.availablePayType", str).commit();
  }
  
  public static void setDefaultChargeType(Context paramContext, String paramString) {
    if (sPref == null)
      init(paramContext); 
    SharedPreferences.Editor editor = sPref.edit();
    if (paramString == null) {
      editor.remove("pref.com.uc.androidsdk.defaultChargeType");
    } else {
      editor.putString("pref.com.uc.androidsdk.defaultChargeType", paramString);
    } 
    editor.commit();
  }
  
  public static void setGFanUID(Context paramContext, int paramInt) {
    if (sPref == null)
      init(paramContext); 
    SharedPreferences.Editor editor = sPref.edit();
    editor.putInt("pref.com.uc.androidsdk.uid", paramInt);
    editor.commit();
  }
  
  public static void setPayedAmount(Context paramContext, int paramInt) {
    if (sPref == null)
      init(paramContext); 
    String str = String.valueOf(Utils.getPaymentInfo().getmActionID()) + "_payedAmount";
    int i = getPayedAmount(paramContext);
    sPref.edit().putInt(str, i + paramInt).commit();
  }
  
  public static void setSmsInfo(Context paramContext, String paramString) {
    if (sPref == null)
      init(paramContext); 
    sPref.edit().putString("pref.com.uc.andoridsdk.smsinfo", paramString).commit();
  }
  
  public static void setSmsInfoVersion(Context paramContext, String paramString) {
    if (sPref == null)
      init(paramContext); 
    sPref.edit().putString("pref.com.uc.andoridsdk.smsinfo.version", paramString).commit();
  }
  
  public static void setUCUserName(Context paramContext, String paramString) {
    if (sPref == null)
      init(paramContext); 
    SharedPreferences.Editor editor = sPref.edit();
    editor.putString("pref.com.uc.androidsdk.username", paramString);
    editor.commit();
  }
  
  public static void setUCUserPass(Context paramContext, String paramString) {
    if (sPref == null)
      init(paramContext); 
    SharedPreferences.Editor editor = sPref.edit();
    editor.putString("pref.com.uc.androidsdk.passowrd", paramString);
    editor.commit();
  }
  
  public static void setUserSession(Context paramContext, String paramString) {
    if (sPref == null)
      init(paramContext); 
    SharedPreferences.Editor editor = sPref.edit();
    editor.putString("pref.com.uc.androidsdk.usersession", paramString);
    editor.commit();
  }
  
  public static boolean supportChargeType(Context paramContext, String paramString) {
    IType[] arrayOfIType = getAvailableChargeType(paramContext, true);
    byte b = 0;
    int i = arrayOfIType.length;
    while (true) {
      if (b >= i)
        return false; 
      if (paramString.equals(arrayOfIType[b].getId()))
        return true; 
      b++;
    } 
  }
  
  public static void syncChargeChannels(Context paramContext, String[] paramArrayOfString) {
    // Byte code:
    //   0: ldc com/uc/paymentsdk/util/PrefUtil
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: invokestatic setAvailableChargeType : (Landroid/content/Context;[Ljava/lang/String;)V
    //   8: ldc com/uc/paymentsdk/util/PrefUtil
    //   10: monitorexit
    //   11: return
    //   12: astore_0
    //   13: ldc com/uc/paymentsdk/util/PrefUtil
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	12	finally
  }
  
  public static void syncPayChannels(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/uc/paymentsdk/util/PrefUtil
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: invokestatic setAvailablePayType : (Landroid/content/Context;Ljava/lang/String;)V
    //   8: ldc com/uc/paymentsdk/util/PrefUtil
    //   10: monitorexit
    //   11: return
    //   12: astore_0
    //   13: ldc com/uc/paymentsdk/util/PrefUtil
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	12	finally
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/util/PrefUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */