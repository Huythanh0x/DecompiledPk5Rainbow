/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  com.PetKing5_480x800.PetKing5
 *  main.GameRun
 *  main.SMSSender
 */
package soars;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.PetKing5_480x800.PetKing5;
import main.GameRun;
import main.SMSSender;

public class Choose
extends Activity {
    private Button btn = null;
    private Button btn2 = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903040);
        this.btn = (Button)this.findViewById(2131099648);
        this.btn2 = (Button)this.findViewById(2131099649);
        this.btn.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.btn2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    /*
     * Enabled force condition propagation
     */
    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        switch (n) {
            default: {
                return super.onKeyDown(n, keyEvent);
            }
            case 4: 
        }
        keyEvent = PetKing5.gr;
        SMSSender.i((GameRun)PetKing5.gr);
        keyEvent.falselly((int)SMSSender.smsType);
        System.out.println("\u6211\u7684");
        this.finishFromChild(this.getParent());
        return true;
    }
}
