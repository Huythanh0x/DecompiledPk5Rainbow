package com.uc.paymentsdk.commons.codec;

public class Hex implements BinaryEncoder, BinaryDecoder
{
    private static final char[] DIGITS;
    
    static {
        DIGITS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    }
    
    public Hex() {
        super();
    }
    
    public static byte[] decodeHex(final char[] array) throws DecoderException {
        final int length = array.length;
        if ((length & 0x1) != 0x0) {
            throw new DecoderException("Odd number of characters.");
        }
        final byte[] array2 = new byte[length >> 1];
        int digit;
        int digit2;
        for (int n = 0, i = 0; i < length; ++i, digit2 = toDigit(array[i], i), ++i, array2[n] = (byte)((digit << 4 | digit2) & 0xFF), ++n) {
            digit = toDigit(array[i], i);
        }
        return array2;
    }
    
    public static char[] encodeHex(final byte[] array) {
        final int length = array.length;
        final char[] array2 = new char[length << 1];
        int i = 0;
        int n = 0;
        while (i < length) {
            final int n2 = n + 1;
            array2[n] = Hex.DIGITS[(array[i] & 0xF0) >>> 4];
            n = n2 + 1;
            array2[n2] = Hex.DIGITS[array[i] & 0xF];
            ++i;
        }
        return array2;
    }
    
    protected static int toDigit(final char c, final int i) throws DecoderException {
        final int digit = Character.digit(c, 16);
        if (digit == -1) {
            throw new DecoderException("Illegal hexadecimal charcter " + c + " at index " + i);
        }
        return digit;
    }
    
    @Override
    public Object decode(final Object o) throws DecoderException {
        try {
            char[] charArray;
            if (o instanceof String) {
                charArray = ((String)o).toCharArray();
            }
            else {
                charArray = (char[])o;
            }
            return decodeHex(charArray);
        }
        catch (final ClassCastException ex) {
            throw new DecoderException(ex.getMessage());
        }
    }
    
    @Override
    public byte[] decode(final byte[] bytes) throws DecoderException {
        return decodeHex(new String(bytes).toCharArray());
    }
    
    @Override
    public Object encode(final Object o) throws EncoderException {
        try {
            byte[] bytes;
            if (o instanceof String) {
                bytes = ((String)o).getBytes();
            }
            else {
                bytes = (byte[])o;
            }
            return encodeHex(bytes);
        }
        catch (final ClassCastException ex) {
            throw new EncoderException(ex.getMessage());
        }
    }
    
    @Override
    public byte[] encode(final byte[] array) {
        return new String(encodeHex(array)).getBytes();
    }
}
