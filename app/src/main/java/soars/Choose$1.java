package soars.Choose$1;
import android.view.View$OnClickListener;
import soars.Choose;
import java.lang.Object;
import android.view.View;
import main.SMSSender;
import android.app.Activity;

class Choose$1 implements View$OnClickListener	// class@0001a3 from classes.dex
{
    final Choose this$0;

    void Choose$1(Choose p0){
       this.this$0 = p0;
       super();
    }
    public void onClick(View v){
       SMSSender.smsSender.setSmsValue(0);
       this.this$0.finishFromChild(this.this$0.getParent());
    }
}
