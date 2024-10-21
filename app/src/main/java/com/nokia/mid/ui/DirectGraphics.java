package com.nokia.mid.ui;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class DirectGraphics {
    public static int FLIP_HORIZONTAL;
    public static int FLIP_VERTICAL;
    public static int ROTATE_180;
    public static int ROTATE_270;
    public static int ROTATE_90;
    public static int TYPE_BYTE_1_GRAY;
    public static int TYPE_BYTE_1_GRAY_VERTICAL;
    public static int TYPE_BYTE_2_GRAY;
    public static int TYPE_BYTE_332_RGB;
    public static int TYPE_BYTE_4_GRAY;
    public static int TYPE_BYTE_8_GRAY;
    public static int TYPE_INT_8888_ARGB;
    public static int TYPE_INT_888_RGB;
    public static int TYPE_USHORT_1555_ARGB;
    public static int TYPE_USHORT_4444_ARGB;
    public static int TYPE_USHORT_444_RGB;
    public static int TYPE_USHORT_555_RGB;
    public static int TYPE_USHORT_565_RGB;
    Graphics g;
    static int[] transA;
    static int[] transB;

    static {
        DirectGraphics.FLIP_HORIZONTAL = 0x2000;
        DirectGraphics.FLIP_VERTICAL = 0x4000;
        DirectGraphics.ROTATE_180 = 180;
        DirectGraphics.ROTATE_270 = 270;
        DirectGraphics.ROTATE_90 = 90;
        DirectGraphics.TYPE_BYTE_1_GRAY = 1;
        DirectGraphics.TYPE_BYTE_1_GRAY_VERTICAL = -1;
        DirectGraphics.TYPE_BYTE_2_GRAY = 2;
        DirectGraphics.TYPE_BYTE_332_RGB = 332;
        DirectGraphics.TYPE_BYTE_4_GRAY = 4;
        DirectGraphics.TYPE_BYTE_8_GRAY = 8;
        DirectGraphics.TYPE_INT_888_RGB = 888;
        DirectGraphics.TYPE_INT_8888_ARGB = 8888;
        DirectGraphics.TYPE_USHORT_1555_ARGB = 0x613;
        DirectGraphics.TYPE_USHORT_444_RGB = 444;
        DirectGraphics.TYPE_USHORT_4444_ARGB = 4444;
        DirectGraphics.TYPE_USHORT_555_RGB = 555;
        DirectGraphics.TYPE_USHORT_565_RGB = 565;
        DirectGraphics.transA = new int[]{0, 6, 3, 5, 2, 4, 1, 7};
        DirectGraphics.transB = new int[]{1, 7, 2, 4};
    }

    public void drawImage(Image img, int x, int y, int anchor, int trans) {
        int tmpTrans;
        if((trans & 0x2000) == 0) {
            tmpTrans = (trans & 0x4000) == 0 ? DirectGraphics.transA[trans / DirectGraphics.ROTATE_90] : DirectGraphics.transB[(trans - 0x4000) / DirectGraphics.ROTATE_90];
        }
        else {
            tmpTrans = DirectGraphics.transA[(trans - 0x2000) / DirectGraphics.ROTATE_90 + 4];
        }
        this.g.drawRegion(img, 0, 0, img.getWidth(), img.getHeight(), tmpTrans, x, y, anchor);
    }

    public void fillPolygon(int[] xPoints, int xOffset, int[] yPoints, int yOffset, int nPoints, int argbColor) {
        this.g.setColor(argbColor);
        this.g.fillTriangle(xPoints[0], yPoints[0], xPoints[1], yPoints[1], xPoints[2], yPoints[2]);
        this.g.fillTriangle(xPoints[0], yPoints[0], xPoints[3], yPoints[3], xPoints[2], yPoints[2]);
    }
}

