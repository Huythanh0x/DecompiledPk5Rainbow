package com.android.Util.AndroidUtil;
import android.os.ConditionVariable;
import javax.microedition.lcdui.CwaActivity;
import android.content.res.AssetManager;
import java.lang.Object;
import android.content.Context;
import java.lang.String;
import android.media.AudioManager;
import java.io.InputStream;
import java.lang.StringBuilder;
import android.util.Log;
import java.io.IOException;

public class AndroidUtil	// class@000081 from classes.dex
{
    private static final String LOG = "PIC_ERROR";
    public static int SCREEN_HEIGHT;
    public static int SCREEN_WIDTH;
    private static AudioManager aManager;
    public static AssetManager am;
    public static ConditionVariable cv;

    static {
       AndroidUtil.cv = new ConditionVariable(true);
       AndroidUtil.am = CwaActivity.getInstance().getAssets();
    }
    public void AndroidUtil(){
       super();
    }
    public static int getCurrentMusic(){
       int streamVolume;
       if (CwaActivity.getContextInstance() != null) {
          AndroidUtil.aManager = CwaActivity.getContextInstance().getSystemService("audio");
          streamVolume = AndroidUtil.aManager.getStreamVolume(3);
       }else {
          streamVolume = -1;
       }
       return streamVolume;
    }
    public static InputStream getResourceAsStream(String name){
       InputStream is = null;
       int i = 47;
       try{
          if (!name.indexOf(i)) {
             is = AndroidUtil.am.open(name.substring(1, name.length()));
          label_0018 :
             if (is == null) {
                Log.e("PIC_ERROR", String.valueOf(name)+" is not exist");
             }
          }else {
             is = AndroidUtil.am.open(name);
             goto label_0018 ;
          }
       }catch(java.io.IOException e2){
          IOException e = e2;
          Log.e("PIC_ERROR", String.valueOf(name)+" is not exist");
          e.printStackTrace();
       }
       return is;
    }
    public static void setMusic(int volume){
       if (CwaActivity.getContextInstance() != null) {
          AndroidUtil.aManager = CwaActivity.getContextInstance().getSystemService("audio");
          AndroidUtil.aManager.setStreamVolume(3, volume, 16);
       }
       return;
    }
}
