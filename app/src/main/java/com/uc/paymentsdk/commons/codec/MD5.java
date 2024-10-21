package com.uc.paymentsdk.commons.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
  public static String getMD5(String paramString) throws NoSuchAlgorithmException {
    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    messageDigest.update(paramString.getBytes());
    return getString(messageDigest.digest());
  }
  
  private static String getString(byte[] paramArrayOfbyte) {
    StringBuffer stringBuffer = new StringBuffer();
    for (byte b = 0;; b++) {
      if (b >= paramArrayOfbyte.length)
        return stringBuffer.toString(); 
      stringBuffer.append(paramArrayOfbyte[b]);
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/commons/codec/MD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */