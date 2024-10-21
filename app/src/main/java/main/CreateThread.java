package main;

public class CreateThread extends Thread
{
    GameRun gr;
    
    public CreateThread(final GameRun gr, final int n) {
        super();
        this.gr = gr;
        this.gr.threadType = (byte)n;
        new Thread(this).start();
    }
    
    @Override
    public void run() {
        while (true) {
            while (true) {
                Label_0110: {
                    try {
                        this.gr.createOver = 0;
                        if (this.gr.threadType == 0) {
                            this.gr.map.initMap();
                            this.gr.loadItem();
                            this.gr.loadMon(0, this.gr.monster_pro);
                            this.gr.loadMon(1, this.gr.monster_pro);
                            this.gr.loadInfoList();
                        }
                        else {
                            if (this.gr.threadType != 1) {
                                break Label_0110;
                            }
                            this.gr.initBattle();
                        }
                        this.gr.createOver = -1;
                        return;
                    }
                    catch (final Exception ex) {
                        ex.printStackTrace();
                        return;
                    }
                }
                if (this.gr.threadType != 2 && this.gr.threadType != 3 && this.gr.threadType != 4) {
                    final byte threadType = this.gr.threadType;
                    continue;
                }
                continue;
            }
        }
    }
}
