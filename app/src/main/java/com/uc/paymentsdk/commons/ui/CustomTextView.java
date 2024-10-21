package com.uc.paymentsdk.commons.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;
import com.uc.paymentsdk.util.Utils;

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
    setTextAppearance(paramContext, 16973891);
    StateListDrawable stateListDrawable = new StateListDrawable();
    stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, (Drawable)new ColorDrawable(-19456));
    if (1 != paramInt % 2) {
      stateListDrawable.addState(View.ENABLED_STATE_SET, (Drawable)new ColorDrawable(Color.parseColor("#6AF9EA97")));
    } else {
      stateListDrawable.addState(View.ENABLED_STATE_SET, (Drawable)new ColorDrawable(-1));
    } 
    setBackgroundDrawable((Drawable)stateListDrawable);
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/commons/ui/CustomTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */