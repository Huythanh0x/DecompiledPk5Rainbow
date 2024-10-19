package com.uc.paymentsdk.commons.codec;

import javax.microedition.lcdui.Canvas;
import main.Constants_H;

/* loaded from: classes.dex */
public class Base64 implements BinaryEncoder, BinaryDecoder {
    static final int CHUNK_SIZE = 76;
    static final int EIGHTBIT = 8;
    static final int FOURBYTE = 4;
    static final int LOOKUPLENGTH = 64;
    static final byte PAD = 61;
    static final int SIGN = -128;
    static final int SIXTEENBIT = 16;
    static final int TWENTYFOURBITGROUP = 24;
    static final byte[] CHUNK_SEPARATOR = "\r\n".getBytes();
    static final int BASELENGTH = 255;
    private static byte[] base64Alphabet = new byte[BASELENGTH];
    private static byte[] lookUpBase64Alphabet = new byte[64];

    static {
        for (int i = 0; i < BASELENGTH; i++) {
            base64Alphabet[i] = -1;
        }
        for (int i2 = 90; i2 >= 65; i2--) {
            base64Alphabet[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 122; i3 >= 97; i3--) {
            base64Alphabet[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 57; i4 >= 48; i4--) {
            base64Alphabet[i4] = (byte) ((i4 - 48) + 52);
        }
        base64Alphabet[43] = 62;
        base64Alphabet[47] = 63;
        for (int i5 = 0; i5 <= 25; i5++) {
            lookUpBase64Alphabet[i5] = (byte) (i5 + 65);
        }
        int icount = 26;
        int j = 0;
        while (icount <= 51) {
            lookUpBase64Alphabet[icount] = (byte) (j + 97);
            icount++;
            j++;
        }
        int icount2 = 52;
        int j2 = 0;
        while (icount2 <= 61) {
            lookUpBase64Alphabet[icount2] = (byte) (j2 + 48);
            icount2++;
            j2++;
        }
        lookUpBase64Alphabet[62] = Constants_H.f89;
        lookUpBase64Alphabet[63] = Constants_H.f20;
    }

    private static boolean isBase64(byte paramByte) {
        return paramByte == 61 || base64Alphabet[paramByte] != -1;
    }

    public static boolean isArrayByteBase64(byte[] paramArrayOfByte) {
        byte[] paramArrayOfByte2 = discardWhitespace(paramArrayOfByte);
        int i = paramArrayOfByte2.length;
        if (i == 0) {
            return true;
        }
        for (byte b : paramArrayOfByte2) {
            if (!isBase64(b)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] encodeBase64(byte[] paramArrayOfByte) {
        return encodeBase64(paramArrayOfByte, false);
    }

    public static byte[] encodeBase64Chunked(byte[] paramArrayOfByte) {
        return encodeBase64(paramArrayOfByte, true);
    }

    @Override // com.uc.paymentsdk.commons.codec.Decoder
    public Object decode(Object paramObject) throws DecoderException {
        if (!(paramObject instanceof byte[])) {
            throw new DecoderException("Parameter supplied to Base64 decode is not a byte[]");
        }
        return decode((byte[]) paramObject);
    }

    @Override // com.uc.paymentsdk.commons.codec.BinaryDecoder
    public byte[] decode(byte[] paramArrayOfByte) {
        return decodeBase64(paramArrayOfByte);
    }

    public static byte[] encodeBase64(byte[] paramArrayOfByte, boolean paramBoolean) {
        int m;
        int n;
        int m2;
        int i11;
        int i112;
        int i113;
        int i9;
        int i = paramArrayOfByte.length * 8;
        int j = i % 24;
        int k = i / 24;
        if (j != 0) {
            int m3 = k + 1;
            m = m3 * 4;
        } else {
            m = k * 4;
        }
        if (!paramBoolean) {
            n = 0;
            m2 = m;
        } else {
            int n2 = CHUNK_SEPARATOR.length;
            int n3 = n2 == 0 ? 0 : (int) Math.ceil(m / 76.0f);
            n = n3;
            m2 = m + (CHUNK_SEPARATOR.length * n3);
        }
        byte[] arrayOfByte = new byte[m2];
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i10 = 0;
        int i92 = CHUNK_SIZE;
        int i8 = 0;
        int i6 = 0;
        while (i8 < k) {
            int i7 = i8 * 3;
            int i72 = paramArrayOfByte[i7];
            int i12 = i7 + 1;
            int i42 = paramArrayOfByte[i12];
            int i13 = i7 + 2;
            int i5 = paramArrayOfByte[i13];
            int i22 = (byte) (i42 & 15);
            i1 = (byte) (i72 & 3);
            if ((i72 & SIGN) == 0) {
                i113 = (byte) (i72 >> 2);
            } else {
                int i23 = i72 >> 2;
                i113 = (byte) (i23 ^ 192);
            }
            int i122 = (i42 & SIGN) == 0 ? (byte) (i42 >> 4) : (byte) ((i42 >> 4) ^ 240);
            int i132 = (i5 & SIGN) == 0 ? (byte) (i5 >> 6) : (byte) ((i5 >> 6) ^ 252);
            arrayOfByte[i6] = lookUpBase64Alphabet[i113];
            arrayOfByte[i6 + 1] = lookUpBase64Alphabet[i122 | (i1 << 4)];
            arrayOfByte[i6 + 2] = lookUpBase64Alphabet[i132 | (i22 << 2)];
            arrayOfByte[i6 + 3] = lookUpBase64Alphabet[i5 & 63];
            int i62 = i6 + 4;
            if (!paramBoolean) {
                i9 = i92;
            } else if (i62 != i92) {
                i9 = i92;
            } else {
                System.arraycopy(CHUNK_SEPARATOR, 0, arrayOfByte, i62, CHUNK_SEPARATOR.length);
                i10++;
                int i93 = ((i10 + 1) * CHUNK_SIZE) + (CHUNK_SEPARATOR.length * i10);
                i62 += CHUNK_SEPARATOR.length;
                i9 = i93;
            }
            i92 = i9;
            i8++;
            i6 = i62;
            i4 = i42;
            i3 = i72;
            i2 = i22;
        }
        int i52 = i8 * 3;
        if (j == 8) {
            int i32 = paramArrayOfByte[i52];
            int i14 = (byte) (i32 & 3);
            int i15 = i32 & SIGN;
            if (i15 == 0) {
                i112 = (byte) (i32 >> 2);
            } else {
                int i16 = i32 >> 2;
                i112 = (byte) (i16 ^ 192);
            }
            arrayOfByte[i6] = lookUpBase64Alphabet[i112];
            arrayOfByte[i6 + 1] = lookUpBase64Alphabet[i14 << 4];
            arrayOfByte[i6 + 2] = PAD;
            arrayOfByte[i6 + 3] = PAD;
        } else if (j == 16) {
            int i43 = paramArrayOfByte[i52];
            int i17 = i52 + 1;
            int i73 = paramArrayOfByte[i17];
            int i24 = (byte) (i73 & 15);
            int i18 = (byte) (i43 & 3);
            if ((i43 & SIGN) == 0) {
                i11 = (byte) (i43 >> 2);
            } else {
                int i25 = i43 >> 2;
                i11 = (byte) (i25 ^ 192);
            }
            int i123 = (i73 & SIGN) == 0 ? (byte) (i73 >> 4) : (byte) ((i73 >> 4) ^ 240);
            arrayOfByte[i6] = lookUpBase64Alphabet[i11];
            arrayOfByte[i6 + 1] = lookUpBase64Alphabet[i123 | (i18 << 4)];
            arrayOfByte[i6 + 2] = lookUpBase64Alphabet[i24 << 2];
            arrayOfByte[i6 + 3] = PAD;
        }
        if (paramBoolean && i10 < n) {
            byte[] bArr = CHUNK_SEPARATOR;
            int i26 = CHUNK_SEPARATOR.length;
            int i102 = CHUNK_SEPARATOR.length;
            System.arraycopy(bArr, 0, arrayOfByte, m2 - i26, i102);
        }
        return arrayOfByte;
    }

    public static byte[] decodeBase64(byte[] paramArrayOfByte) {
        byte[] paramArrayOfByte2 = discardNonBase64(paramArrayOfByte);
        if (paramArrayOfByte2.length == 0) {
            return new byte[0];
        }
        int i = paramArrayOfByte2.length / 4;
        int i3 = 0;
        int i5 = paramArrayOfByte2.length;
        while (paramArrayOfByte2[i5 - 1] == 61) {
            i5--;
            if (i5 == 0) {
                return new byte[0];
            }
        }
        byte[] arrayOfByte = new byte[i5 - i];
        for (int i52 = 0; i52 < i; i52++) {
            int i4 = i52 * 4;
            int i1 = paramArrayOfByte2[i4 + 2];
            int i2 = paramArrayOfByte2[i4 + 3];
            int j = base64Alphabet[paramArrayOfByte2[i4]];
            int k = base64Alphabet[paramArrayOfByte2[i4 + 1]];
            if (i1 != 61 && i2 != 61) {
                int m = base64Alphabet[i1];
                int n = base64Alphabet[i2];
                arrayOfByte[i3] = (byte) ((j << 2) | (k >> 4));
                arrayOfByte[i3 + 1] = (byte) (((k & 15) << 4) | ((m >> 2) & 15));
                arrayOfByte[i3 + 2] = (byte) ((m << 6) | n);
            } else if (i1 == 61) {
                arrayOfByte[i3] = (byte) ((j << 2) | (k >> 4));
            } else if (i2 == 61) {
                int m2 = base64Alphabet[i1];
                arrayOfByte[i3] = (byte) ((j << 2) | (k >> 4));
                arrayOfByte[i3 + 1] = (byte) (((k & 15) << 4) | ((m2 >> 2) & 15));
            }
            i3 += 3;
        }
        return arrayOfByte;
    }

    static byte[] discardWhitespace(byte[] paramArrayOfByte) {
        byte[] arrayOfByte1 = new byte[paramArrayOfByte.length];
        int i = 0;
        for (int j = 0; j < paramArrayOfByte.length; j++) {
            switch (paramArrayOfByte[j]) {
                case 9:
                case 10:
                case Canvas.KEY_NUM6 /* 13 */:
                case 32:
                    break;
                default:
                    arrayOfByte1[i] = paramArrayOfByte[j];
                    i++;
                    break;
            }
        }
        byte[] arrayOfByte2 = new byte[i];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
        return arrayOfByte2;
    }

    static byte[] discardNonBase64(byte[] paramArrayOfByte) {
        byte[] arrayOfByte1 = new byte[paramArrayOfByte.length];
        int i = 0;
        for (int j = 0; j < paramArrayOfByte.length; j++) {
            if (isBase64(paramArrayOfByte[j])) {
                arrayOfByte1[i] = paramArrayOfByte[j];
                i++;
            }
        }
        byte[] arrayOfByte2 = new byte[i];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
        return arrayOfByte2;
    }

    @Override // com.uc.paymentsdk.commons.codec.Encoder
    public Object encode(Object paramObject) throws EncoderException {
        if (!(paramObject instanceof byte[])) {
            throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");
        }
        return encode((byte[]) paramObject);
    }

    @Override // com.uc.paymentsdk.commons.codec.BinaryEncoder
    public byte[] encode(byte[] paramArrayOfByte) {
        return encodeBase64(paramArrayOfByte, false);
    }
}
