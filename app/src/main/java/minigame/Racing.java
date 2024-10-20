package minigame.Racing;
import minigame.MiniGame_H;
import main.GameRun;
import java.lang.Object;
import java.lang.Byte;
import java.lang.Class;
import java.lang.reflect.Array;
import java.lang.Short;
import dm.Ms;
import main.Constants_H;
import dm.Ui;
import java.lang.String;
import java.lang.StringBuffer;
import main.PointerKey;
import dm.Sprite;
import java.lang.StringBuilder;
import javax.microedition.lcdui.Image;

public class Racing implements MiniGame_H	// class@00016f from classes.dex
{
    private final short MAP_HEIGHT;
    private final byte NUM;
    private final short WIN_HEIGHT;
    private short[][] cloud;
    private short[][] gDate;
    GameRun gr;
    private Image imgCloud;
    private byte length;
    private byte lv;
    private short[] monY;
    private short[] money;
    private byte[] myDate;
    private byte[][] now_a;
    private byte sel;
    private Sprite[] sp;
    private byte speedLv;
    private short srcY;
    private byte state;
    private byte time;

    public void Racing(GameRun gr_){
       super();
       this.NUM = 4;
       this.MAP_HEIGHT = 450;
       this.WIN_HEIGHT = 70;
       int[] ointArray = new int[]{4,3};
       this.now_a = Array.newInstance(Byte.TYPE, ointArray);
       byte[] uobyteArray = new byte[4];
       uobyteArray[3] = -1;
       this.myDate = uobyteArray;
       ointArray = new int[]{10,3};
       this.cloud = Array.newInstance(Short.TYPE, ointArray);
       short[] oshortArray = new short[4];
       this.monY = oshortArray;
       this.money = new short[6]{'d','x',300,350,0x3e8,0x4b0};
       short[][] oshortArray1 = new short[][4]{new short[3]{450,3,8},new short[3]{390,4,9},new short[3]{270,7,6},new short[3]{210,6,10}};
       this.gDate = oshortArray1;
       this.gr = gr_;
    }
    private void addCloud(int i){
       Ms.i();
       this.cloud[i][0] = (short)(Ms.getRandom(Constants_H.WIDTH_H) + 640);
       Ms.i();
       this.cloud[i][1] = (short)((this.srcY - 80) + ((Ms.getRandom(25) + 55) * i));
       Ms.i();
       this.cloud[i][2] = (short)(Ms.getRandom(5) + 2);
    }
    private void draw0(int x,int y,int h,int fh){
       int HEIGHT = 360;
       int WIDTH_H = 320;
       Ui.i().fillRectB();
       Ui.i().drawString("\x6e\x02\x62\x02\x89\x02\x52\x02", WIDTH_H, ((y + fh) + 3), 33, 3, 1);
       Ui.i().drawUi(7, (WIDTH_H - 50), ((y + fh) - 13), 40, 0);
       Ui.i().drawUi(7, (WIDTH_H + 50), ((y + fh) - 13), 36, 4);
       int w = 200;
       Ui.i().drawK(x, ((y + fh) + 3), w, h, 4);
       Ui.i().drawK(((x + w) + 10), ((y + fh) + 3), w, h, 4);
       this.gr.showStringM("\x90\x02\x62\x02\x4f\x02\x8b\x02\x4e\x02\x4f\x02\x5f\x02\x7b\x02\x4e\x02\x76\x02\x4e\x02\x53\x02\x5b\x02\x72\x02\x54\x02\x62\x02\x6c\x02\x76\x02\x59\x02\x5c\x02\xff\x02\x6c\x02\x65\x02\x8d\x02\x59\x02\x83\x02\x80\x02\x54\x02\x76\x02\x59\x02\x52\x02\x8d\x02\x4e\x02\x53\x02\xff\x02", (x + 100), ((y + fh) + 15), 7, 0);
       Ui.i().drawK((x + 420), ((y + fh) + 3), w, h, 4);
       Ui.i().drawStringY(this.gr.about_a, ((x + 420) + 25), ((y + fh) + 15), fh, 0, 0);
       if (this.state == null) {
          Ui.i().drawString("\x8b\x02\x90\x02\x62\x02\x62\x02\x6c\x02\x59\x02\x5c\x02\xff\x02", ((x + w) + 10), ((y + fh) + 15), 0, 0, 0);
          int i = 0;
          while (i < this.length) {
             int ix = x + w;
             ix = ix + 10;
             ix = ix + 25;
             int ix1 = ix + 14;
             ix = y + fh;
             ix = ix + 50;
             int ix2 = fh + 16;
             ix2 = ix2 * i;
             int ix3 = ix + ix2;
             int ix4 = fh + 4;
             Ui.i().drawK(ix1, ix3, 150, ix4, 1);
             ix = x + w;
             ix = ix + 10;
             ix = ix + 25;
             ix3 = ix + 14;
             ix = y + fh;
             ix = ix + 50;
             ix2 = fh + 16;
             ix2 = ix2 * i;
             int ix5 = ix + ix2;
             Ui.i().drawString(this.gr.about_b[i].toString(), ix3, ix5, 0, 3, 0);
             ix2 = x + w;
             ix2 = ix2 + 10;
             ix2 = ix2 + 25;
             ix2 = ix2 + 14;
             int ix6 = y + fh;
             ix6 = ix6 + 50;
             int ix7 = fh + 16;
             ix7 = ix7 * i;
             ix6 = ix6 + ix7;
             int ix8 = fh + 4;
             if (this.gr.pkey.isSelect(ix2, ix6, 150, ix8)) {
                if (this.sel == i) {
                   this.gr.pkey.setKey5();
                }else {
                   this.sel = (byte)i;
                }
             }
             i++;
          }
          Ui.i().drawK4(((((x + w) + 10) + 25) + 14), (((y + fh) + 50) + (this.sel * (fh + 16))), 150, (fh + 4));
       }
       this.gr.drawMoney(WIDTH_H, HEIGHT, 3, 0);
       WIDTH_H = 1;
       Ui.i().drawYesNo(true, WIDTH_H);
       return;
    }
    private void draw1(int x,int y,int h){
       byte t;
       Ui ui;
       int b;
       int ix;
       int ix1;
       int ix2;
       boolean b1;
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       Ui.i().drawK(215, 33, 210, 325, 4);
       byte i = 0;
       while (i < this.length) {
          ix = x + 25;
          b = i * 52;
          ix = ix + b;
          b = y + 25;
          b = b + 10;
          Ui.i().drawK(ix, b, 44, h, 1);
          ui = Ui.i();
          object oobject = this.sp[0];
          b = 0;
          ix1 = x + 25;
          int ix3 = i * 52;
          ix1 = ix1 + ix3;
          ix1 = ix1 + 22;
          ix3 = y + 25;
          ix3 = ix3 + 8;
          ix3 = ix3 + h;
          object oobject1 = this.now_a[i];
          int ix4 = 0;
          if (this.state == 1) {
             b1 = (this.sel == i)? true: false;
          }else {
             b1 = false;
          }
          ui.drawActionOne(oobject, b, ix1, ix3, oobject1, ix4, b1);
          b = i + 1;
          b = x + 25;
          ix1 = i * 52;
          b = b + ix1;
          b = b + 27;
          ix1 = y + 50;
          ix1 = ix1 + 12;
          Ui.i().drawNum("".append(b).toString(), b, ix1, 20, 2);
          ix2 = i + 1;
          i = (byte)ix2;
       }
       if (this.state == 1) {
          Ui.i().drawK4(((x + 25) + (this.sel * 52)), ((y + 25) + 10), 44, 76);
          Ui.i().drawTriangle(WIDTH_H, ((y + 25) + 49), 116, true, true);
          if ((t = this.gr.pkey.selectMenuX(4, (WIDTH_H - 116), ((y + 25) + 10), 52, h)) != -1) {
             if (this.sel == t) {
                this.gr.pkey.setKey5();
             }else {
                this.sel = t;
             }
          }
       }
       Ui.i().drawString("\x51\x02\x59\x02\x5e\x02\xff\x02", (x + 25), (((y + 25) + 13) + h), 0, 0, 0);
       this.gr.drawFealty(6, 2, (x + 125), (((y + 25) + 19) + h));
       this.gr.showStringM("\x6b\x02\x55\x02\x4e\x02\x4e\x02\x51\x02\x59\x02\x83\x02\x82\x02\x8d\x0210\x91\x02\xff\x02\x53\x02\x58\x02\x52\x02\x4e\x02\x68\x02\x51\x02\x59\x02\x5e\x02\x30\x02", WIDTH_H, (((y + 50) + 19) + h), 8, 0);
       h = ((h + 69) + 25) + 75;
       Ui.i().drawString("\x8b\x02\x90\x02\x62\x02\x90\x02\x51\x02\xff\x02", (x + 25), (y + h), 0, 0, 0);
       h = (h + 25) + 3;
       i = 0;
       while (i < this.length) {
          ix = x + 25;
          b = i * 52;
          ix = ix + b;
          b = y + h;
          Ui.i().drawK(ix, b, 44, 34, 1);
          b = x + 25;
          ix1 = i * 52;
          b = b + ix1;
          ix1 = y + h;
          ix1 = ix1 + 10;
          this.gr.drawItem(12, b, ix1, 0);
          b = x + 25;
          ix1 = i * 52;
          b = b + ix1;
          b = b + 16;
          ix1 = y + h;
          ix1 = ix1 + 8;
          Ui.i().drawString("x".append(i).toString(), b, ix1, 0, 3, 1);
          ix2 = i + 1;
          i = (byte)ix2;
       }
       if (this.state == 2) {
          Ui.i().drawK4(((x + 25) + (this.sel * 52)), (y + h), 44, 34);
          Ui.i().drawTriangle(WIDTH_H, ((y + h) + 14), 116, true, true);
          if ((t = this.gr.pkey.selectMenuX(4, (WIDTH_H - 116), ((y + h) + 8), 52, 34)) != -1) {
             if (this.sel == t) {
                this.gr.pkey.setKey5();
             }else {
                this.sel = t;
             }
          }
       }
       ui = Ui.i();
       b = (this.state != 1)? true: false;
       ui.drawYesNo(true, b);
       return;
    }
    private void drawCloud(){
       int ix;
       byte i = 0;
       while (i < this.cloud.length) {
          int ix2 = this.cloud[i][1] - this.srcY;
          Ui.i().drawImage(this.imgCloud, this.cloud[i][0], ix2, 0);
          ix = i + 1;
          i = (byte)ix;
       }
       i = 0;
       while (i < this.cloud.length) {
          if (this.isNpcSrc(this.cloud[i][0], this.cloud[i][1])) {
             this.addCloud(i);
          }else {
             object oobject = this.cloud[i];
             int ix1 = oobject[0] - this.cloud[i][2];
             oobject[0] = (short)ix1;
          }
          ix = i + 1;
          i = (byte)ix;
       }
       return;
    }
    private void drawEnd(){
       int WIDTH = 640;
       int n = ((WIDTH - 70) / 35) + 1;
       Ui.i().drawModuleOne(this.sp[1], 0, 0, (40 - this.srcY), 0, 0);
       for (int i = 0; i < n; i++) {
          int ix = i * 35;
          int ix1 = ix + 35;
          int ix2 = 44 - this.srcY;
          Ui.i().drawModuleOne(this.sp[1], 1, ix1, ix2, 0, 0);
       }
       Ui.i().drawModuleOne(this.sp[1], 0, WIDTH, (40 - this.srcY), 1, 0);
       return;
    }
    private void drawGame(){
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       Ui.i().fillRect(0x52c0ff, 0, 0, WIDTH, HEIGHT);
       this.drawCloud();
       this.drawEnd();
       byte i = 0;
       while (i < this.length) {
          int ix = i + 1;
          int ix1 = i * 100;
          ix1 = ix1 + 125;
          int ix2 = ix1 + 22;
          int ix3 = 20 - this.srcY;
          Ui.i().drawNum("".append(ix).toString(), ix2, ix3, 1, 2);
          ix1 = i * 100;
          ix1 = ix1 + 125;
          ix3 = ix1 + 22;
          ix2 = this.monY[i] - this.srcY;
          Ui.i().drawActionOne(this.sp[0], 1, ix3, ix2, this.now_a[i], 0, true);
          ix1 = i + 1;
          i = (byte)ix1;
       }
       if (this.state == 3 && this.time != null) {
          Ui.i().drawNum((this.time / 20), (WIDTH_H - 5), HEIGHT_H, 0, 2);
       }
       return;
    }
    private boolean isNpcSrc(int ax,int ay){
       boolean b = (ax >= -40 && ((ay - this.srcY)) <= (Constants_H.HEIGHT + 20))? false: true;
       return b;
    }
    private void nullGame(){
       this.sp = null;
       this.myDate = null;
       this.money = null;
       this.now_a = null;
       this.monY = null;
       this.imgCloud = null;
       this.cloud = null;
       this.gDate = null;
    }
    private void setSpeed(){
       int ix1;
       if (this.speedLv < this.gDate.length) {
          byte i = 0;
          while (i < 4 && this.monY[i] > this.gDate[this.speedLv][0]) {
             ix1 = i + 1;
             i = (byte)ix1;
          }
          if (i < 4) {
             i = 0;
             while (i < 4) {
                Ms.i();
                int ix = Ms.getRandom(this.gDate[this.speedLv][1]) + this.gDate[this.speedLv][1];
                this.now_a[i][2] = (byte)ix;
                ix1 = i + 1;
                i = (byte)ix1;
             }
             this.speedLv = (byte)(this.speedLv + 1);
          }
       }
       return;
    }
    public void go(int mode){
       int ix;
       byte b = 3;
       if (mode < 1) {
          this.sel = 0;
          this.state = 0;
          this.length = b;
          this.gr.setStringB("\x4e\x02\x6c\x02\xff\x02#n\x62\x02\x51\x02100\x91\x02\xff\x02#n\x83\x02\x80\x02\x5f\x02120\x91\x02\x30\x02#n\x4e\x02\x6c\x02\xff\x02#n\x62\x02\x51\x02300\x91\x02\xff\x02#n\x83\x02\x80\x02\x5f\x02350\x91\x02\x30\x02#n\x4e\x02\x6c\x02\xff\x02#n\x62\x02\x51\x021000\x91\x02\xff\x02#n\x83\x02\x80\x02\x5f\x021200\x91\x02\x30\x02", (Constants_H.WIDTH - 50), 0);
          this.gr.setStringB("\x4e\x02\x6c\x02100\x91\x02#n\x4e\x02\x6c\x02300\x91\x02#n\x4e\x02\x6c\x021000\x91\x02", (Constants_H.WIDTH - 50), 1);
       }else if(mode == 1){
          this.myDate[0] = this.sel;
          this.sel = 0;
          this.state = 1;
          this.length = 4;
       }else if(mode == 2){
          this.myDate[1] = this.sel;
          this.sel = 0;
          this.state = 2;
       }else if(mode == b){
          this.myDate[2] = this.sel;
          this.sel = 0;
          this.state = b;
          this.srcY = 90;
          this.speedLv = 0;
          this.myDate[b] = -1;
          this.time = 70;
          byte i = 0;
          while (i < this.length) {
             this.monY[i] = 450;
             ix = i + 1;
             i = (byte)ix;
          }
          i = 0;
          while (i < this.cloud.length) {
             this.addCloud(i);
             ix = i + 1;
             i = (byte)ix;
          }
       }
       return;
    }
    public void go(int mode,int lv_){
       this.lv = (byte)lv_;
       Sprite[] spriteArray = new Sprite[3];
       this.sp = spriteArray;
       this.sp[0] = Ms.i().createSprite("data/npc0/67", true);
       this.sp[1] = Ms.i().createSprite("data/brow/m1", true);
       this.imgCloud = Ms.i().createImage("data/cloud");
       this.go(mode);
    }
    public boolean key(){
       boolean b;
       int i = 2;
       if (Ms.i().key_delay()) {
          b = false;
       }else if(this.state == null){
          if (Ms.i().key_Up_Down()) {
             this.sel = Ms.i().select(this.sel, 0, (this.length - 1));
          }else if(Ms.i().key_S1_Num5() && this.gr.isMoney(this.money[(this.sel << 1)], 1)){
             this.go(1);
          }else if(Ms.i().key_S2()){
             this.nullGame();
             b = 1;
          }
       }else if(this.state == 1){
          if (Ms.i().key_Left_Right()) {
             this.sel = Ms.i().select(this.sel, 0, (this.length - 1));
          }else if(Ms.i().key_S1_Num5()){
             this.go(i);
          }
       }else if(this.state == i){
          if (Ms.i().key_Left_Right()) {
             this.sel = Ms.i().select(this.sel, 0, (this.length - 1));
          }else if(Ms.i().key_S1_Num5() && this.gr.isMoney((this.sel * 10), 1)){
             this.go(3);
          }else if(Ms.i().key_S2()){
             this.sel = this.myDate[1];
             this.state = 1;
          }
       }
       b = 0;
       return b;
    }
    public void patin(){
       if (this.state != null && (this.state != 1 && this.state != 2)) {
          this.drawGame();
       }else {
          this.draw0(10, 5, 325, 25);
          if (this.state == 1 || this.state == 2) {
             this.draw1(198, 15, 76);
          }
       }
       return;
    }
    public void run(){
       Racing tmonY;
       int ix1;
       if (this.state == 3) {
          if (this.time == null) {
             this.setSpeed();
             if (this.myDate[3] != -1) {
                this.time = 5;
                this.state = 4;
             }else {
                byte j = -1;
                byte i = 0;
                while (i < 4) {
                   tmonY = this.monY;
                   int ix = tmonY[i] - this.now_a[i][2];
                   tmonY[i] = (short)ix;
                   if ((ix1 = this.monY[i] - this.srcY) < Constants_H.HEIGHT_H) {
                      j = i;
                   }
                   if (this.monY[i] < 70 && this.myDate[3] == -1) {
                      this.myDate[3] = i;
                   }
                   ix1 = i + 1;
                   i = (byte)ix1;
                }
                if (j != -1) {
                   this.srcY = (short)(this.srcY - this.now_a[j][2]);
                }
                if (this.srcY < null) {
                   this.srcY = 0;
                }
             }
          }else {
             this.time = (byte)(this.time - 1);
          }
       }else if(this.state == 4){
          if (this.time == 3) {
             if (this.myDate[3] == this.myDate[1]) {
                tmonY = this.gr;
                tmonY.money = tmonY.money + this.money[((this.myDate[0] * 2) + 1)];
                this.gr.say("\x83\x02\x5f\x02\xff\x02"+this.money[((this.myDate[0] * 2) + 1)]+"\x91\x02", 0);
                GameRun rmsOther = this.gr.rmsOther;
                rmsOther[4] = (byte)(rmsOther[4] | (1 << this.lv));
             }else {
                this.gr.say("\x4e\x02\x59\x02\x61\x02\x60\x02\xff\x02\x6c\x02\x67\x02\x73\x02\x5b\x02\x30\x02", 0);
             }
          }
          if (this.time > null) {
             this.time = (byte)(this.time - 1);
          }else if(this.time == null && this.gr.say_c == null){
             this.go(0);
          }
       }
       return;
    }
}
