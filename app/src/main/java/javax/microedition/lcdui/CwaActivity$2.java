package javax.microedition.lcdui.CwaActivity$2;
import android.content.DialogInterface$OnClickListener;
import javax.microedition.lcdui.CwaActivity;
import java.lang.Object;
import android.content.DialogInterface;
import javax.microedition.midlet.MIDletManager;

class CwaActivity$2 implements DialogInterface$OnClickListener	// class@00013e from classes.dex
{
    final CwaActivity this$0;

    void CwaActivity$2(CwaActivity p0){
       this.this$0 = p0;
       super();
    }
    public void onClick(DialogInterface dialog,int which){
       dialog.dismiss();
       CwaActivity.access$0(this.this$0).notifyResumed();
    }
}
