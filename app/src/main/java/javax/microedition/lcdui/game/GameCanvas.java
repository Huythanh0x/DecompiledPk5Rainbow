package javax.microedition.lcdui.game;

import android.content.Context;
import android.util.AttributeSet;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

public abstract class GameCanvas extends Canvas {
    public static final int DOWN_PRESSED = 0x40;
    public static final int FIRE_PRESSED = 0x100;
    public static final int GAME_A_PRESSED = 0x200;
    public static final int GAME_B_PRESSED = 0x400;
    public static final int GAME_C_PRESSED = 0x800;
    public static final int GAME_D_PRESSED = 0x1000;
    public static final int LEFT_PRESSED = 4;
    public static final int RIGHT_PRESSED = 0x20;
    public static final int UP_PRESSED = 2;

    public GameCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override  // javax.microedition.lcdui.Canvas
    public void paint(Graphics g) {
    }
}

