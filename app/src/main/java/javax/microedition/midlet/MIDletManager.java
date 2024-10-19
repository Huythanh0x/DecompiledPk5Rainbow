package javax.microedition.midlet;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.lcdui.Display;

/* loaded from: classes.dex */
public class MIDletManager {
    private static MIDletManager jam;
    private MIDlet currentMidlet;
    private boolean autoLaunch = true;
    private boolean paused = false;
    private boolean destroyed = true;
    private Map<String, String> midlets = new LinkedHashMap();
    private Map<String, String> jad = new LinkedHashMap();

    private MIDletManager() {
    }

    public static final MIDletManager getInstance() {
        if (jam == null) {
            jam = new MIDletManager();
        }
        return jam;
    }

    public void setAutoLaunch(boolean autoLaunch) {
        this.autoLaunch = autoLaunch;
    }

    public boolean isAutoLaunch() {
        return this.autoLaunch;
    }

    public final String getAppProperty(MIDlet midlet, String key) {
        return this.jad.get(key);
    }

    public final void notifyDestroyed() {
        if (this.currentMidlet != null && !this.destroyed) {
            this.destroyed = true;
            try {
                this.currentMidlet.destroyApp(true);
            } catch (MIDletStateChangeException e) {
                e.printStackTrace();
            }
        }
        this.jad.clear();
        this.midlets.clear();
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

    public MIDlet getCurrenMIDlet() {
        return this.currentMidlet;
    }

    public void setMIDlet(MIDlet midlet) {
        this.currentMidlet = midlet;
    }
}
