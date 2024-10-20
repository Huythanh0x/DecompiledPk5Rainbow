package javax.microedition.midlet;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.lcdui.Display;

/* loaded from: classes.dex */
/**
 * The MIDletManager class is a singleton that manages the lifecycle and properties of MIDlets.
 * It provides methods to control the auto-launch behavior, notify different states of the MIDlet,
 * and manage application properties.
 */
/**
 * MIDletManager is a singleton class responsible for managing the lifecycle of MIDlets.
 * It provides methods to control the auto-launch behavior, notify different states
 * of the MIDlet, and manage application properties.
 */
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

    /**
     * Returns the singleton instance of MIDletManager.
     *
     * @return the singleton instance of MIDletManager.
     */
    public static final MIDletManager getInstance() {
        if (jam == null) {
            jam = new MIDletManager();
        }
        return jam;
    }

    /**
     * Sets the auto-launch behavior for the MIDlet.
     *
     * @param autoLaunch true to enable auto-launch, false to disable.
     */
    public void setAutoLaunch(boolean autoLaunch) {
        this.autoLaunch = autoLaunch;
    }

    /**
     * Checks if auto-launch is enabled for the MIDlet.
     *
     * @return true if auto-launch is enabled, false otherwise.
     */
    public boolean isAutoLaunch() {
        return this.autoLaunch;
    }

    /**
     * Retrieves the application property for the given MIDlet and key.
     *
     * @param midlet the MIDlet for which the property is to be retrieved.
     * @param key the key of the property to be retrieved.
     * @return the value of the property, or null if the property does not exist.
     */
    public final String getAppProperty(MIDlet midlet, String key) {
        return this.jad.get(key);
    }

    /**
     * Notifies that the MIDlet has been destroyed.
     * Clears the internal state and properties of the MIDletManager.
     */
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

    /**
     * Notifies that the application should exit.
     * Calls the finish method on the CwaActivity instance.
     */
    public final void notifyExit() {
        CwaActivity.getInstance().finish();
    }

    /**
     * Notifies that the MIDlet has been paused.
     * Updates the internal state and hides the display canvas.
     */
    public final void notifyPaused() {
        if (this.currentMidlet != null && !this.paused) {
            this.paused = true;
            Display.getCanvas().hideNotify();
        }
    }

    /**
     * Notifies that the MIDlet has been resumed.
     * Updates the internal state and shows the display canvas.
     */
    public final void notifyResumed() {
        if (this.currentMidlet != null && this.paused) {
            this.paused = false;
            Display.getCanvas().showNotify();
        }
    }

    /**
     * Returns the current MIDlet being managed.
     *
     * @return the current MIDlet, or null if no MIDlet is being managed.
     */
    public MIDlet getCurrenMIDlet() {
        return this.currentMidlet;
    }

    /**
     * Sets the current MIDlet to be managed.
     *
     * @param midlet the MIDlet to be managed.
     */
    public void setMIDlet(MIDlet midlet) {
        this.currentMidlet = midlet;
    }
}
