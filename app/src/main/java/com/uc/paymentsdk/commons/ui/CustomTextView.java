package com.uc.paymentsdk.commons.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;
import com.uc.paymentsdk.util.Utils;

public class CustomTextView extends TextView {
   public CustomTextView(Context var1, int var2) {
      super(var1);
      if (Utils.isHdpi()) {
         this.setMinHeight(80);
      } else {
         this.setMinHeight(53);
      }

      this.setGravity(16);
      this.setPadding(6, 0, 0, 0);
      this.setTextAppearance(var1, 16973891);
      StateListDrawable var3 = new StateListDrawable();
      var3.addState(View.PRESSED_ENABLED_STATE_SET, new ColorDrawable(-19456));
      if (1 != var2 % 2) {
         var3.addState(View.ENABLED_STATE_SET, new ColorDrawable(Color.parseColor("#6AF9EA97")));
      } else {
         var3.addState(View.ENABLED_STATE_SET, new ColorDrawable(-1));
      }

      this.setBackgroundDrawable(var3);
   }
}
