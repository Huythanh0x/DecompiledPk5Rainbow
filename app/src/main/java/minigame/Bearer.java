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

public class Bearer
implements MiniGame_H {
    private final byte SPEED;
    private short ballC0;
    private short ballC1;
    private short[][] ballDate;
    private byte[] ball_time;
    private Sprite bsp;
    private short count;
    private byte cur;
    private short[][] gDate = new short[][]{{9, 1, 10, 2, 11, 4, 27, 8, 2, -10}, {50, 100, 150, 200}, {60, 40, 30, 10}, {8, 6, 13, 3, 20, 5, 30, 10}};
    GameRun gr;
    private Image img;
    private byte length;
    private byte lv;
    private short[] money;
    private short[] myxy;
    byte sel;
    private Sprite[] sp;
    private byte state;
    private short time0;
    private short time1;
    private short[][] xy;

    public Bearer(GameRun gameRun) {
        this.ballDate = new short[][]{{10, 20, 60, 10, 220}, {13, 40, 60, 12, 170}, {10, 40, 60, 10, 120}};
        this.money = new short[]{150, 200, 300, 450};
        this.xy = new short[40][7];
        short[] sArray = new short[5];
        sArray[1] = 275;
        sArray[2] = 67;
        sArray[3] = 10;
        this.myxy = sArray;
        this.ball_time = new byte[]{20, 15, 10, 5};
        this.SPEED = (byte)10;
        this.gr = gameRun;
    }

    private void addBall(int n) {
        byte by;
        this.xy[this.cur][0] = -20;
        this.xy[this.cur][1] = this.ballDate[n][4];
        this.xy[this.cur][2] = (short)(this.ballDate[n][1] / this.ballDate[n][0]);
        this.xy[this.cur][4] = this.ballDate[n][0];
        this.xy[this.cur][5] = (short)n;
        this.xy[this.cur][3] = this.ballDate[n][3];
        short[] sArray = this.xy[this.cur];
        Ms.i();
        sArray[6] = (short)Ms.getRandom((int)(this.gDate[0].length >> 1));
        this.cur = by = (byte)(this.cur + 1);
        if (by >= this.xy.length) {
            this.cur = 0;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void draw0(int var1_1, int var2_2, int var3_3) {
        block18: {
            block15: {
                block17: {
                    block16: {
                        var5_4 = var3_3 + 45;
                        Ui.i().fillRectB();
                        Ui.i().drawK(var1_1, var2_2 + 25 + 5, 200 - 10, var5_4, 4);
                        Ui.i().drawK(var1_1 + 200 + 10, var2_2 + 25 + 5, 200, var5_4, 4);
                        Ui.i().drawK(var1_1 + 420 + 10, var2_2 + 25 + 5, 200 - 10, var5_4, 4);
                        Ui.i().drawString("\u6e38\u620f\u89c4\u5219", 320, var2_2 + 25 + 5, 33, 3, 1);
                        Ui.i().drawUi(7, 320 - 50 - 5, var2_2 + 25 - 4, 40, 0);
                        Ui.i().drawUi(7, 320 + 50 + 5, var2_2 + 25 - 4, 36, 4);
                        Ui.i().drawStringY(this.gr.about_a, 25, var2_2 + 75 + 10, 25, 0, 0);
                        var3_3 = var2_2 + 100;
                        Ui.i().drawString("\u7403\u7684\u5206\u6570\uff1a", var1_1 + 420 + 20, var3_3, 0, 0, 0);
                        var6_5 = var3_3 + 50;
                        var3_3 = 0;
                        block0: while (true) {
                            if (var3_3 >= this.gDate[0].length) {
                                Ui.i().drawListKY(2, var1_1 + 200 + 12 + 25, var6_5 -= 50, 200 - 50, 3, 30, 10, (int)this.sel, 4, 2);
                                var3_3 = 0;
lbl18:
                                // 2 sources

                                while (true) {
                                    if (var3_3 >= this.gr.about_b.length) {
                                        this.gr.showStringM("\u9700\u8981\u7684\u53c2\u52a0\u8d39\uff1a" + this.money[this.lv] + "\u91d1", 320, var2_2 + var5_4 - 50, 7, 0);
                                        this.gr.drawMoney(320, 360, 3, false);
                                        if (this.state == 0) {
                                            Ui.i().drawYesNo(true, true);
                                        }
                                        return;
                                    }
                                    break block15;
                                    break;
                                }
                            }
                            var8_8 /* !! */  = this.gr;
                            var7_7 = this.gDate[0][var3_3];
                            if (var3_3 % 4 != 2) break;
                            var4_6 = 100;
lbl30:
                            // 2 sources

                            while (true) {
                                var8_8 /* !! */ .drawItem((int)var7_7, var1_1 + 420 + 25 + var4_6, (var3_3 >> 2) * 30 + var6_5, 0);
                                var9_9 = Ui.i();
                                if (this.gDate[0][var3_3 + 1] >= 0) break block16;
                                var8_8 /* !! */  = "";
lbl35:
                                // 2 sources

                                while (true) {
                                    var8_8 /* !! */  = String.valueOf(var8_8 /* !! */ ) + this.gDate[0][var3_3 + 1];
                                    if (var3_3 % 4 == 2) {
                                        var4_6 = 100;
lbl39:
                                        // 2 sources

                                        while (true) {
                                            var9_9.drawString((String)var8_8 /* !! */ , var1_1 + 420 + 25 + var4_6 + 16, (var3_3 >> 2) * 30 + var6_5 - 4, 0, 0, 1);
                                            var3_3 += 2;
                                            continue block0;
                                            break;
                                        }
                                    }
                                    break block17;
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        var4_6 = 0;
                        ** while (true)
                    }
                    var8_8 /* !! */  = "+";
                    ** while (true)
                }
                var4_6 = 0;
                ** while (true)
            }
            System.out.println("i   " + var3_3);
            var9_9 = Ui.i();
            var8_8 /* !! */  = this.gr.about_b[var3_3].toString();
            if (this.sel == var3_3) {
                var4_6 = 0;
lbl58:
                // 2 sources

                while (true) {
                    var9_9.drawString((String)var8_8 /* !! */ , var1_1 + 200 + 15 + 25 + 26, var3_3 * 40 + var6_5 - 2, 0, var4_6, 1);
                    if (this.gr.pkey.isSelect(var1_1 + 200 + 12 + 25, var3_3 * 40 + var6_5 - 2, 200 - 50, 40)) {
                        System.out.println("asdfasfaf");
                        if (this.sel != var3_3) break block18;
                        this.gr.pkey.setKey5();
                    }
lbl64:
                    // 4 sources

                    while (true) {
                        ++var3_3;
                        ** continue;
                        break;
                    }
                    break;
                }
            }
            var4_6 = 3;
            ** while (true)
        }
        this.sel = (byte)var3_3;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawGame(int var1_1, int var2_2, int var3_3, int var4_4) {
        block7: {
            Ui.i().fillRect(5423359, var1_1, var2_2, var3_3, var4_4);
            Ui.i().drawFrameOne(this.bsp, 0, var1_1 + (var3_3 >> 1), var2_2 + (var4_4 >> 1), 0);
            Ui.i().drawString("\u5206\u6570\uff1a" + this.count, (var3_3 >> 1) + var1_1 - 25, var2_2, 24, 3, 1);
            Ui.i().drawString("\u7403\u603b\u6570\uff1a" + this.ballC0, (var3_3 >> 1) + var1_1 + 25, var2_2, 20, 3, 1);
            Ui.i().drawImage(this.img, var1_1 + var3_3, var4_4 - 15, 40);
            var3_3 = 0;
            block0: while (true) {
                if (var3_3 >= this.xy.length) {
                    var3_3 = 0;
lbl10:
                    // 2 sources

                    while (true) {
                        if (var3_3 >= 2) {
                            this.gr.drawMoney(320, 360, 3, false);
                            return;
                        }
                        break block7;
                        break;
                    }
                }
                if (this.xy[var3_3][5] != -1) break;
lbl16:
                // 2 sources

                while (true) {
                    var3_3 = (byte)(var3_3 + 1);
                    continue block0;
                    break;
                }
                break;
            }
            this.gr.drawItem((int)this.gDate[0][this.xy[var3_3][6] << 1], this.xy[var3_3][0] + var1_1, this.xy[var3_3][1] + var2_2, 0);
            ** while (true)
        }
        var5_5 = Ui.i();
        var6_6 = this.sp[0];
        if (this.myxy[4] == 0) {
            var4_4 = 3;
lbl26:
            // 2 sources

            while (true) {
                var5_5.drawFrameOne(var6_6, var4_4, this.myxy[0] + var1_1 + var3_3 * 30 + 20, this.myxy[1] + var2_2 + 25, 0);
                var3_3 = (byte)(var3_3 + 1);
                ** continue;
                break;
            }
        }
        var4_4 = 4;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void getAY(int var1_1) {
        block2: {
            if (this.xy[var1_1][4] > 0 && this.xy[var1_1][3] > 1) {
                var2_2 = this.xy[var1_1];
                var2_2[3] = (short)(var2_2[3] - 1);
lbl4:
                // 4 sources

                return;
            }
            if (this.xy[var1_1][4] != 0) break block2;
            this.xy[var1_1][3] = 0;
            ** GOTO lbl4
        }
        if (this.xy[var1_1][4] >= 0 || this.xy[var1_1][3] <= -this.ballDate[this.xy[var1_1][5]][3]) ** GOTO lbl4
        var2_3 = this.xy[var1_1];
        var2_3[3] = (short)(var2_3[3] - 1);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void initABall(boolean var1_1) {
        if (var1_1) {
            var2_2 = 10;
lbl3:
            // 2 sources

            while (true) {
                this.time0 = (short)var2_2;
                this.time1 = this.ball_time[this.lv];
                Ms.i();
                this.ballC1 = (short)(Ms.getRandom((int)this.gDate[3][this.lv << 1]) + this.gDate[3][(this.lv << 1) + 1]);
                return;
            }
        }
        var2_2 = this.gDate[2][this.lv];
        ** while (true)
    }

    private boolean isCollision(int n) {
        return Ms.i().isRect((int)this.myxy[0], (int)this.myxy[1], (int)this.myxy[2], (int)this.myxy[3], (int)this.xy[n][0], (int)this.xy[n][1], 16, 16);
    }

    /*
     * Unable to fully structure code
     */
    private boolean isSrc(int var1_1) {
        block3: {
            if (this.xy[var1_1][1] <= 320 + 10) break block3;
            var2_2 = true;
lbl3:
            // 2 sources

            while (true) {
                block5: {
                    block4: {
                        if (Ms.i().isRect(240 - 10, 320 - 40, 20, 10, (int)this.xy[var1_1][0], (int)this.xy[var1_1][1], 16, 16)) break block4;
                        var3_3 = var2_2;
                        if (this.xy[var1_1][0] <= 240) break block5;
                        var3_3 = var2_2;
                        if (this.xy[var1_1][1] >= this.myxy[1]) break block5;
                    }
                    var3_3 = true;
                    this.count = (short)(this.count + this.gDate[0][this.xy[var1_1][6] * 2 + 1]);
                }
                return var3_3;
            }
        }
        var2_2 = false;
        ** while (true)
    }

    private void nullGame() {
        this.gDate = null;
        this.money = null;
        this.sp = null;
        this.img = null;
        this.ballDate = null;
    }

    /*
     * Unable to fully structure code
     */
    public void go(int var1_1) {
        if (var1_1 < 1) {
            this.state = 0;
            this.length = (byte)10;
            this.gr.setStringB("\u5728\u9650\u5b9a\u65f6\u95f4\u91cc\u63a5\u5c3d\u91cf\u591a\u7684\u7403\u5230\u6846\u91cc\uff0c\u6700\u540e\u6839\u636e\u6846\u91cc\u7403\u7684\u5206\u6570\u6765\u6362\u53d6\u91d1\u94b1\u3002", 160, 0);
            this.gr.setStringB("\u5f00\u59cb\u6e38\u620f#n\u79bb\u5f00\u6e38\u620f", Constants_H.WIDTH, 1);
lbl6:
            // 3 sources

            return;
        }
        if (var1_1 != 1) ** GOTO lbl6
        this.state = 1;
        this.count = 0;
        this.cur = 0;
        this.ballC0 = this.gDate[1][this.lv];
        this.initABall(true);
        var1_1 = 0;
        while (true) {
            if (var1_1 < this.xy.length) ** break;
            ** continue;
            this.xy[var1_1][5] = -1;
            var1_1 = (byte)(var1_1 + 1);
        }
    }

    public void go(int n, int n2) {
        this.lv = (byte)n2;
        this.sp = new Sprite[2];
        this.sp[0] = Ms.i().createSprite("data/npc2/38", true);
        this.img = Ms.i().createImage("data/brow/m0");
        byte[] byArray = Ms.i().getStream("data/gamee.data", -1);
        Ms.i();
        Ms.skip = 0;
        this.bsp = Sprite.Create((Image)Ms.i().createImage("data/map/5"), (short[][])Ms.i().createShort2Array(byArray, 2), (short[][][])Ms.i().createShort3Array(byArray, 2), (short[][][])Ms.i().createShort3Array(byArray, 2));
        this.go(n);
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key() {
        if (this.state == 0) {
            if (Ms.i().key_Up_Down()) {
                this.sel = (byte)(this.sel ^ 1);
                return false;
            }
            if (Ms.i().key_S1_Num5()) {
                Ms.i().keyRelease();
                if (this.sel == 0 && this.gr.isMoney((int)this.money[this.lv], true)) {
                    this.go(1);
                    return false;
                }
                if (this.sel != 1) return false;
                Ms.i().keyRelease();
                this.nullGame();
                return true;
            }
            if (!Ms.i().key_S2()) return false;
            this.nullGame();
            return true;
        }
        if (this.state != 1) return false;
        if (Ms.i().key_Left()) {
            short[] sArray = this.myxy;
            sArray[0] = (short)(sArray[0] - 10);
            if (this.myxy[0] >= 0) return false;
            this.myxy[0] = 0;
            return false;
        }
        if (!Ms.i().key_Right()) return false;
        short[] sArray = this.myxy;
        sArray[0] = (short)(sArray[0] + 10);
        if (this.myxy[0] + this.myxy[2] <= 220) return false;
        this.myxy[0] = (short)(240 - this.myxy[2] - 20);
        return false;
    }

    public void patin() {
        this.draw0(10, 2, this.length * 25);
        if (this.state != 0) {
            this.drawGame(200, 0, 240, 320);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void run() {
        block11: {
            block16: {
                block10: {
                    block15: {
                        block14: {
                            block13: {
                                block12: {
                                    if (this.state != 1) break block11;
                                    if (this.ballC0 <= 0) break block12;
                                    if (this.time0 <= 0) break block13;
                                    this.time0 = (short)(this.time0 - 1);
                                }
lbl6:
                                // 5 sources

                                while (true) {
                                    if (this.myxy[4] > 0) {
                                        var4_1 /* !! */  = this.myxy;
                                        var4_1 /* !! */ [4] = (short)(var4_1 /* !! */ [4] - 1);
                                    }
                                    var2_2 = true;
                                    var1_3 = 0;
lbl12:
                                    // 2 sources

                                    while (true) {
                                        if (var1_3 >= this.xy.length) {
                                            if (this.ballC0 < 1 && var2_2) {
                                                this.count = (short)(this.count * 15 / 10);
                                                var4_1 /* !! */  = (short[])this.gr;
                                                var4_1 /* !! */ .money += this.count;
                                                this.gr.say("\u83b7\u5f97\uff1a" + this.count + "\u91d1", 0);
                                                if (this.count > 0) {
                                                    var4_1 /* !! */  = this.gr.rmsOther;
                                                    var4_1 /* !! */ [6] = (byte)(var4_1 /* !! */ [6] | 1 << this.lv);
                                                }
                                                this.state = (byte)2;
                                            }
                                            this.gr.pkey.checkButton(4);
lbl25:
                                            // 3 sources

                                            return;
                                        }
                                        break block10;
                                        break;
                                    }
                                    break;
                                }
                            }
                            if (this.time1 <= 0) break block14;
                            this.time1 = (short)(this.time1 - 1);
                            ** GOTO lbl6
                        }
                        if (this.ballC1 <= 0) break block15;
                        this.time1 = this.ball_time[this.lv];
                        this.addBall(Ms.getRandom((int)this.ballDate.length));
                        this.ballC1 = (short)(this.ballC1 - 1);
                        this.ballC0 = (short)(this.ballC0 - 1);
                        ** GOTO lbl6
                    }
                    if (this.ballC1 != 0) ** GOTO lbl6
                    this.initABall(false);
                    ** while (true)
                }
                if (this.xy[var1_3][5] == -1) lbl-1000:
                // 4 sources

                {
                    while (true) {
                        var1_3 = (byte)(var1_3 + 1);
                        ** continue;
                        break;
                    }
                }
                var3_4 = false;
                var4_1 /* !! */  = this.xy[var1_3];
                var4_1 /* !! */ [0] = (short)(var4_1 /* !! */ [0] + this.xy[var1_3][2]);
                var4_1 /* !! */  = this.xy[var1_3];
                var4_1 /* !! */ [1] = (short)(var4_1 /* !! */ [1] - this.xy[var1_3][3]);
                this.getAY(var1_3);
                var4_1 /* !! */  = this.xy[var1_3];
                var4_1 /* !! */ [4] = (short)(var4_1 /* !! */ [4] - 1);
                if (!this.isSrc(var1_3)) break block16;
                this.xy[var1_3][5] = -1;
                var2_2 = var3_4;
                ** GOTO lbl-1000
            }
            var2_2 = var3_4;
            if (!this.isCollision(var1_3)) ** GOTO lbl-1000
            this.xy[var1_3][4] = this.ballDate[this.xy[var1_3][5]][0];
            this.myxy[4] = 1;
            this.xy[var1_3][3] = this.ballDate[this.xy[var1_3][5]][3];
            var2_2 = var3_4;
            ** while (true)
        }
        if (this.state != 2 || this.gr.say_c != 0) ** GOTO lbl25
        this.go(0);
        ** while (true)
    }

    public void setLv(int n) {
        this.lv = (byte)n;
    }
}
