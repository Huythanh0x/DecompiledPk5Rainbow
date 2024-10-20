package javax.microedition.lcdui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;
import com.android.Util.AndroidUtil;
import java.io.IOException;
import java.io.InputStream;

public class Image {
   private Graphics img_g;
   private Bitmap mBitmap;

   private Image() {
      super();
   }

   public static Image createImage(int var0, int var1) {
      Image var2 = new Image();
      var2.mBitmap = Bitmap.createBitmap(var0, var1, Config.RGB_565);
      return var2;
   }

   public static Image createImage(int var0, int var1, int var2) {
      Image var3 = new Image();
      var3.mBitmap = Bitmap.createBitmap(var0, var1, Config.RGB_565);
      return var3;
   }

   public static Image createImage(String var0) throws IOException {
      Image var1 = new Image();
      var1.mBitmap = BitmapFactory.decodeStream(AndroidUtil.getResourceAsStream(var0));
      if (var1.mBitmap == null) {
         throw new IOException();
      } else {
         return var1;
      }
   }

   public static Image createImage(String var0, int var1) throws IOException {
      Image var2 = new Image();
      InputStream var3 = AndroidUtil.getResourceAsStream(var0);
      BitmapFactory.Options var4 = new BitmapFactory.Options();
      var4.inInputShareable = true;
      var4.inSampleSize = var1;
      var2.mBitmap = BitmapFactory.decodeStream(var3, (Rect)null, var4);
      if (var2.mBitmap == null) {
         throw new IOException();
      } else {
         return var2;
      }
   }

   public static Image createImage(Image var0, int var1, int var2, int var3, int var4, int var5) {
      int var7 = var4;
      int var8 = var3;
      if (var5 > 3) {
         var8 = var4;
         var7 = var3;
      }

      Image var9 = new Image();
      System.arraycopy(Graphics.tTrans[var5], 0, Graphics.tTransTemp, 0, 9);
      Graphics.tTransTemp[2] = (float)(Graphics.tTransXY[var5][0] * var8);
      Graphics.tTransTemp[5] = (float)(Graphics.tTransXY[var5][1] * var7);
      Graphics.regionMatrix.setValues(Graphics.tTransTemp);
      var9.mBitmap = Bitmap.createBitmap(var0.getBitMapInpackage(), var1, var2, var3, var4, Graphics.regionMatrix, false);
      return var9;
   }

   public static Image createImage(byte[] var0, int var1, int var2) {
      Image var3 = new Image();
      var3.mBitmap = BitmapFactory.decodeByteArray(var0, var1, var2);
      return var3;
   }

   public static Image createRGBImage(int[] var0, int var1, int var2, boolean var3) {
      Image var4 = new Image();
      var4.mBitmap = Bitmap.createBitmap(var0, var1, var2, Config.ARGB_8888);
      return var4;
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
            this.img_g = new Graphics(new android.graphics.Canvas(this.mBitmap), new Paint(), this.mBitmap);
         }

         return this.img_g;
      } else {
         throw new IllegalStateException();
      }
   }

   public int getHeight() {
      return this.mBitmap.getHeight();
   }

   public void getRGB(int[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.mBitmap.getPixels(var1, var2, var3, var4, var5, var6, var7);
   }

   public int getWidth() {
      return this.mBitmap.getWidth();
   }

   public boolean isMutable() {
      return this.mBitmap.isMutable();
   }
}
