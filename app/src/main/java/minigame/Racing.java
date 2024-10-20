package minigame;

import dm.Ms;
import dm.Sprite;
import dm.Ui;
import javax.microedition.lcdui.Image;
import main.Constants_H;
import main.GameRun;

public class Racing implements MiniGame_H {
    private final short MAP_HEIGHT = 450;
    private final byte NUM = 4;
    private final short WIN_HEIGHT = 70;
    private short[][] cloud;
    private short[][] gDate;
    GameRun gr;
    private Image imgCloud;
    private byte length;
    private byte lv;
    private short[] monY;
    private short[] money;
    private byte[] myDate;
    private byte[][] now_a = new byte[4][3];
    private byte sel;
    private Sprite[] sp;
    private byte speedLv;
    private short srcY;
    private byte state;
    private byte time;

    public Racing(GameRun var1) {
        super();
        byte[] var2 = new byte[4];
        var2[3] = -1;
        this.myDate = var2;
        this.cloud = new short[10][3];
        this.monY = new short[4];
        this.money = new short[]{100, 120, 300, 350, 1000, 1200};
        this.gDate = new short[][]{{450, 3, 8}, {390, 4, 9}, {270, 7, 6}, {210, 6, 10}};
        this.gr = var1;
    }

    private void addCloud(int var1) {
        short[] var3 = this.cloud[var1];
        Ms.i();
        var3[0] = (short)(Ms.getRandom(Constants_H.WIDTH_H) + 640);
        var3 = this.cloud[var1];
        short var2 = this.srcY;
        Ms.i();
        var3[1] = (short)(var2 - 80 + (Ms.getRandom(25) + 55) * var1);
        var3 = this.cloud[var1];
        Ms.i();
        var3[2] = (short)(Ms.getRandom(5) + 2);
    }

    private void draw0(int var1, int var2, int var3, int var4) {
        Ui.i().fillRectB();
        Ui.i().drawString("游戏规则", 320, var2 + var4 + 3, 33, 3, 1);
        Ui.i().drawUi(7, 320 - 50, var2 + var4 - 13, 40, 0);
        Ui.i().drawUi(7, 320 + 50, var2 + var4 - 13, 36, 4);
        Ui.i().drawK(var1, var2 + var4 + 3, 200, var3, 4);
        Ui.i().drawK(var1 + 200 + 10, var2 + var4 + 3, 200, var3, 4);
        this.gr.showStringM("选择你认为会得第一的一只宠物和押注的大小，注数越大获胜后的奖励越丰厚！", var1 + 100, var2 + var4 + 15, 7, 0);
        Ui.i().drawK(var1 + 420, var2 + var4 + 3, 200, var3, 4);
        Ui.i().drawStringY(this.gr.about_a, var1 + 420 + 25, var2 + var4 + 15, var4, 0, 0);
        if (this.state == 0) {
            Ui.i().drawString("请选择押注大小：", var1 + 200 + 10, var2 + var4 + 15, 0, 0, 0);

            for(var3 = 0; var3 < this.length; ++var3) {
                Ui.i().drawK(var1 + 200 + 10 + 25 + 14, var2 + var4 + 50 + (var4 + 16) * var3, 150, var4 + 4, 1);
                Ui.i().drawString(this.gr.about_b[var3].toString(), var1 + 200 + 10 + 25 + 14, var2 + var4 + 50 + (var4 + 16) * var3, 0, 3, 0);
                if (this.gr.pkey.isSelect(var1 + 200 + 10 + 25 + 14, var2 + var4 + 50 + (var4 + 16) * var3, 150, var4 + 4)) {
                    if (this.sel == var3) {
                        this.gr.pkey.setKey5();
                    } else {
                        this.sel = (byte)var3;
                    }
                }
            }

            Ui.i().drawK4(var1 + 200 + 10 + 25 + 14, var2 + var4 + 50 + this.sel * (var4 + 16), 150, var4 + 4);
        }

        this.gr.drawMoney(320, 360, 3, false);
        Ui.i().drawYesNo(true, true);
    }

    private void draw1(int var1, int var2, int var3) {
        Ui.i().drawK(215, 33, 210, 325, 4);

        int var5;
        boolean var6;
        for(var5 = 0; var5 < this.length; var5 = (byte)(var5 + 1)) {
            Ui.i().drawK(var1 + 25 + var5 * 52, var2 + 25 + 10, 44, var3, 1);
            Ui var9 = Ui.i();
            Sprite var8 = this.sp[0];
            byte[] var7 = this.now_a[var5];
            if (this.state == 1) {
                if (this.sel == var5) {
                    var6 = true;
                } else {
                    var6 = false;
                }
            } else {
                var6 = false;
            }

            var9.drawActionOne(var8, 0, var1 + 25 + var5 * 52 + 22, var2 + 25 + 8 + var3, var7, 0, var6);
            Ui.i().drawNum("" + (var5 + 1), var1 + 25 + var5 * 52 + 27, var2 + 50 + 12, 20, 2);
        }

        byte var4;
        if (this.state == 1) {
            Ui.i().drawK4(var1 + 25 + this.sel * 52, var2 + 25 + 10, 44, 76);
            Ui.i().drawTriangle(320, var2 + 25 + 49, 116, true, true);
            var4 = this.gr.pkey.selectMenuX(4, 320 - 116, var2 + 25 + 10, 52, var3);
            if (var4 != -1) {
                if (this.sel == var4) {
                    this.gr.pkey.setKey5();
                } else {
                    this.sel = var4;
                }
            }
        }

        Ui.i().drawString("兴奋度：", var1 + 25, var2 + 25 + 13 + var3, 0, 0, 0);
        this.gr.drawFealty(6, 2, var1 + 125, var2 + 25 + 19 + var3);
        this.gr.showStringM("每喂一个兴奋菇花费10金，可增加一格兴奋度。", 320, var2 + 50 + 19 + var3, 8, 0);
        var3 = var3 + 69 + 25 + 75;
        Ui.i().drawString("请选择道具：", var1 + 25, var2 + var3, 0, 0, 0);
        var5 = var3 + 25 + 3;

        for(byte var10 = 0; var10 < this.length; ++var10) {
            Ui.i().drawK(var1 + 25 + var10 * 52, var2 + var5, 44, 34, 1);
            this.gr.drawItem(12, var1 + 25 + var10 * 52, var2 + var5 + 10, 0);
            Ui.i().drawString("x" + var10, var1 + 25 + var10 * 52 + 16, var2 + var5 + 8, 0, 3, 1);
        }

        if (this.state == 2) {
            Ui.i().drawK4(var1 + 25 + this.sel * 52, var2 + var5, 44, 34);
            Ui.i().drawTriangle(320, var2 + var5 + 14, 116, true, true);
            var4 = this.gr.pkey.selectMenuX(4, 320 - 116, var2 + var5 + 8, 52, 34);
            if (var4 != -1) {
                if (this.sel == var4) {
                    this.gr.pkey.setKey5();
                } else {
                    this.sel = var4;
                }
            }
        }

        Ui var11 = Ui.i();
        if (this.state != 1) {
            var6 = true;
        } else {
            var6 = false;
        }

        var11.drawYesNo(true, var6);
    }

    private void drawCloud() {
        byte var1;
        for(var1 = 0; var1 < this.cloud.length; ++var1) {
            Ui.i().drawImage(this.imgCloud, this.cloud[var1][0], this.cloud[var1][1] - this.srcY, 0);
        }

        for(var1 = 0; var1 < this.cloud.length; ++var1) {
            if (this.isNpcSrc(this.cloud[var1][0], this.cloud[var1][1])) {
                this.addCloud(var1);
            } else {
                short[] var2 = this.cloud[var1];
                var2[0] -= this.cloud[var1][2];
            }
        }

    }

    private void drawEnd() {
        int var2 = (640 - 70) / 35;
        Ui.i().drawModuleOne(this.sp[1], 0, 0, 40 - this.srcY, 0, 0);

        for(int var1 = 0; var1 < var2 + 1; ++var1) {
            Ui.i().drawModuleOne(this.sp[1], 1, var1 * 35 + 35, 44 - this.srcY, 0, 0);
        }

        Ui.i().drawModuleOne(this.sp[1], 0, 640, 40 - this.srcY, 1, 0);
    }

    private void drawGame() {
        Ui.i().fillRect(5423359, 0, 0, 640, 360);
        this.drawCloud();
        this.drawEnd();

        for(byte var1 = 0; var1 < this.length; ++var1) {
            Ui.i().drawNum("" + (var1 + 1), var1 * 100 + 125 + 22, 20 - this.srcY, 1, 2);
            Ui.i().drawActionOne(this.sp[0], 1, var1 * 100 + 125 + 22, this.monY[var1] - this.srcY, this.now_a[var1], 0, true);
        }

        if (this.state == 3 && this.time != 0) {
            Ui.i().drawNum("" + this.time / 20, 320 - 5, 180, 0, 2);
        }

    }

    private boolean isNpcSrc(int var1, int var2) {
        boolean var3;
        if (var1 >= -40 && var2 - this.srcY <= Constants_H.HEIGHT + 20) {
            var3 = false;
        } else {
            var3 = true;
        }

        return var3;
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

    private void setSpeed() {
        if (this.speedLv < this.gDate.length) {
            byte var1;
            for(var1 = 0; var1 < 4 && this.monY[var1] > this.gDate[this.speedLv][0]; ++var1) {
            }

            if (var1 < 4) {
                for(var1 = 0; var1 < 4; ++var1) {
                    byte[] var2 = this.now_a[var1];
                    Ms.i();
                    var2[2] = (byte)(Ms.getRandom(this.gDate[this.speedLv][1]) + this.gDate[this.speedLv][1]);
                }

                ++this.speedLv;
            }
        }

    }

    public void go(int var1) {
        if (var1 < 1) {
            this.sel = 0;
            this.state = 0;
            this.length = 3;
            this.gr.setStringB("一注：#n投入100金，#n获胜得120金。#n二注：#n投入300金，#n获胜得350金。#n三注：#n投入1000金，#n获胜得1200金。", Constants_H.WIDTH - 50, 0);
            this.gr.setStringB("一注100金#n二注300金#n三注1000金", Constants_H.WIDTH - 50, 1);
        } else if (var1 == 1) {
            this.myDate[0] = this.sel;
            this.sel = 0;
            this.state = 1;
            this.length = 4;
        } else if (var1 == 2) {
            this.myDate[1] = this.sel;
            this.sel = 0;
            this.state = 2;
        } else if (var1 == 3) {
            this.myDate[2] = this.sel;
            this.sel = 0;
            this.state = 3;
            this.srcY = 90;
            this.speedLv = 0;
            this.myDate[3] = -1;
            this.time = 70;

            byte var2;
            for(var2 = 0; var2 < this.length; ++var2) {
                this.monY[var2] = 450;
            }

            for(var2 = 0; var2 < this.cloud.length; ++var2) {
                this.addCloud(var2);
            }
        }

    }

    public void go(int var1, int var2) {
        this.lv = (byte)var2;
        this.sp = new Sprite[3];
        this.sp[0] = Ms.i().createSprite("data/npc0/67", true);
        this.sp[1] = Ms.i().createSprite("data/brow/m1", true);
        this.imgCloud = Ms.i().createImage("data/cloud");
        this.go(var1);
    }

    public boolean key() {
        boolean var1;
        if (Ms.i().key_delay()) {
            var1 = false;
        } else {
            if (this.state == 0) {
                if (Ms.i().key_Up_Down()) {
                    this.sel = Ms.i().select(this.sel, 0, this.length - 1);
                } else if (Ms.i().key_S1_Num5() && this.gr.isMoney(this.money[this.sel << 1], true)) {
                    this.go(1);
                } else if (Ms.i().key_S2()) {
                    this.nullGame();
                    var1 = true;
                    return var1;
                }
            } else if (this.state == 1) {
                if (Ms.i().key_Left_Right()) {
                    this.sel = Ms.i().select(this.sel, 0, this.length - 1);
                } else if (Ms.i().key_S1_Num5()) {
                    this.go(2);
                }
            } else if (this.state == 2) {
                if (Ms.i().key_Left_Right()) {
                    this.sel = Ms.i().select(this.sel, 0, this.length - 1);
                } else if (Ms.i().key_S1_Num5() && this.gr.isMoney(this.sel * 10, true)) {
                    this.go(3);
                } else if (Ms.i().key_S2()) {
                    this.sel = this.myDate[1];
                    this.state = 1;
                }
            }

            var1 = false;
        }

        return var1;
    }

    public void patin() {
        if (this.state != 0 && this.state != 1 && this.state != 2) {
            this.drawGame();
        } else {
            this.draw0(10, 5, 325, 25);
            if (this.state == 1 || this.state == 2) {
                this.draw1(198, 15, 76);
            }
        }

    }

    public void run() {
        if (this.state == 3) {
            if (this.time == 0) {
                this.setSpeed();
                if (this.myDate[3] != -1) {
                    this.time = 5;
                    this.state = 4;
                } else {
                    byte var2 = -1;

                    for(byte var1 = 0; var1 < 4; ++var1) {
                        short[] var3 = this.monY;
                        var3[var1] = (short)(var3[var1] - this.now_a[var1][2]);
                        if (this.monY[var1] - this.srcY < Constants_H.HEIGHT_H) {
                            var2 = var1;
                        }

                        if (this.monY[var1] < 70 && this.myDate[3] == -1) {
                            this.myDate[3] = var1;
                        }
                    }

                    if (var2 != -1) {
                        this.srcY = (short)(this.srcY - this.now_a[var2][2]);
                    }

                    if (this.srcY < 0) {
                        this.srcY = 0;
                    }
                }
            } else {
                --this.time;
            }
        } else if (this.state == 4) {
            if (this.time == 3) {
                if (this.myDate[3] == this.myDate[1]) {
                    GameRun var4 = this.gr;
                    var4.money += this.money[this.myDate[0] * 2 + 1];
                    this.gr.say("获得：" + this.money[this.myDate[0] * 2 + 1] + "金", 0);
                    byte[] var5 = this.gr.rmsOther;
                    var5[4] = (byte)(var5[4] | 1 << this.lv);
                } else {
                    this.gr.say("不好意思，没有猜对。", 0);
                }
            }

            if (this.time > 0) {
                --this.time;
            } else if (this.time == 0 && this.gr.say_c == 0) {
                this.go(0);
            }
        }

    }
}
