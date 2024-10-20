package com.uc.paymentsdk.util;

import com.uc.paymentsdk.commons.codec.Base64;
import com.uc.paymentsdk.commons.codec.Crypter;

public class SecurityUtil {
    public static final String KEY_HTTP_CHARGE_ALIPAY_AND_G = "6R4ya0Nee7aLgl4k";
    private static final byte[] SECRET_KEY_HTTP;
    private static final byte[] SECRET_KEY_HTTP_CHARGE;
    public static final byte[] SECRET_KEY_HTTP_CHARGE_ALIPAY;

    static {
        SecurityUtil.SECRET_KEY_HTTP = new byte[]{0x73, 100, 107, 0x5F, 109, 97, 0x70, 0x70, 110, 0x5F, 50, 0x30, 49, 0x30, 0x30, 56};
        SecurityUtil.SECRET_KEY_HTTP_CHARGE = new byte[]{77, 65, 80, 80, 78, 45, 65, 78, 68, 89, 45, 88, 73, 65, 78, 45};
        SecurityUtil.SECRET_KEY_HTTP_CHARGE_ALIPAY = new byte[]{54, 82, 52, 0x79, 97, 0x30, 78, 101, 101, 55, 97, 76, 103, 108, 52, 107};
    }

    public static String decryptHttpChargeAlipayBody(byte[] paramArrayOfByte) {
        return Utils.getUTF8String(new Crypter().decrypt(Base64.decodeBase64(paramArrayOfByte), SecurityUtil.SECRET_KEY_HTTP_CHARGE_ALIPAY));
    }

    public static byte[] encryptHttpBody(String paramString) {
        return Base64.encodeBase64(new Crypter().encrypt(Utils.getUTF8Bytes(paramString), SecurityUtil.SECRET_KEY_HTTP));
    }

    public static byte[] encryptHttpChargeAlipayBody(String paramString) {
        return Base64.encodeBase64(new Crypter().encrypt(Utils.getUTF8Bytes(paramString), SecurityUtil.SECRET_KEY_HTTP_CHARGE_ALIPAY));
    }

    public static byte[] encryptHttpChargePhoneCardBody(String paramString) {
        return new Crypter().encrypt(Utils.getUTF8Bytes(paramString), SecurityUtil.SECRET_KEY_HTTP_CHARGE);
    }
}

