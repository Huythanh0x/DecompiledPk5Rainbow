package javax.microedition.lcdui;

import android.graphics.PathEffect;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Paint$Align;
import android.graphics.RectF;
import android.graphics.Paint$Style;
import android.graphics.Region$Op;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.DashPathEffect;

public final class Graphics
{
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
    
    static {
        dashPathEffect = new DashPathEffect(new float[] { 5.0f, 5.0f }, 0.0f);
        sb = new StringBuffer();
        Graphics.tTrans = new float[][] { { 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f }, { 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f }, { -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f }, { -1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f }, { 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f }, { 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f }, { 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f }, { 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f } };
        Graphics.tTransTemp = new float[9];
        Graphics.regionMatrix = new Matrix();
        Graphics.tTransXY = new int[][] { new int[2], { 0, 1 }, { 1, 0 }, { 1, 1 }, new int[2], { 1, 0 }, { 0, 1 }, { 1, 1 } };
        Graphics.rect1 = new Rect();
        Graphics.rect2 = new Rect();
    }
    
    public Graphics() {
        super();
        this.font = Font.getDefaultFont();
        this.strokeStyle = 0;
        this.translateX = 0;
        this.translateY = 0;
        this.isResetPainter = false;
        this.scale_x = 1.0f;
        this.scale_y = 1.0f;
        this.initPaint();
    }
    
    public Graphics(final Canvas canvas) {
        super();
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
    
    Graphics(final Canvas canvas, final Paint tmpPaint, final Bitmap graphicbitmap) {
        super();
        this.font = Font.getDefaultFont();
        this.strokeStyle = 0;
        this.translateX = 0;
        this.translateY = 0;
        this.isResetPainter = false;
        this.scale_x = 1.0f;
        this.scale_y = 1.0f;
        this.canvas = canvas;
        this.graphicbitmap = graphicbitmap;
        this.font.tmpPaint = tmpPaint;
        this.initPaint();
    }
    
    private void initPaint() {
        this.font.tmpPaint.setAntiAlias(true);
    }
    
    public void clipRect(final int n, final int n2, final int n3, final int n4) {
        this.canvas.clipRect((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4), Region$Op.INTERSECT);
        final Rect clipBounds = this.canvas.getClipBounds();
        this.clipx = clipBounds.left;
        this.clipy = clipBounds.top;
        this.clipw = clipBounds.right - clipBounds.left;
        this.cliph = clipBounds.bottom - clipBounds.top;
    }
    
    public void copyArea(final int n, final int n2, final int n3, final int n4, final int n5, int n6, int n7) {
        if (this.graphicbitmap != null) {
            final int n8 = 0;
            int n9;
            if ((n9 = n7) == 0) {
                n9 = 20;
            }
            n7 = n8;
            if ((n9 & 0x40) != 0x0) {
                n7 = 1;
            }
            int n10;
            if ((n9 & 0x10) != 0x0) {
                n10 = n6;
                if ((n9 & 0x22) != 0x0) {
                    n7 = 1;
                    n10 = n6;
                }
            }
            else if ((n9 & 0x20) != 0x0) {
                if ((n9 & 0x2) != 0x0) {
                    n7 = 1;
                    n10 = n6;
                }
                else {
                    n10 = n6 - (n4 - 1);
                }
            }
            else if ((n9 & 0x2) != 0x0) {
                n10 = n6 - (n4 - 1 >>> 1);
            }
            else {
                n7 = 1;
                n10 = n6;
            }
            if ((n9 & 0x4) != 0x0) {
                n6 = n5;
                if ((n9 & 0x9) != 0x0) {
                    n7 = 1;
                    n6 = n5;
                }
            }
            else if ((n9 & 0x8) != 0x0) {
                if ((n9 & 0x1) != 0x0) {
                    n7 = 1;
                    n6 = n5;
                }
                else {
                    n6 = n5 - (n3 - 1);
                }
            }
            else if ((n9 & 0x1) != 0x0) {
                n6 = n5 - (n3 - 1 >>> 1);
            }
            else {
                n7 = 1;
                n6 = n5;
            }
            if (n7 != 0) {
                throw new IllegalArgumentException("anchor error");
            }
            if (this.area != null && this.area.getWidth() == n3 && this.area.getHeight() == n4) {
                if (this.rgb == null || (this.rgb != null && this.rgb.length != n3 * n4)) {
                    this.rgb = new int[n3 * n4];
                }
                this.graphicbitmap.getPixels(this.rgb, 0, n3, n, n2, n3, n4);
                this.area.setPixels(this.rgb, 0, n3, 0, 0, n3, n4);
            }
            else {
                this.area = Bitmap.createBitmap(this.graphicbitmap, n, n2, n3, n4);
            }
            this.font.tmpPaint.setStyle(Paint$Style.STROKE);
            this.canvas.drawBitmap(this.area, (float)n6, (float)n10, this.font.tmpPaint);
            this.font.tmpPaint.setStyle(Paint$Style.FILL);
        }
    }
    
    public void drawArc(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        this.font.tmpPaint.setStyle(Paint$Style.STROKE);
        this.canvas.drawArc(new RectF((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4)), (float)n5, (float)n6, false, this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint$Style.FILL);
    }
    
    public void drawChar(final char c, final int n, final int n2, final int n3) {
        Graphics.sb.delete(0, Graphics.sb.length());
        Graphics.sb.append(c);
        this.drawString(Graphics.sb.toString(), n, n2, n3);
    }
    
    public void drawChars(final char[] str, final int offset, final int len, final int n, final int n2, final int n3) {
        Graphics.sb.delete(0, Graphics.sb.length());
        Graphics.sb.append(str, offset, len);
        this.drawString(Graphics.sb.toString(), n, n2, n3);
    }
    
    public void drawImage(final Image image, int n, final int n2, final int n3) {
        int n4;
        if ((n3 & 0x8) != 0x0) {
            n4 = n - image.getWidth();
        }
        else {
            n4 = n;
            if ((n3 & 0x1) != 0x0) {
                n4 = n - image.getWidth() / 2;
            }
        }
        if ((n3 & 0x20) != 0x0) {
            n = n2 - image.getHeight();
        }
        else {
            n = n2;
            if ((n3 & 0x2) != 0x0) {
                n = n2 - image.getHeight() / 2;
            }
        }
        this.canvas.drawBitmap(image.getBitMapInpackage(), (float)n4, (float)n, this.font.tmpPaint);
    }
    
    public void drawLine(final float n, final float n2, final float n3, final float n4) {
        this.canvas.drawLine(n, n2, n3, n4, this.font.tmpPaint);
    }
    
    public void drawRGB(final int[] array, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final boolean b) {
        if (array == null) {
            throw new NullPointerException();
        }
        if (n5 > 0 && n6 > 0) {
            final int length = array.length;
            if (n5 < 0 || n6 < 0 || n < 0 || n >= length || (n2 < 0 && (n6 - 1) * n2 < 0) || (n2 >= 0 && (n6 - 1) * n2 + n5 - 1 >= length)) {
                throw new ArrayIndexOutOfBoundsException();
            }
            final int color = array[0];
            final int n7 = array[length / 2];
            final int n8 = array[length / 3];
            final int n9 = array[length / 4];
            final int n10 = array[length * 5 / 8];
            final int n11 = array[length * 4 / 5];
            if (color == n7 && n7 == n8 && n8 == n9 && n9 == n10 && n10 == n11) {
                this.font.tmpPaint.setColor(color);
                this.fillRect(n3, n4, n5, n6);
            }
            else {
                int n12;
                if ((n12 = n2) < n5) {
                    n12 = n5;
                }
                this.font.tmpPaint.setStyle(Paint$Style.STROKE);
                this.canvas.drawBitmap(array, n, n12, n3, n4, n5, n6, b, this.font.tmpPaint);
                this.font.tmpPaint.setStyle(Paint$Style.FILL);
            }
        }
    }
    
    public void drawRect(final int n, final int n2, final int n3, final int n4) {
        this.font.tmpPaint.setStyle(Paint$Style.STROKE);
        this.canvas.drawRect((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4), this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint$Style.FILL);
    }
    
    public void drawRegion(final Image image, final int n, final int n2, final int n3, final int n4, final int n5, int n6, final int n7, final int n8) {
        int n9 = n3;
        int n10 = n4;
        if (n5 > 3) {
            n9 = n4;
            n10 = n3;
        }
        int n11;
        if ((n8 & 0x8) != 0x0) {
            n11 = n6 - n9;
        }
        else {
            n11 = n6;
            if ((n8 & 0x1) != 0x0) {
                n11 = n6 - n9 / 2;
            }
        }
        if ((n8 & 0x20) != 0x0) {
            n6 = n7 - n10;
        }
        else {
            n6 = n7;
            if ((n8 & 0x2) != 0x0) {
                n6 = n7 - n10 / 2;
            }
        }
        if (n5 == 0) {
            Graphics.rect1.set(n, n2, n + n3, n2 + n4);
            Graphics.rect2.set(n11, n6, n11 + n3, n6 + n4);
            this.canvas.drawBitmap(image.getBitMapInpackage(), Graphics.rect1, Graphics.rect2, this.font.tmpPaint);
        }
        else {
            Graphics.ttmatrix = this.canvas.getMatrix();
            System.arraycopy(Graphics.tTrans[n5], 0, Graphics.tTransTemp, 0, 9);
            Graphics.tTransTemp[2] = (float)(Graphics.tTransXY[n5][0] * n9 + n11);
            Graphics.tTransTemp[5] = (float)(Graphics.tTransXY[n5][1] * n10 + n6);
            Graphics.regionMatrix.setValues(Graphics.tTransTemp);
            if (this.scale_x != 1.0f || this.scale_y != 1.0f) {
                Graphics.regionMatrix.postScale(this.scale_x, this.scale_y);
            }
            this.canvas.setMatrix(Graphics.regionMatrix);
            Graphics.rect1.set(n, n2, n + n3, n2 + n4);
            Graphics.rect2.set(0, 0, n3 + 1, n4);
            this.canvas.drawBitmap(image.getBitMapInpackage(), Graphics.rect1, Graphics.rect2, this.font.tmpPaint);
            this.canvas.setMatrix(Graphics.ttmatrix);
        }
    }
    
    public void drawRoundRect(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        this.font.tmpPaint.setStyle(Paint$Style.STROKE);
        this.canvas.drawRoundRect(new RectF((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4)), (float)n5, (float)n6, this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint$Style.FILL);
    }
    
    public void drawString(final String s, final int n, int n2, final int n3) {
        final int n4 = n2 - 5;
        int n5 = n3;
        if (n3 == 0) {
            n5 = 20;
        }
        if ((n5 & 0x10) != 0x0) {
            n2 = n4 - this.font.getMetricsInt().top;
        }
        else if ((n5 & 0x20) != 0x0) {
            n2 = n4 - this.font.getMetricsInt().bottom;
        }
        else {
            n2 = n4;
            if ((n5 & 0x2) != 0x0) {
                n2 = n4 + ((this.font.getMetricsInt().descent - this.font.getMetricsInt().ascent) / 2 - this.font.getMetricsInt().descent);
            }
        }
        if ((n5 & 0x1) != 0x0) {
            this.font.tmpPaint.setTextAlign(Paint$Align.CENTER);
        }
        else if ((n5 & 0x8) != 0x0) {
            this.font.tmpPaint.setTextAlign(Paint$Align.RIGHT);
        }
        else if ((n5 & 0x4) != 0x0) {
            this.font.tmpPaint.setTextAlign(Paint$Align.LEFT);
        }
        this.canvas.drawText(s, (float)n, (float)n2, this.font.tmpPaint);
    }
    
    public void drawSubstring(final String s, final int n, final int n2, final int n3, final int n4, int n5) {
        int n6 = n5;
        if (n5 == 0) {
            n6 = 20;
        }
        if ((n6 & 0x10) != 0x0) {
            n5 = n4 - this.font.getMetricsInt().top;
        }
        else if ((n6 & 0x20) != 0x0) {
            n5 = n4 - this.font.getMetricsInt().bottom;
        }
        else {
            n5 = n4;
            if ((n6 & 0x2) != 0x0) {
                n5 = n4 + ((this.font.getMetricsInt().descent - this.font.getMetricsInt().ascent) / 2 - this.font.getMetricsInt().descent);
            }
        }
        if ((n6 & 0x1) != 0x0) {
            this.font.tmpPaint.setTextAlign(Paint$Align.CENTER);
        }
        else if ((n6 & 0x8) != 0x0) {
            this.font.tmpPaint.setTextAlign(Paint$Align.RIGHT);
        }
        else if ((n6 & 0x4) != 0x0) {
            this.font.tmpPaint.setTextAlign(Paint$Align.LEFT);
        }
        this.canvas.drawText(s, n, n2 + n, (float)n3, (float)n5, this.font.tmpPaint);
    }
    
    public void fillArc(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        this.canvas.drawArc(new RectF((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4)), (float)n5, (float)n6, false, this.font.tmpPaint);
    }
    
    public void fillRect(final int n, final int n2, final int n3, final int n4) {
        this.canvas.drawRect((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4), this.font.tmpPaint);
    }
    
    public void fillRoundRect(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        this.canvas.drawRoundRect(new RectF((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4)), (float)n5, (float)n6, this.font.tmpPaint);
    }
    
    public void fillTriangle(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        final Path path = new Path();
        path.moveTo((float)n, (float)n2);
        path.lineTo((float)n3, (float)n4);
        path.lineTo((float)n5, (float)n6);
        path.lineTo((float)n, (float)n2);
        this.canvas.drawPath(path, this.font.tmpPaint);
    }
    
    public int getBlueComponent() {
        return this.font.tmpPaint.getColor() & 0xFF;
    }
    
    public Canvas getCanvas() throws NullPointerException {
        if (this.canvas == null) {
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
    
    public int getDisplayColor(final int n) {
        return n;
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
    
    public void getXY(final float scale_x, final float scale_y) {
        this.scale_x = scale_x;
        this.scale_y = scale_y;
    }
    
    public boolean isAutoResetPainter() {
        return this.isResetPainter;
    }
    
    public void painterAutoReset(final boolean isResetPainter) {
        this.isResetPainter = isResetPainter;
    }
    
    public void painterReset() {
        this.font.tmpPaint.reset();
    }
    
    public void restCanvas() {
        this.canvas.restore();
        this.canvas.save(2);
    }
    
    void setCanvas(final Canvas canvas) {
        this.canvas = canvas;
        this.initPaint();
    }
    
    public void setClip(final int clipx, final int clipy, final int clipw, final int cliph) {
        this.clipx = clipx;
        this.clipy = clipy;
        this.clipw = clipw;
        this.cliph = cliph;
        if (clipw >= 0 && cliph >= 0) {
            this.canvas.clipRect((float)clipx, (float)clipy, (float)(clipx + clipw), (float)(clipy + cliph), Region$Op.REPLACE);
        }
    }
    
    public void setColor(final int color) {
        if ((color & 0xFF000000) != 0x0) {
            this.font.tmpPaint.setColor(color);
        }
        else {
            this.font.tmpPaint.setColor(0xFF000000 | color);
        }
    }
    
    public void setColor(final int n, final int n2, final int n3) {
        this.setColor(Color.rgb(n, n2, n3));
    }
    
    public void setFont(final Font font) {
        this.font = font;
    }
    
    public void setGrayScale(final int n) {
        if (n < 0 || n > 255) {
            throw new IllegalArgumentException();
        }
        this.setColor(n, n, n);
    }
    
    public void setStrokeStyle(final int strokeStyle) {
        if (strokeStyle != 0 || strokeStyle != 1) {
            throw new IllegalArgumentException();
        }
        if ((this.strokeStyle = strokeStyle) == 0) {
            this.font.tmpPaint.setPathEffect((PathEffect)null);
        }
        else if (strokeStyle == 1) {
            this.font.tmpPaint.setPathEffect((PathEffect)Graphics.dashPathEffect);
        }
    }
    
    public void translate(final int n, final int n2) {
        this.canvas.translate((float)n, (float)n2);
        this.translateX += n;
        this.translateY += n2;
        this.clipx -= n;
        this.clipy -= n2;
    }
}
