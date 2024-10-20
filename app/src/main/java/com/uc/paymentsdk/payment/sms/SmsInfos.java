package com.uc.paymentsdk.payment.sms;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

public class SmsInfos {
   public ArrayList smsInfos = new ArrayList();

   public SmsInfos() {
      super();
   }

   private static ArrayList parsePayment(int var0) {
      ArrayList var3 = new ArrayList();
      int var1 = var0;

      int var2;
      do {
         if (var0 % var1 == 0) {
            var3.add(var1);
         }

         var2 = var1 - 1;
         var1 = var2;
      } while(var2 > 0);

      return var3;
   }

   public void add(SmsInfo var1) {
      this.smsInfos.add(var1);
   }

   public SmsInfo filterSmsInfo(Context var1, int var2) throws SimCardNotSupportException {
      ArrayList var6 = null;
      int var4 = 0;
      int var5 = -1;
      SmsInfo var9;
      if (this.smsInfos.size() == 1) {
         var9 = (SmsInfo)this.smsInfos.get(0);
      } else {
         ArrayList var10;
         for(int var3 = 0; var3 < this.smsInfos.size(); var6 = var10) {
            SmsInfo var7 = (SmsInfo)this.smsInfos.get(var3);
            var10 = var6;
            if (var6 == null) {
               var10 = parsePayment(var2);
            }

            Iterator var11 = var10.iterator();

            while(var11.hasNext()) {
               Integer var8 = (Integer)var11.next();
               if (var7.money == var8 && var7.money > var4) {
                  var4 = var7.money;
                  var5 = var3;
               }
            }

            ++var3;
         }

         if (var5 == -1) {
            throw new SimCardNotSupportException("\u5bf9\u4e0d\u8d77\uff0c\u60a8\u6240\u4f7f\u7528\u7684\u624b\u673a\u8fd0\u8425\u5546\u4e0d\u652f\u6301\u6b64\u77ed\u4fe1\u6fc0\u6d3b\u529f\u80fd\u3002");
         }

         var9 = (SmsInfo)this.smsInfos.get(var5);
      }

      return var9;
   }
}
