/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetricsInt
 *  android.graphics.Typeface
 *  javax.microedition.lcdui.CwaActivity
 */
package javax.microedition.lcdui;

import android.graphics.Paint;
import android.graphics.Typeface;
import javax.microedition.lcdui.CwaActivity;

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
    char[] cHarr;
    private Paint.FontMetricsInt metrics;
    private int nowSize;
    private Typeface tTypeface;
    protected Paint tmpPaint = new Paint();
    private int tmpSize = -1;

    private Font() {
        this.cHarr = new char[1];
    }

    public static Font getDefaultFont() {
        Font font = new Font();
        font.tTypeface = Typeface.create((Typeface)Typeface.SANS_SERIF, (int)(0 | 0));
        font.tmpPaint.setTypeface(font.tTypeface);
        font.tmpPaint.setTextSize((float)fontSize[0]);
        font.metrics = font.tmpPaint.getFontMetricsInt();
        return font;
    }

    /*
     * Exception decompiling
     */
    public static Font getFont(int var0, int var1_1, int var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE]], but top level block is 5[SWITCH]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:111)
         *     at java.base/java.lang.Thread.run(Thread.java:840)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public int charWidth(char c) {
        this.cHarr[0] = c;
        return (int)this.tmpPaint.measureText(this.cHarr, 0, 1);
    }

    public int getHeight() {
        return this.tmpPaint.getFontMetricsInt(this.metrics);
    }

    protected Paint.FontMetricsInt getMetricsInt() {
        return this.metrics;
    }

    /*
     * Enabled force condition propagation
     */
    public void setSize(int n) {
        if (this.tmpSize == n) {
            return;
        }
        this.tmpPaint.setTextSize((float)n);
        this.tmpSize = n;
    }

    public int stringWidth(String string) {
        return (int)this.tmpPaint.measureText(string);
    }

    public int substringWidth(String string, int n, int n2) {
        return (int)this.tmpPaint.measureText(string, n, n + n2);
    }
}
