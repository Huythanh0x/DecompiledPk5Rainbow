package minigame;

import dm.Ms;
import dm.Sprite;
import dm.Ui;
import javax.microedition.lcdui.Image;
import main.Constants_H;
import main.GameRun;

public class Bearer implements MiniGame_H {
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
  
  public Bearer(GameRun paramGameRun) {
    short[] arrayOfShort = { 60, 40, 30, 10 };
    this.gDate = new short[][] { { 9, 1, 10, 2, 11, 4, 27, 8, 2, -10 }, { 50, 100, 150, 200 }, arrayOfShort, { 8, 6, 13, 3, 20, 5, 30, 10 } };
    this.ballDate = new short[][] { { 10, 20, 60, 10, 220 }, { 13, 40, 60, 12, 170 }, { 10, 40, 60, 10, 120 } };
    this.money = new short[] { 150, 200, 300, 450 };
    this.xy = new short[40][7];
    arrayOfShort = new short[5];
    arrayOfShort[1] = 275;
    arrayOfShort[2] = 67;
    arrayOfShort[3] = 10;
    this.myxy = arrayOfShort;
    this.ball_time = new byte[] { 20, 15, 10, 5 };
    this.SPEED = 10;
    this.gr = paramGameRun;
  }
  
  private void addBall(int paramInt) {
    this.xy[this.cur][0] = -20;
    this.xy[this.cur][1] = this.ballDate[paramInt][4];
    this.xy[this.cur][2] = (short)(this.ballDate[paramInt][1] / this.ballDate[paramInt][0]);
    this.xy[this.cur][4] = this.ballDate[paramInt][0];
    this.xy[this.cur][5] = (short)paramInt;
    this.xy[this.cur][3] = this.ballDate[paramInt][3];
    short[] arrayOfShort = this.xy[this.cur];
    Ms.i();
    arrayOfShort[6] = (short)Ms.getRandom((this.gDate[0]).length >> 1);
    byte b = (byte)(this.cur + 1);
    this.cur = b;
    if (b >= this.xy.length)
      this.cur = 0; 
  }
  
  private void draw0(int paramInt1, int paramInt2, int paramInt3) {
    int i = paramInt3 + 45;
    Ui.i().fillRectB();
    Ui.i().drawK(paramInt1, paramInt2 + 25 + 5, 200 - 10, i, 4);
    Ui.i().drawK(paramInt1 + 200 + 10, paramInt2 + 25 + 5, 200, i, 4);
    Ui.i().drawK(paramInt1 + 420 + 10, paramInt2 + 25 + 5, 200 - 10, i, 4);
    Ui.i().drawString("游戏规则", 320, paramInt2 + 25 + 5, 33, 3, 1);
    Ui.i().drawUi(7, 320 - 50 - 5, paramInt2 + 25 - 4, 40, 0);
    Ui.i().drawUi(7, 320 + 50 + 5, paramInt2 + 25 - 4, 36, 4);
    Ui.i().drawStringY(this.gr.about_a, 25, paramInt2 + 75 + 10, 25, 0, 0);
    paramInt3 = paramInt2 + 100;
    Ui.i().drawString("球的分数：", paramInt1 + 420 + 20, paramInt3, 0, 0, 0);
    int j = paramInt3 + 50;
    for (paramInt3 = 0;; paramInt3 += 2) {
      byte b;
      if (paramInt3 >= (this.gDate[0]).length) {
        j -= 50;
        Ui.i().drawListKY(2, paramInt1 + 200 + 12 + 25, j, 200 - 50, 3, 30, 10, this.sel, 4, 2);
        for (paramInt3 = 0;; paramInt3++) {
          if (paramInt3 >= this.gr.about_b.length) {
            this.gr.showStringM("需要的参加费：" + this.money[this.lv] + "金", 320, paramInt2 + i - 50, 7, 0);
            this.gr.drawMoney(320, 360, 3, false);
            if (this.state == 0)
              Ui.i().drawYesNo(true, true); 
            return;
          } 
          System.out.println("i   " + paramInt3);
          Ui ui1 = Ui.i();
          String str1 = this.gr.about_b[paramInt3].toString();
          if (this.sel == paramInt3) {
            b = 0;
          } else {
            b = 3;
          } 
          ui1.drawString(str1, paramInt1 + 200 + 15 + 25 + 26, paramInt3 * 40 + j - 2, 0, b, 1);
          if (this.gr.pkey.isSelect(paramInt1 + 200 + 12 + 25, paramInt3 * 40 + j - 2, 200 - 50, 40)) {
            System.out.println("asdfasfaf");
            if (this.sel == paramInt3) {
              this.gr.pkey.setKey5();
            } else {
              this.sel = (byte)paramInt3;
            } 
          } 
        } 
        break;
      } 
      GameRun gameRun = this.gr;
      short s = this.gDate[0][paramInt3];
      if (paramInt3 % 4 == 2) {
        b = 100;
      } else {
        b = 0;
      } 
      gameRun.drawItem(s, paramInt1 + 420 + 25 + b, (paramInt3 >> 2) * 30 + j, 0);
      Ui ui = Ui.i();
      if (this.gDate[0][paramInt3 + 1] < 0) {
        str = "";
      } else {
        str = "+";
      } 
      String str = String.valueOf(str) + this.gDate[0][paramInt3 + 1];
      if (paramInt3 % 4 == 2) {
        b = 100;
      } else {
        b = 0;
      } 
      ui.drawString(str, paramInt1 + 420 + 25 + b + 16, (paramInt3 >> 2) * 30 + j - 4, 0, 0, 1);
    } 
  }
  
  private void drawGame(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Ui.i().fillRect(5423359, paramInt1, paramInt2, paramInt3, paramInt4);
    Ui.i().drawFrameOne(this.bsp, 0, paramInt1 + (paramInt3 >> 1), paramInt2 + (paramInt4 >> 1), 0);
    Ui.i().drawString("分数：" + this.count, (paramInt3 >> 1) + paramInt1 - 25, paramInt2, 24, 3, 1);
    Ui.i().drawString("球总数：" + this.ballC0, (paramInt3 >> 1) + paramInt1 + 25, paramInt2, 20, 3, 1);
    Ui.i().drawImage(this.img, paramInt1 + paramInt3, paramInt4 - 15, 40);
    for (paramInt3 = 0;; paramInt3 = (byte)(paramInt3 + 1)) {
      if (paramInt3 >= this.xy.length) {
        for (paramInt3 = 0;; paramInt3 = (byte)(paramInt3 + 1)) {
          if (paramInt3 >= 2) {
            this.gr.drawMoney(320, 360, 3, false);
            return;
          } 
          Ui ui = Ui.i();
          Sprite sprite = this.sp[0];
          if (this.myxy[4] == 0) {
            paramInt4 = 3;
          } else {
            paramInt4 = 4;
          } 
          ui.drawFrameOne(sprite, paramInt4, this.myxy[0] + paramInt1 + paramInt3 * 30 + 20, this.myxy[1] + paramInt2 + 25, 0);
        } 
        break;
      } 
      if (this.xy[paramInt3][5] != -1)
        this.gr.drawItem(this.gDate[0][this.xy[paramInt3][6] << 1], this.xy[paramInt3][0] + paramInt1, this.xy[paramInt3][1] + paramInt2, 0); 
    } 
  }
  
  private void getAY(int paramInt) {
    if (this.xy[paramInt][4] > 0 && this.xy[paramInt][3] > 1) {
      short[] arrayOfShort = this.xy[paramInt];
      arrayOfShort[3] = (short)(arrayOfShort[3] - 1);
      return;
    } 
    if (this.xy[paramInt][4] == 0) {
      this.xy[paramInt][3] = 0;
      return;
    } 
    if (this.xy[paramInt][4] < 0 && this.xy[paramInt][3] > -this.ballDate[this.xy[paramInt][5]][3]) {
      short[] arrayOfShort = this.xy[paramInt];
      arrayOfShort[3] = (short)(arrayOfShort[3] - 1);
    } 
  }
  
  private void initABall(boolean paramBoolean) {
    short s;
    if (paramBoolean) {
      s = 10;
    } else {
      s = this.gDate[2][this.lv];
    } 
    this.time0 = s;
    this.time1 = this.ball_time[this.lv];
    Ms.i();
    this.ballC1 = (short)(Ms.getRandom(this.gDate[3][this.lv << 1]) + this.gDate[3][(this.lv << 1) + 1]);
  }
  
  private boolean isCollision(int paramInt) {
    return Ms.i().isRect(this.myxy[0], this.myxy[1], this.myxy[2], this.myxy[3], this.xy[paramInt][0], this.xy[paramInt][1], 16, 16);
  }
  
  private boolean isSrc(int paramInt) {
    boolean bool1;
    if (this.xy[paramInt][1] > 320 + 10) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (!Ms.i().isRect(240 - 10, 320 - 40, 20, 10, this.xy[paramInt][0], this.xy[paramInt][1], 16, 16)) {
      boolean bool = bool1;
      if (this.xy[paramInt][0] > 240) {
        bool = bool1;
        if (this.xy[paramInt][1] < this.myxy[1]) {
          bool = true;
          this.count = (short)(this.count + this.gDate[0][this.xy[paramInt][6] * 2 + 1]);
          return bool;
        } 
      } 
      return bool;
    } 
    boolean bool2 = true;
    this.count = (short)(this.count + this.gDate[0][this.xy[paramInt][6] * 2 + 1]);
    return bool2;
  }
  
  private void nullGame() {
    this.gDate = null;
    this.money = null;
    this.sp = null;
    this.img = null;
    this.ballDate = null;
  }
  
  public void go(int paramInt) {
    if (paramInt < 1) {
      this.state = 0;
      this.length = 10;
      this.gr.setStringB("在限定时间里接尽量多的球到框里，最后根据框里球的分数来换取金钱。", 160, 0);
      this.gr.setStringB("开始游戏#n离开游戏", Constants_H.WIDTH, 1);
      return;
    } 
    if (paramInt == 1) {
      this.state = 1;
      this.count = 0;
      this.cur = 0;
      this.ballC0 = this.gDate[1][this.lv];
      initABall(true);
      paramInt = 0;
      while (true) {
        if (paramInt < this.xy.length) {
          this.xy[paramInt][5] = -1;
          paramInt = (byte)(paramInt + 1);
          continue;
        } 
        return;
      } 
    } 
  }
  
  public void go(int paramInt1, int paramInt2) {
    this.lv = (byte)paramInt2;
    this.sp = new Sprite[2];
    this.sp[0] = Ms.i().createSprite("data/npc2/38", true);
    this.img = Ms.i().createImage("data/brow/m0");
    byte[] arrayOfByte = Ms.i().getStream("data/gamee.data", -1);
    Ms.i();
    Ms.skip = 0;
    this.bsp = Sprite.Create(Ms.i().createImage("data/map/5"), Ms.i().createShort2Array(arrayOfByte, 2), Ms.i().createShort3Array(arrayOfByte, 2), Ms.i().createShort3Array(arrayOfByte, 2));
    go(paramInt1);
  }
  
  public boolean key() {
    if (this.state == 0) {
      if (Ms.i().key_Up_Down()) {
        this.sel = (byte)(this.sel ^ 0x1);
      } else if (Ms.i().key_S1_Num5()) {
        Ms.i().keyRelease();
        if (this.sel == 0 && this.gr.isMoney(this.money[this.lv], true)) {
          go(1);
        } else if (this.sel == 1) {
          Ms.i().keyRelease();
          nullGame();
          return true;
        } 
      } else if (Ms.i().key_S2()) {
        nullGame();
        return true;
      } 
    } else if (this.state == 1) {
      if (Ms.i().key_Left()) {
        short[] arrayOfShort = this.myxy;
        arrayOfShort[0] = (short)(arrayOfShort[0] - 10);
        if (this.myxy[0] < 0)
          this.myxy[0] = 0; 
      } else if (Ms.i().key_Right()) {
        short[] arrayOfShort = this.myxy;
        arrayOfShort[0] = (short)(arrayOfShort[0] + 10);
        if (this.myxy[0] + this.myxy[2] > 220)
          this.myxy[0] = (short)(240 - this.myxy[2] - 20); 
      } 
    } 
    return false;
  }
  
  public void patin() {
    draw0(10, 2, this.length * 25);
    if (this.state != 0)
      drawGame(200, 0, 240, 320); 
  }
  
  public void run() {
    if (this.state == 1) {
      if (this.ballC0 > 0)
        if (this.time0 > 0) {
          this.time0 = (short)(this.time0 - 1);
        } else if (this.time1 > 0) {
          this.time1 = (short)(this.time1 - 1);
        } else if (this.ballC1 > 0) {
          this.time1 = this.ball_time[this.lv];
          addBall(Ms.getRandom(this.ballDate.length));
          this.ballC1 = (short)(this.ballC1 - 1);
          this.ballC0 = (short)(this.ballC0 - 1);
        } else if (this.ballC1 == 0) {
          initABall(false);
        }  
      if (this.myxy[4] > 0) {
        short[] arrayOfShort = this.myxy;
        arrayOfShort[4] = (short)(arrayOfShort[4] - 1);
      } 
      boolean bool = true;
      for (byte b = 0;; b = (byte)(b + 1)) {
        if (b >= this.xy.length) {
          if (this.ballC0 < 1 && bool) {
            this.count = (short)(this.count * 15 / 10);
            GameRun gameRun = this.gr;
            gameRun.money += this.count;
            this.gr.say("获得：" + this.count + "金", 0);
            if (this.count > 0) {
              byte[] arrayOfByte = this.gr.rmsOther;
              arrayOfByte[6] = (byte)(arrayOfByte[6] | 1 << this.lv);
            } 
            this.state = 2;
          } 
          this.gr.pkey.checkButton(4);
          return;
        } 
        if (this.xy[b][5] != -1) {
          boolean bool1 = false;
          short[] arrayOfShort = this.xy[b];
          arrayOfShort[0] = (short)(arrayOfShort[0] + this.xy[b][2]);
          arrayOfShort = this.xy[b];
          arrayOfShort[1] = (short)(arrayOfShort[1] - this.xy[b][3]);
          getAY(b);
          arrayOfShort = this.xy[b];
          arrayOfShort[4] = (short)(arrayOfShort[4] - 1);
          if (isSrc(b)) {
            this.xy[b][5] = -1;
            bool = bool1;
          } else {
            bool = bool1;
            if (isCollision(b)) {
              this.xy[b][4] = this.ballDate[this.xy[b][5]][0];
              this.myxy[4] = 1;
              this.xy[b][3] = this.ballDate[this.xy[b][5]][3];
              bool = bool1;
            } 
          } 
        } 
      } 
    } 
    if (this.state == 2 && this.gr.say_c == 0)
      go(0); 
  }
  
  public void setLv(int paramInt) {
    this.lv = (byte)paramInt;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/minigame/Bearer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */