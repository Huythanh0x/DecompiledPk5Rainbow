package com.uc.paymentsdk.commons.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;

public class CustomTextView extends TextView {
    public CustomTextView(Context paramContext, int paramInt) {
        super(paramContext);
        this.setMinHeight(53);
        this.setGravity(16);
        this.setPadding(6, 0, 0, 0);
        this.setTextAppearance(paramContext, 0x1030043);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, new ColorDrawable(0xFFFFB400));
        if(1 == paramInt % 2) {
            localStateListDrawable.addState(View.ENABLED_STATE_SET, new ColorDrawable(-1));
        }
        else {
            localStateListDrawable.addState(View.ENABLED_STATE_SET, new ColorDrawable(Color.parseColor("#6AF9EA97")));
        }
        this.setBackgroundDrawable(localStateListDrawable);
    }
}

