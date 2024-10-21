package dm.Monster;
import main.Key_H;
import java.lang.Object;
import main.GameRun;
import java.lang.String;
import dm.Ms;

public class Monster implements Key_H	// class@0000e0 from classes.dex
{
    public byte effect;
    public byte effect_time;
    public byte[] monster;
    public short[] monsterPro;

    public void Monster(){
       super();
    }
    public void Monster(GameRun data,int enemy_name,int enemylevel,int enemy_no){
       Monster tmonster;
       int i;
       int i1;
       super();
       short[] oshortArray = new short[8];
       this.monsterPro = oshortArray;
       byte[] uobyteArray = new byte[18];
       this.monster = uobyteArray;
       this.monster[0] = (byte)enemy_name;
       this.monster[2] = (byte)enemylevel;
       byte[] temp_pro = data.monster_pro[enemy_name];
       this.monster[3] = temp_pro[6];
       this.monster[4] = temp_pro[5];
       this.monster[5] = temp_pro[12];
       this.monster[8] = 25;
       this.monster[9] = -1;
       this.monster[10] = -1;
       this.monster[11] = -1;
       this.monster[12] = -1;
       this.monster[13] = -1;
       this.monster[14] = -1;
       this.monster[15] = -1;
       if (enemy_no == -1) {
          this.monster[16] = (byte)((this.monster[3] * 2) + 4);
          this.monster[17] = 2;
       }else if(!enemy_no){
          Ms.i();
          this.monster[16] = (byte)(((this.monster[3] * 2) + 3) + Ms.getRandom(2));
          Ms.i();
          this.monster[17] = (byte)Ms.getRandom(3);
       }else if(enemy_no == 1){
          tmonster = this.monster;
          i = 16;
          i1 = (this.monster[3] * 2) + 3;
          Ms.i();
          int i2 = (Ms.getRandom(100) < 70)? 1: 0;
          tmonster[i] = (byte)(i1 + i2);
          tmonster = this.monster;
          i = 17;
          Ms.i();
          if (Ms.getRandom(100) < 70) {
             i1 = 2;
          }else {
             Ms.i();
             i1 = Ms.getRandom(2);
          }
          tmonster[i] = (byte)i1;
       }
       tmonster = this.monster;
       i = 6;
       i1 = (this.monster[4] > 3)? 120: 100;
       tmonster[i] = (byte)i1;
       this.monsterPro[2] = (short)(temp_pro[0] + ((temp_pro[7] * enemylevel) / 10));
       this.monsterPro[3] = (short)(temp_pro[1] + ((temp_pro[8] * enemylevel) / 10));
       this.monsterPro[1] = this.monsterPro[3];
       this.monsterPro[0] = this.monsterPro[2];
       this.monsterPro[4] = 0;
       this.setProAFD(temp_pro);
       if (this.monster[3] != -1) {
          data.getMagic(this);
       }
       if (!data.monInfoList[enemy_name]) {
          data.monInfoList[enemy_name] = 1;
          GameRun monInfoList = data.monInfoList;
          monInfoList[102] = (byte)(monInfoList[102] + 1);
          data.say("\x5b\x02\x72\x02\x56\x02\x92\x02\x5d\x02\x66\x02\x65\x02", 0);
       }
       this.effect = 7;
       this.effect_time = 0;
       temp_pro = null;
       return;
    }
    public void evolveMonster(GameRun data,int enemy_name,int evolve){
       this.monster[0] = (byte)enemy_name;
       byte[] temp_pro = data.monster_pro[enemy_name];
       this.monster[4] = temp_pro[5];
       Monster tmonster = this.monster;
       tmonster[5] = (byte)(tmonster[5] - evolve);
       this.setProAFD(temp_pro);
       this.monsterPro[2] = (short)(temp_pro[0] + ((temp_pro[7] * this.monster[2]) / 10));
       this.monsterPro[3] = (short)(temp_pro[1] + ((temp_pro[8] * this.monster[2]) / 10));
       this.resetPro(data);
       this.monsterPro[1] = this.monsterPro[3];
       temp_pro = null;
       if (data.monInfoList[enemy_name] != 2) {
          if (!data.monInfoList[enemy_name]) {
             GameRun monInfoList = data.monInfoList;
             monInfoList[102] = (byte)(monInfoList[102] + 1);
          }
          data.addMonInfoListBH();
          data.monInfoList[enemy_name] = 2;
       }
       return;
    }
    public boolean isBuffRate(int effect_id){
       boolean b = (this.monster[16] != effect_id && this.monster[17] != effect_id)? false: true;
       return b;
    }
    public boolean isEffect(int id){
       boolean b = (this.effect == id)? true: false;
       return b;
    }
    public boolean isMonEffect(int id){
       boolean b = (this.effect == id && this.effect_time != null)? true: false;
       return b;
    }
    public boolean isMonReel(int reel){
       boolean b = (this.monster[14] != reel && this.monster[15] != reel)? false: true;
       return b;
    }
    public void resetBoss(int fealty){
       this.monster[16] = 4;
       this.monster[17] = 10;
       this.monster[9] = 4;
       this.monster[10] = 9;
       this.monster[11] = 14;
       this.monster[12] = 19;
       this.monster[13] = 24;
       this.monster[14] = 30;
       this.monster[15] = 48;
       this.monster[6] = (byte)fealty;
    }
    public void resetMonster(int skill6,int skill7,int fealty){
       this.monster[16] = (byte)((this.monster[3] * 2) + 4);
       this.monster[17] = 2;
       this.monster[14] = (byte)skill6;
       this.monster[15] = (byte)skill7;
       this.monster[6] = (byte)fealty;
    }
    public void resetMonster(GameRun data,int evolve){
       int i = -1;
       if (evolve > i) {
          this.monster[5] = (byte)evolve;
       }else if(evolve == i){
          Ms.i();
          this.monster[5] = (byte)Ms.getRandom((this.monster[5] + 1));
       }
       this.resetPro(data);
       return;
    }
    public void resetPro(GameRun data){
       Monster tmonsterPro;
       if (this.isBuffRate(2)) {
          tmonsterPro = this.monsterPro;
          tmonsterPro[2] = (short)(tmonsterPro[2] + ((this.monsterPro[2] * data.inhesion[2]) / 100));
       }else if(this.isBuffRate(1)){
          tmonsterPro = this.monsterPro;
          tmonsterPro[2] = (short)(tmonsterPro[2] + ((this.monsterPro[2] * data.inhesion[1]) / 100));
       }
       if (this.monsterPro[2] < 1) {
          this.monsterPro[2] = 1;
       }
       this.monsterPro[0] = this.monsterPro[2];
       return;
    }
    public void setProAFD(byte[] data){
       this.monsterPro[5] = (short)(data[2] + ((data[9] * this.monster[2]) / 10));
       this.monsterPro[6] = (short)(data[3] + ((data[10] * this.monster[2]) / 10));
       this.monsterPro[7] = (short)(data[4] + ((data[11] * this.monster[2]) / 10));
    }
}
