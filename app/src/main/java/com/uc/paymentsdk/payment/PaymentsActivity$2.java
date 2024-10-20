package com.uc.paymentsdk.payment;

import com.uc.paymentsdk.util.PrefUtil;

class PaymentsActivity$2 implements Runnable {
    final PaymentsActivity this$0;
    
    PaymentsActivity$2(final PaymentsActivity this$0) {
        this.this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        if (PaymentsActivity.access$10(this.this$0) != null) {
            this.this$0.getContentResolver().unregisterContentObserver(PaymentsActivity.access$10(this.this$0));
        }
        this.this$0.removeDialog(17);
        Label_0082: {
            if (!PaymentsActivity.access$1(this.this$0).needconfirm) {
                break Label_0082;
            }
            PaymentsActivity.access$8(this.this$0, "\u5bf9\u4e0d\u8d77\uff0c\u63a5\u6536\u786e\u8ba4\u77ed\u4fe1\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u5c1d\u8bd5\u652f\u4ed8\uff01");
            this.this$0.showDialog(21);
            try {
                while (true) {
                    this.this$0.unregisterReceiver(PaymentsActivity.access$7(this.this$0));
                    return;
                    iftrue(Label_0113:)(PaymentsActivity.access$3(this.this$0) <= 0);
                    Block_4: {
                        break Block_4;
                        Label_0113: {
                            PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), PaymentsActivity.access$5(this.this$0));
                        }
                        PaymentsActivity.access$8(this.this$0, "\u611f\u8c22\u60a8\u7684\u4f7f\u7528\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\uff01");
                        this.this$0.showDialog(20);
                        continue;
                    }
                    PaymentsActivity.access$8(this.this$0, "\u5bf9\u4e0d\u8d77\uff0c\u77ed\u4fe1\u652f\u4ed8\u5df2\u7ecf\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u652f\u4ed8\uff01");
                    this.this$0.showDialog(21);
                    continue;
                }
            }
            catch (final IllegalArgumentException ex) {}
        }
    }
}