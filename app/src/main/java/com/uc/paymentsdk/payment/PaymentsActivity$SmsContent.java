/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteAbortException
 *  android.net.Uri
 *  android.os.Handler
 *  com.uc.paymentsdk.network.Api
 *  com.uc.paymentsdk.network.ApiTask$TaskHandler
 *  com.uc.paymentsdk.payment.PaymentsActivity
 *  com.uc.paymentsdk.util.PrefUtil
 *  com.uc.paymentsdk.util.Utils
 */
package com.uc.paymentsdk.payment;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.net.Uri;
import android.os.Handler;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.network.ApiTask;
import com.uc.paymentsdk.payment.PaymentsActivity;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;

private class PaymentsActivity.SmsContent
extends ContentObserver {
    private static final String BODY = "body";
    private static final String NUMBER = "address";
    private Cursor mCursor;
    final PaymentsActivity this$0;

    public PaymentsActivity.SmsContent(PaymentsActivity paymentsActivity, Handler handler) {
        this.this$0 = paymentsActivity;
        super(handler);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void onChange(boolean var1_1) {
        block20: {
            super.onChange(var1_1);
            var2_2 /* !! */  = Uri.parse((String)"content://sms/inbox");
            var4_4 = this.this$0;
            var5_5 = String.valueOf(PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmsnumber()) + "%%";
            var3_6 = String.valueOf(PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmsConfirmNumber()) + "%%";
            this.mCursor = var4_4.managedQuery(var2_2 /* !! */ , new String[]{"_id", "address", "body"}, " address like ? or address like ? and read=?", new String[]{var5_5, var3_6, "0"}, "date desc");
            if (this.mCursor == null) lbl-1000:
            // 3 sources

            {
                return;
            }
            if (!this.mCursor.moveToFirst()) ** GOTO lbl39
            if (PaymentsActivity.access$11((PaymentsActivity)this.this$0) <= 0 || PaymentsActivity.access$11((PaymentsActivity)this.this$0) <= this.mCursor.getInt(0)) break block20;
            this.mCursor.close();
            ** GOTO lbl-1000
        }
        if (PaymentsActivity.access$12((PaymentsActivity)this.this$0) <= 1) {
            PaymentsActivity.access$13((PaymentsActivity)this.this$0).removeCallbacks(PaymentsActivity.access$14((PaymentsActivity)this.this$0));
            this.this$0.getContentResolver().unregisterContentObserver(PaymentsActivity.access$10((PaymentsActivity)this.this$0));
            this.this$0.unregisterReceiver(PaymentsActivity.access$7((PaymentsActivity)this.this$0));
        }
lbl20:
        // 4 sources

        while (true) {
            block22: {
                block23: {
                    block17: {
                        block21: {
                            block18: {
                                PaymentsActivity.access$15((PaymentsActivity)this.this$0, (int)this.mCursor.getInt(0));
                                var5_5 = new ContentValues();
                                var5_5.put("read", "1");
                                try {
                                    var3_6 = this.this$0.getContentResolver();
                                    var4_4 = new StringBuilder();
                                    var3_6.update(var2_2 /* !! */ , (ContentValues)var5_5, " _id=?", new String[]{var4_4.append(PaymentsActivity.access$11((PaymentsActivity)this.this$0)).toString()});
                                }
                                catch (SQLiteAbortException var2_3) {
                                    var2_3.printStackTrace();
                                    ** continue;
                                }
lbl29:
                                // 2 sources

                                while (true) {
                                    var4_4 = this.mCursor.getString(this.mCursor.getColumnIndex("body"));
                                    var2_2 /* !! */  = this.mCursor.getString(this.mCursor.getColumnIndex("address"));
                                    if (4 != PaymentsActivity.access$0((PaymentsActivity)this.this$0)) break block17;
                                    if (!PaymentsActivity.access$1((PaymentsActivity)this.this$0).isNeedconfirm()) break block18;
                                    this.this$0.removeDialog(17);
                                    var3_6 = PaymentsActivity.access$1((PaymentsActivity)this.this$0).parseConfirmSmsConfirmNumber((String)var4_4);
                                    if (!PaymentsActivity.access$1((PaymentsActivity)this.this$0).isSuccess((String)var4_4) || var3_6 == null) break;
                                    PaymentsActivity.access$13((PaymentsActivity)this.this$0).removeCallbacks(PaymentsActivity.access$14((PaymentsActivity)this.this$0));
                                    PaymentsActivity.access$2((PaymentsActivity)this.this$0, (String)var2_2 /* !! */ , (String)var3_6);
lbl39:
                                    // 6 sources

                                    while (true) {
                                        this.mCursor.close();
                                        ** continue;
                                        break;
                                    }
                                    break;
                                }
                                this.this$0.removeDialog(17);
                                PaymentsActivity.access$8((PaymentsActivity)this.this$0, (String)"\u4f59\u989d\u4e0d\u8db3\uff0c\u652f\u4ed8\u5931\u8d25");
                                this.this$0.showDialog(21);
                                ** GOTO lbl39
                            }
                            PrefUtil.setPayedAmount((Context)this.this$0.getApplicationContext(), (int)PaymentsActivity.access$5((PaymentsActivity)this.this$0));
                            if (PaymentsActivity.access$12((PaymentsActivity)this.this$0) <= 1) break block21;
                            var2_2 /* !! */  = this.this$0;
                            PaymentsActivity.access$16((PaymentsActivity)var2_2 /* !! */ , (int)(PaymentsActivity.access$12((PaymentsActivity)var2_2 /* !! */ ) - 1));
lbl55:
                            // 2 sources

                            while (true) {
                                if (PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmstype() == 1) {
                                    Api.postSmsPayment((Context)this.this$0.getApplicationContext(), (ApiTask.TaskHandler)this.this$0, (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getCpID(), (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getmGameID(), (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getmActionID(), (int)Utils.getSmsPayment(), (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getmActionID(), (String)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmschannelid(), (String)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmsnumber(), (String)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getContent(), (int)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmstype());
                                }
                                ** GOTO lbl39
                                break;
                            }
                        }
                        if (PaymentsActivity.access$12((PaymentsActivity)this.this$0) <= 1) {
                            this.this$0.removeDialog(17);
                        }
                        PaymentsActivity.access$8((PaymentsActivity)this.this$0, (String)"\u652f\u4ed8\u5df2\u5b8c\u6210\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\u3002");
                        this.this$0.showDialog(20);
                        ** continue;
                    }
                    this.this$0.removeDialog(17);
                    if (!PaymentsActivity.access$1((PaymentsActivity)this.this$0).parseConfirmResultSms((String)var4_4)) break block22;
                    PrefUtil.setPayedAmount((Context)this.this$0.getApplicationContext(), (int)PaymentsActivity.access$5((PaymentsActivity)this.this$0));
                    if (PaymentsActivity.access$12((PaymentsActivity)this.this$0) <= 1) break block23;
                    var2_2 /* !! */  = this.this$0;
                    PaymentsActivity.access$16((PaymentsActivity)var2_2 /* !! */ , (int)(PaymentsActivity.access$12((PaymentsActivity)var2_2 /* !! */ ) - 1));
                    var2_2 /* !! */  = this.this$0;
                    PaymentsActivity.access$4((PaymentsActivity)var2_2 /* !! */ , (int)(PaymentsActivity.access$3((PaymentsActivity)var2_2 /* !! */ ) - 1));
                    PaymentsActivity.access$13((PaymentsActivity)this.this$0).removeCallbacks(PaymentsActivity.access$14((PaymentsActivity)this.this$0));
                    this.this$0.removeDialog(17);
                    PaymentsActivity.access$6((PaymentsActivity)this.this$0);
lbl77:
                    // 2 sources

                    while (true) {
                        if (PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmstype() == 1) {
                            Api.postSmsPayment((Context)this.this$0.getApplicationContext(), (ApiTask.TaskHandler)this.this$0, (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getCpID(), (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getmGameID(), (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getmActionID(), (int)Utils.getSmsPayment(), (String)PaymentsActivity.access$9((PaymentsActivity)this.this$0).getmActionID(), (String)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmschannelid(), (String)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmsnumber(), (String)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getContent(), (int)PaymentsActivity.access$1((PaymentsActivity)this.this$0).getSmstype());
                        }
                        ** GOTO lbl39
                        break;
                    }
                }
                PaymentsActivity.access$8((PaymentsActivity)this.this$0, (String)var4_4.replace("success", "\u8d2d\u4e70\u6210\u529f"));
                this.this$0.showDialog(20);
                ** continue;
            }
            PaymentsActivity.access$8((PaymentsActivity)this.this$0, (String)var4_4);
            this.this$0.showDialog(21);
            ** continue;
            break;
        }
        catch (IllegalArgumentException var3_7) {
            ** continue;
        }
    }
}
