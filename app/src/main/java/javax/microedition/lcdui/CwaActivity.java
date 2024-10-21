package javax.microedition.lcdui;

import android.app.Activity;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.KeyEvent;
import dalvik.system.VMRuntime;
import java.util.List;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletManager;

public class CwaActivity extends Activity {
    private static final String LOG_TAG = "CwaActivity";
    private static final int MIN_HEAP_SIZE = 0xC00000;
    private static final float TARGET_HEAP_UTILIZATION = 0.75f;
    public AudioManager audioManager;
    private static Context context;
    private static Canvas curCanvas;
    private static CwaActivity cwaActivity;
    private boolean isFullWindow;
    private MIDletManager jam;

    protected CwaActivity() {
        this.jam = MIDletManager.getInstance();
        this.isFullWindow = false;
        if(CwaActivity.cwaActivity == null) {
            CwaActivity.cwaActivity = this;
        }
    }

    @Override  // android.app.Activity
    public boolean dispatchKeyEvent(KeyEvent event) {
        switch(event.getKeyCode()) {
            case 27: 
            case 80: {
                return true;
            }
            default: {
                return super.dispatchKeyEvent(event);
            }
        }
    }

    public Canvas getCanvas() {
        return CwaActivity.curCanvas;
    }

    public static Context getContextInstance() {
        if(CwaActivity.context == null) {
            CwaActivity.context = CwaActivity.cwaActivity.getApplicationContext();
        }
        return CwaActivity.context;
    }

    public static CwaActivity getInstance() {
        return CwaActivity.cwaActivity;
    }

    private void initActivity() {
        VMRuntime.getRuntime().setMinimumHeapSize(0xC00000L);
        VMRuntime.getRuntime().setTargetHeapUtilization(0.75f);
        this.getWindow().setFlags(0x80, 0x80);
    }

    private void killBackgroundProcess() {
        List list0 = ((ActivityManager)this.getSystemService("activity")).getRunningAppProcesses();
        int v = Process.myPid();
        for(Object object0: list0) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)object0;
            if(runningAppProcessInfo.pid != v && runningAppProcessInfo.importance > 300) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
    }

    @Override  // android.app.Activity
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override  // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.killBackgroundProcess();
        this.initActivity();
        this.audioManager = (AudioManager)this.getSystemService("audio");
        if(this.isFullWindow) {
            this.setFullScreen();
        }
    }

    @Override  // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
        Process.killProcess(Process.myPid());
    }

    @Override  // android.app.Activity
    public void onLowMemory() {
        this.killBackgroundProcess();
        super.onLowMemory();
    }

    @Override  // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.jam.notifyPaused();
    }

    @Override  // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.jam.notifyResumed();
    }

    public void setCanvas(Canvas canvas) {
        CwaActivity.curCanvas = canvas;
    }

    public void setContentView() {
        if(CwaActivity.curCanvas != null) {
            CwaActivity.getInstance().setContentView(CwaActivity.curCanvas);
            return;
        }
        Log.e("CwaActivity", "current canvas is null");
    }

    private void setFullScreen() {
        this.getWindow().setFlags(0x400, 0x400);
        this.requestWindowFeature(1);
    }

    public void setFullWindow(boolean mode) {
        this.isFullWindow = mode;
    }

    protected void setMIDlet(MIDlet midlet) {
        this.jam.setMIDlet(midlet);
    }

    public void showExitDialog() {
        new AlertDialog.Builder(this).setMessage("确认退出？").setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override  // android.content.DialogInterface$OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if(which == -1) {
                    CwaActivity.this.jam.notifyDestroyed();
                    CwaActivity.this.jam.notifyExit();
                }
            }
        }).setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override  // android.content.DialogInterface$OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                CwaActivity.this.jam.notifyResumed();
            }
        }).show();
    }
}

