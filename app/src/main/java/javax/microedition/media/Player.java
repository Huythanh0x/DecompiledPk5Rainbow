package javax.microedition.media;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;
import com.android.Util.AndroidUtil;
import com.uc.paymentsdk.util.Constants;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import javax.microedition.media.control.ToneControl;
import javax.microedition.media.control.VolumeControl;

/* loaded from: classes.dex */
public class Player implements MediaPlayer.OnCompletionListener {
    public static final int CLOSED = 0;
    public static final int PREFETCHED = 300;
    public static final int REALIZED = 200;
    public static final int STARTED = 400;
    public static final long TIME_UNKNOWN = -1;
    public static final int UNREALIZED = 100;
    private String dateSource;
    private int loopCount;
    private int playedCount;
    private String type;
    private int state = 100;
    private MediaPlayer mp = new MediaPlayer();
    private Vector<PlayerListener> playerListeners = new Vector<>();

    public Player() {
        this.mp.setOnCompletionListener(this);
        this.mp.setLooping(false);
        this.dateSource = null;
        this.type = null;
    }

    public void setDatasource(String dataSource) {
        this.dateSource = dataSource;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Control getControl(String controlType) {
        if (controlType.indexOf("VolumeControl") != -1) {
            VolumeControl vc = new VolumeControl();
            return vc;
        }
        if (controlType.indexOf("ToneControl") != -1) {
            ToneControl tc = new ToneControl();
            return tc;
        }
        Log.e("ERROR", "PLAYER IS ERROR");
        return null;
    }

    public void realize() throws MediaException {
        if (this.state < 200) {
            try {
                if (Manager.getIsLocator()) {
                    this.mp.setDataSource(this.dateSource);
                } else {
                    AssetFileDescriptor afd = AndroidUtil.am.openFd(this.dateSource);
                    this.mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                }
                this.state = REALIZED;
            } catch (IOException e) {
                throw new MediaException();
            }
        }
    }

    public void prefetch() throws MediaException {
        if (this.state < 300) {
            if (this.state < 200) {
                realize();
            }
            try {
                this.mp.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
            this.state = PREFETCHED;
        }
    }

    public void start() throws MediaException {
        if (this.state < 400) {
            if (this.state < 200) {
                realize();
            }
            if (this.state < 300) {
                prefetch();
            }
            if (this.state == 200 || this.state == 300) {
                this.playedCount = 0;
                try {
                    this.mp.start();
                    onEvent(PlayerListener.STARTED, null);
                    this.state = STARTED;
                } catch (IllegalStateException e) {
                    onEvent("error", e.getMessage());
                    throw new MediaException();
                }
            }
        }
    }

    public void stop() throws MediaException {
        if (this.state >= 400) {
            try {
                this.mp.pause();
                onEvent(PlayerListener.STOPPED, null);
                this.state = PREFETCHED;
            } catch (IllegalStateException e) {
                onEvent("error", e.getMessage());
                throw new MediaException();
            }
        }
    }

    public void deallocate() {
    }

    public void close() {
        if (this.mp != null) {
            if (this.state == 400) {
                onEvent(PlayerListener.STOPPED, null);
                this.mp.stop();
            }
            this.mp.release();
            onEvent(PlayerListener.CLOSED, null);
            this.state = 0;
        }
    }

    public long setMediaTime(long now) throws MediaException {
        int mill_now = ((int) now) / Constants.PAYMENT_MAX;
        if (mill_now < 0) {
            mill_now = 0;
            now = 0;
        } else if (mill_now > this.mp.getDuration()) {
            mill_now = this.mp.getDuration();
            now = this.mp.getDuration() * Constants.PAYMENT_MAX;
        }
        this.mp.seekTo(mill_now);
        return now;
    }

    public long getMediaTime() {
        long mediaTime = this.mp.getCurrentPosition() * Constants.PAYMENT_MAX;
        if (mediaTime <= 0) {
            return -1L;
        }
        return mediaTime;
    }

    public int getState() {
        return this.state;
    }

    public long getDuration() {
        long duration = this.mp.getDuration() * Constants.PAYMENT_MAX;
        if (duration <= 0) {
            return -1L;
        }
        return duration;
    }

    public String getContentType() {
        return this.type;
    }

    public void setLoopCount(int count) throws IllegalArgumentException, IllegalStateException {
        if (this.state == 400) {
            throw new IllegalStateException("player is close");
        }
        if (count == 0) {
            throw new IllegalArgumentException("loopcount is 0");
        }
        if (count == -1 || count > 1) {
            this.mp.setLooping(true);
            this.loopCount = count;
        } else {
            Log.e("Player", "Loop count < -1");
        }
    }

    public void addPlayerListener(PlayerListener playerListener) {
        if (!this.playerListeners.contains(playerListener)) {
            this.playerListeners.add(playerListener);
        }
    }

    public void removePlayerListener(PlayerListener playerListener) {
        this.playerListeners.remove(playerListener);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mp) {
        if (mp == this.mp) {
            this.playedCount++;
            if (this.playedCount >= this.loopCount && this.loopCount != -1) {
                mp.setLooping(false);
                onEvent(PlayerListener.END_OF_MEDIA, null);
            }
        }
    }

    private final void onEvent(String event, Object eventData) {
        Iterator<PlayerListener> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            PlayerListener playerListener = it.next();
            playerListener.playerUpdate(this, event, eventData);
        }
    }
}
