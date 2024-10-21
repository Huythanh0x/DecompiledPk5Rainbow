package javax.microedition.lcdui;

import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint;
import android.graphics.Typeface;

public final class Font {
    public static final int FACE_MONOSPACE = 0x20;
    public static final int FACE_PROPORTIONAL = 0x40;
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
    char[] cHarr;
    private static int[] fontSize;
    static int font_style;
    private Paint.FontMetricsInt metrics;
    private int nowSize;
    private Typeface tTypeface;
    protected Paint tmpPaint;
    private int tmpSize;

    static {
        Font.fontSize = CwaActivity.getInstance().getResources().getIntArray(0x7F050000);  // array:FontSize
        Font.font_style = 0;
    }

    private Font() {
        this.tmpPaint = new Paint();
        this.cHarr = new char[1];
        this.tmpSize = -1;
    }

    public int charWidth(char ch) {
        this.cHarr[0] = ch;
        return (int)this.tmpPaint.measureText(this.cHarr, 0, 1);
    }

    public static Font getDefaultFont() {
        Font font = new Font();
        font.tTypeface = Typeface.create(Typeface.SANS_SERIF, 0);
        font.tmpPaint.setTypeface(font.tTypeface);
        font.tmpPaint.setTextSize(((float)Font.fontSize[0]));
        font.metrics = font.tmpPaint.getFontMetricsInt();
        return font;
    }

    public static Font getFont(int face, int style, int size) {
        Font font = new Font();
        Typeface family = Typeface.SANS_SERIF;
        switch(face) {
            case 0: {
                family = Typeface.SANS_SERIF;
                break;
            }
            case 0x20: {
                family = Typeface.MONOSPACE;
                break;
            }
            case 0x40: {
                family = Typeface.SANS_SERIF;
            }
        }
        Font.font_style = 0;
        if((style & 1) != 0) {
            Font.font_style |= 1;
        }
        if((style & 2) != 0) {
            Font.font_style |= 2;
        }
        font.tTypeface = Typeface.create(family, Font.font_style);
        switch(size) {
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
            }
        }
        font.tmpPaint.setTypeface(font.tTypeface);
        font.tmpPaint.setTextSize(((float)font.nowSize));
        font.tmpPaint.setUnderlineText((style & 4) != 0);
        font.metrics = font.tmpPaint.getFontMetricsInt();
        return font;
    }

    public int getHeight() {
        return this.tmpPaint.getFontMetricsInt(this.metrics);
    }

    protected Paint.FontMetricsInt getMetricsInt() {
        return this.metrics;
    }

    public void setSize(int i) {
        if(this.tmpSize == i) {
            return;
        }
        this.tmpPaint.setTextSize(((float)i));
        this.tmpSize = i;
    }

    public int stringWidth(String str) {
        return (int)this.tmpPaint.measureText(str);
    }

    public int substringWidth(String str, int offset, int len) {
        return (int)this.tmpPaint.measureText(str, offset, offset + len);
    }
}

