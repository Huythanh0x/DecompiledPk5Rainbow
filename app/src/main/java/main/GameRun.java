package main;

import android.util.Log;
import com.PetKing5_480x800.PetKing5;
import com.nokia.mid.ui.DirectGraphics;
import com.uc.paymentsdk.util.Constants;
import dm.Battle;
import dm.Monster;
import dm.Ms;
import dm.Sound;
import dm.Sprite;
import dm.Ui;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.media.Player;
import minigame.Mg;

/* loaded from: classes.dex */
public class GameRun extends GameRun_F {
    public static boolean isSay = false;
    private StringBuffer[] NAME;
    Battle am;
    public byte b_c;
    public byte battle_type;
    public byte bg_c;
    private StringBuffer[] buff_help;
    private StringBuffer[] buff_name;
    private byte[][] buyItem;
    private short[][] buyPrice;
    short cThrowS;
    short cThrowX;
    short cThrowY;
    public byte cityName_c;
    private StringBuffer[] city_name;
    public byte createOver;
    public byte dead_c;

    /* renamed from: dm, reason: collision with root package name */
    Battle f133dm;
    private Image[] effectImage;
    Battle enB;
    public byte[][] enemyList;
    public int enemyOff;
    short exp;
    byte getSkill;
    private Image[] imgBG;
    private Image[] imgBattle;
    public Image[] imgIco;
    private Image[] imgItem;
    public byte[] inhesion;
    boolean isTalk;
    private byte[][] itemMine;
    private StringBuffer[] item_help;
    private Image item_img;
    private byte[][] item_modules;
    private StringBuffer[] item_name;
    private byte item_type;
    public byte[][] levelUp_in_battle;
    public byte line_max;
    public byte[][] mList_id;
    public byte[] makeLevel;
    public byte[] mapMove;
    public byte[][] mapRect;
    private byte[][] monAppearMap;
    private byte[][] monInfo_dir;
    public byte[] monPro;
    private byte mon_action;
    public byte[] mon_in_battle;
    private StringBuffer[] monsterInfo;
    private byte[][] monsterMake;
    public StringBuffer[] monsterT;
    public byte[][] monster_pro;
    public byte[][] mouduls;
    public byte[] musicNo;
    Battle myB;
    private StringBuffer[] nameTemp;
    public byte[] npc2ImageType;
    public short[][] proReplace;
    public byte say_c;
    public byte say_mode;
    public int say_s;
    public byte select_S;
    public byte select_T;
    private byte[][] skill;
    private StringBuffer[] skill_help;
    private StringBuffer[] skill_name;
    private byte[][] skill_up;
    String strHit;
    public byte t_battle_state;
    public byte t_length;
    public byte time_count;
    public byte immueEnemy = 0;
    public int money = Constants.PAYMENT_MAX;
    public int coin = 10;
    public byte view_state = 1;
    public byte threadType = 0;
    public byte mini_state = 0;
    public boolean isKillAll = false;
    public byte buyItemID = 0;
    public byte battle_state = 0;
    public byte buyOk = 0;
    public byte off = 0;
    private byte list_rows = 8;
    private byte infoStart = 0;
    int sell_money = 0;
    private byte mon_action_c = 0;
    private byte[] initFealty = {100, 120};
    private Boolean isChangeSound = false;
    public ArrayList<String> sayStr = new ArrayList<>();
    public ArrayList<Integer> sayFlag = new ArrayList<>();
    public byte sayOverSms = -1;
    byte[] zb = {-6, -4, -3, -2, -1, 0, 1, 2, 3, 4, 8, -3, 2, -1, 1, 1};
    private byte[][] Shuxing = {new byte[]{2, 3}, new byte[]{3, 4}, new byte[]{4}, new byte[]{0, 1}, new byte[]{1, 2}};
    private int hit_rate = 0;
    public byte magic_id = -2;
    public int magic_x = 0;
    public int magic_y = 0;
    public Sprite[] mon = new Sprite[2];
    public Sprite[] magic = new Sprite[6];
    private short[] now_action_Magic = new short[6];
    private short[] now_time_Magic = new short[6];
    public byte overMode = 0;
    private boolean[] evolve = {true, true, true, true, true};
    private byte[] now_action = new byte[2];
    private byte[] now_time = new byte[2];
    String[] battleSay = {Constants_H.BATTLE_TXT_12, Constants_H.BATTLE_TXT_13, Constants_H.BATTLE_TXT_14};
    public boolean isUpdateList = false;
    public byte first_battle = 0;
    public byte lastSkill = 0;
    private byte[] skill_list = new byte[9];
    public byte b_ico = 2;

    public GameRun(MainCanvas maincanvas) {
        mc = maincanvas;
        this.map = null;
        this.map = new Map(this);
        initOtherImage();
        Ui.i().initUiModules();
        loadRmsOther();
        loadRmsSms();
        SMSSender.i(this);
        PetKing5.gr = this;
    }

    public void goMAIN_MENU() {
        mc.logo_c = 29;
        mc.image_logo = null;
        setNull(true);
        this.myMonsters = null;
        this.cMonsters = null;
        System.gc();
        mc.createFlashImage();
        mc.goMain_menu();
        setAction_str(new String[]{Constants_H.PAUSE_TXT_5, Constants_H.PAUSE_TXT_9, Constants_H.PAUSE_TXT_6, Constants_H.PAUSE_TXT_7, Constants_H.PAUSE_TXT_10, Constants_H.PAUSE_TXT_11});
        byte b = (byte) (this.rmsOther[0] == -1 ? 1 : 0);
        this.selecty = b;
        this.selectx = b;
    }

    public void doPaint(int mode) {
        if (mode != 0) {
            this.b_c = (byte) mode;
        } else {
            run_state = -10;
        }
        mc.paint();
    }

    public void setNull(boolean bb) {
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
            data_null();
        }
    }

    public void start() {
        goRUN_IN_MAP(true);
        this.map.insertNpc();
        this.line_max = (byte) 2;
        this.cityName_c = (byte) 25;
        if (this.map.anole_temp != -2) {
            this.map.anole_type = this.map.anole_temp;
            this.map.anole_temp = (byte) -2;
            this.map.setAnole();
        }
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

    public void run_gameRun() {
        switch (run_state) {
            case -87:
            default:
                return;
            case -86:
            case -15:
                if (this.b_c == 0) {
                    if (this.levelUp_in_battle[this.myB.getMon().monster[1]][0] == 1) {
                        this.levelUp_in_battle[this.myB.getMon().monster[1]][0] = 0;
                        this.b_c = (byte) 1;
                        this.say_s = 52;
                        levelPro(this.myB.now_id, true);
                        setStringB("生命;+" + ((int) this.proReplace[this.myB.now_id][0]) + "#n" + Constants_H.PRO_TXT_1 + ";+" + ((int) this.proReplace[this.myB.now_id][1]), Constants_H.WIDTH, 0);
                        setStringB("力量;+" + ((int) this.proReplace[this.myB.now_id][3]) + "#n" + Constants_H.PRO_TXT_4 + ";+" + ((int) this.proReplace[this.myB.now_id][4]) + "#n" + Constants_H.PRO_TXT_5 + ";+" + ((int) this.proReplace[this.myB.now_id][5]), Constants_H.WIDTH, 1);
                        initMonStream(2, this.mList_id[this.myB.getMon().monster[0]][0], 1);
                    } else {
                        Battle battle = this.myB;
                        battle.now_id = (byte) (battle.now_id + 1);
                    }
                    if (this.myB.now_id >= this.myMon_length) {
                        boolean b = false;
                        StringBuffer sbuf = new StringBuffer("");
                        for (byte i = 0; i < this.myMon_length; i = (byte) (i + 1)) {
                            if (this.myMonsters[i].monster[5] > 0 && this.evolve[i] && isEvolveKind(this.myMonsters[i].monster[4], this.myMonsters[i].monster[2]) == -1) {
                                if (!Ms.i().equals(sbuf, "")) {
                                    sbuf.append("、");
                                }
                                sbuf.append(getNameMon(this.myMonsters[i].monster[0]));
                                this.evolve[i] = false;
                                b = true;
                            }
                        }
                        if (b) {
                            sbuf.append(Constants_H.BATTLE_TXT_17);
                        }
                        StringBuffer sbuf0 = new StringBuffer("");
                        boolean b2 = false;
                        for (byte i2 = 0; i2 < 5; i2 = (byte) (i2 + 1)) {
                            if (getRid(i2) != -2 && getNexp(i2, 1) == getNexp(i2, 3)) {
                                if (!Ms.i().equals(sbuf0, "")) {
                                    sbuf0.append("、");
                                }
                                sbuf0.append(((Object) this.monsterT[this.monster_pro[getNid(i2)][6]]) + Constants_H.TXT_96);
                                b2 = true;
                            }
                        }
                        if (b2) {
                            sbuf0.append(Constants_H.TXT_106);
                            if (!Ms.i().equals(sbuf, "")) {
                                sbuf.append("#n");
                            }
                            sbuf.append(sbuf0.toString());
                        }
                        if (!Ms.i().equals(sbuf, "")) {
                            say(sbuf.toString(), -1);
                        }
                        setNullBattle();
                        goGO_RUNINMAP();
                        return;
                    }
                    return;
                }
                if (this.b_c == 1) {
                    this.say_s = Ms.i().mathSpeedDown(this.say_s, 4, true);
                    return;
                }
                return;
            case -50:
                runMonsterAppear();
                return;
            case -31:
                runBattleState();
                return;
            case -30:
                if (this.createOver == -1) {
                    byte b3 = (byte) (this.b_c + 1);
                    this.b_c = b3;
                    if (b3 >= 8) {
                        goMontsterAppear();
                        return;
                    }
                    return;
                }
                return;
            case -21:
                SMSSender.i(this).runLevel();
                return;
            case -20:
                SMSSender.i(this).run();
                return;
            case -19:
                if (this.cThrowX == 0 && this.b_c == 0) {
                    byte id = this.items[this.selectx][this.select[0][0]][0];
                    deleteItems(id, 1);
                    byte[] CatchBall = {1, 3, 14};
                    short getRate = (short) (((7 - ((this.enB.getMon().monster[5] - 1) * 2)) * ((short) (((((CatchBall[id - 9] * 30) + 50) - this.enB.getMon().monster[2]) + (60 / this.enB.getMon().monster[2])) - ((this.enB.getMon().monsterPro[0] * 100) / this.enB.getMon().monsterPro[2])))) / 10);
                    if (this.enB.getMon().isEffect(3)) {
                        getRate = (short) (getRate + 30);
                    }
                    if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
                        say(Constants_H.TXT_43, -1);
                        this.enB.act_num = (byte) 1;
                        this.myB.act_num = (byte) 0;
                        run_state = -31;
                        this.battle_state = (byte) 9;
                        return;
                    }
                    Ms.i();
                    if (Ms.getRandom(100) < getRate) {
                        this.enB.action = (byte) 2;
                        this.enB.dead = (byte) 1;
                        say("捕获" + getNameMon(this.enB.getMon().monster[0]) + Constants_H.BATTLE_TXT_8, 0);
                        if (getMonster(this.enB.getMon(), -1, false) == 0) {
                            this.myMonsters[this.myMon_length - 1].monster[1] = (byte) (this.myMon_length - 1);
                        }
                        run_state = -31;
                        goBattleExp(false);
                        return;
                    }
                    this.b_c = (byte) 1;
                    StringBuffer str = new StringBuffer(Constants_H.BATTLE_TXT_9 + getNameMon(this.enB.getMon().monster[0]));
                    if (this.myB.getMon().isMonReel(41) || this.enB.getMon().isEffect(4) || this.enB.getMon().isEffect(3)) {
                        this.enB.act_num = (byte) 1;
                        this.myB.act_num = (byte) 0;
                        run_state = -31;
                        this.battle_state = (byte) 9;
                    } else {
                        String[] s = {Constants_H.TXT_55, Constants_H.TXT_56, Constants_H.TXT_57};
                        StringBuilder append = new StringBuilder("#n").append(getNameMon(this.enB.getMon().monster[0]));
                        Ms.i();
                        str.append(append.append(s[Ms.getRandom(3)]).toString());
                    }
                    say(str.toString(), 0);
                    return;
                }
                if (this.b_c == 1 && this.say_c == 0) {
                    arangeMonster();
                    setNullBattle();
                    goGO_RUNINMAP();
                    return;
                }
                return;
            case -11:
                goRUN_IN_MAP(false);
                return;
            case -10:
                this.map.run_map();
                return;
            case 35:
                byte b4 = (byte) (this.mon_action_c + 1);
                this.mon_action_c = b4;
                if (b4 > 50) {
                    this.mon_action_c = (byte) 0;
                    this.mon_action = (byte) 1;
                }
                if (this.cur_c == 2 && this.b_c == -1 && this.say_s == 0) {
                    goView();
                    return;
                }
                return;
            case 69:
                Mg.i().run();
                return;
            case 100:
                if (this.b_c == 1) {
                    saveGame();
                    say("游戏已保存。", 0);
                    this.b_c = (byte) 0;
                    goRUN_IN_MAP(true);
                    return;
                }
                return;
        }
    }

    public void paint_gameRun(Graphics g) {
        switch (run_state) {
            case -50:
                drawBattleBG();
                drawSelectMenu(g, true, 252);
                drawSrcLine(g, 15, 124, 10, false, this.src_c[2] == 0);
                drawSrcLine(g, 131, 124, 10, true, this.src_c[3] == 0);
                drawPlayerAppear(g);
                break;
            case -31:
                drawBattleBG();
                drawPlayer(g);
                drawSelectMenu(g, this.battle_state != 2, 252);
                paintBattleState(g);
                break;
            case -30:
                drawDarkScreen();
                break;
            case -21:
                SMSSender.i(this).paintLevel();
                break;
            case -20:
                SMSSender.i(this).paint();
                break;
            case -19:
                drawBattleBG();
                drawSelectMenu(g, true, 252);
                drawMyMon();
                drawEnemy();
                if (this.cThrowY < 17) {
                    this.cThrowS = (short) (this.cThrowS + this.cThrowY);
                    this.cThrowY = Ms.i().mathSpeedN(this.cThrowY, 17, 2, false);
                }
                this.cThrowX = Ms.i().mathSpeedN(this.cThrowX, 0, 8, false);
                Ui.i().drawImage(this.imgItem[0], 377 - this.cThrowX, this.cThrowS, 1 | 32);
                break;
            case -15:
                paintBATTLE_OVER();
                break;
            case -10:
                this.map.paint_map(g);
                break;
            case 18:
                drawBUY_ITEM();
                break;
            case 25:
                drawMY_BAG(0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_);
                break;
            case 35:
                if (this.cur_c != 0) {
                    if (this.cur_c != 1) {
                        if (this.cur_c == 2) {
                            drawEvolveUI(1, this.selecty, false);
                            break;
                        }
                    } else {
                        drawMagicUI(this.mini_state == 6 ? this.cMonsters[this.selecty] : this.myMonsters[this.selecty]);
                        break;
                    }
                } else {
                    drawMONSTER_UI(this.mini_state == 6 ? this.cMonsters : this.myMonsters);
                    break;
                }
                break;
            case 51:
                this.map.drawBlackSRC(g, 30, true);
                drawZero("结束", Constants_H.HEIGHT_ - 10);
                break;
            case Constants.JIFENGQUAN_G_RATIO /* 60 */:
                mc.drawRectBG();
                showString(Constants_H.TXT_59, Constants_H.HEIGHT_H_, 0);
                Ui.i().drawYesNo(true, true);
                break;
            case 61:
                mc.drawRectBG();
                showString(Constants_H.TXT_60, Constants_H.HEIGHT_ - 50, 0);
                drawSelectMenu(this.action_str, Constants_H.WIDTH_H_ - 50, Constants_H.HEIGHT_H_ - 50, 100, 2, 0, this.popMenu);
                break;
            case 65:
                drawVIEW_COMPUTER();
                break;
            case 66:
                drawNidus(Player.REALIZED, 225);
                break;
            case 67:
                drawMONSTER_INFO(getMonInfo_dir());
                break;
            case 68:
                drawLIST_INFO();
                break;
            case 69:
                Mg.i().paint();
                break;
            case 97:
                Ui.i().drawK0(-2, 0, Constants_H.WIDTH_ + 4, 33, 0);
                Ui.i().drawString(Constants_H.TXT_74 + ((int) this.rmsOther[3]), Constants_H.WIDTH_H_, 2, 17, 1, 2);
                drawPauseMenu((Constants_H.WIDTH_H_ - 100) - 5, 45, 210, 235);
                Ui.i().drawK0(-2, (Constants_H.HEIGHT_ - 25) - 8, Constants_H.WIDTH_ + 4, 33, 0);
                gogoWordM(this.gogoString, (Constants_H.HEIGHT_ - 25) - 6, 16, 3, 0, 2);
                if (this.buyOk != 0) {
                    String str = Constants_H.TXT_31;
                    if (this.buyOk == 2) {
                        str = Constants_H.TXT_32;
                    } else if (this.buyOk == 3) {
                        str = Constants_H.TXT_33;
                    }
                    showString(str, 60, 0);
                }
                Ui.i().drawYesNo(true, true);
                break;
            case 98:
                mc.drawRectBG();
                Ui.i().drawK1(-5, Constants_H.HEIGHT_ - 75, Constants_H.WIDTH_ + 10, 75, 3);
                showStringM(Constants_H.PAUSE_TXT_19, Constants_H.WIDTH_H_, (Constants_H.HEIGHT_ - 50) - 2, 9, 3);
                break;
            case 100:
                this.b_c = (byte) 1;
                showString(Constants_H.PAUSE_TXT_20, 20, 0);
                break;
        }
        map_flashString();
    }

    private boolean magicEffectRate(Battle dmB, Monster am, Monster dm2, int skill_no) {
        if (dm2.effect != 7) {
            return false;
        }
        byte buff = this.skill[skill_no][3];
        byte DebuffRate = this.skill[skill_no][2];
        if (DebuffRate == 0) {
            return false;
        }
        if (buff == 0) {
            if (dm2.isBuffRate(5)) {
                DebuffRate = (byte) (this.inhesion[5] + DebuffRate);
            } else if (dm2.isBuffRate(6)) {
                DebuffRate = (byte) (this.inhesion[6] + DebuffRate);
            }
        } else if (buff == 4) {
            if (dm2.isBuffRate(7)) {
                DebuffRate = (byte) (this.inhesion[7] + DebuffRate);
            } else if (dm2.isBuffRate(8)) {
                DebuffRate = (byte) (this.inhesion[8] + DebuffRate);
            }
        } else if (buff == 2 || buff == 5) {
            if (dm2.isBuffRate(11)) {
                DebuffRate = (byte) (this.inhesion[11] + DebuffRate);
            } else if (dm2.isBuffRate(12)) {
                DebuffRate = (byte) (this.inhesion[12] + DebuffRate);
            }
        }
        Ms.i();
        if (Ms.getRandom(100) >= DebuffRate) {
            return false;
        }
        dm2.effect = buff;
        if (buff == 3 || buff == 4 || buff == 5) {
            dm2.effect_time = (byte) 4;
        } else if (buff == 2) {
            dm2.effect_time = (byte) (am.isMonReel(32) ? 5 : 4);
        } else if (buff == 0) {
            dm2.effect_time = (byte) 2;
        } else if (buff == 6) {
            if (dm2.monster[3] == -1) {
                dm2.effect = (byte) 7;
                say(Constants_H.EFFECT_TXT_7, -1);
            } else {
                dm2.effect_time = (byte) 4;
            }
        }
        if (buff == 5) {
            dmB.fs_level = (byte) ((am.isMonReel(31) ? this.skill[31][0] : (byte) 1) + skill_no);
        }
        return true;
    }

    private void AddMP(int hp, Monster A_Monster) {
        int hp2 = hp + A_Monster.monsterPro[1];
        if (hp2 > A_Monster.monsterPro[3]) {
            A_Monster.monsterPro[1] = A_Monster.monsterPro[3];
        } else {
            A_Monster.monsterPro[1] = (short) hp2;
        }
    }

    private void AddHP(int hp, Monster A_Monster) {
        int hp2 = hp + A_Monster.monsterPro[0];
        if (hp2 >= A_Monster.monsterPro[2]) {
            A_Monster.monsterPro[0] = A_Monster.monsterPro[2];
        } else {
            A_Monster.monsterPro[0] = (short) hp2;
        }
    }

    private void drawEffectImage(Monster monster, int x, int y) {
        if (monster.effect > -1 && monster.effect < 7 && monster.effect_time > 0) {
            Ui i = Ui.i();
            Image image = this.effectImage[monster.effect];
            Graphics graphics = g;
            Graphics graphics2 = g;
            i.drawImage(image, x, y, 8 | 32);
            Ui i2 = Ui.i();
            String sb = new StringBuilder().append((int) monster.effect_time).toString();
            Graphics graphics3 = g;
            Graphics graphics4 = g;
            i2.drawNum(sb, x, y, 8 | 32, 0);
        }
    }

    private void effectR(Monster monster) {
        if (monster.effect_time > 0) {
            monster.effect_time = (byte) (monster.effect_time - 1);
        }
        if (monster.effect_time == 0) {
            monster.effect = (byte) 7;
        }
    }

    public byte getItemCount(int id) {
        if (this.buyItemID != 2) {
            findItemType(id);
            for (int i = 0; i < this.items[this.item_type].length; i++) {
                if (this.items[this.item_type][i][0] == id) {
                    return this.items[this.item_type][i][1];
                }
            }
        }
        return (byte) 0;
    }

    public void goBUY_ITEM(int id, int mode) {
        if (mode != 1) {
            setAction_str(new String[]{"道具", Constants_H.ITEM_TXT_5, "徽章"});
        } else {
            setAction_str(new String[]{"道具", Constants_H.ITEM_TXT_1, Constants_H.ITEM_TXT_2});
        }
        this.cur_a = (byte) id;
        this.cur_b = (byte) mode;
        byte[] bArr = this.select[0];
        this.select[0][0] = 0;
        bArr[1] = 0;
        run_state = 18;
        this.list_rows = (byte) 6;
        this.buyOk = (byte) 0;
        this.popMenu = (byte) -1;
        byte[] data = Ms.i().getStream("data/shop.d", -1);
        Ms.i();
        Ms.skip = 0;
        this.buyItem = Ms.i().create2Array(data);
        this.buyPrice = Ms.i().createShort2Array(data, 0);
    }

    private short getPrice(int type, int select, boolean bb) {
        if (bb) {
            short price = type == 2 ? this.buyPrice[1][select] : this.buyPrice[0][this.buyItem[this.cur_a][select]];
            if (this.view_state == -1) {
                return (short) ((price * 12) / 10);
            }
            return price;
        }
        return (short) (this.buyPrice[0][select] / 5);
    }

    private int getBuyItemCount(int type, int select, boolean bb) {
        if (bb) {
            int c0 = type == 2 ? this.coin / this.sell_money : this.money / this.sell_money;
            int c1 = 99 - findItem(-2, this.buyItem[this.cur_a][select], true);
            if (c1 < 0) {
                c1 = 0;
            }
            return c0 > c1 ? c1 : c0;
        }
        return this.items[this.cur_a][select][1];
    }

    private void drawBUY_ITEM() {
        Ui.i().fillRectB();
        Ui.i().drawK2(1, 2, Constants_H.WIDTH_ - 2, Constants_H.HEIGHT_ - 2, 0);
        byte i = 0;
        if (this.cur_b == 0) {
            Ui.i().drawK1(Constants_H.WIDTH_H_ - 29, 6, 58, 28, 4);
            Ui.i().drawString(this.action_str[this.cur_a], Constants_H.WIDTH_H_, 5, 17, 0, 0);
        } else {
            Ui.i().drawK1((this.cur_a * 210) + 70, 6, 70, 28, 4);
            while (i < 3) {
                Ui.i().drawString(this.action_str[i], (i * 210) + 80, 5, 0, this.cur_a == i ? 0 : 4, 0);
                i = (byte) (i + 1);
            }
            byte t = this.pkey.selectMenuX(3, 70, 0, 210, 62);
            if (t != -1) {
                this.cur_a = t;
                byte[] bArr = this.select[0];
                this.select[0][0] = 0;
                bArr[1] = 0;
            }
            Ui.i().drawTriangle(Constants_H.WIDTH_H_, 15, 329, true, true);
        }
        Ui.i().drawK1(6, 37, Constants_H.WIDTH_ - 26, (this.list_rows * 30) + 6, 1);
        Ui.i().drawK1(6, (this.list_rows * 30) + 37 + 16, Constants_H.WIDTH_ - 12, 30 * 3, 2);
        byte i2 = (byte) (this.cur_b == 1 ? this.itemsLength[this.cur_a] : this.buyItem[this.cur_a].length);
        drawItemList(10, 37 + 3, Constants_H.WIDTH_ - 26, this.list_rows, this.select[0], this.cur_a, i2, this.cur_b == 1 ? 2 : 1);
        Ui.i().sliding(Constants_H.WIDTH_ - 15, 37 + 5, (this.list_rows * 30) - 6, this.select[0][0], i2, true);
        if (i2 > 0) {
            i2 = this.cur_b == 1 ? this.items[this.cur_a][this.select[0][0]][0] : this.buyItem[this.cur_a][this.select[0][0]];
            if (this.item_help[i2].toString().contains("复活死亡的宠物并为其回复生命值的")) {
                showStringM("复活死亡的宠物并为其回复生命值的30%,请勿在宠物战斗中购买!", Constants_H.WIDTH_H_, (this.list_rows * 30) + 37 + 18, 10, 3);
            } else {
                showStringM(this.item_help[i2].toString(), Constants_H.WIDTH_H_, (this.list_rows * 30) + 37 + 18, 10, 3);
            }
        }
        drawMoney(Constants_H.WIDTH_H_, Constants_H.HEIGHT_ - 2, 0, this.cur_b != 1 && this.cur_a == 2);
        if (this.popMenu != -1) {
            if (this.buyOk == 1 && this.cur_b != 1 && this.buyItem[this.cur_a][this.select[0][0]] >= 35 && this.makeLevel[this.buyItem[this.cur_a][this.select[0][0]] - 35] > this.rmsOther[3]) {
                Ui.i().drawKuang(-5, Constants_H.HEIGHT_H_ - 50, Constants_H.WIDTH_ + 10, 108);
                showStringM(Constants_H.TXT_70 + ((int) this.makeLevel[this.buyItem[this.cur_a][this.select[0][0]] - 35]) + Constants_H.TXT_71, Constants_H.WIDTH_H_, Constants_H.HEIGHT_H_ - 25, 12, 9);
                showString("是否购买？", Constants_H.HEIGHT_H_ + 25, 0);
            } else {
                drawBuy(i2, Constants_H.WIDTH_H_, Constants_H.HEIGHT_H_, 150, 50, this.cur_b == 1 ? 1 : this.cur_a == 2 ? 16 : 17);
            }
            byte t2 = this.pkey.selectMenuX(2, 0, 0, Constants_H.WIDTH_H_, Constants_H.HEIGHT_);
            if (t2 != -1) {
                Ms.key = t2 == 0 ? -3 : -4;
                Ms.keyRepeat = true;
            }
        }
        Ui.i().drawYesNo(true, true);
    }

    private void drawBuy(int id, int x, int y, int w_h, int h_h, int d) {
        Ui.i().drawKuang(x - w_h, y - h_h, w_h << 1, h_h << 1);
        int t = (y - h_h) + ((d & 16) != 0 ? 2 : 12);
        Ui.i().drawString(Constants_H.MONEY_TXT_8 + ((int) this.popMenu) + "/" + ((int) this.t_length), x, t, 17, 3, 0);
        StringBuffer s = new StringBuffer();
        if ((d & 16) != 0) {
            s.append(Constants_H.MONEY_TXT_6);
        } else {
            s.append(Constants_H.MONEY_TXT_7);
        }
        s.append(this.sell_money * this.popMenu);
        if ((d & 1) != 0) {
            s.append(Constants_H.MONEY_TXT_0);
        } else {
            s.append("徽章");
        }
        Ui.i().drawString(s.toString(), x, t + 25 + 4, 17, 6, 0);
        if ((d & 16) != 0) {
            Ui.i().drawString(Constants_H.MONEY_TXT_17 + ((int) findItem(-2, id, true)), x, t + 58, 17, 3, 0);
        }
        Ui.i().drawTriangle1(x, y - 2, w_h, true, this.cur_b != 2);
        if (this.buyOk == 1) {
            showString(Constants_H.MONEY_TXT_14 + ((d & 16) != 0 ? Constants_H.MONEY_TXT_15 : Constants_H.MONEY_TXT_16) + "？", Constants_H.HEIGHT_H + 25, 0);
        }
    }

    private void keyBuyItem() {
        if (!Ms.i().key_delay()) {
            if (this.popMenu == -1) {
                if (Ms.i().key_Left_Right() && this.cur_b != 0) {
                    this.cur_a = Ms.i().select(this.cur_a, 0, 2);
                    byte[] bArr = this.select[0];
                    this.select[0][0] = 0;
                    bArr[1] = 0;
                    return;
                }
                if (Ms.i().key_Up_Down()) {
                    Ms.i().selectS(this.select[0], 0, this.cur_b == 1 ? this.itemsLength[this.cur_a] : this.buyItem[this.cur_a].length, this.list_rows);
                    return;
                }
                if (Ms.i().key_S1_Num5()) {
                    this.popMenu = (byte) 1;
                    this.sell_money = getPrice(this.cur_a, this.cur_b != 1 ? this.select[0][0] : this.items[this.cur_a][this.select[0][0]][0], this.cur_b != 1);
                    this.t_length = (byte) getBuyItemCount(this.cur_a, this.select[0][0], this.cur_b != 1);
                    return;
                } else {
                    if (Ms.i().key_S2()) {
                        this.buyItem = null;
                        this.buyPrice = null;
                        if (this.view_state == -1) {
                            goBattleState();
                            return;
                        } else {
                            goGO_RUNINMAP();
                            return;
                        }
                    }
                    return;
                }
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
                            byte[] bArr2 = this.select[0];
                            byte b = (byte) (bArr2[0] - 1);
                            bArr2[0] = b;
                            if (b < 0) {
                                this.select[0][0] = 0;
                            }
                            byte[] bArr3 = this.select[0];
                            byte b2 = (byte) (bArr3[1] - 1);
                            bArr3[1] = b2;
                            if (b2 < 0) {
                                this.select[0][1] = 0;
                            }
                        }
                        say(Constants_H.MONEY_TXT_9 + (this.sell_money * this.popMenu), 0);
                    } else {
                        if (isMoneyItem(this.cur_a, this.buyItem[this.cur_a][this.select[0][0]], this.popMenu, this.cur_a != 2) && addItem(this.buyItem[this.cur_a][this.select[0][0]], this.popMenu) != -1) {
                            say(Constants_H.MONEY_TXT_18, 0);
                        }
                    }
                    this.buyOk = (byte) 0;
                    this.popMenu = (byte) -1;
                    return;
                }
                this.buyOk = (byte) 1;
                return;
            }
            if (Ms.i().key_S2()) {
                if (this.buyOk != 0) {
                    this.buyOk = (byte) 0;
                } else {
                    this.popMenu = (byte) -1;
                }
            }
        }
    }

    public boolean isMoneyItem(int type, int item_id, int num, boolean bb) {
        if (findItem(-2, item_id, true) + num > 99) {
            say(Constants_H.MONEY_TXT_5, 0);
            return false;
        }
        if (bb) {
            if (this.money >= this.sell_money * num) {
                this.money -= this.sell_money * num;
                return true;
            }
            if (this.money < this.sell_money * num) {
                say(Constants_H.MONEY_TXT_2, -1, 0);
            } else {
                say(Constants_H.MONEY_TXT_4, 0, -1);
            }
        } else {
            if (this.coin >= this.sell_money * num) {
                this.coin -= this.sell_money * num;
                return true;
            }
            if (this.coin < this.sell_money * num) {
                say(Constants_H.MONEY_TXT_3, 0);
            } else {
                say(Constants_H.MONEY_TXT_4, 0);
            }
        }
        return false;
    }

    public boolean isMoney(int sell_money, boolean bb) {
        if (bb) {
            if (this.money >= sell_money) {
                this.money -= sell_money;
                return true;
            }
            say(Constants_H.MONEY_TXT_2, 0);
        } else {
            if (this.coin >= sell_money) {
                this.coin -= sell_money;
                return true;
            }
            say(Constants_H.MONEY_TXT_3, 0);
        }
        return false;
    }

    private void drawMY_BAG(int x, int y, int w, int h) {
        byte t;
        byte i = (byte) (this.action_str.length - 1);
        Ui.i().fillRectB();
        Ui.i().drawK2(x + 1, y + 3, w - 2, h - 3, 0);
        Ui.i().drawK1(x + 5, y + 25 + 14, w - 23, this.list_rows * 31, 1);
        Ui.i().drawK1(x + 5, y + 25 + 20 + (this.list_rows * 31), w - 10, 90, 2);
        if (i == 0) {
            Ui.i().drawK1((((w >> 1) + x) - 25) - 9, y + 8, 66, 28, 4);
            Ui.i().drawString(this.action_str[i], (w >> 1) + x, y + 7, 17, 0, 0);
            Log.e("sk", "drawMY_BAG");
        } else {
            Ui.i().drawK1(((((this.selectx + 1) * w) / 5) + x) - 22, y + 8, 70, 28, 4);
            while (i > -1) {
                Ui.i().drawString(this.action_str[i], ((((i + 1) * w) / 5) + x) - 14, y + 7, 0, this.selectx == i ? 0 : 1, 0);
                i = (byte) (i - 1);
            }
            Ui.i().drawTriangle((w >> 1) + x, y + 14, 354, true, true);
            if (this.popMenu == -1 && (t = this.pkey.selectMenuX(4, 0, 0, w / 4, 35)) != -1) {
                this.selectx = t;
                this.select[0][1] = this.select_st[this.selectx];
                this.select[0][0] = this.select_it[this.selectx];
            }
        }
        drawItemList(x + 9, y + 25 + 17, w - 23, this.list_rows, this.select[0], this.selectx, this.itemsLength[this.selectx], 0);
        Ui.i().sliding((x + w) - 15, y + 25 + 17, (this.list_rows * 31) - 6, this.select[0][0], this.itemsLength[this.selectx], true);
        if (this.itemsLength[this.selectx] > 0) {
            showStringM(this.item_help[this.items[this.selectx][this.select[0][0]][0]].toString(), x + (w >> 1), (this.list_rows * 31) + y + 25 + 22, 10, 3);
        }
        drawMoney((w >> 1) + x, (y + h) - 2, 0, this.selectx == 2);
        Ui.i().drawYesNo(this.itemsLength[this.selectx] != 0, true);
        if (this.popMenu != -1) {
            drawSelectMenu(this.about_a, (((w >> 1) + x) - 25) - 8, 50, 75, 2, 0, this.popMenu);
        }
    }

    public void drawMoney(int x, int y, int c, boolean bb) {
        String s = String.valueOf(bb ? this.coin : this.money) + (bb ? "徽章" : Constants_H.MONEY_TXT_0);
        Ui i = Ui.i();
        int i2 = bb ? 53 : 52;
        int stringWidth = (x - (Ms.i().getStringWidth(s) >> 1)) - 1;
        Graphics graphics = g;
        Graphics graphics2 = g;
        i.drawUi(i2, stringWidth, y, 8 | 32, 0);
        Graphics graphics3 = g;
        Graphics graphics4 = g;
        Ui.i().drawString(s, x, y + 3, 1 | 32, c, 1);
    }

    private void drawItemList(int x, int y, int w, int show_num, byte[] sel, int itemType, int length, int mode) {
        byte i = sel[1];
        Ui.i().drawListKY(show_num, x - 4, y, w, 4, 30 + 1, -1, sel[0] - sel[1], 4, 2);
        while (i < sel[1] + show_num) {
            if (i < length) {
                if (mode == 0 || mode == 2) {
                    drawItem(this.items[itemType][i][0], x + 3, y + 4 + ((i - sel[1]) * 30), 0);
                    Ui.i().drawString(getNameItem(this.items[itemType][i][0]), x + 21, y + 1 + ((i - sel[1]) * 30), 0, sel[0] == i ? 0 : 3, 0);
                    String str = mode == 2 ? ((int) getPrice(itemType, this.items[itemType][i][0], false)) + Constants_H.MONEY_TXT_0 : "x" + ((int) this.items[itemType][i][1]);
                    Ui i2 = Ui.i();
                    int i3 = (x + w) - 12;
                    int i4 = y + 1 + ((i - sel[1]) * 30);
                    Graphics graphics = g;
                    Graphics graphics2 = g;
                    i2.drawString(str, i3, i4, 8 | 16, sel[0] == i ? 0 : 3, 0);
                } else {
                    drawItem(this.buyItem[itemType][i], x + 2, y + 4 + ((i - sel[1]) * 30), 0);
                    byte color = (byte) (sel[0] == i ? 0 : 3);
                    Ui.i().drawString(getNameItem(this.buyItem[itemType][i]), x + 20, y + ((i - sel[1]) * 30), 0, color, 0);
                    String str2 = itemType == 2 ? "徽章" : Constants_H.MONEY_TXT_0;
                    int i5 = ((i - sel[1]) * 30) + y + 1;
                    Graphics graphics3 = g;
                    Graphics graphics4 = g;
                    Ui.i().drawString(String.valueOf((int) getPrice(itemType, i, true)) + str2, (x + w) - 12, i5, 8 | 16, color, 0);
                }
                if (this.popMenu == -1 && this.say_c == 0 && this.pkey.isSelect(x, ((i - sel[1]) * 30) + y, Constants_H.WIDTH, 30)) {
                    if (sel[0] == i) {
                        this.pkey.setKey5();
                    } else {
                        sel[0] = i;
                        if (i - sel[1] == 0 && sel[1] > 0) {
                            sel[1] = (byte) (sel[1] - 1);
                        } else if (i - sel[1] == show_num - 1 && sel[1] + show_num < length) {
                            sel[1] = (byte) (sel[1] + 1);
                        }
                        this.select_it[this.selectx] = sel[0];
                        this.select_st[this.selectx] = sel[1];
                    }
                }
            }
            i = (byte) (i + 1);
        }
    }

    public void initItemModules() {
        this.item_img = Ms.i().createImage("data/item");
        Ms.i();
        Ms.skip = 0;
        this.item_modules = Ms.i().create2Array(Ms.i().getStream("data/item_m.d", -1));
    }

    public void drawItem(int action, int x, int y, int anchor) {
        if (action >= 58) {
            action = this.monster_pro[this.nidusList[0][action - 58]][6] + 40;
        } else if (action >= 35) {
            action = this.makeLevel[action - 35] + 34;
        }
        Ui.i().drawRegion(this.item_img, this.item_modules[action][0], this.item_modules[action][1], this.item_modules[action][2], this.item_modules[action][3], x, y, anchor, 0, g);
    }

    private void popBagMenu(int selectx, int select_i) {
        String ts = Constants_H.POP_TXT_4;
        byte id = this.items[selectx][select_i][0];
        if ((selectx == 0 || id == 32 || id == 33) && isBagUse(id)) {
            ts = "使用#n返回";
        } else if (selectx == 2) {
            ts = "学习#n返回";
        } else if (this.view_state == 2 && selectx == 3) {
            ts = "孵化#n返回";
        }
        setStringB(ts, Constants_H.WIDTH, 0);
        this.popMenu = (byte) 0;
    }

    private boolean isBagUse(int id) {
        return this.view_state == -1 ? (id == 14 || id == 15) ? false : true : (id == 9 || id == 10 || id == 11 || id == 8) ? false : true;
    }

    private void popBagState() {
        if (Ms.i().key_Up_Down()) {
            this.popMenu = Ms.i().select(this.popMenu, 0, this.about_a.length - 1);
        }
        if (Ms.i().key_S1_Num5()) {
            byte id = this.items[this.selectx][this.select[0][0]][0];
            if (Ms.i().equals(this.about_a[this.popMenu], Constants_H.POP_TXT_5)) {
                switch (id) {
                    case 9:
                    case 10:
                    case 11:
                        if (this.battle_type == 4 || this.battle_type == 1) {
                            goCatchMonster();
                            break;
                        } else {
                            say(Constants_H.TXT_39, 1);
                            Ms.i().sleep(Player.STARTED);
                            break;
                        }
                    case Canvas.KEY_NUM7 /* 14 */:
                    case Canvas.KEY_NUM8 /* 15 */:
                        this.popMenu = (byte) -1;
                        if (this.map.notMeet == 0) {
                            this.map.notMeet(1, id);
                            say(Constants_H.POP_TXT_5 + getNameItem(id) + Constants.TEXT_PAY_SMS_CONFIRM_INDEXOF + Constants_H.TXT_61 + Constants_H.TXT_63, 1);
                            deleteItems(id, 1);
                            break;
                        } else if (this.map.notMeet == 1) {
                            say("已拥有躲避怪物效果", 0);
                            break;
                        }
                        break;
                    case 32:
                    case Constants_H.G_HCENTER_BOTTOM /* 33 */:
                        if (findItem(-2, id == 32 ? 33 : 32, true) > 0) {
                            deleteItems(32, 1);
                            deleteItems(33, 1);
                            byte type = 3;
                            byte d = 1;
                            byte rId = -1;
                            Ms.i();
                            byte rand = (byte) Ms.getRandom(100);
                            if (rand < 70) {
                                type = 0;
                            } else if (rand < 85) {
                                type = 1;
                            } else if (rand < 95) {
                                type = 2;
                            }
                            Ms.i();
                            byte rand2 = (byte) Ms.getRandom(100);
                            while (true) {
                                if (d < this.itemMine[type].length) {
                                    if (rand2 >= this.itemMine[type][d]) {
                                        d = (byte) (d + 2);
                                    } else {
                                        rId = this.itemMine[type][d - 1];
                                    }
                                }
                            }
                            if (rId == 34 && findItem(-2, rId, true) > 0) {
                                rId = -1;
                            } else if (rId == -1 || findItem(-2, rId, true) >= 99) {
                                rId = -1;
                            }
                            if (rId != -1) {
                                addItem(rId, 1);
                                say(Constants_H.MONEY_TXT_7 + getNameItem(rId) + "x1", 0);
                            } else {
                                say(Constants_H.MONEY_TXT_12, 0);
                            }
                        } else {
                            say(Constants_H.TXT_75 + (id == 32 ? Constants_H.TXT_76 : Constants_H.TXT_77), 0);
                        }
                        this.popMenu = (byte) -1;
                        break;
                    default:
                        goVIEW_MONSTER();
                        this.mini_state = (byte) 15;
                        break;
                }
            } else if (Ms.i().equals(this.about_a[this.popMenu], Constants_H.POP_TXT_6)) {
                this.mini_state = (byte) 13;
                this.getSkill = (byte) (id - 9);
                goVIEW_MONSTER();
            } else if (Ms.i().equals(this.about_a[this.popMenu], "孵化")) {
                if (addNidus(id - Constants_H.f27)) {
                    deleteItems(id, 1);
                    this.select_it[this.selectx] = this.select[0][0];
                    this.select_st[this.selectx] = this.select[0][1];
                } else {
                    say(Constants_H.TXT_99, 0);
                }
                this.popMenu = (byte) -1;
            } else {
                this.popMenu = (byte) -1;
            }
            Ms.i().correctSelect(this.select[0], this.itemsLength[this.selectx], this.list_rows);
            return;
        }
        if (Ms.i().key_S2()) {
            this.popMenu = (byte) -1;
        }
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
                        this.mini_state = (byte) 5;
                        this.selecty = this.select_T;
                        this.selecty = (byte) 0;
                        goVIEW_MONSTER();
                        return;
                    }
                    if (this.view_state == -1) {
                        this.mini_state = (byte) 1;
                        goBattleState();
                        initMonStream(2, this.mList_id[this.myMonsters[0].monster[0]][0], 1);
                        this.itemMine = null;
                        return;
                    }
                    if (this.view_state == 2) {
                        run_state = -10;
                        mc.paint();
                        goNidus(0);
                        return;
                    } else {
                        doPaint(0);
                        goYouPAUSE(2);
                        this.itemMine = null;
                        return;
                    }
                }
                if (Ms.i().key_Up_Down()) {
                    if (this.itemsLength[this.selectx] > 0) {
                        Ms.i().selectS(this.select[0], 0, this.itemsLength[this.selectx], this.list_rows);
                    }
                    this.select_it[this.selectx] = this.select[0][0];
                    this.select_st[this.selectx] = this.select[0][1];
                    return;
                }
                return;
            }
            popBagState();
        }
    }

    public void goVIEW_COMPUTER(int pop) {
        run_state = 65;
        setStringB("存放#n取出#n离开", Constants_H.WIDTH, 3);
        this.popMenu = (byte) pop;
    }

    private void drawVIEW_COMPUTER() {
        Ui.i().drawK2((Constants_H.WIDTH_H_ - (25 * 2)) - 8, (Constants_H.HEIGHT_H_ - (25 * 2)) - 8, (25 * 4) + 16, (25 * 6) + 16, 0);
        drawSelectMenu(this.about_d, (Constants_H.WIDTH_H_ - 25) - 4, Constants_H.HEIGHT_H_ - 25, (25 + 4) * 2, 2, 0, this.popMenu);
        Ui.i().drawString(Constants_H.ITEM_TXT_3, Constants_H.WIDTH_H_, (Constants_H.HEIGHT_H_ - (25 * 2)) - 6, 17, 1, 1);
        Ui.i().drawYesNo(true, true);
    }

    public void goNidus(int pop) {
        run_state = 66;
        this.mini_state = (byte) 16;
        setStringB("查看孵化#n选择蛋#n离开", Constants_H.WIDTH, 3);
        this.popMenu = (byte) pop;
        this.b_c = (byte) -2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x035d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawNidus(int r23, int r24) {
        /*
            Method dump skipped, instructions count: 978
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: main.GameRun.drawNidus(int, int):void");
    }

    private void keyNidus() {
        if (!Ms.i().key_delay()) {
            if (this.mini_state == 16) {
                if (Ms.i().key_Up_Down()) {
                    this.popMenu = Ms.i().select(this.popMenu, 0, this.about_d.length - 1);
                    return;
                }
                if (Ms.i().key_S1_Num5()) {
                    if (Ms.i().equals(this.about_d[this.popMenu], Constants_H.POP_TXT_17)) {
                        this.mini_state = (byte) 17;
                        this.popMenu = (byte) 0;
                        initMonStream(0, 56, 1);
                        if (getRid(this.popMenu) != -2) {
                            this.bg_c = this.monster_pro[getNid(this.popMenu)][6];
                            this.mon_action = (byte) (this.bg_c + 23);
                            return;
                        } else {
                            this.bg_c = this.popMenu;
                            return;
                        }
                    }
                    if (Ms.i().equals(this.about_d[this.popMenu], Constants_H.POP_TXT_16)) {
                        this.view_state = (byte) 2;
                        goMY_BAG(3);
                        return;
                    } else {
                        if (Ms.i().equals(this.about_d[this.popMenu], Constants_H.POP_TXT_14)) {
                            exitNidus();
                            return;
                        }
                        return;
                    }
                }
                if (Ms.i().key_S2()) {
                    exitNidus();
                    return;
                }
                return;
            }
            if (this.b_c == -2 && Ms.i().key_Left_Right()) {
                this.popMenu = Ms.i().select(this.popMenu, 0, 4);
                if (getRid(this.popMenu) != -2) {
                    this.bg_c = this.monster_pro[getNid(this.popMenu)][6];
                    this.mon_action = (byte) (this.bg_c + 23);
                    return;
                } else {
                    this.bg_c = this.popMenu;
                    return;
                }
            }
            if (Ms.i().key_S1_Num5()) {
                if (getRid(this.popMenu) != -2) {
                    if (this.b_c == -2 && getNexp(this.popMenu, 1) == getNexp(this.popMenu, 3)) {
                        if (this.cMon_count != this.max_monsters || this.myMon_length != this.max_takes) {
                            if (isEvolveMake(getNid(this.popMenu)) == 0) {
                                this.mon_action = (byte) (this.bg_c + 28);
                                this.b_c = (byte) 1;
                                setNidusPro(getNid(this.popMenu), 1);
                                delItemEvolve(getNid(this.popMenu));
                                return;
                            }
                            say(Constants_H.TXT_100, 0);
                            return;
                        }
                        say(Constants_H.TXT_48, 0);
                        return;
                    }
                    if (this.b_c == -1) {
                        this.b_c = (byte) -2;
                        getMonster(getNid(this.popMenu), getNLevel(this.popMenu), -2, -1);
                        delNidus(this.popMenu);
                        initMonStream(0, 56, 1);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.b_c != -2 || !Ms.i().key_S2()) {
                return;
            }
            exitNidus();
        }
    }

    public void exitNidus() {
        run_state = -10;
        this.mon[1] = null;
        initNidusMap(1);
    }

    private void setNidusPro(int i, int level) {
        StringBuffer sbuff = new StringBuffer();
        sbuff.append("生命：" + (this.monster_pro[i][0] + ((this.monster_pro[i][7] * level) / 10)) + "#n");
        sbuff.append("能量：" + (this.monster_pro[i][1] + ((this.monster_pro[i][8] * level) / 10)) + "#n");
        sbuff.append("进化：" + ((int) this.monster_pro[i][12]));
        setStringB(sbuff.toString(), Constants_H.WIDTH, 0);
        sbuff.delete(0, sbuff.length());
        sbuff.append("力量：" + (this.monster_pro[i][3] + ((this.monster_pro[i][10] * level) / 10)) + "#n");
        sbuff.append("防御：" + (this.monster_pro[i][4] + ((this.monster_pro[i][11] * level) / 10)) + "#n");
        sbuff.append("敏捷：" + (this.monster_pro[i][4] + ((this.monster_pro[i][11] * level) / 10)));
        setStringB(sbuff.toString(), Constants_H.WIDTH, 1);
    }

    public void initNidusMap(int mode) {
        if (this.nidusMap == null) {
            this.nidusMap = new byte[5];
        }
        byte i = 0;
        if (mode == 0) {
            while (i < this.nidusMap.length) {
                this.nidusMap[i] = -1;
                i = (byte) (i + 1);
            }
            return;
        }
        while (i < this.nidusMap.length) {
            if (this.nidusMap[i] != -1) {
                if (getRid(i) != -2) {
                    this.map.npc[0][this.nidusMap[i]].other[4] = 1;
                    this.map.npc[0][this.nidusMap[i]].other[7] = (byte) (this.monster_pro[getNid(i)][6] + 17);
                } else {
                    this.map.npc[0][this.nidusMap[i]].other[4] = 0;
                }
            }
            i = (byte) (i + 1);
        }
    }

    private void drawLIST_INFO() {
        Ui.i().fillRectB();
        drawInfoBG(24, 35);
        Ui i = Ui.i();
        String str = Constants_H.TXT_28 + Ms.i().getPrecision((this.monInfoList[102] * 1000) / 102) + "%";
        int i2 = Constants_H.WIDTH_ - 12;
        Graphics graphics = g;
        Graphics graphics2 = g;
        i.drawString(str, i2, 34, 8 | 16, 3, 1);
        Ui.i().drawString(this.monsterT[this.cur_a].toString(), 28, 34, 0, 1, 2);
        Ui i3 = Ui.i();
        String str2 = Constants_H.TXT_29 + ((int) this.monInfoList[103]) + "/100";
        int i4 = Constants_H.HEIGHT_ + 1;
        Graphics graphics3 = g;
        Graphics graphics4 = g;
        i3.drawString(str2, Constants_H.WIDTH_H_, i4, 1 | 32, 3, 1);
        byte t = this.pkey.selectMenuX(5, 100, 0, Constants_H.WIDTH_ / 6, 35);
        if (t != -1) {
            this.cur_a = t;
            this.infoStart = (byte) 0;
            if (this.cur_a > 0) {
                for (byte i5 = 0; i5 < this.cur_a; i5 = (byte) (i5 + 1)) {
                    this.infoStart = (byte) (this.infoStart + this.monInfo_dir[i5].length);
                }
            }
            this.t_length = (byte) this.monInfo_dir[this.cur_a].length;
            byte[] bArr = this.select[0];
            this.select[0][1] = 0;
            bArr[0] = 0;
        }
        byte i6 = 0;
        while (i6 < 5) {
            Ui i7 = Ui.i();
            byte b = this.cur_a == i6 ? (byte) 5 : (byte) 0;
            int i8 = Constants_H.WIDTH_ - 26;
            Graphics graphics5 = g;
            Graphics graphics6 = g;
            i7.drawUi(b + i6, (((i6 + 1) * 614) / 6) + 18, 12, 4 | 2, 0);
            i6 = (byte) (i6 + 1);
        }
        drawInfoList(32, 67, Constants_H.WIDTH_ - 50, 29, this.list_rows, this.t_length, this.select[0]);
        Ui.i().drawTriangle(Constants_H.WIDTH_H_ + 10, 12, 331, true, true);
        Ui.i().drawYesNo(this.monInfoList[getMonInfo_dir()] != 0, true);
    }

    private void drawInfoBG(int w, int fh) {
        Ui.i().fillRect(0, 0, 0, Constants_H.WIDTH_, fh);
        g.fillRect(0, Constants_H.HEIGHT_ - fh, Constants_H.WIDTH_, fh);
        g.fillRect(0, fh - 2, Constants_H.WIDTH_, fh);
        Ui.i().fillRect(15400191, 0, 2, Constants_H.WIDTH_, fh - 4);
        g.fillRect(0, (Constants_H.HEIGHT_ - fh) + 2, Constants_H.WIDTH_, fh - 4);
        g.fillRect(0, fh, Constants_H.WIDTH_, fh - 4);
    }

    private void drawInfoList(int x, int y, int w, int sh, int show_num, int listMax, byte[] sel) {
        int i;
        Ui.i().drawListKY(show_num, x - 4, y + 5, w, 4, sh + 4, 2, sel[0] - sel[1], 4, 2);
        for (byte i2 = sel[1]; i2 < sel[1] + show_num && i2 < listMax; i2 = (byte) (i2 + 1)) {
            Ui i3 = Ui.i();
            int i4 = this.monInfoList[this.monInfo_dir[this.cur_a][i2]] == 2 ? 25 : 48;
            int i5 = ((i2 - sel[1]) * (sh + 4 + 2)) + y + 11;
            Graphics graphics = g;
            Graphics graphics2 = g;
            i3.drawUi(i4, x - 10, i5, 8 | 16, 0);
            if (sel[0] == i2) {
                i = 0;
            } else {
                i = this.monInfoList[this.monInfo_dir[this.cur_a][i2]] != 0 ? 3 : -1;
            }
            byte color = (byte) i;
            Ui.i().drawString(String.valueOf((this.infoStart + i2) + 1 < 10 ? "0" : "") + (this.infoStart + i2 + 1) + " " + (this.monInfoList[this.monInfo_dir[this.cur_a][i2]] != 0 ? getNameMon(this.monInfo_dir[this.cur_a][i2]) : Constants_H.TXT_20), x + 10, ((i2 - sel[1]) * (sh + 4 + 2)) + y + 5, 0, color, 0);
            Ui i6 = Ui.i();
            String infoType = getInfoType(this.monAppearMap[this.monInfo_dir[this.cur_a][i2]][0]);
            int i7 = (Constants_H.WIDTH - 25) - 15;
            int i8 = ((i2 - sel[1]) * (sh + 4 + 2)) + y + 5;
            Graphics graphics3 = g;
            Graphics graphics4 = g;
            i6.drawString(infoType, i7, i8, 8 | 16, color, 0);
            if (this.pkey.isSelect(x, ((i2 - sel[1]) * (sh + 4 + 2)) + y + 5, w, sh + 4 + 2)) {
                if (sel[0] == i2) {
                    this.pkey.setKey5();
                } else {
                    sel[0] = i2;
                    if (i2 - sel[1] == 0 && sel[1] > 0) {
                        sel[1] = (byte) (sel[1] - 1);
                    } else if (i2 - sel[1] == show_num - 1 && sel[1] + show_num < listMax) {
                        sel[1] = (byte) (sel[1] + 1);
                    }
                }
            }
        }
        Ui.i().sliding(x + w + 5, y + 10, (((sh + 4) + 2) * show_num) - 4, sel[0], listMax, false);
    }

    private String getInfoType(int i) {
        return i == -1 ? Constants_H.TXT_86 : i == -2 ? "进化" : i == -3 ? Constants_H.TXT_88 : i == -4 ? Constants_H.TXT_89 : i == -5 ? "孵化" : "捕获";
    }

    private byte getSelInfo() {
        return this.select[0][0];
    }

    private byte getMonInfo_dir() {
        return this.monInfo_dir[this.cur_a][getSelInfo()];
    }

    public void keyLIST_INFO() {
        if (!Ms.i().key_delay()) {
            if (Ms.i().key_S1_Num5()) {
                if (this.monInfoList[getMonInfo_dir()] != 0) {
                    goMONSTER_INFO(getMonInfo_dir());
                    return;
                }
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
                this.infoStart = (byte) 0;
                if (this.cur_a > 0) {
                    for (byte i = 0; i < this.cur_a; i = (byte) (i + 1)) {
                        this.infoStart = (byte) (this.infoStart + this.monInfo_dir[i].length);
                    }
                }
                this.t_length = (byte) this.monInfo_dir[this.cur_a].length;
                byte[] bArr = this.select[0];
                this.select[0][1] = 0;
                bArr[0] = 0;
                return;
            }
            if (Ms.i().key_Up_Down()) {
                Ms.i().selectS(this.select[0], 0, this.t_length, this.list_rows);
            }
        }
    }

    private void goLIST_INFO(boolean bb) {
        run_state = 68;
        if (this.monInfo_dir == null) {
            byte[] data = Ms.i().getStream("data/book.d", -1);
            Ms.i();
            Ms.skip = 0;
            this.monInfo_dir = Ms.i().create2Array(data);
        }
        if (bb) {
            this.infoStart = (byte) 0;
            this.cur_a = (byte) 0;
            this.cur_b = (byte) 0;
            this.move_x = (short) 6;
            this.move_y = (short) 0;
            this.t_length = (byte) this.monInfo_dir[this.cur_a].length;
            this.select[0][0] = 0;
            this.select[0][1] = 0;
        }
        this.list_rows = (byte) 7;
    }

    private void goMONSTER_INFO(int id) {
        run_state = 67;
        initMonStream(2, this.mList_id[id][0], 1);
    }

    private void drawMONSTER_INFO(int id) {
        int offx = Constants_H.WIDTH_H_ - 140;
        int x = offx + 12;
        Ui.i().fillRectB();
        Ui.i().drawK2(offx, 2, 280, Constants_H.HEIGHT_ - 2, 0);
        Ui.i().drawK1((Constants_H.WIDTH_H_ - (29 * 4)) - 4, 6, 29 * 8, 29, 4);
        Ui.i().drawK1(x, 35, 100, 90, 1);
        Ui.i().drawK1(29 + 192 + 8, 35 + 90 + 4, 280 - (29 + 25), 29 * 4, 1);
        Ui.i().drawK1(x, 35 + 90 + 4, 29, 29 * 4, 3);
        Ui.i().drawK1(x, (Constants_H.HEIGHT_ - 13) - (29 * 3), (Constants_H.WIDTH_ - (x << 1)) + 2, (29 * 3) + 10, 2);
        Ui.i().drawYesNo(false, true);
        Ui.i().drawUi(this.cur_a + 5, x + 2, 35 + 2, 0, 0);
        Log.e("sk", "drawUi");
        Ui.i().drawString(String.valueOf(getNameMon(id)) + "（" + (this.monInfoList[id] == 2 ? Constants_H.TXT_26 : Constants_H.TXT_27) + "）", Constants_H.WIDTH_H_, 6, 17, 0, 0);
        int i = 100 >> 1;
        if (drawCartoonOne(1, 1, (this.mList_id[id][1] * 3) + this.mon_action, x + 50, (35 + 90) - 10, this.mon_action != 1, 0)) {
            this.mon_action = (byte) 0;
        }
        Ui.i().drawString(Constants_H.TXT_21, 100 + 192 + 5, 35, 0, 1, 1);
        if (this.monAppearMap[id][0] <= -1) {
            Ui.i().drawString(Constants_H.TXT_25, 100 + 192 + 5, 35 + 25, 0, 1, 0);
        } else {
            for (byte i2 = 0; i2 < this.monAppearMap[id].length; i2 = (byte) (i2 + 1)) {
                Ui.i().drawString(this.city_name[this.monAppearMap[id][i2]].toString(), 100 + 192 + 5, 35 + ((i2 + 1) * 25), 0, 1, 0);
            }
        }
        Ui.i().drawString(Constants_H.TXT_22, x + 12 + 2, 35 + 90 + 20, 17, 3, 1);
        int i3 = 35 + 90 + 28;
        Ui.i().drawString(Constants_H.TXT_23, x + 12 + 2, 29 + 153, 17, 3, 1);
        Ui.i().drawListKY(3, 29 + 192 + 8, 35 + 90 + 10, 280 - (29 + 25), 3, 29 + 4, 0, -1, 4, 2);
        byte i4 = 2;
        byte j = 0;
        while (i4 < 7) {
            int i5 = 35 + 90 + 12;
            int i6 = 29 + 4;
            Ui.i().drawString(Constants_H.TXT_24 + ((this.monsterMake[id].length == 0 || i4 >= this.monsterMake[id].length) ? "" : String.valueOf(getNameItem(this.monsterMake[id][i4])) + " x" + ((int) this.monsterMake[id][i4 + 1])), 29 + 192 + 14, (j * 33) + 137, 0, 3, 0);
            i4 = (byte) (i4 + 2);
            j = (byte) (j + 1);
        }
        showStringM(getNameMonsterInfo(id), Constants_H.WIDTH_H_, (Constants_H.HEIGHT_ - 12) - (29 * 3), 10, 3);
        byte b = (byte) (this.mon_action_c + 1);
        this.mon_action_c = b;
        if (b > 50) {
            this.mon_action_c = (byte) 0;
            this.mon_action = (byte) 1;
        }
    }

    private void drawMONSTER_UI(Monster[] monsters) {
        int offx = Constants_H.WIDTH_H_ - 140;
        Ui.i().fillRectB();
        Ui.i().drawK2(offx, 2, 280, Constants_H.HEIGHT_ - 2, 0);
        int lx = offx + 6;
        Ui.i().drawK1(lx, 5 + 6, 118, 116, 1);
        if (this.t_length != 0) {
            drawMonsterHp(monsters[this.select[0][0]], lx + 30, 5, 74, 2, 2, monsters[this.select[0][0]].monsterPro[4]);
            Ui.i().drawNum(String.valueOf((int) monsters[this.select[0][0]].monster[2]) + Constants_H.TXT_9, lx + 2, 5 + 10, 0, 0);
            Ui.i().drawUi(monsters[this.select[0][0]].monster[3] + 5, lx + 9, 5 + 11, 17, 0);
            if (drawCartoonOne(1, 1, (this.mList_id[monsters[this.select[0][0]].monster[0]][1] * 3) + this.mon_action, 248, 111, this.mon_action != 1, 0)) {
                this.mon_action = (byte) 0;
            }
        }
        int i = 116 + 22;
        int ly = 5 + 138;
        int lw = (short) (Constants_H.WIDTH_ - (lx << 1));
        Ui.i().drawK1(lx, ly, lw, (Constants_H.HEIGHT_ - 116) - 32, 1);
        Ui.i().drawK(lx + 8, ly + 10, lw - 16, 33, 3);
        Ui.i().drawK(lx + 8, ly + 150 + 11, lw - 16, 33, 3);
        if (this.t_length != 0) {
            gogoWord(getNameMonsterInfo(monsters[this.select[0][0]].monster[0]), lx + 9, ly + 150 + 13, lw - 70, 0, 1, 2);
            drawMonsterFealty(monsters[this.select[0][0]], lx + 2, ly - 14);
            Ui.i().drawString(this.monsterT[monsters[this.select[0][0]].monster[3]].toString(), lx + 25, ly + 12, 0, 0, 1);
            if (monsters[this.select[0][0]].monster[5] == 0) {
                Ui.i().drawString(Constants_H.TXT_84, lx + 115, ly + 12, 0, 0, 1);
            } else {
                Ui.i().drawString(Constants_H.TXT_15 + ((int) monsters[this.select[0][0]].monster[5]) + "次", lx + 115, ly + 12, 0, 0, 1);
            }
        }
        drawMonPro(monsters, lx, ly);
        int lx2 = ((280 + Constants_H.HEIGHT_H_) - 75) - 15;
        if (this.t_length != 0) {
            drawMonList(monsters, lx2 + 2, 0 + 13, this.list_rows, this.t_length, this.select[0]);
        }
        Ui.i().sliding((280 + Constants_H.HEIGHT_H_) - 17, 0 + 12, 116 + 6, this.select[0][0], this.t_length, true);
        Ui.i().drawNum(String.valueOf((int) this.t_length) + "/" + ((int) (this.mini_state == 6 ? this.max_monsters : this.max_takes)), (280 + Constants_H.HEIGHT_H_) - 40, 0 + 12, 0, 0);
        if (this.popMenu != -1) {
            drawSelectMenu(this.about_d, Constants_H.WIDTH_H_ - 25, 30, 75, 2, 0, this.popMenu);
            if (this.buyOk == 1) {
                showString(this.gogoString, Constants_H.HEIGHT_H_ - 25, 0);
            }
        }
        Ui.i().drawYesNo(this.t_length != 0, true);
    }

    private void drawMonPro(Monster[] monsters, int lx, int ly) {
        Ui.i().drawStringY(this.about_a, lx + 18, ly + 44, 0, 3, 31, 3, 0);
        Ui.i().drawStringY(this.about_b, lx + 160, ly + 44, 0, 3, 31, 3, 0);
        if (this.t_length != 0) {
            Ui.i().drawStringY(this.about_c, lx + 165 + 50, ly + 44, 0, 3, 31, -1, 0);
            drawMonsterHp(monsters[this.select[0][0]], lx + 19 + 50 + 4, ly + 59, 48, 0, 0, monsters[this.select[0][0]].monsterPro[0]);
            drawMonsterHp(monsters[this.select[0][0]], lx + 19 + 50 + 4, ly + 59 + 25 + 3, 48, 1, 0, monsters[this.select[0][0]].monsterPro[1]);
            drawMonKind(monsters[this.select[0][0]].monster[4], lx + 19 + 50 + 4, ly + 76 + 28, 0);
        }
    }

    private void drawMonList(Monster[] monster, int x, int y, int show_num, int max_length, byte[] select) {
        byte i = select[1];
        if (this.mini_state != 6) {
            Graphics graphics = g;
            Graphics graphics2 = g;
            Ui.i().drawUi(34, (x - 50) - 5, y + 2, 8 | 16, 0);
        }
        while (i < select[1] + show_num && i < max_length) {
            if (select[0] == i) {
                Ui.i().drawK(x - 50, ((i - select[1]) * 29) + y, 108, 26, 1);
            }
            Ui.i().drawString(getNameMon(monster[i].monster[0]).toString(), x + 4, (y - 2) + ((i - select[1]) * 29), 17, select[0] == i ? 0 : 1, 1);
            if (this.popMenu == -1 && this.pkey.isSelect(x - 50, ((i - select[1]) * 29) + y, 100, 26)) {
                if (select[0] == i) {
                    Ms.key = 53;
                    Ms.keyRepeat = true;
                } else {
                    select[0] = i;
                    if (i - select[1] == 0 && select[1] > 0) {
                        select[1] = (byte) (select[1] - 1);
                    } else if (i - select[1] == show_num - 1 && select[1] + show_num < max_length) {
                        select[1] = (byte) (select[1] + 1);
                    }
                    initMonStream(2, this.mList_id[monster[select[0]].monster[0]][0], 1);
                    setShowPro(monster[select[0]]);
                    this.introT = Constants_H.WIDTH_H;
                    this.introX = Constants_H.WIDTH_H;
                }
            }
            i = (byte) (i + 1);
        }
    }

    private void drawSkillList(int x, int y, int w, int fontH, int show_num, byte[] sel) {
        byte i = sel[1];
        Ui.i().drawListKY(show_num, x, y, w, 3, fontH, 0, sel[0] - sel[1], 4, 2);
        while (i < sel[1] + show_num && i < this.skill_list[8]) {
            Ui.i().drawUi(this.skill_list[i] > 25 ? 50 : 51, x + 8, y + 8 + ((i - sel[1]) * fontH), 0, 0);
            Log.e("sk", "普通攻击");
            Ui.i().drawString(getNameSkill(this.skill_list[i]).toString(), x + 21, y + 1 + ((i - sel[1]) * fontH), 0, sel[0] == i ? 0 : 3, 0);
            Ui i2 = Ui.i();
            String str = this.skill_list[i] <= 30 ? String.valueOf((int) this.skill[this.skill_list[i]][1]) + Constants_H.PRO_TXT_1 : Constants_H.PRO_TXT_7;
            int i3 = (x + w) - 8;
            int i4 = y + 1 + ((i - sel[1]) * fontH);
            Graphics graphics = g;
            Graphics graphics2 = g;
            i2.drawString(str, i3, i4, 8 | 16, sel[0] == i ? 0 : 3, 0);
            if (this.say_c < 1 && this.pkey.isSelect(x, ((i - sel[1]) * fontH) + y, w, fontH)) {
                if (sel[0] == i) {
                    this.pkey.setKey5();
                } else {
                    sel[0] = i;
                    if (i - sel[1] == 0 && sel[1] > 0) {
                        sel[1] = (byte) (sel[1] - 1);
                    } else if (i - sel[1] == show_num - 1 && sel[1] + show_num < this.skill_list[8]) {
                        sel[1] = (byte) (sel[1] + 1);
                    }
                }
            }
            i = (byte) (i + 1);
        }
    }

    private void drawBuffList(Monster monster, int x, int y, int w, int fontH, int show_num, byte[] sel) {
        byte i = 0;
        Ui.i().drawListKY(show_num, x, y, w, 3, fontH, 0, sel[0] - sel[1], 4, 2);
        while (i < 2) {
            if (i <= 0 || monster.monster[i + 16] >= 1) {
                Ui.i().drawUi(49, x + 8, y + 8 + ((i - this.select[0][1]) * fontH), 0, 0);
                Ui.i().drawString(getNameBuff(monster.monster[i + 16]), x + 21, y + 1 + ((i - this.select[0][1]) * fontH), 0, sel[0] == i ? 0 : 3, 0);
                if (this.pkey.isSelect(x, y + 1 + ((i - sel[1]) * fontH), w, fontH)) {
                    sel[0] = i;
                }
            }
            i = (byte) (i + 1);
        }
    }

    private void drawMagicUI(Monster monsters) {
        byte b;
        Ui.i().fillRect(5422575, 0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_);
        int i = Constants_H.WIDTH_H_ - 140;
        int lx = 1 + Constants_H.HEIGHT_H_;
        drawBG0(this.bg_c, lx, 108, 0, 267);
        byte t = this.pkey.selectMenuX(2, lx, 108, 120, 29);
        if (t != -1) {
            Ms.key = -3;
            Ms.keyRepeat = true;
        }
        Ui.i().drawK1(Constants_H.WIDTH_H_ + (this.popMenu == 0 ? -143 : 21), 108 + 3, 123, 27, 4);
        Ui i2 = Ui.i();
        int i3 = Constants_H.WIDTH_H_ - 25;
        int i4 = 108 + 1;
        Graphics graphics = g;
        Graphics graphics2 = g;
        i2.drawString(Constants_H.PAUSE_TXT_12, i3, i4, 8 | 16, this.popMenu == 0 ? 0 : 1, 0);
        Ui.i().drawString(Constants_H.PAUSE_TXT_13, Constants_H.WIDTH_H_ + 25, 108 + 1, 0, this.popMenu == 0 ? 1 : 0, 0);
        if (drawCartoonOne(1, 1, (this.mList_id[monsters.monster[0]][1] * 3) + this.mon_action, 377 - this.move_x, 97 - this.move_y, this.mon_action != 1, 0)) {
            this.mon_action = (byte) 0;
        }
        this.move_x = Ms.i().mathSpeedDown(this.move_x, 3, false);
        this.move_y = Ms.i().mathSpeedDown(this.move_y, 3, false);
        if (this.popMenu == 0) {
            drawSkillList(lx + 7, 108 + 25 + 12, 267 - 29, 31, 5, this.select[0]);
            if (this.skill_list[this.select[0][0]] != -1) {
                gogoWord(this.skill_help[this.skill_list[this.select[0][0]]].toString(), lx + 10, (Constants_H.HEIGHT_ - 25) - 22, Player.REALIZED, 0, 1, 2);
            }
        } else {
            drawBuffList(monsters, lx + 7, 108 + 25 + 12, 267 - 29, 31, 5, this.select[0]);
            if (monsters.monster[this.select[0][0] + 16] > 0) {
                showStringM(this.buff_help[monsters.monster[this.select[0][0] + 16]].toString(), Constants_H.WIDTH_H_, (Constants_H.HEIGHT_ - 50) - 22, 9, 0);
            }
        }
        Ui i5 = Ui.i();
        int i6 = (267 + Constants_H.HEIGHT_H_) - 13;
        int i7 = 108 + 25 + 13;
        int i8 = (Constants_H.HEIGHT_ - 108) - 120;
        byte b2 = this.select[0][0];
        if (this.popMenu == 0) {
            b = this.skill_list[8];
        } else {
            b = monsters.monster[this.select[0][0] + 16] > 0 ? (byte) 2 : (byte) 1;
        }
        i5.sliding(i6, i7, i8, b2, b, true);
        if (this.mini_state != 13) {
            Ui.i().drawTriangle(Constants_H.WIDTH_H_, 108 + 12, 150, true, true);
            Ui.i().drawYesNo(false, true);
        } else {
            Ui.i().drawYesNo(true, true);
        }
    }

    private void drawBG0(int id, int lx, int ly, int sh, int w) {
        Ui.i().fillRect(5422575, lx - 1, 0, w + 13, Constants_H.HEIGHT_ - 2);
        Ui.i().drawImage(this.imgBG[id], Constants_H.WIDTH_H_, 0, 17);
        Ui.i().drawK2(lx, ly, Constants_H.WIDTH_ - (lx << 1), Constants_H.HEIGHT_ - ly, 0);
        Ui.i().drawK1(lx + 5, ly + 25 + 7 + sh, w, ((Constants_H.HEIGHT_ - ly) - 36) - sh, 1);
        Ui.i().drawK(lx + 7, (Constants_H.HEIGHT_ - 50) - 22, w - 4, 58, 3);
    }

    private void keyMagicUI() {
        if (Ms.i().key_S1_Num5() && this.mini_state == 13) {
            if (this.skill_list[this.select[0][0]] > 25) {
                if (this.skill_list[this.select[0][0]] == this.myMonsters[this.selecty].monster[14]) {
                    this.myMonsters[this.selecty].monster[14] = this.getSkill;
                } else {
                    this.myMonsters[this.selecty].monster[15] = this.getSkill;
                }
                delItemSkill(this.myMonsters[this.selecty]);
                return;
            }
            say(Constants_H.TXT_46, 0);
            return;
        }
        if (Ms.i().key_S2()) {
            this.select[0][1] = this.selectx;
            this.select[0][0] = this.selecty;
            this.cur_c = (byte) 0;
            this.popMenu = (byte) -1;
            return;
        }
        if (Ms.i().key_Left_Right() && this.mini_state != 13) {
            this.popMenu = (byte) (this.popMenu ^ 1);
            byte[] bArr = this.select[0];
            this.select[0][0] = 0;
            bArr[1] = 0;
            return;
        }
        if (Ms.i().key_Up_Down()) {
            this.introX = Constants_H.WIDTH_H;
            if (this.popMenu == 0) {
                Ms.i().selectS(this.select[0], 0, this.skill_list[8], 5);
                return;
            }
            if (this.mini_state == 6) {
                if (this.cMonsters[this.selecty].monster[17] > 0) {
                    byte[] bArr2 = this.select[0];
                    bArr2[0] = (byte) (bArr2[0] ^ 1);
                    return;
                }
                return;
            }
            if (this.myMonsters[this.selecty].monster[17] > 0) {
                byte[] bArr3 = this.select[0];
                bArr3[0] = (byte) (bArr3[0] ^ 1);
            }
        }
    }

    public void drawEvolveUI(int mode, int id, boolean bb) {
        Ui.i().fillRectB();
        drawBG0(this.bg_c, Player.REALIZED, 108, 5, 230);
        if (mode == 1 && this.b_c > 0) {
            if (this.b_c == 1) {
                if (drawMagicC(5, 5, 5 == 5 ? 6 : 1, 377, 97, 0)) {
                    initMonStream(2, this.mList_id[this.myMonsters[id].monster[0]][0], 1);
                    this.b_c = (byte) 2;
                }
            }
            if (this.b_c > 1 && this.b_c < 14) {
                drawClipPic(this.mList_id[this.myMonsters[id].monster[0]][1], 1, 377, 97, 80, 77, 15, this.b_c - 2, 0);
                byte b = (byte) (this.b_c + 1);
                this.b_c = b;
                if (b == 14) {
                    this.b_c = (byte) -1;
                    say(Constants_H.TXT_19 + getNameMon(this.myMonsters[id].monster[0]), 0);
                }
            }
        } else {
            drawCartoonOne(1, 1, this.mList_id[this.myMonsters[id].monster[0]][1] * 3, 377 - this.move_x, 97 - this.move_y, true, 0);
        }
        if (mode != 1 || this.popMenu != 1) {
            Ui.i().drawStringY(this.about_b, (Player.REALIZED + 25) - 16, 108 + 25 + 22, 0, 3, 40, 3, 0);
            Ui.i().drawStringY(this.about_a, (Player.REALIZED + 125) - 3, 108 + 25 + 22, 0, 3, 40, 3, 0);
        } else {
            drawEvolveMake(this.myMonsters[id].monster[0], Player.REALIZED + 25, 108 + 25 + 22, 28);
        }
        if (mode == 0) {
            this.move_y = (short) 0;
            this.move_x = (short) 0;
            Graphics graphics = g;
            Graphics graphics2 = g;
            Ui.i().drawString(String.valueOf(getNameMon(this.myMonsters[id].monster[0])) + Constants_H.TXT_8 + ((int) this.myMonsters[id].monster[2]) + Constants_H.TXT_9, 432, 108 + 4, 8 | 16, 1, 0);
            Ui.i().drawImage(this.imgItem[1], Player.REALIZED - this.say_s, 108 - 4, 36);
            if (this.levelUp_in_battle[bb ? id : this.myMonsters[id].monster[1]][1] != -1) {
                Ui.i().drawString(Constants_H.TXT_10 + getNameSkill(this.levelUp_in_battle[bb ? id : this.myMonsters[id].monster[1]][1]), Constants_H.WIDTH_H_, Constants_H.HEIGHT_ - 60, 17, 9, 0);
            }
        } else if (mode == 1) {
            Ui.i().drawK1(Constants_H.WIDTH_H_ + (this.popMenu == 0 ? -127 : 15), 108 + 6, 113, 27, 4);
            Ui.i().drawString(Constants_H.PAUSE_TXT_14, (Constants_H.WIDTH_H_ - 75) + 4, 108 + 5, 17, this.popMenu == 0 ? 0 : 1, 0);
            Ui.i().drawString(Constants_H.PAUSE_TXT_15, (Constants_H.WIDTH_H_ + 75) - 4, 108 + 5, 17, this.popMenu == 0 ? 1 : 0, 0);
            byte t = this.pkey.selectMenuX(2, 0, 108 + 5, Constants_H.WIDTH_H_, 33);
            if (t != -1) {
                this.popMenu = t;
            }
            Ui.i().drawTriangle(Constants_H.WIDTH_H_, 108 + 15, 150, true, true);
            this.move_x = Ms.i().mathSpeedDown(this.move_x, 3, false);
            this.move_y = Ms.i().mathSpeedDown(this.move_y, 3, false);
            Ui.i().drawString(Constants_H.TXT_17, Constants_H.WIDTH_H_, (Constants_H.HEIGHT_ - 25) - 22, 17, 0, 1);
        }
        Ui.i().drawYesNo(true, true);
    }

    private void keyEvolveUI() {
        if (Ms.i().key_S1_Num5() && this.b_c == 0) {
            byte kind = this.myMonsters[this.selecty].monster[4];
            byte level = this.myMonsters[this.selecty].monster[2];
            byte id = this.myMonsters[this.selecty].monster[0];
            byte dd = isEvolveMake(id);
            if (isEvolveKind(kind, level) != -1) {
                dd = isEvolveKind(kind, level);
            }
            if (dd == 0) {
                this.myMonsters[this.selecty].evolveMonster(this, this.monsterMake[id][1], 1);
            } else if (dd > 0) {
                this.myMonsters[this.selecty].evolveMonster(this, this.monsterMake[id][0], this.myMonsters[this.selecty].monster[5]);
            } else if (dd == -1) {
                say(Constants_H.TXT_18, 0);
                this.popMenu = (byte) 1;
            } else if (dd == -2) {
                say(Constants_H.TXT_64, 0);
            } else if (dd == -3) {
                say(Constants_H.TXT_65, 0);
            } else {
                say(Constants_H.TXT_66, 0);
            }
            if (dd > -1) {
                this.b_c = (byte) 1;
                setMagic(6);
                setShowPro(this.myMonsters[this.selecty]);
                this.popMenu = (byte) 0;
                delItemEvolve(id);
                if (dd > 0) {
                    deleteItems(34, 1);
                    return;
                }
                return;
            }
            return;
        }
        if (Ms.i().key_S2()) {
            goView();
            setShowPro(this.myMonsters[this.selecty]);
        } else if (Ms.i().key_Left_Right() && this.b_c <= 0) {
            this.popMenu = (byte) (this.popMenu ^ 1);
        }
    }

    private void delItemEvolve(byte id) {
        byte i = 2;
        do {
            deleteItems(this.monsterMake[id][i], this.monsterMake[id][i + 1]);
            i = (byte) (i + 2);
        } while (i < this.monsterMake[id].length - 1);
    }

    private byte isEvolveKind(byte kind, byte level) {
        if (kind == 1 && level < 15) {
            return (byte) -2;
        }
        if (kind != 2 || level >= 25) {
            return (kind != 3 || level >= 30) ? (byte) -1 : (byte) -4;
        }
        return (byte) -3;
    }

    private void goView() {
        this.select[0][1] = this.selectx;
        this.select[0][0] = this.selecty;
        this.cur_c = (byte) 0;
        this.popMenu = (byte) -1;
        setStringB("生命#n能量#n档次", Constants_H.WIDTH, 0);
        setStringB("力量#n防御#n敏捷", Constants_H.WIDTH, 1);
    }

    private void drawEvolveMake(int id, int x, int y, int fontH) {
        byte i;
        byte i2 = 2;
        byte j = 0;
        do {
            Ui.i().drawString(String.valueOf(getNameItem(this.monsterMake[id][i2])) + "（" + ((int) findItem(-2, this.monsterMake[id][i2], true)) + "/" + ((int) this.monsterMake[id][i2 + 1]) + "）", x, y + (j * fontH), 0, 3, 0);
            i2 = (byte) (i2 + 2);
            j = (byte) (j + 1);
        } while (i2 < this.monsterMake[id].length - 1);
        if (this.monsterMake[id][0] <= 0 || (i = findItem(-2, 34, true)) <= 0) {
            return;
        }
        Ui.i().drawString(String.valueOf(getNameItem(34)) + "（" + ((int) i) + "/1）", x, y + (j * fontH), 0, -1, 0);
    }

    private byte isEvolveMake(int id) {
        byte i = 2;
        byte evolve = this.monsterMake[id][0];
        while (findItem(-2, this.monsterMake[id][i], true) >= this.monsterMake[id][i + 1]) {
            i = (byte) (i + 2);
            if (i >= this.monsterMake[id].length - 1) {
                if (evolve > 0 && findItem(-2, 34, true) < 1) {
                    evolve = 0;
                }
                return evolve;
            }
        }
        return (byte) -1;
    }

    private void key_MONSTER_LIST(Monster[] mon) {
        if (this.popMenu == -1) {
            if (Ms.i().key_S1_Num5() && this.t_length != 0) {
                if (this.view_state == 1) {
                    if (this.mini_state == 15) {
                        useItem();
                        return;
                    }
                    if (this.mini_state != 13) {
                        StringBuffer sbuff = new StringBuffer("天赋#n技能");
                        if (this.mini_state == 4) {
                            if (mon[this.select[0][0]].monster[5] > 0) {
                                sbuff.append("#n进化");
                            }
                            if (this.t_length > 1) {
                                sbuff.append("#n存放#n卖宠");
                            }
                        } else if (this.mini_state == 6) {
                            if (this.map.gmErr) {
                                sbuff.append("#n卖宠");
                            } else {
                                sbuff.append("#n取出#n卖宠");
                            }
                        } else {
                            if (this.select[0][0] != 0) {
                                sbuff.append("#n参战");
                            }
                            if (mon[this.select[0][0]].monster[5] > 0) {
                                sbuff.append("#n进化");
                            }
                            if (this.t_length > 1) {
                                sbuff.append("#n放生");
                            }
                        }
                        setStringB(sbuff.toString(), Constants_H.WIDTH, 3);
                        this.popMenu = (byte) 0;
                        return;
                    }
                    keyGetSkill(mon[this.select[0][0]]);
                    return;
                }
                if (this.view_state < 0) {
                    if (this.mini_state != 15) {
                        if (this.select[0][0] != 0) {
                            setStringB("参战#n技能", Constants_H.WIDTH, 3);
                        } else {
                            setStringB(Constants_H.POP_TXT_0, Constants_H.WIDTH, 3);
                        }
                        this.popMenu = (byte) 0;
                        return;
                    }
                    useItem();
                    return;
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
                        this.mini_state = (byte) 3;
                        return;
                    } else {
                        if (this.mini_state == 6 || this.mini_state == 4) {
                            if (!this.map.gmErr) {
                                doPaint(0);
                                goVIEW_COMPUTER(this.mini_state == 6 ? 1 : 0);
                                return;
                            } else {
                                this.map.bkEvent_getMon();
                                return;
                            }
                        }
                        doPaint(0);
                        goYouPAUSE(1);
                        return;
                    }
                }
                if (this.view_state == -2) {
                    if (mon[0].monsterPro[0] > 0) {
                        if (this.select[0][0] != 0) {
                            initMonStream(2, this.mList_id[mon[0].monster[0]][0], 1);
                        }
                        goBattleState();
                    } else {
                        say(Constants_H.TXT_5, 0);
                    }
                    this.view_state = (byte) -1;
                    return;
                }
                if (this.view_state == -1) {
                    if (this.mini_state == 15) {
                        goMY_BAG(0);
                        return;
                    } else {
                        say(Constants_H.TXT_5, 0);
                        return;
                    }
                }
                return;
            }
            if (Ms.i().key_Up_Down() && this.t_length != 0) {
                Ms.i().selectS(this.select[0], 0, this.t_length, this.list_rows);
                initMonStream(2, this.mList_id[mon[this.select[0][0]].monster[0]][0], 1);
                setShowPro(mon[this.select[0][0]]);
                this.introT = Constants_H.WIDTH_H;
                return;
            }
            return;
        }
        popState();
    }

    private void keyGetSkill(Monster mon) {
        if (this.getSkill + 9 >= 35 && this.makeLevel[(this.getSkill + 9) - 35] > this.rmsOther[3]) {
            say(Constants_H.TXT_70 + ((int) this.makeLevel[(this.getSkill + 9) - 35]) + Constants_H.TXT_71, 0);
            return;
        }
        if (mon.isMonReel(this.getSkill)) {
            say(String.valueOf(getNameMon(mon.monster[0])) + Constants_H.TXT_45, 0);
            return;
        }
        if (mon.monster[14] != -1 && mon.monster[15] != -1) {
            initSkillList(mon);
            this.bg_c = mon.monster[3];
            restMove(1, 0);
            say("请选择要替换的技能！", 0);
            return;
        }
        if (mon.monster[14] == -1) {
            mon.monster[14] = this.getSkill;
        } else {
            mon.monster[15] = this.getSkill;
        }
        delItemSkill(mon);
    }

    private void delItemSkill(Monster mon) {
        say(String.valueOf(getNameMon(mon.monster[0])) + Constants_H.TXT_10 + getNameSkill(this.getSkill), 0);
        goMY_BAG(2);
        deleteItems(((this.getSkill + 35) - 25) - 1, 1);
        Ms.i().correctSelect(this.select[0], this.itemsLength[this.selectx], this.list_rows);
    }

    private void sellMonster(Monster mon) {
        this.sell_money = (mon.monster[2] * mon.monster[4] * 5) + 100;
    }

    private void putMonster() {
        if (this.cMon_count >= this.max_monsters) {
            say(Constants_H.TXT_48, 0);
        } else {
            if (!isMyMonsters(this.select[0][0])) {
                say(Constants_H.TXT_13, 0);
                return;
            }
            this.cMonsters[this.cMon_count] = this.myMonsters[this.select[0][0]];
            this.cMon_count = (byte) (this.cMon_count + 1);
            setPutMonster();
        }
    }

    private void setPutMonster() {
        for (byte i = this.select[0][0]; i < this.myMon_length - 1; i = (byte) (i + 1)) {
            this.myMonsters[i] = this.myMonsters[i + 1];
            this.evolve[i] = this.evolve[i + 1];
        }
        for (byte i2 = this.myMon_length; i2 < this.myMonsters.length; i2 = (byte) (i2 + 1)) {
            this.evolve[i2] = true;
        }
        this.myMon_length = (byte) (this.myMon_length - 1);
        if (this.select[0][0] == this.myMon_length) {
            byte[] bArr = this.select[0];
            bArr[0] = (byte) (bArr[0] - 1);
        }
        initMonStream(2, this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0], 1);
        setShowPro(this.myMonsters[this.select[0][0]]);
        this.introT = Constants_H.WIDTH_H;
        this.t_length = this.myMon_length;
        this.popMenu = (byte) -1;
        Ms.i().correctSelect(this.select[0], this.t_length, this.list_rows);
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

    private void takenMonster() {
        if (this.myMon_length < this.max_takes) {
            this.myMonsters[this.myMon_length] = this.cMonsters[this.select[0][0]];
            this.evolve[this.myMon_length] = true;
            this.myMon_length = (byte) (this.myMon_length + 1);
            setTakenMonster();
            return;
        }
        say(Constants_H.TXT_43, 1);
    }

    private void setTakenMonster() {
        for (byte i = this.select[0][0]; i < this.cMon_count - 1; i = (byte) (i + 1)) {
            this.cMonsters[i] = this.cMonsters[i + 1];
        }
        this.cMon_count = (byte) (this.cMon_count - 1);
        this.t_length = this.cMon_count;
        if (this.select[0][0] == this.cMon_count) {
            byte[] bArr = this.select[0];
            bArr[0] = (byte) (bArr[0] - 1);
        }
        if (this.t_length > 0) {
            initMonStream(2, this.mList_id[this.cMonsters[this.select[0][0]].monster[0]][0], 1);
            setShowPro(this.cMonsters[this.select[0][0]]);
        }
        this.introT = Constants_H.WIDTH_H;
        this.popMenu = (byte) -1;
        Ms.i().correctSelect(this.select[0], this.t_length, this.list_rows);
    }

    public void goVIEW_MONSTER() {
        run_state = 35;
        this.cur_c = (byte) 0;
        this.selecty = (byte) 0;
        this.selectx = (byte) 0;
        this.t_length = this.mini_state == 6 ? this.cMon_count : this.myMon_length;
        byte[] bArr = this.select[0];
        this.select[0][1] = 0;
        bArr[0] = 0;
        this.popMenu = (byte) -1;
        this.list_rows = (byte) 5;
        this.mon_action = (byte) 0;
        setStringB("生命#n能量#n档次", Constants_H.WIDTH, 0);
        setStringB("力量#n防御#n敏捷", Constants_H.WIDTH, 1);
        this.cur_mon = this.mini_state == 6 ? this.cMonsters[this.select[0][0]] : this.myMonsters[this.select[0][0]];
        if (this.t_length != 0) {
            setShowPro(this.cur_mon);
            initMonStream(2, this.mList_id[this.cur_mon.monster[0]][0], 1);
        }
    }

    private void setShowPro(Monster monster) {
        StringBuffer sbuff = new StringBuffer();
        sbuff.append(String.valueOf((int) monster.monsterPro[6]) + "#n");
        sbuff.append(String.valueOf((int) monster.monsterPro[7]) + "#n");
        sbuff.append((int) monster.monsterPro[5]);
        setStringB(sbuff.toString(), Constants_H.WIDTH, 2);
    }

    private void goGO_RUNINMAP() {
        this.b_c = (byte) 0;
        this.popMenu = (byte) -1;
        System.gc();
        run_state = -11;
    }

    private void goMY_BAG(int type) {
        this.mini_state = (byte) 15;
        this.list_rows = (byte) 6;
        run_state = 25;
        this.popMenu = (byte) -1;
        if (this.view_state == 1) {
            setAction_str(new String[]{"道具", Constants_H.ITEM_TXT_1, Constants_H.ITEM_TXT_2, "孵化"});
        } else if (this.view_state == -1) {
            setAction_str(new String[]{"道具"});
        } else if (this.view_state == 2) {
            setAction_str(new String[]{"孵化"});
        }
        this.selectx = (byte) type;
        this.selecty = (byte) 0;
        this.select[0][1] = this.select_st[this.selectx];
        this.select[0][0] = this.select_it[this.selectx];
        Ms.i().correctSelect(this.select[0], this.itemsLength[this.selectx], this.list_rows);
        this.itemMine = null;
        Ms.i();
        Ms.skip = 0;
        this.itemMine = Ms.i().create2Array(Ms.i().getStream("data/box.d", -1));
    }

    public void popState() {
        if (this.buyOk == 0 && Ms.i().key_Up_Down()) {
            this.popMenu = Ms.i().select(this.popMenu, 0, this.about_d.length - 1);
            return;
        }
        if (Ms.i().key_S1_Num5()) {
            if (Ms.i().equals(this.about_d[this.popMenu], Constants_H.POP_TXT_0) || Ms.i().equals(this.about_d[this.popMenu], Constants_H.POP_TXT_15)) {
                initSkillList(this.mini_state == 6 ? this.cMonsters[this.select[0][0]] : this.myMonsters[this.select[0][0]]);
                if (this.view_state > 0) {
                    this.bg_c = this.mini_state == 6 ? this.cMonsters[this.select[0][0]].monster[3] : this.myMonsters[this.select[0][0]].monster[3];
                } else if (this.view_state < 0 && this.myB != null) {
                    this.bg_c = this.myB.bg_id;
                }
                restMove(1, Ms.i().equals(this.about_d[this.popMenu], Constants_H.POP_TXT_0) ? 0 : 1);
                return;
            }
            if (Ms.i().equals(this.about_d[this.popMenu], Constants_H.POP_TXT_1)) {
                if (this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
                    if (this.view_state < 0) {
                        for (byte i = 1; i <= this.mon_in_battle[0] && this.mon_in_battle[i] != this.myMonsters[this.select[0][0]].monster[1]; i = (byte) (i + 1)) {
                            if (i == this.mon_in_battle[0]) {
                                byte[] bArr = this.mon_in_battle;
                                byte[] bArr2 = this.mon_in_battle;
                                byte b = (byte) (bArr2[0] + 1);
                                bArr2[0] = b;
                                bArr[b] = this.myMonsters[this.select[0][0]].monster[1];
                            }
                        }
                        initSkillList(this.myMonsters[this.select[0][0]]);
                    }
                    changeMonster(this.myMonsters[this.select[0][0]], this.myMonsters[0]);
                    initMonStream(2, this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0], 1);
                    setShowPro(this.myMonsters[this.select[0][0]]);
                    if (this.view_state < 0) {
                        setMyThrow();
                        run_state = -50;
                        this.battle_state = (byte) 0;
                        if (this.view_state == -1) {
                            this.myB.act_num = (byte) 1;
                            this.enB.act_num = (byte) 1;
                        }
                        this.myB.dead = (byte) 0;
                        this.first_battle = (byte) 0;
                    }
                    this.lastSkill = (byte) 0;
                } else {
                    say(Constants_H.TXT_5, 0);
                }
                this.popMenu = (byte) -1;
                return;
            }
            if (Ms.i().equals(this.about_d[this.popMenu], "进化")) {
                setEvolveStringB(this.myMonsters[this.select[0][0]]);
                this.bg_c = this.myMonsters[this.select[0][0]].monster[3];
                this.b_c = (byte) 0;
                restMove(2, 0);
                return;
            }
            if (Ms.i().equals(this.about_d[this.popMenu], Constants_H.POP_TXT_3)) {
                if (!isMyMonsters(this.select[0][0])) {
                    say(Constants_H.TXT_13, 0);
                    return;
                }
                if (this.buyOk == 1) {
                    this.buyOk = (byte) 0;
                    delMonster(this.select[0][0]);
                    if (this.select[0][0] == this.myMon_length) {
                        byte[] bArr3 = this.select[0];
                        bArr3[0] = (byte) (bArr3[0] - 1);
                    }
                    initMonStream(2, this.mList_id[this.myMonsters[this.select[0][0]].monster[0]][0], 1);
                    setShowPro(this.myMonsters[this.select[0][0]]);
                    this.introT = Constants_H.WIDTH_H;
                    this.t_length = this.myMon_length;
                    this.popMenu = (byte) -1;
                    return;
                }
                this.buyOk = (byte) 1;
                this.gogoString = Constants_H.TXT_47;
                return;
            }
            if (Ms.i().equals(this.about_d[this.popMenu], Constants_H.POP_TXT_7)) {
                if (run_state == 35) {
                    putMonster();
                    return;
                }
                this.mini_state = (byte) 4;
                this.view_state = (byte) 1;
                goVIEW_MONSTER();
                return;
            }
            if (Ms.i().equals(this.about_d[this.popMenu], Constants_H.POP_TXT_8)) {
                if (run_state == 35) {
                    takenMonster();
                    return;
                }
                this.mini_state = (byte) 6;
                this.view_state = (byte) 1;
                goVIEW_MONSTER();
                return;
            }
            if (Ms.i().equals(this.about_d[this.popMenu], Constants_H.POP_TXT_9)) {
                if (this.buyOk == 1) {
                    this.buyOk = (byte) 0;
                    this.money += this.sell_money;
                    say(Constants_H.MONEY_TXT_9 + this.sell_money, 0);
                    if (this.mini_state == 6) {
                        setTakenMonster();
                        return;
                    } else {
                        setPutMonster();
                        return;
                    }
                }
                if (this.mini_state == 4 && !isMyMonsters(this.select[0][0])) {
                    say(Constants_H.TXT_13, 0);
                    return;
                }
                this.buyOk = (byte) 1;
                sellMonster(this.mini_state == 4 ? this.myMonsters[this.select[0][0]] : this.cMonsters[this.select[0][0]]);
                this.gogoString = Constants_H.MONEY_TXT_9 + this.sell_money + Constants_H.MONEY_TXT_10;
                return;
            }
            if (Ms.i().equals(this.about_d[this.popMenu], Constants_H.POP_TXT_14)) {
                goRUN_IN_MAP(false);
                return;
            }
            return;
        }
        if (Ms.i().key_S2()) {
            if (this.buyOk == 0) {
                if (run_state == 65) {
                    goRUN_IN_MAP(false);
                    return;
                } else {
                    this.popMenu = (byte) -1;
                    return;
                }
            }
            this.buyOk = (byte) 0;
        }
    }

    private void restMove(int type, int i) {
        this.selectx = this.select[0][1];
        this.selecty = this.select[0][0];
        this.cur_c = (byte) type;
        byte[] bArr = this.select[0];
        this.select[0][0] = 0;
        bArr[1] = 0;
        this.popMenu = (byte) i;
        this.move_x = (short) 129;
        this.move_y = (short) -14;
    }

    private void setEvolveStringB(Monster monster) {
        byte eid = (byte) (monster.monster[0] + 1);
        byte level = monster.monster[2];
        boolean b_e = false;
        if (this.monsterMake[monster.monster[0]][0] > 0 && findItem(-2, 34, true) > 0) {
            eid = this.monsterMake[monster.monster[0]][0];
            b_e = true;
        }
        this.proReplace = null;
        this.proReplace = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 1, 6);
        this.proReplace[0][0] = (short) (getbuffRateV(monster, this.monster_pro[eid][0] + ((this.monster_pro[eid][7] * level) / 10)) - monster.monsterPro[2]);
        this.proReplace[0][1] = (short) ((this.monster_pro[eid][1] + ((this.monster_pro[eid][8] * level) / 10)) - monster.monsterPro[3]);
        this.proReplace[0][2] = (short) (-(b_e ? monster.monster[5] : (byte) 1));
        this.proReplace[0][3] = (byte) ((this.monster_pro[eid][3] + ((this.monster_pro[eid][10] * level) / 10)) - monster.monsterPro[6]);
        this.proReplace[0][4] = (byte) ((this.monster_pro[eid][4] + ((this.monster_pro[eid][11] * level) / 10)) - monster.monsterPro[7]);
        this.proReplace[0][5] = (byte) ((this.monster_pro[eid][2] + ((this.monster_pro[eid][9] * level) / 10)) - monster.monsterPro[5]);
        setStringB("生命：+" + ((int) this.proReplace[0][0]) + "#n" + Constants_H.PRO_TXT_1 + "：+" + ((int) this.proReplace[0][1]) + "#n进化：" + ((int) this.proReplace[0][2]), Constants_H.WIDTH, 0);
        setStringB("力量：+" + ((int) this.proReplace[0][3]) + "#n" + Constants_H.PRO_TXT_4 + "：+" + ((int) this.proReplace[0][4]) + "#n" + Constants_H.PRO_TXT_5 + "：+" + ((int) this.proReplace[0][5]), Constants_H.WIDTH, 1);
        this.proReplace = null;
    }

    private void drawMonsterFealty(Monster monster, int x, int y) {
        byte kind = monster.monster[4];
        byte nn = (byte) (this.initFealty[kind < 4 ? (char) 0 : (char) 1] / 20);
        byte n = (byte) (monster.monster[6] / 20);
        drawFealty(nn, n, x, y);
    }

    public void drawFealty(int length, int n, int x, int y) {
        byte i = 0;
        while (i < length) {
            Ui.i().drawUi(i > n ? 22 : 21, (i * 14) + x, y, 0, 0);
            i = (byte) (i + 1);
        }
    }

    private void drawMonKind(byte monKind, int x, int y, int arh) {
        byte i = 0;
        while (i < 5) {
            Ui.i().drawUi(monKind > i ? 23 : 24, (i * 14) + x, y, arh, 0);
            i = (byte) (i + 1);
        }
    }

    public void keyGameOver1(boolean over) {
        if (Ms.i().key_S1_Num5()) {
            if (this.popMenu == 1) {
                goMAIN_MENU();
            } else if (this.popMenu == 0) {
                System.out.println("loadGame soars");
                loadGame();
            }
            this.popMenu = (byte) -1;
        } else if (Ms.i().key_Up_Down()) {
            this.popMenu = (byte) (this.popMenu ^ 1);
        }
        Ms.i().keyRelease();
    }

    public void key_gameRun() {
        if (run_state == 98) {
            if (Ms.i().key_Num0() || Ms.i().key_S1_Num5()) {
                mc.doShowNotify();
            }
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
                this.say_c = (byte) 0;
                doSayOverSms();
            }
            Ms.i().keyRelease();
            return;
        }
        switch (run_state) {
            case -31:
                keyBattleState();
                break;
            case -21:
                SMSSender.i(this).keyLevel();
                Sound.i().soundStop();
                break;
            case -20:
                SMSSender.i(this).key();
                break;
            case -15:
                if (!Ms.i().key_delay()) {
                    if (this.b_c == 1 && this.say_s == 0) {
                        this.b_c = (byte) 0;
                        break;
                    }
                } else {
                    return;
                }
                break;
            case -10:
                this.map.key_map();
                break;
            case 18:
                keyBuyItem();
                break;
            case 25:
                keyMY_BAG();
                break;
            case 35:
                if (!Ms.i().key_delay()) {
                    if (this.cur_c != 0) {
                        if (this.cur_c != 1) {
                            if (this.cur_c == 2) {
                                keyEvolveUI();
                                break;
                            }
                        } else {
                            keyMagicUI();
                            break;
                        }
                    } else {
                        key_MONSTER_LIST(this.mini_state == 6 ? this.cMonsters : this.myMonsters);
                        break;
                    }
                } else {
                    return;
                }
                break;
            case 51:
                if (Ms.i().key_Num0()) {
                    this.map.my.state = (byte) 0;
                    this.map.eventGoing = (byte) 2;
                    Ms.i().keyRelease();
                    this.map.dialog_no = (byte) -1;
                    goGO_RUNINMAP();
                    break;
                }
                break;
            case Constants.JIFENGQUAN_G_RATIO /* 60 */:
                Ms.i().keyRelease();
                run_state = 61;
                setAction_str(new String[]{Constants_H.POP_TXT_12, Constants_H.POP_TXT_13});
                this.popMenu = (byte) 0;
                break;
            case 61:
                keyGameOver1(true);
                break;
            case 65:
                if (!Ms.i().key_delay()) {
                    popState();
                    break;
                } else {
                    return;
                }
            case 66:
                keyNidus();
                break;
            case 67:
                if (Ms.i().key_S2()) {
                    goLIST_INFO(false);
                    Ms.i().keyRelease();
                    break;
                }
                break;
            case 68:
                keyLIST_INFO();
                break;
            case 69:
                Mg.i().key(this);
                break;
            case 97:
                if (!Ms.i().key_delay()) {
                    if (Ms.i().key_S1_Num5()) {
                        Ms.i().keyRelease();
                        if (this.selectx == 0) {
                            if (this.selecty == 0) {
                                if (this.buyOk == 1) {
                                    run_state = 100;
                                    this.b_c = (byte) 0;
                                    this.buyOk = (byte) 0;
                                    break;
                                } else {
                                    this.buyOk = (byte) 1;
                                    break;
                                }
                            } else if (this.selecty == 1) {
                                goVIEW_MONSTER();
                                break;
                            } else if (this.selecty == 2) {
                                goMY_BAG(0);
                                break;
                            } else if (this.selecty == 3) {
                                goLIST_INFO(true);
                                break;
                            } else if (this.selecty == 4) {
                                this.map.goMission(0, true);
                                break;
                            } else if (this.selecty == 5) {
                                goRUN_IN_MAP(true);
                                this.action_str = null;
                                break;
                            }
                        } else if (this.selecty == 0) {
                            if (this.buyOk != 2) {
                                this.buyOk = (byte) 2;
                                break;
                            } else {
                                loadGame();
                                break;
                            }
                        } else if (this.selecty == 1) {
                            this.isChangeSound = true;
                            Sound.i().keyVolume(0);
                            break;
                        } else if (this.selecty == 2) {
                            mc.goHELP_dialog(1);
                            break;
                        } else if (this.selecty == 3) {
                            if (this.buyOk == 3) {
                                run_state = 0;
                                this.action_str = null;
                                goMAIN_MENU();
                                this.buyOk = (byte) 0;
                                break;
                            } else {
                                this.buyOk = (byte) 3;
                                break;
                            }
                        }
                    } else if (Ms.i().key_S2()) {
                        if (this.buyOk == 0) {
                            this.action_str = null;
                            goRUN_IN_MAP(true);
                            break;
                        } else {
                            doPaint(0);
                            run_state = 97;
                            this.buyOk = (byte) 0;
                            break;
                        }
                    } else if (this.buyOk == 0) {
                        if (Ms.i().key_Left_Right()) {
                            this.selectx = (byte) (this.selectx ^ 1);
                            this.selecty = (byte) 0;
                            setPauseS(this.selectx);
                            break;
                        } else if (Ms.i().key_Up_Down()) {
                            this.selecty = Ms.i().select(this.selecty, 0, this.action_str.length - 1);
                            break;
                        }
                    }
                } else {
                    return;
                }
                break;
        }
        if (Ms.i().key_S1_Num5() || Ms.i().key_S2()) {
            Ms.i().keyRelease();
        }
    }

    private void loadGame() {
        this.map.firstDrawMap = (byte) 0;
        this.buyOk = (byte) 0;
        this.map.mapImg = null;
        System.out.println("loadGame 111111111111");
        mc.goGameLoading();
        System.out.println("loadGame 22222222222");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, short], vars: [r20v0 ??, r20v1 ??, r20v2 ??, r20v3 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    private void drawMonsterHp(dm.Monster r14, int r15, int r16, int r17, int r18, int r19, 
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, short], vars: [r20v0 ??, r20v1 ??, r20v2 ??, r20v3 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r20v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:285)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:636)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:80)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:118)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:400)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:388)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:338)
        */

    private short getMonsterExp(Monster monster) {
        return (short) (((monster.monster[2] * 210) / 10) - 2);
    }

    private boolean level_up(int no, int mode) {
        if (mode == 0) {
            byte b = this.myMonsters[no].monster[2];
            Ms.i();
            byte LevelCha = (byte) (b - Ms.skip2);
            Ms.i();
            Ms.skip = this.exp;
            short buff = this.myMonsters[no].isMonReel(36) ? (short) (0 + 100) : (short) 0;
            if (this.myMonsters[no].isMonReel(37)) {
                buff = (short) (buff + 200);
            }
            if (LevelCha < 0) {
                LevelCha = 0;
            } else if (LevelCha > 4) {
                LevelCha = 5;
            }
            Ms.i();
            Ms.i();
            Ms.skip = (short) (((Ms.skip * (9 - (LevelCha * 2))) * (buff + 100)) / Constants.PAYMENT_MAX);
            Ms.i();
            if (Ms.skip < 1) {
                Ms.i();
                Ms.i();
                Ms.skip = Ms.getRandom(6) + 5;
            }
            if (this.battle_type == 3 || this.battle_type == 0) {
                Ms.i();
                Ms.i();
                Ms.skip = (short) ((Ms.skip * 3) / 2);
            }
            short[] sArr = this.proReplace[no];
            Ms.i();
            sArr[2] = (short) Ms.skip;
        } else if (mode == 1) {
            if (this.myMonsters[no].monster[2] < 60) {
                Ms.i();
                if (Ms.skip > 0) {
                    short tempLevelExp = getMonsterExp(this.myMonsters[no]);
                    short s = this.myMonsters[no].monsterPro[4];
                    Ms.i();
                    short expt = (short) (s + Ms.skip);
                    if (expt >= tempLevelExp) {
                        this.myB.cexp = this.myMonsters[no].monsterPro[4];
                        this.myMonsters[no].monsterPro[4] = tempLevelExp;
                        Ms.i();
                        Ms.skip = (short) (expt - tempLevelExp);
                    } else {
                        this.myB.cexp = this.myMonsters[no].monsterPro[4];
                        short[] sArr2 = this.myMonsters[no].monsterPro;
                        short s2 = sArr2[4];
                        Ms.i();
                        sArr2[4] = (short) (s2 + Ms.skip);
                        Ms.i();
                        Ms.skip = -1;
                    }
                }
            }
            Ms.i();
            Ms.skip = -1;
            this.proReplace[no][2] = 0;
        } else if (mode == 2) {
            Ms.i();
            if (Ms.skip <= -1) {
                return false;
            }
            levelPro(no, false);
            getMagic(this.myMonsters[no]);
            this.levelUp_in_battle[this.myMonsters[no].monster[1]][0] = 1;
            this.levelUp_in_battle[this.myMonsters[no].monster[1]][1] = this.getSkill;
            this.myMonsters[no].monsterPro[4] = 0;
        }
        return true;
    }

    public void levelPro(int no, boolean bb) {
        if (bb) {
            byte enlevel_star = (byte) this.proReplace[no][6];
            byte[] temp_pro = this.monster_pro[this.myMonsters[no].monster[0]];
            short temp = (short) (temp_pro[0] + ((temp_pro[7] * enlevel_star) / 10));
            this.proReplace[no][0] = (short) (this.myMonsters[no].monsterPro[2] - getbuffRateV(this.myMonsters[no], temp));
            short temp2 = (short) (temp_pro[1] + ((temp_pro[8] * enlevel_star) / 10));
            this.proReplace[no][1] = (short) (this.myMonsters[no].monsterPro[3] - temp2);
            short temp3 = (short) (temp_pro[3] + ((temp_pro[10] * enlevel_star) / 10));
            this.proReplace[no][3] = (short) (this.myMonsters[no].monsterPro[6] - temp3);
            short temp4 = (short) (temp_pro[4] + ((temp_pro[11] * enlevel_star) / 10));
            this.proReplace[no][4] = (short) (this.myMonsters[no].monsterPro[7] - temp4);
            short temp5 = (short) (temp_pro[2] + ((temp_pro[9] * enlevel_star) / 10));
            this.proReplace[no][5] = (short) (this.myMonsters[no].monsterPro[5] - temp5);
            return;
        }
        byte[] bArr = this.myMonsters[no].monster;
        byte enemylevel = (byte) (bArr[2] + 1);
        bArr[2] = enemylevel;
        byte[] temp_pro2 = this.monster_pro[this.myMonsters[no].monster[0]];
        this.myMonsters[no].monsterPro[2] = (short) (temp_pro2[0] + ((temp_pro2[7] * enemylevel) / 10));
        this.myMonsters[no].monsterPro[3] = (short) (temp_pro2[1] + ((temp_pro2[8] * enemylevel) / 10));
        this.myMonsters[no].monsterPro[6] = (byte) (temp_pro2[3] + ((temp_pro2[10] * enemylevel) / 10));
        this.myMonsters[no].monsterPro[7] = (byte) (temp_pro2[4] + ((temp_pro2[11] * enemylevel) / 10));
        this.myMonsters[no].monsterPro[5] = (byte) (temp_pro2[2] + ((temp_pro2[9] * enemylevel) / 10));
        this.myMonsters[no].resetPro(this);
        healMonster(this.myMonsters[no]);
    }

    private short getbuffRateV(Monster mon, int temp) {
        if (mon.isBuffRate(2)) {
            temp += (this.inhesion[2] * temp) / 100;
        } else if (mon.isBuffRate(1)) {
            temp += (this.inhesion[1] * temp) / 100;
        }
        return (short) temp;
    }

    private void paintBATTLE_OVER() {
        if (this.b_c == 1) {
            drawEvolveUI(0, this.myB.now_id, false);
        }
    }

    public byte delMonster(int no) {
        byte id = this.myMonsters[no].monster[0];
        if (monsterRemove(no) != -1) {
            say(Constants_H.TXT_14 + getNameMon(id), 0);
            return (byte) 1;
        }
        say(Constants_H.TXT_13, 0);
        return (byte) -1;
    }

    private byte monsterRemove(int no) {
        if (this.myMon_length > 1) {
            this.myMonsters[no] = null;
            for (byte i = (byte) no; i < this.myMon_length - 1; i = (byte) (i + 1)) {
                this.myMonsters[i] = this.myMonsters[i + 1];
                this.evolve[i] = this.evolve[i + 1];
            }
            for (byte i2 = this.myMon_length; i2 < this.myMonsters.length; i2 = (byte) (i2 + 1)) {
                this.evolve[i2] = true;
            }
            this.myMon_length = (byte) (this.myMon_length - 1);
            return (byte) 1;
        }
        return (byte) -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void healMonster(Monster monster) {
        monster.effect = (byte) 7;
        monster.monsterPro[1] = monster.monsterPro[3];
        monster.monsterPro[0] = monster.monsterPro[2];
    }

    public void healMonster(boolean bb) {
        for (byte i = 0; i < this.myMon_length; i = (byte) (i + 1)) {
            healMonster(this.myMonsters[i]);
        }
        if (bb) {
            say(Constants_H.TXT_52, 0);
        }
    }

    public byte findMonster(int id, int lv) {
        for (byte i = 0; i < this.myMon_length; i = (byte) (i + 1)) {
            if (this.myMonsters[i].monster[0] == id && this.myMonsters[i].monster[2] >= lv) {
                return i;
            }
        }
        return (byte) -1;
    }

    public byte findMonsterMinLv(int id, int lv) {
        byte minLv = -1;
        for (byte i = (byte) (this.myMon_length - 1); i > -1; i = (byte) (i - 1)) {
            if (this.myMonsters[i].monster[0] == id && this.myMonsters[i].monster[2] >= lv && (minLv == -1 || this.myMonsters[i].monster[2] < this.myMonsters[minLv].monster[2])) {
                minLv = i;
            }
        }
        return minLv;
    }

    public byte getMonster(int id, int level, int evolve, int buff) {
        Monster enemyMB = new Monster(this, id, level, buff);
        if (this.cMon_count == this.max_monsters && this.myMon_length == this.max_takes) {
            say(Constants_H.TXT_48, 0);
            return (byte) -1;
        }
        if (getMonster(enemyMB, evolve, true) != 1) {
            say(Constants_H.TXT_49 + getNameMon((byte) id), 0);
        } else {
            say(Constants_H.TXT_50 + getNameMon(enemyMB.monster[0]) + Constants_H.TXT_51, 0);
        }
        return (byte) 1;
    }

    private byte getMonster(Monster monster, int evolve, boolean bb) {
        if (this.monInfoList[monster.monster[0]] != 2) {
            this.monInfoList[monster.monster[0]] = 2;
            addMonInfoListBH();
            this.map.addAnole(monster.monster[0]);
        }
        if (this.myMon_length < this.max_takes) {
            this.myMonsters[this.myMon_length] = monster;
            if (bb) {
                this.myMonsters[this.myMon_length].resetMonster(this, evolve);
            }
            this.myMon_length = (byte) (this.myMon_length + 1);
            return (byte) 0;
        }
        if (this.cMon_count < this.max_monsters) {
            say(Constants_H.TXT_50 + getNameMon(monster.monster[0]) + Constants_H.TXT_51, 0);
            this.cMonsters[this.cMon_count] = monster;
            if (bb) {
                this.cMonsters[this.cMon_count].resetMonster(this, evolve);
            }
            this.cMon_count = (byte) (this.cMon_count + 1);
            return (byte) 1;
        }
        return (byte) -1;
    }

    public void addMonInfoListBH() {
        byte[] bArr = this.monInfoList;
        bArr[104] = (byte) (bArr[104] + 1);
        byte[] bArr2 = this.monInfoList;
        bArr2[103] = (byte) (bArr2[103] + 1);
        if (this.monInfoList[103] == 102) {
            say(Constants_H.TXT_30, 0);
            mc.paint();
            Ms.i().sleep(600);
        }
    }

    public byte findItemType(int item_id) {
        if (item_id < 16) {
            return (byte) 0;
        }
        if (item_id < 35) {
            return (byte) 1;
        }
        return item_id < 58 ? (byte) 2 : (byte) 3;
    }

    public byte findItem(int item_type, int item_id, boolean bb) {
        if (item_type == -2) {
            item_type = findItemType(item_id);
        }
        for (byte i = 0; i < this.itemsLength[item_type]; i = (byte) (i + 1)) {
            if (this.items[item_type][i][0] == item_id) {
                return bb ? this.items[item_type][i][1] : i;
            }
        }
        return (byte) (bb ? 0 : -1);
    }

    public byte getItem(int item_id, int count) {
        if (addItem(item_id, count) != 1) {
            return (byte) -1;
        }
        say("获得：“" + getNameItem((byte) item_id) + "”x" + count, 0);
        return (byte) 1;
    }

    public byte addItem(int item_id, int count) {
        byte item_type = findItemType(item_id);
        byte item_no = findItem(item_type, item_id, false);
        if (item_no != -1) {
            byte[] bArr = this.items[item_type][item_no];
            byte b = (byte) (bArr[1] + count);
            bArr[1] = b;
            if (b > 99) {
                this.items[item_type][item_no][1] = 99;
                say(String.valueOf(getNameItem(this.items[item_type][item_no][0])) + Constants_H.MONEY_TXT_5, 0);
                return (byte) -1;
            }
        } else {
            this.items[item_type][this.itemsLength[item_type]][0] = (byte) item_id;
            this.items[item_type][this.itemsLength[item_type]][1] = (byte) count;
            byte[] bArr2 = this.itemsLength;
            bArr2[item_type] = (byte) (bArr2[item_type] + 1);
        }
        return (byte) 1;
    }

    public void deleteItems(int item_id, int count) {
        byte item_type = findItemType(item_id);
        byte item_no = findItem(item_type, item_id, false);
        if (item_no != -1) {
            if (this.items[item_type][item_no][1] >= count) {
                byte[] bArr = this.items[item_type][item_no];
                bArr[1] = (byte) (bArr[1] - count);
            }
            if (this.items[item_type][item_no][1] == 0) {
                dItemIn(item_type, item_no);
            }
        }
    }

    private void dItemIn(int item_type, int item_no) {
        for (int i = item_no; i < this.itemsLength[item_type] - 1; i++) {
            this.items[item_type][i] = this.items[item_type][i + 1];
        }
        byte[] bArr = this.itemsLength;
        bArr[item_type] = (byte) (bArr[item_type] - 1);
        this.items[item_type][this.itemsLength[item_type]] = null;
        this.items[item_type][this.itemsLength[item_type]] = new byte[2];
    }

    private void useState(int type, int id) {
        mc.paint();
        Ms.i().sleep(Player.REALIZED);
        if (this.view_state == -1) {
            this.myB.act_num = (byte) 0;
            goBattleState();
            this.battle_state = (byte) 9;
            initMonStream(2, this.mList_id[this.myMonsters[0].monster[0]][0], 1);
        } else {
            goMY_BAG(type);
        }
        deleteItems(this.items[type][id][0], 1);
    }

    private void mpAdd(int hp) {
        if (this.myMonsters[this.select[0][0]].monsterPro[1] < this.myMonsters[this.select[0][0]].monsterPro[3] && this.myMonsters[this.select_T].monsterPro[0] > 0) {
            AddMP((this.myMonsters[this.select[0][0]].monsterPro[3] * hp) / 100, this.myMonsters[this.select[0][0]]);
            useState(0, this.select_it[0]);
        } else if (this.myMonsters[this.select[0][0]].monsterPro[1] < 1) {
            say(String.valueOf(getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + Constants_H.TXT_0, 0);
        } else {
            say(String.valueOf(getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + Constants_H.TXT_1, 0);
        }
    }

    private void hpAdd(int hp, int offer) {
        if (this.myMonsters[this.select[0][0]].monsterPro[0] < this.myMonsters[this.select[0][0]].monsterPro[2] && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
            AddHP(offer + ((this.myMonsters[this.select[0][0]].monsterPro[2] * hp) / 100), this.myMonsters[this.select[0][0]]);
            useState(0, this.select_it[0]);
        } else if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            say(String.valueOf(getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + Constants_H.TXT_0, 0);
        } else {
            say(String.valueOf(getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + Constants_H.TXT_1, 0);
        }
    }

    private void allAdd(int hp) {
        boolean bmp = false;
        boolean bhp = false;
        if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            say(String.valueOf(getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + Constants_H.TXT_0, 0);
            return;
        }
        if (this.myMonsters[this.select[0][0]].monsterPro[1] < this.myMonsters[this.select[0][0]].monsterPro[3] && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
            AddMP((this.myMonsters[this.select[0][0]].monsterPro[3] * hp) / 100, this.myMonsters[this.select[0][0]]);
            bmp = true;
        }
        if (this.myMonsters[this.select[0][0]].monsterPro[0] < this.myMonsters[this.select[0][0]].monsterPro[2] && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
            AddHP((this.myMonsters[this.select[0][0]].monsterPro[2] * hp) / 100, this.myMonsters[this.select[0][0]]);
            bhp = true;
        }
        if (bhp || bmp) {
            useState(0, this.select_it[0]);
        } else if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            AddHP((this.myMonsters[this.select[0][0]].monsterPro[2] * hp) / 100, this.myMonsters[this.select[0][0]]);
        } else {
            say(String.valueOf(getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + Constants_H.TXT_1, 0);
        }
    }

    private void changeEffect() {
        if (this.myMonsters[this.select[0][0]].effect != 7) {
            this.myMonsters[this.select[0][0]].effect = (byte) 7;
            useState(0, this.select_it[0]);
        } else {
            say(String.valueOf(getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + Constants_H.TXT_2, 0);
        }
    }

    private void resetMonster(int hp) {
        if (this.myMonsters[this.select[0][0]].monsterPro[0] < 1) {
            AddMP((this.myMonsters[this.select[0][0]].monsterPro[3] * hp) / 100, this.myMonsters[this.select[0][0]]);
            AddHP((this.myMonsters[this.select[0][0]].monsterPro[2] * hp) / 100, this.myMonsters[this.select[0][0]]);
            this.myMonsters[this.select[0][0]].effect = (byte) 7;
            useState(0, this.select_it[0]);
            return;
        }
        say(String.valueOf(getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + Constants_H.TXT_4, 0);
    }

    private void resetFealty(int hp) {
        byte fealty = this.initFealty[this.myMonsters[this.select[0][0]].monster[4] / 4];
        if (this.myMonsters[this.select[0][0]].monster[6] < fealty && this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
            if (hp == -1) {
                this.myMonsters[this.select[0][0]].monster[6] = fealty;
            } else if (this.myMonsters[this.select[0][0]].monster[6] + hp > fealty) {
                this.myMonsters[this.select[0][0]].monster[6] = fealty;
            } else {
                byte[] bArr = this.myMonsters[this.select[0][0]].monster;
                bArr[6] = (byte) (bArr[6] + hp);
            }
            useState(0, this.select_it[0]);
            if (this.view_state == -1) {
                getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
                return;
            }
            return;
        }
        if (this.myMonsters[this.select[0][0]].monsterPro[0] > 0) {
            say(String.valueOf(getNameMon(this.myMonsters[this.select[0][0]].monster[0])) + Constants_H.TXT_3, 0);
        }
    }

    private void useItem() {
        switch (this.items[0][this.select_it[0]][0]) {
            case 0:
                hpAdd(35, 30);
                return;
            case 1:
                hpAdd(65, 30);
                return;
            case 2:
                hpAdd(100, 0);
                return;
            case 3:
                mpAdd(50);
                return;
            case 4:
                mpAdd(100);
                return;
            case 5:
                allAdd(50);
                return;
            case 6:
                allAdd(100);
                return;
            case 7:
                resetMonster(30);
                return;
            case 8:
                changeEffect();
                return;
            case 9:
            case 10:
            case 11:
            default:
                return;
            case 12:
                resetFealty(30);
                return;
            case Canvas.KEY_NUM6 /* 13 */:
                resetFealty(-1);
                return;
        }
    }

    public void goYouPAUSE(int sy) {
        run_state = 97;
        this.selectx = (byte) 0;
        this.selecty = (byte) sy;
        setPauseS(0);
        Sound.i().soundStop();
        this.say_c = (byte) 0;
        this.view_state = (byte) 1;
        this.mini_state = (byte) 3;
        this.buyItemID = (byte) 0;
        this.buyOk = (byte) 0;
        this.gogoString = Constants_H.TXT_73;
    }

    private void goRUN_IN_MAP(boolean bb) {
        this.selecty = (byte) 0;
        this.selectx = (byte) 0;
        this.select[0][1] = 0;
        this.mini_state = (byte) 0;
        this.view_state = (byte) 0;
        mc.game_state = 30;
        System.out.println("aaaaaaaaaaaaaaaaa");
        this.map.my.state = (byte) 0;
        if (!this.isChangeSound.booleanValue()) {
            Sound.i().setMusicId(this.musicNo[this.map.mapNo]);
            Sound.i().setMusic(bb);
            Log.d("soars", "tttttttttttttttttttttt");
        }
        if (this.isChangeSound.booleanValue()) {
            Sound.i().setMusicId(this.musicNo[this.map.mapNo]);
            Sound.i().setMusicForMenu(bb);
            Log.d("soars", "ffffffffffffffffffffffffffffffff");
        }
        run_state = -10;
        this.createOver = (byte) 0;
        this.buyItemID = (byte) 0;
    }

    public String getNameMonsterInfo(int id) {
        return this.monsterInfo[id].toString();
    }

    public String getNameItem(int item_id) {
        return this.item_name[item_id].toString();
    }

    public String getNameCity(int id) {
        return this.city_name[id].toString();
    }

    public String getNameMon(int mon_id) {
        return this.NAME[mon_id].toString();
    }

    private String getNameSkill(byte skill_id) {
        return this.skill_name[skill_id].toString();
    }

    private String getNameBuff(int buff_id) {
        if (buff_id < 1) {
            buff_id = 0;
        }
        return this.buff_name[buff_id].toString();
    }

    public void say(String string, int flag) {
        Log.e("soars", string);
        if (string.equals("#7点击屏幕或用导航键#0控制上下左右移动。")) {
            string = "#7点击屏幕#0控制上下左右移动。";
        } else if (string.contains("菜单键")) {
            string.replace("菜单键", "右下方工具按钮");
        }
        this.sayStr.add(string);
        this.sayFlag.add(Integer.valueOf(flag));
        setSay();
    }

    public void doSayOverSms() {
        int temp = this.sayOverSms;
        System.out.println("doSayOverSms() sayOverSms= " + ((int) this.sayOverSms));
        this.sayOverSms = (byte) -1;
        if (temp == 0) {
            isSay = true;
            SMSSender.i(this).go(4, true);
            isSay = false;
        } else if (temp == 1) {
            SMSSender.i(this).go(3, true);
        }
    }

    public void say(String string, int flag, int sayOverSms) {
        this.showS = Ms.i().groupString(string, Constants_H.WIDTH - 50);
        this.say_s = Constants_H.WIDTH;
        this.say_mode = (byte) 0;
        if (flag == 0) {
            this.say_c = (byte) 15;
            return;
        }
        if (flag == -1) {
            this.say_c = (byte) -1;
            this.sayOverSms = (byte) sayOverSms;
        } else if (flag == 1) {
            this.say_c = (byte) 15;
            this.say_mode = (byte) 1;
        }
    }

    public void setSay() {
        if (this.say_c == 0 && this.sayStr.size() != 0) {
            String string = this.sayStr.remove(0);
            int flag = this.sayFlag.remove(0).intValue();
            this.showS = Ms.i().groupString(string, Constants_H.WIDTH - 50);
            this.say_s = Constants_H.WIDTH;
            this.say_mode = (byte) 0;
            if (flag == 0) {
                this.say_c = (byte) 15;
                return;
            }
            if (flag == -1) {
                this.say_c = (byte) -1;
            } else if (flag == 1) {
                this.say_c = (byte) 15;
                this.say_mode = (byte) 1;
            }
        }
    }

    public void map_flashString() {
        int WIDTH = Constants_H.WIDTH__;
        int HEIGHT = Constants_H.HEIGHT__;
        int HEIGHT_H = Constants_H.HEIGHT__ / 2;
        setSay();
        if (this.say_c > 0 && run_state != 98) {
            if (!this.map.fontSizeControl) {
                Ms.i();
                Ms.font.setSize(22);
            }
            showString(this.showS, this.say_mode == 0 ? (HEIGHT_H - ((this.showS.length >> 1) * 25)) - 12 : (HEIGHT - 50) - 18, this.say_s, 1);
            if (this.say_s == 0) {
                this.say_c = (byte) (this.say_c - 1);
            } else {
                this.say_s = Ms.i().mathSpeedDown(this.say_s, 3, true);
            }
        } else if (this.say_c < 0 && run_state != 98) {
            Ms.i();
            Ms.font.setSize(22);
            showString(this.showS, (HEIGHT_H - ((this.showS.length >> 1) * 25)) - 12, this.say_s, 2);
            if (this.say_s != 0) {
                this.say_s = Ms.i().mathSpeedDown(this.say_s, 3, true);
            }
            if (this.pkey.isSelect(0, 0, WIDTH, HEIGHT)) {
                this.pkey.setKey5();
            }
        }
        Ms.i();
        Ms.font.setSize(26);
    }

    public void drawCityName() {
        int WIDTH_H = Constants_H.WIDTH__ / 2;
        if (this.cityName_c != -20) {
            short w = (short) (Ms.i().getStringWidth(this.city_name[this.map.mapNo].toString()) + 8);
            Ui.i().drawKuang(WIDTH_H - (w >> 1), this.cityName_c > 0 ? (byte) 0 : this.cityName_c, w, 25 + 6);
            Ui.i().drawString(this.city_name[this.map.mapNo].toString(), WIDTH_H, this.cityName_c > 0 ? (byte) 0 : this.cityName_c, 17, 4, 2);
            this.cityName_c = (byte) (this.cityName_c - 1);
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
            for (byte i = 0; i < this.imgBG.length; i = (byte) (i + 1)) {
                this.imgBG[i] = Ms.i().createImage("data/battle/" + ((int) i));
            }
        }
        initImgIco();
    }

    public void data_init() {
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

    public boolean isNpc2ImageType(int id) {
        for (byte i = 0; i < this.npc2ImageType.length; i = (byte) (i + 1)) {
            if (this.npc2ImageType[i] == id) {
                return false;
            }
        }
        return true;
    }

    private void goCatchMonster() {
        run_state = -19;
        this.cThrowX = (short) 131;
        this.cThrowY = (short) -20;
        this.cThrowS = (short) 176;
        this.b_c = (byte) 0;
    }

    private void drawClipPic(int action_id, int id, int x, int y, int w, int h, int piece, int cc, int dir) {
        byte i = 1;
        byte ph = (byte) (w / piece);
        int i2 = 2 << cc;
        while (true) {
            short speed = (short) i2;
            if (i < piece) {
                g.clipRect(x - (i * ph), y - h, ph - speed <= 0 ? ph : speed, h + 20);
                drawCartoonOne(id, id, action_id * 3, x, y, true, dir);
                g.setClip(0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
                g.clipRect(((i - 1) * ph) + x, y - h, ph - speed <= 0 ? ph : speed, h + 20);
                drawCartoonOne(id, id, action_id * 3, x, y, true, dir);
                g.setClip(0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
                i = (byte) (i + 1);
                i2 = speed / 2;
            } else {
                return;
            }
        }
    }

    private void goMontsterAppear() {
        run_state = -50;
        this.battle_state = (byte) 0;
        this.enemyOff = 63;
        setAimBattle(1);
    }

    private void setEnemyThrow() {
        this.enemyOff = 63;
        this.enB.cThrow[0] = (byte) ((Constants_H.WIDTH - 377) + 20);
        this.enB.cThrow[1] = 60;
        this.enB.cThrow[2] = 0;
        setThrow(this.enB, this.enB.getMon(), 0);
        getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
        getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
    }

    private void setMyThrow() {
        this.myB.cThrow[0] = -286;
        this.myB.cThrow[1] = 60;
        this.myB.cThrow[2] = 0;
        setThrow(this.myB, this.myB.getMon(), 1);
        getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
        getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
    }

    private void setThrow(Battle be, Monster mon, int mini) {
        be.throw_state = (byte) -1;
        initMonStream(2, this.mList_id[mon.monster[0]][0], mini);
        if (mon.isMonReel(mon.monster[3] + Constants_H.f89)) {
            if (be.bg_id != mon.monster[3]) {
                this.src_c[mini + 2] = 1;
            }
        } else if (this.monPro.length != 0 && be.bg_id != this.monPro[0]) {
            this.src_c[mini + 2] = 1;
        }
        be.action = (byte) 0;
        be.dead = (byte) 0;
        be.chp = mon.monsterPro[0];
    }

    private void drawThrowBall(Battle be, Monster mon, int mini, int x, int y) {
        if (be.throw_state == 0) {
            Ui i = Ui.i();
            Image image = this.imgItem[0];
            int i2 = be.cThrow[0] + x;
            int i3 = y - be.cThrow[1];
            Graphics graphics = g;
            Graphics graphics2 = g;
            i.drawImage(image, i2, i3, 1 | 32);
        } else if (be.throw_state == 1) {
            drawClipPic(this.mList_id[mon.monster[0]][1], mini, x, y, 80, 77, 15, be.cThrow[2], mini);
        } else if (be.throw_state == 2) {
            drawCartoonOne(mini, mini, this.mList_id[mon.monster[0]][1] * 3, x, y, true, mini);
        }
        runThrowBall(be, mon, mini);
    }

    private void runThrowBall(Battle be, Monster mon, int mini) {
        if (this.src_c[mini + 2] == 0 && be.throw_state == -1 && this.src_c[mini] == 12) {
            be.throw_state = (byte) 0;
        } else if (this.src_c[mini + 2] == 1 && this.src_c[mini] == 0) {
            this.src_c[mini + 2] = 0;
            getBattleBG(be, mon);
        }
        if (be.throw_state == 0) {
            be.cThrow[0] = (byte) Ms.i().mathSpeedN(be.cThrow[0], 0, 6, false);
            be.cThrow[1] = (byte) Ms.i().mathSpeedUp(be.cThrow[1], 62, 2);
            if (be.cThrow[0] != 0 || be.cThrow[1] != 0) {
                return;
            }
            be.throw_state = (byte) 1;
            return;
        }
        if (be.throw_state == 1) {
            if (be.cThrow[2] >= 12) {
                be.throw_state = (byte) 2;
            } else {
                short[] sArr = be.cThrow;
                sArr[2] = (short) (sArr[2] + 1);
            }
        }
    }

    private void drawPlayerAppear(Graphics g) {
        switch (this.battle_state) {
            case 0:
                if (this.battle_type > 2) {
                    if (this.src_c[2] == 0 && this.enB.throw_state == -1 && this.src_c[0] == 12) {
                        this.enB.throw_state = (byte) 0;
                    } else if (this.enB.throw_state == 0 || this.enB.throw_state == 2) {
                        drawCartoonOne(0, 0, (this.mList_id[this.enB.getMon().monster[0]][1] * 3) + this.enB.action, this.enemyOff + 377, 97, false, 0);
                        this.enemyOff = Ms.i().mathSpeedN(this.enemyOff, 0, 4, false);
                        if (this.enemyOff == 0) {
                            this.enB.throw_state = (byte) 2;
                        }
                    }
                } else if (this.battle_type < 2) {
                    drawThrowBall(this.enB, this.enB.getMon(), 0, 377, 97);
                }
                drawThrowBall(this.myB, this.myB.getMon(), 1, 266, 236);
                return;
            default:
                return;
        }
    }

    private void runMonsterAppear() {
        switch (this.battle_state) {
            case 0:
                if (this.myB.throw_state == 2 && this.myB.throw_state == 2) {
                    if (this.view_state == -2) {
                        setAimBattle(0);
                        this.myB.act_num = (byte) 0;
                        this.enB.act_num = (byte) 0;
                    }
                    this.view_state = (byte) -1;
                    goBattleState();
                    if (this.t_battle_state == -3 || this.t_battle_state == -2) {
                        this.battle_state = this.t_battle_state;
                        this.t_battle_state = (byte) 0;
                        getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
                    } else {
                        goSelectAction(this.mini_state);
                    }
                    if (this.first_battle == 0) {
                        this.first_battle = (byte) 1;
                        byte coe = (byte) (this.myB.getMon().monster[6] - 99);
                        if (((byte) (coe > 1 ? 20 : (coe / 20) * 20)) < 0) {
                            say(Constants_H.BATTLE_TXT_15, 0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void getHitCoefficient(Battle be, Monster am, Monster dm2) {
        be.countS[1] = 0;
        byte coe = (byte) (am.monster[6] - 99);
        byte[] bArr = be.countS;
        bArr[1] = (byte) (bArr[1] + (coe > 1 ? 20 : (coe / 20) * 20));
        if (am.monster[3] != -1 && be.bg_id != am.monster[3]) {
            byte[] bArr2 = be.countS;
            bArr2[1] = (byte) (bArr2[1] + (be.bg_id == am.monster[3] ? (byte) 0 : Constants_H.SMS_PAUSE));
        }
        byte[] bArr3 = be.countS;
        bArr3[1] = (byte) (bArr3[1] + isShuXing(am, dm2));
    }

    private boolean drawHitOne(Battle dm2, Battle am, int x, int y) {
        boolean bb = true;
        this.strHit = "";
        for (byte i = 0; i < dm2.hit.length; i = (byte) (i + 1)) {
            if (dm2.hit[i][4] < this.zb.length) {
                bb = false;
                if (dm2.hit[i][0] == -1) {
                    this.strHit = Constants_H.TXT_7;
                } else if (dm2.hit[i][0] == -2) {
                    this.strHit = Constants_H.BATTLE_TXT_18;
                } else {
                    StringBuilder sb = new StringBuilder(String.valueOf(dm2.hit[i][1] > -1 ? "-" : "+"));
                    Ms.i();
                    this.strHit = sb.append(Ms.abs(dm2.hit[i][1])).toString();
                }
                if (dm2.hit[i][0] > 0 && dm2.hit[i][0] < 4) {
                    if (dm2.hit[i][0] == 2) {
                        Ui.i().drawUi(32, dm2.hit[i][2] + x + ((this.strHit.length() >> 1) * 14) + 15, dm2.hit[i][3] + y + 8, 40, 0);
                        Ui.i().drawUi(33, dm2.hit[i][2] + x + ((this.strHit.length() >> 1) * 14) + 15, dm2.hit[i][3] + y + 8, 36, 0);
                    }
                    Ui.i().drawNum(this.strHit, dm2.hit[i][2] + x, dm2.hit[i][3] + y, 0, dm2.hit[i][0] == 2 ? 2 : 1);
                } else if (dm2.hit[i][0] < 0 || dm2.hit[i][0] == 4) {
                    Ui.i().drawString(this.strHit, dm2.hit[i][2] + x, dm2.hit[i][3] + y, 0, dm2.hit[i][0] == 4 ? 1 : 0, 2);
                }
                if (i == 0) {
                    short[] sArr = dm2.hit[i];
                    sArr[2] = (short) (sArr[2] + (this.mini_state == 1 ? (short) 1 : (short) -1));
                    short[] sArr2 = dm2.hit[i];
                    sArr2[3] = (short) (sArr2[3] + this.zb[dm2.hit[i][4]]);
                } else if (i == 1) {
                    short[] sArr3 = dm2.hit[i];
                    sArr3[2] = (short) (sArr3[2] + (this.mini_state == 1 ? (short) 1 : (short) -1));
                    short[] sArr4 = dm2.hit[i];
                    sArr4[3] = (short) (sArr4[3] + this.zb[dm2.hit[i][4]]);
                } else if (i == 2) {
                    short[] sArr5 = dm2.hit[i];
                    sArr5[3] = (short) (sArr5[3] - (dm2.hit[i][4] / 3));
                }
                short[] sArr6 = dm2.hit[i];
                short s = (short) (sArr6[4] + 1);
                sArr6[4] = s;
                if (s == 1) {
                    if (dm2.hit[i][0] == 4) {
                        short[] sArr7 = dm2.getMon().monsterPro;
                        sArr7[1] = (short) (sArr7[1] - dm2.hit[i][1]);
                    } else if (dm2.hit[i][0] == -2 && this.mini_state == 0 && !dm2.getMon().isMonReel(40)) {
                        byte[] bArr = dm2.getMon().monster;
                        bArr[6] = (byte) (bArr[6] - dm2.hit[i][1]);
                        getHitCoefficient(dm2, dm2.getMon(), am.getMon());
                    } else if (dm2.hit[i][0] > 0) {
                        short[] sArr8 = dm2.getMon().monsterPro;
                        sArr8[0] = (short) (sArr8[0] - dm2.hit[i][1]);
                    }
                }
            }
        }
        valueMend(dm2.getMon());
        return bb;
    }

    public void valueMend(Monster monster) {
        if (monster.monsterPro[0] < 0) {
            monster.monsterPro[0] = 0;
        } else if (monster.monsterPro[0] > monster.monsterPro[2]) {
            monster.monsterPro[0] = monster.monsterPro[2];
        }
        if (monster.monsterPro[1] >= 0) {
            if (monster.monsterPro[1] > monster.monsterPro[3]) {
                monster.monsterPro[1] = monster.monsterPro[3];
                return;
            }
            return;
        }
        monster.monsterPro[1] = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x008e, code lost:
    
        if (dm.Ms.getRandom(100) >= r17.inhesion[9]) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x00b3, code lost:
    
        r13 = r13 >> 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b1, code lost:
    
        if (dm.Ms.getRandom(100) < r17.skill[48][0]) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void damage(dm.Battle r18, dm.Battle r19, dm.Monster r20, dm.Monster r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: main.GameRun.damage(dm.Battle, dm.Battle, dm.Monster, dm.Monster, int, int):void");
    }

    private byte isShuXing(Monster am, Monster dm2) {
        if (am.monster[3] != -1 && this.Shuxing[am.monster[3]][0] != dm2.monster[3]) {
            return this.Shuxing[am.monster[3]][1] == dm2.monster[3] ? (byte) 0 : (byte) 0;
        }
        return (byte) 30;
    }

    private void hit_rate(Battle amB, Battle dmB, Monster am, Monster dm2, int skill_no) {
        amB.initHit();
        dmB.initHit();
        this.hit_rate = am.monsterPro[5] - dm2.monsterPro[5];
        this.hit_rate = (this.hit_rate / 2) + 92 + amB.rate_off;
        Ms.i();
        byte rand = (byte) Ms.getRandom(100);
        amB.rate_off = (byte) 0;
        if (skill_no > 26 && skill_no < 30) {
            switch (skill_no) {
                case 27:
                case 28:
                    amB.addHit((-this.skill[skill_no][0]) * 10, 1, 1);
                    return;
                case 29:
                    dmB.addHit((am.monsterPro[6] * this.skill[skill_no][0]) + am.monsterPro[1], 1, 0);
                    amB.addHit(am.monsterPro[1], 4, 2);
                    return;
                default:
                    return;
            }
        }
        if (rand < this.hit_rate || (this.mini_state == 1 && am.monster[2] < 11)) {
            damage(amB, dmB, am, dm2, skill_no, this.mini_state ^ 1);
            if (skill_no == 26 && !dmB.getMon().isMonReel(40)) {
                Ms.i();
                if (Ms.getRandom(100) < this.skill[skill_no][2]) {
                    dmB.addHit((this.skill[skill_no][3] * dmB.getMon().monster[6]) / 100, -2, 2);
                    if (am.monster[3] != 2 && am.isMonReel(34)) {
                        dmB.addHit((dm2.monsterPro[3] * this.skill[34][0]) / 100, 4, 2);
                        return;
                    }
                    return;
                }
            }
            if (skill_no < 25 || skill_no == 30) {
                magicEffectRate(dmB, am, dm2, skill_no);
            }
            if (am.monster[3] != 2) {
                return;
            } else {
                return;
            }
        }
        dmB.addHit(0, -1, 2);
        amB.rate_off = (byte) 20;
    }

    private void runHit() {
        if (!this.am.b_renascence && !this.f133dm.b_renascence) {
            hit_rate(this.am, this.f133dm, this.am.getMon(), this.f133dm.getMon(), this.am.skill);
        } else {
            this.am.b_renascence = false;
            this.f133dm.b_renascence = false;
        }
        this.battle_state = (byte) -2;
    }

    private void getExpOne(boolean half) {
        this.exp = (short) 0;
        Ms.i();
        Ms.skip2 = this.enB.mon[0].monster[2];
        for (byte i = 0; i < this.enB.mon.length; i = (byte) (i + 1)) {
            this.exp = (short) (this.exp + (this.enB.mon[i].monster[2] * 3) + 80);
            byte b = this.enB.mon[i].monster[2];
            Ms.i();
            if (b > Ms.skip2) {
                Ms.i();
                Ms.skip2 = this.enB.mon[i].monster[2];
            }
        }
        this.exp = (short) ((this.exp * (((56 / this.mon_in_battle[0]) - ((this.mon_in_battle[0] - 1) * 2)) + 44)) / 100);
        if (!half) {
            this.exp = (short) (this.exp / 2);
        }
    }

    private void arangeMonster() {
        if (this.myMon_length > 1) {
            for (byte i = 0; i < this.myMon_length - 1; i = (byte) (i + 1)) {
                int i2 = i + 1;
                while (true) {
                    byte j = (byte) i2;
                    if (j >= this.myMon_length) {
                        break;
                    }
                    if (this.myMonsters[i].monster[1] > this.myMonsters[j].monster[1]) {
                        changeMonster(this.myMonsters[i], this.myMonsters[j]);
                    }
                    i2 = j + 1;
                }
            }
        }
    }

    private void goBattleItem() {
        this.battle_state = (byte) -4;
        this.cur_b = (byte) -1;
        StringBuffer sbuff = new StringBuffer();
        Ms.i();
        if (Ms.getRandom(100) < 50 && findItem(-2, 32, true) < 99) {
            addItem(32, 1);
            sbuff.append(Constants_H.MONEY_TXT_7 + getNameItem(32) + "x1");
        }
        setStringB(sbuff.toString(), Constants.PAYMENT_JIFENGQUAN_MAX, 0);
    }

    private void goBattleExp(boolean half) {
        this.battle_state = (byte) -5;
        this.cur_c = (byte) 0;
        this.b_c = (byte) 0;
        this.myB.now_id = this.myMonsters[this.myB.now_id].monster[1];
        this.proReplace[this.myB.now_id][2] = -2;
        arangeMonster();
        getExpOne(half);
    }

    private void goBattleOver() {
        run_state = -15;
        this.b_c = (byte) 0;
        this.myB.now_id = (byte) 0;
        this.mini_state = (byte) 3;
        this.view_state = (byte) 1;
        this.bg_c = this.myB.bg_id;
        this.mon[0].nullIMFA();
    }

    private void setNullBattle() {
        this.proReplace = null;
        this.effectImage = null;
        this.imgBattle = null;
        this.levelUp_in_battle = null;
        this.myB = null;
        this.enB = null;
    }

    public void goGameOver() {
        run_state = 60;
    }

    private void drawAnimationBattle(Battle amB, int mini_am) {
        if (amB.action == 0) {
            byte skill_type = (byte) (amB.skill / 5);
            byte skill_id = (byte) (amB.skill % 5);
            if (skill_type > 5) {
                skill_type = 5;
            }
            if (skill_type == 5) {
                skill_id = (byte) (amB.skill - 25);
            }
            if (drawMagicC(skill_type, skill_type, skill_id, getBXY(this.mini_state, amB.skill, true), getBXY(this.mini_state, amB.skill, false), this.mini_state ^ 1)) {
                if (this.mini_state == 1) {
                    short[] sArr = amB.getMon().monsterPro;
                    sArr[1] = (short) (sArr[1] - getSkillMana(amB.getMon(), amB.skill));
                    valueMend(amB.getMon());
                }
                runHit();
            }
        }
    }

    private boolean isSkillToMe(int skill) {
        return skill == 27 || skill == 28;
    }

    private int getBXY(int state, int skill, boolean bb) {
        int x = 266;
        int y = 236;
        if ((state == 1 && !isSkillToMe(skill)) || (state == 0 && isSkillToMe(skill))) {
            x = 377;
            y = 97;
        }
        return bb ? x : y;
    }

    private void drawDarkScreen() {
        drawColorLine(0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_, this.b_c + 1, 6, 1, 2, 16777215, 4802889);
    }

    private void drawColorLine(int x, int y, int width, int height, int line_height, int max_h, int speed, int dir, int bgColor, int lineColor) {
        if (((-16777216) & bgColor) != 0) {
            g.setColor(bgColor);
            g.fillRect(x, y, width, height);
        }
        g.setColor(lineColor);
        int grid = 1;
        if (dir == 1) {
            int over = y + height;
            while (y < over) {
                g.fillRect(x, y, width, line_height);
                y = y + line_height + grid;
                line_height -= speed;
                if (line_height <= 0) {
                    max_h--;
                    if (grid < max_h) {
                        grid++;
                    }
                    line_height = 1;
                }
            }
            return;
        }
        if (dir == 2) {
            int y2 = y + height;
            while (y2 > y) {
                g.fillRect(x, y2 - line_height, width, line_height);
                y2 = (y2 - line_height) - grid;
                line_height -= speed;
                if (line_height <= 0) {
                    max_h--;
                    if (grid < max_h) {
                        grid++;
                    }
                    line_height = 1;
                }
            }
        }
    }

    private void drawBattleBG() {
        Ui.i().fillRectB();
        Ui.i().drawImage(this.imgBG[this.enB.bg_id], Player.REALIZED, 20, 0);
        Ui i = Ui.i();
        Image image = this.imgBG[this.myB.bg_id];
        DirectGraphics directGraphics = dg;
        i.drawImage(image, Player.REALIZED, 144, 0, DirectGraphics.FLIP_HORIZONTAL);
        Ui.i().drawK2(2, 19, 195, 250, 0);
    }

    private void drawPlayer(Graphics g) {
        drawMyMon();
        drawMyMonState();
        drawEnemy();
        drawEnemyState();
    }

    private void paintBattleState(Graphics g) {
        switch (this.battle_state) {
            case -5:
                if (this.proReplace[this.myB.now_id][2] > -1) {
                    String s = String.valueOf(getNameMon(this.myMonsters[this.myB.now_id].monster[0])) + Constants_H.TXT_11;
                    Log.e("sk", "获得经验");
                    Ui.i().drawString(s, 204, 308, 36, 1, 0);
                    Ui.i().drawNum(new StringBuilder().append((int) this.proReplace[this.myB.now_id][2]).toString(), 220, 315, 0, 1);
                    return;
                }
                if (this.proReplace[this.myB.now_id][2] == -1) {
                    Ui.i().drawString(Constants_H.TXT_12, 204, 282, 36, 7, 0);
                    Ms.i().sleep(600);
                    return;
                }
                return;
            case -4:
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            default:
                return;
            case Constants.ERROR_UNKNOWN /* -3 */:
                if (drawHitOne(this.am, this.f133dm, getBXY(this.mini_state ^ 1, 25, true) - 15, getBXY(this.mini_state ^ 1, 25, false) - 34) && runHitToState(this.f133dm, this.am, this.mini_state ^ 1)) {
                    this.battle_state = (byte) 9;
                    effectR(this.f133dm.getMon());
                    return;
                }
                return;
            case Constants.ERROR_CODE_PARSER /* -2 */:
                if (drawHitOne(this.f133dm, this.am, getBXY(this.mini_state, this.am.skill, true) - 15, getBXY(this.mini_state, this.am.skill, false) - 34) && drawHitOne(this.am, this.f133dm, getBXY(this.mini_state ^ 1, 25, true) - 15, getBXY(this.mini_state ^ 1, 25, false) - 34) && runHitToState(this.am, this.f133dm, this.mini_state)) {
                    this.battle_state = (byte) -3;
                    this.am.initHit();
                    doEffectValue(this.am);
                    doBuffValue(this.am);
                    return;
                }
                return;
            case -1:
                drawAnimationBattle(this.am, this.mini_state);
                return;
            case 3:
                Ui.i().drawK0(Constants_H.WIDTH_H_ - 150, 50, Player.PREFETCHED, 193, 0);
                Ui.i().sliding(Constants_H.WIDTH_H_ + 125, 60, 173, this.select[0][0], this.skill_list[8], false);
                drawSkillList((Constants_H.WIDTH_H_ - 150) + 10, 60, 250, 28, 6, this.select[0]);
                showStringM(this.skill_help[this.skill_list[this.select[0][0]]].toString(), Constants_H.WIDTH_H_, 269, 7, 0);
                Ui.i().drawYesNo(true, true);
                return;
        }
    }

    private void doEffectValue(Battle be) {
        short hit = 0;
        if (be.getMon().isMonEffect(2)) {
            hit = (short) (be.getMon().monsterPro[0] / 10);
        } else if (be.getMon().isMonEffect(5)) {
            hit = (short) ((be.fs_level * be.fs_level) + 4);
        }
        if (be.getMon().isMonReel(3)) {
            hit = (short) (((this.inhesion[3] * hit) / 100) + hit);
        }
        if (hit != 0) {
            be.addHit(hit, 1, 0);
        }
    }

    private void doBuffValue(Battle be) {
        if (be.getMon().monsterPro[0] >= 1 && be.getMon().isBuffRate(4)) {
            be.addHit(((-be.getMon().monsterPro[2]) * this.inhesion[4]) / 100, 1, 1);
        }
    }

    private boolean changeMy() {
        for (byte i = 1; i < this.myMon_length; i = (byte) (i + 1)) {
            if (this.myMonsters[i].monsterPro[0] > 0) {
                setAimBattle(1);
                goVIEW_MONSTER();
                return true;
            }
        }
        return false;
    }

    private boolean isMyMonsters(int select_i) {
        for (byte i = 0; i < this.myMon_length; i = (byte) (i + 1)) {
            if (i != select_i && this.myMonsters[i].monsterPro[0] > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean changeMon(Battle be, int length) {
        byte d = 0;
        byte last_id = be.now_id;
        while (true) {
            byte b = (byte) (be.now_id + 1);
            be.now_id = b;
            if (b >= length) {
                be.now_id = (byte) 0;
            }
            d = (byte) (d + 1);
            if (d > length || (last_id != be.now_id && be.getMon().monsterPro[0] >= 1)) {
                break;
            }
        }
        if (d > length) {
            be.now_id = last_id;
        }
        return d <= length;
    }

    private void runBattleState() {
        this.myB.countS[0] = (byte) Ms.i().mathSpeedN(this.myB.countS[0], this.myB.countS[1], 1, false);
        this.enB.countS[0] = (byte) Ms.i().mathSpeedN(this.enB.countS[0], this.enB.countS[1], 1, false);
        switch (this.battle_state) {
            case -5:
                if (this.b_c == 0 && this.cur_c >= this.mon_in_battle[0]) {
                    goBattleOver();
                    setNidusExp(this.exp);
                    return;
                }
                byte id = this.mon_in_battle[this.cur_c + 1];
                if (this.b_c == 0) {
                    if (this.myMonsters[id].monsterPro[0] > 0) {
                        if (!this.myMonsters[id].isMonReel(40)) {
                            byte[] bArr = this.myMonsters[id].monster;
                            bArr[6] = (byte) (bArr[6] - 1);
                        }
                        this.myB.now_id = id;
                        this.myB.chp = this.myMonsters[id].monsterPro[0];
                        this.myB.cexp = this.myMonsters[id].monsterPro[4];
                        initMonStream(2, this.mList_id[this.myMonsters[id].monster[0]][0], 1);
                        if (level_up(id, 0)) {
                            this.b_c = (byte) 1;
                        }
                    } else {
                        this.cur_c = (byte) (this.cur_c + 1);
                    }
                } else if (this.b_c == 1) {
                    level_up(id, 1);
                    this.b_c = (byte) 2;
                } else if (this.b_c == 2 && this.myB.cexp == this.myMonsters[id].monsterPro[4]) {
                    if (level_up(id, 2)) {
                        this.b_c = (byte) 1;
                    } else {
                        this.b_c = (byte) 15;
                    }
                } else if (this.b_c > 2) {
                    if ((this.b_c < 21) & (this.myB.cexp == this.myMonsters[id].monsterPro[4])) {
                        byte b = (byte) (this.b_c - 1);
                        this.b_c = b;
                        if (b == 3) {
                            this.b_c = (byte) 0;
                            this.cur_c = (byte) (this.cur_c + 1);
                        }
                    }
                }
                this.myB.cexp = Ms.i().mathSpeedN(this.myB.cexp, this.myMonsters[id].monsterPro[4], 8, false);
                return;
            case -4:
                if (this.say_c == 0) {
                    byte b2 = (byte) (this.cur_b + 1);
                    this.cur_b = b2;
                    if (b2 >= this.about_a.length) {
                        this.about_a = null;
                        goBattleExp(true);
                        return;
                    } else {
                        Log.e("soars", this.about_a[this.cur_b].toString());
                        say(this.about_a[this.cur_b].toString(), 0);
                        return;
                    }
                }
                return;
            case Constants.ERROR_UNKNOWN /* -3 */:
            default:
                return;
            case 1:
                if (bufferAI(this.enB.getMon())) {
                    aiEnemy();
                    if (this.enB.getMon().effect != 6 || getSkillLevel(this.enB.skill) <= 3) {
                        setAcionSkill(this.enB);
                        return;
                    }
                    return;
                }
                this.enB.act_num = (byte) 0;
                this.battle_state = (byte) -2;
                return;
            case 9:
                if (this.myB.act_num == 0 && this.enB.act_num == 0) {
                    this.myB.act_num = (byte) 1;
                    this.enB.act_num = (byte) 1;
                    if (this.myB.getMon().isMonEffect(0)) {
                        this.myB.act_num = (byte) 0;
                        say(Constants_H.EFFECT_TXT_0, -1);
                    } else {
                        setAimBattle(1);
                        goBattleState();
                        String s = "";
                        if (this.myB.getMon().isMonEffect(2)) {
                            s = Constants_H.EFFECT_TXT_2;
                        } else if (this.myB.getMon().isMonEffect(3)) {
                            s = Constants_H.EFFECT_TXT_3;
                        } else if (this.myB.getMon().isMonEffect(4)) {
                            s = Constants_H.EFFECT_TXT_4;
                        } else if (this.myB.getMon().isMonEffect(5)) {
                            s = Constants_H.EFFECT_TXT_5;
                        }
                        if (!s.equals("")) {
                            say(s, 0);
                            return;
                        }
                        return;
                    }
                }
                if (this.myB.act_num != 0 && this.enB.act_num != 0) {
                    setAimBattle(this.myB.getMon().monsterPro[5] >= this.enB.getMon().monsterPro[5] ? 1 : 0);
                } else {
                    setAimBattle(this.myB.act_num != 0 ? 1 : 0);
                }
                if (this.mini_state == 1) {
                    this.myB.act_num = (byte) 0;
                    if (this.myB.getMon().monster[6] < 41) {
                        Ms.i();
                        if (Ms.getRandom(100) < 25) {
                            say(Constants_H.BATTLE_TXT_6, -1);
                            return;
                        }
                    }
                    if (this.myB.getMon().isMonEffect(0)) {
                        say(Constants_H.EFFECT_TXT_0, -1);
                        return;
                    } else {
                        setAcionSkill(this.myB);
                        return;
                    }
                }
                if (this.say_c == 0) {
                    this.enB.act_num = (byte) 0;
                    if (!this.enB.getMon().isMonEffect(0)) {
                        this.battle_state = (byte) 1;
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private boolean runHitToState(Battle amB, Battle dmB, int mState) {
        if (dmB.getMon().monsterPro[0] > 0) {
            return true;
        }
        if (dmB.dead == 1) {
            if (dmB.getMon().isMonReel(38)) {
                Ms.i();
                if (Ms.getRandom(100) < this.skill[38][1]) {
                    setRelive(amB, dmB);
                }
            }
            if (mState == 0) {
                this.enB.act_num = (byte) 1;
                if (changeMy()) {
                    return false;
                }
                if (this.overMode != 0) {
                    if (this.overMode == 2) {
                        this.map.sIfElse = (byte) 1;
                    }
                    this.overMode = (byte) 0;
                    arangeMonster();
                    setNullBattle();
                    goGO_RUNINMAP();
                    healMonster(false);
                    return false;
                }
                if (SMSSender.i(this).sms_a) {
                    System.out.println("aaaaaaaaaaaaa");
                    if (this.say_c == 0) {
                        this.isKillAll = true;
                        if (!isSay) {
                            say("携带的宠物全都牺牲了!", -1, 1);
                        }
                    }
                } else {
                    System.out.println("bbbbbbbbbb");
                    SMSSender.i(this).sms_a = true;
                    goGameOver();
                }
            } else if (mState == 1) {
                if (changeMon(this.enB, this.enB.mon.length)) {
                    setEnemyThrow();
                    this.enB.act_num = (byte) 0;
                    run_state = -50;
                    this.t_battle_state = this.battle_state;
                    this.battle_state = (byte) 0;
                } else {
                    goBattleItem();
                    if (this.overMode == 2) {
                        this.map.sIfElse = (byte) 0;
                    }
                    this.overMode = (byte) 0;
                }
            }
        } else if (dmB.action != 2) {
            dmB.action = (byte) 2;
            this.now_action[this.mini_state] = 0;
            this.now_time[this.mini_state] = 0;
            if (!dmB.getMon().isMonReel(40)) {
                byte[] bArr = dmB.getMon().monster;
                bArr[6] = (byte) (bArr[6] - 10);
            }
        }
        return false;
    }

    private void setRelive(Battle amB, Battle dmB) {
        dmB.initHit();
        dmB.addHit(((-dmB.getMon().monsterPro[2]) * this.skill[38][0]) / 100, 1, 1);
        dmB.skill = (byte) 28;
        dmB.dead = (byte) 0;
        dmB.action = (byte) 0;
        dmB.b_renascence = true;
        dmB.act_num = (byte) 0;
        this.battle_state = (byte) -1;
        setMagic(5);
        getHitCoefficient(dmB, dmB.getMon(), amB.getMon());
        setAimBattle(this.mini_state ^ 1);
    }

    private void setAcionSkill(Battle be) {
        be.action = (byte) 1;
        this.now_action[this.mini_state] = 0;
        this.now_time[this.mini_state] = 0;
        this.battle_state = (byte) -1;
        setMagic(be.skill / 5);
    }

    public void setMagic(int pro) {
        if (pro > 5) {
            pro = 5;
        }
        initMagicStream(pro);
        this.now_action_Magic[pro] = 0;
        this.now_time_Magic[pro] = 0;
    }

    private void keyBattleState() {
        if (!Ms.i().key_delay()) {
            switch (this.battle_state) {
                case 2:
                    if (Ms.i().key_Left_Right()) {
                        this.cur_a = Ms.i().select(this.cur_a, 0, this.action_str.length - 1);
                        return;
                    }
                    if (Ms.i().key_S1_Num5()) {
                        if (this.cur_a == 0) {
                            if (this.myB.getMon().monster[6] != 0) {
                                this.battle_state = (byte) 3;
                                while (this.skill_list[this.lastSkill] > 30) {
                                    this.lastSkill = (byte) (this.lastSkill + 1);
                                }
                                this.select[0][0] = this.lastSkill;
                                this.select[0][1] = (byte) (this.select[0][0] - 5);
                                if (this.select[0][1] < 1) {
                                    this.select[0][1] = 0;
                                    return;
                                }
                                return;
                            }
                            say(Constants_H.BATTLE_TXT_5, -1);
                            return;
                        }
                        if (this.cur_a == 1) {
                            if (this.myB.getMon().effect == 4) {
                                say("禁锢中无法使用道具！", -1);
                                return;
                            } else {
                                goMY_BAG(0);
                                return;
                            }
                        }
                        if (this.cur_a == 2) {
                            if (this.myB.getMon().effect == 4) {
                                say("禁锢中无法更换宠物！", -1);
                                return;
                            } else {
                                this.view_state = (byte) -2;
                                goVIEW_MONSTER();
                                return;
                            }
                        }
                        if (this.cur_a == 3) {
                            goBUY_ITEM(0, 0);
                            return;
                        }
                        if (this.cur_a == 4) {
                            if (this.battle_type == 4) {
                                short EscRate = (short) ((this.myB.getMon().monster[2] - this.enB.getMon().monster[2]) + 60);
                                byte succ = 0;
                                Ms.i();
                                if (Ms.getRandom(100) >= EscRate) {
                                    succ = 1;
                                }
                                if (this.myB.getMon().isMonReel(42)) {
                                    succ = 0;
                                } else if (this.myB.getMon().isEffect(3) || this.myB.getMon().isEffect(4)) {
                                    succ = 2;
                                }
                                if (succ == 0) {
                                    arangeMonster();
                                    setNullBattle();
                                    goGO_RUNINMAP();
                                    return;
                                } else {
                                    if (succ == 1) {
                                        say(Constants_H.TXT_35, 1);
                                        this.myB.act_num = (byte) 0;
                                        this.enB.act_num = (byte) 1;
                                        this.battle_state = (byte) 9;
                                        return;
                                    }
                                    say(Constants_H.TXT_36 + (this.myB.getMon().isEffect(4) ? Constants_H.TXT_37 : Constants_H.TXT_38) + Constants.TEXT_PAY_SMS_CONFIRM_INDEXOF + Constants_H.TXT_34, 1);
                                    return;
                                }
                            }
                            say(Constants_H.TXT_34, 0);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (Ms.i().key_Up_Down()) {
                        Ms.i().selectS(this.select[0], 0, this.skill_list[8], 6);
                        this.lastSkill = this.select[0][0];
                        return;
                    }
                    if (Ms.i().key_S1_Num5()) {
                        if (this.skill_list[this.select[0][0]] <= 30) {
                            if (this.myB.getMon().effect == 6 && getSkillLevel(this.skill_list[this.select[0][0]]) > 3) {
                                say(Constants_H.EFFECT_TXT_6, -1);
                                return;
                            } else if (this.myB.getMon().monsterPro[1] >= getSkillMana(this.myB.getMon(), this.skill_list[this.select[0][0]])) {
                                this.myB.skill = this.skill_list[this.select[0][0]];
                                this.battle_state = (byte) 9;
                                return;
                            } else {
                                say(Constants_H.BATTLE_TXT_10, -1);
                                return;
                            }
                        }
                        say(Constants_H.BATTLE_TXT_11, -1);
                        return;
                    }
                    if (Ms.i().key_S2()) {
                        this.battle_state = (byte) 2;
                        return;
                    }
                    return;
                case 4:
                    if (Ms.i().key_Up_Down()) {
                        Ms.i().selectS(this.select[0], 0, 6, this.skill_list[8]);
                        return;
                    } else {
                        if (!Ms.i().key_S1_Num5() && Ms.i().key_S2()) {
                            this.battle_state = (byte) 2;
                            return;
                        }
                        return;
                    }
                case 5:
                    if (Ms.i().key_Up_Down()) {
                        Ms.i().selectS(this.select[0], 0, 6, this.skill_list[8]);
                        return;
                    } else {
                        if (!Ms.i().key_S1_Num5() && Ms.i().key_S2()) {
                            this.battle_state = (byte) 2;
                            return;
                        }
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void drawBattleExp(Monster mon, int y) {
        Ui.i().drawK0(Player.REALIZED, y, 240, 10, 0);
        drawMonsterHp(mon, 240, y + 3, 195, 2, 2, this.battle_state != -5 ? mon.monsterPro[4] : this.myB.cexp);
        Ui.i().drawString(Constants_H.GAME_TXT_29, Player.REALIZED, y + 18, 36, 0, 2);
    }

    private void drawSelectMenu(Graphics g, boolean bb, int y) {
        Ui.i().drawK2(Player.REALIZED, y + 15, 240, (Constants_H.HEIGHT_ - y) - 20, 0);
        drawBattleExp(this.myB.getMon(), y + 3);
        if (!bb) {
            Ui.i().drawString(Constants_H.BATTLE_TXT_16, 450, 10, 0, 0, 2);
            for (byte i = 0; i < this.imgBattle.length; i = (byte) (i + 1)) {
                Ui.i().drawImage(this.imgBattle[i], this.pkey.button_pos[5][i][0], this.pkey.button_pos[5][i][1], 0);
            }
        }
    }

    private void drawEnemy() {
        drawEffectImage(this.enB.getMon(), 435, 40);
        if (this.enB.getMon().monsterPro[0] >= 1 || this.enB.dead != 1) {
            if (drawCartoonOne(0, 0, (this.mList_id[this.enB.getMon().monster[0]][1] * 3) + this.enB.action, (this.enB.ceff[0] != 0 ? 3 : 0) + 377, (this.enB.ceff[0] != 0 ? -3 : 0) + 97, this.enB.action == 0, 0)) {
                if (this.enB.getMon().monsterPro[0] < 1) {
                    this.enB.action = (byte) 2;
                    this.enB.dead = (byte) 1;
                } else if (this.enB.dead != 1) {
                    this.enB.action = (byte) 0;
                }
            }
            this.enB.ceff[0] = (byte) Ms.i().mathSpeedN(this.enB.ceff[0], 0, 1, true);
            drawMonsterHp(this.enB.getMon(), 352, 97, 50, 0, 1, this.enB.chp);
            this.enB.chp = Ms.i().mathSpeedN(this.enB.chp, this.enB.getMon().monsterPro[0], this.enB.chp < this.enB.getMon().monsterPro[0] ? 20 : 6, true);
        }
    }

    public void drawMyMon() {
        drawEffectImage(this.myB.getMon(), 220, 164);
        if (drawCartoonOne(1, 1, (this.mList_id[this.myB.getMon().monster[0]][1] * 3) + this.myB.action, (this.myB.ceff[0] != 0 ? -3 : 0) + 266, (this.myB.ceff[0] != 0 ? 3 : 0) + 236, this.myB.action == 0, 1)) {
            if (this.myB.getMon().monsterPro[0] < 1) {
                this.myB.action = (byte) 2;
                this.myB.dead = (byte) 1;
            } else {
                this.myB.action = (byte) 0;
            }
        }
        this.myB.ceff[0] = (byte) Ms.i().mathSpeedN(this.myB.ceff[0], 0, 1, true);
        drawMonsterHp(this.myB.getMon(), 241, 237, 50, 0, 1, this.myB.chp);
        drawMonsterHp(this.myB.getMon(), 241, 242, 50, 1, 2, this.myB.getMon().monsterPro[1]);
        this.myB.chp = Ms.i().mathSpeedN(this.myB.chp, this.myB.getMon().monsterPro[0], this.myB.chp < this.myB.getMon().monsterPro[0] ? 20 : 6, true);
    }

    private void drawEnemyState() {
        Ui.i().drawK(10, 25, 179, 110, 2);
        Ui.i().drawKuang(10 + 2, 25 + 2, 147, 33);
        if (this.enB.getMon().monster[3] != -1) {
            Ui.i().drawUi(this.enB.getMon().monster[3] + 5, 10 + 16, 25 + 16, 3, 0);
        }
        Ui.i().drawString(getNameMon(this.enB.getMon().monster[0]).toString(), 10 + 75 + 14, 25 + 1, 17, 4, 2);
        Ui.i().drawNum(String.valueOf((int) this.enB.getMon().monster[2]) + Constants_H.TXT_9, 10 + 125 + 27, 25 + 20, 0, 0);
        Ui.i().drawK0(10 + 2, 25 + 25 + 11, 62, 14, 4);
        Ui.i().drawUi(34, 10 + 4, 25 + 25 + 12, 0, 0);
        Ui.i().drawNum(String.valueOf(this.enB.countS[0] + 100) + "%", 10 + 60, 25 + 25 + 24, 1, 1);
        Ui.i().drawString(Constants_H.GAME_TXT_30, 10 + 2, 25 + 25 + 30, 20, 4, 2);
        drawMonKind(this.enB.getMon().monster[4], 10 + 100 + 8, 25 + 25 + 38, 0);
        Ui.i().drawString(this.monInfoList[this.enB.getMon().monster[0]] == 2 ? Constants_H.TXT_26 : Constants_H.TXT_27, 10 + 2, 25 + 50 + 32, 20, 4, 2);
        Ui.i().drawUi(this.monInfoList[this.enB.getMon().monster[0]] == 2 ? 25 : 26, 10 + 100 + 4, 25 + 50 + 40, 0, 0);
    }

    private void drawMyMonState() {
        Ui.i().drawK(10, 140, 179, 110, 2);
        Ui.i().drawKuang(10 + 2, 140 + 2, 147, 33);
        Ui.i().drawUi(this.myB.getMon().monster[3] + 5, 10 + 16, 140 + 16, 3, 0);
        Ui.i().drawString(getNameMon(this.myB.getMon().monster[0]).toString(), 10 + 75 + 14, 140 + 1, 17, 4, 2);
        Ui.i().drawNum(String.valueOf((int) this.myB.getMon().monster[2]) + Constants_H.TXT_9, 10 + 125 + 27, 140 + 20, 0, 0);
        Ui.i().drawK0(10 + 2, 140 + 25 + 11, 62, 14, 4);
        Ui.i().drawUi(34, 10 + 4, 140 + 25 + 12, 0, 0);
        Ui.i().drawNum(String.valueOf(this.myB.countS[0] + 100) + "%", 10 + 60, 140 + 25 + 24, 1, 1);
        Ui.i().drawString(Constants_H.GAME_TXT_30, 10 + 2, 140 + 25 + 30, 20, 4, 2);
        drawMonKind(this.myB.getMon().monster[4], 10 + 100 + 8, 140 + 25 + 38, 0);
        Ui.i().drawString(Constants_H.GAME_TXT_31, 10 + 2, 140 + 50 + 32, 20, 4, 2);
        drawMonsterFealty(this.myB.getMon(), 10 + 100 + 4, 140 + 50 + 42);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
    
        dm.Ui.i().drawFrameOne(r7.magic[r9], r2, r11, r12, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return setCartoonFrameMagic_C(r8, r9, r10, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean drawMagicC(int r8, int r9, int r10, int r11, int r12, int r13) {
        /*
            r7 = this;
            r4 = 2
            r6 = 1
            r3 = 0
            short[] r0 = r7.now_action_Magic
            short r0 = r0[r8]
            dm.Sprite[] r1 = r7.magic
            r1 = r1[r9]
            int r1 = r1.aLength(r10)
            if (r0 < r1) goto L17
            short[] r0 = r7.now_action_Magic
            r0[r8] = r3
            r0 = r6
        L16:
            return r0
        L17:
            dm.Sprite[] r0 = r7.magic
            r0 = r0[r9]
            short[] r1 = r7.now_action_Magic
            short r1 = r1[r8]
            int r0 = r0.action(r10, r1, r3)
            short r2 = (short) r0
        L24:
            dm.Battle r0 = r7.f133dm
            if (r0 == 0) goto L2a
            if (r2 < r4) goto L3d
        L2a:
            dm.Ui r0 = dm.Ui.i()
            dm.Sprite[] r1 = r7.magic
            r1 = r1[r9]
            r3 = r11
            r4 = r12
            r5 = r13
            r0.drawFrameOne(r1, r2, r3, r4, r5)
            boolean r0 = r7.setCartoonFrameMagic_C(r8, r9, r10, r6)
            goto L16
        L3d:
            if (r2 != 0) goto L45
            dm.Battle r0 = r7.f133dm
            byte[] r0 = r0.ceff
            r0[r3] = r4
        L45:
            short[] r0 = r7.now_time_Magic
            r0[r8] = r3
            short[] r0 = r7.now_action_Magic
            short r1 = r0[r8]
            int r1 = r1 + 1
            short r1 = (short) r1
            r0[r8] = r1
            dm.Sprite[] r0 = r7.magic
            r0 = r0[r9]
            int r0 = r0.aLength(r10)
            if (r1 < r0) goto L62
            short[] r0 = r7.now_action_Magic
            r0[r8] = r3
            r0 = r6
            goto L16
        L62:
            dm.Sprite[] r0 = r7.magic
            r0 = r0[r9]
            short[] r1 = r7.now_action_Magic
            short r1 = r1[r8]
            int r0 = r0.action(r10, r1, r3)
            short r2 = (short) r0
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: main.GameRun.drawMagicC(int, int, int, int, int, int):boolean");
    }

    private boolean setCartoonFrameMagic_C(int i, int skill_mode, int select, boolean mode) {
        short[] sArr = this.now_time_Magic;
        short s = (short) (sArr[i] + 1);
        sArr[i] = s;
        if (s >= this.magic[skill_mode].action(select, this.now_action_Magic[i], 1)) {
            short[] sArr2 = this.now_action_Magic;
            sArr2[i] = (short) (sArr2[i] + 1);
            this.now_time_Magic[i] = 0;
            if (!mode && this.now_action_Magic[i] >= this.magic[skill_mode].aLength(select)) {
                short[] sArr3 = this.now_action_Magic;
                sArr3[i] = (short) (sArr3[i] - 1);
                return true;
            }
        }
        return false;
    }

    public boolean drawCartoonOne(int i, int skill_mode, int select, int x, int y, boolean mode, int dir) {
        if (this.now_action[i] >= this.mon[skill_mode].aLength(select)) {
            this.now_action[i] = 0;
        }
        Ui.i().drawFrameOne(this.mon[skill_mode], this.mon[skill_mode].action(select, this.now_action[i], 0), x, y, dir);
        return setCartoonFrame_C(i, skill_mode, select, mode);
    }

    private boolean setCartoonFrame_C(int i, int skill_mode, int select, boolean mode) {
        byte[] bArr = this.now_time;
        byte b = (byte) (bArr[i] + 1);
        bArr[i] = b;
        if (b >= this.mon[skill_mode].action(select, this.now_action[i], 1)) {
            byte[] bArr2 = this.now_action;
            bArr2[i] = (byte) (bArr2[i] + 1);
            this.now_time[i] = 0;
            if (!mode && this.now_action[i] >= this.mon[skill_mode].aLength(select)) {
                byte[] bArr3 = this.now_action;
                bArr3[i] = (byte) (bArr3[i] - 1);
                return true;
            }
        }
        return false;
    }

    public void initSkillList(Monster mon) {
        this.skill_list[8] = 0;
        for (byte i = 7; i > -1; i = (byte) (i - 1)) {
            this.skill_list[i] = mon.monster[i + 8];
            if (this.skill_list[i] != -1) {
                byte[] bArr = this.skill_list;
                bArr[8] = (byte) (bArr[8] + 1);
            }
        }
        for (byte i2 = 1; i2 < 8; i2 = (byte) (i2 + 1)) {
            for (byte j = i2; j > 0 && this.skill_list[j] > this.skill_list[j - 1]; j = (byte) (j - 1)) {
                byte temp = this.skill_list[j];
                this.skill_list[j] = this.skill_list[j - 1];
                this.skill_list[j - 1] = temp;
            }
        }
    }

    private void initMagicStream(int i) {
        if (this.magic[i] == null) {
            String s = "data/battle/s" + i;
            this.magic[i] = Ms.i().createSprite(s, false);
        }
    }

    public void initMonStream(int type, int id, int i) {
        String name = "data/npc" + type + "/" + id;
        boolean bb = type == 2 ? isNpc2ImageType(id) : true;
        if (this.mon[i] != null) {
            Ms.i().setSprite(this.mon[i], name, bb);
        } else {
            this.mon[i] = Ms.i().createSprite(name, bb);
        }
    }

    public void goBattlePVC() {
        this.enemyList = null;
        this.enemyList = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 1, 2);
        getEnemy(this.enemyList[0], -1, 0);
        Sound.i().setMusicId(6);
        Sound.i().setMusic(true);
        goBattle();
    }

    private void goBattleState() {
        setAction_str(new String[]{Constants_H.BATTLE_TXT_0, "道具", Constants_H.BATTLE_TXT_2, Constants_H.BATTLE_TXT_3, Constants_H.BATTLE_TXT_4});
        run_state = -31;
        this.battle_state = this.mini_state == 1 ? (byte) 2 : (byte) 1;
    }

    private void goSelectAction(int mini) {
        run_state = -31;
        this.battle_state = mini == 1 ? (byte) 2 : (byte) 1;
        setAimBattle(mini);
        if (mini == 1) {
            initSkillList(this.myB.getMon());
        }
        getHitCoefficient(this.myB, this.myB.getMon(), this.enB.getMon());
        getHitCoefficient(this.enB, this.enB.getMon(), this.myB.getMon());
    }

    public void battleType(int mode) {
        this.battle_type = (byte) mode;
    }

    private void enemy_init() {
        Monster[] eMonsters = new Monster[this.enemyList.length];
        for (int i = 0; i < this.enemyList.length; i++) {
            eMonsters[i] = new Monster(this, this.enemyList[i][0], this.enemyList[i][1], this.myMonsters[0].isMonReel(39) ? 1 : 0);
            if (this.battle_type == 3 || this.battle_type == 0) {
                if (eMonsters[i].monster[3] == -1) {
                    eMonsters[i].resetBoss(this.enemyList[i][4]);
                } else {
                    eMonsters[i].resetMonster(this.enemyList[i][2], this.enemyList[i][3], this.enemyList[i][4]);
                }
                eMonsters[i].resetPro(this);
            } else {
                eMonsters[i].resetMonster(this, -1);
            }
        }
        this.enemyList = null;
        this.enB = new Battle(eMonsters);
    }

    public void initMonPro(int no, boolean mode) {
        Ms.i();
        Ms.skip = 0;
        byte[] data = Ms.i().getStream("data/map/" + (mode ? "m" : "boss") + no + ".d", -1);
        this.monPro = Ms.i().createArray(data);
        this.mapMove = Ms.i().createArray(data);
        this.mapRect = Ms.i().create2Array(data);
    }

    public void getEnemy(byte[] enemy_list, int i, int level) {
        if (i == -1) {
            Ms.i();
            if (Ms.getRandom(100) >= 5 || this.monPro.length <= 6) {
                byte[] bArr = this.monPro;
                Ms.i();
                i = bArr[Ms.getRandom(this.monPro.length > 6 ? 3 : this.monPro.length - 3) + 3];
            } else {
                i = 6;
            }
            Ms.i();
            enemy_list[1] = (byte) (Ms.getRandom(this.monPro[2] + 1) + this.monPro[1]);
        } else {
            enemy_list[1] = (byte) level;
        }
        enemy_list[0] = (byte) i;
    }

    public void setAimBattle(int state) {
        this.mini_state = (byte) state;
        this.am = this.mini_state == 1 ? this.myB : this.enB;
        this.f133dm = this.mini_state == 1 ? this.enB : this.myB;
    }

    public void goBattle() {
        this.first_battle = (byte) 0;
        this.lastSkill = (byte) 0;
        this.b_c = (byte) 0;
        this.cur_a = (byte) 0;
        this.mon_in_battle = null;
        this.mon_in_battle = new byte[this.max_takes + 1];
        this.levelUp_in_battle = null;
        this.levelUp_in_battle = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.max_takes, 2);
        this.proReplace = null;
        this.proReplace = (short[][]) Array.newInstance((Class<?>) Short.TYPE, this.myMonsters.length, 7);
        this.myB = new Battle(this.myMonsters);
        enemy_init();
        for (byte i = 0; i < this.myMon_length; i = (byte) (i + 1)) {
            this.myMonsters[i].effect = (byte) 7;
            this.myMonsters[i].effect_time = (byte) 0;
            this.myMonsters[i].monster[1] = i;
            this.proReplace[i][6] = this.myMonsters[i].monster[2];
        }
        byte i2 = 0;
        while (true) {
            if (i2 >= this.myMon_length) {
                break;
            }
            if (this.myMonsters[i2].monsterPro[0] <= 0) {
                i2 = (byte) (i2 + 1);
            } else {
                byte[] bArr = this.mon_in_battle;
                byte[] bArr2 = this.mon_in_battle;
                byte b = (byte) (bArr2[0] + 1);
                bArr2[0] = b;
                bArr[b] = this.myMonsters[i2].monster[1];
                if (i2 != 0) {
                    changeMonster(this.myMonsters[i2], this.myMonsters[0]);
                }
            }
        }
        if (this.effectImage == null) {
            this.effectImage = Ms.i().createImageArray(7, "data/brow/e");
        }
        if (this.imgBattle == null) {
            this.imgBattle = Ms.i().createImageArray(5, "data/battle/b");
        }
        this.map.my.state = (byte) 15;
        run_state = -30;
        this.view_state = (byte) -1;
        new CreateThread(this, 1);
    }

    public void initBattle() {
        System.gc();
        byte[] bArr = this.src_c;
        byte[] bArr2 = this.src_c;
        byte[] bArr3 = this.src_c;
        this.src_c[3] = 0;
        bArr3[2] = 0;
        bArr2[1] = 0;
        bArr[0] = 0;
        getBattleBG(this.enB, this.enB.getMon());
        getBattleBG(this.myB, this.myB.getMon());
        setEnemyThrow();
        setMyThrow();
    }

    private void getBattleBG(Battle be, Monster mon) {
        if (this.monPro.length != 0) {
            be.bg_id = this.monPro[0];
        }
        for (byte i = 0; i < 5; i = (byte) (i + 1)) {
            if (mon.isMonReel(i + Constants_H.f89)) {
                be.bg_id = i;
                return;
            }
        }
    }

    private boolean bufferAI(Monster mon) {
        return !mon.isMonEffect(0);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:39:0x00c4. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void aiEnemy() {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: main.GameRun.aiEnemy():void");
    }

    private boolean isMonHp(Monster mon, int percent) {
        return mon.monsterPro[0] < (mon.monster[2] * percent) / 100;
    }

    private void getSkill(int skill_level, int pro) {
        this.getSkill = skill_level == 0 ? (byte) 25 : this.skill_up[skill_level - 1][pro];
    }

    private int getSkillLevel(int skill) {
        if (skill == 25) {
            return 0;
        }
        return skill < 25 ? (skill % 5) + 1 : this.makeLevel[(skill - 25) - 1];
    }

    private int getSkillMana(Monster mon, int sl) {
        byte vaule = this.skill[sl][1];
        return (mon.monster[3] == 4 && mon.isMonReel(35)) ? (this.skill[sl][0] * vaule) / 100 : vaule;
    }

    public void getMagic(Monster monster) {
        byte[] level = {0, 7, 14, 21, 28, 35};
        this.getSkill = (byte) -1;
        for (byte i = 0; i < level.length; i = (byte) (i + 1)) {
            if (monster.monster[i + 8] == -1 && monster.monster[2] >= level[i]) {
                getSkill(i, monster.monster[3]);
                monster.monster[i + 8] = this.getSkill;
            }
        }
    }

    public void drawChangeMap(boolean bb, int t_c, int x, int y, int w) {
        int t_c2 = t_c * 2;
        if (bb) {
            Ui.i().fillRect(5422575, 0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_);
        }
        g.setColor(0);
        g.fillRect(x, y + 1, w, 5);
        g.fillRect(x + 1, y, w - 2, 7);
        g.setColor(15400191);
        if (((w - 4) * t_c2) / 60 > w) {
            g.fillRect(x + 2, y + 1, w, 5);
            g.fillRect(x + 1, y + 2, w, 3);
        } else {
            g.fillRect(x + 2, y + 1, ((w - 4) * t_c2) / 60, 5);
            g.fillRect(x + 1, y + 2, ((w - 2) * t_c2) / 60, 3);
        }
        if (bb && Map.npcSp[1][0].img != null) {
            if (((w - 4) * t_c2) / 60 > w) {
                this.map.drawMyAni(this.map.my, 0, w, y + 10, 5);
            } else {
                this.map.drawMyAni(this.map.my, 0, x + (((w - 4) * t_c2) / 60), y + 10, 5);
            }
        }
    }

    public void initImgIco() {
        if (this.imgIco == null) {
            this.imgIco = Ms.i().createImageArray_(7, "data/brow/i", 1);
        }
    }

    public void drawPauseIco(int state) {
        for (byte i = 0; i < this.b_ico; i = (byte) (i + 1)) {
            Ui.i().drawImage(this.imgIco[i], this.pkey.button_pos[6][i][0], this.pkey.button_pos[6][i][1], 0);
        }
    }

    public boolean runPauseIco() {
        for (byte i = 0; i < this.b_ico; i = (byte) (i + 1)) {
            if (this.map.my.state == 0 && this.pkey.isSelect(this.pkey.button_pos[10][i][0], this.pkey.button_pos[10][i][1], this.pkey.button_pos[10][i][2], this.pkey.button_pos[10][i][3])) {
                if (this.b_ico == 2) {
                    this.isTalk = false;
                    this.pkey.setKey5();
                }
                this.pkey.initPointer();
                if (i == 0) {
                    this.b_ico = (byte) (this.b_ico == 2 ? 7 : 2);
                } else if (run_state != 98) {
                    if (i == 3) {
                        goYouPAUSE(0);
                    } else if (i == 6) {
                        SMSSender.i(this).go(0, true);
                    } else {
                        if (i == 2) {
                            Ms.key = 48;
                        } else if (i == 4) {
                            Ms.key = 49;
                        } else if (i == 5) {
                            Ms.key = 51;
                        } else if (i == 1) {
                            Ms.key = 57;
                        }
                        Ms.keyRepeat = true;
                    }
                    this.b_ico = (byte) 2;
                }
                return true;
            }
        }
        return false;
    }

    public boolean checkMonster() {
        for (byte i = 0; i < this.myMon_length; i = (byte) (i + 1)) {
            if (this.myMonsters[i].monsterPro[1] < this.myMonsters[i].monsterPro[3] || this.myMonsters[i].monsterPro[0] < this.myMonsters[i].monsterPro[2]) {
                return false;
            }
        }
        say("您的宠物不需要回复！", 0);
        return true;
    }

    public boolean gameCheckRegIsOK() {
        boolean reged = this.rmsSms[6] == 10;
        System.out.println("gameCheckRegIsOK reged= " + reged);
        return reged;
    }

    public void skyCheckRegFull(int where) {
        switch (where) {
            case 1:
                this.map.setRegState(true);
                mc.skyNewGame();
                return;
            case 2:
                this.map.setRegState(true);
                mc.skyContinueGame();
                return;
            default:
                return;
        }
    }

    public synchronized void Success() {
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
            } else {
                SMSSender.i(this).sendSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void falselly(int id) {
        SMSSender.i(this).setSendSms(-1);
        try {
            if (id == 7) {
                SMSSender.i(this).sms_a = true;
                goGameOver();
                System.out.println("ccccccccc");
                mc.setSmsIsSetRun_state(true);
            } else if (id == 5) {
                run_state = SMSSender.i(this).getTstate();
                mc.temp_state = run_state;
                mc.setSmsIsSetRun_state(true);
            } else if (id == 6) {
                run_state = -10;
                mc.temp_state = run_state;
                mc.setSmsIsSetRun_state(true);
                System.out.println("  我的mc.setSmsIsSetRun_state(true);");
                this.map.setRegState(false);
            } else if (id == 1) {
                if (SMSSender.i(this).getSmsSenderMenuState() != 0) {
                    Log.d("soars", "soooooooooooooooooooooooooooooooooooooooo");
                    mc.setSmsIsSetRun_state(true);
                    run_state = SMSSender.i(this).getTstate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
