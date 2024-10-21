package com.uc.paymentsdk.payment;

import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uc.paymentsdk.network.chain.Handler$OnFinishListener;
import com.uc.paymentsdk.util.Utils;

class PaymentsActivity$3 implements Handler$OnFinishListener {
   Button cancelBtn;
   RelativeLayout contentPanel;
   Button okBtn;
   int smsPayment;
   final PaymentsActivity this$0;
   TextView tvInfo2;
   TextView waitTV;

   PaymentsActivity$3(PaymentsActivity var1, TextView var2, TextView var3, int var4, Button var5, Button var6, RelativeLayout var7) {
      super();
      this.this$0 = var1;
      this.waitTV = var2;
      this.tvInfo2 = var3;
      this.smsPayment = var4;
      this.cancelBtn = var5;
      this.okBtn = var6;
      this.contentPanel = var7;
   }

   public void onFinish() {
      if (Utils.getSmsInfos() == null) {
         this.this$0.removeDialog(19);
         this.this$0.showDialog(15);
      } else {
         PaymentsActivity.access$17(this.this$0, true);
         this.this$0.removeDialog(19);
         PaymentsActivity.access$18(this.this$0, this.waitTV, this.tvInfo2, this.smsPayment, this.cancelBtn, this.okBtn, this.contentPanel);
      }

   }
}
