package javax.microedition.midlet;

import android.content.Intent;
import android.net.Uri;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.CwaActivity;

/* loaded from: classes.dex */
public abstract class MIDlet {
    public abstract void destroyApp(boolean z) throws MIDletStateChangeException;

    protected abstract void pauseApp();

    protected abstract void startApp() throws MIDletStateChangeException;

    public final void notifyDestroyed() {
        MIDletManager.getInstance().notifyDestroyed();
        MIDletManager.getInstance().notifyExit();
    }

    public final void notifyPaused() {
        MIDletManager.getInstance().notifyPaused();
    }

    public final String getAppProperty(String key) {
        return MIDletManager.getInstance().getAppProperty(this, key);
    }

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

    public void resumeRequest() {
        MIDletManager.getInstance().notifyResumed();
    }
}
