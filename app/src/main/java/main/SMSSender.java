package main.SMSSender;
import main.Key_H;
import main.GameRun;
import java.lang.Object;
import java.lang.Exception;
import java.lang.String;
import main.Constants_H;
import dm.Ui;
import java.lang.StringBuilder;
import main.Map;
import dm.Npc;
import android.util.Log;
import main.PointerKey;
import java.lang.Byte;
import java.lang.Class;
import java.lang.reflect.Array;
import java.lang.Short;
import dm.Monster;
import dm.Ms;
import com.PetKing5_480x800.PetKing5;
import dm.Battle;
import main.MainCanvas;
import dm.Sound;

public class SMSSender implements Key_H	// class@000168 from classes.dex
{
    private StringBuffer[] about;
    private byte currentPage;
    public byte idSmsLevel;
    public byte[][] menu;
    private String[][] menuTxt;
    public byte menu_state;
    public PointerKey pkey;
    public byte[] sel;
    public byte sendSms;
    public byte showLine;
    public byte[][] smsCount;
    public boolean sms_a;
    public boolean sms_b;
    public byte tMyState;
    private int tState;
    private byte totalPage;
    public static GameRun gr;
    public static boolean isWorking;
    public static PetKing5 pk;
    public static SMSSender smsSender;
    public static byte smsType;

    public void SMSSender(GameRun gr_){
       super();
       this.sms_a = true;
       this.sms_b = false;
       byte[][] uobyteArray = new byte[][5];
       byte[] uobyteArray1 = new byte[4];
       uobyteArray1[1] = 2;
       uobyteArray1[2] = 4;
       uobyteArray1[3] = 5;
       uobyteArray[0] = uobyteArray1;
       uobyteArray1 = new byte[true];
       uobyteArray1[0] = 6;
       uobyteArray[1] = uobyteArray1;
       uobyteArray1 = new byte[true];
       uobyteArray1[0] = 7;
       uobyteArray[2] = uobyteArray1;
       uobyteArray1 = new byte[true];
       uobyteArray1[0] = 8;
       uobyteArray[3] = uobyteArray1;
       uobyteArray1 = new byte[true];
       uobyteArray1[0] = 2;
       uobyteArray[4] = uobyteArray1;
       this.menu = uobyteArray;
       byte[] uobyteArray2 = new byte[2];
       this.sel = uobyteArray2;
       uobyteArray = new byte[][8];
       uobyteArray[0] = new byte[3]{0x04,0x01,0x01};
       uobyteArray[1] = new byte[3]{0x02,0x01,0x02};
       uobyteArray[2] = new byte[3]{0x04,0x01,0x03};
       uobyteArray[3] = new byte[3]{0x01,0x01,0x04};
       uobyteArray[4] = new byte[3]{0x02,0x01,0x05};
       byte[] uobyteArray3 = new byte[3];
       uobyteArray3[0] = true;
       uobyteArray3[1] = true;
       uobyteArray[5] = uobyteArray3;
       uobyteArray[6] = new byte[3]{0x02,0x01,0x06};
       uobyteArray[7] = new byte[3]{0x02,0x01,0x05};
       this.smsCount = uobyteArray;
       this.sendSms = -1;
       SMSSender.gr = gr_;
       try{
          SMSSender.smsSender = this;
          this.createSMS();
       }catch(java.lang.Exception e0){
          e0.printStackTrace();
       }
       return;
    }
    private void createSMS(){
       String[][] stringArray = new String[][9];
       String[] stringArray1 = new String[]{"\x55\x02\x57\x02"};
       stringArray[0] = stringArray1;
       stringArray1 = new String[]{"\x8d\x02\x4e\x0230000\x91\x02",""};
       stringArray[1] = stringArray1;
       stringArray1 = new String[]{"\x8d\x02\x4e\x025000\x91\x02","\x8e\x02\x4e\x02\x56\x02\x59\x02\x5b\x02\x65\x02\x4e\x02\x99\x02\x76\x02\x8d\x02\x51\x02\x5b\x02\xff\x02\x6c\x02\x94\x02\x53\x02\x4e\x02\x88\x02\xff\x02\x7a\x02\x52\x02\x62\x02\x67\x025000\x91\x02\x30\x02"};
       stringArray[2] = stringArray1;
       String[] stringArray2 = new String[]{"\x8d\x02\x4e\x0250\x5f\x02\x7a\x02",""};
       stringArray[3] = stringArray2;
       stringArray2 = new String[]{"\x8d\x02\x4e\x0210\x5f\x02\x7a\x02","\x8d\x02\x4e\x02\x8b\x02\x72\x02\x6b\x02\x90\x02\x51\x02\xff\x02\x7a\x02\x52\x02\x62\x02\x67\x0210\x5f\x02\x7a\x02\xff\x02\x80\x02\x8d\x02\x4e\x02\x53\x02\x50\x02\x7e\x02\x9a\x02\xff\x02\x5b\x02\x72\x02\x62\x02\x80\x02\xff\x02\x5f\x02\x59\x02\x76\x02\x5b\x02\x72\x02\x63\x02\x83\x02\x74\x02\x7b\x02\x54\x02\x79\x02\x79\x02\x59\x02\x76\x02\x90\x02\x51\x02\x30\x02"};
       stringArray[4] = stringArray2;
       stringArray2 = new String[]{"\x5b\x02\x72\x02\x53\x025\x7e\x02","\x8b\x02\x60\x02\x96\x02\x8e\x02\x64\x02\x5e\x02\x76\x02\x51\x02\x90\x02\x5b\x02\x72\x02\x7a\x02\x52\x02\x53\x025\x7e\x02\xff\x02\x8d\x02\x8f\x0270\x7e\x02\x5b\x02\x72\x02\x4e\x02\x80\x02\x51\x02\x53\x02\x7e\x02\xff\x02"};
       stringArray[5] = stringArray2;
       stringArray2 = new String[]{"\x8d\x02\x4e\x02\x59\x02\x5f\x02\x51\x02","\x8d\x02\x4e\x02\x8b\x02\x72\x02\x6b\x02\x90\x02\x51\x02\xff\x02\x83\x02\x5f\x02\x53\x02\x72\x02\x76\x02\x59\x02\x5f\x02\x51\x02\xff\x02\x79\x02\x52\x02\x90\x02\x5e\x02\x53\x02\x4e\x02\x63\x02\x9a\x02\x4e\x02\x50\x02\xff\x02\x4e\x02\x4e\x02\x4f\x02\x90\x02\x52\x02\x4e\x02\x4f\x02\x65\x02\x4e\x02\xff\x02\x65\x02\x96\x02\x4f\x02\x75\x02\xff\x02\x5f\x02\x52\x02\x4e\x02\x59\x02\x88\x02\x52\x02\xff\x02\x5f\x02\x8d\x02\x4e\x02\x54\x02\xff\x02"};
       stringArray[6] = stringArray2;
       stringArray2 = new String[]{"\x6b\x02\x72\x02\x9a\x02\x8b\x02","\x6e\x02\x62\x02\x8b\x02\x73\x02\x7e\x02\x67\x02\xff\x02\x8d\x02\x4e\x02\x6b\x02\x98\x02\x5c\x02\x5f\x02\x54\x02\x54\x02\x7e\x02\x62\x02\x67\x02\x6e\x02\x62\x02\x51\x02\x5b\x02\x30\x02\x57\x02\x56\x02\x30\x02\x54\x02\x65\x02\x5c\x02\x51\x02\x8d\x02\x8d\x02\x90\x02\x60\x025\x67\x02\x5f\x02\x7a\x02\xff\x02\x53\x02\x8d\x02\x4e\x02\x5f\x02\x52\x02\x90\x02\x51\x02\xff\x02"};
       stringArray[7] = stringArray2;
       stringArray2 = new String[]{"\x53\x02\x7e\x02\x59\x02\x6d\x02","\x8b\x02\x60\x02\x64\x02\x5e\x02\x76\x02\x62\x02\x67\x02\x5b\x02\x72\x02\x51\x02\x60\x02\x59\x02\xff\x02\x54\x02\x65\x02\x7a\x02\x52\x02\x8b\x02\x60\x02\x64\x02\x5e\x02\x76\x02\x5b\x02\x72\x02\x63\x02\x53\x025\x7e\x02\xff\x02\x8d\x02\x8f\x0270\x7e\x02\x5b\x02\x72\x02\x4e\x02\x80\x02\x51\x02\x53\x02\x7e\x02\xff\x02\xff\x02\x8b\x02\x63\x02\x4e\x02\x67\x02\x76\x02\x62\x02\x65\x02\x53\x02\x76\x02\x66\x02\x8f\x02\x67\x02\x30\x02"};
       stringArray[8] = stringArray2;
       this.menuTxt = stringArray;
    }
    private void draw0(){
       int ix = 23;
       boolean bLeft = true;
       boolean bRight = true;
       if (this.sendSms > -1) {
          String smsTip = "";
          if (this.sendSms == null) {
             int i = ((i = this.smsCount[SMSSender.smsType][2]) < 0)? 0: SMSSender.gr.rmsSms[i];
             smsTip = this.getSmsTip(i, (this.smsCount[SMSSender.smsType][1] - i));
          }else if(this.sendSms != 1 && (this.sendSms != 2 && this.sendSms != 3)){
             if (this.sendSms > 3 && (this.sendSms < 15 || (this.sendSms > ix && this.sendSms < 34))) {
                smsTip = "\x8d\x02\x4e\x02\x5d\x02\x62\x02\x52\x02\xff\x02";
                bRight = false;
                bLeft = bRight;
                if (this.sendSms > ix && this.sendSms < 34) {
                   this.sendSms = (byte)(this.sendSms + 1);
                }
             }else if(this.sendSms == 15){
                smsTip = "\x81\x02\x52\x02\x4f\x02\x5b\x02\x6e\x02\x62\x02\x30\x02";
                bRight = false;
                bLeft = bRight;
             }else if(this.sendSms < ix){
                smsTip = "\x4f\x02\x5b\x02\x6e\x02\x62\x02\x62\x02\x52\x02\x30\x02";
                this.sendSms = (byte)(this.sendSms + 1);
                bRight = false;
                bLeft = bRight;
                if (SMSSender.smsType == 5 && this.sendSms == ix) {
                   SMSSender.gr.say("\x8d\x02\x4e\x02\x5d\x02\x62\x02\x52\x02\xff\x02\x6e\x02\x62\x02\x5d\x02\x4f\x02\x5b\x02\x30\x02#n\x65\x02\x6e\x02\x62\x02\x54\x02\x6b\x02\x52\x02\x80\x02\x4e\x02\x51\x02\x89\x02\x6c\x02\x4e\x02\x8d\x02\x30\x02", -1);
                }else if(SMSSender.smsType == 6 && this.sendSms == ix){
                   SMSSender.gr.say("\x8d\x02\x4e\x02\x5d\x02\x62\x02\x52\x02\xff\x02\x83\x02\x5f\x025\x67\x02\x5f\x02\x7a\x02\(\x80\x02\x53\x02\x76\x02\x53\x02\x8f\x02\x75\x02\x97\x02\x53\x02\x67\x02\x77\x02\xff\x02\x30\x02\x6e\x02\x62\x02\x5d\x02\x4f\x02\x5b\x02\x30\x02#n\x65\x02\x6e\x02\x62\x02\x54\x02\x6b\x02\x52\x02\x80\x02\x4e\x02\x51\x02\x89\x02\x6c\x02\x4e\x02\x8d\x02\x30\x02", 0);
                }
             }
          }
          if (this.sendSms != 3 && (this.sendSms != 1 && this.sendSms != 2)) {
             SMSSender.gr.showString(smsTip, (Constants_H.HEIGHT_H - 50), 0);
          }
       }
       Ui.i().drawYesNo(bLeft, bRight);
       return;
    }
    private String getSmsTip(int i0,int i1){
       String tip = "";
       tip = String.valueOf(tip)+"\x60\x02\x5d\x02\x53\x02\x90\x02"+i0+"\x67\x02\x77\x02\x4f\x02\x30\x02"+"\x8d\x02\x4e\x02\x6b\x02\x98\x02\xff\x02\x8f\x02\x97\x02\x53\x02\x90\x02"+i1+"\x67\x02\x77\x02\x4f\x02\x30\x02"+"\x78\x02\x8b\x02\x53\x02\x90\x02\x77\x02\x4f\x02\x54\x02\xff\x02";
       return tip;
    }
    private void goWord(){
       this.showLine = 3;
    }
    public static SMSSender i(GameRun gr_){
       if (SMSSender.smsSender == null) {
          SMSSender.smsSender = new SMSSender(gr_);
       }
       return SMSSender.smsSender;
    }
    private void outState(){
       if (this.tState != -1) {
          GameRun.run_state = this.tState;
          SMSSender.gr.map.my.state = this.tMyState;
       }else {
          GameRun.run_state = -10;
       }
       return;
    }
    public void draw(){
       int i;
       int ix4;
       if (this.menu_state == null) {
          int WIDTH = 640;
          int HEIGHT = 360;
          int WIDTH_H = 320;
          int x = 1;
          int y = 1;
          int w = WIDTH - 2;
          int h = HEIGHT - 1;
          int fh = 28;
          Ui.i().fillRectB();
          Ui.i().drawK2(x, y, w, h, 0);
          Ui.i().drawK1((WIDTH_H - 75), (y + 3), 150, (fh - 4), 4);
          Ui.i().drawString(this.menuTxt[this.menu[this.menu_state][0]][0], WIDTH_H, (y + 1), 17, 0, 1);
          Log.e("sk", "draw");
          x = x + 5;
          y = y + 29;
          w = w - 10;
          if (this.menu[this.menu_state].length > 1) {
             Ui.i().drawK1(x, y, (w - 15), (fh * this.showLine), 1);
             Ui.i().sliding(((x + 628) - 13), y, (fh * this.showLine), (this.sel[0] - 1), (this.menu[this.menu_state].length - 1), true);
             Ui.i().drawListKY(this.showLine, x, (y + 2), (w - 15), 2, fh, -1, (this.sel[0] - this.sel[1]), 4, 2);
             i = this.sel[1];
             while (true) {
                int ix = this.sel[1] + this.showLine;
                if (i < ix && i < this.menu[this.menu_state].length) {
                   Ui ui = Ui.i();
                   object oobject = this.menuTxt[this.menu[this.menu_state][i]][0];
                   ix = w >> 1;
                   int ix1 = x + 314;
                   ix = y + 2;
                   ix = i - this.sel[1];
                   ix = ix * fh;
                   int ix2 = ix + 32;
                   ix = (this.sel[0] == i)? 0: 3;
                   ui.drawString(oobject, ix1, ix2, 17, ix, 0);
                   int ix3 = y + 2;
                   ix3 = i - this.sel[1];
                   ix3 = ix3 * fh;
                   ix3 = ix3 + 32;
                   if (this.pkey.isSelect(x, ix3, WIDTH, fh)) {
                      this.sel[0] = (byte)i;
                      this.setSmsType();
                   }
                   i++;
                }else {
                   break ;
                }
             }
             y = ((this.showLine * fh) + 5) + 30;
          }
          h = h - (y + 10);
          Ui.i().drawK1(x, y, w, h, 2);
          i = 0;
          this.draw0();
       }
       return;
    }
    public byte getSendSms(){
       return this.sendSms;
    }
    public byte getSmsSenderMenuState(){
       return this.menu_state;
    }
    public int getTstate(){
       return this.tState;
    }
    public void go(int menu_state_,boolean bb){
       if (bb) {
          this.tState = GameRun.run_state;
          this.tMyState = SMSSender.gr.map.my.state;
       }else {
          this.tState = -1;
       }
       this.sms_a = true;
       this.sms_b = false;
       GameRun.run_state = -20;
       this.menu_state = (byte)menu_state_;
       SMSSender tsel = this.sel;
       SMSSender tsel1 = this.sel;
       byte b = (this.menu[this.menu_state].length > 1)? true: false;
       b = (byte)b;
       tsel1[1] = b;
       tsel[0] = b;
       SMSSender.smsType = (byte)(this.menu[this.menu_state][this.sel[0]] - true);
       this.goWord();
       if (SMSSender.smsType != 5 && (SMSSender.smsType != 6 && (SMSSender.smsType != 7 && (this.menu_state != 4 && SMSSender.smsType == true)))) {
          this.sendSms = -1;
          SMSSender.isWorking = false;
       }else {
          this.sendSms = true;
       }
       return;
    }
    public void goLevel(){
       int ix;
       GameRun.run_state = -21;
       this.idSmsLevel = 0;
       if ((SMSSender.gr.b_c = 0) != -31) {
          SMSSender.gr.levelUp_in_battle = null;
          int[] ointArray = new int[]{SMSSender.gr.max_takes,2};
          SMSSender sMSSender = Array.newInstance(Byte.TYPE, ointArray);
          SMSSender.gr.levelUp_in_battle = this;
          SMSSender.gr.proReplace = null;
          ointArray = new int[]{SMSSender.gr.myMonsters.length,7};
          SMSSender.gr.proReplace = Array.newInstance(Short.TYPE, ointArray);
       }
       byte i = 0;
       while (i < SMSSender.gr.myMon_length) {
          if (SMSSender.gr.myMonsters[i].monster[2] >= 70) {
             SMSSender.gr.healMonster(SMSSender.gr.myMonsters[i]);
          }else {
             SMSSender.gr.proReplace[i][6] = SMSSender.gr.myMonsters[i].monster[2];
             SMSSender.gr.levelUp_in_battle[i][0] = 1;
             SMSSender.gr.levelUp_in_battle[i][1] = -1;
             byte j = 0;
             while (j < 5) {
                SMSSender.gr.levelPro(i, 0);
                SMSSender.gr.getMagic(SMSSender.gr.myMonsters[i]);
                if (SMSSender.gr.getSkill != -1) {
                   SMSSender.gr.levelUp_in_battle[i][1] = SMSSender.gr.getSkill;
                }
                ix = j + 1;
                j = (byte)ix;
             }
          }
          ix = i + 1;
          i = (byte)ix;
       }
       return;
    }
    public boolean isMyMonLevel(){
       int b;
       byte i = (byte)(SMSSender.gr.myMon_length - 1);
       while (true) {
          if (i <= -1) {
             b = false;
             break ;
          }else if(SMSSender.gr.myMonsters[i].monster[2] < 70){
             b = 1;
             break ;
          }else {
             b = i - 1;
             i = (byte)b;
          }
       }
       return b;
    }
    public void key(){
       int i = 0;
       byte b = -1;
       if (this.sendSms == b && Ms.i().key_Up_Down()) {
          if (!Ms.i().key_delay() && this.menu[this.menu_state].length > 1) {
             Ms.i().selectS(this.sel, 1, this.menu[this.menu_state].length, this.showLine);
             this.setSmsType();
          }
       }else if(this.sendSms != b && (this.sendSms != null || !Ms.i().key_S1())){
          if (this.sendSms == b || (this.sendSms == null || (this.sendSms == 3 || (this.sendSms == 24 && Ms.i().key_S2())))) {
             Ms.i().keyRelease();
             this.outState();
             if (SMSSender.smsType == 6) {
                GameRun.run_state = -10;
                SMSSender.isWorking = true;
             }
             this.sendSms = b;
          }
       }else {
          Ms.i().keyRelease();
          if (SMSSender.smsType == 4 && (this.sel[i] != 7 && (SMSSender.gr.myMon_length < 1 && this.isMyMonLevel()))) {
             this.sendSms = b;
             SMSSender.gr.say("\x76\x02\x52\x02\x6c\x02\x67\x02\x53\x02\x4e\x02\x53\x02\x7e\x02\x76\x02\x5b\x02\x72\x02\xff\x02", i);
          }else {
             this.sendSms = 1;
          }
       }
       return;
    }
    public void keyLevel(){
       if (!Ms.i().key_delay() && (SMSSender.gr.b_c == 1 && SMSSender.gr.say_s == null)) {
          SMSSender.gr.b_c = 0;
       }
       return;
    }
    public void paint(){
       this.draw();
    }
    public void paintLevel(){
       if (SMSSender.gr.b_c == true) {
          SMSSender.gr.drawEvolveUI(0, this.idSmsLevel, true);
       }
       return;
    }
    public void run(){
       if (this.sendSms == 1) {
          this.sendSms = 2;
          SMSSender.pk.setSmshah();
       }
       return;
    }
    public void runLevel(){
       if (SMSSender.gr.b_c == null) {
          if (SMSSender.gr.levelUp_in_battle[this.idSmsLevel][0] == 1) {
             SMSSender.gr.levelUp_in_battle[this.idSmsLevel][0] = 0;
             SMSSender.gr.b_c = 1;
             SMSSender.gr.say_s = 52;
             SMSSender.gr.levelPro(this.idSmsLevel, 1);
             SMSSender.gr.setStringB("\x75\x02\x54\x02;+"+SMSSender.gr.proReplace[this.idSmsLevel][0]+"#n"+"\x80\x02\x91\x02"+";+"+SMSSender.gr.proReplace[this.idSmsLevel][1], Constants_H.WIDTH, 0);
             SMSSender.gr.setStringB("\x52\x02\x91\x02;+"+SMSSender.gr.proReplace[this.idSmsLevel][3]+"#n"+"\x96\x02\x5f\x02"+";+"+SMSSender.gr.proReplace[this.idSmsLevel][4]+"#n"+"\x65\x02\x63\x02"+";+"+SMSSender.gr.proReplace[this.idSmsLevel][5], Constants_H.WIDTH, 1);
             SMSSender.gr.initMonStream(2, SMSSender.gr.mList_id[SMSSender.gr.myMonsters[this.idSmsLevel].monster[0]][0], 1);
          }else {
             this.idSmsLevel = (byte)(this.idSmsLevel + 1);
          }
          if (this.idSmsLevel >= SMSSender.gr.myMon_length) {
             if (this.tState == -1) {
                GameRun.run_state = -20;
                SMSSender.gr.levelUp_in_battle = null;
                SMSSender.gr.proReplace = null;
             }else {
                GameRun.run_state = this.tState;
                if (this.tState == -31) {
                   SMSSender.gr.initMonStream(2, SMSSender.gr.mList_id[SMSSender.gr.myB.getMon().monster[0]][0], 1);
                   SMSSender.gr.myB.act_num = 0;
                   SMSSender.gr.initSkillList(SMSSender.gr.myB.getMon());
                   byte i = 0;
                   while (i < SMSSender.gr.myMon_length) {
                      SMSSender.gr.proReplace[SMSSender.gr.myMonsters[i].monster[1]][6] = SMSSender.gr.myMonsters[i].monster[2];
                      int ix = i + 1;
                      i = (byte)ix;
                   }
                }
             }
          }
       }else if(SMSSender.gr.b_c == 1){
          SMSSender.gr.say_s = (byte)Ms.i().mathSpeedDown(SMSSender.gr.say_s, 4, 1);
       }
       return;
    }
    public void sendSuccess(){
       GameRun rmsSms;
       if (this.sendSms == 4 && this.smsCount[SMSSender.smsType][1] > 1) {
          rmsSms = SMSSender.gr.rmsSms;
          byte b = this.smsCount[SMSSender.smsType][2];
          byte b1 = (byte)(rmsSms[b] + 1);
          rmsSms[b] = b1;
          if (b1 != this.smsCount[SMSSender.smsType][1]) {
             this.sendSms = 0;
             Ms.i().rmsOptions(5, SMSSender.gr.rmsSms, 2);
             Ms.i().rmsOptions(5, null, 4);
          }else {
             SMSSender.gr.rmsSms[this.smsCount[SMSSender.smsType][2]] = 0;
          }
       }
       switch (SMSSender.smsType){
           case 0:
             break;
           case 1:
             rmsSms = SMSSender.gr;
             rmsSms.money = rmsSms.money + 5000;
             SMSSender.gr.say("\x8d\x02\x4e\x025000\x91\x02\x5e\x02", -1);
             GameRun.run_state = -10;
             GameRun.mc.temp_state = GameRun.run_state;
             break;
           case 2:
             rmsSms = SMSSender.gr;
             rmsSms.coin = rmsSms.coin + 50;
             SMSSender.gr.say("\x57\x02\x53\x02\x8f\x02\x55\x02\x5e\x02\x4e\x02\x62\x02\x80\x02\x77\x02\x52\x02\x5f\x02\x7a\x02\x65\x02\x91\x02", -1);
             GameRun.run_state = -10;
             GameRun.mc.temp_state = GameRun.run_state;
             break;
           case 3:
             rmsSms = SMSSender.gr;
             rmsSms.coin = rmsSms.coin + 10;
             SMSSender.gr.say("\x57\x02\x53\x02\x8f\x02\x55\x02\x5e\x02\x4e\x02\x62\x02\x80\x02\x77\x02\x52\x02\x5f\x02\x7a\x02\x65\x02\x91\x02", -1);
             GameRun.run_state = -10;
             GameRun.mc.temp_state = GameRun.run_state;
             break;
           case 4:
             this.tState = -1;
             SMSSender.gr.say("\x64\x02\x5e\x02\x76\x02\x5b\x02\x72\x02\x51\x02\x90\x02\x53\x025\x7e\x02,\x5b\x02\x72\x02\x98\x02\x97\x02\x67\x02\x77\x02\x65\x02\x5c\x02\x60\x02", 0, -1);
             GameRun.run_state = -10;
             GameRun.mc.temp_state = GameRun.run_state;
          label_00e4 :
             this.goLevel();
             GameRun.mc.setSmsIsSetRun_state(1);
             GameRun.run_state = -10;
             GameRun.mc.temp_state = GameRun.run_state;
             break;
           case 5:
             SMSSender.gr.rmsSms[0] = 10;
             SMSSender.gr.say("\x8d\x02\x4e\x02\x54\x02\x6b\x02\x52\x02\x80\x02\x4e\x02\x51\x02\x89\x02\x6c\x02\x4e\x02\x8d\x02", 0, -1);
             GameRun.run_state = -10;
             GameRun.mc.temp_state = GameRun.run_state;
             break;
           case 6:
             SMSSender.gr.rmsSms[this.smsCount[SMSSender.smsType][2]] = 10;
             rmsSms = SMSSender.gr;
             rmsSms.coin = rmsSms.coin + 5;
             this.sms_b = true;
             SMSSender.gr.say("\x8d\x02\x4e\x02\x54\x02\x6b\x02\x52\x02\x80\x02\x4e\x02\x51\x02\x89\x02\x6c\x02\x4e\x02\x8d\x02", 0, -1);
             GameRun.run_state = -10;
             GameRun.mc.temp_state = GameRun.run_state;
             break;
           case 7:
             goto label_00e4 ;
       }
       SMSSender.gr.saveGame();
       if (this.menu_state != null) {
          this.sendSms = -1;
          if (SMSSender.gr.say_c == null) {
             this.outState();
             GameRun.mc.setSmsIsSetRun_state(1);
             GameRun.run_state = -10;
             GameRun.mc.temp_state = GameRun.run_state;
          }
       }else {
          this.sendSms = -1;
          Sound.i().setMusic(0);
       }
       this.sendSms = -1;
       GameRun.run_state = -10;
       GameRun.mc.temp_state = GameRun.run_state;
       return;
    }
    public void setSendSms(int value){
       this.sendSms = (byte)value;
    }
    public void setSmsType(){
       int WIDTH = 640;
       SMSSender.smsType = (byte)(this.menu[this.menu_state][this.sel[0]] - 1);
    }
    public void setSmsValue(int type){
       switch (SMSSender.smsType){
           case 1:
           case 3:
           case 4:
           case 5:
           case 6:
           case 2:
       }
       return;
    }
}
