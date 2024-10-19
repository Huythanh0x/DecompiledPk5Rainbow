package dm;

import android.util.Log;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;

/* loaded from: classes.dex */
public final class Sound {
    private static Sound soundListener;
    private byte loop_s;
    private byte play_music;
    private Player snd_music;
    private VolumeControl vc_snd;
    private boolean sound_play = false;
    private boolean sound_on = false;
    private byte musicId = -1;
    private byte musicId_temp = -1;
    private byte volume = 30;
    public byte[] loop = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public Sound() {
        soundListener = this;
    }

    public static Sound i() {
        if (soundListener == null) {
            soundListener = new Sound();
        }
        return soundListener;
    }

    public void setSoundON(boolean sound_on_) {
        this.sound_on = sound_on_;
    }

    public boolean getSoundON() {
        return this.sound_on;
    }

    public void setMusicId(int musicId_) {
        this.musicId = (byte) musicId_;
    }

    public byte getMusicId() {
        return this.musicId;
    }

    public void setVolume(int volume_) {
        this.volume = (byte) volume_;
    }

    public byte getVolume() {
        return this.volume;
    }

    private Player createMusicForMenu(int id, int flag) {
        String[] tt_str = {"audio/midi", "audio/x-wav"};
        if (flag >= 0) {
            try {
                if (this.snd_music != null) {
                    this.snd_music.close();
                }
                this.snd_music = null;
                this.snd_music = Manager.createPlayer("/music/" + id + ".mid", tt_str[flag]);
                this.snd_music.prefetch();
                this.vc_snd = null;
                createVolumeForMenu(this.volume);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.snd_music;
    }

    private Player createMusic(int id, int flag) {
        String[] tt_str = {"audio/midi", "audio/x-wav"};
        if (flag >= 0) {
            try {
                if (this.snd_music != null) {
                    this.snd_music.close();
                }
                this.snd_music = null;
                this.snd_music = Manager.createPlayer("/music/" + id + ".mid", tt_str[flag]);
                this.snd_music.prefetch();
                this.vc_snd = null;
                createVolume(this.volume);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.snd_music;
    }

    public void setMusic(boolean b) {
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
                    createMusic(this.play_music, 0);
                }
                this.sound_play = true;
            } catch (Exception e) {
                this.sound_play = false;
            }
        }
    }

    public void setMusicForMenu(boolean b) {
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
                    createMusicForMenu(this.play_music, 0);
                }
                this.sound_play = true;
            } catch (Exception e) {
                this.sound_play = false;
            }
        }
    }

    public void soundStart() {
        try {
            this.snd_music.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void soundPlay() {
        if (this.sound_on && this.play_music >= 0 && this.sound_play) {
            if (this.loop_s == -1 && this.snd_music != null) {
                this.snd_music.setLoopCount(-1);
                soundStart();
                this.play_music = (byte) -1;
            } else if (this.loop_s > 0 && this.snd_music != null && this.snd_music.getState() != 400) {
                this.snd_music.setLoopCount(1);
                soundStart();
                this.loop_s = (byte) (this.loop_s - 1);
            } else if (this.loop_s == 0) {
                this.play_music = (byte) -1;
            }
        }
    }

    void playTone() {
    }

    public void soundStop() {
        try {
            if (this.snd_music != null) {
                this.snd_music.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.sound_play = false;
        }
    }

    private void createVolumeForMenu(int volume) {
        if (this.vc_snd == null) {
            this.vc_snd = (VolumeControl) this.snd_music.getControl("VolumeControl");
        }
        Log.e("", "这个游戏的音乐是" + volume);
        this.vc_snd.setLevelForMenu(volume);
    }

    private void createVolume(int volume) {
        if (this.vc_snd == null) {
            this.vc_snd = (VolumeControl) this.snd_music.getControl("VolumeControl");
        }
        Log.e("", "这个游戏的音乐是" + volume);
        this.vc_snd.setLevel(volume);
    }

    public void keyVolume(int mode) {
        if (mode == 0) {
            byte b = (byte) (this.volume + 30);
            this.volume = b;
            if (b > 90) {
                this.volume = (byte) 0;
            }
        } else if (mode == 1 && Ms.i().key_Right()) {
            byte b2 = (byte) (this.volume + 30);
            this.volume = b2;
            if (b2 > 90) {
                this.volume = (byte) 0;
            } else if (Ms.i().key_Left()) {
                byte b3 = (byte) (this.volume - 30);
                this.volume = b3;
                if (b3 < 0) {
                    this.volume = (byte) 90;
                }
            }
        }
        if (this.volume == 0) {
            this.sound_on = false;
            soundStop();
        } else {
            this.sound_on = true;
        }
    }

    public boolean getHaveSoundPlayState() {
        boolean z;
        try {
            if (this.snd_music != null && this.snd_music.getState() == 400) {
                System.out.println("getHaveSoundPlayState() true");
                z = true;
            } else {
                System.out.println("getHaveSoundPlayState() false");
                z = false;
            }
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("getHaveSoundPlayState() false");
            return false;
        }
    }
}
