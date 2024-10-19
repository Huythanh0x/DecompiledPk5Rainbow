package com.uc.paymentsdk.commons.codec;

/* loaded from: classes.dex */
public class Hex implements BinaryEncoder, BinaryDecoder {
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static byte[] decodeHex(char[] paramArrayOfChar) throws DecoderException {
        int i = paramArrayOfChar.length;
        if ((i & 1) != 0) {
            throw new DecoderException("Odd number of characters.");
        }
        byte[] arrayOfByte = new byte[i >> 1];
        int j = 0;
        int k = 0;
        while (k < i) {
            int m = toDigit(paramArrayOfChar[k], k) << 4;
            int k2 = k + 1;
            int m2 = m | toDigit(paramArrayOfChar[k2], k2);
            k = k2 + 1;
            arrayOfByte[j] = (byte) (m2 & 255);
            j++;
        }
        return arrayOfByte;
    }

    protected static int toDigit(char paramChar, int paramInt) throws DecoderException {
        int i = Character.digit(paramChar, 16);
        if (i == -1) {
            throw new DecoderException("Illegal hexadecimal charcter " + paramChar + " at index " + paramInt);
        }
        return i;
    }

    public static char[] encodeHex(byte[] paramArrayOfByte) {
        int i = paramArrayOfByte.length;
        char[] arrayOfChar = new char[i << 1];
        int k = 0;
        for (int j = 0; j < i; j++) {
            int k2 = k + 1;
            arrayOfChar[k] = DIGITS[(paramArrayOfByte[j] & 240) >>> 4];
            k = k2 + 1;
            arrayOfChar[k2] = DIGITS[paramArrayOfByte[j] & 15];
        }
        return arrayOfChar;
    }

    @Override // com.uc.paymentsdk.commons.codec.BinaryDecoder
    public byte[] decode(byte[] paramArrayOfByte) throws DecoderException {
        return decodeHex(new String(paramArrayOfByte).toCharArray());
    }

    @Override // com.uc.paymentsdk.commons.codec.Decoder
    public Object decode(Object paramObject) throws DecoderException {
        try {
            char[] arrayOfChar = paramObject instanceof String ? ((String) paramObject).toCharArray() : (char[]) paramObject;
            return decodeHex(arrayOfChar);
        } catch (ClassCastException localClassCastException) {
            throw new DecoderException(localClassCastException.getMessage());
        }
    }

    @Override // com.uc.paymentsdk.commons.codec.BinaryEncoder
    public byte[] encode(byte[] paramArrayOfByte) {
        return new String(encodeHex(paramArrayOfByte)).getBytes();
    }

    @Override // com.uc.paymentsdk.commons.codec.Encoder
    public Object encode(Object paramObject) throws EncoderException {
        try {
            byte[] arrayOfByte = paramObject instanceof String ? ((String) paramObject).getBytes() : (byte[]) paramObject;
            return encodeHex(arrayOfByte);
        } catch (ClassCastException localClassCastException) {
            throw new EncoderException(localClassCastException.getMessage());
        }
    }
}
