package com.uc.paymentsdk.util.SecurityUtil;
import java.lang.String;
import java.lang.Object;
import com.uc.paymentsdk.commons.codec.Crypter;
import com.uc.paymentsdk.commons.codec.Base64;
import com.uc.paymentsdk.util.Utils;

public class SecurityUtil	// class@0000d6 from classes.dex
{
    public static final String KEY_HTTP_CHARGE_ALIPAY_AND_G = "6R4ya0Nee7aLgl4k";
    private static final byte[] SECRET_KEY_HTTP;
    private static final byte[] SECRET_KEY_HTTP_CHARGE;
    public static final byte[] SECRET_KEY_HTTP_CHARGE_ALIPAY;

    static {
       SecurityUtil.SECRET_KEY_HTTP = "sdk_mappn_201008".getBytes();
       SecurityUtil.SECRET_KEY_HTTP_CHARGE = "MAPPN-ANDY-XIAN-".getBytes();
       SecurityUtil.SECRET_KEY_HTTP_CHARGE_ALIPAY = "6R4ya0Nee7aLgl4k".getBytes();
    }
    public void SecurityUtil(){
       super();
    }
    public static String decryptHttpChargeAlipayBody(byte[] paramArrayOfByte){
       return Utils.getUTF8String(new Crypter().decrypt(Base64.decodeBase64(paramArrayOfByte), SecurityUtil.SECRET_KEY_HTTP_CHARGE_ALIPAY));
    }
    public static byte[] encryptHttpBody(String paramString){
       return Base64.encodeBase64(new Crypter().encrypt(Utils.getUTF8Bytes(paramString), SecurityUtil.SECRET_KEY_HTTP));
    }
    public static byte[] encryptHttpChargeAlipayBody(String paramString){
       return Base64.encodeBase64(new Crypter().encrypt(Utils.getUTF8Bytes(paramString), SecurityUtil.SECRET_KEY_HTTP_CHARGE_ALIPAY));
    }
    public static byte[] encryptHttpChargePhoneCardBody(String paramString){
       return new Crypter().encrypt(Utils.getUTF8Bytes(paramString), SecurityUtil.SECRET_KEY_HTTP_CHARGE);
    }
}
