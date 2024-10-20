package minigame;

import main.GameRun;

public class Mg {
  private static Mg mgListener;
  
  private MiniGame_H mg;
  
  public byte type;
  
  public Mg() {
    mgListener = this;
  }
  
  public static Mg i() {
    if (mgListener == null)
      mgListener = new Mg(); 
    return mgListener;
  }
  
  private void setGame(GameRun paramGameRun, int paramInt) {
    this.mg = null;
    this.type = (byte)paramInt;
    switch (paramInt) {
      default:
        return;
      case 0:
        this.mg = new Racing(paramGameRun);
      case 1:
        this.mg = new Bearer(paramGameRun);
      case 2:
        this.mg = new Cards(paramGameRun);
      case 3:
        break;
    } 
    this.mg = new Guess(paramGameRun);
  }
  
  public void go(GameRun paramGameRun, int paramInt1, int paramInt2, int paramInt3) {
    GameRun.run_state = 69;
    setGame(paramGameRun, paramInt1);
    this.mg.go(paramInt2, paramInt3);
  }
  
  public void key(GameRun paramGameRun) {
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


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/minigame/Mg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */