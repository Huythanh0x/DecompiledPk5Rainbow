package com.uc.paymentsdk.payment;

import com.uc.paymentsdk.network.ApiTask;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.util.Utils;
import com.uc.paymentsdk.util.PrefUtil;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class PaymentsActivity$1 extends BroadcastReceiver {
    final PaymentsActivity this$0;
    
    PaymentsActivity$1(final PaymentsActivity this$0) {
        this.this$0 = this$0;
        super();
    }
    
    public void onReceive(final Context context, final Intent intent) {
        Label_0362: {
            switch (this.getResultCode()) {
                default: {
                    this.this$0.removeDialog(17);
                    PaymentsActivity.access$8(this.this$0, "\u4f59\u989d\u4e0d\u8db3\uff0c\u652f\u4ed8\u5931\u8d25");
                    this.this$0.showDialog(21);
                    if ((PaymentsActivity.access$3(this.this$0) == -1 && 5 != PaymentsActivity.access$0(this.this$0)) || PaymentsActivity.access$10(this.this$0) == null) {
                        return;
                    }
                    break Label_0362;
                }
                case 1:
                case 133404: {
                    Label_0107: {
                        return;
                    }
                }
                case -1: {
                    if (4 != PaymentsActivity.access$0(this.this$0)) {
                        break Label_0362;
                    }
                    if (PaymentsActivity.access$1(this.this$0).isNeedconfirm()) {
                        while (true) {
                            try {
                                Thread.sleep(5000L);
                                this.this$0.removeDialog(17);
                                PaymentsActivity.access$2(this.this$0, PaymentsActivity.access$1(this.this$0).getSmsConfirmNumber(), PaymentsActivity.access$1(this.this$0).getSmsConfirmContent());
                                return;
                            }
                            catch (final InterruptedException ex) {
                                ex.printStackTrace();
                                continue;
                            }
                            break;
                        }
                    }
                    final PaymentsActivity this$0 = this.this$0;
                    PaymentsActivity.access$4(this$0, PaymentsActivity.access$3(this$0) - 1);
                    this.this$0.removeDialog(17);
                    PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), PaymentsActivity.access$5(this.this$0));
                    if (PaymentsActivity.access$3(this.this$0) >= 1) {
                        PaymentsActivity.access$6(this.this$0);
                        break;
                    }
                    break Label_0362;
                }
                case 2: {
                    Label_0605: {
                        break Label_0605;
                        while (true) {
                            try {
                                this.this$0.unregisterReceiver(PaymentsActivity.access$7(this.this$0));
                                PaymentsActivity.access$8(this.this$0, "\u652f\u4ed8\u5df2\u5b8c\u6210\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\u3002");
                                this.this$0.showDialog(20);
                                break;
                                this.this$0.removeDialog(17);
                                final PaymentsActivity this$2 = this.this$0;
                                PaymentsActivity.access$4(this$2, PaymentsActivity.access$3(this$2) - 1);
                                PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), PaymentsActivity.access$5(this.this$0));
                                iftrue(Label_0570:)(PaymentsActivity.access$3(this.this$0) < 1);
                                PaymentsActivity.access$6(this.this$0);
                            Block_10_Outer:
                                while (true) {
                                    break Label_0456;
                                    while (true) {
                                        Api.postSmsPayment(this.this$0.getApplicationContext(), this.this$0, PaymentsActivity.access$9(this.this$0).getCpID(), PaymentsActivity.access$9(this.this$0).getmGameID(), PaymentsActivity.access$9(this.this$0).getmActionID(), Utils.getSmsPayment(), PaymentsActivity.access$9(this.this$0).getmActionID(), PaymentsActivity.access$1(this.this$0).getSmschannelid(), PaymentsActivity.access$1(this.this$0).getSmsnumber(), PaymentsActivity.access$1(this.this$0).getContent(), PaymentsActivity.access$1(this.this$0).getSmstype());
                                        return;
                                        iftrue(Label_0107:)(PaymentsActivity.access$1(this.this$0).getSmstype() != 1);
                                        continue;
                                    }
                                    try {
                                        Label_0570: {
                                            this.this$0.unregisterReceiver(PaymentsActivity.access$7(this.this$0));
                                        }
                                        PaymentsActivity.access$8(this.this$0, "\u652f\u4ed8\u5df2\u5b8c\u6210\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\u3002");
                                        this.this$0.showDialog(20);
                                        continue Block_10_Outer;
                                        this.this$0.removeDialog(17);
                                        PaymentsActivity.access$8(this.this$0, "\u5f53\u524d\u624b\u673a\u8bbe\u7f6e\u4e3a\u98de\u884c\u6a21\u5f0f\uff0c\u4e0d\u80fd\u53d1\u9001\u77ed\u4fe1\u3002");
                                        this.this$0.showDialog(21);
                                        iftrue(Label_0107:)((PaymentsActivity.access$3(this.this$0) == -1 && 5 != PaymentsActivity.access$0(this.this$0)) || PaymentsActivity.access$10(this.this$0) == null);
                                        this.this$0.getContentResolver().unregisterContentObserver(PaymentsActivity.access$10(this.this$0));
                                        return;
                                        this.this$0.getContentResolver().unregisterContentObserver(PaymentsActivity.access$10(this.this$0));
                                    }
                                    catch (final IllegalArgumentException ex2) {}
                                    break;
                                }
                            }
                            catch (final IllegalArgumentException ex3) {
                                continue;
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }
        if (PaymentsActivity.access$1(this.this$0).getSmstype() == 1) {
            Api.postSmsPayment(this.this$0.getApplicationContext(), this.this$0, PaymentsActivity.access$9(this.this$0).getCpID(), PaymentsActivity.access$9(this.this$0).getmGameID(), PaymentsActivity.access$9(this.this$0).getmActionID(), Utils.getSmsPayment(), PaymentsActivity.access$9(this.this$0).getmActionID(), PaymentsActivity.access$1(this.this$0).getSmschannelid(), PaymentsActivity.access$1(this.this$0).getSmsnumber(), PaymentsActivity.access$1(this.this$0).getContent(), PaymentsActivity.access$1(this.this$0).getSmstype());
        }
    }
}