package minigame;

import dm.Ms;
import dm.Sprite;
import dm.Ui;
import javax.microedition.lcdui.Image;
import main.Constants_H;
import main.GameRun;

public class Racing implements MiniGame_H {
  private final short MAP_HEIGHT = 450;
  
  private final byte NUM = 4;
  
  private final short WIN_HEIGHT = 70;
  
  private short[][] cloud;
  
  private short[][] gDate;
  
  GameRun gr;
  
  private Image imgCloud;
  
  private byte length;
  
  private byte lv;
  
  private short[] monY;
  
  private short[] money;
  
  private byte[] myDate;
  
  private byte[][] now_a = new byte[4][3];
  
  private byte sel;
  
  private Sprite[] sp;
  
  private byte speedLv;
  
  private short srcY;
  
  private byte state;
  
  private byte time;
  
  public Racing(GameRun paramGameRun) {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[3] = -1;
    this.myDate = arrayOfByte;
    this.cloud = new short[10][3];
    this.monY = new short[4];
    this.money = new short[] { 100, 120, 300, 350, 1000, 1200 };
    this.gDate = new short[][] { { 450, 3, 8 }, { 390, 4, 9 }, { 270, 7, 6 }, { 210, 6, 10 } };
    this.gr = paramGameRun;
  }
  
  private void addCloud(int paramInt) {
    short[] arrayOfShort = this.cloud[paramInt];
    Ms.i();
    arrayOfShort[0] = (short)(Ms.getRandom(Constants_H.WIDTH_H) + 640);
    arrayOfShort = this.cloud[paramInt];
    short s = this.srcY;
    Ms.i();
    arrayOfShort[1] = (short)(s - 80 + (Ms.getRandom(25) + 55) * paramInt);
    arrayOfShort = this.cloud[paramInt];
    Ms.i();
    arrayOfShort[2] = (short)(Ms.getRandom(5) + 2);
  }
  
  private void draw0(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Ui.i().fillRectB();
    Ui.i().drawString("游戏规则", 320, paramInt2 + paramInt4 + 3, 33, 3, 1);
    Ui.i().drawUi(7, 320 - 50, paramInt2 + paramInt4 - 13, 40, 0);
    Ui.i().drawUi(7, 320 + 50, paramInt2 + paramInt4 - 13, 36, 4);
    Ui.i().drawK(paramInt1, paramInt2 + paramInt4 + 3, 200, paramInt3, 4);
    Ui.i().drawK(paramInt1 + 200 + 10, paramInt2 + paramInt4 + 3, 200, paramInt3, 4);
    this.gr.showStringM("选择你认为会得第一的一只宠物和押注的大小，注数越大获胜后的奖励越丰厚！", paramInt1 + 100, paramInt2 + paramInt4 + 15, 7, 0);
    Ui.i().drawK(paramInt1 + 420, paramInt2 + paramInt4 + 3, 200, paramInt3, 4);
    Ui.i().drawStringY(this.gr.about_a, paramInt1 + 420 + 25, paramInt2 + paramInt4 + 15, paramInt4, 0, 0);
    if (this.state == 0) {
      Ui.i().drawString("请选择押注大小：", paramInt1 + 200 + 10, paramInt2 + paramInt4 + 15, 0, 0, 0);
      paramInt3 = 0;
      while (true) {
        if (paramInt3 >= this.length) {
          Ui.i().drawK4(paramInt1 + 200 + 10 + 25 + 14, paramInt2 + paramInt4 + 50 + this.sel * (paramInt4 + 16), 150, paramInt4 + 4);
        } else {
          Ui.i().drawK(paramInt1 + 200 + 10 + 25 + 14, paramInt2 + paramInt4 + 50 + (paramInt4 + 16) * paramInt3, 150, paramInt4 + 4, 1);
          Ui.i().drawString(this.gr.about_b[paramInt3].toString(), paramInt1 + 200 + 10 + 25 + 14, paramInt2 + paramInt4 + 50 + (paramInt4 + 16) * paramInt3, 0, 3, 0);
          if (this.gr.pkey.isSelect(paramInt1 + 200 + 10 + 25 + 14, paramInt2 + paramInt4 + 50 + (paramInt4 + 16) * paramInt3, 150, paramInt4 + 4))
            if (this.sel == paramInt3) {
              this.gr.pkey.setKey5();
            } else {
              this.sel = (byte)paramInt3;
            }  
          paramInt3++;
          continue;
        } 
        this.gr.drawMoney(320, 360, 3, false);
        Ui.i().drawYesNo(true, true);
        return;
      } 
    } 
    this.gr.drawMoney(320, 360, 3, false);
    Ui.i().drawYesNo(true, true);
  }
  
  private void draw1(int paramInt1, int paramInt2, int paramInt3) {
    Ui.i().drawK(215, 33, 210, 325, 4);
    for (int i = 0;; i = (byte)(i + 1)) {
      boolean bool;
      if (i >= this.length) {
        if (this.state == 1) {
          Ui.i().drawK4(paramInt1 + 25 + this.sel * 52, paramInt2 + 25 + 10, 44, 76);
          Ui.i().drawTriangle(320, paramInt2 + 25 + 49, 116, true, true);
          byte b = this.gr.pkey.selectMenuX(4, 320 - 116, paramInt2 + 25 + 10, 52, paramInt3);
          if (b != -1)
            if (this.sel == b) {
              this.gr.pkey.setKey5();
            } else {
              this.sel = b;
            }  
        } 
        Ui.i().drawString("兴奋度：", paramInt1 + 25, paramInt2 + 25 + 13 + paramInt3, 0, 0, 0);
        this.gr.drawFealty(6, 2, paramInt1 + 125, paramInt2 + 25 + 19 + paramInt3);
        this.gr.showStringM("每喂一个兴奋菇花费10金，可增加一格兴奋度。", 320, paramInt2 + 50 + 19 + paramInt3, 8, 0);
        paramInt3 = paramInt3 + 69 + 25 + 75;
        Ui.i().drawString("请选择道具：", paramInt1 + 25, paramInt2 + paramInt3, 0, 0, 0);
        i = paramInt3 + 25 + 3;
        for (paramInt3 = 0;; paramInt3 = (byte)(paramInt3 + 1)) {
          if (paramInt3 >= this.length) {
            if (this.state == 2) {
              Ui.i().drawK4(paramInt1 + 25 + this.sel * 52, paramInt2 + i, 44, 34);
              Ui.i().drawTriangle(320, paramInt2 + i + 14, 116, true, true);
              byte b = this.gr.pkey.selectMenuX(4, 320 - 116, paramInt2 + i + 8, 52, 34);
              if (b != -1)
                if (this.sel == b) {
                  this.gr.pkey.setKey5();
                } else {
                  this.sel = b;
                }  
            } 
            Ui ui1 = Ui.i();
            if (this.state != 1) {
              bool = true;
            } else {
              bool = false;
            } 
            ui1.drawYesNo(true, bool);
            return;
          } 
          Ui.i().drawK(paramInt1 + 25 + paramInt3 * 52, paramInt2 + i, 44, 34, 1);
          this.gr.drawItem(12, paramInt1 + 25 + paramInt3 * 52, paramInt2 + i + 10, 0);
          Ui.i().drawString("x" + paramInt3, paramInt1 + 25 + paramInt3 * 52 + 16, paramInt2 + i + 8, 0, 3, 1);
        } 
        break;
      } 
      Ui.i().drawK(paramInt1 + 25 + i * 52, paramInt2 + 25 + 10, 44, paramInt3, 1);
      Ui ui = Ui.i();
      Sprite sprite = this.sp[0];
      byte[] arrayOfByte = this.now_a[i];
      if (this.state == 1) {
        if (this.sel == i) {
          bool = true;
        } else {
          bool = false;
        } 
      } else {
        bool = false;
      } 
      ui.drawActionOne(sprite, 0, paramInt1 + 25 + i * 52 + 22, paramInt2 + 25 + 8 + paramInt3, arrayOfByte, 0, bool);
      Ui.i().drawNum(i + 1, paramInt1 + 25 + i * 52 + 27, paramInt2 + 50 + 12, 20, 2);
    } 
  }
  
  private void drawCloud() {
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= this.cloud.length) {
        for (b = 0;; b = (byte)(b + 1)) {
          if (b >= this.cloud.length)
            return; 
          if (isNpcSrc(this.cloud[b][0], this.cloud[b][1])) {
            addCloud(b);
          } else {
            short[] arrayOfShort = this.cloud[b];
            arrayOfShort[0] = (short)(arrayOfShort[0] - this.cloud[b][2]);
          } 
        } 
        break;
      } 
      Ui.i().drawImage(this.imgCloud, this.cloud[b][0], this.cloud[b][1] - this.srcY, 0);
    } 
  }
  
  private void drawEnd() {
    int i = (640 - 70) / 35;
    Ui.i().drawModuleOne(this.sp[1], 0, 0, 40 - this.srcY, 0, 0);
    for (byte b = 0;; b++) {
      if (b >= i + 1) {
        Ui.i().drawModuleOne(this.sp[1], 0, 640, 40 - this.srcY, 1, 0);
        return;
      } 
      Ui.i().drawModuleOne(this.sp[1], 1, b * 35 + 35, 44 - this.srcY, 0, 0);
    } 
  }
  
  private void drawGame() {
    Ui.i().fillRect(5423359, 0, 0, 640, 360);
    drawCloud();
    drawEnd();
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= this.length) {
        if (this.state == 3 && this.time != 0)
          Ui.i().drawNum(this.time / 20, 320 - 5, 180, 0, 2); 
        return;
      } 
      Ui.i().drawNum(b + 1, b * 100 + 125 + 22, 20 - this.srcY, 1, 2);
      Ui.i().drawActionOne(this.sp[0], 1, b * 100 + 125 + 22, this.monY[b] - this.srcY, this.now_a[b], 0, true);
    } 
  }
  
  private boolean isNpcSrc(int paramInt1, int paramInt2) {
    return !(paramInt1 >= -40 && paramInt2 - this.srcY <= Constants_H.HEIGHT + 20);
  }
  
  private void nullGame() {
    this.sp = null;
    this.myDate = null;
    this.money = null;
    this.now_a = null;
    this.monY = null;
    this.imgCloud = null;
    this.cloud = null;
    this.gDate = null;
  }
  
  private void setSpeed() {
    if (this.speedLv < this.gDate.length) {
      byte b = 0;
      while (true) {
        if (b < 4 && this.monY[b] > this.gDate[this.speedLv][0]) {
          b = (byte)(b + 1);
          continue;
        } 
        if (b < 4) {
          for (b = 0;; b = (byte)(b + 1)) {
            if (b >= 4) {
              this.speedLv = (byte)(this.speedLv + 1);
              return;
            } 
            byte[] arrayOfByte = this.now_a[b];
            Ms.i();
            arrayOfByte[2] = (byte)(Ms.getRandom(this.gDate[this.speedLv][1]) + this.gDate[this.speedLv][1]);
          } 
          break;
        } 
        // Byte code: goto -> 12
      } 
    } 
  }
  
  public void go(int paramInt) {
    if (paramInt < 1) {
      this.sel = 0;
      this.state = 0;
      this.length = 3;
      this.gr.setStringB("一注：#n投入100金，#n获胜得120金。#n二注：#n投入300金，#n获胜得350金。#n三注：#n投入1000金，#n获胜得1200金。", Constants_H.WIDTH - 50, 0);
      this.gr.setStringB("一注100金#n二注300金#n三注1000金", Constants_H.WIDTH - 50, 1);
      return;
    } 
    if (paramInt == 1) {
      this.myDate[0] = this.sel;
      this.sel = 0;
      this.state = 1;
      this.length = 4;
      return;
    } 
    if (paramInt == 2) {
      this.myDate[1] = this.sel;
      this.sel = 0;
      this.state = 2;
      return;
    } 
    if (paramInt == 3) {
      this.myDate[2] = this.sel;
      this.sel = 0;
      this.state = 3;
      this.srcY = 90;
      this.speedLv = 0;
      this.myDate[3] = -1;
      this.time = 70;
      for (paramInt = 0;; paramInt = (byte)(paramInt + 1)) {
        if (paramInt >= this.length) {
          paramInt = 0;
          while (true) {
            if (paramInt < this.cloud.length) {
              addCloud(paramInt);
              paramInt = (byte)(paramInt + 1);
              continue;
            } 
            return;
          } 
          break;
        } 
        this.monY[paramInt] = 450;
      } 
    } 
  }
  
  public void go(int paramInt1, int paramInt2) {
    this.lv = (byte)paramInt2;
    this.sp = new Sprite[3];
    this.sp[0] = Ms.i().createSprite("data/npc0/67", true);
    this.sp[1] = Ms.i().createSprite("data/brow/m1", true);
    this.imgCloud = Ms.i().createImage("data/cloud");
    go(paramInt1);
  }
  
  public boolean key() {
    if (Ms.i().key_delay())
      return false; 
    if (this.state == 0) {
      if (Ms.i().key_Up_Down()) {
        this.sel = Ms.i().select(this.sel, 0, this.length - 1);
      } else if (Ms.i().key_S1_Num5() && this.gr.isMoney(this.money[this.sel << 1], true)) {
        go(1);
      } else if (Ms.i().key_S2()) {
        nullGame();
        return true;
      } 
    } else if (this.state == 1) {
      if (Ms.i().key_Left_Right()) {
        this.sel = Ms.i().select(this.sel, 0, this.length - 1);
      } else if (Ms.i().key_S1_Num5()) {
        go(2);
      } 
    } else if (this.state == 2) {
      if (Ms.i().key_Left_Right()) {
        this.sel = Ms.i().select(this.sel, 0, this.length - 1);
      } else if (Ms.i().key_S1_Num5() && this.gr.isMoney(this.sel * 10, true)) {
        go(3);
      } else if (Ms.i().key_S2()) {
        this.sel = this.myDate[1];
        this.state = 1;
      } 
    } 
    return false;
  }
  
  public void patin() {
    if (this.state == 0 || this.state == 1 || this.state == 2) {
      draw0(10, 5, 325, 25);
      if (this.state == 1 || this.state == 2)
        draw1(198, 15, 76); 
      return;
    } 
    drawGame();
  }
  
  public void run() {
    if (this.state == 3) {
      if (this.time == 0) {
        setSpeed();
        if (this.myDate[3] != -1) {
          this.time = 5;
          this.state = 4;
          return;
        } 
        byte b2 = -1;
        for (byte b1 = 0;; b1 = (byte)(b1 + 1)) {
          if (b1 >= 4) {
            if (b2 != -1)
              this.srcY = (short)(this.srcY - this.now_a[b2][2]); 
            if (this.srcY < 0)
              this.srcY = 0; 
            return;
          } 
          short[] arrayOfShort = this.monY;
          arrayOfShort[b1] = (short)(arrayOfShort[b1] - this.now_a[b1][2]);
          if (this.monY[b1] - this.srcY < Constants_H.HEIGHT_H)
            b2 = b1; 
          if (this.monY[b1] < 70 && this.myDate[3] == -1)
            this.myDate[3] = b1; 
        } 
      } 
      this.time = (byte)(this.time - 1);
      return;
    } 
    if (this.state == 4) {
      if (this.time == 3)
        if (this.myDate[3] == this.myDate[1]) {
          GameRun gameRun = this.gr;
          gameRun.money += this.money[this.myDate[0] * 2 + 1];
          this.gr.say("获得：" + this.money[this.myDate[0] * 2 + 1] + "金", 0);
          byte[] arrayOfByte = this.gr.rmsOther;
          arrayOfByte[4] = (byte)(arrayOfByte[4] | 1 << this.lv);
        } else {
          this.gr.say("不好意思，没有猜对。", 0);
        }  
      if (this.time > 0) {
        this.time = (byte)(this.time - 1);
        return;
      } 
      if (this.time == 0 && this.gr.say_c == 0)
        go(0); 
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/minigame/Racing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */