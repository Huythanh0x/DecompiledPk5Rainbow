package com.android.Util;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.os.ConditionVariable;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.CwaActivity;

/* loaded from: classes.dex */
public class AndroidUtil {
    private static final String LOG = "PIC_ERROR";
    public static int SCREEN_HEIGHT;
    public static int SCREEN_WIDTH;
    private static AudioManager aManager;
    public static ConditionVariable cv = new ConditionVariable(true);
    public static AssetManager am = CwaActivity.getInstance().getAssets();

    public static InputStream getResourceAsStream(String name) {
        InputStream is = null;
        try {
            if (name.indexOf(47) == 0) {
                is = am.open(name.substring(1, name.length()));
            } else {
                is = am.open(name);
            }
            if (is == null) {
                Log.e(LOG, String.valueOf(name) + " is not exist");
            }
        } catch (IOException e) {
            Log.e(LOG, String.valueOf(name) + " is not exist");
            e.printStackTrace();
        }
        return is;
    }

    public static int getCurrentMusic() {
        if (CwaActivity.getContextInstance() == null) {
            return -1;
        }
        aManager = (AudioManager) CwaActivity.getContextInstance().getSystemService(Context.AUDIO_SERVICE);
        return aManager.getStreamVolume(3);
    }

    public static void setMusic(int volume) {
        if (CwaActivity.getContextInstance() != null) {
            aManager = (AudioManager) CwaActivity.getContextInstance().getSystemService(Context.AUDIO_SERVICE);
            aManager.setStreamVolume(3, volume, 16);
        }
    }
}
