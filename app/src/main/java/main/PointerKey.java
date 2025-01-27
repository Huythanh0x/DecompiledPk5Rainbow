package main;

import android.util.Log;
import com.uc.paymentsdk.util.Constants;
import dm.Ms;

/* loaded from: classes.dex */
/**
 * The PointerKey class handles the input and interaction logic for the game.
 * It processes touch events, checks button presses, and manages movement.
 */
public class PointerKey implements Key_H {
    boolean dir;
    int gox;
    int goy;
    GameRun gr;
    boolean isGo;
    int m0;
    int m1;
    Map map;
    MainCanvas mc;
    int tempx;
    int tempy;
    public int[][][] button_pos = {new int[][]{new int[]{0, Constants_H.HEIGHT - 50, 50, 50, -6}, new int[]{Constants_H.WIDTH - 50, Constants_H.HEIGHT - 50, 50, 50, -7}}, new int[][]{new int[]{0, 0, Constants_H.WIDTH, Constants_H.HEIGHT, 48}}, new int[][]{new int[]{0, 0, Constants_H.WIDTH, Constants_H.HEIGHT, 53}}, new int[][]{new int[]{170, 275, 106, 97, -3}, new int[]{363, 285, 108, 83, -4}, new int[]{281, 290, 76, 88, 53}}, new int[][]{new int[]{0, 0, Constants_H.WIDTH_H_, Constants_H.HEIGHT_, -3}, new int[]{Constants_H.WIDTH_H_, 0, Constants_H.WIDTH_H_, Constants_H.HEIGHT_, -4}}, new int[][]{new int[]{462, 42, 83, 72, Constants_H.GAME_ERROR}, new int[]{548, 116, 83, 71, Constants_H.GAME_ERROR}, new int[]{466, 182, 85, 75, Constants_H.GAME_ERROR}, new int[]{524, 266, 91, 68, Constants_H.GAME_ERROR}, new int[]{48, 277, 87, 80, Constants_H.GAME_ERROR}}, new int[][]{new int[]{Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60, 60, 60, Constants_H.GAME_ERROR}, new int[]{0, Constants_H.HEIGHT__ - 60, 60, 60, Constants_H.GAME_ERROR}, new int[]{Constants_H.WIDTH__ - 60, ((Constants_H.HEIGHT__ - 60) - 120) - 40, 60, 60, Constants_H.GAME_ERROR}, new int[]{Constants_H.WIDTH__ - 60, ((Constants_H.HEIGHT__ - 60) - 60) - 20, 60, 60, Constants_H.GAME_ERROR}, new int[]{((Constants_H.WIDTH__ - 60) - 120) - 40, Constants_H.HEIGHT__ - 60, 60, 60, Constants_H.GAME_ERROR}, new int[]{((Constants_H.WIDTH__ - 60) - 60) - 20, Constants_H.HEIGHT__ - 60, 60, 60, Constants_H.GAME_ERROR}, new int[]{Constants_H.WIDTH__ - 60, ((Constants_H.HEIGHT__ - 60) - Constants_H.HEIGHT_H_) - 60, 60, 60, Constants_H.GAME_ERROR}}, new int[][]{new int[]{Constants_H.WIDTH - 50, Constants_H.HEIGHT - 50, 50, 50, -7}}, new int[][]{new int[]{0, 310, 50, 50, -6}, new int[]{590, 310, 50, 50, -7}}, new int[][]{new int[]{0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_, 48}}, new int[][]{new int[]{Constants_H.WIDTH - 30, Constants_H.HEIGHT - 30, 30, 30, Constants_H.GAME_ERROR}, new int[]{0, Constants_H.HEIGHT - 30, 30, 30, Constants_H.GAME_ERROR}, new int[]{Constants_H.WIDTH - 30, ((Constants_H.HEIGHT - 30) - 90) - 25, 30, 30, Constants_H.GAME_ERROR}, new int[]{Constants_H.WIDTH - 30, ((Constants_H.HEIGHT - 30) - 45) - 15, 30, 30, Constants_H.GAME_ERROR}, new int[]{((Constants_H.WIDTH - 30) - 90) - 40, Constants_H.HEIGHT - 30, 30, 30, Constants_H.GAME_ERROR}, new int[]{((Constants_H.WIDTH - 30) - 45) - 20, Constants_H.HEIGHT - 30, 30, 30, Constants_H.GAME_ERROR}, new int[]{Constants_H.WIDTH - 30, ((Constants_H.HEIGHT - 30) - 135) - 35, 30, 30, Constants_H.GAME_ERROR}}};
    int i0 = -1;
    int i1 = -1;

    /**
     * Constructor for PointerKey.
     *
     * @param mc_ The MainCanvas instance.
     */
    public PointerKey(MainCanvas mc_) {
        this.mc = mc_;
        this.gr = this.mc.gr;
        this.map = this.gr.map;
    }

    /**
     * Checks if a button is pressed based on the given check number.
     *
     * @param check_no The check number to identify the button set.
     * @return The index of the button if pressed, otherwise -1.
     */
    public int checkButton(int check_no) {
        return checkButton(check_no, this.i0, this.i1);
    }

    /**
     * Checks if a button is pressed based on the given check number and coordinates.
     *
     * @param check_no The check number to identify the button set.
     * @param x        The x-coordinate of the touch event.
     * @param y        The y-coordinate of the touch event.
     * @return The index of the button if pressed, otherwise -1.
     */
    public int checkButton(int check_no, int x, int y) {
        for (int i = 0; i < this.button_pos[check_no].length; i++) {
            if (Ms.i().isRect(x - 1, y - 1, 2, 2, this.button_pos[check_no][i][0], this.button_pos[check_no][i][1], this.button_pos[check_no][i][2], this.button_pos[check_no][i][3])) {
                Ms.key = this.button_pos[check_no][i][4];
                if (check_no == 3 && Ms.key == 53) {
                    Log.e("touch", "Press the OK key...menu_state:" + this.mc.menu_state);
                }
                Ms.keyRepeat = true;
                initPointer();
                return i;
            }
        }
        return -1;
    }

    /**
     * Processes the touch event at the given coordinates.
     *
     * @param x The x-coordinate of the touch event.
     * @param y The y-coordinate of the touch event.
     */
    public void process(int x, int y) {
        if (this.map.my.state != 20 || checkButton(7, x, y) == -1) {
            if (GameRun.run_state != -10 || (this.map.my.state != 0 && this.map.my.state != 20)) {
                if (GameRun.run_state == -10) {
                    if ((this.map.my.state != 18 && this.map.my.state != 17) || checkButton(8, x, y) == -1) {
                        if (this.map.my.state != 18 && this.map.my.state != 17 && checkButton(0, x, y) != -1) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (GameRun.run_state != -10 && checkButton(8, x, y) != -1) {
                    return;
                }
            }
            switch (this.mc.game_state) {
                case 30:
                    runKeySate(x, y);
                    return;
                case 40:
                    switch (this.mc.menu_state) {
                        case 0:
                            if (this.mc.load_c == 1) {
                                this.i0 = x;
                                this.i1 = y;
                                checkButton(3, x, y);
                                return;
                            }
                            checkButton(9, x, y);
                            return;
                        default:
                            return;
                    }
                case 98:
                    checkButton(9, x, y);
                    Log.d("soars", "checkButton");
                    return;
                default:
                    return;
            }
        }
    }

    /**
     * Runs the key state logic based on the current game state and touch coordinates.
     *
     * @param x The x-coordinate of the touch event.
     * @param y The y-coordinate of the touch event.
     */
    public void runKeySate(int x, int y) {
        switch (GameRun.run_state) {
            case -31:
                if (this.gr.battle_state == 2) {
                    this.gr.cur_a = (byte) checkButton(5, x, y);
                    if (this.gr.cur_a != -1) {
                        setKey5();
                        return;
                    }
                    return;
                }
                this.i0 = x;
                this.i1 = y;
                return;
            case -20:
            case 18:
            case 25:
            case 35:
            case 61:
            case 65:
            case 66:
            case 68:
            case 97:
                this.i0 = x;
                this.i1 = y;
                return;
            case -10:
                this.i0 = x;
                this.i1 = y;
                if (this.map.my.state == 22) {
                    if (this.gr.say_c >= 0) {
                        checkButton(1, x, y);
                        return;
                    } else {
                        checkButton(2, x, y);
                        return;
                    }
                }
                if (this.map.my.state == 1 || this.map.my.state == 10) {
                    checkButton(2, x, y);
                    return;
                }
                if (this.map.my.state == 0) {
                    if (this.gr.say_c == -1) {
                        checkButton(2, x, y);
                    } else if (this.gr.say_s == 0 && this.gr.say_c == 0 && isMove((-this.map.map_x) + x, (-this.map.map_y) + y)) {
                        setMove(x, y);
                    }
                    this.i0 = x;
                    this.i1 = y;
                    return;
                }
                if (this.map.my.state == 12 || this.map.my.state == 18 || this.map.my.state == 17 || this.map.my.state == 16 || this.map.my.state == 20 || this.map.my.state == 2) {
                    this.i0 = x;
                    this.i1 = y;
                    return;
                }
                return;
            case Constants.JIFENGQUAN_G_RATIO /* 60 */:
            case 98:
                checkButton(1, x, y);
                return;
            case 69:
                this.i0 = x;
                this.i1 = y;
                return;
            default:
                return;
        }
    }

    /**
     * Sets the key to a specific value (53) and enables key repeat.
     */
    public void setKey5() {
        Ms.key = 53;
        Ms.keyRepeat = true;
    }

    /**
     * Sets the key to a specific value (-6) and enables key repeat.
     */
    public void setKeySoftkey1() {
        Ms.key = -6;
        Ms.keyRepeat = true;
    }

    /**
     * Checks if the given coordinates are within the movement area.
     *
     * @param x The x-coordinate to check.
     * @param y The y-coordinate to check.
     * @return True if the coordinates are within the movement area, otherwise false.
     */
    private boolean isMove(int x, int y) {
        int npcX;
        int npcY;
        if (this.map.my.dir == 3) {
            npcX = this.map.my.x - 20;
            npcY = this.map.my.y - 60;
        } else if (this.map.my.dir == 4) {
            npcX = this.map.my.x + 20;
            npcY = this.map.my.y - 60;
        } else if (this.map.my.dir == 1) {
            npcX = this.map.my.x;
            npcY = this.map.my.y - 80;
        } else {
            npcX = this.map.my.x;
            npcY = this.map.my.y - 40;
        }
        if ((Ms.i().isRect(x, y, 1, 1, npcX, npcY, 20, 80) || Ms.i().isRect(this.i0, this.i1, 1, 1, Constants_H.WIDTH_H - 30, Constants_H.HEIGHT - 60, 60, 60)) && this.map.checkSoftKey(this.map.my.x, this.map.my.y, this.map.dir_select[this.map.my.dir][0] * this.map.my.speed, this.map.dir_select[this.map.my.dir][1] * this.map.my.speed) != -1) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the given coordinates are within the selection area.
     *
     * @param x The x-coordinate of the selection area.
     * @param y The y-coordinate of the selection area.
     * @param w The width of the selection area.
     * @param h The height of the selection area.
     * @return True if the coordinates are within the selection area, otherwise false.
     */
    public boolean isSelect(int x, int y, int w, int h) {
        if (!Ms.i().isRect(this.i0, this.i1, 1, 1, x, y, w, h)) {
            return false;
        }
        initPointer();
        return true;
    }

    /**
     * Selects an item from a list based on the touch coordinates.
     *
     * @param len The length of the list.
     * @param x   The x-coordinate of the list.
     * @param y   The y-coordinate of the list.
     * @param w   The width of the list items.
     * @param kw  The width of the selection area.
     * @param kh  The height of the selection area.
     * @param dis The distance between list items.
     * @param sel The selected item index.
     */
    public void selectListSY(int len, int x, int y, int w, int kw, int kh, int dis, int sel) {
        for (int i = 0; i < len; i++) {
            if (Ms.i().isRect(this.i0, this.i1, 1, 1, x, y + ((kh + dis) * i), w, kh)) {
                this.gr.selecty = (byte) i;
                if (i == sel) {
                    setKey5();
                }
                initPointer();
            }
        }
    }

    /**
     * Selects a menu item based on the touch coordinates.
     *
     * @param len The length of the menu.
     * @param x   The x-coordinate of the menu.
     * @param y   The y-coordinate of the menu.
     * @param w   The width of the menu items.
     * @param h   The height of the menu items.
     * @return The index of the selected menu item, otherwise -1.
     */
    public byte selectMenuX(int len, int x, int y, int w, int h) {
        for (int i = 0; i < len; i++) {
            if (Ms.i().isRect(this.i0, this.i1, 1, 1, x + (i * w), y, w, h)) {
                initPointer();
                return (byte) i;
            }
        }
        return (byte) -1;
    }

    /**
     * Initializes the pointer by resetting coordinates and states.
     */
    public void initPointer() {
        this.i1 = -1;
        this.i0 = -1;
        this.m1 = -1;
        this.m0 = -1;
    }

    /**
     * Sets the movement coordinates and direction based on the touch event.
     *
     * @param x The x-coordinate of the touch event.
     * @param y The y-coordinate of the touch event.
     */
    public void setMove(int x, int y) {
        this.m0 = (((-this.map.map_x) + x) / 20) * 20;
        this.m1 = (((-this.map.map_y) + y) / 20) * 20;
        this.dir = Ms.abs(this.m0 - this.map.my.x) < Ms.abs(this.m1 - this.map.my.y);
        this.isGo = true;
        this.tempx = x;
        this.tempy = y;
        this.gox = (-this.map.map_x) + this.tempx;
        this.goy = (-this.map.map_y) + this.tempy;
    }

    /**
     * Stops the movement and resets the pointer.
     */
    public void stopMove() {
        Ms.i().keyRelease();
        initPointer();
        this.isGo = false;
    }

    /**
     * Runs the movement logic based on the current game state.
     */
    public void runMove() {
        if (GameRun.run_state == -10 && this.map.my.state == 0 && this.m0 != -1) {
            int x = this.m0 - this.map.my.x;
            int y = this.m1 - this.map.my.y;
            if (Ms.abs(x) < this.map.my.speed && Ms.abs(y) < this.map.my.speed) {
                stopMove();
                return;
            }
            boolean bb = this.dir ? Ms.abs(y) < this.map.my.speed : Ms.abs(x) >= this.map.my.speed;
            if (bb) {
                Ms.key = x < 0 ? -3 : -4;
            } else {
                Ms.key = y < 0 ? -1 : -2;
            }
            this.map.map_key = (byte) (-Ms.key);
            this.map.doKey();
        }
    }
}
