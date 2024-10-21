package com.uc.paymentsdk.commons.codec;

public class Hex implements BinaryEncoder, BinaryDecoder {
  private static final char[] DIGITS = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  public static byte[] decodeHex(char[] paramArrayOfchar) throws DecoderException {
    int i = paramArrayOfchar.length;
    if ((i & 0x1) != 0)
      throw new DecoderException("Odd number of characters."); 
    byte[] arrayOfByte = new byte[i >> 1];
    byte b1 = 0;
    byte b2 = 0;
    while (true) {
      if (b2 >= i)
        return arrayOfByte; 
      int j = toDigit(paramArrayOfchar[b2], b2);
      int k = toDigit(paramArrayOfchar[++b2], b2);
      b2++;
      arrayOfByte[b1] = (byte)((j << 4 | k) & 0xFF);
      b1++;
    } 
  }
  
  public static char[] encodeHex(byte[] paramArrayOfbyte) {
    int j = paramArrayOfbyte.length;
    char[] arrayOfChar = new char[j << 1];
    byte b = 0;
    int i = 0;
    while (true) {
      if (b >= j)
        return arrayOfChar; 
      int k = i + 1;
      arrayOfChar[i] = DIGITS[(paramArrayOfbyte[b] & 0xF0) >>> 4];
      i = k + 1;
      arrayOfChar[k] = DIGITS[paramArrayOfbyte[b] & 0xF];
      b++;
    } 
  }
  
  protected static int toDigit(char paramChar, int paramInt) throws DecoderException {
    int i = Character.digit(paramChar, 16);
    if (i == -1)
      throw new DecoderException("Illegal hexadecimal charcter " + paramChar + " at index " + paramInt); 
    return i;
  }
  
  public Object decode(Object paramObject) throws DecoderException {
    try {
      if (paramObject instanceof String) {
        paramObject = ((String)paramObject).toCharArray();
        return decodeHex((char[])paramObject);
      } 
      paramObject = paramObject;
      return decodeHex((char[])paramObject);
    } catch (ClassCastException classCastException) {
      throw new DecoderException(classCastException.getMessage());
    } 
  }
  
  public byte[] decode(byte[] paramArrayOfbyte) throws DecoderException {
    return decodeHex((new String(paramArrayOfbyte)).toCharArray());
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    try {
      if (paramObject instanceof String) {
        paramObject = ((String)paramObject).getBytes();
        return encodeHex((byte[])paramObject);
      } 
      paramObject = paramObject;
      return encodeHex((byte[])paramObject);
    } catch (ClassCastException classCastException) {
      throw new EncoderException(classCastException.getMessage());
    } 
  }
  
  public byte[] encode(byte[] paramArrayOfbyte) {
    return (new String(encodeHex(paramArrayOfbyte))).getBytes();
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/commons/codec/Hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */