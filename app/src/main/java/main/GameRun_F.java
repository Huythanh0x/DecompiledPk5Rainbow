package main;

import android.util.Log;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import dm.Monster;
import dm.Ms;
import dm.Sound;
import dm.Ui;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class GameRun_F implements Key_H {
  static DirectGraphics dg;
  
  static Graphics g;
  
  public static MainCanvas mc;
  
  static Graphics offG;
  
  public static int run_state = 1;
  
  static Image scrT;
  
  public StringBuffer[] about_a;
  
  public StringBuffer[] about_b;
  
  public StringBuffer[] about_c;
  
  public StringBuffer[] about_d;
  
  public String[] action_str;
  
  final byte[] anchor = new byte[] { 20, 36, 40, 24, 24, 40, 36, 20 };
  
  private byte brow5;
  
  public byte cMon_count;
  
  public Monster[] cMonsters;
  
  public byte cur_a;
  
  public byte cur_b;
  
  public byte cur_c;
  
  public Monster cur_emon;
  
  public Monster cur_mon;
  
  public String gogoST;
  
  public String gogoString;
  
  public byte help_page;
  
  public byte[] info;
  
  public int introT;
  
  public int introX;
  
  public byte[][][] items;
  
  public byte[] itemsLength;
  
  public byte[] len;
  
  public Map map;
  
  public byte max_monsters;
  
  public byte max_takes;
  
  public byte[] monInfoList;
  
  public short move_x;
  
  public short move_y;
  
  public byte myMon_length;
  
  public Monster[] myMonsters;
  
  public byte[][] nidusList;
  
  public byte[] nidusMap;
  
  public byte page_max;
  
  public PointerKey pkey;
  
  public byte popMenu;
  
  public byte[] rmsNidus;
  
  public byte[] rmsOther;
  
  public byte[] rmsSms;
  
  public byte[][] select;
  
  public byte[][] selectBag;
  
  public byte[] select_it;
  
  public byte[] select_st;
  
  public byte selectx;
  
  public byte selecty;
  
  public StringBuffer[] showS;
  
  public byte[] src_c;
  
  public String str_cur;
  
  final short[] transB;
  
  public GameRun_F() {
    short[] arrayOfShort = new short[8];
    arrayOfShort[1] = 90;
    arrayOfShort[2] = 180;
    arrayOfShort[3] = 270;
    arrayOfShort[4] = 8192;
    arrayOfShort[5] = 8282;
    arrayOfShort[6] = 8372;
    arrayOfShort[7] = 8462;
    this.transB = arrayOfShort;
    this.introX = Constants_H.WIDTH_H;
    this.gogoString = "";
    this.introT = 640;
    this.gogoST = "";
    this.brow5 = 0;
    this.page_max = 0;
    this.help_page = 0;
    this.src_c = new byte[4];
    this.popMenu = -1;
    this.select_it = new byte[4];
    this.select_st = new byte[4];
    this.selectBag = new byte[4][2];
    this.select = new byte[2][2];
    this.max_takes = 3;
    this.max_monsters = 10;
  }
  
  private void drawSnare5(int paramInt1, int paramInt2) {
    byte b;
    Ui ui = Ui.i();
    if (this.brow5 % 3 == 0) {
      b = 1;
    } else {
      b = 0;
    } 
    ui.drawUi(8, paramInt1, paramInt2 + b, 0, 0);
    paramInt1 = this.brow5;
    this.brow5 = (byte)(paramInt1 + 1);
    if (paramInt1 > 100)
      this.brow5 = 0; 
  }
  
  public boolean addNidus(int paramInt) {
    byte b = 0;
    while (true) {
      if (b >= this.rmsNidus.length)
        return false; 
      if (this.rmsNidus[b] != -2) {
        b = (byte)(b + 5);
        continue;
      } 
      this.rmsNidus[b] = (byte)paramInt;
      Ms.i().putShort(0, this.rmsNidus, b + 1);
      Ms.i().putShort(200, this.rmsNidus, b + 3);
      return true;
    } 
  }
  
  public byte[] createData(int paramInt) {
    return Ms.i().getStream("4", paramInt);
  }
  
  public String createString(String paramString) {
    Ms.i();
    Ms.skip = 0;
    return Ms.i().createStringArray(Ms.i().getStream(paramString, -1))[0].toString();
  }
  
  public void delNidus(int paramInt) {
    this.rmsNidus[paramInt * 5] = -2;
  }
  
  public void drawHelpStr(Graphics paramGraphics, StringBuffer[] paramArrayOfStringBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    byte b1 = (byte)(this.help_page * paramInt1);
    byte b = b1;
    while (true) {
      if (b >= b1 + paramInt1 || b >= paramArrayOfStringBuffer.length) {
        if (paramArrayOfStringBuffer.length > paramInt1) {
          paramInt2 = paramArrayOfStringBuffer.length / paramInt1;
          if (paramArrayOfStringBuffer.length % paramInt1 != 0) {
            paramInt1 = 1;
          } else {
            paramInt1 = 0;
          } 
          this.page_max = (byte)(paramInt2 + paramInt1);
          Ui.i().drawString(String.valueOf(this.help_page + 1) + "/" + this.page_max, Constants_H.WIDTH_H, Constants_H.HEIGHT - 2, 0x1 | 0x20, 3, 0);
          Ui.i().drawTriangle(Constants_H.WIDTH_H, Constants_H.HEIGHT - 12, 75, true, true);
          return;
        } 
      } else {
        Ui.i().drawString(paramArrayOfStringBuffer[b].toString(), paramInt2, paramInt3 + (b - b1) * 27, paramInt4, 3, 0);
        b = (byte)(b + 1);
        continue;
      } 
      this.page_max = 1;
      return;
    } 
  }
  
  public void drawMenu(StringBuffer[] paramArrayOfStringBuffer, int paramInt1, int paramInt2, int paramInt3) {
    int i;
    if (paramInt3 > 0) {
      Ui.i().drawKuang(paramInt1, paramInt2, paramInt3, paramArrayOfStringBuffer.length * 27 + 12);
      i = paramInt3;
    } else {
      Ms.i();
      i = Ms.abs(paramInt3);
    } 
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= paramArrayOfStringBuffer.length)
        return; 
      if (b == 0) {
        paramInt3 = 9;
      } else if (b == this.cur_a) {
        paramInt3 = 8;
      } else {
        paramInt3 = 0;
      } 
      Ui.i().drawString(paramArrayOfStringBuffer[b].toString(), (i >> 1) + paramInt1, paramInt2 + 4 + b * 27, 0x1 | 0x10, paramInt3, 0);
    } 
  }
  
  public void drawPauseMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Ui.i().drawK2(paramInt1, paramInt2, paramInt3, paramInt4, 1);
    Ui.i().drawK1(paramInt1 + 9, paramInt2 + 25 + 11, paramInt3 - 18, paramInt4 - 25 - 19, 0);
    Ui.i().drawListKY(6, paramInt1 + 8, paramInt2 + 25 + 13, paramInt3 - 16, 1, 33, -1, this.selecty, 4, 2);
    this.pkey.selectListSY(this.action_str.length, paramInt1 + 8, paramInt2 + 25 + 13, paramInt3 - 16, 1, 33, -1, this.selecty);
    byte b = this.pkey.selectMenuX(2, paramInt1, paramInt2 + 3, paramInt3 >> 1, 38);
    if (b != -1) {
      this.selectx = b;
      this.selecty = 0;
      setPauseS(this.selectx);
    } 
    if (this.selectx == 1) {
      boolean bool;
      Ui ui1 = Ui.i();
      paramInt4 = Sound.i().getVolume();
      if (this.selecty == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      ui1.drawVolume((paramInt3 >> 1) + paramInt1 + 25 - 8 - 60, paramInt2 + 25 + 16 + 33, paramInt4, bool);
      Ui.i().drawListSYHasSound((Object[])this.action_str, paramInt1 + 8, paramInt2 + 25 + 13, paramInt3 - 16, 32, this.selecty, 0, 3, 0);
    } else {
      Ui.i().drawListSY((Object[])this.action_str, paramInt1 + 8, paramInt2 + 25 + 13, paramInt3 - 16, 32, this.selecty, 0, 3, 0);
    } 
    Ui ui = Ui.i();
    if (this.selectx == 0) {
      paramInt4 = -60;
    } else {
      paramInt4 = 2;
    } 
    ui.drawK1((paramInt3 >> 1) + paramInt1 + paramInt4, paramInt2 + 4, 56, 29, 4);
    ui = Ui.i();
    if (this.selectx == 0) {
      paramInt4 = 0;
    } else {
      paramInt4 = 1;
    } 
    ui.drawString("菜单", (paramInt3 >> 1) + paramInt1 - 25 - 3, paramInt2 + 3, 0x1 | 0x10, paramInt4, 0);
    ui = Ui.i();
    if (this.selectx == 0) {
      paramInt4 = 1;
    } else {
      paramInt4 = 0;
    } 
    ui.drawString("系统", (paramInt3 >> 1) + paramInt1 + 25 + 3, paramInt2 + 3, 0x1 | 0x10, paramInt4, 0);
    Ui.i().drawTriangle((paramInt3 >> 1) + paramInt1, paramInt2 + 12, 80, true, true);
  }
  
  public void drawSelectMenu(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    for (byte b = 0;; b = (byte)(b + 1)) {
      int i;
      if (b >= paramArrayOfObject.length)
        return; 
      Ui ui = Ui.i();
      if (b == paramInt6) {
        i = 1;
      } else {
        i = paramInt5;
      } 
      ui.drawK0(paramInt1, paramInt2 + (paramInt4 + 33) * b, paramInt3, 33, i);
      ui = Ui.i();
      String str = paramArrayOfObject[b].toString();
      if (b == paramInt6) {
        i = 0;
      } else {
        i = 3;
      } 
      ui.drawString(str, (paramInt3 >> 1) + paramInt1, paramInt2 + 2 + (paramInt4 + 33) * b, 0x1 | 0x10, i, 1);
      Log.e("sk", "drawSelectMenu");
      if (this.pkey.isSelect(paramInt1, (paramInt4 + 33) * b + paramInt2, paramInt3, 33))
        if (this.map.my.state == 12) {
          if (b == paramInt6) {
            this.map.my.state = 13;
          } else {
            this.cur_a = b;
          } 
        } else if (run_state == 35 || run_state == 25 || this.map.my.state == 16 || run_state == 65 || run_state == 66 || run_state == 61) {
          if (b == paramInt6) {
            this.pkey.setKey5();
          } else {
            this.popMenu = b;
          } 
        }  
    } 
  }
  
  public void drawSelectMenu_(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    for (byte b = 0;; b = (byte)(b + 1)) {
      int i;
      if (b >= paramArrayOfObject.length)
        return; 
      Ui ui1 = Ui.i();
      if (b == paramInt6) {
        i = 1;
      } else {
        i = paramInt5;
      } 
      ui1.drawK0(paramInt1, paramInt2 + (paramInt4 + 33) * b, paramInt3, 25 + 8, i);
      Ui ui2 = Ui.i();
      String str = paramArrayOfObject[b].toString();
      if (b == paramInt6) {
        i = 0;
      } else {
        i = 3;
      } 
      ui2.drawString(str, (paramInt3 >> 1) + paramInt1, paramInt2 + 2 + (paramInt4 + 33) * b, 0x1 | 0x10, i, 1);
      g.setColor(16711680);
      if (this.pkey.isSelect(Constants_H.WIDTH * paramInt1 / Constants_H.WIDTH__, ((paramInt4 + 33) * b + paramInt2) * Constants_H.WIDTH / Constants_H.WIDTH__, Constants_H.WIDTH * paramInt3 / Constants_H.WIDTH__, Constants_H.WIDTH * 33 / Constants_H.WIDTH__))
        if (this.map.my.state == 12) {
          if (b == paramInt6) {
            this.map.my.state = 13;
          } else {
            this.cur_a = b;
          } 
        } else if (run_state == 35 || run_state == 25 || this.map.my.state == 16 || run_state == 65 || run_state == 66) {
          if (b == paramInt6) {
            this.pkey.setKey5();
          } else {
            this.popMenu = b;
          } 
        }  
    } 
  }
  
  public void drawSrcLine(Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #7
    //   3: iload_3
    //   4: iload #4
    //   6: idiv
    //   7: i2b
    //   8: istore #9
    //   10: aload_1
    //   11: iconst_0
    //   12: invokevirtual setColor : (I)V
    //   15: iload #5
    //   17: ifne -> 181
    //   20: iconst_2
    //   21: aload_0
    //   22: getfield src_c : [B
    //   25: iconst_0
    //   26: baload
    //   27: ishl
    //   28: i2s
    //   29: istore_3
    //   30: iload #4
    //   32: iconst_1
    //   33: isub
    //   34: i2b
    //   35: istore #4
    //   37: iload #4
    //   39: iconst_m1
    //   40: if_icmpgt -> 74
    //   43: iload #6
    //   45: ifeq -> 150
    //   48: aload_0
    //   49: getfield src_c : [B
    //   52: iconst_0
    //   53: baload
    //   54: bipush #12
    //   56: if_icmpge -> 150
    //   59: aload_0
    //   60: getfield src_c : [B
    //   63: astore_1
    //   64: aload_1
    //   65: iconst_0
    //   66: aload_1
    //   67: iconst_0
    //   68: baload
    //   69: iconst_1
    //   70: iadd
    //   71: i2b
    //   72: bastore
    //   73: return
    //   74: iload #9
    //   76: iload_3
    //   77: isub
    //   78: ifgt -> 96
    //   81: iload #4
    //   83: iconst_1
    //   84: isub
    //   85: i2b
    //   86: istore #4
    //   88: iload_3
    //   89: iconst_2
    //   90: idiv
    //   91: i2s
    //   92: istore_3
    //   93: goto -> 37
    //   96: iload_3
    //   97: iconst_2
    //   98: if_icmpge -> 138
    //   101: iconst_0
    //   102: istore #7
    //   104: iload_3
    //   105: iconst_2
    //   106: if_icmpge -> 144
    //   109: iconst_0
    //   110: istore #8
    //   112: aload_1
    //   113: iconst_0
    //   114: iload #4
    //   116: iload #9
    //   118: imul
    //   119: iload_2
    //   120: iadd
    //   121: iload #7
    //   123: iadd
    //   124: sipush #640
    //   127: iload #9
    //   129: iload #8
    //   131: isub
    //   132: invokevirtual fillRect : (IIII)V
    //   135: goto -> 81
    //   138: iload_3
    //   139: istore #7
    //   141: goto -> 104
    //   144: iload_3
    //   145: istore #8
    //   147: goto -> 112
    //   150: iload #6
    //   152: ifne -> 73
    //   155: aload_0
    //   156: getfield src_c : [B
    //   159: iconst_0
    //   160: baload
    //   161: ifle -> 73
    //   164: aload_0
    //   165: getfield src_c : [B
    //   168: astore_1
    //   169: aload_1
    //   170: iconst_0
    //   171: aload_1
    //   172: iconst_0
    //   173: baload
    //   174: iconst_1
    //   175: isub
    //   176: i2b
    //   177: bastore
    //   178: goto -> 73
    //   181: iconst_2
    //   182: aload_0
    //   183: getfield src_c : [B
    //   186: iconst_1
    //   187: baload
    //   188: ishl
    //   189: i2s
    //   190: istore_3
    //   191: iload #5
    //   193: ifeq -> 203
    //   196: iload #7
    //   198: iload #4
    //   200: if_icmplt -> 236
    //   203: iload #6
    //   205: ifeq -> 295
    //   208: aload_0
    //   209: getfield src_c : [B
    //   212: iconst_1
    //   213: baload
    //   214: bipush #12
    //   216: if_icmpge -> 295
    //   219: aload_0
    //   220: getfield src_c : [B
    //   223: astore_1
    //   224: aload_1
    //   225: iconst_1
    //   226: aload_1
    //   227: iconst_1
    //   228: baload
    //   229: iconst_1
    //   230: iadd
    //   231: i2b
    //   232: bastore
    //   233: goto -> 73
    //   236: iload #9
    //   238: iload_3
    //   239: isub
    //   240: ifgt -> 258
    //   243: iload #7
    //   245: iconst_1
    //   246: iadd
    //   247: i2b
    //   248: istore #7
    //   250: iload_3
    //   251: iconst_2
    //   252: idiv
    //   253: i2s
    //   254: istore_3
    //   255: goto -> 191
    //   258: iload_3
    //   259: iconst_2
    //   260: if_icmpge -> 289
    //   263: iconst_0
    //   264: istore #8
    //   266: aload_1
    //   267: iconst_0
    //   268: iload #7
    //   270: iload #9
    //   272: imul
    //   273: iload_2
    //   274: iadd
    //   275: sipush #640
    //   278: iload #9
    //   280: iload #8
    //   282: isub
    //   283: invokevirtual fillRect : (IIII)V
    //   286: goto -> 243
    //   289: iload_3
    //   290: istore #8
    //   292: goto -> 266
    //   295: iload #6
    //   297: ifne -> 73
    //   300: aload_0
    //   301: getfield src_c : [B
    //   304: iconst_1
    //   305: baload
    //   306: ifle -> 73
    //   309: aload_0
    //   310: getfield src_c : [B
    //   313: astore_1
    //   314: aload_1
    //   315: iconst_1
    //   316: aload_1
    //   317: iconst_1
    //   318: baload
    //   319: iconst_1
    //   320: isub
    //   321: i2b
    //   322: bastore
    //   323: goto -> 73
  }
  
  public void drawZero(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Ui.i().drawString("点击屏幕继续", paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public void drawZero(String paramString, int paramInt) {
    Ui.i().drawString("点击屏幕" + paramString, Constants_H.WIDTH_H, paramInt, 0x1 | 0x20, 0, 0);
  }
  
  public byte getNLevel(int paramInt) {
    return this.nidusList[1][getRid(paramInt)];
  }
  
  public short getNexp(int paramInt1, int paramInt2) {
    return Ms.i().getShort(this.rmsNidus, paramInt1 * 5 + paramInt2);
  }
  
  public byte getNid(int paramInt) {
    return this.nidusList[0][getRid(paramInt)];
  }
  
  public byte getRid(int paramInt) {
    return this.rmsNidus[paramInt * 5];
  }
  
  public short getSIndexW(String paramString) {
    byte b4 = 0;
    byte b5 = 0;
    byte b = (byte)paramString.indexOf("#", 0);
    byte b1 = b;
    byte b2 = b4;
    byte b3 = b5;
    if (b == 0) {
      b1 = 1;
      b3 = b5;
      b2 = b4;
    } 
    while (true) {
      if (b1 == -1)
        return (short)(Ms.i().getStringWidth("#1") * b2); 
      b3 = (byte)(b3 + b1);
      b1 = (byte)paramString.indexOf("#", b3);
      b2 = (byte)(b2 + 1);
    } 
  }
  
  public void gogoWord(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    short s = (short)(Ms.i().getStringWidth(paramString) - getSIndexW(paramString));
    if (s > 640 - paramInt1 - paramInt3) {
      this.introX -= paramInt6;
      if (this.introX + s < paramInt1)
        this.introX = 640 - paramInt3 - 75; 
    } else {
      this.introX = paramInt1;
    } 
    g.clipRect(paramInt1, paramInt2, 640 - paramInt3 - paramInt1, 30);
    Ui.i().drawStringColor(paramString, this.introX, paramInt2, paramInt4, paramInt5);
    g.setClip(0, 0, 640, 360);
  }
  
  public void gogoWordM(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    short s = (short)Ms.i().getStringWidth(paramString);
    this.introT -= paramInt5;
    if (this.introT + s < paramInt2 << 1)
      this.introT = 640 + 1; 
    g.clipRect(paramInt2, paramInt1, 640 - (paramInt2 << 1), 30);
    Ui.i().drawString(paramString, this.introT, paramInt1, 0, paramInt3, paramInt4);
    g.setClip(0, 0, 640, 360);
  }
  
  public void initGraphics(Graphics paramGraphics) {
    g = paramGraphics;
    dg = DirectUtils.getDirectGraphics(paramGraphics);
  }
  
  public void initOffG() {
    scrT = Image.createImage(Constants_H.WIDTH + 20, Constants_H.HEIGHT + 20);
    offG = scrT.getGraphics();
  }
  
  public void initRmsOther() {
    this.rmsOther = null;
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[0] = -1;
    arrayOfByte[3] = 1;
    this.rmsOther = arrayOfByte;
  }
  
  public byte isMyLevel(boolean paramBoolean) {
    switch (this.rmsOther[3]) {
      default:
        return -1;
      case 1:
        if (paramBoolean && this.monInfoList[103] > 4) {
          this.rmsOther[3] = 2;
        } else {
          return 5;
        } 
      case 2:
        if (paramBoolean && this.monInfoList[103] > 9) {
          this.rmsOther[3] = 3;
        } else {
          return 10;
        } 
      case 3:
        if (paramBoolean && this.monInfoList[103] > 14) {
          this.rmsOther[3] = 4;
        } else {
          return 15;
        } 
      case 4:
        break;
    } 
    if (paramBoolean && this.monInfoList[103] > 29)
      this.rmsOther[3] = 5; 
    return 30;
  }
  
  public void loadInfoList() {
    this.info = Ms.i().rmsOptions(6, null, 1);
    if (this.info[0] == -1) {
      this.monInfoList = new byte[105];
      byte b = 0;
      while (true) {
        if (b < this.monInfoList.length) {
          this.monInfoList[b] = 0;
          b++;
          continue;
        } 
        this.info = null;
        return;
      } 
    } 
    this.monInfoList = this.info;
    this.info = null;
  }
  
  public void loadItem() {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic i : ()Ldm/Ms;
    //   4: iconst_4
    //   5: aconst_null
    //   6: iconst_1
    //   7: invokevirtual rmsOptions : (I[BI)[B
    //   10: putfield info : [B
    //   13: aload_0
    //   14: iconst_4
    //   15: newarray byte
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 16
    //   22: bastore
    //   23: dup
    //   24: iconst_1
    //   25: ldc_w 19
    //   28: bastore
    //   29: dup
    //   30: iconst_2
    //   31: ldc_w 23
    //   34: bastore
    //   35: dup
    //   36: iconst_3
    //   37: ldc_w 12
    //   40: bastore
    //   41: putfield len : [B
    //   44: aload_0
    //   45: iconst_4
    //   46: newarray byte
    //   48: putfield itemsLength : [B
    //   51: aload_0
    //   52: getfield info : [B
    //   55: iconst_0
    //   56: baload
    //   57: iconst_m1
    //   58: if_icmpeq -> 68
    //   61: iconst_0
    //   62: istore_1
    //   63: iload_1
    //   64: iconst_4
    //   65: if_icmplt -> 104
    //   68: aload_0
    //   69: aload_0
    //   70: getfield itemsLength : [B
    //   73: arraylength
    //   74: anewarray [[B
    //   77: putfield items : [[[B
    //   80: iconst_0
    //   81: istore_1
    //   82: iconst_0
    //   83: istore_2
    //   84: iload_1
    //   85: aload_0
    //   86: getfield items : [[[B
    //   89: arraylength
    //   90: if_icmplt -> 122
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield info : [B
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield len : [B
    //   103: return
    //   104: aload_0
    //   105: getfield itemsLength : [B
    //   108: iload_1
    //   109: aload_0
    //   110: getfield info : [B
    //   113: iload_1
    //   114: baload
    //   115: bastore
    //   116: iinc #1, 1
    //   119: goto -> 63
    //   122: aload_0
    //   123: getfield items : [[[B
    //   126: astore #4
    //   128: aload_0
    //   129: getfield len : [B
    //   132: iload_1
    //   133: baload
    //   134: istore_3
    //   135: aload #4
    //   137: iload_1
    //   138: iload_3
    //   139: iconst_2
    //   140: multianewarray[[B 2
    //   144: aastore
    //   145: iconst_0
    //   146: istore_3
    //   147: iload_3
    //   148: aload_0
    //   149: getfield itemsLength : [B
    //   152: iload_1
    //   153: baload
    //   154: if_icmplt -> 163
    //   157: iinc #1, 1
    //   160: goto -> 84
    //   163: aload_0
    //   164: getfield items : [[[B
    //   167: iload_1
    //   168: aaload
    //   169: iload_3
    //   170: aaload
    //   171: iconst_0
    //   172: aload_0
    //   173: getfield info : [B
    //   176: iload_2
    //   177: iconst_2
    //   178: imul
    //   179: iconst_4
    //   180: iadd
    //   181: baload
    //   182: bastore
    //   183: aload_0
    //   184: getfield items : [[[B
    //   187: iload_1
    //   188: aaload
    //   189: iload_3
    //   190: aaload
    //   191: iconst_1
    //   192: aload_0
    //   193: getfield info : [B
    //   196: iload_2
    //   197: iconst_2
    //   198: imul
    //   199: iconst_4
    //   200: iadd
    //   201: iconst_1
    //   202: iadd
    //   203: baload
    //   204: bastore
    //   205: iinc #3, 1
    //   208: iinc #2, 1
    //   211: goto -> 147
  }
  
  public void loadMon(int paramInt, byte[][] paramArrayOfbyte) {
    this.info = Ms.i().rmsOptions(paramInt + 8, null, 1);
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 0) {
      try {
        this.cMonsters = new Monster[95];
        if (this.info[0] == -1) {
          this.cMon_count = 0;
          return;
        } 
        ByteArrayInputStream byteArrayInputStream1 = new ByteArrayInputStream();
        this(this.info);
        this.cMon_count = (byte)byteArrayInputStream1.read();
        paramInt = bool1;
        while (true) {
          if (paramInt < this.cMon_count) {
            Monster[] arrayOfMonster = this.cMonsters;
            Monster monster = new Monster();
            this();
            arrayOfMonster[paramInt] = monster;
            loadMon(byteArrayInputStream1, this.cMonsters[paramInt], paramArrayOfbyte);
            paramInt++;
            continue;
          } 
          byteArrayInputStream1.close();
          this.info = null;
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      return;
    } 
    this.myMonsters = new Monster[5];
    if (this.info[0] == -1) {
      this.myMon_length = 0;
      return;
    } 
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
    this(this.info);
    this.myMon_length = (byte)byteArrayInputStream.read();
    paramInt = bool2;
    while (true) {
      Monster[] arrayOfMonster;
      ByteArrayInputStream byteArrayInputStream1 = byteArrayInputStream;
      if (paramInt < this.myMon_length) {
        arrayOfMonster = this.myMonsters;
        Monster monster = new Monster();
        this();
        arrayOfMonster[paramInt] = monster;
        loadMon(byteArrayInputStream, this.myMonsters[paramInt], (byte[][])exception);
        paramInt++;
        continue;
      } 
      arrayOfMonster.close();
      this.info = null;
      return;
    } 
  }
  
  public void loadMon(ByteArrayInputStream paramByteArrayInputStream, Monster paramMonster, byte[][] paramArrayOfbyte) throws IOException {
    paramMonster.monster = new byte[18];
    paramMonster.monsterPro = new short[8];
    paramByteArrayInputStream.read(paramMonster.monster);
    this.len = new byte[10];
    paramByteArrayInputStream.read(this.len);
    for (byte b = 0;; b++) {
      if (b >= 5) {
        paramMonster.setProAFD(paramArrayOfbyte[paramMonster.monster[0]]);
        this.len = null;
        return;
      } 
      paramMonster.monsterPro[b] = (short)((this.len[b * 2 + 1] & 0xFF) << 8 | this.len[b * 2 + 0] & 0xFF);
    } 
  }
  
  public void loadRmsNidus() {
    this.rmsNidus = Ms.i().rmsOptions(3, null, 1);
    if (this.rmsNidus[0] == -1) {
      this.rmsNidus = null;
      byte[] arrayOfByte = new byte[25];
      arrayOfByte[0] = -2;
      arrayOfByte[3] = 10;
      arrayOfByte[4] = 10;
      arrayOfByte[5] = -2;
      arrayOfByte[8] = 10;
      arrayOfByte[9] = 10;
      arrayOfByte[10] = -2;
      arrayOfByte[13] = 10;
      arrayOfByte[14] = 10;
      arrayOfByte[15] = -2;
      arrayOfByte[18] = 10;
      arrayOfByte[19] = 10;
      arrayOfByte[20] = -2;
      arrayOfByte[23] = 10;
      arrayOfByte[24] = 10;
      this.rmsNidus = arrayOfByte;
    } 
  }
  
  public void loadRmsOther() {
    this.info = Ms.i().rmsOptions(10, null, 1);
    if (this.info[0] == -1) {
      setMaxTakes(true);
      initRmsOther();
    } else {
      this.rmsOther = this.info;
      setMaxTakes(false);
    } 
    this.info = null;
  }
  
  public void loadRmsSms() {
    this.rmsSms = Ms.i().rmsOptions(5, null, 1);
    if (this.rmsSms == null || this.rmsSms[0] == -1) {
      this.rmsSms = null;
      this.rmsSms = new byte[7];
    } 
    if (this.rmsSms[0] == 10) {
      byte[] arrayOfByte = this.rmsOther;
      arrayOfByte[2] = (byte)(arrayOfByte[2] | 0x8);
    } 
  }
  
  public void saveInfoList() {
    Ms.i().rmsOptions(6, this.monInfoList, 2);
  }
  
  public void saveItem() {
    int i = 0;
    for (byte b = 0;; b++) {
      if (b >= 4) {
        this.info = new byte[this.items.length + i * 2];
        b = 0;
        for (i = 0;; i++) {
          if (i >= 4) {
            i = 0;
            label21: while (true) {
              if (i >= this.items.length) {
                Ms.i().rmsOptions(4, this.info, 2);
                this.info = null;
                return;
              } 
              byte b1 = 0;
              while (true) {
                if (b1 >= this.itemsLength[i]) {
                  i++;
                  continue label21;
                } 
                this.info[b * 2 + 4] = this.items[i][b1][0];
                this.info[b * 2 + 4 + 1] = this.items[i][b1][1];
                b1++;
                b++;
              } 
              break;
            } 
            break;
          } 
          this.info[i] = this.itemsLength[i];
        } 
        break;
      } 
      i += this.itemsLength[b];
    } 
  }
  
  public void saveMon(int paramInt) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 0) {
      try {
        byteArrayOutputStream.write(this.cMon_count);
        paramInt = bool1;
        while (true) {
          if (paramInt >= this.cMon_count) {
            Ms.i().rmsOptions(8, byteArrayOutputStream.toByteArray(), 2);
          } else {
            saveMon(byteArrayOutputStream, this.cMonsters[paramInt]);
            paramInt++;
            continue;
          } 
          byteArrayOutputStream.close();
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      return;
    } 
    exception.write(this.myMon_length);
    paramInt = bool2;
    while (true) {
      if (paramInt >= this.myMon_length) {
        Ms.i().rmsOptions(9, exception.toByteArray(), 2);
      } else {
        saveMon((ByteArrayOutputStream)exception, this.myMonsters[paramInt]);
        paramInt++;
        continue;
      } 
      exception.close();
      return;
    } 
  }
  
  public void saveMon(ByteArrayOutputStream paramByteArrayOutputStream, Monster paramMonster) throws IOException {
    paramByteArrayOutputStream.write(paramMonster.monster);
    for (byte b = 0;; b++) {
      if (b >= 5)
        return; 
      short s = paramMonster.monsterPro[b];
      paramByteArrayOutputStream.write((byte)(s & 0xFF));
      paramByteArrayOutputStream.write((byte)(s >> 8 & 0xFF));
    } 
  }
  
  public void setAction_str(String[] paramArrayOfString) {
    this.action_str = paramArrayOfString;
    paramArrayOfString = (String[])null;
  }
  
  public void setGogoWord() {
    this.introT = Constants_H.WIDTH;
    Ms.i();
    Ms.skip = 0;
    StringBuffer[] arrayOfStringBuffer = Ms.i().createStringArray(Ms.i().getStream("data/other/hint.t", -1));
    Ms.i();
    this.gogoST = arrayOfStringBuffer[Ms.getRandom(arrayOfStringBuffer.length)].toString();
    arrayOfStringBuffer = (StringBuffer[])null;
  }
  
  public void setMaxTakes(boolean paramBoolean) {
    if (paramBoolean) {
      this.max_takes = 3;
      this.max_monsters = 10;
      return;
    } 
    if (this.rmsOther[3] == 2) {
      this.max_takes = 4;
      this.max_monsters = 20;
      return;
    } 
    if (this.rmsOther[3] == 3) {
      this.max_takes = 5;
      this.max_monsters = 40;
      return;
    } 
    if (this.rmsOther[3] == 4) {
      this.max_takes = 5;
      this.max_monsters = 80;
      return;
    } 
    if (this.rmsOther[3] == 5) {
      this.max_takes = 5;
      this.max_monsters = 95;
    } 
  }
  
  public void setNidusExp(int paramInt) {
    if (paramInt / 10 < 1) {
      paramInt = 1;
    } else {
      paramInt /= 10;
    } 
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= 5)
        return; 
      if (getRid(b) != -2) {
        Ms.i().putShort(getNexp(b, 1) + paramInt, this.rmsNidus, b * 5 + 1);
        if (getNexp(b, 1) > getNexp(b, 3))
          Ms.i().putShort(getNexp(b, 3), this.rmsNidus, b * 5 + 1); 
      } 
    } 
  }
  
  public void setPauseS(int paramInt) {
    if (paramInt == 0) {
      setAction_str(new String[] { "保存游戏", "查看宠物", "人物背包", "宠物图鉴", "查看任务", "返回游戏" });
      return;
    } 
    setAction_str(new String[] { "读取进度", "声音", "游戏帮助", "回主菜单" });
  }
  
  public void setStringB(String paramString, int paramInt1, int paramInt2) {
    if (paramInt2 == 0) {
      this.about_a = Ms.i().groupString(paramString, paramInt1);
      return;
    } 
    if (paramInt2 == 1) {
      this.about_b = Ms.i().groupString(paramString, paramInt1);
      return;
    } 
    if (paramInt2 == 2) {
      this.about_c = Ms.i().groupString(paramString, paramInt1);
      return;
    } 
    if (paramInt2 == 3)
      this.about_d = Ms.i().groupString(paramString, paramInt1); 
  }
  
  public void showString(String paramString, int paramInt1, int paramInt2) {
    byte b = (byte)(paramString.length() / 11);
    Ui.i().drawK0(paramInt2 - 5, paramInt1, 640 + 10, (b + 1) * 25 + 8, 3);
    showStringM(paramString, 320 + paramInt2, paramInt1 + 3, 11, 0);
  }
  
  public void showString(StringBuffer[] paramArrayOfStringBuffer, int paramInt1, int paramInt2, int paramInt3) {
    int j = Constants_H.WIDTH__;
    int k = Constants_H.WIDTH__ / 2;
    int i = paramInt1 + 5;
    if (paramInt3 != 0) {
      Ui.i().drawKuang(paramInt2 - 5, i, j + 10, paramArrayOfStringBuffer.length * 25 + 12);
      if (paramInt3 == 2)
        drawSnare5(k + paramInt2, paramArrayOfStringBuffer.length * 25 + i + 4); 
    } 
    for (paramInt1 = 0;; paramInt1 = (byte)(paramInt1 + 1)) {
      if (paramInt1 >= paramArrayOfStringBuffer.length)
        return; 
      Ui.i().drawStringColor(paramArrayOfStringBuffer[paramInt1].toString(), 25 + paramInt2, i + 4 + paramInt1 * 25, -1, 1);
    } 
  }
  
  public void showStringM(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    byte b1 = (byte)(paramString.length() / paramInt3);
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b > b1)
        return; 
      if (b1 == 0) {
        Ui.i().drawString(paramString, paramInt1, paramInt2, 0x1 | 0x10, paramInt4, 1);
        Log.e("sk", "strNum == 0");
      } else {
        int i;
        Ui ui = Ui.i();
        if (b + 1 > b1) {
          i = paramString.length();
        } else {
          i = (b + 1) * paramInt3;
        } 
        ui.drawString(paramString.substring(b * paramInt3, i), paramInt1, paramInt2 + b * 25, 0x1 | 0x10, paramInt4, 0);
        Log.e("sk", "else");
      } 
    } 
  }
  
  public void showStringM_(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    byte b1 = (byte)(paramString.length() / paramInt3);
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b > b1)
        return; 
      if (b1 == 0) {
        Ui.i().drawString(paramString, paramInt1, paramInt2, 0x1 | 0x10, paramInt4, 1);
        Log.e("sk", "strNum == 0");
      } else {
        int i;
        Ui ui = Ui.i();
        if (b + 1 > b1) {
          i = paramString.length();
        } else {
          i = (b + 1) * paramInt3;
        } 
        ui.drawString(paramString.substring(b * paramInt3, i), paramInt1, paramInt2 + b * 25, 0x1 | 0x10, paramInt4, 0);
      } 
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/main/GameRun_F.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */