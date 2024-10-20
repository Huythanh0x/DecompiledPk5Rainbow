package minigame;

import main.GameRun;

/* loaded from: classes.dex */
/**
 * The Mg class is a singleton that manages different types of mini-games.
 * It provides methods to initialize, run, and manage the state of the mini-games.
 */
public class Mg {
    private static Mg mgListener;
    private MiniGame_H mg;
    public byte type;

    /**
     * Constructor for the Mg class.
     * Initializes the singleton instance.
     */
    public Mg() {
        mgListener = this;
    }

    /**
     * Returns the singleton instance of the Mg class.
     * If the instance is null, it creates a new instance.
     *
     * @return the singleton instance of Mg
     */
    public static Mg i() {
        if (mgListener == null) {
            mgListener = new Mg();
        }
        return mgListener;
    }

    /**
     * Sets the current mini-game based on the provided type.
     *
     * @param gr the GameRun instance
     * @param i  the type of mini-game to set
     */
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

    /**
     * Initializes and starts the mini-game.
     *
     * @param gr   the GameRun instance
     * @param i    the type of mini-game to start
     * @param mode the mode of the mini-game
     * @param lv   the level of the mini-game
     */
    public void go(GameRun gr, int i, int mode, int lv) {
        GameRun.run_state = 69;
        setGame(gr, i);
        this.mg.go(mode, lv);
    }

    /**
     * Paints the current mini-game.
     */
    public void paint() {
        this.mg.patin();
    }

    /**
     * Runs the current mini-game.
     */
    public void run() {
        this.mg.run();
    }

    /**
     * Handles key events for the current mini-game.
     * If the key event is handled, it resets the mini-game.
     *
     * @param gr the GameRun instance
     */
    public void key(GameRun gr) {
        if (this.mg.key()) {
            GameRun.run_state = -10;
            this.mg = null;
        }
    }
}
