package javax.microedition.media;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer;
import android.util.Log;
import com.android.Util.AndroidUtil;
import java.io.IOException;
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
    private MediaPlayer mp;
    private int playedCount;
    private Vector playerListeners;
    private int state;
    private String type;

    public Player() {
        this.state = 100;
        this.mp = new MediaPlayer();
        this.playerListeners = new Vector();
        this.mp.setOnCompletionListener(this);
        this.mp.setLooping(false);
        this.dateSource = null;
        this.type = null;
    }

    public void addPlayerListener(PlayerListener playerListener) {
        if(!this.playerListeners.contains(playerListener)) {
            this.playerListeners.add(playerListener);
        }
    }

    public void close() {
        if(this.mp != null) {
            if(this.state == 400) {
                this.onEvent("stopped", null);
                this.mp.stop();
            }
            this.mp.release();
            this.onEvent("closed", null);
            this.state = 0;
        }
    }

    public void deallocate() {
    }

    public String getContentType() {
        return this.type;
    }

    public Control getControl(String controlType) {
        if(controlType.indexOf("VolumeControl") != -1) {
            return new VolumeControl();
        }
        if(controlType.indexOf("ToneControl") != -1) {
            return new ToneControl();
        }
        Log.e("ERROR", "PLAYER IS ERROR");
        return null;
    }

    public long getDuration() {
        long duration = (long)(this.mp.getDuration() * 1000);
        return duration > 0L ? duration : -1L;
    }

    public long getMediaTime() {
        long mediaTime = (long)(this.mp.getCurrentPosition() * 1000);
        return mediaTime > 0L ? mediaTime : -1L;
    }

    public int getState() {
        return this.state;
    }

    @Override  // android.media.MediaPlayer$OnCompletionListener
    public void onCompletion(MediaPlayer mp) {
        if(mp == this.mp) {
            ++this.playedCount;
            if(this.playedCount >= this.loopCount && this.loopCount != -1) {
                mp.setLooping(false);
                this.onEvent("endOfMedia", null);
            }
        }
    }

    private final void onEvent(String event, Object eventData) {
        for(Object object1: this.playerListeners) {
            ((PlayerListener)object1).playerUpdate(this, event, eventData);
        }
    }

    public void prefetch() throws MediaException {
        if(this.state >= 300) {
            return;
        }
        if(this.state < 200) {
            this.realize();
        }
        try {
            this.mp.prepare();
        }
        catch(IllegalStateException illegalStateException0) {
            illegalStateException0.printStackTrace();
        }
        catch(IOException iOException0) {
            iOException0.printStackTrace();
        }
        this.state = 300;
    }

    public void realize() throws MediaException {
        if(this.state >= 200) {
            return;
        }
        try {
            AssetFileDescriptor assetFileDescriptor0 = AndroidUtil.am.openFd(this.dateSource);
            this.mp.setDataSource(assetFileDescriptor0.getFileDescriptor(), assetFileDescriptor0.getStartOffset(), assetFileDescriptor0.getLength());
            this.state = 200;
        }
        catch(IOException unused_ex) {
            throw new MediaException();
        }
    }

    public void removePlayerListener(PlayerListener playerListener) {
        this.playerListeners.remove(playerListener);
    }

    public void setDatasource(String dataSource) {
        this.dateSource = dataSource;
    }

    public void setLoopCount(int count) throws IllegalArgumentException, IllegalStateException {
        if(this.state == 400) {
            throw new IllegalStateException("player is close");
        }
        if(count == 0) {
            throw new IllegalArgumentException("loopcount is 0");
        }
        if(count == -1 || count > 1) {
            this.mp.setLooping(true);
            this.loopCount = count;
            return;
        }
        Log.e("Player", "Loop count < -1");
    }

    public long setMediaTime(long now) throws MediaException {
        int mill_now = ((int)now) / 1000;
        if(mill_now < 0) {
            mill_now = 0;
            now = 0L;
        }
        else if(mill_now > this.mp.getDuration()) {
            mill_now = this.mp.getDuration();
            now = (long)(this.mp.getDuration() * 1000);
        }
        this.mp.seekTo(mill_now);
        return now;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void start() throws MediaException {
        if(this.state < 400) {
            if(this.state < 200) {
                this.realize();
            }
            if(this.state < 300) {
                this.prefetch();
            }
            if(this.state == 200 || this.state == 300) {
                try {
                    this.playedCount = 0;
                    this.mp.start();
                }
                catch(IllegalStateException illegalStateException0) {
                    this.onEvent("error", illegalStateException0.getMessage());
                    throw new MediaException();
                }
                this.onEvent("started", null);
                this.state = 400;
            }
        }
    }

    public void stop() throws MediaException {
        if(this.state < 400) {
            return;
        }
        try {
            this.mp.pause();
        }
        catch(IllegalStateException illegalStateException0) {
            this.onEvent("error", illegalStateException0.getMessage());
            throw new MediaException();
        }
        this.onEvent("stopped", null);
        this.state = 300;
    }
}

