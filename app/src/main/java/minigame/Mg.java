package minigame;

import main.GameRun;

/* loaded from: classes.dex */
public class Mg {
    private static Mg mgListener;
    private MiniGame_H mg;
    public byte type;

    public Mg() {
        mgListener = this;
    }

    public static Mg i() {
        if (mgListener == null) {
            mgListener = new Mg();
        }
        return mgListener;
    }

    private void setGame(GameRun gr, int i) {
        this.mg = null;
        this.type = (byte) i;
        switch (i) {
            case 0:
                this.mg = new Racing(gr);
                return;
            case 1:
                this.mg = new Bearer(gr);
                return;
            case 2:
                this.mg = new Cards(gr);
                return;
            case 3:
                this.mg = new Guess(gr);
                return;
            default:
                return;
        }
    }

    public void go(GameRun gr, int i, int mode, int lv) {
        GameRun.run_state = 69;
        setGame(gr, i);
        this.mg.go(mode, lv);
    }

    public void paint() {
        this.mg.patin();
    }

    public void run() {
        this.mg.run();
    }

    public void key(GameRun gr) {
        if (this.mg.key()) {
            GameRun.run_state = -10;
            this.mg = null;
        }
    }
}
