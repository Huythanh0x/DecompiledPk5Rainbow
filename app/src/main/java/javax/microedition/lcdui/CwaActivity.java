package javax.microedition.lcdui;

import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import javax.microedition.midlet.MIDlet;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.content.res.Configuration;
import android.view.KeyEvent;
import java.util.Iterator;
import java.util.List;
import android.app.ActivityManager$RunningAppProcessInfo;
import android.os.Process;
import android.app.ActivityManager;
import dalvik.system.VMRuntime;
import javax.microedition.midlet.MIDletManager;
import android.media.AudioManager;
import android.content.Context;
import android.app.Activity;

public class CwaActivity extends Activity
{
    private static final String LOG_TAG = "CwaActivity";
    private static final int MIN_HEAP_SIZE = 12582912;
    private static final float TARGET_HEAP_UTILIZATION = 0.75f;
    private static Context context;
    private static Canvas curCanvas;
    private static CwaActivity cwaActivity;
    public AudioManager audioManager;
    private boolean isFullWindow;
    private MIDletManager jam;
    
    protected CwaActivity() {
        super();
        this.jam = MIDletManager.getInstance();
        this.isFullWindow = false;
        if (CwaActivity.cwaActivity == null) {
            CwaActivity.cwaActivity = this;
        }
    }
    
    static /* synthetic */ MIDletManager access$0(final CwaActivity cwaActivity) {
        return cwaActivity.jam;
    }
    
    public static Context getContextInstance() {
        if (CwaActivity.context == null) {
            CwaActivity.context = CwaActivity.cwaActivity.getApplicationContext();
        }
        return CwaActivity.context;
    }
    
    public static CwaActivity getInstance() {
        return CwaActivity.cwaActivity;
    }
    
    private void initActivity() {
        VMRuntime.getRuntime().setMinimumHeapSize(12582912L);
        VMRuntime.getRuntime().setTargetHeapUtilization(0.75f);
        this.getWindow().setFlags(128, 128);
    }
    
    private void killBackgroundProcess() {
        final List runningAppProcesses = ((ActivityManager)this.getSystemService("activity")).getRunningAppProcesses();
        final int myPid = Process.myPid();
        for (final ActivityManager$RunningAppProcessInfo activityManager$RunningAppProcessInfo : runningAppProcesses) {
            if (activityManager$RunningAppProcessInfo.pid != myPid && activityManager$RunningAppProcessInfo.importance > 300) {
                Process.killProcess(activityManager$RunningAppProcessInfo.pid);
            }
        }
    }
    
    private void setFullScreen() {
        this.getWindow().setFlags(1024, 1024);
        this.requestWindowFeature(1);
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        boolean dispatchKeyEvent = false;
        switch (keyEvent.getKeyCode()) {
            default: {
                dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
                break;
            }
            case 27:
            case 80: {
                dispatchKeyEvent = true;
                break;
            }
        }
        return dispatchKeyEvent;
    }
    
    public Canvas getCanvas() {
        return CwaActivity.curCanvas;
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
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
    
    public void setCanvas(final Canvas curCanvas) {
        CwaActivity.curCanvas = curCanvas;
    }
    
    public void setContentView() {
        if (CwaActivity.curCanvas != null) {
            getInstance().setContentView((View)CwaActivity.curCanvas);
        }
        else {
            Log.e("CwaActivity", "current canvas is null");
        }
    }
    
    public void setFullWindow(final boolean isFullWindow) {
        this.isFullWindow = isFullWindow;
    }
    
    protected void setMIDlet(final MIDlet miDlet) {
        this.jam.setMIDlet(miDlet);
    }
    
    public void showExitDialog() {
        new AlertDialog$Builder((Context)this).setMessage((CharSequence)"\u786e\u8ba4\u9000\u51fa\uff1f").setPositiveButton((CharSequence)"\u662f", (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(this) {
            final CwaActivity this$0;
            
            CwaActivity$1(final CwaActivity this$0) {
                this.this$0 = this$0;
                super();
            }
            
            public void onClick(final DialogInterface dialogInterface, final int n) {
                if (n == -1) {
                    jam.notifyDestroyed();
                    jam.notifyExit();
                }
            }
        }).setNegativeButton((CharSequence)"\u5426", (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(this) {
            final CwaActivity this$0;
            
            CwaActivity$2(final CwaActivity this$0) {
                this.this$0 = this$0;
                super();
            }
            
            public void onClick(final DialogInterface dialogInterface, final int n) {
                dialogInterface.dismiss();
                jam.notifyResumed();
            }
        }).show();
    }
}
