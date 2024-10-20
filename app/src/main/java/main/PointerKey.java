package main;

import android.util.Log;
import dm.Ms;

public class PointerKey implements Key_H {
   public int[][][] button_pos;
   boolean dir;
   int gox;
   int goy;
   GameRun gr;
   int i0;
   int i1;
   boolean isGo;
   int m0;
   int m1;
   Map map;
   MainCanvas mc;
   int tempx;
   int tempy;

   public PointerKey(MainCanvas var1) {
      super();
      int[] var14 = new int[]{0, Constants_H.HEIGHT - 50, 50, 50, -6};
      int[][] var26 = new int[][]{var14, {Constants_H.WIDTH - 50, Constants_H.HEIGHT - 50, 50, 50, -7}};
      int[] var15 = new int[]{0, 0, Constants_H.WIDTH, Constants_H.HEIGHT, 48};
      int[][] var16 = new int[][]{var15};
      var15 = new int[]{0, 0, Constants_H.WIDTH, Constants_H.HEIGHT, 53};
      int[][] var18 = new int[][]{{170, 275, 106, 97, -3}, {363, 285, 108, 83, -4}, {281, 290, 76, 88, 53}};
      int[] var19 = new int[]{0, 0, 320, 360, -3};
      int[] var17 = new int[]{320, 0, 320, 360, -4};
      int[] var20 = new int[]{462, 42, 83, 72, 9999};
      int[] var21 = new int[]{466, 182, 85, 75, 9999};
      int[] var22 = new int[]{524, 266, 91, 68, 9999};
      int[][] var27 = new int[][]{var20, {548, 116, 83, 71, 9999}, var21, var22, {48, 277, 87, 80, 9999}};
      var21 = new int[]{Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60, 60, 60, 9999};
      int[] var23 = new int[]{0, Constants_H.HEIGHT__ - 60, 60, 60, 9999};
      int[] var24 = new int[]{Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60 - 120 - 40, 60, 60, 9999};
      int var3 = Constants_H.WIDTH__;
      int var2 = Constants_H.HEIGHT__;
      int var5 = Constants_H.WIDTH__;
      int var7 = Constants_H.HEIGHT__;
      int var4 = Constants_H.WIDTH__;
      int var6 = Constants_H.HEIGHT__;
      var22 = new int[]{Constants_H.WIDTH__ - 60, Constants_H.HEIGHT__ - 60 - 180 - 60, 60, 60, 9999};
      int[][] var29 = new int[][]{var21, var23, var24, {var3 - 60, var2 - 60 - 60 - 20, 60, 60, 9999}, {var5 - 60 - 120 - 40, var7 - 60, 60, 60, 9999}, {var4 - 60 - 60 - 20, var6 - 60, 60, 60, 9999}, var22};
      int[][] var28 = new int[][]{{Constants_H.WIDTH - 50, Constants_H.HEIGHT - 50, 50, 50, -7}};
      var23 = new int[]{0, 310, 50, 50, -6};
      int[][] var30 = new int[][]{var23, {590, 310, 50, 50, -7}};
      var24 = new int[]{0, 0, 640, 360, 48};
      int[][] var31 = new int[][]{var24};
      var4 = Constants_H.WIDTH;
      int var9 = Constants_H.HEIGHT;
      int[] var25 = new int[]{0, Constants_H.HEIGHT - 30, 30, 30, 9999};
      var2 = Constants_H.WIDTH;
      int var10 = Constants_H.HEIGHT;
      var5 = Constants_H.WIDTH;
      int var12 = Constants_H.HEIGHT;
      int var13 = Constants_H.WIDTH;
      int var8 = Constants_H.HEIGHT;
      var3 = Constants_H.WIDTH;
      int var11 = Constants_H.HEIGHT;
      var6 = Constants_H.WIDTH;
      var7 = Constants_H.HEIGHT;
      int[][] var32 = new int[][]{{var4 - 30, var9 - 30, 30, 30, 9999}, var25, {var2 - 30, var10 - 30 - 90 - 25, 30, 30, 9999}, {var5 - 30, var12 - 30 - 45 - 15, 30, 30, 9999}, {var13 - 30 - 90 - 40, var8 - 30, 30, 30, 9999}, {var3 - 30 - 45 - 20, var11 - 30, 30, 30, 9999}, {var6 - 30, var7 - 30 - 135 - 35, 30, 30, 9999}};
      this.button_pos = new int[][][]{var26, var16, {var15}, var18, {var19, var17}, var27, var29, var28, var30, var31, var32};
      this.i0 = -1;
      this.i1 = -1;
      this.mc = var1;
      this.gr = this.mc.gr;
      this.map = this.gr.map;
   }

   private boolean isMove(int var1, int var2) {
      int var3;
      int var4;
      if (this.map.my.dir == 3) {
         var3 = this.map.my.x - 20;
         var4 = this.map.my.y - 60;
      } else if (this.map.my.dir == 4) {
         var3 = this.map.my.x + 20;
         var4 = this.map.my.y - 60;
      } else if (this.map.my.dir == 1) {
         var3 = this.map.my.x;
         var4 = this.map.my.y - 80;
      } else {
         var3 = this.map.my.x;
         var4 = this.map.my.y - 40;
      }

      boolean var5;
      if ((Ms.i().isRect(var1, var2, 1, 1, var3, var4, 20, 80) || Ms.i().isRect(this.i0, this.i1, 1, 1, Constants_H.WIDTH_H - 30, Constants_H.HEIGHT - 60, 60, 60)) && this.map.checkSoftKey(this.map.my.x, this.map.my.y, this.map.dir_select[this.map.my.dir][0] * this.map.my.speed, this.map.dir_select[this.map.my.dir][1] * this.map.my.speed) != -1) {
         var5 = false;
      } else {
         var5 = true;
      }

      return var5;
   }

   public int checkButton(int var1) {
      return this.checkButton(var1, this.i0, this.i1);
   }

   public int checkButton(int var1, int var2, int var3) {
      int var4 = 0;

      while(true) {
         if (var4 >= this.button_pos[var1].length) {
            var4 = -1;
            break;
         }

         if (Ms.i().isRect(var2 - 1, var3 - 1, 2, 2, this.button_pos[var1][var4][0], this.button_pos[var1][var4][1], this.button_pos[var1][var4][2], this.button_pos[var1][var4][3])) {
            Ms.key = this.button_pos[var1][var4][4];
            if (var1 == 3 && Ms.key == 53) {
               Log.e("touch", "\u6309\u4e0b\u786e\u5b9a\u952e\u3002\u3002\u3002menu_state: " + this.mc.menu_state);
            }

            Ms.keyRepeat = true;
            this.initPointer();
            break;
         }

         ++var4;
      }

      return var4;
   }

   public void initPointer() {
      this.i1 = -1;
      this.i0 = -1;
      this.m1 = -1;
      this.m0 = -1;
   }

   public boolean isSelect(int var1, int var2, int var3, int var4) {
      boolean var5;
      if (Ms.i().isRect(this.i0, this.i1, 1, 1, var1, var2, var3, var4)) {
         this.initPointer();
         var5 = true;
      } else {
         var5 = false;
      }

      return var5;
   }

   public void process(int var1, int var2) {
      if (this.map.my.state != 20 || this.checkButton(7, var1, var2) == -1) {
         if (GameRun.run_state != -10 || this.map.my.state != 0 && this.map.my.state != 20) {
            if (GameRun.run_state == -10) {
               if ((this.map.my.state == 18 || this.map.my.state == 17) && this.checkButton(8, var1, var2) != -1 || this.map.my.state != 18 && this.map.my.state != 17 && this.checkButton(0, var1, var2) != -1) {
                  return;
               }
            } else if (GameRun.run_state != -10 && this.checkButton(8, var1, var2) != -1) {
               return;
            }
         }

         switch (this.mc.game_state) {
            case 30:
               this.runKeySate(var1, var2);
               break;
            case 40:
               switch (this.mc.menu_state) {
                  case 0:
                     if (this.mc.load_c == 1) {
                        this.i0 = var1;
                        this.i1 = var2;
                        this.checkButton(3, var1, var2);
                     } else {
                        this.checkButton(9, var1, var2);
                     }

                     return;
                  default:
                     return;
               }
            case 98:
               this.checkButton(9, var1, var2);
               Log.d("soars", "checkButton");
         }
      }

   }

   public void runKeySate(int var1, int var2) {
      switch (GameRun.run_state) {
         case -31:
            if (this.gr.battle_state == 2) {
               this.gr.cur_a = (byte)this.checkButton(5, var1, var2);
               if (this.gr.cur_a != -1) {
                  this.setKey5();
               }
            } else {
               this.i0 = var1;
               this.i1 = var2;
            }
            break;
         case -20:
         case 18:
         case 25:
         case 35:
         case 61:
         case 65:
         case 66:
         case 68:
         case 97:
            this.i0 = var1;
            this.i1 = var2;
            break;
         case -10:
            this.i0 = var1;
            this.i1 = var2;
            if (this.map.my.state == 22) {
               if (this.gr.say_c < 0) {
                  this.checkButton(2, var1, var2);
               } else {
                  this.checkButton(1, var1, var2);
               }
            } else if (this.map.my.state != 1 && this.map.my.state != 10) {
               if (this.map.my.state == 0) {
                  if (this.gr.say_c == -1) {
                     this.checkButton(2, var1, var2);
                  } else if (this.gr.say_s == 0 && this.gr.say_c == 0 && this.isMove(-this.map.map_x + var1, -this.map.map_y + var2)) {
                     this.setMove(var1, var2);
                  }

                  this.i0 = var1;
                  this.i1 = var2;
               } else if (this.map.my.state == 12 || this.map.my.state == 18 || this.map.my.state == 17 || this.map.my.state == 16 || this.map.my.state == 20 || this.map.my.state == 2) {
                  this.i0 = var1;
                  this.i1 = var2;
               }
            } else {
               this.checkButton(2, var1, var2);
            }
            break;
         case 60:
         case 98:
            this.checkButton(1, var1, var2);
            break;
         case 69:
            this.i0 = var1;
            this.i1 = var2;
      }

   }

   public void runMove() {
      if (GameRun.run_state == -10 && this.map.my.state == 0 && this.m0 != -1) {
         int var3 = this.m0 - this.map.my.x;
         int var2 = this.m1 - this.map.my.y;
         if (Ms.abs(var3) < this.map.my.speed && Ms.abs(var2) < this.map.my.speed) {
            this.stopMove();
         } else {
            boolean var1;
            if (this.dir) {
               if (Ms.abs(var2) < this.map.my.speed) {
                  var1 = true;
               } else {
                  var1 = false;
               }
            } else if (Ms.abs(var3) >= this.map.my.speed) {
               var1 = true;
            } else {
               var1 = false;
            }

            byte var4;
            if (var1) {
               if (var3 < 0) {
                  var4 = -3;
               } else {
                  var4 = -4;
               }

               Ms.key = var4;
            } else {
               if (var2 < 0) {
                  var4 = -1;
               } else {
                  var4 = -2;
               }

               Ms.key = var4;
            }

            this.map.map_key = (byte)(-Ms.key);
            this.map.doKey();
         }
      }

   }

   public void selectListSY(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      for(var5 = 0; var5 < var1; ++var5) {
         if (Ms.i().isRect(this.i0, this.i1, 1, 1, var2, var3 + (var6 + var7) * var5, var4, var6)) {
            this.gr.selecty = (byte)var5;
            if (var5 == var8) {
               this.setKey5();
            }

            this.initPointer();
         }
      }

   }

   public byte selectMenuX(int var1, int var2, int var3, int var4, int var5) {
      int var7 = 0;

      byte var6;
      while(true) {
         if (var7 >= var1) {
            var6 = -1;
            break;
         }

         if (Ms.i().isRect(this.i0, this.i1, 1, 1, var2 + var7 * var4, var3, var4, var5)) {
            this.initPointer();
            var6 = (byte)var7;
            break;
         }

         ++var7;
      }

      return var6;
   }

   public void setKey5() {
      Ms.key = 53;
      Ms.keyRepeat = true;
   }

   public void setKeySoftkey1() {
      Ms.key = -6;
      Ms.keyRepeat = true;
   }

   public void setMove(int var1, int var2) {
      this.m0 = (-this.map.map_x + var1) / 20 * 20;
      this.m1 = (-this.map.map_y + var2) / 20 * 20;
      boolean var3;
      if (Ms.abs(this.m0 - this.map.my.x) < Ms.abs(this.m1 - this.map.my.y)) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.dir = var3;
      this.isGo = true;
      this.tempx = var1;
      this.tempy = var2;
      this.gox = -this.map.map_x + this.tempx;
      this.goy = -this.map.map_y + this.tempy;
   }

   public void stopMove() {
      Ms.i().keyRelease();
      this.initPointer();
      this.isGo = false;
   }
}
