package dm;

import android.util.Log;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;

public final class Sound {
  private static Sound soundListener;
  
  public byte[] loop = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  
  private byte loop_s;
  
  private byte musicId = -1;
  
  private byte musicId_temp = -1;
  
  private byte play_music;
  
  private Player snd_music;
  
  private boolean sound_on = false;
  
  private boolean sound_play = false;
  
  private VolumeControl vc_snd;
  
  private byte volume = 30;
  
  public Sound() {
    soundListener = this;
  }
  
  private Player createMusic(int paramInt1, int paramInt2) {
    if (paramInt2 >= 0)
      try {
        if (this.snd_music != null)
          this.snd_music.close(); 
        this.snd_music = null;
        StringBuilder stringBuilder = new StringBuilder();
        this("/music/");
        (new String[2])[0] = "audio/midi";
        (new String[2])[1] = "audio/x-wav";
        this.snd_music = Manager.createPlayer(stringBuilder.append(paramInt1).append(".mid").toString(), (new String[2])[paramInt2]);
        this.snd_music.prefetch();
        this.vc_snd = null;
        createVolume(this.volume);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return this.snd_music;
  }
  
  private Player createMusicForMenu(int paramInt1, int paramInt2) {
    if (paramInt2 >= 0)
      try {
        if (this.snd_music != null)
          this.snd_music.close(); 
        this.snd_music = null;
        StringBuilder stringBuilder = new StringBuilder();
        this("/music/");
        (new String[2])[0] = "audio/midi";
        (new String[2])[1] = "audio/x-wav";
        this.snd_music = Manager.createPlayer(stringBuilder.append(paramInt1).append(".mid").toString(), (new String[2])[paramInt2]);
        this.snd_music.prefetch();
        this.vc_snd = null;
        createVolumeForMenu(this.volume);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return this.snd_music;
  }
  
  private void createVolume(int paramInt) {
    if (this.vc_snd == null)
      this.vc_snd = (VolumeControl)this.snd_music.getControl("VolumeControl"); 
    Log.e("", "这个游戏的音乐是" + paramInt);
    this.vc_snd.setLevel(paramInt);
  }
  
  private void createVolumeForMenu(int paramInt) {
    if (this.vc_snd == null)
      this.vc_snd = (VolumeControl)this.snd_music.getControl("VolumeControl"); 
    Log.e("", "这个游戏的音乐是" + paramInt);
    this.vc_snd.setLevelForMenu(paramInt);
  }
  
  public static Sound i() {
    if (soundListener == null)
      soundListener = new Sound(); 
    return soundListener;
  }
  
  public boolean getHaveSoundPlayState() {
    boolean bool;
    try {
      if (this.snd_music != null && this.snd_music.getState() == 400) {
        System.out.println("getHaveSoundPlayState() true");
        return true;
      } 
      System.out.println("getHaveSoundPlayState() false");
      bool = false;
    } catch (Exception exception) {
      exception.printStackTrace();
      System.out.println("getHaveSoundPlayState() false");
      bool = false;
    } 
    return bool;
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
  
  public void keyVolume(int paramInt) {
    if (paramInt == 0) {
      byte b = (byte)(this.volume + 30);
      this.volume = b;
      if (b > 90)
        this.volume = 0; 
    } else if (paramInt == 1 && Ms.i().key_Right()) {
      byte b = (byte)(this.volume + 30);
      this.volume = b;
      if (b > 90) {
        this.volume = 0;
      } else if (Ms.i().key_Left()) {
        b = (byte)(this.volume - 30);
        this.volume = b;
        if (b < 0)
          this.volume = 90; 
      } 
    } 
    if (this.volume == 0) {
      this.sound_on = false;
      soundStop();
      return;
    } 
    this.sound_on = true;
  }
  
  void playTone() {}
  
  public void setMusic(boolean paramBoolean) {
    if (this.sound_on && this.musicId >= 0)
      try {
        if (this.musicId_temp != this.musicId || paramBoolean) {
          this.loop_s = this.loop[this.musicId];
          this.play_music = this.musicId;
          this.musicId_temp = this.play_music;
          if (this.snd_music != null)
            this.snd_music.close(); 
          this.snd_music = null;
          createMusic(this.play_music, 0);
        } 
        this.sound_play = true;
      } catch (Exception exception) {
        this.sound_play = false;
      }  
  }
  
  public void setMusicForMenu(boolean paramBoolean) {
    if (this.sound_on && this.musicId >= 0)
      try {
        if (this.musicId_temp != this.musicId || paramBoolean) {
          this.loop_s = this.loop[this.musicId];
          this.play_music = this.musicId;
          this.musicId_temp = this.play_music;
          if (this.snd_music != null)
            this.snd_music.close(); 
          this.snd_music = null;
          createMusicForMenu(this.play_music, 0);
        } 
        this.sound_play = true;
      } catch (Exception exception) {
        this.sound_play = false;
      }  
  }
  
  public void setMusicId(int paramInt) {
    this.musicId = (byte)paramInt;
  }
  
  public void setSoundON(boolean paramBoolean) {
    this.sound_on = paramBoolean;
  }
  
  public void setVolume(int paramInt) {
    this.volume = (byte)paramInt;
  }
  
  public void soundPlay() {
    if (this.sound_on && this.play_music >= 0 && this.sound_play) {
      if (this.loop_s == -1 && this.snd_music != null) {
        this.snd_music.setLoopCount(-1);
        soundStart();
        this.play_music = -1;
        return;
      } 
      if (this.loop_s > 0 && this.snd_music != null && this.snd_music.getState() != 400) {
        this.snd_music.setLoopCount(1);
        soundStart();
        this.loop_s = (byte)(this.loop_s - 1);
        return;
      } 
      if (this.loop_s == 0)
        this.play_music = -1; 
    } 
  }
  
  public void soundStart() {
    try {
      this.snd_music.start();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void soundStop() {
    try {
      if (this.snd_music != null)
        this.snd_music.close(); 
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } finally {
      this.sound_play = false;
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/dm/Sound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */