package com.uc.paymentsdk.commons.codec;

import java.io.ByteArrayOutputStream;
import java.util.Random;

public class Crypter {
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
    private static Random random;

    static {
        Crypter.random = new Random();
    }

    public Crypter() {
        this.header = true;
        this.baos = new ByteArrayOutputStream(8);
    }

    private byte[] decipher(byte[] paramArrayOfByte) {
        long v = Crypter.getUnsignedInt(paramArrayOfByte, 0, 4);
        long v1 = Crypter.getUnsignedInt(paramArrayOfByte, 4, 4);
        long v2 = Crypter.getUnsignedInt(this.key, 0, 4);
        long v3 = Crypter.getUnsignedInt(this.key, 4, 4);
        long v4 = Crypter.getUnsignedInt(this.key, 8, 4);
        long v5 = Crypter.getUnsignedInt(this.key, 12, 4);
        long v6 = 0xE3779B90L;
        for(int v7 = 16; v7 > 0; --v7) {
            v1 = v1 - ((v << 4) + v4 ^ v + v6 ^ (v >>> 5) + v5) & 0xFFFFFFFFL;
            v = v - ((v1 << 4) + v2 ^ v1 + v6 ^ (v1 >>> 5) + v3) & 0xFFFFFFFFL;
            v6 = v6 - 0x9E3779B9L & 0xFFFFFFFFL;
        }
        this.baos.reset();
        this.writeInt(((int)v));
        this.writeInt(((int)v1));
        return this.baos.toByteArray();
    }

    private byte[] decipher(byte[] paramArrayOfByte, int paramInt) [...] // Inlined contents

    public byte[] decrypt(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2) {
        if(paramArrayOfByte2 == null) {
            return null;
        }
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = paramArrayOfByte2;
        byte[] arrayOfByte = new byte[paramInt1 + 8];
        if(paramInt2 % 8 != 0 || paramInt2 < 16) {
            return null;
        }
        this.prePlain = this.decipher(paramArrayOfByte1, paramInt1);
        this.pos = this.prePlain[0] & 7;
        int i = paramInt2 - this.pos - 10;
        if(i < 0) {
            return null;
        }
        for(int j = paramInt1; j < arrayOfByte.length; ++j) {
            arrayOfByte[j] = 0;
        }
        this.out = new byte[i];
        this.preCrypt = 0;
        this.crypt = 8;
        this.contextStart = 8;
        ++this.pos;
        this.padding = 1;
        while(true) {
            if(this.padding > 2) {
                int j = 0;
                while(true) {
                    if(i == 0) {
                        this.padding = 1;
                        while(true) {
                            if(this.padding >= 8) {
                                return this.out;
                            }
                            if(this.pos < 8) {
                                if((arrayOfByte[this.preCrypt + paramInt1 + this.pos] ^ this.prePlain[this.pos]) != 0) {
                                    return null;
                                }
                                ++this.pos;
                            }
                            if(this.pos == 8) {
                                arrayOfByte = paramArrayOfByte1;
                                this.preCrypt = this.crypt;
                                if(!this.decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
                                    return null;
                                }
                            }
                            ++this.padding;
                        }
                    }
                    if(this.pos < 8) {
                        this.out[j] = (byte)(arrayOfByte[this.preCrypt + paramInt1 + this.pos] ^ this.prePlain[this.pos]);
                        ++j;
                        --i;
                        ++this.pos;
                    }
                    if(this.pos == 8) {
                        arrayOfByte = paramArrayOfByte1;
                        this.preCrypt = this.crypt - 8;
                        if(!this.decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
                            break;
                        }
                    }
                }
                return null;
            }
            if(this.pos < 8) {
                ++this.pos;
                ++this.padding;
            }
            if(this.pos == 8) {
                arrayOfByte = paramArrayOfByte1;
                if(!this.decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
                    break;
                }
            }
        }
        return null;
    }

    public byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
        return this.decrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
    }

    private boolean decrypt8Bytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        this.pos = 0;
        while(true) {
            if(this.pos >= 8) {
                this.prePlain = this.decipher(this.prePlain);
                if(this.prePlain == null) {
                    return false;
                }
                this.contextStart += 8;
                this.crypt += 8;
                this.pos = 0;
                return true;
            }
            if(this.contextStart + this.pos >= paramInt2) {
                return true;
            }
            this.prePlain[this.pos] = (byte)(this.prePlain[this.pos] ^ paramArrayOfByte[this.crypt + paramInt1 + this.pos]);
            ++this.pos;
        }
    }

    private byte[] encipher(byte[] paramArrayOfByte) {
        long l1 = Crypter.getUnsignedInt(paramArrayOfByte, 0, 4);
        long l2 = Crypter.getUnsignedInt(paramArrayOfByte, 4, 4);
        long v2 = Crypter.getUnsignedInt(this.key, 0, 4);
        long v3 = Crypter.getUnsignedInt(this.key, 4, 4);
        long v4 = Crypter.getUnsignedInt(this.key, 8, 4);
        long v5 = Crypter.getUnsignedInt(this.key, 12, 4);
        long l7 = 0L;
        for(int i = 16; i > 0; --i) {
            l7 = l7 + 0x9E3779B9L & 0xFFFFFFFFL;
            l1 = l1 + ((l2 << 4) + v2 ^ l2 + l7 ^ (l2 >>> 5) + v3) & 0xFFFFFFFFL;
            l2 = l2 + ((l1 << 4) + v4 ^ l1 + l7 ^ (l1 >>> 5) + v5) & 0xFFFFFFFFL;
        }
        this.baos.reset();
        this.writeInt(((int)l1));
        this.writeInt(((int)l2));
        return this.baos.toByteArray();
    }

    public byte[] encrypt(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2) {
        int i;
        if(paramArrayOfByte2 == null) {
            return paramArrayOfByte1;
        }
        this.plain = new byte[8];
        this.prePlain = new byte[8];
        this.pos = 1;
        this.padding = 0;
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = paramArrayOfByte2;
        this.header = true;
        this.pos = (paramInt2 + 10) % 8;
        if(this.pos != 0) {
            this.pos = 8 - this.pos;
        }
        this.out = new byte[this.pos + paramInt2 + 10];
        byte[] arr_b2 = this.plain;
        arr_b2[0] = (byte)(this.rand() & 0xF8 | this.pos);
        for(int i = 1; i <= this.pos; ++i) {
            byte[] arr_b3 = this.plain;
            arr_b3[i] = (byte)(this.rand() & 0xFF);
        }
        ++this.pos;
        for(int i = 0; i < 8; ++i) {
            this.prePlain[i] = 0;
        }
        this.padding = 1;
        while(this.padding <= 2) {
            if(this.pos < 8) {
                byte[] arr_b4 = this.plain;
                int v4 = this.pos;
                this.pos = v4 + 1;
                arr_b4[v4] = (byte)(this.rand() & 0xFF);
                ++this.padding;
            }
            if(this.pos == 8) {
                this.encrypt8Bytes();
            }
        }
        for(int i = paramInt1; paramInt2 > 0; i = i) {
            if(this.pos < 8) {
                int v6 = this.pos;
                this.pos = v6 + 1;
                i = i + 1;
                this.plain[v6] = paramArrayOfByte1[i];
                --paramInt2;
            }
            else {
                i = i;
            }
            if(this.pos == 8) {
                this.encrypt8Bytes();
            }
        }
        this.padding = 1;
        while(this.padding <= 7) {
            if(this.pos < 8) {
                int v8 = this.pos;
                this.pos = v8 + 1;
                this.plain[v8] = 0;
                ++this.padding;
            }
            if(this.pos == 8) {
                this.encrypt8Bytes();
            }
        }
        return this.out;
    }

    public byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
        return this.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
    }

    private void encrypt8Bytes() {
        this.pos = 0;
        while(this.pos < 8) {
            this.plain[this.pos] = this.header ? ((byte)(this.plain[this.pos] ^ this.prePlain[this.pos])) : ((byte)(this.plain[this.pos] ^ this.out[this.preCrypt + this.pos]));
            ++this.pos;
        }
        System.arraycopy(this.encipher(this.plain), 0, this.out, this.crypt, 8);
        this.pos = 0;
        while(this.pos < 8) {
            int tmp137_136 = this.crypt + this.pos;
            this.out[tmp137_136] = (byte)(this.out[tmp137_136] ^ this.prePlain[this.pos]);
            ++this.pos;
        }
        System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
        this.preCrypt = this.crypt;
        this.crypt += 8;
        this.pos = 0;
        this.header = false;
    }

    private static long getUnsignedInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        long l = 0L;
        for(int j = paramInt1; j < (paramInt2 <= 8 ? paramInt1 + paramInt2 : paramInt1 + 8); ++j) {
            l = l << 8 | ((long)(paramArrayOfByte[j] & 0xFF));
        }
        return l | l >>> 0x20;
    }

    private int rand() {
        return Crypter.random.nextInt();
    }

    private void writeInt(int paramInt) {
        this.baos.write(paramInt >>> 24);
        this.baos.write(paramInt >>> 16);
        this.baos.write(paramInt >>> 8);
        this.baos.write(paramInt);
    }
}

