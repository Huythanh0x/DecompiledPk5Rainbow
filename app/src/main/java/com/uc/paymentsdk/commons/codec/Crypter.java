package com.uc.paymentsdk.commons.codec.Crypter;
import java.util.Random;
import java.lang.Object;
import java.io.ByteArrayOutputStream;
import java.lang.System;

public class Crypter	// class@000088 from classes.dex
{
    private ByteArrayOutputStream baos;
    private int contextStart;
    private int crypt;
    private boolean header;
    private byte[] key;
    private byte[] out;
    private int padding;
    private byte[] plain;
    private int pos;
    private int preCrypt;
    private byte[] prePlain;
    private static Random random;

    static {
       Crypter.random = new Random();
    }
    public void Crypter(){
       super();
       this.header = true;
       this.baos = new ByteArrayOutputStream(8);
    }
    private byte[] decipher(byte[] paramArrayOfByte){
       return this.decipher(paramArrayOfByte, 0);
    }
    private byte[] decipher(byte[] paramArrayOfByte,int paramInt){
       int i = 16;
       long long l1 = Crypter.getUnsignedInt(paramArrayOfByte, paramInt, 4);
       long l2 = Crypter.getUnsignedInt(paramArrayOfByte, (paramInt + 4), 4);
       long l3 = Crypter.getUnsignedInt(this.key, 0, 4);
       long l4 = Crypter.getUnsignedInt(this.key, 4, 4);
       long l5 = Crypter.getUnsignedInt(this.key, 8, 4);
       long l6 = Crypter.getUnsignedInt(this.key, 12, 4);
       long l7 = -478700656;
       l7 = l7 & 0xffffffff;
       long l8 = -1640531527;
       l8 = l8 & 0xffffffff;
       i = i;
       while (true) {
          i = i - 1;
          if (i <= 0) {
             break ;
          }else {
             long l = l1 << 4;
             l = l + l5;
             l1 = l1 + l7;
             l = l ^ l1;
             l1 = l1 >> 5;
             l1 = l1 + l6;
             l = l ^ l1;
             l2 = l2 - l;
             l2 = l2 & 0xffffffff;
             l = l2 << 4;
             l = l + l3;
             l1 = l2 + l7;
             l = l ^ l1;
             l1 = l2 >> 5;
             l1 = l1 + l4;
             l = l ^ l1;
             l1 = l1 - l;
             l1 = l1 & 0xffffffff;
             l7 = l7 - l8;
             l7 = l7 & 0xffffffff;
             i = i;
          }
       }
       this.baos.reset();
       this.writeInt((int)l1);
       this.writeInt((int)l2);
       return this.baos.toByteArray();
    }
    private boolean decrypt8Bytes(byte[] paramArrayOfByte,int paramInt1,int paramInt2){
       int i;
       this.pos = 0;
       while (true) {
          if (this.pos >= 8) {
             this.prePlain = this.decipher(this.prePlain);
             if (this.prePlain == null) {
                i = 0;
                break ;
             }else {
                this.contextStart = this.contextStart + 8;
                this.crypt = this.crypt + 8;
                this.pos = 0;
                i = true;
                break ;
             }
          }else if((i = this.contextStart + this.pos) >= paramInt2){
             i = true;
             break ;
          }else {
             int tmp37_34 = this.pos;
             byte[] tmp37_30 = this.prePlain;
             int i1 = this.crypt + paramInt1;
             i1 = i1 + this.pos;
             i = tmp37_30[tmp37_34] ^ paramArrayOfByte[i1];
             tmp37_30[tmp37_34] = (byte)i;
             i = this.pos + 1;
             this.pos = i;
          }
       }
       return i;
    }
    private byte[] encipher(byte[] paramArrayOfByte){
       int i = 16;
       long long l1 = Crypter.getUnsignedInt(paramArrayOfByte, 0, 4);
       long l2 = Crypter.getUnsignedInt(paramArrayOfByte, 4, 4);
       long l3 = Crypter.getUnsignedInt(this.key, 0, 4);
       long l4 = Crypter.getUnsignedInt(this.key, 4, 4);
       long l5 = Crypter.getUnsignedInt(this.key, 8, 4);
       long l6 = Crypter.getUnsignedInt(this.key, 12, 4);
       long l7 = 0;
       long l8 = -1640531527;
       l8 = l8 & 0xffffffff;
       i = i;
       while (true) {
          i = i - 1;
          if (i <= 0) {
             break ;
          }else {
             l7 = l7 + l8;
             l7 = l7 & 0xffffffff;
             long l = l2 << 4;
             l = l + l3;
             l1 = l2 + l7;
             l = l ^ l1;
             l1 = l2 >> 5;
             l1 = l1 + l4;
             l = l ^ l1;
             l1 = l1 + l;
             l1 = l1 & 0xffffffff;
             l = l1 << 4;
             l = l + l5;
             l1 = l1 + l7;
             l = l ^ l1;
             l1 = l1 >> 5;
             l1 = l1 + l6;
             l = l ^ l1;
             l2 = l2 + l;
             l2 = l2 & 0xffffffff;
             i = i;
          }
       }
       this.baos.reset();
       this.writeInt((int)l1);
       this.writeInt((int)l2);
       return this.baos.toByteArray();
    }
    private void encrypt8Bytes(){
       int i;
       this.pos = 0;
       while (this.pos < 8) {
          if (this.header != null) {
             int tmp29_26 = this.pos;
             byte[] tmp29_22 = this.plain;
             i = tmp29_22[tmp29_26] ^ this.prePlain[this.pos];
             tmp29_22[tmp29_26] = (byte)i;
          }else {
             int tmp54_51 = this.pos;
             byte[] tmp54_47 = this.plain;
             int i1 = this.preCrypt + this.pos;
             i = tmp54_47[tmp54_51] ^ this.out[i1];
             tmp54_47[tmp54_51] = (byte)i;
          }
          i = this.pos + 1;
          this.pos = i;
       }
       byte[] arrayOfByte = this.encipher(this.plain);
       System.arraycopy(arrayOfByte, 0, this.out, this.crypt, 8);
       this.pos = 0;
       while (this.pos < 8) {
          int tmp137_136 = this.crypt + this.pos;
          byte[] tmp137_125 = this.out;
          i = tmp137_125[tmp137_136] ^ this.prePlain[this.pos];
          tmp137_125[tmp137_136] = (byte)i;
          i = this.pos + 1;
          this.pos = i;
       }
       System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
       this.preCrypt = this.crypt;
       this.crypt = this.crypt + 8;
       this.pos = 0;
       this.header = false;
       return;
    }
    private static long getUnsignedInt(byte[] paramArrayOfByte,int paramInt1,int paramInt2){
       int ix = 8;
       long l = 0;
       int i = 0;
       i = (paramInt2 > ix)? paramInt1 + 8: paramInt1 + paramInt2;
       for (int j = paramInt1; j < i; j++) {
          l = l << ix;
          int ix1 = paramArrayOfByte[j] & 0x00ff;
          l = l | (long)ix1;
       }
       return ((-1 & l) | (l >> 32));
    }
    private int rand(){
       return Crypter.random.nextInt();
    }
    private void writeInt(int paramInt){
       this.baos.write((paramInt >> 24));
       this.baos.write((paramInt >> 16));
       this.baos.write((paramInt >> 8));
       this.baos.write(paramInt);
    }
    public byte[] decrypt(byte[] paramArrayOfByte1,int paramInt1,int paramInt2,byte[] paramArrayOfByte2){
       byte[] uobyteArray;
       int i;
       int ix1;
       int ix = 0;
       if (paramArrayOfByte2 == null) {
          uobyteArray = null;
       }else {
          this.preCrypt = ix;
          this.crypt = ix;
          this.key = paramArrayOfByte2;
          byte[] arrayOfByte = new byte[(paramInt1 + 8)];
          if (!((paramInt2 % 8)) && paramInt2 >= 16) {
             this.prePlain = this.decipher(paramArrayOfByte1, paramInt1);
             this.pos = this.prePlain[ix] & 0x07;
             if ((i = (paramInt2 - this.pos) - 10) < 0) {
                uobyteArray = null;
             }else {
                for (int j = paramInt1; j < arrayOfByte.length; j++) {
                   arrayOfByte[j] = ix;
                }
                uobyteArray = new byte[i];
                this.out = uobyteArray;
                this.preCrypt = ix;
                this.crypt = 8;
                this.contextStart = 8;
                this.pos = this.pos + 1;
                this.padding = 1;
                while (true) {
                   if (this.padding > 2) {
                      j = 0;
                      while (true) {
                         if (!i) {
                            this.padding = 1;
                            while (true) {
                               if (this.padding >= 8) {
                                  uobyteArray = this.out;
                                  break ;
                               }else if(this.pos < 8){
                                  ix1 = this.preCrypt + paramInt1;
                                  ix1 = ix1 + this.pos;
                                  if (ix1 = arrayOfByte[ix1] ^ this.prePlain[this.pos]) {
                                     uobyteArray = null;
                                     break ;
                                  }else {
                                     ix1 = this.pos + 1;
                                     this.pos = ix1;
                                  }
                               }
                               if (this.pos == 8) {
                                  arrayOfByte = paramArrayOfByte1;
                                  this.preCrypt = this.crypt;
                                  if (!this.decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
                                     uobyteArray = null;
                                     break ;
                                  }
                               }
                               ix1 = this.padding + 1;
                               this.padding = ix1;
                            }
                         }else if(this.pos < 8){
                            int ix2 = this.preCrypt + paramInt1;
                            ix2 = ix2 + this.pos;
                            ix2 = arrayOfByte[ix2] ^ this.prePlain[this.pos];
                            this.out[j] = (byte)ix2;
                            j++;
                            i--;
                            ix1 = this.pos + 1;
                            this.pos = ix1;
                         }
                         if (this.pos == 8) {
                            arrayOfByte = paramArrayOfByte1;
                            ix1 = this.crypt - 8;
                            this.preCrypt = ix1;
                            if (!this.decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
                               uobyteArray = null;
                               break ;
                            }else {
                               continue ;
                            }
                         }else {
                            continue ;
                         }
                      }
                   }else if(this.pos < 8){
                      ix1 = this.pos + 1;
                      this.pos = ix1;
                      ix1 = this.padding + 1;
                      this.padding = ix1;
                   }
                   if (this.pos == 8) {
                      arrayOfByte = paramArrayOfByte1;
                      if (!this.decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
                         uobyteArray = null;
                         break ;
                      }
                   }
                }
             }
          }else {
             uobyteArray = null;
          }
       }
       return uobyteArray;
    }
    public byte[] decrypt(byte[] paramArrayOfByte1,byte[] paramArrayOfByte2){
       return this.decrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
    }
    public byte[] encrypt(byte[] paramArrayOfByte1,int paramInt1,int paramInt2,byte[] paramArrayOfByte2){
       byte[] uobyteArray;
       Crypter tpos;
       int ix;
       int ix1;
       if (paramArrayOfByte2 == null) {
          uobyteArray = paramArrayOfByte1;
       }else {
          uobyteArray = new byte[8];
          this.plain = uobyteArray;
          uobyteArray = new byte[8];
          this.prePlain = uobyteArray;
          this.pos = 1;
          this.padding = 0;
          this.preCrypt = 0;
          this.crypt = 0;
          this.key = paramArrayOfByte2;
          this.header = true;
          this.pos = (paramInt2 + 10) % 8;
          if (this.pos != null) {
             this.pos = 8 - this.pos;
          }
          uobyteArray = new byte[((this.pos + paramInt2) + 10)];
          this.out = uobyteArray;
          this.plain[0] = (byte)((this.rand() & 0x00f8) | this.pos);
          int i = 1;
          while (i <= this.pos) {
             int ix2 = this.rand() & 0x00ff;
             this.plain[i] = (byte)ix2;
             i++;
          }
          this.pos = this.pos + 1;
          for (i = 0; i < 8; i++) {
             this.prePlain[i] = 0;
          }
          this.padding = 1;
          while (this.padding <= 2) {
             if (this.pos < 8) {
                tpos = this.pos;
                ix = tpos + 1;
                this.pos = ix;
                ix = this.rand() & 0x00ff;
                this.plain[tpos] = (byte)ix;
                ix1 = this.padding + 1;
                this.padding = ix1;
             }
             if (this.pos == 8) {
                this.encrypt8Bytes();
             }
          }
          i = paramInt1;
          i = i;
          while (paramInt2 > 0) {
             if (this.pos < 8) {
                tpos = this.pos;
                ix = tpos + 1;
                this.pos = ix;
                i = i + 1;
                this.plain[tpos] = paramArrayOfByte1[i];
                paramInt2--;
             }else {
                i = i;
             }
             if (this.pos != 8) {
                i = i;
             }else {
                this.encrypt8Bytes();
                i = i;
             }
          }
          this.padding = 1;
          while (this.padding <= 7) {
             if (this.pos < 8) {
                tpos = this.pos;
                ix = tpos + 1;
                this.pos = ix;
                this.plain[tpos] = 0;
                ix1 = this.padding + 1;
                this.padding = ix1;
             }
             if (this.pos == 8) {
                this.encrypt8Bytes();
             }
          }
          uobyteArray = this.out;
       }
       return uobyteArray;
    }
    public byte[] encrypt(byte[] paramArrayOfByte1,byte[] paramArrayOfByte2){
       return this.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
    }
}
