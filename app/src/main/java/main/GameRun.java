package main;

import android.util.Log;
import com.PetKing5_480x800.PetKing5;
import com.nokia.mid.ui.DirectGraphics;
import dm.Battle;
import dm.Monster;
import dm.Ms;
import dm.Sound;
import dm.Sprite;
import dm.Ui;
import java.util.ArrayList;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import minigame.Mg;

public class GameRun extends GameRun_F {
   public static boolean isSay = false;
   private StringBuffer[] NAME;
   private byte[][] Shuxing;
   Battle am;
   public byte b_c;
   public byte b_ico;
   String[] battleSay;
   public byte battle_state = 0;
   public byte battle_type;
   public byte bg_c;
   private StringBuffer[] buff_help;
   private StringBuffer[] buff_name;
   private byte[][] buyItem;
   public byte buyItemID = 0;
   public byte buyOk = 0;
   private short[][] buyPrice;
   short cThrowS;
   short cThrowX;
   short cThrowY;
   public byte cityName_c;
   private StringBuffer[] city_name;
   public int coin = 10;
   public byte createOver;
   public byte dead_c;
   Battle dm;
   private Image[] effectImage;
   Battle enB;
   public byte[][] enemyList;
   public int enemyOff;
   private boolean[] evolve;
   short exp;
   public byte first_battle;
   byte getSkill;
   private int hit_rate;
   private Image[] imgBG;
   private Image[] imgBattle;
   public Image[] imgIco;
   private Image[] imgItem;
   public byte immueEnemy = 0;
   private byte infoStart = 0;
   public byte[] inhesion;
   private byte[] initFealty = new byte[]{100, 120};
   private Boolean isChangeSound = false;
   public boolean isKillAll = false;
   boolean isTalk;
   public boolean isUpdateList;
   private byte[][] itemMine;
   private StringBuffer[] item_help;
   private Image item_img;
   private byte[][] item_modules;
   private StringBuffer[] item_name;
   private byte item_type;
   public byte lastSkill;
   public byte[][] levelUp_in_battle;
   public byte line_max;
   private byte list_rows = 8;
   public byte[][] mList_id;
   public Sprite[] magic;
   public byte magic_id;
   public int magic_x;
   public int magic_y;
   public byte[] makeLevel;
   public byte[] mapMove;
   public byte[][] mapRect;
   public byte mini_state = 0;
   public Sprite[] mon;
   private byte[][] monAppearMap;
   private byte[][] monInfo_dir;
   public byte[] monPro;
   private byte mon_action;
   private byte mon_action_c = 0;
   public byte[] mon_in_battle;
   public int money = 1000;
   private StringBuffer[] monsterInfo;
   private byte[][] monsterMake;
   public StringBuffer[] monsterT;
   public byte[][] monster_pro;
   public byte[][] mouduls;
   public byte[] musicNo;
   Battle myB;
   private StringBuffer[] nameTemp;
   private byte[] now_action;
   private short[] now_action_Magic;
   private byte[] now_time;
   private short[] now_time_Magic;
   public byte[] npc2ImageType;
   public byte off = 0;
   public byte overMode;
   public short[][] proReplace;
   public ArrayList sayFlag = new ArrayList();
   public byte sayOverSms = -1;
   public ArrayList sayStr = new ArrayList();
   public byte say_c;
   public byte say_mode;
   public int say_s;
   public byte select_S;
   public byte select_T;
   int sell_money = 0;
   private byte[][] skill;
   private StringBuffer[] skill_help;
   private byte[] skill_list;
   private StringBuffer[] skill_name;
   private byte[][] skill_up;
   String strHit;
   public byte t_battle_state;
   public byte t_length;
   public byte threadType = 0;
   public byte time_count;
   public byte view_state = 1;
   byte[] zb;

   public GameRun(MainCanvas var1) {
      super();
      byte[] var2 = new byte[]{-6, -4, -3, -2, -1, 0, 1, 2, 3, 4, 8, -3, 2, -1, 1, 1};
      this.zb = var2;
      byte[] var3 = new byte[]{4, 0};
      var2 = new byte[]{0, 1};
      this.Shuxing = new byte[][]{{2, 3}, {3, 4}, var3, var2, {1, 2}};
      this.hit_rate = 0;
      this.magic_id = -2;
      this.magic_x = 0;
      this.magic_y = 0;
      this.mon = new Sprite[2];
      this.magic = new Sprite[6];
      this.now_action_Magic = new short[6];
      this.now_time_Magic = new short[6];
      this.overMode = 0;
      this.evolve = new boolean[]{(boolean)1, (boolean)1, (boolean)1, (boolean)1, (boolean)1};
      this.now_action = new byte[2];
      this.now_time = new byte[2];
      this.battleSay = new String[]{"\u654c\u4eba\u51fa\u73b0\u4e86\uff0c\u6218\u6597\u5427\uff01", "\u8003\u9a8c\u7684\u65f6\u523b\u6765\u4e86\uff0c\u8bad\u7ec3\u5e08\uff01", "\u5c3d\u60c5\u6355\u6349\u5ba0\u7269\u5427\uff01"};
      this.isUpdateList = false;
      this.first_battle = 0;
      this.lastSkill = 0;
      this.skill_list = new byte[9];
      this.b_ico = 2;
      mc = var1;
      this.map = null;
      this.map = new Map(this);
      this.initOtherImage();
      Ui.i().initUiModules();
      this.loadRmsOther();
      this.loadRmsSms();
      SMSSender.i(this);
      PetKing5.gr = this;
   }

   private void AddHP(int var1, Monster var2) {
      var1 += var2.monsterPro[0];
      if (var1 >= var2.monsterPro[2]) {
         var2.monsterPro[0] = var2.monsterPro[2];
      } else {
         var2.monsterPro[0] = (short)var1;
      }

   }

   private void AddMP(int var1, Monster var2) {
      var1 += var2.monsterPro[1];
      if (var1 > var2.monsterPro[3]) {
         var2.monsterPro[1] = var2.monsterPro[3];
      } else {
         var2.monsterPro[1] = (short)var1;
      }

   }

   private void aiEnemy() {
      byte var1 = 5;
      Ms.i();

      byte var2;
      for(var2 = (byte)Ms.getRandom(100); var1 > -1 && this.enB.getMon().monster[var1 + 8] == -1; --var1) {
      }

      byte var4 = (byte)(var1 + 1);
      if (this.battle_type == 4) {
         switch (var4) {
            case 1:
               this.enB.skill = 0;
               break;
            case 2:
               if (var2 < 65) {
                  this.enB.skill = 1;
               } else {
                  this.enB.skill = 0;
               }
               break;
            case 3:
               if (var2 < 45) {
                  this.enB.skill = 2;
               } else if (var2 > 75) {
                  this.enB.skill = 1;
               } else {
                  this.enB.skill = 0;
               }
               break;
            default:
               if (var2 < 45) {
                  this.enB.skill = (byte)(var4 - 1);
               } else if (var2 < 75) {
                  this.enB.skill = (byte)(var4 - 2);
               } else if (var2 < 95) {
                  this.enB.skill = (byte)(var4 - 3);
               } else {
                  this.enB.skill = (byte)(var4 - 4);
               }
         }
      } else {
         var1 = 0;
         Ms.i();
         byte var3 = (byte)Ms.getRandom(100);

         label90: {
            label89:
            while(true) {
               if (var1 >= 2) {
                  break label90;
               }

               switch (this.enB.getMon().monster[var1 + 14]) {
                  case 27:
                     if (this.isMonHp(this.enB.getMon(), 50) && var3 < 30) {
                        break label89;
                     }
                     break;
                  case 28:
                     if (this.isMonHp(this.enB.getMon(), 30) && var3 < 30) {
                        break label89;
                     }
               }

               ++var1;
            }

            this.enB.skill = (byte)(var1 + 6);
         }

         if (var1 > 1) {
            switch (var4) {
               case 1:
                  this.enB.skill = 0;
                  break;
               case 2:
                  if (var2 < 20) {
                     this.enB.skill = 0;
                  } else {
                     this.enB.skill = 1;
                  }
                  break;
               case 3:
                  if (var2 < 5) {
                     this.enB.skill = 0;
                  } else if (var2 > 40) {
                     this.enB.skill = 2;
                  } else {
                     this.enB.skill = 1;
                  }
                  break;
               case 4:
                  if (var2 < 15) {
                     this.enB.skill = 1;
                  } else if (var2 < 40) {
                     this.enB.skill = 2;
                  } else {
                     this.enB.skill = 3;
                  }
                  break;
               default:
                  if (var2 < 60) {
                     this.enB.skill = (byte)(var4 - 1);
                  } else if (var2 < 85) {
                     this.enB.skill = (byte)(var4 - 2);
                  } else if (var2 < 95) {
                     this.enB.skill = (byte)(var4 - 3);
                  } else {
                     this.enB.skill = (byte)(var4 - 4);
                  }
            }
         }
      }

      this.enB.skill = this.enB.getMon().monster[this.enB.skill + 8];
   }

   private void allAdd(int var1) {
      boolean var3 = false;
      boolean var4 = false;
      if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
         this.say(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]) + "\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u65e0\u6cd5\u4f7f\u7528\uff01", 0);
      } else {
         boolean var2 = var3;
         if (this.myMonsters[this.select[0][0]].monsterPro[1] < this.myMonsters[this.select[0][0]].monsterPro[3]) {
            var2 = var3;
            if (this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
               this.AddMP(this.myMonsters[this.select[0][0]].monsterPro[3] * var1 / 100, this.myMonsters[this.select[0][0]]);
               var2 = true;
            }
         }

         var3 = var4;
         if (this.myMonsters[this.select[0][0]].monsterPro[0] < this.myMonsters[this.select[0][0]].monsterPro[2]) {
            var3 = var4;
            if (this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
               this.AddHP(this.myMonsters[this.select[0][0]].monsterPro[2] * var1 / 100, this.myMonsters[this.select[0][0]]);
               var3 = true;
            }
         }

         if (!var3 && !var2) {
            if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
               this.AddHP(this.myMonsters[this.select[0][0]].monsterPro[2] * var1 / 100, this.myMonsters[this.select[0][0]]);
            } else {
               this.say(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]) + "\u4e0d\u9700\u8981\u4f7f\u7528\u8fd9\u4e2a\u9053\u5177", 0);
            }
         } else {
            this.useState(0, this.select_it[0]);
         }
      }

   }

   private void arangeMonster() {
      if (this.myMon_length > 1) {
         for(byte var1 = 0; var1 < this.myMon_length - 1; ++var1) {
            for(byte var2 = (byte)(var1 + 1); var2 < this.myMon_length; ++var2) {
               if (this.myMonsters[var1].monster[1] > this.myMonsters[var2].monster[1]) {
                  this.changeMonster(this.myMonsters[var1], this.myMonsters[var2]);
               }
            }
         }
      }

   }

   private boolean bufferAI(Monster var1) {
      boolean var2;
      if (var1.isMonEffect(0)) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   private void changeEffect() {
      if (this.myMonsters[this.select[0][0]].effect != 7) {
         this.myMonsters[this.select[0][0]].effect = 7;
         this.useState(0, this.select_it[0]);
      } else {
         this.say(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]) + "\u6ca1\u6709\u5f02\u5e38\uff01", 0);
      }

   }

   private boolean changeMon(Battle var1, int var2) {
      byte var5 = 0;
      byte var4 = var1.now_id;

      byte var6;
      while(true) {
         byte var3 = (byte)(var1.now_id + 1);
         var1.now_id = var3;
         if (var3 >= var2) {
            var1.now_id = 0;
         }

         var6 = (byte)(var5 + 1);
         if (var6 > var2) {
            break;
         }

         var5 = var6;
         if (var4 != var1.now_id) {
            var5 = var6;
            if (var1.getMon().monsterPro[0] >= 1) {
               break;
            }
         }
      }

      if (var6 > var2) {
         var1.now_id = var4;
      }

      boolean var7;
      if (var6 <= var2) {
         var7 = true;
      } else {
         var7 = false;
      }

      return var7;
   }

   private void changeMonster(Monster var1, Monster var2) {
      Monster var3 = new Monster();
      var3.monster = var1.monster;
      var3.effect = var1.effect;
      var3.monsterPro = var1.monsterPro;
      var1.monster = var2.monster;
      var1.effect = var2.effect;
      var1.monsterPro = var2.monsterPro;
      var2.monster = var3.monster;
      var2.effect = var3.effect;
      var2.monsterPro = var3.monsterPro;
   }

   private boolean changeMy() {
      byte var1 = 1;

      boolean var2;
      while(true) {
         if (var1 >= this.myMon_length) {
            var2 = false;
            break;
         }

         if (this.myMonsters[var1].monsterPro[0] > 0) {
            this.setAimBattle(1);
            this.goVIEW_MONSTER();
            var2 = true;
            break;
         }

         ++var1;
      }

      return var2;
   }

   private void dItemIn(int var1, int var2) {
      while(var2 < this.itemsLength[var1] - 1) {
         this.items[var1][var2] = this.items[var1][var2 + 1];
         ++var2;
      }

      byte[] var3 = this.itemsLength;
      --var3[var1];
      this.items[var1][this.itemsLength[var1]] = null;
      this.items[var1][this.itemsLength[var1]] = new byte[2];
   }

   private void damage(Battle var1, Battle var2, Monster var3, Monster var4, int var5, int var6) {
      int var11 = var3.monster[2];
      int var7 = var4.monster[2];
      byte var14 = 0;
      int var9 = var3.monsterPro[6];
      int var10 = var4.monsterPro[7];
      byte var13 = this.skill[var5][0];
      var7 = var11 - var7;
      byte var8 = 100;
      var9 = var9 * var13 * (1000 - var10 * 5) / 10000;
      var10 /= 10;
      int var12 = var11 / (var13 * 2);
      var11 = (var11 - 1) / 10;
      if (var7 > 10) {
         var5 = 10;
      } else {
         var5 = var7;
         if (var7 < -10) {
            var5 = -10;
         }
      }

      var7 = (var5 * 4 + 100) * (var9 - var10 - var12 + 6 - var11) / 100;
      var13 = var14;
      if (var4.effect == 0) {
         var13 = -30;
      }

      label43: {
         byte var15;
         label47: {
            var9 = (var1.countS[1] + var13 + 100) * var7 / 100;
            var15 = 1;
            if (var3.isBuffRate(9)) {
               Ms.i();
               if (Ms.getRandom(100) < this.inhesion[9]) {
                  break label47;
               }
            }

            if (var4.isMonReel(48)) {
               Ms.i();
               if (Ms.getRandom(100) < this.skill[48][0]) {
                  break label47;
               }
            }

            var14 = var15;
            var5 = var9;
            if (var3.isBuffRate(10)) {
               Ms.i();
               var14 = var15;
               var5 = var9;
               if (Ms.getRandom(100) < this.inhesion[10]) {
                  var5 = var9 * 15 / 10;
                  var14 = 2;
               }
            }
            break label43;
         }

         var5 = var9 >> 1;
         var14 = var15;
      }

      byte var16 = var8;
      if (var4.monster[3] == 1) {
         var16 = var8;
         if (var4.isMonReel(33)) {
            var16 = this.skill[33][0];
         }
      }

      var7 = var5 * var16 / 100;
      var5 = var7;
      if (var7 < 1) {
         var5 = 1;
      }

      var2.addHit(var5, var14, 0);
   }

   private void data_null() {
      this.skill_up = null;
      this.monster_pro = null;
      this.skill = null;
      this.city_name = null;
      this.skill_help = null;
      this.skill_name = null;
      this.NAME = null;
      this.item_help = null;
      this.item_name = null;
   }

   private void delItemEvolve(byte var1) {
      byte var2 = 2;

      byte var3;
      do {
         this.deleteItems(this.monsterMake[var1][var2], this.monsterMake[var1][var2 + 1]);
         var3 = (byte)(var2 + 2);
         var2 = var3;
      } while(var3 < this.monsterMake[var1].length - 1);

   }

   private void delItemSkill(Monster var1) {
      this.say(this.getNameMon(var1.monster[0]) + "\u4e60\u5f97\u6280\u80fd\uff1a" + this.getNameSkill(this.getSkill), 0);
      this.goMY_BAG(2);
      this.deleteItems(this.getSkill + 35 - 25 - 1, 1);
      Ms.i().correctSelect(this.select[0], this.itemsLength[this.selectx], this.list_rows);
   }

   private void doBuffValue(Battle var1) {
      if (var1.getMon().monsterPro[0] >= 1 && var1.getMon().isBuffRate(4)) {
         var1.addHit(-var1.getMon().monsterPro[2] * this.inhesion[4] / 100, 1, 1);
      }

   }

   private void doEffectValue(Battle var1) {
      short var2 = 0;
      if (var1.getMon().isMonEffect(2)) {
         var2 = (short)(var1.getMon().monsterPro[0] / 10);
      } else if (var1.getMon().isMonEffect(5)) {
         var2 = (short)(var1.fs_level * var1.fs_level + 4);
      }

      short var3 = var2;
      if (var1.getMon().isMonReel(3)) {
         var3 = (short)(this.inhesion[3] * var2 / 100 + var2);
      }

      if (var3 != 0) {
         var1.addHit(var3, 1, 0);
      }

   }

   private void drawAnimationBattle(Battle var1, int var2) {
      if (var1.action == 0) {
         byte var4 = (byte)(var1.skill / 5);
         byte var3 = (byte)(var1.skill % 5);
         byte var6 = var4;
         if (var4 > 5) {
            var6 = 5;
         }

         if (var6 == 5) {
            var3 = (byte)(var1.skill - 25);
         }

         if (this.drawMagicC(var6, var6, var3, this.getBXY(this.mini_state, var1.skill, true), this.getBXY(this.mini_state, var1.skill, false), this.mini_state ^ 1)) {
            if (this.mini_state == 1) {
               short[] var5 = var1.getMon().monsterPro;
               var5[1] = (short)(var5[1] - this.getSkillMana(var1.getMon(), var1.skill));
               this.valueMend(var1.getMon());
            }

            this.runHit();
         }
      }

   }

   private void drawBG0(int var1, int var2, int var3, int var4, int var5) {
      Ui.i().fillRect(5422575, var2 - 1, 0, var5 + 13, 360 - 2);
      Ui.i().drawImage(this.imgBG[var1], 320, 0, 17);
      Ui.i().drawK2(var2, var3, 640 - (var2 << 1), 360 - var3, 0);
      Ui.i().drawK1(var2 + 5, var3 + 25 + 7 + var4, var5, 360 - var3 - 36 - var4, 1);
      Ui.i().drawK(var2 + 7, 360 - 50 - 22, var5 - 4, 58, 3);
   }

   private void drawBUY_ITEM() {
      Ui.i().fillRectB();
      Ui.i().drawK2(1, 2, 640 - 2, 360 - 2, 0);
      int var2 = 0;
      byte[] var12;
      if (this.cur_b == 0) {
         Ui.i().drawK1(320 - 29, 6, 58, 28, 4);
         Ui.i().drawString(this.action_str[this.cur_a], 320, 5, 17, 0, 0);
      } else {
         Ui.i().drawK1(this.cur_a * 210 + 70, 6, 70, 28, 4);

         while(var2 < 3) {
            Ui var8 = Ui.i();
            String var7 = this.action_str[var2];
            byte var3;
            if (this.cur_a == var2) {
               var3 = 0;
            } else {
               var3 = 4;
            }

            var8.drawString(var7, var2 * 210 + 80, 5, 0, var3, 0);
            var2 = (byte)(var2 + 1);
         }

         byte var1 = this.pkey.selectMenuX(3, 70, 0, 210, 62);
         if (var1 != -1) {
            this.cur_a = var1;
            var12 = this.select[0];
            this.select[0][0] = 0;
            var12[1] = 0;
         }

         Ui.i().drawTriangle(320, 15, 329, true, true);
      }

      Ui.i().drawK1(6, 37, 640 - 26, this.list_rows * 30 + 6, 1);
      Ui.i().drawK1(6, this.list_rows * 30 + 37 + 16, 640 - 12, 30 * 3, 2);
      if (this.cur_b == 1) {
         var2 = this.itemsLength[this.cur_a];
      } else {
         var2 = this.buyItem[this.cur_a].length;
      }

      byte var4 = (byte)var2;
      byte var5 = this.list_rows;
      var12 = this.select[0];
      byte var10 = this.cur_a;
      byte var9;
      if (this.cur_b == 1) {
         var9 = 2;
      } else {
         var9 = 1;
      }

      this.drawItemList(10, 37 + 3, 640 - 26, var5, var12, var10, var4, var9);
      Ui.i().sliding(640 - 15, 37 + 5, this.list_rows * 30 - 6, this.select[0][0], var4, true);
      var10 = var4;
      byte var11;
      if (var4 > 0) {
         if (this.cur_b == 1) {
            var11 = this.items[this.cur_a][this.select[0][0]][0];
         } else {
            var11 = this.buyItem[this.cur_a][this.select[0][0]];
         }

         if (this.item_help[var11].toString().contains("\u590d\u6d3b\u6b7b\u4ea1\u7684\u5ba0\u7269\u5e76\u4e3a\u5176\u56de\u590d\u751f\u547d\u503c\u7684")) {
            this.showStringM("\u590d\u6d3b\u6b7b\u4ea1\u7684\u5ba0\u7269\u5e76\u4e3a\u5176\u56de\u590d\u751f\u547d\u503c\u768430%,\u8bf7\u52ff\u5728\u5ba0\u7269\u6218\u6597\u4e2d\u8d2d\u4e70!", 320, this.list_rows * 30 + 37 + 18, 10, 3);
            var10 = var11;
         } else {
            this.showStringM(this.item_help[var11].toString(), 320, this.list_rows * 30 + 37 + 18, 10, 3);
            var10 = var11;
         }
      }

      boolean var6;
      if (this.cur_b != 1 && this.cur_a == 2) {
         var6 = true;
      } else {
         var6 = false;
      }

      this.drawMoney(320, 360 - 2, 0, var6);
      if (this.popMenu != -1) {
         if (this.buyOk == 1 && this.cur_b != 1 && this.buyItem[this.cur_a][this.select[0][0]] >= 35 && this.makeLevel[this.buyItem[this.cur_a][this.select[0][0]] - 35] > this.rmsOther[3]) {
            Ui.i().drawKuang(-5, 180 - 50, 640 + 10, 108);
            this.showStringM("\u9700\u8981\u8bad\u7ec3\u5e08" + this.makeLevel[this.buyItem[this.cur_a][this.select[0][0]] - 35] + "\u7ea7\u624d\u80fd\u5b66\u4e60\uff01", 320, 180 - 25, 12, 9);
            this.showString("\u662f\u5426\u8d2d\u4e70\uff1f", 180 + 25, 0);
         } else {
            if (this.cur_b == 1) {
               var9 = 1;
            } else if (this.cur_a == 2) {
               var9 = 16;
            } else {
               var9 = 17;
            }

            this.drawBuy(var10, 320, 180, 150, 50, var9);
         }

         var11 = this.pkey.selectMenuX(2, 0, 0, 320, 360);
         if (var11 != -1) {
            if (var11 == 0) {
               var11 = -3;
            } else {
               var11 = -4;
            }

            Ms.key = var11;
            Ms.keyRepeat = true;
         }
      }

      Ui.i().drawYesNo(true, true);
   }

   private void drawBattleBG() {
      Ui.i().fillRectB();
      Ui.i().drawImage(this.imgBG[this.enB.bg_id], 200, 20, 0);
      Ui var2 = Ui.i();
      Image var1 = this.imgBG[this.myB.bg_id];
      DirectGraphics var3 = dg;
      var2.drawImage(var1, 200, 144, 0, DirectGraphics.FLIP_HORIZONTAL);
      Ui.i().drawK2(2, 19, 195, 250, 0);
   }

   private void drawBattleExp(Monster var1, int var2) {
      Ui.i().drawK0(200, var2, 240, 10, 0);
      short var3;
      if (this.battle_state != -5) {
         var3 = var1.monsterPro[4];
      } else {
         var3 = this.myB.cexp;
      }

      this.drawMonsterHp(var1, 240, var2 + 3, 195, 2, 2, var3);
      Ui.i().drawString("\u7ecf\u9a8c", 200, var2 + 18, 36, 0, 2);
   }

   private void drawBuffList(Monster var1, int var2, int var3, int var4, int var5, int var6, byte[] var7) {
      byte var8 = 0;
      Ui.i().drawListKY(var6, var2, var3, var4, 3, var5, 0, var7[0] - var7[1], 4, 2);

      for(; var8 < 2; ++var8) {
         if (var8 <= 0 || var1.monster[var8 + 16] >= 1) {
            Ui.i().drawUi(49, var2 + 8, var3 + 8 + (var8 - this.select[0][1]) * var5, 0, 0);
            Ui var11 = Ui.i();
            String var10 = this.getNameBuff(var1.monster[var8 + 16]);
            byte var9 = this.select[0][1];
            byte var12;
            if (var7[0] == var8) {
               var12 = 0;
            } else {
               var12 = 3;
            }

            var11.drawString(var10, var2 + 21, var3 + 1 + (var8 - var9) * var5, 0, var12, 0);
            if (this.pkey.isSelect(var2, var3 + 1 + (var8 - var7[1]) * var5, var4, var5)) {
               var7[0] = var8;
            }
         }
      }

   }

   private void drawBuy(int var1, int var2, int var3, int var4, int var5, int var6) {
      Ui.i().drawKuang(var2 - var4, var3 - var5, var4 << 1, var5 << 1);
      byte var7;
      if ((var6 & 16) != 0) {
         var7 = 2;
      } else {
         var7 = 12;
      }

      var5 = var3 - var5 + var7;
      Ui.i().drawString("\u6570\u91cf\uff1a" + this.popMenu + "/" + this.t_length, var2, var5, 17, 3, 0);
      StringBuffer var9 = new StringBuffer();
      if ((var6 & 16) != 0) {
         var9.append("\u9700\u8981\uff1a");
      } else {
         var9.append("\u83b7\u5f97\uff1a");
      }

      var9.append(this.sell_money * this.popMenu);
      if ((var6 & 1) != 0) {
         var9.append("\u91d1");
      } else {
         var9.append("\u5fbd\u7ae0");
      }

      Ui.i().drawString(var9.toString(), var2, var5 + 25 + 4, 17, 6, 0);
      if ((var6 & 16) != 0) {
         Ui.i().drawString("\u73b0\u6709\uff1a" + this.findItem(-2, var1, true), var2, var5 + 58, 17, 3, 0);
      }

      Ui var11 = Ui.i();
      boolean var8;
      if (this.cur_b != 2) {
         var8 = true;
      } else {
         var8 = false;
      }

      var11.drawTriangle1(var2, var3 - 2, var4, true, var8);
      if (this.buyOk == 1) {
         StringBuilder var10 = new StringBuilder("\u662f\u5426");
         String var12;
         if ((var6 & 16) != 0) {
            var12 = "\u8d2d\u4e70";
         } else {
            var12 = "\u5356\u51fa";
         }

         this.showString(var10.append(var12).append("\uff1f").toString(), Constants_H.HEIGHT_H + 25, 0);
      }

   }

   private void drawClipPic(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      short var11 = 1;
      byte var10 = (byte)(var5 / var7);
      short var13 = (short)(2 << var8);

      for(byte var14 = (byte)var11; var14 < var7; var13 = (short)(var13 / 2)) {
         Graphics var12 = g;
         if (var10 - var13 <= 0) {
            var11 = var10;
         } else {
            var11 = var13;
         }

         var12.clipRect(var3 - var14 * var10, var4 - var6, var11, var6 + 20);
         this.drawCartoonOne(var2, var2, var1 * 3, var3, var4, true, var9);
         g.setClip(0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
         var12 = g;
         if (var10 - var13 <= 0) {
            var11 = var10;
         } else {
            var11 = var13;
         }

         var12.clipRect((var14 - 1) * var10 + var3, var4 - var6, var11, var6 + 20);
         this.drawCartoonOne(var2, var2, var1 * 3, var3, var4, true, var9);
         g.setClip(0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
         ++var14;
      }

   }

   private void drawColorLine(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if ((-16777216 & var9) != 0) {
         g.setColor(var9);
         g.fillRect(var1, var2, var3, var4);
      }

      g.setColor(var10);
      byte var12 = 1;
      byte var13 = 1;
      if (var8 == 1) {
         var9 = var6;
         var6 = var2;
         var8 = var13;

         while(var6 < var2 + var4) {
            g.fillRect(var1, var6, var3, var5);
            var10 = var6 + var5 + var8;
            int var11 = var5 - var7;
            var6 = var10;
            var5 = var11;
            if (var11 <= 0) {
               --var9;
               var5 = var8;
               if (var8 < var9) {
                  var5 = var8 + 1;
               }

               byte var14 = 1;
               var8 = var5;
               var6 = var10;
               var5 = var14;
            }
         }
      } else if (var8 == 2) {
         var4 += var2;
         var8 = var6;
         var6 = var12;

         while(var4 > var2) {
            g.fillRect(var1, var4 - var5, var3, var5);
            var9 = var4 - var5 - var6;
            var10 = var5 - var7;
            var4 = var9;
            var5 = var10;
            if (var10 <= 0) {
               --var8;
               var4 = var6;
               if (var6 < var8) {
                  var4 = var6 + 1;
               }

               var5 = 1;
               var6 = var4;
               var4 = var9;
            }
         }
      }

   }

   private void drawDarkScreen() {
      this.drawColorLine(0, 0, 640, 360, this.b_c + 1, 6, 1, 2, 16777215, 4802889);
   }

   private void drawEffectImage(Monster var1, int var2, int var3) {
      if (var1.effect > -1 && var1.effect < 7 && var1.effect_time > 0) {
         Ui var5 = Ui.i();
         Image var4 = this.effectImage[var1.effect];
         Graphics var6 = g;
         var6 = g;
         var5.drawImage(var4, var2, var3, 8 | 32);
         Ui var8 = Ui.i();
         String var7 = "" + var1.effect_time;
         Graphics var9 = g;
         var9 = g;
         var8.drawNum(var7, var2, var3, 8 | 32, 0);
      }

   }

   private void drawEnemy() {
      this.drawEffectImage(this.enB.getMon(), 435, 40);
      if (this.enB.getMon().monsterPro[0] >= 1 || this.enB.dead != 1) {
         byte var4 = this.mList_id[this.enB.getMon().monster[0]][1];
         short var3 = this.enB.action;
         byte var1;
         if (this.enB.ceff[0] != 0) {
            var1 = 3;
         } else {
            var1 = 0;
         }

         short var2;
         if (this.enB.ceff[0] != 0) {
            var2 = -3;
         } else {
            var2 = 0;
         }

         boolean var5;
         if (this.enB.action == 0) {
            var5 = true;
         } else {
            var5 = false;
         }

         if (this.drawCartoonOne(0, 0, var4 * 3 + var3, var1 + 377, var2 + 97, var5, 0)) {
            if (this.enB.getMon().monsterPro[0] < 1) {
               this.enB.action = 2;
               this.enB.dead = 1;
            } else if (this.enB.dead != 1) {
               this.enB.action = 0;
            }
         }

         this.enB.ceff[0] = (byte)Ms.i().mathSpeedN(this.enB.ceff[0], 0, 1, true);
         this.drawMonsterHp(this.enB.getMon(), 352, 97, 50, 0, 1, this.enB.chp);
         Battle var7 = this.enB;
         Ms var6 = Ms.i();
         var3 = this.enB.chp;
         var2 = this.enB.getMon().monsterPro[0];
         if (this.enB.chp < this.enB.getMon().monsterPro[0]) {
            var1 = 20;
         } else {
            var1 = 6;
         }

         var7.chp = var6.mathSpeedN(var3, var2, var1, true);
      }

   }

   private void drawEnemyState() {
      Ui.i().drawK(10, 25, 179, 110, 2);
      Ui.i().drawKuang(10 + 2, 25 + 2, 147, 33);
      if (this.enB.getMon().monster[3] != -1) {
         Ui.i().drawUi(this.enB.getMon().monster[3] + 5, 10 + 16, 25 + 16, 3, 0);
      }

      Ui.i().drawString(this.getNameMon(this.enB.getMon().monster[0]).toString(), 10 + 75 + 14, 25 + 1, 17, 4, 2);
      Ui.i().drawNum(this.enB.getMon().monster[2] + "\u7ea7", 10 + 125 + 27, 25 + 20, 0, 0);
      Ui.i().drawK0(10 + 2, 25 + 25 + 11, 62, 14, 4);
      Ui.i().drawUi(34, 10 + 4, 25 + 25 + 12, 0, 0);
      Ui.i().drawNum(this.enB.countS[0] + 100 + "%", 10 + 60, 25 + 25 + 24, 1, 1);
      Ui.i().drawString("\u5ba0\u7269\u6863\u6b21", 10 + 2, 25 + 25 + 30, 20, 4, 2);
      this.drawMonKind(this.enB.getMon().monster[4], 10 + 100 + 8, 25 + 25 + 38, 0);
      Ui var3 = Ui.i();
      String var2;
      if (this.monInfoList[this.enB.getMon().monster[0]] == 2) {
         var2 = "\u5df2\u6355\u83b7";
      } else {
         var2 = "\u672a\u6355\u83b7";
      }

      var3.drawString(var2, 10 + 2, 25 + 50 + 32, 20, 4, 2);
      Ui var4 = Ui.i();
      byte var1;
      if (this.monInfoList[this.enB.getMon().monster[0]] == 2) {
         var1 = 25;
      } else {
         var1 = 26;
      }

      var4.drawUi(var1, 10 + 100 + 4, 25 + 50 + 40, 0, 0);
   }

   private void drawEvolveMake(int var1, int var2, int var3, int var4) {
      byte var6 = 2;
      byte var5 = 0;

      byte var7;
      byte var8;
      do {
         Ui.i().drawString(this.getNameItem(this.monsterMake[var1][var6]) + "\uff08" + this.findItem(-2, this.monsterMake[var1][var6], true) + "/" + this.monsterMake[var1][var6 + 1] + "\uff09", var2, var3 + var5 * var4, 0, 3, 0);
         var8 = (byte)(var6 + 2);
         var7 = (byte)(var5 + 1);
         var6 = var8;
         var5 = var7;
      } while(var8 < this.monsterMake[var1].length - 1);

      if (this.monsterMake[var1][0] > 0) {
         byte var9 = this.findItem(-2, 34, true);
         if (var9 > 0) {
            Ui.i().drawString(this.getNameItem(34) + "\uff08" + var9 + "/" + 1 + "\uff09", var2, var3 + var7 * var4, 0, -1, 0);
         }
      }

   }

   private boolean drawHitOne(Battle var1, Battle var2, int var3, int var4) {
      boolean var10 = true;
      this.strHit = "";

      for(byte var6 = 0; var6 < var1.hit.length; ++var6) {
         if (var1.hit[var6][4] < this.zb.length) {
            boolean var11 = false;
            String var12;
            if (var1.hit[var6][0] == -1) {
               this.strHit = "\u95ea\u907f";
            } else if (var1.hit[var6][0] == -2) {
               this.strHit = "\u5fe0\u8bda\u5ea6\u51cf\u5c11";
            } else {
               if (var1.hit[var6][1] > -1) {
                  var12 = "-";
               } else {
                  var12 = "+";
               }

               StringBuilder var15 = new StringBuilder(String.valueOf(var12));
               Ms.i();
               this.strHit = var15.append(Ms.abs(var1.hit[var6][1])).toString();
            }

            byte var7;
            short var8;
            short var9;
            Ui var13;
            if (var1.hit[var6][0] > 0 && var1.hit[var6][0] < 4) {
               if (var1.hit[var6][0] == 2) {
                  Ui.i().drawUi(32, var1.hit[var6][2] + var3 + (this.strHit.length() >> 1) * 14 + 15, var1.hit[var6][3] + var4 + 8, 40, 0);
                  Ui.i().drawUi(33, var1.hit[var6][2] + var3 + (this.strHit.length() >> 1) * 14 + 15, var1.hit[var6][3] + var4 + 8, 36, 0);
               }

               var13 = Ui.i();
               var12 = this.strHit;
               var9 = var1.hit[var6][2];
               var8 = var1.hit[var6][3];
               if (var1.hit[var6][0] == 2) {
                  var7 = 2;
               } else {
                  var7 = 1;
               }

               var13.drawNum(var12, var9 + var3, var8 + var4, 0, var7);
            } else if (var1.hit[var6][0] < 0 || var1.hit[var6][0] == 4) {
               var13 = Ui.i();
               var12 = this.strHit;
               var8 = var1.hit[var6][2];
               var9 = var1.hit[var6][3];
               if (var1.hit[var6][0] == 4) {
                  var7 = 1;
               } else {
                  var7 = 0;
               }

               var13.drawString(var12, var8 + var3, var9 + var4, 0, var7, 2);
            }

            byte var14;
            short[] var16;
            if (var6 == 0) {
               var16 = var1.hit[var6];
               var8 = var16[2];
               if (this.mini_state == 1) {
                  var14 = 1;
               } else {
                  var14 = -1;
               }

               var16[2] = (short)(var8 + var14);
               var16 = var1.hit[var6];
               var16[3] = (short)(var16[3] + this.zb[var1.hit[var6][4]]);
            } else if (var6 == 1) {
               var16 = var1.hit[var6];
               var8 = var16[2];
               if (this.mini_state == 1) {
                  var14 = 1;
               } else {
                  var14 = -1;
               }

               var16[2] = (short)(var8 + var14);
               var16 = var1.hit[var6];
               var16[3] = (short)(var16[3] + this.zb[var1.hit[var6][4]]);
            } else if (var6 == 2) {
               var16 = var1.hit[var6];
               var16[3] = (short)(var16[3] - var1.hit[var6][4] / 3);
            }

            var16 = var1.hit[var6];
            short var5 = (short)(var16[4] + 1);
            var16[4] = var5;
            var10 = var11;
            if (var5 == 1) {
               if (var1.hit[var6][0] == 4) {
                  var16 = var1.getMon().monsterPro;
                  var16[1] -= var1.hit[var6][1];
                  var10 = var11;
               } else if (var1.hit[var6][0] == -2 && this.mini_state == 0 && !var1.getMon().isMonReel(40)) {
                  byte[] var17 = var1.getMon().monster;
                  var17[6] = (byte)(var17[6] - var1.hit[var6][1]);
                  this.getHitCoefficient(var1, var1.getMon(), var2.getMon());
                  var10 = var11;
               } else {
                  var10 = var11;
                  if (var1.hit[var6][0] > 0) {
                     var16 = var1.getMon().monsterPro;
                     var16[0] -= var1.hit[var6][1];
                     var10 = var11;
                  }
               }
            }
         }
      }

      this.valueMend(var1.getMon());
      return var10;
   }

   private void drawInfoBG(int var1, int var2) {
      Ui.i().fillRect(0, 0, 0, 640, var2);
      g.fillRect(0, 360 - var2, 640, var2);
      g.fillRect(0, var2 - 2, 640, var2);
      Ui.i().fillRect(15400191, 0, 2, 640, var2 - 4);
      g.fillRect(0, 360 - var2 + 2, 640, var2 - 4);
      g.fillRect(0, var2, 640, var2 - 4);
   }

   private void drawInfoList(int var1, int var2, int var3, int var4, int var5, int var6, byte[] var7) {
      Ui.i().drawListKY(var5, var1 - 4, var2 + 5, var3, 4, var4 + 4, 2, var7[0] - var7[1], 4, 2);

      for(byte var8 = var7[1]; var8 < var7[1] + var5 && var8 < var6; ++var8) {
         Ui var12 = Ui.i();
         byte var9;
         if (this.monInfoList[this.monInfo_dir[this.cur_a][var8]] == 2) {
            var9 = 25;
         } else {
            var9 = 48;
         }

         byte var10 = var7[1];
         Graphics var13 = g;
         var13 = g;
         var12.drawUi(var9, var1 - 10, (var8 - var10) * (var4 + 4 + 2) + var2 + 11, 8 | 16, 0);
         byte var15;
         if (var7[0] == var8) {
            var15 = 0;
         } else if (this.monInfoList[this.monInfo_dir[this.cur_a][var8]] != 0) {
            var15 = 3;
         } else {
            var15 = -1;
         }

         var15 = (byte)var15;
         Ui var17 = Ui.i();
         String var16;
         if (this.infoStart + var8 + 1 < 10) {
            var16 = "0";
         } else {
            var16 = "";
         }

         StringBuilder var14 = (new StringBuilder(String.valueOf(var16))).append(this.infoStart + var8 + 1).append(" ");
         if (this.monInfoList[this.monInfo_dir[this.cur_a][var8]] != 0) {
            var16 = this.getNameMon(this.monInfo_dir[this.cur_a][var8]);
         } else {
            var16 = "\u672a\u77e5\u5ba0\u7269";
         }

         var17.drawString(var14.append(var16).toString(), var1 + 10, (var8 - var7[1]) * (var4 + 4 + 2) + var2 + 5, 0, var15, 0);
         var12 = Ui.i();
         String var18 = this.getInfoType(this.monAppearMap[this.monInfo_dir[this.cur_a][var8]][0]);
         int var11 = Constants_H.WIDTH;
         var10 = var7[1];
         Graphics var19 = g;
         var19 = g;
         var12.drawString(var18, var11 - 25 - 15, (var8 - var10) * (var4 + 4 + 2) + var2 + 5, 8 | 16, var15, 0);
         if (this.pkey.isSelect(var1, (var8 - var7[1]) * (var4 + 4 + 2) + var2 + 5, var3, var4 + 4 + 2)) {
            if (var7[0] == var8) {
               this.pkey.setKey5();
            } else {
               var7[0] = var8;
               if (var8 - var7[1] == 0 && var7[1] > 0) {
                  --var7[1];
               } else if (var8 - var7[1] == var5 - 1 && var7[1] + var5 < var6) {
                  ++var7[1];
               }
            }
         }
      }

      Ui.i().sliding(var1 + var3 + 5, var2 + 10, (var4 + 4 + 2) * var5 - 4, var7[0], var6, false);
   }

   private void drawItemList(int var1, int var2, int var3, int var4, byte[] var5, int var6, int var7, int var8) {
      byte var9 = var5[1];
      Ui.i().drawListKY(var4, var1 - 4, var2, var3, 4, 30 + 1, -1, var5[0] - var5[1], 4, 2);

      for(; var9 < var5[1] + var4; ++var9) {
         if (var9 < var7) {
            byte var10;
            byte var11;
            Graphics var14;
            String var15;
            Ui var17;
            if (var8 != 0 && var8 != 2) {
               this.drawItem(this.buyItem[var6][var9], var1 + 2, var2 + 4 + (var9 - var5[1]) * 30, 0);
               if (var5[0] == var9) {
                  var10 = 0;
               } else {
                  var10 = 3;
               }

               var11 = (byte)var10;
               Ui.i().drawString(this.getNameItem(this.buyItem[var6][var9]), var1 + 20, var2 + (var9 - var5[1]) * 30, 0, var11, 0);
               if (var6 == 2) {
                  var15 = "\u5fbd\u7ae0";
               } else {
                  var15 = "\u91d1";
               }

               var17 = Ui.i();
               var15 = this.getPrice(var6, var9, true) + var15;
               byte var16 = var5[1];
               var14 = g;
               var14 = g;
               var17.drawString(var15, var1 + var3 - 12, (var9 - var16) * 30 + var2 + 1, 8 | 16, var11, 0);
            } else {
               this.drawItem(this.items[var6][var9][0], var1 + 3, var2 + 4 + (var9 - var5[1]) * 30, 0);
               Ui var12 = Ui.i();
               String var13 = this.getNameItem(this.items[var6][var9][0]);
               var11 = var5[1];
               if (var5[0] == var9) {
                  var10 = 0;
               } else {
                  var10 = 3;
               }

               var12.drawString(var13, var1 + 21, var2 + 1 + (var9 - var11) * 30, 0, var10, 0);
               if (var8 == 2) {
                  var15 = this.getPrice(var6, this.items[var6][var9][0], false) + "\u91d1";
               } else {
                  var15 = "x" + this.items[var6][var9][1];
               }

               var17 = Ui.i();
               var11 = var5[1];
               var14 = g;
               var14 = g;
               if (var5[0] == var9) {
                  var10 = 0;
               } else {
                  var10 = 3;
               }

               var17.drawString(var15, var1 + var3 - 12, var2 + 1 + (var9 - var11) * 30, 8 | 16, var10, 0);
            }

            if (this.popMenu == -1 && this.say_c == 0 && this.pkey.isSelect(var1, (var9 - var5[1]) * 30 + var2, Constants_H.WIDTH, 30)) {
               if (var5[0] == var9) {
                  this.pkey.setKey5();
               } else {
                  var5[0] = var9;
                  if (var9 - var5[1] == 0 && var5[1] > 0) {
                     --var5[1];
                  } else if (var9 - var5[1] == var4 - 1 && var5[1] + var4 < var7) {
                     ++var5[1];
                  }

                  this.select_it[this.selectx] = var5[0];
                  this.select_st[this.selectx] = var5[1];
               }
            }
         }
      }

   }

   private void drawLIST_INFO() {
      Ui.i().fillRectB();
      this.drawInfoBG(24, 35);
      Ui var6 = Ui.i();
      String var7 = "\u53d1\u73b0\u5ea6 " + Ms.i().getPrecision(this.monInfoList[102] * 1000 / 102) + "%";
      Graphics var8 = g;
      var8 = g;
      var6.drawString(var7, 640 - 12, 34, 8 | 16, 3, 1);
      Ui.i().drawString(this.monsterT[this.cur_a].toString(), 28, 34, 0, 1, 2);
      var6 = Ui.i();
      var7 = "\u6355\u6349\u79cd\u7c7b " + this.monInfoList[103] + "/" + 100;
      var8 = g;
      var8 = g;
      var6.drawString(var7, 320, 360 + 1, 1 | 32, 3, 1);
      byte var1 = this.pkey.selectMenuX(5, 100, 0, 640 / 6, 35);
      byte var2;
      if (var1 != -1) {
         this.cur_a = var1;
         this.infoStart = 0;
         if (this.cur_a > 0) {
            for(var2 = 0; var2 < this.cur_a; ++var2) {
               this.infoStart = (byte)(this.infoStart + this.monInfo_dir[var2].length);
            }
         }

         this.t_length = (byte)this.monInfo_dir[this.cur_a].length;
         byte[] var9 = this.select[0];
         this.select[0][1] = 0;
         var9[0] = 0;
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var6 = Ui.i();
         byte var3;
         if (this.cur_a == var2) {
            var3 = 5;
         } else {
            var3 = 0;
         }

         int var4 = (var2 + 1) * 614 / 6;
         Graphics var10 = g;
         var10 = g;
         var6.drawUi(var3 + var2, var4 + 18, 12, 4 | 2, 0);
      }

      this.drawInfoList(32, 67, 640 - 50, 29, this.list_rows, this.t_length, this.select[0]);
      Ui.i().drawTriangle(320 + 10, 12, 331, true, true);
      var6 = Ui.i();
      boolean var5;
      if (this.monInfoList[this.getMonInfo_dir()] != 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      var6.drawYesNo(var5, true);
   }

   private void drawMONSTER_INFO(int var1) {
      int var3 = 320 - 140;
      int var4 = var3 + 12;
      Ui.i().fillRectB();
      Ui.i().drawK2(var3, 2, 280, 360 - 2, 0);
      Ui.i().drawK1(320 - 29 * 4 - 4, 6, 29 * 8, 29, 4);
      Ui.i().drawK1(var4, 35, 100, 90, 1);
      Ui.i().drawK1(29 + 192 + 8, 35 + 90 + 4, 280 - (29 + 25), 29 * 4, 1);
      Ui.i().drawK1(var4, 35 + 90 + 4, 29, 29 * 4, 3);
      Ui.i().drawK1(var4, 360 - 13 - 29 * 3, 640 - (var4 << 1) + 2, 29 * 3 + 10, 2);
      Ui.i().drawYesNo(false, true);
      Ui.i().drawUi(this.cur_a + 5, var4 + 2, 35 + 2, 0, 0);
      Log.e("sk", "drawUi");
      Ui var9 = Ui.i();
      StringBuilder var8 = (new StringBuilder(String.valueOf(this.getNameMon(var1)))).append("\uff08");
      String var7;
      if (this.monInfoList[var1] == 2) {
         var7 = "\u5df2\u6355\u83b7";
      } else {
         var7 = "\u672a\u6355\u83b7";
      }

      var9.drawString(var8.append(var7).append("\uff09").toString(), 320, 6, 17, 0, 0);
      byte var5 = this.mList_id[var1][1];
      byte var10 = this.mon_action;
      boolean var6;
      if (this.mon_action == 1) {
         var6 = false;
      } else {
         var6 = true;
      }

      if (this.drawCartoonOne(1, 1, var5 * 3 + var10, var4 + 50, 35 + 90 - 10, var6, 0)) {
         this.mon_action = 0;
      }

      Ui.i().drawString("\u53d1\u73b0\u5730\u70b9", 100 + 192 + 5, 35, 0, 1, 1);
      if (this.monAppearMap[var1][0] > -1) {
         for(var10 = 0; var10 < this.monAppearMap[var1].length; ++var10) {
            Ui.i().drawString(this.city_name[this.monAppearMap[var1][var10]].toString(), 100 + 192 + 5, 35 + (var10 + 1) * 25, 0, 1, 0);
         }
      } else {
         Ui.i().drawString("\u672a\u77e5", 100 + 192 + 5, 35 + 25, 0, 1, 0);
      }

      Ui.i().drawString("\u8fdb", var4 + 12 + 2, 35 + 90 + 20, 17, 3, 1);
      Ui.i().drawString("\u5316", var4 + 12 + 2, 29 + 153, 17, 3, 1);
      Ui.i().drawListKY(3, 29 + 192 + 8, 35 + 90 + 10, 280 - (29 + 25), 3, 29 + 4, 0, -1, 4, 2);
      byte var11 = 2;

      for(var10 = 0; var11 < 7; ++var10) {
         Ui var12 = Ui.i();
         StringBuilder var13 = new StringBuilder("\u6750\u6599\uff1a");
         if (this.monsterMake[var1].length != 0 && var11 < this.monsterMake[var1].length) {
            var7 = this.getNameItem(this.monsterMake[var1][var11]) + " x" + this.monsterMake[var1][var11 + 1];
         } else {
            var7 = "";
         }

         var12.drawString(var13.append(var7).toString(), 29 + 192 + 14, var10 * 33 + 137, 0, 3, 0);
         var11 = (byte)(var11 + 2);
      }

      this.showStringM(this.getNameMonsterInfo(var1), 320, 360 - 12 - 29 * 3, 10, 3);
      byte var2 = (byte)(this.mon_action_c + 1);
      this.mon_action_c = var2;
      if (var2 > 50) {
         this.mon_action_c = 0;
         this.mon_action = 1;
      }

   }

   private void drawMONSTER_UI(Monster[] var1) {
      int var2 = 320 - 140;
      Ui.i().fillRectB();
      Ui.i().drawK2(var2, 2, 280, 360 - 2, 0);
      var2 += 6;
      Ui.i().drawK1(var2, 5 + 6, 118, 116, 1);
      int var3;
      short var4;
      boolean var5;
      if (this.t_length != 0) {
         this.drawMonsterHp(var1[this.select[0][0]], var2 + 30, 5, 74, 2, 2, var1[this.select[0][0]].monsterPro[4]);
         Ui.i().drawNum(var1[this.select[0][0]].monster[2] + "\u7ea7", var2 + 2, 5 + 10, 0, 0);
         Ui.i().drawUi(var1[this.select[0][0]].monster[3] + 5, var2 + 9, 5 + 11, 17, 0);
         var4 = this.mList_id[var1[this.select[0][0]].monster[0]][1];
         var3 = this.mon_action;
         if (this.mon_action == 1) {
            var5 = false;
         } else {
            var5 = true;
         }

         if (this.drawCartoonOne(1, 1, var4 * 3 + var3, 248, 111, var5, 0)) {
            this.mon_action = 0;
         }
      }

      var3 = 5 + 138;
      var4 = (short)(640 - (var2 << 1));
      Ui.i().drawK1(var2, var3, var4, 360 - 116 - 32, 1);
      Ui.i().drawK(var2 + 8, var3 + 10, var4 - 16, 33, 3);
      Ui.i().drawK(var2 + 8, var3 + 150 + 11, var4 - 16, 33, 3);
      if (this.t_length != 0) {
         this.gogoWord(this.getNameMonsterInfo(var1[this.select[0][0]].monster[0]), var2 + 9, var3 + 150 + 13, var4 - 70, 0, 1, 2);
         this.drawMonsterFealty(var1[this.select[0][0]], var2 + 2, var3 - 14);
         Ui.i().drawString(this.monsterT[var1[this.select[0][0]].monster[3]].toString(), var2 + 25, var3 + 12, 0, 0, 1);
         if (var1[this.select[0][0]].monster[5] == 0) {
            Ui.i().drawString("\u4e0d\u53ef\u8fdb\u5316", var2 + 115, var3 + 12, 0, 0, 1);
         } else {
            Ui.i().drawString("\u53ef\u8fdb\u5316" + var1[this.select[0][0]].monster[5] + "\u6b21", var2 + 115, var3 + 12, 0, 0, 1);
         }
      }

      this.drawMonPro(var1, var2, var3);
      if (this.t_length != 0) {
         this.drawMonList(var1, 280 + 180 - 75 - 15 + 2, 0 + 13, this.list_rows, this.t_length, this.select[0]);
      }

      Ui.i().sliding(280 + 180 - 17, 0 + 12, 116 + 6, this.select[0][0], this.t_length, true);
      Ui var6 = Ui.i();
      StringBuilder var7 = (new StringBuilder(String.valueOf(this.t_length))).append("/");
      byte var9;
      if (this.mini_state == 6) {
         var9 = this.max_monsters;
      } else {
         var9 = this.max_takes;
      }

      var6.drawNum(var7.append(var9).toString(), 280 + 180 - 40, 0 + 12, 0, 0);
      if (this.popMenu != -1) {
         this.drawSelectMenu(this.about_d, 320 - 25, 30, 75, 2, 0, this.popMenu);
         if (this.buyOk == 1) {
            this.showString(this.gogoString, 180 - 25, 0);
         }
      }

      Ui var8 = Ui.i();
      if (this.t_length != 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      var8.drawYesNo(var5, true);
   }

   private void drawMY_BAG(int var1, int var2, int var3, int var4) {
      byte var6 = (byte)(this.action_str.length - 1);
      Ui.i().fillRectB();
      Ui.i().drawK2(var1 + 1, var2 + 3, var3 - 2, var4 - 3, 0);
      Ui.i().drawK1(var1 + 5, var2 + 25 + 14, var3 - 23, this.list_rows * 31, 1);
      Ui.i().drawK1(var1 + 5, var2 + 25 + 20 + this.list_rows * 31, var3 - 10, 90, 2);
      if (var6 == 0) {
         Ui.i().drawK1((var3 >> 1) + var1 - 25 - 9, var2 + 8, 66, 28, 4);
         Ui.i().drawString(this.action_str[var6], (var3 >> 1) + var1, var2 + 7, 17, 0, 0);
         Log.e("sk", "drawMY_BAG");
      } else {
         Ui.i().drawK1((this.selectx + 1) * var3 / 5 + var1 - 22, var2 + 8, 70, 28, 4);

         while(var6 > -1) {
            Ui var11 = Ui.i();
            String var10 = this.action_str[var6];
            int var8 = (var6 + 1) * var3 / 5;
            byte var7;
            if (this.selectx == var6) {
               var7 = 0;
            } else {
               var7 = 1;
            }

            var11.drawString(var10, var8 + var1 - 14, var2 + 7, 0, var7, 0);
            --var6;
         }

         Ui.i().drawTriangle((var3 >> 1) + var1, var2 + 14, 354, true, true);
         if (this.popMenu == -1) {
            byte var5 = this.pkey.selectMenuX(4, 0, 0, var3 / 4, 35);
            if (var5 != -1) {
               this.selectx = var5;
               this.select[0][1] = this.select_st[this.selectx];
               this.select[0][0] = this.select_it[this.selectx];
            }
         }
      }

      this.drawItemList(var1 + 9, var2 + 25 + 17, var3 - 23, this.list_rows, this.select[0], this.selectx, this.itemsLength[this.selectx], 0);
      Ui.i().sliding(var1 + var3 - 15, var2 + 25 + 17, this.list_rows * 31 - 6, this.select[0][0], this.itemsLength[this.selectx], true);
      if (this.itemsLength[this.selectx] > 0) {
         this.showStringM(this.item_help[this.items[this.selectx][this.select[0][0]][0]].toString(), var1 + (var3 >> 1), this.list_rows * 31 + var2 + 25 + 22, 10, 3);
      }

      boolean var9;
      if (this.selectx == 2) {
         var9 = true;
      } else {
         var9 = false;
      }

      this.drawMoney((var3 >> 1) + var1, var2 + var4 - 2, 0, var9);
      Ui var12 = Ui.i();
      if (this.itemsLength[this.selectx] == 0) {
         var9 = false;
      } else {
         var9 = true;
      }

      var12.drawYesNo(var9, true);
      if (this.popMenu != -1) {
         this.drawSelectMenu(this.about_a, (var3 >> 1) + var1 - 25 - 8, 50, 75, 2, 0, this.popMenu);
      }

   }

   private void drawMagicUI(Monster var1) {
      Ui.i().fillRect(5422575, 0, 0, 640, 360);
      int var3 = 1 + 180;
      this.drawBG0(this.bg_c, var3, 108, 0, 267);
      if (this.pkey.selectMenuX(2, var3, 108, 120, 29) != -1) {
         Ms.key = -3;
         Ms.keyRepeat = true;
      }

      Ui var8 = Ui.i();
      short var2;
      if (this.popMenu == 0) {
         var2 = -143;
      } else {
         var2 = 21;
      }

      var8.drawK1(320 + var2, 108 + 3, 123, 27, 4);
      var8 = Ui.i();
      Graphics var9 = g;
      var9 = g;
      byte var10;
      if (this.popMenu == 0) {
         var10 = 0;
      } else {
         var10 = 1;
      }

      var8.drawString("\u666e\u901a\u6280\u80fd", 320 - 25, 108 + 1, 8 | 16, var10, 0);
      var8 = Ui.i();
      if (this.popMenu == 0) {
         var10 = 1;
      } else {
         var10 = 0;
      }

      var8.drawString("\u5929\u8d4b\u6280\u80fd", 320 + 25, 108 + 1, 0, var10, 0);
      byte var12 = this.mList_id[var1.monster[0]][1];
      byte var5 = this.mon_action;
      short var6 = this.move_x;
      short var4 = this.move_y;
      boolean var7;
      if (this.mon_action == 1) {
         var7 = false;
      } else {
         var7 = true;
      }

      if (this.drawCartoonOne(1, 1, var12 * 3 + var5, 377 - var6, 97 - var4, var7, 0)) {
         this.mon_action = 0;
      }

      this.move_x = Ms.i().mathSpeedDown(this.move_x, 3, false);
      this.move_y = Ms.i().mathSpeedDown(this.move_y, 3, false);
      if (this.popMenu == 0) {
         this.drawSkillList(var3 + 7, 108 + 25 + 12, 267 - 29, 31, 5, this.select[0]);
         if (this.skill_list[this.select[0][0]] != -1) {
            this.gogoWord(this.skill_help[this.skill_list[this.select[0][0]]].toString(), var3 + 10, 360 - 25 - 22, 200, 0, 1, 2);
         }
      } else {
         this.drawBuffList(var1, var3 + 7, 108 + 25 + 12, 267 - 29, 31, 5, this.select[0]);
         if (var1.monster[this.select[0][0] + 16] > 0) {
            this.showStringM(this.buff_help[var1.monster[this.select[0][0] + 16]].toString(), 320, 360 - 50 - 22, 9, 0);
         }
      }

      var8 = Ui.i();
      byte var11 = this.select[0][0];
      if (this.popMenu == 0) {
         var12 = this.skill_list[8];
      } else if (var1.monster[this.select[0][0] + 16] > 0) {
         var12 = 2;
      } else {
         var12 = 1;
      }

      var8.sliding(267 + 180 - 13, 108 + 25 + 13, 360 - 108 - 120, var11, var12, true);
      if (this.mini_state != 13) {
         Ui.i().drawTriangle(320, 108 + 12, 150, true, true);
         Ui.i().drawYesNo(false, true);
      } else {
         Ui.i().drawYesNo(true, true);
      }

   }

   private void drawMonKind(byte var1, int var2, int var3, int var4) {
      for(byte var5 = 0; var5 < 5; ++var5) {
         Ui var7 = Ui.i();
         byte var6;
         if (var1 > var5) {
            var6 = 23;
         } else {
            var6 = 24;
         }

         var7.drawUi(var6, var5 * 14 + var2, var3, var4, 0);
      }

   }

   private void drawMonList(Monster[] var1, int var2, int var3, int var4, int var5, byte[] var6) {
      byte var8 = var6[1];
      byte var7 = var8;
      if (this.mini_state != 6) {
         Ui var11 = Ui.i();
         Graphics var12 = g;
         var12 = g;
         var11.drawUi(34, var2 - 50 - 5, var3 + 2, 8 | 16, 0);
         var7 = var8;
      }

      for(; var7 < var6[1] + var4 && var7 < var5; ++var7) {
         if (var6[0] == var7) {
            Ui.i().drawK(var2 - 50, (var7 - var6[1]) * 29 + var3, 108, 26, 1);
         }

         Ui var14 = Ui.i();
         String var13 = this.getNameMon(var1[var7].monster[0]).toString();
         byte var10 = var6[1];
         byte var9;
         if (var6[0] == var7) {
            var9 = 0;
         } else {
            var9 = 1;
         }

         var14.drawString(var13, var2 + 4, var3 - 2 + (var7 - var10) * 29, 17, var9, 1);
         if (this.popMenu == -1 && this.pkey.isSelect(var2 - 50, (var7 - var6[1]) * 29 + var3, 100, 26)) {
            if (var6[0] == var7) {
               Ms.key = 53;
               Ms.keyRepeat = true;
            } else {
               var6[0] = var7;
               if (var7 - var6[1] == 0 && var6[1] > 0) {
                  --var6[1];
               } else if (var7 - var6[1] == var4 - 1 && var6[1] + var4 < var5) {
                  ++var6[1];
               }

               this.initMonStream(2, this.mList_id[var1[var6[0]].monster[0]][0], 1);
               this.setShowPro(var1[var6[0]]);
               this.introT = Constants_H.WIDTH_H;
               this.introX = Constants_H.WIDTH_H;
            }
         }
      }

   }

   private void drawMonPro(Monster[] var1, int var2, int var3) {
      Ui.i().drawStringY(this.about_a, var2 + 18, var3 + 44, 0, 3, 31, 3, 0);
      Ui.i().drawStringY(this.about_b, var2 + 160, var3 + 44, 0, 3, 31, 3, 0);
      if (this.t_length != 0) {
         Ui.i().drawStringY(this.about_c, var2 + 165 + 50, var3 + 44, 0, 3, 31, -1, 0);
         this.drawMonsterHp(var1[this.select[0][0]], var2 + 19 + 50 + 4, var3 + 59, 48, 0, 0, var1[this.select[0][0]].monsterPro[0]);
         this.drawMonsterHp(var1[this.select[0][0]], var2 + 19 + 50 + 4, var3 + 59 + 25 + 3, 48, 1, 0, var1[this.select[0][0]].monsterPro[1]);
         this.drawMonKind(var1[this.select[0][0]].monster[4], var2 + 19 + 50 + 4, var3 + 76 + 28, 0);
      }

   }

   private void drawMonsterFealty(Monster var1, int var2, int var3) {
      byte var4 = var1.monster[4];
      byte[] var5 = this.initFealty;
      if (var4 < 4) {
         var4 = 0;
      } else {
         var4 = 1;
      }

      this.drawFealty((byte)(var5[var4] / 20), (byte)(var1.monster[6] / 20), var2, var3);
   }

   private void drawMonsterHp(Monster var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8;
      short var9;
      short var14;
      if (var5 < 2) {
         var9 = var1.monsterPro[var5 + 0];
         short var10 = var1.monsterPro[var5 + 2];
         var8 = var7;
         var14 = var10;
      } else {
         var8 = var7;
         if (var7 == 0) {
            var8 = var1.monsterPro[4];
         }

         var9 = (short)var8;
         var14 = this.getMonsterExp(var1);
      }

      Ui.i().drawBarOne(var2, var3, var4, Ms.i().mathPercent(var8, var4 - 2, var14), Ms.i().mathPercent(var9, var4 - 2, var14), var5);
      if (var6 != 2) {
         String var12 = var9 + "/" + var14;
         Ui var11 = Ui.i();
         var7 = var12.length();
         byte var13;
         if (var6 == 1) {
            var13 = 5;
         } else {
            var13 = 0;
         }

         var11.drawNum(var12, (var4 - var7 * 8 >> 1) + var2, var13 + var3, 0, 0);
      }

   }

   private void drawMyMonState() {
      Ui.i().drawK(10, 140, 179, 110, 2);
      Ui.i().drawKuang(10 + 2, 140 + 2, 147, 33);
      Ui.i().drawUi(this.myB.getMon().monster[3] + 5, 10 + 16, 140 + 16, 3, 0);
      Ui.i().drawString(this.getNameMon(this.myB.getMon().monster[0]).toString(), 10 + 75 + 14, 140 + 1, 17, 4, 2);
      Ui.i().drawNum(this.myB.getMon().monster[2] + "\u7ea7", 10 + 125 + 27, 140 + 20, 0, 0);
      Ui.i().drawK0(10 + 2, 140 + 25 + 11, 62, 14, 4);
      Ui.i().drawUi(34, 10 + 4, 140 + 25 + 12, 0, 0);
      Ui.i().drawNum(this.myB.countS[0] + 100 + "%", 10 + 60, 140 + 25 + 24, 1, 1);
      Ui.i().drawString("\u5ba0\u7269\u6863\u6b21", 10 + 2, 140 + 25 + 30, 20, 4, 2);
      this.drawMonKind(this.myB.getMon().monster[4], 10 + 100 + 8, 140 + 25 + 38, 0);
      Ui.i().drawString("\u5174\u594b\u5ea6", 10 + 2, 140 + 50 + 32, 20, 4, 2);
      this.drawMonsterFealty(this.myB.getMon(), 10 + 100 + 4, 140 + 50 + 42);
   }

   private void drawNidus(int var1, int var2) {
      if (this.mini_state == 16) {
         this.drawSelectMenu(this.about_d, 320 - 75, 180 - (this.about_d.length >> 1) * 25, 150, 1, 0, this.popMenu);
      } else {
         Ui.i().fillRectB();
         this.drawBG0(this.bg_c, var1 + 1, 108, 0, var2);
         Log.e("sk", "drawNidus");
         Ui.i().drawString(this.popMenu + 1 + "/" + 5, var1 + 10, 106, 36, 0, 2);
         Ui var8 = Ui.i();
         String var7;
         if (this.getRid(this.popMenu) == -2) {
            var7 = "\u6b64\u4f4d\u7f6e\u76ee\u524d\u662f\u7a7a\u7684";
         } else {
            var7 = this.monsterT[this.monster_pro[this.getNid(this.popMenu)][6]] + "\u7684\u5ba0\u7269\u86cb";
         }

         var8.drawString(var7, var1 + 20, 110, 0, 1, 0);
         boolean var5;
         if (this.getRid(this.popMenu) != -2) {
            label69: {
               if (this.b_c < 2) {
                  byte var4 = this.mon_action;
                  if (this.b_c == 1) {
                     var5 = false;
                  } else {
                     var5 = true;
                  }

                  if (this.drawCartoonOne(1, 1, var4, 377, 97, var5, 0)) {
                     this.initMonStream(2, this.mList_id[this.getNid(this.popMenu)][0], 1);
                     this.b_c = 2;
                     break label69;
                  }
               }

               if (this.b_c > 1 && this.b_c < 14) {
                  this.drawClipPic(this.mList_id[this.getNid(this.popMenu)][1], 1, 377, 97, 80, 77, 15, this.b_c - 2, 0);
                  byte var3 = (byte)(this.b_c + 1);
                  this.b_c = var3;
                  if (var3 == 14) {
                     this.b_c = -1;
                  }

                  this.mon_action = (byte)(this.mList_id[this.getNid(this.popMenu)][1] * 3);
               }
            }

            if (this.b_c != -1) {
               short var10 = (short)(var2 - 40);
               this.str_cur = this.getNexp(this.popMenu, 1) + "/" + this.getNexp(this.popMenu, 3);
               Ui.i().drawBarOne(var1 + 20, 158, var10, Ms.i().mathPercent(this.getNexp(this.popMenu, 1), var10 - 2, this.getNexp(this.popMenu, 3)), Ms.i().mathPercent(this.getNexp(this.popMenu, 1), var10 - 2, this.getNexp(this.popMenu, 3)), 2);
               Ui.i().drawNum(this.str_cur, var1 + 20 + (var10 - this.str_cur.length() * 8 >> 1), 164, 0, 0);
               var8 = Ui.i();
               if (this.getNexp(this.popMenu, 1) == this.getNexp(this.popMenu, 3)) {
                  var7 = "\u5b75\u5316\u5df2\u5b8c\u6210";
               } else {
                  var7 = "\u5b75\u5316\u4e2d...";
               }

               var8.drawString(var7, var1 + 20 + (var10 >> 1), 164, 17, 3, 1);
               Ui.i().drawString("\u5b75\u5316\u6240\u9700\u6750\u6599", var1 + 20 + (var10 >> 1), 208, 17, 3, 1);
               this.drawEvolveMake(this.getNid(this.popMenu), var1 + 25, 239, 28);
            } else {
               Ui.i().drawStringY(this.about_a, var1 + 26, 155, 0, 3, 30, 3, 0);
               Ui.i().drawStringY(this.about_b, var1 + 126, 155, 0, 3, 30, 3, 0);
               Ui.i().drawString("\u6863\u6b21\uff1a", var1 + 20 + 50, 258, 0, 3, 1);
               this.drawMonKind(this.monster_pro[this.getNid(this.popMenu)][5], var1 + 23 + 100 + 10, 263, 0);
            }

            if (this.getNexp(this.popMenu, 1) == this.getNexp(this.popMenu, 3)) {
               Ui.i().drawString("\u6309\u786e\u5b9a\u952e\u5b8c\u6210\u5b75\u5316", var1 + 20, 360 - 25 - 21, 0, 0, 0);
            }
         }

         if (this.b_c == -2) {
            Ui.i().drawTriangle(320, 120, 150, true, true);
         }

         Ui var11 = Ui.i();
         if (this.getRid(this.popMenu) == -2) {
            var5 = false;
         } else {
            var5 = true;
         }

         boolean var6;
         if (this.b_c != -1) {
            var6 = true;
         } else {
            var6 = false;
         }

         var11.drawYesNo(var5, var6);
         byte var9 = this.pkey.selectMenuX(2, 0, 0, 320, 360);
         if (var9 != -1) {
            if (var9 == 0) {
               var9 = -3;
            } else {
               var9 = -4;
            }

            Ms.key = var9;
            Ms.keyRepeat = true;
         }
      }

   }

   private void drawPlayer(Graphics var1) {
      this.drawMyMon();
      this.drawMyMonState();
      this.drawEnemy();
      this.drawEnemyState();
   }

   private void drawPlayerAppear(Graphics var1) {
      switch (this.battle_state) {
         case 0:
            if (this.battle_type > 2) {
               if (this.src_c[2] == 0 && this.enB.throw_state == -1 && this.src_c[0] == 12) {
                  this.enB.throw_state = 0;
               } else if (this.enB.throw_state == 0 || this.enB.throw_state == 2) {
                  this.drawCartoonOne(0, 0, this.mList_id[this.enB.getMon().monster[0]][1] * 3 + this.enB.action, this.enemyOff + 377, 97, false, 0);
                  this.enemyOff = Ms.i().mathSpeedN(this.enemyOff, 0, 4, false);
                  if (this.enemyOff == 0) {
                     this.enB.throw_state = 2;
                  }
               }
            } else if (this.battle_type < 2) {
               this.drawThrowBall(this.enB, this.enB.getMon(), 0, 377, 97);
            }

            this.drawThrowBall(this.myB, this.myB.getMon(), 1, 266, 236);
         default:
      }
   }

   private void drawSelectMenu(Graphics var1, boolean var2, int var3) {
      Ui.i().drawK2(200, var3 + 15, 240, 360 - var3 - 20, 0);
      this.drawBattleExp(this.myB.getMon(), var3 + 3);
      if (!var2) {
         Ui.i().drawString("\u8981\u505a\u4ec0\u4e48\uff1f", 450, 10, 0, 0, 2);

         for(byte var4 = 0; var4 < this.imgBattle.length; ++var4) {
            Ui.i().drawImage(this.imgBattle[var4], this.pkey.button_pos[5][var4][0], this.pkey.button_pos[5][var4][1], 0);
         }
      }

   }

   private void drawSkillList(int var1, int var2, int var3, int var4, int var5, byte[] var6) {
      byte var7 = var6[1];
      Ui.i().drawListKY(var5, var1, var2, var3, 3, var4, 0, var6[0] - var6[1], 4, 2);

      for(; var7 < var6[1] + var5 && var7 < this.skill_list[8]; ++var7) {
         Ui var10 = Ui.i();
         byte var8;
         if (this.skill_list[var7] > 25) {
            var8 = 50;
         } else {
            var8 = 51;
         }

         var10.drawUi(var8, var1 + 8, var2 + 8 + (var7 - var6[1]) * var4, 0, 0);
         Log.e("sk", "\u666e\u901a\u653b\u51fb");
         Ui var11 = Ui.i();
         String var13 = this.getNameSkill(this.skill_list[var7]).toString();
         byte var9 = var6[1];
         if (var6[0] == var7) {
            var8 = 0;
         } else {
            var8 = 3;
         }

         var11.drawString(var13, var1 + 21, var2 + 1 + (var7 - var9) * var4, 0, var8, 0);
         var11 = Ui.i();
         if (this.skill_list[var7] <= 30) {
            var13 = this.skill[this.skill_list[var7]][1] + "\u80fd\u91cf";
         } else {
            var13 = "\u88ab\u52a8";
         }

         var9 = var6[1];
         Graphics var12 = g;
         var12 = g;
         if (var6[0] == var7) {
            var8 = 0;
         } else {
            var8 = 3;
         }

         var11.drawString(var13, var1 + var3 - 8, var2 + 1 + (var7 - var9) * var4, 8 | 16, var8, 0);
         if (this.say_c < 1 && this.pkey.isSelect(var1, (var7 - var6[1]) * var4 + var2, var3, var4)) {
            if (var6[0] == var7) {
               this.pkey.setKey5();
            } else {
               var6[0] = var7;
               if (var7 - var6[1] == 0 && var6[1] > 0) {
                  --var6[1];
               } else if (var7 - var6[1] == var5 - 1 && var6[1] + var5 < this.skill_list[8]) {
                  ++var6[1];
               }
            }
         }
      }

   }

   private void drawThrowBall(Battle var1, Monster var2, int var3, int var4, int var5) {
      if (var1.throw_state == 0) {
         Ui var9 = Ui.i();
         Image var8 = this.imgItem[0];
         short var6 = var1.cThrow[0];
         short var7 = var1.cThrow[1];
         Graphics var10 = g;
         var10 = g;
         var9.drawImage(var8, var6 + var4, var5 - var7, 1 | 32);
      } else if (var1.throw_state == 1) {
         this.drawClipPic(this.mList_id[var2.monster[0]][1], var3, var4, var5, 80, 77, 15, var1.cThrow[2], var3);
      } else if (var1.throw_state == 2) {
         this.drawCartoonOne(var3, var3, this.mList_id[var2.monster[0]][1] * 3, var4, var5, true, var3);
      }

      this.runThrowBall(var1, var2, var3);
   }

   private void drawVIEW_COMPUTER() {
      Ui.i().drawK2(320 - 25 * 2 - 8, 180 - 25 * 2 - 8, 25 * 4 + 16, 25 * 6 + 16, 0);
      this.drawSelectMenu(this.about_d, 320 - 25 - 4, 180 - 25, (25 + 4) * 2, 2, 0, this.popMenu);
      Ui.i().drawString("\u5bc4\u5b58\u5ba0\u7269", 320, 180 - 25 * 2 - 6, 17, 1, 1);
      Ui.i().drawYesNo(true, true);
   }

   private void effectR(Monster var1) {
      if (var1.effect_time > 0) {
         --var1.effect_time;
      }

      if (var1.effect_time == 0) {
         var1.effect = 7;
      }

   }

   private void enemy_init() {
      Monster[] var5 = new Monster[this.enemyList.length];

      for(int var1 = 0; var1 < this.enemyList.length; ++var1) {
         byte var3 = this.enemyList[var1][0];
         byte var4 = this.enemyList[var1][1];
         byte var2;
         if (this.myMonsters[0].isMonReel(39)) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         var5[var1] = new Monster(this, var3, var4, var2);
         if (this.battle_type != 3 && this.battle_type != 0) {
            var5[var1].resetMonster(this, -1);
         } else {
            if (var5[var1].monster[3] == -1) {
               var5[var1].resetBoss(this.enemyList[var1][4]);
            } else {
               var5[var1].resetMonster(this.enemyList[var1][2], this.enemyList[var1][3], this.enemyList[var1][4]);
            }

            var5[var1].resetPro(this);
         }
      }

      this.enemyList = null;
      this.enB = new Battle(var5);
   }

   private int getBXY(int var1, int var2, boolean var3) {
      short var4;
      short var5;
      label27: {
         short var7 = 266;
         short var6 = 236;
         if (var1 != 1 || this.isSkillToMe(var2)) {
            var5 = var7;
            var4 = var6;
            if (var1 != 0) {
               break label27;
            }

            var5 = var7;
            var4 = var6;
            if (!this.isSkillToMe(var2)) {
               break label27;
            }
         }

         var5 = 377;
         var4 = 97;
      }

      if (var3) {
         var4 = var5;
      }

      return var4;
   }

   private void getBattleBG(Battle var1, Monster var2) {
      if (this.monPro.length != 0) {
         var1.bg_id = this.monPro[0];
      }

      for(byte var3 = 0; var3 < 5; ++var3) {
         if (var2.isMonReel(var3 + 43)) {
            var1.bg_id = var3;
            break;
         }
      }

   }

   private int getBuyItemCount(int var1, int var2, boolean var3) {
      if (var3) {
         if (var1 == 2) {
            var1 = this.coin / this.sell_money;
         } else {
            var1 = this.money / this.sell_money;
         }

         int var4 = 99 - this.findItem(-2, this.buyItem[this.cur_a][var2], true);
         var2 = var4;
         if (var4 < 0) {
            var2 = 0;
         }

         if (var1 > var2) {
            var1 = var2;
         }
      } else {
         var1 = this.items[this.cur_a][var2][1];
      }

      return var1;
   }

   private void getExpOne(boolean var1) {
      byte var2 = 0;
      this.exp = 0;
      Ms.i();

      for(Ms.skip2 = this.enB.mon[0].monster[2]; var2 < this.enB.mon.length; ++var2) {
         this.exp = (short)(this.exp + this.enB.mon[var2].monster[2] * 3 + 80);
         byte var3 = this.enB.mon[var2].monster[2];
         Ms.i();
         if (var3 > Ms.skip2) {
            Ms.i();
            Ms.skip2 = this.enB.mon[var2].monster[2];
         }
      }

      this.exp = (short)(this.exp * (56 / this.mon_in_battle[0] - (this.mon_in_battle[0] - 1) * 2 + 44) / 100);
      if (!var1) {
         this.exp = (short)(this.exp / 2);
      }

   }

   private void getHitCoefficient(Battle var1, Monster var2, Monster var3) {
      var1.countS[1] = 0;
      int var4 = (byte)(var2.monster[6] - 99);
      byte[] var6 = var1.countS;
      byte var5 = var6[1];
      if (var4 > 1) {
         var4 = 20;
      } else {
         var4 = var4 / 20 * 20;
      }

      var6[1] = (byte)(var5 + var4);
      if (var2.monster[3] != -1 && var1.bg_id != var2.monster[3]) {
         var6 = var1.countS;
         var5 = var6[1];
         byte var8;
         if (var1.bg_id == var2.monster[3]) {
            var8 = 0;
         } else {
            var8 = -20;
         }

         var6[1] = (byte)(var5 + var8);
      }

      byte[] var7 = var1.countS;
      var7[1] += this.isShuXing(var2, var3);
   }

   private String getInfoType(int var1) {
      String var2;
      if (var1 == -1) {
         var2 = "\u4efb\u52a1";
      } else if (var1 == -2) {
         var2 = "\u8fdb\u5316";
      } else if (var1 == -3) {
         var2 = "\u5f02\u5316";
      } else if (var1 == -4) {
         var2 = "\u7ade\u6280\u573a";
      } else if (var1 == -5) {
         var2 = "\u5b75\u5316";
      } else {
         var2 = "\u6355\u83b7";
      }

      return var2;
   }

   private byte getMonInfo_dir() {
      return this.monInfo_dir[this.cur_a][this.getSelInfo()];
   }

   private byte getMonster(Monster var1, int var2, boolean var3) {
      if (this.monInfoList[var1.monster[0]] != 2) {
         this.monInfoList[var1.monster[0]] = 2;
         this.addMonInfoListBH();
         this.map.addAnole(var1.monster[0]);
      }

      byte var4;
      if (this.myMon_length < this.max_takes) {
         this.myMonsters[this.myMon_length] = var1;
         if (var3) {
            this.myMonsters[this.myMon_length].resetMonster(this, var2);
         }

         ++this.myMon_length;
         var4 = 0;
      } else if (this.cMon_count < this.max_monsters) {
         this.say("\u643a\u5e26\u5df2\u6ee1\uff0c" + this.getNameMon(var1.monster[0]) + "\u5df2\u8f6c\u5165\u5bc4\u653e\u5904", 0);
         this.cMonsters[this.cMon_count] = var1;
         if (var3) {
            this.cMonsters[this.cMon_count].resetMonster(this, var2);
         }

         ++this.cMon_count;
         var4 = 1;
      } else {
         var4 = -1;
      }

      return var4;
   }

   private short getMonsterExp(Monster var1) {
      return (short)(var1.monster[2] * 210 / 10 - 2);
   }

   private String getNameBuff(int var1) {
      int var2 = var1;
      if (var1 < 1) {
         var2 = 0;
      }

      return this.buff_name[var2].toString();
   }

   private String getNameSkill(byte var1) {
      return this.skill_name[var1].toString();
   }

   private short getPrice(int var1, int var2, boolean var3) {
      short var5;
      if (var3) {
         short var4;
         if (var1 == 2) {
            var4 = this.buyPrice[1][var2];
         } else {
            var4 = this.buyPrice[0][this.buyItem[this.cur_a][var2]];
         }

         var5 = var4;
         if (this.view_state == -1) {
            var5 = (short)(var4 * 12 / 10);
         }
      } else {
         var5 = (short)(this.buyPrice[0][var2] / 5);
      }

      return var5;
   }

   private byte getSelInfo() {
      return this.select[0][0];
   }

   private void getSkill(int var1, int var2) {
      byte var3;
      if (var1 == 0) {
         var3 = 25;
      } else {
         var3 = this.skill_up[var1 - 1][var2];
      }

      this.getSkill = var3;
   }

   private int getSkillLevel(int var1) {
      if (var1 == 25) {
         var1 = 0;
      } else if (var1 < 25) {
         var1 = var1 % 5 + 1;
      } else {
         var1 = this.makeLevel[var1 - 25 - 1];
      }

      return var1;
   }

   private int getSkillMana(Monster var1, int var2) {
      byte var3 = this.skill[var2][1];
      if (var1.monster[3] == 4 && var1.isMonReel(35)) {
         var2 = this.skill[var2][0] * var3 / 100;
      } else {
         var2 = var3;
      }

      return var2;
   }

   private short getbuffRateV(Monster var1, int var2) {
      int var3;
      if (var1.isBuffRate(2)) {
         var3 = var2 + this.inhesion[2] * var2 / 100;
      } else {
         var3 = var2;
         if (var1.isBuffRate(1)) {
            var3 = var2 + this.inhesion[1] * var2 / 100;
         }
      }

      return (short)var3;
   }

   private void goBattleExp(boolean var1) {
      this.battle_state = -5;
      this.cur_c = 0;
      this.b_c = 0;
      this.myB.now_id = this.myMonsters[this.myB.now_id].monster[1];
      this.proReplace[this.myB.now_id][2] = -2;
      this.arangeMonster();
      this.getExpOne(var1);
   }

   private void goBattleItem() {
      this.battle_state = -4;
      this.cur_b = -1;
      StringBuffer var1 = new StringBuffer();
      Ms.i();
      if (Ms.getRandom(100) < 50 && this.findItem(-2, 32, true) < 99) {
         this.addItem(32, 1);
         var1.append("\u83b7\u5f97\uff1a" + this.getNameItem(32) + "x1");
      }

      this.setStringB(var1.toString(), 10000, 0);
   }

   private void goBattleOver() {
      run_state = -15;
      this.b_c = 0;
      this.myB.now_id = 0;
      this.mini_state = 3;
      this.view_state = 1;
      this.bg_c = this.myB.bg_id;
      this.mon[0].nullIMFA();
   }

   private void goBattleState() {
      this.setAction_str(new String[]{"\u653b\u51fb", "\u9053\u5177", "\u5ba0\u7269", "\u5546\u5e97", "\u9003\u8dd1"});
      run_state = -31;
      byte var1;
      if (this.mini_state == 1) {
         var1 = 2;
      } else {
         var1 = 1;
      }

      this.battle_state = var1;
   }

   private void goCatchMonster() {
      run_state = -19;
      this.cThrowX = 131;
      this.cThrowY = -20;
      this.cThrowS = 176;
      this.b_c = 0;
   }

   private void goGO_RUNINMAP() {
      this.b_c = 0;
      this.popMenu = -1;
      System.gc();
      run_state = -11;
   }

   private void goLIST_INFO(boolean var1) {
      run_state = 68;
      if (this.monInfo_dir == null) {
         byte[] var2 = Ms.i().getStream("data/book.d", -1);
         Ms.i();
         Ms.skip = 0;
         this.monInfo_dir = Ms.i().create2Array(var2);
         var2 = (byte[])null;
      }

      if (var1) {
         this.infoStart = 0;
         this.cur_a = 0;
         this.cur_b = 0;
         this.move_x = 6;
         this.move_y = 0;
         this.t_length = (byte)this.monInfo_dir[this.cur_a].length;
         this.select[0][0] = 0;
         this.select[0][1] = 0;
      }

      this.list_rows = 7;
   }

   private void goMONSTER_INFO(int var1) {
      run_state = 67;
      this.initMonStream(2, this.mList_id[var1][0], 1);
   }

   private void goMY_BAG(int var1) {
      this.mini_state = 15;
      this.list_rows = 6;
      run_state = 25;
      this.popMenu = -1;
      if (this.view_state == 1) {
         this.setAction_str(new String[]{"\u9053\u5177", "\u8f85\u52a9", "\u5377\u8f74", "\u5b75\u5316"});
      } else if (this.view_state == -1) {
         this.setAction_str(new String[]{"\u9053\u5177"});
      } else if (this.view_state == 2) {
         this.setAction_str(new String[]{"\u5b75\u5316"});
      }

      this.selectx = (byte)var1;
      this.selecty = 0;
      this.select[0][1] = this.select_st[this.selectx];
      this.select[0][0] = this.select_it[this.selectx];
      Ms.i().correctSelect(this.select[0], this.itemsLength[this.selectx], this.list_rows);
      this.itemMine = null;
      Ms.i();
      Ms.skip = 0;
      this.itemMine = Ms.i().create2Array(Ms.i().getStream("data/box.d", -1));
   }

   private void goMontsterAppear() {
      run_state = -50;
      this.battle_state = 0;
      this.enemyOff = 63;
      this.setAimBattle(1);
   }

   private void goRUN_IN_MAP(boolean var1) {
      this.selecty = 0;
      this.selectx = 0;
      this.select[0][1] = 0;
      this.mini_state = 0;
      this.view_state = 0;
      mc.game_state = 30;
      System.out.println("aaaaaaaaaaaaaaaaa");
      this.map.my.state = 0;
      if (!this.isChangeSound) {
         Sound.i().setMusicId(this.musicNo[this.map.mapNo]);
         Sound.i().setMusic(var1);
         Log.d("soars", "tttttttttttttttttttttt");
      }

      if (this.isChangeSound) {
         Sound.i().setMusicId(this.musicNo[this.map.mapNo]);
         Sound.i().setMusicForMenu(var1);
         Log.d("soars", "ffffffffffffffffffffffffffffffff");
      }

      run_state = -10;
      this.createOver = 0;
      this.buyItemID = 0;
   }

   private void goSelectAction(int var1) {
      run_state = -31;
      byte var2;
      if (var1 == 1) {
         var2 = 2;
      } else {
         var2 = 1;
      }

      this.battle_state = var2;
      this.setAimBattle(var1);
      if (var1 == 1) {
         this.initSkillList(this.myB.getMon());
      }

      this.getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
      this.getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
   }

   private void goView() {
      this.select[0][1] = this.selectx;
      this.select[0][0] = this.selecty;
      this.cur_c = 0;
      this.popMenu = -1;
      this.setStringB("\u751f\u547d#n\u80fd\u91cf#n\u6863\u6b21", Constants_H.WIDTH, 0);
      this.setStringB("\u529b\u91cf#n\u9632\u5fa1#n\u654f\u6377", Constants_H.WIDTH, 1);
   }

   private void hit_rate(Battle var1, Battle var2, Monster var3, Monster var4, int var5) {
      var1.initHit();
      var2.initHit();
      this.hit_rate = var3.monsterPro[5] - var4.monsterPro[5];
      this.hit_rate = this.hit_rate / 2 + 92 + var1.rate_off;
      Ms.i();
      byte var6 = (byte)Ms.getRandom(100);
      var1.rate_off = 0;
      if (var5 > 26 && var5 < 30) {
         switch (var5) {
            case 27:
            case 28:
               var1.addHit(-this.skill[var5][0] * 10, 1, 1);
               break;
            case 29:
               var2.addHit(var3.monsterPro[6] * this.skill[var5][0] + var3.monsterPro[1], 1, 0);
               var1.addHit(var3.monsterPro[1], 4, 2);
         }
      } else if (var6 < this.hit_rate || this.mini_state == 1 && var3.monster[2] < 11) {
         label53: {
            this.damage(var1, var2, var3, var4, var5, this.mini_state ^ 1);
            if (var5 == 26 && !var2.getMon().isMonReel(40)) {
               Ms.i();
               if (Ms.getRandom(100) < this.skill[var5][2]) {
                  var2.addHit(this.skill[var5][3] * var2.getMon().monster[6] / 100, -2, 2);
                  break label53;
               }
            }

            if (var5 < 25 || var5 == 30) {
               this.magicEffectRate(var2, var3, var4, var5);
            }
         }

         if (var3.monster[3] == 2 && var3.isMonReel(34)) {
            var2.addHit(var4.monsterPro[3] * this.skill[34][0] / 100, 4, 2);
         }
      } else {
         var2.addHit(0, -1, 2);
         var1.rate_off = 20;
      }

   }

   private void hpAdd(int var1, int var2) {
      if (this.myMonsters[this.select[0][0]].monsterPro[0] < this.myMonsters[this.select[0][0]].monsterPro[2] && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
         this.AddHP(var2 + this.myMonsters[this.select[0][0]].monsterPro[2] * var1 / 100, this.myMonsters[this.select[0][0]]);
         this.useState(0, this.select_it[0]);
      } else if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
         this.say(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]) + "\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u65e0\u6cd5\u4f7f\u7528\uff01", 0);
      } else {
         this.say(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]) + "\u4e0d\u9700\u8981\u4f7f\u7528\u8fd9\u4e2a\u9053\u5177", 0);
      }

   }

   private void initMagicStream(int var1) {
      if (this.magic[var1] == null) {
         String var2 = "data/battle/s" + var1;
         this.magic[var1] = Ms.i().createSprite(var2, false);
      }

   }

   private void initOtherImage() {
      if (this.imgItem == null) {
         this.imgItem = new Image[2];
         this.imgItem[0] = Ms.i().createImage("data/ball");
         this.imgItem[1] = Ms.i().createImage("data/ll");
         this.initItemModules();
      }

      if (this.imgBG == null) {
         this.imgBG = new Image[5];

         for(byte var1 = 0; var1 < this.imgBG.length; ++var1) {
            this.imgBG[var1] = Ms.i().createImage("data/battle/" + var1);
         }
      }

      this.initImgIco();
   }

   private boolean isBagUse(int var1) {
      boolean var2;
      if (this.view_state == -1) {
         if (var1 != 14 && var1 != 15) {
            var2 = true;
         } else {
            var2 = false;
         }
      } else if (var1 != 9 && var1 != 10 && var1 != 11 && var1 != 8) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private byte isEvolveKind(byte var1, byte var2) {
      byte var4 = -1;
      byte var3;
      if (var1 == 1 && var2 < 15) {
         var3 = -2;
      } else if (var1 == 2 && var2 < 25) {
         var3 = -3;
      } else {
         var3 = var4;
         if (var1 == 3) {
            var3 = var4;
            if (var2 < 30) {
               var3 = -4;
            }
         }
      }

      return var3;
   }

   private byte isEvolveMake(int var1) {
      byte var4 = 2;
      byte var3 = this.monsterMake[var1][0];

      byte var2;
      while(true) {
         if (this.findItem(-2, this.monsterMake[var1][var4], true) < this.monsterMake[var1][var4 + 1]) {
            var2 = -1;
            break;
         }

         byte var5 = (byte)(var4 + 2);
         var4 = var5;
         if (var5 >= this.monsterMake[var1].length - 1) {
            var2 = var3;
            if (var3 > 0) {
               var2 = var3;
               if (this.findItem(-2, 34, true) < 1) {
                  var2 = 0;
               }
            }
            break;
         }
      }

      return var2;
   }

   private boolean isMonHp(Monster var1, int var2) {
      boolean var3;
      if (var1.monsterPro[0] < var1.monster[2] * var2 / 100) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   private boolean isMyMonsters(int var1) {
      byte var2 = 0;

      boolean var3;
      while(true) {
         if (var2 >= this.myMon_length) {
            var3 = false;
            break;
         }

         if (var2 != var1 && this.myMonsters[var2].monsterPro[0] > 0) {
            var3 = true;
            break;
         }

         ++var2;
      }

      return var3;
   }

   private byte isShuXing(Monster var1, Monster var2) {
      byte var3;
      if (var1.monster[3] == -1) {
         var3 = 30;
      } else if (this.Shuxing[var1.monster[3]][0] == var2.monster[3]) {
         var3 = 30;
      } else if (this.Shuxing[var1.monster[3]][1] == var2.monster[3]) {
         var3 = 0;
      } else {
         var3 = 0;
      }

      return var3;
   }

   private boolean isSkillToMe(int var1) {
      boolean var2;
      if (var1 != 27 && var1 != 28) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   private void keyBattleState() {
      if (!Ms.i().key_delay()) {
         switch (this.battle_state) {
            case 2:
               if (Ms.i().key_Left_Right()) {
                  this.cur_a = Ms.i().select(this.cur_a, 0, this.action_str.length - 1);
               } else if (Ms.i().key_S1_Num5()) {
                  if (this.cur_a == 0) {
                     if (this.myB.getMon().monster[6] == 0) {
                        this.say("\u5ba0\u7269\u5fe0\u8bda\u5ea6\u4e3a0\uff0c\u8bf7\u7acb\u523b\u8865\u5145\uff01", -1);
                     } else {
                        for(this.battle_state = 3; this.skill_list[this.lastSkill] > 30; ++this.lastSkill) {
                        }

                        this.select[0][0] = this.lastSkill;
                        this.select[0][1] = (byte)(this.select[0][0] - 5);
                        if (this.select[0][1] < 1) {
                           this.select[0][1] = 0;
                        }
                     }
                  } else if (this.cur_a == 1) {
                     if (this.myB.getMon().effect == 4) {
                        this.say("\u7981\u9522\u4e2d\u65e0\u6cd5\u4f7f\u7528\u9053\u5177\uff01", -1);
                     } else {
                        this.goMY_BAG(0);
                     }
                  } else if (this.cur_a == 2) {
                     if (this.myB.getMon().effect == 4) {
                        this.say("\u7981\u9522\u4e2d\u65e0\u6cd5\u66f4\u6362\u5ba0\u7269\uff01", -1);
                     } else {
                        this.view_state = -2;
                        this.goVIEW_MONSTER();
                     }
                  } else if (this.cur_a == 3) {
                     this.goBUY_ITEM(0, 0);
                  } else if (this.cur_a == 4) {
                     if (this.battle_type == 4) {
                        short var2 = (short)(this.myB.getMon().monster[2] - this.enB.getMon().monster[2] + 60);
                        byte var1 = 0;
                        Ms.i();
                        if (Ms.getRandom(100) >= var2) {
                           var1 = 1;
                        }

                        if (this.myB.getMon().isMonReel(42)) {
                           var1 = 0;
                        } else if (this.myB.getMon().isEffect(3) || this.myB.getMon().isEffect(4)) {
                           var1 = 2;
                        }

                        if (var1 == 0) {
                           this.arangeMonster();
                           this.setNullBattle();
                           this.goGO_RUNINMAP();
                        } else if (var1 == 1) {
                           this.say("\u9003\u8dd1\u5931\u8d25\uff01", 1);
                           this.myB.act_num = 0;
                           this.enB.act_num = 1;
                           this.battle_state = 9;
                        } else {
                           StringBuilder var4 = new StringBuilder("\u88ab\u602a\u7269");
                           String var3;
                           if (this.myB.getMon().isEffect(4)) {
                              var3 = "\u7981\u9522\u4e2d";
                           } else {
                              var3 = "\u7684\u7535\u773c\u9b45\u60d1\u4e86";
                           }

                           this.say(var4.append(var3).append("\uff0c").append("\u65e0\u6cd5\u9003\u8dd1\uff01").toString(), 1);
                        }
                     } else {
                        this.say("\u65e0\u6cd5\u9003\u8dd1\uff01", 0);
                     }
                  }
               }
               break;
            case 3:
               if (Ms.i().key_Up_Down()) {
                  Ms.i().selectS(this.select[0], 0, this.skill_list[8], 6);
                  this.lastSkill = this.select[0][0];
               } else if (Ms.i().key_S1_Num5()) {
                  if (this.skill_list[this.select[0][0]] > 30) {
                     this.say("\u88ab\u52a8\u6280\u80fd\u65e0\u6cd5\u4f7f\u7528!", -1);
                  } else if (this.myB.getMon().effect == 6 && this.getSkillLevel(this.skill_list[this.select[0][0]]) > 3) {
                     this.say("\u5c01\u95ed\u6548\u679c\uff0c\u4e0d\u80fd\u4f7f\u75284\u7ea7\u4ee5\u4e0a\u6280\u80fd", -1);
                  } else if (this.myB.getMon().monsterPro[1] >= this.getSkillMana(this.myB.getMon(), this.skill_list[this.select[0][0]])) {
                     this.myB.skill = this.skill_list[this.select[0][0]];
                     this.battle_state = 9;
                  } else {
                     this.say("\u9700\u8981\u7684\u6280\u80fd\u503c\u4e0d\u591f\uff01", -1);
                  }
               } else if (Ms.i().key_S2()) {
                  this.battle_state = 2;
               }
               break;
            case 4:
               if (Ms.i().key_Up_Down()) {
                  Ms.i().selectS(this.select[0], 0, 6, this.skill_list[8]);
               } else if (!Ms.i().key_S1_Num5() && Ms.i().key_S2()) {
                  this.battle_state = 2;
               }
               break;
            case 5:
               if (Ms.i().key_Up_Down()) {
                  Ms.i().selectS(this.select[0], 0, 6, this.skill_list[8]);
               } else if (!Ms.i().key_S1_Num5() && Ms.i().key_S2()) {
                  this.battle_state = 2;
               }
         }
      }

   }

   private void keyBuyItem() {
      if (!Ms.i().key_delay()) {
         byte var3;
         boolean var5;
         byte[] var6;
         byte var8;
         if (this.popMenu == -1) {
            if (Ms.i().key_Left_Right() && this.cur_b != 0) {
               this.cur_a = Ms.i().select(this.cur_a, 0, 2);
               var6 = this.select[0];
               this.select[0][0] = 0;
               var6[1] = 0;
            } else if (Ms.i().key_Up_Down()) {
               Ms var7 = Ms.i();
               var6 = this.select[0];
               int var2;
               if (this.cur_b == 1) {
                  var2 = this.itemsLength[this.cur_a];
               } else {
                  var2 = this.buyItem[this.cur_a].length;
               }

               var7.selectS(var6, 0, var2, this.list_rows);
            } else if (Ms.i().key_S1_Num5()) {
               this.popMenu = 1;
               var3 = this.cur_a;
               if (this.cur_b != 1) {
                  var8 = this.select[0][0];
               } else {
                  var8 = this.items[this.cur_a][this.select[0][0]][0];
               }

               if (this.cur_b != 1) {
                  var5 = true;
               } else {
                  var5 = false;
               }

               this.sell_money = this.getPrice(var3, var8, var5);
               var8 = this.cur_a;
               var3 = this.select[0][0];
               if (this.cur_b != 1) {
                  var5 = true;
               } else {
                  var5 = false;
               }

               this.t_length = (byte)this.getBuyItemCount(var8, var3, var5);
            } else if (Ms.i().key_S2()) {
               this.buyItem = null;
               this.buyPrice = null;
               if (this.view_state == -1) {
                  this.goBattleState();
               } else {
                  this.goGO_RUNINMAP();
               }
            }
         } else if (this.buyOk == 0 && Ms.i().key_Left_Right()) {
            this.popMenu = Ms.i().select(this.popMenu, 1, this.t_length);
         } else if (Ms.i().key_S1_Num5()) {
            if (this.buyOk == 1) {
               if (this.cur_b == 1) {
                  this.money += this.sell_money * this.popMenu;
                  this.deleteItems(this.items[this.cur_a][this.select[0][0]][0], this.popMenu);
                  if (this.select[0][0] >= this.itemsLength[this.cur_a]) {
                     var6 = this.select[0];
                     byte var1 = (byte)(var6[0] - 1);
                     var6[0] = var1;
                     if (var1 < 0) {
                        this.select[0][0] = 0;
                     }

                     var6 = this.select[0];
                     var1 = (byte)(var6[1] - 1);
                     var6[1] = var1;
                     if (var1 < 0) {
                        this.select[0][1] = 0;
                     }
                  }

                  this.say("\u83b7\u5f97\u91d1\u94b1\uff1a" + this.sell_money * this.popMenu, 0);
               } else {
                  var3 = this.cur_a;
                  var8 = this.buyItem[this.cur_a][this.select[0][0]];
                  byte var4 = this.popMenu;
                  if (this.cur_a != 2) {
                     var5 = true;
                  } else {
                     var5 = false;
                  }

                  if (this.isMoneyItem(var3, var8, var4, var5) && this.addItem(this.buyItem[this.cur_a][this.select[0][0]], this.popMenu) != -1) {
                     this.say("\u8d2d\u4e70\u6210\u529f", 0);
                  }
               }

               this.buyOk = 0;
               this.popMenu = -1;
            } else {
               this.buyOk = 1;
            }
         } else if (Ms.i().key_S2()) {
            if (this.buyOk == 0) {
               this.popMenu = -1;
            } else {
               this.buyOk = 0;
            }
         }
      }

   }

   private void keyEvolveUI() {
      if (Ms.i().key_S1_Num5() && this.b_c == 0) {
         byte var3 = this.myMonsters[this.selecty].monster[4];
         byte var1 = this.myMonsters[this.selecty].monster[2];
         byte var2 = this.myMonsters[this.selecty].monster[0];
         byte var4 = this.isEvolveMake(var2);
         if (this.isEvolveKind(var3, var1) != -1) {
            var4 = this.isEvolveKind(var3, var1);
         }

         if (var4 == 0) {
            this.myMonsters[this.selecty].evolveMonster(this, this.monsterMake[var2][1], 1);
         } else if (var4 > 0) {
            this.myMonsters[this.selecty].evolveMonster(this, this.monsterMake[var2][0], this.myMonsters[this.selecty].monster[5]);
         } else if (var4 == -1) {
            this.say("\u6750\u6599\u4e0d\u8db3\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01", 0);
            this.popMenu = 1;
         } else if (var4 == -2) {
            this.say("\u7b49\u7ea7\u6ca1\u6709\u8fbe\u523015\u7ea7\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01", 0);
         } else if (var4 == -3) {
            this.say("\u7b49\u7ea7\u6ca1\u6709\u8fbe\u523025\u7ea7\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01", 0);
         } else {
            this.say("\u7b49\u7ea7\u6ca1\u6709\u8fbe\u523030\u7ea7\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01", 0);
         }

         if (var4 > -1) {
            this.b_c = 1;
            this.setMagic(6);
            this.setShowPro(this.myMonsters[this.selecty]);
            this.popMenu = 0;
            this.delItemEvolve(var2);
            if (var4 > 0) {
               this.deleteItems(34, 1);
            }
         }
      } else if (Ms.i().key_S2()) {
         this.goView();
         this.setShowPro(this.myMonsters[this.selecty]);
      } else if (Ms.i().key_Left_Right() && this.b_c <= 0) {
         this.popMenu = (byte)(this.popMenu ^ 1);
      }

   }

   private void keyGetSkill(Monster var1) {
      if (this.getSkill + 9 >= 35 && this.makeLevel[this.getSkill + 9 - 35] > this.rmsOther[3]) {
         this.say("\u9700\u8981\u8bad\u7ec3\u5e08" + this.makeLevel[this.getSkill + 9 - 35] + "\u7ea7\u624d\u80fd\u5b66\u4e60\uff01", 0);
      } else if (var1.isMonReel(this.getSkill)) {
         this.say(this.getNameMon(var1.monster[0]) + "\u5df2\u62e5\u6709\u8be5\u6280\u80fd", 0);
      } else if (var1.monster[14] != -1 && var1.monster[15] != -1) {
         this.initSkillList(var1);
         this.bg_c = var1.monster[3];
         this.restMove(1, 0);
         this.say("\u8bf7\u9009\u62e9\u8981\u66ff\u6362\u7684\u6280\u80fd\uff01", 0);
      } else {
         if (var1.monster[14] == -1) {
            var1.monster[14] = this.getSkill;
         } else {
            var1.monster[15] = this.getSkill;
         }

         this.delItemSkill(var1);
      }

   }

   private void keyMY_BAG() {
      if (!Ms.i().key_delay()) {
         if (this.popMenu == -1) {
            if (Ms.i().key_S1_Num5() && this.itemsLength[this.selectx] > 0) {
               this.popBagMenu(this.selectx, this.select[0][0]);
            } else if (Ms.i().key_Left_Right()) {
               this.selectx = Ms.i().select(this.selectx, 0, this.action_str.length - 1);
               this.select[0][1] = this.select_st[this.selectx];
               this.select[0][0] = this.select_it[this.selectx];
            } else if (Ms.i().key_S2()) {
               if (this.mini_state == 9) {
                  this.mini_state = 5;
                  this.selecty = this.select_T;
                  this.selecty = 0;
                  this.goVIEW_MONSTER();
               } else if (this.view_state == -1) {
                  this.mini_state = 1;
                  this.goBattleState();
                  this.initMonStream(2, this.mList_id[this.myMonsters[0].monster[0]][0], 1);
                  this.itemMine = null;
               } else if (this.view_state == 2) {
                  run_state = -10;
                  mc.paint();
                  this.goNidus(0);
               } else {
                  this.doPaint(0);
                  this.goYouPAUSE(2);
                  this.itemMine = null;
               }
            } else if (Ms.i().key_Up_Down()) {
               if (this.itemsLength[this.selectx] > 0) {
                  Ms.i().selectS(this.select[0], 0, this.itemsLength[this.selectx], this.list_rows);
               }

               this.select_it[this.selectx] = this.select[0][0];
               this.select_st[this.selectx] = this.select[0][1];
            }
         } else {
            this.popBagState();
         }
      }

   }

   private void keyMagicUI() {
      if (Ms.i().key_S1_Num5() && this.mini_state == 13) {
         if (this.skill_list[this.select[0][0]] <= 25) {
            this.say("\u8be5\u6280\u80fd\u4e0d\u80fd\u66ff\u6362\uff01", 0);
         } else {
            if (this.skill_list[this.select[0][0]] == this.myMonsters[this.selecty].monster[14]) {
               this.myMonsters[this.selecty].monster[14] = this.getSkill;
            } else {
               this.myMonsters[this.selecty].monster[15] = this.getSkill;
            }

            this.delItemSkill(this.myMonsters[this.selecty]);
         }
      } else if (Ms.i().key_S2()) {
         this.select[0][1] = this.selectx;
         this.select[0][0] = this.selecty;
         this.cur_c = 0;
         this.popMenu = -1;
      } else {
         byte[] var1;
         if (Ms.i().key_Left_Right() && this.mini_state != 13) {
            this.popMenu = (byte)(this.popMenu ^ 1);
            var1 = this.select[0];
            this.select[0][0] = 0;
            var1[1] = 0;
         } else if (Ms.i().key_Up_Down()) {
            this.introX = Constants_H.WIDTH_H;
            if (this.popMenu == 0) {
               Ms.i().selectS(this.select[0], 0, this.skill_list[8], 5);
            } else if (this.mini_state == 6) {
               if (this.cMonsters[this.selecty].monster[17] > 0) {
                  var1 = this.select[0];
                  var1[0] = (byte)(var1[0] ^ 1);
               }
            } else if (this.myMonsters[this.selecty].monster[17] > 0) {
               var1 = this.select[0];
               var1[0] = (byte)(var1[0] ^ 1);
            }
         }
      }

   }

   private void keyNidus() {
      if (!Ms.i().key_delay()) {
         if (this.mini_state == 16) {
            if (Ms.i().key_Up_Down()) {
               this.popMenu = Ms.i().select(this.popMenu, 0, this.about_d.length - 1);
            } else if (Ms.i().key_S1_Num5()) {
               if (Ms.i().equals(this.about_d[this.popMenu], "\u67e5\u770b\u5b75\u5316")) {
                  this.mini_state = 17;
                  this.popMenu = 0;
                  this.initMonStream(0, 56, 1);
                  if (this.getRid(this.popMenu) == -2) {
                     this.bg_c = this.popMenu;
                  } else {
                     this.bg_c = this.monster_pro[this.getNid(this.popMenu)][6];
                     this.mon_action = (byte)(this.bg_c + 23);
                  }
               } else if (Ms.i().equals(this.about_d[this.popMenu], "\u9009\u62e9\u86cb")) {
                  this.view_state = 2;
                  this.goMY_BAG(3);
               } else if (Ms.i().equals(this.about_d[this.popMenu], "\u79bb\u5f00")) {
                  this.exitNidus();
               }
            } else if (Ms.i().key_S2()) {
               this.exitNidus();
            }
         } else if (this.b_c == -2 && Ms.i().key_Left_Right()) {
            this.popMenu = Ms.i().select(this.popMenu, 0, 4);
            if (this.getRid(this.popMenu) == -2) {
               this.bg_c = this.popMenu;
            } else {
               this.bg_c = this.monster_pro[this.getNid(this.popMenu)][6];
               this.mon_action = (byte)(this.bg_c + 23);
            }
         } else if (Ms.i().key_S1_Num5()) {
            if (this.getRid(this.popMenu) != -2) {
               if (this.b_c == -2 && this.getNexp(this.popMenu, 1) == this.getNexp(this.popMenu, 3)) {
                  if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
                     this.say("\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1", 0);
                  } else if (this.isEvolveMake(this.getNid(this.popMenu)) == 0) {
                     this.mon_action = (byte)(this.bg_c + 28);
                     this.b_c = 1;
                     this.setNidusPro(this.getNid(this.popMenu), 1);
                     this.delItemEvolve(this.getNid(this.popMenu));
                  } else {
                     this.say("\u6750\u6599\u4e0d\u8db3\uff0c\u4e0d\u80fd\u5b75\u5316", 0);
                  }
               } else if (this.b_c == -1) {
                  this.b_c = -2;
                  this.getMonster(this.getNid(this.popMenu), this.getNLevel(this.popMenu), -2, -1);
                  this.delNidus(this.popMenu);
                  this.initMonStream(0, 56, 1);
               }
            }
         } else if (this.b_c == -2 && Ms.i().key_S2()) {
            this.exitNidus();
         }
      }

   }

   private void key_MONSTER_LIST(Monster[] var1) {
      if (this.popMenu == -1) {
         if (Ms.i().key_S1_Num5() && this.t_length != 0) {
            if (this.view_state == 1) {
               if (this.mini_state == 15) {
                  this.useItem();
               } else if (this.mini_state == 13) {
                  this.keyGetSkill(var1[this.select[0][0]]);
               } else {
                  StringBuffer var3 = new StringBuffer("\u5929\u8d4b#n\u6280\u80fd");
                  if (this.mini_state == 4) {
                     if (var1[this.select[0][0]].monster[5] > 0) {
                        var3.append("#n\u8fdb\u5316");
                     }

                     if (this.t_length > 1) {
                        var3.append("#n\u5b58\u653e#n\u5356\u5ba0");
                     }
                  } else if (this.mini_state == 6) {
                     if (!this.map.gmErr) {
                        var3.append("#n\u53d6\u51fa#n\u5356\u5ba0");
                     } else {
                        var3.append("#n\u5356\u5ba0");
                     }
                  } else {
                     if (this.select[0][0] != 0) {
                        var3.append("#n\u53c2\u6218");
                     }

                     if (var1[this.select[0][0]].monster[5] > 0) {
                        var3.append("#n\u8fdb\u5316");
                     }

                     if (this.t_length > 1) {
                        var3.append("#n\u653e\u751f");
                     }
                  }

                  this.setStringB(var3.toString(), Constants_H.WIDTH, 3);
                  this.popMenu = 0;
               }
            } else if (this.view_state < 0) {
               if (this.mini_state == 15) {
                  this.useItem();
               } else {
                  if (this.select[0][0] != 0) {
                     this.setStringB("\u53c2\u6218#n\u6280\u80fd", Constants_H.WIDTH, 3);
                  } else {
                     this.setStringB("\u6280\u80fd", Constants_H.WIDTH, 3);
                  }

                  this.popMenu = 0;
               }
            }
         } else if (Ms.i().key_S2()) {
            if (this.mini_state == 13) {
               this.goMY_BAG(2);
            } else if (this.view_state == 1) {
               if (this.mini_state == 15) {
                  this.goMY_BAG(0);
                  this.mini_state = 3;
               } else if (this.mini_state != 6 && this.mini_state != 4) {
                  this.doPaint(0);
                  this.goYouPAUSE(1);
               } else if (!this.map.gmErr) {
                  this.doPaint(0);
                  byte var2;
                  if (this.mini_state == 6) {
                     var2 = 1;
                  } else {
                     var2 = 0;
                  }

                  this.goVIEW_COMPUTER(var2);
               } else {
                  this.map.bkEvent_getMon();
               }
            } else if (this.view_state == -2) {
               if (var1[0].monsterPro[0] > 0) {
                  if (this.select[0][0] != 0) {
                     this.initMonStream(2, this.mList_id[var1[0].monster[0]][0], 1);
                  }

                  this.goBattleState();
               } else {
                  this.say("\u5f53\u524d\u5ba0\u7269\u4e0d\u80fd\u53c2\u6218", 0);
               }

               this.view_state = -1;
            } else if (this.view_state == -1) {
               if (this.mini_state == 15) {
                  this.goMY_BAG(0);
               } else {
                  this.say("\u5f53\u524d\u5ba0\u7269\u4e0d\u80fd\u53c2\u6218", 0);
               }
            }
         } else if (Ms.i().key_Up_Down() && this.t_length != 0) {
            Ms.i().selectS(this.select[0], 0, this.t_length, this.list_rows);
            this.initMonStream(2, this.mList_id[var1[this.select[0][0]].monster[0]][0], 1);
            this.setShowPro(var1[this.select[0][0]]);
            this.introT = Constants_H.WIDTH_H;
         }
      } else {
         this.popState();
      }

   }

   private boolean level_up(int var1, int var2) {
      boolean var6;
      short[] var7;
      short var9;
      if (var2 == 0) {
         var9 = this.myMonsters[var1].monster[2];
         Ms.i();
         byte var5 = (byte)(var9 - Ms.skip2);
         var9 = 0;
         Ms.i();
         Ms.skip = this.exp;
         if (this.myMonsters[var1].isMonReel(36)) {
            var9 = (short)(0 + 100);
         }

         short var4 = var9;
         if (this.myMonsters[var1].isMonReel(37)) {
            var4 = (short)(var9 + 200);
         }

         byte var10;
         if (var5 < 0) {
            var10 = 0;
         } else {
            var10 = var5;
            if (var5 > 4) {
               var10 = 5;
            }
         }

         Ms.i();
         Ms.i();
         Ms.skip = (short)(Ms.skip * (9 - var10 * 2) * (var4 + 100) / 1000);
         Ms.i();
         if (Ms.skip < 1) {
            Ms.i();
            Ms.i();
            Ms.skip = Ms.getRandom(6) + 5;
         }

         if (this.battle_type == 3 || this.battle_type == 0) {
            Ms.i();
            Ms.i();
            Ms.skip = (short)(Ms.skip * 3 / 2);
         }

         var7 = this.proReplace[var1];
         Ms.i();
         var7[2] = (short)Ms.skip;
      } else if (var2 == 1) {
         label45: {
            if (this.myMonsters[var1].monster[2] < 60) {
               Ms.i();
               if (Ms.skip > 0) {
                  short var3 = this.getMonsterExp(this.myMonsters[var1]);
                  var9 = this.myMonsters[var1].monsterPro[4];
                  Ms.i();
                  var9 = (short)(var9 + Ms.skip);
                  if (var9 >= var3) {
                     this.myB.cexp = this.myMonsters[var1].monsterPro[4];
                     this.myMonsters[var1].monsterPro[4] = var3;
                     Ms.i();
                     Ms.skip = (short)(var9 - var3);
                  } else {
                     this.myB.cexp = this.myMonsters[var1].monsterPro[4];
                     var7 = this.myMonsters[var1].monsterPro;
                     short var8 = var7[4];
                     Ms.i();
                     var7[4] = (short)(var8 + Ms.skip);
                     Ms.i();
                     Ms.skip = -1;
                  }
                  break label45;
               }
            }

            Ms.i();
            Ms.skip = -1;
            this.proReplace[var1][2] = 0;
         }
      } else if (var2 == 2) {
         Ms.i();
         if (Ms.skip <= -1) {
            var6 = false;
            return var6;
         }

         this.levelPro(var1, false);
         this.getMagic(this.myMonsters[var1]);
         this.levelUp_in_battle[this.myMonsters[var1].monster[1]][0] = 1;
         this.levelUp_in_battle[this.myMonsters[var1].monster[1]][1] = this.getSkill;
         this.myMonsters[var1].monsterPro[4] = 0;
      }

      var6 = true;
      return var6;
   }

   private void loadGame() {
      this.map.firstDrawMap = 0;
      this.buyOk = 0;
      this.map.mapImg = null;
      System.out.println("loadGame 111111111111");
      mc.goGameLoading();
      System.out.println("loadGame 22222222222");
   }

   private boolean magicEffectRate(Battle var1, Monster var2, Monster var3, int var4) {
      boolean var8;
      if (var3.effect != 7) {
         var8 = false;
      } else {
         byte var5 = this.skill[var4][3];
         byte var7 = this.skill[var4][2];
         if (var7 == 0) {
            var8 = false;
         } else {
            byte var6;
            if (var5 == 0) {
               if (var3.isBuffRate(5)) {
                  var6 = (byte)(this.inhesion[5] + var7);
               } else {
                  var6 = var7;
                  if (var3.isBuffRate(6)) {
                     var6 = (byte)(this.inhesion[6] + var7);
                  }
               }
            } else if (var5 == 4) {
               if (var3.isBuffRate(7)) {
                  var6 = (byte)(this.inhesion[7] + var7);
               } else {
                  var6 = var7;
                  if (var3.isBuffRate(8)) {
                     var6 = (byte)(this.inhesion[8] + var7);
                  }
               }
            } else {
               label86: {
                  if (var5 != 2) {
                     var6 = var7;
                     if (var5 != 5) {
                        break label86;
                     }
                  }

                  if (var3.isBuffRate(11)) {
                     var6 = (byte)(this.inhesion[11] + var7);
                  } else {
                     var6 = var7;
                     if (var3.isBuffRate(12)) {
                        var6 = (byte)(this.inhesion[12] + var7);
                     }
                  }
               }
            }

            Ms.i();
            if (Ms.getRandom(100) < var6) {
               var3.effect = var5;
               if (var5 != 3 && var5 != 4 && var5 != 5) {
                  if (var5 == 2) {
                     if (var2.isMonReel(32)) {
                        var6 = 5;
                     } else {
                        var6 = 4;
                     }

                     var3.effect_time = (byte)var6;
                  } else if (var5 == 0) {
                     var3.effect_time = 2;
                  } else if (var5 == 6) {
                     if (var3.monster[3] == -1) {
                        var3.effect = 7;
                        this.say("\u5c01\u95ed\u6548\u679c\uff0c\u5bf9\u5e7d\u6697\u9b3c\u738b\u4e0d\u8d77\u4f5c\u7528", -1);
                     } else {
                        var3.effect_time = 4;
                     }
                  }
               } else {
                  var3.effect_time = 4;
               }

               if (var5 == 5) {
                  byte var9;
                  if (var2.isMonReel(31)) {
                     var9 = this.skill[31][0];
                  } else {
                     var9 = 1;
                  }

                  var1.fs_level = (byte)(var9 + var4);
               }

               var8 = true;
            } else {
               var8 = false;
            }
         }
      }

      return var8;
   }

   private byte monsterRemove(int var1) {
      byte var2;
      if (this.myMon_length > 1) {
         this.myMonsters[var1] = null;

         byte var3;
         for(var3 = (byte)var1; var3 < this.myMon_length - 1; ++var3) {
            this.myMonsters[var3] = this.myMonsters[var3 + 1];
            this.evolve[var3] = this.evolve[var3 + 1];
         }

         for(var3 = this.myMon_length; var3 < this.myMonsters.length; ++var3) {
            this.evolve[var3] = true;
         }

         --this.myMon_length;
         var2 = 1;
      } else {
         var2 = -1;
      }

      return var2;
   }

   private void mpAdd(int var1) {
      if (this.myMonsters[this.select[0][0]].monsterPro[1] < this.myMonsters[this.select[0][0]].monsterPro[3] && this.myMonsters[this.select_T].monsterPro[0] > 0) {
         this.AddMP(this.myMonsters[this.select[0][0]].monsterPro[3] * var1 / 100, this.myMonsters[this.select[0][0]]);
         this.useState(0, this.select_it[0]);
      } else if (this.myMonsters[this.select[0][0]].monsterPro[1] < 1) {
         this.say(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]) + "\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u65e0\u6cd5\u4f7f\u7528\uff01", 0);
      } else {
         this.say(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]) + "\u4e0d\u9700\u8981\u4f7f\u7528\u8fd9\u4e2a\u9053\u5177", 0);
      }

   }

   private void paintBATTLE_OVER() {
      if (this.b_c == 1) {
         this.drawEvolveUI(0, this.myB.now_id, false);
      }

   }

   private void paintBattleState(Graphics var1) {
      switch (this.battle_state) {
         case -5:
            if (this.proReplace[this.myB.now_id][2] > -1) {
               String var2 = this.getNameMon(this.myMonsters[this.myB.now_id].monster[0]) + "\u83b7\u5f97\u7ecf\u9a8c\uff1a";
               Log.e("sk", "\u83b7\u5f97\u7ecf\u9a8c");
               Ui.i().drawString(var2, 204, 308, 36, 1, 0);
               Ui.i().drawNum("" + this.proReplace[this.myB.now_id][2], 220, 315, 0, 1);
            } else if (this.proReplace[this.myB.now_id][2] == -1) {
               Ui.i().drawString("\u60a8\u7684\u5ba0\u7269\u5df2\u7ecf\u65e0\u6cd5\u83b7\u5f97\u7ecf\u9a8c", 204, 282, 36, 7, 0);
               Ms.i().sleep(600);
            }
         case -4:
         case 0:
         case 1:
         case 2:
         case 4:
         case 5:
         default:
            break;
         case -3:
            if (this.drawHitOne(this.am, this.dm, this.getBXY(this.mini_state ^ 1, 25, true) - 15, this.getBXY(this.mini_state ^ 1, 25, false) - 34) && this.runHitToState(this.dm, this.am, this.mini_state ^ 1)) {
               this.battle_state = 9;
               this.effectR(this.dm.getMon());
            }
            break;
         case -2:
            if (this.drawHitOne(this.dm, this.am, this.getBXY(this.mini_state, this.am.skill, true) - 15, this.getBXY(this.mini_state, this.am.skill, false) - 34) && this.drawHitOne(this.am, this.dm, this.getBXY(this.mini_state ^ 1, 25, true) - 15, this.getBXY(this.mini_state ^ 1, 25, false) - 34) && this.runHitToState(this.am, this.dm, this.mini_state)) {
               this.battle_state = -3;
               this.am.initHit();
               this.doEffectValue(this.am);
               this.doBuffValue(this.am);
            }
            break;
         case -1:
            this.drawAnimationBattle(this.am, this.mini_state);
            break;
         case 3:
            Ui.i().drawK0(320 - 150, 50, 300, 193, 0);
            Ui.i().sliding(320 + 125, 60, 173, this.select[0][0], this.skill_list[8], false);
            this.drawSkillList(320 - 150 + 10, 60, 250, 28, 6, this.select[0]);
            this.showStringM(this.skill_help[this.skill_list[this.select[0][0]]].toString(), 320, 269, 7, 0);
            Ui.i().drawYesNo(true, true);
      }

   }

   private void popBagMenu(int var1, int var2) {
      String var4 = "\u8fd4\u56de";
      byte var5 = this.items[var1][var2][0];
      String var3;
      if ((var1 == 0 || var5 == 32 || var5 == 33) && this.isBagUse(var5)) {
         var3 = "\u4f7f\u7528#n\u8fd4\u56de";
      } else if (var1 == 2) {
         var3 = "\u5b66\u4e60#n\u8fd4\u56de";
      } else {
         var3 = var4;
         if (this.view_state == 2) {
            var3 = var4;
            if (var1 == 3) {
               var3 = "\u5b75\u5316#n\u8fd4\u56de";
            }
         }
      }

      this.setStringB(var3, Constants_H.WIDTH, 0);
      this.popMenu = 0;
   }

   private void popBagState() {
      if (Ms.i().key_Up_Down()) {
         this.popMenu = Ms.i().select(this.popMenu, 0, this.about_a.length - 1);
      }

      if (Ms.i().key_S1_Num5()) {
         byte var2 = this.items[this.selectx][this.select[0][0]][0];
         if (!Ms.i().equals(this.about_a[this.popMenu], "\u4f7f\u7528")) {
            if (Ms.i().equals(this.about_a[this.popMenu], "\u5b66\u4e60")) {
               this.mini_state = 13;
               this.getSkill = (byte)(var2 - 9);
               this.goVIEW_MONSTER();
            } else if (Ms.i().equals(this.about_a[this.popMenu], "\u5b75\u5316")) {
               if (this.addNidus(var2 - 58)) {
                  this.deleteItems(var2, 1);
                  this.select_it[this.selectx] = this.select[0][0];
                  this.select_st[this.selectx] = this.select[0][1];
               } else {
                  this.say("\u5b75\u5316\u6240\u5df2\u7ecf\u6ca1\u6709\u7a7a\u4f4d\u4e86", 0);
               }

               this.popMenu = -1;
            } else {
               this.popMenu = -1;
            }
         } else {
            switch (var2) {
               case 9:
               case 10:
               case 11:
                  if (this.battle_type != 4 && this.battle_type != 1) {
                     this.say("\u7279\u6b8a\u60c5\u51b5\uff0c\u65e0\u6cd5\u6355\u83b7\uff01", 1);
                     Ms.i().sleep(400);
                     break;
                  }

                  this.goCatchMonster();
                  break;
               case 14:
               case 15:
                  this.popMenu = -1;
                  if (this.map.notMeet == 0) {
                     this.map.notMeet(1, var2);
                     this.say("\u4f7f\u7528" + this.getNameItem(var2) + "\uff0c" + "\u83b7\u5f97\u4e86" + "\u8eb2\u907f\u602a\u7269\u6548\u679c", 1);
                     this.deleteItems(var2, 1);
                  } else if (this.map.notMeet == 1) {
                     this.say("\u5df2\u62e5\u6709\u8eb2\u907f\u602a\u7269\u6548\u679c", 0);
                  }
                  break;
               case 32:
               case 33:
                  byte var1;
                  if (var2 == 32) {
                     var1 = 33;
                  } else {
                     var1 = 32;
                  }

                  if (this.findItem(-2, var1, true) > 0) {
                     this.deleteItems(32, 1);
                     this.deleteItems(33, 1);
                     var1 = 3;
                     var2 = 1;
                     byte var3 = -1;
                     Ms.i();
                     byte var4 = (byte)Ms.getRandom(100);
                     if (var4 < 70) {
                        var1 = 0;
                     } else if (var4 < 85) {
                        var1 = 1;
                     } else if (var4 < 95) {
                        var1 = 2;
                     }

                     Ms.i();

                     label96: {
                        for(var4 = (byte)Ms.getRandom(100); var2 < this.itemMine[var1].length; var2 = (byte)(var2 + 2)) {
                           if (var4 < this.itemMine[var1][var2]) {
                              var2 = this.itemMine[var1][var2 - 1];
                              break label96;
                           }
                        }

                        var2 = var3;
                     }

                     byte var7;
                     if (var2 == 34 && this.findItem(-2, var2, true) > 0) {
                        var7 = -1;
                     } else {
                        label114: {
                           if (var2 != -1) {
                              var7 = var2;
                              if (this.findItem(-2, var2, true) < 99) {
                                 break label114;
                              }
                           }

                           var7 = -1;
                        }
                     }

                     if (var7 != -1) {
                        this.addItem(var7, 1);
                        this.say("\u83b7\u5f97\uff1a" + this.getNameItem(var7) + "x1", 0);
                     } else {
                        this.say("\u8fd9\u4e2a\u5b9d\u7bb1\u662f\u7a7a\u7684\u3002", 0);
                     }
                  } else {
                     StringBuilder var6 = new StringBuilder("\u6ca1\u6709");
                     String var5;
                     if (var2 == 32) {
                        var5 = "\u94a5\u5319\uff0c\u94a5\u5319\u5728\u5546\u5e97\u4e2d\u53ef\u4ee5\u8d2d\u4e70\u3002";
                     } else {
                        var5 = "\u5b9d\u7bb1\uff0c\u5b9d\u7bb1\u5728\u6218\u6597\u540e\u4e00\u5b9a\u51e0\u7387\u83b7\u5f97\u3002";
                     }

                     this.say(var6.append(var5).toString(), 0);
                  }

                  this.popMenu = -1;
                  break;
               default:
                  this.goVIEW_MONSTER();
                  this.mini_state = 15;
            }
         }

         Ms.i().correctSelect(this.select[0], this.itemsLength[this.selectx], this.list_rows);
      } else if (Ms.i().key_S2()) {
         this.popMenu = -1;
      }

   }

   private void putMonster() {
      if (this.cMon_count >= this.max_monsters) {
         this.say("\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1", 0);
      } else if (!this.isMyMonsters(this.select[0][0])) {
         this.say("\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01", 0);
      } else {
         this.cMonsters[this.cMon_count] = this.myMonsters[this.select[0][0]];
         ++this.cMon_count;
         this.setPutMonster();
      }

   }

   private void resetFealty(int var1) {
      byte var2 = this.initFealty[this.myMonsters[this.select[0][0]].monster[4] / 4];
      if (this.myMonsters[this.select[0][0]].monster[6] < var2 && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
         if (var1 == -1) {
            this.myMonsters[this.select[0][0]].monster[6] = var2;
         } else if (this.myMonsters[this.select[0][0]].monster[6] + var1 > var2) {
            this.myMonsters[this.select[0][0]].monster[6] = var2;
         } else {
            byte[] var3 = this.myMonsters[this.select[0][0]].monster;
            var3[6] = (byte)(var3[6] + var1);
         }

         this.useState(0, this.select_it[0]);
         if (this.view_state == -1) {
            this.getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
         }
      } else if (this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
         this.say(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]) + "\u5fe0\u8bda\u5ea6\u5df2\u6ee1", 0);
      }

   }

   private void resetMonster(int var1) {
      if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
         this.AddMP(this.myMonsters[this.select[0][0]].monsterPro[3] * var1 / 100, this.myMonsters[this.select[0][0]]);
         this.AddHP(this.myMonsters[this.select[0][0]].monsterPro[2] * var1 / 100, this.myMonsters[this.select[0][0]]);
         this.myMonsters[this.select[0][0]].effect = 7;
         this.useState(0, this.select_it[0]);
      } else {
         this.say(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]) + "\u6ca1\u6709\u6b7b\u4ea1\uff01", 0);
      }

   }

   private void restMove(int var1, int var2) {
      this.selectx = this.select[0][1];
      this.selecty = this.select[0][0];
      this.cur_c = (byte)var1;
      byte[] var3 = this.select[0];
      this.select[0][0] = 0;
      var3[1] = 0;
      this.popMenu = (byte)var2;
      this.move_x = 129;
      this.move_y = -14;
   }

   private void runBattleState() {
      this.myB.countS[0] = (byte)Ms.i().mathSpeedN(this.myB.countS[0], this.myB.countS[1], 1, false);
      this.enB.countS[0] = (byte)Ms.i().mathSpeedN(this.enB.countS[0], this.enB.countS[1], 1, false);
      byte var1;
      switch (this.battle_state) {
         case -5:
            if (this.b_c == 0 && this.cur_c >= this.mon_in_battle[0]) {
               this.goBattleOver();
               this.setNidusExp(this.exp);
            } else {
               var1 = this.mon_in_battle[this.cur_c + 1];
               if (this.b_c == 0) {
                  if (this.myMonsters[var1].monsterPro[0] > 0) {
                     if (!this.myMonsters[var1].isMonReel(40)) {
                        byte[] var7 = this.myMonsters[var1].monster;
                        --var7[6];
                     }

                     this.myB.now_id = var1;
                     this.myB.chp = this.myMonsters[var1].monsterPro[0];
                     this.myB.cexp = this.myMonsters[var1].monsterPro[4];
                     this.initMonStream(2, this.mList_id[this.myMonsters[var1].monster[0]][0], 1);
                     if (this.level_up(var1, 0)) {
                        this.b_c = 1;
                     }
                  } else {
                     ++this.cur_c;
                  }
               } else if (this.b_c == 1) {
                  this.level_up(var1, 1);
                  this.b_c = 2;
               } else if (this.b_c == 2 && this.myB.cexp == this.myMonsters[var1].monsterPro[4]) {
                  if (!this.level_up(var1, 2)) {
                     this.b_c = 15;
                  } else {
                     this.b_c = 1;
                  }
               } else if (this.b_c > 2) {
                  boolean var6;
                  if (this.b_c < 21) {
                     var6 = true;
                  } else {
                     var6 = false;
                  }

                  boolean var4;
                  if (this.myB.cexp == this.myMonsters[var1].monsterPro[4]) {
                     var4 = true;
                  } else {
                     var4 = false;
                  }

                  if (var6 & var4) {
                     byte var2 = (byte)(this.b_c - 1);
                     this.b_c = var2;
                     if (var2 == 3) {
                        this.b_c = 0;
                        ++this.cur_c;
                     }
                  }
               }

               this.myB.cexp = Ms.i().mathSpeedN(this.myB.cexp, this.myMonsters[var1].monsterPro[4], 8, false);
            }
            break;
         case -4:
            if (this.say_c == 0) {
               var1 = (byte)(this.cur_b + 1);
               this.cur_b = var1;
               if (var1 >= this.about_a.length) {
                  this.about_a = null;
                  this.goBattleExp(true);
               } else {
                  Log.e("soars", this.about_a[this.cur_b].toString());
                  this.say(this.about_a[this.cur_b].toString(), 0);
               }
            }
         case -3:
         default:
            break;
         case 1:
            if (this.bufferAI(this.enB.getMon())) {
               this.aiEnemy();
               if (this.enB.getMon().effect != 6 || this.getSkillLevel(this.enB.skill) <= 3) {
                  this.setAcionSkill(this.enB);
               }
            } else {
               this.enB.act_num = 0;
               this.battle_state = -2;
            }
            break;
         case 9:
            if (this.myB.act_num == 0 && this.enB.act_num == 0) {
               this.myB.act_num = 1;
               this.enB.act_num = 1;
               if (!this.myB.getMon().isMonEffect(0)) {
                  this.setAimBattle(1);
                  this.goBattleState();
                  String var5 = "";
                  if (this.myB.getMon().isMonEffect(2)) {
                     var5 = "\u6495\u88c2\u6548\u679c\uff0c\u51cf\u5c11\u5f53\u524d\u8840\u91cf\u768410%";
                  } else if (this.myB.getMon().isMonEffect(3)) {
                     var5 = "\u9b45\u60d1\u6548\u679c\uff0c\u4e0d\u80fd\u9003\u8dd1\uff0c\u589e\u52a0\u6355\u83b7\u5ba0\u7269\u7684\u51e0\u7387";
                  } else if (this.myB.getMon().isMonEffect(4)) {
                     var5 = "\u7981\u9522\u6548\u679c\uff0c\u4e0d\u80fd\u9003\u8dd1\uff0c\u4e0d\u80fd\u6362\u602a\uff0c\u4e0d\u80fd\u4f7f\u7528\u9053\u5177";
                  } else if (this.myB.getMon().isMonEffect(5)) {
                     var5 = "\u8150\u8680\u6548\u679c\uff0c\u6bcf\u56de\u5408\u53d7\u5230\u4e00\u5b9a\u4f24\u5bb3";
                  }

                  if (!var5.equals("")) {
                     this.say(var5, 0);
                  }

                  return;
               }

               this.myB.act_num = 0;
               this.say("\u77f3\u5316\u6548\u679c\u65e0\u6cd5\u884c\u52a8\uff0c\u53d7\u5230\u7684\u4f24\u5bb3\u51cf\u5c1130%", -1);
            }

            byte var3;
            if (this.myB.act_num != 0 && this.enB.act_num != 0) {
               if (this.myB.getMon().monsterPro[5] >= this.enB.getMon().monsterPro[5]) {
                  var3 = 1;
               } else {
                  var3 = 0;
               }

               this.setAimBattle(var3);
            } else {
               if (this.myB.act_num != 0) {
                  var3 = 1;
               } else {
                  var3 = 0;
               }

               this.setAimBattle(var3);
            }

            if (this.mini_state == 1) {
               this.myB.act_num = 0;
               if (this.myB.getMon().monster[6] < 41) {
                  Ms.i();
                  if (Ms.getRandom(100) < 25) {
                     this.say("\u5fe0\u8bda\u5ea6\u8fc7\u4f4e\uff0c\u5ba0\u7269\u4e0d\u670d\u4ece\u4e3b\u4eba\u547d\u4ee4", -1);
                     return;
                  }
               }

               if (this.myB.getMon().isMonEffect(0)) {
                  this.say("\u77f3\u5316\u6548\u679c\u65e0\u6cd5\u884c\u52a8\uff0c\u53d7\u5230\u7684\u4f24\u5bb3\u51cf\u5c1130%", -1);
               } else {
                  this.setAcionSkill(this.myB);
               }
            } else if (this.say_c == 0) {
               this.enB.act_num = 0;
               if (!this.enB.getMon().isMonEffect(0)) {
                  this.battle_state = 1;
               }
            }
      }

   }

   private void runHit() {
      if (!this.am.b_renascence && !this.dm.b_renascence) {
         this.hit_rate(this.am, this.dm, this.am.getMon(), this.dm.getMon(), this.am.skill);
      } else {
         this.am.b_renascence = false;
         this.dm.b_renascence = false;
      }

      this.battle_state = -2;
   }

   private boolean runHitToState(Battle var1, Battle var2, int var3) {
      boolean var4;
      if (var2.getMon().monsterPro[0] > 0) {
         var4 = true;
      } else {
         if (var2.dead == 1) {
            label53: {
               if (var2.getMon().isMonReel(38)) {
                  Ms.i();
                  if (Ms.getRandom(100) < this.skill[38][1]) {
                     this.setRelive(var1, var2);
                     break label53;
                  }
               }

               if (var3 == 0) {
                  this.enB.act_num = 1;
                  if (this.changeMy()) {
                     var4 = false;
                     return var4;
                  }

                  if (this.overMode != 0) {
                     if (this.overMode == 2) {
                        this.map.sIfElse = 1;
                     }

                     this.overMode = 0;
                     this.arangeMonster();
                     this.setNullBattle();
                     this.goGO_RUNINMAP();
                     this.healMonster(false);
                     var4 = false;
                     return var4;
                  }

                  if (SMSSender.i(this).sms_a) {
                     System.out.println("aaaaaaaaaaaaa");
                     if (this.say_c == 0) {
                        this.isKillAll = true;
                        if (!isSay) {
                           this.say("\u643a\u5e26\u7684\u5ba0\u7269\u5168\u90fd\u727a\u7272\u4e86!", -1, 1);
                        }
                     }
                  } else {
                     System.out.println("bbbbbbbbbb");
                     SMSSender.i(this).sms_a = true;
                     this.goGameOver();
                  }
               } else if (var3 == 1) {
                  if (this.changeMon(this.enB, this.enB.mon.length)) {
                     this.setEnemyThrow();
                     this.enB.act_num = 0;
                     run_state = -50;
                     this.t_battle_state = this.battle_state;
                     this.battle_state = 0;
                  } else {
                     this.goBattleItem();
                     if (this.overMode == 2) {
                        this.map.sIfElse = 0;
                     }

                     this.overMode = 0;
                  }
               }
            }
         } else if (var2.action != 2) {
            var2.action = 2;
            this.now_action[this.mini_state] = 0;
            this.now_time[this.mini_state] = 0;
            if (!var2.getMon().isMonReel(40)) {
               byte[] var5 = var2.getMon().monster;
               var5[6] = (byte)(var5[6] - 10);
            }
         }

         var4 = false;
      }

      return var4;
   }

   private void runMonsterAppear() {
      switch (this.battle_state) {
         case 0:
            if (this.myB.throw_state == 2 && this.myB.throw_state == 2) {
               if (this.view_state == -2) {
                  this.setAimBattle(0);
                  this.myB.act_num = 0;
                  this.enB.act_num = 0;
               }

               this.view_state = -1;
               this.goBattleState();
               if (this.t_battle_state != -3 && this.t_battle_state != -2) {
                  this.goSelectAction(this.mini_state);
               } else {
                  this.battle_state = this.t_battle_state;
                  this.t_battle_state = 0;
                  this.getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
               }

               if (this.first_battle == 0) {
                  this.first_battle = 1;
                  int var1 = (byte)(this.myB.getMon().monster[6] - 99);
                  if (var1 > 1) {
                     var1 = 20;
                  } else {
                     var1 = var1 / 20 * 20;
                  }

                  if ((byte)var1 < 0) {
                     this.say("\u5fe0\u8bda\u5ea6\u964d\u4f4e\uff0c\u653b\u51fb\u529b\u4e0b\u964d\uff0c\u8bf7\u53ca\u65f6\u8865\u5145\uff01", 0);
                  }
               }
            }
         default:
      }
   }

   private void runThrowBall(Battle var1, Monster var2, int var3) {
      if (this.src_c[var3 + 2] == 0 && var1.throw_state == -1 && this.src_c[var3] == 12) {
         var1.throw_state = 0;
      } else if (this.src_c[var3 + 2] == 1 && this.src_c[var3] == 0) {
         this.src_c[var3 + 2] = 0;
         this.getBattleBG(var1, var2);
      }

      if (var1.throw_state == 0) {
         var1.cThrow[0] = (byte)Ms.i().mathSpeedN(var1.cThrow[0], 0, 6, false);
         var1.cThrow[1] = (byte)Ms.i().mathSpeedUp(var1.cThrow[1], 62, 2);
         if (var1.cThrow[0] == 0 && var1.cThrow[1] == 0) {
            var1.throw_state = 1;
         }
      } else if (var1.throw_state == 1) {
         if (var1.cThrow[2] < 12) {
            short[] var4 = var1.cThrow;
            ++var4[2];
         } else {
            var1.throw_state = 2;
         }
      }

   }

   private void sellMonster(Monster var1) {
      this.sell_money = var1.monster[2] * var1.monster[4] * 5 + 100;
   }

   private void setAcionSkill(Battle var1) {
      var1.action = 1;
      this.now_action[this.mini_state] = 0;
      this.now_time[this.mini_state] = 0;
      this.battle_state = -1;
      this.setMagic(var1.skill / 5);
   }

   private boolean setCartoonFrameMagic_C(int var1, int var2, int var3, boolean var4) {
      short[] var6 = this.now_time_Magic;
      short var5 = (short)(var6[var1] + 1);
      var6[var1] = var5;
      if (var5 >= this.magic[var2].action(var3, this.now_action_Magic[var1], 1)) {
         var6 = this.now_action_Magic;
         ++var6[var1];
         this.now_time_Magic[var1] = 0;
         if (!var4 && this.now_action_Magic[var1] >= this.magic[var2].aLength(var3)) {
            var6 = this.now_action_Magic;
            --var6[var1];
            var4 = true;
            return var4;
         }
      }

      var4 = false;
      return var4;
   }

   private boolean setCartoonFrame_C(int var1, int var2, int var3, boolean var4) {
      byte[] var6 = this.now_time;
      byte var5 = (byte)(var6[var1] + 1);
      var6[var1] = var5;
      if (var5 >= this.mon[var2].action(var3, this.now_action[var1], 1)) {
         var6 = this.now_action;
         ++var6[var1];
         this.now_time[var1] = 0;
         if (!var4 && this.now_action[var1] >= this.mon[var2].aLength(var3)) {
            var6 = this.now_action;
            --var6[var1];
            var4 = true;
            return var4;
         }
      }

      var4 = false;
      return var4;
   }

   private void setEnemyThrow() {
      this.enemyOff = 63;
      this.enB.cThrow[0] = (byte)(Constants_H.WIDTH - 377 + 20);
      this.enB.cThrow[1] = 60;
      this.enB.cThrow[2] = 0;
      this.setThrow(this.enB, this.enB.getMon(), 0);
      this.getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
      this.getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
   }

   private void setEvolveStringB(Monster var1) {
      byte var5 = (byte)(var1.monster[0] + 1);
      byte var6 = var1.monster[2];
      boolean var4 = false;
      boolean var3 = var4;
      byte var2 = var5;
      if (this.monsterMake[var1.monster[0]][0] > 0) {
         var3 = var4;
         var2 = var5;
         if (this.findItem(-2, 34, true) > 0) {
            var2 = this.monsterMake[var1.monster[0]][0];
            var3 = true;
         }
      }

      this.proReplace = null;
      this.proReplace = new short[1][6];
      this.proReplace[0][0] = (short)(this.getbuffRateV(var1, this.monster_pro[var2][0] + this.monster_pro[var2][7] * var6 / 10) - var1.monsterPro[2]);
      this.proReplace[0][1] = (short)(this.monster_pro[var2][1] + this.monster_pro[var2][8] * var6 / 10 - var1.monsterPro[3]);
      short[] var7 = this.proReplace[0];
      byte var8;
      if (var3) {
         var8 = var1.monster[5];
      } else {
         var8 = 1;
      }

      var7[2] = (short)(-var8);
      this.proReplace[0][3] = (byte)(this.monster_pro[var2][3] + this.monster_pro[var2][10] * var6 / 10 - var1.monsterPro[6]);
      this.proReplace[0][4] = (byte)(this.monster_pro[var2][4] + this.monster_pro[var2][11] * var6 / 10 - var1.monsterPro[7]);
      this.proReplace[0][5] = (byte)(this.monster_pro[var2][2] + this.monster_pro[var2][9] * var6 / 10 - var1.monsterPro[5]);
      this.setStringB("\u751f\u547d\uff1a+" + this.proReplace[0][0] + "#n" + "\u80fd\u91cf" + "\uff1a+" + this.proReplace[0][1] + "#n" + "\u8fdb\u5316" + "\uff1a" + this.proReplace[0][2], Constants_H.WIDTH, 0);
      this.setStringB("\u529b\u91cf\uff1a+" + this.proReplace[0][3] + "#n" + "\u9632\u5fa1" + "\uff1a+" + this.proReplace[0][4] + "#n" + "\u654f\u6377" + "\uff1a+" + this.proReplace[0][5], Constants_H.WIDTH, 1);
      this.proReplace = null;
   }

   private void setMyThrow() {
      this.myB.cThrow[0] = -286;
      this.myB.cThrow[1] = 60;
      this.myB.cThrow[2] = 0;
      this.setThrow(this.myB, this.myB.getMon(), 1);
      this.getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
      this.getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
   }

   private void setNidusPro(int var1, int var2) {
      StringBuffer var3 = new StringBuffer();
      var3.append("\u751f\u547d\uff1a" + (this.monster_pro[var1][0] + this.monster_pro[var1][7] * var2 / 10) + "#n");
      var3.append("\u80fd\u91cf\uff1a" + (this.monster_pro[var1][1] + this.monster_pro[var1][8] * var2 / 10) + "#n");
      var3.append("\u8fdb\u5316\uff1a" + this.monster_pro[var1][12]);
      this.setStringB(var3.toString(), Constants_H.WIDTH, 0);
      var3.delete(0, var3.length());
      var3.append("\u529b\u91cf\uff1a" + (this.monster_pro[var1][3] + this.monster_pro[var1][10] * var2 / 10) + "#n");
      var3.append("\u9632\u5fa1\uff1a" + (this.monster_pro[var1][4] + this.monster_pro[var1][11] * var2 / 10) + "#n");
      var3.append("\u654f\u6377\uff1a" + (this.monster_pro[var1][4] + this.monster_pro[var1][11] * var2 / 10));
      this.setStringB(var3.toString(), Constants_H.WIDTH, 1);
   }

   private void setNullBattle() {
      this.proReplace = null;
      this.effectImage = null;
      this.imgBattle = null;
      this.levelUp_in_battle = null;
      this.myB = null;
      this.enB = null;
   }

   private void setPutMonster() {
      byte var1;
      for(var1 = this.select[0][0]; var1 < this.myMon_length - 1; ++var1) {
         this.myMonsters[var1] = this.myMonsters[var1 + 1];
         this.evolve[var1] = this.evolve[var1 + 1];
      }

      for(var1 = this.myMon_length; var1 < this.myMonsters.length; ++var1) {
         this.evolve[var1] = true;
      }

      --this.myMon_length;
      if (this.select[0][0] == this.myMon_length) {
         byte[] var2 = this.select[0];
         --var2[0];
      }

      this.initMonStream(2, this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0], 1);
      this.setShowPro(this.myMonsters[this.select[0][0]]);
      this.introT = Constants_H.WIDTH_H;
      this.t_length = this.myMon_length;
      this.popMenu = -1;
      Ms.i().correctSelect(this.select[0], this.t_length, this.list_rows);
   }

   private void setRelive(Battle var1, Battle var2) {
      var2.initHit();
      var2.addHit(-var2.getMon().monsterPro[2] * this.skill[38][0] / 100, 1, 1);
      var2.skill = 28;
      var2.dead = 0;
      var2.action = 0;
      var2.b_renascence = true;
      var2.act_num = 0;
      this.battle_state = -1;
      this.setMagic(5);
      this.getHitCoefficient(var2, var2.getMon(), var1.getMon());
      this.setAimBattle(this.mini_state ^ 1);
   }

   private void setShowPro(Monster var1) {
      StringBuffer var2 = new StringBuffer();
      var2.append(var1.monsterPro[6] + "#n");
      var2.append(var1.monsterPro[7] + "#n");
      var2.append(var1.monsterPro[5]);
      this.setStringB(var2.toString(), Constants_H.WIDTH, 2);
   }

   private void setTakenMonster() {
      for(byte var1 = this.select[0][0]; var1 < this.cMon_count - 1; ++var1) {
         this.cMonsters[var1] = this.cMonsters[var1 + 1];
      }

      --this.cMon_count;
      this.t_length = this.cMon_count;
      if (this.select[0][0] == this.cMon_count) {
         byte[] var2 = this.select[0];
         --var2[0];
      }

      if (this.t_length > 0) {
         this.initMonStream(2, this.mList_id[this.cMonsters[this.select[0][0]].monster[0]][0], 1);
         this.setShowPro(this.cMonsters[this.select[0][0]]);
      }

      this.introT = Constants_H.WIDTH_H;
      this.popMenu = -1;
      Ms.i().correctSelect(this.select[0], this.t_length, this.list_rows);
   }

   private void setThrow(Battle var1, Monster var2, int var3) {
      var1.throw_state = -1;
      this.initMonStream(2, this.mList_id[var2.monster[0]][0], var3);
      if (var2.isMonReel(var2.monster[3] + 43)) {
         if (var1.bg_id != var2.monster[3]) {
            this.src_c[var3 + 2] = 1;
         }
      } else if (this.monPro.length != 0 && var1.bg_id != this.monPro[0]) {
         this.src_c[var3 + 2] = 1;
      }

      var1.action = 0;
      var1.dead = 0;
      var1.chp = var2.monsterPro[0];
   }

   private void takenMonster() {
      if (this.myMon_length < this.max_takes) {
         this.myMonsters[this.myMon_length] = this.cMonsters[this.select[0][0]];
         this.evolve[this.myMon_length] = true;
         ++this.myMon_length;
         this.setTakenMonster();
      } else {
         this.say("\u6240\u80fd\u643a\u5e26\u7684\u5ba0\u7269\u5df2\u7ecf\u8fbe\u5230\u4e0a\u9650\uff01", 1);
      }

   }

   private void useItem() {
      switch (this.items[0][this.select_it[0]][0]) {
         case 0:
            this.hpAdd(35, 30);
            break;
         case 1:
            this.hpAdd(65, 30);
            break;
         case 2:
            this.hpAdd(100, 0);
            break;
         case 3:
            this.mpAdd(50);
            break;
         case 4:
            this.mpAdd(100);
            break;
         case 5:
            this.allAdd(50);
            break;
         case 6:
            this.allAdd(100);
            break;
         case 7:
            this.resetMonster(30);
            break;
         case 8:
            this.changeEffect();
         case 9:
         case 10:
         case 11:
         default:
            break;
         case 12:
            this.resetFealty(30);
            break;
         case 13:
            this.resetFealty(-1);
      }

   }

   private void useState(int var1, int var2) {
      mc.paint();
      Ms.i().sleep(200);
      if (this.view_state == -1) {
         this.myB.act_num = 0;
         this.goBattleState();
         this.battle_state = 9;
         this.initMonStream(2, this.mList_id[this.myMonsters[0].monster[0]][0], 1);
      } else {
         this.goMY_BAG(var1);
      }

      this.deleteItems(this.items[var1][var2][0], 1);
   }

   public void Success() {
      synchronized(this){}
      boolean var4 = false;

      try {
         var4 = true;
         SMSSender.i(this).setSendSms(4);

         try {
            SMSSender.i(this);
            if (SMSSender.smsType == 6) {
               SMSSender.i(this).sendSuccess();
               SMSSender.i(this).setSendSms(-1);
               run_state = -10;
               mc.temp_state = run_state;
               mc.setSmsIsSetRun_state(true);
               this.map.setRegState(true);
               var4 = false;
            } else {
               SMSSender.i(this).sendSuccess();
               var4 = false;
            }
         } catch (Exception var5) {
            var5.printStackTrace();
            var4 = false;
         }
      } finally {
         if (var4) {
            ;
         }
      }

   }

   public byte addItem(int var1, int var2) {
      byte var5 = this.findItemType(var1);
      byte var4 = this.findItem(var5, var1, false);
      byte var3;
      byte[] var6;
      if (var4 != -1) {
         var6 = this.items[var5][var4];
         var3 = (byte)(var6[1] + var2);
         var6[1] = var3;
         if (var3 > 99) {
            this.items[var5][var4][1] = 99;
            this.say(this.getNameItem(this.items[var5][var4][0]) + "\u6570\u91cf\u5df2\u5230\u4e0a\u9650", 0);
            var3 = -1;
            return var3;
         }
      } else {
         this.items[var5][this.itemsLength[var5]][0] = (byte)var1;
         this.items[var5][this.itemsLength[var5]][1] = (byte)var2;
         var6 = this.itemsLength;
         ++var6[var5];
      }

      var3 = 1;
      return var3;
   }

   public void addMonInfoListBH() {
      byte[] var1 = this.monInfoList;
      ++var1[104];
      var1 = this.monInfoList;
      ++var1[103];
      if (this.monInfoList[103] == 102) {
         this.say("\u606d\u559c\u60a8\u628a\u6240\u6709\u7684\u5ba0\u7269\u90fd\u6536\u96c6\u9f50\u4e86", 0);
         mc.paint();
         Ms.i().sleep(600);
      }

   }

   public void battleType(int var1) {
      this.battle_type = (byte)var1;
   }

   public boolean checkMonster() {
      byte var1 = 0;

      boolean var2;
      while(true) {
         if (var1 >= this.myMon_length) {
            this.say("\u60a8\u7684\u5ba0\u7269\u4e0d\u9700\u8981\u56de\u590d\uff01", 0);
            var2 = true;
            break;
         }

         if (this.myMonsters[var1].monsterPro[1] < this.myMonsters[var1].monsterPro[3] || this.myMonsters[var1].monsterPro[0] < this.myMonsters[var1].monsterPro[2]) {
            var2 = false;
            break;
         }

         ++var1;
      }

      return var2;
   }

   public void data_init() {
      byte[] var1 = Ms.i().getStream("data/data.d", -1);
      Ms.i();
      Ms.skip = 0;
      this.skill_up = Ms.i().create2Array(var1);
      this.monster_pro = Ms.i().create2Array(var1);
      this.skill = Ms.i().create2Array(var1);
      this.skill_help = Ms.i().createStringArray(var1);
      this.skill_name = Ms.i().createStringArray(var1);
      this.monsterT = Ms.i().createStringArray(var1);
      this.NAME = Ms.i().createStringArray(var1);
      this.item_help = Ms.i().createStringArray(var1);
      this.item_name = Ms.i().createStringArray(var1);
      this.city_name = Ms.i().createStringArray(var1);
      this.buff_name = Ms.i().createStringArray(var1);
      this.buff_help = Ms.i().createStringArray(var1);
      this.monAppearMap = Ms.i().create2Array(var1);
      this.mList_id = Ms.i().create2Array(var1);
      this.monsterMake = Ms.i().create2Array(var1);
      this.monsterInfo = Ms.i().createStringArray(var1);
      this.inhesion = Ms.i().createArray(var1);
      this.makeLevel = Ms.i().createArray(var1);
      this.musicNo = Ms.i().createArray(var1);
      this.npc2ImageType = Ms.i().createArray(var1);
      this.map.boatCourse = Ms.i().create2Array(var1);
      this.nidusList = Ms.i().create2Array(var1);
      var1 = (byte[])null;
   }

   public byte delMonster(int var1) {
      byte var3 = this.myMonsters[var1].monster[0];
      byte var2;
      if (this.monsterRemove(var1) != -1) {
         this.say("\u5931\u53bb\u5ba0\u7269\uff1a" + this.getNameMon(var3), 0);
         var2 = 1;
      } else {
         this.say("\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01", 0);
         var2 = -1;
      }

      return var2;
   }

   public void deleteItems(int var1, int var2) {
      byte var3 = this.findItemType(var1);
      byte var5 = this.findItem(var3, var1, false);
      if (var5 != -1) {
         if (this.items[var3][var5][1] >= var2) {
            byte[] var4 = this.items[var3][var5];
            var4[1] = (byte)(var4[1] - var2);
         }

         if (this.items[var3][var5][1] == 0) {
            this.dItemIn(var3, var5);
         }
      }

   }

   public void doPaint(int var1) {
      if (var1 != 0) {
         this.b_c = (byte)var1;
      } else {
         run_state = -10;
      }

      mc.paint();
   }

   public void doSayOverSms() {
      byte var1 = this.sayOverSms;
      System.out.println("doSayOverSms() sayOverSms= " + this.sayOverSms);
      this.sayOverSms = -1;
      if (var1 == 0) {
         isSay = true;
         SMSSender.i(this).go(4, true);
         isSay = false;
      } else if (var1 == 1) {
         SMSSender.i(this).go(3, true);
      }

   }

   public boolean drawCartoonOne(int var1, int var2, int var3, int var4, int var5, boolean var6, int var7) {
      if (this.now_action[var1] >= this.mon[var2].aLength(var3)) {
         this.now_action[var1] = 0;
      }

      Ui.i().drawFrameOne(this.mon[var2], this.mon[var2].action(var3, this.now_action[var1], 0), var4, var5, var7);
      return this.setCartoonFrame_C(var1, var2, var3, var6);
   }

   public void drawChangeMap(boolean var1, int var2, int var3, int var4, int var5) {
      var2 *= 2;
      if (var1) {
         Ui.i().fillRect(5422575, 0, 0, 640, 360);
      }

      g.setColor(0);
      g.fillRect(var3, var4 + 1, var5, 5);
      g.fillRect(var3 + 1, var4, var5 - 2, 7);
      g.setColor(15400191);
      if ((var5 - 4) * var2 / 60 > var5) {
         g.fillRect(var3 + 2, var4 + 1, var5, 5);
         g.fillRect(var3 + 1, var4 + 2, var5, 3);
      } else {
         g.fillRect(var3 + 2, var4 + 1, (var5 - 4) * var2 / 60, 5);
         g.fillRect(var3 + 1, var4 + 2, (var5 - 2) * var2 / 60, 3);
      }

      if (var1 && Map.npcSp[1][0].img != null) {
         if ((var5 - 4) * var2 / 60 > var5) {
            this.map.drawMyAni(this.map.my, 0, var5, var4 + 10, 5);
         } else {
            this.map.drawMyAni(this.map.my, 0, var3 + (var5 - 4) * var2 / 60, var4 + 10, 5);
         }
      }

   }

   public void drawCityName() {
      int var2 = Constants_H.WIDTH__ / 2;
      if (this.cityName_c != -20) {
         short var3 = (short)(Ms.i().getStringWidth(this.city_name[this.map.mapNo].toString()) + 8);
         Ui var4 = Ui.i();
         byte var1;
         if (this.cityName_c > 0) {
            var1 = 0;
         } else {
            var1 = this.cityName_c;
         }

         var4.drawKuang(var2 - (var3 >> 1), var1, var3, 25 + 6);
         Ui var5 = Ui.i();
         String var6 = this.city_name[this.map.mapNo].toString();
         if (this.cityName_c > 0) {
            var1 = 0;
         } else {
            var1 = this.cityName_c;
         }

         var5.drawString(var6, var2, var1, 17, 4, 2);
         --this.cityName_c;
      }

   }

   public void drawEvolveUI(int var1, int var2, boolean var3) {
      Ui.i().fillRectB();
      this.drawBG0(this.bg_c, 200, 108, 5, 230);
      byte var4;
      if (var1 == 1 && this.b_c > 0) {
         label73: {
            if (this.b_c == 1) {
               byte var5;
               if (5 == 5) {
                  var5 = 6;
               } else {
                  var5 = 1;
               }

               if (this.drawMagicC(5, 5, var5, 377, 97, 0)) {
                  this.initMonStream(2, this.mList_id[this.myMonsters[var2].monster[0]][0], 1);
                  this.b_c = 2;
                  break label73;
               }
            }

            if (this.b_c > 1 && this.b_c < 14) {
               this.drawClipPic(this.mList_id[this.myMonsters[var2].monster[0]][1], 1, 377, 97, 80, 77, 15, this.b_c - 2, 0);
               var4 = (byte)(this.b_c + 1);
               this.b_c = var4;
               if (var4 == 14) {
                  this.b_c = -1;
                  this.say("\u8fdb\u5316\u6210  " + this.getNameMon(this.myMonsters[var2].monster[0]), 0);
               }
            }
         }
      } else {
         this.drawCartoonOne(1, 1, this.mList_id[this.myMonsters[var2].monster[0]][1] * 3, 377 - this.move_x, 97 - this.move_y, true, 0);
      }

      if (var1 == 1 && this.popMenu == 1) {
         this.drawEvolveMake(this.myMonsters[var2].monster[0], 200 + 25, 108 + 25 + 22, 28);
      } else {
         Ui.i().drawStringY(this.about_b, 200 + 25 - 16, 108 + 25 + 22, 0, 3, 40, 3, 0);
         Ui.i().drawStringY(this.about_a, 200 + 125 - 3, 108 + 25 + 22, 0, 3, 40, 3, 0);
      }

      if (var1 == 0) {
         this.move_y = 0;
         this.move_x = 0;
         Ui var7 = Ui.i();
         String var6 = this.getNameMon(this.myMonsters[var2].monster[0]) + "\u5347\u5230\u4e86" + this.myMonsters[var2].monster[2] + "\u7ea7";
         Graphics var8 = g;
         var8 = g;
         var7.drawString(var6, 432, 108 + 4, 8 | 16, 1, 0);
         Ui.i().drawImage(this.imgItem[1], 200 - this.say_s, 108 - 4, 36);
         byte[][] var10 = this.levelUp_in_battle;
         if (var3) {
            var1 = var2;
         } else {
            var1 = this.myMonsters[var2].monster[1];
         }

         if (var10[var1][1] != -1) {
            var7 = Ui.i();
            StringBuilder var11 = new StringBuilder("\u4e60\u5f97\u6280\u80fd\uff1a");
            byte[][] var13 = this.levelUp_in_battle;
            if (var3) {
               var1 = var2;
            } else {
               var1 = this.myMonsters[var2].monster[1];
            }

            var7.drawString(var11.append(this.getNameSkill(var13[var1][1])).toString(), 320, 360 - 60, 17, 9, 0);
         }
      } else if (var1 == 1) {
         Ui var12 = Ui.i();
         byte var9;
         if (this.popMenu == 0) {
            var9 = -127;
         } else {
            var9 = 15;
         }

         var12.drawK1(320 + var9, 108 + 6, 113, 27, 4);
         var12 = Ui.i();
         if (this.popMenu == 0) {
            var9 = 0;
         } else {
            var9 = 1;
         }

         var12.drawString("\u57fa\u672c\u5c5e\u6027", 320 - 75 + 4, 108 + 5, 17, var9, 0);
         var12 = Ui.i();
         if (this.popMenu == 0) {
            var9 = 1;
         } else {
            var9 = 0;
         }

         var12.drawString("\u8fdb\u5316\u7d20\u6750", 320 + 75 - 4, 108 + 5, 17, var9, 0);
         var4 = this.pkey.selectMenuX(2, 0, 108 + 5, 320, 33);
         if (var4 != -1) {
            this.popMenu = var4;
         }

         Ui.i().drawTriangle(320, 108 + 15, 150, true, true);
         this.move_x = Ms.i().mathSpeedDown(this.move_x, 3, false);
         this.move_y = Ms.i().mathSpeedDown(this.move_y, 3, false);
         Ui.i().drawString("\u786e\u5b9a\u8fdb\u5316\u8be5\u5ba0\u7269\uff1f", 320, 360 - 25 - 22, 17, 0, 1);
      }

      Ui.i().drawYesNo(true, true);
   }

   public void drawFealty(int var1, int var2, int var3, int var4) {
      for(byte var5 = 0; var5 < var1; ++var5) {
         Ui var7 = Ui.i();
         byte var6;
         if (var5 > var2) {
            var6 = 22;
         } else {
            var6 = 21;
         }

         var7.drawUi(var6, var5 * 14 + var3, var4, 0, 0);
      }

   }

   public void drawItem(int var1, int var2, int var3, int var4) {
      int var5;
      if (var1 >= 58) {
         var5 = this.monster_pro[this.nidusList[0][var1 - 58]][6] + 40;
      } else {
         var5 = var1;
         if (var1 >= 35) {
            var5 = this.makeLevel[var1 - 35] + 34;
         }
      }

      Ui.i().drawRegion(this.item_img, this.item_modules[var5][0], this.item_modules[var5][1], this.item_modules[var5][2], this.item_modules[var5][3], var2, var3, var4, 0, g);
   }

   public boolean drawMagicC(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var9;
      if (this.now_action_Magic[var1] >= this.magic[var2].aLength(var3)) {
         this.now_action_Magic[var1] = 0;
         var9 = true;
      } else {
         short var8;
         for(var8 = (short)this.magic[var2].action(var3, this.now_action_Magic[var1], 0); this.dm != null && var8 < 2; var8 = (short)this.magic[var2].action(var3, this.now_action_Magic[var1], 0)) {
            if (var8 == 0) {
               this.dm.ceff[0] = 2;
            }

            this.now_time_Magic[var1] = 0;
            short[] var10 = this.now_action_Magic;
            short var7 = (short)(var10[var1] + 1);
            var10[var1] = var7;
            if (var7 >= this.magic[var2].aLength(var3)) {
               this.now_action_Magic[var1] = 0;
               var9 = true;
               return var9;
            }
         }

         Ui.i().drawFrameOne(this.magic[var2], var8, var4, var5, var6);
         var9 = this.setCartoonFrameMagic_C(var1, var2, var3, true);
      }

      return var9;
   }

   public void drawMoney(int var1, int var2, int var3, boolean var4) {
      int var5;
      if (var4) {
         var5 = this.coin;
      } else {
         var5 = this.money;
      }

      StringBuilder var8 = new StringBuilder(String.valueOf(var5));
      String var7;
      if (var4) {
         var7 = "\u5fbd\u7ae0";
      } else {
         var7 = "\u91d1";
      }

      var7 = var8.append(var7).toString();
      Ui var11 = Ui.i();
      byte var10;
      if (var4) {
         var10 = 53;
      } else {
         var10 = 52;
      }

      int var6 = Ms.i().getStringWidth(var7);
      Graphics var9 = g;
      var9 = g;
      var11.drawUi(var10, var1 - (var6 >> 1) - 1, var2, 8 | 32, 0);
      var11 = Ui.i();
      var9 = g;
      var9 = g;
      var11.drawString(var7, var1, var2 + 3, 1 | 32, var3, 1);
   }

   public void drawMyMon() {
      this.drawEffectImage(this.myB.getMon(), 220, 164);
      byte var4 = this.mList_id[this.myB.getMon().monster[0]][1];
      short var3 = this.myB.action;
      byte var1;
      if (this.myB.ceff[0] != 0) {
         var1 = -3;
      } else {
         var1 = 0;
      }

      short var2;
      if (this.myB.ceff[0] != 0) {
         var2 = 3;
      } else {
         var2 = 0;
      }

      boolean var5;
      if (this.myB.action == 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      if (this.drawCartoonOne(1, 1, var4 * 3 + var3, var1 + 266, var2 + 236, var5, 1)) {
         if (this.myB.getMon().monsterPro[0] < 1) {
            this.myB.action = 2;
            this.myB.dead = 1;
         } else {
            this.myB.action = 0;
         }
      }

      this.myB.ceff[0] = (byte)Ms.i().mathSpeedN(this.myB.ceff[0], 0, 1, true);
      this.drawMonsterHp(this.myB.getMon(), 241, 237, 50, 0, 1, this.myB.chp);
      this.drawMonsterHp(this.myB.getMon(), 241, 242, 50, 1, 2, this.myB.getMon().monsterPro[1]);
      Battle var7 = this.myB;
      Ms var6 = Ms.i();
      var3 = this.myB.chp;
      var2 = this.myB.getMon().monsterPro[0];
      if (this.myB.chp < this.myB.getMon().monsterPro[0]) {
         var1 = 20;
      } else {
         var1 = 6;
      }

      var7.chp = var6.mathSpeedN(var3, var2, var1, true);
   }

   public void drawPauseIco(int var1) {
      for(byte var2 = 0; var2 < this.b_ico; ++var2) {
         Ui.i().drawImage(this.imgIco[var2], this.pkey.button_pos[6][var2][0], this.pkey.button_pos[6][var2][1], 0);
      }

   }

   public void exitNidus() {
      run_state = -10;
      this.mon[1] = null;
      this.initNidusMap(1);
   }

   public void falselly(int var1) {
      SMSSender.i(this).setSendSms(-1);
      Exception var10000;
      boolean var10001;
      if (var1 == 7) {
         try {
            SMSSender.i(this).sms_a = true;
            this.goGameOver();
            System.out.println("ccccccccc");
            mc.setSmsIsSetRun_state(true);
            return;
         } catch (Exception var3) {
            var10000 = var3;
            var10001 = false;
         }
      } else if (var1 == 5) {
         try {
            run_state = SMSSender.i(this).getTstate();
            mc.temp_state = run_state;
            mc.setSmsIsSetRun_state(true);
            return;
         } catch (Exception var4) {
            var10000 = var4;
            var10001 = false;
         }
      } else if (var1 == 6) {
         try {
            run_state = -10;
            mc.temp_state = run_state;
            mc.setSmsIsSetRun_state(true);
            System.out.println("  \u6211\u7684mc.setSmsIsSetRun_state(true);");
            this.map.setRegState(false);
            return;
         } catch (Exception var5) {
            var10000 = var5;
            var10001 = false;
         }
      } else {
         if (var1 != 1) {
            return;
         }

         try {
            if (SMSSender.i(this).getSmsSenderMenuState() != 0) {
               Log.d("soars", "soooooooooooooooooooooooooooooooooooooooo");
               mc.setSmsIsSetRun_state(true);
               run_state = SMSSender.i(this).getTstate();
            }

            return;
         } catch (Exception var6) {
            var10000 = var6;
            var10001 = false;
         }
      }

      Exception var2 = var10000;
      var2.printStackTrace();
   }

   public byte findItem(int var1, int var2, boolean var3) {
      byte var5 = 0;
      byte var4 = var5;
      int var6 = var1;
      if (var1 == -2) {
         var6 = this.findItemType(var2);
         var4 = var5;
      }

      while(true) {
         if (var4 >= this.itemsLength[var6]) {
            byte var7;
            if (var3) {
               var7 = 0;
            } else {
               var7 = -1;
            }

            var4 = (byte)var7;
            break;
         }

         if (this.items[var6][var4][0] == var2) {
            if (var3) {
               var4 = this.items[var6][var4][1];
            }
            break;
         }

         ++var4;
      }

      return var4;
   }

   public byte findItemType(int var1) {
      byte var2;
      if (var1 < 16) {
         var2 = 0;
      } else if (var1 < 35) {
         var2 = 1;
      } else if (var1 < 58) {
         var2 = 2;
      } else {
         var2 = 3;
      }

      return var2;
   }

   public byte findMonster(int var1, int var2) {
      byte var3 = 0;

      while(true) {
         if (var3 >= this.myMon_length) {
            var3 = -1;
            break;
         }

         if (this.myMonsters[var3].monster[0] == var1 && this.myMonsters[var3].monster[2] >= var2) {
            break;
         }

         ++var3;
      }

      return var3;
   }

   public byte findMonsterMinLv(int var1, int var2) {
      byte var5 = -1;

      byte var4;
      for(byte var3 = (byte)(this.myMon_length - 1); var3 > -1; var5 = var4) {
         var4 = var5;
         if (this.myMonsters[var3].monster[0] == var1) {
            var4 = var5;
            if (this.myMonsters[var3].monster[2] >= var2) {
               label29: {
                  if (var5 != -1) {
                     var4 = var5;
                     if (this.myMonsters[var3].monster[2] >= this.myMonsters[var5].monster[2]) {
                        break label29;
                     }
                  }

                  var4 = var3;
               }
            }
         }

         --var3;
      }

      return var5;
   }

   public boolean gameCheckRegIsOK() {
      boolean var1;
      if (this.rmsSms[6] == 10) {
         var1 = true;
      } else {
         var1 = false;
      }

      System.out.println("gameCheckRegIsOK reged= " + var1);
      return var1;
   }

   public void getEnemy(byte[] var1, int var2, int var3) {
      if (var2 == -1) {
         Ms.i();
         if (Ms.getRandom(100) < 5 && this.monPro.length > 6) {
            var2 = 6;
         } else {
            byte[] var4 = this.monPro;
            Ms.i();
            if (this.monPro.length > 6) {
               var2 = 3;
            } else {
               var2 = this.monPro.length - 3;
            }

            var2 = var4[Ms.getRandom(var2) + 3];
         }

         Ms.i();
         var1[1] = (byte)(Ms.getRandom(this.monPro[2] + 1) + this.monPro[1]);
      } else {
         var1[1] = (byte)var3;
      }

      var1[0] = (byte)var2;
   }

   public byte getItem(int var1, int var2) {
      byte var3;
      if (this.addItem(var1, var2) == 1) {
         this.say("\u83b7\u5f97\uff1a\u201c" + this.getNameItem((byte)var1) + "\u201dx" + var2, 0);
         var3 = 1;
      } else {
         var3 = -1;
      }

      return var3;
   }

   public byte getItemCount(int var1) {
      byte var2;
      if (this.buyItemID != 2) {
         this.findItemType(var1);

         for(int var3 = 0; var3 < this.items[this.item_type].length; ++var3) {
            if (this.items[this.item_type][var3][0] == var1) {
               var2 = this.items[this.item_type][var3][1];
               return var2;
            }
         }
      }

      var2 = 0;
      return var2;
   }

   public void getMagic(Monster var1) {
      byte[] var3 = new byte[]{0, 7, 14, 21, 28, 35};
      this.getSkill = -1;

      for(byte var2 = 0; var2 < var3.length; ++var2) {
         if (var1.monster[var2 + 8] == -1 && var1.monster[2] >= var3[var2]) {
            this.getSkill(var2, var1.monster[3]);
            var1.monster[var2 + 8] = this.getSkill;
         }
      }

   }

   public byte getMonster(int var1, int var2, int var3, int var4) {
      Monster var6 = new Monster(this, var1, var2, var4);
      byte var5;
      if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
         this.say("\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1", 0);
         var5 = -1;
      } else {
         if (this.getMonster(var6, var3, true) != 1) {
            this.say("\u83b7\u5f97\u5ba0\u7269\uff1a" + this.getNameMon((byte)var1), 0);
         } else {
            this.say("\u643a\u5e26\u5df2\u6ee1\uff0c" + this.getNameMon(var6.monster[0]) + "\u5df2\u8f6c\u5165\u5bc4\u653e\u5904", 0);
         }

         var5 = 1;
      }

      return var5;
   }

   public String getNameCity(int var1) {
      return this.city_name[var1].toString();
   }

   public String getNameItem(int var1) {
      return this.item_name[var1].toString();
   }

   public String getNameMon(int var1) {
      return this.NAME[var1].toString();
   }

   public String getNameMonsterInfo(int var1) {
      return this.monsterInfo[var1].toString();
   }

   public void goBUY_ITEM(int var1, int var2) {
      if (var2 != 1) {
         this.setAction_str(new String[]{"\u9053\u5177", "\u77ff\u77f3", "\u5fbd\u7ae0"});
      } else {
         this.setAction_str(new String[]{"\u9053\u5177", "\u8f85\u52a9", "\u5377\u8f74"});
      }

      this.cur_a = (byte)var1;
      this.cur_b = (byte)var2;
      byte[] var3 = this.select[0];
      this.select[0][0] = 0;
      var3[1] = 0;
      run_state = 18;
      this.list_rows = 6;
      this.buyOk = 0;
      this.popMenu = -1;
      var3 = Ms.i().getStream("data/shop.d", -1);
      Ms.i();
      Ms.skip = 0;
      this.buyItem = Ms.i().create2Array(var3);
      this.buyPrice = Ms.i().createShort2Array(var3, 0);
      var3 = (byte[])null;
   }

   public void goBattle() {
      this.first_battle = 0;
      this.lastSkill = 0;
      this.b_c = 0;
      this.cur_a = 0;
      this.mon_in_battle = null;
      this.mon_in_battle = new byte[this.max_takes + 1];
      this.levelUp_in_battle = null;
      int var2 = this.max_takes;
      this.levelUp_in_battle = new byte[var2][2];
      this.proReplace = null;
      var2 = this.myMonsters.length;
      this.proReplace = new short[var2][7];
      this.myB = new Battle(this.myMonsters);
      this.enemy_init();

      byte var1;
      for(var1 = 0; var1 < this.myMon_length; ++var1) {
         this.myMonsters[var1].effect = 7;
         this.myMonsters[var1].effect_time = 0;
         this.myMonsters[var1].monster[1] = var1;
         this.proReplace[var1][6] = this.myMonsters[var1].monster[2];
      }

      for(byte var5 = 0; var5 < this.myMon_length; ++var5) {
         if (this.myMonsters[var5].monsterPro[0] > 0) {
            byte[] var3 = this.mon_in_battle;
            byte[] var4 = this.mon_in_battle;
            var1 = (byte)(var4[0] + 1);
            var4[0] = var1;
            var3[var1] = this.myMonsters[var5].monster[1];
            if (var5 != 0) {
               this.changeMonster(this.myMonsters[var5], this.myMonsters[0]);
            }
            break;
         }
      }

      if (this.effectImage == null) {
         this.effectImage = Ms.i().createImageArray(7, "data/brow/e");
      }

      if (this.imgBattle == null) {
         this.imgBattle = Ms.i().createImageArray(5, "data/battle/b");
      }

      this.map.my.state = 15;
      run_state = -30;
      this.view_state = -1;
      new CreateThread(this, 1);
   }

   public void goBattlePVC() {
      this.enemyList = null;
      this.enemyList = new byte[1][2];
      this.getEnemy(this.enemyList[0], -1, 0);
      Sound.i().setMusicId(6);
      Sound.i().setMusic(true);
      this.goBattle();
   }

   public void goGameOver() {
      run_state = 60;
   }

   public void goMAIN_MENU() {
      mc.logo_c = 29;
      mc.image_logo = null;
      this.setNull(true);
      this.myMonsters = null;
      this.cMonsters = null;
      System.gc();
      mc.createFlashImage();
      mc.goMain_menu();
      this.setAction_str(new String[]{"\u8bfb\u53d6\u8fdb\u5ea6", "\u65b0\u6e38\u620f", "\u58f0\u97f3", "\u6e38\u620f\u5e2e\u52a9", "\u5173   \u4e8e", "\u9000\u51fa\u6e38\u620f"});
      byte var2;
      if (this.rmsOther[0] == -1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      byte var1 = (byte)var2;
      this.selecty = var1;
      this.selectx = var1;
   }

   public void goNidus(int var1) {
      run_state = 66;
      this.mini_state = 16;
      this.setStringB("\u67e5\u770b\u5b75\u5316#n\u9009\u62e9\u86cb#n\u79bb\u5f00", Constants_H.WIDTH, 3);
      this.popMenu = (byte)var1;
      this.b_c = -2;
   }

   public void goVIEW_COMPUTER(int var1) {
      run_state = 65;
      this.setStringB("\u5b58\u653e#n\u53d6\u51fa#n\u79bb\u5f00", Constants_H.WIDTH, 3);
      this.popMenu = (byte)var1;
   }

   public void goVIEW_MONSTER() {
      run_state = 35;
      this.cur_c = 0;
      this.selecty = 0;
      this.selectx = 0;
      byte var1;
      if (this.mini_state == 6) {
         var1 = this.cMon_count;
      } else {
         var1 = this.myMon_length;
      }

      this.t_length = var1;
      byte[] var2 = this.select[0];
      this.select[0][1] = 0;
      var2[0] = 0;
      this.popMenu = -1;
      this.list_rows = 5;
      this.mon_action = 0;
      this.setStringB("\u751f\u547d#n\u80fd\u91cf#n\u6863\u6b21", Constants_H.WIDTH, 0);
      this.setStringB("\u529b\u91cf#n\u9632\u5fa1#n\u654f\u6377", Constants_H.WIDTH, 1);
      Monster var3;
      if (this.mini_state == 6) {
         var3 = this.cMonsters[this.select[0][0]];
      } else {
         var3 = this.myMonsters[this.select[0][0]];
      }

      this.cur_mon = var3;
      if (this.t_length != 0) {
         this.setShowPro(this.cur_mon);
         this.initMonStream(2, this.mList_id[this.cur_mon.monster[0]][0], 1);
      }

   }

   public void goYouPAUSE(int var1) {
      run_state = 97;
      this.selectx = 0;
      this.selecty = (byte)var1;
      this.setPauseS(0);
      Sound.i().soundStop();
      this.say_c = 0;
      this.view_state = 1;
      this.mini_state = 3;
      this.buyItemID = 0;
      this.buyOk = 0;
      this.gogoString = "\u91d1\u5c5e\u514b\u91ce\u517d\uff0c\u91ce\u517d\u514b\u690d\u7269\uff0c\u690d\u7269\u514b\u98de\u884c\uff0c\u98de\u884c\u514b\u6d77\u6d0b\uff0c\u6d77\u6d0b\u514b\u91d1\u5c5e";
   }

   void healMonster(Monster var1) {
      var1.effect = 7;
      var1.monsterPro[1] = var1.monsterPro[3];
      var1.monsterPro[0] = var1.monsterPro[2];
   }

   public void healMonster(boolean var1) {
      for(byte var2 = 0; var2 < this.myMon_length; ++var2) {
         this.healMonster(this.myMonsters[var2]);
      }

      if (var1) {
         this.say("\u60a8\u643a\u5e26\u7684\u5ba0\u7269\u5df2\u56de\u590d\u3002", 0);
      }

   }

   public void initBattle() {
      System.gc();
      byte[] var3 = this.src_c;
      byte[] var2 = this.src_c;
      byte[] var1 = this.src_c;
      this.src_c[3] = 0;
      var1[2] = 0;
      var2[1] = 0;
      var3[0] = 0;
      this.getBattleBG(this.enB, this.enB.getMon());
      this.getBattleBG(this.myB, this.myB.getMon());
      this.setEnemyThrow();
      this.setMyThrow();
   }

   public void initImgIco() {
      if (this.imgIco == null) {
         this.imgIco = Ms.i().createImageArray_(7, "data/brow/i", 1);
      }

   }

   public void initItemModules() {
      this.item_img = Ms.i().createImage("data/item");
      Ms.i();
      Ms.skip = 0;
      this.item_modules = Ms.i().create2Array(Ms.i().getStream("data/item_m.d", -1));
   }

   public void initMonPro(int var1, boolean var2) {
      Ms.i();
      Ms.skip = 0;
      Ms var5 = Ms.i();
      StringBuilder var4 = new StringBuilder("data/map/");
      String var3;
      if (var2) {
         var3 = "m";
      } else {
         var3 = "boss";
      }

      byte[] var6 = var5.getStream(var4.append(var3).append(var1).append(".d").toString(), -1);
      this.monPro = Ms.i().createArray(var6);
      this.mapMove = Ms.i().createArray(var6);
      this.mapRect = Ms.i().create2Array(var6);
   }

   public void initMonStream(int var1, int var2, int var3) {
      String var5 = "data/npc" + var1 + "/" + var2;
      boolean var4 = true;
      if (var1 == 2) {
         var4 = this.isNpc2ImageType(var2);
      }

      if (this.mon[var3] == null) {
         this.mon[var3] = Ms.i().createSprite(var5, var4);
      } else {
         Ms.i().setSprite(this.mon[var3], var5, var4);
      }

   }

   public void initNidusMap(int var1) {
      if (this.nidusMap == null) {
         this.nidusMap = new byte[5];
      }

      byte var2 = 0;
      byte var3 = 0;
      if (var1 == 0) {
         for(byte var4 = var3; var4 < this.nidusMap.length; ++var4) {
            this.nidusMap[var4] = -1;
         }
      } else {
         for(; var2 < this.nidusMap.length; ++var2) {
            if (this.nidusMap[var2] != -1) {
               if (this.getRid(var2) != -2) {
                  this.map.npc[0][this.nidusMap[var2]].other[4] = 1;
                  this.map.npc[0][this.nidusMap[var2]].other[7] = (byte)(this.monster_pro[this.getNid(var2)][6] + 17);
               } else {
                  this.map.npc[0][this.nidusMap[var2]].other[4] = 0;
               }
            }
         }
      }

   }

   public void initSkillList(Monster var1) {
      this.skill_list[8] = 0;

      byte var3;
      for(var3 = 7; var3 > -1; --var3) {
         this.skill_list[var3] = var1.monster[var3 + 8];
         if (this.skill_list[var3] != -1) {
            byte[] var5 = this.skill_list;
            ++var5[8];
         }
      }

      for(var3 = 1; var3 < 8; ++var3) {
         for(byte var4 = var3; var4 > 0 && this.skill_list[var4] > this.skill_list[var4 - 1]; --var4) {
            byte var2 = this.skill_list[var4];
            this.skill_list[var4] = this.skill_list[var4 - 1];
            this.skill_list[var4 - 1] = var2;
         }
      }

   }

   public boolean isMoney(int var1, boolean var2) {
      if (var2) {
         if (this.money >= var1) {
            this.money -= var1;
            var2 = true;
            return var2;
         }

         this.say("\u91d1\u94b1\u4e0d\u8db3\uff01", 0);
      } else {
         if (this.coin >= var1) {
            this.coin -= var1;
            var2 = true;
            return var2;
         }

         this.say("\u5fbd\u7ae0\u4e0d\u8db3\uff01", 0);
      }

      var2 = false;
      return var2;
   }

   public boolean isMoneyItem(int var1, int var2, int var3, boolean var4) {
      if (this.findItem(-2, var2, true) + var3 > 99) {
         this.say("\u6570\u91cf\u5df2\u5230\u4e0a\u9650", 0);
         var4 = false;
      } else {
         if (var4) {
            if (this.money >= this.sell_money * var3) {
               this.money -= this.sell_money * var3;
               var4 = true;
               return var4;
            }

            if (this.money < this.sell_money * var3) {
               this.say("\u91d1\u94b1\u4e0d\u8db3\uff01", -1, 0);
            } else {
               this.say("\u80cc\u5305\u7a7a\u95f4\u4e0d\u8db3\u3002", 0, -1);
            }
         } else {
            if (this.coin >= this.sell_money * var3) {
               this.coin -= this.sell_money * var3;
               var4 = true;
               return var4;
            }

            if (this.coin < this.sell_money * var3) {
               this.say("\u5fbd\u7ae0\u4e0d\u8db3\uff01", 0);
            } else {
               this.say("\u80cc\u5305\u7a7a\u95f4\u4e0d\u8db3\u3002", 0);
            }
         }

         var4 = false;
      }

      return var4;
   }

   public boolean isNpc2ImageType(int var1) {
      byte var2 = 0;

      boolean var3;
      while(true) {
         if (var2 >= this.npc2ImageType.length) {
            var3 = true;
            break;
         }

         if (this.npc2ImageType[var2] == var1) {
            var3 = false;
            break;
         }

         ++var2;
      }

      return var3;
   }

   public void keyGameOver1(boolean var1) {
      if (Ms.i().key_S1_Num5()) {
         if (this.popMenu == 1) {
            this.goMAIN_MENU();
         } else if (this.popMenu == 0) {
            System.out.println("loadGame soars");
            this.loadGame();
         }

         this.popMenu = -1;
      } else if (Ms.i().key_Up_Down()) {
         this.popMenu = (byte)(this.popMenu ^ 1);
      }

      Ms.i().keyRelease();
   }

   public void keyLIST_INFO() {
      if (!Ms.i().key_delay()) {
         if (Ms.i().key_S1_Num5()) {
            if (this.monInfoList[this.getMonInfo_dir()] != 0) {
               this.goMONSTER_INFO(this.getMonInfo_dir());
            }
         } else if (Ms.i().key_S2()) {
            this.action_str = null;
            this.monInfo_dir = null;
            this.doPaint(0);
            this.goYouPAUSE(3);
         } else if (Ms.i().key_Left_Right()) {
            this.cur_a = Ms.i().select(this.cur_a, 0, 4);
            this.infoStart = 0;
            if (this.cur_a > 0) {
               for(byte var1 = 0; var1 < this.cur_a; ++var1) {
                  this.infoStart = (byte)(this.infoStart + this.monInfo_dir[var1].length);
               }
            }

            this.t_length = (byte)this.monInfo_dir[this.cur_a].length;
            byte[] var2 = this.select[0];
            this.select[0][1] = 0;
            var2[0] = 0;
         } else if (Ms.i().key_Up_Down()) {
            Ms.i().selectS(this.select[0], 0, this.t_length, this.list_rows);
         }
      }

   }

   public void key_gameRun() {
      if (run_state == 98) {
         if (Ms.i().key_Num0() || Ms.i().key_S1_Num5()) {
            mc.doShowNotify();
         }

         Ms.i().keyRelease();
         Log.d("soars", "doShowNotify2");
      } else if (this.say_c > 0) {
         Ms.i().keyRelease();
      } else if (this.say_c < 0) {
         if (this.say_s == 0 && Ms.i().key_S1_Num5()) {
            this.say_c = 0;
            this.doSayOverSms();
         }

         Ms.i().keyRelease();
      } else {
         switch (run_state) {
            case -31:
               this.keyBattleState();
               break;
            case -21:
               SMSSender.i(this).keyLevel();
               Sound.i().soundStop();
               break;
            case -20:
               SMSSender.i(this).key();
               break;
            case -15:
               if (Ms.i().key_delay()) {
                  return;
               }

               if (this.b_c == 1 && this.say_s == 0) {
                  this.b_c = 0;
               }
               break;
            case -10:
               this.map.key_map();
               break;
            case 18:
               this.keyBuyItem();
               break;
            case 25:
               this.keyMY_BAG();
               break;
            case 35:
               if (Ms.i().key_delay()) {
                  return;
               }

               if (this.cur_c == 0) {
                  Monster[] var1;
                  if (this.mini_state == 6) {
                     var1 = this.cMonsters;
                  } else {
                     var1 = this.myMonsters;
                  }

                  this.key_MONSTER_LIST(var1);
               } else if (this.cur_c == 1) {
                  this.keyMagicUI();
               } else if (this.cur_c == 2) {
                  this.keyEvolveUI();
               }
            case 50:
            case 52:
            default:
               break;
            case 51:
               if (Ms.i().key_Num0()) {
                  this.map.my.state = 0;
                  this.map.eventGoing = 2;
                  Ms.i().keyRelease();
                  this.map.dialog_no = -1;
                  this.goGO_RUNINMAP();
               }
               break;
            case 60:
               Ms.i().keyRelease();
               run_state = 61;
               this.setAction_str(new String[]{"\u7ee7\u7eed", "\u653e\u5f03"});
               this.popMenu = 0;
               break;
            case 61:
               this.keyGameOver1(true);
               break;
            case 65:
               if (Ms.i().key_delay()) {
                  return;
               }

               this.popState();
               break;
            case 66:
               this.keyNidus();
               break;
            case 67:
               if (Ms.i().key_S2()) {
                  this.goLIST_INFO(false);
                  Ms.i().keyRelease();
               }
               break;
            case 68:
               this.keyLIST_INFO();
               break;
            case 69:
               Mg.i().key(this);
               break;
            case 97:
               if (Ms.i().key_delay()) {
                  return;
               }

               if (Ms.i().key_S1_Num5()) {
                  Ms.i().keyRelease();
                  if (this.selectx == 0) {
                     if (this.selecty == 0) {
                        if (this.buyOk == 1) {
                           run_state = 100;
                           this.b_c = 0;
                           this.buyOk = 0;
                        } else {
                           this.buyOk = 1;
                        }
                     } else if (this.selecty == 1) {
                        this.goVIEW_MONSTER();
                     } else if (this.selecty == 2) {
                        this.goMY_BAG(0);
                     } else if (this.selecty == 3) {
                        this.goLIST_INFO(true);
                     } else if (this.selecty == 4) {
                        this.map.goMission(0, true);
                     } else if (this.selecty == 5) {
                        this.goRUN_IN_MAP(true);
                        this.action_str = null;
                     }
                  } else if (this.selecty == 0) {
                     if (this.buyOk == 2) {
                        this.loadGame();
                     } else {
                        this.buyOk = 2;
                     }
                  } else if (this.selecty == 1) {
                     this.isChangeSound = true;
                     Sound.i().keyVolume(0);
                  } else if (this.selecty == 2) {
                     mc.goHELP_dialog(1);
                  } else if (this.selecty == 3) {
                     if (this.buyOk == 3) {
                        run_state = 0;
                        this.action_str = null;
                        this.goMAIN_MENU();
                        this.buyOk = 0;
                     } else {
                        this.buyOk = 3;
                     }
                  }
               } else if (Ms.i().key_S2()) {
                  if (this.buyOk == 0) {
                     this.action_str = null;
                     this.goRUN_IN_MAP(true);
                  } else {
                     this.doPaint(0);
                     run_state = 97;
                     this.buyOk = 0;
                  }
               } else if (this.buyOk == 0) {
                  if (Ms.i().key_Left_Right()) {
                     this.selectx = (byte)(this.selectx ^ 1);
                     this.selecty = 0;
                     this.setPauseS(this.selectx);
                  } else if (Ms.i().key_Up_Down()) {
                     this.selecty = Ms.i().select(this.selecty, 0, this.action_str.length - 1);
                  }
               }
         }

         if (Ms.i().key_S1_Num5() || Ms.i().key_S2()) {
            Ms.i().keyRelease();
         }
      }

   }

   public void levelPro(int var1, boolean var2) {
      byte[] var6;
      if (var2) {
         short var4 = (byte)this.proReplace[var1][6];
         var6 = this.monster_pro[this.myMonsters[var1].monster[0]];
         short var5 = (short)(var6[0] + var6[7] * var4 / 10);
         var5 = this.getbuffRateV(this.myMonsters[var1], var5);
         this.proReplace[var1][0] = (short)(this.myMonsters[var1].monsterPro[2] - var5);
         var5 = (short)(var6[1] + var6[8] * var4 / 10);
         this.proReplace[var1][1] = (short)(this.myMonsters[var1].monsterPro[3] - var5);
         var5 = (short)(var6[3] + var6[10] * var4 / 10);
         this.proReplace[var1][3] = (short)(this.myMonsters[var1].monsterPro[6] - var5);
         var5 = (short)(var6[4] + var6[11] * var4 / 10);
         this.proReplace[var1][4] = (short)(this.myMonsters[var1].monsterPro[7] - var5);
         var4 = (short)(var6[2] + var6[9] * var4 / 10);
         this.proReplace[var1][5] = (short)(this.myMonsters[var1].monsterPro[5] - var4);
         var6 = (byte[])null;
      } else {
         var6 = this.myMonsters[var1].monster;
         byte var3 = (byte)(var6[2] + 1);
         var6[2] = var3;
         var6 = this.monster_pro[this.myMonsters[var1].monster[0]];
         this.myMonsters[var1].monsterPro[2] = (short)(var6[0] + var6[7] * var3 / 10);
         this.myMonsters[var1].monsterPro[3] = (short)(var6[1] + var6[8] * var3 / 10);
         this.myMonsters[var1].monsterPro[6] = (byte)(var6[3] + var6[10] * var3 / 10);
         this.myMonsters[var1].monsterPro[7] = (byte)(var6[4] + var6[11] * var3 / 10);
         this.myMonsters[var1].monsterPro[5] = (byte)(var6[2] + var6[9] * var3 / 10);
         this.myMonsters[var1].resetPro(this);
         var6 = (byte[])null;
         this.healMonster(this.myMonsters[var1]);
      }

   }

   public void map_flashString() {
      int var1 = Constants_H.WIDTH__;
      int var2 = Constants_H.HEIGHT__;
      int var3 = Constants_H.HEIGHT__ / 2;
      this.setSay();
      if (this.say_c > 0 && run_state != 98) {
         if (!this.map.fontSizeControl) {
            Ms.i();
            Ms.font.setSize(22);
         }

         StringBuffer[] var4 = this.showS;
         if (this.say_mode == 0) {
            var1 = var3 - (this.showS.length >> 1) * 25 - 12;
         } else {
            var1 = var2 - 50 - 18;
         }

         this.showString(var4, var1, this.say_s, 1);
         if (this.say_s == 0) {
            --this.say_c;
         } else {
            this.say_s = Ms.i().mathSpeedDown(this.say_s, 3, true);
         }
      } else if (this.say_c < 0 && run_state != 98) {
         Ms.i();
         Ms.font.setSize(22);
         this.showString(this.showS, var3 - (this.showS.length >> 1) * 25 - 12, this.say_s, 2);
         if (this.say_s != 0) {
            this.say_s = Ms.i().mathSpeedDown(this.say_s, 3, true);
         }

         if (this.pkey.isSelect(0, 0, var1, var2)) {
            this.pkey.setKey5();
         }
      }

      Ms.i();
      Ms.font.setSize(26);
   }

   public void paint_gameRun(Graphics var1) {
      boolean var2;
      switch (run_state) {
         case -50:
            this.drawBattleBG();
            this.drawSelectMenu(var1, true, 252);
            if (this.src_c[2] == 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            this.drawSrcLine(var1, 15, 124, 10, false, var2);
            if (this.src_c[3] == 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            this.drawSrcLine(var1, 131, 124, 10, true, var2);
            this.drawPlayerAppear(var1);
         case -32:
         case -11:
         case 52:
         default:
            break;
         case -31:
            this.drawBattleBG();
            this.drawPlayer(var1);
            if (this.battle_state != 2) {
               var2 = true;
            } else {
               var2 = false;
            }

            this.drawSelectMenu(var1, var2, 252);
            this.paintBattleState(var1);
            break;
         case -30:
            this.drawDarkScreen();
            break;
         case -21:
            SMSSender.i(this).paintLevel();
            break;
         case -20:
            SMSSender.i(this).paint();
            break;
         case -19:
            this.drawBattleBG();
            this.drawSelectMenu(var1, true, 252);
            this.drawMyMon();
            this.drawEnemy();
            if (this.cThrowY < 17) {
               this.cThrowS += this.cThrowY;
               this.cThrowY = Ms.i().mathSpeedN(this.cThrowY, 17, 2, false);
            }

            this.cThrowX = Ms.i().mathSpeedN(this.cThrowX, 0, 8, false);
            Ui.i().drawImage(this.imgItem[0], 377 - this.cThrowX, this.cThrowS, 1 | 32);
            break;
         case -15:
            this.paintBATTLE_OVER();
            break;
         case -10:
            this.map.paint_map(var1);
            break;
         case 18:
            this.drawBUY_ITEM();
            break;
         case 25:
            this.drawMY_BAG(0, 0, 640, 360);
            break;
         case 35:
            if (this.cur_c == 0) {
               Monster[] var4;
               if (this.mini_state == 6) {
                  var4 = this.cMonsters;
               } else {
                  var4 = this.myMonsters;
               }

               this.drawMONSTER_UI(var4);
            } else if (this.cur_c == 1) {
               Monster var5;
               if (this.mini_state == 6) {
                  var5 = this.cMonsters[this.selecty];
               } else {
                  var5 = this.myMonsters[this.selecty];
               }

               this.drawMagicUI(var5);
            } else if (this.cur_c == 2) {
               this.drawEvolveUI(1, this.selecty, false);
            }
            break;
         case 51:
            this.map.drawBlackSRC(var1, 30, true);
            this.drawZero("\u7ed3\u675f", 360 - 10);
            break;
         case 60:
            mc.drawRectBG();
            this.showString("\u6218\u6597\u5931\u8d25\u4e86,\u8bad\u7ec3\u5e08\u7684\u68a6\u60f3\u4e0d\u80fd\u5b9e\u73b0\u4e86!", 180, 0);
            Ui.i().drawYesNo(true, true);
            break;
         case 61:
            mc.drawRectBG();
            this.showString("\u4f60\u8981\u7ee7\u7eed\u6e38\u620f\uff0c\u786e\u5b9a\u5417\uff1f", 360 - 50, 0);
            this.drawSelectMenu(this.action_str, 320 - 50, 180 - 50, 100, 2, 0, this.popMenu);
            break;
         case 65:
            this.drawVIEW_COMPUTER();
            break;
         case 66:
            this.drawNidus(200, 225);
            break;
         case 67:
            this.drawMONSTER_INFO(this.getMonInfo_dir());
            break;
         case 68:
            this.drawLIST_INFO();
            break;
         case 69:
            Mg.i().paint();
            break;
         case 97:
            Ui.i().drawK0(-2, 0, 640 + 4, 33, 0);
            Ui.i().drawString("\u8bad\u7ec3\u5e08\u7b49\u7ea7\uff1a" + this.rmsOther[3], 320, 2, 17, 1, 2);
            this.drawPauseMenu(320 - 100 - 5, 45, 210, 235);
            Ui.i().drawK0(-2, 360 - 25 - 8, 640 + 4, 33, 0);
            this.gogoWordM(this.gogoString, 360 - 25 - 6, 16, 3, 0, 2);
            if (this.buyOk != 0) {
               String var3 = "\u662f\u5426\u4fdd\u5b58\u6e38\u620f?";
               if (this.buyOk == 2) {
                  var3 = "\u662f\u5426\u8bfb\u53d6\u8fdb\u5ea6?";
               } else if (this.buyOk == 3) {
                  var3 = "\u4e4b\u524d\u672a\u4fdd\u5b58\u7684\u90e8\u5206\u5c06\u4f1a\u4e22\u5931\uff0c\u662f\u5426\u7ee7\u7eed\uff1f";
               }

               this.showString(var3, 60, 0);
            }

            Ui.i().drawYesNo(true, true);
            break;
         case 98:
            mc.drawRectBG();
            Ui.i().drawK1(-5, 360 - 75, 640 + 10, 75, 3);
            this.showStringM("\u6e38\u620f\u6682\u505c\uff0c\u70b9\u51fb\u5c4f\u5e55\u8fd4\u56de\u3002", 320, 360 - 50 - 2, 9, 3);
            break;
         case 100:
            this.b_c = 1;
            this.showString("\u4fdd\u5b58\u6e38\u620f\u4e2d", 20, 0);
      }

      this.map_flashString();
   }

   public void popState() {
      if (this.buyOk == 0 && Ms.i().key_Up_Down()) {
         this.popMenu = Ms.i().select(this.popMenu, 0, this.about_d.length - 1);
      } else if (Ms.i().key_S1_Num5()) {
         byte var1;
         Monster var3;
         if (!Ms.i().equals(this.about_d[this.popMenu], "\u6280\u80fd") && !Ms.i().equals(this.about_d[this.popMenu], "\u5929\u8d4b")) {
            byte[] var6;
            if (Ms.i().equals(this.about_d[this.popMenu], "\u53c2\u6218")) {
               if (this.myMonsters[this.select[0][0]].monsterPro[0] <= 0) {
                  this.say("\u5f53\u524d\u5ba0\u7269\u4e0d\u80fd\u53c2\u6218", 0);
               } else {
                  if (this.view_state < 0) {
                     for(byte var5 = 1; var5 <= this.mon_in_battle[0] && this.mon_in_battle[var5] != this.myMonsters[this.select[0][0]].monster[1]; ++var5) {
                        if (var5 == this.mon_in_battle[0]) {
                           byte[] var4 = this.mon_in_battle;
                           var6 = this.mon_in_battle;
                           var1 = (byte)(var6[0] + 1);
                           var6[0] = var1;
                           var4[var1] = this.myMonsters[this.select[0][0]].monster[1];
                        }
                     }

                     this.initSkillList(this.myMonsters[this.select[0][0]]);
                  }

                  this.changeMonster(this.myMonsters[this.select[0][0]], this.myMonsters[0]);
                  this.initMonStream(2, this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0], 1);
                  this.setShowPro(this.myMonsters[this.select[0][0]]);
                  if (this.view_state < 0) {
                     this.setMyThrow();
                     run_state = -50;
                     this.battle_state = 0;
                     if (this.view_state == -1) {
                        this.myB.act_num = 1;
                        this.enB.act_num = 1;
                     }

                     this.myB.dead = 0;
                     this.first_battle = 0;
                  }

                  this.lastSkill = 0;
               }

               this.popMenu = -1;
            } else if (Ms.i().equals(this.about_d[this.popMenu], "\u8fdb\u5316")) {
               this.setEvolveStringB(this.myMonsters[this.select[0][0]]);
               this.bg_c = this.myMonsters[this.select[0][0]].monster[3];
               this.b_c = 0;
               this.restMove(2, 0);
            } else if (Ms.i().equals(this.about_d[this.popMenu], "\u653e\u751f")) {
               if (!this.isMyMonsters(this.select[0][0])) {
                  this.say("\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01", 0);
               } else if (this.buyOk == 1) {
                  this.buyOk = 0;
                  this.delMonster(this.select[0][0]);
                  if (this.select[0][0] == this.myMon_length) {
                     var6 = this.select[0];
                     --var6[0];
                  }

                  this.initMonStream(2, this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0], 1);
                  this.setShowPro(this.myMonsters[this.select[0][0]]);
                  this.introT = Constants_H.WIDTH_H;
                  this.t_length = this.myMon_length;
                  this.popMenu = -1;
               } else {
                  this.buyOk = 1;
                  this.gogoString = "\u653e\u751f\u7684\u5ba0\u7269\u5c06\u4f1a\u6d88\u5931\uff0c\u662f\u5426\u7ee7\u7eed\uff1f";
               }
            } else if (Ms.i().equals(this.about_d[this.popMenu], "\u5b58\u653e")) {
               if (run_state == 35) {
                  this.putMonster();
               } else {
                  this.mini_state = 4;
                  this.view_state = 1;
                  this.goVIEW_MONSTER();
               }
            } else if (Ms.i().equals(this.about_d[this.popMenu], "\u53d6\u51fa")) {
               if (run_state == 35) {
                  this.takenMonster();
               } else {
                  this.mini_state = 6;
                  this.view_state = 1;
                  this.goVIEW_MONSTER();
               }
            } else if (Ms.i().equals(this.about_d[this.popMenu], "\u5356\u5ba0")) {
               if (this.buyOk == 1) {
                  this.buyOk = 0;
                  this.money += this.sell_money;
                  this.say("\u83b7\u5f97\u91d1\u94b1\uff1a" + this.sell_money, 0);
                  if (this.mini_state == 6) {
                     this.setTakenMonster();
                  } else {
                     this.setPutMonster();
                  }
               } else if (this.mini_state == 4 && !this.isMyMonsters(this.select[0][0])) {
                  this.say("\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01", 0);
               } else {
                  this.buyOk = 1;
                  if (this.mini_state == 4) {
                     var3 = this.myMonsters[this.select[0][0]];
                  } else {
                     var3 = this.cMonsters[this.select[0][0]];
                  }

                  this.sellMonster(var3);
                  this.gogoString = "\u83b7\u5f97\u91d1\u94b1\uff1a" + this.sell_money + "\uff0c\u662f\u5426\u5356\u51fa\uff1f";
               }
            } else if (Ms.i().equals(this.about_d[this.popMenu], "\u79bb\u5f00")) {
               this.goRUN_IN_MAP(false);
            }
         } else {
            if (this.mini_state == 6) {
               var3 = this.cMonsters[this.select[0][0]];
            } else {
               var3 = this.myMonsters[this.select[0][0]];
            }

            this.initSkillList(var3);
            if (this.view_state > 0) {
               if (this.mini_state == 6) {
                  var1 = this.cMonsters[this.select[0][0]].monster[3];
               } else {
                  var1 = this.myMonsters[this.select[0][0]].monster[3];
               }

               this.bg_c = var1;
            } else if (this.view_state < 0 && this.myB != null) {
               this.bg_c = this.myB.bg_id;
            }

            byte var2;
            if (Ms.i().equals(this.about_d[this.popMenu], "\u6280\u80fd")) {
               var2 = 0;
            } else {
               var2 = 1;
            }

            this.restMove(1, var2);
         }
      } else if (Ms.i().key_S2()) {
         if (this.buyOk != 0) {
            this.buyOk = 0;
         } else if (run_state == 65) {
            this.goRUN_IN_MAP(false);
         } else {
            this.popMenu = -1;
         }
      }

   }

   public boolean runPauseIco() {
      byte var1 = 0;

      boolean var2;
      while(true) {
         if (var1 >= this.b_ico) {
            var2 = false;
            break;
         }

         if (this.map.my.state == 0 && this.pkey.isSelect(this.pkey.button_pos[10][var1][0], this.pkey.button_pos[10][var1][1], this.pkey.button_pos[10][var1][2], this.pkey.button_pos[10][var1][3])) {
            if (this.b_ico == 2) {
               this.isTalk = false;
               this.pkey.setKey5();
            }

            this.pkey.initPointer();
            if (var1 == 0) {
               if (this.b_ico == 2) {
                  var1 = 7;
               } else {
                  var1 = 2;
               }

               this.b_ico = (byte)var1;
            } else if (run_state != 98) {
               if (var1 == 3) {
                  this.goYouPAUSE(0);
               } else if (var1 == 6) {
                  SMSSender.i(this).go(0, true);
               } else {
                  if (var1 == 2) {
                     Ms.key = 48;
                  } else if (var1 == 4) {
                     Ms.key = 49;
                  } else if (var1 == 5) {
                     Ms.key = 51;
                  } else if (var1 == 1) {
                     Ms.key = 57;
                  }

                  Ms.keyRepeat = true;
               }

               this.b_ico = 2;
            }

            var2 = true;
            break;
         }

         ++var1;
      }

      return var2;
   }

   public void run_gameRun() {
      byte var1;
      StringBuffer var9;
      switch (run_state) {
         case -87:
         default:
            break;
         case -86:
         case -15:
            if (this.b_c == 0) {
               if (this.levelUp_in_battle[this.myB.getMon().monster[1]][0] == 1) {
                  this.levelUp_in_battle[this.myB.getMon().monster[1]][0] = 0;
                  this.b_c = 1;
                  this.say_s = 52;
                  this.levelPro(this.myB.now_id, true);
                  this.setStringB("\u751f\u547d;+" + this.proReplace[this.myB.now_id][0] + "#n" + "\u80fd\u91cf" + ";+" + this.proReplace[this.myB.now_id][1], Constants_H.WIDTH, 0);
                  this.setStringB("\u529b\u91cf;+" + this.proReplace[this.myB.now_id][3] + "#n" + "\u9632\u5fa1" + ";+" + this.proReplace[this.myB.now_id][4] + "#n" + "\u654f\u6377" + ";+" + this.proReplace[this.myB.now_id][5], Constants_H.WIDTH, 1);
                  this.initMonStream(2, this.mList_id[this.myB.getMon().monster[0]][0], 1);
               } else {
                  Battle var10 = this.myB;
                  ++var10.now_id;
               }

               if (this.myB.now_id >= this.myMon_length) {
                  byte var8 = 0;
                  boolean var7 = false;

                  boolean var4;
                  StringBuffer var12;
                  for(var12 = new StringBuffer(""); var8 < this.myMon_length; var7 = var4) {
                     var4 = var7;
                     if (this.myMonsters[var8].monster[5] > 0) {
                        var4 = var7;
                        if (this.evolve[var8]) {
                           var4 = var7;
                           if (this.isEvolveKind(this.myMonsters[var8].monster[4], this.myMonsters[var8].monster[2]) == -1) {
                              if (!Ms.i().equals(var12, "")) {
                                 var12.append("\u3001");
                              }

                              var12.append(this.getNameMon(this.myMonsters[var8].monster[0]));
                              this.evolve[var8] = false;
                              var4 = true;
                           }
                        }
                     }

                     ++var8;
                  }

                  if (var7) {
                     var12.append("\u53ef\u4ee5\u8fdb\u5316\u4e86");
                  }

                  var9 = new StringBuffer("");
                  var7 = false;

                  for(var8 = 0; var8 < 5; var7 = var4) {
                     var4 = var7;
                     if (this.getRid(var8) != -2) {
                        if (this.getNexp(var8, 1) != this.getNexp(var8, 3)) {
                           var4 = var7;
                        } else {
                           if (!Ms.i().equals(var9, "")) {
                              var9.append("\u3001");
                           }

                           var9.append(this.monsterT[this.monster_pro[this.getNid(var8)][6]] + "\u7684\u5ba0\u7269\u86cb");
                           var4 = true;
                        }
                     }

                     ++var8;
                  }

                  if (var7) {
                     var9.append("\u7ecf\u9a8c\u5df2\u6ee1\uff0c\u53ef\u4ee5\u5b75\u5316\u4e86\u3002");
                     if (!Ms.i().equals(var12, "")) {
                        var12.append("#n");
                     }

                     var12.append(var9.toString());
                  }

                  if (!Ms.i().equals(var12, "")) {
                     this.say(var12.toString(), -1);
                  }

                  this.setNullBattle();
                  this.goGO_RUNINMAP();
               }
            } else if (this.b_c == 1) {
               this.say_s = Ms.i().mathSpeedDown(this.say_s, 4, true);
            }
            break;
         case -50:
            this.runMonsterAppear();
            break;
         case -31:
            this.runBattleState();
            break;
         case -30:
            if (this.createOver == -1) {
               var1 = (byte)(this.b_c + 1);
               this.b_c = var1;
               if (var1 >= 8) {
                  this.goMontsterAppear();
               }
            }
            break;
         case -21:
            SMSSender.i(this).runLevel();
            break;
         case -20:
            SMSSender.i(this).run();
            break;
         case -19:
            if (this.cThrowX == 0 && this.b_c == 0) {
               int var2 = this.items[this.selectx][this.select[0][0]][0];
               this.deleteItems(var2, 1);
               var2 = (short)((new byte[]{1, 3, 14})[var2 - 9] * 30 + 50 - this.enB.getMon().monster[2] + 60 / this.enB.getMon().monster[2] - this.enB.getMon().monsterPro[0] * 100 / this.enB.getMon().monsterPro[2]);
               short var3 = (short)((7 - (this.enB.getMon().monster[5] - 1) * 2) * var2 / 10);
               var2 = var3;
               if (this.enB.getMon().isEffect(3)) {
                  var2 = (short)(var3 + 30);
               }

               byte[] var5 = (byte[])null;
               if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
                  this.say("\u6240\u80fd\u643a\u5e26\u7684\u5ba0\u7269\u5df2\u7ecf\u8fbe\u5230\u4e0a\u9650\uff01", -1);
                  this.enB.act_num = 1;
                  this.myB.act_num = 0;
                  run_state = -31;
                  this.battle_state = 9;
               } else {
                  Ms.i();
                  if (Ms.getRandom(100) < var2) {
                     this.enB.action = 2;
                     this.enB.dead = 1;
                     this.say("\u6355\u83b7" + this.getNameMon(this.enB.getMon().monster[0]) + "\u5df2\u6210\u529f\uff01", 0);
                     if (this.getMonster(this.enB.getMon(), -1, false) == 0) {
                        this.myMonsters[this.myMon_length - 1].monster[1] = (byte)(this.myMon_length - 1);
                     }

                     run_state = -31;
                     this.goBattleExp(false);
                  } else {
                     this.b_c = 1;
                     var9 = new StringBuffer("\u6ca1\u6709\u6355\u83b7\u5230" + this.getNameMon(this.enB.getMon().monster[0]));
                     if (!this.myB.getMon().isMonReel(41) && !this.enB.getMon().isEffect(4) && !this.enB.getMon().isEffect(3)) {
                        StringBuilder var6 = (new StringBuilder("#n")).append(this.getNameMon(this.enB.getMon().monster[0]));
                        Ms.i();
                        var2 = Ms.getRandom(3);
                        var9.append(var6.append((new String[]{"\u6d41\u7740\u6cea\u9003\u8dd1\u4e86\uff01", "\u62fc\u4e86\u547d\u7684\u9003\u8dd1\u4e86\uff01", "\u76ef\u4e86\u4f60\u4e00\u773c\uff0c\u9003\u8d70\u4e86\uff01"})[var2]).toString());
                        String[] var11 = (String[])null;
                     } else {
                        this.enB.act_num = 1;
                        this.myB.act_num = 0;
                        run_state = -31;
                        this.battle_state = 9;
                     }

                     this.say(var9.toString(), 0);
                  }
               }
            } else if (this.b_c == 1 && this.say_c == 0) {
               this.arangeMonster();
               this.setNullBattle();
               this.goGO_RUNINMAP();
            }
            break;
         case -11:
            this.goRUN_IN_MAP(false);
            break;
         case -10:
            this.map.run_map();
            break;
         case 35:
            var1 = (byte)(this.mon_action_c + 1);
            this.mon_action_c = var1;
            if (var1 > 50) {
               this.mon_action_c = 0;
               this.mon_action = 1;
            }

            if (this.cur_c == 2 && this.b_c == -1 && this.say_s == 0) {
               this.goView();
            }
            break;
         case 69:
            Mg.i().run();
            break;
         case 100:
            if (this.b_c == 1) {
               this.saveGame();
               this.say("\u6e38\u620f\u5df2\u4fdd\u5b58\u3002", 0);
               this.b_c = 0;
               this.goRUN_IN_MAP(true);
            }
      }

   }

   public void saveGame() {
      this.map.save();
      this.saveMon(0);
      this.saveMon(1);
      this.saveItem();
      this.saveInfoList();
      this.rmsOther[0] = this.map.mapNo;
      Ms.i().rmsOptions(10, this.rmsOther, 2);
      Ms.i().rmsOptions(3, this.rmsNidus, 2);
      Ms.i().rmsOptions(0, (byte[])null, 4);
   }

   public void say(String var1, int var2) {
      Log.e("soars", var1);
      String var3;
      if (var1.equals("#7\u70b9\u51fb\u5c4f\u5e55\u6216\u7528\u5bfc\u822a\u952e#0\u63a7\u5236\u4e0a\u4e0b\u5de6\u53f3\u79fb\u52a8\u3002")) {
         var3 = "#7\u70b9\u51fb\u5c4f\u5e55#0\u63a7\u5236\u4e0a\u4e0b\u5de6\u53f3\u79fb\u52a8\u3002";
      } else {
         var3 = var1;
         if (var1.contains("\u83dc\u5355\u952e")) {
            var1.replace("\u83dc\u5355\u952e", "\u53f3\u4e0b\u65b9\u5de5\u5177\u6309\u94ae");
            var3 = var1;
         }
      }

      this.sayStr.add(var3);
      this.sayFlag.add(var2);
      this.setSay();
   }

   public void say(String var1, int var2, int var3) {
      this.showS = Ms.i().groupString(var1, Constants_H.WIDTH - 50);
      this.say_s = Constants_H.WIDTH;
      this.say_mode = 0;
      if (var2 == 0) {
         this.say_c = 15;
      } else if (var2 == -1) {
         this.say_c = -1;
         this.sayOverSms = (byte)var3;
      } else if (var2 == 1) {
         this.say_c = 15;
         this.say_mode = 1;
      }

   }

   public void setAimBattle(int var1) {
      this.mini_state = (byte)var1;
      Battle var2;
      if (this.mini_state == 1) {
         var2 = this.myB;
      } else {
         var2 = this.enB;
      }

      this.am = var2;
      if (this.mini_state == 1) {
         var2 = this.enB;
      } else {
         var2 = this.myB;
      }

      this.dm = var2;
   }

   public void setMagic(int var1) {
      int var2 = var1;
      if (var1 > 5) {
         var2 = 5;
      }

      this.initMagicStream(var2);
      this.now_action_Magic[var2] = 0;
      this.now_time_Magic[var2] = 0;
   }

   public void setNull(boolean var1) {
      if (this.map != null) {
         this.map.setNull();
      }

      if (this.mon[0] != null) {
         this.mon[0].nullIMFA();
      }

      if (this.mon[1] != null) {
         this.mon[1].nullIMFA();
      }

      if (var1) {
         this.data_null();
      }

   }

   public void setSay() {
      if (this.say_c == 0 && this.sayStr.size() != 0) {
         String var2 = (String)this.sayStr.remove(0);
         int var1 = (Integer)this.sayFlag.remove(0);
         this.showS = Ms.i().groupString(var2, Constants_H.WIDTH - 50);
         this.say_s = Constants_H.WIDTH;
         this.say_mode = 0;
         if (var1 == 0) {
            this.say_c = 15;
         } else if (var1 == -1) {
            this.say_c = -1;
         } else if (var1 == 1) {
            this.say_c = 15;
            this.say_mode = 1;
         }
      }

   }

   public void skyCheckRegFull(int var1) {
      switch (var1) {
         case 1:
            this.map.setRegState(true);
            mc.skyNewGame();
            break;
         case 2:
            this.map.setRegState(true);
            mc.skyContinueGame();
      }

   }

   public void start() {
      this.goRUN_IN_MAP(true);
      this.map.insertNpc();
      this.line_max = 2;
      this.cityName_c = 25;
      if (this.map.anole_temp != -2) {
         this.map.anole_type = this.map.anole_temp;
         this.map.anole_temp = -2;
         this.map.setAnole();
      }

   }

   public void valueMend(Monster var1) {
      if (var1.monsterPro[0] < 0) {
         var1.monsterPro[0] = 0;
      } else if (var1.monsterPro[0] > var1.monsterPro[2]) {
         var1.monsterPro[0] = var1.monsterPro[2];
      }

      if (var1.monsterPro[1] < 0) {
         var1.monsterPro[1] = 0;
      } else if (var1.monsterPro[1] > var1.monsterPro[3]) {
         var1.monsterPro[1] = var1.monsterPro[3];
      }

   }
}
