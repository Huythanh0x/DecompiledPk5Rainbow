package com.PetKing5_480x800;

import java.io.Serializable;
import com.uc.paymentsdk.payment.PaymentInfo;
import javax.microedition.midlet.MIDlet;
import android.os.Bundle;
import android.util.Log;
import android.content.Context;
import com.uc.paymentsdk.payment.PaymentsActivity;
import main.SMSSender;
import main.XConnection;
import android.app.AlertDialog;
import android.content.Intent;
import main.GameRun;
import javax.microedition.lcdui.CwaActivity;

public class PetKing5 extends CwaActivity
{
    public static GameRun gr;
    public static Intent intent;
    AlertDialog ad;
    XConnection instance;
    
    static {
        PetKing5.intent = null;
        PetKing5.gr = null;
    }
    
    public PetKing5() {
        super();
        PaymentsActivity.init((Context)(SMSSender.pk = this));
    }
    
    protected void onActivityResult(final int n, final int i, final Intent ex) {
        super.onActivityResult(n, i, (Intent)ex);
        while (true) {
            Label_0126: {
                if (n != 0) {
                    break Label_0126;
                }
                if (-1 != i) {
                    SMSSender.i(SMSSender.gr).setSendSms(-1);
                    Label_0220: {
                        try {
                            if (SMSSender.smsType == 7) {
                                SMSSender.i(SMSSender.gr).sms_a = true;
                                SMSSender.gr.goGameOver();
                                System.out.println("ccccccccc");
                                GameRun.mc.setSmsIsSetRun_state(true);
                                break Label_0126;
                            }
                            break Label_0220;
                        }
                        catch (final Exception ex) {
                            ex.printStackTrace();
                            break Label_0126;
                        }
                        break Label_0126;
                    }
                    if (SMSSender.smsType == 5) {
                        GameRun.run_state = -10;
                        GameRun.mc.temp_state = GameRun.run_state;
                        SMSSender.gr.map.setRegState(false);
                        GameRun.mc.setSmsIsSetRun_state(true);
                        break Label_0126;
                    }
                    if (SMSSender.smsType == 6) {
                        GameRun.run_state = -10;
                        GameRun.mc.setSmsIsSetRun_state(true);
                        SMSSender.gr.map.setRegState(false);
                        break Label_0126;
                    }
                    if (SMSSender.smsType == 1 && SMSSender.i(SMSSender.gr).getSmsSenderMenuState() != 0) {
                        GameRun.mc.setSmsIsSetRun_state(true);
                        GameRun.run_state = SMSSender.i(SMSSender.gr).getTstate();
                        break Label_0126;
                    }
                    break Label_0126;
                }
                Log.e(new StringBuilder().append(i).toString(), "================resultCode");
                Log.e("\u6210\u529f", "\u6210\u529f");
                SMSSender.i(SMSSender.gr).setSendSms(4);
                try {
                    if (SMSSender.smsType == 6) {
                        SMSSender.i(SMSSender.gr).sendSuccess();
                        SMSSender.i(SMSSender.gr).setSendSms(-1);
                        GameRun.run_state = -10;
                        GameRun.mc.temp_state = GameRun.run_state;
                        GameRun.mc.setSmsIsSetRun_state(true);
                        SMSSender.gr.map.setRegState(true);
                    }
                    else {
                        SMSSender.i(SMSSender.gr).sendSuccess();
                    }
                    ((Intent)ex).getStringExtra("number");
                    ((Intent)ex).getStringExtra("orderId");
                    SMSSender.i(SMSSender.gr);
                    SMSSender.isWorking = false;
                    return;
                }
                catch (final Exception ex2) {
                    ex2.printStackTrace();
                    continue;
                }
            }
            continue;
        }
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        this.setFullWindow(true);
        super.onCreate(bundle);
        this.setMIDlet(this.instance = new XConnection());
        this.setContentView();
        PetKing5.intent = this.getIntent();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    
    public void setSmshah() {
        switch (SMSSender.smsType) {
            case 1: {
                final Intent intent = new Intent(this.getApplicationContext(), (Class)PaymentsActivity.class);
                intent.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("\u8d2d\u4e705000\u91d1", "22", "01", "\u8eab\u4e3a\u56db\u5927\u5bb6\u65cf\u4e4b\u9996\u7684\u8d35\u516c\u5b50\uff0c\u6ca1\u94b1\u53ef\u4e0d\u884c\uff01\u7acb\u523b\u62e5\u67095000\u91d1\u3002", 20));
                this.startActivityForResult(intent, 0);
                break;
            }
            case 3: {
                final Intent intent2 = new Intent(this.getApplicationContext(), (Class)PaymentsActivity.class);
                intent2.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("\u8d2d\u4e7010\u5fbd\u7ae0", "22", "02", "\u8d2d\u4e70\u8be5\u7279\u6b8a\u9053\u5177\uff0c\u7acb\u523b\u62e5\u670910\u5fbd\u7ae0\uff0c\u80fd\u8d2d\u4e70\u53cc\u500d\u7ecf\u9a8c\uff0c\u5ba0\u7269\u6280\u80fd\uff0c\u5f3a\u5927\u7684\u5ba0\u7269\u6355\u83b7\u7403\u7b49\u5404\u79cd\u795e\u5947\u7684\u9053\u5177\u3002", 20));
                this.startActivityForResult(intent2, 0);
                break;
            }
            case 4: {
                final Intent intent3 = new Intent(this.getApplicationContext(), (Class)PaymentsActivity.class);
                intent3.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("\u5ba0\u7269\u53475\u7ea7", "22", "03", "\u8ba9\u60a8\u968f\u8eab\u643a\u5e26\u7684\u5168\u90e8\u5ba0\u7269\u7acb\u523b\u53475\u7ea7\uff08\u8d85\u8fc770\u7ea7\u5ba0\u7269\u4e0d\u80fd\u518d\u5347\u7ea7\uff09", 20));
                this.startActivityForResult(intent3, 0);
                break;
            }
            case 5: {
                final Intent intent4 = new Intent(this.getApplicationContext(), (Class)PaymentsActivity.class);
                intent4.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("\u8d2d\u4e70\u5947\u5f02\u517d", "22", "04", "\u8d2d\u4e70\u8be5\u7279\u6b8a\u9053\u5177\uff0c\u83b7\u5f97\u53ef\u7231\u7684\u5947\u5f02\u517d\uff0c\u79fb\u52a8\u901f\u5ea6\u53ef\u4ee5\u63d0\u9ad8\u4e00\u500d\uff0c\u4e14\u4e0d\u4f1a\u9047\u5230\u4efb\u4f55\u654c\u4eba\uff01\u65e0\u9650\u4f7f\u7528\uff0c\u5fc3\u52a8\u4e0d\u5982\u884c\u52a8\uff0c\u5feb\u8d2d\u4e70\u5427\uff01", 20));
                this.startActivityForResult(intent4, 0);
                break;
            }
            case 6: {
                final Intent intent5 = new Intent(this.getApplicationContext(), (Class)PaymentsActivity.class);
                intent5.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("\u6b63\u7248\u9a8c\u8bc1", "22", "05", "\u6e38\u620f\u8bd5\u73a9\u7ed3\u675f\uff0c\u8d2d\u4e70\u6b64\u9879\u5c06\u5f00\u542f\u540e\u7eed\u6240\u6709\u6e38\u620f\u5185\u5bb9\u3001\u5730\u56fe\u3002\u540c\u65f6\u5c06\u514d\u8d39\u8d60\u9001\u60a85\u679a\u5fbd\u7ae0\uff08\u53ef\u8d2d\u4e70\u5f3a\u529b\u9053\u5177\uff09", 40));
                this.startActivityForResult(intent5, 0);
                break;
            }
            case 7: {
                final Intent intent6 = new Intent(this.getApplicationContext(), (Class)PaymentsActivity.class);
                intent6.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("\u5347\u7ea7\u590d\u6d3b", "22", "06", "\u8ba9\u60a8\u643a\u5e26\u7684\u6240\u6709\u5ba0\u7269\u5168\u6062\u590d\uff0c\u540c\u65f6\u7acb\u523b\u8ba9\u60a8\u643a\u5e26\u7684\u5ba0\u7269\u63d0\u53475\u7ea7\uff08\u8d85\u8fc770\u7ea7\u5ba0\u7269\u4e0d\u80fd\u518d\u5347\u7ea7\uff09\uff0c\u8ba9\u63a5\u4e0b\u6765\u7684\u6218\u6597\u53d8\u7684\u66f4\u8f7b\u677e\u3002", 20));
                this.startActivityForResult(intent6, 0);
                break;
            }
        }
    }
}
