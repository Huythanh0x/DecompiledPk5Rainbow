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
   public byte lastAction = 127;
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

   public Npc() {
      super();
   }

   public Npc(int var1) {
      super();
      this.other = new byte[var1];
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

   public void setActionNo(boolean var1) {
      byte var2 = 1;
      if (!this.bdir) {
         byte[] var3;
         if (this.dir == 2) {
            var3 = this.other;
            if (var1) {
               var2 = 3;
            } else {
               var2 = 0;
            }

            var3[7] = var2;
         } else if (this.dir == 1) {
            var3 = this.other;
            if (var1) {
               var2 = 4;
            }

            var3[7] = var2;
         } else {
            var3 = this.other;
            if (var1) {
               var2 = 5;
            } else {
               var2 = 2;
            }

            var3[7] = var2;
         }

         var3 = this.other;
         var3[7] = (byte)(var3[7] + this.npc_num * 6);
      }

   }

   public void setIXY(int var1, int var2) {
      this.ix = (byte)var1;
      this.iy = (byte)var2;
   }

   public void setIxIy_npc() {
      this.other[0] = this.getIx();
      this.other[1] = this.getIy();
   }

   public void setLastAction(boolean var1, int var2) {
      this.bdir = var1;
      this.lastAction = (byte)var2;
   }

   public void setNpcNum(int var1) {
      this.npc_num = (byte)(this.other[7] / 6);
      if ((this.npc_num + 1) * 6 > var1) {
         this.npc_num = 0;
      }

   }

   public void setSpeedXY(int var1, int var2) {
      this.speed_x = (byte)var1;
      this.speed_y = (byte)var2;
   }

   public void setXY(int var1, int var2, int var3, int var4) {
      this.x = (short)(var1 * 20 + var3);
      this.y = (short)(var2 * 20 + var4);
   }

   public void setXY_npc() {
      this.setXY(this.other[0], this.other[1], 0, 0);
   }
}
