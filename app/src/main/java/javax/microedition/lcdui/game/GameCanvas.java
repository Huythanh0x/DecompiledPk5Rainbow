package javax.microedition.lcdui.game;

import android.content.Context;
import android.util.AttributeSet;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

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

   public GameCanvas(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public void paint(Graphics var1) {
   }
}
