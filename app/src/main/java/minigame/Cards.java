package minigame.Cards;
import minigame.MiniGame_H;
import main.GameRun;
import java.lang.Object;
import dm.Ui;
import java.lang.StringBuilder;
import java.lang.String;
import main.PointerKey;
import java.lang.StringBuffer;
import dm.Ms;
import main.Constants_H;
import java.lang.Byte;
import java.lang.Class;
import java.lang.reflect.Array;

public class Cards implements MiniGame_H	// class@00016b from classes.dex
{
    private short count;
    private byte[][] findC;
    private byte[][] findN;
    private byte find_count;
    private short gh;
    GameRun gr;
    private short gspace;
    private short gw;
    private short gx;
    private short gy;
    private short hh;
    private byte length;
    private byte lv;
    private byte[][] num;
    byte sel;
    private int sell_money;
    private byte selx;
    private byte sely;
    private byte state;
    private byte time;
    private byte tx;
    private byte ty;
    private short wh;

    public void Cards(GameRun gr_){
       super();
       this.gw = 30;
       this.gh = 40;
       this.gspace = 4;
       this.wh = 320;
       this.hh = 160;
       this.time = 3;
       this.find_count = 3;
       byte[][] uobyteArray = new byte[][4]{new byte[2]{0x03,0x04},new byte[2]{0x03,0x06},new byte[2]{0x04,0x06},new byte[2]{0x05,0x06}};
       this.num = uobyteArray;
       this.gr = gr_;
    }
    private void drawCard(int i,int j,int x,int y,int mode){
       if (!mode) {
          Ui.i().drawK(x, y, this.gw, this.gh, 1);
          Ui.i().drawUi(25, ((this.gw >> 1) + x), ((this.gh >> 1) + y), 3, 0);
       }else if(mode == 1){
          Ui.i().drawK((((this.gw >> 1) + x) - 2), (y - 3), 5, (this.gh + 6), 1);
          object oobject = this.findC[i];
          byte b = (byte)(oobject[j] + 1);
          oobject[j] = b;
          if (b > 3) {
             this.findC[i][j] = 0;
          }
          mode = 2;
       }else {
          Ui.i().drawK(x, y, this.gw, this.gh, 5);
          this.gr.drawItem(this.findN[i][j], ((this.gw >> 1) + x), ((this.gh >> 1) + y), 3);
          Ui.i().drawNum(this.findN[i][j], (this.gw + x), (this.gh + y), 40, 0);
       }
       return;
    }
    private void drawGame(int x,int y,int h){
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       int i = 0;
       while (i < this.findN.length) {
          int j = 0;
          while (j < this.findN[i].length) {
             int ix = this.wh + this.gx;
             int ix1 = this.gw + this.gspace;
             ix1 = ix1 * j;
             ix1 = ix1 + ix;
             ix = this.hh + this.gy;
             int ix2 = this.gh + this.gspace;
             ix2 = ix2 * i;
             ix2 = ix2 + ix;
             int ix3 = (this.findC[i][j] == 3)? 1: this.findC[i][j];
             this.drawCard(i, j, ix1, ix2, ix3);
             ix1 = this.wh + this.gx;
             ix2 = this.gw + this.gspace;
             ix2 = ix2 * j;
             ix1 = ix1 + ix2;
             ix2 = this.hh + this.gy;
             ix3 = this.gh + this.gspace;
             ix3 = ix3 * i;
             ix2 = ix2 + ix3;
             ix3 = this.gw + this.gspace;
             int ix4 = this.gh + this.gspace;
             if (this.gr.pkey.isSelect(ix1, ix2, ix3, ix4) && this.state < 3) {
                this.tx = (byte)j;
                this.ty = (byte)i;
                this.gr.pkey.setKey5();
             }
             j++;
          }
          i++;
       }
       i = this.gx;
       Ui.i().drawRectZ(0xeafcff, ((this.wh + i) + (this.tx * (this.gw + this.gspace))), ((this.hh + this.gy) + (this.ty * (this.gh + this.gspace))), this.gw, this.gh, 3);
       if (this.count > null) {
          Ui.i().drawNum((this.count / 10), (WIDTH_H + 10), 29, 36, 2);
       }else {
          Ui.i().drawString("\x6e\x02\x62\x02\x5f\x02\x59\x02", WIDTH_H, 4, 17, 3, 0);
          Cards tgr = this.gr;
          String str = "\x53\x02\x95\x02\x6b\x02\x65\x02\xff\x02";
          i = (this.time < null)? 0: this.time - 1;
          tgr.showStringM(str+i+"\x6b\x02", (WIDTH_H + 200), (HEIGHT_H - 75), 5, 0);
       }
       return;
    }
    private void nullGame(){
       this.findN = null;
       this.findC = null;
       this.num = null;
    }
    public void draw0(int x,int y,int h){
       int HEIGHT = 360;
       int WIDTH_H = 320;
       Ui.i().fillRectB();
       int w = 200;
       Ui.i().drawK(x, ((y + 25) + 5), (w - 10), h, 4);
       Ui.i().drawK((x + w), ((y + 25) + 5), (w + 20), h, 4);
       Ui.i().drawK(((x + 420) + 10), ((y + 25) + 5), (w - 10), h, 4);
       if (this.state == null) {
          Ui.i().drawString("\x6e\x02\x62\x02\x89\x02\x52\x02", WIDTH_H, ((y + 25) + 5), 33, 3, 1);
          Ui.i().drawUi(7, ((WIDTH_H - 50) + 7), (y + 25), 40, 0);
          Ui.i().drawUi(7, ((WIDTH_H + 50) + 7), (y + 25), 36, 4);
       }
       Ui.i().drawStringY(this.gr.about_a, 25, ((y + 25) + 10), 25, 0, 0);
       if (this.state == null) {
          this.gr.showStringM("\x97\x02\x89\x02\x76\x02\x53\x02\x52\x02\x8d\x02\xff\x02"+this.sell_money+"\x91\x02", WIDTH_H, ((y + h) - 50), 7, 0);
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
             ix = ix + ty;
             int ix2 = ix - 2;
             int ix3 = (this.sel == i)? 0: 3;
             ui.drawString(str, ix1, ix2, 0, ix3, 1);
             int ix4 = x + w;
             ix4 = ix4 + 12;
             ix4 = ix4 + 25;
             int ix5 = i * 40;
             ix5 = ix5 + ty;
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
       this.gr.drawMoney(WIDTH_H, HEIGHT, 3, false);
       if (this.state == null) {
          Ui.i().drawYesNo(true, true);
       }
       return;
    }
    public void go(int mode){
       byte j;
       int ix;
       byte k;
       int ix1;
       this.gr.line_max = 9;
       this.count = 100;
       this.time = (byte)((this.lv * 2) + 4);
       this.find_count = (byte)((this.num[this.lv][0] * this.num[this.lv][1]) / 2);
       if (mode < 1) {
          this.ty = 0;
          this.state = 0;
          this.sell_money = (this.lv * 200) + 200;
       }else {
          this.gx = (short)((- ((this.gw + this.gspace) * this.num[this.lv][1])) >> 1);
          this.gy = (short)((- ((this.gh + this.gspace) * this.num[this.lv][0])) >> 1);
          this.ty = 0;
          this.tx = 0;
          this.state = 1;
          byte i = 0;
          byte[] randN = new byte[this.find_count];
          while (i < this.findC.length) {
             j = 0;
             while (j < this.findC[i].length) {
                this.findC[i][j] = 2;
                this.findN[i][j] = 0;
                ix = j + 1;
                j = (byte)ix;
             }
             ix = i + 1;
             i = (byte)ix;
          }
          i = 0;
          while (i < randN.length) {
             Ms.i();
             ix = Ms.getRandom(35) + 1;
             byte rd = (byte)ix;
             ix = randN.length - 1;
             j = (byte)ix;
             while (j > -1 && randN[j] != rd) {
                ix = j - 1;
                j = (byte)ix;
             }
             if (j == -1) {
                randN[i] = rd;
                ix = i + 1;
                i = (byte)ix;
             }
          }
          i = 0;
          while (i < randN.length) {
             j = 0;
             while (j < 2) {
                do {
                   Ms.i();
                   ix = this.num[this.lv][0] * this.num[this.lv][1];
                   k = (byte)Ms.getRandom(ix);
                   ix1 = k / this.num[this.lv][1];
                   ix1 = k % this.num[this.lv][1];
                } while (!this.findN[ix1][ix1]);
                ix1 = k / this.num[this.lv][1];
                ix1 = k % this.num[this.lv][1];
                this.findN[ix1][ix1] = randN[i];
                ix = j + 1;
                j = (byte)ix;
             }
             ix = i + 1;
             i = (byte)ix;
          }
          Cards uCards = null;
       }
       return;
    }
    public void go(int mode,int lv_){
       this.gr.setStringB(this.gr.createString("data/gamec.d"), 160, 0);
       this.gr.setStringB("\x5f\x02\x59\x02\x6e\x02\x62\x02#n\x79\x02\x5f\x02\x6e\x02\x62\x02", Constants_H.WIDTH, 1);
       this.lv = (byte)lv_;
       this.findN = null;
       int[] ointArray = new int[]{this.num[this.lv][0],this.num[this.lv][1]};
       this.findN = Array.newInstance(Byte.TYPE, ointArray);
       this.findC = null;
       ointArray = new int[]{this.num[this.lv][0],this.num[this.lv][1]};
       this.findC = Array.newInstance(Byte.TYPE, ointArray);
       this.length = 9;
       this.go(mode);
    }
    public boolean key(){
       byte b;
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
                this.nullGame();
                b = true;
             }
          }else if(Ms.i().key_S2()){
             Ms.i().keyRelease();
             this.nullGame();
             b = true;
          }
       }else if(this.state < 3){
          if (Ms.i().key_Up_Down()) {
             this.ty = Ms.i().select(this.ty, 0, (this.findN.length - true));
          }else if(Ms.i().key_Left_Right()){
             this.tx = Ms.i().select(this.tx, 0, (this.findN[this.ty].length - true));
          }else if(Ms.i().key_S1_Num5()){
             Ms.i().keyRelease();
             if (this.state == null) {
                this.go(0, this.lv);
             }else if(!this.findC[this.ty][this.tx]){
                object oobject = this.findC[this.ty];
                Cards ttx = this.tx;
                oobject[ttx] = (byte)(oobject[ttx] + 1);
                b = (byte)(this.state + 1);
                this.state = b;
                if (b == 2) {
                   this.selx = this.tx;
                   this.sely = this.ty;
                }
             }
          }
       }
       b = false;
       return b;
    }
    public void patin(){
       this.draw0(10, 2, 280);
       if (this.state != null) {
          this.drawGame(10, 2, ((this.length + 3) * 25));
       }
       return;
    }
    public void run(){
       int b1;
       int ix = 10;
       int ix1 = 0;
       byte b = -1;
       if (this.time < 1) {
          if (this.time == null) {
             this.time = b;
             this.gr.say("\x6e\x02\x62\x02\x59\x02\x8d\x02\xff\x02\xff\x02\xff\x02", b);
          }else if(this.time == b && this.gr.say_c == null){
             this.go(ix1, this.lv);
          }
       }else if(this.find_count < 1){
          if (this.find_count == null) {
             this.find_count = b;
             Cards tgr = this.gr;
             tgr.money = tgr.money + ((this.time * 125) + 100);
             this.gr.say("\x83\x02\x5f\x02\x91\x02\x94\x02\xff\x02"+((this.time * 125) + 100), b);
             GameRun rmsOther = this.gr.rmsOther;
             rmsOther[8] = (byte)(rmsOther[8] | (1 << this.lv));
          }else if(this.find_count == b && this.gr.say_c == null){
             this.go(ix1, this.lv);
          }
       }else if(this.state >= 3){
          b1 = (byte)(this.state + 1);
          this.state = b1;
          if (b1 > ix) {
             this.state = 1;
          }else if(this.state == ix){
             if (this.findN[this.ty][this.tx] != this.findN[this.sely][this.selx]) {
                this.findC[this.ty][this.tx] = 3;
                this.findC[this.sely][this.selx] = 3;
                this.time = (byte)(this.time - 1);
             }else {
                this.find_count = (byte)(this.find_count - 1);
             }
          }
       }else if(this.count > null){
          b1 = (short)(this.count - 1);
          this.count = b1;
          if (!b1) {
             byte i = 0;
             while (i < this.findC.length) {
                byte j = 0;
                while (j < this.findC[i].length) {
                   this.findC[i][j] = 3;
                   b1 = j + 1;
                   j = (byte)b1;
                }
                b1 = i + 1;
                i = (byte)b1;
             }
          }
       }
       return;
    }
}
