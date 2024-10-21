/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.commons.codec.BinaryDecoder
 *  com.uc.paymentsdk.commons.codec.BinaryEncoder
 *  com.uc.paymentsdk.commons.codec.DecoderException
 *  com.uc.paymentsdk.commons.codec.EncoderException
 */
package com.uc.paymentsdk.commons.codec;

import com.uc.paymentsdk.commons.codec.BinaryDecoder;
import com.uc.paymentsdk.commons.codec.BinaryEncoder;
import com.uc.paymentsdk.commons.codec.DecoderException;
import com.uc.paymentsdk.commons.codec.EncoderException;

public class Base64
implements BinaryEncoder,
BinaryDecoder {
    static final int BASELENGTH = 255;
    static final byte[] CHUNK_SEPARATOR;
    static final int CHUNK_SIZE = 76;
    static final int EIGHTBIT = 8;
    static final int FOURBYTE = 4;
    static final int LOOKUPLENGTH = 64;
    static final byte PAD = 61;
    static final int SIGN = -128;
    static final int SIXTEENBIT = 16;
    static final int TWENTYFOURBITGROUP = 24;
    private static byte[] base64Alphabet;
    private static byte[] lookUpBase64Alphabet;

    /*
     * Unable to fully structure code
     */
    static {
        block13: {
            block12: {
                block11: {
                    block10: {
                        block9: {
                            Base64.CHUNK_SEPARATOR = "\r\n".getBytes();
                            Base64.base64Alphabet = new byte[255];
                            Base64.lookUpBase64Alphabet = new byte[64];
                            var0 = 0;
                            block0: while (true) {
                                if (var0 >= 255) {
                                    var0 = 90;
lbl8:
                                    // 2 sources

                                    while (true) {
                                        if (var0 >= 65) break block0;
                                        var0 = 122;
lbl11:
                                        // 2 sources

                                        while (true) {
                                            if (var0 >= 97) break block9;
                                            var0 = 57;
lbl14:
                                            // 2 sources

                                            while (true) {
                                                if (var0 >= 48) break block10;
                                                Base64.base64Alphabet[43] = 62;
                                                Base64.base64Alphabet[47] = 63;
                                                var0 = 0;
lbl19:
                                                // 2 sources

                                                while (true) {
                                                    if (var0 <= 25) break block11;
                                                    var1_1 = 26;
                                                    var0 = 0;
lbl23:
                                                    // 2 sources

                                                    while (true) {
                                                        if (var1_1 <= 51) break block12;
                                                        var1_1 = 52;
                                                        var0 = 0;
lbl27:
                                                        // 2 sources

                                                        while (true) {
                                                            if (var1_1 > 61) {
                                                                Base64.lookUpBase64Alphabet[62] = 43;
                                                                Base64.lookUpBase64Alphabet[63] = 47;
                                                                return;
                                                            }
                                                            break block13;
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                    break;
                                                }
                                                break;
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                }
                                Base64.base64Alphabet[var0] = -1;
                                ++var0;
                            }
                            Base64.base64Alphabet[var0] = (byte)(var0 - 65);
                            --var0;
                            ** while (true)
                        }
                        Base64.base64Alphabet[var0] = (byte)(var0 - 97 + 26);
                        --var0;
                        ** while (true)
                    }
                    Base64.base64Alphabet[var0] = (byte)(var0 - 48 + 52);
                    --var0;
                    ** while (true)
                }
                Base64.lookUpBase64Alphabet[var0] = (byte)(var0 + 65);
                ++var0;
                ** while (true)
            }
            Base64.lookUpBase64Alphabet[var1_1] = (byte)(var0 + 97);
            ++var1_1;
            ++var0;
            ** while (true)
        }
        Base64.lookUpBase64Alphabet[var1_1] = (byte)(var0 + 48);
        ++var1_1;
        ++var0;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public static byte[] decodeBase64(byte[] var0) {
        block8: {
            block6: {
                var8_1 = Base64.discardNonBase64(var0);
                if (var8_1.length == 0) {
                    var0 = new byte[]{};
lbl4:
                    // 3 sources

                    return var0;
                }
                var4_2 = var8_1.length / 4;
                var0 = null;
                var2_3 = 0;
                var1_4 = var8_1.length;
                do {
                    block7: {
                        if (var8_1[var1_4 - 1] == 61) break block7;
                        var0 = new byte[var1_4 - var4_2];
                        var1_4 = 0;
lbl14:
                        // 2 sources

                        while (true) {
                            if (var1_4 < var4_2) break block6;
                            ** GOTO lbl4
                            break;
                        }
                    }
                    var1_4 = var3_5 = var1_4 - 1;
                } while (var3_5 != 0);
                var0 = new byte[]{};
                ** while (true)
            }
            var5_6 = var1_4 * 4;
            var7_8 = var8_1[var5_6 + 2];
            var6_7 = var8_1[var5_6 + 3];
            var3_5 = Base64.base64Alphabet[var8_1[var5_6]];
            var5_6 = Base64.base64Alphabet[var8_1[var5_6 + 1]];
            if (var7_8 != 61 && var6_7 != 61) {
                var7_8 = Base64.base64Alphabet[var7_8];
                var6_7 = Base64.base64Alphabet[var6_7];
                var0[var2_3] = (byte)(var3_5 << 2 | var5_6 >> 4);
                var0[var2_3 + 1] = (byte)((var5_6 & 15) << 4 | var7_8 >> 2 & 15);
                var0[var2_3 + 2] = (byte)(var7_8 << 6 | var6_7);
lbl34:
                // 4 sources

                while (true) {
                    var2_3 += 3;
                    ++var1_4;
                    ** continue;
                    break;
                }
            }
            if (var7_8 != 61) break block8;
            var0[var2_3] = (byte)(var3_5 << 2 | var5_6 >> 4);
            ** GOTO lbl34
        }
        if (var6_7 != 61) ** GOTO lbl34
        var6_7 = Base64.base64Alphabet[var7_8];
        var0[var2_3] = (byte)(var3_5 << 2 | var5_6 >> 4);
        var0[var2_3 + 1] = (byte)((var5_6 & 15) << 4 | var6_7 >> 2 & 15);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    static byte[] discardNonBase64(byte[] var0) {
        var3_1 = new byte[var0.length];
        var2_2 = 0;
        var1_3 = 0;
        block0: while (true) {
            if (var1_3 >= var0.length) {
                var0 = new byte[var2_2];
                System.arraycopy(var3_1, 0, var0, 0, var2_2);
                return var0;
            }
            if (Base64.isBase64(var0[var1_3])) break;
lbl10:
            // 2 sources

            while (true) {
                ++var1_3;
                continue block0;
                break;
            }
            break;
        }
        var3_1[var2_2] = var0[var1_3];
        ++var2_2;
        ** while (true)
    }

    static byte[] discardWhitespace(byte[] byArray) {
        byte[] byArray2 = new byte[byArray.length];
        int n = 0;
        int n2 = 0;
        while (true) {
            if (n2 >= byArray.length) {
                byArray = new byte[n];
                System.arraycopy(byArray2, 0, byArray, 0, n);
                return byArray;
            }
            int n3 = n;
            switch (byArray[n2]) {
                default: {
                    byArray2[n] = byArray[n2];
                    n3 = n + 1;
                }
                case 9: 
                case 10: 
                case 13: 
                case 32: 
            }
            ++n2;
            n = n3;
        }
    }

    public static byte[] encodeBase64(byte[] byArray) {
        return Base64.encodeBase64(byArray, false);
    }

    /*
     * Unable to fully structure code
     */
    public static byte[] encodeBase64(byte[] var0, boolean var1_1) {
        block21: {
            block25: {
                block24: {
                    block16: {
                        block17: {
                            block18: {
                                block19: {
                                    block23: {
                                        block22: {
                                            block15: {
                                                block14: {
                                                    block20: {
                                                        var2_2 = var0.length * 8;
                                                        var16_3 = var2_2 % 24;
                                                        var17_4 = var2_2 / 24;
                                                        var18_5 = null;
                                                        if (var16_3 == 0) break block20;
                                                        var2_2 = (var17_4 + 1) * 4;
lbl7:
                                                        // 2 sources

                                                        while (var1_1) {
                                                            if (Base64.CHUNK_SEPARATOR.length != 0) break block14;
                                                            var3_6 = 0;
lbl10:
                                                            // 2 sources

                                                            while (true) {
                                                                var5_7 = Base64.CHUNK_SEPARATOR.length;
                                                                var4_8 = var3_6;
                                                                var5_7 = var2_2 + var5_7 * var3_6;
lbl14:
                                                                // 2 sources

                                                                while (true) {
                                                                    var18_5 = new byte[var5_7];
                                                                    var10_9 = 0;
                                                                    var9_10 = 0;
                                                                    var11_11 = 0;
                                                                    var8_12 = 0;
                                                                    var6_13 = 0;
                                                                    var2_2 = 76;
                                                                    var7_14 = 0;
                                                                    var3_6 = 0;
                                                                    var8_12 = var11_11;
                                                                    var9_10 = var10_9;
lbl26:
                                                                    // 2 sources

                                                                    while (true) {
                                                                        if (var7_14 < var17_4) break block15;
                                                                        var7_14 *= 3;
                                                                        if (var16_3 != 8) break block16;
                                                                        var2_2 = var0[var7_14];
                                                                        var7_14 = (byte)(var2_2 & 3);
                                                                        if ((var2_2 & -128) == 0) {
                                                                            var2_2 = (byte)(var2_2 >> 2);
lbl34:
                                                                            // 2 sources

                                                                            while (true) {
                                                                                var18_5[var3_6] = Base64.lookUpBase64Alphabet[var2_2];
                                                                                var18_5[var3_6 + 1] = Base64.lookUpBase64Alphabet[var7_14 << 4];
                                                                                var18_5[var3_6 + 2] = 61;
                                                                                var18_5[var3_6 + 3] = 61;
lbl39:
                                                                                // 3 sources

                                                                                while (true) {
                                                                                    if (var1_1 && var6_13 < var4_8) {
                                                                                        System.arraycopy(Base64.CHUNK_SEPARATOR, 0, var18_5, var5_7 - Base64.CHUNK_SEPARATOR.length, Base64.CHUNK_SEPARATOR.length);
                                                                                    }
                                                                                    return var18_5;
                                                                                }
                                                                                break;
                                                                            }
                                                                        }
                                                                        break block17;
                                                                        break;
                                                                    }
                                                                    break;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                        break block21;
                                                    }
                                                    var2_2 = var17_4 * 4;
                                                    ** GOTO lbl7
                                                }
                                                var3_6 = (int)Math.ceil((float)var2_2 / 76.0f);
                                                ** while (true)
                                            }
                                            var8_12 = var7_14 * 3;
                                            var13_16 = var0[var8_12];
                                            var14_17 = var0[var8_12 + 1];
                                            var15_18 = var0[var8_12 + 2];
                                            var12_15 = (byte)(var14_17 & 15);
                                            var11_11 = (byte)(var13_16 & 3);
                                            if ((var13_16 & -128) != 0) break block22;
                                            var8_12 = (byte)(var13_16 >> 2);
lbl60:
                                            // 2 sources

                                            while ((var14_17 & -128) == 0) {
                                                var9_10 = (byte)(var14_17 >> 4);
lbl62:
                                                // 2 sources

                                                while ((var15_18 & -128) == 0) {
                                                    var10_9 = (byte)(var15_18 >> 6);
lbl64:
                                                    // 2 sources

                                                    while (true) {
                                                        var18_5[var3_6] = Base64.lookUpBase64Alphabet[var8_12];
                                                        var18_5[var3_6 + 1] = Base64.lookUpBase64Alphabet[var9_10 | var11_11 << 4];
                                                        var18_5[var3_6 + 2] = Base64.lookUpBase64Alphabet[var10_9 | var12_15 << 2];
                                                        var18_5[var3_6 + 3] = Base64.lookUpBase64Alphabet[var15_18 & 63];
                                                        if (var1_1 && (var3_6 += 4) == var2_2) break block18;
lbl70:
                                                        // 2 sources

                                                        while (true) {
                                                            var15_18 = var7_14 + 1;
                                                            var7_14 = var14_17;
                                                            var8_12 = var13_16;
                                                            var10_9 = var12_15;
                                                            var9_10 = (byte)var11_11;
                                                            var9_10 = var10_9;
                                                            var8_12 = var7_14;
                                                            var7_14 = var15_18;
                                                            ** continue;
                                                            break;
                                                        }
                                                        break;
                                                    }
lbl80:
                                                    // 1 sources

                                                    ** GOTO lbl26
                                                }
                                                break block19;
                                            }
                                            break block23;
                                        }
                                        var8_12 = (byte)(var13_16 >> 2 ^ 192);
                                        ** GOTO lbl60
                                    }
                                    var9_10 = (byte)(var14_17 >> 4 ^ 240);
                                    ** GOTO lbl62
                                }
                                var10_9 = (byte)(var15_18 >> 6 ^ 252);
                                ** while (true)
                            }
                            System.arraycopy(Base64.CHUNK_SEPARATOR, 0, var18_5, var3_6, Base64.CHUNK_SEPARATOR.length);
                            var2_2 = Base64.CHUNK_SEPARATOR.length;
                            var3_6 += Base64.CHUNK_SEPARATOR.length;
                            var2_2 = (++var6_13 + 1) * 76 + var2_2 * var6_13;
                            ** while (true)
                        }
                        var2_2 = (byte)(var2_2 >> 2 ^ 192);
                        ** while (true)
                    }
                    if (var16_3 != 16) ** GOTO lbl39
                    var2_2 = var0[var7_14];
                    var7_14 = var0[var7_14 + 1];
                    var8_12 = (byte)(var7_14 & 15);
                    var9_10 = (byte)(var2_2 & 3);
                    if ((var2_2 & -128) != 0) break block24;
                    var2_2 = (byte)(var2_2 >> 2);
lbl109:
                    // 2 sources

                    while ((var7_14 & -128) == 0) {
                        var7_14 = (byte)(var7_14 >> 4);
lbl111:
                        // 2 sources

                        while (true) {
                            var18_5[var3_6] = Base64.lookUpBase64Alphabet[var2_2];
                            var18_5[var3_6 + 1] = Base64.lookUpBase64Alphabet[var7_14 | var9_10 << 4];
                            var18_5[var3_6 + 2] = Base64.lookUpBase64Alphabet[var8_12 << 2];
                            var18_5[var3_6 + 3] = 61;
                            ** continue;
                            break;
                        }
lbl117:
                        // 1 sources

                        ** GOTO lbl39
                    }
                    break block25;
                }
                var2_2 = (byte)(var2_2 >> 2 ^ 192);
                ** GOTO lbl109
            }
            var7_14 = (byte)(var7_14 >> 4 ^ 240);
            ** while (true)
        }
        var4_8 = 0;
        var5_7 = var2_2;
        ** while (true)
    }

    public static byte[] encodeBase64Chunked(byte[] byArray) {
        return Base64.encodeBase64(byArray, true);
    }

    /*
     * Enabled force condition propagation
     */
    public static boolean isArrayByteBase64(byte[] byArray) {
        int n = (byArray = Base64.discardWhitespace(byArray)).length;
        if (n == 0) {
            return true;
        }
        int n2 = 0;
        while (n2 < n) {
            if (!Base64.isBase64(byArray[n2])) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    private static boolean isBase64(byte by) {
        if (by == 61) {
            return true;
        }
        if (base64Alphabet[by] == -1) return false;
        return true;
    }

    public Object decode(Object object) throws DecoderException {
        if (!(object instanceof byte[])) {
            throw new DecoderException("Parameter supplied to Base64 decode is not a byte[]");
        }
        return this.decode((byte[])object);
    }

    public byte[] decode(byte[] byArray) {
        return Base64.decodeBase64(byArray);
    }

    public Object encode(Object object) throws EncoderException {
        if (!(object instanceof byte[])) {
            throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");
        }
        return this.encode((byte[])object);
    }

    public byte[] encode(byte[] byArray) {
        return Base64.encodeBase64(byArray, false);
    }
}
