/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  dm.Ms
 *  javax.microedition.media.Manager
 *  javax.microedition.media.Player
 *  javax.microedition.media.control.VolumeControl
 */
package dm;

import android.util.Log;
import dm.Ms;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;

public final class Sound {
    private static Sound soundListener;
    public byte[] loop;
    private byte loop_s;
    private byte musicId = (byte)-1;
    private byte musicId_temp = (byte)-1;
    private byte play_music;
    private Player snd_music;
    private boolean sound_on = false;
    private boolean sound_play = false;
    private VolumeControl vc_snd;
    private byte volume = (byte)30;

    public Sound() {
        this.loop = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        soundListener = this;
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     */
    private Player createMusic(int n, int n2) {
        if (n2 >= 0) {
            if (this.snd_music != null) {
                this.snd_music.close();
            }
            this.snd_music = null;
            StringBuilder stringBuilder = new StringBuilder("/music/");
            this.snd_music = Manager.createPlayer((String)stringBuilder.append(n).append(".mid").toString(), (String)(new String[]{"audio/midi", "audio/x-wav"})[n2]);
            this.snd_music.prefetch();
            this.vc_snd = null;
            this.createVolume(this.volume);
        }
        return this.snd_music;
        catch (Exception exception) {
            exception.printStackTrace();
            return this.snd_music;
        }
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     */
    private Player createMusicForMenu(int n, int n2) {
        if (n2 >= 0) {
            if (this.snd_music != null) {
                this.snd_music.close();
            }
            this.snd_music = null;
            StringBuilder stringBuilder = new StringBuilder("/music/");
            this.snd_music = Manager.createPlayer((String)stringBuilder.append(n).append(".mid").toString(), (String)(new String[]{"audio/midi", "audio/x-wav"})[n2]);
            this.snd_music.prefetch();
            this.vc_snd = null;
            this.createVolumeForMenu(this.volume);
        }
        return this.snd_music;
        catch (Exception exception) {
            exception.printStackTrace();
            return this.snd_music;
        }
    }

    private void createVolume(int n) {
        if (this.vc_snd == null) {
            this.vc_snd = (VolumeControl)this.snd_music.getControl("VolumeControl");
        }
        Log.e((String)"", (String)("\u8fd9\u4e2a\u6e38\u620f\u7684\u97f3\u4e50\u662f" + n));
        this.vc_snd.setLevel(n);
    }

    private void createVolumeForMenu(int n) {
        if (this.vc_snd == null) {
            this.vc_snd = (VolumeControl)this.snd_music.getControl("VolumeControl");
        }
        Log.e((String)"", (String)("\u8fd9\u4e2a\u6e38\u620f\u7684\u97f3\u4e50\u662f" + n));
        this.vc_snd.setLevelForMenu(n);
    }

    public static Sound i() {
        if (soundListener == null) {
            soundListener = new Sound();
        }
        return soundListener;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean getHaveSoundPlayState() {
        try {
            if (this.snd_music != null && this.snd_music.getState() == 400) {
                System.out.println("getHaveSoundPlayState() true");
                return true;
            }
            System.out.println("getHaveSoundPlayState() false");
            return false;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("getHaveSoundPlayState() false");
            return false;
        }
    }

    public byte getMusicId() {
        return this.musicId;
    }

    public boolean getSoundON() {
        return this.sound_on;
    }

    public byte getVolume() {
        return this.volume;
    }

    /*
     * Unable to fully structure code
     */
    public void keyVolume(int var1_1) {
        block4: {
            block5: {
                block3: {
                    if (var1_1 != 0) break block3;
                    this.volume = var2_2 = (byte)(this.volume + 30);
                    if (var2_2 > 90) {
                        this.volume = 0;
                    }
lbl5:
                    // 8 sources

                    while (this.volume == 0) {
                        this.sound_on = false;
                        this.soundStop();
lbl8:
                        // 2 sources

                        return;
                    }
                    break block4;
                }
                if (var1_1 != 1 || !Ms.i().key_Right()) ** GOTO lbl5
                this.volume = var2_3 = (byte)(this.volume + 30);
                if (var2_3 <= 90) break block5;
                this.volume = 0;
                ** GOTO lbl5
            }
            if (!Ms.i().key_Left()) ** GOTO lbl5
            this.volume = var2_3 = (byte)(this.volume - 30);
            if (var2_3 >= 0) ** GOTO lbl5
            this.volume = (byte)90;
            ** GOTO lbl5
        }
        this.sound_on = true;
        ** while (true)
    }

    void playTone() {
    }

    /*
     * Enabled force condition propagation
     */
    public void setMusic(boolean bl) {
        if (!this.sound_on || this.musicId < 0) {
            return;
        }
        try {
            if (this.musicId_temp != this.musicId || bl) {
                this.loop_s = this.loop[this.musicId];
                this.musicId_temp = this.play_music = this.musicId;
                if (this.snd_music != null) {
                    this.snd_music.close();
                }
                this.snd_music = null;
                this.createMusic(this.play_music, 0);
            }
            this.sound_play = true;
            return;
        }
        catch (Exception exception) {
            this.sound_play = false;
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public void setMusicForMenu(boolean bl) {
        if (!this.sound_on || this.musicId < 0) {
            return;
        }
        try {
            if (this.musicId_temp != this.musicId || bl) {
                this.loop_s = this.loop[this.musicId];
                this.musicId_temp = this.play_music = this.musicId;
                if (this.snd_music != null) {
                    this.snd_music.close();
                }
                this.snd_music = null;
                this.createMusicForMenu(this.play_music, 0);
            }
            this.sound_play = true;
            return;
        }
        catch (Exception exception) {
            this.sound_play = false;
            return;
        }
    }

    public void setMusicId(int n) {
        this.musicId = (byte)n;
    }

    public void setSoundON(boolean bl) {
        this.sound_on = bl;
    }

    public void setVolume(int n) {
        this.volume = (byte)n;
    }

    /*
     * Unable to fully structure code
     */
    public void soundPlay() {
        block3: {
            block2: {
                if (!this.sound_on || this.play_music < 0) lbl-1000:
                // 6 sources

                {
                    return;
                }
                if (!this.sound_play) ** GOTO lbl-1000
                if (this.loop_s != -1 || this.snd_music == null) break block2;
                this.snd_music.setLoopCount(-1);
                this.soundStart();
                this.play_music = (byte)-1;
                ** GOTO lbl-1000
            }
            if (this.loop_s <= 0 || this.snd_music == null || this.snd_music.getState() == 400) break block3;
            this.snd_music.setLoopCount(1);
            this.soundStart();
            this.loop_s = (byte)(this.loop_s - 1);
            ** GOTO lbl-1000
        }
        if (this.loop_s != 0) ** GOTO lbl-1000
        this.play_music = (byte)-1;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public void soundStart() {
        try {
            this.snd_music.start();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public void soundStop() {
        try {
            if (this.snd_music != null) {
                this.snd_music.close();
            }
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        finally {
            this.sound_play = false;
            return;
        }
    }
}
