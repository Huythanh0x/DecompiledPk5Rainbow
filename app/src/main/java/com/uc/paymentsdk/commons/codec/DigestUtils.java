package com.uc.paymentsdk.commons.codec;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class DigestUtils
{
    public DigestUtils() {
        super();
    }
    
    static MessageDigest getDigest(final String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        }
        catch (final NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    private static MessageDigest getMd5Digest() {
        return getDigest("MD5");
    }
    
    private static MessageDigest getShaDigest() {
        return getDigest("SHA");
    }
    
    public static byte[] md5(final String s) {
        return md5(s.getBytes());
    }
    
    public static byte[] md5(final byte[] input) {
        return getMd5Digest().digest(input);
    }
    
    public static String md5Hex(final String s) {
        return new String(Hex.encodeHex(md5(s)));
    }
    
    public static String md5Hex(final byte[] array) {
        return new String(Hex.encodeHex(md5(array)));
    }
    
    public static byte[] sha(final String s) {
        return sha(s.getBytes());
    }
    
    public static byte[] sha(final byte[] input) {
        return getShaDigest().digest(input);
    }
    
    public static String shaHex(final String s) {
        return new String(Hex.encodeHex(sha(s)));
    }
    
    public static String shaHex(final byte[] array) {
        return new String(Hex.encodeHex(sha(array)));
    }
}
