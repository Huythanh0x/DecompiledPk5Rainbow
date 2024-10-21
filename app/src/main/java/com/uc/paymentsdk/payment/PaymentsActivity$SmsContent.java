package com.uc.paymentsdk.payment.PaymentsActivity$SmsContent;
import android.database.ContentObserver;
import com.uc.paymentsdk.payment.PaymentsActivity;
import android.os.Handler;
import java.lang.String;
import android.net.Uri;
import java.lang.StringBuilder;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import java.lang.Object;
import android.database.Cursor;
import java.lang.Runnable;
import android.content.ContentResolver;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.database.sqlite.SQLiteAbortException;
import android.content.Context;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.util.Utils;
import com.uc.paymentsdk.network.ApiTask$TaskHandler;
import com.uc.paymentsdk.network.Api;
import java.lang.CharSequence;

class PaymentsActivity$SmsContent extends ContentObserver	// class@0000b4 from classes.dex
{
    private Cursor mCursor;
    final PaymentsActivity this$0;
    private static final String BODY = "body";
    private static final String NUMBER = "address";

    public void PaymentsActivity$SmsContent(PaymentsActivity p0,Handler arg2){
       this.this$0 = p0;
       super(arg2);
    }
    public void onChange(boolean paramBoolean){
       ContentValues localContentValues;
       ContentValues uContentValu;
       String str;
       String str1;
       String[] stringArray2;
       SQLiteAbortException localSQLiteAbortException;
       String smscontent;
       String smsaddress;
       String smsconfirmnumber;
       PaymentsActivity$SmsContent smsContent;
       boolean bool;
       super.onChange(paramBoolean);
       Uri localUri = Uri.parse("content://sms/inbox");
       String[] stringArray = new String[]{"_id","address","body"};
       String[] stringArray1 = new String[]{String.valueOf(PaymentsActivity.access$1(this.this$0).getSmsnumber())+"%%",String.valueOf(PaymentsActivity.access$1(this.this$0).getSmsConfirmNumber())+"%%","0"};
       this.mCursor = this.this$0.managedQuery(localUri, stringArray, " address like ? or address like ? and read=?", stringArray1, "date desc");
       if (this.mCursor != null) {
          if (this.mCursor.moveToFirst()) {
             if (PaymentsActivity.access$11(this.this$0) > 0 && PaymentsActivity.access$11(this.this$0) > this.mCursor.getInt(0)) {
                this.mCursor.close();
             }else if(PaymentsActivity.access$12(this.this$0) <= 1){
                PaymentsActivity.access$13(this.this$0).removeCallbacks(PaymentsActivity.access$14(this.this$0));
                ContentResolver contentResol = this.this$0.getContentResolver();
                ContentObserver uContentObse = PaymentsActivity.access$10(this.this$0);
                contentResol.unregisterContentObserver(uContentObse);
                this.this$0.unregisterReceiver(PaymentsActivity.access$7(this.this$0));
             }
          }
          this.mCursor.close();
       }
       return;
    }
}
