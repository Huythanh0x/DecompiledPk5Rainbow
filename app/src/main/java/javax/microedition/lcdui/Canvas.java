package javax.microedition.lcdui;

import android.view.MotionEvent;
import javax.microedition.midlet.MIDletManager;
import android.util.Log;
import android.view.KeyEvent;
import com.android.Util.AndroidUtil;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View$OnKeyListener;
import android.view.View$OnTouchListener;
import android.view.View;

public abstract class Canvas extends View implements View$OnTouchListener, View$OnKeyListener
{
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
    
    protected Canvas() {
        super(CwaActivity.getContextInstance());
        this.scale_x = 1.0f;
        this.scale_y = 1.0f;
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        this.setLongClickable(true);
        this.setOnKeyListener((View$OnKeyListener)this);
        this.setOnTouchListener((View$OnTouchListener)this);
    }
    
    protected Canvas(final Context context, final AttributeSet set) {
        super(context, set);
        this.scale_x = 1.0f;
        this.scale_y = 1.0f;
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        this.setLongClickable(true);
        this.setOnKeyListener((View$OnKeyListener)this);
        this.setOnTouchListener((View$OnTouchListener)this);
    }
    
    public int getScreenHeight() {
        return AndroidUtil.SCREEN_HEIGHT;
    }
    
    public int getScreenWidth() {
        return AndroidUtil.SCREEN_WIDTH;
    }
    
    public void hideNotify() {
    }
    
    protected void keyPressed(final int n) {
    }
    
    protected void keyReleased(final int n) {
    }
    
    protected void keyRepeated(final int n) {
    }
    
    protected void onDraw(final android.graphics.Canvas canvas) {
        if (this.g == null) {
            this.g = new Graphics(canvas);
        }
        else {
            this.g.setCanvas(canvas);
        }
        if (this.scale_x != 1.0f && this.scale_y != 1.0f) {
            canvas.scale(this.scale_x, this.scale_y);
        }
        if (this.g.isAutoResetPainter()) {
            this.g.painterReset();
        }
        this.paint(this.g);
        AndroidUtil.cv.open();
    }
    
    public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
        boolean b = false;
        switch (keyEvent.getAction()) {
            default: {
                Log.e("Canvas", "not this key");
                b = false;
                break;
            }
            case 0: {
                if (n == 25) {
                    CwaActivity.getInstance().audioManager.adjustStreamVolume(3, -1, 0);
                }
                else if (n == 24) {
                    CwaActivity.getInstance().audioManager.adjustStreamVolume(3, 1, 0);
                }
                else if (n == 4) {
                    if (keyEvent.getRepeatCount() == 0) {
                        MIDletManager.getInstance().notifyPaused();
                        CwaActivity.getInstance().showExitDialog();
                    }
                }
                else {
                    this.keyPressed(keyEvent.getKeyCode());
                }
                b = true;
                break;
            }
            case 1: {
                this.keyReleased(keyEvent.getKeyCode());
                b = true;
                break;
            }
        }
        return b;
    }
    
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        final int n = (int)(motionEvent.getX() / this.keyxx);
        final int n2 = (int)(motionEvent.getY() / this.keyyy);
        switch (motionEvent.getAction()) {
            case 0: {
                this.pointerPressed(n, n2);
                break;
            }
            case 1: {
                this.pointerReleased(n, n2);
                break;
            }
            case 2: {
                this.pointerDragged(n, n2);
                break;
            }
        }
        return true;
    }
    
    protected abstract void paint(final Graphics p0);
    
    protected void pointerDragged(final int n, final int n2) {
    }
    
    protected void pointerPressed(final int n, final int n2) {
    }
    
    protected void pointerReleased(final int n, final int n2) {
    }
    
    public final void repaint() {
        this.postInvalidate();
    }
    
    public final void repaint(final int n, final int n2, final int n3, final int n4) {
        this.postInvalidate(n, n2, n + n3, n2 + n4);
    }
    
    public final void serviceRepaints() {
    }
    
    public void setFullScreenMode(final boolean b) {
    }
    
    public void setScale(final float scale_x, final float scale_y) {
        this.scale_x = scale_x;
        this.scale_y = scale_y;
        this.g.getXY(scale_x, scale_y);
    }
    
    public void showNotify() {
    }
}
