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
/**
 * CwaActivity is an Android Activity that manages the lifecycle and state of a custom canvas and MIDlet.
 * It provides methods to handle memory management, full-screen mode, and background process termination.
 * The activity also includes functionality to display an exit confirmation dialog.
 * 
 * <p>Key features include:</p>
 * <ul>
 *   <li>Singleton pattern to ensure a single instance of the activity.</li>
 *   <li>Methods to manage the custom canvas and MIDlet.</li>
 *   <li>Memory management through VMRuntime settings.</li>
 *   <li>Full-screen mode support.</li>
 *   <li>Background process termination to free up resources.</li>
 *   <li>Exit confirmation dialog with positive and negative actions.</li>
 * </ul>
 * 
 * <p>Usage:</p>
 * <pre>
 * {@code
 * CwaActivity activity = CwaActivity.getInstance();
 * activity.setCanvas(new CustomCanvas());
 * activity.setFullWindow(true);
 * activity.showExitDialog();
 * }
 * </pre>
 * 
 * <p>Note: This activity overrides several lifecycle methods to integrate custom behavior.</p>
 * 
 * @see android.app.Activity
 * @see android.content.Context
 * @see android.app.ActivityManager
 * @see android.os.Process
 * @see android.view.KeyEvent
 * @see android.app.AlertDialog
 */
/**
 * CwaActivity is an Android Activity that manages the lifecycle and UI of the application.
 * It includes methods for managing the canvas, handling memory, and interacting with the MIDletManager.
 * This class also provides functionality for setting full-screen mode and handling key events.
 */
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

    /**
     * Constructor for CwaActivity.
     * Initializes the singleton instance of CwaActivity.
     */
    public CwaActivity() {
        if (cwaActivity == null) {
            cwaActivity = this;
        }
    }

    /**
     * Kills background processes that are not essential and have a lower importance.
     */
    private void killBackgroundProcess() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> apps = activityManager.getRunningAppProcesses();
        int mypid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : apps) {
            if (runningAppProcessInfo.pid != mypid && runningAppProcessInfo.importance > 300) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
    }

    /**
     * Returns the singleton instance of CwaActivity.
     * 
     * @return the singleton instance of CwaActivity
     */
    public static CwaActivity getInstance() {
        return cwaActivity;
    }

    /**
     * Returns the application context.
     * 
     * @return the application context
     */
    public static Context getContextInstance() {
        if (context == null) {
            context = cwaActivity.getApplicationContext();
        }
        return context;
    }

    /**
     * Sets the current canvas.
     * 
     * @param canvas the canvas to set
     */
    public void setCanvas(Canvas canvas) {
        curCanvas = canvas;
    }

    /**
     * Returns the current canvas.
     * 
     * @return the current canvas
     */
    public Canvas getCanvas() {
        return curCanvas;
    }

    /**
     * Sets the activity to full-screen mode.
     */
    private void setFullScreen() {
        getWindow().setFlags(GameCanvas.GAME_B_PRESSED, GameCanvas.GAME_B_PRESSED);
        requestWindowFeature(1);
    }

    /**
     * Initializes the activity by setting heap size and other configurations.
     */
    private void initActivity() {
        VMRuntime.getRuntime().setMinimumHeapSize(12582912L);
        VMRuntime.getRuntime().setTargetHeapUtilization(TARGET_HEAP_UTILIZATION);
        getWindow().setFlags(128, 128);
    }

    /**
     * Called when the system is running low on memory.
     * Kills background processes and calls the superclass method.
     */
    @Override
    public void onLowMemory() {
        killBackgroundProcess();
        super.onLowMemory();
    }

    /**
     * Sets the full window mode.
     * 
     * @param mode true to enable full window mode, false otherwise
     */
    public void setFullWindow(boolean mode) {
        this.isFullWindow = mode;
    }

    /**
     * Called when the device configuration changes.
     * 
     * @param newConfig the new device configuration
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    /**
     * Called when the activity is created.
     * Initializes the activity and sets up the audio manager.
     * 
     * @param savedInstanceState the saved instance state
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        killBackgroundProcess();
        initActivity();
        this.audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (this.isFullWindow) {
            setFullScreen();
        }
    }

    /**
     * Sets the MIDlet for the MIDletManager.
     * 
     * @param midlet the MIDlet to set
     */
    public void setMIDlet(MIDlet midlet) {
        this.jam.setMIDlet(midlet);
    }

    /**
     * Sets the content view to the current canvas.
     * Logs an error if the current canvas is null.
     */
    public void setContentView() {
        if (curCanvas != null) {
            getInstance().setContentView(curCanvas);
        } else {
            Log.e(LOG_TAG, "current canvas is null");
        }
    }

    /**
     * Called when the activity is paused.
     * Notifies the MIDletManager that the activity is paused.
     */
    @Override
    protected void onPause() {
        super.onPause();
        this.jam.notifyPaused();
    }

    /**
     * Called when the activity is resumed.
     * Notifies the MIDletManager that the activity is resumed.
     */
    @Override
    protected void onResume() {
        super.onResume();
        this.jam.notifyResumed();
    }

    /**
     * Called when the activity is destroyed.
     * Exits the system and kills the process.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        System.exit(0);
        Process.killProcess(Process.myPid());
    }

    /**
     * Dispatches key events to the activity.
     * 
     * @param event the key event
     * @return true if the event was handled, false otherwise
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        switch (event.getKeyCode()) {
            case 27:
            case Constants.CUSTOM_TEXTVIEW_HEIGHT_HDPI /* 80 */:
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    /**
     * Shows an exit confirmation dialog.
     */
    public void showExitDialog() {
        new AlertDialog.Builder((Context)this).setMessage("确认退出？").setPositiveButton("是", (DialogInterface.OnClickListener)new CwaActivity()).setNegativeButton("否", (DialogInterface.OnClickListener)new CwaActivity()).show();
    }

    /**
     * DialogInterface.OnClickListener implementation for handling positive button clicks in the exit dialog.
     */
    public class AnonymousClass1 implements DialogInterface.OnClickListener {
        AnonymousClass1() {
        }

        /**
         * Handles the click event for the positive button in the exit dialog.
         * 
         * @param dialog the dialog that received the click
         * @param which the button that was clicked
         */
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == -1) {
                CwaActivity.this.jam.notifyDestroyed();
                CwaActivity.this.jam.notifyExit();
            }
        }
    }

    /**
     * DialogInterface.OnClickListener implementation for handling negative button clicks in the exit dialog.
     */
    public class AnonymousClass2 implements DialogInterface.OnClickListener {
        AnonymousClass2() {
        }

        /**
         * Handles the click event for the negative button in the exit dialog.
         * 
         * @param dialog the dialog that received the click
         * @param which the button that was clicked
         */
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            CwaActivity.this.jam.notifyResumed();
        }
    }
}
