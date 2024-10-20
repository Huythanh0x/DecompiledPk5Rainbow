package javax.microedition.midlet;

import android.content.Intent;
import android.net.Uri;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.CwaActivity;

/* loaded from: classes.dex */
/**
 * The MIDlet class is an abstract class that provides methods to manage the lifecycle
 * of a MIDlet application. It includes methods to start, pause, and destroy the application,
 * as well as to notify the system of changes in the application's state.
 */
public abstract class MIDlet {

    /**
     * Destroys the MIDlet application.
     *
     * @param z a boolean indicating whether the application should be destroyed.
     * @throws MIDletStateChangeException if there is an error during the destruction process.
     */
    public abstract void destroyApp(boolean z) throws MIDletStateChangeException;

    /**
     * Pauses the MIDlet application.
     */
    protected abstract void pauseApp();

    /**
     * Starts the MIDlet application.
     *
     * @throws MIDletStateChangeException if there is an error during the start process.
     */
    protected abstract void startApp() throws MIDletStateChangeException;

    /**
     * Notifies the system that the MIDlet has been destroyed.
     */
    public final void notifyDestroyed() {
        MIDletManager.getInstance().notifyDestroyed();
        MIDletManager.getInstance().notifyExit();
    }

    /**
     * Notifies the system that the MIDlet has been paused.
     */
    public final void notifyPaused() {
        MIDletManager.getInstance().notifyPaused();
    }

    /**
     * Retrieves a property of the MIDlet application.
     *
     * @param key the name of the property to retrieve.
     * @return the value of the property, or null if the property is not found.
     */
    public final String getAppProperty(String key) {
        return MIDletManager.getInstance().getAppProperty(this, key);
    }

    /**
     * Requests a platform-specific action based on the given URL.
     *
     * @param URL the URL specifying the action to be performed.
     * @return true if the request was successful, false otherwise.
     * @throws ConnectionNotFoundException if the URL is not supported or the action cannot be performed.
     */
    public final boolean platformRequest(String URL) throws ConnectionNotFoundException {
        if (URL.startsWith("http://")) {
            Uri uri = Uri.parse(URL);
            Intent it = new Intent("android.intent.action.VIEW", uri);
            CwaActivity.getInstance().startActivity(it);
            return true;
        }
        if (URL.startsWith("tel:")) {
            Uri uri2 = Uri.parse(URL);
            Intent it2 = new Intent("android.intent.action.DIAL", uri2);
            CwaActivity.getInstance().startActivity(it2);
            return true;
        }
        throw new ConnectionNotFoundException(URL);
    }

    /**
     * Requests that the MIDlet be resumed.
     */
    public void resumeRequest() {
        MIDletManager.getInstance().notifyResumed();
    }
}
