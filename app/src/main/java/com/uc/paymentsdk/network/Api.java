package com.uc.paymentsdk.network;

import android.content.Context;
import com.uc.paymentsdk.commons.codec.MD5;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import java.util.HashMap;

public class Api {
   public Api() {
      super();
   }

   public static void confirmPayResult(Context var0, ApiTask$TaskHandler var1, String var2, String var3) {
      HashMap var4 = new HashMap(2);
      var4.put("order_id", var2);
      var4.put("app_key", var3);
      (new ApiTask(var0, 5, var1, var4, "post")).execute(new Void[0]);
   }

   public static void pay(Context var0, ApiTask$TaskHandler var1, PaymentInfo var2, UPointPayInfo var3) {
      HashMap var4 = new HashMap(9);
      var4.put("user_id", var3.getUserid());
      var4.put("&cpid", var3.getCpid());
      var4.put("&gameid", var3.getGameid());
      var4.put("&optid", var2.getmActionID());
      var4.put("&u_money", var3.getUpoint());
      var4.put("&charge", var3.getUmoney());
      var4.put("&consume_id", var3.getConsumeid());
      var4.put("&ucid", var3.getUsersession());
      var4.put("&sign", var3.getSign());
      var4.put("&uc_token", var3.getUctoken());
      var4.put("&pay_pwd", var3.getPaypwd());
      var4.put("&consume_time", var3.getTm());
      var4.put("&tm", var3.getTm());
      var4.put("&eid", UPointPayInfo.getEid());
      var4.put("&ch_code", var3.getChcode());
      (new ApiTask(var0, 3, var1, var4, "post")).execute(new Void[0]);
   }

   public static void postSmsPayment(Context var0, ApiTask$TaskHandler var1, String var2, String var3, String var4, int var5, String var6, String var7, String var8, String var9, int var10) {
      String var12 = Utils.getSessionID(var0);
      String var14 = Utils.createARanConsumeID(20);
      String var13 = "";

      String var11;
      label68: {
         label72: {
            StringBuilder var15;
            boolean var10001;
            label66: {
               label73: {
                  try {
                     var15 = new StringBuilder;
                     if (var12.length() <= 5) {
                        break label73;
                     }
                  } catch (Exception var22) {
                     var10001 = false;
                     break label72;
                  }

                  try {
                     var11 = var12.substring(0, 5);
                     break label66;
                  } catch (Exception var21) {
                     var10001 = false;
                     break label72;
                  }
               }

               var11 = var12;
            }

            label74: {
               label55: {
                  try {
                     var15.<init>(String.valueOf(var11));
                     if (var2.length() > 5) {
                        break label55;
                     }
                  } catch (Exception var20) {
                     var10001 = false;
                     break label72;
                  }

                  var11 = var2;
                  break label74;
               }

               try {
                  var11 = var2.substring(0, 5);
               } catch (Exception var19) {
                  var10001 = false;
                  break label72;
               }
            }

            label46: {
               label75: {
                  try {
                     var15 = var15.append(var11);
                     if (var3.length() <= 5) {
                        break label75;
                     }
                  } catch (Exception var18) {
                     var10001 = false;
                     break label72;
                  }

                  try {
                     var11 = var3.substring(0, 5);
                     break label46;
                  } catch (Exception var17) {
                     var10001 = false;
                     break label72;
                  }
               }

               var11 = var3;
            }

            try {
               var11 = MD5.getMD5(var15.append(var11).append(var5).toString());
               break label68;
            } catch (Exception var16) {
               var10001 = false;
            }
         }

         var11 = var13;
      }

      HashMap var23 = new HashMap(4);
      var23.put("user_id", var12);
      var23.put("cpid", var2);
      var23.put("gameid", var3);
      var23.put("optid", var4);
      var23.put("consume_id", var14);
      var23.put("charge", var5);
      var23.put("optobj", var6);
      var23.put("sms_channel", var7);
      var23.put("sms_port", var8);
      var23.put("sms_content", var9);
      var23.put("sms_type", var10);
      var23.put("sendtime", Utils.getCurrentTime(false));
      var23.put("sign", var11);
      (new ApiTask(var0, 8, var1, var23, "post")).execute(new Void[0]);
   }

   public static void queryUPointDiscount(Context var0, ApiTask$TaskHandler var1, String var2, String var3, int var4) {
      HashMap var5 = new HashMap(1);
      var5.put("cpid", var2);
      var5.put("gameid", var3);
      var5.put("u_money", var4);
      (new ApiTask(var0, 18, var1, var5, "post")).execute(new Void[0]);
   }

   public static void syncChargeChannel(Context var0, ApiTask$TaskHandler var1) {
      HashMap var2 = new HashMap(1);
      var2.put("action", "getRechargeChannels");
      (new ApiTask(var0, 17, var1, var2, "post")).execute(new Void[0]);
   }

   public static void syncPayChannel(Context var0, ApiTask$TaskHandler var1) {
      (new ApiTask(var0, 6, var1, new HashMap(0), "post")).execute(new Void[0]);
   }

   public static void syncSmsInfo(Context var0, ApiTask$TaskHandler var1, String var2, String var3) {
      HashMap var6 = new HashMap(1);
      String var5 = Utils.getSessionID(var0);
      String var4 = var5;
      if (var5 == null) {
         var4 = Utils.createARanSessionid(8);
         PrefUtil.setUserSession(var0, var4);
      }

      var6.put("user_id", var4);
      var6.put("cpid", var2);
      var6.put("gameid", var3);
      var6.put("area", "");
      var6.put("imsi", Utils.getSimNumber(var0));
      (new ApiTask(var0, 7, var1, var6, "post")).execute(new Void[0]);
   }

   public static void syncUPointDiscount(Context var0, ApiTask$TaskHandler var1, String var2, String var3, int var4) {
      HashMap var5 = new HashMap(1);
      var5.put("cpid", var2);
      var5.put("gameid", var3);
      var5.put("u_money", var4);
      (new ApiTask(var0, 18, var1, var5, "post")).execute(new Void[0]);
   }
}
