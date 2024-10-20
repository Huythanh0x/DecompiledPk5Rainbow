package minigame;

import dm.Ms;
import dm.Sprite;
import dm.Ui;
import javax.microedition.lcdui.Image;
import main.Constants_H;
import main.GameRun;

public class Bearer implements MiniGame_H {
    private final byte SPEED;
    private short ballC0;
    private short ballC1;
    private short[][] ballDate;
    private byte[] ball_time;
    private Sprite bsp;
    private short count;
    private byte cur;
    private short[][] gDate;
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

    public Bearer(GameRun gr_) {
        this.gDate = new short[][]{new short[]{9, 1, 10, 2, 11, 4, 27, 8, 2, -10}, new short[]{50, 100, 150, 200}, new short[]{60, 40, 30, 10}, new short[]{8, 6, 13, 3, 20, 5, 30, 10}};
        this.ballDate = new short[][]{new short[]{10, 20, 60, 10, 220}, new short[]{13, 40, 60, 12, 170}, new short[]{10, 40, 60, 10, 120}};
        this.money = new short[]{150, 200, 300, 450};
        this.xy = new short[40][7];
        this.myxy = new short[]{0, 275, 67, 10, 0};
        this.ball_time = new byte[]{20, 15, 10, 5};
        this.SPEED = 10;
        this.gr = gr_;
    }

    private void addBall(int id) {
        this.xy[this.cur][0] = -20;
        this.xy[this.cur][1] = this.ballDate[id][4];
        this.xy[this.cur][2] = (short)(this.ballDate[id][1] / this.ballDate[id][0]);
        this.xy[this.cur][4] = this.ballDate[id][0];
        this.xy[this.cur][5] = (short)id;
        this.xy[this.cur][3] = this.ballDate[id][3];
        short[] arr_v = this.xy[this.cur];
        Ms.i();
        arr_v[6] = (short)Ms.getRandom(this.gDate[0].length >> 1);
        byte b = (byte)(this.cur + 1);
        this.cur = b;
        if(b >= this.xy.length) {
            this.cur = 0;
        }
    }

    private void draw0(int x, int y, int h) {
        Ui.i().fillRectB();
        Ui.i().drawK(x, y + 30, 190, h + 45, 4);
        Ui.i().drawK(x + 210, y + 30, 200, h + 45, 4);
        Ui.i().drawK(x + 430, y + 30, 190, h + 45, 4);
        Ui.i().drawString("游戏规则", 320, y + 30, 33, 3, 1);
        Ui.i().drawUi(7, 0x109, y + 21, 40, 0);
        Ui.i().drawUi(7, 375, y + 21, 36, 4);
        Ui.i().drawStringY(this.gr.about_a, 25, y + 85, 25, 0, 0);
        Ui.i().drawString("球的分数：", x + 440, y + 100, 0, 0, 0);
        for(int i = 0; i < this.gDate[0].length; i += 2) {
            this.gr.drawItem(this.gDate[0][i], x + 445 + (i % 4 == 2 ? 100 : 0), (i >> 2) * 30 + (y + 150), 0);
            Ui.i().drawString(String.valueOf((this.gDate[0][i + 1] >= 0 ? "+" : "")) + this.gDate[0][i + 1], x + 445 + (i % 4 == 2 ? 100 : 0) + 16, (i >> 2) * 30 + (y + 150) - 4, 0, 0, 1);
        }
        Ui.i().drawListKY(2, x + 0xED, y + 100, 150, 3, 30, 10, ((int)this.sel), 4, 2);
        for(int i = 0; i < this.gr.about_b.length; ++i) {
            System.out.println("i   " + i);
            Ui.i().drawString(this.gr.about_b[i].toString(), x + 0x10A, i * 40 + (y + 100) - 2, 0, (this.sel == i ? 0 : 3), 1);
            if(this.gr.pkey.isSelect(x + 0xED, i * 40 + (y + 100) - 2, 150, 40)) {
                System.out.println("asdfasfaf");
                if(this.sel == i) {
                    this.gr.pkey.setKey5();
                }
                else {
                    this.sel = (byte)i;
                }
            }
        }
        this.gr.showStringM("需要的参加费：" + ((int)this.money[this.lv]) + "金", 320, y + (h + 45) - 50, 7, 0);
        this.gr.drawMoney(320, 360, 3, false);
        if(this.state == 0) {
            Ui.i().drawYesNo(true, true);
        }
    }

    private void drawGame(int x, int y, int w, int h) {
        Ui.i().fillRect(0x52C0FF, x, y, w, h);
        Ui.i().drawFrameOne(this.bsp, 0, x + (w >> 1), y + (h >> 1), 0);
        Ui.i().drawString("分数：" + ((int)this.count), (w >> 1) + x - 25, y, 24, 3, 1);
        Ui.i().drawString("球总数：" + ((int)this.ballC0), (w >> 1) + x + 25, y, 20, 3, 1);
        Ui.i().drawImage(this.img, x + w, h - 15, 40);
        for(int i = 0; i < this.xy.length; i = (byte)(i + 1)) {
            if(this.xy[i][5] != -1) {
                this.gr.drawItem(((int)this.gDate[0][this.xy[i][6] << 1]), this.xy[i][0] + x, this.xy[i][1] + y, 0);
            }
        }
        for(int i = 0; i < 2; i = (byte)(i + 1)) {
            Ui.i().drawFrameOne(this.sp[0], (this.myxy[4] == 0 ? 3 : 4), this.myxy[0] + x + i * 30 + 20, this.myxy[1] + y + 25, 0);
        }
        this.gr.drawMoney(320, 360, 3, false);
    }

    private void getAY(int i) {
        if(this.xy[i][4] > 0 && this.xy[i][3] > 1) {
            short[] arr_v = this.xy[i];
            arr_v[3] = (short)(arr_v[3] - 1);
            return;
        }
        if(this.xy[i][4] == 0) {
            this.xy[i][3] = 0;
            return;
        }
        if(this.xy[i][4] < 0 && this.xy[i][3] > -this.ballDate[this.xy[i][5]][3]) {
            short[] arr_v1 = this.xy[i];
            arr_v1[3] = (short)(arr_v1[3] - 1);
        }
    }

    @Override  // minigame.MiniGame_H
    public void go(int mode) {
        if(mode < 1) {
            this.state = 0;
            this.length = 10;
            this.gr.setStringB("在限定时间里接尽量多的球到框里，最后根据框里球的分数来换取金钱。", 0xA0, 0);
            this.gr.setStringB("开始游戏#n离开游戏", Constants_H.WIDTH, 1);
            return;
        }
        if(mode == 1) {
            this.state = 1;
            this.count = 0;
            this.cur = 0;
            this.ballC0 = this.gDate[1][this.lv];
            this.initABall(true);
            for(int i = 0; i < this.xy.length; i = (byte)(i + 1)) {
                this.xy[i][5] = -1;
            }
        }
    }

    @Override  // minigame.MiniGame_H
    public void go(int mode, int lv_) {
        this.lv = (byte)lv_;
        this.sp = new Sprite[2];
        Sprite[] arr_sprite = this.sp;
        arr_sprite[0] = Ms.i().createSprite("data/npc2/38", true);
        this.img = Ms.i().createImage("data/brow/m0");
        byte[] arr_b = Ms.i().getStream("data/gamee.data", -1);
        Ms.i();
        Ms.skip = 0;
        this.bsp = Sprite.Create(Ms.i().createImage("data/map/5"), Ms.i().createShort2Array(arr_b, 2), Ms.i().createShort3Array(arr_b, 2), Ms.i().createShort3Array(arr_b, 2));
        this.go(mode);
    }

    private void initABall(boolean mode) {
        this.time0 = mode ? 10 : this.gDate[2][this.lv];
        this.time1 = this.ball_time[this.lv];
        Ms.i();
        this.ballC1 = (short)(Ms.getRandom(this.gDate[3][this.lv << 1]) + this.gDate[3][(this.lv << 1) + 1]);
    }

    private boolean isCollision(int i) {
        return Ms.i().isRect(((int)this.myxy[0]), ((int)this.myxy[1]), ((int)this.myxy[2]), ((int)this.myxy[3]), ((int)this.xy[i][0]), ((int)this.xy[i][1]), 16, 16);
    }

    private boolean isSrc(int i) {
        boolean bb = this.xy[i][1] > 330;
        if(Ms.i().isRect(230, 280, 20, 10, ((int)this.xy[i][0]), ((int)this.xy[i][1]), 16, 16) || this.xy[i][0] > 0xF0 && this.xy[i][1] < this.myxy[1]) {
            bb = true;
            this.count = (short)(this.count + this.gDate[0][this.xy[i][6] * 2 + 1]);
        }
        return bb;
    }

    @Override  // minigame.MiniGame_H
    public boolean key() {
        switch(this.state) {
            case 0: {
                if(Ms.i().key_Up_Down()) {
                    this.sel = (byte)(this.sel ^ 1);
                    return false;
                }
                if(Ms.i().key_S1_Num5()) {
                    Ms.i().keyRelease();
                    if(this.sel == 0 && this.gr.isMoney(((int)this.money[this.lv]), true)) {
                        this.go(1);
                        return false;
                    }
                    if(this.sel == 1) {
                        Ms.i().keyRelease();
                        this.nullGame();
                        return true;
                    }
                }
                else if(Ms.i().key_S2()) {
                    this.nullGame();
                    return true;
                }
                break;
            }
            case 1: {
                if(Ms.i().key_Left()) {
                    this.myxy[0] = (short)(this.myxy[0] - 10);
                    if(this.myxy[0] < 0) {
                        this.myxy[0] = 0;
                        return false;
                    }
                }
                else if(Ms.i().key_Right()) {
                    this.myxy[0] = (short)(this.myxy[0] + 10);
                    if(this.myxy[0] + this.myxy[2] > 220) {
                        this.myxy[0] = (short)(220 - this.myxy[2]);
                        return false;
                    }
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
        this.gDate = null;
        this.money = null;
        this.sp = null;
        this.img = null;
        this.ballDate = null;
    }

    @Override  // minigame.MiniGame_H
    public void patin() {
        this.draw0(10, 2, this.length * 25);
        if(this.state != 0) {
            this.drawGame(200, 0, 0xF0, 320);
        }
    }

    @Override  // minigame.MiniGame_H
    public void run() {
        switch(this.state) {
            case 1: {
                if(this.ballC0 > 0) {
                    if(this.time0 > 0) {
                        this.time0 = (short)(this.time0 - 1);
                    }
                    else if(this.time1 > 0) {
                        this.time1 = (short)(this.time1 - 1);
                    }
                    else if(this.ballC1 > 0) {
                        this.time1 = this.ball_time[this.lv];
                        this.addBall(Ms.getRandom(this.ballDate.length));
                        this.ballC1 = (short)(this.ballC1 - 1);
                        this.ballC0 = (short)(this.ballC0 - 1);
                    }
                    else if(this.ballC1 == 0) {
                        this.initABall(false);
                    }
                }
                if(this.myxy[4] > 0) {
                    this.myxy[4] = (short)(this.myxy[4] - 1);
                }
                boolean bb = true;
                for(int i = 0; i < this.xy.length; i = (byte)(i + 1)) {
                    if(this.xy[i][5] != -1) {
                        bb = false;
                        short[] arr_v = this.xy[i];
                        arr_v[0] = (short)(arr_v[0] + this.xy[i][2]);
                        short[] arr_v1 = this.xy[i];
                        arr_v1[1] = (short)(arr_v1[1] - this.xy[i][3]);
                        this.getAY(i);
                        short[] arr_v2 = this.xy[i];
                        arr_v2[4] = (short)(arr_v2[4] - 1);
                        if(this.isSrc(i)) {
                            this.xy[i][5] = -1;
                        }
                        else if(this.isCollision(i)) {
                            this.xy[i][4] = this.ballDate[this.xy[i][5]][0];
                            this.myxy[4] = 1;
                            this.xy[i][3] = this.ballDate[this.xy[i][5]][3];
                        }
                    }
                }
                if(this.ballC0 < 1 && bb) {
                    this.count = (short)(this.count * 15 / 10);
                    this.gr.money += this.count;
                    this.gr.say("获得：" + ((int)this.count) + "金", 0);
                    if(this.count > 0) {
                        byte[] arr_b = this.gr.rmsOther;
                        arr_b[6] = (byte)(arr_b[6] | 1 << this.lv);
                    }
                    this.state = 2;
                }
                this.gr.pkey.checkButton(4);
                return;
            }
            case 2: {
                if(this.gr.say_c == 0) {
                    this.go(0);
                }
            }
        }
    }

    public void setLv(int lv_) {
        this.lv = (byte)lv_;
    }
}

