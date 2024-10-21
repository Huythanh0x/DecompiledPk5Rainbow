package main.GameRun;
import main.GameRun_F;
import main.MainCanvas;
import java.lang.Boolean;
import java.util.ArrayList;
import dm.Sprite;
import java.lang.String;
import main.Map;
import dm.Ui;
import main.SMSSender;
import com.PetKing5_480x800.PetKing5;
import dm.Monster;
import dm.Ms;
import dm.Battle;
import java.lang.StringBuilder;
import java.lang.Object;
import javax.microedition.lcdui.Image;
import java.lang.StringBuffer;
import java.lang.CharSequence;
import main.PointerKey;
import com.nokia.mid.ui.DirectGraphics;
import main.Constants_H;
import javax.microedition.lcdui.Graphics;
import android.util.Log;
import java.lang.System;
import java.io.PrintStream;
import dm.Npc;
import dm.Sound;
import java.lang.Short;
import java.lang.Class;
import java.lang.reflect.Array;
import java.lang.Exception;
import java.lang.Byte;
import main.CreateThread;
import minigame.Mg;
import javax.microedition.lcdui.Font;
import java.lang.Integer;

public class GameRun extends GameRun_F	// class@000161 from classes.dex
{
    private StringBuffer[] NAME;
    private byte[][] Shuxing;
    Battle am;
    public byte b_c;
    public byte b_ico;
    String[] battleSay;
    public byte battle_state;
    public byte battle_type;
    public byte bg_c;
    private StringBuffer[] buff_help;
    private StringBuffer[] buff_name;
    private byte[][] buyItem;
    public byte buyItemID;
    public byte buyOk;
    private short[][] buyPrice;
    short cThrowS;
    short cThrowX;
    short cThrowY;
    public byte cityName_c;
    private StringBuffer[] city_name;
    public int coin;
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
    public byte immueEnemy;
    private byte infoStart;
    public byte[] inhesion;
    private byte[] initFealty;
    private Boolean isChangeSound;
    public boolean isKillAll;
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
    private byte list_rows;
    public byte[][] mList_id;
    public Sprite[] magic;
    public byte magic_id;
    public int magic_x;
    public int magic_y;
    public byte[] makeLevel;
    public byte[] mapMove;
    public byte[][] mapRect;
    public byte mini_state;
    public Sprite[] mon;
    private byte[][] monAppearMap;
    private byte[][] monInfo_dir;
    public byte[] monPro;
    private byte mon_action;
    private byte mon_action_c;
    public byte[] mon_in_battle;
    public int money;
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
    public byte off;
    public byte overMode;
    public short[][] proReplace;
    public ArrayList sayFlag;
    public byte sayOverSms;
    public ArrayList sayStr;
    public byte say_c;
    public byte say_mode;
    public int say_s;
    public byte select_S;
    public byte select_T;
    int sell_money;
    private byte[][] skill;
    private StringBuffer[] skill_help;
    private byte[] skill_list;
    private StringBuffer[] skill_name;
    private byte[][] skill_up;
    String strHit;
    public byte t_battle_state;
    public byte t_length;
    public byte threadType;
    public byte time_count;
    public byte view_state;
    byte[] zb;
    public static boolean isSay;

    static {
       GameRun.isSay = false;
    }
    public void GameRun(MainCanvas maincanvas){
       super();
       this.immueEnemy = 0;
       this.money = 1000;
       this.coin = 10;
       this.view_state = 1;
       this.threadType = 0;
       this.mini_state = 0;
       this.isKillAll = false;
       this.buyItemID = 0;
       this.battle_state = 0;
       this.buyOk = 0;
       this.off = 0;
       this.list_rows = 8;
       this.infoStart = 0;
       this.sell_money = 0;
       this.mon_action_c = 0;
       this.initFealty = new byte[2]{'d','x'};
       this.isChangeSound = Boolean.valueOf(0);
       this.sayStr = new ArrayList();
       this.sayFlag = new ArrayList();
       this.sayOverSms = -1;
       byte[] uobyteArray = new byte[16];
       uobyteArray[0] = -6;
       uobyteArray[1] = -4;
       uobyteArray[2] = -3;
       uobyteArray[3] = -2;
       uobyteArray[4] = -1;
       uobyteArray[6] = 1;
       uobyteArray[7] = 2;
       uobyteArray[8] = 3;
       uobyteArray[9] = 4;
       uobyteArray[10] = 8;
       uobyteArray[11] = -3;
       uobyteArray[12] = 2;
       uobyteArray[13] = -1;
       uobyteArray[14] = 1;
       uobyteArray[15] = 1;
       this.zb = uobyteArray;
       byte[][] uobyteArray1 = new byte[][5];
       uobyteArray1[0] = new byte[2]{0x02,0x03};
       uobyteArray1[1] = new byte[2]{0x03,0x04};
       byte[] uobyteArray2 = new byte[2];
       uobyteArray2[0] = 4;
       uobyteArray1[2] = uobyteArray2;
       uobyteArray2 = new byte[2];
       uobyteArray2[1] = 1;
       uobyteArray1[3] = uobyteArray2;
       uobyteArray1[4] = new byte[2]{0x01,0x02};
       this.Shuxing = uobyteArray1;
       this.hit_rate = 0;
       this.magic_id = -2;
       this.magic_x = 0;
       this.magic_y = 0;
       Sprite[] spriteArray = new Sprite[2];
       this.mon = spriteArray;
       spriteArray = new Sprite[6];
       this.magic = spriteArray;
       short[] oshortArray = new short[6];
       this.now_action_Magic = oshortArray;
       oshortArray = new short[6];
       this.now_time_Magic = oshortArray;
       this.overMode = 0;
       this.evolve = new boolean[5]{0x01,0x01,0x01,0x01,0x01};
       uobyteArray = new byte[2];
       this.now_action = uobyteArray;
       uobyteArray = new byte[2];
       this.now_time = uobyteArray;
       String[] stringArray = new String[]{"\x65\x02\x4e\x02\x51\x02\x73\x02\x4e\x02\xff\x02\x62\x02\x65\x02\x54\x02\xff\x02","\x80\x02\x9a\x02\x76\x02\x65\x02\x52\x02\x67\x02\x4e\x02\xff\x02\x8b\x02\x7e\x02\x5e\x02\xff\x02","\x5c\x02\x60\x02\x63\x02\x63\x02\x5b\x02\x72\x02\x54\x02\xff\x02"};
       this.battleSay = stringArray;
       this.isUpdateList = false;
       this.first_battle = 0;
       this.lastSkill = 0;
       uobyteArray = new byte[9];
       this.skill_list = uobyteArray;
       this.b_ico = 2;
       GameRun.mc = maincanvas;
       this.map = null;
       this.map = new Map(this);
       this.initOtherImage();
       Ui.i().initUiModules();
       this.loadRmsOther();
       this.loadRmsSms();
       SMSSender.i(this);
       PetKing5.gr = this;
    }
    private void AddHP(int hp,Monster A_Monster){
       A_Monster.monsterPro[0] = ((hp = hp + A_Monster.monsterPro[0]) >= A_Monster.monsterPro[2])? A_Monster.monsterPro[2]: (short)hp;
       return;
    }
    private void AddMP(int hp,Monster A_Monster){
       A_Monster.monsterPro[1] = ((hp = hp + A_Monster.monsterPro[1]) > A_Monster.monsterPro[3])? A_Monster.monsterPro[3]: (short)hp;
       return;
    }
    private void aiEnemy(){
       int ix;
       int ix1;
       byte b = 1;
       byte skill_num = 5;
       Ms.i();
       byte n = (byte)Ms.getRandom(100);
       while (skill_num > -1) {
          ix = skill_num + 8;
          if (this.enB.getMon().monster[ix] != -1) {
             break ;
          }else {
             ix1 = skill_num - b;
             skill_num = (byte)ix1;
          }
       }
       skill_num = (byte)(skill_num + 1);
       if (this.battle_type == 4) {
          switch (skill_num){
              case 1:
                this.enB.skill = 0;
                break;
              case 2:
                this.enB.skill = (n < 65)? b: 0;
                break;
              case 3:
                if (n < 45) {
                   this.enB.skill = 2;
                }else if(n > 75){
                   this.enB.skill = b;
                }else {
                   this.enB.skill = 0;
                }
                break;
              default:
                if (n < 45) {
                   this.enB.skill = (byte)(skill_num - b);
                }else if(n < 75){
                   this.enB.skill = (byte)(skill_num - 2);
                }else if(n < 95){
                   this.enB.skill = (byte)(skill_num - 3);
                }else {
                   this.enB.skill = (byte)(skill_num - 4);
                }
          }
       }else {
          byte i = 0;
          Ms.i();
          byte rand = (byte)Ms.getRandom(100);
          while (i < 2) {
             ix = i + 14;
             switch (this.enB.getMon().monster[ix]){
                 case 27:
                   if (!this.isMonHp(this.enB.getMon(), 50) || rand >= 30) {
                   }
                   break;
                 case 28:
                   if (!this.isMonHp(this.enB.getMon(), 30) || rand >= 30) {
                   }
                   break;
                 default:
                   ix1 = i + 1;
                   i = (byte)ix1;
             }
             this.enB.skill = (byte)(i + 6);
             break ;
          }
          if (i > b) {
             switch (skill_num){
                 case 1:
                   this.enB.skill = 0;
                   break;
                 case 2:
                   this.enB.skill = (n < 20)? 0: b;
                   break;
                 case 3:
                   if (n < 5) {
                      this.enB.skill = 0;
                   }else if(n > 40){
                      this.enB.skill = 2;
                   }else {
                      this.enB.skill = b;
                   }
                   break;
                 case 4:
                   if (n < 15) {
                      this.enB.skill = b;
                   }else if(n < 40){
                      this.enB.skill = 2;
                   }else {
                      this.enB.skill = 3;
                   }
                   break;
                 default:
                   if (n < 60) {
                      this.enB.skill = (byte)(skill_num - b);
                   }else if(n < 85){
                      this.enB.skill = (byte)(skill_num - 2);
                   }else if(n < 95){
                      this.enB.skill = (byte)(skill_num - 3);
                   }else {
                      this.enB.skill = (byte)(skill_num - 4);
                   }
             }
          }
       }
       this.enB.skill = this.enB.getMon().monster[(this.enB.skill + 8)];
       return;
    }
    private void allAdd(int hp){
       boolean bmp = false;
       boolean bhp = false;
       if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
          this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]))+"\x5d\x02\x7e\x02\x6b\x02\x4e\x02\xff\x02\x65\x02\x6c\x02\x4f\x02\x75\x02\xff\x02", 0);
       }else if(this.myMonsters[this.select[0][0]].monsterPro[1] < this.myMonsters[this.select[0][0]].monsterPro[3] && this.myMonsters[this.select[0][0]].monsterPro[0] > 0){
          this.AddMP(((this.myMonsters[this.select[0][0]].monsterPro[3] * hp) / 100), this.myMonsters[this.select[0][0]]);
          bmp = true;
       }
       if (this.myMonsters[this.select[0][0]].monsterPro[0] < this.myMonsters[this.select[0][0]].monsterPro[2] && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
          this.AddHP(((this.myMonsters[this.select[0][0]].monsterPro[2] * hp) / 100), this.myMonsters[this.select[0][0]]);
          bhp = true;
       }
       if (!bhp && !bmp) {
          if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
             this.AddHP(((this.myMonsters[this.select[0][0]].monsterPro[2] * hp) / 100), this.myMonsters[this.select[0][0]]);
             bhp = true;
          }else {
             this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]))+"\x4e\x02\x97\x02\x89\x02\x4f\x02\x75\x02\x8f\x02\x4e\x02\x90\x02\x51\x02", 0);
          }
       }else {
          this.useState(0, this.select_it[0]);
       }
       return;
    }
    private void arangeMonster(){
       if (this.myMon_length > 1) {
          byte i = 0;
          while (true) {
             int ix = this.myMon_length - 1;
             if (i < ix) {
                ix = i + 1;
                byte j = (byte)ix;
                while (j < this.myMon_length) {
                   if (this.myMonsters[i].monster[1] > this.myMonsters[j].monster[1]) {
                      this.changeMonster(this.myMonsters[i], this.myMonsters[j]);
                   }
                   ix = j + 1;
                   j = (byte)ix;
                }
                ix = i + 1;
                i = (byte)ix;
             }
          }
       }
       return;
    }
    private boolean bufferAI(Monster mon){
       int i = (mon.isMonEffect(0))? 0: true;
       return i;
    }
    private void changeEffect(){
       byte b = 7;
       if (this.myMonsters[this.select[0][0]].effect != b) {
          this.myMonsters[this.select[0][0]].effect = b;
          this.useState(0, this.select_it[0]);
       }else {
          this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]))+"\x6c\x02\x67\x02\x5f\x02\x5e\x02\xff\x02", 0);
       }
       return;
    }
    private boolean changeMon(Battle be,int length){
       byte i;
       byte d = 0;
       byte last_id = be.now_id;
       do {
          i = be.now_id + 1;
          i = (byte)i;
          be.now_id = i;
          if (i >= length) {
             be.now_id = 0;
          }
          i = d + 1;
       } while ((d = (byte)i) <= length && (last_id == be.now_id && be.getMon().monsterPro[0] >= 1));
       if (d > length) {
          be.now_id = last_id;
       }
       i = (d <= length)? true: 0;
       return i;
    }
    private void changeMonster(Monster a,Monster b){
       Monster c = new Monster();
       c.monster = a.monster;
       c.effect = a.effect;
       c.monsterPro = a.monsterPro;
       a.monster = b.monster;
       a.effect = b.effect;
       a.monsterPro = b.monsterPro;
       b.monster = c.monster;
       b.effect = c.effect;
       b.monsterPro = c.monsterPro;
       c = null;
    }
    private boolean changeMy(){
       int b;
       byte i = 1;
       while (true) {
          if (i >= this.myMon_length) {
             b = false;
             break ;
          }else if(this.myMonsters[i].monsterPro[0] > 0){
             this.setAimBattle(1);
             this.goVIEW_MONSTER();
             b = 1;
             break ;
          }else {
             b = i + 1;
             i = (byte)b;
          }
       }
       return b;
    }
    private void dItemIn(int item_type,int item_no){
       int i = item_no;
       while (true) {
          int ix = this.itemsLength[item_type] - 1;
          if (i >= ix) {
             break ;
          }else {
             int ix1 = i + 1;
             this.items[item_type][i] = this.items[item_type][ix1];
             i++;
          }
       }
       GameRun titemsLength = this.itemsLength;
       titemsLength[item_type] = (byte)(titemsLength[item_type] - 1);
       this.items[item_type][this.itemsLength[item_type]] = null;
       byte[] uobyteArray = new byte[2];
       this.items[item_type][this.itemsLength[item_type]] = uobyteArray;
       return;
    }
    private void damage(Battle amB,Battle dmB,Monster am,Monster dm,int skill_no,int mini){
       int LevelA = am.monster[2];
       int LevelB = dm.monster[2];
       int DebuffB = 0;
       int StrA = am.monsterPro[6];
       int DefB = dm.monsterPro[7];
       int SkillDam = this.skill[skill_no][0];
       int LevelCha = LevelA - LevelB;
       byte buff = 100;
       int hit = ((((StrA * SkillDam) * (1000 - (DefB * 5))) / 10000) - (DefB / 10)) - (LevelA / (SkillDam * 2));
       hit = (hit + 6) - ((LevelA - 1) / 10);
       if (LevelCha > 10) {
          LevelCha = 10;
       }else if(LevelCha < -10){
          LevelCha = -10;
       }
       hit = (((LevelCha * 4) + 100) * hit) / 100;
       if (dm.effect == null) {
          DebuffB = -30;
       }
       hit = (((amB.countS[1] + DebuffB) + 100) * hit) / 100;
       byte baoji = 1;
       if (am.isBuffRate(9)) {
          Ms.i();
          if (Ms.getRandom(100) >= this.inhesion[9]) {
          label_0090 :
             if (dm.isMonReel(48)) {
                Ms.i();
                if (Ms.getRandom(100) < this.skill[48][0]) {
                label_00b3 :
                   hit = hit >> 1;
                }
             }
             if (am.isBuffRate(10)) {
                Ms.i();
                if (Ms.getRandom(100) < this.inhesion[10]) {
                   hit = (hit * 15) / 10;
                   baoji = 2;
                }
             }
          }else {
             goto label_00b3 ;
          }
       }else {
          goto label_0090 ;
       }
       if (dm.monster[3] == 1 && dm.isMonReel(33)) {
          buff = this.skill[33][0];
       }
       if ((hit = (hit * buff) / 100) < 1) {
          hit = 1;
       }
       dmB.addHit(hit, baoji, 0);
       return;
    }
    private void data_null(){
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
    private void delItemEvolve(byte id){
       int ix1;
       byte i = 2;
       do {
          int ix = i + 1;
          this.deleteItems(this.monsterMake[id][i], this.monsterMake[id][ix]);
          ix1 = i + 2;
          i = (byte)ix1;
          ix1 = this.monsterMake[id].length - 1;
       } while (i >= ix1);
       return;
    }
    private void delItemSkill(Monster mon){
       this.say(String.valueOf(this.getNameMon(mon.monster[0]))+"\x4e\x02\x5f\x02\x62\x02\x80\x02\xff\x02"+this.getNameSkill(this.getSkill), 0);
       this.goMY_BAG(2);
       this.deleteItems((((this.getSkill + 35) - 25) - 1), 1);
       Ms.i().correctSelect(this.select[0], this.itemsLength[this.selectx], this.list_rows);
    }
    private void doBuffValue(Battle be){
       if (be.getMon().monsterPro[0] >= 1 && be.getMon().isBuffRate(4)) {
          be.addHit((((- be.getMon().monsterPro[2]) * this.inhesion[4]) / 100), 1, 1);
       }
       return;
    }
    private void doEffectValue(Battle be){
       short hit = 0;
       if (be.getMon().isMonEffect(2)) {
          hit = (short)(be.getMon().monsterPro[0] / 10);
       }else if(be.getMon().isMonEffect(5)){
          hit = (short)((be.fs_level * be.fs_level) + 4);
       }
       if (be.getMon().isMonReel(3)) {
          hit = (short)(((this.inhesion[3] * hit) / 100) + hit);
       }
       if (hit) {
          be.addHit(hit, 1, 0);
       }
       return;
    }
    private void drawAnimationBattle(Battle amB,int mini_am){
       int i = 5;
       if (amB.action == null) {
          byte skill_type = (byte)(amB.skill / 5);
          byte skill_id = (byte)(amB.skill % 5);
          if (skill_type > i) {
             skill_type = 5;
          }
          if (skill_type == i) {
             skill_id = (byte)(amB.skill - 25);
          }
          if (this.drawMagicC(skill_type, skill_type, skill_id, this.getBXY(this.mini_state, amB.skill, true), this.getBXY(this.mini_state, amB.skill, false), (this.mini_state ^ 0x01))) {
             if (this.mini_state == true) {
                Monster monsterPro = amB.getMon().monsterPro;
                monsterPro[1] = (short)(monsterPro[1] - this.getSkillMana(amB.getMon(), amB.skill));
                this.valueMend(amB.getMon());
             }
             this.runHit();
          }
       }
       return;
    }
    private void drawBG0(int id,int lx,int ly,int sh,int w){
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       Ui.i().fillRect(0x52bdef, (lx - 1), 0, (w + 13), (HEIGHT - 2));
       Ui.i().drawImage(this.imgBG[id], WIDTH_H, 0, 17);
       Ui.i().drawK2(lx, ly, (WIDTH - (lx << 1)), (HEIGHT - ly), 0);
       Ui.i().drawK1((lx + 5), (((ly + 25) + 7) + sh), w, (((HEIGHT - ly) - 36) - sh), 1);
       Ui.i().drawK((lx + 7), ((HEIGHT - 50) - 22), (w - 4), 58, 3);
    }
    private void drawBUY_ITEM(){
       int b;
       int ix1;
       int ix2;
       byte t;
       int ix4;
       int b1;
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       Ui.i().fillRectB();
       Ui.i().drawK2(1, 2, (WIDTH - 2), (HEIGHT - 2), 0);
       byte i = 0;
       byte ly = 37;
       byte fh = 30;
       if (this.cur_b == null) {
          Ui.i().drawK1((WIDTH_H - 29), 6, 58, 28, 4);
          Ui.i().drawString(this.action_str[this.cur_a], WIDTH_H, 5, 17, 0, 0);
       }else {
          Ui.i().drawK1(((this.cur_a * 210) + 70), 6, 70, 28, 4);
          while (i < 3) {
             Ui ui = Ui.i();
             object oobject1 = this.action_str[i];
             ix1 = i * 210;
             ix1 = ix1 + 80;
             ix2 = 5;
             b1 = 0;
             int ix5 = (this.cur_a == i)? 0: 4;
             ui.drawString(oobject1, ix1, ix2, b1, ix5, 0);
             b = i + 1;
             i = (byte)b;
          }
          t = this.pkey.selectMenuX(3, 70, 0, 210, 62);
          if (t != -1) {
             this.cur_a = t;
             b1 = 0;
             this.select[0][0] = b1;
             this.select[0][1] = b1;
          }
          Ui.i().drawTriangle(WIDTH_H, 15, 329, true, true);
       }
       Ui.i().drawK1(6, ly, (WIDTH - 26), ((this.list_rows * fh) + 6), 1);
       Ui.i().drawK1(6, (((this.list_rows * fh) + ly) + 16), (WIDTH - 12), (fh * 3), 2);
       b = (this.cur_b == 1)? this.itemsLength[this.cur_a]: this.buyItem[this.cur_a].length;
       i = (byte)b;
       int ix = 10;
       ix1 = ly + 3;
       ix2 = WIDTH - 26;
       GameRun gameRun = this.list_rows;
       object oobject = this.select[0];
       GameRun gameRun1 = this.cur_a;
       int ix3 = (this.cur_b == 1)? 2: 1;
       this.drawItemList(ix, ix1, ix2, gameRun, oobject, gameRun1, i, ix3);
       Ui.i().sliding((WIDTH - 15), (ly + 5), ((this.list_rows * fh) - 6), this.select[0][0], i, true);
       if (i > 0) {
          i = (this.cur_b == 1)? this.items[this.cur_a][this.select[0][0]][0]: this.buyItem[this.cur_a][this.select[0][0]];
          if (this.item_help[i].contains("\x59\x02\x6d\x02\x6b\x02\x4e\x02\x76\x02\x5b\x02\x72\x02\x5e\x02\x4e\x02\x51\x02\x56\x02\x59\x02\x75\x02\x54\x02\x50\x02\x76\x02")) {
             this.showStringM("\x59\x02\x6d\x02\x6b\x02\x4e\x02\x76\x02\x5b\x02\x72\x02\x5e\x02\x4e\x02\x51\x02\x56\x02\x59\x02\x75\x02\x54\x02\x50\x02\x76\x0230%,\x8b\x02\x52\x02\x57\x02\x5b\x02\x72\x02\x62\x02\x65\x02\x4e\x02\x8d\x02\x4e\x02!", WIDTH_H, (((this.list_rows * fh) + ly) + 18), 10, 3);
          }else {
             this.showStringM(this.item_help[i], WIDTH_H, (((this.list_rows * fh) + ly) + 18), 10, 3);
          }
       }
       b = HEIGHT - 2;
       ix = 0;
       ix1 = (this.cur_b != 1 && this.cur_a == 2)? 1: 0;
       this.drawMoney(WIDTH_H, b, ix, ix1);
       if (this.popMenu != -1) {
          if (this.buyOk == 1 && (this.cur_b != 1 && (this.buyItem[this.cur_a][this.select[0][0]] >= 35 && this.makeLevel[(this.buyItem[this.cur_a][this.select[0][0]] - 35)] > this.rmsOther[3]))) {
             Ui.i().drawKuang(-5, (HEIGHT_H - 50), (WIDTH + 10), 108);
             this.showStringM("\x97\x02\x89\x02\x8b\x02\x7e\x02\x5e\x02"+this.makeLevel[(this.buyItem[this.cur_a][this.select[0][0]] - 35)]+"\x7e\x02\x62\x02\x80\x02\x5b\x02\x4e\x02\xff\x02", WIDTH_H, (HEIGHT_H - 25), 12, 9);
             this.showString("\x66\x02\x54\x02\x8d\x02\x4e\x02\xff\x02", (HEIGHT_H + 25), 0);
          }else if(this.cur_b == 1){
             ix4 = 1;
          }else if(this.cur_a == 2){
             ix4 = 16;
          }else {
             ix4 = 17;
          }
          this.drawBuy(i, WIDTH_H, HEIGHT_H, 150, 50, ix4);
          t = this.pkey.selectMenuX(2, 0, 0, WIDTH_H, HEIGHT);
          if (t != -1) {
             b = (!t)? -3: -4;
             Ms.key = b;
             Ms.keyRepeat = true;
          }
       }
       Ui.i().drawYesNo(true, true);
       return;
    }
    private void drawBattleBG(){
       Ui.i().fillRectB();
       Ui.i().drawImage(this.imgBG[this.enB.bg_id], 200, 20, 0);
       Ui.i().drawImage(this.imgBG[this.myB.bg_id], 200, 144, 0, DirectGraphics.FLIP_HORIZONTAL);
       Ui.i().drawK2(2, 19, 195, 250, 0);
    }
    private void drawBattleExp(Monster mon,int y){
       Ui.i().drawK0(200, y, 240, 10, 0);
       int i = 240;
       int i1 = y + 3;
       int i2 = 195;
       int i3 = 2;
       int i4 = 2;
       short s = (this.battle_state != -5)? mon.monsterPro[4]: this.myB.cexp;
       this.drawMonsterHp(mon, i, i1, i2, i3, i4, s);
       Ui.i().drawString("\x7e\x02\x9a\x02", 200, (y + 18), 36, 0, 2);
       return;
    }
    private void drawBuffList(Monster monster,int x,int y,int w,int fontH,int show_num,byte[] sel){
       byte i = 0;
       Ui.i().drawListKY(show_num, x, y, w, 3, fontH, 0, (sel[0] - sel[1]), 4, 2);
       while (i < 2) {
          if (i > 0) {
             int ix = i + 16;
             if (monster.monster[ix] >= 1) {
             label_003b :
                int ix2 = x + 8;
                int ix3 = y + 8;
                int ix4 = i - this.select[0][1];
                ix4 = ix4 * fontH;
                ix3 = ix3 + ix4;
                Ui.i().drawUi(49, ix2, ix3, 0, 0);
                Ui ui = Ui.i();
                ix2 = i + 16;
                String nameBuff = this.getNameBuff(monster.monster[ix2]);
                ix2 = x + 21;
                ix3 = y + 1;
                ix4 = i - this.select[0][1];
                ix4 = ix4 * fontH;
                ix3 = ix3 + ix4;
                int ix5 = (sel[0] == i)? 0: 3;
                ui.drawString(nameBuff, ix2, ix3, 0, ix5, 0);
                ix = y + 1;
                ix2 = i - sel[1];
                ix2 = ix2 * fontH;
                ix = ix + ix2;
                if (this.pkey.isSelect(x, ix, w, fontH)) {
                   sel[0] = i;
                }
             }
          }else {
             goto label_003b ;
          }
          int ix1 = i + 1;
          i = (byte)ix1;
       }
       return;
    }
    private void drawBuy(int id,int x,int y,int w_h,int h_h,int d){
       Ui.i().drawKuang((x - w_h), (y - h_h), (w_h << 1), (h_h << 1));
       int i = y - h_h;
       int i1 = ((d & 0x10))? 2: 12;
       int t = i + i1;
       Ui.i().drawString("\x65\x02\x91\x02\xff\x02"+this.popMenu+"/"+this.t_length, x, t, 17, 3, 0);
       StringBuffer s = "";
       s = ((d & 0x10))? s+"\x97\x02\x89\x02\xff\x02": s+"\x83\x02\x5f\x02\xff\x02";
       s = s+(this.sell_money * this.popMenu);
       s = ((d & 0x01))? s+"\x91\x02": s+"\x5f\x02\x7a\x02";
       Ui.i().drawString(s, x, ((t + 25) + 4), 17, 6, 0);
       if ((d & 0x10)) {
          Ui.i().drawString("\x73\x02\x67\x02\xff\x02"+this.findItem(-2, id, true), x, (t + 58), 17, 3, 0);
       }
       Ui ui = Ui.i();
       int i2 = y - 2;
       boolean b = (this.cur_b != 2)? true: false;
       ui.drawTriangle1(x, i2, w_h, true, b);
       s = null;
       if (this.buyOk == 1) {
          String str = "\x66\x02\x54\x02";
          String str1 = ((d & 0x10))? "\x8d\x02\x4e\x02": "\x53\x02\x51\x02";
          this.showString(str+str1+"\xff\x02", (Constants_H.HEIGHT_H + 25), 0);
       }
       return;
    }
    private void drawClipPic(int action_id,int id,int x,int y,int w,int h,int piece,int cc,int dir){
       byte i = 1;
       byte ph = (byte)(w / piece);
       short speed = (short)(2 << cc);
       while (i < piece) {
          Graphics g = GameRun.g;
          int ix = i * ph;
          ix = x - ix;
          int ix1 = y - h;
          short ix2 = ((ix2 = ph - speed) <= 0)? ph: speed;
          int ix3 = h + 20;
          g.clipRect(ix, ix1, ix2, ix3);
          ix2 = action_id * 3;
          this.drawCartoonOne(id, id, ix2, x, y, true, dir);
          GameRun.g.setClip(0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
          g = GameRun.g;
          ix = i - 1;
          ix = ix * ph;
          ix = ix + x;
          ix1 = y - h;
          ix2 = ((ix2 = ph - speed) <= 0)? ph: speed;
          ix3 = h + 20;
          g.clipRect(ix, ix1, ix2, ix3);
          ix2 = action_id * 3;
          this.drawCartoonOne(id, id, ix2, x, y, true, dir);
          GameRun.g.setClip(0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
          int ix4 = i + 1;
          i = (byte)ix4;
          ix4 = speed / 2;
          speed = (short)ix4;
       }
       return;
    }
    private void drawColorLine(int x,int y,int width,int height,int line_height,int max_h,int speed,int dir,int bgColor,int lineColor){
       if ((0xff000000 & bgColor)) {
          GameRun.g.setColor(bgColor);
          GameRun.g.fillRect(x, y, width, height);
       }
       GameRun.g.setColor(lineColor);
       int over = 0;
       int grid = 1;
       if (dir == 1) {
          over = y + height;
          while (y < over) {
             GameRun.g.fillRect(x, y, width, line_height);
             y = y + line_height;
             y = y + grid;
             if ((line_height = line_height - speed) <= 0) {
                max_h--;
                if (grid < max_h) {
                   grid++;
                }
                line_height = 1;
             }
          }
       }else if(dir == 2){
          over = y;
          y = y + height;
          while (y > over) {
             int i = y - line_height;
             GameRun.g.fillRect(x, i, width, line_height);
             y = y - line_height;
             y = y - grid;
             if ((line_height = line_height - speed) <= 0) {
                max_h--;
                if (grid < max_h) {
                   grid++;
                }
                line_height = 1;
             }
          }
       }
       return;
    }
    private void drawDarkScreen(){
       int WIDTH = 640;
       int HEIGHT = 360;
       this.drawColorLine(0, 0, WIDTH, HEIGHT, (this.b_c + 1), 6, 1, 2, 0xffffff, 0x494949);
    }
    private void drawEffectImage(Monster monster,int x,int y){
       int i = 8;
       if (monster.effect > -1 && (monster.effect < 7 && monster.effect_time > null)) {
          Ui.i().drawImage(this.effectImage[monster.effect], x, y, (i | 0x20));
          Ui.i().drawNum(monster.effect_time, x, y, (i | 0x20), 0);
       }
       return;
    }
    private void drawEnemy(){
       int i = 0;
       this.drawEffectImage(this.enB.getMon(), 435, 40);
       if (this.enB.getMon().monsterPro[i] >= 1 || this.enB.dead != 1) {
          int i1 = (this.mList_id[this.enB.getMon().monster[i]][1] * 3) + this.enB.action;
          int i2 = (this.enB.ceff[i])? 3: i;
          short i3 = i2 + 377;
          i2 = (this.enB.ceff[i])? -3: i;
          int i4 = i2 + 97;
          int i5 = (this.enB.action == null)? 1: i;
          if (this.drawCartoonOne(i, i, i1, i3, i4, i5, i)) {
             if (this.enB.getMon().monsterPro[i] < 1) {
                this.enB.action = 2;
                this.enB.dead = 1;
             }else if(this.enB.dead != 1){
                this.enB.action = i;
             }
          }
          this.enB.ceff[i] = (byte)Ms.i().mathSpeedN(this.enB.ceff[i], i, 1, 1);
          this.drawMonsterHp(this.enB.getMon(), 352, 97, 50, i, 1, this.enB.chp);
          GameRun tenB = this.enB;
          Ms ms = Ms.i();
          Battle chp = this.enB.chp;
          i3 = this.enB.getMon().monsterPro[i];
          i = (this.enB.chp < this.enB.getMon().monsterPro[i])? 20: 6;
          tenB.chp = ms.mathSpeedN(chp, i3, i, 1);
       }
       return;
    }
    private void drawEnemyState(){
       int x = 10;
       int y = 25;
       Ui.i().drawK(x, y, 179, 110, 2);
       short w = 147;
       Ui.i().drawKuang((x + 2), (y + 2), w, 33);
       if (this.enB.getMon().monster[3] != -1) {
          Ui.i().drawUi((this.enB.getMon().monster[3] + 5), (x + 16), (y + 16), 3, 0);
       }
       Ui.i().drawString(this.getNameMon(this.enB.getMon().monster[0]), ((x + 75) + 14), (y + 1), 17, 4, 2);
       Ui.i().drawNum(String.valueOf(this.enB.getMon().monster[2])+"\x7e\x02", ((x + 125) + 27), (y + 20), 0, 0);
       Ui.i().drawK0((x + 2), ((y + 25) + 11), 62, 14, 4);
       Ui.i().drawUi(34, (x + 4), ((y + 25) + 12), 0, 0);
       Ui.i().drawNum(String.valueOf((this.enB.countS[0] + 100))+"%", (x + 60), ((y + 25) + 24), 1, 1);
       Ui.i().drawString("\x5b\x02\x72\x02\x68\x02\x6b\x02", (x + 2), ((y + 25) + 30), 20, 4, 2);
       this.drawMonKind(this.enB.getMon().monster[4], ((x + 100) + 8), ((y + 25) + 38), 0);
       Ui ui = Ui.i();
       String str = (this.monInfoList[this.enB.getMon().monster[0]] == 2)? "\x5d\x02\x63\x02\x83\x02": "\x67\x02\x63\x02\x83\x02";
       ui.drawString(str, (x + 2), ((y + 50) + 32), 20, 4, 2);
       ui = Ui.i();
       int i = (this.monInfoList[this.enB.getMon().monster[0]] == 2)? 25: 26;
       ui.drawUi(i, ((x + 100) + 4), ((y + 50) + 40), 0, 0);
       return;
    }
    private void drawEvolveMake(int id,int x,int y,int fontH){
       int ix2;
       byte i = 2;
       byte j = 0;
       do {
          int ix = i + 1;
          int ix1 = j * fontH;
          ix = y + ix1;
          Ui.i().drawString(String.valueOf(this.getNameItem(this.monsterMake[id][i])).append("\(").append(this.findItem(-2, this.monsterMake[id][i], true)).append("/").append(this.monsterMake[id][ix]).append("\)").toString(), x, ix, 0, 3, 0);
          ix2 = i + 2;
          i = (byte)ix2;
          ix2 = j + 1;
          j = (byte)ix2;
          ix2 = this.monsterMake[id].length - 1;
       } while (i >= ix2);
       if (this.monsterMake[id][0] > 0 && (i = this.findItem(-2, 34, true)) > 0) {
          Ui.i().drawString(String.valueOf(this.getNameItem(34))+"\("+i+"/"+1+"\)", x, (y + (j * fontH)), 0, -1, 0);
       }
       return;
    }
    private boolean drawHitOne(Battle dm,Battle am,int x,int y){
       int ix1;
       int ix2;
       Ui ui;
       GameRun tstrHit;
       int ix3;
       int ix4;
       object oobject;
       int ix5;
       Monster monsterPro;
       String str;
       boolean bb = true;
       this.strHit = "";
       byte i = 0;
       while (i < dm.hit.length) {
          if (dm.hit[i][4] < this.zb.length) {
             bb = false;
             if (dm.hit[i][0] == -1) {
                this.strHit = "\x95\x02\x90\x02";
             }else if(dm.hit[i][0] == -2){
                this.strHit = "\x5f\x02\x8b\x02\x5e\x02\x51\x02\x5c\x02";
             }else if(dm.hit[i][1] > -1){
                str = "-";
             }else {
                str = "+";
             }
             Ms.i();
             this.strHit = String.valueOf(str).append(Ms.abs(dm.hit[i][1])).toString();
             if (dm.hit[i][0] > 0 && dm.hit[i][0] < 4) {
                if (dm.hit[i][0] == 2) {
                   ix1 = dm.hit[i][2] + x;
                   ix2 = this.strHit.length() >> 1;
                   ix2 = ix2 * 14;
                   ix1 = ix1 + ix2;
                   ix1 = ix1 + 15;
                   ix2 = dm.hit[i][3] + y;
                   ix2 = ix2 + 8;
                   Ui.i().drawUi(32, ix1, ix2, 40, 0);
                   ix1 = dm.hit[i][2] + x;
                   ix2 = this.strHit.length() >> 1;
                   ix2 = ix2 * 14;
                   ix1 = ix1 + ix2;
                   ix1 = ix1 + 15;
                   ix2 = dm.hit[i][3] + y;
                   ix2 = ix2 + 8;
                   Ui.i().drawUi(33, ix1, ix2, 36, 0);
                }
                ui = Ui.i();
                tstrHit = this.strHit;
                ix1 = dm.hit[i][2] + x;
                ix2 = dm.hit[i][3] + y;
                ix3 = 0;
                ix4 = (dm.hit[i][0] == 2)? 2: 1;
                ui.drawNum(tstrHit, ix1, ix2, ix3, ix4);
             }else if(dm.hit[i][0] >= 0 && dm.hit[i][0] != 4){
                ui = Ui.i();
                tstrHit = this.strHit;
                ix1 = dm.hit[i][2] + x;
                ix2 = dm.hit[i][3] + y;
                ix3 = 0;
                ix4 = (dm.hit[i][0] == 4)? 1: 0;
                ui.drawString(tstrHit, ix1, ix2, ix3, ix4, 2);
             }
             if (!i) {
                oobject = dm.hit[i];
                ix5 = 2;
                ix1 = oobject[ix5];
                ix2 = (this.mini_state == 1)? 1: -1;
                ix1 = ix1 + ix2;
                oobject[ix5] = (short)ix1;
                oobject = dm.hit[i];
                ix5 = 3;
                ix1 = oobject[ix5] + this.zb[dm.hit[i][4]];
                oobject[ix5] = (short)ix1;
             }else if(i == 1){
                oobject = dm.hit[i];
                ix5 = 2;
                ix1 = oobject[ix5];
                ix2 = (this.mini_state == 1)? 1: -1;
                ix1 = ix1 + ix2;
                oobject[ix5] = (short)ix1;
                oobject = dm.hit[i];
                ix5 = 3;
                ix1 = oobject[ix5] + this.zb[dm.hit[i][4]];
                oobject[ix5] = (short)ix1;
             }else if(i == 2){
                oobject = dm.hit[i];
                ix5 = 3;
                ix2 = dm.hit[i][4] / 3;
                ix1 = oobject[ix5] - ix2;
                oobject[ix5] = (short)ix1;
             }
             oobject = dm.hit[i];
             ix5 = 4;
             ix1 = oobject[ix5] + 1;
             ix1 = (short)ix1;
             oobject[ix5] = ix1;
             if (ix1 == 1) {
                if (dm.hit[i][0] == 4) {
                   monsterPro = dm.getMon().monsterPro;
                   ix5 = 1;
                   ix1 = monsterPro[ix5] - dm.hit[i][1];
                   monsterPro[ix5] = (short)ix1;
                }else if(dm.hit[i][0] == -2 && (this.mini_state == null && !dm.getMon().isMonReel(40))){
                   monsterPro = dm.getMon().monster;
                   ix1 = monsterPro[6] - dm.hit[i][1];
                   monsterPro[6] = (byte)ix1;
                   this.getHitCoefficient(dm, dm.getMon(), am.getMon());
                }else if(dm.hit[i][0] > 0){
                   monsterPro = dm.getMon().monsterPro;
                   ix5 = 0;
                   ix1 = monsterPro[ix5] - dm.hit[i][1];
                   monsterPro[ix5] = (short)ix1;
                }
             }
          }
          int ix = i + 1;
          i = (byte)ix;
       }
       this.valueMend(dm.getMon());
       return bb;
    }
    private void drawInfoBG(int w,int fh){
       int WIDTH = 640;
       int HEIGHT = 360;
       Ui.i().fillRect(0, 0, 0, WIDTH, fh);
       GameRun.g.fillRect(0, (HEIGHT - fh), WIDTH, fh);
       GameRun.g.fillRect(0, (fh - 2), WIDTH, fh);
       Ui.i().fillRect(0xeafcff, 0, 2, WIDTH, (fh - 4));
       GameRun.g.fillRect(0, ((HEIGHT - fh) + 2), WIDTH, (fh - 4));
       GameRun.g.fillRect(0, fh, WIDTH, (fh - 4));
    }
    private void drawInfoList(int x,int y,int w,int sh,int show_num,int listMax,byte[] sel){
       Ui.i().drawListKY(show_num, (x - 4), (y + 5), w, 4, (sh + 4), 2, (sel[0] - sel[1]), 4, 2);
       byte i = sel[1];
       while (true) {
          int ix = sel[1] + show_num;
          if (i < ix && i < listMax) {
             Ui ui = Ui.i();
             int ix1 = (this.monInfoList[this.monInfo_dir[this.cur_a][i]] == 2)? 25: 48;
             int ix2 = x - 10;
             int ix3 = i - sel[1];
             int ix4 = sh + 4;
             ix4 = ix4 + 2;
             ix3 = ix3 * ix4;
             ix3 = ix3 + y;
             ix3 = ix3 + 11;
             ix4 = 8 | 0x10;
             ui.drawUi(ix1, ix2, ix3, ix4, 0);
             if (sel[0] == i) {
                ix = 0;
             }else if(this.monInfoList[this.monInfo_dir[this.cur_a][i]]){
                ix = 3;
             }else {
                ix = -1;
             }
             byte color = (byte)ix;
             ui = Ui.i();
             ix2 = this.infoStart + i;
             String str = ((ix2 = ix2 + 1) < 10)? "0": "";
             ix2 = this.infoStart + i;
             ix2 = ix2 + 1;
             StringBuilder str1 = String.valueOf(str).append(ix2);
             str1 = str1.append(" ");
             str = (this.monInfoList[this.monInfo_dir[this.cur_a][i]])? this.getNameMon(this.monInfo_dir[this.cur_a][i]): "\x67\x02\x77\x02\x5b\x02\x72\x02";
             ix2 = x + 10;
             ix3 = i - sel[1];
             ix4 = sh + 4;
             ix4 = ix4 + 2;
             ix3 = ix3 * ix4;
             ix3 = ix3 + y;
             ix3 = ix3 + 5;
             ui.drawString(str1.append(str).toString(), ix2, ix3, 0, color, 0);
             ix2 = Constants_H.WIDTH - 25;
             ix2 = ix2 - 15;
             ix3 = i - sel[1];
             ix4 = sh + 4;
             ix4 = ix4 + 2;
             ix3 = ix3 * ix4;
             ix3 = ix3 + y;
             ix3 = ix3 + 5;
             ix4 = 8 | 0x10;
             Ui.i().drawString(this.getInfoType(this.monAppearMap[this.monInfo_dir[this.cur_a][i]][0]), ix2, ix3, ix4, color, 0);
             ix1 = i - sel[1];
             ix2 = sh + 4;
             ix2 = ix2 + 2;
             ix1 = ix1 * ix2;
             ix1 = ix1 + y;
             ix1 = ix1 + 5;
             ix2 = sh + 4;
             ix2 = ix2 + 2;
             if (this.pkey.isSelect(x, ix1, w, ix2)) {
                if (sel[0] == i) {
                   this.pkey.setKey5();
                }else {
                   sel[0] = i;
                   if (!(ix = i - sel[1]) && sel[1] > 0) {
                      ix = 1;
                      ix1 = sel[ix] - 1;
                      sel[ix] = (byte)ix1;
                   }else {
                      ix = i - sel[1];
                      ix1 = show_num - 1;
                      if (ix == ix1) {
                         ix = sel[1] + show_num;
                         if (ix < listMax) {
                            ix = 1;
                            ix1 = sel[ix] + 1;
                            sel[ix] = (byte)ix1;
                         }
                      }
                   }
                }
             }
             ix = i + 1;
             i = (byte)ix;
          }else {
             break ;
          }
       }
       Ui.i().sliding(((x + w) + 5), (y + 10), ((((sh + 4) + 2) * show_num) - 4), sel[0], listMax, false);
       return;
    }
    private void drawItemList(int x,int y,int w,int show_num,byte[] sel,int itemType,int length,int mode){
       int ix1;
       int ix2;
       int ix3;
       int ix4;
       byte i = sel[1];
       byte fh = 30;
       String str = "";
       Ui.i().drawListKY(show_num, (x - 4), y, w, 4, (fh + 1), -1, (sel[0] - sel[1]), 4, 2);
       int String str1 = str;
       while (true) {
          int ix = sel[1] + show_num;
          if (i >= ix) {
             break ;
          }else if(i < length){
             if (mode && mode != 2) {
                str1 = x + 2;
                ix1 = y + 4;
                ix2 = i - sel[1];
                ix2 = ix2 * fh;
                ix1 = ix1 + ix2;
                this.drawItem(this.buyItem[itemType][i], str1, ix1, 0);
                ix = (sel[0] == i)? 0: 3;
                byte color = (byte)ix;
                ix3 = x + 20;
                ix = i - sel[1];
                ix = ix * fh;
                ix4 = y + ix;
                Ui.i().drawString(this.getNameItem(this.buyItem[itemType][i]), ix3, ix4, 0, color, 0);
                str1 = (itemType == 2)? "\x5f\x02\x7a\x02": "\x91\x02";
                ix = x + w;
                ix3 = ix - 12;
                ix = y + 1;
                ix4 = i - sel[1];
                ix4 = ix4 * fh;
                ix4 = ix4 + ix;
                int ix5 = 8 | 0x10;
                Ui.i().drawString(String.valueOf(this.getPrice(itemType, i, 1)).append(str1).toString(), ix3, ix4, ix5, color, 0);
             }else {
                str1 = null;
                str1 = x + 3;
                ix1 = y + 4;
                ix2 = i - sel[1];
                ix2 = ix2 * fh;
                ix1 = ix1 + ix2;
                this.drawItem(this.items[itemType][i][str1], str1, ix1, 0);
                Ui ui = Ui.i();
                str1 = this.getNameItem(this.items[itemType][i][0]);
                ix2 = x + 21;
                ix2 = y + 1;
                ix3 = i - sel[1];
                ix3 = ix3 * fh;
                ix2 = ix2 + ix3;
                ix3 = 0;
                ix4 = (sel[0] == i)? 0: 3;
                ui.drawString(str1, ix2, ix2, ix3, ix4, 0);
                str1 = (mode == 2)? "".append(this.getPrice(itemType, this.items[itemType][i][0], 0)).append("\x91\x02").toString(): "x".append(this.items[itemType][i][1]).toString();
                ui = Ui.i();
                ix1 = x + w;
                ix1 = ix1 - 12;
                ix2 = y + 1;
                ix3 = i - sel[1];
                ix3 = ix3 * fh;
                ix2 = ix2 + ix3;
                ix3 = 8 | 0x10;
                ix4 = (sel[0] == i)? 0: 3;
                ui.drawString(str, ix1, ix2, ix3, ix4, 0);
             }
             if (this.popMenu == -1 && this.say_c == null) {
                ix1 = i - sel[1];
                ix1 = ix1 * fh;
                ix1 = ix1 + y;
                if (this.pkey.isSelect(x, ix1, Constants_H.WIDTH, fh)) {
                   if (sel[0] == i) {
                      this.pkey.setKey5();
                   }else {
                      sel[0] = i;
                      if (!(ix = i - sel[1]) && sel[1] > 0) {
                         ix = 1;
                         ix1 = sel[ix] - 1;
                         sel[ix] = (byte)ix1;
                      }else {
                         ix = i - sel[1];
                         ix1 = show_num - 1;
                         if (ix == ix1) {
                            ix = sel[1] + show_num;
                            if (ix < length) {
                               ix = 1;
                               ix1 = sel[ix] + 1;
                               sel[ix] = (byte)ix1;
                            }
                         }
                      }
                      this.select_it[this.selectx] = sel[0];
                      this.select_st[this.selectx] = sel[1];
                   }
                }
             }
          }
          ix = i + 1;
          i = (byte)ix;
       }
       return;
    }
    private void drawLIST_INFO(){
       byte t;
       byte i;
       int b;
       Ui ui;
       int b1;
       int ix1;
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       Ui.i().fillRectB();
       this.drawInfoBG(24, 35);
       Ui.i().drawString("\x53\x02\x73\x02\x5e\x02 "+Ms.i().getPrecision(((this.monInfoList[102] * 1000) / 102))+"%", (WIDTH - 12), 34, (8 | 0x10), 3, 1);
       Ui.i().drawString(this.monsterT[this.cur_a], 28, 34, 0, 1, 2);
       Ui.i().drawString("\x63\x02\x63\x02\x79\x02\x7c\x02 "+this.monInfoList[103]+"/"+100, WIDTH_H, (HEIGHT + 1), (1 | 0x20), 3, 1);
       if ((t = this.pkey.selectMenuX(5, 100, 0, (WIDTH / 6), 35)) != -1) {
          this.cur_a = t;
          this.infoStart = 0;
          if (this.cur_a > null) {
             i = 0;
             while (i < this.cur_a) {
                ix1 = this.infoStart + this.monInfo_dir[i].length;
                this.infoStart = (byte)ix1;
                ix1 = i + 1;
                i = (byte)ix1;
             }
          }
          this.t_length = (byte)this.monInfo_dir[this.cur_a].length;
          b = 0;
          this.select[0][1] = b;
          this.select[0][0] = b;
       }
       i = 0;
       while (i < 5) {
          ui = Ui.i();
          b1 = (this.cur_a == i)? 5: 0;
          b1 = b1 + i;
          int ix = WIDTH - 26;
          ix = i + 1;
          ix = ix * 614;
          ix = ix / 6;
          ix = ix + 18;
          b = 4 | 0x02;
          ui.drawUi(b1, ix, 12, b, 0);
          ix1 = i + 1;
          i = (byte)ix1;
       }
       this.drawInfoList(32, 67, (WIDTH - 50), 29, this.list_rows, this.t_length, this.select[0]);
       Ui.i().drawTriangle((WIDTH_H + 10), 12, 331, true, true);
       ui = Ui.i();
       b1 = (this.monInfoList[this.getMonInfo_dir()])? true: false;
       ui.drawYesNo(b1, true);
       return;
    }
    private void drawMONSTER_INFO(int id){
       byte i;
       int b1;
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int offx = WIDTH_H - 140;
       int offw = 280;
       int x = offx + 12;
       int y = 35;
       int w = 100;
       int h = 90;
       int fw = 29;
       int fh = 29;
       Ui.i().fillRectB();
       Ui.i().drawK2(offx, 2, offw, (HEIGHT - 2), 0);
       offx = 4;
       Ui.i().drawK1(((WIDTH_H - (fw * 4)) - offx), 6, (fw * 8), fh, 4);
       Ui.i().drawK1(x, y, w, h, 1);
       Ui.i().drawK1(((fw + 192) + 8), ((y + h) + 4), (offw - (fw + 25)), (fh * 4), 1);
       Ui.i().drawK1(x, ((y + h) + 4), fw, (fh * 4), 3);
       Ui.i().drawK1(x, ((HEIGHT - 13) - (fh * 3)), ((WIDTH - (x << 1)) + 2), ((fh * 3) + 10), 2);
       Ui.i().drawYesNo(false, true);
       Ui.i().drawUi((this.cur_a + 5), (x + 2), (y + 2), 0, 0);
       Log.e("sk", "drawUi");
       Ui ui = Ui.i();
       String str = String.valueOf(this.getNameMon(id))+"\(";
       String offx1 = (this.monInfoList[id] == 2)? "\x5d\x02\x63\x02\x83\x02": "\x67\x02\x63\x02\x83\x02";
       ui.drawString(str+offx1+"\)", WIDTH_H, 6, 17, 0, 0);
       int ix = 1;
       int ix1 = 1;
       int ix2 = (this.mList_id[id][1] * 3) + this.mon_action;
       int ix3 = x + 50;
       int ix4 = (y + h) - 10;
       boolean b = (this.mon_action == 1)? false: true;
       if (this.drawCartoonOne(ix, ix1, ix2, ix3, ix4, b, 0)) {
          this.mon_action = 0;
       }
       Ui.i().drawString("\x53\x02\x73\x02\x57\x02\x70\x02", ((w + 192) + 5), y, 0, 1, 1);
       if (this.monAppearMap[id][0] > -1) {
          i = 0;
          while (i < this.monAppearMap[id].length) {
             b1 = w + 192;
             ix1 = b1 + 5;
             b1 = i + 1;
             b1 = b1 * 25;
             ix2 = y + b1;
             Ui.i().drawString(this.city_name[this.monAppearMap[id][i]].toString(), ix1, ix2, 0, 1, 0);
             b1 = i + 1;
             i = (byte)b1;
          }
       }else {
          Ui.i().drawString("\x67\x02\x77\x02", ((w + 192) + 5), (y + 25), 0, 1, 0);
       }
       Ui.i().drawString("\x8f\x02", ((x + 12) + 2), ((y + h) + 20), 17, 3, 1);
       Ui.i().drawString("\x53\x02", ((x + 12) + 2), (fh + 153), 17, 3, 1);
       Ui.i().drawListKY(3, ((fw + 192) + 8), ((y + h) + 10), (offw - (fw + 25)), 3, (fh + 4), 0, -1, 4, 2);
       i = 2;
       byte j = 0;
       while (i < 7) {
          ui = Ui.i();
          str = "\x67\x02\x65\x02\xff\x02";
          if (this.monsterMake[id].length && i < this.monsterMake[id].length) {
             offw = i + 1;
             offx1 = String.valueOf(this.getNameItem(this.monsterMake[id][i])).append(" x").append(this.monsterMake[id][offw]).toString();
          }else {
             offx1 = "";
          }
          int ix5 = fw + 192;
          ix1 = ix5 + 14;
          ix5 = y + h;
          ix5 = ix5 + 12;
          ix5 = fh + 4;
          ix5 = j * 33;
          ix5 = ix5 + 137;
          ui.drawString(str.append(offx1).toString(), ix1, ix5, 0, 3, 0);
          ix5 = i + 2;
          i = (byte)ix5;
          ix2 = j + 1;
          j = (byte)ix2;
       }
       this.showStringM(this.getNameMonsterInfo(id), WIDTH_H, ((HEIGHT - 12) - (fh * 3)), 10, 3);
       b1 = (byte)(this.mon_action_c + 1);
       this.mon_action_c = b1;
       if (b1 > 50) {
          this.mon_action_c = 0;
          this.mon_action = 1;
       }
       return;
    }
    private void drawMONSTER_UI(Monster[] monsters){
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       boolean offx = WIDTH_H - 140;
       int offw = 280;
       Ui.i().fillRectB();
       Ui.i().drawK2(offx, 2, offw, (HEIGHT - 2), 0);
       int lx = offx + 6;
       int ly = 5;
       int lw = 118;
       int lh = 116;
       Ui.i().drawK1(lx, (ly + 6), lw, lh, 1);
       if (this.t_length != null) {
          offx = 0;
          this.drawMonsterHp(monsters[this.select[offx][0]], (lx + 30), ly, 74, 2, 2, monsters[this.select[0][0]].monsterPro[4]);
          Ui.i().drawNum(String.valueOf(monsters[this.select[0][0]].monster[2])+"\x7e\x02", (lx + 2), (ly + 10), 0, 0);
          Ui.i().drawUi((monsters[this.select[0][0]].monster[3] + 5), (lx + 9), (ly + 11), 17, 0);
          int i = 1;
          int i1 = 1;
          int i2 = (this.mList_id[monsters[this.select[0][0]].monster[0]][1] * 3) + this.mon_action;
          int i3 = 248;
          int i4 = 111;
          boolean b = (this.mon_action == 1)? false: true;
          if (this.drawCartoonOne(i, i1, i2, i3, i4, b, 0)) {
             this.mon_action = 0;
          }
       }
       ly = ly + 138;
       lw = (int)(WIDTH - (lx << 1));
       Ui.i().drawK1(lx, ly, lw, ((HEIGHT - lh) - 32), 1);
       Ui.i().drawK((lx + 8), (ly + 10), (lw - 16), 33, 3);
       Ui.i().drawK((lx + 8), ((ly + 150) + 11), (lw - 16), 33, 3);
       if (this.t_length != null) {
          this.gogoWord(this.getNameMonsterInfo(monsters[this.select[0][0]].monster[0]), (lx + 9), ((ly + 150) + 13), (lw - 70), 0, 1, 2);
          this.drawMonsterFealty(monsters[this.select[0][0]], (lx + 2), (ly - 14));
          Ui.i().drawString(this.monsterT[monsters[this.select[0][0]].monster[3]], (lx + 25), (ly + 12), 0, 0, 1);
          if (!monsters[this.select[0][0]].monster[5]) {
             Ui.i().drawString("\x4e\x02\x53\x02\x8f\x02\x53\x02", (lx + 115), (ly + 12), 0, 0, 1);
          }else {
             Ui.i().drawString("\x53\x02\x8f\x02\x53\x02"+monsters[this.select[0][0]].monster[5]+"\x6b\x02", (lx + 115), (ly + 12), 0, 0, 1);
          }
       }
       this.drawMonPro(monsters, lx, ly);
       lx = ((offw + 180) - 75) - 15;
       ly = 0;
       lw = 75;
       if (this.t_length != null) {
          this.drawMonList(monsters, (lx + 2), (ly + 13), this.list_rows, this.t_length, this.select[0]);
       }
       Ui.i().sliding(((offw + 180) - 17), (ly + 12), (lh + 6), this.select[0][0], this.t_length, true);
       Ui ui = Ui.i();
       StringBuilder str = String.valueOf(this.t_length)+"/";
       GameRun offx1 = (this.mini_state == 6)? this.max_monsters: this.max_takes;
       ui.drawNum(str+offx1, ((offw + 180) - 40), (ly + 12), 0, 0);
       if (this.popMenu != -1) {
          this.drawSelectMenu(this.about_d, (WIDTH_H - 25), 30, 75, 2, 0, this.popMenu);
          if (this.buyOk == 1) {
             this.showString(this.gogoString, (HEIGHT_H - 25), 0);
          }
       }
       Ui ui1 = Ui.i();
       offx = (this.t_length != null)? true: false;
       ui1.drawYesNo(offx, true);
       return;
    }
    private void drawMY_BAG(int x,int y,int w,int h){
       int ix;
       int ix2;
       int b;
       Ui ix3;
       byte t;
       byte i = (byte)(this.action_str.length - 1);
       Ui.i().fillRectB();
       Ui.i().drawK2((x + 1), (y + 3), (w - 2), (h - 3), 0);
       Ui.i().drawK1((x + 5), ((y + 25) + 14), (w - 23), (this.list_rows * 31), 1);
       Ui.i().drawK1((x + 5), (((y + 25) + 20) + (this.list_rows * 31)), (w - 10), 90, 2);
       if (!i) {
          Ui.i().drawK1(((((w >> 1) + x) - 25) - 9), (y + 8), 66, 28, 4);
          Ui.i().drawString(this.action_str[i], ((w >> 1) + x), (y + 7), 17, 0, 0);
          Log.e("sk", "drawMY_BAG");
       }else {
          Ui.i().drawK1((((((this.selectx + 1) * w) / 5) + x) - 22), (y + 8), 70, 28, 4);
          while (i > -1) {
             ix3 = Ui.i();
             object oobject = this.action_str[i];
             ix2 = i + 1;
             ix2 = ix2 * w;
             ix2 = ix2 / 5;
             ix2 = ix2 + x;
             ix2 = ix2 - 14;
             b = y + 7;
             int ix4 = 0;
             int ix5 = (this.selectx == i)? 0: 1;
             ix3.drawString(oobject, ix2, b, ix4, ix5, 0);
             ix = i - 1;
             i = (byte)ix;
          }
          Ui.i().drawTriangle(((w >> 1) + x), (y + 14), 354, true, true);
          if (this.popMenu == -1 && (t = this.pkey.selectMenuX(4, 0, 0, (w / 4), 35)) != -1) {
             this.selectx = t;
             this.select[0][1] = this.select_st[this.selectx];
             this.select[0][0] = this.select_it[this.selectx];
          }
       }
       this.drawItemList((x + 9), ((y + 25) + 17), (w - 23), this.list_rows, this.select[0], this.selectx, this.itemsLength[this.selectx], 0);
       Ui.i().sliding(((x + w) - 15), ((y + 25) + 17), ((this.list_rows * 31) - 6), this.select[0][0], this.itemsLength[this.selectx], true);
       if (this.itemsLength[this.selectx] > 0) {
          this.showStringM(this.item_help[this.items[this.selectx][this.select[0][0]][0]], (x + (w >> 1)), ((this.list_rows * 31) + ((y + 25) + 22)), 10, 3);
       }
       ix = (w >> 1) + x;
       boolean ix1 = (y + h) - 2;
       ix2 = 0;
       b = (this.selectx == 2)? true: false;
       this.drawMoney(ix, ix1, ix2, b);
       ix3 = Ui.i();
       ix1 = (!this.itemsLength[this.selectx])? false: true;
       ix3.drawYesNo(ix1, true);
       if (this.popMenu != -1) {
          this.drawSelectMenu(this.about_a, ((((w >> 1) + x) - 25) - 8), 50, 75, 2, 0, this.popMenu);
       }
       return;
    }
    private void drawMagicUI(Monster monsters){
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       Ui.i().fillRect(0x52bdef, 0, 0, WIDTH, HEIGHT);
       int offx = WIDTH_H - 140;
       int offw = 267;
       int lx = 1 + 180;
       int ly = 108;
       this.drawBG0(this.bg_c, lx, ly, 0, offw);
       byte t = this.pkey.selectMenuX(2, lx, ly, 120, 29);
       if (t != -1) {
          Ms.key = -3;
          Ms.keyRepeat = true;
       }
       Ui ui = Ui.i();
       int i = (this.popMenu == null)? -143: 21;
       ui.drawK1((WIDTH_H + i), (ly + 3), 123, 27, 4);
       ui = Ui.i();
       String str = "\x66\x02\x90\x02\x62\x02\x80\x02";
       int i1 = WIDTH_H - 25;
       int i2 = ly + 1;
       byte i3 = 8 | 0x10;
       int i4 = (this.popMenu == null)? 0: 1;
       ui.drawString(str, i1, i2, i3, i4, 0);
       ui = Ui.i();
       str = "\x59\x02\x8d\x02\x62\x02\x80\x02";
       i1 = WIDTH_H + 25;
       i2 = ly + 1;
       i3 = 0;
       i4 = (this.popMenu == null)? 1: 0;
       ui.drawString(str, i1, i2, i3, i4, 0);
       int i5 = 1;
       i1 = 1;
       i2 = (this.mList_id[monsters.monster[0]][1] * 3) + this.mon_action;
       i3 = 377 - this.move_x;
       i4 = 97 - this.move_y;
       boolean b = (this.mon_action == 1)? false: true;
       if (this.drawCartoonOne(i5, i1, i2, i3, i4, b, 0)) {
          this.mon_action = 0;
       }
       this.move_x = Ms.i().mathSpeedDown(this.move_x, 3, false);
       this.move_y = Ms.i().mathSpeedDown(this.move_y, 3, false);
       if (this.popMenu == null) {
          this.drawSkillList((lx + 7), ((ly + 25) + 12), (offw - 29), 31, 5, this.select[0]);
          if (this.skill_list[this.select[0][0]] != -1) {
             this.gogoWord(this.skill_help[this.skill_list[this.select[0][0]]], (lx + 10), ((HEIGHT - 25) - 22), 200, 0, 1, 2);
          }
       }else {
          this.drawBuffList(monsters, (lx + 7), ((ly + 25) + 12), (offw - 29), 31, 5, this.select[0]);
          if (monsters.monster[(this.select[0][0] + 16)] > 0) {
             this.showStringM(this.buff_help[monsters.monster[(this.select[0][0] + 16)]], WIDTH_H, ((HEIGHT - 50) - 22), 9, 0);
          }
       }
       ui = Ui.i();
       i5 = (offw + 180) - 13;
       i1 = (ly + 25) + 13;
       i2 = (HEIGHT - ly) - 120;
       i3 = this.select[0][0];
       if (this.popMenu == null) {
          i4 = this.skill_list[8];
       }else if(monsters.monster[(this.select[0][0] + 16)] > 0){
          i4 = 2;
       }else {
          i4 = 1;
       }
       ui.sliding(i5, i1, i2, i3, i4, true);
       if (this.mini_state != 13) {
          Ui.i().drawTriangle(WIDTH_H, (ly + 12), 150, true, true);
          Ui.i().drawYesNo(false, true);
       }else {
          Ui.i().drawYesNo(true, true);
       }
       return;
    }
    private void drawMonKind(byte monKind,int x,int y,int arh){
       byte i = 0;
       while (i < 5) {
          Ui ui = Ui.i();
          int ix = (monKind > i)? 23: 24;
          int ix1 = i * 14;
          ix1 = ix1 + x;
          ui.drawUi(ix, ix1, y, arh, 0);
          int ix2 = i + 1;
          i = (byte)ix2;
       }
       return;
    }
    private void drawMonList(Monster[] monster,int x,int y,int show_num,int max_length,byte[] select){
       int ix1;
       int ix2;
       byte i = select[1];
       if (this.mini_state != 6) {
          Ui.i().drawUi(34, ((x - 50) - 5), (y + 2), (8 | 0x10), 0);
       }
       while (true) {
          int ix = select[1] + show_num;
          if (i < ix && i < max_length) {
             if (select[0] == i) {
                ix1 = x - 50;
                ix2 = i - select[1];
                ix2 = ix2 * 29;
                ix2 = ix2 + y;
                Ui.i().drawK(ix1, ix2, 108, 26, 1);
             }
             Ui ui = Ui.i();
             String str = this.getNameMon(monster[i].monster[0]).toString();
             ix2 = x + 4;
             int ix3 = y - 2;
             int ix4 = i - select[1];
             ix4 = ix4 * 29;
             ix3 = ix3 + ix4;
             ix4 = 17;
             int ix5 = (select[0] == i)? 0: 1;
             ui.drawString(str, ix2, ix3, ix4, ix5, 1);
             if (this.popMenu == -1) {
                ix1 = x - 50;
                ix2 = i - select[1];
                ix2 = ix2 * 29;
                ix2 = ix2 + y;
                if (this.pkey.isSelect(ix1, ix2, 100, 26)) {
                   if (select[0] == i) {
                      Ms.key = 53;
                      Ms.keyRepeat = true;
                   }else {
                      select[0] = i;
                      if (!(ix = i - select[1]) && select[1] > 0) {
                         ix = 1;
                         ix1 = select[ix] - 1;
                         select[ix] = (byte)ix1;
                      }else {
                         ix = i - select[1];
                         ix1 = show_num - 1;
                         if (ix == ix1 && (ix = select[1] + show_num) < max_length) {
                            ix = 1;
                            ix1 = select[ix] + 1;
                            select[ix] = (byte)ix1;
                         }
                      }
                      this.initMonStream(2, this.mList_id[monster[select[0]].monster[0]][0], 1);
                      this.setShowPro(monster[select[0]]);
                      this.introT = Constants_H.WIDTH_H;
                      this.introX = Constants_H.WIDTH_H;
                   }
                }
             }
             ix = i + 1;
             i = (byte)ix;
          }else {
             break ;
          }
       }
       return;
    }
    private void drawMonPro(Monster[] monsters,int lx,int ly){
       Ui.i().drawStringY(this.about_a, (lx + 18), (ly + 44), 0, 3, 31, 3, 0);
       Ui.i().drawStringY(this.about_b, (lx + 160), (ly + 44), 0, 3, 31, 3, 0);
       if (this.t_length != null) {
          Ui.i().drawStringY(this.about_c, ((lx + 165) + 50), (ly + 44), 0, 3, 31, -1, 0);
          this.drawMonsterHp(monsters[this.select[0][0]], (((lx + 19) + 50) + 4), (ly + 59), 48, 0, 0, monsters[this.select[0][0]].monsterPro[0]);
          this.drawMonsterHp(monsters[this.select[0][0]], (((lx + 19) + 50) + 4), (((ly + 59) + 25) + 3), 48, 1, 0, monsters[this.select[0][0]].monsterPro[1]);
          this.drawMonKind(monsters[this.select[0][0]].monster[4], (((lx + 19) + 50) + 4), ((ly + 76) + 28), 0);
       }
       return;
    }
    private void drawMonsterFealty(Monster monster,int x,int y){
       int i = 4;
       byte kind = monster.monster[i];
       GameRun tinitFealty = this.initFealty;
       i = (kind < i)? 0: 1;
       byte nn = (byte)(tinitFealty[i] / 20);
       byte n = (byte)(monster.monster[6] / 20);
       this.drawFealty(nn, n, x, y);
       return;
    }
    private void drawMonsterHp(Monster monster,int x,int y,int w,int mode,int type,int t2){
       short t0;
       short t1;
       if (mode < 2) {
          t0 = monster.monsterPro[(mode + 0)];
          t1 = monster.monsterPro[(mode + 2)];
       }else if(!t2){
          t2 = monster.monsterPro[4];
       }
       t0 = (short)t2;
       t1 = this.getMonsterExp(monster);
       Ui.i().drawBarOne(x, y, w, Ms.i().mathPercent(t2, (w - 2), t1), Ms.i().mathPercent(t0, (w - 2), t1), mode);
       if (type != 2) {
          String s = String.valueOf(t0)+"/"+t1;
          Ui ui = Ui.i();
          int i = ((w - (s.length() * 8)) >> 1) + x;
          int i1 = (type == 1)? 5: 0;
          ui.drawNum(s, i, (i1 + y), 0, 0);
       }
       return;
    }
    private void drawMyMonState(){
       short x = 10;
       short w = 147;
       short y = 140;
       Ui.i().drawK(x, y, 179, 110, 2);
       Ui.i().drawKuang((x + 2), (y + 2), w, 33);
       Ui.i().drawUi((this.myB.getMon().monster[3] + 5), (x + 16), (y + 16), 3, 0);
       Ui.i().drawString(this.getNameMon(this.myB.getMon().monster[0]), ((x + 75) + 14), (y + 1), 17, 4, 2);
       Ui.i().drawNum(String.valueOf(this.myB.getMon().monster[2])+"\x7e\x02", ((x + 125) + 27), (y + 20), 0, 0);
       Ui.i().drawK0((x + 2), ((y + 25) + 11), 62, 14, 4);
       Ui.i().drawUi(34, (x + 4), ((y + 25) + 12), 0, 0);
       Ui.i().drawNum(String.valueOf((this.myB.countS[0] + 100))+"%", (x + 60), ((y + 25) + 24), 1, 1);
       Ui.i().drawString("\x5b\x02\x72\x02\x68\x02\x6b\x02", (x + 2), ((y + 25) + 30), 20, 4, 2);
       this.drawMonKind(this.myB.getMon().monster[4], ((x + 100) + 8), ((y + 25) + 38), 0);
       Ui.i().drawString("\x51\x02\x59\x02\x5e\x02", (x + 2), ((y + 50) + 32), 20, 4, 2);
       x = x + 100;
       x = x + 4;
       y = y + 50;
       y = y + 42;
       this.drawMonsterFealty(this.myB.getMon(), x, y);
    }
    private void drawNidus(int x,int w){
       boolean i;
       boolean i1;
       byte ui2;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       if (this.mini_state == 16) {
          this.drawSelectMenu(this.about_d, (WIDTH_H - 75), (HEIGHT_H - ((this.about_d.length >> 1) * 25)), 150, 1, 0, this.popMenu);
       }else {
          Ui.i().fillRectB();
          this.drawBG0(this.bg_c, (x + 1), 108, 0, w);
          Log.e("sk", "drawNidus");
          Ui.i().drawString(String.valueOf((this.popMenu + 1))+"/"+5, (x + 10), 106, 36, 0, 2);
          Ui ui = Ui.i();
          String str = (this.getRid(this.popMenu) == -2)? "\x6b\x02\x4f\x02\x7f\x02\x76\x02\x52\x02\x66\x02\x7a\x02\x76\x02": this.monsterT[this.monster_pro[this.getNid(this.popMenu)][6]]+"\x76\x02\x5b\x02\x72\x02\x86\x02";
          ui.drawString(str, (x + 20), 110, 0, 1, 0);
          if (this.getRid(this.popMenu) != -2) {
             if (this.b_c < 2) {
                i = 1;
                i1 = 1;
                GameRun gameRun = this.mon_action;
                int i2 = 377;
                int i3 = 97;
                boolean b = (this.b_c == 1)? false: true;
                if (this.drawCartoonOne(i, i1, gameRun, i2, i3, b, 0)) {
                   this.initMonStream(2, this.mList_id[this.getNid(this.popMenu)][0], 1);
                   this.b_c = 2;
                }else if(this.b_c > 1 && this.b_c < 14){
                   this.drawClipPic(this.mList_id[this.getNid(this.popMenu)][1], 1, 377, 97, 80, 77, 15, (this.b_c - 2), 0);
                   ui2 = (byte)(this.b_c + 1);
                   this.b_c = ui2;
                   if (ui2 == 14) {
                      this.b_c = -1;
                   }
                   this.mon_action = (byte)(this.mList_id[this.getNid(this.popMenu)][1] * 3);
                }
             }else {
             }
             if (this.b_c != -1) {
                short barW = (short)(w - 40);
                this.str_cur = String.valueOf(this.getNexp(this.popMenu, 1))+"/"+this.getNexp(this.popMenu, 3);
                Ui.i().drawBarOne((x + 20), 158, barW, Ms.i().mathPercent(this.getNexp(this.popMenu, 1), (barW - 2), this.getNexp(this.popMenu, 3)), Ms.i().mathPercent(this.getNexp(this.popMenu, 1), (barW - 2), this.getNexp(this.popMenu, 3)), 2);
                Ui.i().drawNum(this.str_cur, ((x + 20) + ((barW - (this.str_cur.length() * 8)) >> 1)), 164, 0, 0);
                Ui ui1 = Ui.i();
                String str1 = (this.getNexp(this.popMenu, 1) == this.getNexp(this.popMenu, 3))? "\x5b\x02\x53\x02\x5d\x02\x5b\x02\x62\x02": "\x5b\x02\x53\x02\x4e\x02...";
                ui1.drawString(str1, ((x + 20) + (barW >> 1)), 164, 17, 3, 1);
                Ui.i().drawString("\x5b\x02\x53\x02\x62\x02\x97\x02\x67\x02\x65\x02", ((x + 20) + (barW >> 1)), 208, 17, 3, 1);
                barW = 28;
                this.drawEvolveMake(this.getNid(this.popMenu), (x + 25), 239, barW);
             }else {
                Ui.i().drawStringY(this.about_a, (x + 26), 155, 0, 3, 30, 3, 0);
                Ui.i().drawStringY(this.about_b, (x + 126), 155, 0, 3, 30, 3, 0);
                Ui.i().drawString("\x68\x02\x6b\x02\xff\x02", ((x + 20) + 50), 258, 0, 3, 1);
                this.drawMonKind(this.monster_pro[this.getNid(this.popMenu)][5], (((x + 23) + 100) + 10), 263, 0);
             }
             if (this.getNexp(this.popMenu, 1) == this.getNexp(this.popMenu, 3)) {
                Ui.i().drawString("\x63\x02\x78\x02\x5b\x02\x95\x02\x5b\x02\x62\x02\x5b\x02\x53\x02", (x + 20), ((HEIGHT - 25) - 21), 0, 0, 0);
             }
          }
          if (this.b_c == -2) {
             Ui.i().drawTriangle(WIDTH_H, 120, 150, true, true);
          }
          ui = Ui.i();
          i = (this.getRid(this.popMenu) == -2)? false: true;
          i1 = (this.b_c != -1)? true: false;
          ui.drawYesNo(i, i1);
          byte t = this.pkey.selectMenuX(2, 0, 0, WIDTH_H, HEIGHT);
          if (t != -1) {
             ui2 = (!t)? -3: -4;
             Ms.key = ui2;
             Ms.keyRepeat = true;
          }
       }
       return;
    }
    private void drawPlayer(Graphics g){
       this.drawMyMon();
       this.drawMyMonState();
       this.drawEnemy();
       this.drawEnemyState();
    }
    private void drawPlayerAppear(Graphics g){
       int i = 97;
       int i1 = 2;
       int i2 = 0;
       switch (this.battle_state){
           case 0:
             if (this.battle_type > i1) {
                if (!this.src_c[i1] && (this.enB.throw_state == -1 && this.src_c[i2] == 12)) {
                   this.enB.throw_state = i2;
                }else if(this.enB.throw_state != null && this.enB.throw_state != i1){
                   this.drawCartoonOne(i2, i2, ((this.mList_id[this.enB.getMon().monster[i2]][1] * 3) + this.enB.action), (this.enemyOff + 377), i, i2, i2);
                   this.enemyOff = Ms.i().mathSpeedN(this.enemyOff, i2, 4, i2);
                   if (this.enemyOff == null) {
                      this.enB.throw_state = i1;
                   }
                }
             }else if(this.battle_type < i1){
                this.drawThrowBall(this.enB, this.enB.getMon(), i2, 377, i);
             }
             this.drawThrowBall(this.myB, this.myB.getMon(), 1, 266, 236);
             break;
       }
       return;
    }
    private void drawSelectMenu(Graphics g,boolean bb,int y){
       int HEIGHT = 360;
       Ui.i().drawK2(200, (y + 15), 240, ((HEIGHT - y) - 20), 0);
       this.drawBattleExp(this.myB.getMon(), (y + 3));
       if (!bb) {
          Ui.i().drawString("\x89\x02\x50\x02\x4e\x02\x4e\x02\xff\x02", 450, 10, 0, 0, 2);
          byte i = 0;
          while (i < this.imgBattle.length) {
             Ui.i().drawImage(this.imgBattle[i], this.pkey.button_pos[5][i][0], this.pkey.button_pos[5][i][1], 0);
             int ix = i + 1;
             i = (byte)ix;
          }
       }
       return;
    }
    private void drawSkillList(int x,int y,int w,int fontH,int show_num,byte[] sel){
       byte i = sel[1];
       Ui.i().drawListKY(show_num, x, y, w, 3, fontH, 0, (sel[0] - sel[1]), 4, 2);
       while (true) {
          int ix = sel[1] + show_num;
          if (i < ix && i < this.skill_list[8]) {
             Ui ui = Ui.i();
             int ix1 = (this.skill_list[i] > 25)? 50: 51;
             int ix2 = x + 8;
             int ix3 = y + 8;
             int ix4 = i - sel[1];
             ix4 = ix4 * fontH;
             ix3 = ix3 + ix4;
             ui.drawUi(ix1, ix2, ix3, 0, 0);
             Log.e("sk", "\x66\x02\x90\x02\x65\x02\x51\x02");
             ui = Ui.i();
             String str = this.getNameSkill(this.skill_list[i]).toString();
             ix2 = x + 21;
             ix3 = y + 1;
             ix4 = i - sel[1];
             ix4 = ix4 * fontH;
             ix3 = ix3 + ix4;
             ix4 = 0;
             int ix5 = (sel[0] == i)? 0: 3;
             ui.drawString(str, ix2, ix3, ix4, ix5, 0);
             ui = Ui.i();
             str = (this.skill_list[i] <= 30)? String.valueOf(this.skill[this.skill_list[i]][1]).append("\x80\x02\x91\x02").toString(): "\x88\x02\x52\x02";
             ix2 = x + w;
             ix2 = ix2 - 8;
             ix3 = y + 1;
             ix4 = i - sel[1];
             ix4 = ix4 * fontH;
             ix3 = ix3 + ix4;
             ix4 = 8 | 0x10;
             ix5 = (sel[0] == i)? 0: 3;
             ui.drawString(str, ix2, ix3, ix4, ix5, 0);
             if (this.say_c < 1) {
                ix1 = i - sel[1];
                ix1 = ix1 * fontH;
                ix1 = ix1 + y;
                if (this.pkey.isSelect(x, ix1, w, fontH)) {
                   if (sel[0] == i) {
                      this.pkey.setKey5();
                   }else {
                      sel[0] = i;
                      if (!(ix = i - sel[1]) && sel[1] > 0) {
                         ix = 1;
                         ix1 = sel[ix] - 1;
                         sel[ix] = (byte)ix1;
                      }else {
                         ix = i - sel[1];
                         ix1 = show_num - 1;
                         if (ix == ix1 && (ix = sel[1] + show_num) < this.skill_list[8]) {
                            ix = 1;
                            ix1 = sel[ix] + 1;
                            sel[ix] = (byte)ix1;
                         }
                      }
                   }
                }
             }
             ix = i + 1;
             i = (byte)ix;
          }else {
             break ;
          }
       }
       return;
    }
    private void drawThrowBall(Battle be,Monster mon,int mini,int x,int y){
       int i = 2;
       int i1 = 0;
       int i2 = 1;
       if (be.throw_state == null) {
          Ui.i().drawImage(this.imgItem[i1], (be.cThrow[i1] + x), (y - be.cThrow[i2]), (i2 | 0x20));
       }else if(be.throw_state == i2){
          this.drawClipPic(this.mList_id[mon.monster[i1]][i2], mini, x, y, 80, 77, 15, be.cThrow[i], mini);
       }else if(be.throw_state == i){
          this.drawCartoonOne(mini, mini, (this.mList_id[mon.monster[i1]][i2] * 3), x, y, i2, mini);
       }
       this.runThrowBall(be, mon, mini);
       return;
    }
    private void drawVIEW_COMPUTER(){
       int FONT_W = 25;
       int FONT_H = 25;
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       Ui.i().drawK2(((WIDTH_H - (FONT_W * 2)) - 8), ((HEIGHT_H - (FONT_H * 2)) - 8), ((FONT_W * 4) + 16), ((FONT_H * 6) + 16), 0);
       this.drawSelectMenu(this.about_d, ((WIDTH_H - FONT_W) - 4), (HEIGHT_H - FONT_H), ((FONT_W + 4) * 2), 2, 0, this.popMenu);
       Ui.i().drawString("\x5b\x02\x5b\x02\x5b\x02\x72\x02", WIDTH_H, ((HEIGHT_H - (FONT_H * 2)) - 6), 17, 1, 1);
       Ui.i().drawYesNo(true, true);
    }
    private void effectR(Monster monster){
       if (monster.effect_time > null) {
          monster.effect_time = (byte)(monster.effect_time - 1);
       }
       if (monster.effect_time == null) {
          monster.effect = 7;
       }
       return;
    }
    private void enemy_init(){
       Monster[] eMonsters = new Monster[this.enemyList.length];
       int i = 0;
       while (i < this.enemyList.length) {
          byte b = this.enemyList[i][0];
          byte b1 = this.enemyList[i][1];
          int ix = (this.myMonsters[0].isMonReel(39))? 1: 0;
          eMonsters[i] = new Monster(this, b, b1, ix);
          if (this.battle_type != 3 && this.battle_type != null) {
             eMonsters[i].resetMonster(this, -1);
          }else if(eMonsters[i].monster[3] == -1){
             eMonsters[i].resetBoss(this.enemyList[i][4]);
          }else {
             eMonsters[i].resetMonster(this.enemyList[i][2], this.enemyList[i][3], this.enemyList[i][4]);
          }
          eMonsters[i].resetPro(this);
          i++;
       }
       this.enemyList = null;
       this.enB = new Battle(eMonsters);
       return;
    }
    private int getBXY(int state,int skill,boolean bb){
       int x = 266;
       int y = 236;
       if (state == 1 && (!this.isSkillToMe(skill) || (!state && this.isSkillToMe(skill)))) {
          x = 377;
          y = 97;
       }
       int i = (bb)? x: y;
       return i;
    }
    private void getBattleBG(Battle be,Monster mon){
       int ix;
       if (this.monPro.length) {
          be.bg_id = this.monPro[0];
       }
       byte i = 0;
       while (i < 5) {
          if (ix = i + 43) {
             be.bg_id = i;
             break ;
          }
          ix = i + 1;
          i = (byte)ix;
       }
       return;
    }
    private int getBuyItemCount(int type,int select,boolean bb){
       int c1;
       int i;
       if (bb) {
          int c0 = (type == 2)? this.coin / this.sell_money: this.money / this.sell_money;
          if ((c1 = 99 - this.findItem(-2, this.buyItem[this.cur_a][select], true)) < 0) {
             c1 = 0;
          }
          if (c0 > c1) {
             i = c1;
          }else {
             i = c0;
          }
       }else {
          i = this.items[this.cur_a][select][1];
       }
       return i;
    }
    private void getExpOne(boolean half){
       int ix = 2;
       short s = 0;
       byte i = 0;
       this.exp = s;
       Ms.i();
       Ms.skip2 = this.enB.mon[s].monster[ix];
       while (i < this.enB.mon.length) {
          int ix1 = this.enB.mon[i].monster[ix] * 3;
          ix1 = ix1 + 80;
          int ix2 = this.exp + ix1;
          this.exp = (short)ix2;
          Ms.i();
          if (this.enB.mon[i].monster[ix] > Ms.skip2) {
             Ms.i();
             Ms.skip2 = this.enB.mon[i].monster[ix];
          }
          ix2 = i + 1;
          i = (byte)ix2;
       }
       this.exp = (short)((this.exp * (((56 / this.mon_in_battle[s]) - ((this.mon_in_battle[s] - 1) * 2)) + 44)) / 100);
       if (!half) {
          this.exp = (short)(this.exp / 2);
       }
       return;
    }
    private void getHitCoefficient(Battle be,Monster am,Monster dm){
       be.countS[1] = 0;
       byte coe = (byte)(am.monster[6] - 99);
       Battle countS = be.countS;
       byte b = countS[1];
       int i = (coe > 1)? 20: (coe / 20) * 20;
       if ((countS[1] = (byte)(b + i)) != -1 && be.bg_id != am.monster[3]) {
          countS = be.countS;
          b = countS[1];
          i = (be.bg_id == am.monster[3])? 0: -20;
          countS[1] = (byte)(b + i);
       }
       countS = be.countS;
       countS[1] = (byte)(countS[1] + this.isShuXing(am, dm));
       return;
    }
    private String getInfoType(int i){
       String str;
       if (i == -1) {
          str = "\x4e\x02\x52\x02";
       }else if(i == -2){
          str = "\x8f\x02\x53\x02";
       }else if(i == -3){
          str = "\x5f\x02\x53\x02";
       }else if(i == -4){
          str = "\x7a\x02\x62\x02\x57\x02";
       }else if(i == -5){
          str = "\x5b\x02\x53\x02";
       }else {
          str = "\x63\x02\x83\x02";
       }
       return str;
    }
    private byte getMonInfo_dir(){
       return this.monInfo_dir[this.cur_a][this.getSelInfo()];
    }
    private byte getMonster(Monster monster,int evolve,boolean bb){
       int i;
       if (this.monInfoList[monster.monster[0]] != 2) {
          this.monInfoList[monster.monster[0]] = 2;
          this.addMonInfoListBH();
          this.map.addAnole(monster.monster[0]);
       }
       if (this.myMon_length < this.max_takes) {
          this.myMonsters[this.myMon_length] = monster;
          if (bb) {
             this.myMonsters[this.myMon_length].resetMonster(this, evolve);
          }
          this.myMon_length = (byte)(this.myMon_length + 1);
          i = 0;
       }else if(this.cMon_count < this.max_monsters){
          this.say("\x64\x02\x5e\x02\x5d\x02\x6e\x02\xff\x02"+this.getNameMon(monster.monster[0])+"\x5d\x02\x8f\x02\x51\x02\x5b\x02\x65\x02\x59\x02", 0);
          this.cMonsters[this.cMon_count] = monster;
          if (bb) {
             this.cMonsters[this.cMon_count].resetMonster(this, evolve);
          }
          this.cMon_count = (byte)(this.cMon_count + 1);
          i = 1;
       }else {
          i = -1;
       }
       return i;
    }
    private short getMonsterExp(Monster monster){
       return (short)(((monster.monster[2] * 210) / 10) - 2);
    }
    private String getNameBuff(int buff_id){
       if (buff_id < 1) {
          buff_id = 0;
       }
       return this.buff_name[buff_id];
    }
    private String getNameSkill(byte skill_id){
       return this.skill_name[skill_id];
    }
    private short getPrice(int type,int select,boolean bb){
       short price;
       int i = 0;
       if (bb) {
          price = (type == 2)? this.buyPrice[1][select]: this.buyPrice[i][this.buyItem[this.cur_a][select]];
          if (this.view_state == -1) {
             price = (short)((price * 12) / 10);
          }
       }else {
          price = (short)(this.buyPrice[i][select] / 5);
       }
       return price;
    }
    private byte getSelInfo(){
       return this.select[0][0];
    }
    private void getSkill(int skill_level,int pro){
       byte b = (!skill_level)? 25: this.skill_up[(skill_level - 1)][pro];
       this.getSkill = b;
       return;
    }
    private int getSkillLevel(int skill){
       int i1;
       int i = 25;
       if (skill == i) {
          i1 = 0;
       }else if(skill < i){
          i1 = (skill % 5) + 1;
       }else {
          i1 = this.makeLevel[((skill - i) - 1)];
       }
       return i1;
    }
    private int getSkillMana(Monster mon,int sl){
       byte vaule = this.skill[sl][1];
       int i = (mon.monster[3] == 4 && mon.isMonReel(35))? (this.skill[sl][0] * vaule) / 100: vaule;
       return i;
    }
    private short getbuffRateV(Monster mon,int temp){
       if (mon.isBuffRate(2)) {
          temp = temp + ((this.inhesion[2] * temp) / 100);
       }else if(mon.isBuffRate(1)){
          temp = temp + ((this.inhesion[1] * temp) / 100);
       }
       return (short)temp;
    }
    private void goBattleExp(boolean half){
       this.battle_state = -5;
       this.cur_c = 0;
       this.b_c = 0;
       this.myB.now_id = this.myMonsters[this.myB.now_id].monster[1];
       this.proReplace[this.myB.now_id][2] = -2;
       this.arangeMonster();
       this.getExpOne(half);
    }
    private void goBattleItem(){
       int i = 32;
       this.battle_state = -4;
       this.cur_b = -1;
       StringBuffer sbuff = "";
       Ms.i();
       if (Ms.getRandom(100) < 50 && this.findItem(-2, i, true) < 99) {
          this.addItem(i, true);
          sbuff = sbuff+"\x83\x02\x5f\x02\xff\x02"+this.getNameItem(i)+"x1";
       }
       this.setStringB(sbuff, 0x2710, 0);
       sbuff = null;
       return;
    }
    private void goBattleOver(){
       GameRun.run_state = -15;
       this.b_c = 0;
       this.myB.now_id = 0;
       this.mini_state = 3;
       this.view_state = 1;
       this.bg_c = this.myB.bg_id;
       this.mon[0].nullIMFA();
    }
    private void goBattleState(){
       String[] stringArray = new String[]{"\x65\x02\x51\x02","\x90\x02\x51\x02","\x5b\x02\x72\x02","\x55\x02\x5e\x02","\x90\x02\x8d\x02"};
       this.setAction_str(stringArray);
       GameRun.run_state = -31;
       int i = (this.mini_state == 1)? 2: 1;
       this.battle_state = i;
       return;
    }
    private void goCatchMonster(){
       GameRun.run_state = -19;
       this.cThrowX = 131;
       this.cThrowY = -20;
       this.cThrowS = 176;
       this.b_c = 0;
    }
    private void goGO_RUNINMAP(){
       this.b_c = 0;
       this.popMenu = -1;
       System.gc();
       GameRun.run_state = -11;
    }
    private void goLIST_INFO(boolean bb){
       GameRun.run_state = 68;
       if (this.monInfo_dir == null) {
          byte[] data = Ms.i().getStream("data/book.d", -1);
          Ms.i();
          Ms.skip = 0;
          this.monInfo_dir = Ms.i().create2Array(data);
       }
       if (bb) {
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
       return;
    }
    private void goMONSTER_INFO(int id){
       GameRun.run_state = 67;
       this.initMonStream(2, this.mList_id[id][0], 1);
    }
    private void goMY_BAG(int type){
       String[] stringArray;
       int i = 2;
       int i1 = 1;
       this.mini_state = 15;
       this.list_rows = 6;
       GameRun.run_state = 25;
       this.popMenu = -1;
       if (this.view_state == i1) {
          stringArray = new String[]{"\x90\x02\x51\x02","\x8f\x02\x52\x02","\x53\x02\x8f\x02","\x5b\x02\x53\x02"};
          this.setAction_str(stringArray);
       }else if(this.view_state == -1){
          stringArray = new String[i1];
          stringArray[0] = "\x90\x02\x51\x02";
          this.setAction_str(stringArray);
       }else if(this.view_state == i){
          stringArray = new String[i1];
          stringArray[0] = "\x5b\x02\x53\x02";
          this.setAction_str(stringArray);
       }
       this.selectx = (byte)type;
       this.selecty = 0;
       this.select[0][i1] = this.select_st[this.selectx];
       this.select[0][0] = this.select_it[this.selectx];
       Ms.i().correctSelect(this.select[0], this.itemsLength[this.selectx], this.list_rows);
       this.itemMine = null;
       Ms.i();
       Ms.skip = 0;
       this.itemMine = Ms.i().create2Array(Ms.i().getStream("data/box.d", -1));
       return;
    }
    private void goMontsterAppear(){
       GameRun.run_state = -50;
       this.battle_state = 0;
       this.enemyOff = 63;
       this.setAimBattle(1);
    }
    private void goRUN_IN_MAP(boolean bb){
       this.selecty = 0;
       this.selectx = 0;
       this.select[0][1] = 0;
       this.mini_state = 0;
       this.view_state = 0;
       GameRun.mc.game_state = 30;
       System.out.println("aaaaaaaaaaaaaaaaa");
       if (!(this.map.my.state = 0)) {
          Sound.i().setMusicId(this.musicNo[this.map.mapNo]);
          Sound.i().setMusic(bb);
          Log.d("soars", "tttttttttttttttttttttt");
       }
       if (this.isChangeSound.booleanValue()) {
          Sound.i().setMusicId(this.musicNo[this.map.mapNo]);
          Sound.i().setMusicForMenu(bb);
          Log.d("soars", "ffffffffffffffffffffffffffffffff");
       }
       GameRun.run_state = -10;
       this.createOver = 0;
       this.buyItemID = 0;
       return;
    }
    private void goSelectAction(int mini){
       int i = 1;
       GameRun.run_state = -31;
       byte b = (mini == i)? 2: i;
       this.battle_state = b;
       this.setAimBattle(mini);
       if (mini == i) {
          this.initSkillList(this.myB.getMon());
       }
       this.getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
       this.getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
       return;
    }
    private void goView(){
       this.select[0][1] = this.selectx;
       this.select[0][0] = this.selecty;
       this.cur_c = 0;
       this.popMenu = -1;
       this.setStringB("\x75\x02\x54\x02#n\x80\x02\x91\x02#n\x68\x02\x6b\x02", Constants_H.WIDTH, 0);
       this.setStringB("\x52\x02\x91\x02#n\x96\x02\x5f\x02#n\x65\x02\x63\x02", Constants_H.WIDTH, 1);
    }
    private void hit_rate(Battle amB,Battle dmB,Monster am,Monster dm,int skill_no){
       amB.initHit();
       dmB.initHit();
       this.hit_rate = am.monsterPro[5] - dm.monsterPro[5];
       this.hit_rate = ((this.hit_rate / 2) + 92) + amB.rate_off;
       Ms.i();
       byte rand = (byte)Ms.getRandom(100);
       amB.rate_off = 0;
       if (skill_no > 26 && skill_no < 30) {
          switch (skill_no){
              case 27:
              case 28:
                amB.addHit(((- this.skill[skill_no][0]) * 10), 1, 1);
                break;
              case 29:
                dmB.addHit(((am.monsterPro[6] * this.skill[skill_no][0]) + am.monsterPro[1]), 1, 0);
                amB.addHit(am.monsterPro[1], 4, 2);
                break;
          }
       }else if(rand >= this.hit_rate && (this.mini_state != 1 && am.monster[2] < 11)){
          dmB.addHit(0, -1, 2);
          amB.rate_off = 20;
       }else {
          this.damage(amB, dmB, am, dm, skill_no, (this.mini_state ^ 0x01));
          if (skill_no == 26 && !dmB.getMon().isMonReel(40)) {
             Ms.i();
             if (Ms.getRandom(100) < this.skill[skill_no][2]) {
                dmB.addHit(((this.skill[skill_no][3] * dmB.getMon().monster[6]) / 100), -2, 2);
             }else if(skill_no >= 25 && skill_no != 30){
                this.magicEffectRate(dmB, am, dm, skill_no);
             }
          }else {
          }
          if (am.monster[3] == 2 && am.isMonReel(34)) {
             dmB.addHit(((dm.monsterPro[3] * this.skill[34][0]) / 100), 4, 2);
          }
       }
       return;
    }
    private void hpAdd(int hp,int offer){
       if (this.myMonsters[this.select[0][0]].monsterPro[0] < this.myMonsters[this.select[0][0]].monsterPro[2] && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
          hp = (this.myMonsters[this.select[0][0]].monsterPro[2] * hp) / 100;
          this.AddHP((offer + hp), this.myMonsters[this.select[0][0]]);
          this.useState(0, this.select_it[0]);
       }else if(this.myMonsters[this.select[0][0]].monsterPro[0] < 1){
          this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]))+"\x5d\x02\x7e\x02\x6b\x02\x4e\x02\xff\x02\x65\x02\x6c\x02\x4f\x02\x75\x02\xff\x02", 0);
       }else {
          this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]))+"\x4e\x02\x97\x02\x89\x02\x4f\x02\x75\x02\x8f\x02\x4e\x02\x90\x02\x51\x02", 0);
       }
       return;
    }
    private void initMagicStream(int i){
       if (this.magic[i] == null) {
          String s = "data/battle/s"+i;
          this.magic[i] = Ms.i().createSprite(s, false);
       }
       return;
    }
    private void initOtherImage(){
       Image[] imageArray;
       if (this.imgItem == null) {
          imageArray = new Image[]{Ms.i().createImage("data/ball"),Ms.i().createImage("data/ll")};
          this.imgItem = imageArray;
          this.initItemModules();
       }
       if (this.imgBG == null) {
          imageArray = new Image[5];
          this.imgBG = imageArray;
          byte i = 0;
          while (i < this.imgBG.length) {
             this.imgBG[i] = Ms.i().createImage("data/battle/".append(i).toString());
             int ix = i + 1;
             i = (byte)ix;
          }
       }
       this.initImgIco();
       return;
    }
    private boolean isBagUse(int id){
       boolean b;
       if (this.view_state == -1) {
          b = (id != 14 && id != 15)? true: false;
       }else if(id != 9 && (id != 10 && (id != 11 && id != 8))){
          b = true;
       }else {
          b = false;
       }
       return b;
    }
    private byte isEvolveKind(byte kind,byte level){
       byte dd = -1;
       if (kind == 1 && level < 15) {
          dd = -2;
       }else if(kind == 2 && level < 25){
          dd = -3;
       }else if(kind == 3 && level < 30){
          dd = -4;
       }
       return dd;
    }
    private byte isEvolveMake(int id){
       int evolve1;
       byte i = 2;
       byte evolve = this.monsterMake[id][0];
       while (true) {
          int ix = i + 1;
          if (this.findItem(-2, this.monsterMake[id][i], true) < this.monsterMake[id][ix]) {
             evolve = -1;
             evolve1 = evolve;
             break ;
          }else {
             int ix1 = i + 2;
             i = (byte)ix1;
             ix1 = this.monsterMake[id].length - true;
             if (i >= ix1) {
                if (evolve > 0 && this.findItem(-2, 34, true) < true) {
                   evolve = 0;
                }
                evolve1 = evolve;
                break ;
             }
          }
       }
       return evolve1;
    }
    private boolean isMonHp(Monster mon,int percent){
       boolean b = (mon.monsterPro[0] < ((mon.monster[2] * percent) / 100))? true: 0;
       return b;
    }
    private boolean isMyMonsters(int select_i){
       int b;
       byte i = 0;
       while (true) {
          if (i >= this.myMon_length) {
             b = false;
             break ;
          }else if(i != select_i && this.myMonsters[i].monsterPro[0] > 0){
             b = true;
             break ;
          }else {
             b = i + 1;
             i = (byte)b;
          }
       }
       return b;
    }
    private byte isShuXing(Monster am,Monster dm){
       byte b;
       if (am.monster[3] == -1) {
          b = 30;
       }else if(this.Shuxing[am.monster[3]][0] == dm.monster[3]){
          b = 30;
       }else if(this.Shuxing[am.monster[3]][1] == dm.monster[3]){
          b = 0;
       }else {
          b = 0;
       }
       return b;
    }
    private boolean isSkillToMe(int skill){
       boolean b = (skill != 27 && skill != 28)? false: true;
       return b;
    }
    private void keyBattleState(){
       int i = 2;
       int i1 = -1;
       int i2 = 1;
       if (!Ms.i().key_delay()) {
          switch (this.battle_state){
              case 2:
                if (Ms.i().key_Left_Right()) {
                   this.cur_a = Ms.i().select(this.cur_a, 0, (this.action_str.length - i2));
                }else if(Ms.i().key_S1_Num5()){
                   if (this.cur_a == null) {
                      if (!this.myB.getMon().monster[6]) {
                         this.say("\x5b\x02\x72\x02\x5f\x02\x8b\x02\x5e\x02\x4e\x020\xff\x02\x8b\x02\x7a\x02\x52\x02\x88\x02\x51\x02\xff\x02", i1);
                      }else {
                         this.battle_state = 3;
                         while (this.skill_list[this.lastSkill] > 30) {
                            int i3 = this.lastSkill + 1;
                            this.lastSkill = (byte)i3;
                         }
                         this.select[0][0] = this.lastSkill;
                         if ((this.select[0][i2] = (byte)(this.select[0][0] - 5)) < i2) {
                            this.select[0][i2] = 0;
                         }
                      }
                   }else if(this.cur_a == i2){
                      if (this.myB.getMon().effect == 4) {
                         this.say("\x79\x02\x95\x02\x4e\x02\x65\x02\x6c\x02\x4f\x02\x75\x02\x90\x02\x51\x02\xff\x02", i1);
                      }else {
                         this.goMY_BAG(0);
                      }
                   }else if(this.cur_a == i){
                      if (this.myB.getMon().effect == 4) {
                         this.say("\x79\x02\x95\x02\x4e\x02\x65\x02\x6c\x02\x66\x02\x63\x02\x5b\x02\x72\x02\xff\x02", i1);
                      }else {
                         this.view_state = -2;
                         this.goVIEW_MONSTER();
                      }
                   }else if(this.cur_a == 3){
                      this.goBUY_ITEM(0, 0);
                   }else if(this.cur_a == 4){
                      if (this.battle_type == 4) {
                         short EscRate = (short)((this.myB.getMon().monster[i] - this.enB.getMon().monster[i]) + 60);
                         byte succ = 0;
                         Ms.i();
                         if (Ms.getRandom(100) >= EscRate) {
                            succ = 1;
                         }
                         if (this.myB.getMon().isMonReel(42)) {
                            succ = 0;
                         }else if(!this.myB.getMon().isEffect(3) && !this.myB.getMon().isEffect(4)){
                            succ = 2;
                         }
                         if (!succ) {
                            this.arangeMonster();
                            this.setNullBattle();
                            this.goGO_RUNINMAP();
                         }else if(succ == i2){
                            this.say("\x90\x02\x8d\x02\x59\x02\x8d\x02\xff\x02", i2);
                            this.myB.act_num = 0;
                            this.enB.act_num = i2;
                            this.battle_state = 9;
                         }else {
                            String str = "\x88\x02\x60\x02\x72\x02";
                            String str1 = (this.myB.getMon().isEffect(4))? "\x79\x02\x95\x02\x4e\x02": "\x76\x02\x75\x02\x77\x02\x9b\x02\x60\x02\x4e\x02";
                            this.say(str+str1+","+"\x65\x02\x6c\x02\x90\x02\x8d\x02\xff\x02", i2);
                         }
                      }else {
                         this.say("\x65\x02\x6c\x02\x90\x02\x8d\x02\xff\x02", 0);
                      }
                   }
                }
                break;
              case 3:
                if (Ms.i().key_Up_Down()) {
                   Ms.i().selectS(this.select[0], 0, this.skill_list[8], 6);
                   this.lastSkill = this.select[0][0];
                }else if(Ms.i().key_S1_Num5()){
                   if (this.skill_list[this.select[0][0]] > 30) {
                      this.say("\x88\x02\x52\x02\x62\x02\x80\x02\x65\x02\x6c\x02\x4f\x02\x75\x02!", i1);
                   }else if(this.myB.getMon().effect == 6 && this.getSkillLevel(this.skill_list[this.select[0][0]]) > 3){
                      this.say("\x5c\x02\x95\x02\x65\x02\x67\x02\xff\x02\x4e\x02\x80\x02\x4f\x02\x75\x024\x7e\x02\x4e\x02\x4e\x02\x62\x02\x80\x02", i1);
                   }else if(this.myB.getMon().monsterPro[i2] >= this.getSkillMana(this.myB.getMon(), this.skill_list[this.select[0][0]])){
                      this.myB.skill = this.skill_list[this.select[0][0]];
                      this.battle_state = 9;
                   }else {
                      this.say("\x97\x02\x89\x02\x76\x02\x62\x02\x80\x02\x50\x02\x4e\x02\x59\x02\xff\x02", i1);
                   }
                }else if(Ms.i().key_S2()){
                   this.battle_state = i;
                }
                break;
              case 4:
                if (Ms.i().key_Up_Down()) {
                   Ms.i().selectS(this.select[0], 0, 6, this.skill_list[8]);
                }else if(!Ms.i().key_S1_Num5() && Ms.i().key_S2()){
                   this.battle_state = i;
                }
                break;
              case 5:
                if (Ms.i().key_Up_Down()) {
                   Ms.i().selectS(this.select[0], 0, 6, this.skill_list[8]);
                }else if(!Ms.i().key_S1_Num5() && Ms.i().key_S2()){
                   this.battle_state = i;
                }
                break;
              default:
          }
       }
       return;
    }
    private void keyBuyItem(){
       int b;
       GameRun tcur_a;
       byte b1;
       byte[][] uobyteArray = null;
       if (!Ms.i().key_delay()) {
          if (this.popMenu == -1) {
             if (Ms.i().key_Left_Right() && this.cur_b != null) {
                this.cur_a = Ms.i().select(this.cur_a, 0, 2);
                this.select[0][0] = 0;
                this.select[0][1] = 0;
             }else if(Ms.i().key_Up_Down()){
                Ms ms = Ms.i();
                object oobject = this.select[0];
                b = (this.cur_b == 1)? this.itemsLength[this.cur_a]: this.buyItem[this.cur_a].length;
                ms.selectS(oobject, 0, b, this.list_rows);
             }else if(Ms.i().key_S1_Num5()){
                this.popMenu = 1;
                tcur_a = this.cur_a;
                b1 = (this.cur_b != 1)? this.select[0][0]: this.items[this.cur_a][this.select[0][0]][0];
                b = (this.cur_b != 1)? 1: 0;
                this.sell_money = this.getPrice(tcur_a, b1, b);
                tcur_a = this.cur_a;
                b1 = this.select[0][0];
                b = (this.cur_b != 1)? 1: 0;
                this.t_length = (byte)this.getBuyItemCount(tcur_a, b1, b);
             }else if(Ms.i().key_S2()){
                this.buyItem = uobyteArray;
                this.buyPrice = uobyteArray;
                if (this.view_state == -1) {
                   this.goBattleState();
                }else {
                   this.goGO_RUNINMAP();
                }
             }
          }else if(this.buyOk == null && Ms.i().key_Left_Right()){
             this.popMenu = Ms.i().select(this.popMenu, 1, this.t_length);
          }else if(Ms.i().key_S1_Num5()){
             if (this.buyOk == 1) {
                if (this.cur_b == 1) {
                   this.money = this.money + (this.sell_money * this.popMenu);
                   this.deleteItems(this.items[this.cur_a][this.select[0][0]][0], this.popMenu);
                   if (this.select[0][0] >= this.itemsLength[this.cur_a]) {
                      object oobject1 = this.select[0];
                      b1 = (byte)(oobject1[0] - 1);
                      oobject1[0] = b1;
                      if (b1 < 0) {
                         this.select[0][0] = 0;
                      }
                      oobject1 = this.select[0];
                      b1 = (byte)(oobject1[1] - 1);
                      oobject1[1] = b1;
                      if (b1 < 0) {
                         this.select[0][1] = 0;
                      }
                   }
                   this.say("\x83\x02\x5f\x02\x91\x02\x94\x02\xff\x02"+(this.sell_money * this.popMenu), 0);
                }else {
                   tcur_a = this.cur_a;
                   b1 = this.buyItem[this.cur_a][this.select[0][0]];
                   GameRun tpopMenu = this.popMenu;
                   int i = (this.cur_a != 2)? 1: 0;
                   if (this.isMoneyItem(tcur_a, b1, tpopMenu, i) && this.addItem(this.buyItem[this.cur_a][this.select[0][0]], this.popMenu) != -1) {
                      this.say("\x8d\x02\x4e\x02\x62\x02\x52\x02", 0);
                   }
                }
                this.buyOk = 0;
                this.popMenu = -1;
             }else {
                this.buyOk = 1;
             }
          }else if(Ms.i().key_S2()){
             this.popMenu = (this.buyOk == null)? -1: 0;
          }
       }
       return;
    }
    private void keyEvolveUI(){
       if (Ms.i().key_S1_Num5() && this.b_c == null) {
          byte kind = this.myMonsters[this.selecty].monster[4];
          byte level = this.myMonsters[this.selecty].monster[2];
          byte id = this.myMonsters[this.selecty].monster[0];
          byte dd = this.isEvolveMake(id);
          if (this.isEvolveKind(kind, level) != -1) {
             dd = this.isEvolveKind(kind, level);
          }
          if (!dd) {
             this.myMonsters[this.selecty].evolveMonster(this, this.monsterMake[id][1], 1);
          }else if(dd > 0){
             this.myMonsters[this.selecty].evolveMonster(this, this.monsterMake[id][0], this.myMonsters[this.selecty].monster[5]);
          }else if(dd == -1){
             this.say("\x67\x02\x65\x02\x4e\x02\x8d\x02\xff\x02\x4e\x02\x80\x02\x8f\x02\x53\x02\xff\x02", 0);
             this.popMenu = 1;
          }else if(dd == -2){
             this.say("\x7b\x02\x7e\x02\x6c\x02\x67\x02\x8f\x02\x52\x0215\x7e\x02\xff\x02\x4e\x02\x80\x02\x8f\x02\x53\x02\xff\x02", 0);
          }else if(dd == -3){
             this.say("\x7b\x02\x7e\x02\x6c\x02\x67\x02\x8f\x02\x52\x0225\x7e\x02\xff\x02\x4e\x02\x80\x02\x8f\x02\x53\x02\xff\x02", 0);
          }else {
             this.say("\x7b\x02\x7e\x02\x6c\x02\x67\x02\x8f\x02\x52\x0230\x7e\x02\xff\x02\x4e\x02\x80\x02\x8f\x02\x53\x02\xff\x02", 0);
          }
          if (dd > -1) {
             this.b_c = 1;
             this.setMagic(6);
             this.setShowPro(this.myMonsters[this.selecty]);
             this.popMenu = 0;
             this.delItemEvolve(id);
             if (dd > 0) {
                this.deleteItems(34, 1);
             }
          }
       }else if(Ms.i().key_S2()){
          this.goView();
          this.setShowPro(this.myMonsters[this.selecty]);
       }else if(Ms.i().key_Left_Right() && this.b_c <= null){
          this.popMenu = (byte)(this.popMenu ^ 0x01);
       }
       return;
    }
    private void keyGetSkill(Monster mon){
       int i = -1;
       if (((this.getSkill + 9)) >= 35 && this.makeLevel[((this.getSkill + 9) - 35)] > this.rmsOther[3]) {
          this.say("\x97\x02\x89\x02\x8b\x02\x7e\x02\x5e\x02"+this.makeLevel[((this.getSkill + 9) - 35)]+"\x7e\x02\x62\x02\x80\x02\x5b\x02\x4e\x02\xff\x02", 0);
       }else if(mon.isMonReel(this.getSkill)){
          this.say(String.valueOf(this.getNameMon(mon.monster[0]))+"\x5d\x02\x62\x02\x67\x02\x8b\x02\x62\x02\x80\x02", 0);
       }else if(mon.monster[14] != i && mon.monster[15] != i){
          this.initSkillList(mon);
          this.bg_c = mon.monster[3];
          this.restMove(1, 0);
          this.say("\x8b\x02\x90\x02\x62\x02\x89\x02\x66\x02\x63\x02\x76\x02\x62\x02\x80\x02\xff\x02", 0);
       }else if(mon.monster[14] == i){
          mon.monster[14] = this.getSkill;
       }else {
          mon.monster[15] = this.getSkill;
       }
       this.delItemSkill(mon);
       return;
    }
    private void keyMY_BAG(){
       int i = -1;
       int i1 = 2;
       if (!Ms.i().key_delay()) {
          if (this.popMenu == i) {
             if (Ms.i().key_S1_Num5() && this.itemsLength[this.selectx] > 0) {
                this.popBagMenu(this.selectx, this.select[0][0]);
             }else if(Ms.i().key_Left_Right()){
                this.selectx = Ms.i().select(this.selectx, 0, (this.action_str.length - 1));
                this.select[0][1] = this.select_st[this.selectx];
                this.select[0][0] = this.select_it[this.selectx];
             }else if(Ms.i().key_S2()){
                if (this.mini_state == 9) {
                   this.mini_state = 5;
                   this.selecty = this.select_T;
                   this.selecty = 0;
                   this.goVIEW_MONSTER();
                }else if(this.view_state == i){
                   this.mini_state = 1;
                   this.goBattleState();
                   this.initMonStream(i1, this.mList_id[this.myMonsters[0].monster[0]][0], 1);
                   this.itemMine = null;
                }else if(this.view_state == i1){
                   GameRun.run_state = -10;
                   GameRun.mc.paint();
                   this.goNidus(0);
                }else {
                   this.doPaint(0);
                   this.goYouPAUSE(i1);
                   this.itemMine = null;
                }
             }else if(Ms.i().key_Up_Down()){
                if (this.itemsLength[this.selectx] > 0) {
                   Ms.i().selectS(this.select[0], 0, this.itemsLength[this.selectx], this.list_rows);
                }
                this.select_it[this.selectx] = this.select[0][0];
                this.select_st[this.selectx] = this.select[0][1];
             }
          }else {
             this.popBagState();
          }
       }
       return;
    }
    private void keyMagicUI(){
       object oobject;
       int i = 14;
       int i1 = 13;
       int i2 = 1;
       if (Ms.i().key_S1_Num5() && this.mini_state == i1) {
          if (this.skill_list[this.select[0][0]] <= 25) {
             this.say("\x8b\x02\x62\x02\x80\x02\x4e\x02\x80\x02\x66\x02\x63\x02\xff\x02", 0);
          }else if(this.skill_list[this.select[0][0]] == this.myMonsters[this.selecty].monster[i]){
             this.myMonsters[this.selecty].monster[i] = this.getSkill;
          }else {
             this.myMonsters[this.selecty].monster[15] = this.getSkill;
          }
          this.delItemSkill(this.myMonsters[this.selecty]);
       }else if(Ms.i().key_S2()){
          this.select[0][i2] = this.selectx;
          this.select[0][0] = this.selecty;
          this.cur_c = 0;
          this.popMenu = -1;
       }else if(Ms.i().key_Left_Right() && this.mini_state != i1){
          this.popMenu = (byte)(this.popMenu ^ 0x01);
          this.select[0][0] = 0;
          this.select[0][i2] = 0;
       }else if(Ms.i().key_Up_Down()){
          this.introX = Constants_H.WIDTH_H;
          if (this.popMenu == null) {
             Ms.i().selectS(this.select[0], 0, this.skill_list[8], 5);
          }else if(this.mini_state == 6){
             if (this.cMonsters[this.selecty].monster[17] > 0) {
                oobject = this.select[0];
                oobject[0] = (byte)(oobject[0] ^ 0x01);
             }
          }else if(this.myMonsters[this.selecty].monster[17] > 0){
             oobject = this.select[0];
             oobject[0] = (byte)(oobject[0] ^ 0x01);
          }
       }
       return;
    }
    private void keyNidus(){
       int i = -1;
       if (!Ms.i().key_delay()) {
          if (this.mini_state == 16) {
             if (Ms.i().key_Up_Down()) {
                this.popMenu = Ms.i().select(this.popMenu, 0, (this.about_d.length - 1));
             }else if(Ms.i().key_S1_Num5()){
                if (Ms.i().equals(this.about_d[this.popMenu], "\x67\x02\x77\x02\x5b\x02\x53\x02")) {
                   this.mini_state = 17;
                   this.popMenu = 0;
                   this.initMonStream(0, 56, 1);
                   if (this.getRid(this.popMenu) == -2) {
                      this.bg_c = this.popMenu;
                   }else {
                      this.bg_c = this.monster_pro[this.getNid(this.popMenu)][6];
                      this.mon_action = (byte)(this.bg_c + 23);
                   }
                }else if(Ms.i().equals(this.about_d[this.popMenu], "\x90\x02\x62\x02\x86\x02")){
                   this.view_state = 2;
                   this.goMY_BAG(3);
                }else if(Ms.i().equals(this.about_d[this.popMenu], "\x79\x02\x5f\x02")){
                   this.exitNidus();
                }
             }else if(Ms.i().key_S2()){
                this.exitNidus();
             }
          }else if(this.b_c == -2 && Ms.i().key_Left_Right()){
             this.popMenu = Ms.i().select(this.popMenu, 0, 4);
             if (this.getRid(this.popMenu) == -2) {
                this.bg_c = this.popMenu;
             }else {
                this.bg_c = this.monster_pro[this.getNid(this.popMenu)][6];
                this.mon_action = (byte)(this.bg_c + 23);
             }
          }else if(Ms.i().key_S1_Num5()){
             if (this.getRid(this.popMenu) != -2) {
                if (this.b_c == -2 && this.getNexp(this.popMenu, 1) == this.getNexp(this.popMenu, 3)) {
                   if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
                      this.say("\x5b\x02\x72\x02\x7a\x02\x95\x02\x5d\x02\x6e\x02", 0);
                   }else if(!this.isEvolveMake(this.getNid(this.popMenu))){
                      this.mon_action = (byte)(this.bg_c + 28);
                      this.b_c = 1;
                      this.setNidusPro(this.getNid(this.popMenu), 1);
                      this.delItemEvolve(this.getNid(this.popMenu));
                   }else {
                      this.say("\x67\x02\x65\x02\x4e\x02\x8d\x02\xff\x02\x4e\x02\x80\x02\x5b\x02\x53\x02", 0);
                   }
                }else if(this.b_c == i){
                   this.b_c = -2;
                   this.getMonster(this.getNid(this.popMenu), this.getNLevel(this.popMenu), -2, i);
                   this.delNidus(this.popMenu);
                   this.initMonStream(0, 56, 1);
                }
             }
          }else if(this.b_c == -2 && Ms.i().key_S2()){
             this.exitNidus();
          }
       }
       return;
    }
    private void key_MONSTER_LIST(Monster[] mon){
       int i = 15;
       int i1 = 3;
       if (this.popMenu == -1) {
          if (Ms.i().key_S1_Num5() && this.t_length != null) {
             if (this.view_state == 1) {
                if (this.mini_state == i) {
                   this.useItem();
                }else if(this.mini_state == 13){
                   this.keyGetSkill(mon[this.select[0][0]]);
                }else {
                   StringBuffer sbuff = "\x59\x02\x8d\x02#n\x62\x02\x80\x02";
                   if (this.mini_state == 4) {
                      if (mon[this.select[0][0]].monster[5] > 0) {
                         sbuff = sbuff+"#n\x8f\x02\x53\x02";
                      }
                      if (this.t_length > 1) {
                         sbuff = sbuff+"#n\x5b\x02\x65\x02#n\x53\x02\x5b\x02";
                      }
                   }else if(this.mini_state == 6){
                      if (this.map.gmErr == null) {
                         sbuff = sbuff+"#n\x53\x02\x51\x02#n\x53\x02\x5b\x02";
                      }else {
                         sbuff = sbuff+"#n\x53\x02\x5b\x02";
                      }
                   }else if(this.select[0][0]){
                      sbuff = sbuff+"#n\x53\x02\x62\x02";
                   }
                   if (mon[this.select[0][0]].monster[5] > 0) {
                      sbuff = sbuff+"#n\x8f\x02\x53\x02";
                   }
                   if (this.t_length > 1) {
                      sbuff = sbuff+"#n\x65\x02\x75\x02";
                   }
                   this.setStringB(sbuff, Constants_H.WIDTH, i1);
                   sbuff = null;
                   this.popMenu = 0;
                }
             }else if(this.view_state < null){
                if (this.mini_state == i) {
                   this.useItem();
                }else if(this.select[0][0]){
                   this.setStringB("\x53\x02\x62\x02#n\x62\x02\x80\x02", Constants_H.WIDTH, i1);
                }else {
                   this.setStringB("\x62\x02\x80\x02", Constants_H.WIDTH, i1);
                }
                this.popMenu = 0;
             }
          }else if(Ms.i().key_S2()){
             if (this.mini_state == 13) {
                this.goMY_BAG(2);
             }else if(this.view_state == 1){
                if (this.mini_state == i) {
                   this.goMY_BAG(0);
                   this.mini_state = i1;
                }else if(this.mini_state != 6 && this.mini_state != 4){
                   this.doPaint(0);
                   this.goYouPAUSE(1);
                }else if(this.map.gmErr == null){
                   this.doPaint(0);
                   int i2 = (this.mini_state == 6)? 1: 0;
                   this.goVIEW_COMPUTER(i2);
                }else {
                   this.map.bkEvent_getMon();
                }
             }else if(this.view_state == -2){
                if (mon[0].monsterPro[0] > 0) {
                   if (this.select[0][0]) {
                      this.initMonStream(2, this.mList_id[mon[0].monster[0]][0], 1);
                   }
                   this.goBattleState();
                }else {
                   this.say("\x5f\x02\x52\x02\x5b\x02\x72\x02\x4e\x02\x80\x02\x53\x02\x62\x02", 0);
                }
                this.view_state = -1;
             }else if(this.view_state == -1){
                if (this.mini_state == i) {
                   this.goMY_BAG(0);
                }else {
                   this.say("\x5f\x02\x52\x02\x5b\x02\x72\x02\x4e\x02\x80\x02\x53\x02\x62\x02", 0);
                }
             }
          }else if(Ms.i().key_Up_Down() && this.t_length != null){
             Ms.i().selectS(this.select[0], 0, this.t_length, this.list_rows);
             this.initMonStream(2, this.mList_id[mon[this.select[0][0]].monster[0]][0], 1);
             this.setShowPro(mon[this.select[0][0]]);
             this.introT = Constants_H.WIDTH_H;
          }
       }else {
          this.popState();
       }
       return;
    }
    private boolean level_up(int no,int mode){
       boolean b;
       short expt;
       short s = 0;
       if (!mode) {
          Ms.i();
          byte LevelCha = (byte)(this.myMonsters[no].monster[2] - Ms.skip2);
          short buff = 0;
          Ms.i();
          Ms.skip = this.exp;
          if (this.myMonsters[no].isMonReel(36)) {
             buff = (short)(buff + 100);
          }
          if (this.myMonsters[no].isMonReel(37)) {
             buff = (short)(buff + 200);
          }
          if (LevelCha < 0) {
             LevelCha = 0;
          }else if(LevelCha > 4){
             LevelCha = 5;
          }
          Ms.i();
          Ms.i();
          Ms.skip = (short)(((Ms.skip * (9 - (LevelCha * 2))) * (buff + 100)) / 1000);
          Ms.i();
          if (Ms.skip < 1) {
             Ms.i();
             Ms.i();
             Ms.skip = Ms.getRandom(6) + 5;
          }
          if (this.battle_type == 3 || this.battle_type == null) {
             Ms.i();
             Ms.i();
             Ms.skip = (short)((Ms.skip * 3) / 2);
          }
          Ms.i();
          this.proReplace[no][2] = (short)Ms.skip;
       }else if(mode == 1){
          if (this.myMonsters[no].monster[2] < 60) {
             Ms.i();
             if (Ms.skip > 0) {
                short tempLevelExp = this.getMonsterExp(this.myMonsters[no]);
                Ms.i();
                if ((expt = (short)(this.myMonsters[no].monsterPro[4] + Ms.skip)) >= tempLevelExp) {
                   this.myB.cexp = this.myMonsters[no].monsterPro[4];
                   this.myMonsters[no].monsterPro[4] = tempLevelExp;
                   Ms.i();
                   Ms.skip = (short)(expt - tempLevelExp);
                }else {
                   this.myB.cexp = this.myMonsters[no].monsterPro[4];
                   Monster monsterPro = this.myMonsters[no].monsterPro;
                   Ms.i();
                   monsterPro[4] = (short)(monsterPro[4] + Ms.skip);
                   Ms.i();
                   Ms.skip = -1;
                }
             }
          }
          Ms.i();
          Ms.skip = -1;
          this.proReplace[no][2] = s;
       }else if(mode == 2){
          Ms.i();
          if (Ms.skip > -1) {
             this.levelPro(no, s);
             this.getMagic(this.myMonsters[no]);
             this.levelUp_in_battle[this.myMonsters[no].monster[1]][s] = 1;
             this.levelUp_in_battle[this.myMonsters[no].monster[1]][1] = this.getSkill;
             this.myMonsters[no].monsterPro[4] = s;
          }else {
             b = s;
          label_0090 :
             return b;
          }
       }
       b = true;
       goto label_0090 ;
    }
    private void loadGame(){
       this.map.firstDrawMap = 0;
       this.buyOk = 0;
       this.map.mapImg = null;
       System.out.println("loadGame 111111111111");
       GameRun.mc.goGameLoading();
       System.out.println("loadGame 22222222222");
    }
    private boolean magicEffectRate(Battle dmB,Monster am,Monster dm,int skill_no){
       byte b;
       byte DebuffRate;
       if (dm.effect != 7) {
          b = false;
       }else {
          byte buff = this.skill[skill_no][3];
          if (!(DebuffRate = this.skill[skill_no][2])) {
             b = false;
          }else if(!buff){
             if (dm.isBuffRate(5)) {
                DebuffRate = (byte)(this.inhesion[5] + DebuffRate);
             }else if(dm.isBuffRate(6)){
                DebuffRate = (byte)(this.inhesion[6] + DebuffRate);
             }
          }else if(buff == 4){
             if (dm.isBuffRate(7)) {
                DebuffRate = (byte)(this.inhesion[7] + DebuffRate);
             }else if(dm.isBuffRate(8)){
                DebuffRate = (byte)(this.inhesion[8] + DebuffRate);
             }
          }else if(buff != 2 && buff != 5){
             if (dm.isBuffRate(11)) {
                DebuffRate = (byte)(this.inhesion[11] + DebuffRate);
             }else if(dm.isBuffRate(12)){
                DebuffRate = (byte)(this.inhesion[12] + DebuffRate);
             }
          }
          Ms.i();
          if (Ms.getRandom(100) < DebuffRate) {
             dm.effect = buff;
             if (buff != 3 && (buff != 4 && buff != 5)) {
                if (buff == 2) {
                   b = (am.isMonReel(32))? 5: 4;
                   dm.effect_time = (byte)b;
                }else if(!buff){
                   dm.effect_time = 2;
                }else if(buff == 6){
                   if (dm.monster[3] == -1) {
                      dm.effect = 7;
                      this.say("\x5c\x02\x95\x02\x65\x02\x67\x02\xff\x02\x5b\x02\x5e\x02\x66\x02\x9b\x02\x73\x02\x4e\x02\x8d\x02\x4f\x02\x75\x02", -1);
                   }else {
                      dm.effect_time = 4;
                   }
                }
             }else {
                dm.effect_time = 4;
             }
             if (buff == 5) {
                b = (am.isMonReel(31))? this.skill[31][0]: 1;
                dmB.fs_level = (byte)(b + skill_no);
             }
             b = true;
          }else {
             b = 0;
          }
       }
       return b;
    }
    private byte monsterRemove(int no){
       byte ix;
       if (this.myMon_length > 1) {
          this.myMonsters[no] = null;
          byte i = (byte)no;
          while (true) {
             ix = this.myMon_length - 1;
             if (i >= ix) {
                break ;
             }else {
                int ix1 = i + 1;
                this.myMonsters[i] = this.myMonsters[ix1];
                ix1 = i + 1;
                this.evolve[i] = this.evolve[ix1];
                ix = i + 1;
                i = (byte)ix;
             }
          }
          i = this.myMon_length;
          while (i < this.myMonsters.length) {
             this.evolve[i] = 1;
             ix = i + 1;
             i = (byte)ix;
          }
          this.myMon_length = (byte)(this.myMon_length - 1);
          ix = 1;
       }else {
          ix = -1;
       }
       return ix;
    }
    private void mpAdd(int hp){
       if (this.myMonsters[this.select[0][0]].monsterPro[1] < this.myMonsters[this.select[0][0]].monsterPro[3] && this.myMonsters[this.select_T].monsterPro[0] > 0) {
          hp = (this.myMonsters[this.select[0][0]].monsterPro[3] * hp) / 100;
          this.AddMP(hp, this.myMonsters[this.select[0][0]]);
          this.useState(0, this.select_it[0]);
       }else if(this.myMonsters[this.select[0][0]].monsterPro[1] < 1){
          this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]))+"\x5d\x02\x7e\x02\x6b\x02\x4e\x02\xff\x02\x65\x02\x6c\x02\x4f\x02\x75\x02\xff\x02", 0);
       }else {
          this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]))+"\x4e\x02\x97\x02\x89\x02\x4f\x02\x75\x02\x8f\x02\x4e\x02\x90\x02\x51\x02", 0);
       }
       return;
    }
    private void paintBATTLE_OVER(){
       if (this.b_c == 1) {
          this.drawEvolveUI(0, this.myB.now_id, 0);
       }
       return;
    }
    private void paintBattleState(Graphics g){
       int WIDTH_H = 320;
       switch (this.battle_state){
           case 0xfffffffb:
             if (this.proReplace[this.myB.now_id][2] > -1) {
                String s = String.valueOf(this.getNameMon(this.myMonsters[this.myB.now_id].monster[0]))+"\x83\x02\x5f\x02\x7e\x02\x9a\x02\xff\x02";
                Log.e("sk", "\x83\x02\x5f\x02\x7e\x02\x9a\x02");
                Ui.i().drawString(s, 204, 308, 36, 1, 0);
                s = this.proReplace;
                Ui.i().drawNum(s[this.myB.now_id][2], 220, 315, 0, 1);
                s = null;
             }else if(this.proReplace[this.myB.now_id][2] == -1){
                Ui.i().drawString("\x60\x02\x76\x02\x5b\x02\x72\x02\x5d\x02\x7e\x02\x65\x02\x6c\x02\x83\x02\x5f\x02\x7e\x02\x9a\x02", 204, 282, 36, 7, 0);
                Ms.i().sleep(600);
             }
             break;
           case 0xfffffffc:
           case 0:
           case 1:
           case 2:
           case 4:
           case 5:
           case 0xfffffffd:
             if (this.drawHitOne(this.am, this.dm, (this.getBXY((this.mini_state ^ 0x01), 25, true) - 15), (this.getBXY((this.mini_state ^ 0x01), 25, false) - 34)) && this.runHitToState(this.dm, this.am, (this.mini_state ^ 0x01))) {
                this.battle_state = 9;
                this.effectR(this.dm.getMon());
             }
             break;
           case 0xfffffffe:
             if (this.drawHitOne(this.dm, this.am, (this.getBXY(this.mini_state, this.am.skill, true) - 15), (this.getBXY(this.mini_state, this.am.skill, false) - 34)) && (this.drawHitOne(this.am, this.dm, (this.getBXY((this.mini_state ^ 0x01), 25, true) - 15), (this.getBXY((this.mini_state ^ 0x01), 25, false) - 34)) && this.runHitToState(this.am, this.dm, this.mini_state))) {
                this.battle_state = -3;
                this.am.initHit();
                this.doEffectValue(this.am);
                this.doBuffValue(this.am);
             }
             break;
           case 0xffffffff:
             this.drawAnimationBattle(this.am, this.mini_state);
             break;
           case 3:
             Ui.i().drawK0((WIDTH_H - 150), 50, 300, 193, 0);
             Ui.i().sliding((WIDTH_H + 125), 60, 173, this.select[0][0], this.skill_list[8], false);
             this.drawSkillList(((WIDTH_H - 150) + 10), 60, 250, 28, 6, this.select[0]);
             this.showStringM(this.skill_help[this.skill_list[this.select[0][0]]], WIDTH_H, 269, 7, 0);
             Ui.i().drawYesNo(true, true);
             break;
       }
       return;
    }
    private void popBagMenu(int selectx,int select_i){
       String ts = "\x8f\x02\x56\x02";
       byte id = this.items[selectx][select_i][0];
       if (selectx && (id != 32 && (id != 33 || !this.isBagUse(id)))) {
          if (selectx == 2) {
             ts = "\x5b\x02\x4e\x02#n\x8f\x02\x56\x02";
          }else if(this.view_state == 2 && selectx == 3){
             ts = "\x5b\x02\x53\x02#n\x8f\x02\x56\x02";
          }
       }else {
          ts = "\x4f\x02\x75\x02#n\x8f\x02\x56\x02";
       }
       this.setStringB(ts, Constants_H.WIDTH, 0);
       this.popMenu = 0;
       return;
    }
    private void popBagState(){
       byte rand;
       int i = 1;
       if (Ms.i().key_Up_Down()) {
          this.popMenu = Ms.i().select(this.popMenu, 0, (this.about_a.length - i));
       }
       if (Ms.i().key_S1_Num5()) {
          byte id = this.items[this.selectx][this.select[0][0]][0];
          if (Ms.i().equals(this.about_a[this.popMenu], "\x4f\x02\x75\x02")) {
             switch (id){
                 case 9:
                 case 11:
                 case 10:
                   if (this.battle_type != 4 && this.battle_type != i) {
                      this.say("\x72\x02\x6b\x02\x60\x02\x51\x02\xff\x02\x65\x02\x6c\x02\x63\x02\x83\x02\xff\x02", i);
                      Ms.i().sleep(400);
                   }else {
                      this.goCatchMonster();
                   }
                   break;
                 case 14:
                 case 15:
                   this.popMenu = -1;
                   if (this.map.notMeet == null) {
                      this.map.notMeet(i, id);
                      this.say("\x4f\x02\x75\x02"+this.getNameItem(id)+","+"\x83\x02\x5f\x02\x4e\x02"+"\x8e\x02\x90\x02\x60\x02\x72\x02\x65\x02\x67\x02", i);
                      this.deleteItems(id, i);
                   }else if(this.map.notMeet == i){
                      this.say("\x5d\x02\x62\x02\x67\x02\x8e\x02\x90\x02\x60\x02\x72\x02\x65\x02\x67\x02", 0);
                   }
                   break;
                 case 32:
                 case 33:
                   int i1 = (id == 32)? 33: 32;
                   if (this.findItem(-2, i1, i) > 0) {
                      this.deleteItems(32, i);
                      this.deleteItems(33, i);
                      byte type = 3;
                      byte d = 1;
                      byte rId = -1;
                      Ms.i();
                      if ((rand = (byte)Ms.getRandom(100)) < 70) {
                         type = 0;
                      }else if(rand < 85){
                         type = 1;
                      }else if(rand < 95){
                         type = 2;
                      }
                      Ms.i();
                      rand = (byte)Ms.getRandom(100);
                      while (d < this.itemMine[type].length) {
                         if (rand < this.itemMine[type][d]) {
                            rId = this.itemMine[type][(d - i)];
                            break ;
                         }
                         i1 = d + 2;
                         d = (byte)i1;
                      }
                      if (rId == 34 && this.findItem(-2, rId, i) > 0) {
                         rId = -1;
                      }else if(rId != -1 && this.findItem(-2, rId, i) < 99){
                         rId = -1;
                      }
                      if (rId != -1) {
                         this.addItem(rId, i);
                         this.say("\x83\x02\x5f\x02\xff\x02"+this.getNameItem(rId)+"x1", 0);
                      }else {
                         this.say("\x8f\x02\x4e\x02\x5b\x02\x7b\x02\x66\x02\x7a\x02\x76\x02\x30\x02", 0);
                      }
                   }else {
                      String str = "\x6c\x02\x67\x02";
                      String str1 = (id == 32)? "\x94\x02\x53\x02\xff\x02\x94\x02\x53\x02\x57\x02\x55\x02\x5e\x02\x4e\x02\x53\x02\x4e\x02\x8d\x02\x4e\x02\x30\x02": "\x5b\x02\x7b\x02\xff\x02\x5b\x02\x7b\x02\x57\x02\x62\x02\x65\x02\x54\x02\x4e\x02\x5b\x02\x51\x02\x73\x02\x83\x02\x5f\x02\x30\x02";
                      this.say(str+str1, 0);
                   }
                   this.popMenu = -1;
                   break;
                 default:
                   this.goVIEW_MONSTER();
                   this.mini_state = 15;
             }
          }else if(Ms.i().equals(this.about_a[this.popMenu], "\x5b\x02\x4e\x02")){
             this.mini_state = 13;
             this.getSkill = (byte)(id - 9);
             this.goVIEW_MONSTER();
          }else if(Ms.i().equals(this.about_a[this.popMenu], "\x5b\x02\x53\x02")){
             if (this.addNidus((id - 58))) {
                this.deleteItems(id, i);
                this.select_it[this.selectx] = this.select[0][0];
                this.select_st[this.selectx] = this.select[0][i];
             }else {
                this.say("\x5b\x02\x53\x02\x62\x02\x5d\x02\x7e\x02\x6c\x02\x67\x02\x7a\x02\x4f\x02\x4e\x02", 0);
             }
             this.popMenu = -1;
          }else {
             this.popMenu = -1;
          }
          Ms.i().correctSelect(this.select[0], this.itemsLength[this.selectx], this.list_rows);
       }else if(Ms.i().key_S2()){
          this.popMenu = -1;
       }
       return;
    }
    private void putMonster(){
       if (this.cMon_count >= this.max_monsters) {
          this.say("\x5b\x02\x72\x02\x7a\x02\x95\x02\x5d\x02\x6e\x02", 0);
       }else if(!this.isMyMonsters(this.select[0][0])){
          this.say("\x8e\x02\x4e\x02\x5f\x02\x98\x02\x64\x02\x5e\x02\x4e\x02\x53\x02\x80\x02\x53\x02\x62\x02\x76\x02\x5b\x02\x72\x02\xff\x02", 0);
       }else {
          this.cMonsters[this.cMon_count] = this.myMonsters[this.select[0][0]];
          this.cMon_count = (byte)(this.cMon_count + 1);
          this.setPutMonster();
       }
       return;
    }
    private void resetFealty(int hp){
       byte fealty = this.initFealty[(this.myMonsters[this.select[0][0]].monster[4] / 4)];
       if (this.myMonsters[this.select[0][0]].monster[6] < fealty && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
          if (hp == -1) {
             this.myMonsters[this.select[0][0]].monster[6] = fealty;
          }else if(((this.myMonsters[this.select[0][0]].monster[6] + hp)) > fealty){
             this.myMonsters[this.select[0][0]].monster[6] = fealty;
          }else {
             Monster monster = this.myMonsters[this.select[0][0]].monster;
             monster[6] = (byte)(monster[6] + hp);
          }
          this.useState(0, this.select_it[0]);
          if (this.view_state == -1) {
             this.getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
          }
       }else if(this.myMonsters[this.select[0][0]].monsterPro[0] > 0){
          this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]))+"\x5f\x02\x8b\x02\x5e\x02\x5d\x02\x6e\x02", 0);
       }
       return;
    }
    private void resetMonster(int hp){
       if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
          this.AddMP(((this.myMonsters[this.select[0][0]].monsterPro[3] * hp) / 100), this.myMonsters[this.select[0][0]]);
          this.AddHP(((this.myMonsters[this.select[0][0]].monsterPro[2] * hp) / 100), this.myMonsters[this.select[0][0]]);
          this.myMonsters[this.select[0][0]].effect = 7;
          this.useState(0, this.select_it[0]);
       }else {
          this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0]))+"\x6c\x02\x67\x02\x6b\x02\x4e\x02\xff\x02", 0);
       }
       return;
    }
    private void restMove(int type,int i){
       this.selectx = this.select[0][1];
       this.selecty = this.select[0][0];
       this.cur_c = (byte)type;
       this.select[0][0] = 0;
       this.select[0][1] = 0;
       this.popMenu = (byte)i;
       this.move_x = 129;
       this.move_y = -14;
    }
    private void runBattleState(){
       int i1;
       int i2;
       int i = 1;
       this.myB.countS[0] = (byte)Ms.i().mathSpeedN(this.myB.countS[0], this.myB.countS[i], i, 0);
       this.enB.countS[0] = (byte)Ms.i().mathSpeedN(this.enB.countS[0], this.enB.countS[i], i, 0);
       switch (this.battle_state){
           case 0xfffffffb:
             if (this.b_c == null && this.cur_c >= this.mon_in_battle[0]) {
                this.goBattleOver();
                this.setNidusExp(this.exp);
             }else {
                byte id = this.mon_in_battle[(this.cur_c + 1)];
                if (this.b_c == null) {
                   if (this.myMonsters[id].monsterPro[0] > 0) {
                      if (!this.myMonsters[id].isMonReel(40)) {
                         Monster monster = this.myMonsters[id].monster;
                         i1 = 6;
                         monster[i1] = (byte)(monster[i1] - i);
                      }
                      this.myB.now_id = id;
                      this.myB.chp = this.myMonsters[id].monsterPro[0];
                      this.myB.cexp = this.myMonsters[id].monsterPro[4];
                      this.initMonStream(2, this.mList_id[this.myMonsters[id].monster[0]][0], i);
                      if (this.level_up(id, 0)) {
                         this.b_c = i;
                      }
                   }else {
                      this.cur_c = (byte)(this.cur_c + 1);
                   }
                }else if(this.b_c == i){
                   this.level_up(id, i);
                   this.b_c = 2;
                }else if(this.b_c == 2 && this.myB.cexp == this.myMonsters[id].monsterPro[4]){
                   if (!this.level_up(id, 2)) {
                      this.b_c = 15;
                   }else {
                      this.b_c = i;
                   }
                }else if(this.b_c > 2){
                   i2 = (this.b_c < 21)? i: 0;
                   i1 = (this.myB.cexp == this.myMonsters[id].monsterPro[4])? i: 0;
                   if ((i2 & i1)) {
                      i2 = (byte)(this.b_c - i);
                      this.b_c = i2;
                      if (i2 == 3) {
                         this.b_c = 0;
                         this.cur_c = (byte)(this.cur_c + 1);
                      }
                   }
                }
                this.myB.cexp = Ms.i().mathSpeedN(this.myB.cexp, this.myMonsters[id].monsterPro[4], 8, 0);
             }
             break;
           case 0xfffffffc:
             if (this.say_c == null) {
                i2 = (byte)(this.cur_b + 1);
                this.cur_b = i2;
                if (i2 >= this.about_a.length) {
                   this.about_a = null;
                   this.goBattleExp(i);
                }else {
                   Log.e("soars", this.about_a[this.cur_b]);
                   this.say(this.about_a[this.cur_b], 0);
                }
             }
             break;
           case 0xfffffffd:
           case 1:
             if (this.bufferAI(this.enB.getMon())) {
                this.aiEnemy();
                if (this.enB.getMon().effect != 6 || this.getSkillLevel(this.enB.skill) <= 3) {
                   this.setAcionSkill(this.enB);
                }
             }else {
                this.enB.act_num = 0;
                this.battle_state = -2;
             }
             break;
           case 9:
             if (this.myB.act_num == null && this.enB.act_num == null) {
                this.myB.act_num = i;
                if (this.enB.act_num = i) {
                   this.myB.act_num = 0;
                   this.say("\x77\x02\x53\x02\x65\x02\x67\x02\x65\x02\x6c\x02\x88\x02\x52\x02\xff\x02\x53\x02\x52\x02\x76\x02\x4f\x02\x5b\x02\x51\x02\x5c\x0230%", -1);
                }else {
                   this.setAimBattle(i);
                   this.goBattleState();
                   String s = "";
                   if (this.myB.getMon().isMonEffect(2)) {
                      s = "\x64\x02\x88\x02\x65\x02\x67\x02\xff\x02\x51\x02\x5c\x02\x5f\x02\x52\x02\x88\x02\x91\x02\x76\x0210%";
                   }else if(this.myB.getMon().isMonEffect(3)){
                      s = "\x9b\x02\x60\x02\x65\x02\x67\x02\xff\x02\x4e\x02\x80\x02\x90\x02\x8d\x02\xff\x02\x58\x02\x52\x02\x63\x02\x83\x02\x5b\x02\x72\x02\x76\x02\x51\x02\x73\x02";
                   }else if(this.myB.getMon().isMonEffect(4)){
                      s = "\x79\x02\x95\x02\x65\x02\x67\x02\xff\x02\x4e\x02\x80\x02\x90\x02\x8d\x02\xff\x02\x4e\x02\x80\x02\x63\x02\x60\x02\xff\x02\x4e\x02\x80\x02\x4f\x02\x75\x02\x90\x02\x51\x02";
                   }else if(this.myB.getMon().isMonEffect(5)){
                      s = "\x81\x02\x86\x02\x65\x02\x67\x02\xff\x02\x6b\x02\x56\x02\x54\x02\x53\x02\x52\x02\x4e\x02\x5b\x02\x4f\x02\x5b\x02";
                   }
                   if (!s.equals("")) {
                      this.say(s, 0);
                   }
                }
             }
             if (this.myB.act_num != null && this.enB.act_num != null) {
                i2 = (this.myB.getMon().monsterPro[5] >= this.enB.getMon().monsterPro[5])? i: 0;
                this.setAimBattle(i2);
             }else if(this.myB.act_num != null){
                i2 = i;
             }else {
                i2 = 0;
             }
             this.setAimBattle(i2);
             if (this.mini_state == i) {
                if ((this.myB.act_num = 0) < 41) {
                   Ms.i();
                   if (Ms.getRandom(100) < 25) {
                      this.say("\x5f\x02\x8b\x02\x5e\x02\x8f\x02\x4f\x02\xff\x02\x5b\x02\x72\x02\x4e\x02\x67\x02\x4e\x02\x4e\x02\x4e\x02\x54\x02\x4e\x02", -1);
                   }
                }
                if (this.myB.getMon().isMonEffect(0)) {
                   this.say("\x77\x02\x53\x02\x65\x02\x67\x02\x65\x02\x6c\x02\x88\x02\x52\x02\xff\x02\x53\x02\x52\x02\x76\x02\x4f\x02\x5b\x02\x51\x02\x5c\x0230%", -1);
                }else {
                   this.setAcionSkill(this.myB);
                }
             }else if(this.say_c == null && !(this.enB.act_num = 0)){
                this.battle_state = i;
             }
             break;
       }
       return;
    }
    private void runHit(){
       boolean b = false;
       if (this.am.b_renascence == null && this.dm.b_renascence == null) {
          this.hit_rate(this.am, this.dm, this.am.getMon(), this.dm.getMon(), this.am.skill);
       }else {
          this.am.b_renascence = b;
          this.dm.b_renascence = b;
       }
       this.battle_state = -2;
       return;
    }
    private boolean runHitToState(Battle amB,Battle dmB,int mState){
       boolean b1;
       byte b = 2;
       int i = 1;
       if (dmB.getMon().monsterPro[0] > 0) {
          b1 = i;
       }else if(dmB.dead == i){
          if (dmB.getMon().isMonReel(38)) {
             Ms.i();
             if (Ms.getRandom(100) < this.skill[38][i]) {
                this.setRelive(amB, dmB);
             }
          }
          if (!mState) {
             if (this.enB.act_num = i) {
                b1 = 0;
             }else if(this.overMode != null){
                if (this.overMode == b) {
                   this.map.sIfElse = i;
                }
                this.overMode = 0;
                this.arangeMonster();
                this.setNullBattle();
                this.goGO_RUNINMAP();
                this.healMonster(0);
                b1 = 0;
             }else if(SMSSender.i(this).sms_a != null){
                System.out.println("aaaaaaaaaaaaa");
                if (this.say_c == null) {
                   this.isKillAll = i;
                   if (!GameRun.isSay) {
                      this.say("\x64\x02\x5e\x02\x76\x02\x5b\x02\x72\x02\x51\x02\x90\x02\x72\x02\x72\x02\x4e\x02!", -1, i);
                   }
                }
             }else {
                System.out.println("bbbbbbbbbb");
                SMSSender.i(this).sms_a = i;
                this.goGameOver();
             }
          }else if(mState == i){
             if (this.changeMon(this.enB, this.enB.mon.length)) {
                this.setEnemyThrow();
                this.enB.act_num = 0;
                GameRun.run_state = -50;
                this.t_battle_state = this.battle_state;
                this.battle_state = 0;
             }else {
                this.goBattleItem();
                if (this.overMode == b) {
                   this.map.sIfElse = 0;
                }
                this.overMode = 0;
             }
          }
       }else if(dmB.action != b){
          dmB.action = b;
          this.now_action[this.mini_state] = 0;
          if (!(this.now_time[this.mini_state] = 0)) {
             Monster monster = dmB.getMon().monster;
             monster[6] = (byte)(monster[6] - 10);
          }
       }
       b1 = 0;
       return b1;
    }
    private void runMonsterAppear(){
       byte coe;
       int i = 2;
       int i1 = -2;
       switch (this.battle_state){
           case 0:
             if (this.myB.throw_state == i && this.myB.throw_state == i) {
                if (this.view_state == i1) {
                   this.setAimBattle(0);
                   this.myB.act_num = 0;
                   this.enB.act_num = 0;
                }
                this.view_state = -1;
                this.goBattleState();
                if (this.t_battle_state != -3 && this.t_battle_state != i1) {
                   this.goSelectAction(this.mini_state);
                }else {
                   this.battle_state = this.t_battle_state;
                   this.t_battle_state = 0;
                   this.getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
                }
                if (this.first_battle == null) {
                   this.first_battle = 1;
                   int i2 = ((coe = (byte)(this.myB.getMon().monster[6] - 99)) > 1)? 20: (coe / 20) * 20;
                   if ((coe = (byte)i2) < 0) {
                      this.say("\x5f\x02\x8b\x02\x5e\x02\x96\x02\x4f\x02\xff\x02\x65\x02\x51\x02\x52\x02\x4e\x02\x96\x02\xff\x02\x8b\x02\x53\x02\x65\x02\x88\x02\x51\x02\xff\x02", 0);
                   }
                }
             }
             break;
       }
       return;
    }
    private void runThrowBall(Battle be,Monster mon,int mini){
       int i = 12;
       if (!this.src_c[(mini + 2)] && (be.throw_state == -1 && this.src_c[mini] == i)) {
          be.throw_state = 0;
       }else if(this.src_c[(mini + 2)] == 1 && !this.src_c[mini]){
          this.src_c[(mini + 2)] = 0;
          this.getBattleBG(be, mon);
       }
       if (be.throw_state == null) {
          be.cThrow[0] = (byte)Ms.i().mathSpeedN(be.cThrow[0], 0, 6, 0);
          if (!(be.cThrow[1] = (byte)Ms.i().mathSpeedUp(be.cThrow[1], 62, 2)) && !be.cThrow[1]) {
             be.throw_state = 1;
          }
       }else if(be.throw_state == 1){
          if (be.cThrow[2] < i) {
             Battle cThrow = be.cThrow;
             cThrow[2] = (short)(cThrow[2] + 1);
          }else {
             be.throw_state = 2;
          }
       }
       return;
    }
    private void sellMonster(Monster mon){
       this.sell_money = (mon.monster[2] * (mon.monster[4] * 5)) + 100;
    }
    private void setAcionSkill(Battle be){
       be.action = 1;
       this.now_action[this.mini_state] = 0;
       this.now_time[this.mini_state] = 0;
       this.battle_state = -1;
       this.setMagic((be.skill / 5));
    }
    private boolean setCartoonFrameMagic_C(int i,int skill_mode,int select,boolean mode){
       int ix;
       GameRun tnow_time_Ma = this.now_time_Magic;
       short s = (short)(tnow_time_Ma[i] + 1);
       tnow_time_Ma[i] = s;
       if (s >= this.magic[skill_mode].action(select, this.now_action_Magic[i], 1)) {
          tnow_time_Ma = this.now_action_Magic;
          tnow_time_Ma[i] = (short)(tnow_time_Ma[i] + 1);
          this.now_time_Magic[i] = 0;
          if (!mode && this.now_action_Magic[i] >= this.magic[skill_mode].aLength(select)) {
             tnow_time_Ma = this.now_action_Magic;
             tnow_time_Ma[i] = (short)(tnow_time_Ma[i] - 1);
             ix = 1;
          label_003f :
             return ix;
          }
       }
       ix = 0;
       goto label_003f ;
    }
    private boolean setCartoonFrame_C(int i,int skill_mode,int select,boolean mode){
       int ix;
       GameRun tnow_time = this.now_time;
       byte b = (byte)(tnow_time[i] + 1);
       tnow_time[i] = b;
       if (b >= this.mon[skill_mode].action(select, this.now_action[i], 1)) {
          tnow_time = this.now_action;
          tnow_time[i] = (byte)(tnow_time[i] + 1);
          this.now_time[i] = 0;
          if (!mode && this.now_action[i] >= this.mon[skill_mode].aLength(select)) {
             tnow_time = this.now_action;
             tnow_time[i] = (byte)(tnow_time[i] - 1);
             ix = 1;
          label_003f :
             return ix;
          }
       }
       ix = 0;
       goto label_003f ;
    }
    private void setEnemyThrow(){
       this.enemyOff = 63;
       this.enB.cThrow[0] = (byte)((Constants_H.WIDTH - 377) + 20);
       this.enB.cThrow[1] = 60;
       this.enB.cThrow[2] = 0;
       this.setThrow(this.enB, this.enB.getMon(), 0);
       this.getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
       this.getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
    }
    private void setEvolveStringB(Monster monster){
       byte eid = (byte)(monster.monster[0] + 1);
       byte level = monster.monster[2];
       boolean b_e = false;
       if (this.monsterMake[monster.monster[0]][0] > 0 && this.findItem(-2, 34, true) > 0) {
          eid = this.monsterMake[monster.monster[0]][0];
          b_e = true;
       }
       this.proReplace = null;
       int[] ointArray = new int[]{true,6};
       this.proReplace = Array.newInstance(Short.TYPE, ointArray);
       this.proReplace[0][0] = (short)(this.getbuffRateV(monster, (this.monster_pro[eid][0] + ((this.monster_pro[eid][7] * level) / 10))) - monster.monsterPro[2]);
       this.proReplace[0][1] = (short)((this.monster_pro[eid][1] + ((this.monster_pro[eid][8] * level) / 10)) - monster.monsterPro[3]);
       object oobject = this.proReplace[0];
       byte b = (b_e)? monster.monster[5]: true;
       oobject[2] = (short)(- b);
       this.proReplace[0][3] = (byte)((this.monster_pro[eid][3] + ((this.monster_pro[eid][10] * level) / 10)) - monster.monsterPro[6]);
       this.proReplace[0][4] = (byte)((this.monster_pro[eid][4] + ((this.monster_pro[eid][11] * level) / 10)) - monster.monsterPro[7]);
       this.proReplace[0][5] = (byte)((this.monster_pro[eid][2] + ((this.monster_pro[eid][9] * level) / 10)) - monster.monsterPro[5]);
       this.setStringB("\x75\x02\x54\x02\xff\x02+"+this.proReplace[0][0]+"#n"+"\x80\x02\x91\x02"+":+"+this.proReplace[0][1]+"#n"+"\x8f\x02\x53\x02"+":"+this.proReplace[0][2], Constants_H.WIDTH, 0);
       this.setStringB("\x52\x02\x91\x02\xff\x02+"+this.proReplace[0][3]+"#n"+"\x96\x02\x5f\x02"+":+"+this.proReplace[0][4]+"#n"+"\x65\x02\x63\x02"+":+"+this.proReplace[0][5], Constants_H.WIDTH, true);
       this.proReplace = null;
       return;
    }
    private void setMyThrow(){
       this.myB.cThrow[0] = -286;
       this.myB.cThrow[1] = 60;
       this.myB.cThrow[2] = 0;
       this.setThrow(this.myB, this.myB.getMon(), 1);
       this.getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
       this.getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
    }
    private void setNidusPro(int i,int level){
       StringBuffer sbuff = "";
       sbuff = sbuff+"\x75\x02\x54\x02\xff\x02"+(this.monster_pro[i][0] + ((this.monster_pro[i][7] * level) / 10))+"#n";
       sbuff = sbuff+"\x80\x02\x91\x02\xff\x02"+(this.monster_pro[i][1] + ((this.monster_pro[i][8] * level) / 10))+"#n";
       sbuff = sbuff+"\x8f\x02\x53\x02\xff\x02"+this.monster_pro[i][12];
       this.setStringB(sbuff, Constants_H.WIDTH, 0);
       sbuff.delete(0, sbuff.length());
       sbuff = sbuff+"\x52\x02\x91\x02\xff\x02"+(this.monster_pro[i][3] + ((this.monster_pro[i][10] * level) / 10))+"#n";
       sbuff = sbuff+"\x96\x02\x5f\x02\xff\x02"+(this.monster_pro[i][4] + ((this.monster_pro[i][11] * level) / 10))+"#n";
       sbuff = sbuff+"\x65\x02\x63\x02\xff\x02"+(this.monster_pro[i][4] + ((this.monster_pro[i][11] * level) / 10));
       this.setStringB(sbuff, Constants_H.WIDTH, 1);
       sbuff = null;
    }
    private void setNullBattle(){
       this.proReplace = null;
       this.effectImage = null;
       this.imgBattle = null;
       this.levelUp_in_battle = null;
       this.myB = null;
       this.enB = null;
    }
    private void setPutMonster(){
       int ix;
       byte i = this.select[0][0];
       while (true) {
          ix = this.myMon_length - 1;
          if (i >= ix) {
             break ;
          }else {
             int ix1 = i + 1;
             this.myMonsters[i] = this.myMonsters[ix1];
             ix1 = i + 1;
             this.evolve[i] = this.evolve[ix1];
             ix = i + 1;
             i = (byte)ix;
          }
       }
       i = this.myMon_length;
       while (i < this.myMonsters.length) {
          this.evolve[i] = 1;
          ix = i + 1;
          i = (byte)ix;
       }
       this.myMon_length = (byte)(this.myMon_length - 1);
       if (this.select[0][0] == this.myMon_length) {
          object oobject = this.select[0];
          oobject[0] = (byte)(oobject[0] - 1);
       }
       this.initMonStream(2, this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0], 1);
       this.setShowPro(this.myMonsters[this.select[0][0]]);
       this.introT = Constants_H.WIDTH_H;
       this.t_length = this.myMon_length;
       this.popMenu = -1;
       Ms.i().correctSelect(this.select[0], this.t_length, this.list_rows);
       return;
    }
    private void setRelive(Battle amB,Battle dmB){
       dmB.initHit();
       dmB.addHit((((- dmB.getMon().monsterPro[2]) * this.skill[38][0]) / 100), 1, 1);
       dmB.skill = 28;
       dmB.dead = 0;
       dmB.action = 0;
       dmB.b_renascence = true;
       dmB.act_num = 0;
       this.battle_state = -1;
       this.setMagic(5);
       this.getHitCoefficient(dmB, dmB.getMon(), amB.getMon());
       this.setAimBattle((this.mini_state ^ 0x01));
    }
    private void setShowPro(Monster monster){
       StringBuffer sbuff = "";
       sbuff = sbuff+String.valueOf(monster.monsterPro[6])+"#n";
       sbuff = sbuff+String.valueOf(monster.monsterPro[7])+"#n";
       sbuff = sbuff+monster.monsterPro[5];
       this.setStringB(sbuff, Constants_H.WIDTH, 2);
       sbuff = null;
    }
    private void setTakenMonster(){
       byte i = this.select[0][0];
       while (true) {
          int ix = this.cMon_count - 1;
          if (i >= ix) {
             break ;
          }else {
             int ix1 = i + 1;
             this.cMonsters[i] = this.cMonsters[ix1];
             ix = i + 1;
             i = (byte)ix;
          }
       }
       this.cMon_count = (byte)(this.cMon_count - 1);
       this.t_length = this.cMon_count;
       if (this.select[0][0] == this.cMon_count) {
          object oobject = this.select[0];
          oobject[0] = (byte)(oobject[0] - 1);
       }
       if (this.t_length > null) {
          this.initMonStream(2, this.mList_id[this.cMonsters[this.select[0][0]].monster[0]][0], 1);
          this.setShowPro(this.cMonsters[this.select[0][0]]);
       }
       this.introT = Constants_H.WIDTH_H;
       this.popMenu = -1;
       Ms.i().correctSelect(this.select[0], this.t_length, this.list_rows);
       return;
    }
    private void setThrow(Battle be,Monster mon,int mini){
       be.throw_state = -1;
       this.initMonStream(2, this.mList_id[mon.monster[0]][0], mini);
       if (mon.isMonReel((mon.monster[3] + 43))) {
          if (be.bg_id != mon.monster[3]) {
             this.src_c[(mini + 2)] = 1;
          }
       }else if(this.monPro.length && be.bg_id != this.monPro[0]){
          this.src_c[(mini + 2)] = 1;
       }
       be.action = 0;
       be.dead = 0;
       be.chp = mon.monsterPro[0];
       return;
    }
    private void takenMonster(){
       if (this.myMon_length < this.max_takes) {
          this.myMonsters[this.myMon_length] = this.cMonsters[this.select[0][0]];
          this.evolve[this.myMon_length] = true;
          this.myMon_length = (byte)(this.myMon_length + 1);
          this.setTakenMonster();
       }else {
          this.say("\x62\x02\x80\x02\x64\x02\x5e\x02\x76\x02\x5b\x02\x72\x02\x5d\x02\x7e\x02\x8f\x02\x52\x02\x4e\x02\x96\x02\xff\x02", true);
       }
       return;
    }
    private void useItem(){
       switch (this.items[0][this.select_it[0]][0]){
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
             break;
           case 9:
           case 11:
           case 10:
           case 12:
             this.resetFealty(30);
             break;
           case 13:
             this.resetFealty(-1);
             break;
       }
       return;
    }
    private void useState(int type,int id){
       GameRun.mc.paint();
       Ms.i().sleep(200);
       if (this.view_state == -1) {
          this.myB.act_num = 0;
          this.goBattleState();
          this.battle_state = 9;
          this.initMonStream(2, this.mList_id[this.myMonsters[0].monster[0]][0], 1);
       }else {
          this.goMY_BAG(type);
       }
       this.deleteItems(this.items[type][id][0], 1);
       return;
    }
    public synchronized void Success(){
       SMSSender sMSSender = SMSSender.i(this);
       int i = 4;
       try{
          sMSSender.setSendSms(i);
          SMSSender.i(this);
          if (SMSSender.smsType == 6) {
             SMSSender.i(this).sendSuccess();
             SMSSender.i(this).setSendSms(-1);
             GameRun.run_state = -10;
             GameRun.mc.temp_state = GameRun.run_state;
             GameRun.mc.setSmsIsSetRun_state(true);
             this.map.setRegState(true);
          }else {
             SMSSender.i(this).sendSuccess();
          }
       }catch(java.lang.Exception e1){
          Exception e = e1;
          e.printStackTrace();
       }
       return;
    }
    public byte addItem(int item_id,int count){
       byte item_no;
       byte b1;
       byte item_type = this.findItemType(item_id);
       if ((item_no = this.findItem(item_type, item_id, false)) != -1) {
          object oobject = this.items[item_type][item_no];
          byte b = (byte)(oobject[1] + count);
          oobject[1] = b;
          if (b > 99) {
             this.items[item_type][item_no][1] = 99;
             this.say(String.valueOf(this.getNameItem(this.items[item_type][item_no][0]))+"\x65\x02\x91\x02\x5d\x02\x52\x02\x4e\x02\x96\x02", false);
             b1 = -1;
          label_0048 :
             return b1;
          }
       }else {
          this.items[item_type][this.itemsLength[item_type]][0] = (byte)item_id;
          this.items[item_type][this.itemsLength[item_type]][1] = (byte)count;
          GameRun titemsLength = this.itemsLength;
          titemsLength[item_type] = (byte)(titemsLength[item_type] + 1);
       }
       b1 = 1;
       goto label_0048 ;
    }
    public void addMonInfoListBH(){
       GameRun tmonInfoList = this.monInfoList;
       tmonInfoList[104] = (byte)(tmonInfoList[104] + 1);
       tmonInfoList = this.monInfoList;
       if ((tmonInfoList[103] = (byte)(tmonInfoList[103] + 1)) == 102) {
          this.say("\x60\x02\x55\x02\x60\x02\x62\x02\x62\x02\x67\x02\x76\x02\x5b\x02\x72\x02\x90\x02\x65\x02\x96\x02\x9f\x02\x4e\x02", 0);
          GameRun.mc.paint();
          Ms.i().sleep(600);
       }
       return;
    }
    public void battleType(int mode){
       this.battle_type = (byte)mode;
    }
    public boolean checkMonster(){
       int b;
       byte i = 0;
       while (true) {
          if (i >= this.myMon_length) {
             this.say("\x60\x02\x76\x02\x5b\x02\x72\x02\x4e\x02\x97\x02\x89\x02\x56\x02\x59\x02\xff\x02", 0);
             b = true;
             break ;
          }else if(this.myMonsters[i].monsterPro[1] >= this.myMonsters[i].monsterPro[3] && this.myMonsters[i].monsterPro[0] >= this.myMonsters[i].monsterPro[2]){
             b = i + 1;
             i = (byte)b;
          }else {
             b = 0;
             break ;
          }
       }
       return b;
    }
    public void data_init(){
       byte[] data = Ms.i().getStream("data/data.d", -1);
       Ms.i();
       Ms.skip = 0;
       this.skill_up = Ms.i().create2Array(data);
       this.monster_pro = Ms.i().create2Array(data);
       this.skill = Ms.i().create2Array(data);
       this.skill_help = Ms.i().createStringArray(data);
       this.skill_name = Ms.i().createStringArray(data);
       this.monsterT = Ms.i().createStringArray(data);
       this.NAME = Ms.i().createStringArray(data);
       this.item_help = Ms.i().createStringArray(data);
       this.item_name = Ms.i().createStringArray(data);
       this.city_name = Ms.i().createStringArray(data);
       this.buff_name = Ms.i().createStringArray(data);
       this.buff_help = Ms.i().createStringArray(data);
       this.monAppearMap = Ms.i().create2Array(data);
       this.mList_id = Ms.i().create2Array(data);
       this.monsterMake = Ms.i().create2Array(data);
       this.monsterInfo = Ms.i().createStringArray(data);
       this.inhesion = Ms.i().createArray(data);
       this.makeLevel = Ms.i().createArray(data);
       this.musicNo = Ms.i().createArray(data);
       this.npc2ImageType = Ms.i().createArray(data);
       this.map.boatCourse = Ms.i().create2Array(data);
       this.nidusList = Ms.i().create2Array(data);
       data = null;
    }
    public byte delMonster(int no){
       byte b;
       int i = -1;
       byte id = this.myMonsters[no].monster[0];
       if (this.monsterRemove(no) != i) {
          this.say("\x59\x02\x53\x02\x5b\x02\x72\x02\xff\x02"+this.getNameMon(id), 0);
          b = 1;
       }else {
          this.say("\x8e\x02\x4e\x02\x5f\x02\x98\x02\x64\x02\x5e\x02\x4e\x02\x53\x02\x80\x02\x53\x02\x62\x02\x76\x02\x5b\x02\x72\x02\xff\x02", 0);
          b = i;
       }
       return b;
    }
    public void deleteItems(int item_id,int count){
       byte item_no;
       byte item_type = this.findItemType(item_id);
       if ((item_no = this.findItem(item_type, item_id, false)) != -1) {
          if (this.items[item_type][item_no][1] >= count) {
             object oobject = this.items[item_type][item_no];
             oobject[1] = (byte)(oobject[1] - count);
          }
          if (!this.items[item_type][item_no][1]) {
             this.dItemIn(item_type, item_no);
          }
       }
       return;
    }
    public void doPaint(int mode){
       if (mode) {
          this.b_c = (byte)mode;
       }else {
          GameRun.run_state = -10;
       }
       GameRun.mc.paint();
       return;
    }
    public void doSayOverSms(){
       int temp = this.sayOverSms;
       System.out.println("doSayOverSms\(\) sayOverSms= "+this.sayOverSms);
       this.sayOverSms = -1;
       if (temp == null) {
          GameRun.isSay = true;
          SMSSender.i(this).go(4, true);
          GameRun.isSay = false;
       }else if(temp == true){
          SMSSender.i(this).go(3, true);
       }
       return;
    }
    public boolean drawCartoonOne(int i,int skill_mode,int select,int x,int y,boolean mode,int dir){
       byte b = 0;
       if (this.now_action[i] >= this.mon[skill_mode].aLength(select)) {
          this.now_action[i] = b;
       }
       Ui.i().drawFrameOne(this.mon[skill_mode], this.mon[skill_mode].action(select, this.now_action[i], b), x, y, dir);
       return this.setCartoonFrame_C(i, skill_mode, select, mode);
    }
    public void drawChangeMap(boolean bb,int t_c,int x,int y,int w){
       int WIDTH = 640;
       int HEIGHT = 360;
       t_c = t_c * 2;
       if (bb) {
          Ui.i().fillRect(0x52bdef, 0, 0, WIDTH, HEIGHT);
       }
       GameRun.g.setColor(0);
       GameRun.g.fillRect(x, (y + 1), w, 5);
       GameRun.g.fillRect((x + 1), y, (w - 2), 7);
       GameRun.g.setColor(0xeafcff);
       if ((((w - 4) * t_c) / 60) > w) {
          GameRun.g.fillRect((x + 2), (y + 1), w, 5);
          GameRun.g.fillRect((x + 1), (y + 2), w, 3);
       }else {
          WIDTH = 5;
          GameRun.g.fillRect((x + 2), (y + 1), (((w - 4) * t_c) / 60), WIDTH);
          GameRun.g.fillRect((x + 1), (y + 2), (((w - 2) * t_c) / 60), 3);
       }
       if (bb && Map.npcSp[1][0].img != null) {
          if ((((w - 4) * t_c) / 60) > w) {
             this.map.drawMyAni(this.map.my, 0, w, (y + 10), 5);
          }else {
             this.map.drawMyAni(this.map.my, 0, (x + (((w - 4) * t_c) / 60)), (y + 10), 5);
          }
       }
       return;
    }
    public void drawCityName(){
       GameRun tcityName_c;
       int i = 0;
       int FONT_H = 25;
       int WIDTH_H = Constants_H.WIDTH__ / 2;
       if (this.cityName_c != -20) {
          short w = (short)(Ms.i().getStringWidth(this.city_name[this.map.mapNo]) + 8);
          Ui ui = Ui.i();
          int i1 = WIDTH_H - (w >> 1);
          int i2 = (this.cityName_c > null)? i: this.cityName_c;
          ui.drawKuang(i1, i2, w, (FONT_H + 6));
          ui = Ui.i();
          String str = this.city_name[this.map.mapNo];
          i2 = (this.cityName_c > null)? i: this.cityName_c;
          ui.drawString(str, WIDTH_H, i2, 17, 4, 2);
          this.cityName_c = (byte)(this.cityName_c - 1);
       }
       return;
    }
    public void drawEvolveUI(int mode,int id,boolean bb){
       short magicType1;
       Ui ui;
       byte i2;
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       Ui.i().fillRectB();
       short lx = 200;
       short ly = 108;
       short magicType = 0;
       this.drawBG0(this.bg_c, lx, ly, 5, 230);
       if (mode == 1 && this.b_c > null) {
          magicType1 = 5;
          if (this.b_c == 1) {
             int i = (magicType1 == 5)? 6: 1;
             if (this.drawMagicC(magicType1, magicType1, i, 377, 97, 0)) {
                this.initMonStream(2, this.mList_id[this.myMonsters[id].monster[0]][0], 1);
                this.b_c = 2;
             }
          }
          if (this.b_c > 1 && this.b_c < 14) {
             this.drawClipPic(this.mList_id[this.myMonsters[id].monster[0]][1], 1, 377, 97, 80, 77, 15, (this.b_c - 2), 0);
             i2 = (byte)(this.b_c + 1);
             this.b_c = i2;
             if (i2 == 14) {
                this.b_c = -1;
                this.say("\x8f\x02\x53\x02\x62\x02  "+this.getNameMon(this.myMonsters[id].monster[0]), 0);
             }
          }
       }else {
          this.drawCartoonOne(1, 1, (this.mList_id[this.myMonsters[id].monster[0]][1] * 3), (377 - this.move_x), (97 - this.move_y), true, 0);
          magicType1 = magicType;
       }
       if (mode == 1 && this.popMenu == 1) {
          magicType1 = 28;
          this.drawEvolveMake(this.myMonsters[id].monster[0], (lx + 25), ((ly + 25) + 22), magicType1);
       }else {
          Ui.i().drawStringY(this.about_b, ((lx + 25) - 16), ((ly + 25) + 22), 0, 3, 40, 3, 0);
          Ui.i().drawStringY(this.about_a, ((lx + 125) - 3), ((ly + 25) + 22), 0, 3, 40, 3, 0);
       }
       if (!mode) {
          this.move_y = 0;
          this.move_x = 0;
          Ui.i().drawString(String.valueOf(this.getNameMon(this.myMonsters[id].monster[0]))+"\x53\x02\x52\x02\x4e\x02"+this.myMonsters[id].monster[2]+"\x7e\x02", 432, (ly + 4), (8 | 0x10), 1, 0);
          lx = lx - this.say_s;
          ly = ly - 4;
          Ui.i().drawImage(this.imgItem[1], lx, ly, 36);
          GameRun gameRun = this.levelUp_in_battle;
          int i1 = (bb)? id: this.myMonsters[id].monster[1];
          if (gameRun[i1][1] != -1) {
             ui = Ui.i();
             String gameRun1 = "\x4e\x02\x5f\x02\x62\x02\x80\x02\xff\x02";
             GameRun gameRun2 = this.levelUp_in_battle;
             lx = (bb)? id: this.myMonsters[id].monster[1];
             ui.drawString(gameRun1+this.getNameSkill(gameRun2[lx][1]), WIDTH_H, (HEIGHT - 60), 17, 9, 0);
          }
       }else if(mode == 1){
          ui = Ui.i();
          i2 = (this.popMenu == null)? -127: 15;
          ui.drawK1((WIDTH_H + i2), (ly + 6), 113, 27, 4);
          ui = Ui.i();
          String str = "\x57\x02\x67\x02\x5c\x02\x60\x02";
          int i3 = (WIDTH_H - 75) + 4;
          int i4 = ly + 5;
          int i5 = 17;
          int i6 = (this.popMenu == null)? 0: 1;
          ui.drawString(str, i3, i4, i5, i6, 0);
          ui = Ui.i();
          str = "\x8f\x02\x53\x02\x7d\x02\x67\x02";
          i3 = (WIDTH_H + 75) - 4;
          i4 = ly + 5;
          i5 = 17;
          i6 = (this.popMenu == null)? 1: 0;
          ui.drawString(str, i3, i4, i5, i6, 0);
          byte t = this.pkey.selectMenuX(2, 0, (ly + 5), WIDTH_H, 33);
          if (t != -1) {
             this.popMenu = t;
          }
          Ui.i().drawTriangle(WIDTH_H, (ly + 15), 150, true, true);
          lx = 3;
          ly = 0;
          this.move_x = Ms.i().mathSpeedDown(this.move_x, lx, ly);
          this.move_y = Ms.i().mathSpeedDown(this.move_y, 3, false);
          Ui.i().drawString("\x78\x02\x5b\x02\x8f\x02\x53\x02\x8b\x02\x5b\x02\x72\x02\xff\x02", WIDTH_H, ((HEIGHT - 25) - 22), 17, 0, 1);
       }
       Ui.i().drawYesNo(true, true);
       return;
    }
    public void drawFealty(int length,int n,int x,int y){
       byte i = 0;
       while (i < length) {
          Ui ui = Ui.i();
          int ix = (i > n)? 22: 21;
          int ix1 = i * 14;
          ix1 = ix1 + x;
          ui.drawUi(ix, ix1, y, 0, 0);
          int ix2 = i + 1;
          i = (byte)ix2;
       }
       return;
    }
    public void drawItem(int action,int x,int y,int anchor){
       int i = 58;
       int i1 = 35;
       if (action >= i) {
          action = this.monster_pro[this.nidusList[0][(action - i)]][6] + 40;
       }else if(action >= i1){
          action = this.makeLevel[(action - i1)] + 34;
       }
       Ui.i().drawRegion(this.item_img, this.item_modules[action][0], this.item_modules[action][1], this.item_modules[action][2], this.item_modules[action][3], x, y, anchor, 0, GameRun.g);
       return;
    }
    public boolean drawMagicC(int i,int skill_mode,int select,int x,int y,int dir){
       boolean b1;
       byte b = 2;
       short s = 0;
       if (this.now_action_Magic[i] >= this.magic[skill_mode].aLength(select)) {
          this.now_action_Magic[i] = s;
          b1 = true;
       }else {
          short frame_id = (short)this.magic[skill_mode].action(select, this.now_action_Magic[i], s);
          while (true) {
             if (this.dm != null && frame_id < b) {
                if (!frame_id) {
                   this.dm.ceff[s] = b;
                }
                this.now_time_Magic[i] = s;
                GameRun tnow_action_ = this.now_action_Magic;
                short ix = tnow_action_[i] + 1;
                ix = (short)ix;
                tnow_action_[i] = ix;
                if (ix >= this.magic[skill_mode].aLength(select)) {
                   this.now_action_Magic[i] = s;
                   b1 = true;
                   break ;
                }else {
                   frame_id = (short)this.magic[skill_mode].action(select, this.now_action_Magic[i], s);
                }
             }else {
                Ui.i().drawFrameOne(this.magic[skill_mode], frame_id, x, y, dir);
                b1 = this.setCartoonFrameMagic_C(i, skill_mode, select, true);
                break ;
             }
          }
       }
       return b1;
    }
    public void drawMoney(int x,int y,int c,boolean bb){
       GameRun tcoin = (bb)? this.coin: this.money;
       String str = String.valueOf(tcoin);
       String str1 = (bb)? "\x5f\x02\x7a\x02": "\x91\x02";
       String s = str+str1;
       Ui ui = Ui.i();
       int i = (bb)? 53: 52;
       ui.drawUi(i, ((x - (Ms.i().getStringWidth(s) >> 1)) - 1), y, (8 | 0x20), 0);
       Ui.i().drawString(s, x, (y + 3), (1 | 0x20), c, 1);
       s = null;
       return;
    }
    public void drawMyMon(){
       int i = 1;
       this.drawEffectImage(this.myB.getMon(), 220, 164);
       int i1 = (this.mList_id[this.myB.getMon().monster[0]][i] * 3) + this.myB.action;
       int i2 = (this.myB.ceff[0])? -3: 0;
       short i3 = i2 + 266;
       i2 = (this.myB.ceff[0])? 3: 0;
       int i4 = i2 + 236;
       int i5 = (this.myB.action == null)? i: 0;
       if (this.drawCartoonOne(i, i, i1, i3, i4, i5, i)) {
          if (this.myB.getMon().monsterPro[0] < i) {
             this.myB.action = 2;
             this.myB.dead = i;
          }else {
             this.myB.action = 0;
          }
       }
       this.myB.ceff[0] = (byte)Ms.i().mathSpeedN(this.myB.ceff[0], 0, i, i);
       this.drawMonsterHp(this.myB.getMon(), 241, 237, 50, 0, i, this.myB.chp);
       this.drawMonsterHp(this.myB.getMon(), 241, 242, 50, i, 2, this.myB.getMon().monsterPro[i]);
       GameRun tmyB = this.myB;
       Ms ms = Ms.i();
       Battle chp = this.myB.chp;
       i3 = this.myB.getMon().monsterPro[0];
       i4 = (this.myB.chp < this.myB.getMon().monsterPro[0])? 20: 6;
       tmyB.chp = ms.mathSpeedN(chp, i3, i4, i);
       return;
    }
    public void drawPauseIco(int state){
       byte i = 0;
       while (i < this.b_ico) {
          Ui.i().drawImage(this.imgIco[i], this.pkey.button_pos[6][i][0], this.pkey.button_pos[6][i][1], 0);
          int ix = i + 1;
          i = (byte)ix;
       }
       return;
    }
    public void exitNidus(){
       GameRun.run_state = -10;
       this.mon[1] = null;
       this.initNidusMap(1);
    }
    public void falselly(int id){
       try{
          SMSSender.i(this).setSendSms(-1);
          if (id == 7) {
             SMSSender.i(this).sms_a = true;
             this.goGameOver();
             System.out.println("ccccccccc");
             GameRun.mc.setSmsIsSetRun_state(true);
          }else if(id == 5){
             GameRun.run_state = SMSSender.i(this).getTstate();
             GameRun.mc.temp_state = GameRun.run_state;
             GameRun.mc.setSmsIsSetRun_state(true);
          }else if(id == 6){
             GameRun.run_state = -10;
             GameRun.mc.temp_state = GameRun.run_state;
             GameRun.mc.setSmsIsSetRun_state(true);
             System.out.println("  \x62\x02\x76\x02mc.setSmsIsSetRun_state\(true\);");
             this.map.setRegState(false);
          }else if(id == 1 && SMSSender.i(this).getSmsSenderMenuState()){
             Log.d("soars", "soooooooooooooooooooooooooooooooooooooooo");
             GameRun.mc.setSmsIsSetRun_state(true);
             GameRun.run_state = SMSSender.i(this).getTstate();
          }
       }catch(java.lang.Exception e1){
          Exception e = e1;
          e.printStackTrace();
       }
       return;
    }
    public byte findItem(int item_type,int item_id,boolean bb){
       int ix1;
       int ix = 0;
       byte i = 0;
       if (item_type == -2) {
          item_type = this.findItemType(item_id);
       }
       while (true) {
          if (i >= this.itemsLength[item_type]) {
             ix1 = (bb)? ix: -1;
             ix1 = (byte)ix1;
             break ;
          }else if(this.items[item_type][i][ix] == item_id){
             if (bb) {
                ix1 = this.items[item_type][i][1];
                break ;
             }else {
                ix1 = i;
                break ;
             }
          }else {
             ix1 = i + 1;
             i = (byte)ix1;
          }
       }
       return ix1;
    }
    public byte findItemType(int item_id){
       byte b;
       if (item_id < 16) {
          b = 0;
       }else if(item_id < 35){
          b = 1;
       }else if(item_id < 58){
          b = 2;
       }else {
          b = 3;
       }
       return b;
    }
    public byte findMonster(int id,int lv){
       int b;
       byte i = 0;
       while (true) {
          if (i >= this.myMon_length) {
             b = -1;
             break ;
          }else if(this.myMonsters[i].monster[0] == id && this.myMonsters[i].monster[2] >= lv){
             b = i;
             break ;
          }else {
             b = i + 1;
             i = (byte)b;
          }
       }
       return b;
    }
    public byte findMonsterMinLv(int id,int lv){
       byte minLv = -1;
       byte i = (byte)(this.myMon_length - 1);
       while (i > -1) {
          if (this.myMonsters[i].monster[0] == id && (this.myMonsters[i].monster[2] >= lv && (minLv == -1 && this.myMonsters[i].monster[2] >= this.myMonsters[minLv].monster[2]))) {
             minLv = i;
          }
          int ix = i - 1;
          i = (byte)ix;
       }
       return minLv;
    }
    public boolean gameCheckRegIsOK(){
       boolean reged = (this.rmsSms[6] == 10)? true: false;
       System.out.println("gameCheckRegIsOK reged= "+reged);
       return reged;
    }
    public void getEnemy(byte[] enemy_list,int type,int level){
       if (type == -1) {
          Ms.i();
          if (Ms.getRandom(100) < 5 && this.monPro.length > 6) {
             type = 6;
          }else {
             GameRun tmonPro = this.monPro;
             Ms.i();
             int i = (this.monPro.length > 6)? 3: this.monPro.length - 3;
             type = tmonPro[(Ms.getRandom(i) + 3)];
          }
          Ms.i();
          enemy_list[1] = (byte)(Ms.getRandom((this.monPro[2] + 1)) + this.monPro[1]);
       }else {
          enemy_list[1] = (byte)level;
       }
       enemy_list[0] = (byte)type;
       return;
    }
    public byte getItem(int item_id,int count){
       byte b;
       if (this.addItem(item_id, count) == 1) {
          this.say("\x83\x02\x5f\x02\xff\x02\x20\x02"+this.getNameItem((byte)item_id)+"”x"+count, 0);
          b = 1;
       }else {
          b = -1;
       }
       return b;
    }
    public byte getItemCount(int id){
       byte b;
       if (this.buyItemID != 2) {
          this.findItemType(id);
          int i = 0;
          while (true) {
             if (i < this.items[this.item_type].length) {
                if (this.items[this.item_type][i][0] == id) {
                   b = this.items[this.item_type][i][1];
                   break ;
                }else {
                   i++;
                }
             }
          }
          return b;
       }
       b = 0;
    }
    public void getMagic(Monster monster){
       byte[] uobyteArray = new byte[6];
       uobyteArray[1] = 7;
       uobyteArray[2] = 14;
       uobyteArray[3] = 21;
       uobyteArray[4] = 28;
       uobyteArray[5] = 35;
       this.getSkill = -1;
       byte i = 0;
       while (i < uobyteArray.length) {
          int ix = i + 8;
          if (monster.monster[ix] == -1 && monster.monster[2] >= uobyteArray[i]) {
             this.getSkill(i, monster.monster[3]);
             ix = i + 8;
             monster.monster[ix] = this.getSkill;
          }
          int ix1 = i + 1;
          i = (byte)ix1;
       }
       return;
    }
    public byte getMonster(int id,int level,int evolve,int buff){
       byte b;
       Monster enemyMB = new Monster(this, id, level, buff);
       if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
          this.say("\x5b\x02\x72\x02\x7a\x02\x95\x02\x5d\x02\x6e\x02", 0);
          b = -1;
       }else if(this.getMonster(enemyMB, evolve, true) != true){
          this.say("\x83\x02\x5f\x02\x5b\x02\x72\x02\xff\x02"+this.getNameMon((byte)id), 0);
       }else {
          this.say("\x64\x02\x5e\x02\x5d\x02\x6e\x02\xff\x02"+this.getNameMon(enemyMB.monster[0])+"\x5d\x02\x8f\x02\x51\x02\x5b\x02\x65\x02\x59\x02", 0);
       }
       enemyMB = null;
       b = true;
       return b;
    }
    public String getNameCity(int id){
       return this.city_name[id];
    }
    public String getNameItem(int item_id){
       return this.item_name[item_id];
    }
    public String getNameMon(int mon_id){
       return this.NAME[mon_id];
    }
    public String getNameMonsterInfo(int id){
       return this.monsterInfo[id];
    }
    public void goBUY_ITEM(int id,int mode){
       String[] stringArray;
       int i = 3;
       if (mode != 1) {
          stringArray = new String[i];
          stringArray[0] = "\x90\x02\x51\x02";
          stringArray[1] = "\x77\x02\x77\x02";
          stringArray[2] = "\x5f\x02\x7a\x02";
          this.setAction_str(stringArray);
       }else {
          stringArray = new String[i];
          stringArray[0] = "\x90\x02\x51\x02";
          stringArray[1] = "\x8f\x02\x52\x02";
          stringArray[2] = "\x53\x02\x8f\x02";
          this.setAction_str(stringArray);
       }
       this.cur_a = (byte)id;
       this.cur_b = (byte)mode;
       this.select[0][0] = 0;
       this.select[0][1] = 0;
       GameRun.run_state = 18;
       this.list_rows = 6;
       this.buyOk = 0;
       this.popMenu = -1;
       byte[] data = Ms.i().getStream("data/shop.d", -1);
       Ms.i();
       Ms.skip = 0;
       this.buyItem = Ms.i().create2Array(data);
       this.buyPrice = Ms.i().createShort2Array(data, 0);
       data = null;
       return;
    }
    public void goBattle(){
       int ix;
       byte[] uobyteArray = null;
       this.first_battle = 0;
       this.lastSkill = 0;
       this.b_c = 0;
       this.cur_a = 0;
       this.mon_in_battle = uobyteArray;
       byte[] uobyteArray1 = new byte[(this.max_takes + 1)];
       this.mon_in_battle = uobyteArray1;
       this.levelUp_in_battle = uobyteArray;
       int[] ointArray = new int[]{this.max_takes,2};
       this.levelUp_in_battle = Array.newInstance(Byte.TYPE, ointArray);
       this.proReplace = uobyteArray;
       ointArray = new int[]{this.myMonsters.length,7};
       this.proReplace = Array.newInstance(Short.TYPE, ointArray);
       this.myB = new Battle(this.myMonsters);
       this.enemy_init();
       byte i = 0;
       while (i < this.myMon_length) {
          this.myMonsters[i].effect = 7;
          this.myMonsters[i].effect_time = 0;
          this.myMonsters[i].monster[1] = i;
          this.proReplace[i][6] = this.myMonsters[i].monster[2];
          ix = i + 1;
          i = (byte)ix;
       }
       i = 0;
       while (i < this.myMon_length) {
          if (this.myMonsters[i].monsterPro[0] > 0) {
             GameRun tmon_in_batt = this.mon_in_battle;
             byte b = (byte)(tmon_in_batt[0] + 1);
             tmon_in_batt[0] = b;
             this.mon_in_battle[b] = this.myMonsters[i].monster[1];
             if (i) {
                this.changeMonster(this.myMonsters[i], this.myMonsters[0]);
                break ;
             }else if(this.effectImage == null){
                this.effectImage = Ms.i().createImageArray(7, "data/brow/e");
             }
             if (this.imgBattle == null) {
                this.imgBattle = Ms.i().createImageArray(5, "data/battle/b");
             }
             this.map.my.state = 15;
             GameRun.run_state = -30;
             this.view_state = -1;
             CreateThread ointArray1 = new CreateThread(this, 1);
             return;
          }else {
             ix = i + 1;
             i = (byte)ix;
          }
       }
    }
    public void goBattlePVC(){
       this.enemyList = null;
       int[] ointArray = new int[]{1,2};
       this.enemyList = Array.newInstance(Byte.TYPE, ointArray);
       this.getEnemy(this.enemyList[0], -1, 0);
       Sound.i().setMusicId(6);
       Sound.i().setMusic(1);
       this.goBattle();
    }
    public void goGameOver(){
       GameRun.run_state = 60;
    }
    public void goMAIN_MENU(){
       GameRun.mc.logo_c = 29;
       GameRun.mc.image_logo = null;
       this.setNull(true);
       this.myMonsters = null;
       this.cMonsters = null;
       System.gc();
       GameRun.mc.createFlashImage();
       GameRun.mc.goMain_menu();
       String[] stringArray = new String[]{"\x8b\x02\x53\x02\x8f\x02\x5e\x02","\x65\x02\x6e\x02\x62\x02","\x58\x02\x97\x02","\x6e\x02\x62\x02\x5e\x02\x52\x02","\x51\x02   \x4e\x02","\x90\x02\x51\x02\x6e\x02\x62\x02"};
       this.setAction_str(stringArray);
       byte b = (this.rmsOther[0] == -1)? true: 0;
       b = (byte)b;
       this.selecty = b;
       this.selectx = b;
       return;
    }
    public void goNidus(int pop){
       GameRun.run_state = 66;
       this.mini_state = 16;
       this.setStringB("\x67\x02\x77\x02\x5b\x02\x53\x02#n\x90\x02\x62\x02\x86\x02#n\x79\x02\x5f\x02", Constants_H.WIDTH, 3);
       this.popMenu = (byte)pop;
       this.b_c = -2;
    }
    public void goVIEW_COMPUTER(int pop){
       GameRun.run_state = 65;
       this.setStringB("\x5b\x02\x65\x02#n\x53\x02\x51\x02#n\x79\x02\x5f\x02", Constants_H.WIDTH, 3);
       this.popMenu = (byte)pop;
    }
    public void goVIEW_MONSTER(){
       int i = 6;
       GameRun.run_state = 35;
       this.cur_c = 0;
       this.selecty = 0;
       this.selectx = 0;
       GameRun tcMon_count = (this.mini_state == i)? this.cMon_count: this.myMon_length;
       this.t_length = tcMon_count;
       this.select[0][1] = 0;
       this.select[0][0] = 0;
       this.popMenu = -1;
       this.list_rows = 5;
       this.mon_action = 0;
       this.setStringB("\x75\x02\x54\x02#n\x80\x02\x91\x02#n\x68\x02\x6b\x02", Constants_H.WIDTH, 0);
       this.setStringB("\x52\x02\x91\x02#n\x96\x02\x5f\x02#n\x65\x02\x63\x02", Constants_H.WIDTH, 1);
       object oobject = (this.mini_state == i)? this.cMonsters[this.select[0][0]]: this.myMonsters[this.select[0][0]];
       this.cur_mon = oobject;
       if (this.t_length != null) {
          this.setShowPro(this.cur_mon);
          this.initMonStream(2, this.mList_id[this.cur_mon.monster[0]][0], 1);
       }
       return;
    }
    public void goYouPAUSE(int sy){
       GameRun.run_state = 97;
       this.selectx = 0;
       this.selecty = (byte)sy;
       this.setPauseS(0);
       Sound.i().soundStop();
       this.say_c = 0;
       this.view_state = 1;
       this.mini_state = 3;
       this.buyItemID = 0;
       this.buyOk = 0;
       this.gogoString = "\x91\x02\x5c\x02\x51\x02\x91\x02\x51\x02\xff\x02\x91\x02\x51\x02\x51\x02\x69\x02\x72\x02\xff\x02\x69\x02\x72\x02\x51\x02\x98\x02\x88\x02\xff\x02\x98\x02\x88\x02\x51\x02\x6d\x02\x6d\x02\xff\x02\x6d\x02\x6d\x02\x51\x02\x91\x02\x5c\x02";
    }
    void healMonster(Monster monster){
       monster.effect = 7;
       monster.monsterPro[1] = monster.monsterPro[3];
       monster.monsterPro[0] = monster.monsterPro[2];
    }
    public void healMonster(boolean bb){
       byte i = 0;
       while (i < this.myMon_length) {
          this.healMonster(this.myMonsters[i]);
          int ix = i + 1;
          i = (byte)ix;
       }
       if (bb) {
          this.say("\x60\x02\x64\x02\x5e\x02\x76\x02\x5b\x02\x72\x02\x5d\x02\x56\x02\x59\x02\x30\x02", 0);
       }
       return;
    }
    public void initBattle(){
       System.gc();
       this.src_c[3] = 0;
       this.src_c[2] = 0;
       this.src_c[1] = 0;
       this.src_c[0] = 0;
       this.getBattleBG(this.enB, this.enB.getMon());
       this.getBattleBG(this.myB, this.myB.getMon());
       this.setEnemyThrow();
       this.setMyThrow();
    }
    public void initImgIco(){
       if (this.imgIco == null) {
          this.imgIco = Ms.i().createImageArray_(7, "data/brow/i", 1);
       }
       return;
    }
    public void initItemModules(){
       this.item_img = Ms.i().createImage("data/item");
       Ms.i();
       Ms.skip = 0;
       this.item_modules = Ms.i().create2Array(Ms.i().getStream("data/item_m.d", -1));
    }
    public void initMonPro(int no,boolean mode){
       byte[] data;
       Ms.i();
       Ms.skip = 0;
       Ms ms = Ms.i();
       String str = "data/map/";
       String str1 = (mode)? "m": "boss";
       data = ms.getStream(str+str1+no+".d", -1);
       this.monPro = Ms.i().createArray(data);
       this.mapMove = Ms.i().createArray(data);
       this.mapRect = Ms.i().create2Array(data);
       return;
    }
    public void initMonStream(int type,int id,int i){
       String name = "data/npc"+type+"/"+id;
       boolean bb = true;
       if (type == 2) {
          bb = this.isNpc2ImageType(id);
       }
       if (this.mon[i] == null) {
          this.mon[i] = Ms.i().createSprite(name, bb);
       }else {
          Ms.i().setSprite(this.mon[i], name, bb);
       }
       return;
    }
    public void initNidusMap(int mode){
       int ix;
       if (this.nidusMap == null) {
          byte[] uobyteArray = new byte[5];
          this.nidusMap = uobyteArray;
       }
       byte i = 0;
       if (!mode) {
          while (i < this.nidusMap.length) {
             this.nidusMap[i] = -1;
             ix = i + 1;
             i = (byte)ix;
          }
       }else {
          while (i < this.nidusMap.length) {
             if (this.nidusMap[i] != -1) {
                if (this.getRid(i) != -2) {
                   this.map.npc[0][this.nidusMap[i]].other[4] = 1;
                   int ix1 = this.monster_pro[this.getNid(i)][6] + 17;
                   this.map.npc[0][this.nidusMap[i]].other[7] = (byte)ix1;
                }else {
                   this.map.npc[0][this.nidusMap[i]].other[4] = 0;
                }
             }
             ix = i + 1;
             i = (byte)ix;
          }
       }
       return;
    }
    public void initSkillList(Monster mon){
       int ix;
       int ix1;
       int ix2;
       byte temp = 0;
       this.skill_list[8] = 0;
       byte i = 7;
       while (i > -1) {
          ix = i + 8;
          if ((this.skill_list[i] = mon.monster[ix]) != -1) {
             GameRun tskill_list = this.skill_list;
             ix2 = tskill_list[8] + 1;
             tskill_list[8] = (byte)ix2;
          }
          ix1 = i - 1;
          i = (byte)ix1;
       }
       i = 1;
       while (i < 8) {
          byte j = i;
          while (j > 0) {
             ix = j - 1;
             if (this.skill_list[j] <= this.skill_list[ix]) {
                break ;
             }
             temp = this.skill_list[j];
             ix = j - 1;
             this.skill_list[j] = this.skill_list[ix];
             ix2 = j - 1;
             this.skill_list[ix2] = temp;
             ix1 = j - 1;
             j = (byte)ix1;
          }
          ix1 = i + 1;
          i = (byte)ix1;
       }
       return;
    }
    public boolean isMoney(int sell_money,boolean bb){
       boolean b;
       if (bb) {
          if (this.money >= sell_money) {
             this.money = this.money - sell_money;
             b = true;
          }else {
             this.say("\x91\x02\x94\x02\x4e\x02\x8d\x02\xff\x02", 0);
          label_0014 :
             b = 0;
          }
       }else if(this.coin >= sell_money){
          this.coin = this.coin - sell_money;
          b = true;
       }else {
          this.say("\x5f\x02\x7a\x02\x4e\x02\x8d\x02\xff\x02", 0);
          goto label_0014 ;
       }
       return b;
    }
    public boolean isMoneyItem(int type,int item_id,int num,boolean bb){
       int i;
       if (((this.findItem(-2, item_id, true) + num)) > 99) {
          this.say("\x65\x02\x91\x02\x5d\x02\x52\x02\x4e\x02\x96\x02", 0);
          i = 0;
       }else if(bb){
          if (this.money >= (this.sell_money * num)) {
             this.money = this.money - (this.sell_money * num);
             i = true;
          }else if(this.money < (this.sell_money * num)){
             this.say("\x91\x02\x94\x02\x4e\x02\x8d\x02\xff\x02", -1, 0);
          }else {
             this.say("\x80\x02\x53\x02\x7a\x02\x95\x02\x4e\x02\x8d\x02\x30\x02", 0, -1);
          }
       }else if(this.coin >= (this.sell_money * num)){
          this.coin = this.coin - (this.sell_money * num);
          i = true;
       }else if(this.coin < (this.sell_money * num)){
          this.say("\x5f\x02\x7a\x02\x4e\x02\x8d\x02\xff\x02", 0);
       }else {
          this.say("\x80\x02\x53\x02\x7a\x02\x95\x02\x4e\x02\x8d\x02\x30\x02", 0);
       }
       i = 0;
       return i;
    }
    public boolean isNpc2ImageType(int id){
       int b;
       byte i = 0;
       while (true) {
          if (i >= this.npc2ImageType.length) {
             b = true;
             break ;
          }else if(this.npc2ImageType[i] == id){
             b = false;
             break ;
          }else {
             b = i + 1;
             i = (byte)b;
          }
       }
       return b;
    }
    public void keyGameOver1(boolean over){
       if (Ms.i().key_S1_Num5()) {
          if (this.popMenu == 1) {
             this.goMAIN_MENU();
          }else if(this.popMenu == null){
             System.out.println("loadGame soars");
             this.loadGame();
          }
          this.popMenu = -1;
       }else if(Ms.i().key_Up_Down()){
          this.popMenu = (byte)(this.popMenu ^ 0x01);
       }
       Ms.i().keyRelease();
       return;
    }
    public void keyLIST_INFO(){
       String[] stringArray = null;
       if (!Ms.i().key_delay()) {
          if (Ms.i().key_S1_Num5()) {
             if (this.monInfoList[this.getMonInfo_dir()]) {
                this.goMONSTER_INFO(this.getMonInfo_dir());
             }
          }else if(Ms.i().key_S2()){
             this.action_str = stringArray;
             this.monInfo_dir = stringArray;
             this.doPaint(0);
             this.goYouPAUSE(3);
          }else if(Ms.i().key_Left_Right()){
             this.cur_a = Ms.i().select(this.cur_a, 0, 4);
             this.infoStart = 0;
             if (this.cur_a > null) {
                byte i = 0;
                while (i < this.cur_a) {
                   int ix = this.infoStart + this.monInfo_dir[i].length;
                   this.infoStart = (byte)ix;
                   ix = i + 1;
                   i = (byte)ix;
                }
             }
             this.t_length = (byte)this.monInfo_dir[this.cur_a].length;
             this.select[0][1] = 0;
             this.select[0][0] = 0;
          }else if(Ms.i().key_Up_Down()){
             Ms.i().selectS(this.select[0], 0, this.t_length, this.list_rows);
          }
       }
       return;
    }
    public void key_gameRun(){
       byte b = 2;
       if (GameRun.run_state == 98) {
          if (Ms.i().key_Num0() || Ms.i().key_S1_Num5()) {
             GameRun.mc.doShowNotify();
          }
          Ms.i().keyRelease();
          Log.d("soars", "doShowNotify2");
       }else if(this.say_c > null){
          Ms.i().keyRelease();
       }else if(this.say_c < null){
          if (this.say_s == null && Ms.i().key_S1_Num5()) {
             this.say_c = 0;
             this.doSayOverSms();
          }
          Ms.i().keyRelease();
       }else {
          switch (GameRun.run_state){
              case 0xffffffe1:
                this.keyBattleState();
                break;
              case 0xffffffeb:
                SMSSender.i(this).keyLevel();
                Sound.i().soundStop();
                break;
              case 0xffffffec:
                SMSSender.i(this).key();
                break;
              case 0xfffffff1:
                if (!Ms.i().key_delay()) {
                   if (this.b_c == 1 && this.say_s == null) {
                      this.b_c = 0;
                   }
                }
                break;
              case 0xfffffff6:
                this.map.key_map();
                break;
              case 18:
                this.keyBuyItem();
                break;
              case 25:
                this.keyMY_BAG();
                break;
              case 35:
                if (!Ms.i().key_delay()) {
                   if (this.cur_c == null) {
                      GameRun tcMonsters = (this.mini_state == 6)? this.cMonsters: this.myMonsters;
                      this.key_MONSTER_LIST(tcMonsters);
                   }else if(this.cur_c == 1){
                      this.keyMagicUI();
                   }else if(this.cur_c == b){
                      this.keyEvolveUI();
                   }
                }
                break;
              case '2':
              case '4':
                break;
              case '3':
                if (Ms.i().key_Num0()) {
                   this.map.my.state = 0;
                   this.map.eventGoing = b;
                   Ms.i().keyRelease();
                   this.map.dialog_no = -1;
                   this.goGO_RUNINMAP();
                }
                break;
              case 60:
                Ms.i().keyRelease();
                GameRun.run_state = 61;
                String[] stringArray = new String[b];
                stringArray[0] = "\x7e\x02\x7e\x02";
                stringArray[1] = "\x65\x02\x5f\x02";
                this.setAction_str(stringArray);
                this.popMenu = 0;
                break;
              case 61:
                this.keyGameOver1(1);
                break;
              case 'A':
                if (!Ms.i().key_delay()) {
                   this.popState();
                }
                break;
              case 'B':
                this.keyNidus();
                break;
              case 'C':
                if (Ms.i().key_S2()) {
                   this.goLIST_INFO(0);
                   Ms.i().keyRelease();
                }
                break;
              case 'D':
                this.keyLIST_INFO();
                break;
              case 'E':
                Mg.i().key(this);
                break;
              case 'a':
                if (!Ms.i().key_delay()) {
                   if (Ms.i().key_S1_Num5()) {
                      Ms.i().keyRelease();
                      if (this.selectx == null) {
                         if (this.selecty == null) {
                            if (this.buyOk == 1) {
                               GameRun.run_state = 100;
                               this.b_c = 0;
                               this.buyOk = 0;
                            }else {
                               this.buyOk = 1;
                            }
                         }else if(this.selecty == 1){
                            this.goVIEW_MONSTER();
                         }else if(this.selecty == b){
                            this.goMY_BAG(0);
                         }else if(this.selecty == 3){
                            this.goLIST_INFO(1);
                         }else if(this.selecty == 4){
                            this.map.goMission(0, 1);
                         }else if(this.selecty == 5){
                            this.goRUN_IN_MAP(1);
                            this.action_str = null;
                         }
                      }else if(this.selecty == null){
                         if (this.buyOk == b) {
                            this.loadGame();
                         }else {
                            this.buyOk = b;
                         }
                      }else if(this.selecty == 1){
                         this.isChangeSound = Boolean.valueOf(1);
                         Sound.i().keyVolume(0);
                      }else if(this.selecty == b){
                         GameRun.mc.goHELP_dialog(1);
                      }else if(this.selecty == 3){
                         if (this.buyOk == 3) {
                            GameRun.run_state = 0;
                            this.action_str = null;
                            this.goMAIN_MENU();
                            this.buyOk = 0;
                         }else {
                            this.buyOk = 3;
                         }
                      }
                   }else if(Ms.i().key_S2()){
                      if (this.buyOk == null) {
                         this.action_str = null;
                         this.goRUN_IN_MAP(1);
                      }else {
                         this.doPaint(0);
                         GameRun.run_state = 97;
                         this.buyOk = 0;
                      }
                   }else if(this.buyOk == null){
                      if (Ms.i().key_Left_Right()) {
                         this.selectx = (byte)(this.selectx ^ 0x01);
                         this.selecty = 0;
                         this.setPauseS(this.selectx);
                      }else if(Ms.i().key_Up_Down()){
                         this.selecty = Ms.i().select(this.selecty, 0, (this.action_str.length - 1));
                      }
                   }
                }
                break;
          }
          if (Ms.i().key_S1_Num5() || Ms.i().key_S2()) {
             Ms.i().keyRelease();
          }
       }
       return;
    }
    public void levelPro(int no,boolean bb){
       byte[] temp_pro;
       int i = 3;
       int i1 = 0;
       if (bb) {
          byte enlevel_star = (byte)this.proReplace[no][6];
          temp_pro = this.monster_pro[this.myMonsters[no].monster[i1]];
          short temp = (short)(temp_pro[i1] + ((temp_pro[7] * enlevel_star) / 10));
          temp = this.getbuffRateV(this.myMonsters[no], temp);
          this.proReplace[no][i1] = (short)(this.myMonsters[no].monsterPro[2] - temp);
          temp = (short)(temp_pro[1] + ((temp_pro[8] * enlevel_star) / 10));
          this.proReplace[no][1] = (short)(this.myMonsters[no].monsterPro[i] - temp);
          temp = (short)(temp_pro[i] + ((temp_pro[10] * enlevel_star) / 10));
          this.proReplace[no][i] = (short)(this.myMonsters[no].monsterPro[6] - temp);
          temp = (short)(temp_pro[4] + ((temp_pro[11] * enlevel_star) / 10));
          this.proReplace[no][4] = (short)(this.myMonsters[no].monsterPro[7] - temp);
          temp = (short)(temp_pro[2] + ((temp_pro[9] * enlevel_star) / 10));
          this.proReplace[no][5] = (short)(this.myMonsters[no].monsterPro[5] - temp);
          temp_pro = null;
       }else {
          Monster monster = this.myMonsters[no].monster;
          byte b = (byte)(monster[2] + 1);
          monster[2] = b;
          temp_pro = this.monster_pro[this.myMonsters[no].monster[i1]];
          this.myMonsters[no].monsterPro[2] = (short)(temp_pro[i1] + ((temp_pro[7] * b) / 10));
          this.myMonsters[no].monsterPro[i] = (short)(temp_pro[1] + ((temp_pro[8] * b) / 10));
          this.myMonsters[no].monsterPro[6] = (byte)(temp_pro[i] + ((temp_pro[10] * b) / 10));
          this.myMonsters[no].monsterPro[7] = (byte)(temp_pro[4] + ((temp_pro[11] * b) / 10));
          this.myMonsters[no].monsterPro[5] = (byte)(temp_pro[2] + ((temp_pro[9] * b) / 10));
          this.myMonsters[no].resetPro(this);
          temp_pro = null;
          this.healMonster(this.myMonsters[no]);
       }
       return;
    }
    public void map_flashString(){
       int i = 22;
       int i1 = 12;
       int WIDTH = Constants_H.WIDTH__;
       int HEIGHT = Constants_H.HEIGHT__;
       int WIDTH_H = 320;
       int HEIGHT_H = Constants_H.HEIGHT__ / 2;
       this.setSay();
       if (this.say_c > null && GameRun.run_state != 98) {
          if (this.map.fontSizeControl == null) {
             Ms.i();
             Ms.font.setSize(i);
          }
          GameRun tshowS = this.showS;
          int i2 = (this.say_mode == null)? (HEIGHT_H - ((this.showS.length >> 1) * 25)) - i1: (HEIGHT - 50) - 18;
          this.showString(tshowS, i2, this.say_s, 1);
          if (this.say_s == null) {
             this.say_c = (byte)(this.say_c - 1);
          }else {
             this.say_s = Ms.i().mathSpeedDown(this.say_s, 3, 1);
          }
       }else if(this.say_c < null && GameRun.run_state != 98){
          Ms.i();
          Ms.font.setSize(i);
          this.showString(this.showS, ((HEIGHT_H - ((this.showS.length >> 1) * 25)) - i1), this.say_s, 2);
          if (this.say_s != null) {
             this.say_s = Ms.i().mathSpeedDown(this.say_s, 3, 1);
          }
          if (this.pkey.isSelect(0, 0, WIDTH, HEIGHT)) {
             this.pkey.setKey5();
          }
       }
       Ms.i();
       Ms.font.setSize(26);
       return;
    }
    public void paint_gameRun(Graphics g){
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       switch (GameRun.run_state){
           case 0xffffffce:
             this.drawBattleBG();
             this.drawSelectMenu(g, true, 252);
             int i = 15;
             int i1 = 124;
             int i2 = 10;
             boolean b = false;
             boolean b1 = (!this.src_c[2])? true: false;
             this.drawSrcLine(g, i, i1, i2, b, b1);
             b1 = (!this.src_c[3])? true: false;
             this.drawSrcLine(g, 131, 124, 10, true, b1);
             this.drawPlayerAppear(g);
             break;
           case 0xffffffe0:
           case 0xfffffff5:
           case '4':
           case 0xffffffe1:
             this.drawBattleBG();
             this.drawPlayer(g);
             boolean b2 = (this.battle_state != 2)? true: false;
             this.drawSelectMenu(g, b2, 252);
             this.paintBattleState(g);
             break;
           case 0xffffffe2:
             this.drawDarkScreen();
             break;
           case 0xffffffeb:
             SMSSender.i(this).paintLevel();
             break;
           case 0xffffffec:
             SMSSender.i(this).paint();
             break;
           case 0xffffffed:
             this.drawBattleBG();
             this.drawSelectMenu(g, true, 252);
             this.drawMyMon();
             this.drawEnemy();
             if (this.cThrowY < 17) {
                this.cThrowS = (short)(this.cThrowS + this.cThrowY);
                this.cThrowY = Ms.i().mathSpeedN(this.cThrowY, 17, 2, false);
             }
             this.cThrowX = Ms.i().mathSpeedN(this.cThrowX, 0, 8, false);
             Ui.i().drawImage(this.imgItem[0], (377 - this.cThrowX), this.cThrowS, (1 | 0x20));
             break;
           case 0xfffffff1:
             this.paintBATTLE_OVER();
             break;
           case 0xfffffff6:
             this.map.paint_map(g);
             break;
           case 18:
             this.drawBUY_ITEM();
             break;
           case 25:
             this.drawMY_BAG(0, 0, WIDTH, HEIGHT);
             break;
           case 35:
             if (this.cur_c == null) {
                GameRun tcMonsters = (this.mini_state == 6)? this.cMonsters: this.myMonsters;
                this.drawMONSTER_UI(tcMonsters);
             }else if(this.cur_c == 1){
                object oobject = (this.mini_state == 6)? this.cMonsters[this.selecty]: this.myMonsters[this.selecty];
                this.drawMagicUI(oobject);
             }else if(this.cur_c == 2){
                this.drawEvolveUI(1, this.selecty, false);
             }
             break;
           case '3':
             this.map.drawBlackSRC(g, 30, true);
             this.drawZero("\x7e\x02\x67\x02", (HEIGHT - 10));
             break;
           case 60:
             GameRun.mc.drawRectBG();
             this.showString("\x62\x02\x65\x02\x59\x02\x8d\x02\x4e\x02,\x8b\x02\x7e\x02\x5e\x02\x76\x02\x68\x02\x60\x02\x4e\x02\x80\x02\x5b\x02\x73\x02\x4e\x02!", HEIGHT_H, 0);
             Ui.i().drawYesNo(true, true);
             break;
           case 61:
             GameRun.mc.drawRectBG();
             this.showString("\x4f\x02\x89\x02\x7e\x02\x7e\x02\x6e\x02\x62\x02\xff\x02\x78\x02\x5b\x02\x54\x02\xff\x02", (HEIGHT - 50), 0);
             this.drawSelectMenu(this.action_str, (WIDTH_H - 50), (HEIGHT_H - 50), 100, 2, 0, this.popMenu);
             break;
           case 'A':
             this.drawVIEW_COMPUTER();
             break;
           case 'B':
             this.drawNidus(200, 225);
             break;
           case 'C':
             this.drawMONSTER_INFO(this.getMonInfo_dir());
             break;
           case 'D':
             this.drawLIST_INFO();
             break;
           case 'E':
             Mg.i().paint();
             break;
           case 'a':
             Ui.i().drawK0(-2, 0, (WIDTH + 4), 33, 0);
             Ui.i().drawString("\x8b\x02\x7e\x02\x5e\x02\x7b\x02\x7e\x02\xff\x02"+this.rmsOther[3], WIDTH_H, 2, 17, 1, 2);
             this.drawPauseMenu(((WIDTH_H - 100) - 5), 45, 210, 235);
             Ui.i().drawK0(-2, ((HEIGHT - 25) - 8), (WIDTH + 4), 33, 0);
             this.gogoWordM(this.gogoString, ((HEIGHT - 25) - 6), 16, 3, 0, 2);
             if (this.buyOk != null) {
                String str = "\x66\x02\x54\x02\x4f\x02\x5b\x02\x6e\x02\x62\x02?";
                if (this.buyOk == 2) {
                   str = "\x66\x02\x54\x02\x8b\x02\x53\x02\x8f\x02\x5e\x02?";
                }else if(this.buyOk == 3){
                   str = "\x4e\x02\x52\x02\x67\x02\x4f\x02\x5b\x02\x76\x02\x90\x02\x52\x02\x5c\x02\x4f\x02\x4e\x02\x59\x02\xff\x02\x66\x02\x54\x02\x7e\x02\x7e\x02\xff\x02";
                }
                this.showString(str, 60, 0);
             }
             Ui.i().drawYesNo(true, true);
             break;
           case 'b':
             GameRun.mc.drawRectBG();
             Ui.i().drawK1(-5, (HEIGHT - 75), (WIDTH + 10), 75, 3);
             this.showStringM("\x6e\x02\x62\x02\x66\x02\x50\x02\xff\x02\x70\x02\x51\x02\x5c\x02\x5e\x02\x8f\x02\x56\x02\x30\x02", WIDTH_H, ((HEIGHT - 50) - 2), 9, 3);
             break;
           case 'd':
             this.b_c = 1;
             this.showString("\x4f\x02\x5b\x02\x6e\x02\x62\x02\x4e\x02", 20, 0);
             break;
       }
       this.map_flashString();
       return;
    }
    public void popState(){
       object oobject;
       int b1;
       byte b = 6;
       if (this.buyOk == null && Ms.i().key_Up_Down()) {
          this.popMenu = Ms.i().select(this.popMenu, 0, (this.about_d.length - 1));
       }else if(Ms.i().key_S1_Num5()){
          if (!Ms.i().equals(this.about_d[this.popMenu], "\x62\x02\x80\x02") && !Ms.i().equals(this.about_d[this.popMenu], "\x59\x02\x8d\x02")) {
             if (Ms.i().equals(this.about_d[this.popMenu], "\x53\x02\x62\x02")) {
                if (this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
                   if (this.view_state < null) {
                      byte i = 1;
                      while (i <= this.mon_in_battle[0] && this.mon_in_battle[i] != this.myMonsters[this.select[0][0]].monster[1]) {
                         if (i == this.mon_in_battle[0]) {
                            GameRun tmon_in_batt = this.mon_in_battle;
                            byte ix = tmon_in_batt[0] + 1;
                            ix = (byte)ix;
                            tmon_in_batt[0] = ix;
                            this.mon_in_battle[ix] = this.myMonsters[this.select[0][0]].monster[1];
                         }
                         b1 = i + 1;
                         i = (byte)b1;
                      }
                      this.initSkillList(this.myMonsters[this.select[0][0]]);
                   }
                   this.changeMonster(this.myMonsters[this.select[0][0]], this.myMonsters[0]);
                   this.initMonStream(2, this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0], 1);
                   this.setShowPro(this.myMonsters[this.select[0][0]]);
                   if (this.view_state < null) {
                      this.setMyThrow();
                      GameRun.run_state = -50;
                      this.battle_state = 0;
                      if (this.view_state == -1) {
                         this.myB.act_num = 1;
                         this.enB.act_num = 1;
                      }
                      this.myB.dead = 0;
                      this.first_battle = 0;
                   }
                   this.lastSkill = 0;
                }else {
                   this.say("\x5f\x02\x52\x02\x5b\x02\x72\x02\x4e\x02\x80\x02\x53\x02\x62\x02", 0);
                }
                this.popMenu = -1;
             }else if(Ms.i().equals(this.about_d[this.popMenu], "\x8f\x02\x53\x02")){
                this.setEvolveStringB(this.myMonsters[this.select[0][0]]);
                this.bg_c = this.myMonsters[this.select[0][0]].monster[3];
                this.b_c = 0;
                this.restMove(2, 0);
             }else if(Ms.i().equals(this.about_d[this.popMenu], "\x65\x02\x75\x02")){
                if (!this.isMyMonsters(this.select[0][0])) {
                   this.say("\x8e\x02\x4e\x02\x5f\x02\x98\x02\x64\x02\x5e\x02\x4e\x02\x53\x02\x80\x02\x53\x02\x62\x02\x76\x02\x5b\x02\x72\x02\xff\x02", 0);
                }else if(this.buyOk == 1){
                   this.buyOk = 0;
                   this.delMonster(this.select[0][0]);
                   if (this.select[0][0] == this.myMon_length) {
                      oobject = this.select[0];
                      oobject[0] = (byte)(oobject[0] - 1);
                   }
                   this.initMonStream(2, this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0], 1);
                   this.setShowPro(this.myMonsters[this.select[0][0]]);
                   this.introT = Constants_H.WIDTH_H;
                   this.t_length = this.myMon_length;
                   this.popMenu = -1;
                }else {
                   this.buyOk = 1;
                   this.gogoString = "\x65\x02\x75\x02\x76\x02\x5b\x02\x72\x02\x5c\x02\x4f\x02\x6d\x02\x59\x02\xff\x02\x66\x02\x54\x02\x7e\x02\x7e\x02\xff\x02";
                }
             }else if(Ms.i().equals(this.about_d[this.popMenu], "\x5b\x02\x65\x02")){
                if (GameRun.run_state == 35) {
                   this.putMonster();
                }else {
                   this.mini_state = 4;
                   this.view_state = 1;
                   this.goVIEW_MONSTER();
                }
             }else if(Ms.i().equals(this.about_d[this.popMenu], "\x53\x02\x51\x02")){
                if (GameRun.run_state == 35) {
                   this.takenMonster();
                }else {
                   this.mini_state = b;
                   this.view_state = 1;
                   this.goVIEW_MONSTER();
                }
             }else if(Ms.i().equals(this.about_d[this.popMenu], "\x53\x02\x5b\x02")){
                if (this.buyOk == 1) {
                   this.buyOk = 0;
                   this.money = this.money + this.sell_money;
                   this.say("\x83\x02\x5f\x02\x91\x02\x94\x02\xff\x02"+this.sell_money, 0);
                   if (this.mini_state == b) {
                      this.setTakenMonster();
                   }else {
                      this.setPutMonster();
                   }
                }else if(this.mini_state == 4 && !this.isMyMonsters(this.select[0][0])){
                   this.say("\x8e\x02\x4e\x02\x5f\x02\x98\x02\x64\x02\x5e\x02\x4e\x02\x53\x02\x80\x02\x53\x02\x62\x02\x76\x02\x5b\x02\x72\x02\xff\x02", 0);
                }else {
                   this.buyOk = 1;
                   oobject = (this.mini_state == 4)? this.myMonsters[this.select[0][0]]: this.cMonsters[this.select[0][0]];
                   this.sellMonster(oobject);
                   this.gogoString = "\x83\x02\x5f\x02\x91\x02\x94\x02\xff\x02"+this.sell_money+"\xff\x02\x66\x02\x54\x02\x53\x02\x51\x02\xff\x02";
                }
             }else if(Ms.i().equals(this.about_d[this.popMenu], "\x79\x02\x5f\x02")){
                this.goRUN_IN_MAP(0);
             }
          }else if(this.mini_state == b){
             oobject = this.cMonsters[this.select[0][0]];
          }else {
             oobject = this.myMonsters[this.select[0][0]];
          }
          this.initSkillList(oobject);
          if (this.view_state > null) {
             b1 = (this.mini_state == b)? this.cMonsters[this.select[0][0]].monster[3]: this.myMonsters[this.select[0][0]].monster[3];
             this.bg_c = b1;
          }else if(this.view_state < null && this.myB != null){
             this.bg_c = this.myB.bg_id;
          }
          b1 = (Ms.i().equals(this.about_d[this.popMenu], "\x62\x02\x80\x02"))? 0: 1;
          this.restMove(1, b1);
       }else if(Ms.i().key_S2()){
          if (this.buyOk != null) {
             this.buyOk = 0;
          }else if(GameRun.run_state == 65){
             this.goRUN_IN_MAP(0);
          }else {
             this.popMenu = -1;
          }
       }
       return;
    }
    public boolean runPauseIco(){
       int b;
       byte i = 0;
       while (true) {
          if (i >= this.b_ico) {
             b = false;
             break ;
          }else if(this.map.my.state == null && this.pkey.isSelect(this.pkey.button_pos[10][i][0], this.pkey.button_pos[10][i][1], this.pkey.button_pos[10][i][2], this.pkey.button_pos[10][i][3])){
             if (this.b_ico == 2) {
                this.isTalk = false;
                this.pkey.setKey5();
             }
             this.pkey.initPointer();
             if (!i) {
                b = (this.b_ico == 2)? 7: 2;
                this.b_ico = (byte)b;
             }else if(GameRun.run_state != 98){
                if (i == 3) {
                   this.goYouPAUSE(0);
                }else if(i == 6){
                   SMSSender.i(this).go(0, 1);
                }else if(i == 2){
                   Ms.key = 48;
                }else if(i == 4){
                   Ms.key = 49;
                }else if(i == 5){
                   Ms.key = 51;
                }else if(i == 1){
                   Ms.key = 57;
                }
                Ms.keyRepeat = true;
                this.b_ico = 2;
             }
             b = 1;
             break ;
          }else {
             b = i + 1;
             i = (byte)b;
          }
       }
       return b;
    }
    public void run_gameRun(){
       byte ix;
       switch (GameRun.run_state){
           case 0xffffffa9:
           case 0xffffffaa:
           case 0xfffffff1:
             if (this.b_c == null) {
                if (this.levelUp_in_battle[this.myB.getMon().monster[1]][0] == 1) {
                   this.levelUp_in_battle[this.myB.getMon().monster[1]][0] = 0;
                   this.b_c = 1;
                   this.say_s = 52;
                   this.levelPro(this.myB.now_id, true);
                   this.setStringB("\x75\x02\x54\x02;+"+this.proReplace[this.myB.now_id][0]+"#n"+"\x80\x02\x91\x02"+";+"+this.proReplace[this.myB.now_id][1], Constants_H.WIDTH, 0);
                   this.setStringB("\x52\x02\x91\x02;+"+this.proReplace[this.myB.now_id][3]+"#n"+"\x96\x02\x5f\x02"+";+"+this.proReplace[this.myB.now_id][4]+"#n"+"\x65\x02\x63\x02"+";+"+this.proReplace[this.myB.now_id][5], Constants_H.WIDTH, 1);
                   this.initMonStream(2, this.mList_id[this.myB.getMon().monster[0]][0], 1);
                }else {
                   GameRun tmyB = this.myB;
                   tmyB.now_id = (byte)(tmyB.now_id + 1);
                }
                if (this.myB.now_id >= this.myMon_length) {
                   byte i = 0;
                   boolean b = false;
                   StringBuffer sbuf = "";
                   while (i < this.myMon_length) {
                      if (this.myMonsters[i].monster[5] > 0 && (this.evolve[i] && this.isEvolveKind(this.myMonsters[i].monster[4], this.myMonsters[i].monster[2]) == -1)) {
                         if (!Ms.i().equals(sbuf, "")) {
                            sbuf = sbuf.append("\x30\x02");
                         }
                         sbuf = sbuf.append(this.getNameMon(this.myMonsters[i].monster[0]));
                         this.evolve[i] = false;
                         b = true;
                      }
                      ix = i + 1;
                      i = (byte)ix;
                   }
                   if (b) {
                      sbuf = sbuf+"\x53\x02\x4e\x02\x8f\x02\x53\x02\x4e\x02";
                   }
                   StringBuffer sbuf0 = "";
                   b = false;
                   i = 0;
                   while (i < 5) {
                      if (this.getRid(i) != -2 && this.getNexp(i, 1) == this.getNexp(i, 3)) {
                         if (!Ms.i().equals(sbuf0, "")) {
                            sbuf0 = sbuf0.append("\x30\x02");
                         }
                         sbuf0 = sbuf0.append("".append(this.monsterT[this.monster_pro[this.getNid(i)][6]]).append("\x76\x02\x5b\x02\x72\x02\x86\x02").toString());
                         b = true;
                      }
                      ix = i + 1;
                      i = (byte)ix;
                   }
                   if (b) {
                      sbuf0 = sbuf0+"\x7e\x02\x9a\x02\x5d\x02\x6e\x02\xff\x02\x53\x02\x4e\x02\x5b\x02\x53\x02\x4e\x02\x30\x02";
                      if (!Ms.i().equals(sbuf, "")) {
                         sbuf = sbuf+"#n";
                      }
                      sbuf = sbuf+sbuf0;
                   }
                   if (!Ms.i().equals(sbuf, "")) {
                      this.say(sbuf, -1);
                   }
                   sbuf = null;
                   sbuf0 = null;
                   this.setNullBattle();
                   this.goGO_RUNINMAP();
                }
             }else if(this.b_c == 1){
                this.say_s = Ms.i().mathSpeedDown(this.say_s, 4, true);
             }
             break;
           case 0xffffffce:
             this.runMonsterAppear();
             break;
           case 0xffffffe1:
             this.runBattleState();
             break;
           case 0xffffffe2:
             if (this.createOver == -1) {
                ix = (byte)(this.b_c + 1);
                this.b_c = ix;
                if (ix >= 8) {
                   this.goMontsterAppear();
                }
             }
             break;
           case 0xffffffeb:
             SMSSender.i(this).runLevel();
             break;
           case 0xffffffec:
             SMSSender.i(this).run();
             break;
           case 0xffffffed:
             if (this.cThrowX == null && this.b_c == null) {
                byte id = this.items[this.selectx][this.select[0][0]][0];
                this.deleteItems(id, 1);
                short getRate = (short)(((((new byte[3]{0x01,0x03,0x0e}[(id - 9)] * 30) + 50) - this.enB.getMon().monster[2]) + (60 / this.enB.getMon().monster[2])) - ((this.enB.getMon().monsterPro[0] * 100) / this.enB.getMon().monsterPro[2]));
                getRate = (short)(((7 - ((this.enB.getMon().monster[5] - 1) * 2)) * getRate) / 10);
                if (this.enB.getMon().isEffect(3)) {
                   getRate = (short)(getRate + 30);
                }
                byte[] CatchBall = null;
                if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
                   this.say("\x62\x02\x80\x02\x64\x02\x5e\x02\x76\x02\x5b\x02\x72\x02\x5d\x02\x7e\x02\x8f\x02\x52\x02\x4e\x02\x96\x02\xff\x02", -1);
                   this.enB.act_num = 1;
                   this.myB.act_num = 0;
                   GameRun.run_state = -31;
                   this.battle_state = 9;
                }else {
                   Ms.i();
                   if (Ms.getRandom(100) < getRate) {
                      this.enB.action = 2;
                      this.enB.dead = 1;
                      this.say("\x63\x02\x83\x02"+this.getNameMon(this.enB.getMon().monster[0])+"\x5d\x02\x62\x02\x52\x02\xff\x02", 0);
                      if (!this.getMonster(this.enB.getMon(), -1, false)) {
                         this.myMonsters[(this.myMon_length - 1)].monster[1] = (byte)(this.myMon_length - 1);
                      }
                      GameRun.run_state = -31;
                      this.goBattleExp(false);
                   }else {
                      this.b_c = 1;
                      StringBuffer str = "\x6c\x02\x67\x02\x63\x02\x83\x02\x52\x02"+this.getNameMon(this.enB.getMon().monster[0]);
                      if (!this.myB.getMon().isMonReel(41) && (!this.enB.getMon().isEffect(4) && !this.enB.getMon().isEffect(3))) {
                         String[] stringArray = new String[]{"\x6d\x02\x77\x02\x6c\x02\x90\x02\x8d\x02\x4e\x02\xff\x02","\x62\x02\x4e\x02\x54\x02\x76\x02\x90\x02\x8d\x02\x4e\x02\xff\x02","\x76\x02\x4e\x02\x4f\x02\x4e\x02\x77\x02\xff\x02\x90\x02\x8d\x02\x4e\x02\xff\x02"};
                         Ms.i();
                         str = str+"#n"+this.getNameMon(this.enB.getMon().monster[0])+stringArray[Ms.getRandom(3)];
                         CatchBall = null;
                      }else {
                         this.enB.act_num = 1;
                         this.myB.act_num = 0;
                         GameRun.run_state = -31;
                         this.battle_state = 9;
                      }
                      this.say(str, 0);
                   }
                }
             }else if(this.b_c == 1 && this.say_c == null){
                this.arangeMonster();
                this.setNullBattle();
                this.goGO_RUNINMAP();
             }
             break;
           case 0xfffffff5:
             this.goRUN_IN_MAP(false);
             break;
           case 0xfffffff6:
             this.map.run_map();
             break;
           case 35:
             ix = (byte)(this.mon_action_c + 1);
             this.mon_action_c = ix;
             if (ix > 50) {
                this.mon_action_c = 0;
                this.mon_action = 1;
             }
             if (this.cur_c == 2 && (this.b_c == -1 && this.say_s == null)) {
                this.goView();
             }
             break;
           case 'E':
             Mg.i().run();
             break;
           case 'd':
             if (this.b_c == 1) {
                this.saveGame();
                this.say("\x6e\x02\x62\x02\x5d\x02\x4f\x02\x5b\x02\x30\x02", 0);
                this.b_c = 0;
                this.goRUN_IN_MAP(true);
             }
             break;
       }
       return;
    }
    public void saveGame(){
       this.map.save();
       this.saveMon(0);
       this.saveMon(1);
       this.saveItem();
       this.saveInfoList();
       this.rmsOther[0] = this.map.mapNo;
       Ms.i().rmsOptions(10, this.rmsOther, 2);
       Ms.i().rmsOptions(3, this.rmsNidus, 2);
       Ms.i().rmsOptions(0, null, 4);
    }
    public void say(String string,int flag){
       String soars;
       Log.e("soars", string);
       soars = "\x83\x02\x53\x02\x95\x02";
       if (string.equals("#7\x70\x02\x51\x02\x5c\x02\x5e\x02\x62\x02\x75\x02\x5b\x02\x82\x02\x95\x02#0\x63\x02\x52\x02\x4e\x02\x4e\x02\x5d\x02\x53\x02\x79\x02\x52\x02\x30\x02")) {
          string = "#7\x70\x02\x51\x02\x5c\x02\x5e\x02#0\x63\x02\x52\x02\x4e\x02\x4e\x02\x5d\x02\x53\x02\x79\x02\x52\x02\x30\x02";
       }else if(string.contains(soars)){
          string.replace("\x83\x02\x53\x02\x95\x02", "\x53\x02\x4e\x02\x65\x02\x5d\x02\x51\x02\x63\x02\x94\x02");
       }
       this.sayStr.add(string);
       this.sayFlag.add(Integer.valueOf(flag));
       this.setSay();
       return;
    }
    public void say(String string,int flag,int sayOverSms){
       this.showS = Ms.i().groupString(string, (Constants_H.WIDTH - 50));
       this.say_s = Constants_H.WIDTH;
       this.say_mode = 0;
       if (!flag) {
          this.say_c = 15;
       }else if(flag == -1){
          this.say_c = -1;
          this.sayOverSms = (byte)sayOverSms;
       }else if(flag == 1){
          this.say_c = 15;
          this.say_mode = 1;
       }
       return;
    }
    public void setAimBattle(int state){
       this.mini_state = (byte)state;
       GameRun tmyB = (this.mini_state == 1)? this.myB: this.enB;
       this.am = tmyB;
       tmyB = (this.mini_state == 1)? this.enB: this.myB;
       this.dm = tmyB;
       return;
    }
    public void setMagic(int pro){
       if (pro > 5) {
          pro = 5;
       }
       this.initMagicStream(pro);
       this.now_action_Magic[pro] = 0;
       this.now_time_Magic[pro] = 0;
       return;
    }
    public void setNull(boolean bb){
       if (this.map != null) {
          this.map.setNull();
       }
       if (this.mon[0] != null) {
          this.mon[0].nullIMFA();
       }
       if (this.mon[1] != null) {
          this.mon[1].nullIMFA();
       }
       if (bb) {
          this.data_null();
       }
       return;
    }
    public void setSay(){
       if (this.say_c == null && this.sayStr.size()) {
          int flag = this.sayFlag.remove(0).intValue();
          this.showS = Ms.i().groupString(this.sayStr.remove(0), (Constants_H.WIDTH - 50));
          this.say_s = Constants_H.WIDTH;
          this.say_mode = 0;
          if (!flag) {
             this.say_c = 15;
          }else if(flag == -1){
             this.say_c = -1;
          }else if(flag == 1){
             this.say_c = 15;
             this.say_mode = 1;
          }
       }
       return;
    }
    public void skyCheckRegFull(int where){
       switch (where){
           case 1:
             this.map.setRegState(true);
             GameRun.mc.skyNewGame();
             break;
           case 2:
             this.map.setRegState(true);
             GameRun.mc.skyContinueGame();
             break;
       }
       return;
    }
    public void start(){
       this.goRUN_IN_MAP(true);
       this.map.insertNpc();
       this.line_max = 2;
       this.cityName_c = 25;
       if (this.map.anole_temp != -2) {
          this.map.anole_type = this.map.anole_temp;
          this.map.anole_temp = -2;
          this.map.setAnole();
       }
       return;
    }
    public void valueMend(Monster monster){
       if (monster.monsterPro[0] < 0) {
          monster.monsterPro[0] = 0;
       }else if(monster.monsterPro[0] > monster.monsterPro[2]){
          monster.monsterPro[0] = monster.monsterPro[2];
       }
       if (monster.monsterPro[1] < 0) {
          monster.monsterPro[1] = 0;
       }else if(monster.monsterPro[1] > monster.monsterPro[3]){
          monster.monsterPro[1] = monster.monsterPro[3];
       }
       return;
    }
}
