package javax.microedition.media.control;

import android.util.Log;
import javax.microedition.lcdui.CwaActivity;
import android.media.AudioManager;
import javax.microedition.media.Control;

public class VolumeControl implements Control
{
    private AudioManager audioManager;
    private int currentVolume;
    private int maxVolume;
    private boolean mute;
    private float percent;
    
    public VolumeControl() {
        super();
        this.mute = false;
        this.currentVolume = 0;
        this.audioManager = (AudioManager)CwaActivity.getContextInstance().getSystemService("audio");
        this.maxVolume = this.audioManager.getStreamMaxVolume(3);
        this.percent = (float)(100 / this.maxVolume);
    }
    
    private void mute() {
        this.mute = true;
        this.audioManager.setStreamVolume(3, 0, 16);
    }
    
    private void unmute() {
        this.mute = false;
        this.audioManager.setStreamVolume(3, this.currentVolume, 16);
    }
    
    public int getLevel() {
        return (int)(this.currentVolume * this.percent);
    }
    
    public boolean isMuted() {
        return this.getLevel() == 0;
    }
    
    public int setLevel(int n) {
        int n2;
        if (n < 0) {
            n2 = 0;
        }
        else if ((n2 = n) > 100) {
            n2 = 100;
        }
        n = (int)(n2 / this.percent);
        if (!this.mute) {
            this.currentVolume = n;
            Log.e("", "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u7684\u6bd4\u4f8b\u503c\u662f" + this.percent);
            Log.e("", "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u58f0\u97f3\u662f" + n);
        }
        return n2;
    }
    
    public int setLevelForMenu(int n) {
        int n2;
        if (n < 0) {
            n2 = 0;
        }
        else if ((n2 = n) > 100) {
            n2 = 100;
        }
        n = (int)(n2 / this.percent);
        if (!this.mute) {
            this.currentVolume = n;
            Log.e("", "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u7684\u6bd4\u4f8b\u503c\u662f" + this.percent);
            Log.e("", "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u58f0\u97f3\u662f" + n);
            Log.e("", "dddddddddddddddddddddd");
            this.audioManager.setStreamVolume(3, n, 16);
        }
        return n2;
    }
    
    public void setMute(final boolean b) {
        if (b) {
            this.mute();
        }
        else {
            this.unmute();
        }
    }
}
