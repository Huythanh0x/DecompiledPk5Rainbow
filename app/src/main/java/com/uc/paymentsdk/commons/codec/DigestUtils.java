package com.uc.paymentsdk.commons.codec.DigestUtils;
import java.lang.Object;
import java.lang.String;
import java.security.MessageDigest;
import java.lang.RuntimeException;
import java.security.NoSuchAlgorithmException;
import com.uc.paymentsdk.commons.codec.Hex;

public class DigestUtils	// class@00008b from classes.dex
{

    public void DigestUtils(){
       super();
    }
    static MessageDigest getDigest(String paramString){
       try{
          return MessageDigest.getInstance(paramString);
       }catch(java.security.NoSuchAlgorithmException e0){
          throw new RuntimeException(e0.getMessage());
       }
    }
    private static MessageDigest getMd5Digest(){
       return DigestUtils.getDigest("MD5");
    }
    private static MessageDigest getShaDigest(){
       return DigestUtils.getDigest("SHA");
    }
    public static byte[] md5(String paramString){
       return DigestUtils.md5(paramString.getBytes());
    }
    public static byte[] md5(byte[] paramArrayOfByte){
       return DigestUtils.getMd5Digest().digest(paramArrayOfByte);
    }
    public static String md5Hex(String paramString){
       return new String(Hex.encodeHex(DigestUtils.md5(paramString)));
    }
    public static String md5Hex(byte[] paramArrayOfByte){
       return new String(Hex.encodeHex(DigestUtils.md5(paramArrayOfByte)));
    }
    public static byte[] sha(String paramString){
       return DigestUtils.sha(paramString.getBytes());
    }
    public static byte[] sha(byte[] paramArrayOfByte){
       return DigestUtils.getShaDigest().digest(paramArrayOfByte);
    }
    public static String shaHex(String paramString){
       return new String(Hex.encodeHex(DigestUtils.sha(paramString)));
    }
    public static String shaHex(byte[] paramArrayOfByte){
       return new String(Hex.encodeHex(DigestUtils.sha(paramArrayOfByte)));
    }
}
