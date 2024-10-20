package soars;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import com.PetKing5_480x800.PetKing5;
import main.GameRun;
import main.SMSSender;

public class Choose extends Activity {
   private Button btn = null;
   private Button btn2 = null;

   public Choose() {
      super();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130903040);
      this.btn = (Button)this.findViewById(2131099648);
      this.btn2 = (Button)this.findViewById(2131099649);
      this.btn.setOnClickListener(new Choose$1(this));
      this.btn2.setOnClickListener(new Choose$2(this));
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      boolean var3;
      switch (var1) {
         case 4:
            GameRun var4 = PetKing5.gr;
            SMSSender.i(PetKing5.gr);
            var4.falselly(SMSSender.smsType);
            System.out.println("\u6211\u7684");
            this.finishFromChild(this.getParent());
            var3 = true;
            break;
         default:
            var3 = super.onKeyDown(var1, var2);
      }

      return var3;
   }
}
