package javax.microedition.lcdui;

import android.graphics.Paint;
import android.graphics.Canvas;
import java.io.InputStream;
import android.graphics.Rect;
import android.graphics.BitmapFactory$Options;
import java.io.IOException;
import android.graphics.BitmapFactory;
import com.android.Util.AndroidUtil;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;

public class Image
{
    private Graphics img_g;
    private Bitmap mBitmap;
    
    private Image() {
        super();
    }
    
    public static Image createImage(final int n, final int n2) {
        final Image image = new Image();
        image.mBitmap = Bitmap.createBitmap(n, n2, Bitmap$Config.RGB_565);
        return image;
    }
    
    public static Image createImage(final int n, final int n2, final int n3) {
        final Image image = new Image();
        image.mBitmap = Bitmap.createBitmap(n, n2, Bitmap$Config.RGB_565);
        return image;
    }
    
    public static Image createImage(final String s) throws IOException {
        final Image image = new Image();
        image.mBitmap = BitmapFactory.decodeStream(AndroidUtil.getResourceAsStream(s));
        if (image.mBitmap == null) {
            throw new IOException();
        }
        return image;
    }
    
    public static Image createImage(final String s, final int inSampleSize) throws IOException {
        final Image image = new Image();
        final InputStream resourceAsStream = AndroidUtil.getResourceAsStream(s);
        final BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        bitmapFactory$Options.inInputShareable = true;
        bitmapFactory$Options.inSampleSize = inSampleSize;
        image.mBitmap = BitmapFactory.decodeStream(resourceAsStream, (Rect)null, bitmapFactory$Options);
        if (image.mBitmap == null) {
            throw new IOException();
        }
        return image;
    }
    
    public static Image createImage(final Image image, final int n, final int n2, final int n3, final int n4, final int n5) {
        int n6 = n4;
        int n7 = n3;
        if (n5 > 3) {
            n7 = n4;
            n6 = n3;
        }
        final Image image2 = new Image();
        System.arraycopy(Graphics.tTrans[n5], 0, Graphics.tTransTemp, 0, 9);
        Graphics.tTransTemp[2] = (float)(Graphics.tTransXY[n5][0] * n7);
        Graphics.tTransTemp[5] = (float)(Graphics.tTransXY[n5][1] * n6);
        Graphics.regionMatrix.setValues(Graphics.tTransTemp);
        image2.mBitmap = Bitmap.createBitmap(image.getBitMapInpackage(), n, n2, n3, n4, Graphics.regionMatrix, false);
        return image2;
    }
    
    public static Image createImage(final byte[] array, final int n, final int n2) {
        final Image image = new Image();
        image.mBitmap = BitmapFactory.decodeByteArray(array, n, n2);
        return image;
    }
    
    public static Image createRGBImage(final int[] array, final int n, final int n2, final boolean b) {
        final Image image = new Image();
        image.mBitmap = Bitmap.createBitmap(array, n, n2, Bitmap$Config.ARGB_8888);
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
    
    public void getRGB(final int[] array, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        this.mBitmap.getPixels(array, n, n2, n3, n4, n5, n6);
    }
    
    public int getWidth() {
        return this.mBitmap.getWidth();
    }
    
    public boolean isMutable() {
        return this.mBitmap.isMutable();
    }
}
