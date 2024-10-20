package minigame;

import main.Constants_H;
import dm.Ms;
import dm.Ui;
import main.GameRun;

public class Cards implements MiniGame_H
{
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
    
    public Cards(final GameRun gr) {
        super();
        this.gw = 30;
        this.gh = 40;
        this.gspace = 4;
        this.wh = 320;
        this.hh = 160;
        this.time = 3;
        this.find_count = 3;
        this.num = new byte[][] { { 3, 4 }, { 3, 6 }, { 4, 6 }, { 5, 6 } };
        this.gr = gr;
    }
    
    private void drawCard(final int n, final int n2, final int n3, final int n4, final int n5) {
        if (n5 == 0) {
            Ui.i().drawK(n3, n4, this.gw, this.gh, 1);
            Ui.i().drawUi(25, (this.gw >> 1) + n3, (this.gh >> 1) + n4, 3, 0);
        }
        else if (n5 == 1) {
            Ui.i().drawK((this.gw >> 1) + n3 - 2, n4 - 3, 5, this.gh + 6, 1);
            final byte[] array = this.findC[n];
            if (++array[n2] > 3) {
                this.findC[n][n2] = 0;
            }
        }
        else {
            Ui.i().drawK(n3, n4, this.gw, this.gh, 5);
            this.gr.drawItem(this.findN[n][n2], (this.gw >> 1) + n3, (this.gh >> 1) + n4, 3);
            Ui.i().drawNum(new StringBuilder().append(this.findN[n][n2]).toString(), this.gw + n3, this.gh + n4, 40, 0);
        }
    }
    
    private void drawGame(int i, int j, int n) {
        short wh;
        short gx;
        short gw;
        short gspace;
        short hh;
        short gy;
        short gh;
        short gspace2;
        for (i = 0; i < this.findN.length; ++i) {
            for (j = 0; j < this.findN[i].length; ++j) {
                wh = this.wh;
                gx = this.gx;
                gw = this.gw;
                gspace = this.gspace;
                hh = this.hh;
                gy = this.gy;
                gh = this.gh;
                gspace2 = this.gspace;
                if (this.findC[i][j] == 3) {
                    n = 1;
                }
                else {
                    n = this.findC[i][j];
                }
                this.drawCard(i, j, (gw + gspace) * j + (wh + gx), (gh + gspace2) * i + (hh + gy), n);
                if (this.gr.pkey.isSelect(this.wh + this.gx + (this.gw + this.gspace) * j, this.hh + this.gy + (this.gh + this.gspace) * i, this.gw + this.gspace, this.gh + this.gspace) && this.state < 3) {
                    this.tx = (byte)j;
                    this.ty = (byte)i;
                    this.gr.pkey.setKey5();
                }
            }
        }
        Ui.i().drawRectZ(15400191, this.wh + this.gx + this.tx * (this.gw + this.gspace), this.hh + this.gy + this.ty * (this.gh + this.gspace), this.gw, this.gh, 3);
        if (this.count > 0) {
            Ui.i().drawNum(new StringBuilder().append(this.count / 10).toString(), 320 + 10, 29, 36, 2);
        }
        else {
            Ui.i().drawString("\u6e38\u620f\u5f00\u59cb", 320, 4, 17, 3, 0);
            final GameRun gr = this.gr;
            final StringBuilder sb = new StringBuilder("\u53ef\u9519\u6b21\u6570\uff1a");
            if (this.time < 0) {
                i = 0;
            }
            else {
                i = this.time - 1;
            }
            gr.showStringM(sb.append(i).append("\u6b21").toString(), 320 + 200, 180 - 75, 5, 0);
        }
    }
    
    private void nullGame() {
        this.findN = null;
        this.findC = null;
        this.num = null;
    }
    
    public void draw0(final int n, int i, int n2) {
        Ui.i().fillRectB();
        Ui.i().drawK(n, i + 25 + 5, 200 - 10, n2, 4);
        Ui.i().drawK(n + 200, i + 25 + 5, 200 + 20, n2, 4);
        Ui.i().drawK(n + 420 + 10, i + 25 + 5, 200 - 10, n2, 4);
        if (this.state == 0) {
            Ui.i().drawString("\u6e38\u620f\u89c4\u5219", 320, i + 25 + 5, 33, 3, 1);
            Ui.i().drawUi(7, 320 - 50 + 7, i + 25, 40, 0);
            Ui.i().drawUi(7, 320 + 50 + 7, i + 25, 36, 4);
        }
        Ui.i().drawStringY(this.gr.about_a, 25, i + 25 + 10, 25, 0, 0);
        if (this.state == 0) {
            this.gr.showStringM("\u9700\u8981\u7684\u53c2\u52a0\u8d39\uff1a" + this.sell_money + "\u91d1", 320, i + n2 - 50, 7, 0);
            final int n3 = i + 75 + 5;
            Ui.i().drawListKY(2, n + 200 + 12 + 25, n3, 200 - 50, 3, 30, 10, this.sel, 4, 2);
            Ui j;
            String string;
            for (i = 0; i < this.gr.about_b.length; ++i) {
                j = Ui.i();
                string = this.gr.about_b[i].toString();
                if (this.sel == i) {
                    n2 = 0;
                }
                else {
                    n2 = 3;
                }
                j.drawString(string, n + 200 + 15 + 25 + 26, i * 40 + n3 - 2, 0, n2, 1);
                if (this.gr.pkey.isSelect(n + 200 + 12 + 25, i * 40 + n3 - 2, 200 - 50, 40)) {
                    if (this.sel == i) {
                        this.gr.pkey.setKey5();
                    }
                    else {
                        this.sel = (byte)i;
                    }
                }
            }
        }
        this.gr.drawMoney(320, 360, 3, false);
        if (this.state == 0) {
            Ui.i().drawYesNo(true, true);
        }
    }
    
    @Override
    public void go(int i) {
        this.gr.line_max = 9;
        this.count = 100;
        this.time = (byte)(this.lv * 2 + 4);
        this.find_count = (byte)(this.num[this.lv][0] * this.num[this.lv][1] / 2);
        if (i < 1) {
            this.ty = 0;
            this.state = 0;
            this.sell_money = this.lv * 200 + 200;
        }
        else {
            this.gx = (short)(-((this.gw + this.gspace) * this.num[this.lv][1]) >> 1);
            this.gy = (short)(-((this.gh + this.gspace) * this.num[this.lv][0]) >> 1);
            this.ty = 0;
            this.tx = 0;
            this.state = 1;
            i = 0;
            final byte[] array = new byte[this.find_count];
            while (i < this.findC.length) {
                for (int j = 0; j < this.findC[i].length; j = (byte)(j + 1)) {
                    this.findC[i][j] = 2;
                    this.findN[i][j] = 0;
                }
                i = (byte)(i + 1);
            }
            byte b;
            byte b2;
            for (i = 0; i < array.length; i = (byte)(i + 1)) {
                Ms.i();
                for (b = (byte)(Ms.getRandom(35) + 1), b2 = (byte)(array.length - 1); b2 > -1 && array[b2] != b; --b2) {}
                if (b2 == -1) {
                    array[i] = b;
                }
            }
            int k;
            byte b3;
            for (i = 0; i < array.length; i = (byte)(i + 1)) {
                for (k = 0; k < 2; k = (byte)(k + 1)) {
                    do {
                        Ms.i();
                        b3 = (byte)Ms.getRandom(this.num[this.lv][0] * this.num[this.lv][1]);
                    } while (this.findN[b3 / this.num[this.lv][1]][b3 % this.num[this.lv][1]] != 0);
                    this.findN[b3 / this.num[this.lv][1]][b3 % this.num[this.lv][1]] = array[i];
                }
            }
            final byte[] array2 = (byte[])null;
        }
    }
    
    @Override
    public void go(final int n, int n2) {
        this.gr.setStringB(this.gr.createString("data/gamec.d"), 160, 0);
        this.gr.setStringB("\u5f00\u59cb\u6e38\u620f#n\u79bb\u5f00\u6e38\u620f", Constants_H.WIDTH, 1);
        this.lv = (byte)n2;
        this.findN = null;
        final byte b = this.num[this.lv][0];
        n2 = this.num[this.lv][1];
        this.findN = new byte[b][n2];
        this.findC = null;
        n2 = this.num[this.lv][0];
        this.findC = new byte[n2][this.num[this.lv][1]];
        this.length = 9;
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
                        this.nullGame();
                        b = true;
                        return b;
                    }
                }
                else if (Ms.i().key_S2()) {
                    Ms.i().keyRelease();
                    this.nullGame();
                    b = true;
                    return b;
                }
            }
            else if (this.state < 3) {
                if (Ms.i().key_Up_Down()) {
                    this.ty = Ms.i().select(this.ty, 0, this.findN.length - 1);
                }
                else if (Ms.i().key_Left_Right()) {
                    this.tx = Ms.i().select(this.tx, 0, this.findN[this.ty].length - 1);
                }
                else if (Ms.i().key_S1_Num5()) {
                    Ms.i().keyRelease();
                    if (this.state == 0) {
                        this.go(0, this.lv);
                    }
                    else if (this.findC[this.ty][this.tx] == 0) {
                        final byte[] array = this.findC[this.ty];
                        final byte tx = this.tx;
                        ++array[tx];
                        if (++this.state == 2) {
                            this.selx = this.tx;
                            this.sely = this.ty;
                        }
                    }
                }
            }
            b = false;
        }
        return b;
    }
    
    @Override
    public void patin() {
        this.draw0(10, 2, 280);
        if (this.state != 0) {
            this.drawGame(10, 2, (this.length + 3) * 25);
        }
    }
    
    @Override
    public void run() {
        if (this.time < 1) {
            if (this.time == 0) {
                this.time = -1;
                this.gr.say("\u6e38\u620f\u5931\u8d25\uff01\uff01\uff01", -1);
            }
            else if (this.time == -1 && this.gr.say_c == 0) {
                this.go(0, this.lv);
            }
        }
        else if (this.find_count < 1) {
            if (this.find_count == 0) {
                this.find_count = -1;
                final GameRun gr = this.gr;
                gr.money += this.time * 125 + 100;
                this.gr.say("\u83b7\u5f97\u91d1\u94b1\uff1a" + (this.time * 125 + 100), -1);
                final byte[] rmsOther = this.gr.rmsOther;
                rmsOther[8] |= (byte)(1 << this.lv);
            }
            else if (this.find_count == -1 && this.gr.say_c == 0) {
                this.go(0, this.lv);
            }
        }
        else if (this.state >= 3) {
            if (++this.state > 10) {
                this.state = 1;
            }
            else if (this.state == 10) {
                if (this.findN[this.ty][this.tx] != this.findN[this.sely][this.selx]) {
                    this.findC[this.ty][this.tx] = 3;
                    this.findC[this.sely][this.selx] = 3;
                    --this.time;
                }
                else {
                    --this.find_count;
                }
            }
        }
        else if (this.count > 0 && --this.count == 0) {
            for (int i = 0; i < this.findC.length; i = (byte)(i + 1)) {
                for (int j = 0; j < this.findC[i].length; j = (byte)(j + 1)) {
                    this.findC[i][j] = 3;
                }
            }
        }
    }
}
