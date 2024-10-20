package javax.microedition.lcdui.Graphics;
import android.graphics.DashPathEffect;
import java.lang.StringBuffer;
import android.graphics.Matrix;
import android.graphics.Rect;
import java.lang.Object;
import javax.microedition.lcdui.Font;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Bitmap;
import android.graphics.Region$Op;
import java.lang.IllegalArgumentException;
import java.lang.String;
import android.graphics.Paint$Style;
import android.graphics.RectF;
import javax.microedition.lcdui.Image;
import java.lang.NullPointerException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.System;
import android.graphics.Paint$FontMetricsInt;
import android.graphics.Paint$Align;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.PathEffect;

public final class Graphics	// class@000142 from classes.dex
{
    private Bitmap area;
    private Canvas canvas;
    private int cliph;
    private int clipw;
    private int clipx;
    private int clipy;
    private Font font;
    private Bitmap graphicbitmap;
    private boolean isResetPainter;
    private int[] rgb;
    float scale_x;
    float scale_y;
    private int strokeStyle;
    private int translateX;
    private int translateY;
    public static final int BASELINE = 64;
    public static final int BOTTOM = 32;
    public static final int DOTTED = 1;
    public static final int HCENTER = 1;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int SOLID = 0;
    public static final int TOP = 16;
    public static final int VCENTER = 2;
    private static final DashPathEffect dashPathEffect;
    private static Rect rect1;
    private static Rect rect2;
    protected static Matrix regionMatrix;
    private static final StringBuffer sb;
    protected static float[][] tTrans;
    protected static float[] tTransTemp;
    protected static int[][] tTransXY;
    private static Matrix ttmatrix;

    static {
       Graphics.dashPathEffect = new DashPathEffect(new float[2]{0x40a00000,0x40a00000}, 0);
       Graphics.sb = "";
       float[][] uofloatArray = new float[][8]{new float[9]{0x3f800000,0,0,0,0x3f800000,0,0,0,0x3f800000},new float[9]{0x3f800000,0,0,0,0xbf800000,0,0,0,0x3f800000},new float[9]{0xbf800000,0,0,0,0x3f800000,0,0,0,0x3f800000},new float[9]{0xbf800000,0,0,0,0xbf800000,0,0,0,0x3f800000},new float[9]{0,0x3f800000,0,0x3f800000,0,0,0,0,0x3f800000},new float[9]{0,0xbf800000,0,0x3f800000,0,0,0,0,0x3f800000},new float[9]{0,0x3f800000,0,0xbf800000,0,0,0,0,0x3f800000},new float[9]{0,0xbf800000,0,0xbf800000,0,0,0,0,0x3f800000}};
       Graphics.tTrans = uofloatArray;
       float[] uofloatArray1 = new float[9];
       Graphics.tTransTemp = uofloatArray1;
       Graphics.regionMatrix = new Matrix();
       int[][] ointArray = new int[][8];
       int[] ointArray1 = new int[2];
       ointArray[0] = ointArray1;
       ointArray1 = new int[2];
       ointArray1[1] = 1;
       ointArray[1] = ointArray1;
       ointArray1 = new int[2];
       ointArray1[0] = 1;
       ointArray[2] = ointArray1;
       ointArray[3] = new int[2]{1,1};
       int[] ointArray2 = new int[2];
       ointArray[4] = ointArray2;
       ointArray2 = new int[2];
       ointArray2[0] = 1;
       ointArray[5] = ointArray2;
       ointArray2 = new int[2];
       ointArray2[1] = 1;
       ointArray[6] = ointArray2;
       ointArray[7] = new int[2]{1,1};
       Graphics.tTransXY = ointArray;
       Graphics.rect1 = new Rect();
       Graphics.rect2 = new Rect();
    }
    public void Graphics(){
       super();
       this.font = Font.getDefaultFont();
       this.strokeStyle = 0;
       this.translateX = 0;
       this.translateY = 0;
       this.isResetPainter = false;
       this.scale_x = 1.00f;
       this.scale_y = 1.00f;
       this.initPaint();
    }
    public void Graphics(Canvas canvas){
       super();
       this.font = Font.getDefaultFont();
       this.strokeStyle = 0;
       this.translateX = 0;
       this.translateY = 0;
       this.isResetPainter = false;
       this.scale_x = 1.00f;
       this.scale_y = 1.00f;
       this.canvas = canvas;
       this.initPaint();
    }
    void Graphics(Canvas canvas,Paint painter,Bitmap bitmap){
       super();
       this.font = Font.getDefaultFont();
       this.strokeStyle = 0;
       this.translateX = 0;
       this.translateY = 0;
       this.isResetPainter = false;
       this.scale_x = 1.00f;
       this.scale_y = 1.00f;
       this.canvas = canvas;
       this.graphicbitmap = bitmap;
       this.font.tmpPaint = painter;
       this.initPaint();
    }
    private void initPaint(){
       this.font.tmpPaint.setAntiAlias(true);
    }
    public void clipRect(int x,int y,int width,int height){
       this.canvas.clipRect((float)x, (float)y, (float)(x + width), (float)(y + height), Region$Op.INTERSECT);
       Rect rect = this.canvas.getClipBounds();
       this.clipx = rect.left;
       this.clipy = rect.top;
       this.clipw = rect.right - rect.left;
       this.cliph = rect.bottom - rect.top;
    }
    public void copyArea(int x_src,int y_src,int width,int height,int x_dest,int y_dest,int anchor){
       if (this.graphicbitmap != null) {
          boolean anchorError = false;
          if (!anchor) {
             anchor = 20;
          }
          if ((anchor & 0x40)) {
             anchorError = true;
          }
          if ((anchor & 0x10)) {
             if ((anchor & 0x22)) {
                anchorError = true;
             }
          }else if((anchor & 0x20)){
             if ((anchor & 0x02)) {
                anchorError = true;
             }else {
                y_dest = y_dest - (height - 1);
             }
          }else if((anchor & 0x02)){
             y_dest = y_dest - ((height - 1) >> 1);
          }else {
             anchorError = true;
          }
          if ((anchor & 0x04)) {
             if ((anchor & 0x09)) {
                anchorError = true;
             }
          }else if((anchor & 0x08)){
             if ((anchor & 0x01)) {
                anchorError = true;
             }else {
                x_dest = x_dest - (width - 1);
             }
          }else if((anchor & 0x01)){
             x_dest = x_dest - ((width - 1) >> 1);
          }else {
             anchorError = true;
          }
          if (anchorError) {
             throw new IllegalArgumentException("anchor error");
          }else if(this.area != null && (this.area.getWidth() == width && this.area.getHeight() == height)){
             if (this.rgb == null || (this.rgb != null || this.rgb.length == (width * height))) {
                int[] ointArray = new int[(width * height)];
                this.rgb = ointArray;
             }
             this.graphicbitmap.getPixels(this.rgb, 0, width, x_src, y_src, width, height);
             this.area.setPixels(this.rgb, 0, width, 0, 0, width, height);
          }else {
             this.area = Bitmap.createBitmap(this.graphicbitmap, x_src, y_src, width, height);
          }
          this.font.tmpPaint.setStyle(Paint$Style.STROKE);
          this.canvas.drawBitmap(this.area, (float)x_dest, (float)y_dest, this.font.tmpPaint);
          this.font.tmpPaint.setStyle(Paint$Style.FILL);
       }
       return;
    }
    public void drawArc(int x,int y,int width,int height,int startAngle,int arcAngle){
       this.font.tmpPaint.setStyle(Paint$Style.STROKE);
       this.canvas.drawArc(new RectF((float)x, (float)y, (float)(x + width), (float)(y + height)), (float)startAngle, (float)arcAngle, false, this.font.tmpPaint);
       this.font.tmpPaint.setStyle(Paint$Style.FILL);
    }
    public void drawChar(char character,int x,int y,int anchor){
       Graphics.sb.delete(0, Graphics.sb.length());
       StringBuffer str = Graphics.sb+character;
       this.drawString(Graphics.sb, x, y, anchor);
    }
    public void drawChars(char[] data,int offset,int length,int x,int y,int anchor){
       Graphics.sb.delete(0, Graphics.sb.length());
       StringBuffer str = Graphics.sb+data;
       this.drawString(Graphics.sb, x, y, anchor);
    }
    public void drawImage(Image img,int x,int y,int anchor){
       if ((anchor & 0x08)) {
          x = x - img.getWidth();
       }else if((anchor & 0x01)){
          x = x - (img.getWidth() / 2);
       }
       if ((anchor & 0x20)) {
          y = y - img.getHeight();
       }else if((anchor & 0x02)){
          y = y - (img.getHeight() / 2);
       }
       this.canvas.drawBitmap(img.getBitMapInpackage(), (float)x, (float)y, this.font.tmpPaint);
       return;
    }
    public void drawLine(float x1,float y1,float x2,float y2){
       this.canvas.drawLine(x1, y1, x2, y2, this.font.tmpPaint);
    }
    public void drawRGB(int[] rgbData,int offset,int scanlength,int x,int y,int width,int height,boolean processAlpha){
       if (rgbData == null) {
          throw new NullPointerException();
       }
       if (width > 0 && height > 0) {
          int l = rgbData.length;
          if (width >= 0 && (height >= 0 && (offset >= 0 && (offset < l && (scanlength >= 0 && ((((height - 1) * scanlength)) < 0 && (scanlength < 0 && (((((height - 1) * scanlength) + width) - 1)) >= l))))))) {
             int rgb1 = rgbData[0];
             int rgb2 = rgbData[(l / 2)];
             int rgb3 = rgbData[(l / 3)];
             int rgb4 = rgbData[(l / 4)];
             int rgb5 = rgbData[((l * 5) / 8)];
             int rgb6 = rgbData[((l * 4) / 5)];
             if (rgb1 == rgb2 && (rgb2 == rgb3 && (rgb3 == rgb4 && (rgb4 == rgb5 && rgb5 == rgb6)))) {
                this.font.tmpPaint.setColor(rgb1);
                this.fillRect(x, y, width, height);
             }else if(scanlength < width){
                scanlength = width;
             }
             this.font.tmpPaint.setStyle(Paint$Style.STROKE);
             this.canvas.drawBitmap(rgbData, offset, scanlength, x, y, width, height, processAlpha, this.font.tmpPaint);
             this.font.tmpPaint.setStyle(Paint$Style.FILL);
          }else {
             throw new ArrayIndexOutOfBoundsException();
          }
       }
       return;
    }
    public void drawRect(int x,int y,int width,int height){
       this.font.tmpPaint.setStyle(Paint$Style.STROKE);
       this.canvas.drawRect((float)x, (float)y, (float)(x + width), (float)(y + height), this.font.tmpPaint);
       this.font.tmpPaint.setStyle(Paint$Style.FILL);
    }
    public void drawRegion(Image src,int x_src,int y_src,int width,int height,int transform,int x,int y,int anchor){
       int tmp_w = width;
       int tmp_h = height;
       if (transform > 3) {
          tmp_w = height;
          tmp_h = width;
       }
       if ((anchor & 0x08)) {
          x = x - tmp_w;
       }else if((anchor & 0x01)){
          x = x - (tmp_w / 2);
       }
       if ((anchor & 0x20)) {
          y = y - tmp_h;
       }else if((anchor & 0x02)){
          y = y - (tmp_h / 2);
       }
       if (!transform) {
          Graphics.rect1.set(x_src, y_src, (x_src + width), (y_src + height));
          Graphics.rect2.set(x, y, (x + width), (y + height));
          this.canvas.drawBitmap(src.getBitMapInpackage(), Graphics.rect1, Graphics.rect2, this.font.tmpPaint);
       }else {
          Graphics.ttmatrix = this.canvas.getMatrix();
          System.arraycopy(Graphics.tTrans[transform], 0, Graphics.tTransTemp, 0, 9);
          Graphics.tTransTemp[2] = (float)((Graphics.tTransXY[transform][0] * tmp_w) + x);
          Graphics.tTransTemp[5] = (float)((Graphics.tTransXY[transform][1] * tmp_h) + y);
          Graphics.regionMatrix.setValues(Graphics.tTransTemp);
          if ((0x3f800000 - this.scale_x) || (0x3f800000 - this.scale_y)) {
             Graphics.regionMatrix.postScale(this.scale_x, this.scale_y);
          }
          this.canvas.setMatrix(Graphics.regionMatrix);
          Graphics.rect1.set(x_src, y_src, (x_src + width), (y_src + height));
          Graphics.rect2.set(0, 0, (width + 1), height);
          this.canvas.drawBitmap(src.getBitMapInpackage(), Graphics.rect1, Graphics.rect2, this.font.tmpPaint);
          this.canvas.setMatrix(Graphics.ttmatrix);
       }
       return;
    }
    public void drawRoundRect(int x,int y,int width,int height,int arcWidth,int arcHeight){
       this.font.tmpPaint.setStyle(Paint$Style.STROKE);
       RectF rectF = new RectF((float)x, (float)y, (float)(x + width), (float)(y + height));
       this.canvas.drawRoundRect(rectF, (float)arcWidth, (float)arcHeight, this.font.tmpPaint);
       this.font.tmpPaint.setStyle(Paint$Style.FILL);
    }
    public void drawString(String str,int x,int y,int anchor){
       y = y - 5;
       if (!anchor) {
          anchor = 20;
       }
       if ((anchor & 0x10)) {
          y = y - this.font.getMetricsInt().top;
       }else if((anchor & 0x20)){
          y = y - this.font.getMetricsInt().bottom;
       }else if((anchor & 0x02)){
          y = y + (((this.font.getMetricsInt().descent - this.font.getMetricsInt().ascent) / 2) - this.font.getMetricsInt().descent);
       }
       if ((anchor & 0x01)) {
          this.font.tmpPaint.setTextAlign(Paint$Align.CENTER);
       }else if((anchor & 0x08)){
          this.font.tmpPaint.setTextAlign(Paint$Align.RIGHT);
       }else if((anchor & 0x04)){
          this.font.tmpPaint.setTextAlign(Paint$Align.LEFT);
       }
       this.canvas.drawText(str, (float)x, (float)y, this.font.tmpPaint);
       return;
    }
    public void drawSubstring(String str,int offset,int len,int x,int y,int anchor){
       if (!anchor) {
          anchor = 20;
       }
       if ((anchor & 0x10)) {
          y = y - this.font.getMetricsInt().top;
       }else if((anchor & 0x20)){
          y = y - this.font.getMetricsInt().bottom;
       }else if((anchor & 0x02)){
          y = y + (((this.font.getMetricsInt().descent - this.font.getMetricsInt().ascent) / 2) - this.font.getMetricsInt().descent);
       }
       if ((anchor & 0x01)) {
          this.font.tmpPaint.setTextAlign(Paint$Align.CENTER);
       }else if((anchor & 0x08)){
          this.font.tmpPaint.setTextAlign(Paint$Align.RIGHT);
       }else if((anchor & 0x04)){
          this.font.tmpPaint.setTextAlign(Paint$Align.LEFT);
       }
       this.canvas.drawText(str, offset, (len + offset), (float)x, (float)y, this.font.tmpPaint);
       return;
    }
    public void fillArc(int x,int y,int width,int height,int startAngle,int arcAngle){
       this.canvas.drawArc(new RectF((float)x, (float)y, (float)(x + width), (float)(y + height)), (float)startAngle, (float)arcAngle, false, this.font.tmpPaint);
    }
    public void fillRect(int x,int y,int width,int height){
       this.canvas.drawRect((float)x, (float)y, (float)(x + width), (float)(y + height), this.font.tmpPaint);
    }
    public void fillRoundRect(int x,int y,int width,int height,int arcWidth,int arcHeight){
       this.canvas.drawRoundRect(new RectF((float)x, (float)y, (float)(x + width), (float)(y + height)), (float)arcWidth, (float)arcHeight, this.font.tmpPaint);
    }
    public void fillTriangle(int x1,int y1,int x2,int y2,int x3,int y3){
       Path path = new Path();
       path.moveTo((float)x1, (float)y1);
       path.lineTo((float)x2, (float)y2);
       path.lineTo((float)x3, (float)y3);
       path.lineTo((float)x1, (float)y1);
       this.canvas.drawPath(path, this.font.tmpPaint);
    }
    public int getBlueComponent(){
       return (this.font.tmpPaint.getColor() & 0x00ff);
    }
    public Canvas getCanvas(){
       if (this.canvas == null) {
          throw new NullPointerException();
       }
       return this.canvas;
    }
    public int getClipHeight(){
       return this.cliph;
    }
    public int getClipWidth(){
       return this.clipw;
    }
    public int getClipX(){
       return this.clipx;
    }
    public int getClipY(){
       return this.clipy;
    }
    public int getColor(){
       return this.font.tmpPaint.getColor();
    }
    public int getDisplayColor(int color){
       return color;
    }
    public Font getFont(){
       return this.font;
    }
    public int getGrayScale(){
       return (((this.getRedComponent() + this.getGreenComponent()) + this.getBlueComponent()) / 3);
    }
    public int getGreenComponent(){
       return ((this.font.tmpPaint.getColor() >> 8) & 0x00ff);
    }
    public int getRedComponent(){
       return ((this.font.tmpPaint.getColor() >> 16) & 0x00ff);
    }
    public int getStrokeStyle(){
       return this.strokeStyle;
    }
    public int getTranslateX(){
       return this.translateX;
    }
    public int getTranslateY(){
       return this.translateY;
    }
    public void getXY(float x,float y){
       this.scale_x = x;
       this.scale_y = y;
    }
    public boolean isAutoResetPainter(){
       return this.isResetPainter;
    }
    public void painterAutoReset(boolean flag){
       this.isResetPainter = flag;
    }
    public void painterReset(){
       this.font.tmpPaint.reset();
    }
    public void restCanvas(){
       this.canvas.restore();
       this.canvas.save(2);
    }
    void setCanvas(Canvas canvas){
       this.canvas = canvas;
       this.initPaint();
    }
    public void setClip(int x,int y,int width,int height){
       this.clipx = x;
       this.clipy = y;
       this.clipw = width;
       this.cliph = height;
       if (width >= 0 && height >= 0) {
          this.canvas.clipRect((float)x, (float)y, (float)(x + width), (float)(y + height), Region$Op.REPLACE);
       }
       return;
    }
    public void setColor(int RGB){
       int i = 0xff000000;
       if ((RGB & i)) {
          this.font.tmpPaint.setColor(RGB);
       }else {
          this.font.tmpPaint.setColor((i | RGB));
       }
       return;
    }
    public void setColor(int red,int green,int blue){
       this.setColor(Color.rgb(red, green, blue));
    }
    public void setFont(Font font){
       this.font = font;
    }
    public void setGrayScale(int grey){
       if (grey < 0 || grey > 255) {
          throw new IllegalArgumentException();
       }
       this.setColor(grey, grey, grey);
       return;
    }
    public void setStrokeStyle(int style){
       int i = 1;
       if (style || style != i) {
          throw new IllegalArgumentException();
       }
       this.strokeStyle = style;
       if (!style) {
          this.font.tmpPaint.setPathEffect(null);
       }else if(style == i){
          this.font.tmpPaint.setPathEffect(Graphics.dashPathEffect);
       }
       return;
    }
    public void translate(int x,int y){
       this.canvas.translate((float)x, (float)y);
       this.translateX = this.translateX + x;
       this.translateY = this.translateY + y;
       this.clipx = this.clipx - x;
       this.clipy = this.clipy - y;
    }
}
