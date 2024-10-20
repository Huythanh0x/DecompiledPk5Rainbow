package javax.microedition.lcdui.game;

import android.content.Context;
import android.util.AttributeSet;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

/* loaded from: classes.dex */
/**
 * The GameCanvas class extends the Canvas class to provide a framework for 
 * creating games. It includes constants representing various key press states 
 * that can be used to handle user input in a game.
 * 
 * Constants:
 * - {@code DOWN_PRESSED}: Represents the down key being pressed.
 * - {@code FIRE_PRESSED}: Represents the fire key being pressed.
 * - {@code GAME_A_PRESSED}: Represents the game A key being pressed.
 * - {@code GAME_B_PRESSED}: Represents the game B key being pressed.
 * - {@code GAME_C_PRESSED}: Represents the game C key being pressed.
 * - {@code GAME_D_PRESSED}: Represents the game D key being pressed.
 * - {@code LEFT_PRESSED}: Represents the left key being pressed.
 * - {@code RIGHT_PRESSED}: Represents the right key being pressed.
 * - {@code UP_PRESSED}: Represents the up key being pressed.
 * 
 * Constructor:
 * - {@code GameCanvas(Context context, AttributeSet attrs)}: Initializes a new 
 *   instance of the GameCanvas class with the specified context and attribute set.
 * 
 * Methods:
 * - {@code paint(Graphics g)}: An overridden method from the Canvas class that 
 *   is used to render the game graphics. This method should be implemented by 
 *   subclasses to provide custom painting logic.
 */
public abstract class GameCanvas extends Canvas {
    public static final int DOWN_PRESSED = 64;
    public static final int FIRE_PRESSED = 256;
    public static final int GAME_A_PRESSED = 512;
    public static final int GAME_B_PRESSED = 1024;
    public static final int GAME_C_PRESSED = 2048;
    public static final int GAME_D_PRESSED = 4096;
    public static final int LEFT_PRESSED = 4;
    public static final int RIGHT_PRESSED = 32;
    public static final int UP_PRESSED = 2;

    public GameCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override // javax.microedition.lcdui.Canvas
    public void paint(Graphics g) {
    }
}
