package dm.Npc;
import main.Key_H;
import java.lang.Object;

public class Npc implements Key_H	// class@0000e2 from classes.dex
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

    public void Npc(){
       super();
       this.b_check = true;
       this.b_auto = false;
       this.bdir = false;
       this.npc_num = false;
       this.frame_c = -1;
       this.frame_num = true;
       this.lastAction = 127;
       this.speed = 5;
       this.brow_type = -1;
       this.ix = -1;
       this.iy = -1;
       this.dir = 3;
       this.now_time = false;
       this.now_action = false;
    }
    public void Npc(int len){
       super();
       this.b_check = true;
       this.b_auto = false;
       this.bdir = false;
       this.npc_num = false;
       this.frame_c = -1;
       this.frame_num = true;
       this.lastAction = 127;
       this.speed = 5;
       this.brow_type = -1;
       this.ix = -1;
       this.iy = -1;
       this.dir = 3;
       this.now_time = false;
       this.now_action = false;
       byte[] uobyteArray = new byte[len];
       this.other = uobyteArray;
    }
    public byte getIx(){
       return (byte)(this.x / 20);
    }
    public byte getIx_off(){
       return (byte)(this.x % 20);
    }
    public byte getIy(){
       return (byte)(this.y / 20);
    }
    public byte getIy_off(){
       return (byte)(this.y % 20);
    }
    public void setActionNo(boolean mode){
       Npc tother;
       int i = 2;
       byte b = 1;
       if (this.bdir == null) {
          if (this.dir == i) {
             tother = this.other;
             b = (mode)? 3: 0;
             tother[7] = b;
          }else if(this.dir == b){
             tother = this.other;
             if (mode) {
                b = 4;
             }
             tother[7] = b;
          }else {
             tother = this.other;
             b = (mode)? 5: i;
             tother[7] = b;
          }
          tother = this.other;
          tother[7] = (byte)(tother[7] + (this.npc_num * 6));
       }
       return;
    }
    public void setIXY(int _ix,int _iy){
       this.ix = (byte)_ix;
       this.iy = (byte)_iy;
    }
    public void setIxIy_npc(){
       this.other[0] = this.getIx();
       this.other[1] = this.getIy();
    }
    public void setLastAction(boolean _bdir,int _lastAction){
       this.bdir = _bdir;
       this.lastAction = (byte)_lastAction;
    }
    public void setNpcNum(int length){
       this.npc_num = (byte)(this.other[7] / 6);
       if ((((this.npc_num + 1) * 6)) > length) {
          this.npc_num = 0;
       }
       return;
    }
    public void setSpeedXY(int _speed_x,int _speed_y){
       this.speed_x = (byte)_speed_x;
       this.speed_y = (byte)_speed_y;
    }
    public void setXY(int ix,int iy,int offx,int offy){
       this.x = (short)((ix * 20) + offx);
       this.y = (short)((iy * 20) + offy);
    }
    public void setXY_npc(){
       this.setXY(this.other[0], this.other[1], 0, 0);
    }
}
