/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Canvas
 *  javax.microedition.lcdui.CwaActivity
 *  javax.microedition.midlet.MIDlet
 */
package javax.microedition.lcdui;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.midlet.MIDlet;

public class Display {
    private static Canvas canvas;

    private Display() {
    }

    public static Canvas getCanvas() {
        return canvas;
    }

    public static Display getDisplay(MIDlet mIDlet) {
        return new Display();
    }

    public void setCurrent(Canvas canvas) {
        CwaActivity.getInstance().setCanvas(canvas);
        Display.canvas = canvas;
    }
}
