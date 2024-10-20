package com.uc.paymentsdk.commons.ui;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.graphics.drawable.StateListDrawable;
import com.uc.paymentsdk.util.Utils;
import android.content.Context;
import android.widget.TextView;

public class CustomTextView extends TextView
{
    public CustomTextView(final Context context, final int n) {
        super(context);
        if (Utils.isHdpi()) {
            this.setMinHeight(80);
        }
        else {
            this.setMinHeight(53);
        }
        this.setGravity(16);
        this.setPadding(6, 0, 0, 0);
        this.setTextAppearance(context, 16973891);
        final StateListDrawable backgroundDrawable = new StateListDrawable();
        backgroundDrawable.addState(View.PRESSED_ENABLED_STATE_SET, (Drawable)new ColorDrawable(-19456));
        if (1 != n % 2) {
            backgroundDrawable.addState(View.ENABLED_STATE_SET, (Drawable)new ColorDrawable(Color.parseColor("#6AF9EA97")));
        }
        else {
            backgroundDrawable.addState(View.ENABLED_STATE_SET, (Drawable)new ColorDrawable(-1));
        }
        this.setBackgroundDrawable((Drawable)backgroundDrawable);
    }
}
