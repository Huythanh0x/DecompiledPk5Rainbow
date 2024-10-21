package javax.microedition.lcdui;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.PetKing5_480x800.R;

/* loaded from: classes.dex */
/**
 * The Font class provides methods to create and manipulate font styles and sizes.
 * It allows setting different font faces, styles, and sizes, and provides methods
 * to measure text dimensions.
 */
public final class Font {

    /**
     * Constants representing different font faces.
     */
    public static final int FACE_MONOSPACE = 32;
    public static final int FACE_PROPORTIONAL = 64;
    public static final int FACE_SYSTEM = 0;

    /**
     * Constants representing different font types.
     */
    public static final int FONT_INPUT_TEXT = 1;
    public static final int FONT_STATIC_TEXT = 0;

    /**
     * Constants representing different font sizes.
     */
    public static final int SIZE_LARGE = 26;
    public static final int SIZE_MEDIUM = 22;
    public static final int SIZE_SMALL = 8;

    /**
     * Constants representing different font styles.
     */
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

    /**
     * Private constructor to prevent instantiation.
     */
    private Font() {
    }

    /**
     * Returns the font metrics information.
     *
     * @return the font metrics information.
     */
    public Paint.FontMetricsInt getMetricsInt() {
        return this.metrics;
    }

    /**
     * Returns the default font.
     *
     * @return the default font.
     */
    public static Font getDefaultFont() {
        Font font = new Font();
        int style = 0 | 0;
        font.tTypeface = Typeface.create(Typeface.SANS_SERIF, style);
        font.tmpPaint.setTypeface(font.tTypeface);
        font.tmpPaint.setTextSize(fontSize[0]);
        font.metrics = font.tmpPaint.getFontMetricsInt();
        return font;
    }

    /**
     * Returns a font with the specified face, style, and size.
     *
     * @param face the font face.
     * @param style the font style.
     * @param size the font size.
     * @return the font with the specified face, style, and size.
     */
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

    /**
     * Returns the height of the font.
     *
     * @return the height of the font.
     */
    public int getHeight() {
        return this.tmpPaint.getFontMetricsInt(this.metrics);
    }

    /**
     * Returns the width of the specified character.
     *
     * @param ch the character.
     * @return the width of the specified character.
     */
    public int charWidth(char ch) {
        this.cHarr[0] = ch;
        return (int) this.tmpPaint.measureText(this.cHarr, 0, 1);
    }

    /**
     * Returns the width of the specified string.
     *
     * @param str the string.
     * @return the width of the specified string.
     */
    public int stringWidth(String str) {
        return (int) this.tmpPaint.measureText(str);
    }

    /**
     * Returns the width of the specified substring.
     *
     * @param str the string.
     * @param offset the starting offset of the substring.
     * @param len the length of the substring.
     * @return the width of the specified substring.
     */
    public int substringWidth(String str, int offset, int len) {
        return (int) this.tmpPaint.measureText(str, offset, offset + len);
    }

    /**
     * Sets the size of the font.
     *
     * @param i the new size of the font.
     */
    public void setSize(int i) {
        if (this.tmpSize != i) {
            this.tmpPaint.setTextSize(i);
            this.tmpSize = i;
        }
    }
}
