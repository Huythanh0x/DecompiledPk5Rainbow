package minigame;

import dm.Ms;
import dm.Ui;
import main.Constants_H;
import main.GameRun;

public class Cards implements MiniGame_H {
   private short count;
   private byte[][] findC;
   private byte[][] findN;
   private byte find_count = 3;
   private short gh = 40;
   GameRun gr;
   private short gspace = 4;
   private short gw = 30;
   private short gx;
   private short gy;
   private short hh = 160;
   private byte length;
   private byte lv;
   private byte[][] num;
   byte sel;
   private int sell_money;
   private byte selx;
   private byte sely;
   private byte state;
   private byte time = 3;
   private byte tx;
   private byte ty;
   private short wh = 320;

   public Cards(GameRun var1) {
      super();
      byte[] var2 = new byte[]{3, 6};
      this.num = new byte[][]{{3, 4}, var2, {4, 6}, {5, 6}};
      this.gr = var1;
   }

   private void drawCard(int var1, int var2, int var3, int var4, int var5) {
      if (var5 == 0) {
         Ui.i().drawK(var3, var4, this.gw, this.gh, 1);
         Ui.i().drawUi(25, (this.gw >> 1) + var3, (this.gh >> 1) + var4, 3, 0);
      } else if (var5 == 1) {
         Ui.i().drawK((this.gw >> 1) + var3 - 2, var4 - 3, 5, this.gh + 6, 1);
         byte[] var7 = this.findC[var1];
         byte var6 = (byte)(var7[var2] + 1);
         var7[var2] = var6;
         if (var6 > 3) {
            this.findC[var1][var2] = 0;
         }
      } else {
         Ui.i().drawK(var3, var4, this.gw, this.gh, 5);
         this.gr.drawItem(this.findN[var1][var2], (this.gw >> 1) + var3, (this.gh >> 1) + var4, 3);
         Ui.i().drawNum("" + this.findN[var1][var2], this.gw + var3, this.gh + var4, 40, 0);
      }

   }

   private void drawGame(int var1, int var2, int var3) {
      for(var1 = 0; var1 < this.findN.length; ++var1) {
         for(var2 = 0; var2 < this.findN[var1].length; ++var2) {
            short var5 = this.wh;
            short var6 = this.gx;
            short var11 = this.gw;
            short var9 = this.gspace;
            short var8 = this.hh;
            short var10 = this.gy;
            short var4 = this.gh;
            short var7 = this.gspace;
            byte var14;
            if (this.findC[var1][var2] == 3) {
               var14 = 1;
            } else {
               var14 = this.findC[var1][var2];
            }

            this.drawCard(var1, var2, (var11 + var9) * var2 + var5 + var6, (var4 + var7) * var1 + var8 + var10, var14);
            if (this.gr.pkey.isSelect(this.wh + this.gx + (this.gw + this.gspace) * var2, this.hh + this.gy + (this.gh + this.gspace) * var1, this.gw + this.gspace, this.gh + this.gspace) && this.state < 3) {
               this.tx = (byte)var2;
               this.ty = (byte)var1;
               this.gr.pkey.setKey5();
            }
         }
      }

      Ui.i().drawRectZ(15400191, this.wh + this.gx + this.tx * (this.gw + this.gspace), this.hh + this.gy + this.ty * (this.gh + this.gspace), this.gw, this.gh, 3);
      if (this.count > 0) {
         Ui.i().drawNum("" + this.count / 10, 320 + 10, 29, 36, 2);
      } else {
         Ui.i().drawString("\u6e38\u620f\u5f00\u59cb", 320, 4, 17, 3, 0);
         GameRun var12 = this.gr;
         StringBuilder var13 = new StringBuilder("\u53ef\u9519\u6b21\u6570\uff1a");
         if (this.time < 0) {
            var1 = 0;
         } else {
            var1 = this.time - 1;
         }

         var12.showStringM(var13.append(var1).append("\u6b21").toString(), 320 + 200, 180 - 75, 5, 0);
      }

   }

   private void nullGame() {
      this.findN = null;
      this.findC = null;
      this.num = null;
   }

   public void draw0(int var1, int var2, int var3) {
      Ui.i().fillRectB();
      Ui.i().drawK(var1, var2 + 25 + 5, 200 - 10, var3, 4);
      Ui.i().drawK(var1 + 200, var2 + 25 + 5, 200 + 20, var3, 4);
      Ui.i().drawK(var1 + 420 + 10, var2 + 25 + 5, 200 - 10, var3, 4);
      if (this.state == 0) {
         Ui.i().drawString("\u6e38\u620f\u89c4\u5219", 320, var2 + 25 + 5, 33, 3, 1);
         Ui.i().drawUi(7, 320 - 50 + 7, var2 + 25, 40, 0);
         Ui.i().drawUi(7, 320 + 50 + 7, var2 + 25, 36, 4);
      }

      Ui.i().drawStringY(this.gr.about_a, 25, var2 + 25 + 10, 25, 0, 0);
      if (this.state == 0) {
         this.gr.showStringM("\u9700\u8981\u7684\u53c2\u52a0\u8d39\uff1a" + this.sell_money + "\u91d1", 320, var2 + var3 - 50, 7, 0);
         int var4 = var2 + 75 + 5;
         Ui.i().drawListKY(2, var1 + 200 + 12 + 25, var4, 200 - 50, 3, 30, 10, this.sel, 4, 2);

         for(var2 = 0; var2 < this.gr.about_b.length; ++var2) {
            Ui var6 = Ui.i();
            String var5 = this.gr.about_b[var2].toString();
            byte var7;
            if (this.sel == var2) {
               var7 = 0;
            } else {
               var7 = 3;
            }

            var6.drawString(var5, var1 + 200 + 15 + 25 + 26, var2 * 40 + var4 - 2, 0, var7, 1);
            if (this.gr.pkey.isSelect(var1 + 200 + 12 + 25, var2 * 40 + var4 - 2, 200 - 50, 40)) {
               if (this.sel == var2) {
                  this.gr.pkey.setKey5();
               } else {
                  this.sel = (byte)var2;
               }
            }
         }
      }

      this.gr.drawMoney(320, 360, 3, false);
      if (this.state == 0) {
         Ui.i().drawYesNo(true, true);
      }

   }

   public void go(int var1) {
      this.gr.line_max = 9;
      this.count = 100;
      this.time = (byte)(this.lv * 2 + 4);
      this.find_count = (byte)(this.num[this.lv][0] * this.num[this.lv][1] / 2);
      if (var1 < 1) {
         this.ty = 0;
         this.state = 0;
         this.sell_money = this.lv * 200 + 200;
      } else {
         this.gx = (short)(-((this.gw + this.gspace) * this.num[this.lv][1]) >> 1);
         this.gy = (short)(-((this.gh + this.gspace) * this.num[this.lv][0]) >> 1);
         this.ty = 0;
         this.tx = 0;
         this.state = 1;
         byte var6 = 0;

         byte var3;
         byte[] var5;
         for(var5 = new byte[this.find_count]; var6 < this.findC.length; ++var6) {
            for(var3 = 0; var3 < this.findC[var6].length; ++var3) {
               this.findC[var6][var3] = 2;
               this.findN[var6][var3] = 0;
            }
         }

         var6 = 0;

         while(var6 < var5.length) {
            Ms.i();
            byte var2 = (byte)(Ms.getRandom(35) + 1);

            for(var3 = (byte)(var5.length - 1); var3 > -1 && var5[var3] != var2; --var3) {
            }

            if (var3 == -1) {
               var5[var6] = var2;
               ++var6;
            }
         }

         for(var6 = 0; var6 < var5.length; ++var6) {
            for(var3 = 0; var3 < 2; ++var3) {
               byte var4;
               do {
                  Ms.i();
                  var4 = (byte)Ms.getRandom(this.num[this.lv][0] * this.num[this.lv][1]);
               } while(this.findN[var4 / this.num[this.lv][1]][var4 % this.num[this.lv][1]] != 0);

               this.findN[var4 / this.num[this.lv][1]][var4 % this.num[this.lv][1]] = var5[var6];
            }
         }

         var5 = (byte[])null;
      }

   }

   public void go(int var1, int var2) {
      this.gr.setStringB(this.gr.createString("data/gamec.d"), 160, 0);
      this.gr.setStringB("\u5f00\u59cb\u6e38\u620f#n\u79bb\u5f00\u6e38\u620f", Constants_H.WIDTH, 1);
      this.lv = (byte)var2;
      this.findN = null;
      byte var3 = this.num[this.lv][0];
      byte var4 = this.num[this.lv][1];
      this.findN = new byte[var3][var4];
      this.findC = null;
      var4 = this.num[this.lv][0];
      var3 = this.num[this.lv][1];
      this.findC = new byte[var4][var3];
      this.length = 9;
      this.go(var1);
   }

   public boolean key() {
      boolean var3;
      if (Ms.i().key_delay()) {
         var3 = false;
      } else {
         if (this.state == 0) {
            if (Ms.i().key_Up_Down()) {
               this.sel = (byte)(this.sel ^ 1);
            } else if (Ms.i().key_S1_Num5()) {
               Ms.i().keyRelease();
               if (this.sel == 0 && this.gr.isMoney(this.sell_money, true)) {
                  this.go(1, this.lv);
               } else if (this.sel == 1) {
                  Ms.i().keyRelease();
                  this.nullGame();
                  var3 = true;
                  return var3;
               }
            } else if (Ms.i().key_S2()) {
               Ms.i().keyRelease();
               this.nullGame();
               var3 = true;
               return var3;
            }
         } else if (this.state < 3) {
            if (Ms.i().key_Up_Down()) {
               this.ty = Ms.i().select(this.ty, 0, this.findN.length - 1);
            } else if (Ms.i().key_Left_Right()) {
               this.tx = Ms.i().select(this.tx, 0, this.findN[this.ty].length - 1);
            } else if (Ms.i().key_S1_Num5()) {
               Ms.i().keyRelease();
               if (this.state == 0) {
                  this.go(0, this.lv);
               } else if (this.findC[this.ty][this.tx] == 0) {
                  byte[] var4 = this.findC[this.ty];
                  byte var2 = this.tx;
                  ++var4[var2];
                  byte var1 = (byte)(this.state + 1);
                  this.state = var1;
                  if (var1 == 2) {
                     this.selx = this.tx;
                     this.sely = this.ty;
                  }
               }
            }
         }

         var3 = false;
      }

      return var3;
   }

   public void patin() {
      this.draw0(10, 2, 280);
      if (this.state != 0) {
         this.drawGame(10, 2, (this.length + 3) * 25);
      }

   }

   public void run() {
      if (this.time < 1) {
         if (this.time == 0) {
            this.time = -1;
            this.gr.say("\u6e38\u620f\u5931\u8d25\uff01\uff01\uff01", -1);
         } else if (this.time == -1 && this.gr.say_c == 0) {
            this.go(0, this.lv);
         }
      } else if (this.find_count < 1) {
         if (this.find_count == 0) {
            this.find_count = -1;
            GameRun var5 = this.gr;
            var5.money += this.time * 125 + 100;
            this.gr.say("\u83b7\u5f97\u91d1\u94b1\uff1a" + (this.time * 125 + 100), -1);
            byte[] var6 = this.gr.rmsOther;
            var6[8] = (byte)(var6[8] | 1 << this.lv);
         } else if (this.find_count == -1 && this.gr.say_c == 0) {
            this.go(0, this.lv);
         }
      } else if (this.state >= 3) {
         byte var1 = (byte)(this.state + 1);
         this.state = var1;
         if (var1 > 10) {
            this.state = 1;
         } else if (this.state == 10) {
            if (this.findN[this.ty][this.tx] != this.findN[this.sely][this.selx]) {
               this.findC[this.ty][this.tx] = 3;
               this.findC[this.sely][this.selx] = 3;
               --this.time;
            } else {
               --this.find_count;
            }
         }
      } else if (this.count > 0) {
         short var2 = (short)(this.count - 1);
         this.count = var2;
         if (var2 == 0) {
            for(byte var3 = 0; var3 < this.findC.length; ++var3) {
               for(byte var4 = 0; var4 < this.findC[var3].length; ++var4) {
                  this.findC[var3][var4] = 3;
               }
            }
         }
      }

   }
}
