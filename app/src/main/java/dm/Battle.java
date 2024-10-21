package dm;

public class Battle
{
    public byte act_num;
    public byte action;
    public boolean b_renascence;
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
    public byte throw_state;
    
    public Battle(final Monster[] mon) {
        super();
        this.throw_state = -1;
        this.countS = new byte[10];
        this.ceff = new byte[6];
        this.cThrow = new short[4];
        this.hit = new short[3][5];
        this.b_renascence = false;
        this.act_num = 1;
        this.mon = mon;
    }
    
    public void addHit(final int n, final int n2, final int n3) {
        this.hit[n3][0] = (short)n2;
        final short[] array = this.hit[n3];
        array[1] += (short)n;
        this.hit[n3][2] = 0;
        this.hit[n3][3] = 0;
        this.hit[n3][4] = 0;
    }
    
    public Monster getMon() {
        return this.mon[this.now_id];
    }
    
    public void initHit() {
        for (int i = 0; i < this.hit.length; i = (byte)(i + 1)) {
            this.hit[i][1] = 0;
        }
    }
}
