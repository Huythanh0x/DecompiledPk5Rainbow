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

public class Racing
implements MiniGame_H {
    private final short MAP_HEIGHT;
    private final byte NUM = (byte)4;
    private final short WIN_HEIGHT;
    private short[][] cloud;
    private short[][] gDate;
    GameRun gr;
    private Image imgCloud;
    private byte length;
    private byte lv;
    private short[] monY;
    private short[] money;
    private byte[] myDate;
    private byte[][] now_a;
    private byte sel;
    private Sprite[] sp;
    private byte speedLv;
    private short srcY;
    private byte state;
    private byte time;

    public Racing(GameRun gameRun) {
        this.MAP_HEIGHT = (short)450;
        this.WIN_HEIGHT = (short)70;
        this.now_a = new byte[4][3];
        byte[] byArray = new byte[4];
        byArray[3] = -1;
        this.myDate = byArray;
        this.cloud = new short[10][3];
        this.monY = new short[4];
        this.money = new short[]{100, 120, 300, 350, 1000, 1200};
        this.gDate = new short[][]{{450, 3, 8}, {390, 4, 9}, {270, 7, 6}, {210, 6, 10}};
        this.gr = gameRun;
    }

    private void addCloud(int n) {
        short[] sArray = this.cloud[n];
        Ms.i();
        sArray[0] = (short)(Ms.getRandom((int)Constants_H.WIDTH_H) + 640);
        sArray = this.cloud[n];
        short s = this.srcY;
        Ms.i();
        sArray[1] = (short)(s - 80 + (Ms.getRandom((int)25) + 55) * n);
        sArray = this.cloud[n];
        Ms.i();
        sArray[2] = (short)(Ms.getRandom((int)5) + 2);
    }

    /*
     * Unable to fully structure code
     */
    private void draw0(int var1_1, int var2_2, int var3_3, int var4_4) {
        Ui.i().fillRectB();
        Ui.i().drawString("\u6e38\u620f\u89c4\u5219", 320, var2_2 + var4_4 + 3, 33, 3, 1);
        Ui.i().drawUi(7, 320 - 50, var2_2 + var4_4 - 13, 40, 0);
        Ui.i().drawUi(7, 320 + 50, var2_2 + var4_4 - 13, 36, 4);
        Ui.i().drawK(var1_1, var2_2 + var4_4 + 3, 200, var3_3, 4);
        Ui.i().drawK(var1_1 + 200 + 10, var2_2 + var4_4 + 3, 200, var3_3, 4);
        this.gr.showStringM("\u9009\u62e9\u4f60\u8ba4\u4e3a\u4f1a\u5f97\u7b2c\u4e00\u7684\u4e00\u53ea\u5ba0\u7269\u548c\u62bc\u6ce8\u7684\u5927\u5c0f\uff0c\u6ce8\u6570\u8d8a\u5927\u83b7\u80dc\u540e\u7684\u5956\u52b1\u8d8a\u4e30\u539a\uff01", var1_1 + 100, var2_2 + var4_4 + 15, 7, 0);
        Ui.i().drawK(var1_1 + 420, var2_2 + var4_4 + 3, 200, var3_3, 4);
        Ui.i().drawStringY(this.gr.about_a, var1_1 + 420 + 25, var2_2 + var4_4 + 15, var4_4, 0, 0);
        if (this.state != 0) ** GOTO lbl16
        Ui.i().drawString("\u8bf7\u9009\u62e9\u62bc\u6ce8\u5927\u5c0f\uff1a", var1_1 + 200 + 10, var2_2 + var4_4 + 15, 0, 0, 0);
        var3_3 = 0;
        block0: while (true) {
            block6: {
                if (var3_3 < this.length) break block6;
                Ui.i().drawK4(var1_1 + 200 + 10 + 25 + 14, var2_2 + var4_4 + 50 + this.sel * (var4_4 + 16), 150, var4_4 + 4);
lbl16:
                // 2 sources

                this.gr.drawMoney(320, 360, 3, false);
                Ui.i().drawYesNo(true, true);
                return;
            }
            Ui.i().drawK(var1_1 + 200 + 10 + 25 + 14, var2_2 + var4_4 + 50 + (var4_4 + 16) * var3_3, 150, var4_4 + 4, 1);
            Ui.i().drawString(this.gr.about_b[var3_3].toString(), var1_1 + 200 + 10 + 25 + 14, var2_2 + var4_4 + 50 + (var4_4 + 16) * var3_3, 0, 3, 0);
            if (this.gr.pkey.isSelect(var1_1 + 200 + 10 + 25 + 14, var2_2 + var4_4 + 50 + (var4_4 + 16) * var3_3, 150, var4_4 + 4)) {
                if (this.sel != var3_3) break;
                this.gr.pkey.setKey5();
            }
lbl25:
            // 4 sources

            while (true) {
                ++var3_3;
                continue block0;
                break;
            }
            break;
        }
        this.sel = (byte)var3_3;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void draw1(int var1_1, int var2_2, int var3_3) {
        block15: {
            block14: {
                block13: {
                    block12: {
                        block16: {
                            Ui.i().drawK(215, 33, 210, 325, 4);
                            var5_4 = 0;
                            block0: while (true) {
                                if (var5_4 >= this.length) {
                                    if (this.state == 1) {
                                        Ui.i().drawK4(var1_1 + 25 + this.sel * 52, var2_2 + 25 + 10, 44, 76);
                                        Ui.i().drawTriangle(320, var2_2 + 25 + 49, 116, true, true);
                                        var4_9 = this.gr.pkey.selectMenuX(4, 320 - 116, var2_2 + 25 + 10, 52, var3_3);
                                        if (var4_9 != -1) {
                                            if (this.sel != var4_9) break block12;
                                            this.gr.pkey.setKey5();
                                        }
                                    }
lbl12:
                                    // 6 sources

                                    while (true) {
                                        Ui.i().drawString("\u5174\u594b\u5ea6\uff1a", var1_1 + 25, var2_2 + 25 + 13 + var3_3, 0, 0, 0);
                                        this.gr.drawFealty(6, 2, var1_1 + 125, var2_2 + 25 + 19 + var3_3);
                                        this.gr.showStringM("\u6bcf\u5582\u4e00\u4e2a\u5174\u594b\u83c7\u82b1\u8d3910\u91d1\uff0c\u53ef\u589e\u52a0\u4e00\u683c\u5174\u594b\u5ea6\u3002", 320, var2_2 + 50 + 19 + var3_3, 8, 0);
                                        var3_3 = var3_3 + 69 + 25 + 75;
                                        Ui.i().drawString("\u8bf7\u9009\u62e9\u9053\u5177\uff1a", var1_1 + 25, var2_2 + var3_3, 0, 0, 0);
                                        var5_4 = var3_3 + 25 + 3;
                                        var3_3 = 0;
lbl20:
                                        // 2 sources

                                        while (true) {
                                            if (var3_3 < this.length) break block13;
                                            if (this.state == 2) {
                                                Ui.i().drawK4(var1_1 + 25 + this.sel * 52, var2_2 + var5_4, 44, 34);
                                                Ui.i().drawTriangle(320, var2_2 + var5_4 + 14, 116, true, true);
                                                var4_9 = this.gr.pkey.selectMenuX(4, 320 - 116, var2_2 + var5_4 + 8, 52, 34);
                                                if (var4_9 != -1) {
                                                    if (this.sel != var4_9) break block14;
                                                    this.gr.pkey.setKey5();
                                                }
                                            }
lbl29:
                                            // 6 sources

                                            while (true) {
                                                var7_6 = Ui.i();
                                                if (this.state != 1) {
                                                    var6_5 = true;
lbl33:
                                                    // 2 sources

                                                    while (true) {
                                                        var7_6.drawYesNo(true, var6_5);
                                                        return;
                                                    }
                                                }
                                                break block15;
                                                break;
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                }
                                Ui.i().drawK(var1_1 + 25 + var5_4 * 52, var2_2 + 25 + 10, 44, var3_3, 1);
                                var7_6 = Ui.i();
                                var9_8 = this.sp[0];
                                var8_7 = this.now_a[var5_4];
                                if (this.state != 1) break block16;
                                if (this.sel != var5_4) break;
                                var6_5 = true;
lbl44:
                                // 3 sources

                                while (true) {
                                    var7_6.drawActionOne(var9_8, 0, var1_1 + 25 + var5_4 * 52 + 22, var2_2 + 25 + 8 + var3_3, var8_7, 0, var6_5);
                                    Ui.i().drawNum("" + (var5_4 + 1), var1_1 + 25 + var5_4 * 52 + 27, var2_2 + 50 + 12, 20, 2);
                                    var5_4 = (byte)(var5_4 + 1);
                                    continue block0;
                                    break;
                                }
                                break;
                            }
                            var6_5 = false;
                            ** GOTO lbl44
                        }
                        var6_5 = false;
                        ** while (true)
                    }
                    this.sel = var4_9;
                    ** while (true)
                }
                Ui.i().drawK(var1_1 + 25 + var3_3 * 52, var2_2 + var5_4, 44, 34, 1);
                this.gr.drawItem(12, var1_1 + 25 + var3_3 * 52, var2_2 + var5_4 + 10, 0);
                Ui.i().drawString("x" + var3_3, var1_1 + 25 + var3_3 * 52 + 16, var2_2 + var5_4 + 8, 0, 3, 1);
                var3_3 = (byte)(var3_3 + 1);
                ** while (true)
            }
            this.sel = var4_9;
            ** while (true)
        }
        var6_5 = false;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawCloud() {
        var1_1 = 0;
        block0: while (true) {
            if (var1_1 >= this.cloud.length) {
                var1_1 = 0;
lbl5:
                // 2 sources

                while (true) {
                    if (var1_1 < this.cloud.length) break block0;
                    return;
                }
            }
            Ui.i().drawImage(this.imgCloud, (int)this.cloud[var1_1][0], this.cloud[var1_1][1] - this.srcY, 0);
            var1_1 = (byte)(var1_1 + 1);
        }
        if (this.isNpcSrc(this.cloud[var1_1][0], this.cloud[var1_1][1])) {
            this.addCloud(var1_1);
lbl13:
            // 2 sources

            while (true) {
                var1_1 = (byte)(var1_1 + 1);
                ** continue;
                break;
            }
        }
        var2_2 = this.cloud[var1_1];
        var2_2[0] = (short)(var2_2[0] - this.cloud[var1_1][2]);
        ** while (true)
    }

    private void drawEnd() {
        int n = (640 - 70) / 35;
        Ui.i().drawModuleOne(this.sp[1], 0, 0, 40 - this.srcY, 0, 0);
        int n2 = 0;
        while (true) {
            if (n2 >= n + 1) {
                Ui.i().drawModuleOne(this.sp[1], 0, 640, 40 - this.srcY, 1, 0);
                return;
            }
            Ui.i().drawModuleOne(this.sp[1], 1, n2 * 35 + 35, 44 - this.srcY, 0, 0);
            ++n2;
        }
    }

    private void drawGame() {
        Ui.i().fillRect(5423359, 0, 0, 640, 360);
        this.drawCloud();
        this.drawEnd();
        byte by = 0;
        while (true) {
            if (by >= this.length) {
                if (this.state == 3 && this.time != 0) {
                    Ui.i().drawNum("" + this.time / 20, 320 - 5, 180, 0, 2);
                }
                return;
            }
            Ui.i().drawNum("" + (by + 1), by * 100 + 125 + 22, 20 - this.srcY, 1, 2);
            Ui.i().drawActionOne(this.sp[0], 1, by * 100 + 125 + 22, this.monY[by] - this.srcY, this.now_a[by], 0, true);
            by = (byte)(by + 1);
        }
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isNpcSrc(int n, int n2) {
        if (n < -40) return true;
        if (n2 - this.srcY > Constants_H.HEIGHT + 20) return true;
        return false;
    }

    private void nullGame() {
        this.sp = null;
        this.myDate = null;
        this.money = null;
        this.now_a = null;
        this.monY = null;
        this.imgCloud = null;
        this.cloud = null;
        this.gDate = null;
    }

    /*
     * Unable to fully structure code
     */
    private void setSpeed() {
        if (this.speedLv >= this.gDate.length) lbl-1000:
        // 3 sources

        {
            return;
        }
        var1_1 = 0;
        block1: while (true) {
            block5: {
                if (var1_1 < 4) break block5;
                while (true) {
                    if (var1_1 >= 4) ** GOTO lbl-1000
                    var1_1 = 0;
lbl10:
                    // 2 sources

                    while (true) {
                        if (var1_1 < 4) break block1;
                        this.speedLv = (byte)(this.speedLv + 1);
                        ** continue;
                        break;
                    }
                    break;
                }
            }
            if (this.monY[var1_1] <= this.gDate[this.speedLv][0]) ** continue;
            var1_1 = (byte)(var1_1 + 1);
        }
        var2_2 = this.now_a[var1_1];
        Ms.i();
        var2_2[2] = (byte)(Ms.getRandom((int)this.gDate[this.speedLv][1]) + this.gDate[this.speedLv][1]);
        var1_1 = (byte)(var1_1 + 1);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void go(int var1_1) {
        block6: {
            block5: {
                if (var1_1 < 1) {
                    this.sel = 0;
                    this.state = 0;
                    this.length = (byte)3;
                    this.gr.setStringB("\u4e00\u6ce8\uff1a#n\u6295\u5165100\u91d1\uff0c#n\u83b7\u80dc\u5f97120\u91d1\u3002#n\u4e8c\u6ce8\uff1a#n\u6295\u5165300\u91d1\uff0c#n\u83b7\u80dc\u5f97350\u91d1\u3002#n\u4e09\u6ce8\uff1a#n\u6295\u51651000\u91d1\uff0c#n\u83b7\u80dc\u5f971200\u91d1\u3002", Constants_H.WIDTH - 50, 0);
                    this.gr.setStringB("\u4e00\u6ce8100\u91d1#n\u4e8c\u6ce8300\u91d1#n\u4e09\u6ce81000\u91d1", Constants_H.WIDTH - 50, 1);
lbl7:
                    // 5 sources

                    return;
                }
                if (var1_1 != 1) break block5;
                this.myDate[0] = this.sel;
                this.sel = 0;
                this.state = 1;
                this.length = (byte)4;
                ** GOTO lbl7
            }
            if (var1_1 != 2) break block6;
            this.myDate[1] = this.sel;
            this.sel = 0;
            this.state = (byte)2;
            ** GOTO lbl7
        }
        if (var1_1 != 3) ** GOTO lbl7
        this.myDate[2] = this.sel;
        this.sel = 0;
        this.state = (byte)3;
        this.srcY = (short)90;
        this.speedLv = 0;
        this.myDate[3] = -1;
        this.time = (byte)70;
        var1_1 = 0;
        while (true) {
            if (var1_1 >= this.length) {
                var1_1 = 0;
                while (true) {
                    if (var1_1 < this.cloud.length) ** break;
                    ** continue;
                    this.addCloud(var1_1);
                    var1_1 = (byte)(var1_1 + 1);
                }
            }
            this.monY[var1_1] = 450;
            var1_1 = (byte)(var1_1 + 1);
        }
    }

    public void go(int n, int n2) {
        this.lv = (byte)n2;
        this.sp = new Sprite[3];
        this.sp[0] = Ms.i().createSprite("data/npc0/67", true);
        this.sp[1] = Ms.i().createSprite("data/brow/m1", true);
        this.imgCloud = Ms.i().createImage("data/cloud");
        this.go(n);
    }

    /*
     * Enabled force condition propagation
     */
    public boolean key() {
        if (Ms.i().key_delay()) {
            return false;
        }
        if (this.state == 0) {
            if (Ms.i().key_Up_Down()) {
                this.sel = Ms.i().select((int)this.sel, 0, this.length - 1);
                return false;
            }
            if (Ms.i().key_S1_Num5() && this.gr.isMoney((int)this.money[this.sel << 1], true)) {
                this.go(1);
                return false;
            }
            if (!Ms.i().key_S2()) return false;
            this.nullGame();
            return true;
        }
        if (this.state == 1) {
            if (Ms.i().key_Left_Right()) {
                this.sel = Ms.i().select((int)this.sel, 0, this.length - 1);
                return false;
            }
            if (!Ms.i().key_S1_Num5()) return false;
            this.go(2);
            return false;
        }
        if (this.state != 2) return false;
        if (Ms.i().key_Left_Right()) {
            this.sel = Ms.i().select((int)this.sel, 0, this.length - 1);
            return false;
        }
        if (Ms.i().key_S1_Num5() && this.gr.isMoney(this.sel * 10, true)) {
            this.go(3);
            return false;
        }
        if (!Ms.i().key_S2()) return false;
        this.sel = this.myDate[1];
        this.state = 1;
        return false;
    }

    /*
     * Enabled force condition propagation
     */
    public void patin() {
        if (this.state == 0 || this.state == 1 || this.state == 2) {
            this.draw0(10, 5, 325, 25);
            if (this.state == 1 || this.state == 2) {
                this.draw1(198, 15, 76);
            }
            return;
        }
        this.drawGame();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void run() {
        block13: {
            block12: {
                block11: {
                    block8: {
                        block9: {
                            if (this.state != 3) break block8;
                            if (this.time != 0) break block9;
                            this.setSpeed();
                            if (this.myDate[3] != -1) {
                                this.time = (byte)5;
                                this.state = (byte)4;
lbl7:
                                // 7 sources

                                return;
                            }
                            var2_1 = -1;
                            var1_2 = 0;
                            while (true) {
                                block10: {
                                    if (var1_2 < 4) break block10;
                                    if (var2_1 != -1) {
                                        this.srcY = (short)(this.srcY - this.now_a[var2_1][2]);
                                    }
                                    if (this.srcY < 0) {
                                        this.srcY = 0;
                                    }
                                    ** GOTO lbl7
                                }
                                var3_3 = this.monY;
                                var3_3[var1_2] = (short)(var3_3[var1_2] - this.now_a[var1_2][2]);
                                if (this.monY[var1_2] - this.srcY < Constants_H.HEIGHT_H) {
                                    var2_1 = var1_2;
                                }
                                if (this.monY[var1_2] < 70 && this.myDate[3] == -1) {
                                    this.myDate[3] = var1_2;
                                }
                                var1_2 = (byte)(var1_2 + 1);
                            }
                        }
                        this.time = (byte)(this.time - 1);
                        ** GOTO lbl7
                    }
                    if (this.state != 4) ** GOTO lbl7
                    if (this.time != 3) break block11;
                    if (this.myDate[3] != this.myDate[1]) break block12;
                    var3_4 /* !! */  = this.gr;
                    var3_4 /* !! */ .money += this.money[this.myDate[0] * 2 + 1];
                    this.gr.say("\u83b7\u5f97\uff1a" + this.money[this.myDate[0] * 2 + 1] + "\u91d1", 0);
                    var3_4 /* !! */  = (GameRun)this.gr.rmsOther;
                    var3_4 /* !! */ [4] = (GameRun)((byte)(var3_4 /* !! */ [4] | 1 << this.lv));
                }
lbl40:
                // 2 sources

                while (this.time > 0) {
                    this.time = (byte)(this.time - 1);
                    ** GOTO lbl7
                }
                break block13;
            }
            this.gr.say("\u4e0d\u597d\u610f\u601d\uff0c\u6ca1\u6709\u731c\u5bf9\u3002", 0);
            ** GOTO lbl40
        }
        if (this.time != 0 || this.gr.say_c != 0) ** GOTO lbl7
        this.go(0);
        ** while (true)
    }
}
