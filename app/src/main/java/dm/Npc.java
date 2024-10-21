package dm;

import main.Key_H;

public class Npc implements Key_H {
    public boolean b_auto;
    public boolean b_check;
    public boolean bdir;
    public byte brow_action;
    public byte brow_time;
    public byte brow_type;
    public byte dir;
    public byte frame_c;
    public byte frame_num;
    public byte ix;
    public byte iy;
    public byte lastAction;
    public byte now_action;
    public byte now_time;
    public byte npc_num;
    public byte[] other;
    public byte speed;
    public byte speed_x;
    public byte speed_y;
    public byte state;
    public byte timeMove;
    public short x;
    public short y;

    public Npc() {
        this.b_check = true;
        this.b_auto = false;
        this.bdir = false;
        this.npc_num = 0;
        this.frame_c = -1;
        this.frame_num = 1;
        this.lastAction = 0x7F;
        this.speed = 5;
        this.brow_type = -1;
        this.ix = -1;
        this.iy = -1;
        this.dir = 3;
        this.now_time = 0;
        this.now_action = 0;
    }

    public Npc(int len) {
        this.b_check = true;
        this.b_auto = false;
        this.bdir = false;
        this.npc_num = 0;
        this.frame_c = -1;
        this.frame_num = 1;
        this.lastAction = 0x7F;
        this.speed = 5;
        this.brow_type = -1;
        this.ix = -1;
        this.iy = -1;
        this.dir = 3;
        this.now_time = 0;
        this.now_action = 0;
        this.other = new byte[len];
    }

    public byte getIx() {
        return (byte)(this.x / 20);
    }

    public byte getIx_off() {
        return (byte)(this.x % 20);
    }

    public byte getIy() {
        return (byte)(this.y / 20);
    }

    public byte getIy_off() {
        return (byte)(this.y % 20);
    }

    public void setActionNo(boolean mode) {
        byte b = 1;
        if(this.bdir) {
            return;
        }
        switch(this.dir) {
            case 1: {
                byte[] arr_b = this.other;
                if(mode) {
                    b = 4;
                }
                arr_b[7] = b;
                break;
            }
            case 2: {
                this.other[7] = mode ? 3 : 0;
                break;
            }
            default: {
                this.other[7] = mode ? 5 : 2;
            }
        }
        this.other[7] = (byte)(this.other[7] + this.npc_num * 6);
    }

    public void setIXY(int _ix, int _iy) {
        this.ix = (byte)_ix;
        this.iy = (byte)_iy;
    }

    public void setIxIy_npc() {
        byte[] arr_b = this.other;
        arr_b[0] = this.getIx();
        byte[] arr_b1 = this.other;
        arr_b1[1] = this.getIy();
    }

    public void setLastAction(boolean _bdir, int _lastAction) {
        this.bdir = _bdir;
        this.lastAction = (byte)_lastAction;
    }

    public void setNpcNum(int length) {
        this.npc_num = (byte)(this.other[7] / 6);
        if((this.npc_num + 1) * 6 > length) {
            this.npc_num = 0;
        }
    }

    public void setSpeedXY(int _speed_x, int _speed_y) {
        this.speed_x = (byte)_speed_x;
        this.speed_y = (byte)_speed_y;
    }

    public void setXY(int ix, int iy, int offx, int offy) {
        this.x = (short)(ix * 20 + offx);
        this.y = (short)(iy * 20 + offy);
    }

    public void setXY_npc() {
        this.setXY(((int)this.other[0]), ((int)this.other[1]), 0, 0);
    }
}

