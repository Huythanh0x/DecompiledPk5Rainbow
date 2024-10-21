package com.uc.paymentsdk.payment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;

class PaymentsActivity$1 extends BroadcastReceiver {
   final PaymentsActivity this$0;

   PaymentsActivity$1(PaymentsActivity var1) {
      super();
      this.this$0 = var1;
   }

   public void onReceive(Context var1, Intent var2) {
      switch (this.getResultCode()) {
         case -1:
            PaymentsActivity var7;
            if (4 == PaymentsActivity.access$0(this.this$0)) {
               if (PaymentsActivity.access$1(this.this$0).isNeedconfirm()) {
                  try {
                     Thread.sleep(5000L);
                  } catch (InterruptedException var5) {
                     var5.printStackTrace();
                  }

                  this.this$0.removeDialog(17);
                  String var6 = PaymentsActivity.access$1(this.this$0).getSmsConfirmContent();
                  String var8 = PaymentsActivity.access$1(this.this$0).getSmsConfirmNumber();
                  PaymentsActivity.access$2(this.this$0, var8, var6);
               } else {
                  var7 = this.this$0;
                  PaymentsActivity.access$4(var7, PaymentsActivity.access$3(var7) - 1);
                  this.this$0.removeDialog(17);
                  PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), PaymentsActivity.access$5(this.this$0));
                  if (PaymentsActivity.access$3(this.this$0) >= 1) {
                     PaymentsActivity.access$6(this.this$0);
                  } else {
                     try {
                        this.this$0.unregisterReceiver(PaymentsActivity.access$7(this.this$0));
                     } catch (IllegalArgumentException var4) {
                     }

                     PaymentsActivity.access$8(this.this$0, "\u652f\u4ed8\u5df2\u5b8c\u6210\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\u3002");
                     this.this$0.showDialog(20);
                  }

                  if (PaymentsActivity.access$1(this.this$0).getSmstype() == 1) {
                     Api.postSmsPayment(this.this$0.getApplicationContext(), this.this$0, PaymentsActivity.access$9(this.this$0).getCpID(), PaymentsActivity.access$9(this.this$0).getmGameID(), PaymentsActivity.access$9(this.this$0).getmActionID(), Utils.getSmsPayment(), PaymentsActivity.access$9(this.this$0).getmActionID(), PaymentsActivity.access$1(this.this$0).getSmschannelid(), PaymentsActivity.access$1(this.this$0).getSmsnumber(), PaymentsActivity.access$1(this.this$0).getContent(), PaymentsActivity.access$1(this.this$0).getSmstype());
                  }
               }
            } else {
               this.this$0.removeDialog(17);
               var7 = this.this$0;
               PaymentsActivity.access$4(var7, PaymentsActivity.access$3(var7) - 1);
               PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), PaymentsActivity.access$5(this.this$0));
               if (PaymentsActivity.access$3(this.this$0) >= 1) {
                  PaymentsActivity.access$6(this.this$0);
               } else {
                  try {
                     this.this$0.unregisterReceiver(PaymentsActivity.access$7(this.this$0));
                  } catch (IllegalArgumentException var3) {
                  }

                  PaymentsActivity.access$8(this.this$0, "\u652f\u4ed8\u5df2\u5b8c\u6210\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\u3002");
                  this.this$0.showDialog(20);
               }

               if (PaymentsActivity.access$1(this.this$0).getSmstype() == 1) {
                  Api.postSmsPayment(this.this$0.getApplicationContext(), this.this$0, PaymentsActivity.access$9(this.this$0).getCpID(), PaymentsActivity.access$9(this.this$0).getmGameID(), PaymentsActivity.access$9(this.this$0).getmActionID(), Utils.getSmsPayment(), PaymentsActivity.access$9(this.this$0).getmActionID(), PaymentsActivity.access$1(this.this$0).getSmschannelid(), PaymentsActivity.access$1(this.this$0).getSmsnumber(), PaymentsActivity.access$1(this.this$0).getContent(), PaymentsActivity.access$1(this.this$0).getSmstype());
               }
            }
         case 1:
         case 133404:
            break;
         case 2:
            this.this$0.removeDialog(17);
            PaymentsActivity.access$8(this.this$0, "\u5f53\u524d\u624b\u673a\u8bbe\u7f6e\u4e3a\u98de\u884c\u6a21\u5f0f\uff0c\u4e0d\u80fd\u53d1\u9001\u77ed\u4fe1\u3002");
            this.this$0.showDialog(21);
            if ((PaymentsActivity.access$3(this.this$0) != -1 || 5 == PaymentsActivity.access$0(this.this$0)) && PaymentsActivity.access$10(this.this$0) != null) {
               this.this$0.getContentResolver().unregisterContentObserver(PaymentsActivity.access$10(this.this$0));
            }
            break;
         default:
            this.this$0.removeDialog(17);
            PaymentsActivity.access$8(this.this$0, "\u4f59\u989d\u4e0d\u8db3\uff0c\u652f\u4ed8\u5931\u8d25");
            this.this$0.showDialog(21);
            if ((PaymentsActivity.access$3(this.this$0) != -1 || 5 == PaymentsActivity.access$0(this.this$0)) && PaymentsActivity.access$10(this.this$0) != null) {
               this.this$0.getContentResolver().unregisterContentObserver(PaymentsActivity.access$10(this.this$0));
            }
      }

   }
}
