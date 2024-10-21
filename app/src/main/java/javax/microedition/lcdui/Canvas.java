package javax.microedition.lcdui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.android.Util.AndroidUtil;
import javax.microedition.midlet.MIDletManager;

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
  
  float scale_x = 1.0F;
  
  float scale_y = 1.0F;
  
  protected Canvas() {
    super(CwaActivity.getContextInstance());
    setFocusable(true);
    setFocusableInTouchMode(true);
    setLongClickable(true);
    setOnKeyListener(this);
    setOnTouchListener(this);
  }
  
  protected Canvas(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
    setFocusableInTouchMode(true);
    setLongClickable(true);
    setOnKeyListener(this);
    setOnTouchListener(this);
  }
  
  public int getScreenHeight() {
    return AndroidUtil.SCREEN_HEIGHT;
  }
  
  public int getScreenWidth() {
    return AndroidUtil.SCREEN_WIDTH;
  }
  
  public void hideNotify() {}
  
  protected void keyPressed(int paramInt) {}
  
  protected void keyReleased(int paramInt) {}
  
  protected void keyRepeated(int paramInt) {}
  
  protected void onDraw(android.graphics.Canvas paramCanvas) {
    if (this.g == null) {
      this.g = new Graphics(paramCanvas);
    } else {
      this.g.setCanvas(paramCanvas);
    } 
    if (this.scale_x != 1.0F && this.scale_y != 1.0F)
      paramCanvas.scale(this.scale_x, this.scale_y); 
    if (this.g.isAutoResetPainter())
      this.g.painterReset(); 
    paint(this.g);
    AndroidUtil.cv.open();
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    switch (paramKeyEvent.getAction()) {
      default:
        Log.e("Canvas", "not this key");
        return false;
      case 0:
        if (paramInt == 25) {
          (CwaActivity.getInstance()).audioManager.adjustStreamVolume(3, -1, 0);
        } else if (paramInt == 24) {
          (CwaActivity.getInstance()).audioManager.adjustStreamVolume(3, 1, 0);
        } else if (paramInt == 4) {
          if (paramKeyEvent.getRepeatCount() == 0) {
            MIDletManager.getInstance().notifyPaused();
            CwaActivity.getInstance().showExitDialog();
          } 
        } else {
          keyPressed(paramKeyEvent.getKeyCode());
        } 
        return true;
      case 1:
        break;
    } 
    keyReleased(paramKeyEvent.getKeyCode());
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    int i = (int)(paramMotionEvent.getX() / this.keyxx);
    int j = (int)(paramMotionEvent.getY() / this.keyyy);
    switch (paramMotionEvent.getAction()) {
      default:
        return true;
      case 0:
        pointerPressed(i, j);
      case 1:
        pointerReleased(i, j);
      case 2:
        break;
    } 
    pointerDragged(i, j);
  }
  
  protected abstract void paint(Graphics paramGraphics);
  
  protected void pointerDragged(int paramInt1, int paramInt2) {}
  
  protected void pointerPressed(int paramInt1, int paramInt2) {}
  
  protected void pointerReleased(int paramInt1, int paramInt2) {}
  
  public final void repaint() {
    postInvalidate();
  }
  
  public final void repaint(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    postInvalidate(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  public final void serviceRepaints() {}
  
  public void setFullScreenMode(boolean paramBoolean) {}
  
  public void setScale(float paramFloat1, float paramFloat2) {
    this.scale_x = paramFloat1;
    this.scale_y = paramFloat2;
    this.g.getXY(paramFloat1, paramFloat2);
  }
  
  public void showNotify() {}
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/lcdui/Canvas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */