/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  dm.Ms
 *  dm.Ui
 *  main.Constants_H
 *  main.GameRun
 *  minigame.MiniGame_H
 */
package minigame;

import dm.Ms;
import dm.Ui;
import main.Constants_H;
import main.GameRun;
import minigame.MiniGame_H;

public class Cards
implements MiniGame_H {
    private short count;
    private byte[][] findC;
    private byte[][] findN;
    private byte find_count;
    private short gh;
    GameRun gr;
    private short gspace;
    private short gw = (short)30;
    private short gx;
    private short gy;
    private short hh;
    private byte length;
    private byte lv;
    private byte[][] num;
    byte sel;
    private int sell_money;
    private byte selx;
    private byte sely;
    private byte state;
    private byte time;
    private byte tx;
    private byte ty;
    private short wh;

    public Cards(GameRun gameRun) {
        this.gh = (short)40;
        this.gspace = (short)4;
        this.wh = (short)320;
        this.hh = (short)160;
        this.time = (byte)3;
        this.find_count = (byte)3;
        byte[] byArray = new byte[]{3, 6};
        this.num = new byte[][]{{3, 4}, byArray, {4, 6}, {5, 6}};
        this.gr = gameRun;
    }

    /*
     * Enabled force condition propagation
     */
    private void drawCard(int n, int n2, int n3, int n4, int n5) {
        if (n5 == 0) {
            Ui.i().drawK(n3, n4, (int)this.gw, (int)this.gh, 1);
            Ui.i().drawUi(25, (this.gw >> 1) + n3, (this.gh >> 1) + n4, 3, 0);
            return;
        }
        if (n5 == 1) {
            byte by;
            Ui.i().drawK((this.gw >> 1) + n3 - 2, n4 - 3, 5, this.gh + 6, 1);
            byte[] byArray = this.findC[n];
            byArray[n2] = by = (byte)(byArray[n2] + 1);
            if (by <= 3) return;
            this.findC[n][n2] = 0;
            return;
        }
        Ui.i().drawK(n3, n4, (int)this.gw, (int)this.gh, 5);
        this.gr.drawItem((int)this.findN[n][n2], (this.gw >> 1) + n3, (this.gh >> 1) + n4, 3);
        Ui.i().drawNum("" + this.findN[n][n2], this.gw + n3, this.gh + n4, 40, 0);
    }

    /*
     * Unable to fully structure code
     */
    private void drawGame(int var1_1, int var2_2, int var3_3) {
        block10: {
            var1_1 = 0;
            block0: while (true) {
                if (var1_1 >= this.findN.length) {
                    Ui.i().drawRectZ(15400191, this.wh + this.gx + this.tx * (this.gw + this.gspace), this.hh + this.gy + this.ty * (this.gh + this.gspace), (int)this.gw, (int)this.gh, 3);
                    if (this.count > 0) {
                        Ui.i().drawNum("" + this.count / 10, 320 + 10, 29, 36, 2);
lbl7:
                        // 2 sources

                        return;
                    }
                    break block10;
                }
                var2_2 = 0;
                block2: while (true) {
                    if (var2_2 >= this.findN[var1_1].length) {
                        ++var1_1;
                        continue block0;
                    }
                    var5_5 = this.wh;
                    var6_6 = this.gx;
                    var11_11 = this.gw;
                    var9_9 = this.gspace;
                    var8_8 = this.hh;
                    var10_10 = this.gy;
                    var4_4 = this.gh;
                    var7_7 = this.gspace;
                    if (this.findC[var1_1][var2_2] != 3) break block0;
                    var3_3 = 1;
lbl25:
                    // 2 sources

                    while (true) {
                        this.drawCard(var1_1, var2_2, (var11_11 + var9_9) * var2_2 + (var5_5 + var6_6), (var4_4 + var7_7) * var1_1 + (var8_8 + var10_10), var3_3);
                        if (this.gr.pkey.isSelect(this.wh + this.gx + (this.gw + this.gspace) * var2_2, this.hh + this.gy + (this.gh + this.gspace) * var1_1, this.gw + this.gspace, this.gh + this.gspace) && this.state < 3) {
                            this.tx = (byte)var2_2;
                            this.ty = (byte)var1_1;
                            this.gr.pkey.setKey5();
                        }
                        ++var2_2;
                        continue block2;
                        break;
                    }
                    break;
                }
                break;
            }
            var3_3 = this.findC[var1_1][var2_2];
            ** while (true)
        }
        Ui.i().drawString("\u6e38\u620f\u5f00\u59cb", 320, 4, 17, 3, 0);
        var12_12 = this.gr;
        var13_13 = new StringBuilder("\u53ef\u9519\u6b21\u6570\uff1a");
        if (this.time < 0) {
            var1_1 = 0;
lbl41:
            // 2 sources

            while (true) {
                var12_12.showStringM(var13_13.append(var1_1).append("\u6b21").toString(), 320 + 200, 180 - 75, 5, 0);
                ** continue;
                break;
            }
        }
        var1_1 = this.time - 1;
        ** while (true)
    }

    private void nullGame() {
        this.findN = null;
        this.findC = null;
        this.num = null;
    }

    /*
     * Unable to fully structure code
     */
    public void draw0(int var1_1, int var2_2, int var3_3) {
        block11: {
            Ui.i().fillRectB();
            Ui.i().drawK(var1_1, var2_2 + 25 + 5, 200 - 10, var3_3, 4);
            Ui.i().drawK(var1_1 + 200, var2_2 + 25 + 5, 200 + 20, var3_3, 4);
            Ui.i().drawK(var1_1 + 420 + 10, var2_2 + 25 + 5, 200 - 10, var3_3, 4);
            if (this.state == 0) {
                Ui.i().drawString("\u6e38\u620f\u89c4\u5219", 320, var2_2 + 25 + 5, 33, 3, 1);
                Ui.i().drawUi(7, 320 - 50 + 7, var2_2 + 25, 40, 0);
                Ui.i().drawUi(7, 320 + 50 + 7, var2_2 + 25, 36, 4);
            }
            Ui.i().drawStringY(this.gr.about_a, 25, var2_2 + 25 + 10, 25, 0, 0);
            if (this.state != 0) ** GOTO lbl17
            this.gr.showStringM("\u9700\u8981\u7684\u53c2\u52a0\u8d39\uff1a" + this.sell_money + "\u91d1", 320, var2_2 + var3_3 - 50, 7, 0);
            var4_4 = var2_2 + 75 + 5;
            Ui.i().drawListKY(2, var1_1 + 200 + 12 + 25, var4_4, 200 - 50, 3, 30, 10, (int)this.sel, 4, 2);
            var2_2 = 0;
            block0: while (true) {
                block12: {
                    if (var2_2 < this.gr.about_b.length) break block12;
lbl17:
                    // 2 sources

                    this.gr.drawMoney(320, 360, 3, false);
                    if (this.state == 0) {
                        Ui.i().drawYesNo(true, true);
                    }
                    return;
                }
                var6_6 = Ui.i();
                var5_5 = this.gr.about_b[var2_2].toString();
                if (this.sel != var2_2) break;
                var3_3 = 0;
lbl26:
                // 2 sources

                while (true) {
                    var6_6.drawString(var5_5, var1_1 + 200 + 15 + 25 + 26, var2_2 * 40 + var4_4 - 2, 0, var3_3, 1);
                    if (this.gr.pkey.isSelect(var1_1 + 200 + 12 + 25, var2_2 * 40 + var4_4 - 2, 200 - 50, 40)) {
                        if (this.sel != var2_2) break block11;
                        this.gr.pkey.setKey5();
                    }
lbl31:
                    // 4 sources

                    while (true) {
                        ++var2_2;
                        continue block0;
                        break;
                    }
                    break;
                }
                break;
            }
            var3_3 = 3;
            ** while (true)
        }
        this.sel = (byte)var2_2;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void go(int var1_1) {
        block14: {
            this.gr.line_max = (byte)9;
            this.count = (short)100;
            this.time = (byte)(this.lv * 2 + 4);
            this.find_count = (byte)(this.num[this.lv][0] * this.num[this.lv][1] / 2);
            if (var1_1 < 1) {
                this.ty = 0;
                this.state = 0;
                this.sell_money = this.lv * 200 + 200;
lbl9:
                // 2 sources

                return;
            }
            this.gx = (short)(-((this.gw + this.gspace) * this.num[this.lv][1]) >> 1);
            this.gy = (short)(-((this.gh + this.gspace) * this.num[this.lv][0]) >> 1);
            this.ty = 0;
            this.tx = 0;
            this.state = 1;
            var1_1 = 0;
            var5_2 = new byte[this.find_count];
            block1: while (true) {
                if (var1_1 >= this.findC.length) {
                    var1_1 = 0;
lbl21:
                    // 3 sources

                    while (true) {
                        if (var1_1 < var5_2.length) break block1;
                        var1_1 = 0;
lbl24:
                        // 2 sources

                        while (true) {
                            if (var1_1 >= var5_2.length) {
                                var5_2 = null;
                                ** continue;
                            }
                            break block14;
                            break;
                        }
                        break;
                    }
                }
                var3_3 = 0;
                while (true) {
                    if (var3_3 >= this.findC[var1_1].length) {
                        var1_1 = (byte)(var1_1 + 1);
                        continue block1;
                    }
                    this.findC[var1_1][var3_3] = 2;
                    this.findN[var1_1][var3_3] = 0;
                    var3_3 = (byte)(var3_3 + 1);
                }
                break;
            }
            Ms.i();
            var2_4 = (byte)(Ms.getRandom((int)35) + 1);
            var3_3 = (byte)(var5_2.length - 1);
            while (true) {
                block15: {
                    if (var3_3 > -1) break block15;
                    while (true) {
                        if (var3_3 != -1) ** GOTO lbl21
                        var5_2[var1_1] = var2_4;
                        var1_1 = (byte)(var1_1 + 1);
                        ** continue;
                        break;
                    }
                }
                if (var5_2[var3_3] == var2_4) ** continue;
                var3_3 = (byte)(var3_3 - 1);
            }
        }
        var3_3 = 0;
        while (true) {
            if (var3_3 >= 2) {
                var1_1 = (byte)(var1_1 + 1);
                ** continue;
            }
            do {
                Ms.i();
                var4_5 = (byte)Ms.getRandom((int)(this.num[this.lv][0] * this.num[this.lv][1]));
            } while (this.findN[var4_5 / this.num[this.lv][1]][var4_5 % this.num[this.lv][1]] != 0);
            this.findN[var4_5 / this.num[this.lv][1]][var4_5 % this.num[this.lv][1]] = var5_2[var1_1];
            var3_3 = (byte)(var3_3 + 1);
        }
    }

    public void go(int n, int n2) {
        this.gr.setStringB(this.gr.createString("data/gamec.d"), 160, 0);
        this.gr.setStringB("\u5f00\u59cb\u6e38\u620f#n\u79bb\u5f00\u6e38\u620f", Constants_H.WIDTH, 1);
        this.lv = (byte)n2;
        this.findN = null;
        byte by = this.num[this.lv][0];
        n2 = this.num[this.lv][1];
        this.findN = new byte[by][n2];
        this.findC = null;
        n2 = this.num[this.lv][0];
        by = this.num[this.lv][1];
        this.findC = new byte[n2][by];
        this.length = (byte)9;
        this.go(n);
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key() {
        byte by;
        if (Ms.i().key_delay()) {
            return false;
        }
        if (this.state == 0) {
            if (Ms.i().key_Up_Down()) {
                this.sel = (byte)(this.sel ^ 1);
                return false;
            }
            if (Ms.i().key_S1_Num5()) {
                Ms.i().keyRelease();
                if (this.sel == 0 && this.gr.isMoney(this.sell_money, true)) {
                    this.go(1, this.lv);
                    return false;
                }
                if (this.sel != 1) return false;
                Ms.i().keyRelease();
                this.nullGame();
                return true;
            }
            if (!Ms.i().key_S2()) return false;
            Ms.i().keyRelease();
            this.nullGame();
            return true;
        }
        if (this.state >= 3) return false;
        if (Ms.i().key_Up_Down()) {
            this.ty = Ms.i().select((int)this.ty, 0, this.findN.length - 1);
            return false;
        }
        if (Ms.i().key_Left_Right()) {
            this.tx = Ms.i().select((int)this.tx, 0, this.findN[this.ty].length - 1);
            return false;
        }
        if (!Ms.i().key_S1_Num5()) return false;
        Ms.i().keyRelease();
        if (this.state == 0) {
            this.go(0, this.lv);
            return false;
        }
        if (this.findC[this.ty][this.tx] != 0) return false;
        byte[] byArray = this.findC[this.ty];
        byte by2 = this.tx;
        byArray[by2] = (byte)(byArray[by2] + 1);
        this.state = by = (byte)(this.state + 1);
        if (by != 2) return false;
        this.selx = this.tx;
        this.sely = this.ty;
        return false;
    }

    public void patin() {
        this.draw0(10, 2, 280);
        if (this.state != 0) {
            this.drawGame(10, 2, (this.length + 3) * 25);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void run() {
        block9: {
            block11: {
                block10: {
                    block7: {
                        block8: {
                            block6: {
                                if (this.time >= 1) break block6;
                                if (this.time == 0) {
                                    this.time = (byte)-1;
                                    this.gr.say("\u6e38\u620f\u5931\u8d25\uff01\uff01\uff01", -1);
lbl5:
                                    // 12 sources

                                    return;
                                }
                                if (this.time == -1 && this.gr.say_c == 0) {
                                    this.go(0, this.lv);
                                }
                                ** GOTO lbl5
                            }
                            if (this.find_count >= 1) break block7;
                            if (this.find_count != 0) break block8;
                            this.find_count = (byte)-1;
                            var5_1 /* !! */  = this.gr;
                            var5_1 /* !! */ .money += this.time * 125 + 100;
                            this.gr.say("\u83b7\u5f97\u91d1\u94b1\uff1a" + (this.time * 125 + 100), -1);
                            var5_1 /* !! */  = (GameRun)this.gr.rmsOther;
                            var5_1 /* !! */ [8] = (GameRun)((byte)(var5_1 /* !! */ [8] | 1 << this.lv));
                            ** GOTO lbl5
                        }
                        if (this.find_count != -1 || this.gr.say_c != 0) ** GOTO lbl5
                        this.go(0, this.lv);
                        ** GOTO lbl5
                    }
                    if (this.state < 3) break block9;
                    this.state = var1_2 = (byte)(this.state + 1);
                    if (var1_2 <= 10) break block10;
                    this.state = 1;
                    ** GOTO lbl5
                }
                if (this.state != 10) ** GOTO lbl5
                if (this.findN[this.ty][this.tx] == this.findN[this.sely][this.selx]) break block11;
                this.findC[this.ty][this.tx] = 3;
                this.findC[this.sely][this.selx] = 3;
                this.time = (byte)(this.time - 1);
                ** GOTO lbl5
            }
            this.find_count = (byte)(this.find_count - 1);
            ** GOTO lbl5
        }
        if (this.count <= 0) ** GOTO lbl5
        this.count = var2_3 = (short)(this.count - 1);
        if (var2_3 != 0) ** GOTO lbl5
        var3_4 = 0;
        block1: while (true) {
            if (var3_4 < this.findC.length) ** break;
            ** continue;
            var4_5 = 0;
            while (true) {
                if (var4_5 >= this.findC[var3_4].length) {
                    var3_4 = (byte)(var3_4 + 1);
                    continue block1;
                }
                this.findC[var3_4][var4_5] = 3;
                var4_5 = (byte)(var4_5 + 1);
            }
            break;
        }
    }
}
