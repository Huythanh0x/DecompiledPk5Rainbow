/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.uc.paymentsdk.network.Api
 *  com.uc.paymentsdk.network.ApiTask$TaskHandler
 *  com.uc.paymentsdk.payment.PaymentsActivity
 *  com.uc.paymentsdk.util.PrefUtil
 *  com.uc.paymentsdk.util.Utils
 */
package com.uc.paymentsdk.payment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.network.ApiTask;
import com.uc.paymentsdk.payment.PaymentsActivity;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;

class PaymentsActivity.1
extends BroadcastReceiver {
    final PaymentsActivity this$0;

    PaymentsActivity.1(PaymentsActivity paymentsActivity) {
        this.this$0 = paymentsActivity;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void onReceive(Context var1_1, Intent var2_5) {
        switch (this.getResultCode()) {
            default: {
                this.this$0.removeDialog(17);
                PaymentsActivity.access$8((PaymentsActivity)this.this$0, (String)"\u4f59\u989d\u4e0d\u8db3\uff0c\u652f\u4ed8\u5931\u8d25");
                this.this$0.showDialog(21);
                if ((PaymentsActivity.access$3((PaymentsActivity)this.this$0) != -1 || 5 == PaymentsActivity.access$0((PaymentsActivity)this.this$0)) && PaymentsActivity.access$10((PaymentsActivity)this.this$0) != null) break;
            }
lbl7:
            // 7 sources

            case 1: 
            case 133404: lbl-1000:
            // 2 sources

            {
                return;
            }
            case -1: {
                if (4 != PaymentsActivity.access$0((PaymentsActivity)this.this$0)) ** GOTO lbl40
                if (!PaymentsActivity.access$1((PaymentsActivity)this.this$0).isNeedconfirm()) ** GOTO lbl24
                try {
                    Thread.sleep(5000L);
                }
                catch (InterruptedException var1_2) {
                    var1_2.printStackTrace();
                    ** continue;
                }
lbl18:
                // 2 sources

                while (true) {
                    this.this$0.removeDialog(17);
                    var1_1 /* !! */  = PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmsConfirmContent();
                    var2_5 /* !! */  = PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmsConfirmNumber();
                    PaymentsActivity.access$2((PaymentsActivity)this.this$0, (String)var2_5 /* !! */ , (String)var1_1 /* !! */ );
                    ** GOTO lbl7
                    break;
                }
lbl24:
                // 1 sources

                var1_1 /* !! */  = this.this$0;
                PaymentsActivity.access$4((PaymentsActivity)var1_1 /* !! */ , (int)(PaymentsActivity.access$3((PaymentsActivity)var1_1 /* !! */ ) - 1));
                this.this$0.removeDialog(17);
                PrefUtil.setPayedAmount((Context)this.this$0.getApplicationContext(), (int)PaymentsActivity.access$5((PaymentsActivity)this.this$0));
                if (PaymentsActivity.access$3((PaymentsActivity)this.this$0) < 1) ** GOTO lbl35
                PaymentsActivity.access$6((PaymentsActivity)this.this$0);
lbl30:
                // 2 sources

                while (true) {
                    if (PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmstype() == 1) {
                        Api.postSmsPayment((Context)this.this$0.getApplicationContext(), (ApiTask.TaskHandler)this.this$0, (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getCpID(), (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getmGameID(), (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getmActionID(), (int)Utils.getSmsPayment(), (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getmActionID(), (String)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmschannelid(), (String)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmsnumber(), (String)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getContent(), (int)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmstype());
                    }
                    ** GOTO lbl7
                    break;
                }
lbl35:
                // 2 sources

                this.this$0.unregisterReceiver(PaymentsActivity.access$7((PaymentsActivity)this.this$0));
lbl36:
                // 2 sources

                while (true) {
                    PaymentsActivity.access$8((PaymentsActivity)this.this$0, (String)"\u652f\u4ed8\u5df2\u5b8c\u6210\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\u3002");
                    this.this$0.showDialog(20);
                    ** continue;
                    break;
                }
lbl40:
                // 1 sources

                this.this$0.removeDialog(17);
                var1_1 /* !! */  = this.this$0;
                PaymentsActivity.access$4((PaymentsActivity)var1_1 /* !! */ , (int)(PaymentsActivity.access$3((PaymentsActivity)var1_1 /* !! */ ) - 1));
                PrefUtil.setPayedAmount((Context)this.this$0.getApplicationContext(), (int)PaymentsActivity.access$5((PaymentsActivity)this.this$0));
                if (PaymentsActivity.access$3((PaymentsActivity)this.this$0) < 1) ** GOTO lbl51
                PaymentsActivity.access$6((PaymentsActivity)this.this$0);
lbl46:
                // 2 sources

                while (true) {
                    if (PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmstype() == 1) {
                        Api.postSmsPayment((Context)this.this$0.getApplicationContext(), (ApiTask.TaskHandler)this.this$0, (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getCpID(), (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getmGameID(), (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getmActionID(), (int)Utils.getSmsPayment(), (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getmActionID(), (String)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmschannelid(), (String)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmsnumber(), (String)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getContent(), (int)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmstype());
                    }
                    ** GOTO lbl7
                    break;
                }
lbl51:
                // 2 sources

                this.this$0.unregisterReceiver(PaymentsActivity.access$7((PaymentsActivity)this.this$0));
lbl52:
                // 2 sources

                while (true) {
                    PaymentsActivity.access$8((PaymentsActivity)this.this$0, (String)"\u652f\u4ed8\u5df2\u5b8c\u6210\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\u3002");
                    this.this$0.showDialog(20);
                    ** continue;
                    break;
                }
            }
            case 2: {
                this.this$0.removeDialog(17);
                PaymentsActivity.access$8((PaymentsActivity)this.this$0, (String)"\u5f53\u524d\u624b\u673a\u8bbe\u7f6e\u4e3a\u98de\u884c\u6a21\u5f0f\uff0c\u4e0d\u80fd\u53d1\u9001\u77ed\u4fe1\u3002");
                this.this$0.showDialog(21);
                if (PaymentsActivity.access$3((PaymentsActivity)this.this$0) == -1 && 5 != PaymentsActivity.access$0((PaymentsActivity)this.this$0) || PaymentsActivity.access$10((PaymentsActivity)this.this$0) == null) ** GOTO lbl7
                this.this$0.getContentResolver().unregisterContentObserver(PaymentsActivity.access$10((PaymentsActivity)this.this$0));
                ** GOTO lbl7
            }
        }
        this.this$0.getContentResolver().unregisterContentObserver(PaymentsActivity.access$10((PaymentsActivity)this.this$0));
        ** while (true)
        catch (IllegalArgumentException var1_3) {
            ** continue;
        }
        catch (IllegalArgumentException var1_4) {
            ** continue;
        }
    }
}
