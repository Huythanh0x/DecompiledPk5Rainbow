package minigame;

import dm.Ms;
import dm.Ui;
import main.Constants_H;
import main.GameRun;

public class Cards implements MiniGame_H {
    private short count;
    private byte[][] findC;
    private byte[][] findN;
    private byte find_count;
    private short gh;
    GameRun gr;
    private short gspace;
    private short gw;
    private short gx;
    private short gy;
    private short hh;
    private byte length;
    private byte lv;
    private byte[][] num;
    byte sel;
    private int sell_money;
    private byte selx;
    private byte sely;
    private byte state;
    private byte time;
    private byte tx;
    private byte ty;
    private short wh;

    public Cards(GameRun gr_) {
        this.gw = 30;
        this.gh = 40;
        this.gspace = 4;
        this.wh = 320;
        this.hh = 0xA0;
        this.time = 3;
        this.find_count = 3;
        this.num = new byte[][]{new byte[]{3, 4}, new byte[]{3, 6}, new byte[]{4, 6}, new byte[]{5, 6}};
        this.gr = gr_;
    }

    public void draw0(int x, int y, int h) {
        Ui.i().fillRectB();
        Ui.i().drawK(x, y + 30, 190, h, 4);
        Ui.i().drawK(x + 200, y + 30, 220, h, 4);
        Ui.i().drawK(x + 430, y + 30, 190, h, 4);
        if(this.state == 0) {
            Ui.i().drawString("游戏规则", 320, y + 30, 33, 3, 1);
            Ui.i().drawUi(7, 277, y + 25, 40, 0);
            Ui.i().drawUi(7, 377, y + 25, 36, 4);
        }
        Ui.i().drawStringY(this.gr.about_a, 25, y + 35, 25, 0, 0);
        if(this.state == 0) {
            this.gr.showStringM("需要的参加费：" + this.sell_money + "金", 320, y + h - 50, 7, 0);
            Ui.i().drawListKY(2, x + 0xED, y + 80, 150, 3, 30, 10, ((int)this.sel), 4, 2);
            for(int i = 0; i < this.gr.about_b.length; ++i) {
                Ui.i().drawString(this.gr.about_b[i].toString(), x + 0x10A, i * 40 + (y + 80) - 2, 0, (this.sel == i ? 0 : 3), 1);
                if(this.gr.pkey.isSelect(x + 0xED, i * 40 + (y + 80) - 2, 150, 40)) {
                    if(this.sel == i) {
                        this.gr.pkey.setKey5();
                    }
                    else {
                        this.sel = (byte)i;
                    }
                }
            }
        }
        this.gr.drawMoney(320, 360, 3, false);
        if(this.state == 0) {
            Ui.i().drawYesNo(true, true);
        }
    }

    private void drawCard(int i, int j, int x, int y, int mode) {
        if(mode == 0) {
            Ui.i().drawK(x, y, ((int)this.gw), ((int)this.gh), 1);
            Ui.i().drawUi(25, (this.gw >> 1) + x, (this.gh >> 1) + y, 3, 0);
            return;
        }
        if(mode == 1) {
            Ui.i().drawK((this.gw >> 1) + x - 2, y - 3, 5, this.gh + 6, 1);
            byte[] arr_b = this.findC[i];
            byte b = (byte)(arr_b[j] + 1);
            arr_b[j] = b;
            if(b > 3) {
                this.findC[i][j] = 0;
                return;
            }
            return;
        }
        Ui.i().drawK(x, y, ((int)this.gw), ((int)this.gh), 5);
        this.gr.drawItem(((int)this.findN[i][j]), (this.gw >> 1) + x, (this.gh >> 1) + y, 3);
        Ui.i().drawNum(((int)this.findN[i][j]), this.gw + x, this.gh + y, 40, 0);
    }

    private void drawGame(int x, int y, int h) {
        for(int i = 0; i < this.findN.length; ++i) {
            for(int j = 0; j < this.findN[i].length; ++j) {
                int v5 = (this.gw + this.gspace) * j + (this.wh + this.gx);
                int v6 = (this.gh + this.gspace) * i + (this.hh + this.gy);
                int v7 = this.findC[i][j] == 3 ? 1 : this.findC[i][j];
                this.drawCard(i, j, v5, v6, v7);
                if(this.gr.pkey.isSelect(this.wh + this.gx + (this.gw + this.gspace) * j, this.hh + this.gy + (this.gh + this.gspace) * i, this.gw + this.gspace, this.gh + this.gspace) && this.state < 3) {
                    this.tx = (byte)j;
                    this.ty = (byte)i;
                    this.gr.pkey.setKey5();
                }
            }
        }
        Ui.i().drawRectZ(0xEAFCFF, this.wh + this.gx + this.tx * (this.gw + this.gspace), this.hh + this.gy + this.ty * (this.gh + this.gspace), ((int)this.gw), ((int)this.gh), 3);
        if(this.count > 0) {
            Ui.i().drawNum(this.count / 10, 330, 29, 36, 2);
            return;
        }
        Ui.i().drawString("游戏开始", 320, 4, 17, 3, 0);
        this.gr.showStringM("可错次数：" + (this.time >= 0 ? this.time - 1 : 0) + "次", 520, 105, 5, 0);
    }

    @Override  // minigame.MiniGame_H
    public void go(int mode) {
        int k;
        this.gr.line_max = 9;
        this.count = 100;
        this.time = (byte)(this.lv * 2 + 4);
        this.find_count = (byte)(this.num[this.lv][0] * this.num[this.lv][1] / 2);
        if(mode < 1) {
            this.ty = 0;
            this.state = 0;
            this.sell_money = this.lv * 200 + 200;
            return;
        }
        this.gx = (short)(-((this.gw + this.gspace) * this.num[this.lv][1]) >> 1);
        this.gy = (short)(-((this.gh + this.gspace) * this.num[this.lv][0]) >> 1);
        this.ty = 0;
        this.tx = 0;
        this.state = 1;
        byte[] randN = new byte[this.find_count];
        for(int i = 0; i < this.findC.length; i = (byte)(i + 1)) {
            for(int j = 0; j < this.findC[i].length; j = (byte)(j + 1)) {
                this.findC[i][j] = 2;
                this.findN[i][j] = 0;
            }
        }
        int i = 0;
        while(i < randN.length) {
            Ms.i();
            byte rd = (byte)(Ms.getRandom(35) + 1);
            int j;
            for(j = (byte)(randN.length - 1); j > -1 && randN[j] != rd; j = (byte)(j - 1)) {
            }
            if(j == -1) {
                randN[i] = rd;
                i = (byte)(i + 1);
            }
        }
        for(int i = 0; i < randN.length; i = (byte)(i + 1)) {
            for(int j = 0; j < 2; j = (byte)(j + 1)) {
                do {
                    Ms.i();
                    k = (byte)Ms.getRandom(this.num[this.lv][0] * this.num[this.lv][1]);
                }
                while(this.findN[k / this.num[this.lv][1]][k % this.num[this.lv][1]] != 0);
                this.findN[k / this.num[this.lv][1]][k % this.num[this.lv][1]] = randN[i];
            }
        }
    }

    @Override  // minigame.MiniGame_H
    public void go(int mode, int lv_) {
        this.gr.setStringB(this.gr.createString("data/gamec.d"), 0xA0, 0);
        this.gr.setStringB("开始游戏#n离开游戏", Constants_H.WIDTH, 1);
        this.lv = (byte)lv_;
        this.findN = null;
        this.findN = new byte[this.num[this.lv][0]][this.num[this.lv][1]];
        this.findC = null;
        this.findC = new byte[this.num[this.lv][0]][this.num[this.lv][1]];
        this.length = 9;
        this.go(mode);
    }

    @Override  // minigame.MiniGame_H
    public boolean key() {
        if(Ms.i().key_delay()) {
            return false;
        }
        if(this.state == 0) {
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
                    this.nullGame();
                    return true;
                }
            }
            else if(Ms.i().key_S2()) {
                Ms.i().keyRelease();
                this.nullGame();
                return true;
            }
        }
        else if(this.state < 3) {
            if(Ms.i().key_Up_Down()) {
                this.ty = Ms.i().select(((int)this.ty), 0, this.findN.length - 1);
                return false;
            }
            if(Ms.i().key_Left_Right()) {
                this.tx = Ms.i().select(((int)this.tx), 0, this.findN[this.ty].length - 1);
                return false;
            }
            if(Ms.i().key_S1_Num5()) {
                Ms.i().keyRelease();
                if(this.state == 0) {
                    this.go(0, ((int)this.lv));
                    return false;
                }
                if(this.findC[this.ty][this.tx] == 0) {
                    byte[] arr_b = this.findC[this.ty];
                    arr_b[this.tx] = (byte)(arr_b[this.tx] + 1);
                    byte b = (byte)(this.state + 1);
                    this.state = b;
                    if(b == 2) {
                        this.selx = this.tx;
                        this.sely = this.ty;
                        return false;
                    }
                }
            }
        }
        return false;
    }

    private void nullGame() {
        this.findN = null;
        this.findC = null;
        this.num = null;
    }

    @Override  // minigame.MiniGame_H
    public void patin() {
        this.draw0(10, 2, 280);
        if(this.state != 0) {
            this.drawGame(10, 2, (this.length + 3) * 25);
        }
    }

    @Override  // minigame.MiniGame_H
    public void run() {
        if(this.time < 1) {
            switch(this.time) {
                case -1: {
                    goto label_6;
                }
                case 0: {
                    this.time = -1;
                    this.gr.say("游戏失败！！！", -1);
                    return;
                }
            }
            return;
        label_6:
            if(this.gr.say_c == 0) {
                this.go(0, ((int)this.lv));
            }
        }
        else if(this.find_count < 1) {
            switch(this.find_count) {
                case -1: {
                    goto label_18;
                }
                case 0: {
                    goto label_12;
                }
            }
            return;
        label_12:
            this.find_count = -1;
            this.gr.money += this.time * 0x7D + 100;
            this.gr.say("获得金钱：" + (this.time * 0x7D + 100), -1);
            byte[] arr_b = this.gr.rmsOther;
            arr_b[8] = (byte)(arr_b[8] | 1 << this.lv);
            return;
        label_18:
            if(this.gr.say_c == 0) {
                this.go(0, ((int)this.lv));
            }
        }
        else if(this.state >= 3) {
            byte b = (byte)(this.state + 1);
            this.state = b;
            if(b > 10) {
                this.state = 1;
                return;
            }
            if(this.state == 10) {
                if(this.findN[this.ty][this.tx] != this.findN[this.sely][this.selx]) {
                    this.findC[this.ty][this.tx] = 3;
                    this.findC[this.sely][this.selx] = 3;
                    this.time = (byte)(this.time - 1);
                    return;
                }
                this.find_count = (byte)(this.find_count - 1);
            }
        }
        else if(this.count > 0) {
            short v = (short)(this.count - 1);
            this.count = v;
            if(v == 0) {
                for(int i = 0; i < this.findC.length; i = (byte)(i + 1)) {
                    for(int j = 0; j < this.findC[i].length; j = (byte)(j + 1)) {
                        this.findC[i][j] = 3;
                    }
                }
            }
        }
    }
}

