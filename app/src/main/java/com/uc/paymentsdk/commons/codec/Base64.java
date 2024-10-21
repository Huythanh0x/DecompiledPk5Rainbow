package com.uc.paymentsdk.commons.codec;

public class Base64 implements BinaryEncoder, BinaryDecoder {
  static final int BASELENGTH = 255;
  
  static final byte[] CHUNK_SEPARATOR = "\r\n".getBytes();
  
  static final int CHUNK_SIZE = 76;
  
  static final int EIGHTBIT = 8;
  
  static final int FOURBYTE = 4;
  
  static final int LOOKUPLENGTH = 64;
  
  static final byte PAD = 61;
  
  static final int SIGN = -128;
  
  static final int SIXTEENBIT = 16;
  
  static final int TWENTYFOURBITGROUP = 24;
  
  private static byte[] base64Alphabet = new byte[255];
  
  private static byte[] lookUpBase64Alphabet = new byte[64];
  
  static {
    for (byte b = 0;; b++) {
      if (b >= 'ÿ') {
        for (b = 90;; b--) {
          if (b < 65) {
            for (b = 122;; b--) {
              if (b < 97) {
                for (b = 57;; b--) {
                  if (b < 48) {
                    base64Alphabet[43] = 62;
                    base64Alphabet[47] = 63;
                    for (b = 0;; b++) {
                      if (b > 25) {
                        byte b1 = 26;
                        for (b = 0;; b++) {
                          if (b1 > 51) {
                            b1 = 52;
                            for (b = 0;; b++) {
                              if (b1 > 61) {
                                lookUpBase64Alphabet[62] = 43;
                                lookUpBase64Alphabet[63] = 47;
                                return;
                              } 
                              lookUpBase64Alphabet[b1] = (byte)(b + 48);
                              b1++;
                            } 
                            break;
                          } 
                          lookUpBase64Alphabet[b1] = (byte)(b + 97);
                          b1++;
                        } 
                        break;
                      } 
                      lookUpBase64Alphabet[b] = (byte)(b + 65);
                    } 
                    break;
                  } 
                  base64Alphabet[b] = (byte)(b - 48 + 52);
                } 
                break;
              } 
              base64Alphabet[b] = (byte)(b - 97 + 26);
            } 
            break;
          } 
          base64Alphabet[b] = (byte)(b - 65);
        } 
        break;
      } 
      base64Alphabet[b] = -1;
    } 
  }
  
  public static byte[] decodeBase64(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = discardNonBase64(paramArrayOfbyte);
    if (arrayOfByte.length == 0)
      return new byte[0]; 
    int j = arrayOfByte.length / 4;
    paramArrayOfbyte = (byte[])null;
    byte b = 0;
    int i = arrayOfByte.length;
    while (true) {
      if (arrayOfByte[i - 1] != 61) {
        paramArrayOfbyte = new byte[i - j];
        i = 0;
        while (true) {
          if (i < j) {
            int m = i * 4;
            byte b3 = arrayOfByte[m + 2];
            byte b2 = arrayOfByte[m + 3];
            byte b1 = base64Alphabet[arrayOfByte[m]];
            m = base64Alphabet[arrayOfByte[m + 1]];
            if (b3 != 61 && b2 != 61) {
              b3 = base64Alphabet[b3];
              b2 = base64Alphabet[b2];
              paramArrayOfbyte[b] = (byte)(b1 << 2 | m >> 4);
              paramArrayOfbyte[b + 1] = (byte)((m & 0xF) << 4 | b3 >> 2 & 0xF);
              paramArrayOfbyte[b + 2] = (byte)(b3 << 6 | b2);
            } else if (b3 == 61) {
              paramArrayOfbyte[b] = (byte)(b1 << 2 | m >> 4);
            } else if (b2 == 61) {
              b2 = base64Alphabet[b3];
              paramArrayOfbyte[b] = (byte)(b1 << 2 | m >> 4);
              paramArrayOfbyte[b + 1] = (byte)((m & 0xF) << 4 | b2 >> 2 & 0xF);
            } 
            b += 3;
            i++;
            continue;
          } 
          return paramArrayOfbyte;
        } 
        break;
      } 
      int k = i - 1;
      i = k;
      if (k == 0)
        return new byte[0]; 
    } 
  }
  
  static byte[] discardNonBase64(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length];
    byte b2 = 0;
    for (byte b1 = 0;; b1++) {
      if (b1 >= paramArrayOfbyte.length) {
        paramArrayOfbyte = new byte[b2];
        System.arraycopy(arrayOfByte, 0, paramArrayOfbyte, 0, b2);
        return paramArrayOfbyte;
      } 
      if (isBase64(paramArrayOfbyte[b1])) {
        arrayOfByte[b2] = paramArrayOfbyte[b1];
        b2++;
      } 
    } 
  }
  
  static byte[] discardWhitespace(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length];
    int i = 0;
    byte b = 0;
    while (true) {
      if (b >= paramArrayOfbyte.length) {
        paramArrayOfbyte = new byte[i];
        System.arraycopy(arrayOfByte, 0, paramArrayOfbyte, 0, i);
        return paramArrayOfbyte;
      } 
      int j = i;
      switch (paramArrayOfbyte[b]) {
        default:
          arrayOfByte[i] = paramArrayOfbyte[b];
          j = i + 1;
          break;
        case 9:
        case 10:
        case 13:
        case 32:
          break;
      } 
      b++;
      i = j;
    } 
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfbyte) {
    return encodeBase64(paramArrayOfbyte, false);
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfbyte, boolean paramBoolean) {
    int k;
    byte b1;
    int i = paramArrayOfbyte.length * 8;
    int i1 = i % 24;
    int i2 = i / 24;
    byte[] arrayOfByte = (byte[])null;
    if (i1 != 0) {
      i = (i2 + 1) * 4;
    } else {
      i = i2 * 4;
    } 
    if (paramBoolean) {
      int i3;
      if (CHUNK_SEPARATOR.length == 0) {
        i3 = 0;
      } else {
        i3 = (int)Math.ceil((i / 76.0F));
      } 
      k = CHUNK_SEPARATOR.length;
      b1 = i3;
      k = i + k * i3;
    } else {
      b1 = 0;
      k = i;
    } 
    arrayOfByte = new byte[k];
    byte b3 = 0;
    byte b4 = 0;
    byte b5 = 0;
    int n = 0;
    byte b2 = 0;
    i = 76;
    int m = 0;
    int j = 0;
    n = b5;
    n = b4;
    n = b3;
    while (true) {
      if (m >= i2) {
        m *= 3;
        if (i1 == 8) {
          i = paramArrayOfbyte[m];
          m = (byte)(i & 0x3);
          if ((i & 0xFFFFFF80) == 0) {
            i = (byte)(i >> 2);
          } else {
            i = (byte)(i >> 2 ^ 0xC0);
          } 
          arrayOfByte[j] = lookUpBase64Alphabet[i];
          arrayOfByte[j + 1] = lookUpBase64Alphabet[m << 4];
          arrayOfByte[j + 2] = 61;
          arrayOfByte[j + 3] = 61;
        } else if (i1 == 16) {
          i = paramArrayOfbyte[m];
          m = paramArrayOfbyte[m + 1];
          n = (byte)(m & 0xF);
          b3 = (byte)(i & 0x3);
          if ((i & 0xFFFFFF80) == 0) {
            i = (byte)(i >> 2);
          } else {
            i = (byte)(i >> 2 ^ 0xC0);
          } 
          if ((m & 0xFFFFFF80) == 0) {
            m = (byte)(m >> 4);
          } else {
            m = (byte)(m >> 4 ^ 0xF0);
          } 
          arrayOfByte[j] = lookUpBase64Alphabet[i];
          arrayOfByte[j + 1] = lookUpBase64Alphabet[m | b3 << 4];
          arrayOfByte[j + 2] = lookUpBase64Alphabet[n << 2];
          arrayOfByte[j + 3] = 61;
        } 
        if (paramBoolean && b2 < b1)
          System.arraycopy(CHUNK_SEPARATOR, 0, arrayOfByte, k - CHUNK_SEPARATOR.length, CHUNK_SEPARATOR.length); 
        return arrayOfByte;
      } 
      n = m * 3;
      byte b7 = paramArrayOfbyte[n];
      byte b8 = paramArrayOfbyte[n + 1];
      byte b9 = paramArrayOfbyte[n + 2];
      byte b6 = (byte)(b8 & 0xF);
      b5 = (byte)(b7 & 0x3);
      if ((b7 & Byte.MIN_VALUE) == 0) {
        n = (byte)(b7 >> 2);
      } else {
        n = (byte)(b7 >> 2 ^ 0xC0);
      } 
      if ((b8 & Byte.MIN_VALUE) == 0) {
        b3 = (byte)(b8 >> 4);
      } else {
        b3 = (byte)(b8 >> 4 ^ 0xF0);
      } 
      if ((b9 & Byte.MIN_VALUE) == 0) {
        b4 = (byte)(b9 >> 6);
      } else {
        b4 = (byte)(b9 >> 6 ^ 0xFC);
      } 
      arrayOfByte[j] = lookUpBase64Alphabet[n];
      arrayOfByte[j + 1] = lookUpBase64Alphabet[b3 | b5 << 4];
      arrayOfByte[j + 2] = lookUpBase64Alphabet[b4 | b6 << 2];
      arrayOfByte[j + 3] = lookUpBase64Alphabet[b9 & 0x3F];
      j += 4;
      if (paramBoolean && j == i) {
        System.arraycopy(CHUNK_SEPARATOR, 0, arrayOfByte, j, CHUNK_SEPARATOR.length);
        b2++;
        i = CHUNK_SEPARATOR.length;
        j += CHUNK_SEPARATOR.length;
        i = (b2 + 1) * 76 + i * b2;
      } 
      int i3 = m + 1;
      m = b8;
      b3 = b7;
      b4 = b6;
      n = b5;
      n = b4;
      n = b3;
      n = m;
      m = i3;
    } 
  }
  
  public static byte[] encodeBase64Chunked(byte[] paramArrayOfbyte) {
    return encodeBase64(paramArrayOfbyte, true);
  }
  
  public static boolean isArrayByteBase64(byte[] paramArrayOfbyte) {
    paramArrayOfbyte = discardWhitespace(paramArrayOfbyte);
    int i = paramArrayOfbyte.length;
    if (i == 0)
      return true; 
    for (byte b = 0;; b++) {
      if (b >= i)
        return true; 
      if (!isBase64(paramArrayOfbyte[b]))
        return false; 
    } 
  }
  
  private static boolean isBase64(byte paramByte) {
    return (paramByte == 61) ? true : ((base64Alphabet[paramByte] != -1));
  }
  
  public Object decode(Object paramObject) throws DecoderException {
    if (!(paramObject instanceof byte[]))
      throw new DecoderException("Parameter supplied to Base64 decode is not a byte[]"); 
    return decode((byte[])paramObject);
  }
  
  public byte[] decode(byte[] paramArrayOfbyte) {
    return decodeBase64(paramArrayOfbyte);
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    if (!(paramObject instanceof byte[]))
      throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]"); 
    return encode((byte[])paramObject);
  }
  
  public byte[] encode(byte[] paramArrayOfbyte) {
    return encodeBase64(paramArrayOfbyte, false);
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/commons/codec/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */