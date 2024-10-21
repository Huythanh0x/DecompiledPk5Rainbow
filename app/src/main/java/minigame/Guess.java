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
public class Guess implements MiniGame_H {
    private byte b_win;
    private int[][] box;
    private byte[] boxNum;
    private byte[][] gameData;
    GameRun gr;
    private Image[] imgBox;
    private Sprite[] imgMon;
    private byte length;
    private byte lv;
    byte sel;
    private int sell_money;
    private byte time;
    final short TIME = 20;
    final short TIME2 = 40;
    final short BOX_Y1 = 150;
    final short MON_Y = 165;
    private byte mon_size_move = 0;
    private byte state = 0;
    private byte gameR = 0;
    private byte winNum = 0;
    private byte transNum = 0;
    private byte maxTransNum = 20;
    private byte tempTransNum = 0;

    public Guess(GameRun gr_) {
        this.gr = gr_;
    }

    @Override // minigame.MiniGame_H
    public void patin() {
        Ui.i().fillRectB();
        draw();
        if (this.state != 0) {
            drawGame();
        }
    }

    private void drawGame() {
        int i = 240 - 4;
        int i2 = Constants_H.WIDTH_H_ - 4;
        Ui.i().drawString(Constants_H.GAME_TXT_21 + ((int) this.winNum) + "/" + ((int) this.gameData[3][this.lv]), Constants_H.WIDTH_H_, 4, 17, 3, 1);
        if (this.state == 1) {
            Ui.g.setClip(202, 65, 240, 100);
            for (int i3 = 0; i3 < this.box.length; i3++) {
                if (this.box[i3][1] != -1) {
                    drawMon(i3, this.box[i3][1], this.box[i3][2] + 202, (this.time < 40 ? (byte) 0 : this.mon_size_move) + Constants_H.ADD_EFFECT);
                }
            }
            Ui.g.setClip(0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_);
            if (this.time >= 20) {
                for (int i4 = 0; i4 < this.box.length; i4++) {
                    Ui.i().drawImage(this.imgBox[1], this.box[i4][2] + 202, this.box[i4][3], 17);
                }
                return;
            }
            return;
        }
        if (this.state == 2) {
            for (int i5 = 0; i5 < this.box.length; i5++) {
                Ui.i().drawImage(this.imgBox[1], this.box[i5][2] + 202, this.box[i5][3], 17);
            }
            return;
        }
        if (this.state == 3) {
            for (int i6 = 0; i6 < this.box.length; i6++) {
                if (this.gr.pkey.isSelect((this.box[i6][2] + 202) - 20, this.box[i6][3], 40, 40)) {
                    this.gr.selectx = (byte) i6;
                    this.gr.pkey.setKey5();
                }
                Ui.i().drawImage(this.imgBox[1], this.box[i6][2] + 202, this.box[i6][3], 17);
            }
            Ui.i().drawImage(this.imgBox[0], (this.box[this.gr.selectx][2] + 202) - 1, this.box[this.gr.selectx][3] - (this.time % 4 <= 2 ? 5 : 0), 17);
            byte b = (byte) (this.time + 1);
            this.time = b;
            if (b > 20) {
                this.time = (byte) 0;
            }
            drawMon(this.box[this.gr.selecty][0], this.box[this.gr.selecty][1], this.gameData[0][1] + 202 + 100, 135);
            this.gr.showStringM(Constants_H.GAME_TXT_22 + this.gr.getNameMon(this.box[this.gr.selecty][1]) + Constants_H.GAME_TXT_23, 202 + 240 + 90, 29 * 5, 6, 0);
            return;
        }
        if (this.state == 4) {
            int i7 = this.box[this.gr.selecty][0];
            int[][] iArr = this.box;
            int WIDTH_H = this.gr.selecty;
            drawMon(i7, iArr[WIDTH_H][1], this.gameData[0][1] + 202 + 100, 135);
            Ui.i().drawImage(this.imgBox[1], this.box[this.gr.selectx][2] + 202, this.box[this.gr.selectx][3], 17);
            if (this.box[this.gr.selectx][1] != -1) {
                drawMon(this.box[this.gr.selectx][0], this.box[this.gr.selectx][1], this.box[this.gr.selectx][2] + 202, this.box[this.gr.selectx][3] + 35);
            }
            if (this.b_win > 0) {
                this.gr.showStringM(Constants_H.GAME_TXT_24, 202 + 240 + 90, 29 * 5, 6, 0);
            } else {
                this.gr.showStringM(Constants_H.GAME_TXT_25, 202 + 240 + 90, 29 * 5, 6, 0);
            }
            this.gr.showStringM(Constants_H.GAME_TXT_28, 202 + 240 + 90, 29 * 7, 6, 0);
            if (this.gr.pkey.isSelect(0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_)) {
                this.gr.pkey.setKey5();
            }
        }
    }

    private void draw() {
        if (this.state == 0) {
            Ui.i().drawString(Constants_H.GAME_TXT_7, Constants_H.WIDTH_H_, 4, 17, 3, 1);
            Ui.i().drawUi(7, Constants_H.WIDTH_H_ - 75, 27, 40, 0);
            Ui.i().drawUi(7, Constants_H.WIDTH_H_ + 75, 27, 36, 4);
        }
        int h = 29 * 10;
        Ui.i().drawK(10, 25 + 10, Player.REALIZED, h, 4);
        Ui.i().drawK(10 + Player.REALIZED + 10, 25 + 10, Player.REALIZED, h, 4);
        Ui i = Ui.i();
        int i2 = (Player.REALIZED + 10) * 2;
        i.drawK(10 + 420, 25 + 10, Player.REALIZED, h, 4);
        Ui.i().drawStringY(this.gr.about_a, 10 + 6, 25 + 10, 29, 0, 0);
        if (this.state == 0) {
            this.gr.showStringM(Constants_H.GAME_TXT_12 + this.sell_money + Constants_H.MONEY_TXT_0, Constants_H.WIDTH_H_, (25 + 290) - 50, 7, 0);
            int ty = 25 + 75 + 5;
            Ui.i().drawListKY(2, 10 + Player.REALIZED + 12 + 25, ty, Player.REALIZED - 50, 3, 30, 10, this.sel, 4, 2);
            int i3 = 0;
            while (i3 < this.gr.about_b.length) {
                Ui.i().drawString(this.gr.about_b[i3].toString(), 10 + Player.REALIZED + 15 + 25 + 26, ((i3 * 40) + 105) - 2, 0, this.sel == i3 ? 0 : 3, 1);
                if (this.gr.pkey.isSelect(10 + Player.REALIZED + 12 + 25, ((i3 * 40) + 105) - 2, Player.REALIZED - 50, 40)) {
                    if (this.sel == i3) {
                        this.gr.pkey.setKey5();
                    } else {
                        this.sel = (byte) i3;
                    }
                }
                i3++;
            }
        }
        if (this.state == 0) {
            Ui.i().drawYesNo(true, true);
        }
        this.gr.drawMoney(Constants_H.WIDTH_H_, Constants_H.HEIGHT_, 3, false);
    }

    private void drawMon(int i, int id, int x, int y) {
        Ui.i().drawFrameOne(this.imgMon[i], this.imgMon[i].action(this.gr.mList_id[id][1] * 3, 0, 0), x, y, 0);
    }

    @Override // minigame.MiniGame_H
    public void run() {
        if (this.state == 1) {
            if (this.time < 20) {
                this.time = (byte) (this.time + 1);
                return;
            }
            if (this.box[0][3] < 150) {
                for (byte i = 0; i < 3; i = (byte) (i + 1)) {
                    int[] iArr = this.box[i];
                    iArr[3] = iArr[3] + 25;
                }
                return;
            }
            byte b = (byte) (this.time + 1);
            this.time = b;
            if (b >= 40) {
                if (this.mon_size_move < 40) {
                    this.mon_size_move = (byte) (this.mon_size_move + 5);
                    return;
                } else {
                    this.state = (byte) 2;
                    this.time = (byte) 0;
                    return;
                }
            }
            return;
        }
        if (this.state == 2) {
            if (this.time <= 0) {
                if (this.transNum < this.maxTransNum) {
                    this.time = (byte) 1;
                    this.transNum = (byte) (this.transNum + 1);
                    byte[] bArr = this.boxNum;
                    Ms.i();
                    bArr[0] = (byte) Ms.getRandom(3);
                    do {
                        byte[] bArr2 = this.boxNum;
                        Ms.i();
                        bArr2[1] = (byte) Ms.getRandom(3);
                    } while (this.boxNum[1] == this.boxNum[0]);
                    if (this.box[this.boxNum[1]][2] < this.box[this.boxNum[0]][2]) {
                        this.gameR = this.boxNum[1];
                        this.boxNum[1] = this.boxNum[0];
                        this.boxNum[0] = this.gameR;
                    }
                    Ms.i();
                    this.gameR = (byte) (Ms.abs(this.box[this.boxNum[1]][2] - this.box[this.boxNum[0]][2]) / 2);
                    this.tempTransNum = (byte) ((this.gameR * 2) / this.gameData[1][this.lv]);
                    return;
                }
                this.time = (byte) 0;
                this.state = (byte) 3;
                do {
                    GameRun gameRun = this.gr;
                    Ms.i();
                    gameRun.selecty = (byte) Ms.getRandom(this.box.length);
                } while (this.box[this.gr.selecty][1] == -1);
                return;
            }
            if (this.time > this.tempTransNum) {
                this.time = (byte) 0;
                int[] temp = new int[4];
                for (byte i2 = 0; i2 < this.box.length; i2 = (byte) (i2 + 1)) {
                    for (byte j = 0; j < this.box.length; j = (byte) (j + 1)) {
                        if (this.box[j][2] > this.box[i2][2]) {
                            System.arraycopy(this.box[i2], 0, temp, 0, temp.length);
                            System.arraycopy(this.box[j], 0, this.box[i2], 0, this.box[j].length);
                            System.arraycopy(temp, 0, this.box[j], 0, temp.length);
                        }
                    }
                }
                for (byte i3 = 0; i3 < 3; i3 = (byte) (i3 + 1)) {
                    this.box[i3][2] = this.gameData[0][i3] + 100;
                    this.box[i3][3] = 150;
                }
                return;
            }
            this.time = (byte) (this.time + 1);
            int[] iArr2 = this.box[this.boxNum[0]];
            iArr2[2] = iArr2[2] + ((this.gameR * 2) / this.tempTransNum);
            int temp2 = ((this.gameR * 2) / this.tempTransNum) * this.time;
            this.box[this.boxNum[0]][3] = 150 - Ms.i().sqrt((this.gameR * this.gameR) - ((temp2 - this.gameR) * (temp2 - this.gameR)));
            int[] iArr3 = this.box[this.boxNum[1]];
            iArr3[2] = iArr3[2] - ((this.gameR * 2) / this.tempTransNum);
            this.box[this.boxNum[1]][3] = Ms.i().sqrt((this.gameR * this.gameR) - ((temp2 - this.gameR) * (temp2 - this.gameR))) + 150;
            return;
        }
        if (this.state == 4) {
            if ((this.gr.selectx == 2 && this.box[this.gr.selectx][2] > this.gameData[0][1] + 100) || (this.gr.selectx == 0 && this.box[this.gr.selectx][2] < this.gameData[0][1] + 100)) {
                int[] iArr4 = this.box[this.gr.selectx];
                iArr4[2] = iArr4[2] + ((this.gameData[0][1] - this.gameData[0][this.gr.selectx]) / 7);
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
                this.sel = (byte) (this.sel ^ 1);
            } else if (Ms.i().key_S1_Num5()) {
                Ms.i().keyRelease();
                if (this.sel == 0 && this.gr.isMoney(this.sell_money, true)) {
                    go(1, this.lv);
                } else if (this.sel == 1) {
                    Ms.i().keyRelease();
                    this.gr.about_a = null;
                    this.imgBox = null;
                    this.boxNum = null;
                    this.gameData = null;
                    this.box = null;
                    this.imgMon = null;
                    return true;
                }
            } else if (Ms.i().key_S2()) {
                Ms.i().keyRelease();
                this.gr.about_a = null;
                this.imgBox = null;
                this.boxNum = null;
                this.gameData = null;
                this.box = null;
                this.imgMon = null;
                return true;
            }
        } else if (this.state == 3) {
            if (Ms.i().key_Left_Right()) {
                this.gr.selectx = Ms.i().select(this.gr.selectx, 0, this.box.length - 1);
            } else if (Ms.i().key_S1_Num5()) {
                Ms.i().keyRelease();
                this.state = (byte) 4;
                this.b_win = (byte) (this.gr.selectx == this.gr.selecty ? 1 : -1);
            }
        } else if (this.state == 4 && Ms.i().key_S1_Num5()) {
            Ms.i().keyRelease();
            if (this.b_win == 1) {
                this.b_win = win();
                if (this.b_win == 3) {
                    go(1, this.lv);
                }
            } else if (this.b_win == -1 || (this.b_win == 2 && this.gr.say_c == 0)) {
                if (this.b_win == 2 && this.gr.rmsOther[11] == 3) {
                    this.gr.rmsOther[11] = 4;
                    this.gr.getMonster(83, 25, 0, -1);
                } else if (this.b_win == -1 && this.gr.rmsOther[11] < 3) {
                    this.gr.rmsOther[11] = 0;
                }
                go(0, this.lv);
            }
        }
        return false;
    }

    private byte win() {
        byte b = (byte) (this.winNum + 1);
        this.winNum = b;
        if (b < this.gameData[3][this.lv]) {
            return (byte) 3;
        }
        int tm = this.sell_money + (this.lv * this.lv * 150) + ((2 - this.lv) * 25);
        this.gr.money += tm;
        this.gr.say(Constants_H.MONEY_TXT_9 + tm, 0);
        byte[] bArr = this.gr.rmsOther;
        bArr[10] = (byte) (bArr[10] | (1 << this.lv));
        if (this.lv == 2 && this.gr.rmsOther[11] < 3) {
            byte[] bArr2 = this.gr.rmsOther;
            bArr2[11] = (byte) (bArr2[11] + 1);
        }
        return (byte) 2;
    }

    @Override // minigame.MiniGame_H
    public void go(int mode, int lv_) {
        this.gr.setStringB(this.gr.createString("data/gamed.d"), Constants_H.HEIGHT_H_, 0);
        this.gr.setStringB(Constants_H.GAME_TXT_27, Constants_H.WIDTH, 1);
        this.lv = (byte) lv_;
        this.imgBox = new Image[2];
        this.imgBox[0] = Ms.i().createImage("data/brow/m2");
        this.imgBox[1] = Ms.i().createImage("data/brow/m3");
        this.boxNum = new byte[2];
        this.gameData = new byte[][]{new byte[]{-60, 17, 90}, new byte[]{8, 13, 20, 30}, new byte[]{1, 2, 3, 3}, new byte[]{6, 4, 2, 2}, new byte[]{83, 30, 55}};
        //todo thanh0x fix here [][]
        this.box = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 3, 4);
        this.imgMon = new Sprite[3];
        go(mode);
    }

    @Override // minigame.MiniGame_H
    public void go(int mode) {
        if (mode < 1) {
            this.b_win = (byte) 0;
            this.gr.selecty = (byte) 0;
            this.gr.selectx = (byte) 0;
            this.winNum = (byte) 0;
            this.state = (byte) 0;
            this.gr.buyOk = (byte) 0;
            this.gr.line_max = (byte) 9;
            this.sell_money = (this.lv * 200) + Player.REALIZED;
            this.length = (byte) (this.gr.about_a.length - this.gr.line_max);
            return;
        }
        this.time = (byte) 0;
        this.state = (byte) 1;
        initGame();
    }

    private void initGame() {
        byte[] monList = getGameMonList();
        for (byte i = 0; i < 3; i = (byte) (i + 1)) {
            this.box[i][0] = i;
            this.box[i][1] = monList[i];
            this.box[i][2] = this.gameData[0][i] + 100;
            this.box[i][3] = 0;
        }
        Ms.i();
        this.maxTransNum = (byte) (Ms.getRandom(this.lv + 2) + 2 + this.lv);
        this.transNum = (byte) 0;
        this.mon_size_move = (byte) 0;
    }

    private byte[] getGameMonList() {
        byte[] monList = new byte[3];
        for (byte i = 0; i < monList.length; i = (byte) (i + 1)) {
            monList[i] = -1;
        }
        for (byte i2 = 0; i2 < this.gameData[2][this.lv]; i2 = (byte) (i2 + 1)) {
            byte[] bArr = this.gameData[4];
            Ms.i();
            monList[i2] = bArr[Ms.getRandom(this.gameData[4].length)];
            byte n = 0;
            while (n < i2) {
                if (monList[n] == monList[i2]) {
                    byte[] bArr2 = this.gameData[4];
                    Ms.i();
                    monList[i2] = bArr2[Ms.getRandom(this.gameData[4].length)];
                    n = 0;
                } else {
                    n = (byte) (n + 1);
                }
            }
        }
        Ms.i();
        byte i3 = (byte) Ms.getRandom(2);
        byte n2 = monList[monList.length - 1];
        monList[monList.length - 1] = monList[i3];
        monList[i3] = n2;
        for (byte i4 = 0; i4 < 3; i4 = (byte) (i4 + 1)) {
            if (monList[i4] != -1) {
                byte t = this.gr.mList_id[monList[i4]][0];
                this.imgMon[i4] = Ms.i().createSprite("data/npc2/" + ((int) t), this.gr.isNpc2ImageType(t));
            }
        }
        return monList;
    }
}
