package dm;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public class Battle {
    public byte action;
    public byte baoji;
    public byte bg_id;
    public short cexp;
    public short chp;
    public byte dead;
    public byte fs_level;
    public Monster[] mon;
    public byte now_id;
    public byte rate_off;
    public byte skill;
    public byte throw_state = -1;
    public byte[] countS = new byte[10];
    public byte[] ceff = new byte[6];
    public short[] cThrow = new short[4];
    //todo thanh0x fix here [][]
    public short[][] hit = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 3, 5);
    public boolean b_renascence = false;
    public byte act_num = 1;

    public Battle(Monster[] _mon) {
        this.mon = _mon;
    }

    public Monster getMon() {
        return this.mon[this.now_id];
    }

    public void initHit() {
        for (byte i = 0; i < this.hit.length; i = (byte) (i + 1)) {
            this.hit[i][1] = 0;
        }
    }

    public void addHit(int h, int type, int i) {
        this.hit[i][0] = (short) type;
        short[] sArr = this.hit[i];
        sArr[1] = (short) (sArr[1] + h);
        this.hit[i][2] = 0;
        this.hit[i][3] = 0;
        this.hit[i][4] = 0;
    }
}
