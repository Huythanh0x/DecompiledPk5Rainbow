package dm;

import android.util.Log;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;

public final class Sound {
    public byte[] loop;
    private byte loop_s;
    private byte musicId;
    private byte musicId_temp;
    private byte play_music;
    private Player snd_music;
    private static Sound soundListener;
    private boolean sound_on;
    private boolean sound_play;
    private VolumeControl vc_snd;
    private byte volume;

    public Sound() {
        this.sound_play = false;
        this.sound_on = false;
        this.musicId = -1;
        this.musicId_temp = -1;
        this.volume = 30;
        this.loop = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        Sound.soundListener = this;
    }

    private Player createMusic(int id, int flag) {
        if(flag >= 0) {
            try {
                if(this.snd_music != null) {
                    this.snd_music.close();
                }
                this.snd_music = null;
                this.snd_music = Manager.createPlayer(("/music/" + id + ".mid"), new String[]{"audio/midi", "audio/x-wav"}[flag]);
                this.snd_music.prefetch();
                this.vc_snd = null;
                this.createVolume(((int)this.volume));
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
            }
            return this.snd_music;
        }
        return this.snd_music;
    }

    private Player createMusicForMenu(int id, int flag) {
        if(flag >= 0) {
            try {
                if(this.snd_music != null) {
                    this.snd_music.close();
                }
                this.snd_music = null;
                this.snd_music = Manager.createPlayer(("/music/" + id + ".mid"), new String[]{"audio/midi", "audio/x-wav"}[flag]);
                this.snd_music.prefetch();
                this.vc_snd = null;
                this.createVolumeForMenu(((int)this.volume));
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
            }
            return this.snd_music;
        }
        return this.snd_music;
    }

    private void createVolume(int volume) {
        if(this.vc_snd == null) {
            this.vc_snd = (VolumeControl)this.snd_music.getControl("VolumeControl");
        }
        Log.e("", "这个游戏的音乐是" + volume);
        this.vc_snd.setLevel(volume);
    }

    private void createVolumeForMenu(int volume) {
        if(this.vc_snd == null) {
            this.vc_snd = (VolumeControl)this.snd_music.getControl("VolumeControl");
        }
        Log.e("", "这个游戏的音乐是" + volume);
        this.vc_snd.setLevelForMenu(volume);
    }

    public boolean getHaveSoundPlayState() {
        try {
            if(this.snd_music != null && this.snd_music.getState() == 400) {
                System.out.println("getHaveSoundPlayState() true");
                return true;
            }
            System.out.println("getHaveSoundPlayState() false");
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            System.out.println("getHaveSoundPlayState() false");
        }
        return false;
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

    public static Sound i() {
        if(Sound.soundListener == null) {
            Sound.soundListener = new Sound();
        }
        return Sound.soundListener;
    }

    public void keyVolume(int mode) {
        switch(mode) {
            case 0: {
                byte b = (byte)(this.volume + 30);
                this.volume = b;
                if(b > 90) {
                    this.volume = 0;
                }
                break;
            }
            case 1: {
                if(Ms.i().key_Right()) {
                    byte b1 = (byte)(this.volume + 30);
                    this.volume = b1;
                    if(b1 > 90) {
                        this.volume = 0;
                    }
                    else if(Ms.i().key_Left()) {
                        byte b2 = (byte)(this.volume - 30);
                        this.volume = b2;
                        if(b2 < 0) {
                            this.volume = 90;
                        }
                    }
                }
            }
        }
        if(this.volume == 0) {
            this.sound_on = false;
            this.soundStop();
            return;
        }
        this.sound_on = true;
    }

    void playTone() {
    }

    public void setMusic(boolean b) {
        if(!this.sound_on || this.musicId < 0) {
            return;
        }
        try {
            if(this.musicId_temp != this.musicId || b) {
                this.loop_s = this.loop[this.musicId];
                this.play_music = this.musicId;
                this.musicId_temp = this.play_music;
                if(this.snd_music != null) {
                    this.snd_music.close();
                }
                this.snd_music = null;
                this.createMusic(((int)this.play_music), 0);
            }
            this.sound_play = true;
        }
        catch(Exception unused_ex) {
            this.sound_play = false;
        }
    }

    public void setMusicForMenu(boolean b) {
        if(!this.sound_on || this.musicId < 0) {
            return;
        }
        try {
            if(this.musicId_temp != this.musicId || b) {
                this.loop_s = this.loop[this.musicId];
                this.play_music = this.musicId;
                this.musicId_temp = this.play_music;
                if(this.snd_music != null) {
                    this.snd_music.close();
                }
                this.snd_music = null;
                this.createMusicForMenu(((int)this.play_music), 0);
            }
            this.sound_play = true;
        }
        catch(Exception unused_ex) {
            this.sound_play = false;
        }
    }

    public void setMusicId(int musicId_) {
        this.musicId = (byte)musicId_;
    }

    public void setSoundON(boolean sound_on_) {
        this.sound_on = sound_on_;
    }

    public void setVolume(int volume_) {
        this.volume = (byte)volume_;
    }

    public void soundPlay() {
        if(this.sound_on && this.play_music >= 0 && this.sound_play) {
            if(this.loop_s == -1 && this.snd_music != null) {
                this.snd_music.setLoopCount(-1);
                this.soundStart();
                this.play_music = -1;
                return;
            }
            if(this.loop_s > 0 && this.snd_music != null && this.snd_music.getState() != 400) {
                this.snd_music.setLoopCount(1);
                this.soundStart();
                this.loop_s = (byte)(this.loop_s - 1);
                return;
            }
            if(this.loop_s == 0) {
                this.play_music = -1;
            }
        }
    }

    public void soundStart() {
        try {
            this.snd_music.start();
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
    }

    public void soundStop() {
        try {
            if(this.snd_music != null) {
                this.snd_music.close();
            }
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
        finally {
            this.sound_play = false;
        }
    }
}

