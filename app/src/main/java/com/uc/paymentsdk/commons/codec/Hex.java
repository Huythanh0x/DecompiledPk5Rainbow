package com.uc.paymentsdk.commons.codec.Hex;
import com.uc.paymentsdk.commons.codec.BinaryEncoder;
import com.uc.paymentsdk.commons.codec.BinaryDecoder;
import java.lang.Object;
import com.uc.paymentsdk.commons.codec.DecoderException;
import java.lang.String;
import java.lang.Character;
import java.lang.StringBuilder;
import java.lang.ClassCastException;
import com.uc.paymentsdk.commons.codec.EncoderException;

public class Hex implements BinaryEncoder, BinaryDecoder	// class@00008e from classes.dex
{
    private static final char[] DIGITS;

    static {
       Hex.DIGITS = new char[16]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    }
    public void Hex(){
       super();
    }
    public static byte[] decodeHex(char[] paramArrayOfChar){
       int i = paramArrayOfChar.length;
       if ((i & 0x01)) {
          throw new DecoderException("Odd number of characters.");
       }
       byte[] arrayOfByte = new byte[(i >> 1)];
       int j = 0;
       int k = 0;
       while (k < i) {
          int m = Hex.toDigit(paramArrayOfChar[k], k) << 4;
          k++;
          m = m | Hex.toDigit(paramArrayOfChar[k], k);
          k++;
          int ix = m & 0x00ff;
          arrayOfByte[j] = (byte)ix;
          j++;
       }
       return arrayOfByte;
    }
    public static char[] encodeHex(byte[] paramArrayOfByte){
       int i = paramArrayOfByte.length;
       char[] arrayOfChar = new char[(i << 1)];
       int k = 0;
       k = k;
       for (int j = 0; j < i; j++) {
          k = k + 1;
          int ix = paramArrayOfByte[j] & 0x00f0;
          ix = ix >> 4;
          arrayOfChar[k] = Hex.DIGITS[ix];
          k = k + 1;
          ix = paramArrayOfByte[j] & 0x0f;
          arrayOfChar[k] = Hex.DIGITS[ix];
       }
       return arrayOfChar;
    }
    protected static int toDigit(char paramChar,int paramInt){
       int i;
       if ((i = Character.digit(paramChar, 16)) == -1) {
          throw new DecoderException("Illegal hexadecimal charcter "+paramChar+" at index "+paramInt);
       }
       return i;
    }
    public Object decode(Object paramObject){
       try{
          char[] arrayOfChar = (paramObject instanceof String)? paramObject.toCharArray(): paramObject;
          return Hex.decodeHex(arrayOfChar);
       }catch(java.lang.ClassCastException e2){
          ClassCastException localClassCastException = e2;
          throw new DecoderException(localClassCastException.getMessage());
       }
    }
    public byte[] decode(byte[] paramArrayOfByte){
       return Hex.decodeHex(new String(paramArrayOfByte).toCharArray());
    }
    public Object encode(Object paramObject){
       try{
          byte[] arrayOfByte = (paramObject instanceof String)? paramObject.getBytes(): paramObject;
          return Hex.encodeHex(arrayOfByte);
       }catch(java.lang.ClassCastException e2){
          ClassCastException localClassCastException = e2;
          throw new EncoderException(localClassCastException.getMessage());
       }
    }
    public byte[] encode(byte[] paramArrayOfByte){
       return new String(Hex.encodeHex(paramArrayOfByte)).getBytes();
    }
}
