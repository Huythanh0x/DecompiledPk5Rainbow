package javax.microedition.midlet.MIDlet;
import java.lang.Object;
import java.lang.String;
import javax.microedition.midlet.MIDletManager;
import android.net.Uri;
import android.content.Intent;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.io.ConnectionNotFoundException;

public abstract class MIDlet	// class@000150 from classes.dex
{

    protected void MIDlet(){
       super();
    }
    protected abstract void destroyApp(boolean p0);
    public final String getAppProperty(String key){
       return MIDletManager.getInstance().getAppProperty(this, key);
    }
    public final void notifyDestroyed(){
       MIDletManager.getInstance().notifyDestroyed();
       MIDletManager.getInstance().notifyExit();
    }
    public final void notifyPaused(){
       MIDletManager.getInstance().notifyPaused();
    }
    protected abstract void pauseApp();
    public final boolean platformRequest(String URL){
       Uri uri;
       Intent it;
       boolean b;
       if (URL.startsWith("http://")) {
          uri = Uri.parse(URL);
          it = new Intent("android.intent.action.VIEW", uri);
          CwaActivity.getInstance().startActivity(it);
          b = true;
       }else if(URL.startsWith("tel:")){
          uri = Uri.parse(URL);
          it = new Intent("android.intent.action.DIAL", uri);
          CwaActivity.getInstance().startActivity(it);
          b = true;
       }else {
          throw new ConnectionNotFoundException(URL);
       }
       return b;
    }
    public void resumeRequest(){
       MIDletManager.getInstance().notifyResumed();
    }
    protected abstract void startApp();
}
