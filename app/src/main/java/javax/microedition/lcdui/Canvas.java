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
      this.setFocusable(true);
      this.setFocusableInTouchMode(true);
      this.setLongClickable(true);
      this.setOnKeyListener(this);
      this.setOnTouchListener(this);
   }

   protected Canvas(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.setFocusable(true);
      this.setFocusableInTouchMode(true);
      this.setLongClickable(true);
      this.setOnKeyListener(this);
      this.setOnTouchListener(this);
   }

   public int getScreenHeight() {
      return AndroidUtil.SCREEN_HEIGHT;
   }

   public int getScreenWidth() {
      return AndroidUtil.SCREEN_WIDTH;
   }

   public void hideNotify() {
   }

   protected void keyPressed(int var1) {
   }

   protected void keyReleased(int var1) {
   }

   protected void keyRepeated(int var1) {
   }

   protected void onDraw(android.graphics.Canvas var1) {
      if (this.g == null) {
         this.g = new Graphics(var1);
      } else {
         this.g.setCanvas(var1);
      }

      if (this.scale_x != 1.0F && this.scale_y != 1.0F) {
         var1.scale(this.scale_x, this.scale_y);
      }

      if (this.g.isAutoResetPainter()) {
         this.g.painterReset();
      }

      this.paint(this.g);
      AndroidUtil.cv.open();
   }

   public boolean onKey(View var1, int var2, KeyEvent var3) {
      boolean var4;
      switch (var3.getAction()) {
         case 0:
            if (var2 == 25) {
               CwaActivity.getInstance().audioManager.adjustStreamVolume(3, -1, 0);
            } else if (var2 == 24) {
               CwaActivity.getInstance().audioManager.adjustStreamVolume(3, 1, 0);
            } else if (var2 == 4) {
               if (var3.getRepeatCount() == 0) {
                  MIDletManager.getInstance().notifyPaused();
                  CwaActivity.getInstance().showExitDialog();
               }
            } else {
               this.keyPressed(var3.getKeyCode());
            }

            var4 = true;
            break;
         case 1:
            this.keyReleased(var3.getKeyCode());
            var4 = true;
            break;
         default:
            Log.e("Canvas", "not this key");
            var4 = false;
      }

      return var4;
   }

   public boolean onTouch(View var1, MotionEvent var2) {
      int var3 = (int)(var2.getX() / this.keyxx);
      int var4 = (int)(var2.getY() / this.keyyy);
      switch (var2.getAction()) {
         case 0:
            this.pointerPressed(var3, var4);
            break;
         case 1:
            this.pointerReleased(var3, var4);
            break;
         case 2:
            this.pointerDragged(var3, var4);
      }

      return true;
   }

   protected abstract void paint(Graphics var1);

   protected void pointerDragged(int var1, int var2) {
   }

   protected void pointerPressed(int var1, int var2) {
   }

   protected void pointerReleased(int var1, int var2) {
   }

   public final void repaint() {
      this.postInvalidate();
   }

   public final void repaint(int var1, int var2, int var3, int var4) {
      this.postInvalidate(var1, var2, var1 + var3, var2 + var4);
   }

   public final void serviceRepaints() {
   }

   public void setFullScreenMode(boolean var1) {
   }

   public void setScale(float var1, float var2) {
      this.scale_x = var1;
      this.scale_y = var2;
      this.g.getXY(var1, var2);
   }

   public void showNotify() {
   }
}
