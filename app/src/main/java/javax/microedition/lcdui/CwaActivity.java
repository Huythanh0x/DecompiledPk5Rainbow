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
import com.uc.paymentsdk.util.Constants;
import dalvik.system.VMRuntime;
import java.util.List;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletManager;
import main.Constants_H;

/* loaded from: classes.dex */
public class CwaActivity extends Activity {
    private static final String LOG_TAG = "CwaActivity";
    private static final int MIN_HEAP_SIZE = 12582912;
    private static final float TARGET_HEAP_UTILIZATION = 0.75f;
    private static Context context;
    private static Canvas curCanvas;
    private static CwaActivity cwaActivity;
    public AudioManager audioManager;
    private MIDletManager jam = MIDletManager.getInstance();
    private boolean isFullWindow = false;

    public CwaActivity() {
        if (cwaActivity == null) {
            cwaActivity = this;
        }
    }

    private void killBackgroundProcess() {
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> apps = activityManager.getRunningAppProcesses();
        int mypid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : apps) {
            if (runningAppProcessInfo.pid != mypid && runningAppProcessInfo.importance > 300) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
    }

    public static CwaActivity getInstance() {
        return cwaActivity;
    }

    public static Context getContextInstance() {
        if (context == null) {
            context = cwaActivity.getApplicationContext();
        }
        return context;
    }

    public void setCanvas(Canvas canvas) {
        curCanvas = canvas;
    }

    public Canvas getCanvas() {
        return curCanvas;
    }

    private void setFullScreen() {
        getWindow().setFlags(GameCanvas.GAME_B_PRESSED, GameCanvas.GAME_B_PRESSED);
        requestWindowFeature(1);
    }

    private void initActivity() {
        VMRuntime.getRuntime().setMinimumHeapSize(12582912L);
        VMRuntime.getRuntime().setTargetHeapUtilization(TARGET_HEAP_UTILIZATION);
        getWindow().setFlags(128, 128);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        killBackgroundProcess();
        super.onLowMemory();
    }

    public void setFullWindow(boolean mode) {
        this.isFullWindow = mode;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        killBackgroundProcess();
        initActivity();
        this.audioManager = (AudioManager) getSystemService("audio");
        if (this.isFullWindow) {
            setFullScreen();
        }
    }

    public void setMIDlet(MIDlet midlet) {
        this.jam.setMIDlet(midlet);
    }

    public void setContentView() {
        if (curCanvas != null) {
            getInstance().setContentView(curCanvas);
        } else {
            Log.e(LOG_TAG, "current canvas is null");
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.jam.notifyPaused();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.jam.notifyResumed();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        System.exit(0);
        Process.killProcess(Process.myPid());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        switch (event.getKeyCode()) {
            case 27:
            case Constants.CUSTOM_TEXTVIEW_HEIGHT_HDPI /* 80 */:
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    public void showExitDialog() {
        new AlertDialog.Builder(this).setMessage("确认退出？").setPositiveButton(Constants_H.PAUSE_TXT_22, new DialogInterface.OnClickListener() { // from class: javax.microedition.lcdui.CwaActivity.1
            AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if (which == -1) {
                    CwaActivity.this.jam.notifyDestroyed();
                    CwaActivity.this.jam.notifyExit();
                }
            }
        }).setNegativeButton(Constants_H.PAUSE_TXT_23, new DialogInterface.OnClickListener() { // from class: javax.microedition.lcdui.CwaActivity.2
            AnonymousClass2() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                CwaActivity.this.jam.notifyResumed();
            }
        }).show();
    }

    /* renamed from: javax.microedition.lcdui.CwaActivity$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements DialogInterface.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            if (which == -1) {
                CwaActivity.this.jam.notifyDestroyed();
                CwaActivity.this.jam.notifyExit();
            }
        }
    }

    /* renamed from: javax.microedition.lcdui.CwaActivity$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements DialogInterface.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            CwaActivity.this.jam.notifyResumed();
        }
    }
}
