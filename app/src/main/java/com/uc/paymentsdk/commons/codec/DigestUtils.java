/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.commons.codec.Hex
 */
package com.uc.paymentsdk.commons.codec;

import com.uc.paymentsdk.commons.codec.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils {
    static MessageDigest getDigest(String object) {
        try {
            object = MessageDigest.getInstance((String)object);
            return object;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException.getMessage());
        }
    }

    private static MessageDigest getMd5Digest() {
        return DigestUtils.getDigest("MD5");
    }

    private static MessageDigest getShaDigest() {
        return DigestUtils.getDigest("SHA");
    }

    public static byte[] md5(String string) {
        return DigestUtils.md5(string.getBytes());
    }

    public static byte[] md5(byte[] byArray) {
        return DigestUtils.getMd5Digest().digest(byArray);
    }

    public static String md5Hex(String string) {
        return new String(Hex.encodeHex((byte[])DigestUtils.md5(string)));
    }

    public static String md5Hex(byte[] byArray) {
        return new String(Hex.encodeHex((byte[])DigestUtils.md5(byArray)));
    }

    public static byte[] sha(String string) {
        return DigestUtils.sha(string.getBytes());
    }

    public static byte[] sha(byte[] byArray) {
        return DigestUtils.getShaDigest().digest(byArray);
    }

    public static String shaHex(String string) {
        return new String(Hex.encodeHex((byte[])DigestUtils.sha(string)));
    }

    public static String shaHex(byte[] byArray) {
        return new String(Hex.encodeHex((byte[])DigestUtils.sha(byArray)));
    }
}
