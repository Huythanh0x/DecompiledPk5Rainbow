package com.uc.paymentsdk.payment.PaymentsActivity$3;
import com.uc.paymentsdk.network.chain.Handler$OnFinishListener;
import com.uc.paymentsdk.payment.PaymentsActivity;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import java.lang.Object;
import com.uc.paymentsdk.payment.sms.SmsInfos;
import com.uc.paymentsdk.util.Utils;

class PaymentsActivity$3 implements Handler$OnFinishListener	// class@0000b3 from classes.dex
{
    Button cancelBtn;
    RelativeLayout contentPanel;
    Button okBtn;
    int smsPayment;
    final PaymentsActivity this$0;
    TextView tvInfo2;
    TextView waitTV;

    void PaymentsActivity$3(PaymentsActivity p0,TextView p1,TextView p2,int p3,Button p4,Button p5,RelativeLayout p6){
       this.this$0 = p0;
       super();
       this.waitTV = p1;
       this.tvInfo2 = p2;
       this.smsPayment = p3;
       this.cancelBtn = p4;
       this.okBtn = p5;
       this.contentPanel = p6;
    }
    public void onFinish(){
       int i = 19;
       if (Utils.getSmsInfos() == null) {
          this.this$0.removeDialog(i);
          this.this$0.showDialog(15);
       }else {
          PaymentsActivity.access$17(this.this$0, true);
          this.this$0.removeDialog(i);
          PaymentsActivity.access$18(this.this$0, this.waitTV, this.tvInfo2, this.smsPayment, this.cancelBtn, this.okBtn, this.contentPanel);
       }
       return;
    }
}
