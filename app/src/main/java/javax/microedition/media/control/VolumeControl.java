package javax.microedition.media.control;

import android.media.AudioManager;
import android.util.Log;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.media.Control;

public class VolumeControl implements Control {
   private AudioManager audioManager = (AudioManager)CwaActivity.getContextInstance().getSystemService("audio");
   private int currentVolume = 0;
   private int maxVolume;
   private boolean mute = false;
   private float percent;

   public VolumeControl() {
      super();
      this.maxVolume = this.audioManager.getStreamMaxVolume(3);
      this.percent = (float)(100 / this.maxVolume);
   }

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

   public boolean isMuted() {
      boolean var1;
      if (this.getLevel() == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public int setLevel(int var1) {
      int var2;
      if (var1 < 0) {
         var2 = 0;
      } else {
         var2 = var1;
         if (var1 > 100) {
            var2 = 100;
         }
      }

      var1 = (int)((float)var2 / this.percent);
      if (!this.mute) {
         this.currentVolume = var1;
         Log.e("", "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u7684\u6bd4\u4f8b\u503c\u662f" + this.percent);
         Log.e("", "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u58f0\u97f3\u662f" + var1);
      }

      return var2;
   }

   public int setLevelForMenu(int var1) {
      int var2;
      if (var1 < 0) {
         var2 = 0;
      } else {
         var2 = var1;
         if (var1 > 100) {
            var2 = 100;
         }
      }

      var1 = (int)((float)var2 / this.percent);
      if (!this.mute) {
         this.currentVolume = var1;
         Log.e("", "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u7684\u6bd4\u4f8b\u503c\u662f" + this.percent);
         Log.e("", "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u58f0\u97f3\u662f" + var1);
         Log.e("", "dddddddddddddddddddddd");
         this.audioManager.setStreamVolume(3, var1, 16);
      }

      return var2;
   }

   public void setMute(boolean var1) {
      if (var1) {
         this.mute();
      } else {
         this.unmute();
      }

   }
}
