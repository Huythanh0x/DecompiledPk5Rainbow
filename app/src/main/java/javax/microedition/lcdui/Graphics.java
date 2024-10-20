package javax.microedition.lcdui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;

public final class Graphics {
    public static final int BASELINE = 64;

    public static final int BOTTOM = 32;

    public static final int DOTTED = 1;

    public static final int HCENTER = 1;

    public static final int LEFT = 4;

    public static final int RIGHT = 8;

    public static final int SOLID = 0;

    public static final int TOP = 16;

    public static final int VCENTER = 2;

    private static final DashPathEffect dashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);

    private static Rect rect1;

    private static Rect rect2;

    protected static Matrix regionMatrix;

    private static final StringBuffer sb = new StringBuffer();

    protected static float[][] tTrans;

    protected static float[] tTransTemp = new float[9];

    protected static int[][] tTransXY;

    private static Matrix ttmatrix;

    private Bitmap area;

    private Canvas canvas;

    private int cliph;

    private int clipw;

    private int clipx;

    private int clipy;

    private Font font = Font.getDefaultFont();

    private Bitmap graphicbitmap;

    private boolean isResetPainter = false;

    private int[] rgb;

    float scale_x = 1.0F;

    float scale_y = 1.0F;

    private int strokeStyle = 0;

    private int translateX = 0;

    private int translateY = 0;

    static {
        regionMatrix = new Matrix();
        int[] arrayOfInt4 = new int[2];
        int[] arrayOfInt1 = new int[2];
        arrayOfInt1[1] = 1;
        int[] arrayOfInt3 = new int[2];
        arrayOfInt3[0] = 1;
        int[] arrayOfInt2 = { 1, 1 };
        int[] arrayOfInt6 = new int[2];
        int[] arrayOfInt7 = new int[2];
        arrayOfInt7[0] = 1;
        int[] arrayOfInt5 = new int[2];
        arrayOfInt5[1] = 1;
        tTransXY = new int[][] { arrayOfInt4, arrayOfInt1, arrayOfInt3, arrayOfInt2, arrayOfInt6, arrayOfInt7, arrayOfInt5, { 1, 1 } };
        rect1 = new Rect();
        rect2 = new Rect();
    }

    public Graphics() {
        initPaint();
    }

    public Graphics(Canvas paramCanvas) {
        this.canvas = paramCanvas;
        initPaint();
    }

    Graphics(Canvas paramCanvas, Paint paramPaint, Bitmap paramBitmap) {
        this.canvas = paramCanvas;
        this.graphicbitmap = paramBitmap;
        this.font.tmpPaint = paramPaint;
        initPaint();
    }

    private void initPaint() {
        this.font.tmpPaint.setAntiAlias(true);
    }

    public void clipRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.canvas.clipRect(paramInt1, paramInt2, (paramInt1 + paramInt3), (paramInt2 + paramInt4), Region.Op.INTERSECT);
        Rect rect = this.canvas.getClipBounds();
        this.clipx = rect.left;
        this.clipy = rect.top;
        this.clipw = rect.right - rect.left;
        this.cliph = rect.bottom - rect.top;
    }

    public void copyArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
        if (this.graphicbitmap != null) {
            int i = 0;
            int j = paramInt7;
            if (paramInt7 == 0)
                j = 20;
            paramInt7 = i;
            if ((j & 0x40) != 0)
                paramInt7 = 1;
            if ((j & 0x10) != 0) {
                i = paramInt6;
                if ((j & 0x22) != 0) {
                    paramInt7 = 1;
                    i = paramInt6;
                }
            } else if ((j & 0x20) != 0) {
                if ((j & 0x2) != 0) {
                    paramInt7 = 1;
                    i = paramInt6;
                } else {
                    i = paramInt6 - paramInt4 - 1;
                }
            } else if ((j & 0x2) != 0) {
                i = paramInt6 - (paramInt4 - 1 >>> 1);
            } else {
                paramInt7 = 1;
                i = paramInt6;
            }
            if ((j & 0x4) != 0) {
                paramInt6 = paramInt5;
                if ((j & 0x9) != 0) {
                    paramInt7 = 1;
                    paramInt6 = paramInt5;
                }
            } else if ((j & 0x8) != 0) {
                if ((j & 0x1) != 0) {
                    paramInt7 = 1;
                    paramInt6 = paramInt5;
                } else {
                    paramInt6 = paramInt5 - paramInt3 - 1;
                }
            } else if ((j & 0x1) != 0) {
                paramInt6 = paramInt5 - (paramInt3 - 1 >>> 1);
            } else {
                paramInt7 = 1;
                paramInt6 = paramInt5;
            }
            if (paramInt7 != 0)
                throw new IllegalArgumentException("anchor error");
            if (this.area != null && this.area.getWidth() == paramInt3 && this.area.getHeight() == paramInt4) {
                if (this.rgb == null || (this.rgb != null && this.rgb.length != paramInt3 * paramInt4))
                    this.rgb = new int[paramInt3 * paramInt4];
                this.graphicbitmap.getPixels(this.rgb, 0, paramInt3, paramInt1, paramInt2, paramInt3, paramInt4);
                this.area.setPixels(this.rgb, 0, paramInt3, 0, 0, paramInt3, paramInt4);
            } else {
                this.area = Bitmap.createBitmap(this.graphicbitmap, paramInt1, paramInt2, paramInt3, paramInt4);
            }
            this.font.tmpPaint.setStyle(Paint.Style.STROKE);
            this.canvas.drawBitmap(this.area, paramInt6, i, this.font.tmpPaint);
            this.font.tmpPaint.setStyle(Paint.Style.FILL);
        }
    }

    public void drawArc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
        this.font.tmpPaint.setStyle(Paint.Style.STROKE);
        this.canvas.drawArc(new RectF(paramInt1, paramInt2, (paramInt1 + paramInt3), (paramInt2 + paramInt4)), paramInt5, paramInt6, false, this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint.Style.FILL);
    }

    public void drawChar(char paramChar, int paramInt1, int paramInt2, int paramInt3) {
        sb.delete(0, sb.length());
        sb.append(paramChar);
        drawString(sb.toString(), paramInt1, paramInt2, paramInt3);
    }

    public void drawChars(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        sb.delete(0, sb.length());
        sb.append(paramArrayOfchar, paramInt1, paramInt2);
        drawString(sb.toString(), paramInt3, paramInt4, paramInt5);
    }

    public void drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3) {
        int i;
        if ((paramInt3 & 0x8) != 0) {
            i = paramInt1 - paramImage.getWidth();
        } else {
            i = paramInt1;
            if ((paramInt3 & 0x1) != 0)
                i = paramInt1 - paramImage.getWidth() / 2;
        }
        if ((paramInt3 & 0x20) != 0) {
            paramInt1 = paramInt2 - paramImage.getHeight();
        } else {
            paramInt1 = paramInt2;
            if ((paramInt3 & 0x2) != 0)
                paramInt1 = paramInt2 - paramImage.getHeight() / 2;
        }
        this.canvas.drawBitmap(paramImage.getBitMapInpackage(), i, paramInt1, this.font.tmpPaint);
    }

    public void drawLine(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        this.canvas.drawLine(paramFloat1, paramFloat2, paramFloat3, paramFloat4, this.font.tmpPaint);
    }

    public void drawRGB(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean) {
        if (paramArrayOfint == null)
            throw new NullPointerException();
        if (paramInt5 > 0 && paramInt6 > 0) {
            int i1 = paramArrayOfint.length;
            if (paramInt5 < 0 || paramInt6 < 0 || paramInt1 < 0 || paramInt1 >= i1 || (paramInt2 < 0 && (paramInt6 - 1) * paramInt2 < 0) || (paramInt2 >= 0 && (paramInt6 - 1) * paramInt2 + paramInt5 - 1 >= i1))
                throw new ArrayIndexOutOfBoundsException();
            int j = paramArrayOfint[0];
            int n = paramArrayOfint[i1 / 2];
            int m = paramArrayOfint[i1 / 3];
            int k = paramArrayOfint[i1 / 4];
            int i = paramArrayOfint[i1 * 5 / 8];
            i1 = paramArrayOfint[i1 * 4 / 5];
            if (j == n && n == m && m == k && k == i && i == i1) {
                this.font.tmpPaint.setColor(j);
                fillRect(paramInt3, paramInt4, paramInt5, paramInt6);
                return;
            }
            i = paramInt2;
            if (paramInt2 < paramInt5)
                i = paramInt5;
            this.font.tmpPaint.setStyle(Paint.Style.STROKE);
            this.canvas.drawBitmap(paramArrayOfint, paramInt1, i, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean, this.font.tmpPaint);
            this.font.tmpPaint.setStyle(Paint.Style.FILL);
        }
    }

    public void drawRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.font.tmpPaint.setStyle(Paint.Style.STROKE);
        this.canvas.drawRect(paramInt1, paramInt2, (paramInt1 + paramInt3), (paramInt2 + paramInt4), this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint.Style.FILL);
    }

    public void drawRegion(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
        int i;
        int j = paramInt3;
        int k = paramInt4;
        if (paramInt5 > 3) {
            j = paramInt4;
            k = paramInt3;
        }
        if ((paramInt8 & 0x8) != 0) {
            i = paramInt6 - j;
        } else {
            i = paramInt6;
            if ((paramInt8 & 0x1) != 0)
                i = paramInt6 - j / 2;
        }
        if ((paramInt8 & 0x20) != 0) {
            paramInt6 = paramInt7 - k;
        } else {
            paramInt6 = paramInt7;
            if ((paramInt8 & 0x2) != 0)
                paramInt6 = paramInt7 - k / 2;
        }
        if (paramInt5 == 0) {
            rect1.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
            rect2.set(i, paramInt6, i + paramInt3, paramInt6 + paramInt4);
            this.canvas.drawBitmap(paramImage.getBitMapInpackage(), rect1, rect2, this.font.tmpPaint);
            return;
        }
        ttmatrix = this.canvas.getMatrix();
        System.arraycopy(tTrans[paramInt5], 0, tTransTemp, 0, 9);
        tTransTemp[2] = (tTransXY[paramInt5][0] * j + i);
        tTransTemp[5] = (tTransXY[paramInt5][1] * k + paramInt6);
        regionMatrix.setValues(tTransTemp);
        if (this.scale_x != 1.0F || this.scale_y != 1.0F)
            regionMatrix.postScale(this.scale_x, this.scale_y);
        this.canvas.setMatrix(regionMatrix);
        rect1.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
        rect2.set(0, 0, paramInt3 + 1, paramInt4);
        this.canvas.drawBitmap(paramImage.getBitMapInpackage(), rect1, rect2, this.font.tmpPaint);
        this.canvas.setMatrix(ttmatrix);
    }

    public void drawRoundRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
        this.font.tmpPaint.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF(paramInt1, paramInt2, (paramInt1 + paramInt3), (paramInt2 + paramInt4));
        this.canvas.drawRoundRect(rectF, paramInt5, paramInt6, this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint.Style.FILL);
    }

    public void drawString(String paramString, int paramInt1, int paramInt2, int paramInt3) {
        int j = paramInt2 - 5;
        int i = paramInt3;
        if (paramInt3 == 0)
            i = 20;
        if ((i & 0x10) != 0) {
            paramInt2 = j - (this.font.getMetricsInt()).top;
        } else if ((i & 0x20) != 0) {
            paramInt2 = j - (this.font.getMetricsInt()).bottom;
        } else {
            paramInt2 = j;
            if ((i & 0x2) != 0)
                paramInt2 = j + ((this.font.getMetricsInt()).descent - (this.font.getMetricsInt()).ascent) / 2 - (this.font.getMetricsInt()).descent;
        }
        if ((i & 0x1) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.CENTER);
        } else if ((i & 0x8) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.RIGHT);
        } else if ((i & 0x4) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.LEFT);
        }
        this.canvas.drawText(paramString, paramInt1, paramInt2, this.font.tmpPaint);
    }

    public void drawSubstring(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        int i = paramInt5;
        if (paramInt5 == 0)
            i = 20;
        if ((i & 0x10) != 0) {
            paramInt5 = paramInt4 - (this.font.getMetricsInt()).top;
        } else if ((i & 0x20) != 0) {
            paramInt5 = paramInt4 - (this.font.getMetricsInt()).bottom;
        } else {
            paramInt5 = paramInt4;
            if ((i & 0x2) != 0)
                paramInt5 = paramInt4 + ((this.font.getMetricsInt()).descent - (this.font.getMetricsInt()).ascent) / 2 - (this.font.getMetricsInt()).descent;
        }
        if ((i & 0x1) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.CENTER);
        } else if ((i & 0x8) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.RIGHT);
        } else if ((i & 0x4) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.LEFT);
        }
        this.canvas.drawText(paramString, paramInt1, paramInt2 + paramInt1, paramInt3, paramInt5, this.font.tmpPaint);
    }

    public void fillArc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
        this.canvas.drawArc(new RectF(paramInt1, paramInt2, (paramInt1 + paramInt3), (paramInt2 + paramInt4)), paramInt5, paramInt6, false, this.font.tmpPaint);
    }

    public void fillRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.canvas.drawRect(paramInt1, paramInt2, (paramInt1 + paramInt3), (paramInt2 + paramInt4), this.font.tmpPaint);
    }

    public void fillRoundRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
        this.canvas.drawRoundRect(new RectF(paramInt1, paramInt2, (paramInt1 + paramInt3), (paramInt2 + paramInt4)), paramInt5, paramInt6, this.font.tmpPaint);
    }

    public void fillTriangle(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
        Path path = new Path();
        path.moveTo(paramInt1, paramInt2);
        path.lineTo(paramInt3, paramInt4);
        path.lineTo(paramInt5, paramInt6);
        path.lineTo(paramInt1, paramInt2);
        this.canvas.drawPath(path, this.font.tmpPaint);
    }

    public int getBlueComponent() {
        return this.font.tmpPaint.getColor() & 0xFF;
    }

    public Canvas getCanvas() throws NullPointerException {
        if (this.canvas == null)
            throw new NullPointerException();
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

    public int getDisplayColor(int paramInt) {
        return paramInt;
    }

    public Font getFont() {
        return this.font;
    }

    public int getGrayScale() {
        return (getRedComponent() + getGreenComponent() + getBlueComponent()) / 3;
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

    public void getXY(float paramFloat1, float paramFloat2) {
        this.scale_x = paramFloat1;
        this.scale_y = paramFloat2;
    }

    public boolean isAutoResetPainter() {
        return this.isResetPainter;
    }

    public void painterAutoReset(boolean paramBoolean) {
        this.isResetPainter = paramBoolean;
    }

    public void painterReset() {
        this.font.tmpPaint.reset();
    }

    public void restCanvas() {
        this.canvas.restore();
        this.canvas.save(2);
    }

    void setCanvas(Canvas paramCanvas) {
        this.canvas = paramCanvas;
        initPaint();
    }

    public void setClip(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.clipx = paramInt1;
        this.clipy = paramInt2;
        this.clipw = paramInt3;
        this.cliph = paramInt4;
        if (paramInt3 >= 0 && paramInt4 >= 0)
            this.canvas.clipRect(paramInt1, paramInt2, (paramInt1 + paramInt3), (paramInt2 + paramInt4), Region.Op.REPLACE);
    }

    public void setColor(int paramInt) {
        if ((paramInt & 0xFF000000) != 0) {
            this.font.tmpPaint.setColor(paramInt);
            return;
        }
        this.font.tmpPaint.setColor(0xFF000000 | paramInt);
    }

    public void setColor(int paramInt1, int paramInt2, int paramInt3) {
        setColor(Color.rgb(paramInt1, paramInt2, paramInt3));
    }

    public void setFont(Font paramFont) {
        this.font = paramFont;
    }

    public void setGrayScale(int paramInt) {
        if (paramInt < 0 || paramInt > 255)
            throw new IllegalArgumentException();
        setColor(paramInt, paramInt, paramInt);
    }

    public void setStrokeStyle(int paramInt) {
        if (paramInt != 0 || paramInt != 1)
            throw new IllegalArgumentException();
        this.strokeStyle = paramInt;
        if (paramInt == 0) {
            this.font.tmpPaint.setPathEffect(null);
            return;
        }
        if (paramInt == 1)
            this.font.tmpPaint.setPathEffect((PathEffect)dashPathEffect);
    }

    public void translate(int paramInt1, int paramInt2) {
        this.canvas.translate(paramInt1, paramInt2);
        this.translateX += paramInt1;
        this.translateY += paramInt2;
        this.clipx -= paramInt1;
        this.clipy -= paramInt2;
    }

    static {
        float[] arrayOfFloat = { -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F };
        tTrans = new float[][] { { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F }, { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F }, arrayOfFloat, { -1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F }, { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F }, { 0.0F, -1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F }, { 0.0F, 1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F }, { 0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F } };
    }
}
