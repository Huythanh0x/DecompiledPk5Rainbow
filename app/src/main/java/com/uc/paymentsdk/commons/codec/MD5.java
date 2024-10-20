package com.uc.paymentsdk.commons.codec.MD5;
import java.lang.Object;
import java.lang.String;
import java.security.MessageDigest;
import java.lang.StringBuffer;

public class MD5	// class@00008f from classes.dex
{

    public void MD5(){
       super();
    }
    public static String getMD5(String val){
       MessageDigest md5 = MessageDigest.getInstance("MD5");
       md5.update(val.getBytes());
       byte[] m = md5.digest();
       return MD5.getString(m);
    }
    private static String getString(byte[] b){
       StringBuffer sb = "";
       for (int i = 0; i < b.length; i++) {
          sb = sb.append(b[i]);
       }
       return sb;
    }
}
