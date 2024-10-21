package com.uc.paymentsdk.commons.ui;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;
import com.uc.paymentsdk.util.Constants;
import com.uc.paymentsdk.util.Utils;

/* loaded from: classes.dex */
public class CustomTextView extends TextView {
    public CustomTextView(Context paramContext, int paramInt) {
        super(paramContext);
        if (Utils.isHdpi()) {
            setMinHeight(80);
        } else {
            setMinHeight(53);
        }
        setGravity(16);
        setPadding(6, 0, 0, 0);
        setTextAppearance(paramContext, R.style.TextAppearance.Large.Inverse);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, new ColorDrawable(Constants.COLOR_PRESSED));
        if (1 != paramInt % 2) {
            localStateListDrawable.addState(View.ENABLED_STATE_SET, new ColorDrawable(Color.parseColor("#6AF9EA97")));
        } else {
            localStateListDrawable.addState(View.ENABLED_STATE_SET, new ColorDrawable(-1));
        }
        setBackgroundDrawable(localStateListDrawable);
    }
}
