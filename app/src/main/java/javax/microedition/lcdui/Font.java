package javax.microedition.lcdui;

import android.graphics.Paint;
import android.graphics.Typeface;

public final class Font {
   public static final int FACE_MONOSPACE = 32;
   public static final int FACE_PROPORTIONAL = 64;
   public static final int FACE_SYSTEM = 0;
   public static final int FONT_INPUT_TEXT = 1;
   public static final int FONT_STATIC_TEXT = 0;
   public static final int SIZE_LARGE = 26;
   public static final int SIZE_MEDIUM = 22;
   public static final int SIZE_SMALL = 8;
   public static final int STYLE_BOLD = 1;
   public static final int STYLE_ITALIC = 2;
   public static final int STYLE_PLAIN = 0;
   public static final int STYLE_UNDERLINED = 4;
   private static int[] fontSize = CwaActivity.getInstance().getResources().getIntArray(2131034112);
   static int font_style = 0;
   char[] cHarr = new char[1];
   private Paint.FontMetricsInt metrics;
   private int nowSize;
   private Typeface tTypeface;
   protected Paint tmpPaint = new Paint();
   private int tmpSize = -1;

   private Font() {
      super();
   }

   public static Font getDefaultFont() {
      Font var0 = new Font();
      var0.tTypeface = Typeface.create(Typeface.SANS_SERIF, 0 | 0);
      var0.tmpPaint.setTypeface(var0.tTypeface);
      var0.tmpPaint.setTextSize((float)fontSize[0]);
      var0.metrics = var0.tmpPaint.getFontMetricsInt();
      return var0;
   }

   public static Font getFont(int var0, int var1, int var2) {
      Font var5 = new Font();
      Typeface var4 = Typeface.SANS_SERIF;
      switch (var0) {
         case 0:
            var4 = Typeface.SANS_SERIF;
            break;
         case 32:
            var4 = Typeface.MONOSPACE;
            break;
         case 64:
            var4 = Typeface.SANS_SERIF;
      }

      font_style = 0;
      if (false) {
         font_style |= 0;
      }

      if ((var1 & 1) != 0) {
         font_style |= 1;
      }

      if ((var1 & 2) != 0) {
         font_style |= 2;
      }

      boolean var3 = false;
      if ((var1 & 4) != 0) {
         var3 = true;
      }

      var5.tTypeface = Typeface.create(var4, font_style);
      switch (var2) {
         case 8:
            var5.nowSize = fontSize[0];
            break;
         case 22:
            var5.nowSize = fontSize[1];
            break;
         case 26:
            var5.nowSize = fontSize[2];
      }

      var5.tmpPaint.setTypeface(var5.tTypeface);
      var5.tmpPaint.setTextSize((float)var5.nowSize);
      var5.tmpPaint.setUnderlineText(var3);
      var5.metrics = var5.tmpPaint.getFontMetricsInt();
      return var5;
   }

   public int charWidth(char var1) {
      this.cHarr[0] = var1;
      return (int)this.tmpPaint.measureText(this.cHarr, 0, 1);
   }

   public int getHeight() {
      return this.tmpPaint.getFontMetricsInt(this.metrics);
   }

   protected Paint.FontMetricsInt getMetricsInt() {
      return this.metrics;
   }

   public void setSize(int var1) {
      if (this.tmpSize != var1) {
         this.tmpPaint.setTextSize((float)var1);
         this.tmpSize = var1;
      }

   }

   public int stringWidth(String var1) {
      return (int)this.tmpPaint.measureText(var1);
   }

   public int substringWidth(String var1, int var2, int var3) {
      return (int)this.tmpPaint.measureText(var1, var2, var2 + var3);
   }
}
