package javax.microedition.lcdui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.android.Util.AndroidUtil;
import javax.microedition.midlet.MIDletManager;

/* loaded from: classes.dex */
/**
 * The Canvas class is an abstract class that extends the View class and implements
 * the View.OnTouchListener and View.OnKeyListener interfaces. It provides a framework
 * for handling touch and key events, as well as drawing graphics on the screen.
 * 
 * Constants:
 * - DOWN: Represents the down key code.
 * - FIRE: Represents the fire key code.
 * - GAME_A, GAME_B, GAME_C, GAME_D: Represent game key codes.
 * - KEY_NUM0 to KEY_NUM9: Represent numeric key codes.
 * - KEY_POUND: Represents the pound key code.
 * - KEY_STAR: Represents the star key code.
 * - LEFT: Represents the left key code.
 * - RIGHT: Represents the right key code.
 * - UP: Represents the up key code.
 * 
 * Fields:
 * - g: An instance of the Graphics class used for drawing.
 * - keyxx, keyyy: Float values representing key coordinates.
 * - scale_x, scale_y: Float values representing the scale factors for the x and y axes.
 * 
 * Constructors:
 * - Canvas(): Initializes a new instance of the Canvas class with default context.
 * - Canvas(Context context, AttributeSet attrs): Initializes a new instance of the Canvas class with specified context and attributes.
 * 
 * Methods:
 * - setFullScreenMode(boolean mode): Sets the full screen mode.
 * - keyPressed(int keyCode): Handles key press events.
 * - keyRepeated(int keyCode): Handles key repeat events.
 * - keyReleased(int keyCode): Handles key release events.
 * - pointerPressed(int x, int y): Handles pointer press events.
 * - pointerReleased(int x, int y): Handles pointer release events.
 * - pointerDragged(int x, int y): Handles pointer drag events.
 * - repaint(int x, int y, int width, int height): Requests a repaint for the specified area.
 * - repaint(): Requests a repaint for the entire view.
 * - serviceRepaints(): Services repaint requests.
 * - showNotify(): Called when the view is shown.
 * - hideNotify(): Called when the view is hidden.
 * - setScale(float x, float y): Sets the scale factors for the x and y axes.
 * - onDraw(android.graphics.Canvas canvas): Draws the content of the view on the specified canvas.
 * - onTouch(View v, MotionEvent event): Handles touch events.
 * - onKey(View v, int keyCode, KeyEvent event): Handles key events.
 * - getScreenWidth(): Returns the screen width.
 * - getScreenHeight(): Returns the screen height.
 * 
 * Abstract Methods:
 * - paint(Graphics graphics): Abstract method to be implemented by subclasses for custom drawing.
 */
/**
 * The Canvas class is an abstract class that extends View and implements 
 * View.OnTouchListener and View.OnKeyListener. It provides a framework for 
 * handling touch and key events, as well as drawing operations.
 */
public abstract class Canvas extends View implements View.OnTouchListener, View.OnKeyListener {
    public static final int DOWN = 20;
    public static final int FIRE = 23;
    public static final int GAME_A = 9;
    public static final int GAME_B = 10;
    public static final int GAME_C = 11;
    public static final int GAME_D = 12;
    public static final int KEY_NUM0 = 7;
    public static final int KEY_NUM1 = 8;
    public static final int KEY_NUM2 = 9;
    public static final int KEY_NUM3 = 10;
    public static final int KEY_NUM4 = 11;
    public static final int KEY_NUM5 = 12;
    public static final int KEY_NUM6 = 13;
    public static final int KEY_NUM7 = 14;
    public static final int KEY_NUM8 = 15;
    public static final int KEY_NUM9 = 16;
    public static final int KEY_POUND = 18;
    public static final int KEY_STAR = 17;
    public static final int LEFT = 21;
    public static final int RIGHT = 22;
    public static final int UP = 19;
    private Graphics g;
    public float keyxx;
    public float keyyy;
    float scale_x;
    float scale_y;

    protected abstract void paint(Graphics graphics);

    /**
     * Constructs a new Canvas with default context.
     */
    public Canvas() {
        super(CwaActivity.getContextInstance());
        this.scale_x = 1.0f;
        this.scale_y = 1.0f;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLongClickable(true);
        setOnKeyListener(this);
        setOnTouchListener(this);
    }

    /**
     * Constructs a new Canvas with the specified context and attribute set.
     *
     * @param context the context to use
     * @param attrs the attribute set to use
     */
    public Canvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.scale_x = 1.0f;
        this.scale_y = 1.0f;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLongClickable(true);
        setOnKeyListener(this);
        setOnTouchListener(this);
    }

    /**
     * Sets the full screen mode.
     *
     * @param mode true to enable full screen mode, false otherwise
     */
    public void setFullScreenMode(boolean mode) {
    }

    /**
     * Called when a key is pressed.
     *
     * @param keyCode the code of the key that was pressed
     */
    protected void keyPressed(int keyCode) {
    }

    /**
     * Called when a key is repeated.
     *
     * @param keyCode the code of the key that was repeated
     */
    protected void keyRepeated(int keyCode) {
    }

    /**
     * Called when a key is released.
     *
     * @param keyCode the code of the key that was released
     */
    protected void keyReleased(int keyCode) {
    }

    /**
     * Called when a pointer is pressed.
     *
     * @param x the x-coordinate of the pointer
     * @param y the y-coordinate of the pointer
     */
    protected void pointerPressed(int x, int y) {
    }

    /**
     * Called when a pointer is released.
     *
     * @param x the x-coordinate of the pointer
     * @param y the y-coordinate of the pointer
     */
    protected void pointerReleased(int x, int y) {
    }

    /**
     * Called when a pointer is dragged.
     *
     * @param x the x-coordinate of the pointer
     * @param y the y-coordinate of the pointer
     */
    protected void pointerDragged(int x, int y) {
    }

    /**
     * Requests a repaint of the specified area.
     *
     * @param x the x-coordinate of the area to repaint
     * @param y the y-coordinate of the area to repaint
     * @param width the width of the area to repaint
     * @param height the height of the area to repaint
     */
    public final void repaint(int x, int y, int width, int height) {
        postInvalidate(x, y, x + width, y + height);
    }

    /**
     * Requests a repaint of the entire canvas.
     */
    public final void repaint() {
        postInvalidate();
    }

    /**
     * Services any pending repaint requests.
     */
    public final void serviceRepaints() {
    }

    /**
     * Called when the canvas is shown.
     */
    public void showNotify() {
    }

    /**
     * Called when the canvas is hidden.
     */
    public void hideNotify() {
    }

    /**
     * Sets the scale for the canvas.
     *
     * @param x the scale factor in the x direction
     * @param y the scale factor in the y direction
     */
    public void setScale(float x, float y) {
        this.scale_x = x;
        this.scale_y = y;
        this.g.getXY(x, y);
    }

    /**
     * Called to draw the canvas.
     *
     * @param canvas the canvas to draw on
     */
    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.g == null) {
            this.g = new Graphics(canvas);
        } else {
            this.g.setCanvas(canvas);
        }
        if (this.scale_x != 1.0f && this.scale_y != 1.0f) {
            canvas.scale(this.scale_x, this.scale_y);
        }
        if (this.g.isAutoResetPainter()) {
            this.g.painterReset();
        }
        paint(this.g);
        AndroidUtil.cv.open();
    }

    /**
     * Handles touch events.
     *
     * @param v the view that was touched
     * @param event the motion event
     * @return true if the event was handled, false otherwise
     */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) (event.getX() / this.keyxx);
        int y = (int) (event.getY() / this.keyyy);
        switch (event.getAction()) {
            case 0:
                pointerPressed(x, y);
                return true;
            case 1:
                pointerReleased(x, y);
                return true;
            case 2:
                pointerDragged(x, y);
                return true;
            default:
                return true;
        }
    }

    /**
     * Handles key events.
     *
     * @param v the view that received the key event
     * @param keyCode the code of the key that was pressed
     * @param event the key event
     * @return true if the event was handled, false otherwise
     */
    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (event.getAction()) {
            case 0:
                if (keyCode == 25) {
                    CwaActivity.getInstance().audioManager.adjustStreamVolume(3, -1, 0);
                } else if (keyCode == 24) {
                    CwaActivity.getInstance().audioManager.adjustStreamVolume(3, 1, 0);
                } else if (keyCode == 4) {
                    if (event.getRepeatCount() == 0) {
                        MIDletManager.getInstance().notifyPaused();
                        CwaActivity.getInstance().showExitDialog();
                    }
                } else {
                    keyPressed(event.getKeyCode());
                }
                return true;
            case 1:
                keyReleased(event.getKeyCode());
                return true;
            default:
                Log.e("Canvas", "not this key");
                return false;
        }
    }

    /**
     * Gets the screen width.
     *
     * @return the screen width
     */
    public int getScreenWidth() {
        return AndroidUtil.SCREEN_WIDTH;
    }

    /**
     * Gets the screen height.
     *
     * @return the screen height
     */
    public int getScreenHeight() {
        return AndroidUtil.SCREEN_HEIGHT;
    }
}
