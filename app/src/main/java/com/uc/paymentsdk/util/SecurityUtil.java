package com.uc.paymentsdk.util;

import com.uc.paymentsdk.commons.codec.Base64;
import com.uc.paymentsdk.commons.codec.Crypter;

public class SecurityUtil {
  public static final String KEY_HTTP_CHARGE_ALIPAY_AND_G = "6R4ya0Nee7aLgl4k";
  
  private static final byte[] SECRET_KEY_HTTP = "sdk_mappn_201008".getBytes();
  
  private static final byte[] SECRET_KEY_HTTP_CHARGE = "MAPPN-ANDY-XIAN-".getBytes();
  
  public static final byte[] SECRET_KEY_HTTP_CHARGE_ALIPAY = "6R4ya0Nee7aLgl4k".getBytes();
  
  public static String decryptHttpChargeAlipayBody(byte[] paramArrayOfbyte) {
    return Utils.getUTF8String((new Crypter()).decrypt(Base64.decodeBase64(paramArrayOfbyte), SECRET_KEY_HTTP_CHARGE_ALIPAY));
  }
  
  public static byte[] encryptHttpBody(String paramString) {
    return Base64.encodeBase64((new Crypter()).encrypt(Utils.getUTF8Bytes(paramString), SECRET_KEY_HTTP));
  }
  
  public static byte[] encryptHttpChargeAlipayBody(String paramString) {
    return Base64.encodeBase64((new Crypter()).encrypt(Utils.getUTF8Bytes(paramString), SECRET_KEY_HTTP_CHARGE_ALIPAY));
  }
  
  public static byte[] encryptHttpChargePhoneCardBody(String paramString) {
    return (new Crypter()).encrypt(Utils.getUTF8Bytes(paramString), SECRET_KEY_HTTP_CHARGE);
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/util/SecurityUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */