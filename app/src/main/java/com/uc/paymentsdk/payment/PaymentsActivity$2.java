package com.uc.paymentsdk.payment.PaymentsActivity$2;
import java.lang.Runnable;
import com.uc.paymentsdk.payment.PaymentsActivity;
import java.lang.Object;
import android.database.ContentObserver;
import android.content.ContentResolver;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import java.lang.String;
import android.content.BroadcastReceiver;
import android.content.Context;
import com.uc.paymentsdk.util.PrefUtil;

class PaymentsActivity$2 implements Runnable	// class@0000b2 from classes.dex
{
    final PaymentsActivity this$0;

    void PaymentsActivity$2(PaymentsActivity p0){
       this.this$0 = p0;
       super();
    }
    public void run(){
       if (PaymentsActivity.access$10(this.this$0) != null) {
          this.this$0.getContentResolver().unregisterContentObserver(PaymentsActivity.access$10(this.this$0));
       }
       this.this$0.removeDialog(17);
       if (PaymentsActivity.access$1(this.this$0).needconfirm != null) {
          PaymentsActivity.access$8(this.this$0, "\x5b\x02\x4e\x02\x8d\x02\xff\x02\x63\x02\x65\x02\x78\x02\x8b\x02\x77\x02\x4f\x02\x8d\x02\x65\x02\xff\x02\x8b\x02\x91\x02\x65\x02\x5c\x02\x8b\x02\x65\x02\x4e\x02\xff\x02");
          this.this$0.showDialog(21);
       }else if(PaymentsActivity.access$3(this.this$0) > 0){
          PaymentsActivity.access$8(this.this$0, "\x5b\x02\x4e\x02\x8d\x02\xff\x02\x77\x02\x4f\x02\x65\x02\x4e\x02\x5d\x02\x7e\x02\x8d\x02\x65\x02\xff\x02\x8b\x02\x91\x02\x65\x02\x65\x02\x4e\x02\xff\x02");
          this.this$0.showDialog(21);
       }else {
          PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), PaymentsActivity.access$5(this.this$0));
          PaymentsActivity.access$8(this.this$0, "\x61\x02\x8c\x02\x60\x02\x76\x02\x4f\x02\x75\x02\xff\x02\x79\x02\x60\x02\x73\x02\x5f\x02\x5f\x02\x5f\x02\xff\x02");
          this.this$0.showDialog(20);
       }
       try{
          this.this$0.unregisterReceiver(PaymentsActivity.access$7(this.this$0));
       }catch(java.lang.IllegalArgumentException e0){
       }
       return;
    }
}
