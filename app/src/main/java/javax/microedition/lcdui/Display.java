package javax.microedition.lcdui;

import javax.microedition.midlet.MIDlet;

public class Display
{
    private static Canvas canvas;
    
    private Display() {
        super();
    }
    
    public static Canvas getCanvas() {
        return Display.canvas;
    }
    
    public static Display getDisplay(final MIDlet miDlet) {
        return new Display();
    }
    
    public void setCurrent(final Canvas canvas) {
        CwaActivity.getInstance().setCanvas(canvas);
        Display.canvas = canvas;
    }
}
