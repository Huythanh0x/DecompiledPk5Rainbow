package com.nokia.mid.ui.DirectGraphics;
import java.lang.Object;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;

public class DirectGraphics	// class@000082 from classes.dex
{
    Graphics g;
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
    static int[] transA;
    static int[] transB;

    static {
       DirectGraphics.FLIP_HORIZONTAL = 8192;
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
       DirectGraphics.TYPE_USHORT_1555_ARGB = 1555;
       DirectGraphics.TYPE_USHORT_444_RGB = 444;
       DirectGraphics.TYPE_USHORT_4444_ARGB = 4444;
       DirectGraphics.TYPE_USHORT_555_RGB = 555;
       DirectGraphics.TYPE_USHORT_565_RGB = 565;
       int[] ointArray = new int[8];
       ointArray[1] = 6;
       ointArray[2] = 3;
       ointArray[3] = 5;
       ointArray[4] = 2;
       ointArray[5] = 4;
       ointArray[6] = 1;
       ointArray[7] = 7;
       DirectGraphics.transA = ointArray;
       DirectGraphics.transB = new int[4]{1,7,2,4};
    }
    protected void DirectGraphics(){
       super();
    }
    public void drawImage(Image img,int x,int y,int anchor,int trans){
       int tmpTrans = 0;
       if ((trans & 0x2000)) {
          trans = trans - 8192;
          tmpTrans = DirectGraphics.transA[((trans / DirectGraphics.ROTATE_90) + 4)];
       }else if((trans & 0x4000)){
          trans = trans - 16384;
          tmpTrans = DirectGraphics.transB[(trans / DirectGraphics.ROTATE_90)];
       }else {
          tmpTrans = DirectGraphics.transA[(trans / DirectGraphics.ROTATE_90)];
       }
       this.g.drawRegion(img, 0, 0, img.getWidth(), img.getHeight(), tmpTrans, x, y, anchor);
       return;
    }
    public void fillPolygon(int[] xPoints,int xOffset,int[] yPoints,int yOffset,int nPoints,int argbColor){
       this.g.setColor(argbColor);
       this.g.fillTriangle(xPoints[0], yPoints[0], xPoints[1], yPoints[1], xPoints[2], yPoints[2]);
       this.g.fillTriangle(xPoints[0], yPoints[0], xPoints[3], yPoints[3], xPoints[2], yPoints[2]);
    }
}
