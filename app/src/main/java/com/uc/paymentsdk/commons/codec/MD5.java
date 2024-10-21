/*
 * Decompiled with CFR.
 */
package com.uc.paymentsdk.commons.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String getMD5(String string) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(string.getBytes());
        return MD5.getString(messageDigest.digest());
    }

    private static String getString(byte[] byArray) {
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        while (n < byArray.length) {
            stringBuffer.append(byArray[n]);
            ++n;
        }
        return stringBuffer.toString();
    }
}
