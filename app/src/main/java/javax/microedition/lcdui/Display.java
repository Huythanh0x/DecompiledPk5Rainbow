package javax.microedition.lcdui;

import javax.microedition.midlet.MIDlet;

/* loaded from: classes.dex */
public class Display {
    private static Canvas canvas;

    private Display() {
    }

    public static Display getDisplay(MIDlet midlet) {
        return new Display();
    }

    public void setCurrent(Canvas gCanvas) {
        CwaActivity.getInstance().setCanvas(gCanvas);
        canvas = gCanvas;
    }

    public static Canvas getCanvas() {
        return canvas;
    }
}
