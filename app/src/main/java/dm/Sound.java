package dm;

import android.util.Log;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;

public final class Sound {
   private static Sound soundListener;
   public byte[] loop = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
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
      super();
      soundListener = this;
   }

   private Player createMusic(int var1, int var2) {
      if (var2 >= 0) {
         try {
            if (this.snd_music != null) {
               this.snd_music.close();
            }

            this.snd_music = null;
            StringBuilder var3 = new StringBuilder("/music/");
            this.snd_music = Manager.createPlayer(var3.append(var1).append(".mid").toString(), (new String[]{"audio/midi", "audio/x-wav"})[var2]);
            this.snd_music.prefetch();
            this.vc_snd = null;
            this.createVolume(this.volume);
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

      return this.snd_music;
   }

   private Player createMusicForMenu(int var1, int var2) {
      if (var2 >= 0) {
         try {
            if (this.snd_music != null) {
               this.snd_music.close();
            }

            this.snd_music = null;
            StringBuilder var3 = new StringBuilder("/music/");
            this.snd_music = Manager.createPlayer(var3.append(var1).append(".mid").toString(), (new String[]{"audio/midi", "audio/x-wav"})[var2]);
            this.snd_music.prefetch();
            this.vc_snd = null;
            this.createVolumeForMenu(this.volume);
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

      return this.snd_music;
   }

   private void createVolume(int var1) {
      if (this.vc_snd == null) {
         this.vc_snd = (VolumeControl)this.snd_music.getControl("VolumeControl");
      }

      Log.e("", "\u8fd9\u4e2a\u6e38\u620f\u7684\u97f3\u4e50\u662f" + var1);
      this.vc_snd.setLevel(var1);
   }

   private void createVolumeForMenu(int var1) {
      if (this.vc_snd == null) {
         this.vc_snd = (VolumeControl)this.snd_music.getControl("VolumeControl");
      }

      Log.e("", "\u8fd9\u4e2a\u6e38\u620f\u7684\u97f3\u4e50\u662f" + var1);
      this.vc_snd.setLevelForMenu(var1);
   }

   public static Sound i() {
      if (soundListener == null) {
         soundListener = new Sound();
      }

      return soundListener;
   }

   public boolean getHaveSoundPlayState() {
      boolean var1;
      label34: {
         try {
            if (this.snd_music != null && this.snd_music.getState() == 400) {
               System.out.println("getHaveSoundPlayState() true");
               break label34;
            }

            System.out.println("getHaveSoundPlayState() false");
         } catch (Exception var3) {
            var3.printStackTrace();
            System.out.println("getHaveSoundPlayState() false");
            var1 = false;
            return var1;
         }

         var1 = false;
         return var1;
      }

      var1 = true;
      return var1;
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

   public void keyVolume(int var1) {
      byte var2;
      if (var1 == 0) {
         var2 = (byte)(this.volume + 30);
         this.volume = var2;
         if (var2 > 90) {
            this.volume = 0;
         }
      } else if (var1 == 1 && Ms.i().key_Right()) {
         var2 = (byte)(this.volume + 30);
         this.volume = var2;
         if (var2 > 90) {
            this.volume = 0;
         } else if (Ms.i().key_Left()) {
            var2 = (byte)(this.volume - 30);
            this.volume = var2;
            if (var2 < 0) {
               this.volume = 90;
            }
         }
      }

      if (this.volume == 0) {
         this.sound_on = false;
         this.soundStop();
      } else {
         this.sound_on = true;
      }

   }

   void playTone() {
   }

   public void setMusic(boolean var1) {
      if (this.sound_on && this.musicId >= 0) {
         label42: {
            boolean var10001;
            label47: {
               label40: {
                  try {
                     if (this.musicId_temp != this.musicId) {
                        break label40;
                     }
                  } catch (Exception var6) {
                     var10001 = false;
                     break label42;
                  }

                  if (!var1) {
                     break label47;
                  }
               }

               try {
                  this.loop_s = this.loop[this.musicId];
                  this.play_music = this.musicId;
                  this.musicId_temp = this.play_music;
                  if (this.snd_music != null) {
                     this.snd_music.close();
                  }
               } catch (Exception var5) {
                  var10001 = false;
                  break label42;
               }

               try {
                  this.snd_music = null;
                  this.createMusic(this.play_music, 0);
               } catch (Exception var4) {
                  var10001 = false;
                  break label42;
               }
            }

            try {
               this.sound_play = true;
               return;
            } catch (Exception var3) {
               var10001 = false;
            }
         }

         this.sound_play = false;
      }

   }

   public void setMusicForMenu(boolean var1) {
      if (this.sound_on && this.musicId >= 0) {
         label42: {
            boolean var10001;
            label47: {
               label40: {
                  try {
                     if (this.musicId_temp != this.musicId) {
                        break label40;
                     }
                  } catch (Exception var6) {
                     var10001 = false;
                     break label42;
                  }

                  if (!var1) {
                     break label47;
                  }
               }

               try {
                  this.loop_s = this.loop[this.musicId];
                  this.play_music = this.musicId;
                  this.musicId_temp = this.play_music;
                  if (this.snd_music != null) {
                     this.snd_music.close();
                  }
               } catch (Exception var5) {
                  var10001 = false;
                  break label42;
               }

               try {
                  this.snd_music = null;
                  this.createMusicForMenu(this.play_music, 0);
               } catch (Exception var4) {
                  var10001 = false;
                  break label42;
               }
            }

            try {
               this.sound_play = true;
               return;
            } catch (Exception var3) {
               var10001 = false;
            }
         }

         this.sound_play = false;
      }

   }

   public void setMusicId(int var1) {
      this.musicId = (byte)var1;
   }

   public void setSoundON(boolean var1) {
      this.sound_on = var1;
   }

   public void setVolume(int var1) {
      this.volume = (byte)var1;
   }

   public void soundPlay() {
      if (this.sound_on && this.play_music >= 0 && this.sound_play) {
         if (this.loop_s == -1 && this.snd_music != null) {
            this.snd_music.setLoopCount(-1);
            this.soundStart();
            this.play_music = -1;
         } else if (this.loop_s > 0 && this.snd_music != null && this.snd_music.getState() != 400) {
            this.snd_music.setLoopCount(1);
            this.soundStart();
            --this.loop_s;
         } else if (this.loop_s == 0) {
            this.play_music = -1;
         }
      }

   }

   public void soundStart() {
      try {
         this.snd_music.start();
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public void soundStop() {
      boolean var4 = false;

      label57: {
         try {
            var4 = true;
            if (this.snd_music != null) {
               this.snd_music.close();
               var4 = false;
            } else {
               var4 = false;
            }
            break label57;
         } catch (Exception var5) {
            var5.printStackTrace();
            var4 = false;
         } finally {
            if (var4) {
               this.sound_play = false;
            }
         }

         this.sound_play = false;
         return;
      }

      this.sound_play = false;
   }
}
