package javax.microedition.lcdui;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Region.Op;

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
   private static final DashPathEffect dashPathEffect = new DashPathEffect(new float[]{5.0F, 5.0F}, 0.0F);
   private static Rect rect1;
   private static Rect rect2;
   protected static Matrix regionMatrix = new Matrix();
   private static final StringBuffer sb = new StringBuffer();
   protected static float[][] tTrans = new float[][]{{1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F}, {1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F}, {-1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F}, {-1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F}, {0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F}, {0.0F, -1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F}, {0.0F, 1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F}, {0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F}};
   protected static float[] tTransTemp = new float[9];
   protected static int[][] tTransXY;
   private static Matrix ttmatrix;
   private Bitmap area;
   private android.graphics.Canvas canvas;
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
      int[] var3 = new int[2];
      int[] var4 = new int[]{0, 1};
      int[] var5 = new int[]{1, 0};
      int[] var2 = new int[]{1, 1};
      int[] var0 = new int[2];
      int[] var6 = new int[]{1, 0};
      int[] var1 = new int[]{0, 1};
      tTransXY = new int[][]{var3, var4, var5, var2, var0, var6, var1, {1, 1}};
      rect1 = new Rect();
      rect2 = new Rect();
   }

   public Graphics() {
      super();
      this.initPaint();
   }

   public Graphics(android.graphics.Canvas var1) {
      super();
      this.canvas = var1;
      this.initPaint();
   }

   Graphics(android.graphics.Canvas var1, Paint var2, Bitmap var3) {
      super();
      this.canvas = var1;
      this.graphicbitmap = var3;
      this.font.tmpPaint = var2;
      this.initPaint();
   }

   private void initPaint() {
      this.font.tmpPaint.setAntiAlias(true);
   }

   public void clipRect(int var1, int var2, int var3, int var4) {
      this.canvas.clipRect((float)var1, (float)var2, (float)(var1 + var3), (float)(var2 + var4), Op.INTERSECT);
      Rect var5 = this.canvas.getClipBounds();
      this.clipx = var5.left;
      this.clipy = var5.top;
      this.clipw = var5.right - var5.left;
      this.cliph = var5.bottom - var5.top;
   }

   public void copyArea(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (this.graphicbitmap != null) {
         boolean var8 = false;
         int var9 = var7;
         if (var7 == 0) {
            var9 = 20;
         }

         boolean var10 = var8;
         if ((var9 & 64) != 0) {
            var10 = true;
         }

         int var11;
         if ((var9 & 16) != 0) {
            var11 = var6;
            if ((var9 & 34) != 0) {
               var10 = true;
               var11 = var6;
            }
         } else if ((var9 & 32) != 0) {
            if ((var9 & 2) != 0) {
               var10 = true;
               var11 = var6;
            } else {
               var11 = var6 - (var4 - 1);
            }
         } else if ((var9 & 2) != 0) {
            var11 = var6 - (var4 - 1 >>> 1);
         } else {
            var10 = true;
            var11 = var6;
         }

         if ((var9 & 4) != 0) {
            var6 = var5;
            if ((var9 & 9) != 0) {
               var10 = true;
               var6 = var5;
            }
         } else if ((var9 & 8) != 0) {
            if ((var9 & 1) != 0) {
               var10 = true;
               var6 = var5;
            } else {
               var6 = var5 - (var3 - 1);
            }
         } else if ((var9 & 1) != 0) {
            var6 = var5 - (var3 - 1 >>> 1);
         } else {
            var10 = true;
            var6 = var5;
         }

         if (var10) {
            throw new IllegalArgumentException("anchor error");
         }

         if (this.area != null && this.area.getWidth() == var3 && this.area.getHeight() == var4) {
            if (this.rgb == null || this.rgb != null && this.rgb.length != var3 * var4) {
               this.rgb = new int[var3 * var4];
            }

            this.graphicbitmap.getPixels(this.rgb, 0, var3, var1, var2, var3, var4);
            this.area.setPixels(this.rgb, 0, var3, 0, 0, var3, var4);
         } else {
            this.area = Bitmap.createBitmap(this.graphicbitmap, var1, var2, var3, var4);
         }

         this.font.tmpPaint.setStyle(Style.STROKE);
         this.canvas.drawBitmap(this.area, (float)var6, (float)var11, this.font.tmpPaint);
         this.font.tmpPaint.setStyle(Style.FILL);
      }

   }

   public void drawArc(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.font.tmpPaint.setStyle(Style.STROKE);
      this.canvas.drawArc(new RectF((float)var1, (float)var2, (float)(var1 + var3), (float)(var2 + var4)), (float)var5, (float)var6, false, this.font.tmpPaint);
      this.font.tmpPaint.setStyle(Style.FILL);
   }

   public void drawChar(char var1, int var2, int var3, int var4) {
      sb.delete(0, sb.length());
      sb.append(var1);
      this.drawString(sb.toString(), var2, var3, var4);
   }

   public void drawChars(char[] var1, int var2, int var3, int var4, int var5, int var6) {
      sb.delete(0, sb.length());
      sb.append(var1, var2, var3);
      this.drawString(sb.toString(), var4, var5, var6);
   }

   public void drawImage(Image var1, int var2, int var3, int var4) {
      int var5;
      if ((var4 & 8) != 0) {
         var5 = var2 - var1.getWidth();
      } else {
         var5 = var2;
         if ((var4 & 1) != 0) {
            var5 = var2 - var1.getWidth() / 2;
         }
      }

      if ((var4 & 32) != 0) {
         var2 = var3 - var1.getHeight();
      } else {
         var2 = var3;
         if ((var4 & 2) != 0) {
            var2 = var3 - var1.getHeight() / 2;
         }
      }

      this.canvas.drawBitmap(var1.getBitMapInpackage(), (float)var5, (float)var2, this.font.tmpPaint);
   }

   public void drawLine(float var1, float var2, float var3, float var4) {
      this.canvas.drawLine(var1, var2, var3, var4, this.font.tmpPaint);
   }

   public void drawRGB(int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         if (var6 > 0 && var7 > 0) {
            int var14 = var1.length;
            if (var6 < 0 || var7 < 0 || var2 < 0 || var2 >= var14 || var3 < 0 && (var7 - 1) * var3 < 0 || var3 >= 0 && (var7 - 1) * var3 + var6 - 1 >= var14) {
               throw new ArrayIndexOutOfBoundsException();
            }

            int var11 = var1[0];
            int var12 = var1[var14 / 2];
            int var13 = var1[var14 / 3];
            int var9 = var1[var14 / 4];
            int var10 = var1[var14 * 5 / 8];
            var14 = var1[var14 * 4 / 5];
            if (var11 == var12 && var12 == var13 && var13 == var9 && var9 == var10 && var10 == var14) {
               this.font.tmpPaint.setColor(var11);
               this.fillRect(var4, var5, var6, var7);
            } else {
               var9 = var3;
               if (var3 < var6) {
                  var9 = var6;
               }

               this.font.tmpPaint.setStyle(Style.STROKE);
               this.canvas.drawBitmap(var1, var2, var9, var4, var5, var6, var7, var8, this.font.tmpPaint);
               this.font.tmpPaint.setStyle(Style.FILL);
            }
         }

      }
   }

   public void drawRect(int var1, int var2, int var3, int var4) {
      this.font.tmpPaint.setStyle(Style.STROKE);
      this.canvas.drawRect((float)var1, (float)var2, (float)(var1 + var3), (float)(var2 + var4), this.font.tmpPaint);
      this.font.tmpPaint.setStyle(Style.FILL);
   }

   public void drawRegion(Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      int var12 = var4;
      int var11 = var5;
      if (var6 > 3) {
         var12 = var5;
         var11 = var4;
      }

      int var10;
      if ((var9 & 8) != 0) {
         var10 = var7 - var12;
      } else {
         var10 = var7;
         if ((var9 & 1) != 0) {
            var10 = var7 - var12 / 2;
         }
      }

      if ((var9 & 32) != 0) {
         var7 = var8 - var11;
      } else {
         var7 = var8;
         if ((var9 & 2) != 0) {
            var7 = var8 - var11 / 2;
         }
      }

      if (var6 == 0) {
         rect1.set(var2, var3, var2 + var4, var3 + var5);
         rect2.set(var10, var7, var10 + var4, var7 + var5);
         this.canvas.drawBitmap(var1.getBitMapInpackage(), rect1, rect2, this.font.tmpPaint);
      } else {
         ttmatrix = this.canvas.getMatrix();
         System.arraycopy(tTrans[var6], 0, tTransTemp, 0, 9);
         tTransTemp[2] = (float)(tTransXY[var6][0] * var12 + var10);
         tTransTemp[5] = (float)(tTransXY[var6][1] * var11 + var7);
         regionMatrix.setValues(tTransTemp);
         if (this.scale_x != 1.0F || this.scale_y != 1.0F) {
            regionMatrix.postScale(this.scale_x, this.scale_y);
         }

         this.canvas.setMatrix(regionMatrix);
         rect1.set(var2, var3, var2 + var4, var3 + var5);
         rect2.set(0, 0, var4 + 1, var5);
         this.canvas.drawBitmap(var1.getBitMapInpackage(), rect1, rect2, this.font.tmpPaint);
         this.canvas.setMatrix(ttmatrix);
      }

   }

   public void drawRoundRect(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.font.tmpPaint.setStyle(Style.STROKE);
      RectF var7 = new RectF((float)var1, (float)var2, (float)(var1 + var3), (float)(var2 + var4));
      this.canvas.drawRoundRect(var7, (float)var5, (float)var6, this.font.tmpPaint);
      this.font.tmpPaint.setStyle(Style.FILL);
   }

   public void drawString(String var1, int var2, int var3, int var4) {
      int var6 = var3 - 5;
      int var5 = var4;
      if (var4 == 0) {
         var5 = 20;
      }

      if ((var5 & 16) != 0) {
         var3 = var6 - this.font.getMetricsInt().top;
      } else if ((var5 & 32) != 0) {
         var3 = var6 - this.font.getMetricsInt().bottom;
      } else {
         var3 = var6;
         if ((var5 & 2) != 0) {
            var3 = var6 + ((this.font.getMetricsInt().descent - this.font.getMetricsInt().ascent) / 2 - this.font.getMetricsInt().descent);
         }
      }

      if ((var5 & 1) != 0) {
         this.font.tmpPaint.setTextAlign(Align.CENTER);
      } else if ((var5 & 8) != 0) {
         this.font.tmpPaint.setTextAlign(Align.RIGHT);
      } else if ((var5 & 4) != 0) {
         this.font.tmpPaint.setTextAlign(Align.LEFT);
      }

      this.canvas.drawText(var1, (float)var2, (float)var3, this.font.tmpPaint);
   }

   public void drawSubstring(String var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var6;
      if (var6 == 0) {
         var7 = 20;
      }

      if ((var7 & 16) != 0) {
         var6 = var5 - this.font.getMetricsInt().top;
      } else if ((var7 & 32) != 0) {
         var6 = var5 - this.font.getMetricsInt().bottom;
      } else {
         var6 = var5;
         if ((var7 & 2) != 0) {
            var6 = var5 + ((this.font.getMetricsInt().descent - this.font.getMetricsInt().ascent) / 2 - this.font.getMetricsInt().descent);
         }
      }

      if ((var7 & 1) != 0) {
         this.font.tmpPaint.setTextAlign(Align.CENTER);
      } else if ((var7 & 8) != 0) {
         this.font.tmpPaint.setTextAlign(Align.RIGHT);
      } else if ((var7 & 4) != 0) {
         this.font.tmpPaint.setTextAlign(Align.LEFT);
      }

      this.canvas.drawText(var1, var2, var3 + var2, (float)var4, (float)var6, this.font.tmpPaint);
   }

   public void fillArc(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.canvas.drawArc(new RectF((float)var1, (float)var2, (float)(var1 + var3), (float)(var2 + var4)), (float)var5, (float)var6, false, this.font.tmpPaint);
   }

   public void fillRect(int var1, int var2, int var3, int var4) {
      this.canvas.drawRect((float)var1, (float)var2, (float)(var1 + var3), (float)(var2 + var4), this.font.tmpPaint);
   }

   public void fillRoundRect(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.canvas.drawRoundRect(new RectF((float)var1, (float)var2, (float)(var1 + var3), (float)(var2 + var4)), (float)var5, (float)var6, this.font.tmpPaint);
   }

   public void fillTriangle(int var1, int var2, int var3, int var4, int var5, int var6) {
      Path var7 = new Path();
      var7.moveTo((float)var1, (float)var2);
      var7.lineTo((float)var3, (float)var4);
      var7.lineTo((float)var5, (float)var6);
      var7.lineTo((float)var1, (float)var2);
      this.canvas.drawPath(var7, this.font.tmpPaint);
   }

   public int getBlueComponent() {
      return this.font.tmpPaint.getColor() & 255;
   }

   public android.graphics.Canvas getCanvas() throws NullPointerException {
      if (this.canvas == null) {
         throw new NullPointerException();
      } else {
         return this.canvas;
      }
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

   public int getDisplayColor(int var1) {
      return var1;
   }

   public Font getFont() {
      return this.font;
   }

   public int getGrayScale() {
      return (this.getRedComponent() + this.getGreenComponent() + this.getBlueComponent()) / 3;
   }

   public int getGreenComponent() {
      return this.font.tmpPaint.getColor() >> 8 & 255;
   }

   public int getRedComponent() {
      return this.font.tmpPaint.getColor() >> 16 & 255;
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

   public void getXY(float var1, float var2) {
      this.scale_x = var1;
      this.scale_y = var2;
   }

   public boolean isAutoResetPainter() {
      return this.isResetPainter;
   }

   public void painterAutoReset(boolean var1) {
      this.isResetPainter = var1;
   }

   public void painterReset() {
      this.font.tmpPaint.reset();
   }

   public void restCanvas() {
      this.canvas.restore();
      this.canvas.save(2);
   }

   void setCanvas(android.graphics.Canvas var1) {
      this.canvas = var1;
      this.initPaint();
   }

   public void setClip(int var1, int var2, int var3, int var4) {
      this.clipx = var1;
      this.clipy = var2;
      this.clipw = var3;
      this.cliph = var4;
      if (var3 >= 0 && var4 >= 0) {
         this.canvas.clipRect((float)var1, (float)var2, (float)(var1 + var3), (float)(var2 + var4), Op.REPLACE);
      }

   }

   public void setColor(int var1) {
      if ((var1 & -16777216) != 0) {
         this.font.tmpPaint.setColor(var1);
      } else {
         this.font.tmpPaint.setColor(-16777216 | var1);
      }

   }

   public void setColor(int var1, int var2, int var3) {
      this.setColor(Color.rgb(var1, var2, var3));
   }

   public void setFont(Font var1) {
      this.font = var1;
   }

   public void setGrayScale(int var1) {
      if (var1 >= 0 && var1 <= 255) {
         this.setColor(var1, var1, var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   public void setStrokeStyle(int var1) {
      if (var1 == 0 && var1 == 1) {
         this.strokeStyle = var1;
         if (var1 == 0) {
            this.font.tmpPaint.setPathEffect((PathEffect)null);
         } else if (var1 == 1) {
            this.font.tmpPaint.setPathEffect(dashPathEffect);
         }

      } else {
         throw new IllegalArgumentException();
      }
   }

   public void translate(int var1, int var2) {
      this.canvas.translate((float)var1, (float)var2);
      this.translateX += var1;
      this.translateY += var2;
      this.clipx -= var1;
      this.clipy -= var2;
   }
}
