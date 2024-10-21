package dm;

import main.Key_H;

public class Npc implements Key_H
{
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
        super();
        this.b_check = true;
        this.b_auto = false;
        this.bdir = false;
        this.npc_num = 0;
        this.frame_c = -1;
        this.frame_num = 1;
        this.lastAction = 127;
        this.speed = 5;
        this.brow_type = -1;
        this.ix = -1;
        this.iy = -1;
        this.dir = 3;
        this.now_time = 0;
        this.now_action = 0;
    }
    
    public Npc(final int n) {
        super();
        this.b_check = true;
        this.b_auto = false;
        this.bdir = false;
        this.npc_num = 0;
        this.frame_c = -1;
        this.frame_num = 1;
        this.lastAction = 127;
        this.speed = 5;
        this.brow_type = -1;
        this.ix = -1;
        this.iy = -1;
        this.dir = 3;
        this.now_time = 0;
        this.now_action = 0;
        this.other = new byte[n];
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
    
    public void setActionNo(final boolean b) {
        byte b2 = 1;
        if (!this.bdir) {
            if (this.dir == 2) {
                final byte[] other = this.other;
                byte b3;
                if (b) {
                    b3 = 3;
                }
                else {
                    b3 = 0;
                }
                other[7] = b3;
            }
            else if (this.dir == 1) {
                final byte[] other2 = this.other;
                if (b) {
                    b2 = 4;
                }
                other2[7] = b2;
            }
            else {
                final byte[] other3 = this.other;
                byte b4;
                if (b) {
                    b4 = 5;
                }
                else {
                    b4 = 2;
                }
                other3[7] = b4;
            }
            final byte[] other4 = this.other;
            other4[7] += (byte)(this.npc_num * 6);
        }
    }
    
    public void setIXY(final int n, final int n2) {
        this.ix = (byte)n;
        this.iy = (byte)n2;
    }
    
    public void setIxIy_npc() {
        this.other[0] = this.getIx();
        this.other[1] = this.getIy();
    }
    
    public void setLastAction(final boolean bdir, final int n) {
        this.bdir = bdir;
        this.lastAction = (byte)n;
    }
    
    public void setNpcNum(final int n) {
        this.npc_num = (byte)(this.other[7] / 6);
        if ((this.npc_num + 1) * 6 > n) {
            this.npc_num = 0;
        }
    }
    
    public void setSpeedXY(final int n, final int n2) {
        this.speed_x = (byte)n;
        this.speed_y = (byte)n2;
    }
    
    public void setXY(final int n, final int n2, final int n3, final int n4) {
        this.x = (short)(n * 20 + n3);
        this.y = (short)(n2 * 20 + n4);
    }
    
    public void setXY_npc() {
        this.setXY(this.other[0], this.other[1], 0, 0);
    }
}
