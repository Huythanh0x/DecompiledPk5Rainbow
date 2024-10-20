package minigame;

import dm.Ms;
import dm.Ui;
import main.Constants_H;
import main.GameRun;

public class Cards implements MiniGame_H {
  private short count;
  
  private byte[][] findC;
  
  private byte[][] findN;
  
  private byte find_count = 3;
  
  private short gh = 40;
  
  GameRun gr;
  
  private short gspace = 4;
  
  private short gw = 30;
  
  private short gx;
  
  private short gy;
  
  private short hh = 160;
  
  private byte length;
  
  private byte lv;
  
  private byte[][] num;
  
  byte sel;
  
  private int sell_money;
  
  private byte selx;
  
  private byte sely;
  
  private byte state;
  
  private byte time = 3;
  
  private byte tx;
  
  private byte ty;
  
  private short wh = 320;
  
  public Cards(GameRun paramGameRun) {
    byte[] arrayOfByte1 = { 3, 4 };
    byte[] arrayOfByte2 = { 4, 6 };
    this.num = new byte[][] { arrayOfByte1, { 3, 6 }, arrayOfByte2, { 5, 6 } };
    this.gr = paramGameRun;
  }
  
  private void drawCard(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (paramInt5 == 0) {
      Ui.i().drawK(paramInt3, paramInt4, this.gw, this.gh, 1);
      Ui.i().drawUi(25, (this.gw >> 1) + paramInt3, (this.gh >> 1) + paramInt4, 3, 0);
      return;
    } 
    if (paramInt5 == 1) {
      Ui.i().drawK((this.gw >> 1) + paramInt3 - 2, paramInt4 - 3, 5, this.gh + 6, 1);
      byte[] arrayOfByte = this.findC[paramInt1];
      byte b = (byte)(arrayOfByte[paramInt2] + 1);
      arrayOfByte[paramInt2] = b;
      if (b > 3)
        this.findC[paramInt1][paramInt2] = 0; 
      return;
    } 
    Ui.i().drawK(paramInt3, paramInt4, this.gw, this.gh, 5);
    this.gr.drawItem(this.findN[paramInt1][paramInt2], (this.gw >> 1) + paramInt3, (this.gh >> 1) + paramInt4, 3);
    Ui.i().drawNum(this.findN[paramInt1][paramInt2], this.gw + paramInt3, this.gh + paramInt4, 40, 0);
  }
  
  private void drawGame(int paramInt1, int paramInt2, int paramInt3) {
    paramInt1 = 0;
    label31: while (true) {
      if (paramInt1 >= this.findN.length) {
        Ui.i().drawRectZ(15400191, this.wh + this.gx + this.tx * (this.gw + this.gspace), this.hh + this.gy + this.ty * (this.gh + this.gspace), this.gw, this.gh, 3);
        if (this.count > 0) {
          Ui.i().drawNum(this.count / 10, 320 + 10, 29, 36, 2);
          return;
        } 
      } else {
        for (paramInt2 = 0;; paramInt2++) {
          if (paramInt2 >= (this.findN[paramInt1]).length) {
            paramInt1++;
            continue label31;
          } 
          short s5 = this.wh;
          short s6 = this.gx;
          short s4 = this.gw;
          short s3 = this.gspace;
          short s7 = this.hh;
          short s1 = this.gy;
          short s8 = this.gh;
          short s2 = this.gspace;
          if (this.findC[paramInt1][paramInt2] == 3) {
            paramInt3 = 1;
          } else {
            paramInt3 = this.findC[paramInt1][paramInt2];
          } 
          drawCard(paramInt1, paramInt2, (s4 + s3) * paramInt2 + s5 + s6, (s8 + s2) * paramInt1 + s7 + s1, paramInt3);
          if (this.gr.pkey.isSelect(this.wh + this.gx + (this.gw + this.gspace) * paramInt2, this.hh + this.gy + (this.gh + this.gspace) * paramInt1, this.gw + this.gspace, this.gh + this.gspace) && this.state < 3) {
            this.tx = (byte)paramInt2;
            this.ty = (byte)paramInt1;
            this.gr.pkey.setKey5();
          } 
        } 
        break;
      } 
      Ui.i().drawString("游戏开始", 320, 4, 17, 3, 0);
      GameRun gameRun = this.gr;
      StringBuilder stringBuilder = new StringBuilder("可错次数：");
      if (this.time < 0) {
        paramInt1 = 0;
      } else {
        paramInt1 = this.time - 1;
      } 
      gameRun.showStringM(stringBuilder.append(paramInt1).append("次").toString(), 320 + 200, 180 - 75, 5, 0);
      return;
    } 
  }
  
  private void nullGame() {
    this.findN = null;
    this.findC = null;
    this.num = null;
  }
  
  public void draw0(int paramInt1, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: invokestatic i : ()Ldm/Ui;
    //   3: invokevirtual fillRectB : ()V
    //   6: invokestatic i : ()Ldm/Ui;
    //   9: iload_1
    //   10: iload_2
    //   11: bipush #25
    //   13: iadd
    //   14: iconst_5
    //   15: iadd
    //   16: sipush #200
    //   19: bipush #10
    //   21: isub
    //   22: iload_3
    //   23: iconst_4
    //   24: invokevirtual drawK : (IIIII)V
    //   27: invokestatic i : ()Ldm/Ui;
    //   30: iload_1
    //   31: sipush #200
    //   34: iadd
    //   35: iload_2
    //   36: bipush #25
    //   38: iadd
    //   39: iconst_5
    //   40: iadd
    //   41: sipush #200
    //   44: bipush #20
    //   46: iadd
    //   47: iload_3
    //   48: iconst_4
    //   49: invokevirtual drawK : (IIIII)V
    //   52: invokestatic i : ()Ldm/Ui;
    //   55: iload_1
    //   56: sipush #420
    //   59: iadd
    //   60: bipush #10
    //   62: iadd
    //   63: iload_2
    //   64: bipush #25
    //   66: iadd
    //   67: iconst_5
    //   68: iadd
    //   69: sipush #200
    //   72: bipush #10
    //   74: isub
    //   75: iload_3
    //   76: iconst_4
    //   77: invokevirtual drawK : (IIIII)V
    //   80: aload_0
    //   81: getfield state : B
    //   84: ifne -> 156
    //   87: invokestatic i : ()Ldm/Ui;
    //   90: ldc '游戏规则'
    //   92: sipush #320
    //   95: iload_2
    //   96: bipush #25
    //   98: iadd
    //   99: iconst_5
    //   100: iadd
    //   101: bipush #33
    //   103: iconst_3
    //   104: iconst_1
    //   105: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   108: invokestatic i : ()Ldm/Ui;
    //   111: bipush #7
    //   113: sipush #320
    //   116: bipush #50
    //   118: isub
    //   119: bipush #7
    //   121: iadd
    //   122: iload_2
    //   123: bipush #25
    //   125: iadd
    //   126: bipush #40
    //   128: iconst_0
    //   129: invokevirtual drawUi : (IIIII)V
    //   132: invokestatic i : ()Ldm/Ui;
    //   135: bipush #7
    //   137: sipush #320
    //   140: bipush #50
    //   142: iadd
    //   143: bipush #7
    //   145: iadd
    //   146: iload_2
    //   147: bipush #25
    //   149: iadd
    //   150: bipush #36
    //   152: iconst_4
    //   153: invokevirtual drawUi : (IIIII)V
    //   156: invokestatic i : ()Ldm/Ui;
    //   159: aload_0
    //   160: getfield gr : Lmain/GameRun;
    //   163: getfield about_a : [Ljava/lang/StringBuffer;
    //   166: bipush #25
    //   168: iload_2
    //   169: bipush #25
    //   171: iadd
    //   172: bipush #10
    //   174: iadd
    //   175: bipush #25
    //   177: iconst_0
    //   178: iconst_0
    //   179: invokevirtual drawStringY : ([Ljava/lang/StringBuffer;IIIII)V
    //   182: aload_0
    //   183: getfield state : B
    //   186: ifne -> 291
    //   189: aload_0
    //   190: getfield gr : Lmain/GameRun;
    //   193: new java/lang/StringBuilder
    //   196: dup
    //   197: ldc '需要的参加费：'
    //   199: invokespecial <init> : (Ljava/lang/String;)V
    //   202: aload_0
    //   203: getfield sell_money : I
    //   206: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   209: ldc '金'
    //   211: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual toString : ()Ljava/lang/String;
    //   217: sipush #320
    //   220: iload_2
    //   221: iload_3
    //   222: iadd
    //   223: bipush #50
    //   225: isub
    //   226: bipush #7
    //   228: iconst_0
    //   229: invokevirtual showStringM : (Ljava/lang/String;IIII)V
    //   232: iload_2
    //   233: bipush #75
    //   235: iadd
    //   236: iconst_5
    //   237: iadd
    //   238: istore #4
    //   240: invokestatic i : ()Ldm/Ui;
    //   243: iconst_2
    //   244: iload_1
    //   245: sipush #200
    //   248: iadd
    //   249: bipush #12
    //   251: iadd
    //   252: bipush #25
    //   254: iadd
    //   255: iload #4
    //   257: sipush #200
    //   260: bipush #50
    //   262: isub
    //   263: iconst_3
    //   264: bipush #30
    //   266: bipush #10
    //   268: aload_0
    //   269: getfield sel : B
    //   272: iconst_4
    //   273: iconst_2
    //   274: invokevirtual drawListKY : (IIIIIIIIII)V
    //   277: iconst_0
    //   278: istore_2
    //   279: iload_2
    //   280: aload_0
    //   281: getfield gr : Lmain/GameRun;
    //   284: getfield about_b : [Ljava/lang/StringBuffer;
    //   287: arraylength
    //   288: if_icmplt -> 322
    //   291: aload_0
    //   292: getfield gr : Lmain/GameRun;
    //   295: sipush #320
    //   298: sipush #360
    //   301: iconst_3
    //   302: iconst_0
    //   303: invokevirtual drawMoney : (IIIZ)V
    //   306: aload_0
    //   307: getfield state : B
    //   310: ifne -> 321
    //   313: invokestatic i : ()Ldm/Ui;
    //   316: iconst_1
    //   317: iconst_1
    //   318: invokevirtual drawYesNo : (ZZ)V
    //   321: return
    //   322: invokestatic i : ()Ldm/Ui;
    //   325: astore #5
    //   327: aload_0
    //   328: getfield gr : Lmain/GameRun;
    //   331: getfield about_b : [Ljava/lang/StringBuffer;
    //   334: iload_2
    //   335: aaload
    //   336: invokevirtual toString : ()Ljava/lang/String;
    //   339: astore #6
    //   341: aload_0
    //   342: getfield sel : B
    //   345: iload_2
    //   346: if_icmpne -> 449
    //   349: iconst_0
    //   350: istore_3
    //   351: aload #5
    //   353: aload #6
    //   355: iload_1
    //   356: sipush #200
    //   359: iadd
    //   360: bipush #15
    //   362: iadd
    //   363: bipush #25
    //   365: iadd
    //   366: bipush #26
    //   368: iadd
    //   369: iload_2
    //   370: bipush #40
    //   372: imul
    //   373: iload #4
    //   375: iadd
    //   376: iconst_2
    //   377: isub
    //   378: iconst_0
    //   379: iload_3
    //   380: iconst_1
    //   381: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   384: aload_0
    //   385: getfield gr : Lmain/GameRun;
    //   388: getfield pkey : Lmain/PointerKey;
    //   391: iload_1
    //   392: sipush #200
    //   395: iadd
    //   396: bipush #12
    //   398: iadd
    //   399: bipush #25
    //   401: iadd
    //   402: iload_2
    //   403: bipush #40
    //   405: imul
    //   406: iload #4
    //   408: iadd
    //   409: iconst_2
    //   410: isub
    //   411: sipush #200
    //   414: bipush #50
    //   416: isub
    //   417: bipush #40
    //   419: invokevirtual isSelect : (IIII)Z
    //   422: ifeq -> 443
    //   425: aload_0
    //   426: getfield sel : B
    //   429: iload_2
    //   430: if_icmpne -> 454
    //   433: aload_0
    //   434: getfield gr : Lmain/GameRun;
    //   437: getfield pkey : Lmain/PointerKey;
    //   440: invokevirtual setKey5 : ()V
    //   443: iinc #2, 1
    //   446: goto -> 279
    //   449: iconst_3
    //   450: istore_3
    //   451: goto -> 351
    //   454: aload_0
    //   455: iload_2
    //   456: i2b
    //   457: putfield sel : B
    //   460: goto -> 443
  }
  
  public void go(int paramInt) {
    this.gr.line_max = 9;
    this.count = 100;
    this.time = (byte)(this.lv * 2 + 4);
    this.find_count = (byte)(this.num[this.lv][0] * this.num[this.lv][1] / 2);
    if (paramInt < 1) {
      this.ty = 0;
      this.state = 0;
      this.sell_money = this.lv * 200 + 200;
      return;
    } 
    this.gx = (short)(-((this.gw + this.gspace) * this.num[this.lv][1]) >> 1);
    this.gy = (short)(-((this.gh + this.gspace) * this.num[this.lv][0]) >> 1);
    this.ty = 0;
    this.tx = 0;
    this.state = 1;
    paramInt = 0;
    byte[] arrayOfByte = new byte[this.find_count];
    label44: while (true) {
      if (paramInt >= this.findC.length) {
        paramInt = 0;
        label45: while (true) {
          if (paramInt >= arrayOfByte.length) {
            paramInt = 0;
            label43: while (true) {
              if (paramInt >= arrayOfByte.length) {
                arrayOfByte = (byte[])null;
                return;
              } 
              byte b3 = 0;
              while (true) {
                if (b3 >= 2) {
                  paramInt = (byte)(paramInt + 1);
                  continue label43;
                } 
                while (true) {
                  Ms.i();
                  byte b4 = (byte)Ms.getRandom(this.num[this.lv][0] * this.num[this.lv][1]);
                  if (this.findN[b4 / this.num[this.lv][1]][b4 % this.num[this.lv][1]] == 0) {
                    this.findN[b4 / this.num[this.lv][1]][b4 % this.num[this.lv][1]] = arrayOfByte[paramInt];
                    b3 = (byte)(b3 + 1);
                  } 
                } 
                break;
              } 
              break;
            } 
            break;
          } 
          Ms.i();
          byte b1 = (byte)(Ms.getRandom(35) + 1);
          byte b2 = (byte)(arrayOfByte.length - 1);
          while (true) {
            if (b2 > -1 && arrayOfByte[b2] != b1) {
              b2 = (byte)(b2 - 1);
              continue;
            } 
            if (b2 == -1) {
              arrayOfByte[paramInt] = b1;
              paramInt = (byte)(paramInt + 1);
              continue label45;
            } 
            continue label45;
          } 
          break;
        } 
      } 
      for (byte b = 0;; b = (byte)(b + 1)) {
        if (b >= (this.findC[paramInt]).length) {
          paramInt = (byte)(paramInt + 1);
          continue label44;
        } 
        this.findC[paramInt][b] = 2;
        this.findN[paramInt][b] = 0;
      } 
      break;
    } 
  }
  
  public void go(int paramInt1, int paramInt2) {
    this.gr.setStringB(this.gr.createString("data/gamec.d"), 160, 0);
    this.gr.setStringB("开始游戏#n离开游戏", Constants_H.WIDTH, 1);
    this.lv = (byte)paramInt2;
    this.findN = null;
    paramInt2 = this.num[this.lv][0];
    byte b = this.num[this.lv][1];
    this.findN = new byte[paramInt2][b];
    this.findC = null;
    paramInt2 = this.num[this.lv][0];
    b = this.num[this.lv][1];
    this.findC = new byte[paramInt2][b];
    this.length = 9;
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
          nullGame();
          return true;
        } 
      } else if (Ms.i().key_S2()) {
        Ms.i().keyRelease();
        nullGame();
        return true;
      } 
    } else if (this.state < 3) {
      if (Ms.i().key_Up_Down()) {
        this.ty = Ms.i().select(this.ty, 0, this.findN.length - 1);
      } else if (Ms.i().key_Left_Right()) {
        this.tx = Ms.i().select(this.tx, 0, (this.findN[this.ty]).length - 1);
      } else if (Ms.i().key_S1_Num5()) {
        Ms.i().keyRelease();
        if (this.state == 0) {
          go(0, this.lv);
        } else if (this.findC[this.ty][this.tx] == 0) {
          byte[] arrayOfByte = this.findC[this.ty];
          byte b2 = this.tx;
          arrayOfByte[b2] = (byte)(arrayOfByte[b2] + 1);
          byte b1 = (byte)(this.state + 1);
          this.state = b1;
          if (b1 == 2) {
            this.selx = this.tx;
            this.sely = this.ty;
          } 
        } 
      } 
    } 
    return false;
  }
  
  public void patin() {
    draw0(10, 2, 280);
    if (this.state != 0)
      drawGame(10, 2, (this.length + 3) * 25); 
  }
  
  public void run() {
    if (this.time < 1) {
      if (this.time == 0) {
        this.time = -1;
        this.gr.say("游戏失败！！！", -1);
        return;
      } 
      if (this.time == -1 && this.gr.say_c == 0)
        go(0, this.lv); 
      return;
    } 
    if (this.find_count < 1) {
      if (this.find_count == 0) {
        this.find_count = -1;
        GameRun gameRun = this.gr;
        gameRun.money += this.time * 125 + 100;
        this.gr.say("获得金钱：" + (this.time * 125 + 100), -1);
        byte[] arrayOfByte = this.gr.rmsOther;
        arrayOfByte[8] = (byte)(arrayOfByte[8] | 1 << this.lv);
        return;
      } 
      if (this.find_count == -1 && this.gr.say_c == 0)
        go(0, this.lv); 
      return;
    } 
    if (this.state >= 3) {
      byte b = (byte)(this.state + 1);
      this.state = b;
      if (b > 10) {
        this.state = 1;
        return;
      } 
      if (this.state == 10) {
        if (this.findN[this.ty][this.tx] != this.findN[this.sely][this.selx]) {
          this.findC[this.ty][this.tx] = 3;
          this.findC[this.sely][this.selx] = 3;
          this.time = (byte)(this.time - 1);
          return;
        } 
        this.find_count = (byte)(this.find_count - 1);
      } 
      return;
    } 
    if (this.count > 0) {
      short s = (short)(this.count - 1);
      this.count = s;
      if (s == 0) {
        byte b = 0;
        label41: while (true) {
          if (b < this.findC.length) {
            byte b1;
            for (b1 = 0;; b1 = (byte)(b1 + 1)) {
              if (b1 >= (this.findC[b]).length) {
                b = (byte)(b + 1);
                continue label41;
              } 
              this.findC[b][b1] = 3;
            } 
            break;
          } 
          return;
        } 
      } 
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/minigame/Cards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */