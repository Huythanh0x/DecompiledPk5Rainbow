/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.media.AudioManager
 *  android.util.Log
 *  javax.microedition.lcdui.CwaActivity
 *  javax.microedition.media.Control
 */
package javax.microedition.media.control;

import android.media.AudioManager;
import android.util.Log;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.media.Control;

public class VolumeControl
implements Control {
    private AudioManager audioManager = (AudioManager)CwaActivity.getContextInstance().getSystemService("audio");
    private int currentVolume = 0;
    private int maxVolume = this.audioManager.getStreamMaxVolume(3);
    private boolean mute = false;
    private float percent = 100 / this.maxVolume;

    private void mute() {
        this.mute = true;
        this.audioManager.setStreamVolume(3, 0, 16);
    }

    private void unmute() {
        this.mute = false;
        this.audioManager.setStreamVolume(3, this.currentVolume, 16);
    }

    public int getLevel() {
        return (int)((float)this.currentVolume * this.percent);
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isMuted() {
        if (this.getLevel() != 0) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public int setLevel(int var1_1) {
        if (var1_1 < 0) {
            var2_2 = 0;
lbl3:
            // 3 sources

            while (true) {
                var1_1 = (int)((float)var2_2 / this.percent);
                if (!this.mute) {
                    this.currentVolume = var1_1;
                    Log.e((String)"", (String)("\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u7684\u6bd4\u4f8b\u503c\u662f" + this.percent));
                    Log.e((String)"", (String)("\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u58f0\u97f3\u662f" + var1_1));
                }
                return var2_2;
            }
        }
        var2_2 = var1_1;
        if (var1_1 <= 100) ** GOTO lbl3
        var2_2 = 100;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public int setLevelForMenu(int var1_1) {
        if (var1_1 < 0) {
            var2_2 = 0;
lbl3:
            // 3 sources

            while (true) {
                var1_1 = (int)((float)var2_2 / this.percent);
                if (!this.mute) {
                    this.currentVolume = var1_1;
                    Log.e((String)"", (String)("\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u7684\u6bd4\u4f8b\u503c\u662f" + this.percent));
                    Log.e((String)"", (String)("\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u58f0\u97f3\u662f" + var1_1));
                    Log.e((String)"", (String)"dddddddddddddddddddddd");
                    this.audioManager.setStreamVolume(3, var1_1, 16);
                }
                return var2_2;
            }
        }
        var2_2 = var1_1;
        if (var1_1 <= 100) ** GOTO lbl3
        var2_2 = 100;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public void setMute(boolean bl) {
        if (bl) {
            this.mute();
            return;
        }
        this.unmute();
    }
}
