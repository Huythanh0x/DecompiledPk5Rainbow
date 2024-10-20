package javax.microedition.lcdui.CwaActivity;
import android.app.Activity;
import javax.microedition.midlet.MIDletManager;
import android.content.Context;
import dalvik.system.VMRuntime;
import android.view.Window;
import java.lang.String;
import java.lang.Object;
import android.app.ActivityManager;
import java.util.List;
import android.os.Process;
import java.util.Iterator;
import android.app.ActivityManager$RunningAppProcessInfo;
import android.view.KeyEvent;
import javax.microedition.lcdui.Canvas;
import android.content.res.Configuration;
import android.os.Bundle;
import android.media.AudioManager;
import java.lang.System;
import android.view.View;
import android.util.Log;
import javax.microedition.midlet.MIDlet;
import android.app.AlertDialog$Builder;
import java.lang.CharSequence;
import javax.microedition.lcdui.CwaActivity$1;
import android.content.DialogInterface$OnClickListener;
import javax.microedition.lcdui.CwaActivity$2;
import android.app.AlertDialog;

public class CwaActivity extends Activity	// class@00013f from classes.dex
{
    public AudioManager audioManager;
    private boolean isFullWindow;
    private MIDletManager jam;
    private static final String LOG_TAG = "CwaActivity";
    private static final int MIN_HEAP_SIZE = 12582912;
    private static final float TARGET_HEAP_UTILIZATION = 0.000000;
    private static Context context;
    private static Canvas curCanvas;
    private static CwaActivity cwaActivity;

    protected void CwaActivity(){
       super();
       this.jam = MIDletManager.getInstance();
       this.isFullWindow = false;
       if (CwaActivity.cwaActivity == null) {
          CwaActivity.cwaActivity = this;
       }
       return;
    }
    static MIDletManager access$0(CwaActivity p0){
       return p0.jam;
    }
    public static Context getContextInstance(){
       if (CwaActivity.context == null) {
          CwaActivity.context = CwaActivity.cwaActivity.getApplicationContext();
       }
       return CwaActivity.context;
    }
    public static CwaActivity getInstance(){
       return CwaActivity.cwaActivity;
    }
    private void initActivity(){
       VMRuntime.getRuntime().setMinimumHeapSize(0xc00000);
       VMRuntime.getRuntime().setTargetHeapUtilization(0.75f);
       this.getWindow().setFlags(128, 128);
    }
    private void killBackgroundProcess(){
       List apps = this.getSystemService("activity").getRunningAppProcesses();
       int mypid = Process.myPid();
       Iterator iterator = apps.iterator();
       while (iterator.hasNext()) {
          ActivityManager$RunningAppProcessInfo runningAppPr = iterator.next();
          if (runningAppPr.pid != mypid && runningAppPr.importance > 300) {
             Process.killProcess(runningAppPr.pid);
          }
       }
       return;
    }
    private void setFullScreen(){
       this.getWindow().setFlags(1024, 1024);
       this.requestWindowFeature(1);
    }
    public boolean dispatchKeyEvent(KeyEvent event){
       boolean b;
       switch (event.getKeyCode()){
           case 27:
           case 'P':
             b = true;
             break;
           default:
             b = super.dispatchKeyEvent(event);
       }
       return b;
    }
    public Canvas getCanvas(){
       return CwaActivity.curCanvas;
    }
    public void onConfigurationChanged(Configuration newConfig){
       super.onConfigurationChanged(newConfig);
    }
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       this.killBackgroundProcess();
       this.initActivity();
       this.audioManager = this.getSystemService("audio");
       if (this.isFullWindow != null) {
          this.setFullScreen();
       }
       return;
    }
    protected void onDestroy(){
       super.onDestroy();
       System.exit(0);
       Process.killProcess(Process.myPid());
    }
    public void onLowMemory(){
       this.killBackgroundProcess();
       super.onLowMemory();
    }
    protected void onPause(){
       super.onPause();
       this.jam.notifyPaused();
    }
    protected void onResume(){
       super.onResume();
       this.jam.notifyResumed();
    }
    public void setCanvas(Canvas canvas){
       CwaActivity.curCanvas = canvas;
    }
    public void setContentView(){
       if (CwaActivity.curCanvas != null) {
          CwaActivity.getInstance().setContentView(CwaActivity.curCanvas);
       }else {
          Log.e("CwaActivity", "current canvas is null");
       }
       return;
    }
    public void setFullWindow(boolean mode){
       this.isFullWindow = mode;
    }
    protected void setMIDlet(MIDlet midlet){
       this.jam.setMIDlet(midlet);
    }
    public void showExitDialog(){
       new AlertDialog$Builder(this).setMessage("\x78\x02\x8b\x02\x90\x02\x51\x02\xff\x02").setPositiveButton("\x66\x02", new CwaActivity$1(this)).setNegativeButton("\x54\x02", new CwaActivity$2(this)).show();
    }
}
