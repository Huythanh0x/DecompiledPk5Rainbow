package minigame;

import main.GameRun;

public class Mg
{
    private static Mg mgListener;
    private MiniGame_H mg;
    public byte type;
    
    public Mg() {
        super();
        Mg.mgListener = this;
    }
    
    public static Mg i() {
        if (Mg.mgListener == null) {
            Mg.mgListener = new Mg();
        }
        return Mg.mgListener;
    }
    
    private void setGame(final GameRun gameRun, final int n) {
        this.mg = null;
        this.type = (byte)n;
        switch (n) {
            case 0: {
                this.mg = new Racing(gameRun);
                break;
            }
            case 1: {
                this.mg = new Bearer(gameRun);
                break;
            }
            case 2: {
                this.mg = new Cards(gameRun);
                break;
            }
            case 3: {
                this.mg = new Guess(gameRun);
                break;
            }
        }
    }
    
    public void go(final GameRun gameRun, final int n, final int n2, final int n3) {
        GameRun.run_state = 69;
        this.setGame(gameRun, n);
        this.mg.go(n2, n3);
    }
    
    public void key(final GameRun gameRun) {
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
