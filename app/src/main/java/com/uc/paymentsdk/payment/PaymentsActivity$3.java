package com.uc.paymentsdk.payment;

import com.uc.paymentsdk.util.Utils;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.Button;
import com.uc.paymentsdk.network.chain.Handler;

class PaymentsActivity$3 implements OnFinishListener {
    Button cancelBtn = cancelBtn;
    RelativeLayout contentPanel = contentPanel;
    Button okBtn = okBtn;
    int smsPayment = smsPayment;
    final PaymentsActivity this$0;
    TextView tvInfo2 = tvInfo2;
    TextView waitTV = waitTV;
    
    PaymentsActivity$3(final PaymentsActivity this$0, final TextView waitTV, final TextView tvInfo2, final int smsPayment, final Button cancelBtn, final Button okBtn, final RelativeLayout contentPanel) {
        this.this$0 = this$0;
        super();
    }
    
    @Override
    public void onFinish() {
        if (Utils.getSmsInfos() == null) {
            this.this$0.removeDialog(19);
            this.this$0.showDialog(15);
        }
        else {
            PaymentsActivity.access$17(this.this$0, true);
            this.this$0.removeDialog(19);
            PaymentsActivity.access$18(this.this$0, this.waitTV, this.tvInfo2, this.smsPayment, this.cancelBtn, this.okBtn, this.contentPanel);
        }
    }
}