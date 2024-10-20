package javax.microedition.lcdui;

import javax.microedition.midlet.MIDlet;

/**
 * The Display class is used to manage the display of MIDlet applications.
 */
/**
 * The Display class is responsible for managing the display of a MIDlet.
 * It provides methods to get the current display instance and set or get the current canvas.
 */
public class Display {
    private static Canvas canvas;

    /**
     * Private constructor to prevent instantiation.
     */
    private Display() {
    }

    /**
     * Returns the Display instance associated with the given MIDlet.
     *
     * @param midlet the MIDlet for which the Display instance is requested
     * @return a new Display instance
     */
    public static Display getDisplay(MIDlet midlet) {
        return new Display();
    }

    /**
     * Sets the current canvas to be displayed.
     *
     * @param gCanvas the Canvas to be set as current
     */
    public void setCurrent(Canvas gCanvas) {
        CwaActivity.getInstance().setCanvas(gCanvas);
        canvas = gCanvas;
    }

    /**
     * Returns the current canvas being displayed.
     *
     * @return the current Canvas
     */
    public static Canvas getCanvas() {
        return canvas;
    }
}
