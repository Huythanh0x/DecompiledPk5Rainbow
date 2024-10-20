/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.content.res.Configuration
 *  android.media.AudioManager
 *  android.os.Bundle
 *  android.os.Process
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.View
 *  dalvik.system.VMRuntime
 *  javax.microedition.lcdui.Canvas
 *  javax.microedition.midlet.MIDlet
 *  javax.microedition.midlet.MIDletManager
 */
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
import android.view.View;
import dalvik.system.VMRuntime;
import java.util.Iterator;
import java.util.List;
import javax.microedition.lcdui.Canvas;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletManager;

public class CwaActivity
extends Activity {
    private static final String LOG_TAG = "CwaActivity";
    private static final int MIN_HEAP_SIZE = 0xC00000;
    private static final float TARGET_HEAP_UTILIZATION = 0.75f;
    private static Context context;
    private static Canvas curCanvas;
    private static CwaActivity cwaActivity;
    public AudioManager audioManager;
    private boolean isFullWindow = false;
    private MIDletManager jam = MIDletManager.getInstance();

    protected CwaActivity() {
        if (cwaActivity == null) {
            cwaActivity = this;
        }
    }

    static /* synthetic */ MIDletManager access$0(CwaActivity cwaActivity) {
        return cwaActivity.jam;
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
        VMRuntime.getRuntime().setMinimumHeapSize(0xC00000L);
        VMRuntime.getRuntime().setTargetHeapUtilization(0.75f);
        this.getWindow().setFlags(128, 128);
    }

    private void killBackgroundProcess() {
        List list = ((ActivityManager)this.getSystemService("activity")).getRunningAppProcesses();
        int n = Process.myPid();
        Iterator<E> iterator = list.iterator();
        while (iterator.hasNext()) {
            list = (ActivityManager.RunningAppProcessInfo)iterator.next();
            if (((ActivityManager.RunningAppProcessInfo)list).pid == n || ((ActivityManager.RunningAppProcessInfo)list).importance <= 300) continue;
            Process.killProcess((int)((ActivityManager.RunningAppProcessInfo)list).pid);
        }
        return;
    }

    private void setFullScreen() {
        this.getWindow().setFlags(1024, 1024);
        this.requestWindowFeature(1);
    }

    /*
     * Enabled force condition propagation
     */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            default: {
                return super.dispatchKeyEvent(keyEvent);
            }
            case 27: 
            case 80: 
        }
        return true;
    }

    public Canvas getCanvas() {
        return curCanvas;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
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
        Process.killProcess((int)Process.myPid());
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

    public void setCanvas(Canvas canvas) {
        curCanvas = canvas;
    }

    /*
     * Enabled force condition propagation
     */
    public void setContentView() {
        if (curCanvas != null) {
            CwaActivity.getInstance().setContentView((View)curCanvas);
            return;
        }
        Log.e((String)LOG_TAG, (String)"current canvas is null");
    }

    public void setFullWindow(boolean bl) {
        this.isFullWindow = bl;
    }

    protected void setMIDlet(MIDlet mIDlet) {
        this.jam.setMIDlet(mIDlet);
    }

    public void showExitDialog() {
        new AlertDialog.Builder((Context)this).setMessage((CharSequence)"\u786e\u8ba4\u9000\u51fa\uff1f").setPositiveButton((CharSequence)"\u662f", (DialogInterface.OnClickListener)new /* Unavailable Anonymous Inner Class!! */).setNegativeButton((CharSequence)"\u5426", (DialogInterface.OnClickListener)new /* Unavailable Anonymous Inner Class!! */).show();
    }
}
