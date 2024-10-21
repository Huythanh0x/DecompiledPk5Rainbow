/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.commons.codec.Base64
 *  com.uc.paymentsdk.commons.codec.Crypter
 *  com.uc.paymentsdk.util.Utils
 */
package com.uc.paymentsdk.util;

import com.uc.paymentsdk.commons.codec.Base64;
import com.uc.paymentsdk.commons.codec.Crypter;
import com.uc.paymentsdk.util.Utils;

public class SecurityUtil {
    public static final String KEY_HTTP_CHARGE_ALIPAY_AND_G = "6R4ya0Nee7aLgl4k";
    private static final byte[] SECRET_KEY_HTTP = "sdk_mappn_201008".getBytes();
    private static final byte[] SECRET_KEY_HTTP_CHARGE = "MAPPN-ANDY-XIAN-".getBytes();
    public static final byte[] SECRET_KEY_HTTP_CHARGE_ALIPAY = "6R4ya0Nee7aLgl4k".getBytes();

    public static String decryptHttpChargeAlipayBody(byte[] byArray) {
        return Utils.getUTF8String((byte[])new Crypter().decrypt(Base64.decodeBase64((byte[])byArray), SECRET_KEY_HTTP_CHARGE_ALIPAY));
    }

    public static byte[] encryptHttpBody(String string) {
        return Base64.encodeBase64((byte[])new Crypter().encrypt(Utils.getUTF8Bytes((String)string), SECRET_KEY_HTTP));
    }

    public static byte[] encryptHttpChargeAlipayBody(String string) {
        return Base64.encodeBase64((byte[])new Crypter().encrypt(Utils.getUTF8Bytes((String)string), SECRET_KEY_HTTP_CHARGE_ALIPAY));
    }

    public static byte[] encryptHttpChargePhoneCardBody(String string) {
        return new Crypter().encrypt(Utils.getUTF8Bytes((String)string), SECRET_KEY_HTTP_CHARGE);
    }
}
