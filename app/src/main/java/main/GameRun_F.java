package main;

import android.util.Log;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import dm.Monster;
import dm.Ms;
import dm.Sound;
import dm.Ui;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class GameRun_F implements Key_H {
   static DirectGraphics dg;
   static Graphics g;
   public static MainCanvas mc;
   static Graphics offG;
   public static int run_state = 1;
   static Image scrT;
   public StringBuffer[] about_a;
   public StringBuffer[] about_b;
   public StringBuffer[] about_c;
   public StringBuffer[] about_d;
   public String[] action_str;
   final byte[] anchor = new byte[]{20, 36, 40, 24, 24, 40, 36, 20};
   private byte brow5;
   public byte cMon_count;
   public Monster[] cMonsters;
   public byte cur_a;
   public byte cur_b;
   public byte cur_c;
   public Monster cur_emon;
   public Monster cur_mon;
   public String gogoST;
   public String gogoString;
   public byte help_page;
   public byte[] info;
   public int introT;
   public int introX;
   public byte[][][] items;
   public byte[] itemsLength;
   public byte[] len;
   public Map map;
   public byte max_monsters;
   public byte max_takes;
   public byte[] monInfoList;
   public short move_x;
   public short move_y;
   public byte myMon_length;
   public Monster[] myMonsters;
   public byte[][] nidusList;
   public byte[] nidusMap;
   public byte page_max;
   public PointerKey pkey;
   public byte popMenu;
   public byte[] rmsNidus;
   public byte[] rmsOther;
   public byte[] rmsSms;
   public byte[][] select;
   public byte[][] selectBag;
   public byte[] select_it;
   public byte[] select_st;
   public byte selectx;
   public byte selecty;
   public StringBuffer[] showS;
   public byte[] src_c;
   public String str_cur;
   final short[] transB;

   public GameRun_F() {
      super();
      short[] var1 = new short[]{0, 90, 180, 270, 8192, 8282, 8372, 8462};
      this.transB = var1;
      this.introX = Constants_H.WIDTH_H;
      this.gogoString = "";
      this.introT = 640;
      this.gogoST = "";
      this.brow5 = 0;
      this.page_max = 0;
      this.help_page = 0;
      this.src_c = new byte[4];
      this.popMenu = -1;
      this.select_it = new byte[4];
      this.select_st = new byte[4];
      this.selectBag = new byte[4][2];
      this.select = new byte[2][2];
      this.max_takes = 3;
      this.max_monsters = 10;
   }

   private void drawSnare5(int var1, int var2) {
      Ui var4 = Ui.i();
      byte var3;
      if (this.brow5 % 3 == 0) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var4.drawUi(8, var1, var2 + var3, 0, 0);
      byte var5 = this.brow5;
      this.brow5 = (byte)(var5 + 1);
      if (var5 > 100) {
         this.brow5 = 0;
      }

   }

   public boolean addNidus(int var1) {
      byte var2 = 0;

      boolean var3;
      while(true) {
         if (var2 >= this.rmsNidus.length) {
            var3 = false;
            break;
         }

         if (this.rmsNidus[var2] == -2) {
            this.rmsNidus[var2] = (byte)var1;
            Ms.i().putShort(0, this.rmsNidus, var2 + 1);
            Ms.i().putShort(200, this.rmsNidus, var2 + 3);
            var3 = true;
            break;
         }

         var2 = (byte)(var2 + 5);
      }

      return var3;
   }

   public byte[] createData(int var1) {
      return Ms.i().getStream("4", var1);
   }

   public String createString(String var1) {
      Ms.i();
      Ms.skip = 0;
      return Ms.i().createStringArray(Ms.i().getStream(var1, -1))[0].toString();
   }

   public void delNidus(int var1) {
      this.rmsNidus[var1 * 5] = -2;
   }

   public void drawHelpStr(Graphics var1, StringBuffer[] var2, int var3, int var4, int var5, int var6) {
      byte var8 = (byte)(this.help_page * var3);

      for(byte var7 = var8; var7 < var8 + var3 && var7 < var2.length; ++var7) {
         Ui.i().drawString(var2[var7].toString(), var4, var5 + (var7 - var8) * 27, var6, 3, 0);
      }

      if (var2.length > var3) {
         var4 = var2.length / var3;
         byte var9;
         if (var2.length % var3 != 0) {
            var9 = 1;
         } else {
            var9 = 0;
         }

         this.page_max = (byte)(var4 + var9);
         Ui.i().drawString(this.help_page + 1 + "/" + this.page_max, Constants_H.WIDTH_H, Constants_H.HEIGHT - 2, 1 | 32, 3, 0);
         Ui.i().drawTriangle(Constants_H.WIDTH_H, Constants_H.HEIGHT - 12, 75, true, true);
      } else {
         this.page_max = 1;
      }

   }

   public void drawMenu(StringBuffer[] var1, int var2, int var3, int var4) {
      int var5;
      if (var4 > 0) {
         Ui.i().drawKuang(var2, var3, var4, var1.length * 27 + 12);
         var5 = var4;
      } else {
         Ms.i();
         var5 = Ms.abs(var4);
      }

      for(byte var6 = 0; var6 < var1.length; ++var6) {
         byte var7;
         if (var6 == 0) {
            var7 = 9;
         } else if (var6 == this.cur_a) {
            var7 = 8;
         } else {
            var7 = 0;
         }

         Ui.i().drawString(var1[var6].toString(), (var5 >> 1) + var2, var3 + 4 + var6 * 27, 1 | 16, var7, 0);
      }

   }

   public void drawPauseMenu(int var1, int var2, int var3, int var4) {
      Ui.i().drawK2(var1, var2, var3, var4, 1);
      Ui.i().drawK1(var1 + 9, var2 + 25 + 11, var3 - 18, var4 - 25 - 19, 0);
      Ui.i().drawListKY(6, var1 + 8, var2 + 25 + 13, var3 - 16, 1, 33, -1, this.selecty, 4, 2);
      this.pkey.selectListSY(this.action_str.length, var1 + 8, var2 + 25 + 13, var3 - 16, 1, 33, -1, this.selecty);
      byte var5 = this.pkey.selectMenuX(2, var1, var2 + 3, var3 >> 1, 38);
      if (var5 != -1) {
         this.selectx = var5;
         this.selecty = 0;
         this.setPauseS(this.selectx);
      }

      Ui var7;
      byte var8;
      if (this.selectx == 1) {
         var7 = Ui.i();
         var8 = Sound.i().getVolume();
         boolean var6;
         if (this.selecty == 1) {
            var6 = true;
         } else {
            var6 = false;
         }

         var7.drawVolume((var3 >> 1) + var1 + 25 - 8 - 60, var2 + 25 + 16 + 33, var8, var6);
         Ui.i().drawListSYHasSound(this.action_str, var1 + 8, var2 + 25 + 13, var3 - 16, 32, this.selecty, 0, 3, 0);
      } else {
         Ui.i().drawListSY(this.action_str, var1 + 8, var2 + 25 + 13, var3 - 16, 32, this.selecty, 0, 3, 0);
      }

      var7 = Ui.i();
      if (this.selectx == 0) {
         var8 = -60;
      } else {
         var8 = 2;
      }

      var7.drawK1((var3 >> 1) + var1 + var8, var2 + 4, 56, 29, 4);
      var7 = Ui.i();
      if (this.selectx == 0) {
         var8 = 0;
      } else {
         var8 = 1;
      }

      var7.drawString("\u83dc\u5355", (var3 >> 1) + var1 - 25 - 3, var2 + 3, 1 | 16, var8, 0);
      var7 = Ui.i();
      if (this.selectx == 0) {
         var8 = 1;
      } else {
         var8 = 0;
      }

      var7.drawString("\u7cfb\u7edf", (var3 >> 1) + var1 + 25 + 3, var2 + 3, 1 | 16, var8, 0);
      Ui.i().drawTriangle((var3 >> 1) + var1, var2 + 12, 80, true, true);
   }

   public void drawSelectMenu(Object[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(byte var8 = 0; var8 < var1.length; ++var8) {
         Ui var10 = Ui.i();
         int var9;
         if (var8 == var7) {
            var9 = 1;
         } else {
            var9 = var6;
         }

         var10.drawK0(var2, var3 + (var5 + 33) * var8, var4, 33, var9);
         Ui var11 = Ui.i();
         String var13 = var1[var8].toString();
         byte var12;
         if (var8 == var7) {
            var12 = 0;
         } else {
            var12 = 3;
         }

         var11.drawString(var13, (var4 >> 1) + var2, var3 + 2 + (var5 + 33) * var8, 1 | 16, var12, 1);
         Log.e("sk", "drawSelectMenu");
         if (this.pkey.isSelect(var2, (var5 + 33) * var8 + var3, var4, 33)) {
            if (this.map.my.state == 12) {
               if (var8 == var7) {
                  this.map.my.state = 13;
               } else {
                  this.cur_a = var8;
               }
            } else if (run_state == 35 || run_state == 25 || this.map.my.state == 16 || run_state == 65 || run_state == 66 || run_state == 61) {
               if (var8 == var7) {
                  this.pkey.setKey5();
               } else {
                  this.popMenu = var8;
               }
            }
         }
      }

   }

   public void drawSelectMenu_(Object[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(byte var8 = 0; var8 < var1.length; ++var8) {
         Ui var10 = Ui.i();
         int var9;
         if (var8 == var7) {
            var9 = 1;
         } else {
            var9 = var6;
         }

         var10.drawK0(var2, var3 + (var5 + 33) * var8, var4, 25 + 8, var9);
         var10 = Ui.i();
         String var11 = var1[var8].toString();
         byte var12;
         if (var8 == var7) {
            var12 = 0;
         } else {
            var12 = 3;
         }

         var10.drawString(var11, (var4 >> 1) + var2, var3 + 2 + (var5 + 33) * var8, 1 | 16, var12, 1);
         g.setColor(16711680);
         if (this.pkey.isSelect(Constants_H.WIDTH * var2 / Constants_H.WIDTH__, ((var5 + 33) * var8 + var3) * Constants_H.WIDTH / Constants_H.WIDTH__, Constants_H.WIDTH * var4 / Constants_H.WIDTH__, Constants_H.WIDTH * 33 / Constants_H.WIDTH__)) {
            if (this.map.my.state == 12) {
               if (var8 == var7) {
                  this.map.my.state = 13;
               } else {
                  this.cur_a = var8;
               }
            } else if (run_state == 35 || run_state == 25 || this.map.my.state == 16 || run_state == 65 || run_state == 66) {
               if (var8 == var7) {
                  this.pkey.setKey5();
               } else {
                  this.popMenu = var8;
               }
            }
         }
      }

   }

   public void drawSrcLine(Graphics var1, int var2, int var3, int var4, boolean var5, boolean var6) {
      short var7 = 0;
      byte var9 = (byte)(var3 / var4);
      var1.setColor(0);
      short var8;
      byte[] var10;
      short var11;
      if (!var5) {
         var11 = (short)(2 << this.src_c[0]);

         for(byte var12 = (byte)(var4 - 1); var12 > -1; var11 = (short)(var11 / 2)) {
            if (var9 - var11 > 0) {
               if (var11 < 2) {
                  var7 = 0;
               } else {
                  var7 = var11;
               }

               if (var11 < 2) {
                  var8 = 0;
               } else {
                  var8 = var11;
               }

               var1.fillRect(0, var12 * var9 + var2 + var7, 640, var9 - var8);
            }

            --var12;
         }

         if (var6 && this.src_c[0] < 12) {
            var10 = this.src_c;
            ++var10[0];
         } else if (!var6 && this.src_c[0] > 0) {
            var10 = this.src_c;
            --var10[0];
         }
      } else {
         for(var11 = (short)(2 << this.src_c[1]); var5 && var7 < var4; var11 = (short)(var11 / 2)) {
            if (var9 - var11 > 0) {
               if (var11 < 2) {
                  var8 = 0;
               } else {
                  var8 = var11;
               }

               var1.fillRect(0, var7 * var9 + var2, 640, var9 - var8);
            }

            var7 = (byte)(var7 + 1);
         }

         if (var6 && this.src_c[1] < 12) {
            var10 = this.src_c;
            ++var10[1];
         } else if (!var6 && this.src_c[1] > 0) {
            var10 = this.src_c;
            --var10[1];
         }
      }

   }

   public void drawZero(int var1, int var2, int var3, int var4) {
      Ui.i().drawString("\u70b9\u51fb\u5c4f\u5e55\u7ee7\u7eed", var1, var2, var3, var4, 0);
   }

   public void drawZero(String var1, int var2) {
      Ui.i().drawString("\u70b9\u51fb\u5c4f\u5e55" + var1, Constants_H.WIDTH_H, var2, 1 | 32, 0, 0);
   }

   public byte getNLevel(int var1) {
      return this.nidusList[1][this.getRid(var1)];
   }

   public short getNexp(int var1, int var2) {
      return Ms.i().getShort(this.rmsNidus, var1 * 5 + var2);
   }

   public byte getNid(int var1) {
      return this.nidusList[0][this.getRid(var1)];
   }

   public byte getRid(int var1) {
      return this.rmsNidus[var1 * 5];
   }

   public short getSIndexW(String var1) {
      byte var6 = 0;
      byte var5 = 0;
      byte var7 = (byte)var1.indexOf("#", 0);
      byte var2 = var7;
      byte var3 = var6;
      byte var4 = var5;
      if (var7 == 0) {
         var2 = 1;
         var4 = var5;
         var3 = var6;
      }

      while(var2 != -1) {
         var4 += var2;
         var2 = (byte)var1.indexOf("#", var4);
         ++var3;
      }

      return (short)(Ms.i().getStringWidth("#1") * var3);
   }

   public void gogoWord(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      short var8 = (short)(Ms.i().getStringWidth(var1) - this.getSIndexW(var1));
      if (var8 > 640 - var2 - var4) {
         this.introX -= var7;
         if (this.introX + var8 < var2) {
            this.introX = 640 - var4 - 75;
         }
      } else {
         this.introX = var2;
      }

      g.clipRect(var2, var3, 640 - var4 - var2, 30);
      Ui.i().drawStringColor(var1, this.introX, var3, var5, var6);
      g.setClip(0, 0, 640, 360);
   }

   public void gogoWordM(String var1, int var2, int var3, int var4, int var5, int var6) {
      short var7 = (short)Ms.i().getStringWidth(var1);
      this.introT -= var6;
      if (this.introT + var7 < var3 << 1) {
         this.introT = 640 + 1;
      }

      g.clipRect(var3, var2, 640 - (var3 << 1), 30);
      Ui.i().drawString(var1, this.introT, var2, 0, var4, var5);
      g.setClip(0, 0, 640, 360);
   }

   public void initGraphics(Graphics var1) {
      g = var1;
      dg = DirectUtils.getDirectGraphics(var1);
   }

   public void initOffG() {
      scrT = Image.createImage(Constants_H.WIDTH + 20, Constants_H.HEIGHT + 20);
      offG = scrT.getGraphics();
   }

   public void initRmsOther() {
      this.rmsOther = null;
      byte[] var1 = new byte[12];
      var1[0] = -1;
      var1[3] = 1;
      this.rmsOther = var1;
   }

   public byte isMyLevel(boolean var1) {
      byte var2;
      switch (this.rmsOther[3]) {
         case 1:
            if (var1 && this.monInfoList[103] > 4) {
               this.rmsOther[3] = 2;
               break;
            }

            var2 = 5;
            return var2;
         case 2:
            if (var1 && this.monInfoList[103] > 9) {
               this.rmsOther[3] = 3;
               break;
            }

            var2 = 10;
            return var2;
         case 3:
            if (var1 && this.monInfoList[103] > 14) {
               this.rmsOther[3] = 4;
               break;
            }

            var2 = 15;
            return var2;
         case 4:
            if (!var1 || this.monInfoList[103] <= 29) {
               var2 = 30;
               return var2;
            }

            this.rmsOther[3] = 5;
      }

      var2 = -1;
      return var2;
   }

   public void loadInfoList() {
      this.info = Ms.i().rmsOptions(6, (byte[])null, 1);
      if (this.info[0] == -1) {
         this.monInfoList = new byte[105];

         for(int var1 = 0; var1 < this.monInfoList.length; ++var1) {
            this.monInfoList[var1] = 0;
         }
      } else {
         this.monInfoList = this.info;
      }

      this.info = null;
   }

   public void loadItem() {
      this.info = Ms.i().rmsOptions(4, (byte[])null, 1);
      this.len = new byte[]{16, 19, 23, 12};
      this.itemsLength = new byte[4];
      int var1;
      if (this.info[0] != -1) {
         for(var1 = 0; var1 < 4; ++var1) {
            this.itemsLength[var1] = this.info[var1];
         }
      }

      this.items = new byte[this.itemsLength.length][][];
      var1 = 0;

      for(int var2 = 0; var1 < this.items.length; ++var1) {
         byte[][][] var4 = this.items;
         int var3 = this.len[var1];
         var4[var1] = new byte[var3][2];

         for(var3 = 0; var3 < this.itemsLength[var1]; ++var2) {
            this.items[var1][var3][0] = this.info[var2 * 2 + 4];
            this.items[var1][var3][1] = this.info[var2 * 2 + 4 + 1];
            ++var3;
         }
      }

      this.info = null;
      this.len = null;
   }

   public void loadMon(int var1, byte[][] var2) {
      Exception var10000;
      label101: {
         this.info = Ms.i().rmsOptions(var1 + 8, (byte[])null, 1);
         byte var3 = 0;
         byte var4 = 0;
         ByteArrayInputStream var5;
         Monster var7;
         boolean var10001;
         if (var1 == 0) {
            try {
               this.cMonsters = new Monster[95];
               if (this.info[0] == -1) {
                  this.cMon_count = 0;
                  return;
               }
            } catch (Exception var16) {
               var10000 = var16;
               var10001 = false;
               break label101;
            }

            try {
               var5 = new ByteArrayInputStream(this.info);
               this.cMon_count = (byte)var5.read();
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
               break label101;
            }

            var1 = var4;

            while(true) {
               try {
                  if (var1 >= this.cMon_count) {
                     break;
                  }
               } catch (Exception var14) {
                  var10000 = var14;
                  var10001 = false;
                  break label101;
               }

               Monster[] var20;
               try {
                  var20 = this.cMonsters;
                  var7 = new Monster();
               } catch (Exception var12) {
                  var10000 = var12;
                  var10001 = false;
                  break label101;
               }

               var20[var1] = var7;

               try {
                  this.loadMon(var5, this.cMonsters[var1], var2);
               } catch (Exception var11) {
                  var10000 = var11;
                  var10001 = false;
                  break label101;
               }

               ++var1;
            }
         } else {
            try {
               this.myMonsters = new Monster[5];
               if (this.info[0] == -1) {
                  this.myMon_length = 0;
                  return;
               }
            } catch (Exception var17) {
               var10000 = var17;
               var10001 = false;
               break label101;
            }

            ByteArrayInputStream var6;
            try {
               var6 = new ByteArrayInputStream(this.info);
               this.myMon_length = (byte)var6.read();
            } catch (Exception var10) {
               var10000 = var10;
               var10001 = false;
               break label101;
            }

            var1 = var3;

            while(true) {
               var5 = var6;

               Monster[] var19;
               try {
                  if (var1 >= this.myMon_length) {
                     break;
                  }

                  var19 = this.myMonsters;
                  var7 = new Monster();
               } catch (Exception var15) {
                  var10000 = var15;
                  var10001 = false;
                  break label101;
               }

               var19[var1] = var7;

               try {
                  this.loadMon(var6, this.myMonsters[var1], var2);
               } catch (Exception var9) {
                  var10000 = var9;
                  var10001 = false;
                  break label101;
               }

               ++var1;
            }
         }

         try {
            var5.close();
            this.info = null;
            return;
         } catch (Exception var8) {
            var10000 = var8;
            var10001 = false;
         }
      }

      Exception var18 = var10000;
      var18.printStackTrace();
   }

   public void loadMon(ByteArrayInputStream var1, Monster var2, byte[][] var3) throws IOException {
      var2.monster = new byte[18];
      var2.monsterPro = new short[8];
      var1.read(var2.monster);
      this.len = new byte[10];
      var1.read(this.len);

      for(int var4 = 0; var4 < 5; ++var4) {
         var2.monsterPro[var4] = (short)((this.len[var4 * 2 + 1] & 255) << 8 | this.len[var4 * 2 + 0] & 255);
      }

      var2.setProAFD(var3[var2.monster[0]]);
      this.len = null;
   }

   public void loadRmsNidus() {
      this.rmsNidus = Ms.i().rmsOptions(3, (byte[])null, 1);
      if (this.rmsNidus[0] == -1) {
         this.rmsNidus = null;
         byte[] var1 = new byte[25];
         var1[0] = -2;
         var1[3] = 10;
         var1[4] = 10;
         var1[5] = -2;
         var1[8] = 10;
         var1[9] = 10;
         var1[10] = -2;
         var1[13] = 10;
         var1[14] = 10;
         var1[15] = -2;
         var1[18] = 10;
         var1[19] = 10;
         var1[20] = -2;
         var1[23] = 10;
         var1[24] = 10;
         this.rmsNidus = var1;
      }

   }

   public void loadRmsOther() {
      this.info = Ms.i().rmsOptions(10, (byte[])null, 1);
      if (this.info[0] == -1) {
         this.setMaxTakes(true);
         this.initRmsOther();
      } else {
         this.rmsOther = this.info;
         this.setMaxTakes(false);
      }

      this.info = null;
   }

   public void loadRmsSms() {
      this.rmsSms = Ms.i().rmsOptions(5, (byte[])null, 1);
      if (this.rmsSms == null || this.rmsSms[0] == -1) {
         this.rmsSms = null;
         this.rmsSms = new byte[7];
      }

      if (this.rmsSms[0] == 10) {
         byte[] var1 = this.rmsOther;
         var1[2] = (byte)(var1[2] | 8);
      }

   }

   public void saveInfoList() {
      Ms.i().rmsOptions(6, this.monInfoList, 2);
   }

   public void saveItem() {
      int var2 = 0;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 += this.itemsLength[var1];
      }

      this.info = new byte[this.items.length + var2 * 2];
      var2 = 0;

      for(var1 = 0; var1 < 4; ++var1) {
         this.info[var1] = this.itemsLength[var1];
      }

      for(var1 = 0; var1 < this.items.length; ++var1) {
         for(int var3 = 0; var3 < this.itemsLength[var1]; ++var2) {
            this.info[var2 * 2 + 4] = this.items[var1][var3][0];
            this.info[var2 * 2 + 4 + 1] = this.items[var1][var3][1];
            ++var3;
         }
      }

      Ms.i().rmsOptions(4, this.info, 2);
      this.info = null;
   }

   public void saveMon(int var1) {
      Exception var10000;
      label76: {
         ByteArrayOutputStream var4 = new ByteArrayOutputStream();
         byte var3 = 0;
         byte var2 = 0;
         boolean var10001;
         if (var1 == 0) {
            try {
               var4.write(this.cMon_count);
            } catch (Exception var9) {
               var10000 = var9;
               var10001 = false;
               break label76;
            }

            var1 = var2;

            while(true) {
               try {
                  if (var1 >= this.cMon_count) {
                     Ms.i().rmsOptions(8, var4.toByteArray(), 2);
                     break;
                  }
               } catch (Exception var10) {
                  var10000 = var10;
                  var10001 = false;
                  break label76;
               }

               try {
                  this.saveMon(var4, this.cMonsters[var1]);
               } catch (Exception var8) {
                  var10000 = var8;
                  var10001 = false;
                  break label76;
               }

               ++var1;
            }
         } else {
            try {
               var4.write(this.myMon_length);
            } catch (Exception var7) {
               var10000 = var7;
               var10001 = false;
               break label76;
            }

            var1 = var3;

            while(true) {
               try {
                  if (var1 >= this.myMon_length) {
                     Ms.i().rmsOptions(9, var4.toByteArray(), 2);
                     break;
                  }
               } catch (Exception var11) {
                  var10000 = var11;
                  var10001 = false;
                  break label76;
               }

               try {
                  this.saveMon(var4, this.myMonsters[var1]);
               } catch (Exception var6) {
                  var10000 = var6;
                  var10001 = false;
                  break label76;
               }

               ++var1;
            }
         }

         try {
            var4.close();
            return;
         } catch (Exception var5) {
            var10000 = var5;
            var10001 = false;
         }
      }

      Exception var12 = var10000;
      var12.printStackTrace();
   }

   public void saveMon(ByteArrayOutputStream var1, Monster var2) throws IOException {
      var1.write(var2.monster);

      for(int var3 = 0; var3 < 5; ++var3) {
         short var4 = var2.monsterPro[var3];
         var1.write((byte)(var4 & 255));
         var1.write((byte)(var4 >> 8 & 255));
      }

   }

   public void setAction_str(String[] var1) {
      this.action_str = var1;
      var1 = (String[])null;
   }

   public void setGogoWord() {
      this.introT = Constants_H.WIDTH;
      Ms.i();
      Ms.skip = 0;
      StringBuffer[] var1 = Ms.i().createStringArray(Ms.i().getStream("data/other/hint.t", -1));
      Ms.i();
      this.gogoST = var1[Ms.getRandom(var1.length)].toString();
      var1 = (StringBuffer[])null;
   }

   public void setMaxTakes(boolean var1) {
      if (var1) {
         this.max_takes = 3;
         this.max_monsters = 10;
      } else if (this.rmsOther[3] == 2) {
         this.max_takes = 4;
         this.max_monsters = 20;
      } else if (this.rmsOther[3] == 3) {
         this.max_takes = 5;
         this.max_monsters = 40;
      } else if (this.rmsOther[3] == 4) {
         this.max_takes = 5;
         this.max_monsters = 80;
      } else if (this.rmsOther[3] == 5) {
         this.max_takes = 5;
         this.max_monsters = 95;
      }

   }

   public void setNidusExp(int var1) {
      if (var1 / 10 < 1) {
         var1 = 1;
      } else {
         var1 /= 10;
      }

      for(byte var2 = 0; var2 < 5; ++var2) {
         if (this.getRid(var2) != -2) {
            Ms.i().putShort(this.getNexp(var2, 1) + var1, this.rmsNidus, var2 * 5 + 1);
            if (this.getNexp(var2, 1) > this.getNexp(var2, 3)) {
               Ms.i().putShort(this.getNexp(var2, 3), this.rmsNidus, var2 * 5 + 1);
            }
         }
      }

   }

   public void setPauseS(int var1) {
      if (var1 == 0) {
         this.setAction_str(new String[]{"\u4fdd\u5b58\u6e38\u620f", "\u67e5\u770b\u5ba0\u7269", "\u4eba\u7269\u80cc\u5305", "\u5ba0\u7269\u56fe\u9274", "\u67e5\u770b\u4efb\u52a1", "\u8fd4\u56de\u6e38\u620f"});
      } else {
         this.setAction_str(new String[]{"\u8bfb\u53d6\u8fdb\u5ea6", "\u58f0\u97f3", "\u6e38\u620f\u5e2e\u52a9", "\u56de\u4e3b\u83dc\u5355"});
      }

   }

   public void setStringB(String var1, int var2, int var3) {
      if (var3 == 0) {
         this.about_a = Ms.i().groupString(var1, var2);
      } else if (var3 == 1) {
         this.about_b = Ms.i().groupString(var1, var2);
      } else if (var3 == 2) {
         this.about_c = Ms.i().groupString(var1, var2);
      } else if (var3 == 3) {
         this.about_d = Ms.i().groupString(var1, var2);
      }

   }

   public void showString(String var1, int var2, int var3) {
      byte var4 = (byte)(var1.length() / 11);
      Ui.i().drawK0(var3 - 5, var2, 640 + 10, (var4 + 1) * 25 + 8, 3);
      this.showStringM(var1, 320 + var3, var2 + 3, 11, 0);
   }

   public void showString(StringBuffer[] var1, int var2, int var3, int var4) {
      int var7 = Constants_H.WIDTH__;
      int var6 = Constants_H.WIDTH__ / 2;
      int var5 = var2 + 5;
      if (var4 != 0) {
         Ui.i().drawKuang(var3 - 5, var5, var7 + 10, var1.length * 25 + 12);
         if (var4 == 2) {
            this.drawSnare5(var6 + var3, var1.length * 25 + var5 + 4);
         }
      }

      for(byte var8 = 0; var8 < var1.length; ++var8) {
         Ui.i().drawStringColor(var1[var8].toString(), 25 + var3, var5 + 4 + var8 * 25, -1, 1);
      }

   }

   public void showStringM(String var1, int var2, int var3, int var4, int var5) {
      byte var8 = (byte)(var1.length() / var4);

      for(byte var6 = 0; var6 <= var8; ++var6) {
         if (var8 == 0) {
            Ui.i().drawString(var1, var2, var3, 1 | 16, var5, 1);
            Log.e("sk", "strNum == 0");
         } else {
            Ui var9 = Ui.i();
            int var7;
            if (var6 + 1 > var8) {
               var7 = var1.length();
            } else {
               var7 = (var6 + 1) * var4;
            }

            var9.drawString(var1.substring(var6 * var4, var7), var2, var3 + var6 * 25, 1 | 16, var5, 0);
            Log.e("sk", "else");
         }
      }

   }

   public void showStringM_(String var1, int var2, int var3, int var4, int var5) {
      byte var8 = (byte)(var1.length() / var4);

      for(byte var6 = 0; var6 <= var8; ++var6) {
         if (var8 == 0) {
            Ui.i().drawString(var1, var2, var3, 1 | 16, var5, 1);
            Log.e("sk", "strNum == 0");
         } else {
            Ui var9 = Ui.i();
            int var7;
            if (var6 + 1 > var8) {
               var7 = var1.length();
            } else {
               var7 = (var6 + 1) * var4;
            }

            var9.drawString(var1.substring(var6 * var4, var7), var2, var3 + var6 * 25, 1 | 16, var5, 0);
         }
      }

   }
}
