package main;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public final class XConnection extends MIDlet {
   public MainCanvas gamecanvas = new MainCanvas(this);

   public XConnection() {
      super();
      Display.getDisplay(this).setCurrent(this.gamecanvas);
      this.gamecanvas.game_start();
   }

   public void destroyApp(boolean var1) {
      this.gamecanvas.game_stop();
      this.notifyDestroyed();
   }

   public void pauseApp() {
      if (this.gamecanvas != null) {
         this.gamecanvas.hideNotify();
      }

   }

   public void startApp() {
      if (this.gamecanvas != null) {
         this.gamecanvas.showNotify();
      }

   }
}
