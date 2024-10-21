/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  javax.microedition.io.ConnectionNotFoundException
 *  javax.microedition.lcdui.CwaActivity
 *  javax.microedition.midlet.MIDletManager
 *  javax.microedition.midlet.MIDletStateChangeException
 */
package javax.microedition.midlet;

import android.content.Intent;
import android.net.Uri;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.midlet.MIDletManager;
import javax.microedition.midlet.MIDletStateChangeException;

public abstract class MIDlet {
    protected MIDlet() {
    }

    protected abstract void destroyApp(boolean var1) throws MIDletStateChangeException;

    public final String getAppProperty(String string) {
        return MIDletManager.getInstance().getAppProperty(this, string);
    }

    public final void notifyDestroyed() {
        MIDletManager.getInstance().notifyDestroyed();
        MIDletManager.getInstance().notifyExit();
    }

    public final void notifyPaused() {
        MIDletManager.getInstance().notifyPaused();
    }

    protected abstract void pauseApp();

    /*
     * Enabled force condition propagation
     */
    public final boolean platformRequest(String string) throws ConnectionNotFoundException {
        if (string.startsWith("http://")) {
            string = new Intent("android.intent.action.VIEW", Uri.parse((String)string));
            CwaActivity.getInstance().startActivity((Intent)string);
            return true;
        }
        if (!string.startsWith("tel:")) throw new ConnectionNotFoundException(string);
        string = new Intent("android.intent.action.DIAL", Uri.parse((String)string));
        CwaActivity.getInstance().startActivity((Intent)string);
        return true;
    }

    public void resumeRequest() {
        MIDletManager.getInstance().notifyResumed();
    }

    protected abstract void startApp() throws MIDletStateChangeException;
}
