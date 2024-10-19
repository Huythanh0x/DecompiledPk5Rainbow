package com.uc.paymentsdk.commons.codec;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* loaded from: classes.dex */
public class Crypter {
    private static Random random = new Random();
    private int contextStart;
    private int crypt;
    private byte[] key;
    private byte[] out;
    private int padding;
    private byte[] plain;
    private int pos;
    private int preCrypt;
    private byte[] prePlain;
    private boolean header = true;
    private ByteArrayOutputStream baos = new ByteArrayOutputStream(8);

    private static long getUnsignedInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        int i;
        long l = 0;
        if (paramInt2 > 8) {
            i = paramInt1 + 8;
        } else {
            i = paramInt1 + paramInt2;
        }
        for (int j = paramInt1; j < i; j++) {
            l = (l << 8) | (paramArrayOfByte[j] & 255);
        }
        return ((-1) & l) | (l >>> 32);
    }

    public byte[] decrypt(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2) {
        if (paramArrayOfByte2 == null) {
            return null;
        }
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = paramArrayOfByte2;
        byte[] arrayOfByte = new byte[paramInt1 + 8];
        if (paramInt2 % 8 != 0 || paramInt2 < 16) {
            return null;
        }
        this.prePlain = decipher(paramArrayOfByte1, paramInt1);
        this.pos = this.prePlain[0] & 7;
        int i = (paramInt2 - this.pos) - 10;
        if (i < 0) {
            return null;
        }
        for (int j = paramInt1; j < arrayOfByte.length; j++) {
            arrayOfByte[j] = 0;
        }
        this.out = new byte[i];
        this.preCrypt = 0;
        this.crypt = 8;
        this.contextStart = 8;
        this.pos++;
        this.padding = 1;
        while (this.padding <= 2) {
            if (this.pos < 8) {
                this.pos++;
                this.padding++;
            }
            if (this.pos == 8) {
                arrayOfByte = paramArrayOfByte1;
                if (!decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
                    return null;
                }
            }
        }
        int j2 = 0;
        while (i != 0) {
            if (this.pos < 8) {
                this.out[j2] = (byte) (arrayOfByte[(this.preCrypt + paramInt1) + this.pos] ^ this.prePlain[this.pos]);
                j2++;
                i--;
                this.pos++;
            }
            if (this.pos == 8) {
                arrayOfByte = paramArrayOfByte1;
                this.preCrypt = this.crypt - 8;
                if (!decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
                    return null;
                }
            }
        }
        this.padding = 1;
        while (this.padding < 8) {
            if (this.pos < 8) {
                if ((arrayOfByte[(this.preCrypt + paramInt1) + this.pos] ^ this.prePlain[this.pos]) != 0) {
                    return null;
                }
                this.pos++;
            }
            if (this.pos == 8) {
                arrayOfByte = paramArrayOfByte1;
                this.preCrypt = this.crypt;
                if (!decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
                    return null;
                }
            }
            this.padding++;
        }
        return this.out;
    }

    public byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
        return decrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
    }

    public byte[] encrypt(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2) {
        int i;
        if (paramArrayOfByte2 == null) {
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
        if (this.pos != 0) {
            this.pos = 8 - this.pos;
        }
        this.out = new byte[this.pos + paramInt2 + 10];
        this.plain[0] = (byte) ((rand() & 248) | this.pos);
        for (int i2 = 1; i2 <= this.pos; i2++) {
            this.plain[i2] = (byte) (rand() & 255);
        }
        this.pos++;
        for (int i3 = 0; i3 < 8; i3++) {
            this.prePlain[i3] = 0;
        }
        this.padding = 1;
        while (this.padding <= 2) {
            if (this.pos < 8) {
                byte[] bArr = this.plain;
                int i4 = this.pos;
                this.pos = i4 + 1;
                bArr[i4] = (byte) (rand() & 255);
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        int i5 = paramInt1;
        while (paramInt2 > 0) {
            if (this.pos < 8) {
                byte[] bArr2 = this.plain;
                int i6 = this.pos;
                this.pos = i6 + 1;
                i = i5 + 1;
                bArr2[i6] = paramArrayOfByte1[i5];
                paramInt2--;
            } else {
                i = i5;
            }
            if (this.pos != 8) {
                i5 = i;
            } else {
                encrypt8Bytes();
                i5 = i;
            }
        }
        this.padding = 1;
        while (this.padding <= 7) {
            if (this.pos < 8) {
                byte[] bArr3 = this.plain;
                int i7 = this.pos;
                this.pos = i7 + 1;
                bArr3[i7] = 0;
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        return this.out;
    }

    public byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
        return encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
    }

    private byte[] encipher(byte[] paramArrayOfByte) {
        int i = 16;
        long l1 = getUnsignedInt(paramArrayOfByte, 0, 4);
        long l2 = getUnsignedInt(paramArrayOfByte, 4, 4);
        long l3 = getUnsignedInt(this.key, 0, 4);
        long l4 = getUnsignedInt(this.key, 4, 4);
        long l5 = getUnsignedInt(this.key, 8, 4);
        long l6 = getUnsignedInt(this.key, 12, 4);
        long l7 = 0;
        long l8 = (-1640531527) & 4294967295L;
        while (true) {
            int i2 = i;
            i = i2 - 1;
            if (i2 > 0) {
                l7 = (l7 + l8) & 4294967295L;
                l1 = (l1 + ((((l2 << 4) + l3) ^ (l2 + l7)) ^ ((l2 >>> 5) + l4))) & 4294967295L;
                l2 = (l2 + ((((l1 << 4) + l5) ^ (l1 + l7)) ^ ((l1 >>> 5) + l6))) & 4294967295L;
            } else {
                this.baos.reset();
                writeInt((int) l1);
                writeInt((int) l2);
                return this.baos.toByteArray();
            }
        }
    }

    private byte[] decipher(byte[] paramArrayOfByte, int paramInt) {
        int i = 16;
        long l1 = getUnsignedInt(paramArrayOfByte, paramInt, 4);
        long l2 = getUnsignedInt(paramArrayOfByte, paramInt + 4, 4);
        long l3 = getUnsignedInt(this.key, 0, 4);
        long l4 = getUnsignedInt(this.key, 4, 4);
        long l5 = getUnsignedInt(this.key, 8, 4);
        long l6 = getUnsignedInt(this.key, 12, 4);
        long l7 = (-478700656) & 4294967295L;
        long l8 = (-1640531527) & 4294967295L;
        while (true) {
            int i2 = i;
            i = i2 - 1;
            if (i2 > 0) {
                l2 = (l2 - ((((l1 << 4) + l5) ^ (l1 + l7)) ^ ((l1 >>> 5) + l6))) & 4294967295L;
                l1 = (l1 - ((((l2 << 4) + l3) ^ (l2 + l7)) ^ ((l2 >>> 5) + l4))) & 4294967295L;
                l7 = (l7 - l8) & 4294967295L;
            } else {
                this.baos.reset();
                writeInt((int) l1);
                writeInt((int) l2);
                return this.baos.toByteArray();
            }
        }
    }

    private void writeInt(int paramInt) {
        this.baos.write(paramInt >>> 24);
        this.baos.write(paramInt >>> 16);
        this.baos.write(paramInt >>> 8);
        this.baos.write(paramInt);
    }

    private byte[] decipher(byte[] paramArrayOfByte) {
        return decipher(paramArrayOfByte, 0);
    }

    private void encrypt8Bytes() {
        this.pos = 0;
        while (this.pos < 8) {
            if (this.header) {
                int tmp29_26 = this.pos;
                byte[] tmp29_22 = this.plain;
                tmp29_22[tmp29_26] = (byte) (tmp29_22[tmp29_26] ^ this.prePlain[this.pos]);
            } else {
                int tmp54_51 = this.pos;
                byte[] tmp54_47 = this.plain;
                tmp54_47[tmp54_51] = (byte) (tmp54_47[tmp54_51] ^ this.out[this.preCrypt + this.pos]);
            }
            this.pos++;
        }
        byte[] arrayOfByte = encipher(this.plain);
        System.arraycopy(arrayOfByte, 0, this.out, this.crypt, 8);
        this.pos = 0;
        while (this.pos < 8) {
            int tmp137_136 = this.crypt + this.pos;
            byte[] tmp137_125 = this.out;
            tmp137_125[tmp137_136] = (byte) (tmp137_125[tmp137_136] ^ this.prePlain[this.pos]);
            this.pos++;
        }
        System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
        this.preCrypt = this.crypt;
        this.crypt += 8;
        this.pos = 0;
        this.header = false;
    }

    private boolean decrypt8Bytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        this.pos = 0;
        while (this.pos < 8) {
            if (this.contextStart + this.pos >= paramInt2) {
                return true;
            }
            int tmp37_34 = this.pos;
            byte[] tmp37_30 = this.prePlain;
            tmp37_30[tmp37_34] = (byte) (tmp37_30[tmp37_34] ^ paramArrayOfByte[(this.crypt + paramInt1) + this.pos]);
            this.pos++;
        }
        this.prePlain = decipher(this.prePlain);
        if (this.prePlain == null) {
            return false;
        }
        this.contextStart += 8;
        this.crypt += 8;
        this.pos = 0;
        return true;
    }

    private int rand() {
        return random.nextInt();
    }
}
