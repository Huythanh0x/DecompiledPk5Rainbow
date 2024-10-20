package com.uc.paymentsdk.commons.codec;

import java.io.ByteArrayOutputStream;
import java.util.Random;

public class Crypter {
  private static Random random = new Random();
  
  private ByteArrayOutputStream baos = new ByteArrayOutputStream(8);
  
  private int contextStart;
  
  private int crypt;
  
  private boolean header = true;
  
  private byte[] key;
  
  private byte[] out;
  
  private int padding;
  
  private byte[] plain;
  
  private int pos;
  
  private int preCrypt;
  
  private byte[] prePlain;
  
  private byte[] decipher(byte[] paramArrayOfbyte) {
    return decipher(paramArrayOfbyte, 0);
  }
  
  private byte[] decipher(byte[] paramArrayOfbyte, int paramInt) {
    long l2 = getUnsignedInt(paramArrayOfbyte, paramInt, 4);
    long l3 = getUnsignedInt(paramArrayOfbyte, paramInt + 4, 4);
    long l7 = getUnsignedInt(this.key, 0, 4);
    long l5 = getUnsignedInt(this.key, 4, 4);
    long l6 = getUnsignedInt(this.key, 8, 4);
    long l4 = getUnsignedInt(this.key, 12, 4);
    long l1 = 0xFFFFFFFFE3779B90L & 0xFFFFFFFFL;
    for (paramInt = 16;; paramInt--) {
      if (paramInt <= 0) {
        this.baos.reset();
        writeInt((int)l2);
        writeInt((int)l3);
        return this.baos.toByteArray();
      } 
      l3 = l3 - ((l2 << 4L) + l6 ^ l2 + l1 ^ (l2 >>> 5L) + l4) & 0xFFFFFFFFL;
      l2 = l2 - ((l3 << 4L) + l7 ^ l3 + l1 ^ (l3 >>> 5L) + l5) & 0xFFFFFFFFL;
      l1 = l1 - (0xFFFFFFFF9E3779B9L & 0xFFFFFFFFL) & 0xFFFFFFFFL;
    } 
  }
  
  private boolean decrypt8Bytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.pos = 0;
    while (true) {
      if (this.pos >= 8) {
        this.prePlain = decipher(this.prePlain);
        if (this.prePlain == null)
          return false; 
      } else {
        if (this.contextStart + this.pos >= paramInt2)
          return true; 
        int i = this.pos;
        byte[] arrayOfByte = this.prePlain;
        arrayOfByte[i] = (byte)(arrayOfByte[i] ^ paramArrayOfbyte[this.crypt + paramInt1 + this.pos]);
        this.pos++;
        continue;
      } 
      this.contextStart += 8;
      this.crypt += 8;
      this.pos = 0;
      return true;
    } 
  }
  
  private byte[] encipher(byte[] paramArrayOfbyte) {
    long l2 = getUnsignedInt(paramArrayOfbyte, 0, 4);
    long l1 = getUnsignedInt(paramArrayOfbyte, 4, 4);
    long l4 = getUnsignedInt(this.key, 0, 4);
    long l5 = getUnsignedInt(this.key, 4, 4);
    long l7 = getUnsignedInt(this.key, 8, 4);
    long l6 = getUnsignedInt(this.key, 12, 4);
    long l3 = 0L;
    for (byte b = 16;; b--) {
      if (b <= 0) {
        this.baos.reset();
        writeInt((int)l2);
        writeInt((int)l1);
        return this.baos.toByteArray();
      } 
      l3 = l3 + (0xFFFFFFFF9E3779B9L & 0xFFFFFFFFL) & 0xFFFFFFFFL;
      l2 = l2 + ((l1 << 4L) + l4 ^ l1 + l3 ^ (l1 >>> 5L) + l5) & 0xFFFFFFFFL;
      l1 = l1 + ((l2 << 4L) + l7 ^ l2 + l3 ^ (l2 >>> 5L) + l6) & 0xFFFFFFFFL;
    } 
  }
  
  private void encrypt8Bytes() {
    this.pos = 0;
    while (true) {
      if (this.pos >= 8) {
        System.arraycopy(encipher(this.plain), 0, this.out, this.crypt, 8);
        this.pos = 0;
        while (true) {
          if (this.pos >= 8) {
            System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
            this.preCrypt = this.crypt;
            this.crypt += 8;
            this.pos = 0;
            this.header = false;
            return;
          } 
          int i = this.crypt + this.pos;
          byte[] arrayOfByte = this.out;
          arrayOfByte[i] = (byte)(arrayOfByte[i] ^ this.prePlain[this.pos]);
          this.pos++;
        } 
        break;
      } 
      if (this.header) {
        int i = this.pos;
        byte[] arrayOfByte = this.plain;
        arrayOfByte[i] = (byte)(arrayOfByte[i] ^ this.prePlain[this.pos]);
      } else {
        int i = this.pos;
        byte[] arrayOfByte = this.plain;
        arrayOfByte[i] = (byte)(arrayOfByte[i] ^ this.out[this.preCrypt + this.pos]);
      } 
      this.pos++;
    } 
  }
  
  private static long getUnsignedInt(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    long l = 0L;
    if (paramInt2 > 8) {
      paramInt2 = paramInt1 + 8;
    } else {
      paramInt2 = paramInt1 + paramInt2;
    } 
    while (true) {
      if (paramInt1 >= paramInt2)
        return 0xFFFFFFFFFFFFFFFFL & l | l >>> 32L; 
      l = l << 8L | (paramArrayOfbyte[paramInt1] & 0xFF);
      paramInt1++;
    } 
  }
  
  private int rand() {
    return random.nextInt();
  }
  
  private void writeInt(int paramInt) {
    this.baos.write(paramInt >>> 24);
    this.baos.write(paramInt >>> 16);
    this.baos.write(paramInt >>> 8);
    this.baos.write(paramInt);
  }
  
  public byte[] decrypt(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2) {
    if (paramArrayOfbyte2 == null)
      return null; 
    this.preCrypt = 0;
    this.crypt = 0;
    this.key = paramArrayOfbyte2;
    paramArrayOfbyte2 = new byte[paramInt1 + 8];
    if (paramInt2 % 8 != 0 || paramInt2 < 16)
      return null; 
    this.prePlain = decipher(paramArrayOfbyte1, paramInt1);
    this.pos = this.prePlain[0] & 0x7;
    int j = paramInt2 - this.pos - 10;
    if (j < 0)
      return null; 
    for (int i = paramInt1;; i++) {
      if (i >= paramArrayOfbyte2.length) {
        this.out = new byte[j];
        this.preCrypt = 0;
        this.crypt = 8;
        this.contextStart = 8;
        this.pos++;
        this.padding = 1;
        while (true) {
          if (this.padding > 2) {
            int k = 0;
            i = j;
            while (true) {
              if (i == 0) {
                this.padding = 1;
                while (true) {
                  if (this.padding >= 8)
                    return this.out; 
                  if (this.pos < 8) {
                    if ((paramArrayOfbyte2[this.preCrypt + paramInt1 + this.pos] ^ this.prePlain[this.pos]) != 0)
                      return null; 
                    this.pos++;
                  } 
                  if (this.pos == 8) {
                    paramArrayOfbyte2 = paramArrayOfbyte1;
                    this.preCrypt = this.crypt;
                    if (!decrypt8Bytes(paramArrayOfbyte1, paramInt1, paramInt2))
                      return null; 
                  } 
                  this.padding++;
                } 
                break;
              } 
              int m = i;
              j = k;
              if (this.pos < 8) {
                this.out[k] = (byte)(paramArrayOfbyte2[this.preCrypt + paramInt1 + this.pos] ^ this.prePlain[this.pos]);
                j = k + 1;
                m = i - 1;
                this.pos++;
              } 
              i = m;
              k = j;
              if (this.pos == 8) {
                paramArrayOfbyte2 = paramArrayOfbyte1;
                this.preCrypt = this.crypt - 8;
                i = m;
                k = j;
                if (!decrypt8Bytes(paramArrayOfbyte1, paramInt1, paramInt2))
                  return null; 
              } 
            } 
          } 
          if (this.pos < 8) {
            this.pos++;
            this.padding++;
          } 
          if (this.pos == 8) {
            paramArrayOfbyte2 = paramArrayOfbyte1;
            if (!decrypt8Bytes(paramArrayOfbyte1, paramInt1, paramInt2))
              return null; 
          } 
        } 
      } 
      paramArrayOfbyte2[i] = 0;
    } 
  }
  
  public byte[] decrypt(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    return decrypt(paramArrayOfbyte1, 0, paramArrayOfbyte1.length, paramArrayOfbyte2);
  }
  
  public byte[] encrypt(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2) {
    if (paramArrayOfbyte2 != null) {
      this.plain = new byte[8];
      this.prePlain = new byte[8];
      this.pos = 1;
      this.padding = 0;
      this.preCrypt = 0;
      this.crypt = 0;
      this.key = paramArrayOfbyte2;
      this.header = true;
      this.pos = (paramInt2 + 10) % 8;
      if (this.pos != 0)
        this.pos = 8 - this.pos; 
      this.out = new byte[this.pos + paramInt2 + 10];
      this.plain[0] = (byte)(rand() & 0xF8 | this.pos);
      for (int i = 1;; i++) {
        if (i > this.pos) {
          this.pos++;
          for (i = 0;; i++) {
            if (i >= 8) {
              this.padding = 1;
              while (true) {
                if (this.padding > 2) {
                  while (true) {
                    if (paramInt2 <= 0) {
                      this.padding = 1;
                      while (true) {
                        if (this.padding > 7)
                          return this.out; 
                        if (this.pos < 8) {
                          paramArrayOfbyte1 = this.plain;
                          paramInt1 = this.pos;
                          this.pos = paramInt1 + 1;
                          paramArrayOfbyte1[paramInt1] = 0;
                          this.padding++;
                        } 
                        if (this.pos == 8)
                          encrypt8Bytes(); 
                      } 
                      break;
                    } 
                    if (this.pos < 8) {
                      paramArrayOfbyte2 = this.plain;
                      int j = this.pos;
                      this.pos = j + 1;
                      i = paramInt1 + 1;
                      paramArrayOfbyte2[j] = paramArrayOfbyte1[paramInt1];
                      paramInt2--;
                      paramInt1 = i;
                    } 
                    if (this.pos != 8)
                      continue; 
                    encrypt8Bytes();
                  } 
                  break;
                } 
                if (this.pos < 8) {
                  paramArrayOfbyte2 = this.plain;
                  i = this.pos;
                  this.pos = i + 1;
                  paramArrayOfbyte2[i] = (byte)(rand() & 0xFF);
                  this.padding++;
                } 
                if (this.pos == 8)
                  encrypt8Bytes(); 
              } 
            } 
            this.prePlain[i] = 0;
          } 
          break;
        } 
        this.plain[i] = (byte)(rand() & 0xFF);
      } 
    } 
    return paramArrayOfbyte1;
  }
  
  public byte[] encrypt(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    return encrypt(paramArrayOfbyte1, 0, paramArrayOfbyte1.length, paramArrayOfbyte2);
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/commons/codec/Crypter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */