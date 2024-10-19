package javax.microedition.lcdui;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;

/* loaded from: classes.dex */
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
    private static Matrix ttmatrix;
    private Bitmap area;
    private android.graphics.Canvas canvas;
    private int cliph;
    private int clipw;
    private int clipx;
    private int clipy;
    private Bitmap graphicbitmap;
    private int[] rgb;
    private static final DashPathEffect dashPathEffect = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
    private static final StringBuffer sb = new StringBuffer();
    protected static float[][] tTrans = {new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{-1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}};
    protected static float[] tTransTemp = new float[9];
    protected static Matrix regionMatrix = new Matrix();
    protected static int[][] tTransXY = {new int[2], new int[]{0, 1}, new int[]{1}, new int[]{1, 1}, new int[2], new int[]{1}, new int[]{0, 1}, new int[]{1, 1}};
    private static Rect rect1 = new Rect();
    private static Rect rect2 = new Rect();
    private Font font = Font.getDefaultFont();
    private int strokeStyle = 0;
    private int translateX = 0;
    private int translateY = 0;
    private boolean isResetPainter = false;
    float scale_x = 1.0f;
    float scale_y = 1.0f;

    private void initPaint() {
        this.font.tmpPaint.setAntiAlias(true);
    }

    public Graphics() {
        initPaint();
    }

    public Graphics(android.graphics.Canvas canvas) {
        this.canvas = canvas;
        initPaint();
    }

    public void setCanvas(android.graphics.Canvas canvas) {
        this.canvas = canvas;
        initPaint();
    }

    public Graphics(android.graphics.Canvas canvas, Paint painter, Bitmap bitmap) {
        this.canvas = canvas;
        this.graphicbitmap = bitmap;
        this.font.tmpPaint = painter;
        initPaint();
    }

    public void clipRect(int x, int y, int width, int height) {
        this.canvas.clipRect(x, y, x + width, y + height, Region.Op.INTERSECT);
        Rect rect = this.canvas.getClipBounds();
        this.clipx = rect.left;
        this.clipy = rect.top;
        this.clipw = rect.right - rect.left;
        this.cliph = rect.bottom - rect.top;
    }

    public void copyArea(int x_src, int y_src, int width, int height, int x_dest, int y_dest, int anchor) {
        if (this.graphicbitmap != null) {
            boolean anchorError = false;
            if (anchor == 0) {
                anchor = 20;
            }
            if ((anchor & 64) != 0) {
                anchorError = true;
            }
            if ((anchor & 16) != 0) {
                if ((anchor & 34) != 0) {
                    anchorError = true;
                }
            } else if ((anchor & 32) != 0) {
                if ((anchor & 2) != 0) {
                    anchorError = true;
                } else {
                    y_dest -= height - 1;
                }
            } else if ((anchor & 2) != 0) {
                y_dest -= (height - 1) >>> 1;
            } else {
                anchorError = true;
            }
            if ((anchor & 4) != 0) {
                if ((anchor & 9) != 0) {
                    anchorError = true;
                }
            } else if ((anchor & 8) != 0) {
                if ((anchor & 1) != 0) {
                    anchorError = true;
                } else {
                    x_dest -= width - 1;
                }
            } else if ((anchor & 1) != 0) {
                x_dest -= (width - 1) >>> 1;
            } else {
                anchorError = true;
            }
            if (anchorError) {
                throw new IllegalArgumentException("anchor error");
            }
            if (this.area != null && this.area.getWidth() == width && this.area.getHeight() == height) {
                if (this.rgb == null || (this.rgb != null && this.rgb.length != width * height)) {
                    this.rgb = new int[width * height];
                }
                this.graphicbitmap.getPixels(this.rgb, 0, width, x_src, y_src, width, height);
                this.area.setPixels(this.rgb, 0, width, 0, 0, width, height);
            } else {
                this.area = Bitmap.createBitmap(this.graphicbitmap, x_src, y_src, width, height);
            }
            this.font.tmpPaint.setStyle(Paint.Style.STROKE);
            this.canvas.drawBitmap(this.area, x_dest, y_dest, this.font.tmpPaint);
            this.font.tmpPaint.setStyle(Paint.Style.FILL);
        }
    }

    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        this.font.tmpPaint.setStyle(Paint.Style.STROKE);
        this.canvas.drawArc(new RectF(x, y, x + width, y + height), startAngle, arcAngle, false, this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint.Style.FILL);
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void drawChar(char character, int x, int y, int anchor) {
        sb.delete(0, sb.length());
        sb.append(character);
        drawString(sb.toString(), x, y, anchor);
    }

    public void drawString(String str, int x, int y, int anchor) {
        int y2 = y - 5;
        if (anchor == 0) {
            anchor = 20;
        }
        if ((anchor & 16) != 0) {
            y2 -= this.font.getMetricsInt().top;
        } else if ((anchor & 32) != 0) {
            y2 -= this.font.getMetricsInt().bottom;
        } else if ((anchor & 2) != 0) {
            y2 += ((this.font.getMetricsInt().descent - this.font.getMetricsInt().ascent) / 2) - this.font.getMetricsInt().descent;
        }
        if ((anchor & 1) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.CENTER);
        } else if ((anchor & 8) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.RIGHT);
        } else if ((anchor & 4) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.LEFT);
        }
        this.canvas.drawText(str, x, y2, this.font.tmpPaint);
    }

    public void drawChars(char[] data, int offset, int length, int x, int y, int anchor) {
        sb.delete(0, sb.length());
        sb.append(data, offset, length);
        drawString(sb.toString(), x, y, anchor);
    }

    public void drawRect(int x, int y, int width, int height) {
        this.font.tmpPaint.setStyle(Paint.Style.STROKE);
        this.canvas.drawRect(x, y, x + width, y + height, this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint.Style.FILL);
    }

    public void drawImage(Image img, int x, int y, int anchor) {
        if ((anchor & 8) != 0) {
            x -= img.getWidth();
        } else if ((anchor & 1) != 0) {
            x -= img.getWidth() / 2;
        }
        if ((anchor & 32) != 0) {
            y -= img.getHeight();
        } else if ((anchor & 2) != 0) {
            y -= img.getHeight() / 2;
        }
        this.canvas.drawBitmap(img.getBitMapInpackage(), x, y, this.font.tmpPaint);
    }

    public void getXY(float x, float y) {
        this.scale_x = x;
        this.scale_y = y;
    }

    public void drawRegion(Image src, int x_src, int y_src, int width, int height, int transform, int x, int y, int anchor) {
        int tmp_w = width;
        int tmp_h = height;
        if (transform > 3) {
            tmp_w = height;
            tmp_h = width;
        }
        if ((anchor & 8) != 0) {
            x -= tmp_w;
        } else if ((anchor & 1) != 0) {
            x -= tmp_w / 2;
        }
        if ((anchor & 32) != 0) {
            y -= tmp_h;
        } else if ((anchor & 2) != 0) {
            y -= tmp_h / 2;
        }
        if (transform == 0) {
            rect1.set(x_src, y_src, x_src + width, y_src + height);
            rect2.set(x, y, x + width, y + height);
            this.canvas.drawBitmap(src.getBitMapInpackage(), rect1, rect2, this.font.tmpPaint);
            return;
        }
        ttmatrix = this.canvas.getMatrix();
        System.arraycopy(tTrans[transform], 0, tTransTemp, 0, 9);
        tTransTemp[2] = (tTransXY[transform][0] * tmp_w) + x;
        tTransTemp[5] = (tTransXY[transform][1] * tmp_h) + y;
        regionMatrix.setValues(tTransTemp);
        if (this.scale_x != 1.0f || this.scale_y != 1.0f) {
            regionMatrix.postScale(this.scale_x, this.scale_y);
        }
        this.canvas.setMatrix(regionMatrix);
        rect1.set(x_src, y_src, x_src + width, y_src + height);
        rect2.set(0, 0, width + 1, height);
        this.canvas.drawBitmap(src.getBitMapInpackage(), rect1, rect2, this.font.tmpPaint);
        this.canvas.setMatrix(ttmatrix);
    }

    public void drawRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height, boolean processAlpha) {
        if (rgbData == null) {
            throw new NullPointerException();
        }
        if (width > 0 && height > 0) {
            int l = rgbData.length;
            if (width < 0 || height < 0 || offset < 0 || offset >= l || ((scanlength < 0 && (height - 1) * scanlength < 0) || (scanlength >= 0 && (((height - 1) * scanlength) + width) - 1 >= l))) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int rgb1 = rgbData[0];
            int rgb2 = rgbData[l / 2];
            int rgb3 = rgbData[l / 3];
            int rgb4 = rgbData[l / 4];
            int rgb5 = rgbData[(l * 5) / 8];
            int rgb6 = rgbData[(l * 4) / 5];
            if (rgb1 == rgb2 && rgb2 == rgb3 && rgb3 == rgb4 && rgb4 == rgb5 && rgb5 == rgb6) {
                this.font.tmpPaint.setColor(rgb1);
                fillRect(x, y, width, height);
                return;
            }
            if (scanlength < width) {
                scanlength = width;
            }
            this.font.tmpPaint.setStyle(Paint.Style.STROKE);
            this.canvas.drawBitmap(rgbData, offset, scanlength, x, y, width, height, processAlpha, this.font.tmpPaint);
            this.font.tmpPaint.setStyle(Paint.Style.FILL);
        }
    }

    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        this.font.tmpPaint.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF(x, y, x + width, y + height);
        this.canvas.drawRoundRect(rectF, arcWidth, arcHeight, this.font.tmpPaint);
        this.font.tmpPaint.setStyle(Paint.Style.FILL);
    }

    public void drawSubstring(String str, int offset, int len, int x, int y, int anchor) {
        if (anchor == 0) {
            anchor = 20;
        }
        if ((anchor & 16) != 0) {
            y -= this.font.getMetricsInt().top;
        } else if ((anchor & 32) != 0) {
            y -= this.font.getMetricsInt().bottom;
        } else if ((anchor & 2) != 0) {
            y += ((this.font.getMetricsInt().descent - this.font.getMetricsInt().ascent) / 2) - this.font.getMetricsInt().descent;
        }
        if ((anchor & 1) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.CENTER);
        } else if ((anchor & 8) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.RIGHT);
        } else if ((anchor & 4) != 0) {
            this.font.tmpPaint.setTextAlign(Paint.Align.LEFT);
        }
        this.canvas.drawText(str, offset, len + offset, x, y, this.font.tmpPaint);
    }

    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        this.canvas.drawArc(new RectF(x, y, x + width, y + height), startAngle, arcAngle, false, this.font.tmpPaint);
    }

    public void fillRect(int x, int y, int width, int height) {
        this.canvas.drawRect(x, y, x + width, y + height, this.font.tmpPaint);
    }

    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        this.canvas.drawRoundRect(new RectF(x, y, x + width, y + height), arcWidth, arcHeight, this.font.tmpPaint);
    }

    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        Path path = new Path();
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        path.lineTo(x3, y3);
        path.lineTo(x1, y1);
        this.canvas.drawPath(path, this.font.tmpPaint);
    }

    public void translate(int x, int y) {
        this.canvas.translate(x, y);
        this.translateX += x;
        this.translateY += y;
        this.clipx -= x;
        this.clipy -= y;
    }

    public int getBlueComponent() {
        return this.font.tmpPaint.getColor() & 255;
    }

    public int getGreenComponent() {
        return (this.font.tmpPaint.getColor() >> 8) & 255;
    }

    public int getRedComponent() {
        return (this.font.tmpPaint.getColor() >> 16) & 255;
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
        return ((getRedComponent() + getGreenComponent()) + getBlueComponent()) / 3;
    }

    public int getStrokeStyle() {
        return this.strokeStyle;
    }

    public void setStrokeStyle(int style) {
        if (style != 0 || style != 1) {
            throw new IllegalArgumentException();
        }
        this.strokeStyle = style;
        if (style == 0) {
            this.font.tmpPaint.setPathEffect(null);
        } else if (style == 1) {
            this.font.tmpPaint.setPathEffect(dashPathEffect);
        }
    }

    public int getTranslateX() {
        return this.translateX;
    }

    public int getTranslateY() {
        return this.translateY;
    }

    public void setClip(int x, int y, int width, int height) {
        this.clipx = x;
        this.clipy = y;
        this.clipw = width;
        this.cliph = height;
        if (width >= 0 && height >= 0) {
            this.canvas.clipRect(x, y, x + width, y + height, Region.Op.REPLACE);
        }
    }

    public void setColor(int RGB) {
        if ((RGB & (-16777216)) != 0) {
            this.font.tmpPaint.setColor(RGB);
        } else {
            this.font.tmpPaint.setColor((-16777216) | RGB);
        }
    }

    public void setColor(int red, int green, int blue) {
        setColor(Color.rgb(red, green, blue));
    }

    public void setGrayScale(int grey) {
        if (grey < 0 || grey > 255) {
            throw new IllegalArgumentException();
        }
        setColor(grey, grey, grey);
    }

    public void drawLine(float x1, float y1, float x2, float y2) {
        this.canvas.drawLine(x1, y1, x2, y2, this.font.tmpPaint);
    }

    public void painterAutoReset(boolean flag) {
        this.isResetPainter = flag;
    }

    public boolean isAutoResetPainter() {
        return this.isResetPainter;
    }

    public void painterReset() {
        this.font.tmpPaint.reset();
    }

    public android.graphics.Canvas getCanvas() throws NullPointerException {
        if (this.canvas == null) {
            throw new NullPointerException();
        }
        return this.canvas;
    }

    public void restCanvas() {
        this.canvas.restore();
        this.canvas.save(2);
    }
}
