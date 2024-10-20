package com.PetKing5_480x800;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.payment.PaymentsActivity;
import java.io.Serializable;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.midlet.MIDlet;
import main.GameRun;
import main.SMSSender;
import main.XConnection;

public class PetKing5 extends CwaActivity {
  public static GameRun gr;
  
  public static Intent intent = null;
  
  AlertDialog ad;
  
  XConnection instance;
  
  static {
    gr = null;
  }
  
  public PetKing5() {
    SMSSender.pk = this;
    PaymentsActivity.init((Context)this);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
      if (-1 == paramInt2) {
        Log.e(paramInt2, "================resultCode");
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
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        paramIntent.getStringExtra("number");
        paramIntent.getStringExtra("orderId");
      } else {
        SMSSender.i(SMSSender.gr).setSendSms(-1);
        try {
          if (SMSSender.smsType == 7) {
            (SMSSender.i(SMSSender.gr)).sms_a = true;
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
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      }  
    SMSSender.i(SMSSender.gr);
    SMSSender.isWorking = false;
  }
  
  public void onCreate(Bundle paramBundle) {
    setFullWindow(true);
    super.onCreate(paramBundle);
    this.instance = new XConnection();
    setMIDlet((MIDlet)this.instance);
    setContentView();
    intent = getIntent();
  }
  
  protected void onDestroy() {
    super.onDestroy();
  }
  
  public void setSmshah() {
    switch (SMSSender.smsType) {
      default:
        return;
      case 1:
        intent = new Intent(getApplicationContext(), PaymentsActivity.class);
        intent.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("购买5000金", "22", "01", "身为四大家族之首的贵公子，没钱可不行！立刻拥有5000金。", 20));
        startActivityForResult(intent, 0);
      case 3:
        intent = new Intent(getApplicationContext(), PaymentsActivity.class);
        intent.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("购买10徽章", "22", "02", "购买该特殊道具，立刻拥有10徽章，能购买双倍经验，宠物技能，强大的宠物捕获球等各种神奇的道具。", 20));
        startActivityForResult(intent, 0);
      case 4:
        intent = new Intent(getApplicationContext(), PaymentsActivity.class);
        intent.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("宠物升5级", "22", "03", "让您随身携带的全部宠物立刻升5级（超过70级宠物不能再升级）", 20));
        startActivityForResult(intent, 0);
      case 5:
        intent = new Intent(getApplicationContext(), PaymentsActivity.class);
        intent.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("购买奇异兽", "22", "04", "购买该特殊道具，获得可爱的奇异兽，移动速度可以提高一倍，且不会遇到任何敌人！无限使用，心动不如行动，快购买吧！", 20));
        startActivityForResult(intent, 0);
      case 6:
        intent = new Intent(getApplicationContext(), PaymentsActivity.class);
        intent.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("正版验证", "22", "05", "游戏试玩结束，购买此项将开启后续所有游戏内容、地图。同时将免费赠送您5枚徽章（可购买强力道具）", 40));
        startActivityForResult(intent, 0);
      case 7:
        break;
    } 
    Intent intent = new Intent(getApplicationContext(), PaymentsActivity.class);
    intent.putExtra("com.mappn.sdk.paymentinfo", (Serializable)new PaymentInfo("升级复活", "22", "06", "让您携带的所有宠物全恢复，同时立刻让您携带的宠物提升5级（超过70级宠物不能再升级），让接下来的战斗变的更轻松。", 20));
    startActivityForResult(intent, 0);
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/PetKing5_480x800/PetKing5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */