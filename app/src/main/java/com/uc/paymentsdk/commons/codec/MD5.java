package com.uc.paymentsdk.commons.codec;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class MD5
{
    public MD5() {
        super();
    }
    
    public static String getMD5(final String s) throws NoSuchAlgorithmException {
        final MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(s.getBytes());
        return getString(instance.digest());
    }
    
    private static String getString(final byte[] array) {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
}
