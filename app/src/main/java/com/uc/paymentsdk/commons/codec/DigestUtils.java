package com.uc.paymentsdk.commons.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils {
   public DigestUtils() {
      super();
   }

   static MessageDigest getDigest(String var0) {
      try {
         MessageDigest var2 = MessageDigest.getInstance(var0);
         return var2;
      } catch (NoSuchAlgorithmException var1) {
         throw new RuntimeException(var1.getMessage());
      }
   }

   private static MessageDigest getMd5Digest() {
      return getDigest("MD5");
   }

   private static MessageDigest getShaDigest() {
      return getDigest("SHA");
   }

   public static byte[] md5(String var0) {
      return md5(var0.getBytes());
   }

   public static byte[] md5(byte[] var0) {
      return getMd5Digest().digest(var0);
   }

   public static String md5Hex(String var0) {
      return new String(Hex.encodeHex(md5(var0)));
   }

   public static String md5Hex(byte[] var0) {
      return new String(Hex.encodeHex(md5(var0)));
   }

   public static byte[] sha(String var0) {
      return sha(var0.getBytes());
   }

   public static byte[] sha(byte[] var0) {
      return getShaDigest().digest(var0);
   }

   public static String shaHex(String var0) {
      return new String(Hex.encodeHex(sha(var0)));
   }

   public static String shaHex(byte[] var0) {
      return new String(Hex.encodeHex(sha(var0)));
   }
}
