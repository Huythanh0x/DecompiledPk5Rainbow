/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  dm.Ms
 *  dm.Sprite
 *  dm.Ui
 *  javax.microedition.lcdui.Image
 *  main.Constants_H
 *  main.GameRun
 *  minigame.MiniGame_H
 */
package minigame;

import dm.Ms;
import dm.Sprite;
import dm.Ui;
import javax.microedition.lcdui.Image;
import main.Constants_H;
import main.GameRun;
import minigame.MiniGame_H;

public class Guess
implements MiniGame_H {
    final short BOX_Y1;
    final short MON_Y;
    final short TIME = (short)20;
    final short TIME2 = (short)40;
    private byte b_win;
    private int[][] box;
    private byte[] boxNum;
    private byte[][] gameData;
    private byte gameR = 0;
    GameRun gr;
    private Image[] imgBox;
    private Sprite[] imgMon;
    private byte length;
    private byte lv;
    private byte maxTransNum;
    private byte mon_size_move = 0;
    byte sel;
    private int sell_money;
    private byte state = 0;
    private byte tempTransNum = 0;
    private byte time;
    private byte transNum = 0;
    private byte winNum = 0;

    public Guess(GameRun gameRun) {
        this.BOX_Y1 = (short)150;
        this.MON_Y = (short)165;
        this.maxTransNum = (byte)20;
        this.gr = gameRun;
    }

    /*
     * Unable to fully structure code
     */
    private void draw() {
        block11: {
            if (this.state == 0) {
                Ui.i().drawString("\u6e38\u620f\u89c4\u5219", 320, 4, 17, 3, 1);
                Ui.i().drawUi(7, 320 - 75, 27, 40, 0);
                Ui.i().drawUi(7, 320 + 75, 27, 36, 4);
            }
            var1_1 = 29 * 10;
            Ui.i().drawK(10, 25 + 10, 200, var1_1, 4);
            Ui.i().drawK(10 + 200 + 10, 25 + 10, 200, var1_1, 4);
            Ui.i().drawK(10 + 420, 25 + 10, 200, var1_1, 4);
            Ui.i().drawStringY(this.gr.about_a, 10 + 6, 25 + 10, 29, 0, 0);
            if (this.state != 0) ** GOTO lbl16
            this.gr.showStringM("\u9700\u8981\u7684\u53c2\u52a0\u8d39\uff1a" + this.sell_money + "\u91d1", 320, 25 + 290 - 50, 7, 0);
            Ui.i().drawListKY(2, 10 + 200 + 12 + 25, 25 + 75 + 5, 200 - 50, 3, 30, 10, (int)this.sel, 4, 2);
            var1_1 = 0;
            block0: while (true) {
                block12: {
                    if (var1_1 < this.gr.about_b.length) break block12;
lbl16:
                    // 2 sources

                    if (this.state == 0) {
                        Ui.i().drawYesNo(true, true);
                    }
                    this.gr.drawMoney(320, 360, 3, false);
                    return;
                }
                var4_4 = Ui.i();
                var3_3 = this.gr.about_b[var1_1].toString();
                if (this.sel != var1_1) break;
                var2_2 = 0;
lbl25:
                // 2 sources

                while (true) {
                    var4_4.drawString(var3_3, 10 + 200 + 15 + 25 + 26, var1_1 * 40 + 105 - 2, 0, var2_2, 1);
                    if (this.gr.pkey.isSelect(10 + 200 + 12 + 25, var1_1 * 40 + 105 - 2, 200 - 50, 40)) {
                        if (this.sel != var1_1) break block11;
                        this.gr.pkey.setKey5();
                    }
lbl30:
                    // 4 sources

                    while (true) {
                        ++var1_1;
                        continue block0;
                        break;
                    }
                    break;
                }
                break;
            }
            var2_2 = 3;
            ** while (true)
        }
        this.sel = (byte)var1_1;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawGame() {
        block20: {
            block18: {
                block17: {
                    block15: {
                        block14: {
                            Ui.i().drawString("\u80dc\u5229\u6b21\u6570\uff1a" + this.winNum + "/" + this.gameData[3][this.lv], 320, 4, 17, 3, 1);
                            if (this.state != 1) break block15;
                            Ui.g.setClip(202, 65, 240, 100);
                            var2_1 = 0;
                            block0: while (true) {
                                block16: {
                                    if (var2_1 < this.box.length) break block16;
                                    Ui.g.setClip(0, 0, 640, 360);
                                    if (this.time < 20) ** GOTO lbl12
                                    var2_1 = 0;
lbl10:
                                    // 2 sources

                                    while (true) {
                                        if (var2_1 < this.box.length) break block14;
lbl12:
                                        // 7 sources

                                        return;
                                    }
                                }
                                if (this.box[var2_1][1] != -1) break;
lbl16:
                                // 2 sources

                                while (true) {
                                    ++var2_1;
                                    continue block0;
                                    break;
                                }
                                break;
                            }
                            var5_8 = this.box[var2_1][1];
                            var4_6 = this.box[var2_1][2];
                            if (this.time < 40) {
                                var3_4 = 0;
lbl23:
                                // 2 sources

                                while (true) {
                                    this.drawMon(var2_1, var5_8, var4_6 + 202, var3_4 + 165);
                                    ** continue;
                                    break;
                                }
                            }
                            var3_4 = this.mon_size_move;
                            ** while (true)
                        }
                        Ui.i().drawImage(this.imgBox[1], this.box[var2_1][2] + 202, this.box[var2_1][3], 17);
                        ++var2_1;
                        ** while (true)
                    }
                    if (this.state != 2) break block17;
                    var2_2 = 0;
                    while (true) {
                        if (var2_2 >= this.box.length) ** GOTO lbl12
                        Ui.i().drawImage(this.imgBox[1], this.box[var2_2][2] + 202, this.box[var2_2][3], 17);
                        ++var2_2;
                    }
                }
                if (this.state != 3) break block18;
                var2_3 = 0;
                while (true) {
                    block19: {
                        if (var2_3 < this.box.length) break block19;
                        var6_9 = Ui.i();
                        var7_10 = this.imgBox[0];
                        var3_5 = this.box[this.gr.selectx][2];
                        var4_7 = this.box[this.gr.selectx][3];
                        if (this.time % 4 > 2) break;
                        var2_3 = 5;
lbl51:
                        // 2 sources

                        while (true) {
                            var6_9.drawImage(var7_10, var3_5 + 202 - 1, var4_7 - var2_3, 17);
                            this.time = var1_11 = (byte)(this.time + 1);
                            if (var1_11 > 20) {
                                this.time = 0;
                            }
                            this.drawMon(this.box[this.gr.selecty][0], this.box[this.gr.selecty][1], this.gameData[0][1] + 202 + 100, 135);
                            this.gr.showStringM("\u8bf7\u6307\u51fa" + this.gr.getNameMon(this.box[this.gr.selecty][1]) + "\u6240\u5728\u7bb1\u5b50", 202 + 240 + 90, 29 * 5, 6, 0);
                            ** GOTO lbl12
                            break;
                        }
                    }
                    if (this.gr.pkey.isSelect(this.box[var2_3][2] + 202 - 20, this.box[var2_3][3], 40, 40)) {
                        this.gr.selectx = (byte)var2_3;
                        this.gr.pkey.setKey5();
                    }
                    Ui.i().drawImage(this.imgBox[1], this.box[var2_3][2] + 202, this.box[var2_3][3], 17);
                    ++var2_3;
                }
                var2_3 = 0;
                ** while (true)
            }
            if (this.state != 4) ** GOTO lbl12
            this.drawMon(this.box[this.gr.selecty][0], this.box[this.gr.selecty][1], this.gameData[0][1] + 202 + 100, 135);
            Ui.i().drawImage(this.imgBox[1], this.box[this.gr.selectx][2] + 202, this.box[this.gr.selectx][3], 17);
            if (this.box[this.gr.selectx][1] != -1) {
                this.drawMon(this.box[this.gr.selectx][0], this.box[this.gr.selectx][1], this.box[this.gr.selectx][2] + 202, this.box[this.gr.selectx][3] + 35);
            }
            if (this.b_win <= 0) break block20;
            this.gr.showStringM("\u60a8\u771f\u5389\u5bb3\uff01", 202 + 240 + 90, 29 * 5, 6, 0);
lbl76:
            // 2 sources

            while (true) {
                this.gr.showStringM("\u70b9\u51fb\u5c4f\u5e55\u7ee7\u7eed", 202 + 240 + 90, 29 * 7, 6, 0);
                if (!this.gr.pkey.isSelect(0, 0, 640, 360)) ** GOTO lbl12
                this.gr.pkey.setKey5();
                ** continue;
                break;
            }
        }
        this.gr.showStringM("\u8bf4\u4e0d\u5b9a\u4e0b\u6b21\u5c31\u80fd\u884c\u7684\u3002", 202 + 240 + 90, 29 * 5, 6, 0);
        ** while (true)
    }

    private void drawMon(int n, int n2, int n3, int n4) {
        Ui.i().drawFrameOne(this.imgMon[n], this.imgMon[n].action(this.gr.mList_id[n2][1] * 3, 0, 0), n3, n4, 0);
    }

    /*
     * Unable to fully structure code
     */
    private byte[] getGameMonList() {
        block10: {
            var4_1 = new byte[3];
            var2_2 = 0;
            block0: while (true) {
                if (var2_2 >= var4_1.length) {
                    var3_3 = 0;
lbl6:
                    // 2 sources

                    while (true) {
                        if (var3_3 < this.gameData[2][this.lv]) break block0;
                        Ms.i();
                        var2_2 = (byte)Ms.getRandom((int)2);
                        var1_5 = var4_1[var4_1.length - 1];
                        var4_1[var4_1.length - 1] = var4_1[var2_2];
                        var4_1[var2_2] = var1_5;
                        var2_2 = 0;
lbl15:
                        // 2 sources

                        while (true) {
                            if (var2_2 >= 3) {
                                return var4_1;
                            }
                            break block10;
                            break;
                        }
                        break;
                    }
                }
                var4_1[var2_2] = -1;
                var2_2 = (byte)(var2_2 + 1);
            }
            var5_4 = this.gameData[4];
            Ms.i();
            var4_1[var3_3] = var5_4[Ms.getRandom((int)this.gameData[4].length)];
            var2_2 = 0;
            while (true) {
                if (var2_2 >= var3_3) {
                    var3_3 = (byte)(var3_3 + 1);
                    ** continue;
                }
                if (var4_1[var2_2] == var4_1[var3_3]) {
                    var5_4 = this.gameData[4];
                    Ms.i();
                    var4_1[var3_3] = var5_4[Ms.getRandom((int)this.gameData[4].length)];
                    var2_2 = 0;
                    continue;
                }
                var2_2 = (byte)(var2_2 + 1);
            }
        }
        if (var4_1[var2_2] == -1) lbl-1000:
        // 2 sources

        {
            while (true) {
                var2_2 = (byte)(var2_2 + 1);
                ** continue;
                break;
            }
        }
        var3_3 = this.gr.mList_id[var4_1[var2_2]][0];
        this.imgMon[var2_2] = Ms.i().createSprite("data/npc2/" + var3_3, this.gr.isNpc2ImageType((int)var3_3));
        ** while (true)
    }

    private void initGame() {
        byte[] byArray = this.getGameMonList();
        int n = 0;
        while (true) {
            if (n >= 3) {
                byArray = null;
                Ms.i();
                this.maxTransNum = (byte)(Ms.getRandom((int)(this.lv + 2)) + 2 + this.lv);
                this.transNum = 0;
                this.mon_size_move = 0;
                return;
            }
            this.box[n][0] = n;
            this.box[n][1] = byArray[n];
            this.box[n][2] = this.gameData[0][n] + 100;
            this.box[n][3] = 0;
            n = (byte)(n + 1);
        }
    }

    /*
     * Enabled force condition propagation
     */
    private byte win() {
        int n;
        this.winNum = n = (int)(this.winNum + 1);
        if (n < this.gameData[3][this.lv]) return (byte)3;
        int n2 = this.sell_money + this.lv * this.lv * 150 + (2 - this.lv) * 25;
        GameRun gameRun = this.gr;
        gameRun.money += n2;
        this.gr.say("\u83b7\u5f97\u91d1\u94b1\uff1a" + n2, 0);
        byte[] byArray = this.gr.rmsOther;
        byArray[10] = (byte)(byArray[10] | 1 << this.lv);
        if (this.lv != 2) return (byte)2;
        if (this.gr.rmsOther[11] >= 3) return (byte)2;
        byte[] byArray2 = this.gr.rmsOther;
        byArray2[11] = (byte)(byArray2[11] + 1);
        return (byte)2;
    }

    /*
     * Enabled force condition propagation
     */
    public void go(int n) {
        if (n < 1) {
            this.b_win = 0;
            this.gr.selecty = 0;
            this.gr.selectx = 0;
            this.winNum = 0;
            this.state = 0;
            this.gr.buyOk = 0;
            this.gr.line_max = (byte)9;
            this.sell_money = this.lv * 200 + 200;
            this.length = (byte)(this.gr.about_a.length - this.gr.line_max);
            return;
        }
        this.time = 0;
        this.state = 1;
        this.initGame();
    }

    public void go(int n, int n2) {
        this.gr.setStringB(this.gr.createString("data/gamed.d"), 180, 0);
        this.gr.setStringB("\u5f00\u59cb\u6e38\u620f#n\u79bb\u5f00\u6e38\u620f", Constants_H.WIDTH, 1);
        this.lv = (byte)n2;
        this.imgBox = new Image[2];
        this.imgBox[0] = Ms.i().createImage("data/brow/m2");
        this.imgBox[1] = Ms.i().createImage("data/brow/m3");
        this.boxNum = new byte[2];
        this.gameData = new byte[][]{{-60, 17, 90}, {8, 13, 20, 30}, {1, 2, 3, 3}, {6, 4, 2, 2}, {83, 30, 55}};
        this.box = new int[3][4];
        this.imgMon = new Sprite[3];
        this.go(n);
    }

    /*
     * Unable to fully structure code
     */
    public boolean key() {
        block14: {
            block11: {
                block13: {
                    block12: {
                        block7: {
                            block9: {
                                block10: {
                                    block8: {
                                        if (Ms.i().key_delay()) {
                                            var2_1 = false;
lbl3:
                                            // 4 sources

                                            return var2_1;
                                        }
                                        if (this.state != 0) break block7;
                                        if (!Ms.i().key_Up_Down()) break block8;
                                        this.sel = (byte)(this.sel ^ 1);
lbl8:
                                        // 11 sources

                                        while (true) {
                                            var2_1 = false;
                                            ** GOTO lbl3
                                            break;
                                        }
                                    }
                                    if (!Ms.i().key_S1_Num5()) break block9;
                                    Ms.i().keyRelease();
                                    if (this.sel != 0 || !this.gr.isMoney(this.sell_money, true)) break block10;
                                    this.go(1, this.lv);
                                    ** GOTO lbl8
                                }
                                if (this.sel != 1) ** GOTO lbl8
                                Ms.i().keyRelease();
                                this.gr.about_a = null;
                                this.imgBox = null;
                                this.boxNum = null;
                                this.gameData = null;
                                this.box = null;
                                this.imgMon = null;
                                var2_1 = true;
                                ** GOTO lbl3
                            }
                            if (!Ms.i().key_S2()) ** GOTO lbl8
                            Ms.i().keyRelease();
                            this.gr.about_a = null;
                            this.imgBox = null;
                            this.boxNum = null;
                            this.gameData = null;
                            this.box = null;
                            this.imgMon = null;
                            var2_1 = true;
                            ** while (true)
                        }
                        if (this.state != 3) break block11;
                        if (!Ms.i().key_Left_Right()) break block12;
                        this.gr.selectx = Ms.i().select((int)this.gr.selectx, 0, this.box.length - 1);
                        ** GOTO lbl8
                    }
                    if (!Ms.i().key_S1_Num5()) ** GOTO lbl8
                    Ms.i().keyRelease();
                    this.state = (byte)4;
                    if (this.gr.selectx != this.gr.selecty) break block13;
                    var1_2 = 1;
lbl50:
                    // 2 sources

                    while (true) {
                        this.b_win = (byte)var1_2;
                        ** GOTO lbl8
                        break;
                    }
                }
                var1_2 = -1;
                ** while (true)
            }
            if (this.state != 4 || !Ms.i().key_S1_Num5()) ** GOTO lbl8
            Ms.i().keyRelease();
            if (this.b_win != 1) break block14;
            this.b_win = this.win();
            if (this.b_win == 3) {
                this.go(1, this.lv);
            }
            ** GOTO lbl8
        }
        if (this.b_win != -1 && (this.b_win != 2 || this.gr.say_c != 0)) ** GOTO lbl8
        if (this.b_win == 2 && this.gr.rmsOther[11] == 3) {
            this.gr.rmsOther[11] = 4;
            this.gr.getMonster(83, 25, 0, -1);
lbl70:
            // 3 sources

            while (true) {
                this.go(0, this.lv);
                ** continue;
                break;
            }
        }
        if (this.b_win != -1 || this.gr.rmsOther[11] >= 3) ** GOTO lbl70
        this.gr.rmsOther[11] = 0;
        ** while (true)
    }

    public void patin() {
        Ui.i().fillRectB();
        this.draw();
        if (this.state != 0) {
            this.drawGame();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void run() {
        block14: {
            block17: {
                block15: {
                    block16: {
                        block11: {
                            block13: {
                                block12: {
                                    if (this.state != 1) break block11;
                                    if (this.time < 20) {
                                        this.time = (byte)(this.time + 1);
lbl4:
                                        // 11 sources

                                        return;
                                    }
                                    if (this.box[0][3] >= 150) break block12;
                                    var2_1 = 0;
                                    while (true) {
                                        if (var2_1 >= 3) ** GOTO lbl4
                                        var4_4 = this.box[var2_1];
                                        var4_4[3] = var4_4[3] + 25;
                                        var2_1 = (byte)(var2_1 + 1);
                                    }
                                }
                                this.time = var1_10 = (byte)(this.time + 1);
                                if (var1_10 < 40) ** GOTO lbl4
                                if (this.mon_size_move >= 40) break block13;
                                this.mon_size_move = (byte)(this.mon_size_move + 5);
                                ** GOTO lbl4
                            }
                            this.state = (byte)2;
                            this.time = 0;
                            ** GOTO lbl4
                        }
                        if (this.state != 2) break block14;
                        if (this.time > 0) break block15;
                        if (this.transNum >= this.maxTransNum) break block16;
                        this.time = 1;
                        this.transNum = (byte)(this.transNum + 1);
                        var4_5 = this.boxNum;
                        Ms.i();
                        var4_5[0] = (byte)Ms.getRandom((int)3);
                        do {
                            var4_5 = this.boxNum;
                            Ms.i();
                            var4_5[1] = (byte)Ms.getRandom((int)3);
                        } while (this.boxNum[1] == this.boxNum[0]);
                        if (this.box[this.boxNum[1]][2] < this.box[this.boxNum[0]][2]) {
                            this.gameR = this.boxNum[1];
                            this.boxNum[1] = this.boxNum[0];
                            this.boxNum[0] = this.gameR;
                        }
                        Ms.i();
                        this.gameR = (byte)(Ms.abs((int)(this.box[this.boxNum[1]][2] - this.box[this.boxNum[0]][2])) / 2);
                        this.tempTransNum = (byte)(this.gameR * 2 / this.gameData[1][this.lv]);
                        ** GOTO lbl4
                    }
                    this.time = 0;
                    this.state = (byte)3;
                    do {
                        var4_6 = this.gr;
                        Ms.i();
                        var4_6.selecty = (byte)Ms.getRandom((int)this.box.length);
                    } while (this.box[this.gr.selecty][1] == -1);
                    ** GOTO lbl4
                }
                if (this.time <= this.tempTransNum) break block17;
                this.time = 0;
                var4_7 = new int[4];
                var2_2 = 0;
                block4: while (true) {
                    block18: {
                        if (var2_2 < this.box.length) break block18;
                        var2_2 = 0;
                        while (true) {
                            if (var2_2 >= 3) ** GOTO lbl4
                            this.box[var2_2][2] = this.gameData[0][var2_2] + 100;
                            this.box[var2_2][3] = 150;
                            var2_2 = (byte)(var2_2 + 1);
                        }
                    }
                    var3_11 = 0;
                    while (true) {
                        if (var3_11 >= this.box.length) {
                            var2_2 = (byte)(var2_2 + 1);
                            continue block4;
                        }
                        if (this.box[var3_11][2] > this.box[var2_2][2]) {
                            System.arraycopy(this.box[var2_2], 0, var4_7, 0, var4_7.length);
                            System.arraycopy(this.box[var3_11], 0, this.box[var2_2], 0, this.box[var3_11].length);
                            System.arraycopy(var4_7, 0, this.box[var3_11], 0, var4_7.length);
                        }
                        var3_11 = (byte)(var3_11 + 1);
                    }
                    break;
                }
            }
            this.time = (byte)(this.time + 1);
            var4_8 = this.box[this.boxNum[0]];
            var4_8[2] = var4_8[2] + this.gameR * 2 / this.tempTransNum;
            var2_3 = this.gameR * 2 / this.tempTransNum * this.time;
            this.box[this.boxNum[0]][3] = 150 - Ms.i().sqrt(this.gameR * this.gameR - (var2_3 - this.gameR) * (var2_3 - this.gameR));
            var4_8 = this.box[this.boxNum[1]];
            var4_8[2] = var4_8[2] - this.gameR * 2 / this.tempTransNum;
            this.box[this.boxNum[1]][3] = Ms.i().sqrt(this.gameR * this.gameR - (var2_3 - this.gameR) * (var2_3 - this.gameR)) + 150;
            ** GOTO lbl4
        }
        if (this.state != 4 || (this.gr.selectx != 2 || this.box[this.gr.selectx][2] <= this.gameData[0][1] + 100) && (this.gr.selectx != 0 || this.box[this.gr.selectx][2] >= this.gameData[0][1] + 100)) ** GOTO lbl4
        var4_9 = this.box[this.gr.selectx];
        var4_9[2] = var4_9[2] + (this.gameData[0][1] - this.gameData[0][this.gr.selectx]) / 7;
        ** while (true)
    }
}
