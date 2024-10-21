package main;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public final class XConnection extends MIDlet {
    public MainCanvas gamecanvas;

    public XConnection() {
        this.gamecanvas = new MainCanvas(this);
        Display.getDisplay(this).setCurrent(this.gamecanvas);
        this.gamecanvas.game_start();
    }

    @Override  // javax.microedition.midlet.MIDlet
    public void destroyApp(boolean parm) {
        this.gamecanvas.game_stop();
        this.notifyDestroyed();
    }

    @Override  // javax.microedition.midlet.MIDlet
    public void pauseApp() {
        if(this.gamecanvas != null) {
            this.gamecanvas.hideNotify();
        }
    }

    @Override  // javax.microedition.midlet.MIDlet
    public void startApp() {
        if(this.gamecanvas != null) {
            this.gamecanvas.showNotify();
        }
    }
}

