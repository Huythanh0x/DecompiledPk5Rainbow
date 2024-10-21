/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  main.GameRun
 *  minigame.Bearer
 *  minigame.Cards
 *  minigame.Guess
 *  minigame.MiniGame_H
 *  minigame.Racing
 */
package minigame;

import main.GameRun;
import minigame.Bearer;
import minigame.Cards;
import minigame.Guess;
import minigame.MiniGame_H;
import minigame.Racing;

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

    /*
     * Unable to fully structure code
     */
    private void setGame(GameRun var1_1, int var2_2) {
        this.mg = null;
        this.type = (byte)var2_2;
        switch (var2_2) lbl-1000:
        // 4 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                return;
            }
            case 0: {
                this.mg = new Racing(var1_1);
                ** GOTO lbl-1000
            }
            case 1: {
                this.mg = new Bearer(var1_1);
                ** GOTO lbl-1000
            }
            case 2: {
                this.mg = new Cards(var1_1);
                ** GOTO lbl-1000
            }
            case 3: 
        }
        this.mg = new Guess(var1_1);
        ** while (true)
    }

    public void go(GameRun gameRun, int n, int n2, int n3) {
        GameRun.run_state = 69;
        this.setGame(gameRun, n);
        this.mg.go(n2, n3);
    }

    public void key(GameRun gameRun) {
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
