package dm;

import main.GameRun;
import main.Key_H;

public class Monster implements Key_H {
   public byte effect;
   public byte effect_time;
   public byte[] monster;
   public short[] monsterPro;

   public Monster() {
      super();
   }

   public Monster(GameRun var1, int var2, int var3, int var4) {
      super();
      this.monsterPro = new short[8];
      this.monster = new byte[18];
      this.monster[0] = (byte)var2;
      this.monster[2] = (byte)var3;
      byte[] var6 = var1.monster_pro[var2];
      this.monster[3] = var6[6];
      this.monster[4] = var6[5];
      this.monster[5] = var6[12];
      this.monster[8] = 25;
      this.monster[9] = -1;
      this.monster[10] = -1;
      this.monster[11] = -1;
      this.monster[12] = -1;
      this.monster[13] = -1;
      this.monster[14] = -1;
      this.monster[15] = -1;
      byte[] var7;
      byte var9;
      if (var4 == -1) {
         this.monster[16] = (byte)(this.monster[3] * 2 + 4);
         this.monster[17] = 2;
      } else if (var4 == 0) {
         var7 = this.monster;
         var9 = this.monster[3];
         Ms.i();
         var7[16] = (byte)(var9 * 2 + 3 + Ms.getRandom(2));
         var7 = this.monster;
         Ms.i();
         var7[17] = (byte)Ms.getRandom(3);
      } else if (var4 == 1) {
         var7 = this.monster;
         byte var5 = this.monster[3];
         Ms.i();
         if (Ms.getRandom(100) < 70) {
            var9 = 1;
         } else {
            var9 = 0;
         }

         var7[16] = (byte)(var5 * 2 + 3 + var9);
         var7 = this.monster;
         Ms.i();
         if (Ms.getRandom(100) < 70) {
            var4 = 2;
         } else {
            Ms.i();
            var4 = Ms.getRandom(2);
         }

         var7[17] = (byte)var4;
      }

      var7 = this.monster;
      if (this.monster[4] > 3) {
         var9 = 120;
      } else {
         var9 = 100;
      }

      var7[6] = (byte)var9;
      this.monsterPro[2] = (short)(var6[0] + var6[7] * var3 / 10);
      this.monsterPro[3] = (short)(var6[1] + var6[8] * var3 / 10);
      this.monsterPro[1] = this.monsterPro[3];
      this.monsterPro[0] = this.monsterPro[2];
      this.monsterPro[4] = 0;
      this.setProAFD(var6);
      if (this.monster[3] != -1) {
         var1.getMagic(this);
      }

      if (var1.monInfoList[var2] == 0) {
         var1.monInfoList[var2] = 1;
         var6 = var1.monInfoList;
         ++var6[102];
         var1.say("\u5ba0\u7269\u56fe\u9274\u5df2\u66f4\u65b0", 0);
      }

      this.effect = 7;
      this.effect_time = 0;
      byte[] var8 = (byte[])null;
   }

   public void evolveMonster(GameRun var1, int var2, int var3) {
      this.monster[0] = (byte)var2;
      byte[] var5 = var1.monster_pro[var2];
      this.monster[4] = var5[5];
      byte[] var4 = this.monster;
      var4[5] = (byte)(var4[5] - var3);
      this.setProAFD(var5);
      this.monsterPro[2] = (short)(var5[0] + var5[7] * this.monster[2] / 10);
      this.monsterPro[3] = (short)(var5[1] + var5[8] * this.monster[2] / 10);
      this.resetPro(var1);
      this.monsterPro[1] = this.monsterPro[3];
      var4 = (byte[])null;
      if (var1.monInfoList[var2] != 2) {
         if (var1.monInfoList[var2] == 0) {
            var4 = var1.monInfoList;
            ++var4[102];
         }

         var1.addMonInfoListBH();
         var1.monInfoList[var2] = 2;
      }

   }

   public boolean isBuffRate(int var1) {
      boolean var2;
      if (this.monster[16] != var1 && this.monster[17] != var1) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public boolean isEffect(int var1) {
      boolean var2;
      if (this.effect == var1) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public boolean isMonEffect(int var1) {
      boolean var2;
      if (this.effect == var1 && this.effect_time != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public boolean isMonReel(int var1) {
      boolean var2;
      if (this.monster[14] != var1 && this.monster[15] != var1) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public void resetBoss(int var1) {
      this.monster[16] = 4;
      this.monster[17] = 10;
      this.monster[9] = 4;
      this.monster[10] = 9;
      this.monster[11] = 14;
      this.monster[12] = 19;
      this.monster[13] = 24;
      this.monster[14] = 30;
      this.monster[15] = 48;
      this.monster[6] = (byte)var1;
   }

   public void resetMonster(int var1, int var2, int var3) {
      this.monster[16] = (byte)(this.monster[3] * 2 + 4);
      this.monster[17] = 2;
      this.monster[14] = (byte)var1;
      this.monster[15] = (byte)var2;
      this.monster[6] = (byte)var3;
   }

   public void resetMonster(GameRun var1, int var2) {
      if (var2 > -1) {
         this.monster[5] = (byte)var2;
      } else if (var2 == -1) {
         byte[] var3 = this.monster;
         Ms.i();
         var3[5] = (byte)Ms.getRandom(this.monster[5] + 1);
      }

      this.resetPro(var1);
   }

   public void resetPro(GameRun var1) {
      short[] var2;
      if (this.isBuffRate(2)) {
         var2 = this.monsterPro;
         var2[2] = (short)(var2[2] + this.monsterPro[2] * var1.inhesion[2] / 100);
      } else if (this.isBuffRate(1)) {
         var2 = this.monsterPro;
         var2[2] = (short)(var2[2] + this.monsterPro[2] * var1.inhesion[1] / 100);
      }

      if (this.monsterPro[2] < 1) {
         this.monsterPro[2] = 1;
      }

      this.monsterPro[0] = this.monsterPro[2];
   }

   public void setProAFD(byte[] var1) {
      this.monsterPro[5] = (short)(var1[2] + var1[9] * this.monster[2] / 10);
      this.monsterPro[6] = (short)(var1[3] + var1[10] * this.monster[2] / 10);
      this.monsterPro[7] = (short)(var1[4] + var1[11] * this.monster[2] / 10);
   }
}
