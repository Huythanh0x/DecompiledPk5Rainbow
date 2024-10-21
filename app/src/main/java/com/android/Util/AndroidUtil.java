package com.android.Util;

import android.content.res.AssetManager;
import android.media.AudioManager;
import android.os.ConditionVariable;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.CwaActivity;

/* loaded from: classes.dex */
/**
 * Utility class for Android-related operations.
 */
public class AndroidUtil {

    /**
     * Log tag for error messages.
     */
    private static final String LOG = "PIC_ERROR";

    /**
     * Screen height of the device.
     */
    public static int SCREEN_HEIGHT;

    /**
     * Screen width of the device.
     */
    public static int SCREEN_WIDTH;

    /**
     * AudioManager instance for managing audio streams.
     */
    private static AudioManager aManager;

    /**
     * ConditionVariable instance for synchronization.
     */
    public static ConditionVariable cv = new ConditionVariable(true);

    /**
     * AssetManager instance for accessing application assets.
     */
    public static AssetManager am = CwaActivity.getInstance().getAssets();

    /**
     * Retrieves an InputStream for a given resource name.
     *
     * @param name the name of the resource
     * @return InputStream for the resource, or null if the resource does not exist
     */
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

    /**
     * Gets the current music stream volume.
     *
     * @return the current music stream volume, or -1 if the context is null
     */
    public static int getCurrentMusic() {
        if (CwaActivity.getContextInstance() == null) {
            return -1;
        }
        aManager = (AudioManager) CwaActivity.getContextInstance().getSystemService("audio");
        return aManager.getStreamVolume(3);
    }

    /**
     * Sets the music stream volume to the specified level.
     *
     * @param volume the desired volume level
     */
    public static void setMusic(int volume) {
        if (CwaActivity.getContextInstance() != null) {
            aManager = (AudioManager) CwaActivity.getContextInstance().getSystemService("audio");
            aManager.setStreamVolume(3, volume, 16);
        }
    }
}
