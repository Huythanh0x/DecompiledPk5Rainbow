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

    public void setFullScreenMode(boolean mode) {
    }

    protected void keyPressed(int keyCode) {
    }

    protected void keyRepeated(int keyCode) {
    }

    protected void keyReleased(int keyCode) {
    }

    protected void pointerPressed(int x, int y) {
    }

    protected void pointerReleased(int x, int y) {
    }

    protected void pointerDragged(int x, int y) {
    }

    public final void repaint(int x, int y, int width, int height) {
        postInvalidate(x, y, x + width, y + height);
    }

    public final void repaint() {
        postInvalidate();
    }

    public final void serviceRepaints() {
    }

    public void showNotify() {
    }

    public void hideNotify() {
    }

    public void setScale(float x, float y) {
        this.scale_x = x;
        this.scale_y = y;
        this.g.getXY(x, y);
    }

    @Override // android.view.View
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

    public int getScreenWidth() {
        return AndroidUtil.SCREEN_WIDTH;
    }

    public int getScreenHeight() {
        return AndroidUtil.SCREEN_HEIGHT;
    }
}
