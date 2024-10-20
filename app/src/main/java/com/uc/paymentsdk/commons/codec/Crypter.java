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

   public Crypter() {
      super();
   }

   private byte[] decipher(byte[] var1) {
      return this.decipher(var1, 0);
   }

   private byte[] decipher(byte[] var1, int var2) {
      long var7 = getUnsignedInt(var1, var2, 4);
      long var5 = getUnsignedInt(var1, var2 + 4, 4);
      long var15 = getUnsignedInt(this.key, 0, 4);
      long var13 = getUnsignedInt(this.key, 4, 4);
      long var11 = getUnsignedInt(this.key, 8, 4);
      long var9 = getUnsignedInt(this.key, 12, 4);
      long var3 = -478700656L & 4294967295L;

      for(var2 = 16; var2 > 0; --var2) {
         var5 = var5 - ((var7 << 4) + var11 ^ var7 + var3 ^ (var7 >>> 5) + var9) & 4294967295L;
         var7 = var7 - ((var5 << 4) + var15 ^ var5 + var3 ^ (var5 >>> 5) + var13) & 4294967295L;
         var3 = var3 - (-1640531527L & 4294967295L) & 4294967295L;
      }

      this.baos.reset();
      this.writeInt((int)var7);
      this.writeInt((int)var5);
      return this.baos.toByteArray();
   }

   private boolean decrypt8Bytes(byte[] var1, int var2, int var3) {
      this.pos = 0;

      boolean var5;
      while(true) {
         if (this.pos >= 8) {
            this.prePlain = this.decipher(this.prePlain);
            if (this.prePlain == null) {
               var5 = false;
            } else {
               this.contextStart += 8;
               this.crypt += 8;
               this.pos = 0;
               var5 = true;
            }
            break;
         }

         if (this.contextStart + this.pos >= var3) {
            var5 = true;
            break;
         }

         int var4 = this.pos;
         byte[] var6 = this.prePlain;
         var6[var4] ^= var1[this.crypt + var2 + this.pos];
         ++this.pos;
      }

      return var5;
   }

   private byte[] encipher(byte[] var1) {
      long var5 = getUnsignedInt(var1, 0, 4);
      long var3 = getUnsignedInt(var1, 4, 4);
      long var9 = getUnsignedInt(this.key, 0, 4);
      long var11 = getUnsignedInt(this.key, 4, 4);
      long var15 = getUnsignedInt(this.key, 8, 4);
      long var13 = getUnsignedInt(this.key, 12, 4);
      long var7 = 0L;

      for(int var2 = 16; var2 > 0; --var2) {
         var7 = var7 + (-1640531527L & 4294967295L) & 4294967295L;
         var5 = var5 + ((var3 << 4) + var9 ^ var3 + var7 ^ (var3 >>> 5) + var11) & 4294967295L;
         var3 = var3 + ((var5 << 4) + var15 ^ var5 + var7 ^ (var5 >>> 5) + var13) & 4294967295L;
      }

      this.baos.reset();
      this.writeInt((int)var5);
      this.writeInt((int)var3);
      return this.baos.toByteArray();
   }

   private void encrypt8Bytes() {
      int var1;
      byte[] var2;
      for(this.pos = 0; this.pos < 8; ++this.pos) {
         if (this.header) {
            var1 = this.pos;
            var2 = this.plain;
            var2[var1] ^= this.prePlain[this.pos];
         } else {
            var1 = this.pos;
            var2 = this.plain;
            var2[var1] ^= this.out[this.preCrypt + this.pos];
         }
      }

      System.arraycopy(this.encipher(this.plain), 0, this.out, this.crypt, 8);

      for(this.pos = 0; this.pos < 8; ++this.pos) {
         var1 = this.crypt + this.pos;
         var2 = this.out;
         var2[var1] ^= this.prePlain[this.pos];
      }

      System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
      this.preCrypt = this.crypt;
      this.crypt += 8;
      this.pos = 0;
      this.header = false;
   }

   private static long getUnsignedInt(byte[] var0, int var1, int var2) {
      long var3 = 0L;
      if (var2 > 8) {
         var2 = var1 + 8;
      } else {
         var2 += var1;
      }

      while(var1 < var2) {
         var3 = var3 << 8 | (long)(var0[var1] & 255);
         ++var1;
      }

      return -1L & var3 | var3 >>> 32;
   }

   private int rand() {
      return random.nextInt();
   }

   private void writeInt(int var1) {
      this.baos.write(var1 >>> 24);
      this.baos.write(var1 >>> 16);
      this.baos.write(var1 >>> 8);
      this.baos.write(var1);
   }

   public byte[] decrypt(byte[] var1, int var2, int var3, byte[] var4) {
      if (var4 == null) {
         var1 = null;
      } else {
         this.preCrypt = 0;
         this.crypt = 0;
         this.key = var4;
         var4 = new byte[var2 + 8];
         if (var3 % 8 == 0 && var3 >= 16) {
            this.prePlain = this.decipher(var1, var2);
            this.pos = this.prePlain[0] & 7;
            int var6 = var3 - this.pos - 10;
            if (var6 < 0) {
               var1 = null;
            } else {
               int var5;
               for(var5 = var2; var5 < var4.length; ++var5) {
                  var4[var5] = 0;
               }

               this.out = new byte[var6];
               this.preCrypt = 0;
               this.crypt = 8;
               this.contextStart = 8;
               ++this.pos;
               this.padding = 1;

               while(this.padding <= 2) {
                  if (this.pos < 8) {
                     ++this.pos;
                     ++this.padding;
                  }

                  if (this.pos == 8) {
                     var4 = var1;
                     if (!this.decrypt8Bytes(var1, var2, var3)) {
                        var1 = null;
                        return var1;
                     }
                  }
               }

               int var7 = 0;

               while(var6 != 0) {
                  int var8 = var6;
                  var5 = var7;
                  if (this.pos < 8) {
                     this.out[var7] = (byte)(var4[this.preCrypt + var2 + this.pos] ^ this.prePlain[this.pos]);
                     var5 = var7 + 1;
                     var8 = var6 - 1;
                     ++this.pos;
                  }

                  var6 = var8;
                  var7 = var5;
                  if (this.pos == 8) {
                     var4 = var1;
                     this.preCrypt = this.crypt - 8;
                     var6 = var8;
                     var7 = var5;
                     if (!this.decrypt8Bytes(var1, var2, var3)) {
                        var1 = null;
                        return var1;
                     }
                  }
               }

               this.padding = 1;

               while(true) {
                  if (this.padding >= 8) {
                     var1 = this.out;
                     break;
                  }

                  if (this.pos < 8) {
                     if ((var4[this.preCrypt + var2 + this.pos] ^ this.prePlain[this.pos]) != 0) {
                        var1 = null;
                        break;
                     }

                     ++this.pos;
                  }

                  if (this.pos == 8) {
                     var4 = var1;
                     this.preCrypt = this.crypt;
                     if (!this.decrypt8Bytes(var1, var2, var3)) {
                        var1 = null;
                        break;
                     }
                  }

                  ++this.padding;
               }
            }
         } else {
            var1 = null;
         }
      }

      return var1;
   }

   public byte[] decrypt(byte[] var1, byte[] var2) {
      return this.decrypt(var1, 0, var1.length, var2);
   }

   public byte[] encrypt(byte[] var1, int var2, int var3, byte[] var4) {
      if (var4 != null) {
         this.plain = new byte[8];
         this.prePlain = new byte[8];
         this.pos = 1;
         this.padding = 0;
         this.preCrypt = 0;
         this.crypt = 0;
         this.key = var4;
         this.header = true;
         this.pos = (var3 + 10) % 8;
         if (this.pos != 0) {
            this.pos = 8 - this.pos;
         }

         this.out = new byte[this.pos + var3 + 10];
         this.plain[0] = (byte)(this.rand() & 248 | this.pos);

         int var5;
         for(var5 = 1; var5 <= this.pos; ++var5) {
            this.plain[var5] = (byte)(this.rand() & 255);
         }

         ++this.pos;

         for(var5 = 0; var5 < 8; ++var5) {
            this.prePlain[var5] = 0;
         }

         this.padding = 1;

         while(this.padding <= 2) {
            if (this.pos < 8) {
               var4 = this.plain;
               var5 = this.pos++;
               var4[var5] = (byte)(this.rand() & 255);
               ++this.padding;
            }

            if (this.pos == 8) {
               this.encrypt8Bytes();
            }
         }

         while(var3 > 0) {
            if (this.pos < 8) {
               var4 = this.plain;
               int var6 = this.pos++;
               var5 = var2 + 1;
               var4[var6] = var1[var2];
               --var3;
               var2 = var5;
            }

            if (this.pos == 8) {
               this.encrypt8Bytes();
            }
         }

         this.padding = 1;

         while(this.padding <= 7) {
            if (this.pos < 8) {
               var1 = this.plain;
               var2 = this.pos++;
               var1[var2] = 0;
               ++this.padding;
            }

            if (this.pos == 8) {
               this.encrypt8Bytes();
            }
         }

         var1 = this.out;
      }

      return var1;
   }

   public byte[] encrypt(byte[] var1, byte[] var2) {
      return this.encrypt(var1, 0, var1.length, var2);
   }
}
