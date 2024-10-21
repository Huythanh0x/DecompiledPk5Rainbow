package com.nokia.mid.ui;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class DirectGraphics {
  public static int FLIP_HORIZONTAL = 8192;
  
  public static int FLIP_VERTICAL = 16384;
  
  public static int ROTATE_180 = 180;
  
  public static int ROTATE_270 = 270;
  
  public static int ROTATE_90 = 90;
  
  public static int TYPE_BYTE_1_GRAY = 1;
  
  public static int TYPE_BYTE_1_GRAY_VERTICAL = -1;
  
  public static int TYPE_BYTE_2_GRAY = 2;
  
  public static int TYPE_BYTE_332_RGB = 332;
  
  public static int TYPE_BYTE_4_GRAY = 4;
  
  public static int TYPE_BYTE_8_GRAY = 8;
  
  public static int TYPE_INT_8888_ARGB;
  
  public static int TYPE_INT_888_RGB = 888;
  
  public static int TYPE_USHORT_1555_ARGB;
  
  public static int TYPE_USHORT_4444_ARGB;
  
  public static int TYPE_USHORT_444_RGB;
  
  public static int TYPE_USHORT_555_RGB;
  
  public static int TYPE_USHORT_565_RGB;
  
  static int[] transA;
  
  static int[] transB;
  
  Graphics g;
  
  static {
    TYPE_INT_8888_ARGB = 8888;
    TYPE_USHORT_1555_ARGB = 1555;
    TYPE_USHORT_444_RGB = 444;
    TYPE_USHORT_4444_ARGB = 4444;
    TYPE_USHORT_555_RGB = 555;
    TYPE_USHORT_565_RGB = 565;
    int[] arrayOfInt = new int[8];
    arrayOfInt[1] = 6;
    arrayOfInt[2] = 3;
    arrayOfInt[3] = 5;
    arrayOfInt[4] = 2;
    arrayOfInt[5] = 4;
    arrayOfInt[6] = 1;
    arrayOfInt[7] = 7;
    transA = arrayOfInt;
    transB = new int[] { 1, 7, 2, 4 };
  }
  
  public void drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if ((paramInt4 & 0x2000) != 0) {
      paramInt4 = transA[(paramInt4 - 8192) / ROTATE_90 + 4];
    } else if ((paramInt4 & 0x4000) != 0) {
      paramInt4 = transB[(paramInt4 - 16384) / ROTATE_90];
    } else {
      paramInt4 = transA[paramInt4 / ROTATE_90];
    } 
    this.g.drawRegion(paramImage, 0, 0, paramImage.getWidth(), paramImage.getHeight(), paramInt4, paramInt1, paramInt2, paramInt3);
  }
  
  public void fillPolygon(int[] paramArrayOfint1, int paramInt1, int[] paramArrayOfint2, int paramInt2, int paramInt3, int paramInt4) {
    this.g.setColor(paramInt4);
    this.g.fillTriangle(paramArrayOfint1[0], paramArrayOfint2[0], paramArrayOfint1[1], paramArrayOfint2[1], paramArrayOfint1[2], paramArrayOfint2[2]);
    this.g.fillTriangle(paramArrayOfint1[0], paramArrayOfint2[0], paramArrayOfint1[3], paramArrayOfint2[3], paramArrayOfint1[2], paramArrayOfint2[2]);
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/nokia/mid/ui/DirectGraphics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */