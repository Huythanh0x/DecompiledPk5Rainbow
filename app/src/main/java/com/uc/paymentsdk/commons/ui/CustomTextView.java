/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 *  android.view.View
 *  android.widget.TextView
 *  com.uc.paymentsdk.util.Utils
 */
package com.uc.paymentsdk.commons.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;
import com.uc.paymentsdk.util.Utils;

public class CustomTextView
extends TextView {
    /*
     * Unable to fully structure code
     */
    public CustomTextView(Context var1_1, int var2_2) {
        super(var1_1);
        if (Utils.isHdpi()) {
            this.setMinHeight(80);
lbl4:
            // 2 sources

            while (true) {
                this.setGravity(16);
                this.setPadding(6, 0, 0, 0);
                this.setTextAppearance(var1_1, 16973891);
                var1_1 = new StateListDrawable();
                var1_1.addState(View.PRESSED_ENABLED_STATE_SET, (Drawable)new ColorDrawable(-19456));
                if (1 != var2_2 % 2) {
                    var1_1.addState(View.ENABLED_STATE_SET, (Drawable)new ColorDrawable(Color.parseColor((String)"#6AF9EA97")));
lbl12:
                    // 2 sources

                    while (true) {
                        this.setBackgroundDrawable((Drawable)var1_1);
                        return;
                    }
                }
                break;
            }
        } else {
            this.setMinHeight(53);
            ** continue;
        }
        var1_1.addState(View.ENABLED_STATE_SET, (Drawable)new ColorDrawable(-1));
        ** while (true)
    }
}
