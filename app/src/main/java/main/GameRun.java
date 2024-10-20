package main;

import minigame.Mg;
import dm.Sound;
import android.util.Log;
import javax.microedition.lcdui.Graphics;
import com.nokia.mid.ui.DirectGraphics;
import dm.Ms;
import dm.Monster;
import com.PetKing5_480x800.PetKing5;
import dm.Ui;
import java.util.ArrayList;
import dm.Sprite;
import javax.microedition.lcdui.Image;
import dm.Battle;

public class GameRun extends GameRun_F
{
    public static boolean isSay;
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
    public ArrayList<Integer> sayFlag;
    public byte sayOverSms;
    public ArrayList<String> sayStr;
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
    
    static {
        GameRun.isSay = false;
    }
    
    public GameRun(final MainCanvas mc) {
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
        this.initFealty = new byte[] { 100, 120 };
        this.isChangeSound = Boolean.valueOf(false);
        this.sayStr = new ArrayList<String>();
        this.sayFlag = new ArrayList<Integer>();
        this.sayOverSms = -1;
        this.zb = new byte[] { -6, -4, -3, -2, -1, 0, 1, 2, 3, 4, 8, -3, 2, -1, 1, 1 };
        this.Shuxing = new byte[][] { { 2, 3 }, { 3, 4 }, { 4, 0 }, { 0, 1 }, { 1, 2 } };
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
        this.battleSay = new String[] { "\u654c\u4eba\u51fa\u73b0\u4e86\uff0c\u6218\u6597\u5427\uff01", "\u8003\u9a8c\u7684\u65f6\u523b\u6765\u4e86\uff0c\u8bad\u7ec3\u5e08\uff01", "\u5c3d\u60c5\u6355\u6349\u5ba0\u7269\u5427\uff01" };
        this.isUpdateList = false;
        this.first_battle = 0;
        this.lastSkill = 0;
        this.skill_list = new byte[9];
        this.b_ico = 2;
        GameRun.mc = mc;
        this.map = null;
        this.map = new Map(this);
        this.initOtherImage();
        Ui.i().initUiModules();
        this.loadRmsOther();
        this.loadRmsSms();
        SMSSender.i(this);
        PetKing5.gr = this;
    }
    
    private void AddHP(int n, final Monster monster) {
        n += monster.monsterPro[0];
        if (n >= monster.monsterPro[2]) {
            monster.monsterPro[0] = monster.monsterPro[2];
        }
        else {
            monster.monsterPro[0] = (short)n;
        }
    }
    
    private void AddMP(int n, final Monster monster) {
        n += monster.monsterPro[1];
        if (n > monster.monsterPro[3]) {
            monster.monsterPro[1] = monster.monsterPro[3];
        }
        else {
            monster.monsterPro[1] = (short)n;
        }
    }
    
    private void aiEnemy() {
        int n = 5;
        Ms.i();
        final byte b = (byte)Ms.getRandom(100);
        while (n > -1 && this.enB.getMon().monster[n + 8] == -1) {
            n = (byte)(n - 1);
        }
        final byte b2 = (byte)(n + 1);
        if (this.battle_type == 4) {
            switch (b2) {
                default: {
                    if (b < 45) {
                        this.enB.skill = (byte)(b2 - 1);
                        break;
                    }
                    if (b < 75) {
                        this.enB.skill = (byte)(b2 - 2);
                        break;
                    }
                    if (b < 95) {
                        this.enB.skill = (byte)(b2 - 3);
                        break;
                    }
                    this.enB.skill = (byte)(b2 - 4);
                    break;
                }
                case 1: {
                    this.enB.skill = 0;
                    break;
                }
                case 2: {
                    if (b < 65) {
                        this.enB.skill = 1;
                        break;
                    }
                    this.enB.skill = 0;
                    break;
                }
                case 3: {
                    if (b < 45) {
                        this.enB.skill = 2;
                        break;
                    }
                    if (b > 75) {
                        this.enB.skill = 1;
                        break;
                    }
                    this.enB.skill = 0;
                    break;
                }
            }
        }
        else {
            int i = 0;
            Ms.i();
            final byte b3 = (byte)Ms.getRandom(100);
            while (i < 2) {
                Label_0422: {
                    switch (this.enB.getMon().monster[i + 14]) {
                        case 27: {
                            if (this.isMonHp(this.enB.getMon(), 50) && b3 < 30) {
                                break Label_0422;
                            }
                            break;
                        }
                        case 28: {
                            if (this.isMonHp(this.enB.getMon(), 30) && b3 < 30) {
                                break Label_0422;
                            }
                            break;
                        }
                    }
                    i = (byte)(i + 1);
                    continue;
                }
                this.enB.skill = (byte)(i + 6);
                break;
            }
            if (i > 1) {
                switch (b2) {
                    default: {
                        if (b < 60) {
                            this.enB.skill = (byte)(b2 - 1);
                            break;
                        }
                        if (b < 85) {
                            this.enB.skill = (byte)(b2 - 2);
                            break;
                        }
                        if (b < 95) {
                            this.enB.skill = (byte)(b2 - 3);
                            break;
                        }
                        this.enB.skill = (byte)(b2 - 4);
                        break;
                    }
                    case 1: {
                        this.enB.skill = 0;
                        break;
                    }
                    case 2: {
                        if (b < 20) {
                            this.enB.skill = 0;
                            break;
                        }
                        this.enB.skill = 1;
                        break;
                    }
                    case 3: {
                        if (b < 5) {
                            this.enB.skill = 0;
                            break;
                        }
                        if (b > 40) {
                            this.enB.skill = 2;
                            break;
                        }
                        this.enB.skill = 1;
                        break;
                    }
                    case 4: {
                        if (b < 15) {
                            this.enB.skill = 1;
                            break;
                        }
                        if (b < 40) {
                            this.enB.skill = 2;
                            break;
                        }
                        this.enB.skill = 3;
                        break;
                    }
                }
            }
        }
        this.enB.skill = this.enB.getMon().monster[this.enB.skill + 8];
    }
    
    private void allAdd(final int n) {
        final int n2 = 0;
        final int n3 = 0;
        if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u65e0\u6cd5\u4f7f\u7528\uff01", 0);
        }
        else {
            int n4 = n2;
            if (this.myMonsters[this.select[0][0]].monsterPro[1] < this.myMonsters[this.select[0][0]].monsterPro[3]) {
                n4 = n2;
                if (this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
                    this.AddMP(this.myMonsters[this.select[0][0]].monsterPro[3] * n / 100, this.myMonsters[this.select[0][0]]);
                    n4 = 1;
                }
            }
            int n5 = n3;
            if (this.myMonsters[this.select[0][0]].monsterPro[0] < this.myMonsters[this.select[0][0]].monsterPro[2]) {
                n5 = n3;
                if (this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
                    this.AddHP(this.myMonsters[this.select[0][0]].monsterPro[2] * n / 100, this.myMonsters[this.select[0][0]]);
                    n5 = 1;
                }
            }
            if (n5 != 0 || n4 != 0) {
                this.useState(0, this.select_it[0]);
            }
            else if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
                this.AddHP(this.myMonsters[this.select[0][0]].monsterPro[2] * n / 100, this.myMonsters[this.select[0][0]]);
            }
            else {
                this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u4e0d\u9700\u8981\u4f7f\u7528\u8fd9\u4e2a\u9053\u5177", 0);
            }
        }
    }
    
    private void arangeMonster() {
        if (this.myMon_length > 1) {
            for (int i = 0; i < this.myMon_length - 1; i = (byte)(i + 1)) {
                for (byte b = (byte)(i + 1); b < this.myMon_length; ++b) {
                    if (this.myMonsters[i].monster[1] > this.myMonsters[b].monster[1]) {
                        this.changeMonster(this.myMonsters[i], this.myMonsters[b]);
                    }
                }
            }
        }
    }
    
    private boolean bufferAI(final Monster monster) {
        return !monster.isMonEffect(0);
    }
    
    private void changeEffect() {
        if (this.myMonsters[this.select[0][0]].effect != 7) {
            this.myMonsters[this.select[0][0]].effect = 7;
            this.useState(0, this.select_it[0]);
        }
        else {
            this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u6ca1\u6709\u5f02\u5e38\uff01", 0);
        }
    }
    
    private boolean changeMon(final Battle battle, final int n) {
        int n2 = 0;
        final byte now_id = battle.now_id;
        byte b;
        while (true) {
            if (++battle.now_id >= n) {
                battle.now_id = 0;
            }
            b = (byte)(n2 + 1);
            if (b > n) {
                break;
            }
            n2 = b;
            if (now_id == battle.now_id) {
                continue;
            }
            n2 = b;
            if (battle.getMon().monsterPro[0] >= 1) {
                break;
            }
        }
        if (b > n) {
            battle.now_id = now_id;
        }
        return b <= n;
    }
    
    private void changeMonster(final Monster monster, final Monster monster2) {
        final Monster monster3 = new Monster();
        monster3.monster = monster.monster;
        monster3.effect = monster.effect;
        monster3.monsterPro = monster.monsterPro;
        monster.monster = monster2.monster;
        monster.effect = monster2.effect;
        monster.monsterPro = monster2.monsterPro;
        monster2.monster = monster3.monster;
        monster2.effect = monster3.effect;
        monster2.monsterPro = monster3.monsterPro;
    }
    
    private boolean changeMy() {
        for (byte b = 1; b < this.myMon_length; ++b) {
            if (this.myMonsters[b].monsterPro[0] > 0) {
                this.setAimBattle(1);
                this.goVIEW_MONSTER();
                return true;
            }
        }
        return false;
    }
    
    private void dItemIn(final int n, int i) {
        while (i < this.itemsLength[n] - 1) {
            this.items[n][i] = this.items[n][i + 1];
            ++i;
        }
        final byte[] itemsLength = this.itemsLength;
        --itemsLength[n];
        this.items[n][this.itemsLength[n]] = null;
        this.items[n][this.itemsLength[n]] = new byte[2];
    }
    
    private void damage(final Battle battle, final Battle battle2, final Monster monster, final Monster monster2, int n, int n2) {
        final byte b = monster.monster[2];
        final byte b2 = monster2.monster[2];
        n2 = 0;
        final short n3 = monster.monsterPro[6];
        final short n4 = monster2.monsterPro[7];
        n = this.skill[n][0];
        final int n5 = b - b2;
        final int n6 = 100;
        final int n7 = n3 * n * (1000 - n4 * 5) / 10000;
        final int n8 = n4 / 10;
        final int n9 = b / (n * 2);
        final int n10 = (b - 1) / 10;
        if (n5 > 10) {
            n = 10;
        }
        else if ((n = n5) < -10) {
            n = -10;
        }
        final int n11 = (n * 4 + 100) * (n7 - n8 - n9 + 6 - n10) / 100;
        n = n2;
        if (monster2.effect == 0) {
            n = -30;
        }
        final int n12 = (battle.countS[1] + n + 100) * n11 / 100;
        final int n13 = 1;
        Label_0252: {
            Label_0242: {
                if (monster.isBuffRate(9)) {
                    Ms.i();
                    if (Ms.getRandom(100) < this.inhesion[9]) {
                        break Label_0242;
                    }
                }
                if (monster2.isMonReel(48)) {
                    Ms.i();
                    if (Ms.getRandom(100) < this.skill[48][0]) {
                        break Label_0242;
                    }
                }
                n2 = n13;
                n = n12;
                if (!monster.isBuffRate(10)) {
                    break Label_0252;
                }
                Ms.i();
                n2 = n13;
                n = n12;
                if (Ms.getRandom(100) < this.inhesion[10]) {
                    n = n12 * 15 / 10;
                    n2 = 2;
                }
                break Label_0252;
            }
            n = n12 >> 1;
            n2 = n13;
        }
        int n14 = n6;
        if (monster2.monster[3] == 1) {
            n14 = n6;
            if (monster2.isMonReel(33)) {
                n14 = this.skill[33][0];
            }
        }
        if ((n = n * n14 / 100) < 1) {
            n = 1;
        }
        battle2.addHit(n, n2, 0);
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
    
    private void delItemEvolve(final byte b) {
        int n = 2;
        do {
            this.deleteItems(this.monsterMake[b][n], this.monsterMake[b][n + 1]);
        } while ((n = (byte)(n + 2)) < this.monsterMake[b].length - 1);
    }
    
    private void delItemSkill(final Monster monster) {
        this.say(String.valueOf(this.getNameMon(monster.monster[0])) + "\u4e60\u5f97\u6280\u80fd\uff1a" + this.getNameSkill(this.getSkill), 0);
        this.goMY_BAG(2);
        this.deleteItems(this.getSkill + 35 - 25 - 1, 1);
        Ms.i().correctSelect(this.select[0], this.itemsLength[this.selectx], this.list_rows);
    }
    
    private void doBuffValue(final Battle battle) {
        if (battle.getMon().monsterPro[0] >= 1 && battle.getMon().isBuffRate(4)) {
            battle.addHit(-battle.getMon().monsterPro[2] * this.inhesion[4] / 100, 1, 1);
        }
    }
    
    private void doEffectValue(final Battle battle) {
        short n = 0;
        if (battle.getMon().isMonEffect(2)) {
            n = (short)(battle.getMon().monsterPro[0] / 10);
        }
        else if (battle.getMon().isMonEffect(5)) {
            n = (short)(battle.fs_level * battle.fs_level + 4);
        }
        short n2 = n;
        if (battle.getMon().isMonReel(3)) {
            n2 = (short)(this.inhesion[3] * n / 100 + n);
        }
        if (n2 != 0) {
            battle.addHit(n2, 1, 0);
        }
    }
    
    private void drawAnimationBattle(final Battle battle, int n) {
        if (battle.action == 0) {
            final int n2 = (byte)(battle.skill / 5);
            byte b = (byte)(battle.skill % 5);
            if ((n = n2) > 5) {
                n = 5;
            }
            if (n == 5) {
                b = (byte)(battle.skill - 25);
            }
            if (this.drawMagicC(n, n, b, this.getBXY((int)this.mini_state, (int)battle.skill, true), this.getBXY((int)this.mini_state, (int)battle.skill, false), this.mini_state ^ 0x1)) {
                if (this.mini_state == 1) {
                    final short[] monsterPro = battle.getMon().monsterPro;
                    monsterPro[1] -= (short)this.getSkillMana(battle.getMon(), battle.skill);
                    this.valueMend(battle.getMon());
                }
                this.runHit();
            }
        }
    }
    
    private void drawBG0(final int n, final int n2, final int n3, final int n4, final int n5) {
        Ui.i().fillRect(5422575, n2 - 1, 0, n5 + 13, 360 - 2);
        Ui.i().drawImage(this.imgBG[n], 320, 0, 17);
        Ui.i().drawK2(n2, n3, 640 - (n2 << 1), 360 - n3, 0);
        Ui.i().drawK1(n2 + 5, n3 + 25 + 7 + n4, n5, 360 - n3 - 36 - n4, 1);
        Ui.i().drawK(n2 + 7, 360 - 50 - 22, n5 - 4, 58, 3);
    }
    
    private void drawBUY_ITEM() {
        Ui.i().fillRectB();
        Ui.i().drawK2(1, 2, 640 - 2, 360 - 2, 0);
        byte b = 0;
        if (this.cur_b == 0) {
            Ui.i().drawK1(320 - 29, 6, 58, 28, 4);
            Ui.i().drawString(this.action_str[this.cur_a], 320, 5, 17, 0, 0);
        }
        else {
            Ui.i().drawK1(this.cur_a * 210 + 70, 6, 70, 28, 4);
            while (b < 3) {
                final Ui i = Ui.i();
                final String s = this.action_str[b];
                int n;
                if (this.cur_a == b) {
                    n = 0;
                }
                else {
                    n = 4;
                }
                i.drawString(s, b * 210 + 80, 5, 0, n, 0);
                ++b;
            }
            final byte selectMenuX = this.pkey.selectMenuX(3, 70, 0, 210, 62);
            if (selectMenuX != -1) {
                this.cur_a = selectMenuX;
                this.select[0][1] = (this.select[0][0] = 0);
            }
            Ui.i().drawTriangle(320, 15, 329, true, true);
        }
        Ui.i().drawK1(6, 37, 640 - 26, this.list_rows * 30 + 6, 1);
        Ui.i().drawK1(6, this.list_rows * 30 + 37 + 16, 640 - 12, 30 * 3, 2);
        int length;
        if (this.cur_b == 1) {
            length = this.itemsLength[this.cur_a];
        }
        else {
            length = this.buyItem[this.cur_a].length;
        }
        final byte b2 = (byte)length;
        final byte list_rows = this.list_rows;
        final byte[] array = this.select[0];
        final byte cur_a = this.cur_a;
        int n2;
        if (this.cur_b == 1) {
            n2 = 2;
        }
        else {
            n2 = 1;
        }
        this.drawItemList(10, 37 + 3, 640 - 26, list_rows, array, cur_a, b2, n2);
        Ui.i().sliding(640 - 15, 37 + 5, this.list_rows * 30 - 6, this.select[0][0], b2, true);
        byte b3 = b2;
        if (b2 > 0) {
            byte b4;
            if (this.cur_b == 1) {
                b4 = this.items[this.cur_a][this.select[0][0]][0];
            }
            else {
                b4 = this.buyItem[this.cur_a][this.select[0][0]];
            }
            if (this.item_help[b4].toString().contains("\u590d\u6d3b\u6b7b\u4ea1\u7684\u5ba0\u7269\u5e76\u4e3a\u5176\u56de\u590d\u751f\u547d\u503c\u7684")) {
                this.showStringM("\u590d\u6d3b\u6b7b\u4ea1\u7684\u5ba0\u7269\u5e76\u4e3a\u5176\u56de\u590d\u751f\u547d\u503c\u768430%,\u8bf7\u52ff\u5728\u5ba0\u7269\u6218\u6597\u4e2d\u8d2d\u4e70!", 320, this.list_rows * 30 + 37 + 18, 10, 3);
                b3 = b4;
            }
            else {
                this.showStringM(this.item_help[b4].toString(), 320, this.list_rows * 30 + 37 + 18, 10, 3);
                b3 = b4;
            }
        }
        this.drawMoney(320, 360 - 2, 0, this.cur_b != 1 && this.cur_a == 2);
        if (this.popMenu != -1) {
            if (this.buyOk == 1 && this.cur_b != 1 && this.buyItem[this.cur_a][this.select[0][0]] >= 35 && this.makeLevel[this.buyItem[this.cur_a][this.select[0][0]] - 35] > this.rmsOther[3]) {
                Ui.i().drawKuang(-5, 180 - 50, 640 + 10, 108);
                this.showStringM("\u9700\u8981\u8bad\u7ec3\u5e08" + this.makeLevel[this.buyItem[this.cur_a][this.select[0][0]] - 35] + "\u7ea7\u624d\u80fd\u5b66\u4e60\uff01", 320, 180 - 25, 12, 9);
                this.showString("\u662f\u5426\u8d2d\u4e70\uff1f", 180 + 25, 0);
            }
            else {
                int n3;
                if (this.cur_b == 1) {
                    n3 = 1;
                }
                else if (this.cur_a == 2) {
                    n3 = 16;
                }
                else {
                    n3 = 17;
                }
                this.drawBuy(b3, 320, 180, 150, 50, n3);
            }
            final byte selectMenuX2 = this.pkey.selectMenuX(2, 0, 0, 320, 360);
            if (selectMenuX2 != -1) {
                int key;
                if (selectMenuX2 == 0) {
                    key = -3;
                }
                else {
                    key = -4;
                }
                Ms.key = key;
                Ms.keyRepeat = true;
            }
        }
        Ui.i().drawYesNo(true, true);
    }
    
    private void drawBattleBG() {
        Ui.i().fillRectB();
        Ui.i().drawImage(this.imgBG[this.enB.bg_id], 200, 20, 0);
        final Ui i = Ui.i();
        final Image image = this.imgBG[this.myB.bg_id];
        final DirectGraphics dg = GameRun.dg;
        i.drawImage(image, 200, 144, 0, DirectGraphics.FLIP_HORIZONTAL);
        Ui.i().drawK2(2, 19, 195, 250, 0);
    }
    
    private void drawBattleExp(final Monster monster, final int n) {
        Ui.i().drawK0(200, n, 240, 10, 0);
        short cexp;
        if (this.battle_state != -5) {
            cexp = monster.monsterPro[4];
        }
        else {
            cexp = this.myB.cexp;
        }
        this.drawMonsterHp(monster, 240, n + 3, 195, 2, 2, cexp);
        Ui.i().drawString("\u7ecf\u9a8c", 200, n + 18, 36, 0, 2);
    }
    
    private void drawBuffList(final Monster monster, final int n, final int n2, final int n3, final int n4, int n5, final byte[] array) {
        byte b = 0;
        Ui.i().drawListKY(n5, n, n2, n3, 3, n4, 0, array[0] - array[1], 4, 2);
        while (b < 2) {
            if (b <= 0 || monster.monster[b + 16] >= 1) {
                Ui.i().drawUi(49, n + 8, n2 + 8 + (b - this.select[0][1]) * n4, 0, 0);
                final Ui i = Ui.i();
                final String nameBuff = this.getNameBuff(monster.monster[b + 16]);
                final byte b2 = this.select[0][1];
                if (array[0] == b) {
                    n5 = 0;
                }
                else {
                    n5 = 3;
                }
                i.drawString(nameBuff, n + 21, n2 + 1 + (b - b2) * n4, 0, n5, 0);
                if (this.pkey.isSelect(n, n2 + 1 + (b - array[1]) * n4, n3, n4)) {
                    array[0] = b;
                }
            }
            ++b;
        }
    }
    
    private void drawBuy(final int n, final int n2, final int n3, final int n4, int n5, final int n6) {
        Ui.i().drawKuang(n2 - n4, n3 - n5, n4 << 1, n5 << 1);
        int n7;
        if ((n6 & 0x10) != 0x0) {
            n7 = 2;
        }
        else {
            n7 = 12;
        }
        n5 = n3 - n5 + n7;
        Ui.i().drawString("\u6570\u91cf\uff1a" + this.popMenu + "/" + this.t_length, n2, n5, 17, 3, 0);
        final StringBuffer sb = new StringBuffer();
        if ((n6 & 0x10) != 0x0) {
            sb.append("\u9700\u8981\uff1a");
        }
        else {
            sb.append("\u83b7\u5f97\uff1a");
        }
        sb.append(this.sell_money * this.popMenu);
        if ((n6 & 0x1) != 0x0) {
            sb.append("\u91d1");
        }
        else {
            sb.append("\u5fbd\u7ae0");
        }
        Ui.i().drawString(sb.toString(), n2, n5 + 25 + 4, 17, 6, 0);
        if ((n6 & 0x10) != 0x0) {
            Ui.i().drawString("\u73b0\u6709\uff1a" + this.findItem(-2, n, true), n2, n5 + 58, 17, 3, 0);
        }
        Ui.i().drawTriangle1(n2, n3 - 2, n4, true, this.cur_b != 2);
        if (this.buyOk == 1) {
            final StringBuilder sb2 = new StringBuilder("\u662f\u5426");
            String str;
            if ((n6 & 0x10) != 0x0) {
                str = "\u8d2d\u4e70";
            }
            else {
                str = "\u5356\u51fa";
            }
            this.showString(sb2.append(str).append("\uff1f").toString(), Constants_H.HEIGHT_H + 25, 0);
        }
    }
    
    private void drawClipPic(final int n, final int n2, final int n3, final int n4, int n5, final int n6, final int n7, int i, final int n8) {
        final int n9 = 1;
        final byte b = (byte)(n5 / n7);
        Graphics g;
        int n10;
        Graphics g2;
        int n11;
        for (n5 = (short)(2 << i), i = n9; i < n7; i = (byte)(i + 1), n5 = (short)(n5 / 2)) {
            g = GameRun.g;
            if (b - n5 <= 0) {
                n10 = b;
            }
            else {
                n10 = n5;
            }
            g.clipRect(n3 - i * b, n4 - n6, n10, n6 + 20);
            this.drawCartoonOne(n2, n2, n * 3, n3, n4, true, n8);
            GameRun.g.setClip(0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
            g2 = GameRun.g;
            if (b - n5 <= 0) {
                n11 = b;
            }
            else {
                n11 = n5;
            }
            g2.clipRect((i - 1) * b + n3, n4 - n6, n11, n6 + 20);
            this.drawCartoonOne(n2, n2, n * 3, n3, n4, true, n8);
            GameRun.g.setClip(0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
        }
    }
    
    private void drawColorLine(final int n, final int n2, final int n3, int i, int n4, int j, final int n5, int n6, int color, int color2) {
        if ((0xFF000000 & color) != 0x0) {
            GameRun.g.setColor(color);
            GameRun.g.fillRect(n, n2, n3, i);
        }
        GameRun.g.setColor(color2);
        color = 1;
        color2 = 1;
        if (n6 == 1) {
            color = j;
            j = n2;
            n6 = color2;
            while (j < n2 + i) {
                GameRun.g.fillRect(n, j, n3, n4);
                color2 = j + n4 + n6;
                final int n7 = n4 - n5;
                j = color2;
                if ((n4 = n7) <= 0) {
                    --color;
                    if ((n4 = n6) < color) {
                        n4 = n6 + 1;
                    }
                    final int n8 = 1;
                    n6 = n4;
                    j = color2;
                    n4 = n8;
                }
            }
        }
        else if (n6 == 2) {
            i += n2;
            n6 = j;
            j = color;
            while (i > n2) {
                GameRun.g.fillRect(n, i - n4, n3, n4);
                color = i - n4 - j;
                color2 = n4 - n5;
                i = color;
                if ((n4 = color2) <= 0) {
                    --n6;
                    if ((i = j) < n6) {
                        i = j + 1;
                    }
                    n4 = 1;
                    j = i;
                    i = color;
                }
            }
        }
    }
    
    private void drawDarkScreen() {
        this.drawColorLine(0, 0, 640, 360, this.b_c + 1, 6, 1, 2, 16777215, 4802889);
    }
    
    private void drawEffectImage(final Monster monster, final int n, final int n2) {
        if (monster.effect > -1 && monster.effect < 7 && monster.effect_time > 0) {
            final Ui i = Ui.i();
            final Image image = this.effectImage[monster.effect];
            final Graphics g = GameRun.g;
            final Graphics g2 = GameRun.g;
            i.drawImage(image, n, n2, 0x8 | 0x20);
            final Ui j = Ui.i();
            final String string = new StringBuilder().append(monster.effect_time).toString();
            final Graphics g3 = GameRun.g;
            final Graphics g4 = GameRun.g;
            j.drawNum(string, n, n2, 0x8 | 0x20, 0);
        }
    }
    
    private void drawEnemy() {
        this.drawEffectImage(this.enB.getMon(), 435, 40);
        if (this.enB.getMon().monsterPro[0] >= 1 || this.enB.dead != 1) {
            final byte b = this.mList_id[this.enB.getMon().monster[0]][1];
            final byte action = this.enB.action;
            int n;
            if (this.enB.ceff[0] != 0) {
                n = 3;
            }
            else {
                n = 0;
            }
            int n2;
            if (this.enB.ceff[0] != 0) {
                n2 = -3;
            }
            else {
                n2 = 0;
            }
            if (this.drawCartoonOne(0, 0, b * 3 + action, n + 377, n2 + 97, this.enB.action == 0, 0)) {
                if (this.enB.getMon().monsterPro[0] < 1) {
                    this.enB.action = 2;
                    this.enB.dead = 1;
                }
                else if (this.enB.dead != 1) {
                    this.enB.action = 0;
                }
            }
            this.enB.ceff[0] = (byte)Ms.i().mathSpeedN(this.enB.ceff[0], 0, 1, true);
            this.drawMonsterHp(this.enB.getMon(), 352, 97, 50, 0, 1, this.enB.chp);
            final Battle enB = this.enB;
            final Ms i = Ms.i();
            final short chp = this.enB.chp;
            final short n3 = this.enB.getMon().monsterPro[0];
            int n4;
            if (this.enB.chp < this.enB.getMon().monsterPro[0]) {
                n4 = 20;
            }
            else {
                n4 = 6;
            }
            enB.chp = i.mathSpeedN(chp, n3, n4, true);
        }
    }
    
    private void drawEnemyState() {
        Ui.i().drawK(10, 25, 179, 110, 2);
        Ui.i().drawKuang(10 + 2, 25 + 2, 147, 33);
        if (this.enB.getMon().monster[3] != -1) {
            Ui.i().drawUi(this.enB.getMon().monster[3] + 5, 10 + 16, 25 + 16, 3, 0);
        }
        Ui.i().drawString(this.getNameMon(this.enB.getMon().monster[0]).toString(), 10 + 75 + 14, 25 + 1, 17, 4, 2);
        Ui.i().drawNum(String.valueOf(this.enB.getMon().monster[2]) + "\u7ea7", 10 + 125 + 27, 25 + 20, 0, 0);
        Ui.i().drawK0(10 + 2, 25 + 25 + 11, 62, 14, 4);
        Ui.i().drawUi(34, 10 + 4, 25 + 25 + 12, 0, 0);
        Ui.i().drawNum(String.valueOf(this.enB.countS[0] + 100) + "%", 10 + 60, 25 + 25 + 24, 1, 1);
        Ui.i().drawString("\u5ba0\u7269\u6863\u6b21", 10 + 2, 25 + 25 + 30, 20, 4, 2);
        this.drawMonKind(this.enB.getMon().monster[4], 10 + 100 + 8, 25 + 25 + 38, 0);
        final Ui i = Ui.i();
        String s;
        if (this.monInfoList[this.enB.getMon().monster[0]] == 2) {
            s = "\u5df2\u6355\u83b7";
        }
        else {
            s = "\u672a\u6355\u83b7";
        }
        i.drawString(s, 10 + 2, 25 + 50 + 32, 20, 4, 2);
        final Ui j = Ui.i();
        int n;
        if (this.monInfoList[this.enB.getMon().monster[0]] == 2) {
            n = 25;
        }
        else {
            n = 26;
        }
        j.drawUi(n, 10 + 100 + 4, 25 + 50 + 40, 0, 0);
    }
    
    private void drawEvolveMake(int item, final int n, final int n2, final int n3) {
        int n4 = 2;
        int n5 = 0;
        byte b;
        byte b2;
        do {
            Ui.i().drawString(String.valueOf(this.getNameItem(this.monsterMake[item][n4])) + "\uff08" + this.findItem(-2, this.monsterMake[item][n4], true) + "/" + this.monsterMake[item][n4 + 1] + "\uff09", n, n2 + n5 * n3, 0, 3, 0);
            b = (byte)(n4 + 2);
            b2 = (byte)(n5 + 1);
            n4 = b;
            n5 = b2;
        } while (b < this.monsterMake[item].length - 1);
        if (this.monsterMake[item][0] > 0) {
            item = this.findItem(-2, 34, true);
            if (item > 0) {
                Ui.i().drawString(String.valueOf(this.getNameItem(34)) + "\uff08" + item + "/" + 1 + "\uff09", n, n2 + b2 * n3, 0, -1, 0);
            }
        }
    }
    
    private boolean drawHitOne(final Battle battle, final Battle battle2, final int n, final int n2) {
        boolean b = true;
        this.strHit = "";
        for (int i = 0; i < battle.hit.length; i = (byte)(i + 1)) {
            if (battle.hit[i][4] < this.zb.length) {
                final boolean b2 = false;
                if (battle.hit[i][0] == -1) {
                    this.strHit = "\u95ea\u907f";
                }
                else if (battle.hit[i][0] == -2) {
                    this.strHit = "\u5fe0\u8bda\u5ea6\u51cf\u5c11";
                }
                else {
                    String obj;
                    if (battle.hit[i][1] > -1) {
                        obj = "-";
                    }
                    else {
                        obj = "+";
                    }
                    final StringBuilder sb = new StringBuilder(String.valueOf(obj));
                    Ms.i();
                    this.strHit = sb.append(Ms.abs((int)battle.hit[i][1])).toString();
                }
                if (battle.hit[i][0] > 0 && battle.hit[i][0] < 4) {
                    if (battle.hit[i][0] == 2) {
                        Ui.i().drawUi(32, battle.hit[i][2] + n + (this.strHit.length() >> 1) * 14 + 15, battle.hit[i][3] + n2 + 8, 40, 0);
                        Ui.i().drawUi(33, battle.hit[i][2] + n + (this.strHit.length() >> 1) * 14 + 15, battle.hit[i][3] + n2 + 8, 36, 0);
                    }
                    final Ui j = Ui.i();
                    final String strHit = this.strHit;
                    final short n3 = battle.hit[i][2];
                    final short n4 = battle.hit[i][3];
                    int n5;
                    if (battle.hit[i][0] == 2) {
                        n5 = 2;
                    }
                    else {
                        n5 = 1;
                    }
                    j.drawNum(strHit, n3 + n, n4 + n2, 0, n5);
                }
                else if (battle.hit[i][0] < 0 || battle.hit[i][0] == 4) {
                    final Ui k = Ui.i();
                    final String strHit2 = this.strHit;
                    final short n6 = battle.hit[i][2];
                    final short n7 = battle.hit[i][3];
                    int n8;
                    if (battle.hit[i][0] == 4) {
                        n8 = 1;
                    }
                    else {
                        n8 = 0;
                    }
                    k.drawString(strHit2, n6 + n, n7 + n2, 0, n8, 2);
                }
                if (i == 0) {
                    final short[] array = battle.hit[i];
                    final short n9 = array[2];
                    short n10;
                    if (this.mini_state == 1) {
                        n10 = 1;
                    }
                    else {
                        n10 = -1;
                    }
                    array[2] = (short)(n9 + n10);
                    final short[] array2 = battle.hit[i];
                    array2[3] += this.zb[battle.hit[i][4]];
                }
                else if (i == 1) {
                    final short[] array3 = battle.hit[i];
                    final short n11 = array3[2];
                    short n12;
                    if (this.mini_state == 1) {
                        n12 = 1;
                    }
                    else {
                        n12 = -1;
                    }
                    array3[2] = (short)(n11 + n12);
                    final short[] array4 = battle.hit[i];
                    array4[3] += this.zb[battle.hit[i][4]];
                }
                else if (i == 2) {
                    final short[] array5 = battle.hit[i];
                    array5[3] -= (short)(battle.hit[i][4] / 3);
                }
                final short[] array6 = battle.hit[i];
                final short n13 = (short)(array6[4] + 1);
                array6[4] = n13;
                b = b2;
                if (n13 == 1) {
                    if (battle.hit[i][0] == 4) {
                        final short[] monsterPro = battle.getMon().monsterPro;
                        monsterPro[1] -= battle.hit[i][1];
                        b = b2;
                    }
                    else if (battle.hit[i][0] == -2 && this.mini_state == 0 && !battle.getMon().isMonReel(40)) {
                        final byte[] monster = battle.getMon().monster;
                        monster[6] -= (byte)battle.hit[i][1];
                        this.getHitCoefficient(battle, battle.getMon(), battle2.getMon());
                        b = b2;
                    }
                    else {
                        b = b2;
                        if (battle.hit[i][0] > 0) {
                            final short[] monsterPro2 = battle.getMon().monsterPro;
                            monsterPro2[0] -= battle.hit[i][1];
                            b = b2;
                        }
                    }
                }
            }
        }
        this.valueMend(battle.getMon());
        return b;
    }
    
    private void drawInfoBG(final int n, final int n2) {
        Ui.i().fillRect(0, 0, 0, 640, n2);
        GameRun.g.fillRect(0, 360 - n2, 640, n2);
        GameRun.g.fillRect(0, n2 - 2, 640, n2);
        Ui.i().fillRect(15400191, 0, 2, 640, n2 - 4);
        GameRun.g.fillRect(0, 360 - n2 + 2, 640, n2 - 4);
        GameRun.g.fillRect(0, n2, 640, n2 - 4);
    }
    
    private void drawInfoList(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final byte[] array) {
        Ui.i().drawListKY(n5, n - 4, n2 + 5, n3, 4, n4 + 4, 2, array[0] - array[1], 4, 2);
        for (byte b = array[1]; b < array[1] + n5 && b < n6; ++b) {
            final Ui i = Ui.i();
            int n7;
            if (this.monInfoList[this.monInfo_dir[this.cur_a][b]] == 2) {
                n7 = 25;
            }
            else {
                n7 = 48;
            }
            final byte b2 = array[1];
            final Graphics g = GameRun.g;
            final Graphics g2 = GameRun.g;
            i.drawUi(n7, n - 10, (b - b2) * (n4 + 4 + 2) + n2 + 11, 0x8 | 0x10, 0);
            int n8;
            if (array[0] == b) {
                n8 = 0;
            }
            else if (this.monInfoList[this.monInfo_dir[this.cur_a][b]] != 0) {
                n8 = 3;
            }
            else {
                n8 = -1;
            }
            final byte b3 = (byte)n8;
            final Ui j = Ui.i();
            String obj;
            if (this.infoStart + b + 1 < 10) {
                obj = "0";
            }
            else {
                obj = "";
            }
            final StringBuilder append = new StringBuilder(String.valueOf(obj)).append(this.infoStart + b + 1).append(" ");
            String nameMon;
            if (this.monInfoList[this.monInfo_dir[this.cur_a][b]] != 0) {
                nameMon = this.getNameMon(this.monInfo_dir[this.cur_a][b]);
            }
            else {
                nameMon = "\u672a\u77e5\u5ba0\u7269";
            }
            j.drawString(append.append(nameMon).toString(), n + 10, (b - array[1]) * (n4 + 4 + 2) + n2 + 5, 0, b3, 0);
            final Ui k = Ui.i();
            final String infoType = this.getInfoType(this.monAppearMap[this.monInfo_dir[this.cur_a][b]][0]);
            final int width = Constants_H.WIDTH;
            final byte b4 = array[1];
            final Graphics g3 = GameRun.g;
            final Graphics g4 = GameRun.g;
            k.drawString(infoType, width - 25 - 15, (b - b4) * (n4 + 4 + 2) + n2 + 5, 0x8 | 0x10, b3, 0);
            if (this.pkey.isSelect(n, (b - array[1]) * (n4 + 4 + 2) + n2 + 5, n3, n4 + 4 + 2)) {
                if (array[0] == b) {
                    this.pkey.setKey5();
                }
                else {
                    array[0] = b;
                    if (b - array[1] == 0 && array[1] > 0) {
                        --array[1];
                    }
                    else if (b - array[1] == n5 - 1 && array[1] + n5 < n6) {
                        ++array[1];
                    }
                }
            }
        }
        Ui.i().sliding(n + n3 + 5, n2 + 10, (n4 + 4 + 2) * n5 - 4, array[0], n6, false);
    }
    
    private void drawItemList(final int n, final int n2, final int n3, final int n4, final byte[] array, final int n5, final int n6, final int n7) {
        byte b = array[1];
        Ui.i().drawListKY(n4, n - 4, n2, n3, 4, 30 + 1, -1, array[0] - array[1], 4, 2);
        while (b < array[1] + n4) {
            if (b < n6) {
                if (n7 == 0 || n7 == 2) {
                    this.drawItem(this.items[n5][b][0], n + 3, n2 + 4 + (b - array[1]) * 30, 0);
                    final Ui i = Ui.i();
                    final String nameItem = this.getNameItem(this.items[n5][b][0]);
                    final byte b2 = array[1];
                    int n8;
                    if (array[0] == b) {
                        n8 = 0;
                    }
                    else {
                        n8 = 3;
                    }
                    i.drawString(nameItem, n + 21, n2 + 1 + (b - b2) * 30, 0, n8, 0);
                    String s;
                    if (n7 == 2) {
                        s = this.getPrice(n5, this.items[n5][b][0], false) + "\u91d1";
                    }
                    else {
                        s = "x" + this.items[n5][b][1];
                    }
                    final Ui j = Ui.i();
                    final byte b3 = array[1];
                    final Graphics g = GameRun.g;
                    final Graphics g2 = GameRun.g;
                    int n9;
                    if (array[0] == b) {
                        n9 = 0;
                    }
                    else {
                        n9 = 3;
                    }
                    j.drawString(s, n + n3 - 12, n2 + 1 + (b - b3) * 30, 0x8 | 0x10, n9, 0);
                }
                else {
                    this.drawItem(this.buyItem[n5][b], n + 2, n2 + 4 + (b - array[1]) * 30, 0);
                    int n10;
                    if (array[0] == b) {
                        n10 = 0;
                    }
                    else {
                        n10 = 3;
                    }
                    final byte b4 = (byte)n10;
                    Ui.i().drawString(this.getNameItem(this.buyItem[n5][b]), n + 20, n2 + (b - array[1]) * 30, 0, b4, 0);
                    String str;
                    if (n5 == 2) {
                        str = "\u5fbd\u7ae0";
                    }
                    else {
                        str = "\u91d1";
                    }
                    final Ui k = Ui.i();
                    final String string = String.valueOf(this.getPrice(n5, b, true)) + str;
                    final byte b5 = array[1];
                    final Graphics g3 = GameRun.g;
                    final Graphics g4 = GameRun.g;
                    k.drawString(string, n + n3 - 12, (b - b5) * 30 + (n2 + 1), 0x8 | 0x10, b4, 0);
                }
                if (this.popMenu == -1 && this.say_c == 0 && this.pkey.isSelect(n, (b - array[1]) * 30 + n2, Constants_H.WIDTH, 30)) {
                    if (array[0] == b) {
                        this.pkey.setKey5();
                    }
                    else {
                        array[0] = b;
                        if (b - array[1] == 0 && array[1] > 0) {
                            --array[1];
                        }
                        else if (b - array[1] == n4 - 1 && array[1] + n4 < n6) {
                            ++array[1];
                        }
                        this.select_it[this.selectx] = array[0];
                        this.select_st[this.selectx] = array[1];
                    }
                }
            }
            ++b;
        }
    }
    
    private void drawLIST_INFO() {
        Ui.i().fillRectB();
        this.drawInfoBG(24, 35);
        final Ui i = Ui.i();
        final String string = "\u53d1\u73b0\u5ea6 " + Ms.i().getPrecision(this.monInfoList[102] * 1000 / 102) + "%";
        final Graphics g = GameRun.g;
        final Graphics g2 = GameRun.g;
        i.drawString(string, 640 - 12, 34, 0x8 | 0x10, 3, 1);
        Ui.i().drawString(this.monsterT[this.cur_a].toString(), 28, 34, 0, 1, 2);
        final Ui j = Ui.i();
        final String string2 = "\u6355\u6349\u79cd\u7c7b " + this.monInfoList[103] + "/" + 100;
        final Graphics g3 = GameRun.g;
        final Graphics g4 = GameRun.g;
        j.drawString(string2, 320, 360 + 1, 0x1 | 0x20, 3, 1);
        final byte selectMenuX = this.pkey.selectMenuX(5, 100, 0, 640 / 6, 35);
        if (selectMenuX != -1) {
            this.cur_a = selectMenuX;
            this.infoStart = 0;
            if (this.cur_a > 0) {
                for (byte b = 0; b < this.cur_a; ++b) {
                    this.infoStart += (byte)this.monInfo_dir[b].length;
                }
            }
            this.t_length = (byte)this.monInfo_dir[this.cur_a].length;
            this.select[0][0] = (this.select[0][1] = 0);
        }
        for (byte b2 = 0; b2 < 5; ++b2) {
            final Ui k = Ui.i();
            byte b3;
            if (this.cur_a == b2) {
                b3 = 5;
            }
            else {
                b3 = 0;
            }
            final int n = (b2 + 1) * 614 / 6;
            final Graphics g5 = GameRun.g;
            final Graphics g6 = GameRun.g;
            k.drawUi(b3 + b2, n + 18, 12, 0x4 | 0x2, 0);
        }
        this.drawInfoList(32, 67, 640 - 50, 29, this.list_rows, this.t_length, this.select[0]);
        Ui.i().drawTriangle(320 + 10, 12, 331, true, true);
        Ui.i().drawYesNo(this.monInfoList[this.getMonInfo_dir()] != 0, true);
    }
    
    private void drawMONSTER_INFO(final int n) {
        final int n2 = 320 - 140;
        final int n3 = n2 + 12;
        Ui.i().fillRectB();
        Ui.i().drawK2(n2, 2, 280, 360 - 2, 0);
        Ui.i().drawK1(320 - 29 * 4 - 4, 6, 29 * 8, 29, 4);
        Ui.i().drawK1(n3, 35, 100, 90, 1);
        Ui.i().drawK1(29 + 192 + 8, 35 + 90 + 4, 280 - (29 + 25), 29 * 4, 1);
        Ui.i().drawK1(n3, 35 + 90 + 4, 29, 29 * 4, 3);
        Ui.i().drawK1(n3, 360 - 13 - 29 * 3, 640 - (n3 << 1) + 2, 29 * 3 + 10, 2);
        Ui.i().drawYesNo(false, true);
        Ui.i().drawUi(this.cur_a + 5, n3 + 2, 35 + 2, 0, 0);
        Log.e("sk", "drawUi");
        final Ui i = Ui.i();
        final StringBuilder append = new StringBuilder(String.valueOf(this.getNameMon(n))).append("\uff08");
        String str;
        if (this.monInfoList[n] == 2) {
            str = "\u5df2\u6355\u83b7";
        }
        else {
            str = "\u672a\u6355\u83b7";
        }
        i.drawString(append.append(str).append("\uff09").toString(), 320, 6, 17, 0, 0);
        if (this.drawCartoonOne(1, 1, this.mList_id[n][1] * 3 + this.mon_action, n3 + 50, 35 + 90 - 10, this.mon_action != 1, 0)) {
            this.mon_action = 0;
        }
        Ui.i().drawString("\u53d1\u73b0\u5730\u70b9", 100 + 192 + 5, 35, 0, 1, 1);
        if (this.monAppearMap[n][0] > -1) {
            for (int j = 0; j < this.monAppearMap[n].length; j = (byte)(j + 1)) {
                Ui.i().drawString(this.city_name[this.monAppearMap[n][j]].toString(), 100 + 192 + 5, 35 + (j + 1) * 25, 0, 1, 0);
            }
        }
        else {
            Ui.i().drawString("\u672a\u77e5", 100 + 192 + 5, 35 + 25, 0, 1, 0);
        }
        Ui.i().drawString("\u8fdb", n3 + 12 + 2, 35 + 90 + 20, 17, 3, 1);
        Ui.i().drawString("\u5316", n3 + 12 + 2, 29 + 153, 17, 3, 1);
        Ui.i().drawListKY(3, 29 + 192 + 8, 35 + 90 + 10, 280 - (29 + 25), 3, 29 + 4, 0, -1, 4, 2);
        for (int k = 2, n4 = 0; k < 7; k = (byte)(k + 2), n4 = (byte)(n4 + 1)) {
            final Ui l = Ui.i();
            final StringBuilder sb = new StringBuilder("\u6750\u6599\uff1a");
            String string;
            if (this.monsterMake[n].length == 0 || k >= this.monsterMake[n].length) {
                string = "";
            }
            else {
                string = String.valueOf(this.getNameItem(this.monsterMake[n][k])) + " x" + this.monsterMake[n][k + 1];
            }
            l.drawString(sb.append(string).toString(), 29 + 192 + 14, n4 * 33 + 137, 0, 3, 0);
        }
        this.showStringM(this.getNameMonsterInfo(n), 320, 360 - 12 - 29 * 3, 10, 3);
        if (++this.mon_action_c > 50) {
            this.mon_action_c = 0;
            this.mon_action = 1;
        }
    }
    
    private void drawMONSTER_UI(final Monster[] array) {
        int n = 320 - 140;
        Ui.i().fillRectB();
        Ui.i().drawK2(n, 2, 280, 360 - 2, 0);
        n += 6;
        Ui.i().drawK1(n, 5 + 6, 118, 116, 1);
        if (this.t_length != 0) {
            this.drawMonsterHp(array[this.select[0][0]], n + 30, 5, 74, 2, 2, array[this.select[0][0]].monsterPro[4]);
            Ui.i().drawNum(String.valueOf(array[this.select[0][0]].monster[2]) + "\u7ea7", n + 2, 5 + 10, 0, 0);
            Ui.i().drawUi(array[this.select[0][0]].monster[3] + 5, n + 9, 5 + 11, 17, 0);
            if (this.drawCartoonOne(1, 1, this.mList_id[array[this.select[0][0]].monster[0]][1] * 3 + this.mon_action, 248, 111, this.mon_action != 1, 0)) {
                this.mon_action = 0;
            }
        }
        final int n2 = 5 + 138;
        final short n3 = (short)(640 - (n << 1));
        Ui.i().drawK1(n, n2, n3, 360 - 116 - 32, 1);
        Ui.i().drawK(n + 8, n2 + 10, n3 - 16, 33, 3);
        Ui.i().drawK(n + 8, n2 + 150 + 11, n3 - 16, 33, 3);
        if (this.t_length != 0) {
            this.gogoWord(this.getNameMonsterInfo((int)array[this.select[0][0]].monster[0]), n + 9, n2 + 150 + 13, n3 - 70, 0, 1, 2);
            this.drawMonsterFealty(array[this.select[0][0]], n + 2, n2 - 14);
            Ui.i().drawString(this.monsterT[array[this.select[0][0]].monster[3]].toString(), n + 25, n2 + 12, 0, 0, 1);
            if (array[this.select[0][0]].monster[5] == 0) {
                Ui.i().drawString("\u4e0d\u53ef\u8fdb\u5316", n + 115, n2 + 12, 0, 0, 1);
            }
            else {
                Ui.i().drawString("\u53ef\u8fdb\u5316" + array[this.select[0][0]].monster[5] + "\u6b21", n + 115, n2 + 12, 0, 0, 1);
            }
        }
        this.drawMonPro(array, n, n2);
        if (this.t_length != 0) {
            this.drawMonList(array, 280 + 180 - 75 - 15 + 2, 0 + 13, this.list_rows, this.t_length, this.select[0]);
        }
        Ui.i().sliding(280 + 180 - 17, 0 + 12, 116 + 6, this.select[0][0], this.t_length, true);
        final Ui i = Ui.i();
        final StringBuilder append = new StringBuilder(String.valueOf(this.t_length)).append("/");
        byte j;
        if (this.mini_state == 6) {
            j = this.max_monsters;
        }
        else {
            j = this.max_takes;
        }
        i.drawNum(append.append(j).toString(), 280 + 180 - 40, 0 + 12, 0, 0);
        if (this.popMenu != -1) {
            this.drawSelectMenu(this.about_d, 320 - 25, 30, 75, 2, 0, this.popMenu);
            if (this.buyOk == 1) {
                this.showString(this.gogoString, 180 - 25, 0);
            }
        }
        Ui.i().drawYesNo(this.t_length != 0, true);
    }
    
    private void drawMY_BAG(final int n, final int n2, final int n3, final int n4) {
        byte b = (byte)(this.action_str.length - 1);
        Ui.i().fillRectB();
        Ui.i().drawK2(n + 1, n2 + 3, n3 - 2, n4 - 3, 0);
        Ui.i().drawK1(n + 5, n2 + 25 + 14, n3 - 23, this.list_rows * 31, 1);
        Ui.i().drawK1(n + 5, n2 + 25 + 20 + this.list_rows * 31, n3 - 10, 90, 2);
        if (b == 0) {
            Ui.i().drawK1((n3 >> 1) + n - 25 - 9, n2 + 8, 66, 28, 4);
            Ui.i().drawString(this.action_str[b], (n3 >> 1) + n, n2 + 7, 17, 0, 0);
            Log.e("sk", "drawMY_BAG");
        }
        else {
            Ui.i().drawK1((this.selectx + 1) * n3 / 5 + n - 22, n2 + 8, 70, 28, 4);
            while (b > -1) {
                final Ui i = Ui.i();
                final String s = this.action_str[b];
                final int n5 = (b + 1) * n3 / 5;
                int n6;
                if (this.selectx == b) {
                    n6 = 0;
                }
                else {
                    n6 = 1;
                }
                i.drawString(s, n5 + n - 14, n2 + 7, 0, n6, 0);
                --b;
            }
            Ui.i().drawTriangle((n3 >> 1) + n, n2 + 14, 354, true, true);
            if (this.popMenu == -1) {
                final byte selectMenuX = this.pkey.selectMenuX(4, 0, 0, n3 / 4, 35);
                if (selectMenuX != -1) {
                    this.selectx = selectMenuX;
                    this.select[0][1] = this.select_st[this.selectx];
                    this.select[0][0] = this.select_it[this.selectx];
                }
            }
        }
        this.drawItemList(n + 9, n2 + 25 + 17, n3 - 23, this.list_rows, this.select[0], this.selectx, this.itemsLength[this.selectx], 0);
        Ui.i().sliding(n + n3 - 15, n2 + 25 + 17, this.list_rows * 31 - 6, this.select[0][0], this.itemsLength[this.selectx], true);
        if (this.itemsLength[this.selectx] > 0) {
            this.showStringM(this.item_help[this.items[this.selectx][this.select[0][0]][0]].toString(), n + (n3 >> 1), this.list_rows * 31 + (n2 + 25 + 22), 10, 3);
        }
        this.drawMoney((n3 >> 1) + n, n2 + n4 - 2, 0, this.selectx == 2);
        Ui.i().drawYesNo(this.itemsLength[this.selectx] != 0, true);
        if (this.popMenu != -1) {
            this.drawSelectMenu(this.about_a, (n3 >> 1) + n - 25 - 8, 50, 75, 2, 0, this.popMenu);
        }
    }
    
    private void drawMagicUI(final Monster monster) {
        Ui.i().fillRect(5422575, 0, 0, 640, 360);
        final int n = 1 + 180;
        this.drawBG0(this.bg_c, n, 108, 0, 267);
        if (this.pkey.selectMenuX(2, n, 108, 120, 29) != -1) {
            Ms.key = -3;
            Ms.keyRepeat = true;
        }
        final Ui i = Ui.i();
        int n2;
        if (this.popMenu == 0) {
            n2 = -143;
        }
        else {
            n2 = 21;
        }
        i.drawK1(320 + n2, 108 + 3, 123, 27, 4);
        final Ui j = Ui.i();
        final Graphics g = GameRun.g;
        final Graphics g2 = GameRun.g;
        int n3;
        if (this.popMenu == 0) {
            n3 = 0;
        }
        else {
            n3 = 1;
        }
        j.drawString("\u666e\u901a\u6280\u80fd", 320 - 25, 108 + 1, 0x8 | 0x10, n3, 0);
        final Ui k = Ui.i();
        int n4;
        if (this.popMenu == 0) {
            n4 = 1;
        }
        else {
            n4 = 0;
        }
        k.drawString("\u5929\u8d4b\u6280\u80fd", 320 + 25, 108 + 1, 0, n4, 0);
        if (this.drawCartoonOne(1, 1, this.mList_id[monster.monster[0]][1] * 3 + this.mon_action, 377 - this.move_x, 97 - this.move_y, this.mon_action != 1, 0)) {
            this.mon_action = 0;
        }
        this.move_x = Ms.i().mathSpeedDown(this.move_x, 3, false);
        this.move_y = Ms.i().mathSpeedDown(this.move_y, 3, false);
        if (this.popMenu == 0) {
            this.drawSkillList(n + 7, 108 + 25 + 12, 267 - 29, 31, 5, this.select[0]);
            if (this.skill_list[this.select[0][0]] != -1) {
                this.gogoWord(this.skill_help[this.skill_list[this.select[0][0]]].toString(), n + 10, 360 - 25 - 22, 200, 0, 1, 2);
            }
        }
        else {
            this.drawBuffList(monster, n + 7, 108 + 25 + 12, 267 - 29, 31, 5, this.select[0]);
            if (monster.monster[this.select[0][0] + 16] > 0) {
                this.showStringM(this.buff_help[monster.monster[this.select[0][0] + 16]].toString(), 320, 360 - 50 - 22, 9, 0);
            }
        }
        final Ui l = Ui.i();
        final byte b = this.select[0][0];
        int n5;
        if (this.popMenu == 0) {
            n5 = this.skill_list[8];
        }
        else if (monster.monster[this.select[0][0] + 16] > 0) {
            n5 = 2;
        }
        else {
            n5 = 1;
        }
        l.sliding(267 + 180 - 13, 108 + 25 + 13, 360 - 108 - 120, b, n5, true);
        if (this.mini_state != 13) {
            Ui.i().drawTriangle(320, 108 + 12, 150, true, true);
            Ui.i().drawYesNo(false, true);
        }
        else {
            Ui.i().drawYesNo(true, true);
        }
    }
    
    private void drawMonKind(final byte b, final int n, final int n2, final int n3) {
        for (byte b2 = 0; b2 < 5; ++b2) {
            final Ui i = Ui.i();
            int n4;
            if (b > b2) {
                n4 = 23;
            }
            else {
                n4 = 24;
            }
            i.drawUi(n4, b2 * 14 + n, n2, n3, 0);
        }
    }
    
    private void drawMonList(final Monster[] array, final int n, final int n2, final int n3, final int n4, final byte[] array2) {
        byte b2;
        final byte b = b2 = array2[1];
        if (this.mini_state != 6) {
            final Ui i = Ui.i();
            final Graphics g = GameRun.g;
            final Graphics g2 = GameRun.g;
            i.drawUi(34, n - 50 - 5, n2 + 2, 0x8 | 0x10, 0);
            b2 = b;
        }
        while (b2 < array2[1] + n3 && b2 < n4) {
            if (array2[0] == b2) {
                Ui.i().drawK(n - 50, (b2 - array2[1]) * 29 + n2, 108, 26, 1);
            }
            final Ui j = Ui.i();
            final String string = this.getNameMon(array[b2].monster[0]).toString();
            final byte b3 = array2[1];
            int n5;
            if (array2[0] == b2) {
                n5 = 0;
            }
            else {
                n5 = 1;
            }
            j.drawString(string, n + 4, n2 - 2 + (b2 - b3) * 29, 17, n5, 1);
            if (this.popMenu == -1 && this.pkey.isSelect(n - 50, (b2 - array2[1]) * 29 + n2, 100, 26)) {
                if (array2[0] == b2) {
                    Ms.key = 53;
                    Ms.keyRepeat = true;
                }
                else {
                    array2[0] = b2;
                    if (b2 - array2[1] == 0 && array2[1] > 0) {
                        --array2[1];
                    }
                    else if (b2 - array2[1] == n3 - 1 && array2[1] + n3 < n4) {
                        ++array2[1];
                    }
                    this.initMonStream(2, this.mList_id[array[array2[0]].monster[0]][0], 1);
                    this.setShowPro(array[array2[0]]);
                    this.introT = Constants_H.WIDTH_H;
                    this.introX = Constants_H.WIDTH_H;
                }
            }
            ++b2;
        }
    }
    
    private void drawMonPro(final Monster[] array, final int n, final int n2) {
        Ui.i().drawStringY(this.about_a, n + 18, n2 + 44, 0, 3, 31, 3, 0);
        Ui.i().drawStringY(this.about_b, n + 160, n2 + 44, 0, 3, 31, 3, 0);
        if (this.t_length != 0) {
            Ui.i().drawStringY(this.about_c, n + 165 + 50, n2 + 44, 0, 3, 31, -1, 0);
            this.drawMonsterHp(array[this.select[0][0]], n + 19 + 50 + 4, n2 + 59, 48, 0, 0, array[this.select[0][0]].monsterPro[0]);
            this.drawMonsterHp(array[this.select[0][0]], n + 19 + 50 + 4, n2 + 59 + 25 + 3, 48, 1, 0, array[this.select[0][0]].monsterPro[1]);
            this.drawMonKind(array[this.select[0][0]].monster[4], n + 19 + 50 + 4, n2 + 76 + 28, 0);
        }
    }
    
    private void drawMonsterFealty(final Monster monster, final int n, final int n2) {
        final byte b = monster.monster[4];
        final byte[] initFealty = this.initFealty;
        int n3;
        if (b < 4) {
            n3 = 0;
        }
        else {
            n3 = 1;
        }
        this.drawFealty(initFealty[n3] / 20, monster.monster[6] / 20, n, n2);
    }
    
    private void drawMonsterHp(final Monster monster, final int n, final int n2, final int n3, int n4, final int n5, int i) {
        short j;
        int n7;
        if (n4 < 2) {
            j = monster.monsterPro[n4 + 0];
            final int n6 = monster.monsterPro[n4 + 2];
            n7 = i;
            i = n6;
        }
        else {
            if ((n7 = i) == 0) {
                n7 = monster.monsterPro[4];
            }
            j = (short)n7;
            i = this.getMonsterExp(monster);
        }
        Ui.i().drawBarOne(n, n2, n3, Ms.i().mathPercent(n7, n3 - 2, i), Ms.i().mathPercent(j, n3 - 2, i), n4);
        if (n5 != 2) {
            final String string = String.valueOf(j) + "/" + i;
            final Ui k = Ui.i();
            i = string.length();
            if (n5 == 1) {
                n4 = 5;
            }
            else {
                n4 = 0;
            }
            k.drawNum(string, (n3 - i * 8 >> 1) + n, n4 + n2, 0, 0);
        }
    }
    
    private void drawMyMonState() {
        Ui.i().drawK(10, 140, 179, 110, 2);
        Ui.i().drawKuang(10 + 2, 140 + 2, 147, 33);
        Ui.i().drawUi(this.myB.getMon().monster[3] + 5, 10 + 16, 140 + 16, 3, 0);
        Ui.i().drawString(this.getNameMon(this.myB.getMon().monster[0]).toString(), 10 + 75 + 14, 140 + 1, 17, 4, 2);
        Ui.i().drawNum(String.valueOf(this.myB.getMon().monster[2]) + "\u7ea7", 10 + 125 + 27, 140 + 20, 0, 0);
        Ui.i().drawK0(10 + 2, 140 + 25 + 11, 62, 14, 4);
        Ui.i().drawUi(34, 10 + 4, 140 + 25 + 12, 0, 0);
        Ui.i().drawNum(String.valueOf(this.myB.countS[0] + 100) + "%", 10 + 60, 140 + 25 + 24, 1, 1);
        Ui.i().drawString("\u5ba0\u7269\u6863\u6b21", 10 + 2, 140 + 25 + 30, 20, 4, 2);
        this.drawMonKind(this.myB.getMon().monster[4], 10 + 100 + 8, 140 + 25 + 38, 0);
        Ui.i().drawString("\u5174\u594b\u5ea6", 10 + 2, 140 + 50 + 32, 20, 4, 2);
        this.drawMonsterFealty(this.myB.getMon(), 10 + 100 + 4, 140 + 50 + 42);
    }
    
    private void drawNidus(int selectMenuX, int n) {
        if (this.mini_state == 16) {
            this.drawSelectMenu(this.about_d, 320 - 75, 180 - (this.about_d.length >> 1) * 25, 150, 1, 0, this.popMenu);
        }
        else {
            Ui.i().fillRectB();
            this.drawBG0(this.bg_c, selectMenuX + 1, 108, 0, n);
            Log.e("sk", "drawNidus");
            Ui.i().drawString(String.valueOf(this.popMenu + 1) + "/" + 5, selectMenuX + 10, 106, 36, 0, 2);
            final Ui i = Ui.i();
            String string;
            if (this.getRid(this.popMenu) == -2) {
                string = "\u6b64\u4f4d\u7f6e\u76ee\u524d\u662f\u7a7a\u7684";
            }
            else {
                string = (Object)this.monsterT[this.monster_pro[this.getNid((int)this.popMenu)][6]] + "\u7684\u5ba0\u7269\u86cb";
            }
            i.drawString(string, selectMenuX + 20, 110, 0, 1, 0);
            if (this.getRid(this.popMenu) != -2) {
                if (this.b_c < 2 && this.drawCartoonOne(1, 1, this.mon_action, 377, 97, this.b_c != 1, 0)) {
                    this.initMonStream(2, this.mList_id[this.getNid((int)this.popMenu)][0], 1);
                    this.b_c = 2;
                }
                else if (this.b_c > 1 && this.b_c < 14) {
                    this.drawClipPic(this.mList_id[this.getNid((int)this.popMenu)][1], 1, 377, 97, 80, 77, 15, this.b_c - 2, 0);
                    if (++this.b_c == 14) {
                        this.b_c = -1;
                    }
                    this.mon_action = (byte)(this.mList_id[this.getNid((int)this.popMenu)][1] * 3);
                }
                if (this.b_c != -1) {
                    n = (short)(n - 40);
                    this.str_cur = String.valueOf(this.getNexp(this.popMenu, 1)) + "/" + this.getNexp(this.popMenu, 3);
                    Ui.i().drawBarOne(selectMenuX + 20, 158, n, Ms.i().mathPercent(this.getNexp(this.popMenu, 1), n - 2, this.getNexp(this.popMenu, 3)), Ms.i().mathPercent(this.getNexp(this.popMenu, 1), n - 2, this.getNexp(this.popMenu, 3)), 2);
                    Ui.i().drawNum(this.str_cur, selectMenuX + 20 + (n - this.str_cur.length() * 8 >> 1), 164, 0, 0);
                    final Ui j = Ui.i();
                    String s;
                    if (this.getNexp(this.popMenu, 1) == this.getNexp(this.popMenu, 3)) {
                        s = "\u5b75\u5316\u5df2\u5b8c\u6210";
                    }
                    else {
                        s = "\u5b75\u5316\u4e2d...";
                    }
                    j.drawString(s, selectMenuX + 20 + (n >> 1), 164, 17, 3, 1);
                    Ui.i().drawString("\u5b75\u5316\u6240\u9700\u6750\u6599", selectMenuX + 20 + (n >> 1), 208, 17, 3, 1);
                    this.drawEvolveMake(this.getNid(this.popMenu), selectMenuX + 25, 239, 28);
                }
                else {
                    Ui.i().drawStringY(this.about_a, selectMenuX + 26, 155, 0, 3, 30, 3, 0);
                    Ui.i().drawStringY(this.about_b, selectMenuX + 126, 155, 0, 3, 30, 3, 0);
                    Ui.i().drawString("\u6863\u6b21\uff1a", selectMenuX + 20 + 50, 258, 0, 3, 1);
                    this.drawMonKind(this.monster_pro[this.getNid((int)this.popMenu)][5], selectMenuX + 23 + 100 + 10, 263, 0);
                }
                if (this.getNexp(this.popMenu, 1) == this.getNexp(this.popMenu, 3)) {
                    Ui.i().drawString("\u6309\u786e\u5b9a\u952e\u5b8c\u6210\u5b75\u5316", selectMenuX + 20, 360 - 25 - 21, 0, 0, 0);
                }
            }
            if (this.b_c == -2) {
                Ui.i().drawTriangle(320, 120, 150, true, true);
            }
            Ui.i().drawYesNo(this.getRid(this.popMenu) != -2, this.b_c != -1);
            selectMenuX = this.pkey.selectMenuX(2, 0, 0, 320, 360);
            if (selectMenuX != -1) {
                if (selectMenuX == 0) {
                    selectMenuX = -3;
                }
                else {
                    selectMenuX = -4;
                }
                Ms.key = selectMenuX;
                Ms.keyRepeat = true;
            }
        }
    }
    
    private void drawPlayer(final Graphics graphics) {
        this.drawMyMon();
        this.drawMyMonState();
        this.drawEnemy();
        this.drawEnemyState();
    }
    
    private void drawPlayerAppear(final Graphics graphics) {
        switch (this.battle_state) {
            case 0: {
                if (this.battle_type > 2) {
                    if (this.src_c[2] == 0 && this.enB.throw_state == -1 && this.src_c[0] == 12) {
                        this.enB.throw_state = 0;
                    }
                    else if (this.enB.throw_state == 0 || this.enB.throw_state == 2) {
                        this.drawCartoonOne(0, 0, this.mList_id[this.enB.getMon().monster[0]][1] * 3 + this.enB.action, this.enemyOff + 377, 97, false, 0);
                        this.enemyOff = Ms.i().mathSpeedN(this.enemyOff, 0, 4, false);
                        if (this.enemyOff == 0) {
                            this.enB.throw_state = 2;
                        }
                    }
                }
                else if (this.battle_type < 2) {
                    this.drawThrowBall(this.enB, this.enB.getMon(), 0, 377, 97);
                }
                this.drawThrowBall(this.myB, this.myB.getMon(), 1, 266, 236);
                break;
            }
        }
    }
    
    private void drawSelectMenu(final Graphics graphics, final boolean b, int i) {
        Ui.i().drawK2(200, i + 15, 240, 360 - i - 20, 0);
        this.drawBattleExp(this.myB.getMon(), i + 3);
        if (!b) {
            Ui.i().drawString("\u8981\u505a\u4ec0\u4e48\uff1f", 450, 10, 0, 0, 2);
            for (i = 0; i < this.imgBattle.length; i = (byte)(i + 1)) {
                Ui.i().drawImage(this.imgBattle[i], this.pkey.button_pos[5][i][0], this.pkey.button_pos[5][i][1], 0);
            }
        }
    }
    
    private void drawSkillList(final int n, final int n2, final int n3, final int n4, final int n5, final byte[] array) {
        byte b = array[1];
        Ui.i().drawListKY(n5, n, n2, n3, 3, n4, 0, array[0] - array[1], 4, 2);
        while (b < array[1] + n5 && b < this.skill_list[8]) {
            final Ui i = Ui.i();
            int n6;
            if (this.skill_list[b] > 25) {
                n6 = 50;
            }
            else {
                n6 = 51;
            }
            i.drawUi(n6, n + 8, n2 + 8 + (b - array[1]) * n4, 0, 0);
            Log.e("sk", "\u666e\u901a\u653b\u51fb");
            final Ui j = Ui.i();
            final String string = this.getNameSkill(this.skill_list[b]).toString();
            final byte b2 = array[1];
            int n7;
            if (array[0] == b) {
                n7 = 0;
            }
            else {
                n7 = 3;
            }
            j.drawString(string, n + 21, n2 + 1 + (b - b2) * n4, 0, n7, 0);
            final Ui k = Ui.i();
            String string2;
            if (this.skill_list[b] <= 30) {
                string2 = String.valueOf(this.skill[this.skill_list[b]][1]) + "\u80fd\u91cf";
            }
            else {
                string2 = "\u88ab\u52a8";
            }
            final byte b3 = array[1];
            final Graphics g = GameRun.g;
            final Graphics g2 = GameRun.g;
            int n8;
            if (array[0] == b) {
                n8 = 0;
            }
            else {
                n8 = 3;
            }
            k.drawString(string2, n + n3 - 8, n2 + 1 + (b - b3) * n4, 0x8 | 0x10, n8, 0);
            if (this.say_c < 1 && this.pkey.isSelect(n, (b - array[1]) * n4 + n2, n3, n4)) {
                if (array[0] == b) {
                    this.pkey.setKey5();
                }
                else {
                    array[0] = b;
                    if (b - array[1] == 0 && array[1] > 0) {
                        --array[1];
                    }
                    else if (b - array[1] == n5 - 1 && array[1] + n5 < this.skill_list[8]) {
                        ++array[1];
                    }
                }
            }
            ++b;
        }
    }
    
    private void drawThrowBall(final Battle battle, final Monster monster, final int n, final int n2, final int n3) {
        if (battle.throw_state == 0) {
            final Ui i = Ui.i();
            final Image image = this.imgItem[0];
            final short n4 = battle.cThrow[0];
            final short n5 = battle.cThrow[1];
            final Graphics g = GameRun.g;
            final Graphics g2 = GameRun.g;
            i.drawImage(image, n4 + n2, n3 - n5, 0x1 | 0x20);
        }
        else if (battle.throw_state == 1) {
            this.drawClipPic(this.mList_id[monster.monster[0]][1], n, n2, n3, 80, 77, 15, battle.cThrow[2], n);
        }
        else if (battle.throw_state == 2) {
            this.drawCartoonOne(n, n, this.mList_id[monster.monster[0]][1] * 3, n2, n3, true, n);
        }
        this.runThrowBall(battle, monster, n);
    }
    
    private void drawVIEW_COMPUTER() {
        Ui.i().drawK2(320 - 25 * 2 - 8, 180 - 25 * 2 - 8, 25 * 4 + 16, 25 * 6 + 16, 0);
        this.drawSelectMenu(this.about_d, 320 - 25 - 4, 180 - 25, (25 + 4) * 2, 2, 0, this.popMenu);
        Ui.i().drawString("\u5bc4\u5b58\u5ba0\u7269", 320, 180 - 25 * 2 - 6, 17, 1, 1);
        Ui.i().drawYesNo(true, true);
    }
    
    private void effectR(final Monster monster) {
        if (monster.effect_time > 0) {
            --monster.effect_time;
        }
        if (monster.effect_time == 0) {
            monster.effect = 7;
        }
    }
    
    private void enemy_init() {
        final Monster[] array = new Monster[this.enemyList.length];
        for (int i = 0; i < this.enemyList.length; ++i) {
            final byte b = this.enemyList[i][0];
            final byte b2 = this.enemyList[i][1];
            boolean b3;
            if (this.myMonsters[0].isMonReel(39)) {
                b3 = true;
            }
            else {
                b3 = false;
            }
            array[i] = new Monster(this, b, b2, b3 ? 1 : 0);
            if (this.battle_type == 3 || this.battle_type == 0) {
                if (array[i].monster[3] == -1) {
                    array[i].resetBoss(this.enemyList[i][4]);
                }
                else {
                    array[i].resetMonster(this.enemyList[i][2], this.enemyList[i][3], this.enemyList[i][4]);
                }
                array[i].resetPro(this);
            }
            else {
                array[i].resetMonster(this, -1);
            }
        }
        this.enemyList = null;
        this.enB = new Battle(array);
    }
    
    private int getBXY(final int n, final int n2, final boolean b) {
        final int n3 = 266;
        final int n4 = 236;
        int n5 = 0;
        int n6 = 0;
        Label_0060: {
            if (n != 1 || this.isSkillToMe(n2)) {
                n5 = n3;
                n6 = n4;
                if (n != 0) {
                    break Label_0060;
                }
                n5 = n3;
                n6 = n4;
                if (!this.isSkillToMe(n2)) {
                    break Label_0060;
                }
            }
            n5 = 377;
            n6 = 97;
        }
        if (b) {
            n6 = n5;
        }
        return n6;
    }
    
    private void getBattleBG(final Battle battle, final Monster monster) {
        if (this.monPro.length != 0) {
            battle.bg_id = this.monPro[0];
        }
        for (byte bg_id = 0; bg_id < 5; ++bg_id) {
            if (monster.isMonReel(bg_id + 43)) {
                battle.bg_id = bg_id;
                break;
            }
        }
    }
    
    private int getBuyItemCount(int n, int n2, final boolean b) {
        if (b) {
            if (n == 2) {
                n = this.coin / this.sell_money;
            }
            else {
                n = this.money / this.sell_money;
            }
            if ((n2 = 99 - this.findItem(-2, this.buyItem[this.cur_a][n2], true)) < 0) {
                n2 = 0;
            }
            if (n > n2) {
                n = n2;
            }
        }
        else {
            n = this.items[this.cur_a][n2][1];
        }
        return n;
    }
    
    private void getExpOne(final boolean b) {
        int i = 0;
        this.exp = 0;
        Ms.i();
        Ms.skip2 = this.enB.mon[0].monster[2];
        while (i < this.enB.mon.length) {
            this.exp += (short)(this.enB.mon[i].monster[2] * 3 + 80);
            final byte b2 = this.enB.mon[i].monster[2];
            Ms.i();
            if (b2 > Ms.skip2) {
                Ms.i();
                Ms.skip2 = this.enB.mon[i].monster[2];
            }
            i = (byte)(i + 1);
        }
        this.exp = (short)(this.exp * (56 / this.mon_in_battle[0] - (this.mon_in_battle[0] - 1) * 2 + 44) / 100);
        if (!b) {
            this.exp /= 2;
        }
    }
    
    private void getHitCoefficient(final Battle battle, final Monster monster, final Monster monster2) {
        battle.countS[1] = 0;
        final byte b = (byte)(monster.monster[6] - 99);
        final byte[] countS = battle.countS;
        final byte b2 = countS[1];
        int n;
        if (b > 1) {
            n = 20;
        }
        else {
            n = b / 20 * 20;
        }
        countS[1] = (byte)(b2 + n);
        if (monster.monster[3] != -1 && battle.bg_id != monster.monster[3]) {
            final byte[] countS2 = battle.countS;
            final byte b3 = countS2[1];
            byte b4;
            if (battle.bg_id == monster.monster[3]) {
                b4 = 0;
            }
            else {
                b4 = -20;
            }
            countS2[1] = (byte)(b3 + b4);
        }
        final byte[] countS3 = battle.countS;
        countS3[1] += this.isShuXing(monster, monster2);
    }
    
    private String getInfoType(final int n) {
        String s;
        if (n == -1) {
            s = "\u4efb\u52a1";
        }
        else if (n == -2) {
            s = "\u8fdb\u5316";
        }
        else if (n == -3) {
            s = "\u5f02\u5316";
        }
        else if (n == -4) {
            s = "\u7ade\u6280\u573a";
        }
        else if (n == -5) {
            s = "\u5b75\u5316";
        }
        else {
            s = "\u6355\u83b7";
        }
        return s;
    }
    
    private byte getMonInfo_dir() {
        return this.monInfo_dir[this.cur_a][this.getSelInfo()];
    }
    
    private byte getMonster(final Monster monster, final int n, final boolean b) {
        if (this.monInfoList[monster.monster[0]] != 2) {
            this.monInfoList[monster.monster[0]] = 2;
            this.addMonInfoListBH();
            this.map.addAnole(monster.monster[0]);
        }
        byte b2;
        if (this.myMon_length < this.max_takes) {
            this.myMonsters[this.myMon_length] = monster;
            if (b) {
                this.myMonsters[this.myMon_length].resetMonster(this, n);
            }
            ++this.myMon_length;
            b2 = 0;
        }
        else if (this.cMon_count < this.max_monsters) {
            this.say("\u643a\u5e26\u5df2\u6ee1\uff0c" + this.getNameMon((int)monster.monster[0]) + "\u5df2\u8f6c\u5165\u5bc4\u653e\u5904", 0);
            this.cMonsters[this.cMon_count] = monster;
            if (b) {
                this.cMonsters[this.cMon_count].resetMonster(this, n);
            }
            ++this.cMon_count;
            b2 = 1;
        }
        else {
            b2 = -1;
        }
        return b2;
    }
    
    private short getMonsterExp(final Monster monster) {
        return (short)(monster.monster[2] * 210 / 10 - 2);
    }
    
    private String getNameBuff(final int n) {
        int n2 = n;
        if (n < 1) {
            n2 = 0;
        }
        return this.buff_name[n2].toString();
    }
    
    private String getNameSkill(final byte b) {
        return this.skill_name[b].toString();
    }
    
    private short getPrice(final int n, final int n2, final boolean b) {
        short n4;
        if (b) {
            short n3;
            if (n == 2) {
                n3 = this.buyPrice[1][n2];
            }
            else {
                n3 = this.buyPrice[0][this.buyItem[this.cur_a][n2]];
            }
            n4 = n3;
            if (this.view_state == -1) {
                n4 = (short)(n3 * 12 / 10);
            }
        }
        else {
            n4 = (short)(this.buyPrice[0][n2] / 5);
        }
        return n4;
    }
    
    private byte getSelInfo() {
        return this.select[0][0];
    }
    
    private void getSkill(final int n, final int n2) {
        byte getSkill;
        if (n == 0) {
            getSkill = 25;
        }
        else {
            getSkill = this.skill_up[n - 1][n2];
        }
        this.getSkill = getSkill;
    }
    
    private int getSkillLevel(int n) {
        if (n == 25) {
            n = 0;
        }
        else if (n < 25) {
            n = n % 5 + 1;
        }
        else {
            n = this.makeLevel[n - 25 - 1];
        }
        return n;
    }
    
    private int getSkillMana(final Monster monster, int n) {
        final byte b = this.skill[n][1];
        if (monster.monster[3] == 4 && monster.isMonReel(35)) {
            n = this.skill[n][0] * b / 100;
        }
        else {
            n = b;
        }
        return n;
    }
    
    private short getbuffRateV(final Monster monster, final int n) {
        int n2;
        if (monster.isBuffRate(2)) {
            n2 = n + this.inhesion[2] * n / 100;
        }
        else {
            n2 = n;
            if (monster.isBuffRate(1)) {
                n2 = n + this.inhesion[1] * n / 100;
            }
        }
        return (short)n2;
    }
    
    private void goBattleExp(final boolean b) {
        this.battle_state = -5;
        this.cur_c = 0;
        this.b_c = 0;
        this.myB.now_id = this.myMonsters[this.myB.now_id].monster[1];
        this.proReplace[this.myB.now_id][2] = -2;
        this.arangeMonster();
        this.getExpOne(b);
    }
    
    private void goBattleItem() {
        this.battle_state = -4;
        this.cur_b = -1;
        final StringBuffer sb = new StringBuffer();
        Ms.i();
        if (Ms.getRandom(100) < 50 && this.findItem(-2, 32, true) < 99) {
            this.addItem(32, 1);
            sb.append("\u83b7\u5f97\uff1a" + this.getNameItem(32) + "x1");
        }
        this.setStringB(sb.toString(), 10000, 0);
    }
    
    private void goBattleOver() {
        GameRun.run_state = -15;
        this.b_c = 0;
        this.myB.now_id = 0;
        this.mini_state = 3;
        this.view_state = 1;
        this.bg_c = this.myB.bg_id;
        this.mon[0].nullIMFA();
    }
    
    private void goBattleState() {
        this.setAction_str(new String[] { "\u653b\u51fb", "\u9053\u5177", "\u5ba0\u7269", "\u5546\u5e97", "\u9003\u8dd1" });
        GameRun.run_state = -31;
        byte battle_state;
        if (this.mini_state == 1) {
            battle_state = 2;
        }
        else {
            battle_state = 1;
        }
        this.battle_state = battle_state;
    }
    
    private void goCatchMonster() {
        GameRun.run_state = -19;
        this.cThrowX = 131;
        this.cThrowY = -20;
        this.cThrowS = 176;
        this.b_c = 0;
    }
    
    private void goGO_RUNINMAP() {
        this.b_c = 0;
        this.popMenu = -1;
        System.gc();
        GameRun.run_state = -11;
    }
    
    private void goLIST_INFO(final boolean b) {
        GameRun.run_state = 68;
        if (this.monInfo_dir == null) {
            final byte[] stream = Ms.i().getStream("data/book.d", -1);
            Ms.i();
            Ms.skip = 0;
            this.monInfo_dir = Ms.i().create2Array(stream);
            final byte[] array = (byte[])null;
        }
        if (b) {
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
    
    private void goMONSTER_INFO(final int n) {
        GameRun.run_state = 67;
        this.initMonStream(2, this.mList_id[n][0], 1);
    }
    
    private void goMY_BAG(final int n) {
        this.mini_state = 15;
        this.list_rows = 6;
        GameRun.run_state = 25;
        this.popMenu = -1;
        if (this.view_state == 1) {
            this.setAction_str(new String[] { "\u9053\u5177", "\u8f85\u52a9", "\u5377\u8f74", "\u5b75\u5316" });
        }
        else if (this.view_state == -1) {
            this.setAction_str(new String[] { "\u9053\u5177" });
        }
        else if (this.view_state == 2) {
            this.setAction_str(new String[] { "\u5b75\u5316" });
        }
        this.selectx = (byte)n;
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
        GameRun.run_state = -50;
        this.battle_state = 0;
        this.enemyOff = 63;
        this.setAimBattle(1);
    }
    
    private void goRUN_IN_MAP(final boolean b) {
        this.selecty = 0;
        this.selectx = 0;
        this.select[0][1] = 0;
        this.mini_state = 0;
        this.view_state = 0;
        GameRun.mc.game_state = 30;
        System.out.println("aaaaaaaaaaaaaaaaa");
        this.map.my.state = 0;
        if (!(boolean)this.isChangeSound) {
            Sound.i().setMusicId(this.musicNo[this.map.mapNo]);
            Sound.i().setMusic(b);
            Log.d("soars", "tttttttttttttttttttttt");
        }
        if ((boolean)this.isChangeSound) {
            Sound.i().setMusicId(this.musicNo[this.map.mapNo]);
            Sound.i().setMusicForMenu(b);
            Log.d("soars", "ffffffffffffffffffffffffffffffff");
        }
        GameRun.run_state = -10;
        this.createOver = 0;
        this.buyItemID = 0;
    }
    
    private void goSelectAction(final int aimBattle) {
        GameRun.run_state = -31;
        byte battle_state;
        if (aimBattle == 1) {
            battle_state = 2;
        }
        else {
            battle_state = 1;
        }
        this.battle_state = battle_state;
        this.setAimBattle(aimBattle);
        if (aimBattle == 1) {
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
    
    private void hit_rate(final Battle battle, final Battle battle2, final Monster monster, final Monster monster2, final int n) {
        battle.initHit();
        battle2.initHit();
        this.hit_rate = monster.monsterPro[5] - monster2.monsterPro[5];
        this.hit_rate = this.hit_rate / 2 + 92 + battle.rate_off;
        Ms.i();
        final byte b = (byte)Ms.getRandom(100);
        battle.rate_off = 0;
        if (n > 26 && n < 30) {
            switch (n) {
                case 27:
                case 28: {
                    battle.addHit(-this.skill[n][0] * 10, 1, 1);
                    break;
                }
                case 29: {
                    battle2.addHit(monster.monsterPro[6] * this.skill[n][0] + monster.monsterPro[1], 1, 0);
                    battle.addHit(monster.monsterPro[1], 4, 2);
                    break;
                }
            }
        }
        else if (b < this.hit_rate || (this.mini_state == 1 && monster.monster[2] < 11)) {
            this.damage(battle, battle2, monster, monster2, n, this.mini_state ^ 0x1);
            while (true) {
                Label_0335: {
                    if (n != 26 || battle2.getMon().isMonReel(40)) {
                        break Label_0335;
                    }
                    Ms.i();
                    if (Ms.getRandom(100) >= this.skill[n][2]) {
                        break Label_0335;
                    }
                    battle2.addHit(this.skill[n][3] * battle2.getMon().monster[6] / 100, -2, 2);
                    if (monster.monster[3] == 2 && monster.isMonReel(34)) {
                        battle2.addHit(monster2.monsterPro[3] * this.skill[34][0] / 100, 4, 2);
                        return;
                    }
                    return;
                }
                if (n < 25 || n == 30) {
                    this.magicEffectRate(battle2, monster, monster2, n);
                }
                continue;
            }
        }
        else {
            battle2.addHit(0, -1, 2);
            battle.rate_off = 20;
        }
    }
    
    private void hpAdd(final int n, final int n2) {
        if (this.myMonsters[this.select[0][0]].monsterPro[0] < this.myMonsters[this.select[0][0]].monsterPro[2] && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
            this.AddHP(n2 + this.myMonsters[this.select[0][0]].monsterPro[2] * n / 100, this.myMonsters[this.select[0][0]]);
            this.useState(0, this.select_it[0]);
        }
        else if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u65e0\u6cd5\u4f7f\u7528\uff01", 0);
        }
        else {
            this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u4e0d\u9700\u8981\u4f7f\u7528\u8fd9\u4e2a\u9053\u5177", 0);
        }
    }
    
    private void initMagicStream(final int i) {
        if (this.magic[i] == null) {
            this.magic[i] = Ms.i().createSprite("data/battle/s" + i, false);
        }
    }
    
    private void initOtherImage() {
        if (this.imgItem == null) {
            (this.imgItem = new Image[2])[0] = Ms.i().createImage("data/ball");
            this.imgItem[1] = Ms.i().createImage("data/ll");
            this.initItemModules();
        }
        if (this.imgBG == null) {
            this.imgBG = new Image[5];
            for (int i = 0; i < this.imgBG.length; i = (byte)(i + 1)) {
                this.imgBG[i] = Ms.i().createImage("data/battle/" + i);
            }
        }
        this.initImgIco();
    }
    
    private boolean isBagUse(final int n) {
        boolean b;
        if (this.view_state == -1) {
            b = (n != 14 && n != 15);
        }
        else {
            b = (n != 9 && n != 10 && n != 11 && n != 8);
        }
        return b;
    }
    
    private byte isEvolveKind(final byte b, final byte b2) {
        final byte b3 = -1;
        byte b4;
        if (b == 1 && b2 < 15) {
            b4 = -2;
        }
        else if (b == 2 && b2 < 25) {
            b4 = -3;
        }
        else {
            b4 = b3;
            if (b == 3) {
                b4 = b3;
                if (b2 < 30) {
                    b4 = -4;
                }
            }
        }
        return b4;
    }
    
    private byte isEvolveMake(final int n) {
        int n2 = 2;
        final byte b = this.monsterMake[n][0];
        while (this.findItem(-2, this.monsterMake[n][n2], true) >= this.monsterMake[n][n2 + 1]) {
            if ((n2 = (byte)(n2 + 2)) >= this.monsterMake[n].length - 1) {
                byte b2;
                if ((b2 = b) > 0) {
                    b2 = b;
                    if (this.findItem(-2, 34, true) < 1) {
                        b2 = 0;
                    }
                }
                return b2;
            }
        }
        return -1;
    }
    
    private boolean isMonHp(final Monster monster, final int n) {
        return monster.monsterPro[0] < monster.monster[2] * n / 100;
    }
    
    private boolean isMyMonsters(final int n) {
        for (byte b = 0; b < this.myMon_length; ++b) {
            if (b != n && this.myMonsters[b].monsterPro[0] > 0) {
                return true;
            }
        }
        return false;
    }
    
    private byte isShuXing(final Monster monster, final Monster monster2) {
        byte b;
        if (monster.monster[3] == -1) {
            b = 30;
        }
        else if (this.Shuxing[monster.monster[3]][0] == monster2.monster[3]) {
            b = 30;
        }
        else if (this.Shuxing[monster.monster[3]][1] == monster2.monster[3]) {
            b = 0;
        }
        else {
            b = 0;
        }
        return b;
    }
    
    private boolean isSkillToMe(final int n) {
        return n == 27 || n == 28;
    }
    
    private void keyBattleState() {
        if (!Ms.i().key_delay()) {
            switch (this.battle_state) {
                case 2: {
                    if (Ms.i().key_Left_Right()) {
                        this.cur_a = Ms.i().select(this.cur_a, 0, this.action_str.length - 1);
                        break;
                    }
                    if (!Ms.i().key_S1_Num5()) {
                        break;
                    }
                    if (this.cur_a == 0) {
                        if (this.myB.getMon().monster[6] == 0) {
                            this.say("\u5ba0\u7269\u5fe0\u8bda\u5ea6\u4e3a0\uff0c\u8bf7\u7acb\u523b\u8865\u5145\uff01", -1);
                            break;
                        }
                        this.battle_state = 3;
                        while (this.skill_list[this.lastSkill] > 30) {
                            ++this.lastSkill;
                        }
                        this.select[0][0] = this.lastSkill;
                        this.select[0][1] = (byte)(this.select[0][0] - 5);
                        if (this.select[0][1] < 1) {
                            this.select[0][1] = 0;
                            break;
                        }
                        break;
                    }
                    else if (this.cur_a == 1) {
                        if (this.myB.getMon().effect == 4) {
                            this.say("\u7981\u9522\u4e2d\u65e0\u6cd5\u4f7f\u7528\u9053\u5177\uff01", -1);
                            break;
                        }
                        this.goMY_BAG(0);
                        break;
                    }
                    else if (this.cur_a == 2) {
                        if (this.myB.getMon().effect == 4) {
                            this.say("\u7981\u9522\u4e2d\u65e0\u6cd5\u66f4\u6362\u5ba0\u7269\uff01", -1);
                            break;
                        }
                        this.view_state = -2;
                        this.goVIEW_MONSTER();
                        break;
                    }
                    else {
                        if (this.cur_a == 3) {
                            this.goBUY_ITEM(0, 0);
                            break;
                        }
                        if (this.cur_a != 4) {
                            break;
                        }
                        if (this.battle_type != 4) {
                            this.say("\u65e0\u6cd5\u9003\u8dd1\uff01", 0);
                            break;
                        }
                        final short n = (short)(this.myB.getMon().monster[2] - this.enB.getMon().monster[2] + 60);
                        int n2 = 0;
                        Ms.i();
                        if (Ms.getRandom(100) >= n) {
                            n2 = 1;
                        }
                        if (this.myB.getMon().isMonReel(42)) {
                            n2 = 0;
                        }
                        else if (this.myB.getMon().isEffect(3) || this.myB.getMon().isEffect(4)) {
                            n2 = 2;
                        }
                        if (n2 == 0) {
                            this.arangeMonster();
                            this.setNullBattle();
                            this.goGO_RUNINMAP();
                            break;
                        }
                        if (n2 == 1) {
                            this.say("\u9003\u8dd1\u5931\u8d25\uff01", 1);
                            this.myB.act_num = 0;
                            this.enB.act_num = 1;
                            this.battle_state = 9;
                            break;
                        }
                        final StringBuilder sb = new StringBuilder("\u88ab\u602a\u7269");
                        String str;
                        if (this.myB.getMon().isEffect(4)) {
                            str = "\u7981\u9522\u4e2d";
                        }
                        else {
                            str = "\u7684\u7535\u773c\u9b45\u60d1\u4e86";
                        }
                        this.say(sb.append(str).append("\uff0c").append("\u65e0\u6cd5\u9003\u8dd1\uff01").toString(), 1);
                        break;
                    }
                    break;
                }
                case 3: {
                    if (Ms.i().key_Up_Down()) {
                        Ms.i().selectS(this.select[0], 0, this.skill_list[8], 6);
                        this.lastSkill = this.select[0][0];
                        break;
                    }
                    if (Ms.i().key_S1_Num5()) {
                        if (this.skill_list[this.select[0][0]] > 30) {
                            this.say("\u88ab\u52a8\u6280\u80fd\u65e0\u6cd5\u4f7f\u7528!", -1);
                            break;
                        }
                        if (this.myB.getMon().effect == 6 && this.getSkillLevel(this.skill_list[this.select[0][0]]) > 3) {
                            this.say("\u5c01\u95ed\u6548\u679c\uff0c\u4e0d\u80fd\u4f7f\u75284\u7ea7\u4ee5\u4e0a\u6280\u80fd", -1);
                            break;
                        }
                        if (this.myB.getMon().monsterPro[1] >= this.getSkillMana(this.myB.getMon(), this.skill_list[this.select[0][0]])) {
                            this.myB.skill = this.skill_list[this.select[0][0]];
                            this.battle_state = 9;
                            break;
                        }
                        this.say("\u9700\u8981\u7684\u6280\u80fd\u503c\u4e0d\u591f\uff01", -1);
                        break;
                    }
                    else {
                        if (Ms.i().key_S2()) {
                            this.battle_state = 2;
                            break;
                        }
                        break;
                    }
                    break;
                }
                case 5: {
                    if (Ms.i().key_Up_Down()) {
                        Ms.i().selectS(this.select[0], 0, 6, this.skill_list[8]);
                        break;
                    }
                    if (!Ms.i().key_S1_Num5() && Ms.i().key_S2()) {
                        this.battle_state = 2;
                        break;
                    }
                    break;
                }
                case 4: {
                    if (Ms.i().key_Up_Down()) {
                        Ms.i().selectS(this.select[0], 0, 6, this.skill_list[8]);
                        break;
                    }
                    if (!Ms.i().key_S1_Num5() && Ms.i().key_S2()) {
                        this.battle_state = 2;
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    private void keyBuyItem() {
        if (!Ms.i().key_delay()) {
            if (this.popMenu == -1) {
                if (Ms.i().key_Left_Right() && this.cur_b != 0) {
                    this.cur_a = Ms.i().select(this.cur_a, 0, 2);
                    this.select[0][1] = (this.select[0][0] = 0);
                }
                else if (Ms.i().key_Up_Down()) {
                    final Ms i = Ms.i();
                    final byte[] array = this.select[0];
                    int length;
                    if (this.cur_b == 1) {
                        length = this.itemsLength[this.cur_a];
                    }
                    else {
                        length = this.buyItem[this.cur_a].length;
                    }
                    i.selectS(array, 0, length, this.list_rows);
                }
                else if (Ms.i().key_S1_Num5()) {
                    this.popMenu = 1;
                    final byte cur_a = this.cur_a;
                    byte b;
                    if (this.cur_b != 1) {
                        b = this.select[0][0];
                    }
                    else {
                        b = this.items[this.cur_a][this.select[0][0]][0];
                    }
                    this.sell_money = this.getPrice(cur_a, b, this.cur_b != 1);
                    this.t_length = (byte)this.getBuyItemCount(this.cur_a, this.select[0][0], this.cur_b != 1);
                }
                else if (Ms.i().key_S2()) {
                    this.buyItem = null;
                    this.buyPrice = null;
                    if (this.view_state == -1) {
                        this.goBattleState();
                    }
                    else {
                        this.goGO_RUNINMAP();
                    }
                }
            }
            else if (this.buyOk == 0 && Ms.i().key_Left_Right()) {
                this.popMenu = Ms.i().select(this.popMenu, 1, this.t_length);
            }
            else if (Ms.i().key_S1_Num5()) {
                if (this.buyOk == 1) {
                    if (this.cur_b == 1) {
                        this.money += this.sell_money * this.popMenu;
                        this.deleteItems(this.items[this.cur_a][this.select[0][0]][0], this.popMenu);
                        if (this.select[0][0] >= this.itemsLength[this.cur_a]) {
                            final byte[] array2 = this.select[0];
                            if (--array2[0] < 0) {
                                this.select[0][0] = 0;
                            }
                            final byte[] array3 = this.select[0];
                            if (--array3[1] < 0) {
                                this.select[0][1] = 0;
                            }
                        }
                        this.say("\u83b7\u5f97\u91d1\u94b1\uff1a" + this.sell_money * this.popMenu, 0);
                    }
                    else if (this.isMoneyItem(this.cur_a, this.buyItem[this.cur_a][this.select[0][0]], this.popMenu, this.cur_a != 2) && this.addItem(this.buyItem[this.cur_a][this.select[0][0]], this.popMenu) != -1) {
                        this.say("\u8d2d\u4e70\u6210\u529f", 0);
                    }
                    this.buyOk = 0;
                    this.popMenu = -1;
                }
                else {
                    this.buyOk = 1;
                }
            }
            else if (Ms.i().key_S2()) {
                if (this.buyOk == 0) {
                    this.popMenu = -1;
                }
                else {
                    this.buyOk = 0;
                }
            }
        }
    }
    
    private void keyEvolveUI() {
        if (Ms.i().key_S1_Num5() && this.b_c == 0) {
            final byte b = this.myMonsters[this.selecty].monster[4];
            final byte b2 = this.myMonsters[this.selecty].monster[2];
            final byte b3 = this.myMonsters[this.selecty].monster[0];
            byte b4 = this.isEvolveMake(b3);
            if (this.isEvolveKind(b, b2) != -1) {
                b4 = this.isEvolveKind(b, b2);
            }
            if (b4 == 0) {
                this.myMonsters[this.selecty].evolveMonster(this, this.monsterMake[b3][1], 1);
            }
            else if (b4 > 0) {
                this.myMonsters[this.selecty].evolveMonster(this, this.monsterMake[b3][0], this.myMonsters[this.selecty].monster[5]);
            }
            else if (b4 == -1) {
                this.say("\u6750\u6599\u4e0d\u8db3\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01", 0);
                this.popMenu = 1;
            }
            else if (b4 == -2) {
                this.say("\u7b49\u7ea7\u6ca1\u6709\u8fbe\u523015\u7ea7\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01", 0);
            }
            else if (b4 == -3) {
                this.say("\u7b49\u7ea7\u6ca1\u6709\u8fbe\u523025\u7ea7\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01", 0);
            }
            else {
                this.say("\u7b49\u7ea7\u6ca1\u6709\u8fbe\u523030\u7ea7\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01", 0);
            }
            if (b4 > -1) {
                this.b_c = 1;
                this.setMagic(6);
                this.setShowPro(this.myMonsters[this.selecty]);
                this.popMenu = 0;
                this.delItemEvolve(b3);
                if (b4 > 0) {
                    this.deleteItems(34, 1);
                }
            }
        }
        else if (Ms.i().key_S2()) {
            this.goView();
            this.setShowPro(this.myMonsters[this.selecty]);
        }
        else if (Ms.i().key_Left_Right() && this.b_c <= 0) {
            this.popMenu ^= 0x1;
        }
    }
    
    private void keyGetSkill(final Monster monster) {
        if (this.getSkill + 9 >= 35 && this.makeLevel[this.getSkill + 9 - 35] > this.rmsOther[3]) {
            this.say("\u9700\u8981\u8bad\u7ec3\u5e08" + this.makeLevel[this.getSkill + 9 - 35] + "\u7ea7\u624d\u80fd\u5b66\u4e60\uff01", 0);
        }
        else if (monster.isMonReel(this.getSkill)) {
            this.say(String.valueOf(this.getNameMon(monster.monster[0])) + "\u5df2\u62e5\u6709\u8be5\u6280\u80fd", 0);
        }
        else if (monster.monster[14] != -1 && monster.monster[15] != -1) {
            this.initSkillList(monster);
            this.bg_c = monster.monster[3];
            this.restMove(1, 0);
            this.say("\u8bf7\u9009\u62e9\u8981\u66ff\u6362\u7684\u6280\u80fd\uff01", 0);
        }
        else {
            if (monster.monster[14] == -1) {
                monster.monster[14] = this.getSkill;
            }
            else {
                monster.monster[15] = this.getSkill;
            }
            this.delItemSkill(monster);
        }
    }
    
    private void keyMY_BAG() {
        if (!Ms.i().key_delay()) {
            if (this.popMenu == -1) {
                if (Ms.i().key_S1_Num5() && this.itemsLength[this.selectx] > 0) {
                    this.popBagMenu(this.selectx, this.select[0][0]);
                }
                else if (Ms.i().key_Left_Right()) {
                    this.selectx = Ms.i().select(this.selectx, 0, this.action_str.length - 1);
                    this.select[0][1] = this.select_st[this.selectx];
                    this.select[0][0] = this.select_it[this.selectx];
                }
                else if (Ms.i().key_S2()) {
                    if (this.mini_state == 9) {
                        this.mini_state = 5;
                        this.selecty = this.select_T;
                        this.selecty = 0;
                        this.goVIEW_MONSTER();
                    }
                    else if (this.view_state == -1) {
                        this.mini_state = 1;
                        this.goBattleState();
                        this.initMonStream(2, this.mList_id[this.myMonsters[0].monster[0]][0], 1);
                        this.itemMine = null;
                    }
                    else if (this.view_state == 2) {
                        GameRun.run_state = -10;
                        GameRun.mc.paint();
                        this.goNidus(0);
                    }
                    else {
                        this.doPaint(0);
                        this.goYouPAUSE(2);
                        this.itemMine = null;
                    }
                }
                else if (Ms.i().key_Up_Down()) {
                    if (this.itemsLength[this.selectx] > 0) {
                        Ms.i().selectS(this.select[0], 0, this.itemsLength[this.selectx], this.list_rows);
                    }
                    this.select_it[this.selectx] = this.select[0][0];
                    this.select_st[this.selectx] = this.select[0][1];
                }
            }
            else {
                this.popBagState();
            }
        }
    }
    
    private void keyMagicUI() {
        if (Ms.i().key_S1_Num5() && this.mini_state == 13) {
            if (this.skill_list[this.select[0][0]] <= 25) {
                this.say("\u8be5\u6280\u80fd\u4e0d\u80fd\u66ff\u6362\uff01", 0);
            }
            else {
                if (this.skill_list[this.select[0][0]] == this.myMonsters[this.selecty].monster[14]) {
                    this.myMonsters[this.selecty].monster[14] = this.getSkill;
                }
                else {
                    this.myMonsters[this.selecty].monster[15] = this.getSkill;
                }
                this.delItemSkill(this.myMonsters[this.selecty]);
            }
        }
        else if (Ms.i().key_S2()) {
            this.select[0][1] = this.selectx;
            this.select[0][0] = this.selecty;
            this.cur_c = 0;
            this.popMenu = -1;
        }
        else if (Ms.i().key_Left_Right() && this.mini_state != 13) {
            this.popMenu ^= 0x1;
            this.select[0][1] = (this.select[0][0] = 0);
        }
        else if (Ms.i().key_Up_Down()) {
            this.introX = Constants_H.WIDTH_H;
            if (this.popMenu == 0) {
                Ms.i().selectS(this.select[0], 0, this.skill_list[8], 5);
            }
            else if (this.mini_state == 6) {
                if (this.cMonsters[this.selecty].monster[17] > 0) {
                    final byte[] array = this.select[0];
                    array[0] ^= 0x1;
                }
            }
            else if (this.myMonsters[this.selecty].monster[17] > 0) {
                final byte[] array2 = this.select[0];
                array2[0] ^= 0x1;
            }
        }
    }
    
    private void keyNidus() {
        if (!Ms.i().key_delay()) {
            if (this.mini_state == 16) {
                if (Ms.i().key_Up_Down()) {
                    this.popMenu = Ms.i().select(this.popMenu, 0, this.about_d.length - 1);
                }
                else if (Ms.i().key_S1_Num5()) {
                    if (Ms.i().equals(this.about_d[this.popMenu], "\u67e5\u770b\u5b75\u5316")) {
                        this.mini_state = 17;
                        this.popMenu = 0;
                        this.initMonStream(0, 56, 1);
                        if (this.getRid(this.popMenu) == -2) {
                            this.bg_c = this.popMenu;
                        }
                        else {
                            this.bg_c = this.monster_pro[this.getNid((int)this.popMenu)][6];
                            this.mon_action = (byte)(this.bg_c + 23);
                        }
                    }
                    else if (Ms.i().equals(this.about_d[this.popMenu], "\u9009\u62e9\u86cb")) {
                        this.view_state = 2;
                        this.goMY_BAG(3);
                    }
                    else if (Ms.i().equals(this.about_d[this.popMenu], "\u79bb\u5f00")) {
                        this.exitNidus();
                    }
                }
                else if (Ms.i().key_S2()) {
                    this.exitNidus();
                }
            }
            else if (this.b_c == -2 && Ms.i().key_Left_Right()) {
                this.popMenu = Ms.i().select(this.popMenu, 0, 4);
                if (this.getRid(this.popMenu) == -2) {
                    this.bg_c = this.popMenu;
                }
                else {
                    this.bg_c = this.monster_pro[this.getNid((int)this.popMenu)][6];
                    this.mon_action = (byte)(this.bg_c + 23);
                }
            }
            else if (Ms.i().key_S1_Num5()) {
                if (this.getRid(this.popMenu) != -2) {
                    if (this.b_c == -2 && this.getNexp(this.popMenu, 1) == this.getNexp(this.popMenu, 3)) {
                        if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
                            this.say("\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1", 0);
                        }
                        else if (this.isEvolveMake(this.getNid(this.popMenu)) == 0) {
                            this.mon_action = (byte)(this.bg_c + 28);
                            this.b_c = 1;
                            this.setNidusPro(this.getNid(this.popMenu), 1);
                            this.delItemEvolve(this.getNid((int)this.popMenu));
                        }
                        else {
                            this.say("\u6750\u6599\u4e0d\u8db3\uff0c\u4e0d\u80fd\u5b75\u5316", 0);
                        }
                    }
                    else if (this.b_c == -1) {
                        this.b_c = -2;
                        this.getMonster(this.getNid(this.popMenu), this.getNLevel(this.popMenu), -2, -1);
                        this.delNidus(this.popMenu);
                        this.initMonStream(0, 56, 1);
                    }
                }
            }
            else if (this.b_c == -2 && Ms.i().key_S2()) {
                this.exitNidus();
            }
        }
    }
    
    private void key_MONSTER_LIST(final Monster[] array) {
        if (this.popMenu == -1) {
            if (Ms.i().key_S1_Num5() && this.t_length != 0) {
                if (this.view_state == 1) {
                    if (this.mini_state == 15) {
                        this.useItem();
                    }
                    else if (this.mini_state == 13) {
                        this.keyGetSkill(array[this.select[0][0]]);
                    }
                    else {
                        final StringBuffer sb = new StringBuffer("\u5929\u8d4b#n\u6280\u80fd");
                        if (this.mini_state == 4) {
                            if (array[this.select[0][0]].monster[5] > 0) {
                                sb.append("#n\u8fdb\u5316");
                            }
                            if (this.t_length > 1) {
                                sb.append("#n\u5b58\u653e#n\u5356\u5ba0");
                            }
                        }
                        else if (this.mini_state == 6) {
                            if (!this.map.gmErr) {
                                sb.append("#n\u53d6\u51fa#n\u5356\u5ba0");
                            }
                            else {
                                sb.append("#n\u5356\u5ba0");
                            }
                        }
                        else {
                            if (this.select[0][0] != 0) {
                                sb.append("#n\u53c2\u6218");
                            }
                            if (array[this.select[0][0]].monster[5] > 0) {
                                sb.append("#n\u8fdb\u5316");
                            }
                            if (this.t_length > 1) {
                                sb.append("#n\u653e\u751f");
                            }
                        }
                        this.setStringB(sb.toString(), Constants_H.WIDTH, 3);
                        this.popMenu = 0;
                    }
                }
                else if (this.view_state < 0) {
                    if (this.mini_state == 15) {
                        this.useItem();
                    }
                    else {
                        if (this.select[0][0] != 0) {
                            this.setStringB("\u53c2\u6218#n\u6280\u80fd", Constants_H.WIDTH, 3);
                        }
                        else {
                            this.setStringB("\u6280\u80fd", Constants_H.WIDTH, 3);
                        }
                        this.popMenu = 0;
                    }
                }
            }
            else if (Ms.i().key_S2()) {
                if (this.mini_state == 13) {
                    this.goMY_BAG(2);
                }
                else if (this.view_state == 1) {
                    if (this.mini_state == 15) {
                        this.goMY_BAG(0);
                        this.mini_state = 3;
                    }
                    else if (this.mini_state == 6 || this.mini_state == 4) {
                        if (!this.map.gmErr) {
                            this.doPaint(0);
                            int n;
                            if (this.mini_state == 6) {
                                n = 1;
                            }
                            else {
                                n = 0;
                            }
                            this.goVIEW_COMPUTER(n);
                        }
                        else {
                            this.map.bkEvent_getMon();
                        }
                    }
                    else {
                        this.doPaint(0);
                        this.goYouPAUSE(1);
                    }
                }
                else if (this.view_state == -2) {
                    if (array[0].monsterPro[0] > 0) {
                        if (this.select[0][0] != 0) {
                            this.initMonStream(2, this.mList_id[array[0].monster[0]][0], 1);
                        }
                        this.goBattleState();
                    }
                    else {
                        this.say("\u5f53\u524d\u5ba0\u7269\u4e0d\u80fd\u53c2\u6218", 0);
                    }
                    this.view_state = -1;
                }
                else if (this.view_state == -1) {
                    if (this.mini_state == 15) {
                        this.goMY_BAG(0);
                    }
                    else {
                        this.say("\u5f53\u524d\u5ba0\u7269\u4e0d\u80fd\u53c2\u6218", 0);
                    }
                }
            }
            else if (Ms.i().key_Up_Down() && this.t_length != 0) {
                Ms.i().selectS(this.select[0], 0, this.t_length, this.list_rows);
                this.initMonStream(2, this.mList_id[array[this.select[0][0]].monster[0]][0], 1);
                this.setShowPro(array[this.select[0][0]]);
                this.introT = Constants_H.WIDTH_H;
            }
        }
        else {
            this.popState();
        }
    }
    
    private boolean level_up(int n, int n2) {
        if (n2 == 0) {
            n2 = this.myMonsters[n].monster[2];
            Ms.i();
            final int n3 = (byte)(n2 - Ms.skip2);
            n2 = 0;
            Ms.i();
            Ms.skip = this.exp;
            if (this.myMonsters[n].isMonReel(36)) {
                n2 = 0 + 100;
            }
            int n4 = n2;
            if (this.myMonsters[n].isMonReel(37)) {
                n4 = (short)(n2 + 200);
            }
            if (n3 < 0) {
                n2 = 0;
            }
            else if ((n2 = n3) > 4) {
                n2 = 5;
            }
            Ms.i();
            Ms.i();
            Ms.skip = (short)(Ms.skip * (9 - n2 * 2) * (n4 + 100) / 1000);
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
            final short[] array = this.proReplace[n];
            Ms.i();
            array[2] = (short)Ms.skip;
        }
        else if (n2 == 1) {
            if (this.myMonsters[n].monster[2] < 60) {
                Ms.i();
                if (Ms.skip > 0) {
                    final short monsterExp = this.getMonsterExp(this.myMonsters[n]);
                    n2 = this.myMonsters[n].monsterPro[4];
                    Ms.i();
                    n2 = (short)(n2 + Ms.skip);
                    if (n2 >= monsterExp) {
                        this.myB.cexp = this.myMonsters[n].monsterPro[4];
                        this.myMonsters[n].monsterPro[4] = monsterExp;
                        Ms.i();
                        Ms.skip = (short)(n2 - monsterExp);
                        return true;
                    }
                    this.myB.cexp = this.myMonsters[n].monsterPro[4];
                    final short[] monsterPro = this.myMonsters[n].monsterPro;
                    n = monsterPro[4];
                    Ms.i();
                    monsterPro[4] = (short)(n + Ms.skip);
                    Ms.i();
                    Ms.skip = -1;
                    return true;
                }
            }
            Ms.i();
            Ms.skip = -1;
            this.proReplace[n][2] = 0;
        }
        else if (n2 == 2) {
            Ms.i();
            if (Ms.skip <= -1) {
                return false;
            }
            this.levelPro(n, false);
            this.getMagic(this.myMonsters[n]);
            this.levelUp_in_battle[this.myMonsters[n].monster[1]][0] = 1;
            this.levelUp_in_battle[this.myMonsters[n].monster[1]][1] = this.getSkill;
            this.myMonsters[n].monsterPro[4] = 0;
        }
        return true;
    }
    
    private void loadGame() {
        this.map.firstDrawMap = 0;
        this.buyOk = 0;
        this.map.mapImg = null;
        System.out.println("loadGame 111111111111");
        GameRun.mc.goGameLoading();
        System.out.println("loadGame 22222222222");
    }
    
    private boolean magicEffectRate(final Battle battle, final Monster monster, final Monster monster2, final int n) {
        boolean b;
        if (monster2.effect != 7) {
            b = false;
        }
        else {
            final byte effect = this.skill[n][3];
            final byte b2 = this.skill[n][2];
            if (b2 == 0) {
                b = false;
            }
            else {
                byte b3 = 0;
                Label_0073: {
                    if (effect == 0) {
                        if (monster2.isBuffRate(5)) {
                            b3 = (byte)(this.inhesion[5] + b2);
                        }
                        else {
                            b3 = b2;
                            if (monster2.isBuffRate(6)) {
                                b3 = (byte)(this.inhesion[6] + b2);
                            }
                        }
                    }
                    else if (effect == 4) {
                        if (monster2.isBuffRate(7)) {
                            b3 = (byte)(this.inhesion[7] + b2);
                        }
                        else {
                            b3 = b2;
                            if (monster2.isBuffRate(8)) {
                                b3 = (byte)(this.inhesion[8] + b2);
                            }
                        }
                    }
                    else {
                        if (effect != 2) {
                            b3 = b2;
                            if (effect != 5) {
                                break Label_0073;
                            }
                        }
                        if (monster2.isBuffRate(11)) {
                            b3 = (byte)(this.inhesion[11] + b2);
                        }
                        else {
                            b3 = b2;
                            if (monster2.isBuffRate(12)) {
                                b3 = (byte)(this.inhesion[12] + b2);
                            }
                        }
                    }
                }
                Ms.i();
                if (Ms.getRandom(100) < b3) {
                    monster2.effect = effect;
                    if (effect == 3 || effect == 4 || effect == 5) {
                        monster2.effect_time = 4;
                    }
                    else if (effect == 2) {
                        int n2;
                        if (monster.isMonReel(32)) {
                            n2 = 5;
                        }
                        else {
                            n2 = 4;
                        }
                        monster2.effect_time = (byte)n2;
                    }
                    else if (effect == 0) {
                        monster2.effect_time = 2;
                    }
                    else if (effect == 6) {
                        if (monster2.monster[3] == -1) {
                            monster2.effect = 7;
                            this.say("\u5c01\u95ed\u6548\u679c\uff0c\u5bf9\u5e7d\u6697\u9b3c\u738b\u4e0d\u8d77\u4f5c\u7528", -1);
                        }
                        else {
                            monster2.effect_time = 4;
                        }
                    }
                    if (effect == 5) {
                        byte b4;
                        if (monster.isMonReel(31)) {
                            b4 = this.skill[31][0];
                        }
                        else {
                            b4 = 1;
                        }
                        battle.fs_level = (byte)(b4 + n);
                    }
                    b = true;
                }
                else {
                    b = false;
                }
            }
        }
        return b;
    }
    
    private byte monsterRemove(int i) {
        byte b;
        if (this.myMon_length > 1) {
            this.myMonsters[i] = null;
            for (i = (byte)i; i < this.myMon_length - 1; i = (byte)(i + 1)) {
                this.myMonsters[i] = this.myMonsters[i + 1];
                this.evolve[i] = this.evolve[i + 1];
            }
            for (i = this.myMon_length; i < this.myMonsters.length; i = (byte)(i + 1)) {
                this.evolve[i] = true;
            }
            --this.myMon_length;
            b = 1;
        }
        else {
            b = -1;
        }
        return b;
    }
    
    private void mpAdd(final int n) {
        if (this.myMonsters[this.select[0][0]].monsterPro[1] < this.myMonsters[this.select[0][0]].monsterPro[3] && this.myMonsters[this.select_T].monsterPro[0] > 0) {
            this.AddMP(this.myMonsters[this.select[0][0]].monsterPro[3] * n / 100, this.myMonsters[this.select[0][0]]);
            this.useState(0, this.select_it[0]);
        }
        else if (this.myMonsters[this.select[0][0]].monsterPro[1] < 1) {
            this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u65e0\u6cd5\u4f7f\u7528\uff01", 0);
        }
        else {
            this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u4e0d\u9700\u8981\u4f7f\u7528\u8fd9\u4e2a\u9053\u5177", 0);
        }
    }
    
    private void paintBATTLE_OVER() {
        if (this.b_c == 1) {
            this.drawEvolveUI(0, this.myB.now_id, false);
        }
    }
    
    private void paintBattleState(final Graphics graphics) {
        switch (this.battle_state) {
            case -1: {
                this.drawAnimationBattle(this.am, this.mini_state);
                break;
            }
            case 3: {
                Ui.i().drawK0(320 - 150, 50, 300, 193, 0);
                Ui.i().sliding(320 + 125, 60, 173, this.select[0][0], this.skill_list[8], false);
                this.drawSkillList(320 - 150 + 10, 60, 250, 28, 6, this.select[0]);
                this.showStringM(this.skill_help[this.skill_list[this.select[0][0]]].toString(), 320, 269, 7, 0);
                Ui.i().drawYesNo(true, true);
                break;
            }
            case -2: {
                if (this.drawHitOne(this.dm, this.am, this.getBXY(this.mini_state, this.am.skill, true) - 15, this.getBXY(this.mini_state, this.am.skill, false) - 34) && this.drawHitOne(this.am, this.dm, this.getBXY(this.mini_state ^ 0x1, 25, true) - 15, this.getBXY(this.mini_state ^ 0x1, 25, false) - 34) && this.runHitToState(this.am, this.dm, this.mini_state)) {
                    this.battle_state = -3;
                    this.am.initHit();
                    this.doEffectValue(this.am);
                    this.doBuffValue(this.am);
                    break;
                }
                break;
            }
            case -3: {
                if (this.drawHitOne(this.am, this.dm, this.getBXY(this.mini_state ^ 0x1, 25, true) - 15, this.getBXY(this.mini_state ^ 0x1, 25, false) - 34) && this.runHitToState(this.dm, this.am, this.mini_state ^ 0x1)) {
                    this.battle_state = 9;
                    this.effectR(this.dm.getMon());
                    break;
                }
                break;
            }
            case -5: {
                if (this.proReplace[this.myB.now_id][2] > -1) {
                    final String string = String.valueOf(this.getNameMon(this.myMonsters[this.myB.now_id].monster[0])) + "\u83b7\u5f97\u7ecf\u9a8c\uff1a";
                    Log.e("sk", "\u83b7\u5f97\u7ecf\u9a8c");
                    Ui.i().drawString(string, 204, 308, 36, 1, 0);
                    Ui.i().drawNum(new StringBuilder().append(this.proReplace[this.myB.now_id][2]).toString(), 220, 315, 0, 1);
                    break;
                }
                if (this.proReplace[this.myB.now_id][2] == -1) {
                    Ui.i().drawString("\u60a8\u7684\u5ba0\u7269\u5df2\u7ecf\u65e0\u6cd5\u83b7\u5f97\u7ecf\u9a8c", 204, 282, 36, 7, 0);
                    Ms.i().sleep(600);
                    break;
                }
                break;
            }
        }
    }
    
    private void popBagMenu(final int n, int n2) {
        final String s = "\u8fd4\u56de";
        n2 = this.items[n][n2][0];
        String s2;
        if ((n == 0 || n2 == 32 || n2 == 33) && this.isBagUse(n2)) {
            s2 = "\u4f7f\u7528#n\u8fd4\u56de";
        }
        else if (n == 2) {
            s2 = "\u5b66\u4e60#n\u8fd4\u56de";
        }
        else {
            s2 = s;
            if (this.view_state == 2) {
                s2 = s;
                if (n == 3) {
                    s2 = "\u5b75\u5316#n\u8fd4\u56de";
                }
            }
        }
        this.setStringB(s2, Constants_H.WIDTH, 0);
        this.popMenu = 0;
    }
    
    private void popBagState() {
        if (Ms.i().key_Up_Down()) {
            this.popMenu = Ms.i().select(this.popMenu, 0, this.about_a.length - 1);
        }
        if (Ms.i().key_S1_Num5()) {
            final byte b = this.items[this.selectx][this.select[0][0]][0];
            if (Ms.i().equals(this.about_a[this.popMenu], "\u4f7f\u7528")) {
                switch (b) {
                    default: {
                        this.goVIEW_MONSTER();
                        this.mini_state = 15;
                        break;
                    }
                    case 9:
                    case 10:
                    case 11: {
                        if (this.battle_type == 4 || this.battle_type == 1) {
                            this.goCatchMonster();
                            break;
                        }
                        this.say("\u7279\u6b8a\u60c5\u51b5\uff0c\u65e0\u6cd5\u6355\u83b7\uff01", 1);
                        Ms.i().sleep(400);
                        break;
                    }
                    case 14:
                    case 15: {
                        this.popMenu = -1;
                        if (this.map.notMeet == 0) {
                            this.map.notMeet(1, b);
                            this.say("\u4f7f\u7528" + this.getNameItem((int)b) + "\uff0c" + "\u83b7\u5f97\u4e86" + "\u8eb2\u907f\u602a\u7269\u6548\u679c", 1);
                            this.deleteItems(b, 1);
                            break;
                        }
                        if (this.map.notMeet == 1) {
                            this.say("\u5df2\u62e5\u6709\u8eb2\u907f\u602a\u7269\u6548\u679c", 0);
                            break;
                        }
                        break;
                    }
                    case 32:
                    case 33: {
                        int n;
                        if (b == 32) {
                            n = 33;
                        }
                        else {
                            n = 32;
                        }
                        Label_0475: {
                            if (this.findItem(-2, n, true) > 0) {
                                this.deleteItems(32, 1);
                                this.deleteItems(33, 1);
                                int n2 = 3;
                                int i = 1;
                                final int n3 = -1;
                                Ms.i();
                                final byte b2 = (byte)Ms.getRandom(100);
                                if (b2 < 70) {
                                    n2 = 0;
                                }
                                else if (b2 < 85) {
                                    n2 = 1;
                                }
                                else if (b2 < 95) {
                                    n2 = 2;
                                }
                                Ms.i();
                                final byte b3 = (byte)Ms.getRandom(100);
                                while (true) {
                                    while (i < this.itemMine[n2].length) {
                                        if (b3 < this.itemMine[n2][i]) {
                                            final int n4 = this.itemMine[n2][i - 1];
                                            int n5 = 0;
                                            Label_0431: {
                                                if (n4 == 34 && this.findItem(-2, n4, true) > 0) {
                                                    n5 = -1;
                                                }
                                                else {
                                                    if (n4 != -1) {
                                                        n5 = n4;
                                                        if (this.findItem(-2, n4, true) < 99) {
                                                            break Label_0431;
                                                        }
                                                    }
                                                    n5 = -1;
                                                }
                                            }
                                            if (n5 != -1) {
                                                this.addItem(n5, 1);
                                                this.say("\u83b7\u5f97\uff1a" + this.getNameItem(n5) + "x1", 0);
                                                break Label_0475;
                                            }
                                            this.say("\u8fd9\u4e2a\u5b9d\u7bb1\u662f\u7a7a\u7684\u3002", 0);
                                            break Label_0475;
                                        }
                                        else {
                                            i = (byte)(i + 2);
                                        }
                                    }
                                    final int n4 = n3;
                                    continue;
                                }
                            }
                            final StringBuilder sb = new StringBuilder("\u6ca1\u6709");
                            String str;
                            if (b == 32) {
                                str = "\u94a5\u5319\uff0c\u94a5\u5319\u5728\u5546\u5e97\u4e2d\u53ef\u4ee5\u8d2d\u4e70\u3002";
                            }
                            else {
                                str = "\u5b9d\u7bb1\uff0c\u5b9d\u7bb1\u5728\u6218\u6597\u540e\u4e00\u5b9a\u51e0\u7387\u83b7\u5f97\u3002";
                            }
                            this.say(sb.append(str).toString(), 0);
                        }
                        this.popMenu = -1;
                        break;
                    }
                }
            }
            else if (Ms.i().equals(this.about_a[this.popMenu], "\u5b66\u4e60")) {
                this.mini_state = 13;
                this.getSkill = (byte)(b - 9);
                this.goVIEW_MONSTER();
            }
            else if (Ms.i().equals(this.about_a[this.popMenu], "\u5b75\u5316")) {
                if (this.addNidus(b - 58)) {
                    this.deleteItems(b, 1);
                    this.select_it[this.selectx] = this.select[0][0];
                    this.select_st[this.selectx] = this.select[0][1];
                }
                else {
                    this.say("\u5b75\u5316\u6240\u5df2\u7ecf\u6ca1\u6709\u7a7a\u4f4d\u4e86", 0);
                }
                this.popMenu = -1;
            }
            else {
                this.popMenu = -1;
            }
            Ms.i().correctSelect(this.select[0], this.itemsLength[this.selectx], this.list_rows);
        }
        else if (Ms.i().key_S2()) {
            this.popMenu = -1;
        }
    }
    
    private void putMonster() {
        if (this.cMon_count >= this.max_monsters) {
            this.say("\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1", 0);
        }
        else if (!this.isMyMonsters(this.select[0][0])) {
            this.say("\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01", 0);
        }
        else {
            this.cMonsters[this.cMon_count] = this.myMonsters[this.select[0][0]];
            ++this.cMon_count;
            this.setPutMonster();
        }
    }
    
    private void resetFealty(final int n) {
        final byte b = this.initFealty[this.myMonsters[this.select[0][0]].monster[4] / 4];
        if (this.myMonsters[this.select[0][0]].monster[6] < b && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
            if (n == -1) {
                this.myMonsters[this.select[0][0]].monster[6] = b;
            }
            else if (this.myMonsters[this.select[0][0]].monster[6] + n > b) {
                this.myMonsters[this.select[0][0]].monster[6] = b;
            }
            else {
                final byte[] monster = this.myMonsters[this.select[0][0]].monster;
                monster[6] += (byte)n;
            }
            this.useState(0, this.select_it[0]);
            if (this.view_state == -1) {
                this.getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
            }
        }
        else if (this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
            this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u5fe0\u8bda\u5ea6\u5df2\u6ee1", 0);
        }
    }
    
    private void resetMonster(final int n) {
        if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            this.AddMP(this.myMonsters[this.select[0][0]].monsterPro[3] * n / 100, this.myMonsters[this.select[0][0]]);
            this.AddHP(this.myMonsters[this.select[0][0]].monsterPro[2] * n / 100, this.myMonsters[this.select[0][0]]);
            this.myMonsters[this.select[0][0]].effect = 7;
            this.useState(0, this.select_it[0]);
        }
        else {
            this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u6ca1\u6709\u6b7b\u4ea1\uff01", 0);
        }
    }
    
    private void restMove(final int n, final int n2) {
        this.selectx = this.select[0][1];
        this.selecty = this.select[0][0];
        this.cur_c = (byte)n;
        this.select[0][1] = (this.select[0][0] = 0);
        this.popMenu = (byte)n2;
        this.move_x = 129;
        this.move_y = -14;
    }
    
    private void runBattleState() {
        this.myB.countS[0] = (byte)Ms.i().mathSpeedN(this.myB.countS[0], this.myB.countS[1], 1, false);
        this.enB.countS[0] = (byte)Ms.i().mathSpeedN(this.enB.countS[0], this.enB.countS[1], 1, false);
        switch (this.battle_state) {
            case 1: {
                if (!this.bufferAI(this.enB.getMon())) {
                    this.enB.act_num = 0;
                    this.battle_state = -2;
                    break;
                }
                this.aiEnemy();
                if (this.enB.getMon().effect != 6 || this.getSkillLevel(this.enB.skill) <= 3) {
                    this.setAcionSkill(this.enB);
                    break;
                }
                break;
            }
            case 9: {
                if (this.myB.act_num == 0 && this.enB.act_num == 0) {
                    this.myB.act_num = 1;
                    this.enB.act_num = 1;
                    if (this.myB.getMon().isMonEffect(0)) {
                        this.myB.act_num = 0;
                        this.say("\u77f3\u5316\u6548\u679c\u65e0\u6cd5\u884c\u52a8\uff0c\u53d7\u5230\u7684\u4f24\u5bb3\u51cf\u5c1130%", -1);
                    }
                    else {
                        this.setAimBattle(1);
                        this.goBattleState();
                        String s = "";
                        if (this.myB.getMon().isMonEffect(2)) {
                            s = "\u6495\u88c2\u6548\u679c\uff0c\u51cf\u5c11\u5f53\u524d\u8840\u91cf\u768410%";
                        }
                        else if (this.myB.getMon().isMonEffect(3)) {
                            s = "\u9b45\u60d1\u6548\u679c\uff0c\u4e0d\u80fd\u9003\u8dd1\uff0c\u589e\u52a0\u6355\u83b7\u5ba0\u7269\u7684\u51e0\u7387";
                        }
                        else if (this.myB.getMon().isMonEffect(4)) {
                            s = "\u7981\u9522\u6548\u679c\uff0c\u4e0d\u80fd\u9003\u8dd1\uff0c\u4e0d\u80fd\u6362\u602a\uff0c\u4e0d\u80fd\u4f7f\u7528\u9053\u5177";
                        }
                        else if (this.myB.getMon().isMonEffect(5)) {
                            s = "\u8150\u8680\u6548\u679c\uff0c\u6bcf\u56de\u5408\u53d7\u5230\u4e00\u5b9a\u4f24\u5bb3";
                        }
                        if (!s.equals("")) {
                            this.say(s, 0);
                            break;
                        }
                        break;
                    }
                }
                if (this.myB.act_num != 0 && this.enB.act_num != 0) {
                    int aimBattle;
                    if (this.myB.getMon().monsterPro[5] >= this.enB.getMon().monsterPro[5]) {
                        aimBattle = 1;
                    }
                    else {
                        aimBattle = 0;
                    }
                    this.setAimBattle(aimBattle);
                }
                else {
                    int aimBattle2;
                    if (this.myB.act_num != 0) {
                        aimBattle2 = 1;
                    }
                    else {
                        aimBattle2 = 0;
                    }
                    this.setAimBattle(aimBattle2);
                }
                if (this.mini_state == 1) {
                    this.myB.act_num = 0;
                    if (this.myB.getMon().monster[6] < 41) {
                        Ms.i();
                        if (Ms.getRandom(100) < 25) {
                            this.say("\u5fe0\u8bda\u5ea6\u8fc7\u4f4e\uff0c\u5ba0\u7269\u4e0d\u670d\u4ece\u4e3b\u4eba\u547d\u4ee4", -1);
                            break;
                        }
                    }
                    if (this.myB.getMon().isMonEffect(0)) {
                        this.say("\u77f3\u5316\u6548\u679c\u65e0\u6cd5\u884c\u52a8\uff0c\u53d7\u5230\u7684\u4f24\u5bb3\u51cf\u5c1130%", -1);
                        break;
                    }
                    this.setAcionSkill(this.myB);
                    break;
                }
                else {
                    if (this.say_c != 0) {
                        break;
                    }
                    this.enB.act_num = 0;
                    if (!this.enB.getMon().isMonEffect(0)) {
                        this.battle_state = 1;
                        break;
                    }
                    break;
                }
                break;
            }
            case -5: {
                if (this.b_c == 0 && this.cur_c >= this.mon_in_battle[0]) {
                    this.goBattleOver();
                    this.setNidusExp(this.exp);
                    break;
                }
                final byte now_id = this.mon_in_battle[this.cur_c + 1];
                if (this.b_c == 0) {
                    if (this.myMonsters[now_id].monsterPro[0] > 0) {
                        if (!this.myMonsters[now_id].isMonReel(40)) {
                            final byte[] monster = this.myMonsters[now_id].monster;
                            --monster[6];
                        }
                        this.myB.now_id = now_id;
                        this.myB.chp = this.myMonsters[now_id].monsterPro[0];
                        this.myB.cexp = this.myMonsters[now_id].monsterPro[4];
                        this.initMonStream(2, this.mList_id[this.myMonsters[now_id].monster[0]][0], 1);
                        if (this.level_up(now_id, 0)) {
                            this.b_c = 1;
                        }
                    }
                    else {
                        ++this.cur_c;
                    }
                }
                else if (this.b_c == 1) {
                    this.level_up(now_id, 1);
                    this.b_c = 2;
                }
                else if (this.b_c == 2 && this.myB.cexp == this.myMonsters[now_id].monsterPro[4]) {
                    if (!this.level_up(now_id, 2)) {
                        this.b_c = 15;
                    }
                    else {
                        this.b_c = 1;
                    }
                }
                else if (this.b_c > 2) {
                    boolean b;
                    if (this.b_c < 21) {
                        b = true;
                    }
                    else {
                        b = false;
                    }
                    boolean b2;
                    if (this.myB.cexp == this.myMonsters[now_id].monsterPro[4]) {
                        b2 = true;
                    }
                    else {
                        b2 = false;
                    }
                    if ((b & b2) && --this.b_c == 3) {
                        this.b_c = 0;
                        ++this.cur_c;
                    }
                }
                this.myB.cexp = Ms.i().mathSpeedN(this.myB.cexp, this.myMonsters[now_id].monsterPro[4], 8, false);
                break;
            }
            case -4: {
                if (this.say_c != 0) {
                    break;
                }
                if (++this.cur_b >= this.about_a.length) {
                    this.about_a = null;
                    this.goBattleExp(true);
                    break;
                }
                Log.e("soars", this.about_a[this.cur_b].toString());
                this.say(this.about_a[this.cur_b].toString(), 0);
                break;
            }
        }
    }
    
    private void runHit() {
        if (!this.am.b_renascence && !this.dm.b_renascence) {
            this.hit_rate(this.am, this.dm, this.am.getMon(), this.dm.getMon(), this.am.skill);
        }
        else {
            this.am.b_renascence = false;
            this.dm.b_renascence = false;
        }
        this.battle_state = -2;
    }
    
    private boolean runHitToState(final Battle battle, final Battle battle2, final int n) {
        boolean b;
        if (battle2.getMon().monsterPro[0] > 0) {
            b = true;
        }
        else {
            Label_0065: {
                if (battle2.dead == 1) {
                    if (battle2.getMon().isMonReel(38)) {
                        Ms.i();
                        if (Ms.getRandom(100) < this.skill[38][1]) {
                            this.setRelive(battle, battle2);
                            break Label_0065;
                        }
                    }
                    if (n == 0) {
                        this.enB.act_num = 1;
                        if (this.changeMy()) {
                            b = false;
                            return b;
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
                            b = false;
                            return b;
                        }
                        if (SMSSender.i(this).sms_a) {
                            System.out.println("aaaaaaaaaaaaa");
                            if (this.say_c == 0) {
                                this.isKillAll = true;
                                if (!GameRun.isSay) {
                                    this.say("\u643a\u5e26\u7684\u5ba0\u7269\u5168\u90fd\u727a\u7272\u4e86!", -1, 1);
                                }
                            }
                        }
                        else {
                            System.out.println("bbbbbbbbbb");
                            SMSSender.i(this).sms_a = true;
                            this.goGameOver();
                        }
                    }
                    else if (n == 1) {
                        if (this.changeMon(this.enB, this.enB.mon.length)) {
                            this.setEnemyThrow();
                            this.enB.act_num = 0;
                            GameRun.run_state = -50;
                            this.t_battle_state = this.battle_state;
                            this.battle_state = 0;
                        }
                        else {
                            this.goBattleItem();
                            if (this.overMode == 2) {
                                this.map.sIfElse = 0;
                            }
                            this.overMode = 0;
                        }
                    }
                }
                else if (battle2.action != 2) {
                    battle2.action = 2;
                    this.now_action[this.mini_state] = 0;
                    this.now_time[this.mini_state] = 0;
                    if (!battle2.getMon().isMonReel(40)) {
                        final byte[] monster = battle2.getMon().monster;
                        monster[6] -= 10;
                    }
                }
            }
            b = false;
        }
        return b;
    }
    
    private void runMonsterAppear() {
        switch (this.battle_state) {
            case 0: {
                if (this.myB.throw_state != 2 || this.myB.throw_state != 2) {
                    break;
                }
                if (this.view_state == -2) {
                    this.setAimBattle(0);
                    this.myB.act_num = 0;
                    this.enB.act_num = 0;
                }
                this.view_state = -1;
                this.goBattleState();
                if (this.t_battle_state == -3 || this.t_battle_state == -2) {
                    this.battle_state = this.t_battle_state;
                    this.t_battle_state = 0;
                    this.getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
                }
                else {
                    this.goSelectAction(this.mini_state);
                }
                if (this.first_battle != 0) {
                    break;
                }
                this.first_battle = 1;
                final byte b = (byte)(this.myB.getMon().monster[6] - 99);
                int n;
                if (b > 1) {
                    n = 20;
                }
                else {
                    n = b / 20 * 20;
                }
                if ((byte)n < 0) {
                    this.say("\u5fe0\u8bda\u5ea6\u964d\u4f4e\uff0c\u653b\u51fb\u529b\u4e0b\u964d\uff0c\u8bf7\u53ca\u65f6\u8865\u5145\uff01", 0);
                    break;
                }
                break;
            }
        }
    }
    
    private void runThrowBall(final Battle battle, final Monster monster, final int n) {
        if (this.src_c[n + 2] == 0 && battle.throw_state == -1 && this.src_c[n] == 12) {
            battle.throw_state = 0;
        }
        else if (this.src_c[n + 2] == 1 && this.src_c[n] == 0) {
            this.src_c[n + 2] = 0;
            this.getBattleBG(battle, monster);
        }
        if (battle.throw_state == 0) {
            battle.cThrow[0] = (byte)Ms.i().mathSpeedN(battle.cThrow[0], 0, 6, false);
            battle.cThrow[1] = (byte)Ms.i().mathSpeedUp(battle.cThrow[1], 62, 2);
            if (battle.cThrow[0] == 0 && battle.cThrow[1] == 0) {
                battle.throw_state = 1;
            }
        }
        else if (battle.throw_state == 1) {
            if (battle.cThrow[2] < 12) {
                final short[] cThrow = battle.cThrow;
                ++cThrow[2];
            }
            else {
                battle.throw_state = 2;
            }
        }
    }
    
    private void sellMonster(final Monster monster) {
        this.sell_money = monster.monster[2] * (monster.monster[4] * 5) + 100;
    }
    
    private void setAcionSkill(final Battle battle) {
        battle.action = 1;
        this.now_action[this.mini_state] = 0;
        this.now_time[this.mini_state] = 0;
        this.battle_state = -1;
        this.setMagic(battle.skill / 5);
    }
    
    private boolean setCartoonFrameMagic_C(final int n, final int n2, final int n3, final boolean b) {
        final short[] now_time_Magic = this.now_time_Magic;
        final short n4 = (short)(now_time_Magic[n] + 1);
        now_time_Magic[n] = n4;
        if (n4 < this.magic[n2].action(n3, this.now_action_Magic[n], 1)) {
            return false;
        }
        final short[] now_action_Magic = this.now_action_Magic;
        ++now_action_Magic[n];
        this.now_time_Magic[n] = 0;
        if (b || this.now_action_Magic[n] < this.magic[n2].aLength(n3)) {
            return false;
        }
        final short[] now_action_Magic2 = this.now_action_Magic;
        --now_action_Magic2[n];
        return true;
        b2 = false;
        return b2;
    }
    
    private boolean setCartoonFrame_C(final int n, final int n2, final int n3, final boolean b) {
        final byte[] now_time = this.now_time;
        final byte b2 = (byte)(now_time[n] + 1);
        now_time[n] = b2;
        if (b2 < this.mon[n2].action(n3, this.now_action[n], 1)) {
            return false;
        }
        final byte[] now_action = this.now_action;
        ++now_action[n];
        this.now_time[n] = 0;
        if (b || this.now_action[n] < this.mon[n2].aLength(n3)) {
            return false;
        }
        final byte[] now_action2 = this.now_action;
        --now_action2[n];
        return true;
        b3 = false;
        return b3;
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
    
    private void setEvolveStringB(final Monster monster) {
        final byte b = (byte)(monster.monster[0] + 1);
        final byte b2 = monster.monster[2];
        int n = 0;
        byte b3 = b;
        if (this.monsterMake[monster.monster[0]][0] > 0) {
            n = n;
            b3 = b;
            if (this.findItem(-2, 34, true) > 0) {
                b3 = this.monsterMake[monster.monster[0]][0];
                n = 1;
            }
        }
        this.proReplace = null;
        this.proReplace = new short[1][6];
        this.proReplace[0][0] = (short)(this.getbuffRateV(monster, this.monster_pro[b3][0] + this.monster_pro[b3][7] * b2 / 10) - monster.monsterPro[2]);
        this.proReplace[0][1] = (short)(this.monster_pro[b3][1] + this.monster_pro[b3][8] * b2 / 10 - monster.monsterPro[3]);
        final short[] array = this.proReplace[0];
        byte b4;
        if (n != 0) {
            b4 = monster.monster[5];
        }
        else {
            b4 = 1;
        }
        array[2] = (short)(-b4);
        this.proReplace[0][3] = (byte)(this.monster_pro[b3][3] + this.monster_pro[b3][10] * b2 / 10 - monster.monsterPro[6]);
        this.proReplace[0][4] = (byte)(this.monster_pro[b3][4] + this.monster_pro[b3][11] * b2 / 10 - monster.monsterPro[7]);
        this.proReplace[0][5] = (byte)(this.monster_pro[b3][2] + this.monster_pro[b3][9] * b2 / 10 - monster.monsterPro[5]);
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
    
    private void setNidusPro(final int n, final int n2) {
        final StringBuffer sb = new StringBuffer();
        sb.append("\u751f\u547d\uff1a" + (this.monster_pro[n][0] + this.monster_pro[n][7] * n2 / 10) + "#n");
        sb.append("\u80fd\u91cf\uff1a" + (this.monster_pro[n][1] + this.monster_pro[n][8] * n2 / 10) + "#n");
        sb.append("\u8fdb\u5316\uff1a" + this.monster_pro[n][12]);
        this.setStringB(sb.toString(), Constants_H.WIDTH, 0);
        sb.delete(0, sb.length());
        sb.append("\u529b\u91cf\uff1a" + (this.monster_pro[n][3] + this.monster_pro[n][10] * n2 / 10) + "#n");
        sb.append("\u9632\u5fa1\uff1a" + (this.monster_pro[n][4] + this.monster_pro[n][11] * n2 / 10) + "#n");
        sb.append("\u654f\u6377\uff1a" + (this.monster_pro[n][4] + this.monster_pro[n][11] * n2 / 10));
        this.setStringB(sb.toString(), Constants_H.WIDTH, 1);
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
        for (byte b = this.select[0][0]; b < this.myMon_length - 1; ++b) {
            this.myMonsters[b] = this.myMonsters[b + 1];
            this.evolve[b] = this.evolve[b + 1];
        }
        for (byte myMon_length = this.myMon_length; myMon_length < this.myMonsters.length; ++myMon_length) {
            this.evolve[myMon_length] = true;
        }
        --this.myMon_length;
        if (this.select[0][0] == this.myMon_length) {
            final byte[] array = this.select[0];
            --array[0];
        }
        this.initMonStream(2, this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0], 1);
        this.setShowPro(this.myMonsters[this.select[0][0]]);
        this.introT = Constants_H.WIDTH_H;
        this.t_length = this.myMon_length;
        this.popMenu = -1;
        Ms.i().correctSelect(this.select[0], this.t_length, this.list_rows);
    }
    
    private void setRelive(final Battle battle, final Battle battle2) {
        battle2.initHit();
        battle2.addHit(-battle2.getMon().monsterPro[2] * this.skill[38][0] / 100, 1, 1);
        battle2.skill = 28;
        battle2.dead = 0;
        battle2.action = 0;
        battle2.b_renascence = true;
        battle2.act_num = 0;
        this.battle_state = -1;
        this.setMagic(5);
        this.getHitCoefficient(battle2, battle2.getMon(), battle.getMon());
        this.setAimBattle(this.mini_state ^ 0x1);
    }
    
    private void setShowPro(final Monster monster) {
        final StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(monster.monsterPro[6]) + "#n");
        sb.append(String.valueOf(monster.monsterPro[7]) + "#n");
        sb.append(monster.monsterPro[5]);
        this.setStringB(sb.toString(), Constants_H.WIDTH, 2);
    }
    
    private void setTakenMonster() {
        for (byte b = this.select[0][0]; b < this.cMon_count - 1; ++b) {
            this.cMonsters[b] = this.cMonsters[b + 1];
        }
        --this.cMon_count;
        this.t_length = this.cMon_count;
        if (this.select[0][0] == this.cMon_count) {
            final byte[] array = this.select[0];
            --array[0];
        }
        if (this.t_length > 0) {
            this.initMonStream(2, this.mList_id[this.cMonsters[this.select[0][0]].monster[0]][0], 1);
            this.setShowPro(this.cMonsters[this.select[0][0]]);
        }
        this.introT = Constants_H.WIDTH_H;
        this.popMenu = -1;
        Ms.i().correctSelect(this.select[0], this.t_length, this.list_rows);
    }
    
    private void setThrow(final Battle battle, final Monster monster, final int n) {
        battle.throw_state = -1;
        this.initMonStream(2, this.mList_id[monster.monster[0]][0], n);
        if (monster.isMonReel(monster.monster[3] + 43)) {
            if (battle.bg_id != monster.monster[3]) {
                this.src_c[n + 2] = 1;
            }
        }
        else if (this.monPro.length != 0 && battle.bg_id != this.monPro[0]) {
            this.src_c[n + 2] = 1;
        }
        battle.action = 0;
        battle.dead = 0;
        battle.chp = monster.monsterPro[0];
    }
    
    private void takenMonster() {
        if (this.myMon_length < this.max_takes) {
            this.myMonsters[this.myMon_length] = this.cMonsters[this.select[0][0]];
            this.evolve[this.myMon_length] = true;
            ++this.myMon_length;
            this.setTakenMonster();
        }
        else {
            this.say("\u6240\u80fd\u643a\u5e26\u7684\u5ba0\u7269\u5df2\u7ecf\u8fbe\u5230\u4e0a\u9650\uff01", 1);
        }
    }
    
    private void useItem() {
        switch (this.items[0][this.select_it[0]][0]) {
            case 5: {
                this.allAdd(50);
                break;
            }
            case 6: {
                this.allAdd(100);
                break;
            }
            case 13: {
                this.resetFealty(-1);
                break;
            }
            case 12: {
                this.resetFealty(30);
                break;
            }
            case 7: {
                this.resetMonster(30);
                break;
            }
            case 4: {
                this.mpAdd(100);
                break;
            }
            case 3: {
                this.mpAdd(50);
                break;
            }
            case 2: {
                this.hpAdd(100, 0);
                break;
            }
            case 0: {
                this.hpAdd(35, 30);
                break;
            }
            case 1: {
                this.hpAdd(65, 30);
                break;
            }
            case 8: {
                this.changeEffect();
                break;
            }
        }
    }
    
    private void useState(final int n, final int n2) {
        GameRun.mc.paint();
        Ms.i().sleep(200);
        if (this.view_state == -1) {
            this.myB.act_num = 0;
            this.goBattleState();
            this.battle_state = 9;
            this.initMonStream(2, this.mList_id[this.myMonsters[0].monster[0]][0], 1);
        }
        else {
            this.goMY_BAG(n);
        }
        this.deleteItems(this.items[n][n2][0], 1);
    }
    
    public void Success() {
        synchronized (this) {
            SMSSender.i(this).setSendSms(4);
            try {
                SMSSender.i(this);
                if (SMSSender.smsType == 6) {
                    SMSSender.i(this).sendSuccess();
                    SMSSender.i(this).setSendSms(-1);
                    GameRun.run_state = -10;
                    GameRun.mc.temp_state = GameRun.run_state;
                    GameRun.mc.setSmsIsSetRun_state(true);
                    this.map.setRegState(true);
                }
                else {
                    SMSSender.i(this).sendSuccess();
                }
            }
            catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public byte addItem(final int n, final int n2) {
        final byte itemType = this.findItemType(n);
        final byte item = this.findItem(itemType, n, false);
        if (item == -1) {
            this.items[itemType][this.itemsLength[itemType]][0] = (byte)n;
            this.items[itemType][this.itemsLength[itemType]][1] = (byte)n2;
            final byte[] itemsLength = this.itemsLength;
            ++itemsLength[itemType];
            return 1;
        }
        final byte[] array = this.items[itemType][item];
        if ((array[1] += (byte)n2) <= 99) {
            return 1;
        }
        this.items[itemType][item][1] = 99;
        this.say(String.valueOf(this.getNameItem(this.items[itemType][item][0])) + "\u6570\u91cf\u5df2\u5230\u4e0a\u9650", 0);
        return -1;
        b = 1;
        return b;
    }
    
    public void addMonInfoListBH() {
        final byte[] monInfoList = this.monInfoList;
        ++monInfoList[104];
        final byte[] monInfoList2 = this.monInfoList;
        ++monInfoList2[103];
        if (this.monInfoList[103] == 102) {
            this.say("\u606d\u559c\u60a8\u628a\u6240\u6709\u7684\u5ba0\u7269\u90fd\u6536\u96c6\u9f50\u4e86", 0);
            GameRun.mc.paint();
            Ms.i().sleep(600);
        }
    }
    
    public void battleType(final int n) {
        this.battle_type = (byte)n;
    }
    
    public boolean checkMonster() {
        for (byte b = 0; b < this.myMon_length; ++b) {
            if (this.myMonsters[b].monsterPro[1] < this.myMonsters[b].monsterPro[3] || this.myMonsters[b].monsterPro[0] < this.myMonsters[b].monsterPro[2]) {
                return false;
            }
        }
        this.say("\u60a8\u7684\u5ba0\u7269\u4e0d\u9700\u8981\u56de\u590d\uff01", 0);
        return true;
    }
    
    public void data_init() {
        final byte[] stream = Ms.i().getStream("data/data.d", -1);
        Ms.i();
        Ms.skip = 0;
        this.skill_up = Ms.i().create2Array(stream);
        this.monster_pro = Ms.i().create2Array(stream);
        this.skill = Ms.i().create2Array(stream);
        this.skill_help = Ms.i().createStringArray(stream);
        this.skill_name = Ms.i().createStringArray(stream);
        this.monsterT = Ms.i().createStringArray(stream);
        this.NAME = Ms.i().createStringArray(stream);
        this.item_help = Ms.i().createStringArray(stream);
        this.item_name = Ms.i().createStringArray(stream);
        this.city_name = Ms.i().createStringArray(stream);
        this.buff_name = Ms.i().createStringArray(stream);
        this.buff_help = Ms.i().createStringArray(stream);
        this.monAppearMap = Ms.i().create2Array(stream);
        this.mList_id = Ms.i().create2Array(stream);
        this.monsterMake = Ms.i().create2Array(stream);
        this.monsterInfo = Ms.i().createStringArray(stream);
        this.inhesion = Ms.i().createArray(stream);
        this.makeLevel = Ms.i().createArray(stream);
        this.musicNo = Ms.i().createArray(stream);
        this.npc2ImageType = Ms.i().createArray(stream);
        this.map.boatCourse = Ms.i().create2Array(stream);
        this.nidusList = Ms.i().create2Array(stream);
        final byte[] array = (byte[])null;
    }
    
    public byte delMonster(final int n) {
        final byte b = this.myMonsters[n].monster[0];
        byte b2;
        if (this.monsterRemove(n) != -1) {
            this.say("\u5931\u53bb\u5ba0\u7269\uff1a" + this.getNameMon((int)b), 0);
            b2 = 1;
        }
        else {
            this.say("\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01", 0);
            b2 = -1;
        }
        return b2;
    }
    
    public void deleteItems(int item, final int n) {
        final byte itemType = this.findItemType(item);
        item = this.findItem(itemType, item, false);
        if (item != -1) {
            if (this.items[itemType][item][1] >= n) {
                final byte[] array = this.items[itemType][item];
                array[1] -= (byte)n;
            }
            if (this.items[itemType][item][1] == 0) {
                this.dItemIn(itemType, item);
            }
        }
    }
    
    public void doPaint(final int n) {
        if (n != 0) {
            this.b_c = (byte)n;
        }
        else {
            GameRun.run_state = -10;
        }
        GameRun.mc.paint();
    }
    
    public void doSayOverSms() {
        final byte sayOverSms = this.sayOverSms;
        System.out.println("doSayOverSms() sayOverSms= " + this.sayOverSms);
        this.sayOverSms = -1;
        if (sayOverSms == 0) {
            GameRun.isSay = true;
            SMSSender.i(this).go(4, true);
            GameRun.isSay = false;
        }
        else if (sayOverSms == 1) {
            SMSSender.i(this).go(3, true);
        }
    }
    
    public boolean drawCartoonOne(final int n, final int n2, final int n3, final int n4, final int n5, final boolean b, final int n6) {
        if (this.now_action[n] >= this.mon[n2].aLength(n3)) {
            this.now_action[n] = 0;
        }
        Ui.i().drawFrameOne(this.mon[n2], this.mon[n2].action(n3, (int)this.now_action[n], 0), n4, n5, n6);
        return this.setCartoonFrame_C(n, n2, n3, b);
    }
    
    public void drawChangeMap(final boolean b, int n, final int n2, final int n3, final int n4) {
        n *= 2;
        if (b) {
            Ui.i().fillRect(5422575, 0, 0, 640, 360);
        }
        GameRun.g.setColor(0);
        GameRun.g.fillRect(n2, n3 + 1, n4, 5);
        GameRun.g.fillRect(n2 + 1, n3, n4 - 2, 7);
        GameRun.g.setColor(15400191);
        if ((n4 - 4) * n / 60 > n4) {
            GameRun.g.fillRect(n2 + 2, n3 + 1, n4, 5);
            GameRun.g.fillRect(n2 + 1, n3 + 2, n4, 3);
        }
        else {
            GameRun.g.fillRect(n2 + 2, n3 + 1, (n4 - 4) * n / 60, 5);
            GameRun.g.fillRect(n2 + 1, n3 + 2, (n4 - 2) * n / 60, 3);
        }
        if (b && Map.npcSp[1][0].img != null) {
            if ((n4 - 4) * n / 60 > n4) {
                this.map.drawMyAni(this.map.my, 0, n4, n3 + 10, 5);
            }
            else {
                this.map.drawMyAni(this.map.my, 0, n2 + (n4 - 4) * n / 60, n3 + 10, 5);
            }
        }
    }
    
    public void drawCityName() {
        final int n = Constants_H.WIDTH__ / 2;
        if (this.cityName_c != -20) {
            final short n2 = (short)(Ms.i().getStringWidth(this.city_name[this.map.mapNo].toString()) + 8);
            final Ui i = Ui.i();
            int cityName_c;
            if (this.cityName_c > 0) {
                cityName_c = 0;
            }
            else {
                cityName_c = this.cityName_c;
            }
            i.drawKuang(n - (n2 >> 1), cityName_c, n2, 25 + 6);
            final Ui j = Ui.i();
            final String string = this.city_name[this.map.mapNo].toString();
            int cityName_c2;
            if (this.cityName_c > 0) {
                cityName_c2 = 0;
            }
            else {
                cityName_c2 = this.cityName_c;
            }
            j.drawString(string, n, cityName_c2, 17, 4, 2);
            --this.cityName_c;
        }
    }
    
    public void drawEvolveUI(int n, final int n2, final boolean b) {
        Ui.i().fillRectB();
        this.drawBG0(this.bg_c, 200, 108, 5, 230);
        Label_0098: {
            if (n == 1 && this.b_c > 0) {
                if (this.b_c == 1) {
                    int n3;
                    if (5 == 5) {
                        n3 = 6;
                    }
                    else {
                        n3 = 1;
                    }
                    if (this.drawMagicC(5, 5, n3, 377, 97, 0)) {
                        this.initMonStream(2, this.mList_id[this.myMonsters[n2].monster[0]][0], 1);
                        this.b_c = 2;
                        break Label_0098;
                    }
                }
                if (this.b_c > 1 && this.b_c < 14) {
                    this.drawClipPic(this.mList_id[this.myMonsters[n2].monster[0]][1], 1, 377, 97, 80, 77, 15, this.b_c - 2, 0);
                    if (++this.b_c == 14) {
                        this.b_c = -1;
                        this.say("\u8fdb\u5316\u6210  " + this.getNameMon((int)this.myMonsters[n2].monster[0]), 0);
                    }
                }
            }
            else {
                this.drawCartoonOne(1, 1, this.mList_id[this.myMonsters[n2].monster[0]][1] * 3, 377 - this.move_x, 97 - this.move_y, true, 0);
            }
        }
        if (n == 1 && this.popMenu == 1) {
            this.drawEvolveMake(this.myMonsters[n2].monster[0], 200 + 25, 108 + 25 + 22, 28);
        }
        else {
            Ui.i().drawStringY(this.about_b, 200 + 25 - 16, 108 + 25 + 22, 0, 3, 40, 3, 0);
            Ui.i().drawStringY(this.about_a, 200 + 125 - 3, 108 + 25 + 22, 0, 3, 40, 3, 0);
        }
        if (n == 0) {
            this.move_y = 0;
            this.move_x = 0;
            final Ui i = Ui.i();
            final String string = String.valueOf(this.getNameMon(this.myMonsters[n2].monster[0])) + "\u5347\u5230\u4e86" + this.myMonsters[n2].monster[2] + "\u7ea7";
            final Graphics g = GameRun.g;
            final Graphics g2 = GameRun.g;
            i.drawString(string, 432, 108 + 4, 0x8 | 0x10, 1, 0);
            Ui.i().drawImage(this.imgItem[1], 200 - this.say_s, 108 - 4, 36);
            final byte[][] levelUp_in_battle = this.levelUp_in_battle;
            if (b) {
                n = n2;
            }
            else {
                n = this.myMonsters[n2].monster[1];
            }
            if (levelUp_in_battle[n][1] != -1) {
                final Ui j = Ui.i();
                final StringBuilder sb = new StringBuilder("\u4e60\u5f97\u6280\u80fd\uff1a");
                final byte[][] levelUp_in_battle2 = this.levelUp_in_battle;
                if (b) {
                    n = n2;
                }
                else {
                    n = this.myMonsters[n2].monster[1];
                }
                j.drawString(sb.append(this.getNameSkill(levelUp_in_battle2[n][1])).toString(), 320, 360 - 60, 17, 9, 0);
            }
        }
        else if (n == 1) {
            final Ui k = Ui.i();
            if (this.popMenu == 0) {
                n = -127;
            }
            else {
                n = 15;
            }
            k.drawK1(320 + n, 108 + 6, 113, 27, 4);
            final Ui l = Ui.i();
            if (this.popMenu == 0) {
                n = 0;
            }
            else {
                n = 1;
            }
            l.drawString("\u57fa\u672c\u5c5e\u6027", 320 - 75 + 4, 108 + 5, 17, n, 0);
            final Ui m = Ui.i();
            if (this.popMenu == 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            m.drawString("\u8fdb\u5316\u7d20\u6750", 320 + 75 - 4, 108 + 5, 17, n, 0);
            final byte selectMenuX = this.pkey.selectMenuX(2, 0, 108 + 5, 320, 33);
            if (selectMenuX != -1) {
                this.popMenu = selectMenuX;
            }
            Ui.i().drawTriangle(320, 108 + 15, 150, true, true);
            this.move_x = Ms.i().mathSpeedDown(this.move_x, 3, false);
            this.move_y = Ms.i().mathSpeedDown(this.move_y, 3, false);
            Ui.i().drawString("\u786e\u5b9a\u8fdb\u5316\u8be5\u5ba0\u7269\uff1f", 320, 360 - 25 - 22, 17, 0, 1);
        }
        Ui.i().drawYesNo(true, true);
    }
    
    public void drawFealty(final int n, final int n2, final int n3, final int n4) {
        for (int i = 0; i < n; i = (byte)(i + 1)) {
            final Ui j = Ui.i();
            int n5;
            if (i > n2) {
                n5 = 22;
            }
            else {
                n5 = 21;
            }
            j.drawUi(n5, i * 14 + n3, n4, 0, 0);
        }
    }
    
    public void drawItem(final int n, final int n2, final int n3, final int n4) {
        int n5;
        if (n >= 58) {
            n5 = this.monster_pro[this.nidusList[0][n - 58]][6] + 40;
        }
        else if ((n5 = n) >= 35) {
            n5 = this.makeLevel[n - 35] + 34;
        }
        Ui.i().drawRegion(this.item_img, this.item_modules[n5][0], this.item_modules[n5][1], this.item_modules[n5][2], this.item_modules[n5][3], n2, n3, n4, 0, GameRun.g);
    }
    
    public boolean drawMagicC(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        boolean setCartoonFrameMagic_C;
        if (this.now_action_Magic[n] >= this.magic[n2].aLength(n3)) {
            this.now_action_Magic[n] = 0;
            setCartoonFrameMagic_C = true;
        }
        else {
            short n7;
            for (n7 = (short)this.magic[n2].action(n3, this.now_action_Magic[n], 0); this.dm != null && n7 < 2; n7 = (short)this.magic[n2].action(n3, this.now_action_Magic[n], 0)) {
                if (n7 == 0) {
                    this.dm.ceff[0] = 2;
                }
                this.now_time_Magic[n] = 0;
                final short[] now_action_Magic = this.now_action_Magic;
                if (++now_action_Magic[n] >= this.magic[n2].aLength(n3)) {
                    this.now_action_Magic[n] = 0;
                    setCartoonFrameMagic_C = true;
                    return setCartoonFrameMagic_C;
                }
            }
            Ui.i().drawFrameOne(this.magic[n2], n7, n4, n5, n6);
            setCartoonFrameMagic_C = this.setCartoonFrameMagic_C(n, n2, n3, true);
        }
        return setCartoonFrameMagic_C;
    }
    
    public void drawMoney(final int n, final int n2, final int n3, final boolean b) {
        int i;
        if (b) {
            i = this.coin;
        }
        else {
            i = this.money;
        }
        final StringBuilder sb = new StringBuilder(String.valueOf(i));
        String str;
        if (b) {
            str = "\u5fbd\u7ae0";
        }
        else {
            str = "\u91d1";
        }
        final String string = sb.append(str).toString();
        final Ui j = Ui.i();
        int n4;
        if (b) {
            n4 = 53;
        }
        else {
            n4 = 52;
        }
        final int stringWidth = Ms.i().getStringWidth(string);
        final Graphics g = GameRun.g;
        final Graphics g2 = GameRun.g;
        j.drawUi(n4, n - (stringWidth >> 1) - 1, n2, 0x8 | 0x20, 0);
        final Ui k = Ui.i();
        final Graphics g3 = GameRun.g;
        final Graphics g4 = GameRun.g;
        k.drawString(string, n, n2 + 3, 0x1 | 0x20, n3, 1);
    }
    
    public void drawMyMon() {
        this.drawEffectImage(this.myB.getMon(), 220, 164);
        final byte b = this.mList_id[this.myB.getMon().monster[0]][1];
        final byte action = this.myB.action;
        int n;
        if (this.myB.ceff[0] != 0) {
            n = -3;
        }
        else {
            n = 0;
        }
        int n2;
        if (this.myB.ceff[0] != 0) {
            n2 = 3;
        }
        else {
            n2 = 0;
        }
        if (this.drawCartoonOne(1, 1, b * 3 + action, n + 266, n2 + 236, this.myB.action == 0, 1)) {
            if (this.myB.getMon().monsterPro[0] < 1) {
                this.myB.action = 2;
                this.myB.dead = 1;
            }
            else {
                this.myB.action = 0;
            }
        }
        this.myB.ceff[0] = (byte)Ms.i().mathSpeedN(this.myB.ceff[0], 0, 1, true);
        this.drawMonsterHp(this.myB.getMon(), 241, 237, 50, 0, 1, this.myB.chp);
        this.drawMonsterHp(this.myB.getMon(), 241, 242, 50, 1, 2, this.myB.getMon().monsterPro[1]);
        final Battle myB = this.myB;
        final Ms i = Ms.i();
        final short chp = this.myB.chp;
        final short n3 = this.myB.getMon().monsterPro[0];
        int n4;
        if (this.myB.chp < this.myB.getMon().monsterPro[0]) {
            n4 = 20;
        }
        else {
            n4 = 6;
        }
        myB.chp = i.mathSpeedN(chp, n3, n4, true);
    }
    
    public void drawPauseIco(int i) {
        for (i = 0; i < this.b_ico; i = (byte)(i + 1)) {
            Ui.i().drawImage(this.imgIco[i], this.pkey.button_pos[6][i][0], this.pkey.button_pos[6][i][1], 0);
        }
    }
    
    public void exitNidus() {
        GameRun.run_state = -10;
        this.mon[1] = null;
        this.initNidusMap(1);
    }
    
    public void falselly(final int n) {
        SMSSender.i(this).setSendSms(-1);
        Label_0043: {
            if (n != 7) {
                break Label_0043;
            }
            while (true) {
                try {
                    SMSSender.i(this).sms_a = true;
                    this.goGameOver();
                    System.out.println("ccccccccc");
                    GameRun.mc.setSmsIsSetRun_state(true);
                    return;
                    iftrue(Label_0085:)(n != 5);
                    GameRun.run_state = SMSSender.i(this).getTstate();
                    GameRun.mc.temp_state = GameRun.run_state;
                    GameRun.mc.setSmsIsSetRun_state(true);
                    return;
                }
                catch (final Exception ex) {
                    ex.printStackTrace();
                    return;
                }
                return;
                Label_0085: {
                    if (n == 6) {
                        GameRun.run_state = -10;
                        GameRun.mc.temp_state = GameRun.run_state;
                        GameRun.mc.setSmsIsSetRun_state(true);
                        System.out.println("  \u6211\u7684mc.setSmsIsSetRun_state(true);");
                        this.map.setRegState(false);
                        return;
                    }
                }
                if (n == 1 && SMSSender.i(this).getSmsSenderMenuState() != 0) {
                    Log.d("soars", "soooooooooooooooooooooooooooooooooooooooo");
                    GameRun.mc.setSmsIsSetRun_state(true);
                    GameRun.run_state = SMSSender.i(this).getTstate();
                }
            }
        }
    }
    
    public byte findItem(int n, final int n2, final boolean b) {
        byte b3;
        final byte b2 = b3 = 0;
        int itemType = n;
        if (n == -2) {
            itemType = this.findItemType(n2);
            b3 = b2;
        }
        while (b3 < this.itemsLength[itemType]) {
            if (this.items[itemType][b3][0] == n2) {
                if (b) {
                    b3 = this.items[itemType][b3][1];
                }
                return b3;
            }
            ++b3;
        }
        if (b) {
            n = 0;
        }
        else {
            n = -1;
        }
        b3 = (byte)n;
        return b3;
    }
    
    public byte findItemType(final int n) {
        byte b;
        if (n < 16) {
            b = 0;
        }
        else if (n < 35) {
            b = 1;
        }
        else if (n < 58) {
            b = 2;
        }
        else {
            b = 3;
        }
        return b;
    }
    
    public byte findMonster(final int n, final int n2) {
        for (byte b = 0; b < this.myMon_length; ++b) {
            if (this.myMonsters[b].monster[0] == n && this.myMonsters[b].monster[2] >= n2) {
                return b;
            }
        }
        return -1;
    }
    
    public byte findMonsterMinLv(final int n, final int n2) {
        byte b = -1;
        byte b3;
        for (byte b2 = (byte)(this.myMon_length - 1); b2 > -1; --b2, b = b3) {
            b3 = b;
            if (this.myMonsters[b2].monster[0] == n) {
                b3 = b;
                if (this.myMonsters[b2].monster[2] >= n2) {
                    if (b != -1) {
                        b3 = b;
                        if (this.myMonsters[b2].monster[2] >= this.myMonsters[b].monster[2]) {
                            continue;
                        }
                    }
                    b3 = b2;
                }
            }
        }
        return b;
    }
    
    public boolean gameCheckRegIsOK() {
        final boolean b = this.rmsSms[6] == 10;
        System.out.println("gameCheckRegIsOK reged= " + b);
        return b;
    }
    
    public void getEnemy(final byte[] array, int n, final int n2) {
        if (n == -1) {
            Ms.i();
            if (Ms.getRandom(100) < 5 && this.monPro.length > 6) {
                n = 6;
            }
            else {
                final byte[] monPro = this.monPro;
                Ms.i();
                if (this.monPro.length > 6) {
                    n = 3;
                }
                else {
                    n = this.monPro.length - 3;
                }
                n = monPro[Ms.getRandom(n) + 3];
            }
            Ms.i();
            array[1] = (byte)(Ms.getRandom(this.monPro[2] + 1) + this.monPro[1]);
        }
        else {
            array[1] = (byte)n2;
        }
        array[0] = (byte)n;
    }
    
    public byte getItem(final int n, final int i) {
        byte b;
        if (this.addItem(n, i) == 1) {
            this.say("\u83b7\u5f97\uff1a\u201c" + this.getNameItem((int)n) + "\u201dx" + i, 0);
            b = 1;
        }
        else {
            b = -1;
        }
        return b;
    }
    
    public byte getItemCount(final int n) {
        if (this.buyItemID != 2) {
            this.findItemType(n);
            for (int i = 0; i < this.items[this.item_type].length; ++i) {
                if (this.items[this.item_type][i][0] == n) {
                    return this.items[this.item_type][i][1];
                }
            }
        }
        return 0;
    }
    
    public void getMagic(final Monster monster) {
        final byte[] array = { 0, 7, 14, 21, 28, 35 };
        this.getSkill = -1;
        for (int i = 0; i < array.length; i = (byte)(i + 1)) {
            if (monster.monster[i + 8] == -1 && monster.monster[2] >= array[i]) {
                this.getSkill(i, monster.monster[3]);
                monster.monster[i + 8] = this.getSkill;
            }
        }
    }
    
    public byte getMonster(final int n, final int n2, final int n3, final int n4) {
        final Monster monster = new Monster(this, n, n2, n4);
        byte b;
        if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
            this.say("\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1", 0);
            b = -1;
        }
        else {
            if (this.getMonster(monster, n3, true) != 1) {
                this.say("\u83b7\u5f97\u5ba0\u7269\uff1a" + this.getNameMon((int)n), 0);
            }
            else {
                this.say("\u643a\u5e26\u5df2\u6ee1\uff0c" + this.getNameMon((int)monster.monster[0]) + "\u5df2\u8f6c\u5165\u5bc4\u653e\u5904", 0);
            }
            b = 1;
        }
        return b;
    }
    
    public String getNameCity(final int n) {
        return this.city_name[n].toString();
    }
    
    public String getNameItem(final int n) {
        return this.item_name[n].toString();
    }
    
    public String getNameMon(final int n) {
        return this.NAME[n].toString();
    }
    
    public String getNameMonsterInfo(final int n) {
        return this.monsterInfo[n].toString();
    }
    
    public void goBUY_ITEM(final int n, final int n2) {
        if (n2 != 1) {
            this.setAction_str(new String[] { "\u9053\u5177", "\u77ff\u77f3", "\u5fbd\u7ae0" });
        }
        else {
            this.setAction_str(new String[] { "\u9053\u5177", "\u8f85\u52a9", "\u5377\u8f74" });
        }
        this.cur_a = (byte)n;
        this.cur_b = (byte)n2;
        this.select[0][1] = (this.select[0][0] = 0);
        GameRun.run_state = 18;
        this.list_rows = 6;
        this.buyOk = 0;
        this.popMenu = -1;
        final byte[] stream = Ms.i().getStream("data/shop.d", -1);
        Ms.i();
        Ms.skip = 0;
        this.buyItem = Ms.i().create2Array(stream);
        this.buyPrice = Ms.i().createShort2Array(stream, 0);
        final byte[] array = (byte[])null;
    }
    
    public void goBattle() {
        this.first_battle = 0;
        this.lastSkill = 0;
        this.b_c = 0;
        this.cur_a = 0;
        this.mon_in_battle = null;
        this.mon_in_battle = new byte[this.max_takes + 1];
        this.levelUp_in_battle = null;
        this.levelUp_in_battle = new byte[this.max_takes][2];
        this.proReplace = null;
        this.proReplace = new short[this.myMonsters.length][7];
        this.myB = new Battle(this.myMonsters);
        this.enemy_init();
        for (byte b = 0; b < this.myMon_length; ++b) {
            this.myMonsters[b].effect = 7;
            this.myMonsters[b].effect_time = 0;
            this.myMonsters[b].monster[1] = b;
            this.proReplace[b][6] = this.myMonsters[b].monster[2];
        }
        byte b2 = 0;
        while (b2 < this.myMon_length) {
            if (this.myMonsters[b2].monsterPro[0] > 0) {
                final byte[] mon_in_battle = this.mon_in_battle;
                final byte[] mon_in_battle2 = this.mon_in_battle;
                mon_in_battle[++mon_in_battle2[0]] = this.myMonsters[b2].monster[1];
                if (b2 != 0) {
                    this.changeMonster(this.myMonsters[b2], this.myMonsters[0]);
                    break;
                }
                break;
            }
            else {
                ++b2;
            }
        }
        if (this.effectImage == null) {
            this.effectImage = Ms.i().createImageArray(7, "data/brow/e");
        }
        if (this.imgBattle == null) {
            this.imgBattle = Ms.i().createImageArray(5, "data/battle/b");
        }
        this.map.my.state = 15;
        GameRun.run_state = -30;
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
        GameRun.run_state = 60;
    }
    
    public void goMAIN_MENU() {
        GameRun.mc.logo_c = 29;
        GameRun.mc.image_logo = null;
        this.setNull(true);
        this.myMonsters = null;
        this.cMonsters = null;
        System.gc();
        GameRun.mc.createFlashImage();
        GameRun.mc.goMain_menu();
        this.setAction_str(new String[] { "\u8bfb\u53d6\u8fdb\u5ea6", "\u65b0\u6e38\u620f", "\u58f0\u97f3", "\u6e38\u620f\u5e2e\u52a9", "\u5173   \u4e8e", "\u9000\u51fa\u6e38\u620f" });
        boolean b;
        if (this.rmsOther[0] == -1) {
            b = true;
        }
        else {
            b = false;
        }
        final byte b2 = (byte)(b ? 1 : 0);
        this.selecty = b2;
        this.selectx = b2;
    }
    
    public void goNidus(final int n) {
        GameRun.run_state = 66;
        this.mini_state = 16;
        this.setStringB("\u67e5\u770b\u5b75\u5316#n\u9009\u62e9\u86cb#n\u79bb\u5f00", Constants_H.WIDTH, 3);
        this.popMenu = (byte)n;
        this.b_c = -2;
    }
    
    public void goVIEW_COMPUTER(final int n) {
        GameRun.run_state = 65;
        this.setStringB("\u5b58\u653e#n\u53d6\u51fa#n\u79bb\u5f00", Constants_H.WIDTH, 3);
        this.popMenu = (byte)n;
    }
    
    public void goVIEW_MONSTER() {
        GameRun.run_state = 35;
        this.cur_c = 0;
        this.selecty = 0;
        this.selectx = 0;
        byte t_length;
        if (this.mini_state == 6) {
            t_length = this.cMon_count;
        }
        else {
            t_length = this.myMon_length;
        }
        this.t_length = t_length;
        this.select[0][0] = (this.select[0][1] = 0);
        this.popMenu = -1;
        this.list_rows = 5;
        this.mon_action = 0;
        this.setStringB("\u751f\u547d#n\u80fd\u91cf#n\u6863\u6b21", Constants_H.WIDTH, 0);
        this.setStringB("\u529b\u91cf#n\u9632\u5fa1#n\u654f\u6377", Constants_H.WIDTH, 1);
        Monster cur_mon;
        if (this.mini_state == 6) {
            cur_mon = this.cMonsters[this.select[0][0]];
        }
        else {
            cur_mon = this.myMonsters[this.select[0][0]];
        }
        this.cur_mon = cur_mon;
        if (this.t_length != 0) {
            this.setShowPro(this.cur_mon);
            this.initMonStream(2, this.mList_id[this.cur_mon.monster[0]][0], 1);
        }
    }
    
    public void goYouPAUSE(final int n) {
        GameRun.run_state = 97;
        this.selectx = 0;
        this.selecty = (byte)n;
        this.setPauseS(0);
        Sound.i().soundStop();
        this.say_c = 0;
        this.view_state = 1;
        this.mini_state = 3;
        this.buyItemID = 0;
        this.buyOk = 0;
        this.gogoString = "\u91d1\u5c5e\u514b\u91ce\u517d\uff0c\u91ce\u517d\u514b\u690d\u7269\uff0c\u690d\u7269\u514b\u98de\u884c\uff0c\u98de\u884c\u514b\u6d77\u6d0b\uff0c\u6d77\u6d0b\u514b\u91d1\u5c5e";
    }
    
    void healMonster(final Monster monster) {
        monster.effect = 7;
        monster.monsterPro[1] = monster.monsterPro[3];
        monster.monsterPro[0] = monster.monsterPro[2];
    }
    
    public void healMonster(final boolean b) {
        for (byte b2 = 0; b2 < this.myMon_length; ++b2) {
            this.healMonster(this.myMonsters[b2]);
        }
        if (b) {
            this.say("\u60a8\u643a\u5e26\u7684\u5ba0\u7269\u5df2\u56de\u590d\u3002", 0);
        }
    }
    
    public void initBattle() {
        System.gc();
        final byte[] src_c = this.src_c;
        final byte[] src_c2 = this.src_c;
        this.src_c[2] = (this.src_c[3] = 0);
        src_c[0] = (src_c2[1] = 0);
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
    
    public void initMonPro(final int i, final boolean b) {
        Ms.i();
        Ms.skip = 0;
        final Ms j = Ms.i();
        final StringBuilder sb = new StringBuilder("data/map/");
        String str;
        if (b) {
            str = "m";
        }
        else {
            str = "boss";
        }
        final byte[] stream = j.getStream(sb.append(str).append(i).append(".d").toString(), -1);
        this.monPro = Ms.i().createArray(stream);
        this.mapMove = Ms.i().createArray(stream);
        this.mapRect = Ms.i().create2Array(stream);
    }
    
    public void initMonStream(final int i, final int j, final int n) {
        final String string = "data/npc" + i + "/" + j;
        boolean npc2ImageType = true;
        if (i == 2) {
            npc2ImageType = this.isNpc2ImageType(j);
        }
        if (this.mon[n] == null) {
            this.mon[n] = Ms.i().createSprite(string, npc2ImageType);
        }
        else {
            Ms.i().setSprite(this.mon[n], string, npc2ImageType);
        }
    }
    
    public void initNidusMap(int i) {
        if (this.nidusMap == null) {
            this.nidusMap = new byte[5];
        }
        int j = 0;
        final int n = 0;
        if (i == 0) {
            for (i = n; i < this.nidusMap.length; i = (byte)(i + 1)) {
                this.nidusMap[i] = -1;
            }
        }
        else {
            while (j < this.nidusMap.length) {
                if (this.nidusMap[j] != -1) {
                    if (this.getRid(j) != -2) {
                        this.map.npc[0][this.nidusMap[j]].other[4] = 1;
                        this.map.npc[0][this.nidusMap[j]].other[7] = (byte)(this.monster_pro[this.getNid(j)][6] + 17);
                    }
                    else {
                        this.map.npc[0][this.nidusMap[j]].other[4] = 0;
                    }
                }
                j = (byte)(j + 1);
            }
        }
    }
    
    public void initSkillList(final Monster monster) {
        this.skill_list[8] = 0;
        for (int i = 7; i > -1; i = (byte)(i - 1)) {
            this.skill_list[i] = monster.monster[i + 8];
            if (this.skill_list[i] != -1) {
                final byte[] skill_list = this.skill_list;
                ++skill_list[8];
            }
        }
        for (int j = 1; j < 8; j = (byte)(j + 1)) {
            for (int n = j; n > 0 && this.skill_list[n] > this.skill_list[n - 1]; n = (byte)(n - 1)) {
                final byte b = this.skill_list[n];
                this.skill_list[n] = this.skill_list[n - 1];
                this.skill_list[n - 1] = b;
            }
        }
    }
    
    public boolean isMoney(final int n, final boolean b) {
        boolean b2;
        if (b) {
            if (this.money < n) {
                this.say("\u91d1\u94b1\u4e0d\u8db3\uff01", 0);
                return false;
            }
            this.money -= n;
            b2 = true;
        }
        else {
            if (this.coin < n) {
                this.say("\u5fbd\u7ae0\u4e0d\u8db3\uff01", 0);
                return false;
            }
            this.coin -= n;
            b2 = true;
        }
        return b2;
        b2 = false;
        return b2;
    }
    
    public boolean isMoneyItem(final int n, final int n2, final int n3, final boolean b) {
        boolean b2;
        if (this.findItem(-2, n2, true) + n3 > 99) {
            this.say("\u6570\u91cf\u5df2\u5230\u4e0a\u9650", 0);
            b2 = false;
        }
        else {
            if (b) {
                if (this.money >= this.sell_money * n3) {
                    this.money -= this.sell_money * n3;
                    b2 = true;
                    return b2;
                }
                if (this.money < this.sell_money * n3) {
                    this.say("\u91d1\u94b1\u4e0d\u8db3\uff01", -1, 0);
                }
                else {
                    this.say("\u80cc\u5305\u7a7a\u95f4\u4e0d\u8db3\u3002", 0, -1);
                }
            }
            else {
                if (this.coin >= this.sell_money * n3) {
                    this.coin -= this.sell_money * n3;
                    b2 = true;
                    return b2;
                }
                if (this.coin < this.sell_money * n3) {
                    this.say("\u5fbd\u7ae0\u4e0d\u8db3\uff01", 0);
                }
                else {
                    this.say("\u80cc\u5305\u7a7a\u95f4\u4e0d\u8db3\u3002", 0);
                }
            }
            b2 = false;
        }
        return b2;
    }
    
    public boolean isNpc2ImageType(final int n) {
        for (int i = 0; i < this.npc2ImageType.length; i = (byte)(i + 1)) {
            if (this.npc2ImageType[i] == n) {
                return false;
            }
        }
        return true;
    }
    
    public void keyGameOver1(final boolean b) {
        if (Ms.i().key_S1_Num5()) {
            if (this.popMenu == 1) {
                this.goMAIN_MENU();
            }
            else if (this.popMenu == 0) {
                System.out.println("loadGame soars");
                this.loadGame();
            }
            this.popMenu = -1;
        }
        else if (Ms.i().key_Up_Down()) {
            this.popMenu ^= 0x1;
        }
        Ms.i().keyRelease();
    }
    
    public void keyLIST_INFO() {
        if (!Ms.i().key_delay()) {
            if (Ms.i().key_S1_Num5()) {
                if (this.monInfoList[this.getMonInfo_dir()] != 0) {
                    this.goMONSTER_INFO(this.getMonInfo_dir());
                }
            }
            else if (Ms.i().key_S2()) {
                this.action_str = null;
                this.monInfo_dir = null;
                this.doPaint(0);
                this.goYouPAUSE(3);
            }
            else if (Ms.i().key_Left_Right()) {
                this.cur_a = Ms.i().select(this.cur_a, 0, 4);
                this.infoStart = 0;
                if (this.cur_a > 0) {
                    for (byte b = 0; b < this.cur_a; ++b) {
                        this.infoStart += (byte)this.monInfo_dir[b].length;
                    }
                }
                this.t_length = (byte)this.monInfo_dir[this.cur_a].length;
                this.select[0][0] = (this.select[0][1] = 0);
            }
            else if (Ms.i().key_Up_Down()) {
                Ms.i().selectS(this.select[0], 0, this.t_length, this.list_rows);
            }
        }
    }
    
    public void key_gameRun() {
        if (GameRun.run_state == 98) {
            if (Ms.i().key_Num0() || Ms.i().key_S1_Num5()) {
                GameRun.mc.doShowNotify();
            }
            Ms.i().keyRelease();
            Log.d("soars", "doShowNotify2");
        }
        else if (this.say_c > 0) {
            Ms.i().keyRelease();
        }
        else if (this.say_c < 0) {
            if (this.say_s == 0 && Ms.i().key_S1_Num5()) {
                this.say_c = 0;
                this.doSayOverSms();
            }
            Ms.i().keyRelease();
        }
        else {
            switch (GameRun.run_state) {
                case -10: {
                    this.map.key_map();
                    break;
                }
                case -31: {
                    this.keyBattleState();
                    break;
                }
                case -15: {
                    if (Ms.i().key_delay()) {
                        return;
                    }
                    if (this.b_c == 1 && this.say_s == 0) {
                        this.b_c = 0;
                        break;
                    }
                    break;
                }
                case 61: {
                    this.keyGameOver1(true);
                    break;
                }
                case 60: {
                    Ms.i().keyRelease();
                    GameRun.run_state = 61;
                    this.setAction_str(new String[] { "\u7ee7\u7eed", "\u653e\u5f03" });
                    this.popMenu = 0;
                    break;
                }
                case 67: {
                    if (Ms.i().key_S2()) {
                        this.goLIST_INFO(false);
                        Ms.i().keyRelease();
                        break;
                    }
                    break;
                }
                case 68: {
                    this.keyLIST_INFO();
                    break;
                }
                case 97: {
                    if (Ms.i().key_delay()) {
                        return;
                    }
                    if (Ms.i().key_S1_Num5()) {
                        Ms.i().keyRelease();
                        if (this.selectx == 0) {
                            if (this.selecty == 0) {
                                if (this.buyOk == 1) {
                                    GameRun.run_state = 100;
                                    this.b_c = 0;
                                    this.buyOk = 0;
                                    break;
                                }
                                this.buyOk = 1;
                                break;
                            }
                            else {
                                if (this.selecty == 1) {
                                    this.goVIEW_MONSTER();
                                    break;
                                }
                                if (this.selecty == 2) {
                                    this.goMY_BAG(0);
                                    break;
                                }
                                if (this.selecty == 3) {
                                    this.goLIST_INFO(true);
                                    break;
                                }
                                if (this.selecty == 4) {
                                    this.map.goMission(0, true);
                                    break;
                                }
                                if (this.selecty == 5) {
                                    this.goRUN_IN_MAP(true);
                                    this.action_str = null;
                                    break;
                                }
                                break;
                            }
                        }
                        else if (this.selecty == 0) {
                            if (this.buyOk == 2) {
                                this.loadGame();
                                break;
                            }
                            this.buyOk = 2;
                            break;
                        }
                        else {
                            if (this.selecty == 1) {
                                this.isChangeSound = Boolean.valueOf(true);
                                Sound.i().keyVolume(0);
                                break;
                            }
                            if (this.selecty == 2) {
                                GameRun.mc.goHELP_dialog(1);
                                break;
                            }
                            if (this.selecty != 3) {
                                break;
                            }
                            if (this.buyOk == 3) {
                                GameRun.run_state = 0;
                                this.action_str = null;
                                this.goMAIN_MENU();
                                this.buyOk = 0;
                                break;
                            }
                            this.buyOk = 3;
                            break;
                        }
                    }
                    else if (Ms.i().key_S2()) {
                        if (this.buyOk == 0) {
                            this.action_str = null;
                            this.goRUN_IN_MAP(true);
                            break;
                        }
                        this.doPaint(0);
                        GameRun.run_state = 97;
                        this.buyOk = 0;
                        break;
                    }
                    else {
                        if (this.buyOk != 0) {
                            break;
                        }
                        if (Ms.i().key_Left_Right()) {
                            this.selectx ^= 0x1;
                            this.selecty = 0;
                            this.setPauseS(this.selectx);
                            break;
                        }
                        if (Ms.i().key_Up_Down()) {
                            this.selecty = Ms.i().select(this.selecty, 0, this.action_str.length - 1);
                            break;
                        }
                        break;
                    }
                    break;
                }
                case 51: {
                    if (Ms.i().key_Num0()) {
                        this.map.my.state = 0;
                        this.map.eventGoing = 2;
                        Ms.i().keyRelease();
                        this.map.dialog_no = -1;
                        this.goGO_RUNINMAP();
                        break;
                    }
                    break;
                }
                case 35: {
                    if (Ms.i().key_delay()) {
                        return;
                    }
                    if (this.cur_c == 0) {
                        Monster[] array;
                        if (this.mini_state == 6) {
                            array = this.cMonsters;
                        }
                        else {
                            array = this.myMonsters;
                        }
                        this.key_MONSTER_LIST(array);
                        break;
                    }
                    if (this.cur_c == 1) {
                        this.keyMagicUI();
                        break;
                    }
                    if (this.cur_c == 2) {
                        this.keyEvolveUI();
                        break;
                    }
                    break;
                }
                case 65: {
                    if (!Ms.i().key_delay()) {
                        this.popState();
                        break;
                    }
                    return;
                }
                case 66: {
                    this.keyNidus();
                    break;
                }
                case 25: {
                    this.keyMY_BAG();
                    break;
                }
                case 18: {
                    this.keyBuyItem();
                    break;
                }
                case 69: {
                    Mg.i().key(this);
                    break;
                }
                case -20: {
                    SMSSender.i(this).key();
                    break;
                }
                case -21: {
                    SMSSender.i(this).keyLevel();
                    Sound.i().soundStop();
                    break;
                }
            }
            if (Ms.i().key_S1_Num5() || Ms.i().key_S2()) {
                Ms.i().keyRelease();
            }
        }
    }
    
    public void levelPro(final int n, final boolean b) {
        if (b) {
            final byte b2 = (byte)this.proReplace[n][6];
            final byte[] array = this.monster_pro[this.myMonsters[n].monster[0]];
            this.proReplace[n][0] = (short)(this.myMonsters[n].monsterPro[2] - this.getbuffRateV(this.myMonsters[n], array[0] + array[7] * b2 / 10));
            this.proReplace[n][1] = (short)(this.myMonsters[n].monsterPro[3] - (short)(array[1] + array[8] * b2 / 10));
            this.proReplace[n][3] = (short)(this.myMonsters[n].monsterPro[6] - (short)(array[3] + array[10] * b2 / 10));
            this.proReplace[n][4] = (short)(this.myMonsters[n].monsterPro[7] - (short)(array[4] + array[11] * b2 / 10));
            this.proReplace[n][5] = (short)(this.myMonsters[n].monsterPro[5] - (short)(array[2] + array[9] * b2 / 10));
            final byte[] array2 = (byte[])null;
        }
        else {
            final byte[] monster = this.myMonsters[n].monster;
            final byte b3 = (byte)(monster[2] + 1);
            monster[2] = b3;
            final byte[] array3 = this.monster_pro[this.myMonsters[n].monster[0]];
            this.myMonsters[n].monsterPro[2] = (short)(array3[0] + array3[7] * b3 / 10);
            this.myMonsters[n].monsterPro[3] = (short)(array3[1] + array3[8] * b3 / 10);
            this.myMonsters[n].monsterPro[6] = (byte)(array3[3] + array3[10] * b3 / 10);
            this.myMonsters[n].monsterPro[7] = (byte)(array3[4] + array3[11] * b3 / 10);
            this.myMonsters[n].monsterPro[5] = (byte)(array3[2] + array3[9] * b3 / 10);
            this.myMonsters[n].resetPro(this);
            final byte[] array4 = (byte[])null;
            this.healMonster(this.myMonsters[n]);
        }
    }
    
    public void map_flashString() {
        final int width__ = Constants_H.WIDTH__;
        final int height__ = Constants_H.HEIGHT__;
        final int n = Constants_H.HEIGHT__ / 2;
        this.setSay();
        if (this.say_c > 0 && GameRun.run_state != 98) {
            if (!this.map.fontSizeControl) {
                Ms.i();
                Ms.font.setSize(22);
            }
            final StringBuffer[] showS = this.showS;
            int n2;
            if (this.say_mode == 0) {
                n2 = n - (this.showS.length >> 1) * 25 - 12;
            }
            else {
                n2 = height__ - 50 - 18;
            }
            this.showString(showS, n2, this.say_s, 1);
            if (this.say_s == 0) {
                --this.say_c;
            }
            else {
                this.say_s = Ms.i().mathSpeedDown(this.say_s, 3, true);
            }
        }
        else if (this.say_c < 0 && GameRun.run_state != 98) {
            Ms.i();
            Ms.font.setSize(22);
            this.showString(this.showS, n - (this.showS.length >> 1) * 25 - 12, this.say_s, 2);
            if (this.say_s != 0) {
                this.say_s = Ms.i().mathSpeedDown(this.say_s, 3, true);
            }
            if (this.pkey.isSelect(0, 0, width__, height__)) {
                this.pkey.setKey5();
            }
        }
        Ms.i();
        Ms.font.setSize(26);
    }
    
    public void paint_gameRun(final Graphics graphics) {
        switch (GameRun.run_state) {
            case -10: {
                this.map.paint_map(graphics);
                break;
            }
            case -50: {
                this.drawBattleBG();
                this.drawSelectMenu(graphics, true, 252);
                this.drawSrcLine(graphics, 15, 124, 10, false, this.src_c[2] == 0);
                this.drawSrcLine(graphics, 131, 124, 10, true, this.src_c[3] == 0);
                this.drawPlayerAppear(graphics);
                break;
            }
            case -31: {
                this.drawBattleBG();
                this.drawPlayer(graphics);
                this.drawSelectMenu(graphics, this.battle_state != 2, 252);
                this.paintBattleState(graphics);
                break;
            }
            case -19: {
                this.drawBattleBG();
                this.drawSelectMenu(graphics, true, 252);
                this.drawMyMon();
                this.drawEnemy();
                if (this.cThrowY < 17) {
                    this.cThrowS += this.cThrowY;
                    this.cThrowY = Ms.i().mathSpeedN(this.cThrowY, 17, 2, false);
                }
                this.cThrowX = Ms.i().mathSpeedN(this.cThrowX, 0, 8, false);
                Ui.i().drawImage(this.imgItem[0], 377 - this.cThrowX, this.cThrowS, 0x1 | 0x20);
                break;
            }
            case -15: {
                this.paintBATTLE_OVER();
                break;
            }
            case 97: {
                Ui.i().drawK0(-2, 0, 640 + 4, 33, 0);
                Ui.i().drawString("\u8bad\u7ec3\u5e08\u7b49\u7ea7\uff1a" + this.rmsOther[3], 320, 2, 17, 1, 2);
                this.drawPauseMenu(320 - 100 - 5, 45, 210, 235);
                Ui.i().drawK0(-2, 360 - 25 - 8, 640 + 4, 33, 0);
                this.gogoWordM(this.gogoString, 360 - 25 - 6, 16, 3, 0, 2);
                if (this.buyOk != 0) {
                    String s = "\u662f\u5426\u4fdd\u5b58\u6e38\u620f?";
                    if (this.buyOk == 2) {
                        s = "\u662f\u5426\u8bfb\u53d6\u8fdb\u5ea6?";
                    }
                    else if (this.buyOk == 3) {
                        s = "\u4e4b\u524d\u672a\u4fdd\u5b58\u7684\u90e8\u5206\u5c06\u4f1a\u4e22\u5931\uff0c\u662f\u5426\u7ee7\u7eed\uff1f";
                    }
                    this.showString(s, 60, 0);
                }
                Ui.i().drawYesNo(true, true);
                break;
            }
            case 61: {
                GameRun.mc.drawRectBG();
                this.showString("\u4f60\u8981\u7ee7\u7eed\u6e38\u620f\uff0c\u786e\u5b9a\u5417\uff1f", 360 - 50, 0);
                this.drawSelectMenu(this.action_str, 320 - 50, 180 - 50, 100, 2, 0, this.popMenu);
                break;
            }
            case 60: {
                GameRun.mc.drawRectBG();
                this.showString("\u6218\u6597\u5931\u8d25\u4e86,\u8bad\u7ec3\u5e08\u7684\u68a6\u60f3\u4e0d\u80fd\u5b9e\u73b0\u4e86!", 180, 0);
                Ui.i().drawYesNo(true, true);
                break;
            }
            case 98: {
                GameRun.mc.drawRectBG();
                Ui.i().drawK1(-5, 360 - 75, 640 + 10, 75, 3);
                this.showStringM("\u6e38\u620f\u6682\u505c\uff0c\u70b9\u51fb\u5c4f\u5e55\u8fd4\u56de\u3002", 320, 360 - 50 - 2, 9, 3);
                break;
            }
            case -30: {
                this.drawDarkScreen();
                break;
            }
            case 100: {
                this.b_c = 1;
                this.showString("\u4fdd\u5b58\u6e38\u620f\u4e2d", 20, 0);
                break;
            }
            case 51: {
                this.map.drawBlackSRC(graphics, 30, true);
                this.drawZero("\u7ed3\u675f", 360 - 10);
                break;
            }
            case 25: {
                this.drawMY_BAG(0, 0, 640, 360);
                break;
            }
            case 18: {
                this.drawBUY_ITEM();
                break;
            }
            case 68: {
                this.drawLIST_INFO();
                break;
            }
            case 67: {
                this.drawMONSTER_INFO(this.getMonInfo_dir());
                break;
            }
            case 35: {
                if (this.cur_c == 0) {
                    Monster[] array;
                    if (this.mini_state == 6) {
                        array = this.cMonsters;
                    }
                    else {
                        array = this.myMonsters;
                    }
                    this.drawMONSTER_UI(array);
                    break;
                }
                if (this.cur_c == 1) {
                    Monster monster;
                    if (this.mini_state == 6) {
                        monster = this.cMonsters[this.selecty];
                    }
                    else {
                        monster = this.myMonsters[this.selecty];
                    }
                    this.drawMagicUI(monster);
                    break;
                }
                if (this.cur_c == 2) {
                    this.drawEvolveUI(1, this.selecty, false);
                    break;
                }
                break;
            }
            case 65: {
                this.drawVIEW_COMPUTER();
                break;
            }
            case 66: {
                this.drawNidus(200, 225);
                break;
            }
            case 69: {
                Mg.i().paint();
                break;
            }
            case -20: {
                SMSSender.i(this).paint();
                break;
            }
            case -21: {
                SMSSender.i(this).paintLevel();
                break;
            }
        }
        this.map_flashString();
    }
    
    public void popState() {
        if (this.buyOk == 0 && Ms.i().key_Up_Down()) {
            this.popMenu = Ms.i().select(this.popMenu, 0, this.about_d.length - 1);
        }
        else if (Ms.i().key_S1_Num5()) {
            if (Ms.i().equals(this.about_d[this.popMenu], "\u6280\u80fd") || Ms.i().equals(this.about_d[this.popMenu], "\u5929\u8d4b")) {
                Monster monster;
                if (this.mini_state == 6) {
                    monster = this.cMonsters[this.select[0][0]];
                }
                else {
                    monster = this.myMonsters[this.select[0][0]];
                }
                this.initSkillList(monster);
                if (this.view_state > 0) {
                    byte bg_c;
                    if (this.mini_state == 6) {
                        bg_c = this.cMonsters[this.select[0][0]].monster[3];
                    }
                    else {
                        bg_c = this.myMonsters[this.select[0][0]].monster[3];
                    }
                    this.bg_c = bg_c;
                }
                else if (this.view_state < 0 && this.myB != null) {
                    this.bg_c = this.myB.bg_id;
                }
                int n;
                if (Ms.i().equals(this.about_d[this.popMenu], "\u6280\u80fd")) {
                    n = 0;
                }
                else {
                    n = 1;
                }
                this.restMove(1, n);
            }
            else if (Ms.i().equals(this.about_d[this.popMenu], "\u53c2\u6218")) {
                if (this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
                    if (this.view_state < 0) {
                        for (byte b = 1; b <= this.mon_in_battle[0] && this.mon_in_battle[b] != this.myMonsters[this.select[0][0]].monster[1]; ++b) {
                            if (b == this.mon_in_battle[0]) {
                                final byte[] mon_in_battle = this.mon_in_battle;
                                final byte[] mon_in_battle2 = this.mon_in_battle;
                                mon_in_battle[++mon_in_battle2[0]] = this.myMonsters[this.select[0][0]].monster[1];
                            }
                        }
                        this.initSkillList(this.myMonsters[this.select[0][0]]);
                    }
                    this.changeMonster(this.myMonsters[this.select[0][0]], this.myMonsters[0]);
                    this.initMonStream(2, this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0], 1);
                    this.setShowPro(this.myMonsters[this.select[0][0]]);
                    if (this.view_state < 0) {
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
                }
                else {
                    this.say("\u5f53\u524d\u5ba0\u7269\u4e0d\u80fd\u53c2\u6218", 0);
                }
                this.popMenu = -1;
            }
            else if (Ms.i().equals(this.about_d[this.popMenu], "\u8fdb\u5316")) {
                this.setEvolveStringB(this.myMonsters[this.select[0][0]]);
                this.bg_c = this.myMonsters[this.select[0][0]].monster[3];
                this.b_c = 0;
                this.restMove(2, 0);
            }
            else if (Ms.i().equals(this.about_d[this.popMenu], "\u653e\u751f")) {
                if (!this.isMyMonsters(this.select[0][0])) {
                    this.say("\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01", 0);
                }
                else if (this.buyOk == 1) {
                    this.buyOk = 0;
                    this.delMonster(this.select[0][0]);
                    if (this.select[0][0] == this.myMon_length) {
                        final byte[] array = this.select[0];
                        --array[0];
                    }
                    this.initMonStream(2, this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0], 1);
                    this.setShowPro(this.myMonsters[this.select[0][0]]);
                    this.introT = Constants_H.WIDTH_H;
                    this.t_length = this.myMon_length;
                    this.popMenu = -1;
                }
                else {
                    this.buyOk = 1;
                    this.gogoString = "\u653e\u751f\u7684\u5ba0\u7269\u5c06\u4f1a\u6d88\u5931\uff0c\u662f\u5426\u7ee7\u7eed\uff1f";
                }
            }
            else if (Ms.i().equals(this.about_d[this.popMenu], "\u5b58\u653e")) {
                if (GameRun.run_state == 35) {
                    this.putMonster();
                }
                else {
                    this.mini_state = 4;
                    this.view_state = 1;
                    this.goVIEW_MONSTER();
                }
            }
            else if (Ms.i().equals(this.about_d[this.popMenu], "\u53d6\u51fa")) {
                if (GameRun.run_state == 35) {
                    this.takenMonster();
                }
                else {
                    this.mini_state = 6;
                    this.view_state = 1;
                    this.goVIEW_MONSTER();
                }
            }
            else if (Ms.i().equals(this.about_d[this.popMenu], "\u5356\u5ba0")) {
                if (this.buyOk == 1) {
                    this.buyOk = 0;
                    this.money += this.sell_money;
                    this.say("\u83b7\u5f97\u91d1\u94b1\uff1a" + this.sell_money, 0);
                    if (this.mini_state == 6) {
                        this.setTakenMonster();
                    }
                    else {
                        this.setPutMonster();
                    }
                }
                else if (this.mini_state == 4 && !this.isMyMonsters(this.select[0][0])) {
                    this.say("\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01", 0);
                }
                else {
                    this.buyOk = 1;
                    Monster monster2;
                    if (this.mini_state == 4) {
                        monster2 = this.myMonsters[this.select[0][0]];
                    }
                    else {
                        monster2 = this.cMonsters[this.select[0][0]];
                    }
                    this.sellMonster(monster2);
                    this.gogoString = "\u83b7\u5f97\u91d1\u94b1\uff1a" + this.sell_money + "\uff0c\u662f\u5426\u5356\u51fa\uff1f";
                }
            }
            else if (Ms.i().equals(this.about_d[this.popMenu], "\u79bb\u5f00")) {
                this.goRUN_IN_MAP(false);
            }
        }
        else if (Ms.i().key_S2()) {
            if (this.buyOk != 0) {
                this.buyOk = 0;
            }
            else if (GameRun.run_state == 65) {
                this.goRUN_IN_MAP(false);
            }
            else {
                this.popMenu = -1;
            }
        }
    }
    
    public boolean runPauseIco() {
        for (byte b = 0; b < this.b_ico; ++b) {
            if (this.map.my.state == 0 && this.pkey.isSelect(this.pkey.button_pos[10][b][0], this.pkey.button_pos[10][b][1], this.pkey.button_pos[10][b][2], this.pkey.button_pos[10][b][3])) {
                if (this.b_ico == 2) {
                    this.isTalk = false;
                    this.pkey.setKey5();
                }
                this.pkey.initPointer();
                if (b == 0) {
                    int n;
                    if (this.b_ico == 2) {
                        n = 7;
                    }
                    else {
                        n = 2;
                    }
                    this.b_ico = (byte)n;
                }
                else if (GameRun.run_state != 98) {
                    if (b == 3) {
                        this.goYouPAUSE(0);
                    }
                    else if (b == 6) {
                        SMSSender.i(this).go(0, true);
                    }
                    else {
                        if (b == 2) {
                            Ms.key = 48;
                        }
                        else if (b == 4) {
                            Ms.key = 49;
                        }
                        else if (b == 5) {
                            Ms.key = 51;
                        }
                        else if (b == 1) {
                            Ms.key = 57;
                        }
                        Ms.keyRepeat = true;
                    }
                    this.b_ico = 2;
                }
                return true;
            }
        }
        return false;
    }
    
    public void run_gameRun() {
        switch (GameRun.run_state) {
            case -10: {
                this.map.run_map();
                break;
            }
            case -50: {
                this.runMonsterAppear();
                break;
            }
            case -31: {
                this.runBattleState();
                break;
            }
            case -19: {
                if (this.cThrowX == 0 && this.b_c == 0) {
                    final byte b = this.items[this.selectx][this.select[0][0]][0];
                    this.deleteItems(b, 1);
                    short n = (short)((7 - (this.enB.getMon().monster[5] - 1) * 2) * (short)((new byte[] { 1, 3, 14 })[b - 9] * 30 + 50 - this.enB.getMon().monster[2] + 60 / this.enB.getMon().monster[2] - this.enB.getMon().monsterPro[0] * 100 / this.enB.getMon().monsterPro[2]) / 10);
                    if (this.enB.getMon().isEffect(3)) {
                        n += 30;
                    }
                    final byte[] array = (byte[])null;
                    if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
                        this.say("\u6240\u80fd\u643a\u5e26\u7684\u5ba0\u7269\u5df2\u7ecf\u8fbe\u5230\u4e0a\u9650\uff01", -1);
                        this.enB.act_num = 1;
                        this.myB.act_num = 0;
                        GameRun.run_state = -31;
                        this.battle_state = 9;
                        break;
                    }
                    Ms.i();
                    if (Ms.getRandom(100) < n) {
                        this.enB.action = 2;
                        this.enB.dead = 1;
                        this.say("\u6355\u83b7" + this.getNameMon((int)this.enB.getMon().monster[0]) + "\u5df2\u6210\u529f\uff01", 0);
                        if (this.getMonster(this.enB.getMon(), -1, false) == 0) {
                            this.myMonsters[this.myMon_length - 1].monster[1] = (byte)(this.myMon_length - 1);
                        }
                        GameRun.run_state = -31;
                        this.goBattleExp(false);
                        break;
                    }
                    this.b_c = 1;
                    final StringBuffer sb = new StringBuffer("\u6ca1\u6709\u6355\u83b7\u5230" + this.getNameMon((int)this.enB.getMon().monster[0]));
                    if (this.myB.getMon().isMonReel(41) || this.enB.getMon().isEffect(4) || this.enB.getMon().isEffect(3)) {
                        this.enB.act_num = 1;
                        this.myB.act_num = 0;
                        GameRun.run_state = -31;
                        this.battle_state = 9;
                    }
                    else {
                        final StringBuilder append = new StringBuilder("#n").append(this.getNameMon((int)this.enB.getMon().monster[0]));
                        Ms.i();
                        sb.append(append.append((new String[] { "\u6d41\u7740\u6cea\u9003\u8dd1\u4e86\uff01", "\u62fc\u4e86\u547d\u7684\u9003\u8dd1\u4e86\uff01", "\u76ef\u4e86\u4f60\u4e00\u773c\uff0c\u9003\u8d70\u4e86\uff01" })[Ms.getRandom(3)]).toString());
                        final String[] array2 = (String[])null;
                    }
                    this.say(sb.toString(), 0);
                    break;
                }
                else {
                    if (this.b_c == 1 && this.say_c == 0) {
                        this.arangeMonster();
                        this.setNullBattle();
                        this.goGO_RUNINMAP();
                        break;
                    }
                    break;
                }
                break;
            }
            case -86:
            case -15: {
                if (this.b_c == 0) {
                    if (this.levelUp_in_battle[this.myB.getMon().monster[1]][0] == 1) {
                        this.levelUp_in_battle[this.myB.getMon().monster[1]][0] = 0;
                        this.b_c = 1;
                        this.say_s = 52;
                        this.levelPro(this.myB.now_id, true);
                        this.setStringB("\u751f\u547d;+" + this.proReplace[this.myB.now_id][0] + "#n" + "\u80fd\u91cf" + ";+" + this.proReplace[this.myB.now_id][1], Constants_H.WIDTH, 0);
                        this.setStringB("\u529b\u91cf;+" + this.proReplace[this.myB.now_id][3] + "#n" + "\u9632\u5fa1" + ";+" + this.proReplace[this.myB.now_id][4] + "#n" + "\u654f\u6377" + ";+" + this.proReplace[this.myB.now_id][5], Constants_H.WIDTH, 1);
                        this.initMonStream(2, this.mList_id[this.myB.getMon().monster[0]][0], 1);
                    }
                    else {
                        final Battle myB = this.myB;
                        ++myB.now_id;
                    }
                    if (this.myB.now_id >= this.myMon_length) {
                        byte b2 = 0;
                        int n2 = 0;
                        final StringBuffer sb2 = new StringBuffer("");
                        while (b2 < this.myMon_length) {
                            int n3 = n2;
                            if (this.myMonsters[b2].monster[5] > 0) {
                                n3 = n2;
                                if (this.evolve[b2]) {
                                    n3 = n2;
                                    if (this.isEvolveKind(this.myMonsters[b2].monster[4], this.myMonsters[b2].monster[2]) == -1) {
                                        if (!Ms.i().equals(sb2, "")) {
                                            sb2.append("\u3001");
                                        }
                                        sb2.append(this.getNameMon((int)this.myMonsters[b2].monster[0]));
                                        this.evolve[b2] = false;
                                        n3 = 1;
                                    }
                                }
                            }
                            ++b2;
                            n2 = n3;
                        }
                        if (n2 != 0) {
                            sb2.append("\u53ef\u4ee5\u8fdb\u5316\u4e86");
                        }
                        final StringBuffer sb3 = new StringBuffer("");
                        int n4 = 0;
                        int n5;
                        for (int i = 0; i < 5; i = (byte)(i + 1), n4 = n5) {
                            n5 = n4;
                            if (this.getRid(i) != -2) {
                                if (this.getNexp(i, 1) != this.getNexp(i, 3)) {
                                    n5 = n4;
                                }
                                else {
                                    if (!Ms.i().equals(sb3, "")) {
                                        sb3.append("\u3001");
                                    }
                                    sb3.append((Object)this.monsterT[this.monster_pro[this.getNid(i)][6]] + "\u7684\u5ba0\u7269\u86cb");
                                    n5 = 1;
                                }
                            }
                        }
                        if (n4 != 0) {
                            sb3.append("\u7ecf\u9a8c\u5df2\u6ee1\uff0c\u53ef\u4ee5\u5b75\u5316\u4e86\u3002");
                            if (!Ms.i().equals(sb2, "")) {
                                sb2.append("#n");
                            }
                            sb2.append(sb3.toString());
                        }
                        if (!Ms.i().equals(sb2, "")) {
                            this.say(sb2.toString(), -1);
                        }
                        this.setNullBattle();
                        this.goGO_RUNINMAP();
                        break;
                    }
                    break;
                }
                else {
                    if (this.b_c == 1) {
                        this.say_s = Ms.i().mathSpeedDown(this.say_s, 4, true);
                        break;
                    }
                    break;
                }
                break;
            }
            case -11: {
                this.goRUN_IN_MAP(false);
                break;
            }
            case -30: {
                if (this.createOver == -1 && ++this.b_c >= 8) {
                    this.goMontsterAppear();
                    break;
                }
                break;
            }
            case 100: {
                if (this.b_c == 1) {
                    this.saveGame();
                    this.say("\u6e38\u620f\u5df2\u4fdd\u5b58\u3002", 0);
                    this.b_c = 0;
                    this.goRUN_IN_MAP(true);
                    break;
                }
                break;
            }
            case 35: {
                final byte mon_action_c = (byte)(this.mon_action_c + 1);
                this.mon_action_c = mon_action_c;
                if (mon_action_c > 50) {
                    this.mon_action_c = 0;
                    this.mon_action = 1;
                }
                if (this.cur_c == 2 && this.b_c == -1 && this.say_s == 0) {
                    this.goView();
                    break;
                }
                break;
            }
            case 69: {
                Mg.i().run();
                break;
            }
            case -20: {
                SMSSender.i(this).run();
                break;
            }
            case -21: {
                SMSSender.i(this).runLevel();
                break;
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
        Ms.i().rmsOptions(0, null, 4);
    }
    
    public void say(final String s, final int i) {
        Log.e("soars", s);
        String e;
        if (s.equals("#7\u70b9\u51fb\u5c4f\u5e55\u6216\u7528\u5bfc\u822a\u952e#0\u63a7\u5236\u4e0a\u4e0b\u5de6\u53f3\u79fb\u52a8\u3002")) {
            e = "#7\u70b9\u51fb\u5c4f\u5e55#0\u63a7\u5236\u4e0a\u4e0b\u5de6\u53f3\u79fb\u52a8\u3002";
        }
        else {
            e = s;
            if (s.contains("\u83dc\u5355\u952e")) {
                s.replace("\u83dc\u5355\u952e", "\u53f3\u4e0b\u65b9\u5de5\u5177\u6309\u94ae");
                e = s;
            }
        }
        this.sayStr.add(e);
        this.sayFlag.add(Integer.valueOf(i));
        this.setSay();
    }
    
    public void say(final String s, final int n, final int n2) {
        this.showS = Ms.i().groupString(s, Constants_H.WIDTH - 50);
        this.say_s = Constants_H.WIDTH;
        this.say_mode = 0;
        if (n == 0) {
            this.say_c = 15;
        }
        else if (n == -1) {
            this.say_c = -1;
            this.sayOverSms = (byte)n2;
        }
        else if (n == 1) {
            this.say_c = 15;
            this.say_mode = 1;
        }
    }
    
    public void setAimBattle(final int n) {
        this.mini_state = (byte)n;
        Battle am;
        if (this.mini_state == 1) {
            am = this.myB;
        }
        else {
            am = this.enB;
        }
        this.am = am;
        Battle dm;
        if (this.mini_state == 1) {
            dm = this.enB;
        }
        else {
            dm = this.myB;
        }
        this.dm = dm;
    }
    
    public void setMagic(final int n) {
        int n2 = n;
        if (n > 5) {
            n2 = 5;
        }
        this.initMagicStream(n2);
        this.now_action_Magic[n2] = 0;
        this.now_time_Magic[n2] = 0;
    }
    
    public void setNull(final boolean b) {
        if (this.map != null) {
            this.map.setNull();
        }
        if (this.mon[0] != null) {
            this.mon[0].nullIMFA();
        }
        if (this.mon[1] != null) {
            this.mon[1].nullIMFA();
        }
        if (b) {
            this.data_null();
        }
    }
    
    public void setSay() {
        if (this.say_c == 0 && this.sayStr.size() != 0) {
            final String s = (String)this.sayStr.remove(0);
            final int intValue = (int)Integer.valueOf(this.sayFlag.remove(0));
            this.showS = Ms.i().groupString(s, Constants_H.WIDTH - 50);
            this.say_s = Constants_H.WIDTH;
            this.say_mode = 0;
            if (intValue == 0) {
                this.say_c = 15;
            }
            else if (intValue == -1) {
                this.say_c = -1;
            }
            else if (intValue == 1) {
                this.say_c = 15;
                this.say_mode = 1;
            }
        }
    }
    
    public void skyCheckRegFull(final int n) {
        switch (n) {
            case 1: {
                this.map.setRegState(true);
                GameRun.mc.skyNewGame();
                break;
            }
            case 2: {
                this.map.setRegState(true);
                GameRun.mc.skyContinueGame();
                break;
            }
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
    
    public void valueMend(final Monster monster) {
        if (monster.monsterPro[0] < 0) {
            monster.monsterPro[0] = 0;
        }
        else if (monster.monsterPro[0] > monster.monsterPro[2]) {
            monster.monsterPro[0] = monster.monsterPro[2];
        }
        if (monster.monsterPro[1] < 0) {
            monster.monsterPro[1] = 0;
        }
        else if (monster.monsterPro[1] > monster.monsterPro[3]) {
            monster.monsterPro[1] = monster.monsterPro[3];
        }
    }
}
