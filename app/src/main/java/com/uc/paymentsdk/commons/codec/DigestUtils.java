package com.uc.paymentsdk.commons.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils {
    static MessageDigest getDigest(String paramString) [...] // Inlined contents

    private static MessageDigest getMd5Digest() {
        try {
            return MessageDigest.getInstance("MD5");
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
            throw new RuntimeException(noSuchAlgorithmException0.getMessage());
        }
    }

    private static MessageDigest getShaDigest() {
        try {
            return MessageDigest.getInstance("SHA");
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
            throw new RuntimeException(noSuchAlgorithmException0.getMessage());
        }
    }

    public static byte[] md5(String paramString) {
        return DigestUtils.md5(paramString.getBytes());
    }

    public static byte[] md5(byte[] paramArrayOfByte) {
        return DigestUtils.getMd5Digest().digest(paramArrayOfByte);
    }

    public static String md5Hex(String paramString) {
        return new String(Hex.encodeHex(DigestUtils.md5(paramString)));
    }

    public static String md5Hex(byte[] paramArrayOfByte) {
        return new String(Hex.encodeHex(DigestUtils.md5(paramArrayOfByte)));
    }

    public static byte[] sha(String paramString) {
        return DigestUtils.sha(paramString.getBytes());
    }

    public static byte[] sha(byte[] paramArrayOfByte) {
        return DigestUtils.getShaDigest().digest(paramArrayOfByte);
    }

    public static String shaHex(String paramString) {
        return new String(Hex.encodeHex(DigestUtils.sha(paramString)));
    }

    public static String shaHex(byte[] paramArrayOfByte) {
        return new String(Hex.encodeHex(DigestUtils.sha(paramArrayOfByte)));
    }
}

