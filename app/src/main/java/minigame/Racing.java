package minigame;

import com.uc.paymentsdk.util.Constants;
import dm.Ms;
import dm.Sprite;
import dm.Ui;
import java.lang.reflect.Array;
import javax.microedition.lcdui.Image;
import javax.microedition.media.Player;
import main.Constants_H;
import main.GameRun;
import main.Key_H;

/* loaded from: classes.dex */
public class Racing implements MiniGame_H {
    private short[][] cloud;
    private short[][] gDate;
    GameRun gr;
    private Image imgCloud;
    private byte length;
    private byte lv;
    private short[] monY;
    private short[] money;
    private byte[] myDate;
    private byte sel;
    private Sprite[] sp;
    private byte speedLv;
    private short srcY;
    private byte state;
    private byte time;
    private final byte NUM = 4;
    private final short MAP_HEIGHT = 450;
    private final short WIN_HEIGHT = 70;
    //todo thanh0x fix here [][]
    private byte[][] now_a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 3);

    public Racing(GameRun gr_) {
        byte[] bArr = new byte[4];
        bArr[3] = -1;
        this.myDate = bArr;
        this.cloud = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 10, 3);
        this.monY = new short[4];
        this.money = new short[]{100, 120, 300, 350, 1000, 1200};
        this.gDate = new short[][]{new short[]{450, 3, 8}, new short[]{390, 4, 9}, new short[]{270, 7, 6}, new short[]{210, 6, 10}};
        this.gr = gr_;
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

    private void draw0(int x, int y, int h, int fh) {
        Ui.i().fillRectB();
        Ui.i().drawString(Constants_H.GAME_TXT_7, Constants_H.WIDTH_H_, y + fh + 3, 33, 3, 1);
        Ui.i().drawUi(7, Constants_H.WIDTH_H_ - 50, (y + fh) - 13, 40, 0);
        Ui.i().drawUi(7, Constants_H.WIDTH_H_ + 50, (y + fh) - 13, 36, 4);
        Ui.i().drawK(x, y + fh + 3, Player.REALIZED, h, 4);
        Ui.i().drawK(x + Player.REALIZED + 10, y + fh + 3, Player.REALIZED, h, 4);
        GameRun gameRun = this.gr;
        int i = Player.REALIZED >> 1;
        gameRun.showStringM(Constants_H.GAME_TXT_26, x + 100, y + fh + 15, 7, 0);
        Ui i2 = Ui.i();
        int i3 = (Player.REALIZED + 10) * 2;
        i2.drawK(x + 420, y + fh + 3, Player.REALIZED, h, 4);
        Ui i4 = Ui.i();
        StringBuffer[] stringBufferArr = this.gr.about_a;
        int i5 = (Player.REALIZED + 10) * 2;
        i4.drawStringY(stringBufferArr, x + 420 + 25, y + fh + 15, fh, 0, 0);
        if (this.state == 0) {
            Ui.i().drawString(Constants_H.GAME_TXT_4, x + Player.REALIZED + 10, y + fh + 15, 0, 0, 0);
            for (int i6 = 0; i6 < this.length; i6++) {
                Ui.i().drawK(x + Player.REALIZED + 10 + 25 + 14, y + fh + 50 + ((fh + 16) * i6), 150, fh + 4, 1);
                Ui.i().drawString(this.gr.about_b[i6].toString(), x + Player.REALIZED + 10 + 25 + 14, y + fh + 50 + ((fh + 16) * i6), 0, 3, 0);
                if (this.gr.pkey.isSelect(x + Player.REALIZED + 10 + 25 + 14, y + fh + 50 + ((fh + 16) * i6), 150, fh + 4)) {
                    if (this.sel == i6) {
                        this.gr.pkey.setKey5();
                    } else {
                        this.sel = (byte) i6;
                    }
                }
            }
            Ui.i().drawK4(x + Player.REALIZED + 10 + 25 + 14, y + fh + 50 + (this.sel * (fh + 16)), 150, fh + 4);
        }
        this.gr.drawMoney(Constants_H.WIDTH_H_, Constants_H.HEIGHT_, 3, false);
        Ui.i().drawYesNo(true, true);
    }

    private void draw1(int x, int y, int h) {
        boolean z;
        Ui.i().drawK(Constants.ERROR_CODE_EMAIL_WRONG_FORMAT, 33, 210, 325, 4);
        byte i = 0;
        while (i < this.length) {
            Ui.i().drawK(x + 25 + (i * Key_H.KEY_NUM4), y + 25 + 10, 44, h, 1);
            Ui i2 = Ui.i();
            Sprite sprite = this.sp[0];
            int i3 = x + 25 + (i * Key_H.KEY_NUM4) + 22;
            int i4 = y + 25 + 8 + h;
            byte[] bArr = this.now_a[i];
            if (this.state == 1) {
                z = this.sel == i;
            } else {
                z = false;
            }
            i2.drawActionOne(sprite, 0, i3, i4, bArr, 0, z);
            Ui.i().drawNum(new StringBuilder().append(i + 1).toString(), x + 25 + (i * Key_H.KEY_NUM4) + 27, y + 50 + 12, 20, 2);
            i = (byte) (i + 1);
        }
        if (this.state == 1) {
            Ui.i().drawK4(x + 25 + (this.sel * Key_H.KEY_NUM4), y + 25 + 10, 44, 76);
            Ui.i().drawTriangle(Constants_H.WIDTH_H_, y + 25 + 49, 116, true, true);
            byte t = this.gr.pkey.selectMenuX(4, Constants_H.WIDTH_H_ - 116, y + 25 + 10, 52, h);
            if (t != -1) {
                if (this.sel == t) {
                    this.gr.pkey.setKey5();
                } else {
                    this.sel = t;
                }
            }
        }
        Ui.i().drawString(Constants_H.GAME_TXT_9, x + 25, y + 25 + 13 + h, 0, 0, 0);
        this.gr.drawFealty(6, 2, x + 125, y + 25 + 19 + h);
        this.gr.showStringM(Constants_H.GAME_TXT_6, Constants_H.WIDTH_H_, y + 50 + 19 + h, 8, 0);
        int h2 = h + 69 + 25 + 75;
        Ui.i().drawString(Constants_H.GAME_TXT_10, x + 25, y + h2, 0, 0, 0);
        int h3 = h2 + 25 + 3;
        for (byte i5 = 0; i5 < this.length; i5 = (byte) (i5 + 1)) {
            Ui.i().drawK(x + 25 + (i5 * Key_H.KEY_NUM4), y + h3, 44, 34, 1);
            this.gr.drawItem(12, x + 25 + (i5 * Key_H.KEY_NUM4), y + h3 + 10, 0);
            Ui.i().drawString("x" + ((int) i5), x + 25 + (i5 * Key_H.KEY_NUM4) + 16, y + h3 + 8, 0, 3, 1);
        }
        if (this.state == 2) {
            Ui.i().drawK4(x + 25 + (this.sel * Key_H.KEY_NUM4), y + h3, 44, 34);
            Ui.i().drawTriangle(Constants_H.WIDTH_H_, y + h3 + 14, 116, true, true);
            byte t2 = this.gr.pkey.selectMenuX(4, Constants_H.WIDTH_H_ - 116, y + h3 + 8, 52, 34);
            if (t2 != -1) {
                if (this.sel == t2) {
                    this.gr.pkey.setKey5();
                } else {
                    this.sel = t2;
                }
            }
        }
        Ui.i().drawYesNo(true, this.state != 1);
    }

    private void drawGame() {
        Ui.i().fillRect(5423359, 0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_);
        drawCloud();
        drawEnd();
        for (byte i = 0; i < this.length; i = (byte) (i + 1)) {
            Ui.i().drawNum(new StringBuilder().append(i + 1).toString(), (i * 100) + 125 + 22, 20 - this.srcY, 1, 2);
            Ui.i().drawActionOne(this.sp[0], 1, (i * 100) + 125 + 22, this.monY[i] - this.srcY, this.now_a[i], 0, true);
        }
        if (this.state == 3 && this.time != 0) {
            Ui.i().drawNum(new StringBuilder().append(this.time / 20).toString(), Constants_H.WIDTH_H_ - 5, Constants_H.HEIGHT_H_, 0, 2);
        }
    }

    private void setSpeed() {
        if (this.speedLv < this.gDate.length) {
            byte i = 0;
            while (i < 4 && this.monY[i] > this.gDate[this.speedLv][0]) {
                i = (byte) (i + 1);
            }
            if (i < 4) {
                for (byte i2 = 0; i2 < 4; i2 = (byte) (i2 + 1)) {
                    byte[] bArr = this.now_a[i2];
                    Ms.i();
                    bArr[2] = (byte) (Ms.getRandom(this.gDate[this.speedLv][1]) + this.gDate[this.speedLv][1]);
                }
                this.speedLv = (byte) (this.speedLv + 1);
            }
        }
    }

    @Override // minigame.MiniGame_H
    public void go(int mode, int lv_) {
        this.lv = (byte) lv_;
        this.sp = new Sprite[3];
        this.sp[0] = Ms.i().createSprite("data/npc0/67", true);
        this.sp[1] = Ms.i().createSprite("data/brow/m1", true);
        this.imgCloud = Ms.i().createImage("data/cloud");
        go(mode);
    }

    @Override // minigame.MiniGame_H
    public void go(int mode) {
        if (mode < 1) {
            this.sel = (byte) 0;
            this.state = (byte) 0;
            this.length = (byte) 3;
            this.gr.setStringB(Constants_H.GAME_TXT_3, Constants_H.WIDTH - 50, 0);
            this.gr.setStringB(Constants_H.GAME_TXT_8, Constants_H.WIDTH - 50, 1);
            return;
        }
        if (mode == 1) {
            this.myDate[0] = this.sel;
            this.sel = (byte) 0;
            this.state = (byte) 1;
            this.length = (byte) 4;
            return;
        }
        if (mode == 2) {
            this.myDate[1] = this.sel;
            this.sel = (byte) 0;
            this.state = (byte) 2;
            return;
        }
        if (mode == 3) {
            this.myDate[2] = this.sel;
            this.sel = (byte) 0;
            this.state = (byte) 3;
            this.srcY = (short) 90;
            this.speedLv = (byte) 0;
            this.myDate[3] = -1;
            this.time = (byte) 70;
            for (byte i = 0; i < this.length; i = (byte) (i + 1)) {
                this.monY[i] = 450;
            }
            for (byte i2 = 0; i2 < this.cloud.length; i2 = (byte) (i2 + 1)) {
                addCloud(i2);
            }
        }
    }

    @Override // minigame.MiniGame_H
    public boolean key() {
        if (Ms.i().key_delay()) {
            return false;
        }
        if (this.state == 0) {
            if (Ms.i().key_Up_Down()) {
                this.sel = Ms.i().select(this.sel, 0, this.length - 1);
            } else if (Ms.i().key_S1_Num5() && this.gr.isMoney(this.money[this.sel << 1], true)) {
                go(1);
            } else if (Ms.i().key_S2()) {
                nullGame();
                return true;
            }
        } else if (this.state == 1) {
            if (Ms.i().key_Left_Right()) {
                this.sel = Ms.i().select(this.sel, 0, this.length - 1);
            } else if (Ms.i().key_S1_Num5()) {
                go(2);
            }
        } else if (this.state == 2) {
            if (Ms.i().key_Left_Right()) {
                this.sel = Ms.i().select(this.sel, 0, this.length - 1);
            } else if (Ms.i().key_S1_Num5() && this.gr.isMoney(this.sel * 10, true)) {
                go(3);
            } else if (Ms.i().key_S2()) {
                this.sel = this.myDate[1];
                this.state = (byte) 1;
            }
        }
        return false;
    }

    @Override // minigame.MiniGame_H
    public void patin() {
        if (this.state == 0 || this.state == 1 || this.state == 2) {
            draw0(10, 5, 325, 25);
            if (this.state == 1 || this.state == 2) {
                draw1(198, 15, 76);
                return;
            }
            return;
        }
        drawGame();
    }

    @Override // minigame.MiniGame_H
    public void run() {
        if (this.state == 3) {
            if (this.time == 0) {
                setSpeed();
                if (this.myDate[3] != -1) {
                    this.time = (byte) 5;
                    this.state = (byte) 4;
                    return;
                }
                byte j = -1;
                for (byte i = 0; i < 4; i = (byte) (i + 1)) {
                    short[] sArr = this.monY;
                    sArr[i] = (short) (sArr[i] - this.now_a[i][2]);
                    if (this.monY[i] - this.srcY < Constants_H.HEIGHT_H) {
                        j = i;
                    }
                    if (this.monY[i] < 70 && this.myDate[3] == -1) {
                        this.myDate[3] = i;
                    }
                }
                if (j != -1) {
                    this.srcY = (short) (this.srcY - this.now_a[j][2]);
                }
                if (this.srcY < 0) {
                    this.srcY = (short) 0;
                    return;
                }
                return;
            }
            this.time = (byte) (this.time - 1);
            return;
        }
        if (this.state == 4) {
            if (this.time == 3) {
                if (this.myDate[3] == this.myDate[1]) {
                    this.gr.money += this.money[(this.myDate[0] * 2) + 1];
                    this.gr.say(Constants_H.MONEY_TXT_7 + ((int) this.money[(this.myDate[0] * 2) + 1]) + Constants_H.MONEY_TXT_0, 0);
                    byte[] bArr = this.gr.rmsOther;
                    bArr[4] = (byte) (bArr[4] | (1 << this.lv));
                } else {
                    this.gr.say(Constants_H.GAME_TXT_11, 0);
                }
            }
            if (this.time <= 0) {
                if (this.time == 0 && this.gr.say_c == 0) {
                    go(0);
                    return;
                }
                return;
            }
            this.time = (byte) (this.time - 1);
        }
    }

    private void addCloud(int i) {
        short[] sArr = this.cloud[i];
        Ms.i();
        sArr[0] = (short) (Ms.getRandom(Constants_H.WIDTH_H) + Constants_H.WIDTH_);
        short[] sArr2 = this.cloud[i];
        int i2 = this.srcY - 80;
        Ms.i();
        sArr2[1] = (short) (i2 + ((Ms.getRandom(25) + 55) * i));
        short[] sArr3 = this.cloud[i];
        Ms.i();
        sArr3[2] = (short) (Ms.getRandom(5) + 2);
    }

    private void drawCloud() {
        for (byte i = 0; i < this.cloud.length; i = (byte) (i + 1)) {
            Ui.i().drawImage(this.imgCloud, this.cloud[i][0], this.cloud[i][1] - this.srcY, 0);
        }
        for (byte i2 = 0; i2 < this.cloud.length; i2 = (byte) (i2 + 1)) {
            if (isNpcSrc(this.cloud[i2][0], this.cloud[i2][1])) {
                addCloud(i2);
            } else {
                short[] sArr = this.cloud[i2];
                sArr[0] = (short) (sArr[0] - this.cloud[i2][2]);
            }
        }
    }

    private boolean isNpcSrc(int ax, int ay) {
        return ax < -40 || ay - this.srcY > Constants_H.HEIGHT + 20;
    }

    private void drawEnd() {
        int n = ((Constants_H.WIDTH_ - 70) / 35) + 1;
        Ui.i().drawModuleOne(this.sp[1], 0, 0, 40 - this.srcY, 0, 0);
        for (int i = 0; i < n; i++) {
            Ui.i().drawModuleOne(this.sp[1], 1, (i * 35) + 35, 44 - this.srcY, 0, 0);
        }
        Ui.i().drawModuleOne(this.sp[1], 0, Constants_H.WIDTH_, 40 - this.srcY, 1, 0);
    }
}
