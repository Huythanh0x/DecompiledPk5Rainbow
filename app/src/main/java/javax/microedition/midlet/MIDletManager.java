package javax.microedition.midlet;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.lcdui.Display;

public class MIDletManager {
    private boolean autoLaunch;
    private MIDlet currentMidlet;
    private boolean destroyed;
    private Map jad;
    private static MIDletManager jam;
    private Map midlets;
    private boolean paused;

    private MIDletManager() {
        this.autoLaunch = true;
        this.paused = false;
        this.destroyed = true;
        this.midlets = new LinkedHashMap();
        this.jad = new LinkedHashMap();
    }

    public final String getAppProperty(MIDlet midlet, String key) {
        return (String)this.jad.get(key);
    }

    public MIDlet getCurrenMIDlet() {
        return this.currentMidlet;
    }

    public static final MIDletManager getInstance() {
        if(MIDletManager.jam == null) {
            MIDletManager.jam = new MIDletManager();
        }
        return MIDletManager.jam;
    }

    public boolean isAutoLaunch() {
        return this.autoLaunch;
    }

    public final void notifyDestroyed() {
        if(this.currentMidlet != null && !this.destroyed) {
            try {
                this.destroyed = true;
                this.currentMidlet.destroyApp(true);
            }
            catch(MIDletStateChangeException mIDletStateChangeException0) {
                mIDletStateChangeException0.printStackTrace();
            }
        }
        this.jad.clear();
        this.midlets.clear();
    }

    public final void notifyExit() {
        CwaActivity.getInstance().finish();
    }

    public final void notifyPaused() {
        if(this.currentMidlet != null && !this.paused) {
            this.paused = true;
            Display.getCanvas().hideNotify();
        }
    }

    public final void notifyResumed() {
        if(this.currentMidlet != null && this.paused) {
            this.paused = false;
            Display.getCanvas().showNotify();
        }
    }

    public void setAutoLaunch(boolean autoLaunch) {
        this.autoLaunch = autoLaunch;
    }

    public void setMIDlet(MIDlet midlet) {
        this.currentMidlet = midlet;
    }
}

