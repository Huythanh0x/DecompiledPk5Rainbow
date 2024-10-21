package dm;

import android.util.Log;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Constants_H;

public class Ui {
  public static DirectGraphics dg;
  
  public static Graphics g;
  
  private static final short[] transforms;
  
  private static Ui uiListener;
  
  private int[] MIRROR;
  
  private byte[][] MIRROR2;
  
  private byte[] MIRROR3;
  
  public byte cTriangle;
  
  private byte rz;
  
  private Image ui_img;
  
  private short[][] ui_modules;
  
  static {
    short[] arrayOfShort = new short[8];
    arrayOfShort[1] = 5;
    arrayOfShort[2] = 3;
    arrayOfShort[3] = 6;
    arrayOfShort[4] = 2;
    arrayOfShort[5] = 4;
    arrayOfShort[6] = 1;
    arrayOfShort[7] = 7;
    transforms = arrayOfShort;
  }
  
  public Ui() {
    byte[] arrayOfByte1 = new byte[8];
    arrayOfByte1[1] = 1;
    arrayOfByte1[2] = 2;
    arrayOfByte1[3] = 3;
    arrayOfByte1[4] = 4;
    arrayOfByte1[5] = 5;
    arrayOfByte1[6] = 6;
    arrayOfByte1[7] = 7;
    byte[] arrayOfByte2 = new byte[8];
    arrayOfByte2[0] = 4;
    arrayOfByte2[1] = 5;
    arrayOfByte2[2] = 6;
    arrayOfByte2[3] = 7;
    arrayOfByte2[5] = 1;
    arrayOfByte2[6] = 2;
    arrayOfByte2[7] = 3;
    this.MIRROR2 = new byte[][] { arrayOfByte1, arrayOfByte2 };
    this.MIRROR3 = new byte[] { 1, -1 };
    this.MIRROR = new int[] { 0x4 | 0x10, 0x8 | 0x10 };
    this.cTriangle = 0;
    uiListener = this;
  }
  
  public static Ui i() {
    if (uiListener == null)
      uiListener = new Ui(); 
    return uiListener;
  }
  
  public boolean drawActionOne(Sprite paramSprite, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfbyte, int paramInt4, boolean paramBoolean) {
    drawFrameOne(paramSprite, paramSprite.action(paramInt1, paramArrayOfbyte[0], 0), paramInt2, paramInt3, paramInt4);
    byte b = (byte)(paramArrayOfbyte[1] + 1);
    paramArrayOfbyte[1] = b;
    if (b > paramSprite.action(paramInt1, paramArrayOfbyte[0], 1)) {
      paramArrayOfbyte[1] = 0;
      b = (byte)(paramArrayOfbyte[0] + 1);
      paramArrayOfbyte[0] = b;
      if (b >= paramSprite.aLength(paramInt1)) {
        if (!paramBoolean) {
          paramArrayOfbyte[0] = (byte)(paramSprite.aLength(paramInt1) - 1);
          return true;
        } 
        paramArrayOfbyte[0] = 0;
      } 
    } 
    return false;
  }
  
  public void drawBDir(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    g.setColor(8310516);
    g.drawRect(paramInt1, paramInt2, paramInt3 * 3, paramInt4 << 1);
    g.drawRect(paramInt1 + paramInt3, paramInt2, paramInt3, paramInt4 << 1);
    g.drawLine(paramInt1, (paramInt2 + paramInt4), (paramInt3 * 3 + paramInt1), (paramInt2 + paramInt4));
  }
  
  public void drawBarOne(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    int i = 16125468;
    if (paramInt6 == 1) {
      i = 55551;
    } else if (paramInt6 == 2) {
      i = 60177;
    } 
    fillRect(4067649, paramInt1 + 1, paramInt2, paramInt3 - 1, 5);
    g.drawRect(paramInt1, paramInt2 + 1, paramInt3, 5 - 3);
    paramInt6 = 5 - 2;
    fillRect(16752385, paramInt1 + 1, paramInt2 + 1, paramInt4, paramInt6);
    if (paramInt4 > paramInt5) {
      paramInt3 = paramInt5;
    } else {
      paramInt3 = paramInt4;
    } 
    fillRect(i, paramInt1 + 1, paramInt2 + 1, paramInt3, paramInt6);
  }
  
  public void drawFrameOne(Sprite paramSprite, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    short s;
    for (s = 0;; s = (short)(s + 1)) {
      if (s >= paramSprite.fLength(paramInt1))
        return; 
      drawModuleOne(paramSprite, paramSprite.frame(paramInt1, s, 0), paramInt2 + paramSprite.frame(paramInt1, s, 1) * this.MIRROR3[paramInt4], paramInt3 + paramSprite.frame(paramInt1, s, 2), paramInt4, paramSprite.frame(paramInt1, s, 3));
    } 
  }
  
  public void drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3) {
    g.drawImage(paramImage, paramInt1, paramInt2, paramInt3);
  }
  
  public void drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramInt4 == 0) {
      g.drawImage(paramImage, paramInt1, paramInt2, paramInt3);
      return;
    } 
    dg.drawImage(paramImage, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void drawK(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (paramInt5 == 0) {
      paramInt5 = 15400191;
    } else if (paramInt5 == 1) {
      paramInt5 = 12352252;
    } else if (paramInt5 == 2) {
      paramInt5 = 12313343;
    } else if (paramInt5 == 3) {
      paramInt5 = 5228543;
    } else if (paramInt5 == 4) {
      paramInt5 = 30975;
    } else {
      paramInt5 = 11121884;
    } 
    g.setColor(paramInt5);
    g.fillRect(paramInt1 + 1, paramInt2, paramInt3 - 2, paramInt4);
    g.fillRect(paramInt1, paramInt2 + 1, paramInt3, paramInt4 - 2);
  }
  
  public void drawK0(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    byte b = (byte)paramInt5;
    if (paramInt5 == 2) {
      paramInt5 = 15400191;
    } else {
      paramInt5 = 1908277;
    } 
    g.setColor(paramInt5);
    g.drawRect(paramInt1 + 1, paramInt2, paramInt3 - 3, paramInt4 - 1);
    g.drawRect(paramInt1, paramInt2 + 1, paramInt3 - 1, paramInt4 - 3);
    drawK(paramInt1 + 1, paramInt2 + 1, paramInt3 - 2, paramInt4 - 2, b);
  }
  
  public void drawK1(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    int i;
    Graphics graphics = g;
    if (paramInt5 == 0) {
      i = 5461075;
    } else {
      i = 1908277;
    } 
    graphics.setColor(i);
    g.drawRect(paramInt1, paramInt2 + 2, paramInt3, paramInt4 - 3);
    g.drawLine((paramInt1 + 1), (paramInt2 + paramInt4), (paramInt1 + paramInt3 - 1), (paramInt2 + paramInt4));
    if (paramInt5 == 0 || paramInt5 == 1) {
      paramInt5 = 15400191;
    } else if (paramInt5 == 2) {
      paramInt5 = 13892607;
    } else if (paramInt5 == 3) {
      paramInt5 = 7727871;
    } else {
      paramInt5 = 12352252;
    } 
    g.setColor(paramInt5);
    g.fillRect(paramInt1 + 1, paramInt2, paramInt3 - 2, paramInt4);
    g.fillRect(paramInt1, paramInt2 + 1, paramInt3, paramInt4 - 2);
  }
  
  public void drawK2(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (paramInt5 == 0);
    g.setColor(0);
    g.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
    g.setColor(30975);
    g.fillRect(paramInt1 + 2, paramInt2 + 2, paramInt3 - 4, paramInt4 - 4);
  }
  
  public void drawK3(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    drawK0(paramInt1, paramInt2, paramInt3 - 1, paramInt4 - 1, 0);
    g.setColor(1908277);
    g.fillRect(paramInt1 + 2, paramInt2 + 2, paramInt3 - 2, paramInt4 - 2);
  }
  
  public void drawK4(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    g.setColor(16771373);
    g.drawLine((paramInt1 + 1), paramInt2, (paramInt1 + paramInt3 - 2), paramInt2);
    g.drawLine((paramInt1 + 1), (paramInt2 + paramInt4 - 1), (paramInt1 + paramInt3 - 2), (paramInt2 + paramInt4 - 1));
    g.drawLine(paramInt1, (paramInt2 + 1), paramInt1, (paramInt2 + paramInt4 - 2));
    g.drawLine((paramInt1 + paramInt3 - 1), (paramInt2 + 1), (paramInt1 + paramInt3 - 1), (paramInt2 + paramInt4 - 2));
    g.drawLine(paramInt1, (paramInt2 + 1), (paramInt1 + 1), (paramInt2 + 1));
    g.drawLine((paramInt1 + paramInt3 - 2), (paramInt2 + 1), (paramInt1 + paramInt3 - 1), (paramInt2 + 1));
    g.drawLine(paramInt1, (paramInt2 + paramInt4 - 2), (paramInt1 + 1), (paramInt2 + paramInt4 - 2));
    g.drawLine((paramInt1 + paramInt3 - 2), (paramInt2 + paramInt4 - 2), (paramInt1 + paramInt3 - 2), (paramInt2 + paramInt4 - 2));
  }
  
  public void drawKuang(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    g.setColor(1908277);
    g.drawRect(paramInt1 + 1, paramInt2, paramInt3 - 4, paramInt4 - 2);
    g.drawRect(paramInt1 + 2, paramInt2 + 1, paramInt3 - 4, paramInt4 - 2);
    g.drawLine(paramInt1, (paramInt2 + 1), paramInt1, (paramInt2 + paramInt4 - 3));
    g.drawLine((paramInt1 + paramInt3 - 1), (paramInt2 + 2), (paramInt1 + paramInt3 - 1), (paramInt2 + paramInt4 - 2));
    fillRect(15400191, paramInt1 + 1, paramInt2 + 1, paramInt3 - 3, paramInt4 - 3);
  }
  
  public void drawKuangAdorn(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (paramInt5 == 0) {
      g.setColor(1842484);
      g.drawRect(paramInt1 + 20, paramInt2 - 22, paramInt3 - 21, 20);
      g.drawRect(paramInt1 + 20, paramInt2 - 22, paramInt3 - 22, 21);
      fillRect(15129744, paramInt1 + 20, paramInt2 - 22, paramInt3 - 22, 20);
      drawUi(33, paramInt1, paramInt2, 36, 0);
      drawUi(31, paramInt1 + paramInt3 - 4, paramInt2, 36, 0);
      return;
    } 
    if (paramInt5 == 1) {
      drawUi(32, paramInt1, paramInt2 - 7, 0, 0);
      drawUi(32, paramInt1 + paramInt3 + 5, paramInt2 - 7, 0x8 | 0x10, 0);
      fillRect(13550445, paramInt1 + 15, paramInt2 - 5, paramInt3 - 25, 13);
      fillRect(16116383, paramInt1 + 15, paramInt2 - 3, paramInt3 - 25, 10);
      fillRect(13078326, paramInt1 + 15, paramInt2 + 10, paramInt3 - 25, 5);
      drawLine(1842484, paramInt1 + 15, paramInt2 - 7, paramInt1 + paramInt3 - 11, paramInt2 - 7);
      drawLine(16446403, paramInt1 + 15, paramInt2 - 6, paramInt1 + paramInt3 - 11, paramInt2 - 6);
      drawLine(6168835, paramInt1 + 15, paramInt2 + 12, paramInt1 + paramInt3 - 11, paramInt2 + 12);
      g.setColor(13281366);
      g.drawRect(paramInt1 + 15, paramInt2 + 8, paramInt3 - 26, 1);
      return;
    } 
    if (paramInt5 == 2) {
      drawUi(32, paramInt1, paramInt2 + paramInt4 - 1, 36, 6);
      drawUi(32, paramInt1 + paramInt3 + 5, paramInt2 + paramInt4 - 1, 40, 6);
      fillRect(13550445, paramInt1 + 15, paramInt2 + paramInt4 - 16, paramInt3 - 25, 13);
      fillRect(16116383, paramInt1 + 15, paramInt2 + paramInt4 - 15, paramInt3 - 25, 10);
      fillRect(13078326, paramInt1 + 15, paramInt2 + paramInt4 - 23, paramInt3 - 25, 5);
      drawLine(1842484, paramInt1 + 15, paramInt2 + paramInt4 - 2, paramInt1 + paramInt3 - 11, paramInt2 + paramInt4 - 2);
      drawLine(16446403, paramInt1 + 15, paramInt2 + paramInt4 - 3, paramInt1 + paramInt3 - 11, paramInt2 + paramInt4 - 3);
      drawLine(6168835, paramInt1 + 15, paramInt2 + paramInt4 - 21, paramInt1 + paramInt3 - 11, paramInt2 + paramInt4 - 21);
      g.setColor(13281366);
      g.drawRect(paramInt1 + 15, paramInt2 + paramInt4 - 18, paramInt3 - 26, 1);
    } 
  }
  
  public void drawKuangMap(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    int i;
    if (paramBoolean) {
      i = 14961;
    } else {
      i = 16762112;
    } 
    fillRect(i, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      i = 6724095;
    } else {
      i = 11370036;
    } 
    fillRect(i, paramInt1 + 1, paramInt2 + 1, paramInt3 - 2, paramInt4 - 2);
  }
  
  public void drawKuangSelect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    int i = 13281366;
    if (paramInt5 == 1) {
      i = 11370036;
    } else if (paramInt5 == 2) {
      i = 2233088;
    } else if (paramInt5 == 3) {
      i = 15129744;
    } else if (paramInt5 == 4) {
      i = 16762112;
    } else if (paramInt5 == 5) {
      i = 6168835;
    } 
    g.setColor(i);
    g.fillRect(paramInt1 + 1, paramInt2, paramInt3 - 2, paramInt4);
    g.drawRect(paramInt1, paramInt2 + 1, paramInt3 - 1, paramInt4 - 3);
  }
  
  public void drawLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    g.setColor(paramInt1);
    g.drawLine(paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void drawListKY(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
    byte b;
    for (b = 0;; b = (byte)(b + 1)) {
      if (b >= paramInt1) {
        if (paramInt8 != -1)
          drawK1(paramInt2, paramInt3 + (paramInt6 + paramInt7) * paramInt8, paramInt4, paramInt6, paramInt9); 
        return;
      } 
      if (b != paramInt8)
        drawK0(paramInt2 + paramInt5, paramInt3 + (paramInt6 + paramInt7) * b, paramInt4 - (paramInt5 << 1), paramInt6, paramInt10); 
    } 
  }
  
  public void drawListSY(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    for (byte b = 0;; b = (byte)(b + 1)) {
      int i;
      if (b >= paramArrayOfObject.length) {
        Log.e("sk", "drawListSY");
        return;
      } 
      String str = paramArrayOfObject[b].toString();
      if (b == paramInt5) {
        i = paramInt6;
      } else {
        i = paramInt7;
      } 
      drawString(str, paramInt1 + (paramInt3 >> 1), b * paramInt4 + paramInt2 + 2, 17, i, paramInt8);
    } 
  }
  
  public void drawListSYHasSound(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    for (byte b = 0;; b = (byte)(b + 1)) {
      byte b1;
      int i;
      if (b >= paramArrayOfObject.length)
        return; 
      String str = paramArrayOfObject[b].toString();
      if (paramArrayOfObject[b].toString().equals("声音")) {
        b1 = 20;
      } else {
        b1 = 17;
      } 
      if (b == paramInt5) {
        i = paramInt6;
      } else {
        i = paramInt7;
      } 
      drawString(str, paramInt1 + (paramInt3 >> 1), b * paramInt4 + paramInt2 + 2, b1, i, paramInt8);
    } 
  }
  
  public void drawModuleOne(Sprite paramSprite, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    drawRegion(paramSprite.img, paramSprite.module(paramInt1, 0), paramSprite.module(paramInt1, 1), paramSprite.module(paramInt1, 2), paramSprite.module(paramInt1, 3), paramInt2, paramInt3, this.MIRROR[paramInt4], this.MIRROR2[paramInt4][paramInt5], g);
  }
  
  public void drawNum(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i;
    if (paramString.length() == 0)
      return; 
    if (paramInt3 == 0) {
      i = 0;
    } else {
      i = paramString.length() - 1;
    } 
    byte b = (byte)i;
    int j = 0;
    while (true) {
      byte b1;
      if (paramInt4 == 0) {
        b1 = 8;
      } else if (paramInt4 == 1) {
        b1 = 10;
      } else {
        b1 = 14;
      } 
      i = -1;
      char c = paramString.charAt(b);
      if (c >= '0' && c <= '9') {
        i = (byte)(c - 48);
        if (paramInt4 == 0) {
          i = (byte)(i + 10);
        } else if (paramInt4 == 1) {
          i = (byte)(i + 35);
        } else {
          i = (byte)(i + 57);
        } 
      } else if (c == '/') {
        i = 20;
      } else if (c == '-') {
        if (paramInt4 == 2) {
          i = 56;
        } else {
          i = 46;
        } 
        i = (byte)i;
      } else if (c == '+') {
        i = 47;
      } else if (c == '%') {
        i = 45;
        b1 = 14;
      } else if (c == '级') {
        i = 29;
        b1 = 12;
      } 
      if (i != -1) {
        if (paramInt3 == 0) {
          drawUi(i, paramInt1 + j, paramInt2, 36, 0);
        } else {
          drawUi(i, paramInt1 - j, paramInt2, 40, 0);
        } 
        i = (short)(j + b1);
      } else {
        if (paramInt3 == 0) {
          drawString(c, paramInt1 + j, paramInt2 + 5, 36, 3, 0);
        } else {
          drawString(c, paramInt1 - j, paramInt2 + 5, 40, 3, 0);
        } 
        i = (short)(j + 25);
      } 
      if (paramInt3 == 0) {
        b1 = (byte)(b + 1);
      } else {
        b1 = (byte)(b - 1);
      } 
      if (paramInt3 == 0) {
        b = b1;
        j = i;
        if (b1 >= paramString.length())
          return; 
        continue;
      } 
      b = b1;
      j = i;
      if (b1 <= -1)
        return; 
    } 
  }
  
  public void drawRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    g.setColor(paramInt1);
    g.drawRect(paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void drawRectZ(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    g.setColor(paramInt1);
    Graphics graphics = g;
    Ms.i();
    paramInt1 = Ms.abs(this.rz);
    Ms.i();
    int i = Ms.abs(this.rz);
    Ms.i();
    int j = Ms.abs(this.rz);
    Ms.i();
    graphics.drawRect(paramInt2 - paramInt1, paramInt3 - i, (j << 1) + paramInt4, (Ms.abs(this.rz) << 1) + paramInt5);
    byte b = (byte)(this.rz + 1);
    this.rz = b;
    if (b > paramInt6)
      this.rz = (byte)-paramInt6; 
  }
  
  public void drawRegion(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Graphics paramGraphics) {
    paramGraphics.drawRegion(paramImage, paramInt1, paramInt2, paramInt3, paramInt4, transforms[paramInt8], paramInt5, paramInt6, paramInt7);
  }
  
  public void drawString(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    // Byte code:
    //   0: ldc 13281366
    //   2: istore #7
    //   4: ldc 3676168
    //   6: istore #8
    //   8: iload_3
    //   9: iconst_1
    //   10: iadd
    //   11: istore #9
    //   13: iload #5
    //   15: tableswitch default -> 72, 0 -> 253, 1 -> 262, 2 -> 272, 3 -> 282, 4 -> 293, 5 -> 303, 6 -> 313, 7 -> 323, 8 -> 333, 9 -> 343, 10 -> 353
    //   72: iload #8
    //   74: istore #5
    //   76: iload #7
    //   78: istore_3
    //   79: iload #6
    //   81: iconst_2
    //   82: if_icmpne -> 212
    //   85: getstatic dm/Ui.g : Ljavax/microedition/lcdui/Graphics;
    //   88: iload_3
    //   89: invokevirtual setColor : (I)V
    //   92: getstatic dm/Ui.g : Ljavax/microedition/lcdui/Graphics;
    //   95: aload_1
    //   96: iload_2
    //   97: iconst_1
    //   98: isub
    //   99: iload #9
    //   101: iload #4
    //   103: invokevirtual drawString : (Ljava/lang/String;III)V
    //   106: getstatic dm/Ui.g : Ljavax/microedition/lcdui/Graphics;
    //   109: aload_1
    //   110: iload_2
    //   111: iconst_1
    //   112: iadd
    //   113: iload #9
    //   115: iload #4
    //   117: invokevirtual drawString : (Ljava/lang/String;III)V
    //   120: getstatic dm/Ui.g : Ljavax/microedition/lcdui/Graphics;
    //   123: aload_1
    //   124: iload_2
    //   125: iload #9
    //   127: iconst_1
    //   128: isub
    //   129: iload #4
    //   131: invokevirtual drawString : (Ljava/lang/String;III)V
    //   134: getstatic dm/Ui.g : Ljavax/microedition/lcdui/Graphics;
    //   137: aload_1
    //   138: iload_2
    //   139: iload #9
    //   141: iconst_1
    //   142: iadd
    //   143: iload #4
    //   145: invokevirtual drawString : (Ljava/lang/String;III)V
    //   148: getstatic dm/Ui.g : Ljavax/microedition/lcdui/Graphics;
    //   151: aload_1
    //   152: iload_2
    //   153: iconst_1
    //   154: iadd
    //   155: iload #9
    //   157: iconst_1
    //   158: iadd
    //   159: iload #4
    //   161: invokevirtual drawString : (Ljava/lang/String;III)V
    //   164: getstatic dm/Ui.g : Ljavax/microedition/lcdui/Graphics;
    //   167: aload_1
    //   168: iload_2
    //   169: iconst_1
    //   170: isub
    //   171: iload #9
    //   173: iconst_1
    //   174: iadd
    //   175: iload #4
    //   177: invokevirtual drawString : (Ljava/lang/String;III)V
    //   180: getstatic dm/Ui.g : Ljavax/microedition/lcdui/Graphics;
    //   183: aload_1
    //   184: iload_2
    //   185: iconst_1
    //   186: isub
    //   187: iload #9
    //   189: iconst_1
    //   190: isub
    //   191: iload #4
    //   193: invokevirtual drawString : (Ljava/lang/String;III)V
    //   196: getstatic dm/Ui.g : Ljavax/microedition/lcdui/Graphics;
    //   199: aload_1
    //   200: iload_2
    //   201: iconst_1
    //   202: iadd
    //   203: iload #9
    //   205: iconst_1
    //   206: isub
    //   207: iload #4
    //   209: invokevirtual drawString : (Ljava/lang/String;III)V
    //   212: getstatic dm/Ui.g : Ljavax/microedition/lcdui/Graphics;
    //   215: iload #5
    //   217: invokevirtual setColor : (I)V
    //   220: iload #6
    //   222: iconst_1
    //   223: if_icmpne -> 240
    //   226: getstatic dm/Ui.g : Ljavax/microedition/lcdui/Graphics;
    //   229: aload_1
    //   230: iload_2
    //   231: iconst_1
    //   232: iadd
    //   233: iload #9
    //   235: iload #4
    //   237: invokevirtual drawString : (Ljava/lang/String;III)V
    //   240: getstatic dm/Ui.g : Ljavax/microedition/lcdui/Graphics;
    //   243: aload_1
    //   244: iload_2
    //   245: iload #9
    //   247: iload #4
    //   249: invokevirtual drawString : (Ljava/lang/String;III)V
    //   252: return
    //   253: iconst_0
    //   254: istore_3
    //   255: ldc 16777215
    //   257: istore #5
    //   259: goto -> 79
    //   262: ldc 5461075
    //   264: istore_3
    //   265: ldc 7727871
    //   267: istore #5
    //   269: goto -> 79
    //   272: ldc 2707928
    //   274: istore_3
    //   275: ldc 43016
    //   277: istore #5
    //   279: goto -> 79
    //   282: ldc 1908277
    //   284: istore_3
    //   285: sipush #24295
    //   288: istore #5
    //   290: goto -> 79
    //   293: ldc 1314307
    //   295: istore_3
    //   296: ldc 5228543
    //   298: istore #5
    //   300: goto -> 79
    //   303: ldc 2233603
    //   305: istore_3
    //   306: ldc 16739328
    //   308: istore #5
    //   310: goto -> 79
    //   313: ldc 8075577
    //   315: istore_3
    //   316: ldc 16189448
    //   318: istore #5
    //   320: goto -> 79
    //   323: ldc 4467457
    //   325: istore_3
    //   326: ldc 16757760
    //   328: istore #5
    //   330: goto -> 79
    //   333: ldc 10122756
    //   335: istore_3
    //   336: ldc 12583167
    //   338: istore #5
    //   340: goto -> 79
    //   343: ldc 11563064
    //   345: istore_3
    //   346: ldc 3676168
    //   348: istore #5
    //   350: goto -> 79
    //   353: ldc 1311269
    //   355: istore_3
    //   356: ldc 8816262
    //   358: istore #5
    //   360: goto -> 79
  }
  
  public void drawStringColor(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    byte b = (byte)paramInt3;
    byte b1 = 0;
    short s = 0;
    while (true) {
      byte b2 = (byte)paramString.indexOf("#", b1);
      if (b2 != -1) {
        String str = paramString.substring(b1, b2);
        drawString(str, paramInt1 + s, paramInt2, 0, b, paramInt4);
        short s1 = (short)(Ms.i().getStringWidth(str) + s);
        byte b4 = (byte)(Integer.parseInt(paramString.substring(b2 + 1, b2 + 2)) - 1);
        byte b3 = (byte)(b2 + 2);
        b = b4;
        b1 = b3;
        s = s1;
        if (b4 == -1) {
          b = (byte)paramInt3;
          s = s1;
          b1 = b3;
        } 
      } else {
        drawString(paramString.substring(b1, paramString.length()), paramInt1 + s, paramInt2, 0, b, paramInt4);
      } 
      if (b2 == -1)
        return; 
    } 
  }
  
  public void drawStringY(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    byte b;
    for (b = (byte)paramInt3;; b = (byte)(b + 1)) {
      if (b >= paramInt4 || b >= paramArrayOfObject.length)
        return; 
      i().drawString(paramArrayOfObject[b].toString(), paramInt1, paramInt2 + (b - paramInt3) * paramInt5, 0, paramInt6, paramInt7);
    } 
  }
  
  public void drawStringY(StringBuffer[] paramArrayOfStringBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    byte b;
    for (b = 0;; b = (byte)(b + 1)) {
      if (b >= paramArrayOfStringBuffer.length)
        return; 
      drawStringColor(paramArrayOfStringBuffer[b].toString(), paramInt1, paramInt2 + 4 + b * paramInt3, paramInt4, paramInt5);
    } 
  }
  
  public void drawTriangle(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void drawTriangle1(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) {
    Ms.i();
    drawUi(30, paramInt1 - paramInt3 - Ms.abs(this.cTriangle), paramInt2, 0x4 | 0x2, 4);
    Ms.i();
    drawUi(30, Ms.abs(this.cTriangle) + paramInt1 + paramInt3, paramInt2, 0x8 | 0x2, 0);
    if (paramBoolean2) {
      byte b = (byte)(this.cTriangle + 1);
      this.cTriangle = b;
      if (b > 4)
        this.cTriangle = -3; 
    } 
  }
  
  public void drawUi(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    drawRegion(this.ui_img, this.ui_modules[paramInt1][0], this.ui_modules[paramInt1][1], this.ui_modules[paramInt1][2], this.ui_modules[paramInt1][3], paramInt2, paramInt3, paramInt4, paramInt5, g);
  }
  
  public void drawVolume(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    int i;
    Graphics graphics = g;
    if (paramBoolean) {
      i = 458827;
    } else {
      i = 11563064;
    } 
    graphics.setColor(i);
    g.drawRect(paramInt1 - 1 + 3, paramInt2 + 5, 7, 10);
    g.drawRect(paramInt1 + 5 + 2 + 3, paramInt2 + 2, 7, 13);
    g.drawRect(paramInt1 + 11 + 4 + 3, paramInt2 - 1, 8, 16);
    graphics = g;
    if (paramBoolean) {
      i = 16048400;
    } else {
      i = 3676168;
    } 
    graphics.setColor(i);
    g.drawRect(paramInt1 + 3, paramInt2 + 6, 6, 8);
    g.drawRect(paramInt1 + 6 + 2 + 3, paramInt2 + 3, 6, 11);
    g.drawRect(paramInt1 + 12 + 4 + 3, paramInt2, 6, 14);
    if (paramInt3 > 0)
      g.fillRect(paramInt1 + 1 + 3, paramInt2 + 7, 5, 7); 
    if (paramInt3 > 30)
      g.fillRect(paramInt1 + 7 + 2 + 3, paramInt2 + 4, 5, 10); 
    if (paramInt3 > 60)
      g.fillRect(paramInt1 + 13 + 4 + 3, paramInt2 + 1, 5, 13); 
  }
  
  public void drawYesNo(boolean paramBoolean1, boolean paramBoolean2) {
    if (paramBoolean1)
      drawUi(27, 0, 360, 36, 0); 
    if (paramBoolean2)
      drawUi(28, 640, 360, 40, 0); 
  }
  
  public void drawYesNo_(boolean paramBoolean1, boolean paramBoolean2) {
    if (paramBoolean1)
      drawUi(27, 0, Constants_H.HEIGHT, 36, 0); 
    if (paramBoolean2)
      drawUi(28, Constants_H.WIDTH, Constants_H.HEIGHT, 40, 0); 
  }
  
  public void drawYesNo__(boolean paramBoolean1, boolean paramBoolean2) {
    int i = Constants_H.WIDTH__;
    int j = Constants_H.HEIGHT__;
    if (paramBoolean1)
      drawUi(27, 0, j, 36, 0); 
    if (paramBoolean2)
      drawUi(28, i, j, 40, 0); 
  }
  
  public void fillArc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    g.setColor(paramInt1);
    g.fillArc(paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public void fillRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    g.setColor(paramInt1);
    g.fillRect(paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void fillRectB() {
    fillRect(5422575, 0, 0, 640, 360);
  }
  
  public void initGraphics(Graphics paramGraphics) {
    g = paramGraphics;
    dg = DirectUtils.getDirectGraphics(paramGraphics);
  }
  
  public void initUiModules() {
    this.ui_img = Ms.i().createImage("data/ui");
    Ms.i();
    Ms.skip = 0;
    this.ui_modules = Ms.i().createShort2Array(Ms.i().getStream("data/ui_m.d", -1), 0);
  }
  
  public void sliding(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {
    if (!paramBoolean)
      drawK(paramInt1 - 2, paramInt2 - 2, 10 + 4, paramInt3 + 4, 0); 
    if (paramBoolean) {
      i = 0;
    } else {
      i = 3;
    } 
    drawK(paramInt1, paramInt2, 10, paramInt3, i);
    if (paramBoolean) {
      i = 3;
    } else {
      i = 0;
    } 
    drawK(paramInt1, paramInt2, 10, 11, i);
    if (paramBoolean) {
      i = 3;
    } else {
      i = 0;
    } 
    drawK(paramInt1, paramInt2 + paramInt3 - 11, 10, 11, i);
    int i = paramInt3 - 22;
    int j = paramInt5 - 1;
    if (j < 1) {
      if (paramBoolean) {
        paramInt3 = 3;
      } else {
        paramInt3 = 0;
      } 
      drawK(paramInt1 + 1, paramInt2 + 12, 10 - 2, i - 2, paramInt3);
      return;
    } 
    paramInt5 = (byte)(i / (j + 1));
    paramInt3 = paramInt5;
    if (paramInt5 < 15)
      paramInt3 = 15; 
    paramInt5 = (short)((i - 2 - paramInt3) * paramInt4 / j);
    if (paramBoolean) {
      paramInt4 = 3;
    } else {
      paramInt4 = 0;
    } 
    drawK(paramInt1 + 1, paramInt2 + 12 + paramInt5, 10 - 2, paramInt3, paramInt4);
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/dm/Ui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */