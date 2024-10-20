package minigame;

import dm.Ms;
import dm.Sprite;
import dm.Ui;
import javax.microedition.lcdui.Image;
import main.Constants_H;
import main.GameRun;

public class Bearer implements MiniGame_H {
   private final byte SPEED;
   private short ballC0;
   private short ballC1;
   private short[][] ballDate = new short[][]{{10, 20, 60, 10, 220}, {13, 40, 60, 12, 170}, {10, 40, 60, 10, 120}};
   private byte[] ball_time;
   private Sprite bsp;
   private short count;
   private byte cur;
   private short[][] gDate = new short[][]{{9, 1, 10, 2, 11, 4, 27, 8, 2, -10}, {50, 100, 150, 200}, {60, 40, 30, 10}, {8, 6, 13, 3, 20, 5, 30, 10}};
   GameRun gr;
   private Image img;
   private byte length;
   private byte lv;
   private short[] money = new short[]{150, 200, 300, 450};
   private short[] myxy;
   byte sel;
   private Sprite[] sp;
   private byte state;
   private short time0;
   private short time1;
   private short[][] xy = new short[40][7];

   public Bearer(GameRun var1) {
      super();
      short[] var2 = new short[]{0, 275, 67, 10, 0};
      this.myxy = var2;
      this.ball_time = new byte[]{20, 15, 10, 5};
      this.SPEED = 10;
      this.gr = var1;
   }

   private void addBall(int var1) {
      this.xy[this.cur][0] = -20;
      this.xy[this.cur][1] = this.ballDate[var1][4];
      this.xy[this.cur][2] = (short)(this.ballDate[var1][1] / this.ballDate[var1][0]);
      this.xy[this.cur][4] = this.ballDate[var1][0];
      this.xy[this.cur][5] = (short)var1;
      this.xy[this.cur][3] = this.ballDate[var1][3];
      short[] var3 = this.xy[this.cur];
      Ms.i();
      var3[6] = (short)Ms.getRandom(this.gDate[0].length >> 1);
      byte var2 = (byte)(this.cur + 1);
      this.cur = var2;
      if (var2 >= this.xy.length) {
         this.cur = 0;
      }

   }

   private void draw0(int var1, int var2, int var3) {
      int var5 = var3 + 45;
      Ui.i().fillRectB();
      Ui.i().drawK(var1, var2 + 25 + 5, 200 - 10, var5, 4);
      Ui.i().drawK(var1 + 200 + 10, var2 + 25 + 5, 200, var5, 4);
      Ui.i().drawK(var1 + 420 + 10, var2 + 25 + 5, 200 - 10, var5, 4);
      Ui.i().drawString("\u6e38\u620f\u89c4\u5219", 320, var2 + 25 + 5, 33, 3, 1);
      Ui.i().drawUi(7, 320 - 50 - 5, var2 + 25 - 4, 40, 0);
      Ui.i().drawUi(7, 320 + 50 + 5, var2 + 25 - 4, 36, 4);
      Ui.i().drawStringY(this.gr.about_a, 25, var2 + 75 + 10, 25, 0, 0);
      var3 = var2 + 100;
      Ui.i().drawString("\u7403\u7684\u5206\u6570\uff1a", var1 + 420 + 20, var3, 0, 0, 0);
      int var6 = var3 + 50;

      byte var4;
      Ui var9;
      String var10;
      for(var3 = 0; var3 < this.gDate[0].length; var3 += 2) {
         GameRun var8 = this.gr;
         short var7 = this.gDate[0][var3];
         if (var3 % 4 == 2) {
            var4 = 100;
         } else {
            var4 = 0;
         }

         var8.drawItem(var7, var1 + 420 + 25 + var4, (var3 >> 2) * 30 + var6, 0);
         var9 = Ui.i();
         if (this.gDate[0][var3 + 1] < 0) {
            var10 = "";
         } else {
            var10 = "+";
         }

         var10 = var10 + this.gDate[0][var3 + 1];
         if (var3 % 4 == 2) {
            var4 = 100;
         } else {
            var4 = 0;
         }

         var9.drawString(var10, var1 + 420 + 25 + var4 + 16, (var3 >> 2) * 30 + var6 - 4, 0, 0, 1);
      }

      var6 -= 50;
      Ui.i().drawListKY(2, var1 + 200 + 12 + 25, var6, 200 - 50, 3, 30, 10, this.sel, 4, 2);

      for(var3 = 0; var3 < this.gr.about_b.length; ++var3) {
         System.out.println("i   " + var3);
         var9 = Ui.i();
         var10 = this.gr.about_b[var3].toString();
         if (this.sel == var3) {
            var4 = 0;
         } else {
            var4 = 3;
         }

         var9.drawString(var10, var1 + 200 + 15 + 25 + 26, var3 * 40 + var6 - 2, 0, var4, 1);
         if (this.gr.pkey.isSelect(var1 + 200 + 12 + 25, var3 * 40 + var6 - 2, 200 - 50, 40)) {
            System.out.println("asdfasfaf");
            if (this.sel == var3) {
               this.gr.pkey.setKey5();
            } else {
               this.sel = (byte)var3;
            }
         }
      }

      this.gr.showStringM("\u9700\u8981\u7684\u53c2\u52a0\u8d39\uff1a" + this.money[this.lv] + "\u91d1", 320, var2 + var5 - 50, 7, 0);
      this.gr.drawMoney(320, 360, 3, false);
      if (this.state == 0) {
         Ui.i().drawYesNo(true, true);
      }

   }

   private void drawGame(int var1, int var2, int var3, int var4) {
      Ui.i().fillRect(5423359, var1, var2, var3, var4);
      Ui.i().drawFrameOne(this.bsp, 0, var1 + (var3 >> 1), var2 + (var4 >> 1), 0);
      Ui.i().drawString("\u5206\u6570\uff1a" + this.count, (var3 >> 1) + var1 - 25, var2, 24, 3, 1);
      Ui.i().drawString("\u7403\u603b\u6570\uff1a" + this.ballC0, (var3 >> 1) + var1 + 25, var2, 20, 3, 1);
      Ui.i().drawImage(this.img, var1 + var3, var4 - 15, 40);

      byte var7;
      for(var7 = 0; var7 < this.xy.length; ++var7) {
         if (this.xy[var7][5] != -1) {
            this.gr.drawItem(this.gDate[0][this.xy[var7][6] << 1], this.xy[var7][0] + var1, this.xy[var7][1] + var2, 0);
         }
      }

      for(var7 = 0; var7 < 2; ++var7) {
         Ui var5 = Ui.i();
         Sprite var6 = this.sp[0];
         byte var8;
         if (this.myxy[4] == 0) {
            var8 = 3;
         } else {
            var8 = 4;
         }

         var5.drawFrameOne(var6, var8, this.myxy[0] + var1 + var7 * 30 + 20, this.myxy[1] + var2 + 25, 0);
      }

      this.gr.drawMoney(320, 360, 3, false);
   }

   private void getAY(int var1) {
      short[] var2;
      if (this.xy[var1][4] > 0 && this.xy[var1][3] > 1) {
         var2 = this.xy[var1];
         --var2[3];
      } else if (this.xy[var1][4] == 0) {
         this.xy[var1][3] = 0;
      } else if (this.xy[var1][4] < 0 && this.xy[var1][3] > -this.ballDate[this.xy[var1][5]][3]) {
         var2 = this.xy[var1];
         --var2[3];
      }

   }

   private void initABall(boolean var1) {
      short var2;
      if (var1) {
         var2 = 10;
      } else {
         var2 = this.gDate[2][this.lv];
      }

      this.time0 = var2;
      this.time1 = this.ball_time[this.lv];
      Ms.i();
      this.ballC1 = (short)(Ms.getRandom(this.gDate[3][this.lv << 1]) + this.gDate[3][(this.lv << 1) + 1]);
   }

   private boolean isCollision(int var1) {
      return Ms.i().isRect(this.myxy[0], this.myxy[1], this.myxy[2], this.myxy[3], this.xy[var1][0], this.xy[var1][1], 16, 16);
   }

   private boolean isSrc(int var1) {
      boolean var2;
      if (this.xy[var1][1] > 320 + 10) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var3;
      if (!Ms.i().isRect(240 - 10, 320 - 40, 20, 10, this.xy[var1][0], this.xy[var1][1], 16, 16)) {
         var3 = var2;
         if (this.xy[var1][0] <= 240) {
            return var3;
         }

         var3 = var2;
         if (this.xy[var1][1] >= this.myxy[1]) {
            return var3;
         }
      }

      var3 = true;
      this.count += this.gDate[0][this.xy[var1][6] * 2 + 1];
      return var3;
   }

   private void nullGame() {
      this.gDate = null;
      this.money = null;
      this.sp = null;
      this.img = null;
      this.ballDate = null;
   }

   public void go(int var1) {
      if (var1 < 1) {
         this.state = 0;
         this.length = 10;
         this.gr.setStringB("\u5728\u9650\u5b9a\u65f6\u95f4\u91cc\u63a5\u5c3d\u91cf\u591a\u7684\u7403\u5230\u6846\u91cc\uff0c\u6700\u540e\u6839\u636e\u6846\u91cc\u7403\u7684\u5206\u6570\u6765\u6362\u53d6\u91d1\u94b1\u3002", 160, 0);
         this.gr.setStringB("\u5f00\u59cb\u6e38\u620f#n\u79bb\u5f00\u6e38\u620f", Constants_H.WIDTH, 1);
      } else if (var1 == 1) {
         this.state = 1;
         this.count = 0;
         this.cur = 0;
         this.ballC0 = this.gDate[1][this.lv];
         this.initABall(true);

         for(byte var2 = 0; var2 < this.xy.length; ++var2) {
            this.xy[var2][5] = -1;
         }
      }

   }

   public void go(int var1, int var2) {
      this.lv = (byte)var2;
      this.sp = new Sprite[2];
      this.sp[0] = Ms.i().createSprite("data/npc2/38", true);
      this.img = Ms.i().createImage("data/brow/m0");
      byte[] var3 = Ms.i().getStream("data/gamee.data", -1);
      Ms.i();
      Ms.skip = 0;
      this.bsp = Sprite.Create(Ms.i().createImage("data/map/5"), Ms.i().createShort2Array(var3, 2), Ms.i().createShort3Array(var3, 2), Ms.i().createShort3Array(var3, 2));
      this.go(var1);
   }

   public boolean key() {
      boolean var1;
      if (this.state == 0) {
         if (Ms.i().key_Up_Down()) {
            this.sel = (byte)(this.sel ^ 1);
         } else if (Ms.i().key_S1_Num5()) {
            Ms.i().keyRelease();
            if (this.sel == 0 && this.gr.isMoney(this.money[this.lv], true)) {
               this.go(1);
            } else if (this.sel == 1) {
               Ms.i().keyRelease();
               this.nullGame();
               var1 = true;
               return var1;
            }
         } else if (Ms.i().key_S2()) {
            this.nullGame();
            var1 = true;
            return var1;
         }
      } else if (this.state == 1) {
         short[] var2;
         if (Ms.i().key_Left()) {
            var2 = this.myxy;
            var2[0] = (short)(var2[0] - 10);
            if (this.myxy[0] < 0) {
               this.myxy[0] = 0;
            }
         } else if (Ms.i().key_Right()) {
            var2 = this.myxy;
            var2[0] = (short)(var2[0] + 10);
            if (this.myxy[0] + this.myxy[2] > 220) {
               this.myxy[0] = (short)(240 - this.myxy[2] - 20);
            }
         }
      }

      var1 = false;
      return var1;
   }

   public void patin() {
      this.draw0(10, 2, this.length * 25);
      if (this.state != 0) {
         this.drawGame(200, 0, 240, 320);
      }

   }

   public void run() {
      if (this.state == 1) {
         if (this.ballC0 > 0) {
            if (this.time0 > 0) {
               --this.time0;
            } else if (this.time1 > 0) {
               --this.time1;
            } else if (this.ballC1 > 0) {
               this.time1 = this.ball_time[this.lv];
               this.addBall(Ms.getRandom(this.ballDate.length));
               --this.ballC1;
               --this.ballC0;
            } else if (this.ballC1 == 0) {
               this.initABall(false);
            }
         }

         short[] var4;
         if (this.myxy[4] > 0) {
            var4 = this.myxy;
            --var4[4];
         }

         boolean var2 = true;

         for(byte var1 = 0; var1 < this.xy.length; ++var1) {
            if (this.xy[var1][5] != -1) {
               boolean var3 = false;
               var4 = this.xy[var1];
               var4[0] += this.xy[var1][2];
               var4 = this.xy[var1];
               var4[1] -= this.xy[var1][3];
               this.getAY(var1);
               var4 = this.xy[var1];
               --var4[4];
               if (this.isSrc(var1)) {
                  this.xy[var1][5] = -1;
                  var2 = var3;
               } else {
                  var2 = var3;
                  if (this.isCollision(var1)) {
                     this.xy[var1][4] = this.ballDate[this.xy[var1][5]][0];
                     this.myxy[4] = 1;
                     this.xy[var1][3] = this.ballDate[this.xy[var1][5]][3];
                     var2 = var3;
                  }
               }
            }
         }

         if (this.ballC0 < 1 && var2) {
            this.count = (short)(this.count * 15 / 10);
            GameRun var5 = this.gr;
            var5.money += this.count;
            this.gr.say("\u83b7\u5f97\uff1a" + this.count + "\u91d1", 0);
            if (this.count > 0) {
               byte[] var6 = this.gr.rmsOther;
               var6[6] = (byte)(var6[6] | 1 << this.lv);
            }

            this.state = 2;
         }

         this.gr.pkey.checkButton(4);
      } else if (this.state == 2 && this.gr.say_c == 0) {
         this.go(0);
      }

   }

   public void setLv(int var1) {
      this.lv = (byte)var1;
   }
}
