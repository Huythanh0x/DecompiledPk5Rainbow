package soars.Choose$2;
import android.view.View$OnClickListener;
import soars.Choose;
import java.lang.Object;
import android.view.View;
import main.SMSSender;
import android.app.Activity;

class Choose$2 implements View$OnClickListener	// class@0001a4 from classes.dex
{
    final Choose this$0;

    void Choose$2(Choose p0){
       this.this$0 = p0;
       super();
    }
    public void onClick(View v){
       SMSSender.smsSender.setSmsValue(1);
       this.this$0.finishFromChild(this.this$0.getParent());
    }
}
