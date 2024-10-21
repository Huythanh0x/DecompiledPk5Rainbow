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
  
  private byte[] initFealty = new byte[] { 100, 120 };
  
  private Boolean isChangeSound = Boolean.valueOf(false);
  
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
  
  public ArrayList<Integer> sayFlag = new ArrayList<Integer>();
  
  public byte sayOverSms = -1;
  
  public ArrayList<String> sayStr = new ArrayList<String>();
  
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
  
  public GameRun(MainCanvas paramMainCanvas) {
    byte[] arrayOfByte1 = new byte[16];
    arrayOfByte1[0] = -6;
    arrayOfByte1[1] = -4;
    arrayOfByte1[2] = -3;
    arrayOfByte1[3] = -2;
    arrayOfByte1[4] = -1;
    arrayOfByte1[6] = 1;
    arrayOfByte1[7] = 2;
    arrayOfByte1[8] = 3;
    arrayOfByte1[9] = 4;
    arrayOfByte1[10] = 8;
    arrayOfByte1[11] = -3;
    arrayOfByte1[12] = 2;
    arrayOfByte1[13] = -1;
    arrayOfByte1[14] = 1;
    arrayOfByte1[15] = 1;
    this.zb = arrayOfByte1;
    arrayOfByte1 = new byte[] { 2, 3 };
    byte[] arrayOfByte4 = { 3, 4 };
    byte[] arrayOfByte3 = new byte[2];
    arrayOfByte3[0] = 4;
    byte[] arrayOfByte2 = new byte[2];
    arrayOfByte2[1] = 1;
    this.Shuxing = new byte[][] { arrayOfByte1, arrayOfByte4, arrayOfByte3, arrayOfByte2, { 1, 2 } };
    this.hit_rate = 0;
    this.magic_id = -2;
    this.magic_x = 0;
    this.magic_y = 0;
    this.mon = new Sprite[2];
    this.magic = new Sprite[6];
    this.now_action_Magic = new short[6];
    this.now_time_Magic = new short[6];
    this.overMode = 0;
    this.evolve = new boolean[] { true, true, true, true, true };
    this.now_action = new byte[2];
    this.now_time = new byte[2];
    this.battleSay = new String[] { "敌人出现了，战斗吧！", "考验的时刻来了，训练师！", "尽情捕捉宠物吧！" };
    this.isUpdateList = false;
    this.first_battle = 0;
    this.lastSkill = 0;
    this.skill_list = new byte[9];
    this.b_ico = 2;
    mc = paramMainCanvas;
    this.map = null;
    this.map = new Map(this);
    initOtherImage();
    Ui.i().initUiModules();
    loadRmsOther();
    loadRmsSms();
    SMSSender.i(this);
    PetKing5.gr = this;
  }
  
  private void AddHP(int paramInt, Monster paramMonster) {
    paramInt += paramMonster.monsterPro[0];
    if (paramInt >= paramMonster.monsterPro[2]) {
      paramMonster.monsterPro[0] = paramMonster.monsterPro[2];
      return;
    } 
    paramMonster.monsterPro[0] = (short)paramInt;
  }
  
  private void AddMP(int paramInt, Monster paramMonster) {
    paramInt += paramMonster.monsterPro[1];
    if (paramInt > paramMonster.monsterPro[3]) {
      paramMonster.monsterPro[1] = paramMonster.monsterPro[3];
      return;
    } 
    paramMonster.monsterPro[1] = (short)paramInt;
  }
  
  private void aiEnemy() {
    // Byte code:
    //   0: iconst_5
    //   1: istore_1
    //   2: invokestatic i : ()Ldm/Ms;
    //   5: pop
    //   6: bipush #100
    //   8: invokestatic getRandom : (I)I
    //   11: i2b
    //   12: istore_2
    //   13: iload_1
    //   14: iconst_m1
    //   15: if_icmple -> 37
    //   18: aload_0
    //   19: getfield enB : Ldm/Battle;
    //   22: invokevirtual getMon : ()Ldm/Monster;
    //   25: getfield monster : [B
    //   28: iload_1
    //   29: bipush #8
    //   31: iadd
    //   32: baload
    //   33: iconst_m1
    //   34: if_icmpeq -> 127
    //   37: iload_1
    //   38: iconst_1
    //   39: iadd
    //   40: i2b
    //   41: istore #4
    //   43: aload_0
    //   44: getfield battle_type : B
    //   47: iconst_4
    //   48: if_icmpne -> 276
    //   51: iload #4
    //   53: tableswitch default -> 80, 1 -> 135, 2 -> 146, 3 -> 174
    //   80: iload_2
    //   81: bipush #45
    //   83: if_icmpge -> 219
    //   86: aload_0
    //   87: getfield enB : Ldm/Battle;
    //   90: iload #4
    //   92: iconst_1
    //   93: isub
    //   94: i2b
    //   95: putfield skill : B
    //   98: aload_0
    //   99: getfield enB : Ldm/Battle;
    //   102: aload_0
    //   103: getfield enB : Ldm/Battle;
    //   106: invokevirtual getMon : ()Ldm/Monster;
    //   109: getfield monster : [B
    //   112: aload_0
    //   113: getfield enB : Ldm/Battle;
    //   116: getfield skill : B
    //   119: bipush #8
    //   121: iadd
    //   122: baload
    //   123: putfield skill : B
    //   126: return
    //   127: iload_1
    //   128: iconst_1
    //   129: isub
    //   130: i2b
    //   131: istore_1
    //   132: goto -> 13
    //   135: aload_0
    //   136: getfield enB : Ldm/Battle;
    //   139: iconst_0
    //   140: putfield skill : B
    //   143: goto -> 98
    //   146: iload_2
    //   147: bipush #65
    //   149: if_icmpge -> 163
    //   152: aload_0
    //   153: getfield enB : Ldm/Battle;
    //   156: iconst_1
    //   157: putfield skill : B
    //   160: goto -> 98
    //   163: aload_0
    //   164: getfield enB : Ldm/Battle;
    //   167: iconst_0
    //   168: putfield skill : B
    //   171: goto -> 98
    //   174: iload_2
    //   175: bipush #45
    //   177: if_icmpge -> 191
    //   180: aload_0
    //   181: getfield enB : Ldm/Battle;
    //   184: iconst_2
    //   185: putfield skill : B
    //   188: goto -> 98
    //   191: iload_2
    //   192: bipush #75
    //   194: if_icmple -> 208
    //   197: aload_0
    //   198: getfield enB : Ldm/Battle;
    //   201: iconst_1
    //   202: putfield skill : B
    //   205: goto -> 98
    //   208: aload_0
    //   209: getfield enB : Ldm/Battle;
    //   212: iconst_0
    //   213: putfield skill : B
    //   216: goto -> 98
    //   219: iload_2
    //   220: bipush #75
    //   222: if_icmpge -> 240
    //   225: aload_0
    //   226: getfield enB : Ldm/Battle;
    //   229: iload #4
    //   231: iconst_2
    //   232: isub
    //   233: i2b
    //   234: putfield skill : B
    //   237: goto -> 98
    //   240: iload_2
    //   241: bipush #95
    //   243: if_icmpge -> 261
    //   246: aload_0
    //   247: getfield enB : Ldm/Battle;
    //   250: iload #4
    //   252: iconst_3
    //   253: isub
    //   254: i2b
    //   255: putfield skill : B
    //   258: goto -> 98
    //   261: aload_0
    //   262: getfield enB : Ldm/Battle;
    //   265: iload #4
    //   267: iconst_4
    //   268: isub
    //   269: i2b
    //   270: putfield skill : B
    //   273: goto -> 98
    //   276: iconst_0
    //   277: istore_1
    //   278: invokestatic i : ()Ldm/Ms;
    //   281: pop
    //   282: bipush #100
    //   284: invokestatic getRandom : (I)I
    //   287: i2b
    //   288: istore_3
    //   289: iload_1
    //   290: iconst_2
    //   291: if_icmplt -> 353
    //   294: iload_1
    //   295: iconst_1
    //   296: if_icmple -> 98
    //   299: iload #4
    //   301: tableswitch default -> 332, 1 -> 462, 2 -> 473, 3 -> 501, 4 -> 545
    //   332: iload_2
    //   333: bipush #60
    //   335: if_icmpge -> 590
    //   338: aload_0
    //   339: getfield enB : Ldm/Battle;
    //   342: iload #4
    //   344: iconst_1
    //   345: isub
    //   346: i2b
    //   347: putfield skill : B
    //   350: goto -> 98
    //   353: aload_0
    //   354: getfield enB : Ldm/Battle;
    //   357: invokevirtual getMon : ()Ldm/Monster;
    //   360: getfield monster : [B
    //   363: iload_1
    //   364: bipush #14
    //   366: iadd
    //   367: baload
    //   368: tableswitch default -> 392, 27 -> 400, 28 -> 437
    //   392: iload_1
    //   393: iconst_1
    //   394: iadd
    //   395: i2b
    //   396: istore_1
    //   397: goto -> 289
    //   400: aload_0
    //   401: aload_0
    //   402: getfield enB : Ldm/Battle;
    //   405: invokevirtual getMon : ()Ldm/Monster;
    //   408: bipush #50
    //   410: invokespecial isMonHp : (Ldm/Monster;I)Z
    //   413: ifeq -> 392
    //   416: iload_3
    //   417: bipush #30
    //   419: if_icmpge -> 392
    //   422: aload_0
    //   423: getfield enB : Ldm/Battle;
    //   426: iload_1
    //   427: bipush #6
    //   429: iadd
    //   430: i2b
    //   431: putfield skill : B
    //   434: goto -> 294
    //   437: aload_0
    //   438: aload_0
    //   439: getfield enB : Ldm/Battle;
    //   442: invokevirtual getMon : ()Ldm/Monster;
    //   445: bipush #30
    //   447: invokespecial isMonHp : (Ldm/Monster;I)Z
    //   450: ifeq -> 392
    //   453: iload_3
    //   454: bipush #30
    //   456: if_icmpge -> 392
    //   459: goto -> 422
    //   462: aload_0
    //   463: getfield enB : Ldm/Battle;
    //   466: iconst_0
    //   467: putfield skill : B
    //   470: goto -> 98
    //   473: iload_2
    //   474: bipush #20
    //   476: if_icmpge -> 490
    //   479: aload_0
    //   480: getfield enB : Ldm/Battle;
    //   483: iconst_0
    //   484: putfield skill : B
    //   487: goto -> 98
    //   490: aload_0
    //   491: getfield enB : Ldm/Battle;
    //   494: iconst_1
    //   495: putfield skill : B
    //   498: goto -> 98
    //   501: iload_2
    //   502: iconst_5
    //   503: if_icmpge -> 517
    //   506: aload_0
    //   507: getfield enB : Ldm/Battle;
    //   510: iconst_0
    //   511: putfield skill : B
    //   514: goto -> 98
    //   517: iload_2
    //   518: bipush #40
    //   520: if_icmple -> 534
    //   523: aload_0
    //   524: getfield enB : Ldm/Battle;
    //   527: iconst_2
    //   528: putfield skill : B
    //   531: goto -> 98
    //   534: aload_0
    //   535: getfield enB : Ldm/Battle;
    //   538: iconst_1
    //   539: putfield skill : B
    //   542: goto -> 98
    //   545: iload_2
    //   546: bipush #15
    //   548: if_icmpge -> 562
    //   551: aload_0
    //   552: getfield enB : Ldm/Battle;
    //   555: iconst_1
    //   556: putfield skill : B
    //   559: goto -> 98
    //   562: iload_2
    //   563: bipush #40
    //   565: if_icmpge -> 579
    //   568: aload_0
    //   569: getfield enB : Ldm/Battle;
    //   572: iconst_2
    //   573: putfield skill : B
    //   576: goto -> 98
    //   579: aload_0
    //   580: getfield enB : Ldm/Battle;
    //   583: iconst_3
    //   584: putfield skill : B
    //   587: goto -> 98
    //   590: iload_2
    //   591: bipush #85
    //   593: if_icmpge -> 611
    //   596: aload_0
    //   597: getfield enB : Ldm/Battle;
    //   600: iload #4
    //   602: iconst_2
    //   603: isub
    //   604: i2b
    //   605: putfield skill : B
    //   608: goto -> 98
    //   611: iload_2
    //   612: bipush #95
    //   614: if_icmpge -> 632
    //   617: aload_0
    //   618: getfield enB : Ldm/Battle;
    //   621: iload #4
    //   623: iconst_3
    //   624: isub
    //   625: i2b
    //   626: putfield skill : B
    //   629: goto -> 98
    //   632: aload_0
    //   633: getfield enB : Ldm/Battle;
    //   636: iload #4
    //   638: iconst_4
    //   639: isub
    //   640: i2b
    //   641: putfield skill : B
    //   644: goto -> 98
  }
  
  private void allAdd(int paramInt) {
    boolean bool2 = false;
    boolean bool3 = false;
    if ((this.myMonsters[this.select[0][0]]).monsterPro[0] < 1) {
      say(String.valueOf(getNameMon((this.myMonsters[this.select[0][0]]).monster[0])) + "已经死亡，无法使用！", 0);
      return;
    } 
    boolean bool1 = bool2;
    if ((this.myMonsters[this.select[0][0]]).monsterPro[1] < (this.myMonsters[this.select[0][0]]).monsterPro[3]) {
      bool1 = bool2;
      if ((this.myMonsters[this.select[0][0]]).monsterPro[0] > 0) {
        AddMP((this.myMonsters[this.select[0][0]]).monsterPro[3] * paramInt / 100, this.myMonsters[this.select[0][0]]);
        bool1 = true;
      } 
    } 
    bool2 = bool3;
    if ((this.myMonsters[this.select[0][0]]).monsterPro[0] < (this.myMonsters[this.select[0][0]]).monsterPro[2]) {
      bool2 = bool3;
      if ((this.myMonsters[this.select[0][0]]).monsterPro[0] > 0) {
        AddHP((this.myMonsters[this.select[0][0]]).monsterPro[2] * paramInt / 100, this.myMonsters[this.select[0][0]]);
        bool2 = true;
      } 
    } 
    if (bool2 || bool1) {
      useState(0, this.select_it[0]);
      return;
    } 
    if ((this.myMonsters[this.select[0][0]]).monsterPro[0] < 1) {
      AddHP((this.myMonsters[this.select[0][0]]).monsterPro[2] * paramInt / 100, this.myMonsters[this.select[0][0]]);
      return;
    } 
    say(String.valueOf(getNameMon((this.myMonsters[this.select[0][0]]).monster[0])) + "不需要使用这个道具", 0);
  }
  
  private void arangeMonster() {
    if (this.myMon_length > 1) {
      byte b = 0;
      label15: while (true) {
        if (b < this.myMon_length - 1) {
          for (byte b1 = (byte)(b + 1);; b1 = (byte)(b1 + 1)) {
            if (b1 >= this.myMon_length) {
              b = (byte)(b + 1);
              continue label15;
            } 
            if ((this.myMonsters[b]).monster[1] > (this.myMonsters[b1]).monster[1])
              changeMonster(this.myMonsters[b], this.myMonsters[b1]); 
          } 
          break;
        } 
        return;
      } 
    } 
  }
  
  private boolean bufferAI(Monster paramMonster) {
    return !paramMonster.isMonEffect(0);
  }
  
  private void changeEffect() {
    if ((this.myMonsters[this.select[0][0]]).effect != 7) {
      (this.myMonsters[this.select[0][0]]).effect = 7;
      useState(0, this.select_it[0]);
      return;
    } 
    say(String.valueOf(getNameMon((this.myMonsters[this.select[0][0]]).monster[0])) + "没有异常！", 0);
  }
  
  private boolean changeMon(Battle paramBattle, int paramInt) {
    byte b2;
    byte b = 0;
    byte b1 = paramBattle.now_id;
    while (true) {
      byte b3 = (byte)(paramBattle.now_id + 1);
      paramBattle.now_id = b3;
      if (b3 >= paramInt)
        paramBattle.now_id = 0; 
      b2 = (byte)(b + 1);
      if (b2 <= paramInt) {
        b = b2;
        if (b1 != paramBattle.now_id) {
          b = b2;
          if ((paramBattle.getMon()).monsterPro[0] >= 1)
            break; 
        } 
        continue;
      } 
      break;
    } 
    if (b2 > paramInt)
      paramBattle.now_id = b1; 
    return (b2 <= paramInt);
  }
  
  private void changeMonster(Monster paramMonster1, Monster paramMonster2) {
    Monster monster = new Monster();
    monster.monster = paramMonster1.monster;
    monster.effect = paramMonster1.effect;
    monster.monsterPro = paramMonster1.monsterPro;
    paramMonster1.monster = paramMonster2.monster;
    paramMonster1.effect = paramMonster2.effect;
    paramMonster1.monsterPro = paramMonster2.monsterPro;
    paramMonster2.monster = monster.monster;
    paramMonster2.effect = monster.effect;
    paramMonster2.monsterPro = monster.monsterPro;
  }
  
  private boolean changeMy() {
    for (byte b = 1;; b = (byte)(b + 1)) {
      if (b >= this.myMon_length)
        return false; 
      if ((this.myMonsters[b]).monsterPro[0] > 0) {
        setAimBattle(1);
        goVIEW_MONSTER();
        return true;
      } 
    } 
  }
  
  private void dItemIn(int paramInt1, int paramInt2) {
    while (true) {
      if (paramInt2 >= this.itemsLength[paramInt1] - 1) {
        byte[] arrayOfByte = this.itemsLength;
        arrayOfByte[paramInt1] = (byte)(arrayOfByte[paramInt1] - 1);
        this.items[paramInt1][this.itemsLength[paramInt1]] = null;
        this.items[paramInt1][this.itemsLength[paramInt1]] = new byte[2];
        return;
      } 
      this.items[paramInt1][paramInt2] = this.items[paramInt1][paramInt2 + 1];
      paramInt2++;
    } 
  }
  
  private void damage(Battle paramBattle1, Battle paramBattle2, Monster paramMonster1, Monster paramMonster2, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_3
    //   1: getfield monster : [B
    //   4: iconst_2
    //   5: baload
    //   6: istore #10
    //   8: aload #4
    //   10: getfield monster : [B
    //   13: iconst_2
    //   14: baload
    //   15: istore #7
    //   17: iconst_0
    //   18: istore #6
    //   20: aload_3
    //   21: getfield monsterPro : [S
    //   24: bipush #6
    //   26: saload
    //   27: istore #9
    //   29: aload #4
    //   31: getfield monsterPro : [S
    //   34: bipush #7
    //   36: saload
    //   37: istore #11
    //   39: aload_0
    //   40: getfield skill : [[B
    //   43: iload #5
    //   45: aaload
    //   46: iconst_0
    //   47: baload
    //   48: istore #5
    //   50: iload #10
    //   52: iload #7
    //   54: isub
    //   55: istore #7
    //   57: bipush #100
    //   59: istore #8
    //   61: iload #9
    //   63: iload #5
    //   65: imul
    //   66: sipush #1000
    //   69: iload #11
    //   71: iconst_5
    //   72: imul
    //   73: isub
    //   74: imul
    //   75: sipush #10000
    //   78: idiv
    //   79: istore #9
    //   81: iload #11
    //   83: bipush #10
    //   85: idiv
    //   86: istore #11
    //   88: iload #10
    //   90: iload #5
    //   92: iconst_2
    //   93: imul
    //   94: idiv
    //   95: istore #12
    //   97: iload #10
    //   99: iconst_1
    //   100: isub
    //   101: bipush #10
    //   103: idiv
    //   104: istore #10
    //   106: iload #7
    //   108: bipush #10
    //   110: if_icmple -> 325
    //   113: bipush #10
    //   115: istore #5
    //   117: iload #5
    //   119: iconst_4
    //   120: imul
    //   121: bipush #100
    //   123: iadd
    //   124: iload #9
    //   126: iload #11
    //   128: isub
    //   129: iload #12
    //   131: isub
    //   132: bipush #6
    //   134: iadd
    //   135: iload #10
    //   137: isub
    //   138: imul
    //   139: bipush #100
    //   141: idiv
    //   142: istore #7
    //   144: iload #6
    //   146: istore #5
    //   148: aload #4
    //   150: getfield effect : B
    //   153: ifne -> 160
    //   156: bipush #-30
    //   158: istore #5
    //   160: aload_1
    //   161: getfield countS : [B
    //   164: iconst_1
    //   165: baload
    //   166: iload #5
    //   168: iadd
    //   169: bipush #100
    //   171: iadd
    //   172: iload #7
    //   174: imul
    //   175: bipush #100
    //   177: idiv
    //   178: istore #9
    //   180: iconst_1
    //   181: istore #7
    //   183: aload_3
    //   184: bipush #9
    //   186: invokevirtual isBuffRate : (I)Z
    //   189: ifeq -> 211
    //   192: invokestatic i : ()Ldm/Ms;
    //   195: pop
    //   196: bipush #100
    //   198: invokestatic getRandom : (I)I
    //   201: aload_0
    //   202: getfield inhesion : [B
    //   205: bipush #9
    //   207: baload
    //   208: if_icmplt -> 242
    //   211: aload #4
    //   213: bipush #48
    //   215: invokevirtual isMonReel : (I)Z
    //   218: ifeq -> 343
    //   221: invokestatic i : ()Ldm/Ms;
    //   224: pop
    //   225: bipush #100
    //   227: invokestatic getRandom : (I)I
    //   230: aload_0
    //   231: getfield skill : [[B
    //   234: bipush #48
    //   236: aaload
    //   237: iconst_0
    //   238: baload
    //   239: if_icmpge -> 343
    //   242: iload #9
    //   244: iconst_1
    //   245: ishr
    //   246: istore #5
    //   248: iload #7
    //   250: istore #6
    //   252: iload #8
    //   254: istore #7
    //   256: aload #4
    //   258: getfield monster : [B
    //   261: iconst_3
    //   262: baload
    //   263: iconst_1
    //   264: if_icmpne -> 292
    //   267: iload #8
    //   269: istore #7
    //   271: aload #4
    //   273: bipush #33
    //   275: invokevirtual isMonReel : (I)Z
    //   278: ifeq -> 292
    //   281: aload_0
    //   282: getfield skill : [[B
    //   285: bipush #33
    //   287: aaload
    //   288: iconst_0
    //   289: baload
    //   290: istore #7
    //   292: iload #5
    //   294: iload #7
    //   296: imul
    //   297: bipush #100
    //   299: idiv
    //   300: istore #7
    //   302: iload #7
    //   304: istore #5
    //   306: iload #7
    //   308: iconst_1
    //   309: if_icmpge -> 315
    //   312: iconst_1
    //   313: istore #5
    //   315: aload_2
    //   316: iload #5
    //   318: iload #6
    //   320: iconst_0
    //   321: invokevirtual addHit : (III)V
    //   324: return
    //   325: iload #7
    //   327: istore #5
    //   329: iload #7
    //   331: bipush #-10
    //   333: if_icmpge -> 117
    //   336: bipush #-10
    //   338: istore #5
    //   340: goto -> 117
    //   343: iload #7
    //   345: istore #6
    //   347: iload #9
    //   349: istore #5
    //   351: aload_3
    //   352: bipush #10
    //   354: invokevirtual isBuffRate : (I)Z
    //   357: ifeq -> 252
    //   360: invokestatic i : ()Ldm/Ms;
    //   363: pop
    //   364: iload #7
    //   366: istore #6
    //   368: iload #9
    //   370: istore #5
    //   372: bipush #100
    //   374: invokestatic getRandom : (I)I
    //   377: aload_0
    //   378: getfield inhesion : [B
    //   381: bipush #10
    //   383: baload
    //   384: if_icmpge -> 252
    //   387: iload #9
    //   389: bipush #15
    //   391: imul
    //   392: bipush #10
    //   394: idiv
    //   395: istore #5
    //   397: iconst_2
    //   398: istore #6
    //   400: goto -> 252
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
  
  private void delItemEvolve(byte paramByte) {
    byte b1;
    byte b = 2;
    do {
      deleteItems(this.monsterMake[paramByte][b], this.monsterMake[paramByte][b + 1]);
      b1 = (byte)(b + 2);
      b = b1;
    } while (b1 < (this.monsterMake[paramByte]).length - 1);
  }
  
  private void delItemSkill(Monster paramMonster) {
    say(String.valueOf(getNameMon(paramMonster.monster[0])) + "习得技能：" + getNameSkill(this.getSkill), 0);
    goMY_BAG(2);
    deleteItems(this.getSkill + 35 - 25 - 1, 1);
    Ms.i().correctSelect(this.select[0], this.itemsLength[this.selectx], this.list_rows);
  }
  
  private void doBuffValue(Battle paramBattle) {
    if ((paramBattle.getMon()).monsterPro[0] >= 1 && paramBattle.getMon().isBuffRate(4))
      paramBattle.addHit(-(paramBattle.getMon()).monsterPro[2] * this.inhesion[4] / 100, 1, 1); 
  }
  
  private void doEffectValue(Battle paramBattle) {
    short s1 = 0;
    if (paramBattle.getMon().isMonEffect(2)) {
      s1 = (short)((paramBattle.getMon()).monsterPro[0] / 10);
    } else if (paramBattle.getMon().isMonEffect(5)) {
      s1 = (short)(paramBattle.fs_level * paramBattle.fs_level + 4);
    } 
    short s2 = s1;
    if (paramBattle.getMon().isMonReel(3))
      s2 = (short)(this.inhesion[3] * s1 / 100 + s1); 
    if (s2 != 0)
      paramBattle.addHit(s2, 1, 0); 
  }
  
  private void drawAnimationBattle(Battle paramBattle, int paramInt) {
    if (paramBattle.action == 0) {
      byte b2 = (byte)(paramBattle.skill / 5);
      byte b1 = (byte)(paramBattle.skill % 5);
      paramInt = b2;
      if (b2 > 5)
        paramInt = 5; 
      if (paramInt == 5)
        b1 = (byte)(paramBattle.skill - 25); 
      if (drawMagicC(paramInt, paramInt, b1, getBXY(this.mini_state, paramBattle.skill, true), getBXY(this.mini_state, paramBattle.skill, false), this.mini_state ^ 0x1)) {
        if (this.mini_state == 1) {
          short[] arrayOfShort = (paramBattle.getMon()).monsterPro;
          arrayOfShort[1] = (short)(arrayOfShort[1] - getSkillMana(paramBattle.getMon(), paramBattle.skill));
          valueMend(paramBattle.getMon());
        } 
        runHit();
      } 
    } 
  }
  
  private void drawBG0(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    Ui.i().fillRect(5422575, paramInt2 - 1, 0, paramInt5 + 13, 360 - 2);
    Ui.i().drawImage(this.imgBG[paramInt1], 320, 0, 17);
    Ui.i().drawK2(paramInt2, paramInt3, 640 - (paramInt2 << 1), 360 - paramInt3, 0);
    Ui.i().drawK1(paramInt2 + 5, paramInt3 + 25 + 7 + paramInt4, paramInt5, 360 - paramInt3 - 36 - paramInt4, 1);
    Ui.i().drawK(paramInt2 + 7, 360 - 50 - 22, paramInt5 - 4, 58, 3);
  }
  
  private void drawBUY_ITEM() {
    // Byte code:
    //   0: invokestatic i : ()Ldm/Ui;
    //   3: invokevirtual fillRectB : ()V
    //   6: invokestatic i : ()Ldm/Ui;
    //   9: iconst_1
    //   10: iconst_2
    //   11: sipush #640
    //   14: iconst_2
    //   15: isub
    //   16: sipush #360
    //   19: iconst_2
    //   20: isub
    //   21: iconst_0
    //   22: invokevirtual drawK2 : (IIIII)V
    //   25: iconst_0
    //   26: istore_2
    //   27: aload_0
    //   28: getfield cur_b : B
    //   31: ifne -> 593
    //   34: invokestatic i : ()Ldm/Ui;
    //   37: sipush #320
    //   40: bipush #29
    //   42: isub
    //   43: bipush #6
    //   45: bipush #58
    //   47: bipush #28
    //   49: iconst_4
    //   50: invokevirtual drawK1 : (IIIII)V
    //   53: invokestatic i : ()Ldm/Ui;
    //   56: aload_0
    //   57: getfield action_str : [Ljava/lang/String;
    //   60: aload_0
    //   61: getfield cur_a : B
    //   64: aaload
    //   65: sipush #320
    //   68: iconst_5
    //   69: bipush #17
    //   71: iconst_0
    //   72: iconst_0
    //   73: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   76: invokestatic i : ()Ldm/Ui;
    //   79: bipush #6
    //   81: bipush #37
    //   83: sipush #640
    //   86: bipush #26
    //   88: isub
    //   89: aload_0
    //   90: getfield list_rows : B
    //   93: bipush #30
    //   95: imul
    //   96: bipush #6
    //   98: iadd
    //   99: iconst_1
    //   100: invokevirtual drawK1 : (IIIII)V
    //   103: invokestatic i : ()Ldm/Ui;
    //   106: bipush #6
    //   108: aload_0
    //   109: getfield list_rows : B
    //   112: bipush #30
    //   114: imul
    //   115: bipush #37
    //   117: iadd
    //   118: bipush #16
    //   120: iadd
    //   121: sipush #640
    //   124: bipush #12
    //   126: isub
    //   127: bipush #30
    //   129: iconst_3
    //   130: imul
    //   131: iconst_2
    //   132: invokevirtual drawK1 : (IIIII)V
    //   135: aload_0
    //   136: getfield cur_b : B
    //   139: iconst_1
    //   140: if_icmpne -> 745
    //   143: aload_0
    //   144: getfield itemsLength : [B
    //   147: aload_0
    //   148: getfield cur_a : B
    //   151: baload
    //   152: istore_2
    //   153: iload_2
    //   154: i2b
    //   155: istore #4
    //   157: aload_0
    //   158: getfield list_rows : B
    //   161: istore_3
    //   162: aload_0
    //   163: getfield select : [[B
    //   166: iconst_0
    //   167: aaload
    //   168: astore #7
    //   170: aload_0
    //   171: getfield cur_a : B
    //   174: istore #5
    //   176: aload_0
    //   177: getfield cur_b : B
    //   180: iconst_1
    //   181: if_icmpne -> 759
    //   184: iconst_2
    //   185: istore_2
    //   186: aload_0
    //   187: bipush #10
    //   189: bipush #37
    //   191: iconst_3
    //   192: iadd
    //   193: sipush #640
    //   196: bipush #26
    //   198: isub
    //   199: iload_3
    //   200: aload #7
    //   202: iload #5
    //   204: iload #4
    //   206: iload_2
    //   207: invokespecial drawItemList : (IIII[BIII)V
    //   210: invokestatic i : ()Ldm/Ui;
    //   213: sipush #640
    //   216: bipush #15
    //   218: isub
    //   219: bipush #37
    //   221: iconst_5
    //   222: iadd
    //   223: aload_0
    //   224: getfield list_rows : B
    //   227: bipush #30
    //   229: imul
    //   230: bipush #6
    //   232: isub
    //   233: aload_0
    //   234: getfield select : [[B
    //   237: iconst_0
    //   238: aaload
    //   239: iconst_0
    //   240: baload
    //   241: iload #4
    //   243: iconst_1
    //   244: invokevirtual sliding : (IIIIIZ)V
    //   247: iload #4
    //   249: istore_3
    //   250: iload #4
    //   252: ifle -> 330
    //   255: aload_0
    //   256: getfield cur_b : B
    //   259: iconst_1
    //   260: if_icmpne -> 764
    //   263: aload_0
    //   264: getfield items : [[[B
    //   267: aload_0
    //   268: getfield cur_a : B
    //   271: aaload
    //   272: aload_0
    //   273: getfield select : [[B
    //   276: iconst_0
    //   277: aaload
    //   278: iconst_0
    //   279: baload
    //   280: aaload
    //   281: iconst_0
    //   282: baload
    //   283: istore_2
    //   284: aload_0
    //   285: getfield item_help : [Ljava/lang/StringBuffer;
    //   288: iload_2
    //   289: aaload
    //   290: invokevirtual toString : ()Ljava/lang/String;
    //   293: ldc_w '复活死亡的宠物并为其回复生命值的'
    //   296: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   299: ifeq -> 786
    //   302: aload_0
    //   303: ldc_w '复活死亡的宠物并为其回复生命值的30%,请勿在宠物战斗中购买!'
    //   306: sipush #320
    //   309: aload_0
    //   310: getfield list_rows : B
    //   313: bipush #30
    //   315: imul
    //   316: bipush #37
    //   318: iadd
    //   319: bipush #18
    //   321: iadd
    //   322: bipush #10
    //   324: iconst_3
    //   325: invokevirtual showStringM : (Ljava/lang/String;IIII)V
    //   328: iload_2
    //   329: istore_3
    //   330: aload_0
    //   331: getfield cur_b : B
    //   334: iconst_1
    //   335: if_icmpeq -> 823
    //   338: aload_0
    //   339: getfield cur_a : B
    //   342: iconst_2
    //   343: if_icmpne -> 823
    //   346: iconst_1
    //   347: istore #6
    //   349: aload_0
    //   350: sipush #320
    //   353: sipush #360
    //   356: iconst_2
    //   357: isub
    //   358: iconst_0
    //   359: iload #6
    //   361: invokevirtual drawMoney : (IIIZ)V
    //   364: aload_0
    //   365: getfield popMenu : B
    //   368: iconst_m1
    //   369: if_icmpeq -> 584
    //   372: aload_0
    //   373: getfield buyOk : B
    //   376: iconst_1
    //   377: if_icmpne -> 829
    //   380: aload_0
    //   381: getfield cur_b : B
    //   384: iconst_1
    //   385: if_icmpeq -> 829
    //   388: aload_0
    //   389: getfield buyItem : [[B
    //   392: aload_0
    //   393: getfield cur_a : B
    //   396: aaload
    //   397: aload_0
    //   398: getfield select : [[B
    //   401: iconst_0
    //   402: aaload
    //   403: iconst_0
    //   404: baload
    //   405: baload
    //   406: bipush #35
    //   408: if_icmplt -> 829
    //   411: aload_0
    //   412: getfield makeLevel : [B
    //   415: aload_0
    //   416: getfield buyItem : [[B
    //   419: aload_0
    //   420: getfield cur_a : B
    //   423: aaload
    //   424: aload_0
    //   425: getfield select : [[B
    //   428: iconst_0
    //   429: aaload
    //   430: iconst_0
    //   431: baload
    //   432: baload
    //   433: bipush #35
    //   435: isub
    //   436: baload
    //   437: aload_0
    //   438: getfield rmsOther : [B
    //   441: iconst_3
    //   442: baload
    //   443: if_icmple -> 829
    //   446: invokestatic i : ()Ldm/Ui;
    //   449: bipush #-5
    //   451: sipush #180
    //   454: bipush #50
    //   456: isub
    //   457: sipush #640
    //   460: bipush #10
    //   462: iadd
    //   463: bipush #108
    //   465: invokevirtual drawKuang : (IIII)V
    //   468: aload_0
    //   469: new java/lang/StringBuilder
    //   472: dup
    //   473: ldc_w '需要训练师'
    //   476: invokespecial <init> : (Ljava/lang/String;)V
    //   479: aload_0
    //   480: getfield makeLevel : [B
    //   483: aload_0
    //   484: getfield buyItem : [[B
    //   487: aload_0
    //   488: getfield cur_a : B
    //   491: aaload
    //   492: aload_0
    //   493: getfield select : [[B
    //   496: iconst_0
    //   497: aaload
    //   498: iconst_0
    //   499: baload
    //   500: baload
    //   501: bipush #35
    //   503: isub
    //   504: baload
    //   505: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   508: ldc_w '级才能学习！'
    //   511: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual toString : ()Ljava/lang/String;
    //   517: sipush #320
    //   520: sipush #180
    //   523: bipush #25
    //   525: isub
    //   526: bipush #12
    //   528: bipush #9
    //   530: invokevirtual showStringM : (Ljava/lang/String;IIII)V
    //   533: aload_0
    //   534: ldc_w '是否购买？'
    //   537: sipush #180
    //   540: bipush #25
    //   542: iadd
    //   543: iconst_0
    //   544: invokevirtual showString : (Ljava/lang/String;II)V
    //   547: aload_0
    //   548: getfield pkey : Lmain/PointerKey;
    //   551: iconst_2
    //   552: iconst_0
    //   553: iconst_0
    //   554: sipush #320
    //   557: sipush #360
    //   560: invokevirtual selectMenuX : (IIIII)B
    //   563: istore_2
    //   564: iload_2
    //   565: iconst_m1
    //   566: if_icmpeq -> 584
    //   569: iload_2
    //   570: ifne -> 879
    //   573: bipush #-3
    //   575: istore_2
    //   576: iload_2
    //   577: putstatic dm/Ms.key : I
    //   580: iconst_1
    //   581: putstatic dm/Ms.keyRepeat : Z
    //   584: invokestatic i : ()Ldm/Ui;
    //   587: iconst_1
    //   588: iconst_1
    //   589: invokevirtual drawYesNo : (ZZ)V
    //   592: return
    //   593: invokestatic i : ()Ldm/Ui;
    //   596: aload_0
    //   597: getfield cur_a : B
    //   600: sipush #210
    //   603: imul
    //   604: bipush #70
    //   606: iadd
    //   607: bipush #6
    //   609: bipush #70
    //   611: bipush #28
    //   613: iconst_4
    //   614: invokevirtual drawK1 : (IIIII)V
    //   617: iload_2
    //   618: iconst_3
    //   619: if_icmplt -> 690
    //   622: aload_0
    //   623: getfield pkey : Lmain/PointerKey;
    //   626: iconst_3
    //   627: bipush #70
    //   629: iconst_0
    //   630: sipush #210
    //   633: bipush #62
    //   635: invokevirtual selectMenuX : (IIIII)B
    //   638: istore_1
    //   639: iload_1
    //   640: iconst_m1
    //   641: if_icmpeq -> 671
    //   644: aload_0
    //   645: iload_1
    //   646: putfield cur_a : B
    //   649: aload_0
    //   650: getfield select : [[B
    //   653: iconst_0
    //   654: aaload
    //   655: astore #7
    //   657: aload_0
    //   658: getfield select : [[B
    //   661: iconst_0
    //   662: aaload
    //   663: iconst_0
    //   664: iconst_0
    //   665: bastore
    //   666: aload #7
    //   668: iconst_1
    //   669: iconst_0
    //   670: bastore
    //   671: invokestatic i : ()Ldm/Ui;
    //   674: sipush #320
    //   677: bipush #15
    //   679: sipush #329
    //   682: iconst_1
    //   683: iconst_1
    //   684: invokevirtual drawTriangle : (IIIZZ)V
    //   687: goto -> 76
    //   690: invokestatic i : ()Ldm/Ui;
    //   693: astore #8
    //   695: aload_0
    //   696: getfield action_str : [Ljava/lang/String;
    //   699: iload_2
    //   700: aaload
    //   701: astore #7
    //   703: aload_0
    //   704: getfield cur_a : B
    //   707: iload_2
    //   708: if_icmpne -> 740
    //   711: iconst_0
    //   712: istore_3
    //   713: aload #8
    //   715: aload #7
    //   717: iload_2
    //   718: sipush #210
    //   721: imul
    //   722: bipush #80
    //   724: iadd
    //   725: iconst_5
    //   726: iconst_0
    //   727: iload_3
    //   728: iconst_0
    //   729: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   732: iload_2
    //   733: iconst_1
    //   734: iadd
    //   735: i2b
    //   736: istore_2
    //   737: goto -> 617
    //   740: iconst_4
    //   741: istore_3
    //   742: goto -> 713
    //   745: aload_0
    //   746: getfield buyItem : [[B
    //   749: aload_0
    //   750: getfield cur_a : B
    //   753: aaload
    //   754: arraylength
    //   755: istore_2
    //   756: goto -> 153
    //   759: iconst_1
    //   760: istore_2
    //   761: goto -> 186
    //   764: aload_0
    //   765: getfield buyItem : [[B
    //   768: aload_0
    //   769: getfield cur_a : B
    //   772: aaload
    //   773: aload_0
    //   774: getfield select : [[B
    //   777: iconst_0
    //   778: aaload
    //   779: iconst_0
    //   780: baload
    //   781: baload
    //   782: istore_2
    //   783: goto -> 284
    //   786: aload_0
    //   787: aload_0
    //   788: getfield item_help : [Ljava/lang/StringBuffer;
    //   791: iload_2
    //   792: aaload
    //   793: invokevirtual toString : ()Ljava/lang/String;
    //   796: sipush #320
    //   799: aload_0
    //   800: getfield list_rows : B
    //   803: bipush #30
    //   805: imul
    //   806: bipush #37
    //   808: iadd
    //   809: bipush #18
    //   811: iadd
    //   812: bipush #10
    //   814: iconst_3
    //   815: invokevirtual showStringM : (Ljava/lang/String;IIII)V
    //   818: iload_2
    //   819: istore_3
    //   820: goto -> 330
    //   823: iconst_0
    //   824: istore #6
    //   826: goto -> 349
    //   829: aload_0
    //   830: getfield cur_b : B
    //   833: iconst_1
    //   834: if_icmpne -> 859
    //   837: iconst_1
    //   838: istore_2
    //   839: aload_0
    //   840: iload_3
    //   841: sipush #320
    //   844: sipush #180
    //   847: sipush #150
    //   850: bipush #50
    //   852: iload_2
    //   853: invokespecial drawBuy : (IIIIII)V
    //   856: goto -> 547
    //   859: aload_0
    //   860: getfield cur_a : B
    //   863: iconst_2
    //   864: if_icmpne -> 873
    //   867: bipush #16
    //   869: istore_2
    //   870: goto -> 839
    //   873: bipush #17
    //   875: istore_2
    //   876: goto -> 839
    //   879: bipush #-4
    //   881: istore_2
    //   882: goto -> 576
  }
  
  private void drawBattleBG() {
    Ui.i().fillRectB();
    Ui.i().drawImage(this.imgBG[this.enB.bg_id], 200, 20, 0);
    Ui ui = Ui.i();
    Image image = this.imgBG[this.myB.bg_id];
    DirectGraphics directGraphics = dg;
    ui.drawImage(image, 200, 144, 0, DirectGraphics.FLIP_HORIZONTAL);
    Ui.i().drawK2(2, 19, 195, 250, 0);
  }
  
  private void drawBattleExp(Monster paramMonster, int paramInt) {
    short s;
    Ui.i().drawK0(200, paramInt, 240, 10, 0);
    if (this.battle_state != -5) {
      s = paramMonster.monsterPro[4];
    } else {
      s = this.myB.cexp;
    } 
    drawMonsterHp(paramMonster, 240, paramInt + 3, 195, 2, 2, s);
    Ui.i().drawString("经验", 200, paramInt + 18, 36, 0, 2);
  }
  
  private void drawBuffList(Monster paramMonster, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfbyte) {
    byte b = 0;
    Ui.i().drawListKY(paramInt5, paramInt1, paramInt2, paramInt3, 3, paramInt4, 0, paramArrayOfbyte[0] - paramArrayOfbyte[1], 4, 2);
    while (true) {
      if (b >= 2)
        return; 
      if (b <= 0 || paramMonster.monster[b + 16] >= 1) {
        Ui.i().drawUi(49, paramInt1 + 8, paramInt2 + 8 + (b - this.select[0][1]) * paramInt4, 0, 0);
        Ui ui = Ui.i();
        String str = getNameBuff(paramMonster.monster[b + 16]);
        byte b1 = this.select[0][1];
        if (paramArrayOfbyte[0] == b) {
          paramInt5 = 0;
        } else {
          paramInt5 = 3;
        } 
        ui.drawString(str, paramInt1 + 21, paramInt2 + 1 + (b - b1) * paramInt4, 0, paramInt5, 0);
        if (this.pkey.isSelect(paramInt1, paramInt2 + 1 + (b - paramArrayOfbyte[1]) * paramInt4, paramInt3, paramInt4))
          paramArrayOfbyte[0] = b; 
      } 
      b = (byte)(b + 1);
    } 
  }
  
  private void drawBuy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    byte b;
    boolean bool;
    Ui.i().drawKuang(paramInt2 - paramInt4, paramInt3 - paramInt5, paramInt4 << 1, paramInt5 << 1);
    if ((paramInt6 & 0x10) != 0) {
      b = 2;
    } else {
      b = 12;
    } 
    paramInt5 = paramInt3 - paramInt5 + b;
    Ui.i().drawString("数量：" + this.popMenu + "/" + this.t_length, paramInt2, paramInt5, 17, 3, 0);
    StringBuffer stringBuffer = new StringBuffer();
    if ((paramInt6 & 0x10) != 0) {
      stringBuffer.append("需要：");
    } else {
      stringBuffer.append("获得：");
    } 
    stringBuffer.append(this.sell_money * this.popMenu);
    if ((paramInt6 & 0x1) != 0) {
      stringBuffer.append("金");
    } else {
      stringBuffer.append("徽章");
    } 
    Ui.i().drawString(stringBuffer.toString(), paramInt2, paramInt5 + 25 + 4, 17, 6, 0);
    if ((paramInt6 & 0x10) != 0)
      Ui.i().drawString("现有：" + findItem(-2, paramInt1, true), paramInt2, paramInt5 + 58, 17, 3, 0); 
    Ui ui = Ui.i();
    if (this.cur_b != 2) {
      bool = true;
    } else {
      bool = false;
    } 
    ui.drawTriangle1(paramInt2, paramInt3 - 2, paramInt4, true, bool);
    if (this.buyOk == 1) {
      String str;
      StringBuilder stringBuilder = new StringBuilder("是否");
      if ((paramInt6 & 0x10) != 0) {
        str = "购买";
      } else {
        str = "卖出";
      } 
      showString(stringBuilder.append(str).append("？").toString(), Constants_H.HEIGHT_H + 25, 0);
    } 
  }
  
  private void drawClipPic(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9) {
    int i = 1;
    byte b = (byte)(paramInt5 / paramInt7);
    paramInt5 = (short)(2 << paramInt8);
    paramInt8 = i;
    while (true) {
      if (paramInt8 >= paramInt7)
        return; 
      Graphics graphics = g;
      if (b - paramInt5 <= 0) {
        i = b;
      } else {
        i = paramInt5;
      } 
      graphics.clipRect(paramInt3 - paramInt8 * b, paramInt4 - paramInt6, i, paramInt6 + 20);
      drawCartoonOne(paramInt2, paramInt2, paramInt1 * 3, paramInt3, paramInt4, true, paramInt9);
      g.setClip(0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
      graphics = g;
      if (b - paramInt5 <= 0) {
        i = b;
      } else {
        i = paramInt5;
      } 
      graphics.clipRect((paramInt8 - 1) * b + paramInt3, paramInt4 - paramInt6, i, paramInt6 + 20);
      drawCartoonOne(paramInt2, paramInt2, paramInt1 * 3, paramInt3, paramInt4, true, paramInt9);
      g.setClip(0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
      paramInt8 = (byte)(paramInt8 + 1);
      paramInt5 = (short)(paramInt5 / 2);
    } 
  }
  
  private void drawColorLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
    if ((0xFF000000 & paramInt9) != 0) {
      g.setColor(paramInt9);
      g.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
    } 
    g.setColor(paramInt10);
    paramInt9 = 1;
    paramInt10 = 1;
    if (paramInt8 == 1) {
      paramInt9 = paramInt6;
      paramInt6 = paramInt2;
      paramInt8 = paramInt10;
      while (true) {
        if (paramInt6 < paramInt2 + paramInt4) {
          g.fillRect(paramInt1, paramInt6, paramInt3, paramInt5);
          paramInt10 = paramInt6 + paramInt5 + paramInt8;
          int i = paramInt5 - paramInt7;
          paramInt6 = paramInt10;
          paramInt5 = i;
          if (i <= 0) {
            paramInt9--;
            paramInt5 = paramInt8;
            if (paramInt8 < paramInt9)
              paramInt5 = paramInt8 + 1; 
            i = 1;
            paramInt8 = paramInt5;
            paramInt6 = paramInt10;
            paramInt5 = i;
          } 
          continue;
        } 
        return;
      } 
    } 
    if (paramInt8 == 2) {
      paramInt4 = paramInt2 + paramInt4;
      paramInt8 = paramInt6;
      paramInt6 = paramInt4;
      paramInt4 = paramInt9;
      while (true) {
        if (paramInt6 > paramInt2) {
          g.fillRect(paramInt1, paramInt6 - paramInt5, paramInt3, paramInt5);
          paramInt9 = paramInt6 - paramInt5 - paramInt4;
          paramInt10 = paramInt5 - paramInt7;
          paramInt6 = paramInt9;
          paramInt5 = paramInt10;
          if (paramInt10 <= 0) {
            paramInt8--;
            paramInt5 = paramInt4;
            if (paramInt4 < paramInt8)
              paramInt5 = paramInt4 + 1; 
            paramInt10 = 1;
            paramInt4 = paramInt5;
            paramInt6 = paramInt9;
            paramInt5 = paramInt10;
          } 
          continue;
        } 
        return;
      } 
    } 
  }
  
  private void drawDarkScreen() {
    drawColorLine(0, 0, 640, 360, this.b_c + 1, 6, 1, 2, 16777215, 4802889);
  }
  
  private void drawEffectImage(Monster paramMonster, int paramInt1, int paramInt2) {
    if (paramMonster.effect > -1 && paramMonster.effect < 7 && paramMonster.effect_time > 0) {
      Ui ui = Ui.i();
      Image image = this.effectImage[paramMonster.effect];
      Graphics graphics2 = g;
      graphics2 = g;
      ui.drawImage(image, paramInt1, paramInt2, 0x8 | 0x20);
      ui = Ui.i();
      byte b = paramMonster.effect_time;
      Graphics graphics1 = g;
      graphics1 = g;
      ui.drawNum(b, paramInt1, paramInt2, 0x8 | 0x20, 0);
    } 
  }
  
  private void drawEnemy() {
    drawEffectImage(this.enB.getMon(), 435, 40);
    if ((this.enB.getMon()).monsterPro[0] >= 1 || this.enB.dead != 1) {
      byte b;
      boolean bool;
      byte b1 = this.mList_id[(this.enB.getMon()).monster[0]][1];
      byte b2 = this.enB.action;
      if (this.enB.ceff[0] != 0) {
        b = 3;
      } else {
        b = 0;
      } 
      if (this.enB.ceff[0] != 0) {
        s = -3;
      } else {
        s = 0;
      } 
      if (this.enB.action == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      if (drawCartoonOne(0, 0, b1 * 3 + b2, b + 377, s + 97, bool, 0))
        if ((this.enB.getMon()).monsterPro[0] < 1) {
          this.enB.action = 2;
          this.enB.dead = 1;
        } else if (this.enB.dead != 1) {
          this.enB.action = 0;
        }  
      this.enB.ceff[0] = (byte)Ms.i().mathSpeedN(this.enB.ceff[0], 0, 1, true);
      drawMonsterHp(this.enB.getMon(), 352, 97, 50, 0, 1, this.enB.chp);
      Battle battle = this.enB;
      Ms ms = Ms.i();
      short s = this.enB.chp;
      short s1 = (this.enB.getMon()).monsterPro[0];
      if (this.enB.chp < (this.enB.getMon()).monsterPro[0]) {
        b = 20;
      } else {
        b = 6;
      } 
      battle.chp = ms.mathSpeedN(s, s1, b, true);
    } 
  }
  
  private void drawEnemyState() {
    byte b;
    String str;
    Ui.i().drawK(10, 25, 179, 110, 2);
    Ui.i().drawKuang(10 + 2, 25 + 2, 147, 33);
    if ((this.enB.getMon()).monster[3] != -1)
      Ui.i().drawUi((this.enB.getMon()).monster[3] + 5, 10 + 16, 25 + 16, 3, 0); 
    Ui.i().drawString(getNameMon((this.enB.getMon()).monster[0]).toString(), 10 + 75 + 14, 25 + 1, 17, 4, 2);
    Ui.i().drawNum(String.valueOf((this.enB.getMon()).monster[2]) + "级", 10 + 125 + 27, 25 + 20, 0, 0);
    Ui.i().drawK0(10 + 2, 25 + 25 + 11, 62, 14, 4);
    Ui.i().drawUi(34, 10 + 4, 25 + 25 + 12, 0, 0);
    Ui.i().drawNum(String.valueOf(this.enB.countS[0] + 100) + "%", 10 + 60, 25 + 25 + 24, 1, 1);
    Ui.i().drawString("宠物档次", 10 + 2, 25 + 25 + 30, 20, 4, 2);
    drawMonKind((this.enB.getMon()).monster[4], 10 + 100 + 8, 25 + 25 + 38, 0);
    Ui ui2 = Ui.i();
    if (this.monInfoList[(this.enB.getMon()).monster[0]] == 2) {
      str = "已捕获";
    } else {
      str = "未捕获";
    } 
    ui2.drawString(str, 10 + 2, 25 + 50 + 32, 20, 4, 2);
    Ui ui1 = Ui.i();
    if (this.monInfoList[(this.enB.getMon()).monster[0]] == 2) {
      b = 25;
    } else {
      b = 26;
    } 
    ui1.drawUi(b, 10 + 100 + 4, 25 + 50 + 40, 0, 0);
  }
  
  private void drawEvolveMake(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    byte b2 = 2;
    byte b1 = 0;
    while (true) {
      Ui.i().drawString(String.valueOf(getNameItem(this.monsterMake[paramInt1][b2])) + "（" + findItem(-2, this.monsterMake[paramInt1][b2], true) + "/" + this.monsterMake[paramInt1][b2 + 1] + "）", paramInt2, paramInt3 + b1 * paramInt4, 0, 3, 0);
      byte b4 = (byte)(b2 + 2);
      byte b3 = (byte)(b1 + 1);
      b2 = b4;
      b1 = b3;
      if (b4 >= (this.monsterMake[paramInt1]).length - 1) {
        if (this.monsterMake[paramInt1][0] > 0) {
          paramInt1 = findItem(-2, 34, true);
          if (paramInt1 > 0)
            Ui.i().drawString(String.valueOf(getNameItem(34)) + "（" + paramInt1 + "/" + '\001' + "）", paramInt2, paramInt3 + b3 * paramInt4, 0, -1, 0); 
        } 
        return;
      } 
    } 
  }
  
  private boolean drawHitOne(Battle paramBattle1, Battle paramBattle2, int paramInt1, int paramInt2) {
    boolean bool = true;
    this.strHit = "";
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= paramBattle1.hit.length) {
        valueMend(paramBattle1.getMon());
        return bool;
      } 
      if (paramBattle1.hit[b][4] < this.zb.length) {
        boolean bool1 = false;
        if (paramBattle1.hit[b][0] == -1) {
          this.strHit = "闪避";
        } else if (paramBattle1.hit[b][0] == -2) {
          this.strHit = "忠诚度减少";
        } else {
          String str;
          if (paramBattle1.hit[b][1] > -1) {
            str = "-";
          } else {
            str = "+";
          } 
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str));
          Ms.i();
          this.strHit = stringBuilder.append(Ms.abs(paramBattle1.hit[b][1])).toString();
        } 
        if (paramBattle1.hit[b][0] > 0 && paramBattle1.hit[b][0] < 4) {
          boolean bool2;
          if (paramBattle1.hit[b][0] == 2) {
            Ui.i().drawUi(32, paramBattle1.hit[b][2] + paramInt1 + (this.strHit.length() >> 1) * 14 + 15, paramBattle1.hit[b][3] + paramInt2 + 8, 40, 0);
            Ui.i().drawUi(33, paramBattle1.hit[b][2] + paramInt1 + (this.strHit.length() >> 1) * 14 + 15, paramBattle1.hit[b][3] + paramInt2 + 8, 36, 0);
          } 
          Ui ui = Ui.i();
          String str = this.strHit;
          short s2 = paramBattle1.hit[b][2];
          short s1 = paramBattle1.hit[b][3];
          if (paramBattle1.hit[b][0] == 2) {
            bool2 = true;
          } else {
            bool2 = true;
          } 
          ui.drawNum(str, s2 + paramInt1, s1 + paramInt2, 0, bool2);
        } else if (paramBattle1.hit[b][0] < 0 || paramBattle1.hit[b][0] == 4) {
          boolean bool2;
          Ui ui = Ui.i();
          String str = this.strHit;
          short s1 = paramBattle1.hit[b][2];
          short s2 = paramBattle1.hit[b][3];
          if (paramBattle1.hit[b][0] == 4) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          ui.drawString(str, s1 + paramInt1, s2 + paramInt2, 0, bool2, 2);
        } 
        if (b == 0) {
          byte b1;
          short[] arrayOfShort1 = paramBattle1.hit[b];
          short s1 = arrayOfShort1[2];
          if (this.mini_state == 1) {
            b1 = 1;
          } else {
            b1 = -1;
          } 
          arrayOfShort1[2] = (short)(s1 + b1);
          arrayOfShort1 = paramBattle1.hit[b];
          arrayOfShort1[3] = (short)(arrayOfShort1[3] + this.zb[paramBattle1.hit[b][4]]);
        } else if (b == 1) {
          byte b1;
          short[] arrayOfShort1 = paramBattle1.hit[b];
          short s1 = arrayOfShort1[2];
          if (this.mini_state == 1) {
            b1 = 1;
          } else {
            b1 = -1;
          } 
          arrayOfShort1[2] = (short)(s1 + b1);
          arrayOfShort1 = paramBattle1.hit[b];
          arrayOfShort1[3] = (short)(arrayOfShort1[3] + this.zb[paramBattle1.hit[b][4]]);
        } else if (b == 2) {
          short[] arrayOfShort1 = paramBattle1.hit[b];
          arrayOfShort1[3] = (short)(arrayOfShort1[3] - paramBattle1.hit[b][4] / 3);
        } 
        short[] arrayOfShort = paramBattle1.hit[b];
        short s = (short)(arrayOfShort[4] + 1);
        arrayOfShort[4] = s;
        bool = bool1;
        if (s == 1)
          if (paramBattle1.hit[b][0] == 4) {
            arrayOfShort = (paramBattle1.getMon()).monsterPro;
            arrayOfShort[1] = (short)(arrayOfShort[1] - paramBattle1.hit[b][1]);
            bool = bool1;
          } else if (paramBattle1.hit[b][0] == -2 && this.mini_state == 0 && !paramBattle1.getMon().isMonReel(40)) {
            byte[] arrayOfByte = (paramBattle1.getMon()).monster;
            arrayOfByte[6] = (byte)(arrayOfByte[6] - paramBattle1.hit[b][1]);
            getHitCoefficient(paramBattle1, paramBattle1.getMon(), paramBattle2.getMon());
            bool = bool1;
          } else {
            bool = bool1;
            if (paramBattle1.hit[b][0] > 0) {
              arrayOfShort = (paramBattle1.getMon()).monsterPro;
              arrayOfShort[0] = (short)(arrayOfShort[0] - paramBattle1.hit[b][1]);
              bool = bool1;
            } 
          }  
      } 
    } 
  }
  
  private void drawInfoBG(int paramInt1, int paramInt2) {
    Ui.i().fillRect(0, 0, 0, 640, paramInt2);
    g.fillRect(0, 360 - paramInt2, 640, paramInt2);
    g.fillRect(0, paramInt2 - 2, 640, paramInt2);
    Ui.i().fillRect(15400191, 0, 2, 640, paramInt2 - 4);
    g.fillRect(0, 360 - paramInt2 + 2, 640, paramInt2 - 4);
    g.fillRect(0, paramInt2, 640, paramInt2 - 4);
  }
  
  private void drawInfoList(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfbyte) {
    Ui.i().drawListKY(paramInt5, paramInt1 - 4, paramInt2 + 5, paramInt3, 4, paramInt4 + 4, 2, paramArrayOfbyte[0] - paramArrayOfbyte[1], 4, 2);
    for (byte b = paramArrayOfbyte[1];; b = (byte)(b + 1)) {
      if (b >= paramArrayOfbyte[1] + paramInt5 || b >= paramInt6) {
        Ui.i().sliding(paramInt1 + paramInt3 + 5, paramInt2 + 10, (paramInt4 + 4 + 2) * paramInt5 - 4, paramArrayOfbyte[0], paramInt6, false);
        return;
      } 
      Ui ui1 = Ui.i();
      if (this.monInfoList[this.monInfo_dir[this.cur_a][b]] == 2) {
        b1 = 25;
      } else {
        b1 = 48;
      } 
      byte b2 = paramArrayOfbyte[1];
      Graphics graphics1 = g;
      graphics1 = g;
      ui1.drawUi(b1, paramInt1 - 10, (b - b2) * (paramInt4 + 4 + 2) + paramInt2 + 11, 0x8 | 0x10, 0);
      if (paramArrayOfbyte[0] == b) {
        b1 = 0;
      } else if (this.monInfoList[this.monInfo_dir[this.cur_a][b]] != 0) {
        b1 = 3;
      } else {
        b1 = -1;
      } 
      b2 = (byte)b1;
      Ui ui2 = Ui.i();
      if (this.infoStart + b + 1 < 10) {
        str = "0";
      } else {
        str = "";
      } 
      StringBuilder stringBuilder = (new StringBuilder(String.valueOf(str))).append(this.infoStart + b + 1).append(" ");
      if (this.monInfoList[this.monInfo_dir[this.cur_a][b]] != 0) {
        str = getNameMon(this.monInfo_dir[this.cur_a][b]);
      } else {
        str = "未知宠物";
      } 
      ui2.drawString(stringBuilder.append(str).toString(), paramInt1 + 10, (b - paramArrayOfbyte[1]) * (paramInt4 + 4 + 2) + paramInt2 + 5, 0, b2, 0);
      ui2 = Ui.i();
      String str = getInfoType(this.monAppearMap[this.monInfo_dir[this.cur_a][b]][0]);
      int i = Constants_H.WIDTH;
      byte b1 = paramArrayOfbyte[1];
      Graphics graphics2 = g;
      graphics2 = g;
      ui2.drawString(str, i - 25 - 15, (b - b1) * (paramInt4 + 4 + 2) + paramInt2 + 5, 0x8 | 0x10, b2, 0);
      if (this.pkey.isSelect(paramInt1, (b - paramArrayOfbyte[1]) * (paramInt4 + 4 + 2) + paramInt2 + 5, paramInt3, paramInt4 + 4 + 2))
        if (paramArrayOfbyte[0] == b) {
          this.pkey.setKey5();
        } else {
          paramArrayOfbyte[0] = b;
          if (b - paramArrayOfbyte[1] == 0 && paramArrayOfbyte[1] > 0) {
            paramArrayOfbyte[1] = (byte)(paramArrayOfbyte[1] - 1);
          } else if (b - paramArrayOfbyte[1] == paramInt5 - 1 && paramArrayOfbyte[1] + paramInt5 < paramInt6) {
            paramArrayOfbyte[1] = (byte)(paramArrayOfbyte[1] + 1);
          } 
        }  
    } 
  }
  
  private void drawItemList(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfbyte, int paramInt5, int paramInt6, int paramInt7) {
    byte b = paramArrayOfbyte[1];
    Ui.i().drawListKY(paramInt4, paramInt1 - 4, paramInt2, paramInt3, 4, 30 + 1, -1, paramArrayOfbyte[0] - paramArrayOfbyte[1], 4, 2);
    while (true) {
      if (b >= paramArrayOfbyte[1] + paramInt4)
        return; 
      if (b < paramInt6) {
        if (paramInt7 == 0 || paramInt7 == 2) {
          byte b1;
          drawItem(this.items[paramInt5][b][0], paramInt1 + 3, paramInt2 + 4 + (b - paramArrayOfbyte[1]) * 30, 0);
          Ui ui = Ui.i();
          String str = getNameItem(this.items[paramInt5][b][0]);
          byte b2 = paramArrayOfbyte[1];
          if (paramArrayOfbyte[0] == b) {
            b1 = 0;
          } else {
            b1 = 3;
          } 
          ui.drawString(str, paramInt1 + 21, paramInt2 + 1 + (b - b2) * 30, 0, b1, 0);
          if (paramInt7 == 2) {
            str = getPrice(paramInt5, this.items[paramInt5][b][0], false) + "金";
          } else {
            str = "x" + this.items[paramInt5][b][1];
          } 
          ui = Ui.i();
          b2 = paramArrayOfbyte[1];
          Graphics graphics = g;
          graphics = g;
          if (paramArrayOfbyte[0] == b) {
            b1 = 0;
          } else {
            b1 = 3;
          } 
          ui.drawString(str, paramInt1 + paramInt3 - 12, paramInt2 + 1 + (b - b2) * 30, 0x8 | 0x10, b1, 0);
        } else {
          drawItem(this.buyItem[paramInt5][b], paramInt1 + 2, paramInt2 + 4 + (b - paramArrayOfbyte[1]) * 30, 0);
          if (paramArrayOfbyte[0] == b) {
            b1 = 0;
          } else {
            b1 = 3;
          } 
          byte b2 = (byte)b1;
          Ui.i().drawString(getNameItem(this.buyItem[paramInt5][b]), paramInt1 + 20, paramInt2 + (b - paramArrayOfbyte[1]) * 30, 0, b2, 0);
          if (paramInt5 == 2) {
            str = "徽章";
          } else {
            str = "金";
          } 
          Ui ui = Ui.i();
          String str = String.valueOf(getPrice(paramInt5, b, true)) + str;
          byte b1 = paramArrayOfbyte[1];
          Graphics graphics = g;
          graphics = g;
          ui.drawString(str, paramInt1 + paramInt3 - 12, (b - b1) * 30 + paramInt2 + 1, 0x8 | 0x10, b2, 0);
        } 
        if (this.popMenu == -1 && this.say_c == 0 && this.pkey.isSelect(paramInt1, (b - paramArrayOfbyte[1]) * 30 + paramInt2, Constants_H.WIDTH, 30))
          if (paramArrayOfbyte[0] == b) {
            this.pkey.setKey5();
          } else {
            paramArrayOfbyte[0] = b;
            if (b - paramArrayOfbyte[1] == 0 && paramArrayOfbyte[1] > 0) {
              paramArrayOfbyte[1] = (byte)(paramArrayOfbyte[1] - 1);
            } else if (b - paramArrayOfbyte[1] == paramInt4 - 1 && paramArrayOfbyte[1] + paramInt4 < paramInt6) {
              paramArrayOfbyte[1] = (byte)(paramArrayOfbyte[1] + 1);
            } 
            this.select_it[this.selectx] = paramArrayOfbyte[0];
            this.select_st[this.selectx] = paramArrayOfbyte[1];
          }  
      } 
      b = (byte)(b + 1);
    } 
  }
  
  private void drawLIST_INFO() {
    // Byte code:
    //   0: invokestatic i : ()Ldm/Ui;
    //   3: invokevirtual fillRectB : ()V
    //   6: aload_0
    //   7: bipush #24
    //   9: bipush #35
    //   11: invokespecial drawInfoBG : (II)V
    //   14: invokestatic i : ()Ldm/Ui;
    //   17: astore #7
    //   19: new java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w '发现度 '
    //   26: invokespecial <init> : (Ljava/lang/String;)V
    //   29: invokestatic i : ()Ldm/Ms;
    //   32: aload_0
    //   33: getfield monInfoList : [B
    //   36: bipush #102
    //   38: baload
    //   39: sipush #1000
    //   42: imul
    //   43: bipush #102
    //   45: idiv
    //   46: invokevirtual getPrecision : (I)Ljava/lang/String;
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w '%'
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual toString : ()Ljava/lang/String;
    //   61: astore #6
    //   63: getstatic main/GameRun.g : Ljavax/microedition/lcdui/Graphics;
    //   66: astore #8
    //   68: getstatic main/GameRun.g : Ljavax/microedition/lcdui/Graphics;
    //   71: astore #8
    //   73: aload #7
    //   75: aload #6
    //   77: sipush #640
    //   80: bipush #12
    //   82: isub
    //   83: bipush #34
    //   85: bipush #8
    //   87: bipush #16
    //   89: ior
    //   90: iconst_3
    //   91: iconst_1
    //   92: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   95: invokestatic i : ()Ldm/Ui;
    //   98: aload_0
    //   99: getfield monsterT : [Ljava/lang/StringBuffer;
    //   102: aload_0
    //   103: getfield cur_a : B
    //   106: aaload
    //   107: invokevirtual toString : ()Ljava/lang/String;
    //   110: bipush #28
    //   112: bipush #34
    //   114: iconst_0
    //   115: iconst_1
    //   116: iconst_2
    //   117: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   120: invokestatic i : ()Ldm/Ui;
    //   123: astore #6
    //   125: new java/lang/StringBuilder
    //   128: dup
    //   129: ldc_w '捕捉种类 '
    //   132: invokespecial <init> : (Ljava/lang/String;)V
    //   135: aload_0
    //   136: getfield monInfoList : [B
    //   139: bipush #103
    //   141: baload
    //   142: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   145: ldc_w '/'
    //   148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: bipush #100
    //   153: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   156: invokevirtual toString : ()Ljava/lang/String;
    //   159: astore #7
    //   161: getstatic main/GameRun.g : Ljavax/microedition/lcdui/Graphics;
    //   164: astore #8
    //   166: getstatic main/GameRun.g : Ljavax/microedition/lcdui/Graphics;
    //   169: astore #8
    //   171: aload #6
    //   173: aload #7
    //   175: sipush #320
    //   178: sipush #360
    //   181: iconst_1
    //   182: iadd
    //   183: iconst_1
    //   184: bipush #32
    //   186: ior
    //   187: iconst_3
    //   188: iconst_1
    //   189: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   192: aload_0
    //   193: getfield pkey : Lmain/PointerKey;
    //   196: iconst_5
    //   197: bipush #100
    //   199: iconst_0
    //   200: sipush #640
    //   203: bipush #6
    //   205: idiv
    //   206: bipush #35
    //   208: invokevirtual selectMenuX : (IIIII)B
    //   211: istore_1
    //   212: iload_1
    //   213: iconst_m1
    //   214: if_icmpeq -> 281
    //   217: aload_0
    //   218: iload_1
    //   219: putfield cur_a : B
    //   222: aload_0
    //   223: iconst_0
    //   224: putfield infoStart : B
    //   227: aload_0
    //   228: getfield cur_a : B
    //   231: ifle -> 244
    //   234: iconst_0
    //   235: istore_2
    //   236: iload_2
    //   237: aload_0
    //   238: getfield cur_a : B
    //   241: if_icmplt -> 366
    //   244: aload_0
    //   245: aload_0
    //   246: getfield monInfo_dir : [[B
    //   249: aload_0
    //   250: getfield cur_a : B
    //   253: aaload
    //   254: arraylength
    //   255: i2b
    //   256: putfield t_length : B
    //   259: aload_0
    //   260: getfield select : [[B
    //   263: iconst_0
    //   264: aaload
    //   265: astore #6
    //   267: aload_0
    //   268: getfield select : [[B
    //   271: iconst_0
    //   272: aaload
    //   273: iconst_1
    //   274: iconst_0
    //   275: bastore
    //   276: aload #6
    //   278: iconst_0
    //   279: iconst_0
    //   280: bastore
    //   281: iconst_0
    //   282: istore_2
    //   283: iload_2
    //   284: iconst_5
    //   285: if_icmplt -> 391
    //   288: aload_0
    //   289: bipush #32
    //   291: bipush #67
    //   293: sipush #640
    //   296: bipush #50
    //   298: isub
    //   299: bipush #29
    //   301: aload_0
    //   302: getfield list_rows : B
    //   305: aload_0
    //   306: getfield t_length : B
    //   309: aload_0
    //   310: getfield select : [[B
    //   313: iconst_0
    //   314: aaload
    //   315: invokespecial drawInfoList : (IIIIII[B)V
    //   318: invokestatic i : ()Ldm/Ui;
    //   321: sipush #320
    //   324: bipush #10
    //   326: iadd
    //   327: bipush #12
    //   329: sipush #331
    //   332: iconst_1
    //   333: iconst_1
    //   334: invokevirtual drawTriangle : (IIIZZ)V
    //   337: invokestatic i : ()Ldm/Ui;
    //   340: astore #6
    //   342: aload_0
    //   343: getfield monInfoList : [B
    //   346: aload_0
    //   347: invokespecial getMonInfo_dir : ()B
    //   350: baload
    //   351: ifeq -> 460
    //   354: iconst_1
    //   355: istore #5
    //   357: aload #6
    //   359: iload #5
    //   361: iconst_1
    //   362: invokevirtual drawYesNo : (ZZ)V
    //   365: return
    //   366: aload_0
    //   367: aload_0
    //   368: getfield infoStart : B
    //   371: aload_0
    //   372: getfield monInfo_dir : [[B
    //   375: iload_2
    //   376: aaload
    //   377: arraylength
    //   378: iadd
    //   379: i2b
    //   380: putfield infoStart : B
    //   383: iload_2
    //   384: iconst_1
    //   385: iadd
    //   386: i2b
    //   387: istore_2
    //   388: goto -> 236
    //   391: invokestatic i : ()Ldm/Ui;
    //   394: astore #6
    //   396: aload_0
    //   397: getfield cur_a : B
    //   400: iload_2
    //   401: if_icmpne -> 455
    //   404: iconst_5
    //   405: istore_3
    //   406: iload_2
    //   407: iconst_1
    //   408: iadd
    //   409: sipush #614
    //   412: imul
    //   413: bipush #6
    //   415: idiv
    //   416: istore #4
    //   418: getstatic main/GameRun.g : Ljavax/microedition/lcdui/Graphics;
    //   421: astore #7
    //   423: getstatic main/GameRun.g : Ljavax/microedition/lcdui/Graphics;
    //   426: astore #7
    //   428: aload #6
    //   430: iload_3
    //   431: iload_2
    //   432: iadd
    //   433: iload #4
    //   435: bipush #18
    //   437: iadd
    //   438: bipush #12
    //   440: iconst_4
    //   441: iconst_2
    //   442: ior
    //   443: iconst_0
    //   444: invokevirtual drawUi : (IIIII)V
    //   447: iload_2
    //   448: iconst_1
    //   449: iadd
    //   450: i2b
    //   451: istore_2
    //   452: goto -> 283
    //   455: iconst_0
    //   456: istore_3
    //   457: goto -> 406
    //   460: iconst_0
    //   461: istore #5
    //   463: goto -> 357
  }
  
  private void drawMONSTER_INFO(int paramInt) {
    // Byte code:
    //   0: sipush #320
    //   3: sipush #140
    //   6: isub
    //   7: istore_3
    //   8: iload_3
    //   9: bipush #12
    //   11: iadd
    //   12: istore #4
    //   14: invokestatic i : ()Ldm/Ui;
    //   17: invokevirtual fillRectB : ()V
    //   20: invokestatic i : ()Ldm/Ui;
    //   23: iload_3
    //   24: iconst_2
    //   25: sipush #280
    //   28: sipush #360
    //   31: iconst_2
    //   32: isub
    //   33: iconst_0
    //   34: invokevirtual drawK2 : (IIIII)V
    //   37: invokestatic i : ()Ldm/Ui;
    //   40: sipush #320
    //   43: bipush #29
    //   45: iconst_4
    //   46: imul
    //   47: isub
    //   48: iconst_4
    //   49: isub
    //   50: bipush #6
    //   52: bipush #29
    //   54: bipush #8
    //   56: imul
    //   57: bipush #29
    //   59: iconst_4
    //   60: invokevirtual drawK1 : (IIIII)V
    //   63: invokestatic i : ()Ldm/Ui;
    //   66: iload #4
    //   68: bipush #35
    //   70: bipush #100
    //   72: bipush #90
    //   74: iconst_1
    //   75: invokevirtual drawK1 : (IIIII)V
    //   78: invokestatic i : ()Ldm/Ui;
    //   81: bipush #29
    //   83: sipush #192
    //   86: iadd
    //   87: bipush #8
    //   89: iadd
    //   90: bipush #35
    //   92: bipush #90
    //   94: iadd
    //   95: iconst_4
    //   96: iadd
    //   97: sipush #280
    //   100: bipush #29
    //   102: bipush #25
    //   104: iadd
    //   105: isub
    //   106: bipush #29
    //   108: iconst_4
    //   109: imul
    //   110: iconst_1
    //   111: invokevirtual drawK1 : (IIIII)V
    //   114: invokestatic i : ()Ldm/Ui;
    //   117: iload #4
    //   119: bipush #35
    //   121: bipush #90
    //   123: iadd
    //   124: iconst_4
    //   125: iadd
    //   126: bipush #29
    //   128: bipush #29
    //   130: iconst_4
    //   131: imul
    //   132: iconst_3
    //   133: invokevirtual drawK1 : (IIIII)V
    //   136: invokestatic i : ()Ldm/Ui;
    //   139: iload #4
    //   141: sipush #360
    //   144: bipush #13
    //   146: isub
    //   147: bipush #29
    //   149: iconst_3
    //   150: imul
    //   151: isub
    //   152: sipush #640
    //   155: iload #4
    //   157: iconst_1
    //   158: ishl
    //   159: isub
    //   160: iconst_2
    //   161: iadd
    //   162: bipush #29
    //   164: iconst_3
    //   165: imul
    //   166: bipush #10
    //   168: iadd
    //   169: iconst_2
    //   170: invokevirtual drawK1 : (IIIII)V
    //   173: invokestatic i : ()Ldm/Ui;
    //   176: iconst_0
    //   177: iconst_1
    //   178: invokevirtual drawYesNo : (ZZ)V
    //   181: invokestatic i : ()Ldm/Ui;
    //   184: aload_0
    //   185: getfield cur_a : B
    //   188: iconst_5
    //   189: iadd
    //   190: iload #4
    //   192: iconst_2
    //   193: iadd
    //   194: bipush #35
    //   196: iconst_2
    //   197: iadd
    //   198: iconst_0
    //   199: iconst_0
    //   200: invokevirtual drawUi : (IIIII)V
    //   203: ldc_w 'sk'
    //   206: ldc_w 'drawUi'
    //   209: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   212: pop
    //   213: invokestatic i : ()Ldm/Ui;
    //   216: astore #9
    //   218: new java/lang/StringBuilder
    //   221: dup
    //   222: aload_0
    //   223: iload_1
    //   224: invokevirtual getNameMon : (I)Ljava/lang/String;
    //   227: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   230: invokespecial <init> : (Ljava/lang/String;)V
    //   233: ldc_w '（'
    //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: astore #8
    //   241: aload_0
    //   242: getfield monInfoList : [B
    //   245: iload_1
    //   246: baload
    //   247: iconst_2
    //   248: if_icmpne -> 559
    //   251: ldc_w '已捕获'
    //   254: astore #7
    //   256: aload #9
    //   258: aload #8
    //   260: aload #7
    //   262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w '）'
    //   268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual toString : ()Ljava/lang/String;
    //   274: sipush #320
    //   277: bipush #6
    //   279: bipush #17
    //   281: iconst_0
    //   282: iconst_0
    //   283: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   286: aload_0
    //   287: getfield mList_id : [[B
    //   290: iload_1
    //   291: aaload
    //   292: iconst_1
    //   293: baload
    //   294: istore #5
    //   296: aload_0
    //   297: getfield mon_action : B
    //   300: istore_3
    //   301: aload_0
    //   302: getfield mon_action : B
    //   305: iconst_1
    //   306: if_icmpne -> 567
    //   309: iconst_0
    //   310: istore #6
    //   312: aload_0
    //   313: iconst_1
    //   314: iconst_1
    //   315: iload #5
    //   317: iconst_3
    //   318: imul
    //   319: iload_3
    //   320: iadd
    //   321: iload #4
    //   323: bipush #50
    //   325: iadd
    //   326: bipush #35
    //   328: bipush #90
    //   330: iadd
    //   331: bipush #10
    //   333: isub
    //   334: iload #6
    //   336: iconst_0
    //   337: invokevirtual drawCartoonOne : (IIIIIZI)Z
    //   340: ifeq -> 348
    //   343: aload_0
    //   344: iconst_0
    //   345: putfield mon_action : B
    //   348: invokestatic i : ()Ldm/Ui;
    //   351: ldc_w '发现地点'
    //   354: bipush #100
    //   356: sipush #192
    //   359: iadd
    //   360: iconst_5
    //   361: iadd
    //   362: bipush #35
    //   364: iconst_0
    //   365: iconst_1
    //   366: iconst_1
    //   367: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   370: aload_0
    //   371: getfield monAppearMap : [[B
    //   374: iload_1
    //   375: aaload
    //   376: iconst_0
    //   377: baload
    //   378: iconst_m1
    //   379: if_icmple -> 623
    //   382: iconst_0
    //   383: istore_3
    //   384: iload_3
    //   385: aload_0
    //   386: getfield monAppearMap : [[B
    //   389: iload_1
    //   390: aaload
    //   391: arraylength
    //   392: if_icmplt -> 573
    //   395: invokestatic i : ()Ldm/Ui;
    //   398: ldc_w '进'
    //   401: iload #4
    //   403: bipush #12
    //   405: iadd
    //   406: iconst_2
    //   407: iadd
    //   408: bipush #35
    //   410: bipush #90
    //   412: iadd
    //   413: bipush #20
    //   415: iadd
    //   416: bipush #17
    //   418: iconst_3
    //   419: iconst_1
    //   420: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   423: invokestatic i : ()Ldm/Ui;
    //   426: ldc_w '化'
    //   429: iload #4
    //   431: bipush #12
    //   433: iadd
    //   434: iconst_2
    //   435: iadd
    //   436: bipush #29
    //   438: sipush #153
    //   441: iadd
    //   442: bipush #17
    //   444: iconst_3
    //   445: iconst_1
    //   446: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   449: invokestatic i : ()Ldm/Ui;
    //   452: iconst_3
    //   453: bipush #29
    //   455: sipush #192
    //   458: iadd
    //   459: bipush #8
    //   461: iadd
    //   462: bipush #35
    //   464: bipush #90
    //   466: iadd
    //   467: bipush #10
    //   469: iadd
    //   470: sipush #280
    //   473: bipush #29
    //   475: bipush #25
    //   477: iadd
    //   478: isub
    //   479: iconst_3
    //   480: bipush #29
    //   482: iconst_4
    //   483: iadd
    //   484: iconst_0
    //   485: iconst_m1
    //   486: iconst_4
    //   487: iconst_2
    //   488: invokevirtual drawListKY : (IIIIIIIIII)V
    //   491: iconst_2
    //   492: istore #4
    //   494: iconst_0
    //   495: istore_3
    //   496: iload #4
    //   498: bipush #7
    //   500: if_icmplt -> 651
    //   503: aload_0
    //   504: aload_0
    //   505: iload_1
    //   506: invokevirtual getNameMonsterInfo : (I)Ljava/lang/String;
    //   509: sipush #320
    //   512: sipush #360
    //   515: bipush #12
    //   517: isub
    //   518: bipush #29
    //   520: iconst_3
    //   521: imul
    //   522: isub
    //   523: bipush #10
    //   525: iconst_3
    //   526: invokevirtual showStringM : (Ljava/lang/String;IIII)V
    //   529: aload_0
    //   530: getfield mon_action_c : B
    //   533: iconst_1
    //   534: iadd
    //   535: i2b
    //   536: istore_2
    //   537: aload_0
    //   538: iload_2
    //   539: putfield mon_action_c : B
    //   542: iload_2
    //   543: bipush #50
    //   545: if_icmple -> 558
    //   548: aload_0
    //   549: iconst_0
    //   550: putfield mon_action_c : B
    //   553: aload_0
    //   554: iconst_1
    //   555: putfield mon_action : B
    //   558: return
    //   559: ldc_w '未捕获'
    //   562: astore #7
    //   564: goto -> 256
    //   567: iconst_1
    //   568: istore #6
    //   570: goto -> 312
    //   573: invokestatic i : ()Ldm/Ui;
    //   576: aload_0
    //   577: getfield city_name : [Ljava/lang/StringBuffer;
    //   580: aload_0
    //   581: getfield monAppearMap : [[B
    //   584: iload_1
    //   585: aaload
    //   586: iload_3
    //   587: baload
    //   588: aaload
    //   589: invokevirtual toString : ()Ljava/lang/String;
    //   592: bipush #100
    //   594: sipush #192
    //   597: iadd
    //   598: iconst_5
    //   599: iadd
    //   600: bipush #35
    //   602: iload_3
    //   603: iconst_1
    //   604: iadd
    //   605: bipush #25
    //   607: imul
    //   608: iadd
    //   609: iconst_0
    //   610: iconst_1
    //   611: iconst_0
    //   612: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   615: iload_3
    //   616: iconst_1
    //   617: iadd
    //   618: i2b
    //   619: istore_3
    //   620: goto -> 384
    //   623: invokestatic i : ()Ldm/Ui;
    //   626: ldc_w '未知'
    //   629: bipush #100
    //   631: sipush #192
    //   634: iadd
    //   635: iconst_5
    //   636: iadd
    //   637: bipush #35
    //   639: bipush #25
    //   641: iadd
    //   642: iconst_0
    //   643: iconst_1
    //   644: iconst_0
    //   645: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   648: goto -> 395
    //   651: invokestatic i : ()Ldm/Ui;
    //   654: astore #9
    //   656: new java/lang/StringBuilder
    //   659: dup
    //   660: ldc_w '材料：'
    //   663: invokespecial <init> : (Ljava/lang/String;)V
    //   666: astore #8
    //   668: aload_0
    //   669: getfield monsterMake : [[B
    //   672: iload_1
    //   673: aaload
    //   674: arraylength
    //   675: ifeq -> 690
    //   678: iload #4
    //   680: aload_0
    //   681: getfield monsterMake : [[B
    //   684: iload_1
    //   685: aaload
    //   686: arraylength
    //   687: if_icmplt -> 745
    //   690: ldc_w ''
    //   693: astore #7
    //   695: aload #9
    //   697: aload #8
    //   699: aload #7
    //   701: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual toString : ()Ljava/lang/String;
    //   707: bipush #29
    //   709: sipush #192
    //   712: iadd
    //   713: bipush #14
    //   715: iadd
    //   716: iload_3
    //   717: bipush #33
    //   719: imul
    //   720: sipush #137
    //   723: iadd
    //   724: iconst_0
    //   725: iconst_3
    //   726: iconst_0
    //   727: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   730: iload #4
    //   732: iconst_2
    //   733: iadd
    //   734: i2b
    //   735: istore #4
    //   737: iload_3
    //   738: iconst_1
    //   739: iadd
    //   740: i2b
    //   741: istore_3
    //   742: goto -> 496
    //   745: new java/lang/StringBuilder
    //   748: dup
    //   749: aload_0
    //   750: aload_0
    //   751: getfield monsterMake : [[B
    //   754: iload_1
    //   755: aaload
    //   756: iload #4
    //   758: baload
    //   759: invokevirtual getNameItem : (I)Ljava/lang/String;
    //   762: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   765: invokespecial <init> : (Ljava/lang/String;)V
    //   768: ldc_w ' x'
    //   771: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: aload_0
    //   775: getfield monsterMake : [[B
    //   778: iload_1
    //   779: aaload
    //   780: iload #4
    //   782: iconst_1
    //   783: iadd
    //   784: baload
    //   785: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   788: invokevirtual toString : ()Ljava/lang/String;
    //   791: astore #7
    //   793: goto -> 695
  }
  
  private void drawMONSTER_UI(Monster[] paramArrayOfMonster) {
    boolean bool;
    int i = 320 - 140;
    Ui.i().fillRectB();
    Ui.i().drawK2(i, 2, 280, 360 - 2, 0);
    i += 6;
    Ui.i().drawK1(i, 5 + 6, 118, 116, 1);
    if (this.t_length != 0) {
      drawMonsterHp(paramArrayOfMonster[this.select[0][0]], i + 30, 5, 74, 2, 2, (paramArrayOfMonster[this.select[0][0]]).monsterPro[4]);
      Ui.i().drawNum(String.valueOf((paramArrayOfMonster[this.select[0][0]]).monster[2]) + "级", i + 2, 5 + 10, 0, 0);
      Ui.i().drawUi((paramArrayOfMonster[this.select[0][0]]).monster[3] + 5, i + 9, 5 + 11, 17, 0);
      byte b2 = this.mList_id[(paramArrayOfMonster[this.select[0][0]]).monster[0]][1];
      byte b1 = this.mon_action;
      if (this.mon_action == 1) {
        bool = false;
      } else {
        bool = true;
      } 
      if (drawCartoonOne(1, 1, b2 * 3 + b1, 248, 111, bool, 0))
        this.mon_action = 0; 
    } 
    int j = 5 + 138;
    short s = (short)(640 - (i << 1));
    Ui.i().drawK1(i, j, s, 360 - 116 - 32, 1);
    Ui.i().drawK(i + 8, j + 10, s - 16, 33, 3);
    Ui.i().drawK(i + 8, j + 150 + 11, s - 16, 33, 3);
    if (this.t_length != 0) {
      gogoWord(getNameMonsterInfo((paramArrayOfMonster[this.select[0][0]]).monster[0]), i + 9, j + 150 + 13, s - 70, 0, 1, 2);
      drawMonsterFealty(paramArrayOfMonster[this.select[0][0]], i + 2, j - 14);
      Ui.i().drawString(this.monsterT[(paramArrayOfMonster[this.select[0][0]]).monster[3]].toString(), i + 25, j + 12, 0, 0, 1);
      if ((paramArrayOfMonster[this.select[0][0]]).monster[5] == 0) {
        Ui.i().drawString("不可进化", i + 115, j + 12, 0, 0, 1);
      } else {
        Ui.i().drawString("可进化" + (paramArrayOfMonster[this.select[0][0]]).monster[5] + "次", i + 115, j + 12, 0, 0, 1);
      } 
    } 
    drawMonPro(paramArrayOfMonster, i, j);
    if (this.t_length != 0)
      drawMonList(paramArrayOfMonster, 280 + 180 - 75 - 15 + 2, 0 + 13, this.list_rows, this.t_length, this.select[0]); 
    Ui.i().sliding(280 + 180 - 17, 0 + 12, 116 + 6, this.select[0][0], this.t_length, true);
    Ui ui = Ui.i();
    StringBuilder stringBuilder = (new StringBuilder(String.valueOf(this.t_length))).append("/");
    if (this.mini_state == 6) {
      i = this.max_monsters;
    } else {
      i = this.max_takes;
    } 
    ui.drawNum(stringBuilder.append(i).toString(), 280 + 180 - 40, 0 + 12, 0, 0);
    if (this.popMenu != -1) {
      drawSelectMenu((Object[])this.about_d, 320 - 25, 30, 75, 2, 0, this.popMenu);
      if (this.buyOk == 1)
        showString(this.gogoString, 180 - 25, 0); 
    } 
    ui = Ui.i();
    if (this.t_length != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    ui.drawYesNo(bool, true);
  }
  
  private void drawMY_BAG(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: getfield action_str : [Ljava/lang/String;
    //   4: arraylength
    //   5: iconst_1
    //   6: isub
    //   7: i2b
    //   8: istore #6
    //   10: invokestatic i : ()Ldm/Ui;
    //   13: invokevirtual fillRectB : ()V
    //   16: invokestatic i : ()Ldm/Ui;
    //   19: iload_1
    //   20: iconst_1
    //   21: iadd
    //   22: iload_2
    //   23: iconst_3
    //   24: iadd
    //   25: iload_3
    //   26: iconst_2
    //   27: isub
    //   28: iload #4
    //   30: iconst_3
    //   31: isub
    //   32: iconst_0
    //   33: invokevirtual drawK2 : (IIIII)V
    //   36: invokestatic i : ()Ldm/Ui;
    //   39: iload_1
    //   40: iconst_5
    //   41: iadd
    //   42: iload_2
    //   43: bipush #25
    //   45: iadd
    //   46: bipush #14
    //   48: iadd
    //   49: iload_3
    //   50: bipush #23
    //   52: isub
    //   53: aload_0
    //   54: getfield list_rows : B
    //   57: bipush #31
    //   59: imul
    //   60: iconst_1
    //   61: invokevirtual drawK1 : (IIIII)V
    //   64: invokestatic i : ()Ldm/Ui;
    //   67: iload_1
    //   68: iconst_5
    //   69: iadd
    //   70: iload_2
    //   71: bipush #25
    //   73: iadd
    //   74: bipush #20
    //   76: iadd
    //   77: aload_0
    //   78: getfield list_rows : B
    //   81: bipush #31
    //   83: imul
    //   84: iadd
    //   85: iload_3
    //   86: bipush #10
    //   88: isub
    //   89: bipush #90
    //   91: iconst_2
    //   92: invokevirtual drawK1 : (IIIII)V
    //   95: iload #6
    //   97: ifne -> 414
    //   100: invokestatic i : ()Ldm/Ui;
    //   103: iload_3
    //   104: iconst_1
    //   105: ishr
    //   106: iload_1
    //   107: iadd
    //   108: bipush #25
    //   110: isub
    //   111: bipush #9
    //   113: isub
    //   114: iload_2
    //   115: bipush #8
    //   117: iadd
    //   118: bipush #66
    //   120: bipush #28
    //   122: iconst_4
    //   123: invokevirtual drawK1 : (IIIII)V
    //   126: invokestatic i : ()Ldm/Ui;
    //   129: aload_0
    //   130: getfield action_str : [Ljava/lang/String;
    //   133: iload #6
    //   135: aaload
    //   136: iload_3
    //   137: iconst_1
    //   138: ishr
    //   139: iload_1
    //   140: iadd
    //   141: iload_2
    //   142: bipush #7
    //   144: iadd
    //   145: bipush #17
    //   147: iconst_0
    //   148: iconst_0
    //   149: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   152: ldc_w 'sk'
    //   155: ldc_w 'drawMY_BAG'
    //   158: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   161: pop
    //   162: aload_0
    //   163: iload_1
    //   164: bipush #9
    //   166: iadd
    //   167: iload_2
    //   168: bipush #25
    //   170: iadd
    //   171: bipush #17
    //   173: iadd
    //   174: iload_3
    //   175: bipush #23
    //   177: isub
    //   178: aload_0
    //   179: getfield list_rows : B
    //   182: aload_0
    //   183: getfield select : [[B
    //   186: iconst_0
    //   187: aaload
    //   188: aload_0
    //   189: getfield selectx : B
    //   192: aload_0
    //   193: getfield itemsLength : [B
    //   196: aload_0
    //   197: getfield selectx : B
    //   200: baload
    //   201: iconst_0
    //   202: invokespecial drawItemList : (IIII[BIII)V
    //   205: invokestatic i : ()Ldm/Ui;
    //   208: iload_1
    //   209: iload_3
    //   210: iadd
    //   211: bipush #15
    //   213: isub
    //   214: iload_2
    //   215: bipush #25
    //   217: iadd
    //   218: bipush #17
    //   220: iadd
    //   221: aload_0
    //   222: getfield list_rows : B
    //   225: bipush #31
    //   227: imul
    //   228: bipush #6
    //   230: isub
    //   231: aload_0
    //   232: getfield select : [[B
    //   235: iconst_0
    //   236: aaload
    //   237: iconst_0
    //   238: baload
    //   239: aload_0
    //   240: getfield itemsLength : [B
    //   243: aload_0
    //   244: getfield selectx : B
    //   247: baload
    //   248: iconst_1
    //   249: invokevirtual sliding : (IIIIIZ)V
    //   252: aload_0
    //   253: getfield itemsLength : [B
    //   256: aload_0
    //   257: getfield selectx : B
    //   260: baload
    //   261: ifle -> 319
    //   264: aload_0
    //   265: aload_0
    //   266: getfield item_help : [Ljava/lang/StringBuffer;
    //   269: aload_0
    //   270: getfield items : [[[B
    //   273: aload_0
    //   274: getfield selectx : B
    //   277: aaload
    //   278: aload_0
    //   279: getfield select : [[B
    //   282: iconst_0
    //   283: aaload
    //   284: iconst_0
    //   285: baload
    //   286: aaload
    //   287: iconst_0
    //   288: baload
    //   289: aaload
    //   290: invokevirtual toString : ()Ljava/lang/String;
    //   293: iload_1
    //   294: iload_3
    //   295: iconst_1
    //   296: ishr
    //   297: iadd
    //   298: aload_0
    //   299: getfield list_rows : B
    //   302: bipush #31
    //   304: imul
    //   305: iload_2
    //   306: bipush #25
    //   308: iadd
    //   309: bipush #22
    //   311: iadd
    //   312: iadd
    //   313: bipush #10
    //   315: iconst_3
    //   316: invokevirtual showStringM : (Ljava/lang/String;IIII)V
    //   319: aload_0
    //   320: getfield selectx : B
    //   323: iconst_2
    //   324: if_icmpne -> 618
    //   327: iconst_1
    //   328: istore #9
    //   330: aload_0
    //   331: iload_3
    //   332: iconst_1
    //   333: ishr
    //   334: iload_1
    //   335: iadd
    //   336: iload_2
    //   337: iload #4
    //   339: iadd
    //   340: iconst_2
    //   341: isub
    //   342: iconst_0
    //   343: iload #9
    //   345: invokevirtual drawMoney : (IIIZ)V
    //   348: invokestatic i : ()Ldm/Ui;
    //   351: astore #10
    //   353: aload_0
    //   354: getfield itemsLength : [B
    //   357: aload_0
    //   358: getfield selectx : B
    //   361: baload
    //   362: ifne -> 624
    //   365: iconst_0
    //   366: istore #9
    //   368: aload #10
    //   370: iload #9
    //   372: iconst_1
    //   373: invokevirtual drawYesNo : (ZZ)V
    //   376: aload_0
    //   377: getfield popMenu : B
    //   380: iconst_m1
    //   381: if_icmpeq -> 413
    //   384: aload_0
    //   385: aload_0
    //   386: getfield about_a : [Ljava/lang/StringBuffer;
    //   389: iload_3
    //   390: iconst_1
    //   391: ishr
    //   392: iload_1
    //   393: iadd
    //   394: bipush #25
    //   396: isub
    //   397: bipush #8
    //   399: isub
    //   400: bipush #50
    //   402: bipush #75
    //   404: iconst_2
    //   405: iconst_0
    //   406: aload_0
    //   407: getfield popMenu : B
    //   410: invokevirtual drawSelectMenu : ([Ljava/lang/Object;IIIIII)V
    //   413: return
    //   414: invokestatic i : ()Ldm/Ui;
    //   417: aload_0
    //   418: getfield selectx : B
    //   421: iconst_1
    //   422: iadd
    //   423: iload_3
    //   424: imul
    //   425: iconst_5
    //   426: idiv
    //   427: iload_1
    //   428: iadd
    //   429: bipush #22
    //   431: isub
    //   432: iload_2
    //   433: bipush #8
    //   435: iadd
    //   436: bipush #70
    //   438: bipush #28
    //   440: iconst_4
    //   441: invokevirtual drawK1 : (IIIII)V
    //   444: iload #6
    //   446: iconst_m1
    //   447: if_icmpgt -> 544
    //   450: invokestatic i : ()Ldm/Ui;
    //   453: iload_3
    //   454: iconst_1
    //   455: ishr
    //   456: iload_1
    //   457: iadd
    //   458: iload_2
    //   459: bipush #14
    //   461: iadd
    //   462: sipush #354
    //   465: iconst_1
    //   466: iconst_1
    //   467: invokevirtual drawTriangle : (IIIZZ)V
    //   470: aload_0
    //   471: getfield popMenu : B
    //   474: iconst_m1
    //   475: if_icmpne -> 162
    //   478: aload_0
    //   479: getfield pkey : Lmain/PointerKey;
    //   482: iconst_4
    //   483: iconst_0
    //   484: iconst_0
    //   485: iload_3
    //   486: iconst_4
    //   487: idiv
    //   488: bipush #35
    //   490: invokevirtual selectMenuX : (IIIII)B
    //   493: istore #5
    //   495: iload #5
    //   497: iconst_m1
    //   498: if_icmpeq -> 162
    //   501: aload_0
    //   502: iload #5
    //   504: putfield selectx : B
    //   507: aload_0
    //   508: getfield select : [[B
    //   511: iconst_0
    //   512: aaload
    //   513: iconst_1
    //   514: aload_0
    //   515: getfield select_st : [B
    //   518: aload_0
    //   519: getfield selectx : B
    //   522: baload
    //   523: bastore
    //   524: aload_0
    //   525: getfield select : [[B
    //   528: iconst_0
    //   529: aaload
    //   530: iconst_0
    //   531: aload_0
    //   532: getfield select_it : [B
    //   535: aload_0
    //   536: getfield selectx : B
    //   539: baload
    //   540: bastore
    //   541: goto -> 162
    //   544: invokestatic i : ()Ldm/Ui;
    //   547: astore #10
    //   549: aload_0
    //   550: getfield action_str : [Ljava/lang/String;
    //   553: iload #6
    //   555: aaload
    //   556: astore #11
    //   558: iload #6
    //   560: iconst_1
    //   561: iadd
    //   562: iload_3
    //   563: imul
    //   564: iconst_5
    //   565: idiv
    //   566: istore #8
    //   568: aload_0
    //   569: getfield selectx : B
    //   572: iload #6
    //   574: if_icmpne -> 612
    //   577: iconst_0
    //   578: istore #7
    //   580: aload #10
    //   582: aload #11
    //   584: iload #8
    //   586: iload_1
    //   587: iadd
    //   588: bipush #14
    //   590: isub
    //   591: iload_2
    //   592: bipush #7
    //   594: iadd
    //   595: iconst_0
    //   596: iload #7
    //   598: iconst_0
    //   599: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   602: iload #6
    //   604: iconst_1
    //   605: isub
    //   606: i2b
    //   607: istore #6
    //   609: goto -> 444
    //   612: iconst_1
    //   613: istore #7
    //   615: goto -> 580
    //   618: iconst_0
    //   619: istore #9
    //   621: goto -> 330
    //   624: iconst_1
    //   625: istore #9
    //   627: goto -> 368
  }
  
  private void drawMagicUI(Monster paramMonster) {
    boolean bool;
    Ui.i().fillRect(5422575, 0, 0, 640, 360);
    int i = 1 + 180;
    drawBG0(this.bg_c, i, 108, 0, 267);
    if (this.pkey.selectMenuX(2, i, 108, 120, 29) != -1) {
      Ms.key = -3;
      Ms.keyRepeat = true;
    } 
    Ui ui = Ui.i();
    if (this.popMenu == 0) {
      s = -143;
    } else {
      s = 21;
    } 
    ui.drawK1(320 + s, 108 + 3, 123, 27, 4);
    ui = Ui.i();
    Graphics graphics = g;
    graphics = g;
    if (this.popMenu == 0) {
      s = 0;
    } else {
      s = 1;
    } 
    ui.drawString("普通技能", 320 - 25, 108 + 1, 0x8 | 0x10, s, 0);
    ui = Ui.i();
    if (this.popMenu == 0) {
      s = 1;
    } else {
      s = 0;
    } 
    ui.drawString("天赋技能", 320 + 25, 108 + 1, 0, s, 0);
    byte b2 = this.mList_id[paramMonster.monster[0]][1];
    byte b1 = this.mon_action;
    short s = this.move_x;
    short s1 = this.move_y;
    if (this.mon_action == 1) {
      bool = false;
    } else {
      bool = true;
    } 
    if (drawCartoonOne(1, 1, b2 * 3 + b1, 377 - s, 97 - s1, bool, 0))
      this.mon_action = 0; 
    this.move_x = Ms.i().mathSpeedDown(this.move_x, 3, false);
    this.move_y = Ms.i().mathSpeedDown(this.move_y, 3, false);
    if (this.popMenu == 0) {
      drawSkillList(i + 7, 108 + 25 + 12, 267 - 29, 31, 5, this.select[0]);
      if (this.skill_list[this.select[0][0]] != -1)
        gogoWord(this.skill_help[this.skill_list[this.select[0][0]]].toString(), i + 10, 360 - 25 - 22, 200, 0, 1, 2); 
    } else {
      drawBuffList(paramMonster, i + 7, 108 + 25 + 12, 267 - 29, 31, 5, this.select[0]);
      if (paramMonster.monster[this.select[0][0] + 16] > 0)
        showStringM(this.buff_help[paramMonster.monster[this.select[0][0] + 16]].toString(), 320, 360 - 50 - 22, 9, 0); 
    } 
    ui = Ui.i();
    i = this.select[0][0];
    if (this.popMenu == 0) {
      s = this.skill_list[8];
    } else if (paramMonster.monster[this.select[0][0] + 16] > 0) {
      s = 2;
    } else {
      s = 1;
    } 
    ui.sliding(267 + 180 - 13, 108 + 25 + 13, 360 - 108 - 120, i, s, true);
    if (this.mini_state != 13) {
      Ui.i().drawTriangle(320, 108 + 12, 150, true, true);
      Ui.i().drawYesNo(false, true);
      return;
    } 
    Ui.i().drawYesNo(true, true);
  }
  
  private void drawMonKind(byte paramByte, int paramInt1, int paramInt2, int paramInt3) {
    for (byte b = 0;; b = (byte)(b + 1)) {
      byte b1;
      if (b >= 5)
        return; 
      Ui ui = Ui.i();
      if (paramByte > b) {
        b1 = 23;
      } else {
        b1 = 24;
      } 
      ui.drawUi(b1, b * 14 + paramInt1, paramInt2, paramInt3, 0);
    } 
  }
  
  private void drawMonList(Monster[] paramArrayOfMonster, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfbyte) {
    byte b1 = paramArrayOfbyte[1];
    byte b = b1;
    if (this.mini_state != 6) {
      Ui ui = Ui.i();
      Graphics graphics = g;
      graphics = g;
      ui.drawUi(34, paramInt1 - 50 - 5, paramInt2 + 2, 0x8 | 0x10, 0);
      b = b1;
    } 
    while (true) {
      boolean bool;
      if (b >= paramArrayOfbyte[1] + paramInt3 || b >= paramInt4)
        return; 
      if (paramArrayOfbyte[0] == b)
        Ui.i().drawK(paramInt1 - 50, (b - paramArrayOfbyte[1]) * 29 + paramInt2, 108, 26, 1); 
      Ui ui = Ui.i();
      String str = getNameMon((paramArrayOfMonster[b]).monster[0]).toString();
      byte b2 = paramArrayOfbyte[1];
      if (paramArrayOfbyte[0] == b) {
        bool = false;
      } else {
        bool = true;
      } 
      ui.drawString(str, paramInt1 + 4, paramInt2 - 2 + (b - b2) * 29, 17, bool, 1);
      if (this.popMenu == -1 && this.pkey.isSelect(paramInt1 - 50, (b - paramArrayOfbyte[1]) * 29 + paramInt2, 100, 26))
        if (paramArrayOfbyte[0] == b) {
          Ms.key = 53;
          Ms.keyRepeat = true;
        } else {
          paramArrayOfbyte[0] = b;
          if (b - paramArrayOfbyte[1] == 0 && paramArrayOfbyte[1] > 0) {
            paramArrayOfbyte[1] = (byte)(paramArrayOfbyte[1] - 1);
          } else if (b - paramArrayOfbyte[1] == paramInt3 - 1 && paramArrayOfbyte[1] + paramInt3 < paramInt4) {
            paramArrayOfbyte[1] = (byte)(paramArrayOfbyte[1] + 1);
          } 
          initMonStream(2, this.mList_id[(paramArrayOfMonster[paramArrayOfbyte[0]]).monster[0]][0], 1);
          setShowPro(paramArrayOfMonster[paramArrayOfbyte[0]]);
          this.introT = Constants_H.WIDTH_H;
          this.introX = Constants_H.WIDTH_H;
        }  
      b = (byte)(b + 1);
    } 
  }
  
  private void drawMonPro(Monster[] paramArrayOfMonster, int paramInt1, int paramInt2) {
    Ui.i().drawStringY((Object[])this.about_a, paramInt1 + 18, paramInt2 + 44, 0, 3, 31, 3, 0);
    Ui.i().drawStringY((Object[])this.about_b, paramInt1 + 160, paramInt2 + 44, 0, 3, 31, 3, 0);
    if (this.t_length != 0) {
      Ui.i().drawStringY((Object[])this.about_c, paramInt1 + 165 + 50, paramInt2 + 44, 0, 3, 31, -1, 0);
      drawMonsterHp(paramArrayOfMonster[this.select[0][0]], paramInt1 + 19 + 50 + 4, paramInt2 + 59, 48, 0, 0, (paramArrayOfMonster[this.select[0][0]]).monsterPro[0]);
      drawMonsterHp(paramArrayOfMonster[this.select[0][0]], paramInt1 + 19 + 50 + 4, paramInt2 + 59 + 25 + 3, 48, 1, 0, (paramArrayOfMonster[this.select[0][0]]).monsterPro[1]);
      drawMonKind((paramArrayOfMonster[this.select[0][0]]).monster[4], paramInt1 + 19 + 50 + 4, paramInt2 + 76 + 28, 0);
    } 
  }
  
  private void drawMonsterFealty(Monster paramMonster, int paramInt1, int paramInt2) {
    byte b = paramMonster.monster[4];
    byte[] arrayOfByte = this.initFealty;
    if (b < 4) {
      b = 0;
    } else {
      b = 1;
    } 
    drawFealty((byte)(arrayOfByte[b] / 20), (byte)(paramMonster.monster[6] / 20), paramInt1, paramInt2);
  }
  
  private void drawMonsterHp(Monster paramMonster, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    int i;
    short s;
    if (paramInt4 < 2) {
      s = paramMonster.monsterPro[paramInt4 + 0];
      short s1 = paramMonster.monsterPro[paramInt4 + 2];
      i = paramInt6;
      paramInt6 = s1;
    } else {
      i = paramInt6;
      if (paramInt6 == 0)
        i = paramMonster.monsterPro[4]; 
      s = (short)i;
      paramInt6 = getMonsterExp(paramMonster);
    } 
    Ui.i().drawBarOne(paramInt1, paramInt2, paramInt3, Ms.i().mathPercent(i, paramInt3 - 2, paramInt6), Ms.i().mathPercent(s, paramInt3 - 2, paramInt6), paramInt4);
    if (paramInt5 != 2) {
      String str = String.valueOf(s) + "/" + paramInt6;
      Ui ui = Ui.i();
      paramInt6 = str.length();
      if (paramInt5 == 1) {
        paramInt4 = 5;
      } else {
        paramInt4 = 0;
      } 
      ui.drawNum(str, (paramInt3 - paramInt6 * 8 >> 1) + paramInt1, paramInt4 + paramInt2, 0, 0);
    } 
  }
  
  private void drawMyMonState() {
    Ui.i().drawK(10, 140, 179, 110, 2);
    Ui.i().drawKuang(10 + 2, 140 + 2, 147, 33);
    Ui.i().drawUi((this.myB.getMon()).monster[3] + 5, 10 + 16, 140 + 16, 3, 0);
    Ui.i().drawString(getNameMon((this.myB.getMon()).monster[0]).toString(), 10 + 75 + 14, 140 + 1, 17, 4, 2);
    Ui.i().drawNum(String.valueOf((this.myB.getMon()).monster[2]) + "级", 10 + 125 + 27, 140 + 20, 0, 0);
    Ui.i().drawK0(10 + 2, 140 + 25 + 11, 62, 14, 4);
    Ui.i().drawUi(34, 10 + 4, 140 + 25 + 12, 0, 0);
    Ui.i().drawNum(String.valueOf(this.myB.countS[0] + 100) + "%", 10 + 60, 140 + 25 + 24, 1, 1);
    Ui.i().drawString("宠物档次", 10 + 2, 140 + 25 + 30, 20, 4, 2);
    drawMonKind((this.myB.getMon()).monster[4], 10 + 100 + 8, 140 + 25 + 38, 0);
    Ui.i().drawString("兴奋度", 10 + 2, 140 + 50 + 32, 20, 4, 2);
    drawMonsterFealty(this.myB.getMon(), 10 + 100 + 4, 140 + 50 + 42);
  }
  
  private void drawNidus(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mini_state : B
    //   4: bipush #16
    //   6: if_icmpne -> 47
    //   9: aload_0
    //   10: aload_0
    //   11: getfield about_d : [Ljava/lang/StringBuffer;
    //   14: sipush #320
    //   17: bipush #75
    //   19: isub
    //   20: sipush #180
    //   23: aload_0
    //   24: getfield about_d : [Ljava/lang/StringBuffer;
    //   27: arraylength
    //   28: iconst_1
    //   29: ishr
    //   30: bipush #25
    //   32: imul
    //   33: isub
    //   34: sipush #150
    //   37: iconst_1
    //   38: iconst_0
    //   39: aload_0
    //   40: getfield popMenu : B
    //   43: invokevirtual drawSelectMenu : ([Ljava/lang/Object;IIIIII)V
    //   46: return
    //   47: invokestatic i : ()Ldm/Ui;
    //   50: invokevirtual fillRectB : ()V
    //   53: aload_0
    //   54: aload_0
    //   55: getfield bg_c : B
    //   58: iload_1
    //   59: iconst_1
    //   60: iadd
    //   61: bipush #108
    //   63: iconst_0
    //   64: iload_2
    //   65: invokespecial drawBG0 : (IIIII)V
    //   68: ldc_w 'sk'
    //   71: ldc_w 'drawNidus'
    //   74: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: invokestatic i : ()Ldm/Ui;
    //   81: new java/lang/StringBuilder
    //   84: dup
    //   85: aload_0
    //   86: getfield popMenu : B
    //   89: iconst_1
    //   90: iadd
    //   91: invokestatic valueOf : (I)Ljava/lang/String;
    //   94: invokespecial <init> : (Ljava/lang/String;)V
    //   97: ldc_w '/'
    //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: iconst_5
    //   104: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   107: invokevirtual toString : ()Ljava/lang/String;
    //   110: iload_1
    //   111: bipush #10
    //   113: iadd
    //   114: bipush #106
    //   116: bipush #36
    //   118: iconst_0
    //   119: iconst_2
    //   120: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   123: invokestatic i : ()Ldm/Ui;
    //   126: astore #8
    //   128: aload_0
    //   129: aload_0
    //   130: getfield popMenu : B
    //   133: invokevirtual getRid : (I)B
    //   136: bipush #-2
    //   138: if_icmpne -> 656
    //   141: ldc_w '此位置目前是空的'
    //   144: astore #7
    //   146: aload #8
    //   148: aload #7
    //   150: iload_1
    //   151: bipush #20
    //   153: iadd
    //   154: bipush #110
    //   156: iconst_0
    //   157: iconst_1
    //   158: iconst_0
    //   159: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   162: aload_0
    //   163: aload_0
    //   164: getfield popMenu : B
    //   167: invokevirtual getRid : (I)B
    //   170: bipush #-2
    //   172: if_icmpeq -> 550
    //   175: aload_0
    //   176: getfield b_c : B
    //   179: iconst_2
    //   180: if_icmpge -> 707
    //   183: aload_0
    //   184: getfield mon_action : B
    //   187: istore #4
    //   189: aload_0
    //   190: getfield b_c : B
    //   193: iconst_1
    //   194: if_icmpne -> 701
    //   197: iconst_0
    //   198: istore #5
    //   200: aload_0
    //   201: iconst_1
    //   202: iconst_1
    //   203: iload #4
    //   205: sipush #377
    //   208: bipush #97
    //   210: iload #5
    //   212: iconst_0
    //   213: invokevirtual drawCartoonOne : (IIIIIZI)Z
    //   216: ifeq -> 707
    //   219: aload_0
    //   220: iconst_2
    //   221: aload_0
    //   222: getfield mList_id : [[B
    //   225: aload_0
    //   226: aload_0
    //   227: getfield popMenu : B
    //   230: invokevirtual getNid : (I)B
    //   233: aaload
    //   234: iconst_0
    //   235: baload
    //   236: iconst_1
    //   237: invokevirtual initMonStream : (III)V
    //   240: aload_0
    //   241: iconst_2
    //   242: putfield b_c : B
    //   245: aload_0
    //   246: getfield b_c : B
    //   249: iconst_m1
    //   250: if_icmpeq -> 819
    //   253: iload_2
    //   254: bipush #40
    //   256: isub
    //   257: i2s
    //   258: istore_2
    //   259: aload_0
    //   260: new java/lang/StringBuilder
    //   263: dup
    //   264: aload_0
    //   265: aload_0
    //   266: getfield popMenu : B
    //   269: iconst_1
    //   270: invokevirtual getNexp : (II)S
    //   273: invokestatic valueOf : (I)Ljava/lang/String;
    //   276: invokespecial <init> : (Ljava/lang/String;)V
    //   279: ldc_w '/'
    //   282: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_0
    //   286: aload_0
    //   287: getfield popMenu : B
    //   290: iconst_3
    //   291: invokevirtual getNexp : (II)S
    //   294: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   297: invokevirtual toString : ()Ljava/lang/String;
    //   300: putfield str_cur : Ljava/lang/String;
    //   303: invokestatic i : ()Ldm/Ui;
    //   306: iload_1
    //   307: bipush #20
    //   309: iadd
    //   310: sipush #158
    //   313: iload_2
    //   314: invokestatic i : ()Ldm/Ms;
    //   317: aload_0
    //   318: aload_0
    //   319: getfield popMenu : B
    //   322: iconst_1
    //   323: invokevirtual getNexp : (II)S
    //   326: iload_2
    //   327: iconst_2
    //   328: isub
    //   329: aload_0
    //   330: aload_0
    //   331: getfield popMenu : B
    //   334: iconst_3
    //   335: invokevirtual getNexp : (II)S
    //   338: invokevirtual mathPercent : (III)S
    //   341: invokestatic i : ()Ldm/Ms;
    //   344: aload_0
    //   345: aload_0
    //   346: getfield popMenu : B
    //   349: iconst_1
    //   350: invokevirtual getNexp : (II)S
    //   353: iload_2
    //   354: iconst_2
    //   355: isub
    //   356: aload_0
    //   357: aload_0
    //   358: getfield popMenu : B
    //   361: iconst_3
    //   362: invokevirtual getNexp : (II)S
    //   365: invokevirtual mathPercent : (III)S
    //   368: iconst_2
    //   369: invokevirtual drawBarOne : (IIIIII)V
    //   372: invokestatic i : ()Ldm/Ui;
    //   375: aload_0
    //   376: getfield str_cur : Ljava/lang/String;
    //   379: iload_1
    //   380: bipush #20
    //   382: iadd
    //   383: iload_2
    //   384: aload_0
    //   385: getfield str_cur : Ljava/lang/String;
    //   388: invokevirtual length : ()I
    //   391: bipush #8
    //   393: imul
    //   394: isub
    //   395: iconst_1
    //   396: ishr
    //   397: iadd
    //   398: sipush #164
    //   401: iconst_0
    //   402: iconst_0
    //   403: invokevirtual drawNum : (Ljava/lang/String;IIII)V
    //   406: invokestatic i : ()Ldm/Ui;
    //   409: astore #8
    //   411: aload_0
    //   412: aload_0
    //   413: getfield popMenu : B
    //   416: iconst_1
    //   417: invokevirtual getNexp : (II)S
    //   420: aload_0
    //   421: aload_0
    //   422: getfield popMenu : B
    //   425: iconst_3
    //   426: invokevirtual getNexp : (II)S
    //   429: if_icmpne -> 811
    //   432: ldc_w '孵化已完成'
    //   435: astore #7
    //   437: aload #8
    //   439: aload #7
    //   441: iload_1
    //   442: bipush #20
    //   444: iadd
    //   445: iload_2
    //   446: iconst_1
    //   447: ishr
    //   448: iadd
    //   449: sipush #164
    //   452: bipush #17
    //   454: iconst_3
    //   455: iconst_1
    //   456: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   459: invokestatic i : ()Ldm/Ui;
    //   462: ldc_w '孵化所需材料'
    //   465: iload_1
    //   466: bipush #20
    //   468: iadd
    //   469: iload_2
    //   470: iconst_1
    //   471: ishr
    //   472: iadd
    //   473: sipush #208
    //   476: bipush #17
    //   478: iconst_3
    //   479: iconst_1
    //   480: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   483: aload_0
    //   484: aload_0
    //   485: aload_0
    //   486: getfield popMenu : B
    //   489: invokevirtual getNid : (I)B
    //   492: iload_1
    //   493: bipush #25
    //   495: iadd
    //   496: sipush #239
    //   499: bipush #28
    //   501: invokespecial drawEvolveMake : (IIII)V
    //   504: aload_0
    //   505: aload_0
    //   506: getfield popMenu : B
    //   509: iconst_1
    //   510: invokevirtual getNexp : (II)S
    //   513: aload_0
    //   514: aload_0
    //   515: getfield popMenu : B
    //   518: iconst_3
    //   519: invokevirtual getNexp : (II)S
    //   522: if_icmpne -> 550
    //   525: invokestatic i : ()Ldm/Ui;
    //   528: ldc_w '按确定键完成孵化'
    //   531: iload_1
    //   532: bipush #20
    //   534: iadd
    //   535: sipush #360
    //   538: bipush #25
    //   540: isub
    //   541: bipush #21
    //   543: isub
    //   544: iconst_0
    //   545: iconst_0
    //   546: iconst_0
    //   547: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   550: aload_0
    //   551: getfield b_c : B
    //   554: bipush #-2
    //   556: if_icmpne -> 575
    //   559: invokestatic i : ()Ldm/Ui;
    //   562: sipush #320
    //   565: bipush #120
    //   567: sipush #150
    //   570: iconst_1
    //   571: iconst_1
    //   572: invokevirtual drawTriangle : (IIIZZ)V
    //   575: invokestatic i : ()Ldm/Ui;
    //   578: astore #7
    //   580: aload_0
    //   581: aload_0
    //   582: getfield popMenu : B
    //   585: invokevirtual getRid : (I)B
    //   588: bipush #-2
    //   590: if_icmpne -> 923
    //   593: iconst_0
    //   594: istore #5
    //   596: aload_0
    //   597: getfield b_c : B
    //   600: iconst_m1
    //   601: if_icmpeq -> 929
    //   604: iconst_1
    //   605: istore #6
    //   607: aload #7
    //   609: iload #5
    //   611: iload #6
    //   613: invokevirtual drawYesNo : (ZZ)V
    //   616: aload_0
    //   617: getfield pkey : Lmain/PointerKey;
    //   620: iconst_2
    //   621: iconst_0
    //   622: iconst_0
    //   623: sipush #320
    //   626: sipush #360
    //   629: invokevirtual selectMenuX : (IIIII)B
    //   632: istore_1
    //   633: iload_1
    //   634: iconst_m1
    //   635: if_icmpeq -> 46
    //   638: iload_1
    //   639: ifne -> 935
    //   642: bipush #-3
    //   644: istore_1
    //   645: iload_1
    //   646: putstatic dm/Ms.key : I
    //   649: iconst_1
    //   650: putstatic dm/Ms.keyRepeat : Z
    //   653: goto -> 46
    //   656: new java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial <init> : ()V
    //   663: aload_0
    //   664: getfield monsterT : [Ljava/lang/StringBuffer;
    //   667: aload_0
    //   668: getfield monster_pro : [[B
    //   671: aload_0
    //   672: aload_0
    //   673: getfield popMenu : B
    //   676: invokevirtual getNid : (I)B
    //   679: aaload
    //   680: bipush #6
    //   682: baload
    //   683: aaload
    //   684: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   687: ldc_w '的宠物蛋'
    //   690: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: invokevirtual toString : ()Ljava/lang/String;
    //   696: astore #7
    //   698: goto -> 146
    //   701: iconst_1
    //   702: istore #5
    //   704: goto -> 200
    //   707: aload_0
    //   708: getfield b_c : B
    //   711: iconst_1
    //   712: if_icmple -> 245
    //   715: aload_0
    //   716: getfield b_c : B
    //   719: bipush #14
    //   721: if_icmpge -> 245
    //   724: aload_0
    //   725: aload_0
    //   726: getfield mList_id : [[B
    //   729: aload_0
    //   730: aload_0
    //   731: getfield popMenu : B
    //   734: invokevirtual getNid : (I)B
    //   737: aaload
    //   738: iconst_1
    //   739: baload
    //   740: iconst_1
    //   741: sipush #377
    //   744: bipush #97
    //   746: bipush #80
    //   748: bipush #77
    //   750: bipush #15
    //   752: aload_0
    //   753: getfield b_c : B
    //   756: iconst_2
    //   757: isub
    //   758: iconst_0
    //   759: invokespecial drawClipPic : (IIIIIIIII)V
    //   762: aload_0
    //   763: getfield b_c : B
    //   766: iconst_1
    //   767: iadd
    //   768: i2b
    //   769: istore_3
    //   770: aload_0
    //   771: iload_3
    //   772: putfield b_c : B
    //   775: iload_3
    //   776: bipush #14
    //   778: if_icmpne -> 786
    //   781: aload_0
    //   782: iconst_m1
    //   783: putfield b_c : B
    //   786: aload_0
    //   787: aload_0
    //   788: getfield mList_id : [[B
    //   791: aload_0
    //   792: aload_0
    //   793: getfield popMenu : B
    //   796: invokevirtual getNid : (I)B
    //   799: aaload
    //   800: iconst_1
    //   801: baload
    //   802: iconst_3
    //   803: imul
    //   804: i2b
    //   805: putfield mon_action : B
    //   808: goto -> 245
    //   811: ldc_w '孵化中...'
    //   814: astore #7
    //   816: goto -> 437
    //   819: invokestatic i : ()Ldm/Ui;
    //   822: aload_0
    //   823: getfield about_a : [Ljava/lang/StringBuffer;
    //   826: iload_1
    //   827: bipush #26
    //   829: iadd
    //   830: sipush #155
    //   833: iconst_0
    //   834: iconst_3
    //   835: bipush #30
    //   837: iconst_3
    //   838: iconst_0
    //   839: invokevirtual drawStringY : ([Ljava/lang/Object;IIIIIII)V
    //   842: invokestatic i : ()Ldm/Ui;
    //   845: aload_0
    //   846: getfield about_b : [Ljava/lang/StringBuffer;
    //   849: iload_1
    //   850: bipush #126
    //   852: iadd
    //   853: sipush #155
    //   856: iconst_0
    //   857: iconst_3
    //   858: bipush #30
    //   860: iconst_3
    //   861: iconst_0
    //   862: invokevirtual drawStringY : ([Ljava/lang/Object;IIIIIII)V
    //   865: invokestatic i : ()Ldm/Ui;
    //   868: ldc_w '档次：'
    //   871: iload_1
    //   872: bipush #20
    //   874: iadd
    //   875: bipush #50
    //   877: iadd
    //   878: sipush #258
    //   881: iconst_0
    //   882: iconst_3
    //   883: iconst_1
    //   884: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   887: aload_0
    //   888: aload_0
    //   889: getfield monster_pro : [[B
    //   892: aload_0
    //   893: aload_0
    //   894: getfield popMenu : B
    //   897: invokevirtual getNid : (I)B
    //   900: aaload
    //   901: iconst_5
    //   902: baload
    //   903: iload_1
    //   904: bipush #23
    //   906: iadd
    //   907: bipush #100
    //   909: iadd
    //   910: bipush #10
    //   912: iadd
    //   913: sipush #263
    //   916: iconst_0
    //   917: invokespecial drawMonKind : (BIII)V
    //   920: goto -> 504
    //   923: iconst_1
    //   924: istore #5
    //   926: goto -> 596
    //   929: iconst_0
    //   930: istore #6
    //   932: goto -> 607
    //   935: bipush #-4
    //   937: istore_1
    //   938: goto -> 645
  }
  
  private void drawPlayer(Graphics paramGraphics) {
    drawMyMon();
    drawMyMonState();
    drawEnemy();
    drawEnemyState();
  }
  
  private void drawPlayerAppear(Graphics paramGraphics) {
    switch (this.battle_state) {
      default:
        return;
      case 0:
        break;
    } 
    if (this.battle_type > 2) {
      if (this.src_c[2] == 0 && this.enB.throw_state == -1 && this.src_c[0] == 12) {
        this.enB.throw_state = 0;
      } else if (this.enB.throw_state == 0 || this.enB.throw_state == 2) {
        drawCartoonOne(0, 0, this.mList_id[(this.enB.getMon()).monster[0]][1] * 3 + this.enB.action, this.enemyOff + 377, 97, false, 0);
        this.enemyOff = Ms.i().mathSpeedN(this.enemyOff, 0, 4, false);
        if (this.enemyOff == 0)
          this.enB.throw_state = 2; 
      } 
    } else if (this.battle_type < 2) {
      drawThrowBall(this.enB, this.enB.getMon(), 0, 377, 97);
    } 
    drawThrowBall(this.myB, this.myB.getMon(), 1, 266, 236);
  }
  
  private void drawSelectMenu(Graphics paramGraphics, boolean paramBoolean, int paramInt) {
    Ui.i().drawK2(200, paramInt + 15, 240, 360 - paramInt - 20, 0);
    drawBattleExp(this.myB.getMon(), paramInt + 3);
    if (!paramBoolean) {
      Ui.i().drawString("要做什么？", 450, 10, 0, 0, 2);
      paramInt = 0;
      while (true) {
        if (paramInt < this.imgBattle.length) {
          Ui.i().drawImage(this.imgBattle[paramInt], this.pkey.button_pos[5][paramInt][0], this.pkey.button_pos[5][paramInt][1], 0);
          paramInt = (byte)(paramInt + 1);
          continue;
        } 
        return;
      } 
    } 
  }
  
  private void drawSkillList(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfbyte) {
    byte b = paramArrayOfbyte[1];
    Ui.i().drawListKY(paramInt5, paramInt1, paramInt2, paramInt3, 3, paramInt4, 0, paramArrayOfbyte[0] - paramArrayOfbyte[1], 4, 2);
    while (true) {
      byte b1;
      String str1;
      if (b >= paramArrayOfbyte[1] + paramInt5 || b >= this.skill_list[8])
        return; 
      Ui ui1 = Ui.i();
      if (this.skill_list[b] > 25) {
        b1 = 50;
      } else {
        b1 = 51;
      } 
      ui1.drawUi(b1, paramInt1 + 8, paramInt2 + 8 + (b - paramArrayOfbyte[1]) * paramInt4, 0, 0);
      Log.e("sk", "普通攻击");
      ui1 = Ui.i();
      String str2 = getNameSkill(this.skill_list[b]).toString();
      byte b2 = paramArrayOfbyte[1];
      if (paramArrayOfbyte[0] == b) {
        b1 = 0;
      } else {
        b1 = 3;
      } 
      ui1.drawString(str2, paramInt1 + 21, paramInt2 + 1 + (b - b2) * paramInt4, 0, b1, 0);
      Ui ui2 = Ui.i();
      if (this.skill_list[b] <= 30) {
        str1 = String.valueOf(this.skill[this.skill_list[b]][1]) + "能量";
      } else {
        str1 = "被动";
      } 
      b2 = paramArrayOfbyte[1];
      Graphics graphics = g;
      graphics = g;
      if (paramArrayOfbyte[0] == b) {
        b1 = 0;
      } else {
        b1 = 3;
      } 
      ui2.drawString(str1, paramInt1 + paramInt3 - 8, paramInt2 + 1 + (b - b2) * paramInt4, 0x8 | 0x10, b1, 0);
      if (this.say_c < 1 && this.pkey.isSelect(paramInt1, (b - paramArrayOfbyte[1]) * paramInt4 + paramInt2, paramInt3, paramInt4))
        if (paramArrayOfbyte[0] == b) {
          this.pkey.setKey5();
        } else {
          paramArrayOfbyte[0] = b;
          if (b - paramArrayOfbyte[1] == 0 && paramArrayOfbyte[1] > 0) {
            paramArrayOfbyte[1] = (byte)(paramArrayOfbyte[1] - 1);
          } else if (b - paramArrayOfbyte[1] == paramInt5 - 1 && paramArrayOfbyte[1] + paramInt5 < this.skill_list[8]) {
            paramArrayOfbyte[1] = (byte)(paramArrayOfbyte[1] + 1);
          } 
        }  
      b = (byte)(b + 1);
    } 
  }
  
  private void drawThrowBall(Battle paramBattle, Monster paramMonster, int paramInt1, int paramInt2, int paramInt3) {
    if (paramBattle.throw_state == 0) {
      Ui ui = Ui.i();
      Image image = this.imgItem[0];
      short s1 = paramBattle.cThrow[0];
      short s2 = paramBattle.cThrow[1];
      Graphics graphics = g;
      graphics = g;
      ui.drawImage(image, s1 + paramInt2, paramInt3 - s2, 0x1 | 0x20);
    } else if (paramBattle.throw_state == 1) {
      drawClipPic(this.mList_id[paramMonster.monster[0]][1], paramInt1, paramInt2, paramInt3, 80, 77, 15, paramBattle.cThrow[2], paramInt1);
    } else if (paramBattle.throw_state == 2) {
      drawCartoonOne(paramInt1, paramInt1, this.mList_id[paramMonster.monster[0]][1] * 3, paramInt2, paramInt3, true, paramInt1);
    } 
    runThrowBall(paramBattle, paramMonster, paramInt1);
  }
  
  private void drawVIEW_COMPUTER() {
    Ui.i().drawK2(320 - 25 * 2 - 8, 180 - 25 * 2 - 8, 25 * 4 + 16, 25 * 6 + 16, 0);
    drawSelectMenu((Object[])this.about_d, 320 - 25 - 4, 180 - 25, (25 + 4) * 2, 2, 0, this.popMenu);
    Ui.i().drawString("寄存宠物", 320, 180 - 25 * 2 - 6, 17, 1, 1);
    Ui.i().drawYesNo(true, true);
  }
  
  private void effectR(Monster paramMonster) {
    if (paramMonster.effect_time > 0)
      paramMonster.effect_time = (byte)(paramMonster.effect_time - 1); 
    if (paramMonster.effect_time == 0)
      paramMonster.effect = 7; 
  }
  
  private void enemy_init() {
    Monster[] arrayOfMonster = new Monster[this.enemyList.length];
    for (byte b = 0;; b++) {
      boolean bool;
      if (b >= this.enemyList.length) {
        this.enemyList = null;
        this.enB = new Battle(arrayOfMonster);
        return;
      } 
      byte b1 = this.enemyList[b][0];
      byte b2 = this.enemyList[b][1];
      if (this.myMonsters[0].isMonReel(39)) {
        bool = true;
      } else {
        bool = false;
      } 
      arrayOfMonster[b] = new Monster(this, b1, b2, bool);
      if (this.battle_type == 3 || this.battle_type == 0) {
        if ((arrayOfMonster[b]).monster[3] == -1) {
          arrayOfMonster[b].resetBoss(this.enemyList[b][4]);
        } else {
          arrayOfMonster[b].resetMonster(this.enemyList[b][2], this.enemyList[b][3], this.enemyList[b][4]);
        } 
        arrayOfMonster[b].resetPro(this);
      } else {
        arrayOfMonster[b].resetMonster(this, -1);
      } 
    } 
  }
  
  private int getBXY(int paramInt1, int paramInt2, boolean paramBoolean) {
    // Byte code:
    //   0: sipush #266
    //   3: istore #6
    //   5: sipush #236
    //   8: istore #7
    //   10: iload_1
    //   11: iconst_1
    //   12: if_icmpne -> 23
    //   15: aload_0
    //   16: iload_2
    //   17: invokespecial isSkillToMe : (I)Z
    //   20: ifeq -> 51
    //   23: iload #6
    //   25: istore #5
    //   27: iload #7
    //   29: istore #4
    //   31: iload_1
    //   32: ifne -> 60
    //   35: iload #6
    //   37: istore #5
    //   39: iload #7
    //   41: istore #4
    //   43: aload_0
    //   44: iload_2
    //   45: invokespecial isSkillToMe : (I)Z
    //   48: ifeq -> 60
    //   51: sipush #377
    //   54: istore #5
    //   56: bipush #97
    //   58: istore #4
    //   60: iload_3
    //   61: ifeq -> 67
    //   64: iload #5
    //   66: ireturn
    //   67: iload #4
    //   69: istore #5
    //   71: goto -> 64
  }
  
  private void getBattleBG(Battle paramBattle, Monster paramMonster) {
    if (this.monPro.length != 0)
      paramBattle.bg_id = this.monPro[0]; 
    byte b = 0;
    while (true) {
      if (b < 5) {
        if (paramMonster.isMonReel(b + 43)) {
          paramBattle.bg_id = b;
          return;
        } 
        b = (byte)(b + 1);
        continue;
      } 
      return;
    } 
  }
  
  private int getBuyItemCount(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramBoolean) {
      if (paramInt1 == 2) {
        paramInt1 = this.coin / this.sell_money;
      } else {
        paramInt1 = this.money / this.sell_money;
      } 
      int i = 99 - findItem(-2, this.buyItem[this.cur_a][paramInt2], true);
      paramInt2 = i;
      if (i < 0)
        paramInt2 = 0; 
      if (paramInt1 > paramInt2)
        paramInt1 = paramInt2; 
      return paramInt1;
    } 
    return this.items[this.cur_a][paramInt2][1];
  }
  
  private void getExpOne(boolean paramBoolean) {
    byte b = 0;
    this.exp = 0;
    Ms.i();
    Ms.skip2 = (this.enB.mon[0]).monster[2];
    while (true) {
      if (b >= this.enB.mon.length) {
        this.exp = (short)(this.exp * (56 / this.mon_in_battle[0] - (this.mon_in_battle[0] - 1) * 2 + 44) / 100);
        if (!paramBoolean)
          this.exp = (short)(this.exp / 2); 
        return;
      } 
      this.exp = (short)(this.exp + (this.enB.mon[b]).monster[2] * 3 + 80);
      byte b1 = (this.enB.mon[b]).monster[2];
      Ms.i();
      if (b1 > Ms.skip2) {
        Ms.i();
        Ms.skip2 = (this.enB.mon[b]).monster[2];
      } 
      b = (byte)(b + 1);
    } 
  }
  
  private void getHitCoefficient(Battle paramBattle, Monster paramMonster1, Monster paramMonster2) {
    paramBattle.countS[1] = 0;
    int i = (byte)(paramMonster1.monster[6] - 99);
    byte[] arrayOfByte2 = paramBattle.countS;
    byte b = arrayOfByte2[1];
    if (i > 1) {
      i = 20;
    } else {
      i = i / 20 * 20;
    } 
    arrayOfByte2[1] = (byte)(b + i);
    if (paramMonster1.monster[3] != -1 && paramBattle.bg_id != paramMonster1.monster[3]) {
      arrayOfByte2 = paramBattle.countS;
      b = arrayOfByte2[1];
      if (paramBattle.bg_id == paramMonster1.monster[3]) {
        i = 0;
      } else {
        i = -20;
      } 
      arrayOfByte2[1] = (byte)(b + i);
    } 
    byte[] arrayOfByte1 = paramBattle.countS;
    arrayOfByte1[1] = (byte)(arrayOfByte1[1] + isShuXing(paramMonster1, paramMonster2));
  }
  
  private String getInfoType(int paramInt) {
    return (paramInt == -1) ? "任务" : ((paramInt == -2) ? "进化" : ((paramInt == -3) ? "异化" : ((paramInt == -4) ? "竞技场" : ((paramInt == -5) ? "孵化" : "捕获"))));
  }
  
  private byte getMonInfo_dir() {
    return this.monInfo_dir[this.cur_a][getSelInfo()];
  }
  
  private byte getMonster(Monster paramMonster, int paramInt, boolean paramBoolean) {
    if (this.monInfoList[paramMonster.monster[0]] != 2) {
      this.monInfoList[paramMonster.monster[0]] = 2;
      addMonInfoListBH();
      this.map.addAnole(paramMonster.monster[0]);
    } 
    if (this.myMon_length < this.max_takes) {
      this.myMonsters[this.myMon_length] = paramMonster;
      if (paramBoolean)
        this.myMonsters[this.myMon_length].resetMonster(this, paramInt); 
      this.myMon_length = (byte)(this.myMon_length + 1);
      return 0;
    } 
    if (this.cMon_count < this.max_monsters) {
      say("携带已满，" + getNameMon(paramMonster.monster[0]) + "已转入寄放处", 0);
      this.cMonsters[this.cMon_count] = paramMonster;
      if (paramBoolean)
        this.cMonsters[this.cMon_count].resetMonster(this, paramInt); 
      this.cMon_count = (byte)(this.cMon_count + 1);
      return 1;
    } 
    return -1;
  }
  
  private short getMonsterExp(Monster paramMonster) {
    return (short)(paramMonster.monster[2] * 210 / 10 - 2);
  }
  
  private String getNameBuff(int paramInt) {
    int i = paramInt;
    if (paramInt < 1)
      i = 0; 
    return this.buff_name[i].toString();
  }
  
  private String getNameSkill(byte paramByte) {
    return this.skill_name[paramByte].toString();
  }
  
  private short getPrice(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramBoolean) {
      short s;
      if (paramInt1 == 2) {
        s = this.buyPrice[1][paramInt2];
      } else {
        s = this.buyPrice[0][this.buyItem[this.cur_a][paramInt2]];
      } 
      short s1 = s;
      if (this.view_state == -1)
        s1 = (short)(s * 12 / 10); 
      return s1;
    } 
    return (short)(this.buyPrice[0][paramInt2] / 5);
  }
  
  private byte getSelInfo() {
    return this.select[0][0];
  }
  
  private void getSkill(int paramInt1, int paramInt2) {
    byte b;
    if (paramInt1 == 0) {
      b = 25;
    } else {
      b = this.skill_up[paramInt1 - 1][paramInt2];
    } 
    this.getSkill = b;
  }
  
  private int getSkillLevel(int paramInt) {
    return (paramInt == 25) ? 0 : ((paramInt < 25) ? (paramInt % 5 + 1) : this.makeLevel[paramInt - 25 - 1]);
  }
  
  private int getSkillMana(Monster paramMonster, int paramInt) {
    byte b = this.skill[paramInt][1];
    return (paramMonster.monster[3] == 4 && paramMonster.isMonReel(35)) ? (this.skill[paramInt][0] * b / 100) : b;
  }
  
  private short getbuffRateV(Monster paramMonster, int paramInt) {
    if (paramMonster.isBuffRate(2)) {
      int j = paramInt + this.inhesion[2] * paramInt / 100;
      return (short)j;
    } 
    int i = paramInt;
    if (paramMonster.isBuffRate(1))
      i = paramInt + this.inhesion[1] * paramInt / 100; 
    return (short)i;
  }
  
  private void goBattleExp(boolean paramBoolean) {
    this.battle_state = -5;
    this.cur_c = 0;
    this.b_c = 0;
    this.myB.now_id = (this.myMonsters[this.myB.now_id]).monster[1];
    this.proReplace[this.myB.now_id][2] = -2;
    arangeMonster();
    getExpOne(paramBoolean);
  }
  
  private void goBattleItem() {
    this.battle_state = -4;
    this.cur_b = -1;
    StringBuffer stringBuffer = new StringBuffer();
    Ms.i();
    if (Ms.getRandom(100) < 50 && findItem(-2, 32, true) < 99) {
      addItem(32, 1);
      stringBuffer.append("获得：" + getNameItem(32) + "x1");
    } 
    setStringB(stringBuffer.toString(), 10000, 0);
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
    boolean bool;
    setAction_str(new String[] { "攻击", "道具", "宠物", "商店", "逃跑" });
    run_state = -31;
    if (this.mini_state == 1) {
      bool = true;
    } else {
      bool = true;
    } 
    this.battle_state = bool;
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
  
  private void goLIST_INFO(boolean paramBoolean) {
    run_state = 68;
    if (this.monInfo_dir == null) {
      byte[] arrayOfByte = Ms.i().getStream("data/book.d", -1);
      Ms.i();
      Ms.skip = 0;
      this.monInfo_dir = Ms.i().create2Array(arrayOfByte);
      arrayOfByte = (byte[])null;
    } 
    if (paramBoolean) {
      this.infoStart = 0;
      this.cur_a = 0;
      this.cur_b = 0;
      this.move_x = 6;
      this.move_y = 0;
      this.t_length = (byte)(this.monInfo_dir[this.cur_a]).length;
      this.select[0][0] = 0;
      this.select[0][1] = 0;
    } 
    this.list_rows = 7;
  }
  
  private void goMONSTER_INFO(int paramInt) {
    run_state = 67;
    initMonStream(2, this.mList_id[paramInt][0], 1);
  }
  
  private void goMY_BAG(int paramInt) {
    this.mini_state = 15;
    this.list_rows = 6;
    run_state = 25;
    this.popMenu = -1;
    if (this.view_state == 1) {
      setAction_str(new String[] { "道具", "辅助", "卷轴", "孵化" });
    } else if (this.view_state == -1) {
      setAction_str(new String[] { "道具" });
    } else if (this.view_state == 2) {
      setAction_str(new String[] { "孵化" });
    } 
    this.selectx = (byte)paramInt;
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
    setAimBattle(1);
  }
  
  private void goRUN_IN_MAP(boolean paramBoolean) {
    this.selecty = 0;
    this.selectx = 0;
    this.select[0][1] = 0;
    this.mini_state = 0;
    this.view_state = 0;
    mc.game_state = 30;
    System.out.println("aaaaaaaaaaaaaaaaa");
    this.map.my.state = 0;
    if (!this.isChangeSound.booleanValue()) {
      Sound.i().setMusicId(this.musicNo[this.map.mapNo]);
      Sound.i().setMusic(paramBoolean);
      Log.d("soars", "tttttttttttttttttttttt");
    } 
    if (this.isChangeSound.booleanValue()) {
      Sound.i().setMusicId(this.musicNo[this.map.mapNo]);
      Sound.i().setMusicForMenu(paramBoolean);
      Log.d("soars", "ffffffffffffffffffffffffffffffff");
    } 
    run_state = -10;
    this.createOver = 0;
    this.buyItemID = 0;
  }
  
  private void goSelectAction(int paramInt) {
    boolean bool;
    run_state = -31;
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = true;
    } 
    this.battle_state = bool;
    setAimBattle(paramInt);
    if (paramInt == 1)
      initSkillList(this.myB.getMon()); 
    getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
    getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
  }
  
  private void goView() {
    this.select[0][1] = this.selectx;
    this.select[0][0] = this.selecty;
    this.cur_c = 0;
    this.popMenu = -1;
    setStringB("生命#n能量#n档次", Constants_H.WIDTH, 0);
    setStringB("力量#n防御#n敏捷", Constants_H.WIDTH, 1);
  }
  
  private void hit_rate(Battle paramBattle1, Battle paramBattle2, Monster paramMonster1, Monster paramMonster2, int paramInt) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual initHit : ()V
    //   4: aload_2
    //   5: invokevirtual initHit : ()V
    //   8: aload_0
    //   9: aload_3
    //   10: getfield monsterPro : [S
    //   13: iconst_5
    //   14: saload
    //   15: aload #4
    //   17: getfield monsterPro : [S
    //   20: iconst_5
    //   21: saload
    //   22: isub
    //   23: putfield hit_rate : I
    //   26: aload_0
    //   27: aload_0
    //   28: getfield hit_rate : I
    //   31: iconst_2
    //   32: idiv
    //   33: bipush #92
    //   35: iadd
    //   36: aload_1
    //   37: getfield rate_off : B
    //   40: iadd
    //   41: putfield hit_rate : I
    //   44: invokestatic i : ()Ldm/Ms;
    //   47: pop
    //   48: bipush #100
    //   50: invokestatic getRandom : (I)I
    //   53: i2b
    //   54: istore #6
    //   56: aload_1
    //   57: iconst_0
    //   58: putfield rate_off : B
    //   61: iload #5
    //   63: bipush #26
    //   65: if_icmple -> 172
    //   68: iload #5
    //   70: bipush #30
    //   72: if_icmpge -> 172
    //   75: iload #5
    //   77: tableswitch default -> 104, 27 -> 105, 28 -> 105, 29 -> 127
    //   104: return
    //   105: aload_1
    //   106: aload_0
    //   107: getfield skill : [[B
    //   110: iload #5
    //   112: aaload
    //   113: iconst_0
    //   114: baload
    //   115: ineg
    //   116: bipush #10
    //   118: imul
    //   119: iconst_1
    //   120: iconst_1
    //   121: invokevirtual addHit : (III)V
    //   124: goto -> 104
    //   127: aload_2
    //   128: aload_3
    //   129: getfield monsterPro : [S
    //   132: bipush #6
    //   134: saload
    //   135: aload_0
    //   136: getfield skill : [[B
    //   139: iload #5
    //   141: aaload
    //   142: iconst_0
    //   143: baload
    //   144: imul
    //   145: aload_3
    //   146: getfield monsterPro : [S
    //   149: iconst_1
    //   150: saload
    //   151: iadd
    //   152: iconst_1
    //   153: iconst_0
    //   154: invokevirtual addHit : (III)V
    //   157: aload_1
    //   158: aload_3
    //   159: getfield monsterPro : [S
    //   162: iconst_1
    //   163: saload
    //   164: iconst_4
    //   165: iconst_2
    //   166: invokevirtual addHit : (III)V
    //   169: goto -> 104
    //   172: iload #6
    //   174: aload_0
    //   175: getfield hit_rate : I
    //   178: if_icmplt -> 200
    //   181: aload_0
    //   182: getfield mini_state : B
    //   185: iconst_1
    //   186: if_icmpne -> 363
    //   189: aload_3
    //   190: getfield monster : [B
    //   193: iconst_2
    //   194: baload
    //   195: bipush #11
    //   197: if_icmpge -> 363
    //   200: aload_0
    //   201: aload_1
    //   202: aload_2
    //   203: aload_3
    //   204: aload #4
    //   206: iload #5
    //   208: aload_0
    //   209: getfield mini_state : B
    //   212: iconst_1
    //   213: ixor
    //   214: invokespecial damage : (Ldm/Battle;Ldm/Battle;Ldm/Monster;Ldm/Monster;II)V
    //   217: iload #5
    //   219: bipush #26
    //   221: if_icmpne -> 335
    //   224: aload_2
    //   225: invokevirtual getMon : ()Ldm/Monster;
    //   228: bipush #40
    //   230: invokevirtual isMonReel : (I)Z
    //   233: ifne -> 335
    //   236: invokestatic i : ()Ldm/Ms;
    //   239: pop
    //   240: bipush #100
    //   242: invokestatic getRandom : (I)I
    //   245: aload_0
    //   246: getfield skill : [[B
    //   249: iload #5
    //   251: aaload
    //   252: iconst_2
    //   253: baload
    //   254: if_icmpge -> 335
    //   257: aload_2
    //   258: aload_0
    //   259: getfield skill : [[B
    //   262: iload #5
    //   264: aaload
    //   265: iconst_3
    //   266: baload
    //   267: aload_2
    //   268: invokevirtual getMon : ()Ldm/Monster;
    //   271: getfield monster : [B
    //   274: bipush #6
    //   276: baload
    //   277: imul
    //   278: bipush #100
    //   280: idiv
    //   281: bipush #-2
    //   283: iconst_2
    //   284: invokevirtual addHit : (III)V
    //   287: aload_3
    //   288: getfield monster : [B
    //   291: iconst_3
    //   292: baload
    //   293: iconst_2
    //   294: if_icmpne -> 104
    //   297: aload_3
    //   298: bipush #34
    //   300: invokevirtual isMonReel : (I)Z
    //   303: ifeq -> 104
    //   306: aload_2
    //   307: aload #4
    //   309: getfield monsterPro : [S
    //   312: iconst_3
    //   313: saload
    //   314: aload_0
    //   315: getfield skill : [[B
    //   318: bipush #34
    //   320: aaload
    //   321: iconst_0
    //   322: baload
    //   323: imul
    //   324: bipush #100
    //   326: idiv
    //   327: iconst_4
    //   328: iconst_2
    //   329: invokevirtual addHit : (III)V
    //   332: goto -> 104
    //   335: iload #5
    //   337: bipush #25
    //   339: if_icmplt -> 349
    //   342: iload #5
    //   344: bipush #30
    //   346: if_icmpne -> 287
    //   349: aload_0
    //   350: aload_2
    //   351: aload_3
    //   352: aload #4
    //   354: iload #5
    //   356: invokespecial magicEffectRate : (Ldm/Battle;Ldm/Monster;Ldm/Monster;I)Z
    //   359: pop
    //   360: goto -> 287
    //   363: aload_2
    //   364: iconst_0
    //   365: iconst_m1
    //   366: iconst_2
    //   367: invokevirtual addHit : (III)V
    //   370: aload_1
    //   371: bipush #20
    //   373: putfield rate_off : B
    //   376: goto -> 104
  }
  
  private void hpAdd(int paramInt1, int paramInt2) {
    if ((this.myMonsters[this.select[0][0]]).monsterPro[0] < (this.myMonsters[this.select[0][0]]).monsterPro[2] && (this.myMonsters[this.select[0][0]]).monsterPro[0] > 0) {
      AddHP(paramInt2 + (this.myMonsters[this.select[0][0]]).monsterPro[2] * paramInt1 / 100, this.myMonsters[this.select[0][0]]);
      useState(0, this.select_it[0]);
      return;
    } 
    if ((this.myMonsters[this.select[0][0]]).monsterPro[0] < 1) {
      say(String.valueOf(getNameMon((this.myMonsters[this.select[0][0]]).monster[0])) + "已经死亡，无法使用！", 0);
      return;
    } 
    say(String.valueOf(getNameMon((this.myMonsters[this.select[0][0]]).monster[0])) + "不需要使用这个道具", 0);
  }
  
  private void initMagicStream(int paramInt) {
    if (this.magic[paramInt] == null) {
      String str = "data/battle/s" + paramInt;
      this.magic[paramInt] = Ms.i().createSprite(str, false);
    } 
  }
  
  private void initOtherImage() {
    if (this.imgItem == null) {
      this.imgItem = new Image[2];
      this.imgItem[0] = Ms.i().createImage("data/ball");
      this.imgItem[1] = Ms.i().createImage("data/ll");
      initItemModules();
    } 
    if (this.imgBG == null) {
      this.imgBG = new Image[5];
      byte b = 0;
      while (true) {
        if (b < this.imgBG.length) {
          this.imgBG[b] = Ms.i().createImage("data/battle/" + b);
          b = (byte)(b + 1);
          continue;
        } 
        initImgIco();
        return;
      } 
    } 
    initImgIco();
  }
  
  private boolean isBagUse(int paramInt) {
    return (this.view_state == -1) ? ((paramInt != 14 && paramInt != 15)) : ((paramInt != 9 && paramInt != 10 && paramInt != 11 && paramInt != 8));
  }
  
  private byte isEvolveKind(byte paramByte1, byte paramByte2) {
    byte b2 = -1;
    if (paramByte1 == 1 && paramByte2 < 15)
      return -2; 
    if (paramByte1 == 2 && paramByte2 < 25)
      return -3; 
    byte b1 = b2;
    if (paramByte1 == 3) {
      b1 = b2;
      if (paramByte2 < 30)
        b1 = -4; 
    } 
    return b1;
  }
  
  private byte isEvolveMake(int paramInt) {
    byte b1 = 2;
    byte b = this.monsterMake[paramInt][0];
    while (true) {
      if (findItem(-2, this.monsterMake[paramInt][b1], true) < this.monsterMake[paramInt][b1 + 1])
        return -1; 
      byte b2 = (byte)(b1 + 2);
      b1 = b2;
      if (b2 >= (this.monsterMake[paramInt]).length - 1) {
        byte b3 = b;
        if (b > 0) {
          b3 = b;
          if (findItem(-2, 34, true) < 1)
            b3 = 0; 
        } 
        return b3;
      } 
    } 
  }
  
  private boolean isMonHp(Monster paramMonster, int paramInt) {
    return (paramMonster.monsterPro[0] < paramMonster.monster[2] * paramInt / 100);
  }
  
  private boolean isMyMonsters(int paramInt) {
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= this.myMon_length)
        return false; 
      if (b != paramInt && (this.myMonsters[b]).monsterPro[0] > 0)
        return true; 
    } 
  }
  
  private byte isShuXing(Monster paramMonster1, Monster paramMonster2) {
    return (paramMonster1.monster[3] == -1) ? 30 : ((this.Shuxing[paramMonster1.monster[3]][0] == paramMonster2.monster[3]) ? 30 : ((this.Shuxing[paramMonster1.monster[3]][1] == paramMonster2.monster[3]) ? 0 : 0));
  }
  
  private boolean isSkillToMe(int paramInt) {
    return !(paramInt != 27 && paramInt != 28);
  }
  
  private void keyBattleState() {
    if (Ms.i().key_delay());
    switch (this.battle_state) {
      default:
        return;
      case 2:
        if (Ms.i().key_Left_Right())
          this.cur_a = Ms.i().select(this.cur_a, 0, this.action_str.length - 1); 
        if (Ms.i().key_S1_Num5()) {
          if (this.cur_a == 0) {
            if ((this.myB.getMon()).monster[6] == 0)
              say("宠物忠诚度为0，请立刻补充！", -1); 
            this.battle_state = 3;
            while (true) {
              if (this.skill_list[this.lastSkill] <= 30) {
                this.select[0][0] = this.lastSkill;
                this.select[0][1] = (byte)(this.select[0][0] - 5);
                if (this.select[0][1] < 1)
                  this.select[0][1] = 0; 
              } 
              this.lastSkill = (byte)(this.lastSkill + 1);
            } 
          } 
          if (this.cur_a == 1) {
            if ((this.myB.getMon()).effect == 4)
              say("禁锢中无法使用道具！", -1); 
            goMY_BAG(0);
          } 
          if (this.cur_a == 2) {
            if ((this.myB.getMon()).effect == 4)
              say("禁锢中无法更换宠物！", -1); 
            this.view_state = -2;
            goVIEW_MONSTER();
          } 
          if (this.cur_a == 3)
            goBUY_ITEM(0, 0); 
          if (this.cur_a == 4) {
            if (this.battle_type == 4) {
              String str;
              short s = (short)((this.myB.getMon()).monster[2] - (this.enB.getMon()).monster[2] + 60);
              byte b = 0;
              Ms.i();
              if (Ms.getRandom(100) >= s)
                b = 1; 
              if (this.myB.getMon().isMonReel(42)) {
                b = 0;
              } else if (this.myB.getMon().isEffect(3) || this.myB.getMon().isEffect(4)) {
                b = 2;
              } 
              if (b == 0) {
                arangeMonster();
                setNullBattle();
                goGO_RUNINMAP();
              } 
              if (b == 1) {
                say("逃跑失败！", 1);
                this.myB.act_num = 0;
                this.enB.act_num = 1;
                this.battle_state = 9;
              } 
              StringBuilder stringBuilder = new StringBuilder("被怪物");
              if (this.myB.getMon().isEffect(4)) {
                str = "禁锢中";
              } else {
                str = "的电眼魅惑了";
              } 
              say(stringBuilder.append(str).append("，").append("无法逃跑！").toString(), 1);
            } 
            say("无法逃跑！", 0);
          } 
        } 
      case 3:
        if (Ms.i().key_Up_Down()) {
          Ms.i().selectS(this.select[0], 0, this.skill_list[8], 6);
          this.lastSkill = this.select[0][0];
        } 
        if (Ms.i().key_S1_Num5()) {
          if (this.skill_list[this.select[0][0]] > 30)
            say("被动技能无法使用!", -1); 
          if ((this.myB.getMon()).effect == 6 && getSkillLevel(this.skill_list[this.select[0][0]]) > 3)
            say("封闭效果，不能使用4级以上技能", -1); 
          if ((this.myB.getMon()).monsterPro[1] >= getSkillMana(this.myB.getMon(), this.skill_list[this.select[0][0]])) {
            this.myB.skill = this.skill_list[this.select[0][0]];
            this.battle_state = 9;
          } 
          say("需要的技能值不够！", -1);
        } 
        if (Ms.i().key_S2())
          this.battle_state = 2; 
      case 5:
        if (Ms.i().key_Up_Down())
          Ms.i().selectS(this.select[0], 0, 6, this.skill_list[8]); 
        if (!Ms.i().key_S1_Num5() && Ms.i().key_S2())
          this.battle_state = 2; 
      case 4:
        break;
    } 
    if (Ms.i().key_Up_Down())
      Ms.i().selectS(this.select[0], 0, 6, this.skill_list[8]); 
    if (!Ms.i().key_S1_Num5() && Ms.i().key_S2())
      this.battle_state = 2; 
  }
  
  private void keyBuyItem() {
    if (!Ms.i().key_delay()) {
      if (this.popMenu == -1) {
        if (Ms.i().key_Left_Right() && this.cur_b != 0) {
          this.cur_a = Ms.i().select(this.cur_a, 0, 2);
          byte[] arrayOfByte = this.select[0];
          this.select[0][0] = 0;
          arrayOfByte[1] = 0;
          return;
        } 
        if (Ms.i().key_Up_Down()) {
          int i;
          Ms ms = Ms.i();
          byte[] arrayOfByte = this.select[0];
          if (this.cur_b == 1) {
            i = this.itemsLength[this.cur_a];
          } else {
            i = (this.buyItem[this.cur_a]).length;
          } 
          ms.selectS(arrayOfByte, 0, i, this.list_rows);
          return;
        } 
        if (Ms.i().key_S1_Num5()) {
          boolean bool;
          this.popMenu = 1;
          byte b2 = this.cur_a;
          if (this.cur_b != 1) {
            b1 = this.select[0][0];
          } else {
            b1 = this.items[this.cur_a][this.select[0][0]][0];
          } 
          if (this.cur_b != 1) {
            bool = true;
          } else {
            bool = false;
          } 
          this.sell_money = getPrice(b2, b1, bool);
          byte b1 = this.cur_a;
          b2 = this.select[0][0];
          if (this.cur_b != 1) {
            bool = true;
          } else {
            bool = false;
          } 
          this.t_length = (byte)getBuyItemCount(b1, b2, bool);
          return;
        } 
        if (Ms.i().key_S2()) {
          this.buyItem = null;
          this.buyPrice = null;
          if (this.view_state == -1) {
            goBattleState();
            return;
          } 
          goGO_RUNINMAP();
        } 
        return;
      } 
      if (this.buyOk == 0 && Ms.i().key_Left_Right()) {
        this.popMenu = Ms.i().select(this.popMenu, 1, this.t_length);
        return;
      } 
      if (Ms.i().key_S1_Num5()) {
        if (this.buyOk == 1) {
          if (this.cur_b == 1) {
            this.money += this.sell_money * this.popMenu;
            deleteItems(this.items[this.cur_a][this.select[0][0]][0], this.popMenu);
            if (this.select[0][0] >= this.itemsLength[this.cur_a]) {
              byte[] arrayOfByte = this.select[0];
              byte b = (byte)(arrayOfByte[0] - 1);
              arrayOfByte[0] = b;
              if (b < 0)
                this.select[0][0] = 0; 
              arrayOfByte = this.select[0];
              b = (byte)(arrayOfByte[1] - 1);
              arrayOfByte[1] = b;
              if (b < 0)
                this.select[0][1] = 0; 
            } 
            say("获得金钱：" + (this.sell_money * this.popMenu), 0);
          } else {
            boolean bool;
            byte b1 = this.cur_a;
            byte b3 = this.buyItem[this.cur_a][this.select[0][0]];
            byte b2 = this.popMenu;
            if (this.cur_a != 2) {
              bool = true;
            } else {
              bool = false;
            } 
            if (isMoneyItem(b1, b3, b2, bool) && addItem(this.buyItem[this.cur_a][this.select[0][0]], this.popMenu) != -1)
              say("购买成功", 0); 
          } 
          this.buyOk = 0;
          this.popMenu = -1;
          return;
        } 
        this.buyOk = 1;
        return;
      } 
      if (Ms.i().key_S2()) {
        if (this.buyOk == 0) {
          this.popMenu = -1;
          return;
        } 
        this.buyOk = 0;
      } 
    } 
  }
  
  private void keyEvolveUI() {
    if (Ms.i().key_S1_Num5() && this.b_c == 0) {
      byte b3 = (this.myMonsters[this.selecty]).monster[4];
      byte b1 = (this.myMonsters[this.selecty]).monster[2];
      byte b2 = (this.myMonsters[this.selecty]).monster[0];
      byte b4 = isEvolveMake(b2);
      if (isEvolveKind(b3, b1) != -1)
        b4 = isEvolveKind(b3, b1); 
      if (b4 == 0) {
        this.myMonsters[this.selecty].evolveMonster(this, this.monsterMake[b2][1], 1);
      } else if (b4 > 0) {
        this.myMonsters[this.selecty].evolveMonster(this, this.monsterMake[b2][0], (this.myMonsters[this.selecty]).monster[5]);
      } else if (b4 == -1) {
        say("材料不足，不能进化！", 0);
        this.popMenu = 1;
      } else if (b4 == -2) {
        say("等级没有达到15级，不能进化！", 0);
      } else if (b4 == -3) {
        say("等级没有达到25级，不能进化！", 0);
      } else {
        say("等级没有达到30级，不能进化！", 0);
      } 
      if (b4 > -1) {
        this.b_c = 1;
        setMagic(6);
        setShowPro(this.myMonsters[this.selecty]);
        this.popMenu = 0;
        delItemEvolve(b2);
        if (b4 > 0)
          deleteItems(34, 1); 
      } 
      return;
    } 
    if (Ms.i().key_S2()) {
      goView();
      setShowPro(this.myMonsters[this.selecty]);
      return;
    } 
    if (Ms.i().key_Left_Right() && this.b_c <= 0)
      this.popMenu = (byte)(this.popMenu ^ 0x1); 
  }
  
  private void keyGetSkill(Monster paramMonster) {
    if (this.getSkill + 9 >= 35 && this.makeLevel[this.getSkill + 9 - 35] > this.rmsOther[3]) {
      say("需要训练师" + this.makeLevel[this.getSkill + 9 - 35] + "级才能学习！", 0);
      return;
    } 
    if (paramMonster.isMonReel(this.getSkill)) {
      say(String.valueOf(getNameMon(paramMonster.monster[0])) + "已拥有该技能", 0);
      return;
    } 
    if (paramMonster.monster[14] != -1 && paramMonster.monster[15] != -1) {
      initSkillList(paramMonster);
      this.bg_c = paramMonster.monster[3];
      restMove(1, 0);
      say("请选择要替换的技能！", 0);
      return;
    } 
    if (paramMonster.monster[14] == -1) {
      paramMonster.monster[14] = this.getSkill;
    } else {
      paramMonster.monster[15] = this.getSkill;
    } 
    delItemSkill(paramMonster);
  }
  
  private void keyMY_BAG() {
    if (!Ms.i().key_delay()) {
      if (this.popMenu == -1) {
        if (Ms.i().key_S1_Num5() && this.itemsLength[this.selectx] > 0) {
          popBagMenu(this.selectx, this.select[0][0]);
          return;
        } 
        if (Ms.i().key_Left_Right()) {
          this.selectx = Ms.i().select(this.selectx, 0, this.action_str.length - 1);
          this.select[0][1] = this.select_st[this.selectx];
          this.select[0][0] = this.select_it[this.selectx];
          return;
        } 
        if (Ms.i().key_S2()) {
          if (this.mini_state == 9) {
            this.mini_state = 5;
            this.selecty = this.select_T;
            this.selecty = 0;
            goVIEW_MONSTER();
            return;
          } 
          if (this.view_state == -1) {
            this.mini_state = 1;
            goBattleState();
            initMonStream(2, this.mList_id[(this.myMonsters[0]).monster[0]][0], 1);
            this.itemMine = null;
            return;
          } 
          if (this.view_state == 2) {
            run_state = -10;
            mc.paint();
            goNidus(0);
            return;
          } 
          doPaint(0);
          goYouPAUSE(2);
          this.itemMine = null;
          return;
        } 
        if (Ms.i().key_Up_Down()) {
          if (this.itemsLength[this.selectx] > 0)
            Ms.i().selectS(this.select[0], 0, this.itemsLength[this.selectx], this.list_rows); 
          this.select_it[this.selectx] = this.select[0][0];
          this.select_st[this.selectx] = this.select[0][1];
        } 
        return;
      } 
      popBagState();
    } 
  }
  
  private void keyMagicUI() {
    if (Ms.i().key_S1_Num5() && this.mini_state == 13) {
      if (this.skill_list[this.select[0][0]] <= 25) {
        say("该技能不能替换！", 0);
        return;
      } 
      if (this.skill_list[this.select[0][0]] == (this.myMonsters[this.selecty]).monster[14]) {
        (this.myMonsters[this.selecty]).monster[14] = this.getSkill;
      } else {
        (this.myMonsters[this.selecty]).monster[15] = this.getSkill;
      } 
      delItemSkill(this.myMonsters[this.selecty]);
      return;
    } 
    if (Ms.i().key_S2()) {
      this.select[0][1] = this.selectx;
      this.select[0][0] = this.selecty;
      this.cur_c = 0;
      this.popMenu = -1;
      return;
    } 
    if (Ms.i().key_Left_Right() && this.mini_state != 13) {
      this.popMenu = (byte)(this.popMenu ^ 0x1);
      byte[] arrayOfByte = this.select[0];
      this.select[0][0] = 0;
      arrayOfByte[1] = 0;
      return;
    } 
    if (Ms.i().key_Up_Down()) {
      this.introX = Constants_H.WIDTH_H;
      if (this.popMenu == 0) {
        Ms.i().selectS(this.select[0], 0, this.skill_list[8], 5);
        return;
      } 
      if (this.mini_state == 6) {
        if ((this.cMonsters[this.selecty]).monster[17] > 0) {
          byte[] arrayOfByte = this.select[0];
          arrayOfByte[0] = (byte)(arrayOfByte[0] ^ 0x1);
        } 
        return;
      } 
      if ((this.myMonsters[this.selecty]).monster[17] > 0) {
        byte[] arrayOfByte = this.select[0];
        arrayOfByte[0] = (byte)(arrayOfByte[0] ^ 0x1);
      } 
    } 
  }
  
  private void keyNidus() {
    if (!Ms.i().key_delay()) {
      if (this.mini_state == 16) {
        if (Ms.i().key_Up_Down()) {
          this.popMenu = Ms.i().select(this.popMenu, 0, this.about_d.length - 1);
          return;
        } 
        if (Ms.i().key_S1_Num5()) {
          if (Ms.i().equals(this.about_d[this.popMenu], "查看孵化")) {
            this.mini_state = 17;
            this.popMenu = 0;
            initMonStream(0, 56, 1);
            if (getRid(this.popMenu) == -2) {
              this.bg_c = this.popMenu;
              return;
            } 
            this.bg_c = this.monster_pro[getNid(this.popMenu)][6];
            this.mon_action = (byte)(this.bg_c + 23);
            return;
          } 
          if (Ms.i().equals(this.about_d[this.popMenu], "选择蛋")) {
            this.view_state = 2;
            goMY_BAG(3);
            return;
          } 
          if (Ms.i().equals(this.about_d[this.popMenu], "离开"))
            exitNidus(); 
          return;
        } 
        if (Ms.i().key_S2())
          exitNidus(); 
        return;
      } 
      if (this.b_c == -2 && Ms.i().key_Left_Right()) {
        this.popMenu = Ms.i().select(this.popMenu, 0, 4);
        if (getRid(this.popMenu) == -2) {
          this.bg_c = this.popMenu;
          return;
        } 
        this.bg_c = this.monster_pro[getNid(this.popMenu)][6];
        this.mon_action = (byte)(this.bg_c + 23);
        return;
      } 
      if (Ms.i().key_S1_Num5()) {
        if (getRid(this.popMenu) != -2) {
          if (this.b_c == -2 && getNexp(this.popMenu, 1) == getNexp(this.popMenu, 3)) {
            if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
              say("宠物空间已满", 0);
              return;
            } 
            if (isEvolveMake(getNid(this.popMenu)) == 0) {
              this.mon_action = (byte)(this.bg_c + 28);
              this.b_c = 1;
              setNidusPro(getNid(this.popMenu), 1);
              delItemEvolve(getNid(this.popMenu));
              return;
            } 
            say("材料不足，不能孵化", 0);
            return;
          } 
          if (this.b_c == -1) {
            this.b_c = -2;
            getMonster(getNid(this.popMenu), getNLevel(this.popMenu), -2, -1);
            delNidus(this.popMenu);
            initMonStream(0, 56, 1);
          } 
        } 
        return;
      } 
      if (this.b_c == -2 && Ms.i().key_S2())
        exitNidus(); 
    } 
  }
  
  private void key_MONSTER_LIST(Monster[] paramArrayOfMonster) {
    if (this.popMenu == -1) {
      if (Ms.i().key_S1_Num5() && this.t_length != 0) {
        if (this.view_state == 1) {
          if (this.mini_state == 15) {
            useItem();
            return;
          } 
          if (this.mini_state == 13) {
            keyGetSkill(paramArrayOfMonster[this.select[0][0]]);
            return;
          } 
          StringBuffer stringBuffer = new StringBuffer("天赋#n技能");
          if (this.mini_state == 4) {
            if ((paramArrayOfMonster[this.select[0][0]]).monster[5] > 0)
              stringBuffer.append("#n进化"); 
            if (this.t_length > 1)
              stringBuffer.append("#n存放#n卖宠"); 
          } else if (this.mini_state == 6) {
            if (!this.map.gmErr) {
              stringBuffer.append("#n取出#n卖宠");
            } else {
              stringBuffer.append("#n卖宠");
            } 
          } else {
            if (this.select[0][0] != 0)
              stringBuffer.append("#n参战"); 
            if ((paramArrayOfMonster[this.select[0][0]]).monster[5] > 0)
              stringBuffer.append("#n进化"); 
            if (this.t_length > 1)
              stringBuffer.append("#n放生"); 
          } 
          setStringB(stringBuffer.toString(), Constants_H.WIDTH, 3);
          this.popMenu = 0;
          return;
        } 
        if (this.view_state < 0) {
          if (this.mini_state == 15) {
            useItem();
            return;
          } 
          if (this.select[0][0] != 0) {
            setStringB("参战#n技能", Constants_H.WIDTH, 3);
          } else {
            setStringB("技能", Constants_H.WIDTH, 3);
          } 
          this.popMenu = 0;
        } 
        return;
      } 
      if (Ms.i().key_S2()) {
        if (this.mini_state == 13) {
          goMY_BAG(2);
          return;
        } 
        if (this.view_state == 1) {
          if (this.mini_state == 15) {
            goMY_BAG(0);
            this.mini_state = 3;
            return;
          } 
          if (this.mini_state == 6 || this.mini_state == 4) {
            if (!this.map.gmErr) {
              boolean bool;
              doPaint(0);
              if (this.mini_state == 6) {
                bool = true;
              } else {
                bool = false;
              } 
              goVIEW_COMPUTER(bool);
              return;
            } 
            this.map.bkEvent_getMon();
            return;
          } 
          doPaint(0);
          goYouPAUSE(1);
          return;
        } 
        if (this.view_state == -2) {
          if ((paramArrayOfMonster[0]).monsterPro[0] > 0) {
            if (this.select[0][0] != 0)
              initMonStream(2, this.mList_id[(paramArrayOfMonster[0]).monster[0]][0], 1); 
            goBattleState();
          } else {
            say("当前宠物不能参战", 0);
          } 
          this.view_state = -1;
          return;
        } 
        if (this.view_state == -1) {
          if (this.mini_state == 15) {
            goMY_BAG(0);
            return;
          } 
          say("当前宠物不能参战", 0);
        } 
        return;
      } 
      if (Ms.i().key_Up_Down() && this.t_length != 0) {
        Ms.i().selectS(this.select[0], 0, this.t_length, this.list_rows);
        initMonStream(2, this.mList_id[(paramArrayOfMonster[this.select[0][0]]).monster[0]][0], 1);
        setShowPro(paramArrayOfMonster[this.select[0][0]]);
        this.introT = Constants_H.WIDTH_H;
      } 
      return;
    } 
    popState();
  }
  
  private boolean level_up(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_2
    //   1: ifne -> 228
    //   4: aload_0
    //   5: getfield myMonsters : [Ldm/Monster;
    //   8: iload_1
    //   9: aaload
    //   10: getfield monster : [B
    //   13: iconst_2
    //   14: baload
    //   15: istore_2
    //   16: invokestatic i : ()Ldm/Ms;
    //   19: pop
    //   20: iload_2
    //   21: getstatic dm/Ms.skip2 : I
    //   24: isub
    //   25: i2b
    //   26: istore #5
    //   28: iconst_0
    //   29: istore_2
    //   30: invokestatic i : ()Ldm/Ms;
    //   33: pop
    //   34: aload_0
    //   35: getfield exp : S
    //   38: putstatic dm/Ms.skip : I
    //   41: aload_0
    //   42: getfield myMonsters : [Ldm/Monster;
    //   45: iload_1
    //   46: aaload
    //   47: bipush #36
    //   49: invokevirtual isMonReel : (I)Z
    //   52: ifeq -> 61
    //   55: iconst_0
    //   56: bipush #100
    //   58: iadd
    //   59: i2s
    //   60: istore_2
    //   61: iload_2
    //   62: istore #4
    //   64: aload_0
    //   65: getfield myMonsters : [Ldm/Monster;
    //   68: iload_1
    //   69: aaload
    //   70: bipush #37
    //   72: invokevirtual isMonReel : (I)Z
    //   75: ifeq -> 86
    //   78: iload_2
    //   79: sipush #200
    //   82: iadd
    //   83: i2s
    //   84: istore #4
    //   86: iload #5
    //   88: ifge -> 214
    //   91: iconst_0
    //   92: istore_2
    //   93: invokestatic i : ()Ldm/Ms;
    //   96: pop
    //   97: invokestatic i : ()Ldm/Ms;
    //   100: pop
    //   101: getstatic dm/Ms.skip : I
    //   104: bipush #9
    //   106: iload_2
    //   107: iconst_2
    //   108: imul
    //   109: isub
    //   110: imul
    //   111: iload #4
    //   113: bipush #100
    //   115: iadd
    //   116: imul
    //   117: sipush #1000
    //   120: idiv
    //   121: i2s
    //   122: putstatic dm/Ms.skip : I
    //   125: invokestatic i : ()Ldm/Ms;
    //   128: pop
    //   129: getstatic dm/Ms.skip : I
    //   132: iconst_1
    //   133: if_icmpge -> 154
    //   136: invokestatic i : ()Ldm/Ms;
    //   139: pop
    //   140: invokestatic i : ()Ldm/Ms;
    //   143: pop
    //   144: bipush #6
    //   146: invokestatic getRandom : (I)I
    //   149: iconst_5
    //   150: iadd
    //   151: putstatic dm/Ms.skip : I
    //   154: aload_0
    //   155: getfield battle_type : B
    //   158: iconst_3
    //   159: if_icmpeq -> 169
    //   162: aload_0
    //   163: getfield battle_type : B
    //   166: ifne -> 188
    //   169: invokestatic i : ()Ldm/Ms;
    //   172: pop
    //   173: invokestatic i : ()Ldm/Ms;
    //   176: pop
    //   177: getstatic dm/Ms.skip : I
    //   180: iconst_3
    //   181: imul
    //   182: iconst_2
    //   183: idiv
    //   184: i2s
    //   185: putstatic dm/Ms.skip : I
    //   188: aload_0
    //   189: getfield proReplace : [[S
    //   192: iload_1
    //   193: aaload
    //   194: astore #7
    //   196: invokestatic i : ()Ldm/Ms;
    //   199: pop
    //   200: aload #7
    //   202: iconst_2
    //   203: getstatic dm/Ms.skip : I
    //   206: i2s
    //   207: sastore
    //   208: iconst_1
    //   209: istore #6
    //   211: iload #6
    //   213: ireturn
    //   214: iload #5
    //   216: istore_2
    //   217: iload #5
    //   219: iconst_4
    //   220: if_icmple -> 93
    //   223: iconst_5
    //   224: istore_2
    //   225: goto -> 93
    //   228: iload_2
    //   229: iconst_1
    //   230: if_icmpne -> 421
    //   233: aload_0
    //   234: getfield myMonsters : [Ldm/Monster;
    //   237: iload_1
    //   238: aaload
    //   239: getfield monster : [B
    //   242: iconst_2
    //   243: baload
    //   244: bipush #60
    //   246: if_icmpge -> 401
    //   249: invokestatic i : ()Ldm/Ms;
    //   252: pop
    //   253: getstatic dm/Ms.skip : I
    //   256: ifle -> 401
    //   259: aload_0
    //   260: aload_0
    //   261: getfield myMonsters : [Ldm/Monster;
    //   264: iload_1
    //   265: aaload
    //   266: invokespecial getMonsterExp : (Ldm/Monster;)S
    //   269: istore_3
    //   270: aload_0
    //   271: getfield myMonsters : [Ldm/Monster;
    //   274: iload_1
    //   275: aaload
    //   276: getfield monsterPro : [S
    //   279: iconst_4
    //   280: saload
    //   281: istore_2
    //   282: invokestatic i : ()Ldm/Ms;
    //   285: pop
    //   286: iload_2
    //   287: getstatic dm/Ms.skip : I
    //   290: iadd
    //   291: i2s
    //   292: istore_2
    //   293: iload_2
    //   294: iload_3
    //   295: if_icmplt -> 342
    //   298: aload_0
    //   299: getfield myB : Ldm/Battle;
    //   302: aload_0
    //   303: getfield myMonsters : [Ldm/Monster;
    //   306: iload_1
    //   307: aaload
    //   308: getfield monsterPro : [S
    //   311: iconst_4
    //   312: saload
    //   313: putfield cexp : S
    //   316: aload_0
    //   317: getfield myMonsters : [Ldm/Monster;
    //   320: iload_1
    //   321: aaload
    //   322: getfield monsterPro : [S
    //   325: iconst_4
    //   326: iload_3
    //   327: sastore
    //   328: invokestatic i : ()Ldm/Ms;
    //   331: pop
    //   332: iload_2
    //   333: iload_3
    //   334: isub
    //   335: i2s
    //   336: putstatic dm/Ms.skip : I
    //   339: goto -> 208
    //   342: aload_0
    //   343: getfield myB : Ldm/Battle;
    //   346: aload_0
    //   347: getfield myMonsters : [Ldm/Monster;
    //   350: iload_1
    //   351: aaload
    //   352: getfield monsterPro : [S
    //   355: iconst_4
    //   356: saload
    //   357: putfield cexp : S
    //   360: aload_0
    //   361: getfield myMonsters : [Ldm/Monster;
    //   364: iload_1
    //   365: aaload
    //   366: getfield monsterPro : [S
    //   369: astore #7
    //   371: aload #7
    //   373: iconst_4
    //   374: saload
    //   375: istore_1
    //   376: invokestatic i : ()Ldm/Ms;
    //   379: pop
    //   380: aload #7
    //   382: iconst_4
    //   383: iload_1
    //   384: getstatic dm/Ms.skip : I
    //   387: iadd
    //   388: i2s
    //   389: sastore
    //   390: invokestatic i : ()Ldm/Ms;
    //   393: pop
    //   394: iconst_m1
    //   395: putstatic dm/Ms.skip : I
    //   398: goto -> 208
    //   401: invokestatic i : ()Ldm/Ms;
    //   404: pop
    //   405: iconst_m1
    //   406: putstatic dm/Ms.skip : I
    //   409: aload_0
    //   410: getfield proReplace : [[S
    //   413: iload_1
    //   414: aaload
    //   415: iconst_2
    //   416: iconst_0
    //   417: sastore
    //   418: goto -> 208
    //   421: iload_2
    //   422: iconst_2
    //   423: if_icmpne -> 208
    //   426: invokestatic i : ()Ldm/Ms;
    //   429: pop
    //   430: getstatic dm/Ms.skip : I
    //   433: iconst_m1
    //   434: if_icmple -> 509
    //   437: aload_0
    //   438: iload_1
    //   439: iconst_0
    //   440: invokevirtual levelPro : (IZ)V
    //   443: aload_0
    //   444: aload_0
    //   445: getfield myMonsters : [Ldm/Monster;
    //   448: iload_1
    //   449: aaload
    //   450: invokevirtual getMagic : (Ldm/Monster;)V
    //   453: aload_0
    //   454: getfield levelUp_in_battle : [[B
    //   457: aload_0
    //   458: getfield myMonsters : [Ldm/Monster;
    //   461: iload_1
    //   462: aaload
    //   463: getfield monster : [B
    //   466: iconst_1
    //   467: baload
    //   468: aaload
    //   469: iconst_0
    //   470: iconst_1
    //   471: bastore
    //   472: aload_0
    //   473: getfield levelUp_in_battle : [[B
    //   476: aload_0
    //   477: getfield myMonsters : [Ldm/Monster;
    //   480: iload_1
    //   481: aaload
    //   482: getfield monster : [B
    //   485: iconst_1
    //   486: baload
    //   487: aaload
    //   488: iconst_1
    //   489: aload_0
    //   490: getfield getSkill : B
    //   493: bastore
    //   494: aload_0
    //   495: getfield myMonsters : [Ldm/Monster;
    //   498: iload_1
    //   499: aaload
    //   500: getfield monsterPro : [S
    //   503: iconst_4
    //   504: iconst_0
    //   505: sastore
    //   506: goto -> 208
    //   509: iconst_0
    //   510: istore #6
    //   512: goto -> 211
  }
  
  private void loadGame() {
    this.map.firstDrawMap = 0;
    this.buyOk = 0;
    this.map.mapImg = null;
    System.out.println("loadGame 111111111111");
    mc.goGameLoading();
    System.out.println("loadGame 22222222222");
  }
  
  private boolean magicEffectRate(Battle paramBattle, Monster paramMonster1, Monster paramMonster2, int paramInt) {
    // Byte code:
    //   0: aload_3
    //   1: getfield effect : B
    //   4: bipush #7
    //   6: if_icmpeq -> 15
    //   9: iconst_0
    //   10: istore #8
    //   12: iload #8
    //   14: ireturn
    //   15: aload_0
    //   16: getfield skill : [[B
    //   19: iload #4
    //   21: aaload
    //   22: iconst_3
    //   23: baload
    //   24: istore #5
    //   26: aload_0
    //   27: getfield skill : [[B
    //   30: iload #4
    //   32: aaload
    //   33: iconst_2
    //   34: baload
    //   35: istore #7
    //   37: iload #7
    //   39: ifne -> 48
    //   42: iconst_0
    //   43: istore #8
    //   45: goto -> 12
    //   48: iload #5
    //   50: ifne -> 187
    //   53: aload_3
    //   54: iconst_5
    //   55: invokevirtual isBuffRate : (I)Z
    //   58: ifeq -> 158
    //   61: aload_0
    //   62: getfield inhesion : [B
    //   65: iconst_5
    //   66: baload
    //   67: iload #7
    //   69: iadd
    //   70: i2b
    //   71: istore #6
    //   73: invokestatic i : ()Ldm/Ms;
    //   76: pop
    //   77: bipush #100
    //   79: invokestatic getRandom : (I)I
    //   82: iload #6
    //   84: if_icmpge -> 412
    //   87: aload_3
    //   88: iload #5
    //   90: putfield effect : B
    //   93: iload #5
    //   95: iconst_3
    //   96: if_icmpeq -> 111
    //   99: iload #5
    //   101: iconst_4
    //   102: if_icmpeq -> 111
    //   105: iload #5
    //   107: iconst_5
    //   108: if_icmpne -> 317
    //   111: aload_3
    //   112: iconst_4
    //   113: putfield effect_time : B
    //   116: iload #5
    //   118: iconst_5
    //   119: if_icmpne -> 152
    //   122: aload_2
    //   123: bipush #31
    //   125: invokevirtual isMonReel : (I)Z
    //   128: ifeq -> 406
    //   131: aload_0
    //   132: getfield skill : [[B
    //   135: bipush #31
    //   137: aaload
    //   138: iconst_0
    //   139: baload
    //   140: istore #6
    //   142: aload_1
    //   143: iload #6
    //   145: iload #4
    //   147: iadd
    //   148: i2b
    //   149: putfield fs_level : B
    //   152: iconst_1
    //   153: istore #8
    //   155: goto -> 12
    //   158: iload #7
    //   160: istore #6
    //   162: aload_3
    //   163: bipush #6
    //   165: invokevirtual isBuffRate : (I)Z
    //   168: ifeq -> 73
    //   171: aload_0
    //   172: getfield inhesion : [B
    //   175: bipush #6
    //   177: baload
    //   178: iload #7
    //   180: iadd
    //   181: i2b
    //   182: istore #6
    //   184: goto -> 73
    //   187: iload #5
    //   189: iconst_4
    //   190: if_icmpne -> 247
    //   193: aload_3
    //   194: bipush #7
    //   196: invokevirtual isBuffRate : (I)Z
    //   199: ifeq -> 218
    //   202: aload_0
    //   203: getfield inhesion : [B
    //   206: bipush #7
    //   208: baload
    //   209: iload #7
    //   211: iadd
    //   212: i2b
    //   213: istore #6
    //   215: goto -> 73
    //   218: iload #7
    //   220: istore #6
    //   222: aload_3
    //   223: bipush #8
    //   225: invokevirtual isBuffRate : (I)Z
    //   228: ifeq -> 73
    //   231: aload_0
    //   232: getfield inhesion : [B
    //   235: bipush #8
    //   237: baload
    //   238: iload #7
    //   240: iadd
    //   241: i2b
    //   242: istore #6
    //   244: goto -> 73
    //   247: iload #5
    //   249: iconst_2
    //   250: if_icmpeq -> 263
    //   253: iload #7
    //   255: istore #6
    //   257: iload #5
    //   259: iconst_5
    //   260: if_icmpne -> 73
    //   263: aload_3
    //   264: bipush #11
    //   266: invokevirtual isBuffRate : (I)Z
    //   269: ifeq -> 288
    //   272: aload_0
    //   273: getfield inhesion : [B
    //   276: bipush #11
    //   278: baload
    //   279: iload #7
    //   281: iadd
    //   282: i2b
    //   283: istore #6
    //   285: goto -> 73
    //   288: iload #7
    //   290: istore #6
    //   292: aload_3
    //   293: bipush #12
    //   295: invokevirtual isBuffRate : (I)Z
    //   298: ifeq -> 73
    //   301: aload_0
    //   302: getfield inhesion : [B
    //   305: bipush #12
    //   307: baload
    //   308: iload #7
    //   310: iadd
    //   311: i2b
    //   312: istore #6
    //   314: goto -> 73
    //   317: iload #5
    //   319: iconst_2
    //   320: if_icmpne -> 351
    //   323: aload_2
    //   324: bipush #32
    //   326: invokevirtual isMonReel : (I)Z
    //   329: ifeq -> 345
    //   332: iconst_5
    //   333: istore #6
    //   335: aload_3
    //   336: iload #6
    //   338: i2b
    //   339: putfield effect_time : B
    //   342: goto -> 116
    //   345: iconst_4
    //   346: istore #6
    //   348: goto -> 335
    //   351: iload #5
    //   353: ifne -> 364
    //   356: aload_3
    //   357: iconst_2
    //   358: putfield effect_time : B
    //   361: goto -> 116
    //   364: iload #5
    //   366: bipush #6
    //   368: if_icmpne -> 116
    //   371: aload_3
    //   372: getfield monster : [B
    //   375: iconst_3
    //   376: baload
    //   377: iconst_m1
    //   378: if_icmpne -> 398
    //   381: aload_3
    //   382: bipush #7
    //   384: putfield effect : B
    //   387: aload_0
    //   388: ldc_w '封闭效果，对幽暗鬼王不起作用'
    //   391: iconst_m1
    //   392: invokevirtual say : (Ljava/lang/String;I)V
    //   395: goto -> 116
    //   398: aload_3
    //   399: iconst_4
    //   400: putfield effect_time : B
    //   403: goto -> 116
    //   406: iconst_1
    //   407: istore #6
    //   409: goto -> 142
    //   412: iconst_0
    //   413: istore #8
    //   415: goto -> 12
  }
  
  private byte monsterRemove(int paramInt) {
    if (this.myMon_length > 1) {
      this.myMonsters[paramInt] = null;
      for (paramInt = (byte)paramInt;; paramInt = (byte)(paramInt + 1)) {
        if (paramInt >= this.myMon_length - 1) {
          for (paramInt = this.myMon_length;; paramInt = (byte)(paramInt + 1)) {
            if (paramInt >= this.myMonsters.length) {
              this.myMon_length = (byte)(this.myMon_length - 1);
              return 1;
            } 
            this.evolve[paramInt] = true;
          } 
          break;
        } 
        this.myMonsters[paramInt] = this.myMonsters[paramInt + 1];
        this.evolve[paramInt] = this.evolve[paramInt + 1];
      } 
    } 
    return -1;
  }
  
  private void mpAdd(int paramInt) {
    if ((this.myMonsters[this.select[0][0]]).monsterPro[1] < (this.myMonsters[this.select[0][0]]).monsterPro[3] && (this.myMonsters[this.select_T]).monsterPro[0] > 0) {
      AddMP((this.myMonsters[this.select[0][0]]).monsterPro[3] * paramInt / 100, this.myMonsters[this.select[0][0]]);
      useState(0, this.select_it[0]);
      return;
    } 
    if ((this.myMonsters[this.select[0][0]]).monsterPro[1] < 1) {
      say(String.valueOf(getNameMon((this.myMonsters[this.select[0][0]]).monster[0])) + "已经死亡，无法使用！", 0);
      return;
    } 
    say(String.valueOf(getNameMon((this.myMonsters[this.select[0][0]]).monster[0])) + "不需要使用这个道具", 0);
  }
  
  private void paintBATTLE_OVER() {
    if (this.b_c == 1)
      drawEvolveUI(0, this.myB.now_id, false); 
  }
  
  private void paintBattleState(Graphics paramGraphics) {
    switch (this.battle_state) {
      default:
        return;
      case -1:
        drawAnimationBattle(this.am, this.mini_state);
      case 3:
        Ui.i().drawK0(320 - 150, 50, 300, 193, 0);
        Ui.i().sliding(320 + 125, 60, 173, this.select[0][0], this.skill_list[8], false);
        drawSkillList(320 - 150 + 10, 60, 250, 28, 6, this.select[0]);
        showStringM(this.skill_help[this.skill_list[this.select[0][0]]].toString(), 320, 269, 7, 0);
        Ui.i().drawYesNo(true, true);
      case -2:
        if (drawHitOne(this.dm, this.am, getBXY(this.mini_state, this.am.skill, true) - 15, getBXY(this.mini_state, this.am.skill, false) - 34) && drawHitOne(this.am, this.dm, getBXY(this.mini_state ^ 0x1, 25, true) - 15, getBXY(this.mini_state ^ 0x1, 25, false) - 34) && runHitToState(this.am, this.dm, this.mini_state)) {
          this.battle_state = -3;
          this.am.initHit();
          doEffectValue(this.am);
          doBuffValue(this.am);
        } 
      case -3:
        if (drawHitOne(this.am, this.dm, getBXY(this.mini_state ^ 0x1, 25, true) - 15, getBXY(this.mini_state ^ 0x1, 25, false) - 34) && runHitToState(this.dm, this.am, this.mini_state ^ 0x1)) {
          this.battle_state = 9;
          effectR(this.dm.getMon());
        } 
      case -5:
        break;
    } 
    if (this.proReplace[this.myB.now_id][2] > -1) {
      String str = String.valueOf(getNameMon((this.myMonsters[this.myB.now_id]).monster[0])) + "获得经验：";
      Log.e("sk", "获得经验");
      Ui.i().drawString(str, 204, 308, 36, 1, 0);
      Ui.i().drawNum(this.proReplace[this.myB.now_id][2], 220, 315, 0, 1);
    } 
    if (this.proReplace[this.myB.now_id][2] == -1) {
      Ui.i().drawString("您的宠物已经无法获得经验", 204, 282, 36, 7, 0);
      Ms.i().sleep(600);
    } 
  }
  
  private void popBagMenu(int paramInt1, int paramInt2) {
    String str1;
    String str2 = "返回";
    paramInt2 = this.items[paramInt1][paramInt2][0];
    if ((paramInt1 == 0 || paramInt2 == 32 || paramInt2 == 33) && isBagUse(paramInt2)) {
      str1 = "使用#n返回";
    } else if (paramInt1 == 2) {
      str1 = "学习#n返回";
    } else {
      str1 = str2;
      if (this.view_state == 2) {
        str1 = str2;
        if (paramInt1 == 3)
          str1 = "孵化#n返回"; 
      } 
    } 
    setStringB(str1, Constants_H.WIDTH, 0);
    this.popMenu = 0;
  }
  
  private void popBagState() {
    // Byte code:
    //   0: invokestatic i : ()Ldm/Ms;
    //   3: invokevirtual key_Up_Down : ()Z
    //   6: ifeq -> 31
    //   9: aload_0
    //   10: invokestatic i : ()Ldm/Ms;
    //   13: aload_0
    //   14: getfield popMenu : B
    //   17: iconst_0
    //   18: aload_0
    //   19: getfield about_a : [Ljava/lang/StringBuffer;
    //   22: arraylength
    //   23: iconst_1
    //   24: isub
    //   25: invokevirtual select : (III)B
    //   28: putfield popMenu : B
    //   31: invokestatic i : ()Ldm/Ms;
    //   34: invokevirtual key_S1_Num5 : ()Z
    //   37: ifeq -> 775
    //   40: aload_0
    //   41: getfield items : [[[B
    //   44: aload_0
    //   45: getfield selectx : B
    //   48: aaload
    //   49: aload_0
    //   50: getfield select : [[B
    //   53: iconst_0
    //   54: aaload
    //   55: iconst_0
    //   56: baload
    //   57: aaload
    //   58: iconst_0
    //   59: baload
    //   60: istore_2
    //   61: invokestatic i : ()Ldm/Ms;
    //   64: aload_0
    //   65: getfield about_a : [Ljava/lang/StringBuffer;
    //   68: aload_0
    //   69: getfield popMenu : B
    //   72: aaload
    //   73: ldc_w '使用'
    //   76: invokevirtual equals : (Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   79: ifeq -> 633
    //   82: iload_2
    //   83: lookupswitch default -> 148, 9 -> 184, 10 -> 184, 11 -> 184, 14 -> 227, 15 -> 227, 32 -> 326, 33 -> 326
    //   148: aload_0
    //   149: invokevirtual goVIEW_MONSTER : ()V
    //   152: aload_0
    //   153: bipush #15
    //   155: putfield mini_state : B
    //   158: invokestatic i : ()Ldm/Ms;
    //   161: aload_0
    //   162: getfield select : [[B
    //   165: iconst_0
    //   166: aaload
    //   167: aload_0
    //   168: getfield itemsLength : [B
    //   171: aload_0
    //   172: getfield selectx : B
    //   175: baload
    //   176: aload_0
    //   177: getfield list_rows : B
    //   180: invokevirtual correctSelect : ([BII)V
    //   183: return
    //   184: aload_0
    //   185: getfield battle_type : B
    //   188: iconst_4
    //   189: if_icmpeq -> 200
    //   192: aload_0
    //   193: getfield battle_type : B
    //   196: iconst_1
    //   197: if_icmpne -> 207
    //   200: aload_0
    //   201: invokespecial goCatchMonster : ()V
    //   204: goto -> 158
    //   207: aload_0
    //   208: ldc_w '特殊情况，无法捕获！'
    //   211: iconst_1
    //   212: invokevirtual say : (Ljava/lang/String;I)V
    //   215: invokestatic i : ()Ldm/Ms;
    //   218: sipush #400
    //   221: invokevirtual sleep : (I)V
    //   224: goto -> 158
    //   227: aload_0
    //   228: iconst_m1
    //   229: putfield popMenu : B
    //   232: aload_0
    //   233: getfield map : Lmain/Map;
    //   236: getfield notMeet : B
    //   239: ifne -> 304
    //   242: aload_0
    //   243: getfield map : Lmain/Map;
    //   246: iconst_1
    //   247: iload_2
    //   248: invokevirtual notMeet : (II)V
    //   251: aload_0
    //   252: new java/lang/StringBuilder
    //   255: dup
    //   256: ldc_w '使用'
    //   259: invokespecial <init> : (Ljava/lang/String;)V
    //   262: aload_0
    //   263: iload_2
    //   264: invokevirtual getNameItem : (I)Ljava/lang/String;
    //   267: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc_w '，'
    //   273: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc_w '获得了'
    //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc_w '躲避怪物效果'
    //   285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual toString : ()Ljava/lang/String;
    //   291: iconst_1
    //   292: invokevirtual say : (Ljava/lang/String;I)V
    //   295: aload_0
    //   296: iload_2
    //   297: iconst_1
    //   298: invokevirtual deleteItems : (II)V
    //   301: goto -> 158
    //   304: aload_0
    //   305: getfield map : Lmain/Map;
    //   308: getfield notMeet : B
    //   311: iconst_1
    //   312: if_icmpne -> 158
    //   315: aload_0
    //   316: ldc_w '已拥有躲避怪物效果'
    //   319: iconst_0
    //   320: invokevirtual say : (Ljava/lang/String;I)V
    //   323: goto -> 158
    //   326: iload_2
    //   327: bipush #32
    //   329: if_icmpne -> 483
    //   332: bipush #33
    //   334: istore_1
    //   335: aload_0
    //   336: bipush #-2
    //   338: iload_1
    //   339: iconst_1
    //   340: invokevirtual findItem : (IIZ)B
    //   343: ifle -> 584
    //   346: aload_0
    //   347: bipush #32
    //   349: iconst_1
    //   350: invokevirtual deleteItems : (II)V
    //   353: aload_0
    //   354: bipush #33
    //   356: iconst_1
    //   357: invokevirtual deleteItems : (II)V
    //   360: iconst_3
    //   361: istore_1
    //   362: iconst_1
    //   363: istore_2
    //   364: iconst_m1
    //   365: istore_3
    //   366: invokestatic i : ()Ldm/Ms;
    //   369: pop
    //   370: bipush #100
    //   372: invokestatic getRandom : (I)I
    //   375: i2b
    //   376: istore #4
    //   378: iload #4
    //   380: bipush #70
    //   382: if_icmpge -> 489
    //   385: iconst_0
    //   386: istore_1
    //   387: invokestatic i : ()Ldm/Ms;
    //   390: pop
    //   391: bipush #100
    //   393: invokestatic getRandom : (I)I
    //   396: i2b
    //   397: istore #4
    //   399: iload_2
    //   400: aload_0
    //   401: getfield itemMine : [[B
    //   404: iload_1
    //   405: aaload
    //   406: arraylength
    //   407: if_icmplt -> 513
    //   410: iload_3
    //   411: istore_2
    //   412: iload_2
    //   413: bipush #34
    //   415: if_icmpne -> 548
    //   418: aload_0
    //   419: bipush #-2
    //   421: iload_2
    //   422: iconst_1
    //   423: invokevirtual findItem : (IIZ)B
    //   426: ifle -> 548
    //   429: iconst_m1
    //   430: istore_1
    //   431: iload_1
    //   432: iconst_m1
    //   433: if_icmpeq -> 573
    //   436: aload_0
    //   437: iload_1
    //   438: iconst_1
    //   439: invokevirtual addItem : (II)B
    //   442: pop
    //   443: aload_0
    //   444: new java/lang/StringBuilder
    //   447: dup
    //   448: ldc_w '获得：'
    //   451: invokespecial <init> : (Ljava/lang/String;)V
    //   454: aload_0
    //   455: iload_1
    //   456: invokevirtual getNameItem : (I)Ljava/lang/String;
    //   459: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc_w 'x1'
    //   465: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual toString : ()Ljava/lang/String;
    //   471: iconst_0
    //   472: invokevirtual say : (Ljava/lang/String;I)V
    //   475: aload_0
    //   476: iconst_m1
    //   477: putfield popMenu : B
    //   480: goto -> 158
    //   483: bipush #32
    //   485: istore_1
    //   486: goto -> 335
    //   489: iload #4
    //   491: bipush #85
    //   493: if_icmpge -> 501
    //   496: iconst_1
    //   497: istore_1
    //   498: goto -> 387
    //   501: iload #4
    //   503: bipush #95
    //   505: if_icmpge -> 387
    //   508: iconst_2
    //   509: istore_1
    //   510: goto -> 387
    //   513: iload #4
    //   515: aload_0
    //   516: getfield itemMine : [[B
    //   519: iload_1
    //   520: aaload
    //   521: iload_2
    //   522: baload
    //   523: if_icmpge -> 540
    //   526: aload_0
    //   527: getfield itemMine : [[B
    //   530: iload_1
    //   531: aaload
    //   532: iload_2
    //   533: iconst_1
    //   534: isub
    //   535: baload
    //   536: istore_2
    //   537: goto -> 412
    //   540: iload_2
    //   541: iconst_2
    //   542: iadd
    //   543: i2b
    //   544: istore_2
    //   545: goto -> 399
    //   548: iload_2
    //   549: iconst_m1
    //   550: if_icmpeq -> 568
    //   553: iload_2
    //   554: istore_1
    //   555: aload_0
    //   556: bipush #-2
    //   558: iload_2
    //   559: iconst_1
    //   560: invokevirtual findItem : (IIZ)B
    //   563: bipush #99
    //   565: if_icmplt -> 431
    //   568: iconst_m1
    //   569: istore_1
    //   570: goto -> 431
    //   573: aload_0
    //   574: ldc_w '这个宝箱是空的。'
    //   577: iconst_0
    //   578: invokevirtual say : (Ljava/lang/String;I)V
    //   581: goto -> 475
    //   584: new java/lang/StringBuilder
    //   587: dup
    //   588: ldc_w '没有'
    //   591: invokespecial <init> : (Ljava/lang/String;)V
    //   594: astore #6
    //   596: iload_2
    //   597: bipush #32
    //   599: if_icmpne -> 625
    //   602: ldc_w '钥匙，钥匙在商店中可以购买。'
    //   605: astore #5
    //   607: aload_0
    //   608: aload #6
    //   610: aload #5
    //   612: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: invokevirtual toString : ()Ljava/lang/String;
    //   618: iconst_0
    //   619: invokevirtual say : (Ljava/lang/String;I)V
    //   622: goto -> 475
    //   625: ldc_w '宝箱，宝箱在战斗后一定几率获得。'
    //   628: astore #5
    //   630: goto -> 607
    //   633: invokestatic i : ()Ldm/Ms;
    //   636: aload_0
    //   637: getfield about_a : [Ljava/lang/StringBuffer;
    //   640: aload_0
    //   641: getfield popMenu : B
    //   644: aaload
    //   645: ldc_w '学习'
    //   648: invokevirtual equals : (Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   651: ifeq -> 676
    //   654: aload_0
    //   655: bipush #13
    //   657: putfield mini_state : B
    //   660: aload_0
    //   661: iload_2
    //   662: bipush #9
    //   664: isub
    //   665: i2b
    //   666: putfield getSkill : B
    //   669: aload_0
    //   670: invokevirtual goVIEW_MONSTER : ()V
    //   673: goto -> 158
    //   676: invokestatic i : ()Ldm/Ms;
    //   679: aload_0
    //   680: getfield about_a : [Ljava/lang/StringBuffer;
    //   683: aload_0
    //   684: getfield popMenu : B
    //   687: aaload
    //   688: ldc_w '孵化'
    //   691: invokevirtual equals : (Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   694: ifeq -> 767
    //   697: aload_0
    //   698: iload_2
    //   699: bipush #58
    //   701: isub
    //   702: invokevirtual addNidus : (I)Z
    //   705: ifeq -> 756
    //   708: aload_0
    //   709: iload_2
    //   710: iconst_1
    //   711: invokevirtual deleteItems : (II)V
    //   714: aload_0
    //   715: getfield select_it : [B
    //   718: aload_0
    //   719: getfield selectx : B
    //   722: aload_0
    //   723: getfield select : [[B
    //   726: iconst_0
    //   727: aaload
    //   728: iconst_0
    //   729: baload
    //   730: bastore
    //   731: aload_0
    //   732: getfield select_st : [B
    //   735: aload_0
    //   736: getfield selectx : B
    //   739: aload_0
    //   740: getfield select : [[B
    //   743: iconst_0
    //   744: aaload
    //   745: iconst_1
    //   746: baload
    //   747: bastore
    //   748: aload_0
    //   749: iconst_m1
    //   750: putfield popMenu : B
    //   753: goto -> 158
    //   756: aload_0
    //   757: ldc_w '孵化所已经没有空位了'
    //   760: iconst_0
    //   761: invokevirtual say : (Ljava/lang/String;I)V
    //   764: goto -> 748
    //   767: aload_0
    //   768: iconst_m1
    //   769: putfield popMenu : B
    //   772: goto -> 158
    //   775: invokestatic i : ()Ldm/Ms;
    //   778: invokevirtual key_S2 : ()Z
    //   781: ifeq -> 183
    //   784: aload_0
    //   785: iconst_m1
    //   786: putfield popMenu : B
    //   789: goto -> 183
  }
  
  private void putMonster() {
    if (this.cMon_count >= this.max_monsters) {
      say("宠物空间已满", 0);
      return;
    } 
    if (!isMyMonsters(this.select[0][0])) {
      say("身上必须携带一只能参战的宠物！", 0);
      return;
    } 
    this.cMonsters[this.cMon_count] = this.myMonsters[this.select[0][0]];
    this.cMon_count = (byte)(this.cMon_count + 1);
    setPutMonster();
  }
  
  private void resetFealty(int paramInt) {
    byte b = this.initFealty[(this.myMonsters[this.select[0][0]]).monster[4] / 4];
    if ((this.myMonsters[this.select[0][0]]).monster[6] < b && (this.myMonsters[this.select[0][0]]).monsterPro[0] > 0) {
      if (paramInt == -1) {
        (this.myMonsters[this.select[0][0]]).monster[6] = b;
      } else if ((this.myMonsters[this.select[0][0]]).monster[6] + paramInt > b) {
        (this.myMonsters[this.select[0][0]]).monster[6] = b;
      } else {
        byte[] arrayOfByte = (this.myMonsters[this.select[0][0]]).monster;
        arrayOfByte[6] = (byte)(arrayOfByte[6] + paramInt);
      } 
      useState(0, this.select_it[0]);
      if (this.view_state == -1)
        getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon()); 
      return;
    } 
    if ((this.myMonsters[this.select[0][0]]).monsterPro[0] > 0)
      say(String.valueOf(getNameMon((this.myMonsters[this.select[0][0]]).monster[0])) + "忠诚度已满", 0); 
  }
  
  private void resetMonster(int paramInt) {
    if ((this.myMonsters[this.select[0][0]]).monsterPro[0] < 1) {
      AddMP((this.myMonsters[this.select[0][0]]).monsterPro[3] * paramInt / 100, this.myMonsters[this.select[0][0]]);
      AddHP((this.myMonsters[this.select[0][0]]).monsterPro[2] * paramInt / 100, this.myMonsters[this.select[0][0]]);
      (this.myMonsters[this.select[0][0]]).effect = 7;
      useState(0, this.select_it[0]);
      return;
    } 
    say(String.valueOf(getNameMon((this.myMonsters[this.select[0][0]]).monster[0])) + "没有死亡！", 0);
  }
  
  private void restMove(int paramInt1, int paramInt2) {
    this.selectx = this.select[0][1];
    this.selecty = this.select[0][0];
    this.cur_c = (byte)paramInt1;
    byte[] arrayOfByte = this.select[0];
    this.select[0][0] = 0;
    arrayOfByte[1] = 0;
    this.popMenu = (byte)paramInt2;
    this.move_x = 129;
    this.move_y = -14;
  }
  
  private void runBattleState() {
    byte b;
    this.myB.countS[0] = (byte)Ms.i().mathSpeedN(this.myB.countS[0], this.myB.countS[1], 1, false);
    this.enB.countS[0] = (byte)Ms.i().mathSpeedN(this.enB.countS[0], this.enB.countS[1], 1, false);
    switch (this.battle_state) {
      default:
        return;
      case 1:
        if (bufferAI(this.enB.getMon())) {
          aiEnemy();
          if ((this.enB.getMon()).effect != 6 || getSkillLevel(this.enB.skill) <= 3)
            setAcionSkill(this.enB); 
        } 
        this.enB.act_num = 0;
        this.battle_state = -2;
      case 9:
        if (this.myB.act_num == 0 && this.enB.act_num == 0) {
          this.myB.act_num = 1;
          this.enB.act_num = 1;
          if (this.myB.getMon().isMonEffect(0)) {
            this.myB.act_num = 0;
            say("石化效果无法行动，受到的伤害减少30%", -1);
          } else {
            setAimBattle(1);
            goBattleState();
            String str = "";
            if (this.myB.getMon().isMonEffect(2)) {
              str = "撕裂效果，减少当前血量的10%";
            } else if (this.myB.getMon().isMonEffect(3)) {
              str = "魅惑效果，不能逃跑，增加捕获宠物的几率";
            } else if (this.myB.getMon().isMonEffect(4)) {
              str = "禁锢效果，不能逃跑，不能换怪，不能使用道具";
            } else if (this.myB.getMon().isMonEffect(5)) {
              str = "腐蚀效果，每回合受到一定伤害";
            } 
            if (!str.equals(""))
              say(str, 0); 
          } 
        } 
        if (this.myB.act_num != 0 && this.enB.act_num != 0) {
          boolean bool;
          if ((this.myB.getMon()).monsterPro[5] >= (this.enB.getMon()).monsterPro[5]) {
            bool = true;
          } else {
            bool = false;
          } 
          setAimBattle(bool);
        } else {
          boolean bool;
          if (this.myB.act_num != 0) {
            bool = true;
          } else {
            bool = false;
          } 
          setAimBattle(bool);
        } 
        if (this.mini_state == 1) {
          this.myB.act_num = 0;
          if ((this.myB.getMon()).monster[6] < 41) {
            Ms.i();
            if (Ms.getRandom(100) < 25)
              say("忠诚度过低，宠物不服从主人命令", -1); 
          } 
          if (this.myB.getMon().isMonEffect(0))
            say("石化效果无法行动，受到的伤害减少30%", -1); 
          setAcionSkill(this.myB);
        } 
        if (this.say_c == 0) {
          this.enB.act_num = 0;
          if (!this.enB.getMon().isMonEffect(0))
            this.battle_state = 1; 
        } 
      case -5:
        if (this.b_c == 0 && this.cur_c >= this.mon_in_battle[0]) {
          goBattleOver();
          setNidusExp(this.exp);
        } 
        b = this.mon_in_battle[this.cur_c + 1];
        if (this.b_c == 0) {
          if ((this.myMonsters[b]).monsterPro[0] > 0) {
            if (!this.myMonsters[b].isMonReel(40)) {
              byte[] arrayOfByte = (this.myMonsters[b]).monster;
              arrayOfByte[6] = (byte)(arrayOfByte[6] - 1);
            } 
            this.myB.now_id = b;
            this.myB.chp = (this.myMonsters[b]).monsterPro[0];
            this.myB.cexp = (this.myMonsters[b]).monsterPro[4];
            initMonStream(2, this.mList_id[(this.myMonsters[b]).monster[0]][0], 1);
            if (level_up(b, 0))
              this.b_c = 1; 
          } else {
            this.cur_c = (byte)(this.cur_c + 1);
          } 
        } else if (this.b_c == 1) {
          level_up(b, 1);
          this.b_c = 2;
        } else if (this.b_c == 2 && this.myB.cexp == (this.myMonsters[b]).monsterPro[4]) {
          if (!level_up(b, 2)) {
            this.b_c = 15;
          } else {
            this.b_c = 1;
          } 
        } else if (this.b_c > 2) {
          boolean bool1;
          boolean bool2;
          if (this.b_c < 21) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (this.myB.cexp == (this.myMonsters[b]).monsterPro[4]) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          if ((bool1 & bool2) != 0) {
            byte b1 = (byte)(this.b_c - 1);
            this.b_c = b1;
            if (b1 == 3) {
              this.b_c = 0;
              this.cur_c = (byte)(this.cur_c + 1);
            } 
          } 
        } 
        this.myB.cexp = Ms.i().mathSpeedN(this.myB.cexp, (this.myMonsters[b]).monsterPro[4], 8, false);
      case -4:
        break;
    } 
    if (this.say_c == 0) {
      byte b1 = (byte)(this.cur_b + 1);
      this.cur_b = b1;
      if (b1 >= this.about_a.length) {
        this.about_a = null;
        goBattleExp(true);
      } 
      Log.e("soars", this.about_a[this.cur_b].toString());
      say(this.about_a[this.cur_b].toString(), 0);
    } 
  }
  
  private void runHit() {
    if (!this.am.b_renascence && !this.dm.b_renascence) {
      hit_rate(this.am, this.dm, this.am.getMon(), this.dm.getMon(), this.am.skill);
    } else {
      this.am.b_renascence = false;
      this.dm.b_renascence = false;
    } 
    this.battle_state = -2;
  }
  
  private boolean runHitToState(Battle paramBattle1, Battle paramBattle2, int paramInt) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual getMon : ()Ldm/Monster;
    //   4: getfield monsterPro : [S
    //   7: iconst_0
    //   8: saload
    //   9: ifle -> 18
    //   12: iconst_1
    //   13: istore #4
    //   15: iload #4
    //   17: ireturn
    //   18: aload_2
    //   19: getfield dead : B
    //   22: iconst_1
    //   23: if_icmpne -> 305
    //   26: aload_2
    //   27: invokevirtual getMon : ()Ldm/Monster;
    //   30: bipush #38
    //   32: invokevirtual isMonReel : (I)Z
    //   35: ifeq -> 71
    //   38: invokestatic i : ()Ldm/Ms;
    //   41: pop
    //   42: bipush #100
    //   44: invokestatic getRandom : (I)I
    //   47: aload_0
    //   48: getfield skill : [[B
    //   51: bipush #38
    //   53: aaload
    //   54: iconst_1
    //   55: baload
    //   56: if_icmpge -> 71
    //   59: aload_0
    //   60: aload_1
    //   61: aload_2
    //   62: invokespecial setRelive : (Ldm/Battle;Ldm/Battle;)V
    //   65: iconst_0
    //   66: istore #4
    //   68: goto -> 15
    //   71: iload_3
    //   72: ifne -> 220
    //   75: aload_0
    //   76: getfield enB : Ldm/Battle;
    //   79: iconst_1
    //   80: putfield act_num : B
    //   83: aload_0
    //   84: invokespecial changeMy : ()Z
    //   87: ifeq -> 96
    //   90: iconst_0
    //   91: istore #4
    //   93: goto -> 15
    //   96: aload_0
    //   97: getfield overMode : B
    //   100: ifeq -> 147
    //   103: aload_0
    //   104: getfield overMode : B
    //   107: iconst_2
    //   108: if_icmpne -> 119
    //   111: aload_0
    //   112: getfield map : Lmain/Map;
    //   115: iconst_1
    //   116: putfield sIfElse : B
    //   119: aload_0
    //   120: iconst_0
    //   121: putfield overMode : B
    //   124: aload_0
    //   125: invokespecial arangeMonster : ()V
    //   128: aload_0
    //   129: invokespecial setNullBattle : ()V
    //   132: aload_0
    //   133: invokespecial goGO_RUNINMAP : ()V
    //   136: aload_0
    //   137: iconst_0
    //   138: invokevirtual healMonster : (Z)V
    //   141: iconst_0
    //   142: istore #4
    //   144: goto -> 15
    //   147: aload_0
    //   148: invokestatic i : (Lmain/GameRun;)Lmain/SMSSender;
    //   151: getfield sms_a : Z
    //   154: ifeq -> 196
    //   157: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   160: ldc_w 'aaaaaaaaaaaaa'
    //   163: invokevirtual println : (Ljava/lang/String;)V
    //   166: aload_0
    //   167: getfield say_c : B
    //   170: ifne -> 65
    //   173: aload_0
    //   174: iconst_1
    //   175: putfield isKillAll : Z
    //   178: getstatic main/GameRun.isSay : Z
    //   181: ifne -> 65
    //   184: aload_0
    //   185: ldc_w '携带的宠物全都牺牲了!'
    //   188: iconst_m1
    //   189: iconst_1
    //   190: invokevirtual say : (Ljava/lang/String;II)V
    //   193: goto -> 65
    //   196: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   199: ldc_w 'bbbbbbbbbb'
    //   202: invokevirtual println : (Ljava/lang/String;)V
    //   205: aload_0
    //   206: invokestatic i : (Lmain/GameRun;)Lmain/SMSSender;
    //   209: iconst_1
    //   210: putfield sms_a : Z
    //   213: aload_0
    //   214: invokevirtual goGameOver : ()V
    //   217: goto -> 65
    //   220: iload_3
    //   221: iconst_1
    //   222: if_icmpne -> 65
    //   225: aload_0
    //   226: aload_0
    //   227: getfield enB : Ldm/Battle;
    //   230: aload_0
    //   231: getfield enB : Ldm/Battle;
    //   234: getfield mon : [Ldm/Monster;
    //   237: arraylength
    //   238: invokespecial changeMon : (Ldm/Battle;I)Z
    //   241: ifeq -> 277
    //   244: aload_0
    //   245: invokespecial setEnemyThrow : ()V
    //   248: aload_0
    //   249: getfield enB : Ldm/Battle;
    //   252: iconst_0
    //   253: putfield act_num : B
    //   256: bipush #-50
    //   258: putstatic main/GameRun.run_state : I
    //   261: aload_0
    //   262: aload_0
    //   263: getfield battle_state : B
    //   266: putfield t_battle_state : B
    //   269: aload_0
    //   270: iconst_0
    //   271: putfield battle_state : B
    //   274: goto -> 65
    //   277: aload_0
    //   278: invokespecial goBattleItem : ()V
    //   281: aload_0
    //   282: getfield overMode : B
    //   285: iconst_2
    //   286: if_icmpne -> 297
    //   289: aload_0
    //   290: getfield map : Lmain/Map;
    //   293: iconst_0
    //   294: putfield sIfElse : B
    //   297: aload_0
    //   298: iconst_0
    //   299: putfield overMode : B
    //   302: goto -> 65
    //   305: aload_2
    //   306: getfield action : B
    //   309: iconst_2
    //   310: if_icmpeq -> 65
    //   313: aload_2
    //   314: iconst_2
    //   315: putfield action : B
    //   318: aload_0
    //   319: getfield now_action : [B
    //   322: aload_0
    //   323: getfield mini_state : B
    //   326: iconst_0
    //   327: bastore
    //   328: aload_0
    //   329: getfield now_time : [B
    //   332: aload_0
    //   333: getfield mini_state : B
    //   336: iconst_0
    //   337: bastore
    //   338: aload_2
    //   339: invokevirtual getMon : ()Ldm/Monster;
    //   342: bipush #40
    //   344: invokevirtual isMonReel : (I)Z
    //   347: ifne -> 65
    //   350: aload_2
    //   351: invokevirtual getMon : ()Ldm/Monster;
    //   354: getfield monster : [B
    //   357: astore_1
    //   358: aload_1
    //   359: bipush #6
    //   361: aload_1
    //   362: bipush #6
    //   364: baload
    //   365: bipush #10
    //   367: isub
    //   368: i2b
    //   369: bastore
    //   370: goto -> 65
  }
  
  private void runMonsterAppear() {
    switch (this.battle_state) {
      default:
        return;
      case 0:
        break;
    } 
    if (this.myB.throw_state == 2 && this.myB.throw_state == 2) {
      if (this.view_state == -2) {
        setAimBattle(0);
        this.myB.act_num = 0;
        this.enB.act_num = 0;
      } 
      this.view_state = -1;
      goBattleState();
      if (this.t_battle_state == -3 || this.t_battle_state == -2) {
        this.battle_state = this.t_battle_state;
        this.t_battle_state = 0;
        getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
      } else {
        goSelectAction(this.mini_state);
      } 
      if (this.first_battle == 0) {
        this.first_battle = 1;
        int i = (byte)((this.myB.getMon()).monster[6] - 99);
        if (i > 1) {
          i = 20;
        } else {
          i = i / 20 * 20;
        } 
        if ((byte)i < 0)
          say("忠诚度降低，攻击力下降，请及时补充！", 0); 
      } 
    } 
  }
  
  private void runThrowBall(Battle paramBattle, Monster paramMonster, int paramInt) {
    if (this.src_c[paramInt + 2] == 0 && paramBattle.throw_state == -1 && this.src_c[paramInt] == 12) {
      paramBattle.throw_state = 0;
    } else if (this.src_c[paramInt + 2] == 1 && this.src_c[paramInt] == 0) {
      this.src_c[paramInt + 2] = 0;
      getBattleBG(paramBattle, paramMonster);
    } 
    if (paramBattle.throw_state == 0) {
      paramBattle.cThrow[0] = (byte)Ms.i().mathSpeedN(paramBattle.cThrow[0], 0, 6, false);
      paramBattle.cThrow[1] = (byte)Ms.i().mathSpeedUp(paramBattle.cThrow[1], 62, 2);
      if (paramBattle.cThrow[0] == 0 && paramBattle.cThrow[1] == 0)
        paramBattle.throw_state = 1; 
      return;
    } 
    if (paramBattle.throw_state == 1) {
      short[] arrayOfShort;
      if (paramBattle.cThrow[2] < 12) {
        arrayOfShort = paramBattle.cThrow;
        arrayOfShort[2] = (short)(arrayOfShort[2] + 1);
        return;
      } 
      ((Battle)arrayOfShort).throw_state = 2;
    } 
  }
  
  private void sellMonster(Monster paramMonster) {
    this.sell_money = paramMonster.monster[2] * paramMonster.monster[4] * 5 + 100;
  }
  
  private void setAcionSkill(Battle paramBattle) {
    paramBattle.action = 1;
    this.now_action[this.mini_state] = 0;
    this.now_time[this.mini_state] = 0;
    this.battle_state = -1;
    setMagic(paramBattle.skill / 5);
  }
  
  private boolean setCartoonFrameMagic_C(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    short[] arrayOfShort = this.now_time_Magic;
    short s = (short)(arrayOfShort[paramInt1] + 1);
    arrayOfShort[paramInt1] = s;
    if (s >= this.magic[paramInt2].action(paramInt3, this.now_action_Magic[paramInt1], 1)) {
      arrayOfShort = this.now_action_Magic;
      arrayOfShort[paramInt1] = (short)(arrayOfShort[paramInt1] + 1);
      this.now_time_Magic[paramInt1] = 0;
      if (!paramBoolean && this.now_action_Magic[paramInt1] >= this.magic[paramInt2].aLength(paramInt3)) {
        arrayOfShort = this.now_action_Magic;
        arrayOfShort[paramInt1] = (short)(arrayOfShort[paramInt1] - 1);
        return true;
      } 
    } 
    return false;
  }
  
  private boolean setCartoonFrame_C(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    byte[] arrayOfByte = this.now_time;
    byte b = (byte)(arrayOfByte[paramInt1] + 1);
    arrayOfByte[paramInt1] = b;
    if (b >= this.mon[paramInt2].action(paramInt3, this.now_action[paramInt1], 1)) {
      arrayOfByte = this.now_action;
      arrayOfByte[paramInt1] = (byte)(arrayOfByte[paramInt1] + 1);
      this.now_time[paramInt1] = 0;
      if (!paramBoolean && this.now_action[paramInt1] >= this.mon[paramInt2].aLength(paramInt3)) {
        arrayOfByte = this.now_action;
        arrayOfByte[paramInt1] = (byte)(arrayOfByte[paramInt1] - 1);
        return true;
      } 
    } 
    return false;
  }
  
  private void setEnemyThrow() {
    this.enemyOff = 63;
    this.enB.cThrow[0] = (byte)(Constants_H.WIDTH - 377 + 20);
    this.enB.cThrow[1] = 60;
    this.enB.cThrow[2] = 0;
    setThrow(this.enB, this.enB.getMon(), 0);
    getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
    getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
  }
  
  private void setEvolveStringB(Monster paramMonster) {
    byte b3 = (byte)(paramMonster.monster[0] + 1);
    byte b5 = paramMonster.monster[2];
    byte b4 = 0;
    byte b2 = b4;
    byte b1 = b3;
    if (this.monsterMake[paramMonster.monster[0]][0] > 0) {
      b2 = b4;
      b1 = b3;
      if (findItem(-2, 34, true) > 0) {
        b1 = this.monsterMake[paramMonster.monster[0]][0];
        b2 = 1;
      } 
    } 
    this.proReplace = null;
    this.proReplace = new short[1][6];
    this.proReplace[0][0] = (short)(getbuffRateV(paramMonster, this.monster_pro[b1][0] + this.monster_pro[b1][7] * b5 / 10) - paramMonster.monsterPro[2]);
    this.proReplace[0][1] = (short)(this.monster_pro[b1][1] + this.monster_pro[b1][8] * b5 / 10 - paramMonster.monsterPro[3]);
    short[] arrayOfShort = this.proReplace[0];
    if (b2) {
      b2 = paramMonster.monster[5];
    } else {
      b2 = 1;
    } 
    arrayOfShort[2] = (short)-b2;
    this.proReplace[0][3] = (byte)(this.monster_pro[b1][3] + this.monster_pro[b1][10] * b5 / 10 - paramMonster.monsterPro[6]);
    this.proReplace[0][4] = (byte)(this.monster_pro[b1][4] + this.monster_pro[b1][11] * b5 / 10 - paramMonster.monsterPro[7]);
    this.proReplace[0][5] = (byte)(this.monster_pro[b1][2] + this.monster_pro[b1][9] * b5 / 10 - paramMonster.monsterPro[5]);
    setStringB("生命：+" + this.proReplace[0][0] + "#n" + "能量" + "：+" + this.proReplace[0][1] + "#n" + "进化" + "：" + this.proReplace[0][2], Constants_H.WIDTH, 0);
    setStringB("力量：+" + this.proReplace[0][3] + "#n" + "防御" + "：+" + this.proReplace[0][4] + "#n" + "敏捷" + "：+" + this.proReplace[0][5], Constants_H.WIDTH, 1);
    this.proReplace = null;
  }
  
  private void setMyThrow() {
    this.myB.cThrow[0] = -286;
    this.myB.cThrow[1] = 60;
    this.myB.cThrow[2] = 0;
    setThrow(this.myB, this.myB.getMon(), 1);
    getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
    getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
  }
  
  private void setNidusPro(int paramInt1, int paramInt2) {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("生命：" + (this.monster_pro[paramInt1][0] + this.monster_pro[paramInt1][7] * paramInt2 / 10) + "#n");
    stringBuffer.append("能量：" + (this.monster_pro[paramInt1][1] + this.monster_pro[paramInt1][8] * paramInt2 / 10) + "#n");
    stringBuffer.append("进化：" + this.monster_pro[paramInt1][12]);
    setStringB(stringBuffer.toString(), Constants_H.WIDTH, 0);
    stringBuffer.delete(0, stringBuffer.length());
    stringBuffer.append("力量：" + (this.monster_pro[paramInt1][3] + this.monster_pro[paramInt1][10] * paramInt2 / 10) + "#n");
    stringBuffer.append("防御：" + (this.monster_pro[paramInt1][4] + this.monster_pro[paramInt1][11] * paramInt2 / 10) + "#n");
    stringBuffer.append("敏捷：" + (this.monster_pro[paramInt1][4] + this.monster_pro[paramInt1][11] * paramInt2 / 10));
    setStringB(stringBuffer.toString(), Constants_H.WIDTH, 1);
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
    for (byte b = this.select[0][0];; b = (byte)(b + 1)) {
      if (b >= this.myMon_length - 1) {
        for (b = this.myMon_length;; b = (byte)(b + 1)) {
          if (b >= this.myMonsters.length) {
            this.myMon_length = (byte)(this.myMon_length - 1);
            if (this.select[0][0] == this.myMon_length) {
              byte[] arrayOfByte = this.select[0];
              arrayOfByte[0] = (byte)(arrayOfByte[0] - 1);
            } 
            initMonStream(2, this.mList_id[(this.myMonsters[this.select[0][0]]).monster[0]][0], 1);
            setShowPro(this.myMonsters[this.select[0][0]]);
            this.introT = Constants_H.WIDTH_H;
            this.t_length = this.myMon_length;
            this.popMenu = -1;
            Ms.i().correctSelect(this.select[0], this.t_length, this.list_rows);
            return;
          } 
          this.evolve[b] = true;
        } 
        break;
      } 
      this.myMonsters[b] = this.myMonsters[b + 1];
      this.evolve[b] = this.evolve[b + 1];
    } 
  }
  
  private void setRelive(Battle paramBattle1, Battle paramBattle2) {
    paramBattle2.initHit();
    paramBattle2.addHit(-(paramBattle2.getMon()).monsterPro[2] * this.skill[38][0] / 100, 1, 1);
    paramBattle2.skill = 28;
    paramBattle2.dead = 0;
    paramBattle2.action = 0;
    paramBattle2.b_renascence = true;
    paramBattle2.act_num = 0;
    this.battle_state = -1;
    setMagic(5);
    getHitCoefficient(paramBattle2, paramBattle2.getMon(), paramBattle1.getMon());
    setAimBattle(this.mini_state ^ 0x1);
  }
  
  private void setShowPro(Monster paramMonster) {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(String.valueOf(paramMonster.monsterPro[6]) + "#n");
    stringBuffer.append(String.valueOf(paramMonster.monsterPro[7]) + "#n");
    stringBuffer.append(paramMonster.monsterPro[5]);
    setStringB(stringBuffer.toString(), Constants_H.WIDTH, 2);
  }
  
  private void setTakenMonster() {
    for (byte b = this.select[0][0];; b = (byte)(b + 1)) {
      if (b >= this.cMon_count - 1) {
        this.cMon_count = (byte)(this.cMon_count - 1);
        this.t_length = this.cMon_count;
        if (this.select[0][0] == this.cMon_count) {
          byte[] arrayOfByte = this.select[0];
          arrayOfByte[0] = (byte)(arrayOfByte[0] - 1);
        } 
        if (this.t_length > 0) {
          initMonStream(2, this.mList_id[(this.cMonsters[this.select[0][0]]).monster[0]][0], 1);
          setShowPro(this.cMonsters[this.select[0][0]]);
        } 
        this.introT = Constants_H.WIDTH_H;
        this.popMenu = -1;
        Ms.i().correctSelect(this.select[0], this.t_length, this.list_rows);
        return;
      } 
      this.cMonsters[b] = this.cMonsters[b + 1];
    } 
  }
  
  private void setThrow(Battle paramBattle, Monster paramMonster, int paramInt) {
    paramBattle.throw_state = -1;
    initMonStream(2, this.mList_id[paramMonster.monster[0]][0], paramInt);
    if (paramMonster.isMonReel(paramMonster.monster[3] + 43)) {
      if (paramBattle.bg_id != paramMonster.monster[3])
        this.src_c[paramInt + 2] = 1; 
    } else if (this.monPro.length != 0 && paramBattle.bg_id != this.monPro[0]) {
      this.src_c[paramInt + 2] = 1;
    } 
    paramBattle.action = 0;
    paramBattle.dead = 0;
    paramBattle.chp = paramMonster.monsterPro[0];
  }
  
  private void takenMonster() {
    if (this.myMon_length < this.max_takes) {
      this.myMonsters[this.myMon_length] = this.cMonsters[this.select[0][0]];
      this.evolve[this.myMon_length] = true;
      this.myMon_length = (byte)(this.myMon_length + 1);
      setTakenMonster();
      return;
    } 
    say("所能携带的宠物已经达到上限！", 1);
  }
  
  private void useItem() {
    switch (this.items[0][this.select_it[0]][0]) {
      default:
        return;
      case 5:
        allAdd(50);
      case 6:
        allAdd(100);
      case 13:
        resetFealty(-1);
      case 12:
        resetFealty(30);
      case 7:
        resetMonster(30);
      case 4:
        mpAdd(100);
      case 3:
        mpAdd(50);
      case 2:
        hpAdd(100, 0);
      case 0:
        hpAdd(35, 30);
      case 1:
        hpAdd(65, 30);
      case 8:
        break;
    } 
    changeEffect();
  }
  
  private void useState(int paramInt1, int paramInt2) {
    mc.paint();
    Ms.i().sleep(200);
    if (this.view_state == -1) {
      this.myB.act_num = 0;
      goBattleState();
      this.battle_state = 9;
      initMonStream(2, this.mList_id[(this.myMonsters[0]).monster[0]][0], 1);
    } else {
      goMY_BAG(paramInt1);
    } 
    deleteItems(this.items[paramInt1][paramInt2][0], 1);
  }
  
  public void Success() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic i : (Lmain/GameRun;)Lmain/SMSSender;
    //   6: iconst_4
    //   7: invokevirtual setSendSms : (I)V
    //   10: aload_0
    //   11: invokestatic i : (Lmain/GameRun;)Lmain/SMSSender;
    //   14: pop
    //   15: getstatic main/SMSSender.smsType : B
    //   18: bipush #6
    //   20: if_icmpne -> 70
    //   23: aload_0
    //   24: invokestatic i : (Lmain/GameRun;)Lmain/SMSSender;
    //   27: invokevirtual sendSuccess : ()V
    //   30: aload_0
    //   31: invokestatic i : (Lmain/GameRun;)Lmain/SMSSender;
    //   34: iconst_m1
    //   35: invokevirtual setSendSms : (I)V
    //   38: bipush #-10
    //   40: putstatic main/GameRun.run_state : I
    //   43: getstatic main/GameRun.mc : Lmain/MainCanvas;
    //   46: getstatic main/GameRun.run_state : I
    //   49: putfield temp_state : I
    //   52: getstatic main/GameRun.mc : Lmain/MainCanvas;
    //   55: iconst_1
    //   56: invokevirtual setSmsIsSetRun_state : (Z)V
    //   59: aload_0
    //   60: getfield map : Lmain/Map;
    //   63: iconst_1
    //   64: invokevirtual setRegState : (Z)V
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aload_0
    //   71: invokestatic i : (Lmain/GameRun;)Lmain/SMSSender;
    //   74: invokevirtual sendSuccess : ()V
    //   77: goto -> 67
    //   80: astore_1
    //   81: aload_1
    //   82: invokevirtual printStackTrace : ()V
    //   85: goto -> 67
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	88	finally
    //   10	67	80	java/lang/Exception
    //   10	67	88	finally
    //   70	77	80	java/lang/Exception
    //   70	77	88	finally
    //   81	85	88	finally
  }
  
  public byte addItem(int paramInt1, int paramInt2) {
    byte b2 = findItemType(paramInt1);
    byte b1 = findItem(b2, paramInt1, false);
    if (b1 != -1) {
      byte[] arrayOfByte = this.items[b2][b1];
      byte b = (byte)(arrayOfByte[1] + paramInt2);
      arrayOfByte[1] = b;
      if (b > 99) {
        this.items[b2][b1][1] = 99;
        say(String.valueOf(getNameItem(this.items[b2][b1][0])) + "数量已到上限", 0);
        return -1;
      } 
    } else {
      this.items[b2][this.itemsLength[b2]][0] = (byte)paramInt1;
      this.items[b2][this.itemsLength[b2]][1] = (byte)paramInt2;
      byte[] arrayOfByte = this.itemsLength;
      arrayOfByte[b2] = (byte)(arrayOfByte[b2] + 1);
    } 
    return 1;
  }
  
  public void addMonInfoListBH() {
    byte[] arrayOfByte = this.monInfoList;
    arrayOfByte[104] = (byte)(arrayOfByte[104] + 1);
    arrayOfByte = this.monInfoList;
    arrayOfByte[103] = (byte)(arrayOfByte[103] + 1);
    if (this.monInfoList[103] == 102) {
      say("恭喜您把所有的宠物都收集齐了", 0);
      mc.paint();
      Ms.i().sleep(600);
    } 
  }
  
  public void battleType(int paramInt) {
    this.battle_type = (byte)paramInt;
  }
  
  public boolean checkMonster() {
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= this.myMon_length) {
        say("您的宠物不需要回复！", 0);
        return true;
      } 
      if ((this.myMonsters[b]).monsterPro[1] < (this.myMonsters[b]).monsterPro[3] || (this.myMonsters[b]).monsterPro[0] < (this.myMonsters[b]).monsterPro[2])
        return false; 
    } 
  }
  
  public void data_init() {
    byte[] arrayOfByte = Ms.i().getStream("data/data.d", -1);
    Ms.i();
    Ms.skip = 0;
    this.skill_up = Ms.i().create2Array(arrayOfByte);
    this.monster_pro = Ms.i().create2Array(arrayOfByte);
    this.skill = Ms.i().create2Array(arrayOfByte);
    this.skill_help = Ms.i().createStringArray(arrayOfByte);
    this.skill_name = Ms.i().createStringArray(arrayOfByte);
    this.monsterT = Ms.i().createStringArray(arrayOfByte);
    this.NAME = Ms.i().createStringArray(arrayOfByte);
    this.item_help = Ms.i().createStringArray(arrayOfByte);
    this.item_name = Ms.i().createStringArray(arrayOfByte);
    this.city_name = Ms.i().createStringArray(arrayOfByte);
    this.buff_name = Ms.i().createStringArray(arrayOfByte);
    this.buff_help = Ms.i().createStringArray(arrayOfByte);
    this.monAppearMap = Ms.i().create2Array(arrayOfByte);
    this.mList_id = Ms.i().create2Array(arrayOfByte);
    this.monsterMake = Ms.i().create2Array(arrayOfByte);
    this.monsterInfo = Ms.i().createStringArray(arrayOfByte);
    this.inhesion = Ms.i().createArray(arrayOfByte);
    this.makeLevel = Ms.i().createArray(arrayOfByte);
    this.musicNo = Ms.i().createArray(arrayOfByte);
    this.npc2ImageType = Ms.i().createArray(arrayOfByte);
    this.map.boatCourse = Ms.i().create2Array(arrayOfByte);
    this.nidusList = Ms.i().create2Array(arrayOfByte);
    arrayOfByte = (byte[])null;
  }
  
  public byte delMonster(int paramInt) {
    byte b = (this.myMonsters[paramInt]).monster[0];
    if (monsterRemove(paramInt) != -1) {
      say("失去宠物：" + getNameMon(b), 0);
      return 1;
    } 
    say("身上必须携带一只能参战的宠物！", 0);
    return -1;
  }
  
  public void deleteItems(int paramInt1, int paramInt2) {
    byte b = findItemType(paramInt1);
    paramInt1 = findItem(b, paramInt1, false);
    if (paramInt1 != -1) {
      if (this.items[b][paramInt1][1] >= paramInt2) {
        byte[] arrayOfByte = this.items[b][paramInt1];
        arrayOfByte[1] = (byte)(arrayOfByte[1] - paramInt2);
      } 
      if (this.items[b][paramInt1][1] == 0)
        dItemIn(b, paramInt1); 
    } 
  }
  
  public void doPaint(int paramInt) {
    if (paramInt != 0) {
      this.b_c = (byte)paramInt;
    } else {
      run_state = -10;
    } 
    mc.paint();
  }
  
  public void doSayOverSms() {
    byte b = this.sayOverSms;
    System.out.println("doSayOverSms() sayOverSms= " + this.sayOverSms);
    this.sayOverSms = -1;
    if (b == 0) {
      isSay = true;
      SMSSender.i(this).go(4, true);
      isSay = false;
      return;
    } 
    if (b == 1)
      SMSSender.i(this).go(3, true); 
  }
  
  public boolean drawCartoonOne(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6) {
    if (this.now_action[paramInt1] >= this.mon[paramInt2].aLength(paramInt3))
      this.now_action[paramInt1] = 0; 
    Ui.i().drawFrameOne(this.mon[paramInt2], this.mon[paramInt2].action(paramInt3, this.now_action[paramInt1], 0), paramInt4, paramInt5, paramInt6);
    return setCartoonFrame_C(paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  public void drawChangeMap(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt1 *= 2;
    if (paramBoolean)
      Ui.i().fillRect(5422575, 0, 0, 640, 360); 
    g.setColor(0);
    g.fillRect(paramInt2, paramInt3 + 1, paramInt4, 5);
    g.fillRect(paramInt2 + 1, paramInt3, paramInt4 - 2, 7);
    g.setColor(15400191);
    if ((paramInt4 - 4) * paramInt1 / 60 > paramInt4) {
      g.fillRect(paramInt2 + 2, paramInt3 + 1, paramInt4, 5);
      g.fillRect(paramInt2 + 1, paramInt3 + 2, paramInt4, 3);
    } else {
      g.fillRect(paramInt2 + 2, paramInt3 + 1, (paramInt4 - 4) * paramInt1 / 60, 5);
      g.fillRect(paramInt2 + 1, paramInt3 + 2, (paramInt4 - 2) * paramInt1 / 60, 3);
    } 
    if (paramBoolean && (Map.npcSp[1][0]).img != null) {
      if ((paramInt4 - 4) * paramInt1 / 60 > paramInt4) {
        this.map.drawMyAni(this.map.my, 0, paramInt4, paramInt3 + 10, 5);
        return;
      } 
    } else {
      return;
    } 
    this.map.drawMyAni(this.map.my, 0, paramInt2 + (paramInt4 - 4) * paramInt1 / 60, paramInt3 + 10, 5);
  }
  
  public void drawCityName() {
    int i = Constants_H.WIDTH__ / 2;
    if (this.cityName_c != -20) {
      byte b;
      short s = (short)(Ms.i().getStringWidth(this.city_name[this.map.mapNo].toString()) + 8);
      Ui ui1 = Ui.i();
      if (this.cityName_c > 0) {
        b = 0;
      } else {
        b = this.cityName_c;
      } 
      ui1.drawKuang(i - (s >> 1), b, s, 25 + 6);
      Ui ui2 = Ui.i();
      String str = this.city_name[this.map.mapNo].toString();
      if (this.cityName_c > 0) {
        b = 0;
      } else {
        b = this.cityName_c;
      } 
      ui2.drawString(str, i, b, 17, 4, 2);
      this.cityName_c = (byte)(this.cityName_c - 1);
    } 
  }
  
  public void drawEvolveUI(int paramInt1, int paramInt2, boolean paramBoolean) {
    // Byte code:
    //   0: invokestatic i : ()Ldm/Ui;
    //   3: invokevirtual fillRectB : ()V
    //   6: aload_0
    //   7: aload_0
    //   8: getfield bg_c : B
    //   11: sipush #200
    //   14: bipush #108
    //   16: iconst_5
    //   17: sipush #230
    //   20: invokespecial drawBG0 : (IIIII)V
    //   23: iload_1
    //   24: iconst_1
    //   25: if_icmpne -> 501
    //   28: aload_0
    //   29: getfield b_c : B
    //   32: ifle -> 501
    //   35: aload_0
    //   36: getfield b_c : B
    //   39: iconst_1
    //   40: if_icmpne -> 377
    //   43: iconst_5
    //   44: iconst_5
    //   45: if_icmpne -> 371
    //   48: bipush #6
    //   50: istore #5
    //   52: aload_0
    //   53: iconst_5
    //   54: iconst_5
    //   55: iload #5
    //   57: sipush #377
    //   60: bipush #97
    //   62: iconst_0
    //   63: invokevirtual drawMagicC : (IIIIII)Z
    //   66: ifeq -> 377
    //   69: aload_0
    //   70: iconst_2
    //   71: aload_0
    //   72: getfield mList_id : [[B
    //   75: aload_0
    //   76: getfield myMonsters : [Ldm/Monster;
    //   79: iload_2
    //   80: aaload
    //   81: getfield monster : [B
    //   84: iconst_0
    //   85: baload
    //   86: aaload
    //   87: iconst_0
    //   88: baload
    //   89: iconst_1
    //   90: invokevirtual initMonStream : (III)V
    //   93: aload_0
    //   94: iconst_2
    //   95: putfield b_c : B
    //   98: iload_1
    //   99: iconst_1
    //   100: if_icmpne -> 548
    //   103: aload_0
    //   104: getfield popMenu : B
    //   107: iconst_1
    //   108: if_icmpne -> 548
    //   111: aload_0
    //   112: aload_0
    //   113: getfield myMonsters : [Ldm/Monster;
    //   116: iload_2
    //   117: aaload
    //   118: getfield monster : [B
    //   121: iconst_0
    //   122: baload
    //   123: sipush #200
    //   126: bipush #25
    //   128: iadd
    //   129: bipush #108
    //   131: bipush #25
    //   133: iadd
    //   134: bipush #22
    //   136: iadd
    //   137: bipush #28
    //   139: invokespecial drawEvolveMake : (IIII)V
    //   142: iload_1
    //   143: ifne -> 646
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield move_y : S
    //   151: aload_0
    //   152: iconst_0
    //   153: putfield move_x : S
    //   156: invokestatic i : ()Ldm/Ui;
    //   159: astore #7
    //   161: new java/lang/StringBuilder
    //   164: dup
    //   165: aload_0
    //   166: aload_0
    //   167: getfield myMonsters : [Ldm/Monster;
    //   170: iload_2
    //   171: aaload
    //   172: getfield monster : [B
    //   175: iconst_0
    //   176: baload
    //   177: invokevirtual getNameMon : (I)Ljava/lang/String;
    //   180: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   183: invokespecial <init> : (Ljava/lang/String;)V
    //   186: ldc_w '升到了'
    //   189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_0
    //   193: getfield myMonsters : [Ldm/Monster;
    //   196: iload_2
    //   197: aaload
    //   198: getfield monster : [B
    //   201: iconst_2
    //   202: baload
    //   203: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   206: ldc_w '级'
    //   209: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual toString : ()Ljava/lang/String;
    //   215: astore #6
    //   217: getstatic main/GameRun.g : Ljavax/microedition/lcdui/Graphics;
    //   220: astore #8
    //   222: getstatic main/GameRun.g : Ljavax/microedition/lcdui/Graphics;
    //   225: astore #8
    //   227: aload #7
    //   229: aload #6
    //   231: sipush #432
    //   234: bipush #108
    //   236: iconst_4
    //   237: iadd
    //   238: bipush #8
    //   240: bipush #16
    //   242: ior
    //   243: iconst_1
    //   244: iconst_0
    //   245: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   248: invokestatic i : ()Ldm/Ui;
    //   251: aload_0
    //   252: getfield imgItem : [Ljavax/microedition/lcdui/Image;
    //   255: iconst_1
    //   256: aaload
    //   257: sipush #200
    //   260: aload_0
    //   261: getfield say_s : I
    //   264: isub
    //   265: bipush #108
    //   267: iconst_4
    //   268: isub
    //   269: bipush #36
    //   271: invokevirtual drawImage : (Ljavax/microedition/lcdui/Image;III)V
    //   274: aload_0
    //   275: getfield levelUp_in_battle : [[B
    //   278: astore #6
    //   280: iload_3
    //   281: ifeq -> 616
    //   284: iload_2
    //   285: istore_1
    //   286: aload #6
    //   288: iload_1
    //   289: aaload
    //   290: iconst_1
    //   291: baload
    //   292: iconst_m1
    //   293: if_icmpeq -> 362
    //   296: invokestatic i : ()Ldm/Ui;
    //   299: astore #7
    //   301: new java/lang/StringBuilder
    //   304: dup
    //   305: ldc_w '习得技能：'
    //   308: invokespecial <init> : (Ljava/lang/String;)V
    //   311: astore #8
    //   313: aload_0
    //   314: getfield levelUp_in_battle : [[B
    //   317: astore #6
    //   319: iload_3
    //   320: ifeq -> 631
    //   323: iload_2
    //   324: istore_1
    //   325: aload #7
    //   327: aload #8
    //   329: aload_0
    //   330: aload #6
    //   332: iload_1
    //   333: aaload
    //   334: iconst_1
    //   335: baload
    //   336: invokespecial getNameSkill : (B)Ljava/lang/String;
    //   339: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual toString : ()Ljava/lang/String;
    //   345: sipush #320
    //   348: sipush #360
    //   351: bipush #60
    //   353: isub
    //   354: bipush #17
    //   356: bipush #9
    //   358: iconst_0
    //   359: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   362: invokestatic i : ()Ldm/Ui;
    //   365: iconst_1
    //   366: iconst_1
    //   367: invokevirtual drawYesNo : (ZZ)V
    //   370: return
    //   371: iconst_1
    //   372: istore #5
    //   374: goto -> 52
    //   377: aload_0
    //   378: getfield b_c : B
    //   381: iconst_1
    //   382: if_icmple -> 98
    //   385: aload_0
    //   386: getfield b_c : B
    //   389: bipush #14
    //   391: if_icmpge -> 98
    //   394: aload_0
    //   395: aload_0
    //   396: getfield mList_id : [[B
    //   399: aload_0
    //   400: getfield myMonsters : [Ldm/Monster;
    //   403: iload_2
    //   404: aaload
    //   405: getfield monster : [B
    //   408: iconst_0
    //   409: baload
    //   410: aaload
    //   411: iconst_1
    //   412: baload
    //   413: iconst_1
    //   414: sipush #377
    //   417: bipush #97
    //   419: bipush #80
    //   421: bipush #77
    //   423: bipush #15
    //   425: aload_0
    //   426: getfield b_c : B
    //   429: iconst_2
    //   430: isub
    //   431: iconst_0
    //   432: invokespecial drawClipPic : (IIIIIIIII)V
    //   435: aload_0
    //   436: getfield b_c : B
    //   439: iconst_1
    //   440: iadd
    //   441: i2b
    //   442: istore #4
    //   444: aload_0
    //   445: iload #4
    //   447: putfield b_c : B
    //   450: iload #4
    //   452: bipush #14
    //   454: if_icmpne -> 98
    //   457: aload_0
    //   458: iconst_m1
    //   459: putfield b_c : B
    //   462: aload_0
    //   463: new java/lang/StringBuilder
    //   466: dup
    //   467: ldc_w '进化成  '
    //   470: invokespecial <init> : (Ljava/lang/String;)V
    //   473: aload_0
    //   474: aload_0
    //   475: getfield myMonsters : [Ldm/Monster;
    //   478: iload_2
    //   479: aaload
    //   480: getfield monster : [B
    //   483: iconst_0
    //   484: baload
    //   485: invokevirtual getNameMon : (I)Ljava/lang/String;
    //   488: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual toString : ()Ljava/lang/String;
    //   494: iconst_0
    //   495: invokevirtual say : (Ljava/lang/String;I)V
    //   498: goto -> 98
    //   501: aload_0
    //   502: iconst_1
    //   503: iconst_1
    //   504: aload_0
    //   505: getfield mList_id : [[B
    //   508: aload_0
    //   509: getfield myMonsters : [Ldm/Monster;
    //   512: iload_2
    //   513: aaload
    //   514: getfield monster : [B
    //   517: iconst_0
    //   518: baload
    //   519: aaload
    //   520: iconst_1
    //   521: baload
    //   522: iconst_3
    //   523: imul
    //   524: sipush #377
    //   527: aload_0
    //   528: getfield move_x : S
    //   531: isub
    //   532: bipush #97
    //   534: aload_0
    //   535: getfield move_y : S
    //   538: isub
    //   539: iconst_1
    //   540: iconst_0
    //   541: invokevirtual drawCartoonOne : (IIIIIZI)Z
    //   544: pop
    //   545: goto -> 98
    //   548: invokestatic i : ()Ldm/Ui;
    //   551: aload_0
    //   552: getfield about_b : [Ljava/lang/StringBuffer;
    //   555: sipush #200
    //   558: bipush #25
    //   560: iadd
    //   561: bipush #16
    //   563: isub
    //   564: bipush #108
    //   566: bipush #25
    //   568: iadd
    //   569: bipush #22
    //   571: iadd
    //   572: iconst_0
    //   573: iconst_3
    //   574: bipush #40
    //   576: iconst_3
    //   577: iconst_0
    //   578: invokevirtual drawStringY : ([Ljava/lang/Object;IIIIIII)V
    //   581: invokestatic i : ()Ldm/Ui;
    //   584: aload_0
    //   585: getfield about_a : [Ljava/lang/StringBuffer;
    //   588: sipush #200
    //   591: bipush #125
    //   593: iadd
    //   594: iconst_3
    //   595: isub
    //   596: bipush #108
    //   598: bipush #25
    //   600: iadd
    //   601: bipush #22
    //   603: iadd
    //   604: iconst_0
    //   605: iconst_3
    //   606: bipush #40
    //   608: iconst_3
    //   609: iconst_0
    //   610: invokevirtual drawStringY : ([Ljava/lang/Object;IIIIIII)V
    //   613: goto -> 142
    //   616: aload_0
    //   617: getfield myMonsters : [Ldm/Monster;
    //   620: iload_2
    //   621: aaload
    //   622: getfield monster : [B
    //   625: iconst_1
    //   626: baload
    //   627: istore_1
    //   628: goto -> 286
    //   631: aload_0
    //   632: getfield myMonsters : [Ldm/Monster;
    //   635: iload_2
    //   636: aaload
    //   637: getfield monster : [B
    //   640: iconst_1
    //   641: baload
    //   642: istore_1
    //   643: goto -> 325
    //   646: iload_1
    //   647: iconst_1
    //   648: if_icmpne -> 362
    //   651: invokestatic i : ()Ldm/Ui;
    //   654: astore #6
    //   656: aload_0
    //   657: getfield popMenu : B
    //   660: ifne -> 873
    //   663: bipush #-127
    //   665: istore_1
    //   666: aload #6
    //   668: sipush #320
    //   671: iload_1
    //   672: iadd
    //   673: bipush #108
    //   675: bipush #6
    //   677: iadd
    //   678: bipush #113
    //   680: bipush #27
    //   682: iconst_4
    //   683: invokevirtual drawK1 : (IIIII)V
    //   686: invokestatic i : ()Ldm/Ui;
    //   689: astore #6
    //   691: aload_0
    //   692: getfield popMenu : B
    //   695: ifne -> 879
    //   698: iconst_0
    //   699: istore_1
    //   700: aload #6
    //   702: ldc_w '基本属性'
    //   705: sipush #320
    //   708: bipush #75
    //   710: isub
    //   711: iconst_4
    //   712: iadd
    //   713: bipush #108
    //   715: iconst_5
    //   716: iadd
    //   717: bipush #17
    //   719: iload_1
    //   720: iconst_0
    //   721: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   724: invokestatic i : ()Ldm/Ui;
    //   727: astore #6
    //   729: aload_0
    //   730: getfield popMenu : B
    //   733: ifne -> 884
    //   736: iconst_1
    //   737: istore_1
    //   738: aload #6
    //   740: ldc_w '进化素材'
    //   743: sipush #320
    //   746: bipush #75
    //   748: iadd
    //   749: iconst_4
    //   750: isub
    //   751: bipush #108
    //   753: iconst_5
    //   754: iadd
    //   755: bipush #17
    //   757: iload_1
    //   758: iconst_0
    //   759: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   762: aload_0
    //   763: getfield pkey : Lmain/PointerKey;
    //   766: iconst_2
    //   767: iconst_0
    //   768: bipush #108
    //   770: iconst_5
    //   771: iadd
    //   772: sipush #320
    //   775: bipush #33
    //   777: invokevirtual selectMenuX : (IIIII)B
    //   780: istore #4
    //   782: iload #4
    //   784: iconst_m1
    //   785: if_icmpeq -> 794
    //   788: aload_0
    //   789: iload #4
    //   791: putfield popMenu : B
    //   794: invokestatic i : ()Ldm/Ui;
    //   797: sipush #320
    //   800: bipush #108
    //   802: bipush #15
    //   804: iadd
    //   805: sipush #150
    //   808: iconst_1
    //   809: iconst_1
    //   810: invokevirtual drawTriangle : (IIIZZ)V
    //   813: aload_0
    //   814: invokestatic i : ()Ldm/Ms;
    //   817: aload_0
    //   818: getfield move_x : S
    //   821: iconst_3
    //   822: iconst_0
    //   823: invokevirtual mathSpeedDown : (IIZ)S
    //   826: putfield move_x : S
    //   829: aload_0
    //   830: invokestatic i : ()Ldm/Ms;
    //   833: aload_0
    //   834: getfield move_y : S
    //   837: iconst_3
    //   838: iconst_0
    //   839: invokevirtual mathSpeedDown : (IIZ)S
    //   842: putfield move_y : S
    //   845: invokestatic i : ()Ldm/Ui;
    //   848: ldc_w '确定进化该宠物？'
    //   851: sipush #320
    //   854: sipush #360
    //   857: bipush #25
    //   859: isub
    //   860: bipush #22
    //   862: isub
    //   863: bipush #17
    //   865: iconst_0
    //   866: iconst_1
    //   867: invokevirtual drawString : (Ljava/lang/String;IIIII)V
    //   870: goto -> 362
    //   873: bipush #15
    //   875: istore_1
    //   876: goto -> 666
    //   879: iconst_1
    //   880: istore_1
    //   881: goto -> 700
    //   884: iconst_0
    //   885: istore_1
    //   886: goto -> 738
  }
  
  public void drawFealty(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    for (byte b = 0;; b = (byte)(b + 1)) {
      byte b1;
      if (b >= paramInt1)
        return; 
      Ui ui = Ui.i();
      if (b > paramInt2) {
        b1 = 22;
      } else {
        b1 = 21;
      } 
      ui.drawUi(b1, b * 14 + paramInt3, paramInt4, 0, 0);
    } 
  }
  
  public void drawItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i;
    if (paramInt1 >= 58) {
      i = this.monster_pro[this.nidusList[0][paramInt1 - 58]][6] + 40;
    } else {
      i = paramInt1;
      if (paramInt1 >= 35)
        i = this.makeLevel[paramInt1 - 35] + 34; 
    } 
    Ui.i().drawRegion(this.item_img, this.item_modules[i][0], this.item_modules[i][1], this.item_modules[i][2], this.item_modules[i][3], paramInt2, paramInt3, paramInt4, 0, g);
  }
  
  public boolean drawMagicC(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    if (this.now_action_Magic[paramInt1] >= this.magic[paramInt2].aLength(paramInt3)) {
      this.now_action_Magic[paramInt1] = 0;
      return true;
    } 
    short s;
    for (s = (short)this.magic[paramInt2].action(paramInt3, this.now_action_Magic[paramInt1], 0);; s = (short)this.magic[paramInt2].action(paramInt3, this.now_action_Magic[paramInt1], 0)) {
      if (this.dm == null || s >= 2) {
        Ui.i().drawFrameOne(this.magic[paramInt2], s, paramInt4, paramInt5, paramInt6);
        return setCartoonFrameMagic_C(paramInt1, paramInt2, paramInt3, true);
      } 
      if (s == 0)
        this.dm.ceff[0] = 2; 
      this.now_time_Magic[paramInt1] = 0;
      short[] arrayOfShort = this.now_action_Magic;
      short s1 = (short)(arrayOfShort[paramInt1] + 1);
      arrayOfShort[paramInt1] = s1;
      if (s1 >= this.magic[paramInt2].aLength(paramInt3)) {
        this.now_action_Magic[paramInt1] = 0;
        return true;
      } 
    } 
  }
  
  public void drawMoney(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    int i;
    if (paramBoolean) {
      i = this.coin;
    } else {
      i = this.money;
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(i));
    if (paramBoolean) {
      str = "徽章";
    } else {
      str = "金";
    } 
    String str = stringBuilder.append(str).toString();
    Ui ui = Ui.i();
    if (paramBoolean) {
      i = 53;
    } else {
      i = 52;
    } 
    int j = Ms.i().getStringWidth(str);
    Graphics graphics = g;
    graphics = g;
    ui.drawUi(i, paramInt1 - (j >> 1) - 1, paramInt2, 0x8 | 0x20, 0);
    ui = Ui.i();
    graphics = g;
    graphics = g;
    ui.drawString(str, paramInt1, paramInt2 + 3, 0x1 | 0x20, paramInt3, 1);
  }
  
  public void drawMyMon() {
    byte b;
    boolean bool;
    drawEffectImage(this.myB.getMon(), 220, 164);
    byte b2 = this.mList_id[(this.myB.getMon()).monster[0]][1];
    byte b1 = this.myB.action;
    if (this.myB.ceff[0] != 0) {
      b = -3;
    } else {
      b = 0;
    } 
    if (this.myB.ceff[0] != 0) {
      s = 3;
    } else {
      s = 0;
    } 
    if (this.myB.action == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (drawCartoonOne(1, 1, b2 * 3 + b1, b + 266, s + 236, bool, 1))
      if ((this.myB.getMon()).monsterPro[0] < 1) {
        this.myB.action = 2;
        this.myB.dead = 1;
      } else {
        this.myB.action = 0;
      }  
    this.myB.ceff[0] = (byte)Ms.i().mathSpeedN(this.myB.ceff[0], 0, 1, true);
    drawMonsterHp(this.myB.getMon(), 241, 237, 50, 0, 1, this.myB.chp);
    drawMonsterHp(this.myB.getMon(), 241, 242, 50, 1, 2, (this.myB.getMon()).monsterPro[1]);
    Battle battle = this.myB;
    Ms ms = Ms.i();
    short s1 = this.myB.chp;
    short s = (this.myB.getMon()).monsterPro[0];
    if (this.myB.chp < (this.myB.getMon()).monsterPro[0]) {
      b = 20;
    } else {
      b = 6;
    } 
    battle.chp = ms.mathSpeedN(s1, s, b, true);
  }
  
  public void drawPauseIco(int paramInt) {
    for (paramInt = 0;; paramInt = (byte)(paramInt + 1)) {
      if (paramInt >= this.b_ico)
        return; 
      Ui.i().drawImage(this.imgIco[paramInt], this.pkey.button_pos[6][paramInt][0], this.pkey.button_pos[6][paramInt][1], 0);
    } 
  }
  
  public void exitNidus() {
    run_state = -10;
    this.mon[1] = null;
    initNidusMap(1);
  }
  
  public void falselly(int paramInt) {
    SMSSender.i(this).setSendSms(-1);
    if (paramInt == 7) {
      try {
        (SMSSender.i(this)).sms_a = true;
        goGameOver();
        System.out.println("ccccccccc");
        mc.setSmsIsSetRun_state(true);
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      return;
    } 
    if (paramInt == 5) {
      run_state = SMSSender.i(this).getTstate();
      mc.temp_state = run_state;
      mc.setSmsIsSetRun_state(true);
      return;
    } 
    if (paramInt == 6) {
      run_state = -10;
      mc.temp_state = run_state;
      mc.setSmsIsSetRun_state(true);
      System.out.println("  我的mc.setSmsIsSetRun_state(true);");
      this.map.setRegState(false);
      return;
    } 
    if (paramInt == 1 && SMSSender.i(this).getSmsSenderMenuState() != 0) {
      Log.d("soars", "soooooooooooooooooooooooooooooooooooooooo");
      mc.setSmsIsSetRun_state(true);
      run_state = SMSSender.i(this).getTstate();
    } 
  }
  
  public byte findItem(int paramInt1, int paramInt2, boolean paramBoolean) {
    byte b2 = 0;
    byte b1 = b2;
    int i = paramInt1;
    if (paramInt1 == -2) {
      i = findItemType(paramInt2);
      b1 = b2;
    } 
    while (true) {
      if (b1 >= this.itemsLength[i]) {
        if (paramBoolean) {
          paramInt1 = 0;
        } else {
          paramInt1 = -1;
        } 
        return (byte)paramInt1;
      } 
      if (this.items[i][b1][0] == paramInt2) {
        if (paramBoolean)
          b1 = this.items[i][b1][1]; 
        return b1;
      } 
      b1 = (byte)(b1 + 1);
    } 
  }
  
  public byte findItemType(int paramInt) {
    return (paramInt < 16) ? 0 : ((paramInt < 35) ? 1 : ((paramInt < 58) ? 2 : 3));
  }
  
  public byte findMonster(int paramInt1, int paramInt2) {
    byte b = 0;
    while (true) {
      if (b >= this.myMon_length)
        return -1; 
      if ((this.myMonsters[b]).monster[0] != paramInt1 || (this.myMonsters[b]).monster[2] < paramInt2) {
        b = (byte)(b + 1);
        continue;
      } 
      return b;
    } 
  }
  
  public byte findMonsterMinLv(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iconst_m1
    //   1: istore #5
    //   3: aload_0
    //   4: getfield myMon_length : B
    //   7: iconst_1
    //   8: isub
    //   9: i2b
    //   10: istore_3
    //   11: iload_3
    //   12: iconst_m1
    //   13: if_icmpgt -> 19
    //   16: iload #5
    //   18: ireturn
    //   19: iload #5
    //   21: istore #4
    //   23: aload_0
    //   24: getfield myMonsters : [Ldm/Monster;
    //   27: iload_3
    //   28: aaload
    //   29: getfield monster : [B
    //   32: iconst_0
    //   33: baload
    //   34: iload_1
    //   35: if_icmpne -> 96
    //   38: iload #5
    //   40: istore #4
    //   42: aload_0
    //   43: getfield myMonsters : [Ldm/Monster;
    //   46: iload_3
    //   47: aaload
    //   48: getfield monster : [B
    //   51: iconst_2
    //   52: baload
    //   53: iload_2
    //   54: if_icmplt -> 96
    //   57: iload #5
    //   59: iconst_m1
    //   60: if_icmpeq -> 93
    //   63: iload #5
    //   65: istore #4
    //   67: aload_0
    //   68: getfield myMonsters : [Ldm/Monster;
    //   71: iload_3
    //   72: aaload
    //   73: getfield monster : [B
    //   76: iconst_2
    //   77: baload
    //   78: aload_0
    //   79: getfield myMonsters : [Ldm/Monster;
    //   82: iload #5
    //   84: aaload
    //   85: getfield monster : [B
    //   88: iconst_2
    //   89: baload
    //   90: if_icmpge -> 96
    //   93: iload_3
    //   94: istore #4
    //   96: iload_3
    //   97: iconst_1
    //   98: isub
    //   99: i2b
    //   100: istore_3
    //   101: iload #4
    //   103: istore #5
    //   105: goto -> 11
  }
  
  public boolean gameCheckRegIsOK() {
    if (this.rmsSms[6] == 10) {
      boolean bool1 = true;
      System.out.println("gameCheckRegIsOK reged= " + bool1);
      return bool1;
    } 
    boolean bool = false;
    System.out.println("gameCheckRegIsOK reged= " + bool);
    return bool;
  }
  
  public void getEnemy(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramInt1 == -1) {
      Ms.i();
      if (Ms.getRandom(100) < 5 && this.monPro.length > 6) {
        paramInt1 = 6;
      } else {
        byte[] arrayOfByte = this.monPro;
        Ms.i();
        if (this.monPro.length > 6) {
          paramInt1 = 3;
        } else {
          paramInt1 = this.monPro.length - 3;
        } 
        paramInt1 = arrayOfByte[Ms.getRandom(paramInt1) + 3];
      } 
      Ms.i();
      paramArrayOfbyte[1] = (byte)(Ms.getRandom(this.monPro[2] + 1) + this.monPro[1]);
    } else {
      paramArrayOfbyte[1] = (byte)paramInt2;
    } 
    paramArrayOfbyte[0] = (byte)paramInt1;
  }
  
  public byte getItem(int paramInt1, int paramInt2) {
    if (addItem(paramInt1, paramInt2) == 1) {
      say("获得：“" + getNameItem((byte)paramInt1) + "”x" + paramInt2, 0);
      return 1;
    } 
    return -1;
  }
  
  public byte getItemCount(int paramInt) {
    if (this.buyItemID != 2) {
      findItemType(paramInt);
      byte b = 0;
      while (true) {
        if (b < (this.items[this.item_type]).length) {
          if (this.items[this.item_type][b][0] == paramInt)
            return this.items[this.item_type][b][1]; 
          b++;
          continue;
        } 
        return 0;
      } 
    } 
    return 0;
  }
  
  public void getMagic(Monster paramMonster) {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[1] = 7;
    arrayOfByte[2] = 14;
    arrayOfByte[3] = 21;
    arrayOfByte[4] = 28;
    arrayOfByte[5] = 35;
    this.getSkill = -1;
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= arrayOfByte.length)
        return; 
      if (paramMonster.monster[b + 8] == -1 && paramMonster.monster[2] >= arrayOfByte[b]) {
        getSkill(b, paramMonster.monster[3]);
        paramMonster.monster[b + 8] = this.getSkill;
      } 
    } 
  }
  
  public byte getMonster(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Monster monster = new Monster(this, paramInt1, paramInt2, paramInt4);
    if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
      say("宠物空间已满", 0);
      return -1;
    } 
    if (getMonster(monster, paramInt3, true) != 1) {
      say("获得宠物：" + getNameMon((byte)paramInt1), 0);
    } else {
      say("携带已满，" + getNameMon(monster.monster[0]) + "已转入寄放处", 0);
    } 
    return 1;
  }
  
  public String getNameCity(int paramInt) {
    return this.city_name[paramInt].toString();
  }
  
  public String getNameItem(int paramInt) {
    return this.item_name[paramInt].toString();
  }
  
  public String getNameMon(int paramInt) {
    return this.NAME[paramInt].toString();
  }
  
  public String getNameMonsterInfo(int paramInt) {
    return this.monsterInfo[paramInt].toString();
  }
  
  public void goBUY_ITEM(int paramInt1, int paramInt2) {
    if (paramInt2 != 1) {
      setAction_str(new String[] { "道具", "矿石", "徽章" });
    } else {
      setAction_str(new String[] { "道具", "辅助", "卷轴" });
    } 
    this.cur_a = (byte)paramInt1;
    this.cur_b = (byte)paramInt2;
    byte[] arrayOfByte = this.select[0];
    this.select[0][0] = 0;
    arrayOfByte[1] = 0;
    run_state = 18;
    this.list_rows = 6;
    this.buyOk = 0;
    this.popMenu = -1;
    arrayOfByte = Ms.i().getStream("data/shop.d", -1);
    Ms.i();
    Ms.skip = 0;
    this.buyItem = Ms.i().create2Array(arrayOfByte);
    this.buyPrice = Ms.i().createShort2Array(arrayOfByte, 0);
    arrayOfByte = (byte[])null;
  }
  
  public void goBattle() {
    this.first_battle = 0;
    this.lastSkill = 0;
    this.b_c = 0;
    this.cur_a = 0;
    this.mon_in_battle = null;
    this.mon_in_battle = new byte[this.max_takes + 1];
    this.levelUp_in_battle = null;
    byte b1 = this.max_takes;
    this.levelUp_in_battle = new byte[b1][2];
    this.proReplace = null;
    int i = this.myMonsters.length;
    this.proReplace = new short[i][7];
    this.myB = new Battle(this.myMonsters);
    enemy_init();
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= this.myMon_length) {
        i = 0;
        while (true) {
          if (i < this.myMon_length)
            if ((this.myMonsters[i]).monsterPro[0] > 0) {
              byte[] arrayOfByte2 = this.mon_in_battle;
              byte[] arrayOfByte1 = this.mon_in_battle;
              b = (byte)(arrayOfByte1[0] + 1);
              arrayOfByte1[0] = b;
              arrayOfByte2[b] = (this.myMonsters[i]).monster[1];
              if (i != 0)
                changeMonster(this.myMonsters[i], this.myMonsters[0]); 
            } else {
              i = (byte)(i + 1);
              continue;
            }  
          if (this.effectImage == null)
            this.effectImage = Ms.i().createImageArray(7, "data/brow/e"); 
          if (this.imgBattle == null)
            this.imgBattle = Ms.i().createImageArray(5, "data/battle/b"); 
          this.map.my.state = 15;
          run_state = -30;
          this.view_state = -1;
          new CreateThread(this, 1);
          return;
        } 
        break;
      } 
      (this.myMonsters[b]).effect = 7;
      (this.myMonsters[b]).effect_time = 0;
      (this.myMonsters[b]).monster[1] = b;
      this.proReplace[b][6] = (this.myMonsters[b]).monster[2];
    } 
  }
  
  public void goBattlePVC() {
    this.enemyList = null;
    this.enemyList = new byte[1][2];
    getEnemy(this.enemyList[0], -1, 0);
    Sound.i().setMusicId(6);
    Sound.i().setMusic(true);
    goBattle();
  }
  
  public void goGameOver() {
    run_state = 60;
  }
  
  public void goMAIN_MENU() {
    boolean bool;
    mc.logo_c = 29;
    mc.image_logo = null;
    setNull(true);
    this.myMonsters = null;
    this.cMonsters = null;
    System.gc();
    mc.createFlashImage();
    mc.goMain_menu();
    setAction_str(new String[] { "读取进度", "新游戏", "声音", "游戏帮助", "关   于", "退出游戏" });
    if (this.rmsOther[0] == -1) {
      bool = true;
    } else {
      bool = false;
    } 
    byte b = (byte)bool;
    this.selecty = b;
    this.selectx = b;
  }
  
  public void goNidus(int paramInt) {
    run_state = 66;
    this.mini_state = 16;
    setStringB("查看孵化#n选择蛋#n离开", Constants_H.WIDTH, 3);
    this.popMenu = (byte)paramInt;
    this.b_c = -2;
  }
  
  public void goVIEW_COMPUTER(int paramInt) {
    run_state = 65;
    setStringB("存放#n取出#n离开", Constants_H.WIDTH, 3);
    this.popMenu = (byte)paramInt;
  }
  
  public void goVIEW_MONSTER() {
    byte b;
    Monster monster;
    run_state = 35;
    this.cur_c = 0;
    this.selecty = 0;
    this.selectx = 0;
    if (this.mini_state == 6) {
      b = this.cMon_count;
    } else {
      b = this.myMon_length;
    } 
    this.t_length = b;
    byte[] arrayOfByte = this.select[0];
    this.select[0][1] = 0;
    arrayOfByte[0] = 0;
    this.popMenu = -1;
    this.list_rows = 5;
    this.mon_action = 0;
    setStringB("生命#n能量#n档次", Constants_H.WIDTH, 0);
    setStringB("力量#n防御#n敏捷", Constants_H.WIDTH, 1);
    if (this.mini_state == 6) {
      monster = this.cMonsters[this.select[0][0]];
    } else {
      monster = this.myMonsters[this.select[0][0]];
    } 
    this.cur_mon = monster;
    if (this.t_length != 0) {
      setShowPro(this.cur_mon);
      initMonStream(2, this.mList_id[this.cur_mon.monster[0]][0], 1);
    } 
  }
  
  public void goYouPAUSE(int paramInt) {
    run_state = 97;
    this.selectx = 0;
    this.selecty = (byte)paramInt;
    setPauseS(0);
    Sound.i().soundStop();
    this.say_c = 0;
    this.view_state = 1;
    this.mini_state = 3;
    this.buyItemID = 0;
    this.buyOk = 0;
    this.gogoString = "金属克野兽，野兽克植物，植物克飞行，飞行克海洋，海洋克金属";
  }
  
  void healMonster(Monster paramMonster) {
    paramMonster.effect = 7;
    paramMonster.monsterPro[1] = paramMonster.monsterPro[3];
    paramMonster.monsterPro[0] = paramMonster.monsterPro[2];
  }
  
  public void healMonster(boolean paramBoolean) {
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= this.myMon_length) {
        if (paramBoolean)
          say("您携带的宠物已回复。", 0); 
        return;
      } 
      healMonster(this.myMonsters[b]);
    } 
  }
  
  public void initBattle() {
    System.gc();
    byte[] arrayOfByte3 = this.src_c;
    byte[] arrayOfByte2 = this.src_c;
    byte[] arrayOfByte1 = this.src_c;
    this.src_c[3] = 0;
    arrayOfByte1[2] = 0;
    arrayOfByte2[1] = 0;
    arrayOfByte3[0] = 0;
    getBattleBG(this.enB, this.enB.getMon());
    getBattleBG(this.myB, this.myB.getMon());
    setEnemyThrow();
    setMyThrow();
  }
  
  public void initImgIco() {
    if (this.imgIco == null)
      this.imgIco = Ms.i().createImageArray_(7, "data/brow/i", 1); 
  }
  
  public void initItemModules() {
    this.item_img = Ms.i().createImage("data/item");
    Ms.i();
    Ms.skip = 0;
    this.item_modules = Ms.i().create2Array(Ms.i().getStream("data/item_m.d", -1));
  }
  
  public void initMonPro(int paramInt, boolean paramBoolean) {
    String str;
    Ms.i();
    Ms.skip = 0;
    Ms ms = Ms.i();
    StringBuilder stringBuilder = new StringBuilder("data/map/");
    if (paramBoolean) {
      str = "m";
    } else {
      str = "boss";
    } 
    byte[] arrayOfByte = ms.getStream(stringBuilder.append(str).append(paramInt).append(".d").toString(), -1);
    this.monPro = Ms.i().createArray(arrayOfByte);
    this.mapMove = Ms.i().createArray(arrayOfByte);
    this.mapRect = Ms.i().create2Array(arrayOfByte);
  }
  
  public void initMonStream(int paramInt1, int paramInt2, int paramInt3) {
    String str = "data/npc" + paramInt1 + "/" + paramInt2;
    boolean bool = true;
    if (paramInt1 == 2)
      bool = isNpc2ImageType(paramInt2); 
    if (this.mon[paramInt3] == null) {
      this.mon[paramInt3] = Ms.i().createSprite(str, bool);
      return;
    } 
    Ms.i().setSprite(this.mon[paramInt3], str, bool);
  }
  
  public void initNidusMap(int paramInt) {
    if (this.nidusMap == null)
      this.nidusMap = new byte[5]; 
    byte b = 0;
    boolean bool = false;
    if (paramInt == 0) {
      paramInt = bool;
      while (true) {
        if (paramInt < this.nidusMap.length) {
          this.nidusMap[paramInt] = -1;
          paramInt = (byte)(paramInt + 1);
          continue;
        } 
        return;
      } 
    } 
    while (true) {
      if (b < this.nidusMap.length) {
        if (this.nidusMap[b] != -1)
          if (getRid(b) != -2) {
            (this.map.npc[0][this.nidusMap[b]]).other[4] = 1;
            (this.map.npc[0][this.nidusMap[b]]).other[7] = (byte)(this.monster_pro[getNid(b)][6] + 17);
          } else {
            (this.map.npc[0][this.nidusMap[b]]).other[4] = 0;
          }  
        b = (byte)(b + 1);
        continue;
      } 
      return;
    } 
  }
  
  public void initSkillList(Monster paramMonster) {
    this.skill_list[8] = 0;
    for (byte b = 7;; b = (byte)(b - 1)) {
      if (b <= -1) {
        b = 1;
        label20: while (true) {
          if (b >= 8)
            return; 
          byte b1;
          for (b1 = b;; b1 = (byte)(b1 - 1)) {
            if (b1 <= 0 || this.skill_list[b1] <= this.skill_list[b1 - 1]) {
              b = (byte)(b + 1);
              continue label20;
            } 
            byte b2 = this.skill_list[b1];
            this.skill_list[b1] = this.skill_list[b1 - 1];
            this.skill_list[b1 - 1] = b2;
          } 
          break;
        } 
        break;
      } 
      this.skill_list[b] = paramMonster.monster[b + 8];
      if (this.skill_list[b] != -1) {
        byte[] arrayOfByte = this.skill_list;
        arrayOfByte[8] = (byte)(arrayOfByte[8] + 1);
      } 
    } 
  }
  
  public boolean isMoney(int paramInt, boolean paramBoolean) {
    if (paramBoolean) {
      if (this.money >= paramInt) {
        this.money -= paramInt;
        return true;
      } 
      say("金钱不足！", 0);
    } else {
      if (this.coin >= paramInt) {
        this.coin -= paramInt;
        return true;
      } 
      say("徽章不足！", 0);
    } 
    return false;
  }
  
  public boolean isMoneyItem(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    if (findItem(-2, paramInt2, true) + paramInt3 > 99) {
      say("数量已到上限", 0);
      return false;
    } 
    if (paramBoolean) {
      if (this.money >= this.sell_money * paramInt3) {
        this.money -= this.sell_money * paramInt3;
        return true;
      } 
      if (this.money < this.sell_money * paramInt3) {
        say("金钱不足！", -1, 0);
      } else {
        say("背包空间不足。", 0, -1);
      } 
    } else {
      if (this.coin >= this.sell_money * paramInt3) {
        this.coin -= this.sell_money * paramInt3;
        return true;
      } 
      if (this.coin < this.sell_money * paramInt3) {
        say("徽章不足！", 0);
      } else {
        say("背包空间不足。", 0);
      } 
    } 
    return false;
  }
  
  public boolean isNpc2ImageType(int paramInt) {
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= this.npc2ImageType.length)
        return true; 
      if (this.npc2ImageType[b] == paramInt)
        return false; 
    } 
  }
  
  public void keyGameOver1(boolean paramBoolean) {
    if (Ms.i().key_S1_Num5()) {
      if (this.popMenu == 1) {
        goMAIN_MENU();
      } else if (this.popMenu == 0) {
        System.out.println("loadGame soars");
        loadGame();
      } 
      this.popMenu = -1;
    } else if (Ms.i().key_Up_Down()) {
      this.popMenu = (byte)(this.popMenu ^ 0x1);
    } 
    Ms.i().keyRelease();
  }
  
  public void keyLIST_INFO() {
    if (Ms.i().key_delay())
      return; 
    if (Ms.i().key_S1_Num5()) {
      if (this.monInfoList[getMonInfo_dir()] != 0)
        goMONSTER_INFO(getMonInfo_dir()); 
      return;
    } 
    if (Ms.i().key_S2()) {
      this.action_str = null;
      this.monInfo_dir = null;
      doPaint(0);
      goYouPAUSE(3);
      return;
    } 
    if (Ms.i().key_Left_Right()) {
      this.cur_a = Ms.i().select(this.cur_a, 0, 4);
      this.infoStart = 0;
      if (this.cur_a > 0) {
        byte b = 0;
        while (true) {
          if (b < this.cur_a) {
            this.infoStart = (byte)(this.infoStart + (this.monInfo_dir[b]).length);
            b = (byte)(b + 1);
            continue;
          } 
          this.t_length = (byte)(this.monInfo_dir[this.cur_a]).length;
          byte[] arrayOfByte1 = this.select[0];
          this.select[0][1] = 0;
          arrayOfByte1[0] = 0;
          return;
        } 
      } 
    } else {
      if (Ms.i().key_Up_Down())
        Ms.i().selectS(this.select[0], 0, this.t_length, this.list_rows); 
      return;
    } 
    this.t_length = (byte)(this.monInfo_dir[this.cur_a]).length;
    byte[] arrayOfByte = this.select[0];
    this.select[0][1] = 0;
    arrayOfByte[0] = 0;
  }
  
  public void key_gameRun() {
    if (run_state == 98) {
      if (Ms.i().key_Num0() || Ms.i().key_S1_Num5())
        mc.doShowNotify(); 
      Ms.i().keyRelease();
      Log.d("soars", "doShowNotify2");
      return;
    } 
    if (this.say_c > 0) {
      Ms.i().keyRelease();
      return;
    } 
    if (this.say_c < 0) {
      if (this.say_s == 0 && Ms.i().key_S1_Num5()) {
        this.say_c = 0;
        doSayOverSms();
      } 
      Ms.i().keyRelease();
      return;
    } 
    switch (run_state) {
      default:
        if (Ms.i().key_S1_Num5() || Ms.i().key_S2())
          Ms.i().keyRelease(); 
        return;
      case -10:
        this.map.key_map();
      case -31:
        keyBattleState();
      case -15:
        if (!Ms.i().key_delay()) {
          if (this.b_c == 1 && this.say_s == 0)
            this.b_c = 0; 
        } else {
          return;
        } 
      case 61:
        keyGameOver1(true);
      case 60:
        Ms.i().keyRelease();
        run_state = 61;
        setAction_str(new String[] { "继续", "放弃" });
        this.popMenu = 0;
      case 67:
        if (Ms.i().key_S2()) {
          goLIST_INFO(false);
          Ms.i().keyRelease();
        } 
      case 68:
        keyLIST_INFO();
      case 97:
        if (!Ms.i().key_delay()) {
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
                goVIEW_MONSTER();
              } else if (this.selecty == 2) {
                goMY_BAG(0);
              } else if (this.selecty == 3) {
                goLIST_INFO(true);
              } else if (this.selecty == 4) {
                this.map.goMission(0, true);
              } else if (this.selecty == 5) {
                goRUN_IN_MAP(true);
                this.action_str = null;
              } 
            } else if (this.selecty == 0) {
              if (this.buyOk == 2) {
                loadGame();
              } else {
                this.buyOk = 2;
              } 
            } else if (this.selecty == 1) {
              this.isChangeSound = Boolean.valueOf(true);
              Sound.i().keyVolume(0);
            } else if (this.selecty == 2) {
              mc.goHELP_dialog(1);
            } else if (this.selecty == 3) {
              if (this.buyOk == 3) {
                run_state = 0;
                this.action_str = null;
                goMAIN_MENU();
                this.buyOk = 0;
              } else {
                this.buyOk = 3;
              } 
            } 
          } else if (Ms.i().key_S2()) {
            if (this.buyOk == 0) {
              this.action_str = null;
              goRUN_IN_MAP(true);
            } else {
              doPaint(0);
              run_state = 97;
              this.buyOk = 0;
            } 
          } else if (this.buyOk == 0) {
            if (Ms.i().key_Left_Right()) {
              this.selectx = (byte)(this.selectx ^ 0x1);
              this.selecty = 0;
              setPauseS(this.selectx);
            } else if (Ms.i().key_Up_Down()) {
              this.selecty = Ms.i().select(this.selecty, 0, this.action_str.length - 1);
            } 
          } 
        } else {
          return;
        } 
      case 51:
        if (Ms.i().key_Num0()) {
          this.map.my.state = 0;
          this.map.eventGoing = 2;
          Ms.i().keyRelease();
          this.map.dialog_no = -1;
          goGO_RUNINMAP();
        } 
      case 35:
        if (!Ms.i().key_delay()) {
          if (this.cur_c == 0) {
            Monster[] arrayOfMonster;
            if (this.mini_state == 6) {
              arrayOfMonster = this.cMonsters;
            } else {
              arrayOfMonster = this.myMonsters;
            } 
            key_MONSTER_LIST(arrayOfMonster);
          } else if (this.cur_c == 1) {
            keyMagicUI();
          } else if (this.cur_c == 2) {
            keyEvolveUI();
          } 
        } else {
          return;
        } 
      case 65:
        if (!Ms.i().key_delay()) {
          popState();
        } else {
          return;
        } 
      case 66:
        keyNidus();
      case 25:
        keyMY_BAG();
      case 18:
        keyBuyItem();
      case 69:
        Mg.i().key(this);
      case -20:
        SMSSender.i(this).key();
      case -21:
        break;
    } 
    SMSSender.i(this).keyLevel();
    Sound.i().soundStop();
  }
  
  public void levelPro(int paramInt, boolean paramBoolean) {
    if (paramBoolean) {
      byte b1 = (byte)this.proReplace[paramInt][6];
      byte[] arrayOfByte1 = this.monster_pro[(this.myMonsters[paramInt]).monster[0]];
      short s2 = (short)(arrayOfByte1[0] + arrayOfByte1[7] * b1 / 10);
      s2 = getbuffRateV(this.myMonsters[paramInt], s2);
      this.proReplace[paramInt][0] = (short)((this.myMonsters[paramInt]).monsterPro[2] - s2);
      s2 = (short)(arrayOfByte1[1] + arrayOfByte1[8] * b1 / 10);
      this.proReplace[paramInt][1] = (short)((this.myMonsters[paramInt]).monsterPro[3] - s2);
      s2 = (short)(arrayOfByte1[3] + arrayOfByte1[10] * b1 / 10);
      this.proReplace[paramInt][3] = (short)((this.myMonsters[paramInt]).monsterPro[6] - s2);
      s2 = (short)(arrayOfByte1[4] + arrayOfByte1[11] * b1 / 10);
      this.proReplace[paramInt][4] = (short)((this.myMonsters[paramInt]).monsterPro[7] - s2);
      short s1 = (short)(arrayOfByte1[2] + arrayOfByte1[9] * b1 / 10);
      this.proReplace[paramInt][5] = (short)((this.myMonsters[paramInt]).monsterPro[5] - s1);
      arrayOfByte1 = (byte[])null;
      return;
    } 
    byte[] arrayOfByte = (this.myMonsters[paramInt]).monster;
    byte b = (byte)(arrayOfByte[2] + 1);
    arrayOfByte[2] = b;
    arrayOfByte = this.monster_pro[(this.myMonsters[paramInt]).monster[0]];
    (this.myMonsters[paramInt]).monsterPro[2] = (short)(arrayOfByte[0] + arrayOfByte[7] * b / 10);
    (this.myMonsters[paramInt]).monsterPro[3] = (short)(arrayOfByte[1] + arrayOfByte[8] * b / 10);
    (this.myMonsters[paramInt]).monsterPro[6] = (byte)(arrayOfByte[3] + arrayOfByte[10] * b / 10);
    (this.myMonsters[paramInt]).monsterPro[7] = (byte)(arrayOfByte[4] + arrayOfByte[11] * b / 10);
    (this.myMonsters[paramInt]).monsterPro[5] = (byte)(arrayOfByte[2] + arrayOfByte[9] * b / 10);
    this.myMonsters[paramInt].resetPro(this);
    arrayOfByte = (byte[])null;
    healMonster(this.myMonsters[paramInt]);
  }
  
  public void map_flashString() {
    int k = Constants_H.WIDTH__;
    int j = Constants_H.HEIGHT__;
    int i = Constants_H.HEIGHT__ / 2;
    setSay();
    if (this.say_c > 0 && run_state != 98) {
      if (!this.map.fontSizeControl) {
        Ms.i();
        Ms.font.setSize(22);
      } 
      StringBuffer[] arrayOfStringBuffer = this.showS;
      if (this.say_mode == 0) {
        i = i - (this.showS.length >> 1) * 25 - 12;
      } else {
        i = j - 50 - 18;
      } 
      showString(arrayOfStringBuffer, i, this.say_s, 1);
      if (this.say_s == 0) {
        this.say_c = (byte)(this.say_c - 1);
      } else {
        this.say_s = Ms.i().mathSpeedDown(this.say_s, 3, true);
      } 
    } else if (this.say_c < 0 && run_state != 98) {
      Ms.i();
      Ms.font.setSize(22);
      showString(this.showS, i - (this.showS.length >> 1) * 25 - 12, this.say_s, 2);
      if (this.say_s != 0)
        this.say_s = Ms.i().mathSpeedDown(this.say_s, 3, true); 
      if (this.pkey.isSelect(0, 0, k, j))
        this.pkey.setKey5(); 
    } 
    Ms.i();
    Ms.font.setSize(26);
  }
  
  public void paint_gameRun(Graphics paramGraphics) {
    String str;
    boolean bool;
    switch (run_state) {
      default:
        map_flashString();
        return;
      case -10:
        this.map.paint_map(paramGraphics);
      case -50:
        drawBattleBG();
        drawSelectMenu(paramGraphics, true, 252);
        if (this.src_c[2] == 0) {
          bool = true;
        } else {
          bool = false;
        } 
        drawSrcLine(paramGraphics, 15, 124, 10, false, bool);
        if (this.src_c[3] == 0) {
          bool = true;
        } else {
          bool = false;
        } 
        drawSrcLine(paramGraphics, 131, 124, 10, true, bool);
        drawPlayerAppear(paramGraphics);
      case -31:
        drawBattleBG();
        drawPlayer(paramGraphics);
        if (this.battle_state != 2) {
          bool = true;
        } else {
          bool = false;
        } 
        drawSelectMenu(paramGraphics, bool, 252);
        paintBattleState(paramGraphics);
      case -19:
        drawBattleBG();
        drawSelectMenu(paramGraphics, true, 252);
        drawMyMon();
        drawEnemy();
        if (this.cThrowY < 17) {
          this.cThrowS = (short)(this.cThrowS + this.cThrowY);
          this.cThrowY = Ms.i().mathSpeedN(this.cThrowY, 17, 2, false);
        } 
        this.cThrowX = Ms.i().mathSpeedN(this.cThrowX, 0, 8, false);
        Ui.i().drawImage(this.imgItem[0], 377 - this.cThrowX, this.cThrowS, 0x1 | 0x20);
      case -15:
        paintBATTLE_OVER();
      case 97:
        Ui.i().drawK0(-2, 0, 640 + 4, 33, 0);
        Ui.i().drawString("训练师等级：" + this.rmsOther[3], 320, 2, 17, 1, 2);
        drawPauseMenu(320 - 100 - 5, 45, 210, 235);
        Ui.i().drawK0(-2, 360 - 25 - 8, 640 + 4, 33, 0);
        gogoWordM(this.gogoString, 360 - 25 - 6, 16, 3, 0, 2);
        if (this.buyOk != 0) {
          str = "是否保存游戏?";
          if (this.buyOk == 2) {
            str = "是否读取进度?";
          } else if (this.buyOk == 3) {
            str = "之前未保存的部分将会丢失，是否继续？";
          } 
          showString(str, 60, 0);
        } 
        Ui.i().drawYesNo(true, true);
      case 61:
        mc.drawRectBG();
        showString("你要继续游戏，确定吗？", 360 - 50, 0);
        drawSelectMenu((Object[])this.action_str, 320 - 50, 180 - 50, 100, 2, 0, this.popMenu);
      case 60:
        mc.drawRectBG();
        showString("战斗失败了,训练师的梦想不能实现了!", 180, 0);
        Ui.i().drawYesNo(true, true);
      case 98:
        mc.drawRectBG();
        Ui.i().drawK1(-5, 360 - 75, 640 + 10, 75, 3);
        showStringM("游戏暂停，点击屏幕返回。", 320, 360 - 50 - 2, 9, 3);
      case -30:
        drawDarkScreen();
      case 100:
        this.b_c = 1;
        showString("保存游戏中", 20, 0);
      case 51:
        this.map.drawBlackSRC((Graphics)str, 30, true);
        drawZero("结束", 360 - 10);
      case 25:
        drawMY_BAG(0, 0, 640, 360);
      case 18:
        drawBUY_ITEM();
      case 68:
        drawLIST_INFO();
      case 67:
        drawMONSTER_INFO(getMonInfo_dir());
      case 35:
        if (this.cur_c == 0) {
          Monster[] arrayOfMonster;
          if (this.mini_state == 6) {
            arrayOfMonster = this.cMonsters;
          } else {
            arrayOfMonster = this.myMonsters;
          } 
          drawMONSTER_UI(arrayOfMonster);
        } else if (this.cur_c == 1) {
          Monster monster;
          if (this.mini_state == 6) {
            monster = this.cMonsters[this.selecty];
          } else {
            monster = this.myMonsters[this.selecty];
          } 
          drawMagicUI(monster);
        } else if (this.cur_c == 2) {
          drawEvolveUI(1, this.selecty, false);
        } 
      case 65:
        drawVIEW_COMPUTER();
      case 66:
        drawNidus(200, 225);
      case 69:
        Mg.i().paint();
      case -20:
        SMSSender.i(this).paint();
      case -21:
        break;
    } 
    SMSSender.i(this).paintLevel();
  }
  
  public void popState() {
    // Byte code:
    //   0: aload_0
    //   1: getfield buyOk : B
    //   4: ifne -> 39
    //   7: invokestatic i : ()Ldm/Ms;
    //   10: invokevirtual key_Up_Down : ()Z
    //   13: ifeq -> 39
    //   16: aload_0
    //   17: invokestatic i : ()Ldm/Ms;
    //   20: aload_0
    //   21: getfield popMenu : B
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield about_d : [Ljava/lang/StringBuffer;
    //   29: arraylength
    //   30: iconst_1
    //   31: isub
    //   32: invokevirtual select : (III)B
    //   35: putfield popMenu : B
    //   38: return
    //   39: invokestatic i : ()Ldm/Ms;
    //   42: invokevirtual key_S1_Num5 : ()Z
    //   45: ifeq -> 1194
    //   48: invokestatic i : ()Ldm/Ms;
    //   51: aload_0
    //   52: getfield about_d : [Ljava/lang/StringBuffer;
    //   55: aload_0
    //   56: getfield popMenu : B
    //   59: aaload
    //   60: ldc_w '技能'
    //   63: invokevirtual equals : (Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   66: ifne -> 90
    //   69: invokestatic i : ()Ldm/Ms;
    //   72: aload_0
    //   73: getfield about_d : [Ljava/lang/StringBuffer;
    //   76: aload_0
    //   77: getfield popMenu : B
    //   80: aaload
    //   81: ldc_w '天赋'
    //   84: invokevirtual equals : (Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   87: ifeq -> 262
    //   90: aload_0
    //   91: getfield mini_state : B
    //   94: bipush #6
    //   96: if_icmpne -> 190
    //   99: aload_0
    //   100: getfield cMonsters : [Ldm/Monster;
    //   103: aload_0
    //   104: getfield select : [[B
    //   107: iconst_0
    //   108: aaload
    //   109: iconst_0
    //   110: baload
    //   111: aaload
    //   112: astore_3
    //   113: aload_0
    //   114: aload_3
    //   115: invokevirtual initSkillList : (Ldm/Monster;)V
    //   118: aload_0
    //   119: getfield view_state : B
    //   122: ifle -> 229
    //   125: aload_0
    //   126: getfield mini_state : B
    //   129: bipush #6
    //   131: if_icmpne -> 207
    //   134: aload_0
    //   135: getfield cMonsters : [Ldm/Monster;
    //   138: aload_0
    //   139: getfield select : [[B
    //   142: iconst_0
    //   143: aaload
    //   144: iconst_0
    //   145: baload
    //   146: aaload
    //   147: getfield monster : [B
    //   150: iconst_3
    //   151: baload
    //   152: istore_1
    //   153: aload_0
    //   154: iload_1
    //   155: putfield bg_c : B
    //   158: invokestatic i : ()Ldm/Ms;
    //   161: aload_0
    //   162: getfield about_d : [Ljava/lang/StringBuffer;
    //   165: aload_0
    //   166: getfield popMenu : B
    //   169: aaload
    //   170: ldc_w '技能'
    //   173: invokevirtual equals : (Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   176: ifeq -> 257
    //   179: iconst_0
    //   180: istore_2
    //   181: aload_0
    //   182: iconst_1
    //   183: iload_2
    //   184: invokespecial restMove : (II)V
    //   187: goto -> 38
    //   190: aload_0
    //   191: getfield myMonsters : [Ldm/Monster;
    //   194: aload_0
    //   195: getfield select : [[B
    //   198: iconst_0
    //   199: aaload
    //   200: iconst_0
    //   201: baload
    //   202: aaload
    //   203: astore_3
    //   204: goto -> 113
    //   207: aload_0
    //   208: getfield myMonsters : [Ldm/Monster;
    //   211: aload_0
    //   212: getfield select : [[B
    //   215: iconst_0
    //   216: aaload
    //   217: iconst_0
    //   218: baload
    //   219: aaload
    //   220: getfield monster : [B
    //   223: iconst_3
    //   224: baload
    //   225: istore_1
    //   226: goto -> 153
    //   229: aload_0
    //   230: getfield view_state : B
    //   233: ifge -> 158
    //   236: aload_0
    //   237: getfield myB : Ldm/Battle;
    //   240: ifnull -> 158
    //   243: aload_0
    //   244: aload_0
    //   245: getfield myB : Ldm/Battle;
    //   248: getfield bg_id : B
    //   251: putfield bg_c : B
    //   254: goto -> 158
    //   257: iconst_1
    //   258: istore_2
    //   259: goto -> 181
    //   262: invokestatic i : ()Ldm/Ms;
    //   265: aload_0
    //   266: getfield about_d : [Ljava/lang/StringBuffer;
    //   269: aload_0
    //   270: getfield popMenu : B
    //   273: aaload
    //   274: ldc_w '参战'
    //   277: invokevirtual equals : (Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   280: ifeq -> 583
    //   283: aload_0
    //   284: getfield myMonsters : [Ldm/Monster;
    //   287: aload_0
    //   288: getfield select : [[B
    //   291: iconst_0
    //   292: aaload
    //   293: iconst_0
    //   294: baload
    //   295: aaload
    //   296: getfield monsterPro : [S
    //   299: iconst_0
    //   300: saload
    //   301: ifle -> 572
    //   304: aload_0
    //   305: getfield view_state : B
    //   308: ifge -> 340
    //   311: iconst_1
    //   312: istore_2
    //   313: iload_2
    //   314: aload_0
    //   315: getfield mon_in_battle : [B
    //   318: iconst_0
    //   319: baload
    //   320: if_icmple -> 482
    //   323: aload_0
    //   324: aload_0
    //   325: getfield myMonsters : [Ldm/Monster;
    //   328: aload_0
    //   329: getfield select : [[B
    //   332: iconst_0
    //   333: aaload
    //   334: iconst_0
    //   335: baload
    //   336: aaload
    //   337: invokevirtual initSkillList : (Ldm/Monster;)V
    //   340: aload_0
    //   341: aload_0
    //   342: getfield myMonsters : [Ldm/Monster;
    //   345: aload_0
    //   346: getfield select : [[B
    //   349: iconst_0
    //   350: aaload
    //   351: iconst_0
    //   352: baload
    //   353: aaload
    //   354: aload_0
    //   355: getfield myMonsters : [Ldm/Monster;
    //   358: iconst_0
    //   359: aaload
    //   360: invokespecial changeMonster : (Ldm/Monster;Ldm/Monster;)V
    //   363: aload_0
    //   364: iconst_2
    //   365: aload_0
    //   366: getfield mList_id : [[B
    //   369: aload_0
    //   370: getfield myMonsters : [Ldm/Monster;
    //   373: aload_0
    //   374: getfield select : [[B
    //   377: iconst_0
    //   378: aaload
    //   379: iconst_0
    //   380: baload
    //   381: aaload
    //   382: getfield monster : [B
    //   385: iconst_0
    //   386: baload
    //   387: aaload
    //   388: iconst_0
    //   389: baload
    //   390: iconst_1
    //   391: invokevirtual initMonStream : (III)V
    //   394: aload_0
    //   395: aload_0
    //   396: getfield myMonsters : [Ldm/Monster;
    //   399: aload_0
    //   400: getfield select : [[B
    //   403: iconst_0
    //   404: aaload
    //   405: iconst_0
    //   406: baload
    //   407: aaload
    //   408: invokespecial setShowPro : (Ldm/Monster;)V
    //   411: aload_0
    //   412: getfield view_state : B
    //   415: ifge -> 469
    //   418: aload_0
    //   419: invokespecial setMyThrow : ()V
    //   422: bipush #-50
    //   424: putstatic main/GameRun.run_state : I
    //   427: aload_0
    //   428: iconst_0
    //   429: putfield battle_state : B
    //   432: aload_0
    //   433: getfield view_state : B
    //   436: iconst_m1
    //   437: if_icmpne -> 456
    //   440: aload_0
    //   441: getfield myB : Ldm/Battle;
    //   444: iconst_1
    //   445: putfield act_num : B
    //   448: aload_0
    //   449: getfield enB : Ldm/Battle;
    //   452: iconst_1
    //   453: putfield act_num : B
    //   456: aload_0
    //   457: getfield myB : Ldm/Battle;
    //   460: iconst_0
    //   461: putfield dead : B
    //   464: aload_0
    //   465: iconst_0
    //   466: putfield first_battle : B
    //   469: aload_0
    //   470: iconst_0
    //   471: putfield lastSkill : B
    //   474: aload_0
    //   475: iconst_m1
    //   476: putfield popMenu : B
    //   479: goto -> 38
    //   482: aload_0
    //   483: getfield mon_in_battle : [B
    //   486: iload_2
    //   487: baload
    //   488: aload_0
    //   489: getfield myMonsters : [Ldm/Monster;
    //   492: aload_0
    //   493: getfield select : [[B
    //   496: iconst_0
    //   497: aaload
    //   498: iconst_0
    //   499: baload
    //   500: aaload
    //   501: getfield monster : [B
    //   504: iconst_1
    //   505: baload
    //   506: if_icmpeq -> 323
    //   509: iload_2
    //   510: aload_0
    //   511: getfield mon_in_battle : [B
    //   514: iconst_0
    //   515: baload
    //   516: if_icmpne -> 564
    //   519: aload_0
    //   520: getfield mon_in_battle : [B
    //   523: astore_3
    //   524: aload_0
    //   525: getfield mon_in_battle : [B
    //   528: astore #4
    //   530: aload #4
    //   532: iconst_0
    //   533: baload
    //   534: iconst_1
    //   535: iadd
    //   536: i2b
    //   537: istore_1
    //   538: aload #4
    //   540: iconst_0
    //   541: iload_1
    //   542: bastore
    //   543: aload_3
    //   544: iload_1
    //   545: aload_0
    //   546: getfield myMonsters : [Ldm/Monster;
    //   549: aload_0
    //   550: getfield select : [[B
    //   553: iconst_0
    //   554: aaload
    //   555: iconst_0
    //   556: baload
    //   557: aaload
    //   558: getfield monster : [B
    //   561: iconst_1
    //   562: baload
    //   563: bastore
    //   564: iload_2
    //   565: iconst_1
    //   566: iadd
    //   567: i2b
    //   568: istore_2
    //   569: goto -> 313
    //   572: aload_0
    //   573: ldc_w '当前宠物不能参战'
    //   576: iconst_0
    //   577: invokevirtual say : (Ljava/lang/String;I)V
    //   580: goto -> 474
    //   583: invokestatic i : ()Ldm/Ms;
    //   586: aload_0
    //   587: getfield about_d : [Ljava/lang/StringBuffer;
    //   590: aload_0
    //   591: getfield popMenu : B
    //   594: aaload
    //   595: ldc_w '进化'
    //   598: invokevirtual equals : (Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   601: ifeq -> 657
    //   604: aload_0
    //   605: aload_0
    //   606: getfield myMonsters : [Ldm/Monster;
    //   609: aload_0
    //   610: getfield select : [[B
    //   613: iconst_0
    //   614: aaload
    //   615: iconst_0
    //   616: baload
    //   617: aaload
    //   618: invokespecial setEvolveStringB : (Ldm/Monster;)V
    //   621: aload_0
    //   622: aload_0
    //   623: getfield myMonsters : [Ldm/Monster;
    //   626: aload_0
    //   627: getfield select : [[B
    //   630: iconst_0
    //   631: aaload
    //   632: iconst_0
    //   633: baload
    //   634: aaload
    //   635: getfield monster : [B
    //   638: iconst_3
    //   639: baload
    //   640: putfield bg_c : B
    //   643: aload_0
    //   644: iconst_0
    //   645: putfield b_c : B
    //   648: aload_0
    //   649: iconst_2
    //   650: iconst_0
    //   651: invokespecial restMove : (II)V
    //   654: goto -> 38
    //   657: invokestatic i : ()Ldm/Ms;
    //   660: aload_0
    //   661: getfield about_d : [Ljava/lang/StringBuffer;
    //   664: aload_0
    //   665: getfield popMenu : B
    //   668: aaload
    //   669: ldc_w '放生'
    //   672: invokevirtual equals : (Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   675: ifeq -> 847
    //   678: aload_0
    //   679: aload_0
    //   680: getfield select : [[B
    //   683: iconst_0
    //   684: aaload
    //   685: iconst_0
    //   686: baload
    //   687: invokespecial isMyMonsters : (I)Z
    //   690: ifne -> 704
    //   693: aload_0
    //   694: ldc_w '身上必须携带一只能参战的宠物！'
    //   697: iconst_0
    //   698: invokevirtual say : (Ljava/lang/String;I)V
    //   701: goto -> 38
    //   704: aload_0
    //   705: getfield buyOk : B
    //   708: iconst_1
    //   709: if_icmpne -> 832
    //   712: aload_0
    //   713: iconst_0
    //   714: putfield buyOk : B
    //   717: aload_0
    //   718: aload_0
    //   719: getfield select : [[B
    //   722: iconst_0
    //   723: aaload
    //   724: iconst_0
    //   725: baload
    //   726: invokevirtual delMonster : (I)B
    //   729: pop
    //   730: aload_0
    //   731: getfield select : [[B
    //   734: iconst_0
    //   735: aaload
    //   736: iconst_0
    //   737: baload
    //   738: aload_0
    //   739: getfield myMon_length : B
    //   742: if_icmpne -> 761
    //   745: aload_0
    //   746: getfield select : [[B
    //   749: iconst_0
    //   750: aaload
    //   751: astore_3
    //   752: aload_3
    //   753: iconst_0
    //   754: aload_3
    //   755: iconst_0
    //   756: baload
    //   757: iconst_1
    //   758: isub
    //   759: i2b
    //   760: bastore
    //   761: aload_0
    //   762: iconst_2
    //   763: aload_0
    //   764: getfield mList_id : [[B
    //   767: aload_0
    //   768: getfield myMonsters : [Ldm/Monster;
    //   771: aload_0
    //   772: getfield select : [[B
    //   775: iconst_0
    //   776: aaload
    //   777: iconst_0
    //   778: baload
    //   779: aaload
    //   780: getfield monster : [B
    //   783: iconst_0
    //   784: baload
    //   785: aaload
    //   786: iconst_0
    //   787: baload
    //   788: iconst_1
    //   789: invokevirtual initMonStream : (III)V
    //   792: aload_0
    //   793: aload_0
    //   794: getfield myMonsters : [Ldm/Monster;
    //   797: aload_0
    //   798: getfield select : [[B
    //   801: iconst_0
    //   802: aaload
    //   803: iconst_0
    //   804: baload
    //   805: aaload
    //   806: invokespecial setShowPro : (Ldm/Monster;)V
    //   809: aload_0
    //   810: getstatic main/Constants_H.WIDTH_H : I
    //   813: putfield introT : I
    //   816: aload_0
    //   817: aload_0
    //   818: getfield myMon_length : B
    //   821: putfield t_length : B
    //   824: aload_0
    //   825: iconst_m1
    //   826: putfield popMenu : B
    //   829: goto -> 38
    //   832: aload_0
    //   833: iconst_1
    //   834: putfield buyOk : B
    //   837: aload_0
    //   838: ldc_w '放生的宠物将会消失，是否继续？'
    //   841: putfield gogoString : Ljava/lang/String;
    //   844: goto -> 38
    //   847: invokestatic i : ()Ldm/Ms;
    //   850: aload_0
    //   851: getfield about_d : [Ljava/lang/StringBuffer;
    //   854: aload_0
    //   855: getfield popMenu : B
    //   858: aaload
    //   859: ldc_w '存放'
    //   862: invokevirtual equals : (Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   865: ifeq -> 900
    //   868: getstatic main/GameRun.run_state : I
    //   871: bipush #35
    //   873: if_icmpne -> 883
    //   876: aload_0
    //   877: invokespecial putMonster : ()V
    //   880: goto -> 38
    //   883: aload_0
    //   884: iconst_4
    //   885: putfield mini_state : B
    //   888: aload_0
    //   889: iconst_1
    //   890: putfield view_state : B
    //   893: aload_0
    //   894: invokevirtual goVIEW_MONSTER : ()V
    //   897: goto -> 38
    //   900: invokestatic i : ()Ldm/Ms;
    //   903: aload_0
    //   904: getfield about_d : [Ljava/lang/StringBuffer;
    //   907: aload_0
    //   908: getfield popMenu : B
    //   911: aaload
    //   912: ldc_w '取出'
    //   915: invokevirtual equals : (Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   918: ifeq -> 954
    //   921: getstatic main/GameRun.run_state : I
    //   924: bipush #35
    //   926: if_icmpne -> 936
    //   929: aload_0
    //   930: invokespecial takenMonster : ()V
    //   933: goto -> 38
    //   936: aload_0
    //   937: bipush #6
    //   939: putfield mini_state : B
    //   942: aload_0
    //   943: iconst_1
    //   944: putfield view_state : B
    //   947: aload_0
    //   948: invokevirtual goVIEW_MONSTER : ()V
    //   951: goto -> 38
    //   954: invokestatic i : ()Ldm/Ms;
    //   957: aload_0
    //   958: getfield about_d : [Ljava/lang/StringBuffer;
    //   961: aload_0
    //   962: getfield popMenu : B
    //   965: aaload
    //   966: ldc_w '卖宠'
    //   969: invokevirtual equals : (Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   972: ifeq -> 1165
    //   975: aload_0
    //   976: getfield buyOk : B
    //   979: iconst_1
    //   980: if_icmpne -> 1049
    //   983: aload_0
    //   984: iconst_0
    //   985: putfield buyOk : B
    //   988: aload_0
    //   989: aload_0
    //   990: getfield money : I
    //   993: aload_0
    //   994: getfield sell_money : I
    //   997: iadd
    //   998: putfield money : I
    //   1001: aload_0
    //   1002: new java/lang/StringBuilder
    //   1005: dup
    //   1006: ldc_w '获得金钱：'
    //   1009: invokespecial <init> : (Ljava/lang/String;)V
    //   1012: aload_0
    //   1013: getfield sell_money : I
    //   1016: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1019: invokevirtual toString : ()Ljava/lang/String;
    //   1022: iconst_0
    //   1023: invokevirtual say : (Ljava/lang/String;I)V
    //   1026: aload_0
    //   1027: getfield mini_state : B
    //   1030: bipush #6
    //   1032: if_icmpne -> 1042
    //   1035: aload_0
    //   1036: invokespecial setTakenMonster : ()V
    //   1039: goto -> 38
    //   1042: aload_0
    //   1043: invokespecial setPutMonster : ()V
    //   1046: goto -> 38
    //   1049: aload_0
    //   1050: getfield mini_state : B
    //   1053: iconst_4
    //   1054: if_icmpne -> 1083
    //   1057: aload_0
    //   1058: aload_0
    //   1059: getfield select : [[B
    //   1062: iconst_0
    //   1063: aaload
    //   1064: iconst_0
    //   1065: baload
    //   1066: invokespecial isMyMonsters : (I)Z
    //   1069: ifne -> 1083
    //   1072: aload_0
    //   1073: ldc_w '身上必须携带一只能参战的宠物！'
    //   1076: iconst_0
    //   1077: invokevirtual say : (Ljava/lang/String;I)V
    //   1080: goto -> 38
    //   1083: aload_0
    //   1084: iconst_1
    //   1085: putfield buyOk : B
    //   1088: aload_0
    //   1089: getfield mini_state : B
    //   1092: iconst_4
    //   1093: if_icmpne -> 1148
    //   1096: aload_0
    //   1097: getfield myMonsters : [Ldm/Monster;
    //   1100: aload_0
    //   1101: getfield select : [[B
    //   1104: iconst_0
    //   1105: aaload
    //   1106: iconst_0
    //   1107: baload
    //   1108: aaload
    //   1109: astore_3
    //   1110: aload_0
    //   1111: aload_3
    //   1112: invokespecial sellMonster : (Ldm/Monster;)V
    //   1115: aload_0
    //   1116: new java/lang/StringBuilder
    //   1119: dup
    //   1120: ldc_w '获得金钱：'
    //   1123: invokespecial <init> : (Ljava/lang/String;)V
    //   1126: aload_0
    //   1127: getfield sell_money : I
    //   1130: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1133: ldc_w '，是否卖出？'
    //   1136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: invokevirtual toString : ()Ljava/lang/String;
    //   1142: putfield gogoString : Ljava/lang/String;
    //   1145: goto -> 38
    //   1148: aload_0
    //   1149: getfield cMonsters : [Ldm/Monster;
    //   1152: aload_0
    //   1153: getfield select : [[B
    //   1156: iconst_0
    //   1157: aaload
    //   1158: iconst_0
    //   1159: baload
    //   1160: aaload
    //   1161: astore_3
    //   1162: goto -> 1110
    //   1165: invokestatic i : ()Ldm/Ms;
    //   1168: aload_0
    //   1169: getfield about_d : [Ljava/lang/StringBuffer;
    //   1172: aload_0
    //   1173: getfield popMenu : B
    //   1176: aaload
    //   1177: ldc_w '离开'
    //   1180: invokevirtual equals : (Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   1183: ifeq -> 38
    //   1186: aload_0
    //   1187: iconst_0
    //   1188: invokespecial goRUN_IN_MAP : (Z)V
    //   1191: goto -> 38
    //   1194: invokestatic i : ()Ldm/Ms;
    //   1197: invokevirtual key_S2 : ()Z
    //   1200: ifeq -> 38
    //   1203: aload_0
    //   1204: getfield buyOk : B
    //   1207: ifeq -> 1218
    //   1210: aload_0
    //   1211: iconst_0
    //   1212: putfield buyOk : B
    //   1215: goto -> 38
    //   1218: getstatic main/GameRun.run_state : I
    //   1221: bipush #65
    //   1223: if_icmpne -> 1234
    //   1226: aload_0
    //   1227: iconst_0
    //   1228: invokespecial goRUN_IN_MAP : (Z)V
    //   1231: goto -> 38
    //   1234: aload_0
    //   1235: iconst_m1
    //   1236: putfield popMenu : B
    //   1239: goto -> 38
  }
  
  public boolean runPauseIco() {
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= this.b_ico)
        return false; 
      if (this.map.my.state == 0 && this.pkey.isSelect(this.pkey.button_pos[10][b][0], this.pkey.button_pos[10][b][1], this.pkey.button_pos[10][b][2], this.pkey.button_pos[10][b][3])) {
        if (this.b_ico == 2) {
          this.isTalk = false;
          this.pkey.setKey5();
        } 
        this.pkey.initPointer();
        if (b == 0) {
          if (this.b_ico == 2) {
            b = 7;
          } else {
            b = 2;
          } 
          this.b_ico = (byte)b;
        } else if (run_state != 98) {
          if (b == 3) {
            goYouPAUSE(0);
          } else if (b == 6) {
            SMSSender.i(this).go(0, true);
          } else {
            if (b == 2) {
              Ms.key = 48;
            } else if (b == 4) {
              Ms.key = 49;
            } else if (b == 5) {
              Ms.key = 51;
            } else if (b == 1) {
              Ms.key = 57;
            } 
            Ms.keyRepeat = true;
          } 
          this.b_ico = 2;
        } 
        return true;
      } 
    } 
  }
  
  public void run_gameRun() {
    byte b;
    switch (run_state) {
      default:
        return;
      case -10:
        this.map.run_map();
      case -50:
        runMonsterAppear();
      case -31:
        runBattleState();
      case -19:
        if (this.cThrowX == 0 && this.b_c == 0) {
          byte b1 = this.items[this.selectx][this.select[0][0]][0];
          deleteItems(b1, 1);
          (new byte[3])[0] = 1;
          (new byte[3])[1] = 3;
          (new byte[3])[2] = 14;
          short s1 = (short)((new byte[3])[b1 - 9] * 30 + 50 - (this.enB.getMon()).monster[2] + 60 / (this.enB.getMon()).monster[2] - (this.enB.getMon()).monsterPro[0] * 100 / (this.enB.getMon()).monsterPro[2]);
          short s2 = (short)((7 - ((this.enB.getMon()).monster[5] - 1) * 2) * s1 / 10);
          s1 = s2;
          if (this.enB.getMon().isEffect(3))
            s1 = (short)(s2 + 30); 
          byte[] arrayOfByte = (byte[])null;
          if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
            say("所能携带的宠物已经达到上限！", -1);
            this.enB.act_num = 1;
            this.myB.act_num = 0;
            run_state = -31;
            this.battle_state = 9;
          } 
          Ms.i();
          if (Ms.getRandom(100) < s1) {
            this.enB.action = 2;
            this.enB.dead = 1;
            say("捕获" + getNameMon((this.enB.getMon()).monster[0]) + "已成功！", 0);
            if (getMonster(this.enB.getMon(), -1, false) == 0)
              (this.myMonsters[this.myMon_length - 1]).monster[1] = (byte)(this.myMon_length - 1); 
            run_state = -31;
            goBattleExp(false);
          } 
          this.b_c = 1;
          StringBuffer stringBuffer = new StringBuffer("没有捕获到" + getNameMon((this.enB.getMon()).monster[0]));
          if (this.myB.getMon().isMonReel(41) || this.enB.getMon().isEffect(4) || this.enB.getMon().isEffect(3)) {
            this.enB.act_num = 1;
            this.myB.act_num = 0;
            run_state = -31;
            this.battle_state = 9;
          } else {
            StringBuilder stringBuilder = (new StringBuilder("#n")).append(getNameMon((this.enB.getMon()).monster[0]));
            Ms.i();
            int i = Ms.getRandom(3);
            (new String[3])[0] = "流着泪逃跑了！";
            (new String[3])[1] = "拼了命的逃跑了！";
            (new String[3])[2] = "盯了你一眼，逃走了！";
            stringBuffer.append(stringBuilder.append((new String[3])[i]).toString());
            String[] arrayOfString = (String[])null;
          } 
          say(stringBuffer.toString(), 0);
        } 
        if (this.b_c == 1 && this.say_c == 0) {
          arangeMonster();
          setNullBattle();
          goGO_RUNINMAP();
        } 
      case -86:
      case -15:
        if (this.b_c == 0) {
          if (this.levelUp_in_battle[(this.myB.getMon()).monster[1]][0] == 1) {
            this.levelUp_in_battle[(this.myB.getMon()).monster[1]][0] = 0;
            this.b_c = 1;
            this.say_s = 52;
            levelPro(this.myB.now_id, true);
            setStringB("生命;+" + this.proReplace[this.myB.now_id][0] + "#n" + "能量" + ";+" + this.proReplace[this.myB.now_id][1], Constants_H.WIDTH, 0);
            setStringB("力量;+" + this.proReplace[this.myB.now_id][3] + "#n" + "防御" + ";+" + this.proReplace[this.myB.now_id][4] + "#n" + "敏捷" + ";+" + this.proReplace[this.myB.now_id][5], Constants_H.WIDTH, 1);
            initMonStream(2, this.mList_id[(this.myB.getMon()).monster[0]][0], 1);
          } else {
            Battle battle = this.myB;
            battle.now_id = (byte)(battle.now_id + 1);
          } 
          if (this.myB.now_id >= this.myMon_length) {
            byte b1 = 0;
            boolean bool = false;
            StringBuffer stringBuffer = new StringBuffer("");
            while (true) {
              if (b1 >= this.myMon_length) {
                if (bool)
                  stringBuffer.append("可以进化了"); 
                StringBuffer stringBuffer1 = new StringBuffer("");
                boolean bool2 = false;
                b1 = 0;
                while (true) {
                  if (b1 >= 5) {
                    if (bool2) {
                      stringBuffer1.append("经验已满，可以孵化了。");
                      if (!Ms.i().equals(stringBuffer, ""))
                        stringBuffer.append("#n"); 
                      stringBuffer.append(stringBuffer1.toString());
                    } 
                    if (!Ms.i().equals(stringBuffer, ""))
                      say(stringBuffer.toString(), -1); 
                    setNullBattle();
                    goGO_RUNINMAP();
                  } 
                  bool = bool2;
                  if (getRid(b1) != -2)
                    if (getNexp(b1, 1) != getNexp(b1, 3)) {
                      bool = bool2;
                    } else {
                      if (!Ms.i().equals(stringBuffer1, ""))
                        stringBuffer1.append("、"); 
                      stringBuffer1.append(this.monsterT[this.monster_pro[getNid(b1)][6]] + "的宠物蛋");
                      bool = true;
                    }  
                  b1 = (byte)(b1 + 1);
                  bool2 = bool;
                } 
                break;
              } 
              boolean bool1 = bool;
              if ((this.myMonsters[b1]).monster[5] > 0) {
                bool1 = bool;
                if (this.evolve[b1]) {
                  bool1 = bool;
                  if (isEvolveKind((this.myMonsters[b1]).monster[4], (this.myMonsters[b1]).monster[2]) == -1) {
                    if (!Ms.i().equals(stringBuffer, ""))
                      stringBuffer.append("、"); 
                    stringBuffer.append(getNameMon((this.myMonsters[b1]).monster[0]));
                    this.evolve[b1] = false;
                    bool1 = true;
                  } 
                } 
              } 
              b1 = (byte)(b1 + 1);
              bool = bool1;
            } 
          } 
        } 
        if (this.b_c == 1)
          this.say_s = Ms.i().mathSpeedDown(this.say_s, 4, true); 
      case -11:
        goRUN_IN_MAP(false);
      case -30:
        if (this.createOver == -1) {
          byte b1 = (byte)(this.b_c + 1);
          this.b_c = b1;
          if (b1 >= 8)
            goMontsterAppear(); 
        } 
      case 100:
        if (this.b_c == 1) {
          saveGame();
          say("游戏已保存。", 0);
          this.b_c = 0;
          goRUN_IN_MAP(true);
        } 
      case 35:
        b = (byte)(this.mon_action_c + 1);
        this.mon_action_c = b;
        if (b > 50) {
          this.mon_action_c = 0;
          this.mon_action = 1;
        } 
        if (this.cur_c == 2 && this.b_c == -1 && this.say_s == 0)
          goView(); 
      case 69:
        Mg.i().run();
      case -20:
        SMSSender.i(this).run();
      case -21:
        break;
    } 
    SMSSender.i(this).runLevel();
  }
  
  public void saveGame() {
    this.map.save();
    saveMon(0);
    saveMon(1);
    saveItem();
    saveInfoList();
    this.rmsOther[0] = this.map.mapNo;
    Ms.i().rmsOptions(10, this.rmsOther, 2);
    Ms.i().rmsOptions(3, this.rmsNidus, 2);
    Ms.i().rmsOptions(0, null, 4);
  }
  
  public void say(String paramString, int paramInt) {
    String str;
    Log.e("soars", paramString);
    if (paramString.equals("#7点击屏幕或用导航键#0控制上下左右移动。")) {
      str = "#7点击屏幕#0控制上下左右移动。";
    } else {
      str = paramString;
      if (paramString.contains("菜单键")) {
        paramString.replace("菜单键", "右下方工具按钮");
        str = paramString;
      } 
    } 
    this.sayStr.add(str);
    this.sayFlag.add(Integer.valueOf(paramInt));
    setSay();
  }
  
  public void say(String paramString, int paramInt1, int paramInt2) {
    this.showS = Ms.i().groupString(paramString, Constants_H.WIDTH - 50);
    this.say_s = Constants_H.WIDTH;
    this.say_mode = 0;
    if (paramInt1 == 0) {
      this.say_c = 15;
      return;
    } 
    if (paramInt1 == -1) {
      this.say_c = -1;
      this.sayOverSms = (byte)paramInt2;
      return;
    } 
    if (paramInt1 == 1) {
      this.say_c = 15;
      this.say_mode = 1;
    } 
  }
  
  public void setAimBattle(int paramInt) {
    Battle battle;
    this.mini_state = (byte)paramInt;
    if (this.mini_state == 1) {
      battle = this.myB;
    } else {
      battle = this.enB;
    } 
    this.am = battle;
    if (this.mini_state == 1) {
      battle = this.enB;
    } else {
      battle = this.myB;
    } 
    this.dm = battle;
  }
  
  public void setMagic(int paramInt) {
    int i = paramInt;
    if (paramInt > 5)
      i = 5; 
    initMagicStream(i);
    this.now_action_Magic[i] = 0;
    this.now_time_Magic[i] = 0;
  }
  
  public void setNull(boolean paramBoolean) {
    if (this.map != null)
      this.map.setNull(); 
    if (this.mon[0] != null)
      this.mon[0].nullIMFA(); 
    if (this.mon[1] != null)
      this.mon[1].nullIMFA(); 
    if (paramBoolean)
      data_null(); 
  }
  
  public void setSay() {
    if (this.say_c == 0 && this.sayStr.size() != 0) {
      String str = this.sayStr.remove(0);
      int i = ((Integer)this.sayFlag.remove(0)).intValue();
      this.showS = Ms.i().groupString(str, Constants_H.WIDTH - 50);
      this.say_s = Constants_H.WIDTH;
      this.say_mode = 0;
      if (i == 0) {
        this.say_c = 15;
        return;
      } 
      if (i == -1) {
        this.say_c = -1;
        return;
      } 
      if (i == 1) {
        this.say_c = 15;
        this.say_mode = 1;
      } 
    } 
  }
  
  public void skyCheckRegFull(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 1:
        this.map.setRegState(true);
        mc.skyNewGame();
      case 2:
        break;
    } 
    this.map.setRegState(true);
    mc.skyContinueGame();
  }
  
  public void start() {
    goRUN_IN_MAP(true);
    this.map.insertNpc();
    this.line_max = 2;
    this.cityName_c = 25;
    if (this.map.anole_temp != -2) {
      this.map.anole_type = this.map.anole_temp;
      this.map.anole_temp = -2;
      this.map.setAnole();
    } 
  }
  
  public void valueMend(Monster paramMonster) {
    if (paramMonster.monsterPro[0] < 0) {
      paramMonster.monsterPro[0] = 0;
    } else if (paramMonster.monsterPro[0] > paramMonster.monsterPro[2]) {
      paramMonster.monsterPro[0] = paramMonster.monsterPro[2];
    } 
    if (paramMonster.monsterPro[1] < 0) {
      paramMonster.monsterPro[1] = 0;
      return;
    } 
    if (paramMonster.monsterPro[1] > paramMonster.monsterPro[3])
      paramMonster.monsterPro[1] = paramMonster.monsterPro[3]; 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/main/GameRun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */