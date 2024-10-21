package javax.microedition.media.control;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.media.Control;

/* loaded from: classes.dex */
/**
 * The VolumeControl class provides methods to control the volume level and mute state
 * of an audio stream. It implements the Control interface.
 */
public class VolumeControl implements Control {
    private boolean mute = false;
    private int currentVolume = 0;
    private AudioManager audioManager = (AudioManager) CwaActivity.getContextInstance().getSystemService(Context.AUDIO_SERVICE);
    private int maxVolume = this.audioManager.getStreamMaxVolume(3);
    private float percent = 100 / this.maxVolume;

    /**
     * Gets the current volume level as a percentage of the maximum volume.
     *
     * @return the current volume level as a percentage (0-100).
     */
    public int getLevel() {
        return (int) (this.currentVolume * this.percent);
    }

    /**
     * Checks if the audio is muted.
     *
     * @return true if the audio is muted, false otherwise.
     */
    public boolean isMuted() {
        return getLevel() == 0;
    }

    /**
     * Sets the volume level to the specified percentage.
     *
     * @param level the desired volume level as a percentage (0-100).
     * @return the actual volume level set as a percentage (0-100).
     */
    public int setLevel(int level) {
        if (level < 0) {
            level = 0;
        } else if (level > 100) {
            level = 100;
        }
        int androidLevel = (int) (level / this.percent);
        if (!this.mute) {
            this.currentVolume = androidLevel;
            Log.e("", "这个游戏的管理器的比例值是" + this.percent);
            Log.e("", "这个游戏的管理器声音是" + androidLevel);
        }
        return level;
    }

    /**
     * Sets the volume level to the specified percentage for the menu.
     *
     * @param level the desired volume level as a percentage (0-100).
     * @return the actual volume level set as a percentage (0-100).
     */
    public int setLevelForMenu(int level) {
        if (level < 0) {
            level = 0;
        } else if (level > 100) {
            level = 100;
        }
        int androidLevel = (int) (level / this.percent);
        if (!this.mute) {
            this.currentVolume = androidLevel;
            Log.e("", "这个游戏的管理器的比例值是" + this.percent);
            Log.e("", "这个游戏的管理器声音是" + androidLevel);
            Log.e("", "dddddddddddddddddddddd");
            this.audioManager.setStreamVolume(3, androidLevel, 16);
        }
        return level;
    }

    /**
     * Sets the mute state of the audio.
     *
     * @param mute true to mute the audio, false to unmute.
     */
    public void setMute(boolean mute) {
        if (mute) {
            mute();
        } else {
            unmute();
        }
    }

    /**
     * Mutes the audio.
     */
    private void mute() {
        this.mute = true;
        this.audioManager.setStreamVolume(3, 0, 16);
    }

    /**
     * Unmutes the audio.
     */
    private void unmute() {
        this.mute = false;
        this.audioManager.setStreamVolume(3, this.currentVolume, 16);
    }
}
