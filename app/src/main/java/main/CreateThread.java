package main.CreateThread;
import java.lang.Thread;
import main.GameRun;
import java.lang.Runnable;
import main.Map;
import java.lang.Exception;

public class CreateThread extends Thread	// class@000160 from classes.dex
{
    GameRun gr;

    public void CreateThread(GameRun gr_,int type){
       super();
       this.gr = gr_;
       this.gr.threadType = (byte)type;
       new Thread(this).start();
    }
    public void run(){
       int i = 1;
       try{
          if ((this.gr.createOver = 0) == null) {
             this.gr.map.initMap();
             this.gr.loadItem();
             this.gr.loadMon(0, this.gr.monster_pro);
             this.gr.loadMon(1, this.gr.monster_pro);
             this.gr.loadInfoList();
          }else if(this.gr.threadType == i){
             this.gr.initBattle();
          }else if(this.gr.threadType != 2 && (this.gr.threadType != 3 && this.gr.threadType != 4)){
             GameRun threadType = this.gr.threadType;
          }
          this.gr.createOver = -1;
       }catch(java.lang.Exception e1){
          Exception e = e1;
          e.printStackTrace();
       }
       return;
    }
}
