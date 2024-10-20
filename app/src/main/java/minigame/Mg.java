package minigame.Mg;
import java.lang.Object;
import main.GameRun;
import minigame.Racing;
import minigame.Bearer;
import minigame.Cards;
import minigame.Guess;
import minigame.MiniGame_H;

public class Mg	// class@00016d from classes.dex
{
    private MiniGame_H mg;
    public byte type;
    private static Mg mgListener;

    public void Mg(){
       super();
       Mg.mgListener = this;
    }
    public static Mg i(){
       if (Mg.mgListener == null) {
          Mg.mgListener = new Mg();
       }
       return Mg.mgListener;
    }
    private void setGame(GameRun gr,int i){
       this.mg = null;
       this.type = (byte)i;
       switch (i){
           case 0:
             this.mg = new Racing(gr);
             break;
           case 1:
             this.mg = new Bearer(gr);
             break;
           case 2:
             this.mg = new Cards(gr);
             break;
           case 3:
             this.mg = new Guess(gr);
             break;
       }
       return;
    }
    public void go(GameRun gr,int i,int mode,int lv){
       GameRun.run_state = 69;
       this.setGame(gr, i);
       this.mg.go(mode, lv);
    }
    public void key(GameRun gr){
       if (this.mg.key()) {
          GameRun.run_state = -10;
          this.mg = null;
       }
       return;
    }
    public void paint(){
       this.mg.patin();
    }
    public void run(){
       this.mg.run();
    }
}
