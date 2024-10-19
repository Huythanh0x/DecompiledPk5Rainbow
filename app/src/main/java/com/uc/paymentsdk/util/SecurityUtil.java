package com.uc.paymentsdk.util;

import com.uc.paymentsdk.commons.codec.Base64;
import com.uc.paymentsdk.commons.codec.Crypter;

/* loaded from: classes.dex */
public class SecurityUtil {
    private static final byte[] SECRET_KEY_HTTP = Constants.CODE_KEY_PAY_AND_ACCOUNT.getBytes();
    private static final byte[] SECRET_KEY_HTTP_CHARGE = "MAPPN-ANDY-XIAN-".getBytes();
    public static final String KEY_HTTP_CHARGE_ALIPAY_AND_G = "6R4ya0Nee7aLgl4k";
    public static final byte[] SECRET_KEY_HTTP_CHARGE_ALIPAY = KEY_HTTP_CHARGE_ALIPAY_AND_G.getBytes();

    public static byte[] encryptHttpBody(String paramString) {
        return Base64.encodeBase64(new Crypter().encrypt(Utils.getUTF8Bytes(paramString), SECRET_KEY_HTTP));
    }

    public static byte[] encryptHttpChargePhoneCardBody(String paramString) {
        return new Crypter().encrypt(Utils.getUTF8Bytes(paramString), SECRET_KEY_HTTP_CHARGE);
    }

    public static byte[] encryptHttpChargeAlipayBody(String paramString) {
        return Base64.encodeBase64(new Crypter().encrypt(Utils.getUTF8Bytes(paramString), SECRET_KEY_HTTP_CHARGE_ALIPAY));
    }

    public static String decryptHttpChargeAlipayBody(byte[] paramArrayOfByte) {
        return Utils.getUTF8String(new Crypter().decrypt(Base64.decodeBase64(paramArrayOfByte), SECRET_KEY_HTTP_CHARGE_ALIPAY));
    }
}
