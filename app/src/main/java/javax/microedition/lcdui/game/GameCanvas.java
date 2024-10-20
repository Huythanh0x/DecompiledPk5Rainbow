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
  
  public GameCanvas(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public void paint(Graphics paramGraphics) {}
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/lcdui/game/GameCanvas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */