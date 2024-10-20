package javax.microedition.lcdui;

import javax.microedition.midlet.MIDlet;

public class Display {
    private static Canvas canvas;

    public static Canvas getCanvas() {
        return Display.canvas;
    }

    public static Display getDisplay(MIDlet midlet) {
        return new Display();
    }

    public void setCurrent(Canvas gCanvas) {
        CwaActivity.getInstance().setCanvas(gCanvas);
        Display.canvas = gCanvas;
    }
}

