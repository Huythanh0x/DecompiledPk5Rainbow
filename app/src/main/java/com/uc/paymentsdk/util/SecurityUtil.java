package com.uc.paymentsdk.util;

import com.uc.paymentsdk.commons.codec.Base64;
import com.uc.paymentsdk.commons.codec.Crypter;

public class SecurityUtil {
   public static final String KEY_HTTP_CHARGE_ALIPAY_AND_G = "6R4ya0Nee7aLgl4k";
   private static final byte[] SECRET_KEY_HTTP = "sdk_mappn_201008".getBytes();
   private static final byte[] SECRET_KEY_HTTP_CHARGE = "MAPPN-ANDY-XIAN-".getBytes();
   public static final byte[] SECRET_KEY_HTTP_CHARGE_ALIPAY = "6R4ya0Nee7aLgl4k".getBytes();

   public SecurityUtil() {
      super();
   }

   public static String decryptHttpChargeAlipayBody(byte[] var0) {
      return Utils.getUTF8String((new Crypter()).decrypt(Base64.decodeBase64(var0), SECRET_KEY_HTTP_CHARGE_ALIPAY));
   }

   public static byte[] encryptHttpBody(String var0) {
      return Base64.encodeBase64((new Crypter()).encrypt(Utils.getUTF8Bytes(var0), SECRET_KEY_HTTP));
   }

   public static byte[] encryptHttpChargeAlipayBody(String var0) {
      return Base64.encodeBase64((new Crypter()).encrypt(Utils.getUTF8Bytes(var0), SECRET_KEY_HTTP_CHARGE_ALIPAY));
   }

   public static byte[] encryptHttpChargePhoneCardBody(String var0) {
      return (new Crypter()).encrypt(Utils.getUTF8Bytes(var0), SECRET_KEY_HTTP_CHARGE);
   }
}
