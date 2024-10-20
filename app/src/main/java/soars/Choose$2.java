package soars;

import android.view.View;
import main.SMSSender;

class Choose$2 implements View.OnClickListener {
   final Choose this$0;

   Choose$2(Choose var1) {
      super();
      this.this$0 = var1;
   }

   public void onClick(View var1) {
      SMSSender.smsSender.setSmsValue(1);
      this.this$0.finishFromChild(this.this$0.getParent());
   }
}
