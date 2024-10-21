package com.uc.paymentsdk.network.AndroidHttpClient$LoggingConfiguration;
import java.lang.String;
import java.lang.Object;
import android.util.Log;

class AndroidHttpClient$LoggingConfiguration	// class@00009c from classes.dex
{
    private final int level;
    private final String tag;

    private void AndroidHttpClient$LoggingConfiguration(String paramString,int paramInt){
       super();
       this.tag = paramString;
       this.level = paramInt;
    }
    void AndroidHttpClient$LoggingConfiguration(String p0,int p1,AndroidHttpClient$LoggingConfiguration p2){
       super(p0, p1);
    }
    static boolean access$0(AndroidHttpClient$LoggingConfiguration p0){
       return p0.isLoggable();
    }
    static void access$1(AndroidHttpClient$LoggingConfiguration p0,String p1){
       p0.println(p1);
    }
    private boolean isLoggable(){
       return Log.isLoggable(this.tag, this.level);
    }
    private void println(String paramString){
       Log.println(this.level, this.tag, paramString);
    }
}
