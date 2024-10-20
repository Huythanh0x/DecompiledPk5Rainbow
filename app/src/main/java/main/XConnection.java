package main.XConnection;
import javax.microedition.midlet.MIDlet;
import main.MainCanvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Canvas;

public final class XConnection extends MIDlet	// class@000169 from classes.dex
{
    public MainCanvas gamecanvas;

    public void XConnection(){
       super();
       this.gamecanvas = new MainCanvas(this);
       Display.getDisplay(this).setCurrent(this.gamecanvas);
       this.gamecanvas.game_start();
    }
    public void destroyApp(boolean parm){
       this.gamecanvas.game_stop();
       this.notifyDestroyed();
    }
    public void pauseApp(){
       if (this.gamecanvas != null) {
          this.gamecanvas.hideNotify();
       }
       return;
    }
    public void startApp(){
       if (this.gamecanvas != null) {
          this.gamecanvas.showNotify();
       }
       return;
    }
}
