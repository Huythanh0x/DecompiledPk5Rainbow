package com.uc.paymentsdk.commons.codec;

public class Base64 implements BinaryEncoder, BinaryDecoder
{
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
    
    static {
        CHUNK_SEPARATOR = "\r\n".getBytes();
        Base64.base64Alphabet = new byte[255];
        Base64.lookUpBase64Alphabet = new byte[64];
        for (int i = 0; i < 255; ++i) {
            Base64.base64Alphabet[i] = -1;
        }
        for (int j = 90; j >= 65; --j) {
            Base64.base64Alphabet[j] = (byte)(j - 65);
        }
        for (int k = 122; k >= 97; --k) {
            Base64.base64Alphabet[k] = (byte)(k - 97 + 26);
        }
        for (int l = 57; l >= 48; --l) {
            Base64.base64Alphabet[l] = (byte)(l - 48 + 52);
        }
        Base64.base64Alphabet[43] = 62;
        Base64.base64Alphabet[47] = 63;
        for (int n = 0; n <= 25; ++n) {
            Base64.lookUpBase64Alphabet[n] = (byte)(n + 65);
        }
        for (int n2 = 26, n3 = 0; n2 <= 51; ++n2, ++n3) {
            Base64.lookUpBase64Alphabet[n2] = (byte)(n3 + 97);
        }
        for (int n4 = 52, n5 = 0; n4 <= 61; ++n4, ++n5) {
            Base64.lookUpBase64Alphabet[n4] = (byte)(n5 + 48);
        }
        Base64.lookUpBase64Alphabet[62] = 43;
        Base64.lookUpBase64Alphabet[63] = 47;
    }
    
    public Base64() {
        super();
    }
    
    public static byte[] decodeBase64(byte[] array) {
        final byte[] discardNonBase64 = discardNonBase64(array);
        if (discardNonBase64.length == 0) {
            array = new byte[0];
        }
        else {
            final int n = discardNonBase64.length / 4;
            array = null;
            int n2 = 0;
            int length = discardNonBase64.length;
            while (discardNonBase64[length - 1] == 61) {
                if (--length == 0) {
                    array = new byte[0];
                    return array;
                }
            }
            array = new byte[length - n];
            for (int i = 0; i < n; ++i) {
                final int n3 = i * 4;
                final byte b = discardNonBase64[n3 + 2];
                final byte b2 = discardNonBase64[n3 + 3];
                final byte b3 = Base64.base64Alphabet[discardNonBase64[n3]];
                final byte b4 = Base64.base64Alphabet[discardNonBase64[n3 + 1]];
                if (b != 61 && b2 != 61) {
                    final byte b5 = Base64.base64Alphabet[b];
                    final byte b6 = Base64.base64Alphabet[b2];
                    array[n2] = (byte)(b3 << 2 | b4 >> 4);
                    array[n2 + 1] = (byte)((b4 & 0xF) << 4 | (b5 >> 2 & 0xF));
                    array[n2 + 2] = (byte)(b5 << 6 | b6);
                }
                else if (b == 61) {
                    array[n2] = (byte)(b3 << 2 | b4 >> 4);
                }
                else if (b2 == 61) {
                    final byte b7 = Base64.base64Alphabet[b];
                    array[n2] = (byte)(b3 << 2 | b4 >> 4);
                    array[n2 + 1] = (byte)((b4 & 0xF) << 4 | (b7 >> 2 & 0xF));
                }
                n2 += 3;
            }
        }
        return array;
    }
    
    static byte[] discardNonBase64(byte[] array) {
        final byte[] array2 = new byte[array.length];
        int n = 0;
        for (int i = 0; i < array.length; ++i) {
            if (isBase64(array[i])) {
                array2[n] = array[i];
                ++n;
            }
        }
        array = new byte[n];
        System.arraycopy(array2, 0, array, 0, n);
        return array;
    }
    
    static byte[] discardWhitespace(byte[] array) {
        final byte[] array2 = new byte[array.length];
        int n = 0;
        int i = 0;
        while (i < array.length) {
            int n2 = n;
            switch (array[i]) {
                default: {
                    array2[n] = array[i];
                    n2 = n + 1;
                }
                case 9:
                case 10:
                case 13:
                case 32: {
                    ++i;
                    n = n2;
                    continue;
                }
            }
        }
        array = new byte[n];
        System.arraycopy(array2, 0, array, 0, n);
        return array;
    }
    
    public static byte[] encodeBase64(final byte[] array) {
        return encodeBase64(array, false);
    }
    
    public static byte[] encodeBase64(final byte[] array, final boolean b) {
        final int n = array.length * 8;
        final int n2 = n % 24;
        final int n3 = n / 24;
        final byte[] array2 = (byte[])null;
        int n4;
        if (n2 != 0) {
            n4 = (n3 + 1) * 4;
        }
        else {
            n4 = n3 * 4;
        }
        int n6;
        int n7;
        if (b) {
            int n5;
            if (Base64.CHUNK_SEPARATOR.length == 0) {
                n5 = 0;
            }
            else {
                n5 = (int)Math.ceil(n4 / 76.0f);
            }
            final int length = Base64.CHUNK_SEPARATOR.length;
            n6 = n5;
            n7 = n4 + length * n5;
        }
        else {
            n6 = 0;
            n7 = n4;
        }
        final byte[] array3 = new byte[n7];
        int n8 = 0;
        int n9 = 76;
        int i = 0;
        int n10 = 0;
        while (i < n3) {
            final int n11 = i * 3;
            final byte b2 = array[n11];
            final byte b3 = array[n11 + 1];
            final byte b4 = array[n11 + 2];
            final byte b5 = (byte)(b3 & 0xF);
            final byte b6 = (byte)(b2 & 0x3);
            byte b7;
            if ((b2 & 0xFFFFFF80) == 0x0) {
                b7 = (byte)(b2 >> 2);
            }
            else {
                b7 = (byte)(b2 >> 2 ^ 0xC0);
            }
            byte b8;
            if ((b3 & 0xFFFFFF80) == 0x0) {
                b8 = (byte)(b3 >> 4);
            }
            else {
                b8 = (byte)(b3 >> 4 ^ 0xF0);
            }
            byte b9;
            if ((b4 & 0xFFFFFF80) == 0x0) {
                b9 = (byte)(b4 >> 6);
            }
            else {
                b9 = (byte)(b4 >> 6 ^ 0xFC);
            }
            array3[n10] = Base64.lookUpBase64Alphabet[b7];
            array3[n10 + 1] = Base64.lookUpBase64Alphabet[b8 | b6 << 4];
            array3[n10 + 2] = Base64.lookUpBase64Alphabet[b9 | b5 << 2];
            array3[n10 + 3] = Base64.lookUpBase64Alphabet[b4 & 0x3F];
            n10 += 4;
            if (b) {
                if (n10 == n9) {
                    System.arraycopy(Base64.CHUNK_SEPARATOR, 0, array3, n10, Base64.CHUNK_SEPARATOR.length);
                    ++n8;
                    final int length2 = Base64.CHUNK_SEPARATOR.length;
                    n10 += Base64.CHUNK_SEPARATOR.length;
                    n9 = (n8 + 1) * 76 + length2 * n8;
                }
            }
            ++i;
        }
        final int n12 = i * 3;
        if (n2 == 8) {
            final byte b10 = array[n12];
            final byte b11 = (byte)(b10 & 0x3);
            byte b12;
            if ((b10 & 0xFFFFFF80) == 0x0) {
                b12 = (byte)(b10 >> 2);
            }
            else {
                b12 = (byte)(b10 >> 2 ^ 0xC0);
            }
            array3[n10] = Base64.lookUpBase64Alphabet[b12];
            array3[n10 + 1] = Base64.lookUpBase64Alphabet[b11 << 4];
            array3[n10 + 3] = (array3[n10 + 2] = 61);
        }
        else if (n2 == 16) {
            final byte b13 = array[n12];
            final byte b14 = array[n12 + 1];
            final byte b15 = (byte)(b14 & 0xF);
            final byte b16 = (byte)(b13 & 0x3);
            byte b17;
            if ((b13 & 0xFFFFFF80) == 0x0) {
                b17 = (byte)(b13 >> 2);
            }
            else {
                b17 = (byte)(b13 >> 2 ^ 0xC0);
            }
            byte b18;
            if ((b14 & 0xFFFFFF80) == 0x0) {
                b18 = (byte)(b14 >> 4);
            }
            else {
                b18 = (byte)(b14 >> 4 ^ 0xF0);
            }
            array3[n10] = Base64.lookUpBase64Alphabet[b17];
            array3[n10 + 1] = Base64.lookUpBase64Alphabet[b18 | b16 << 4];
            array3[n10 + 2] = Base64.lookUpBase64Alphabet[b15 << 2];
            array3[n10 + 3] = 61;
        }
        if (b && n8 < n6) {
            System.arraycopy(Base64.CHUNK_SEPARATOR, 0, array3, n7 - Base64.CHUNK_SEPARATOR.length, Base64.CHUNK_SEPARATOR.length);
        }
        return array3;
    }
    
    public static byte[] encodeBase64Chunked(final byte[] array) {
        return encodeBase64(array, true);
    }
    
    public static boolean isArrayByteBase64(byte[] discardWhitespace) {
        discardWhitespace = discardWhitespace(discardWhitespace);
        final int length = discardWhitespace.length;
        boolean b;
        if (length == 0) {
            b = true;
        }
        else {
            for (int i = 0; i < length; ++i) {
                if (!isBase64(discardWhitespace[i])) {
                    b = false;
                    return b;
                }
            }
            b = true;
        }
        return b;
    }
    
    private static boolean isBase64(final byte b) {
        return b == 61 || Base64.base64Alphabet[b] != -1;
    }
    
    @Override
    public Object decode(final Object o) throws DecoderException {
        if (!(o instanceof byte[])) {
            throw new DecoderException("Parameter supplied to Base64 decode is not a byte[]");
        }
        return this.decode((byte[])o);
    }
    
    @Override
    public byte[] decode(final byte[] array) {
        return decodeBase64(array);
    }
    
    @Override
    public Object encode(final Object o) throws EncoderException {
        if (!(o instanceof byte[])) {
            throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");
        }
        return this.encode((byte[])o);
    }
    
    @Override
    public byte[] encode(final byte[] array) {
        return encodeBase64(array, false);
    }
}
