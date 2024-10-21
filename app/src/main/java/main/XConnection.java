/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Canvas
 *  javax.microedition.lcdui.Display
 *  javax.microedition.midlet.MIDlet
 *  main.MainCanvas
 */
package main;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import main.MainCanvas;

public final class XConnection
extends MIDlet {
    public MainCanvas gamecanvas = new MainCanvas(this);

    public XConnection() {
        Display.getDisplay((MIDlet)this).setCurrent((Canvas)this.gamecanvas);
        this.gamecanvas.game_start();
    }

    public void destroyApp(boolean bl) {
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
