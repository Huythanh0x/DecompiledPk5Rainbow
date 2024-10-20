package com.uc.paymentsdk.commons.codec;

public class Hex implements BinaryDecoder, BinaryEncoder {
    private static final char[] DIGITS;

    static {
        Hex.DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    @Override  // com.uc.paymentsdk.commons.codec.Decoder
    public Object decode(Object paramObject) throws DecoderException {
        try {
            return Hex.decodeHex(((paramObject instanceof String) ? ((String)paramObject).toCharArray() : ((char[])paramObject)));
        }
        catch(ClassCastException classCastException0) {
            throw new DecoderException(classCastException0.getMessage());
        }
    }

    @Override  // com.uc.paymentsdk.commons.codec.BinaryDecoder
    public byte[] decode(byte[] paramArrayOfByte) throws DecoderException {
        return Hex.decodeHex(new String(paramArrayOfByte).toCharArray());
    }

    public static byte[] decodeHex(char[] paramArrayOfChar) throws DecoderException {
        if((paramArrayOfChar.length & 1) != 0) {
            throw new DecoderException("Odd number of characters.");
        }
        byte[] arrayOfByte = new byte[paramArrayOfChar.length >> 1];
        int k = 0;
        for(int j = 0; k < paramArrayOfChar.length; ++j) {
            int m = Hex.toDigit(paramArrayOfChar[k], k) << 4 | Hex.toDigit(paramArrayOfChar[k + 1], k + 1);
            k += 2;
            arrayOfByte[j] = (byte)(m & 0xFF);
        }
        return arrayOfByte;
    }

    @Override  // com.uc.paymentsdk.commons.codec.Encoder
    public Object encode(Object paramObject) throws EncoderException {
        try {
            return Hex.encodeHex(((paramObject instanceof String) ? ((String)paramObject).getBytes() : ((byte[])paramObject)));
        }
        catch(ClassCastException classCastException0) {
            throw new EncoderException(classCastException0.getMessage());
        }
    }

    @Override  // com.uc.paymentsdk.commons.codec.BinaryEncoder
    public byte[] encode(byte[] paramArrayOfByte) {
        return new String(Hex.encodeHex(paramArrayOfByte)).getBytes();
    }

    public static char[] encodeHex(byte[] paramArrayOfByte) {
        char[] arrayOfChar = new char[paramArrayOfByte.length << 1];
        int k = 0;
        for(int j = 0; j < paramArrayOfByte.length; ++j) {
            int k = k + 1;
            arrayOfChar[k] = Hex.DIGITS[(paramArrayOfByte[j] & 0xF0) >>> 4];
            k = k + 1;
            arrayOfChar[k] = Hex.DIGITS[paramArrayOfByte[j] & 15];
        }
        return arrayOfChar;
    }

    protected static int toDigit(char paramChar, int paramInt) throws DecoderException {
        int v1 = Character.digit(paramChar, 16);
        if(v1 == -1) {
            throw new DecoderException("Illegal hexadecimal charcter " + paramChar + " at index " + paramInt);
        }
        return v1;
    }
}

