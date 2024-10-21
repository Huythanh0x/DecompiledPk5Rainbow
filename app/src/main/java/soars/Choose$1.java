/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  main.SMSSender
 *  soars.Choose
 */
package soars;

import android.view.View;
import main.SMSSender;
import soars.Choose;

class Choose.1
implements View.OnClickListener {
    final Choose this$0;

    Choose.1(Choose choose) {
        this.this$0 = choose;
    }

    public void onClick(View view) {
        SMSSender.smsSender.setSmsValue(0);
        this.this$0.finishFromChild(this.this$0.getParent());
    }
}
