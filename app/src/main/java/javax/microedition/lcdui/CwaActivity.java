package javax.microedition.lcdui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
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
      super();
      if (cwaActivity == null) {
         cwaActivity = this;
      }

   }

   // $FF: synthetic method
   static MIDletManager access$0(CwaActivity var0) {
      return var0.jam;
   }

   public static Context getContextInstance() {
      if (context == null) {
         context = cwaActivity.getApplicationContext();
      }

      return context;
   }

   public static CwaActivity getInstance() {
      return cwaActivity;
   }

   private void initActivity() {
      VMRuntime.getRuntime().setMinimumHeapSize(12582912L);
      VMRuntime.getRuntime().setTargetHeapUtilization(0.75F);
      this.getWindow().setFlags(128, 128);
   }

   private void killBackgroundProcess() {
      List var2 = ((ActivityManager)this.getSystemService("activity")).getRunningAppProcesses();
      int var1 = Process.myPid();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         ActivityManager.RunningAppProcessInfo var4 = (ActivityManager.RunningAppProcessInfo)var3.next();
         if (var4.pid != var1 && var4.importance > 300) {
            Process.killProcess(var4.pid);
         }
      }

   }

   private void setFullScreen() {
      this.getWindow().setFlags(1024, 1024);
      this.requestWindowFeature(1);
   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      boolean var2;
      switch (var1.getKeyCode()) {
         case 27:
         case 80:
            var2 = true;
            break;
         default:
            var2 = super.dispatchKeyEvent(var1);
      }

      return var2;
   }

   public Canvas getCanvas() {
      return curCanvas;
   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.killBackgroundProcess();
      this.initActivity();
      this.audioManager = (AudioManager)this.getSystemService("audio");
      if (this.isFullWindow) {
         this.setFullScreen();
      }

   }

   protected void onDestroy() {
      super.onDestroy();
      System.exit(0);
      Process.killProcess(Process.myPid());
   }

   public void onLowMemory() {
      this.killBackgroundProcess();
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

   public void setCanvas(Canvas var1) {
      curCanvas = var1;
   }

   public void setContentView() {
      if (curCanvas != null) {
         getInstance().setContentView(curCanvas);
      } else {
         Log.e("CwaActivity", "current canvas is null");
      }

   }

   public void setFullWindow(boolean var1) {
      this.isFullWindow = var1;
   }

   protected void setMIDlet(MIDlet var1) {
      this.jam.setMIDlet(var1);
   }

   public void showExitDialog() {
      (new AlertDialog.Builder(this)).setMessage("\u786e\u8ba4\u9000\u51fa\uff1f").setPositiveButton("\u662f", new CwaActivity$1(this)).setNegativeButton("\u5426", new CwaActivity$2(this)).show();
   }
}
