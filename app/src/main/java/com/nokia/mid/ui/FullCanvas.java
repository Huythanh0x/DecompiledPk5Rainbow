package com.nokia.mid.ui;

import android.content.Context;
import android.util.AttributeSet;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.CwaActivity;

/* loaded from: classes.dex */
/**
 * FullCanvas is an abstract class that extends the Canvas class.
 * It provides constants for various key codes and ensures that the window is set to full screen.
 * 
 * Key Code Constants:
 * - KEY_UP_ARROW: Represents the up arrow key (value: 19).
 * - KEY_DOWN_ARROW: Represents the down arrow key (value: 20).
 * - KEY_LEFT_ARROW: Represents the left arrow key (value: 21).
 * - KEY_RIGHT_ARROW: Represents the right arrow key (value: 22).
 * - KEY_END: Represents the end key (value: 6).
 * - KEY_SEND: Represents the send key (value: 5).
 * - KEY_SOFTKEY1: Represents the first soft key (value: 1).
 * - KEY_SOFTKEY2: Represents the second soft key (value: 2).
 * - KEY_SOFTKEY3: Represents the third soft key (value: 23).
 * 
 * Constructors:
 * - FullCanvas(): Default constructor that sets the window to full screen.
 * - FullCanvas(Context context, AttributeSet attrs): Constructor with context and attribute set parameters.
 */
/**
 * FullCanvas is an abstract class that extends Canvas and provides key constants
 * for various key events. It also ensures that the window is set to full screen.
 */
public abstract class FullCanvas extends Canvas {

    /**
     * Key code for the up arrow key.
     */
    public static int KEY_UP_ARROW = 19;

    /**
     * Key code for the down arrow key.
     */
    public static int KEY_DOWN_ARROW = 20;

    /**
     * Key code for the left arrow key.
     */
    public static int KEY_LEFT_ARROW = 21;

    /**
     * Key code for the right arrow key.
     */
    public static int KEY_RIGHT_ARROW = 22;

    /**
     * Key code for the end key.
     */
    public static int KEY_END = 6;

    /**
     * Key code for the send key.
     */
    public static int KEY_SEND = 5;

    /**
     * Key code for the first soft key.
     */
    public static int KEY_SOFTKEY1 = 1;

    /**
     * Key code for the second soft key.
     */
    public static int KEY_SOFTKEY2 = 2;

    /**
     * Key code for the third soft key.
     */
    public static int KEY_SOFTKEY3 = 23;

    /**
     * Default constructor that sets the window to full screen.
     */
    public FullCanvas() {
        CwaActivity.getInstance().setFullWindow(true);
    }

    /**
     * Constructor with context and attribute set parameters.
     *
     * @param context the context in which the canvas is running
     * @param attrs the attribute set for the canvas
     */
    protected FullCanvas(Context context, AttributeSet attrs) {
    }
}
