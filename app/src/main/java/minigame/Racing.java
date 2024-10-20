package minigame;

import dm.Ui;
import main.Constants_H;
import dm.Ms;
import dm.Sprite;
import javax.microedition.lcdui.Image;
import main.GameRun;

public class Racing implements MiniGame_H
{
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
    
    public Racing(final GameRun gr) {
        super();
        this.NUM = 4;
        this.MAP_HEIGHT = 450;
        this.WIN_HEIGHT = 70;
        this.now_a = new byte[4][3];
        this.myDate = new byte[] { 0, 0, 0, -1 };
        this.cloud = new short[10][3];
        this.monY = new short[4];
        this.money = new short[] { 100, 120, 300, 350, 1000, 1200 };
        this.gDate = new short[][] { { 450, 3, 8 }, { 390, 4, 9 }, { 270, 7, 6 }, { 210, 6, 10 } };
        this.gr = gr;
    }
    
    private void addCloud(final int n) {
        final short[] array = this.cloud[n];
        Ms.i();
        array[0] = (short)(Ms.getRandom(Constants_H.WIDTH_H) + 640);
        final short[] array2 = this.cloud[n];
        final short srcY = this.srcY;
        Ms.i();
        array2[1] = (short)(srcY - 80 + (Ms.getRandom(25) + 55) * n);
        final short[] array3 = this.cloud[n];
        Ms.i();
        array3[2] = (short)(Ms.getRandom(5) + 2);
    }
    
    private void draw0(final int n, final int n2, int i, final int n3) {
        Ui.i().fillRectB();
        Ui.i().drawString("\u6e38\u620f\u89c4\u5219", 320, n2 + n3 + 3, 33, 3, 1);
        Ui.i().drawUi(7, 320 - 50, n2 + n3 - 13, 40, 0);
        Ui.i().drawUi(7, 320 + 50, n2 + n3 - 13, 36, 4);
        Ui.i().drawK(n, n2 + n3 + 3, 200, i, 4);
        Ui.i().drawK(n + 200 + 10, n2 + n3 + 3, 200, i, 4);
        this.gr.showStringM("\u9009\u62e9\u4f60\u8ba4\u4e3a\u4f1a\u5f97\u7b2c\u4e00\u7684\u4e00\u53ea\u5ba0\u7269\u548c\u62bc\u6ce8\u7684\u5927\u5c0f\uff0c\u6ce8\u6570\u8d8a\u5927\u83b7\u80dc\u540e\u7684\u5956\u52b1\u8d8a\u4e30\u539a\uff01", n + 100, n2 + n3 + 15, 7, 0);
        Ui.i().drawK(n + 420, n2 + n3 + 3, 200, i, 4);
        Ui.i().drawStringY(this.gr.about_a, n + 420 + 25, n2 + n3 + 15, n3, 0, 0);
        if (this.state == 0) {
            Ui.i().drawString("\u8bf7\u9009\u62e9\u62bc\u6ce8\u5927\u5c0f\uff1a", n + 200 + 10, n2 + n3 + 15, 0, 0, 0);
            for (i = 0; i < this.length; ++i) {
                Ui.i().drawK(n + 200 + 10 + 25 + 14, n2 + n3 + 50 + (n3 + 16) * i, 150, n3 + 4, 1);
                Ui.i().drawString(this.gr.about_b[i].toString(), n + 200 + 10 + 25 + 14, n2 + n3 + 50 + (n3 + 16) * i, 0, 3, 0);
                if (this.gr.pkey.isSelect(n + 200 + 10 + 25 + 14, n2 + n3 + 50 + (n3 + 16) * i, 150, n3 + 4)) {
                    if (this.sel == i) {
                        this.gr.pkey.setKey5();
                    }
                    else {
                        this.sel = (byte)i;
                    }
                }
            }
            Ui.i().drawK4(n + 200 + 10 + 25 + 14, n2 + n3 + 50 + this.sel * (n3 + 16), 150, n3 + 4);
        }
        this.gr.drawMoney(320, 360, 3, false);
        Ui.i().drawYesNo(true, true);
    }
    
    private void draw1(final int n, final int n2, int i) {
        Ui.i().drawK(215, 33, 210, 325, 4);
        for (byte b = 0; b < this.length; ++b) {
            Ui.i().drawK(n + 25 + b * 52, n2 + 25 + 10, 44, i, 1);
            Ui.i().drawActionOne(this.sp[0], 0, n + 25 + b * 52 + 22, n2 + 25 + 8 + i, this.now_a[b], 0, this.state == 1 && this.sel == b);
            Ui.i().drawNum(new StringBuilder().append(b + 1).toString(), n + 25 + b * 52 + 27, n2 + 50 + 12, 20, 2);
        }
        if (this.state == 1) {
            Ui.i().drawK4(n + 25 + this.sel * 52, n2 + 25 + 10, 44, 76);
            Ui.i().drawTriangle(320, n2 + 25 + 49, 116, true, true);
            final byte selectMenuX = this.gr.pkey.selectMenuX(4, 320 - 116, n2 + 25 + 10, 52, i);
            if (selectMenuX != -1) {
                if (this.sel == selectMenuX) {
                    this.gr.pkey.setKey5();
                }
                else {
                    this.sel = selectMenuX;
                }
            }
        }
        Ui.i().drawString("\u5174\u594b\u5ea6\uff1a", n + 25, n2 + 25 + 13 + i, 0, 0, 0);
        this.gr.drawFealty(6, 2, n + 125, n2 + 25 + 19 + i);
        this.gr.showStringM("\u6bcf\u5582\u4e00\u4e2a\u5174\u594b\u83c7\u82b1\u8d3910\u91d1\uff0c\u53ef\u589e\u52a0\u4e00\u683c\u5174\u594b\u5ea6\u3002", 320, n2 + 50 + 19 + i, 8, 0);
        i = i + 69 + 25 + 75;
        Ui.i().drawString("\u8bf7\u9009\u62e9\u9053\u5177\uff1a", n + 25, n2 + i, 0, 0, 0);
        final int n3 = i + 25 + 3;
        for (i = 0; i < this.length; i = (byte)(i + 1)) {
            Ui.i().drawK(n + 25 + i * 52, n2 + n3, 44, 34, 1);
            this.gr.drawItem(12, n + 25 + i * 52, n2 + n3 + 10, 0);
            Ui.i().drawString("x" + i, n + 25 + i * 52 + 16, n2 + n3 + 8, 0, 3, 1);
        }
        if (this.state == 2) {
            Ui.i().drawK4(n + 25 + this.sel * 52, n2 + n3, 44, 34);
            Ui.i().drawTriangle(320, n2 + n3 + 14, 116, true, true);
            final byte selectMenuX2 = this.gr.pkey.selectMenuX(4, 320 - 116, n2 + n3 + 8, 52, 34);
            if (selectMenuX2 != -1) {
                if (this.sel == selectMenuX2) {
                    this.gr.pkey.setKey5();
                }
                else {
                    this.sel = selectMenuX2;
                }
            }
        }
        Ui.i().drawYesNo(true, this.state != 1);
    }
    
    private void drawCloud() {
        for (int i = 0; i < this.cloud.length; i = (byte)(i + 1)) {
            Ui.i().drawImage(this.imgCloud, this.cloud[i][0], this.cloud[i][1] - this.srcY, 0);
        }
        for (int j = 0; j < this.cloud.length; j = (byte)(j + 1)) {
            if (this.isNpcSrc(this.cloud[j][0], this.cloud[j][1])) {
                this.addCloud(j);
            }
            else {
                final short[] array = this.cloud[j];
                array[0] -= this.cloud[j][2];
            }
        }
    }
    
    private void drawEnd() {
        final int n = (640 - 70) / 35;
        Ui.i().drawModuleOne(this.sp[1], 0, 0, 40 - this.srcY, 0, 0);
        for (int i = 0; i < n + 1; ++i) {
            Ui.i().drawModuleOne(this.sp[1], 1, i * 35 + 35, 44 - this.srcY, 0, 0);
        }
        Ui.i().drawModuleOne(this.sp[1], 0, 640, 40 - this.srcY, 1, 0);
    }
    
    private void drawGame() {
        Ui.i().fillRect(5423359, 0, 0, 640, 360);
        this.drawCloud();
        this.drawEnd();
        for (byte b = 0; b < this.length; ++b) {
            Ui.i().drawNum(new StringBuilder().append(b + 1).toString(), b * 100 + 125 + 22, 20 - this.srcY, 1, 2);
            Ui.i().drawActionOne(this.sp[0], 1, b * 100 + 125 + 22, this.monY[b] - this.srcY, this.now_a[b], 0, true);
        }
        if (this.state == 3 && this.time != 0) {
            Ui.i().drawNum(new StringBuilder().append(this.time / 20).toString(), 320 - 5, 180, 0, 2);
        }
    }
    
    private boolean isNpcSrc(final int n, final int n2) {
        return n < -40 || n2 - this.srcY > Constants_H.HEIGHT + 20;
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
    
    private void setSpeed() {
        if (this.speedLv < this.gDate.length) {
            int n;
            for (n = 0; n < 4 && this.monY[n] > this.gDate[this.speedLv][0]; n = (byte)(n + 1)) {}
            if (n < 4) {
                for (int i = 0; i < 4; i = (byte)(i + 1)) {
                    final byte[] array = this.now_a[i];
                    Ms.i();
                    array[2] = (byte)(Ms.getRandom(this.gDate[this.speedLv][1]) + this.gDate[this.speedLv][1]);
                }
                ++this.speedLv;
            }
        }
    }
    
    @Override
    public void go(int i) {
        if (i < 1) {
            this.sel = 0;
            this.state = 0;
            this.length = 3;
            this.gr.setStringB("\u4e00\u6ce8\uff1a#n\u6295\u5165100\u91d1\uff0c#n\u83b7\u80dc\u5f97120\u91d1\u3002#n\u4e8c\u6ce8\uff1a#n\u6295\u5165300\u91d1\uff0c#n\u83b7\u80dc\u5f97350\u91d1\u3002#n\u4e09\u6ce8\uff1a#n\u6295\u51651000\u91d1\uff0c#n\u83b7\u80dc\u5f971200\u91d1\u3002", Constants_H.WIDTH - 50, 0);
            this.gr.setStringB("\u4e00\u6ce8100\u91d1#n\u4e8c\u6ce8300\u91d1#n\u4e09\u6ce81000\u91d1", Constants_H.WIDTH - 50, 1);
        }
        else if (i == 1) {
            this.myDate[0] = this.sel;
            this.sel = 0;
            this.state = 1;
            this.length = 4;
        }
        else if (i == 2) {
            this.myDate[1] = this.sel;
            this.sel = 0;
            this.state = 2;
        }
        else if (i == 3) {
            this.myDate[2] = this.sel;
            this.sel = 0;
            this.state = 3;
            this.srcY = 90;
            this.speedLv = 0;
            this.myDate[3] = -1;
            this.time = 70;
            for (i = 0; i < this.length; i = (byte)(i + 1)) {
                this.monY[i] = 450;
            }
            for (i = 0; i < this.cloud.length; i = (byte)(i + 1)) {
                this.addCloud(i);
            }
        }
    }
    
    @Override
    public void go(final int n, final int n2) {
        this.lv = (byte)n2;
        (this.sp = new Sprite[3])[0] = Ms.i().createSprite("data/npc0/67", true);
        this.sp[1] = Ms.i().createSprite("data/brow/m1", true);
        this.imgCloud = Ms.i().createImage("data/cloud");
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
                    this.sel = Ms.i().select(this.sel, 0, this.length - 1);
                }
                else if (Ms.i().key_S1_Num5() && this.gr.isMoney(this.money[this.sel << 1], true)) {
                    this.go(1);
                }
                else if (Ms.i().key_S2()) {
                    this.nullGame();
                    b = true;
                    return b;
                }
            }
            else if (this.state == 1) {
                if (Ms.i().key_Left_Right()) {
                    this.sel = Ms.i().select(this.sel, 0, this.length - 1);
                }
                else if (Ms.i().key_S1_Num5()) {
                    this.go(2);
                }
            }
            else if (this.state == 2) {
                if (Ms.i().key_Left_Right()) {
                    this.sel = Ms.i().select(this.sel, 0, this.length - 1);
                }
                else if (Ms.i().key_S1_Num5() && this.gr.isMoney(this.sel * 10, true)) {
                    this.go(3);
                }
                else if (Ms.i().key_S2()) {
                    this.sel = this.myDate[1];
                    this.state = 1;
                }
            }
            b = false;
        }
        return b;
    }
    
    @Override
    public void patin() {
        if (this.state == 0 || this.state == 1 || this.state == 2) {
            this.draw0(10, 5, 325, 25);
            if (this.state == 1 || this.state == 2) {
                this.draw1(198, 15, 76);
            }
        }
        else {
            this.drawGame();
        }
    }
    
    @Override
    public void run() {
        if (this.state == 3) {
            if (this.time == 0) {
                this.setSpeed();
                if (this.myDate[3] != -1) {
                    this.time = 5;
                    this.state = 4;
                }
                else {
                    int n = -1;
                    for (byte b = 0; b < 4; ++b) {
                        final short[] monY = this.monY;
                        monY[b] -= this.now_a[b][2];
                        if (this.monY[b] - this.srcY < Constants_H.HEIGHT_H) {
                            n = b;
                        }
                        if (this.monY[b] < 70 && this.myDate[3] == -1) {
                            this.myDate[3] = b;
                        }
                    }
                    if (n != -1) {
                        this.srcY -= this.now_a[n][2];
                    }
                    if (this.srcY < 0) {
                        this.srcY = 0;
                    }
                }
            }
            else {
                --this.time;
            }
        }
        else if (this.state == 4) {
            if (this.time == 3) {
                if (this.myDate[3] == this.myDate[1]) {
                    final GameRun gr = this.gr;
                    gr.money += this.money[this.myDate[0] * 2 + 1];
                    this.gr.say("\u83b7\u5f97\uff1a" + this.money[this.myDate[0] * 2 + 1] + "\u91d1", 0);
                    final byte[] rmsOther = this.gr.rmsOther;
                    rmsOther[4] |= (byte)(1 << this.lv);
                }
                else {
                    this.gr.say("\u4e0d\u597d\u610f\u601d\uff0c\u6ca1\u6709\u731c\u5bf9\u3002", 0);
                }
            }
            if (this.time > 0) {
                --this.time;
            }
            else if (this.time == 0 && this.gr.say_c == 0) {
                this.go(0);
            }
        }
    }
}
