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
      int var0;
      for(var0 = 0; var0 < 255; ++var0) {
         base64Alphabet[var0] = -1;
      }

      for(var0 = 90; var0 >= 65; --var0) {
         base64Alphabet[var0] = (byte)(var0 - 65);
      }

      for(var0 = 122; var0 >= 97; --var0) {
         base64Alphabet[var0] = (byte)(var0 - 97 + 26);
      }

      for(var0 = 57; var0 >= 48; --var0) {
         base64Alphabet[var0] = (byte)(var0 - 48 + 52);
      }

      base64Alphabet[43] = 62;
      base64Alphabet[47] = 63;

      for(var0 = 0; var0 <= 25; ++var0) {
         lookUpBase64Alphabet[var0] = (byte)(var0 + 65);
      }

      int var1 = 26;

      for(var0 = 0; var1 <= 51; ++var0) {
         lookUpBase64Alphabet[var1] = (byte)(var0 + 97);
         ++var1;
      }

      var1 = 52;

      for(var0 = 0; var1 <= 61; ++var0) {
         lookUpBase64Alphabet[var1] = (byte)(var0 + 48);
         ++var1;
      }

      lookUpBase64Alphabet[62] = 43;
      lookUpBase64Alphabet[63] = 47;
   }

   public Base64() {
      super();
   }

   public static byte[] decodeBase64(byte[] var0) {
      byte[] var8 = discardNonBase64(var0);
      if (var8.length == 0) {
         var0 = new byte[0];
      } else {
         int var4 = var8.length / 4;
         var0 = (byte[])null;
         int var2 = 0;
         int var1 = var8.length;

         while(var8[var1 - 1] == 61) {
            int var3 = var1 - 1;
            var1 = var3;
            if (var3 == 0) {
               var0 = new byte[0];
               return var0;
            }
         }

         var0 = new byte[var1 - var4];

         for(var1 = 0; var1 < var4; ++var1) {
            int var5 = var1 * 4;
            byte var7 = var8[var5 + 2];
            byte var6 = var8[var5 + 3];
            byte var9 = base64Alphabet[var8[var5]];
            byte var10 = base64Alphabet[var8[var5 + 1]];
            if (var7 != 61 && var6 != 61) {
               var7 = base64Alphabet[var7];
               var6 = base64Alphabet[var6];
               var0[var2] = (byte)(var9 << 2 | var10 >> 4);
               var0[var2 + 1] = (byte)((var10 & 15) << 4 | var7 >> 2 & 15);
               var0[var2 + 2] = (byte)(var7 << 6 | var6);
            } else if (var7 == 61) {
               var0[var2] = (byte)(var9 << 2 | var10 >> 4);
            } else if (var6 == 61) {
               var6 = base64Alphabet[var7];
               var0[var2] = (byte)(var9 << 2 | var10 >> 4);
               var0[var2 + 1] = (byte)((var10 & 15) << 4 | var6 >> 2 & 15);
            }

            var2 += 3;
         }
      }

      return var0;
   }

   static byte[] discardNonBase64(byte[] var0) {
      byte[] var3 = new byte[var0.length];
      int var2 = 0;

      for(int var1 = 0; var1 < var0.length; ++var1) {
         if (isBase64(var0[var1])) {
            var3[var2] = var0[var1];
            ++var2;
         }
      }

      var0 = new byte[var2];
      System.arraycopy(var3, 0, var0, 0, var2);
      return var0;
   }

   static byte[] discardWhitespace(byte[] var0) {
      byte[] var4 = new byte[var0.length];
      int var3 = 0;
      int var1 = 0;

      while(var1 < var0.length) {
         int var2 = var3;
         switch (var0[var1]) {
            default:
               var4[var3] = var0[var1];
               var2 = var3 + 1;
            case 9:
            case 10:
            case 13:
            case 32:
               ++var1;
               var3 = var2;
         }
      }

      var0 = new byte[var3];
      System.arraycopy(var4, 0, var0, 0, var3);
      return var0;
   }

   public static byte[] encodeBase64(byte[] var0) {
      return encodeBase64(var0, false);
   }

   public static byte[] encodeBase64(byte[] var0, boolean var1) {
      int var2 = var0.length * 8;
      int var16 = var2 % 24;
      int var17 = var2 / 24;
      byte[] var18 = (byte[])null;
      if (var16 != 0) {
         var2 = (var17 + 1) * 4;
      } else {
         var2 = var17 * 4;
      }

      int var3;
      int var4;
      int var5;
      if (var1) {
         if (CHUNK_SEPARATOR.length == 0) {
            var3 = 0;
         } else {
            var3 = (int)Math.ceil((double)((float)var2 / 76.0F));
         }

         var5 = CHUNK_SEPARATOR.length;
         var4 = var3;
         var5 = var2 + var5 * var3;
      } else {
         var4 = 0;
         var5 = var2;
      }

      var18 = new byte[var5];
      boolean var10 = false;
      boolean var9 = false;
      boolean var11 = false;
      boolean var8 = false;
      int var6 = 0;
      var2 = 76;
      int var7 = 0;

      int var15;
      byte var22;
      byte var23;
      for(var3 = 0; var7 < var17; var7 = var15) {
         int var21 = var7 * 3;
         byte var13 = var0[var21];
         byte var14 = var0[var21 + 1];
         var15 = var0[var21 + 2];
         byte var12 = (byte)(var14 & 15);
         byte var25 = (byte)(var13 & 3);
         if ((var13 & -128) == 0) {
            var22 = (byte)(var13 >> 2);
         } else {
            var22 = (byte)(var13 >> 2 ^ 192);
         }

         if ((var14 & -128) == 0) {
            var23 = (byte)(var14 >> 4);
         } else {
            var23 = (byte)(var14 >> 4 ^ 240);
         }

         byte var24;
         if ((var15 & -128) == 0) {
            var24 = (byte)(var15 >> 6);
         } else {
            var24 = (byte)(var15 >> 6 ^ 252);
         }

         var18[var3] = lookUpBase64Alphabet[var22];
         var18[var3 + 1] = lookUpBase64Alphabet[var23 | var25 << 4];
         var18[var3 + 2] = lookUpBase64Alphabet[var24 | var12 << 2];
         var18[var3 + 3] = lookUpBase64Alphabet[var15 & 63];
         var3 += 4;
         if (var1 && var3 == var2) {
            System.arraycopy(CHUNK_SEPARATOR, 0, var18, var3, CHUNK_SEPARATOR.length);
            ++var6;
            var2 = CHUNK_SEPARATOR.length;
            var3 += CHUNK_SEPARATOR.length;
            var2 = (var6 + 1) * 76 + var2 * var6;
         }

         var15 = var7 + 1;
      }

      var7 *= 3;
      byte var19;
      byte var20;
      if (var16 == 8) {
         var19 = var0[var7];
         var20 = (byte)(var19 & 3);
         if ((var19 & -128) == 0) {
            var19 = (byte)(var19 >> 2);
         } else {
            var19 = (byte)(var19 >> 2 ^ 192);
         }

         var18[var3] = lookUpBase64Alphabet[var19];
         var18[var3 + 1] = lookUpBase64Alphabet[var20 << 4];
         var18[var3 + 2] = 61;
         var18[var3 + 3] = 61;
      } else if (var16 == 16) {
         var19 = var0[var7];
         var20 = var0[var7 + 1];
         var22 = (byte)(var20 & 15);
         var23 = (byte)(var19 & 3);
         if ((var19 & -128) == 0) {
            var19 = (byte)(var19 >> 2);
         } else {
            var19 = (byte)(var19 >> 2 ^ 192);
         }

         if ((var20 & -128) == 0) {
            var20 = (byte)(var20 >> 4);
         } else {
            var20 = (byte)(var20 >> 4 ^ 240);
         }

         var18[var3] = lookUpBase64Alphabet[var19];
         var18[var3 + 1] = lookUpBase64Alphabet[var20 | var23 << 4];
         var18[var3 + 2] = lookUpBase64Alphabet[var22 << 2];
         var18[var3 + 3] = 61;
      }

      if (var1 && var6 < var4) {
         System.arraycopy(CHUNK_SEPARATOR, 0, var18, var5 - CHUNK_SEPARATOR.length, CHUNK_SEPARATOR.length);
      }

      return var18;
   }

   public static byte[] encodeBase64Chunked(byte[] var0) {
      return encodeBase64(var0, true);
   }

   public static boolean isArrayByteBase64(byte[] var0) {
      var0 = discardWhitespace(var0);
      int var2 = var0.length;
      boolean var3;
      if (var2 == 0) {
         var3 = true;
      } else {
         for(int var1 = 0; var1 < var2; ++var1) {
            if (!isBase64(var0[var1])) {
               var3 = false;
               return var3;
            }
         }

         var3 = true;
      }

      return var3;
   }

   private static boolean isBase64(byte var0) {
      boolean var1;
      if (var0 == 61) {
         var1 = true;
      } else if (base64Alphabet[var0] != -1) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public Object decode(Object var1) throws DecoderException {
      if (!(var1 instanceof byte[])) {
         throw new DecoderException("Parameter supplied to Base64 decode is not a byte[]");
      } else {
         return this.decode((byte[])var1);
      }
   }

   public byte[] decode(byte[] var1) {
      return decodeBase64(var1);
   }

   public Object encode(Object var1) throws EncoderException {
      if (!(var1 instanceof byte[])) {
         throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");
      } else {
         return this.encode((byte[])var1);
      }
   }

   public byte[] encode(byte[] var1) {
      return encodeBase64(var1, false);
   }
}
