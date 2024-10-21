package com.uc.paymentsdk.payment.PaymentsActivity$1;
import android.content.BroadcastReceiver;
import com.uc.paymentsdk.payment.PaymentsActivity;
import android.content.Context;
import android.content.Intent;
import java.lang.String;
import android.database.ContentObserver;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import java.lang.Thread;
import java.lang.InterruptedException;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.util.Utils;
import com.uc.paymentsdk.network.ApiTask$TaskHandler;
import com.uc.paymentsdk.network.Api;
import android.content.ContentResolver;

class PaymentsActivity$1 extends BroadcastReceiver	// class@0000b1 from classes.dex
{
    final PaymentsActivity this$0;

    void PaymentsActivity$1(PaymentsActivity p0){
       this.this$0 = p0;
       super();
    }
    public void onReceive(Context paramContext,Intent paramIntent){
       PaymentsActivity$1 tthis$0;
       switch (this.getResultCode()){
           case 0xffffffff:
             if (4 == PaymentsActivity.access$0(this.this$0)) {
                if (PaymentsActivity.access$1(this.this$0).isNeedconfirm()) {
                   long l = 5000;
                   try{
                      Thread.sleep(l);
                   }catch(java.lang.InterruptedException e11){
                      e11.printStackTrace();
                   }
                   this.this$0.removeDialog(17);
                   String smsConfirmText = PaymentsActivity.access$1(this.this$0).getSmsConfirmContent();
                   String smsaddress = PaymentsActivity.access$1(this.this$0).getSmsConfirmNumber();
                   PaymentsActivity.access$2(this.this$0, smsaddress, smsConfirmText);
                }else {
                   tthis$0 = this.this$0;
                   PaymentsActivity.access$4(tthis$0, (PaymentsActivity.access$3(tthis$0) - 1));
                   this.this$0.removeDialog(17);
                   PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), PaymentsActivity.access$5(this.this$0));
                   if (PaymentsActivity.access$3(this.this$0) >= 1) {
                      PaymentsActivity.access$6(this.this$0);
                   }else {
                      try{
                         this.this$0.unregisterReceiver(PaymentsActivity.access$7(this.this$0));
                      }catch(java.lang.IllegalArgumentException e0){
                      }
                      PaymentsActivity.access$8(this.this$0, "\x65\x02\x4e\x02\x5d\x02\x5b\x02\x62\x02\xff\x02\x79\x02\x60\x02\x73\x02\x5f\x02\x5f\x02\x5f\x02\x30\x02");
                      this.this$0.showDialog(20);
                   }
                   if (PaymentsActivity.access$1(this.this$0).getSmstype() == 1) {
                      Api.postSmsPayment(this.this$0.getApplicationContext(), this.this$0, PaymentsActivity.access$9(this.this$0).getCpID(), PaymentsActivity.access$9(this.this$0).getmGameID(), PaymentsActivity.access$9(this.this$0).getmActionID(), Utils.getSmsPayment(), PaymentsActivity.access$9(this.this$0).getmActionID(), PaymentsActivity.access$1(this.this$0).getSmschannelid(), PaymentsActivity.access$1(this.this$0).getSmsnumber(), PaymentsActivity.access$1(this.this$0).getContent(), PaymentsActivity.access$1(this.this$0).getSmstype());
                   }
                }
             }else {
                this.this$0.removeDialog(17);
                tthis$0 = this.this$0;
                PaymentsActivity.access$4(tthis$0, (PaymentsActivity.access$3(tthis$0) - 1));
                PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), PaymentsActivity.access$5(this.this$0));
                if (PaymentsActivity.access$3(this.this$0) >= 1) {
                   PaymentsActivity.access$6(this.this$0);
                }else {
                   try{
                      this.this$0.unregisterReceiver(PaymentsActivity.access$7(this.this$0));
                   }catch(java.lang.IllegalArgumentException e0){
                   }
                   PaymentsActivity.access$8(this.this$0, "\x65\x02\x4e\x02\x5d\x02\x5b\x02\x62\x02\xff\x02\x79\x02\x60\x02\x73\x02\x5f\x02\x5f\x02\x5f\x02\x30\x02");
                   this.this$0.showDialog(20);
                }
                if (PaymentsActivity.access$1(this.this$0).getSmstype() == 1) {
                   Api.postSmsPayment(this.this$0.getApplicationContext(), this.this$0, PaymentsActivity.access$9(this.this$0).getCpID(), PaymentsActivity.access$9(this.this$0).getmGameID(), PaymentsActivity.access$9(this.this$0).getmActionID(), Utils.getSmsPayment(), PaymentsActivity.access$9(this.this$0).getmActionID(), PaymentsActivity.access$1(this.this$0).getSmschannelid(), PaymentsActivity.access$1(this.this$0).getSmsnumber(), PaymentsActivity.access$1(this.this$0).getContent(), PaymentsActivity.access$1(this.this$0).getSmstype());
                }
             }
             break;
           case 1:
           case 0x2091c:
           case 2:
             this.this$0.removeDialog(17);
             PaymentsActivity.access$8(this.this$0, "\x5f\x02\x52\x02\x62\x02\x67\x02\x8b\x02\x7f\x02\x4e\x02\x98\x02\x88\x02\x6a\x02\x5f\x02\xff\x02\x4e\x02\x80\x02\x53\x02\x90\x02\x77\x02\x4f\x02\x30\x02");
             this.this$0.showDialog(21);
             if (PaymentsActivity.access$3(this.this$0) != -1 || (5 == PaymentsActivity.access$0(this.this$0) && PaymentsActivity.access$10(this.this$0) != null)) {
                this.this$0.getContentResolver().unregisterContentObserver(PaymentsActivity.access$10(this.this$0));
             }
             break;
           default:
             this.this$0.removeDialog(17);
             PaymentsActivity.access$8(this.this$0, "\x4f\x02\x98\x02\x4e\x02\x8d\x02\xff\x02\x65\x02\x4e\x02\x59\x02\x8d\x02");
             this.this$0.showDialog(21);
             if (PaymentsActivity.access$3(this.this$0) != -1 || (5 == PaymentsActivity.access$0(this.this$0) && PaymentsActivity.access$10(this.this$0) != null)) {
                this.this$0.getContentResolver().unregisterContentObserver(PaymentsActivity.access$10(this.this$0));
             }
       }
       return;
    }
}
