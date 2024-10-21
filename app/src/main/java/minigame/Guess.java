package minigame;

import dm.Ms;
import dm.Sprite;
import dm.Ui;
import javax.microedition.lcdui.Image;
import main.Constants_H;
import main.GameRun;

public class Guess implements MiniGame_H {
  final short BOX_Y1 = 150;
  
  final short MON_Y = 165;
  
  final short TIME = 20;
  
  final short TIME2 = 40;
  
  private byte b_win;
  
  private int[][] box;
  
  private byte[] boxNum;
  
  private byte[][] gameData;
  
  private byte gameR = 0;
  
  GameRun gr;
  
  private Image[] imgBox;
  
  private Sprite[] imgMon;
  
  private byte length;
  
  private byte lv;
  
  private byte maxTransNum = 20;
  
  private byte mon_size_move = 0;
  
  byte sel;
  
  private int sell_money;
  
  private byte state = 0;
  
  private byte tempTransNum = 0;
  
  private byte time;
  
  private byte transNum = 0;
  
  private byte winNum = 0;
  
  public Guess(GameRun paramGameRun) {
    this.gr = paramGameRun;
  }
  
  private void draw() {
    if (this.state == 0) {
      Ui.i().drawString("游戏规则", 320, 4, 17, 3, 1);
      Ui.i().drawUi(7, 320 - 75, 27, 40, 0);
      Ui.i().drawUi(7, 320 + 75, 27, 36, 4);
    } 
    int i = 29 * 10;
    Ui.i().drawK(10, 25 + 10, 200, i, 4);
    Ui.i().drawK(10 + 200 + 10, 25 + 10, 200, i, 4);
    Ui.i().drawK(10 + 420, 25 + 10, 200, i, 4);
    Ui.i().drawStringY(this.gr.about_a, 10 + 6, 25 + 10, 29, 0, 0);
    if (this.state == 0) {
      this.gr.showStringM("需要的参加费：" + this.sell_money + "金", 320, 25 + 290 - 50, 7, 0);
      Ui.i().drawListKY(2, 10 + 200 + 12 + 25, 25 + 75 + 5, 200 - 50, 3, 30, 10, this.sel, 4, 2);
      i = 0;
      while (true) {
        if (i < this.gr.about_b.length) {
          byte b;
          Ui ui = Ui.i();
          String str = this.gr.about_b[i].toString();
          if (this.sel == i) {
            b = 0;
          } else {
            b = 3;
          } 
          ui.drawString(str, 10 + 200 + 15 + 25 + 26, i * 40 + 105 - 2, 0, b, 1);
          if (this.gr.pkey.isSelect(10 + 200 + 12 + 25, i * 40 + 105 - 2, 200 - 50, 40))
            if (this.sel == i) {
              this.gr.pkey.setKey5();
            } else {
              this.sel = (byte)i;
            }  
          i++;
          continue;
        } 
        if (this.state == 0)
          Ui.i().drawYesNo(true, true); 
        this.gr.drawMoney(320, 360, 3, false);
        return;
      } 
    } 
    if (this.state == 0)
      Ui.i().drawYesNo(true, true); 
    this.gr.drawMoney(320, 360, 3, false);
  }
  
  private void drawGame() {
    Ui.i().drawString("胜利次数：" + this.winNum + "/" + this.gameData[3][this.lv], 320, 4, 17, 3, 1);
    if (this.state == 1) {
      Ui.g.setClip(202, 65, 240, 100);
      for (byte b = 0;; b++) {
        if (b >= this.box.length) {
          Ui.g.setClip(0, 0, 640, 360);
          if (this.time >= 20) {
            b = 0;
            while (true) {
              if (b < this.box.length) {
                Ui.i().drawImage(this.imgBox[1], this.box[b][2] + 202, this.box[b][3], 17);
                b++;
                continue;
              } 
              return;
            } 
            break;
          } 
          continue;
        } 
        if (this.box[b][1] != -1) {
          byte b1;
          int j = this.box[b][1];
          int i = this.box[b][2];
          if (this.time < 40) {
            b1 = 0;
          } else {
            b1 = this.mon_size_move;
          } 
          drawMon(b, j, i + 202, b1 + 165);
        } 
      } 
    } 
    if (this.state == 2) {
      byte b = 0;
      while (true) {
        if (b < this.box.length) {
          Ui.i().drawImage(this.imgBox[1], this.box[b][2] + 202, this.box[b][3], 17);
          b++;
          continue;
        } 
        return;
      } 
    } 
    if (this.state == 3)
      for (byte b = 0;; b++) {
        if (b >= this.box.length) {
          Ui ui = Ui.i();
          Image image = this.imgBox[0];
          int j = this.box[this.gr.selectx][2];
          int i = this.box[this.gr.selectx][3];
          if (this.time % 4 <= 2) {
            b = 5;
          } else {
            b = 0;
          } 
          ui.drawImage(image, j + 202 - 1, i - b, 17);
          byte b1 = (byte)(this.time + 1);
          this.time = b1;
          if (b1 > 20)
            this.time = 0; 
          drawMon(this.box[this.gr.selecty][0], this.box[this.gr.selecty][1], this.gameData[0][1] + 202 + 100, 135);
          this.gr.showStringM("请指出" + this.gr.getNameMon(this.box[this.gr.selecty][1]) + "所在箱子", 202 + 240 + 90, 29 * 5, 6, 0);
          return;
        } 
        if (this.gr.pkey.isSelect(this.box[b][2] + 202 - 20, this.box[b][3], 40, 40)) {
          this.gr.selectx = (byte)b;
          this.gr.pkey.setKey5();
        } 
        Ui.i().drawImage(this.imgBox[1], this.box[b][2] + 202, this.box[b][3], 17);
      }  
    if (this.state == 4) {
      drawMon(this.box[this.gr.selecty][0], this.box[this.gr.selecty][1], this.gameData[0][1] + 202 + 100, 135);
      Ui.i().drawImage(this.imgBox[1], this.box[this.gr.selectx][2] + 202, this.box[this.gr.selectx][3], 17);
      if (this.box[this.gr.selectx][1] != -1)
        drawMon(this.box[this.gr.selectx][0], this.box[this.gr.selectx][1], this.box[this.gr.selectx][2] + 202, this.box[this.gr.selectx][3] + 35); 
      if (this.b_win > 0) {
        this.gr.showStringM("您真厉害！", 202 + 240 + 90, 29 * 5, 6, 0);
      } else {
        this.gr.showStringM("说不定下次就能行的。", 202 + 240 + 90, 29 * 5, 6, 0);
      } 
      this.gr.showStringM("点击屏幕继续", 202 + 240 + 90, 29 * 7, 6, 0);
      if (this.gr.pkey.isSelect(0, 0, 640, 360))
        this.gr.pkey.setKey5(); 
    } 
  }
  
  private void drawMon(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Ui.i().drawFrameOne(this.imgMon[paramInt1], this.imgMon[paramInt1].action(this.gr.mList_id[paramInt2][1] * 3, 0, 0), paramInt3, paramInt4, 0);
  }
  
  private byte[] getGameMonList() {
    byte[] arrayOfByte = new byte[3];
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= arrayOfByte.length) {
        byte b1 = 0;
        label28: while (true) {
          if (b1 >= this.gameData[2][this.lv]) {
            Ms.i();
            b = (byte)Ms.getRandom(2);
            byte b2 = arrayOfByte[arrayOfByte.length - 1];
            arrayOfByte[arrayOfByte.length - 1] = arrayOfByte[b];
            arrayOfByte[b] = b2;
            for (b = 0;; b = (byte)(b + 1)) {
              if (b >= 3)
                return arrayOfByte; 
              if (arrayOfByte[b] != -1) {
                b1 = this.gr.mList_id[arrayOfByte[b]][0];
                this.imgMon[b] = Ms.i().createSprite("data/npc2/" + b1, this.gr.isNpc2ImageType(b1));
              } 
            } 
            break;
          } 
          byte[] arrayOfByte1 = this.gameData[4];
          Ms.i();
          arrayOfByte[b1] = arrayOfByte1[Ms.getRandom((this.gameData[4]).length)];
          for (b = 0;; b = (byte)(b + 1)) {
            if (b >= b1) {
              b1 = (byte)(b1 + 1);
              continue label28;
            } 
            if (arrayOfByte[b] == arrayOfByte[b1]) {
              arrayOfByte1 = this.gameData[4];
              Ms.i();
              arrayOfByte[b1] = arrayOfByte1[Ms.getRandom((this.gameData[4]).length)];
              b = 0;
              continue;
            } 
          } 
          break;
        } 
      } 
      arrayOfByte[b] = -1;
    } 
  }
  
  private void initGame() {
    byte[] arrayOfByte = getGameMonList();
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= 3) {
        arrayOfByte = (byte[])null;
        Ms.i();
        this.maxTransNum = (byte)(Ms.getRandom(this.lv + 2) + 2 + this.lv);
        this.transNum = 0;
        this.mon_size_move = 0;
        return;
      } 
      this.box[b][0] = b;
      this.box[b][1] = arrayOfByte[b];
      this.box[b][2] = this.gameData[0][b] + 100;
      this.box[b][3] = 0;
    } 
  }
  
  private byte win() {
    null = (byte)(this.winNum + 1);
    this.winNum = null;
    if (null >= this.gameData[3][this.lv]) {
      int i = this.sell_money + this.lv * this.lv * 150 + (2 - this.lv) * 25;
      GameRun gameRun = this.gr;
      gameRun.money += i;
      this.gr.say("获得金钱：" + i, 0);
      byte[] arrayOfByte = this.gr.rmsOther;
      arrayOfByte[10] = (byte)(arrayOfByte[10] | 1 << this.lv);
      if (this.lv == 2 && this.gr.rmsOther[11] < 3) {
        arrayOfByte = this.gr.rmsOther;
        arrayOfByte[11] = (byte)(arrayOfByte[11] + 1);
      } 
      return 2;
    } 
    return 3;
  }
  
  public void go(int paramInt) {
    if (paramInt < 1) {
      this.b_win = 0;
      this.gr.selecty = 0;
      this.gr.selectx = 0;
      this.winNum = 0;
      this.state = 0;
      this.gr.buyOk = 0;
      this.gr.line_max = 9;
      this.sell_money = this.lv * 200 + 200;
      this.length = (byte)(this.gr.about_a.length - this.gr.line_max);
      return;
    } 
    this.time = 0;
    this.state = 1;
    initGame();
  }
  
  public void go(int paramInt1, int paramInt2) {
    this.gr.setStringB(this.gr.createString("data/gamed.d"), 180, 0);
    this.gr.setStringB("开始游戏#n离开游戏", Constants_H.WIDTH, 1);
    this.lv = (byte)paramInt2;
    this.imgBox = new Image[2];
    this.imgBox[0] = Ms.i().createImage("data/brow/m2");
    this.imgBox[1] = Ms.i().createImage("data/brow/m3");
    this.boxNum = new byte[2];
    byte[] arrayOfByte3 = { -60, 17, 90 };
    byte[] arrayOfByte2 = { 1, 2, 3, 3 };
    byte[] arrayOfByte4 = { 6, 4, 2, 2 };
    byte[] arrayOfByte1 = { 83, 30, 55 };
    this.gameData = new byte[][] { arrayOfByte3, { 8, 13, 20, 30 }, arrayOfByte2, arrayOfByte4, arrayOfByte1 };
    this.box = new int[3][4];
    this.imgMon = new Sprite[3];
    go(paramInt1);
  }
  
  public boolean key() {
    if (Ms.i().key_delay())
      return false; 
    if (this.state == 0) {
      if (Ms.i().key_Up_Down()) {
        this.sel = (byte)(this.sel ^ 0x1);
      } else if (Ms.i().key_S1_Num5()) {
        Ms.i().keyRelease();
        if (this.sel == 0 && this.gr.isMoney(this.sell_money, true)) {
          go(1, this.lv);
        } else if (this.sel == 1) {
          Ms.i().keyRelease();
          this.gr.about_a = null;
          this.imgBox = null;
          this.boxNum = null;
          this.gameData = null;
          this.box = null;
          this.imgMon = null;
          return true;
        } 
      } else if (Ms.i().key_S2()) {
        Ms.i().keyRelease();
        this.gr.about_a = null;
        this.imgBox = null;
        this.boxNum = null;
        this.gameData = null;
        this.box = null;
        this.imgMon = null;
        return true;
      } 
    } else if (this.state == 3) {
      if (Ms.i().key_Left_Right()) {
        this.gr.selectx = Ms.i().select(this.gr.selectx, 0, this.box.length - 1);
      } else if (Ms.i().key_S1_Num5()) {
        byte b;
        Ms.i().keyRelease();
        this.state = 4;
        if (this.gr.selectx == this.gr.selecty) {
          b = 1;
        } else {
          b = -1;
        } 
        this.b_win = (byte)b;
      } 
    } else if (this.state == 4 && Ms.i().key_S1_Num5()) {
      Ms.i().keyRelease();
      if (this.b_win == 1) {
        this.b_win = win();
        if (this.b_win == 3)
          go(1, this.lv); 
      } else if (this.b_win == -1 || (this.b_win == 2 && this.gr.say_c == 0)) {
        if (this.b_win == 2 && this.gr.rmsOther[11] == 3) {
          this.gr.rmsOther[11] = 4;
          this.gr.getMonster(83, 25, 0, -1);
        } else if (this.b_win == -1 && this.gr.rmsOther[11] < 3) {
          this.gr.rmsOther[11] = 0;
        } 
        go(0, this.lv);
      } 
    } 
    return false;
  }
  
  public void patin() {
    Ui.i().fillRectB();
    draw();
    if (this.state != 0)
      drawGame(); 
  }
  
  public void run() {
    if (this.state == 1) {
      if (this.time < 20) {
        this.time = (byte)(this.time + 1);
        return;
      } 
      if (this.box[0][3] < 150) {
        byte b1 = 0;
        while (true) {
          if (b1 < 3) {
            int[] arrayOfInt = this.box[b1];
            arrayOfInt[3] = arrayOfInt[3] + 25;
            b1 = (byte)(b1 + 1);
            continue;
          } 
          return;
        } 
      } 
      byte b = (byte)(this.time + 1);
      this.time = b;
      if (b >= 40) {
        if (this.mon_size_move < 40) {
          this.mon_size_move = (byte)(this.mon_size_move + 5);
          return;
        } 
        this.state = 2;
        this.time = 0;
      } 
      return;
    } 
    if (this.state == 2) {
      if (this.time <= 0) {
        if (this.transNum < this.maxTransNum) {
          this.time = 1;
          this.transNum = (byte)(this.transNum + 1);
          byte[] arrayOfByte = this.boxNum;
          Ms.i();
          arrayOfByte[0] = (byte)Ms.getRandom(3);
          while (true) {
            arrayOfByte = this.boxNum;
            Ms.i();
            arrayOfByte[1] = (byte)Ms.getRandom(3);
            if (this.boxNum[1] != this.boxNum[0]) {
              if (this.box[this.boxNum[1]][2] < this.box[this.boxNum[0]][2]) {
                this.gameR = this.boxNum[1];
                this.boxNum[1] = this.boxNum[0];
                this.boxNum[0] = this.gameR;
              } 
              Ms.i();
              this.gameR = (byte)(Ms.abs(this.box[this.boxNum[1]][2] - this.box[this.boxNum[0]][2]) / 2);
              this.tempTransNum = (byte)(this.gameR * 2 / this.gameData[1][this.lv]);
              return;
            } 
          } 
        } 
        this.time = 0;
        this.state = 3;
        while (true) {
          GameRun gameRun = this.gr;
          Ms.i();
          gameRun.selecty = (byte)Ms.getRandom(this.box.length);
          if (this.box[this.gr.selecty][1] != -1)
            return; 
        } 
      } 
      if (this.time > this.tempTransNum) {
        this.time = 0;
        int[] arrayOfInt1 = new int[4];
        byte b = 0;
        label61: while (true) {
          if (b >= this.box.length) {
            b = 0;
            while (true) {
              if (b < 3) {
                this.box[b][2] = this.gameData[0][b] + 100;
                this.box[b][3] = 150;
                b = (byte)(b + 1);
                continue;
              } 
              return;
            } 
            break;
          } 
          for (byte b1 = 0;; b1 = (byte)(b1 + 1)) {
            if (b1 >= this.box.length) {
              b = (byte)(b + 1);
              continue label61;
            } 
            if (this.box[b1][2] > this.box[b][2]) {
              System.arraycopy(this.box[b], 0, arrayOfInt1, 0, arrayOfInt1.length);
              System.arraycopy(this.box[b1], 0, this.box[b], 0, (this.box[b1]).length);
              System.arraycopy(arrayOfInt1, 0, this.box[b1], 0, arrayOfInt1.length);
            } 
          } 
          break;
        } 
      } 
      this.time = (byte)(this.time + 1);
      int[] arrayOfInt = this.box[this.boxNum[0]];
      arrayOfInt[2] = arrayOfInt[2] + this.gameR * 2 / this.tempTransNum;
      int i = this.gameR * 2 / this.tempTransNum * this.time;
      this.box[this.boxNum[0]][3] = 150 - Ms.i().sqrt(this.gameR * this.gameR - (i - this.gameR) * (i - this.gameR));
      arrayOfInt = this.box[this.boxNum[1]];
      arrayOfInt[2] = arrayOfInt[2] - this.gameR * 2 / this.tempTransNum;
      this.box[this.boxNum[1]][3] = Ms.i().sqrt(this.gameR * this.gameR - (i - this.gameR) * (i - this.gameR)) + 150;
      return;
    } 
    if (this.state == 4 && ((this.gr.selectx == 2 && this.box[this.gr.selectx][2] > this.gameData[0][1] + 100) || (this.gr.selectx == 0 && this.box[this.gr.selectx][2] < this.gameData[0][1] + 100))) {
      int[] arrayOfInt = this.box[this.gr.selectx];
      arrayOfInt[2] = arrayOfInt[2] + (this.gameData[0][1] - this.gameData[0][this.gr.selectx]) / 7;
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/minigame/Guess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */