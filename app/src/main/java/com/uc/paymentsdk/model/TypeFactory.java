package com.uc.paymentsdk.model;

import com.uc.paymentsdk.util.Utils;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class TypeFactory {
  public static final String TYPE_PAY_SMS = "sms";
  
  public static final String TYPE_PAY_UPOINT = "upoint";
  
  private static HashMap<String, SoftReference<IType>> sTypes;
  
  public static void clear() {
    sTypes = null;
  }
  
  public static IType factory(String paramString) {
    // Byte code:
    //   0: ldc com/uc/paymentsdk/model/TypeFactory
    //   2: monitorenter
    //   3: getstatic com/uc/paymentsdk/model/TypeFactory.sTypes : Ljava/util/HashMap;
    //   6: ifnonnull -> 22
    //   9: new java/util/HashMap
    //   12: astore_1
    //   13: aload_1
    //   14: iconst_4
    //   15: invokespecial <init> : (I)V
    //   18: aload_1
    //   19: putstatic com/uc/paymentsdk/model/TypeFactory.sTypes : Ljava/util/HashMap;
    //   22: getstatic com/uc/paymentsdk/model/TypeFactory.sTypes : Ljava/util/HashMap;
    //   25: aload_0
    //   26: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   29: ifeq -> 60
    //   32: getstatic com/uc/paymentsdk/model/TypeFactory.sTypes : Ljava/util/HashMap;
    //   35: aload_0
    //   36: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast java/lang/ref/SoftReference
    //   42: invokevirtual get : ()Ljava/lang/Object;
    //   45: checkcast com/uc/paymentsdk/model/IType
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull -> 60
    //   53: aload_1
    //   54: astore_0
    //   55: ldc com/uc/paymentsdk/model/TypeFactory
    //   57: monitorexit
    //   58: aload_0
    //   59: areturn
    //   60: ldc 'upoint'
    //   62: aload_0
    //   63: invokevirtual equals : (Ljava/lang/Object;)Z
    //   66: ifne -> 78
    //   69: ldc 'sms'
    //   71: aload_0
    //   72: invokevirtual equals : (Ljava/lang/Object;)Z
    //   75: ifeq -> 124
    //   78: new com/uc/paymentsdk/model/PayType
    //   81: astore_1
    //   82: aload_1
    //   83: aload_0
    //   84: aload_0
    //   85: invokestatic getTypeName : (Ljava/lang/String;)Ljava/lang/String;
    //   88: aload_0
    //   89: invokestatic getTypeDesc : (Ljava/lang/String;)Ljava/lang/String;
    //   92: aload_0
    //   93: invokestatic getTypeIconFileName : (Ljava/lang/String;)Ljava/lang/String;
    //   96: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   99: getstatic com/uc/paymentsdk/model/TypeFactory.sTypes : Ljava/util/HashMap;
    //   102: astore_3
    //   103: new java/lang/ref/SoftReference
    //   106: astore_2
    //   107: aload_2
    //   108: aload_1
    //   109: invokespecial <init> : (Ljava/lang/Object;)V
    //   112: aload_3
    //   113: aload_0
    //   114: aload_2
    //   115: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   118: pop
    //   119: aload_1
    //   120: astore_0
    //   121: goto -> 55
    //   124: new com/uc/paymentsdk/model/ChargeType
    //   127: dup
    //   128: aload_0
    //   129: aload_0
    //   130: invokestatic getTypeName : (Ljava/lang/String;)Ljava/lang/String;
    //   133: aload_0
    //   134: invokestatic getTypeDesc : (Ljava/lang/String;)Ljava/lang/String;
    //   137: aload_0
    //   138: invokestatic getTypeIconFileName : (Ljava/lang/String;)Ljava/lang/String;
    //   141: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   144: astore_1
    //   145: goto -> 99
    //   148: astore_0
    //   149: ldc com/uc/paymentsdk/model/TypeFactory
    //   151: monitorexit
    //   152: aload_0
    //   153: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	148	finally
    //   22	49	148	finally
    //   60	78	148	finally
    //   78	99	148	finally
    //   99	119	148	finally
    //   124	145	148	finally
  }
  
  private static String getTypeDesc(String paramString) {
    if ("upoint".equals(paramString))
      return "用U点购买<br /><small><small><font color='#999999'>10U点价值1元</font></small></small>"; 
    if ("sms".equals(paramString))
      return String.format("发短信直接购买<br /><small><small><font color='#999999'>发送%s元短信，可购买该内容</font></small></small>", new Object[] { Integer.valueOf(Utils.getSmsPayment()) }); 
    throw new IllegalArgumentException("type not supported. " + paramString);
  }
  
  private static String getTypeIconFileName(String paramString) {
    boolean bool = Utils.isHdpi();
    if ("upoint".equals(paramString))
      return bool ? "upoint_logo_hdpi.png" : "upoint_logo.png"; 
    if ("sms".equals(paramString))
      return bool ? "sms_logo_hdpi.png" : "sms_logo.png"; 
    throw new IllegalArgumentException("type not supported.");
  }
  
  private static String getTypeName(String paramString) {
    return null;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/model/TypeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */