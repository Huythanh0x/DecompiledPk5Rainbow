package com.PetKing5_480x800.PetKing5;
import javax.microedition.lcdui.CwaActivity;
import main.SMSSender;
import android.content.Context;
import com.uc.paymentsdk.payment.PaymentsActivity;
import android.content.Intent;
import java.lang.StringBuilder;
import java.lang.String;
import android.util.Log;
import main.GameRun;
import main.MainCanvas;
import main.Map;
import java.lang.Exception;
import java.lang.System;
import java.io.PrintStream;
import android.os.Bundle;
import main.XConnection;
import javax.microedition.midlet.MIDlet;
import java.lang.Class;
import com.uc.paymentsdk.payment.PaymentInfo;
import java.io.Serializable;

public class PetKing5 extends CwaActivity	// class@000079 from classes.dex
{
    AlertDialog ad;
    XConnection instance;
    public static GameRun gr;
    public static Intent intent;

    static {
       PetKing5.intent = null;
       PetKing5.gr = null;
    }
    public void PetKing5(){
       super();
       SMSSender.pk = this;
       PaymentsActivity.init(this);
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
       SMSSender sMSSender;
       Exception e;
       try{
          int i = -1;
          super.onActivityResult(requestCode, resultCode, data);
          if (!requestCode) {
             if (i == resultCode) {
                Log.e(resultCode, "================resultCode");
                Log.e("\x62\x02\x52\x02", "\x62\x02\x52\x02");
                sMSSender = SMSSender.i(SMSSender.gr);
                i = 4;
                sMSSender.setSendSms(i);
                if (SMSSender.smsType == 6) {
                   SMSSender.i(SMSSender.gr).sendSuccess();
                   SMSSender.i(SMSSender.gr).setSendSms(-1);
                   GameRun.run_state = -10;
                   GameRun.mc.temp_state = GameRun.run_state;
                   GameRun.mc.setSmsIsSetRun_state(true);
                   SMSSender.gr.map.setRegState(true);
                }else {
                   SMSSender.i(SMSSender.gr).sendSuccess();
                }
             }else {
                sMSSender = SMSSender.i(SMSSender.gr);
                try{
                   sMSSender.setSendSms(i);
                   if (SMSSender.smsType == 7) {
                      SMSSender.i(SMSSender.gr).sms_a = true;
                      SMSSender.gr.goGameOver();
                      System.out.println("ccccccccc");
                      GameRun.mc.setSmsIsSetRun_state(true);
                   }else if(SMSSender.smsType == 5){
                      GameRun.run_state = -10;
                      GameRun.mc.temp_state = GameRun.run_state;
                      SMSSender.gr.map.setRegState(false);
                      GameRun.mc.setSmsIsSetRun_state(true);
                   }else if(SMSSender.smsType == 6){
                      GameRun.run_state = -10;
                      GameRun.mc.setSmsIsSetRun_state(true);
                      SMSSender.gr.map.setRegState(false);
                   }else if(SMSSender.smsType == 1 && SMSSender.i(SMSSender.gr).getSmsSenderMenuState()){
                      GameRun.mc.setSmsIsSetRun_state(true);
                      GameRun.run_state = SMSSender.i(SMSSender.gr).getTstate();
                   }
                }catch(java.lang.Exception e3){
                   e = e3;
                   e.printStackTrace();
                }
             }
          }
          SMSSender.i(SMSSender.gr);
          SMSSender.isWorking = false;
          return;
       }catch(java.lang.Exception e3){
          e = e3;
          e.printStackTrace();
       }
       data.getStringExtra("number");
       data.getStringExtra("orderId");
    }
    public void onCreate(Bundle savedInstanceState){
       this.setFullWindow(true);
       super.onCreate(savedInstanceState);
       this.instance = new XConnection();
       this.setMIDlet(this.instance);
       this.setContentView();
       PetKing5.intent = this.getIntent();
    }
    protected void onDestroy(){
       super.onDestroy();
    }
    public void setSmshah(){
       Intent v16;
       String DebugAdress = "10086";
       switch (SMSSender.smsType){
           case 1:
             Intent intent = new Intent(this.getApplicationContext(), PaymentsActivity.class);
             PaymentInfo info = new PaymentInfo("\x8d\x02\x4e\x025000\x91\x02", "22", "01", "\x8e\x02\x4e\x02\x56\x02\x59\x02\x5b\x02\x65\x02\x4e\x02\x99\x02\x76\x02\x8d\x02\x51\x02\x5b\x02\xff\x02\x6c\x02\x94\x02\x53\x02\x4e\x02\x88\x02\xff\x02\x7a\x02\x52\x02\x62\x02\x67\x025000\x91\x02\x30\x02", 20);
             intent.putExtra("com.mappn.sdk.paymentinfo", info);
             this.startActivityForResult(intent, 0);
             break;
           case 2:
           case 3:
             v16 = new Intent(this.getApplicationContext(), PaymentsActivity.class);
             PaymentInfo info1 = new PaymentInfo("\x8d\x02\x4e\x0210\x5f\x02\x7a\x02", "22", "02", "\x8d\x02\x4e\x02\x8b\x02\x72\x02\x6b\x02\x90\x02\x51\x02\xff\x02\x7a\x02\x52\x02\x62\x02\x67\x0210\x5f\x02\x7a\x02\xff\x02\x80\x02\x8d\x02\x4e\x02\x53\x02\x50\x02\x7e\x02\x9a\x02\xff\x02\x5b\x02\x72\x02\x62\x02\x80\x02\xff\x02\x5f\x02\x59\x02\x76\x02\x5b\x02\x72\x02\x63\x02\x83\x02\x74\x02\x7b\x02\x54\x02\x79\x02\x79\x02\x59\x02\x76\x02\x90\x02\x51\x02\x30\x02", 20);
             v16.putExtra("com.mappn.sdk.paymentinfo", info1);
             this.startActivityForResult(v16, 0);
             break;
           case 4:
             v16 = new Intent(this.getApplicationContext(), PaymentsActivity.class);
             PaymentInfo info2 = new PaymentInfo("\x5b\x02\x72\x02\x53\x025\x7e\x02", "22", "03", "\x8b\x02\x60\x02\x96\x02\x8e\x02\x64\x02\x5e\x02\x76\x02\x51\x02\x90\x02\x5b\x02\x72\x02\x7a\x02\x52\x02\x53\x025\x7e\x02\xff\x02\x8d\x02\x8f\x0270\x7e\x02\x5b\x02\x72\x02\x4e\x02\x80\x02\x51\x02\x53\x02\x7e\x02\xff\x02", 20);
             v17.putExtra("com.mappn.sdk.paymentinfo", info2);
             this.startActivityForResult(v17, 0);
             break;
           case 5:
             v16 = new Intent(this.getApplicationContext(), PaymentsActivity.class);
             PaymentInfo info3 = new PaymentInfo("\x8d\x02\x4e\x02\x59\x02\x5f\x02\x51\x02", "22", "04", "\x8d\x02\x4e\x02\x8b\x02\x72\x02\x6b\x02\x90\x02\x51\x02\xff\x02\x83\x02\x5f\x02\x53\x02\x72\x02\x76\x02\x59\x02\x5f\x02\x51\x02\xff\x02\x79\x02\x52\x02\x90\x02\x5e\x02\x53\x02\x4e\x02\x63\x02\x9a\x02\x4e\x02\x50\x02\xff\x02\x4e\x02\x4e\x02\x4f\x02\x90\x02\x52\x02\x4e\x02\x4f\x02\x65\x02\x4e\x02\xff\x02\x65\x02\x96\x02\x4f\x02\x75\x02\xff\x02\x5f\x02\x52\x02\x4e\x02\x59\x02\x88\x02\x52\x02\xff\x02\x5f\x02\x8d\x02\x4e\x02\x54\x02\xff\x02", 20);
             v18.putExtra("com.mappn.sdk.paymentinfo", info3);
             this.startActivityForResult(v18, 0);
             break;
           case 6:
             v16 = new Intent(this.getApplicationContext(), PaymentsActivity.class);
             PaymentInfo info4 = new PaymentInfo("\x6b\x02\x72\x02\x9a\x02\x8b\x02", "22", "05", "\x6e\x02\x62\x02\x8b\x02\x73\x02\x7e\x02\x67\x02\xff\x02\x8d\x02\x4e\x02\x6b\x02\x98\x02\x5c\x02\x5f\x02\x54\x02\x54\x02\x7e\x02\x62\x02\x67\x02\x6e\x02\x62\x02\x51\x02\x5b\x02\x30\x02\x57\x02\x56\x02\x30\x02\x54\x02\x65\x02\x5c\x02\x51\x02\x8d\x02\x8d\x02\x90\x02\x60\x025\x67\x02\x5f\x02\x7a\x02\xff\x02\x53\x02\x8d\x02\x4e\x02\x5f\x02\x52\x02\x90\x02\x51\x02\xff\x02", 40);
             v19.putExtra("com.mappn.sdk.paymentinfo", info4);
             this.startActivityForResult(v19, 0);
             break;
           case 7:
             v16 = new Intent(this.getApplicationContext(), PaymentsActivity.class);
             PaymentInfo info5 = new PaymentInfo("\x53\x02\x7e\x02\x59\x02\x6d\x02", "22", "06", "\x8b\x02\x60\x02\x64\x02\x5e\x02\x76\x02\x62\x02\x67\x02\x5b\x02\x72\x02\x51\x02\x60\x02\x59\x02\xff\x02\x54\x02\x65\x02\x7a\x02\x52\x02\x8b\x02\x60\x02\x64\x02\x5e\x02\x76\x02\x5b\x02\x72\x02\x63\x02\x53\x025\x7e\x02\xff\x02\x8d\x02\x8f\x0270\x7e\x02\x5b\x02\x72\x02\x4e\x02\x80\x02\x51\x02\x53\x02\x7e\x02\xff\x02\xff\x02\x8b\x02\x63\x02\x4e\x02\x67\x02\x76\x02\x62\x02\x65\x02\x53\x02\x76\x02\x66\x02\x8f\x02\x67\x02\x30\x02", 20);
             v20.putExtra("com.mappn.sdk.paymentinfo", info5);
             this.startActivityForResult(v20, 0);
             break;
       }
       return;
    }
}
