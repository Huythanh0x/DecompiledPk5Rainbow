package minigame;

import main.Constants_H;
import dm.Ui;
import dm.Ms;
import javax.microedition.lcdui.Image;
import main.GameRun;
import dm.Sprite;

public class Bearer implements MiniGame_H
{
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
    
    public Bearer(final GameRun gr) {
        super();
        this.gDate = new short[][] { { 9, 1, 10, 2, 11, 4, 27, 8, 2, -10 }, { 50, 100, 150, 200 }, { 60, 40, 30, 10 }, { 8, 6, 13, 3, 20, 5, 30, 10 } };
        this.ballDate = new short[][] { { 10, 20, 60, 10, 220 }, { 13, 40, 60, 12, 170 }, { 10, 40, 60, 10, 120 } };
        this.money = new short[] { 150, 200, 300, 450 };
        this.xy = new short[40][7];
        this.myxy = new short[] { 0, 275, 67, 10, 0 };
        this.ball_time = new byte[] { 20, 15, 10, 5 };
        this.SPEED = 10;
        this.gr = gr;
    }
    
    private void addBall(final int n) {
        this.xy[this.cur][0] = -20;
        this.xy[this.cur][1] = this.ballDate[n][4];
        this.xy[this.cur][2] = (short)(this.ballDate[n][1] / this.ballDate[n][0]);
        this.xy[this.cur][4] = this.ballDate[n][0];
        this.xy[this.cur][5] = (short)n;
        this.xy[this.cur][3] = this.ballDate[n][3];
        final short[] array = this.xy[this.cur];
        Ms.i();
        array[6] = (short)Ms.getRandom(this.gDate[0].length >> 1);
        final byte cur = (byte)(this.cur + 1);
        this.cur = cur;
        if (cur >= this.xy.length) {
            this.cur = 0;
        }
    }
    
    private void draw0(final int n, final int n2, int i) {
        final int n3 = i + 45;
        Ui.i().fillRectB();
        Ui.i().drawK(n, n2 + 25 + 5, 200 - 10, n3, 4);
        Ui.i().drawK(n + 200 + 10, n2 + 25 + 5, 200, n3, 4);
        Ui.i().drawK(n + 420 + 10, n2 + 25 + 5, 200 - 10, n3, 4);
        Ui.i().drawString("\u6e38\u620f\u89c4\u5219", 320, n2 + 25 + 5, 33, 3, 1);
        Ui.i().drawUi(7, 320 - 50 - 5, n2 + 25 - 4, 40, 0);
        Ui.i().drawUi(7, 320 + 50 + 5, n2 + 25 - 4, 36, 4);
        Ui.i().drawStringY(this.gr.about_a, 25, n2 + 75 + 10, 25, 0, 0);
        i = n2 + 100;
        Ui.i().drawString("\u7403\u7684\u5206\u6570\uff1a", n + 420 + 20, i, 0, 0, 0);
        int n4 = i + 50;
        GameRun gr;
        short n5;
        int n6;
        Ui j;
        String obj;
        String string;
        int n7;
        for (i = 0; i < this.gDate[0].length; i += 2) {
            gr = this.gr;
            n5 = this.gDate[0][i];
            if (i % 4 == 2) {
                n6 = 100;
            }
            else {
                n6 = 0;
            }
            gr.drawItem(n5, n + 420 + 25 + n6, (i >> 2) * 30 + n4, 0);
            j = Ui.i();
            if (this.gDate[0][i + 1] < 0) {
                obj = "";
            }
            else {
                obj = "+";
            }
            string = String.valueOf(obj) + this.gDate[0][i + 1];
            if (i % 4 == 2) {
                n7 = 100;
            }
            else {
                n7 = 0;
            }
            j.drawString(string, n + 420 + 25 + n7 + 16, (i >> 2) * 30 + n4 - 4, 0, 0, 1);
        }
        n4 -= 50;
        Ui.i().drawListKY(2, n + 200 + 12 + 25, n4, 200 - 50, 3, 30, 10, this.sel, 4, 2);
        Ui k;
        String string2;
        int n8;
        for (i = 0; i < this.gr.about_b.length; ++i) {
            System.out.println("i   " + i);
            k = Ui.i();
            string2 = this.gr.about_b[i].toString();
            if (this.sel == i) {
                n8 = 0;
            }
            else {
                n8 = 3;
            }
            k.drawString(string2, n + 200 + 15 + 25 + 26, i * 40 + n4 - 2, 0, n8, 1);
            if (this.gr.pkey.isSelect(n + 200 + 12 + 25, i * 40 + n4 - 2, 200 - 50, 40)) {
                System.out.println("asdfasfaf");
                if (this.sel == i) {
                    this.gr.pkey.setKey5();
                }
                else {
                    this.sel = (byte)i;
                }
            }
        }
        this.gr.showStringM("\u9700\u8981\u7684\u53c2\u52a0\u8d39\uff1a" + this.money[this.lv] + "\u91d1", 320, n2 + n3 - 50, 7, 0);
        this.gr.drawMoney(320, 360, 3, false);
        if (this.state == 0) {
            Ui.i().drawYesNo(true, true);
        }
    }
    
    private void drawGame(final int n, final int n2, int i, int n3) {
        Ui.i().fillRect(5423359, n, n2, i, n3);
        Ui.i().drawFrameOne(this.bsp, 0, n + (i >> 1), n2 + (n3 >> 1), 0);
        Ui.i().drawString("\u5206\u6570\uff1a" + this.count, (i >> 1) + n - 25, n2, 24, 3, 1);
        Ui.i().drawString("\u7403\u603b\u6570\uff1a" + this.ballC0, (i >> 1) + n + 25, n2, 20, 3, 1);
        Ui.i().drawImage(this.img, n + i, n3 - 15, 40);
        for (i = 0; i < this.xy.length; i = (byte)(i + 1)) {
            if (this.xy[i][5] != -1) {
                this.gr.drawItem(this.gDate[0][this.xy[i][6] << 1], this.xy[i][0] + n, this.xy[i][1] + n2, 0);
            }
        }
        Ui j;
        Sprite sprite;
        for (i = 0; i < 2; i = (byte)(i + 1)) {
            j = Ui.i();
            sprite = this.sp[0];
            if (this.myxy[4] == 0) {
                n3 = 3;
            }
            else {
                n3 = 4;
            }
            j.drawFrameOne(sprite, n3, this.myxy[0] + n + i * 30 + 20, this.myxy[1] + n2 + 25, 0);
        }
        this.gr.drawMoney(320, 360, 3, false);
    }
    
    private void getAY(final int n) {
        if (this.xy[n][4] > 0 && this.xy[n][3] > 1) {
            final short[] array = this.xy[n];
            --array[3];
        }
        else if (this.xy[n][4] == 0) {
            this.xy[n][3] = 0;
        }
        else if (this.xy[n][4] < 0 && this.xy[n][3] > -this.ballDate[this.xy[n][5]][3]) {
            final short[] array2 = this.xy[n];
            --array2[3];
        }
    }
    
    private void initABall(final boolean b) {
        short time0;
        if (b) {
            time0 = 10;
        }
        else {
            time0 = this.gDate[2][this.lv];
        }
        this.time0 = time0;
        this.time1 = this.ball_time[this.lv];
        Ms.i();
        this.ballC1 = (short)(Ms.getRandom(this.gDate[3][this.lv << 1]) + this.gDate[3][(this.lv << 1) + 1]);
    }
    
    private boolean isCollision(final int n) {
        return Ms.i().isRect(this.myxy[0], this.myxy[1], this.myxy[2], this.myxy[3], this.xy[n][0], this.xy[n][1], 16, 16);
    }
    
    private boolean isSrc(final int n) {
        final boolean b = this.xy[n][1] > 320 + 10;
        if (!Ms.i().isRect(240 - 10, 320 - 40, 20, 10, this.xy[n][0], this.xy[n][1], 16, 16)) {
            boolean b2 = b;
            if (this.xy[n][0] <= 240) {
                return b2;
            }
            b2 = b;
            if (this.xy[n][1] >= this.myxy[1]) {
                return b2;
            }
        }
        boolean b2 = true;
        this.count += this.gDate[0][this.xy[n][6] * 2 + 1];
        return b2;
    }
    
    private void nullGame() {
        this.gDate = null;
        this.money = null;
        this.sp = null;
        this.img = null;
        this.ballDate = null;
    }
    
    @Override
    public void go(int i) {
        if (i < 1) {
            this.state = 0;
            this.length = 10;
            this.gr.setStringB("\u5728\u9650\u5b9a\u65f6\u95f4\u91cc\u63a5\u5c3d\u91cf\u591a\u7684\u7403\u5230\u6846\u91cc\uff0c\u6700\u540e\u6839\u636e\u6846\u91cc\u7403\u7684\u5206\u6570\u6765\u6362\u53d6\u91d1\u94b1\u3002", 160, 0);
            this.gr.setStringB("\u5f00\u59cb\u6e38\u620f#n\u79bb\u5f00\u6e38\u620f", Constants_H.WIDTH, 1);
        }
        else if (i == 1) {
            this.state = 1;
            this.count = 0;
            this.cur = 0;
            this.ballC0 = this.gDate[1][this.lv];
            this.initABall(true);
            for (i = 0; i < this.xy.length; i = (byte)(i + 1)) {
                this.xy[i][5] = -1;
            }
        }
    }
    
    @Override
    public void go(final int n, final int n2) {
        this.lv = (byte)n2;
        (this.sp = new Sprite[2])[0] = Ms.i().createSprite("data/npc2/38", true);
        this.img = Ms.i().createImage("data/brow/m0");
        final byte[] stream = Ms.i().getStream("data/gamee.data", -1);
        Ms.i();
        Ms.skip = 0;
        this.bsp = Sprite.Create(Ms.i().createImage("data/map/5"), Ms.i().createShort2Array(stream, 2), Ms.i().createShort3Array(stream, 2), Ms.i().createShort3Array(stream, 2));
        this.go(n);
    }
    
    @Override
    public boolean key() {
        if (this.state == 0) {
            if (Ms.i().key_Up_Down()) {
                this.sel ^= 0x1;
            }
            else if (Ms.i().key_S1_Num5()) {
                Ms.i().keyRelease();
                if (this.sel == 0 && this.gr.isMoney(this.money[this.lv], true)) {
                    this.go(1);
                }
                else if (this.sel == 1) {
                    Ms.i().keyRelease();
                    this.nullGame();
                    return true;
                }
            }
            else if (Ms.i().key_S2()) {
                this.nullGame();
                return true;
            }
        }
        else if (this.state == 1) {
            if (Ms.i().key_Left()) {
                final short[] myxy = this.myxy;
                myxy[0] -= 10;
                if (this.myxy[0] < 0) {
                    this.myxy[0] = 0;
                }
            }
            else if (Ms.i().key_Right()) {
                final short[] myxy2 = this.myxy;
                myxy2[0] += 10;
                if (this.myxy[0] + this.myxy[2] > 220) {
                    this.myxy[0] = (short)(240 - this.myxy[2] - 20);
                }
            }
        }
        return false;
    }
    
    @Override
    public void patin() {
        this.draw0(10, 2, this.length * 25);
        if (this.state != 0) {
            this.drawGame(200, 0, 240, 320);
        }
    }
    
    @Override
    public void run() {
        if (this.state == 1) {
            if (this.ballC0 > 0) {
                if (this.time0 > 0) {
                    --this.time0;
                }
                else if (this.time1 > 0) {
                    --this.time1;
                }
                else if (this.ballC1 > 0) {
                    this.time1 = this.ball_time[this.lv];
                    this.addBall(Ms.getRandom(this.ballDate.length));
                    --this.ballC1;
                    --this.ballC0;
                }
                else if (this.ballC1 == 0) {
                    this.initABall(false);
                }
            }
            if (this.myxy[4] > 0) {
                final short[] myxy = this.myxy;
                --myxy[4];
            }
            int n = 1;
            for (int i = 0; i < this.xy.length; i = (byte)(i + 1)) {
                if (this.xy[i][5] != -1) {
                    final int n2 = 0;
                    final short[] array = this.xy[i];
                    array[0] += this.xy[i][2];
                    final short[] array2 = this.xy[i];
                    array2[1] -= this.xy[i][3];
                    this.getAY(i);
                    final short[] array3 = this.xy[i];
                    --array3[4];
                    if (this.isSrc(i)) {
                        this.xy[i][5] = -1;
                        n = n2;
                    }
                    else {
                        n = n2;
                        if (this.isCollision(i)) {
                            this.xy[i][4] = this.ballDate[this.xy[i][5]][0];
                            this.myxy[4] = 1;
                            this.xy[i][3] = this.ballDate[this.xy[i][5]][3];
                            n = n2;
                        }
                    }
                }
            }
            if (this.ballC0 < 1 && n != 0) {
                this.count = (short)(this.count * 15 / 10);
                final GameRun gr = this.gr;
                gr.money += this.count;
                this.gr.say("\u83b7\u5f97\uff1a" + this.count + "\u91d1", 0);
                if (this.count > 0) {
                    final byte[] rmsOther = this.gr.rmsOther;
                    rmsOther[6] |= (byte)(1 << this.lv);
                }
                this.state = 2;
            }
            this.gr.pkey.checkButton(4);
        }
        else if (this.state == 2 && this.gr.say_c == 0) {
            this.go(0);
        }
    }
    
    public void setLv(final int n) {
        this.lv = (byte)n;
    }
}
