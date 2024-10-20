/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.nokia.mid.ui.DirectGraphics
 *  com.nokia.mid.ui.DirectUtils
 *  dm.Ms
 *  dm.Sprite
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 *  main.Constants_H
 */
package dm;

import android.util.Log;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import dm.Ms;
import dm.Sprite;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Constants_H;

public class Ui {
    public static DirectGraphics dg;
    public static Graphics g;
    private static final short[] transforms;
    private static Ui uiListener;
    private int[] MIRROR;
    private byte[][] MIRROR2;
    private byte[] MIRROR3;
    public byte cTriangle;
    private byte rz;
    private Image ui_img;
    private short[][] ui_modules;

    static {
        short[] sArray = new short[8];
        sArray[1] = 5;
        sArray[2] = 3;
        sArray[3] = 6;
        sArray[4] = 2;
        sArray[5] = 4;
        sArray[6] = 1;
        sArray[7] = 7;
        transforms = sArray;
    }

    public Ui() {
        byte[] byArray = new byte[8];
        byArray[1] = 1;
        byArray[2] = 2;
        byArray[3] = 3;
        byArray[4] = 4;
        byArray[5] = 5;
        byArray[6] = 6;
        byArray[7] = 7;
        byte[] byArray2 = new byte[8];
        byArray2[0] = 4;
        byArray2[1] = 5;
        byArray2[2] = 6;
        byArray2[3] = 7;
        byArray2[5] = 1;
        byArray2[6] = 2;
        byArray2[7] = 3;
        this.MIRROR2 = new byte[][]{byArray, byArray2};
        this.MIRROR3 = new byte[]{1, -1};
        this.MIRROR = new int[]{4 | 0x10, 8 | 0x10};
        this.cTriangle = 0;
        uiListener = this;
    }

    public static Ui i() {
        if (uiListener == null) {
            uiListener = new Ui();
        }
        return uiListener;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean drawActionOne(Sprite sprite, int n, int n2, int n3, byte[] byArray, int n4, boolean bl) {
        byte by;
        this.drawFrameOne(sprite, sprite.action(n, (int)byArray[0], 0), n2, n3, n4);
        byArray[1] = by = (byte)(byArray[1] + 1);
        if (by <= sprite.action(n, (int)byArray[0], 1)) return false;
        byArray[1] = 0;
        byArray[0] = by = (byte)(byArray[0] + 1);
        if (by < sprite.aLength(n)) return false;
        if (!bl) {
            byArray[0] = (byte)(sprite.aLength(n) - 1);
            return true;
        }
        byArray[0] = 0;
        return false;
    }

    public void drawBDir(int n, int n2, int n3, int n4) {
        g.setColor(8310516);
        g.drawRect(n, n2, n3 * 3, n4 << 1);
        g.drawRect(n + n3, n2, n3, n4 << 1);
        g.drawLine((float)n, (float)(n2 + n4), (float)(n3 * 3 + n), (float)(n2 + n4));
    }

    /*
     * Unable to fully structure code
     */
    public void drawBarOne(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6) {
        block4: {
            var7_7 = 16125468;
            if (var6_6 == 1) {
                var7_7 = 55551;
lbl4:
                // 3 sources

                while (true) {
                    this.fillRect(4067649, var1_1 + 1, var2_2, var3_3 - 1, 5);
                    Ui.g.drawRect(var1_1, var2_2 + 1, var3_3, 5 - 3);
                    var3_3 = 5 - 2;
                    this.fillRect(16752385, var1_1 + 1, var2_2 + 1, var4_4, var3_3);
                    if (var4_4 > var5_5) lbl-1000:
                    // 2 sources

                    {
                        while (true) {
                            this.fillRect(var7_7, var1_1 + 1, var2_2 + 1, var5_5, var3_3);
                            return;
                        }
                    }
                    break block4;
                    break;
                }
            }
            if (var6_6 != 2) ** GOTO lbl4
            var7_7 = 60177;
            ** while (true)
        }
        var5_5 = var4_4;
        ** while (true)
    }

    public void drawFrameOne(Sprite sprite, int n, int n2, int n3, int n4) {
        int n5 = 0;
        while (n5 < sprite.fLength(n)) {
            this.drawModuleOne(sprite, sprite.frame(n, n5, 0), n2 + sprite.frame(n, n5, 1) * this.MIRROR3[n4], n3 + sprite.frame(n, n5, 2), n4, sprite.frame(n, n5, 3));
            n5 = (short)(n5 + 1);
        }
        return;
    }

    public void drawImage(Image image, int n, int n2, int n3) {
        g.drawImage(image, n, n2, n3);
    }

    /*
     * Enabled force condition propagation
     */
    public void drawImage(Image image, int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            g.drawImage(image, n, n2, n3);
            return;
        }
        dg.drawImage(image, n, n2, n3, n4);
    }

    /*
     * Unable to fully structure code
     */
    public void drawK(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        block5: {
            block4: {
                block3: {
                    block2: {
                        if (var5_5 == 0) {
                            var5_5 = 15400191;
lbl3:
                            // 6 sources

                            while (true) {
                                Ui.g.setColor(var5_5);
                                Ui.g.fillRect(var1_1 + 1, var2_2, var3_3 - 2, var4_4);
                                Ui.g.fillRect(var1_1, var2_2 + 1, var3_3, var4_4 - 2);
                                return;
                            }
                        }
                        if (var5_5 != 1) break block2;
                        var5_5 = 12352252;
                        ** GOTO lbl3
                    }
                    if (var5_5 != 2) break block3;
                    var5_5 = 12313343;
                    ** GOTO lbl3
                }
                if (var5_5 != 3) break block4;
                var5_5 = 5228543;
                ** GOTO lbl3
            }
            if (var5_5 != 4) break block5;
            var5_5 = 30975;
            ** GOTO lbl3
        }
        var5_5 = 11121884;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawK0(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        var6_6 = (byte)var5_5;
        if (var5_5 == 2) {
            var5_5 = 15400191;
lbl4:
            // 2 sources

            while (true) {
                Ui.g.setColor(var5_5);
                Ui.g.drawRect(var1_1 + 1, var2_2, var3_3 - 3, var4_4 - 1);
                Ui.g.drawRect(var1_1, var2_2 + 1, var3_3 - 1, var4_4 - 3);
                this.drawK(var1_1 + 1, var2_2 + 1, var3_3 - 2, var4_4 - 2, var6_6);
                return;
            }
        }
        var5_5 = 1908277;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawK1(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        block6: {
            block5: {
                var7_6 = Ui.g;
                if (var5_5 == 0) {
                    var6_7 = 0x535453;
lbl4:
                    // 2 sources

                    while (true) {
                        var7_6.setColor(var6_7);
                        Ui.g.drawRect(var1_1, var2_2 + 2, var3_3, var4_4 - 3);
                        Ui.g.drawLine((float)(var1_1 + 1), (float)(var2_2 + var4_4), (float)(var1_1 + var3_3 - 1), (float)(var2_2 + var4_4));
                        if (var5_5 == 0 || var5_5 == 1) {
                            var5_5 = 15400191;
lbl10:
                            // 4 sources

                            while (true) {
                                Ui.g.setColor(var5_5);
                                Ui.g.fillRect(var1_1 + 1, var2_2, var3_3 - 2, var4_4);
                                Ui.g.fillRect(var1_1, var2_2 + 1, var3_3, var4_4 - 2);
                                return;
                            }
                        }
                        break;
                    }
                } else {
                    var6_7 = 1908277;
                    ** continue;
                }
                if (var5_5 != 2) break block5;
                var5_5 = 13892607;
                ** GOTO lbl10
            }
            if (var5_5 != 3) break block6;
            var5_5 = 7727871;
            ** GOTO lbl10
        }
        var5_5 = 12352252;
        ** while (true)
    }

    public void drawK2(int n, int n2, int n3, int n4, int n5) {
        if (n5 == 0) {
            // empty if block
        }
        g.setColor(0);
        g.fillRect(n, n2, n3, n4);
        g.setColor(30975);
        g.fillRect(n + 2, n2 + 2, n3 - 4, n4 - 4);
    }

    public void drawK3(int n, int n2, int n3, int n4) {
        this.drawK0(n, n2, n3 - 1, n4 - 1, 0);
        g.setColor(1908277);
        g.fillRect(n + 2, n2 + 2, n3 - 2, n4 - 2);
    }

    public void drawK4(int n, int n2, int n3, int n4) {
        g.setColor(16771373);
        g.drawLine((float)(n + 1), (float)n2, (float)(n + n3 - 2), (float)n2);
        g.drawLine((float)(n + 1), (float)(n2 + n4 - 1), (float)(n + n3 - 2), (float)(n2 + n4 - 1));
        g.drawLine((float)n, (float)(n2 + 1), (float)n, (float)(n2 + n4 - 2));
        g.drawLine((float)(n + n3 - 1), (float)(n2 + 1), (float)(n + n3 - 1), (float)(n2 + n4 - 2));
        g.drawLine((float)n, (float)(n2 + 1), (float)(n + 1), (float)(n2 + 1));
        g.drawLine((float)(n + n3 - 2), (float)(n2 + 1), (float)(n + n3 - 1), (float)(n2 + 1));
        g.drawLine((float)n, (float)(n2 + n4 - 2), (float)(n + 1), (float)(n2 + n4 - 2));
        g.drawLine((float)(n + n3 - 2), (float)(n2 + n4 - 2), (float)(n + n3 - 2), (float)(n2 + n4 - 2));
    }

    public void drawKuang(int n, int n2, int n3, int n4) {
        g.setColor(1908277);
        g.drawRect(n + 1, n2, n3 - 4, n4 - 2);
        g.drawRect(n + 2, n2 + 1, n3 - 4, n4 - 2);
        g.drawLine((float)n, (float)(n2 + 1), (float)n, (float)(n2 + n4 - 3));
        g.drawLine((float)(n + n3 - 1), (float)(n2 + 2), (float)(n + n3 - 1), (float)(n2 + n4 - 2));
        this.fillRect(15400191, n + 1, n2 + 1, n3 - 3, n4 - 3);
    }

    /*
     * Unable to fully structure code
     */
    public void drawKuangAdorn(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        block2: {
            if (var5_5 == 0) {
                Ui.g.setColor(1842484);
                Ui.g.drawRect(var1_1 + 20, var2_2 - 22, var3_3 - 21, 20);
                Ui.g.drawRect(var1_1 + 20, var2_2 - 22, var3_3 - 22, 21);
                this.fillRect(15129744, var1_1 + 20, var2_2 - 22, var3_3 - 22, 20);
                this.drawUi(33, var1_1, var2_2, 36, 0);
                this.drawUi(31, var1_1 + var3_3 - 4, var2_2, 36, 0);
lbl8:
                // 4 sources

                return;
            }
            if (var5_5 != 1) break block2;
            this.drawUi(32, var1_1, var2_2 - 7, 0, 0);
            this.drawUi(32, var1_1 + var3_3 + 5, var2_2 - 7, 8 | 16, 0);
            this.fillRect(13550445, var1_1 + 15, var2_2 - 5, var3_3 - 25, 13);
            this.fillRect(16116383, var1_1 + 15, var2_2 - 3, var3_3 - 25, 10);
            this.fillRect(13078326, var1_1 + 15, var2_2 + 10, var3_3 - 25, 5);
            this.drawLine(1842484, var1_1 + 15, var2_2 - 7, var1_1 + var3_3 - 11, var2_2 - 7);
            this.drawLine(16446403, var1_1 + 15, var2_2 - 6, var1_1 + var3_3 - 11, var2_2 - 6);
            this.drawLine(6168835, var1_1 + 15, var2_2 + 12, var1_1 + var3_3 - 11, var2_2 + 12);
            Ui.g.setColor(13281366);
            Ui.g.drawRect(var1_1 + 15, var2_2 + 8, var3_3 - 26, 1);
            ** GOTO lbl8
        }
        if (var5_5 != 2) ** GOTO lbl8
        this.drawUi(32, var1_1, var2_2 + var4_4 - 1, 36, 6);
        this.drawUi(32, var1_1 + var3_3 + 5, var2_2 + var4_4 - 1, 40, 6);
        this.fillRect(13550445, var1_1 + 15, var2_2 + var4_4 - 16, var3_3 - 25, 13);
        this.fillRect(16116383, var1_1 + 15, var2_2 + var4_4 - 15, var3_3 - 25, 10);
        this.fillRect(13078326, var1_1 + 15, var2_2 + var4_4 - 23, var3_3 - 25, 5);
        this.drawLine(1842484, var1_1 + 15, var2_2 + var4_4 - 2, var1_1 + var3_3 - 11, var2_2 + var4_4 - 2);
        this.drawLine(16446403, var1_1 + 15, var2_2 + var4_4 - 3, var1_1 + var3_3 - 11, var2_2 + var4_4 - 3);
        this.drawLine(6168835, var1_1 + 15, var2_2 + var4_4 - 21, var1_1 + var3_3 - 11, var2_2 + var4_4 - 21);
        Ui.g.setColor(13281366);
        Ui.g.drawRect(var1_1 + 15, var2_2 + var4_4 - 18, var3_3 - 26, 1);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawKuangMap(int var1_1, int var2_2, int var3_3, int var4_4, boolean var5_5) {
        if (var5_5) {
            var6_6 = 14961;
lbl3:
            // 2 sources

            while (true) {
                this.fillRect(var6_6, var1_1, var2_2, var3_3, var4_4);
                if (var5_5) {
                    var6_6 = 0x6699FF;
lbl7:
                    // 2 sources

                    while (true) {
                        this.fillRect(var6_6, var1_1 + 1, var2_2 + 1, var3_3 - 2, var4_4 - 2);
                        return;
                    }
                }
                break;
            }
        } else {
            var6_6 = 16762112;
            ** continue;
        }
        var6_6 = 11370036;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawKuangSelect(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        block4: {
            block3: {
                block2: {
                    var6_6 = 13281366;
                    if (var5_5 == 1) {
                        var6_6 = 11370036;
lbl4:
                        // 6 sources

                        while (true) {
                            Ui.g.setColor(var6_6);
                            Ui.g.fillRect(var1_1 + 1, var2_2, var3_3 - 2, var4_4);
                            Ui.g.drawRect(var1_1, var2_2 + 1, var3_3 - 1, var4_4 - 3);
                            return;
                        }
                    }
                    if (var5_5 != 2) break block2;
                    var6_6 = 2233088;
                    ** GOTO lbl4
                }
                if (var5_5 != 3) break block3;
                var6_6 = 15129744;
                ** GOTO lbl4
            }
            if (var5_5 != 4) break block4;
            var6_6 = 16762112;
            ** GOTO lbl4
        }
        if (var5_5 != 5) ** GOTO lbl4
        var6_6 = 6168835;
        ** while (true)
    }

    public void drawLine(int n, int n2, int n3, int n4, int n5) {
        g.setColor(n);
        g.drawLine((float)n2, (float)n3, (float)n4, (float)n5);
    }

    public void drawListKY(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        int n11 = 0;
        while (true) {
            if (n11 >= n) {
                if (n8 != -1) {
                    this.drawK1(n2, n3 + (n6 + n7) * n8, n4, n6, n9);
                }
                return;
            }
            if (n11 != n8) {
                this.drawK0(n2 + n5, n3 + (n6 + n7) * n11, n4 - (n5 << 1), n6, n10);
            }
            n11 = (byte)(n11 + 1);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void drawListSY(Object[] var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7, int var8_8, int var9_9) {
        var10_10 = 0;
        block0: while (true) {
            if (var10_10 >= var1_1.length) {
                Log.e((String)"sk", (String)"drawListSY");
                return;
            }
            var12_12 = var1_1[var10_10].toString();
            if (var10_10 != var6_6) break;
            var11_11 = var7_7;
lbl10:
            // 2 sources

            while (true) {
                this.drawString(var12_12, var2_2 + (var4_4 >> 1), var10_10 * var5_5 + (var3_3 + 2), 17, var11_11, var9_9);
                var10_10 = (byte)(var10_10 + 1);
                continue block0;
                break;
            }
            break;
        }
        var11_11 = var8_8;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawListSYHasSound(Object[] var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7, int var8_8, int var9_9) {
        block4: {
            var10_10 = 0;
            block0: while (true) {
                if (var10_10 >= var1_1.length) {
                    return;
                }
                var13_13 = var1_1[var10_10].toString();
                if (!var1_1[var10_10].toString().equals("\u58f0\u97f3")) break;
                var11_11 = 20;
lbl8:
                // 2 sources

                while (var10_10 == var6_6) {
                    var12_12 = var7_7;
lbl10:
                    // 2 sources

                    while (true) {
                        this.drawString(var13_13, var2_2 + (var4_4 >> 1), var10_10 * var5_5 + (var3_3 + 2), var11_11, var12_12, var9_9);
                        var10_10 = (byte)(var10_10 + 1);
                        continue block0;
                        break;
                    }
                    continue block0;
                }
                break block4;
                break;
            }
            var11_11 = 17;
            ** GOTO lbl8
        }
        var12_12 = var8_8;
        ** while (true)
    }

    public void drawModuleOne(Sprite sprite, int n, int n2, int n3, int n4, int n5) {
        this.drawRegion(sprite.img, sprite.module(n, 0), sprite.module(n, 1), sprite.module(n, 2), sprite.module(n, 3), n2, n3, this.MIRROR[n4], this.MIRROR2[n4][n5], g);
    }

    /*
     * Unable to fully structure code
     */
    public void drawNum(String var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        block15: {
            block16: {
                block26: {
                    block17: {
                        block14: {
                            block25: {
                                block24: {
                                    block22: {
                                        block23: {
                                            block21: {
                                                block12: {
                                                    block20: {
                                                        block13: {
                                                            block19: {
                                                                block11: {
                                                                    block18: {
                                                                        if (var1_1.length() == 0) lbl-1000:
                                                                        // 3 sources

                                                                        {
                                                                            return;
                                                                        }
                                                                        if (var4_4 != 0) break block18;
                                                                        var7_6 = 0;
lbl6:
                                                                        // 2 sources

                                                                        while (true) {
                                                                            var9_7 = var7_6;
                                                                            var10_8 = 0;
lbl9:
                                                                            // 2 sources

                                                                            block2: while (true) {
                                                                                if (var5_5 != 0) break block11;
                                                                                var8_10 = 8;
lbl12:
                                                                                // 3 sources

                                                                                while (true) {
                                                                                    var7_6 = -1;
                                                                                    var6_9 = var1_1.charAt(var9_7);
                                                                                    if (var6_9 < '0' || var6_9 > '9') break block12;
                                                                                    var7_6 = (byte)(var6_9 - 48);
                                                                                    if (var5_5 != 0) break block13;
                                                                                    var7_6 = (byte)(var7_6 + 10);
lbl19:
                                                                                    // 9 sources

                                                                                    while (var7_6 != -1) {
                                                                                        if (var4_4 != 0) break block14;
                                                                                        this.drawUi(var7_6, var2_2 + var10_8, var3_3, 36, 0);
lbl22:
                                                                                        // 2 sources

                                                                                        while (true) {
                                                                                            var7_6 = (short)(var10_8 + var8_10);
lbl24:
                                                                                            // 2 sources

                                                                                            while (var4_4 == 0) {
                                                                                                var8_10 = (byte)(var9_7 + 1);
lbl26:
                                                                                                // 2 sources

                                                                                                while (var4_4 == 0) {
                                                                                                    var9_7 = var8_10;
                                                                                                    var10_8 = var7_6;
                                                                                                    if (var8_10 < var1_1.length()) continue block2;
                                                                                                    ** GOTO lbl-1000
                                                                                                }
                                                                                                break block15;
                                                                                            }
                                                                                            break block16;
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    break block17;
                                                                                    break;
                                                                                }
                                                                                break;
                                                                            }
                                                                            break;
                                                                        }
                                                                    }
                                                                    var7_6 = var1_1.length() - 1;
                                                                    ** while (true)
                                                                }
                                                                if (var5_5 != 1) break block19;
                                                                var8_10 = 10;
                                                                ** GOTO lbl12
                                                            }
                                                            var8_10 = 14;
                                                            ** while (true)
                                                        }
                                                        if (var5_5 != 1) break block20;
                                                        var7_6 = (byte)(var7_6 + 35);
                                                        ** GOTO lbl19
                                                    }
                                                    var7_6 = (byte)(var7_6 + 57);
                                                    ** GOTO lbl19
                                                }
                                                if (var6_9 != '/') break block21;
                                                var7_6 = 20;
                                                ** GOTO lbl19
                                            }
                                            if (var6_9 != '-') break block22;
                                            if (var5_5 != 2) break block23;
                                            var7_6 = 56;
lbl59:
                                            // 2 sources

                                            while (true) {
                                                var7_6 = (byte)var7_6;
                                                ** GOTO lbl19
                                                break;
                                            }
                                        }
                                        var7_6 = 46;
                                        ** while (true)
                                    }
                                    if (var6_9 != '+') break block24;
                                    var7_6 = 47;
                                    ** GOTO lbl19
                                }
                                if (var6_9 != '%') break block25;
                                var7_6 = 45;
                                var8_10 = 14;
                                ** GOTO lbl19
                            }
                            if (var6_9 != '\u7ea7') ** GOTO lbl19
                            var7_6 = 29;
                            var8_10 = 12;
                            ** GOTO lbl19
                        }
                        this.drawUi(var7_6, var2_2 - var10_8, var3_3, 40, 0);
                        ** while (true)
                    }
                    if (var4_4 != 0) break block26;
                    this.drawString("" + var6_9, var2_2 + var10_8, var3_3 + 5, 36, 3, 0);
lbl85:
                    // 2 sources

                    while (true) {
                        var7_6 = (short)(var10_8 + 25);
                        ** GOTO lbl24
                        break;
                    }
                }
                this.drawString("" + var6_9, var2_2 - var10_8, var3_3 + 5, 40, 3, 0);
                ** while (true)
            }
            var8_10 = (byte)(var9_7 - 1);
            ** GOTO lbl26
        }
        var9_7 = var8_10;
        var10_8 = var7_6;
        if (var8_10 <= -1) ** break;
        ** while (true)
        ** while (true)
    }

    public void drawRect(int n, int n2, int n3, int n4, int n5) {
        g.setColor(n);
        g.drawRect(n2, n3, n4, n5);
    }

    public void drawRectZ(int n, int n2, int n3, int n4, int n5, int n6) {
        byte by;
        g.setColor(n);
        Graphics graphics = g;
        Ms.i();
        int n7 = Ms.abs((int)this.rz);
        Ms.i();
        n = Ms.abs((int)this.rz);
        Ms.i();
        int n8 = Ms.abs((int)this.rz);
        Ms.i();
        graphics.drawRect(n2 - n7, n3 - n, (n8 << 1) + n4, (Ms.abs((int)this.rz) << 1) + n5);
        this.rz = by = (byte)(this.rz + 1);
        if (by > n6) {
            this.rz = (byte)(-n6);
        }
    }

    public void drawRegion(Image image, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Graphics graphics) {
        graphics.drawRegion(image, n, n2, n3, n4, (int)transforms[n8], n5, n6, n7);
    }

    /*
     * Unable to fully structure code
     */
    public void drawString(String var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6) {
        var7_7 = 13281366;
        var8_8 = 3676168;
        var9_9 = var3_3 + 1;
        switch (var5_5) {
            default: {
                var5_5 = var8_8;
                var3_3 = var7_7;
lbl8:
                // 12 sources

                while (true) {
                    if (var6_6 == 2) {
                        Ui.g.setColor(var3_3);
                        Ui.g.drawString(var1_1, var2_2 - 1, var9_9, var4_4);
                        Ui.g.drawString(var1_1, var2_2 + 1, var9_9, var4_4);
                        Ui.g.drawString(var1_1, var2_2, var9_9 - 1, var4_4);
                        Ui.g.drawString(var1_1, var2_2, var9_9 + 1, var4_4);
                        Ui.g.drawString(var1_1, var2_2 + 1, var9_9 + 1, var4_4);
                        Ui.g.drawString(var1_1, var2_2 - 1, var9_9 + 1, var4_4);
                        Ui.g.drawString(var1_1, var2_2 - 1, var9_9 - 1, var4_4);
                        Ui.g.drawString(var1_1, var2_2 + 1, var9_9 - 1, var4_4);
                    }
                    Ui.g.setColor(var5_5);
                    if (var6_6 == 1) {
                        Ui.g.drawString(var1_1, var2_2 + 1, var9_9, var4_4);
                    }
                    Ui.g.drawString(var1_1, var2_2, var9_9, var4_4);
                    return;
                }
            }
            case 0: {
                var3_3 = 0;
                var5_5 = 0xFFFFFF;
                ** GOTO lbl8
            }
            case 1: {
                var3_3 = 0x535453;
                var5_5 = 7727871;
                ** GOTO lbl8
            }
            case 2: {
                var3_3 = 2707928;
                var5_5 = 43016;
                ** GOTO lbl8
            }
            case 3: {
                var3_3 = 1908277;
                var5_5 = 24295;
                ** GOTO lbl8
            }
            case 4: {
                var3_3 = 1314307;
                var5_5 = 5228543;
                ** GOTO lbl8
            }
            case 5: {
                var3_3 = 2233603;
                var5_5 = 16739328;
                ** GOTO lbl8
            }
            case 6: {
                var3_3 = 8075577;
                var5_5 = 16189448;
                ** GOTO lbl8
            }
            case 7: {
                var3_3 = 4467457;
                var5_5 = 16757760;
                ** GOTO lbl8
            }
            case 8: {
                var3_3 = 10122756;
                var5_5 = 0xC000FF;
                ** GOTO lbl8
            }
            case 9: {
                var3_3 = 11563064;
                var5_5 = 3676168;
                ** GOTO lbl8
            }
            case 10: 
        }
        var3_3 = 1311269;
        var5_5 = 0x868686;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawStringColor(String var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        var6_6 = (byte)var4_4;
        var7_7 = 0;
        var8_8 = 0;
        while ((var12_12 = (byte)var1_1.indexOf("#", var7_7)) != -1) {
            var13_13 = var1_1.substring(var7_7, var12_12);
            this.drawString(var13_13, var2_2 + var8_8, var3_3, 0, var6_6, var5_5);
            var9_9 = (short)(Ms.i().getStringWidth(var13_13) + var8_8);
            var11_11 = (byte)(Integer.parseInt(var1_1.substring(var12_12 + 1, var12_12 + 2)) - 1);
            var10_10 = (byte)(var12_12 + 2);
            var6_6 = var11_11;
            var7_7 = var10_10;
            var8_8 = var9_9;
            if (var11_11 == -1) {
                var6_6 = (byte)var4_4;
                var8_8 = var9_9;
                var7_7 = var10_10;
            }
lbl17:
            // 4 sources

            while (var12_12 == -1) {
                return;
            }
        }
        this.drawString(var1_1.substring(var7_7, var1_1.length()), var2_2 + var8_8, var3_3, 0, var6_6, var5_5);
        ** GOTO lbl17
    }

    public void drawStringY(Object[] objectArray, int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        byte by = (byte)n3;
        while (by < n4 && by < objectArray.length) {
            Ui.i().drawString(objectArray[by].toString(), n, n2 + (by - n3) * n5, 0, n6, n7);
            by = (byte)(by + 1);
        }
        return;
    }

    public void drawStringY(StringBuffer[] stringBufferArray, int n, int n2, int n3, int n4, int n5) {
        int n6 = 0;
        while (n6 < stringBufferArray.length) {
            this.drawStringColor(stringBufferArray[n6].toString(), n, n2 + 4 + n6 * n3, n4, n5);
            n6 = (byte)(n6 + 1);
        }
        return;
    }

    public void drawTriangle(int n, int n2, int n3, boolean bl, boolean bl2) {
    }

    public void drawTriangle1(int n, int n2, int n3, boolean bl, boolean bl2) {
        Ms.i();
        this.drawUi(30, n - n3 - Ms.abs((int)this.cTriangle), n2, 4 | 2, 4);
        Ms.i();
        this.drawUi(30, Ms.abs((int)this.cTriangle) + (n + n3), n2, 8 | 2, 0);
        if (bl2) {
            byte by;
            this.cTriangle = by = (byte)(this.cTriangle + 1);
            if (by > 4) {
                this.cTriangle = (byte)-3;
            }
        }
    }

    public void drawUi(int n, int n2, int n3, int n4, int n5) {
        this.drawRegion(this.ui_img, this.ui_modules[n][0], this.ui_modules[n][1], this.ui_modules[n][2], this.ui_modules[n][3], n2, n3, n4, n5, g);
    }

    /*
     * Unable to fully structure code
     */
    public void drawVolume(int var1_1, int var2_2, int var3_3, boolean var4_4) {
        var6_5 = Ui.g;
        if (var4_4) {
            var5_6 = 458827;
lbl4:
            // 2 sources

            while (true) {
                var6_5.setColor(var5_6);
                Ui.g.drawRect(var1_1 - 1 + 3, var2_2 + 5, 7, 10);
                Ui.g.drawRect(var1_1 + 5 + 2 + 3, var2_2 + 2, 7, 13);
                Ui.g.drawRect(var1_1 + 11 + 4 + 3, var2_2 - 1, 8, 16);
                var6_5 = Ui.g;
                if (var4_4) {
                    var5_6 = 16048400;
lbl12:
                    // 2 sources

                    while (true) {
                        var6_5.setColor(var5_6);
                        Ui.g.drawRect(var1_1 + 3, var2_2 + 6, 6, 8);
                        Ui.g.drawRect(var1_1 + 6 + 2 + 3, var2_2 + 3, 6, 11);
                        Ui.g.drawRect(var1_1 + 12 + 4 + 3, var2_2, 6, 14);
                        if (var3_3 > 0) {
                            Ui.g.fillRect(var1_1 + 1 + 3, var2_2 + 7, 5, 7);
                        }
                        if (var3_3 > 30) {
                            Ui.g.fillRect(var1_1 + 7 + 2 + 3, var2_2 + 4, 5, 10);
                        }
                        if (var3_3 > 60) {
                            Ui.g.fillRect(var1_1 + 13 + 4 + 3, var2_2 + 1, 5, 13);
                        }
                        return;
                    }
                }
                break;
            }
        } else {
            var5_6 = 11563064;
            ** continue;
        }
        var5_6 = 3676168;
        ** while (true)
    }

    public void drawYesNo(boolean bl, boolean bl2) {
        if (bl) {
            this.drawUi(27, 0, 360, 36, 0);
        }
        if (bl2) {
            this.drawUi(28, 640, 360, 40, 0);
        }
    }

    public void drawYesNo_(boolean bl, boolean bl2) {
        if (bl) {
            this.drawUi(27, 0, Constants_H.HEIGHT, 36, 0);
        }
        if (bl2) {
            this.drawUi(28, Constants_H.WIDTH, Constants_H.HEIGHT, 40, 0);
        }
    }

    public void drawYesNo__(boolean bl, boolean bl2) {
        int n = Constants_H.WIDTH__;
        int n2 = Constants_H.HEIGHT__;
        if (bl) {
            this.drawUi(27, 0, n2, 36, 0);
        }
        if (bl2) {
            this.drawUi(28, n, n2, 40, 0);
        }
    }

    public void fillArc(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        g.setColor(n);
        g.fillArc(n2, n3, n4, n5, n6, n7);
    }

    public void fillRect(int n, int n2, int n3, int n4, int n5) {
        g.setColor(n);
        g.fillRect(n2, n3, n4, n5);
    }

    public void fillRectB() {
        this.fillRect(5422575, 0, 0, 640, 360);
    }

    public void initGraphics(Graphics graphics) {
        g = graphics;
        dg = DirectUtils.getDirectGraphics((Graphics)graphics);
    }

    public void initUiModules() {
        this.ui_img = Ms.i().createImage("data/ui");
        Ms.i();
        Ms.skip = 0;
        this.ui_modules = Ms.i().createShort2Array(Ms.i().getStream("data/ui_m.d", -1), 0);
    }

    /*
     * Unable to fully structure code
     */
    public void sliding(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5, boolean var6_6) {
        block13: {
            block14: {
                block12: {
                    block11: {
                        if (!var6_6) {
                            this.drawK(var1_1 - 2, var2_2 - 2, 10 + 4, var3_3 + 4, 0);
                        }
                        if (var6_6) {
                            var7_7 = 0;
lbl5:
                            // 2 sources

                            while (true) {
                                this.drawK(var1_1, var2_2, 10, var3_3, var7_7);
                                if (!var6_6) break block11;
                                var7_7 = 3;
lbl9:
                                // 2 sources

                                while (true) {
                                    this.drawK(var1_1, var2_2, 10, 11, var7_7);
                                    if (!var6_6) break block12;
                                    var7_7 = 3;
lbl13:
                                    // 2 sources

                                    while (true) {
                                        this.drawK(var1_1, var2_2 + var3_3 - 11, 10, 11, var7_7);
                                        var7_7 = var3_3 - 22;
                                        var8_8 = var5_5 - 1;
                                        if (var8_8 >= 1) break block13;
                                        if (var6_6) {
                                            var3_3 = 3;
lbl20:
                                            // 2 sources

                                            while (true) {
                                                this.drawK(var1_1 + 1, var2_2 + 12, 10 - 2, var7_7 - 2, var3_3);
lbl22:
                                                // 2 sources

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
                        var7_7 = 3;
                        ** while (true)
                    }
                    var7_7 = 0;
                    ** while (true)
                }
                var7_7 = 0;
                ** while (true)
            }
            var3_3 = 0;
            ** while (true)
        }
        var3_3 = var5_5 = (int)((byte)(var7_7 / (var8_8 + 1)));
        if (var5_5 < 15) {
            var3_3 = 15;
        }
        var5_5 = (short)((var7_7 - 2 - var3_3) * var4_4 / var8_8);
        if (var6_6) {
            var4_4 = 3;
lbl43:
            // 2 sources

            while (true) {
                this.drawK(var1_1 + 1, var2_2 + 12 + var5_5, 10 - 2, var3_3, var4_4);
                ** continue;
                break;
            }
        }
        var4_4 = 0;
        ** while (true)
    }
}
