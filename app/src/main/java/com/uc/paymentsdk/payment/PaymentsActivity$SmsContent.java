package com.uc.paymentsdk.payment;

import com.uc.paymentsdk.network.ApiTask;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.util.Utils;
import com.uc.paymentsdk.util.PrefUtil;
import android.database.sqlite.SQLiteAbortException;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Handler;
import android.database.Cursor;
import android.database.ContentObserver;

private class SmsContent extends ContentObserver
{
    private static final String BODY = "body";
    private static final String NUMBER = "address";
    private Cursor mCursor;
    final PaymentsActivity this$0;
    
    public SmsContent(final PaymentsActivity this$0, final android.os.Handler handler) {
        this.this$0 = this$0;
        super(handler);
    }
    
    public void onChange(final boolean b) {
        super.onChange(b);
        Object o = Uri.parse("content://sms/inbox");
        this.mCursor = this.this$0.managedQuery((Uri)o, new String[] { "_id", "address", "body" }, " address like ? or address like ? and read=?", new String[] { String.valueOf(PaymentsActivity.access$1(this.this$0).getSmsnumber()) + "%%", String.valueOf(PaymentsActivity.access$1(this.this$0).getSmsConfirmNumber()) + "%%", "0" }, "date desc");
        if (this.mCursor != null) {
        Label_0467:
            while (true) {
                if (!this.mCursor.moveToFirst()) {
                    break Label_0467;
                }
                if (PaymentsActivity.access$11(this.this$0) > 0 && PaymentsActivity.access$11(this.this$0) > this.mCursor.getInt(0)) {
                    this.mCursor.close();
                    return;
                }
                while (true) {
                    if (PaymentsActivity.access$12(this.this$0) > 1) {
                        break Label_0248;
                    }
                    PaymentsActivity.access$13(this.this$0).removeCallbacks(PaymentsActivity.access$14(this.this$0));
                    this.this$0.getContentResolver().unregisterContentObserver(PaymentsActivity.access$10(this.this$0));
                    try {
                        this.this$0.unregisterReceiver(PaymentsActivity.access$7(this.this$0));
                        while (true) {
                            PaymentsActivity.access$15(this.this$0, this.mCursor.getInt(0));
                            final ContentValues contentValues = new ContentValues();
                            contentValues.put("read", "1");
                            String string = null;
                            Label_0716: {
                                Label_0517: {
                                    while (true) {
                                        try {
                                            this.this$0.getContentResolver().update((Uri)o, contentValues, " _id=?", new String[] { new StringBuilder().append(PaymentsActivity.access$11(this.this$0)).toString() });
                                            string = this.mCursor.getString(this.mCursor.getColumnIndex("body"));
                                            o = this.mCursor.getString(this.mCursor.getColumnIndex("address"));
                                            if (4 != PaymentsActivity.access$0(this.this$0)) {
                                                break Label_0716;
                                            }
                                            if (!PaymentsActivity.access$1(this.this$0).isNeedconfirm()) {
                                                break Label_0517;
                                            }
                                            this.this$0.removeDialog(17);
                                            final String confirmSmsConfirmNumber = PaymentsActivity.access$1(this.this$0).parseConfirmSmsConfirmNumber(string);
                                            if (PaymentsActivity.access$1(this.this$0).isSuccess(string) && confirmSmsConfirmNumber != null) {
                                                PaymentsActivity.access$13(this.this$0).removeCallbacks(PaymentsActivity.access$14(this.this$0));
                                                PaymentsActivity.access$2(this.this$0, (String)o, confirmSmsConfirmNumber);
                                                this.mCursor.close();
                                                break;
                                            }
                                        }
                                        catch (final SQLiteAbortException o) {
                                            ((SQLiteAbortException)o).printStackTrace();
                                            continue;
                                        }
                                        break;
                                    }
                                    this.this$0.removeDialog(17);
                                    PaymentsActivity.access$8(this.this$0, "\u4f59\u989d\u4e0d\u8db3\uff0c\u652f\u4ed8\u5931\u8d25");
                                    this.this$0.showDialog(21);
                                    continue Label_0467;
                                }
                                PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), PaymentsActivity.access$5(this.this$0));
                                if (PaymentsActivity.access$12(this.this$0) > 1) {
                                    o = this.this$0;
                                    PaymentsActivity.access$16((PaymentsActivity)o, PaymentsActivity.access$12((PaymentsActivity)o) - 1);
                                }
                                else {
                                    if (PaymentsActivity.access$12(this.this$0) <= 1) {
                                        this.this$0.removeDialog(17);
                                    }
                                    PaymentsActivity.access$8(this.this$0, "\u652f\u4ed8\u5df2\u5b8c\u6210\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\u3002");
                                    this.this$0.showDialog(20);
                                }
                                if (PaymentsActivity.access$1(this.this$0).getSmstype() == 1) {
                                    Api.postSmsPayment(this.this$0.getApplicationContext(), this.this$0, PaymentsActivity.access$9(this.this$0).getCpID(), PaymentsActivity.access$9(this.this$0).getmGameID(), PaymentsActivity.access$9(this.this$0).getmActionID(), Utils.getSmsPayment(), PaymentsActivity.access$9(this.this$0).getmActionID(), PaymentsActivity.access$1(this.this$0).getSmschannelid(), PaymentsActivity.access$1(this.this$0).getSmsnumber(), PaymentsActivity.access$1(this.this$0).getContent(), PaymentsActivity.access$1(this.this$0).getSmstype());
                                    continue Label_0467;
                                }
                                continue Label_0467;
                            }
                            this.this$0.removeDialog(17);
                            if (!PaymentsActivity.access$1(this.this$0).parseConfirmResultSms(string)) {
                                PaymentsActivity.access$8(this.this$0, string);
                                this.this$0.showDialog(21);
                                continue Label_0467;
                            }
                            PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), PaymentsActivity.access$5(this.this$0));
                            if (PaymentsActivity.access$12(this.this$0) > 1) {
                                o = this.this$0;
                                PaymentsActivity.access$16((PaymentsActivity)o, PaymentsActivity.access$12((PaymentsActivity)o) - 1);
                                o = this.this$0;
                                PaymentsActivity.access$4((PaymentsActivity)o, PaymentsActivity.access$3((PaymentsActivity)o) - 1);
                                PaymentsActivity.access$13(this.this$0).removeCallbacks(PaymentsActivity.access$14(this.this$0));
                                this.this$0.removeDialog(17);
                                PaymentsActivity.access$6(this.this$0);
                            }
                            else {
                                PaymentsActivity.access$8(this.this$0, string.replace((CharSequence)"success", (CharSequence)"\u8d2d\u4e70\u6210\u529f"));
                                this.this$0.showDialog(20);
                            }
                            if (PaymentsActivity.access$1(this.this$0).getSmstype() == 1) {
                                Api.postSmsPayment(this.this$0.getApplicationContext(), this.this$0, PaymentsActivity.access$9(this.this$0).getCpID(), PaymentsActivity.access$9(this.this$0).getmGameID(), PaymentsActivity.access$9(this.this$0).getmActionID(), Utils.getSmsPayment(), PaymentsActivity.access$9(this.this$0).getmActionID(), PaymentsActivity.access$1(this.this$0).getSmschannelid(), PaymentsActivity.access$1(this.this$0).getSmsnumber(), PaymentsActivity.access$1(this.this$0).getContent(), PaymentsActivity.access$1(this.this$0).getSmstype());
                                continue Label_0467;
                            }
                            continue Label_0467;
                        }
                    }
                    catch (final IllegalArgumentException ex) {
                        continue;
                    }
                    break;
                }
                break;
            }
        }
    }
}
