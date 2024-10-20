package javax.microedition.midlet.MIDletManager;
import java.lang.Object;
import java.util.LinkedHashMap;
import javax.microedition.midlet.MIDlet;
import java.lang.String;
import java.util.Map;
import javax.microedition.midlet.MIDletStateChangeException;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;

public class MIDletManager	// class@000151 from classes.dex
{
    private boolean autoLaunch;
    private MIDlet currentMidlet;
    private boolean destroyed;
    private Map jad;
    private Map midlets;
    private boolean paused;
    private static MIDletManager jam;

    private void MIDletManager(){
       super();
       this.autoLaunch = true;
       this.paused = false;
       this.destroyed = true;
       this.midlets = new LinkedHashMap();
       this.jad = new LinkedHashMap();
    }
    public static final MIDletManager getInstance(){
       if (MIDletManager.jam == null) {
          MIDletManager.jam = new MIDletManager();
       }
       return MIDletManager.jam;
    }
    public final String getAppProperty(MIDlet midlet,String key){
       MIDletManager mIDletManage = this.jad.get(key);
       return this;
    }
    public MIDlet getCurrenMIDlet(){
       return this.currentMidlet;
    }
    public boolean isAutoLaunch(){
       return this.autoLaunch;
    }
    public final void notifyDestroyed(){
       try{
          boolean b = true;
          if (this.currentMidlet != null && this.destroyed == null) {
             this.destroyed = b;
             this.currentMidlet.destroyApp(true);
          }
       }catch(javax.microedition.midlet.MIDletStateChangeException e1){
          MIDletStateChangeException e = e1;
          e.printStackTrace();
       }
       this.jad.clear();
       this.midlets.clear();
       return;
    }
    public final void notifyExit(){
       CwaActivity.getInstance().finish();
    }
    public final void notifyPaused(){
       if (this.currentMidlet != null && this.paused == null) {
          this.paused = true;
          Display.getCanvas().hideNotify();
       }
       return;
    }
    public final void notifyResumed(){
       if (this.currentMidlet != null && this.paused != null) {
          this.paused = false;
          Display.getCanvas().showNotify();
       }
       return;
    }
    public void setAutoLaunch(boolean autoLaunch){
       this.autoLaunch = autoLaunch;
    }
    public void setMIDlet(MIDlet midlet){
       this.currentMidlet = midlet;
    }
}
