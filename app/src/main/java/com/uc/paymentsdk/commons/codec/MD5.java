package com.uc.paymentsdk.commons.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String getMD5(String val) throws NoSuchAlgorithmException {
        MessageDigest messageDigest0 = MessageDigest.getInstance("MD5");
        messageDigest0.update(val.getBytes());
        return MD5.getString(messageDigest0.digest());
    }

    private static String getString(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < b.length; ++i) {
            sb.append(((int)b[i]));
        }
        return sb.toString();
    }
}

