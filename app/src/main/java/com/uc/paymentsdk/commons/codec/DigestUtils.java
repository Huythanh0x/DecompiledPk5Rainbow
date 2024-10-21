package com.uc.paymentsdk.commons.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class DigestUtils {
    static MessageDigest getDigest(String paramString) {
        try {
            return MessageDigest.getInstance(paramString);
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            throw new RuntimeException(localNoSuchAlgorithmException.getMessage());
        }
    }

    private static MessageDigest getMd5Digest() {
        return getDigest("MD5");
    }

    private static MessageDigest getShaDigest() {
        return getDigest("SHA");
    }

    public static byte[] md5(byte[] paramArrayOfByte) {
        return getMd5Digest().digest(paramArrayOfByte);
    }

    public static byte[] md5(String paramString) {
        return md5(paramString.getBytes());
    }

    public static String md5Hex(byte[] paramArrayOfByte) {
        return new String(Hex.encodeHex(md5(paramArrayOfByte)));
    }

    public static String md5Hex(String paramString) {
        return new String(Hex.encodeHex(md5(paramString)));
    }

    public static byte[] sha(byte[] paramArrayOfByte) {
        return getShaDigest().digest(paramArrayOfByte);
    }

    public static byte[] sha(String paramString) {
        return sha(paramString.getBytes());
    }

    public static String shaHex(byte[] paramArrayOfByte) {
        return new String(Hex.encodeHex(sha(paramArrayOfByte)));
    }

    public static String shaHex(String paramString) {
        return new String(Hex.encodeHex(sha(paramString)));
    }
}
