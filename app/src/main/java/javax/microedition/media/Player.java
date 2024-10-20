/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.util.Log
 *  com.android.Util.AndroidUtil
 *  javax.microedition.media.Control
 *  javax.microedition.media.Manager
 *  javax.microedition.media.MediaException
 *  javax.microedition.media.PlayerListener
 *  javax.microedition.media.control.ToneControl
 *  javax.microedition.media.control.VolumeControl
 */
package javax.microedition.media;

import android.media.MediaPlayer;
import android.util.Log;
import com.android.Util.AndroidUtil;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import javax.microedition.media.Control;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.PlayerListener;
import javax.microedition.media.control.ToneControl;
import javax.microedition.media.control.VolumeControl;

public class Player
implements MediaPlayer.OnCompletionListener {
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
    private Vector<PlayerListener> playerListeners = new Vector<E>();
    private int state = 100;
    private String type;

    public Player() {
        this.mp.setOnCompletionListener((MediaPlayer.OnCompletionListener)this);
        this.mp.setLooping(false);
        this.dateSource = null;
        this.type = null;
    }

    private final void onEvent(String string, Object object) {
        Iterator<PlayerListener> iterator = this.playerListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().playerUpdate(this, string, object);
        }
        return;
    }

    public void addPlayerListener(PlayerListener playerListener) {
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

    /*
     * Enabled force condition propagation
     */
    public Control getControl(String string) {
        if (string.indexOf("VolumeControl") != -1) {
            return new VolumeControl();
        }
        if (string.indexOf("ToneControl") != -1) {
            return new ToneControl();
        }
        Log.e((String)"ERROR", (String)"PLAYER IS ERROR");
        return null;
    }

    public long getDuration() {
        long l = this.mp.getDuration() * 1000;
        if (l <= 0L) {
            l = -1L;
        }
        return l;
    }

    public long getMediaTime() {
        long l = this.mp.getCurrentPosition() * 1000;
        if (l <= 0L) {
            l = -1L;
        }
        return l;
    }

    public int getState() {
        return this.state;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (mediaPlayer == this.mp) {
            ++this.playedCount;
            if (this.playedCount >= this.loopCount && this.loopCount != -1) {
                mediaPlayer.setLooping(false);
                this.onEvent("endOfMedia", null);
            }
        }
    }

    /*
     * Exception decompiling
     */
    public void prefetch() throws MediaException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Nonsensical loop would be emitted - failure
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.LoopIdentifier.considerAsDoLoopStart(LoopIdentifier.java:438)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.LoopIdentifier.identifyLoops1(LoopIdentifier.java:65)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:681)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:111)
         *     at java.base/java.lang.Thread.run(Thread.java:840)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     */
    public void realize() throws MediaException {
        block6: {
            if (this.state >= 200) lbl-1000:
            // 2 sources

            {
                return;
            }
            if (!Manager.getIsLocator()) break block6;
            this.mp.setDataSource(this.dateSource);
lbl7:
            // 2 sources

            while (true) {
                this.state = 200;
                ** continue;
                break;
            }
        }
        try {
            var1_1 = AndroidUtil.am.openFd(this.dateSource);
            this.mp.setDataSource(var1_1.getFileDescriptor(), var1_1.getStartOffset(), var1_1.getLength());
            ** continue;
        }
        catch (IOException var1_2) {
            throw new MediaException();
        }
    }

    public void removePlayerListener(PlayerListener playerListener) {
        this.playerListeners.remove(playerListener);
    }

    public void setDatasource(String string) {
        this.dateSource = string;
    }

    /*
     * Enabled force condition propagation
     */
    public void setLoopCount(int n) throws IllegalArgumentException, IllegalStateException {
        if (this.state == 400) {
            throw new IllegalStateException("player is close");
        }
        if (n == 0) {
            throw new IllegalArgumentException("loopcount is 0");
        }
        if (n == -1 || n > 1) {
            this.mp.setLooping(true);
            this.loopCount = n;
            return;
        }
        Log.e((String)"Player", (String)"Loop count < -1");
    }

    /*
     * Unable to fully structure code
     */
    public long setMediaTime(long var1_1) throws MediaException {
        var4_2 = (int)var1_1 / 1000;
        if (var4_2 < 0) {
            var3_3 = 0;
            var1_1 = 0L;
lbl5:
            // 3 sources

            while (true) {
                this.mp.seekTo(var3_3);
                return var1_1;
            }
        }
        var3_3 = var4_2;
        if (var4_2 <= this.mp.getDuration()) ** GOTO lbl5
        var3_3 = this.mp.getDuration();
        var1_1 = this.mp.getDuration() * 1000;
        ** while (true)
    }

    public void setType(String string) {
        this.type = string;
    }

    /*
     * Unable to fully structure code
     */
    public void start() throws MediaException {
        if (this.state >= 400) lbl-1000:
        // 3 sources

        {
            return;
        }
        if (this.state < 200) {
            this.realize();
        }
        if (this.state < 300) {
            this.prefetch();
        }
        if (this.state != 200 && this.state != 300) ** GOTO lbl-1000
        this.playedCount = 0;
        try {
            this.mp.start();
        }
        catch (IllegalStateException var1_1) {
            this.onEvent("error", var1_1.getMessage());
            throw new MediaException();
        }
        this.onEvent("started", null);
        this.state = 400;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public void stop() throws MediaException {
        if (this.state < 400) {
            return;
        }
        try {
            this.mp.pause();
        }
        catch (IllegalStateException illegalStateException) {
            this.onEvent("error", illegalStateException.getMessage());
            throw new MediaException();
        }
        this.onEvent("stopped", null);
        this.state = 300;
    }
}
