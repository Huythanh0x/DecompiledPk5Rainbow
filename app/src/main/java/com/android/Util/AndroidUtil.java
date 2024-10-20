package com.android.Util;

import android.content.res.AssetManager;
import android.media.AudioManager;
import android.os.ConditionVariable;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.CwaActivity;

public class AndroidUtil {
  private static final String LOG = "PIC_ERROR";
  
  public static int SCREEN_HEIGHT;
  
  public static int SCREEN_WIDTH;
  
  private static AudioManager aManager;
  
  public static AssetManager am;
  
  public static ConditionVariable cv = new ConditionVariable(true);
  
  static {
    am = CwaActivity.getInstance().getAssets();
  }
  
  public static int getCurrentMusic() {
    if (CwaActivity.getContextInstance() != null) {
      aManager = (AudioManager)CwaActivity.getContextInstance().getSystemService("audio");
      return aManager.getStreamVolume(3);
    } 
    return -1;
  }
  
  public static InputStream getResourceAsStream(String paramString) {
    InputStream inputStream1 = null;
    InputStream inputStream2 = inputStream1;
    try {
      if (paramString.indexOf('/') == 0) {
        inputStream2 = inputStream1;
        inputStream1 = am.open(paramString.substring(1, paramString.length()));
      } else {
        inputStream2 = inputStream1;
        inputStream1 = am.open(paramString);
      } 
      inputStream2 = inputStream1;
      if (inputStream1 == null) {
        inputStream2 = inputStream1;
        StringBuilder stringBuilder = new StringBuilder();
        inputStream2 = inputStream1;
        this(String.valueOf(paramString));
        inputStream2 = inputStream1;
        Log.e("PIC_ERROR", stringBuilder.append(" is not exist").toString());
        inputStream2 = inputStream1;
      } 
    } catch (IOException iOException) {
      Log.e("PIC_ERROR", String.valueOf(paramString) + " is not exist");
      iOException.printStackTrace();
    } 
    return inputStream2;
  }
  
  public static void setMusic(int paramInt) {
    if (CwaActivity.getContextInstance() != null) {
      aManager = (AudioManager)CwaActivity.getContextInstance().getSystemService("audio");
      aManager.setStreamVolume(3, paramInt, 16);
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/android/Util/AndroidUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */