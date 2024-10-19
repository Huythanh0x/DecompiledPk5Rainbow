package javax.microedition.media.control;

import android.media.AudioManager;
import android.util.Log;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.media.Control;

/* loaded from: classes.dex */
public class VolumeControl implements Control {
    private boolean mute = false;
    private int currentVolume = 0;
    private AudioManager audioManager = (AudioManager) CwaActivity.getContextInstance().getSystemService("audio");
    private int maxVolume = this.audioManager.getStreamMaxVolume(3);
    private float percent = 100 / this.maxVolume;

    public int getLevel() {
        return (int) (this.currentVolume * this.percent);
    }

    public boolean isMuted() {
        return getLevel() == 0;
    }

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

    public void setMute(boolean mute) {
        if (mute) {
            mute();
        } else {
            unmute();
        }
    }

    private void mute() {
        this.mute = true;
        this.audioManager.setStreamVolume(3, 0, 16);
    }

    private void unmute() {
        this.mute = false;
        this.audioManager.setStreamVolume(3, this.currentVolume, 16);
    }
}
