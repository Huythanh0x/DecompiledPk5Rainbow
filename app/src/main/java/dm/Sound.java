package dm;

import android.util.Log;
import javax.microedition.media.Manager;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.media.Player;

public final class Sound
{
    private static Sound soundListener;
    public byte[] loop;
    private byte loop_s;
    private byte musicId;
    private byte musicId_temp;
    private byte play_music;
    private Player snd_music;
    private boolean sound_on;
    private boolean sound_play;
    private VolumeControl vc_snd;
    private byte volume;
    
    public Sound() {
        super();
        this.sound_play = false;
        this.sound_on = false;
        this.musicId = -1;
        this.musicId_temp = -1;
        this.volume = 30;
        this.loop = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        Sound.soundListener = this;
    }
    
    private Player createMusic(final int i, final int n) {
        Label_0089: {
            if (n < 0) {
                break Label_0089;
            }
            try {
                if (this.snd_music != null) {
                    this.snd_music.close();
                }
                this.snd_music = null;
                (this.snd_music = Manager.createPlayer("/music/" + i + ".mid", (new String[] { "audio/midi", "audio/x-wav" })[n])).prefetch();
                this.vc_snd = null;
                this.createVolume(this.volume);
                return this.snd_music;
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                return this.snd_music;
            }
        }
    }
    
    private Player createMusicForMenu(final int i, final int n) {
        Label_0089: {
            if (n < 0) {
                break Label_0089;
            }
            try {
                if (this.snd_music != null) {
                    this.snd_music.close();
                }
                this.snd_music = null;
                (this.snd_music = Manager.createPlayer("/music/" + i + ".mid", (new String[] { "audio/midi", "audio/x-wav" })[n])).prefetch();
                this.vc_snd = null;
                this.createVolumeForMenu(this.volume);
                return this.snd_music;
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                return this.snd_music;
            }
        }
    }
    
    private void createVolume(final int n) {
        if (this.vc_snd == null) {
            this.vc_snd = (VolumeControl)this.snd_music.getControl("VolumeControl");
        }
        Log.e("", "\u8fd9\u4e2a\u6e38\u620f\u7684\u97f3\u4e50\u662f" + n);
        this.vc_snd.setLevel(n);
    }
    
    private void createVolumeForMenu(final int n) {
        if (this.vc_snd == null) {
            this.vc_snd = (VolumeControl)this.snd_music.getControl("VolumeControl");
        }
        Log.e("", "\u8fd9\u4e2a\u6e38\u620f\u7684\u97f3\u4e50\u662f" + n);
        this.vc_snd.setLevelForMenu(n);
    }
    
    public static Sound i() {
        if (Sound.soundListener == null) {
            Sound.soundListener = new Sound();
        }
        return Sound.soundListener;
    }
    
    public boolean getHaveSoundPlayState() {
        try {
            boolean b;
            if (this.snd_music != null && this.snd_music.getState() == 400) {
                System.out.println("getHaveSoundPlayState() true");
                b = true;
            }
            else {
                System.out.println("getHaveSoundPlayState() false");
                b = false;
            }
            return b;
        }
        catch (final Exception ex) {
            ex.printStackTrace();
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
    
    public void keyVolume(final int n) {
        if (n == 0) {
            if ((this.volume += 30) > 90) {
                this.volume = 0;
            }
        }
        else if (n == 1 && Ms.i().key_Right()) {
            if ((this.volume += 30) > 90) {
                this.volume = 0;
            }
            else if (Ms.i().key_Left() && (this.volume -= 30) < 0) {
                this.volume = 90;
            }
        }
        if (this.volume == 0) {
            this.sound_on = false;
            this.soundStop();
        }
        else {
            this.sound_on = true;
        }
    }
    
    void playTone() {
    }
    
    public void setMusic(final boolean b) {
        if (this.sound_on && this.musicId >= 0) {
            try {
                if (this.musicId_temp != this.musicId || b) {
                    this.loop_s = this.loop[this.musicId];
                    this.play_music = this.musicId;
                    this.musicId_temp = this.play_music;
                    if (this.snd_music != null) {
                        this.snd_music.close();
                    }
                    this.snd_music = null;
                    this.createMusic(this.play_music, 0);
                }
                this.sound_play = true;
            }
            catch (final Exception ex) {
                this.sound_play = false;
            }
        }
    }
    
    public void setMusicForMenu(final boolean b) {
        if (this.sound_on && this.musicId >= 0) {
            try {
                if (this.musicId_temp != this.musicId || b) {
                    this.loop_s = this.loop[this.musicId];
                    this.play_music = this.musicId;
                    this.musicId_temp = this.play_music;
                    if (this.snd_music != null) {
                        this.snd_music.close();
                    }
                    this.snd_music = null;
                    this.createMusicForMenu(this.play_music, 0);
                }
                this.sound_play = true;
            }
            catch (final Exception ex) {
                this.sound_play = false;
            }
        }
    }
    
    public void setMusicId(final int n) {
        this.musicId = (byte)n;
    }
    
    public void setSoundON(final boolean sound_on) {
        this.sound_on = sound_on;
    }
    
    public void setVolume(final int n) {
        this.volume = (byte)n;
    }
    
    public void soundPlay() {
        if (this.sound_on && this.play_music >= 0 && this.sound_play) {
            if (this.loop_s == -1 && this.snd_music != null) {
                this.snd_music.setLoopCount(-1);
                this.soundStart();
                this.play_music = -1;
            }
            else if (this.loop_s > 0 && this.snd_music != null && this.snd_music.getState() != 400) {
                this.snd_music.setLoopCount(1);
                this.soundStart();
                --this.loop_s;
            }
            else if (this.loop_s == 0) {
                this.play_music = -1;
            }
        }
    }
    
    public void soundStart() {
        try {
            this.snd_music.start();
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void soundStop() {
        try {
            if (this.snd_music != null) {
                this.snd_music.close();
            }
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            this.sound_play = false;
        }
        finally {
            this.sound_play = false;
        }
    }
}
