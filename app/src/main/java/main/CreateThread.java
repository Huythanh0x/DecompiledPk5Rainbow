package main;

public class CreateThread extends Thread {
  GameRun gr;
  
  public CreateThread(GameRun paramGameRun, int paramInt) {
    this.gr = paramGameRun;
    this.gr.threadType = (byte)paramInt;
    (new Thread(this)).start();
  }
  
  public void run() {
    try {
      this.gr.createOver = 0;
      if (this.gr.threadType == 0) {
        this.gr.map.initMap();
        this.gr.loadItem();
        this.gr.loadMon(0, this.gr.monster_pro);
        this.gr.loadMon(1, this.gr.monster_pro);
        this.gr.loadInfoList();
      } else if (this.gr.threadType == 1) {
        this.gr.initBattle();
      } else if (this.gr.threadType != 2 && this.gr.threadType != 3 && this.gr.threadType != 4) {
        byte b = this.gr.threadType;
      } 
      this.gr.createOver = -1;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/main/CreateThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */