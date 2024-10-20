package com.uc.paymentsdk.model;

import com.uc.paymentsdk.util.Utils;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class TypeFactory {
   public static final String TYPE_PAY_SMS = "sms";
   public static final String TYPE_PAY_UPOINT = "upoint";
   private static HashMap sTypes;

   public TypeFactory() {
      super();
   }

   public static void clear() {
      sTypes = null;
   }

   public static IType factory(String var0) {
      synchronized(TypeFactory.class){}

      Object var46;
      label435: {
         Object var49;
         label434: {
            Throwable var10000;
            label439: {
               boolean var10001;
               try {
                  if (sTypes == null) {
                     HashMap var1 = new HashMap(4);
                     sTypes = var1;
                  }
               } catch (Throwable var45) {
                  var10000 = var45;
                  var10001 = false;
                  break label439;
               }

               label429: {
                  IType var48;
                  try {
                     if (!sTypes.containsKey(var0)) {
                        break label429;
                     }

                     var48 = (IType)((SoftReference)sTypes.get(var0)).get();
                  } catch (Throwable var44) {
                     var10000 = var44;
                     var10001 = false;
                     break label439;
                  }

                  if (var48 != null) {
                     var46 = var48;
                     break label435;
                  }
               }

               label440: {
                  label421: {
                     try {
                        if (!"upoint".equals(var0) && !"sms".equals(var0)) {
                           break label421;
                        }
                     } catch (Throwable var43) {
                        var10000 = var43;
                        var10001 = false;
                        break label439;
                     }

                     try {
                        var49 = new PayType(var0, getTypeName(var0), getTypeDesc(var0), getTypeIconFileName(var0));
                        break label440;
                     } catch (Throwable var42) {
                        var10000 = var42;
                        var10001 = false;
                        break label439;
                     }
                  }

                  try {
                     var49 = new ChargeType(var0, getTypeName(var0), getTypeDesc(var0), getTypeIconFileName(var0));
                  } catch (Throwable var41) {
                     var10000 = var41;
                     var10001 = false;
                     break label439;
                  }
               }

               label409:
               try {
                  HashMap var2 = sTypes;
                  SoftReference var3 = new SoftReference(var49);
                  var2.put(var0, var3);
                  break label434;
               } catch (Throwable var40) {
                  var10000 = var40;
                  var10001 = false;
                  break label409;
               }
            }

            Throwable var47 = var10000;
            throw var47;
         }

         var46 = var49;
      }

      return (IType)var46;
   }

   private static String getTypeDesc(String var0) {
      if ("upoint".equals(var0)) {
         var0 = "\u7528U\u70b9\u8d2d\u4e70<br /><small><small><font color='#999999'>10U\u70b9\u4ef7\u503c1\u5143</font></small></small>";
      } else {
         if (!"sms".equals(var0)) {
            throw new IllegalArgumentException("type not supported. " + var0);
         }

         var0 = String.format("\u53d1\u77ed\u4fe1\u76f4\u63a5\u8d2d\u4e70<br /><small><small><font color='#999999'>\u53d1\u9001%s\u5143\u77ed\u4fe1\uff0c\u53ef\u8d2d\u4e70\u8be5\u5185\u5bb9</font></small></small>", Utils.getSmsPayment());
      }

      return var0;
   }

   private static String getTypeIconFileName(String var0) {
      boolean var1 = Utils.isHdpi();
      if ("upoint".equals(var0)) {
         if (var1) {
            var0 = "upoint_logo_hdpi.png";
         } else {
            var0 = "upoint_logo.png";
         }
      } else {
         if (!"sms".equals(var0)) {
            throw new IllegalArgumentException("type not supported.");
         }

         if (var1) {
            var0 = "sms_logo_hdpi.png";
         } else {
            var0 = "sms_logo.png";
         }
      }

      return var0;
   }

   private static String getTypeName(String var0) {
      return null;
   }
}
