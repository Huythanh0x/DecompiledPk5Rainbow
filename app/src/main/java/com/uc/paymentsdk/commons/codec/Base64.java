package com.uc.paymentsdk.commons.codec;

public class Base64 implements BinaryDecoder, BinaryEncoder {
    static final int BASELENGTH = 0xFF;
    static final byte[] CHUNK_SEPARATOR = null;
    static final int CHUNK_SIZE = 76;
    static final int EIGHTBIT = 8;
    static final int FOURBYTE = 4;
    static final int LOOKUPLENGTH = 0x40;
    static final byte PAD = 61;
    static final int SIGN = 0xFFFFFF80;
    static final int SIXTEENBIT = 16;
    static final int TWENTYFOURBITGROUP = 24;
    private static byte[] base64Alphabet;
    private static byte[] lookUpBase64Alphabet;

    static {
        Base64.CHUNK_SEPARATOR = new byte[]{13, 10};
        Base64.base64Alphabet = new byte[0xFF];
        Base64.lookUpBase64Alphabet = new byte[0x40];
        for(int i = 0; i < 0xFF; ++i) {
            Base64.base64Alphabet[i] = -1;
        }
        for(int i = 90; i >= 65; --i) {
            Base64.base64Alphabet[i] = (byte)(i - 65);
        }
        for(int i = 0x7A; i >= 97; --i) {
            Base64.base64Alphabet[i] = (byte)(i - 71);
        }
        for(int i = 57; i >= 0x30; --i) {
            Base64.base64Alphabet[i] = (byte)(i + 4);
        }
        Base64.base64Alphabet[43] = 62;
        Base64.base64Alphabet[0x2F] = 0x3F;
        for(int i = 0; i <= 25; ++i) {
            Base64.lookUpBase64Alphabet[i] = (byte)(i + 65);
        }
        int icount = 26;
        for(int j = 0; icount <= 51; ++j) {
            Base64.lookUpBase64Alphabet[icount] = (byte)(j + 97);
            ++icount;
        }
        int icount = 52;
        for(int j = 0; icount <= 61; ++j) {
            Base64.lookUpBase64Alphabet[icount] = (byte)(j + 0x30);
            ++icount;
        }
        Base64.lookUpBase64Alphabet[62] = 43;
        Base64.lookUpBase64Alphabet[0x3F] = 0x2F;
    }

    @Override  // com.uc.paymentsdk.commons.codec.Decoder
    public Object decode(Object paramObject) throws DecoderException {
        if(!(paramObject instanceof byte[])) {
            throw new DecoderException("Parameter supplied to Base64 decode is not a byte[]");
        }
        return this.decode(((byte[])paramObject));
    }

    @Override  // com.uc.paymentsdk.commons.codec.BinaryDecoder
    public byte[] decode(byte[] paramArrayOfByte) {
        return Base64.decodeBase64(paramArrayOfByte);
    }

    public static byte[] decodeBase64(byte[] paramArrayOfByte) {
        byte[] arr_b1 = Base64.discardNonBase64(paramArrayOfByte);
        if(arr_b1.length == 0) {
            return new byte[0];
        }
        int i = arr_b1.length / 4;
        int i3 = 0;
        int i5 = arr_b1.length;
        do {
            if(arr_b1[i5 - 1] != 61) {
                byte[] arrayOfByte = new byte[i5 - i];
                for(int i5 = 0; i5 < i; ++i5) {
                    int i1 = arr_b1[i5 * 4 + 2];
                    int i2 = arr_b1[i5 * 4 + 3];
                    int j = Base64.base64Alphabet[arr_b1[i5 * 4]];
                    int k = Base64.base64Alphabet[arr_b1[i5 * 4 + 1]];
                    if(i1 != 61 && i2 != 61) {
                        int m = Base64.base64Alphabet[i1];
                        int n = Base64.base64Alphabet[i2];
                        arrayOfByte[i3] = (byte)(j << 2 | k >> 4);
                        arrayOfByte[i3 + 1] = (byte)((k & 15) << 4 | m >> 2 & 15);
                        arrayOfByte[i3 + 2] = (byte)(m << 6 | n);
                    }
                    else if(i1 == 61) {
                        arrayOfByte[i3] = (byte)(j << 2 | k >> 4);
                    }
                    else if(i2 == 61) {
                        int m = Base64.base64Alphabet[i1];
                        arrayOfByte[i3] = (byte)(j << 2 | k >> 4);
                        arrayOfByte[i3 + 1] = (byte)((k & 15) << 4 | m >> 2 & 15);
                    }
                    i3 += 3;
                }
                return arrayOfByte;
            }
            --i5;
        }
        while(i5 != 0);
        return new byte[0];
    }

    static byte[] discardNonBase64(byte[] paramArrayOfByte) {
        byte[] arrayOfByte1 = new byte[paramArrayOfByte.length];
        int i = 0;
        for(int j = 0; j < paramArrayOfByte.length; ++j) {
            if(Base64.isBase64(paramArrayOfByte[j])) {
                arrayOfByte1[i] = paramArrayOfByte[j];
                ++i;
            }
        }
        byte[] arrayOfByte2 = new byte[i];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
        return arrayOfByte2;
    }

    static byte[] discardWhitespace(byte[] paramArrayOfByte) {
        byte[] arrayOfByte1 = new byte[paramArrayOfByte.length];
        int i = 0;
        for(int j = 0; j < paramArrayOfByte.length; ++j) {
            switch(paramArrayOfByte[j]) {
                case 9: 
                case 10: 
                case 13: 
                case 0x20: {
                    break;
                }
                default: {
                    arrayOfByte1[i] = paramArrayOfByte[j];
                    ++i;
                }
            }
        }
        byte[] arrayOfByte2 = new byte[i];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
        return arrayOfByte2;
    }

    @Override  // com.uc.paymentsdk.commons.codec.Encoder
    public Object encode(Object paramObject) throws EncoderException {
        if(!(paramObject instanceof byte[])) {
            throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");
        }
        return this.encode(((byte[])paramObject));
    }

    @Override  // com.uc.paymentsdk.commons.codec.BinaryEncoder
    public byte[] encode(byte[] paramArrayOfByte) {
        int v = paramArrayOfByte.length * 8 % 24;
        int v1 = paramArrayOfByte.length * 8 / 24;
        byte[] arr_b1 = new byte[(v == 0 ? v1 * 4 : (v1 + 1) * 4)];
        int v2 = 0;
        int v3;
        for(v3 = 0; v2 < v1; v3 += 4) {
            int v4 = paramArrayOfByte[v2 * 3];
            int v5 = paramArrayOfByte[v2 * 3 + 1];
            int v6 = paramArrayOfByte[v2 * 3 + 2];
            arr_b1[v3] = Base64.lookUpBase64Alphabet[((v4 & 0xFFFFFF80) == 0 ? ((byte)(v4 >> 2)) : ((byte)(v4 >> 2 ^ 0xC0)))];
            arr_b1[v3 + 1] = Base64.lookUpBase64Alphabet[((v5 & 0xFFFFFF80) == 0 ? ((byte)(v5 >> 4)) : ((byte)(v5 >> 4 ^ 0xF0))) | ((byte)(v4 & 3)) << 4];
            arr_b1[v3 + 2] = Base64.lookUpBase64Alphabet[((v6 & 0xFFFFFF80) == 0 ? ((byte)(v6 >> 6)) : ((byte)(v6 >> 6 ^ 0xFC))) | ((byte)(v5 & 15)) << 2];
            arr_b1[v3 + 3] = Base64.lookUpBase64Alphabet[v6 & 0x3F];
            ++v2;
        }
        switch(v) {
            case 8: {
                int v7 = paramArrayOfByte[v2 * 3];
                arr_b1[v3] = Base64.lookUpBase64Alphabet[((v7 & 0xFFFFFF80) == 0 ? ((byte)(v7 >> 2)) : ((byte)(v7 >> 2 ^ 0xC0)))];
                arr_b1[v3 + 1] = Base64.lookUpBase64Alphabet[((byte)(v7 & 3)) << 4];
                arr_b1[v3 + 2] = 61;
                arr_b1[v3 + 3] = 61;
                return arr_b1;
            }
            case 16: {
                int v8 = paramArrayOfByte[v2 * 3];
                int v9 = paramArrayOfByte[v2 * 3 + 1];
                arr_b1[v3] = Base64.lookUpBase64Alphabet[((v8 & 0xFFFFFF80) == 0 ? ((byte)(v8 >> 2)) : ((byte)(v8 >> 2 ^ 0xC0)))];
                arr_b1[v3 + 1] = Base64.lookUpBase64Alphabet[((v9 & 0xFFFFFF80) == 0 ? ((byte)(v9 >> 4)) : ((byte)(v9 >> 4 ^ 0xF0))) | ((byte)(v8 & 3)) << 4];
                arr_b1[v3 + 2] = Base64.lookUpBase64Alphabet[((byte)(v9 & 15)) << 2];
                arr_b1[v3 + 3] = 61;
                return arr_b1;
            }
            default: {
                return arr_b1;
            }
        }
    }

    public static byte[] encodeBase64(byte[] paramArrayOfByte) {
        int v = paramArrayOfByte.length * 8 % 24;
        int v1 = paramArrayOfByte.length * 8 / 24;
        byte[] arr_b1 = new byte[(v == 0 ? v1 * 4 : (v1 + 1) * 4)];
        int v2 = 0;
        int v3;
        for(v3 = 0; v2 < v1; v3 += 4) {
            int v4 = paramArrayOfByte[v2 * 3];
            int v5 = paramArrayOfByte[v2 * 3 + 1];
            int v6 = paramArrayOfByte[v2 * 3 + 2];
            arr_b1[v3] = Base64.lookUpBase64Alphabet[((v4 & 0xFFFFFF80) == 0 ? ((byte)(v4 >> 2)) : ((byte)(v4 >> 2 ^ 0xC0)))];
            arr_b1[v3 + 1] = Base64.lookUpBase64Alphabet[((v5 & 0xFFFFFF80) == 0 ? ((byte)(v5 >> 4)) : ((byte)(v5 >> 4 ^ 0xF0))) | ((byte)(v4 & 3)) << 4];
            arr_b1[v3 + 2] = Base64.lookUpBase64Alphabet[((v6 & 0xFFFFFF80) == 0 ? ((byte)(v6 >> 6)) : ((byte)(v6 >> 6 ^ 0xFC))) | ((byte)(v5 & 15)) << 2];
            arr_b1[v3 + 3] = Base64.lookUpBase64Alphabet[v6 & 0x3F];
            ++v2;
        }
        switch(v) {
            case 8: {
                int v7 = paramArrayOfByte[v2 * 3];
                arr_b1[v3] = Base64.lookUpBase64Alphabet[((v7 & 0xFFFFFF80) == 0 ? ((byte)(v7 >> 2)) : ((byte)(v7 >> 2 ^ 0xC0)))];
                arr_b1[v3 + 1] = Base64.lookUpBase64Alphabet[((byte)(v7 & 3)) << 4];
                arr_b1[v3 + 2] = 61;
                arr_b1[v3 + 3] = 61;
                return arr_b1;
            }
            case 16: {
                int v8 = paramArrayOfByte[v2 * 3];
                int v9 = paramArrayOfByte[v2 * 3 + 1];
                arr_b1[v3] = Base64.lookUpBase64Alphabet[((v8 & 0xFFFFFF80) == 0 ? ((byte)(v8 >> 2)) : ((byte)(v8 >> 2 ^ 0xC0)))];
                arr_b1[v3 + 1] = Base64.lookUpBase64Alphabet[((v9 & 0xFFFFFF80) == 0 ? ((byte)(v9 >> 4)) : ((byte)(v9 >> 4 ^ 0xF0))) | ((byte)(v8 & 3)) << 4];
                arr_b1[v3 + 2] = Base64.lookUpBase64Alphabet[((byte)(v9 & 15)) << 2];
                arr_b1[v3 + 3] = 61;
                return arr_b1;
            }
            default: {
                return arr_b1;
            }
        }
    }

    public static byte[] encodeBase64(byte[] paramArrayOfByte, boolean paramBoolean) [...] // Inlined contents

    public static byte[] encodeBase64Chunked(byte[] paramArrayOfByte) {
        int v13;
        int v = paramArrayOfByte.length * 8 % 24;
        int v1 = paramArrayOfByte.length * 8 / 24;
        int v2 = v == 0 ? v1 * 4 : (v1 + 1) * 4;
        int v3 = Base64.CHUNK_SEPARATOR.length == 0 ? 0 : ((int)Math.ceil(((float)v2) / 76.0f));
        int v4 = v2 + Base64.CHUNK_SEPARATOR.length * v3;
        byte[] arr_b1 = new byte[v4];
        int v5 = 0;
        int v6 = 76;
        int v7 = 0;
        int v8;
        for(v8 = 0; v7 < v1; v8 = v12) {
            int v9 = paramArrayOfByte[v7 * 3];
            int v10 = paramArrayOfByte[v7 * 3 + 1];
            int v11 = paramArrayOfByte[v7 * 3 + 2];
            arr_b1[v8] = Base64.lookUpBase64Alphabet[((v9 & 0xFFFFFF80) == 0 ? ((byte)(v9 >> 2)) : ((byte)(v9 >> 2 ^ 0xC0)))];
            arr_b1[v8 + 1] = Base64.lookUpBase64Alphabet[((v10 & 0xFFFFFF80) == 0 ? ((byte)(v10 >> 4)) : ((byte)(v10 >> 4 ^ 0xF0))) | ((byte)(v9 & 3)) << 4];
            arr_b1[v8 + 2] = Base64.lookUpBase64Alphabet[((v11 & 0xFFFFFF80) == 0 ? ((byte)(v11 >> 6)) : ((byte)(v11 >> 6 ^ 0xFC))) | ((byte)(v10 & 15)) << 2];
            arr_b1[v8 + 3] = Base64.lookUpBase64Alphabet[v11 & 0x3F];
            int v12 = v8 + 4;
            if(v12 == v6) {
                System.arraycopy(Base64.CHUNK_SEPARATOR, 0, arr_b1, v12, Base64.CHUNK_SEPARATOR.length);
                ++v5;
                v12 += Base64.CHUNK_SEPARATOR.length;
                v13 = (v5 + 1) * 76 + Base64.CHUNK_SEPARATOR.length * v5;
            }
            else {
                v13 = v6;
            }
            v6 = v13;
            ++v7;
        }
        switch(v) {
            case 8: {
                int v14 = paramArrayOfByte[v7 * 3];
                arr_b1[v8] = Base64.lookUpBase64Alphabet[((v14 & 0xFFFFFF80) == 0 ? ((byte)(v14 >> 2)) : ((byte)(v14 >> 2 ^ 0xC0)))];
                arr_b1[v8 + 1] = Base64.lookUpBase64Alphabet[((byte)(v14 & 3)) << 4];
                arr_b1[v8 + 2] = 61;
                arr_b1[v8 + 3] = 61;
                break;
            }
            case 16: {
                int v15 = paramArrayOfByte[v7 * 3];
                int v16 = paramArrayOfByte[v7 * 3 + 1];
                arr_b1[v8] = Base64.lookUpBase64Alphabet[((v15 & 0xFFFFFF80) == 0 ? ((byte)(v15 >> 2)) : ((byte)(v15 >> 2 ^ 0xC0)))];
                arr_b1[v8 + 1] = Base64.lookUpBase64Alphabet[((v16 & 0xFFFFFF80) == 0 ? ((byte)(v16 >> 4)) : ((byte)(v16 >> 4 ^ 0xF0))) | ((byte)(v15 & 3)) << 4];
                arr_b1[v8 + 2] = Base64.lookUpBase64Alphabet[((byte)(v16 & 15)) << 2];
                arr_b1[v8 + 3] = 61;
            }
        }
        if(v5 < v3) {
            System.arraycopy(Base64.CHUNK_SEPARATOR, 0, arr_b1, v4 - Base64.CHUNK_SEPARATOR.length, Base64.CHUNK_SEPARATOR.length);
        }
        return arr_b1;
    }

    public static boolean isArrayByteBase64(byte[] paramArrayOfByte) {
        byte[] arr_b1 = Base64.discardWhitespace(paramArrayOfByte);
        if(arr_b1.length == 0) {
            return true;
        }
        for(int j = 0; true; ++j) {
            if(j >= arr_b1.length) {
                return true;
            }
            if(!Base64.isBase64(arr_b1[j])) {
                return false;
            }
        }
    }

    private static boolean isBase64(byte paramByte) {
        return paramByte == 61 ? true : Base64.base64Alphabet[paramByte] != -1;
    }
}

