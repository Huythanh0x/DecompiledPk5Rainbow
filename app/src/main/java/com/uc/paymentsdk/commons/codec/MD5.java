package com.uc.paymentsdk.commons.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
   public MD5() {
      super();
   }

   public static String getMD5(String var0) throws NoSuchAlgorithmException {
      MessageDigest var1 = MessageDigest.getInstance("MD5");
      var1.update(var0.getBytes());
      return getString(var1.digest());
   }

   private static String getString(byte[] var0) {
      StringBuffer var2 = new StringBuffer();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         var2.append(var0[var1]);
      }

      return var2.toString();
   }
}
