package javax.microedition.midlet;

import android.content.Intent;
import android.net.Uri;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.CwaActivity;

public abstract class MIDlet {
   protected MIDlet() {
      super();
   }

   protected abstract void destroyApp(boolean var1) throws MIDletStateChangeException;

   public final String getAppProperty(String var1) {
      return MIDletManager.getInstance().getAppProperty(this, var1);
   }

   public final void notifyDestroyed() {
      MIDletManager.getInstance().notifyDestroyed();
      MIDletManager.getInstance().notifyExit();
   }

   public final void notifyPaused() {
      MIDletManager.getInstance().notifyPaused();
   }

   protected abstract void pauseApp();

   public final boolean platformRequest(String var1) throws ConnectionNotFoundException {
      Intent var2;
      if (var1.startsWith("http://")) {
         var2 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
         CwaActivity.getInstance().startActivity(var2);
      } else {
         if (!var1.startsWith("tel:")) {
            throw new ConnectionNotFoundException(var1);
         }

         var2 = new Intent("android.intent.action.DIAL", Uri.parse(var1));
         CwaActivity.getInstance().startActivity(var2);
      }

      return true;
   }

   public void resumeRequest() {
      MIDletManager.getInstance().notifyResumed();
   }

   protected abstract void startApp() throws MIDletStateChangeException;
}
