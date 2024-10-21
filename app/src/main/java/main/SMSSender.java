package main;

import android.util.Log;
import com.PetKing5_480x800.PetKing5;
import dm.Ms;
import dm.Sound;
import dm.Ui;

public class SMSSender implements Key_H {
   public static GameRun gr;
   public static boolean isWorking;
   public static PetKing5 pk;
   public static SMSSender smsSender;
   public static byte smsType;
   private StringBuffer[] about;
   private byte currentPage;
   public byte idSmsLevel;
   public byte[][] menu;
   private String[][] menuTxt;
   public byte menu_state;
   public PointerKey pkey;
   public byte[] sel;
   public byte sendSms;
   public byte showLine;
   public byte[][] smsCount;
   public boolean sms_a = true;
   public boolean sms_b = false;
   public byte tMyState;
   private int tState;
   private byte totalPage;

   public SMSSender(GameRun var1) {
      super();
      byte[] var2 = new byte[]{0, 2, 4, 5};
      this.menu = new byte[][]{var2, {6}, {7}, {8}, {2}};
      this.sel = new byte[2];
      var2 = new byte[]{4, 1, 1};
      byte[] var7 = new byte[]{2, 1, 2};
      byte[] var5 = new byte[]{4, 1, 3};
      byte[] var6 = new byte[]{1, 1, 4};
      byte[] var3 = new byte[]{2, 1, 5};
      byte[] var4 = new byte[]{1, 1, 0};
      this.smsCount = new byte[][]{var2, var7, var5, var6, var3, var4, {2, 1, 6}, {2, 1, 5}};
      this.sendSms = -1;
      gr = var1;
      smsSender = this;

      try {
         this.createSMS();
      } catch (Exception var8) {
         var8.printStackTrace();
      }

   }

   private void createSMS() {
      String[] var1 = new String[]{"\u5546\u57ce"};
      String[] var2 = new String[]{"\u8d2d\u4e705000\u91d1", "\u8eab\u4e3a\u56db\u5927\u5bb6\u65cf\u4e4b\u9996\u7684\u8d35\u516c\u5b50\uff0c\u6ca1\u94b1\u53ef\u4e0d\u884c\uff01\u7acb\u523b\u62e5\u67095000\u91d1\u3002"};
      String[] var6 = new String[]{"\u8d2d\u4e7050\u5fbd\u7ae0", ""};
      String[] var4 = new String[]{"\u8d2d\u4e7010\u5fbd\u7ae0", "\u8d2d\u4e70\u8be5\u7279\u6b8a\u9053\u5177\uff0c\u7acb\u523b\u62e5\u670910\u5fbd\u7ae0\uff0c\u80fd\u8d2d\u4e70\u53cc\u500d\u7ecf\u9a8c\uff0c\u5ba0\u7269\u6280\u80fd\uff0c\u5f3a\u5927\u7684\u5ba0\u7269\u6355\u83b7\u7403\u7b49\u5404\u79cd\u795e\u5947\u7684\u9053\u5177\u3002"};
      String[] var5 = new String[]{"\u8d2d\u4e70\u5947\u5f02\u517d", "\u8d2d\u4e70\u8be5\u7279\u6b8a\u9053\u5177\uff0c\u83b7\u5f97\u53ef\u7231\u7684\u5947\u5f02\u517d\uff0c\u79fb\u52a8\u901f\u5ea6\u53ef\u4ee5\u63d0\u9ad8\u4e00\u500d\uff0c\u4e14\u4e0d\u4f1a\u9047\u5230\u4efb\u4f55\u654c\u4eba\uff01\u65e0\u9650\u4f7f\u7528\uff0c\u5fc3\u52a8\u4e0d\u5982\u884c\u52a8\uff0c\u5feb\u8d2d\u4e70\u5427\uff01"};
      String[] var3 = new String[]{"\u5347\u7ea7\u590d\u6d3b", "\u8ba9\u60a8\u643a\u5e26\u7684\u6240\u6709\u5ba0\u7269\u5168\u6062\u590d\uff0c\u540c\u65f6\u7acb\u523b\u8ba9\u60a8\u643a\u5e26\u7684\u5ba0\u7269\u63d0\u53475\u7ea7\uff08\u8d85\u8fc770\u7ea7\u5ba0\u7269\u4e0d\u80fd\u518d\u5347\u7ea7\uff09\uff0c\u8ba9\u63a5\u4e0b\u6765\u7684\u6218\u6597\u53d8\u7684\u66f4\u8f7b\u677e\u3002"};
      this.menuTxt = new String[][]{var1, {"\u8d2d\u4e7030000\u91d1", ""}, var2, var6, var4, {"\u5ba0\u7269\u53475\u7ea7", "\u8ba9\u60a8\u968f\u8eab\u643a\u5e26\u7684\u5168\u90e8\u5ba0\u7269\u7acb\u523b\u53475\u7ea7\uff08\u8d85\u8fc770\u7ea7\u5ba0\u7269\u4e0d\u80fd\u518d\u5347\u7ea7\uff09"}, var5, {"\u6b63\u7248\u9a8c\u8bc1", "\u6e38\u620f\u8bd5\u73a9\u7ed3\u675f\uff0c\u8d2d\u4e70\u6b64\u9879\u5c06\u5f00\u542f\u540e\u7eed\u6240\u6709\u6e38\u620f\u5185\u5bb9\u3001\u5730\u56fe\u3002\u540c\u65f6\u5c06\u514d\u8d39\u8d60\u9001\u60a85\u679a\u5fbd\u7ae0\uff08\u53ef\u8d2d\u4e70\u5f3a\u529b\u9053\u5177\uff09"}, var3};
   }

   private void draw0() {
      boolean var4 = true;
      boolean var6 = true;
      boolean var5 = true;
      boolean var7 = true;
      if (this.sendSms > -1) {
         String var9 = "";
         boolean var2;
         boolean var3;
         String var8;
         if (this.sendSms == 0) {
            byte var1 = this.smsCount[smsType][2];
            if (var1 < 0) {
               var1 = 0;
            } else {
               var1 = gr.rmsSms[var1];
            }

            var8 = this.getSmsTip(var1, this.smsCount[smsType][1] - var1);
            var3 = var7;
            var2 = var6;
         } else {
            var2 = var6;
            var3 = var7;
            var8 = var9;
            if (this.sendSms != 1) {
               var2 = var6;
               var3 = var7;
               var8 = var9;
               if (this.sendSms != 2) {
                  var2 = var6;
                  var3 = var7;
                  var8 = var9;
                  if (this.sendSms != 3) {
                     if (this.sendSms > 3 && this.sendSms < 15 || this.sendSms > 23 && this.sendSms < 34) {
                        var9 = "\u8d2d\u4e70\u5df2\u6210\u529f\uff01";
                        var4 = false;
                        var5 = false;
                        var2 = var5;
                        var3 = var4;
                        var8 = var9;
                        if (this.sendSms > 23) {
                           var2 = var5;
                           var3 = var4;
                           var8 = var9;
                           if (this.sendSms < 34) {
                              ++this.sendSms;
                              var2 = var5;
                              var3 = var4;
                              var8 = var9;
                           }
                        }
                     } else if (this.sendSms == 15) {
                        var8 = "\u81ea\u52a8\u4fdd\u5b58\u6e38\u620f\u3002";
                        var3 = false;
                        var2 = false;
                     } else {
                        var2 = var6;
                        var3 = var7;
                        var8 = var9;
                        if (this.sendSms < 23) {
                           var9 = "\u4fdd\u5b58\u6e38\u620f\u6210\u529f\u3002";
                           ++this.sendSms;
                           var4 = false;
                           var5 = false;
                           if (smsType == 5 && this.sendSms == 23) {
                              gr.say("\u8d2d\u4e70\u5df2\u6210\u529f\uff01\u6e38\u620f\u5df2\u4fdd\u5b58\u3002#n\u65b0\u6e38\u620f\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39\u3002", -1);
                              var2 = var5;
                              var3 = var4;
                              var8 = var9;
                           } else {
                              var2 = var5;
                              var3 = var4;
                              var8 = var9;
                              if (smsType == 6) {
                                 var2 = var5;
                                 var3 = var4;
                                 var8 = var9;
                                 if (this.sendSms == 23) {
                                    gr.say("\u8d2d\u4e70\u5df2\u6210\u529f\uff01\u83b7\u5f975\u679a\u5fbd\u7ae0(\u80cc\u5305\u7684\u5377\u8f74\u754c\u9762\u53ef\u67e5\u770b\uff09\u3002\u6e38\u620f\u5df2\u4fdd\u5b58\u3002#n\u65b0\u6e38\u620f\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39\u3002", 0);
                                    var2 = var5;
                                    var3 = var4;
                                    var8 = var9;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         var4 = var2;
         var5 = var3;
         if (this.sendSms != 3) {
            var4 = var2;
            var5 = var3;
            if (this.sendSms != 1) {
               var4 = var2;
               var5 = var3;
               if (this.sendSms != 2) {
                  gr.showString(var8, Constants_H.HEIGHT_H - 50, 0);
                  var5 = var3;
                  var4 = var2;
               }
            }
         }
      }

      Ui.i().drawYesNo(var4, var5);
   }

   private String getSmsTip(int var1, int var2) {
      return "" + "\u60a8\u5df2\u53d1\u9001" + var1 + "\u6761\u77ed\u4fe1\u3002" + "\u8d2d\u4e70\u6b64\u9879\uff0c\u8fd8\u9700\u53d1\u9001" + var2 + "\u6761\u77ed\u4fe1\u3002" + "\u786e\u8ba4\u53d1\u9001\u77ed\u4fe1\u5417\uff1f";
   }

   private void goWord() {
      this.showLine = 3;
   }

   public static SMSSender i(GameRun var0) {
      if (smsSender == null) {
         smsSender = new SMSSender(var0);
      }

      return smsSender;
   }

   private void outState() {
      if (this.tState != -1) {
         GameRun.run_state = this.tState;
         gr.map.my.state = this.tMyState;
      } else {
         GameRun.run_state = -10;
      }

   }

   public void draw() {
      if (this.menu_state == 0) {
         int var1 = 640 - 2;
         int var4 = 360 - 1;
         Ui.i().fillRectB();
         Ui.i().drawK2(1, 1, var1, var4, 0);
         Ui.i().drawK1(320 - 75, 1 + 3, 150, 28 - 4, 4);
         Ui.i().drawString(this.menuTxt[this.menu[this.menu_state][0]][0], 320, 1 + 1, 17, 0, 1);
         Log.e("sk", "draw");
         int var3 = 1 + 5;
         int var2 = 1 + 29;
         int var5 = var1 - 10;
         var1 = var2;
         if (this.menu[this.menu_state].length > 1) {
            Ui.i().drawK1(var3, var2, var5 - 15, 28 * this.showLine, 1);
            Ui.i().sliding(var3 + 628 - 13, var2, 28 * this.showLine, this.sel[0] - 1, this.menu[this.menu_state].length - 1, true);
            Ui.i().drawListKY(this.showLine, var3, var2 + 2, var5 - 15, 2, 28, -1, this.sel[0] - this.sel[1], 4, 2);

            for(var1 = this.sel[1]; var1 < this.sel[1] + this.showLine && var1 < this.menu[this.menu_state].length; ++var1) {
               Ui var8 = Ui.i();
               String var7 = this.menuTxt[this.menu[this.menu_state][var1]][0];
               byte var6 = this.sel[1];
               byte var9;
               if (this.sel[0] == var1) {
                  var9 = 0;
               } else {
                  var9 = 3;
               }

               var8.drawString(var7, var3 + 314, (var1 - var6) * 28 + 32, 17, var9, 0);
               if (this.pkey.isSelect(var3, (var1 - this.sel[1]) * 28 + 32, 640, 28)) {
                  this.sel[0] = (byte)var1;
                  this.setSmsType();
               }
            }

            var1 = this.showLine * 28 + 5 + 30;
         }

         Ui.i().drawK1(var3, var1, var5, var4 - (var1 + 10), 2);
         this.draw0();
      }

   }

   public byte getSendSms() {
      return this.sendSms;
   }

   public byte getSmsSenderMenuState() {
      return this.menu_state;
   }

   public int getTstate() {
      return this.tState;
   }

   public void go(int var1, boolean var2) {
      if (var2) {
         this.tState = GameRun.run_state;
         this.tMyState = gr.map.my.state;
      } else {
         this.tState = -1;
      }

      this.sms_a = true;
      this.sms_b = false;
      GameRun.run_state = -20;
      this.menu_state = (byte)var1;
      byte[] var4 = this.sel;
      byte[] var5 = this.sel;
      byte var6;
      if (this.menu[this.menu_state].length > 1) {
         var6 = 1;
      } else {
         var6 = 0;
      }

      byte var3 = (byte)var6;
      var5[1] = var3;
      var4[0] = var3;
      smsType = (byte)(this.menu[this.menu_state][this.sel[0]] - 1);
      this.goWord();
      if (smsType != 5 && smsType != 6 && smsType != 7 && (this.menu_state != 4 || smsType != 1)) {
         this.sendSms = -1;
         isWorking = false;
      } else {
         this.sendSms = 1;
      }

   }

   public void goLevel() {
      GameRun.run_state = -21;
      this.idSmsLevel = 0;
      gr.b_c = 0;
      if (this.tState != -31) {
         gr.levelUp_in_battle = null;
         GameRun var3 = gr;
         int var1 = gr.max_takes;
         var3.levelUp_in_battle = new byte[var1][2];
         gr.proReplace = null;
         var3 = gr;
         var1 = gr.myMonsters.length;
         var3.proReplace = new short[var1][7];
      }

      for(byte var4 = 0; var4 < gr.myMon_length; ++var4) {
         if (gr.myMonsters[var4].monster[2] >= 70) {
            gr.healMonster(gr.myMonsters[var4]);
         } else {
            gr.proReplace[var4][6] = gr.myMonsters[var4].monster[2];
            gr.levelUp_in_battle[var4][0] = 1;
            gr.levelUp_in_battle[var4][1] = -1;

            for(byte var2 = 0; var2 < 5; ++var2) {
               gr.levelPro(var4, false);
               gr.getMagic(gr.myMonsters[var4]);
               if (gr.getSkill != -1) {
                  gr.levelUp_in_battle[var4][1] = gr.getSkill;
               }
            }
         }
      }

   }

   public boolean isMyMonLevel() {
      byte var1 = (byte)(gr.myMon_length - 1);

      boolean var2;
      while(true) {
         if (var1 <= -1) {
            var2 = false;
            break;
         }

         if (gr.myMonsters[var1].monster[2] < 70) {
            var2 = true;
            break;
         }

         --var1;
      }

      return var2;
   }

   public void key() {
      if (this.sendSms == -1 && Ms.i().key_Up_Down()) {
         if (!Ms.i().key_delay() && this.menu[this.menu_state].length > 1) {
            Ms.i().selectS(this.sel, 1, this.menu[this.menu_state].length, this.showLine);
            this.setSmsType();
         }
      } else if ((this.sendSms == -1 || this.sendSms == 0) && Ms.i().key_S1()) {
         Ms.i().keyRelease();
         if (smsType != 4 || this.sel[0] == 7 || gr.myMon_length >= 1 && this.isMyMonLevel()) {
            this.sendSms = 1;
         } else {
            this.sendSms = -1;
            gr.say("\u76ee\u524d\u6ca1\u6709\u53ef\u4ee5\u5347\u7ea7\u7684\u5ba0\u7269\uff01", 0);
         }
      } else if ((this.sendSms == -1 || this.sendSms == 0 || this.sendSms == 3 || this.sendSms == 24) && Ms.i().key_S2()) {
         Ms.i().keyRelease();
         this.outState();
         if (smsType == 6) {
            GameRun.run_state = -10;
            isWorking = true;
         }

         this.sendSms = -1;
      }

   }

   public void keyLevel() {
      if (!Ms.i().key_delay() && gr.b_c == 1 && gr.say_s == 0) {
         gr.b_c = 0;
      }

   }

   public void paint() {
      this.draw();
   }

   public void paintLevel() {
      if (gr.b_c == 1) {
         gr.drawEvolveUI(0, this.idSmsLevel, true);
      }

   }

   public void run() {
      if (this.sendSms == 1) {
         this.sendSms = 2;
         pk.setSmshah();
      }

   }

   public void runLevel() {
      if (gr.b_c == 0) {
         if (gr.levelUp_in_battle[this.idSmsLevel][0] == 1) {
            gr.levelUp_in_battle[this.idSmsLevel][0] = 0;
            gr.b_c = 1;
            gr.say_s = 52;
            gr.levelPro(this.idSmsLevel, true);
            gr.setStringB("\u751f\u547d;+" + gr.proReplace[this.idSmsLevel][0] + "#n" + "\u80fd\u91cf" + ";+" + gr.proReplace[this.idSmsLevel][1], Constants_H.WIDTH, 0);
            gr.setStringB("\u529b\u91cf;+" + gr.proReplace[this.idSmsLevel][3] + "#n" + "\u9632\u5fa1" + ";+" + gr.proReplace[this.idSmsLevel][4] + "#n" + "\u654f\u6377" + ";+" + gr.proReplace[this.idSmsLevel][5], Constants_H.WIDTH, 1);
            gr.initMonStream(2, gr.mList_id[gr.myMonsters[this.idSmsLevel].monster[0]][0], 1);
         } else {
            ++this.idSmsLevel;
         }

         if (this.idSmsLevel >= gr.myMon_length) {
            if (this.tState == -1) {
               GameRun.run_state = -20;
               gr.levelUp_in_battle = null;
               gr.proReplace = null;
            } else {
               GameRun.run_state = this.tState;
               if (this.tState == -31) {
                  gr.initMonStream(2, gr.mList_id[gr.myB.getMon().monster[0]][0], 1);
                  gr.myB.act_num = 0;
                  gr.initSkillList(gr.myB.getMon());

                  for(byte var1 = 0; var1 < gr.myMon_length; ++var1) {
                     gr.proReplace[gr.myMonsters[var1].monster[1]][6] = gr.myMonsters[var1].monster[2];
                  }
               }
            }
         }
      } else if (gr.b_c == 1) {
         gr.say_s = (byte)Ms.i().mathSpeedDown(gr.say_s, 4, true);
      }

   }

   public void sendSuccess() {
      if (this.sendSms == 4 && this.smsCount[smsType][1] > 1) {
         byte[] var3 = gr.rmsSms;
         byte var2 = this.smsCount[smsType][2];
         byte var1 = (byte)(var3[var2] + 1);
         var3[var2] = var1;
         if (var1 != this.smsCount[smsType][1]) {
            this.sendSms = 0;
            Ms.i().rmsOptions(5, gr.rmsSms, 2);
            Ms.i().rmsOptions(5, (byte[])null, 4);
         } else {
            gr.rmsSms[this.smsCount[smsType][2]] = 0;
         }
      }

      GameRun var4;
      switch (smsType) {
         case 0:
         default:
            break;
         case 1:
            var4 = gr;
            var4.money += 5000;
            gr.say("\u8d2d\u4e705000\u91d1\u5e01", -1);
            GameRun.run_state = -10;
            GameRun.mc.temp_state = GameRun.run_state;
            break;
         case 2:
            var4 = gr;
            var4.coin += 50;
            gr.say("\u5728\u5377\u8f74\u5546\u5e97\u4e2d\u624d\u80fd\u770b\u5230\u5fbd\u7ae0\u6570\u91cf", -1);
            GameRun.run_state = -10;
            GameRun.mc.temp_state = GameRun.run_state;
            break;
         case 3:
            var4 = gr;
            var4.coin += 10;
            gr.say("\u5728\u5377\u8f74\u5546\u5e97\u4e2d\u624d\u80fd\u770b\u5230\u5fbd\u7ae0\u6570\u91cf", -1);
            GameRun.run_state = -10;
            GameRun.mc.temp_state = GameRun.run_state;
            break;
         case 4:
            this.tState = -1;
            gr.say("\u643a\u5e26\u7684\u5ba0\u7269\u5168\u90e8\u53475\u7ea7,\u5ba0\u7269\u9875\u9762\u67e5\u770b\u65b0\u5c5e\u6027", 0, -1);
            GameRun.run_state = -10;
            GameRun.mc.temp_state = GameRun.run_state;
         case 7:
            this.goLevel();
            GameRun.mc.setSmsIsSetRun_state(true);
            GameRun.run_state = -10;
            GameRun.mc.temp_state = GameRun.run_state;
            break;
         case 5:
            gr.rmsSms[0] = 10;
            gr.say("\u8d2d\u4e70\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39", 0, -1);
            GameRun.run_state = -10;
            GameRun.mc.temp_state = GameRun.run_state;
            break;
         case 6:
            gr.rmsSms[this.smsCount[smsType][2]] = 10;
            var4 = gr;
            var4.coin += 5;
            this.sms_b = true;
            gr.say("\u8d2d\u4e70\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39", 0, -1);
            GameRun.run_state = -10;
            GameRun.mc.temp_state = GameRun.run_state;
      }

      gr.saveGame();
      if (this.menu_state != 0) {
         this.sendSms = -1;
         if (gr.say_c == 0) {
            this.outState();
            GameRun.mc.setSmsIsSetRun_state(true);
            GameRun.run_state = -10;
            GameRun.mc.temp_state = GameRun.run_state;
         }
      } else {
         this.sendSms = -1;
         Sound.i().setMusic(false);
      }

      this.sendSms = -1;
      GameRun.run_state = -10;
      GameRun.mc.temp_state = GameRun.run_state;
   }

   public void setSendSms(int var1) {
      this.sendSms = (byte)var1;
   }

   public void setSmsType() {
      smsType = (byte)(this.menu[this.menu_state][this.sel[0]] - 1);
   }

   public void setSmsValue(int var1) {
      switch (smsType) {
         case 1:
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         default:
      }
   }
}
