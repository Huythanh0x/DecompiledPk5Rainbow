package dm.Sound;
import java.lang.Object;
import javax.microedition.media.Player;
import java.lang.String;
import java.lang.StringBuilder;
import javax.microedition.media.Manager;
import java.lang.Exception;
import javax.microedition.media.Control;
import javax.microedition.media.control.VolumeControl;
import android.util.Log;
import java.lang.System;
import java.io.PrintStream;
import dm.Ms;

public final class Sound	// class@0000e3 from classes.dex
{
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
    private static Sound soundListener;

    public void Sound(){
       super();
       this.sound_play = false;
       this.sound_on = false;
       this.musicId = -1;
       this.musicId_temp = -1;
       this.volume = 30;
       this.loop = new byte[10]{0xff,0xff,0xff,0xff,0xff,0xff,0xff,0xff,0xff,0xff};
       Sound.soundListener = this;
    }
    private Player createMusic(int id,int flag){
       try{
          String[] stringArray = new String[]{"audio/midi","audio/x-wav"};
          if (flag >= 0) {
             if (this.snd_music != null) {
                this.snd_music.close();
             }
             this.snd_music = null;
             this.snd_music = Manager.createPlayer("/music/"+id+".mid", stringArray[flag]);
             this.snd_music.prefetch();
             this.vc_snd = null;
             this.createVolume(this.volume);
          }
       }catch(java.lang.Exception e2){
          Exception e = e2;
          e.printStackTrace();
       }
       return this.snd_music;
    }
    private Player createMusicForMenu(int id,int flag){
       try{
          String[] stringArray = new String[]{"audio/midi","audio/x-wav"};
          if (flag >= 0) {
             if (this.snd_music != null) {
                this.snd_music.close();
             }
             this.snd_music = null;
             this.snd_music = Manager.createPlayer("/music/"+id+".mid", stringArray[flag]);
             this.snd_music.prefetch();
             this.vc_snd = null;
             this.createVolumeForMenu(this.volume);
          }
       }catch(java.lang.Exception e2){
          Exception e = e2;
          e.printStackTrace();
       }
       return this.snd_music;
    }
    private void createVolume(int volume){
       if (this.vc_snd == null) {
          this.vc_snd = this.snd_music.getControl("VolumeControl");
       }
       Log.e("", "\x8f\x02\x4e\x02\x6e\x02\x62\x02\x76\x02\x97\x02\x4e\x02\x66\x02"+volume);
       this.vc_snd.setLevel(volume);
       return;
    }
    private void createVolumeForMenu(int volume){
       if (this.vc_snd == null) {
          this.vc_snd = this.snd_music.getControl("VolumeControl");
       }
       Log.e("", "\x8f\x02\x4e\x02\x6e\x02\x62\x02\x76\x02\x97\x02\x4e\x02\x66\x02"+volume);
       this.vc_snd.setLevelForMenu(volume);
       return;
    }
    public static Sound i(){
       if (Sound.soundListener == null) {
          Sound.soundListener = new Sound();
       }
       return Sound.soundListener;
    }
    public boolean getHaveSoundPlayState(){
       boolean b;
       int i = 0;
       try{
          if (this.snd_music != null && this.snd_music.getState() == 400) {
             System.out.println("getHaveSoundPlayState\(\) true");
             b = true;
          }else {
             System.out.println("getHaveSoundPlayState\(\) false");
             b = i;
          }
       }catch(java.lang.Exception e1){
          Exception e = e1;
          e.printStackTrace();
          System.out.println("getHaveSoundPlayState\(\) false");
          b = i;
       }
       return b;
    }
    public byte getMusicId(){
       return this.musicId;
    }
    public boolean getSoundON(){
       return this.sound_on;
    }
    public byte getVolume(){
       return this.volume;
    }
    public void keyVolume(int mode){
       byte b;
       if (!mode) {
          b = (byte)(this.volume + 30);
          this.volume = b;
          if (b > 90) {
             this.volume = 0;
          }
       }else if(mode == 1 && Ms.i().key_Right()){
          b = (byte)(this.volume + 30);
          this.volume = b;
          if (b > 90) {
             this.volume = 0;
          }else if(Ms.i().key_Left()){
             b = (byte)(this.volume - 30);
             this.volume = b;
             if (b < 0) {
                this.volume = 90;
             }
          }
       }
       if (this.volume == null) {
          this.sound_on = false;
          this.soundStop();
       }else {
          this.sound_on = true;
       }
       return;
    }
    void playTone(){
    }
    public void setMusic(boolean b){
       try{
          if (this.sound_on != null && this.musicId >= null) {
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
       }catch(java.lang.Exception e1){
          Exception ex = e1;
          this.sound_play = false;
       }
       return;
    }
    public void setMusicForMenu(boolean b){
       try{
          if (this.sound_on != null && this.musicId >= null) {
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
       }catch(java.lang.Exception e1){
          Exception ex = e1;
          this.sound_play = false;
       }
       return;
    }
    public void setMusicId(int musicId_){
       this.musicId = (byte)musicId_;
    }
    public void setSoundON(boolean sound_on_){
       this.sound_on = sound_on_;
    }
    public void setVolume(int volume_){
       this.volume = (byte)volume_;
    }
    public void soundPlay(){
       if (this.sound_on != null && (this.play_music >= null && this.sound_play != null)) {
          if (this.loop_s == -1 && this.snd_music != null) {
             this.snd_music.setLoopCount(-1);
             this.soundStart();
             this.play_music = -1;
          }else if(this.loop_s > null && (this.snd_music != null && this.snd_music.getState() != 400)){
             this.snd_music.setLoopCount(1);
             this.soundStart();
             this.loop_s = (byte)(this.loop_s - 1);
          }else if(this.loop_s == null){
             this.play_music = -1;
          }
       }
       return;
    }
    public void soundStart(){
       try{
          this.snd_music.start();
       }catch(java.lang.Exception e1){
          Exception ex = e1;
          ex.printStackTrace();
       }
       return;
    }
    public void soundStop(){
       boolean b = false;
       try{
          if (this.snd_music != null) {
             this.snd_music.close();
          }
          this.sound_play = b;
       }catch(java.lang.Exception e1){
          Exception e = e1;
          e.printStackTrace();
          this.sound_play = b;
       }
       return;
    }
}
