package javax.microedition.midlet;

import android.content.Intent;
import android.net.Uri;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.CwaActivity;

public abstract class MIDlet {
  protected abstract void destroyApp(boolean paramBoolean) throws MIDletStateChangeException;
  
  public final String getAppProperty(String paramString) {
    return MIDletManager.getInstance().getAppProperty(this, paramString);
  }
  
  public final void notifyDestroyed() {
    MIDletManager.getInstance().notifyDestroyed();
    MIDletManager.getInstance().notifyExit();
  }
  
  public final void notifyPaused() {
    MIDletManager.getInstance().notifyPaused();
  }
  
  protected abstract void pauseApp();
  
  public final boolean platformRequest(String paramString) throws ConnectionNotFoundException {
    Intent intent;
    if (paramString.startsWith("http://")) {
      intent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      CwaActivity.getInstance().startActivity(intent);
      return true;
    } 
    if (intent.startsWith("tel:")) {
      intent = new Intent("android.intent.action.DIAL", Uri.parse((String)intent));
      CwaActivity.getInstance().startActivity(intent);
      return true;
    } 
    throw new ConnectionNotFoundException(intent);
  }
  
  public void resumeRequest() {
    MIDletManager.getInstance().notifyResumed();
  }
  
  protected abstract void startApp() throws MIDletStateChangeException;
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/midlet/MIDlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */