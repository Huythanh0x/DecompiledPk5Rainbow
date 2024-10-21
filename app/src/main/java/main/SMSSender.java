package main;

import dm.Sound;
import dm.Ms;
import android.util.Log;
import dm.Ui;
import com.PetKing5_480x800.PetKing5;

public class SMSSender implements Key_H
{
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
    public boolean sms_a;
    public boolean sms_b;
    public byte tMyState;
    private int tState;
    private byte totalPage;
    
    public SMSSender(final GameRun gr) {
        super();
        this.sms_a = true;
        this.sms_b = false;
        this.menu = new byte[][] { { 0, 2, 4, 5 }, { 6 }, { 7 }, { 8 }, { 2 } };
        this.sel = new byte[2];
        this.smsCount = new byte[][] { { 4, 1, 1 }, { 2, 1, 2 }, { 4, 1, 3 }, { 1, 1, 4 }, { 2, 1, 5 }, { 1, 1, 0 }, { 2, 1, 6 }, { 2, 1, 5 } };
        this.sendSms = -1;
        SMSSender.gr = gr;
        SMSSender.smsSender = this;
        try {
            this.createSMS();
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void createSMS() {
        this.menuTxt = new String[][] { { "\u5546\u57ce" }, { "\u8d2d\u4e7030000\u91d1", "" }, { "\u8d2d\u4e705000\u91d1", "\u8eab\u4e3a\u56db\u5927\u5bb6\u65cf\u4e4b\u9996\u7684\u8d35\u516c\u5b50\uff0c\u6ca1\u94b1\u53ef\u4e0d\u884c\uff01\u7acb\u523b\u62e5\u67095000\u91d1\u3002" }, { "\u8d2d\u4e7050\u5fbd\u7ae0", "" }, { "\u8d2d\u4e7010\u5fbd\u7ae0", "\u8d2d\u4e70\u8be5\u7279\u6b8a\u9053\u5177\uff0c\u7acb\u523b\u62e5\u670910\u5fbd\u7ae0\uff0c\u80fd\u8d2d\u4e70\u53cc\u500d\u7ecf\u9a8c\uff0c\u5ba0\u7269\u6280\u80fd\uff0c\u5f3a\u5927\u7684\u5ba0\u7269\u6355\u83b7\u7403\u7b49\u5404\u79cd\u795e\u5947\u7684\u9053\u5177\u3002" }, { "\u5ba0\u7269\u53475\u7ea7", "\u8ba9\u60a8\u968f\u8eab\u643a\u5e26\u7684\u5168\u90e8\u5ba0\u7269\u7acb\u523b\u53475\u7ea7\uff08\u8d85\u8fc770\u7ea7\u5ba0\u7269\u4e0d\u80fd\u518d\u5347\u7ea7\uff09" }, { "\u8d2d\u4e70\u5947\u5f02\u517d", "\u8d2d\u4e70\u8be5\u7279\u6b8a\u9053\u5177\uff0c\u83b7\u5f97\u53ef\u7231\u7684\u5947\u5f02\u517d\uff0c\u79fb\u52a8\u901f\u5ea6\u53ef\u4ee5\u63d0\u9ad8\u4e00\u500d\uff0c\u4e14\u4e0d\u4f1a\u9047\u5230\u4efb\u4f55\u654c\u4eba\uff01\u65e0\u9650\u4f7f\u7528\uff0c\u5fc3\u52a8\u4e0d\u5982\u884c\u52a8\uff0c\u5feb\u8d2d\u4e70\u5427\uff01" }, { "\u6b63\u7248\u9a8c\u8bc1", "\u6e38\u620f\u8bd5\u73a9\u7ed3\u675f\uff0c\u8d2d\u4e70\u6b64\u9879\u5c06\u5f00\u542f\u540e\u7eed\u6240\u6709\u6e38\u620f\u5185\u5bb9\u3001\u5730\u56fe\u3002\u540c\u65f6\u5c06\u514d\u8d39\u8d60\u9001\u60a85\u679a\u5fbd\u7ae0\uff08\u53ef\u8d2d\u4e70\u5f3a\u529b\u9053\u5177\uff09" }, { "\u5347\u7ea7\u590d\u6d3b", "\u8ba9\u60a8\u643a\u5e26\u7684\u6240\u6709\u5ba0\u7269\u5168\u6062\u590d\uff0c\u540c\u65f6\u7acb\u523b\u8ba9\u60a8\u643a\u5e26\u7684\u5ba0\u7269\u63d0\u53475\u7ea7\uff08\u8d85\u8fc770\u7ea7\u5ba0\u7269\u4e0d\u80fd\u518d\u5347\u7ea7\uff09\uff0c\u8ba9\u63a5\u4e0b\u6765\u7684\u6218\u6597\u53d8\u7684\u66f4\u8f7b\u677e\u3002" } };
    }
    
    private void draw0() {
        boolean b = true;
        final boolean b2 = true;
        boolean b3 = true;
        final boolean b4 = true;
        if (this.sendSms > -1) {
            final String s = "";
            String smsTip;
            boolean b7;
            boolean b8;
            if (this.sendSms == 0) {
                final byte b5 = this.smsCount[SMSSender.smsType][2];
                byte b6;
                if (b5 < 0) {
                    b6 = 0;
                }
                else {
                    b6 = SMSSender.gr.rmsSms[b5];
                }
                smsTip = this.getSmsTip(b6, this.smsCount[SMSSender.smsType][1] - b6);
                b7 = b4;
                b8 = b2;
            }
            else {
                b8 = b2;
                b7 = b4;
                smsTip = s;
                if (this.sendSms != 1) {
                    b8 = b2;
                    b7 = b4;
                    smsTip = s;
                    if (this.sendSms != 2) {
                        b8 = b2;
                        b7 = b4;
                        smsTip = s;
                        if (this.sendSms != 3) {
                            if ((this.sendSms > 3 && this.sendSms < 15) || (this.sendSms > 23 && this.sendSms < 34)) {
                                final String s2 = "\u8d2d\u4e70\u5df2\u6210\u529f\uff01";
                                final boolean b9 = false;
                                final boolean b10 = b8 = false;
                                b7 = b9;
                                smsTip = s2;
                                if (this.sendSms > 23) {
                                    b8 = b10;
                                    b7 = b9;
                                    smsTip = s2;
                                    if (this.sendSms < 34) {
                                        ++this.sendSms;
                                        b8 = b10;
                                        b7 = b9;
                                        smsTip = s2;
                                    }
                                }
                            }
                            else if (this.sendSms == 15) {
                                smsTip = "\u81ea\u52a8\u4fdd\u5b58\u6e38\u620f\u3002";
                                b7 = false;
                                b8 = false;
                            }
                            else {
                                b8 = b2;
                                b7 = b4;
                                smsTip = s;
                                if (this.sendSms < 23) {
                                    final String s3 = "\u4fdd\u5b58\u6e38\u620f\u6210\u529f\u3002";
                                    ++this.sendSms;
                                    final boolean b11 = false;
                                    final boolean b12 = false;
                                    if (SMSSender.smsType == 5 && this.sendSms == 23) {
                                        SMSSender.gr.say("\u8d2d\u4e70\u5df2\u6210\u529f\uff01\u6e38\u620f\u5df2\u4fdd\u5b58\u3002#n\u65b0\u6e38\u620f\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39\u3002", -1);
                                        b8 = b12;
                                        b7 = b11;
                                        smsTip = s3;
                                    }
                                    else {
                                        b8 = b12;
                                        b7 = b11;
                                        smsTip = s3;
                                        if (SMSSender.smsType == 6) {
                                            b8 = b12;
                                            b7 = b11;
                                            smsTip = s3;
                                            if (this.sendSms == 23) {
                                                SMSSender.gr.say("\u8d2d\u4e70\u5df2\u6210\u529f\uff01\u83b7\u5f975\u679a\u5fbd\u7ae0(\u80cc\u5305\u7684\u5377\u8f74\u754c\u9762\u53ef\u67e5\u770b\uff09\u3002\u6e38\u620f\u5df2\u4fdd\u5b58\u3002#n\u65b0\u6e38\u620f\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39\u3002", 0);
                                                b8 = b12;
                                                b7 = b11;
                                                smsTip = s3;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            b = b8;
            b3 = b7;
            if (this.sendSms != 3) {
                b = b8;
                b3 = b7;
                if (this.sendSms != 1) {
                    b = b8;
                    b3 = b7;
                    if (this.sendSms != 2) {
                        SMSSender.gr.showString(smsTip, Constants_H.HEIGHT_H - 50, 0);
                        b3 = b7;
                        b = b8;
                    }
                }
            }
        }
        Ui.i().drawYesNo(b, b3);
    }
    
    private String getSmsTip(final int i, final int j) {
        return String.valueOf("") + "\u60a8\u5df2\u53d1\u9001" + i + "\u6761\u77ed\u4fe1\u3002" + "\u8d2d\u4e70\u6b64\u9879\uff0c\u8fd8\u9700\u53d1\u9001" + j + "\u6761\u77ed\u4fe1\u3002" + "\u786e\u8ba4\u53d1\u9001\u77ed\u4fe1\u5417\uff1f";
    }
    
    private void goWord() {
        this.showLine = 3;
    }
    
    public static SMSSender i(final GameRun gameRun) {
        if (SMSSender.smsSender == null) {
            SMSSender.smsSender = new SMSSender(gameRun);
        }
        return SMSSender.smsSender;
    }
    
    private void outState() {
        if (this.tState != -1) {
            GameRun.run_state = this.tState;
            SMSSender.gr.map.my.state = this.tMyState;
        }
        else {
            GameRun.run_state = -10;
        }
    }
    
    public void draw() {
        if (this.menu_state == 0) {
            final int n = 640 - 2;
            final int n2 = 360 - 1;
            Ui.i().fillRectB();
            Ui.i().drawK2(1, 1, n, n2, 0);
            Ui.i().drawK1(320 - 75, 1 + 3, 150, 28 - 4, 4);
            Ui.i().drawString(this.menuTxt[this.menu[this.menu_state][0]][0], 320, 1 + 1, 17, 0, 1);
            Log.e("sk", "draw");
            final int n3 = 1 + 5;
            final int n4 = 1 + 29;
            final int n5 = n - 10;
            int n6 = n4;
            if (this.menu[this.menu_state].length > 1) {
                Ui.i().drawK1(n3, n4, n5 - 15, 28 * this.showLine, 1);
                Ui.i().sliding(n3 + 628 - 13, n4, 28 * this.showLine, this.sel[0] - 1, this.menu[this.menu_state].length - 1, true);
                Ui.i().drawListKY(this.showLine, n3, n4 + 2, n5 - 15, 2, 28, -1, this.sel[0] - this.sel[1], 4, 2);
                for (byte b = this.sel[1]; b < this.sel[1] + this.showLine && b < this.menu[this.menu_state].length; ++b) {
                    final Ui i = Ui.i();
                    final String s = this.menuTxt[this.menu[this.menu_state][b]][0];
                    final byte b2 = this.sel[1];
                    int n7;
                    if (this.sel[0] == b) {
                        n7 = 0;
                    }
                    else {
                        n7 = 3;
                    }
                    i.drawString(s, n3 + 314, (b - b2) * 28 + 32, 17, n7, 0);
                    if (this.pkey.isSelect(n3, (b - this.sel[1]) * 28 + 32, 640, 28)) {
                        this.sel[0] = b;
                        this.setSmsType();
                    }
                }
                n6 = this.showLine * 28 + 5 + 30;
            }
            Ui.i().drawK1(n3, n6, n5, n2 - (n6 + 10), 2);
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
    
    public void go(int n, final boolean b) {
        if (b) {
            this.tState = GameRun.run_state;
            this.tMyState = SMSSender.gr.map.my.state;
        }
        else {
            this.tState = -1;
        }
        this.sms_a = true;
        this.sms_b = false;
        GameRun.run_state = -20;
        this.menu_state = (byte)n;
        final byte[] sel = this.sel;
        final byte[] sel2 = this.sel;
        if (this.menu[this.menu_state].length > 1) {
            n = 1;
        }
        else {
            n = 0;
        }
        sel[0] = (sel2[1] = (byte)n);
        SMSSender.smsType = (byte)(this.menu[this.menu_state][this.sel[0]] - 1);
        this.goWord();
        if (SMSSender.smsType == 5 || SMSSender.smsType == 6 || SMSSender.smsType == 7 || (this.menu_state == 4 && SMSSender.smsType == 1)) {
            this.sendSms = 1;
        }
        else {
            this.sendSms = -1;
            SMSSender.isWorking = false;
        }
    }
    
    public void goLevel() {
        GameRun.run_state = -21;
        this.idSmsLevel = 0;
        SMSSender.gr.b_c = 0;
        if (this.tState != -31) {
            SMSSender.gr.levelUp_in_battle = null;
            SMSSender.gr.levelUp_in_battle = new byte[SMSSender.gr.max_takes][2];
            SMSSender.gr.proReplace = null;
            SMSSender.gr.proReplace = new short[SMSSender.gr.myMonsters.length][7];
        }
        for (byte b = 0; b < SMSSender.gr.myMon_length; ++b) {
            if (SMSSender.gr.myMonsters[b].monster[2] >= 70) {
                SMSSender.gr.healMonster(SMSSender.gr.myMonsters[b]);
            }
            else {
                SMSSender.gr.proReplace[b][6] = SMSSender.gr.myMonsters[b].monster[2];
                SMSSender.gr.levelUp_in_battle[b][0] = 1;
                SMSSender.gr.levelUp_in_battle[b][1] = -1;
                for (int i = 0; i < 5; i = (byte)(i + 1)) {
                    SMSSender.gr.levelPro(b, false);
                    SMSSender.gr.getMagic(SMSSender.gr.myMonsters[b]);
                    if (SMSSender.gr.getSkill != -1) {
                        SMSSender.gr.levelUp_in_battle[b][1] = SMSSender.gr.getSkill;
                    }
                }
            }
        }
    }
    
    public boolean isMyMonLevel() {
        for (byte b = (byte)(SMSSender.gr.myMon_length - 1); b > -1; --b) {
            if (SMSSender.gr.myMonsters[b].monster[2] < 70) {
                return true;
            }
        }
        return false;
    }
    
    public void key() {
        if (this.sendSms == -1 && Ms.i().key_Up_Down()) {
            if (!Ms.i().key_delay() && this.menu[this.menu_state].length > 1) {
                Ms.i().selectS(this.sel, 1, this.menu[this.menu_state].length, this.showLine);
                this.setSmsType();
            }
        }
        else if ((this.sendSms == -1 || this.sendSms == 0) && Ms.i().key_S1()) {
            Ms.i().keyRelease();
            if (SMSSender.smsType == 4 && this.sel[0] != 7 && (SMSSender.gr.myMon_length < 1 || !this.isMyMonLevel())) {
                this.sendSms = -1;
                SMSSender.gr.say("\u76ee\u524d\u6ca1\u6709\u53ef\u4ee5\u5347\u7ea7\u7684\u5ba0\u7269\uff01", 0);
            }
            else {
                this.sendSms = 1;
            }
        }
        else if ((this.sendSms == -1 || this.sendSms == 0 || this.sendSms == 3 || this.sendSms == 24) && Ms.i().key_S2()) {
            Ms.i().keyRelease();
            this.outState();
            if (SMSSender.smsType == 6) {
                GameRun.run_state = -10;
                SMSSender.isWorking = true;
            }
            this.sendSms = -1;
        }
    }
    
    public void keyLevel() {
        if (!Ms.i().key_delay() && SMSSender.gr.b_c == 1 && SMSSender.gr.say_s == 0) {
            SMSSender.gr.b_c = 0;
        }
    }
    
    public void paint() {
        this.draw();
    }
    
    public void paintLevel() {
        if (SMSSender.gr.b_c == 1) {
            SMSSender.gr.drawEvolveUI(0, this.idSmsLevel, true);
        }
    }
    
    public void run() {
        if (this.sendSms == 1) {
            this.sendSms = 2;
            SMSSender.pk.setSmshah();
        }
    }
    
    public void runLevel() {
        if (SMSSender.gr.b_c == 0) {
            if (SMSSender.gr.levelUp_in_battle[this.idSmsLevel][0] == 1) {
                SMSSender.gr.levelUp_in_battle[this.idSmsLevel][0] = 0;
                SMSSender.gr.b_c = 1;
                SMSSender.gr.say_s = 52;
                SMSSender.gr.levelPro(this.idSmsLevel, true);
                SMSSender.gr.setStringB("\u751f\u547d;+" + SMSSender.gr.proReplace[this.idSmsLevel][0] + "#n" + "\u80fd\u91cf" + ";+" + SMSSender.gr.proReplace[this.idSmsLevel][1], Constants_H.WIDTH, 0);
                SMSSender.gr.setStringB("\u529b\u91cf;+" + SMSSender.gr.proReplace[this.idSmsLevel][3] + "#n" + "\u9632\u5fa1" + ";+" + SMSSender.gr.proReplace[this.idSmsLevel][4] + "#n" + "\u654f\u6377" + ";+" + SMSSender.gr.proReplace[this.idSmsLevel][5], Constants_H.WIDTH, 1);
                SMSSender.gr.initMonStream(2, SMSSender.gr.mList_id[SMSSender.gr.myMonsters[this.idSmsLevel].monster[0]][0], 1);
            }
            else {
                ++this.idSmsLevel;
            }
            if (this.idSmsLevel >= SMSSender.gr.myMon_length) {
                if (this.tState == -1) {
                    GameRun.run_state = -20;
                    SMSSender.gr.levelUp_in_battle = null;
                    SMSSender.gr.proReplace = null;
                }
                else {
                    GameRun.run_state = this.tState;
                    if (this.tState == -31) {
                        SMSSender.gr.initMonStream(2, SMSSender.gr.mList_id[SMSSender.gr.myB.getMon().monster[0]][0], 1);
                        SMSSender.gr.myB.act_num = 0;
                        SMSSender.gr.initSkillList(SMSSender.gr.myB.getMon());
                        for (byte b = 0; b < SMSSender.gr.myMon_length; ++b) {
                            SMSSender.gr.proReplace[SMSSender.gr.myMonsters[b].monster[1]][6] = SMSSender.gr.myMonsters[b].monster[2];
                        }
                    }
                }
            }
        }
        else if (SMSSender.gr.b_c == 1) {
            SMSSender.gr.say_s = (byte)Ms.i().mathSpeedDown(SMSSender.gr.say_s, 4, true);
        }
    }
    
    public void sendSuccess() {
        if (this.sendSms == 4 && this.smsCount[SMSSender.smsType][1] > 1) {
            final byte[] rmsSms = SMSSender.gr.rmsSms;
            final byte b = this.smsCount[SMSSender.smsType][2];
            if (++rmsSms[b] != this.smsCount[SMSSender.smsType][1]) {
                this.sendSms = 0;
                Ms.i().rmsOptions(5, SMSSender.gr.rmsSms, 2);
                Ms.i().rmsOptions(5, null, 4);
            }
            else {
                SMSSender.gr.rmsSms[this.smsCount[SMSSender.smsType][2]] = 0;
            }
        }
        switch (SMSSender.smsType) {
            case 1: {
                final GameRun gr = SMSSender.gr;
                gr.money += 5000;
                SMSSender.gr.say("\u8d2d\u4e705000\u91d1\u5e01", -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            }
            case 2: {
                final GameRun gr2 = SMSSender.gr;
                gr2.coin += 50;
                SMSSender.gr.say("\u5728\u5377\u8f74\u5546\u5e97\u4e2d\u624d\u80fd\u770b\u5230\u5fbd\u7ae0\u6570\u91cf", -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            }
            case 3: {
                final GameRun gr3 = SMSSender.gr;
                gr3.coin += 10;
                SMSSender.gr.say("\u5728\u5377\u8f74\u5546\u5e97\u4e2d\u624d\u80fd\u770b\u5230\u5fbd\u7ae0\u6570\u91cf", -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            }
            case 4: {
                this.tState = -1;
                SMSSender.gr.say("\u643a\u5e26\u7684\u5ba0\u7269\u5168\u90e8\u53475\u7ea7,\u5ba0\u7269\u9875\u9762\u67e5\u770b\u65b0\u5c5e\u6027", 0, -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
            }
            case 7: {
                this.goLevel();
                GameRun.mc.setSmsIsSetRun_state(true);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            }
            case 5: {
                SMSSender.gr.rmsSms[0] = 10;
                SMSSender.gr.say("\u8d2d\u4e70\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39", 0, -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            }
            case 6: {
                SMSSender.gr.rmsSms[this.smsCount[SMSSender.smsType][2]] = 10;
                final GameRun gr4 = SMSSender.gr;
                gr4.coin += 5;
                this.sms_b = true;
                SMSSender.gr.say("\u8d2d\u4e70\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39", 0, -1);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
                break;
            }
        }
        SMSSender.gr.saveGame();
        if (this.menu_state != 0) {
            this.sendSms = -1;
            if (SMSSender.gr.say_c == 0) {
                this.outState();
                GameRun.mc.setSmsIsSetRun_state(true);
                GameRun.run_state = -10;
                GameRun.mc.temp_state = GameRun.run_state;
            }
        }
        else {
            this.sendSms = -1;
            Sound.i().setMusic(false);
        }
        this.sendSms = -1;
        GameRun.run_state = -10;
        GameRun.mc.temp_state = GameRun.run_state;
    }
    
    public void setSendSms(final int n) {
        this.sendSms = (byte)n;
    }
    
    public void setSmsType() {
        SMSSender.smsType = (byte)(this.menu[this.menu_state][this.sel[0]] - 1);
    }
    
    public void setSmsValue(final int n) {
        switch (SMSSender.smsType) {
            default: {}
        }
    }
}
