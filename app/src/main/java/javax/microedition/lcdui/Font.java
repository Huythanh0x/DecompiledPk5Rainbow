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
  
  public static Font getDefaultFont() {
    Font font = new Font();
    font.tTypeface = Typeface.create(Typeface.SANS_SERIF, false | false);
    font.tmpPaint.setTypeface(font.tTypeface);
    font.tmpPaint.setTextSize(fontSize[0]);
    font.metrics = font.tmpPaint.getFontMetricsInt();
    return font;
  }
  
  public static Font getFont(int paramInt1, int paramInt2, int paramInt3) {
    boolean bool;
    Font font = new Font();
    Typeface typeface = Typeface.SANS_SERIF;
    switch (paramInt1) {
      default:
        font_style = 0;
        if (false)
          font_style |= 0x0; 
        if ((paramInt2 & 0x1) != 0)
          font_style |= 0x1; 
        if ((paramInt2 & 0x2) != 0)
          font_style |= 0x2; 
        bool = false;
        if ((paramInt2 & 0x4) != 0)
          bool = true; 
        font.tTypeface = Typeface.create(typeface, font_style);
        switch (paramInt3) {
          default:
            font.tmpPaint.setTypeface(font.tTypeface);
            font.tmpPaint.setTextSize(font.nowSize);
            font.tmpPaint.setUnderlineText(bool);
            font.metrics = font.tmpPaint.getFontMetricsInt();
            return font;
          case 8:
            font.nowSize = fontSize[0];
          case 22:
            font.nowSize = fontSize[1];
          case 26:
            break;
        } 
        break;
      case 0:
        typeface = Typeface.SANS_SERIF;
      case 32:
        typeface = Typeface.MONOSPACE;
      case 64:
        typeface = Typeface.SANS_SERIF;
    } 
    font.nowSize = fontSize[2];
  }
  
  public int charWidth(char paramChar) {
    this.cHarr[0] = paramChar;
    return (int)this.tmpPaint.measureText(this.cHarr, 0, 1);
  }
  
  public int getHeight() {
    return this.tmpPaint.getFontMetricsInt(this.metrics);
  }
  
  protected Paint.FontMetricsInt getMetricsInt() {
    return this.metrics;
  }
  
  public void setSize(int paramInt) {
    if (this.tmpSize != paramInt) {
      this.tmpPaint.setTextSize(paramInt);
      this.tmpSize = paramInt;
    } 
  }
  
  public int stringWidth(String paramString) {
    return (int)this.tmpPaint.measureText(paramString);
  }
  
  public int substringWidth(String paramString, int paramInt1, int paramInt2) {
    return (int)this.tmpPaint.measureText(paramString, paramInt1, paramInt1 + paramInt2);
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/lcdui/Font.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */