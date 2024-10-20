package main;

import android.util.Log;
import dm.Ms;

public class PointerKey implements Key_H {
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

    public PointerKey(MainCanvas mc_) {
        this.button_pos = new int[][][]{new int[][]{new int[]{0, Constants_H.HEIGHT - 50, 50, 50, -6}, new int[]{Constants_H.WIDTH - 50, Constants_H.HEIGHT - 50, 50, 50, -7}}, new int[][]{new int[]{0, 0, Constants_H.WIDTH, Constants_H.HEIGHT, 0x30}}, new int[][]{new int[]{0, 0, Constants_H.WIDTH, Constants_H.HEIGHT, 53}}, new int[][]{new int[]{170, 275, 106, 97, -3}, new int[]{363, 285, 108, 83, -4}, new int[]{281, 290, 76, 88, 53}}, new int[][]{new int[]{0, 0, 320, 360, -3}, new int[]{320, 0, 320, 360, -4}}, new int[][]{new int[]{462, 42, 83, 72, 0x270F}, new int[]{548, 0x74, 83, 71, 0x270F}, new int[]{466, 0xB6, 85, 75, 0x270F}, new int[]{0x20C, 0x10A, 91, 68, 0x270F}, new int[]{0x30, 277, 87, 80, 0x270F}}, new int[][]{new int[]{Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60, 60, 60, 0x270F}, new int[]{0, Constants_H.HEIGHT__ - 60, 60, 60, 0x270F}, new int[]{Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 220, 60, 60, 0x270F}, new int[]{Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 140, 60, 60, 0x270F}, new int[]{Constants_H.WIDTH__ - 220, Constants_H.HEIGHT__ - 60, 60, 60, 0x270F}, new int[]{Constants_H.WIDTH__ - 140, Constants_H.HEIGHT__ - 60, 60, 60, 0x270F}, new int[]{Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 300, 60, 60, 0x270F}}, new int[][]{new int[]{Constants_H.WIDTH - 50, Constants_H.HEIGHT - 50, 50, 50, -7}}, new int[][]{new int[]{0, 310, 50, 50, -6}, new int[]{590, 310, 50, 50, -7}}, new int[][]{new int[]{0, 0, 640, 360, 0x30}}, new int[][]{new int[]{Constants_H.WIDTH - 30, Constants_H.HEIGHT - 30, 30, 30, 0x270F}, new int[]{0, Constants_H.HEIGHT - 30, 30, 30, 0x270F}, new int[]{Constants_H.WIDTH - 30, Constants_H.HEIGHT - 0x91, 30, 30, 0x270F}, new int[]{Constants_H.WIDTH - 30, Constants_H.HEIGHT - 90, 30, 30, 0x270F}, new int[]{Constants_H.WIDTH - 0xA0, Constants_H.HEIGHT - 30, 30, 30, 0x270F}, new int[]{Constants_H.WIDTH - 0x5F, Constants_H.HEIGHT - 30, 30, 30, 0x270F}, new int[]{Constants_H.WIDTH - 30, Constants_H.HEIGHT - 200, 30, 30, 0x270F}}};
        this.i0 = -1;
        this.i1 = -1;
        this.mc = mc_;
        this.gr = this.mc.gr;
        this.map = this.gr.map;
    }

    public int checkButton(int check_no) {
        return this.checkButton(check_no, this.i0, this.i1);
    }

    public int checkButton(int check_no, int x, int y) {
        for(int i = 0; true; ++i) {
            if(i >= this.button_pos[check_no].length) {
                return -1;
            }
            if(Ms.i().isRect(x - 1, y - 1, 2, 2, this.button_pos[check_no][i][0], this.button_pos[check_no][i][1], this.button_pos[check_no][i][2], this.button_pos[check_no][i][3])) {
                Ms.key = this.button_pos[check_no][i][4];
                if(check_no == 3 && Ms.key == 53) {
                    Log.e("touch", "按下确定键。。。menu_state: " + this.mc.menu_state);
                }
                Ms.keyRepeat = true;
                this.initPointer();
                return i;
            }
        }
    }

    public void initPointer() {
        this.i1 = -1;
        this.i0 = -1;
        this.m1 = -1;
        this.m0 = -1;
    }

    private boolean isMove(int x, int y) {
        int npcY;
        int npcX;
        switch(this.map.my.dir) {
            case 1: {
                npcX = this.map.my.x;
                npcY = this.map.my.y - 80;
                return !Ms.i().isRect(x, y, 1, 1, npcX, npcY, 20, 80) && !Ms.i().isRect(this.i0, this.i1, 1, 1, Constants_H.WIDTH_H - 30, Constants_H.HEIGHT - 60, 60, 60) || this.map.checkSoftKey(((int)this.map.my.x), ((int)this.map.my.y), this.map.dir_select[this.map.my.dir][0] * this.map.my.speed, this.map.dir_select[this.map.my.dir][1] * this.map.my.speed) == -1;
            }
            case 3: {
                npcX = this.map.my.x - 20;
                npcY = this.map.my.y - 60;
                return !Ms.i().isRect(x, y, 1, 1, npcX, npcY, 20, 80) && !Ms.i().isRect(this.i0, this.i1, 1, 1, Constants_H.WIDTH_H - 30, Constants_H.HEIGHT - 60, 60, 60) || this.map.checkSoftKey(((int)this.map.my.x), ((int)this.map.my.y), this.map.dir_select[this.map.my.dir][0] * this.map.my.speed, this.map.dir_select[this.map.my.dir][1] * this.map.my.speed) == -1;
            }
            case 4: {
                npcX = this.map.my.x + 20;
                npcY = this.map.my.y - 60;
                return !Ms.i().isRect(x, y, 1, 1, npcX, npcY, 20, 80) && !Ms.i().isRect(this.i0, this.i1, 1, 1, Constants_H.WIDTH_H - 30, Constants_H.HEIGHT - 60, 60, 60) || this.map.checkSoftKey(((int)this.map.my.x), ((int)this.map.my.y), this.map.dir_select[this.map.my.dir][0] * this.map.my.speed, this.map.dir_select[this.map.my.dir][1] * this.map.my.speed) == -1;
            }
            default: {
                npcX = this.map.my.x;
                npcY = this.map.my.y - 40;
                return !Ms.i().isRect(x, y, 1, 1, npcX, npcY, 20, 80) && !Ms.i().isRect(this.i0, this.i1, 1, 1, Constants_H.WIDTH_H - 30, Constants_H.HEIGHT - 60, 60, 60) || this.map.checkSoftKey(((int)this.map.my.x), ((int)this.map.my.y), this.map.dir_select[this.map.my.dir][0] * this.map.my.speed, this.map.dir_select[this.map.my.dir][1] * this.map.my.speed) == -1;
            }
        }
    }

    public boolean isSelect(int x, int y, int w, int h) {
        if(Ms.i().isRect(this.i0, this.i1, 1, 1, x, y, w, h)) {
            this.initPointer();
            return true;
        }
        return false;
    }

    public void process(int x, int y) {
        if(this.map.my.state != 20 || this.checkButton(7, x, y) == -1) {
            if(GameRun.run_state != -10 || this.map.my.state != 0 && this.map.my.state != 20) {
                if(GameRun.run_state == -10) {
                    if((this.map.my.state == 17 || this.map.my.state == 18) && this.checkButton(8, x, y) != -1 || this.map.my.state != 17 && this.map.my.state != 18 && this.checkButton(0, x, y) != -1) {
                        return;
                    }
                }
                else if(GameRun.run_state != -10 && this.checkButton(8, x, y) != -1) {
                    return;
                }
            }
            switch(this.mc.game_state) {
                case 30: {
                    this.runKeySate(x, y);
                    return;
                }
                case 40: {
                    if(this.mc.menu_state == 0) {
                        if(this.mc.load_c == 1) {
                            this.i0 = x;
                            this.i1 = y;
                            this.checkButton(3, x, y);
                            return;
                        }
                        this.checkButton(9, x, y);
                        return;
                    }
                    break;
                }
                case 98: {
                    this.checkButton(9, x, y);
                    Log.d("soars", "checkButton");
                }
            }
        }
    }

    public void runKeySate(int x, int y) {
    alab1:
        switch(GameRun.run_state) {
            case 0xFFFFFFE1: {
                if(this.gr.battle_state != 2) {
                    this.i0 = x;
                    this.i1 = y;
                    return;
                }
                GameRun gameRun0 = this.gr;
                gameRun0.cur_a = (byte)this.checkButton(5, x, y);
                if(this.gr.cur_a != -1) {
                    this.setKey5();
                    return;
                }
                break;
            }
            case -10: {
                this.i0 = x;
                this.i1 = y;
                if(this.map.my.state == 22) {
                    if(this.gr.say_c < 0) {
                        this.checkButton(2, x, y);
                        return;
                    }
                    this.checkButton(1, x, y);
                    return;
                }
                switch(this.map.my.state) {
                    case 0: {
                        if(this.gr.say_c == -1) {
                            this.checkButton(2, x, y);
                        }
                        else if(this.gr.say_s == 0 && this.gr.say_c == 0 && this.isMove(-this.map.map_x + x, -this.map.map_y + y)) {
                            this.setMove(x, y);
                        }
                        this.i0 = x;
                        this.i1 = y;
                        return;
                    }
                    case 1: 
                    case 10: {
                        this.checkButton(2, x, y);
                        return;
                    label_39:
                        if(this.map.my.state == 2 || this.map.my.state == 20) {
                            this.i0 = x;
                            this.i1 = y;
                            return;
                        }
                        break alab1;
                    }
                    case 12: 
                    case 16: 
                    case 17: 
                    case 18: {
                        this.i0 = x;
                        this.i1 = y;
                        return;
                    }
                    default: {
                        goto label_39;
                    }
                }
            }
            case 69: {
                this.i0 = x;
                this.i1 = y;
                return;
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
                this.i0 = x;
                this.i1 = y;
                return;
            }
            case 60: 
            case 98: {
                this.checkButton(1, x, y);
            }
        }
    }

    public void runMove() {
        boolean bb;
        if(GameRun.run_state != -10 || this.map.my.state != 0 || this.m0 == -1) {
            return;
        }
        int x = this.m0 - this.map.my.x;
        int y = this.m1 - this.map.my.y;
        if(Ms.abs(x) < this.map.my.speed && Ms.abs(y) < this.map.my.speed) {
            this.stopMove();
            return;
        }
        if(!this.dir) {
            bb = Ms.abs(x) >= this.map.my.speed;
        }
        else if(Ms.abs(y) < this.map.my.speed) {
            bb = true;
        }
        else {
            bb = false;
        }
        if(bb) {
            Ms.key = x >= 0 ? -4 : -3;
        }
        else {
            Ms.key = y >= 0 ? -2 : -1;
        }
        this.map.map_key = (byte)(-Ms.key);
        this.map.doKey();
    }

    public void selectListSY(int len, int x, int y, int w, int kw, int kh, int dis, int sel) {
        for(int i = 0; i < len; ++i) {
            if(Ms.i().isRect(this.i0, this.i1, 1, 1, x, y + (kh + dis) * i, w, kh)) {
                this.gr.selecty = (byte)i;
                if(i == sel) {
                    this.setKey5();
                }
                this.initPointer();
            }
        }
    }

    public byte selectMenuX(int len, int x, int y, int w, int h) {
        for(int i = 0; true; ++i) {
            if(i >= len) {
                return -1;
            }
            if(Ms.i().isRect(this.i0, this.i1, 1, 1, x + i * w, y, w, h)) {
                this.initPointer();
                return (byte)i;
            }
        }
    }

    public void setKey5() {
        Ms.key = 53;
        Ms.keyRepeat = true;
    }

    public void setKeySoftkey1() {
        Ms.key = -6;
        Ms.keyRepeat = true;
    }

    public void setMove(int x, int y) {
        this.m0 = (-this.map.map_x + x) / 20 * 20;
        this.m1 = (-this.map.map_y + y) / 20 * 20;
        this.dir = Ms.abs(this.m0 - this.map.my.x) < Ms.abs(this.m1 - this.map.my.y);
        this.isGo = true;
        this.tempx = x;
        this.tempy = y;
        this.gox = -this.map.map_x + this.tempx;
        this.goy = -this.map.map_y + this.tempy;
    }

    public void stopMove() {
        Ms.i().keyRelease();
        this.initPointer();
        this.isGo = false;
    }
}

