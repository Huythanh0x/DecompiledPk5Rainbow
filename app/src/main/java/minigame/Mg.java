package minigame;

import main.GameRun;

public class Mg {
   private static Mg mgListener;
   private MiniGame_H mg;
   public byte type;

   public Mg() {
      super();
      mgListener = this;
   }

   public static Mg i() {
      if (mgListener == null) {
         mgListener = new Mg();
      }

      return mgListener;
   }

   private void setGame(GameRun var1, int var2) {
      this.mg = null;
      this.type = (byte)var2;
      switch (var2) {
         case 0:
            this.mg = new Racing(var1);
            break;
         case 1:
            this.mg = new Bearer(var1);
            break;
         case 2:
            this.mg = new Cards(var1);
            break;
         case 3:
            this.mg = new Guess(var1);
      }

   }

   public void go(GameRun var1, int var2, int var3, int var4) {
      GameRun.run_state = 69;
      this.setGame(var1, var2);
      this.mg.go(var3, var4);
   }

   public void key(GameRun var1) {
      if (this.mg.key()) {
         GameRun.run_state = -10;
         this.mg = null;
      }

   }

   public void paint() {
      this.mg.patin();
   }

   public void run() {
      this.mg.run();
   }
}
