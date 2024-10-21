package main;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

/* loaded from: classes.dex */
/**
 * XConnection is a MIDlet that initializes and manages the lifecycle of the MainCanvas game.
 * It extends the javax.microedition.midlet.MIDlet class and overrides its lifecycle methods.
 */
public final class XConnection extends MIDlet {
    public MainCanvas gamecanvas = new MainCanvas(this);

    /**
     * Constructor for XConnection.
     * Initializes the MainCanvas and sets it as the current display.
     * Also starts the game.
     */
    public XConnection() {
        Display.getDisplay(this).setCurrent(this.gamecanvas);
        this.gamecanvas.game_start();
    }

    /**
     * Called when the MIDlet is started.
     * If the game canvas is not null, it triggers the showNotify method of the game canvas.
     */
    @Override // javax.microedition.midlet.MIDlet
    public void startApp() {
        if (this.gamecanvas != null) {
            this.gamecanvas.showNotify();
        }
    }

    /**
     * Called when the MIDlet is paused.
     * If the game canvas is not null, it triggers the hideNotify method of the game canvas.
     */
    @Override // javax.microedition.midlet.MIDlet
    public void pauseApp() {
        if (this.gamecanvas != null) {
            this.gamecanvas.hideNotify();
        }
    }

    /**
     * Called when the MIDlet is destroyed.
     * Stops the game and notifies that the MIDlet has been destroyed.
     *
     * @param parm a boolean parameter indicating if the MIDlet is being destroyed unconditionally.
     */
    @Override // javax.microedition.midlet.MIDlet
    public void destroyApp(boolean parm) {
        this.gamecanvas.game_stop();
        notifyDestroyed();
    }
}
