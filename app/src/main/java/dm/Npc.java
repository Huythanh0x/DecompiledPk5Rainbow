/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  main.Key_H
 */
package dm;

import main.Key_H;

public class Npc
implements Key_H {
    public boolean b_auto = false;
    public boolean b_check = true;
    public boolean bdir = false;
    public byte brow_action;
    public byte brow_time;
    public byte brow_type;
    public byte dir;
    public byte frame_c = (byte)-1;
    public byte frame_num = 1;
    public byte ix;
    public byte iy;
    public byte lastAction = (byte)127;
    public byte now_action = 0;
    public byte now_time = 0;
    public byte npc_num = 0;
    public byte[] other;
    public byte speed = (byte)5;
    public byte speed_x;
    public byte speed_y;
    public byte state;
    public byte timeMove;
    public short x;
    public short y;

    public Npc() {
        this.brow_type = (byte)-1;
        this.ix = (byte)-1;
        this.iy = (byte)-1;
        this.dir = (byte)3;
    }

    public Npc(int n) {
        this.brow_type = (byte)-1;
        this.ix = (byte)-1;
        this.iy = (byte)-1;
        this.dir = (byte)3;
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

    /*
     * Unable to fully structure code
     */
    public void setActionNo(boolean var1_1) {
        block9: {
            var2_2 = 1;
            if (this.bdir) lbl-1000:
            // 2 sources

            {
                return;
            }
            if (this.dir == 2) {
                var3_3 = this.other;
                if (var1_1) {
                    var2_2 = 3;
lbl9:
                    // 2 sources

                    while (true) {
                        var3_3[7] = var2_2;
lbl11:
                        // 3 sources

                        while (true) {
                            var3_3 = this.other;
                            var3_3[7] = (byte)(var3_3[7] + this.npc_num * 6);
                            ** continue;
                            break;
                        }
                        break;
                    }
                }
                var2_2 = 0;
                ** continue;
            }
            if (this.dir != 1) break block9;
            var3_3 = this.other;
            if (var1_1) {
                var2_2 = 4;
            }
            var3_3[7] = var2_2;
            ** GOTO lbl11
        }
        var3_3 = this.other;
        if (var1_1) {
            var2_2 = 5;
lbl27:
            // 2 sources

            while (true) {
                var3_3[7] = var2_2;
                ** continue;
                break;
            }
        }
        var2_2 = 2;
        ** while (true)
    }

    public void setIXY(int n, int n2) {
        this.ix = (byte)n;
        this.iy = (byte)n2;
    }

    public void setIxIy_npc() {
        this.other[0] = this.getIx();
        this.other[1] = this.getIy();
    }

    public void setLastAction(boolean bl, int n) {
        this.bdir = bl;
        this.lastAction = (byte)n;
    }

    public void setNpcNum(int n) {
        this.npc_num = (byte)(this.other[7] / 6);
        if ((this.npc_num + 1) * 6 > n) {
            this.npc_num = 0;
        }
    }

    public void setSpeedXY(int n, int n2) {
        this.speed_x = (byte)n;
        this.speed_y = (byte)n2;
    }

    public void setXY(int n, int n2, int n3, int n4) {
        this.x = (short)(n * 20 + n3);
        this.y = (short)(n2 * 20 + n4);
    }

    public void setXY_npc() {
        this.setXY(this.other[0], this.other[1], 0, 0);
    }
}
