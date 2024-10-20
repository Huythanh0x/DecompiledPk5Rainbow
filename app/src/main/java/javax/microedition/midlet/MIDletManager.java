package javax.microedition.midlet;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.lcdui.Display;

public class MIDletManager {
   private static MIDletManager jam;
   private boolean autoLaunch = true;
   private MIDlet currentMidlet;
   private boolean destroyed = true;
   private Map jad = new LinkedHashMap();
   private Map midlets = new LinkedHashMap();
   private boolean paused = false;

   private MIDletManager() {
      super();
   }

   public static final MIDletManager getInstance() {
      if (jam == null) {
         jam = new MIDletManager();
      }

      return jam;
   }

   public final String getAppProperty(MIDlet var1, String var2) {
      return (String)this.jad.get(var2);
   }

   public MIDlet getCurrenMIDlet() {
      return this.currentMidlet;
   }

   public boolean isAutoLaunch() {
      return this.autoLaunch;
   }

   public final void notifyDestroyed() {
      if (this.currentMidlet != null && !this.destroyed) {
         this.destroyed = true;

         try {
            this.currentMidlet.destroyApp(true);
         } catch (MIDletStateChangeException var2) {
            var2.printStackTrace();
         }
      }

      this.jad.clear();
      this.midlets.clear();
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

   public void setAutoLaunch(boolean var1) {
      this.autoLaunch = var1;
   }

   public void setMIDlet(MIDlet var1) {
      this.currentMidlet = var1;
   }
}
