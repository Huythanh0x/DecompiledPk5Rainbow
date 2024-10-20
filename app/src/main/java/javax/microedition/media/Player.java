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
  
  private Vector<PlayerListener> playerListeners = new Vector<PlayerListener>();
  
  private int state = 100;
  
  private String type;
  
  public Player() {
    this.mp.setOnCompletionListener(this);
    this.mp.setLooping(false);
    this.dateSource = null;
    this.type = null;
  }
  
  private final void onEvent(String paramString, Object paramObject) {
    Iterator<PlayerListener> iterator = this.playerListeners.iterator();
    while (true) {
      if (!iterator.hasNext())
        return; 
      ((PlayerListener)iterator.next()).playerUpdate(this, paramString, paramObject);
    } 
  }
  
  public void addPlayerListener(PlayerListener paramPlayerListener) {
    if (!this.playerListeners.contains(paramPlayerListener))
      this.playerListeners.add(paramPlayerListener); 
  }
  
  public void close() {
    if (this.mp != null) {
      if (this.state == 400) {
        onEvent("stopped", null);
        this.mp.stop();
      } 
      this.mp.release();
      onEvent("closed", null);
      this.state = 0;
    } 
  }
  
  public void deallocate() {}
  
  public String getContentType() {
    return this.type;
  }
  
  public Control getControl(String paramString) {
    if (paramString.indexOf("VolumeControl") != -1)
      return (Control)new VolumeControl(); 
    if (paramString.indexOf("ToneControl") != -1)
      return (Control)new ToneControl(); 
    Log.e("ERROR", "PLAYER IS ERROR");
    return null;
  }
  
  public long getDuration() {
    long l = (this.mp.getDuration() * 1000);
    if (l <= 0L)
      l = -1L; 
    return l;
  }
  
  public long getMediaTime() {
    long l = (this.mp.getCurrentPosition() * 1000);
    if (l <= 0L)
      l = -1L; 
    return l;
  }
  
  public int getState() {
    return this.state;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer) {
    if (paramMediaPlayer == this.mp) {
      this.playedCount++;
      if (this.playedCount >= this.loopCount && this.loopCount != -1) {
        paramMediaPlayer.setLooping(false);
        onEvent("endOfMedia", null);
      } 
    } 
  }
  
  public void prefetch() throws MediaException {
    if (this.state < 300) {
      if (this.state < 200)
        realize(); 
      try {
        this.mp.prepare();
      } catch (IllegalStateException illegalStateException) {
        illegalStateException.printStackTrace();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
      this.state = 300;
    } 
  }
  
  public void realize() throws MediaException {
    if (this.state < 200)
      try {
        if (Manager.getIsLocator()) {
          this.mp.setDataSource(this.dateSource);
        } else {
          AssetFileDescriptor assetFileDescriptor = AndroidUtil.am.openFd(this.dateSource);
          this.mp.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        } 
        this.state = 200;
        return;
      } catch (IOException iOException) {
        throw new MediaException();
      }  
  }
  
  public void removePlayerListener(PlayerListener paramPlayerListener) {
    this.playerListeners.remove(paramPlayerListener);
  }
  
  public void setDatasource(String paramString) {
    this.dateSource = paramString;
  }
  
  public void setLoopCount(int paramInt) throws IllegalArgumentException, IllegalStateException {
    if (this.state == 400)
      throw new IllegalStateException("player is close"); 
    if (paramInt == 0)
      throw new IllegalArgumentException("loopcount is 0"); 
    if (paramInt == -1 || paramInt > 1) {
      this.mp.setLooping(true);
      this.loopCount = paramInt;
      return;
    } 
    Log.e("Player", "Loop count < -1");
  }
  
  public long setMediaTime(long paramLong) throws MediaException {
    int j = (int)paramLong / 1000;
    if (j < 0) {
      boolean bool = false;
      paramLong = 0L;
      this.mp.seekTo(bool);
      return paramLong;
    } 
    int i = j;
    if (j > this.mp.getDuration()) {
      i = this.mp.getDuration();
      paramLong = (this.mp.getDuration() * 1000);
    } 
    this.mp.seekTo(i);
    return paramLong;
  }
  
  public void setType(String paramString) {
    this.type = paramString;
  }
  
  public void start() throws MediaException {
    if (this.state < 400) {
      if (this.state < 200)
        realize(); 
      if (this.state < 300)
        prefetch(); 
      if (this.state == 200 || this.state == 300) {
        this.playedCount = 0;
        try {
          this.mp.start();
          onEvent("started", null);
          this.state = 400;
          return;
        } catch (IllegalStateException illegalStateException) {
          onEvent("error", illegalStateException.getMessage());
          throw new MediaException();
        } 
      } 
    } 
  }
  
  public void stop() throws MediaException {
    if (this.state >= 400)
      try {
        this.mp.pause();
        onEvent("stopped", null);
        this.state = 300;
        return;
      } catch (IllegalStateException illegalStateException) {
        onEvent("error", illegalStateException.getMessage());
        throw new MediaException();
      }  
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/media/Player.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */