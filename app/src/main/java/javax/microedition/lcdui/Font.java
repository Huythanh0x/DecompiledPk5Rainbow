package javax.microedition.lcdui;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.PetKing5_480x800.R;

/* loaded from: classes.dex */
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
    private static int[] fontSize = CwaActivity.getInstance().getResources().getIntArray(R.array.FontSize);
    static int font_style = 0;
    private Paint.FontMetricsInt metrics;
    private int nowSize;
    private Typeface tTypeface;
    protected Paint tmpPaint = new Paint();
    char[] cHarr = new char[1];
    private int tmpSize = -1;

    private Font() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Paint.FontMetricsInt getMetricsInt() {
        return this.metrics;
    }

    public static Font getDefaultFont() {
        Font font = new Font();
        int style = 0 | 0;
        font.tTypeface = Typeface.create(Typeface.SANS_SERIF, style);
        font.tmpPaint.setTypeface(font.tTypeface);
        font.tmpPaint.setTextSize(fontSize[0]);
        font.metrics = font.tmpPaint.getFontMetricsInt();
        return font;
    }

    public static Font getFont(int face, int style, int size) {
        Font font = new Font();
        Typeface family = Typeface.SANS_SERIF;
        switch (face) {
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
        font_style = 0;
        if (0 != 0) {
            font_style |= 0;
        }
        if ((style & 1) != 0) {
            font_style |= 1;
        }
        if ((style & 2) != 0) {
            font_style |= 2;
        }
        boolean underLine = false;
        if ((style & 4) != 0) {
            underLine = true;
        }
        font.tTypeface = Typeface.create(family, font_style);
        switch (size) {
            case 8:
                font.nowSize = fontSize[0];
                break;
            case 22:
                font.nowSize = fontSize[1];
                break;
            case SIZE_LARGE /* 26 */:
                font.nowSize = fontSize[2];
                break;
        }
        font.tmpPaint.setTypeface(font.tTypeface);
        font.tmpPaint.setTextSize(font.nowSize);
        font.tmpPaint.setUnderlineText(underLine);
        font.metrics = font.tmpPaint.getFontMetricsInt();
        return font;
    }

    public int getHeight() {
        return this.tmpPaint.getFontMetricsInt(this.metrics);
    }

    public int charWidth(char ch) {
        this.cHarr[0] = ch;
        return (int) this.tmpPaint.measureText(this.cHarr, 0, 1);
    }

    public int stringWidth(String str) {
        return (int) this.tmpPaint.measureText(str);
    }

    public int substringWidth(String str, int offset, int len) {
        return (int) this.tmpPaint.measureText(str, offset, offset + len);
    }

    public void setSize(int i) {
        if (this.tmpSize != i) {
            this.tmpPaint.setTextSize(i);
            this.tmpSize = i;
        }
    }
}
