/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.uc.paymentsdk.payment.PaymentsActivity
 *  com.uc.paymentsdk.util.PrefUtil
 */
package com.uc.paymentsdk.payment;

import android.content.Context;
import com.uc.paymentsdk.payment.PaymentsActivity;
import com.uc.paymentsdk.util.PrefUtil;

class PaymentsActivity.2
implements Runnable {
    final PaymentsActivity this$0;

    PaymentsActivity.2(PaymentsActivity paymentsActivity) {
        this.this$0 = paymentsActivity;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void run() {
        block6: {
            if (PaymentsActivity.access$10((PaymentsActivity)this.this$0) != null) {
                this.this$0.getContentResolver().unregisterContentObserver(PaymentsActivity.access$10((PaymentsActivity)this.this$0));
            }
            this.this$0.removeDialog(17);
            if (PaymentsActivity.access$1((PaymentsActivity)this.this$0).needconfirm) {
                PaymentsActivity.access$8((PaymentsActivity)this.this$0, (String)"\u5bf9\u4e0d\u8d77\uff0c\u63a5\u6536\u786e\u8ba4\u77ed\u4fe1\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u5c1d\u8bd5\u652f\u4ed8\uff01");
                this.this$0.showDialog(21);
lbl7:
                // 3 sources

                while (true) {
                    this.this$0.unregisterReceiver(PaymentsActivity.access$7((PaymentsActivity)this.this$0));
lbl10:
                    // 2 sources

                    return;
                    break;
                }
            }
            if (PaymentsActivity.access$3((PaymentsActivity)this.this$0) <= 0) break block6;
            PaymentsActivity.access$8((PaymentsActivity)this.this$0, (String)"\u5bf9\u4e0d\u8d77\uff0c\u77ed\u4fe1\u652f\u4ed8\u5df2\u7ecf\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u652f\u4ed8\uff01");
            this.this$0.showDialog(21);
            ** GOTO lbl7
        }
        PrefUtil.setPayedAmount((Context)this.this$0.getApplicationContext(), (int)PaymentsActivity.access$5((PaymentsActivity)this.this$0));
        PaymentsActivity.access$8((PaymentsActivity)this.this$0, (String)"\u611f\u8c22\u60a8\u7684\u4f7f\u7528\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\uff01");
        this.this$0.showDialog(20);
        ** while (true)
        catch (IllegalArgumentException var1_1) {
            ** continue;
        }
    }
}
