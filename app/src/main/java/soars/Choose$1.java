package soars;

import android.view.View;
import main.SMSSender;

class Choose$1 implements View.OnClickListener {
   final Choose this$0;

   Choose$1(Choose var1) {
      super();
      this.this$0 = var1;
   }

   public void onClick(View var1) {
      SMSSender.smsSender.setSmsValue(0);
      this.this$0.finishFromChild(this.this$0.getParent());
   }
}
