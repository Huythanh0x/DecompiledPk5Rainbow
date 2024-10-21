package dm.Battle;
import dm.Monster;
import java.lang.Object;
import java.lang.Short;
import java.lang.Class;
import java.lang.reflect.Array;

public class Battle	// class@0000df from classes.dex
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

    public void Battle(Monster[] _mon){
       super();
       this.throw_state = -1;
       byte[] uobyteArray = new byte[10];
       this.countS = uobyteArray;
       uobyteArray = new byte[6];
       this.ceff = uobyteArray;
       short[] oshortArray = new short[4];
       this.cThrow = oshortArray;
       int[] ointArray = new int[]{3,5};
       this.hit = Array.newInstance(Short.TYPE, ointArray);
       this.b_renascence = false;
       this.act_num = 1;
       this.mon = _mon;
    }
    public void addHit(int h,int type,int i){
       this.hit[i][0] = (short)type;
       object oobject = this.hit[i];
       oobject[1] = (short)(oobject[1] + h);
       this.hit[i][2] = 0;
       this.hit[i][3] = 0;
       this.hit[i][4] = 0;
    }
    public Monster getMon(){
       return this.mon[this.now_id];
    }
    public void initHit(){
       byte i = 0;
       while (i < this.hit.length) {
          this.hit[i][1] = 0;
          int ix = i + 1;
          i = (byte)ix;
       }
       return;
    }
}
