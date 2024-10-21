package javax.microedition.midlet;

import android.content.Intent;
import android.net.Uri;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.CwaActivity;

public abstract class MIDlet {
    protected abstract void destroyApp(boolean arg1) throws MIDletStateChangeException;

    public final String getAppProperty(String key) {
        return MIDletManager.getInstance().getAppProperty(this, key);
    }

    public final void notifyDestroyed() {
        MIDletManager.getInstance().notifyDestroyed();
        MIDletManager.getInstance().notifyExit();
    }

    public final void notifyPaused() {
        MIDletManager.getInstance().notifyPaused();
    }

    protected abstract void pauseApp();

    public final boolean platformRequest(String URL) throws ConnectionNotFoundException {
        if(URL.startsWith("http://")) {
            CwaActivity.getInstance().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(URL)));
            return true;
        }
        if(!URL.startsWith("tel:")) {
            throw new ConnectionNotFoundException(URL);
        }
        CwaActivity.getInstance().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(URL)));
        return true;
    }

    public void resumeRequest() {
        MIDletManager.getInstance().notifyResumed();
    }

    protected abstract void startApp() throws MIDletStateChangeException;
}

