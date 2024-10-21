package javax.microedition.media.Player;
import android.media.MediaPlayer$OnCompletionListener;
import java.lang.Object;
import android.media.MediaPlayer;
import java.util.Vector;
import java.lang.String;
import java.util.Iterator;
import javax.microedition.media.PlayerListener;
import javax.microedition.media.Control;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.media.control.ToneControl;
import android.util.Log;
import java.lang.IllegalStateException;
import java.io.IOException;
import javax.microedition.media.Manager;
import com.android.Util.AndroidUtil;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.FileDescriptor;
import javax.microedition.media.MediaException;
import java.lang.IllegalArgumentException;

public class Player implements MediaPlayer$OnCompletionListener	// class@00014c from classes.dex
{
    private String dateSource;
    private int loopCount;
    private MediaPlayer mp;
    private int playedCount;
    private Vector playerListeners;
    private int state;
    private String type;
    public static final int CLOSED = 0;
    public static final int PREFETCHED = 300;
    public static final int REALIZED = 200;
    public static final int STARTED = 400;
    public static final long TIME_UNKNOWN = 0xff;
    public static final int UNREALIZED = 100;

    public void Player(){
       super();
       this.state = 100;
       this.mp = new MediaPlayer();
       this.playerListeners = new Vector();
       this.mp.setOnCompletionListener(this);
       this.mp.setLooping(false);
       this.dateSource = null;
       this.type = null;
    }
    private final void onEvent(String event,Object eventData){
       Iterator iterator = this.playerListeners.iterator();
       while (iterator.hasNext()) {
          iterator.next().playerUpdate(this, event, eventData);
       }
       return;
    }
    public void addPlayerListener(PlayerListener playerListener){
       if (!this.playerListeners.contains(playerListener)) {
          this.playerListeners.add(playerListener);
       }
       return;
    }
    public void close(){
       if (this.mp != null) {
          if (this.state == 400) {
             this.onEvent("stopped", null);
             this.mp.stop();
          }
          this.mp.release();
          this.onEvent("closed", null);
          this.state = 0;
       }
       return;
    }
    public void deallocate(){
    }
    public String getContentType(){
       return this.type;
    }
    public Control getControl(String controlType){
       VolumeControl volumeContro;
       int i = -1;
       if (controlType.indexOf("VolumeControl") != i) {
          VolumeControl vc = new VolumeControl();
          volumeContro = vc;
       }else if(controlType.indexOf("ToneControl") != i){
          ToneControl tc = new ToneControl();
          volumeContro = tc;
       }else {
          Log.e("ERROR", "PLAYER IS ERROR");
          volumeContro = null;
       }
       return volumeContro;
    }
    public long getDuration(){
       long duration = (long)(this.mp.getDuration() * 1000);
       long l = ((duration) <= 0)? -1: duration;
       return l;
    }
    public long getMediaTime(){
       long mediaTime = (long)(this.mp.getCurrentPosition() * 1000);
       long l = ((mediaTime) <= 0)? -1: mediaTime;
       return l;
    }
    public int getState(){
       return this.state;
    }
    public void onCompletion(MediaPlayer mp){
       if (mp == this.mp) {
          this.playedCount = this.playedCount + 1;
          if (this.playedCount >= this.loopCount && this.loopCount != -1) {
             mp.setLooping(false);
             this.onEvent("endOfMedia", null);
          }
       }
       return;
    }
    public void prefetch(){
       IOException e1;
       if (this.state < 300) {
          if (this.state < 200) {
             this.realize();
          }
          try{
             this.mp.prepare();
          }catch(java.lang.IllegalStateException e1){
             IllegalStateException e = e1;
             e.printStackTrace();
          }catch(java.io.IOException e1){
             e1 = e1;
             e1.printStackTrace();
          }
          this.state = 300;
       }
       return;
    }
    public void realize(){
       if (this.state < 200) {
          try{
             if (Manager.getIsLocator()) {
                this.mp.setDataSource(this.dateSource);
             }else {
                AssetFileDescriptor afd = AndroidUtil.am.openFd(this.dateSource);
                this.mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
             }
             this.state = 200;
          }catch(java.io.IOException e0){
             IOException e = e0;
             throw new MediaException();
          }
       }
       return;
    }
    public void removePlayerListener(PlayerListener playerListener){
       this.playerListeners.remove(playerListener);
    }
    public void setDatasource(String dataSource){
       this.dateSource = dataSource;
    }
    public void setLoopCount(int count){
       if (this.state == 400) {
          throw new IllegalStateException("player is close");
       }
       if (!count) {
          throw new IllegalArgumentException("loopcount is 0");
       }
       if (count != -1 && count <= 1) {
          Log.e("Player", "Loop count < -1");
       }else {
          this.mp.setLooping(1);
          this.loopCount = count;
       }
       return;
    }
    public long setMediaTime(long now){
       int mill_now;
       if ((mill_now = (int)now / 1000) < 0) {
          mill_now = 0;
          now = 0;
       }else if(mill_now > this.mp.getDuration()){
          mill_now = this.mp.getDuration();
          now = (long)(this.mp.getDuration() * 1000);
       }
       this.mp.seekTo(mill_now);
       return now;
    }
    public void setType(String type){
       this.type = type;
    }
    public void start(){
       int i = 200;
       if (this.state < 400) {
          if (this.state < i) {
             this.realize();
          }
          if (this.state < 300) {
             this.prefetch();
          }
          if (this.state == i || this.state == 300) {
             this.playedCount = 0;
             try{
                this.mp.start();
                this.onEvent("started", null);
                this.state = 400;
             }catch(java.lang.IllegalStateException e1){
                IllegalStateException e = e1;
                this.onEvent("error", e.getMessage());
                throw new MediaException();
             }
          }
       }
       return;
    }
    public void stop(){
       if (this.state >= 400) {
          try{
             this.mp.pause();
             this.onEvent("stopped", null);
             this.state = 300;
          }catch(java.lang.IllegalStateException e1){
             IllegalStateException e = e1;
             this.onEvent("error", e.getMessage());
             throw new MediaException();
          }
       }
       return;
    }
}
