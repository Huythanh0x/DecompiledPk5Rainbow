package com.uc.paymentsdk.payment;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.net.Uri;
import android.os.Handler;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;

class PaymentsActivity$SmsContent extends ContentObserver {
   private static final String BODY = "body";
   private static final String NUMBER = "address";
   private Cursor mCursor;
   final PaymentsActivity this$0;

   public PaymentsActivity$SmsContent(PaymentsActivity var1, Handler var2) {
      super(var2);
      this.this$0 = var1;
   }

   public void onChange(boolean var1) {
      super.onChange(var1);
      Uri var2 = Uri.parse("content://sms/inbox");
      PaymentsActivity var4 = this.this$0;
      String var5 = PaymentsActivity.access$1(this.this$0).getSmsnumber() + "%%";
      String var3 = PaymentsActivity.access$1(this.this$0).getSmsConfirmNumber() + "%%";
      this.mCursor = var4.managedQuery(var2, new String[]{"_id", "address", "body"}, " address like ? or address like ? and read=?", new String[]{var5, var3, "0"}, "date desc");
      if (this.mCursor != null) {
         if (this.mCursor.moveToFirst()) {
            if (PaymentsActivity.access$11(this.this$0) > 0 && PaymentsActivity.access$11(this.this$0) > this.mCursor.getInt(0)) {
               this.mCursor.close();
               return;
            }

            if (PaymentsActivity.access$12(this.this$0) <= 1) {
               PaymentsActivity.access$13(this.this$0).removeCallbacks(PaymentsActivity.access$14(this.this$0));
               this.this$0.getContentResolver().unregisterContentObserver(PaymentsActivity.access$10(this.this$0));

               try {
                  this.this$0.unregisterReceiver(PaymentsActivity.access$7(this.this$0));
               } catch (IllegalArgumentException var7) {
               }
            }

            PaymentsActivity.access$15(this.this$0, this.mCursor.getInt(0));
            ContentValues var13 = new ContentValues();
            var13.put("read", "1");

            try {
               ContentResolver var10 = this.this$0.getContentResolver();
               StringBuilder var11 = new StringBuilder();
               var10.update(var2, var13, " _id=?", new String[]{var11.append(PaymentsActivity.access$11(this.this$0)).toString()});
            } catch (SQLiteAbortException var6) {
               var6.printStackTrace();
            }

            String var12 = this.mCursor.getString(this.mCursor.getColumnIndex("body"));
            String var8 = this.mCursor.getString(this.mCursor.getColumnIndex("address"));
            PaymentsActivity var9;
            if (4 == PaymentsActivity.access$0(this.this$0)) {
               if (PaymentsActivity.access$1(this.this$0).isNeedconfirm()) {
                  this.this$0.removeDialog(17);
                  var3 = PaymentsActivity.access$1(this.this$0).parseConfirmSmsConfirmNumber(var12);
                  if (PaymentsActivity.access$1(this.this$0).isSuccess(var12) && var3 != null) {
                     PaymentsActivity.access$13(this.this$0).removeCallbacks(PaymentsActivity.access$14(this.this$0));
                     PaymentsActivity.access$2(this.this$0, var8, var3);
                  } else {
                     this.this$0.removeDialog(17);
                     PaymentsActivity.access$8(this.this$0, "\u4f59\u989d\u4e0d\u8db3\uff0c\u652f\u4ed8\u5931\u8d25");
                     this.this$0.showDialog(21);
                  }
               } else {
                  PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), PaymentsActivity.access$5(this.this$0));
                  if (PaymentsActivity.access$12(this.this$0) > 1) {
                     var9 = this.this$0;
                     PaymentsActivity.access$16(var9, PaymentsActivity.access$12(var9) - 1);
                  } else {
                     if (PaymentsActivity.access$12(this.this$0) <= 1) {
                        this.this$0.removeDialog(17);
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
               if (PaymentsActivity.access$1(this.this$0).parseConfirmResultSms(var12)) {
                  PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), PaymentsActivity.access$5(this.this$0));
                  if (PaymentsActivity.access$12(this.this$0) > 1) {
                     var9 = this.this$0;
                     PaymentsActivity.access$16(var9, PaymentsActivity.access$12(var9) - 1);
                     var9 = this.this$0;
                     PaymentsActivity.access$4(var9, PaymentsActivity.access$3(var9) - 1);
                     PaymentsActivity.access$13(this.this$0).removeCallbacks(PaymentsActivity.access$14(this.this$0));
                     this.this$0.removeDialog(17);
                     PaymentsActivity.access$6(this.this$0);
                  } else {
                     PaymentsActivity.access$8(this.this$0, var12.replace("success", "\u8d2d\u4e70\u6210\u529f"));
                     this.this$0.showDialog(20);
                  }

                  if (PaymentsActivity.access$1(this.this$0).getSmstype() == 1) {
                     Api.postSmsPayment(this.this$0.getApplicationContext(), this.this$0, PaymentsActivity.access$9(this.this$0).getCpID(), PaymentsActivity.access$9(this.this$0).getmGameID(), PaymentsActivity.access$9(this.this$0).getmActionID(), Utils.getSmsPayment(), PaymentsActivity.access$9(this.this$0).getmActionID(), PaymentsActivity.access$1(this.this$0).getSmschannelid(), PaymentsActivity.access$1(this.this$0).getSmsnumber(), PaymentsActivity.access$1(this.this$0).getContent(), PaymentsActivity.access$1(this.this$0).getSmstype());
                  }
               } else {
                  PaymentsActivity.access$8(this.this$0, var12);
                  this.this$0.showDialog(21);
               }
            }
         }

         this.mCursor.close();
      }

   }
}
