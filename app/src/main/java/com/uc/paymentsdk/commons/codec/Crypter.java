/*
 * Decompiled with CFR.
 */
package com.uc.paymentsdk.commons.codec;

import java.io.ByteArrayOutputStream;
import java.util.Random;

public class Crypter {
    private static Random random = new Random();
    private ByteArrayOutputStream baos = new ByteArrayOutputStream(8);
    private int contextStart;
    private int crypt;
    private boolean header = true;
    private byte[] key;
    private byte[] out;
    private int padding;
    private byte[] plain;
    private int pos;
    private int preCrypt;
    private byte[] prePlain;

    private byte[] decipher(byte[] byArray) {
        return this.decipher(byArray, 0);
    }

    private byte[] decipher(byte[] byArray, int n) {
        long l = Crypter.getUnsignedInt(byArray, n, 4);
        long l2 = Crypter.getUnsignedInt(byArray, n + 4, 4);
        long l3 = Crypter.getUnsignedInt(this.key, 0, 4);
        long l4 = Crypter.getUnsignedInt(this.key, 4, 4);
        long l5 = Crypter.getUnsignedInt(this.key, 8, 4);
        long l6 = Crypter.getUnsignedInt(this.key, 12, 4);
        long l7 = 0xFFFFFFFFE3779B90L & 0xFFFFFFFFL;
        n = 16;
        while (true) {
            if (n <= 0) {
                this.baos.reset();
                this.writeInt((int)l);
                this.writeInt((int)l2);
                return this.baos.toByteArray();
            }
            l2 = l2 - ((l << 4) + l5 ^ l + l7 ^ (l >>> 5) + l6) & 0xFFFFFFFFL;
            l = l - ((l2 << 4) + l3 ^ l2 + l7 ^ (l2 >>> 5) + l4) & 0xFFFFFFFFL;
            l7 = l7 - (0xFFFFFFFF9E3779B9L & 0xFFFFFFFFL) & 0xFFFFFFFFL;
            --n;
        }
    }

    /*
     * Enabled force condition propagation
     */
    private boolean decrypt8Bytes(byte[] byArray, int n, int n2) {
        this.pos = 0;
        while (true) {
            if (this.pos >= 8) {
                this.prePlain = this.decipher(this.prePlain);
                if (this.prePlain != null) break;
                return false;
            }
            if (this.contextStart + this.pos >= n2) {
                return true;
            }
            int n3 = this.pos;
            byte[] byArray2 = this.prePlain;
            byArray2[n3] = (byte)(byArray2[n3] ^ byArray[this.crypt + n + this.pos]);
            ++this.pos;
        }
        this.contextStart += 8;
        this.crypt += 8;
        this.pos = 0;
        return true;
    }

    private byte[] encipher(byte[] byArray) {
        long l = Crypter.getUnsignedInt(byArray, 0, 4);
        long l2 = Crypter.getUnsignedInt(byArray, 4, 4);
        long l3 = Crypter.getUnsignedInt(this.key, 0, 4);
        long l4 = Crypter.getUnsignedInt(this.key, 4, 4);
        long l5 = Crypter.getUnsignedInt(this.key, 8, 4);
        long l6 = Crypter.getUnsignedInt(this.key, 12, 4);
        long l7 = 0L;
        int n = 16;
        while (true) {
            if (n <= 0) {
                this.baos.reset();
                this.writeInt((int)l);
                this.writeInt((int)l2);
                return this.baos.toByteArray();
            }
            l7 = l7 + (0xFFFFFFFF9E3779B9L & 0xFFFFFFFFL) & 0xFFFFFFFFL;
            l = l + ((l2 << 4) + l3 ^ l2 + l7 ^ (l2 >>> 5) + l4) & 0xFFFFFFFFL;
            l2 = l2 + ((l << 4) + l5 ^ l + l7 ^ (l >>> 5) + l6) & 0xFFFFFFFFL;
            --n;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void encrypt8Bytes() {
        block5: {
            this.pos = 0;
            block0: while (true) {
                if (this.pos >= 8) {
                    System.arraycopy(this.encipher(this.plain), 0, this.out, this.crypt, 8);
                    this.pos = 0;
lbl6:
                    // 2 sources

                    while (true) {
                        if (this.pos >= 8) {
                            System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
                            this.preCrypt = this.crypt;
                            this.crypt += 8;
                            this.pos = 0;
                            this.header = false;
                            return;
                        }
                        break block5;
                        break;
                    }
                }
                if (!this.header) break;
                var1_1 = this.pos;
                var2_2 = this.plain;
                var2_2[var1_1] = (byte)(var2_2[var1_1] ^ this.prePlain[this.pos]);
lbl19:
                // 2 sources

                while (true) {
                    ++this.pos;
                    continue block0;
                    break;
                }
                break;
            }
            var1_1 = this.pos;
            var2_2 = this.plain;
            var2_2[var1_1] = (byte)(var2_2[var1_1] ^ this.out[this.preCrypt + this.pos]);
            ** while (true)
        }
        var1_1 = this.crypt + this.pos;
        var2_2 = this.out;
        var2_2[var1_1] = (byte)(var2_2[var1_1] ^ this.prePlain[this.pos]);
        ++this.pos;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private static long getUnsignedInt(byte[] var0, int var1_1, int var2_2) {
        block3: {
            var3_3 = 0L;
            if (var2_2 > 8) {
                var2_2 = var1_1 + 8;
lbl4:
                // 3 sources

                while (true) {
                    if (var1_1 >= var2_2) {
                        return -1L & var3_3 | var3_3 >>> 32;
                    }
                    break block3;
                    break;
                }
            }
            var2_2 = var1_1 + var2_2;
            ** GOTO lbl4
        }
        var3_3 = var3_3 << 8 | (long)(var0[var1_1] & 255);
        ++var1_1;
        ** while (true)
    }

    private int rand() {
        return random.nextInt();
    }

    private void writeInt(int n) {
        this.baos.write(n >>> 24);
        this.baos.write(n >>> 16);
        this.baos.write(n >>> 8);
        this.baos.write(n);
    }

    /*
     * Unable to fully structure code
     */
    public byte[] decrypt(byte[] var1_1, int var2_2, int var3_3, byte[] var4_4) {
        block15: {
            block16: {
                block11: {
                    block10: {
                        block13: {
                            block12: {
                                if (var4_4 == null) {
                                    var1_1 = null;
lbl3:
                                    // 8 sources

                                    return var1_1;
                                }
                                this.preCrypt = 0;
                                this.crypt = 0;
                                this.key = var4_4;
                                var4_4 = new byte[var2_2 + 8];
                                if (var3_3 % 8 == 0 && var3_3 >= 16) break block12;
                                var1_1 = null;
                                ** GOTO lbl3
                            }
                            this.prePlain = this.decipher(var1_1, var2_2);
                            this.pos = this.prePlain[0] & 7;
                            var6_5 = var3_3 - this.pos - 10;
                            if (var6_5 >= 0) break block13;
                            var1_1 = null;
                            ** GOTO lbl3
                        }
                        var5_6 = var2_2;
                        block1: while (true) {
                            block14: {
                                if (var5_6 < var4_4.length) break block14;
                                this.out = new byte[var6_5];
                                this.preCrypt = 0;
                                this.crypt = 8;
                                this.contextStart = 8;
                                ++this.pos;
                                this.padding = 1;
lbl29:
                                // 3 sources

                                while (true) {
                                    if (this.padding <= 2) break block1;
                                    var7_7 = 0;
lbl32:
                                    // 3 sources

                                    while (true) {
                                        if (var6_5 != 0) break block10;
                                        this.padding = 1;
lbl35:
                                        // 2 sources

                                        while (true) {
                                            if (this.padding < 8) break block11;
                                            var1_1 = this.out;
                                            ** GOTO lbl3
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                            }
                            var4_4[var5_6] = 0;
                            ++var5_6;
                        }
                        if (this.pos < 8) {
                            ++this.pos;
                            ++this.padding;
                        }
                        if (this.pos != 8) ** GOTO lbl29
                        var4_4 = var1_1;
                        if (!this.decrypt8Bytes(var1_1, var2_2, var3_3)) ** break;
                        ** while (true)
                        var1_1 = null;
                        ** GOTO lbl3
                    }
                    var8_8 = var6_5;
                    var5_6 = var7_7;
                    if (this.pos < 8) {
                        this.out[var7_7] = (byte)(var4_4[this.preCrypt + var2_2 + this.pos] ^ this.prePlain[this.pos]);
                        var5_6 = var7_7 + 1;
                        var8_8 = var6_5 - 1;
                        ++this.pos;
                    }
                    var6_5 = var8_8;
                    var7_7 = var5_6;
                    if (this.pos != 8) ** GOTO lbl32
                    var4_4 = var1_1;
                    this.preCrypt = this.crypt - 8;
                    var6_5 = var8_8;
                    var7_7 = var5_6;
                    if (!this.decrypt8Bytes(var1_1, var2_2, var3_3)) ** break;
                    ** while (true)
                    var1_1 = null;
                    ** GOTO lbl3
                }
                if (this.pos >= 8) break block15;
                if ((var4_4[this.preCrypt + var2_2 + this.pos] ^ this.prePlain[this.pos]) == 0) break block16;
                var1_1 = null;
                ** GOTO lbl3
            }
            ++this.pos;
        }
        if (this.pos == 8) {
            var4_4 = var1_1;
            this.preCrypt = this.crypt;
            if (!this.decrypt8Bytes(var1_1, var2_2, var3_3)) {
                var1_1 = null;
                ** continue;
            }
        }
        ++this.padding;
        ** while (true)
    }

    public byte[] decrypt(byte[] byArray, byte[] byArray2) {
        return this.decrypt(byArray, 0, byArray.length, byArray2);
    }

    /*
     * Unable to fully structure code
     */
    public byte[] encrypt(byte[] var1_1, int var2_2, int var3_3, byte[] var4_4) {
        block15: {
            block14: {
                block13: {
                    if (var4_4 == null) lbl-1000:
                    // 2 sources

                    {
                        return var1_1;
                    }
                    this.plain = new byte[8];
                    this.prePlain = new byte[8];
                    this.pos = 1;
                    this.padding = 0;
                    this.preCrypt = 0;
                    this.crypt = 0;
                    this.key = var4_4;
                    this.header = true;
                    this.pos = (var3_3 + 10) % 8;
                    if (this.pos != 0) {
                        this.pos = 8 - this.pos;
                    }
                    this.out = new byte[this.pos + var3_3 + 10];
                    this.plain[0] = (byte)(this.rand() & 248 | this.pos);
                    var5_5 = 1;
                    block1: while (true) {
                        if (var5_5 > this.pos) {
                            ++this.pos;
                            var5_5 = 0;
lbl22:
                            // 2 sources

                            while (true) {
                                if (var5_5 < 8) break block1;
                                this.padding = 1;
lbl25:
                                // 3 sources

                                while (true) {
                                    if (this.padding <= 2) break block13;
lbl27:
                                    // 3 sources

                                    while (true) {
                                        if (var3_3 > 0) break block14;
                                        this.padding = 1;
lbl30:
                                        // 3 sources

                                        while (true) {
                                            if (this.padding > 7) {
                                                var1_1 = this.out;
                                                ** continue;
                                            }
                                            break block15;
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        this.plain[var5_5] = (byte)(this.rand() & 255);
                        ++var5_5;
                    }
                    this.prePlain[var5_5] = 0;
                    ++var5_5;
                    ** while (true)
                }
                if (this.pos < 8) {
                    var4_4 = this.plain;
                    var5_5 = this.pos;
                    this.pos = var5_5 + 1;
                    var4_4[var5_5] = (byte)(this.rand() & 255);
                    ++this.padding;
                }
                if (this.pos != 8) ** GOTO lbl25
                this.encrypt8Bytes();
                ** while (true)
            }
            if (this.pos < 8) {
                var4_4 = this.plain;
                var6_6 = this.pos;
                this.pos = var6_6 + 1;
                var5_5 = var2_2 + 1;
                var4_4[var6_6] = var1_1[var2_2];
                --var3_3;
                var2_2 = var5_5;
            }
            if (this.pos != 8) ** GOTO lbl27
            this.encrypt8Bytes();
            ** while (true)
        }
        if (this.pos < 8) {
            var1_1 = this.plain;
            var2_2 = this.pos;
            this.pos = var2_2 + 1;
            var1_1[var2_2] = 0;
            ++this.padding;
        }
        if (this.pos != 8) ** GOTO lbl30
        this.encrypt8Bytes();
        ** while (true)
    }

    public byte[] encrypt(byte[] byArray, byte[] byArray2) {
        return this.encrypt(byArray, 0, byArray.length, byArray2);
    }
}
