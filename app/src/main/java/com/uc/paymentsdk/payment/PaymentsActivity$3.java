/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.widget.Button
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  com.uc.paymentsdk.network.chain.Handler$OnFinishListener
 *  com.uc.paymentsdk.payment.PaymentsActivity
 *  com.uc.paymentsdk.util.Utils
 */
package com.uc.paymentsdk.payment;

import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uc.paymentsdk.network.chain.Handler;
import com.uc.paymentsdk.payment.PaymentsActivity;
import com.uc.paymentsdk.util.Utils;

class PaymentsActivity.3
implements Handler.OnFinishListener {
    Button cancelBtn;
    RelativeLayout contentPanel;
    Button okBtn;
    int smsPayment;
    final PaymentsActivity this$0;
    TextView tvInfo2;
    TextView waitTV;

    PaymentsActivity.3(PaymentsActivity paymentsActivity, TextView textView, TextView textView2, int n, Button button, Button button2, RelativeLayout relativeLayout) {
        this.this$0 = paymentsActivity;
        this.waitTV = textView;
        this.tvInfo2 = textView2;
        this.smsPayment = n;
        this.cancelBtn = button;
        this.okBtn = button2;
        this.contentPanel = relativeLayout;
    }

    /*
     * Enabled force condition propagation
     */
    public void onFinish() {
        if (Utils.getSmsInfos() == null) {
            this.this$0.removeDialog(19);
            this.this$0.showDialog(15);
            return;
        }
        PaymentsActivity.access$17((PaymentsActivity)this.this$0, (boolean)true);
        this.this$0.removeDialog(19);
        PaymentsActivity.access$18((PaymentsActivity)this.this$0, (TextView)this.waitTV, (TextView)this.tvInfo2, (int)this.smsPayment, (Button)this.cancelBtn, (Button)this.okBtn, (RelativeLayout)this.contentPanel);
    }
}
