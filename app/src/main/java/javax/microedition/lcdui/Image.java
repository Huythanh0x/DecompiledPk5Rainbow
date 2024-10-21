/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  com.android.Util.AndroidUtil
 *  javax.microedition.lcdui.Graphics
 */
package javax.microedition.lcdui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.android.Util.AndroidUtil;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.Graphics;

public class Image {
    private Graphics img_g;
    private Bitmap mBitmap;

    private Image() {
    }

    public static Image createImage(int n, int n2) {
        Image image = new Image();
        image.mBitmap = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)Bitmap.Config.RGB_565);
        return image;
    }

    public static Image createImage(int n, int n2, int n3) {
        Image image = new Image();
        image.mBitmap = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)Bitmap.Config.RGB_565);
        return image;
    }

    public static Image createImage(String string) throws IOException {
        Image image = new Image();
        image.mBitmap = BitmapFactory.decodeStream((InputStream)AndroidUtil.getResourceAsStream((String)string));
        if (image.mBitmap == null) {
            throw new IOException();
        }
        return image;
    }

    public static Image createImage(String string, int n) throws IOException {
        Image image = new Image();
        InputStream inputStream = AndroidUtil.getResourceAsStream((String)string);
        string = new BitmapFactory.Options();
        ((BitmapFactory.Options)string).inInputShareable = true;
        ((BitmapFactory.Options)string).inSampleSize = n;
        image.mBitmap = BitmapFactory.decodeStream((InputStream)inputStream, null, (BitmapFactory.Options)string);
        if (image.mBitmap == null) {
            throw new IOException();
        }
        return image;
    }

    public static Image createImage(Image image, int n, int n2, int n3, int n4, int n5) {
        int n6 = n3;
        int n7 = n4;
        int n8 = n6;
        if (n5 > 3) {
            n8 = n4;
            n7 = n6 = n3;
        }
        Image image2 = new Image();
        System.arraycopy(Graphics.tTrans[n5], 0, Graphics.tTransTemp, 0, 9);
        Graphics.tTransTemp[2] = Graphics.tTransXY[n5][0] * n8;
        Graphics.tTransTemp[5] = Graphics.tTransXY[n5][1] * n7;
        Graphics.regionMatrix.setValues(Graphics.tTransTemp);
        image2.mBitmap = Bitmap.createBitmap((Bitmap)image.getBitMapInpackage(), (int)n, (int)n2, (int)n3, (int)n4, (Matrix)Graphics.regionMatrix, (boolean)false);
        return image2;
    }

    public static Image createImage(byte[] byArray, int n, int n2) {
        Image image = new Image();
        image.mBitmap = BitmapFactory.decodeByteArray((byte[])byArray, (int)n, (int)n2);
        return image;
    }

    public static Image createRGBImage(int[] nArray, int n, int n2, boolean bl) {
        Image image = new Image();
        image.mBitmap = Bitmap.createBitmap((int[])nArray, (int)n, (int)n2, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        return image;
    }

    public Bitmap getBitMap() {
        return this.mBitmap;
    }

    Bitmap getBitMapInpackage() {
        return this.mBitmap;
    }

    public Graphics getGraphics() {
        if (this.mBitmap.isMutable()) {
            if (this.img_g == null) {
                this.img_g = new Graphics(new Canvas(this.mBitmap), new Paint(), this.mBitmap);
            }
            return this.img_g;
        }
        throw new IllegalStateException();
    }

    public int getHeight() {
        return this.mBitmap.getHeight();
    }

    public void getRGB(int[] nArray, int n, int n2, int n3, int n4, int n5, int n6) {
        this.mBitmap.getPixels(nArray, n, n2, n3, n4, n5, n6);
    }

    public int getWidth() {
        return this.mBitmap.getWidth();
    }

    public boolean isMutable() {
        return this.mBitmap.isMutable();
    }
}
