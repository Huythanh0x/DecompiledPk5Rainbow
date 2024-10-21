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

class Choose.2
implements View.OnClickListener {
    final Choose this$0;

    Choose.2(Choose choose) {
        this.this$0 = choose;
    }

    public void onClick(View view) {
        SMSSender.smsSender.setSmsValue(1);
        this.this$0.finishFromChild(this.this$0.getParent());
    }
}
