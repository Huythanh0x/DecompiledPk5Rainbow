package com.android.Util;

import java.io.IOException;
import android.util.Log;
import java.io.InputStream;
import javax.microedition.lcdui.CwaActivity;
import android.os.ConditionVariable;
import android.content.res.AssetManager;
import android.media.AudioManager;

public class AndroidUtil
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
    
    public AndroidUtil() {
        super();
    }
    
    public static int getCurrentMusic() {
        int streamVolume;
        if (CwaActivity.getContextInstance() != null) {
            AndroidUtil.aManager = (AudioManager)CwaActivity.getContextInstance().getSystemService("audio");
            streamVolume = AndroidUtil.aManager.getStreamVolume(3);
        }
        else {
            streamVolume = -1;
        }
        return streamVolume;
    }
    
    public static InputStream getResourceAsStream(final String s) {
        InputStream inputStream2;
        final InputStream inputStream = inputStream2 = null;
        try {
            InputStream inputStream3;
            if (s.indexOf(47) == 0) {
                inputStream2 = inputStream;
                inputStream3 = AndroidUtil.am.open(s.substring(1, s.length()));
            }
            else {
                inputStream2 = inputStream;
                inputStream3 = AndroidUtil.am.open(s);
            }
            inputStream2 = inputStream3;
            if (inputStream3 == null) {
                inputStream2 = inputStream3;
                inputStream2 = inputStream3;
                final StringBuilder sb = new StringBuilder(String.valueOf(s));
                inputStream2 = inputStream3;
                Log.e("PIC_ERROR", sb.append(" is not exist").toString());
                inputStream2 = inputStream3;
            }
            return inputStream2;
        }
        catch (final IOException ex) {
            Log.e("PIC_ERROR", String.valueOf(s) + " is not exist");
            ex.printStackTrace();
            return inputStream2;
        }
    }
    
    public static void setMusic(final int n) {
        if (CwaActivity.getContextInstance() != null) {
            (AndroidUtil.aManager = (AudioManager)CwaActivity.getContextInstance().getSystemService("audio")).setStreamVolume(3, n, 16);
        }
    }
}
