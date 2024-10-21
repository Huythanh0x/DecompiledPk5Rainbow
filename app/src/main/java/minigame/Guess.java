package minigame;

import main.Constants_H;
import dm.Ms;
import dm.Ui;
import dm.Sprite;
import javax.microedition.lcdui.Image;
import main.GameRun;

public class Guess implements MiniGame_H
{
    final short BOX_Y1;
    final short MON_Y;
    final short TIME;
    final short TIME2;
    private byte b_win;
    private int[][] box;
    private byte[] boxNum;
    private byte[][] gameData;
    private byte gameR;
    GameRun gr;
    private Image[] imgBox;
    private Sprite[] imgMon;
    private byte length;
    private byte lv;
    private byte maxTransNum;
    private byte mon_size_move;
    byte sel;
    private int sell_money;
    private byte state;
    private byte tempTransNum;
    private byte time;
    private byte transNum;
    private byte winNum;
    
    public Guess(final GameRun gr) {
        super();
        this.TIME = 20;
        this.TIME2 = 40;
        this.BOX_Y1 = 150;
        this.MON_Y = 165;
        this.mon_size_move = 0;
        this.state = 0;
        this.gameR = 0;
        this.winNum = 0;
        this.transNum = 0;
        this.maxTransNum = 20;
        this.tempTransNum = 0;
        this.gr = gr;
    }
    
    private void draw() {
        if (this.state == 0) {
            Ui.i().drawString("\u6e38\u620f\u89c4\u5219", 320, 4, 17, 3, 1);
            Ui.i().drawUi(7, 320 - 75, 27, 40, 0);
            Ui.i().drawUi(7, 320 + 75, 27, 36, 4);
        }
        final int n = 29 * 10;
        Ui.i().drawK(10, 25 + 10, 200, n, 4);
        Ui.i().drawK(10 + 200 + 10, 25 + 10, 200, n, 4);
        Ui.i().drawK(10 + 420, 25 + 10, 200, n, 4);
        Ui.i().drawStringY(this.gr.about_a, 10 + 6, 25 + 10, 29, 0, 0);
        if (this.state == 0) {
            this.gr.showStringM("\u9700\u8981\u7684\u53c2\u52a0\u8d39\uff1a" + this.sell_money + "\u91d1", 320, 25 + 290 - 50, 7, 0);
            Ui.i().drawListKY(2, 10 + 200 + 12 + 25, 25 + 75 + 5, 200 - 50, 3, 30, 10, this.sel, 4, 2);
            for (byte b = 0; b < this.gr.about_b.length; ++b) {
                final Ui i = Ui.i();
                final String string = this.gr.about_b[b].toString();
                int n2;
                if (this.sel == b) {
                    n2 = 0;
                }
                else {
                    n2 = 3;
                }
                i.drawString(string, 10 + 200 + 15 + 25 + 26, b * 40 + 105 - 2, 0, n2, 1);
                if (this.gr.pkey.isSelect(10 + 200 + 12 + 25, b * 40 + 105 - 2, 200 - 50, 40)) {
                    if (this.sel == b) {
                        this.gr.pkey.setKey5();
                    }
                    else {
                        this.sel = b;
                    }
                }
            }
        }
        if (this.state == 0) {
            Ui.i().drawYesNo(true, true);
        }
        this.gr.drawMoney(320, 360, 3, false);
    }
    
    private void drawGame() {
        Ui.i().drawString("\u80dc\u5229\u6b21\u6570\uff1a" + this.winNum + "/" + this.gameData[3][this.lv], 320, 4, 17, 3, 1);
        if (this.state == 1) {
            Ui.g.setClip(202, 65, 240, 100);
            for (int i = 0; i < this.box.length; ++i) {
                if (this.box[i][1] != -1) {
                    final int n = this.box[i][1];
                    final int n2 = this.box[i][2];
                    int mon_size_move;
                    if (this.time < 40) {
                        mon_size_move = 0;
                    }
                    else {
                        mon_size_move = this.mon_size_move;
                    }
                    this.drawMon(i, n, n2 + 202, mon_size_move + 165);
                }
            }
            Ui.g.setClip(0, 0, 640, 360);
            if (this.time >= 20) {
                for (int j = 0; j < this.box.length; ++j) {
                    Ui.i().drawImage(this.imgBox[1], this.box[j][2] + 202, this.box[j][3], 17);
                }
            }
        }
        else if (this.state == 2) {
            for (int k = 0; k < this.box.length; ++k) {
                Ui.i().drawImage(this.imgBox[1], this.box[k][2] + 202, this.box[k][3], 17);
            }
        }
        else if (this.state == 3) {
            for (int l = 0; l < this.box.length; ++l) {
                if (this.gr.pkey.isSelect(this.box[l][2] + 202 - 20, this.box[l][3], 40, 40)) {
                    this.gr.selectx = (byte)l;
                    this.gr.pkey.setKey5();
                }
                Ui.i().drawImage(this.imgBox[1], this.box[l][2] + 202, this.box[l][3], 17);
            }
            final Ui m = Ui.i();
            final Image image = this.imgBox[0];
            final int n3 = this.box[this.gr.selectx][2];
            final int n4 = this.box[this.gr.selectx][3];
            int n5;
            if (this.time % 4 <= 2) {
                n5 = 5;
            }
            else {
                n5 = 0;
            }
            m.drawImage(image, n3 + 202 - 1, n4 - n5, 17);
            final byte time = (byte)(this.time + 1);
            this.time = time;
            if (time > 20) {
                this.time = 0;
            }
            this.drawMon(this.box[this.gr.selecty][0], this.box[this.gr.selecty][1], this.gameData[0][1] + 202 + 100, 135);
            this.gr.showStringM("\u8bf7\u6307\u51fa" + this.gr.getNameMon(this.box[this.gr.selecty][1]) + "\u6240\u5728\u7bb1\u5b50", 202 + 240 + 90, 29 * 5, 6, 0);
        }
        else if (this.state == 4) {
            this.drawMon(this.box[this.gr.selecty][0], this.box[this.gr.selecty][1], this.gameData[0][1] + 202 + 100, 135);
            Ui.i().drawImage(this.imgBox[1], this.box[this.gr.selectx][2] + 202, this.box[this.gr.selectx][3], 17);
            if (this.box[this.gr.selectx][1] != -1) {
                this.drawMon(this.box[this.gr.selectx][0], this.box[this.gr.selectx][1], this.box[this.gr.selectx][2] + 202, this.box[this.gr.selectx][3] + 35);
            }
            if (this.b_win > 0) {
                this.gr.showStringM("\u60a8\u771f\u5389\u5bb3\uff01", 202 + 240 + 90, 29 * 5, 6, 0);
            }
            else {
                this.gr.showStringM("\u8bf4\u4e0d\u5b9a\u4e0b\u6b21\u5c31\u80fd\u884c\u7684\u3002", 202 + 240 + 90, 29 * 5, 6, 0);
            }
            this.gr.showStringM("\u70b9\u51fb\u5c4f\u5e55\u7ee7\u7eed", 202 + 240 + 90, 29 * 7, 6, 0);
            if (this.gr.pkey.isSelect(0, 0, 640, 360)) {
                this.gr.pkey.setKey5();
            }
        }
    }
    
    private void drawMon(final int n, final int n2, final int n3, final int n4) {
        Ui.i().drawFrameOne(this.imgMon[n], this.imgMon[n].action(this.gr.mList_id[n2][1] * 3, 0, 0), n3, n4, 0);
    }
    
    private byte[] getGameMonList() {
        final byte[] array = new byte[3];
        for (int i = 0; i < array.length; i = (byte)(i + 1)) {
            array[i] = -1;
        }
        for (byte b = 0; b < this.gameData[2][this.lv]; ++b) {
            final byte[] array2 = this.gameData[4];
            Ms.i();
            array[b] = array2[Ms.getRandom(this.gameData[4].length)];
            byte b2 = 0;
            while (b2 < b) {
                if (array[b2] == array[b]) {
                    final byte[] array3 = this.gameData[4];
                    Ms.i();
                    array[b] = array3[Ms.getRandom(this.gameData[4].length)];
                    b2 = 0;
                }
                else {
                    ++b2;
                }
            }
        }
        Ms.i();
        final byte b3 = (byte)Ms.getRandom(2);
        final byte b4 = array[array.length - 1];
        array[array.length - 1] = array[b3];
        array[b3] = b4;
        for (int j = 0; j < 3; j = (byte)(j + 1)) {
            if (array[j] != -1) {
                final byte k = this.gr.mList_id[array[j]][0];
                this.imgMon[j] = Ms.i().createSprite("data/npc2/" + k, this.gr.isNpc2ImageType((int)k));
            }
        }
        return array;
    }
    
    private void initGame() {
        final byte[] gameMonList = this.getGameMonList();
        for (int i = 0; i < 3; i = (byte)(i + 1)) {
            this.box[i][0] = i;
            this.box[i][1] = gameMonList[i];
            this.box[i][2] = this.gameData[0][i] + 100;
            this.box[i][3] = 0;
        }
        final byte[] array = (byte[])null;
        Ms.i();
        this.maxTransNum = (byte)(Ms.getRandom(this.lv + 2) + 2 + this.lv);
        this.transNum = 0;
        this.mon_size_move = 0;
    }
    
    private byte win() {
        final byte winNum = (byte)(this.winNum + 1);
        this.winNum = winNum;
        byte b;
        if (winNum >= this.gameData[3][this.lv]) {
            final int i = this.sell_money + this.lv * this.lv * 150 + (2 - this.lv) * 25;
            final GameRun gr = this.gr;
            gr.money += i;
            this.gr.say("\u83b7\u5f97\u91d1\u94b1\uff1a" + i, 0);
            final byte[] rmsOther = this.gr.rmsOther;
            rmsOther[10] |= (byte)(1 << this.lv);
            if (this.lv == 2 && this.gr.rmsOther[11] < 3) {
                final byte[] rmsOther2 = this.gr.rmsOther;
                ++rmsOther2[11];
            }
            b = 2;
        }
        else {
            b = 3;
        }
        return b;
    }
    
    @Override
    public void go(final int n) {
        if (n < 1) {
            this.b_win = 0;
            this.gr.selecty = 0;
            this.gr.selectx = 0;
            this.winNum = 0;
            this.state = 0;
            this.gr.buyOk = 0;
            this.gr.line_max = 9;
            this.sell_money = this.lv * 200 + 200;
            this.length = (byte)(this.gr.about_a.length - this.gr.line_max);
        }
        else {
            this.time = 0;
            this.state = 1;
            this.initGame();
        }
    }
    
    @Override
    public void go(final int n, final int n2) {
        this.gr.setStringB(this.gr.createString("data/gamed.d"), 180, 0);
        this.gr.setStringB("\u5f00\u59cb\u6e38\u620f#n\u79bb\u5f00\u6e38\u620f", Constants_H.WIDTH, 1);
        this.lv = (byte)n2;
        (this.imgBox = new Image[2])[0] = Ms.i().createImage("data/brow/m2");
        this.imgBox[1] = Ms.i().createImage("data/brow/m3");
        this.boxNum = new byte[2];
        this.gameData = new byte[][] { { -60, 17, 90 }, { 8, 13, 20, 30 }, { 1, 2, 3, 3 }, { 6, 4, 2, 2 }, { 83, 30, 55 } };
        this.box = new int[3][4];
        this.imgMon = new Sprite[3];
        this.go(n);
    }
    
    @Override
    public boolean key() {
        boolean b;
        if (Ms.i().key_delay()) {
            b = false;
        }
        else {
            if (this.state == 0) {
                if (Ms.i().key_Up_Down()) {
                    this.sel ^= 0x1;
                }
                else if (Ms.i().key_S1_Num5()) {
                    Ms.i().keyRelease();
                    if (this.sel == 0 && this.gr.isMoney(this.sell_money, true)) {
                        this.go(1, this.lv);
                    }
                    else if (this.sel == 1) {
                        Ms.i().keyRelease();
                        this.gr.about_a = null;
                        this.imgBox = null;
                        this.boxNum = null;
                        this.gameData = null;
                        this.box = null;
                        this.imgMon = null;
                        b = true;
                        return b;
                    }
                }
                else if (Ms.i().key_S2()) {
                    Ms.i().keyRelease();
                    this.gr.about_a = null;
                    this.imgBox = null;
                    this.boxNum = null;
                    this.gameData = null;
                    this.box = null;
                    this.imgMon = null;
                    b = true;
                    return b;
                }
            }
            else if (this.state == 3) {
                if (Ms.i().key_Left_Right()) {
                    this.gr.selectx = Ms.i().select(this.gr.selectx, 0, this.box.length - 1);
                }
                else if (Ms.i().key_S1_Num5()) {
                    Ms.i().keyRelease();
                    this.state = 4;
                    int n;
                    if (this.gr.selectx == this.gr.selecty) {
                        n = 1;
                    }
                    else {
                        n = -1;
                    }
                    this.b_win = (byte)n;
                }
            }
            else if (this.state == 4 && Ms.i().key_S1_Num5()) {
                Ms.i().keyRelease();
                if (this.b_win == 1) {
                    this.b_win = this.win();
                    if (this.b_win == 3) {
                        this.go(1, this.lv);
                    }
                }
                else if (this.b_win == -1 || (this.b_win == 2 && this.gr.say_c == 0)) {
                    if (this.b_win == 2 && this.gr.rmsOther[11] == 3) {
                        this.gr.rmsOther[11] = 4;
                        this.gr.getMonster(83, 25, 0, -1);
                    }
                    else if (this.b_win == -1 && this.gr.rmsOther[11] < 3) {
                        this.gr.rmsOther[11] = 0;
                    }
                    this.go(0, this.lv);
                }
            }
            b = false;
        }
        return b;
    }
    
    @Override
    public void patin() {
        Ui.i().fillRectB();
        this.draw();
        if (this.state != 0) {
            this.drawGame();
        }
    }
    
    @Override
    public void run() {
        if (this.state == 1) {
            if (this.time < 20) {
                ++this.time;
            }
            else if (this.box[0][3] < 150) {
                for (int i = 0; i < 3; i = (byte)(i + 1)) {
                    final int[] array = this.box[i];
                    array[3] += 25;
                }
            }
            else if (++this.time >= 40) {
                if (this.mon_size_move < 40) {
                    this.mon_size_move += 5;
                }
                else {
                    this.state = 2;
                    this.time = 0;
                }
            }
        }
        else if (this.state == 2) {
            if (this.time <= 0) {
                if (this.transNum < this.maxTransNum) {
                    this.time = 1;
                    ++this.transNum;
                    final byte[] boxNum = this.boxNum;
                    Ms.i();
                    boxNum[0] = (byte)Ms.getRandom(3);
                    do {
                        final byte[] boxNum2 = this.boxNum;
                        Ms.i();
                        boxNum2[1] = (byte)Ms.getRandom(3);
                    } while (this.boxNum[1] == this.boxNum[0]);
                    if (this.box[this.boxNum[1]][2] < this.box[this.boxNum[0]][2]) {
                        this.gameR = this.boxNum[1];
                        this.boxNum[1] = this.boxNum[0];
                        this.boxNum[0] = this.gameR;
                    }
                    Ms.i();
                    this.gameR = (byte)(Ms.abs(this.box[this.boxNum[1]][2] - this.box[this.boxNum[0]][2]) / 2);
                    this.tempTransNum = (byte)(this.gameR * 2 / this.gameData[1][this.lv]);
                }
                else {
                    this.time = 0;
                    this.state = 3;
                    do {
                        final GameRun gr = this.gr;
                        Ms.i();
                        gr.selecty = (byte)Ms.getRandom(this.box.length);
                    } while (this.box[this.gr.selecty][1] == -1);
                }
            }
            else if (this.time > this.tempTransNum) {
                this.time = 0;
                final int[] array2 = new int[4];
                for (int j = 0; j < this.box.length; j = (byte)(j + 1)) {
                    for (int k = 0; k < this.box.length; k = (byte)(k + 1)) {
                        if (this.box[k][2] > this.box[j][2]) {
                            System.arraycopy(this.box[j], 0, array2, 0, array2.length);
                            System.arraycopy(this.box[k], 0, this.box[j], 0, this.box[k].length);
                            System.arraycopy(array2, 0, this.box[k], 0, array2.length);
                        }
                    }
                }
                for (int l = 0; l < 3; l = (byte)(l + 1)) {
                    this.box[l][2] = this.gameData[0][l] + 100;
                    this.box[l][3] = 150;
                }
            }
            else {
                ++this.time;
                final int[] array3 = this.box[this.boxNum[0]];
                array3[2] += this.gameR * 2 / this.tempTransNum;
                final int n = this.gameR * 2 / this.tempTransNum * this.time;
                this.box[this.boxNum[0]][3] = 150 - Ms.i().sqrt(this.gameR * this.gameR - (n - this.gameR) * (n - this.gameR));
                final int[] array4 = this.box[this.boxNum[1]];
                array4[2] -= this.gameR * 2 / this.tempTransNum;
                this.box[this.boxNum[1]][3] = Ms.i().sqrt(this.gameR * this.gameR - (n - this.gameR) * (n - this.gameR)) + 150;
            }
        }
        else if (this.state == 4 && ((this.gr.selectx == 2 && this.box[this.gr.selectx][2] > this.gameData[0][1] + 100) || (this.gr.selectx == 0 && this.box[this.gr.selectx][2] < this.gameData[0][1] + 100))) {
            final int[] array5 = this.box[this.gr.selectx];
            array5[2] += (this.gameData[0][1] - this.gameData[0][this.gr.selectx]) / 7;
        }
    }
}
