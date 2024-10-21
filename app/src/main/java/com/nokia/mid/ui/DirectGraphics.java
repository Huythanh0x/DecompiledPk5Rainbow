/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
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
    public static int TYPE_INT_888_RGB;
    public static int TYPE_USHORT_1555_ARGB;
    public static int TYPE_USHORT_4444_ARGB;
    public static int TYPE_USHORT_444_RGB;
    public static int TYPE_USHORT_555_RGB;
    public static int TYPE_USHORT_565_RGB;
    static int[] transA;
    static int[] transB;
    Graphics g;

    static {
        TYPE_INT_888_RGB = 888;
        TYPE_INT_8888_ARGB = 8888;
        TYPE_USHORT_1555_ARGB = 1555;
        TYPE_USHORT_444_RGB = 444;
        TYPE_USHORT_4444_ARGB = 4444;
        TYPE_USHORT_555_RGB = 555;
        TYPE_USHORT_565_RGB = 565;
        int[] nArray = new int[8];
        nArray[1] = 6;
        nArray[2] = 3;
        nArray[3] = 5;
        nArray[4] = 2;
        nArray[5] = 4;
        nArray[6] = 1;
        nArray[7] = 7;
        transA = nArray;
        transB = new int[]{1, 7, 2, 4};
    }

    protected DirectGraphics() {
    }

    /*
     * Unable to fully structure code
     */
    public void drawImage(Image var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        block2: {
            if ((var5_5 & 8192) != 0) {
                var5_5 = DirectGraphics.transA[(var5_5 - 8192) / DirectGraphics.ROTATE_90 + 4];
lbl3:
                // 3 sources

                while (true) {
                    this.g.drawRegion(var1_1, 0, 0, var1_1.getWidth(), var1_1.getHeight(), var5_5, var2_2, var3_3, var4_4);
                    return;
                }
            }
            if ((var5_5 & 16384) == 0) break block2;
            var5_5 = DirectGraphics.transB[(var5_5 - 16384) / DirectGraphics.ROTATE_90];
            ** GOTO lbl3
        }
        var5_5 = DirectGraphics.transA[var5_5 / DirectGraphics.ROTATE_90];
        ** while (true)
    }

    public void fillPolygon(int[] nArray, int n, int[] nArray2, int n2, int n3, int n4) {
        this.g.setColor(n4);
        this.g.fillTriangle(nArray[0], nArray2[0], nArray[1], nArray2[1], nArray[2], nArray2[2]);
        this.g.fillTriangle(nArray[0], nArray2[0], nArray[3], nArray2[3], nArray[2], nArray2[2]);
    }
}
