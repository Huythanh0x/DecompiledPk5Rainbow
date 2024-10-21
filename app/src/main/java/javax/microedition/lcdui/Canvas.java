/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnKeyListener
 *  android.view.View$OnTouchListener
 *  com.android.Util.AndroidUtil
 *  javax.microedition.lcdui.CwaActivity
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.midlet.MIDletManager
 */
package javax.microedition.lcdui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.android.Util.AndroidUtil;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDletManager;

public abstract class Canvas
extends View
implements View.OnTouchListener,
View.OnKeyListener {
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
    float scale_x = 1.0f;
    float scale_y = 1.0f;

    protected Canvas() {
        super(CwaActivity.getContextInstance());
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        this.setLongClickable(true);
        this.setOnKeyListener(this);
        this.setOnTouchListener(this);
    }

    protected Canvas(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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

    protected void keyPressed(int n) {
    }

    protected void keyReleased(int n) {
    }

    protected void keyRepeated(int n) {
    }

    /*
     * Unable to fully structure code
     */
    protected void onDraw(android.graphics.Canvas var1_1) {
        if (this.g == null) {
            this.g = new Graphics(var1_1);
lbl3:
            // 2 sources

            while (true) {
                if (this.scale_x != 1.0f && this.scale_y != 1.0f) {
                    var1_1.scale(this.scale_x, this.scale_y);
                }
                if (this.g.isAutoResetPainter()) {
                    this.g.painterReset();
                }
                this.paint(this.g);
                AndroidUtil.cv.open();
                return;
            }
        }
        this.g.setCanvas(var1_1);
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public boolean onKey(View view, int n, KeyEvent keyEvent) {
        switch (keyEvent.getAction()) {
            default: {
                Log.e((String)"Canvas", (String)"not this key");
                return false;
            }
            case 0: {
                if (n == 25) {
                    CwaActivity.getInstance().audioManager.adjustStreamVolume(3, -1, 0);
                    return true;
                }
                if (n == 24) {
                    CwaActivity.getInstance().audioManager.adjustStreamVolume(3, 1, 0);
                    return true;
                }
                if (n == 4) {
                    if (keyEvent.getRepeatCount() != 0) return true;
                    MIDletManager.getInstance().notifyPaused();
                    CwaActivity.getInstance().showExitDialog();
                    return true;
                }
                this.keyPressed(keyEvent.getKeyCode());
                return true;
            }
            case 1: 
        }
        this.keyReleased(keyEvent.getKeyCode());
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public boolean onTouch(View var1_1, MotionEvent var2_2) {
        var3_3 = (int)(var2_2.getX() / this.keyxx);
        var4_4 = (int)(var2_2.getY() / this.keyyy);
        switch (var2_2.getAction()) lbl-1000:
        // 3 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                return true;
            }
            case 0: {
                this.pointerPressed(var3_3, var4_4);
                ** GOTO lbl-1000
            }
            case 1: {
                this.pointerReleased(var3_3, var4_4);
                ** GOTO lbl-1000
            }
            case 2: 
        }
        this.pointerDragged(var3_3, var4_4);
        ** while (true)
    }

    protected abstract void paint(Graphics var1);

    protected void pointerDragged(int n, int n2) {
    }

    protected void pointerPressed(int n, int n2) {
    }

    protected void pointerReleased(int n, int n2) {
    }

    public final void repaint() {
        this.postInvalidate();
    }

    public final void repaint(int n, int n2, int n3, int n4) {
        this.postInvalidate(n, n2, n + n3, n2 + n4);
    }

    public final void serviceRepaints() {
    }

    public void setFullScreenMode(boolean bl) {
    }

    public void setScale(float f, float f2) {
        this.scale_x = f;
        this.scale_y = f2;
        this.g.getXY(f, f2);
    }

    public void showNotify() {
    }
}
