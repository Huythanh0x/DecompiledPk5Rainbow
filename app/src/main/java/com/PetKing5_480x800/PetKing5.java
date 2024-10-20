package com.PetKing5_480x800;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.payment.PaymentsActivity;
import javax.microedition.lcdui.CwaActivity;
import main.GameRun;
import main.SMSSender;
import main.XConnection;

/* loaded from: classes.dex */
public class PetKing5 extends CwaActivity {
    AlertDialog ad;
    XConnection instance;
    public static Intent intent = null;
    public static GameRun gr = null;

    public PetKing5() {
        SMSSender.pk = this;
        PaymentsActivity.init(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.microedition.lcdui.CwaActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // javax.microedition.lcdui.CwaActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        setFullWindow(true);
        super.onCreate(savedInstanceState);
        this.instance = new XConnection();
        setMIDlet(this.instance);
        setContentView();
        intent = getIntent();
    }

    public void setSmshah() {
        switch (SMSSender.smsType) {
            case 1:
                Intent intent2 = new Intent(getApplicationContext(), (Class<?>) PaymentsActivity.class);
                PaymentInfo info = new PaymentInfo("购买5000金", "22", "01", "身为四大家族之首的贵公子，没钱可不行！立刻拥有5000金。", 20);
                intent2.putExtra(PaymentsActivity.EXTRA_KEY_PAYMENTINFO, info);
                startActivityForResult(intent2, 0);
                return;
            case 2:
            default:
                return;
            case 3:
                Intent intent1 = new Intent(getApplicationContext(), (Class<?>) PaymentsActivity.class);
                PaymentInfo info1 = new PaymentInfo("购买10徽章", "22", "02", "购买该特殊道具，立刻拥有10徽章，能购买双倍经验，宠物技能，强大的宠物捕获球等各种神奇的道具。", 20);
                intent1.putExtra(PaymentsActivity.EXTRA_KEY_PAYMENTINFO, info1);
                startActivityForResult(intent1, 0);
                return;
            case 4:
                Intent intent22 = new Intent(getApplicationContext(), (Class<?>) PaymentsActivity.class);
                PaymentInfo info2 = new PaymentInfo("宠物升5级", "22", "03", "让您随身携带的全部宠物立刻升5级（超过70级宠物不能再升级）", 20);
                intent22.putExtra(PaymentsActivity.EXTRA_KEY_PAYMENTINFO, info2);
                startActivityForResult(intent22, 0);
                return;
            case 5:
                Intent intent3 = new Intent(getApplicationContext(), (Class<?>) PaymentsActivity.class);
                PaymentInfo info3 = new PaymentInfo("购买奇异兽", "22", "04", "购买该特殊道具，获得可爱的奇异兽，移动速度可以提高一倍，且不会遇到任何敌人！无限使用，心动不如行动，快购买吧！", 20);
                intent3.putExtra(PaymentsActivity.EXTRA_KEY_PAYMENTINFO, info3);
                startActivityForResult(intent3, 0);
                return;
            case 6:
                Intent intent4 = new Intent(getApplicationContext(), (Class<?>) PaymentsActivity.class);
                PaymentInfo info4 = new PaymentInfo("正版验证", "22", "05", "游戏试玩结束，购买此项将开启后续所有游戏内容、地图。同时将免费赠送您5枚徽章（可购买强力道具）", 40);
                intent4.putExtra(PaymentsActivity.EXTRA_KEY_PAYMENTINFO, info4);
                startActivityForResult(intent4, 0);
                return;
            case 7:
                Intent intent5 = new Intent(getApplicationContext(), (Class<?>) PaymentsActivity.class);
                PaymentInfo info5 = new PaymentInfo("升级复活", "22", "06", "让您携带的所有宠物全恢复，同时立刻让您携带的宠物提升5级（超过70级宠物不能再升级），让接下来的战斗变的更轻松。", 20);
                intent5.putExtra(PaymentsActivity.EXTRA_KEY_PAYMENTINFO, info5);
                startActivityForResult(intent5, 0);
                return;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (-1 == resultCode) {
                Log.e(new StringBuilder().append(resultCode).toString(), "================resultCode");
                Log.e("成功", "成功");
                SMSSender.i(SMSSender.gr).setSendSms(4);
                try {
                    if (SMSSender.smsType == 6) {
                        SMSSender.i(SMSSender.gr).sendSuccess();
                        SMSSender.i(SMSSender.gr).setSendSms(-1);
                        GameRun.run_state = -10;
                        GameRun.mc.temp_state = GameRun.run_state;
                        GameRun.mc.setSmsIsSetRun_state(true);
                        SMSSender.gr.map.setRegState(true);
                    } else {
                        SMSSender.i(SMSSender.gr).sendSuccess();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                data.getStringExtra(PaymentsActivity.EXTRA_KEY_NUMBER);
                data.getStringExtra(PaymentsActivity.EXTRA_KEY_ORDER_ID);
            } else {
                SMSSender.i(SMSSender.gr).setSendSms(-1);
                try {
                    if (SMSSender.smsType == 7) {
                        SMSSender.i(SMSSender.gr).sms_a = true;
                        SMSSender.gr.goGameOver();
                        System.out.println("ccccccccc");
                        GameRun.mc.setSmsIsSetRun_state(true);
                    } else if (SMSSender.smsType == 5) {
                        GameRun.run_state = -10;
                        GameRun.mc.temp_state = GameRun.run_state;
                        SMSSender.gr.map.setRegState(false);
                        GameRun.mc.setSmsIsSetRun_state(true);
                    } else if (SMSSender.smsType == 6) {
                        GameRun.run_state = -10;
                        GameRun.mc.setSmsIsSetRun_state(true);
                        SMSSender.gr.map.setRegState(false);
                    } else if (SMSSender.smsType == 1 && SMSSender.i(SMSSender.gr).getSmsSenderMenuState() != 0) {
                        GameRun.mc.setSmsIsSetRun_state(true);
                        GameRun.run_state = SMSSender.i(SMSSender.gr).getTstate();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        SMSSender.i(SMSSender.gr);
        SMSSender.isWorking = false;
    }
}
