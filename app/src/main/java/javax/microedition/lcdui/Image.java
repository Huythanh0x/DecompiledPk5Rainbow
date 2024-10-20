package javax.microedition.lcdui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import com.android.Util.AndroidUtil;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
/**
 * The Image class provides methods to create and manipulate images.
 * It supports creating images from byte arrays, other images, dimensions, and resource names.
 * It also provides methods to get image properties and manipulate image pixels.
 */
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

    /**
     * Creates an image from a portion of another image with optional transformation.
     *
     * @param source The source image.
     * @param x The x coordinate of the upper-left corner of the specified rectangular region.
     * @param y The y coordinate of the upper-left corner of the specified rectangular region.
     * @param width The width of the specified rectangular region.
     * @param height The height of the specified rectangular region.
     * @param transform The transformation to apply to the specified rectangular region.
     * @return The created Image object.
     */
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

    /**
     * Creates an image with the specified width and height.
     *
     * @param width The width of the image.
     * @param height The height of the image.
     * @return The created Image object.
     */
    public static Image createImage(int width, int height) {
        Image image = new Image();
        image.mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        return image;
    }

    /**
     * Creates an image with the specified width, height, and flag.
     *
     * @param width The width of the image.
     * @param height The height of the image.
     * @param flag The flag for image creation.
     * @return The created Image object.
     */
    public static Image createImage(int width, int height, int flag) {
        Image image = new Image();
        image.mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        return image;
    }

    /**
     * Creates an image from a resource name.
     *
     * @param name The name of the resource.
     * @return The created Image object.
     * @throws IOException If an error occurs during image creation.
     */
    public static Image createImage(String name) throws IOException {
        Image image = new Image();
        InputStream is = AndroidUtil.getResourceAsStream(name);
        image.mBitmap = BitmapFactory.decodeStream(is);
        if (image.mBitmap == null) {
            throw new IOException();
        }
        return image;
    }

    /**
     * Gets the bitmap associated with this image.
     *
     * @return The bitmap associated with this image.
     */
    public Bitmap getBitMapInpackage() {
        return this.mBitmap;
    }

    /**
     * Creates an RGB image from an array of integers.
     *
     * @param rgb The array of integers representing the RGB values.
     * @param width The width of the image.
     * @param height The height of the image.
     * @param processAlpha Whether to process the alpha channel.
     * @return The created Image object.
     */
    public static Image createRGBImage(int[] rgb, int width, int height, boolean processAlpha) {
        Image image = new Image();
        image.mBitmap = Bitmap.createBitmap(rgb, width, height, Bitmap.Config.ARGB_8888);
        return image;
    }

    /**
     * Gets the graphics context for drawing on this image.
     *
     * @return The graphics context for drawing on this image.
     * @throws IllegalStateException If the image is not mutable.
     */
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

    /**
     * Gets the height of the image.
     *
     * @return The height of the image.
     */
    public int getHeight() {
        return this.mBitmap.getHeight();
    }

    /**
     * Gets the RGB values of the specified region of the image.
     *
     * @param rgbData The array to receive the RGB values.
     * @param offset The offset into the array where the RGB values start.
     * @param scanlength The number of pixels between rows in the array.
     * @param x The x coordinate of the upper-left corner of the specified rectangular region.
     * @param y The y coordinate of the upper-left corner of the specified rectangular region.
     * @param width The width of the specified rectangular region.
     * @param height The height of the specified rectangular region.
     */
    public void getRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height) {
        this.mBitmap.getPixels(rgbData, offset, scanlength, x, y, width, height);
    }

    /**
     * Gets the width of the image.
     *
     * @return The width of the image.
     */
    public int getWidth() {
        return this.mBitmap.getWidth();
    }

    /**
     * Checks if the image is mutable.
     *
     * @return True if the image is mutable, false otherwise.
     */
    public boolean isMutable() {
        return this.mBitmap.isMutable();
    }

    /**
     * Gets the bitmap associated with this image.
     *
     * @return The bitmap associated with this image.
     */
    public Bitmap getBitMap() {
        return this.mBitmap;
    }

    /**
     * Creates an image from a resource name with a specified zoom level.
     *
     * @param name The name of the resource.
     * @param zoom The zoom level for the image.
     * @return The created Image object.
     * @throws IOException If an error occurs during image creation.
     */
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
