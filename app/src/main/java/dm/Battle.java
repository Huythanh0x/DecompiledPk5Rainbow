/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  dm.Monster
 */
package dm;

import dm.Monster;

public class Battle {
    public byte act_num = 1;
    public byte action;
    public boolean b_renascence = false;
    public byte baoji;
    public byte bg_id;
    public short[] cThrow;
    public byte[] ceff;
    public short cexp;
    public short chp;
    public byte[] countS;
    public byte dead;
    public byte fs_level;
    public short[][] hit;
    public Monster[] mon;
    public byte now_id;
    public byte rate_off;
    public byte skill;
    public byte throw_state = (byte)-1;

    public Battle(Monster[] monsterArray) {
        this.countS = new byte[10];
        this.ceff = new byte[6];
        this.cThrow = new short[4];
        this.hit = new short[3][5];
        this.mon = monsterArray;
    }

    public void addHit(int n, int n2, int n3) {
        this.hit[n3][0] = (short)n2;
        short[] sArray = this.hit[n3];
        sArray[1] = (short)(sArray[1] + n);
        this.hit[n3][2] = 0;
        this.hit[n3][3] = 0;
        this.hit[n3][4] = 0;
    }

    public Monster getMon() {
        return this.mon[this.now_id];
    }

    public void initHit() {
        int n = 0;
        while (n < this.hit.length) {
            this.hit[n][1] = 0;
            n = (byte)(n + 1);
        }
        return;
    }
}
