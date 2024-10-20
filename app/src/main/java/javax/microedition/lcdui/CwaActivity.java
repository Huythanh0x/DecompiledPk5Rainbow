package javax.microedition.lcdui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.KeyEvent;
import dalvik.system.VMRuntime;
import java.util.Iterator;
import java.util.List;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletManager;

public class CwaActivity extends Activity {
  private static final String LOG_TAG = "CwaActivity";
  
  private static final int MIN_HEAP_SIZE = 12582912;
  
  private static final float TARGET_HEAP_UTILIZATION = 0.75F;
  
  private static Context context;
  
  private static Canvas curCanvas;
  
  private static CwaActivity cwaActivity;
  
  public AudioManager audioManager;
  
  private boolean isFullWindow = false;
  
  private MIDletManager jam = MIDletManager.getInstance();
  
  protected CwaActivity() {
    if (cwaActivity == null)
      cwaActivity = this; 
  }
  
  public static Context getContextInstance() {
    if (context == null)
      context = cwaActivity.getApplicationContext(); 
    return context;
  }
  
  public static CwaActivity getInstance() {
    return cwaActivity;
  }
  
  private void initActivity() {
    VMRuntime.getRuntime().setMinimumHeapSize(12582912L);
    VMRuntime.getRuntime().setTargetHeapUtilization(0.75F);
    getWindow().setFlags(128, 128);
  }
  
  private void killBackgroundProcess() {
    List list = ((ActivityManager)getSystemService("activity")).getRunningAppProcesses();
    int i = Process.myPid();
    Iterator<ActivityManager.RunningAppProcessInfo> iterator = list.iterator();
    while (true) {
      if (!iterator.hasNext())
        return; 
      ActivityManager.RunningAppProcessInfo runningAppProcessInfo = iterator.next();
      if (runningAppProcessInfo.pid != i && runningAppProcessInfo.importance > 300)
        Process.killProcess(runningAppProcessInfo.pid); 
    } 
  }
  
  private void setFullScreen() {
    getWindow().setFlags(1024, 1024);
    requestWindowFeature(1);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    switch (paramKeyEvent.getKeyCode()) {
      default:
        return super.dispatchKeyEvent(paramKeyEvent);
      case 27:
      case 80:
        break;
    } 
    return true;
  }
  
  public Canvas getCanvas() {
    return curCanvas;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    killBackgroundProcess();
    initActivity();
    this.audioManager = (AudioManager)getSystemService("audio");
    if (this.isFullWindow)
      setFullScreen(); 
  }
  
  protected void onDestroy() {
    super.onDestroy();
    System.exit(0);
    Process.killProcess(Process.myPid());
  }
  
  public void onLowMemory() {
    killBackgroundProcess();
    super.onLowMemory();
  }
  
  protected void onPause() {
    super.onPause();
    this.jam.notifyPaused();
  }
  
  protected void onResume() {
    super.onResume();
    this.jam.notifyResumed();
  }
  
  public void setCanvas(Canvas paramCanvas) {
    curCanvas = paramCanvas;
  }
  
  public void setContentView() {
    if (curCanvas != null) {
      getInstance().setContentView(curCanvas);
      return;
    } 
    Log.e("CwaActivity", "current canvas is null");
  }
  
  public void setFullWindow(boolean paramBoolean) {
    this.isFullWindow = paramBoolean;
  }
  
  protected void setMIDlet(MIDlet paramMIDlet) {
    this.jam.setMIDlet(paramMIDlet);
  }
  
  public void showExitDialog() {
    (new AlertDialog.Builder((Context)this)).setMessage("确认退出？").setPositiveButton("是", new DialogInterface.OnClickListener() {
          final CwaActivity this$0;
          
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (param1Int == -1) {
              CwaActivity.this.jam.notifyDestroyed();
              CwaActivity.this.jam.notifyExit();
            } 
          }
        }).setNegativeButton("否", new DialogInterface.OnClickListener() {
          final CwaActivity this$0;
          
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            param1DialogInterface.dismiss();
            CwaActivity.this.jam.notifyResumed();
          }
        }).show();
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/lcdui/CwaActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */