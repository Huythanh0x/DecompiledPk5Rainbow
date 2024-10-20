package minigame.Guess;
import minigame.MiniGame_H;
import main.GameRun;
import java.lang.Object;
import dm.Ui;
import java.lang.String;
import java.lang.StringBuffer;
import java.lang.StringBuilder;
import main.PointerKey;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import dm.Sprite;
import dm.Ms;
import main.Constants_H;
import java.lang.Integer;
import java.lang.Class;
import java.lang.reflect.Array;
import java.lang.System;

public class Guess implements MiniGame_H	// class@00016c from classes.dex
{
    final short BOX_Y1;
    final short MON_Y;
    final short TIME;
    final short TIME2;
    private byte b_win;
    private int[][] box;
    private byte[] boxNum;
    private byte[][] gameData;
    private byte gameR;
    GameRun gr;
    private Image[] imgBox;
    private Sprite[] imgMon;
    private byte length;
    private byte lv;
    private byte maxTransNum;
    private byte mon_size_move;
    byte sel;
    private int sell_money;
    private byte state;
    private byte tempTransNum;
    private byte time;
    private byte transNum;
    private byte winNum;

    public void Guess(GameRun gr_){
       super();
       this.TIME = 20;
       this.TIME2 = 40;
       this.BOX_Y1 = 150;
       this.MON_Y = 165;
       this.mon_size_move = 0;
       this.state = 0;
       this.gameR = 0;
       this.winNum = 0;
       this.transNum = 0;
       this.maxTransNum = 20;
       this.tempTransNum = 0;
       this.gr = gr_;
    }
    private void draw(){
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       if (this.state == null) {
          Ui.i().drawString("\x6e\x02\x62\x02\x89\x02\x52\x02", WIDTH_H, 4, 17, 3, 1);
          Ui.i().drawUi(7, (WIDTH_H - 75), 27, 40, 0);
          Ui.i().drawUi(7, (WIDTH_H + 75), 27, 36, 4);
       }
       int x = 10;
       int y = 25;
       int w = 200;
       int fh = 29;
       int h = fh * 10;
       Ui.i().drawK(x, (y + 10), w, h, 4);
       Ui.i().drawK(((x + w) + 10), (y + 10), w, h, 4);
       Ui.i().drawK((x + 420), (y + 10), w, h, 4);
       Ui.i().drawStringY(this.gr.about_a, (x + 6), (y + 10), fh, 0, 0);
       if (this.state == null) {
          this.gr.showStringM("\x97\x02\x89\x02\x76\x02\x53\x02\x52\x02\x8d\x02\xff\x02"+this.sell_money+"\x91\x02", WIDTH_H, ((y + 290) - 50), 7, 0);
          int ty = (y + 75) + 5;
          Ui.i().drawListKY(2, (((x + w) + 12) + 25), ty, (w - 50), 3, 30, 10, this.sel, 4, 2);
          int i = 0;
          while (i < this.gr.about_b.length) {
             Ui ui = Ui.i();
             String str = this.gr.about_b[i].toString();
             int ix = x + w;
             ix = ix + 15;
             ix = ix + 25;
             int ix1 = ix + 26;
             ix = i * 40;
             ix = ix + 105;
             int ix2 = ix - 2;
             int ix3 = (this.sel == i)? 0: 3;
             ui.drawString(str, ix1, ix2, 0, ix3, 1);
             int ix4 = x + w;
             ix4 = ix4 + 12;
             ix4 = ix4 + 25;
             int ix5 = i * 40;
             ix5 = ix5 + 105;
             ix5 = ix5 - 2;
             int ix6 = w - 50;
             if (this.gr.pkey.isSelect(ix4, ix5, ix6, 40)) {
                if (this.sel == i) {
                   this.gr.pkey.setKey5();
                }else {
                   this.sel = (byte)i;
                }
             }
             i++;
          }
       }
       if (this.state == null) {
          Ui.i().drawYesNo(true, true);
       }
       this.gr.drawMoney(WIDTH_H, HEIGHT, 3, 0);
       return;
    }
    private void drawGame(){
       int i;
       byte ix;
       int ix1;
       Guess WIDTH_H1;
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int width = 240;
       int height = 320;
       int x = 202;
       int y = 32;
       int w = width - 4;
       int h = height - 4;
       int fh = 29;
       Ui.i().drawString("\x80\x02\x52\x02\x6b\x02\x65\x02\xff\x02"+this.winNum+"/"+this.gameData[3][this.lv], WIDTH_H, 4, 17, 3, 1);
       if (this.state == 1) {
          WIDTH_H = 100;
          Ui.g.setClip(x, 65, width, WIDTH_H);
          i = 0;
          while (i < this.box.length) {
             if (this.box[i][1] != -1) {
                ix = this.box[i][1];
                ix1 = this.box[i][2] + x;
                WIDTH_H = (this.time < 40)? 0: this.mon_size_move;
                WIDTH_H = WIDTH_H + 165;
                this.drawMon(i, ix, ix1, WIDTH_H);
             }
             i++;
          }
          Ui.g.setClip(0, 0, WIDTH, HEIGHT);
          if (this.time >= 20) {
             i = 0;
             while (i < this.box.length) {
                WIDTH_H = this.box[i][2] + x;
                Ui.i().drawImage(this.imgBox[1], WIDTH_H, this.box[i][3], 17);
                i++;
             }
          }
       }else if(this.state == 2){
          i = 0;
          while (i < this.box.length) {
             WIDTH_H = this.box[i][2] + x;
             Ui.i().drawImage(this.imgBox[1], WIDTH_H, this.box[i][3], 17);
             i++;
          }
       }else if(this.state == 3){
          i = 0;
          while (i < this.box.length) {
             ix1 = this.box[i][2] + x;
             ix1 = ix1 - 20;
             if (this.gr.pkey.isSelect(ix1, this.box[i][3], 40, 40)) {
                this.gr.selectx = (byte)i;
                this.gr.pkey.setKey5();
             }
             WIDTH_H = this.box[i][2] + x;
             Ui.i().drawImage(this.imgBox[1], WIDTH_H, this.box[i][3], 17);
             i++;
          }
          Ui ui = Ui.i();
          object oobject = this.imgBox[0];
          WIDTH_H = (this.box[this.gr.selectx][2] + x) - 1;
          int ix2 = this.box[this.gr.selectx][3];
          int ix3 = (((this.time % 4)) <= 2)? 5: 0;
          ui.drawImage(oobject, WIDTH_H, (ix2 - ix3), 17);
          ix = (byte)(this.time + 1);
          this.time = ix;
          if (ix > 20) {
             this.time = 0;
          }
          this.drawMon(this.box[this.gr.selecty][0], this.box[this.gr.selecty][1], ((this.gameData[0][1] + x) + 100), 135);
          this.gr.showStringM("\x8b\x02\x63\x02\x51\x02"+this.gr.getNameMon(this.box[this.gr.selecty][1])+"\x62\x02\x57\x02\x7b\x02\x5b\x02", ((x + width) + 90), (fh * 5), 6, 0);
       }else if(this.state == 4){
          WIDTH_H = this.gr;
          this.drawMon(this.box[this.gr.selecty][0], this.box[WIDTH_H.selecty][1], ((this.gameData[0][1] + x) + 100), 135);
          Ui.i().drawImage(this.imgBox[1], (this.box[this.gr.selectx][2] + x), this.box[this.gr.selectx][3], 17);
          if (this.box[this.gr.selectx][1] != -1) {
             this.drawMon(this.box[this.gr.selectx][0], this.box[this.gr.selectx][1], (this.box[this.gr.selectx][2] + x), (this.box[this.gr.selectx][3] + 35));
          }
          if (this.b_win > null) {
             this.gr.showStringM("\x60\x02\x77\x02\x53\x02\x5b\x02\xff\x02", ((x + width) + 90), (fh * 5), 6, 0);
          }else {
             this.gr.showStringM("\x8b\x02\x4e\x02\x5b\x02\x4e\x02\x6b\x02\x5c\x02\x80\x02\x88\x02\x76\x02\x30\x02", ((x + width) + 90), (fh * 5), 6, 0);
          }
          this.gr.showStringM("\x70\x02\x51\x02\x5c\x02\x5e\x02\x7e\x02\x7e\x02", ((x + width) + 90), (fh * 7), 6, 0);
          if (this.gr.pkey.isSelect(0, 0, WIDTH, HEIGHT)) {
             this.gr.pkey.setKey5();
          }
       }
       return;
    }
    private void drawMon(int i,int id,int x,int y){
       Ui.i().drawFrameOne(this.imgMon[i], this.imgMon[i].action((this.gr.mList_id[id][1] * 3), 0, 0), x, y, 0);
    }
    private byte[] getGameMonList(){
       byte n;
       int ix2;
       int ix = 1;
       int ix1 = 4;
       byte[] monList = new byte[3];
       byte i = 0;
       while (i < monList.length) {
          monList[i] = -1;
          ix2 = i + 1;
          i = (byte)ix2;
       }
       i = 0;
       while (i < this.gameData[2][this.lv]) {
          Ms.i();
          monList[i] = this.gameData[ix1][Ms.getRandom(this.gameData[ix1].length)];
          n = 0;
          while (n < i) {
             if (monList[n] == monList[i]) {
                Ms.i();
                monList[i] = this.gameData[ix1][Ms.getRandom(this.gameData[ix1].length)];
                n = 0;
             }else {
                ix2 = n + 1;
                n = (byte)ix2;
             }
          }
          ix2 = i + 1;
          i = (byte)ix2;
       }
       Ms.i();
       i = (byte)Ms.getRandom(2);
       n = monList[(monList.length - ix)];
       monList[(monList.length - ix)] = monList[i];
       monList[i] = n;
       i = 0;
       while (i < 3) {
          if (monList[i] != -1) {
             byte t = this.gr.mList_id[monList[i]][0];
             this.imgMon[i] = Ms.i().createSprite("data/npc2/".append(t).toString(), this.gr.isNpc2ImageType(t));
          }
          ix2 = i + 1;
          i = (byte)ix2;
       }
       return monList;
    }
    private void initGame(){
       byte[] monList = this.getGameMonList();
       byte i = 0;
       while (i < 3) {
          this.box[i][0] = i;
          this.box[i][1] = monList[i];
          int ix = this.gameData[0][i] + 100;
          this.box[i][2] = ix;
          this.box[i][3] = 0;
          int ix1 = i + 1;
          i = (byte)ix1;
       }
       monList = null;
       Ms.i();
       this.maxTransNum = (byte)((Ms.getRandom((this.lv + 2)) + 2) + this.lv);
       this.transNum = 0;
       this.mon_size_move = 0;
       return;
    }
    private byte win(){
       int b = (byte)(this.winNum + 1);
       this.winNum = b;
       if (b >= this.gameData[3][this.lv]) {
          int tm = (this.sell_money + ((this.lv * this.lv) * 150)) + ((2 - this.lv) * 25);
          Guess tgr = this.gr;
          tgr.money = tgr.money + tm;
          this.gr.say("\x83\x02\x5f\x02\x91\x02\x94\x02\xff\x02"+tm, 0);
          GameRun rmsOther = this.gr.rmsOther;
          int i = 10;
          if ((rmsOther[i] = (byte)(rmsOther[i] | (1 << this.lv))) == 2 && this.gr.rmsOther[11] < 3) {
             rmsOther = this.gr.rmsOther;
             rmsOther[11] = (byte)(rmsOther[11] + 1);
          }
          b = 2;
       }else {
          b = 3;
       }
       return b;
    }
    public void go(int mode){
       int i = 1;
       byte b = 0;
       if (mode < i) {
          this.b_win = b;
          this.gr.selecty = b;
          this.gr.selectx = b;
          this.winNum = b;
          this.state = b;
          this.gr.buyOk = b;
          this.gr.line_max = 9;
          this.sell_money = (this.lv * 200) + 200;
          this.length = (byte)(this.gr.about_a.length - this.gr.line_max);
       }else {
          this.time = b;
          this.state = i;
          this.initGame();
       }
       return;
    }
    public void go(int mode,int lv_){
       this.gr.setStringB(this.gr.createString("data/gamed.d"), 180, 0);
       this.gr.setStringB("\x5f\x02\x59\x02\x6e\x02\x62\x02#n\x79\x02\x5f\x02\x6e\x02\x62\x02", Constants_H.WIDTH, 1);
       this.lv = (byte)lv_;
       Image[] imageArray = new Image[]{Ms.i().createImage("data/brow/m2"),Ms.i().createImage("data/brow/m3")};
       this.imgBox = imageArray;
       byte[] uobyteArray = new byte[2];
       this.boxNum = uobyteArray;
       byte[][] uobyteArray1 = new byte[][5]{new byte[3]{0xc4,0x11,'Z'},new byte[4]{0x08,0x0d,0x14,0x1e},new byte[4]{0x01,0x02,0x03,0x03},new byte[4]{0x06,0x04,0x02,0x02},new byte[3]{'S',0x1e,'7'}};
       this.gameData = uobyteArray1;
       int[] ointArray = new int[]{3,4};
       this.box = Array.newInstance(Integer.TYPE, ointArray);
       Sprite[] spriteArray = new Sprite[3];
       this.imgMon = spriteArray;
       this.go(mode);
    }
    public boolean key(){
       int b;
       int i = -1;
       StringBuffer[] stringBuffer = null;
       if (Ms.i().key_delay()) {
          b = false;
       }else if(this.state == null){
          if (Ms.i().key_Up_Down()) {
             this.sel = (byte)(this.sel ^ 0x01);
          }else if(Ms.i().key_S1_Num5()){
             Ms.i().keyRelease();
             if (this.sel == null && this.gr.isMoney(this.sell_money, true)) {
                this.go(true, this.lv);
             }else if(this.sel == true){
                Ms.i().keyRelease();
                this.gr.about_a = stringBuffer;
                this.imgBox = stringBuffer;
                this.boxNum = stringBuffer;
                this.gameData = stringBuffer;
                this.box = stringBuffer;
                this.imgMon = stringBuffer;
                b = true;
             }
          }else if(Ms.i().key_S2()){
             Ms.i().keyRelease();
             this.gr.about_a = stringBuffer;
             this.imgBox = stringBuffer;
             this.boxNum = stringBuffer;
             this.gameData = stringBuffer;
             this.box = stringBuffer;
             this.imgMon = stringBuffer;
             b = true;
          }
       }else if(this.state == 3){
          if (Ms.i().key_Left_Right()) {
             this.gr.selectx = Ms.i().select(this.gr.selectx, 0, (this.box.length - true));
          }else if(Ms.i().key_S1_Num5()){
             Ms.i().keyRelease();
             this.state = 4;
             b = (this.gr.selectx == this.gr.selecty)? true: i;
             this.b_win = (byte)b;
          }
       }else if(this.state == 4 && Ms.i().key_S1_Num5()){
          Ms.i().keyRelease();
          if (this.b_win == true) {
             this.b_win = this.win();
             if (this.b_win == 3) {
                this.go(true, this.lv);
             }
          }else if(this.b_win != i && (this.b_win != 2 && this.gr.say_c == null)){
             if (this.b_win == 2 && this.gr.rmsOther[11] == 3) {
                this.gr.rmsOther[11] = 4;
                this.gr.getMonster(83, 25, 0, i);
             }else if(this.b_win == i && this.gr.rmsOther[11] < 3){
                this.gr.rmsOther[11] = 0;
             }
             this.go(0, this.lv);
          }
       }
       b = false;
       return b;
    }
    public void patin(){
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       Ui.i().fillRectB();
       this.draw();
       if (this.state != null) {
          this.drawGame();
       }
       return;
    }
    public void run(){
       byte i;
       object oobject;
       int ix1;
       int ix2;
       int ix = 0;
       if (this.state == 1) {
          if (this.time < 20) {
             this.time = (byte)(this.time + 1);
          }else if(this.box[ix][3] < 150){
             i = 0;
             while (i < 3) {
                oobject = this.box[i];
                ix1 = oobject[3] + 25;
                oobject[3] = ix1;
                ix2 = i + 1;
                i = (byte)ix2;
             }
          }else {
             ix2 = (byte)(this.time + 1);
             this.time = ix2;
             if (ix2 >= 40) {
                if (this.mon_size_move < 40) {
                   this.mon_size_move = (byte)(this.mon_size_move + 5);
                }else {
                   this.state = 2;
                   this.time = ix;
                }
             }
          }
       }else if(this.state == 2){
          if (this.time <= null) {
             if (this.transNum < this.maxTransNum) {
                this.time = 1;
                this.transNum = (byte)(this.transNum + 1);
                Ms.i();
                this.boxNum[ix] = (byte)Ms.getRandom(3);
                do {
                   Ms.i();
                } while ((this.boxNum[1] = (byte)Ms.getRandom(3)) != this.boxNum[ix]);
                if (this.box[this.boxNum[1]][2] < this.box[this.boxNum[ix]][2]) {
                   this.gameR = this.boxNum[1];
                   this.boxNum[1] = this.boxNum[ix];
                   this.boxNum[ix] = this.gameR;
                }
                Ms.i();
                this.gameR = (byte)(Ms.abs((this.box[this.boxNum[1]][2] - this.box[this.boxNum[ix]][2])) / 2);
                this.tempTransNum = (byte)((this.gameR * 2) / this.gameData[1][this.lv]);
             }else {
                this.time = ix;
                this.state = 3;
                do {
                   Ms.i();
                } while ((this.gr.selecty = (byte)Ms.getRandom(this.box.length)) != -1);
             }
          }else if(this.time > this.tempTransNum){
             this.time = ix;
             int[] temp = new int[4];
             i = 0;
             while (i < this.box.length) {
                byte j = 0;
                while (j < this.box.length) {
                   if (this.box[j][2] > this.box[i][2]) {
                      System.arraycopy(this.box[i], ix, temp, ix, temp.length);
                      System.arraycopy(this.box[j], ix, this.box[i], ix, this.box[j].length);
                      System.arraycopy(temp, ix, this.box[j], ix, temp.length);
                   }
                   ix2 = j + 1;
                   j = (byte)ix2;
                }
                ix2 = i + 1;
                i = (byte)ix2;
             }
             i = 0;
             while (i < 3) {
                ix1 = this.gameData[ix][i] + 100;
                this.box[i][2] = ix1;
                this.box[i][3] = 150;
                ix2 = i + 1;
                i = (byte)ix2;
             }
          }else {
             this.time = (byte)(this.time + 1);
             oobject = this.box[this.boxNum[ix]];
             oobject[2] = oobject[2] + ((this.gameR * 2) / this.tempTransNum);
             int temp1 = ((this.gameR * 2) / this.tempTransNum) * this.time;
             this.box[this.boxNum[ix]][3] = 150 - Ms.i().sqrt(((this.gameR * this.gameR) - ((temp1 - this.gameR) * (temp1 - this.gameR))));
             oobject = this.box[this.boxNum[1]];
             oobject[2] = oobject[2] - ((this.gameR * 2) / this.tempTransNum);
             this.box[this.boxNum[1]][3] = Ms.i().sqrt(((this.gameR * this.gameR) - ((temp1 - this.gameR) * (temp1 - this.gameR)))) + 150;
          }
       }else if(this.state == 4 && (this.gr.selectx == 2 && (this.box[this.gr.selectx][2] > (this.gameData[ix][1] + 100) || (this.gr.selectx == null && this.box[this.gr.selectx][2] < (this.gameData[ix][1] + 100))))){
          oobject = this.box[this.gr.selectx];
          oobject[2] = oobject[2] + ((this.gameData[ix][1] - this.gameData[ix][this.gr.selectx]) / 7);
       }
       return;
    }
}
