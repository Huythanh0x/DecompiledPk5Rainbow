package javax.microedition.media.control.VolumeControl;
import javax.microedition.media.Control;
import java.lang.Object;
import android.content.Context;
import javax.microedition.lcdui.CwaActivity;
import java.lang.String;
import android.media.AudioManager;
import java.lang.StringBuilder;
import android.util.Log;

public class VolumeControl implements Control	// class@00014f from classes.dex
{
    private AudioManager audioManager;
    private int currentVolume;
    private int maxVolume;
    private boolean mute;
    private float percent;

    public void VolumeControl(){
       super();
       this.mute = false;
       this.currentVolume = 0;
       this.audioManager = CwaActivity.getContextInstance().getSystemService("audio");
       this.maxVolume = this.audioManager.getStreamMaxVolume(3);
       this.percent = (float)(100 / this.maxVolume);
    }
    private void mute(){
       this.mute = true;
       this.audioManager.setStreamVolume(3, 0, 16);
    }
    private void unmute(){
       this.mute = false;
       this.audioManager.setStreamVolume(3, this.currentVolume, 16);
    }
    public int getLevel(){
       return (int)((float)this.currentVolume * this.percent);
    }
    public boolean isMuted(){
       boolean b = (!this.getLevel())? true: false;
       return b;
    }
    public int setLevel(int level){
       if (level < 0) {
          level = 0;
       }else if(level > 100){
          level = 100;
       }
       int androidLevel = (int)((float)level / this.percent);
       if (this.mute == null) {
          this.currentVolume = androidLevel;
          Log.e("", "\x8f\x02\x4e\x02\x6e\x02\x62\x02\x76\x02\x7b\x02\x74\x02\x56\x02\x76\x02\x6b\x02\x4f\x02\x50\x02\x66\x02"+this.percent);
          Log.e("", "\x8f\x02\x4e\x02\x6e\x02\x62\x02\x76\x02\x7b\x02\x74\x02\x56\x02\x58\x02\x97\x02\x66\x02"+androidLevel);
       }
       return level;
    }
    public int setLevelForMenu(int level){
       if (level < 0) {
          level = 0;
       }else if(level > 100){
          level = 100;
       }
       int androidLevel = (int)((float)level / this.percent);
       if (this.mute == null) {
          this.currentVolume = androidLevel;
          Log.e("", "\x8f\x02\x4e\x02\x6e\x02\x62\x02\x76\x02\x7b\x02\x74\x02\x56\x02\x76\x02\x6b\x02\x4f\x02\x50\x02\x66\x02"+this.percent);
          Log.e("", "\x8f\x02\x4e\x02\x6e\x02\x62\x02\x76\x02\x7b\x02\x74\x02\x56\x02\x58\x02\x97\x02\x66\x02"+androidLevel);
          Log.e("", "dddddddddddddddddddddd");
          this.audioManager.setStreamVolume(3, androidLevel, 16);
       }
       return level;
    }
    public void setMute(boolean mute){
       if (mute) {
          this.mute();
       }else {
          this.unmute();
       }
       return;
    }
}
