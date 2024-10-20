package main;

import android.util.Log;
import com.PetKing5_480x800.PetKing5;
import dm.Monster;
import dm.Ms;
import dm.Sound;
import dm.Ui;

public class SMSSender implements Key_H {
    private StringBuffer[] about;
    private byte currentPage;
    public static GameRun gr;
    public byte idSmsLevel;
    public static boolean isWorking;
    public byte[][] menu;
    private String[][] menuTxt;
    public byte menu_state;
    public static PetKing5 pk;
    public PointerKey pkey;
    public byte[] sel;
    public byte sendSms;
    public byte showLine;
    public byte[][] smsCount;
    public static SMSSender smsSender;
    public static byte smsType;
    public boolean sms_a;
    public boolean sms_b;
    public byte tMyState;
    private int tState;
    private byte totalPage;

    public SMSSender(GameRun gr_) {
        this.sms_a = true;
        this.sms_b = false;
        this.menu = new byte[][]{new byte[]{0, 2, 4, 5}, new byte[]{6}, new byte[]{7}, new byte[]{8}, new byte[]{2}};
        this.sel = new byte[2];
        this.smsCount = new byte[][]{new byte[]{4, 1, 1}, new byte[]{2, 1, 2}, new byte[]{4, 1, 3}, new byte[]{1, 1, 4}, new byte[]{2, 1, 5}, new byte[]{1, 1, 0}, new byte[]{2, 1, 6}, new byte[]{2, 1, 5}};
        this.sendSms = -1;
        SMSSender.gr = gr_;
        SMSSender.smsSender = this;
        try {
            this.createSMS();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void createSMS() {
        this.menuTxt = new String[][]{new String[]{"商城"}, new String[]{"购买30000金", ""}, new String[]{"购买5000金", "身为四大家族之首的贵公子，没钱可不行！立刻拥有5000金。"}, new String[]{"购买50徽章", ""}, new String[]{"购买10徽章", "购买该特殊道具，立刻拥有10徽章，能购买双倍经验，宠物技能，强大的宠物捕获球等各种神奇的道具。"}, new String[]{"宠物升5级", "让您随身携带的全部宠物立刻升5级（超过70级宠物不能再升级）"}, new String[]{"购买奇异兽", "购买该特殊道具，获得可爱的奇异兽，移动速度可以提高一倍，且不会遇到任何敌人！无限使用，心动不如行动，快购买吧！"}, new String[]{"正版验证", "游戏试玩结束，购买此项将开启后续所有游戏内容、地图。同时将免费赠送您5枚徽章（可购买强力道具）"}, new String[]{"升级复活", "让您携带的所有宠物全恢复，同时立刻让您携带的宠物提升5级（超过70级宠物不能再升级），让接下来的战斗变的更轻松。"}};
    }

    public void draw() {
        if(this.menu_state == 0) {
            Ui.i().fillRectB();
            Ui.i().drawK2(1, 1, 638, 359, 0);
            Ui.i().drawK1(0xF5, 4, 150, 24, 4);
            Ui.i().drawString(this.menuTxt[this.menu[this.menu_state][0]][0], 320, 2, 17, 0, 1);
            Log.e("sk", "draw");
            int y = 30;
            if(this.menu[this.menu_state].length > 1) {
                Ui.i().drawK1(6, 30, 613, 28 * this.showLine, 1);
                Ui.i().sliding(621, 30, 28 * this.showLine, this.sel[0] - 1, this.menu[this.menu_state].length - 1, true);
                Ui.i().drawListKY(((int)this.showLine), 6, 0x20, 613, 2, 28, -1, this.sel[0] - this.sel[1], 4, 2);
                for(int i = this.sel[1]; i < this.sel[1] + this.showLine && i < this.menu[this.menu_state].length; ++i) {
                    Ui.i().drawString(this.menuTxt[this.menu[this.menu_state][i]][0], 320, (i - this.sel[1]) * 28 + 0x20, 17, (this.sel[0] == i ? 0 : 3), 0);
                    if(this.pkey.isSelect(6, (i - this.sel[1]) * 28 + 0x20, 640, 28)) {
                        this.sel[0] = (byte)i;
                        this.setSmsType();
                    }
                }
                y = this.showLine * 28 + 35;
            }
            Ui.i().drawK1(6, y, 628, 349 - y, 2);
            this.draw0();
        }
    }

    private void draw0() {
        String smsTip = "";
        boolean bLeft = true;
        boolean bRight = true;
        if(this.sendSms > -1) {
            if(this.sendSms == 0) {
                int i = this.smsCount[SMSSender.smsType][2];
                int i = i < 0 ? 0 : SMSSender.gr.rmsSms[i];
                smsTip = this.getSmsTip(i, this.smsCount[SMSSender.smsType][1] - i);
            }
            else if(this.sendSms != 1 && this.sendSms != 2 && this.sendSms != 3) {
                if(this.sendSms > 3 && this.sendSms < 15 || this.sendSms > 23 && this.sendSms < 34) {
                    smsTip = "购买已成功！";
                    bRight = false;
                    bLeft = false;
                    if(this.sendSms > 23 && this.sendSms < 34) {
                        this.sendSms = (byte)(this.sendSms + 1);
                    }
                }
                else if(this.sendSms == 15) {
                    smsTip = "自动保存游戏。";
                    bRight = false;
                    bLeft = false;
                }
                else if(this.sendSms < 23) {
                    smsTip = "保存游戏成功。";
                    this.sendSms = (byte)(this.sendSms + 1);
                    bRight = false;
                    bLeft = false;
                    if(SMSSender.smsType == 5 && this.sendSms == 23) {
                        SMSSender.gr.say("购买已成功！游戏已保存。#n新游戏后此功能不再要求付费。", -1);
                    }
                    else if(SMSSender.smsType == 6 && this.sendSms == 23) {
                        SMSSender.gr.say("购买已成功！获得5枚徽章(背包的卷轴界面可查看）。游戏已保存。#n新游戏后此功能不再要求付费。", 0);
                    }
                }
            }
            if(this.sendSms != 1 && this.sendSms != 2 && this.sendSms != 3) {
                SMSSender.gr.showString(smsTip, Constants_H.HEIGHT_H - 50, 0);
            }
        }
        Ui.i().drawYesNo(bLeft, bRight);
    }

    public byte getSendSms() {
        return this.sendSms;
    }

    public byte getSmsSenderMenuState() {
        return this.menu_state;
    }

    private String getSmsTip(int i0, int i1) {
        return "您已发送" + i0 + "条短信。" + "购买此项，还需发送" + i1 + "条短信。" + "确认发送短信吗？";
    }

    public int getTstate() {
        return this.tState;
    }

    public void go(int menu_state_, boolean bb) {
        if(bb) {
            this.tState = GameRun.run_state;
            this.tMyState = SMSSender.gr.map.my.state;
        }
        else {
            this.tState = -1;
        }
        this.sms_a = true;
        this.sms_b = false;
        GameRun.run_state = -20;
        this.menu_state = (byte)menu_state_;
        byte[] arr_b = this.sel;
        byte[] arr_b1 = this.sel;
        int v1 = this.menu[this.menu_state].length <= 1 ? 0 : 1;
        arr_b1[1] = (byte)v1;
        arr_b[0] = (byte)v1;
        SMSSender.smsType = (byte)(this.menu[this.menu_state][this.sel[0]] - 1);
        this.goWord();
        if(SMSSender.smsType == 5 || SMSSender.smsType == 6 || SMSSender.smsType == 7 || this.menu_state == 4 && SMSSender.smsType == 1) {
            this.sendSms = 1;
            return;
        }
        this.sendSms = -1;
        SMSSender.isWorking = false;
    }

    public void goLevel() {
        GameRun.run_state = -21;
        this.idSmsLevel = 0;
        SMSSender.gr.b_c = 0;
        if(this.tState != 0xFFFFFFE1) {
            SMSSender.gr.levelUp_in_battle = null;
            GameRun gameRun0 = SMSSender.gr;
            gameRun0.levelUp_in_battle = new byte[SMSSender.gr.max_takes][2];
            SMSSender.gr.proReplace = null;
            GameRun gameRun1 = SMSSender.gr;
            gameRun1.proReplace = new short[SMSSender.gr.myMonsters.length][7];
        }
        for(int i = 0; i < SMSSender.gr.myMon_length; i = (byte)(i + 1)) {
            if(SMSSender.gr.myMonsters[i].monster[2] >= 70) {
                SMSSender.gr.healMonster(SMSSender.gr.myMonsters[i]);
            }
            else {
                SMSSender.gr.proReplace[i][6] = SMSSender.gr.myMonsters[i].monster[2];
                SMSSender.gr.levelUp_in_battle[i][0] = 1;
                SMSSender.gr.levelUp_in_battle[i][1] = -1;
                for(int j = 0; j < 5; j = (byte)(j + 1)) {
                    SMSSender.gr.levelPro(i, false);
                    SMSSender.gr.getMagic(SMSSender.gr.myMonsters[i]);
                    if(SMSSender.gr.getSkill != -1) {
                        SMSSender.gr.levelUp_in_battle[i][1] = SMSSender.gr.getSkill;
                    }
                }
            }
        }
    }

    private void goWord() {
        this.showLine = 3;
    }

    public static SMSSender i(GameRun gr_) {
        if(SMSSender.smsSender == null) {
            SMSSender.smsSender = new SMSSender(gr_);
        }
        return SMSSender.smsSender;
    }

    public boolean isMyMonLevel() {
        for(int i = (byte)(SMSSender.gr.myMon_length - 1); true; i = (byte)(i - 1)) {
            if(i <= -1) {
                return false;
            }
            if(SMSSender.gr.myMonsters[i].monster[2] < 70) {
                return true;
            }
        }
    }

    public void key() {
        if(this.sendSms != -1 || !Ms.i().key_Up_Down()) {
            if((this.sendSms == -1 || this.sendSms == 0) && Ms.i().key_S1()) {
                Ms.i().keyRelease();
                if(SMSSender.smsType == 4 && this.sel[0] != 7 && (SMSSender.gr.myMon_length < 1 || !this.isMyMonLevel())) {
                    this.sendSms = -1;
                    SMSSender.gr.say("目前没有可以升级的宠物！", 0);
                    return;
                }
                this.sendSms = 1;
                return;
            }
            if((this.sendSms == -1 || this.sendSms == 0 || (this.sendSms == 3 || this.sendSms == 24)) && Ms.i().key_S2()) {
                Ms.i().keyRelease();
                this.outState();
                if(SMSSender.smsType == 6) {
                    GameRun.run_state = -10;
                    SMSSender.isWorking = true;
                }
                this.sendSms = -1;
            }
        }
        else if(!Ms.i().key_delay() && this.menu[this.menu_state].length > 1) {
            Ms.i().selectS(this.sel, 1, this.menu[this.menu_state].length, ((int)this.showLine));
            this.setSmsType();
        }
    }

    public void keyLevel() {
        if(!Ms.i().key_delay() && (SMSSender.gr.b_c == 1 && SMSSender.gr.say_s == 0)) {
            SMSSender.gr.b_c = 0;
        }
    }

    private void outState() {
        if(this.tState != -1) {
            GameRun.run_state = this.tState;
            SMSSender.gr.map.my.state = this.tMyState;
            return;
        }
        GameRun.run_state = -10;
    }

    public void paint() {
        this.draw();
    }

    public void paintLevel() {
        if(SMSSender.gr.b_c != 1) {
            return;
        }
        SMSSender.gr.drawEvolveUI(0, ((int)this.idSmsLevel), true);
    }

    public void run() {
        if(this.sendSms == 1) {
            this.sendSms = 2;
            SMSSender.pk.setSmshah();
        }
    }

    public void runLevel() {
        switch(SMSSender.gr.b_c) {
            case 0: {
                if(SMSSender.gr.levelUp_in_battle[this.idSmsLevel][0] == 1) {
                    SMSSender.gr.levelUp_in_battle[this.idSmsLevel][0] = 0;
                    SMSSender.gr.b_c = 1;
                    SMSSender.gr.say_s = 52;
                    SMSSender.gr.levelPro(((int)this.idSmsLevel), true);
                    SMSSender.gr.setStringB("生命;+" + ((int)SMSSender.gr.proReplace[this.idSmsLevel][0]) + "#n" + "能量" + ";+" + ((int)SMSSender.gr.proReplace[this.idSmsLevel][1]), Constants_H.WIDTH, 0);
                    SMSSender.gr.setStringB("力量;+" + ((int)SMSSender.gr.proReplace[this.idSmsLevel][3]) + "#n" + "防御" + ";+" + ((int)SMSSender.gr.proReplace[this.idSmsLevel][4]) + "#n" + "敏捷" + ";+" + ((int)SMSSender.gr.proReplace[this.idSmsLevel][5]), Constants_H.WIDTH, 1);
                    SMSSender.gr.initMonStream(2, ((int)SMSSender.gr.mList_id[SMSSender.gr.myMonsters[this.idSmsLevel].monster[0]][0]), 1);
                }
                else {
                    this.idSmsLevel = (byte)(this.idSmsLevel + 1);
                }
                if(this.idSmsLevel >= SMSSender.gr.myMon_length) {
                    if(this.tState == -1) {
                        GameRun.run_state = -20;
                        SMSSender.gr.levelUp_in_battle = null;
                        SMSSender.gr.proReplace = null;
                        return;
                    }
                    GameRun.run_state = this.tState;
                    if(this.tState == 0xFFFFFFE1) {
                        SMSSender.gr.initMonStream(2, ((int)SMSSender.gr.mList_id[SMSSender.gr.myB.getMon().monster[0]][0]), 1);
                        SMSSender.gr.myB.act_num = 0;
                        Monster monster0 = SMSSender.gr.myB.getMon();
                        SMSSender.gr.initSkillList(monster0);
                        for(int i = 0; i < SMSSender.gr.myMon_length; i = (byte)(i + 1)) {
                            SMSSender.gr.proReplace[SMSSender.gr.myMonsters[i].monster[1]][6] = SMSSender.gr.myMonsters[i].monster[2];
                        }
                    }
                }
                return;
            }
            case 1: {
                GameRun gameRun0 = SMSSender.gr;
                gameRun0.say_s = (byte)Ms.i().mathSpeedDown(SMSSender.gr.say_s, 4, true);
            }
        }
    }

    public void sendSuccess() {
        if(this.sendSms == 4 && this.smsCount[SMSSender.smsType][1] > 1) {
            byte[] arr_b = SMSSender.gr.rmsSms;
            int v = this.smsCount[SMSSender.smsType][2];
            byte b = (byte)(arr_b[v] + 1);
            arr_b[v] = b;
            if(b == this.smsCount[SMSSender.smsType][1]) {
                SMSSender.gr.rmsSms[this.smsCount[SMSSender.smsType][2]] = 0;
            }
            else {
                this.sendSms = 0;
                Ms.i().rmsOptions(5, SMSSender.gr.rmsSms, 2);
                Ms.i().rmsOptions(5, null, 4);
            }
        }
        switch(SMSSender.smsType) {
            case 1: {
                SMSSender.gr.money += 5000;
                SMSSender.gr.say("购买5000金币", -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            }
            case 2: {
                SMSSender.gr.coin += 50;
                SMSSender.gr.say("在卷轴商店中才能看到徽章数量", -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            }
            case 3: {
                SMSSender.gr.coin += 10;
                SMSSender.gr.say("在卷轴商店中才能看到徽章数量", -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            }
            case 4: {
                this.tState = -1;
                SMSSender.gr.say("携带的宠物全部升5级,宠物页面查看新属性", 0, -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                goto label_45;
            }
            case 5: {
                SMSSender.gr.rmsSms[0] = 10;
                SMSSender.gr.say("购买后此功能不再要求付费", 0, -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            }
            case 6: {
                SMSSender.gr.rmsSms[this.smsCount[SMSSender.smsType][2]] = 10;
                SMSSender.gr.coin += 5;
                this.sms_b = true;
                SMSSender.gr.say("购买后此功能不再要求付费", 0, -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            }
            case 7: {
            label_45:
                this.goLevel();
                GameRun.mc.setSmsIsSetRun_state(true);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
            }
        }
        SMSSender.gr.saveGame();
        if(this.menu_state == 0) {
            this.sendSms = -1;
            Sound.i().setMusic(false);
        }
        else {
            this.sendSms = -1;
            if(SMSSender.gr.say_c == 0) {
                this.outState();
                GameRun.mc.setSmsIsSetRun_state(true);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
            }
        }
        this.sendSms = -1;
        GameRun.run_state = -10;
        GameRun.mc.temp_state = GameRun.run_state;
    }

    public void setSendSms(int value) {
        this.sendSms = (byte)value;
    }

    public void setSmsType() {
        SMSSender.smsType = (byte)(this.menu[this.menu_state][this.sel[0]] - 1);
    }

    public void setSmsValue(int type) {
    }
}

