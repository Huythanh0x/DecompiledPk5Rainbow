package javax.microedition.lcdui.Font;
import javax.microedition.lcdui.CwaActivity;
import android.content.res.Resources;
import java.lang.Object;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.Paint$FontMetricsInt;
import java.lang.String;

public final class Font	// class@000141 from classes.dex
{
    char[] cHarr;
    private Paint$FontMetricsInt metrics;
    private int nowSize;
    private Typeface tTypeface;
    protected Paint tmpPaint;
    private int tmpSize;
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
    private static int[] fontSize;
    static int font_style;

    static {
       Font.fontSize = CwaActivity.getInstance().getResources().getIntArray(0x7f050000);
       Font.font_style = 0;
    }
    private void Font(){
       super();
       this.tmpPaint = new Paint();
       char[] uocharArray = new char[1];
       this.cHarr = uocharArray;
       this.tmpSize = -1;
    }
    public static Font getDefaultFont(){
       Font font = new Font();
       int style = 0;
       style = style | 0x00;
       font.tTypeface = Typeface.create(Typeface.SANS_SERIF, style);
       font.tmpPaint.setTypeface(font.tTypeface);
       font.tmpPaint.setTextSize((float)Font.fontSize[0]);
       font.metrics = font.tmpPaint.getFontMetricsInt();
       return font;
    }
    public static Font getFont(int face,int style,int size){
       int i = 0;
       Font font = new Font();
       Typeface family = Typeface.SANS_SERIF;
       switch (face){
           case 0:
             family = Typeface.SANS_SERIF;
             break;
           case 32:
             family = Typeface.MONOSPACE;
             break;
           case 64:
             family = Typeface.SANS_SERIF;
             break;
       }
       Font.font_style = i;
       if (i) {
          Font.font_style = Font.font_style | 0x00;
       }
       if ((style & 0x01)) {
          Font.font_style = Font.font_style | 0x01;
       }
       if ((style & 0x02)) {
          Font.font_style = Font.font_style | 0x02;
       }
       boolean underLine = false;
       if ((style & 0x04)) {
          underLine = true;
       }
       font.tTypeface = Typeface.create(family, Font.font_style);
       switch (size){
           case 8:
             font.nowSize = Font.fontSize[i];
             break;
           case 22:
             font.nowSize = Font.fontSize[1];
             break;
           case 26:
             font.nowSize = Font.fontSize[2];
             break;
       }
       font.tmpPaint.setTypeface(font.tTypeface);
       font.tmpPaint.setTextSize((float)font.nowSize);
       font.tmpPaint.setUnderlineText(underLine);
       font.metrics = font.tmpPaint.getFontMetricsInt();
       return font;
    }
    public int charWidth(char ch){
       this.cHarr[0] = ch;
       return (int)this.tmpPaint.measureText(this.cHarr, 0, 1);
    }
    public int getHeight(){
       return this.tmpPaint.getFontMetricsInt(this.metrics);
    }
    protected Paint$FontMetricsInt getMetricsInt(){
       return this.metrics;
    }
    public void setSize(int i){
       if (this.tmpSize != i) {
          this.tmpPaint.setTextSize((float)i);
          this.tmpSize = i;
       }
       return;
    }
    public int stringWidth(String str){
       return (int)this.tmpPaint.measureText(str);
    }
    public int substringWidth(String str,int offset,int len){
       return (int)this.tmpPaint.measureText(str, offset, (offset + len));
    }
}
