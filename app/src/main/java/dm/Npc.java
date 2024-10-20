package dm;

import main.Key_H;

public class Npc implements Key_H {
  public boolean b_auto = false;
  
  public boolean b_check = true;
  
  public boolean bdir = false;
  
  public byte brow_action;
  
  public byte brow_time;
  
  public byte brow_type = -1;
  
  public byte dir = 3;
  
  public byte frame_c = -1;
  
  public byte frame_num = 1;
  
  public byte ix = -1;
  
  public byte iy = -1;
  
  public byte lastAction = Byte.MAX_VALUE;
  
  public byte now_action = 0;
  
  public byte now_time = 0;
  
  public byte npc_num = 0;
  
  public byte[] other;
  
  public byte speed = 5;
  
  public byte speed_x;
  
  public byte speed_y;
  
  public byte state;
  
  public byte timeMove;
  
  public short x;
  
  public short y;
  
  public Npc() {}
  
  public Npc(int paramInt) {
    this.other = new byte[paramInt];
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
  
  public void setActionNo(boolean paramBoolean) {
    byte b = 1;
    if (!this.bdir) {
      if (this.dir == 2) {
        byte[] arrayOfByte1 = this.other;
        if (paramBoolean) {
          b = 3;
        } else {
          b = 0;
        } 
        arrayOfByte1[7] = b;
      } else if (this.dir == 1) {
        byte[] arrayOfByte1 = this.other;
        if (paramBoolean)
          b = 4; 
        arrayOfByte1[7] = b;
      } else {
        byte[] arrayOfByte1 = this.other;
        if (paramBoolean) {
          b = 5;
        } else {
          b = 2;
        } 
        arrayOfByte1[7] = b;
      } 
      byte[] arrayOfByte = this.other;
      arrayOfByte[7] = (byte)(arrayOfByte[7] + this.npc_num * 6);
    } 
  }
  
  public void setIXY(int paramInt1, int paramInt2) {
    this.ix = (byte)paramInt1;
    this.iy = (byte)paramInt2;
  }
  
  public void setIxIy_npc() {
    this.other[0] = getIx();
    this.other[1] = getIy();
  }
  
  public void setLastAction(boolean paramBoolean, int paramInt) {
    this.bdir = paramBoolean;
    this.lastAction = (byte)paramInt;
  }
  
  public void setNpcNum(int paramInt) {
    this.npc_num = (byte)(this.other[7] / 6);
    if ((this.npc_num + 1) * 6 > paramInt)
      this.npc_num = 0; 
  }
  
  public void setSpeedXY(int paramInt1, int paramInt2) {
    this.speed_x = (byte)paramInt1;
    this.speed_y = (byte)paramInt2;
  }
  
  public void setXY(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.x = (short)(paramInt1 * 20 + paramInt3);
    this.y = (short)(paramInt2 * 20 + paramInt4);
  }
  
  public void setXY_npc() {
    setXY(this.other[0], this.other[1], 0, 0);
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/dm/Npc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */