package dm;

import android.util.Log;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;

/* loaded from: classes.dex */
/**
 * The Sound class is responsible for managing the sound and music playback within the application.
 * It provides methods to control sound settings, play music, and manage volume levels.
 * This class follows the singleton pattern to ensure only one instance is used throughout the application.
 */
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

    /**
     * Private constructor to prevent instantiation from outside the class.
     * Initializes the soundListener to this instance.
     */
    public Sound() {
        soundListener = this;
    }

    /**
     * Returns the singleton instance of the Sound class.
     * If the instance is null, it creates a new one.
     *
     * @return the singleton instance of the Sound class.
     */
    public static Sound i() {
        if (soundListener == null) {
            soundListener = new Sound();
        }
        return soundListener;
    }

    /**
     * Sets the sound on or off.
     *
     * @param sound_on_ true to turn the sound on, false to turn it off.
     */
    public void setSoundON(boolean sound_on_) {
        this.sound_on = sound_on_;
    }

    /**
     * Returns the current state of the sound.
     *
     * @return true if the sound is on, false otherwise.
     */
    public boolean getSoundON() {
        return this.sound_on;
    }

    /**
     * Sets the music ID to be played.
     *
     * @param musicId_ the ID of the music to be played.
     */
    public void setMusicId(int musicId_) {
        this.musicId = (byte) musicId_;
    }

    /**
     * Returns the current music ID.
     *
     * @return the current music ID.
     */
    public byte getMusicId() {
        return this.musicId;
    }

    /**
     * Sets the volume level.
     *
     * @param volume_ the volume level to be set.
     */
    public void setVolume(int volume_) {
        this.volume = (byte) volume_;
    }

    /**
     * Returns the current volume level.
     *
     * @return the current volume level.
     */
    public byte getVolume() {
        return this.volume;
    }

    /**
     * Creates a music player for the menu with the specified ID and flag.
     *
     * @param id   the ID of the music to be played.
     * @param flag the flag indicating the type of music.
     * @return the created music player.
     */
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

    /**
     * Creates a music player with the specified ID and flag.
     *
     * @param id   the ID of the music to be played.
     * @param flag the flag indicating the type of music.
     * @return the created music player.
     */
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

    /**
     * Sets the music to be played based on the current settings.
     *
     * @param b a boolean flag indicating whether to force the music to be set.
     */
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

    /**
     * Sets the music to be played for the menu based on the current settings.
     *
     * @param b a boolean flag indicating whether to force the music to be set.
     */
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

    /**
     * Starts the music playback.
     */
    public void soundStart() {
        try {
            this.snd_music.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Plays the sound based on the current settings.
     */
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

    /**
     * Stops the sound playback.
     */
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

    /**
     * Creates the volume control for the menu with the specified volume level.
     *
     * @param volume the volume level to be set.
     */
    private void createVolumeForMenu(int volume) {
        if (this.vc_snd == null) {
            this.vc_snd = (VolumeControl) this.snd_music.getControl("VolumeControl");
        }
        Log.e("", "The music of this game is" + volume);
        this.vc_snd.setLevelForMenu(volume);
    }

    /**
     * Creates the volume control with the specified volume level.
     *
     * @param volume the volume level to be set.
     */
    private void createVolume(int volume) {
        if (this.vc_snd == null) {
            this.vc_snd = (VolumeControl) this.snd_music.getControl("VolumeControl");
        }
        Log.e("", "The music of this game is" + volume);
        this.vc_snd.setLevel(volume);
    }

    /**
     * Adjusts the volume based on the specified mode.
     *
     * @param mode the mode indicating how to adjust the volume.
     */
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

    /**
     * Returns the state of whether there is sound currently playing.
     *
     * @return true if there is sound playing, false otherwise.
     */
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
