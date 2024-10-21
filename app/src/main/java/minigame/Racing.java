package minigame;

import dm.Ms;
import dm.Sprite;
import dm.Ui;
import javax.microedition.lcdui.Image;
import main.Constants_H;
import main.GameRun;

public class Racing implements MiniGame_H {
    private final short MAP_HEIGHT;
    private final byte NUM;
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

    public Racing(GameRun gr_) {
        this.NUM = 4;
        this.MAP_HEIGHT = 450;
        this.WIN_HEIGHT = 70;
        this.now_a = new byte[4][3];
        byte[] arr_b = new byte[4];
        arr_b[3] = -1;
        this.myDate = arr_b;
        this.cloud = new short[10][3];
        this.monY = new short[4];
        this.money = new short[]{100, 120, 300, 350, 1000, 1200};
        this.gDate = new short[][]{new short[]{450, 3, 8}, new short[]{390, 4, 9}, new short[]{270, 7, 6}, new short[]{210, 6, 10}};
        this.gr = gr_;
    }

    private void addCloud(int i) {
        short[] arr_v = this.cloud[i];
        Ms.i();
        arr_v[0] = (short)(Ms.getRandom(Constants_H.WIDTH_H) + 640);
        short[] arr_v1 = this.cloud[i];
        int v1 = this.srcY - 80;
        Ms.i();
        arr_v1[1] = (short)(v1 + (Ms.getRandom(25) + 55) * i);
        short[] arr_v2 = this.cloud[i];
        Ms.i();
        arr_v2[2] = (short)(Ms.getRandom(5) + 2);
    }

    private void draw0(int x, int y, int h, int fh) {
        Ui.i().fillRectB();
        Ui.i().drawString("游戏规则", 320, y + fh + 3, 33, 3, 1);
        Ui.i().drawUi(7, 270, y + fh - 13, 40, 0);
        Ui.i().drawUi(7, 370, y + fh - 13, 36, 4);
        Ui.i().drawK(x, y + fh + 3, 200, h, 4);
        Ui.i().drawK(x + 210, y + fh + 3, 200, h, 4);
        this.gr.showStringM("选择你认为会得第一的一只宠物和押注的大小，注数越大获胜后的奖励越丰厚！", x + 100, y + fh + 15, 7, 0);
        Ui.i().drawK(x + 420, y + fh + 3, 200, h, 4);
        Ui.i().drawStringY(this.gr.about_a, x + 445, y + fh + 15, fh, 0, 0);
        if(this.state == 0) {
            Ui.i().drawString("请选择押注大小：", x + 210, y + fh + 15, 0, 0, 0);
            for(int i = 0; i < this.length; ++i) {
                Ui.i().drawK(x + 0xF9, y + fh + 50 + (fh + 16) * i, 150, fh + 4, 1);
                Ui.i().drawString(this.gr.about_b[i].toString(), x + 0xF9, y + fh + 50 + (fh + 16) * i, 0, 3, 0);
                if(this.gr.pkey.isSelect(x + 0xF9, y + fh + 50 + (fh + 16) * i, 150, fh + 4)) {
                    if(this.sel == i) {
                        this.gr.pkey.setKey5();
                    }
                    else {
                        this.sel = (byte)i;
                    }
                }
            }
            Ui.i().drawK4(x + 0xF9, y + fh + 50 + this.sel * (fh + 16), 150, fh + 4);
        }
        this.gr.drawMoney(320, 360, 3, false);
        Ui.i().drawYesNo(true, true);
    }

    private void draw1(int x, int y, int h) {
        boolean z;
        Ui.i().drawK(0xD7, 33, 210, 325, 4);
        for(int i = 0; i < this.length; i = (byte)(i + 1)) {
            Ui.i().drawK(x + 25 + i * 52, y + 35, 44, h, 1);
            Ui ui0 = Ui.i();
            Sprite sprite0 = this.sp[0];
            byte[] arr_b = this.now_a[i];
            if(this.state != 1) {
                z = false;
            }
            else if(this.sel == i) {
                z = true;
            }
            else {
                z = false;
            }
            ui0.drawActionOne(sprite0, 0, x + 25 + i * 52 + 22, y + 33 + h, arr_b, 0, z);
            Ui.i().drawNum(i + 1, x + 25 + i * 52 + 27, y + 62, 20, 2);
        }
        if(this.state == 1) {
            Ui.i().drawK4(x + 25 + this.sel * 52, y + 35, 44, 76);
            Ui.i();
            byte b = this.gr.pkey.selectMenuX(4, 204, y + 35, 52, h);
            if(b != -1) {
                if(this.sel == b) {
                    this.gr.pkey.setKey5();
                }
                else {
                    this.sel = b;
                }
            }
        }
        Ui.i().drawString("兴奋度：", x + 25, y + 38 + h, 0, 0, 0);
        this.gr.drawFealty(6, 2, x + 0x7D, y + 44 + h);
        this.gr.showStringM("每喂一个兴奋菇花费10金，可增加一格兴奋度。", 320, y + 69 + h, 8, 0);
        Ui.i().drawString("请选择道具：", x + 25, y + (h + 0xA9), 0, 0, 0);
        for(int i = 0; i < this.length; i = (byte)(i + 1)) {
            Ui.i().drawK(x + 25 + i * 52, y + (h + 0xC5), 44, 34, 1);
            this.gr.drawItem(12, x + 25 + i * 52, y + (h + 0xC5) + 10, 0);
            Ui.i().drawString("x" + i, x + 25 + i * 52 + 16, y + (h + 0xC5) + 8, 0, 3, 1);
        }
        if(this.state == 2) {
            Ui.i().drawK4(x + 25 + this.sel * 52, y + (h + 0xC5), 44, 34);
            Ui.i();
            byte b1 = this.gr.pkey.selectMenuX(4, 204, y + (h + 0xC5) + 8, 52, 34);
            if(b1 != -1) {
                if(this.sel == b1) {
                    this.gr.pkey.setKey5();
                }
                else {
                    this.sel = b1;
                }
            }
        }
        Ui.i().drawYesNo(true, this.state != 1);
    }

    private void drawCloud() {
        for(int i = 0; i < this.cloud.length; i = (byte)(i + 1)) {
            Ui.i().drawImage(this.imgCloud, ((int)this.cloud[i][0]), this.cloud[i][1] - this.srcY, 0);
        }
        for(int i = 0; i < this.cloud.length; i = (byte)(i + 1)) {
            if(this.isNpcSrc(((int)this.cloud[i][0]), ((int)this.cloud[i][1]))) {
                this.addCloud(i);
            }
            else {
                short[] arr_v = this.cloud[i];
                arr_v[0] = (short)(arr_v[0] - this.cloud[i][2]);
            }
        }
    }

    private void drawEnd() {
        Ui.i().drawModuleOne(this.sp[1], 0, 0, 40 - this.srcY, 0, 0);
        for(int i = 0; i < 17; ++i) {
            Ui.i().drawModuleOne(this.sp[1], 1, i * 35 + 35, 44 - this.srcY, 0, 0);
        }
        Ui.i().drawModuleOne(this.sp[1], 0, 640, 40 - this.srcY, 1, 0);
    }

    private void drawGame() {
        Ui.i().fillRect(0x52C0FF, 0, 0, 640, 360);
        this.drawCloud();
        this.drawEnd();
        for(int i = 0; i < this.length; i = (byte)(i + 1)) {
            Ui.i().drawNum(i + 1, i * 100 + 0x93, 20 - this.srcY, 1, 2);
            Ui.i().drawActionOne(this.sp[0], 1, i * 100 + 0x93, this.monY[i] - this.srcY, this.now_a[i], 0, true);
        }
        if(this.state == 3 && this.time != 0) {
            Ui.i().drawNum(this.time / 20, 315, 180, 0, 2);
        }
    }

    @Override  // minigame.MiniGame_H
    public void go(int mode) {
        if(mode < 1) {
            this.sel = 0;
            this.state = 0;
            this.length = 3;
            this.gr.setStringB("一注：#n投入100金，#n获胜得120金。#n二注：#n投入300金，#n获胜得350金。#n三注：#n投入1000金，#n获胜得1200金。", Constants_H.WIDTH - 50, 0);
            this.gr.setStringB("一注100金#n二注300金#n三注1000金", Constants_H.WIDTH - 50, 1);
            return;
        }
        if(mode == 1) {
            this.myDate[0] = this.sel;
            this.sel = 0;
            this.state = 1;
            this.length = 4;
            return;
        }
        if(mode == 2) {
            this.myDate[1] = this.sel;
            this.sel = 0;
            this.state = 2;
            return;
        }
        if(mode == 3) {
            this.myDate[2] = this.sel;
            this.sel = 0;
            this.state = 3;
            this.srcY = 90;
            this.speedLv = 0;
            this.myDate[3] = -1;
            this.time = 70;
            for(int i = 0; i < this.length; i = (byte)(i + 1)) {
                this.monY[i] = 450;
            }
            for(int i = 0; i < this.cloud.length; i = (byte)(i + 1)) {
                this.addCloud(i);
            }
        }
    }

    @Override  // minigame.MiniGame_H
    public void go(int mode, int lv_) {
        this.lv = (byte)lv_;
        this.sp = new Sprite[3];
        Sprite[] arr_sprite = this.sp;
        arr_sprite[0] = Ms.i().createSprite("data/npc0/67", true);
        Sprite[] arr_sprite1 = this.sp;
        arr_sprite1[1] = Ms.i().createSprite("data/brow/m1", true);
        this.imgCloud = Ms.i().createImage("data/cloud");
        this.go(mode);
    }

    private boolean isNpcSrc(int ax, int ay) {
        return ax < -40 || ay - this.srcY > Constants_H.HEIGHT + 20;
    }

    @Override  // minigame.MiniGame_H
    public boolean key() {
        if(Ms.i().key_delay()) {
            return false;
        }
        switch(this.state) {
            case 0: {
                if(Ms.i().key_Up_Down()) {
                    this.sel = Ms.i().select(((int)this.sel), 0, this.length - 1);
                    return false;
                }
                if(Ms.i().key_S1_Num5() && this.gr.isMoney(((int)this.money[this.sel << 1]), true)) {
                    this.go(1);
                    return false;
                }
                if(Ms.i().key_S2()) {
                    this.nullGame();
                    return true;
                }
                break;
            }
            case 1: {
                if(Ms.i().key_Left_Right()) {
                    this.sel = Ms.i().select(((int)this.sel), 0, this.length - 1);
                    return false;
                }
                if(Ms.i().key_S1_Num5()) {
                    this.go(2);
                    return false;
                }
                break;
            }
            case 2: {
                if(Ms.i().key_Left_Right()) {
                    this.sel = Ms.i().select(((int)this.sel), 0, this.length - 1);
                    return false;
                }
                if(Ms.i().key_S1_Num5() && this.gr.isMoney(this.sel * 10, true)) {
                    this.go(3);
                    return false;
                }
                if(Ms.i().key_S2()) {
                    this.sel = this.myDate[1];
                    this.state = 1;
                    return false;
                }
                break;
            }
            default: {
                return false;
            }
        }
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

    @Override  // minigame.MiniGame_H
    public void patin() {
        if(this.state == 0 || this.state == 1 || this.state == 2) {
            this.draw0(10, 5, 325, 25);
            if(this.state == 1 || this.state == 2) {
                this.draw1(0xC6, 15, 76);
            }
            return;
        }
        this.drawGame();
    }

    @Override  // minigame.MiniGame_H
    public void run() {
        switch(this.state) {
            case 3: {
                if(this.time != 0) {
                    this.time = (byte)(this.time - 1);
                    return;
                }
                this.setSpeed();
                if(this.myDate[3] != -1) {
                    this.time = 5;
                    this.state = 4;
                    return;
                }
                int j = -1;
                for(byte i = 0; i < 4; i = (byte)(i + 1)) {
                    this.monY[i] = (short)(this.monY[i] - this.now_a[i][2]);
                    if(this.monY[i] - this.srcY < Constants_H.HEIGHT_H) {
                        j = i;
                    }
                    if(this.monY[i] < 70 && this.myDate[3] == -1) {
                        this.myDate[3] = i;
                    }
                }
                if(j != -1) {
                    this.srcY = (short)(this.srcY - this.now_a[j][2]);
                }
                if(this.srcY < 0) {
                    this.srcY = 0;
                    return;
                }
                break;
            }
            case 4: {
                if(this.time == 3) {
                    if(this.myDate[3] == this.myDate[1]) {
                        this.gr.money += this.money[this.myDate[0] * 2 + 1];
                        this.gr.say("获得：" + ((int)this.money[this.myDate[0] * 2 + 1]) + "金", 0);
                        byte[] arr_b = this.gr.rmsOther;
                        arr_b[4] = (byte)(arr_b[4] | 1 << this.lv);
                    }
                    else {
                        this.gr.say("不好意思，没有猜对。", 0);
                    }
                }
                if(this.time > 0) {
                    this.time = (byte)(this.time - 1);
                    return;
                }
                if(this.time == 0 && this.gr.say_c == 0) {
                    this.go(0);
                    return;
                }
                break;
            }
        }
    }

    private void setSpeed() {
        if(this.speedLv < this.gDate.length) {
            int i;
            for(i = 0; i < 4 && this.monY[i] > this.gDate[this.speedLv][0]; i = (byte)(i + 1)) {
            }
            if(i < 4) {
                for(int i = 0; i < 4; i = (byte)(i + 1)) {
                    byte[] arr_b = this.now_a[i];
                    Ms.i();
                    arr_b[2] = (byte)(Ms.getRandom(this.gDate[this.speedLv][1]) + this.gDate[this.speedLv][1]);
                }
                this.speedLv = (byte)(this.speedLv + 1);
            }
        }
    }
}

