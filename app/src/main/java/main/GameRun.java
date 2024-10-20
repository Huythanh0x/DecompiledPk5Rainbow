/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.PetKing5_480x800.PetKing5
 *  com.nokia.mid.ui.DirectGraphics
 *  dm.Battle
 *  dm.Monster
 *  dm.Ms
 *  dm.Sound
 *  dm.Sprite
 *  dm.Ui
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 *  main.Constants_H
 *  main.CreateThread
 *  main.GameRun_F
 *  main.MainCanvas
 *  main.Map
 *  main.SMSSender
 *  minigame.Mg
 */
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
import main.Constants_H;
import main.CreateThread;
import main.GameRun_F;
import main.MainCanvas;
import main.Map;
import main.SMSSender;
import minigame.Mg;

public class GameRun
extends GameRun_F {
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
    private byte[] initFealty;
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
    private byte list_rows = (byte)8;
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
    public ArrayList<Integer> sayFlag;
    public byte sayOverSms;
    public ArrayList<String> sayStr;
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

    public GameRun(MainCanvas mainCanvas) {
        this.initFealty = new byte[]{100, 120};
        this.sayStr = new ArrayList<E>();
        this.sayFlag = new ArrayList<E>();
        this.sayOverSms = (byte)-1;
        byte[] byArray = new byte[16];
        byArray[0] = -6;
        byArray[1] = -4;
        byArray[2] = -3;
        byArray[3] = -2;
        byArray[4] = -1;
        byArray[6] = 1;
        byArray[7] = 2;
        byArray[8] = 3;
        byArray[9] = 4;
        byArray[10] = 8;
        byArray[11] = -3;
        byArray[12] = 2;
        byArray[13] = -1;
        byArray[14] = 1;
        byArray[15] = 1;
        this.zb = byArray;
        byte[] byArray2 = new byte[2];
        byArray2[0] = 4;
        byArray = new byte[2];
        byArray[1] = 1;
        this.Shuxing = new byte[][]{{2, 3}, {3, 4}, byArray2, byArray, {1, 2}};
        this.hit_rate = 0;
        this.magic_id = (byte)-2;
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
        this.battleSay = new String[]{"\u654c\u4eba\u51fa\u73b0\u4e86\uff0c\u6218\u6597\u5427\uff01", "\u8003\u9a8c\u7684\u65f6\u523b\u6765\u4e86\uff0c\u8bad\u7ec3\u5e08\uff01", "\u5c3d\u60c5\u6355\u6349\u5ba0\u7269\u5427\uff01"};
        this.isUpdateList = false;
        this.first_battle = 0;
        this.lastSkill = 0;
        this.skill_list = new byte[9];
        this.b_ico = (byte)2;
        mc = mainCanvas;
        this.map = null;
        this.map = new Map(this);
        this.initOtherImage();
        Ui.i().initUiModules();
        this.loadRmsOther();
        this.loadRmsSms();
        SMSSender.i((GameRun)this);
        PetKing5.gr = this;
    }

    /*
     * Enabled force condition propagation
     */
    private void AddHP(int n, Monster monster) {
        if ((n += monster.monsterPro[0]) >= monster.monsterPro[2]) {
            monster.monsterPro[0] = monster.monsterPro[2];
            return;
        }
        monster.monsterPro[0] = (short)n;
    }

    /*
     * Enabled force condition propagation
     */
    private void AddMP(int n, Monster monster) {
        if ((n += monster.monsterPro[1]) > monster.monsterPro[3]) {
            monster.monsterPro[1] = monster.monsterPro[3];
            return;
        }
        monster.monsterPro[1] = (short)n;
    }

    /*
     * Unable to fully structure code
     */
    private void aiEnemy() {
        block27: {
            block26: {
                block23: {
                    block25: {
                        block24: {
                            var1_1 = 5;
                            Ms.i();
                            var2_2 = (byte)Ms.getRandom((int)100);
                            block15: while (true) {
                                if (var1_1 > -1 && this.enB.getMon().monster[var1_1 + 8] == -1) ** GOTO lbl-1000
                                var4_3 = (byte)(var1_1 + 1);
                                if (this.battle_type == 4) {
                                    switch (var4_3) {
                                        default: {
                                            if (var2_2 >= 45) break block15;
                                            this.enB.skill = (byte)(var4_3 - 1);
lbl13:
                                            // 24 sources

                                            while (true) {
                                                this.enB.skill = this.enB.getMon().monster[this.enB.skill + 8];
                                                return;
                                            }
                                        }
                                    }
                                }
                                break block23;
lbl-1000:
                                // 1 sources

                                {
                                    var1_1 = (byte)(var1_1 - 1);
                                    continue block15;
                                    case 1: {
                                        this.enB.skill = 0;
                                        ** GOTO lbl13
                                    }
                                    case 2: {
                                        if (var2_2 >= 65) ** GOTO lbl26
                                        this.enB.skill = 1;
                                        ** GOTO lbl13
lbl26:
                                        // 1 sources

                                        this.enB.skill = 0;
                                        ** GOTO lbl13
                                    }
                                    case 3: {
                                        if (var2_2 >= 45) ** GOTO lbl32
                                        this.enB.skill = (byte)2;
                                        ** GOTO lbl13
lbl32:
                                        // 1 sources

                                        if (var2_2 <= 75) ** GOTO lbl35
                                        this.enB.skill = 1;
                                        ** GOTO lbl13
lbl35:
                                        // 1 sources

                                        this.enB.skill = 0;
                                        ** GOTO lbl13
                                    }
                                }
                                break;
                            }
                            if (var2_2 >= 75) break block24;
                            this.enB.skill = (byte)(var4_3 - 2);
                            ** GOTO lbl13
                        }
                        if (var2_2 >= 95) break block25;
                        this.enB.skill = (byte)(var4_3 - 3);
                        ** GOTO lbl13
                    }
                    this.enB.skill = (byte)(var4_3 - 4);
                    ** GOTO lbl13
                }
                var1_1 = 0;
                Ms.i();
                var3_4 = (byte)Ms.getRandom((int)100);
                block17: while (true) {
                    if (var1_1 < 2) ** GOTO lbl61
                    block18: while (true) {
                        if (var1_1 <= 1) ** GOTO lbl13
                        switch (var4_3) {
                            default: {
                                if (var2_2 >= 60) break block17;
                                this.enB.skill = (byte)(var4_3 - 1);
                                ** GOTO lbl13
                            }
lbl61:
                            // 1 sources

                            switch (this.enB.getMon().monster[var1_1 + 14]) lbl-1000:
                            // 2 sources

                            {
                                default: {
                                    while (true) {
                                        var1_1 = (byte)(var1_1 + 1);
                                        continue block17;
                                        break;
                                    }
                                }
                                case 27: {
                                    if (!this.isMonHp(this.enB.getMon(), 50) || var3_4 >= 30) ** GOTO lbl-1000
lbl68:
                                    // 2 sources

                                    while (true) {
                                        this.enB.skill = (byte)(var1_1 + 6);
                                        continue block18;
                                        break;
                                    }
                                }
                                case 28: 
                            }
                            if (!this.isMonHp(this.enB.getMon(), 30) || var3_4 >= 30) ** continue;
                            ** continue;
                            case 1: {
                                this.enB.skill = 0;
                                ** GOTO lbl13
                            }
                            case 2: {
                                if (var2_2 >= 20) ** GOTO lbl81
                                this.enB.skill = 0;
                                ** GOTO lbl13
lbl81:
                                // 1 sources

                                this.enB.skill = 1;
                                ** GOTO lbl13
                            }
                            case 3: {
                                if (var2_2 >= 5) ** GOTO lbl87
                                this.enB.skill = 0;
                                ** GOTO lbl13
lbl87:
                                // 1 sources

                                if (var2_2 <= 40) ** GOTO lbl90
                                this.enB.skill = (byte)2;
                                ** GOTO lbl13
lbl90:
                                // 1 sources

                                this.enB.skill = 1;
                                ** GOTO lbl13
                            }
                            case 4: {
                                if (var2_2 >= 15) ** GOTO lbl96
                                this.enB.skill = 1;
                                ** GOTO lbl13
lbl96:
                                // 1 sources

                                if (var2_2 >= 40) ** GOTO lbl99
                                this.enB.skill = (byte)2;
                                ** GOTO lbl13
lbl99:
                                // 1 sources

                                this.enB.skill = (byte)3;
                                ** GOTO lbl13
                            }
                        }
                        break;
                    }
                    break;
                }
                if (var2_2 >= 85) break block26;
                this.enB.skill = (byte)(var4_3 - 2);
                ** GOTO lbl13
            }
            if (var2_2 >= 95) break block27;
            this.enB.skill = (byte)(var4_3 - 3);
            ** GOTO lbl13
        }
        this.enB.skill = (byte)(var4_3 - 4);
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private void allAdd(int n) {
        boolean bl = false;
        boolean bl2 = false;
        if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u65e0\u6cd5\u4f7f\u7528\uff01", 0);
            return;
        }
        boolean bl3 = bl;
        if (this.myMonsters[this.select[0][0]].monsterPro[1] < this.myMonsters[this.select[0][0]].monsterPro[3]) {
            bl3 = bl;
            if (this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
                this.AddMP(this.myMonsters[this.select[0][0]].monsterPro[3] * n / 100, this.myMonsters[this.select[0][0]]);
                bl3 = true;
            }
        }
        bl = bl2;
        if (this.myMonsters[this.select[0][0]].monsterPro[0] < this.myMonsters[this.select[0][0]].monsterPro[2]) {
            bl = bl2;
            if (this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
                this.AddHP(this.myMonsters[this.select[0][0]].monsterPro[2] * n / 100, this.myMonsters[this.select[0][0]]);
                bl = true;
            }
        }
        if (bl || bl3) {
            this.useState(0, this.select_it[0]);
            return;
        }
        if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            this.AddHP(this.myMonsters[this.select[0][0]].monsterPro[2] * n / 100, this.myMonsters[this.select[0][0]]);
            return;
        }
        this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u4e0d\u9700\u8981\u4f7f\u7528\u8fd9\u4e2a\u9053\u5177", 0);
    }

    /*
     * Unable to fully structure code
     */
    private void arangeMonster() {
        if (this.myMon_length <= 1) ** GOTO lbl5
        var1_1 = 0;
        block0: while (true) {
            block7: {
                if (var1_1 < this.myMon_length - 1) break block7;
lbl5:
                // 2 sources

                return;
            }
            var2_2 = (byte)(var1_1 + 1);
            while (true) {
                if (var2_2 >= this.myMon_length) {
                    var1_1 = (byte)(var1_1 + 1);
                    continue block0;
                }
                if (this.myMonsters[var1_1].monster[1] > this.myMonsters[var2_2].monster[1]) {
                    this.changeMonster(this.myMonsters[var1_1], this.myMonsters[var2_2]);
                }
                var2_2 = (byte)(var2_2 + 1);
            }
            break;
        }
    }

    /*
     * Enabled force condition propagation
     */
    private boolean bufferAI(Monster monster) {
        if (!monster.isMonEffect(0)) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     */
    private void changeEffect() {
        if (this.myMonsters[this.select[0][0]].effect != 7) {
            this.myMonsters[this.select[0][0]].effect = (byte)7;
            this.useState(0, this.select_it[0]);
            return;
        }
        this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u6ca1\u6709\u5f02\u5e38\uff01", 0);
    }

    /*
     * Enabled force condition propagation
     */
    private boolean changeMon(Battle battle, int n) {
        byte by;
        int n2 = 0;
        byte by2 = battle.now_id;
        while (true) {
            byte by3;
            battle.now_id = by3 = (byte)(battle.now_id + 1);
            if (by3 >= n) {
                battle.now_id = 0;
            }
            if ((by = (byte)(n2 + 1)) > n) break;
            n2 = by;
            if (by2 == battle.now_id) continue;
            n2 = by;
            if (battle.getMon().monsterPro[0] >= 1) break;
        }
        if (by > n) {
            battle.now_id = by2;
        }
        if (by > n) return false;
        return true;
    }

    private void changeMonster(Monster monster, Monster monster2) {
        Monster monster3 = new Monster();
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

    /*
     * Enabled force condition propagation
     */
    private boolean changeMy() {
        byte by = 1;
        while (by < this.myMon_length) {
            if (this.myMonsters[by].monsterPro[0] > 0) {
                this.setAimBattle(1);
                this.goVIEW_MONSTER();
                return true;
            }
            by = (byte)(by + 1);
        }
        return false;
    }

    private void dItemIn(int n, int n2) {
        while (true) {
            if (n2 >= this.itemsLength[n] - 1) {
                byte[] byArray = this.itemsLength;
                byArray[n] = (byte)(byArray[n] - 1);
                this.items[n][this.itemsLength[n]] = null;
                this.items[n][this.itemsLength[n]] = new byte[2];
                return;
            }
            this.items[n][n2] = this.items[n][n2 + 1];
            ++n2;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void damage(Battle var1_1, Battle var2_2, Monster var3_3, Monster var4_4, int var5_5, int var6_6) {
        block8: {
            block9: {
                var11_7 = var3_3.monster[2];
                var7_8 = var4_4.monster[2];
                var6_6 = 0;
                var9_9 = var3_3.monsterPro[6];
                var10_10 = var4_4.monsterPro[7];
                var5_5 = this.skill[var5_5][0];
                var7_8 = var11_7 - var7_8;
                var8_11 = 100;
                var9_9 = var9_9 * var5_5 * (1000 - var10_10 * 5) / 10000;
                var10_10 /= 10;
                var12_12 = var11_7 / (var5_5 * 2);
                var11_7 = (var11_7 - 1) / 10;
                if (var7_8 <= 10) break block9;
                var5_5 = 10;
lbl15:
                // 3 sources

                while (true) {
                    block11: {
                        block10: {
                            var7_8 = (var5_5 * 4 + 100) * (var9_9 - var10_10 - var12_12 + 6 - var11_7) / 100;
                            var5_5 = var6_6;
                            if (var4_4.effect == 0) {
                                var5_5 = -30;
                            }
                            var9_9 = (var1_1.countS[1] + var5_5 + 100) * var7_8 / 100;
                            var7_8 = 1;
                            if (!var3_3.isBuffRate(9)) break block10;
                            Ms.i();
                            if (Ms.getRandom((int)100) < this.inhesion[9]) break block11;
                        }
                        if (!var4_4.isMonReel(48)) break block8;
                        Ms.i();
                        if (Ms.getRandom((int)100) >= this.skill[48][0]) break block8;
                    }
                    var5_5 = var9_9 >> 1;
                    var6_6 = var7_8;
lbl34:
                    // 4 sources

                    while (true) {
                        var7_8 = var8_11;
                        if (var4_4.monster[3] == 1) {
                            var7_8 = var8_11;
                            if (var4_4.isMonReel(33)) {
                                var7_8 = this.skill[33][0];
                            }
                        }
                        var5_5 = var7_8 = var5_5 * var7_8 / 100;
                        if (var7_8 < 1) {
                            var5_5 = 1;
                        }
                        var2_2.addHit(var5_5, var6_6, 0);
                        return;
                    }
                    break;
                }
            }
            var5_5 = var7_8;
            if (var7_8 >= -10) ** GOTO lbl15
            var5_5 = -10;
            ** while (true)
        }
        var6_6 = var7_8;
        var5_5 = var9_9;
        if (!var3_3.isBuffRate(10)) ** GOTO lbl34
        Ms.i();
        var6_6 = var7_8;
        var5_5 = var9_9;
        if (Ms.getRandom((int)100) >= this.inhesion[10]) ** GOTO lbl34
        var5_5 = var9_9 * 15 / 10;
        var6_6 = 2;
        ** while (true)
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

    private void delItemEvolve(byte by) {
        byte by2;
        int n = 2;
        do {
            this.deleteItems(this.monsterMake[by][n], this.monsterMake[by][n + 1]);
            by2 = (byte)(n + 2);
            n = by2;
        } while (by2 < this.monsterMake[by].length - 1);
    }

    private void delItemSkill(Monster monster) {
        this.say(String.valueOf(this.getNameMon(monster.monster[0])) + "\u4e60\u5f97\u6280\u80fd\uff1a" + this.getNameSkill(this.getSkill), 0);
        this.goMY_BAG(2);
        this.deleteItems(this.getSkill + 35 - 25 - 1, 1);
        Ms.i().correctSelect(this.select[0], (int)this.itemsLength[this.selectx], (int)this.list_rows);
    }

    /*
     * Unable to fully structure code
     */
    private void doBuffValue(Battle var1_1) {
        if (var1_1.getMon().monsterPro[0] < 1) lbl-1000:
        // 3 sources

        {
            return;
        }
        if (!var1_1.getMon().isBuffRate(4)) ** GOTO lbl-1000
        var1_1.addHit(-var1_1.getMon().monsterPro[2] * this.inhesion[4] / 100, 1, 1);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void doEffectValue(Battle var1_1) {
        var2_2 = 0;
        if (var1_1.getMon().isMonEffect(2)) {
            var2_2 = (short)(var1_1.getMon().monsterPro[0] / 10);
lbl4:
            // 3 sources

            while (true) {
                var3_3 = var2_2;
                if (var1_1.getMon().isMonReel(3)) {
                    var3_3 = (short)(this.inhesion[3] * var2_2 / 100 + var2_2);
                }
                if (var3_3 != 0) {
                    var1_1.addHit((int)var3_3, 1, 0);
                }
                return;
            }
        }
        if (!var1_1.getMon().isMonEffect(5)) ** GOTO lbl4
        var2_2 = (short)(var1_1.fs_level * var1_1.fs_level + 4);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawAnimationBattle(Battle var1_1, int var2_2) {
        if (var1_1.action != 0) lbl-1000:
        // 3 sources

        {
            return;
        }
        var4_3 = (byte)(var1_1.skill / 5);
        var3_4 = (byte)(var1_1.skill % 5);
        var2_2 = var4_3;
        if (var4_3 > 5) {
            var2_2 = 5;
        }
        if (var2_2 == 5) {
            var3_4 = (byte)(var1_1.skill - 25);
        }
        if (!this.drawMagicC(var2_2, var2_2, var3_4, this.getBXY(this.mini_state, var1_1.skill, true), this.getBXY(this.mini_state, var1_1.skill, false), this.mini_state ^ 1)) ** GOTO lbl-1000
        if (this.mini_state == 1) {
            var5_5 = var1_1.getMon().monsterPro;
            var5_5[1] = (short)(var5_5[1] - this.getSkillMana(var1_1.getMon(), var1_1.skill));
            this.valueMend(var1_1.getMon());
        }
        this.runHit();
        ** while (true)
    }

    private void drawBG0(int n, int n2, int n3, int n4, int n5) {
        Ui.i().fillRect(5422575, n2 - 1, 0, n5 + 13, 360 - 2);
        Ui.i().drawImage(this.imgBG[n], 320, 0, 17);
        Ui.i().drawK2(n2, n3, 640 - (n2 << 1), 360 - n3, 0);
        Ui.i().drawK1(n2 + 5, n3 + 25 + 7 + n4, n5, 360 - n3 - 36 - n4, 1);
        Ui.i().drawK(n2 + 7, 360 - 50 - 22, n5 - 4, 58, 3);
    }

    /*
     * Unable to fully structure code
     */
    private void drawBUY_ITEM() {
        block19: {
            block23: {
                block18: {
                    block20: {
                        block21: {
                            block17: {
                                block16: {
                                    block15: {
                                        block22: {
                                            Ui.i().fillRectB();
                                            Ui.i().drawK2(1, 2, 640 - 2, 360 - 2, 0);
                                            var2_1 = 0;
                                            if (this.cur_b != 0) break block22;
                                            Ui.i().drawK1(320 - 29, 6, 58, 28, 4);
                                            Ui.i().drawString(this.action_str[this.cur_a], 320, 5, 17, 0, 0);
lbl7:
                                            // 2 sources

                                            while (true) {
                                                Ui.i().drawK1(6, 37, 640 - 26, this.list_rows * 30 + 6, 1);
                                                Ui.i().drawK1(6, this.list_rows * 30 + 37 + 16, 640 - 12, 30 * 3, 2);
                                                if (this.cur_b != 1) break block15;
                                                var2_1 = this.itemsLength[this.cur_a];
lbl12:
                                                // 2 sources

                                                while (true) {
                                                    var4_4 = (byte)var2_1;
                                                    var5_5 = this.list_rows;
                                                    var7_3 = this.select[0];
                                                    var3_2 = this.cur_a;
                                                    if (this.cur_b != 1) break block16;
                                                    var2_1 = 2;
lbl19:
                                                    // 2 sources

                                                    while (true) {
                                                        this.drawItemList(10, 37 + 3, 640 - 26, var5_5, (byte[])var7_3, var3_2, var4_4, var2_1);
                                                        Ui.i().sliding(640 - 15, 37 + 5, this.list_rows * 30 - 6, (int)this.select[0][0], (int)var4_4, true);
                                                        var3_2 = var4_4;
                                                        if (var4_4 <= 0) ** GOTO lbl29
                                                        if (this.cur_b != 1) break block17;
                                                        var2_1 = this.items[this.cur_a][this.select[0][0]][0];
lbl26:
                                                        // 2 sources

                                                        while (this.item_help[var2_1].toString().contains("\u590d\u6d3b\u6b7b\u4ea1\u7684\u5ba0\u7269\u5e76\u4e3a\u5176\u56de\u590d\u751f\u547d\u503c\u7684")) {
                                                            this.showStringM("\u590d\u6d3b\u6b7b\u4ea1\u7684\u5ba0\u7269\u5e76\u4e3a\u5176\u56de\u590d\u751f\u547d\u503c\u768430%,\u8bf7\u52ff\u5728\u5ba0\u7269\u6218\u6597\u4e2d\u8d2d\u4e70!", 320, this.list_rows * 30 + 37 + 18, 10, 3);
                                                            var3_2 = var2_1;
lbl29:
                                                            // 3 sources

                                                            while (this.cur_b != 1 && this.cur_a == 2) {
                                                                var6_6 = true;
lbl31:
                                                                // 2 sources

                                                                while (true) {
                                                                    this.drawMoney(320, 360 - 2, 0, var6_6);
                                                                    if (this.popMenu == -1) ** GOTO lbl46
                                                                    if (this.buyOk != 1 || this.cur_b == 1 || this.buyItem[this.cur_a][this.select[0][0]] < 35 || this.makeLevel[this.buyItem[this.cur_a][this.select[0][0]] - 35] <= this.rmsOther[3]) break block18;
                                                                    Ui.i().drawKuang(-5, 180 - 50, 640 + 10, 108);
                                                                    this.showStringM("\u9700\u8981\u8bad\u7ec3\u5e08" + this.makeLevel[this.buyItem[this.cur_a][this.select[0][0]] - 35] + "\u7ea7\u624d\u80fd\u5b66\u4e60\uff01", 320, 180 - 25, 12, 9);
                                                                    this.showString("\u662f\u5426\u8d2d\u4e70\uff1f", 180 + 25, 0);
lbl38:
                                                                    // 2 sources

                                                                    while (true) {
                                                                        var2_1 = this.pkey.selectMenuX(2, 0, 0, 320, 360);
                                                                        if (var2_1 == -1) ** GOTO lbl46
                                                                        if (var2_1 != 0) break block19;
                                                                        var2_1 = -3;
lbl43:
                                                                        // 2 sources

                                                                        while (true) {
                                                                            Ms.key = var2_1;
                                                                            Ms.keyRepeat = true;
lbl46:
                                                                            // 3 sources

                                                                            Ui.i().drawYesNo(true, true);
                                                                            return;
                                                                        }
                                                                        break;
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                            break block20;
                                                        }
                                                        break block21;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                break;
                                            }
                                        }
                                        Ui.i().drawK1(this.cur_a * 210 + 70, 6, 70, 28, 4);
                                        block8: while (true) {
                                            if (var2_1 >= 3) {
                                                var1_8 = this.pkey.selectMenuX(3, 70, 0, 210, 62);
                                                if (var1_8 != -1) {
                                                    this.cur_a = var1_8;
                                                    var7_3 = this.select[0];
                                                    this.select[0][0] = 0;
                                                    var7_3[1] = false;
                                                }
                                                Ui.i().drawTriangle(320, 15, 329, true, true);
                                                ** continue;
                                            }
                                            var8_7 = Ui.i();
                                            var7_3 = this.action_str[var2_1];
                                            if (this.cur_a != var2_1) break;
                                            var3_2 = 0;
lbl66:
                                            // 2 sources

                                            while (true) {
                                                var8_7.drawString((String)var7_3, var2_1 * 210 + 80, 5, 0, var3_2, 0);
                                                var2_1 = (byte)(var2_1 + 1);
                                                continue block8;
                                                break;
                                            }
                                            break;
                                        }
                                        var3_2 = 4;
                                        ** while (true)
                                    }
                                    var2_1 = this.buyItem[this.cur_a].length;
                                    ** while (true)
                                }
                                var2_1 = 1;
                                ** while (true)
                            }
                            var2_1 = this.buyItem[this.cur_a][this.select[0][0]];
                            ** GOTO lbl26
                        }
                        this.showStringM(this.item_help[var2_1].toString(), 320, this.list_rows * 30 + 37 + 18, 10, 3);
                        var3_2 = var2_1;
                        ** GOTO lbl29
                    }
                    var6_6 = false;
                    ** while (true)
                }
                if (this.cur_b == 1) {
                    var2_1 = 1;
lbl91:
                    // 3 sources

                    while (true) {
                        this.drawBuy(var3_2, 320, 180, 150, 50, var2_1);
                        ** continue;
                        break;
                    }
                }
                if (this.cur_a != 2) break block23;
                var2_1 = 16;
                ** GOTO lbl91
            }
            var2_1 = 17;
            ** while (true)
        }
        var2_1 = -4;
        ** while (true)
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

    /*
     * Unable to fully structure code
     */
    private void drawBattleExp(Monster var1_1, int var2_2) {
        Ui.i().drawK0(200, var2_2, 240, 10, 0);
        if (this.battle_state != -5) {
            var3_3 = var1_1.monsterPro[4];
lbl4:
            // 2 sources

            while (true) {
                this.drawMonsterHp(var1_1, 240, var2_2 + 3, 195, 2, 2, var3_3);
                Ui.i().drawString("\u7ecf\u9a8c", 200, var2_2 + 18, 36, 0, 2);
                return;
            }
        }
        var3_3 = this.myB.cexp;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawBuffList(Monster var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, byte[] var7_7) {
        block4: {
            var8_8 = 0;
            Ui.i().drawListKY(var6_6, var2_2, var3_3, var4_4, 3, var5_5, 0, var7_7[0] - var7_7[1], 4, 2);
            block0: while (true) {
                if (var8_8 >= 2) {
                    return;
                }
                if (var8_8 <= 0 || var1_1.monster[var8_8 + 16] >= 1) break;
lbl7:
                // 3 sources

                while (true) {
                    var8_8 = (byte)(var8_8 + 1);
                    continue block0;
                    break;
                }
                break;
            }
            Ui.i().drawUi(49, var2_2 + 8, var3_3 + 8 + (var8_8 - this.select[0][1]) * var5_5, 0, 0);
            var11_11 = Ui.i();
            var10_10 = this.getNameBuff(var1_1.monster[var8_8 + 16]);
            var9_9 = this.select[0][1];
            if (var7_7[0] != var8_8) break block4;
            var6_6 = 0;
lbl16:
            // 2 sources

            while (true) {
                var11_11.drawString(var10_10, var2_2 + 21, var3_3 + 1 + (var8_8 - var9_9) * var5_5, 0, var6_6, 0);
                if (!this.pkey.isSelect(var2_2, var3_3 + 1 + (var8_8 - var7_7[1]) * var5_5, var4_4, var5_5)) ** GOTO lbl7
                var7_7[0] = var8_8;
                ** continue;
                break;
            }
        }
        var6_6 = 3;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void drawBuy(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6) {
        block10: {
            block9: {
                block8: {
                    block7: {
                        block11: {
                            Ui.i().drawKuang(var2_2 - var4_4, var3_3 - var5_5, var4_4 << 1, var5_5 << 1);
                            if ((var6_6 & 16) == 0) break block11;
                            var7_7 = 2;
lbl4:
                            // 2 sources

                            while (true) {
                                var5_5 = var3_3 - var5_5 + var7_7;
                                Ui.i().drawString("\u6570\u91cf\uff1a" + this.popMenu + "/" + this.t_length, var2_2, var5_5, 17, 3, 0);
                                var9_8 /* !! */  = new StringBuffer();
                                if ((var6_6 & 16) == 0) break block7;
                                var9_8 /* !! */ .append("\u9700\u8981\uff1a");
lbl11:
                                // 2 sources

                                while (true) {
                                    var9_8 /* !! */ .append(this.sell_money * this.popMenu);
                                    if ((var6_6 & 1) == 0) break block8;
                                    var9_8 /* !! */ .append("\u91d1");
lbl17:
                                    // 2 sources

                                    while (true) {
                                        Ui.i().drawString(var9_8 /* !! */ .toString(), var2_2, var5_5 + 25 + 4, 17, 6, 0);
                                        if ((var6_6 & 16) != 0) {
                                            Ui.i().drawString("\u73b0\u6709\uff1a" + this.findItem(-2, var1_1, true), var2_2, var5_5 + 58, 17, 3, 0);
                                        }
                                        var9_8 /* !! */  = Ui.i();
                                        if (this.cur_b == 2) break block9;
                                        var8_9 = true;
lbl24:
                                        // 2 sources

                                        while (true) {
                                            var9_8 /* !! */ .drawTriangle1(var2_2, var3_3 - 2, var4_4, true, var8_9);
                                            if (this.buyOk != 1) ** GOTO lbl32
                                            var10_10 = new StringBuilder("\u662f\u5426");
                                            if ((var6_6 & 16) == 0) break block10;
                                            var9_8 /* !! */  = "\u8d2d\u4e70";
lbl30:
                                            // 2 sources

                                            while (true) {
                                                this.showString(var10_10.append((String)var9_8 /* !! */ ).append("\uff1f").toString(), Constants_H.HEIGHT_H + 25, 0);
lbl32:
                                                // 2 sources

                                                return;
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        var7_7 = 12;
                        ** while (true)
                    }
                    var9_8 /* !! */ .append("\u83b7\u5f97\uff1a");
                    ** while (true)
                }
                var9_8 /* !! */ .append("\u5fbd\u7ae0");
                ** while (true)
            }
            var8_9 = false;
            ** while (true)
        }
        var9_8 /* !! */  = "\u5356\u51fa";
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawClipPic(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7, int var8_8, int var9_9) {
        block5: {
            var11_10 = 1;
            var10_11 = (byte)(var5_5 / var7_7);
            var5_5 = (short)(2 << var8_8);
            var8_8 = var11_10;
            block0: while (true) {
                if (var8_8 >= var7_7) {
                    return;
                }
                var12_12 = GameRun.g;
                if (var10_11 - var5_5 > 0) break;
                var11_10 = var10_11;
lbl11:
                // 2 sources

                while (true) {
                    var12_12.clipRect(var3_3 - var8_8 * var10_11, var4_4 - var6_6, var11_10, var6_6 + 20);
                    this.drawCartoonOne(var2_2, var2_2, var1_1 * 3, var3_3, var4_4, true, var9_9);
                    GameRun.g.setClip(0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
                    var12_12 = GameRun.g;
                    if (var10_11 - var5_5 <= 0) {
                        var11_10 = var10_11;
lbl19:
                        // 2 sources

                        while (true) {
                            var12_12.clipRect((var8_8 - 1) * var10_11 + var3_3, var4_4 - var6_6, var11_10, var6_6 + 20);
                            this.drawCartoonOne(var2_2, var2_2, var1_1 * 3, var3_3, var4_4, true, var9_9);
                            GameRun.g.setClip(0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
                            var8_8 = (byte)(var8_8 + 1);
                            var5_5 = (short)(var5_5 / 2);
                            continue block0;
                            break;
                        }
                    }
                    break block5;
                    break;
                }
                break;
            }
            var11_10 = var5_5;
            ** while (true)
        }
        var11_10 = var5_5;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawColorLine(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7, int var8_8, int var9_9, int var10_10) {
        if ((-16777216 & var9_9) != 0) {
            GameRun.g.setColor(var9_9);
            GameRun.g.fillRect(var1_1, var2_2, var3_3, var4_4);
        }
        GameRun.g.setColor(var10_10);
        var9_9 = 1;
        var10_10 = 1;
        if (var8_8 == 1) {
            var9_9 = var6_6;
            var6_6 = var2_2;
            var8_8 = var10_10;
            while (true) {
                if (var6_6 >= var2_2 + var4_4) lbl-1000:
                // 3 sources

                {
                    return;
                }
                GameRun.g.fillRect(var1_1, var6_6, var3_3, var5_5);
                var10_10 = var6_6 + var5_5 + var8_8;
                var11_11 = var5_5 - var7_7;
                var6_6 = var10_10;
                var5_5 = var11_11;
                if (var11_11 > 0) continue;
                var5_5 = var8_8;
                if (var8_8 < --var9_9) {
                    var5_5 = var8_8 + 1;
                }
                var11_11 = 1;
                var8_8 = var5_5;
                var6_6 = var10_10;
                var5_5 = var11_11;
            }
        }
        if (var8_8 != 2) ** GOTO lbl-1000
        var4_4 = var2_2 + var4_4;
        var8_8 = var6_6;
        var6_6 = var9_9;
        while (true) {
            if (var4_4 > var2_2) ** break;
            ** continue;
            GameRun.g.fillRect(var1_1, var4_4 - var5_5, var3_3, var5_5);
            var9_9 = var4_4 - var5_5 - var6_6;
            var10_10 = var5_5 - var7_7;
            var4_4 = var9_9;
            var5_5 = var10_10;
            if (var10_10 > 0) continue;
            var4_4 = var6_6;
            if (var6_6 < --var8_8) {
                var4_4 = var6_6 + 1;
            }
            var5_5 = 1;
            var6_6 = var4_4;
            var4_4 = var9_9;
        }
    }

    private void drawDarkScreen() {
        this.drawColorLine(0, 0, 640, 360, this.b_c + 1, 6, 1, 2, 0xFFFFFF, 0x494949);
    }

    private void drawEffectImage(Monster object, int n, int n2) {
        if (object.effect > -1 && object.effect < 7 && object.effect_time > 0) {
            Ui ui = Ui.i();
            Image image = this.effectImage[object.effect];
            Graphics graphics = g;
            graphics = g;
            ui.drawImage(image, n, n2, 8 | 0x20);
            image = Ui.i();
            object = "" + object.effect_time;
            ui = g;
            ui = g;
            image.drawNum((String)object, n, n2, 8 | 0x20, 0);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void drawEnemy() {
        block9: {
            block8: {
                block10: {
                    block12: {
                        block11: {
                            this.drawEffectImage(this.enB.getMon(), 435, 40);
                            if (this.enB.getMon().monsterPro[0] < 1 && this.enB.dead == 1) lbl-1000:
                            // 2 sources

                            {
                                return;
                            }
                            var4_1 = this.mList_id[this.enB.getMon().monster[0]][1];
                            var3_2 = this.enB.action;
                            if (this.enB.ceff[0] == 0) break block11;
                            var1_3 = 3;
lbl9:
                            // 2 sources

                            while (this.enB.ceff[0] != 0) {
                                var2_4 = -3;
lbl11:
                                // 2 sources

                                while (this.enB.action == 0) {
                                    var5_5 = true;
lbl13:
                                    // 2 sources

                                    while (true) {
                                        if (this.drawCartoonOne(0, 0, var4_1 * 3 + var3_2, var1_3 + 377, var2_4 + 97, var5_5, 0)) {
                                            if (this.enB.getMon().monsterPro[0] >= 1) break block8;
                                            this.enB.action = (byte)2;
                                            this.enB.dead = 1;
                                        }
lbl18:
                                        // 5 sources

                                        while (true) {
                                            this.enB.ceff[0] = (byte)Ms.i().mathSpeedN((int)this.enB.ceff[0], 0, 1, true);
                                            this.drawMonsterHp(this.enB.getMon(), 352, 97, 50, 0, 1, this.enB.chp);
                                            var7_6 = this.enB;
                                            var6_7 = Ms.i();
                                            var3_2 = this.enB.chp;
                                            var2_4 = this.enB.getMon().monsterPro[0];
                                            if (this.enB.chp >= this.enB.getMon().monsterPro[0]) break block9;
                                            var1_3 = 20;
lbl27:
                                            // 2 sources

                                            while (true) {
                                                var7_6.chp = var6_7.mathSpeedN((int)var3_2, var2_4, var1_3, true);
                                                ** continue;
                                                break;
                                            }
                                            break;
                                        }
                                        break;
                                    }
lbl30:
                                    // 1 sources

                                    ** GOTO lbl-1000
                                }
                                break block10;
                            }
                            break block12;
                        }
                        var1_3 = 0;
                        ** GOTO lbl9
                    }
                    var2_4 = 0;
                    ** GOTO lbl11
                }
                var5_5 = false;
                ** while (true)
            }
            if (this.enB.dead == 1) ** GOTO lbl18
            this.enB.action = 0;
            ** while (true)
        }
        var1_3 = 6;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
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
        var3_1 = Ui.i();
        if (this.monInfoList[this.enB.getMon().monster[0]] == 2) {
            var2_2 = "\u5df2\u6355\u83b7";
lbl15:
            // 2 sources

            while (true) {
                var3_1.drawString(var2_2, 10 + 2, 25 + 50 + 32, 20, 4, 2);
                var2_2 = Ui.i();
                if (this.monInfoList[this.enB.getMon().monster[0]] == 2) {
                    var1_3 = 25;
lbl20:
                    // 2 sources

                    while (true) {
                        var2_2.drawUi(var1_3, 10 + 100 + 4, 25 + 50 + 40, 0, 0);
                        return;
                    }
                }
                break;
            }
        } else {
            var2_2 = "\u672a\u6355\u83b7";
            ** continue;
        }
        var1_3 = 26;
        ** while (true)
    }

    private void drawEvolveMake(int n, int n2, int n3, int n4) {
        byte by;
        byte by2;
        int n5 = 2;
        int n6 = 0;
        do {
            Ui.i().drawString(String.valueOf(this.getNameItem(this.monsterMake[n][n5])) + "\uff08" + this.findItem(-2, this.monsterMake[n][n5], true) + "/" + this.monsterMake[n][n5 + 1] + "\uff09", n2, n3 + n6 * n4, 0, 3, 0);
            by2 = (byte)(n5 + 2);
            by = (byte)(n6 + 1);
            n5 = by2;
            n6 = by;
        } while (by2 < this.monsterMake[n].length - 1);
        if (this.monsterMake[n][0] > 0 && (n = (int)this.findItem(-2, 34, true)) > 0) {
            Ui.i().drawString(String.valueOf(this.getNameItem(34)) + "\uff08" + n + "/" + 1 + "\uff09", n2, n3 + by * n4, 0, -1, 0);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private boolean drawHitOne(Battle var1_1, Battle var2_2, int var3_3, int var4_4) {
        block23: {
            block14: {
                block21: {
                    block22: {
                        block15: {
                            block13: {
                                block20: {
                                    block17: {
                                        block12: {
                                            block19: {
                                                block18: {
                                                    block16: {
                                                        var10_5 = true;
                                                        this.strHit = "";
                                                        var6_6 = 0;
                                                        block0: while (true) {
                                                            if (var6_6 >= var1_1.hit.length) {
                                                                this.valueMend(var1_1.getMon());
                                                                return var10_5;
                                                            }
                                                            if (var1_1.hit[var6_6][4] < this.zb.length) break;
lbl9:
                                                            // 6 sources

                                                            while (true) {
                                                                var6_6 = (byte)(var6_6 + 1);
                                                                continue block0;
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                        var11_11 = false;
                                                        if (var1_1.hit[var6_6][0] != -1) break block16;
                                                        this.strHit = "\u95ea\u907f";
lbl15:
                                                        // 3 sources

                                                        while (var1_1.hit[var6_6][0] > 0 && var1_1.hit[var6_6][0] < 4) {
                                                            if (var1_1.hit[var6_6][0] == 2) {
                                                                Ui.i().drawUi(32, var1_1.hit[var6_6][2] + var3_3 + (this.strHit.length() >> 1) * 14 + 15, var1_1.hit[var6_6][3] + var4_4 + 8, 40, 0);
                                                                Ui.i().drawUi(33, var1_1.hit[var6_6][2] + var3_3 + (this.strHit.length() >> 1) * 14 + 15, var1_1.hit[var6_6][3] + var4_4 + 8, 36, 0);
                                                            }
                                                            var13_13 = Ui.i();
                                                            var12_12 = this.strHit;
                                                            var9_10 = var1_1.hit[var6_6][2];
                                                            var8_9 /* !! */  = var1_1.hit[var6_6][3];
                                                            if (var1_1.hit[var6_6][0] != 2) break block12;
                                                            var7_8 = 2;
lbl25:
                                                            // 2 sources

                                                            while (true) {
                                                                var13_13.drawNum((String)var12_12, var9_10 + var3_3, var8_9 /* !! */  + var4_4, 0, var7_8);
lbl27:
                                                                // 3 sources

                                                                while (var6_6 == 0) {
                                                                    var12_12 = var1_1.hit[var6_6];
                                                                    var8_9 /* !! */  = (short)var12_12[2];
                                                                    if (this.mini_state != 1) break block13;
                                                                    var7_8 = 1;
lbl32:
                                                                    // 2 sources

                                                                    while (true) {
                                                                        var12_12[2] = (short)(var8_9 /* !! */  + var7_8);
                                                                        var12_12 = var1_1.hit[var6_6];
                                                                        var12_12[3] = (short)(var12_12[3] + this.zb[var1_1.hit[var6_6][4]]);
lbl36:
                                                                        // 4 sources

                                                                        while (true) {
                                                                            var12_12 = var1_1.hit[var6_6];
                                                                            var5_7 = (short)(var12_12[4] + true);
                                                                            var12_12[4] = var5_7;
                                                                            var10_5 = var11_11;
                                                                            if (var5_7 != 1) ** GOTO lbl9
                                                                            if (var1_1.hit[var6_6][0] != 4) break block14;
                                                                            var12_12 = var1_1.getMon().monsterPro;
                                                                            var12_12[1] = (short)(var12_12[1] - var1_1.hit[var6_6][1]);
                                                                            var10_5 = var11_11;
                                                                            ** GOTO lbl9
                                                                            break;
                                                                        }
                                                                        break;
                                                                    }
                                                                }
                                                                break block15;
                                                                break;
                                                            }
                                                        }
                                                        break block17;
                                                    }
                                                    if (var1_1.hit[var6_6][0] != -2) break block18;
                                                    this.strHit = "\u5fe0\u8bda\u5ea6\u51cf\u5c11";
                                                    ** GOTO lbl15
                                                }
                                                if (var1_1.hit[var6_6][1] <= -1) break block19;
                                                var12_12 = "-";
lbl56:
                                                // 2 sources

                                                while (true) {
                                                    var12_12 = new StringBuilder(String.valueOf(var12_12));
                                                    Ms.i();
                                                    this.strHit = var12_12.append(Ms.abs((int)var1_1.hit[var6_6][1])).toString();
                                                    ** GOTO lbl15
                                                    break;
                                                }
                                            }
                                            var12_12 = "+";
                                            ** while (true)
                                        }
                                        var7_8 = 1;
                                        ** while (true)
                                    }
                                    if (var1_1.hit[var6_6][0] >= 0 && var1_1.hit[var6_6][0] != 4) ** GOTO lbl27
                                    var13_13 = Ui.i();
                                    var12_12 = this.strHit;
                                    var8_9 /* !! */  = var1_1.hit[var6_6][2];
                                    var9_10 = var1_1.hit[var6_6][3];
                                    if (var1_1.hit[var6_6][0] != 4) break block20;
                                    var7_8 = 1;
lbl76:
                                    // 2 sources

                                    while (true) {
                                        var13_13.drawString((String)var12_12, var8_9 /* !! */  + var3_3, var9_10 + var4_4, 0, var7_8, 2);
                                        ** GOTO lbl27
                                        break;
                                    }
                                }
                                var7_8 = 0;
                                ** while (true)
                            }
                            var7_8 = -1;
                            ** while (true)
                        }
                        if (var6_6 != 1) break block21;
                        var12_12 = var1_1.hit[var6_6];
                        var8_9 /* !! */  = (short)var12_12[2];
                        if (this.mini_state != 1) break block22;
                        var7_8 = 1;
lbl91:
                        // 2 sources

                        while (true) {
                            var12_12[2] = (short)(var8_9 /* !! */  + var7_8);
                            var12_12 = var1_1.hit[var6_6];
                            var12_12[3] = (short)(var12_12[3] + this.zb[var1_1.hit[var6_6][4]]);
                            ** GOTO lbl36
                            break;
                        }
                    }
                    var7_8 = -1;
                    ** while (true)
                }
                if (var6_6 != 2) ** GOTO lbl36
                var12_12 = var1_1.hit[var6_6];
                var12_12[3] = (short)(var12_12[3] - var1_1.hit[var6_6][4] / 3);
                ** while (true)
            }
            if (var1_1.hit[var6_6][0] != -2 || this.mini_state != 0 || var1_1.getMon().isMonReel(40)) break block23;
            var12_12 = var1_1.getMon().monster;
            var12_12[6] = (byte)(var12_12[6] - var1_1.hit[var6_6][1]);
            this.getHitCoefficient(var1_1, var1_1.getMon(), var2_2.getMon());
            var10_5 = var11_11;
            ** GOTO lbl9
        }
        var10_5 = var11_11;
        if (var1_1.hit[var6_6][0] <= 0) ** GOTO lbl9
        var12_12 = var1_1.getMon().monsterPro;
        var12_12[0] = (short)(var12_12[0] - var1_1.hit[var6_6][1]);
        var10_5 = var11_11;
        ** while (true)
    }

    private void drawInfoBG(int n, int n2) {
        Ui.i().fillRect(0, 0, 0, 640, n2);
        g.fillRect(0, 360 - n2, 640, n2);
        g.fillRect(0, n2 - 2, 640, n2);
        Ui.i().fillRect(15400191, 0, 2, 640, n2 - 4);
        g.fillRect(0, 360 - n2 + 2, 640, n2 - 4);
        g.fillRect(0, n2, 640, n2 - 4);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void drawInfoList(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, byte[] var7_7) {
        block14: {
            block12: {
                block11: {
                    block10: {
                        block13: {
                            block9: {
                                Ui.i().drawListKY(var5_5, var1_1 - 4, var2_2 + 5, var3_3, 4, var4_4 + 4, 2, var7_7[0] - var7_7[1], 4, 2);
                                var8_8 = var7_7[1];
                                block0: while (true) {
                                    if (var8_8 >= var7_7[1] + var5_5 || var8_8 >= var6_6) {
                                        Ui.i().sliding(var1_1 + var3_3 + 5, var2_2 + 10, (var4_4 + 4 + 2) * var5_5 - 4, (int)var7_7[0], var6_6, false);
                                        return;
                                    }
                                    var12_12 /* !! */  = Ui.i();
                                    if (this.monInfoList[this.monInfo_dir[this.cur_a][var8_8]] != 2) break;
                                    var9_9 = 25;
lbl10:
                                    // 2 sources

                                    while (true) {
                                        var10_10 = var7_7[1];
                                        var13_13 /* !! */  = GameRun.g;
                                        var13_13 /* !! */  = GameRun.g;
                                        var12_12 /* !! */ .drawUi(var9_9, var1_1 - 10, (var8_8 - var10_10) * (var4_4 + 4 + 2) + var2_2 + 11, 8 | 16, 0);
                                        if (var7_7[0] != var8_8) break block9;
                                        var9_9 = 0;
lbl17:
                                        // 3 sources

                                        while (true) {
                                            var9_9 = (byte)var9_9;
                                            var13_13 /* !! */  = Ui.i();
                                            if (this.infoStart + var8_8 + 1 >= 10) break block10;
                                            var12_12 /* !! */  = "0";
lbl22:
                                            // 2 sources

                                            while (true) {
                                                var14_14 = new StringBuilder(String.valueOf(var12_12 /* !! */ )).append(this.infoStart + var8_8 + 1).append(" ");
                                                if (this.monInfoList[this.monInfo_dir[this.cur_a][var8_8]] == 0) break block11;
                                                var12_12 /* !! */  = this.getNameMon(this.monInfo_dir[this.cur_a][var8_8]);
lbl26:
                                                // 2 sources

                                                while (true) {
                                                    var13_13 /* !! */ .drawString(var14_14.append((String)var12_12 /* !! */ ).toString(), var1_1 + 10, (var8_8 - var7_7[1]) * (var4_4 + 4 + 2) + var2_2 + 5, 0, var9_9, 0);
                                                    var12_12 /* !! */  = Ui.i();
                                                    var13_13 /* !! */  = this.getInfoType(this.monAppearMap[this.monInfo_dir[this.cur_a][var8_8]][0]);
                                                    var11_11 = Constants_H.WIDTH;
                                                    var10_10 = var7_7[1];
                                                    var14_14 = GameRun.g;
                                                    var14_14 = GameRun.g;
                                                    var12_12 /* !! */ .drawString((String)var13_13 /* !! */ , var11_11 - 25 - 15, (var8_8 - var10_10) * (var4_4 + 4 + 2) + var2_2 + 5, 8 | 16, var9_9, 0);
                                                    if (this.pkey.isSelect(var1_1, (var8_8 - var7_7[1]) * (var4_4 + 4 + 2) + var2_2 + 5, var3_3, var4_4 + 4 + 2)) {
                                                        if (var7_7[0] != var8_8) break block12;
                                                        this.pkey.setKey5();
                                                    }
lbl38:
                                                    // 6 sources

                                                    while (true) {
                                                        var8_8 = (byte)(var8_8 + 1);
                                                        continue block0;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                break;
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                                var9_9 = 48;
                                ** while (true)
                            }
                            if (this.monInfoList[this.monInfo_dir[this.cur_a][var8_8]] == 0) break block13;
                            var9_9 = 3;
                            ** GOTO lbl17
                        }
                        var9_9 = -1;
                        ** while (true)
                    }
                    var12_12 /* !! */  = "";
                    ** while (true)
                }
                var12_12 /* !! */  = "\u672a\u77e5\u5ba0\u7269";
                ** while (true)
            }
            var7_7[0] = var8_8;
            if (var8_8 - var7_7[1] != 0 || var7_7[1] <= 0) break block14;
            var7_7[1] = (byte)(var7_7[1] - 1);
            ** GOTO lbl38
        }
        if (var8_8 - var7_7[1] != var5_5 - 1 || var7_7[1] + var5_5 >= var6_6) ** GOTO lbl38
        var7_7[1] = (byte)(var7_7[1] + 1);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void drawItemList(int var1_1, int var2_2, int var3_3, int var4_4, byte[] var5_5, int var6_6, int var7_7, int var8_8) {
        block20: {
            block17: {
                block19: {
                    block18: {
                        var9_9 = var5_5[1];
                        Ui.i().drawListKY(var4_4, var1_1 - 4, var2_2, var3_3, 4, 30 + 1, -1, var5_5[0] - var5_5[1], 4, 2);
                        block0: while (true) {
                            if (var9_9 >= var5_5[1] + var4_4) {
                                return;
                            }
                            if (var9_9 >= var7_7) ** GOTO lbl31
                            if (var8_8 != 0 && var8_8 != 2) break block17;
                            this.drawItem(this.items[var6_6][var9_9][0], var1_1 + 3, var2_2 + 4 + (var9_9 - var5_5[1]) * 30, 0);
                            var12_12 /* !! */  = Ui.i();
                            var13_13 = this.getNameItem(this.items[var6_6][var9_9][0]);
                            var11_11 = var5_5[1];
                            if (var5_5[0] != var9_9) break;
                            var10_10 = 0;
lbl14:
                            // 2 sources

                            while (true) {
                                var12_12 /* !! */ .drawString(var13_13, var1_1 + 21, var2_2 + 1 + (var9_9 - var11_11) * 30, 0, var10_10, 0);
                                if (var8_8 != 2) break block18;
                                var12_12 /* !! */  = this.getPrice(var6_6, this.items[var6_6][var9_9][0], false) + "\u91d1";
lbl18:
                                // 2 sources

                                while (true) {
                                    var13_13 = Ui.i();
                                    var11_11 = var5_5[1];
                                    var14_14 = GameRun.g;
                                    var14_14 = GameRun.g;
                                    if (var5_5[0] != var9_9) break block19;
                                    var10_10 = 0;
lbl25:
                                    // 2 sources

                                    while (true) {
                                        var13_13.drawString((String)var12_12 /* !! */ , var1_1 + var3_3 - 12, var2_2 + 1 + (var9_9 - var11_11) * 30, 8 | 16, var10_10, 0);
lbl27:
                                        // 2 sources

                                        while (true) {
                                            if (this.popMenu == -1 && this.say_c == 0 && this.pkey.isSelect(var1_1, (var9_9 - var5_5[1]) * 30 + var2_2, Constants_H.WIDTH, 30)) {
                                                if (var5_5[0] != var9_9) break block20;
                                                this.pkey.setKey5();
                                            }
lbl31:
                                            // 5 sources

                                            while (true) {
                                                var9_9 = (byte)(var9_9 + 1);
                                                continue block0;
                                                break;
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        var10_10 = 3;
                        ** while (true)
                    }
                    var12_12 /* !! */  = "x" + this.items[var6_6][var9_9][1];
                    ** while (true)
                }
                var10_10 = 3;
                ** while (true)
            }
            this.drawItem(this.buyItem[var6_6][var9_9], var1_1 + 2, var2_2 + 4 + (var9_9 - var5_5[1]) * 30, 0);
            if (var5_5[0] == var9_9) {
                var10_10 = 0;
lbl46:
                // 2 sources

                while (true) {
                    var11_11 = (byte)var10_10;
                    Ui.i().drawString(this.getNameItem(this.buyItem[var6_6][var9_9]), var1_1 + 20, var2_2 + (var9_9 - var5_5[1]) * 30, 0, (int)var11_11, 0);
                    if (var6_6 == 2) {
                        var12_12 /* !! */  = "\u5fbd\u7ae0";
lbl51:
                        // 2 sources

                        while (true) {
                            var13_13 = Ui.i();
                            var12_12 /* !! */  = String.valueOf(this.getPrice(var6_6, var9_9, true)) + (String)var12_12 /* !! */ ;
                            var10_10 = var5_5[1];
                            var14_14 = GameRun.g;
                            var14_14 = GameRun.g;
                            var13_13.drawString((String)var12_12 /* !! */ , var1_1 + var3_3 - 12, (var9_9 - var10_10) * 30 + (var2_2 + 1), 8 | 16, (int)var11_11, 0);
                            ** continue;
                            break;
                        }
                    }
                    break;
                }
            } else {
                var10_10 = 3;
                ** continue;
            }
            var12_12 /* !! */  = "\u91d1";
            ** while (true)
        }
        var5_5[0] = var9_9;
        if (var9_9 - var5_5[1] == 0 && var5_5[1] > 0) {
            var5_5[1] = (byte)(var5_5[1] - 1);
lbl68:
            // 3 sources

            while (true) {
                this.select_it[this.selectx] = var5_5[0];
                this.select_st[this.selectx] = var5_5[1];
                ** continue;
                break;
            }
        }
        if (var9_9 - var5_5[1] != var4_4 - 1 || var5_5[1] + var4_4 >= var7_7) ** GOTO lbl68
        var5_5[1] = (byte)(var5_5[1] + 1);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void drawLIST_INFO() {
        block7: {
            Ui.i().fillRectB();
            this.drawInfoBG(24, 35);
            var6_1 /* !! */  = Ui.i();
            var7_2 = "\u53d1\u73b0\u5ea6 " + Ms.i().getPrecision(this.monInfoList[102] * 1000 / 102) + "%";
            var8_3 = GameRun.g;
            var8_3 = GameRun.g;
            var6_1 /* !! */ .drawString(var7_2, 640 - 12, 34, 8 | 16, 3, 1);
            Ui.i().drawString(this.monsterT[this.cur_a].toString(), 28, 34, 0, 1, 2);
            var6_1 /* !! */  = Ui.i();
            var7_2 = "\u6355\u6349\u79cd\u7c7b " + this.monInfoList[103] + "/" + 100;
            var8_3 = GameRun.g;
            var8_3 = GameRun.g;
            var6_1 /* !! */ .drawString(var7_2, 320, 360 + 1, 1 | 32, 3, 1);
            var1_4 = this.pkey.selectMenuX(5, 100, 0, 640 / 6, 35);
            if (var1_4 == -1) ** GOTO lbl26
            this.cur_a = var1_4;
            this.infoStart = 0;
            if (this.cur_a <= 0) ** GOTO lbl22
            var2_5 = 0;
            block0: while (true) {
                block8: {
                    if (var2_5 < this.cur_a) break block8;
lbl22:
                    // 2 sources

                    this.t_length = (byte)this.monInfo_dir[this.cur_a].length;
                    var6_1 /* !! */  = (Ui)this.select[0];
                    this.select[0][1] = 0;
                    var6_1 /* !! */ [0] = (Ui)false;
lbl26:
                    // 2 sources

                    var2_5 = 0;
lbl27:
                    // 2 sources

                    while (true) {
                        if (var2_5 < 5) break block0;
                        this.drawInfoList(32, 67, 640 - 50, 29, this.list_rows, this.t_length, this.select[0]);
                        Ui.i().drawTriangle(320 + 10, 12, 331, true, true);
                        var6_1 /* !! */  = Ui.i();
                        if (this.monInfoList[this.getMonInfo_dir()] != 0) {
                            var5_8 = true;
lbl34:
                            // 2 sources

                            while (true) {
                                var6_1 /* !! */ .drawYesNo(var5_8, true);
                                return;
                            }
                        }
                        break block7;
                        break;
                    }
                }
                this.infoStart = (byte)(this.infoStart + this.monInfo_dir[var2_5].length);
                var2_5 = (byte)(var2_5 + 1);
            }
            var6_1 /* !! */  = Ui.i();
            if (this.cur_a == var2_5) {
                var3_6 = 5;
lbl45:
                // 2 sources

                while (true) {
                    var4_7 = (var2_5 + 1) * 614 / 6;
                    var7_2 = GameRun.g;
                    var7_2 = GameRun.g;
                    var6_1 /* !! */ .drawUi(var3_6 + var2_5, var4_7 + 18, 12, 4 | 2, 0);
                    var2_5 = (byte)(var2_5 + 1);
                    ** continue;
                    break;
                }
            }
            var3_6 = 0;
            ** while (true)
        }
        var5_8 = false;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawMONSTER_INFO(int var1_1) {
        block14: {
            block12: {
                block13: {
                    block11: {
                        var3_2 = 320 - 140;
                        var4_3 = var3_2 + 12;
                        Ui.i().fillRectB();
                        Ui.i().drawK2(var3_2, 2, 280, 360 - 2, 0);
                        Ui.i().drawK1(320 - 29 * 4 - 4, 6, 29 * 8, 29, 4);
                        Ui.i().drawK1(var4_3, 35, 100, 90, 1);
                        Ui.i().drawK1(29 + 192 + 8, 35 + 90 + 4, 280 - (29 + 25), 29 * 4, 1);
                        Ui.i().drawK1(var4_3, 35 + 90 + 4, 29, 29 * 4, 3);
                        Ui.i().drawK1(var4_3, 360 - 13 - 29 * 3, 640 - (var4_3 << 1) + 2, 29 * 3 + 10, 2);
                        Ui.i().drawYesNo(false, true);
                        Ui.i().drawUi(this.cur_a + 5, var4_3 + 2, 35 + 2, 0, 0);
                        Log.e((String)"sk", (String)"drawUi");
                        var9_4 = Ui.i();
                        var8_5 = new StringBuilder(String.valueOf(this.getNameMon(var1_1))).append("\uff08");
                        if (this.monInfoList[var1_1] == 2) {
                            var7_6 = "\u5df2\u6355\u83b7";
lbl18:
                            // 2 sources

                            while (true) {
                                var9_4.drawString(var8_5.append(var7_6).append("\uff09").toString(), 320, 6, 17, 0, 0);
                                var5_7 = this.mList_id[var1_1][1];
                                var3_2 = this.mon_action;
                                if (this.mon_action != 1) break block11;
                                var6_8 = false;
lbl24:
                                // 2 sources

                                while (true) {
                                    if (this.drawCartoonOne(1, 1, var5_7 * 3 + var3_2, var4_3 + 50, 35 + 90 - 10, var6_8, 0)) {
                                        this.mon_action = 0;
                                    }
                                    Ui.i().drawString("\u53d1\u73b0\u5730\u70b9", 100 + 192 + 5, 35, 0, 1, 1);
                                    if (this.monAppearMap[var1_1][0] <= -1) break block12;
                                    var3_2 = 0;
lbl30:
                                    // 2 sources

                                    while (true) {
                                        if (var3_2 < this.monAppearMap[var1_1].length) break block13;
lbl32:
                                        // 2 sources

                                        while (true) {
                                            Ui.i().drawString("\u8fdb", var4_3 + 12 + 2, 35 + 90 + 20, 17, 3, 1);
                                            Ui.i().drawString("\u5316", var4_3 + 12 + 2, 29 + 153, 17, 3, 1);
                                            Ui.i().drawListKY(3, 29 + 192 + 8, 35 + 90 + 10, 280 - (29 + 25), 3, 29 + 4, 0, -1, 4, 2);
                                            var4_3 = 2;
                                            var3_2 = 0;
lbl38:
                                            // 2 sources

                                            while (true) {
                                                if (var4_3 >= 7) {
                                                    this.showStringM(this.getNameMonsterInfo(var1_1), 320, 360 - 12 - 29 * 3, 10, 3);
                                                    this.mon_action_c = var2_9 = (byte)(this.mon_action_c + 1);
                                                    if (var2_9 > 50) {
                                                        this.mon_action_c = 0;
                                                        this.mon_action = 1;
                                                    }
                                                    return;
                                                }
                                                break block14;
                                                break;
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        var7_6 = "\u672a\u6355\u83b7";
                        ** while (true)
                    }
                    var6_8 = true;
                    ** while (true)
                }
                Ui.i().drawString(this.city_name[this.monAppearMap[var1_1][var3_2]].toString(), 100 + 192 + 5, 35 + (var3_2 + 1) * 25, 0, 1, 0);
                var3_2 = (byte)(var3_2 + 1);
                ** while (true)
            }
            Ui.i().drawString("\u672a\u77e5", 100 + 192 + 5, 35 + 25, 0, 1, 0);
            ** while (true)
        }
        var8_5 = Ui.i();
        var9_4 = new StringBuilder("\u6750\u6599\uff1a");
        if (this.monsterMake[var1_1].length == 0 || var4_3 >= this.monsterMake[var1_1].length) {
            var7_6 = "";
lbl64:
            // 2 sources

            while (true) {
                var8_5.drawString(var9_4.append(var7_6).toString(), 29 + 192 + 14, var3_2 * 33 + 137, 0, 3, 0);
                var4_3 = (byte)(var4_3 + 2);
                var3_2 = (byte)(var3_2 + 1);
                ** continue;
                break;
            }
        }
        var7_6 = String.valueOf(this.getNameItem(this.monsterMake[var1_1][var4_3])) + " x" + this.monsterMake[var1_1][var4_3 + 1];
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawMONSTER_UI(Monster[] var1_1) {
        block14: {
            block13: {
                block12: {
                    block15: {
                        var2_2 = 320 - 140;
                        Ui.i().fillRectB();
                        Ui.i().drawK2(var2_2, 2, 280, 360 - 2, 0);
                        Ui.i().drawK1(var2_2 += 6, 5 + 6, 118, 116, 1);
                        if (this.t_length == 0) ** GOTO lbl16
                        this.drawMonsterHp(var1_1[this.select[0][0]], var2_2 + 30, 5, 74, 2, 2, var1_1[this.select[0][0]].monsterPro[4]);
                        Ui.i().drawNum(String.valueOf(var1_1[this.select[0][0]].monster[2]) + "\u7ea7", var2_2 + 2, 5 + 10, 0, 0);
                        Ui.i().drawUi(var1_1[this.select[0][0]].monster[3] + 5, var2_2 + 9, 5 + 11, 17, 0);
                        var4_3 = this.mList_id[var1_1[this.select[0][0]].monster[0]][1];
                        var3_4 = this.mon_action;
                        if (this.mon_action != 1) break block15;
                        var5_5 = false;
lbl13:
                        // 2 sources

                        while (true) {
                            if (this.drawCartoonOne(1, 1, var4_3 * 3 + var3_4, 248, 111, var5_5, 0)) {
                                this.mon_action = 0;
                            }
lbl16:
                            // 4 sources

                            var3_4 = 5 + 138;
                            var4_3 = (short)(640 - (var2_2 << 1));
                            Ui.i().drawK1(var2_2, var3_4, (int)var4_3, 360 - 116 - 32, 1);
                            Ui.i().drawK(var2_2 + 8, var3_4 + 10, var4_3 - 16, 33, 3);
                            Ui.i().drawK(var2_2 + 8, var3_4 + 150 + 11, var4_3 - 16, 33, 3);
                            if (this.t_length != 0) {
                                this.gogoWord(this.getNameMonsterInfo(var1_1[this.select[0][0]].monster[0]), var2_2 + 9, var3_4 + 150 + 13, var4_3 - 70, 0, 1, 2);
                                this.drawMonsterFealty(var1_1[this.select[0][0]], var2_2 + 2, var3_4 - 14);
                                Ui.i().drawString(this.monsterT[var1_1[this.select[0][0]].monster[3]].toString(), var2_2 + 25, var3_4 + 12, 0, 0, 1);
                                if (var1_1[this.select[0][0]].monster[5] != 0) break block12;
                                Ui.i().drawString("\u4e0d\u53ef\u8fdb\u5316", var2_2 + 115, var3_4 + 12, 0, 0, 1);
                            }
lbl27:
                            // 4 sources

                            while (true) {
                                this.drawMonPro((Monster[])var1_1, var2_2, var3_4);
                                if (this.t_length != 0) {
                                    this.drawMonList((Monster[])var1_1, 280 + 180 - 75 - 15 + 2, 0 + 13, this.list_rows, this.t_length, this.select[0]);
                                }
                                Ui.i().sliding(280 + 180 - 17, 0 + 12, 116 + 6, (int)this.select[0][0], (int)this.t_length, true);
                                var6_6 = Ui.i();
                                var1_1 = new StringBuilder(String.valueOf(this.t_length)).append("/");
                                if (this.mini_state != 6) break block13;
                                var2_2 = this.max_monsters;
lbl36:
                                // 2 sources

                                while (true) {
                                    var6_6.drawNum(var1_1.append(var2_2).toString(), 280 + 180 - 40, 0 + 12, 0, 0);
                                    if (this.popMenu != -1) {
                                        this.drawSelectMenu(this.about_d, 320 - 25, 30, 75, 2, 0, this.popMenu);
                                        if (this.buyOk == 1) {
                                            this.showString(this.gogoString, 180 - 25, 0);
                                        }
                                    }
                                    var1_1 = Ui.i();
                                    if (this.t_length != 0) {
                                        var5_5 = true;
lbl45:
                                        // 2 sources

                                        while (true) {
                                            var1_1.drawYesNo(var5_5, true);
                                            return;
                                        }
                                    }
                                    break block14;
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                    }
                    var5_5 = true;
                    ** while (true)
                }
                Ui.i().drawString("\u53ef\u8fdb\u5316" + var1_1[this.select[0][0]].monster[5] + "\u6b21", var2_2 + 115, var3_4 + 12, 0, 0, 1);
                ** while (true)
            }
            var2_2 = this.max_takes;
            ** while (true)
        }
        var5_5 = false;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawMY_BAG(int var1_1, int var2_2, int var3_3, int var4_4) {
        block10: {
            block9: {
                var6_5 = (byte)(this.action_str.length - 1);
                Ui.i().fillRectB();
                Ui.i().drawK2(var1_1 + 1, var2_2 + 3, var3_3 - 2, var4_4 - 3, 0);
                Ui.i().drawK1(var1_1 + 5, var2_2 + 25 + 14, var3_3 - 23, this.list_rows * 31, 1);
                Ui.i().drawK1(var1_1 + 5, var2_2 + 25 + 20 + this.list_rows * 31, var3_3 - 10, 90, 2);
                if (var6_5 == 0) {
                    Ui.i().drawK1((var3_3 >> 1) + var1_1 - 25 - 9, var2_2 + 8, 66, 28, 4);
                    Ui.i().drawString(this.action_str[var6_5], (var3_3 >> 1) + var1_1, var2_2 + 7, 17, 0, 0);
                    Log.e((String)"sk", (String)"drawMY_BAG");
lbl11:
                    // 3 sources

                    while (true) {
                        this.drawItemList(var1_1 + 9, var2_2 + 25 + 17, var3_3 - 23, this.list_rows, this.select[0], this.selectx, this.itemsLength[this.selectx], 0);
                        Ui.i().sliding(var1_1 + var3_3 - 15, var2_2 + 25 + 17, this.list_rows * 31 - 6, (int)this.select[0][0], (int)this.itemsLength[this.selectx], true);
                        if (this.itemsLength[this.selectx] > 0) {
                            this.showStringM(this.item_help[this.items[this.selectx][this.select[0][0]][0]].toString(), var1_1 + (var3_3 >> 1), this.list_rows * 31 + (var2_2 + 25 + 22), 10, 3);
                        }
                        if (this.selectx != 2) break block9;
                        var9_7 = true;
lbl18:
                        // 2 sources

                        while (true) {
                            this.drawMoney((var3_3 >> 1) + var1_1, var2_2 + var4_4 - 2, 0, var9_7);
                            var10_6 = Ui.i();
                            if (this.itemsLength[this.selectx] == 0) {
                                var9_7 = false;
lbl23:
                                // 2 sources

                                while (true) {
                                    var10_6.drawYesNo(var9_7, true);
                                    if (this.popMenu != -1) {
                                        this.drawSelectMenu(this.about_a, (var3_3 >> 1) + var1_1 - 25 - 8, 50, 75, 2, 0, this.popMenu);
                                    }
                                    return;
                                }
                            }
                            break block10;
                            break;
                        }
                        break;
                    }
                }
                Ui.i().drawK1((this.selectx + 1) * var3_3 / 5 + var1_1 - 22, var2_2 + 8, 70, 28, 4);
                block3: while (true) {
                    block11: {
                        if (var6_5 > -1) break block11;
                        Ui.i().drawTriangle((var3_3 >> 1) + var1_1, var2_2 + 14, 354, true, true);
                        if (this.popMenu != -1 || (var5_11 = this.pkey.selectMenuX(4, 0, 0, var3_3 / 4, 35)) == -1) ** GOTO lbl11
                        this.selectx = var5_11;
                        this.select[0][1] = this.select_st[this.selectx];
                        this.select[0][0] = this.select_it[this.selectx];
                        ** continue;
                    }
                    var11_10 = Ui.i();
                    var10_6 = this.action_str[var6_5];
                    var8_9 = (var6_5 + 1) * var3_3 / 5;
                    if (this.selectx != var6_5) break;
                    var7_8 = 0;
lbl44:
                    // 2 sources

                    while (true) {
                        var11_10.drawString(var10_6, var8_9 + var1_1 - 14, var2_2 + 7, 0, var7_8, 0);
                        var6_5 = (byte)(var6_5 - 1);
                        continue block3;
                        break;
                    }
                    break;
                }
                var7_8 = 1;
                ** while (true)
            }
            var9_7 = false;
            ** while (true)
        }
        var9_7 = true;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawMagicUI(Monster var1_1) {
        block17: {
            block18: {
                block16: {
                    block15: {
                        block14: {
                            block13: {
                                block12: {
                                    Ui.i().fillRect(5422575, 0, 0, 640, 360);
                                    var3_2 = 1 + 180;
                                    this.drawBG0(this.bg_c, var3_2, 108, 0, 267);
                                    if (this.pkey.selectMenuX(2, var3_2, 108, 120, 29) != -1) {
                                        Ms.key = -3;
                                        Ms.keyRepeat = true;
                                    }
                                    var8_3 = Ui.i();
                                    if (this.popMenu == 0) {
                                        var2_4 = -143;
lbl10:
                                        // 2 sources

                                        while (true) {
                                            var8_3.drawK1(320 + var2_4, 108 + 3, 123, 27, 4);
                                            var8_3 = Ui.i();
                                            var9_5 = GameRun.g;
                                            var9_5 = GameRun.g;
                                            if (this.popMenu != 0) break block12;
                                            var2_4 = 0;
lbl17:
                                            // 2 sources

                                            while (true) {
                                                var8_3.drawString("\u666e\u901a\u6280\u80fd", 320 - 25, 108 + 1, 8 | 16, var2_4, 0);
                                                var8_3 = Ui.i();
                                                if (this.popMenu != 0) break block13;
                                                var2_4 = 1;
lbl22:
                                                // 2 sources

                                                while (true) {
                                                    var8_3.drawString("\u5929\u8d4b\u6280\u80fd", 320 + 25, 108 + 1, 0, var2_4, 0);
                                                    var2_4 = this.mList_id[var1_1.monster[0]][1];
                                                    var5_6 = this.mon_action;
                                                    var6_7 = this.move_x;
                                                    var4_8 = this.move_y;
                                                    if (this.mon_action != 1) break block14;
                                                    var7_9 = false;
lbl30:
                                                    // 2 sources

                                                    while (true) {
                                                        if (this.drawCartoonOne(1, 1, var2_4 * 3 + var5_6, 377 - var6_7, 97 - var4_8, var7_9, 0)) {
                                                            this.mon_action = 0;
                                                        }
                                                        this.move_x = Ms.i().mathSpeedDown((int)this.move_x, 3, false);
                                                        this.move_y = Ms.i().mathSpeedDown((int)this.move_y, 3, false);
                                                        if (this.popMenu != 0) break block15;
                                                        this.drawSkillList(var3_2 + 7, 108 + 25 + 12, 267 - 29, 31, 5, this.select[0]);
                                                        if (this.skill_list[this.select[0][0]] != -1) {
                                                            this.gogoWord(this.skill_help[this.skill_list[this.select[0][0]]].toString(), var3_2 + 10, 360 - 25 - 22, 200, 0, 1, 2);
                                                        }
lbl39:
                                                        // 5 sources

                                                        while (true) {
                                                            var8_3 = Ui.i();
                                                            var3_2 = this.select[0][0];
                                                            if (this.popMenu != 0) break block16;
                                                            var2_4 = this.skill_list[8];
lbl44:
                                                            // 3 sources

                                                            while (true) {
                                                                var8_3.sliding(267 + 180 - 13, 108 + 25 + 13, 360 - 108 - 120, var3_2, var2_4, true);
                                                                if (this.mini_state != 13) {
                                                                    Ui.i().drawTriangle(320, 108 + 12, 150, true, true);
                                                                    Ui.i().drawYesNo(false, true);
lbl49:
                                                                    // 2 sources

                                                                    return;
                                                                }
                                                                break block17;
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                    break;
                                                }
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                    var2_4 = 21;
                                    ** while (true)
                                }
                                var2_4 = 1;
                                ** while (true)
                            }
                            var2_4 = 0;
                            ** while (true)
                        }
                        var7_9 = true;
                        ** while (true)
                    }
                    this.drawBuffList(var1_1, var3_2 + 7, 108 + 25 + 12, 267 - 29, 31, 5, this.select[0]);
                    if (var1_1.monster[this.select[0][0] + 16] <= 0) ** GOTO lbl39
                    this.showStringM(this.buff_help[var1_1.monster[this.select[0][0] + 16]].toString(), 320, 360 - 50 - 22, 9, 0);
                    ** while (true)
                }
                if (var1_1.monster[this.select[0][0] + 16] <= 0) break block18;
                var2_4 = 2;
                ** GOTO lbl44
            }
            var2_4 = 1;
            ** while (true)
        }
        Ui.i().drawYesNo(true, true);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawMonKind(byte var1_1, int var2_2, int var3_3, int var4_4) {
        var5_5 = 0;
        block0: while (true) {
            if (var5_5 >= 5) {
                return;
            }
            var7_7 = Ui.i();
            if (var1_1 <= var5_5) break;
            var6_6 = 23;
lbl8:
            // 2 sources

            while (true) {
                var7_7.drawUi(var6_6, var5_5 * 14 + var2_2, var3_3, var4_4, 0);
                var5_5 = (byte)(var5_5 + 1);
                continue block0;
                break;
            }
            break;
        }
        var6_6 = 24;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void drawMonList(Monster[] var1_1, int var2_2, int var3_3, int var4_4, int var5_5, byte[] var6_6) {
        block10: {
            var7_8 = var8_7 = var6_6[1];
            if (this.mini_state != 6) {
                var11_9 /* !! */  = Ui.i();
                var12_10 = GameRun.g;
                var12_10 = GameRun.g;
                var11_9 /* !! */ .drawUi(34, var2_2 - 50 - 5, var3_3 + 2, 8 | 16, 0);
                var7_8 = var8_7;
            }
            block0: while (true) {
                if (var7_8 >= var6_6[1] + var4_4 || var7_8 >= var5_5) {
                    return;
                }
                if (var6_6[0] == var7_8) {
                    Ui.i().drawK(var2_2 - 50, (var7_8 - var6_6[1]) * 29 + var3_3, 108, 26, 1);
                }
                var12_10 = Ui.i();
                var11_9 /* !! */  = this.getNameMon(var1_1[var7_8].monster[0]).toString();
                var10_12 = var6_6[1];
                if (var6_6[0] != var7_8) break;
                var9_11 = 0;
lbl18:
                // 2 sources

                while (true) {
                    var12_10.drawString((String)var11_9 /* !! */ , var2_2 + 4, var3_3 - 2 + (var7_8 - var10_12) * 29, 17, var9_11, 1);
                    if (this.popMenu == -1 && this.pkey.isSelect(var2_2 - 50, (var7_8 - var6_6[1]) * 29 + var3_3, 100, 26)) {
                        if (var6_6[0] != var7_8) break block10;
                        Ms.key = 53;
                        Ms.keyRepeat = true;
                    }
lbl24:
                    // 4 sources

                    while (true) {
                        var7_8 = (byte)(var7_8 + 1);
                        continue block0;
                        break;
                    }
                    break;
                }
                break;
            }
            var9_11 = 1;
            ** while (true)
        }
        var6_6[0] = var7_8;
        if (var7_8 - var6_6[1] == 0 && var6_6[1] > 0) {
            var6_6[1] = (byte)(var6_6[1] - 1);
lbl33:
            // 3 sources

            while (true) {
                this.initMonStream(2, this.mList_id[var1_1[var6_6[0]].monster[0]][0], 1);
                this.setShowPro(var1_1[var6_6[0]]);
                this.introT = Constants_H.WIDTH_H;
                this.introX = Constants_H.WIDTH_H;
                ** continue;
                break;
            }
        }
        if (var7_8 - var6_6[1] != var4_4 - 1 || var6_6[1] + var4_4 >= var5_5) ** GOTO lbl33
        var6_6[1] = (byte)(var6_6[1] + 1);
        ** while (true)
    }

    private void drawMonPro(Monster[] monsterArray, int n, int n2) {
        Ui.i().drawStringY((Object[])this.about_a, n + 18, n2 + 44, 0, 3, 31, 3, 0);
        Ui.i().drawStringY((Object[])this.about_b, n + 160, n2 + 44, 0, 3, 31, 3, 0);
        if (this.t_length != 0) {
            Ui.i().drawStringY((Object[])this.about_c, n + 165 + 50, n2 + 44, 0, 3, 31, -1, 0);
            this.drawMonsterHp(monsterArray[this.select[0][0]], n + 19 + 50 + 4, n2 + 59, 48, 0, 0, monsterArray[this.select[0][0]].monsterPro[0]);
            this.drawMonsterHp(monsterArray[this.select[0][0]], n + 19 + 50 + 4, n2 + 59 + 25 + 3, 48, 1, 0, monsterArray[this.select[0][0]].monsterPro[1]);
            this.drawMonKind(monsterArray[this.select[0][0]].monster[4], n + 19 + 50 + 4, n2 + 76 + 28, 0);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void drawMonsterFealty(Monster var1_1, int var2_2, int var3_3) {
        var4_4 = var1_1.monster[4];
        var5_5 = this.initFealty;
        if (var4_4 < 4) {
            var4_4 = 0;
lbl5:
            // 2 sources

            while (true) {
                this.drawFealty((byte)(var5_5[var4_4] / 20), (byte)(var1_1.monster[6] / 20), var2_2, var3_3);
                return;
            }
        }
        var4_4 = 1;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawMonsterHp(Monster var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7) {
        block4: {
            block5: {
                if (var5_5 >= 2) break block5;
                var9_8 = var1_1.monsterPro[var5_5 + 0];
                var10_9 = var1_1.monsterPro[var5_5 + 2];
                var8_10 = var7_7;
                var7_7 = var10_9;
lbl6:
                // 2 sources

                while (true) {
                    Ui.i().drawBarOne(var2_2, var3_3, var4_4, (int)Ms.i().mathPercent(var8_10, var4_4 - 2, var7_7), (int)Ms.i().mathPercent((int)var9_8, var4_4 - 2, var7_7), var5_5);
                    if (var6_6 == 2) ** GOTO lbl16
                    var1_1 = String.valueOf(var9_8) + "/" + var7_7;
                    var11_11 = Ui.i();
                    var7_7 = var1_1.length();
                    if (var6_6 != 1) break block4;
                    var5_5 = 5;
lbl14:
                    // 2 sources

                    while (true) {
                        var11_11.drawNum((String)var1_1, (var4_4 - var7_7 * 8 >> 1) + var2_2, var5_5 + var3_3, 0, 0);
lbl16:
                        // 2 sources

                        return;
                    }
                    break;
                }
            }
            var8_10 = var7_7;
            if (var7_7 == 0) {
                var8_10 = var1_1.monsterPro[4];
            }
            var9_8 = (short)var8_10;
            var7_7 = this.getMonsterExp((Monster)var1_1);
            ** while (true)
        }
        var5_5 = 0;
        ** while (true)
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

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     */
    private void drawNidus(int var1_1, int var2_2) {
        block18: {
            block19: {
                block17: {
                    block20: {
                        block16: {
                            block14: {
                                block15: {
                                    block21: {
                                        if (this.mini_state == 16) {
                                            this.drawSelectMenu(this.about_d, 320 - 75, 180 - (this.about_d.length >> 1) * 25, 150, 1, 0, this.popMenu);
lbl3:
                                            // 2 sources

                                            return;
                                        }
                                        Ui.i().fillRectB();
                                        this.drawBG0(this.bg_c, var1_1 + 1, 108, 0, var2_2);
                                        Log.e((String)"sk", (String)"drawNidus");
                                        Ui.i().drawString(String.valueOf(this.popMenu + 1) + "/" + 5, var1_1 + 10, 106, 36, 0, 2);
                                        var8_3 = Ui.i();
                                        if (this.getRid(this.popMenu) != -2) break block21;
                                        var7_4 = "\u6b64\u4f4d\u7f6e\u76ee\u524d\u662f\u7a7a\u7684";
lbl13:
                                        // 2 sources

                                        while (true) {
                                            var8_3.drawString(var7_4, var1_1 + 20, 110, 0, 1, 0);
                                            if (this.getRid(this.popMenu) == -2) ** GOTO lbl38
                                            if (this.b_c >= 2) break block14;
                                            var4_5 = this.mon_action;
                                            if (this.b_c != 1) break block15;
                                            var5_6 = false;
lbl20:
                                            // 2 sources

                                            while (this.drawCartoonOne(1, 1, var4_5, 377, 97, var5_6, 0)) {
                                                this.initMonStream(2, this.mList_id[this.getNid(this.popMenu)][0], 1);
                                                this.b_c = (byte)2;
lbl23:
                                                // 3 sources

                                                while (this.b_c != -1) {
                                                    var2_2 = (short)(var2_2 - 40);
                                                    this.str_cur = String.valueOf(this.getNexp(this.popMenu, 1)) + "/" + this.getNexp(this.popMenu, 3);
                                                    Ui.i().drawBarOne(var1_1 + 20, 158, var2_2, (int)Ms.i().mathPercent((int)this.getNexp(this.popMenu, 1), var2_2 - 2, (int)this.getNexp(this.popMenu, 3)), (int)Ms.i().mathPercent((int)this.getNexp(this.popMenu, 1), var2_2 - 2, (int)this.getNexp(this.popMenu, 3)), 2);
                                                    Ui.i().drawNum(this.str_cur, var1_1 + 20 + (var2_2 - this.str_cur.length() * 8 >> 1), 164, 0, 0);
                                                    var8_3 = Ui.i();
                                                    if (this.getNexp(this.popMenu, 1) != this.getNexp(this.popMenu, 3)) break block16;
                                                    var7_4 = "\u5b75\u5316\u5df2\u5b8c\u6210";
lbl31:
                                                    // 2 sources

                                                    while (true) {
                                                        var8_3.drawString(var7_4, var1_1 + 20 + (var2_2 >> 1), 164, 17, 3, 1);
                                                        Ui.i().drawString("\u5b75\u5316\u6240\u9700\u6750\u6599", var1_1 + 20 + (var2_2 >> 1), 208, 17, 3, 1);
                                                        this.drawEvolveMake(this.getNid(this.popMenu), var1_1 + 25, 239, 28);
lbl35:
                                                        // 2 sources

                                                        while (true) {
                                                            if (this.getNexp(this.popMenu, 1) == this.getNexp(this.popMenu, 3)) {
                                                                Ui.i().drawString("\u6309\u786e\u5b9a\u952e\u5b8c\u6210\u5b75\u5316", var1_1 + 20, 360 - 25 - 21, 0, 0, 0);
                                                            }
lbl38:
                                                            // 4 sources

                                                            if (this.b_c == -2) {
                                                                Ui.i().drawTriangle(320, 120, 150, true, true);
                                                            }
                                                            var7_4 = Ui.i();
                                                            if (this.getRid(this.popMenu) != -2) break block17;
                                                            var5_6 = false;
lbl43:
                                                            // 2 sources

                                                            while (this.b_c != -1) {
                                                                var6_7 = true;
lbl45:
                                                                // 2 sources

                                                                while (true) {
                                                                    var7_4.drawYesNo(var5_6, var6_7);
                                                                    var1_1 = this.pkey.selectMenuX(2, 0, 0, 320, 360);
                                                                    if (var1_1 == -1) ** GOTO lbl3
                                                                    if (var1_1 == 0) {
                                                                        var1_1 = -3;
lbl51:
                                                                        // 2 sources

                                                                        while (true) {
                                                                            Ms.key = var1_1;
                                                                            Ms.keyRepeat = true;
                                                                            return;
                                                                        }
                                                                    }
                                                                    break block18;
                                                                    break;
                                                                }
                                                            }
                                                            break block19;
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                }
                                                break block20;
                                            }
                                            break block14;
                                            break;
                                        }
                                    }
                                    var7_4 = this.monsterT[this.monster_pro[this.getNid(this.popMenu)][6]] + "\u7684\u5ba0\u7269\u86cb";
                                    ** while (true)
                                }
                                var5_6 = true;
                                ** GOTO lbl20
                            }
                            if (this.b_c <= 1 || this.b_c >= 14) ** GOTO lbl23
                            this.drawClipPic(this.mList_id[this.getNid(this.popMenu)][1], 1, 377, 97, 80, 77, 15, this.b_c - 2, 0);
                            this.b_c = var3_8 = (byte)(this.b_c + 1);
                            if (var3_8 == 14) {
                                this.b_c = (byte)-1;
                            }
                            this.mon_action = (byte)(this.mList_id[this.getNid(this.popMenu)][1] * 3);
                            ** GOTO lbl23
                        }
                        var7_4 = "\u5b75\u5316\u4e2d...";
                        ** while (true)
                    }
                    Ui.i().drawStringY((Object[])this.about_a, var1_1 + 26, 155, 0, 3, 30, 3, 0);
                    Ui.i().drawStringY((Object[])this.about_b, var1_1 + 126, 155, 0, 3, 30, 3, 0);
                    Ui.i().drawString("\u6863\u6b21\uff1a", var1_1 + 20 + 50, 258, 0, 3, 1);
                    this.drawMonKind(this.monster_pro[this.getNid(this.popMenu)][5], var1_1 + 23 + 100 + 10, 263, 0);
                    ** while (true)
                }
                var5_6 = true;
                ** GOTO lbl43
            }
            var6_7 = false;
            ** while (true)
        }
        var1_1 = -4;
        ** while (true)
    }

    private void drawPlayer(Graphics graphics) {
        this.drawMyMon();
        this.drawMyMonState();
        this.drawEnemy();
        this.drawEnemyState();
    }

    /*
     * Unable to fully structure code
     */
    private void drawPlayerAppear(Graphics var1_1) {
        block6: {
            switch (this.battle_state) {
                default: lbl-1000:
                // 2 sources

                {
                    return;
                }
                case 0: 
            }
            if (this.battle_type <= 2) break block6;
            if (this.src_c[2] == 0 && this.enB.throw_state == -1 && this.src_c[0] == 12) {
                this.enB.throw_state = 0;
lbl9:
                // 6 sources

                while (true) {
                    this.drawThrowBall(this.myB, this.myB.getMon(), 1, 266, 236);
                    ** continue;
                    break;
                }
            }
            if (this.enB.throw_state != 0 && this.enB.throw_state != 2) ** GOTO lbl9
            this.drawCartoonOne(0, 0, this.mList_id[this.enB.getMon().monster[0]][1] * 3 + this.enB.action, this.enemyOff + 377, 97, false, 0);
            this.enemyOff = Ms.i().mathSpeedN(this.enemyOff, 0, 4, false);
            if (this.enemyOff != 0) ** GOTO lbl9
            this.enB.throw_state = (byte)2;
            ** GOTO lbl9
        }
        if (this.battle_type >= 2) ** GOTO lbl9
        this.drawThrowBall(this.enB, this.enB.getMon(), 0, 377, 97);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawSelectMenu(Graphics var1_1, boolean var2_2, int var3_3) {
        Ui.i().drawK2(200, var3_3 + 15, 240, 360 - var3_3 - 20, 0);
        this.drawBattleExp(this.myB.getMon(), var3_3 + 3);
        if (var2_2) {
            return;
        }
        Ui.i().drawString("\u8981\u505a\u4ec0\u4e48\uff1f", 450, 10, 0, 0, 2);
        var3_3 = 0;
        while (true) {
            if (var3_3 >= this.imgBattle.length) ** continue;
            Ui.i().drawImage(this.imgBattle[var3_3], this.pkey.button_pos[5][var3_3][0], this.pkey.button_pos[5][var3_3][1], 0);
            var3_3 = (byte)(var3_3 + 1);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void drawSkillList(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5, byte[] var6_6) {
        block13: {
            block12: {
                block11: {
                    block10: {
                        block9: {
                            var7_7 = var6_6[1];
                            Ui.i().drawListKY(var5_5, var1_1, var2_2, var3_3, 3, var4_4, 0, var6_6[0] - var6_6[1], 4, 2);
                            block0: while (true) {
                                if (var7_7 >= var6_6[1] + var5_5 || var7_7 >= this.skill_list[8]) {
                                    return;
                                }
                                var10_10 /* !! */  = Ui.i();
                                if (this.skill_list[var7_7] <= 25) break;
                                var8_8 = 50;
lbl9:
                                // 2 sources

                                while (true) {
                                    var10_10 /* !! */ .drawUi(var8_8, var1_1 + 8, var2_2 + 8 + (var7_7 - var6_6[1]) * var4_4, 0, 0);
                                    Log.e((String)"sk", (String)"\u666e\u901a\u653b\u51fb");
                                    var11_11 = Ui.i();
                                    var10_10 /* !! */  = this.getNameSkill(this.skill_list[var7_7]).toString();
                                    var9_9 = var6_6[1];
                                    if (var6_6[0] != var7_7) break block9;
                                    var8_8 = 0;
lbl18:
                                    // 2 sources

                                    while (true) {
                                        var11_11.drawString((String)var10_10 /* !! */ , var1_1 + 21, var2_2 + 1 + (var7_7 - var9_9) * var4_4, 0, var8_8, 0);
                                        var11_11 = Ui.i();
                                        if (this.skill_list[var7_7] > 30) break block10;
                                        var10_10 /* !! */  = String.valueOf(this.skill[this.skill_list[var7_7]][1]) + "\u80fd\u91cf";
lbl23:
                                        // 2 sources

                                        while (true) {
                                            var9_9 = var6_6[1];
                                            var12_12 = GameRun.g;
                                            var12_12 = GameRun.g;
                                            if (var6_6[0] != var7_7) break block11;
                                            var8_8 = 0;
lbl29:
                                            // 2 sources

                                            while (true) {
                                                var11_11.drawString((String)var10_10 /* !! */ , var1_1 + var3_3 - 8, var2_2 + 1 + (var7_7 - var9_9) * var4_4, 8 | 16, var8_8, 0);
                                                if (this.say_c < 1 && this.pkey.isSelect(var1_1, (var7_7 - var6_6[1]) * var4_4 + var2_2, var3_3, var4_4)) {
                                                    if (var6_6[0] != var7_7) break block12;
                                                    this.pkey.setKey5();
                                                }
lbl34:
                                                // 6 sources

                                                while (true) {
                                                    var7_7 = (byte)(var7_7 + 1);
                                                    continue block0;
                                                    break;
                                                }
                                                break;
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            var8_8 = 51;
                            ** while (true)
                        }
                        var8_8 = 3;
                        ** while (true)
                    }
                    var10_10 /* !! */  = "\u88ab\u52a8";
                    ** while (true)
                }
                var8_8 = 3;
                ** while (true)
            }
            var6_6[0] = var7_7;
            if (var7_7 - var6_6[1] != 0 || var6_6[1] <= 0) break block13;
            var6_6[1] = (byte)(var6_6[1] - 1);
            ** GOTO lbl34
        }
        if (var7_7 - var6_6[1] != var5_5 - 1 || var6_6[1] + var5_5 >= this.skill_list[8]) ** GOTO lbl34
        var6_6[1] = (byte)(var6_6[1] + 1);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawThrowBall(Battle var1_1, Monster var2_2, int var3_3, int var4_4, int var5_5) {
        block2: {
            if (var1_1.throw_state == 0) {
                var9_6 = Ui.i();
                var8_7 = this.imgItem[0];
                var6_8 = var1_1.cThrow[0];
                var7_9 = var1_1.cThrow[1];
                var10_10 = GameRun.g;
                var10_10 = GameRun.g;
                var9_6.drawImage(var8_7, var6_8 + var4_4, var5_5 - var7_9, 1 | 32);
lbl9:
                // 4 sources

                while (true) {
                    this.runThrowBall(var1_1, var2_2, var3_3);
                    return;
                }
            }
            if (var1_1.throw_state != 1) break block2;
            this.drawClipPic(this.mList_id[var2_2.monster[0]][1], var3_3, var4_4, var5_5, 80, 77, 15, var1_1.cThrow[2], var3_3);
            ** GOTO lbl9
        }
        if (var1_1.throw_state != 2) ** GOTO lbl9
        this.drawCartoonOne(var3_3, var3_3, this.mList_id[var2_2.monster[0]][1] * 3, var4_4, var5_5, true, var3_3);
        ** while (true)
    }

    private void drawVIEW_COMPUTER() {
        Ui.i().drawK2(320 - 25 * 2 - 8, 180 - 25 * 2 - 8, 25 * 4 + 16, 25 * 6 + 16, 0);
        this.drawSelectMenu(this.about_d, 320 - 25 - 4, 180 - 25, (25 + 4) * 2, 2, 0, this.popMenu);
        Ui.i().drawString("\u5bc4\u5b58\u5ba0\u7269", 320, 180 - 25 * 2 - 6, 17, 1, 1);
        Ui.i().drawYesNo(true, true);
    }

    private void effectR(Monster monster) {
        if (monster.effect_time > 0) {
            monster.effect_time = (byte)(monster.effect_time - 1);
        }
        if (monster.effect_time == 0) {
            monster.effect = (byte)7;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void enemy_init() {
        block6: {
            block7: {
                var5_1 = new Monster[this.enemyList.length];
                var1_2 = 0;
                block0: while (true) {
                    if (var1_2 >= this.enemyList.length) {
                        this.enemyList = null;
                        this.enB = new Battle(var5_1);
                        return;
                    }
                    var3_4 = this.enemyList[var1_2][0];
                    var4_5 = this.enemyList[var1_2][1];
                    if (!this.myMonsters[0].isMonReel(39)) break;
                    var2_3 = 1;
lbl12:
                    // 2 sources

                    while (true) {
                        var5_1[var1_2] = new Monster(this, (int)var3_4, (int)var4_5, var2_3);
                        if (this.battle_type != 3 && this.battle_type != 0) break block6;
                        if (var5_1[var1_2].monster[3] == -1) {
                            var5_1[var1_2].resetBoss((int)this.enemyList[var1_2][4]);
lbl17:
                            // 2 sources

                            while (true) {
                                var5_1[var1_2].resetPro(this);
lbl19:
                                // 2 sources

                                while (true) {
                                    ++var1_2;
                                    continue block0;
                                    break;
                                }
                                break;
                            }
                        }
                        break block7;
                        break;
                    }
                    break;
                }
                var2_3 = 0;
                ** while (true)
            }
            var5_1[var1_2].resetMonster((int)this.enemyList[var1_2][2], (int)this.enemyList[var1_2][3], (int)this.enemyList[var1_2][4]);
            ** while (true)
        }
        var5_1[var1_2].resetMonster(this, -1);
        ** while (true)
    }

    private int getBXY(int n, int n2, boolean bl) {
        int n3;
        int n4;
        block5: {
            block4: {
                int n5 = 266;
                int n6 = 236;
                if (n == 1 && !this.isSkillToMe(n2)) break block4;
                n4 = n5;
                n3 = n6;
                if (n != 0) break block5;
                n4 = n5;
                n3 = n6;
                if (!this.isSkillToMe(n2)) break block5;
            }
            n4 = 377;
            n3 = 97;
        }
        if (bl) {
            n3 = n4;
        }
        return n3;
    }

    /*
     * Enabled force condition propagation
     */
    private void getBattleBG(Battle battle, Monster monster) {
        if (this.monPro.length != 0) {
            battle.bg_id = this.monPro[0];
        }
        int n = 0;
        while (n < 5) {
            if (monster.isMonReel(n + 43)) {
                battle.bg_id = (byte)n;
                return;
            }
            n = (byte)(n + 1);
        }
        return;
    }

    /*
     * Unable to fully structure code
     */
    private int getBuyItemCount(int var1_1, int var2_2, boolean var3_3) {
        if (var3_3) {
            if (var1_1 == 2) {
                var1_1 = this.coin / this.sell_money;
lbl4:
                // 2 sources

                while (true) {
                    var2_2 = var4_4 = 99 - this.findItem(-2, this.buyItem[this.cur_a][var2_2], true);
                    if (var4_4 < 0) {
                        var2_2 = 0;
                    }
                    if (var1_1 > var2_2) {
                        var1_1 = var2_2;
                    }
lbl10:
                    // 4 sources

                    return var1_1;
                }
            }
            var1_1 = this.money / this.sell_money;
            ** continue;
        }
        var1_1 = this.items[this.cur_a][var2_2][1];
        ** while (true)
    }

    private void getExpOne(boolean bl) {
        int n = 0;
        this.exp = 0;
        Ms.i();
        Ms.skip2 = this.enB.mon[0].monster[2];
        while (true) {
            if (n >= this.enB.mon.length) {
                this.exp = (short)(this.exp * (56 / this.mon_in_battle[0] - (this.mon_in_battle[0] - 1) * 2 + 44) / 100);
                if (!bl) {
                    this.exp = (short)(this.exp / 2);
                }
                return;
            }
            this.exp = (short)(this.exp + (this.enB.mon[n].monster[2] * 3 + 80));
            byte by = this.enB.mon[n].monster[2];
            Ms.i();
            if (by > Ms.skip2) {
                Ms.i();
                Ms.skip2 = this.enB.mon[n].monster[2];
            }
            n = (byte)(n + 1);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void getHitCoefficient(Battle var1_1, Monster var2_2, Monster var3_3) {
        block3: {
            block4: {
                var1_1 /* !! */ .countS[1] = 0;
                var4_4 = var2_2.monster[6] - 99;
                var6_5 = var1_1 /* !! */ .countS;
                var5_6 = var6_5[1];
                if (var4_4 <= 1) break block4;
                var4_4 = 20;
lbl7:
                // 2 sources

                while (true) {
                    var6_5[1] = (byte)(var5_6 + var4_4);
                    if (var2_2.monster[3] == -1 || var1_1 /* !! */ .bg_id == var2_2.monster[3]) ** GOTO lbl16
                    var6_5 = var1_1 /* !! */ .countS;
                    var5_6 = var6_5[1];
                    if (var1_1 /* !! */ .bg_id != var2_2.monster[3]) break block3;
                    var4_4 = 0;
lbl14:
                    // 2 sources

                    while (true) {
                        var6_5[1] = (byte)(var5_6 + var4_4);
lbl16:
                        // 2 sources

                        var1_1 /* !! */  = (Battle)var1_1 /* !! */ .countS;
                        var1_1 /* !! */ [1] = (Battle)((byte)(var1_1 /* !! */ [1] + this.isShuXing(var2_2, var3_3)));
                        return;
                    }
                    break;
                }
            }
            var4_4 = var4_4 / 20 * 20;
            ** while (true)
        }
        var4_4 = -20;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private String getInfoType(int n) {
        if (n == -1) {
            return "\u4efb\u52a1";
        }
        if (n == -2) {
            return "\u8fdb\u5316";
        }
        if (n == -3) {
            return "\u5f02\u5316";
        }
        if (n == -4) {
            return "\u7ade\u6280\u573a";
        }
        if (n != -5) return "\u6355\u83b7";
        return "\u5b75\u5316";
    }

    private byte getMonInfo_dir() {
        return this.monInfo_dir[this.cur_a][this.getSelInfo()];
    }

    /*
     * Enabled force condition propagation
     */
    private byte getMonster(Monster monster, int n, boolean bl) {
        if (this.monInfoList[monster.monster[0]] != 2) {
            this.monInfoList[monster.monster[0]] = 2;
            this.addMonInfoListBH();
            this.map.addAnole((int)monster.monster[0]);
        }
        if (this.myMon_length < this.max_takes) {
            this.myMonsters[this.myMon_length] = monster;
            if (bl) {
                this.myMonsters[this.myMon_length].resetMonster(this, n);
            }
            this.myMon_length = (byte)(this.myMon_length + 1);
            return 0;
        }
        if (this.cMon_count >= this.max_monsters) return -1;
        this.say("\u643a\u5e26\u5df2\u6ee1\uff0c" + this.getNameMon(monster.monster[0]) + "\u5df2\u8f6c\u5165\u5bc4\u653e\u5904", 0);
        this.cMonsters[this.cMon_count] = monster;
        if (bl) {
            this.cMonsters[this.cMon_count].resetMonster(this, n);
        }
        this.cMon_count = (byte)(this.cMon_count + 1);
        return 1;
    }

    private short getMonsterExp(Monster monster) {
        return (short)(monster.monster[2] * 210 / 10 - 2);
    }

    private String getNameBuff(int n) {
        int n2 = n;
        if (n < 1) {
            n2 = 0;
        }
        return this.buff_name[n2].toString();
    }

    private String getNameSkill(byte by) {
        return this.skill_name[by].toString();
    }

    /*
     * Unable to fully structure code
     */
    private short getPrice(int var1_1, int var2_2, boolean var3_3) {
        if (var3_3) {
            if (var1_1 == 2) {
                var4_4 = this.buyPrice[1][var2_2];
lbl4:
                // 2 sources

                while (true) {
                    var5_5 = var4_4;
                    if (this.view_state == -1) {
                        var5_5 = (short)(var4_4 * 12 / 10);
                    }
lbl8:
                    // 4 sources

                    return var5_5;
                }
            }
            var4_4 = this.buyPrice[0][this.buyItem[this.cur_a][var2_2]];
            ** continue;
        }
        var5_5 = (short)(this.buyPrice[0][var2_2] / 5);
        ** while (true)
    }

    private byte getSelInfo() {
        return this.select[0][0];
    }

    /*
     * Unable to fully structure code
     */
    private void getSkill(int var1_1, int var2_2) {
        if (var1_1 == 0) {
            var3_3 = 25;
lbl3:
            // 2 sources

            while (true) {
                this.getSkill = (byte)var3_3;
                return;
            }
        }
        var3_3 = this.skill_up[var1_1 - 1][var2_2];
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private int getSkillLevel(int n) {
        if (n == 25) {
            return 0;
        }
        if (n >= 25) return this.makeLevel[n - 25 - 1];
        return n % 5 + 1;
    }

    /*
     * Enabled force condition propagation
     */
    private int getSkillMana(Monster monster, int n) {
        int n2 = this.skill[n][1];
        if (monster.monster[3] != 4) return n2;
        if (!monster.isMonReel(35)) return n2;
        return this.skill[n][0] * n2 / 100;
    }

    /*
     * Unable to fully structure code
     */
    private short getbuffRateV(Monster var1_1, int var2_2) {
        if (var1_1.isBuffRate(2)) {
            var3_3 = var2_2 + this.inhesion[2] * var2_2 / 100;
lbl3:
            // 3 sources

            return (short)var3_3;
        }
        var3_3 = var2_2;
        if (!var1_1.isBuffRate(1)) ** GOTO lbl3
        var3_3 = var2_2 + this.inhesion[1] * var2_2 / 100;
        ** while (true)
    }

    private void goBattleExp(boolean bl) {
        this.battle_state = (byte)-5;
        this.cur_c = 0;
        this.b_c = 0;
        this.myB.now_id = this.myMonsters[this.myB.now_id].monster[1];
        this.proReplace[this.myB.now_id][2] = -2;
        this.arangeMonster();
        this.getExpOne(bl);
    }

    private void goBattleItem() {
        this.battle_state = (byte)-4;
        this.cur_b = (byte)-1;
        StringBuffer stringBuffer = new StringBuffer();
        Ms.i();
        if (Ms.getRandom((int)100) < 50 && this.findItem(-2, 32, true) < 99) {
            this.addItem(32, 1);
            stringBuffer.append("\u83b7\u5f97\uff1a" + this.getNameItem(32) + "x1");
        }
        this.setStringB(stringBuffer.toString(), 10000, 0);
    }

    private void goBattleOver() {
        run_state = -15;
        this.b_c = 0;
        this.myB.now_id = 0;
        this.mini_state = (byte)3;
        this.view_state = 1;
        this.bg_c = this.myB.bg_id;
        this.mon[0].nullIMFA();
    }

    /*
     * Unable to fully structure code
     */
    private void goBattleState() {
        this.setAction_str(new String[]{"\u653b\u51fb", "\u9053\u5177", "\u5ba0\u7269", "\u5546\u5e97", "\u9003\u8dd1"});
        GameRun.run_state = -31;
        if (this.mini_state == 1) {
            var1_1 = 2;
lbl5:
            // 2 sources

            while (true) {
                this.battle_state = (byte)var1_1;
                return;
            }
        }
        var1_1 = 1;
        ** while (true)
    }

    private void goCatchMonster() {
        run_state = -19;
        this.cThrowX = (short)131;
        this.cThrowY = (short)-20;
        this.cThrowS = (short)176;
        this.b_c = 0;
    }

    private void goGO_RUNINMAP() {
        this.b_c = 0;
        this.popMenu = (byte)-1;
        System.gc();
        run_state = -11;
    }

    private void goLIST_INFO(boolean bl) {
        run_state = 68;
        if (this.monInfo_dir == null) {
            byte[] byArray = Ms.i().getStream("data/book.d", -1);
            Ms.i();
            Ms.skip = 0;
            this.monInfo_dir = Ms.i().create2Array(byArray);
            byArray = null;
        }
        if (bl) {
            this.infoStart = 0;
            this.cur_a = 0;
            this.cur_b = 0;
            this.move_x = (short)6;
            this.move_y = 0;
            this.t_length = (byte)this.monInfo_dir[this.cur_a].length;
            this.select[0][0] = 0;
            this.select[0][1] = 0;
        }
        this.list_rows = (byte)7;
    }

    private void goMONSTER_INFO(int n) {
        run_state = 67;
        this.initMonStream(2, this.mList_id[n][0], 1);
    }

    /*
     * Unable to fully structure code
     */
    private void goMY_BAG(int var1_1) {
        block2: {
            this.mini_state = (byte)15;
            this.list_rows = (byte)6;
            GameRun.run_state = 25;
            this.popMenu = (byte)-1;
            if (this.view_state == 1) {
                this.setAction_str(new String[]{"\u9053\u5177", "\u8f85\u52a9", "\u5377\u8f74", "\u5b75\u5316"});
lbl7:
                // 4 sources

                while (true) {
                    this.selectx = (byte)var1_1;
                    this.selecty = 0;
                    this.select[0][1] = this.select_st[this.selectx];
                    this.select[0][0] = this.select_it[this.selectx];
                    Ms.i().correctSelect(this.select[0], (int)this.itemsLength[this.selectx], (int)this.list_rows);
                    this.itemMine = null;
                    Ms.i();
                    Ms.skip = 0;
                    this.itemMine = Ms.i().create2Array(Ms.i().getStream("data/box.d", -1));
                    return;
                }
            }
            if (this.view_state != -1) break block2;
            this.setAction_str(new String[]{"\u9053\u5177"});
            ** GOTO lbl7
        }
        if (this.view_state != 2) ** GOTO lbl7
        this.setAction_str(new String[]{"\u5b75\u5316"});
        ** while (true)
    }

    private void goMontsterAppear() {
        run_state = -50;
        this.battle_state = 0;
        this.enemyOff = 63;
        this.setAimBattle(1);
    }

    private void goRUN_IN_MAP(boolean bl) {
        this.selecty = 0;
        this.selectx = 0;
        this.select[0][1] = 0;
        this.mini_state = 0;
        this.view_state = 0;
        GameRun.mc.game_state = 30;
        System.out.println("aaaaaaaaaaaaaaaaa");
        this.map.my.state = 0;
        if (!this.isChangeSound.booleanValue()) {
            Sound.i().setMusicId((int)this.musicNo[this.map.mapNo]);
            Sound.i().setMusic(bl);
            Log.d((String)"soars", (String)"tttttttttttttttttttttt");
        }
        if (this.isChangeSound.booleanValue()) {
            Sound.i().setMusicId((int)this.musicNo[this.map.mapNo]);
            Sound.i().setMusicForMenu(bl);
            Log.d((String)"soars", (String)"ffffffffffffffffffffffffffffffff");
        }
        run_state = -10;
        this.createOver = 0;
        this.buyItemID = 0;
    }

    /*
     * Unable to fully structure code
     */
    private void goSelectAction(int var1_1) {
        GameRun.run_state = -31;
        if (var1_1 == 1) {
            var2_2 = 2;
lbl4:
            // 2 sources

            while (true) {
                this.battle_state = (byte)var2_2;
                this.setAimBattle(var1_1);
                if (var1_1 == 1) {
                    this.initSkillList(this.myB.getMon());
                }
                this.getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
                this.getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
                return;
            }
        }
        var2_2 = 1;
        ** while (true)
    }

    private void goView() {
        this.select[0][1] = this.selectx;
        this.select[0][0] = this.selecty;
        this.cur_c = 0;
        this.popMenu = (byte)-1;
        this.setStringB("\u751f\u547d#n\u80fd\u91cf#n\u6863\u6b21", Constants_H.WIDTH, 0);
        this.setStringB("\u529b\u91cf#n\u9632\u5fa1#n\u654f\u6377", Constants_H.WIDTH, 1);
    }

    /*
     * Unable to fully structure code
     */
    private void hit_rate(Battle var1_1, Battle var2_2, Monster var3_3, Monster var4_4, int var5_5) {
        block9: {
            block10: {
                block8: {
                    var1_1.initHit();
                    var2_2.initHit();
                    this.hit_rate = var3_3.monsterPro[5] - var4_4.monsterPro[5];
                    this.hit_rate = this.hit_rate / 2 + 92 + var1_1.rate_off;
                    Ms.i();
                    var6_6 = (byte)Ms.getRandom((int)100);
                    var1_1.rate_off = 0;
                    if (var5_5 <= 26 || var5_5 >= 30) break block8;
                    switch (var5_5) lbl-1000:
                    // 2 sources

                    {
                        default: lbl-1000:
                        // 4 sources

                        {
                            return;
                        }
                        case 27: 
                        case 28: {
                            var1_1.addHit(-this.skill[var5_5][0] * 10, 1, 1);
                            ** GOTO lbl-1000
                        }
                        case 29: 
                    }
                    var2_2.addHit(var3_3.monsterPro[6] * this.skill[var5_5][0] + var3_3.monsterPro[1], 1, 0);
                    var1_1.addHit((int)var3_3.monsterPro[1], 4, 2);
                    ** GOTO lbl-1000
                }
                if (var6_6 >= this.hit_rate && (this.mini_state != 1 || var3_3.monster[2] >= 11)) break block9;
                this.damage(var1_1, var2_2, var3_3, var4_4, var5_5, this.mini_state ^ 1);
                if (var5_5 != 26 || var2_2.getMon().isMonReel(40)) break block10;
                Ms.i();
                if (Ms.getRandom((int)100) >= this.skill[var5_5][2]) break block10;
                var2_2.addHit(this.skill[var5_5][3] * var2_2.getMon().monster[6] / 100, -2, 2);
lbl29:
                // 3 sources

                while (true) {
                    if (var3_3.monster[3] == 2 && var3_3.isMonReel(34)) {
                        var2_2.addHit(var4_4.monsterPro[3] * this.skill[34][0] / 100, 4, 2);
                    }
                    ** GOTO lbl-1000
                    break;
                }
            }
            if (var5_5 >= 25 && var5_5 != 30) ** GOTO lbl29
            this.magicEffectRate(var2_2, var3_3, var4_4, var5_5);
            ** while (true)
        }
        var2_2.addHit(0, -1, 2);
        var1_1.rate_off = (byte)20;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private void hpAdd(int n, int n2) {
        if (this.myMonsters[this.select[0][0]].monsterPro[0] < this.myMonsters[this.select[0][0]].monsterPro[2] && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
            this.AddHP(n2 + this.myMonsters[this.select[0][0]].monsterPro[2] * n / 100, this.myMonsters[this.select[0][0]]);
            this.useState(0, this.select_it[0]);
            return;
        }
        if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u65e0\u6cd5\u4f7f\u7528\uff01", 0);
            return;
        }
        this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u4e0d\u9700\u8981\u4f7f\u7528\u8fd9\u4e2a\u9053\u5177", 0);
    }

    /*
     * Enabled force condition propagation
     */
    private void initMagicStream(int n) {
        if (this.magic[n] != null) {
            return;
        }
        String string = "data/battle/s" + n;
        this.magic[n] = Ms.i().createSprite(string, false);
    }

    /*
     * Handled impossible loop by adding 'first' condition
     */
    private void initOtherImage() {
        if (this.imgItem == null) {
            this.imgItem = new Image[2];
            this.imgItem[0] = Ms.i().createImage("data/ball");
            this.imgItem[1] = Ms.i().createImage("data/ll");
            this.initItemModules();
        }
        boolean bl = true;
        while (true) {
            int n;
            block7: {
                block6: {
                    block5: {
                        if (!bl || (bl = false)) break block5;
                        if (this.imgBG != null) break block6;
                        this.imgBG = new Image[5];
                        n = 0;
                    }
                    if (n < this.imgBG.length) break block7;
                }
                this.initImgIco();
                return;
            }
            this.imgBG[n] = Ms.i().createImage("data/battle/" + n);
            n = (byte)(n + 1);
        }
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isBagUse(int n) {
        if (this.view_state == -1) {
            if (n == 14) return false;
            if (n == 15) return false;
            return true;
        }
        if (n == 9) return false;
        if (n == 10) return false;
        if (n == 11) return false;
        if (n == 8) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    private byte isEvolveKind(byte by, byte by2) {
        int n = -1;
        if (by == 1 && by2 < 15) {
            return (byte)-2;
        }
        if (by == 2 && by2 < 25) {
            return (byte)-3;
        }
        int n2 = n;
        if (by != 3) return (byte)n2;
        n2 = n;
        if (by2 >= 30) return (byte)n2;
        return (byte)-4;
    }

    /*
     * Enabled force condition propagation
     */
    private byte isEvolveMake(int n) {
        byte by;
        int n2 = 2;
        byte by2 = this.monsterMake[n][0];
        do {
            if (this.findItem(-2, this.monsterMake[n][n2], true) < this.monsterMake[n][n2 + 1]) {
                return -1;
            }
            by = (byte)(n2 + 2);
            n2 = by;
        } while (by < this.monsterMake[n].length - 1);
        byte by3 = by2;
        if (by2 <= 0) return by3;
        by3 = by2;
        if (this.findItem(-2, 34, true) >= 1) return by3;
        return 0;
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isMonHp(Monster monster, int n) {
        if (monster.monsterPro[0] >= monster.monster[2] * n / 100) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isMyMonsters(int n) {
        byte by = 0;
        while (by < this.myMon_length) {
            if (by != n && this.myMonsters[by].monsterPro[0] > 0) {
                return true;
            }
            by = (byte)(by + 1);
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     */
    private byte isShuXing(Monster monster, Monster monster2) {
        if (monster.monster[3] == -1) {
            return (byte)30;
        }
        if (this.Shuxing[monster.monster[3]][0] == monster2.monster[3]) {
            return (byte)30;
        }
        if (this.Shuxing[monster.monster[3]][1] != monster2.monster[3]) return (byte)0;
        return (byte)0;
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isSkillToMe(int n) {
        if (n == 27) return true;
        if (n == 28) return true;
        return false;
    }

    /*
     * Unable to fully structure code
     */
    private void keyBattleState() {
        block13: {
            if (Ms.i().key_delay()) lbl-1000:
            // 29 sources

            {
                return;
            }
            switch (this.battle_state) {
                default: {
                    ** GOTO lbl-1000
                }
                case 2: {
                    if (!Ms.i().key_Left_Right()) ** GOTO lbl11
                    this.cur_a = Ms.i().select((int)this.cur_a, 0, this.action_str.length - 1);
                    ** GOTO lbl-1000
lbl11:
                    // 1 sources

                    if (!Ms.i().key_S1_Num5()) ** GOTO lbl-1000
                    if (this.cur_a != 0) ** GOTO lbl26
                    if (this.myB.getMon().monster[6] != 0) ** GOTO lbl16
                    this.say("\u5ba0\u7269\u5fe0\u8bda\u5ea6\u4e3a0\uff0c\u8bf7\u7acb\u523b\u8865\u5145\uff01", -1);
                    ** GOTO lbl-1000
lbl16:
                    // 1 sources

                    this.battle_state = (byte)3;
                    while (true) {
                        if (this.skill_list[this.lastSkill] > 30) ** GOTO lbl24
                        this.select[0][0] = this.lastSkill;
                        this.select[0][1] = (byte)(this.select[0][0] - 5);
                        if (this.select[0][1] < 1) {
                            this.select[0][1] = 0;
                        }
                        ** GOTO lbl-1000
lbl24:
                        // 1 sources

                        this.lastSkill = (byte)(this.lastSkill + 1);
                    }
lbl26:
                    // 1 sources

                    if (this.cur_a != 1) ** GOTO lbl32
                    if (this.myB.getMon().effect != 4) ** GOTO lbl30
                    this.say("\u7981\u9522\u4e2d\u65e0\u6cd5\u4f7f\u7528\u9053\u5177\uff01", -1);
                    ** GOTO lbl-1000
lbl30:
                    // 1 sources

                    this.goMY_BAG(0);
                    ** GOTO lbl-1000
lbl32:
                    // 1 sources

                    if (this.cur_a != 2) ** GOTO lbl39
                    if (this.myB.getMon().effect != 4) ** GOTO lbl36
                    this.say("\u7981\u9522\u4e2d\u65e0\u6cd5\u66f4\u6362\u5ba0\u7269\uff01", -1);
                    ** GOTO lbl-1000
lbl36:
                    // 1 sources

                    this.view_state = (byte)-2;
                    this.goVIEW_MONSTER();
                    ** GOTO lbl-1000
lbl39:
                    // 1 sources

                    if (this.cur_a != 3) ** GOTO lbl42
                    this.goBUY_ITEM(0, 0);
                    ** GOTO lbl-1000
lbl42:
                    // 1 sources

                    if (this.cur_a != 4) ** GOTO lbl-1000
                    if (this.battle_type != 4) ** GOTO lbl77
                    var2_1 = (short)(this.myB.getMon().monster[2] - this.enB.getMon().monster[2] + 60);
                    var1_2 = 0;
                    Ms.i();
                    if (Ms.getRandom((int)100) >= var2_1) ** GOTO lbl58
lbl49:
                    // 2 sources

                    while (this.myB.getMon().isMonReel(42)) {
                        var1_2 = 0;
lbl51:
                        // 3 sources

                        while (var1_2 == 0) {
                            this.arangeMonster();
                            this.setNullBattle();
                            this.goGO_RUNINMAP();
                            ** GOTO lbl-1000
                        }
                        ** GOTO lbl63
                    }
                    ** GOTO lbl60
lbl58:
                    // 1 sources

                    var1_2 = 1;
                    ** GOTO lbl49
lbl60:
                    // 1 sources

                    if (!this.myB.getMon().isEffect(3) && !this.myB.getMon().isEffect(4)) ** GOTO lbl51
                    var1_2 = 2;
                    ** GOTO lbl51
lbl63:
                    // 1 sources

                    if (var1_2 != true) ** GOTO lbl69
                    this.say("\u9003\u8dd1\u5931\u8d25\uff01", 1);
                    this.myB.act_num = 0;
                    this.enB.act_num = 1;
                    this.battle_state = (byte)9;
                    ** GOTO lbl-1000
lbl69:
                    // 1 sources

                    var4_3 = new StringBuilder("\u88ab\u602a\u7269");
                    if (!this.myB.getMon().isEffect(4)) ** GOTO lbl75
                    var3_4 = "\u7981\u9522\u4e2d";
lbl72:
                    // 2 sources

                    while (true) {
                        this.say(var4_3.append(var3_4).append("\uff0c").append("\u65e0\u6cd5\u9003\u8dd1\uff01").toString(), 1);
                        ** GOTO lbl-1000
                        break;
                    }
lbl75:
                    // 1 sources

                    var3_4 = "\u7684\u7535\u773c\u9b45\u60d1\u4e86";
                    ** continue;
lbl77:
                    // 1 sources

                    this.say("\u65e0\u6cd5\u9003\u8dd1\uff01", 0);
                    ** GOTO lbl-1000
                }
                case 3: {
                    if (!Ms.i().key_Up_Down()) ** GOTO lbl84
                    Ms.i().selectS(this.select[0], 0, (int)this.skill_list[8], 6);
                    this.lastSkill = this.select[0][0];
                    ** GOTO lbl-1000
lbl84:
                    // 1 sources

                    if (!Ms.i().key_S1_Num5()) ** GOTO lbl97
                    if (this.skill_list[this.select[0][0]] <= 30) ** GOTO lbl88
                    this.say("\u88ab\u52a8\u6280\u80fd\u65e0\u6cd5\u4f7f\u7528!", -1);
                    ** GOTO lbl-1000
lbl88:
                    // 1 sources

                    if (this.myB.getMon().effect != 6 || this.getSkillLevel(this.skill_list[this.select[0][0]]) <= 3) ** GOTO lbl91
                    this.say("\u5c01\u95ed\u6548\u679c\uff0c\u4e0d\u80fd\u4f7f\u75284\u7ea7\u4ee5\u4e0a\u6280\u80fd", -1);
                    ** GOTO lbl-1000
lbl91:
                    // 1 sources

                    if (this.myB.getMon().monsterPro[1] < this.getSkillMana(this.myB.getMon(), this.skill_list[this.select[0][0]])) ** GOTO lbl95
                    this.myB.skill = this.skill_list[this.select[0][0]];
                    this.battle_state = (byte)9;
                    ** GOTO lbl-1000
lbl95:
                    // 1 sources

                    this.say("\u9700\u8981\u7684\u6280\u80fd\u503c\u4e0d\u591f\uff01", -1);
                    ** GOTO lbl-1000
lbl97:
                    // 1 sources

                    if (!Ms.i().key_S2()) ** GOTO lbl-1000
                    this.battle_state = (byte)2;
                    ** GOTO lbl-1000
                }
                case 5: {
                    if (!Ms.i().key_Up_Down()) ** GOTO lbl104
                    Ms.i().selectS(this.select[0], 0, 6, (int)this.skill_list[8]);
                    ** GOTO lbl-1000
lbl104:
                    // 1 sources

                    if (Ms.i().key_S1_Num5() || !Ms.i().key_S2()) ** GOTO lbl-1000
                    this.battle_state = (byte)2;
                    ** GOTO lbl-1000
                }
                case 4: 
            }
            if (!Ms.i().key_Up_Down()) break block13;
            Ms.i().selectS(this.select[0], 0, 6, (int)this.skill_list[8]);
            ** GOTO lbl-1000
        }
        if (Ms.i().key_S1_Num5() || !Ms.i().key_S2()) ** GOTO lbl-1000
        this.battle_state = (byte)2;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void keyBuyItem() {
        block25: {
            block21: {
                block22: {
                    block24: {
                        block23: {
                            block20: {
                                block12: {
                                    block19: {
                                        block16: {
                                            block11: {
                                                block18: {
                                                    block17: {
                                                        block14: {
                                                            block15: {
                                                                block13: {
                                                                    if (Ms.i().key_delay()) lbl-1000:
                                                                    // 13 sources

                                                                    {
                                                                        return;
                                                                    }
                                                                    if (this.popMenu != -1) break block12;
                                                                    if (!Ms.i().key_Left_Right() || this.cur_b == 0) break block13;
                                                                    this.cur_a = Ms.i().select((int)this.cur_a, 0, 2);
                                                                    var6_1 = this.select[0];
                                                                    this.select[0][0] = 0;
                                                                    var6_1[1] = 0;
                                                                    ** GOTO lbl-1000
                                                                }
                                                                if (!Ms.i().key_Up_Down()) break block14;
                                                                var7_4 = Ms.i();
                                                                var6_2 = this.select[0];
                                                                if (this.cur_b != 1) break block15;
                                                                var2_5 = this.itemsLength[this.cur_a];
lbl17:
                                                                // 2 sources

                                                                while (true) {
                                                                    var7_4.selectS(var6_2, 0, var2_5, (int)this.list_rows);
                                                                    ** GOTO lbl-1000
                                                                    break;
                                                                }
                                                            }
                                                            var2_5 = this.buyItem[this.cur_a].length;
                                                            ** while (true)
                                                        }
                                                        if (!Ms.i().key_S1_Num5()) break block16;
                                                        this.popMenu = 1;
                                                        var3_8 = this.cur_a;
                                                        if (this.cur_b == 1) break block17;
                                                        var2_6 = this.select[0][0];
lbl29:
                                                        // 2 sources

                                                        while (this.cur_b != 1) {
                                                            var5_10 = true;
lbl31:
                                                            // 2 sources

                                                            while (true) {
                                                                this.sell_money = this.getPrice(var3_8, var2_6, var5_10);
                                                                var2_6 = this.cur_a;
                                                                var3_8 = this.select[0][0];
                                                                if (this.cur_b == 1) break block11;
                                                                var5_10 = true;
lbl37:
                                                                // 2 sources

                                                                while (true) {
                                                                    this.t_length = (byte)this.getBuyItemCount(var2_6, var3_8, var5_10);
                                                                    ** GOTO lbl-1000
                                                                    break;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                        break block18;
                                                    }
                                                    var2_6 = this.items[this.cur_a][this.select[0][0]][0];
                                                    ** GOTO lbl29
                                                }
                                                var5_10 = false;
                                                ** while (true)
                                            }
                                            var5_10 = false;
                                            ** while (true)
                                        }
                                        if (!Ms.i().key_S2()) ** GOTO lbl-1000
                                        this.buyItem = null;
                                        this.buyPrice = null;
                                        if (this.view_state != -1) break block19;
                                        this.goBattleState();
                                        ** GOTO lbl-1000
                                    }
                                    this.goGO_RUNINMAP();
                                    ** GOTO lbl-1000
                                }
                                if (this.buyOk != 0 || !Ms.i().key_Left_Right()) break block20;
                                this.popMenu = Ms.i().select((int)this.popMenu, 1, (int)this.t_length);
                                ** GOTO lbl-1000
                            }
                            if (!Ms.i().key_S1_Num5()) break block21;
                            if (this.buyOk != 1) break block22;
                            if (this.cur_b != 1) break block23;
                            this.money += this.sell_money * this.popMenu;
                            this.deleteItems(this.items[this.cur_a][this.select[0][0]][0], this.popMenu);
                            if (this.select[0][0] >= this.itemsLength[this.cur_a]) {
                                var6_3 = this.select[0];
                                var6_3[0] = var1_12 = (byte)(var6_3[0] - 1);
                                if (var1_12 < 0) {
                                    this.select[0][0] = 0;
                                }
                                var6_3 = this.select[0];
                                var6_3[1] = var1_12 = (byte)(var6_3[1] - 1);
                                if (var1_12 < 0) {
                                    this.select[0][1] = 0;
                                }
                            }
                            this.say("\u83b7\u5f97\u91d1\u94b1\uff1a" + this.sell_money * this.popMenu, 0);
lbl80:
                            // 3 sources

                            while (true) {
                                this.buyOk = 0;
                                this.popMenu = (byte)-1;
                                ** GOTO lbl-1000
                                break;
                            }
                        }
                        var3_9 = this.cur_a;
                        var2_7 = this.buyItem[this.cur_a][this.select[0][0]];
                        var4_13 = this.popMenu;
                        if (this.cur_a == 2) break block24;
                        var5_11 = true;
lbl90:
                        // 2 sources

                        while (true) {
                            if (!this.isMoneyItem(var3_9, var2_7, var4_13, var5_11) || this.addItem(this.buyItem[this.cur_a][this.select[0][0]], this.popMenu) == -1) ** GOTO lbl80
                            this.say("\u8d2d\u4e70\u6210\u529f", 0);
                            ** continue;
                            break;
                        }
                    }
                    var5_11 = false;
                    ** while (true)
                }
                this.buyOk = 1;
                ** GOTO lbl-1000
            }
            if (!Ms.i().key_S2()) ** GOTO lbl-1000
            if (this.buyOk != 0) break block25;
            this.popMenu = (byte)-1;
            ** GOTO lbl-1000
        }
        this.buyOk = 0;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void keyEvolveUI() {
        block11: {
            block6: {
                block10: {
                    block9: {
                        block8: {
                            block7: {
                                if (!Ms.i().key_S1_Num5() || this.b_c != 0) break block6;
                                var3_1 = this.myMonsters[this.selecty].monster[4];
                                var1_2 = this.myMonsters[this.selecty].monster[2];
                                var2_3 = this.myMonsters[this.selecty].monster[0];
                                var4_4 = this.isEvolveMake(var2_3);
                                if (this.isEvolveKind(var3_1, var1_2) != -1) {
                                    var4_4 = this.isEvolveKind(var3_1, var1_2);
                                }
                                if (var4_4 == 0) {
                                    this.myMonsters[this.selecty].evolveMonster(this, (int)this.monsterMake[var2_3][1], 1);
lbl10:
                                    // 6 sources

                                    while (true) {
                                        if (var4_4 > -1) {
                                            this.b_c = 1;
                                            this.setMagic(6);
                                            this.setShowPro(this.myMonsters[this.selecty]);
                                            this.popMenu = 0;
                                            this.delItemEvolve(var2_3);
                                            if (var4_4 > 0) {
                                                this.deleteItems(34, 1);
                                            }
                                        }
lbl19:
                                        // 8 sources

                                        return;
                                    }
                                }
                                if (var4_4 <= 0) break block7;
                                this.myMonsters[this.selecty].evolveMonster(this, (int)this.monsterMake[var2_3][0], (int)this.myMonsters[this.selecty].monster[5]);
                                ** GOTO lbl10
                            }
                            if (var4_4 != -1) break block8;
                            this.say("\u6750\u6599\u4e0d\u8db3\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01", 0);
                            this.popMenu = 1;
                            ** GOTO lbl10
                        }
                        if (var4_4 != -2) break block9;
                        this.say("\u7b49\u7ea7\u6ca1\u6709\u8fbe\u523015\u7ea7\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01", 0);
                        ** GOTO lbl10
                    }
                    if (var4_4 != -3) break block10;
                    this.say("\u7b49\u7ea7\u6ca1\u6709\u8fbe\u523025\u7ea7\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01", 0);
                    ** GOTO lbl10
                }
                this.say("\u7b49\u7ea7\u6ca1\u6709\u8fbe\u523030\u7ea7\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01", 0);
                ** while (true)
            }
            if (!Ms.i().key_S2()) break block11;
            this.goView();
            this.setShowPro(this.myMonsters[this.selecty]);
            ** GOTO lbl19
        }
        if (!Ms.i().key_Left_Right() || this.b_c > 0) ** GOTO lbl19
        this.popMenu = (byte)(this.popMenu ^ 1);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void keyGetSkill(Monster var1_1) {
        block5: {
            block4: {
                if (this.getSkill + 9 >= 35 && this.makeLevel[this.getSkill + 9 - 35] > this.rmsOther[3]) {
                    this.say("\u9700\u8981\u8bad\u7ec3\u5e08" + this.makeLevel[this.getSkill + 9 - 35] + "\u7ea7\u624d\u80fd\u5b66\u4e60\uff01", 0);
lbl3:
                    // 4 sources

                    return;
                }
                if (!var1_1.isMonReel((int)this.getSkill)) break block4;
                this.say(String.valueOf(this.getNameMon(var1_1.monster[0])) + "\u5df2\u62e5\u6709\u8be5\u6280\u80fd", 0);
                ** GOTO lbl3
            }
            if (var1_1.monster[14] == -1 || var1_1.monster[15] == -1) break block5;
            this.initSkillList(var1_1);
            this.bg_c = var1_1.monster[3];
            this.restMove(1, 0);
            this.say("\u8bf7\u9009\u62e9\u8981\u66ff\u6362\u7684\u6280\u80fd\uff01", 0);
            ** GOTO lbl3
        }
        if (var1_1.monster[14] == -1) {
            var1_1.monster[14] = this.getSkill;
lbl18:
            // 2 sources

            while (true) {
                this.delItemSkill(var1_1);
                ** continue;
                break;
            }
        }
        var1_1.monster[15] = this.getSkill;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void keyMY_BAG() {
        block3: {
            block6: {
                block9: {
                    block8: {
                        block7: {
                            block5: {
                                block4: {
                                    if (Ms.i().key_delay()) lbl-1000:
                                    // 10 sources

                                    {
                                        return;
                                    }
                                    if (this.popMenu != -1) break block3;
                                    if (!Ms.i().key_S1_Num5() || this.itemsLength[this.selectx] <= 0) break block4;
                                    this.popBagMenu(this.selectx, this.select[0][0]);
                                    ** GOTO lbl-1000
                                }
                                if (!Ms.i().key_Left_Right()) break block5;
                                this.selectx = Ms.i().select((int)this.selectx, 0, this.action_str.length - 1);
                                this.select[0][1] = this.select_st[this.selectx];
                                this.select[0][0] = this.select_it[this.selectx];
                                ** GOTO lbl-1000
                            }
                            if (!Ms.i().key_S2()) break block6;
                            if (this.mini_state != 9) break block7;
                            this.mini_state = (byte)5;
                            this.selecty = this.select_T;
                            this.selecty = 0;
                            this.goVIEW_MONSTER();
                            ** GOTO lbl-1000
                        }
                        if (this.view_state != -1) break block8;
                        this.mini_state = 1;
                        this.goBattleState();
                        this.initMonStream(2, this.mList_id[this.myMonsters[0].monster[0]][0], 1);
                        this.itemMine = null;
                        ** GOTO lbl-1000
                    }
                    if (this.view_state != 2) break block9;
                    GameRun.run_state = -10;
                    GameRun.mc.paint();
                    this.goNidus(0);
                    ** GOTO lbl-1000
                }
                this.doPaint(0);
                this.goYouPAUSE(2);
                this.itemMine = null;
                ** GOTO lbl-1000
            }
            if (!Ms.i().key_Up_Down()) ** GOTO lbl-1000
            if (this.itemsLength[this.selectx] > 0) {
                Ms.i().selectS(this.select[0], 0, (int)this.itemsLength[this.selectx], (int)this.list_rows);
            }
            this.select_it[this.selectx] = this.select[0][0];
            this.select_st[this.selectx] = this.select[0][1];
            ** GOTO lbl-1000
        }
        this.popBagState();
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void keyMagicUI() {
        block9: {
            block8: {
                block7: {
                    block6: {
                        block4: {
                            block5: {
                                if (!Ms.i().key_S1_Num5() || this.mini_state != 13) break block4;
                                if (this.skill_list[this.select[0][0]] <= 25) {
                                    this.say("\u8be5\u6280\u80fd\u4e0d\u80fd\u66ff\u6362\uff01", 0);
lbl4:
                                    // 9 sources

                                    return;
                                }
                                if (this.skill_list[this.select[0][0]] != this.myMonsters[this.selecty].monster[14]) break block5;
                                this.myMonsters[this.selecty].monster[14] = this.getSkill;
lbl8:
                                // 2 sources

                                while (true) {
                                    this.delItemSkill(this.myMonsters[this.selecty]);
                                    ** GOTO lbl4
                                    break;
                                }
                            }
                            this.myMonsters[this.selecty].monster[15] = this.getSkill;
                            ** while (true)
                        }
                        if (!Ms.i().key_S2()) break block6;
                        this.select[0][1] = this.selectx;
                        this.select[0][0] = this.selecty;
                        this.cur_c = 0;
                        this.popMenu = (byte)-1;
                        ** GOTO lbl4
                    }
                    if (!Ms.i().key_Left_Right() || this.mini_state == 13) break block7;
                    this.popMenu = (byte)(this.popMenu ^ 1);
                    var1_1 = this.select[0];
                    this.select[0][0] = 0;
                    var1_1[1] = 0;
                    ** GOTO lbl4
                }
                if (!Ms.i().key_Up_Down()) ** GOTO lbl4
                this.introX = Constants_H.WIDTH_H;
                if (this.popMenu != 0) break block8;
                Ms.i().selectS(this.select[0], 0, (int)this.skill_list[8], 5);
                ** GOTO lbl4
            }
            if (this.mini_state != 6) break block9;
            if (this.cMonsters[this.selecty].monster[17] > 0) {
                var1_2 = this.select[0];
                var1_2[0] = (byte)(var1_2[0] ^ 1);
            }
            ** GOTO lbl4
        }
        if (this.myMonsters[this.selecty].monster[17] <= 0) ** GOTO lbl4
        var1_3 = this.select[0];
        var1_3[0] = (byte)(var1_3[0] ^ 1);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void keyNidus() {
        block10: {
            block11: {
                block13: {
                    block12: {
                        block8: {
                            block9: {
                                block2: {
                                    block4: {
                                        block7: {
                                            block5: {
                                                block6: {
                                                    block3: {
                                                        if (Ms.i().key_delay()) lbl-1000:
                                                        // 19 sources

                                                        {
                                                            return;
                                                        }
                                                        if (this.mini_state != 16) break block2;
                                                        if (!Ms.i().key_Up_Down()) break block3;
                                                        this.popMenu = Ms.i().select((int)this.popMenu, 0, this.about_d.length - 1);
                                                        ** GOTO lbl-1000
                                                    }
                                                    if (!Ms.i().key_S1_Num5()) break block4;
                                                    if (!Ms.i().equals(this.about_d[this.popMenu], "\u67e5\u770b\u5b75\u5316")) break block5;
                                                    this.mini_state = (byte)17;
                                                    this.popMenu = 0;
                                                    this.initMonStream(0, 56, 1);
                                                    if (this.getRid(this.popMenu) != -2) break block6;
                                                    this.bg_c = this.popMenu;
                                                    ** GOTO lbl-1000
                                                }
                                                this.bg_c = this.monster_pro[this.getNid(this.popMenu)][6];
                                                this.mon_action = (byte)(this.bg_c + 23);
                                                ** GOTO lbl-1000
                                            }
                                            if (!Ms.i().equals(this.about_d[this.popMenu], "\u9009\u62e9\u86cb")) break block7;
                                            this.view_state = (byte)2;
                                            this.goMY_BAG(3);
                                            ** GOTO lbl-1000
                                        }
                                        if (!Ms.i().equals(this.about_d[this.popMenu], "\u79bb\u5f00")) ** GOTO lbl-1000
                                        this.exitNidus();
                                        ** GOTO lbl-1000
                                    }
                                    if (!Ms.i().key_S2()) ** GOTO lbl-1000
                                    this.exitNidus();
                                    ** GOTO lbl-1000
                                }
                                if (this.b_c != -2 || !Ms.i().key_Left_Right()) break block8;
                                this.popMenu = Ms.i().select((int)this.popMenu, 0, 4);
                                if (this.getRid(this.popMenu) != -2) break block9;
                                this.bg_c = this.popMenu;
                                ** GOTO lbl-1000
                            }
                            this.bg_c = this.monster_pro[this.getNid(this.popMenu)][6];
                            this.mon_action = (byte)(this.bg_c + 23);
                            ** GOTO lbl-1000
                        }
                        if (!Ms.i().key_S1_Num5()) break block10;
                        if (this.getRid(this.popMenu) == -2) ** GOTO lbl-1000
                        if (this.b_c != -2 || this.getNexp(this.popMenu, 1) != this.getNexp(this.popMenu, 3)) break block11;
                        if (this.cMon_count != this.max_monsters || this.myMon_length != this.max_takes) break block12;
                        this.say("\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1", 0);
                        ** GOTO lbl-1000
                    }
                    if (this.isEvolveMake(this.getNid(this.popMenu)) != 0) break block13;
                    this.mon_action = (byte)(this.bg_c + 28);
                    this.b_c = 1;
                    this.setNidusPro(this.getNid(this.popMenu), 1);
                    this.delItemEvolve(this.getNid(this.popMenu));
                    ** GOTO lbl-1000
                }
                this.say("\u6750\u6599\u4e0d\u8db3\uff0c\u4e0d\u80fd\u5b75\u5316", 0);
                ** GOTO lbl-1000
            }
            if (this.b_c != -1) ** GOTO lbl-1000
            this.b_c = (byte)-2;
            this.getMonster(this.getNid(this.popMenu), this.getNLevel(this.popMenu), -2, -1);
            this.delNidus(this.popMenu);
            this.initMonStream(0, 56, 1);
            ** GOTO lbl-1000
        }
        if (this.b_c != -2 || !Ms.i().key_S2()) ** GOTO lbl-1000
        this.exitNidus();
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void key_MONSTER_LIST(Monster[] var1_1) {
        block11: {
            block20: {
                block29: {
                    block27: {
                        block28: {
                            block22: {
                                block24: {
                                    block25: {
                                        block26: {
                                            block23: {
                                                block21: {
                                                    block12: {
                                                        block19: {
                                                            block18: {
                                                                block13: {
                                                                    block16: {
                                                                        block17: {
                                                                            block15: {
                                                                                block14: {
                                                                                    if (this.popMenu != -1) break block11;
                                                                                    if (!Ms.i().key_S1_Num5() || this.t_length == 0) break block12;
                                                                                    if (this.view_state != 1) break block13;
                                                                                    if (this.mini_state == 15) {
                                                                                        this.useItem();
lbl6:
                                                                                        // 18 sources

                                                                                        return;
                                                                                    }
                                                                                    if (this.mini_state != 13) break block14;
                                                                                    this.keyGetSkill(var1_1[this.select[0][0]]);
                                                                                    ** GOTO lbl6
                                                                                }
                                                                                var3_2 = new StringBuffer("\u5929\u8d4b#n\u6280\u80fd");
                                                                                if (this.mini_state != 4) break block15;
                                                                                if (var1_1[this.select[0][0]].monster[5] > 0) {
                                                                                    var3_2.append("#n\u8fdb\u5316");
                                                                                }
                                                                                if (this.t_length > 1) {
                                                                                    var3_2.append("#n\u5b58\u653e#n\u5356\u5ba0");
                                                                                }
lbl20:
                                                                                // 7 sources

                                                                                while (true) {
                                                                                    this.setStringB(var3_2.toString(), Constants_H.WIDTH, 3);
                                                                                    this.popMenu = 0;
                                                                                    ** GOTO lbl6
                                                                                    break;
                                                                                }
                                                                            }
                                                                            if (this.mini_state != 6) break block16;
                                                                            if (this.map.gmErr) break block17;
                                                                            var3_2.append("#n\u53d6\u51fa#n\u5356\u5ba0");
                                                                            ** GOTO lbl20
                                                                        }
                                                                        var3_2.append("#n\u5356\u5ba0");
                                                                        ** GOTO lbl20
                                                                    }
                                                                    if (this.select[0][0] != 0) {
                                                                        var3_2.append("#n\u53c2\u6218");
                                                                    }
                                                                    if (var1_1[this.select[0][0]].monster[5] > 0) {
                                                                        var3_2.append("#n\u8fdb\u5316");
                                                                    }
                                                                    if (this.t_length <= 1) ** GOTO lbl20
                                                                    var3_2.append("#n\u653e\u751f");
                                                                    ** while (true)
                                                                }
                                                                if (this.view_state >= 0) ** GOTO lbl6
                                                                if (this.mini_state != 15) break block18;
                                                                this.useItem();
                                                                ** GOTO lbl6
                                                            }
                                                            if (this.select[0][0] == 0) break block19;
                                                            this.setStringB("\u53c2\u6218#n\u6280\u80fd", Constants_H.WIDTH, 3);
lbl53:
                                                            // 2 sources

                                                            while (true) {
                                                                this.popMenu = 0;
                                                                ** GOTO lbl6
                                                                break;
                                                            }
                                                        }
                                                        this.setStringB("\u6280\u80fd", Constants_H.WIDTH, 3);
                                                        ** while (true)
                                                    }
                                                    if (!Ms.i().key_S2()) break block20;
                                                    if (this.mini_state != 13) break block21;
                                                    this.goMY_BAG(2);
                                                    ** GOTO lbl6
                                                }
                                                if (this.view_state != 1) break block22;
                                                if (this.mini_state != 15) break block23;
                                                this.goMY_BAG(0);
                                                this.mini_state = (byte)3;
                                                ** GOTO lbl6
                                            }
                                            if (this.mini_state != 6 && this.mini_state != 4) break block24;
                                            if (this.map.gmErr) break block25;
                                            this.doPaint(0);
                                            if (this.mini_state != 6) break block26;
                                            var2_3 = 1;
lbl76:
                                            // 2 sources

                                            while (true) {
                                                this.goVIEW_COMPUTER(var2_3);
                                                ** GOTO lbl6
                                                break;
                                            }
                                        }
                                        var2_3 = 0;
                                        ** while (true)
                                    }
                                    this.map.bkEvent_getMon();
                                    ** GOTO lbl6
                                }
                                this.doPaint(0);
                                this.goYouPAUSE(1);
                                ** GOTO lbl6
                            }
                            if (this.view_state != -2) break block27;
                            if (var1_1[0].monsterPro[0] <= 0) break block28;
                            if (this.select[0][0] != 0) {
                                this.initMonStream(2, this.mList_id[var1_1[0].monster[0]][0], 1);
                            }
                            this.goBattleState();
lbl95:
                            // 2 sources

                            while (true) {
                                this.view_state = (byte)-1;
                                ** GOTO lbl6
                                break;
                            }
                        }
                        this.say("\u5f53\u524d\u5ba0\u7269\u4e0d\u80fd\u53c2\u6218", 0);
                        ** while (true)
                    }
                    if (this.view_state != -1) ** GOTO lbl6
                    if (this.mini_state != 15) break block29;
                    this.goMY_BAG(0);
                    ** GOTO lbl6
                }
                this.say("\u5f53\u524d\u5ba0\u7269\u4e0d\u80fd\u53c2\u6218", 0);
                ** GOTO lbl6
            }
            if (!Ms.i().key_Up_Down() || this.t_length == 0) ** GOTO lbl6
            Ms.i().selectS(this.select[0], 0, (int)this.t_length, (int)this.list_rows);
            this.initMonStream(2, this.mList_id[var1_1[this.select[0][0]].monster[0]][0], 1);
            this.setShowPro(var1_1[this.select[0][0]]);
            this.introT = Constants_H.WIDTH_H;
            ** GOTO lbl6
        }
        this.popState();
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private boolean level_up(int var1_1, int var2_2) {
        block10: {
            block11: {
                block12: {
                    block9: {
                        if (var2_2 != 0) break block9;
                        var2_2 = this.myMonsters[var1_1].monster[2];
                        Ms.i();
                        var5_3 = (byte)(var2_2 - Ms.skip2);
                        var2_2 = 0;
                        Ms.i();
                        Ms.skip = this.exp;
                        if (this.myMonsters[var1_1].isMonReel(36)) {
                            var2_2 = (short)(0 + 100);
                        }
                        var4_4 = var2_2;
                        if (this.myMonsters[var1_1].isMonReel(37)) {
                            var4_4 = (short)(var2_2 + 200);
                        }
                        if (var5_3 < 0) {
                            var2_2 = 0;
lbl17:
                            // 3 sources

                            while (true) {
                                Ms.i();
                                Ms.i();
                                Ms.skip = (short)(Ms.skip * (9 - var2_2 * 2) * (var4_4 + 100) / 1000);
                                Ms.i();
                                if (Ms.skip < 1) {
                                    Ms.i();
                                    Ms.i();
                                    Ms.skip = Ms.getRandom((int)6) + 5;
                                }
                                if (this.battle_type == 3 || this.battle_type == 0) {
                                    Ms.i();
                                    Ms.i();
                                    Ms.skip = (short)(Ms.skip * 3 / 2);
                                }
                                var7_5 = this.proReplace[var1_1];
                                Ms.i();
                                var7_5[2] = (short)Ms.skip;
lbl41:
                                // 6 sources

                                while (true) {
                                    var6_7 = true;
lbl43:
                                    // 2 sources

                                    return var6_7;
                                }
                                break;
                            }
                        }
                        var2_2 = var5_3;
                        if (var5_3 <= 4) ** GOTO lbl17
                        var2_2 = 5;
                        ** while (true)
                    }
                    if (var2_2 != 1) break block10;
                    if (this.myMonsters[var1_1].monster[2] >= 60) break block11;
                    Ms.i();
                    if (Ms.skip <= 0) break block11;
                    var3_8 = this.getMonsterExp(this.myMonsters[var1_1]);
                    var2_2 = this.myMonsters[var1_1].monsterPro[4];
                    Ms.i();
                    var2_2 = (short)(var2_2 + Ms.skip);
                    if (var2_2 < var3_8) break block12;
                    this.myB.cexp = this.myMonsters[var1_1].monsterPro[4];
                    this.myMonsters[var1_1].monsterPro[4] = var3_8;
                    Ms.i();
                    Ms.skip = (short)(var2_2 - var3_8);
                    ** GOTO lbl41
                }
                this.myB.cexp = this.myMonsters[var1_1].monsterPro[4];
                var7_6 = this.myMonsters[var1_1].monsterPro;
                var1_1 = var7_6[4];
                Ms.i();
                var7_6[4] = (short)(var1_1 + Ms.skip);
                Ms.i();
                Ms.skip = -1;
                ** GOTO lbl41
            }
            Ms.i();
            Ms.skip = -1;
            this.proReplace[var1_1][2] = 0;
            ** GOTO lbl41
        }
        if (var2_2 != 2) ** GOTO lbl41
        Ms.i();
        if (Ms.skip > -1) {
            this.levelPro(var1_1, false);
            this.getMagic(this.myMonsters[var1_1]);
            this.levelUp_in_battle[this.myMonsters[var1_1].monster[1]][0] = 1;
            this.levelUp_in_battle[this.myMonsters[var1_1].monster[1]][1] = this.getSkill;
            this.myMonsters[var1_1].monsterPro[4] = 0;
            ** continue;
        }
        var6_7 = false;
        ** while (true)
    }

    private void loadGame() {
        this.map.firstDrawMap = 0;
        this.buyOk = 0;
        this.map.mapImg = null;
        System.out.println("loadGame 111111111111");
        mc.goGameLoading();
        System.out.println("loadGame 22222222222");
    }

    /*
     * Unable to fully structure code
     */
    private boolean magicEffectRate(Battle var1_1, Monster var2_2, Monster var3_3, int var4_4) {
        block6: {
            block8: {
                block19: {
                    block18: {
                        block16: {
                            block17: {
                                block7: {
                                    block15: {
                                        block14: {
                                            block12: {
                                                block13: {
                                                    block10: {
                                                        block11: {
                                                            block9: {
                                                                if (var3_3.effect != 7) {
                                                                    var8_5 = false;
lbl3:
                                                                    // 4 sources

                                                                    return var8_5;
                                                                }
                                                                var5_6 = this.skill[var4_4][3];
                                                                var7_7 = this.skill[var4_4][2];
                                                                if (var7_7 != 0) break block9;
                                                                var8_5 = false;
                                                                ** GOTO lbl3
                                                            }
                                                            if (var5_6 != 0) break block10;
                                                            if (!var3_3.isBuffRate(5)) break block11;
                                                            var6_8 = (byte)(this.inhesion[5] + var7_7);
lbl14:
                                                            // 10 sources

                                                            while (true) {
                                                                Ms.i();
                                                                if (Ms.getRandom((int)100) >= var6_8) break block6;
                                                                var3_3.effect = var5_6;
                                                                if (var5_6 != 3 && var5_6 != 4 && var5_6 != 5) break block7;
                                                                var3_3.effect_time = (byte)4;
lbl21:
                                                                // 6 sources

                                                                while (true) {
                                                                    if (var5_6 != 5) ** GOTO lbl27
                                                                    if (!var2_2.isMonReel(31)) break block8;
                                                                    var6_8 = this.skill[31][0];
lbl25:
                                                                    // 2 sources

                                                                    while (true) {
                                                                        var1_1.fs_level = (byte)(var6_8 + var4_4);
lbl27:
                                                                        // 2 sources

                                                                        var8_5 = true;
                                                                        ** GOTO lbl3
                                                                        break;
                                                                    }
                                                                    break;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                        var6_8 = var7_7;
                                                        if (!var3_3.isBuffRate(6)) ** GOTO lbl14
                                                        var6_8 = (byte)(this.inhesion[6] + var7_7);
                                                        ** GOTO lbl14
                                                    }
                                                    if (var5_6 != 4) break block12;
                                                    if (!var3_3.isBuffRate(7)) break block13;
                                                    var6_8 = (byte)(this.inhesion[7] + var7_7);
                                                    ** GOTO lbl14
                                                }
                                                var6_8 = var7_7;
                                                if (!var3_3.isBuffRate(8)) ** GOTO lbl14
                                                var6_8 = (byte)(this.inhesion[8] + var7_7);
                                                ** GOTO lbl14
                                            }
                                            if (var5_6 == 2) break block14;
                                            var6_8 = var7_7;
                                            if (var5_6 != 5) ** GOTO lbl14
                                        }
                                        if (!var3_3.isBuffRate(11)) break block15;
                                        var6_8 = (byte)(this.inhesion[11] + var7_7);
                                        ** GOTO lbl14
                                    }
                                    var6_8 = var7_7;
                                    if (!var3_3.isBuffRate(12)) ** GOTO lbl14
                                    var6_8 = (byte)(this.inhesion[12] + var7_7);
                                    ** while (true)
                                }
                                if (var5_6 != 2) break block16;
                                if (!var2_2.isMonReel(32)) break block17;
                                var6_8 = 5;
lbl61:
                                // 2 sources

                                while (true) {
                                    var3_3.effect_time = (byte)var6_8;
                                    ** GOTO lbl21
                                    break;
                                }
                            }
                            var6_8 = 4;
                            ** while (true)
                        }
                        if (var5_6 != 0) break block18;
                        var3_3.effect_time = (byte)2;
                        ** GOTO lbl21
                    }
                    if (var5_6 != 6) ** GOTO lbl21
                    if (var3_3.monster[3] != -1) break block19;
                    var3_3.effect = (byte)7;
                    this.say("\u5c01\u95ed\u6548\u679c\uff0c\u5bf9\u5e7d\u6697\u9b3c\u738b\u4e0d\u8d77\u4f5c\u7528", -1);
                    ** GOTO lbl21
                }
                var3_3.effect_time = (byte)4;
                ** while (true)
            }
            var6_8 = 1;
            ** while (true)
        }
        var8_5 = false;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private byte monsterRemove(int var1_1) {
        if (this.myMon_length > 1) {
            this.myMonsters[var1_1] = null;
            var1_1 = (byte)var1_1;
            block0: while (true) {
                if (var1_1 >= this.myMon_length - 1) {
                    var1_1 = this.myMon_length;
lbl7:
                    // 2 sources

                    while (true) {
                        if (var1_1 < this.myMonsters.length) break block0;
                        this.myMon_length = (byte)(this.myMon_length - 1);
                        var2_2 = 1;
lbl11:
                        // 2 sources

                        return var2_2;
                    }
                }
                this.myMonsters[var1_1] = this.myMonsters[var1_1 + 1];
                this.evolve[var1_1] = this.evolve[var1_1 + 1];
                var1_1 = (byte)(var1_1 + 1);
            }
            this.evolve[var1_1] = true;
            var1_1 = (byte)(var1_1 + 1);
            ** continue;
        }
        var2_2 = -1;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private void mpAdd(int n) {
        if (this.myMonsters[this.select[0][0]].monsterPro[1] < this.myMonsters[this.select[0][0]].monsterPro[3] && this.myMonsters[this.select_T].monsterPro[0] > 0) {
            this.AddMP(this.myMonsters[this.select[0][0]].monsterPro[3] * n / 100, this.myMonsters[this.select[0][0]]);
            this.useState(0, this.select_it[0]);
            return;
        }
        if (this.myMonsters[this.select[0][0]].monsterPro[1] < 1) {
            this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u65e0\u6cd5\u4f7f\u7528\uff01", 0);
            return;
        }
        this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u4e0d\u9700\u8981\u4f7f\u7528\u8fd9\u4e2a\u9053\u5177", 0);
    }

    private void paintBATTLE_OVER() {
        if (this.b_c == 1) {
            this.drawEvolveUI(0, this.myB.now_id, false);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void paintBattleState(Graphics var1_1) {
        block9: {
            switch (this.battle_state) lbl-1000:
            // 7 sources

            {
                default: lbl-1000:
                // 4 sources

                {
                    return;
                }
                case -1: {
                    this.drawAnimationBattle(this.am, this.mini_state);
                    ** GOTO lbl-1000
                }
                case 3: {
                    Ui.i().drawK0(320 - 150, 50, 300, 193, 0);
                    Ui.i().sliding(320 + 125, 60, 173, (int)this.select[0][0], (int)this.skill_list[8], false);
                    this.drawSkillList(320 - 150 + 10, 60, 250, 28, 6, this.select[0]);
                    this.showStringM(this.skill_help[this.skill_list[this.select[0][0]]].toString(), 320, 269, 7, 0);
                    Ui.i().drawYesNo(true, true);
                    ** GOTO lbl-1000
                }
                case -2: {
                    if (!this.drawHitOne(this.dm, this.am, this.getBXY(this.mini_state, this.am.skill, true) - 15, this.getBXY(this.mini_state, this.am.skill, false) - 34) || !this.drawHitOne(this.am, this.dm, this.getBXY(this.mini_state ^ 1, 25, true) - 15, this.getBXY(this.mini_state ^ 1, 25, false) - 34) || !this.runHitToState(this.am, this.dm, this.mini_state)) ** GOTO lbl-1000
                    this.battle_state = (byte)-3;
                    this.am.initHit();
                    this.doEffectValue(this.am);
                    this.doBuffValue(this.am);
                    ** GOTO lbl-1000
                }
                case -3: {
                    if (!this.drawHitOne(this.am, this.dm, this.getBXY(this.mini_state ^ 1, 25, true) - 15, this.getBXY(this.mini_state ^ 1, 25, false) - 34) || !this.runHitToState(this.dm, this.am, this.mini_state ^ 1)) ** GOTO lbl-1000
                    this.battle_state = (byte)9;
                    this.effectR(this.dm.getMon());
                    ** GOTO lbl-1000
                }
                case -5: 
            }
            if (this.proReplace[this.myB.now_id][2] <= -1) break block9;
            var1_1 /* !! */  = String.valueOf(this.getNameMon(this.myMonsters[this.myB.now_id].monster[0])) + "\u83b7\u5f97\u7ecf\u9a8c\uff1a";
            Log.e((String)"sk", (String)"\u83b7\u5f97\u7ecf\u9a8c");
            Ui.i().drawString((String)var1_1 /* !! */ , 204, 308, 36, 1, 0);
            Ui.i().drawNum("" + this.proReplace[this.myB.now_id][2], 220, 315, 0, 1);
            ** GOTO lbl-1000
        }
        if (this.proReplace[this.myB.now_id][2] != -1) ** GOTO lbl-1000
        Ui.i().drawString("\u60a8\u7684\u5ba0\u7269\u5df2\u7ecf\u65e0\u6cd5\u83b7\u5f97\u7ecf\u9a8c", 204, 282, 36, 7, 0);
        Ms.i().sleep(600);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void popBagMenu(int var1_1, int var2_2) {
        block2: {
            var4_3 = "\u8fd4\u56de";
            var2_2 = this.items[var1_1][var2_2][0];
            if ((var1_1 == 0 || var2_2 == 32 || var2_2 == 33) && this.isBagUse(var2_2)) {
                var3_4 = "\u4f7f\u7528#n\u8fd4\u56de";
lbl5:
                // 5 sources

                while (true) {
                    this.setStringB(var3_4, Constants_H.WIDTH, 0);
                    this.popMenu = 0;
                    return;
                }
            }
            if (var1_1 != 2) break block2;
            var3_4 = "\u5b66\u4e60#n\u8fd4\u56de";
            ** GOTO lbl5
        }
        var3_4 = var4_3;
        if (this.view_state != 2) ** GOTO lbl5
        var3_4 = var4_3;
        if (var1_1 != 3) ** GOTO lbl5
        var3_4 = "\u5b75\u5316#n\u8fd4\u56de";
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void popBagState() {
        block21: {
            block29: {
                block30: {
                    block28: {
                        block22: {
                            block24: {
                                block19: {
                                    block27: {
                                        block20: {
                                            block26: {
                                                block18: {
                                                    block25: {
                                                        block17: {
                                                            block23: {
                                                                if (Ms.i().key_Up_Down()) {
                                                                    this.popMenu = Ms.i().select((int)this.popMenu, 0, this.about_a.length - 1);
                                                                }
                                                                if (!Ms.i().key_S1_Num5()) break block21;
                                                                var2_1 = this.items[this.selectx][this.select[0][0]][0];
                                                                if (!Ms.i().equals(this.about_a[this.popMenu], "\u4f7f\u7528")) break block22;
                                                                switch (var2_1) {
                                                                    default: {
                                                                        this.goVIEW_MONSTER();
                                                                        this.mini_state = (byte)15;
lbl10:
                                                                        // 10 sources

                                                                        while (true) {
                                                                            Ms.i().correctSelect(this.select[0], (int)this.itemsLength[this.selectx], (int)this.list_rows);
lbl12:
                                                                            // 3 sources

                                                                            return;
                                                                        }
                                                                    }
                                                                    case 9: 
                                                                    case 10: 
                                                                    case 11: {
                                                                        if (this.battle_type != 4 && this.battle_type != 1) ** GOTO lbl18
                                                                        this.goCatchMonster();
                                                                        ** GOTO lbl10
lbl18:
                                                                        // 1 sources

                                                                        this.say("\u7279\u6b8a\u60c5\u51b5\uff0c\u65e0\u6cd5\u6355\u83b7\uff01", 1);
                                                                        Ms.i().sleep(400);
                                                                        ** GOTO lbl10
                                                                    }
                                                                    case 14: 
                                                                    case 15: {
                                                                        this.popMenu = (byte)-1;
                                                                        if (this.map.notMeet != 0) ** GOTO lbl28
                                                                        this.map.notMeet(1, var2_1);
                                                                        this.say("\u4f7f\u7528" + this.getNameItem(var2_1) + "\uff0c" + "\u83b7\u5f97\u4e86" + "\u8eb2\u907f\u602a\u7269\u6548\u679c", 1);
                                                                        this.deleteItems(var2_1, 1);
                                                                        ** GOTO lbl10
lbl28:
                                                                        // 1 sources

                                                                        if (this.map.notMeet != 1) ** GOTO lbl10
                                                                        this.say("\u5df2\u62e5\u6709\u8eb2\u907f\u602a\u7269\u6548\u679c", 0);
                                                                        ** GOTO lbl10
                                                                    }
                                                                    case 32: 
                                                                    case 33: 
                                                                }
                                                                if (var2_1 != 32) break block23;
                                                                var1_2 = 33;
lbl34:
                                                                // 2 sources

                                                                while (this.findItem(-2, var1_2, true) > 0) {
                                                                    this.deleteItems(32, 1);
                                                                    this.deleteItems(33, 1);
                                                                    var1_2 = 3;
                                                                    var2_1 = 1;
                                                                    var3_3 = -1;
                                                                    Ms.i();
                                                                    var4_4 = (byte)Ms.getRandom((int)100);
                                                                    if (var4_4 >= 70) break block17;
                                                                    var1_2 = 0;
lbl45:
                                                                    // 4 sources

                                                                    while (true) {
                                                                        Ms.i();
                                                                        var4_4 = (byte)Ms.getRandom((int)100);
lbl49:
                                                                        // 2 sources

                                                                        while (true) {
                                                                            if (var2_1 < this.itemMine[var1_2].length) break block18;
                                                                            var2_1 = var3_3;
lbl52:
                                                                            // 2 sources

                                                                            while (var2_1 == 34 && this.findItem(-2, var2_1, true) > 0) {
                                                                                var1_2 = -1;
lbl54:
                                                                                // 3 sources

                                                                                while (var1_2 != -1) {
                                                                                    this.addItem(var1_2, 1);
                                                                                    this.say("\u83b7\u5f97\uff1a" + this.getNameItem(var1_2) + "x1", 0);
lbl58:
                                                                                    // 3 sources

                                                                                    while (true) {
                                                                                        this.popMenu = (byte)-1;
                                                                                        ** GOTO lbl10
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                break block19;
                                                                            }
                                                                            break block20;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    }
                                                                }
                                                                break block24;
                                                            }
                                                            var1_2 = 32;
                                                            ** GOTO lbl34
                                                        }
                                                        if (var4_4 >= 85) break block25;
                                                        var1_2 = 1;
                                                        ** GOTO lbl45
                                                    }
                                                    if (var4_4 >= 95) ** GOTO lbl45
                                                    var1_2 = 2;
                                                    ** while (true)
                                                }
                                                if (var4_4 >= this.itemMine[var1_2][var2_1]) break block26;
                                                var2_1 = this.itemMine[var1_2][var2_1 - 1];
                                                ** GOTO lbl52
                                            }
                                            var2_1 = (byte)(var2_1 + 2);
                                            ** while (true)
                                        }
                                        if (var2_1 == -1) break block27;
                                        var1_2 = var2_1;
                                        if (this.findItem(-2, var2_1, true) < 99) ** GOTO lbl54
                                    }
                                    var1_2 = -1;
                                    ** GOTO lbl54
                                }
                                this.say("\u8fd9\u4e2a\u5b9d\u7bb1\u662f\u7a7a\u7684\u3002", 0);
                                ** GOTO lbl58
                            }
                            var6_5 = new StringBuilder("\u6ca1\u6709");
                            if (var2_1 == 32) {
                                var5_6 = "\u94a5\u5319\uff0c\u94a5\u5319\u5728\u5546\u5e97\u4e2d\u53ef\u4ee5\u8d2d\u4e70\u3002";
lbl96:
                                // 2 sources

                                while (true) {
                                    this.say(var6_5.append(var5_6).toString(), 0);
                                    ** continue;
                                    break;
                                }
                            }
                            var5_6 = "\u5b9d\u7bb1\uff0c\u5b9d\u7bb1\u5728\u6218\u6597\u540e\u4e00\u5b9a\u51e0\u7387\u83b7\u5f97\u3002";
                            ** while (true)
                        }
                        if (!Ms.i().equals(this.about_a[this.popMenu], "\u5b66\u4e60")) break block28;
                        this.mini_state = (byte)13;
                        this.getSkill = (byte)(var2_1 - 9);
                        this.goVIEW_MONSTER();
                        ** GOTO lbl10
                    }
                    if (!Ms.i().equals(this.about_a[this.popMenu], "\u5b75\u5316")) break block29;
                    if (!this.addNidus(var2_1 - 58)) break block30;
                    this.deleteItems(var2_1, 1);
                    this.select_it[this.selectx] = this.select[0][0];
                    this.select_st[this.selectx] = this.select[0][1];
lbl113:
                    // 2 sources

                    while (true) {
                        this.popMenu = (byte)-1;
                        ** GOTO lbl10
                        break;
                    }
                }
                this.say("\u5b75\u5316\u6240\u5df2\u7ecf\u6ca1\u6709\u7a7a\u4f4d\u4e86", 0);
                ** while (true)
            }
            this.popMenu = (byte)-1;
            ** while (true)
        }
        if (!Ms.i().key_S2()) ** GOTO lbl12
        this.popMenu = (byte)-1;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private void putMonster() {
        if (this.cMon_count >= this.max_monsters) {
            this.say("\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1", 0);
            return;
        }
        if (!this.isMyMonsters(this.select[0][0])) {
            this.say("\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01", 0);
            return;
        }
        this.cMonsters[this.cMon_count] = this.myMonsters[this.select[0][0]];
        this.cMon_count = (byte)(this.cMon_count + 1);
        this.setPutMonster();
    }

    /*
     * Unable to fully structure code
     */
    private void resetFealty(int var1_1) {
        block4: {
            block5: {
                var2_2 = this.initFealty[this.myMonsters[this.select[0][0]].monster[4] / 4];
                if (this.myMonsters[this.select[0][0]].monster[6] >= var2_2 || this.myMonsters[this.select[0][0]].monsterPro[0] <= 0) break block4;
                if (var1_1 == -1) {
                    this.myMonsters[this.select[0][0]].monster[6] = var2_2;
lbl5:
                    // 3 sources

                    while (true) {
                        this.useState(0, this.select_it[0]);
                        if (this.view_state == -1) {
                            this.getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
                        }
lbl9:
                        // 5 sources

                        return;
                    }
                }
                if (this.myMonsters[this.select[0][0]].monster[6] + var1_1 <= var2_2) break block5;
                this.myMonsters[this.select[0][0]].monster[6] = var2_2;
                ** GOTO lbl5
            }
            var3_3 = this.myMonsters[this.select[0][0]].monster;
            var3_3[6] = (byte)(var3_3[6] + var1_1);
            ** while (true)
        }
        if (this.myMonsters[this.select[0][0]].monsterPro[0] <= 0) ** GOTO lbl9
        this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u5fe0\u8bda\u5ea6\u5df2\u6ee1", 0);
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private void resetMonster(int n) {
        if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            this.AddMP(this.myMonsters[this.select[0][0]].monsterPro[3] * n / 100, this.myMonsters[this.select[0][0]]);
            this.AddHP(this.myMonsters[this.select[0][0]].monsterPro[2] * n / 100, this.myMonsters[this.select[0][0]]);
            this.myMonsters[this.select[0][0]].effect = (byte)7;
            this.useState(0, this.select_it[0]);
            return;
        }
        this.say(String.valueOf(this.getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + "\u6ca1\u6709\u6b7b\u4ea1\uff01", 0);
    }

    private void restMove(int n, int n2) {
        this.selectx = this.select[0][1];
        this.selecty = this.select[0][0];
        this.cur_c = (byte)n;
        byte[] byArray = this.select[0];
        this.select[0][0] = 0;
        byArray[1] = 0;
        this.popMenu = (byte)n2;
        this.move_x = (short)129;
        this.move_y = (short)-14;
    }

    /*
     * Unable to fully structure code
     */
    private void runBattleState() {
        block19: {
            this.myB.countS[0] = (byte)Ms.i().mathSpeedN((int)this.myB.countS[0], (int)this.myB.countS[1], 1, false);
            this.enB.countS[0] = (byte)Ms.i().mathSpeedN((int)this.enB.countS[0], (int)this.enB.countS[1], 1, false);
            switch (this.battle_state) lbl-1000:
            // 12 sources

            {
                default: lbl-1000:
                // 4 sources

                {
                    return;
                }
                case 1: {
                    if (!this.bufferAI(this.enB.getMon())) ** GOTO lbl13
                    this.aiEnemy();
                    if (this.enB.getMon().effect != 6 || this.getSkillLevel(this.enB.skill) <= 3) {
                        this.setAcionSkill(this.enB);
                    }
                    ** GOTO lbl-1000
lbl13:
                    // 1 sources

                    this.enB.act_num = 0;
                    this.battle_state = (byte)-2;
                    ** GOTO lbl-1000
                }
                case 9: {
                    if (this.myB.act_num != 0 || this.enB.act_num != 0) ** GOTO lbl23
                    this.myB.act_num = 1;
                    this.enB.act_num = 1;
                    if (!this.myB.getMon().isMonEffect(0)) ** GOTO lbl37
                    this.myB.act_num = 0;
                    this.say("\u77f3\u5316\u6548\u679c\u65e0\u6cd5\u884c\u52a8\uff0c\u53d7\u5230\u7684\u4f24\u5bb3\u51cf\u5c1130%", -1);
lbl23:
                    // 2 sources

                    if (this.myB.act_num == 0 || this.enB.act_num == 0) ** GOTO lbl57
                    if (this.myB.getMon().monsterPro[5] < this.enB.getMon().monsterPro[5]) ** GOTO lbl55
                    var3_1 = 1;
lbl26:
                    // 2 sources

                    while (true) {
                        this.setAimBattle(var3_1);
lbl28:
                        // 2 sources

                        while (this.mini_state == 1) {
                            this.myB.act_num = 0;
                            if (this.myB.getMon().monster[6] >= 41) ** GOTO lbl64
                            Ms.i();
                            if (Ms.getRandom((int)100) >= 25) ** GOTO lbl64
                            this.say("\u5fe0\u8bda\u5ea6\u8fc7\u4f4e\uff0c\u5ba0\u7269\u4e0d\u670d\u4ece\u4e3b\u4eba\u547d\u4ee4", -1);
                            ** GOTO lbl-1000
                        }
                        ** GOTO lbl69
                        break;
                    }
lbl37:
                    // 1 sources

                    this.setAimBattle(1);
                    this.goBattleState();
                    var5_4 = "";
                    if (!this.myB.getMon().isMonEffect(2)) ** GOTO lbl46
                    var5_4 = "\u6495\u88c2\u6548\u679c\uff0c\u51cf\u5c11\u5f53\u524d\u8840\u91cf\u768410%";
lbl42:
                    // 5 sources

                    while (true) {
                        if (!var5_4.equals("")) {
                            this.say(var5_4, 0);
                        }
                        ** GOTO lbl-1000
                        break;
                    }
lbl46:
                    // 1 sources

                    if (!this.myB.getMon().isMonEffect(3)) ** GOTO lbl49
                    var5_4 = "\u9b45\u60d1\u6548\u679c\uff0c\u4e0d\u80fd\u9003\u8dd1\uff0c\u589e\u52a0\u6355\u83b7\u5ba0\u7269\u7684\u51e0\u7387";
                    ** GOTO lbl42
lbl49:
                    // 1 sources

                    if (!this.myB.getMon().isMonEffect(4)) ** GOTO lbl52
                    var5_4 = "\u7981\u9522\u6548\u679c\uff0c\u4e0d\u80fd\u9003\u8dd1\uff0c\u4e0d\u80fd\u6362\u602a\uff0c\u4e0d\u80fd\u4f7f\u7528\u9053\u5177";
                    ** GOTO lbl42
lbl52:
                    // 1 sources

                    if (!this.myB.getMon().isMonEffect(5)) ** GOTO lbl42
                    var5_4 = "\u8150\u8680\u6548\u679c\uff0c\u6bcf\u56de\u5408\u53d7\u5230\u4e00\u5b9a\u4f24\u5bb3";
                    ** continue;
lbl55:
                    // 1 sources

                    var3_1 = 0;
                    ** continue;
lbl57:
                    // 1 sources

                    if (this.myB.act_num == 0) ** GOTO lbl62
                    var3_2 = 1;
lbl59:
                    // 2 sources

                    while (true) {
                        this.setAimBattle(var3_2);
                        ** GOTO lbl28
                        break;
                    }
lbl62:
                    // 1 sources

                    var3_2 = 0;
                    ** continue;
lbl64:
                    // 2 sources

                    if (!this.myB.getMon().isMonEffect(0)) ** GOTO lbl67
                    this.say("\u77f3\u5316\u6548\u679c\u65e0\u6cd5\u884c\u52a8\uff0c\u53d7\u5230\u7684\u4f24\u5bb3\u51cf\u5c1130%", -1);
                    ** GOTO lbl-1000
lbl67:
                    // 1 sources

                    this.setAcionSkill(this.myB);
                    ** GOTO lbl-1000
lbl69:
                    // 1 sources

                    if (this.say_c != 0) ** GOTO lbl-1000
                    this.enB.act_num = 0;
                    if (this.enB.getMon().isMonEffect(0)) ** GOTO lbl-1000
                    this.battle_state = 1;
                    ** GOTO lbl-1000
                }
                case -5: {
                    if (this.b_c != 0 || this.cur_c < this.mon_in_battle[0]) ** GOTO lbl79
                    this.goBattleOver();
                    this.setNidusExp(this.exp);
                    ** GOTO lbl-1000
lbl79:
                    // 1 sources

                    var1_6 = this.mon_in_battle[this.cur_c + 1];
                    if (this.b_c != 0) ** GOTO lbl96
                    if (this.myMonsters[var1_6].monsterPro[0] <= 0) ** GOTO lbl94
                    if (!this.myMonsters[var1_6].isMonReel(40)) {
                        var5_5 = this.myMonsters[var1_6].monster;
                        var5_5[6] = (byte)(var5_5[6] - 1);
                    }
                    this.myB.now_id = var1_6;
                    this.myB.chp = this.myMonsters[var1_6].monsterPro[0];
                    this.myB.cexp = this.myMonsters[var1_6].monsterPro[4];
                    this.initMonStream(2, this.mList_id[this.myMonsters[var1_6].monster[0]][0], 1);
                    if (this.level_up(var1_6, 0)) {
                        this.b_c = 1;
                    }
lbl91:
                    // 11 sources

                    while (true) {
                        this.myB.cexp = Ms.i().mathSpeedN((int)this.myB.cexp, (int)this.myMonsters[var1_6].monsterPro[4], 8, false);
                        ** GOTO lbl-1000
                        break;
                    }
lbl94:
                    // 1 sources

                    this.cur_c = (byte)(this.cur_c + 1);
                    ** GOTO lbl91
lbl96:
                    // 1 sources

                    if (this.b_c != 1) ** GOTO lbl101
                    this.level_up(var1_6, 1);
                    this.b_c = (byte)2;
                    ** GOTO lbl91
lbl101:
                    // 1 sources

                    if (this.b_c != 2 || this.myB.cexp != this.myMonsters[var1_6].monsterPro[4]) ** GOTO lbl107
                    if (this.level_up(var1_6, 2)) ** GOTO lbl105
                    this.b_c = (byte)15;
                    ** GOTO lbl91
lbl105:
                    // 1 sources

                    this.b_c = 1;
                    ** GOTO lbl91
lbl107:
                    // 1 sources

                    if (this.b_c <= 2) ** GOTO lbl91
                    if (this.b_c >= 21) ** GOTO lbl121
                    var3_3 = true;
lbl110:
                    // 2 sources

                    while (this.myB.cexp == this.myMonsters[var1_6].monsterPro[4]) {
                        var4_8 = true;
lbl112:
                        // 2 sources

                        while (true) {
                            if (!(var3_3 & var4_8)) ** GOTO lbl91
                            this.b_c = var2_9 = (byte)(this.b_c - 1);
                            if (var2_9 != 3) ** GOTO lbl91
                            this.b_c = 0;
                            this.cur_c = (byte)(this.cur_c + 1);
                            ** continue;
                            break;
                        }
lbl119:
                        // 1 sources

                        ** GOTO lbl91
                    }
                    ** GOTO lbl123
lbl121:
                    // 1 sources

                    var3_3 = false;
                    ** GOTO lbl110
lbl123:
                    // 1 sources

                    var4_8 = false;
                    ** continue;
                }
                case -4: 
            }
            if (this.say_c != 0) ** GOTO lbl-1000
            this.cur_b = var1_7 = (byte)(this.cur_b + 1);
            if (var1_7 < this.about_a.length) break block19;
            this.about_a = null;
            this.goBattleExp(true);
            ** GOTO lbl-1000
        }
        Log.e((String)"soars", (String)this.about_a[this.cur_b].toString());
        this.say(this.about_a[this.cur_b].toString(), 0);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void runHit() {
        if (!this.am.b_renascence && !this.dm.b_renascence) {
            this.hit_rate(this.am, this.dm, this.am.getMon(), this.dm.getMon(), this.am.skill);
lbl3:
            // 2 sources

            while (true) {
                this.battle_state = (byte)-2;
                return;
            }
        }
        this.am.b_renascence = false;
        this.dm.b_renascence = false;
        ** while (true)
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    private boolean runHitToState(Battle object, Battle battle, int n) {
        void var2_3;
        if (var2_3.getMon().monsterPro[0] > 0) {
            return true;
        }
        if (var2_3.dead == 1) {
            void var3_4;
            if (var2_3.getMon().isMonReel(38)) {
                Ms.i();
                if (Ms.getRandom((int)100) < this.skill[38][1]) {
                    this.setRelive((Battle)object, (Battle)var2_3);
                    return false;
                }
            }
            if (var3_4 == false) {
                this.enB.act_num = 1;
                if (this.changeMy()) {
                    return false;
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
                    return false;
                }
                if (SMSSender.i((GameRun)this).sms_a) {
                    System.out.println("aaaaaaaaaaaaa");
                    if (this.say_c != 0) return false;
                    this.isKillAll = true;
                    if (isSay) return false;
                    this.say("\u643a\u5e26\u7684\u5ba0\u7269\u5168\u90fd\u727a\u7272\u4e86!", -1, 1);
                    return false;
                }
                System.out.println("bbbbbbbbbb");
                SMSSender.i((GameRun)this).sms_a = true;
                this.goGameOver();
                return false;
            }
            if (var3_4 != true) return false;
            if (this.changeMon(this.enB, this.enB.mon.length)) {
                this.setEnemyThrow();
                this.enB.act_num = 0;
                run_state = -50;
                this.t_battle_state = this.battle_state;
                this.battle_state = 0;
                return false;
            }
            this.goBattleItem();
            if (this.overMode == 2) {
                this.map.sIfElse = 0;
            }
            this.overMode = 0;
            return false;
        }
        if (var2_3.action == 2) return false;
        var2_3.action = (byte)2;
        this.now_action[this.mini_state] = 0;
        this.now_time[this.mini_state] = 0;
        if (var2_3.getMon().isMonReel(40)) return false;
        byte[] byArray = var2_3.getMon().monster;
        byArray[6] = (byte)(byArray[6] - 10);
        return false;
    }

    /*
     * Unable to fully structure code
     */
    private void runMonsterAppear() {
        block7: {
            block8: {
                switch (this.battle_state) {
                    default: lbl-1000:
                    // 5 sources

                    {
                        return;
                    }
                    case 0: 
                }
                if (this.myB.throw_state != 2 || this.myB.throw_state != 2) ** GOTO lbl-1000
                if (this.view_state == -2) {
                    this.setAimBattle(0);
                    this.myB.act_num = 0;
                    this.enB.act_num = 0;
                }
                this.view_state = (byte)-1;
                this.goBattleState();
                if (this.t_battle_state != -3 && this.t_battle_state != -2) break block8;
                this.battle_state = this.t_battle_state;
                this.t_battle_state = 0;
                this.getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
lbl17:
                // 2 sources

                while (true) {
                    if (this.first_battle != 0) ** GOTO lbl-1000
                    this.first_battle = 1;
                    var1_1 = this.myB.getMon().monster[6] - 99;
                    if (var1_1 <= 1) break block7;
                    var1_1 = 20;
lbl23:
                    // 2 sources

                    while (true) {
                        if ((byte)var1_1 >= 0) ** GOTO lbl-1000
                        this.say("\u5fe0\u8bda\u5ea6\u964d\u4f4e\uff0c\u653b\u51fb\u529b\u4e0b\u964d\uff0c\u8bf7\u53ca\u65f6\u8865\u5145\uff01", 0);
                        ** continue;
                        break;
                    }
                    break;
                }
            }
            this.goSelectAction(this.mini_state);
            ** while (true)
        }
        var1_1 = var1_1 / 20 * 20;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void runThrowBall(Battle var1_1, Monster var2_2, int var3_3) {
        block5: {
            block4: {
                block3: {
                    if (this.src_c[var3_3 + 2] != 0 || var1_1 /* !! */ .throw_state != -1 || this.src_c[var3_3] != 12) break block3;
                    var1_1 /* !! */ .throw_state = 0;
lbl3:
                    // 3 sources

                    while (var1_1 /* !! */ .throw_state == 0) {
                        var1_1 /* !! */ .cThrow[0] = (byte)Ms.i().mathSpeedN((int)var1_1 /* !! */ .cThrow[0], 0, 6, false);
                        var1_1 /* !! */ .cThrow[1] = (byte)Ms.i().mathSpeedUp((int)var1_1 /* !! */ .cThrow[1], 62, 2);
                        if (var1_1 /* !! */ .cThrow[0] == 0 && var1_1 /* !! */ .cThrow[1] == 0) {
                            var1_1 /* !! */ .throw_state = 1;
                        }
lbl8:
                        // 6 sources

                        return;
                    }
                    break block4;
                }
                if (this.src_c[var3_3 + 2] != 1 || this.src_c[var3_3] != 0) ** GOTO lbl3
                this.src_c[var3_3 + 2] = 0;
                this.getBattleBG(var1_1 /* !! */ , var2_2);
                ** GOTO lbl3
            }
            if (var1_1 /* !! */ .throw_state != 1) ** GOTO lbl8
            if (var1_1 /* !! */ .cThrow[2] >= 12) break block5;
            var1_1 /* !! */  = (Battle)var1_1 /* !! */ .cThrow;
            var1_1 /* !! */ [2] = (Battle)((short)(var1_1 /* !! */ [2] + true));
            ** GOTO lbl8
        }
        var1_1 /* !! */ .throw_state = (byte)2;
        ** while (true)
    }

    private void sellMonster(Monster monster) {
        this.sell_money = monster.monster[2] * (monster.monster[4] * 5) + 100;
    }

    private void setAcionSkill(Battle battle) {
        battle.action = 1;
        this.now_action[this.mini_state] = 0;
        this.now_time[this.mini_state] = 0;
        this.battle_state = (byte)-1;
        this.setMagic(battle.skill / 5);
    }

    /*
     * Enabled force condition propagation
     */
    private boolean setCartoonFrameMagic_C(int n, int n2, int n3, boolean bl) {
        short s;
        short[] sArray = this.now_time_Magic;
        sArray[n] = s = (short)(sArray[n] + 1);
        if (s < this.magic[n2].action(n3, (int)this.now_action_Magic[n], 1)) return false;
        sArray = this.now_action_Magic;
        sArray[n] = (short)(sArray[n] + 1);
        this.now_time_Magic[n] = 0;
        if (bl) return false;
        if (this.now_action_Magic[n] < this.magic[n2].aLength(n3)) return false;
        sArray = this.now_action_Magic;
        sArray[n] = (short)(sArray[n] - 1);
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    private boolean setCartoonFrame_C(int n, int n2, int n3, boolean bl) {
        byte by;
        byte[] byArray = this.now_time;
        byArray[n] = by = (byte)(byArray[n] + 1);
        if (by < this.mon[n2].action(n3, (int)this.now_action[n], 1)) return false;
        byArray = this.now_action;
        byArray[n] = (byte)(byArray[n] + 1);
        this.now_time[n] = 0;
        if (bl) return false;
        if (this.now_action[n] < this.mon[n2].aLength(n3)) return false;
        byArray = this.now_action;
        byArray[n] = (byte)(byArray[n] - 1);
        return true;
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

    /*
     * Unable to fully structure code
     */
    private void setEvolveStringB(Monster var1_1) {
        var5_2 = (byte)(var1_1.monster[0] + 1);
        var6_3 = var1_1.monster[2];
        var3_5 = var4_4 = 0;
        var2_6 = var5_2;
        if (this.monsterMake[var1_1.monster[0]][0] > 0) {
            var3_5 = var4_4;
            var2_6 = var5_2;
            if (this.findItem(-2, 34, true) > 0) {
                var2_6 = this.monsterMake[var1_1.monster[0]][0];
                var3_5 = 1;
            }
        }
        this.proReplace = null;
        this.proReplace = new short[1][6];
        this.proReplace[0][0] = (short)(this.getbuffRateV(var1_1, this.monster_pro[var2_6][0] + this.monster_pro[var2_6][7] * var6_3 / 10) - var1_1.monsterPro[2]);
        this.proReplace[0][1] = (short)(this.monster_pro[var2_6][1] + this.monster_pro[var2_6][8] * var6_3 / 10 - var1_1.monsterPro[3]);
        var7_7 = this.proReplace[0];
        if (var3_5 != 0) {
            var3_5 = var1_1.monster[5];
lbl18:
            // 2 sources

            while (true) {
                var7_7[2] = -var3_5;
                this.proReplace[0][3] = (byte)(this.monster_pro[var2_6][3] + this.monster_pro[var2_6][10] * var6_3 / 10 - var1_1.monsterPro[6]);
                this.proReplace[0][4] = (byte)(this.monster_pro[var2_6][4] + this.monster_pro[var2_6][11] * var6_3 / 10 - var1_1.monsterPro[7]);
                this.proReplace[0][5] = (byte)(this.monster_pro[var2_6][2] + this.monster_pro[var2_6][9] * var6_3 / 10 - var1_1.monsterPro[5]);
                this.setStringB("\u751f\u547d\uff1a+" + this.proReplace[0][0] + "#n" + "\u80fd\u91cf" + "\uff1a+" + this.proReplace[0][1] + "#n" + "\u8fdb\u5316" + "\uff1a" + this.proReplace[0][2], Constants_H.WIDTH, 0);
                this.setStringB("\u529b\u91cf\uff1a+" + this.proReplace[0][3] + "#n" + "\u9632\u5fa1" + "\uff1a+" + this.proReplace[0][4] + "#n" + "\u654f\u6377" + "\uff1a+" + this.proReplace[0][5], Constants_H.WIDTH, 1);
                this.proReplace = null;
                return;
            }
        }
        var3_5 = 1;
        ** while (true)
    }

    private void setMyThrow() {
        this.myB.cThrow[0] = -286;
        this.myB.cThrow[1] = 60;
        this.myB.cThrow[2] = 0;
        this.setThrow(this.myB, this.myB.getMon(), 1);
        this.getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
        this.getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
    }

    private void setNidusPro(int n, int n2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\u751f\u547d\uff1a" + (this.monster_pro[n][0] + this.monster_pro[n][7] * n2 / 10) + "#n");
        stringBuffer.append("\u80fd\u91cf\uff1a" + (this.monster_pro[n][1] + this.monster_pro[n][8] * n2 / 10) + "#n");
        stringBuffer.append("\u8fdb\u5316\uff1a" + this.monster_pro[n][12]);
        this.setStringB(stringBuffer.toString(), Constants_H.WIDTH, 0);
        stringBuffer.delete(0, stringBuffer.length());
        stringBuffer.append("\u529b\u91cf\uff1a" + (this.monster_pro[n][3] + this.monster_pro[n][10] * n2 / 10) + "#n");
        stringBuffer.append("\u9632\u5fa1\uff1a" + (this.monster_pro[n][4] + this.monster_pro[n][11] * n2 / 10) + "#n");
        stringBuffer.append("\u654f\u6377\uff1a" + (this.monster_pro[n][4] + this.monster_pro[n][11] * n2 / 10));
        this.setStringB(stringBuffer.toString(), Constants_H.WIDTH, 1);
    }

    private void setNullBattle() {
        this.proReplace = null;
        this.effectImage = null;
        this.imgBattle = null;
        this.levelUp_in_battle = null;
        this.myB = null;
        this.enB = null;
    }

    /*
     * Unable to fully structure code
     */
    private void setPutMonster() {
        var1_1 = this.select[0][0];
        block0: while (true) {
            if (var1_1 >= this.myMon_length - 1) {
                var1_1 = this.myMon_length;
lbl5:
                // 2 sources

                while (true) {
                    if (var1_1 < this.myMonsters.length) break block0;
                    this.myMon_length = (byte)(this.myMon_length - 1);
                    if (this.select[0][0] == this.myMon_length) {
                        var2_2 = this.select[0];
                        var2_2[0] = (byte)(var2_2[0] - 1);
                    }
                    this.initMonStream(2, this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0], 1);
                    this.setShowPro(this.myMonsters[this.select[0][0]]);
                    this.introT = Constants_H.WIDTH_H;
                    this.t_length = this.myMon_length;
                    this.popMenu = (byte)-1;
                    Ms.i().correctSelect(this.select[0], (int)this.t_length, (int)this.list_rows);
                    return;
                }
            }
            this.myMonsters[var1_1] = this.myMonsters[var1_1 + 1];
            this.evolve[var1_1] = this.evolve[var1_1 + 1];
            var1_1 = (byte)(var1_1 + 1);
        }
        this.evolve[var1_1] = true;
        var1_1 = (byte)(var1_1 + 1);
        ** while (true)
    }

    private void setRelive(Battle battle, Battle battle2) {
        battle2.initHit();
        battle2.addHit(-battle2.getMon().monsterPro[2] * this.skill[38][0] / 100, 1, 1);
        battle2.skill = (byte)28;
        battle2.dead = 0;
        battle2.action = 0;
        battle2.b_renascence = true;
        battle2.act_num = 0;
        this.battle_state = (byte)-1;
        this.setMagic(5);
        this.getHitCoefficient(battle2, battle2.getMon(), battle.getMon());
        this.setAimBattle(this.mini_state ^ 1);
    }

    private void setShowPro(Monster monster) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(monster.monsterPro[6]) + "#n");
        stringBuffer.append(String.valueOf(monster.monsterPro[7]) + "#n");
        stringBuffer.append(monster.monsterPro[5]);
        this.setStringB(stringBuffer.toString(), Constants_H.WIDTH, 2);
    }

    private void setTakenMonster() {
        byte by = this.select[0][0];
        while (true) {
            if (by >= this.cMon_count - 1) {
                this.t_length = this.cMon_count = (byte)(this.cMon_count - 1);
                if (this.select[0][0] == this.cMon_count) {
                    byte[] byArray = this.select[0];
                    byArray[0] = (byte)(byArray[0] - 1);
                }
                if (this.t_length > 0) {
                    this.initMonStream(2, this.mList_id[this.cMonsters[this.select[0][0]].monster[0]][0], 1);
                    this.setShowPro(this.cMonsters[this.select[0][0]]);
                }
                this.introT = Constants_H.WIDTH_H;
                this.popMenu = (byte)-1;
                Ms.i().correctSelect(this.select[0], (int)this.t_length, (int)this.list_rows);
                return;
            }
            this.cMonsters[by] = this.cMonsters[by + 1];
            by = (byte)(by + 1);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void setThrow(Battle var1_1, Monster var2_2, int var3_3) {
        var1_1.throw_state = (byte)-1;
        this.initMonStream(2, this.mList_id[var2_2.monster[0]][0], var3_3);
        if (var2_2.isMonReel(var2_2.monster[3] + 43)) {
            if (var1_1.bg_id != var2_2.monster[3]) {
                this.src_c[var3_3 + 2] = 1;
            }
lbl6:
            // 5 sources

            while (true) {
                var1_1.action = 0;
                var1_1.dead = 0;
                var1_1.chp = var2_2.monsterPro[0];
                return;
            }
        }
        if (this.monPro.length == 0 || var1_1.bg_id == this.monPro[0]) ** GOTO lbl6
        this.src_c[var3_3 + 2] = 1;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private void takenMonster() {
        if (this.myMon_length < this.max_takes) {
            this.myMonsters[this.myMon_length] = this.cMonsters[this.select[0][0]];
            this.evolve[this.myMon_length] = true;
            this.myMon_length = (byte)(this.myMon_length + 1);
            this.setTakenMonster();
            return;
        }
        this.say("\u6240\u80fd\u643a\u5e26\u7684\u5ba0\u7269\u5df2\u7ecf\u8fbe\u5230\u4e0a\u9650\uff01", 1);
    }

    /*
     * Unable to fully structure code
     */
    private void useItem() {
        switch (this.items[0][this.select_it[0]][0]) lbl-1000:
        // 11 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                return;
            }
            case 5: {
                this.allAdd(50);
                ** GOTO lbl-1000
            }
            case 6: {
                this.allAdd(100);
                ** GOTO lbl-1000
            }
            case 13: {
                this.resetFealty(-1);
                ** GOTO lbl-1000
            }
            case 12: {
                this.resetFealty(30);
                ** GOTO lbl-1000
            }
            case 7: {
                this.resetMonster(30);
                ** GOTO lbl-1000
            }
            case 4: {
                this.mpAdd(100);
                ** GOTO lbl-1000
            }
            case 3: {
                this.mpAdd(50);
                ** GOTO lbl-1000
            }
            case 2: {
                this.hpAdd(100, 0);
                ** GOTO lbl-1000
            }
            case 0: {
                this.hpAdd(35, 30);
                ** GOTO lbl-1000
            }
            case 1: {
                this.hpAdd(65, 30);
                ** GOTO lbl-1000
            }
            case 8: 
        }
        this.changeEffect();
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void useState(int var1_1, int var2_2) {
        GameRun.mc.paint();
        Ms.i().sleep(200);
        if (this.view_state == -1) {
            this.myB.act_num = 0;
            this.goBattleState();
            this.battle_state = (byte)9;
            this.initMonStream(2, this.mList_id[this.myMonsters[0].monster[0]][0], 1);
lbl8:
            // 2 sources

            while (true) {
                this.deleteItems(this.items[var1_1][var2_2][0], 1);
                return;
            }
        }
        this.goMY_BAG(var1_1);
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public void Success() {
        // MONITORENTER : this
        SMSSender.i((GameRun)this).setSendSms(4);
        try {
            SMSSender.i((GameRun)this);
            if (SMSSender.smsType == 6) {
                SMSSender.i((GameRun)this).sendSuccess();
                SMSSender.i((GameRun)this).setSendSms(-1);
                GameRun.mc.temp_state = run_state = -10;
                mc.setSmsIsSetRun_state(true);
                this.map.setRegState(true);
                return;
            }
            SMSSender.i((GameRun)this).sendSuccess();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return;
    }

    /*
     * Enabled force condition propagation
     */
    public byte addItem(int n, int n2) {
        byte by = this.findItemType(n);
        byte by2 = this.findItem(by, n, false);
        if (by2 != -1) {
            int n3;
            byte[] byArray = this.items[by][by2];
            byArray[1] = n3 = (int)(byArray[1] + n2);
            if (n3 <= 99) return (byte)1;
            this.items[by][by2][1] = 99;
            this.say(String.valueOf(this.getNameItem(this.items[by][by2][0])) + "\u6570\u91cf\u5df2\u5230\u4e0a\u9650", 0);
            return (byte)-1;
        }
        this.items[by][this.itemsLength[by]][0] = (byte)n;
        this.items[by][this.itemsLength[by]][1] = (byte)n2;
        byte[] byArray = this.itemsLength;
        byArray[by] = (byte)(byArray[by] + 1);
        return (byte)1;
    }

    public void addMonInfoListBH() {
        byte[] byArray = this.monInfoList;
        byArray[104] = (byte)(byArray[104] + 1);
        byArray = this.monInfoList;
        byArray[103] = (byte)(byArray[103] + 1);
        if (this.monInfoList[103] == 102) {
            this.say("\u606d\u559c\u60a8\u628a\u6240\u6709\u7684\u5ba0\u7269\u90fd\u6536\u96c6\u9f50\u4e86", 0);
            mc.paint();
            Ms.i().sleep(600);
        }
    }

    public void battleType(int n) {
        this.battle_type = (byte)n;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean checkMonster() {
        byte by = 0;
        while (true) {
            if (by >= this.myMon_length) {
                this.say("\u60a8\u7684\u5ba0\u7269\u4e0d\u9700\u8981\u56de\u590d\uff01", 0);
                return true;
            }
            if (this.myMonsters[by].monsterPro[1] < this.myMonsters[by].monsterPro[3]) return false;
            if (this.myMonsters[by].monsterPro[0] < this.myMonsters[by].monsterPro[2]) {
                return false;
            }
            by = (byte)(by + 1);
        }
    }

    public void data_init() {
        byte[] byArray = Ms.i().getStream("data/data.d", -1);
        Ms.i();
        Ms.skip = 0;
        this.skill_up = Ms.i().create2Array(byArray);
        this.monster_pro = Ms.i().create2Array(byArray);
        this.skill = Ms.i().create2Array(byArray);
        this.skill_help = Ms.i().createStringArray(byArray);
        this.skill_name = Ms.i().createStringArray(byArray);
        this.monsterT = Ms.i().createStringArray(byArray);
        this.NAME = Ms.i().createStringArray(byArray);
        this.item_help = Ms.i().createStringArray(byArray);
        this.item_name = Ms.i().createStringArray(byArray);
        this.city_name = Ms.i().createStringArray(byArray);
        this.buff_name = Ms.i().createStringArray(byArray);
        this.buff_help = Ms.i().createStringArray(byArray);
        this.monAppearMap = Ms.i().create2Array(byArray);
        this.mList_id = Ms.i().create2Array(byArray);
        this.monsterMake = Ms.i().create2Array(byArray);
        this.monsterInfo = Ms.i().createStringArray(byArray);
        this.inhesion = Ms.i().createArray(byArray);
        this.makeLevel = Ms.i().createArray(byArray);
        this.musicNo = Ms.i().createArray(byArray);
        this.npc2ImageType = Ms.i().createArray(byArray);
        this.map.boatCourse = Ms.i().create2Array(byArray);
        this.nidusList = Ms.i().create2Array(byArray);
        byArray = null;
    }

    /*
     * Enabled force condition propagation
     */
    public byte delMonster(int n) {
        byte by = this.myMonsters[n].monster[0];
        if (this.monsterRemove(n) != -1) {
            this.say("\u5931\u53bb\u5ba0\u7269\uff1a" + this.getNameMon(by), 0);
            return 1;
        }
        this.say("\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01", 0);
        return -1;
    }

    public void deleteItems(int n, int n2) {
        byte by = this.findItemType(n);
        if ((n = (int)this.findItem(by, n, false)) != -1) {
            if (this.items[by][n][1] >= n2) {
                byte[] byArray = this.items[by][n];
                byArray[1] = (byte)(byArray[1] - n2);
            }
            if (this.items[by][n][1] == 0) {
                this.dItemIn(by, n);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public void doPaint(int var1_1) {
        if (var1_1 != 0) {
            this.b_c = (byte)var1_1;
lbl3:
            // 2 sources

            while (true) {
                GameRun.mc.paint();
                return;
            }
        }
        GameRun.run_state = -10;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void doSayOverSms() {
        var1_1 = this.sayOverSms;
        System.out.println("doSayOverSms() sayOverSms= " + this.sayOverSms);
        this.sayOverSms = (byte)-1;
        if (var1_1 == 0) {
            GameRun.isSay = true;
            SMSSender.i((GameRun)this).go(4, true);
            GameRun.isSay = false;
lbl8:
            // 3 sources

            return;
        }
        if (var1_1 != 1) ** GOTO lbl8
        SMSSender.i((GameRun)this).go(3, true);
        ** while (true)
    }

    public boolean drawCartoonOne(int n, int n2, int n3, int n4, int n5, boolean bl, int n6) {
        if (this.now_action[n] >= this.mon[n2].aLength(n3)) {
            this.now_action[n] = 0;
        }
        Ui.i().drawFrameOne(this.mon[n2], this.mon[n2].action(n3, (int)this.now_action[n], 0), n4, n5, n6);
        return this.setCartoonFrame_C(n, n2, n3, bl);
    }

    /*
     * Unable to fully structure code
     */
    public void drawChangeMap(boolean var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        block6: {
            var2_2 *= 2;
            if (var1_1) {
                Ui.i().fillRect(5422575, 0, 0, 640, 360);
            }
            GameRun.g.setColor(0);
            GameRun.g.fillRect(var3_3, var4_4 + 1, var5_5, 5);
            GameRun.g.fillRect(var3_3 + 1, var4_4, var5_5 - 2, 7);
            GameRun.g.setColor(15400191);
            if ((var5_5 - 4) * var2_2 / 60 > var5_5) {
                GameRun.g.fillRect(var3_3 + 2, var4_4 + 1, var5_5, 5);
                GameRun.g.fillRect(var3_3 + 1, var4_4 + 2, var5_5, 3);
lbl11:
                // 2 sources

                while (true) {
                    if (var1_1 && Map.npcSp[1][0].img != null) {
                        if ((var5_5 - 4) * var2_2 / 60 <= var5_5) break block6;
                        this.map.drawMyAni(this.map.my, 0, var5_5, var4_4 + 10, 5);
                    }
lbl15:
                    // 4 sources

                    return;
                }
            }
            GameRun.g.fillRect(var3_3 + 2, var4_4 + 1, (var5_5 - 4) * var2_2 / 60, 5);
            GameRun.g.fillRect(var3_3 + 1, var4_4 + 2, (var5_5 - 2) * var2_2 / 60, 3);
            ** while (true)
        }
        this.map.drawMyAni(this.map.my, 0, var3_3 + (var5_5 - 4) * var2_2 / 60, var4_4 + 10, 5);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void drawCityName() {
        var2_1 = Constants_H.WIDTH__ / 2;
        if (this.cityName_c == -20) lbl-1000:
        // 2 sources

        {
            return;
        }
        var3_2 = (short)(Ms.i().getStringWidth(this.city_name[this.map.mapNo].toString()) + 8);
        var4_3 /* !! */  = Ui.i();
        if (this.cityName_c > 0) {
            var1_4 = 0;
lbl9:
            // 2 sources

            while (true) {
                var4_3 /* !! */ .drawKuang(var2_1 - (var3_2 >> 1), (int)var1_4, (int)var3_2, 25 + 6);
                var5_5 = Ui.i();
                var4_3 /* !! */  = this.city_name[this.map.mapNo].toString();
                if (this.cityName_c > 0) {
                    var1_4 = 0;
lbl15:
                    // 2 sources

                    while (true) {
                        var5_5.drawString((String)var4_3 /* !! */ , var2_1, (int)var1_4, 17, 4, 2);
                        this.cityName_c = (byte)(this.cityName_c - 1);
                        ** continue;
                        break;
                    }
                }
                break;
            }
        } else {
            var1_4 = this.cityName_c;
            ** continue;
        }
        var1_4 = this.cityName_c;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void drawEvolveUI(int var1_1, int var2_2, boolean var3_3) {
        block19: {
            block18: {
                block16: {
                    block15: {
                        block14: {
                            block17: {
                                block20: {
                                    block21: {
                                        block22: {
                                            Ui.i().fillRectB();
                                            this.drawBG0(this.bg_c, 200, 108, 5, 230);
                                            if (var1_1 != 1 || this.b_c <= 0) break block20;
                                            if (this.b_c != 1) break block21;
                                            if (5 != 5) break block22;
                                            var5_4 = 6;
lbl7:
                                            // 2 sources

                                            while (this.drawMagicC(5, 5, var5_4, 377, 97, 0)) {
                                                this.initMonStream(2, this.mList_id[this.myMonsters[var2_2].monster[0]][0], 1);
                                                this.b_c = (byte)2;
lbl10:
                                                // 5 sources

                                                while (var1_1 == 1 && this.popMenu == 1) {
                                                    this.drawEvolveMake(this.myMonsters[var2_2].monster[0], 200 + 25, 108 + 25 + 22, 28);
lbl12:
                                                    // 2 sources

                                                    while (var1_1 == 0) {
                                                        this.move_y = 0;
                                                        this.move_x = 0;
                                                        var7_6 = Ui.i();
                                                        var6_7 = String.valueOf(this.getNameMon(this.myMonsters[var2_2].monster[0])) + "\u5347\u5230\u4e86" + this.myMonsters[var2_2].monster[2] + "\u7ea7";
                                                        var8_9 /* !! */  = GameRun.g;
                                                        var8_9 /* !! */  = GameRun.g;
                                                        var7_6.drawString((String)var6_7, 432, 108 + 4, 8 | 16, 1, 0);
                                                        Ui.i().drawImage(this.imgItem[1], 200 - this.say_s, 108 - 4, 36);
                                                        var6_7 = this.levelUp_in_battle;
                                                        if (!var3_3) break block14;
                                                        var1_1 = var2_2;
lbl24:
                                                        // 2 sources

                                                        while (true) {
                                                            if (var6_7[var1_1][1] == -1) ** GOTO lbl33
                                                            var7_6 = Ui.i();
                                                            var6_7 = new StringBuilder("\u4e60\u5f97\u6280\u80fd\uff1a");
                                                            var8_9 /* !! */  = (Graphics)this.levelUp_in_battle;
                                                            if (!var3_3) break block15;
                                                            var1_1 = var2_2;
lbl31:
                                                            // 2 sources

                                                            while (true) {
                                                                var7_6.drawString(var6_7.append(this.getNameSkill((byte)var8_9 /* !! */ [var1_1][1])).toString(), 320, 360 - 60, 17, 9, 0);
lbl33:
                                                                // 4 sources

                                                                while (true) {
                                                                    Ui.i().drawYesNo(true, true);
                                                                    return;
                                                                }
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break block16;
                                                }
                                                break block17;
                                            }
                                            break block21;
                                        }
                                        var5_4 = 1;
                                        ** GOTO lbl7
                                    }
                                    if (this.b_c <= 1 || this.b_c >= 14) ** GOTO lbl10
                                    this.drawClipPic(this.mList_id[this.myMonsters[var2_2].monster[0]][1], 1, 377, 97, 80, 77, 15, this.b_c - 2, 0);
                                    this.b_c = var4_5 = (byte)(this.b_c + 1);
                                    if (var4_5 != 14) ** GOTO lbl10
                                    this.b_c = (byte)-1;
                                    this.say("\u8fdb\u5316\u6210  " + this.getNameMon(this.myMonsters[var2_2].monster[0]), 0);
                                    ** GOTO lbl10
                                }
                                this.drawCartoonOne(1, 1, this.mList_id[this.myMonsters[var2_2].monster[0]][1] * 3, 377 - this.move_x, 97 - this.move_y, true, 0);
                                ** GOTO lbl10
                            }
                            Ui.i().drawStringY((Object[])this.about_b, 200 + 25 - 16, 108 + 25 + 22, 0, 3, 40, 3, 0);
                            Ui.i().drawStringY((Object[])this.about_a, 200 + 125 - 3, 108 + 25 + 22, 0, 3, 40, 3, 0);
                            ** GOTO lbl12
                        }
                        var1_1 = this.myMonsters[var2_2].monster[1];
                        ** while (true)
                    }
                    var1_1 = this.myMonsters[var2_2].monster[1];
                    ** while (true)
                }
                if (var1_1 != 1) ** GOTO lbl33
                var6_8 = Ui.i();
                if (this.popMenu == 0) {
                    var1_1 = -127;
lbl69:
                    // 2 sources

                    while (true) {
                        var6_8.drawK1(320 + var1_1, 108 + 6, 113, 27, 4);
                        var6_8 = Ui.i();
                        if (this.popMenu != 0) break block18;
                        var1_1 = 0;
lbl74:
                        // 2 sources

                        while (true) {
                            var6_8.drawString("\u57fa\u672c\u5c5e\u6027", 320 - 75 + 4, 108 + 5, 17, var1_1, 0);
                            var6_8 = Ui.i();
                            if (this.popMenu == 0) {
                                var1_1 = 1;
lbl79:
                                // 2 sources

                                while (true) {
                                    var6_8.drawString("\u8fdb\u5316\u7d20\u6750", 320 + 75 - 4, 108 + 5, 17, var1_1, 0);
                                    var4_5 = this.pkey.selectMenuX(2, 0, 108 + 5, 320, 33);
                                    if (var4_5 != -1) {
                                        this.popMenu = var4_5;
                                    }
                                    Ui.i().drawTriangle(320, 108 + 15, 150, true, true);
                                    this.move_x = Ms.i().mathSpeedDown((int)this.move_x, 3, false);
                                    this.move_y = Ms.i().mathSpeedDown((int)this.move_y, 3, false);
                                    Ui.i().drawString("\u786e\u5b9a\u8fdb\u5316\u8be5\u5ba0\u7269\uff1f", 320, 360 - 25 - 22, 17, 0, 1);
                                    ** continue;
                                    break;
                                }
                            }
                            break block19;
                            break;
                        }
                        break;
                    }
                }
                var1_1 = 15;
                ** while (true)
            }
            var1_1 = 1;
            ** while (true)
        }
        var1_1 = 0;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawFealty(int var1_1, int var2_2, int var3_3, int var4_4) {
        var5_5 = 0;
        block0: while (true) {
            if (var5_5 >= var1_1) {
                return;
            }
            var7_7 = Ui.i();
            if (var5_5 <= var2_2) break;
            var6_6 = 22;
lbl8:
            // 2 sources

            while (true) {
                var7_7.drawUi(var6_6, var5_5 * 14 + var3_3, var4_4, 0, 0);
                var5_5 = (byte)(var5_5 + 1);
                continue block0;
                break;
            }
            break;
        }
        var6_6 = 21;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawItem(int var1_1, int var2_2, int var3_3, int var4_4) {
        if (var1_1 >= 58) {
            var5_5 = this.monster_pro[this.nidusList[0][var1_1 - 58]][6] + 40;
lbl3:
            // 3 sources

            while (true) {
                Ui.i().drawRegion(this.item_img, (int)this.item_modules[var5_5][0], (int)this.item_modules[var5_5][1], (int)this.item_modules[var5_5][2], (int)this.item_modules[var5_5][3], var2_2, var3_3, var4_4, 0, GameRun.g);
                return;
            }
        }
        var5_5 = var1_1;
        if (var1_1 < 35) ** GOTO lbl3
        var5_5 = this.makeLevel[var1_1 - 35] + 34;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public boolean drawMagicC(int n, int n2, int n3, int n4, int n5, int n6) {
        if (this.now_action_Magic[n] >= this.magic[n2].aLength(n3)) {
            this.now_action_Magic[n] = 0;
            return true;
        }
        short s = (short)this.magic[n2].action(n3, (int)this.now_action_Magic[n], 0);
        while (true) {
            short s2;
            if (this.dm == null || s >= 2) {
                Ui.i().drawFrameOne(this.magic[n2], (int)s, n4, n5, n6);
                return this.setCartoonFrameMagic_C(n, n2, n3, true);
            }
            if (s == 0) {
                this.dm.ceff[0] = 2;
            }
            this.now_time_Magic[n] = 0;
            short[] sArray = this.now_action_Magic;
            sArray[n] = s2 = (short)(sArray[n] + 1);
            if (s2 >= this.magic[n2].aLength(n3)) {
                this.now_action_Magic[n] = 0;
                return true;
            }
            s = (short)this.magic[n2].action(n3, (int)this.now_action_Magic[n], 0);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void drawMoney(int var1_1, int var2_2, int var3_3, boolean var4_4) {
        block6: {
            block5: {
                if (var4_4) {
                    var5_5 = this.coin;
lbl3:
                    // 2 sources

                    while (true) {
                        var8_6 = new StringBuilder(String.valueOf(var5_5));
                        if (!var4_4) break block5;
                        var7_7 = "\u5fbd\u7ae0";
lbl7:
                        // 2 sources

                        while (true) {
                            var7_7 = var8_6.append(var7_7).toString();
                            var8_6 = Ui.i();
                            if (var4_4) {
                                var5_5 = 53;
lbl12:
                                // 2 sources

                                while (true) {
                                    var6_8 = Ms.i().getStringWidth(var7_7);
                                    var9_9 = GameRun.g;
                                    var9_9 = GameRun.g;
                                    var8_6.drawUi(var5_5, var1_1 - (var6_8 >> 1) - 1, var2_2, 8 | 32, 0);
                                    var8_6 = Ui.i();
                                    var9_9 = GameRun.g;
                                    var9_9 = GameRun.g;
                                    var8_6.drawString(var7_7, var1_1, var2_2 + 3, 1 | 32, var3_3, 1);
                                    return;
                                }
                            }
                            break block6;
                            break;
                        }
                        break;
                    }
                }
                var5_5 = this.money;
                ** while (true)
            }
            var7_7 = "\u91d1";
            ** while (true)
        }
        var5_5 = 52;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawMyMon() {
        block8: {
            block7: {
                block9: {
                    block11: {
                        block10: {
                            this.drawEffectImage(this.myB.getMon(), 220, 164);
                            var4_1 = this.mList_id[this.myB.getMon().monster[0]][1];
                            var3_2 = this.myB.action;
                            if (this.myB.ceff[0] == 0) break block10;
                            var1_3 = -3;
lbl6:
                            // 2 sources

                            while (this.myB.ceff[0] != 0) {
                                var2_4 = 3;
lbl8:
                                // 2 sources

                                while (this.myB.action == 0) {
                                    var5_5 = true;
lbl10:
                                    // 2 sources

                                    while (true) {
                                        if (this.drawCartoonOne(1, 1, var4_1 * 3 + var3_2, var1_3 + 266, var2_4 + 236, var5_5, 1)) {
                                            if (this.myB.getMon().monsterPro[0] >= 1) break block7;
                                            this.myB.action = (byte)2;
                                            this.myB.dead = 1;
                                        }
lbl15:
                                        // 4 sources

                                        while (true) {
                                            this.myB.ceff[0] = (byte)Ms.i().mathSpeedN((int)this.myB.ceff[0], 0, 1, true);
                                            this.drawMonsterHp(this.myB.getMon(), 241, 237, 50, 0, 1, this.myB.chp);
                                            this.drawMonsterHp(this.myB.getMon(), 241, 242, 50, 1, 2, this.myB.getMon().monsterPro[1]);
                                            var7_6 = this.myB;
                                            var6_7 = Ms.i();
                                            var3_2 = this.myB.chp;
                                            var2_4 = this.myB.getMon().monsterPro[0];
                                            if (this.myB.chp < this.myB.getMon().monsterPro[0]) {
                                                var1_3 = 20;
lbl25:
                                                // 2 sources

                                                while (true) {
                                                    var7_6.chp = var6_7.mathSpeedN((int)var3_2, var2_4, var1_3, true);
                                                    return;
                                                }
                                            }
                                            break block8;
                                            break;
                                        }
                                        break;
                                    }
                                }
                                break block9;
                            }
                            break block11;
                        }
                        var1_3 = 0;
                        ** GOTO lbl6
                    }
                    var2_4 = 0;
                    ** GOTO lbl8
                }
                var5_5 = false;
                ** while (true)
            }
            this.myB.action = 0;
            ** while (true)
        }
        var1_3 = 6;
        ** while (true)
    }

    public void drawPauseIco(int n) {
        n = 0;
        while (n < this.b_ico) {
            Ui.i().drawImage(this.imgIco[n], this.pkey.button_pos[6][n][0], this.pkey.button_pos[6][n][1], 0);
            n = (byte)(n + 1);
        }
        return;
    }

    public void exitNidus() {
        run_state = -10;
        this.mon[1] = null;
        this.initNidusMap(1);
    }

    /*
     * Exception decompiling
     */
    public void falselly(int var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.IllegalStateException: Backjump on non jumping statement @NONE, blocks:[] lbl18 : TryStatement: try { 1[TRYBLOCK]
         * 
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
         *     at org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:550)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:111)
         *     at java.base/java.lang.Thread.run(Thread.java:840)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled force condition propagation
     */
    public byte findItem(int n, int n2, boolean bl) {
        byte by;
        byte by2 = by = 0;
        int n3 = n;
        if (n == -2) {
            n3 = this.findItemType(n2);
            by2 = by;
        }
        while (true) {
            if (by2 >= this.itemsLength[n3]) {
                if (!bl) return -1;
                return 0;
            }
            if (this.items[n3][by2][0] == n2) {
                if (!bl) return by2;
                return this.items[n3][by2][1];
            }
            by2 = (byte)(by2 + 1);
        }
    }

    /*
     * Enabled force condition propagation
     */
    public byte findItemType(int n) {
        if (n < 16) {
            return (byte)0;
        }
        if (n < 35) {
            return (byte)1;
        }
        if (n >= 58) return (byte)3;
        return (byte)2;
    }

    /*
     * Unable to fully structure code
     */
    public byte findMonster(int var1_1, int var2_2) {
        var3_3 = 0;
        while (true) {
            if (var3_3 >= this.myMon_length) {
                var3_3 = -1;
                return var3_3;
            }
            if (this.myMonsters[var3_3].monster[0] == var1_1 && this.myMonsters[var3_3].monster[2] >= var2_2) ** continue;
            var3_3 = (byte)(var3_3 + 1);
        }
    }

    public byte findMonsterMinLv(int n, int n2) {
        byte by = -1;
        byte by2 = (byte)(this.myMon_length - 1);
        while (true) {
            byte by3;
            block5: {
                block6: {
                    if (by2 <= -1) {
                        return by;
                    }
                    by3 = by;
                    if (this.myMonsters[by2].monster[0] != n) break block5;
                    by3 = by;
                    if (this.myMonsters[by2].monster[2] < n2) break block5;
                    if (by == -1) break block6;
                    by3 = by;
                    if (this.myMonsters[by2].monster[2] >= this.myMonsters[by].monster[2]) break block5;
                }
                by3 = by2;
            }
            by2 = (byte)(by2 - 1);
            by = by3;
        }
    }

    /*
     * Unable to fully structure code
     */
    public boolean gameCheckRegIsOK() {
        if (this.rmsSms[6] == 10) {
            var1_1 = true;
lbl3:
            // 2 sources

            while (true) {
                System.out.println("gameCheckRegIsOK reged= " + var1_1);
                return var1_1;
            }
        }
        var1_1 = false;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void getEnemy(byte[] var1_1, int var2_2, int var3_3) {
        if (var2_2 == -1) {
            Ms.i();
            if (Ms.getRandom((int)100) < 5 && this.monPro.length > 6) {
                var2_2 = 6;
lbl6:
                // 2 sources

                while (true) {
                    Ms.i();
                    var1_1[1] = (byte)(Ms.getRandom((int)(this.monPro[2] + 1)) + this.monPro[1]);
lbl10:
                    // 2 sources

                    while (true) {
                        var1_1[0] = (byte)var2_2;
                        return;
                    }
                    break;
                }
            }
            var4_4 = this.monPro;
            Ms.i();
            if (this.monPro.length > 6) {
                var2_2 = 3;
lbl18:
                // 2 sources

                while (true) {
                    var2_2 = var4_4[Ms.getRandom((int)var2_2) + 3];
                    ** continue;
                    break;
                }
            }
            var2_2 = this.monPro.length - 3;
            ** continue;
        }
        var1_1[1] = (byte)var3_3;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public byte getItem(int n, int n2) {
        if (this.addItem(n, n2) != 1) return -1;
        this.say("\u83b7\u5f97\uff1a\u201c" + this.getNameItem((byte)n) + "\u201dx" + n2, 0);
        return 1;
    }

    /*
     * Enabled force condition propagation
     */
    public byte getItemCount(int n) {
        if (this.buyItemID == 2) return 0;
        this.findItemType(n);
        int n2 = 0;
        while (n2 < this.items[this.item_type].length) {
            if (this.items[this.item_type][n2][0] == n) {
                return this.items[this.item_type][n2][1];
            }
            ++n2;
        }
        return 0;
    }

    public void getMagic(Monster monster) {
        byte[] byArray = new byte[6];
        byArray[1] = 7;
        byArray[2] = 14;
        byArray[3] = 21;
        byArray[4] = 28;
        byArray[5] = 35;
        this.getSkill = (byte)-1;
        int n = 0;
        while (n < byArray.length) {
            if (monster.monster[n + 8] == -1 && monster.monster[2] >= byArray[n]) {
                this.getSkill(n, monster.monster[3]);
                monster.monster[n + 8] = this.getSkill;
            }
            n = (byte)(n + 1);
        }
        return;
    }

    /*
     * Enabled force condition propagation
     */
    public byte getMonster(int n, int n2, int n3, int n4) {
        Monster monster = new Monster(this, n, n2, n4);
        if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
            this.say("\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1", 0);
            return -1;
        }
        if (this.getMonster(monster, n3, true) != 1) {
            this.say("\u83b7\u5f97\u5ba0\u7269\uff1a" + this.getNameMon((byte)n), 0);
            return 1;
        }
        this.say("\u643a\u5e26\u5df2\u6ee1\uff0c" + this.getNameMon(monster.monster[0]) + "\u5df2\u8f6c\u5165\u5bc4\u653e\u5904", 0);
        return 1;
    }

    public String getNameCity(int n) {
        return this.city_name[n].toString();
    }

    public String getNameItem(int n) {
        return this.item_name[n].toString();
    }

    public String getNameMon(int n) {
        return this.NAME[n].toString();
    }

    public String getNameMonsterInfo(int n) {
        return this.monsterInfo[n].toString();
    }

    /*
     * Unable to fully structure code
     */
    public void goBUY_ITEM(int var1_1, int var2_2) {
        if (var2_2 != 1) {
            this.setAction_str(new String[]{"\u9053\u5177", "\u77ff\u77f3", "\u5fbd\u7ae0"});
lbl3:
            // 2 sources

            while (true) {
                this.cur_a = (byte)var1_1;
                this.cur_b = (byte)var2_2;
                var3_3 = this.select[0];
                this.select[0][0] = 0;
                var3_3[1] = 0;
                GameRun.run_state = 18;
                this.list_rows = (byte)6;
                this.buyOk = 0;
                this.popMenu = (byte)-1;
                var3_3 = Ms.i().getStream("data/shop.d", -1);
                Ms.i();
                Ms.skip = 0;
                this.buyItem = Ms.i().create2Array(var3_3);
                this.buyPrice = Ms.i().createShort2Array(var3_3, 0);
                var3_3 = null;
                return;
            }
        }
        this.setAction_str(new String[]{"\u9053\u5177", "\u8f85\u52a9", "\u5377\u8f74"});
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void goBattle() {
        block6: {
            this.first_battle = 0;
            this.lastSkill = 0;
            this.b_c = 0;
            this.cur_a = 0;
            this.mon_in_battle = null;
            this.mon_in_battle = new byte[this.max_takes + 1];
            this.levelUp_in_battle = null;
            var2_1 = this.max_takes;
            this.levelUp_in_battle = new byte[var2_1][2];
            this.proReplace = null;
            var2_1 = this.myMonsters.length;
            this.proReplace = new short[var2_1][7];
            this.myB = new Battle(this.myMonsters);
            this.enemy_init();
            var1_2 = 0;
            block0: while (true) {
                if (var1_2 >= this.myMon_length) {
                    var2_1 = 0;
lbl19:
                    // 2 sources

                    while (true) {
                        if (var2_1 < this.myMon_length) break block0;
lbl21:
                        // 3 sources

                        while (true) {
                            if (this.effectImage == null) {
                                this.effectImage = Ms.i().createImageArray(7, "data/brow/e");
                            }
                            if (this.imgBattle == null) {
                                this.imgBattle = Ms.i().createImageArray(5, "data/battle/b");
                            }
                            this.map.my.state = (byte)15;
                            GameRun.run_state = -30;
                            this.view_state = (byte)-1;
                            new CreateThread(this, 1);
                            return;
                        }
                        break;
                    }
                }
                this.myMonsters[var1_2].effect = (byte)7;
                this.myMonsters[var1_2].effect_time = 0;
                this.myMonsters[var1_2].monster[1] = var1_2;
                this.proReplace[var1_2][6] = this.myMonsters[var1_2].monster[2];
                var1_2 = (byte)(var1_2 + 1);
            }
            if (this.myMonsters[var2_1].monsterPro[0] <= 0) break block6;
            var3_3 = this.mon_in_battle;
            var4_4 = this.mon_in_battle;
            var4_4[0] = var1_2 = (byte)(var4_4[0] + 1);
            var3_3[var1_2] = this.myMonsters[var2_1].monster[1];
            if (var2_1 == 0) ** GOTO lbl21
            this.changeMonster(this.myMonsters[var2_1], this.myMonsters[0]);
            ** while (true)
        }
        var2_1 = (byte)(var2_1 + 1);
        ** while (true)
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

    /*
     * Unable to fully structure code
     */
    public void goMAIN_MENU() {
        GameRun.mc.logo_c = 29;
        GameRun.mc.image_logo = null;
        this.setNull(true);
        this.myMonsters = null;
        this.cMonsters = null;
        System.gc();
        GameRun.mc.createFlashImage();
        GameRun.mc.goMain_menu();
        this.setAction_str(new String[]{"\u8bfb\u53d6\u8fdb\u5ea6", "\u65b0\u6e38\u620f", "\u58f0\u97f3", "\u6e38\u620f\u5e2e\u52a9", "\u5173   \u4e8e", "\u9000\u51fa\u6e38\u620f"});
        if (this.rmsOther[0] == -1) {
            var2_1 = true;
lbl12:
            // 2 sources

            while (true) {
                this.selecty = var1_2 = (byte)var2_1;
                this.selectx = var1_2;
                return;
            }
        }
        var2_1 = false;
        ** while (true)
    }

    public void goNidus(int n) {
        run_state = 66;
        this.mini_state = (byte)16;
        this.setStringB("\u67e5\u770b\u5b75\u5316#n\u9009\u62e9\u86cb#n\u79bb\u5f00", Constants_H.WIDTH, 3);
        this.popMenu = (byte)n;
        this.b_c = (byte)-2;
    }

    public void goVIEW_COMPUTER(int n) {
        run_state = 65;
        this.setStringB("\u5b58\u653e#n\u53d6\u51fa#n\u79bb\u5f00", Constants_H.WIDTH, 3);
        this.popMenu = (byte)n;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void goVIEW_MONSTER() {
        GameRun.run_state = 35;
        this.cur_c = 0;
        this.selecty = 0;
        this.selectx = 0;
        if (this.mini_state == 6) {
            var1_1 = this.cMon_count;
lbl7:
            // 2 sources

            while (true) {
                this.t_length = var1_1;
                var2_2 /* !! */  = this.select[0];
                this.select[0][1] = 0;
                var2_2 /* !! */ [0] = 0;
                this.popMenu = (byte)-1;
                this.list_rows = (byte)5;
                this.mon_action = 0;
                this.setStringB("\u751f\u547d#n\u80fd\u91cf#n\u6863\u6b21", Constants_H.WIDTH, 0);
                this.setStringB("\u529b\u91cf#n\u9632\u5fa1#n\u654f\u6377", Constants_H.WIDTH, 1);
                if (this.mini_state == 6) {
                    var2_2 /* !! */  = (byte[])this.cMonsters[this.select[0][0]];
lbl19:
                    // 2 sources

                    while (true) {
                        this.cur_mon = (Monster)var2_2 /* !! */ ;
                        if (this.t_length != 0) {
                            this.setShowPro(this.cur_mon);
                            this.initMonStream(2, this.mList_id[this.cur_mon.monster[0]][0], 1);
                        }
                        return;
                    }
                }
                break;
            }
        } else {
            var1_1 = this.myMon_length;
            ** continue;
        }
        var2_2 /* !! */  = (byte[])this.myMonsters[this.select[0][0]];
        ** while (true)
    }

    public void goYouPAUSE(int n) {
        run_state = 97;
        this.selectx = 0;
        this.selecty = (byte)n;
        this.setPauseS(0);
        Sound.i().soundStop();
        this.say_c = 0;
        this.view_state = 1;
        this.mini_state = (byte)3;
        this.buyItemID = 0;
        this.buyOk = 0;
        this.gogoString = "\u91d1\u5c5e\u514b\u91ce\u517d\uff0c\u91ce\u517d\u514b\u690d\u7269\uff0c\u690d\u7269\u514b\u98de\u884c\uff0c\u98de\u884c\u514b\u6d77\u6d0b\uff0c\u6d77\u6d0b\u514b\u91d1\u5c5e";
    }

    void healMonster(Monster monster) {
        monster.effect = (byte)7;
        monster.monsterPro[1] = monster.monsterPro[3];
        monster.monsterPro[0] = monster.monsterPro[2];
    }

    public void healMonster(boolean bl) {
        byte by = 0;
        while (true) {
            if (by >= this.myMon_length) {
                if (bl) {
                    this.say("\u60a8\u643a\u5e26\u7684\u5ba0\u7269\u5df2\u56de\u590d\u3002", 0);
                }
                return;
            }
            this.healMonster(this.myMonsters[by]);
            by = (byte)(by + 1);
        }
    }

    public void initBattle() {
        System.gc();
        byte[] byArray = this.src_c;
        byte[] byArray2 = this.src_c;
        byte[] byArray3 = this.src_c;
        this.src_c[3] = 0;
        byArray3[2] = 0;
        byArray2[1] = 0;
        byArray[0] = 0;
        this.getBattleBG(this.enB, this.enB.getMon());
        this.getBattleBG(this.myB, this.myB.getMon());
        this.setEnemyThrow();
        this.setMyThrow();
    }

    /*
     * Enabled force condition propagation
     */
    public void initImgIco() {
        if (this.imgIco != null) {
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

    /*
     * Unable to fully structure code
     */
    public void initMonPro(int var1_1, boolean var2_2) {
        Ms.i();
        Ms.skip = 0;
        var5_3 = Ms.i();
        var4_4 = new StringBuilder("data/map/");
        if (var2_2) {
            var3_5 = "m";
lbl8:
            // 2 sources

            while (true) {
                var3_5 = var5_3.getStream(var4_4.append((String)var3_5).append(var1_1).append(".d").toString(), -1);
                this.monPro = Ms.i().createArray((byte[])var3_5);
                this.mapMove = Ms.i().createArray((byte[])var3_5);
                this.mapRect = Ms.i().create2Array((byte[])var3_5);
                return;
            }
        }
        var3_5 = "boss";
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public void initMonStream(int n, int n2, int n3) {
        String string = "data/npc" + n + "/" + n2;
        boolean bl = true;
        if (n == 2) {
            bl = this.isNpc2ImageType(n2);
        }
        if (this.mon[n3] == null) {
            this.mon[n3] = Ms.i().createSprite(string, bl);
            return;
        }
        Ms.i().setSprite(this.mon[n3], string, bl);
    }

    /*
     * Unable to fully structure code
     */
    public void initNidusMap(int var1_1) {
        block6: {
            if (this.nidusMap == null) {
                this.nidusMap = new byte[5];
            }
            var2_2 = 0;
            var3_3 = 0;
            if (var1_1 != 0) ** GOTO lbl17
            var1_1 = var3_3;
            while (true) {
                if (var1_1 >= this.nidusMap.length) lbl-1000:
                // 2 sources

                {
                    return;
                }
                this.nidusMap[var1_1] = -1;
                var1_1 = (byte)(var1_1 + 1);
            }
            block2: while (this.nidusMap[var2_2] == -1) lbl-1000:
            // 3 sources

            {
                while (true) {
                    var2_2 = (byte)(var2_2 + 1);
lbl17:
                    // 2 sources

                    if (var2_2 < this.nidusMap.length) continue block2;
                    ** continue;
                    break;
                }
lbl19:
                // 1 sources

                ** GOTO lbl-1000
            }
            if (this.getRid(var2_2) == -2) break block6;
            this.map.npc[0][this.nidusMap[var2_2]].other[4] = 1;
            this.map.npc[0][this.nidusMap[var2_2]].other[7] = (byte)(this.monster_pro[this.getNid(var2_2)][6] + 17);
            ** GOTO lbl-1000
        }
        this.map.npc[0][this.nidusMap[var2_2]].other[4] = 0;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void initSkillList(Monster var1_1) {
        this.skill_list[8] = 0;
        var3_2 = 7;
        block0: while (true) {
            if (var3_2 <= -1) {
                var3_2 = 1;
lbl6:
                // 2 sources

                while (true) {
                    if (var3_2 < 8) break block0;
                    return;
                }
            }
            this.skill_list[var3_2] = var1_1.monster[var3_2 + 8];
            if (this.skill_list[var3_2] != -1) {
                var5_3 = this.skill_list;
                var5_3[8] = (byte)(var5_3[8] + 1);
            }
            var3_2 = (byte)(var3_2 - 1);
        }
        var4_5 = var3_2;
        while (true) {
            if (var4_5 <= 0 || this.skill_list[var4_5] <= this.skill_list[var4_5 - 1]) {
                var3_2 = (byte)(var3_2 + 1);
                ** continue;
            }
            var2_4 = this.skill_list[var4_5];
            this.skill_list[var4_5] = this.skill_list[var4_5 - 1];
            this.skill_list[var4_5 - 1] = var2_4;
            var4_5 = (byte)(var4_5 - 1);
        }
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isMoney(int n, boolean bl) {
        if (bl) {
            if (this.money >= n) {
                this.money -= n;
                return true;
            }
            this.say("\u91d1\u94b1\u4e0d\u8db3\uff01", 0);
            return false;
        }
        if (this.coin >= n) {
            this.coin -= n;
            return true;
        }
        this.say("\u5fbd\u7ae0\u4e0d\u8db3\uff01", 0);
        return false;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isMoneyItem(int n, int n2, int n3, boolean bl) {
        if (this.findItem(-2, n2, true) + n3 > 99) {
            this.say("\u6570\u91cf\u5df2\u5230\u4e0a\u9650", 0);
            return false;
        }
        if (bl) {
            if (this.money >= this.sell_money * n3) {
                this.money -= this.sell_money * n3;
                return true;
            }
            if (this.money < this.sell_money * n3) {
                this.say("\u91d1\u94b1\u4e0d\u8db3\uff01", -1, 0);
                return false;
            }
            this.say("\u80cc\u5305\u7a7a\u95f4\u4e0d\u8db3\u3002", 0, -1);
            return false;
        }
        if (this.coin >= this.sell_money * n3) {
            this.coin -= this.sell_money * n3;
            return true;
        }
        if (this.coin < this.sell_money * n3) {
            this.say("\u5fbd\u7ae0\u4e0d\u8db3\uff01", 0);
            return false;
        }
        this.say("\u80cc\u5305\u7a7a\u95f4\u4e0d\u8db3\u3002", 0);
        return false;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isNpc2ImageType(int n) {
        int n2 = 0;
        while (n2 < this.npc2ImageType.length) {
            if (this.npc2ImageType[n2] == n) {
                return false;
            }
            n2 = (byte)(n2 + 1);
        }
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public void keyGameOver1(boolean var1_1) {
        block3: {
            if (!Ms.i().key_S1_Num5()) break block3;
            if (this.popMenu == 1) {
                this.goMAIN_MENU();
lbl4:
                // 3 sources

                while (true) {
                    this.popMenu = (byte)-1;
lbl6:
                    // 3 sources

                    while (true) {
                        Ms.i().keyRelease();
                        return;
                    }
                    break;
                }
            }
            if (this.popMenu != 0) ** GOTO lbl4
            System.out.println("loadGame soars");
            this.loadGame();
            ** while (true)
        }
        if (!Ms.i().key_Up_Down()) ** GOTO lbl6
        this.popMenu = (byte)(this.popMenu ^ 1);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void keyLIST_INFO() {
        block6: {
            block5: {
                block4: {
                    if (Ms.i().key_delay()) lbl-1000:
                    // 6 sources

                    {
                        return;
                    }
                    if (!Ms.i().key_S1_Num5()) break block4;
                    if (this.monInfoList[this.getMonInfo_dir()] != 0) {
                        this.goMONSTER_INFO(this.getMonInfo_dir());
                    }
                    ** GOTO lbl-1000
                }
                if (!Ms.i().key_S2()) break block5;
                this.action_str = null;
                this.monInfo_dir = null;
                this.doPaint(0);
                this.goYouPAUSE(3);
                ** GOTO lbl-1000
            }
            if (!Ms.i().key_Left_Right()) break block6;
            this.cur_a = Ms.i().select((int)this.cur_a, 0, 4);
            this.infoStart = 0;
            if (this.cur_a <= 0) ** GOTO lbl23
            var1_1 = 0;
            while (true) {
                block7: {
                    if (var1_1 < this.cur_a) break block7;
lbl23:
                    // 2 sources

                    this.t_length = (byte)this.monInfo_dir[this.cur_a].length;
                    var2_2 = this.select[0];
                    this.select[0][1] = 0;
                    var2_2[0] = 0;
                    ** GOTO lbl-1000
                }
                this.infoStart = (byte)(this.infoStart + this.monInfo_dir[var1_1].length);
                var1_1 = (byte)(var1_1 + 1);
            }
        }
        if (!Ms.i().key_Up_Down()) ** GOTO lbl-1000
        Ms.i().selectS(this.select[0], 0, (int)this.t_length, (int)this.list_rows);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void key_gameRun() {
        block27: {
            block26: {
                if (GameRun.run_state == 98) {
                    if (Ms.i().key_Num0() || Ms.i().key_S1_Num5()) {
                        GameRun.mc.doShowNotify();
                    }
                    Ms.i().keyRelease();
                    Log.d((String)"soars", (String)"doShowNotify2");
lbl7:
                    // 9 sources

                    return;
                }
                if (this.say_c <= 0) break block26;
                Ms.i().keyRelease();
                ** GOTO lbl7
            }
            if (this.say_c >= 0) break block27;
            if (this.say_s == 0 && Ms.i().key_S1_Num5()) {
                this.say_c = 0;
                this.doSayOverSms();
            }
            Ms.i().keyRelease();
            ** GOTO lbl7
        }
        switch (GameRun.run_state) lbl-1000:
        // 43 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                while (true) {
                    if (!Ms.i().key_S1_Num5() && !Ms.i().key_S2()) ** GOTO lbl7
                    Ms.i().keyRelease();
                    ** GOTO lbl7
                    break;
                }
            }
            case -10: {
                this.map.key_map();
                ** GOTO lbl-1000
            }
            case -31: {
                this.keyBattleState();
                ** GOTO lbl-1000
            }
            case -15: {
                if (Ms.i().key_delay()) ** GOTO lbl7
                if (this.b_c != 1 || this.say_s != 0) ** GOTO lbl-1000
                this.b_c = 0;
                ** GOTO lbl-1000
            }
            case 61: {
                this.keyGameOver1(true);
                ** GOTO lbl-1000
            }
            case 60: {
                Ms.i().keyRelease();
                GameRun.run_state = 61;
                this.setAction_str(new String[]{"\u7ee7\u7eed", "\u653e\u5f03"});
                this.popMenu = 0;
                ** GOTO lbl-1000
            }
            case 67: {
                if (!Ms.i().key_S2()) ** GOTO lbl-1000
                this.goLIST_INFO(false);
                Ms.i().keyRelease();
                ** GOTO lbl-1000
            }
            case 68: {
                this.keyLIST_INFO();
                ** GOTO lbl-1000
            }
            case 97: {
                if (Ms.i().key_delay()) ** GOTO lbl7
                if (!Ms.i().key_S1_Num5()) ** GOTO lbl105
                Ms.i().keyRelease();
                if (this.selectx != 0) ** GOTO lbl83
                if (this.selecty != 0) ** GOTO lbl67
                if (this.buyOk != 1) ** GOTO lbl65
                GameRun.run_state = 100;
                this.b_c = 0;
                this.buyOk = 0;
                ** GOTO lbl-1000
lbl65:
                // 1 sources

                this.buyOk = 1;
                ** GOTO lbl-1000
lbl67:
                // 1 sources

                if (this.selecty != 1) ** GOTO lbl70
                this.goVIEW_MONSTER();
                ** GOTO lbl-1000
lbl70:
                // 1 sources

                if (this.selecty != 2) ** GOTO lbl73
                this.goMY_BAG(0);
                ** GOTO lbl-1000
lbl73:
                // 1 sources

                if (this.selecty != 3) ** GOTO lbl76
                this.goLIST_INFO(true);
                ** GOTO lbl-1000
lbl76:
                // 1 sources

                if (this.selecty != 4) ** GOTO lbl79
                this.map.goMission(0, true);
                ** GOTO lbl-1000
lbl79:
                // 1 sources

                if (this.selecty != 5) ** GOTO lbl-1000
                this.goRUN_IN_MAP(true);
                this.action_str = null;
                ** GOTO lbl-1000
lbl83:
                // 1 sources

                if (this.selecty != 0) ** GOTO lbl89
                if (this.buyOk != 2) ** GOTO lbl87
                this.loadGame();
                ** GOTO lbl-1000
lbl87:
                // 1 sources

                this.buyOk = (byte)2;
                ** GOTO lbl-1000
lbl89:
                // 1 sources

                if (this.selecty != 1) ** GOTO lbl93
                this.isChangeSound = true;
                Sound.i().keyVolume(0);
                ** GOTO lbl-1000
lbl93:
                // 1 sources

                if (this.selecty != 2) ** GOTO lbl96
                GameRun.mc.goHELP_dialog(1);
                ** GOTO lbl-1000
lbl96:
                // 1 sources

                if (this.selecty != 3) ** GOTO lbl-1000
                if (this.buyOk != 3) ** GOTO lbl103
                GameRun.run_state = 0;
                this.action_str = null;
                this.goMAIN_MENU();
                this.buyOk = 0;
                ** GOTO lbl-1000
lbl103:
                // 1 sources

                this.buyOk = (byte)3;
                ** GOTO lbl-1000
lbl105:
                // 1 sources

                if (!Ms.i().key_S2()) ** GOTO lbl114
                if (this.buyOk != 0) ** GOTO lbl110
                this.action_str = null;
                this.goRUN_IN_MAP(true);
                ** GOTO lbl-1000
lbl110:
                // 1 sources

                this.doPaint(0);
                GameRun.run_state = 97;
                this.buyOk = 0;
                ** GOTO lbl-1000
lbl114:
                // 1 sources

                if (this.buyOk != 0) ** GOTO lbl-1000
                if (!Ms.i().key_Left_Right()) ** GOTO lbl120
                this.selectx = (byte)(this.selectx ^ 1);
                this.selecty = 0;
                this.setPauseS(this.selectx);
                ** GOTO lbl-1000
lbl120:
                // 1 sources

                if (!Ms.i().key_Up_Down()) ** GOTO lbl-1000
                this.selecty = Ms.i().select((int)this.selecty, 0, this.action_str.length - 1);
                ** GOTO lbl-1000
            }
            case 51: {
                if (!Ms.i().key_Num0()) ** GOTO lbl-1000
                this.map.my.state = 0;
                this.map.eventGoing = (byte)2;
                Ms.i().keyRelease();
                this.map.dialog_no = (byte)-1;
                this.goGO_RUNINMAP();
                ** GOTO lbl-1000
            }
            case 35: {
                if (Ms.i().key_delay()) ** GOTO lbl7
                if (this.cur_c != 0) ** GOTO lbl141
                if (this.mini_state != 6) ** GOTO lbl139
                var1_1 = this.cMonsters;
lbl136:
                // 2 sources

                while (true) {
                    this.key_MONSTER_LIST(var1_1);
                    ** GOTO lbl-1000
                    break;
                }
lbl139:
                // 1 sources

                var1_1 = this.myMonsters;
                ** continue;
lbl141:
                // 1 sources

                if (this.cur_c != 1) ** GOTO lbl144
                this.keyMagicUI();
                ** GOTO lbl-1000
lbl144:
                // 1 sources

                if (this.cur_c != 2) ** GOTO lbl-1000
                this.keyEvolveUI();
                ** GOTO lbl-1000
            }
            case 65: {
                if (!Ms.i().key_delay()) ** break;
                ** continue;
                this.popState();
                ** GOTO lbl-1000
            }
            case 66: {
                this.keyNidus();
                ** GOTO lbl-1000
            }
            case 25: {
                this.keyMY_BAG();
                ** GOTO lbl-1000
            }
            case 18: {
                this.keyBuyItem();
                ** GOTO lbl-1000
            }
            case 69: {
                Mg.i().key(this);
                ** GOTO lbl-1000
            }
            case -20: {
                SMSSender.i((GameRun)this).key();
                ** GOTO lbl-1000
            }
            case -21: 
        }
        SMSSender.i((GameRun)this).keyLevel();
        Sound.i().soundStop();
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public void levelPro(int n, boolean bl) {
        byte by;
        if (bl) {
            short s = this.proReplace[n][6];
            byte[] byArray = this.monster_pro[this.myMonsters[n].monster[0]];
            short s2 = (short)(byArray[0] + byArray[7] * s / 10);
            s2 = this.getbuffRateV(this.myMonsters[n], s2);
            this.proReplace[n][0] = (short)(this.myMonsters[n].monsterPro[2] - s2);
            s2 = (short)(byArray[1] + byArray[8] * s / 10);
            this.proReplace[n][1] = (short)(this.myMonsters[n].monsterPro[3] - s2);
            s2 = (short)(byArray[3] + byArray[10] * s / 10);
            this.proReplace[n][3] = (short)(this.myMonsters[n].monsterPro[6] - s2);
            s2 = (short)(byArray[4] + byArray[11] * s / 10);
            this.proReplace[n][4] = (short)(this.myMonsters[n].monsterPro[7] - s2);
            s = (short)(byArray[2] + byArray[9] * s / 10);
            this.proReplace[n][5] = (short)(this.myMonsters[n].monsterPro[5] - s);
            byArray = null;
            return;
        }
        byte[] byArray = this.myMonsters[n].monster;
        byArray[2] = by = (byte)(byArray[2] + 1);
        byArray = this.monster_pro[this.myMonsters[n].monster[0]];
        this.myMonsters[n].monsterPro[2] = (short)(byArray[0] + byArray[7] * by / 10);
        this.myMonsters[n].monsterPro[3] = (short)(byArray[1] + byArray[8] * by / 10);
        this.myMonsters[n].monsterPro[6] = (byte)(byArray[3] + byArray[10] * by / 10);
        this.myMonsters[n].monsterPro[7] = (byte)(byArray[4] + byArray[11] * by / 10);
        this.myMonsters[n].monsterPro[5] = (byte)(byArray[2] + byArray[9] * by / 10);
        this.myMonsters[n].resetPro(this);
        byArray = null;
        this.healMonster(this.myMonsters[n]);
    }

    /*
     * Unable to fully structure code
     */
    public void map_flashString() {
        block7: {
            var1_1 = Constants_H.WIDTH__;
            var2_2 = Constants_H.HEIGHT__;
            var3_3 = Constants_H.HEIGHT__ / 2;
            this.setSay();
            if (this.say_c <= 0 || GameRun.run_state == 98) break block7;
            if (!this.map.fontSizeControl) {
                Ms.i();
                Ms.font.setSize(22);
            }
            var4_4 = this.showS;
            if (this.say_mode == 0) {
                var1_1 = var3_3 - (this.showS.length >> 1) * 25 - 12;
lbl13:
                // 2 sources

                while (true) {
                    this.showString(var4_4, var1_1, this.say_s, 1);
                    if (this.say_s == 0) {
                        this.say_c = (byte)(this.say_c - 1);
lbl17:
                        // 5 sources

                        while (true) {
                            Ms.i();
                            Ms.font.setSize(26);
                            return;
                        }
                    }
                    break;
                }
            } else {
                var1_1 = var2_2 - 50 - 18;
                ** continue;
            }
            this.say_s = Ms.i().mathSpeedDown(this.say_s, 3, true);
            ** GOTO lbl17
        }
        if (this.say_c >= 0 || GameRun.run_state == 98) ** GOTO lbl17
        Ms.i();
        Ms.font.setSize(22);
        this.showString(this.showS, var3_3 - (this.showS.length >> 1) * 25 - 12, this.say_s, 2);
        if (this.say_s != 0) {
            this.say_s = Ms.i().mathSpeedDown(this.say_s, 3, true);
        }
        if (!this.pkey.isSelect(0, 0, var1_1, var2_2)) ** GOTO lbl17
        this.pkey.setKey5();
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void paint_gameRun(Graphics var1_1) {
        switch (GameRun.run_state) lbl-1000:
        // 25 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                while (true) {
                    this.map_flashString();
                    return;
                }
            }
            case -10: {
                this.map.paint_map((Graphics)var1_1 /* !! */ );
                ** GOTO lbl-1000
            }
            case -50: {
                this.drawBattleBG();
                this.drawSelectMenu((Graphics)var1_1 /* !! */ , true, 252);
                if (this.src_c[2] != 0) ** GOTO lbl22
                var2_2 = true;
lbl14:
                // 2 sources

                while (true) {
                    this.drawSrcLine((Graphics)var1_1 /* !! */ , 15, 124, 10, false, var2_2);
                    if (this.src_c[3] != 0) ** GOTO lbl24
                    var2_2 = true;
lbl18:
                    // 2 sources

                    while (true) {
                        this.drawSrcLine((Graphics)var1_1 /* !! */ , 131, 124, 10, true, var2_2);
                        this.drawPlayerAppear((Graphics)var1_1 /* !! */ );
                        ** GOTO lbl-1000
                        break;
                    }
                    break;
                }
lbl22:
                // 1 sources

                var2_2 = false;
                ** continue;
lbl24:
                // 1 sources

                var2_2 = false;
                ** continue;
            }
            case -31: {
                this.drawBattleBG();
                this.drawPlayer((Graphics)var1_1 /* !! */ );
                if (this.battle_state == 2) ** GOTO lbl35
                var2_3 = true;
lbl31:
                // 2 sources

                while (true) {
                    this.drawSelectMenu((Graphics)var1_1 /* !! */ , var2_3, 252);
                    this.paintBattleState((Graphics)var1_1 /* !! */ );
                    ** GOTO lbl-1000
                    break;
                }
lbl35:
                // 1 sources

                var2_3 = false;
                ** continue;
            }
            case -19: {
                this.drawBattleBG();
                this.drawSelectMenu((Graphics)var1_1 /* !! */ , true, 252);
                this.drawMyMon();
                this.drawEnemy();
                if (this.cThrowY < 17) {
                    this.cThrowS = (short)(this.cThrowS + this.cThrowY);
                    this.cThrowY = Ms.i().mathSpeedN((int)this.cThrowY, 17, 2, false);
                }
                this.cThrowX = Ms.i().mathSpeedN((int)this.cThrowX, 0, 8, false);
                Ui.i().drawImage(this.imgItem[0], 377 - this.cThrowX, (int)this.cThrowS, 1 | 32);
                ** GOTO lbl-1000
            }
            case -15: {
                this.paintBATTLE_OVER();
                ** GOTO lbl-1000
            }
            case 97: {
                Ui.i().drawK0(-2, 0, 640 + 4, 33, 0);
                Ui.i().drawString("\u8bad\u7ec3\u5e08\u7b49\u7ea7\uff1a" + this.rmsOther[3], 320, 2, 17, 1, 2);
                this.drawPauseMenu(320 - 100 - 5, 45, 210, 235);
                Ui.i().drawK0(-2, 360 - 25 - 8, 640 + 4, 33, 0);
                this.gogoWordM(this.gogoString, 360 - 25 - 6, 16, 3, 0, 2);
                if (this.buyOk == 0) ** GOTO lbl63
                var1_1 /* !! */  = "\u662f\u5426\u4fdd\u5b58\u6e38\u620f?";
                if (this.buyOk != 2) ** GOTO lbl65
                var1_1 /* !! */  = "\u662f\u5426\u8bfb\u53d6\u8fdb\u5ea6?";
lbl61:
                // 3 sources

                while (true) {
                    this.showString((String)var1_1 /* !! */ , 60, 0);
lbl63:
                    // 2 sources

                    Ui.i().drawYesNo(true, true);
                    ** GOTO lbl-1000
                    break;
                }
lbl65:
                // 1 sources

                if (this.buyOk != 3) ** GOTO lbl61
                var1_1 /* !! */  = "\u4e4b\u524d\u672a\u4fdd\u5b58\u7684\u90e8\u5206\u5c06\u4f1a\u4e22\u5931\uff0c\u662f\u5426\u7ee7\u7eed\uff1f";
                ** continue;
            }
            case 61: {
                GameRun.mc.drawRectBG();
                this.showString("\u4f60\u8981\u7ee7\u7eed\u6e38\u620f\uff0c\u786e\u5b9a\u5417\uff1f", 360 - 50, 0);
                this.drawSelectMenu(this.action_str, 320 - 50, 180 - 50, 100, 2, 0, this.popMenu);
                ** GOTO lbl-1000
            }
            case 60: {
                GameRun.mc.drawRectBG();
                this.showString("\u6218\u6597\u5931\u8d25\u4e86,\u8bad\u7ec3\u5e08\u7684\u68a6\u60f3\u4e0d\u80fd\u5b9e\u73b0\u4e86!", 180, 0);
                Ui.i().drawYesNo(true, true);
                ** GOTO lbl-1000
            }
            case 98: {
                GameRun.mc.drawRectBG();
                Ui.i().drawK1(-5, 360 - 75, 640 + 10, 75, 3);
                this.showStringM("\u6e38\u620f\u6682\u505c\uff0c\u70b9\u51fb\u5c4f\u5e55\u8fd4\u56de\u3002", 320, 360 - 50 - 2, 9, 3);
                ** GOTO lbl-1000
            }
            case -30: {
                this.drawDarkScreen();
                ** GOTO lbl-1000
            }
            case 100: {
                this.b_c = 1;
                this.showString("\u4fdd\u5b58\u6e38\u620f\u4e2d", 20, 0);
                ** GOTO lbl-1000
            }
            case 51: {
                this.map.drawBlackSRC((Graphics)var1_1 /* !! */ , 30, true);
                this.drawZero("\u7ed3\u675f", 360 - 10);
                ** GOTO lbl-1000
            }
            case 25: {
                this.drawMY_BAG(0, 0, 640, 360);
                ** GOTO lbl-1000
            }
            case 18: {
                this.drawBUY_ITEM();
                ** GOTO lbl-1000
            }
            case 68: {
                this.drawLIST_INFO();
                ** GOTO lbl-1000
            }
            case 67: {
                this.drawMONSTER_INFO(this.getMonInfo_dir());
                ** GOTO lbl-1000
            }
            case 35: {
                if (this.cur_c != 0) ** GOTO lbl115
                if (this.mini_state != 6) ** GOTO lbl113
                var1_1 /* !! */  = this.cMonsters;
lbl110:
                // 2 sources

                while (true) {
                    this.drawMONSTER_UI((Monster[])var1_1 /* !! */ );
                    ** GOTO lbl-1000
                    break;
                }
lbl113:
                // 1 sources

                var1_1 /* !! */  = this.myMonsters;
                ** continue;
lbl115:
                // 1 sources

                if (this.cur_c != 1) ** GOTO lbl123
                if (this.mini_state != 6) ** GOTO lbl121
                var1_1 /* !! */  = this.cMonsters[this.selecty];
lbl118:
                // 2 sources

                while (true) {
                    this.drawMagicUI(var1_1 /* !! */ );
                    ** GOTO lbl-1000
                    break;
                }
lbl121:
                // 1 sources

                var1_1 /* !! */  = this.myMonsters[this.selecty];
                ** continue;
lbl123:
                // 1 sources

                if (this.cur_c != 2) ** GOTO lbl-1000
                this.drawEvolveUI(1, this.selecty, false);
                ** GOTO lbl-1000
            }
            case 65: {
                this.drawVIEW_COMPUTER();
                ** GOTO lbl-1000
            }
            case 66: {
                this.drawNidus(200, 225);
                ** GOTO lbl-1000
            }
            case 69: {
                Mg.i().paint();
                ** GOTO lbl-1000
            }
            case -20: {
                SMSSender.i((GameRun)this).paint();
                ** GOTO lbl-1000
            }
            case -21: 
        }
        SMSSender.i((GameRun)this).paintLevel();
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void popState() {
        block37: {
            block36: {
                block17: {
                    block31: {
                        block35: {
                            block34: {
                                block32: {
                                    block33: {
                                        block29: {
                                            block30: {
                                                block27: {
                                                    block28: {
                                                        block24: {
                                                            block26: {
                                                                block25: {
                                                                    block23: {
                                                                        block20: {
                                                                            block21: {
                                                                                block18: {
                                                                                    block16: {
                                                                                        block14: {
                                                                                            block15: {
                                                                                                block19: {
                                                                                                    if (this.buyOk == 0 && Ms.i().key_Up_Down()) {
                                                                                                        this.popMenu = Ms.i().select((int)this.popMenu, 0, this.about_d.length - 1);
lbl3:
                                                                                                        // 21 sources

                                                                                                        return;
                                                                                                    }
                                                                                                    if (!Ms.i().key_S1_Num5()) break block17;
                                                                                                    if (!Ms.i().equals(this.about_d[this.popMenu], "\u6280\u80fd") && !Ms.i().equals(this.about_d[this.popMenu], "\u5929\u8d4b")) break block18;
                                                                                                    if (this.mini_state != 6) break block19;
                                                                                                    var3_1 = this.cMonsters[this.select[0][0]];
lbl9:
                                                                                                    // 2 sources

                                                                                                    while (true) {
                                                                                                        this.initSkillList(var3_1);
                                                                                                        if (this.view_state <= 0) break block14;
                                                                                                        if (this.mini_state != 6) break block15;
                                                                                                        var1_5 = this.cMonsters[this.select[0][0]].monster[3];
lbl14:
                                                                                                        // 2 sources

                                                                                                        while (true) {
                                                                                                            this.bg_c = var1_5;
lbl16:
                                                                                                            // 3 sources

                                                                                                            while (Ms.i().equals(this.about_d[this.popMenu], "\u6280\u80fd")) {
                                                                                                                var2_7 = 0;
lbl18:
                                                                                                                // 2 sources

                                                                                                                while (true) {
                                                                                                                    this.restMove(1, var2_7);
                                                                                                                    ** GOTO lbl3
                                                                                                                    break;
                                                                                                                }
                                                                                                            }
                                                                                                            break block16;
                                                                                                            break;
                                                                                                        }
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                var3_1 = this.myMonsters[this.select[0][0]];
                                                                                                ** while (true)
                                                                                            }
                                                                                            var1_5 = this.myMonsters[this.select[0][0]].monster[3];
                                                                                            ** while (true)
                                                                                        }
                                                                                        if (this.view_state >= 0 || this.myB == null) ** GOTO lbl16
                                                                                        this.bg_c = this.myB.bg_id;
                                                                                        ** GOTO lbl16
                                                                                    }
                                                                                    var2_7 = 1;
                                                                                    ** while (true)
                                                                                }
                                                                                if (!Ms.i().equals(this.about_d[this.popMenu], "\u53c2\u6218")) break block20;
                                                                                if (this.myMonsters[this.select[0][0]].monsterPro[0] <= 0) break block21;
                                                                                if (this.view_state >= 0) ** GOTO lbl44
                                                                                var2_8 = 1;
                                                                                while (true) {
                                                                                    block22: {
                                                                                        if (var2_8 <= this.mon_in_battle[0]) break block22;
                                                                                        while (true) {
                                                                                            this.initSkillList(this.myMonsters[this.select[0][0]]);
lbl44:
                                                                                            // 2 sources

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
lbl57:
                                                                                            // 2 sources

                                                                                            while (true) {
                                                                                                this.popMenu = (byte)-1;
                                                                                                ** GOTO lbl3
                                                                                                break;
                                                                                            }
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    if (this.mon_in_battle[var2_8] == this.myMonsters[this.select[0][0]].monster[1]) ** continue;
                                                                                    if (var2_8 == this.mon_in_battle[0]) {
                                                                                        var4_9 = this.mon_in_battle;
                                                                                        var3_2 = this.mon_in_battle;
                                                                                        var3_2[0] = var1_6 = (byte)(var3_2[0] + 1);
                                                                                        var4_9[var1_6] = this.myMonsters[this.select[0][0]].monster[1];
                                                                                    }
                                                                                    var2_8 = (byte)(var2_8 + 1);
                                                                                }
                                                                            }
                                                                            this.say("\u5f53\u524d\u5ba0\u7269\u4e0d\u80fd\u53c2\u6218", 0);
                                                                            ** while (true)
                                                                        }
                                                                        if (!Ms.i().equals(this.about_d[this.popMenu], "\u8fdb\u5316")) break block23;
                                                                        this.setEvolveStringB(this.myMonsters[this.select[0][0]]);
                                                                        this.bg_c = this.myMonsters[this.select[0][0]].monster[3];
                                                                        this.b_c = 0;
                                                                        this.restMove(2, 0);
                                                                        ** GOTO lbl3
                                                                    }
                                                                    if (!Ms.i().equals(this.about_d[this.popMenu], "\u653e\u751f")) break block24;
                                                                    if (this.isMyMonsters(this.select[0][0])) break block25;
                                                                    this.say("\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01", 0);
                                                                    ** GOTO lbl3
                                                                }
                                                                if (this.buyOk != 1) break block26;
                                                                this.buyOk = 0;
                                                                this.delMonster(this.select[0][0]);
                                                                if (this.select[0][0] == this.myMon_length) {
                                                                    var3_3 = this.select[0];
                                                                    var3_3[0] = (byte)(var3_3[0] - 1);
                                                                }
                                                                this.initMonStream(2, this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0], 1);
                                                                this.setShowPro(this.myMonsters[this.select[0][0]]);
                                                                this.introT = Constants_H.WIDTH_H;
                                                                this.t_length = this.myMon_length;
                                                                this.popMenu = (byte)-1;
                                                                ** GOTO lbl3
                                                            }
                                                            this.buyOk = 1;
                                                            this.gogoString = "\u653e\u751f\u7684\u5ba0\u7269\u5c06\u4f1a\u6d88\u5931\uff0c\u662f\u5426\u7ee7\u7eed\uff1f";
                                                            ** GOTO lbl3
                                                        }
                                                        if (!Ms.i().equals(this.about_d[this.popMenu], "\u5b58\u653e")) break block27;
                                                        if (GameRun.run_state != 35) break block28;
                                                        this.putMonster();
                                                        ** GOTO lbl3
                                                    }
                                                    this.mini_state = (byte)4;
                                                    this.view_state = 1;
                                                    this.goVIEW_MONSTER();
                                                    ** GOTO lbl3
                                                }
                                                if (!Ms.i().equals(this.about_d[this.popMenu], "\u53d6\u51fa")) break block29;
                                                if (GameRun.run_state != 35) break block30;
                                                this.takenMonster();
                                                ** GOTO lbl3
                                            }
                                            this.mini_state = (byte)6;
                                            this.view_state = 1;
                                            this.goVIEW_MONSTER();
                                            ** GOTO lbl3
                                        }
                                        if (!Ms.i().equals(this.about_d[this.popMenu], "\u5356\u5ba0")) break block31;
                                        if (this.buyOk != 1) break block32;
                                        this.buyOk = 0;
                                        this.money += this.sell_money;
                                        this.say("\u83b7\u5f97\u91d1\u94b1\uff1a" + this.sell_money, 0);
                                        if (this.mini_state != 6) break block33;
                                        this.setTakenMonster();
                                        ** GOTO lbl3
                                    }
                                    this.setPutMonster();
                                    ** GOTO lbl3
                                }
                                if (this.mini_state != 4 || this.isMyMonsters(this.select[0][0])) break block34;
                                this.say("\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01", 0);
                                ** GOTO lbl3
                            }
                            this.buyOk = 1;
                            if (this.mini_state != 4) break block35;
                            var3_4 = this.myMonsters[this.select[0][0]];
lbl142:
                            // 2 sources

                            while (true) {
                                this.sellMonster(var3_4);
                                this.gogoString = "\u83b7\u5f97\u91d1\u94b1\uff1a" + this.sell_money + "\uff0c\u662f\u5426\u5356\u51fa\uff1f";
                                ** GOTO lbl3
                                break;
                            }
                        }
                        var3_4 = this.cMonsters[this.select[0][0]];
                        ** while (true)
                    }
                    if (!Ms.i().equals(this.about_d[this.popMenu], "\u79bb\u5f00")) ** GOTO lbl3
                    this.goRUN_IN_MAP(false);
                    ** GOTO lbl3
                }
                if (!Ms.i().key_S2()) ** GOTO lbl3
                if (this.buyOk == 0) break block36;
                this.buyOk = 0;
                ** GOTO lbl3
            }
            if (GameRun.run_state != 65) break block37;
            this.goRUN_IN_MAP(false);
            ** GOTO lbl3
        }
        this.popMenu = (byte)-1;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public boolean runPauseIco() {
        var1_1 = 0;
        while (true) {
            block12: {
                block15: {
                    block14: {
                        block13: {
                            if (var1_1 >= this.b_ico) {
                                var2_2 = false;
lbl5:
                                // 2 sources

                                return var2_2;
                            }
                            if (this.map.my.state != 0 || !this.pkey.isSelect(this.pkey.button_pos[10][var1_1][0], this.pkey.button_pos[10][var1_1][1], this.pkey.button_pos[10][var1_1][2], this.pkey.button_pos[10][var1_1][3])) break block12;
                            if (this.b_ico == 2) {
                                this.isTalk = false;
                                this.pkey.setKey5();
                            }
                            this.pkey.initPointer();
                            if (var1_1 == 0) {
                                if (this.b_ico == 2) {
                                    var1_1 = 7;
lbl15:
                                    // 2 sources

                                    while (true) {
                                        this.b_ico = (byte)var1_1;
lbl17:
                                        // 3 sources

                                        while (true) {
                                            var2_2 = true;
                                            ** continue;
                                            break;
                                        }
                                        break;
                                    }
                                }
                                var1_1 = 2;
                                ** continue;
                            }
                            if (GameRun.run_state == 98) ** GOTO lbl17
                            if (var1_1 == 3) {
                                this.goYouPAUSE(0);
lbl25:
                                // 3 sources

                                while (true) {
                                    this.b_ico = (byte)2;
                                    ** continue;
                                    break;
                                }
                            }
                            if (var1_1 != 6) break block13;
                            SMSSender.i((GameRun)this).go(0, true);
                            ** GOTO lbl25
                        }
                        if (var1_1 == 2) {
                            Ms.key = 48;
lbl34:
                            // 5 sources

                            while (true) {
                                Ms.keyRepeat = true;
                                ** continue;
                                break;
                            }
                        }
                        if (var1_1 != 4) break block14;
                        Ms.key = 49;
                        ** GOTO lbl34
                    }
                    if (var1_1 != 5) break block15;
                    Ms.key = 51;
                    ** GOTO lbl34
                }
                if (var1_1 != 1) ** GOTO lbl34
                Ms.key = 57;
                ** continue;
            }
            var1_1 = (byte)(var1_1 + 1);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void run_gameRun() {
        switch (GameRun.run_state) lbl-1000:
        // 23 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                return;
            }
            case -10: {
                this.map.run_map();
                ** GOTO lbl-1000
            }
            case -50: {
                this.runMonsterAppear();
                ** GOTO lbl-1000
            }
            case -31: {
                this.runBattleState();
                ** GOTO lbl-1000
            }
            case -19: {
                if (this.cThrowX != 0 || this.b_c != 0) ** GOTO lbl59
                var2_1 = this.items[this.selectx][this.select[0][0]][0];
                this.deleteItems(var2_1, 1);
                var2_1 = (short)((new byte[]{1, 3, 14})[var2_1 - 9] * 30 + 50 - this.enB.getMon().monster[2] + 60 / this.enB.getMon().monster[2] - this.enB.getMon().monsterPro[0] * 100 / this.enB.getMon().monsterPro[2]);
                var2_1 = var3_3 = (short)((7 - (this.enB.getMon().monster[5] - 1) * 2) * var2_1 / 10);
                if (this.enB.getMon().isEffect(3)) {
                    var2_1 = (short)(var3_3 + 30);
                }
                var5_5 = null;
                if (this.cMon_count != this.max_monsters || this.myMon_length != this.max_takes) ** GOTO lbl30
                this.say("\u6240\u80fd\u643a\u5e26\u7684\u5ba0\u7269\u5df2\u7ecf\u8fbe\u5230\u4e0a\u9650\uff01", -1);
                this.enB.act_num = 1;
                this.myB.act_num = 0;
                GameRun.run_state = -31;
                this.battle_state = (byte)9;
                ** GOTO lbl-1000
lbl30:
                // 1 sources

                Ms.i();
                if (Ms.getRandom((int)100) >= var2_1) ** GOTO lbl41
                this.enB.action = (byte)2;
                this.enB.dead = 1;
                this.say("\u6355\u83b7" + this.getNameMon(this.enB.getMon().monster[0]) + "\u5df2\u6210\u529f\uff01", 0);
                if (this.getMonster(this.enB.getMon(), -1, false) == 0) {
                    this.myMonsters[this.myMon_length - 1].monster[1] = (byte)(this.myMon_length - 1);
                }
                GameRun.run_state = -31;
                this.goBattleExp(false);
                ** GOTO lbl-1000
lbl41:
                // 1 sources

                this.b_c = 1;
                var5_5 = new StringBuffer("\u6ca1\u6709\u6355\u83b7\u5230" + this.getNameMon(this.enB.getMon().monster[0]));
                if (!this.myB.getMon().isMonReel(41) && !this.enB.getMon().isEffect(4) && !this.enB.getMon().isEffect(3)) ** GOTO lbl51
                this.enB.act_num = 1;
                this.myB.act_num = 0;
                GameRun.run_state = -31;
                this.battle_state = (byte)9;
lbl48:
                // 2 sources

                while (true) {
                    this.say(var5_5.toString(), 0);
                    ** GOTO lbl-1000
                    break;
                }
lbl51:
                // 1 sources

                var6_7 = new StringBuilder("#n").append(this.getNameMon(this.enB.getMon().monster[0]));
                Ms.i();
                var2_1 = (short)Ms.getRandom((int)3);
                var5_5.append(var6_7.append((new String[]{"\u6d41\u7740\u6cea\u9003\u8dd1\u4e86\uff01", "\u62fc\u4e86\u547d\u7684\u9003\u8dd1\u4e86\uff01", "\u76ef\u4e86\u4f60\u4e00\u773c\uff0c\u9003\u8d70\u4e86\uff01"})[var2_1]).toString());
                var6_7 = null;
                ** continue;
lbl59:
                // 1 sources

                if (this.b_c != 1 || this.say_c != 0) ** GOTO lbl-1000
                this.arangeMonster();
                this.setNullBattle();
                this.goGO_RUNINMAP();
                ** GOTO lbl-1000
            }
            case -86: 
            case -15: {
                if (this.b_c != 0) ** GOTO lbl136
                if (this.levelUp_in_battle[this.myB.getMon().monster[1]][0] != 1) ** GOTO lbl102
                this.levelUp_in_battle[this.myB.getMon().monster[1]][0] = 0;
                this.b_c = 1;
                this.say_s = 52;
                this.levelPro(this.myB.now_id, true);
                this.setStringB("\u751f\u547d;+" + this.proReplace[this.myB.now_id][0] + "#n" + "\u80fd\u91cf" + ";+" + this.proReplace[this.myB.now_id][1], Constants_H.WIDTH, 0);
                this.setStringB("\u529b\u91cf;+" + this.proReplace[this.myB.now_id][3] + "#n" + "\u9632\u5fa1" + ";+" + this.proReplace[this.myB.now_id][4] + "#n" + "\u654f\u6377" + ";+" + this.proReplace[this.myB.now_id][5], Constants_H.WIDTH, 1);
                this.initMonStream(2, this.mList_id[this.myB.getMon().monster[0]][0], 1);
lbl74:
                // 2 sources

                while (true) {
                    if (this.myB.now_id < this.myMon_length) ** GOTO lbl-1000
                    var2_2 = 0;
                    var3_4 = false;
                    var6_8 = new StringBuffer("");
lbl79:
                    // 2 sources

                    while (true) {
                        if (var2_2 < this.myMon_length) ** GOTO lbl105
                        if (var3_4) {
                            var6_8.append("\u53ef\u4ee5\u8fdb\u5316\u4e86");
                        }
                        var5_6 = new StringBuffer("");
                        var3_4 = false;
                        var2_2 = 0;
lbl87:
                        // 2 sources

                        while (true) {
                            if (var2_2 < 5) ** GOTO lbl121
                            if (var3_4) {
                                var5_6.append("\u7ecf\u9a8c\u5df2\u6ee1\uff0c\u53ef\u4ee5\u5b75\u5316\u4e86\u3002");
                                if (!Ms.i().equals(var6_8, "")) {
                                    var6_8.append("#n");
                                }
                                var6_8.append(var5_6.toString());
                            }
                            if (!Ms.i().equals(var6_8, "")) {
                                this.say(var6_8.toString(), -1);
                            }
                            this.setNullBattle();
                            this.goGO_RUNINMAP();
                            ** GOTO lbl-1000
                            break;
                        }
                        break;
                    }
                    break;
                }
lbl102:
                // 1 sources

                var5_6 = this.myB;
                var5_6.now_id = (byte)(var5_6.now_id + 1);
                ** continue;
lbl105:
                // 1 sources

                var4_9 = var3_4;
                if (this.myMonsters[var2_2].monster[5] > 0) {
                    var4_9 = var3_4;
                    if (this.evolve[var2_2]) {
                        var4_9 = var3_4;
                        if (this.isEvolveKind(this.myMonsters[var2_2].monster[4], this.myMonsters[var2_2].monster[2]) == -1) {
                            if (!Ms.i().equals(var6_8, "")) {
                                var6_8.append("\u3001");
                            }
                            var6_8.append(this.getNameMon(this.myMonsters[var2_2].monster[0]));
                            this.evolve[var2_2] = false;
                            var4_9 = true;
                        }
                    }
                }
                var2_2 = (byte)(var2_2 + 1);
                var3_4 = var4_9;
                ** continue;
lbl121:
                // 1 sources

                var4_9 = var3_4;
                if (this.getRid(var2_2) == -2) ** GOTO lbl125
                if (this.getNexp(var2_2, 1) == this.getNexp(var2_2, 3)) ** GOTO lbl129
                var4_9 = var3_4;
lbl125:
                // 3 sources

                while (true) {
                    var2_2 = (byte)(var2_2 + 1);
                    var3_4 = var4_9;
                    ** continue;
                    break;
                }
lbl129:
                // 1 sources

                if (!Ms.i().equals((StringBuffer)var5_6, "")) {
                    var5_6.append("\u3001");
                }
                var5_6.append(this.monsterT[this.monster_pro[this.getNid(var2_2)][6]] + "\u7684\u5ba0\u7269\u86cb");
                var4_9 = true;
                ** continue;
lbl136:
                // 1 sources

                if (this.b_c != 1) ** GOTO lbl-1000
                this.say_s = Ms.i().mathSpeedDown(this.say_s, 4, true);
                ** GOTO lbl-1000
            }
            case -11: {
                this.goRUN_IN_MAP(false);
                ** GOTO lbl-1000
            }
            case -30: {
                if (this.createOver != -1) ** GOTO lbl-1000
                this.b_c = var1_10 = (byte)(this.b_c + 1);
                if (var1_10 < 8) ** GOTO lbl-1000
                this.goMontsterAppear();
                ** GOTO lbl-1000
            }
            case 100: {
                if (this.b_c != 1) ** GOTO lbl-1000
                this.saveGame();
                this.say("\u6e38\u620f\u5df2\u4fdd\u5b58\u3002", 0);
                this.b_c = 0;
                this.goRUN_IN_MAP(true);
                ** GOTO lbl-1000
            }
            case 35: {
                this.mon_action_c = var1_11 = (byte)(this.mon_action_c + 1);
                if (var1_11 > 50) {
                    this.mon_action_c = 0;
                    this.mon_action = 1;
                }
                if (this.cur_c != 2 || this.b_c != -1 || this.say_s != 0) ** GOTO lbl-1000
                this.goView();
                ** GOTO lbl-1000
            }
            case 69: {
                Mg.i().run();
                ** GOTO lbl-1000
            }
            case -20: {
                SMSSender.i((GameRun)this).run();
                ** GOTO lbl-1000
            }
            case -21: 
        }
        SMSSender.i((GameRun)this).runLevel();
        ** while (true)
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

    /*
     * Unable to fully structure code
     */
    public void say(String var1_1, int var2_2) {
        Log.e((String)"soars", (String)var1_1);
        if (var1_1.equals("#7\u70b9\u51fb\u5c4f\u5e55\u6216\u7528\u5bfc\u822a\u952e#0\u63a7\u5236\u4e0a\u4e0b\u5de6\u53f3\u79fb\u52a8\u3002")) {
            var3_3 = "#7\u70b9\u51fb\u5c4f\u5e55#0\u63a7\u5236\u4e0a\u4e0b\u5de6\u53f3\u79fb\u52a8\u3002";
lbl5:
            // 3 sources

            while (true) {
                this.sayStr.add(var3_3);
                this.sayFlag.add(var2_2);
                this.setSay();
                return;
            }
        }
        var3_3 = var1_1;
        if (!var1_1.contains("\u83dc\u5355\u952e")) ** GOTO lbl5
        var1_1.replace("\u83dc\u5355\u952e", "\u53f3\u4e0b\u65b9\u5de5\u5177\u6309\u94ae");
        var3_3 = var1_1;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void say(String var1_1, int var2_2, int var3_3) {
        block2: {
            this.showS = Ms.i().groupString(var1_1, Constants_H.WIDTH - 50);
            this.say_s = Constants_H.WIDTH;
            this.say_mode = 0;
            if (var2_2 == 0) {
                this.say_c = (byte)15;
lbl6:
                // 4 sources

                return;
            }
            if (var2_2 != -1) break block2;
            this.say_c = (byte)-1;
            this.sayOverSms = (byte)var3_3;
            ** GOTO lbl6
        }
        if (var2_2 != 1) ** GOTO lbl6
        this.say_c = (byte)15;
        this.say_mode = 1;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void setAimBattle(int var1_1) {
        this.mini_state = (byte)var1_1;
        if (this.mini_state == 1) {
            var2_2 = this.myB;
lbl4:
            // 2 sources

            while (true) {
                this.am = var2_2;
                if (this.mini_state == 1) {
                    var2_2 = this.enB;
lbl8:
                    // 2 sources

                    while (true) {
                        this.dm = var2_2;
                        return;
                    }
                }
                break;
            }
        } else {
            var2_2 = this.enB;
            ** continue;
        }
        var2_2 = this.myB;
        ** while (true)
    }

    public void setMagic(int n) {
        int n2 = n;
        if (n > 5) {
            n2 = 5;
        }
        this.initMagicStream(n2);
        this.now_action_Magic[n2] = 0;
        this.now_time_Magic[n2] = 0;
    }

    public void setNull(boolean bl) {
        if (this.map != null) {
            this.map.setNull();
        }
        if (this.mon[0] != null) {
            this.mon[0].nullIMFA();
        }
        if (this.mon[1] != null) {
            this.mon[1].nullIMFA();
        }
        if (bl) {
            this.data_null();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void setSay() {
        block3: {
            block2: {
                if (this.say_c != 0 || this.sayStr.size() == 0) lbl-1000:
                // 5 sources

                {
                    return;
                }
                var2_1 = this.sayStr.remove(0);
                var1_2 = this.sayFlag.remove(0);
                this.showS = Ms.i().groupString(var2_1, Constants_H.WIDTH - 50);
                this.say_s = Constants_H.WIDTH;
                this.say_mode = 0;
                if (var1_2 != 0) break block2;
                this.say_c = (byte)15;
                ** GOTO lbl-1000
            }
            if (var1_2 != -1) break block3;
            this.say_c = (byte)-1;
            ** GOTO lbl-1000
        }
        if (var1_2 != 1) ** GOTO lbl-1000
        this.say_c = (byte)15;
        this.say_mode = 1;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void skyCheckRegFull(int var1_1) {
        switch (var1_1) lbl-1000:
        // 2 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                return;
            }
            case 1: {
                this.map.setRegState(true);
                GameRun.mc.skyNewGame();
                ** GOTO lbl-1000
            }
            case 2: 
        }
        this.map.setRegState(true);
        GameRun.mc.skyContinueGame();
        ** while (true)
    }

    public void start() {
        this.goRUN_IN_MAP(true);
        this.map.insertNpc();
        this.line_max = (byte)2;
        this.cityName_c = (byte)25;
        if (this.map.anole_temp != -2) {
            this.map.anole_type = this.map.anole_temp;
            this.map.anole_temp = (byte)-2;
            this.map.setAnole();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void valueMend(Monster var1_1) {
        block3: {
            block2: {
                if (var1_1.monsterPro[0] >= 0) break block2;
                var1_1.monsterPro[0] = 0;
lbl3:
                // 3 sources

                while (var1_1.monsterPro[1] < 0) {
                    var1_1.monsterPro[1] = 0;
lbl5:
                    // 3 sources

                    return;
                }
                break block3;
            }
            if (var1_1.monsterPro[0] <= var1_1.monsterPro[2]) ** GOTO lbl3
            var1_1.monsterPro[0] = var1_1.monsterPro[2];
            ** GOTO lbl3
        }
        if (var1_1.monsterPro[1] <= var1_1.monsterPro[3]) ** GOTO lbl5
        var1_1.monsterPro[1] = var1_1.monsterPro[3];
        ** while (true)
    }
}
