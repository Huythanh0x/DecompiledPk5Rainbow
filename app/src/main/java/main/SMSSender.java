package main;

import android.util.Log;
import com.PetKing5_480x800.PetKing5;
import dm.Ms;
import dm.Sound;
import dm.Ui;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public class SMSSender implements Key_H {
    public static GameRun gr;
    public static boolean isWorking;
    public static PetKing5 pk;
    public static SMSSender smsSender;
    public static byte smsType;
    private StringBuffer[] about;
    private byte currentPage;
    public byte idSmsLevel;
    private String[][] menuTxt;
    public byte menu_state;
    public PointerKey pkey;
    public byte showLine;
    public byte tMyState;
    private int tState;
    private byte totalPage;
    public boolean sms_a = true;
    public boolean sms_b = false;
    public byte[][] menu = {new byte[]{0, 2, 4, 5}, new byte[]{6}, new byte[]{7}, new byte[]{8}, new byte[]{2}};
    public byte[] sel = new byte[2];
    public byte[][] smsCount = {new byte[]{4, 1, 1}, new byte[]{2, 1, 2}, new byte[]{4, 1, 3}, new byte[]{1, 1, 4}, new byte[]{2, 1, 5}, new byte[]{1, 1}, new byte[]{2, 1, 6}, new byte[]{2, 1, 5}};
    public byte sendSms = -1;

    public SMSSender(GameRun gr_) {
        gr = gr_;
        smsSender = this;
        try {
            createSMS();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static SMSSender i(GameRun gr_) {
        if (smsSender == null) {
            smsSender = new SMSSender(gr_);
        }
        return smsSender;
    }

    private void createSMS() {
        this.menuTxt = new String[][]{new String[]{"Mall"}, new String[]{"Buy 30000 gold", ""}, new String[]{"Buy 5000 gold", "As the noble son of the head of the four major families, you can't be without money! Get 5000 gold immediately."}, new String[]{"Buy 50 badges", ""}, new String[]{"Buy 10 badges", "Buy this special item and immediately have 10 badges, which can be used to purchase double experience, pet skills, powerful pet capture balls, and other magical items."}, new String[]{"Pet level up 5", "Let all the pets you carry level up by 5 immediately (pets over level 70 cannot level up anymore)"}, new String[]{"Buy strange beast", "Buy this special item to obtain a cute strange beast, which can double your movement speed and you won't encounter any enemies! Unlimited use, take action now, buy it now!"}, new String[]{"Genuine verification", "The game trial is over, buy this item to unlock all subsequent game content and maps. You will also be given 5 badges for free (which can be used to buy powerful items)"}, new String[]{"Upgrade revival", "Restore all the pets you carry, and at the same time immediately upgrade the pets you carry by 5 levels (pets over level 70 cannot level up anymore), making the next battle easier."}};
    }

    public void go(int menu_state_, boolean bb) {
        if (bb) {
            this.tState = GameRun.run_state;
            this.tMyState = gr.map.my.state;
        } else {
            this.tState = -1;
        }
        this.sms_a = true;
        this.sms_b = false;
        GameRun.run_state = -20;
        this.menu_state = (byte) menu_state_;
        byte[] bArr = this.sel;
        byte[] bArr2 = this.sel;
        byte b = (byte) (this.menu[this.menu_state].length > 1 ? 1 : 0);
        bArr2[1] = b;
        bArr[0] = b;
        smsType = (byte) (this.menu[this.menu_state][this.sel[0]] - 1);
        goWord();
        if (smsType == 5 || smsType == 6 || smsType == 7 || (this.menu_state == 4 && smsType == 1)) {
            this.sendSms = (byte) 1;
        } else {
            this.sendSms = (byte) -1;
            isWorking = false;
        }
    }

    private void goWord() {
        this.showLine = (byte) 3;
    }

    public void paint() {
        draw();
    }

    public void run() {
        if (this.sendSms == 1) {
            this.sendSms = (byte) 2;
            pk.setSmshah();
        }
    }

    public void setSmsType() {
        smsType = (byte) (this.menu[this.menu_state][this.sel[0]] - 1);
    }

    public void key() {
        if (this.sendSms == -1 && Ms.i().key_Up_Down()) {
            if (!Ms.i().key_delay() && this.menu[this.menu_state].length > 1) {
                Ms.i().selectS(this.sel, 1, this.menu[this.menu_state].length, this.showLine);
                setSmsType();
                return;
            }
            return;
        }
        if ((this.sendSms == -1 || this.sendSms == 0) && Ms.i().key_S1()) {
            Ms.i().keyRelease();
            if (smsType == 4 && this.sel[0] != 7 && (gr.myMon_length < 1 || !isMyMonLevel())) {
                this.sendSms = (byte) -1;
                gr.say("No pets that can be upgraded at the moment!", 0);
                return;
            } else {
                this.sendSms = (byte) 1;
                return;
            }
        }
        if ((this.sendSms == -1 || this.sendSms == 0 || this.sendSms == 3 || this.sendSms == 24) && Ms.i().key_S2()) {
            Ms.i().keyRelease();
            outState();
            if (smsType == 6) {
                GameRun.run_state = -10;
                isWorking = true;
            }
            this.sendSms = (byte) -1;
        }
    }

    public void draw() {
        if (this.menu_state == 0) {
            int i = Constants_H.WIDTH_ - 2;
            int i2 = Constants_H.HEIGHT_ - 1;
            Ui.i().fillRectB();
            Ui.i().drawK2(1, 1, i, i2, 0);
            Ui.i().drawK1(Constants_H.WIDTH_H_ - 75, 1 + 3, 150, 28 - 4, 4);
            Ui.i().drawString(this.menuTxt[this.menu[this.menu_state][0]][0], Constants_H.WIDTH_H_, 1 + 1, 17, 0, 1);
            Log.e("sk", "draw");
            int i3 = 1 + 5;
            int i4 = 28 + 1;
            int i5 = 1 + 29;
            int i6 = i - 10;
            if (this.menu[this.menu_state].length > 1) {
                Ui.i().drawK1(i3, i5, i6 - 15, 28 * this.showLine, 1);
                Ui.i().sliding((i3 + 628) - 13, i5, 28 * this.showLine, this.sel[0] - 1, this.menu[this.menu_state].length - 1, true);
                Ui.i().drawListKY(this.showLine, i3, i5 + 2, i6 - 15, 2, 28, -1, this.sel[0] - this.sel[1], 4, 2);
                int i7 = this.sel[1];
                while (i7 < this.sel[1] + this.showLine && i7 < this.menu[this.menu_state].length) {
                    int i8 = i6 >> 1;
                    int i9 = i5 + 2;
                    Ui.i().drawString(this.menuTxt[this.menu[this.menu_state][i7]][0], i3 + 314, ((i7 - this.sel[1]) * 28) + 32, 17, this.sel[0] == i7 ? 0 : 3, 0);
                    int i10 = i5 + 2;
                    if (this.pkey.isSelect(i3, ((i7 - this.sel[1]) * 28) + 32, Constants_H.WIDTH_, 28)) {
                        this.sel[0] = (byte) i7;
                        setSmsType();
                    }
                    i7++;
                }
                i5 = (this.showLine * 28) + 5 + 30;
            }
            Ui.i().drawK1(i3, i5, i6, i2 - (i5 + 10), 2);
            draw0();
        }
    }

    private void draw0() {
        boolean bLeft = true;
        boolean bRight = true;
        if (this.sendSms > -1) {
            String smsTip = "";
            if (this.sendSms == 0) {
                int i = this.smsCount[smsType][2];
                int i2 = i < 0 ? 0 : gr.rmsSms[i];
                smsTip = getSmsTip(i2, this.smsCount[smsType][1] - i2);
            } else if (this.sendSms != 1 && this.sendSms != 2 && this.sendSms != 3) {
                if ((this.sendSms > 3 && this.sendSms < 15) || (this.sendSms > 23 && this.sendSms < 34)) {
                    smsTip = "Purchase successful!";
                    bRight = false;
                    bLeft = false;
                    if (this.sendSms > 23 && this.sendSms < 34) {
                        this.sendSms = (byte) (this.sendSms + 1);
                    }
                } else if (this.sendSms == 15) {
                    smsTip = "Auto save game.";
                    bRight = false;
                    bLeft = false;
                } else if (this.sendSms < 23) {
                    smsTip = "Save game successful.";
                    this.sendSms = (byte) (this.sendSms + 1);
                    bRight = false;
                    bLeft = false;
                    if (smsType == 5 && this.sendSms == 23) {
                        gr.say("Purchase successful! Game saved. #nThis function will no longer require payment after a new game.", -1);
                    } else if (smsType == 6 && this.sendSms == 23) {
                        gr.say("Purchase successful! Obtain 5 badges (can be viewed in the scroll interface of the backpack). Game saved. #nThis function will no longer require payment after a new game.", 0);
                    }
                }
            }
            if (this.sendSms != 3 && this.sendSms != 1 && this.sendSms != 2) {
                gr.showString(smsTip, Constants_H.HEIGHT_H - 50, 0);
            }
        }
        Ui.i().drawYesNo(bLeft, bRight);
    }

    private String getSmsTip(int i0, int i1) {
        String tip = String.valueOf("") + "You have sent" + i0 + "SMS messages. To purchase this item, you still need to send" + i1 + "SMS messages. Confirm to send SMS?";
        return tip;
    }

    private void outState() {
        if (this.tState != -1) {
            GameRun.run_state = this.tState;
            gr.map.my.state = this.tMyState;
            return;
        }
        GameRun.run_state = -10;
    }

    public void paintLevel() {
        if (gr.b_c == 1) {
            gr.drawEvolveUI(0, this.idSmsLevel, true);
        }
    }

    public void runLevel() {
        if (gr.b_c == 0) {
            if (gr.levelUp_in_battle[this.idSmsLevel][0] == 1) {
                gr.levelUp_in_battle[this.idSmsLevel][0] = 0;
                gr.b_c = (byte) 1;
                gr.say_s = 52;
                gr.levelPro(this.idSmsLevel, true);
                gr.setStringB("HP;+" + ((int) gr.proReplace[this.idSmsLevel][0]) + "#n" + Constants_H.PRO_TXT_1 + ";+" + ((int) gr.proReplace[this.idSmsLevel][1]), Constants_H.WIDTH, 0);
                gr.setStringB("Strength;+" + ((int) gr.proReplace[this.idSmsLevel][3]) + "#n" + Constants_H.PRO_TXT_4 + ";+" + ((int) gr.proReplace[this.idSmsLevel][4]) + "#n" + Constants_H.PRO_TXT_5 + ";+" + ((int) gr.proReplace[this.idSmsLevel][5]), Constants_H.WIDTH, 1);
                gr.initMonStream(2, gr.mList_id[gr.myMonsters[this.idSmsLevel].monster[0]][0], 1);
            } else {
                this.idSmsLevel = (byte) (this.idSmsLevel + 1);
            }
            if (this.idSmsLevel >= gr.myMon_length) {
                if (this.tState == -1) {
                    GameRun.run_state = -20;
                    gr.levelUp_in_battle = null;
                    gr.proReplace = null;
                    return;
                }
                GameRun.run_state = this.tState;
                if (this.tState == -31) {
                    gr.initMonStream(2, gr.mList_id[gr.myB.getMon().monster[0]][0], 1);
                    gr.myB.act_num = (byte) 0;
                    gr.initSkillList(gr.myB.getMon());
                    for (byte i = 0; i < gr.myMon_length; i = (byte) (i + 1)) {
                        gr.proReplace[gr.myMonsters[i].monster[1]][6] = gr.myMonsters[i].monster[2];
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (gr.b_c == 1) {
            gr.say_s = (byte) Ms.i().mathSpeedDown(gr.say_s, 4, true);
        }
    }

    public void keyLevel() {
        if (!Ms.i().key_delay() && gr.b_c == 1 && gr.say_s == 0) {
            gr.b_c = (byte) 0;
        }
    }

    public void goLevel() {
        GameRun.run_state = -21;
        this.idSmsLevel = (byte) 0;
        gr.b_c = (byte) 0;
        if (this.tState != -31) {
            gr.levelUp_in_battle = null;
            //todo thanh0x fix here [][]
            gr.levelUp_in_battle = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, gr.max_takes, 2);
            gr.proReplace = null;
            //todo thanh0x fix here [][]
            gr.proReplace = (short[][]) Array.newInstance((Class<?>) Short.TYPE, gr.myMonsters.length, 7);
        }
        for (byte i = 0; i < gr.myMon_length; i = (byte) (i + 1)) {
            if (gr.myMonsters[i].monster[2] >= 70) {
                gr.healMonster(gr.myMonsters[i]);
            } else {
                gr.proReplace[i][6] = gr.myMonsters[i].monster[2];
                gr.levelUp_in_battle[i][0] = 1;
                gr.levelUp_in_battle[i][1] = -1;
                for (byte j = 0; j < 5; j = (byte) (j + 1)) {
                    gr.levelPro(i, false);
                    gr.getMagic(gr.myMonsters[i]);
                    if (gr.getSkill != -1) {
                        gr.levelUp_in_battle[i][1] = gr.getSkill;
                    }
                }
            }
        }
    }

    public boolean isMyMonLevel() {
        int i = gr.myMon_length - 1;
        while (true) {
            byte i2 = (byte) i;
            if (i2 > -1) {
                if (gr.myMonsters[i2].monster[2] < 70) {
                    return true;
                }
                i = i2 - 1;
            } else {
                return false;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void sendSuccess() {
        if (this.sendSms == 4 && this.smsCount[smsType][1] > 1) {
            byte[] bArr = gr.rmsSms;
            byte b = this.smsCount[smsType][2];
            byte b2 = (byte) (bArr[b] + 1);
            bArr[b] = b2;
            if (b2 != this.smsCount[smsType][1]) {
                this.sendSms = (byte) 0;
                Ms.i().rmsOptions(5, gr.rmsSms, 2);
                Ms.i().rmsOptions(5, null, 4);
            } else {
                gr.rmsSms[this.smsCount[smsType][2]] = 0;
            }
        }
        switch (smsType) {
            case 1:
                gr.money += 5000;
                gr.say("Buy 5000 gold coins", -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            case 2:
                gr.coin += 50;
                gr.say("The number of badges can only be seen in the scroll shop", -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            case 3:
                gr.coin += 10;
                gr.say("The number of badges can only be seen in the scroll shop", -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            case 4:
                this.tState = -1;
                gr.say("All carried pets level up by 5, view the new attributes on the pet page", 0, -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                goLevel();
                GameRun.mc.setSmsIsSetRun_state(true);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            case 5:
                gr.rmsSms[0] = 10;
                gr.say("This function no longer requires payment after purchase", 0, -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            case 6:
                gr.rmsSms[this.smsCount[smsType][2]] = 10;
                gr.coin += 5;
                this.sms_b = true;
                gr.say("This function no longer requires payment after purchase", 0, -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            case 7:
                goLevel();
                GameRun.mc.setSmsIsSetRun_state(true);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
        }
        gr.saveGame();
        if (this.menu_state != 0) {
            this.sendSms = (byte) -1;
            if (gr.say_c == 0) {
                outState();
                GameRun.mc.setSmsIsSetRun_state(true);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
            }
        } else {
            this.sendSms = (byte) -1;
            Sound.i().setMusic(false);
        }
        this.sendSms = (byte) -1;
        GameRun.run_state = -10;
        GameRun.mc.temp_state = GameRun.run_state;
    }

    public byte getSendSms() {
        return this.sendSms;
    }

    public void setSendSms(int value) {
        this.sendSms = (byte) value;
    }

    public byte getSmsSenderMenuState() {
        return this.menu_state;
    }

    public int getTstate() {
        return this.tState;
    }

    public void setSmsValue(int type) {
        switch (smsType) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            default:
                return;
        }
    }
}
