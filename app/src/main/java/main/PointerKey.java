package main;

import android.util.Log;
import dm.Ms;

public class PointerKey implements Key_H
{
    public int[][][] button_pos;
    boolean dir;
    int gox;
    int goy;
    GameRun gr;
    int i0;
    int i1;
    boolean isGo;
    int m0;
    int m1;
    Map map;
    MainCanvas mc;
    int tempx;
    int tempy;
    
    public PointerKey(final MainCanvas mc) {
        super();
        this.button_pos = new int[][][] { { { 0, Constants_H.HEIGHT - 50, 50, 50, -6 }, { Constants_H.WIDTH - 50, Constants_H.HEIGHT - 50, 50, 50, -7 } }, { { 0, 0, Constants_H.WIDTH, Constants_H.HEIGHT, 48 } }, { { 0, 0, Constants_H.WIDTH, Constants_H.HEIGHT, 53 } }, { { 170, 275, 106, 97, -3 }, { 363, 285, 108, 83, -4 }, { 281, 290, 76, 88, 53 } }, { { 0, 0, 320, 360, -3 }, { 320, 0, 320, 360, -4 } }, { { 462, 42, 83, 72, 9999 }, { 548, 116, 83, 71, 9999 }, { 466, 182, 85, 75, 9999 }, { 524, 266, 91, 68, 9999 }, { 48, 277, 87, 80, 9999 } }, { { Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60, 60, 60, 9999 }, { 0, Constants_H.HEIGHT__ - 60, 60, 60, 9999 }, { Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60 - 120 - 40, 60, 60, 9999 }, { Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60 - 60 - 20, 60, 60, 9999 }, { Constants_H.WIDTH__ - 60 - 120 - 40, Constants_H.HEIGHT__ - 60, 60, 60, 9999 }, { Constants_H.WIDTH__ - 60 - 60 - 20, Constants_H.HEIGHT__ - 60, 60, 60, 9999 }, { Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60 - 180 - 60, 60, 60, 9999 } }, { { Constants_H.WIDTH - 50, Constants_H.HEIGHT - 50, 50, 50, -7 } }, { { 0, 310, 50, 50, -6 }, { 590, 310, 50, 50, -7 } }, { { 0, 0, 640, 360, 48 } }, { { Constants_H.WIDTH - 30, Constants_H.HEIGHT - 30, 30, 30, 9999 }, { 0, Constants_H.HEIGHT - 30, 30, 30, 9999 }, { Constants_H.WIDTH - 30, Constants_H.HEIGHT - 30 - 90 - 25, 30, 30, 9999 }, { Constants_H.WIDTH - 30, Constants_H.HEIGHT - 30 - 45 - 15, 30, 30, 9999 }, { Constants_H.WIDTH - 30 - 90 - 40, Constants_H.HEIGHT - 30, 30, 30, 9999 }, { Constants_H.WIDTH - 30 - 45 - 20, Constants_H.HEIGHT - 30, 30, 30, 9999 }, { Constants_H.WIDTH - 30, Constants_H.HEIGHT - 30 - 135 - 35, 30, 30, 9999 } } };
        this.i0 = -1;
        this.i1 = -1;
        this.mc = mc;
        this.gr = this.mc.gr;
        this.map = this.gr.map;
    }
    
    private boolean isMove(final int n, final int n2) {
        int n3;
        int n4;
        if (this.map.my.dir == 3) {
            n3 = this.map.my.x - 20;
            n4 = this.map.my.y - 60;
        }
        else if (this.map.my.dir == 4) {
            n3 = this.map.my.x + 20;
            n4 = this.map.my.y - 60;
        }
        else if (this.map.my.dir == 1) {
            n3 = this.map.my.x;
            n4 = this.map.my.y - 80;
        }
        else {
            n3 = this.map.my.x;
            n4 = this.map.my.y - 40;
        }
        return (!Ms.i().isRect(n, n2, 1, 1, n3, n4, 20, 80) && !Ms.i().isRect(this.i0, this.i1, 1, 1, Constants_H.WIDTH_H - 30, Constants_H.HEIGHT - 60, 60, 60)) || this.map.checkSoftKey(this.map.my.x, this.map.my.y, this.map.dir_select[this.map.my.dir][0] * this.map.my.speed, this.map.dir_select[this.map.my.dir][1] * this.map.my.speed) == -1;
    }
    
    public int checkButton(final int n) {
        return this.checkButton(n, this.i0, this.i1);
    }
    
    public int checkButton(final int n, final int n2, final int n3) {
        for (int i = 0; i < this.button_pos[n].length; ++i) {
            if (Ms.i().isRect(n2 - 1, n3 - 1, 2, 2, this.button_pos[n][i][0], this.button_pos[n][i][1], this.button_pos[n][i][2], this.button_pos[n][i][3])) {
                Ms.key = this.button_pos[n][i][4];
                if (n == 3 && Ms.key == 53) {
                    Log.e("touch", "\u6309\u4e0b\u786e\u5b9a\u952e\u3002\u3002\u3002menu_state: " + this.mc.menu_state);
                }
                Ms.keyRepeat = true;
                this.initPointer();
                return i;
            }
        }
        return -1;
    }
    
    public void initPointer() {
        this.i1 = -1;
        this.i0 = -1;
        this.m1 = -1;
        this.m0 = -1;
    }
    
    public boolean isSelect(final int n, final int n2, final int n3, final int n4) {
        boolean b;
        if (Ms.i().isRect(this.i0, this.i1, 1, 1, n, n2, n3, n4)) {
            this.initPointer();
            b = true;
        }
        else {
            b = false;
        }
        return b;
    }
    
    public void process(final int i0, final int i2) {
        Label_0027: {
            if (this.map.my.state != 20 || this.checkButton(7, i0, i2) == -1) {
                if (GameRun.run_state != -10 || (this.map.my.state != 0 && this.map.my.state != 20)) {
                    if (GameRun.run_state == -10) {
                        if ((this.map.my.state == 18 || this.map.my.state == 17) && this.checkButton(8, i0, i2) != -1) {
                            return;
                        }
                        if (this.map.my.state != 18 && this.map.my.state != 17 && this.checkButton(0, i0, i2) != -1) {
                            return;
                        }
                    }
                    else if (GameRun.run_state != -10 && this.checkButton(8, i0, i2) != -1) {
                        return;
                    }
                }
                switch (this.mc.game_state) {
                    case 30: {
                        this.runKeySate(i0, i2);
                        break;
                    }
                    case 98: {
                        this.checkButton(9, i0, i2);
                        Log.d("soars", "checkButton");
                        break;
                    }
                    case 40: {
                        switch (this.mc.menu_state) {
                            default: {
                                break Label_0027;
                            }
                            case 0: {
                                if (this.mc.load_c == 1) {
                                    this.checkButton(3, this.i0 = i0, this.i1 = i2);
                                    break Label_0027;
                                }
                                this.checkButton(9, i0, i2);
                                break Label_0027;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
    
    public void runKeySate(final int n, final int n2) {
        switch (GameRun.run_state) {
            case 60:
            case 98: {
                this.checkButton(1, n, n2);
                break;
            }
            case -10: {
                this.i0 = n;
                this.i1 = n2;
                if (this.map.my.state == 22) {
                    if (this.gr.say_c < 0) {
                        this.checkButton(2, n, n2);
                        break;
                    }
                    this.checkButton(1, n, n2);
                    break;
                }
                else {
                    if (this.map.my.state == 1 || this.map.my.state == 10) {
                        this.checkButton(2, n, n2);
                        break;
                    }
                    if (this.map.my.state == 0) {
                        if (this.gr.say_c == -1) {
                            this.checkButton(2, n, n2);
                        }
                        else if (this.gr.say_s == 0 && this.gr.say_c == 0 && this.isMove(-this.map.map_x + n, -this.map.map_y + n2)) {
                            this.setMove(n, n2);
                        }
                        this.i0 = n;
                        this.i1 = n2;
                        break;
                    }
                    if (this.map.my.state == 12 || this.map.my.state == 18 || this.map.my.state == 17 || this.map.my.state == 16 || this.map.my.state == 20 || this.map.my.state == 2) {
                        this.i0 = n;
                        this.i1 = n2;
                        break;
                    }
                    break;
                }
                break;
            }
            case -20:
            case 18:
            case 25:
            case 35:
            case 61:
            case 65:
            case 66:
            case 68:
            case 97: {
                this.i0 = n;
                this.i1 = n2;
                break;
            }
            case 69: {
                this.i0 = n;
                this.i1 = n2;
                break;
            }
            case -31: {
                if (this.gr.battle_state != 2) {
                    this.i0 = n;
                    this.i1 = n2;
                    break;
                }
                this.gr.cur_a = (byte)this.checkButton(5, n, n2);
                if (this.gr.cur_a != -1) {
                    this.setKey5();
                    break;
                }
                break;
            }
        }
    }
    
    public void runMove() {
        if (GameRun.run_state == -10 && this.map.my.state == 0 && this.m0 != -1) {
            final int n = this.m0 - this.map.my.x;
            final int n2 = this.m1 - this.map.my.y;
            if (Ms.abs(n) < this.map.my.speed && Ms.abs(n2) < this.map.my.speed) {
                this.stopMove();
            }
            else {
                int n3;
                if (this.dir) {
                    if (Ms.abs(n2) < this.map.my.speed) {
                        n3 = 1;
                    }
                    else {
                        n3 = 0;
                    }
                }
                else if (Ms.abs(n) >= this.map.my.speed) {
                    n3 = 1;
                }
                else {
                    n3 = 0;
                }
                if (n3 != 0) {
                    int key;
                    if (n < 0) {
                        key = -3;
                    }
                    else {
                        key = -4;
                    }
                    Ms.key = key;
                }
                else {
                    int key2;
                    if (n2 < 0) {
                        key2 = -1;
                    }
                    else {
                        key2 = -2;
                    }
                    Ms.key = key2;
                }
                this.map.map_key = (byte)(-Ms.key);
                this.map.doKey();
            }
        }
    }
    
    public void selectListSY(final int n, final int n2, final int n3, final int n4, int i, final int n5, final int n6, final int n7) {
        for (i = 0; i < n; ++i) {
            if (Ms.i().isRect(this.i0, this.i1, 1, 1, n2, n3 + (n5 + n6) * i, n4, n5)) {
                this.gr.selecty = (byte)i;
                if (i == n7) {
                    this.setKey5();
                }
                this.initPointer();
            }
        }
    }
    
    public byte selectMenuX(final int n, final int n2, final int n3, final int n4, final int n5) {
        for (int i = 0; i < n; ++i) {
            if (Ms.i().isRect(this.i0, this.i1, 1, 1, n2 + i * n4, n3, n4, n5)) {
                this.initPointer();
                return (byte)i;
            }
        }
        return -1;
    }
    
    public void setKey5() {
        Ms.key = 53;
        Ms.keyRepeat = true;
    }
    
    public void setKeySoftkey1() {
        Ms.key = -6;
        Ms.keyRepeat = true;
    }
    
    public void setMove(final int tempx, final int tempy) {
        this.m0 = (-this.map.map_x + tempx) / 20 * 20;
        this.m1 = (-this.map.map_y + tempy) / 20 * 20;
        this.dir = (Ms.abs(this.m0 - this.map.my.x) < Ms.abs(this.m1 - this.map.my.y));
        this.isGo = true;
        this.tempx = tempx;
        this.tempy = tempy;
        this.gox = -this.map.map_x + this.tempx;
        this.goy = -this.map.map_y + this.tempy;
    }
    
    public void stopMove() {
        Ms.i().keyRelease();
        this.initPointer();
        this.isGo = false;
    }
}
