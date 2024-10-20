package com.uc.paymentsdk.commons.codec;

import java.io.ByteArrayOutputStream;
import java.util.Random;

public class Crypter
{
    private static Random random;
    private ByteArrayOutputStream baos;
    private int contextStart;
    private int crypt;
    private boolean header;
    private byte[] key;
    private byte[] out;
    private int padding;
    private byte[] plain;
    private int pos;
    private int preCrypt;
    private byte[] prePlain;
    
    static {
        Crypter.random = new Random();
    }
    
    public Crypter() {
        super();
        this.header = true;
        this.baos = new ByteArrayOutputStream(8);
    }
    
    private byte[] decipher(final byte[] array) {
        return this.decipher(array, 0);
    }
    
    private byte[] decipher(final byte[] array, int i) {
        long unsignedInt = getUnsignedInt(array, i, 4);
        long unsignedInt2 = getUnsignedInt(array, i + 4, 4);
        final long unsignedInt3 = getUnsignedInt(this.key, 0, 4);
        final long unsignedInt4 = getUnsignedInt(this.key, 4, 4);
        final long unsignedInt5 = getUnsignedInt(this.key, 8, 4);
        final long unsignedInt6 = getUnsignedInt(this.key, 12, 4);
        long n = 0xFFFFFFFFE3779B90L & 0xFFFFFFFFL;
        for (i = 16; i > 0; --i) {
            unsignedInt2 = (unsignedInt2 - ((unsignedInt << 4) + unsignedInt5 ^ unsignedInt + n ^ (unsignedInt >>> 5) + unsignedInt6) & 0xFFFFFFFFL);
            unsignedInt = (unsignedInt - ((unsignedInt2 << 4) + unsignedInt3 ^ unsignedInt2 + n ^ (unsignedInt2 >>> 5) + unsignedInt4) & 0xFFFFFFFFL);
            n = (n - (0xFFFFFFFF9E3779B9L & 0xFFFFFFFFL) & 0xFFFFFFFFL);
        }
        this.baos.reset();
        this.writeInt((int)unsignedInt);
        this.writeInt((int)unsignedInt2);
        return this.baos.toByteArray();
    }
    
    private boolean decrypt8Bytes(final byte[] array, final int n, final int n2) {
        this.pos = 0;
        while (this.pos < 8) {
            if (this.contextStart + this.pos >= n2) {
                return true;
            }
            final int pos = this.pos;
            final byte[] prePlain = this.prePlain;
            prePlain[pos] ^= array[this.crypt + n + this.pos];
            ++this.pos;
        }
        this.prePlain = this.decipher(this.prePlain);
        if (this.prePlain == null) {
            return false;
        }
        this.contextStart += 8;
        this.crypt += 8;
        this.pos = 0;
        return true;
    }
    
    private byte[] encipher(final byte[] array) {
        long unsignedInt = getUnsignedInt(array, 0, 4);
        long unsignedInt2 = getUnsignedInt(array, 4, 4);
        final long unsignedInt3 = getUnsignedInt(this.key, 0, 4);
        final long unsignedInt4 = getUnsignedInt(this.key, 4, 4);
        final long unsignedInt5 = getUnsignedInt(this.key, 8, 4);
        final long unsignedInt6 = getUnsignedInt(this.key, 12, 4);
        long n = 0L;
        for (int i = 16; i > 0; --i) {
            n = (n + (0xFFFFFFFF9E3779B9L & 0xFFFFFFFFL) & 0xFFFFFFFFL);
            unsignedInt = (unsignedInt + ((unsignedInt2 << 4) + unsignedInt3 ^ unsignedInt2 + n ^ (unsignedInt2 >>> 5) + unsignedInt4) & 0xFFFFFFFFL);
            unsignedInt2 = (unsignedInt2 + ((unsignedInt << 4) + unsignedInt5 ^ unsignedInt + n ^ (unsignedInt >>> 5) + unsignedInt6) & 0xFFFFFFFFL);
        }
        this.baos.reset();
        this.writeInt((int)unsignedInt);
        this.writeInt((int)unsignedInt2);
        return this.baos.toByteArray();
    }
    
    private void encrypt8Bytes() {
        this.pos = 0;
        while (this.pos < 8) {
            if (this.header) {
                final int pos = this.pos;
                final byte[] plain = this.plain;
                plain[pos] ^= this.prePlain[this.pos];
            }
            else {
                final int pos2 = this.pos;
                final byte[] plain2 = this.plain;
                plain2[pos2] ^= this.out[this.preCrypt + this.pos];
            }
            ++this.pos;
        }
        System.arraycopy(this.encipher(this.plain), 0, this.out, this.crypt, 8);
        this.pos = 0;
        while (this.pos < 8) {
            final int n = this.crypt + this.pos;
            final byte[] out = this.out;
            out[n] ^= this.prePlain[this.pos];
            ++this.pos;
        }
        System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
        this.preCrypt = this.crypt;
        this.crypt += 8;
        this.pos = 0;
        this.header = false;
    }
    
    private static long getUnsignedInt(final byte[] array, int i, int n) {
        long n2 = 0L;
        if (n > 8) {
            n = i + 8;
        }
        else {
            n += i;
        }
        while (i < n) {
            n2 = (n2 << 8 | (long)(array[i] & 0xFF));
            ++i;
        }
        return (-1L & n2) | n2 >>> 32;
    }
    
    private int rand() {
        return Crypter.random.nextInt();
    }
    
    private void writeInt(final int b) {
        this.baos.write(b >>> 24);
        this.baos.write(b >>> 16);
        this.baos.write(b >>> 8);
        this.baos.write(b);
    }
    
    public byte[] decrypt(byte[] out, final int n, final int n2, byte[] key) {
        if (key == null) {
            out = null;
        }
        else {
            this.preCrypt = 0;
            this.crypt = 0;
            this.key = key;
            key = new byte[n + 8];
            if (n2 % 8 != 0 || n2 < 16) {
                out = null;
            }
            else {
                this.prePlain = this.decipher(out, n);
                this.pos = (this.prePlain[0] & 0x7);
                int i = n2 - this.pos - 10;
                if (i < 0) {
                    out = null;
                }
                else {
                    for (int j = n; j < key.length; ++j) {
                        key[j] = 0;
                    }
                    this.out = new byte[i];
                    this.preCrypt = 0;
                    this.crypt = 8;
                    this.contextStart = 8;
                    ++this.pos;
                    this.padding = 1;
                    while (this.padding <= 2) {
                        if (this.pos < 8) {
                            ++this.pos;
                            ++this.padding;
                        }
                        if (this.pos == 8) {
                            key = out;
                            if (!this.decrypt8Bytes(out, n, n2)) {
                                out = null;
                                return out;
                            }
                            continue;
                        }
                    }
                    int n3 = 0;
                    while (i != 0) {
                        int n4 = i;
                        int n5 = n3;
                        if (this.pos < 8) {
                            this.out[n3] = (byte)(key[this.preCrypt + n + this.pos] ^ this.prePlain[this.pos]);
                            n5 = n3 + 1;
                            n4 = i - 1;
                            ++this.pos;
                        }
                        i = n4;
                        n3 = n5;
                        if (this.pos == 8) {
                            key = out;
                            this.preCrypt = this.crypt - 8;
                            i = n4;
                            n3 = n5;
                            if (!this.decrypt8Bytes(out, n, n2)) {
                                out = null;
                                return out;
                            }
                            continue;
                        }
                    }
                    this.padding = 1;
                    while (this.padding < 8) {
                        if (this.pos < 8) {
                            if ((key[this.preCrypt + n + this.pos] ^ this.prePlain[this.pos]) != 0x0) {
                                out = null;
                                return out;
                            }
                            ++this.pos;
                        }
                        if (this.pos == 8) {
                            key = out;
                            this.preCrypt = this.crypt;
                            if (!this.decrypt8Bytes(out, n, n2)) {
                                out = null;
                                return out;
                            }
                        }
                        ++this.padding;
                    }
                    out = this.out;
                }
            }
        }
        return out;
    }
    
    public byte[] decrypt(final byte[] array, final byte[] array2) {
        return this.decrypt(array, 0, array.length, array2);
    }
    
    public byte[] encrypt(byte[] array, int n, int i, byte[] key) {
        if (key != null) {
            this.plain = new byte[8];
            this.prePlain = new byte[8];
            this.pos = 1;
            this.padding = 0;
            this.preCrypt = 0;
            this.crypt = 0;
            this.key = key;
            this.header = true;
            this.pos = (i + 10) % 8;
            if (this.pos != 0) {
                this.pos = 8 - this.pos;
            }
            this.out = new byte[this.pos + i + 10];
            this.plain[0] = (byte)((this.rand() & 0xF8) | this.pos);
            for (int j = 1; j <= this.pos; ++j) {
                this.plain[j] = (byte)(this.rand() & 0xFF);
            }
            ++this.pos;
            for (int k = 0; k < 8; ++k) {
                this.prePlain[k] = 0;
            }
            this.padding = 1;
            while (this.padding <= 2) {
                if (this.pos < 8) {
                    key = this.plain;
                    key[this.pos++] = (byte)(this.rand() & 0xFF);
                    ++this.padding;
                }
                if (this.pos == 8) {
                    this.encrypt8Bytes();
                }
            }
            while (i > 0) {
                if (this.pos < 8) {
                    key = this.plain;
                    final int n2 = this.pos++;
                    final int n3 = n + 1;
                    key[n2] = array[n];
                    --i;
                    n = n3;
                }
                if (this.pos != 8) {
                    continue;
                }
                this.encrypt8Bytes();
            }
            this.padding = 1;
            while (this.padding <= 7) {
                if (this.pos < 8) {
                    array = this.plain;
                    n = this.pos++;
                    array[n] = 0;
                    ++this.padding;
                }
                if (this.pos == 8) {
                    this.encrypt8Bytes();
                }
            }
            array = this.out;
        }
        return array;
    }
    
    public byte[] encrypt(final byte[] array, final byte[] array2) {
        return this.encrypt(array, 0, array.length, array2);
    }
}
