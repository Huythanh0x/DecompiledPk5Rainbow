package com.uc.paymentsdk.commons.codec;

public class Hex implements BinaryEncoder, BinaryDecoder {
   private static final char[] DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

   public Hex() {
      super();
   }

   public static byte[] decodeHex(char[] var0) throws DecoderException {
      int var3 = var0.length;
      if ((var3 & 1) != 0) {
         throw new DecoderException("Odd number of characters.");
      } else {
         byte[] var6 = new byte[var3 >> 1];
         int var1 = 0;

         for(int var2 = 0; var2 < var3; ++var1) {
            int var4 = toDigit(var0[var2], var2);
            ++var2;
            int var5 = toDigit(var0[var2], var2);
            ++var2;
            var6[var1] = (byte)((var4 << 4 | var5) & 255);
         }

         return var6;
      }
   }

   public static char[] encodeHex(byte[] var0) {
      int var3 = var0.length;
      char[] var5 = new char[var3 << 1];
      int var1 = 0;

      for(int var2 = 0; var1 < var3; ++var1) {
         int var4 = var2 + 1;
         var5[var2] = DIGITS[(var0[var1] & 240) >>> 4];
         var2 = var4 + 1;
         var5[var4] = DIGITS[var0[var1] & 15];
      }

      return var5;
   }

   protected static int toDigit(char var0, int var1) throws DecoderException {
      int var2 = Character.digit(var0, 16);
      if (var2 == -1) {
         throw new DecoderException("Illegal hexadecimal charcter " + var0 + " at index " + var1);
      } else {
         return var2;
      }
   }

   public Object decode(Object param1) throws DecoderException {
      // $FF: Couldn't be decompiled
   }

   public byte[] decode(byte[] var1) throws DecoderException {
      return decodeHex((new String(var1)).toCharArray());
   }

   public Object encode(Object param1) throws EncoderException {
      // $FF: Couldn't be decompiled
   }

   public byte[] encode(byte[] var1) {
      return (new String(encodeHex(var1))).getBytes();
   }
}
