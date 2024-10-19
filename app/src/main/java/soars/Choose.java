package soars;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.PetKing5_480x800.PetKing5;
import com.PetKing5_480x800.R;
import main.GameRun;
import main.SMSSender;

/* loaded from: classes.dex */
public class Choose extends Activity {
    private Button btn = null;
    private Button btn2 = null;

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case 4:
                GameRun gameRun = PetKing5.gr;
                SMSSender.i(PetKing5.gr);
                gameRun.falselly(SMSSender.smsType);
                System.out.println("我的");
                finishFromChild(getParent());
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.btn = (Button) findViewById(R.id.button1);
        this.btn2 = (Button) findViewById(R.id.button2);
        this.btn.setOnClickListener(new View.OnClickListener() { // from class: soars.Choose.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SMSSender.smsSender.setSmsValue(0);
                Choose.this.finishFromChild(Choose.this.getParent());
            }
        });
        this.btn2.setOnClickListener(new View.OnClickListener() { // from class: soars.Choose.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SMSSender.smsSender.setSmsValue(1);
                Choose.this.finishFromChild(Choose.this.getParent());
            }
        });
    }

    /* renamed from: soars.Choose$1 */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            SMSSender.smsSender.setSmsValue(0);
            Choose.this.finishFromChild(Choose.this.getParent());
        }
    }

    /* renamed from: soars.Choose$2 */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            SMSSender.smsSender.setSmsValue(1);
            Choose.this.finishFromChild(Choose.this.getParent());
        }
    }
}
