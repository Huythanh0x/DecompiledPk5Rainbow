package com.uc.paymentsdk.commons.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils {
  static MessageDigest getDigest(String paramString) {
    try {
      return MessageDigest.getInstance(paramString);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new RuntimeException(noSuchAlgorithmException.getMessage());
    } 
  }
  
  private static MessageDigest getMd5Digest() {
    return getDigest("MD5");
  }
  
  private static MessageDigest getShaDigest() {
    return getDigest("SHA");
  }
  
  public static byte[] md5(String paramString) {
    return md5(paramString.getBytes());
  }
  
  public static byte[] md5(byte[] paramArrayOfbyte) {
    return getMd5Digest().digest(paramArrayOfbyte);
  }
  
  public static String md5Hex(String paramString) {
    return new String(Hex.encodeHex(md5(paramString)));
  }
  
  public static String md5Hex(byte[] paramArrayOfbyte) {
    return new String(Hex.encodeHex(md5(paramArrayOfbyte)));
  }
  
  public static byte[] sha(String paramString) {
    return sha(paramString.getBytes());
  }
  
  public static byte[] sha(byte[] paramArrayOfbyte) {
    return getShaDigest().digest(paramArrayOfbyte);
  }
  
  public static String shaHex(String paramString) {
    return new String(Hex.encodeHex(sha(paramString)));
  }
  
  public static String shaHex(byte[] paramArrayOfbyte) {
    return new String(Hex.encodeHex(sha(paramArrayOfbyte)));
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/commons/codec/DigestUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */