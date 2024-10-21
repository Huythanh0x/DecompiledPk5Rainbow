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
   public static int TYPE_INT_8888_ARGB = 8888;
   public static int TYPE_INT_888_RGB = 888;
   public static int TYPE_USHORT_1555_ARGB = 1555;
   public static int TYPE_USHORT_4444_ARGB = 4444;
   public static int TYPE_USHORT_444_RGB = 444;
   public static int TYPE_USHORT_555_RGB = 555;
   public static int TYPE_USHORT_565_RGB = 565;
   static int[] transA;
   static int[] transB;
   Graphics g;

   static {
      int[] var0 = new int[]{0, 6, 3, 5, 2, 4, 1, 7};
      transA = var0;
      transB = new int[]{1, 7, 2, 4};
   }

   protected DirectGraphics() {
      super();
   }

   public void drawImage(Image var1, int var2, int var3, int var4, int var5) {
      if ((var5 & 8192) != 0) {
         var5 = transA[(var5 - 8192) / ROTATE_90 + 4];
      } else if ((var5 & 16384) != 0) {
         var5 = transB[(var5 - 16384) / ROTATE_90];
      } else {
         var5 = transA[var5 / ROTATE_90];
      }

      this.g.drawRegion(var1, 0, 0, var1.getWidth(), var1.getHeight(), var5, var2, var3, var4);
   }

   public void fillPolygon(int[] var1, int var2, int[] var3, int var4, int var5, int var6) {
      this.g.setColor(var6);
      this.g.fillTriangle(var1[0], var3[0], var1[1], var3[1], var1[2], var3[2]);
      this.g.fillTriangle(var1[0], var3[0], var1[3], var3[3], var1[2], var3[2]);
   }
}
