/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  dm.Ms
 *  main.GameRun
 *  main.Key_H
 */
package dm;

import dm.Ms;
import main.GameRun;
import main.Key_H;

public class Monster
implements Key_H {
    public byte effect;
    public byte effect_time;
    public byte[] monster;
    public short[] monsterPro;

    public Monster() {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public Monster(GameRun var1_1, int var2_2, int var3_3, int var4_4) {
        block11: {
            block12: {
                super();
                this.monsterPro = new short[8];
                this.monster = new byte[18];
                this.monster[0] = (byte)var2_2;
                this.monster[2] = (byte)var3_3;
                var6_5 = var1_1 /* !! */ .monster_pro[var2_2];
                this.monster[3] = var6_5[6];
                this.monster[4] = var6_5[5];
                this.monster[5] = var6_5[12];
                this.monster[8] = 25;
                this.monster[9] = -1;
                this.monster[10] = -1;
                this.monster[11] = -1;
                this.monster[12] = -1;
                this.monster[13] = -1;
                this.monster[14] = -1;
                this.monster[15] = -1;
                if (var4_4 == -1) {
                    this.monster[16] = (byte)(this.monster[3] * 2 + 4);
                    this.monster[17] = 2;
lbl21:
                    // 4 sources

                    while (true) {
                        var7_6 = this.monster;
                        if (this.monster[4] > 3) {
                            var4_4 = 120;
lbl25:
                            // 2 sources

                            while (true) {
                                var7_6[6] = (byte)var4_4;
                                this.monsterPro[2] = (short)(var6_5[0] + var6_5[7] * var3_3 / 10);
                                this.monsterPro[3] = (short)(var6_5[1] + var6_5[8] * var3_3 / 10);
                                this.monsterPro[1] = this.monsterPro[3];
                                this.monsterPro[0] = this.monsterPro[2];
                                this.monsterPro[4] = 0;
                                this.setProAFD(var6_5);
                                if (this.monster[3] != -1) {
                                    var1_1 /* !! */ .getMagic(this);
                                }
                                if (var1_1 /* !! */ .monInfoList[var2_2] == 0) {
                                    var1_1 /* !! */ .monInfoList[var2_2] = 1;
                                    var6_5 = var1_1 /* !! */ .monInfoList;
                                    var6_5[102] = (byte)(var6_5[102] + 1);
                                    var1_1 /* !! */ .say("\u5ba0\u7269\u56fe\u9274\u5df2\u66f4\u65b0", 0);
                                }
                                this.effect = (byte)7;
                                this.effect_time = 0;
                                var1_1 /* !! */  = (GameRun)((byte[])null);
                                return;
                            }
                        }
                        break block11;
                        break;
                    }
                }
                if (var4_4 != 0) break block12;
                var7_6 = this.monster;
                var4_4 = this.monster[3];
                Ms.i();
                var7_6[16] = (byte)(var4_4 * 2 + 3 + Ms.getRandom((int)2));
                var7_6 = this.monster;
                Ms.i();
                var7_6[17] = (byte)Ms.getRandom((int)3);
                ** GOTO lbl21
            }
            if (var4_4 != 1) ** GOTO lbl21
            var7_6 = this.monster;
            var5_7 = this.monster[3];
            Ms.i();
            if (Ms.getRandom((int)100) < 70) {
                var4_4 = 1;
lbl64:
                // 2 sources

                while (true) {
                    var7_6[16] = (byte)(var5_7 * 2 + 3 + var4_4);
                    var7_6 = this.monster;
                    Ms.i();
                    if (Ms.getRandom((int)100) < 70) {
                        var4_4 = 2;
lbl71:
                        // 2 sources

                        while (true) {
                            var7_6[17] = (byte)var4_4;
                            ** continue;
                            break;
                        }
                    }
                    break;
                }
            } else {
                var4_4 = 0;
                ** continue;
            }
            Ms.i();
            var4_4 = Ms.getRandom((int)2);
            ** while (true)
        }
        var4_4 = 100;
        ** while (true)
    }

    public void evolveMonster(GameRun gameRun, int n, int n2) {
        this.monster[0] = (byte)n;
        byte[] byArray = gameRun.monster_pro[n];
        this.monster[4] = byArray[5];
        byte[] byArray2 = this.monster;
        byArray2[5] = (byte)(byArray2[5] - n2);
        this.setProAFD(byArray);
        this.monsterPro[2] = (short)(byArray[0] + byArray[7] * this.monster[2] / 10);
        this.monsterPro[3] = (short)(byArray[1] + byArray[8] * this.monster[2] / 10);
        this.resetPro(gameRun);
        this.monsterPro[1] = this.monsterPro[3];
        byArray2 = null;
        if (gameRun.monInfoList[n] != 2) {
            if (gameRun.monInfoList[n] == 0) {
                byArray2 = gameRun.monInfoList;
                byArray2[102] = (byte)(byArray2[102] + 1);
            }
            gameRun.addMonInfoListBH();
            gameRun.monInfoList[n] = 2;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isBuffRate(int n) {
        if (this.monster[16] == n) return true;
        if (this.monster[17] == n) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isEffect(int n) {
        if (this.effect != n) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isMonEffect(int n) {
        if (this.effect != n) return false;
        if (this.effect_time == 0) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isMonReel(int n) {
        if (this.monster[14] == n) return true;
        if (this.monster[15] == n) return true;
        return false;
    }

    public void resetBoss(int n) {
        this.monster[16] = 4;
        this.monster[17] = 10;
        this.monster[9] = 4;
        this.monster[10] = 9;
        this.monster[11] = 14;
        this.monster[12] = 19;
        this.monster[13] = 24;
        this.monster[14] = 30;
        this.monster[15] = 48;
        this.monster[6] = (byte)n;
    }

    public void resetMonster(int n, int n2, int n3) {
        this.monster[16] = (byte)(this.monster[3] * 2 + 4);
        this.monster[17] = 2;
        this.monster[14] = (byte)n;
        this.monster[15] = (byte)n2;
        this.monster[6] = (byte)n3;
    }

    /*
     * Unable to fully structure code
     */
    public void resetMonster(GameRun var1_1, int var2_2) {
        if (var2_2 > -1) {
            this.monster[5] = (byte)var2_2;
lbl3:
            // 3 sources

            while (true) {
                this.resetPro(var1_1);
                return;
            }
        }
        if (var2_2 != -1) ** GOTO lbl3
        var3_3 = this.monster;
        Ms.i();
        var3_3[5] = (byte)Ms.getRandom((int)(this.monster[5] + 1));
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void resetPro(GameRun var1_1) {
        if (this.isBuffRate(2)) {
            var2_2 = this.monsterPro;
            var2_2[2] = (short)(var2_2[2] + this.monsterPro[2] * var1_1.inhesion[2] / 100);
lbl4:
            // 3 sources

            while (true) {
                if (this.monsterPro[2] < 1) {
                    this.monsterPro[2] = 1;
                }
                this.monsterPro[0] = this.monsterPro[2];
                return;
            }
        }
        if (!this.isBuffRate(1)) ** GOTO lbl4
        var2_3 = this.monsterPro;
        var2_3[2] = (short)(var2_3[2] + this.monsterPro[2] * var1_1.inhesion[1] / 100);
        ** while (true)
    }

    public void setProAFD(byte[] byArray) {
        this.monsterPro[5] = (short)(byArray[2] + byArray[9] * this.monster[2] / 10);
        this.monsterPro[6] = (short)(byArray[3] + byArray[10] * this.monster[2] / 10);
        this.monsterPro[7] = (short)(byArray[4] + byArray[11] * this.monster[2] / 10);
    }
}
