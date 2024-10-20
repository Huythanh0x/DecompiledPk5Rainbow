/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.DashPathEffect
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PathEffect
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Region$Op
 *  javax.microedition.lcdui.Font
 *  javax.microedition.lcdui.Image
 */
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
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;

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
    private static final DashPathEffect dashPathEffect = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
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
    private Font font = Font.getDefaultFont();
    private Bitmap graphicbitmap;
    private boolean isResetPainter = false;
    private int[] rgb;
    float scale_x = 1.0f;
    float scale_y = 1.0f;
    private int strokeStyle = 0;
    private int translateX = 0;
    private int translateY = 0;

    static {
        sb = new StringBuffer();
        tTrans = new float[][]{{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, {-1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, {-1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, {0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, {0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, {0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, {0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}};
        tTransTemp = new float[9];
        regionMatrix = new Matrix();
        int[] nArray = new int[2];
        int[] nArray2 = new int[2];
        nArray2[1] = 1;
        int[] nArray3 = new int[2];
        nArray3[0] = 1;
        int[] nArray4 = new int[]{1, 1};
        int[] nArray5 = new int[2];
        int[] nArray6 = new int[2];
        nArray6[0] = 1;
        int[] nArray7 = new int[2];
        nArray7[1] = 1;
        tTransXY = new int[][]{nArray, nArray2, nArray3, nArray4, nArray5, nArray6, nArray7, {1, 1}};
        rect1 = new Rect();
        rect2 = new Rect();
    }

    public Graphics() {
        this.initPaint();
    }

    public Graphics(Canvas canvas) {
        this.canvas = canvas;
        this.initPaint();
    }

    Graphics(Canvas canvas, Paint paint, Bitmap bitmap) {
        this.canvas = canvas;
        this.graphicbitmap = bitmap;
        this.font.tmpPaint = paint;
        this.initPaint();
    }

    private void initPaint() {
        this.font.tmpPaint.setAntiAlias(true);
    }

    public void clipRect(int n, int n2, int n3, int n4) {
        this.canvas.clipRect((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4), Region.Op.INTERSECT);
        Rect rect = this.canvas.getClipBounds();
        this.clipx = rect.left;
        this.clipy = rect.top;
        this.clipw = rect.right - rect.left;
        this.cliph = rect.bottom - rect.top;
    }

    /*
     * Unable to fully structure code
     */
    public void copyArea(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7) {
        block20: {
            block11: {
                block19: {
                    block17: {
                        block18: {
                            block13: {
                                block16: {
                                    block14: {
                                        block15: {
                                            block12: {
                                                if (this.graphicbitmap == null) ** GOTO lbl67
                                                var8_8 = 0;
                                                var9_9 = var7_7;
                                                if (var7_7 == 0) {
                                                    var9_9 = 20;
                                                }
                                                var7_7 = var8_8;
                                                if ((var9_9 & 64) != 0) {
                                                    var7_7 = 1;
                                                }
                                                if ((var9_9 & 16) == 0) break block12;
                                                var8_8 = var6_6;
                                                if ((var9_9 & 34) != 0) {
                                                    var7_7 = 1;
                                                    var8_8 = var6_6;
                                                }
lbl14:
                                                // 7 sources

                                                while ((var9_9 & 4) != 0) {
                                                    var6_6 = var5_5;
                                                    if ((var9_9 & 9) != 0) {
                                                        var7_7 = 1;
                                                        var6_6 = var5_5;
                                                    }
lbl19:
                                                    // 7 sources

                                                    while (var7_7 != 0) {
                                                        throw new IllegalArgumentException("anchor error");
                                                    }
                                                    break block11;
                                                }
                                                break block13;
                                            }
                                            if ((var9_9 & 32) == 0) break block14;
                                            if ((var9_9 & 2) == 0) break block15;
                                            var7_7 = 1;
                                            var8_8 = var6_6;
                                            ** GOTO lbl14
                                        }
                                        var8_8 = var6_6 - (var4_4 - 1);
                                        ** GOTO lbl14
                                    }
                                    if ((var9_9 & 2) == 0) break block16;
                                    var8_8 = var6_6 - (var4_4 - 1 >>> 1);
                                    ** GOTO lbl14
                                }
                                var7_7 = 1;
                                var8_8 = var6_6;
                                ** GOTO lbl14
                            }
                            if ((var9_9 & 8) == 0) break block17;
                            if ((var9_9 & 1) == 0) break block18;
                            var7_7 = 1;
                            var6_6 = var5_5;
                            ** GOTO lbl19
                        }
                        var6_6 = var5_5 - (var3_3 - 1);
                        ** GOTO lbl19
                    }
                    if ((var9_9 & 1) == 0) break block19;
                    var6_6 = var5_5 - (var3_3 - 1 >>> 1);
                    ** GOTO lbl19
                }
                var7_7 = 1;
                var6_6 = var5_5;
                ** GOTO lbl19
            }
            if (this.area == null || this.area.getWidth() != var3_3 || this.area.getHeight() != var4_4) break block20;
            if (this.rgb == null || this.rgb != null && this.rgb.length != var3_3 * var4_4) {
                this.rgb = new int[var3_3 * var4_4];
            }
            this.graphicbitmap.getPixels(this.rgb, 0, var3_3, var1_1, var2_2, var3_3, var4_4);
            this.area.setPixels(this.rgb, 0, var3_3, 0, 0, var3_3, var4_4);
lbl63:
            // 2 sources

            while (true) {
                this.font.tmpPaint.setStyle(Paint.Style.STROKE);
                this.canvas.drawBitmap(this.area, (float)var6_6, (float)var8_8, this.font.tmpPaint);
                this.font.tmpPaint.setStyle(Paint.Style.FILL);
lbl67:
                // 2 sources

                return;
            }
        }
        this.area = Bitmap.createBitmap((Bitmap)this.graphicbitmap, (int)var1_1, (int)var2_2, (int)var3_3, (int)var4_4);
        ** while (true)
    }

    public void drawArc(int n, int n2, int n3, int n4, int n5, int n6) {
        this.font.tmpPaint.setStyle(Paint.Style.STROKE);
        this.canvas.drawArc(new RectF((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4)), (float)n5, (float)n6, false, this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint.Style.FILL);
    }

    public void drawChar(char c, int n, int n2, int n3) {
        sb.delete(0, sb.length());
        sb.append(c);
        this.drawString(sb.toString(), n, n2, n3);
    }

    public void drawChars(char[] cArray, int n, int n2, int n3, int n4, int n5) {
        sb.delete(0, sb.length());
        sb.append(cArray, n, n2);
        this.drawString(sb.toString(), n3, n4, n5);
    }

    /*
     * Unable to fully structure code
     */
    public void drawImage(Image var1_1, int var2_2, int var3_3, int var4_4) {
        block3: {
            block2: {
                if ((var4_4 & 8) == 0) break block2;
                var5_5 = var2_2 - var1_1.getWidth();
lbl3:
                // 3 sources

                while ((var4_4 & 32) != 0) {
                    var2_2 = var3_3 - var1_1.getHeight();
lbl5:
                    // 3 sources

                    while (true) {
                        this.canvas.drawBitmap(var1_1.getBitMapInpackage(), (float)var5_5, (float)var2_2, this.font.tmpPaint);
                        return;
                    }
                }
                break block3;
            }
            var5_5 = var2_2;
            if ((var4_4 & 1) == 0) ** GOTO lbl3
            var5_5 = var2_2 - var1_1.getWidth() / 2;
            ** GOTO lbl3
        }
        var2_2 = var3_3;
        if ((var4_4 & 2) == 0) ** GOTO lbl5
        var2_2 = var3_3 - var1_1.getHeight() / 2;
        ** while (true)
    }

    public void drawLine(float f, float f2, float f3, float f4) {
        this.canvas.drawLine(f, f2, f3, f4, this.font.tmpPaint);
    }

    /*
     * Enabled force condition propagation
     */
    public void drawRGB(int[] nArray, int n, int n2, int n3, int n4, int n5, int n6, boolean bl) {
        if (nArray == null) {
            throw new NullPointerException();
        }
        if (n5 <= 0 || n6 <= 0) {
            return;
        }
        int n7 = nArray.length;
        if (n5 < 0 || n6 < 0 || n < 0 || n >= n7 || n2 < 0 && (n6 - 1) * n2 < 0 || n2 >= 0 && (n6 - 1) * n2 + n5 - 1 >= n7) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int n8 = nArray[0];
        int n9 = nArray[n7 / 2];
        int n10 = nArray[n7 / 3];
        int n11 = nArray[n7 / 4];
        int n12 = nArray[n7 * 5 / 8];
        n7 = nArray[n7 * 4 / 5];
        if (n8 == n9 && n9 == n10 && n10 == n11 && n11 == n12 && n12 == n7) {
            this.font.tmpPaint.setColor(n8);
            this.fillRect(n3, n4, n5, n6);
            return;
        }
        n11 = n2;
        if (n2 < n5) {
            n11 = n5;
        }
        this.font.tmpPaint.setStyle(Paint.Style.STROKE);
        this.canvas.drawBitmap(nArray, n, n11, n3, n4, n5, n6, bl, this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint.Style.FILL);
    }

    public void drawRect(int n, int n2, int n3, int n4) {
        this.font.tmpPaint.setStyle(Paint.Style.STROKE);
        this.canvas.drawRect((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4), this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint.Style.FILL);
    }

    /*
     * Unable to fully structure code
     */
    public void drawRegion(Image var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7, int var8_8, int var9_9) {
        block5: {
            block7: {
                block6: {
                    var12_10 = var4_4;
                    var11_11 = var5_5;
                    if (var6_6 > 3) {
                        var12_10 = var5_5;
                        var11_11 = var4_4;
                    }
                    if ((var9_9 & 8) == 0) break block6;
                    var10_12 = var7_7 - var12_10;
lbl8:
                    // 3 sources

                    while ((var9_9 & 32) != 0) {
                        var7_7 = var8_8 - var11_11;
lbl10:
                        // 3 sources

                        while (var6_6 == 0) {
                            Graphics.rect1.set(var2_2, var3_3, var2_2 + var4_4, var3_3 + var5_5);
                            Graphics.rect2.set(var10_12, var7_7, var10_12 + var4_4, var7_7 + var5_5);
                            this.canvas.drawBitmap(var1_1.getBitMapInpackage(), Graphics.rect1, Graphics.rect2, this.font.tmpPaint);
lbl14:
                            // 2 sources

                            return;
                        }
                        break block5;
                    }
                    break block7;
                }
                var10_12 = var7_7;
                if ((var9_9 & 1) == 0) ** GOTO lbl8
                var10_12 = var7_7 - var12_10 / 2;
                ** GOTO lbl8
            }
            var7_7 = var8_8;
            if ((var9_9 & 2) == 0) ** GOTO lbl10
            var7_7 = var8_8 - var11_11 / 2;
            ** GOTO lbl10
        }
        Graphics.ttmatrix = this.canvas.getMatrix();
        System.arraycopy(Graphics.tTrans[var6_6], 0, Graphics.tTransTemp, 0, 9);
        Graphics.tTransTemp[2] = Graphics.tTransXY[var6_6][0] * var12_10 + var10_12;
        Graphics.tTransTemp[5] = Graphics.tTransXY[var6_6][1] * var11_11 + var7_7;
        Graphics.regionMatrix.setValues(Graphics.tTransTemp);
        if (this.scale_x != 1.0f || this.scale_y != 1.0f) {
            Graphics.regionMatrix.postScale(this.scale_x, this.scale_y);
        }
        this.canvas.setMatrix(Graphics.regionMatrix);
        Graphics.rect1.set(var2_2, var3_3, var2_2 + var4_4, var3_3 + var5_5);
        Graphics.rect2.set(0, 0, var4_4 + 1, var5_5);
        this.canvas.drawBitmap(var1_1.getBitMapInpackage(), Graphics.rect1, Graphics.rect2, this.font.tmpPaint);
        this.canvas.setMatrix(Graphics.ttmatrix);
        ** while (true)
    }

    public void drawRoundRect(int n, int n2, int n3, int n4, int n5, int n6) {
        this.font.tmpPaint.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4));
        this.canvas.drawRoundRect(rectF, (float)n5, (float)n6, this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint.Style.FILL);
    }

    /*
     * Unable to fully structure code
     */
    public void drawString(String var1_1, int var2_2, int var3_3, int var4_4) {
        block6: {
            block4: {
                block5: {
                    block3: {
                        var6_5 = var3_3 - 5;
                        var5_6 = var4_4;
                        if (var4_4 == 0) {
                            var5_6 = 20;
                        }
                        if ((var5_6 & 16) == 0) break block3;
                        var3_3 = var6_5 - this.font.getMetricsInt().top;
lbl7:
                        // 4 sources

                        while ((var5_6 & 1) != 0) {
                            this.font.tmpPaint.setTextAlign(Paint.Align.CENTER);
lbl9:
                            // 4 sources

                            while (true) {
                                this.canvas.drawText(var1_1, (float)var2_2, (float)var3_3, this.font.tmpPaint);
                                return;
                            }
                        }
                        break block4;
                    }
                    if ((var5_6 & 32) == 0) break block5;
                    var3_3 = var6_5 - this.font.getMetricsInt().bottom;
                    ** GOTO lbl7
                }
                var3_3 = var6_5;
                if ((var5_6 & 2) == 0) ** GOTO lbl7
                var3_3 = var6_5 + ((this.font.getMetricsInt().descent - this.font.getMetricsInt().ascent) / 2 - this.font.getMetricsInt().descent);
                ** GOTO lbl7
            }
            if ((var5_6 & 8) == 0) break block6;
            this.font.tmpPaint.setTextAlign(Paint.Align.RIGHT);
            ** GOTO lbl9
        }
        if ((var5_6 & 4) == 0) ** GOTO lbl9
        this.font.tmpPaint.setTextAlign(Paint.Align.LEFT);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawSubstring(String var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6) {
        block6: {
            block4: {
                block5: {
                    block3: {
                        var7_7 = var6_6;
                        if (var6_6 == 0) {
                            var7_7 = 20;
                        }
                        if ((var7_7 & 16) == 0) break block3;
                        var6_6 = var5_5 - this.font.getMetricsInt().top;
lbl6:
                        // 4 sources

                        while ((var7_7 & 1) != 0) {
                            this.font.tmpPaint.setTextAlign(Paint.Align.CENTER);
lbl8:
                            // 4 sources

                            while (true) {
                                this.canvas.drawText(var1_1, var2_2, var3_3 + var2_2, (float)var4_4, (float)var6_6, this.font.tmpPaint);
                                return;
                            }
                        }
                        break block4;
                    }
                    if ((var7_7 & 32) == 0) break block5;
                    var6_6 = var5_5 - this.font.getMetricsInt().bottom;
                    ** GOTO lbl6
                }
                var6_6 = var5_5;
                if ((var7_7 & 2) == 0) ** GOTO lbl6
                var6_6 = var5_5 + ((this.font.getMetricsInt().descent - this.font.getMetricsInt().ascent) / 2 - this.font.getMetricsInt().descent);
                ** GOTO lbl6
            }
            if ((var7_7 & 8) == 0) break block6;
            this.font.tmpPaint.setTextAlign(Paint.Align.RIGHT);
            ** GOTO lbl8
        }
        if ((var7_7 & 4) == 0) ** GOTO lbl8
        this.font.tmpPaint.setTextAlign(Paint.Align.LEFT);
        ** while (true)
    }

    public void fillArc(int n, int n2, int n3, int n4, int n5, int n6) {
        this.canvas.drawArc(new RectF((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4)), (float)n5, (float)n6, false, this.font.tmpPaint);
    }

    public void fillRect(int n, int n2, int n3, int n4) {
        this.canvas.drawRect((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4), this.font.tmpPaint);
    }

    public void fillRoundRect(int n, int n2, int n3, int n4, int n5, int n6) {
        this.canvas.drawRoundRect(new RectF((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4)), (float)n5, (float)n6, this.font.tmpPaint);
    }

    public void fillTriangle(int n, int n2, int n3, int n4, int n5, int n6) {
        Path path = new Path();
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

    public int getDisplayColor(int n) {
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

    public void getXY(float f, float f2) {
        this.scale_x = f;
        this.scale_y = f2;
    }

    public boolean isAutoResetPainter() {
        return this.isResetPainter;
    }

    public void painterAutoReset(boolean bl) {
        this.isResetPainter = bl;
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

    /*
     * Enabled force condition propagation
     */
    public void setClip(int n, int n2, int n3, int n4) {
        this.clipx = n;
        this.clipy = n2;
        this.clipw = n3;
        this.cliph = n4;
        if (n3 < 0 || n4 < 0) {
            return;
        }
        this.canvas.clipRect((float)n, (float)n2, (float)(n + n3), (float)(n2 + n4), Region.Op.REPLACE);
    }

    /*
     * Enabled force condition propagation
     */
    public void setColor(int n) {
        if ((n & 0xFF000000) != 0) {
            this.font.tmpPaint.setColor(n);
            return;
        }
        this.font.tmpPaint.setColor(0xFF000000 | n);
    }

    public void setColor(int n, int n2, int n3) {
        this.setColor(Color.rgb((int)n, (int)n2, (int)n3));
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setGrayScale(int n) {
        if (n < 0 || n > 255) {
            throw new IllegalArgumentException();
        }
        this.setColor(n, n, n);
    }

    /*
     * Unable to fully structure code
     */
    public void setStrokeStyle(int var1_1) {
        if (var1_1 != 0 || var1_1 != 1) {
            throw new IllegalArgumentException();
        }
        this.strokeStyle = var1_1;
        if (var1_1 == 0) {
            this.font.tmpPaint.setPathEffect(null);
lbl7:
            // 3 sources

            return;
        }
        if (var1_1 != 1) ** GOTO lbl7
        this.font.tmpPaint.setPathEffect((PathEffect)Graphics.dashPathEffect);
        ** while (true)
    }

    public void translate(int n, int n2) {
        this.canvas.translate((float)n, (float)n2);
        this.translateX += n;
        this.translateY += n2;
        this.clipx -= n;
        this.clipy -= n2;
    }
}
