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
        byte[] var5 = new byte[]{0, 2, 4, 5};
        byte[] var4 = new byte[]{6};
        byte[] var2 = new byte[]{8};
        byte[] var3 = new byte[]{2};
        this.menu = new byte[][]{var5, var4, {7}, var2, var3};
        this.sel = new byte[2];
        var3 = new byte[]{4, 1, 3};
        var2 = new byte[]{1, 1, 0};
        this.smsCount = new byte[][]{{4, 1, 1}, {2, 1, 2}, var3, {1, 1, 4}, {2, 1, 5}, var2, {2, 1, 6}, {2, 1, 5}};
        this.sendSms = -1;
        gr = var1;
        smsSender = this;

        try {
            this.createSMS();
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    private void createSMS() {
        this.menuTxt = new String[][]{{"商城"}, {"购买30000金", ""}, {"购买5000金", "身为四大家族之首的贵公子，没钱可不行！立刻拥有5000金。"}, {"购买50徽章", ""}, {"购买10徽章", "购买该特殊道具，立刻拥有10徽章，能购买双倍经验，宠物技能，强大的宠物捕获球等各种神奇的道具。"}, {"宠物升5级", "让您随身携带的全部宠物立刻升5级（超过70级宠物不能再升级）"}, {"购买奇异兽", "购买该特殊道具，获得可爱的奇异兽，移动速度可以提高一倍，且不会遇到任何敌人！无限使用，心动不如行动，快购买吧！"}, {"正版验证", "游戏试玩结束，购买此项将开启后续所有游戏内容、地图。同时将免费赠送您5枚徽章（可购买强力道具）"}, {"升级复活", "让您携带的所有宠物全恢复，同时立刻让您携带的宠物提升5级（超过70级宠物不能再升级），让接下来的战斗变的更轻松。"}};
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
                                var9 = "购买已成功！";
                                var5 = false;
                                var4 = false;
                                var2 = var4;
                                var3 = var5;
                                var8 = var9;
                                if (this.sendSms > 23) {
                                    var2 = var4;
                                    var3 = var5;
                                    var8 = var9;
                                    if (this.sendSms < 34) {
                                        ++this.sendSms;
                                        var2 = var4;
                                        var3 = var5;
                                        var8 = var9;
                                    }
                                }
                            } else if (this.sendSms == 15) {
                                var8 = "自动保存游戏。";
                                var3 = false;
                                var2 = false;
                            } else {
                                var2 = var6;
                                var3 = var7;
                                var8 = var9;
                                if (this.sendSms < 23) {
                                    var9 = "保存游戏成功。";
                                    ++this.sendSms;
                                    var5 = false;
                                    var4 = false;
                                    if (smsType == 5 && this.sendSms == 23) {
                                        gr.say("购买已成功！游戏已保存。#n新游戏后此功能不再要求付费。", -1);
                                        var2 = var4;
                                        var3 = var5;
                                        var8 = var9;
                                    } else {
                                        var2 = var4;
                                        var3 = var5;
                                        var8 = var9;
                                        if (smsType == 6) {
                                            var2 = var4;
                                            var3 = var5;
                                            var8 = var9;
                                            if (this.sendSms == 23) {
                                                gr.say("购买已成功！获得5枚徽章(背包的卷轴界面可查看）。游戏已保存。#n新游戏后此功能不再要求付费。", 0);
                                                var2 = var4;
                                                var3 = var5;
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
        return "" + "您已发送" + var1 + "条短信。" + "购买此项，还需发送" + var2 + "条短信。" + "确认发送短信吗？";
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
                    Ui var7 = Ui.i();
                    String var8 = this.menuTxt[this.menu[this.menu_state][var1]][0];
                    byte var6 = this.sel[1];
                    byte var9;
                    if (this.sel[0] == var1) {
                        var9 = 0;
                    } else {
                        var9 = 3;
                    }

                    var7.drawString(var8, var3 + 314, (var1 - var6) * 28 + 32, 17, var9, 0);
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
                gr.say("目前没有可以升级的宠物！", 0);
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
                gr.setStringB("生命;+" + gr.proReplace[this.idSmsLevel][0] + "#n" + "能量" + ";+" + gr.proReplace[this.idSmsLevel][1], Constants_H.WIDTH, 0);
                gr.setStringB("力量;+" + gr.proReplace[this.idSmsLevel][3] + "#n" + "防御" + ";+" + gr.proReplace[this.idSmsLevel][4] + "#n" + "敏捷" + ";+" + gr.proReplace[this.idSmsLevel][5], Constants_H.WIDTH, 1);
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
                gr.say("购买5000金币", -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            case 2:
                var4 = gr;
                var4.coin += 50;
                gr.say("在卷轴商店中才能看到徽章数量", -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            case 3:
                var4 = gr;
                var4.coin += 10;
                gr.say("在卷轴商店中才能看到徽章数量", -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            case 4:
                this.tState = -1;
                gr.say("携带的宠物全部升5级,宠物页面查看新属性", 0, -1);
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
                gr.say("购买后此功能不再要求付费", 0, -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            case 6:
                gr.rmsSms[this.smsCount[smsType][2]] = 10;
                var4 = gr;
                var4.coin += 5;
                this.sms_b = true;
                gr.say("购买后此功能不再要求付费", 0, -1);
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
