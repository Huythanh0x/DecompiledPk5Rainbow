package main;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public final class XConnection extends MIDlet {
  public MainCanvas gamecanvas = new MainCanvas(this);
  
  public XConnection() {
    Display.getDisplay(this).setCurrent((Canvas)this.gamecanvas);
    this.gamecanvas.game_start();
  }
  
  public void destroyApp(boolean paramBoolean) {
    this.gamecanvas.game_stop();
    notifyDestroyed();
  }
  
  public void pauseApp() {
    if (this.gamecanvas != null)
      this.gamecanvas.hideNotify(); 
  }
  
  public void startApp() {
    if (this.gamecanvas != null)
      this.gamecanvas.showNotify(); 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/main/XConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */