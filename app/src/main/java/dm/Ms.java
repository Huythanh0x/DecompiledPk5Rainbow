/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.android.Util.AndroidUtil
 *  dm.Sprite
 *  javax.microedition.lcdui.Font
 *  javax.microedition.lcdui.Image
 *  javax.microedition.rms.RecordStore
 *  main.Key_H
 */
package dm;

import com.android.Util.AndroidUtil;
import dm.Sprite;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.util.Random;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;
import main.Key_H;

public class Ms
implements Key_H {
    public static Font font;
    public static int key;
    public static boolean keyRepeat;
    public static byte key_delay;
    public static byte key_time;
    private static Ms msListener;
    private static Random random;
    private static RecordStore rms;
    public static int skip;
    public static int skip2;
    final int RMSSIZE;
    private int sleep_time;
    private final byte[] transA;

    static {
        random = new Random();
        font = Font.getFont((int)0, (int)0, (int)26);
        key_delay = 0;
        key_time = (byte)10;
    }

    public Ms() {
        this.RMSSIZE = 15360;
        byte[] byArray = new byte[8];
        byArray[1] = 6;
        byArray[2] = 3;
        byArray[3] = 5;
        byArray[4] = 2;
        byArray[5] = 7;
        byArray[6] = 1;
        byArray[7] = 4;
        this.transA = byArray;
        msListener = this;
    }

    /*
     * Enabled force condition propagation
     */
    public static int abs(int n) {
        if (n <= 0) return -n;
        return n;
    }

    /*
     * Enabled force condition propagation
     */
    private boolean checkIsSimulate() {
        if (Runtime.getRuntime().totalMemory() >= 8000000L) {
            return true;
        }
        try {
            Class.forName("emulator.Emulator");
            Class.forName("com.sprintpcs.util.System");
            return true;
        }
        catch (Exception exception) {
            String string = System.getProperty("microedition.platform");
            if (string.toLowerCase().indexOf("wtk") != -1) return true;
            if (string.toLowerCase().indexOf("javasdk") != -1) return true;
            if (string.toLowerCase().indexOf("j2me") != -1) return true;
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public static int compare_min(int n, int n2) {
        if (n > n2) return n2;
        return n;
    }

    /*
     * Unable to fully structure code
     */
    public static long getNum(byte[] var0) {
        var3_1 = 0;
        var4_2 = var0.length;
        var2_3 = 0;
        block7: while (true) {
            if (var2_3 >= var4_2) {
                return var3_1;
            }
            var1_4 = var3_1;
            switch (var4_2) {
                default: {
                    var1_4 = var3_1;
                }
lbl11:
                // 5 sources

                case 3: 
                case 5: 
                case 6: 
                case 7: lbl-1000:
                // 2 sources

                {
                    while (true) {
                        ++var2_3;
                        var3_1 = var1_4;
                        continue block7;
                        break;
                    }
                }
                case 1: {
                    var1_4 = var3_1 + (byte)((var0[var2_3] & 255) << var2_3 * 8);
                    ** GOTO lbl11
                }
                case 2: {
                    var1_4 = var3_1 + (short)((var0[var2_3] & 255) << var2_3 * 8);
                    ** GOTO lbl11
                }
                case 4: {
                    var1_4 = var3_1 + ((var0[var2_3] & 255) << var2_3 * 8);
                    ** GOTO lbl11
                }
                case 8: 
            }
            break;
        }
        var1_4 = (int)((long)var3_1 + (long)((var0[var2_3] & 255) << var2_3 * 8));
        ** while (true)
    }

    public static int getRandom(int n) {
        return (random.nextInt() & Integer.MAX_VALUE) % n;
    }

    /*
     * Enabled force condition propagation
     */
    private short getStreamL(byte[] byArray, int n) {
        if (n == 0) {
            n = skip;
            skip = n + 1;
            return byArray[n];
        }
        if (n == 1) {
            n = skip;
            skip = n + 1;
            return (short)(byArray[n] + 100);
        }
        if (n == 2) {
            n = skip;
            skip = n + 1;
            byte by = byArray[n];
            n = skip;
            skip = n + 1;
            return (short)((by & 0xFF) << 8 | byArray[n] & 0xFF);
        }
        n = skip;
        skip = n + 1;
        n = byArray[n];
        int n2 = skip;
        skip = n2 + 1;
        return (short)(n & 0xFF | (byArray[n2] & 0xFF) << 8);
    }

    public static Ms i() {
        if (msListener == null) {
            msListener = new Ms();
        }
        return msListener;
    }

    public short[] byteArrayToShortArray(byte[] byArray) {
        skip = 0;
        int n = byArray.length >> 1;
        short[] sArray = new short[n];
        int n2 = 0;
        while (n2 < n) {
            sArray[n2] = this.getStreamL(byArray, 2);
            ++n2;
        }
        return sArray;
    }

    /*
     * Unable to fully structure code
     */
    public void correctSelect(byte[] var1_1, int var2_2, int var3_3) {
        if (var1_1[0] < var2_2) {
            var1_1[1] = (byte)(var1_1[0] - var3_3 + 1);
lbl3:
            // 2 sources

            while (true) {
                if (var1_1[0] < 0) {
                    var1_1[0] = 0;
                }
                if (var1_1[1] < 0) {
                    var1_1[1] = 0;
                }
                return;
            }
        }
        var1_1[0] = (byte)(var2_2 - 1);
        var1_1[1] = (byte)(var2_2 - var3_3);
        ** while (true)
    }

    public byte[][] create2Array(byte[] byArray) {
        int n = skip;
        skip = n + 1;
        byte[][] byArrayArray = new byte[this.getLen_byte(byArray[n])][];
        n = 0;
        while (n < byArrayArray.length) {
            byArrayArray[n] = this.createArray(byArray);
            ++n;
        }
        return byArrayArray;
    }

    public byte[][][] create3Array(byte[] byArray) {
        int n = skip;
        skip = n + 1;
        byte[][][] byArrayArray = new byte[this.getLen_byte(byArray[n])][][];
        n = 0;
        while (n < byArrayArray.length) {
            byArrayArray[n] = this.create2Array(byArray);
            ++n;
        }
        return byArrayArray;
    }

    public byte[][][][] create4Array(byte[] byArray) {
        int n = skip;
        skip = n + 1;
        byte[][][][] byArrayArray = new byte[this.getLen_byte(byArray[n])][][][];
        n = 0;
        while (n < byArrayArray.length) {
            byArrayArray[n] = this.create3Array(byArray);
            ++n;
        }
        return byArrayArray;
    }

    public byte[] createArray(byte[] byArray) {
        int n = skip;
        skip = n + 1;
        byte[] byArray2 = new byte[this.getLen_byte(byArray[n])];
        n = 0;
        while (n < byArray2.length) {
            int n2 = skip;
            skip = n2 + 1;
            byArray2[n] = byArray[n2];
            ++n;
        }
        return byArray2;
    }

    Image createCellImage(Image image, int n, int n2, int n3, int n4) {
        return this.createImage(image, n % (image.getWidth() / n2) * n2, n % (image.getHeight() / n3) * n3, n2, n3, n4);
    }

    /*
     * Enabled force condition propagation
     */
    public Image createImage(String string) {
        try {
            StringBuilder stringBuilder = new StringBuilder("/");
            return Image.createImage((String)stringBuilder.append(string).append(".png").toString());
        }
        catch (Exception exception) {
            return null;
        }
    }

    public Image createImage(String object, int n) {
        object = this.getStream((String)object, n);
        return Image.createImage((byte[])object, (int)0, (int)((Object)object).length);
    }

    Image createImage(Image image, int n, int n2, int n3, int n4, int n5) {
        int n6 = n3;
        if (n + n3 > image.getWidth()) {
            n6 = image.getWidth() - n;
        }
        n3 = n4;
        if (n2 + n4 > image.getHeight()) {
            n3 = image.getHeight() - n2;
        }
        return Image.createImage((Image)image, (int)n, (int)n2, (int)n6, (int)n3, (int)this.transA[n5]);
    }

    public Image[] createImageArray(int n, String string) {
        Image[] imageArray = new Image[n];
        n = 0;
        while (n < imageArray.length) {
            imageArray[n] = this.createImage(String.valueOf(string) + n);
            n = (short)(n + 1);
        }
        return imageArray;
    }

    public Image[] createImageArray_(int n, String string, int n2) {
        Image[] imageArray = new Image[n];
        n = 0;
        while (n < imageArray.length) {
            imageArray[n] = this.createImage_(String.valueOf(string) + n, n2);
            n = (short)(n + 1);
        }
        return imageArray;
    }

    /*
     * Enabled force condition propagation
     */
    public Image createImage_(String string, int n) {
        try {
            StringBuilder stringBuilder = new StringBuilder("/");
            return Image.createImage((String)stringBuilder.append(string).append(".png").toString(), (int)n);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public int[] createIntArray(byte[] byArray) {
        int[] nArray = new int[this.getStreamL(byArray, 0)];
        int n = 0;
        while (n < nArray.length) {
            int n2 = skip;
            skip = n2 + 1;
            n2 = byArray[n2];
            int n3 = skip;
            skip = n3 + 1;
            n3 = byArray[n3];
            int n4 = skip;
            skip = n4 + 1;
            byte by = byArray[n4];
            n4 = skip;
            skip = n4 + 1;
            nArray[n] = n2 & 0xFF | (n3 & 0xFF) << 8 | (by & 0xFF) << 16 | (byArray[n4] & 0xFF) << 24;
            ++n;
        }
        return nArray;
    }

    public short[][] createShort2Array(byte[] byArray, int n) {
        short[][] sArrayArray = new short[this.getStreamL(byArray, n)][];
        int n2 = 0;
        while (n2 < sArrayArray.length) {
            sArrayArray[n2] = this.createShortArray(byArray, n);
            ++n2;
        }
        return sArrayArray;
    }

    public short[][][] createShort3Array(byte[] byArray, int n) {
        short[][][] sArrayArray = new short[this.getStreamL(byArray, n)][][];
        int n2 = 0;
        while (n2 < sArrayArray.length) {
            sArrayArray[n2] = this.createShort2Array(byArray, n);
            ++n2;
        }
        return sArrayArray;
    }

    /*
     * Unable to fully structure code
     */
    public short[] createShortArray(byte[] var1_1, int var2_2) {
        var5_3 = new short[this.getStreamL(var1_1, var2_2)];
        var3_4 = 0;
        block0: while (true) {
            if (var3_4 >= var5_3.length) {
                return var5_3;
            }
            if (var2_2 != 2) break;
            var4_5 = 2;
lbl8:
            // 2 sources

            while (true) {
                var5_3[var3_4] = this.getStreamL(var1_1, var4_5);
                ++var3_4;
                continue block0;
                break;
            }
            break;
        }
        var4_5 = -1;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public Sprite createSprite(String string, boolean bl) {
        byte[] byArray = this.getStream(String.valueOf(string) + ".data", -1);
        skip = 0;
        if (!bl) return Sprite.Create((Image)this.createImage(string), (short[][])this.createShort2Array(byArray, 2), (short[][][])this.createShort3Array(byArray, 2), (short[][][])this.createShort3Array(byArray, 2));
        return Sprite.Create((Image)this.createImage(string), (byte[][])this.create2Array(byArray), (byte[][][])this.create3Array(byArray), (byte[][][])this.create3Array(byArray));
    }

    public StringBuffer[][] createString2Array(byte[] byArray) {
        int n = skip;
        skip = n + 1;
        StringBuffer[][] stringBufferArray = new StringBuffer[byArray[n]][];
        n = 0;
        while (n < stringBufferArray.length) {
            stringBufferArray[n] = this.createStringArray(byArray);
            n = (byte)(n + 1);
        }
        return stringBufferArray;
    }

    public StringBuffer[] createStringArray(byte[] byArray) {
        int n = skip;
        skip = n + 1;
        StringBuffer[] stringBufferArray = new StringBuffer[this.getLen_byte(byArray[n])];
        n = 0;
        while (n < stringBufferArray.length) {
            short s;
            short s2 = s = byArray[skip];
            if (s < 0) {
                s2 = (short)(s + 256);
            }
            stringBufferArray[n] = new StringBuffer(this.getDialogs(byArray, skip + 1, s2));
            skip += s2 * 2 + 1;
            n = (byte)(n + 1);
        }
        return stringBufferArray;
    }

    public StringBuffer createStringArrayOne(byte[] byArray) {
        return new StringBuffer(this.getDialogs(byArray, 2, this.getLen_byte(byArray[1])));
    }

    public boolean equals(StringBuffer stringBuffer, String string) {
        return stringBuffer.toString().equals(string);
    }

    public String getDialogs(byte[] byArray, int n, int n2) {
        StringBuffer stringBuffer = new StringBuffer();
        int n3 = 0;
        while (n3 < n2) {
            stringBuffer.append((char)(byArray[(n3 << 1) + n] << 8 | byArray[(n3 << 1) + n + 1] & 0xFF));
            ++n3;
        }
        return stringBuffer.toString();
    }

    /*
     * Unable to fully structure code
     */
    public byte[] getEventNowData(short[][] var1_1) {
        var4_2 = new ByteArrayOutputStream();
        var4_2.write(var1_1.length);
        var2_3 = 0;
        block0: while (true) {
            if (var2_3 >= var1_1.length) {
                return var4_2.toByteArray();
            }
            if (var1_1[var2_3] != null) break;
            var4_2.write(0);
            while (true) {
                ++var2_3;
                continue block0;
                break;
            }
            break;
        }
        var4_2.write(var1_1[var2_3].length);
        var3_4 = 0;
        while (true) {
            if (var3_4 >= var1_1[var2_3].length) ** continue;
            var4_2.write(var1_1[var2_3][var3_4] & 255);
            var4_2.write(var1_1[var2_3][var3_4] >> 8 & 255);
            ++var3_4;
        }
    }

    public int getInt(byte[] byArray, int n) {
        return (byArray[n] & 0xFF) << 24 | (byArray[n + 1] & 0xFF) << 16 | (byArray[n + 2] & 0xFF) << 8 | byArray[n + 3] & 0xFF;
    }

    public int getLen_byte(byte by) {
        if (by < 0) {
            by = (byte)(by + 256);
        }
        return by;
    }

    public int getLen_short(short s) {
        if (s < 0) {
            s = (short)(65536 + s);
        }
        return s;
    }

    public byte getMin(byte by, byte by2) {
        if (by > by2) {
            by = by2;
        }
        return by;
    }

    public String getPrecision(int n) {
        return String.valueOf(n / 10) + "." + n % 10;
    }

    public short getShort(byte[] byArray, int n) {
        return (short)((byArray[n] & 0xFF) << 8 | byArray[n + 1] & 0xFF);
    }

    public int getSleep() {
        return this.sleep_time;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public byte[] getStream(String var1_1, int var2_3) {
        var4_5 /* !! */  = var5_4 = (byte[])null;
        try {
            var4_5 /* !! */  = var5_4;
            var4_5 /* !! */  = var5_4;
            var7_7 = new StringBuilder("/");
            var4_5 /* !! */  = var5_4;
            var6_6 = new DataInputStream(AndroidUtil.getResourceAsStream((String)var7_7.append((String)var1_1).toString()));
            if (var2_3 <= -1) ** GOTO lbl15
            var4_5 /* !! */  = var5_4;
            var6_6.readByte();
            var3_8 = 0;
            while (true) lbl-1000:
            // 2 sources

            {
                block6: {
                    if (var3_8 < var2_3) break block6;
lbl15:
                    // 2 sources

                    var4_5 /* !! */  = var5_4;
                    var1_1 = new byte[this.getLen_short(var6_6.readShort())];
                    var4_5 /* !! */  = (byte[])var1_1;
                    var6_6.read((byte[])var1_1);
                    var4_5 /* !! */  = (byte[])var1_1;
                    var6_6.close();
lbl22:
                    // 2 sources

                    return var1_1;
                }
                var4_5 /* !! */  = var5_4;
                var6_6.skip(this.getLen_short(var6_6.readShort()));
                break;
            }
        }
        catch (Exception var1_2) {
            var1_2.printStackTrace();
            var1_1 = var4_5 /* !! */ ;
            ** continue;
        }
        {
            var3_8 = (byte)(var3_8 + 1);
            ** while (true)
        }
    }

    public int getStringWidth(String string) {
        return font.stringWidth(string);
    }

    /*
     * Unable to fully structure code
     */
    public StringBuffer[] groupString(String var1_1, int var2_2) {
        block8: {
            block10: {
                block9: {
                    block7: {
                        var15_3 = new StringBuffer[30];
                        var12_4 = new StringBuffer();
                        var16_5 = new StringBuffer((String)var1_1);
                        var10_6 = var1_1.length();
                        var3_7 = 0;
                        var11_8 = (byte)this.getStringWidth("#0");
                        var8_9 = -1;
                        var4_10 = 0;
                        var1_1 = "";
                        var5_11 = 0;
                        block0: while (true) {
                            if (var5_11 >= var10_6) {
                                var1_1 = new StringBuffer[var8_9 + 1];
                                System.arraycopy(var15_3, 0, var1_1, 0, var8_9 + 1);
                                var12_4 = null;
                                return var1_1;
                            }
                            if (var16_5.charAt(0) != '#') break block7;
                            if (var16_5.charAt(1) != 'n') break;
                            var4_10 = 1;
lbl20:
                            // 2 sources

                            while (true) {
                                var16_5.deleteCharAt(0);
                                var16_5.deleteCharAt(0);
                                var9_14 = var5_11 + 1;
                                var13_15 = var1_1;
                                var5_11 = var3_7;
lbl28:
                                // 4 sources

                                while (true) {
                                    var6_12 = var4_10;
                                    var7_13 = var8_9;
                                    var3_7 = var5_11;
                                    var14_16 = var12_4;
                                    if (var4_10 == 0) ** GOTO lbl44
                                    var7_13 = (byte)(var8_9 + 1);
                                    if (var13_15.length() != 0) break block8;
                                    var3_7 = 0;
lbl37:
                                    // 2 sources

                                    while (true) {
                                        var3_7 = (byte)var3_7;
                                        var6_12 = 0;
                                        var15_3[var7_13] = var12_4;
                                        var14_16 = new StringBuffer();
                                        var14_16.append((String)var13_15);
lbl44:
                                        // 2 sources

                                        var5_11 = var9_14 + 1;
                                        var4_10 = var6_12;
                                        var8_9 = var7_13;
                                        var1_1 = var13_15;
                                        var12_4 = var14_16;
                                        continue block0;
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        var1_1 = "#" + var16_5.charAt(1);
                        var12_4.append((String)var1_1);
                        var3_7 = (byte)(var3_7 + 1);
                        ** while (true)
                    }
                    var12_4.append(var16_5.charAt(0));
                    if (var2_2 == 0 || this.getStringWidth(var12_4.toString()) > var11_8 * var3_7 + var2_2) break block9;
                    var16_5.deleteCharAt(0);
                    var7_13 = var4_10;
                    var6_12 = var5_11;
lbl63:
                    // 3 sources

                    while (true) {
                        var9_14 = var6_12;
                        var4_10 = var7_13;
                        var5_11 = var3_7;
                        var13_15 = var1_1;
                        if (var6_12 != var10_6 - 1) ** GOTO lbl28
                        var9_14 = var6_12;
                        var4_10 = var7_13;
                        var5_11 = var3_7;
                        var13_15 = var1_1;
                        if (var7_13 != 0) ** GOTO lbl28
                        var4_10 = 1;
                        var9_14 = var6_12;
                        var5_11 = var3_7;
                        var13_15 = var1_1;
                        ** continue;
                        break;
                    }
                }
                if (var2_2 == 0) break block10;
                var6_12 = var5_11 - 1;
                var12_4.deleteCharAt(var12_4.length() - 1);
                var7_13 = 1;
                ** GOTO lbl63
            }
            var16_5.deleteCharAt(0);
            var6_12 = var5_11;
            var7_13 = var4_10;
            ** while (true)
        }
        var3_7 = 1;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isRect(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        if (n >= n5 + n7) return false;
        if (n + n3 <= n5) return false;
        if (n2 >= n6 + n8) return false;
        if (n2 + n4 <= n6) return false;
        return true;
    }

    public void keyRelease() {
        keyRepeat = false;
        key_delay = 0;
        key_time = (byte)10;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key_Down() {
        if (key != -2) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key_Left() {
        if (key != -3) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key_Left_Right() {
        if (key == -3) return true;
        if (key == -4) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key_Num0() {
        if (key != 48) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key_Num1() {
        if (key != 49) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key_Num3() {
        if (key != 51) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key_Num9() {
        if (key != 57) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key_Right() {
        if (key != -4) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key_S1() {
        if (key != -6) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key_S1_Num5() {
        if (key == -6) return true;
        if (key == 53) return true;
        if (key == -5) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key_S2() {
        if (key != -7) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key_Up() {
        if (key != -1) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key_Up_Down() {
        if (key == -1) return true;
        if (key == -2) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key_delay() {
        if (key_delay != 0) return true;
        key_delay = key_time;
        if (key_time <= 1) return false;
        key_time = (byte)(key_time - 1);
        return false;
    }

    /*
     * Exception decompiling
     */
    public String[] loadText(byte[] var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.IllegalStateException: Backjump on non jumping statement @NONE, blocks:[] lbl44 : TryStatement: try { 3[TRYBLOCK]
         * 
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
         *     at org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:550)
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

    public short mathPercent(int n, int n2, int n3) {
        int n4 = n3;
        if (n3 < 1) {
            n4 = 1;
        }
        return (short)(n * n2 / n4);
    }

    /*
     * Enabled force condition propagation
     */
    public short mathSpeedDown(int n, int n2, boolean bl) {
        if (n / n2 != 0) {
            n -= n / n2;
            return (short)n;
        }
        if (bl && n > 0) {
            --n;
            return (short)n;
        }
        if (!bl) return 0;
        if (n >= 0) return 0;
        ++n;
        return (short)n;
    }

    /*
     * Enabled force condition propagation
     */
    public short mathSpeedN(int n, int n2, int n3, boolean bl) {
        if (n > n2 && n - n3 > n2) {
            n -= n3;
            return (short)n;
        }
        if (n < n2 && n + n3 < n2) {
            n += n3;
            return (short)n;
        }
        if (bl && n > n2) {
            --n;
            return (short)n;
        }
        if (bl && n < n2) {
            ++n;
            return (short)n;
        }
        n = n2;
        return (short)n;
    }

    public short mathSpeedUp(int n, int n2, int n3) {
        if ((n -= (n2 - n) / n3) < 0) {
            n = 0;
        }
        return (short)n;
    }

    public void putInt(int n, byte[] byArray, int n2) {
        byArray[n2] = (byte)(n >> 24 & 0xFF);
        byArray[n2 + 1] = (byte)(n >> 16 & 0xFF);
        byArray[n2 + 2] = (byte)(n >> 8 & 0xFF);
        byArray[n2 + 3] = (byte)(n & 0xFF);
    }

    public void putShort(int n, byte[] byArray, int n2) {
        byArray[n2] = (byte)(n >> 8 & 0xFF);
        byArray[n2 + 1] = (byte)(n & 0xFF);
    }

    public void putShort(byte[] byArray, int n) {
        int n2 = skip;
        skip = n2 + 1;
        byArray[n2] = (byte)(n >> 8 & 0xFF);
        n2 = skip;
        skip = n2 + 1;
        byArray[n2] = (byte)(n >> 0 & 0xFF);
    }

    /*
     * Unable to fully structure code
     */
    public short[][] readEventNowData() {
        var3_1 = null;
        var3_1 = new ByteArrayInputStream(this.rmsOptions(12, null, 1));
        var4_2 = new short[var3_1.read()][];
        var1_3 = 0;
        block0: while (true) {
            if (var1_3 >= var4_2.length) {
                return var4_2;
            }
            var2_4 = var3_1.read();
            if (var2_4 != 0) break;
            while (true) {
                ++var1_3;
                continue block0;
                break;
            }
            break;
        }
        var4_2[var1_3] = new short[var2_4];
        var2_4 = 0;
        while (true) {
            if (var2_4 >= var4_2[var1_3].length) ** continue;
            var4_2[var1_3][var2_4] = (short)(var3_1.read() | var3_1.read() << 8);
            ++var2_4;
        }
    }

    /*
     * Exception decompiling
     */
    public byte[] rmsOptions(int var1_1, byte[] var2_2, int var3_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.IllegalStateException: Backjump on non jumping statement @NONE, blocks:[] lbl21 : TryStatement: try { 1[TRYBLOCK]
         * 
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
         *     at org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:550)
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

    public void runDelay() {
        if (key_delay > 0) {
            key_delay = (byte)(key_delay - 1);
        }
    }

    /*
     * Enabled force condition propagation
     */
    public byte select(int n, int n2, int n3) {
        if (n3 == 0) {
            return (byte)n;
        }
        int n4 = n--;
        if (Ms.abs(key) % 2 == 1) {
            n4 = n;
            if (n < n2) {
                n = n3;
                return (byte)n;
            }
        }
        n = n4++;
        if (Ms.abs(key) % 2 != 0) return (byte)n;
        n = n4;
        if (n4 <= n3) return (byte)n;
        n = n2;
        return (byte)n;
    }

    /*
     * Unable to fully structure code
     */
    public void selectS(byte[] var1_1, int var2_2, int var3_3, int var4_4) {
        block5: {
            block6: {
                block4: {
                    block3: {
                        if (var3_3 == 0) lbl-1000:
                        // 6 sources

                        {
                            return;
                        }
                        var1_1[0] = this.select(var1_1[0], var2_2, var3_3 - 1);
                        if (var1_1[1] - 1 != var1_1[0]) break block3;
                        var1_1[1] = (byte)(var1_1[1] - 1);
                        ** GOTO lbl-1000
                    }
                    if (var1_1[1] + var4_4 != var1_1[0]) break block4;
                    var1_1[1] = (byte)(var1_1[1] + 1);
                    ** GOTO lbl-1000
                }
                if (var1_1[0] != var3_3 - 1) break block5;
                if (var3_3 - var2_2 >= var4_4) break block6;
lbl15:
                // 2 sources

                while (true) {
                    var1_1[1] = (byte)var2_2;
                    ** GOTO lbl-1000
                    break;
                }
            }
            var2_2 = var3_3 - var4_4;
            ** while (true)
        }
        if (var1_1[0] != var2_2) ** GOTO lbl-1000
        var1_1[1] = (byte)var2_2;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void setRmsInit(boolean var1_1) throws Exception {
        block5: {
            block3: {
                block4: {
                    var4_2 = new byte[140];
                    var4_2[0] = -1;
                    var3_3 = new byte[280];
                    var2_4 = 0;
                    block0: while (true) {
                        if (var2_4 >= 83) {
                            var3_3 = null;
                            return;
                        }
                        if (var1_1 || var2_4 != 4) break;
lbl10:
                        // 5 sources

                        while (true) {
                            ++var2_4;
                            continue block0;
                            break;
                        }
                        break;
                    }
                    if (var2_4 == 12) break block3;
                    if (!var1_1) break block4;
                    Ms.rms.addRecord(var4_2, 0, var4_2.length);
                    ** GOTO lbl10
                }
                Ms.rms.setRecord(var2_4 + 1, var4_2, 0, var4_2.length);
                ** GOTO lbl10
            }
            if (!var1_1) break block5;
            Ms.rms.addRecord(var3_3, 0, var3_3.length);
            ** GOTO lbl10
        }
        Ms.rms.setRecord(var2_4 + 1, var3_3, 0, var3_3.length);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void setSprite(Sprite var1_1, String var2_2, boolean var3_3) {
        var4_4 = this.getStream(String.valueOf(var2_2) + ".data", -1);
        Ms.skip = 0;
        var1_1 /* !! */ .nullIMFA();
        if (var3_3) {
            var1_1 /* !! */ .Set(this.createImage(var2_2), this.create2Array(var4_4), this.create3Array(var4_4), this.create3Array(var4_4));
lbl6:
            // 2 sources

            while (true) {
                var1_1 /* !! */  = (Sprite)((byte[])null);
                return;
            }
        }
        var1_1 /* !! */ .Set(this.createImage(var2_2), this.createShort2Array(var4_4, 2), this.createShort3Array(var4_4, 2), this.createShort3Array(var4_4, 2));
        ** while (true)
    }

    public byte[] shortArrayToByteArray(short[] sArray) {
        skip = 0;
        int n = sArray.length;
        byte[] byArray = new byte[n << 1];
        int n2 = 0;
        while (n2 < n) {
            this.putShort(byArray, sArray[n2]);
            ++n2;
        }
        return byArray;
    }

    public void sleep(int n) {
        this.sleep_time = n;
    }

    /*
     * Enabled force condition propagation
     */
    public int sqrt(int n) {
        int n2;
        int n3;
        if (n <= 0) return 0;
        int n4 = 10000;
        do {
            n2 = n4;
            n4 = n3 = n * 10000 / n2 + n2 >> 1;
        } while (n3 < n2);
        return n2 / 100;
    }
}
