/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  dm.Ms
 *  main.Constants_H
 *  main.GameRun
 *  main.Key_H
 *  main.MainCanvas
 *  main.Map
 */
package main;

import android.util.Log;
import dm.Ms;
import main.Constants_H;
import main.GameRun;
import main.Key_H;
import main.MainCanvas;
import main.Map;

public class PointerKey
implements Key_H {
    public int[][][] button_pos;
    boolean dir;
    int gox;
    int goy;
    GameRun gr;
    int i0;
    int i1;
    boolean isGo;
    int m0;
    int m1;
    Map map;
    MainCanvas mc;
    int tempx;
    int tempy;

    public PointerKey(MainCanvas mainCanvas) {
        Object object = new int[5];
        object[1] = Constants_H.HEIGHT - 50;
        object[2] = 50;
        object[3] = 50;
        object[4] = -6;
        object = new int[][]{object, {Constants_H.WIDTH - 50, Constants_H.HEIGHT - 50, 50, 50, -7}};
        int[] nArray = new int[5];
        nArray[2] = Constants_H.WIDTH;
        nArray[3] = Constants_H.HEIGHT;
        nArray[4] = 48;
        int[][] nArrayArray = new int[][]{nArray};
        nArray = new int[5];
        nArray[2] = Constants_H.WIDTH;
        nArray[3] = Constants_H.HEIGHT;
        nArray[4] = 53;
        int[][] nArrayArray2 = new int[][]{{170, 275, 106, 97, -3}, {363, 285, 108, 83, -4}, {281, 290, 76, 88, 53}};
        int[] nArray2 = new int[5];
        nArray2[2] = 320;
        nArray2[3] = 360;
        nArray2[4] = -3;
        int[] nArray3 = new int[5];
        nArray3[0] = 320;
        nArray3[2] = 320;
        nArray3[3] = 360;
        nArray3[4] = -4;
        Object object2 = new int[]{462, 42, 83, 72, 9999};
        Object object3 = new int[]{466, 182, 85, 75, 9999};
        Object object4 = new int[]{524, 266, 91, 68, 9999};
        object2 = new int[][]{object2, {548, 116, 83, 71, 9999}, object3, object4, {48, 277, 87, 80, 9999}};
        object3 = new int[]{Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60, 60, 60, 9999};
        Object object5 = new int[5];
        object5[1] = Constants_H.HEIGHT__ - 60;
        object5[2] = 60;
        object5[3] = 60;
        object5[4] = 9999;
        Object object6 = new int[]{Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60 - 120 - 40, 60, 60, 9999};
        int n = Constants_H.WIDTH__;
        int n2 = Constants_H.HEIGHT__;
        int n3 = Constants_H.WIDTH__;
        int n4 = Constants_H.HEIGHT__;
        int n5 = Constants_H.WIDTH__;
        int n6 = Constants_H.HEIGHT__;
        object4 = new int[]{Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60 - 180 - 60, 60, 60, 9999};
        object4 = new int[][]{object3, object5, object6, {n - 60, n2 - 60 - 60 - 20, 60, 60, 9999}, {n3 - 60 - 120 - 40, n4 - 60, 60, 60, 9999}, {n5 - 60 - 60 - 20, n6 - 60, 60, 60, 9999}, object4};
        object3 = new int[][]{{Constants_H.WIDTH - 50, Constants_H.HEIGHT - 50, 50, 50, -7}};
        object5 = new int[5];
        object5[1] = 310;
        object5[2] = 50;
        object5[3] = 50;
        object5[4] = -6;
        object5 = new int[][]{object5, {590, 310, 50, 50, -7}};
        object6 = new int[5];
        object6[2] = 640;
        object6[3] = 360;
        object6[4] = 48;
        object6 = new int[][]{object6};
        n5 = Constants_H.WIDTH;
        int n7 = Constants_H.HEIGHT;
        Object object7 = new int[5];
        object7[1] = Constants_H.HEIGHT - 30;
        object7[2] = 30;
        object7[3] = 30;
        object7[4] = 9999;
        n2 = Constants_H.WIDTH;
        int n8 = Constants_H.HEIGHT;
        n3 = Constants_H.WIDTH;
        int n9 = Constants_H.HEIGHT;
        int n10 = Constants_H.WIDTH;
        int n11 = Constants_H.HEIGHT;
        n = Constants_H.WIDTH;
        int n12 = Constants_H.HEIGHT;
        n6 = Constants_H.WIDTH;
        n4 = Constants_H.HEIGHT;
        object7 = new int[][]{{n5 - 30, n7 - 30, 30, 30, 9999}, object7, {n2 - 30, n8 - 30 - 90 - 25, 30, 30, 9999}, {n3 - 30, n9 - 30 - 45 - 15, 30, 30, 9999}, {n10 - 30 - 90 - 40, n11 - 30, 30, 30, 9999}, {n - 30 - 45 - 20, n12 - 30, 30, 30, 9999}, {n6 - 30, n4 - 30 - 135 - 35, 30, 30, 9999}};
        this.button_pos = new int[][][]{(int[][])object, nArrayArray, new int[][]{nArray}, nArrayArray2, new int[][]{nArray2, nArray3}, (int[][])object2, (int[][])object4, (int[][])object3, (int[][])object5, (int[][])object6, (int[][])object7};
        this.i0 = -1;
        this.i1 = -1;
        this.mc = mainCanvas;
        this.gr = this.mc.gr;
        this.map = this.gr.map;
    }

    /*
     * Unable to fully structure code
     */
    private boolean isMove(int var1_1, int var2_2) {
        block3: {
            block5: {
                block4: {
                    block2: {
                        if (this.map.my.dir != 3) break block2;
                        var3_3 = this.map.my.x - 20;
                        var4_4 = this.map.my.y - 60;
lbl4:
                        // 4 sources

                        while ((Ms.i().isRect(var1_1, var2_2, 1, 1, var3_3, var4_4, 20, 80) || Ms.i().isRect(this.i0, this.i1, 1, 1, Constants_H.WIDTH_H - 30, Constants_H.HEIGHT - 60, 60, 60)) && this.map.checkSoftKey((int)this.map.my.x, (int)this.map.my.y, this.map.dir_select[this.map.my.dir][0] * this.map.my.speed, this.map.dir_select[this.map.my.dir][1] * this.map.my.speed) != -1) {
                            var5_5 = false;
lbl6:
                            // 2 sources

                            return var5_5;
                        }
                        break block3;
                    }
                    if (this.map.my.dir != 4) break block4;
                    var3_3 = this.map.my.x + 20;
                    var4_4 = this.map.my.y - 60;
                    ** GOTO lbl4
                }
                if (this.map.my.dir != 1) break block5;
                var3_3 = this.map.my.x;
                var4_4 = this.map.my.y - 80;
                ** GOTO lbl4
            }
            var3_3 = this.map.my.x;
            var4_4 = this.map.my.y - 40;
            ** GOTO lbl4
        }
        var5_5 = true;
        ** while (true)
    }

    public int checkButton(int n) {
        return this.checkButton(n, this.i0, this.i1);
    }

    /*
     * Enabled force condition propagation
     */
    public int checkButton(int n, int n2, int n3) {
        int n4 = 0;
        while (n4 < this.button_pos[n].length) {
            if (Ms.i().isRect(n2 - 1, n3 - 1, 2, 2, this.button_pos[n][n4][0], this.button_pos[n][n4][1], this.button_pos[n][n4][2], this.button_pos[n][n4][3])) {
                Ms.key = this.button_pos[n][n4][4];
                if (n == 3 && Ms.key == 53) {
                    Log.e((String)"touch", (String)("\u6309\u4e0b\u786e\u5b9a\u952e\u3002\u3002\u3002menu_state: " + this.mc.menu_state));
                }
                Ms.keyRepeat = true;
                this.initPointer();
                return n4;
            }
            ++n4;
        }
        return -1;
    }

    public void initPointer() {
        this.i1 = -1;
        this.i0 = -1;
        this.m1 = -1;
        this.m0 = -1;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isSelect(int n, int n2, int n3, int n4) {
        if (!Ms.i().isRect(this.i0, this.i1, 1, 1, n, n2, n3, n4)) return false;
        this.initPointer();
        return true;
    }

    /*
     * Handled impossible loop by adding 'first' condition
     */
    public void process(int n, int n2) {
        if (this.map.my.state == 20 && this.checkButton(7, n, n2) != -1) {
            return;
        }
        boolean bl = true;
        block9: while (true) {
            if (bl && !(bl = false)) {
                if (GameRun.run_state != -10 || this.map.my.state != 0 && this.map.my.state != 20) continue;
            }
            switch (this.mc.game_state) {
                default: {
                    return;
                }
                case 30: {
                    this.runKeySate(n, n2);
                    return;
                }
                if (!(GameRun.run_state == -10 ? (this.map.my.state == 18 || this.map.my.state == 17) && this.checkButton(8, n, n2) != -1 || this.map.my.state != 18 && this.map.my.state != 17 && this.checkButton(0, n, n2) != -1 : GameRun.run_state != -10 && this.checkButton(8, n, n2) != -1)) continue block9;
                return;
                case 98: {
                    this.checkButton(9, n, n2);
                    Log.d((String)"soars", (String)"checkButton");
                    return;
                }
                case 40: 
            }
            break;
        }
        switch (this.mc.menu_state) {
            default: {
                return;
            }
            case 0: 
        }
        if (this.mc.load_c == 1) {
            this.i0 = n;
            this.i1 = n2;
            this.checkButton(3, n, n2);
            return;
        }
        this.checkButton(9, n, n2);
    }

    /*
     * Unable to fully structure code
     */
    public void runKeySate(int var1_1, int var2_2) {
        block11: {
            switch (GameRun.run_state) lbl-1000:
            // 10 sources

            {
                default: lbl-1000:
                // 3 sources

                {
                    return;
                }
                case 60: 
                case 98: {
                    this.checkButton(1, var1_1, var2_2);
                    ** GOTO lbl-1000
                }
                case -10: {
                    this.i0 = var1_1;
                    this.i1 = var2_2;
                    if (this.map.my.state != 22) ** GOTO lbl20
                    if (this.gr.say_c >= 0) ** GOTO lbl17
                    this.checkButton(2, var1_1, var2_2);
                    ** GOTO lbl-1000
lbl17:
                    // 1 sources

                    this.checkButton(1, var1_1, var2_2);
                    ** GOTO lbl-1000
lbl20:
                    // 1 sources

                    if (this.map.my.state != 1 && this.map.my.state != 10) ** GOTO lbl24
                    this.checkButton(2, var1_1, var2_2);
                    ** GOTO lbl-1000
lbl24:
                    // 1 sources

                    if (this.map.my.state != 0) ** GOTO lbl35
                    if (this.gr.say_c != -1) ** GOTO lbl32
                    this.checkButton(2, var1_1, var2_2);
lbl28:
                    // 3 sources

                    while (true) {
                        this.i0 = var1_1;
                        this.i1 = var2_2;
                        ** GOTO lbl-1000
                        break;
                    }
lbl32:
                    // 1 sources

                    if (this.gr.say_s != 0 || this.gr.say_c != 0 || !this.isMove(-this.map.map_x + var1_1, -this.map.map_y + var2_2)) ** GOTO lbl28
                    this.setMove(var1_1, var2_2);
                    ** continue;
lbl35:
                    // 1 sources

                    if (this.map.my.state != 12 && this.map.my.state != 18 && this.map.my.state != 17 && this.map.my.state != 16 && this.map.my.state != 20 && this.map.my.state != 2) ** GOTO lbl-1000
                    this.i0 = var1_1;
                    this.i1 = var2_2;
                    ** GOTO lbl-1000
                }
                case -20: 
                case 18: 
                case 25: 
                case 35: 
                case 61: 
                case 65: 
                case 66: 
                case 68: 
                case 97: {
                    this.i0 = var1_1;
                    this.i1 = var2_2;
                    ** GOTO lbl-1000
                }
                case 69: {
                    this.i0 = var1_1;
                    this.i1 = var2_2;
                    ** GOTO lbl-1000
                }
                case -31: 
            }
            if (this.gr.battle_state != 2) break block11;
            this.gr.cur_a = (byte)this.checkButton(5, var1_1, var2_2);
            if (this.gr.cur_a != -1) {
                this.setKey5();
            }
            ** GOTO lbl-1000
        }
        this.i0 = var1_1;
        this.i1 = var2_2;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void runMove() {
        block11: {
            block7: {
                block12: {
                    block9: {
                        block10: {
                            block8: {
                                if (GameRun.run_state != -10 || this.map.my.state != 0 || this.m0 == -1) lbl-1000:
                                // 3 sources

                                {
                                    return;
                                }
                                var3_1 = this.m0 - this.map.my.x;
                                var2_2 = this.m1 - this.map.my.y;
                                if (Ms.abs((int)var3_1) >= this.map.my.speed || Ms.abs((int)var2_2) >= this.map.my.speed) break block8;
                                this.stopMove();
                                ** GOTO lbl-1000
                            }
                            if (!this.dir) break block9;
                            if (Ms.abs((int)var2_2) >= this.map.my.speed) break block10;
                            var1_3 = 1;
lbl13:
                            // 4 sources

                            while (var1_3 != 0) {
                                if (var3_1 >= 0) break block7;
                                var1_3 = -3;
lbl16:
                                // 2 sources

                                while (true) {
                                    Ms.key = var1_3;
lbl18:
                                    // 2 sources

                                    while (true) {
                                        this.map.map_key = (byte)(-Ms.key);
                                        this.map.doKey();
                                        ** continue;
                                        break;
                                    }
                                    break;
                                }
lbl22:
                                // 1 sources

                                ** GOTO lbl-1000
                            }
                            break block11;
                        }
                        var1_3 = 0;
                        ** GOTO lbl13
                    }
                    if (Ms.abs((int)var3_1) < this.map.my.speed) break block12;
                    var1_3 = 1;
                    ** GOTO lbl13
                }
                var1_3 = 0;
                ** GOTO lbl13
            }
            var1_3 = -4;
            ** while (true)
        }
        if (var2_2 < 0) {
            var1_3 = -1;
lbl40:
            // 2 sources

            while (true) {
                Ms.key = var1_3;
                ** continue;
                break;
            }
        }
        var1_3 = -2;
        ** while (true)
    }

    public void selectListSY(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        n5 = 0;
        while (n5 < n) {
            if (Ms.i().isRect(this.i0, this.i1, 1, 1, n2, n3 + (n6 + n7) * n5, n4, n6)) {
                this.gr.selecty = (byte)n5;
                if (n5 == n8) {
                    this.setKey5();
                }
                this.initPointer();
            }
            ++n5;
        }
        return;
    }

    /*
     * Enabled force condition propagation
     */
    public byte selectMenuX(int n, int n2, int n3, int n4, int n5) {
        int n6 = 0;
        while (n6 < n) {
            if (Ms.i().isRect(this.i0, this.i1, 1, 1, n2 + n6 * n4, n3, n4, n5)) {
                this.initPointer();
                return (byte)n6;
            }
            ++n6;
        }
        return -1;
    }

    public void setKey5() {
        Ms.key = 53;
        Ms.keyRepeat = true;
    }

    public void setKeySoftkey1() {
        Ms.key = -6;
        Ms.keyRepeat = true;
    }

    /*
     * Unable to fully structure code
     */
    public void setMove(int var1_1, int var2_2) {
        this.m0 = (-this.map.map_x + var1_1) / 20 * 20;
        this.m1 = (-this.map.map_y + var2_2) / 20 * 20;
        if (Ms.abs((int)(this.m0 - this.map.my.x)) < Ms.abs((int)(this.m1 - this.map.my.y))) {
            var3_3 = true;
lbl5:
            // 2 sources

            while (true) {
                this.dir = var3_3;
                this.isGo = true;
                this.tempx = var1_1;
                this.tempy = var2_2;
                this.gox = -this.map.map_x + this.tempx;
                this.goy = -this.map.map_y + this.tempy;
                return;
            }
        }
        var3_3 = false;
        ** while (true)
    }

    public void stopMove() {
        Ms.i().keyRelease();
        this.initPointer();
        this.isGo = false;
    }
}
