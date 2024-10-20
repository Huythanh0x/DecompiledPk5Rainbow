package minigame;

import main.GameRun;

public class Mg {
    private MiniGame_H mg;
    private static Mg mgListener;
    public byte type;

    public Mg() {
        Mg.mgListener = this;
    }

    public void go(GameRun gr, int i, int mode, int lv) {
        GameRun.run_state = 69;
        this.setGame(gr, i);
        this.mg.go(mode, lv);
    }

    public static Mg i() {
        if(Mg.mgListener == null) {
            Mg.mgListener = new Mg();
        }
        return Mg.mgListener;
    }

    public void key(GameRun gr) {
        if(this.mg.key()) {
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

    private void setGame(GameRun gr, int i) {
        this.mg = null;
        this.type = (byte)i;
        switch(i) {
            case 0: {
                this.mg = new Racing(gr);
                return;
            }
            case 1: {
                this.mg = new Bearer(gr);
                return;
            }
            case 2: {
                this.mg = new Cards(gr);
                return;
            }
            case 3: {
                this.mg = new Guess(gr);
            }
        }
    }
}

