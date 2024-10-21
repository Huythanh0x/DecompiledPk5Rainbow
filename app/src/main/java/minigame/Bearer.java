package minigame;

import dm.Ms;
import dm.Sprite;
import dm.Ui;
import java.lang.reflect.Array;
import javax.microedition.lcdui.Image;
import javax.microedition.media.Player;
import main.Constants_H;
import main.GameRun;

/* loaded from: classes.dex */
public class Bearer implements MiniGame_H {
    private short ballC0;
    private short ballC1;
    private Sprite bsp;
    private short count;
    private byte cur;
    GameRun gr;
    private Image img;
    private byte length;
    private byte lv;
    byte sel;
    private Sprite[] sp;
    private byte state;
    private short time0;
    private short time1;
    private short[][] gDate = {new short[]{9, 1, 10, 2, 11, 4, 27, 8, 2, -10}, new short[]{50, 100, 150, 200}, new short[]{60, 40, 30, 10}, new short[]{8, 6, 13, 3, 20, 5, 30, 10}};
    private short[][] ballDate = {new short[]{10, 20, 60, 10, 220}, new short[]{13, 40, 60, 12, Constants_H.FIRST_ROW}, new short[]{10, 40, 60, 10, 120}};
    private short[] money = {150, 200, 300, 450};
    //todo thanh0x fix here [][]
    private short[][] xy = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 40, 7);
    private short[] myxy = {0, 275, 67, 10};
    private byte[] ball_time = {20, 15, 10, 5};
    private final byte SPEED = 10;

    public Bearer(GameRun gr_) {
        this.gr = gr_;
    }

    private void nullGame() {
        this.gDate = null;
        this.money = null;
        this.sp = null;
        this.img = null;
        this.ballDate = null;
    }

    public void setLv(int lv_) {
        this.lv = (byte) lv_;
    }

    @Override // minigame.MiniGame_H
    public void go(int mode, int lv_) {
        this.lv = (byte) lv_;
        this.sp = new Sprite[2];
        this.sp[0] = Ms.i().createSprite("data/npc2/38", true);
        this.img = Ms.i().createImage("data/brow/m0");
        byte[] date = Ms.i().getStream("data/gamee.data", -1);
        Ms.i();
        Ms.skip = 0;
        this.bsp = Sprite.Create(Ms.i().createImage("data/map/5"), Ms.i().createShort2Array(date, 2), Ms.i().createShort3Array(date, 2), Ms.i().createShort3Array(date, 2));
        go(mode);
    }

    @Override // minigame.MiniGame_H
    public void go(int mode) {
        if (mode < 1) {
            this.state = (byte) 0;
            this.length = (byte) 10;
            this.gr.setStringB(Constants_H.GAME_TXT_13, 160, 0);
            this.gr.setStringB(Constants_H.GAME_TXT_27, Constants_H.WIDTH, 1);
            return;
        }
        if (mode == 1) {
            this.state = (byte) 1;
            this.count = (short) 0;
            this.cur = (byte) 0;
            this.ballC0 = this.gDate[1][this.lv];
            initABall(true);
            for (byte i = 0; i < this.xy.length; i = (byte) (i + 1)) {
                this.xy[i][5] = -1;
            }
        }
    }

    @Override // minigame.MiniGame_H
    public boolean key() {
        if (this.state == 0) {
            if (Ms.i().key_Up_Down()) {
                this.sel = (byte) (this.sel ^ 1);
            } else if (Ms.i().key_S1_Num5()) {
                Ms.i().keyRelease();
                if (this.sel == 0 && this.gr.isMoney(this.money[this.lv], true)) {
                    go(1);
                } else if (this.sel == 1) {
                    Ms.i().keyRelease();
                    nullGame();
                    return true;
                }
            } else if (Ms.i().key_S2()) {
                nullGame();
                return true;
            }
        } else if (this.state == 1) {
            if (Ms.i().key_Left()) {
                short[] sArr = this.myxy;
                sArr[0] = (short) (sArr[0] - 10);
                if (this.myxy[0] < 0) {
                    this.myxy[0] = 0;
                }
            } else if (Ms.i().key_Right()) {
                short[] sArr2 = this.myxy;
                sArr2[0] = (short) (sArr2[0] + 10);
                if (this.myxy[0] + this.myxy[2] > 220) {
                    this.myxy[0] = (short) ((240 - this.myxy[2]) - 20);
                }
            }
        }
        return false;
    }

    @Override // minigame.MiniGame_H
    public void patin() {
        draw0(10, 2, this.length * 25);
        if (this.state != 0) {
            drawGame(Player.REALIZED, 0, 240, Constants_H.WIDTH_H_);
        }
    }

    private void draw0(int x, int y, int h) {
        int h2 = h + 45;
        Ui.i().fillRectB();
        Ui.i().drawK(x, y + 25 + 5, Player.REALIZED - 10, h2, 4);
        Ui.i().drawK(x + Player.REALIZED + 10, y + 25 + 5, Player.REALIZED, h2, 4);
        Ui i = Ui.i();
        int i2 = (Player.REALIZED + 10) * 2;
        i.drawK(x + 420 + 10, y + 25 + 5, Player.REALIZED - 10, h2, 4);
        Ui.i().drawString(Constants_H.GAME_TXT_7, Constants_H.WIDTH_H_, y + 25 + 5, 33, 3, 1);
        Ui.i().drawUi(7, (Constants_H.WIDTH_H_ - 50) - 5, (y + 25) - 4, 40, 0);
        Ui.i().drawUi(7, Constants_H.WIDTH_H_ + 50 + 5, (y + 25) - 4, 36, 4);
        Ui.i().drawStringY(this.gr.about_a, 25, y + 75 + 10, 25, 0, 0);
        int ty = y + 100;
        Ui i3 = Ui.i();
        int i4 = (Player.REALIZED + 10) * 2;
        i3.drawString(Constants_H.GAME_TXT_14, x + 420 + 20, ty, 0, 0, 0);
        int ty2 = ty + 50;
        for (int i5 = 0; i5 < this.gDate[0].length; i5 += 2) {
            GameRun gameRun = this.gr;
            short s = this.gDate[0][i5];
            int i6 = (Player.REALIZED + 10) * 2;
            gameRun.drawItem(s, x + 420 + 25 + (i5 % 4 == 2 ? 100 : 0), ((i5 >> 2) * 30) + ty2, 0);
            Ui i7 = Ui.i();
            String str = String.valueOf(this.gDate[0][i5 + 1] < 0 ? "" : "+") + ((int) this.gDate[0][i5 + 1]);
            int i8 = (Player.REALIZED + 10) * 2;
            i7.drawString(str, x + 420 + 25 + (i5 % 4 == 2 ? 100 : 0) + 16, (((i5 >> 2) * 30) + ty2) - 4, 0, 0, 1);
        }
        int ty3 = ty2 - 50;
        Ui.i().drawListKY(2, x + Player.REALIZED + 12 + 25, ty3, Player.REALIZED - 50, 3, 30, 10, this.sel, 4, 2);
        int i9 = 0;
        while (i9 < this.gr.about_b.length) {
            System.out.println("i   " + i9);
            Ui.i().drawString(this.gr.about_b[i9].toString(), x + Player.REALIZED + 15 + 25 + 26, ((i9 * 40) + ty3) - 2, 0, this.sel == i9 ? 0 : 3, 1);
            if (this.gr.pkey.isSelect(x + Player.REALIZED + 12 + 25, ((i9 * 40) + ty3) - 2, Player.REALIZED - 50, 40)) {
                System.out.println("asdfasfaf");
                if (this.sel == i9) {
                    this.gr.pkey.setKey5();
                } else {
                    this.sel = (byte) i9;
                }
            }
            i9++;
        }
        this.gr.showStringM(Constants_H.GAME_TXT_12 + ((int) this.money[this.lv]) + Constants_H.MONEY_TXT_0, Constants_H.WIDTH_H_, (y + h2) - 50, 7, 0);
        this.gr.drawMoney(Constants_H.WIDTH_H_, Constants_H.HEIGHT_, 3, false);
        if (this.state == 0) {
            Ui.i().drawYesNo(true, true);
        }
    }

    private void drawGame(int x, int y, int w, int h) {
        Ui.i().fillRect(5423359, x, y, w, h);
        Ui.i().drawFrameOne(this.bsp, 0, x + (w >> 1), y + (h >> 1), 0);
        Ui.i().drawString(Constants_H.GAME_TXT_15 + ((int) this.count), ((w >> 1) + x) - 25, y, 24, 3, 1);
        Ui.i().drawString(Constants_H.GAME_TXT_16 + ((int) this.ballC0), (w >> 1) + x + 25, y, 20, 3, 1);
        Ui.i().drawImage(this.img, x + w, h - 15, 40);
        for (byte i = 0; i < this.xy.length; i = (byte) (i + 1)) {
            if (this.xy[i][5] != -1) {
                this.gr.drawItem(this.gDate[0][this.xy[i][6] << 1], this.xy[i][0] + x, this.xy[i][1] + y, 0);
            }
        }
        for (byte i2 = 0; i2 < 2; i2 = (byte) (i2 + 1)) {
            Ui.i().drawFrameOne(this.sp[0], this.myxy[4] == 0 ? 3 : 4, this.myxy[0] + x + (i2 * 30) + 20, this.myxy[1] + y + 25, 0);
        }
        this.gr.drawMoney(Constants_H.WIDTH_H_, Constants_H.HEIGHT_, 3, false);
    }

    private void addBall(int id) {
        this.xy[this.cur][0] = -20;
        this.xy[this.cur][1] = this.ballDate[id][4];
        this.xy[this.cur][2] = (short) (this.ballDate[id][1] / this.ballDate[id][0]);
        this.xy[this.cur][4] = this.ballDate[id][0];
        this.xy[this.cur][5] = (short) id;
        this.xy[this.cur][3] = this.ballDate[id][3];
        short[] sArr = this.xy[this.cur];
        Ms.i();
        sArr[6] = (short) Ms.getRandom(this.gDate[0].length >> 1);
        byte b = (byte) (this.cur + 1);
        this.cur = b;
        if (b >= this.xy.length) {
            this.cur = (byte) 0;
        }
    }

    private void initABall(boolean mode) {
        this.time0 = mode ? (short) 10 : this.gDate[2][this.lv];
        this.time1 = this.ball_time[this.lv];
        Ms.i();
        this.ballC1 = (short) (Ms.getRandom(this.gDate[3][this.lv << 1]) + this.gDate[3][(this.lv << 1) + 1]);
    }

    private void getAY(int i) {
        if (this.xy[i][4] <= 0 || this.xy[i][3] <= 1) {
            if (this.xy[i][4] != 0) {
                if (this.xy[i][4] >= 0 || this.xy[i][3] <= (-this.ballDate[this.xy[i][5]][3])) {
                    return;
                }
                short[] sArr = this.xy[i];
                sArr[3] = (short) (sArr[3] - 1);
                return;
            }
            this.xy[i][3] = 0;
            return;
        }
        short[] sArr2 = this.xy[i];
        sArr2[3] = (short) (sArr2[3] - 1);
    }

    private boolean isSrc(int i) {
        boolean bb = this.xy[i][1] > Constants_H.WIDTH_H_ + 10;
        if (Ms.i().isRect(240 - 10, Constants_H.WIDTH_H_ - 40, 20, 10, this.xy[i][0], this.xy[i][1], 16, 16) || (this.xy[i][0] > 240 && this.xy[i][1] < this.myxy[1])) {
            this.count = (short) (this.count + this.gDate[0][(this.xy[i][6] * 2) + 1]);
            return true;
        }
        return bb;
    }

    private boolean isCollision(int i) {
        boolean bb = Ms.i().isRect(this.myxy[0], this.myxy[1], this.myxy[2], this.myxy[3], this.xy[i][0], this.xy[i][1], 16, 16);
        return bb;
    }

    @Override // minigame.MiniGame_H
    public void run() {
        if (this.state == 1) {
            if (this.ballC0 > 0) {
                if (this.time0 > 0) {
                    this.time0 = (short) (this.time0 - 1);
                } else if (this.time1 > 0) {
                    this.time1 = (short) (this.time1 - 1);
                } else if (this.ballC1 > 0) {
                    this.time1 = this.ball_time[this.lv];
                    addBall(Ms.getRandom(this.ballDate.length));
                    this.ballC1 = (short) (this.ballC1 - 1);
                    this.ballC0 = (short) (this.ballC0 - 1);
                } else if (this.ballC1 == 0) {
                    initABall(false);
                }
            }
            if (this.myxy[4] > 0) {
                short[] sArr = this.myxy;
                sArr[4] = (short) (sArr[4] - 1);
            }
            boolean bb = true;
            for (byte i = 0; i < this.xy.length; i = (byte) (i + 1)) {
                if (this.xy[i][5] != -1) {
                    bb = false;
                    short[] sArr2 = this.xy[i];
                    sArr2[0] = (short) (sArr2[0] + this.xy[i][2]);
                    short[] sArr3 = this.xy[i];
                    sArr3[1] = (short) (sArr3[1] - this.xy[i][3]);
                    getAY(i);
                    short[] sArr4 = this.xy[i];
                    sArr4[4] = (short) (sArr4[4] - 1);
                    if (isSrc(i)) {
                        this.xy[i][5] = -1;
                    } else if (isCollision(i)) {
                        this.xy[i][4] = this.ballDate[this.xy[i][5]][0];
                        this.myxy[4] = 1;
                        this.xy[i][3] = this.ballDate[this.xy[i][5]][3];
                    }
                }
            }
            if (this.ballC0 < 1 && bb) {
                this.count = (short) ((this.count * 15) / 10);
                this.gr.money += this.count;
                this.gr.say(Constants_H.MONEY_TXT_7 + ((int) this.count) + Constants_H.MONEY_TXT_0, 0);
                if (this.count > 0) {
                    byte[] bArr = this.gr.rmsOther;
                    bArr[6] = (byte) (bArr[6] | (1 << this.lv));
                }
                this.state = (byte) 2;
            }
            this.gr.pkey.checkButton(4);
            return;
        }
        if (this.state != 2 || this.gr.say_c != 0) {
            return;
        }
        go(0);
    }
}
