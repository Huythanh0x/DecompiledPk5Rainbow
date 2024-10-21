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
    public static ConditionVariable cv;

    static {
        AndroidUtil.cv = new ConditionVariable(true);
        AndroidUtil.am = CwaActivity.getInstance().getAssets();
    }

    public static int getCurrentMusic() {
        if(CwaActivity.getContextInstance() != null) {
            AndroidUtil.aManager = (AudioManager)CwaActivity.getContextInstance().getSystemService("audio");
            return AndroidUtil.aManager.getStreamVolume(3);
        }
        return -1;
    }

    public static InputStream getResourceAsStream(String name) {
        InputStream is = null;
        try {
            is = name.indexOf(0x2F) == 0 ? AndroidUtil.am.open(name.substring(1, name.length())) : AndroidUtil.am.open(name);
            if(is == null) {
                Log.e("PIC_ERROR", name + " is not exist");
            }
        }
        catch(IOException iOException0) {
            Log.e("PIC_ERROR", name + " is not exist");
            iOException0.printStackTrace();
        }
        return is;
    }

    public static void setMusic(int volume) {
        if(CwaActivity.getContextInstance() != null) {
            AndroidUtil.aManager = (AudioManager)CwaActivity.getContextInstance().getSystemService("audio");
            AndroidUtil.aManager.setStreamVolume(3, volume, 16);
        }
    }
}

