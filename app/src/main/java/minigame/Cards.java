package minigame;

import dm.Ms;
import dm.Ui;
import java.lang.reflect.Array;
import javax.microedition.media.Player;
import main.Constants_H;
import main.GameRun;

/* loaded from: classes.dex */
public class Cards implements MiniGame_H {
    private short count;
    private byte[][] findC;
    private byte[][] findN;
    GameRun gr;
    private short gx;
    private short gy;
    private byte length;
    private byte lv;
    byte sel;
    private int sell_money;
    private byte selx;
    private byte sely;
    private byte state;
    private byte tx;
    private byte ty;
    private short gw = 30;
    private short gh = 40;
    private short gspace = 4;
    private short wh = 320;
    private short hh = 160;
    private byte time = 3;
    private byte find_count = 3;
    private byte[][] num = {new byte[]{3, 4}, new byte[]{3, 6}, new byte[]{4, 6}, new byte[]{5, 6}};

    public Cards(GameRun gr_) {
        this.gr = gr_;
    }

    @Override // minigame.MiniGame_H
    public void go(int mode, int lv_) {
        this.gr.setStringB(this.gr.createString("data/gamec.d"), 160, 0);
        this.gr.setStringB(Constants_H.GAME_TXT_27, Constants_H.WIDTH, 1);
        this.lv = (byte) lv_;
        this.findN = null;
        //todo thanh0x fix here [][]
        this.findN = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.num[this.lv][0], this.num[this.lv][1]);
        this.findC = null;
        this.findC = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.num[this.lv][0], this.num[this.lv][1]);
        this.length = (byte) 9;
        go(mode);
    }

    @Override // minigame.MiniGame_H
    public void go(int mode) {
        byte k;
        this.gr.line_max = (byte) 9;
        this.count = (short) 100;
        this.time = (byte) ((this.lv * 2) + 4);
        this.find_count = (byte) ((this.num[this.lv][0] * this.num[this.lv][1]) / 2);
        if (mode < 1) {
            this.ty = (byte) 0;
            this.state = (byte) 0;
            this.sell_money = (this.lv * 200) + Player.REALIZED;
            return;
        }
        this.gx = (short) ((-((this.gw + this.gspace) * this.num[this.lv][1])) >> 1);
        this.gy = (short) ((-((this.gh + this.gspace) * this.num[this.lv][0])) >> 1);
        this.ty = (byte) 0;
        this.tx = (byte) 0;
        this.state = (byte) 1;
        byte[] randN = new byte[this.find_count];
        for (byte i = 0; i < this.findC.length; i = (byte) (i + 1)) {
            for (byte j = 0; j < this.findC[i].length; j = (byte) (j + 1)) {
                this.findC[i][j] = 2;
                this.findN[i][j] = 0;
            }
        }
        byte i2 = 0;
        while (i2 < randN.length) {
            Ms.i();
            byte rd = (byte) (Ms.getRandom(35) + 1);
            byte j2 = (byte) (randN.length - 1);
            while (j2 > -1 && randN[j2] != rd) {
                j2 = (byte) (j2 - 1);
            }
            if (j2 == -1) {
                randN[i2] = rd;
                i2 = (byte) (i2 + 1);
            }
        }
        for (byte i3 = 0; i3 < randN.length; i3 = (byte) (i3 + 1)) {
            for (byte j3 = 0; j3 < 2; j3 = (byte) (j3 + 1)) {
                do {
                    Ms.i();
                    k = (byte) Ms.getRandom(this.num[this.lv][0] * this.num[this.lv][1]);
                } while (this.findN[k / this.num[this.lv][1]][k % this.num[this.lv][1]] != 0);
                this.findN[k / this.num[this.lv][1]][k % this.num[this.lv][1]] = randN[i3];
            }
        }
    }

    private void nullGame() {
        this.findN = null;
        this.findC = null;
        this.num = null;
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
                    nullGame();
                    return true;
                }
            } else if (Ms.i().key_S2()) {
                Ms.i().keyRelease();
                nullGame();
                return true;
            }
        } else if (this.state < 3) {
            if (Ms.i().key_Up_Down()) {
                this.ty = Ms.i().select(this.ty, 0, this.findN.length - 1);
            } else if (Ms.i().key_Left_Right()) {
                this.tx = Ms.i().select(this.tx, 0, this.findN[this.ty].length - 1);
            } else if (Ms.i().key_S1_Num5()) {
                Ms.i().keyRelease();
                if (this.state == 0) {
                    go(0, this.lv);
                } else if (this.findC[this.ty][this.tx] == 0) {
                    byte[] bArr = this.findC[this.ty];
                    byte b = this.tx;
                    bArr[b] = (byte) (bArr[b] + 1);
                    byte b2 = (byte) (this.state + 1);
                    this.state = b2;
                    if (b2 == 2) {
                        this.selx = this.tx;
                        this.sely = this.ty;
                    }
                }
            }
        }
        return false;
    }

    @Override // minigame.MiniGame_H
    public void patin() {
        draw0(10, 2, 280);
        if (this.state != 0) {
            drawGame(10, 2, (this.length + 3) * 25);
        }
    }

    @Override // minigame.MiniGame_H
    public void run() {
        if (this.time < 1) {
            if (this.time == 0) {
                this.time = (byte) -1;
                this.gr.say(Constants_H.GAME_TXT_20, -1);
                return;
            } else {
                if (this.time == -1 && this.gr.say_c == 0) {
                    go(0, this.lv);
                    return;
                }
                return;
            }
        }
        if (this.find_count < 1) {
            if (this.find_count == 0) {
                this.find_count = (byte) -1;
                this.gr.money += (this.time * 125) + 100;
                this.gr.say(Constants_H.MONEY_TXT_9 + ((this.time * 125) + 100), -1);
                byte[] bArr = this.gr.rmsOther;
                bArr[8] = (byte) (bArr[8] | (1 << this.lv));
                return;
            }
            if (this.find_count == -1 && this.gr.say_c == 0) {
                go(0, this.lv);
                return;
            }
            return;
        }
        if (this.state >= 3) {
            byte b = (byte) (this.state + 1);
            this.state = b;
            if (b <= 10) {
                if (this.state == 10) {
                    if (this.findN[this.ty][this.tx] != this.findN[this.sely][this.selx]) {
                        this.findC[this.ty][this.tx] = 3;
                        this.findC[this.sely][this.selx] = 3;
                        this.time = (byte) (this.time - 1);
                        return;
                    }
                    this.find_count = (byte) (this.find_count - 1);
                    return;
                }
                return;
            }
            this.state = (byte) 1;
            return;
        }
        if (this.count > 0) {
            short s = (short) (this.count - 1);
            this.count = s;
            if (s == 0) {
                for (byte i = 0; i < this.findC.length; i = (byte) (i + 1)) {
                    for (byte j = 0; j < this.findC[i].length; j = (byte) (j + 1)) {
                        this.findC[i][j] = 3;
                    }
                }
            }
        }
    }

    public void draw0(int x, int y, int h) {
        Ui.i().fillRectB();
        Ui.i().drawK(x, y + 25 + 5, Player.REALIZED - 10, h, 4);
        Ui.i().drawK(x + Player.REALIZED, y + 25 + 5, Player.REALIZED + 20, h, 4);
        Ui i = Ui.i();
        int i2 = (Player.REALIZED + 10) * 2;
        i.drawK(x + 420 + 10, y + 25 + 5, Player.REALIZED - 10, h, 4);
        if (this.state == 0) {
            Ui.i().drawString(Constants_H.GAME_TXT_7, Constants_H.WIDTH_H_, y + 25 + 5, 33, 3, 1);
            Ui.i().drawUi(7, (Constants_H.WIDTH_H_ - 50) + 7, y + 25, 40, 0);
            Ui.i().drawUi(7, Constants_H.WIDTH_H_ + 50 + 7, y + 25, 36, 4);
        }
        Ui.i().drawStringY(this.gr.about_a, 25, y + 25 + 10, 25, 0, 0);
        if (this.state == 0) {
            this.gr.showStringM(Constants_H.GAME_TXT_12 + this.sell_money + Constants_H.MONEY_TXT_0, Constants_H.WIDTH_H_, (y + h) - 50, 7, 0);
            int ty = y + 75 + 5;
            Ui.i().drawListKY(2, x + Player.REALIZED + 12 + 25, ty, Player.REALIZED - 50, 3, 30, 10, this.sel, 4, 2);
            int i3 = 0;
            while (i3 < this.gr.about_b.length) {
                Ui.i().drawString(this.gr.about_b[i3].toString(), x + Player.REALIZED + 15 + 25 + 26, ((i3 * 40) + ty) - 2, 0, this.sel == i3 ? 0 : 3, 1);
                if (this.gr.pkey.isSelect(x + Player.REALIZED + 12 + 25, ((i3 * 40) + ty) - 2, Player.REALIZED - 50, 40)) {
                    if (this.sel == i3) {
                        this.gr.pkey.setKey5();
                    } else {
                        this.sel = (byte) i3;
                    }
                }
                i3++;
            }
        }
        this.gr.drawMoney(Constants_H.WIDTH_H_, Constants_H.HEIGHT_, 3, false);
        if (this.state == 0) {
            Ui.i().drawYesNo(true, true);
        }
    }

    private void drawGame(int x, int y, int h) {
        for (int i = 0; i < this.findN.length; i++) {
            for (int j = 0; j < this.findN[i].length; j++) {
                drawCard(i, j, ((this.gw + this.gspace) * j) + this.wh + this.gx, ((this.gh + this.gspace) * i) + this.hh + this.gy, this.findC[i][j] == 3 ? (byte) 1 : this.findC[i][j]);
                if (this.gr.pkey.isSelect(this.wh + this.gx + ((this.gw + this.gspace) * j), this.hh + this.gy + ((this.gh + this.gspace) * i), this.gw + this.gspace, this.gh + this.gspace) && this.state < 3) {
                    this.tx = (byte) j;
                    this.ty = (byte) i;
                    this.gr.pkey.setKey5();
                }
            }
        }
        Ui i2 = Ui.i();
        int i3 = this.wh;
        int i4 = this.gx;
        i2.drawRectZ(15400191, i3 + i4 + (this.tx * (this.gw + this.gspace)), this.hh + this.gy + (this.ty * (this.gh + this.gspace)), this.gw, this.gh, 3);
        if (this.count > 0) {
            Ui.i().drawNum(new StringBuilder().append(this.count / 10).toString(), Constants_H.WIDTH_H_ + 10, 29, 36, 2);
        } else {
            Ui.i().drawString(Constants_H.GAME_TXT_17, Constants_H.WIDTH_H_, 4, 17, 3, 0);
            this.gr.showStringM(Constants_H.GAME_TXT_18 + (this.time < 0 ? 0 : this.time - 1) + "次", Constants_H.WIDTH_H_ + Player.REALIZED, Constants_H.HEIGHT_H_ - 75, 5, 0);
        }
    }

    private void drawCard(int i, int j, int x, int y, int mode) {
        if (mode == 0) {
            Ui.i().drawK(x, y, this.gw, this.gh, 1);
            Ui.i().drawUi(25, (this.gw >> 1) + x, (this.gh >> 1) + y, 3, 0);
            return;
        }
        if (mode == 1) {
            Ui.i().drawK(((this.gw >> 1) + x) - 2, y - 3, 5, this.gh + 6, 1);
            byte[] bArr = this.findC[i];
            byte b = (byte) (bArr[j] + 1);
            bArr[j] = b;
            if (b > 3) {
                this.findC[i][j] = 0;
            }
            return;
        }
        Ui.i().drawK(x, y, this.gw, this.gh, 5);
        this.gr.drawItem(this.findN[i][j], (this.gw >> 1) + x, (this.gh >> 1) + y, 3);
        Ui.i().drawNum(new StringBuilder().append((int) this.findN[i][j]).toString(), this.gw + x, this.gh + y, 40, 0);
    }
}
