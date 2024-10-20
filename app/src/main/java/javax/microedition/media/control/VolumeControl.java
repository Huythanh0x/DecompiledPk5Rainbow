package javax.microedition.media.control;

import android.media.AudioManager;
import android.util.Log;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.media.Control;

public class VolumeControl implements Control {
  private AudioManager audioManager = (AudioManager)CwaActivity.getContextInstance().getSystemService("audio");
  
  private int currentVolume = 0;
  
  private int maxVolume = this.audioManager.getStreamMaxVolume(3);
  
  private boolean mute = false;
  
  private float percent = (100 / this.maxVolume);
  
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
    return (getLevel() == 0);
  }
  
  public int setLevel(int paramInt) {
    int i;
    if (paramInt < 0) {
      i = 0;
    } else {
      i = paramInt;
      if (paramInt > 100)
        i = 100; 
    } 
    paramInt = (int)(i / this.percent);
    if (!this.mute) {
      this.currentVolume = paramInt;
      Log.e("", "这个游戏的管理器的比例值是" + this.percent);
      Log.e("", "这个游戏的管理器声音是" + paramInt);
    } 
    return i;
  }
  
  public int setLevelForMenu(int paramInt) {
    int i;
    if (paramInt < 0) {
      i = 0;
    } else {
      i = paramInt;
      if (paramInt > 100)
        i = 100; 
    } 
    paramInt = (int)(i / this.percent);
    if (!this.mute) {
      this.currentVolume = paramInt;
      Log.e("", "这个游戏的管理器的比例值是" + this.percent);
      Log.e("", "这个游戏的管理器声音是" + paramInt);
      Log.e("", "dddddddddddddddddddddd");
      this.audioManager.setStreamVolume(3, paramInt, 16);
    } 
    return i;
  }
  
  public void setMute(boolean paramBoolean) {
    if (paramBoolean) {
      mute();
      return;
    } 
    unmute();
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/media/control/VolumeControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */