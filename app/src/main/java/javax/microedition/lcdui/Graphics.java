package javax.microedition.lcdui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;

public final class Graphics {
    public static final int BASELINE = 0x40;
    public static final int BOTTOM = 0x20;
    public static final int DOTTED = 1;
    public static final int HCENTER = 1;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int SOLID = 0;
    public static final int TOP = 16;
    public static final int VCENTER = 2;
    private Bitmap area;
    private Canvas canvas;
    private int cliph;
    private int clipw;
    private int clipx;
    private int clipy;
    private static final DashPathEffect dashPathEffect;
    private Font font;
    private Bitmap graphicbitmap;
    private boolean isResetPainter;
    private static Rect rect1;
    private static Rect rect2;
    protected static Matrix regionMatrix;
    private int[] rgb;
    private static final StringBuffer sb;
    float scale_x;
    float scale_y;
    private int strokeStyle;
    protected static float[][] tTrans;
    protected static float[] tTransTemp;
    protected static int[][] tTransXY;
    private int translateX;
    private int translateY;
    private static Matrix ttmatrix;

    static {
        Graphics.dashPathEffect = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        Graphics.sb = new StringBuffer();
        Graphics.tTrans = new float[][]{new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{-1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}};
        Graphics.tTransTemp = new float[9];
        Graphics.regionMatrix = new Matrix();
        Graphics.tTransXY = new int[][]{new int[2], new int[]{0, 1}, new int[]{1, 0}, new int[]{1, 1}, new int[2], new int[]{1, 0}, new int[]{0, 1}, new int[]{1, 1}};
        Graphics.rect1 = new Rect();
        Graphics.rect2 = new Rect();
    }

    public Graphics() {
        this.font = Font.getDefaultFont();
        this.strokeStyle = 0;
        this.translateX = 0;
        this.translateY = 0;
        this.isResetPainter = false;
        this.scale_x = 1.0f;
        this.scale_y = 1.0f;
        this.initPaint();
    }

    public Graphics(Canvas canvas) {
        this.font = Font.getDefaultFont();
        this.strokeStyle = 0;
        this.translateX = 0;
        this.translateY = 0;
        this.isResetPainter = false;
        this.scale_x = 1.0f;
        this.scale_y = 1.0f;
        this.canvas = canvas;
        this.initPaint();
    }

    Graphics(Canvas canvas, Paint painter, Bitmap bitmap) {
        this.font = Font.getDefaultFont();
        this.strokeStyle = 0;
        this.translateX = 0;
        this.translateY = 0;
        this.isResetPainter = false;
        this.scale_x = 1.0f;
        this.scale_y = 1.0f;
        this.canvas = canvas;
        this.graphicbitmap = bitmap;
        this.font.tmpPaint = painter;
        this.initPaint();
    }

    public void clipRect(int x, int y, int width, int height) {
        this.canvas.clipRect(((float)x), ((float)y), ((float)(x + width)), ((float)(y + height)), Region.Op.INTERSECT);
        Rect rect0 = this.canvas.getClipBounds();
        this.clipx = rect0.left;
        this.clipy = rect0.top;
        this.clipw = rect0.right - rect0.left;
        this.cliph = rect0.bottom - rect0.top;
    }

    public void copyArea(int x_src, int y_src, int width, int height, int x_dest, int y_dest, int anchor) {
        boolean anchorError = false;
        if(this.graphicbitmap != null) {
            if(anchor != 0) {
                if((anchor & 0x40) != 0) {
                    anchorError = true;
                }
                if((anchor & 16) == 0) {
                    if((anchor & 0x20) == 0) {
                        if((anchor & 2) == 0) {
                            anchorError = true;
                        }
                        else {
                            y_dest -= height - 1 >>> 1;
                        }
                    }
                    else if((anchor & 2) != 0) {
                        anchorError = true;
                    }
                    else {
                        y_dest -= height - 1;
                    }
                }
                else if((anchor & 34) != 0) {
                    anchorError = true;
                }
                if((anchor & 4) == 0) {
                    if((anchor & 8) == 0) {
                        if((anchor & 1) == 0) {
                            anchorError = true;
                        }
                        else {
                            x_dest -= width - 1 >>> 1;
                        }
                    }
                    else if((anchor & 1) != 0) {
                        anchorError = true;
                    }
                    else {
                        x_dest -= width - 1;
                    }
                }
                else if((anchor & 9) != 0) {
                    anchorError = true;
                }
            }
            if(anchorError) {
                throw new IllegalArgumentException("anchor error");
            }
            if(this.area != null && this.area.getWidth() == width && this.area.getHeight() == height) {
                if(this.rgb == null || this.rgb.length != width * height) {
                    this.rgb = new int[width * height];
                }
                this.graphicbitmap.getPixels(this.rgb, 0, width, x_src, y_src, width, height);
                this.area.setPixels(this.rgb, 0, width, 0, 0, width, height);
            }
            else {
                this.area = Bitmap.createBitmap(this.graphicbitmap, x_src, y_src, width, height);
            }
            this.font.tmpPaint.setStyle(Paint.Style.STROKE);
            this.canvas.drawBitmap(this.area, ((float)x_dest), ((float)y_dest), this.font.tmpPaint);
            this.font.tmpPaint.setStyle(Paint.Style.FILL);
        }
    }

    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        this.font.tmpPaint.setStyle(Paint.Style.STROKE);
        this.canvas.drawArc(new RectF(((float)x), ((float)y), ((float)(x + width)), ((float)(y + height))), ((float)startAngle), ((float)arcAngle), false, this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint.Style.FILL);
    }

    public void drawChar(char character, int x, int y, int anchor) {
        Graphics.sb.delete(0, Graphics.sb.length());
        Graphics.sb.append(character);
        this.drawString("", x, y, anchor);
    }

    public void drawChars(char[] data, int offset, int length, int x, int y, int anchor) {
        Graphics.sb.delete(0, Graphics.sb.length());
        Graphics.sb.append(data, offset, length);
        this.drawString("", x, y, anchor);
    }

    public void drawImage(Image img, int x, int y, int anchor) {
        if((anchor & 8) != 0) {
            x -= img.getWidth();
        }
        else if((anchor & 1) != 0) {
            x -= img.getWidth() / 2;
        }
        if((anchor & 0x20) != 0) {
            y -= img.getHeight();
        }
        else if((anchor & 2) != 0) {
            y -= img.getHeight() / 2;
        }
        this.canvas.drawBitmap(img.getBitMapInpackage(), ((float)x), ((float)y), this.font.tmpPaint);
    }

    public void drawLine(float x1, float y1, float x2, float y2) {
        this.canvas.drawLine(x1, y1, x2, y2, this.font.tmpPaint);
    }

    public void drawRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height, boolean processAlpha) {
        if(rgbData == null) {
            throw new NullPointerException();
        }
        if(width <= 0 || height <= 0) {
            return;
        }
        if(width < 0 || height < 0 || offset < 0 || offset >= rgbData.length || scanlength < 0 && (height - 1) * scanlength < 0 || scanlength >= 0 && (height - 1) * scanlength + width - 1 >= rgbData.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int rgb1 = rgbData[0];
        int rgb2 = rgbData[rgbData.length / 2];
        int rgb3 = rgbData[rgbData.length / 3];
        int rgb4 = rgbData[rgbData.length / 4];
        int rgb5 = rgbData[rgbData.length * 5 / 8];
        if(rgb1 == rgb2 && rgb2 == rgb3 && rgb3 == rgb4 && rgb4 == rgb5 && rgb5 == rgbData[rgbData.length * 4 / 5]) {
            this.font.tmpPaint.setColor(rgb1);
            this.fillRect(x, y, width, height);
            return;
        }
        if(scanlength < width) {
            scanlength = width;
        }
        this.font.tmpPaint.setStyle(Paint.Style.STROKE);
        this.canvas.drawBitmap(rgbData, offset, scanlength, x, y, width, height, processAlpha, this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint.Style.FILL);
    }

    public void drawRect(int x, int y, int width, int height) {
        this.font.tmpPaint.setStyle(Paint.Style.STROKE);
        this.canvas.drawRect(((float)x), ((float)y), ((float)(x + width)), ((float)(y + height)), this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint.Style.FILL);
    }

    public void drawRegion(Image src, int x_src, int y_src, int width, int height, int transform, int x, int y, int anchor) {
        int tmp_w = width;
        int tmp_h = height;
        if(transform > 3) {
            tmp_w = height;
            tmp_h = width;
        }
        if((anchor & 8) != 0) {
            x -= tmp_w;
        }
        else if((anchor & 1) != 0) {
            x -= tmp_w / 2;
        }
        if((anchor & 0x20) != 0) {
            y -= tmp_h;
        }
        else if((anchor & 2) != 0) {
            y -= tmp_h / 2;
        }
        if(transform == 0) {
            Graphics.rect1.set(x_src, y_src, x_src + width, y_src + height);
            Graphics.rect2.set(x, y, x + width, y + height);
            this.canvas.drawBitmap(src.getBitMapInpackage(), Graphics.rect1, Graphics.rect2, this.font.tmpPaint);
            return;
        }
        Graphics.ttmatrix = this.canvas.getMatrix();
        System.arraycopy(Graphics.tTrans[transform], 0, Graphics.tTransTemp, 0, 9);
        Graphics.tTransTemp[2] = (float)(Graphics.tTransXY[transform][0] * tmp_w + x);
        Graphics.tTransTemp[5] = (float)(Graphics.tTransXY[transform][1] * tmp_h + y);
        Graphics.regionMatrix.setValues(Graphics.tTransTemp);
        if((this.scale_x != 1.0f) || this.scale_y != 1.0f) {
            Graphics.regionMatrix.postScale(this.scale_x, this.scale_y);
        }
        this.canvas.setMatrix(Graphics.regionMatrix);
        Graphics.rect1.set(x_src, y_src, x_src + width, y_src + height);
        Graphics.rect2.set(0, 0, width + 1, height);
        this.canvas.drawBitmap(src.getBitMapInpackage(), Graphics.rect1, Graphics.rect2, this.font.tmpPaint);
        this.canvas.setMatrix(Graphics.ttmatrix);
    }

    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        this.font.tmpPaint.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF(((float)x), ((float)y), ((float)(x + width)), ((float)(y + height)));
        this.canvas.drawRoundRect(rectF, ((float)arcWidth), ((float)arcHeight), this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint.Style.FILL);
    }

    public void drawString(String str, int x, int y, int anchor) {
        int v3 = y - 5;
        if(anchor == 0) {
            anchor = 20;
        }
        if((anchor & 16) != 0) {
            v3 -= this.font.getMetricsInt().top;
        }
        else if((anchor & 0x20) != 0) {
            v3 -= this.font.getMetricsInt().bottom;
        }
        else if((anchor & 2) != 0) {
            v3 += (this.font.getMetricsInt().descent - this.font.getMetricsInt().ascent) / 2 - this.font.getMetricsInt().descent;
        }
        if((anchor & 1) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.CENTER);
        }
        else if((anchor & 8) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.RIGHT);
        }
        else if((anchor & 4) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.LEFT);
        }
        this.canvas.drawText(str, ((float)x), ((float)v3), this.font.tmpPaint);
    }

    public void drawSubstring(String str, int offset, int len, int x, int y, int anchor) {
        if(anchor == 0) {
            anchor = 20;
        }
        if((anchor & 16) != 0) {
            y -= this.font.getMetricsInt().top;
        }
        else if((anchor & 0x20) != 0) {
            y -= this.font.getMetricsInt().bottom;
        }
        else if((anchor & 2) != 0) {
            y += (this.font.getMetricsInt().descent - this.font.getMetricsInt().ascent) / 2 - this.font.getMetricsInt().descent;
        }
        if((anchor & 1) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.CENTER);
        }
        else if((anchor & 8) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.RIGHT);
        }
        else if((anchor & 4) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.LEFT);
        }
        this.canvas.drawText(str, offset, len + offset, ((float)x), ((float)y), this.font.tmpPaint);
    }

    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        this.canvas.drawArc(new RectF(((float)x), ((float)y), ((float)(x + width)), ((float)(y + height))), ((float)startAngle), ((float)arcAngle), false, this.font.tmpPaint);
    }

    public void fillRect(int x, int y, int width, int height) {
        this.canvas.drawRect(((float)x), ((float)y), ((float)(x + width)), ((float)(y + height)), this.font.tmpPaint);
    }

    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        this.canvas.drawRoundRect(new RectF(((float)x), ((float)y), ((float)(x + width)), ((float)(y + height))), ((float)arcWidth), ((float)arcHeight), this.font.tmpPaint);
    }

    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        Path path = new Path();
        path.moveTo(((float)x1), ((float)y1));
        path.lineTo(((float)x2), ((float)y2));
        path.lineTo(((float)x3), ((float)y3));
        path.lineTo(((float)x1), ((float)y1));
        this.canvas.drawPath(path, this.font.tmpPaint);
    }

    public int getBlueComponent() {
        return this.font.tmpPaint.getColor() & 0xFF;
    }

    public Canvas getCanvas() throws NullPointerException {
        if(this.canvas == null) {
            throw new NullPointerException();
        }
        return this.canvas;
    }

    public int getClipHeight() {
        return this.cliph;
    }

    public int getClipWidth() {
        return this.clipw;
    }

    public int getClipX() {
        return this.clipx;
    }

    public int getClipY() {
        return this.clipy;
    }

    public int getColor() {
        return this.font.tmpPaint.getColor();
    }

    public int getDisplayColor(int color) {
        return color;
    }

    public Font getFont() {
        return this.font;
    }

    public int getGrayScale() {
        return (this.getRedComponent() + this.getGreenComponent() + this.getBlueComponent()) / 3;
    }

    public int getGreenComponent() {
        return this.font.tmpPaint.getColor() >> 8 & 0xFF;
    }

    public int getRedComponent() {
        return this.font.tmpPaint.getColor() >> 16 & 0xFF;
    }

    public int getStrokeStyle() {
        return this.strokeStyle;
    }

    public int getTranslateX() {
        return this.translateX;
    }

    public int getTranslateY() {
        return this.translateY;
    }

    public void getXY(float x, float y) {
        this.scale_x = x;
        this.scale_y = y;
    }

    private void initPaint() {
        this.font.tmpPaint.setAntiAlias(true);
    }

    public boolean isAutoResetPainter() {
        return this.isResetPainter;
    }

    public void painterAutoReset(boolean flag) {
        this.isResetPainter = flag;
    }

    public void painterReset() {
        this.font.tmpPaint.reset();
    }

    public void restCanvas() {
        this.canvas.restore();
        this.canvas.save(2);
    }

    void setCanvas(Canvas canvas) {
        this.canvas = canvas;
        this.initPaint();
    }

    public void setClip(int x, int y, int width, int height) {
        this.clipx = x;
        this.clipy = y;
        this.clipw = width;
        this.cliph = height;
        if(width < 0 || height < 0) {
            return;
        }
        this.canvas.clipRect(((float)x), ((float)y), ((float)(x + width)), ((float)(y + height)), Region.Op.REPLACE);
    }

    public void setColor(int RGB) {
        if((RGB & 0xFF000000) != 0) {
            this.font.tmpPaint.setColor(RGB);
            return;
        }
        this.font.tmpPaint.setColor(0xFF000000 | RGB);
    }

    public void setColor(int red, int green, int blue) {
        this.setColor(Color.rgb(red, green, blue));
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setGrayScale(int grey) {
        if(grey < 0 || grey > 0xFF) {
            throw new IllegalArgumentException();
        }
        this.setColor(grey, grey, grey);
    }

    public void setStrokeStyle(int style) {
        throw new IllegalArgumentException();
    }

    public void translate(int x, int y) {
        this.canvas.translate(((float)x), ((float)y));
        this.translateX += x;
        this.translateY += y;
        this.clipx -= x;
        this.clipy -= y;
    }
}

