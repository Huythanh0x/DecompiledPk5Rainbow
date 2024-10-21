package javax.microedition.lcdui.Canvas;
import android.view.View$OnTouchListener;
import android.view.View$OnKeyListener;
import android.view.View;
import android.content.Context;
import javax.microedition.lcdui.CwaActivity;
import android.util.AttributeSet;
import com.android.Util.AndroidUtil;
import android.graphics.Canvas;
import javax.microedition.lcdui.Graphics;
import android.os.ConditionVariable;
import android.view.KeyEvent;
import java.lang.String;
import android.util.Log;
import android.media.AudioManager;
import javax.microedition.midlet.MIDletManager;
import android.view.MotionEvent;

public abstract class Canvas extends View implements View$OnTouchListener, View$OnKeyListener	// class@00013c from classes.dex
{
    private Graphics g;
    public float keyxx;
    public float keyyy;
    float scale_x;
    float scale_y;
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

    protected void Canvas(){
       super(CwaActivity.getContextInstance());
       this.scale_x = 1.00f;
       this.scale_y = 1.00f;
       this.setFocusable(true);
       this.setFocusableInTouchMode(true);
       this.setLongClickable(true);
       this.setOnKeyListener(this);
       this.setOnTouchListener(this);
    }
    protected void Canvas(Context context,AttributeSet attrs){
       super(context, attrs);
       this.scale_x = 1.00f;
       this.scale_y = 1.00f;
       this.setFocusable(true);
       this.setFocusableInTouchMode(true);
       this.setLongClickable(true);
       this.setOnKeyListener(this);
       this.setOnTouchListener(this);
    }
    public int getScreenHeight(){
       return AndroidUtil.SCREEN_HEIGHT;
    }
    public int getScreenWidth(){
       return AndroidUtil.SCREEN_WIDTH;
    }
    public void hideNotify(){
    }
    protected void keyPressed(int keyCode){
    }
    protected void keyReleased(int keyCode){
    }
    protected void keyRepeated(int keyCode){
    }
    protected void onDraw(Canvas canvas){
       int i = 0x3f800000;
       if (this.g == null) {
          this.g = new Graphics(canvas);
       }else {
          this.g.setCanvas(canvas);
       }
       if ((i - this.scale_x) && (i - this.scale_y)) {
          canvas.scale(this.scale_x, this.scale_y);
       }
       if (this.g.isAutoResetPainter()) {
          this.g.painterReset();
       }
       this.paint(this.g);
       AndroidUtil.cv.open();
       return;
    }
    public boolean onKey(View v,int keyCode,KeyEvent event){
       boolean b;
       switch (event.getAction()){
           case 0:
             if (keyCode == 25) {
                CwaActivity.getInstance().audioManager.adjustStreamVolume(3, -1, 0);
             }else if(keyCode == 24){
                CwaActivity.getInstance().audioManager.adjustStreamVolume(3, 1, 0);
             }else if(keyCode == 4){
                if (!event.getRepeatCount()) {
                   MIDletManager.getInstance().notifyPaused();
                   CwaActivity.getInstance().showExitDialog();
                }
             }else {
                this.keyPressed(event.getKeyCode());
             }
             b = true;
             break;
           case 1:
             this.keyReleased(event.getKeyCode());
             b = 1;
             break;
           default:
             Log.e("Canvas", "not this key");
             b = 0;
       }
       return b;
    }
    public boolean onTouch(View v,MotionEvent event){
       int x = (int)(event.getX() / this.keyxx);
       int y = (int)(event.getY() / this.keyyy);
       switch (event.getAction()){
           case 0:
             this.pointerPressed(x, y);
             break;
           case 1:
             this.pointerReleased(x, y);
             break;
           case 2:
             this.pointerDragged(x, y);
             break;
       }
       return true;
    }
    protected abstract void paint(Graphics p0);
    protected void pointerDragged(int x,int y){
    }
    protected void pointerPressed(int x,int y){
    }
    protected void pointerReleased(int x,int y){
    }
    public final void repaint(){
       this.postInvalidate();
    }
    public final void repaint(int x,int y,int width,int height){
       this.postInvalidate(x, y, (x + width), (y + height));
    }
    public final void serviceRepaints(){
    }
    public void setFullScreenMode(boolean mode){
    }
    public void setScale(float x,float y){
       this.scale_x = x;
       this.scale_y = y;
       this.g.getXY(x, y);
    }
    public void showNotify(){
    }
}
