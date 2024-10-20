package soars;

import main.SMSSender;
import android.view.View;
import android.view.View$OnClickListener;

class Choose$1 implements View$OnClickListener {
    final Choose this$0;
    
    Choose$1(final Choose this$0) {
        this.this$0 = this$0;
        super();
    }
    
    public void onClick(final View view) {
        SMSSender.smsSender.setSmsValue(0);
        this.this$0.finishFromChild(this.this$0.getParent());
    }
}