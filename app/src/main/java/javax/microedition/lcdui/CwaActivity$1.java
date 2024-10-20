package javax.microedition.lcdui.CwaActivity$1;
import android.content.DialogInterface$OnClickListener;
import javax.microedition.lcdui.CwaActivity;
import java.lang.Object;
import android.content.DialogInterface;
import javax.microedition.midlet.MIDletManager;

class CwaActivity$1 implements DialogInterface$OnClickListener	// class@00013d from classes.dex
{
    final CwaActivity this$0;

    void CwaActivity$1(CwaActivity p0){
       this.this$0 = p0;
       super();
    }
    public void onClick(DialogInterface dialog,int which){
       if (which == -1) {
          CwaActivity.access$0(this.this$0).notifyDestroyed();
          CwaActivity.access$0(this.this$0).notifyExit();
       }
       return;
    }
}
