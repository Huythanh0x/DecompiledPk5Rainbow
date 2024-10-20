package minigame;

import dm.Ms;
import dm.Sprite;
import dm.Ui;
import javax.microedition.lcdui.Image;
import main.Constants_H;
import main.GameRun;

public class Guess implements MiniGame_H {
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

    public Guess(GameRun gr_) {
        this.TIME = 20;
        this.TIME2 = 40;
        this.BOX_Y1 = 150;
        this.MON_Y = 0xA5;
        this.mon_size_move = 0;
        this.state = 0;
        this.gameR = 0;
        this.winNum = 0;
        this.transNum = 0;
        this.maxTransNum = 20;
        this.tempTransNum = 0;
        this.gr = gr_;
    }

    private void draw() {
        if(this.state == 0) {
            Ui.i().drawString("游戏规则", 320, 4, 17, 3, 1);
            Ui.i().drawUi(7, 0xF5, 27, 40, 0);
            Ui.i().drawUi(7, 395, 27, 36, 4);
        }
        Ui.i().drawK(10, 35, 200, 290, 4);
        Ui.i().drawK(220, 35, 200, 290, 4);
        Ui.i().drawK(430, 35, 200, 290, 4);
        Ui.i().drawStringY(this.gr.about_a, 16, 35, 29, 0, 0);
        if(this.state == 0) {
            this.gr.showStringM("需要的参加费：" + this.sell_money + "金", 320, 0x109, 7, 0);
            Ui.i().drawListKY(2, 0xF7, 105, 150, 3, 30, 10, ((int)this.sel), 4, 2);
            for(int i = 0; i < this.gr.about_b.length; ++i) {
                Ui.i().drawString(this.gr.about_b[i].toString(), 276, i * 40 + 103, 0, (this.sel == i ? 0 : 3), 1);
                if(this.gr.pkey.isSelect(0xF7, i * 40 + 103, 150, 40)) {
                    if(this.sel == i) {
                        this.gr.pkey.setKey5();
                    }
                    else {
                        this.sel = (byte)i;
                    }
                }
            }
        }
        if(this.state == 0) {
            Ui.i().drawYesNo(true, true);
        }
        this.gr.drawMoney(320, 360, 3, false);
    }

    private void drawGame() {
        Ui.i().drawString("胜利次数：" + ((int)this.winNum) + "/" + ((int)this.gameData[3][this.lv]), 320, 4, 17, 3, 1);
        if(this.state == 1) {
            Ui.g.setClip(202, 65, 0xF0, 100);
            for(int i = 0; i < this.box.length; ++i) {
                if(this.box[i][1] != -1) {
                    int v1 = this.box[i][1];
                    int v2 = this.box[i][2] + 202;
                    int v3 = this.time < 40 ? 0 : this.mon_size_move;
                    this.drawMon(i, v1, v2, v3 + 0xA5);
                }
            }
            Ui.g.setClip(0, 0, 640, 360);
            if(this.time >= 20) {
                for(int i = 0; i < this.box.length; ++i) {
                    Ui.i().drawImage(this.imgBox[1], this.box[i][2] + 202, this.box[i][3], 17);
                }
            }
        }
        else {
            switch(this.state) {
                case 2: {
                    for(int i = 0; i < this.box.length; ++i) {
                        Ui.i().drawImage(this.imgBox[1], this.box[i][2] + 202, this.box[i][3], 17);
                    }
                    return;
                }
                case 3: {
                    for(int i = 0; i < this.box.length; ++i) {
                        if(this.gr.pkey.isSelect(this.box[i][2] + 0xB6, this.box[i][3], 40, 40)) {
                            this.gr.selectx = (byte)i;
                            this.gr.pkey.setKey5();
                        }
                        Ui.i().drawImage(this.imgBox[1], this.box[i][2] + 202, this.box[i][3], 17);
                    }
                    Ui.i().drawImage(this.imgBox[0], this.box[this.gr.selectx][2] + 201, this.box[this.gr.selectx][3] - (this.time % 4 > 2 ? 0 : 5), 17);
                    byte b = (byte)(this.time + 1);
                    this.time = b;
                    if(b > 20) {
                        this.time = 0;
                    }
                    this.drawMon(this.box[this.gr.selecty][0], this.box[this.gr.selecty][1], this.gameData[0][1] + 302, 0x87);
                    this.gr.showStringM("请指出" + this.gr.getNameMon(this.box[this.gr.selecty][1]) + "所在箱子", 532, 0x91, 6, 0);
                    return;
                }
                case 4: {
                    this.drawMon(this.box[this.gr.selecty][0], this.box[this.gr.selecty][1], this.gameData[0][1] + 302, 0x87);
                    Ui.i().drawImage(this.imgBox[1], this.box[this.gr.selectx][2] + 202, this.box[this.gr.selectx][3], 17);
                    if(this.box[this.gr.selectx][1] != -1) {
                        this.drawMon(this.box[this.gr.selectx][0], this.box[this.gr.selectx][1], this.box[this.gr.selectx][2] + 202, this.box[this.gr.selectx][3] + 35);
                    }
                    if(this.b_win > 0) {
                        this.gr.showStringM("您真厉害！", 532, 0x91, 6, 0);
                    }
                    else {
                        this.gr.showStringM("说不定下次就能行的。", 532, 0x91, 6, 0);
                    }
                    this.gr.showStringM("点击屏幕继续", 532, 203, 6, 0);
                    if(this.gr.pkey.isSelect(0, 0, 640, 360)) {
                        this.gr.pkey.setKey5();
                        return;
                    }
                    break;
                }
            }
        }
    }

    private void drawMon(int i, int id, int x, int y) {
        Ui.i().drawFrameOne(this.imgMon[i], this.imgMon[i].action(this.gr.mList_id[id][1] * 3, 0, 0), x, y, 0);
    }

    private byte[] getGameMonList() {
        byte[] monList = new byte[3];
        for(int i = 0; i < 3; i = (byte)(i + 1)) {
            monList[i] = -1;
        }
        for(int i = 0; i < this.gameData[2][this.lv]; i = (byte)(i + 1)) {
            byte[] arr_b1 = this.gameData[4];
            Ms.i();
            monList[i] = arr_b1[Ms.getRandom(this.gameData[4].length)];
            int n = 0;
            while(n < i) {
                if(monList[n] == monList[i]) {
                    byte[] arr_b2 = this.gameData[4];
                    Ms.i();
                    monList[i] = arr_b2[Ms.getRandom(this.gameData[4].length)];
                    n = 0;
                }
                else {
                    n = (byte)(n + 1);
                }
            }
        }
        Ms.i();
        int i = (byte)Ms.getRandom(2);
        byte n = monList[2];
        monList[2] = monList[i];
        monList[i] = n;
        for(int i = 0; i < 3; i = (byte)(i + 1)) {
            if(monList[i] != -1) {
                int t = this.gr.mList_id[monList[i]][0];
                Sprite[] arr_sprite = this.imgMon;
                arr_sprite[i] = Ms.i().createSprite("data/npc2/" + t, this.gr.isNpc2ImageType(t));
            }
        }
        return monList;
    }

    @Override  // minigame.MiniGame_H
    public void go(int mode) {
        if(mode < 1) {
            this.b_win = 0;
            this.gr.selecty = 0;
            this.gr.selectx = 0;
            this.winNum = 0;
            this.state = 0;
            this.gr.buyOk = 0;
            this.gr.line_max = 9;
            this.sell_money = this.lv * 200 + 200;
            this.length = (byte)(this.gr.about_a.length - this.gr.line_max);
            return;
        }
        this.time = 0;
        this.state = 1;
        this.initGame();
    }

    @Override  // minigame.MiniGame_H
    public void go(int mode, int lv_) {
        this.gr.setStringB(this.gr.createString("data/gamed.d"), 180, 0);
        this.gr.setStringB("开始游戏#n离开游戏", Constants_H.WIDTH, 1);
        this.lv = (byte)lv_;
        this.imgBox = new Image[2];
        Image[] arr_image = this.imgBox;
        arr_image[0] = Ms.i().createImage("data/brow/m2");
        Image[] arr_image1 = this.imgBox;
        arr_image1[1] = Ms.i().createImage("data/brow/m3");
        this.boxNum = new byte[2];
        this.gameData = new byte[][]{new byte[]{-60, 17, 90}, new byte[]{8, 13, 20, 30}, new byte[]{1, 2, 3, 3}, new byte[]{6, 4, 2, 2}, new byte[]{83, 30, 55}};
        this.box = new int[3][4];
        this.imgMon = new Sprite[3];
        this.go(mode);
    }

    private void initGame() {
        byte[] arr_b = this.getGameMonList();
        for(int i = 0; i < 3; i = (byte)(i + 1)) {
            this.box[i][0] = i;
            this.box[i][1] = arr_b[i];
            this.box[i][2] = this.gameData[0][i] + 100;
            this.box[i][3] = 0;
        }
        Ms.i();
        this.maxTransNum = (byte)(Ms.getRandom(this.lv + 2) + 2 + this.lv);
        this.transNum = 0;
        this.mon_size_move = 0;
    }

    @Override  // minigame.MiniGame_H
    public boolean key() {
        if(Ms.i().key_delay()) {
            return false;
        }
        switch(this.state) {
            case 0: {
                if(Ms.i().key_Up_Down()) {
                    this.sel = (byte)(this.sel ^ 1);
                    return false;
                }
                if(Ms.i().key_S1_Num5()) {
                    Ms.i().keyRelease();
                    if(this.sel == 0 && this.gr.isMoney(this.sell_money, true)) {
                        this.go(1, ((int)this.lv));
                        return false;
                    }
                    if(this.sel == 1) {
                        Ms.i().keyRelease();
                        this.gr.about_a = null;
                        this.imgBox = null;
                        this.boxNum = null;
                        this.gameData = null;
                        this.box = null;
                        this.imgMon = null;
                        return true;
                    }
                }
                else if(Ms.i().key_S2()) {
                    Ms.i().keyRelease();
                    this.gr.about_a = null;
                    this.imgBox = null;
                    this.boxNum = null;
                    this.gameData = null;
                    this.box = null;
                    this.imgMon = null;
                    return true;
                }
                break;
            }
            case 3: {
                if(Ms.i().key_Left_Right()) {
                    GameRun gameRun0 = this.gr;
                    gameRun0.selectx = Ms.i().select(((int)this.gr.selectx), 0, this.box.length - 1);
                    return false;
                }
                if(Ms.i().key_S1_Num5()) {
                    Ms.i().keyRelease();
                    this.state = 4;
                    this.b_win = (byte)(this.gr.selectx == this.gr.selecty ? 1 : -1);
                    return false;
                }
                break;
            }
            default: {
                if(this.state == 4 && Ms.i().key_S1_Num5()) {
                    Ms.i().keyRelease();
                    if(this.b_win == 1) {
                        this.b_win = this.win();
                        if(this.b_win == 3) {
                            this.go(1, ((int)this.lv));
                            return false;
                        }
                    }
                    else if(this.b_win == -1 || this.b_win == 2 && this.gr.say_c == 0) {
                        if(this.b_win == 2 && this.gr.rmsOther[11] == 3) {
                            this.gr.rmsOther[11] = 4;
                            this.gr.getMonster(83, 25, 0, -1);
                        }
                        else if(this.b_win == -1 && this.gr.rmsOther[11] < 3) {
                            this.gr.rmsOther[11] = 0;
                        }
                        this.go(0, ((int)this.lv));
                        return false;
                    }
                }
            }
        }
        return false;
    }

    @Override  // minigame.MiniGame_H
    public void patin() {
        Ui.i().fillRectB();
        this.draw();
        if(this.state != 0) {
            this.drawGame();
        }
    }

    @Override  // minigame.MiniGame_H
    public void run() {
        switch(this.state) {
            case 1: {
                if(this.time < 20) {
                    this.time = (byte)(this.time + 1);
                    return;
                }
                if(this.box[0][3] < 150) {
                    for(int i = 0; i < 3; i = (byte)(i + 1)) {
                        int[] arr_v5 = this.box[i];
                        arr_v5[3] += 25;
                    }
                    return;
                }
                byte b = (byte)(this.time + 1);
                this.time = b;
                if(b >= 40) {
                    if(this.mon_size_move < 40) {
                        this.mon_size_move = (byte)(this.mon_size_move + 5);
                        return;
                    }
                    this.state = 2;
                    this.time = 0;
                    return;
                }
                break;
            }
            case 2: {
                if(this.time <= 0) {
                    if(this.transNum < this.maxTransNum) {
                        this.time = 1;
                        this.transNum = (byte)(this.transNum + 1);
                        byte[] arr_b = this.boxNum;
                        Ms.i();
                        arr_b[0] = (byte)Ms.getRandom(3);
                        do {
                            byte[] arr_b1 = this.boxNum;
                            Ms.i();
                            arr_b1[1] = (byte)Ms.getRandom(3);
                        }
                        while(this.boxNum[1] == this.boxNum[0]);
                        if(this.box[this.boxNum[1]][2] < this.box[this.boxNum[0]][2]) {
                            this.gameR = this.boxNum[1];
                            this.boxNum[1] = this.boxNum[0];
                            this.boxNum[0] = this.gameR;
                        }
                        Ms.i();
                        this.gameR = (byte)(Ms.abs(this.box[this.boxNum[1]][2] - this.box[this.boxNum[0]][2]) / 2);
                        this.tempTransNum = (byte)(this.gameR * 2 / this.gameData[1][this.lv]);
                        return;
                    }
                    this.time = 0;
                    this.state = 3;
                    do {
                        GameRun gameRun0 = this.gr;
                        Ms.i();
                        gameRun0.selecty = (byte)Ms.getRandom(this.box.length);
                    }
                    while(this.box[this.gr.selecty][1] == -1);
                    return;
                }
                if(this.time > this.tempTransNum) {
                    this.time = 0;
                    int[] temp = new int[4];
                    for(int i = 0; i < this.box.length; i = (byte)(i + 1)) {
                        for(int j = 0; j < this.box.length; j = (byte)(j + 1)) {
                            if(this.box[j][2] > this.box[i][2]) {
                                System.arraycopy(this.box[i], 0, temp, 0, 4);
                                System.arraycopy(this.box[j], 0, this.box[i], 0, this.box[j].length);
                                System.arraycopy(temp, 0, this.box[j], 0, 4);
                            }
                        }
                    }
                    for(int i = 0; i < 3; i = (byte)(i + 1)) {
                        this.box[i][2] = this.gameData[0][i] + 100;
                        this.box[i][3] = 150;
                    }
                    return;
                }
                this.time = (byte)(this.time + 1);
                int[] arr_v1 = this.box[this.boxNum[0]];
                arr_v1[2] += this.gameR * 2 / this.tempTransNum;
                int temp = this.gameR * 2 / this.tempTransNum * this.time;
                int[] arr_v2 = this.box[this.boxNum[0]];
                arr_v2[3] = 150 - Ms.i().sqrt(this.gameR * this.gameR - (temp - this.gameR) * (temp - this.gameR));
                int[] arr_v3 = this.box[this.boxNum[1]];
                arr_v3[2] -= this.gameR * 2 / this.tempTransNum;
                int[] arr_v4 = this.box[this.boxNum[1]];
                arr_v4[3] = Ms.i().sqrt(this.gameR * this.gameR - (temp - this.gameR) * (temp - this.gameR)) + 150;
                return;
            }
            case 4: {
                if(this.gr.selectx == 2 && this.box[this.gr.selectx][2] > this.gameData[0][1] + 100 || this.gr.selectx == 0 && this.box[this.gr.selectx][2] < this.gameData[0][1] + 100) {
                    int[] arr_v6 = this.box[this.gr.selectx];
                    arr_v6[2] += (this.gameData[0][1] - this.gameData[0][this.gr.selectx]) / 7;
                    return;
                }
                break;
            }
        }
    }

    private byte win() {
        byte b = (byte)(this.winNum + 1);
        this.winNum = b;
        if(b >= this.gameData[3][this.lv]) {
            int tm = this.sell_money + this.lv * this.lv * 150 + (2 - this.lv) * 25;
            this.gr.money += tm;
            this.gr.say("获得金钱：" + tm, 0);
            byte[] arr_b = this.gr.rmsOther;
            arr_b[10] = (byte)(arr_b[10] | 1 << this.lv);
            if(this.lv == 2 && this.gr.rmsOther[11] < 3) {
                byte[] arr_b1 = this.gr.rmsOther;
                arr_b1[11] = (byte)(arr_b1[11] + 1);
            }
            return 2;
        }
        return 3;
    }
}

