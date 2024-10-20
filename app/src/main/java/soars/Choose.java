package soars;

import main.GameRun;
import com.PetKing5_480x800.PetKing5;
import android.view.KeyEvent;
import main.SMSSender;
import android.view.View;
import android.view.View$OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;

public class Choose extends Activity
{
    private Button btn;
    private Button btn2;
    
    public Choose() {
        super();
        this.btn = null;
        this.btn2 = null;
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903040);
        this.btn = (Button)this.findViewById(2131099648);
        this.btn2 = (Button)this.findViewById(2131099649);
        this.btn.setOnClickListener((View$OnClickListener)new View$OnClickListener(this) {
            final Choose this$0;
            
            Choose$1(final Choose this$0) {
                this.this$0 = this$0;
                super();
            }
            
            public void onClick(final View view) {
                SMSSender.smsSender.setSmsValue(0);
                this.this$0.finishFromChild(this.this$0.getParent());
            }
        });
        this.btn2.setOnClickListener((View$OnClickListener)new View$OnClickListener(this) {
            final Choose this$0;
            
            Choose$2(final Choose this$0) {
                this.this$0 = this$0;
                super();
            }
            
            public void onClick(final View view) {
                SMSSender.smsSender.setSmsValue(1);
                this.this$0.finishFromChild(this.this$0.getParent());
            }
        });
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        boolean onKeyDown = false;
        switch (n) {
            default: {
                onKeyDown = super.onKeyDown(n, keyEvent);
                break;
            }
            case 4: {
                final GameRun gr = PetKing5.gr;
                SMSSender.i(PetKing5.gr);
                gr.falselly(SMSSender.smsType);
                System.out.println("\u6211\u7684");
                this.finishFromChild(this.getParent());
                onKeyDown = true;
                break;
            }
        }
        return onKeyDown;
    }
}
