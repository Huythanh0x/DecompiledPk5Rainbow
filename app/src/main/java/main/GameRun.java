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
    public static boolean isSay;
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

    static {
        GameRun.isSay = false;
    }

    public GameRun(MainCanvas maincanvas) {
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
        this.initFealty = new byte[]{100, 120};
        this.isChangeSound = Boolean.valueOf(false);
        this.sayStr = new ArrayList();
        this.sayFlag = new ArrayList();
        this.sayOverSms = -1;
        this.zb = new byte[]{-6, -4, -3, -2, -1, 0, 1, 2, 3, 4, 8, -3, 2, -1, 1, 1};
        this.Shuxing = new byte[][]{new byte[]{2, 3}, new byte[]{3, 4}, new byte[]{4, 0}, new byte[]{0, 1}, new byte[]{1, 2}};
        this.hit_rate = 0;
        this.magic_id = -2;
        this.magic_x = 0;
        this.magic_y = 0;
        this.mon = new Sprite[2];
        this.magic = new Sprite[6];
        this.now_action_Magic = new short[6];
        this.now_time_Magic = new short[6];
        this.overMode = 0;
        this.evolve = new boolean[]{true, true, true, true, true};
        this.now_action = new byte[2];
        this.now_time = new byte[2];
        this.battleSay = new String[]{"敌人出现了，战斗吧！", "考验的时刻来了，训练师！", "尽情捕捉宠物吧！"};
        this.isUpdateList = false;
        this.first_battle = 0;
        this.lastSkill = 0;
        this.skill_list = new byte[9];
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

    private void AddHP(int hp, Monster A_Monster) {
        int v1 = hp + A_Monster.monsterPro[0];
        if(v1 >= A_Monster.monsterPro[2]) {
            A_Monster.monsterPro[0] = A_Monster.monsterPro[2];
            return;
        }
        A_Monster.monsterPro[0] = (short)v1;
    }

    private void AddMP(int hp, Monster A_Monster) {
        int v1 = hp + A_Monster.monsterPro[1];
        if(v1 > A_Monster.monsterPro[3]) {
            A_Monster.monsterPro[1] = A_Monster.monsterPro[3];
            return;
        }
        A_Monster.monsterPro[1] = (short)v1;
    }

    public void Success() {
        synchronized(this) {
            SMSSender.i(this).setSendSms(4);
            try {
                SMSSender.i(this);
                if(SMSSender.smsType == 6) {
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
            catch(Exception exception0) {
                exception0.printStackTrace();
            }
        }
    }

    public byte addItem(int item_id, int count) {
        int v2 = this.findItemType(item_id);
        int v3 = this.findItem(v2, item_id, false);
        if(v3 == -1) {
            this.items[v2][this.itemsLength[v2]][0] = (byte)item_id;
            this.items[v2][this.itemsLength[v2]][1] = (byte)count;
            this.itemsLength[v2] = (byte)(this.itemsLength[v2] + 1);
        }
        else {
            byte[] arr_b = this.items[v2][v3];
            byte b = (byte)(arr_b[1] + count);
            arr_b[1] = b;
            if(b > 99) {
                this.items[v2][v3][1] = 99;
                this.say(this.getNameItem(((int)this.items[v2][v3][0])) + "数量已到上限", 0);
                return -1;
            }
        }
        return 1;
    }

    public void addMonInfoListBH() {
        this.monInfoList[104] = (byte)(this.monInfoList[104] + 1);
        this.monInfoList[103] = (byte)(this.monInfoList[103] + 1);
        if(this.monInfoList[103] == 102) {
            this.say("恭喜您把所有的宠物都收集齐了", 0);
            GameRun.mc.paint();
            Ms.i().sleep(600);
        }
    }

    private void aiEnemy() {
        int skill_num = 5;
        Ms.i();
        int n = (byte)Ms.getRandom(100);
        while(skill_num > -1 && this.enB.getMon().monster[skill_num + 8] == -1) {
            skill_num = (byte)(skill_num - 1);
        }
        if(this.battle_type == 4) {
            switch(((byte)(skill_num + 1))) {
                case 1: {
                    this.enB.skill = 0;
                    break;
                }
                case 2: {
                    this.enB.skill = n < 65 ? 1 : 0;
                    break;
                }
                case 3: {
                    if(n < 45) {
                        this.enB.skill = 2;
                    }
                    else if(n > 75) {
                        this.enB.skill = 1;
                    }
                    else {
                        this.enB.skill = 0;
                    }
                    break;
                }
                default: {
                    if(n < 45) {
                        this.enB.skill = (byte)(((byte)(skill_num + 1)) - 1);
                    }
                    else if(n < 75) {
                        this.enB.skill = (byte)(((byte)(skill_num + 1)) - 2);
                    }
                    else if(n < 0x5F) {
                        this.enB.skill = (byte)(((byte)(skill_num + 1)) - 3);
                    }
                    else {
                        this.enB.skill = (byte)(((byte)(skill_num + 1)) - 4);
                    }
                }
            }
        }
        else {
            Ms.i();
            int rand = (byte)Ms.getRandom(100);
            int i = 0;
        alab1:
            while(i < 2) {
                switch(this.enB.getMon().monster[i + 14]) {
                    case 27: {
                        if(this.isMonHp(this.enB.getMon(), 50) && rand < 30) {
                            this.enB.skill = (byte)(i + 6);
                            break alab1;
                        }
                        break;
                    }
                    case 28: {
                        if(this.isMonHp(this.enB.getMon(), 30) && rand < 30) {
                            this.enB.skill = (byte)(i + 6);
                            break alab1;
                        }
                    }
                }
                i = (byte)(i + 1);
            }
            if(i > 1) {
                switch(((byte)(skill_num + 1))) {
                    case 1: {
                        this.enB.skill = 0;
                        break;
                    }
                    case 2: {
                        this.enB.skill = n < 20 ? 0 : 1;
                        break;
                    }
                    case 3: {
                        if(n < 5) {
                            this.enB.skill = 0;
                        }
                        else if(n > 40) {
                            this.enB.skill = 2;
                        }
                        else {
                            this.enB.skill = 1;
                        }
                        break;
                    }
                    case 4: {
                        if(n < 15) {
                            this.enB.skill = 1;
                        }
                        else if(n < 40) {
                            this.enB.skill = 2;
                        }
                        else {
                            this.enB.skill = 3;
                        }
                        break;
                    }
                    default: {
                        if(n < 60) {
                            this.enB.skill = (byte)(((byte)(skill_num + 1)) - 1);
                        }
                        else if(n < 85) {
                            this.enB.skill = (byte)(((byte)(skill_num + 1)) - 2);
                        }
                        else if(n < 0x5F) {
                            this.enB.skill = (byte)(((byte)(skill_num + 1)) - 3);
                        }
                        else {
                            this.enB.skill = (byte)(((byte)(skill_num + 1)) - 4);
                        }
                    }
                }
            }
        }
        this.enB.skill = this.enB.getMon().monster[this.enB.skill + 8];
    }

    private void allAdd(int hp) {
        boolean bmp = false;
        boolean bhp = false;
        if(this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            this.say(this.getNameMon(((int)this.myMonsters[this.select[0][0]].monster[0])) + "已经死亡，无法使用！", 0);
            return;
        }
        if(this.myMonsters[this.select[0][0]].monsterPro[1] < this.myMonsters[this.select[0][0]].monsterPro[3] && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
            this.AddMP(this.myMonsters[this.select[0][0]].monsterPro[3] * hp / 100, this.myMonsters[this.select[0][0]]);
            bmp = true;
        }
        if(this.myMonsters[this.select[0][0]].monsterPro[0] < this.myMonsters[this.select[0][0]].monsterPro[2] && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
            this.AddHP(this.myMonsters[this.select[0][0]].monsterPro[2] * hp / 100, this.myMonsters[this.select[0][0]]);
            bhp = true;
        }
        if(bhp || bmp) {
            this.useState(0, ((int)this.select_it[0]));
            return;
        }
        if(this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            this.AddHP(this.myMonsters[this.select[0][0]].monsterPro[2] * hp / 100, this.myMonsters[this.select[0][0]]);
            return;
        }
        this.say(this.getNameMon(((int)this.myMonsters[this.select[0][0]].monster[0])) + "不需要使用这个道具", 0);
    }

    private void arangeMonster() {
        if(this.myMon_length > 1) {
            for(int i = 0; i < this.myMon_length - 1; i = (byte)(i + 1)) {
                for(int j = (byte)(i + 1); j < this.myMon_length; j = (byte)(j + 1)) {
                    if(this.myMonsters[i].monster[1] > this.myMonsters[j].monster[1]) {
                        this.changeMonster(this.myMonsters[i], this.myMonsters[j]);
                    }
                }
            }
        }
    }

    public void battleType(int mode) {
        this.battle_type = (byte)mode;
    }

    private boolean bufferAI(Monster mon) {
        return !mon.isMonEffect(0);
    }

    private void changeEffect() {
        if(this.myMonsters[this.select[0][0]].effect != 7) {
            this.myMonsters[this.select[0][0]].effect = 7;
            this.useState(0, ((int)this.select_it[0]));
            return;
        }
        this.say(this.getNameMon(((int)this.myMonsters[this.select[0][0]].monster[0])) + "没有异常！", 0);
    }

    private boolean changeMon(Battle be, int length) {
        int d = 0;
        byte last_id = be.now_id;
        do {
            byte b1 = (byte)(be.now_id + 1);
            be.now_id = b1;
            if(b1 >= length) {
                be.now_id = 0;
            }
            d = (byte)(d + 1);
        }
        while(d <= length && (last_id == be.now_id || be.getMon().monsterPro[0] < 1));
        if(d > length) {
            be.now_id = last_id;
        }
        return d <= length;
    }

    private void changeMonster(Monster a, Monster b) {
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
    }

    private boolean changeMy() {
        for(int i = 1; true; i = (byte)(i + 1)) {
            if(i >= this.myMon_length) {
                return false;
            }
            if(this.myMonsters[i].monsterPro[0] > 0) {
                this.setAimBattle(1);
                this.goVIEW_MONSTER();
                return true;
            }
        }
    }

    public boolean checkMonster() {
        for(int i = 0; true; i = (byte)(i + 1)) {
            if(i >= this.myMon_length) {
                this.say("您的宠物不需要回复！", 0);
                return true;
            }
            if(this.myMonsters[i].monsterPro[1] < this.myMonsters[i].monsterPro[3] || this.myMonsters[i].monsterPro[0] < this.myMonsters[i].monsterPro[2]) {
                return false;
            }
        }
    }

    private void dItemIn(int item_type, int item_no) {
        for(int i = item_no; i < this.itemsLength[item_type] - 1; ++i) {
            this.items[item_type][i] = this.items[item_type][i + 1];
        }
        this.itemsLength[item_type] = (byte)(this.itemsLength[item_type] - 1);
        this.items[item_type][this.itemsLength[item_type]] = null;
        this.items[item_type][this.itemsLength[item_type]] = new byte[2];
    }

    private void damage(Battle amB, Battle dmB, Monster am, Monster dm, int skill_no, int mini) {
        int LevelA = am.monster[2];
        int LevelB = dm.monster[2];
        int DebuffB = 0;
        int StrA = am.monsterPro[6];
        int DefB = dm.monsterPro[7];
        int SkillDam = this.skill[skill_no][0];
        int LevelCha = LevelA - LevelB;
        int buff = 100;
        if(LevelCha > 10) {
            LevelCha = 10;
        }
        else if(LevelCha < -10) {
            LevelCha = -10;
        }
        if(dm.effect == 0) {
            DebuffB = -30;
        }
        int hit = (amB.countS[1] + DebuffB + 100) * ((LevelCha * 4 + 100) * (StrA * SkillDam * (1000 - DefB * 5) / 10000 - DefB / 10 - LevelA / (SkillDam * 2) + 6 - (LevelA - 1) / 10) / 100) / 100;
        int baoji = 1;
        if(am.isBuffRate(9)) {
            Ms.i();
            if(Ms.getRandom(100) < this.inhesion[9]) {
                hit >>= 1;
                goto label_32;
            }
            goto label_22;
        }
        else {
        label_22:
            if(dm.isMonReel(0x30)) {
                Ms.i();
                if(Ms.getRandom(100) < this.skill[0x30][0]) {
                    hit >>= 1;
                    goto label_32;
                }
                goto label_27;
            }
            else {
            label_27:
                if(am.isBuffRate(10)) {
                    Ms.i();
                    if(Ms.getRandom(100) < this.inhesion[10]) {
                        hit = hit * 15 / 10;
                        baoji = 2;
                    }
                }
            }
        }
    label_32:
        if(dm.monster[3] == 1 && dm.isMonReel(33)) {
            buff = this.skill[33][0];
        }
        dmB.addHit((hit * buff / 100 >= 1 ? hit * buff / 100 : 1), baoji, 0);
    }

    public void data_init() {
        byte[] arr_b = Ms.i().getStream("data/data.d", -1);
        Ms.i();
        Ms.skip = 0;
        this.skill_up = Ms.i().create2Array(arr_b);
        this.monster_pro = Ms.i().create2Array(arr_b);
        this.skill = Ms.i().create2Array(arr_b);
        this.skill_help = Ms.i().createStringArray(arr_b);
        this.skill_name = Ms.i().createStringArray(arr_b);
        this.monsterT = Ms.i().createStringArray(arr_b);
        this.NAME = Ms.i().createStringArray(arr_b);
        this.item_help = Ms.i().createStringArray(arr_b);
        this.item_name = Ms.i().createStringArray(arr_b);
        this.city_name = Ms.i().createStringArray(arr_b);
        this.buff_name = Ms.i().createStringArray(arr_b);
        this.buff_help = Ms.i().createStringArray(arr_b);
        this.monAppearMap = Ms.i().create2Array(arr_b);
        this.mList_id = Ms.i().create2Array(arr_b);
        this.monsterMake = Ms.i().create2Array(arr_b);
        this.monsterInfo = Ms.i().createStringArray(arr_b);
        this.inhesion = Ms.i().createArray(arr_b);
        this.makeLevel = Ms.i().createArray(arr_b);
        this.musicNo = Ms.i().createArray(arr_b);
        this.npc2ImageType = Ms.i().createArray(arr_b);
        Map map0 = this.map;
        map0.boatCourse = Ms.i().create2Array(arr_b);
        this.nidusList = Ms.i().create2Array(arr_b);
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

    private void delItemEvolve(byte id) {
        int i = 2;
        do {
            this.deleteItems(((int)this.monsterMake[id][i]), ((int)this.monsterMake[id][i + 1]));
            i = (byte)(i + 2);
        }
        while(i < this.monsterMake[id].length - 1);
    }

    private void delItemSkill(Monster mon) {
        this.say(this.getNameMon(((int)mon.monster[0])) + "习得技能：" + this.getNameSkill(this.getSkill), 0);
        this.goMY_BAG(2);
        this.deleteItems(this.getSkill + 9, 1);
        Ms.i().correctSelect(this.select[0], ((int)this.itemsLength[this.selectx]), ((int)this.list_rows));
    }

    public byte delMonster(int no) {
        int id = this.myMonsters[no].monster[0];
        if(this.monsterRemove(no) != -1) {
            this.say("失去宠物：" + this.getNameMon(id), 0);
            return 1;
        }
        this.say("身上必须携带一只能参战的宠物！", 0);
        return -1;
    }

    public void deleteItems(int item_id, int count) {
        int v2 = this.findItemType(item_id);
        int v3 = this.findItem(v2, item_id, false);
        if(v3 != -1) {
            if(this.items[v2][v3][1] >= count) {
                byte[] arr_b = this.items[v2][v3];
                arr_b[1] = (byte)(arr_b[1] - count);
            }
            if(this.items[v2][v3][1] == 0) {
                this.dItemIn(v2, v3);
            }
        }
    }

    private void doBuffValue(Battle be) {
        if(be.getMon().monsterPro[0] >= 1 && be.getMon().isBuffRate(4)) {
            be.addHit(-be.getMon().monsterPro[2] * this.inhesion[4] / 100, 1, 1);
        }
    }

    private void doEffectValue(Battle be) {
        int hit = 0;
        if(be.getMon().isMonEffect(2)) {
            hit = (short)(be.getMon().monsterPro[0] / 10);
        }
        else if(be.getMon().isMonEffect(5)) {
            hit = (short)(be.fs_level * be.fs_level + 4);
        }
        if(be.getMon().isMonReel(3)) {
            hit = (short)(this.inhesion[3] * hit / 100 + hit);
        }
        if(hit != 0) {
            be.addHit(hit, 1, 0);
        }
    }

    public void doPaint(int mode) {
        if(mode == 0) {
            GameRun.run_state = -10;
        }
        else {
            this.b_c = (byte)mode;
        }
        GameRun.mc.paint();
    }

    public void doSayOverSms() {
        int temp = this.sayOverSms;
        System.out.println("doSayOverSms() sayOverSms= " + ((int)this.sayOverSms));
        this.sayOverSms = -1;
        if(temp == 0) {
            GameRun.isSay = true;
            SMSSender.i(this).go(4, true);
            GameRun.isSay = false;
            return;
        }
        if(temp == 1) {
            SMSSender.i(this).go(3, true);
        }
    }

    private void drawAnimationBattle(Battle amB, int mini_am) {
        if(amB.action == 0) {
            int skill_type = (byte)(amB.skill / 5);
            int skill_id = (byte)(amB.skill % 5);
            if(skill_type > 5) {
                skill_type = 5;
            }
            if(skill_type == 5) {
                skill_id = (byte)(amB.skill - 25);
            }
            if(this.drawMagicC(skill_type, skill_type, skill_id, this.getBXY(((int)this.mini_state), ((int)amB.skill), true), this.getBXY(((int)this.mini_state), ((int)amB.skill), false), this.mini_state ^ 1)) {
                if(this.mini_state == 1) {
                    short[] arr_v = amB.getMon().monsterPro;
                    arr_v[1] = (short)(arr_v[1] - this.getSkillMana(amB.getMon(), ((int)amB.skill)));
                    this.valueMend(amB.getMon());
                }
                this.runHit();
            }
        }
    }

    private void drawBG0(int id, int lx, int ly, int sh, int w) {
        Ui.i().fillRect(0x52BDEF, lx - 1, 0, w + 13, 358);
        Ui.i().drawImage(this.imgBG[id], 320, 0, 17);
        Ui.i().drawK2(lx, ly, 640 - (lx << 1), 360 - ly, 0);
        Ui.i().drawK1(lx + 5, ly + 0x20 + sh, w, 324 - ly - sh, 1);
        Ui.i().drawK(lx + 7, 0x120, w - 4, 58, 3);
    }

    private void drawBUY_ITEM() {
        int v3;
        Ui.i().fillRectB();
        Ui.i().drawK2(1, 2, 638, 358, 0);
        if(this.cur_b == 0) {
            Ui.i().drawK1(291, 6, 58, 28, 4);
            Ui.i().drawString(this.action_str[this.cur_a], 320, 5, 17, 0, 0);
        }
        else {
            Ui.i().drawK1(this.cur_a * 210 + 70, 6, 70, 28, 4);
            for(int i = 0; i < 3; i = (byte)(i + 1)) {
                Ui.i().drawString(this.action_str[i], i * 210 + 80, 5, 0, (this.cur_a == i ? 0 : 4), 0);
            }
            byte b = this.pkey.selectMenuX(3, 70, 0, 210, 62);
            if(b != -1) {
                this.cur_a = b;
                byte[] arr_b = this.select[0];
                this.select[0][0] = 0;
                arr_b[1] = 0;
            }
            Ui.i();
        }
        Ui.i().drawK1(6, 37, 614, this.list_rows * 30 + 6, 1);
        Ui.i().drawK1(6, this.list_rows * 30 + 53, 628, 90, 2);
        int v1 = this.cur_b == 1 ? this.itemsLength[this.cur_a] : this.buyItem[this.cur_a].length;
        int i = (byte)v1;
        this.drawItemList(10, 40, 614, this.list_rows, this.select[0], this.cur_a, i, (this.cur_b == 1 ? 2 : 1));
        Ui.i().sliding(625, 42, this.list_rows * 30 - 6, ((int)this.select[0][0]), i, true);
        if(i > 0) {
            i = this.cur_b == 1 ? this.items[this.cur_a][this.select[0][0]][0] : this.buyItem[this.cur_a][this.select[0][0]];
            if(this.item_help[i].toString().contains("复活死亡的宠物并为其回复生命值的")) {
                this.showStringM("复活死亡的宠物并为其回复生命值的30%,请勿在宠物战斗中购买!", 320, this.list_rows * 30 + 55, 10, 3);
            }
            else {
                this.showStringM(this.item_help[i].toString(), 320, this.list_rows * 30 + 55, 10, 3);
            }
        }
        this.drawMoney(320, 358, 0, this.cur_b != 1 && this.cur_a == 2);
        if(this.popMenu != -1) {
            if(this.buyOk == 1 && this.cur_b != 1 && this.buyItem[this.cur_a][this.select[0][0]] >= 35 && this.makeLevel[this.buyItem[this.cur_a][this.select[0][0]] - 35] > this.rmsOther[3]) {
                Ui.i().drawKuang(-5, 130, 650, 108);
                this.showStringM("需要训练师" + ((int)this.makeLevel[this.buyItem[this.cur_a][this.select[0][0]] - 35]) + "级才能学习！", 320, 0x9B, 12, 9);
                this.showString("是否购买？", 205, 0);
            }
            else {
                if(this.cur_b == 1) {
                    v3 = 1;
                }
                else {
                    v3 = this.cur_a == 2 ? 16 : 17;
                }
                this.drawBuy(i, 320, 180, 150, 50, v3);
            }
            int v4 = this.pkey.selectMenuX(2, 0, 0, 320, 360);
            if(v4 != -1) {
                Ms.key = v4 == 0 ? -3 : -4;
                Ms.keyRepeat = true;
            }
        }
        Ui.i().drawYesNo(true, true);
    }

    private void drawBattleBG() {
        Ui.i().fillRectB();
        Ui.i().drawImage(this.imgBG[this.enB.bg_id], 200, 20, 0);
        Ui.i().drawImage(this.imgBG[this.myB.bg_id], 200, 0x90, 0, DirectGraphics.FLIP_HORIZONTAL);
        Ui.i().drawK2(2, 19, 0xC3, 0xFA, 0);
    }

    private void drawBattleExp(Monster mon, int y) {
        Ui.i().drawK0(200, y, 0xF0, 10, 0);
        this.drawMonsterHp(mon, 0xF0, y + 3, 0xC3, 2, 2, (this.battle_state == -5 ? this.myB.cexp : mon.monsterPro[4]));
        Ui.i().drawString("经验", 200, y + 18, 36, 0, 2);
    }

    private void drawBuffList(Monster monster, int x, int y, int w, int fontH, int show_num, byte[] sel) {
        Ui.i().drawListKY(show_num, x, y, w, 3, fontH, 0, sel[0] - sel[1], 4, 2);
        for(byte i = 0; i < 2; i = (byte)(i + 1)) {
            if(i <= 0 || monster.monster[i + 16] >= 1) {
                Ui.i().drawUi(49, x + 8, y + 8 + (i - this.select[0][1]) * fontH, 0, 0);
                Ui.i().drawString(this.getNameBuff(((int)monster.monster[i + 16])), x + 21, y + 1 + (i - this.select[0][1]) * fontH, 0, (sel[0] == i ? 0 : 3), 0);
                if(this.pkey.isSelect(x, y + 1 + (i - sel[1]) * fontH, w, fontH)) {
                    sel[0] = i;
                }
            }
        }
    }

    private void drawBuy(int id, int x, int y, int w_h, int h_h, int d) {
        Ui.i().drawKuang(x - w_h, y - h_h, w_h << 1, h_h << 1);
        int t = y - h_h + ((d & 16) == 0 ? 12 : 2);
        Ui.i().drawString("数量：" + ((int)this.popMenu) + "/" + ((int)this.t_length), x, t, 17, 3, 0);
        StringBuffer s = new StringBuffer();
        if((d & 16) == 0) {
            s.append("获得：");
        }
        else {
            s.append("需要：");
        }
        s.append(this.sell_money * this.popMenu);
        if((d & 1) == 0) {
            s.append("徽章");
        }
        else {
            s.append("金");
        }
        Ui.i().drawString(s.toString(), x, t + 29, 17, 6, 0);
        if((d & 16) != 0) {
            Ui.i().drawString("现有：" + this.findItem(-2, id, true), x, t + 58, 17, 3, 0);
        }
        Ui.i().drawTriangle1(x, y - 2, w_h, true, this.cur_b != 2);
        if(this.buyOk == 1) {
            this.showString("是否" + ((d & 16) == 0 ? "卖出" : "购买") + "？", Constants_H.HEIGHT_H + 25, 0);
        }
    }

    public boolean drawCartoonOne(int i, int skill_mode, int select, int x, int y, boolean mode, int dir) {
        if(this.now_action[i] >= this.mon[skill_mode].aLength(select)) {
            this.now_action[i] = 0;
        }
        Ui.i().drawFrameOne(this.mon[skill_mode], this.mon[skill_mode].action(select, ((int)this.now_action[i]), 0), x, y, dir);
        return this.setCartoonFrame_C(i, skill_mode, select, mode);
    }

    public void drawChangeMap(boolean bb, int t_c, int x, int y, int w) {
        if(bb) {
            Ui.i().fillRect(0x52BDEF, 0, 0, 640, 360);
        }
        GameRun.g.setColor(0);
        GameRun.g.fillRect(x, y + 1, w, 5);
        GameRun.g.fillRect(x + 1, y, w - 2, 7);
        GameRun.g.setColor(0xEAFCFF);
        if((w - 4) * (t_c * 2) / 60 > w) {
            GameRun.g.fillRect(x + 2, y + 1, w, 5);
            GameRun.g.fillRect(x + 1, y + 2, w, 3);
        }
        else {
            GameRun.g.fillRect(x + 2, y + 1, (w - 4) * (t_c * 2) / 60, 5);
            GameRun.g.fillRect(x + 1, y + 2, (w - 2) * (t_c * 2) / 60, 3);
        }
        if(bb && Map.npcSp[1][0].img != null) {
            if((w - 4) * (t_c * 2) / 60 > w) {
                this.map.drawMyAni(this.map.my, 0, w, y + 10, 5);
                return;
            }
            this.map.drawMyAni(this.map.my, 0, x + (w - 4) * (t_c * 2) / 60, y + 10, 5);
        }
    }

    public void drawCityName() {
        int WIDTH_H = Constants_H.WIDTH__ / 2;
        if(this.cityName_c == -20) {
            return;
        }
        int w = (short)(Ms.i().getStringWidth(this.city_name[this.map.mapNo].toString()) + 8);
        Ui ui0 = Ui.i();
        int v2 = this.cityName_c > 0 ? 0 : this.cityName_c;
        ui0.drawKuang(WIDTH_H - (w >> 1), v2, w, 0x1F);
        Ui ui1 = Ui.i();
        String s = this.city_name[this.map.mapNo].toString();
        int v3 = this.cityName_c > 0 ? 0 : this.cityName_c;
        ui1.drawString(s, WIDTH_H, v3, 17, 4, 2);
        this.cityName_c = (byte)(this.cityName_c - 1);
    }

    private void drawClipPic(int action_id, int id, int x, int y, int w, int h, int piece, int cc, int dir) {
        int i = 1;
        int ph = (byte)(w / piece);
        for(int speed = (short)(2 << cc); i < piece; speed = (short)(speed / 2)) {
            GameRun.g.clipRect(x - i * ph, y - h, (ph - speed > 0 ? speed : ph), h + 20);
            this.drawCartoonOne(id, id, action_id * 3, x, y, true, dir);
            GameRun.g.setClip(0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
            GameRun.g.clipRect((i - 1) * ph + x, y - h, (ph - speed > 0 ? speed : ph), h + 20);
            this.drawCartoonOne(id, id, action_id * 3, x, y, true, dir);
            GameRun.g.setClip(0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
            i = (byte)(i + 1);
        }
    }

    private void drawColorLine(int x, int y, int width, int height, int line_height, int max_h, int speed, int dir, int bgColor, int lineColor) {
        if((0xFF000000 & bgColor) != 0) {
            GameRun.g.setColor(bgColor);
            GameRun.g.fillRect(x, y, width, height);
        }
        GameRun.g.setColor(lineColor);
        int grid = 1;
        if(dir == 1) {
            while(y < y + height) {
                GameRun.g.fillRect(x, y, width, line_height);
                y = y + line_height + grid;
                int v11 = line_height - speed;
                if(v11 > 0) {
                    line_height = v11;
                }
                else {
                    --max_h;
                    if(grid < max_h) {
                        ++grid;
                    }
                    line_height = 1;
                }
            }
            return;
        }
        if(dir == 2) {
            int v12 = y + height;
            while(v12 > y) {
                GameRun.g.fillRect(x, v12 - line_height, width, line_height);
                v12 = v12 - line_height - grid;
                int v13 = line_height - speed;
                if(v13 > 0) {
                    line_height = v13;
                }
                else {
                    --max_h;
                    if(grid < max_h) {
                        ++grid;
                    }
                    line_height = 1;
                }
            }
        }
    }

    private void drawDarkScreen() {
        this.drawColorLine(0, 0, 640, 360, this.b_c + 1, 6, 1, 2, 0xFFFFFF, 4802889);
    }

    private void drawEffectImage(Monster monster, int x, int y) {
        if(monster.effect > -1 && monster.effect < 7 && monster.effect_time > 0) {
            Ui.i().drawImage(this.effectImage[monster.effect], x, y, 40);
            Ui.i().drawNum(((int)monster.effect_time), x, y, 40, 0);
        }
    }

    private void drawEnemy() {
        this.drawEffectImage(this.enB.getMon(), 435, 40);
        if(this.enB.getMon().monsterPro[0] < 1 && this.enB.dead == 1) {
            return;
        }
        if(this.drawCartoonOne(0, 0, this.mList_id[this.enB.getMon().monster[0]][1] * 3 + this.enB.action, (this.enB.ceff[0] == 0 ? 0 : 3) + 377, (this.enB.ceff[0] == 0 ? 0 : -3) + 97, this.enB.action == 0, 0)) {
            if(this.enB.getMon().monsterPro[0] < 1) {
                this.enB.action = 2;
                this.enB.dead = 1;
            }
            else if(this.enB.dead != 1) {
                this.enB.action = 0;
            }
        }
        byte[] arr_b = this.enB.ceff;
        arr_b[0] = (byte)Ms.i().mathSpeedN(((int)this.enB.ceff[0]), 0, 1, true);
        this.drawMonsterHp(this.enB.getMon(), 0x160, 97, 50, 0, 1, ((int)this.enB.chp));
        Battle battle0 = this.enB;
        battle0.chp = Ms.i().mathSpeedN(this.enB.chp, this.enB.getMon().monsterPro[0], (this.enB.chp >= this.enB.getMon().monsterPro[0] ? 6 : 20), true);
    }

    private void drawEnemyState() {
        Ui.i().drawK(10, 25, 0xB3, 110, 2);
        Ui.i().drawKuang(12, 27, 0x93, 33);
        if(this.enB.getMon().monster[3] != -1) {
            Ui.i().drawUi(this.enB.getMon().monster[3] + 5, 26, 41, 3, 0);
        }
        Ui.i().drawString(this.getNameMon(((int)this.enB.getMon().monster[0])).toString(), 99, 26, 17, 4, 2);
        Ui.i().drawNum(((int)this.enB.getMon().monster[2]) + "级", 0xA2, 45, 0, 0);
        Ui.i().drawK0(12, 61, 62, 14, 4);
        Ui.i().drawUi(34, 14, 62, 0, 0);
        Ui.i().drawNum(this.enB.countS[0] + 100 + "%", 70, 74, 1, 1);
        Ui.i().drawString("宠物档次", 12, 80, 20, 4, 2);
        this.drawMonKind(this.enB.getMon().monster[4], 0x76, 88, 0);
        Ui.i().drawString((this.monInfoList[this.enB.getMon().monster[0]] == 2 ? "已捕获" : "未捕获"), 12, 107, 20, 4, 2);
        Ui.i().drawUi((this.monInfoList[this.enB.getMon().monster[0]] == 2 ? 25 : 26), 0x72, 0x73, 0, 0);
    }

    private void drawEvolveMake(int id, int x, int y, int fontH) {
        int i = 2;
        int j = 0;
        do {
            Ui.i().drawString(this.getNameItem(((int)this.monsterMake[id][i])) + "（" + this.findItem(-2, ((int)this.monsterMake[id][i]), true) + "/" + ((int)this.monsterMake[id][i + 1]) + "）", x, y + j * fontH, 0, 3, 0);
            i = (byte)(i + 2);
            j = (byte)(j + 1);
        }
        while(i < this.monsterMake[id].length - 1);
        if(this.monsterMake[id][0] > 0) {
            int i = this.findItem(-2, 34, true);
            if(i > 0) {
                Ui.i().drawString(this.getNameItem(34) + "（" + i + "/" + 1 + "）", x, y + j * fontH, 0, -1, 0);
            }
        }
    }

    public void drawEvolveUI(int mode, int id, boolean bb) {
        Ui.i().fillRectB();
        this.drawBG0(((int)this.bg_c), 200, 108, 5, 230);
        if(mode != 1 || this.b_c <= 0) {
            this.drawCartoonOne(1, 1, this.mList_id[this.myMonsters[id].monster[0]][1] * 3, 377 - this.move_x, 97 - this.move_y, true, 0);
        }
        else if(this.b_c == 1 && this.drawMagicC(5, 5, 6, 377, 97, 0)) {
            this.initMonStream(2, ((int)this.mList_id[this.myMonsters[id].monster[0]][0]), 1);
            this.b_c = 2;
        }
        else if(this.b_c > 1 && this.b_c < 14) {
            this.drawClipPic(((int)this.mList_id[this.myMonsters[id].monster[0]][1]), 1, 377, 97, 80, 77, 15, this.b_c - 2, 0);
            byte b = (byte)(this.b_c + 1);
            this.b_c = b;
            if(b == 14) {
                this.b_c = -1;
                this.say("进化成  " + this.getNameMon(((int)this.myMonsters[id].monster[0])), 0);
            }
        }
        if(mode == 1 && this.popMenu == 1) {
            this.drawEvolveMake(((int)this.myMonsters[id].monster[0]), 0xE1, 0x9B, 28);
        }
        else {
            Ui.i().drawStringY(this.about_b, 209, 0x9B, 0, 3, 40, 3, 0);
            Ui.i().drawStringY(this.about_a, 322, 0x9B, 0, 3, 40, 3, 0);
        }
        if(mode == 0) {
            this.move_y = 0;
            this.move_x = 0;
            Ui.i().drawString(this.getNameMon(((int)this.myMonsters[id].monster[0])) + "升到了" + ((int)this.myMonsters[id].monster[2]) + "级", 0x1B0, 0x70, 24, 1, 0);
            Ui.i().drawImage(this.imgItem[1], 200 - this.say_s, 104, 36);
            byte[][] arr2_b = this.levelUp_in_battle;
            int v2 = bb ? id : this.myMonsters[id].monster[1];
            if(arr2_b[v2][1] != -1) {
                Ui ui0 = Ui.i();
                StringBuilder stringBuilder0 = new StringBuilder("习得技能：");
                byte[][] arr2_b1 = this.levelUp_in_battle;
                int v3 = bb ? id : this.myMonsters[id].monster[1];
                ui0.drawString(stringBuilder0.append(this.getNameSkill(arr2_b1[v3][1])).toString(), 320, 300, 17, 9, 0);
            }
        }
        else if(mode == 1) {
            Ui.i().drawK1(320 + (this.popMenu == 0 ? 0xFFFFFF81 : 15), 0x72, 0x71, 27, 4);
            Ui.i().drawString("基本属性", 0xF9, 0x71, 17, (this.popMenu == 0 ? 0 : 1), 0);
            Ui.i().drawString("进化素材", 391, 0x71, 17, (this.popMenu == 0 ? 1 : 0), 0);
            byte b1 = this.pkey.selectMenuX(2, 0, 0x71, 320, 33);
            if(b1 != -1) {
                this.popMenu = b1;
            }
            Ui.i();
            this.move_x = Ms.i().mathSpeedDown(((int)this.move_x), 3, false);
            this.move_y = Ms.i().mathSpeedDown(((int)this.move_y), 3, false);
            Ui.i().drawString("确定进化该宠物？", 320, 313, 17, 0, 1);
        }
        Ui.i().drawYesNo(true, true);
    }

    public void drawFealty(int length, int n, int x, int y) {
        for(int i = 0; i < length; i = (byte)(i + 1)) {
            Ui.i().drawUi((i <= n ? 21 : 22), i * 14 + x, y, 0, 0);
        }
    }

    private boolean drawHitOne(Battle dm, Battle am, int x, int y) {
        boolean bb = true;
        this.strHit = "";
        int i = 0;
        while(i < dm.hit.length) {
            if(dm.hit[i][4] < this.zb.length) {
                bb = false;
                if(dm.hit[i][0] == -1) {
                    this.strHit = "闪避";
                }
                else if(dm.hit[i][0] == -2) {
                    this.strHit = "忠诚度减少";
                }
                else {
                    String s = dm.hit[i][1] <= -1 ? "+" : "-";
                    Ms.i();
                    this.strHit = String.valueOf(s) + Ms.abs(dm.hit[i][1]);
                }
                if(dm.hit[i][0] > 0 && dm.hit[i][0] < 4) {
                    if(dm.hit[i][0] == 2) {
                        Ui.i().drawUi(0x20, dm.hit[i][2] + x + (this.strHit.length() >> 1) * 14 + 15, dm.hit[i][3] + y + 8, 40, 0);
                        Ui.i().drawUi(33, dm.hit[i][2] + x + (this.strHit.length() >> 1) * 14 + 15, dm.hit[i][3] + y + 8, 36, 0);
                    }
                    Ui.i().drawNum(this.strHit, dm.hit[i][2] + x, dm.hit[i][3] + y, 0, (dm.hit[i][0] == 2 ? 2 : 1));
                }
                else if(dm.hit[i][0] < 0 || dm.hit[i][0] == 4) {
                    Ui.i().drawString(this.strHit, dm.hit[i][2] + x, dm.hit[i][3] + y, 0, (dm.hit[i][0] == 4 ? 1 : 0), 2);
                }
                if(i == 0) {
                    short[] arr_v = dm.hit[0];
                    arr_v[2] = (short)(arr_v[2] + (this.mini_state == 1 ? 1 : -1));
                    short[] arr_v1 = dm.hit[0];
                    arr_v1[3] = (short)(arr_v1[3] + this.zb[dm.hit[0][4]]);
                }
                else {
                    switch(i) {
                        case 1: {
                            short[] arr_v2 = dm.hit[1];
                            arr_v2[2] = (short)(arr_v2[2] + (this.mini_state == 1 ? 1 : -1));
                            short[] arr_v3 = dm.hit[1];
                            arr_v3[3] = (short)(arr_v3[3] + this.zb[dm.hit[1][4]]);
                            break;
                        }
                        case 2: {
                            short[] arr_v4 = dm.hit[2];
                            arr_v4[3] = (short)(arr_v4[3] - dm.hit[2][4] / 3);
                        }
                    }
                }
                short[] arr_v5 = dm.hit[i];
                short v3 = (short)(arr_v5[4] + 1);
                arr_v5[4] = v3;
                if(v3 == 1) {
                    switch(dm.hit[i][0]) {
                        case -2: {
                            if(this.mini_state == 0 && !dm.getMon().isMonReel(40)) {
                                byte[] arr_b = dm.getMon().monster;
                                arr_b[6] = (byte)(arr_b[6] - dm.hit[i][1]);
                                this.getHitCoefficient(dm, dm.getMon(), am.getMon());
                                break;
                            }
                        label_49:
                            if(dm.hit[i][0] > 0) {
                                short[] arr_v6 = dm.getMon().monsterPro;
                                arr_v6[0] = (short)(arr_v6[0] - dm.hit[i][1]);
                            }
                            break;
                        }
                        case 4: {
                            short[] arr_v7 = dm.getMon().monsterPro;
                            arr_v7[1] = (short)(arr_v7[1] - dm.hit[i][1]);
                            break;
                        }
                        default: {
                            goto label_49;
                        }
                    }
                }
            }
            i = (byte)(i + 1);
        }
        this.valueMend(dm.getMon());
        return bb;
    }

    private void drawInfoBG(int w, int fh) {
        Ui.i().fillRect(0, 0, 0, 640, fh);
        GameRun.g.fillRect(0, 360 - fh, 640, fh);
        GameRun.g.fillRect(0, fh - 2, 640, fh);
        Ui.i().fillRect(0xEAFCFF, 0, 2, 640, fh - 4);
        GameRun.g.fillRect(0, 362 - fh, 640, fh - 4);
        GameRun.g.fillRect(0, fh, 640, fh - 4);
    }

    private void drawInfoList(int x, int y, int w, int sh, int show_num, int listMax, byte[] sel) {
        int v6;
        Ui.i().drawListKY(show_num, x - 4, y + 5, w, 4, sh + 4, 2, sel[0] - sel[1], 4, 2);
        for(byte i = sel[1]; i < sel[1] + show_num && i < listMax; i = (byte)(i + 1)) {
            Ui.i().drawUi((this.monInfoList[this.monInfo_dir[this.cur_a][i]] == 2 ? 25 : 0x30), x - 10, (i - sel[1]) * (sh + 6) + y + 11, 24, 0);
            if(sel[0] == i) {
                v6 = 0;
            }
            else {
                v6 = this.monInfoList[this.monInfo_dir[this.cur_a][i]] == 0 ? -1 : 3;
            }
            Ui.i().drawString(String.valueOf((this.infoStart + i + 1 >= 10 ? "" : "0")) + (this.infoStart + i + 1) + " " + (this.monInfoList[this.monInfo_dir[this.cur_a][i]] == 0 ? "未知宠物" : this.getNameMon(((int)this.monInfo_dir[this.cur_a][i]))), x + 10, (i - sel[1]) * (sh + 6) + y + 5, 0, ((int)(((byte)v6))), 0);
            Ui.i().drawString(this.getInfoType(((int)this.monAppearMap[this.monInfo_dir[this.cur_a][i]][0])), Constants_H.WIDTH - 40, (i - sel[1]) * (sh + 6) + y + 5, 24, ((int)(((byte)v6))), 0);
            if(this.pkey.isSelect(x, (i - sel[1]) * (sh + 6) + y + 5, w, sh + 6)) {
                if(sel[0] == i) {
                    this.pkey.setKey5();
                }
                else {
                    sel[0] = i;
                    if(i - sel[1] == 0 && sel[1] > 0) {
                        sel[1] = (byte)(sel[1] - 1);
                    }
                    else if(i - sel[1] == show_num - 1 && sel[1] + show_num < listMax) {
                        sel[1] = (byte)(sel[1] + 1);
                    }
                }
            }
        }
        Ui.i().sliding(x + w + 5, y + 10, (sh + 6) * show_num - 4, ((int)sel[0]), listMax, false);
    }

    public void drawItem(int action, int x, int y, int anchor) {
        if(action >= 58) {
            action = this.monster_pro[this.nidusList[0][action - 58]][6] + 40;
        }
        else if(action >= 35) {
            action = this.makeLevel[action - 35] + 34;
        }
        Ui.i().drawRegion(this.item_img, ((int)this.item_modules[action][0]), ((int)this.item_modules[action][1]), ((int)this.item_modules[action][2]), ((int)this.item_modules[action][3]), x, y, anchor, 0, GameRun.g);
    }

    private void drawItemList(int x, int y, int w, int show_num, byte[] sel, int itemType, int length, int mode) {
        byte i = sel[1];
        Ui.i().drawListKY(show_num, x - 4, y, w, 4, 0x1F, -1, sel[0] - sel[1], 4, 2);
        while(i < sel[1] + show_num) {
            if(i < length) {
                if(mode == 0 || mode == 2) {
                    this.drawItem(((int)this.items[itemType][i][0]), x + 3, y + 4 + (i - sel[1]) * 30, 0);
                    Ui.i().drawString(this.getNameItem(((int)this.items[itemType][i][0])), x + 21, y + 1 + (i - sel[1]) * 30, 0, (sel[0] == i ? 0 : 3), 0);
                    String s = mode == 2 ? this.getPrice(itemType, ((int)this.items[itemType][i][0]), false) + "金" : "x" + ((int)this.items[itemType][i][1]);
                    Ui.i().drawString(s, x + w - 12, y + 1 + (i - sel[1]) * 30, 24, (sel[0] == i ? 0 : 3), 0);
                }
                else {
                    this.drawItem(((int)this.buyItem[itemType][i]), x + 2, y + 4 + (i - sel[1]) * 30, 0);
                    int v7 = sel[0] == i ? 0 : 3;
                    Ui.i().drawString(this.getNameItem(((int)this.buyItem[itemType][i])), x + 20, y + (i - sel[1]) * 30, 0, ((int)(((byte)v7))), 0);
                    Ui.i().drawString(this.getPrice(itemType, ((int)i), true) + (itemType == 2 ? "徽章" : "金"), x + w - 12, (i - sel[1]) * 30 + (y + 1), 24, ((int)(((byte)v7))), 0);
                }
                if(this.popMenu == -1 && this.say_c == 0 && this.pkey.isSelect(x, (i - sel[1]) * 30 + y, Constants_H.WIDTH, 30)) {
                    if(sel[0] == i) {
                        this.pkey.setKey5();
                    }
                    else {
                        sel[0] = i;
                        if(i - sel[1] == 0 && sel[1] > 0) {
                            sel[1] = (byte)(sel[1] - 1);
                        }
                        else if(i - sel[1] == show_num - 1 && sel[1] + show_num < length) {
                            sel[1] = (byte)(sel[1] + 1);
                        }
                        this.select_it[this.selectx] = sel[0];
                        this.select_st[this.selectx] = sel[1];
                    }
                }
            }
            i = (byte)(i + 1);
        }
    }

    private void drawLIST_INFO() {
        Ui.i().fillRectB();
        this.drawInfoBG(24, 35);
        Ui.i().drawString("发现度 " + Ms.i().getPrecision(this.monInfoList[102] * 1000 / 102) + "%", 628, 34, 24, 3, 1);
        Ui.i().drawString(this.monsterT[this.cur_a].toString(), 28, 34, 0, 1, 2);
        Ui.i().drawString("捕捉种类 " + ((int)this.monInfoList[103]) + "/" + 100, 320, 361, 33, 3, 1);
        byte b = this.pkey.selectMenuX(5, 100, 0, 106, 35);
        if(b != -1) {
            this.cur_a = b;
            this.infoStart = 0;
            if(this.cur_a > 0) {
                for(int i = 0; i < this.cur_a; i = (byte)(i + 1)) {
                    this.infoStart = (byte)(this.infoStart + this.monInfo_dir[i].length);
                }
            }
            this.t_length = (byte)this.monInfo_dir[this.cur_a].length;
            byte[] arr_b = this.select[0];
            this.select[0][1] = 0;
            arr_b[0] = 0;
        }
        for(int i = 0; i < 5; i = (byte)(i + 1)) {
            Ui.i().drawUi((this.cur_a == i ? 5 : 0) + i, (i + 1) * 614 / 6 + 18, 12, 6, 0);
        }
        this.drawInfoList(0x20, 67, 590, 29, ((int)this.list_rows), ((int)this.t_length), this.select[0]);
        Ui.i();
        Ui.i().drawYesNo(this.monInfoList[this.getMonInfo_dir()] != 0, true);
    }

    private void drawMONSTER_INFO(int id) {
        Ui.i().fillRectB();
        Ui.i().drawK2(180, 2, 280, 358, 0);
        Ui.i().drawK1(200, 6, 0xE8, 29, 4);
        Ui.i().drawK1(0xC0, 35, 100, 90, 1);
        Ui.i().drawK1(0xE5, 0x81, 0xE2, 0x74, 1);
        Ui.i().drawK1(0xC0, 0x81, 29, 0x74, 3);
        Ui.i().drawK1(0xC0, 260, 0x102, 97, 2);
        Ui.i().drawYesNo(false, true);
        Ui.i().drawUi(this.cur_a + 5, 0xC2, 37, 0, 0);
        Log.e("sk", "drawUi");
        Ui.i().drawString(this.getNameMon(id) + "（" + (this.monInfoList[id] == 2 ? "已捕获" : "未捕获") + "）", 320, 6, 17, 0, 0);
        if(this.drawCartoonOne(1, 1, this.mList_id[id][1] * 3 + this.mon_action, 0xF2, 0x73, this.mon_action != 1, 0)) {
            this.mon_action = 0;
        }
        Ui.i().drawString("发现地点", 297, 35, 0, 1, 1);
        if(this.monAppearMap[id][0] > -1) {
            for(int i = 0; i < this.monAppearMap[id].length; i = (byte)(i + 1)) {
                Ui.i().drawString(this.city_name[this.monAppearMap[id][i]].toString(), 297, 35 + (i + 1) * 25, 0, 1, 0);
            }
        }
        else {
            Ui.i().drawString("未知", 297, 60, 0, 1, 0);
        }
        Ui.i().drawString("进", 206, 0x91, 17, 3, 1);
        Ui.i().drawString("化", 206, 0xB6, 17, 3, 1);
        Ui.i().drawListKY(3, 0xE5, 0x87, 0xE2, 3, 33, 0, -1, 4, 2);
        int i = 2;
        for(int j = 0; i < 7; j = (byte)(j + 1)) {
            Ui.i().drawString("材料：" + (this.monsterMake[id].length != 0 && i < this.monsterMake[id].length ? this.getNameItem(((int)this.monsterMake[id][i])) + " x" + ((int)this.monsterMake[id][i + 1]) : ""), 0xEB, j * 33 + 0x89, 0, 3, 0);
            i = (byte)(i + 2);
        }
        this.showStringM(this.getNameMonsterInfo(id), 320, 0x105, 10, 3);
        byte b = (byte)(this.mon_action_c + 1);
        this.mon_action_c = b;
        if(b > 50) {
            this.mon_action_c = 0;
            this.mon_action = 1;
        }
    }

    private void drawMONSTER_UI(Monster[] monsters) {
        Ui.i().fillRectB();
        Ui.i().drawK2(180, 2, 280, 358, 0);
        Ui.i().drawK1(0xBA, 11, 0x76, 0x74, 1);
        if(this.t_length != 0) {
            this.drawMonsterHp(monsters[this.select[0][0]], 0xD8, 5, 74, 2, 2, ((int)monsters[this.select[0][0]].monsterPro[4]));
            Ui.i().drawNum(((int)monsters[this.select[0][0]].monster[2]) + "级", 0xBC, 15, 0, 0);
            Ui.i().drawUi(monsters[this.select[0][0]].monster[3] + 5, 0xC3, 16, 17, 0);
            if(this.drawCartoonOne(1, 1, this.mList_id[monsters[this.select[0][0]].monster[0]][1] * 3 + this.mon_action, 0xF8, 0x6F, this.mon_action != 1, 0)) {
                this.mon_action = 0;
            }
        }
        Ui.i().drawK1(0xBA, 0x8F, 0x10C, 0xD4, 1);
        Ui.i().drawK(0xC2, 0x99, 0xFC, 33, 3);
        Ui.i().drawK(0xC2, 304, 0xFC, 33, 3);
        if(this.t_length != 0) {
            this.gogoWord(this.getNameMonsterInfo(((int)monsters[this.select[0][0]].monster[0])), 0xC3, 306, 0xC6, 0, 1, 2);
            this.drawMonsterFealty(monsters[this.select[0][0]], 0xBC, 0x81);
            Ui.i().drawString(this.monsterT[monsters[this.select[0][0]].monster[3]].toString(), 0xD3, 0x9B, 0, 0, 1);
            if(monsters[this.select[0][0]].monster[5] == 0) {
                Ui.i().drawString("不可进化", 301, 0x9B, 0, 0, 1);
            }
            else {
                Ui.i().drawString("可进化" + ((int)monsters[this.select[0][0]].monster[5]) + "次", 301, 0x9B, 0, 0, 1);
            }
        }
        this.drawMonPro(monsters, 0xBA, 0x8F);
        if(this.t_length != 0) {
            this.drawMonList(monsters, 372, 13, ((int)this.list_rows), ((int)this.t_length), this.select[0]);
        }
        Ui.i().sliding(443, 12, 0x7A, ((int)this.select[0][0]), ((int)this.t_length), true);
        Ui.i().drawNum(((int)this.t_length) + "/" + (this.mini_state == 6 ? this.max_monsters : this.max_takes), 420, 12, 0, 0);
        if(this.popMenu != -1) {
            this.drawSelectMenu(this.about_d, 295, 30, 75, 2, 0, ((int)this.popMenu));
            if(this.buyOk == 1) {
                this.showString(this.gogoString, 0x9B, 0);
            }
        }
        Ui.i().drawYesNo(this.t_length != 0, true);
    }

    private void drawMY_BAG(int x, int y, int w, int h) {
        int i = (byte)(this.action_str.length - 1);
        Ui.i().fillRectB();
        Ui.i().drawK2(x + 1, y + 3, w - 2, h - 3, 0);
        Ui.i().drawK1(x + 5, y + 39, w - 23, this.list_rows * 0x1F, 1);
        Ui.i().drawK1(x + 5, y + 45 + this.list_rows * 0x1F, w - 10, 90, 2);
        if(i == 0) {
            Ui.i().drawK1((w >> 1) + x - 34, y + 8, 66, 28, 4);
            Ui.i().drawString(this.action_str[0], (w >> 1) + x, y + 7, 17, 0, 0);
            Log.e("sk", "drawMY_BAG");
        }
        else {
            Ui.i().drawK1((this.selectx + 1) * w / 5 + x - 22, y + 8, 70, 28, 4);
            while(i > -1) {
                Ui.i().drawString(this.action_str[i], (i + 1) * w / 5 + x - 14, y + 7, 0, (this.selectx == i ? 0 : 1), 0);
                i = (byte)(i - 1);
            }
            Ui.i();
            if(this.popMenu == -1) {
                byte b = this.pkey.selectMenuX(4, 0, 0, w / 4, 35);
                if(b != -1) {
                    this.selectx = b;
                    this.select[0][1] = this.select_st[this.selectx];
                    this.select[0][0] = this.select_it[this.selectx];
                }
            }
        }
        this.drawItemList(x + 9, y + 42, w - 23, ((int)this.list_rows), this.select[0], ((int)this.selectx), ((int)this.itemsLength[this.selectx]), 0);
        Ui.i().sliding(x + w - 15, y + 42, this.list_rows * 0x1F - 6, ((int)this.select[0][0]), ((int)this.itemsLength[this.selectx]), true);
        if(this.itemsLength[this.selectx] > 0) {
            this.showStringM(this.item_help[this.items[this.selectx][this.select[0][0]][0]].toString(), x + (w >> 1), this.list_rows * 0x1F + (y + 0x2F), 10, 3);
        }
        this.drawMoney((w >> 1) + x, y + h - 2, 0, this.selectx == 2);
        Ui.i().drawYesNo(this.itemsLength[this.selectx] != 0, true);
        if(this.popMenu != -1) {
            this.drawSelectMenu(this.about_a, (w >> 1) + x - 33, 50, 75, 2, 0, ((int)this.popMenu));
        }
    }

    public boolean drawMagicC(int i, int skill_mode, int select, int x, int y, int dir) {
        if(this.now_action_Magic[i] >= this.magic[skill_mode].aLength(select)) {
            this.now_action_Magic[i] = 0;
            return true;
        }
        for(int frame_id = (short)this.magic[skill_mode].action(select, ((int)this.now_action_Magic[i]), 0); true; frame_id = (short)this.magic[skill_mode].action(select, ((int)this.now_action_Magic[i]), 0)) {
            if(this.dm == null || frame_id >= 2) {
                Ui.i().drawFrameOne(this.magic[skill_mode], frame_id, x, y, dir);
                return this.setCartoonFrameMagic_C(i, skill_mode, select, true);
            }
            if(frame_id == 0) {
                this.dm.ceff[0] = 2;
            }
            this.now_time_Magic[i] = 0;
            short[] arr_v = this.now_action_Magic;
            short v7 = (short)(arr_v[i] + 1);
            arr_v[i] = v7;
            if(v7 >= this.magic[skill_mode].aLength(select)) {
                this.now_action_Magic[i] = 0;
                return true;
            }
        }
    }

    private void drawMagicUI(Monster monsters) {
        int v1;
        Ui.i().fillRect(0x52BDEF, 0, 0, 640, 360);
        this.drawBG0(((int)this.bg_c), 0xB5, 108, 0, 0x10B);
        if(this.pkey.selectMenuX(2, 0xB5, 108, 120, 29) != -1) {
            Ms.key = -3;
            Ms.keyRepeat = true;
        }
        Ui.i().drawK1(320 + (this.popMenu == 0 ? 0xFFFFFF71 : 21), 0x6F, 0x7B, 27, 4);
        Ui.i().drawString("普通技能", 295, 109, 24, (this.popMenu == 0 ? 0 : 1), 0);
        Ui.i().drawString("天赋技能", 345, 109, 0, (this.popMenu == 0 ? 1 : 0), 0);
        if(this.drawCartoonOne(1, 1, this.mList_id[monsters.monster[0]][1] * 3 + this.mon_action, 377 - this.move_x, 97 - this.move_y, this.mon_action != 1, 0)) {
            this.mon_action = 0;
        }
        this.move_x = Ms.i().mathSpeedDown(((int)this.move_x), 3, false);
        this.move_y = Ms.i().mathSpeedDown(((int)this.move_y), 3, false);
        if(this.popMenu == 0) {
            this.drawSkillList(0xBC, 0x91, 0xEE, 0x1F, 5, this.select[0]);
            if(this.skill_list[this.select[0][0]] != -1) {
                this.gogoWord(this.skill_help[this.skill_list[this.select[0][0]]].toString(), 0xBF, 313, 200, 0, 1, 2);
            }
        }
        else {
            this.drawBuffList(monsters, 0xBC, 0x91, 0xEE, 0x1F, 5, this.select[0]);
            if(monsters.monster[this.select[0][0] + 16] > 0) {
                this.showStringM(this.buff_help[monsters.monster[this.select[0][0] + 16]].toString(), 320, 0x120, 9, 0);
            }
        }
        Ui ui0 = Ui.i();
        int v = this.select[0][0];
        if(this.popMenu == 0) {
            v1 = this.skill_list[8];
        }
        else {
            v1 = monsters.monster[this.select[0][0] + 16] <= 0 ? 1 : 2;
        }
        ui0.sliding(434, 0x92, 0x84, v, v1, true);
        if(this.mini_state != 13) {
            Ui.i();
            Ui.i().drawYesNo(false, true);
            return;
        }
        Ui.i().drawYesNo(true, true);
    }

    private void drawMonKind(byte monKind, int x, int y, int arh) {
        for(int i = 0; i < 5; i = (byte)(i + 1)) {
            Ui.i().drawUi((monKind <= i ? 24 : 23), i * 14 + x, y, arh, 0);
        }
    }

    private void drawMonList(Monster[] monster, int x, int y, int show_num, int max_length, byte[] select) {
        byte i = select[1];
        if(this.mini_state != 6) {
            Ui.i().drawUi(34, x - 55, y + 2, 24, 0);
        }
        while(i < select[1] + show_num && i < max_length) {
            if(select[0] == i) {
                Ui.i().drawK(x - 50, (i - select[1]) * 29 + y, 108, 26, 1);
            }
            Ui.i().drawString(this.getNameMon(((int)monster[i].monster[0])).toString(), x + 4, y - 2 + (i - select[1]) * 29, 17, (select[0] == i ? 0 : 1), 1);
            if(this.popMenu == -1 && this.pkey.isSelect(x - 50, (i - select[1]) * 29 + y, 100, 26)) {
                if(select[0] == i) {
                    Ms.key = 53;
                    Ms.keyRepeat = true;
                }
                else {
                    select[0] = i;
                    if(i - select[1] == 0 && select[1] > 0) {
                        select[1] = (byte)(select[1] - 1);
                    }
                    else if(i - select[1] == show_num - 1 && select[1] + show_num < max_length) {
                        select[1] = (byte)(select[1] + 1);
                    }
                    this.initMonStream(2, ((int)this.mList_id[monster[select[0]].monster[0]][0]), 1);
                    this.setShowPro(monster[select[0]]);
                    this.introT = Constants_H.WIDTH_H;
                    this.introX = Constants_H.WIDTH_H;
                }
            }
            i = (byte)(i + 1);
        }
    }

    private void drawMonPro(Monster[] monsters, int lx, int ly) {
        Ui.i().drawStringY(this.about_a, lx + 18, ly + 44, 0, 3, 0x1F, 3, 0);
        Ui.i().drawStringY(this.about_b, lx + 0xA0, ly + 44, 0, 3, 0x1F, 3, 0);
        if(this.t_length != 0) {
            Ui.i().drawStringY(this.about_c, lx + 0xD7, ly + 44, 0, 3, 0x1F, -1, 0);
            this.drawMonsterHp(monsters[this.select[0][0]], lx + 73, ly + 59, 0x30, 0, 0, ((int)monsters[this.select[0][0]].monsterPro[0]));
            this.drawMonsterHp(monsters[this.select[0][0]], lx + 73, ly + 87, 0x30, 1, 0, ((int)monsters[this.select[0][0]].monsterPro[1]));
            this.drawMonKind(monsters[this.select[0][0]].monster[4], lx + 73, ly + 104, 0);
        }
    }

    public void drawMoney(int x, int y, int c, boolean bb) {
        String s = (bb ? this.coin : this.money) + (bb ? "徽章" : "金");
        Ui.i().drawUi((bb ? 53 : 52), x - (Ms.i().getStringWidth(s) >> 1) - 1, y, 40, 0);
        Ui.i().drawString(s, x, y + 3, 33, c, 1);
    }

    private void drawMonsterFealty(Monster monster, int x, int y) {
        this.drawFealty(((int)(((byte)(this.initFealty[(monster.monster[4] >= 4 ? 1 : 0)] / 20)))), ((int)(((byte)(monster.monster[6] / 20)))), x, y);
    }

    private void drawMonsterHp(Monster monster, int x, int y, int w, int mode, int type, int t2) {
        int t1;
        int t0;
        if(mode < 2) {
            t0 = monster.monsterPro[mode];
            t1 = monster.monsterPro[mode + 2];
        }
        else {
            if(t2 == 0) {
                t2 = monster.monsterPro[4];
            }
            t0 = (short)t2;
            t1 = this.getMonsterExp(monster);
        }
        Ui.i().drawBarOne(x, y, w, Ms.i().mathPercent(t2, w - 2, t1), Ms.i().mathPercent(t0, w - 2, t1), mode);
        if(type != 2) {
            String s = t0 + "/" + t1;
            Ui.i().drawNum(s, (w - s.length() * 8 >> 1) + x, (type == 1 ? 5 : 0) + y, 0, 0);
        }
    }

    public void drawMyMon() {
        this.drawEffectImage(this.myB.getMon(), 220, 0xA4);
        if(this.drawCartoonOne(1, 1, this.mList_id[this.myB.getMon().monster[0]][1] * 3 + this.myB.action, (this.myB.ceff[0] == 0 ? 0 : -3) + 0x10A, (this.myB.ceff[0] == 0 ? 0 : 3) + 0xEC, this.myB.action == 0, 1)) {
            if(this.myB.getMon().monsterPro[0] < 1) {
                this.myB.action = 2;
                this.myB.dead = 1;
            }
            else {
                this.myB.action = 0;
            }
        }
        byte[] arr_b = this.myB.ceff;
        arr_b[0] = (byte)Ms.i().mathSpeedN(((int)this.myB.ceff[0]), 0, 1, true);
        this.drawMonsterHp(this.myB.getMon(), 0xF1, 0xED, 50, 0, 1, ((int)this.myB.chp));
        this.drawMonsterHp(this.myB.getMon(), 0xF1, 0xF2, 50, 1, 2, ((int)this.myB.getMon().monsterPro[1]));
        Battle battle0 = this.myB;
        battle0.chp = Ms.i().mathSpeedN(this.myB.chp, this.myB.getMon().monsterPro[0], (this.myB.chp >= this.myB.getMon().monsterPro[0] ? 6 : 20), true);
    }

    private void drawMyMonState() {
        Ui.i().drawK(10, 140, 0xB3, 110, 2);
        Ui.i().drawKuang(12, 0x8E, 0x93, 33);
        Ui.i().drawUi(this.myB.getMon().monster[3] + 5, 26, 0x9C, 3, 0);
        Ui.i().drawString(this.getNameMon(((int)this.myB.getMon().monster[0])).toString(), 99, 0x8D, 17, 4, 2);
        Ui.i().drawNum(((int)this.myB.getMon().monster[2]) + "级", 0xA2, 0xA0, 0, 0);
        Ui.i().drawK0(12, 0xB0, 62, 14, 4);
        Ui.i().drawUi(34, 14, 0xB1, 0, 0);
        Ui.i().drawNum(this.myB.countS[0] + 100 + "%", 70, 0xBD, 1, 1);
        Ui.i().drawString("宠物档次", 12, 0xC3, 20, 4, 2);
        this.drawMonKind(this.myB.getMon().monster[4], 0x76, 203, 0);
        Ui.i().drawString("兴奋度", 12, 0xDE, 20, 4, 2);
        this.drawMonsterFealty(this.myB.getMon(), 0x72, 0xE8);
    }

    private void drawNidus(int x, int w) {
        int v2;
        String s;
        if(this.mini_state == 16) {
            this.drawSelectMenu(this.about_d, 0xF5, 180 - (this.about_d.length >> 1) * 25, 150, 1, 0, ((int)this.popMenu));
            return;
        }
        Ui.i().fillRectB();
        this.drawBG0(((int)this.bg_c), x + 1, 108, 0, w);
        Log.e("sk", "drawNidus");
        Ui.i().drawString(this.popMenu + 1 + "/" + 5, x + 10, 106, 36, 0, 2);
        Ui ui0 = Ui.i();
        if(this.getRid(((int)this.popMenu)) == -2) {
            s = "此位置目前是空的";
        }
        else {
            StringBuilder stringBuilder0 = new StringBuilder();
            StringBuffer[] arr_stringBuffer = this.monsterT;
            byte[][] arr2_b = this.monster_pro;
            s = stringBuilder0.append(arr_stringBuffer[arr2_b[this.getNid(((int)this.popMenu))][6]]).append("的宠物蛋").toString();
        }
        ui0.drawString(s, x + 20, 110, 0, 1, 0);
        if(this.getRid(((int)this.popMenu)) != -2) {
            if(this.b_c < 2 && this.drawCartoonOne(1, 1, this.mon_action, 377, 97, this.b_c != 1, 0)) {
                byte[][] arr2_b1 = this.mList_id;
                this.initMonStream(2, ((int)arr2_b1[this.getNid(((int)this.popMenu))][0]), 1);
                this.b_c = 2;
            }
            else if(this.b_c > 1 && this.b_c < 14) {
                byte[][] arr2_b2 = this.mList_id;
                this.drawClipPic(((int)arr2_b2[this.getNid(((int)this.popMenu))][1]), 1, 377, 97, 80, 77, 15, this.b_c - 2, 0);
                byte b = (byte)(this.b_c + 1);
                this.b_c = b;
                if(b == 14) {
                    this.b_c = -1;
                }
                byte[][] arr2_b3 = this.mList_id;
                this.mon_action = (byte)(arr2_b3[this.getNid(((int)this.popMenu))][1] * 3);
            }
            if(this.b_c == -1) {
                Ui.i().drawStringY(this.about_a, x + 26, 0x9B, 0, 3, 30, 3, 0);
                Ui.i().drawStringY(this.about_b, x + 0x7E, 0x9B, 0, 3, 30, 3, 0);
                Ui.i().drawString("档次：", x + 70, 0x102, 0, 3, 1);
                byte[][] arr2_b4 = this.monster_pro;
                this.drawMonKind(arr2_b4[this.getNid(((int)this.popMenu))][5], x + 0x85, 0x107, 0);
            }
            else {
                this.str_cur = this.getNexp(((int)this.popMenu), 1) + "/" + this.getNexp(((int)this.popMenu), 3);
                Ui.i().drawBarOne(x + 20, 0x9E, ((int)(((short)(w - 40)))), Ms.i().mathPercent(this.getNexp(((int)this.popMenu), 1), ((short)(w - 40)) - 2, this.getNexp(((int)this.popMenu), 3)), Ms.i().mathPercent(this.getNexp(((int)this.popMenu), 1), ((short)(w - 40)) - 2, this.getNexp(((int)this.popMenu), 3)), 2);
                Ui.i().drawNum(this.str_cur, x + 20 + (((short)(w - 40)) - this.str_cur.length() * 8 >> 1), 0xA4, 0, 0);
                Ui.i().drawString((this.getNexp(((int)this.popMenu), 1) == this.getNexp(((int)this.popMenu), 3) ? "孵化已完成" : "孵化中..."), x + 20 + (((short)(w - 40)) >> 1), 0xA4, 17, 3, 1);
                Ui.i().drawString("孵化所需材料", x + 20 + (((short)(w - 40)) >> 1), 0xD0, 17, 3, 1);
                this.drawEvolveMake(this.getNid(((int)this.popMenu)), x + 25, 0xEF, 28);
            }
            if(this.getNexp(((int)this.popMenu), 1) == this.getNexp(((int)this.popMenu), 3)) {
                Ui.i().drawString("按确定键完成孵化", x + 20, 314, 0, 0, 0);
            }
        }
        if(this.b_c == -2) {
            Ui.i();
        }
        Ui.i().drawYesNo(this.getRid(((int)this.popMenu)) != -2, this.b_c != -1);
        switch(this.pkey.selectMenuX(2, 0, 0, 320, 360)) {
            case -1: {
                return;
            }
            case 0: {
                v2 = -3;
                break;
            }
            default: {
                v2 = -4;
                break;
            }
        }
        Ms.key = v2;
        Ms.keyRepeat = true;
    }

    public void drawPauseIco(int state) {
        for(int i = 0; i < this.b_ico; i = (byte)(i + 1)) {
            Ui.i().drawImage(this.imgIco[i], this.pkey.button_pos[6][i][0], this.pkey.button_pos[6][i][1], 0);
        }
    }

    private void drawPlayer(Graphics g) {
        this.drawMyMon();
        this.drawMyMonState();
        this.drawEnemy();
        this.drawEnemyState();
    }

    private void drawPlayerAppear(Graphics g) {
        if(this.battle_state != 0) {
            return;
        }
        if(this.battle_type <= 2) {
            if(this.battle_type < 2) {
                Monster monster0 = this.enB.getMon();
                this.drawThrowBall(this.enB, monster0, 0, 377, 97);
            }
        }
        else if(this.src_c[2] == 0 && this.enB.throw_state == -1 && this.src_c[0] == 12) {
            this.enB.throw_state = 0;
        }
        else if(this.enB.throw_state == 0 || this.enB.throw_state == 2) {
            this.drawCartoonOne(0, 0, this.mList_id[this.enB.getMon().monster[0]][1] * 3 + this.enB.action, this.enemyOff + 377, 97, false, 0);
            this.enemyOff = Ms.i().mathSpeedN(this.enemyOff, 0, 4, false);
            if(this.enemyOff == 0) {
                this.enB.throw_state = 2;
            }
        }
        Monster monster1 = this.myB.getMon();
        this.drawThrowBall(this.myB, monster1, 1, 0x10A, 0xEC);
    }

    private void drawSelectMenu(Graphics g, boolean bb, int y) {
        Ui.i().drawK2(200, y + 15, 0xF0, 340 - y, 0);
        this.drawBattleExp(this.myB.getMon(), y + 3);
        if(!bb) {
            Ui.i().drawString("要做什么？", 450, 10, 0, 0, 2);
            for(int i = 0; i < this.imgBattle.length; i = (byte)(i + 1)) {
                Ui.i().drawImage(this.imgBattle[i], this.pkey.button_pos[5][i][0], this.pkey.button_pos[5][i][1], 0);
            }
        }
    }

    private void drawSkillList(int x, int y, int w, int fontH, int show_num, byte[] sel) {
        byte i = sel[1];
        Ui.i().drawListKY(show_num, x, y, w, 3, fontH, 0, sel[0] - sel[1], 4, 2);
        while(i < sel[1] + show_num && i < this.skill_list[8]) {
            Ui.i().drawUi((this.skill_list[i] <= 25 ? 51 : 50), x + 8, y + 8 + (i - sel[1]) * fontH, 0, 0);
            Log.e("sk", "普通攻击");
            Ui.i().drawString(this.getNameSkill(this.skill_list[i]).toString(), x + 21, y + 1 + (i - sel[1]) * fontH, 0, (sel[0] == i ? 0 : 3), 0);
            Ui.i().drawString((this.skill_list[i] > 30 ? "被动" : ((int)this.skill[this.skill_list[i]][1]) + "能量"), x + w - 8, y + 1 + (i - sel[1]) * fontH, 24, (sel[0] == i ? 0 : 3), 0);
            if(this.say_c < 1 && this.pkey.isSelect(x, (i - sel[1]) * fontH + y, w, fontH)) {
                if(sel[0] == i) {
                    this.pkey.setKey5();
                }
                else {
                    sel[0] = i;
                    if(i - sel[1] == 0 && sel[1] > 0) {
                        sel[1] = (byte)(sel[1] - 1);
                    }
                    else if(i - sel[1] == show_num - 1 && sel[1] + show_num < this.skill_list[8]) {
                        sel[1] = (byte)(sel[1] + 1);
                    }
                }
            }
            i = (byte)(i + 1);
        }
    }

    private void drawThrowBall(Battle be, Monster mon, int mini, int x, int y) {
        if(be.throw_state == 0) {
            Ui.i().drawImage(this.imgItem[0], be.cThrow[0] + x, y - be.cThrow[1], 33);
        }
        else {
            switch(be.throw_state) {
                case 1: {
                    this.drawClipPic(((int)this.mList_id[mon.monster[0]][1]), mini, x, y, 80, 77, 15, ((int)be.cThrow[2]), mini);
                    break;
                }
                case 2: {
                    this.drawCartoonOne(mini, mini, this.mList_id[mon.monster[0]][1] * 3, x, y, true, mini);
                }
            }
        }
        this.runThrowBall(be, mon, mini);
    }

    private void drawVIEW_COMPUTER() {
        Ui.i().drawK2(0x106, 0x7A, 0x74, 0xA6, 0);
        this.drawSelectMenu(this.about_d, 291, 0x9B, 58, 2, 0, ((int)this.popMenu));
        Ui.i().drawString("寄存宠物", 320, 0x7C, 17, 1, 1);
        Ui.i().drawYesNo(true, true);
    }

    private void effectR(Monster monster) {
        if(monster.effect_time > 0) {
            monster.effect_time = (byte)(monster.effect_time - 1);
        }
        if(monster.effect_time == 0) {
            monster.effect = 7;
        }
    }

    private void enemy_init() {
        Monster[] eMonsters = new Monster[this.enemyList.length];
        for(int i = 0; i < this.enemyList.length; ++i) {
            eMonsters[i] = new Monster(this, this.enemyList[i][0], this.enemyList[i][1], (this.myMonsters[0].isMonReel(39) ? 1 : 0));
            if(this.battle_type == 0 || this.battle_type == 3) {
                if(eMonsters[i].monster[3] == -1) {
                    eMonsters[i].resetBoss(((int)this.enemyList[i][4]));
                }
                else {
                    eMonsters[i].resetMonster(((int)this.enemyList[i][2]), ((int)this.enemyList[i][3]), ((int)this.enemyList[i][4]));
                }
                eMonsters[i].resetPro(this);
            }
            else {
                eMonsters[i].resetMonster(this, -1);
            }
        }
        this.enemyList = null;
        this.enB = new Battle(eMonsters);
    }

    public void exitNidus() {
        GameRun.run_state = -10;
        this.mon[1] = null;
        this.initNidusMap(1);
    }

    public void falselly(int id) {
        SMSSender.i(this).setSendSms(-1);
        try {
            if(id == 7) {
                SMSSender.i(this).sms_a = true;
                this.goGameOver();
                System.out.println("ccccccccc");
                GameRun.mc.setSmsIsSetRun_state(true);
                return;
            }
            switch(id) {
                case 5: {
                    GameRun.run_state = SMSSender.i(this).getTstate();
                    GameRun.mc.temp_state = GameRun.run_state;
                    GameRun.mc.setSmsIsSetRun_state(true);
                    return;
                }
                case 6: {
                    GameRun.run_state = -10;
                    GameRun.mc.temp_state = GameRun.run_state;
                    GameRun.mc.setSmsIsSetRun_state(true);
                    System.out.println("  我的mc.setSmsIsSetRun_state(true);");
                    this.map.setRegState(false);
                    return;
                }
                default: {
                    if(id == 1 && SMSSender.i(this).getSmsSenderMenuState() != 0) {
                        Log.d("soars", "soooooooooooooooooooooooooooooooooooooooo");
                        GameRun.mc.setSmsIsSetRun_state(true);
                        GameRun.run_state = SMSSender.i(this).getTstate();
                    }
                }
            }
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
    }

    public byte findItem(int item_type, int item_id, boolean bb) {
        if(item_type == -2) {
            item_type = this.findItemType(item_id);
        }
        for(byte i = 0; true; i = (byte)(i + 1)) {
            if(i >= this.itemsLength[item_type]) {
                return bb ? 0 : -1;
            }
            if(this.items[item_type][i][0] == item_id) {
                return bb ? this.items[item_type][i][1] : i;
            }
        }
    }

    public byte findItemType(int item_id) {
        if(item_id < 16) {
            return 0;
        }
        if(item_id < 35) {
            return 1;
        }
        return item_id >= 58 ? 3 : 2;
    }

    public byte findMonster(int id, int lv) {
        for(byte i = 0; true; i = (byte)(i + 1)) {
            if(i >= this.myMon_length) {
                return -1;
            }
            if(this.myMonsters[i].monster[0] == id && this.myMonsters[i].monster[2] >= lv) {
                return i;
            }
        }
    }

    public byte findMonsterMinLv(int id, int lv) {
        byte minLv = -1;
        for(byte i = (byte)(this.myMon_length - 1); i > -1; i = (byte)(i - 1)) {
            if(this.myMonsters[i].monster[0] == id && this.myMonsters[i].monster[2] >= lv && (minLv == -1 || this.myMonsters[i].monster[2] < this.myMonsters[minLv].monster[2])) {
                minLv = i;
            }
        }
        return minLv;
    }

    public boolean gameCheckRegIsOK() {
        boolean reged = this.rmsSms[6] == 10;
        System.out.println("gameCheckRegIsOK reged= " + reged);
        return reged;
    }

    private int getBXY(int state, int skill, boolean bb) {
        int x = 0x10A;
        int y = 0xEC;
        if(state == 1 && !this.isSkillToMe(skill) || state == 0 && this.isSkillToMe(skill)) {
            x = 377;
            y = 97;
        }
        return bb ? x : y;
    }

    private void getBattleBG(Battle be, Monster mon) {
        if(this.monPro.length != 0) {
            be.bg_id = this.monPro[0];
        }
        for(byte i = 0; true; i = (byte)(i + 1)) {
            if(i >= 5) {
                return;
            }
            if(mon.isMonReel(i + 43)) {
                be.bg_id = i;
                return;
            }
        }
    }

    private int getBuyItemCount(int type, int select, boolean bb) {
        if(bb) {
            int c0 = type == 2 ? this.coin / this.sell_money : this.money / this.sell_money;
            int c1 = 99 - this.findItem(-2, ((int)this.buyItem[this.cur_a][select]), true);
            if(c1 < 0) {
                c1 = 0;
            }
            return c0 <= c1 ? c0 : c1;
        }
        return this.items[this.cur_a][select][1];
    }

    public void getEnemy(byte[] enemy_list, int type, int level) {
        if(type == -1) {
            Ms.i();
            if(Ms.getRandom(100) < 5 && this.monPro.length > 6) {
                type = 6;
            }
            else {
                byte[] arr_b1 = this.monPro;
                Ms.i();
                type = arr_b1[Ms.getRandom((this.monPro.length <= 6 ? this.monPro.length - 3 : 3)) + 3];
            }
            Ms.i();
            enemy_list[1] = (byte)(Ms.getRandom(this.monPro[2] + 1) + this.monPro[1]);
        }
        else {
            enemy_list[1] = (byte)level;
        }
        enemy_list[0] = (byte)type;
    }

    private void getExpOne(boolean half) {
        this.exp = 0;
        Ms.i();
        Ms.skip2 = this.enB.mon[0].monster[2];
        for(int i = 0; i < this.enB.mon.length; i = (byte)(i + 1)) {
            this.exp = (short)(this.exp + (this.enB.mon[i].monster[2] * 3 + 80));
            int v1 = this.enB.mon[i].monster[2];
            Ms.i();
            if(v1 > Ms.skip2) {
                Ms.i();
                Ms.skip2 = this.enB.mon[i].monster[2];
            }
        }
        this.exp = (short)(this.exp * (56 / this.mon_in_battle[0] - (this.mon_in_battle[0] - 1) * 2 + 44) / 100);
        if(!half) {
            this.exp = (short)(this.exp / 2);
        }
    }

    private void getHitCoefficient(Battle be, Monster am, Monster dm) {
        be.countS[1] = 0;
        int coe = (byte)(am.monster[6] - 99);
        be.countS[1] = (byte)(be.countS[1] + (coe <= 1 ? coe / 20 * 20 : 20));
        if(am.monster[3] != -1 && be.bg_id != am.monster[3]) {
            be.countS[1] = (byte)(be.countS[1] + (be.bg_id == am.monster[3] ? 0 : -20));
        }
        int v1 = this.isShuXing(am, dm);
        be.countS[1] = (byte)(be.countS[1] + v1);
    }

    private String getInfoType(int i) {
        switch(i) {
            case -5: {
                return "孵化";
            }
            case -4: {
                return "竞技场";
            }
            case -3: {
                return "异化";
            }
            case -2: {
                return "进化";
            }
            case -1: {
                return "任务";
            }
            default: {
                return "捕获";
            }
        }
    }

    public byte getItem(int item_id, int count) {
        if(this.addItem(item_id, count) == 1) {
            this.say("获得：“" + this.getNameItem(((int)(((byte)item_id)))) + "”x" + count, 0);
            return 1;
        }
        return -1;
    }

    public byte getItemCount(int id) {
        if(this.buyItemID != 2) {
            for(int i = 0; i < this.items[this.item_type].length; ++i) {
                if(this.items[this.item_type][i][0] == id) {
                    return this.items[this.item_type][i][1];
                }
            }
        }
        return 0;
    }

    public void getMagic(Monster monster) {
        this.getSkill = -1;
        for(int i = 0; i < 6; i = (byte)(i + 1)) {
            if(monster.monster[i + 8] == -1 && monster.monster[2] >= new byte[]{0, 7, 14, 21, 28, 35}[i]) {
                this.getSkill(i, ((int)monster.monster[3]));
                monster.monster[i + 8] = this.getSkill;
            }
        }
    }

    private byte getMonInfo_dir() {
        return this.monInfo_dir[this.cur_a][this.getSelInfo()];
    }

    private byte getMonster(Monster monster, int evolve, boolean bb) {
        if(this.monInfoList[monster.monster[0]] != 2) {
            this.monInfoList[monster.monster[0]] = 2;
            this.addMonInfoListBH();
            this.map.addAnole(((int)monster.monster[0]));
        }
        if(this.myMon_length < this.max_takes) {
            this.myMonsters[this.myMon_length] = monster;
            if(bb) {
                this.myMonsters[this.myMon_length].resetMonster(this, evolve);
            }
            this.myMon_length = (byte)(this.myMon_length + 1);
            return 0;
        }
        if(this.cMon_count < this.max_monsters) {
            this.say("携带已满，" + this.getNameMon(((int)monster.monster[0])) + "已转入寄放处", 0);
            this.cMonsters[this.cMon_count] = monster;
            if(bb) {
                this.cMonsters[this.cMon_count].resetMonster(this, evolve);
            }
            this.cMon_count = (byte)(this.cMon_count + 1);
            return 1;
        }
        return -1;
    }

    public byte getMonster(int id, int level, int evolve, int buff) {
        Monster enemyMB = new Monster(this, id, level, buff);
        if(this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
            this.say("宠物空间已满", 0);
            return -1;
        }
        if(this.getMonster(enemyMB, evolve, true) != 1) {
            this.say("获得宠物：" + this.getNameMon(((int)(((byte)id)))), 0);
            return 1;
        }
        this.say("携带已满，" + this.getNameMon(((int)enemyMB.monster[0])) + "已转入寄放处", 0);
        return 1;
    }

    private short getMonsterExp(Monster monster) {
        return (short)(monster.monster[2] * 210 / 10 - 2);
    }

    private String getNameBuff(int buff_id) {
        if(buff_id < 1) {
            buff_id = 0;
        }
        return this.buff_name[buff_id].toString();
    }

    public String getNameCity(int id) {
        return this.city_name[id].toString();
    }

    public String getNameItem(int item_id) {
        return this.item_name[item_id].toString();
    }

    public String getNameMon(int mon_id) {
        return this.NAME[mon_id].toString();
    }

    public String getNameMonsterInfo(int id) {
        return this.monsterInfo[id].toString();
    }

    private String getNameSkill(byte skill_id) {
        return this.skill_name[skill_id].toString();
    }

    private short getPrice(int type, int select, boolean bb) {
        short price;
        if(bb) {
            if(type == 2) {
                price = this.buyPrice[1][select];
                return this.view_state == -1 ? ((short)(price * 12 / 10)) : price;
            }
            price = this.buyPrice[0][this.buyItem[this.cur_a][select]];
            return this.view_state == -1 ? ((short)(price * 12 / 10)) : price;
        }
        return (short)(this.buyPrice[0][select] / 5);
    }

    private byte getSelInfo() {
        return this.select[0][0];
    }

    private void getSkill(int skill_level, int pro) {
        this.getSkill = skill_level == 0 ? 25 : this.skill_up[skill_level - 1][pro];
    }

    private int getSkillLevel(int skill) {
        if(skill == 25) {
            return 0;
        }
        return skill < 25 ? skill % 5 + 1 : this.makeLevel[skill - 26];
    }

    private int getSkillMana(Monster mon, int sl) {
        int vaule = this.skill[sl][1];
        return mon.monster[3] != 4 || !mon.isMonReel(35) ? vaule : this.skill[sl][0] * vaule / 100;
    }

    private short getbuffRateV(Monster mon, int temp) {
        if(mon.isBuffRate(2)) {
            return (short)(temp + this.inhesion[2] * temp / 100);
        }
        return mon.isBuffRate(1) ? ((short)(temp + this.inhesion[1] * temp / 100)) : ((short)temp);
    }

    public void goBUY_ITEM(int id, int mode) {
        if(mode == 1) {
            this.setAction_str(new String[]{"道具", "辅助", "卷轴"});
        }
        else {
            this.setAction_str(new String[]{"道具", "矿石", "徽章"});
        }
        this.cur_a = (byte)id;
        this.cur_b = (byte)mode;
        byte[] arr_b = this.select[0];
        this.select[0][0] = 0;
        arr_b[1] = 0;
        GameRun.run_state = 18;
        this.list_rows = 6;
        this.buyOk = 0;
        this.popMenu = -1;
        byte[] arr_b1 = Ms.i().getStream("data/shop.d", -1);
        Ms.i();
        Ms.skip = 0;
        this.buyItem = Ms.i().create2Array(arr_b1);
        this.buyPrice = Ms.i().createShort2Array(arr_b1, 0);
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
        for(byte i = 0; i < this.myMon_length; i = (byte)(i + 1)) {
            this.myMonsters[i].effect = 7;
            this.myMonsters[i].effect_time = 0;
            this.myMonsters[i].monster[1] = i;
            this.proReplace[i][6] = this.myMonsters[i].monster[2];
        }
        for(int i = 0; i < this.myMon_length; i = (byte)(i + 1)) {
            if(this.myMonsters[i].monsterPro[0] > 0) {
                byte[] arr_b = this.mon_in_battle;
                byte[] arr_b1 = this.mon_in_battle;
                byte b1 = (byte)(arr_b1[0] + 1);
                arr_b1[0] = b1;
                arr_b[b1] = this.myMonsters[i].monster[1];
                if(i == 0) {
                    break;
                }
                this.changeMonster(this.myMonsters[i], this.myMonsters[0]);
                break;
            }
        }
        if(this.effectImage == null) {
            this.effectImage = Ms.i().createImageArray(7, "data/brow/e");
        }
        if(this.imgBattle == null) {
            this.imgBattle = Ms.i().createImageArray(5, "data/battle/b");
        }
        this.map.my.state = 15;
        GameRun.run_state = -30;
        this.view_state = -1;
        new CreateThread(this, 1);
    }

    private void goBattleExp(boolean half) {
        this.battle_state = -5;
        this.cur_c = 0;
        this.b_c = 0;
        this.myB.now_id = this.myMonsters[this.myB.now_id].monster[1];
        this.proReplace[this.myB.now_id][2] = -2;
        this.arangeMonster();
        this.getExpOne(half);
    }

    private void goBattleItem() {
        this.battle_state = -4;
        this.cur_b = -1;
        StringBuffer sbuff = new StringBuffer();
        Ms.i();
        if(Ms.getRandom(100) < 50 && this.findItem(-2, 0x20, true) < 99) {
            this.addItem(0x20, 1);
            sbuff.append("获得：" + this.getNameItem(0x20) + "x1");
        }
        this.setStringB(sbuff.toString(), 10000, 0);
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

    public void goBattlePVC() {
        this.enemyList = null;
        this.enemyList = new byte[1][2];
        this.getEnemy(this.enemyList[0], -1, 0);
        Sound.i().setMusicId(6);
        Sound.i().setMusic(true);
        this.goBattle();
    }

    private void goBattleState() {
        this.setAction_str(new String[]{"攻击", "道具", "宠物", "商店", "逃跑"});
        GameRun.run_state = 0xFFFFFFE1;
        this.battle_state = this.mini_state == 1 ? 2 : 1;
    }

    private void goCatchMonster() {
        GameRun.run_state = -19;
        this.cThrowX = 0x83;
        this.cThrowY = -20;
        this.cThrowS = 0xB0;
        this.b_c = 0;
    }

    private void goGO_RUNINMAP() {
        this.b_c = 0;
        this.popMenu = -1;
        System.gc();
        GameRun.run_state = -11;
    }

    public void goGameOver() {
        GameRun.run_state = 60;
    }

    private void goLIST_INFO(boolean bb) {
        GameRun.run_state = 68;
        if(this.monInfo_dir == null) {
            byte[] arr_b = Ms.i().getStream("data/book.d", -1);
            Ms.i();
            Ms.skip = 0;
            this.monInfo_dir = Ms.i().create2Array(arr_b);
        }
        if(bb) {
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

    public void goMAIN_MENU() {
        GameRun.mc.logo_c = 29;
        GameRun.mc.image_logo = null;
        this.setNull(true);
        this.myMonsters = null;
        this.cMonsters = null;
        System.gc();
        GameRun.mc.createFlashImage();
        GameRun.mc.goMain_menu();
        this.setAction_str(new String[]{"读取进度", "新游戏", "声音", "游戏帮助", "关   于", "退出游戏"});
        int v = this.rmsOther[0] == -1 ? 1 : 0;
        this.selecty = (byte)v;
        this.selectx = (byte)v;
    }

    private void goMONSTER_INFO(int id) {
        GameRun.run_state = 67;
        this.initMonStream(2, ((int)this.mList_id[id][0]), 1);
    }

    private void goMY_BAG(int type) {
        this.mini_state = 15;
        this.list_rows = 6;
        GameRun.run_state = 25;
        this.popMenu = -1;
        if(this.view_state == 1) {
            this.setAction_str(new String[]{"道具", "辅助", "卷轴", "孵化"});
        }
        else {
            switch(this.view_state) {
                case -1: {
                    this.setAction_str(new String[]{"道具"});
                    break;
                }
                case 2: {
                    this.setAction_str(new String[]{"孵化"});
                }
            }
        }
        this.selectx = (byte)type;
        this.selecty = 0;
        this.select[0][1] = this.select_st[this.selectx];
        this.select[0][0] = this.select_it[this.selectx];
        Ms.i().correctSelect(this.select[0], ((int)this.itemsLength[this.selectx]), 6);
        this.itemMine = null;
        Ms.i();
        Ms.skip = 0;
        this.itemMine = Ms.i().create2Array(Ms.i().getStream("data/box.d", -1));
    }

    private void goMontsterAppear() {
        GameRun.run_state = -50;
        this.battle_state = 0;
        this.enemyOff = 0x3F;
        this.setAimBattle(1);
    }

    public void goNidus(int pop) {
        GameRun.run_state = 66;
        this.mini_state = 16;
        this.setStringB("查看孵化#n选择蛋#n离开", Constants_H.WIDTH, 3);
        this.popMenu = (byte)pop;
        this.b_c = -2;
    }

    private void goRUN_IN_MAP(boolean bb) {
        this.selecty = 0;
        this.selectx = 0;
        this.select[0][1] = 0;
        this.mini_state = 0;
        this.view_state = 0;
        GameRun.mc.game_state = 30;
        System.out.println("aaaaaaaaaaaaaaaaa");
        this.map.my.state = 0;
        if(!this.isChangeSound.booleanValue()) {
            Sound.i().setMusicId(((int)this.musicNo[this.map.mapNo]));
            Sound.i().setMusic(bb);
            Log.d("soars", "tttttttttttttttttttttt");
        }
        if(this.isChangeSound.booleanValue()) {
            Sound.i().setMusicId(((int)this.musicNo[this.map.mapNo]));
            Sound.i().setMusicForMenu(bb);
            Log.d("soars", "ffffffffffffffffffffffffffffffff");
        }
        GameRun.run_state = -10;
        this.createOver = 0;
        this.buyItemID = 0;
    }

    private void goSelectAction(int mini) {
        GameRun.run_state = 0xFFFFFFE1;
        this.battle_state = mini == 1 ? 2 : 1;
        this.setAimBattle(mini);
        if(mini == 1) {
            this.initSkillList(this.myB.getMon());
        }
        Monster monster0 = this.myB.getMon();
        Monster monster1 = this.enB.getMon();
        this.getHitCoefficient(this.myB, monster0, monster1);
        Monster monster2 = this.enB.getMon();
        Monster monster3 = this.myB.getMon();
        this.getHitCoefficient(this.enB, monster2, monster3);
    }

    public void goVIEW_COMPUTER(int pop) {
        GameRun.run_state = 65;
        this.setStringB("存放#n取出#n离开", Constants_H.WIDTH, 3);
        this.popMenu = (byte)pop;
    }

    public void goVIEW_MONSTER() {
        GameRun.run_state = 35;
        this.cur_c = 0;
        this.selecty = 0;
        this.selectx = 0;
        this.t_length = this.mini_state == 6 ? this.cMon_count : this.myMon_length;
        byte[] arr_b = this.select[0];
        this.select[0][1] = 0;
        arr_b[0] = 0;
        this.popMenu = -1;
        this.list_rows = 5;
        this.mon_action = 0;
        this.setStringB("生命#n能量#n档次", Constants_H.WIDTH, 0);
        this.setStringB("力量#n防御#n敏捷", Constants_H.WIDTH, 1);
        this.cur_mon = this.mini_state == 6 ? this.cMonsters[this.select[0][0]] : this.myMonsters[this.select[0][0]];
        if(this.t_length != 0) {
            this.setShowPro(this.cur_mon);
            this.initMonStream(2, ((int)this.mList_id[this.cur_mon.monster[0]][0]), 1);
        }
    }

    private void goView() {
        this.select[0][1] = this.selectx;
        this.select[0][0] = this.selecty;
        this.cur_c = 0;
        this.popMenu = -1;
        this.setStringB("生命#n能量#n档次", Constants_H.WIDTH, 0);
        this.setStringB("力量#n防御#n敏捷", Constants_H.WIDTH, 1);
    }

    public void goYouPAUSE(int sy) {
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
        this.gogoString = "金属克野兽，野兽克植物，植物克飞行，飞行克海洋，海洋克金属";
    }

    void healMonster(Monster monster) {
        monster.effect = 7;
        monster.monsterPro[1] = monster.monsterPro[3];
        monster.monsterPro[0] = monster.monsterPro[2];
    }

    public void healMonster(boolean bb) {
        for(int i = 0; i < this.myMon_length; i = (byte)(i + 1)) {
            this.healMonster(this.myMonsters[i]);
        }
        if(bb) {
            this.say("您携带的宠物已回复。", 0);
        }
    }

    private void hit_rate(Battle amB, Battle dmB, Monster am, Monster dm, int skill_no) {
        amB.initHit();
        dmB.initHit();
        this.hit_rate = am.monsterPro[5] - dm.monsterPro[5];
        this.hit_rate = this.hit_rate / 2 + 92 + amB.rate_off;
        Ms.i();
        int rand = (byte)Ms.getRandom(100);
        amB.rate_off = 0;
        if(skill_no > 26 && skill_no < 30) {
            switch(skill_no) {
                case 27: 
                case 28: {
                    amB.addHit(-this.skill[skill_no][0] * 10, 1, 1);
                    return;
                }
                case 29: {
                    dmB.addHit(am.monsterPro[6] * this.skill[29][0] + am.monsterPro[1], 1, 0);
                    amB.addHit(((int)am.monsterPro[1]), 4, 2);
                    return;
                }
                default: {
                    return;
                }
            }
        }
        if(rand < this.hit_rate || this.mini_state == 1 && am.monster[2] < 11) {
            this.damage(amB, dmB, am, dm, skill_no, this.mini_state ^ 1);
            if(skill_no == 26 && !dmB.getMon().isMonReel(40)) {
                Ms.i();
                if(Ms.getRandom(100) < this.skill[26][2]) {
                    dmB.addHit(this.skill[26][3] * dmB.getMon().monster[6] / 100, -2, 2);
                    goto label_24;
                }
                goto label_22;
            }
            else {
            label_22:
                if(skill_no < 25 || skill_no == 30) {
                    this.magicEffectRate(dmB, am, dm, skill_no);
                }
            }
        label_24:
            if(am.monster[3] == 2 && am.isMonReel(34)) {
                dmB.addHit(dm.monsterPro[3] * this.skill[34][0] / 100, 4, 2);
                return;
            }
            return;
        }
        dmB.addHit(0, -1, 2);
        amB.rate_off = 20;
    }

    private void hpAdd(int hp, int offer) {
        if(this.myMonsters[this.select[0][0]].monsterPro[0] < this.myMonsters[this.select[0][0]].monsterPro[2] && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
            this.AddHP(offer + this.myMonsters[this.select[0][0]].monsterPro[2] * hp / 100, this.myMonsters[this.select[0][0]]);
            this.useState(0, ((int)this.select_it[0]));
            return;
        }
        if(this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            this.say(this.getNameMon(((int)this.myMonsters[this.select[0][0]].monster[0])) + "已经死亡，无法使用！", 0);
            return;
        }
        this.say(this.getNameMon(((int)this.myMonsters[this.select[0][0]].monster[0])) + "不需要使用这个道具", 0);
    }

    public void initBattle() {
        System.gc();
        byte[] arr_b = this.src_c;
        byte[] arr_b1 = this.src_c;
        byte[] arr_b2 = this.src_c;
        this.src_c[3] = 0;
        arr_b2[2] = 0;
        arr_b1[1] = 0;
        arr_b[0] = 0;
        Monster monster0 = this.enB.getMon();
        this.getBattleBG(this.enB, monster0);
        Monster monster1 = this.myB.getMon();
        this.getBattleBG(this.myB, monster1);
        this.setEnemyThrow();
        this.setMyThrow();
    }

    public void initImgIco() {
        if(this.imgIco != null) {
            return;
        }
        this.imgIco = Ms.i().createImageArray_(7, "data/brow/i", 1);
    }

    public void initItemModules() {
        this.item_img = Ms.i().createImage("data/item");
        Ms.i();
        Ms.skip = 0;
        this.item_modules = Ms.i().create2Array(Ms.i().getStream("data/item_m.d", -1));
    }

    private void initMagicStream(int i) {
        if(this.magic[i] != null) {
            return;
        }
        Sprite[] arr_sprite = this.magic;
        arr_sprite[i] = Ms.i().createSprite("data/battle/s" + i, false);
    }

    public void initMonPro(int no, boolean mode) {
        Ms.i();
        Ms.skip = 0;
        byte[] arr_b = Ms.i().getStream("data/map/" + (mode ? "m" : "boss") + no + ".d", -1);
        this.monPro = Ms.i().createArray(arr_b);
        this.mapMove = Ms.i().createArray(arr_b);
        this.mapRect = Ms.i().create2Array(arr_b);
    }

    public void initMonStream(int type, int id, int i) {
        String s = "data/npc" + type + "/" + id;
        boolean bb = type == 2 ? this.isNpc2ImageType(id) : true;
        if(this.mon[i] == null) {
            Sprite[] arr_sprite = this.mon;
            arr_sprite[i] = Ms.i().createSprite(s, bb);
            return;
        }
        Ms.i().setSprite(this.mon[i], s, bb);
    }

    public void initNidusMap(int mode) {
        if(this.nidusMap == null) {
            this.nidusMap = new byte[5];
        }
        int i = 0;
        if(mode == 0) {
            while(i < this.nidusMap.length) {
                this.nidusMap[i] = -1;
                i = (byte)(i + 1);
            }
            return;
        }
        while(i < this.nidusMap.length) {
            if(this.nidusMap[i] != -1) {
                if(this.getRid(i) == -2) {
                    this.map.npc[0][this.nidusMap[i]].other[4] = 0;
                }
                else {
                    this.map.npc[0][this.nidusMap[i]].other[4] = 1;
                    byte[] arr_b = this.map.npc[0][this.nidusMap[i]].other;
                    byte[][] arr2_b = this.monster_pro;
                    arr_b[7] = (byte)(arr2_b[this.getNid(i)][6] + 17);
                }
            }
            i = (byte)(i + 1);
        }
    }

    private void initOtherImage() {
        if(this.imgItem == null) {
            this.imgItem = new Image[2];
            Image[] arr_image = this.imgItem;
            arr_image[0] = Ms.i().createImage("data/ball");
            Image[] arr_image1 = this.imgItem;
            arr_image1[1] = Ms.i().createImage("data/ll");
            this.initItemModules();
        }
        if(this.imgBG == null) {
            this.imgBG = new Image[5];
            for(int i = 0; i < this.imgBG.length; i = (byte)(i + 1)) {
                Image[] arr_image2 = this.imgBG;
                arr_image2[i] = Ms.i().createImage("data/battle/" + i);
            }
        }
        this.initImgIco();
    }

    public void initSkillList(Monster mon) {
        this.skill_list[8] = 0;
        for(int i = 7; i > -1; i = (byte)(i - 1)) {
            this.skill_list[i] = mon.monster[i + 8];
            if(this.skill_list[i] != -1) {
                this.skill_list[8] = (byte)(this.skill_list[8] + 1);
            }
        }
        for(int i = 1; i < 8; i = (byte)(i + 1)) {
            for(int j = i; j > 0 && this.skill_list[j] > this.skill_list[j - 1]; j = (byte)(j - 1)) {
                byte temp = this.skill_list[j];
                this.skill_list[j] = this.skill_list[j - 1];
                this.skill_list[j - 1] = temp;
            }
        }
    }

    private boolean isBagUse(int id) {
        return this.view_state == -1 ? id != 14 && id != 15 : id != 8 && id != 9 && id != 10 && id != 11;
    }

    private byte isEvolveKind(byte kind, byte level) {
        if(kind == 1 && level < 15) {
            return -2;
        }
        if(kind == 2 && level < 25) {
            return -3;
        }
        return kind != 3 || level >= 30 ? -1 : -4;
    }

    private byte isEvolveMake(int id) {
        int i = 2;
        byte evolve = this.monsterMake[id][0];
        do {
            if(this.findItem(-2, ((int)this.monsterMake[id][i]), true) < this.monsterMake[id][i + 1]) {
                return -1;
            }
            i = (byte)(i + 2);
        }
        while(i < this.monsterMake[id].length - 1);
        return evolve <= 0 || this.findItem(-2, 34, true) >= 1 ? evolve : 0;
    }

    private boolean isMonHp(Monster mon, int percent) {
        return mon.monsterPro[0] < mon.monster[2] * percent / 100;
    }

    public boolean isMoney(int sell_money, boolean bb) {
        if(bb) {
            if(this.money >= sell_money) {
                this.money -= sell_money;
                return true;
            }
            this.say("金钱不足！", 0);
            return false;
        }
        if(this.coin >= sell_money) {
            this.coin -= sell_money;
            return true;
        }
        this.say("徽章不足！", 0);
        return false;
    }

    public boolean isMoneyItem(int type, int item_id, int num, boolean bb) {
        if(this.findItem(-2, item_id, true) + num > 99) {
            this.say("数量已到上限", 0);
            return false;
        }
        if(bb) {
            if(this.money >= this.sell_money * num) {
                this.money -= this.sell_money * num;
                return true;
            }
            if(this.money < this.sell_money * num) {
                this.say("金钱不足！", -1, 0);
                return false;
            }
            this.say("背包空间不足。", 0, -1);
            return false;
        }
        if(this.coin >= this.sell_money * num) {
            this.coin -= this.sell_money * num;
            return true;
        }
        if(this.coin < this.sell_money * num) {
            this.say("徽章不足！", 0);
            return false;
        }
        this.say("背包空间不足。", 0);
        return false;
    }

    private boolean isMyMonsters(int select_i) {
        for(int i = 0; true; i = (byte)(i + 1)) {
            if(i >= this.myMon_length) {
                return false;
            }
            if(i != select_i && this.myMonsters[i].monsterPro[0] > 0) {
                return true;
            }
        }
    }

    public boolean isNpc2ImageType(int id) {
        for(int i = 0; true; i = (byte)(i + 1)) {
            if(i >= this.npc2ImageType.length) {
                return true;
            }
            if(this.npc2ImageType[i] == id) {
                return false;
            }
        }
    }

    private byte isShuXing(Monster am, Monster dm) {
        if(am.monster[3] == -1) {
            return 30;
        }
        if(this.Shuxing[am.monster[3]][0] == dm.monster[3]) {
            return 30;
        }
        return this.Shuxing[am.monster[3]][1] == dm.monster[3] ? 0 : 0;
    }

    private boolean isSkillToMe(int skill) {
        return skill == 27 || skill == 28;
    }

    private void keyBattleState() {
        if(!Ms.i().key_delay()) {
            switch(this.battle_state) {
                case 2: {
                    if(Ms.i().key_Left_Right()) {
                        this.cur_a = Ms.i().select(((int)this.cur_a), 0, this.action_str.length - 1);
                        return;
                    }
                    if(Ms.i().key_S1_Num5()) {
                    alab1:
                        switch(this.cur_a) {
                            case 0: {
                                if(this.myB.getMon().monster[6] == 0) {
                                    this.say("宠物忠诚度为0，请立刻补充！", -1);
                                    return;
                                }
                                this.battle_state = 3;
                                while(true) {
                                    if(this.skill_list[this.lastSkill] <= 30) {
                                        break alab1;
                                    }
                                    this.lastSkill = (byte)(this.lastSkill + 1);
                                }
                            }
                            case 1: {
                                if(this.myB.getMon().effect == 4) {
                                    this.say("禁锢中无法使用道具！", -1);
                                    return;
                                }
                                this.goMY_BAG(0);
                                return;
                            }
                            case 2: {
                                if(this.myB.getMon().effect == 4) {
                                    this.say("禁锢中无法更换宠物！", -1);
                                    return;
                                }
                                this.view_state = -2;
                                this.goVIEW_MONSTER();
                                return;
                            }
                            default: {
                                switch(this.cur_a) {
                                    case 3: {
                                        this.goBUY_ITEM(0, 0);
                                        return;
                                    }
                                    case 4: {
                                        if(this.battle_type == 4) {
                                            int EscRate = (short)(this.myB.getMon().monster[2] - this.enB.getMon().monster[2] + 60);
                                            int succ = 0;
                                            Ms.i();
                                            if(Ms.getRandom(100) >= EscRate) {
                                                succ = 1;
                                            }
                                            if(this.myB.getMon().isMonReel(42)) {
                                                succ = 0;
                                            }
                                            else if(this.myB.getMon().isEffect(3) || this.myB.getMon().isEffect(4)) {
                                                succ = 2;
                                            }
                                            if(succ == 0) {
                                                this.arangeMonster();
                                                this.setNullBattle();
                                                this.goGO_RUNINMAP();
                                                return;
                                            }
                                            if(succ == 1) {
                                                this.say("逃跑失败！", 1);
                                                this.myB.act_num = 0;
                                                this.enB.act_num = 1;
                                                this.battle_state = 9;
                                                return;
                                            }
                                            this.say("被怪物" + (this.myB.getMon().isEffect(4) ? "禁锢中" : "的电眼魅惑了") + "，" + "无法逃跑！", 1);
                                            return;
                                        }
                                        this.say("无法逃跑！", 0);
                                        return;
                                    }
                                    default: {
                                        return;
                                    }
                                }
                            }
                        }
                        this.select[0][0] = this.lastSkill;
                        this.select[0][1] = (byte)(this.select[0][0] - 5);
                        if(this.select[0][1] < 1) {
                            this.select[0][1] = 0;
                            return;
                        }
                    }
                    break;
                }
                case 3: {
                    if(Ms.i().key_Up_Down()) {
                        Ms.i().selectS(this.select[0], 0, ((int)this.skill_list[8]), 6);
                        this.lastSkill = this.select[0][0];
                        return;
                    }
                    if(Ms.i().key_S1_Num5()) {
                        if(this.skill_list[this.select[0][0]] > 30) {
                            this.say("被动技能无法使用!", -1);
                            return;
                        }
                        if(this.myB.getMon().effect == 6 && this.getSkillLevel(((int)this.skill_list[this.select[0][0]])) > 3) {
                            this.say("封闭效果，不能使用4级以上技能", -1);
                            return;
                        }
                        Monster monster0 = this.myB.getMon();
                        if(this.myB.getMon().monsterPro[1] >= this.getSkillMana(monster0, ((int)this.skill_list[this.select[0][0]]))) {
                            this.myB.skill = this.skill_list[this.select[0][0]];
                            this.battle_state = 9;
                            return;
                        }
                        this.say("需要的技能值不够！", -1);
                        return;
                    }
                    if(Ms.i().key_S2()) {
                        this.battle_state = 2;
                        return;
                    }
                    break;
                }
                case 4: {
                    if(Ms.i().key_Up_Down()) {
                        Ms.i().selectS(this.select[0], 0, 6, ((int)this.skill_list[8]));
                        return;
                    }
                    if(!Ms.i().key_S1_Num5() && Ms.i().key_S2()) {
                        this.battle_state = 2;
                        return;
                    }
                    break;
                }
                case 5: {
                    if(Ms.i().key_Up_Down()) {
                        Ms.i().selectS(this.select[0], 0, 6, ((int)this.skill_list[8]));
                        return;
                    }
                    if(!Ms.i().key_S1_Num5() && Ms.i().key_S2()) {
                        this.battle_state = 2;
                        return;
                    }
                    break;
                }
            }
        }
    }

    private void keyBuyItem() {
        if(!Ms.i().key_delay()) {
            if(this.popMenu == -1) {
                if(Ms.i().key_Left_Right() && this.cur_b != 0) {
                    this.cur_a = Ms.i().select(((int)this.cur_a), 0, 2);
                    byte[] arr_b = this.select[0];
                    this.select[0][0] = 0;
                    arr_b[1] = 0;
                    return;
                }
                if(Ms.i().key_Up_Down()) {
                    Ms ms0 = Ms.i();
                    byte[] arr_b1 = this.select[0];
                    int v = this.cur_b == 1 ? this.itemsLength[this.cur_a] : this.buyItem[this.cur_a].length;
                    ms0.selectS(arr_b1, 0, v, ((int)this.list_rows));
                    return;
                }
                if(Ms.i().key_S1_Num5()) {
                    this.popMenu = 1;
                    this.sell_money = this.getPrice(this.cur_a, (this.cur_b == 1 ? this.items[this.cur_a][this.select[0][0]][0] : this.select[0][0]), this.cur_b != 1);
                    this.t_length = (byte)this.getBuyItemCount(this.cur_a, this.select[0][0], this.cur_b != 1);
                    return;
                }
                if(Ms.i().key_S2()) {
                    this.buyItem = null;
                    this.buyPrice = null;
                    if(this.view_state == -1) {
                        this.goBattleState();
                        return;
                    }
                    this.goGO_RUNINMAP();
                }
            }
            else {
                if(this.buyOk == 0 && Ms.i().key_Left_Right()) {
                    this.popMenu = Ms.i().select(((int)this.popMenu), 1, ((int)this.t_length));
                    return;
                }
                if(Ms.i().key_S1_Num5()) {
                    if(this.buyOk == 1) {
                        if(this.cur_b == 1) {
                            this.money += this.sell_money * this.popMenu;
                            this.deleteItems(((int)this.items[this.cur_a][this.select[0][0]][0]), ((int)this.popMenu));
                            if(this.select[0][0] >= this.itemsLength[this.cur_a]) {
                                byte[] arr_b2 = this.select[0];
                                byte b = (byte)(arr_b2[0] - 1);
                                arr_b2[0] = b;
                                if(b < 0) {
                                    this.select[0][0] = 0;
                                }
                                byte[] arr_b3 = this.select[0];
                                byte b1 = (byte)(arr_b3[1] - 1);
                                arr_b3[1] = b1;
                                if(b1 < 0) {
                                    this.select[0][1] = 0;
                                }
                            }
                            this.say("获得金钱：" + this.sell_money * this.popMenu, 0);
                        }
                        else if(this.isMoneyItem(this.cur_a, this.buyItem[this.cur_a][this.select[0][0]], this.popMenu, this.cur_a != 2) && this.addItem(((int)this.buyItem[this.cur_a][this.select[0][0]]), ((int)this.popMenu)) != -1) {
                            this.say("购买成功", 0);
                        }
                        this.buyOk = 0;
                        this.popMenu = -1;
                        return;
                    }
                    this.buyOk = 1;
                    return;
                }
                if(Ms.i().key_S2()) {
                    if(this.buyOk == 0) {
                        this.popMenu = -1;
                        return;
                    }
                    this.buyOk = 0;
                }
            }
        }
    }

    private void keyEvolveUI() {
        if(Ms.i().key_S1_Num5() && this.b_c == 0) {
            int kind = this.myMonsters[this.selecty].monster[4];
            int level = this.myMonsters[this.selecty].monster[2];
            int id = this.myMonsters[this.selecty].monster[0];
            int dd = this.isEvolveKind(((byte)kind), ((byte)level)) == -1 ? this.isEvolveMake(id) : this.isEvolveKind(((byte)kind), ((byte)level));
            if(dd == 0) {
                this.myMonsters[this.selecty].evolveMonster(this, ((int)this.monsterMake[id][1]), 1);
            }
            else if(dd > 0) {
                this.myMonsters[this.selecty].evolveMonster(this, ((int)this.monsterMake[id][0]), ((int)this.myMonsters[this.selecty].monster[5]));
            }
            else if(dd == -1) {
                this.say("材料不足，不能进化！", 0);
                this.popMenu = 1;
            }
            else {
                switch(dd) {
                    case -3: {
                        this.say("等级没有达到25级，不能进化！", 0);
                        break;
                    }
                    case -2: {
                        this.say("等级没有达到15级，不能进化！", 0);
                        break;
                    }
                    default: {
                        this.say("等级没有达到30级，不能进化！", 0);
                    }
                }
            }
            if(dd > -1) {
                this.b_c = 1;
                this.setMagic(6);
                this.setShowPro(this.myMonsters[this.selecty]);
                this.popMenu = 0;
                this.delItemEvolve(((byte)id));
                if(dd > 0) {
                    this.deleteItems(34, 1);
                }
            }
        }
        else {
            if(Ms.i().key_S2()) {
                this.goView();
                this.setShowPro(this.myMonsters[this.selecty]);
                return;
            }
            if(Ms.i().key_Left_Right() && this.b_c <= 0) {
                this.popMenu = (byte)(this.popMenu ^ 1);
            }
        }
    }

    public void keyGameOver1(boolean over) {
        if(Ms.i().key_S1_Num5()) {
            switch(this.popMenu) {
                case 0: {
                    System.out.println("loadGame soars");
                    this.loadGame();
                    break;
                }
                case 1: {
                    this.goMAIN_MENU();
                }
            }
            this.popMenu = -1;
        }
        else if(Ms.i().key_Up_Down()) {
            this.popMenu = (byte)(this.popMenu ^ 1);
        }
        Ms.i().keyRelease();
    }

    private void keyGetSkill(Monster mon) {
        if(this.getSkill + 9 >= 35 && this.makeLevel[this.getSkill - 26] > this.rmsOther[3]) {
            this.say("需要训练师" + ((int)this.makeLevel[this.getSkill - 26]) + "级才能学习！", 0);
            return;
        }
        if(mon.isMonReel(((int)this.getSkill))) {
            this.say(this.getNameMon(((int)mon.monster[0])) + "已拥有该技能", 0);
            return;
        }
        if(mon.monster[14] != -1 && mon.monster[15] != -1) {
            this.initSkillList(mon);
            this.bg_c = mon.monster[3];
            this.restMove(1, 0);
            this.say("请选择要替换的技能！", 0);
            return;
        }
        if(mon.monster[14] == -1) {
            mon.monster[14] = this.getSkill;
        }
        else {
            mon.monster[15] = this.getSkill;
        }
        this.delItemSkill(mon);
    }

    public void keyLIST_INFO() {
        if(!Ms.i().key_delay()) {
            if(!Ms.i().key_S1_Num5()) {
                if(Ms.i().key_S2()) {
                    this.action_str = null;
                    this.monInfo_dir = null;
                    this.doPaint(0);
                    this.goYouPAUSE(3);
                    return;
                }
                if(Ms.i().key_Left_Right()) {
                    this.cur_a = Ms.i().select(((int)this.cur_a), 0, 4);
                    this.infoStart = 0;
                    if(this.cur_a > 0) {
                        for(int i = 0; i < this.cur_a; i = (byte)(i + 1)) {
                            this.infoStart = (byte)(this.infoStart + this.monInfo_dir[i].length);
                        }
                    }
                    this.t_length = (byte)this.monInfo_dir[this.cur_a].length;
                    byte[] arr_b = this.select[0];
                    this.select[0][1] = 0;
                    arr_b[0] = 0;
                    return;
                }
                if(Ms.i().key_Up_Down()) {
                    Ms.i().selectS(this.select[0], 0, ((int)this.t_length), ((int)this.list_rows));
                }
            }
            else if(this.monInfoList[this.getMonInfo_dir()] != 0) {
                this.goMONSTER_INFO(this.getMonInfo_dir());
            }
        }
    }

    private void keyMY_BAG() {
        if(!Ms.i().key_delay()) {
            if(this.popMenu != -1) {
                this.popBagState();
                return;
            }
            if(Ms.i().key_S1_Num5() && this.itemsLength[this.selectx] > 0) {
                this.popBagMenu(((int)this.selectx), ((int)this.select[0][0]));
                return;
            }
            if(Ms.i().key_Left_Right()) {
                this.selectx = Ms.i().select(((int)this.selectx), 0, this.action_str.length - 1);
                this.select[0][1] = this.select_st[this.selectx];
                this.select[0][0] = this.select_it[this.selectx];
                return;
            }
            if(Ms.i().key_S2()) {
                if(this.mini_state == 9) {
                    this.mini_state = 5;
                    this.selecty = this.select_T;
                    this.selecty = 0;
                    this.goVIEW_MONSTER();
                    return;
                }
                switch(this.view_state) {
                    case -1: {
                        this.mini_state = 1;
                        this.goBattleState();
                        this.initMonStream(2, ((int)this.mList_id[this.myMonsters[0].monster[0]][0]), 1);
                        this.itemMine = null;
                        return;
                    }
                    case 2: {
                        GameRun.run_state = -10;
                        GameRun.mc.paint();
                        this.goNidus(0);
                        return;
                    }
                    default: {
                        this.doPaint(0);
                        this.goYouPAUSE(2);
                        this.itemMine = null;
                        return;
                    }
                }
            }
            if(Ms.i().key_Up_Down()) {
                if(this.itemsLength[this.selectx] > 0) {
                    Ms.i().selectS(this.select[0], 0, ((int)this.itemsLength[this.selectx]), ((int)this.list_rows));
                }
                this.select_it[this.selectx] = this.select[0][0];
                this.select_st[this.selectx] = this.select[0][1];
            }
        }
    }

    private void keyMagicUI() {
        if(Ms.i().key_S1_Num5() && this.mini_state == 13) {
            if(this.skill_list[this.select[0][0]] <= 25) {
                this.say("该技能不能替换！", 0);
                return;
            }
            if(this.skill_list[this.select[0][0]] == this.myMonsters[this.selecty].monster[14]) {
                this.myMonsters[this.selecty].monster[14] = this.getSkill;
            }
            else {
                this.myMonsters[this.selecty].monster[15] = this.getSkill;
            }
            this.delItemSkill(this.myMonsters[this.selecty]);
            return;
        }
        if(Ms.i().key_S2()) {
            this.select[0][1] = this.selectx;
            this.select[0][0] = this.selecty;
            this.cur_c = 0;
            this.popMenu = -1;
            return;
        }
        if(Ms.i().key_Left_Right() && this.mini_state != 13) {
            this.popMenu = (byte)(this.popMenu ^ 1);
            byte[] arr_b = this.select[0];
            this.select[0][0] = 0;
            arr_b[1] = 0;
            return;
        }
        if(Ms.i().key_Up_Down()) {
            this.introX = Constants_H.WIDTH_H;
            if(this.popMenu == 0) {
                Ms.i().selectS(this.select[0], 0, ((int)this.skill_list[8]), 5);
                return;
            }
            if(this.mini_state == 6) {
                if(this.cMonsters[this.selecty].monster[17] > 0) {
                    byte[] arr_b1 = this.select[0];
                    arr_b1[0] = (byte)(arr_b1[0] ^ 1);
                }
            }
            else if(this.myMonsters[this.selecty].monster[17] > 0) {
                byte[] arr_b2 = this.select[0];
                arr_b2[0] = (byte)(arr_b2[0] ^ 1);
            }
        }
    }

    private void keyNidus() {
        if(!Ms.i().key_delay()) {
            if(this.mini_state == 16) {
                if(Ms.i().key_Up_Down()) {
                    this.popMenu = Ms.i().select(((int)this.popMenu), 0, this.about_d.length - 1);
                    return;
                }
                if(Ms.i().key_S1_Num5()) {
                    if(Ms.i().equals(this.about_d[this.popMenu], "查看孵化")) {
                        this.mini_state = 17;
                        this.popMenu = 0;
                        this.initMonStream(0, 56, 1);
                        if(this.getRid(((int)this.popMenu)) == -2) {
                            this.bg_c = this.popMenu;
                            return;
                        }
                        byte[][] arr2_b = this.monster_pro;
                        this.bg_c = arr2_b[this.getNid(((int)this.popMenu))][6];
                        this.mon_action = (byte)(this.bg_c + 23);
                        return;
                    }
                    if(Ms.i().equals(this.about_d[this.popMenu], "选择蛋")) {
                        this.view_state = 2;
                        this.goMY_BAG(3);
                        return;
                    }
                    if(Ms.i().equals(this.about_d[this.popMenu], "离开")) {
                        this.exitNidus();
                    }
                }
                else if(Ms.i().key_S2()) {
                    this.exitNidus();
                }
            }
            else {
                if(this.b_c == -2 && Ms.i().key_Left_Right()) {
                    this.popMenu = Ms.i().select(((int)this.popMenu), 0, 4);
                    if(this.getRid(((int)this.popMenu)) == -2) {
                        this.bg_c = this.popMenu;
                        return;
                    }
                    byte[][] arr2_b1 = this.monster_pro;
                    this.bg_c = arr2_b1[this.getNid(((int)this.popMenu))][6];
                    this.mon_action = (byte)(this.bg_c + 23);
                    return;
                }
                if(Ms.i().key_S1_Num5()) {
                    if(this.getRid(((int)this.popMenu)) != -2) {
                        if(this.b_c == -2 && this.getNexp(((int)this.popMenu), 1) == this.getNexp(((int)this.popMenu), 3)) {
                            if(this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
                                this.say("宠物空间已满", 0);
                                return;
                            }
                            if(this.isEvolveMake(this.getNid(((int)this.popMenu))) == 0) {
                                this.mon_action = (byte)(this.bg_c + 28);
                                this.b_c = 1;
                                this.setNidusPro(this.getNid(((int)this.popMenu)), 1);
                                this.delItemEvolve(this.getNid(((int)this.popMenu)));
                                return;
                            }
                            this.say("材料不足，不能孵化", 0);
                            return;
                        }
                        if(this.b_c == -1) {
                            this.b_c = -2;
                            this.getMonster(this.getNid(((int)this.popMenu)), this.getNLevel(((int)this.popMenu)), -2, -1);
                            this.delNidus(((int)this.popMenu));
                            this.initMonStream(0, 56, 1);
                        }
                    }
                }
                else if(this.b_c == -2 && Ms.i().key_S2()) {
                    this.exitNidus();
                }
            }
        }
    }

    private void key_MONSTER_LIST(Monster[] mon) {
        if(this.popMenu == -1) {
            if(Ms.i().key_S1_Num5() && this.t_length != 0) {
                if(this.view_state == 1) {
                    switch(this.mini_state) {
                        case 13: {
                            this.keyGetSkill(mon[this.select[0][0]]);
                            return;
                        }
                        case 15: {
                            this.useItem();
                            return;
                        }
                        default: {
                            StringBuffer sbuff = new StringBuffer("天赋#n技能");
                            if(this.mini_state == 4) {
                                if(mon[this.select[0][0]].monster[5] > 0) {
                                    sbuff.append("#n进化");
                                }
                                if(this.t_length > 1) {
                                    sbuff.append("#n存放#n卖宠");
                                }
                            }
                            else if(this.mini_state != 6) {
                                if(this.select[0][0] != 0) {
                                    sbuff.append("#n参战");
                                }
                                if(mon[this.select[0][0]].monster[5] > 0) {
                                    sbuff.append("#n进化");
                                }
                                if(this.t_length > 1) {
                                    sbuff.append("#n放生");
                                }
                            }
                            else if(!this.map.gmErr) {
                                sbuff.append("#n取出#n卖宠");
                            }
                            else {
                                sbuff.append("#n卖宠");
                            }
                            this.setStringB(sbuff.toString(), Constants_H.WIDTH, 3);
                            this.popMenu = 0;
                            return;
                        }
                    }
                }
                if(this.view_state < 0) {
                    if(this.mini_state == 15) {
                        this.useItem();
                        return;
                    }
                    if(this.select[0][0] == 0) {
                        this.setStringB("技能", Constants_H.WIDTH, 3);
                    }
                    else {
                        this.setStringB("参战#n技能", Constants_H.WIDTH, 3);
                    }
                    this.popMenu = 0;
                    return;
                }
            }
            else {
                if(Ms.i().key_S2()) {
                    if(this.mini_state == 13) {
                        this.goMY_BAG(2);
                        return;
                    }
                    switch(this.view_state) {
                        case -2: {
                            if(mon[0].monsterPro[0] > 0) {
                                if(this.select[0][0] != 0) {
                                    this.initMonStream(2, ((int)this.mList_id[mon[0].monster[0]][0]), 1);
                                }
                                this.goBattleState();
                            }
                            else {
                                this.say("当前宠物不能参战", 0);
                            }
                            this.view_state = -1;
                            return;
                        }
                        case -1: {
                            if(this.mini_state == 15) {
                                this.goMY_BAG(0);
                                return;
                            }
                            this.say("当前宠物不能参战", 0);
                            return;
                        }
                        case 1: {
                            switch(this.mini_state) {
                                case 4: 
                                case 6: {
                                    if(!this.map.gmErr) {
                                        this.doPaint(0);
                                        this.goVIEW_COMPUTER((this.mini_state == 6 ? 1 : 0));
                                        return;
                                    }
                                    this.map.bkEvent_getMon();
                                    return;
                                }
                                case 15: {
                                    this.goMY_BAG(0);
                                    this.mini_state = 3;
                                    return;
                                }
                                default: {
                                    this.doPaint(0);
                                    this.goYouPAUSE(1);
                                    return;
                                }
                            }
                        }
                        default: {
                            return;
                        }
                    }
                }
                if(Ms.i().key_Up_Down() && this.t_length != 0) {
                    Ms.i().selectS(this.select[0], 0, ((int)this.t_length), ((int)this.list_rows));
                    this.initMonStream(2, ((int)this.mList_id[mon[this.select[0][0]].monster[0]][0]), 1);
                    this.setShowPro(mon[this.select[0][0]]);
                    this.introT = Constants_H.WIDTH_H;
                    return;
                }
            }
            return;
        }
        this.popState();
    }

    public void key_gameRun() {
        if(GameRun.run_state == 98) {
            if(Ms.i().key_Num0() || Ms.i().key_S1_Num5()) {
                GameRun.mc.doShowNotify();
            }
            Ms.i().keyRelease();
            Log.d("soars", "doShowNotify2");
            return;
        }
        if(this.say_c > 0) {
            Ms.i().keyRelease();
            return;
        }
        if(this.say_c < 0) {
            if(this.say_s == 0 && Ms.i().key_S1_Num5()) {
                this.say_c = 0;
                this.doSayOverSms();
            }
            Ms.i().keyRelease();
            return;
        }
        switch(GameRun.run_state) {
            case 0xFFFFFFE1: {
                this.keyBattleState();
                goto label_132;
            }
            case -21: {
                SMSSender.i(this).keyLevel();
                Sound.i().soundStop();
                goto label_132;
            }
            case -20: {
                SMSSender.i(this).key();
                goto label_132;
            }
            case -15: {
                if(!Ms.i().key_delay()) {
                    if(this.b_c == 1 && this.say_s == 0) {
                        this.b_c = 0;
                    }
                    goto label_132;
                }
                break;
            }
            case -10: {
                this.map.key_map();
                goto label_132;
            }
            case 18: {
                this.keyBuyItem();
                goto label_132;
            }
            case 25: {
                this.keyMY_BAG();
                goto label_132;
            }
            case 35: {
                if(!Ms.i().key_delay()) {
                    switch(this.cur_c) {
                        case 0: {
                            this.key_MONSTER_LIST((this.mini_state == 6 ? this.cMonsters : this.myMonsters));
                            goto label_132;
                        }
                        case 1: {
                            this.keyMagicUI();
                            goto label_132;
                        }
                        case 2: {
                            this.keyEvolveUI();
                            goto label_132;
                        }
                        default: {
                            goto label_132;
                        }
                    }
                }
                break;
            }
            case 51: {
                if(Ms.i().key_Num0()) {
                    this.map.my.state = 0;
                    this.map.eventGoing = 2;
                    Ms.i().keyRelease();
                    this.map.dialog_no = -1;
                    this.goGO_RUNINMAP();
                }
                goto label_132;
            }
            case 60: {
                Ms.i().keyRelease();
                GameRun.run_state = 61;
                this.setAction_str(new String[]{"继续", "放弃"});
                this.popMenu = 0;
                goto label_132;
            }
            case 61: {
                this.keyGameOver1(true);
                goto label_132;
            }
            case 65: {
                if(!Ms.i().key_delay()) {
                    this.popState();
                    goto label_132;
                }
                break;
            }
            case 66: {
                this.keyNidus();
                goto label_132;
            }
            case 67: {
                if(Ms.i().key_S2()) {
                    this.goLIST_INFO(false);
                    Ms.i().keyRelease();
                }
                goto label_132;
            }
            case 68: {
                this.keyLIST_INFO();
                goto label_132;
            }
            case 69: {
                Mg.i().key(this);
                goto label_132;
            }
            case 97: {
                if(!Ms.i().key_delay()) {
                    if(Ms.i().key_S1_Num5()) {
                        Ms.i().keyRelease();
                        if(this.selectx == 0) {
                            switch(this.selecty) {
                                case 0: {
                                    if(this.buyOk == 1) {
                                        GameRun.run_state = 100;
                                        this.b_c = 0;
                                        this.buyOk = 0;
                                    }
                                    else {
                                        this.buyOk = 1;
                                    }
                                    break;
                                }
                                case 1: {
                                    this.goVIEW_MONSTER();
                                    break;
                                }
                                case 2: {
                                    this.goMY_BAG(0);
                                    break;
                                }
                                case 3: {
                                    this.goLIST_INFO(true);
                                    break;
                                }
                                default: {
                                    switch(this.selecty) {
                                        case 4: {
                                            this.map.goMission(0, true);
                                            break;
                                        }
                                        case 5: {
                                            this.goRUN_IN_MAP(true);
                                            this.action_str = null;
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            switch(this.selecty) {
                                case 0: {
                                    if(this.buyOk == 2) {
                                        this.loadGame();
                                    }
                                    else {
                                        this.buyOk = 2;
                                    }
                                    break;
                                }
                                case 1: {
                                    this.isChangeSound = Boolean.valueOf(true);
                                    Sound.i().keyVolume(0);
                                    break;
                                }
                                case 2: {
                                    GameRun.mc.goHELP_dialog(1);
                                    break;
                                }
                                case 3: {
                                    if(this.buyOk == 3) {
                                        GameRun.run_state = 0;
                                        this.action_str = null;
                                        this.goMAIN_MENU();
                                        this.buyOk = 0;
                                    }
                                    else {
                                        this.buyOk = 3;
                                    }
                                }
                            }
                        }
                    }
                    else if(!Ms.i().key_S2()) {
                        if(this.buyOk == 0) {
                            if(Ms.i().key_Left_Right()) {
                                this.selectx = (byte)(this.selectx ^ 1);
                                this.selecty = 0;
                                this.setPauseS(((int)this.selectx));
                            }
                            else if(Ms.i().key_Up_Down()) {
                                this.selecty = Ms.i().select(((int)this.selecty), 0, this.action_str.length - 1);
                            }
                        }
                    }
                    else if(this.buyOk == 0) {
                        this.action_str = null;
                        this.goRUN_IN_MAP(true);
                    }
                    else {
                        this.doPaint(0);
                        GameRun.run_state = 97;
                        this.buyOk = 0;
                    }
                label_132:
                    if(Ms.i().key_S1_Num5() || Ms.i().key_S2()) {
                        Ms.i().keyRelease();
                        return;
                    }
                }
                break;
            }
            default: {
                goto label_132;
            }
        }
    }

    public void levelPro(int no, boolean bb) {
        if(bb) {
            int enlevel_star = (byte)this.proReplace[no][6];
            byte[] temp_pro = this.monster_pro[this.myMonsters[no].monster[0]];
            int temp = this.getbuffRateV(this.myMonsters[no], ((int)(((short)(temp_pro[0] + temp_pro[7] * enlevel_star / 10)))));
            this.proReplace[no][0] = (short)(this.myMonsters[no].monsterPro[2] - temp);
            this.proReplace[no][1] = (short)(this.myMonsters[no].monsterPro[3] - ((short)(temp_pro[1] + temp_pro[8] * enlevel_star / 10)));
            this.proReplace[no][3] = (short)(this.myMonsters[no].monsterPro[6] - ((short)(temp_pro[3] + temp_pro[10] * enlevel_star / 10)));
            this.proReplace[no][4] = (short)(this.myMonsters[no].monsterPro[7] - ((short)(temp_pro[4] + temp_pro[11] * enlevel_star / 10)));
            this.proReplace[no][5] = (short)(this.myMonsters[no].monsterPro[5] - ((short)(temp_pro[2] + temp_pro[9] * enlevel_star / 10)));
            return;
        }
        byte[] arr_b1 = this.myMonsters[no].monster;
        byte b = (byte)(arr_b1[2] + 1);
        arr_b1[2] = b;
        byte[] temp_pro = this.monster_pro[this.myMonsters[no].monster[0]];
        this.myMonsters[no].monsterPro[2] = (short)(temp_pro[0] + temp_pro[7] * b / 10);
        this.myMonsters[no].monsterPro[3] = (short)(temp_pro[1] + temp_pro[8] * b / 10);
        this.myMonsters[no].monsterPro[6] = (byte)(temp_pro[3] + temp_pro[10] * b / 10);
        this.myMonsters[no].monsterPro[7] = (byte)(temp_pro[4] + temp_pro[11] * b / 10);
        this.myMonsters[no].monsterPro[5] = (byte)(temp_pro[2] + temp_pro[9] * b / 10);
        this.myMonsters[no].resetPro(this);
        this.healMonster(this.myMonsters[no]);
    }

    private boolean level_up(int no, int mode) {
        switch(mode) {
            case 0: {
                int v2 = this.myMonsters[no].monster[2];
                Ms.i();
                int LevelCha = (byte)(v2 - Ms.skip2);
                int buff = 0;
                Ms.i();
                Ms.skip = this.exp;
                if(this.myMonsters[no].isMonReel(36)) {
                    buff = 100;
                }
                if(this.myMonsters[no].isMonReel(37)) {
                    buff = (short)(buff + 200);
                }
                if(LevelCha < 0) {
                    LevelCha = 0;
                }
                else if(LevelCha > 4) {
                    LevelCha = 5;
                }
                Ms.i();
                Ms.i();
                Ms.skip = (short)(Ms.skip * (9 - LevelCha * 2) * (buff + 100) / 1000);
                Ms.i();
                if(Ms.skip < 1) {
                    Ms.i();
                    Ms.i();
                    Ms.skip = Ms.getRandom(6) + 5;
                }
                if(this.battle_type == 0 || this.battle_type == 3) {
                    Ms.i();
                    Ms.i();
                    Ms.skip = (short)(Ms.skip * 3 / 2);
                }
                short[] arr_v = this.proReplace[no];
                Ms.i();
                arr_v[2] = (short)Ms.skip;
                return true;
            }
            case 1: {
                if(this.myMonsters[no].monster[2] < 60) {
                    Ms.i();
                    if(Ms.skip > 0) {
                        short v5 = this.getMonsterExp(this.myMonsters[no]);
                        int v6 = this.myMonsters[no].monsterPro[4];
                        Ms.i();
                        int expt = (short)(v6 + Ms.skip);
                        if(expt >= v5) {
                            this.myB.cexp = this.myMonsters[no].monsterPro[4];
                            this.myMonsters[no].monsterPro[4] = v5;
                            Ms.i();
                            Ms.skip = (short)(expt - v5);
                            return true;
                        }
                        this.myB.cexp = this.myMonsters[no].monsterPro[4];
                        short[] arr_v1 = this.myMonsters[no].monsterPro;
                        int v8 = arr_v1[4];
                        Ms.i();
                        arr_v1[4] = (short)(v8 + Ms.skip);
                        Ms.i();
                        Ms.skip = -1;
                        return true;
                    }
                }
                Ms.i();
                Ms.skip = -1;
                this.proReplace[no][2] = 0;
                return true;
            }
            case 2: {
                Ms.i();
                if(Ms.skip > -1) {
                    this.levelPro(no, false);
                    this.getMagic(this.myMonsters[no]);
                    this.levelUp_in_battle[this.myMonsters[no].monster[1]][0] = 1;
                    this.levelUp_in_battle[this.myMonsters[no].monster[1]][1] = this.getSkill;
                    this.myMonsters[no].monsterPro[4] = 0;
                    return true;
                }
                return false;
            }
            default: {
                return true;
            }
        }
    }

    private void loadGame() {
        this.map.firstDrawMap = 0;
        this.buyOk = 0;
        this.map.mapImg = null;
        System.out.println("loadGame 111111111111");
        GameRun.mc.goGameLoading();
        System.out.println("loadGame 22222222222");
    }

    private boolean magicEffectRate(Battle dmB, Monster am, Monster dm, int skill_no) {
        if(dm.effect != 7) {
            return false;
        }
        byte buff = this.skill[skill_no][3];
        int DebuffRate = this.skill[skill_no][2];
        if(DebuffRate == 0) {
            return false;
        }
        if(buff != 0) {
            if(buff != 4) {
                if(buff == 2 || buff == 5) {
                    if(dm.isBuffRate(11)) {
                        DebuffRate = (byte)(this.inhesion[11] + DebuffRate);
                    }
                    else if(dm.isBuffRate(12)) {
                        DebuffRate = (byte)(this.inhesion[12] + DebuffRate);
                    }
                }
            }
            else if(dm.isBuffRate(7)) {
                DebuffRate = (byte)(this.inhesion[7] + DebuffRate);
            }
            else if(dm.isBuffRate(8)) {
                DebuffRate = (byte)(this.inhesion[8] + DebuffRate);
            }
        }
        else if(dm.isBuffRate(5)) {
            DebuffRate = (byte)(this.inhesion[5] + DebuffRate);
        }
        else if(dm.isBuffRate(6)) {
            DebuffRate = (byte)(this.inhesion[6] + DebuffRate);
        }
        Ms.i();
        if(Ms.getRandom(100) < DebuffRate) {
            dm.effect = buff;
            switch(buff) {
                case 0: {
                    dm.effect_time = 2;
                    break;
                }
                case 2: {
                    dm.effect_time = (byte)(am.isMonReel(0x20) ? 5 : 4);
                    break;
                }
                case 3: 
                case 4: 
                case 5: {
                    dm.effect_time = 4;
                    break;
                }
                default: {
                    if(buff == 6) {
                        if(dm.monster[3] == -1) {
                            dm.effect = 7;
                            this.say("封闭效果，对幽暗鬼王不起作用", -1);
                        }
                        else {
                            dm.effect_time = 4;
                        }
                    }
                }
            }
            if(buff == 5) {
                int v2 = am.isMonReel(0x1F) ? this.skill[0x1F][0] : 1;
                dmB.fs_level = (byte)(v2 + skill_no);
            }
            return true;
        }
        return false;
    }

    public void map_flashString() {
        int WIDTH = Constants_H.WIDTH__;
        int HEIGHT = Constants_H.HEIGHT__;
        int HEIGHT_H = Constants_H.HEIGHT__ / 2;
        this.setSay();
        if(this.say_c > 0 && GameRun.run_state != 98) {
            if(!this.map.fontSizeControl) {
                Ms.i();
                Ms.font.setSize(22);
            }
            this.showString(this.showS, (this.say_mode == 0 ? HEIGHT_H - (this.showS.length >> 1) * 25 - 12 : HEIGHT - 68), this.say_s, 1);
            if(this.say_s == 0) {
                this.say_c = (byte)(this.say_c - 1);
            }
            else {
                this.say_s = Ms.i().mathSpeedDown(this.say_s, 3, true);
            }
        }
        else if(this.say_c < 0 && GameRun.run_state != 98) {
            Ms.i();
            Ms.font.setSize(22);
            this.showString(this.showS, HEIGHT_H - (this.showS.length >> 1) * 25 - 12, this.say_s, 2);
            if(this.say_s != 0) {
                this.say_s = Ms.i().mathSpeedDown(this.say_s, 3, true);
            }
            if(this.pkey.isSelect(0, 0, WIDTH, HEIGHT)) {
                this.pkey.setKey5();
            }
        }
        Ms.i();
        Ms.font.setSize(26);
    }

    private byte monsterRemove(int no) {
        if(this.myMon_length > 1) {
            this.myMonsters[no] = null;
            for(int i = (byte)no; i < this.myMon_length - 1; i = (byte)(i + 1)) {
                this.myMonsters[i] = this.myMonsters[i + 1];
                this.evolve[i] = this.evolve[i + 1];
            }
            for(int i = this.myMon_length; i < this.myMonsters.length; i = (byte)(i + 1)) {
                this.evolve[i] = true;
            }
            this.myMon_length = (byte)(this.myMon_length - 1);
            return 1;
        }
        return -1;
    }

    private void mpAdd(int hp) {
        if(this.myMonsters[this.select[0][0]].monsterPro[1] < this.myMonsters[this.select[0][0]].monsterPro[3] && this.myMonsters[this.select_T].monsterPro[0] > 0) {
            this.AddMP(this.myMonsters[this.select[0][0]].monsterPro[3] * hp / 100, this.myMonsters[this.select[0][0]]);
            this.useState(0, ((int)this.select_it[0]));
            return;
        }
        if(this.myMonsters[this.select[0][0]].monsterPro[1] < 1) {
            this.say(this.getNameMon(((int)this.myMonsters[this.select[0][0]].monster[0])) + "已经死亡，无法使用！", 0);
            return;
        }
        this.say(this.getNameMon(((int)this.myMonsters[this.select[0][0]].monster[0])) + "不需要使用这个道具", 0);
    }

    private void paintBATTLE_OVER() {
        if(this.b_c == 1) {
            this.drawEvolveUI(0, ((int)this.myB.now_id), false);
        }
    }

    private void paintBattleState(Graphics g) {
        switch(this.battle_state) {
            case -5: {
                if(this.proReplace[this.myB.now_id][2] > -1) {
                    String s = this.getNameMon(((int)this.myMonsters[this.myB.now_id].monster[0])) + "获得经验：";
                    Log.e("sk", "获得经验");
                    Ui.i().drawString(s, 204, 308, 36, 1, 0);
                    Ui.i().drawNum(((int)this.proReplace[this.myB.now_id][2]), 220, 315, 0, 1);
                    return;
                }
                if(this.proReplace[this.myB.now_id][2] == -1) {
                    Ui.i().drawString("您的宠物已经无法获得经验", 204, 282, 36, 7, 0);
                    Ms.i().sleep(600);
                    return;
                }
                break;
            }
            case -3: {
                if(this.drawHitOne(this.am, this.dm, this.getBXY(this.mini_state ^ 1, 25, true) - 15, this.getBXY(this.mini_state ^ 1, 25, false) - 34) && this.runHitToState(this.dm, this.am, this.mini_state ^ 1)) {
                    this.battle_state = 9;
                    this.effectR(this.dm.getMon());
                    return;
                }
                break;
            }
            case -2: {
                if(this.drawHitOne(this.dm, this.am, this.getBXY(((int)this.mini_state), ((int)this.am.skill), true) - 15, this.getBXY(((int)this.mini_state), ((int)this.am.skill), false) - 34) && this.drawHitOne(this.am, this.dm, this.getBXY(this.mini_state ^ 1, 25, true) - 15, this.getBXY(this.mini_state ^ 1, 25, false) - 34) && this.runHitToState(this.am, this.dm, ((int)this.mini_state))) {
                    this.battle_state = -3;
                    this.am.initHit();
                    this.doEffectValue(this.am);
                    this.doBuffValue(this.am);
                    return;
                }
                break;
            }
            case -1: {
                this.drawAnimationBattle(this.am, ((int)this.mini_state));
                return;
            }
            case 3: {
                Ui.i().drawK0(170, 50, 300, 0xC1, 0);
                Ui.i().sliding(445, 60, 0xAD, ((int)this.select[0][0]), ((int)this.skill_list[8]), false);
                this.drawSkillList(180, 60, 0xFA, 28, 6, this.select[0]);
                this.showStringM(this.skill_help[this.skill_list[this.select[0][0]]].toString(), 320, 0x10D, 7, 0);
                Ui.i().drawYesNo(true, true);
            }
        }
    }

    public void paint_gameRun(Graphics g) {
    alab1:
        switch(GameRun.run_state) {
            case -50: {
                this.drawBattleBG();
                this.drawSelectMenu(g, true, 0xFC);
                this.drawSrcLine(g, 15, 0x7C, 10, false, this.src_c[2] == 0);
                this.drawSrcLine(g, 0x83, 0x7C, 10, true, this.src_c[3] == 0);
                this.drawPlayerAppear(g);
                break;
            }
            case 0xFFFFFFE1: {
                this.drawBattleBG();
                this.drawPlayer(g);
                this.drawSelectMenu(g, this.battle_state != 2, 0xFC);
                this.paintBattleState(g);
                break;
            }
            case -30: {
                this.drawDarkScreen();
                break;
            }
            case -21: {
                SMSSender.i(this).paintLevel();
                break;
            }
            case -20: {
                SMSSender.i(this).paint();
                break;
            }
            case -19: {
                this.drawBattleBG();
                this.drawSelectMenu(g, true, 0xFC);
                this.drawMyMon();
                this.drawEnemy();
                if(this.cThrowY < 17) {
                    this.cThrowS = (short)(this.cThrowS + this.cThrowY);
                    this.cThrowY = Ms.i().mathSpeedN(((int)this.cThrowY), 17, 2, false);
                }
                this.cThrowX = Ms.i().mathSpeedN(((int)this.cThrowX), 0, 8, false);
                Ui.i().drawImage(this.imgItem[0], 377 - this.cThrowX, ((int)this.cThrowS), 33);
                break;
            }
            case -15: {
                this.paintBATTLE_OVER();
                break;
            }
            case -10: {
                this.map.paint_map(g);
                break;
            }
            case 18: {
                this.drawBUY_ITEM();
                break;
            }
            case 25: {
                this.drawMY_BAG(0, 0, 640, 360);
                break;
            }
            case 35: {
                switch(this.cur_c) {
                    case 0: {
                        this.drawMONSTER_UI((this.mini_state == 6 ? this.cMonsters : this.myMonsters));
                        break alab1;
                    }
                    case 1: {
                        this.drawMagicUI((this.mini_state == 6 ? this.cMonsters[this.selecty] : this.myMonsters[this.selecty]));
                        break alab1;
                    }
                    case 2: {
                        this.drawEvolveUI(1, ((int)this.selecty), false);
                        break alab1;
                    }
                    default: {
                        break alab1;
                    }
                }
            }
            case 51: {
                this.map.drawBlackSRC(g, 30, true);
                this.drawZero("结束", 350);
                break;
            }
            case 60: {
                GameRun.mc.drawRectBG();
                this.showString("战斗失败了,训练师的梦想不能实现了!", 180, 0);
                Ui.i().drawYesNo(true, true);
                break;
            }
            case 61: {
                GameRun.mc.drawRectBG();
                this.showString("你要继续游戏，确定吗？", 310, 0);
                this.drawSelectMenu(this.action_str, 270, 130, 100, 2, 0, ((int)this.popMenu));
                break;
            }
            case 65: {
                this.drawVIEW_COMPUTER();
                break;
            }
            case 66: {
                this.drawNidus(200, 0xE1);
                break;
            }
            case 67: {
                this.drawMONSTER_INFO(this.getMonInfo_dir());
                break;
            }
            case 68: {
                this.drawLIST_INFO();
                break;
            }
            case 69: {
                Mg.i().paint();
                break;
            }
            case 97: {
                Ui.i().drawK0(-2, 0, 644, 33, 0);
                Ui.i().drawString("训练师等级：" + ((int)this.rmsOther[3]), 320, 2, 17, 1, 2);
                this.drawPauseMenu(0xD7, 45, 210, 0xEB);
                Ui.i().drawK0(-2, 327, 644, 33, 0);
                this.gogoWordM(this.gogoString, 329, 16, 3, 0, 2);
                switch(this.buyOk) {
                    case 0: {
                        break;
                    }
                    case 2: {
                        this.showString("是否读取进度?", 60, 0);
                        break;
                    }
                    case 3: {
                        this.showString("之前未保存的部分将会丢失，是否继续？", 60, 0);
                        break;
                    }
                    default: {
                        this.showString("是否保存游戏?", 60, 0);
                    }
                }
                Ui.i().drawYesNo(true, true);
                break;
            }
            case 98: {
                GameRun.mc.drawRectBG();
                Ui.i().drawK1(-5, 285, 650, 75, 3);
                this.showStringM("游戏暂停，点击屏幕返回。", 320, 308, 9, 3);
                break;
            }
            case 100: {
                this.b_c = 1;
                this.showString("保存游戏中", 20, 0);
            }
        }
        this.map_flashString();
    }

    private void popBagMenu(int selectx, int select_i) {
        String ts = "返回";
        int id = this.items[selectx][select_i][0];
        if((selectx == 0 || (id == 0x20 || id == 33)) && this.isBagUse(id)) {
            ts = "使用#n返回";
        }
        else if(selectx == 2) {
            ts = "学习#n返回";
        }
        else if(this.view_state == 2 && selectx == 3) {
            ts = "孵化#n返回";
        }
        this.setStringB(ts, Constants_H.WIDTH, 0);
        this.popMenu = 0;
    }

    private void popBagState() {
        if(Ms.i().key_Up_Down()) {
            this.popMenu = Ms.i().select(((int)this.popMenu), 0, this.about_a.length - 1);
        }
        if(Ms.i().key_S1_Num5()) {
            int id = this.items[this.selectx][this.select[0][0]][0];
            if(Ms.i().equals(this.about_a[this.popMenu], "使用")) {
                switch(id) {
                    case 9: 
                    case 10: 
                    case 11: {
                        if(this.battle_type == 1 || this.battle_type == 4) {
                            this.goCatchMonster();
                        }
                        else {
                            this.say("特殊情况，无法捕获！", 1);
                            Ms.i().sleep(400);
                        }
                        break;
                    }
                    case 14: 
                    case 15: {
                        this.popMenu = -1;
                        if(this.map.notMeet == 0) {
                            this.map.notMeet(1, id);
                            this.say("使用" + this.getNameItem(id) + "，" + "获得了" + "躲避怪物效果", 1);
                            this.deleteItems(id, 1);
                        }
                        else if(this.map.notMeet == 1) {
                            this.say("已拥有躲避怪物效果", 0);
                        }
                        break;
                    }
                    case 0x20: 
                    case 33: {
                        if(this.findItem(-2, (id == 0x20 ? 33 : 0x20), true) > 0) {
                            this.deleteItems(0x20, 1);
                            this.deleteItems(33, 1);
                            int type = 3;
                            int rId = -1;
                            Ms.i();
                            int rand = (byte)Ms.getRandom(100);
                            if(rand < 70) {
                                type = 0;
                            }
                            else if(rand < 85) {
                                type = 1;
                            }
                            else if(rand < 0x5F) {
                                type = 2;
                            }
                            Ms.i();
                            int rand = (byte)Ms.getRandom(100);
                            for(int d = 1; d < this.itemMine[type].length; d = (byte)(d + 2)) {
                                if(rand < this.itemMine[type][d]) {
                                    rId = this.itemMine[type][d - 1];
                                    break;
                                }
                            }
                            if(rId == 34 && this.findItem(-2, 34, true) > 0) {
                                rId = -1;
                            }
                            else if(rId == -1 || this.findItem(-2, rId, true) >= 99) {
                                rId = -1;
                            }
                            if(rId == -1) {
                                this.say("这个宝箱是空的。", 0);
                            }
                            else {
                                this.addItem(rId, 1);
                                this.say("获得：" + this.getNameItem(rId) + "x1", 0);
                            }
                        }
                        else {
                            this.say("没有" + (id == 0x20 ? "钥匙，钥匙在商店中可以购买。" : "宝箱，宝箱在战斗后一定几率获得。"), 0);
                        }
                        this.popMenu = -1;
                        Ms.i().correctSelect(this.select[0], ((int)this.itemsLength[this.selectx]), ((int)this.list_rows));
                        return;
                    }
                    default: {
                        this.goVIEW_MONSTER();
                        this.mini_state = 15;
                    }
                }
            }
            else if(Ms.i().equals(this.about_a[this.popMenu], "学习")) {
                this.mini_state = 13;
                this.getSkill = (byte)(id - 9);
                this.goVIEW_MONSTER();
            }
            else {
                if(Ms.i().equals(this.about_a[this.popMenu], "孵化")) {
                    if(this.addNidus(id - 58)) {
                        this.deleteItems(id, 1);
                        this.select_it[this.selectx] = this.select[0][0];
                        this.select_st[this.selectx] = this.select[0][1];
                    }
                    else {
                        this.say("孵化所已经没有空位了", 0);
                    }
                }
                this.popMenu = -1;
            }
            Ms.i().correctSelect(this.select[0], ((int)this.itemsLength[this.selectx]), ((int)this.list_rows));
            return;
        }
        if(Ms.i().key_S2()) {
            this.popMenu = -1;
        }
    }

    public void popState() {
        if(this.buyOk == 0 && Ms.i().key_Up_Down()) {
            this.popMenu = Ms.i().select(((int)this.popMenu), 0, this.about_d.length - 1);
            return;
        }
        if(Ms.i().key_S1_Num5()) {
            if(Ms.i().equals(this.about_d[this.popMenu], "技能") || Ms.i().equals(this.about_d[this.popMenu], "天赋")) {
                this.initSkillList((this.mini_state == 6 ? this.cMonsters[this.select[0][0]] : this.myMonsters[this.select[0][0]]));
                if(this.view_state > 0) {
                    this.bg_c = this.mini_state == 6 ? this.cMonsters[this.select[0][0]].monster[3] : this.myMonsters[this.select[0][0]].monster[3];
                }
                else if(this.view_state < 0 && this.myB != null) {
                    this.bg_c = this.myB.bg_id;
                }
                this.restMove(1, (Ms.i().equals(this.about_d[this.popMenu], "技能") ? 0 : 1));
                return;
            }
            if(Ms.i().equals(this.about_d[this.popMenu], "参战")) {
                if(this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
                    if(this.view_state < 0) {
                        for(int i = 1; i <= this.mon_in_battle[0] && this.mon_in_battle[i] != this.myMonsters[this.select[0][0]].monster[1]; i = (byte)(i + 1)) {
                            if(i == this.mon_in_battle[0]) {
                                byte[] arr_b = this.mon_in_battle;
                                byte[] arr_b1 = this.mon_in_battle;
                                byte b = (byte)(arr_b1[0] + 1);
                                arr_b1[0] = b;
                                arr_b[b] = this.myMonsters[this.select[0][0]].monster[1];
                            }
                        }
                        this.initSkillList(this.myMonsters[this.select[0][0]]);
                    }
                    this.changeMonster(this.myMonsters[this.select[0][0]], this.myMonsters[0]);
                    this.initMonStream(2, ((int)this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0]), 1);
                    this.setShowPro(this.myMonsters[this.select[0][0]]);
                    if(this.view_state < 0) {
                        this.setMyThrow();
                        GameRun.run_state = -50;
                        this.battle_state = 0;
                        if(this.view_state == -1) {
                            this.myB.act_num = 1;
                            this.enB.act_num = 1;
                        }
                        this.myB.dead = 0;
                        this.first_battle = 0;
                    }
                    this.lastSkill = 0;
                }
                else {
                    this.say("当前宠物不能参战", 0);
                }
                this.popMenu = -1;
                return;
            }
            if(Ms.i().equals(this.about_d[this.popMenu], "进化")) {
                this.setEvolveStringB(this.myMonsters[this.select[0][0]]);
                this.bg_c = this.myMonsters[this.select[0][0]].monster[3];
                this.b_c = 0;
                this.restMove(2, 0);
                return;
            }
            if(Ms.i().equals(this.about_d[this.popMenu], "放生")) {
                if(!this.isMyMonsters(((int)this.select[0][0]))) {
                    this.say("身上必须携带一只能参战的宠物！", 0);
                    return;
                }
                if(this.buyOk == 1) {
                    this.buyOk = 0;
                    this.delMonster(((int)this.select[0][0]));
                    if(this.select[0][0] == this.myMon_length) {
                        byte[] arr_b2 = this.select[0];
                        arr_b2[0] = (byte)(arr_b2[0] - 1);
                    }
                    this.initMonStream(2, ((int)this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0]), 1);
                    this.setShowPro(this.myMonsters[this.select[0][0]]);
                    this.introT = Constants_H.WIDTH_H;
                    this.t_length = this.myMon_length;
                    this.popMenu = -1;
                    return;
                }
                this.buyOk = 1;
                this.gogoString = "放生的宠物将会消失，是否继续？";
                return;
            }
            if(Ms.i().equals(this.about_d[this.popMenu], "存放")) {
                if(GameRun.run_state == 35) {
                    this.putMonster();
                    return;
                }
                this.mini_state = 4;
                this.view_state = 1;
                this.goVIEW_MONSTER();
                return;
            }
            if(Ms.i().equals(this.about_d[this.popMenu], "取出")) {
                if(GameRun.run_state == 35) {
                    this.takenMonster();
                    return;
                }
                this.mini_state = 6;
                this.view_state = 1;
                this.goVIEW_MONSTER();
                return;
            }
            if(Ms.i().equals(this.about_d[this.popMenu], "卖宠")) {
                if(this.buyOk == 1) {
                    this.buyOk = 0;
                    this.money += this.sell_money;
                    this.say("获得金钱：" + this.sell_money, 0);
                    if(this.mini_state == 6) {
                        this.setTakenMonster();
                        return;
                    }
                    this.setPutMonster();
                    return;
                }
                if(this.mini_state == 4 && !this.isMyMonsters(((int)this.select[0][0]))) {
                    this.say("身上必须携带一只能参战的宠物！", 0);
                    return;
                }
                this.buyOk = 1;
                this.sellMonster((this.mini_state == 4 ? this.myMonsters[this.select[0][0]] : this.cMonsters[this.select[0][0]]));
                this.gogoString = "获得金钱：" + this.sell_money + "，是否卖出？";
                return;
            }
            if(Ms.i().equals(this.about_d[this.popMenu], "离开")) {
                this.goRUN_IN_MAP(false);
            }
        }
        else if(Ms.i().key_S2()) {
            if(this.buyOk != 0) {
                this.buyOk = 0;
                return;
            }
            if(GameRun.run_state == 65) {
                this.goRUN_IN_MAP(false);
                return;
            }
            this.popMenu = -1;
        }
    }

    private void putMonster() {
        if(this.cMon_count >= this.max_monsters) {
            this.say("宠物空间已满", 0);
            return;
        }
        if(!this.isMyMonsters(((int)this.select[0][0]))) {
            this.say("身上必须携带一只能参战的宠物！", 0);
            return;
        }
        this.cMonsters[this.cMon_count] = this.myMonsters[this.select[0][0]];
        this.cMon_count = (byte)(this.cMon_count + 1);
        this.setPutMonster();
    }

    private void resetFealty(int hp) {
        byte fealty = this.initFealty[this.myMonsters[this.select[0][0]].monster[4] / 4];
        if(this.myMonsters[this.select[0][0]].monster[6] < fealty && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
            if(hp == -1) {
                this.myMonsters[this.select[0][0]].monster[6] = fealty;
            }
            else if(this.myMonsters[this.select[0][0]].monster[6] + hp > fealty) {
                this.myMonsters[this.select[0][0]].monster[6] = fealty;
            }
            else {
                byte[] arr_b = this.myMonsters[this.select[0][0]].monster;
                arr_b[6] = (byte)(arr_b[6] + hp);
            }
            this.useState(0, ((int)this.select_it[0]));
            if(this.view_state == -1) {
                Monster monster0 = this.myB.getMon();
                Monster monster1 = this.enB.getMon();
                this.getHitCoefficient(this.myB, monster0, monster1);
            }
        }
        else if(this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
            this.say(this.getNameMon(((int)this.myMonsters[this.select[0][0]].monster[0])) + "忠诚度已满", 0);
        }
    }

    private void resetMonster(int hp) {
        if(this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            this.AddMP(this.myMonsters[this.select[0][0]].monsterPro[3] * hp / 100, this.myMonsters[this.select[0][0]]);
            this.AddHP(this.myMonsters[this.select[0][0]].monsterPro[2] * hp / 100, this.myMonsters[this.select[0][0]]);
            this.myMonsters[this.select[0][0]].effect = 7;
            this.useState(0, ((int)this.select_it[0]));
            return;
        }
        this.say(this.getNameMon(((int)this.myMonsters[this.select[0][0]].monster[0])) + "没有死亡！", 0);
    }

    private void restMove(int type, int i) {
        this.selectx = this.select[0][1];
        this.selecty = this.select[0][0];
        this.cur_c = (byte)type;
        byte[] arr_b = this.select[0];
        this.select[0][0] = 0;
        arr_b[1] = 0;
        this.popMenu = (byte)i;
        this.move_x = 0x81;
        this.move_y = -14;
    }

    private void runBattleState() {
        byte[] arr_b = this.myB.countS;
        arr_b[0] = (byte)Ms.i().mathSpeedN(((int)this.myB.countS[0]), ((int)this.myB.countS[1]), 1, false);
        byte[] arr_b1 = this.enB.countS;
        arr_b1[0] = (byte)Ms.i().mathSpeedN(((int)this.enB.countS[0]), ((int)this.enB.countS[1]), 1, false);
        switch(this.battle_state) {
            case -5: {
                if(this.b_c == 0 && this.cur_c >= this.mon_in_battle[0]) {
                    this.goBattleOver();
                    this.setNidusExp(((int)this.exp));
                    return;
                }
                byte id = this.mon_in_battle[this.cur_c + 1];
                if(this.b_c != 0) {
                    switch(this.b_c) {
                        case 1: {
                            this.level_up(((int)id), 1);
                            this.b_c = 2;
                            break;
                        }
                        case 2: {
                            if(this.myB.cexp != this.myMonsters[id].monsterPro[4]) {
                            label_36:
                                if(this.b_c > 2 && ((this.b_c >= 21 ? 0 : 1) & (this.myB.cexp == this.myMonsters[id].monsterPro[4] ? 1 : 0)) != 0) {
                                    byte b1 = (byte)(this.b_c - 1);
                                    this.b_c = b1;
                                    if(b1 == 3) {
                                        this.b_c = 0;
                                        this.cur_c = (byte)(this.cur_c + 1);
                                    }
                                }
                            }
                            else if(!this.level_up(((int)id), 2)) {
                                this.b_c = 15;
                            }
                            else {
                                this.b_c = 1;
                            }
                            break;
                        }
                        default: {
                            goto label_36;
                        }
                    }
                }
                else if(this.myMonsters[id].monsterPro[0] > 0) {
                    if(!this.myMonsters[id].isMonReel(40)) {
                        byte[] arr_b2 = this.myMonsters[id].monster;
                        arr_b2[6] = (byte)(arr_b2[6] - 1);
                    }
                    this.myB.now_id = id;
                    this.myB.chp = this.myMonsters[id].monsterPro[0];
                    this.myB.cexp = this.myMonsters[id].monsterPro[4];
                    this.initMonStream(2, ((int)this.mList_id[this.myMonsters[id].monster[0]][0]), 1);
                    if(this.level_up(((int)id), 0)) {
                        this.b_c = 1;
                    }
                }
                else {
                    this.cur_c = (byte)(this.cur_c + 1);
                }
                Battle battle0 = this.myB;
                battle0.cexp = Ms.i().mathSpeedN(((int)this.myB.cexp), ((int)this.myMonsters[id].monsterPro[4]), 8, false);
                return;
            }
            case -4: {
                if(this.say_c == 0) {
                    byte b2 = (byte)(this.cur_b + 1);
                    this.cur_b = b2;
                    if(b2 >= this.about_a.length) {
                        this.about_a = null;
                        this.goBattleExp(true);
                        return;
                    }
                    Log.e("soars", this.about_a[this.cur_b].toString());
                    this.say(this.about_a[this.cur_b].toString(), 0);
                    return;
                }
                break;
            }
            case 1: {
                if(!this.bufferAI(this.enB.getMon())) {
                    this.enB.act_num = 0;
                    this.battle_state = -2;
                    return;
                }
                this.aiEnemy();
                if(this.enB.getMon().effect != 6 || this.getSkillLevel(((int)this.enB.skill)) <= 3) {
                    this.setAcionSkill(this.enB);
                    return;
                }
                break;
            }
            case 9: {
                if(this.myB.act_num == 0 && this.enB.act_num == 0) {
                    this.myB.act_num = 1;
                    this.enB.act_num = 1;
                    if(this.myB.getMon().isMonEffect(0)) {
                        this.myB.act_num = 0;
                        this.say("石化效果无法行动，受到的伤害减少30%", -1);
                        goto label_87;
                    }
                    else {
                        this.setAimBattle(1);
                        this.goBattleState();
                        String s = "";
                        if(this.myB.getMon().isMonEffect(2)) {
                            s = "撕裂效果，减少当前血量的10%";
                        }
                        else if(this.myB.getMon().isMonEffect(3)) {
                            s = "魅惑效果，不能逃跑，增加捕获宠物的几率";
                        }
                        else if(this.myB.getMon().isMonEffect(4)) {
                            s = "禁锢效果，不能逃跑，不能换怪，不能使用道具";
                        }
                        else if(this.myB.getMon().isMonEffect(5)) {
                            s = "腐蚀效果，每回合受到一定伤害";
                        }
                        if(!s.equals("")) {
                            this.say(s, 0);
                            return;
                        }
                    }
                }
                else {
                label_87:
                    if(this.myB.act_num != 0 && this.enB.act_num != 0) {
                        this.setAimBattle((this.myB.getMon().monsterPro[5] < this.enB.getMon().monsterPro[5] ? 0 : 1));
                    }
                    else {
                        this.setAimBattle((this.myB.act_num == 0 ? 0 : 1));
                    }
                    if(this.mini_state == 1) {
                        this.myB.act_num = 0;
                        if(this.myB.getMon().monster[6] < 41) {
                            Ms.i();
                            if(Ms.getRandom(100) < 25) {
                                this.say("忠诚度过低，宠物不服从主人命令", -1);
                                return;
                            }
                        }
                        if(this.myB.getMon().isMonEffect(0)) {
                            this.say("石化效果无法行动，受到的伤害减少30%", -1);
                            return;
                        }
                        this.setAcionSkill(this.myB);
                        return;
                    }
                    if(this.say_c == 0) {
                        this.enB.act_num = 0;
                        if(!this.enB.getMon().isMonEffect(0)) {
                            this.battle_state = 1;
                            return;
                        }
                    }
                }
                break;
            }
        }
    }

    private void runHit() {
        if(!this.am.b_renascence && !this.dm.b_renascence) {
            Monster monster0 = this.am.getMon();
            Monster monster1 = this.dm.getMon();
            this.hit_rate(this.am, this.dm, monster0, monster1, ((int)this.am.skill));
        }
        else {
            this.am.b_renascence = false;
            this.dm.b_renascence = false;
        }
        this.battle_state = -2;
    }

    private boolean runHitToState(Battle amB, Battle dmB, int mState) {
        if(dmB.getMon().monsterPro[0] > 0) {
            return true;
        }
        if(dmB.dead == 1) {
            if(dmB.getMon().isMonReel(38)) {
                Ms.i();
                if(Ms.getRandom(100) < this.skill[38][1]) {
                    this.setRelive(amB, dmB);
                    return false;
                }
            }
            if(mState == 0) {
                this.enB.act_num = 1;
                if(this.changeMy()) {
                    return false;
                }
                switch(this.overMode) {
                    case 0: {
                        if(!SMSSender.i(this).sms_a) {
                            System.out.println("bbbbbbbbbb");
                            SMSSender.i(this).sms_a = true;
                            this.goGameOver();
                            return false;
                        }
                        System.out.println("aaaaaaaaaaaaa");
                        if(this.say_c == 0) {
                            this.isKillAll = true;
                            if(!GameRun.isSay) {
                                this.say("携带的宠物全都牺牲了!", -1, 1);
                                return false;
                            }
                        }
                        return false;
                    }
                    case 2: {
                        break;
                    }
                    default: {
                        goto label_26;
                    }
                }
                this.map.sIfElse = 1;
            label_26:
                this.overMode = 0;
                this.arangeMonster();
                this.setNullBattle();
                this.goGO_RUNINMAP();
                this.healMonster(false);
                return false;
            }
            else if(mState == 1) {
                if(this.changeMon(this.enB, this.enB.mon.length)) {
                    this.setEnemyThrow();
                    this.enB.act_num = 0;
                    GameRun.run_state = -50;
                    this.t_battle_state = this.battle_state;
                    this.battle_state = 0;
                    return false;
                }
                this.goBattleItem();
                if(this.overMode == 2) {
                    this.map.sIfElse = 0;
                }
                this.overMode = 0;
                return false;
            }
        }
        else if(dmB.action != 2) {
            dmB.action = 2;
            this.now_action[this.mini_state] = 0;
            this.now_time[this.mini_state] = 0;
            if(!dmB.getMon().isMonReel(40)) {
                byte[] arr_b = dmB.getMon().monster;
                arr_b[6] = (byte)(arr_b[6] - 10);
                return false;
            }
        }
        return false;
    }

    private void runMonsterAppear() {
        if(this.battle_state == 0 && this.myB.throw_state == 2) {
            if(this.view_state == -2) {
                this.setAimBattle(0);
                this.myB.act_num = 0;
                this.enB.act_num = 0;
            }
            this.view_state = -1;
            this.goBattleState();
            if(this.t_battle_state == -3 || this.t_battle_state == -2) {
                this.battle_state = this.t_battle_state;
                this.t_battle_state = 0;
                Monster monster0 = this.enB.getMon();
                Monster monster1 = this.myB.getMon();
                this.getHitCoefficient(this.enB, monster0, monster1);
            }
            else {
                this.goSelectAction(((int)this.mini_state));
            }
            if(this.first_battle == 0) {
                this.first_battle = 1;
                int coe = (byte)(this.myB.getMon().monster[6] - 99);
                if(((byte)(coe <= 1 ? coe / 20 * 20 : 20)) < 0) {
                    this.say("忠诚度降低，攻击力下降，请及时补充！", 0);
                }
            }
        }
    }

    public boolean runPauseIco() {
        for(int i = 0; true; i = (byte)(i + 1)) {
            if(i >= this.b_ico) {
                return false;
            }
            if(this.map.my.state == 0 && this.pkey.isSelect(this.pkey.button_pos[10][i][0], this.pkey.button_pos[10][i][1], this.pkey.button_pos[10][i][2], this.pkey.button_pos[10][i][3])) {
                if(this.b_ico == 2) {
                    this.isTalk = false;
                    this.pkey.setKey5();
                }
                this.pkey.initPointer();
                if(i == 0) {
                    this.b_ico = (byte)(this.b_ico == 2 ? 7 : 2);
                    return true;
                }
                if(GameRun.run_state != 98) {
                    if(i == 3) {
                        this.goYouPAUSE(0);
                    }
                    else {
                        switch(i) {
                            case 1: {
                                Ms.key = 57;
                                Ms.keyRepeat = true;
                                break;
                            }
                            case 2: {
                                Ms.key = 0x30;
                                Ms.keyRepeat = true;
                                break;
                            }
                            case 4: {
                                Ms.key = 49;
                                Ms.keyRepeat = true;
                                break;
                            }
                            case 5: {
                                Ms.key = 51;
                                Ms.keyRepeat = true;
                                break;
                            }
                            case 6: {
                                SMSSender.i(this).go(0, true);
                                break;
                            }
                            default: {
                                Ms.keyRepeat = true;
                            }
                        }
                    }
                    this.b_ico = 2;
                    return true;
                }
                return true;
            }
        }
    }

    private void runThrowBall(Battle be, Monster mon, int mini) {
        if(this.src_c[mini + 2] == 0 && be.throw_state == -1 && this.src_c[mini] == 12) {
            be.throw_state = 0;
        }
        else if(this.src_c[mini + 2] == 1 && this.src_c[mini] == 0) {
            this.src_c[mini + 2] = 0;
            this.getBattleBG(be, mon);
        }
        switch(be.throw_state) {
            case 0: {
                short[] arr_v = be.cThrow;
                arr_v[0] = (byte)Ms.i().mathSpeedN(((int)be.cThrow[0]), 0, 6, false);
                short[] arr_v1 = be.cThrow;
                arr_v1[1] = (byte)Ms.i().mathSpeedUp(((int)be.cThrow[1]), 62, 2);
                if(be.cThrow[0] == 0 && be.cThrow[1] == 0) {
                    be.throw_state = 1;
                }
                return;
            }
            case 1: {
                if(be.cThrow[2] < 12) {
                    be.cThrow[2] = (short)(be.cThrow[2] + 1);
                    return;
                }
                be.throw_state = 2;
            }
        }
    }

    public void run_gameRun() {
        switch(GameRun.run_state) {
            case -50: {
                this.runMonsterAppear();
                return;
            }
            case 0xFFFFFFE1: {
                this.runBattleState();
                return;
            }
            case -30: {
                if(this.createOver == -1) {
                    byte b = (byte)(this.b_c + 1);
                    this.b_c = b;
                    if(b >= 8) {
                        this.goMontsterAppear();
                        return;
                    }
                }
                break;
            }
            case -21: {
                SMSSender.i(this).runLevel();
                return;
            }
            case -20: {
                SMSSender.i(this).run();
                return;
            }
            case -19: {
                if(this.cThrowX == 0 && this.b_c == 0) {
                    int id = this.items[this.selectx][this.select[0][0]][0];
                    this.deleteItems(id, 1);
                    int getRate = (short)(new byte[]{1, 3, 14}[id - 9] * 30 + 50 - this.enB.getMon().monster[2] + 60 / this.enB.getMon().monster[2] - this.enB.getMon().monsterPro[0] * 100 / this.enB.getMon().monsterPro[2]);
                    int getRate = (short)((7 - (this.enB.getMon().monster[5] - 1) * 2) * getRate / 10);
                    if(this.enB.getMon().isEffect(3)) {
                        getRate = (short)(getRate + 30);
                    }
                    if(this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
                        this.say("所能携带的宠物已经达到上限！", -1);
                        this.enB.act_num = 1;
                        this.myB.act_num = 0;
                        GameRun.run_state = 0xFFFFFFE1;
                        this.battle_state = 9;
                        return;
                    }
                    Ms.i();
                    if(Ms.getRandom(100) < getRate) {
                        this.enB.action = 2;
                        this.enB.dead = 1;
                        this.say("捕获" + this.getNameMon(((int)this.enB.getMon().monster[0])) + "已成功！", 0);
                        if(this.getMonster(this.enB.getMon(), -1, false) == 0) {
                            this.myMonsters[this.myMon_length - 1].monster[1] = (byte)(this.myMon_length - 1);
                        }
                        GameRun.run_state = 0xFFFFFFE1;
                        this.goBattleExp(false);
                        return;
                    }
                    this.b_c = 1;
                    StringBuffer str = new StringBuffer("没有捕获到" + this.getNameMon(((int)this.enB.getMon().monster[0])));
                    if(this.myB.getMon().isMonReel(41) || this.enB.getMon().isEffect(4) || this.enB.getMon().isEffect(3)) {
                        this.enB.act_num = 1;
                        this.myB.act_num = 0;
                        GameRun.run_state = 0xFFFFFFE1;
                        this.battle_state = 9;
                    }
                    else {
                        StringBuilder stringBuilder1 = new StringBuilder("#n").append(this.getNameMon(((int)this.enB.getMon().monster[0])));
                        Ms.i();
                        str.append(stringBuilder1.append(new String[]{"流着泪逃跑了！", "拼了命的逃跑了！", "盯了你一眼，逃走了！"}[Ms.getRandom(3)]).toString());
                    }
                    this.say(str.toString(), 0);
                    return;
                }
                if(this.b_c == 1 && this.say_c == 0) {
                    this.arangeMonster();
                    this.setNullBattle();
                    this.goGO_RUNINMAP();
                    return;
                }
                break;
            }
            case -86: 
            case -15: {
                switch(this.b_c) {
                    case 0: {
                        if(this.levelUp_in_battle[this.myB.getMon().monster[1]][0] == 1) {
                            this.levelUp_in_battle[this.myB.getMon().monster[1]][0] = 0;
                            this.b_c = 1;
                            this.say_s = 52;
                            this.levelPro(((int)this.myB.now_id), true);
                            this.setStringB("生命;+" + ((int)this.proReplace[this.myB.now_id][0]) + "#n" + "能量" + ";+" + ((int)this.proReplace[this.myB.now_id][1]), Constants_H.WIDTH, 0);
                            this.setStringB("力量;+" + ((int)this.proReplace[this.myB.now_id][3]) + "#n" + "防御" + ";+" + ((int)this.proReplace[this.myB.now_id][4]) + "#n" + "敏捷" + ";+" + ((int)this.proReplace[this.myB.now_id][5]), Constants_H.WIDTH, 1);
                            this.initMonStream(2, ((int)this.mList_id[this.myB.getMon().monster[0]][0]), 1);
                        }
                        else {
                            this.myB.now_id = (byte)(this.myB.now_id + 1);
                        }
                        break;
                    }
                    case 1: {
                        this.say_s = Ms.i().mathSpeedDown(this.say_s, 4, true);
                        return;
                    }
                    default: {
                        return;
                    }
                }
                if(this.myB.now_id >= this.myMon_length) {
                    boolean b = false;
                    StringBuffer sbuf = new StringBuffer("");
                    for(int i = 0; i < this.myMon_length; i = (byte)(i + 1)) {
                        if(this.myMonsters[i].monster[5] > 0 && this.evolve[i] && this.isEvolveKind(this.myMonsters[i].monster[4], this.myMonsters[i].monster[2]) == -1) {
                            if(!Ms.i().equals(sbuf, "")) {
                                sbuf.append("、");
                            }
                            sbuf.append(this.getNameMon(((int)this.myMonsters[i].monster[0])));
                            this.evolve[i] = false;
                            b = true;
                        }
                    }
                    if(b) {
                        sbuf.append("可以进化了");
                    }
                    StringBuffer sbuf0 = new StringBuffer("");
                    boolean b = false;
                    for(int i = 0; i < 5; i = (byte)(i + 1)) {
                        if(this.getRid(i) != -2 && this.getNexp(i, 1) == this.getNexp(i, 3)) {
                            if(!Ms.i().equals(sbuf0, "")) {
                                sbuf0.append("、");
                            }
                            StringBuilder stringBuilder0 = new StringBuilder();
                            StringBuffer[] arr_stringBuffer = this.monsterT;
                            byte[][] arr2_b = this.monster_pro;
                            sbuf0.append(stringBuilder0.append(arr_stringBuffer[arr2_b[this.getNid(i)][6]]).append("的宠物蛋").toString());
                            b = true;
                        }
                    }
                    if(b) {
                        sbuf0.append("经验已满，可以孵化了。");
                        if(!Ms.i().equals(sbuf, "")) {
                            sbuf.append("#n");
                        }
                        sbuf.append(sbuf0.toString());
                    }
                    if(!Ms.i().equals(sbuf, "")) {
                        this.say(sbuf.toString(), -1);
                    }
                    this.setNullBattle();
                    this.goGO_RUNINMAP();
                    return;
                }
                break;
            }
            case -11: {
                this.goRUN_IN_MAP(false);
                return;
            }
            case -10: {
                this.map.run_map();
                return;
            }
            case 35: {
                byte b1 = (byte)(this.mon_action_c + 1);
                this.mon_action_c = b1;
                if(b1 > 50) {
                    this.mon_action_c = 0;
                    this.mon_action = 1;
                }
                if(this.cur_c == 2 && this.b_c == -1 && this.say_s == 0) {
                    this.goView();
                    return;
                }
                break;
            }
            case 69: {
                Mg.i().run();
                return;
            }
            case 100: {
                if(this.b_c == 1) {
                    this.saveGame();
                    this.say("游戏已保存。", 0);
                    this.b_c = 0;
                    this.goRUN_IN_MAP(true);
                    return;
                }
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

    public void say(String string, int flag) {
        Log.e("soars", string);
        if(string.equals("#7点击屏幕或用导航键#0控制上下左右移动。")) {
            string = "#7点击屏幕#0控制上下左右移动。";
        }
        this.sayStr.add(string);
        this.sayFlag.add(Integer.valueOf(flag));
        this.setSay();
    }

    public void say(String string, int flag, int sayOverSms) {
        this.showS = Ms.i().groupString(string, Constants_H.WIDTH - 50);
        this.say_s = Constants_H.WIDTH;
        this.say_mode = 0;
        if(flag == 0) {
            this.say_c = 15;
            return;
        }
        if(flag == -1) {
            this.say_c = -1;
            this.sayOverSms = (byte)sayOverSms;
            return;
        }
        if(flag == 1) {
            this.say_c = 15;
            this.say_mode = 1;
        }
    }

    private void sellMonster(Monster mon) {
        this.sell_money = mon.monster[2] * (mon.monster[4] * 5) + 100;
    }

    private void setAcionSkill(Battle be) {
        be.action = 1;
        this.now_action[this.mini_state] = 0;
        this.now_time[this.mini_state] = 0;
        this.battle_state = -1;
        this.setMagic(be.skill / 5);
    }

    public void setAimBattle(int state) {
        this.mini_state = (byte)state;
        this.am = this.mini_state == 1 ? this.myB : this.enB;
        this.dm = this.mini_state == 1 ? this.enB : this.myB;
    }

    private boolean setCartoonFrameMagic_C(int i, int skill_mode, int select, boolean mode) {
        short[] arr_v = this.now_time_Magic;
        short v3 = (short)(arr_v[i] + 1);
        arr_v[i] = v3;
        if(v3 >= this.magic[skill_mode].action(select, ((int)this.now_action_Magic[i]), 1)) {
            this.now_action_Magic[i] = (short)(this.now_action_Magic[i] + 1);
            this.now_time_Magic[i] = 0;
            if(!mode && this.now_action_Magic[i] >= this.magic[skill_mode].aLength(select)) {
                this.now_action_Magic[i] = (short)(this.now_action_Magic[i] - 1);
                return true;
            }
        }
        return false;
    }

    private boolean setCartoonFrame_C(int i, int skill_mode, int select, boolean mode) {
        byte[] arr_b = this.now_time;
        byte b = (byte)(arr_b[i] + 1);
        arr_b[i] = b;
        if(b >= this.mon[skill_mode].action(select, ((int)this.now_action[i]), 1)) {
            this.now_action[i] = (byte)(this.now_action[i] + 1);
            this.now_time[i] = 0;
            if(!mode && this.now_action[i] >= this.mon[skill_mode].aLength(select)) {
                this.now_action[i] = (byte)(this.now_action[i] - 1);
                return true;
            }
        }
        return false;
    }

    private void setEnemyThrow() {
        this.enemyOff = 0x3F;
        this.enB.cThrow[0] = (byte)(Constants_H.WIDTH - 357);
        this.enB.cThrow[1] = 60;
        this.enB.cThrow[2] = 0;
        Monster monster0 = this.enB.getMon();
        this.setThrow(this.enB, monster0, 0);
        Monster monster1 = this.myB.getMon();
        Monster monster2 = this.enB.getMon();
        this.getHitCoefficient(this.myB, monster1, monster2);
        Monster monster3 = this.enB.getMon();
        Monster monster4 = this.myB.getMon();
        this.getHitCoefficient(this.enB, monster3, monster4);
    }

    private void setEvolveStringB(Monster monster) {
        int eid = (byte)(monster.monster[0] + 1);
        int level = monster.monster[2];
        boolean b_e = false;
        if(this.monsterMake[monster.monster[0]][0] > 0 && this.findItem(-2, 34, true) > 0) {
            eid = this.monsterMake[monster.monster[0]][0];
            b_e = true;
        }
        this.proReplace = null;
        this.proReplace = new short[1][6];
        short[] arr_v = this.proReplace[0];
        arr_v[0] = (short)(this.getbuffRateV(monster, this.monster_pro[eid][0] + this.monster_pro[eid][7] * level / 10) - monster.monsterPro[2]);
        this.proReplace[0][1] = (short)(this.monster_pro[eid][1] + this.monster_pro[eid][8] * level / 10 - monster.monsterPro[3]);
        short[] arr_v1 = this.proReplace[0];
        int v2 = b_e ? monster.monster[5] : 1;
        arr_v1[2] = (short)(-v2);
        this.proReplace[0][3] = (byte)(this.monster_pro[eid][3] + this.monster_pro[eid][10] * level / 10 - monster.monsterPro[6]);
        this.proReplace[0][4] = (byte)(this.monster_pro[eid][4] + this.monster_pro[eid][11] * level / 10 - monster.monsterPro[7]);
        this.proReplace[0][5] = (byte)(this.monster_pro[eid][2] + this.monster_pro[eid][9] * level / 10 - monster.monsterPro[5]);
        this.setStringB("生命：+" + ((int)this.proReplace[0][0]) + "#n" + "能量" + "：+" + ((int)this.proReplace[0][1]) + "#n" + "进化" + "：" + ((int)this.proReplace[0][2]), Constants_H.WIDTH, 0);
        this.setStringB("力量：+" + ((int)this.proReplace[0][3]) + "#n" + "防御" + "：+" + ((int)this.proReplace[0][4]) + "#n" + "敏捷" + "：+" + ((int)this.proReplace[0][5]), Constants_H.WIDTH, 1);
        this.proReplace = null;
    }

    public void setMagic(int pro) {
        if(pro > 5) {
            pro = 5;
        }
        this.initMagicStream(pro);
        this.now_action_Magic[pro] = 0;
        this.now_time_Magic[pro] = 0;
    }

    private void setMyThrow() {
        this.myB.cThrow[0] = -286;
        this.myB.cThrow[1] = 60;
        this.myB.cThrow[2] = 0;
        Monster monster0 = this.myB.getMon();
        this.setThrow(this.myB, monster0, 1);
        Monster monster1 = this.myB.getMon();
        Monster monster2 = this.enB.getMon();
        this.getHitCoefficient(this.myB, monster1, monster2);
        Monster monster3 = this.enB.getMon();
        Monster monster4 = this.myB.getMon();
        this.getHitCoefficient(this.enB, monster3, monster4);
    }

    private void setNidusPro(int i, int level) {
        StringBuffer sbuff = new StringBuffer();
        sbuff.append("生命：" + (this.monster_pro[i][0] + this.monster_pro[i][7] * level / 10) + "#n");
        sbuff.append("能量：" + (this.monster_pro[i][1] + this.monster_pro[i][8] * level / 10) + "#n");
        sbuff.append("进化：" + ((int)this.monster_pro[i][12]));
        this.setStringB(sbuff.toString(), Constants_H.WIDTH, 0);
        sbuff.delete(0, sbuff.length());
        sbuff.append("力量：" + (this.monster_pro[i][3] + this.monster_pro[i][10] * level / 10) + "#n");
        sbuff.append("防御：" + (this.monster_pro[i][4] + this.monster_pro[i][11] * level / 10) + "#n");
        sbuff.append("敏捷：" + (this.monster_pro[i][4] + this.monster_pro[i][11] * level / 10));
        this.setStringB(sbuff.toString(), Constants_H.WIDTH, 1);
    }

    public void setNull(boolean bb) {
        if(this.map != null) {
            this.map.setNull();
        }
        if(this.mon[0] != null) {
            this.mon[0].nullIMFA();
        }
        if(this.mon[1] != null) {
            this.mon[1].nullIMFA();
        }
        if(bb) {
            this.data_null();
        }
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
        for(int i = this.select[0][0]; i < this.myMon_length - 1; i = (byte)(i + 1)) {
            this.myMonsters[i] = this.myMonsters[i + 1];
            this.evolve[i] = this.evolve[i + 1];
        }
        for(int i = this.myMon_length; i < this.myMonsters.length; i = (byte)(i + 1)) {
            this.evolve[i] = true;
        }
        this.myMon_length = (byte)(this.myMon_length - 1);
        if(this.select[0][0] == this.myMon_length) {
            byte[] arr_b = this.select[0];
            arr_b[0] = (byte)(arr_b[0] - 1);
        }
        this.initMonStream(2, ((int)this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0]), 1);
        this.setShowPro(this.myMonsters[this.select[0][0]]);
        this.introT = Constants_H.WIDTH_H;
        this.t_length = this.myMon_length;
        this.popMenu = -1;
        Ms.i().correctSelect(this.select[0], ((int)this.t_length), ((int)this.list_rows));
    }

    private void setRelive(Battle amB, Battle dmB) {
        dmB.initHit();
        dmB.addHit(-dmB.getMon().monsterPro[2] * this.skill[38][0] / 100, 1, 1);
        dmB.skill = 28;
        dmB.dead = 0;
        dmB.action = 0;
        dmB.b_renascence = true;
        dmB.act_num = 0;
        this.battle_state = -1;
        this.setMagic(5);
        this.getHitCoefficient(dmB, dmB.getMon(), amB.getMon());
        this.setAimBattle(this.mini_state ^ 1);
    }

    public void setSay() {
        if(this.say_c == 0 && this.sayStr.size() != 0) {
            String string = (String)this.sayStr.remove(0);
            int v = (int)(((Integer)this.sayFlag.remove(0)));
            this.showS = Ms.i().groupString(string, Constants_H.WIDTH - 50);
            this.say_s = Constants_H.WIDTH;
            this.say_mode = 0;
            if(v == 0) {
                this.say_c = 15;
                return;
            }
            if(v == -1) {
                this.say_c = -1;
                return;
            }
            if(v == 1) {
                this.say_c = 15;
                this.say_mode = 1;
            }
        }
    }

    private void setShowPro(Monster monster) {
        this.setStringB(((int)monster.monsterPro[6]) + "#n" + (((int)monster.monsterPro[7]) + "#n") + ((int)monster.monsterPro[5]), Constants_H.WIDTH, 2);
    }

    private void setTakenMonster() {
        for(int i = this.select[0][0]; i < this.cMon_count - 1; i = (byte)(i + 1)) {
            this.cMonsters[i] = this.cMonsters[i + 1];
        }
        this.cMon_count = (byte)(this.cMon_count - 1);
        this.t_length = this.cMon_count;
        if(this.select[0][0] == this.cMon_count) {
            byte[] arr_b = this.select[0];
            arr_b[0] = (byte)(arr_b[0] - 1);
        }
        if(this.t_length > 0) {
            this.initMonStream(2, ((int)this.mList_id[this.cMonsters[this.select[0][0]].monster[0]][0]), 1);
            this.setShowPro(this.cMonsters[this.select[0][0]]);
        }
        this.introT = Constants_H.WIDTH_H;
        this.popMenu = -1;
        Ms.i().correctSelect(this.select[0], ((int)this.t_length), ((int)this.list_rows));
    }

    private void setThrow(Battle be, Monster mon, int mini) {
        be.throw_state = -1;
        this.initMonStream(2, ((int)this.mList_id[mon.monster[0]][0]), mini);
        if(!mon.isMonReel(mon.monster[3] + 43)) {
            if(this.monPro.length != 0 && be.bg_id != this.monPro[0]) {
                this.src_c[mini + 2] = 1;
            }
        }
        else if(be.bg_id != mon.monster[3]) {
            this.src_c[mini + 2] = 1;
        }
        be.action = 0;
        be.dead = 0;
        be.chp = mon.monsterPro[0];
    }

    public void skyCheckRegFull(int where) {
        switch(where) {
            case 1: {
                this.map.setRegState(true);
                GameRun.mc.skyNewGame();
                return;
            }
            case 2: {
                this.map.setRegState(true);
                GameRun.mc.skyContinueGame();
            }
        }
    }

    public void start() {
        this.goRUN_IN_MAP(true);
        this.map.insertNpc();
        this.line_max = 2;
        this.cityName_c = 25;
        if(this.map.anole_temp != -2) {
            this.map.anole_type = this.map.anole_temp;
            this.map.anole_temp = -2;
            this.map.setAnole();
        }
    }

    private void takenMonster() {
        if(this.myMon_length < this.max_takes) {
            this.myMonsters[this.myMon_length] = this.cMonsters[this.select[0][0]];
            this.evolve[this.myMon_length] = true;
            this.myMon_length = (byte)(this.myMon_length + 1);
            this.setTakenMonster();
            return;
        }
        this.say("所能携带的宠物已经达到上限！", 1);
    }

    private void useItem() {
        switch(this.items[0][this.select_it[0]][0]) {
            case 0: {
                this.hpAdd(35, 30);
                return;
            }
            case 1: {
                this.hpAdd(65, 30);
                return;
            }
            case 2: {
                this.hpAdd(100, 0);
                return;
            }
            case 3: {
                this.mpAdd(50);
                return;
            }
            case 4: {
                this.mpAdd(100);
                return;
            }
            case 5: {
                this.allAdd(50);
                return;
            }
            case 6: {
                this.allAdd(100);
                return;
            }
            case 7: {
                this.resetMonster(30);
                return;
            }
            case 8: {
                this.changeEffect();
                return;
            }
            case 12: {
                this.resetFealty(30);
                return;
            }
            case 13: {
                this.resetFealty(-1);
            }
        }
    }

    private void useState(int type, int id) {
        GameRun.mc.paint();
        Ms.i().sleep(200);
        if(this.view_state == -1) {
            this.myB.act_num = 0;
            this.goBattleState();
            this.battle_state = 9;
            this.initMonStream(2, ((int)this.mList_id[this.myMonsters[0].monster[0]][0]), 1);
        }
        else {
            this.goMY_BAG(type);
        }
        this.deleteItems(((int)this.items[type][id][0]), 1);
    }

    public void valueMend(Monster monster) {
        if(monster.monsterPro[0] < 0) {
            monster.monsterPro[0] = 0;
        }
        else if(monster.monsterPro[0] > monster.monsterPro[2]) {
            monster.monsterPro[0] = monster.monsterPro[2];
        }
        if(monster.monsterPro[1] < 0) {
            monster.monsterPro[1] = 0;
            return;
        }
        if(monster.monsterPro[1] > monster.monsterPro[3]) {
            monster.monsterPro[1] = monster.monsterPro[3];
        }
    }
}

