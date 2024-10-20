/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.media.AudioManager
 *  android.os.ConditionVariable
 *  android.util.Log
 *  javax.microedition.lcdui.CwaActivity
 */
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
        cv = new ConditionVariable(true);
        am = CwaActivity.getInstance().getAssets();
    }

    /*
     * Enabled force condition propagation
     */
    public static int getCurrentMusic() {
        if (CwaActivity.getContextInstance() == null) return -1;
        aManager = (AudioManager)CwaActivity.getContextInstance().getSystemService("audio");
        return aManager.getStreamVolume(3);
    }

    /*
     * Unable to fully structure code
     */
    public static InputStream getResourceAsStream(String var0) {
        var2_3 = var1_1 = null;
        try {
            if (var0.indexOf(47) == 0) {
                var2_3 = var1_1;
                var1_1 = AndroidUtil.am.open(var0.substring(1, var0.length()));
lbl6:
                // 2 sources

                while (true) {
                    var2_3 = var1_1;
                    if (var1_1 == null) {
                        var2_3 = var1_1;
                        var2_3 = var1_1;
                        var3_4 = new StringBuilder(String.valueOf(var0));
                        var2_3 = var1_1;
                        Log.e((String)"PIC_ERROR", (String)var3_4.append(" is not exist").toString());
                        var2_3 = var1_1;
                    }
lbl16:
                    // 4 sources

                    return var2_3;
                }
            }
            var2_3 = var1_1;
            var1_1 = AndroidUtil.am.open(var0);
            ** continue;
        }
        catch (IOException var1_2) {
            Log.e((String)"PIC_ERROR", (String)(String.valueOf(var0) + " is not exist"));
            var1_2.printStackTrace();
            ** continue;
        }
    }

    public static void setMusic(int n) {
        if (CwaActivity.getContextInstance() != null) {
            aManager = (AudioManager)CwaActivity.getContextInstance().getSystemService("audio");
            aManager.setStreamVolume(3, n, 16);
        }
    }
}
