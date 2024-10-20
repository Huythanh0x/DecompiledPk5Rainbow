package main;

public class CreateThread extends Thread {
   GameRun gr;

   public CreateThread(GameRun var1, int var2) {
      super();
      this.gr = var1;
      this.gr.threadType = (byte)var2;
      (new Thread(this)).start();
   }

   public void run() {
      // $FF: Couldn't be decompiled
   }
}
