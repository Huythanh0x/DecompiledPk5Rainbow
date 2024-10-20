package minigame;

import dm.Ms;
import dm.Sprite;
import dm.Ui;
import javax.microedition.lcdui.Image;
import main.Constants_H;
import main.GameRun;

public class Guess implements MiniGame_H {
   final short BOX_Y1 = 150;
   final short MON_Y = 165;
   final short TIME = 20;
   final short TIME2 = 40;
   private byte b_win;
   private int[][] box;
   private byte[] boxNum;
   private byte[][] gameData;
   private byte gameR = 0;
   GameRun gr;
   private Image[] imgBox;
   private Sprite[] imgMon;
   private byte length;
   private byte lv;
   private byte maxTransNum = 20;
   private byte mon_size_move = 0;
   byte sel;
   private int sell_money;
   private byte state = 0;
   private byte tempTransNum = 0;
   private byte time;
   private byte transNum = 0;
   private byte winNum = 0;

   public Guess(GameRun var1) {
      super();
      this.gr = var1;
   }

   private void draw() {
      if (this.state == 0) {
         Ui.i().drawString("\u6e38\u620f\u89c4\u5219", 320, 4, 17, 3, 1);
         Ui.i().drawUi(7, 320 - 75, 27, 40, 0);
         Ui.i().drawUi(7, 320 + 75, 27, 36, 4);
      }

      int var1 = 29 * 10;
      Ui.i().drawK(10, 25 + 10, 200, var1, 4);
      Ui.i().drawK(10 + 200 + 10, 25 + 10, 200, var1, 4);
      Ui.i().drawK(10 + 420, 25 + 10, 200, var1, 4);
      Ui.i().drawStringY(this.gr.about_a, 10 + 6, 25 + 10, 29, 0, 0);
      if (this.state == 0) {
         this.gr.showStringM("\u9700\u8981\u7684\u53c2\u52a0\u8d39\uff1a" + this.sell_money + "\u91d1", 320, 25 + 290 - 50, 7, 0);
         Ui.i().drawListKY(2, 10 + 200 + 12 + 25, 25 + 75 + 5, 200 - 50, 3, 30, 10, this.sel, 4, 2);

         for(var1 = 0; var1 < this.gr.about_b.length; ++var1) {
            Ui var4 = Ui.i();
            String var3 = this.gr.about_b[var1].toString();
            byte var2;
            if (this.sel == var1) {
               var2 = 0;
            } else {
               var2 = 3;
            }

            var4.drawString(var3, 10 + 200 + 15 + 25 + 26, var1 * 40 + 105 - 2, 0, var2, 1);
            if (this.gr.pkey.isSelect(10 + 200 + 12 + 25, var1 * 40 + 105 - 2, 200 - 50, 40)) {
               if (this.sel == var1) {
                  this.gr.pkey.setKey5();
               } else {
                  this.sel = (byte)var1;
               }
            }
         }
      }

      if (this.state == 0) {
         Ui.i().drawYesNo(true, true);
      }

      this.gr.drawMoney(320, 360, 3, false);
   }

   private void drawGame() {
      Ui.i().drawString("\u80dc\u5229\u6b21\u6570\uff1a" + this.winNum + "/" + this.gameData[3][this.lv], 320, 4, 17, 3, 1);
      int var2;
      int var3;
      int var4;
      if (this.state == 1) {
         Ui.g.setClip(202, 65, 240, 100);

         for(var2 = 0; var2 < this.box.length; ++var2) {
            if (this.box[var2][1] != -1) {
               int var5 = this.box[var2][1];
               var4 = this.box[var2][2];
               if (this.time < 40) {
                  var3 = 0;
               } else {
                  var3 = this.mon_size_move;
               }

               this.drawMon(var2, var5, var4 + 202, var3 + 165);
            }
         }

         Ui.g.setClip(0, 0, 640, 360);
         if (this.time >= 20) {
            for(var2 = 0; var2 < this.box.length; ++var2) {
               Ui.i().drawImage(this.imgBox[1], this.box[var2][2] + 202, this.box[var2][3], 17);
            }
         }
      } else if (this.state == 2) {
         for(var2 = 0; var2 < this.box.length; ++var2) {
            Ui.i().drawImage(this.imgBox[1], this.box[var2][2] + 202, this.box[var2][3], 17);
         }
      } else if (this.state == 3) {
         for(var2 = 0; var2 < this.box.length; ++var2) {
            if (this.gr.pkey.isSelect(this.box[var2][2] + 202 - 20, this.box[var2][3], 40, 40)) {
               this.gr.selectx = (byte)var2;
               this.gr.pkey.setKey5();
            }

            Ui.i().drawImage(this.imgBox[1], this.box[var2][2] + 202, this.box[var2][3], 17);
         }

         Ui var6 = Ui.i();
         Image var7 = this.imgBox[0];
         var3 = this.box[this.gr.selectx][2];
         var4 = this.box[this.gr.selectx][3];
         byte var8;
         if (this.time % 4 <= 2) {
            var8 = 5;
         } else {
            var8 = 0;
         }

         var6.drawImage(var7, var3 + 202 - 1, var4 - var8, 17);
         byte var1 = (byte)(this.time + 1);
         this.time = var1;
         if (var1 > 20) {
            this.time = 0;
         }

         this.drawMon(this.box[this.gr.selecty][0], this.box[this.gr.selecty][1], this.gameData[0][1] + 202 + 100, 135);
         this.gr.showStringM("\u8bf7\u6307\u51fa" + this.gr.getNameMon(this.box[this.gr.selecty][1]) + "\u6240\u5728\u7bb1\u5b50", 202 + 240 + 90, 29 * 5, 6, 0);
      } else if (this.state == 4) {
         this.drawMon(this.box[this.gr.selecty][0], this.box[this.gr.selecty][1], this.gameData[0][1] + 202 + 100, 135);
         Ui.i().drawImage(this.imgBox[1], this.box[this.gr.selectx][2] + 202, this.box[this.gr.selectx][3], 17);
         if (this.box[this.gr.selectx][1] != -1) {
            this.drawMon(this.box[this.gr.selectx][0], this.box[this.gr.selectx][1], this.box[this.gr.selectx][2] + 202, this.box[this.gr.selectx][3] + 35);
         }

         if (this.b_win > 0) {
            this.gr.showStringM("\u60a8\u771f\u5389\u5bb3\uff01", 202 + 240 + 90, 29 * 5, 6, 0);
         } else {
            this.gr.showStringM("\u8bf4\u4e0d\u5b9a\u4e0b\u6b21\u5c31\u80fd\u884c\u7684\u3002", 202 + 240 + 90, 29 * 5, 6, 0);
         }

         this.gr.showStringM("\u70b9\u51fb\u5c4f\u5e55\u7ee7\u7eed", 202 + 240 + 90, 29 * 7, 6, 0);
         if (this.gr.pkey.isSelect(0, 0, 640, 360)) {
            this.gr.pkey.setKey5();
         }
      }

   }

   private void drawMon(int var1, int var2, int var3, int var4) {
      Ui.i().drawFrameOne(this.imgMon[var1], this.imgMon[var1].action(this.gr.mList_id[var2][1] * 3, 0, 0), var3, var4, 0);
   }

   private byte[] getGameMonList() {
      byte[] var4 = new byte[3];

      byte var2;
      for(var2 = 0; var2 < var4.length; ++var2) {
         var4[var2] = -1;
      }

      byte var3;
      for(var3 = 0; var3 < this.gameData[2][this.lv]; ++var3) {
         byte[] var5 = this.gameData[4];
         Ms.i();
         var4[var3] = var5[Ms.getRandom(this.gameData[4].length)];
         var2 = 0;

         while(var2 < var3) {
            if (var4[var2] == var4[var3]) {
               var5 = this.gameData[4];
               Ms.i();
               var4[var3] = var5[Ms.getRandom(this.gameData[4].length)];
               var2 = 0;
            } else {
               ++var2;
            }
         }
      }

      Ms.i();
      var2 = (byte)Ms.getRandom(2);
      byte var1 = var4[var4.length - 1];
      var4[var4.length - 1] = var4[var2];
      var4[var2] = var1;

      for(var2 = 0; var2 < 3; ++var2) {
         if (var4[var2] != -1) {
            var3 = this.gr.mList_id[var4[var2]][0];
            this.imgMon[var2] = Ms.i().createSprite("data/npc2/" + var3, this.gr.isNpc2ImageType(var3));
         }
      }

      return var4;
   }

   private void initGame() {
      byte[] var2 = this.getGameMonList();

      for(byte var1 = 0; var1 < 3; ++var1) {
         this.box[var1][0] = var1;
         this.box[var1][1] = var2[var1];
         this.box[var1][2] = this.gameData[0][var1] + 100;
         this.box[var1][3] = 0;
      }

      var2 = (byte[])null;
      Ms.i();
      this.maxTransNum = (byte)(Ms.getRandom(this.lv + 2) + 2 + this.lv);
      this.transNum = 0;
      this.mon_size_move = 0;
   }

   private byte win() {
      byte var1 = (byte)(this.winNum + 1);
      this.winNum = var1;
      if (var1 >= this.gameData[3][this.lv]) {
         int var2 = this.sell_money + this.lv * this.lv * 150 + (2 - this.lv) * 25;
         GameRun var3 = this.gr;
         var3.money += var2;
         this.gr.say("\u83b7\u5f97\u91d1\u94b1\uff1a" + var2, 0);
         byte[] var4 = this.gr.rmsOther;
         var4[10] = (byte)(var4[10] | 1 << this.lv);
         if (this.lv == 2 && this.gr.rmsOther[11] < 3) {
            var4 = this.gr.rmsOther;
            ++var4[11];
         }

         var1 = 2;
      } else {
         var1 = 3;
      }

      return var1;
   }

   public void go(int var1) {
      if (var1 < 1) {
         this.b_win = 0;
         this.gr.selecty = 0;
         this.gr.selectx = 0;
         this.winNum = 0;
         this.state = 0;
         this.gr.buyOk = 0;
         this.gr.line_max = 9;
         this.sell_money = this.lv * 200 + 200;
         this.length = (byte)(this.gr.about_a.length - this.gr.line_max);
      } else {
         this.time = 0;
         this.state = 1;
         this.initGame();
      }

   }

   public void go(int var1, int var2) {
      this.gr.setStringB(this.gr.createString("data/gamed.d"), 180, 0);
      this.gr.setStringB("\u5f00\u59cb\u6e38\u620f#n\u79bb\u5f00\u6e38\u620f", Constants_H.WIDTH, 1);
      this.lv = (byte)var2;
      this.imgBox = new Image[2];
      this.imgBox[0] = Ms.i().createImage("data/brow/m2");
      this.imgBox[1] = Ms.i().createImage("data/brow/m3");
      this.boxNum = new byte[2];
      this.gameData = new byte[][]{{-60, 17, 90}, {8, 13, 20, 30}, {1, 2, 3, 3}, {6, 4, 2, 2}, {83, 30, 55}};
      this.box = new int[3][4];
      this.imgMon = new Sprite[3];
      this.go(var1);
   }

   public boolean key() {
      boolean var2;
      if (Ms.i().key_delay()) {
         var2 = false;
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
                  this.gr.about_a = null;
                  this.imgBox = null;
                  this.boxNum = null;
                  this.gameData = null;
                  this.box = null;
                  this.imgMon = null;
                  var2 = true;
                  return var2;
               }
            } else if (Ms.i().key_S2()) {
               Ms.i().keyRelease();
               this.gr.about_a = null;
               this.imgBox = null;
               this.boxNum = null;
               this.gameData = null;
               this.box = null;
               this.imgMon = null;
               var2 = true;
               return var2;
            }
         } else if (this.state == 3) {
            if (Ms.i().key_Left_Right()) {
               this.gr.selectx = Ms.i().select(this.gr.selectx, 0, this.box.length - 1);
            } else if (Ms.i().key_S1_Num5()) {
               Ms.i().keyRelease();
               this.state = 4;
               byte var1;
               if (this.gr.selectx == this.gr.selecty) {
                  var1 = 1;
               } else {
                  var1 = -1;
               }

               this.b_win = (byte)var1;
            }
         } else if (this.state == 4 && Ms.i().key_S1_Num5()) {
            Ms.i().keyRelease();
            if (this.b_win == 1) {
               this.b_win = this.win();
               if (this.b_win == 3) {
                  this.go(1, this.lv);
               }
            } else if (this.b_win == -1 || this.b_win == 2 && this.gr.say_c == 0) {
               if (this.b_win == 2 && this.gr.rmsOther[11] == 3) {
                  this.gr.rmsOther[11] = 4;
                  this.gr.getMonster(83, 25, 0, -1);
               } else if (this.b_win == -1 && this.gr.rmsOther[11] < 3) {
                  this.gr.rmsOther[11] = 0;
               }

               this.go(0, this.lv);
            }
         }

         var2 = false;
      }

      return var2;
   }

   public void patin() {
      Ui.i().fillRectB();
      this.draw();
      if (this.state != 0) {
         this.drawGame();
      }

   }

   public void run() {
      int var2;
      int[] var4;
      if (this.state == 1) {
         if (this.time < 20) {
            ++this.time;
         } else if (this.box[0][3] < 150) {
            for(var2 = 0; var2 < 3; var2 = (byte)(var2 + 1)) {
               var4 = this.box[var2];
               var4[3] += 25;
            }
         } else {
            byte var1 = (byte)(this.time + 1);
            this.time = var1;
            if (var1 >= 40) {
               if (this.mon_size_move < 40) {
                  this.mon_size_move = (byte)(this.mon_size_move + 5);
               } else {
                  this.state = 2;
                  this.time = 0;
               }
            }
         }
      } else if (this.state == 2) {
         if (this.time <= 0) {
            if (this.transNum < this.maxTransNum) {
               this.time = 1;
               ++this.transNum;
               byte[] var5 = this.boxNum;
               Ms.i();
               var5[0] = (byte)Ms.getRandom(3);

               do {
                  var5 = this.boxNum;
                  Ms.i();
                  var5[1] = (byte)Ms.getRandom(3);
               } while(this.boxNum[1] == this.boxNum[0]);

               if (this.box[this.boxNum[1]][2] < this.box[this.boxNum[0]][2]) {
                  this.gameR = this.boxNum[1];
                  this.boxNum[1] = this.boxNum[0];
                  this.boxNum[0] = this.gameR;
               }

               Ms.i();
               this.gameR = (byte)(Ms.abs(this.box[this.boxNum[1]][2] - this.box[this.boxNum[0]][2]) / 2);
               this.tempTransNum = (byte)(this.gameR * 2 / this.gameData[1][this.lv]);
            } else {
               this.time = 0;
               this.state = 3;

               do {
                  GameRun var6 = this.gr;
                  Ms.i();
                  var6.selecty = (byte)Ms.getRandom(this.box.length);
               } while(this.box[this.gr.selecty][1] == -1);
            }
         } else if (this.time > this.tempTransNum) {
            this.time = 0;
            var4 = new int[4];

            for(var2 = 0; var2 < this.box.length; var2 = (byte)(var2 + 1)) {
               for(byte var3 = 0; var3 < this.box.length; ++var3) {
                  if (this.box[var3][2] > this.box[var2][2]) {
                     System.arraycopy(this.box[var2], 0, var4, 0, var4.length);
                     System.arraycopy(this.box[var3], 0, this.box[var2], 0, this.box[var3].length);
                     System.arraycopy(var4, 0, this.box[var3], 0, var4.length);
                  }
               }
            }

            for(var2 = 0; var2 < 3; var2 = (byte)(var2 + 1)) {
               this.box[var2][2] = this.gameData[0][var2] + 100;
               this.box[var2][3] = 150;
            }
         } else {
            ++this.time;
            var4 = this.box[this.boxNum[0]];
            var4[2] += this.gameR * 2 / this.tempTransNum;
            var2 = this.gameR * 2 / this.tempTransNum * this.time;
            this.box[this.boxNum[0]][3] = 150 - Ms.i().sqrt(this.gameR * this.gameR - (var2 - this.gameR) * (var2 - this.gameR));
            var4 = this.box[this.boxNum[1]];
            var4[2] -= this.gameR * 2 / this.tempTransNum;
            this.box[this.boxNum[1]][3] = Ms.i().sqrt(this.gameR * this.gameR - (var2 - this.gameR) * (var2 - this.gameR)) + 150;
         }
      } else if (this.state == 4 && (this.gr.selectx == 2 && this.box[this.gr.selectx][2] > this.gameData[0][1] + 100 || this.gr.selectx == 0 && this.box[this.gr.selectx][2] < this.gameData[0][1] + 100)) {
         var4 = this.box[this.gr.selectx];
         var4[2] += (this.gameData[0][1] - this.gameData[0][this.gr.selectx]) / 7;
      }

   }
}
