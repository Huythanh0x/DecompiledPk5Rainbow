package com.uc.paymentsdk.commons.codec.Base64;
import com.uc.paymentsdk.commons.codec.BinaryEncoder;
import com.uc.paymentsdk.commons.codec.BinaryDecoder;
import java.lang.String;
import java.lang.Object;
import java.lang.System;
import java.lang.Math;
import com.uc.paymentsdk.commons.codec.DecoderException;
import com.uc.paymentsdk.commons.codec.EncoderException;

public class Base64 implements BinaryEncoder, BinaryDecoder	// class@000085 from classes.dex
{
    static final int BASELENGTH = 255;
    static final byte[] CHUNK_SEPARATOR;
    static final int CHUNK_SIZE;
    static final int EIGHTBIT;
    static final int FOURBYTE;
    static final int LOOKUPLENGTH;
    static final byte PAD;
    static final int SIGN;
    static final int SIXTEENBIT;
    static final int TWENTYFOURBITGROUP;
    private static byte[] base64Alphabet;
    private static byte[] lookUpBase64Alphabet;

    static {
       int ix;
       Base64.CHUNK_SEPARATOR = "\r\n".getBytes();
       byte[] uobyteArray = new byte[255];
       Base64.base64Alphabet = uobyteArray;
       uobyteArray = new byte[64];
       Base64.lookUpBase64Alphabet = uobyteArray;
       for (int i = 0; i < 255; i++) {
          Base64.base64Alphabet[i] = -1;
       }
       for (i = 90; i >= 65; i--) {
          ix = i - 65;
          Base64.base64Alphabet[i] = (byte)ix;
       }
       for (i = 122; i >= 97; i--) {
          ix = i - 97;
          ix = ix + 26;
          Base64.base64Alphabet[i] = (byte)ix;
       }
       for (i = 57; i >= 48; i--) {
          ix = i - 48;
          ix = ix + 52;
          Base64.base64Alphabet[i] = (byte)ix;
       }
       Base64.base64Alphabet[43] = 62;
       Base64.base64Alphabet[47] = 63;
       i = 0;
       while (i <= 25) {
          ix = i + 65;
          Base64.lookUpBase64Alphabet[i] = (byte)ix;
          i++;
       }
       int icount = 26;
       int j = 0;
       while (icount <= 51) {
          ix = j + 97;
          Base64.lookUpBase64Alphabet[icount] = (byte)ix;
          icount++;
          j++;
       }
       icount = 52;
       j = 0;
       while (icount <= 61) {
          ix = j + 48;
          Base64.lookUpBase64Alphabet[icount] = (byte)ix;
          icount++;
          j++;
       }
       Base64.lookUpBase64Alphabet[62] = 43;
       Base64.lookUpBase64Alphabet[63] = 47;
    }
    public void Base64(){
       super();
    }
    public static byte[] decodeBase64(byte[] paramArrayOfByte){
       byte[] uobyteArray;
       int ix1;
       int ix2;
       int ix = 0;
       paramArrayOfByte = Base64.discardNonBase64(paramArrayOfByte);
       if (!paramArrayOfByte.length) {
          uobyteArray = new byte[ix];
       }else {
          int i = paramArrayOfByte.length / 4;
          int j = 0;
          int k = 0;
          int m = 0;
          int n = 0;
          int i1 = 0;
          int i2 = 0;
          int i3 = 0;
          int i4 = 0;
          int i5 = paramArrayOfByte.length;
          while (true) {
             if ((ix1 = i5 - 1) != 61) {
                byte[] arrayOfByte = new byte[(i5 - i)];
                for (i5 = 0; i5 < i; i5++) {
                   i4 = i5 * 4;
                   ix1 = i4 + 2;
                   i1 = paramArrayOfByte[ix1];
                   ix1 = i4 + 3;
                   i2 = paramArrayOfByte[ix1];
                   j = Base64.base64Alphabet[paramArrayOfByte[i4]];
                   ix = i4 + 1;
                   k = Base64.base64Alphabet[paramArrayOfByte[ix]];
                   if (i1 != 61 && i2 != 61) {
                      m = Base64.base64Alphabet[i1];
                      n = Base64.base64Alphabet[i2];
                      ix1 = j << 2;
                      ix = k >> 4;
                      ix1 = ix1 | ix;
                      arrayOfByte[i3] = (byte)ix1;
                      ix1 = i3 + 1;
                      ix = k & 0x0f;
                      ix = ix << 4;
                      ix2 = m >> 2;
                      ix2 = ix2 & 0x0f;
                      ix = ix | ix2;
                      arrayOfByte[ix1] = (byte)ix;
                      ix1 = i3 + 2;
                      ix = m << 6;
                      ix = ix | n;
                      arrayOfByte[ix1] = (byte)ix;
                   }else if(i1 == 61){
                      ix1 = j << 2;
                      ix = k >> 4;
                      ix1 = ix1 | ix;
                      arrayOfByte[i3] = (byte)ix1;
                   }else if(i2 == 61){
                      m = Base64.base64Alphabet[i1];
                      ix1 = j << 2;
                      ix = k >> 4;
                      ix1 = ix1 | ix;
                      arrayOfByte[i3] = (byte)ix1;
                      ix1 = i3 + 1;
                      ix = k & 0x0f;
                      ix = ix << 4;
                      ix2 = m >> 2;
                      ix2 = ix2 & 0x0f;
                      ix = ix | ix2;
                      arrayOfByte[ix1] = (byte)ix;
                   }
                   i3 = i3 + 3;
                }
                uobyteArray = arrayOfByte;
             }else {
                if (!(i5--)) {
                   uobyteArray = new byte[ix];
                   break ;
                }
             }
          }
       }
       return uobyteArray;
    }
    static byte[] discardNonBase64(byte[] paramArrayOfByte){
       byte[] arrayOfByte1 = new byte[paramArrayOfByte.length];
       int i = 0;
       int j = 0;
       while (j < paramArrayOfByte.length) {
          if (Base64.isBase64(paramArrayOfByte[j])) {
             i = i + 1;
             arrayOfByte1[i] = paramArrayOfByte[j];
             i = i;
          }
          j++;
       }
       byte[] arrayOfByte2 = new byte[i];
       System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
       return arrayOfByte2;
    }
    static byte[] discardWhitespace(byte[] paramArrayOfByte){
       byte[] arrayOfByte1 = new byte[paramArrayOfByte.length];
       int i = 0;
       int j = 0;
       while (j < paramArrayOfByte.length) {
          switch (paramArrayOfByte[j]){
              case 9:
              case 13:
              case 32:
              case 10:
                break;
              default:
                i = i + 1;
                arrayOfByte1[i] = paramArrayOfByte[j];
                i = i;
          }
          j++;
       }
       byte[] arrayOfByte2 = new byte[i];
       System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
       return arrayOfByte2;
    }
    public static byte[] encodeBase64(byte[] paramArrayOfByte){
       return Base64.encodeBase64(paramArrayOfByte, false);
    }
    public static byte[] encodeBase64(byte[] paramArrayOfByte,boolean paramBoolean){
       int m;
       int ix;
       int i = paramArrayOfByte.length * 8;
       int j = i % 24;
       int k = i / 24;
       i = 0;
       i = 0;
       int n = 0;
       if (j) {
          i = k + 1;
          i = i * 4;
       }else {
          i = k * 4;
       }
       if (paramBoolean) {
          n = (!(n = Base64.CHUNK_SEPARATOR))? 0: (int)Math.ceil((double)((float)i / 76.00f));
          i = i + (Base64.CHUNK_SEPARATOR.length * n);
          n = n;
          m = i;
       }else {
          n = n;
          m = i;
       }
       byte[] uobyteArray = new byte[m];
       byte[] arrayOfByte = uobyteArray;
       n = 0;
       byte i2 = 0;
       byte i3 = 0;
       byte i4 = 0;
       int i5 = 0;
       int i6 = 0;
       int i7 = 0;
       int i8 = 0;
       int i9 = 76;
       i8 = 0;
       i8 = 0;
       i9 = i9;
       i8 = i8;
       i9 = i6;
       i6 = i7;
       while (i8 < k) {
          i7 = i8 * 3;
          i6 = paramArrayOfByte[i7];
          n = i7 + 1;
          i7 = paramArrayOfByte[n];
          n = i7 + 2;
          i5 = paramArrayOfByte[n];
          n = i7 & 0x0f;
          i5 = (int)n;
          n = i6 & 0x03;
          n = (int)n;
          if (!(i2 = i6 & 0x80)) {
             i2 = i6 >> 2;
             i2 = (int)i2;
          }else {
             i2 = i6 >> 2;
             i2 = i2 ^ 0x00c0;
             i2 = (byte)i2;
          }
          if (!(i3 = i7 & 0x80)) {
             i3 = i7 >> 4;
             i3 = (int)i3;
          }else {
             i3 = i7 >> 4;
             i3 = i3 ^ 0x00f0;
             i3 = (byte)i3;
          }
          if (!(i4 = i5 & 0x80)) {
             i4 = i5 >> 6;
             i4 = (int)i4;
          }else {
             i4 = i5 >> 6;
             i4 = i4 ^ 0x00fc;
             i4 = (byte)i4;
          }
          i2 = Base64.lookUpBase64Alphabet[i2];
          arrayOfByte[i9] = i2;
          i2 = i9 + 1;
          int ix1 = n << 4;
          i3 = i3 | ix1;
          i3 = Base64.lookUpBase64Alphabet[i3];
          arrayOfByte[i2] = i3;
          i2 = i9 + 2;
          int ix2 = i5 << 2;
          i4 = i4 | ix2;
          arrayOfByte[i2] = Base64.lookUpBase64Alphabet[i4];
          i2 = i9 + 3;
          i4 = i5 & 0x3f;
          arrayOfByte[i2] = Base64.lookUpBase64Alphabet[i4];
          i2 = i9 + 4;
          if (paramBoolean) {
             if (i2 != i9) {
                i4 = i9;
             }else {
                System.arraycopy(Base64.CHUNK_SEPARATOR, 0, arrayOfByte, i2, Base64.CHUNK_SEPARATOR.length);
                i8 = i8 + 1;
                i3 = i8 + 1;
                i3 = i3 * 76;
                i4 = Base64.CHUNK_SEPARATOR.length * i8;
                i3 = i3 + i4;
                i2 = i2 + Base64.CHUNK_SEPARATOR.length;
                i4 = i3;
             }
          }else {
             i4 = i9;
          }
          i3 = i8 + 1;
          i9 = i4;
          i8 = i3;
          i9 = i2;
          i4 = i7;
          i3 = i6;
          i2 = i5;
          i5 = i5;
          i6 = i7;
       }
       i5 = i8 * 3;
       if (j == 8) {
          i3 = paramArrayOfByte[i5];
          paramArrayOfByte = i3 & 0x03;
          ix = (byte)paramArrayOfByte;
          n = (!((i3 & 0x80)))? (int)(i3 >> 2): (byte)((i3 >> 2) ^ 0x00c0);
          i5 = Base64.lookUpBase64Alphabet;
          n = i5[n];
          arrayOfByte[i9] = n;
          arrayOfByte[(i9 + 1)] = Base64.lookUpBase64Alphabet[(ix << 4)];
          arrayOfByte[(i9 + 2)] = 61;
          arrayOfByte[(i9 + 3)] = 61;
          n = i2;
          i2 = i3;
          i3 = i4;
       }else if(j == 16){
          i4 = paramArrayOfByte[i5];
          n = i5 + 1;
          i5 = paramArrayOfByte[n];
          paramArrayOfByte = i5 & 0x0f;
          i3 = (byte)paramArrayOfByte;
          paramArrayOfByte = i4 & 0x03;
          ix = (byte)paramArrayOfByte;
          n = (!((i4 & 0x80)))? (int)(i4 >> 2): (byte)((i4 >> 2) ^ 0x00c0);
          i2 = (!((i5 & 0x80)))? (int)(i5 >> 4): (byte)((i5 >> 4) ^ 0x00f0);
          n = Base64.lookUpBase64Alphabet[n];
          arrayOfByte[i9] = n;
          i2 = i2 | (ix << 4);
          i2 = Base64.lookUpBase64Alphabet[i2];
          arrayOfByte[(i9 + 1)] = i2;
          arrayOfByte[(i9 + 2)] = Base64.lookUpBase64Alphabet[(i3 << 2)];
          arrayOfByte[(i9 + 3)] = 61;
          i2 = i4;
          n = i3;
          i3 = i5;
       }else {
          ix = n;
          n = i2;
          i3 = i3;
          i3 = i4;
       }
       if (paramBoolean && i8 < n) {
          ix = Base64.CHUNK_SEPARATOR;
          paramBoolean = false;
          n = Base64.CHUNK_SEPARATOR;
          i8 = Base64.CHUNK_SEPARATOR;
          System.arraycopy(ix, paramBoolean, arrayOfByte, (m - n.length), i8.length);
       }
       return arrayOfByte;
    }
    public static byte[] encodeBase64Chunked(byte[] paramArrayOfByte){
       return Base64.encodeBase64(paramArrayOfByte, true);
    }
    public static boolean isArrayByteBase64(byte[] paramArrayOfByte){
       int i;
       boolean b;
       paramArrayOfByte = Base64.discardWhitespace(paramArrayOfByte);
       if (!(i = paramArrayOfByte.length)) {
          b = true;
       }else {
          int j = 0;
          while (true) {
             if (j >= i) {
                b = true;
                break ;
             }else if(!Base64.isBase64(paramArrayOfByte[j])){
                b = false;
                break ;
             }else {
                j++;
             }
          }
       }
       return b;
    }
    private static boolean isBase64(byte paramByte){
       boolean b;
       if (paramByte == 61) {
          b = true;
       }else if(Base64.base64Alphabet[paramByte] != -1){
          b = true;
       }else {
          b = false;
       }
       return b;
    }
    public Object decode(Object paramObject){
       if (!paramObject instanceof byte[]) {
          throw new DecoderException("Parameter supplied to Base64 decode is not a byte[]");
       }
       return this.decode(paramObject);
    }
    public byte[] decode(byte[] paramArrayOfByte){
       return Base64.decodeBase64(paramArrayOfByte);
    }
    public Object encode(Object paramObject){
       if (!paramObject instanceof byte[]) {
          throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");
       }
       return this.encode(paramObject);
    }
    public byte[] encode(byte[] paramArrayOfByte){
       return Base64.encodeBase64(paramArrayOfByte, false);
    }
}
