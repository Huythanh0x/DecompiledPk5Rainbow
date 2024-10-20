package main;

/* loaded from: classes.dex */
/**
 * The CreateThread class extends the Thread class to handle different types of game-related tasks
 * in a separate thread. It initializes the game map, loads items and monsters, or initializes a battle
 * based on the thread type.
 */
public class CreateThread extends Thread {
    GameRun gr;

    /**
     * Constructs a CreateThread object with the specified GameRun instance and thread type.
     *
     * @param gr_ the GameRun instance to be used by this thread
     * @param type the type of thread to be created
     */
    public CreateThread(GameRun gr_, int type) {
        this.gr = gr_;
        this.gr.threadType = (byte) type;
        new Thread(this).start();
    }

    /**
     * The run method is executed when the thread is started. It performs different tasks based on the
     * thread type, such as initializing the game map, loading items and monsters, or initializing a battle.
     */
    @Override
    public void run() {
        try {
            this.gr.createOver = (byte) 0;
            if (this.gr.threadType == 0) {
                this.gr.map.initMap();
                this.gr.loadItem();
                this.gr.loadMon(0, this.gr.monster_pro);
                this.gr.loadMon(1, this.gr.monster_pro);
                this.gr.loadInfoList();
            } else if (this.gr.threadType == 1) {
                this.gr.initBattle();
            } else if (this.gr.threadType != 2 && this.gr.threadType != 3 && this.gr.threadType != 4) {
                byte b = this.gr.threadType;
            }
            this.gr.createOver = (byte) -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
