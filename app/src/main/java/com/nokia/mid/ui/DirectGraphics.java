package com.nokia.mid.ui;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Constants_H;

/* loaded from: classes.dex */
public class DirectGraphics {
    Graphics g;
    public static int FLIP_HORIZONTAL = 8192;
    public static int FLIP_VERTICAL = 16384;
    public static int ROTATE_180 = Constants_H.HEIGHT_H_;
    public static int ROTATE_270 = 270;
    public static int ROTATE_90 = 90;
    public static int TYPE_BYTE_1_GRAY = 1;
    public static int TYPE_BYTE_1_GRAY_VERTICAL = -1;
    public static int TYPE_BYTE_2_GRAY = 2;
    public static int TYPE_BYTE_332_RGB = 332;
    public static int TYPE_BYTE_4_GRAY = 4;
    public static int TYPE_BYTE_8_GRAY = 8;
    public static int TYPE_INT_888_RGB = 888;
    public static int TYPE_INT_8888_ARGB = 8888;
    public static int TYPE_USHORT_1555_ARGB = 1555;
    public static int TYPE_USHORT_444_RGB = 444;
    public static int TYPE_USHORT_4444_ARGB = 4444;
    public static int TYPE_USHORT_555_RGB = 555;
    public static int TYPE_USHORT_565_RGB = 565;
    static int[] transA = {0, 6, 3, 5, 2, 4, 1, 7};
    static int[] transB = {1, 7, 2, 4};

    public void drawImage(Image img, int x, int y, int anchor, int trans) {
        int tmpTrans;
        if ((trans & 8192) != 0) {
            tmpTrans = transA[((trans - 8192) / ROTATE_90) + 4];
        } else if ((trans & 16384) != 0) {
            tmpTrans = transB[(trans - 16384) / ROTATE_90];
        } else {
            tmpTrans = transA[trans / ROTATE_90];
        }
        this.g.drawRegion(img, 0, 0, img.getWidth(), img.getHeight(), tmpTrans, x, y, anchor);
    }

    public void fillPolygon(int[] xPoints, int xOffset, int[] yPoints, int yOffset, int nPoints, int argbColor) {
        this.g.setColor(argbColor);
        this.g.fillTriangle(xPoints[0], yPoints[0], xPoints[1], yPoints[1], xPoints[2], yPoints[2]);
        this.g.fillTriangle(xPoints[0], yPoints[0], xPoints[3], yPoints[3], xPoints[2], yPoints[2]);
    }
}
