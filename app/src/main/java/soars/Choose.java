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
/**
 * The Choose class extends Activity and provides functionality for handling button clicks
 * and key events within the application.
 */
public class Choose extends Activity {
    private Button btn = null;
    private Button btn2 = null;
    /**
     * Handles key down events.
     *
     * @param keyCode the code of the key that was pressed
     * @param event the KeyEvent object containing full information about the event
     * @return true if the event was handled, false otherwise
     */
    @Override
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

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState if the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.btn = (Button) findViewById(R.id.button1);
        this.btn2 = (Button) findViewById(R.id.button2);
        this.btn.setOnClickListener(new View.OnClickListener() { // from class: soars.Choose.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SMSSender.smsSender.setSmsValue(0);
                Choose.this.finishFromChild(Choose.this.getParent());
            }
        });
        this.btn2.setOnClickListener(new View.OnClickListener() { // from class: soars.Choose.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SMSSender.smsSender.setSmsValue(1);
                Choose.this.finishFromChild(Choose.this.getParent());
            }
        });
    }
    /**
     * Inner class to handle click events for the first button.
     */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        /**
         * Handles click events for the first button.
         *
         * @param v the view that was clicked
         */
        @Override
        public void onClick(View v) {
            SMSSender.smsSender.setSmsValue(0);
            Choose.this.finishFromChild(Choose.this.getParent());
        }
    }

    /**
     * Inner class to handle click events for the second button.
     */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        /**
         * Handles click events for the second button.
         *
         * @param v the view that was clicked
         */
        @Override
        public void onClick(View v) {
            SMSSender.smsSender.setSmsValue(1);
            Choose.this.finishFromChild(Choose.this.getParent());
        }
    }
}
