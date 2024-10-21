package minigame.Bearer;
import minigame.MiniGame_H;
import main.GameRun;
import java.lang.Object;
import java.lang.Short;
import java.lang.Class;
import java.lang.reflect.Array;
import dm.Ms;
import dm.Ui;
import java.lang.String;
import java.lang.StringBuffer;
import java.lang.StringBuilder;
import java.lang.System;
import java.io.PrintStream;
import main.PointerKey;
import dm.Sprite;
import javax.microedition.lcdui.Image;
import main.Constants_H;

public class Bearer implements MiniGame_H	// class@00016a from classes.dex
{
    private final byte SPEED;
    private short ballC0;
    private short ballC1;
    private short[][] ballDate;
    private byte[] ball_time;
    private Sprite bsp;
    private short count;
    private byte cur;
    private short[][] gDate;
    GameRun gr;
    private Image img;
    private byte length;
    private byte lv;
    private short[] money;
    private short[] myxy;
    byte sel;
    private Sprite[] sp;
    private byte state;
    private short time0;
    private short time1;
    private short[][] xy;

    public void Bearer(GameRun gr_){
       super();
       short[][] oshortArray = new short[][4]{new short[10]{9,1,10,2,11,4,27,8,2,0xfff6},new short[4]{'2','d',150,200},new short[4]{'<','(',30,10},new short[8]{8,6,13,3,20,5,30,10}};
       this.gDate = oshortArray;
       oshortArray = new short[][3]{new short[5]{10,20,'<',10,220},new short[5]{13,'(','<',12,170},new short[5]{10,'(','<',10,'x'}};
       this.ballDate = oshortArray;
       this.money = new short[4]{150,200,300,450};
       int[] ointArray = new int[]{40,7};
       this.xy = Array.newInstance(Short.TYPE, ointArray);
       short[] oshortArray1 = new short[5];
       oshortArray1[1] = 275;
       oshortArray1[2] = 67;
       oshortArray1[3] = 10;
       this.myxy = oshortArray1;
       this.ball_time = new byte[4]{0x14,0x0f,0x0a,0x05};
       this.SPEED = 10;
       this.gr = gr_;
    }
    private void addBall(int id){
       this.xy[this.cur][0] = -20;
       this.xy[this.cur][1] = this.ballDate[id][4];
       this.xy[this.cur][2] = (short)(this.ballDate[id][1] / this.ballDate[id][0]);
       this.xy[this.cur][4] = this.ballDate[id][0];
       this.xy[this.cur][5] = (short)id;
       this.xy[this.cur][3] = this.ballDate[id][3];
       Ms.i();
       this.xy[this.cur][6] = (short)Ms.getRandom((this.gDate[0].length >> 1));
       byte b = (byte)(this.cur + 1);
       this.cur = b;
       if (b >= this.xy.length) {
          this.cur = 0;
       }
       return;
    }
    private void draw0(int x,int y,int h){
       Ui ui;
       String str;
       int ix;
       int ix1;
       int ix2;
       int ix5;
       int ix6;
       int ix7;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       h = h + 45;
       Ui.i().fillRectB();
       int w = 200;
       Ui.i().drawK(x, ((y + 25) + 5), (w - 10), h, 4);
       Ui.i().drawK(((x + w) + 10), ((y + 25) + 5), w, h, 4);
       Ui.i().drawK(((x + 420) + 10), ((y + 25) + 5), (w - 10), h, 4);
       Ui.i().drawString("\x6e\x02\x62\x02\x89\x02\x52\x02", WIDTH_H, ((y + 25) + 5), 33, 3, 1);
       Ui.i().drawUi(7, ((WIDTH_H - 50) - 5), ((y + 25) - 4), 40, 0);
       Ui.i().drawUi(7, ((WIDTH_H + 50) + 5), ((y + 25) - 4), 36, 4);
       Ui.i().drawStringY(this.gr.about_a, 25, ((y + 75) + 10), 25, 0, 0);
       int ty = y + 100;
       Ui.i().drawString("\x74\x02\x76\x02\x52\x02\x65\x02\xff\x02", ((x + 420) + 20), ty, 0, 0, 0);
       ty = ty + 50;
       for (int i = 0; i < this.gDate[0].length; i = i + 2) {
          Bearer uBearer = this.gr;
          ix5 = this.gDate[0][i];
          ix7 = w + 10;
          ix6 = ix7 * 2;
          int ix8 = x + 420;
          ix8 = ix8 + 25;
          ix7 = ((ix7 = i % 4) == 2)? 100: 0;
          ix8 = ix8 + ix7;
          ix7 = i >> 2;
          ix7 = ix7 * 30;
          ix7 = ix7 + ty;
          uBearer.drawItem(ix5, ix8, ix7, 0);
          ui = Ui.i();
          ix6 = i + 1;
          String str1 = (this.gDate[0][ix6] < 0)? "": "+";
          ix6 = i + 1;
          str = String.valueOf(str1).append(this.gDate[0][ix6]).toString();
          ix = w + 10;
          ix = ix * 2;
          ix8 = x + 420;
          ix8 = ix8 + 25;
          ix5 = ((ix5 = i % 4) == 2)? 100: 0;
          ix8 = ix8 + ix5;
          ix1 = ix8 + 16;
          ix8 = i >> 2;
          ix8 = ix8 * 30;
          ix8 = ix8 + ty;
          ix2 = ix8 - 4;
          ui.drawString(str, ix1, ix2, 0, 0, 1);
       }
       ty = ty - 50;
       Ui.i().drawListKY(2, (((x + w) + 12) + 25), ty, (w - 50), 3, 30, 10, this.sel, 4, 2);
       i = 0;
       while (i < this.gr.about_b.length) {
          System.out.println("i   ".append(i).toString());
          ui = Ui.i();
          str = this.gr.about_b[i].toString();
          ix = x + w;
          ix = ix + 15;
          ix = ix + 25;
          ix1 = ix + 26;
          ix = i * 40;
          ix = ix + ty;
          ix2 = ix - 2;
          int ix3 = 0;
          int ix4 = (this.sel == i)? 0: 3;
          ui.drawString(str, ix1, ix2, ix3, ix4, 1);
          ix5 = x + w;
          ix5 = ix5 + 12;
          ix5 = ix5 + 25;
          ix6 = i * 40;
          ix6 = ix6 + ty;
          ix6 = ix6 - 2;
          ix7 = w - 50;
          if (this.gr.pkey.isSelect(ix5, ix6, ix7, 40)) {
             System.out.println("asdfasfaf");
             if (this.sel == i) {
                this.gr.pkey.setKey5();
             }else {
                this.sel = (byte)i;
             }
          }
          i++;
       }
       this.gr.showStringM("\x97\x02\x89\x02\x76\x02\x53\x02\x52\x02\x8d\x02\xff\x02"+this.money[this.lv]+"\x91\x02", WIDTH_H, ((y + h) - 50), 7, 0);
       this.gr.drawMoney(WIDTH_H, HEIGHT, 3, false);
       if (this.state == null) {
          Ui.i().drawYesNo(true, true);
       }
       return;
    }
    private void drawGame(int x,int y,int w,int h){
       int ix;
       int ix1;
       int ix3;
       Ui.i().fillRect(0x52c0ff, x, y, w, h);
       Ui.i().drawFrameOne(this.bsp, false, (x + (w >> 1)), (y + (h >> 1)), false);
       Ui.i().drawString("\x52\x02\x65\x02\xff\x02"+this.count, (((w >> 1) + x) - 25), y, 24, 3, 1);
       Ui.i().drawString("\x74\x02\x60\x02\x65\x02\xff\x02"+this.ballC0, (((w >> 1) + x) + 25), y, 20, 3, 1);
       Ui.i().drawImage(this.img, (x + w), (h - 15), 40);
       byte i = 0;
       while (i < this.xy.length) {
          if (this.xy[i][5] != -1) {
             ix = this.xy[i][6] << 1;
             ix = this.xy[i][0] + x;
             ix1 = this.xy[i][1] + y;
             this.gr.drawItem(this.gDate[0][ix], ix, ix1, false);
          }
          ix3 = i + 1;
          i = (byte)ix3;
       }
       i = 0;
       while (i < 2) {
          Ui ui = Ui.i();
          object oobject = this.sp[0];
          ix = (!this.myxy[4])? 3: 4;
          ix1 = this.myxy[0] + x;
          int ix2 = i * 30;
          ix1 = ix1 + ix2;
          ix1 = ix1 + 20;
          ix2 = this.myxy[1] + y;
          ix2 = ix2 + 25;
          ui.drawFrameOne(oobject, ix, ix1, ix2, false);
          ix3 = i + 1;
          i = (byte)ix3;
       }
       this.gr.drawMoney(320, 360, 3, false);
       return;
    }
    private void getAY(int i){
       object oobject;
       int ix = 4;
       if (this.xy[i][ix] > 0 && this.xy[i][3] > 1) {
          oobject = this.xy[i];
          oobject[3] = (short)(oobject[3] - 1);
       }else if(!this.xy[i][ix]){
          this.xy[i][3] = 0;
       }else if(this.xy[i][ix] < 0 && this.xy[i][3] > (- this.ballDate[this.xy[i][5]][3])){
          oobject = this.xy[i];
          oobject[3] = (short)(oobject[3] - 1);
       }
       return;
    }
    private void initABall(boolean mode){
       int i = 3;
       short s = (mode)? 10: this.gDate[2][this.lv];
       this.time0 = s;
       this.time1 = this.ball_time[this.lv];
       Ms.i();
       this.ballC1 = (short)(Ms.getRandom(this.gDate[i][(this.lv << 1)]) + this.gDate[i][((this.lv << 1) + 1)]);
       return;
    }
    private boolean isCollision(int i){
       boolean bb = Ms.i().isRect(this.myxy[0], this.myxy[1], this.myxy[2], this.myxy[3], this.xy[i][0], this.xy[i][1], 16, 16);
       return bb;
    }
    private boolean isSrc(int i){
       int w = 240;
       int h = 320;
       boolean bb = (this.xy[i][1] > (h + 10))? true: 0;
       if (Ms.i().isRect((w - 10), (h - 40), 20, 10, this.xy[i][0], this.xy[i][1], 16, 16) || (this.xy[i][0] > w || this.xy[i][1] >= this.myxy[1])) {
          bb = true;
          this.count = (short)(this.count + this.gDate[0][((this.xy[i][6] * 2) + 1)]);
       }
       return bb;
    }
    private void nullGame(){
       this.gDate = null;
       this.money = null;
       this.sp = null;
       this.img = null;
       this.ballDate = null;
    }
    public void go(int mode){
       if (mode < 1) {
          this.state = 0;
          this.length = 10;
          this.gr.setStringB("\x57\x02\x96\x02\x5b\x02\x65\x02\x95\x02\x91\x02\x63\x02\x5c\x02\x91\x02\x59\x02\x76\x02\x74\x02\x52\x02\x68\x02\x91\x02\xff\x02\x67\x02\x54\x02\x68\x02\x63\x02\x68\x02\x91\x02\x74\x02\x76\x02\x52\x02\x65\x02\x67\x02\x63\x02\x53\x02\x91\x02\x94\x02\x30\x02", 160, 0);
          this.gr.setStringB("\x5f\x02\x59\x02\x6e\x02\x62\x02#n\x79\x02\x5f\x02\x6e\x02\x62\x02", Constants_H.WIDTH, 1);
       }else if(mode == 1){
          this.state = 1;
          this.count = 0;
          this.cur = 0;
          this.ballC0 = this.gDate[1][this.lv];
          this.initABall(1);
          byte i = 0;
          while (i < this.xy.length) {
             this.xy[i][5] = -1;
             int ix = i + 1;
             i = (byte)ix;
          }
       }
       return;
    }
    public void go(int mode,int lv_){
       this.lv = (byte)lv_;
       Sprite[] spriteArray = new Sprite[2];
       this.sp = spriteArray;
       this.sp[0] = Ms.i().createSprite("data/npc2/38", true);
       this.img = Ms.i().createImage("data/brow/m0");
       byte[] date = Ms.i().getStream("data/gamee.data", -1);
       Ms.i();
       Ms.skip = 0;
       this.bsp = Sprite.Create(Ms.i().createImage("data/map/5"), Ms.i().createShort2Array(date, 2), Ms.i().createShort3Array(date, 2), Ms.i().createShort3Array(date, 2));
       this.go(mode);
    }
    public boolean key(){
       boolean b;
       Bearer tmyxy;
       if (this.state == null) {
          if (Ms.i().key_Up_Down()) {
             this.sel = (byte)(this.sel ^ 0x01);
          }else if(Ms.i().key_S1_Num5()){
             Ms.i().keyRelease();
             if (this.sel == null && this.gr.isMoney(this.money[this.lv], true)) {
                this.go(true);
             }else if(this.sel == true){
                Ms.i().keyRelease();
                this.nullGame();
                b = true;
             label_0019 :
                return b;
             }
          }else if(Ms.i().key_S2()){
             this.nullGame();
             b = true;
             goto label_0019 ;
          }
       }else if(this.state == true){
          if (Ms.i().key_Left()) {
             tmyxy = this.myxy;
             if ((tmyxy[0] = (short)(tmyxy[0] - 10)) < 0) {
                this.myxy[0] = 0;
             }
          }else if(Ms.i().key_Right()){
             tmyxy = this.myxy;
             if (((tmyxy[0] = (short)(tmyxy[0] + 10))) > 220) {
                this.myxy[0] = (short)((240 - this.myxy[2]) - 20);
             }
          }
       }
       b = false;
       goto label_0019 ;
    }
    public void patin(){
       this.draw0(10, 2, (this.length * 25));
       if (this.state != null) {
          this.drawGame(200, 0, 240, 320);
       }
       return;
    }
    public void run(){
       Bearer tmyxy;
       if (this.state == 1) {
          if (this.ballC0 > null) {
             if (this.time0 > null) {
                this.time0 = (short)(this.time0 - 1);
             }else if(this.time1 > null){
                this.time1 = (short)(this.time1 - 1);
             }else if(this.ballC1 > null){
                this.time1 = this.ball_time[this.lv];
                this.addBall(Ms.getRandom(this.ballDate.length));
                this.ballC1 = (short)(this.ballC1 - 1);
                this.ballC0 = (short)(this.ballC0 - 1);
             }else if(this.ballC1 == null){
                this.initABall(0);
             }
          }
          if (this.myxy[4] > 0) {
             tmyxy = this.myxy;
             tmyxy[4] = (short)(tmyxy[4] - 1);
          }
          boolean bb = true;
          byte i = 0;
          while (i < this.xy.length) {
             if (this.xy[i][5] != -1) {
                bb = false;
                object oobject = this.xy[i];
                int ix1 = oobject[0] + this.xy[i][2];
                oobject[0] = (short)ix1;
                oobject = this.xy[i];
                ix1 = oobject[1] - this.xy[i][3];
                oobject[1] = (short)ix1;
                this.getAY(i);
                oobject = this.xy[i];
                ix1 = oobject[4] - 1;
                if (oobject[4] = (short)ix1) {
                   this.xy[i][5] = -1;
                }else if(this.isCollision(i)){
                   this.xy[i][4] = this.ballDate[this.xy[i][5]][0];
                   this.myxy[4] = 1;
                   this.xy[i][3] = this.ballDate[this.xy[i][5]][3];
                }
             }
             int ix = i + 1;
             i = (byte)ix;
          }
          if (this.ballC0 < 1 && bb) {
             this.count = (short)((this.count * 15) / 10);
             tmyxy = this.gr;
             tmyxy.money = tmyxy.money + this.count;
             this.gr.say("\x83\x02\x5f\x02\xff\x02"+this.count+"\x91\x02", 0);
             if (this.count > null) {
                GameRun rmsOther = this.gr.rmsOther;
                rmsOther[6] = (byte)(rmsOther[6] | (1 << this.lv));
             }
             this.state = 2;
          }
          this.gr.pkey.checkButton(4);
       }else if(this.state == 2 && this.gr.say_c == null){
          this.go(0);
       }
       return;
    }
    public void setLv(int lv_){
       this.lv = (byte)lv_;
    }
}
