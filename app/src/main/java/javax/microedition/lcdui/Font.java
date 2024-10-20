package javax.microedition.lcdui;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.Paint$FontMetricsInt;

public final class Font
{
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
    char[] cHarr;
    private Paint$FontMetricsInt metrics;
    private int nowSize;
    private Typeface tTypeface;
    protected Paint tmpPaint;
    private int tmpSize;
    
    static {
        Font.fontSize = CwaActivity.getInstance().getResources().getIntArray(2131034112);
        Font.font_style = 0;
    }
    
    private Font() {
        super();
        this.tmpPaint = new Paint();
        this.cHarr = new char[1];
        this.tmpSize = -1;
    }
    
    public static Font getDefaultFont() {
        final Font font = new Font();
        font.tTypeface = Typeface.create(Typeface.SANS_SERIF, (int)((false | false) ? 1 : 0));
        font.tmpPaint.setTypeface(font.tTypeface);
        font.tmpPaint.setTextSize((float)Font.fontSize[0]);
        font.metrics = font.tmpPaint.getFontMetricsInt();
        return font;
    }
    
    public static Font getFont(final int n, final int n2, final int n3) {
        final Font font = new Font();
        Typeface typeface = Typeface.SANS_SERIF;
        switch (n) {
            case 0: {
                typeface = Typeface.SANS_SERIF;
                break;
            }
            case 32: {
                typeface = Typeface.MONOSPACE;
                break;
            }
            case 64: {
                typeface = Typeface.SANS_SERIF;
                break;
            }
        }
        Font.font_style = 0;
        if (false) {
            Font.font_style |= 0x0;
        }
        if ((n2 & 0x1) != 0x0) {
            Font.font_style |= 0x1;
        }
        if ((n2 & 0x2) != 0x0) {
            Font.font_style |= 0x2;
        }
        boolean underlineText = false;
        if ((n2 & 0x4) != 0x0) {
            underlineText = true;
        }
        font.tTypeface = Typeface.create(typeface, Font.font_style);
        switch (n3) {
            case 8: {
                font.nowSize = Font.fontSize[0];
                break;
            }
            case 22: {
                font.nowSize = Font.fontSize[1];
                break;
            }
            case 26: {
                font.nowSize = Font.fontSize[2];
                break;
            }
        }
        font.tmpPaint.setTypeface(font.tTypeface);
        font.tmpPaint.setTextSize((float)font.nowSize);
        font.tmpPaint.setUnderlineText(underlineText);
        font.metrics = font.tmpPaint.getFontMetricsInt();
        return font;
    }
    
    public int charWidth(final char c) {
        this.cHarr[0] = c;
        return (int)this.tmpPaint.measureText(this.cHarr, 0, 1);
    }
    
    public int getHeight() {
        return this.tmpPaint.getFontMetricsInt(this.metrics);
    }
    
    protected Paint$FontMetricsInt getMetricsInt() {
        return this.metrics;
    }
    
    public void setSize(final int tmpSize) {
        if (this.tmpSize != tmpSize) {
            this.tmpPaint.setTextSize((float)tmpSize);
            this.tmpSize = tmpSize;
        }
    }
    
    public int stringWidth(final String s) {
        return (int)this.tmpPaint.measureText(s);
    }
    
    public int substringWidth(final String s, final int n, final int n2) {
        return (int)this.tmpPaint.measureText(s, n, n + n2);
    }
}
