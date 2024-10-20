package javax.microedition.media;

import android.content.res.AssetFileDescriptor;
import com.android.Util.AndroidUtil;
import java.io.IOException;
import android.util.Log;
import javax.microedition.media.control.ToneControl;
import javax.microedition.media.control.VolumeControl;
import java.util.Iterator;
import java.util.Vector;
import android.media.MediaPlayer;
import android.media.MediaPlayer$OnCompletionListener;

public class Player implements MediaPlayer$OnCompletionListener
{
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
    private Vector<PlayerListener> playerListeners;
    private int state;
    private String type;
    
    public Player() {
        super();
        this.state = 100;
        this.mp = new MediaPlayer();
        this.playerListeners = new Vector<PlayerListener>();
        this.mp.setOnCompletionListener((MediaPlayer$OnCompletionListener)this);
        this.mp.setLooping(false);
        this.dateSource = null;
        this.type = null;
    }
    
    private final void onEvent(final String s, final Object o) {
        final Iterator<PlayerListener> iterator = this.playerListeners.iterator();
        while (iterator.hasNext()) {
            ((PlayerListener)iterator.next()).playerUpdate(this, s, o);
        }
    }
    
    public void addPlayerListener(final PlayerListener playerListener) {
        if (!this.playerListeners.contains(playerListener)) {
            this.playerListeners.add(playerListener);
        }
    }
    
    public void close() {
        if (this.mp != null) {
            if (this.state == 400) {
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
    
    public Control getControl(final String s) {
        Control control;
        if (s.indexOf("VolumeControl") != -1) {
            control = new VolumeControl();
        }
        else if (s.indexOf("ToneControl") != -1) {
            control = new ToneControl();
        }
        else {
            Log.e("ERROR", "PLAYER IS ERROR");
            control = null;
        }
        return control;
    }
    
    public long getDuration() {
        long n = (long)(this.mp.getDuration() * 1000);
        if (n <= 0L) {
            n = -1L;
        }
        return n;
    }
    
    public long getMediaTime() {
        long n = (long)(this.mp.getCurrentPosition() * 1000);
        if (n <= 0L) {
            n = -1L;
        }
        return n;
    }
    
    public int getState() {
        return this.state;
    }
    
    public void onCompletion(final MediaPlayer mediaPlayer) {
        if (mediaPlayer == this.mp) {
            ++this.playedCount;
            if (this.playedCount >= this.loopCount && this.loopCount != -1) {
                mediaPlayer.setLooping(false);
                this.onEvent("endOfMedia", null);
            }
        }
    }
    
    public void prefetch() throws MediaException {
        if (this.state < 300) {
            if (this.state < 200) {
                this.realize();
            }
            while (true) {
                try {
                    this.mp.prepare();
                    this.state = 300;
                }
                catch (final IllegalStateException ex) {
                    ex.printStackTrace();
                    continue;
                }
                catch (final IOException ex2) {
                    ex2.printStackTrace();
                    continue;
                }
                break;
            }
        }
    }
    
    public void realize() throws MediaException {
        if (this.state < 200) {
            try {
                if (Manager.getIsLocator()) {
                    this.mp.setDataSource(this.dateSource);
                }
                else {
                    final AssetFileDescriptor openFd = AndroidUtil.am.openFd(this.dateSource);
                    this.mp.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                }
                this.state = 200;
            }
            catch (final IOException ex) {
                throw new MediaException();
            }
        }
    }
    
    public void removePlayerListener(final PlayerListener o) {
        this.playerListeners.remove(o);
    }
    
    public void setDatasource(final String dateSource) {
        this.dateSource = dateSource;
    }
    
    public void setLoopCount(final int loopCount) throws IllegalArgumentException, IllegalStateException {
        if (this.state == 400) {
            throw new IllegalStateException("player is close");
        }
        if (loopCount == 0) {
            throw new IllegalArgumentException("loopcount is 0");
        }
        if (loopCount == -1 || loopCount > 1) {
            this.mp.setLooping(true);
            this.loopCount = loopCount;
        }
        else {
            Log.e("Player", "Loop count < -1");
        }
    }
    
    public long setMediaTime(long n) throws MediaException {
        final int n2 = (int)n / 1000;
        int duration;
        if (n2 < 0) {
            duration = 0;
            n = 0L;
        }
        else if ((duration = n2) > this.mp.getDuration()) {
            duration = this.mp.getDuration();
            n = this.mp.getDuration() * 1000;
        }
        this.mp.seekTo(duration);
        return n;
    }
    
    public void setType(final String type) {
        this.type = type;
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
                    this.onEvent("started", null);
                    this.state = 400;
                }
                catch (final IllegalStateException ex) {
                    this.onEvent("error", ex.getMessage());
                    throw new MediaException();
                }
            }
        }
    }
    
    public void stop() throws MediaException {
        if (this.state >= 400) {
            try {
                this.mp.pause();
                this.onEvent("stopped", null);
                this.state = 300;
            }
            catch (final IllegalStateException ex) {
                this.onEvent("error", ex.getMessage());
                throw new MediaException();
            }
        }
    }
}
