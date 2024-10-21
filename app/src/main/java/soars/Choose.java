package soars;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.PetKing5_480x800.PetKing5;
import main.GameRun;
import main.SMSSender;

public class Choose extends Activity {
  private Button btn = null;
  
  private Button btn2 = null;
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    this.btn = (Button)findViewById(2131099648);
    this.btn2 = (Button)findViewById(2131099649);
    this.btn.setOnClickListener(new View.OnClickListener() {
          final Choose this$0;
          
          public void onClick(View param1View) {
            SMSSender.smsSender.setSmsValue(0);
            Choose.this.finishFromChild(Choose.this.getParent());
          }
        });
    this.btn2.setOnClickListener(new View.OnClickListener() {
          final Choose this$0;
          
          public void onClick(View param1View) {
            SMSSender.smsSender.setSmsValue(1);
            Choose.this.finishFromChild(Choose.this.getParent());
          }
        });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    switch (paramInt) {
      default:
        return super.onKeyDown(paramInt, paramKeyEvent);
      case 4:
        break;
    } 
    GameRun gameRun = PetKing5.gr;
    SMSSender.i(PetKing5.gr);
    gameRun.falselly(SMSSender.smsType);
    System.out.println("我的");
    finishFromChild(getParent());
    return true;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/soars/Choose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */