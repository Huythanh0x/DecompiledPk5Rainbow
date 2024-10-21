package javax.microedition.midlet;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.CwaActivity;
import java.util.LinkedHashMap;
import java.util.Map;

public class MIDletManager
{
    private static MIDletManager jam;
    private boolean autoLaunch;
    private MIDlet currentMidlet;
    private boolean destroyed;
    private Map<String, String> jad;
    private Map<String, String> midlets;
    private boolean paused;
    
    private MIDletManager() {
        super();
        this.autoLaunch = true;
        this.paused = false;
        this.destroyed = true;
        this.midlets = new LinkedHashMap<String, String>();
        this.jad = new LinkedHashMap<String, String>();
    }
    
    public static final MIDletManager getInstance() {
        if (MIDletManager.jam == null) {
            MIDletManager.jam = new MIDletManager();
        }
        return MIDletManager.jam;
    }
    
    public final String getAppProperty(final MIDlet miDlet, final String s) {
        return this.jad.get(s);
    }
    
    public MIDlet getCurrenMIDlet() {
        return this.currentMidlet;
    }
    
    public boolean isAutoLaunch() {
        return this.autoLaunch;
    }
    
    public final void notifyDestroyed() {
        while (true) {
            if (this.currentMidlet == null || this.destroyed) {
                break Label_0027;
            }
            this.destroyed = true;
            try {
                this.currentMidlet.destroyApp(true);
                this.jad.clear();
                this.midlets.clear();
            }
            catch (final MIDletStateChangeException ex) {
                ex.printStackTrace();
                continue;
            }
            break;
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
    
    public void setAutoLaunch(final boolean autoLaunch) {
        this.autoLaunch = autoLaunch;
    }
    
    public void setMIDlet(final MIDlet currentMidlet) {
        this.currentMidlet = currentMidlet;
    }
}
