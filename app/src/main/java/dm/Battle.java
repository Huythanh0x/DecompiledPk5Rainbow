package dm;

public class Battle {
   public byte act_num = 1;
   public byte action;
   public boolean b_renascence = false;
   public byte baoji;
   public byte bg_id;
   public short[] cThrow = new short[4];
   public byte[] ceff = new byte[6];
   public short cexp;
   public short chp;
   public byte[] countS = new byte[10];
   public byte dead;
   public byte fs_level;
   public short[][] hit = new short[3][5];
   public Monster[] mon;
   public byte now_id;
   public byte rate_off;
   public byte skill;
   public byte throw_state = -1;

   public Battle(Monster[] var1) {
      super();
      this.mon = var1;
   }

   public void addHit(int var1, int var2, int var3) {
      this.hit[var3][0] = (short)var2;
      short[] var4 = this.hit[var3];
      var4[1] = (short)(var4[1] + var1);
      this.hit[var3][2] = 0;
      this.hit[var3][3] = 0;
      this.hit[var3][4] = 0;
   }

   public Monster getMon() {
      return this.mon[this.now_id];
   }

   public void initHit() {
      for(byte var1 = 0; var1 < this.hit.length; ++var1) {
         this.hit[var1][1] = 0;
      }

   }
}
