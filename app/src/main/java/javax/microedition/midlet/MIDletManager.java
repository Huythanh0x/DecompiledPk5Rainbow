/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.CwaActivity
 *  javax.microedition.lcdui.Display
 *  javax.microedition.midlet.MIDlet
 *  javax.microedition.midlet.MIDletStateChangeException
 */
package javax.microedition.midlet;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class MIDletManager {
    private static MIDletManager jam;
    private boolean autoLaunch = true;
    private MIDlet currentMidlet;
    private boolean destroyed = true;
    private Map<String, String> jad;
    private Map<String, String> midlets = new LinkedHashMap<String, String>();
    private boolean paused = false;

    private MIDletManager() {
        this.jad = new LinkedHashMap<String, String>();
    }

    public static final MIDletManager getInstance() {
        if (jam == null) {
            jam = new MIDletManager();
        }
        return jam;
    }

    public final String getAppProperty(MIDlet mIDlet, String string) {
        return this.jad.get(string);
    }

    public MIDlet getCurrenMIDlet() {
        return this.currentMidlet;
    }

    public boolean isAutoLaunch() {
        return this.autoLaunch;
    }

    /*
     * Unable to fully structure code
     */
    public final void notifyDestroyed() {
        if (this.currentMidlet != null && !this.destroyed) {
            this.destroyed = true;
            this.currentMidlet.destroyApp(true);
        }
lbl5:
        // 4 sources

        while (true) {
            this.jad.clear();
            this.midlets.clear();
            return;
        }
        catch (MIDletStateChangeException var1_1) {
            var1_1.printStackTrace();
            ** continue;
        }
    }

    public final void notifyExit() {
        CwaActivity.getInstance().finish();
    }

    public final void notifyPaused() {
        if (this.currentMidlet != null && !this.paused) {
            this.paused = true;
            Display.getCanvas().hideNotify();
        }
    }

    public final void notifyResumed() {
        if (this.currentMidlet != null && this.paused) {
            this.paused = false;
            Display.getCanvas().showNotify();
        }
    }

    public void setAutoLaunch(boolean bl) {
        this.autoLaunch = bl;
    }

    public void setMIDlet(MIDlet mIDlet) {
        this.currentMidlet = mIDlet;
    }
}
