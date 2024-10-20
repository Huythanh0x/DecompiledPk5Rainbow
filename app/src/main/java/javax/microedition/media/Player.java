package javax.microedition.media;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;
import com.android.Util.AndroidUtil;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import javax.microedition.media.control.ToneControl;
import javax.microedition.media.control.VolumeControl;

public class Player implements MediaPlayer.OnCompletionListener {
   public static final int CLOSED = 0;
   public static final int PREFETCHED = 300;
   public static final int REALIZED = 200;
   public static final int STARTED = 400;
   public static final long TIME_UNKNOWN = -1L;
   public static final int UNREALIZED = 100;
   private String dateSource;
   private int loopCount;
   private MediaPlayer mp = new MediaPlayer();
   private int playedCount;
   private Vector playerListeners = new Vector();
   private int state = 100;
   private String type;

   public Player() {
      super();
      this.mp.setOnCompletionListener(this);
      this.mp.setLooping(false);
      this.dateSource = null;
      this.type = null;
   }

   private final void onEvent(String var1, Object var2) {
      Iterator var3 = this.playerListeners.iterator();

      while(var3.hasNext()) {
         ((PlayerListener)var3.next()).playerUpdate(this, var1, var2);
      }

   }

   public void addPlayerListener(PlayerListener var1) {
      if (!this.playerListeners.contains(var1)) {
         this.playerListeners.add(var1);
      }

   }

   public void close() {
      if (this.mp != null) {
         if (this.state == 400) {
            this.onEvent("stopped", (Object)null);
            this.mp.stop();
         }

         this.mp.release();
         this.onEvent("closed", (Object)null);
         this.state = 0;
      }

   }

   public void deallocate() {
   }

   public String getContentType() {
      return this.type;
   }

   public Control getControl(String var1) {
      Object var2;
      if (var1.indexOf("VolumeControl") != -1) {
         var2 = new VolumeControl();
      } else if (var1.indexOf("ToneControl") != -1) {
         var2 = new ToneControl();
      } else {
         Log.e("ERROR", "PLAYER IS ERROR");
         var2 = null;
      }

      return (Control)var2;
   }

   public long getDuration() {
      long var1 = (long)(this.mp.getDuration() * 1000);
      if (var1 <= 0L) {
         var1 = -1L;
      }

      return var1;
   }

   public long getMediaTime() {
      long var1 = (long)(this.mp.getCurrentPosition() * 1000);
      if (var1 <= 0L) {
         var1 = -1L;
      }

      return var1;
   }

   public int getState() {
      return this.state;
   }

   public void onCompletion(MediaPlayer var1) {
      if (var1 == this.mp) {
         ++this.playedCount;
         if (this.playedCount >= this.loopCount && this.loopCount != -1) {
            var1.setLooping(false);
            this.onEvent("endOfMedia", (Object)null);
         }
      }

   }

   public void prefetch() throws MediaException {
      if (this.state < 300) {
         if (this.state < 200) {
            this.realize();
         }

         try {
            this.mp.prepare();
         } catch (IllegalStateException var2) {
            var2.printStackTrace();
         } catch (IOException var3) {
            var3.printStackTrace();
         }

         this.state = 300;
      }

   }

   public void realize() throws MediaException {
      if (this.state < 200) {
         try {
            if (Manager.getIsLocator()) {
               this.mp.setDataSource(this.dateSource);
            } else {
               AssetFileDescriptor var1 = AndroidUtil.am.openFd(this.dateSource);
               this.mp.setDataSource(var1.getFileDescriptor(), var1.getStartOffset(), var1.getLength());
            }
         } catch (IOException var2) {
            throw new MediaException();
         }

         this.state = 200;
      }

   }

   public void removePlayerListener(PlayerListener var1) {
      this.playerListeners.remove(var1);
   }

   public void setDatasource(String var1) {
      this.dateSource = var1;
   }

   public void setLoopCount(int var1) throws IllegalArgumentException, IllegalStateException {
      if (this.state == 400) {
         throw new IllegalStateException("player is close");
      } else if (var1 == 0) {
         throw new IllegalArgumentException("loopcount is 0");
      } else {
         if (var1 != -1 && var1 <= 1) {
            Log.e("Player", "Loop count < -1");
         } else {
            this.mp.setLooping(true);
            this.loopCount = var1;
         }

      }
   }

   public long setMediaTime(long var1) throws MediaException {
      int var4 = (int)var1 / 1000;
      int var3;
      if (var4 < 0) {
         var3 = 0;
         var1 = 0L;
      } else {
         var3 = var4;
         if (var4 > this.mp.getDuration()) {
            var3 = this.mp.getDuration();
            var1 = (long)(this.mp.getDuration() * 1000);
         }
      }

      this.mp.seekTo(var3);
      return var1;
   }

   public void setType(String var1) {
      this.type = var1;
   }

   public void start() throws MediaException {
      if (this.state < 400) {
         if (this.state < 200) {
            this.realize();
         }

         if (this.state < 300) {
            this.prefetch();
         }

         if (this.state == 200 || this.state == 300) {
            this.playedCount = 0;

            try {
               this.mp.start();
            } catch (IllegalStateException var2) {
               this.onEvent("error", var2.getMessage());
               throw new MediaException();
            }

            this.onEvent("started", (Object)null);
            this.state = 400;
         }
      }

   }

   public void stop() throws MediaException {
      if (this.state >= 400) {
         try {
            this.mp.pause();
         } catch (IllegalStateException var2) {
            this.onEvent("error", var2.getMessage());
            throw new MediaException();
         }

         this.onEvent("stopped", (Object)null);
         this.state = 300;
      }

   }
}
