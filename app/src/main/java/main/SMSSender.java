/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.PetKing5_480x800.PetKing5
 *  dm.Ms
 *  dm.Sound
 *  dm.Ui
 *  main.Constants_H
 *  main.GameRun
 *  main.Key_H
 *  main.PointerKey
 */
package main;

import android.util.Log;
import com.PetKing5_480x800.PetKing5;
import dm.Ms;
import dm.Sound;
import dm.Ui;
import main.Constants_H;
import main.GameRun;
import main.Key_H;
import main.PointerKey;

public class SMSSender
implements Key_H {
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

    /*
     * Enabled force condition propagation
     */
    public SMSSender(GameRun gameRun) {
        byte[] byArray = new byte[4];
        byArray[1] = 2;
        byArray[2] = 4;
        byArray[3] = 5;
        this.menu = new byte[][]{byArray, {6}, {7}, {8}, {2}};
        this.sel = new byte[2];
        byArray = new byte[]{4, 1, 1};
        byte[] byArray2 = new byte[]{2, 1, 2};
        byte[] byArray3 = new byte[]{4, 1, 3};
        byte[] byArray4 = new byte[]{1, 1, 4};
        byte[] byArray5 = new byte[]{2, 1, 5};
        byte[] byArray6 = new byte[3];
        byArray6[0] = 1;
        byArray6[1] = 1;
        this.smsCount = new byte[][]{byArray, byArray2, byArray3, byArray4, byArray5, byArray6, {2, 1, 6}, {2, 1, 5}};
        this.sendSms = (byte)-1;
        gr = gameRun;
        smsSender = this;
        try {
            this.createSMS();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    private void createSMS() {
        String[] stringArray = new String[]{"\u5546\u57ce"};
        String[] stringArray2 = new String[]{"\u8d2d\u4e705000\u91d1", "\u8eab\u4e3a\u56db\u5927\u5bb6\u65cf\u4e4b\u9996\u7684\u8d35\u516c\u5b50\uff0c\u6ca1\u94b1\u53ef\u4e0d\u884c\uff01\u7acb\u523b\u62e5\u67095000\u91d1\u3002"};
        String[] stringArray3 = new String[]{"\u8d2d\u4e7050\u5fbd\u7ae0", ""};
        String[] stringArray4 = new String[]{"\u8d2d\u4e7010\u5fbd\u7ae0", "\u8d2d\u4e70\u8be5\u7279\u6b8a\u9053\u5177\uff0c\u7acb\u523b\u62e5\u670910\u5fbd\u7ae0\uff0c\u80fd\u8d2d\u4e70\u53cc\u500d\u7ecf\u9a8c\uff0c\u5ba0\u7269\u6280\u80fd\uff0c\u5f3a\u5927\u7684\u5ba0\u7269\u6355\u83b7\u7403\u7b49\u5404\u79cd\u795e\u5947\u7684\u9053\u5177\u3002"};
        String[] stringArray5 = new String[]{"\u8d2d\u4e70\u5947\u5f02\u517d", "\u8d2d\u4e70\u8be5\u7279\u6b8a\u9053\u5177\uff0c\u83b7\u5f97\u53ef\u7231\u7684\u5947\u5f02\u517d\uff0c\u79fb\u52a8\u901f\u5ea6\u53ef\u4ee5\u63d0\u9ad8\u4e00\u500d\uff0c\u4e14\u4e0d\u4f1a\u9047\u5230\u4efb\u4f55\u654c\u4eba\uff01\u65e0\u9650\u4f7f\u7528\uff0c\u5fc3\u52a8\u4e0d\u5982\u884c\u52a8\uff0c\u5feb\u8d2d\u4e70\u5427\uff01"};
        String[] stringArray6 = new String[]{"\u5347\u7ea7\u590d\u6d3b", "\u8ba9\u60a8\u643a\u5e26\u7684\u6240\u6709\u5ba0\u7269\u5168\u6062\u590d\uff0c\u540c\u65f6\u7acb\u523b\u8ba9\u60a8\u643a\u5e26\u7684\u5ba0\u7269\u63d0\u53475\u7ea7\uff08\u8d85\u8fc770\u7ea7\u5ba0\u7269\u4e0d\u80fd\u518d\u5347\u7ea7\uff09\uff0c\u8ba9\u63a5\u4e0b\u6765\u7684\u6218\u6597\u53d8\u7684\u66f4\u8f7b\u677e\u3002"};
        this.menuTxt = new String[][]{stringArray, {"\u8d2d\u4e7030000\u91d1", ""}, stringArray2, stringArray3, stringArray4, {"\u5ba0\u7269\u53475\u7ea7", "\u8ba9\u60a8\u968f\u8eab\u643a\u5e26\u7684\u5168\u90e8\u5ba0\u7269\u7acb\u523b\u53475\u7ea7\uff08\u8d85\u8fc770\u7ea7\u5ba0\u7269\u4e0d\u80fd\u518d\u5347\u7ea7\uff09"}, stringArray5, {"\u6b63\u7248\u9a8c\u8bc1", "\u6e38\u620f\u8bd5\u73a9\u7ed3\u675f\uff0c\u8d2d\u4e70\u6b64\u9879\u5c06\u5f00\u542f\u540e\u7eed\u6240\u6709\u6e38\u620f\u5185\u5bb9\u3001\u5730\u56fe\u3002\u540c\u65f6\u5c06\u514d\u8d39\u8d60\u9001\u60a85\u679a\u5fbd\u7ae0\uff08\u53ef\u8d2d\u4e70\u5f3a\u529b\u9053\u5177\uff09"}, stringArray6};
    }

    /*
     * Unable to fully structure code
     */
    private void draw0() {
        block13: {
            block12: {
                block11: {
                    block9: {
                        block10: {
                            var4_1 = true;
                            var6_2 = true;
                            var5_3 = true;
                            var7_4 = true;
                            if (this.sendSms <= -1) ** GOTO lbl28
                            var9_5 = "";
                            if (this.sendSms != 0) break block9;
                            var1_6 = this.smsCount[SMSSender.smsType][2];
                            if (var1_6 >= 0) break block10;
                            var1_6 = 0;
lbl11:
                            // 2 sources

                            while (true) {
                                var8_7 = this.getSmsTip(var1_6, this.smsCount[SMSSender.smsType][1] - var1_6);
                                var3_8 = var7_4;
                                var2_9 = var6_2;
lbl15:
                                // 13 sources

                                while (true) {
                                    var4_1 = var2_9;
                                    var5_3 = var3_8;
                                    if (this.sendSms != 3) {
                                        var4_1 = var2_9;
                                        var5_3 = var3_8;
                                        if (this.sendSms != 1) {
                                            var4_1 = var2_9;
                                            var5_3 = var3_8;
                                            if (this.sendSms != 2) {
                                                SMSSender.gr.showString(var8_7, Constants_H.HEIGHT_H - 50, 0);
                                                var5_3 = var3_8;
                                                var4_1 = var2_9;
                                            }
                                        }
                                    }
lbl28:
                                    // 8 sources

                                    Ui.i().drawYesNo(var4_1, var5_3);
                                    return;
                                }
                                break;
                            }
                        }
                        var1_6 = SMSSender.gr.rmsSms[var1_6];
                        ** while (true)
                    }
                    var2_9 = var6_2;
                    var3_8 = var7_4;
                    var8_7 = var9_5;
                    if (this.sendSms == 1) ** GOTO lbl15
                    var2_9 = var6_2;
                    var3_8 = var7_4;
                    var8_7 = var9_5;
                    if (this.sendSms == 2) ** GOTO lbl15
                    var2_9 = var6_2;
                    var3_8 = var7_4;
                    var8_7 = var9_5;
                    if (this.sendSms == 3) ** GOTO lbl15
                    if ((this.sendSms <= 3 || this.sendSms >= 15) && (this.sendSms <= 23 || this.sendSms >= 34)) break block11;
                    var9_5 = "\u8d2d\u4e70\u5df2\u6210\u529f\uff01";
                    var4_1 = false;
                    var2_9 = var5_3 = false;
                    var3_8 = var4_1;
                    var8_7 = var9_5;
                    if (this.sendSms <= 23) ** GOTO lbl15
                    var2_9 = var5_3;
                    var3_8 = var4_1;
                    var8_7 = var9_5;
                    if (this.sendSms >= 34) ** GOTO lbl15
                    this.sendSms = (byte)(this.sendSms + 1);
                    var2_9 = var5_3;
                    var3_8 = var4_1;
                    var8_7 = var9_5;
                    ** GOTO lbl15
                }
                if (this.sendSms != 15) break block12;
                var8_7 = "\u81ea\u52a8\u4fdd\u5b58\u6e38\u620f\u3002";
                var3_8 = false;
                var2_9 = false;
                ** GOTO lbl15
            }
            var2_9 = var6_2;
            var3_8 = var7_4;
            var8_7 = var9_5;
            if (this.sendSms >= 23) ** GOTO lbl15
            var9_5 = "\u4fdd\u5b58\u6e38\u620f\u6210\u529f\u3002";
            this.sendSms = (byte)(this.sendSms + 1);
            var4_1 = false;
            var5_3 = false;
            if (SMSSender.smsType != 5 || this.sendSms != 23) break block13;
            SMSSender.gr.say("\u8d2d\u4e70\u5df2\u6210\u529f\uff01\u6e38\u620f\u5df2\u4fdd\u5b58\u3002#n\u65b0\u6e38\u620f\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39\u3002", -1);
            var2_9 = var5_3;
            var3_8 = var4_1;
            var8_7 = var9_5;
            ** GOTO lbl15
        }
        var2_9 = var5_3;
        var3_8 = var4_1;
        var8_7 = var9_5;
        if (SMSSender.smsType != 6) ** GOTO lbl15
        var2_9 = var5_3;
        var3_8 = var4_1;
        var8_7 = var9_5;
        if (this.sendSms != 23) ** GOTO lbl15
        SMSSender.gr.say("\u8d2d\u4e70\u5df2\u6210\u529f\uff01\u83b7\u5f975\u679a\u5fbd\u7ae0(\u80cc\u5305\u7684\u5377\u8f74\u754c\u9762\u53ef\u67e5\u770b\uff09\u3002\u6e38\u620f\u5df2\u4fdd\u5b58\u3002#n\u65b0\u6e38\u620f\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39\u3002", 0);
        var2_9 = var5_3;
        var3_8 = var4_1;
        var8_7 = var9_5;
        ** while (true)
    }

    private String getSmsTip(int n, int n2) {
        return String.valueOf("") + "\u60a8\u5df2\u53d1\u9001" + n + "\u6761\u77ed\u4fe1\u3002" + "\u8d2d\u4e70\u6b64\u9879\uff0c\u8fd8\u9700\u53d1\u9001" + n2 + "\u6761\u77ed\u4fe1\u3002" + "\u786e\u8ba4\u53d1\u9001\u77ed\u4fe1\u5417\uff1f";
    }

    private void goWord() {
        this.showLine = (byte)3;
    }

    public static SMSSender i(GameRun gameRun) {
        if (smsSender == null) {
            smsSender = new SMSSender(gameRun);
        }
        return smsSender;
    }

    /*
     * Enabled force condition propagation
     */
    private void outState() {
        if (this.tState != -1) {
            GameRun.run_state = this.tState;
            SMSSender.gr.map.my.state = this.tMyState;
            return;
        }
        GameRun.run_state = -10;
    }

    /*
     * Unable to fully structure code
     */
    public void draw() {
        if (this.menu_state != 0) ** GOTO lbl24
        var1_1 = 640 - 2;
        var4_2 = 360 - 1;
        Ui.i().fillRectB();
        Ui.i().drawK2(1, 1, var1_1, var4_2, 0);
        Ui.i().drawK1(320 - 75, 1 + 3, 150, 28 - 4, 4);
        Ui.i().drawString(this.menuTxt[this.menu[this.menu_state][0]][0], 320, 1 + 1, 17, 0, 1);
        Log.e((String)"sk", (String)"draw");
        var3_3 = 1 + 5;
        var2_4 = 1 + 29;
        var5_5 = var1_1 - 10;
        var1_1 = var2_4;
        if (this.menu[this.menu_state].length <= 1) ** GOTO lbl22
        Ui.i().drawK1(var3_3, var2_4, var5_5 - 15, 28 * this.showLine, 1);
        Ui.i().sliding(var3_3 + 628 - 13, var2_4, 28 * this.showLine, this.sel[0] - 1, this.menu[this.menu_state].length - 1, true);
        Ui.i().drawListKY((int)this.showLine, var3_3, var2_4 + 2, var5_5 - 15, 2, 28, -1, this.sel[0] - this.sel[1], 4, 2);
        var1_1 = this.sel[1];
        block0: while (true) {
            block6: {
                if (var1_1 < this.sel[1] + this.showLine && var1_1 < this.menu[this.menu_state].length) break block6;
                var1_1 = this.showLine * 28 + 5 + 30;
lbl22:
                // 2 sources

                Ui.i().drawK1(var3_3, var1_1, var5_5, var4_2 - (var1_1 + 10), 2);
                this.draw0();
lbl24:
                // 2 sources

                return;
            }
            var8_8 = Ui.i();
            var7_7 = this.menuTxt[this.menu[this.menu_state][var1_1]][0];
            var6_6 = this.sel[1];
            if (this.sel[0] != var1_1) break;
            var2_4 = 0;
lbl31:
            // 2 sources

            while (true) {
                var8_8.drawString(var7_7, var3_3 + 314, (var1_1 - var6_6) * 28 + 32, 17, var2_4, 0);
                if (this.pkey.isSelect(var3_3, (var1_1 - this.sel[1]) * 28 + 32, 640, 28)) {
                    this.sel[0] = (byte)var1_1;
                    this.setSmsType();
                }
                ++var1_1;
                continue block0;
                break;
            }
            break;
        }
        var2_4 = 3;
        ** while (true)
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

    /*
     * Unable to fully structure code
     */
    public void go(int var1_1, boolean var2_2) {
        block6: {
            block5: {
                if (var2_2) {
                    this.tState = GameRun.run_state;
                    this.tMyState = SMSSender.gr.map.my.state;
lbl4:
                    // 2 sources

                    while (true) {
                        this.sms_a = true;
                        this.sms_b = false;
                        GameRun.run_state = -20;
                        this.menu_state = (byte)var1_1;
                        var4_3 = this.sel;
                        var5_4 = this.sel;
                        if (this.menu[this.menu_state].length <= 1) break block5;
                        var1_1 = 1;
lbl13:
                        // 2 sources

                        while (true) {
                            var5_4[1] = var3_5 = (byte)var1_1;
                            var4_3[0] = var3_5;
                            SMSSender.smsType = (byte)(this.menu[this.menu_state][this.sel[0]] - 1);
                            this.goWord();
                            if (SMSSender.smsType == 5 || SMSSender.smsType == 6 || SMSSender.smsType == 7 || this.menu_state == 4 && SMSSender.smsType == 1) {
                                this.sendSms = 1;
lbl20:
                                // 2 sources

                                return;
                            }
                            break block6;
                            break;
                        }
                        break;
                    }
                }
                this.tState = -1;
                ** while (true)
            }
            var1_1 = 0;
            ** while (true)
        }
        this.sendSms = (byte)-1;
        SMSSender.isWorking = false;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void goLevel() {
        GameRun.run_state = -21;
        this.idSmsLevel = 0;
        SMSSender.gr.b_c = 0;
        if (this.tState != -31) {
            SMSSender.gr.levelUp_in_battle = null;
            var3_1 = SMSSender.gr;
            var1_2 = SMSSender.gr.max_takes;
            var3_1.levelUp_in_battle = new byte[var1_2][2];
            SMSSender.gr.proReplace = null;
            var3_1 = SMSSender.gr;
            var1_2 = SMSSender.gr.myMonsters.length;
            var3_1.proReplace = new short[var1_2][7];
        }
        var1_2 = 0;
        block0: while (true) {
            if (var1_2 >= SMSSender.gr.myMon_length) {
                return;
            }
            if (SMSSender.gr.myMonsters[var1_2].monster[2] < 70) break;
            SMSSender.gr.healMonster(SMSSender.gr.myMonsters[var1_2]);
            while (true) {
                var1_2 = (byte)(var1_2 + 1);
                continue block0;
                break;
            }
            break;
        }
        SMSSender.gr.proReplace[var1_2][6] = SMSSender.gr.myMonsters[var1_2].monster[2];
        SMSSender.gr.levelUp_in_battle[var1_2][0] = 1;
        SMSSender.gr.levelUp_in_battle[var1_2][1] = -1;
        var2_3 = 0;
        while (true) {
            if (var2_3 >= 5) ** continue;
            SMSSender.gr.levelPro(var1_2, false);
            SMSSender.gr.getMagic(SMSSender.gr.myMonsters[var1_2]);
            if (SMSSender.gr.getSkill != -1) {
                SMSSender.gr.levelUp_in_battle[var1_2][1] = SMSSender.gr.getSkill;
            }
            var2_3 = (byte)(var2_3 + 1);
        }
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isMyMonLevel() {
        byte by = (byte)(SMSSender.gr.myMon_length - 1);
        while (by > -1) {
            if (SMSSender.gr.myMonsters[by].monster[2] < 70) {
                return true;
            }
            by = (byte)(by - 1);
        }
        return false;
    }

    /*
     * Unable to fully structure code
     */
    public void key() {
        block5: {
            block6: {
                block4: {
                    if (this.sendSms != -1 || !Ms.i().key_Up_Down()) break block4;
                    if (Ms.i().key_delay()) lbl-1000:
                    // 6 sources

                    {
                        return;
                    }
                    if (this.menu[this.menu_state].length > 1) {
                        Ms.i().selectS(this.sel, 1, this.menu[this.menu_state].length, (int)this.showLine);
                        this.setSmsType();
                    }
                    ** GOTO lbl-1000
                }
                if (this.sendSms != -1 && this.sendSms != 0 || !Ms.i().key_S1()) break block5;
                Ms.i().keyRelease();
                if (SMSSender.smsType != 4 || this.sel[0] == 7 || SMSSender.gr.myMon_length >= 1 && this.isMyMonLevel()) break block6;
                this.sendSms = (byte)-1;
                SMSSender.gr.say("\u76ee\u524d\u6ca1\u6709\u53ef\u4ee5\u5347\u7ea7\u7684\u5ba0\u7269\uff01", 0);
                ** GOTO lbl-1000
            }
            this.sendSms = 1;
            ** GOTO lbl-1000
        }
        if (this.sendSms != -1 && this.sendSms != 0 && this.sendSms != 3 && this.sendSms != 24 || !Ms.i().key_S2()) ** GOTO lbl-1000
        Ms.i().keyRelease();
        this.outState();
        if (SMSSender.smsType == 6) {
            GameRun.run_state = -10;
            SMSSender.isWorking = true;
        }
        this.sendSms = (byte)-1;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void keyLevel() {
        if (Ms.i().key_delay()) lbl-1000:
        // 3 sources

        {
            return;
        }
        if (SMSSender.gr.b_c != 1 || SMSSender.gr.say_s != 0) ** GOTO lbl-1000
        SMSSender.gr.b_c = 0;
        ** while (true)
    }

    public void paint() {
        this.draw();
    }

    /*
     * Enabled force condition propagation
     */
    public void paintLevel() {
        if (SMSSender.gr.b_c != 1) {
            return;
        }
        gr.drawEvolveUI(0, (int)this.idSmsLevel, true);
    }

    public void run() {
        if (this.sendSms == 1) {
            this.sendSms = (byte)2;
            pk.setSmshah();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void runLevel() {
        block7: {
            block6: {
                if (SMSSender.gr.b_c != 0) break block7;
                if (SMSSender.gr.levelUp_in_battle[this.idSmsLevel][0] == 1) {
                    SMSSender.gr.levelUp_in_battle[this.idSmsLevel][0] = 0;
                    SMSSender.gr.b_c = 1;
                    SMSSender.gr.say_s = 52;
                    SMSSender.gr.levelPro((int)this.idSmsLevel, true);
                    SMSSender.gr.setStringB("\u751f\u547d;+" + SMSSender.gr.proReplace[this.idSmsLevel][0] + "#n" + "\u80fd\u91cf" + ";+" + SMSSender.gr.proReplace[this.idSmsLevel][1], Constants_H.WIDTH, 0);
                    SMSSender.gr.setStringB("\u529b\u91cf;+" + SMSSender.gr.proReplace[this.idSmsLevel][3] + "#n" + "\u9632\u5fa1" + ";+" + SMSSender.gr.proReplace[this.idSmsLevel][4] + "#n" + "\u654f\u6377" + ";+" + SMSSender.gr.proReplace[this.idSmsLevel][5], Constants_H.WIDTH, 1);
                    SMSSender.gr.initMonStream(2, (int)SMSSender.gr.mList_id[SMSSender.gr.myMonsters[this.idSmsLevel].monster[0]][0], 1);
lbl10:
                    // 2 sources

                    while (true) {
                        if (this.idSmsLevel >= SMSSender.gr.myMon_length) {
                            if (this.tState != -1) break block6;
                            GameRun.run_state = -20;
                            SMSSender.gr.levelUp_in_battle = null;
                            SMSSender.gr.proReplace = null;
                        }
lbl16:
                        // 7 sources

                        return;
                    }
                }
                this.idSmsLevel = (byte)(this.idSmsLevel + 1);
                ** while (true)
            }
            GameRun.run_state = this.tState;
            if (this.tState != -31) ** GOTO lbl16
            SMSSender.gr.initMonStream(2, (int)SMSSender.gr.mList_id[SMSSender.gr.myB.getMon().monster[0]][0], 1);
            SMSSender.gr.myB.act_num = 0;
            SMSSender.gr.initSkillList(SMSSender.gr.myB.getMon());
            var1_1 = 0;
            while (true) {
                if (var1_1 >= SMSSender.gr.myMon_length) ** GOTO lbl16
                SMSSender.gr.proReplace[SMSSender.gr.myMonsters[var1_1].monster[1]][6] = SMSSender.gr.myMonsters[var1_1].monster[2];
                var1_1 = (byte)(var1_1 + 1);
            }
        }
        if (SMSSender.gr.b_c != 1) ** GOTO lbl16
        SMSSender.gr.say_s = (byte)Ms.i().mathSpeedDown(SMSSender.gr.say_s, 4, true);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void sendSuccess() {
        block13: {
            if (this.sendSms != 4 || this.smsCount[SMSSender.smsType][1] <= 1) break block13;
            var3_1 /* !! */  = (GameRun)SMSSender.gr.rmsSms;
            var2_2 = this.smsCount[SMSSender.smsType][2];
            var1_3 = (byte)(var3_1 /* !! */ [var2_2] + true);
            var3_1 /* !! */ [var2_2] = (GameRun)var1_3;
            if (var1_3 == this.smsCount[SMSSender.smsType][1]) ** GOTO lbl27
            this.sendSms = 0;
            Ms.i().rmsOptions(5, SMSSender.gr.rmsSms, 2);
            Ms.i().rmsOptions(5, null, 4);
        }
        block9: while (true) {
            switch (SMSSender.smsType) lbl-1000:
            // 7 sources

            {
                default: {
                    SMSSender.gr.saveGame();
                    if (this.menu_state == 0) break block9;
                    this.sendSms = (byte)-1;
                    if (SMSSender.gr.say_c == 0) {
                        this.outState();
                        GameRun.mc.setSmsIsSetRun_state(true);
                        GameRun.mc.temp_state = GameRun.run_state = -10;
                    }
lbl23:
                    // 4 sources

                    while (true) {
                        this.sendSms = (byte)-1;
                        GameRun.mc.temp_state = GameRun.run_state = -10;
                        return;
                    }
                }
lbl27:
                // 1 sources

                SMSSender.gr.rmsSms[this.smsCount[SMSSender.smsType][2]] = 0;
                continue block9;
                case 1: {
                    var3_1 /* !! */  = SMSSender.gr;
                    var3_1 /* !! */ .money += 5000;
                    SMSSender.gr.say("\u8d2d\u4e705000\u91d1\u5e01", -1);
                    GameRun.mc.temp_state = GameRun.run_state = -10;
                    ** GOTO lbl-1000
                }
                case 2: {
                    var3_1 /* !! */  = SMSSender.gr;
                    var3_1 /* !! */ .coin += 50;
                    SMSSender.gr.say("\u5728\u5377\u8f74\u5546\u5e97\u4e2d\u624d\u80fd\u770b\u5230\u5fbd\u7ae0\u6570\u91cf", -1);
                    GameRun.mc.temp_state = GameRun.run_state = -10;
                    ** GOTO lbl-1000
                }
                case 3: {
                    var3_1 /* !! */  = SMSSender.gr;
                    var3_1 /* !! */ .coin += 10;
                    SMSSender.gr.say("\u5728\u5377\u8f74\u5546\u5e97\u4e2d\u624d\u80fd\u770b\u5230\u5fbd\u7ae0\u6570\u91cf", -1);
                    GameRun.mc.temp_state = GameRun.run_state = -10;
                    ** GOTO lbl-1000
                }
                case 4: {
                    this.tState = -1;
                    SMSSender.gr.say("\u643a\u5e26\u7684\u5ba0\u7269\u5168\u90e8\u53475\u7ea7,\u5ba0\u7269\u9875\u9762\u67e5\u770b\u65b0\u5c5e\u6027", 0, -1);
                    GameRun.mc.temp_state = GameRun.run_state = -10;
                }
                case 7: {
                    this.goLevel();
                    GameRun.mc.setSmsIsSetRun_state(true);
                    GameRun.mc.temp_state = GameRun.run_state = -10;
                    ** GOTO lbl-1000
                }
                case 5: {
                    SMSSender.gr.rmsSms[0] = 10;
                    SMSSender.gr.say("\u8d2d\u4e70\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39", 0, -1);
                    GameRun.mc.temp_state = GameRun.run_state = -10;
                    ** GOTO lbl-1000
                }
                case 6: {
                    SMSSender.gr.rmsSms[this.smsCount[SMSSender.smsType][2]] = 10;
                    var3_1 /* !! */  = SMSSender.gr;
                    var3_1 /* !! */ .coin += 5;
                    this.sms_b = true;
                    SMSSender.gr.say("\u8d2d\u4e70\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39", 0, -1);
                    GameRun.mc.temp_state = GameRun.run_state = -10;
                    ** GOTO lbl-1000
                }
            }
            break;
        }
        this.sendSms = (byte)-1;
        Sound.i().setMusic(false);
        ** while (true)
    }

    public void setSendSms(int n) {
        this.sendSms = (byte)n;
    }

    public void setSmsType() {
        smsType = (byte)(this.menu[this.menu_state][this.sel[0]] - 1);
    }

    public void setSmsValue(int n) {
        switch (smsType) {
            default: 
        }
    }
}
