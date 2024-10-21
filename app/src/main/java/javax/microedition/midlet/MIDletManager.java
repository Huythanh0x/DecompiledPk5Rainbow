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
  
  private Map<String, String> jad = new LinkedHashMap<String, String>();
  
  private Map<String, String> midlets = new LinkedHashMap<String, String>();
  
  private boolean paused = false;
  
  public static final MIDletManager getInstance() {
    if (jam == null)
      jam = new MIDletManager(); 
    return jam;
  }
  
  public final String getAppProperty(MIDlet paramMIDlet, String paramString) {
    return this.jad.get(paramString);
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
      } catch (MIDletStateChangeException mIDletStateChangeException) {
        mIDletStateChangeException.printStackTrace();
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
  
  public void setAutoLaunch(boolean paramBoolean) {
    this.autoLaunch = paramBoolean;
  }
  
  public void setMIDlet(MIDlet paramMIDlet) {
    this.currentMidlet = paramMIDlet;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/midlet/MIDletManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */