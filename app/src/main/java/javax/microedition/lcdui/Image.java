package javax.microedition.lcdui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.android.Util.AndroidUtil;
import java.io.IOException;
import java.io.InputStream;

public class Image {
  private Graphics img_g;
  
  private Bitmap mBitmap;
  
  public static Image createImage(int paramInt1, int paramInt2) {
    Image image = new Image();
    image.mBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
    return image;
  }
  
  public static Image createImage(int paramInt1, int paramInt2, int paramInt3) {
    Image image = new Image();
    image.mBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
    return image;
  }
  
  public static Image createImage(String paramString) throws IOException {
    Image image = new Image();
    image.mBitmap = BitmapFactory.decodeStream(AndroidUtil.getResourceAsStream(paramString));
    if (image.mBitmap == null)
      throw new IOException(); 
    return image;
  }
  
  public static Image createImage(String paramString, int paramInt) throws IOException {
    Image image = new Image();
    InputStream inputStream = AndroidUtil.getResourceAsStream(paramString);
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inInputShareable = true;
    options.inSampleSize = paramInt;
    image.mBitmap = BitmapFactory.decodeStream(inputStream, null, options);
    if (image.mBitmap == null)
      throw new IOException(); 
    return image;
  }
  
  public static Image createImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    int j = paramInt3;
    int i = paramInt4;
    if (paramInt5 > 3) {
      j = paramInt4;
      i = paramInt3;
    } 
    Image image = new Image();
    System.arraycopy(Graphics.tTrans[paramInt5], 0, Graphics.tTransTemp, 0, 9);
    Graphics.tTransTemp[2] = (Graphics.tTransXY[paramInt5][0] * j);
    Graphics.tTransTemp[5] = (Graphics.tTransXY[paramInt5][1] * i);
    Graphics.regionMatrix.setValues(Graphics.tTransTemp);
    image.mBitmap = Bitmap.createBitmap(paramImage.getBitMapInpackage(), paramInt1, paramInt2, paramInt3, paramInt4, Graphics.regionMatrix, false);
    return image;
  }
  
  public static Image createImage(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    Image image = new Image();
    image.mBitmap = BitmapFactory.decodeByteArray(paramArrayOfbyte, paramInt1, paramInt2);
    return image;
  }
  
  public static Image createRGBImage(int[] paramArrayOfint, int paramInt1, int paramInt2, boolean paramBoolean) {
    Image image = new Image();
    image.mBitmap = Bitmap.createBitmap(paramArrayOfint, paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
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
      if (this.img_g == null)
        this.img_g = new Graphics(new Canvas(this.mBitmap), new Paint(), this.mBitmap); 
      return this.img_g;
    } 
    throw new IllegalStateException();
  }
  
  public int getHeight() {
    return this.mBitmap.getHeight();
  }
  
  public void getRGB(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    this.mBitmap.getPixels(paramArrayOfint, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public int getWidth() {
    return this.mBitmap.getWidth();
  }
  
  public boolean isMutable() {
    return this.mBitmap.isMutable();
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/lcdui/Image.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */