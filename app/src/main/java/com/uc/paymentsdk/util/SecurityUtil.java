package com.uc.paymentsdk.util;

import com.uc.paymentsdk.commons.codec.Base64;
import com.uc.paymentsdk.commons.codec.Crypter;

public class SecurityUtil
{
    public static final String KEY_HTTP_CHARGE_ALIPAY_AND_G = "6R4ya0Nee7aLgl4k";
    private static final byte[] SECRET_KEY_HTTP;
    private static final byte[] SECRET_KEY_HTTP_CHARGE;
    public static final byte[] SECRET_KEY_HTTP_CHARGE_ALIPAY;
    
    static {
        SECRET_KEY_HTTP = "sdk_mappn_201008".getBytes();
        SECRET_KEY_HTTP_CHARGE = "MAPPN-ANDY-XIAN-".getBytes();
        SECRET_KEY_HTTP_CHARGE_ALIPAY = "6R4ya0Nee7aLgl4k".getBytes();
    }
    
    public SecurityUtil() {
        super();
    }
    
    public static String decryptHttpChargeAlipayBody(final byte[] array) {
        return Utils.getUTF8String(new Crypter().decrypt(Base64.decodeBase64(array), SecurityUtil.SECRET_KEY_HTTP_CHARGE_ALIPAY));
    }
    
    public static byte[] encryptHttpBody(final String s) {
        return Base64.encodeBase64(new Crypter().encrypt(Utils.getUTF8Bytes(s), SecurityUtil.SECRET_KEY_HTTP));
    }
    
    public static byte[] encryptHttpChargeAlipayBody(final String s) {
        return Base64.encodeBase64(new Crypter().encrypt(Utils.getUTF8Bytes(s), SecurityUtil.SECRET_KEY_HTTP_CHARGE_ALIPAY));
    }
    
    public static byte[] encryptHttpChargePhoneCardBody(final String s) {
        return new Crypter().encrypt(Utils.getUTF8Bytes(s), SecurityUtil.SECRET_KEY_HTTP_CHARGE);
    }
}
