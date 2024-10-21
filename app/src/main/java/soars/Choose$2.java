package soars;

import main.SMSSender;
import android.view.View;
import android.view.View$OnClickListener;

class Choose$2 implements View$OnClickListener {
    final Choose this$0;
    
    Choose$2(final Choose this$0) {
        this.this$0 = this$0;
        super();
    }
    
    public void onClick(final View view) {
        SMSSender.smsSender.setSmsValue(1);
        this.this$0.finishFromChild(this.this$0.getParent());
    }
}