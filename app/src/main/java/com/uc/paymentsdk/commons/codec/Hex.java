/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.commons.codec.BinaryDecoder
 *  com.uc.paymentsdk.commons.codec.BinaryEncoder
 *  com.uc.paymentsdk.commons.codec.DecoderException
 *  com.uc.paymentsdk.commons.codec.EncoderException
 */
package com.uc.paymentsdk.commons.codec;

import com.uc.paymentsdk.commons.codec.BinaryDecoder;
import com.uc.paymentsdk.commons.codec.BinaryEncoder;
import com.uc.paymentsdk.commons.codec.DecoderException;
import com.uc.paymentsdk.commons.codec.EncoderException;

public class Hex
implements BinaryEncoder,
BinaryDecoder {
    private static final char[] DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static byte[] decodeHex(char[] cArray) throws DecoderException {
        int n = cArray.length;
        if ((n & 1) != 0) {
            throw new DecoderException("Odd number of characters.");
        }
        byte[] byArray = new byte[n >> 1];
        int n2 = 0;
        int n3 = 0;
        while (n3 < n) {
            int n4 = Hex.toDigit(cArray[n3], n3);
            int n5 = Hex.toDigit(cArray[++n3], n3);
            ++n3;
            byArray[n2] = (byte)((n4 << 4 | n5) & 0xFF);
            ++n2;
        }
        return byArray;
    }

    public static char[] encodeHex(byte[] byArray) {
        int n = byArray.length;
        char[] cArray = new char[n << 1];
        int n2 = 0;
        int n3 = 0;
        while (n2 < n) {
            int n4 = n3 + 1;
            cArray[n3] = DIGITS[(byArray[n2] & 0xF0) >>> 4];
            n3 = n4 + 1;
            cArray[n4] = DIGITS[byArray[n2] & 0xF];
            ++n2;
        }
        return cArray;
    }

    protected static int toDigit(char c, int n) throws DecoderException {
        int n2 = Character.digit(c, 16);
        if (n2 == -1) {
            throw new DecoderException("Illegal hexadecimal charcter " + c + " at index " + n);
        }
        return n2;
    }

    /*
     * Enabled force condition propagation
     */
    public Object decode(Object object) throws DecoderException {
        try {
            if (object instanceof String) {
                object = ((String)object).toCharArray();
                return Hex.decodeHex((char[])object);
            }
            object = (char[])object;
            return Hex.decodeHex((char[])object);
        }
        catch (ClassCastException classCastException) {
            throw new DecoderException(classCastException.getMessage());
        }
    }

    public byte[] decode(byte[] byArray) throws DecoderException {
        return Hex.decodeHex(new String(byArray).toCharArray());
    }

    /*
     * Enabled force condition propagation
     */
    public Object encode(Object object) throws EncoderException {
        try {
            if (object instanceof String) {
                object = ((String)object).getBytes();
                return Hex.encodeHex((byte[])object);
            }
            object = (byte[])object;
            return Hex.encodeHex((byte[])object);
        }
        catch (ClassCastException classCastException) {
            throw new EncoderException(classCastException.getMessage());
        }
    }

    public byte[] encode(byte[] byArray) {
        return new String(Hex.encodeHex(byArray)).getBytes();
    }
}
