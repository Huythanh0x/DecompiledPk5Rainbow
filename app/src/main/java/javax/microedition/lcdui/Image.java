package javax.microedition.lcdui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import com.android.Util.AndroidUtil;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class Image {
    private Graphics img_g;
    private Bitmap mBitmap;

    private Image() {
    }

    public static Image createImage(byte[] imageData, int imageOffset, int imageLength) {
        Image image = new Image();
        image.mBitmap = BitmapFactory.decodeByteArray(imageData, imageOffset, imageLength);
        return image;
    }

    public static Image createImage(Image source, int x, int y, int width, int height, int transform) {
        int tmp_w = width;
        int tmp_h = height;
        if (transform > 3) {
            tmp_w = height;
            tmp_h = width;
        }
        Image image = new Image();
        System.arraycopy(Graphics.tTrans[transform], 0, Graphics.tTransTemp, 0, 9);
        Graphics.tTransTemp[2] = Graphics.tTransXY[transform][0] * tmp_w;
        Graphics.tTransTemp[5] = Graphics.tTransXY[transform][1] * tmp_h;
        Graphics.regionMatrix.setValues(Graphics.tTransTemp);
        image.mBitmap = Bitmap.createBitmap(source.getBitMapInpackage(), x, y, width, height, Graphics.regionMatrix, false);
        return image;
    }

    public static Image createImage(int width, int height) {
        Image image = new Image();
        image.mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        return image;
    }

    public static Image createImage(int width, int height, int flag) {
        Image image = new Image();
        image.mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        return image;
    }

    public static Image createImage(String name) throws IOException {
        Image image = new Image();
        InputStream is = AndroidUtil.getResourceAsStream(name);
        image.mBitmap = BitmapFactory.decodeStream(is);
        if (image.mBitmap == null) {
            throw new IOException();
        }
        return image;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap getBitMapInpackage() {
        return this.mBitmap;
    }

    public static Image createRGBImage(int[] rgb, int width, int height, boolean processAlpha) {
        Image image = new Image();
        image.mBitmap = Bitmap.createBitmap(rgb, width, height, Bitmap.Config.ARGB_8888);
        return image;
    }

    public Graphics getGraphics() {
        if (this.mBitmap.isMutable()) {
            if (this.img_g == null) {
                android.graphics.Canvas imagecanvas = new android.graphics.Canvas(this.mBitmap);
                Paint painter = new Paint();
                this.img_g = new Graphics(imagecanvas, painter, this.mBitmap);
            }
            return this.img_g;
        }
        throw new IllegalStateException();
    }

    public int getHeight() {
        return this.mBitmap.getHeight();
    }

    public void getRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height) {
        this.mBitmap.getPixels(rgbData, offset, scanlength, x, y, width, height);
    }

    public int getWidth() {
        return this.mBitmap.getWidth();
    }

    public boolean isMutable() {
        return this.mBitmap.isMutable();
    }

    public Bitmap getBitMap() {
        return this.mBitmap;
    }

    public static Image createImage(String name, int zoom) throws IOException {
        Image image = new Image();
        InputStream is = AndroidUtil.getResourceAsStream(name);
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inInputShareable = true;
        opts.inSampleSize = zoom;
        image.mBitmap = BitmapFactory.decodeStream(is, null, opts);
        if (image.mBitmap == null) {
            throw new IOException();
        }
        return image;
    }
}
