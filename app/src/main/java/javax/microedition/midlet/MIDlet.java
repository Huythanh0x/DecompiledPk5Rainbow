package javax.microedition.midlet;

import javax.microedition.io.ConnectionNotFoundException;
import android.content.Intent;
import android.net.Uri;
import javax.microedition.lcdui.CwaActivity;

public abstract class MIDlet
{
    protected MIDlet() {
        super();
    }
    
    protected abstract void destroyApp(final boolean p0) throws MIDletStateChangeException;
    
    public final String getAppProperty(final String s) {
        return MIDletManager.getInstance().getAppProperty(this, s);
    }
    
    public final void notifyDestroyed() {
        MIDletManager.getInstance().notifyDestroyed();
        MIDletManager.getInstance().notifyExit();
    }
    
    public final void notifyPaused() {
        MIDletManager.getInstance().notifyPaused();
    }
    
    protected abstract void pauseApp();
    
    public final boolean platformRequest(final String s) throws ConnectionNotFoundException {
        if (s.startsWith("http://")) {
            CwaActivity.getInstance().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
        }
        else {
            if (!s.startsWith("tel:")) {
                throw new ConnectionNotFoundException(s);
            }
            CwaActivity.getInstance().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(s)));
        }
        return true;
    }
    
    public void resumeRequest() {
        MIDletManager.getInstance().notifyResumed();
    }
    
    protected abstract void startApp() throws MIDletStateChangeException;
}
