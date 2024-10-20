package soars;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import com.PetKing5_480x800.PetKing5;
import main.GameRun;
import main.SMSSender;

public class Choose extends Activity {
    private Button btn;
    private Button btn2;

    public Choose() {
        this.btn = null;
        this.btn2 = null;
    }

    @Override  // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(0x7F030000);  // layout:main
        this.btn = (Button)this.findViewById(0x7F060000);  // id:button1
        this.btn2 = (Button)this.findViewById(0x7F060001);  // id:button2
        this.btn.setOnClickListener(new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View v) {
                Activity activity0 = Choose.this.getParent();
                Choose.this.finishFromChild(activity0);
            }
        });
        this.btn2.setOnClickListener(new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View v) {
                Activity activity0 = Choose.this.getParent();
                Choose.this.finishFromChild(activity0);
            }
        });
    }

    @Override  // android.app.Activity
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode != 4) {
            return super.onKeyDown(keyCode, event);
        }
        GameRun gameRun0 = PetKing5.gr;
        SMSSender.i(PetKing5.gr);
        gameRun0.falselly(((int)SMSSender.smsType));
        System.out.println("我的");
        this.finishFromChild(this.getParent());
        return true;
    }
}

