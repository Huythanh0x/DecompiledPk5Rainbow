package com.uc.paymentsdk.commons.ui.CustomTextView;
import android.widget.TextView;
import android.content.Context;
import com.uc.paymentsdk.util.Utils;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import java.lang.String;
import android.graphics.Color;

public class CustomTextView extends TextView	// class@000091 from classes.dex
{

    public void CustomTextView(Context paramContext,int paramInt){
       int i = 0;
       super(paramContext);
       if (Utils.isHdpi()) {
          this.setMinHeight(80);
       }else {
          this.setMinHeight(53);
       }
       this.setGravity(16);
       this.setPadding(6, i, i, i);
       this.setTextAppearance(paramContext, 0x1030043);
       StateListDrawable localStateListDrawable = new StateListDrawable();
       localStateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, new ColorDrawable(-19456));
       if (1 != (paramInt % 2)) {
          localStateListDrawable.addState(View.ENABLED_STATE_SET, new ColorDrawable(Color.parseColor("#6AF9EA97")));
       }else {
          localStateListDrawable.addState(View.ENABLED_STATE_SET, new ColorDrawable(-1));
       }
       this.setBackgroundDrawable(localStateListDrawable);
       return;
    }
}
