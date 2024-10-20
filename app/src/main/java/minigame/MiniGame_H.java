package minigame;

/* loaded from: classes.dex */
/**
 * Interface representing a mini-game with various actions.
 */
public interface MiniGame_H {

    /**
     * Initiates the mini-game with a single integer parameter.
     *
     * @param i the integer parameter to start the mini-game
     */
    void go(int i);

    /**
     * Initiates the mini-game with two integer parameters.
     *
     * @param i the first integer parameter to start the mini-game
     * @param i2 the second integer parameter to start the mini-game
     */
    void go(int i, int i2);

    /**
     * Checks a condition related to the mini-game.
     *
     * @return true if the condition is met, false otherwise
     */
    boolean key();

    /**
     * Performs a patin action in the mini-game.
     */
    void patin();

    /**
     * Runs the mini-game.
     */
    void run();
}
