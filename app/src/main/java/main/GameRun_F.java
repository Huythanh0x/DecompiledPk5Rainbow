/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.nokia.mid.ui.DirectGraphics
 *  com.nokia.mid.ui.DirectUtils
 *  dm.Monster
 *  dm.Ms
 *  dm.Sound
 *  dm.Ui
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 *  main.Constants_H
 *  main.Key_H
 *  main.MainCanvas
 *  main.Map
 *  main.PointerKey
 */
package main;

import android.util.Log;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import dm.Monster;
import dm.Ms;
import dm.Sound;
import dm.Ui;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Constants_H;
import main.Key_H;
import main.MainCanvas;
import main.Map;
import main.PointerKey;

public class GameRun_F
implements Key_H {
    static DirectGraphics dg;
    static Graphics g;
    public static MainCanvas mc;
    static Graphics offG;
    public static int run_state;
    static Image scrT;
    public StringBuffer[] about_a;
    public StringBuffer[] about_b;
    public StringBuffer[] about_c;
    public StringBuffer[] about_d;
    public String[] action_str;
    final byte[] anchor = new byte[]{20, 36, 40, 24, 24, 40, 36, 20};
    private byte brow5;
    public byte cMon_count;
    public Monster[] cMonsters;
    public byte cur_a;
    public byte cur_b;
    public byte cur_c;
    public Monster cur_emon;
    public Monster cur_mon;
    public String gogoST;
    public String gogoString;
    public byte help_page;
    public byte[] info;
    public int introT;
    public int introX;
    public byte[][][] items;
    public byte[] itemsLength;
    public byte[] len;
    public Map map;
    public byte max_monsters;
    public byte max_takes;
    public byte[] monInfoList;
    public short move_x;
    public short move_y;
    public byte myMon_length;
    public Monster[] myMonsters;
    public byte[][] nidusList;
    public byte[] nidusMap;
    public byte page_max;
    public PointerKey pkey;
    public byte popMenu;
    public byte[] rmsNidus;
    public byte[] rmsOther;
    public byte[] rmsSms;
    public byte[][] select;
    public byte[][] selectBag;
    public byte[] select_it;
    public byte[] select_st;
    public byte selectx;
    public byte selecty;
    public StringBuffer[] showS;
    public byte[] src_c;
    public String str_cur;
    final short[] transB;

    static {
        run_state = 1;
    }

    public GameRun_F() {
        short[] sArray = new short[8];
        sArray[1] = 90;
        sArray[2] = 180;
        sArray[3] = 270;
        sArray[4] = 8192;
        sArray[5] = 8282;
        sArray[6] = 8372;
        sArray[7] = 8462;
        this.transB = sArray;
        this.introX = Constants_H.WIDTH_H;
        this.gogoString = "";
        this.introT = 640;
        this.gogoST = "";
        this.brow5 = 0;
        this.page_max = 0;
        this.help_page = 0;
        this.src_c = new byte[4];
        this.popMenu = (byte)-1;
        this.select_it = new byte[4];
        this.select_st = new byte[4];
        this.selectBag = new byte[4][2];
        this.select = new byte[2][2];
        this.max_takes = (byte)3;
        this.max_monsters = (byte)10;
    }

    /*
     * Unable to fully structure code
     */
    private void drawSnare5(int var1_1, int var2_2) {
        var4_3 = Ui.i();
        if (this.brow5 % 3 == 0) {
            var3_4 = 1;
lbl4:
            // 2 sources

            while (true) {
                var4_3.drawUi(8, var1_1, var2_2 + var3_4, 0, 0);
                var1_1 = this.brow5;
                this.brow5 = (byte)(var1_1 + 1);
                if (var1_1 > 100) {
                    this.brow5 = 0;
                }
                return;
            }
        }
        var3_4 = 0;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public boolean addNidus(int n) {
        int n2 = 0;
        while (true) {
            if (n2 >= this.rmsNidus.length) {
                return false;
            }
            if (this.rmsNidus[n2] == -2) break;
            n2 = (byte)(n2 + 5);
        }
        this.rmsNidus[n2] = (byte)n;
        Ms.i().putShort(0, this.rmsNidus, n2 + 1);
        Ms.i().putShort(200, this.rmsNidus, n2 + 3);
        return true;
    }

    public byte[] createData(int n) {
        return Ms.i().getStream("4", n);
    }

    public String createString(String string) {
        Ms.i();
        Ms.skip = 0;
        return Ms.i().createStringArray(Ms.i().getStream(string, -1))[0].toString();
    }

    public void delNidus(int n) {
        this.rmsNidus[n * 5] = -2;
    }

    /*
     * Unable to fully structure code
     */
    public void drawHelpStr(Graphics var1_1, StringBuffer[] var2_2, int var3_3, int var4_4, int var5_5, int var6_6) {
        block5: {
            var7_8 = var8_7 = (byte)(this.help_page * var3_3);
            while (true) {
                if (var7_8 >= var8_7 + var3_3 || var7_8 >= var2_2.length) {
                    if (var2_2.length > var3_3) {
                        var4_4 = var2_2.length / var3_3;
                        if (var2_2.length % var3_3 == 0) break;
                        var3_3 = 1;
lbl8:
                        // 2 sources

                        while (true) {
                            this.page_max = (byte)(var4_4 + var3_3);
                            Ui.i().drawString(String.valueOf(this.help_page + 1) + "/" + this.page_max, Constants_H.WIDTH_H, Constants_H.HEIGHT - 2, 1 | 32, 3, 0);
                            Ui.i().drawTriangle(Constants_H.WIDTH_H, Constants_H.HEIGHT - 12, 75, true, true);
lbl12:
                            // 2 sources

                            return;
                        }
                    }
                    break block5;
                }
                Ui.i().drawString(var2_2[var7_8].toString(), var4_4, var5_5 + (var7_8 - var8_7) * 27, var6_6, 3, 0);
                var7_8 = (byte)(var7_8 + 1);
            }
            var3_3 = 0;
            ** while (true)
        }
        this.page_max = 1;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawMenu(StringBuffer[] var1_1, int var2_2, int var3_3, int var4_4) {
        block7: {
            if (var4_4 > 0) {
                Ui.i().drawKuang(var2_2, var3_3, var4_4, var1_1.length * 27 + 12);
                var5_5 = var4_4;
lbl4:
                // 2 sources

                while (true) {
                    var6_6 = 0;
lbl6:
                    // 2 sources

                    while (true) {
                        if (var6_6 >= var1_1.length) {
                            return;
                        }
                        ** GOTO lbl14
                        break;
                    }
                    break;
                }
            } else {
                Ms.i();
                var5_5 = Ms.abs((int)var4_4);
                ** continue;
            }
lbl14:
            // 1 sources

            if (var6_6 == 0) {
                var4_4 = 9;
lbl16:
                // 3 sources

                while (true) {
                    Ui.i().drawString(var1_1[var6_6].toString(), (var5_5 >> 1) + var2_2, var3_3 + 4 + var6_6 * 27, 1 | 16, var4_4, 0);
                    var6_6 = (byte)(var6_6 + 1);
                    ** continue;
                    break;
                }
            }
            if (var6_6 != this.cur_a) break block7;
            var4_4 = 8;
            ** GOTO lbl16
        }
        var4_4 = 0;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawPauseMenu(int var1_1, int var2_2, int var3_3, int var4_4) {
        block11: {
            block10: {
                block9: {
                    Ui.i().drawK2(var1_1, var2_2, var3_3, var4_4, 1);
                    Ui.i().drawK1(var1_1 + 9, var2_2 + 25 + 11, var3_3 - 18, var4_4 - 25 - 19, 0);
                    Ui.i().drawListKY(6, var1_1 + 8, var2_2 + 25 + 13, var3_3 - 16, 1, 33, -1, (int)this.selecty, 4, 2);
                    this.pkey.selectListSY(this.action_str.length, var1_1 + 8, var2_2 + 25 + 13, var3_3 - 16, 1, 33, -1, (int)this.selecty);
                    var5_5 = this.pkey.selectMenuX(2, var1_1, var2_2 + 3, var3_3 >> 1, 38);
                    if (var5_5 != -1) {
                        this.selectx = var5_5;
                        this.selecty = 0;
                        this.setPauseS(this.selectx);
                    }
                    if (this.selectx == 1) {
                        var7_6 = Ui.i();
                        var4_4 = Sound.i().getVolume();
                        if (this.selecty == 1) {
                            var6_7 = true;
lbl15:
                            // 2 sources

                            while (true) {
                                var7_6.drawVolume((var3_3 >> 1) + var1_1 + 25 - 8 - 60, var2_2 + 25 + 16 + 33, var4_4, var6_7);
                                Ui.i().drawListSYHasSound((Object[])this.action_str, var1_1 + 8, var2_2 + 25 + 13, var3_3 - 16, 32, (int)this.selecty, 0, 3, 0);
lbl18:
                                // 2 sources

                                while (true) {
                                    var7_6 = Ui.i();
                                    if (this.selectx != 0) break block9;
                                    var4_4 = -60;
lbl22:
                                    // 2 sources

                                    while (true) {
                                        var7_6.drawK1((var3_3 >> 1) + var1_1 + var4_4, var2_2 + 4, 56, 29, 4);
                                        var7_6 = Ui.i();
                                        if (this.selectx != 0) break block10;
                                        var4_4 = 0;
lbl27:
                                        // 2 sources

                                        while (true) {
                                            var7_6.drawString("\u83dc\u5355", (var3_3 >> 1) + var1_1 - 25 - 3, var2_2 + 3, 1 | 16, var4_4, 0);
                                            var7_6 = Ui.i();
                                            if (this.selectx == 0) {
                                                var4_4 = 1;
lbl32:
                                                // 2 sources

                                                while (true) {
                                                    var7_6.drawString("\u7cfb\u7edf", (var3_3 >> 1) + var1_1 + 25 + 3, var2_2 + 3, 1 | 16, var4_4, 0);
                                                    Ui.i().drawTriangle((var3_3 >> 1) + var1_1, var2_2 + 12, 80, true, true);
                                                    return;
                                                }
                                            }
                                            break block11;
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        var6_7 = false;
                        ** continue;
                    }
                    Ui.i().drawListSY((Object[])this.action_str, var1_1 + 8, var2_2 + 25 + 13, var3_3 - 16, 32, (int)this.selecty, 0, 3, 0);
                    ** while (true)
                }
                var4_4 = 2;
                ** while (true)
            }
            var4_4 = 1;
            ** while (true)
        }
        var4_4 = 0;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void drawSelectMenu(Object[] var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7) {
        block10: {
            block8: {
                block9: {
                    block7: {
                        var8_8 = 0;
                        block0: while (true) {
                            if (var8_8 >= var1_1.length) {
                                return;
                            }
                            var10_10 /* !! */  = Ui.i();
                            if (var8_8 != var7_7) break;
                            var9_9 = 1;
lbl8:
                            // 2 sources

                            while (true) {
                                var10_10 /* !! */ .drawK0(var2_2, var3_3 + (var5_5 + 33) * var8_8, var4_4, 33, var9_9);
                                var11_11 = Ui.i();
                                var10_10 /* !! */  = var1_1[var8_8].toString();
                                if (var8_8 != var7_7) break block7;
                                var9_9 = 0;
lbl14:
                                // 2 sources

                                while (true) {
                                    var11_11.drawString((String)var10_10 /* !! */ , (var4_4 >> 1) + var2_2, var3_3 + 2 + (var5_5 + 33) * var8_8, 1 | 16, var9_9, 1);
                                    Log.e((String)"sk", (String)"drawSelectMenu");
                                    if (this.pkey.isSelect(var2_2, (var5_5 + 33) * var8_8 + var3_3, var4_4, 33)) {
                                        if (this.map.my.state != 12) break block8;
                                        if (var8_8 != var7_7) break block9;
                                        this.map.my.state = (byte)13;
                                    }
lbl22:
                                    // 7 sources

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
                        var9_9 = var6_6;
                        ** while (true)
                    }
                    var9_9 = 3;
                    ** while (true)
                }
                this.cur_a = (byte)var8_8;
                ** GOTO lbl22
            }
            if (GameRun_F.run_state != 35 && GameRun_F.run_state != 25 && this.map.my.state != 16 && GameRun_F.run_state != 65 && GameRun_F.run_state != 66 && GameRun_F.run_state != 61) ** GOTO lbl22
            if (var8_8 != var7_7) break block10;
            this.pkey.setKey5();
            ** GOTO lbl22
        }
        this.popMenu = (byte)var8_8;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawSelectMenu_(Object[] var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7) {
        block10: {
            block8: {
                block9: {
                    block7: {
                        var8_8 = 0;
                        block0: while (true) {
                            if (var8_8 >= var1_1.length) {
                                return;
                            }
                            var10_10 = Ui.i();
                            if (var8_8 != var7_7) break;
                            var9_9 = 1;
lbl8:
                            // 2 sources

                            while (true) {
                                var10_10.drawK0(var2_2, var3_3 + (var5_5 + 33) * var8_8, var4_4, 25 + 8, var9_9);
                                var10_10 = Ui.i();
                                var11_11 = var1_1[var8_8].toString();
                                if (var8_8 != var7_7) break block7;
                                var9_9 = 0;
lbl14:
                                // 2 sources

                                while (true) {
                                    var10_10.drawString(var11_11, (var4_4 >> 1) + var2_2, var3_3 + 2 + (var5_5 + 33) * var8_8, 1 | 16, var9_9, 1);
                                    GameRun_F.g.setColor(0xFF0000);
                                    if (this.pkey.isSelect(Constants_H.WIDTH * var2_2 / Constants_H.WIDTH__, ((var5_5 + 33) * var8_8 + var3_3) * Constants_H.WIDTH / Constants_H.WIDTH__, Constants_H.WIDTH * var4_4 / Constants_H.WIDTH__, Constants_H.WIDTH * 33 / Constants_H.WIDTH__)) {
                                        if (this.map.my.state != 12) break block8;
                                        if (var8_8 != var7_7) break block9;
                                        this.map.my.state = (byte)13;
                                    }
lbl21:
                                    // 7 sources

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
                        var9_9 = var6_6;
                        ** while (true)
                    }
                    var9_9 = 3;
                    ** while (true)
                }
                this.cur_a = (byte)var8_8;
                ** GOTO lbl21
            }
            if (GameRun_F.run_state != 35 && GameRun_F.run_state != 25 && this.map.my.state != 16 && GameRun_F.run_state != 65 && GameRun_F.run_state != 66) ** GOTO lbl21
            if (var8_8 != var7_7) break block10;
            this.pkey.setKey5();
            ** GOTO lbl21
        }
        this.popMenu = (byte)var8_8;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void drawSrcLine(Graphics var1_1, int var2_2, int var3_3, int var4_4, boolean var5_5, boolean var6_6) {
        block12: {
            block13: {
                block11: {
                    block15: {
                        block14: {
                            var7_7 = 0;
                            var9_8 = (byte)(var3_3 / var4_4);
                            var1_1 /* !! */ .setColor(0);
                            if (var5_5) break block13;
                            var3_3 = (short)(2 << this.src_c[0]);
                            var4_4 = (byte)(var4_4 - 1);
                            block0: while (true) {
                                if (var4_4 <= -1) {
                                    if (var6_6 && this.src_c[0] < 12) {
                                        var1_1 /* !! */  = (Graphics)this.src_c;
                                        var1_1 /* !! */ [0] = (Graphics)((byte)(var1_1 /* !! */ [0] + true));
lbl12:
                                        // 6 sources

                                        return;
                                    }
                                    break block11;
                                }
                                if (var9_8 - var3_3 > 0) break;
lbl16:
                                // 2 sources

                                while (true) {
                                    var4_4 = (byte)(var4_4 - 1);
                                    var3_3 = (short)(var3_3 / 2);
                                    continue block0;
                                    break;
                                }
                                break;
                            }
                            if (var3_3 >= 2) break block14;
                            var7_7 = 0;
lbl22:
                            // 2 sources

                            while (var3_3 < 2) {
                                var8_9 = 0;
lbl24:
                                // 2 sources

                                while (true) {
                                    var1_1 /* !! */ .fillRect(0, var4_4 * var9_8 + var2_2 + var7_7, 640, var9_8 - var8_9);
                                    ** continue;
                                    break;
                                }
lbl27:
                                // 1 sources

                                ** GOTO lbl16
                            }
                            break block15;
                        }
                        var7_7 = var3_3;
                        ** GOTO lbl22
                    }
                    var8_9 = var3_3;
                    ** while (true)
                }
                if (var6_6 || this.src_c[0] <= 0) ** GOTO lbl12
                var1_1 /* !! */  = (Graphics)this.src_c;
                var1_1 /* !! */ [0] = (Graphics)((byte)(var1_1 /* !! */ [0] - true));
                ** GOTO lbl12
            }
            var3_3 = (short)(2 << this.src_c[1]);
            block5: while (true) {
                block16: {
                    if (var5_5 && var7_7 < var4_4) break block16;
                    if (!var6_6 || this.src_c[1] >= 12) break block12;
                    var1_1 /* !! */  = (Graphics)this.src_c;
                    var1_1 /* !! */ [1] = (Graphics)((byte)(var1_1 /* !! */ [1] + true));
                    ** GOTO lbl12
                }
                if (var9_8 - var3_3 > 0) break;
lbl50:
                // 2 sources

                while (true) {
                    var7_7 = (byte)(var7_7 + 1);
                    var3_3 = (short)(var3_3 / 2);
                    continue block5;
                    break;
                }
                break;
            }
            if (var3_3 < 2) {
                var8_10 = 0;
lbl56:
                // 2 sources

                while (true) {
                    var1_1 /* !! */ .fillRect(0, var7_7 * var9_8 + var2_2, 640, var9_8 - var8_10);
                    ** continue;
                    break;
                }
            }
            var8_10 = var3_3;
            ** while (true)
        }
        if (var6_6 || this.src_c[1] <= 0) ** GOTO lbl12
        var1_1 /* !! */  = (Graphics)this.src_c;
        var1_1 /* !! */ [1] = (Graphics)((byte)(var1_1 /* !! */ [1] - true));
        ** while (true)
    }

    public void drawZero(int n, int n2, int n3, int n4) {
        Ui.i().drawString("\u70b9\u51fb\u5c4f\u5e55\u7ee7\u7eed", n, n2, n3, n4, 0);
    }

    public void drawZero(String string, int n) {
        Ui.i().drawString("\u70b9\u51fb\u5c4f\u5e55" + string, Constants_H.WIDTH_H, n, 1 | 0x20, 0, 0);
    }

    public byte getNLevel(int n) {
        return this.nidusList[1][this.getRid(n)];
    }

    public short getNexp(int n, int n2) {
        return Ms.i().getShort(this.rmsNidus, n * 5 + n2);
    }

    public byte getNid(int n) {
        return this.nidusList[0][this.getRid(n)];
    }

    public byte getRid(int n) {
        return this.rmsNidus[n * 5];
    }

    public short getSIndexW(String string) {
        byte by;
        int n = 0;
        byte by2 = 0;
        byte by3 = by = (byte)string.indexOf("#", 0);
        int n2 = n;
        byte by4 = by2;
        if (by == 0) {
            by3 = 1;
            by4 = by2;
            n2 = n;
        }
        while (by3 != -1) {
            by4 = (byte)(by4 + by3);
            by3 = (byte)string.indexOf("#", (int)by4);
            n2 = (byte)(n2 + 1);
        }
        return (short)(Ms.i().getStringWidth("#1") * n2);
    }

    /*
     * Unable to fully structure code
     */
    public void gogoWord(String var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7) {
        var8_8 = (short)(Ms.i().getStringWidth(var1_1) - this.getSIndexW(var1_1));
        if (var8_8 > 640 - var2_2 - var4_4) {
            this.introX -= var7_7;
            if (this.introX + var8_8 < var2_2) {
                this.introX = 640 - var4_4 - 75;
            }
lbl6:
            // 4 sources

            while (true) {
                GameRun_F.g.clipRect(var2_2, var3_3, 640 - var4_4 - var2_2, 30);
                Ui.i().drawStringColor(var1_1, this.introX, var3_3, var5_5, var6_6);
                GameRun_F.g.setClip(0, 0, 640, 360);
                return;
            }
        }
        this.introX = var2_2;
        ** while (true)
    }

    public void gogoWordM(String string, int n, int n2, int n3, int n4, int n5) {
        short s = (short)Ms.i().getStringWidth(string);
        this.introT -= n5;
        if (this.introT + s < n2 << 1) {
            this.introT = 640 + 1;
        }
        g.clipRect(n2, n, 640 - (n2 << 1), 30);
        Ui.i().drawString(string, this.introT, n, 0, n3, n4);
        g.setClip(0, 0, 640, 360);
    }

    public void initGraphics(Graphics graphics) {
        g = graphics;
        dg = DirectUtils.getDirectGraphics((Graphics)graphics);
    }

    public void initOffG() {
        scrT = Image.createImage((int)(Constants_H.WIDTH + 20), (int)(Constants_H.HEIGHT + 20));
        offG = scrT.getGraphics();
    }

    public void initRmsOther() {
        this.rmsOther = null;
        byte[] byArray = new byte[12];
        byArray[0] = -1;
        byArray[3] = 1;
        this.rmsOther = byArray;
    }

    /*
     * Unable to fully structure code
     */
    public byte isMyLevel(boolean var1_1) {
        switch (this.rmsOther[3]) lbl-1000:
        // 4 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                while (true) {
                    var2_2 = -1;
lbl5:
                    // 5 sources

                    return (byte)var2_2;
                }
            }
            case 1: {
                if (!var1_1 || this.monInfoList[103] <= 4) ** GOTO lbl11
                this.rmsOther[3] = 2;
                ** GOTO lbl-1000
lbl11:
                // 1 sources

                var2_2 = 5;
                ** GOTO lbl5
            }
            case 2: {
                if (!var1_1 || this.monInfoList[103] <= 9) ** GOTO lbl17
                this.rmsOther[3] = 3;
                ** GOTO lbl-1000
lbl17:
                // 1 sources

                var2_2 = 10;
                ** GOTO lbl5
            }
            case 3: {
                if (!var1_1 || this.monInfoList[103] <= 14) ** GOTO lbl23
                this.rmsOther[3] = 4;
                ** GOTO lbl-1000
lbl23:
                // 1 sources

                var2_2 = 15;
                ** GOTO lbl5
            }
            case 4: 
        }
        if (var1_1 && this.monInfoList[103] > 29) {
            this.rmsOther[3] = 5;
            ** continue;
        }
        var2_2 = 30;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void loadInfoList() {
        this.info = Ms.i().rmsOptions(6, null, 1);
        if (this.info[0] == -1) {
            this.monInfoList = new byte[105];
            var1_1 = 0;
            while (true) {
                if (var1_1 >= this.monInfoList.length) lbl-1000:
                // 2 sources

                {
                    while (true) {
                        this.info = null;
                        return;
                    }
                }
                this.monInfoList[var1_1] = 0;
                ++var1_1;
            }
        }
        this.monInfoList = this.info;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void loadItem() {
        this.info = Ms.i().rmsOptions(4, null, 1);
        this.len = new byte[]{16, 19, 23, 12};
        this.itemsLength = new byte[4];
        if (this.info[0] == -1) ** GOTO lbl8
        var1_1 = 0;
        block0: while (true) {
            block7: {
                if (var1_1 < 4) break block7;
lbl8:
                // 2 sources

                this.items = new byte[this.itemsLength.length][][];
                var1_1 = 0;
                var2_2 = 0;
lbl11:
                // 2 sources

                while (true) {
                    if (var1_1 < this.items.length) break block0;
                    this.info = null;
                    this.len = null;
                    return;
                }
            }
            this.itemsLength[var1_1] = this.info[var1_1];
            ++var1_1;
        }
        var4_4 = this.items;
        var3_3 = this.len[var1_1];
        var4_4[var1_1] = new byte[var3_3][2];
        var3_3 = 0;
        while (true) {
            if (var3_3 >= this.itemsLength[var1_1]) {
                ++var1_1;
                ** continue;
            }
            this.items[var1_1][var3_3][0] = this.info[var2_2 * 2 + 4];
            this.items[var1_1][var3_3][1] = this.info[var2_2 * 2 + 4 + 1];
            ++var3_3;
            ++var2_2;
        }
    }

    /*
     * Exception decompiling
     */
    public void loadMon(int var1_1, byte[][] var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.IllegalStateException: Backjump on non jumping statement @NONE, blocks:[] lbl20 : TryStatement: try { 1[TRYBLOCK]
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

    public void loadMon(ByteArrayInputStream byteArrayInputStream, Monster monster, byte[][] byArray) throws IOException {
        monster.monster = new byte[18];
        monster.monsterPro = new short[8];
        byteArrayInputStream.read(monster.monster);
        this.len = new byte[10];
        byteArrayInputStream.read(this.len);
        int n = 0;
        while (true) {
            if (n >= 5) {
                monster.setProAFD(byArray[monster.monster[0]]);
                this.len = null;
                return;
            }
            monster.monsterPro[n] = (short)((this.len[n * 2 + 1] & 0xFF) << 8 | this.len[n * 2 + 0] & 0xFF);
            ++n;
        }
    }

    public void loadRmsNidus() {
        this.rmsNidus = Ms.i().rmsOptions(3, null, 1);
        if (this.rmsNidus[0] == -1) {
            this.rmsNidus = null;
            byte[] byArray = new byte[25];
            byArray[0] = -2;
            byArray[3] = 10;
            byArray[4] = 10;
            byArray[5] = -2;
            byArray[8] = 10;
            byArray[9] = 10;
            byArray[10] = -2;
            byArray[13] = 10;
            byArray[14] = 10;
            byArray[15] = -2;
            byArray[18] = 10;
            byArray[19] = 10;
            byArray[20] = -2;
            byArray[23] = 10;
            byArray[24] = 10;
            this.rmsNidus = byArray;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void loadRmsOther() {
        this.info = Ms.i().rmsOptions(10, null, 1);
        if (this.info[0] == -1) {
            this.setMaxTakes(true);
            this.initRmsOther();
lbl5:
            // 2 sources

            while (true) {
                this.info = null;
                return;
            }
        }
        this.rmsOther = this.info;
        this.setMaxTakes(false);
        ** while (true)
    }

    public void loadRmsSms() {
        this.rmsSms = Ms.i().rmsOptions(5, null, 1);
        if (this.rmsSms == null || this.rmsSms[0] == -1) {
            this.rmsSms = null;
            this.rmsSms = new byte[7];
        }
        if (this.rmsSms[0] == 10) {
            byte[] byArray = this.rmsOther;
            byArray[2] = (byte)(byArray[2] | 8);
        }
    }

    public void saveInfoList() {
        Ms.i().rmsOptions(6, this.monInfoList, 2);
    }

    /*
     * Unable to fully structure code
     */
    public void saveItem() {
        block7: {
            var2_1 = 0;
            var1_2 = 0;
            block0: while (true) {
                if (var1_2 >= 4) {
                    this.info = new byte[this.items.length + var2_1 * 2];
                    var2_1 = 0;
                    var1_2 = 0;
lbl8:
                    // 2 sources

                    while (true) {
                        if (var1_2 < 4) break block0;
                        var1_2 = 0;
lbl11:
                        // 2 sources

                        while (true) {
                            if (var1_2 >= this.items.length) {
                                Ms.i().rmsOptions(4, this.info, 2);
                                this.info = null;
                                return;
                            }
                            break block7;
                            break;
                        }
                        break;
                    }
                }
                var2_1 += this.itemsLength[var1_2];
                ++var1_2;
            }
            this.info[var1_2] = this.itemsLength[var1_2];
            ++var1_2;
            ** while (true)
        }
        var3_3 = 0;
        while (true) {
            if (var3_3 >= this.itemsLength[var1_2]) {
                ++var1_2;
                ** continue;
            }
            this.info[var2_1 * 2 + 4] = this.items[var1_2][var3_3][0];
            this.info[var2_1 * 2 + 4 + 1] = this.items[var1_2][var3_3][1];
            ++var3_3;
            ++var2_1;
        }
    }

    /*
     * Exception decompiling
     */
    public void saveMon(int var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.IllegalStateException: Backjump on non jumping statement @NONE, blocks:[] lbl27 : TryStatement: try { 2[TRYBLOCK]
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

    public void saveMon(ByteArrayOutputStream byteArrayOutputStream, Monster monster) throws IOException {
        byteArrayOutputStream.write(monster.monster);
        int n = 0;
        while (n < 5) {
            short s = monster.monsterPro[n];
            byteArrayOutputStream.write((byte)(s & 0xFF));
            byteArrayOutputStream.write((byte)(s >> 8 & 0xFF));
            ++n;
        }
        return;
    }

    public void setAction_str(String[] stringArray) {
        this.action_str = stringArray;
        stringArray = null;
    }

    public void setGogoWord() {
        this.introT = Constants_H.WIDTH;
        Ms.i();
        Ms.skip = 0;
        StringBuffer[] stringBufferArray = Ms.i().createStringArray(Ms.i().getStream("data/other/hint.t", -1));
        Ms.i();
        this.gogoST = stringBufferArray[Ms.getRandom((int)stringBufferArray.length)].toString();
        stringBufferArray = null;
    }

    /*
     * Unable to fully structure code
     */
    public void setMaxTakes(boolean var1_1) {
        block4: {
            block3: {
                block2: {
                    if (var1_1) {
                        this.max_takes = (byte)3;
                        this.max_monsters = (byte)10;
lbl4:
                        // 6 sources

                        return;
                    }
                    if (this.rmsOther[3] != 2) break block2;
                    this.max_takes = (byte)4;
                    this.max_monsters = (byte)20;
                    ** GOTO lbl4
                }
                if (this.rmsOther[3] != 3) break block3;
                this.max_takes = (byte)5;
                this.max_monsters = (byte)40;
                ** GOTO lbl4
            }
            if (this.rmsOther[3] != 4) break block4;
            this.max_takes = (byte)5;
            this.max_monsters = (byte)80;
            ** GOTO lbl4
        }
        if (this.rmsOther[3] != 5) ** GOTO lbl4
        this.max_takes = (byte)5;
        this.max_monsters = (byte)95;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void setNidusExp(int var1_1) {
        if (var1_1 / 10 < 1) {
            var1_1 = 1;
lbl3:
            // 2 sources

            while (true) {
                var2_2 = 0;
lbl5:
                // 2 sources

                while (true) {
                    if (var2_2 >= 5) {
                        return;
                    }
                    ** GOTO lbl11
                    break;
                }
                break;
            }
        } else {
            var1_1 /= 10;
            ** continue;
        }
lbl11:
        // 1 sources

        if (this.getRid(var2_2) == -2) lbl-1000:
        // 3 sources

        {
            while (true) {
                var2_2 = (byte)(var2_2 + 1);
                ** continue;
                break;
            }
        }
        Ms.i().putShort(this.getNexp(var2_2, 1) + var1_1, this.rmsNidus, var2_2 * 5 + 1);
        if (this.getNexp(var2_2, 1) <= this.getNexp(var2_2, 3)) ** GOTO lbl-1000
        Ms.i().putShort((int)this.getNexp(var2_2, 3), this.rmsNidus, var2_2 * 5 + 1);
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public void setPauseS(int n) {
        if (n == 0) {
            this.setAction_str(new String[]{"\u4fdd\u5b58\u6e38\u620f", "\u67e5\u770b\u5ba0\u7269", "\u4eba\u7269\u80cc\u5305", "\u5ba0\u7269\u56fe\u9274", "\u67e5\u770b\u4efb\u52a1", "\u8fd4\u56de\u6e38\u620f"});
            return;
        }
        this.setAction_str(new String[]{"\u8bfb\u53d6\u8fdb\u5ea6", "\u58f0\u97f3", "\u6e38\u620f\u5e2e\u52a9", "\u56de\u4e3b\u83dc\u5355"});
    }

    /*
     * Unable to fully structure code
     */
    public void setStringB(String var1_1, int var2_2, int var3_3) {
        block3: {
            block2: {
                if (var3_3 == 0) {
                    this.about_a = Ms.i().groupString(var1_1, var2_2);
lbl3:
                    // 5 sources

                    return;
                }
                if (var3_3 != 1) break block2;
                this.about_b = Ms.i().groupString(var1_1, var2_2);
                ** GOTO lbl3
            }
            if (var3_3 != 2) break block3;
            this.about_c = Ms.i().groupString(var1_1, var2_2);
            ** GOTO lbl3
        }
        if (var3_3 != 3) ** GOTO lbl3
        this.about_d = Ms.i().groupString(var1_1, var2_2);
        ** while (true)
    }

    public void showString(String string, int n, int n2) {
        byte by = (byte)(string.length() / 11);
        Ui.i().drawK0(n2 - 5, n, 640 + 10, (by + 1) * 25 + 8, 3);
        this.showStringM(string, 320 + n2, n + 3, 11, 0);
    }

    public void showString(StringBuffer[] stringBufferArray, int n, int n2, int n3) {
        int n4 = Constants_H.WIDTH__;
        int n5 = Constants_H.WIDTH__ / 2;
        int n6 = n + 5;
        if (n3 != 0) {
            Ui.i().drawKuang(n2 - 5, n6, n4 + 10, stringBufferArray.length * 25 + 12);
            if (n3 == 2) {
                this.drawSnare5(n5 + n2, stringBufferArray.length * 25 + n6 + 4);
            }
        }
        n = 0;
        while (n < stringBufferArray.length) {
            Ui.i().drawStringColor(stringBufferArray[n].toString(), 25 + n2, n6 + 4 + n * 25, -1, 1);
            n = (byte)(n + 1);
        }
        return;
    }

    /*
     * Unable to fully structure code
     */
    public void showStringM(String var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        var8_6 = (byte)(var1_1.length() / var4_4);
        var6_7 = 0;
        block0: while (true) {
            if (var6_7 > var8_6) {
                return;
            }
            if (var8_6 != 0) break;
            Ui.i().drawString(var1_1, var2_2, var3_3, 1 | 16, var5_5, 1);
            Log.e((String)"sk", (String)"strNum == 0");
lbl10:
            // 2 sources

            while (true) {
                var6_7 = (byte)(var6_7 + 1);
                continue block0;
                break;
            }
            break;
        }
        var9_9 = Ui.i();
        if (var6_7 + 1 > var8_6) {
            var7_8 = var1_1.length();
lbl16:
            // 2 sources

            while (true) {
                var9_9.drawString(var1_1.substring(var6_7 * var4_4, var7_8), var2_2, var3_3 + var6_7 * 25, 1 | 16, var5_5, 0);
                Log.e((String)"sk", (String)"else");
                ** continue;
                break;
            }
        }
        var7_8 = (var6_7 + 1) * var4_4;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void showStringM_(String var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        var8_6 = (byte)(var1_1.length() / var4_4);
        var6_7 = 0;
        block0: while (true) {
            if (var6_7 > var8_6) {
                return;
            }
            if (var8_6 != 0) break;
            Ui.i().drawString(var1_1, var2_2, var3_3, 1 | 16, var5_5, 1);
            Log.e((String)"sk", (String)"strNum == 0");
lbl10:
            // 2 sources

            while (true) {
                var6_7 = (byte)(var6_7 + 1);
                continue block0;
                break;
            }
            break;
        }
        var9_9 = Ui.i();
        if (var6_7 + 1 > var8_6) {
            var7_8 = var1_1.length();
lbl16:
            // 2 sources

            while (true) {
                var9_9.drawString(var1_1.substring(var6_7 * var4_4, var7_8), var2_2, var3_3 + var6_7 * 25, 1 | 16, var5_5, 0);
                ** continue;
                break;
            }
        }
        var7_8 = (var6_7 + 1) * var4_4;
        ** while (true)
    }
}
