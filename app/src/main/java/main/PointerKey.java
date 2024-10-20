package main;

import android.util.Log;
import dm.Ms;

public class PointerKey implements Key_H {
  public int[][][] button_pos;
  
  boolean dir;
  
  int gox;
  
  int goy;
  
  GameRun gr;
  
  int i0;
  
  int i1;
  
  boolean isGo;
  
  int m0;
  
  int m1;
  
  Map map;
  
  MainCanvas mc;
  
  int tempx;
  
  int tempy;
  
  public PointerKey(MainCanvas paramMainCanvas) {
    int[] arrayOfInt2 = new int[5];
    arrayOfInt2[1] = Constants_H.HEIGHT - 50;
    arrayOfInt2[2] = 50;
    arrayOfInt2[3] = 50;
    arrayOfInt2[4] = -6;
    int[][] arrayOfInt1 = { arrayOfInt2, { Constants_H.WIDTH - 50, Constants_H.HEIGHT - 50, 50, 50, -7 } };
    int[] arrayOfInt4 = new int[5];
    arrayOfInt4[2] = Constants_H.WIDTH;
    arrayOfInt4[3] = Constants_H.HEIGHT;
    arrayOfInt4[4] = 48;
    int[][] arrayOfInt3 = { arrayOfInt4 };
    int[] arrayOfInt6 = new int[5];
    arrayOfInt6[2] = Constants_H.WIDTH;
    arrayOfInt6[3] = Constants_H.HEIGHT;
    arrayOfInt6[4] = 53;
    int[][] arrayOfInt5 = { arrayOfInt6 };
    int[][] arrayOfInt8 = { { 170, 275, 106, 97, -3 }, { 363, 285, 108, 83, -4 }, { 281, 290, 76, 88, 53 } };
    int[] arrayOfInt9 = new int[5];
    arrayOfInt9[2] = 320;
    arrayOfInt9[3] = 360;
    arrayOfInt9[4] = -3;
    int[] arrayOfInt7 = new int[5];
    arrayOfInt7[0] = 320;
    arrayOfInt7[2] = 320;
    arrayOfInt7[3] = 360;
    arrayOfInt7[4] = -4;
    int[] arrayOfInt11 = { 548, 116, 83, 71, 9999 };
    int[][] arrayOfInt10 = { { 462, 42, 83, 72, 9999 }, arrayOfInt11, { 466, 182, 85, 75, 9999 }, { 524, 266, 91, 68, 9999 }, { 48, 277, 87, 80, 9999 } };
    int[] arrayOfInt15 = { Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60, 60, 60, 9999 };
    int[] arrayOfInt13 = new int[5];
    arrayOfInt13[1] = Constants_H.HEIGHT__ - 60;
    arrayOfInt13[2] = 60;
    arrayOfInt13[3] = 60;
    arrayOfInt13[4] = 9999;
    int[][] arrayOfInt12 = { arrayOfInt15, arrayOfInt13, { Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60 - 120 - 40, 60, 60, 9999 }, { Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60 - 60 - 20, 60, 60, 9999 }, { Constants_H.WIDTH__ - 60 - 120 - 40, Constants_H.HEIGHT__ - 60, 60, 60, 9999 }, { Constants_H.WIDTH__ - 60 - 60 - 20, Constants_H.HEIGHT__ - 60, 60, 60, 9999 }, { Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60 - 180 - 60, 60, 60, 9999 } };
    int[][] arrayOfInt14 = { { Constants_H.WIDTH - 50, Constants_H.HEIGHT - 50, 50, 50, -7 } };
    int[] arrayOfInt17 = new int[5];
    arrayOfInt17[1] = 310;
    arrayOfInt17[2] = 50;
    arrayOfInt17[3] = 50;
    arrayOfInt17[4] = -6;
    int[][] arrayOfInt16 = { arrayOfInt17, { 590, 310, 50, 50, -7 } };
    int[] arrayOfInt19 = new int[5];
    arrayOfInt19[2] = 640;
    arrayOfInt19[3] = 360;
    arrayOfInt19[4] = 48;
    int[][] arrayOfInt18 = { arrayOfInt19 };
    int[] arrayOfInt22 = { Constants_H.WIDTH - 30, Constants_H.HEIGHT - 30, 30, 30, 9999 };
    int[] arrayOfInt24 = new int[5];
    arrayOfInt24[1] = Constants_H.HEIGHT - 30;
    arrayOfInt24[2] = 30;
    arrayOfInt24[3] = 30;
    arrayOfInt24[4] = 9999;
    int[] arrayOfInt25 = { Constants_H.WIDTH - 30, Constants_H.HEIGHT - 30 - 90 - 25, 30, 30, 9999 };
    int[] arrayOfInt26 = { Constants_H.WIDTH - 30, Constants_H.HEIGHT - 30 - 45 - 15, 30, 30, 9999 };
    int[] arrayOfInt21 = { Constants_H.WIDTH - 30 - 90 - 40, Constants_H.HEIGHT - 30, 30, 30, 9999 };
    int j = Constants_H.WIDTH;
    int i = Constants_H.HEIGHT;
    int[] arrayOfInt23 = { Constants_H.WIDTH - 30, Constants_H.HEIGHT - 30 - 135 - 35, 30, 30, 9999 };
    int[][] arrayOfInt20 = { arrayOfInt22, arrayOfInt24, arrayOfInt25, arrayOfInt26, arrayOfInt21, { j - 30 - 45 - 20, i - 30, 30, 30, 9999 }, arrayOfInt23 };
    this.button_pos = new int[][][] { 
        arrayOfInt1, arrayOfInt3, arrayOfInt5, arrayOfInt8, { arrayOfInt9, arrayOfInt7 }, arrayOfInt10, arrayOfInt12, arrayOfInt14, arrayOfInt16, arrayOfInt18, 
        arrayOfInt20 };
    this.i0 = -1;
    this.i1 = -1;
    this.mc = paramMainCanvas;
    this.gr = this.mc.gr;
    this.map = this.gr.map;
  }
  
  private boolean isMove(int paramInt1, int paramInt2) {
    int i;
    int j;
    if (this.map.my.dir == 3) {
      i = this.map.my.x - 20;
      j = this.map.my.y - 60;
    } else if (this.map.my.dir == 4) {
      i = this.map.my.x + 20;
      j = this.map.my.y - 60;
    } else if (this.map.my.dir == 1) {
      i = this.map.my.x;
      j = this.map.my.y - 80;
    } else {
      i = this.map.my.x;
      j = this.map.my.y - 40;
    } 
    return !((Ms.i().isRect(paramInt1, paramInt2, 1, 1, i, j, 20, 80) || Ms.i().isRect(this.i0, this.i1, 1, 1, Constants_H.WIDTH_H - 30, Constants_H.HEIGHT - 60, 60, 60)) && this.map.checkSoftKey(this.map.my.x, this.map.my.y, this.map.dir_select[this.map.my.dir][0] * this.map.my.speed, this.map.dir_select[this.map.my.dir][1] * this.map.my.speed) != -1);
  }
  
  public int checkButton(int paramInt) {
    return checkButton(paramInt, this.i0, this.i1);
  }
  
  public int checkButton(int paramInt1, int paramInt2, int paramInt3) {
    for (byte b = 0;; b++) {
      if (b >= (this.button_pos[paramInt1]).length)
        return -1; 
      if (Ms.i().isRect(paramInt2 - 1, paramInt3 - 1, 2, 2, this.button_pos[paramInt1][b][0], this.button_pos[paramInt1][b][1], this.button_pos[paramInt1][b][2], this.button_pos[paramInt1][b][3])) {
        Ms.key = this.button_pos[paramInt1][b][4];
        if (paramInt1 == 3 && Ms.key == 53)
          Log.e("touch", "按下确定键。。。menu_state: " + this.mc.menu_state); 
        Ms.keyRepeat = true;
        initPointer();
        return b;
      } 
    } 
  }
  
  public void initPointer() {
    this.i1 = -1;
    this.i0 = -1;
    this.m1 = -1;
    this.m0 = -1;
  }
  
  public boolean isSelect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (Ms.i().isRect(this.i0, this.i1, 1, 1, paramInt1, paramInt2, paramInt3, paramInt4)) {
      initPointer();
      return true;
    } 
    return false;
  }
  
  public void process(int paramInt1, int paramInt2) {
    if (this.map.my.state == 20 && checkButton(7, paramInt1, paramInt2) != -1);
    if ((GameRun.run_state != -10 || (this.map.my.state != 0 && this.map.my.state != 20)) && ((GameRun.run_state == -10) ? (((this.map.my.state == 18 || this.map.my.state == 17) && checkButton(8, paramInt1, paramInt2) != -1) || (this.map.my.state != 18 && this.map.my.state != 17 && checkButton(0, paramInt1, paramInt2) != -1)) : (GameRun.run_state != -10 && checkButton(8, paramInt1, paramInt2) != -1)));
    switch (this.mc.game_state) {
      default:
        return;
      case 30:
        runKeySate(paramInt1, paramInt2);
      case 98:
        checkButton(9, paramInt1, paramInt2);
        Log.d("soars", "checkButton");
      case 40:
        break;
    } 
    switch (this.mc.menu_state) {
      default:
      
      case 0:
        break;
    } 
    if (this.mc.load_c == 1) {
      this.i0 = paramInt1;
      this.i1 = paramInt2;
      checkButton(3, paramInt1, paramInt2);
    } 
    checkButton(9, paramInt1, paramInt2);
  }
  
  public void runKeySate(int paramInt1, int paramInt2) {
    switch (GameRun.run_state) {
      default:
        return;
      case 60:
      case 98:
        checkButton(1, paramInt1, paramInt2);
      case -10:
        this.i0 = paramInt1;
        this.i1 = paramInt2;
        if (this.map.my.state == 22) {
          if (this.gr.say_c < 0)
            checkButton(2, paramInt1, paramInt2); 
          checkButton(1, paramInt1, paramInt2);
        } 
        if (this.map.my.state == 1 || this.map.my.state == 10)
          checkButton(2, paramInt1, paramInt2); 
        if (this.map.my.state == 0) {
          if (this.gr.say_c == -1) {
            checkButton(2, paramInt1, paramInt2);
          } else if (this.gr.say_s == 0 && this.gr.say_c == 0 && isMove(-this.map.map_x + paramInt1, -this.map.map_y + paramInt2)) {
            setMove(paramInt1, paramInt2);
          } 
          this.i0 = paramInt1;
          this.i1 = paramInt2;
        } 
        if (this.map.my.state == 12 || this.map.my.state == 18 || this.map.my.state == 17 || this.map.my.state == 16 || this.map.my.state == 20 || this.map.my.state == 2) {
          this.i0 = paramInt1;
          this.i1 = paramInt2;
        } 
      case -20:
      case 18:
      case 25:
      case 35:
      case 61:
      case 65:
      case 66:
      case 68:
      case 97:
        this.i0 = paramInt1;
        this.i1 = paramInt2;
      case 69:
        this.i0 = paramInt1;
        this.i1 = paramInt2;
      case -31:
        break;
    } 
    if (this.gr.battle_state == 2) {
      this.gr.cur_a = (byte)checkButton(5, paramInt1, paramInt2);
      if (this.gr.cur_a != -1)
        setKey5(); 
    } 
    this.i0 = paramInt1;
    this.i1 = paramInt2;
  }
  
  public void runMove() {
    if (GameRun.run_state == -10 && this.map.my.state == 0 && this.m0 != -1) {
      byte b;
      int j = this.m0 - this.map.my.x;
      int i = this.m1 - this.map.my.y;
      if (Ms.abs(j) < this.map.my.speed && Ms.abs(i) < this.map.my.speed) {
        stopMove();
        return;
      } 
      if (this.dir) {
        if (Ms.abs(i) < this.map.my.speed) {
          b = 1;
        } else {
          b = 0;
        } 
      } else if (Ms.abs(j) >= this.map.my.speed) {
        b = 1;
      } else {
        b = 0;
      } 
      if (b) {
        if (j < 0) {
          b = -3;
        } else {
          b = -4;
        } 
        Ms.key = b;
      } else {
        if (i < 0) {
          b = -1;
        } else {
          b = -2;
        } 
        Ms.key = b;
      } 
      this.map.map_key = (byte)-Ms.key;
      this.map.doKey();
    } 
  }
  
  public void selectListSY(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    for (paramInt5 = 0;; paramInt5++) {
      if (paramInt5 >= paramInt1)
        return; 
      if (Ms.i().isRect(this.i0, this.i1, 1, 1, paramInt2, paramInt3 + (paramInt6 + paramInt7) * paramInt5, paramInt4, paramInt6)) {
        this.gr.selecty = (byte)paramInt5;
        if (paramInt5 == paramInt8)
          setKey5(); 
        initPointer();
      } 
    } 
  }
  
  public byte selectMenuX(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    for (byte b = 0;; b++) {
      if (b >= paramInt1)
        return -1; 
      if (Ms.i().isRect(this.i0, this.i1, 1, 1, paramInt2 + b * paramInt4, paramInt3, paramInt4, paramInt5)) {
        initPointer();
        return (byte)b;
      } 
    } 
  }
  
  public void setKey5() {
    Ms.key = 53;
    Ms.keyRepeat = true;
  }
  
  public void setKeySoftkey1() {
    Ms.key = -6;
    Ms.keyRepeat = true;
  }
  
  public void setMove(int paramInt1, int paramInt2) {
    boolean bool;
    this.m0 = (-this.map.map_x + paramInt1) / 20 * 20;
    this.m1 = (-this.map.map_y + paramInt2) / 20 * 20;
    if (Ms.abs(this.m0 - this.map.my.x) < Ms.abs(this.m1 - this.map.my.y)) {
      bool = true;
    } else {
      bool = false;
    } 
    this.dir = bool;
    this.isGo = true;
    this.tempx = paramInt1;
    this.tempy = paramInt2;
    this.gox = -this.map.map_x + this.tempx;
    this.goy = -this.map.map_y + this.tempy;
  }
  
  public void stopMove() {
    Ms.i().keyRelease();
    initPointer();
    this.isGo = false;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/main/PointerKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */