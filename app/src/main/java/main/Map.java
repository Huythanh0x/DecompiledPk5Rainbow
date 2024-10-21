/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  dm.Ms
 *  dm.Npc
 *  dm.Sound
 *  dm.Sprite
 *  dm.Ui
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 *  main.Constants_H
 *  main.GameRun
 *  main.Key_H
 *  main.MainCanvas
 *  main.PointerKey
 *  main.SMSSender
 *  minigame.Mg
 */
package main;

import android.util.Log;
import dm.Ms;
import dm.Npc;
import dm.Sound;
import dm.Sprite;
import dm.Ui;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Constants_H;
import main.GameRun;
import main.Key_H;
import main.MainCanvas;
import main.PointerKey;
import main.SMSSender;
import minigame.Mg;

public class Map
implements Key_H {
    private static Npc cur_npc;
    private static Graphics g;
    static Sprite[][] npcSp;
    private byte action_5;
    private byte anoleSel;
    public byte anole_temp;
    public byte anole_type;
    public boolean bDirTalk;
    boolean bExitBoss = false;
    public byte[] bMission;
    private boolean bPause;
    private boolean bSrc;
    private short bSrc_c;
    private byte bStep;
    int bgColor;
    public short black_0;
    public short black_1;
    private short black_width;
    public byte[][] boatCourse;
    public byte boatSelect;
    short[] bottomData;
    int bottomRow;
    Sprite brow;
    byte checkNpcT;
    byte checkType;
    private short[][] cloud;
    private short cols;
    public StringBuffer[] dialog;
    public byte dialog_no;
    public byte[][] dir_select;
    private byte[][] door;
    private byte[][] event;
    private int eventCount;
    public byte eventGoing;
    public short[] event_now;
    public short[][] event_now_list;
    private byte event_state = 0;
    public String fString;
    private boolean faceDir;
    private byte faceLast;
    private short face_c;
    public byte firstDrawMap;
    public byte fmap;
    boolean fontSizeControl;
    short[] frontData;
    private byte get_meet;
    public boolean gmErr = false;
    private byte go;
    public GameRun gr;
    private Image hudong;
    int i = 0;
    int ii = 0;
    private Image imgCloud;
    private Image imgFace;
    public Image imgShadow;
    public byte inShop = 0;
    private boolean isNeedWait;
    private byte[][] item;
    private byte lastExit;
    private byte lastMap;
    private short leftCol;
    private short littleMapClipY;
    public byte[] mDirect;
    private byte[] mapChange;
    private short mapDown_NOmove;
    Image[] mapImg;
    public short[] mapInfo;
    private short mapLeft_NOmove;
    public byte mapNo = 0;
    byte mapNotemp = 0;
    private short mapRight_NOmove;
    private byte[][] mapTemp;
    private short mapUp_NOmove;
    int map_bottom;
    public byte map_key;
    int map_left;
    int map_right;
    int map_top;
    public int map_x;
    public int map_y;
    private byte[][] mapdataArea;
    private byte[][] mapdataMap;
    private short mapoffx;
    private short mapoffy;
    private short meet_step;
    private boolean miniMapMode;
    short[][] moduleData;
    public Npc my;
    private byte myMiniMap;
    public byte notMeet = 0;
    private byte now_eV1;
    private byte now_eV2;
    public Npc[][] npc = new Npc[3][];
    public byte npcDirTalk;
    private byte[] npcList;
    private String npcName;
    private String[] npcNameData;
    private byte[] npcPos;
    private String[] npcStringData;
    public PointerKey pkey;
    int rightCol;
    private byte roadType;
    private short rows;
    public byte sEvent_eV1;
    public byte sEvent_eV2;
    public byte sIfElse;
    private StringBuffer[][] sMission;
    private byte selectMap;
    private byte showArea;
    private byte sleep_count = 0;
    public int smissionLength;
    private byte srcFlash_c;
    private byte srcNpcNo = (byte)-1;
    private short step_MEET = (short)4;
    private byte time_5;
    private short topRow;
    public Image[] walkIco;
    short[][] worldData;
    private byte xxx = 0;

    static {
        npcSp = new Sprite[3][];
    }

    public Map(GameRun gameRun) {
        this.mapTemp = new byte[70][];
        this.anole_temp = (byte)-1;
        this.anole_type = (byte)-1;
        this.dialog_no = (byte)-1;
        this.bStep = (byte)-1;
        this.go = (byte)-2;
        this.fmap = (byte)-1;
        this.sIfElse = (byte)-1;
        byte[] byArray = new byte[2];
        byte[] byArray2 = new byte[2];
        byArray2[1] = -1;
        byte[] byArray3 = new byte[2];
        byArray3[1] = 1;
        byte[] byArray4 = new byte[2];
        byArray4[0] = -1;
        byte[] byArray5 = new byte[2];
        byArray5[0] = 1;
        this.dir_select = new byte[][]{byArray, byArray2, byArray3, byArray4, byArray5};
        this.anoleSel = 0;
        this.npcDirTalk = (byte)-1;
        this.bDirTalk = false;
        this.checkNpcT = (byte)-1;
        this.roadType = 0;
        this.miniMapMode = false;
        this.showArea = (byte)-1;
        this.littleMapClipY = (short)300;
        this.bPause = false;
        this.moduleData = null;
        this.mapImg = null;
        this.bgColor = 0;
        this.bottomData = null;
        this.frontData = null;
        this.worldData = null;
        this.firstDrawMap = 0;
        this.map_left = 0;
        this.map_top = 0;
        this.map_right = 0;
        this.map_bottom = 0;
        this.rightCol = 0;
        this.bottomRow = 0;
        this.imgFace = null;
        this.faceDir = false;
        this.faceLast = (byte)-1;
        this.face_c = 0;
        this.bSrc_c = 0;
        this.bSrc = false;
        this.srcFlash_c = 0;
        this.boatSelect = (byte)-1;
        this.isNeedWait = true;
        this.gr = gameRun;
        System.gc();
        this.init();
    }

    private void addCloud(int n) {
        short[] sArray = this.cloud[n];
        short s = this.leftCol;
        int n2 = Constants_H.WIDTH;
        Ms.i();
        sArray[0] = (short)(s * 20 + n2 + Ms.getRandom((int)Constants_H.WIDTH_H));
        sArray = this.cloud[n];
        s = this.topRow;
        Ms.i();
        sArray[1] = (short)(s * 20 + 20 + 2 + (Ms.getRandom((int)25) + 55) * n);
        sArray = this.cloud[n];
        Ms.i();
        sArray[2] = (short)(Ms.getRandom((int)3) + 1);
    }

    /*
     * Unable to fully structure code
     */
    private void canMove(int var1_1, int var2_2) {
        block2: {
            block4: {
                block6: {
                    block5: {
                        block3: {
                            this.my.speed_x = (byte)var1_1;
                            this.my.speed_y = (byte)var2_2;
                            if (this.my.x + this.my.speed_x < 0 || this.my.x + this.my.speed_x + 19 >= this.cols * 20 || this.my.y + this.my.speed_y < 0 || this.my.y + this.my.speed_y + 19 >= this.rows * 20) break block2;
                            this.roadType = this.checkMap(this.my.x, this.my.y, this.my.speed_x, this.my.speed_y);
                            if (this.roadType == 0) {
                                this.initMoveMy();
lbl7:
                                // 8 sources

                                return;
                            }
                            if (!this.checkMoveOff(this.checkNpcT)) break block3;
                            this.initMoveMy();
                            ** GOTO lbl7
                        }
                        if (this.checkNpcT != -1 && !this.isCheckNpcOff()) break block4;
                        this.roadType = this.isMapChenk(this.roadType);
                        if (this.roadType != -1) break block5;
                        this.moveOff((byte)3, (byte)1, -this.my.speed);
                        ** GOTO lbl7
                    }
                    if (this.roadType != -2) break block6;
                    this.moveOff((byte)4, (byte)2, this.my.speed);
                    ** GOTO lbl7
                }
                this.checkAnole();
                ** GOTO lbl7
            }
            Ms.i().keyRelease();
            this.setMoveStop_m();
            ** GOTO lbl7
        }
        this.setMoveStop_m();
        this.checkType = this.checkIfOther(this.door, this.my.x, this.my.y);
        if (this.checkType == -1 || this.door[this.checkType][5] != 0 || this.map_key != this.door[this.checkType][2]) ** GOTO lbl7
        this.my.state = (byte)5;
        this.get_meet = this.checkType;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void checkAnole() {
        block8: {
            block7: {
                block6: {
                    block5: {
                        this.checkType = this.checkWorld(this.my.x, this.my.y, this.my.speed_x, this.my.speed_y, true);
                        if (this.checkType != 2) break block5;
                        if (this.isCheckAnole(4)) lbl-1000:
                        // 5 sources

                        {
                            return;
                        }
                        break block6;
                    }
                    if (this.checkType != 3) break block7;
                    if (this.isCheckAnole(0)) ** GOTO lbl-1000
                }
lbl11:
                // 3 sources

                while (true) {
                    Ms.i().keyRelease();
                    this.setMoveStop_m();
                    ** GOTO lbl-1000
                    break;
                }
            }
            if (this.checkType != 4) break block8;
            if (!this.isCheckAnole(2)) ** GOTO lbl11
            ** GOTO lbl-1000
        }
        if (this.checkType == 0 && this.anole_type == 4) ** break;
        ** while (true)
        if (this.anole_type != 3 && this.isAnoleType(3)) {
            this.anole_type = (byte)3;
lbl24:
            // 2 sources

            while (true) {
                this.setAnole();
                this.initMoveMy();
                ** continue;
                break;
            }
        }
        this.anole_type = (byte)-1;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private byte checkIfNpc(Npc[] var1_1, int var2_2, int var3_3) {
        var4_4 = (byte)(var1_1.length - 1);
        while (true) {
            if (var4_4 <= -1) {
                var4_4 = -1;
                return var4_4;
            }
            if (Ms.i().isRect(var2_2, var3_3, 19, 19, (int)var1_1[var4_4].x, (int)var1_1[var4_4].y, 20, 20) && (var1_1[var4_4].other[4] == 1 || var1_1[var4_4].other[4] == 3)) ** continue;
            var4_4 = (byte)(var4_4 - 1);
        }
    }

    /*
     * Unable to fully structure code
     */
    private byte checkIfOther(byte[][] var1_1, int var2_2, int var3_3) {
        var4_4 = (byte)(var1_1.length - 1);
        while (true) {
            if (var4_4 <= -1) {
                var4_4 = -1;
                return var4_4;
            }
            if (Ms.i().isRect(var2_2, var3_3, 19, 19, var1_1[var4_4][0] * 20, var1_1[var4_4][1] * 20, 20, 20)) ** continue;
            var4_4 = (byte)(var4_4 - 1);
        }
    }

    /*
     * Enabled force condition propagation
     */
    private byte checkMap(int n, int n2, int n3, int n4) {
        this.checkNpcT = (byte)-1;
        this.checkType = this.checkIfOther(this.item, n + n3, n2 + n4);
        if (this.checkType != -1) {
            this.checkNpcT = (byte)-2;
            return 1;
        }
        if (n + n3 < 0) return 1;
        if (n + n3 >= this.cols * 20) return 1;
        if (n2 + n4 < 0) return 1;
        if (n2 + n4 >= this.rows * 20) {
            return 1;
        }
        this.checkType = this.checkIfNpc(this.npc[0], n + n3, n2 + n4);
        if (this.checkType != -1) {
            if (this.npcNameData[this.checkType].equals("\u8def\u4eba")) {
                if (this.npc[0][this.checkType].other[5] <= 0) return 1;
            }
            this.checkNpcT = this.checkType;
            return 1;
        }
        this.checkType = this.checkIfOther(this.door, n + n3, n2 + n4);
        if (this.checkType == -1) return this.checkWorld(n, n2, n3, n4, false);
        if (this.door[this.checkType][5] != 2) {
            if (this.map_key != this.door[this.checkType][2]) return this.checkWorld(n, n2, n3, n4, false);
        }
        this.my.state = (byte)5;
        this.get_meet = this.checkType;
        return 0;
    }

    /*
     * Unable to fully structure code
     */
    private boolean checkMoveOff(int var1_1) {
        block20: {
            block25: {
                block26: {
                    block22: {
                        block23: {
                            block24: {
                                block15: {
                                    block21: {
                                        block18: {
                                            block19: {
                                                block16: {
                                                    block17: {
                                                        if (var1_1 <= -1) break block15;
                                                        var3_2 = (byte)(this.npc[0][var1_1].x + 20 - this.my.x);
                                                        var2_4 = (byte)(this.npc[0][var1_1].x - this.my.x - 20);
                                                        var4_6 = (byte)(this.npc[0][var1_1].y + 20 - this.my.y);
                                                        var5_7 = (byte)(this.npc[0][var1_1].y - this.my.y - 20);
                                                        if (this.my.speed_x < 0 && var3_2 != 0) {
                                                            var8_8 = this.my;
                                                            if (var3_2 < this.my.speed_x) {
                                                                var2_4 = this.my.speed_x;
lbl10:
                                                                // 2 sources

                                                                while (true) {
                                                                    var8_8.speed_x = var2_4;
                                                                    var7_16 = true;
lbl13:
                                                                    // 7 sources

                                                                    return var7_16;
                                                                }
                                                            }
                                                            var2_4 = var3_2;
                                                            ** continue;
                                                        }
                                                        if (this.my.speed_x <= 0 || var2_4 == 0) break block16;
                                                        var8_9 = this.my;
                                                        if (var2_4 >= this.my.speed_x) break block17;
lbl20:
                                                        // 2 sources

                                                        while (true) {
                                                            var8_9.speed_x = var2_4;
                                                            var7_16 = true;
                                                            ** GOTO lbl13
                                                            break;
                                                        }
                                                    }
                                                    var2_4 = this.my.speed_x;
                                                    ** while (true)
                                                }
                                                if (this.my.speed_y >= 0 || var4_6 == 0) break block18;
                                                var8_10 = this.my;
                                                if (var4_6 >= this.my.speed_y) break block19;
                                                var2_4 = this.my.speed_y;
lbl32:
                                                // 2 sources

                                                while (true) {
                                                    var8_10.speed_y = var2_4;
                                                    var7_16 = true;
                                                    ** GOTO lbl13
                                                    break;
                                                }
                                            }
                                            var2_4 = var4_6;
                                            ** while (true)
                                        }
                                        if (this.my.speed_y <= 0 || var5_7 == 0) break block20;
                                        var8_11 = this.my;
                                        if (var5_7 >= this.my.speed_y) break block21;
                                        var2_4 = var5_7;
lbl44:
                                        // 2 sources

                                        while (true) {
                                            var8_11.speed_y = var2_4;
                                            var7_16 = true;
                                            ** GOTO lbl13
                                            break;
                                        }
                                    }
                                    var2_4 = this.my.speed_y;
                                    ** while (true)
                                }
                                var6_17 = this.my.getIx_off();
                                var3_3 = (byte)(20 - this.my.getIx_off());
                                var1_1 = this.my.getIy_off();
                                var2_5 = (byte)(20 - this.my.getIy_off());
                                if (this.my.speed_x == 0 || var6_17 == 0) break block22;
                                if (this.my.speed_x >= 0) break block23;
                                var8_12 = this.my;
                                if (-var6_17 >= this.my.speed_x) break block24;
                                var1_1 = this.my.speed_x;
lbl61:
                                // 2 sources

                                while (true) {
                                    var8_12.speed_x = (byte)var1_1;
lbl63:
                                    // 2 sources

                                    while (true) {
                                        var7_16 = true;
                                        ** GOTO lbl13
                                        break;
                                    }
                                    break;
                                }
                            }
                            var1_1 = -var6_17;
                            ** while (true)
                        }
                        var8_13 = this.my;
                        if (var3_3 < this.my.speed_x) {
                            var2_5 = var3_3;
lbl73:
                            // 2 sources

                            while (true) {
                                var8_13.speed_x = var2_5;
                                ** continue;
                                break;
                            }
                        }
                        var2_5 = this.my.speed_x;
                        ** while (true)
                    }
                    if (this.my.speed_y == 0 || var1_1 == 0) break block20;
                    if (this.my.speed_y >= 0) break block25;
                    var8_14 = this.my;
                    if (-var1_1 >= this.my.speed_y) break block26;
                    var1_1 = this.my.speed_y;
lbl84:
                    // 2 sources

                    while (true) {
                        var8_14.speed_y = (byte)var1_1;
lbl86:
                        // 2 sources

                        while (true) {
                            var7_16 = true;
                            ** GOTO lbl13
                            break;
                        }
                        break;
                    }
                }
                var1_1 = -var1_1;
                ** while (true)
            }
            var8_15 = this.my;
            if (var2_5 < this.my.speed_y) lbl-1000:
            // 2 sources

            {
                while (true) {
                    var8_15.speed_y = var2_5;
                    ** continue;
                    break;
                }
            }
            var2_5 = this.my.speed_y;
            ** while (true)
        }
        var7_16 = false;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private byte checkWorld(int var1_1, int var2_2, int var3_3, int var4_4, boolean var5_5) {
        block13: {
            block12: {
                var9_6 = 0;
                var10_7 = 1;
                if (var3_3 == 0 && var1_1 % 20 != 0) break block12;
                var7_8 = var10_7;
                var8_9 = var9_6;
                if (var4_4 != 0) break block13;
                var7_8 = var10_7;
                var8_9 = var9_6;
                if (var2_2 % 20 == 0) break block13;
            }
            var7_8 = 2;
            var8_9 = var9_6;
        }
        while (true) {
            block10: {
                block11: {
                    block16: {
                        block14: {
                            block15: {
                                if (var8_9 >= var7_8) {
                                    var6_11 = 0;
lbl17:
                                    // 3 sources

                                    return var6_11;
                                }
                                if (var4_4 != 0) break block14;
                                var10_7 = (byte)((var8_9 * 20 + var2_2) / 20);
                                if (var3_3 < 0) break block15;
                                var9_6 = (var1_1 + var3_3 + 19) / 20;
lbl23:
                                // 2 sources

                                while (true) {
                                    var9_6 = (byte)var9_6;
lbl25:
                                    // 2 sources

                                    while (var5_5) {
                                        if (this.worldData[var9_6][var10_7] == 0) break block10;
                                        var6_11 = (byte)this.worldData[var9_6][var10_7];
                                        ** GOTO lbl17
                                    }
                                    break block11;
                                    break;
                                }
                            }
                            var9_6 = (var1_1 + var3_3) / 20;
                            ** continue;
                        }
                        var10_7 = (byte)((var8_9 * 20 + var1_1) / 20);
                        if (var4_4 < 0) break block16;
                        var9_6 = (var2_2 + var4_4 + 19) / 20;
lbl37:
                        // 2 sources

                        while (true) {
                            var11_10 = (byte)var9_6;
                            var9_6 = var10_7;
                            var10_7 = var11_10;
                            ** GOTO lbl25
                            break;
                        }
                    }
                    var9_6 = (var2_2 + var4_4) / 20;
                    ** continue;
                }
                if (this.isCan_not_pass(var9_6, var10_7)) {
                    var6_11 = 1;
                    ** continue;
                }
            }
            var8_9 = (byte)(var8_9 + 1);
        }
    }

    private void configureNpc() {
        Map.npcSp[0] = new Sprite[100];
        Map.npcSp[1] = new Sprite[5];
        Map.npcSp[2] = new Sprite[60];
    }

    private void createMap() {
        this.loadMapModuleAndImage();
        this.loadMapData(this.mapNo);
    }

    /*
     * Unable to fully structure code
     */
    private void dialog(String var1_1) {
        block4: {
            block6: {
                block5: {
                    var7_2 = Constants_H.WIDTH__;
                    var3_3 = Constants_H.HEIGHT__;
                    var5_4 = var3_3 - 8 - 25 * 2;
                    var6_5 = 25 * 2 + 11;
                    var4_6 = 0;
                    Ui.i().drawKuang(4, var3_3 - var6_5 - 4, var7_2 - 4, var6_5 + 4);
                    var2_7 = var4_6;
                    if (var1_1 == null) ** GOTO lbl20
                    if (!this.faceDir) break block5;
                    var2_7 = var7_2 - 50;
lbl11:
                    // 2 sources

                    while (this.faceDir) {
                        var3_3 = var3_3 - var6_5 - 4;
lbl13:
                        // 2 sources

                        while (true) {
                            this.drawNpcFace(var2_7, var3_3, 1 | 32);
                            Ui.i().drawKuang(0, var5_4 - var6_5 + 25, Ms.i().getStringWidth(var1_1) + 16, 25 + 8);
                            Ui.i().drawString(var1_1, 8, var5_4 - var6_5 + 2 + 25, 0, 9, 1);
                            Log.e((String)"sk", (String)"dialog");
                            var2_7 = var4_6;
lbl20:
                            // 3 sources

                            while (true) {
                                if (var2_7 >= 2 || this.dialog_no + var2_7 >= this.dialog.length) {
                                    return;
                                }
                                break block4;
                                break;
                            }
                            break;
                        }
                    }
                    break block6;
                }
                var2_7 = 50;
                ** GOTO lbl11
            }
            var3_3 = var3_3 - var6_5 - 4 - 25;
            ** while (true)
        }
        Ui.i().drawStringColor(this.dialog[this.dialog_no + var2_7].toString(), 10, var2_7 * 25 + (var5_4 - 2), -1, 1);
        ++var2_7;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawAnoleSel() {
        block15: {
            block16: {
                block17: {
                    block18: {
                        this.gr.cur_a = (byte)Ms.i().mathSpeedN((int)this.gr.cur_a, 25 * 2 + 12, 8, false);
                        Ui.i().drawK1(0, Constants_H.HEIGHT - this.gr.cur_a - 2, 119, 25 + 4 + 2, 2);
                        Ui.i().drawK2(0, Constants_H.HEIGHT + 25 + 4 - this.gr.cur_a, Constants_H.WIDTH, 25 + 8, 0);
                        var1_1 = 0;
                        block0: while (true) {
                            if (var1_1 >= 5) {
                                if (this.anoleSel == this.anole_type) {
                                    var2_2 = 0;
lbl9:
                                    // 2 sources

                                    while (true) {
                                        Log.e((String)"sk", (String)"drawAnoleSel");
                                        Ui.i().drawString(this.gr.about_a[var2_2].toString(), 60, Constants_H.HEIGHT - this.gr.cur_a - 2, 17, 1, 2);
                                        Ui.i().drawK4(this.anoleSel * Constants_H.WIDTH / 6 + 41 + this.gr.cur_b / 3, Constants_H.HEIGHT + 25 + 7 - this.gr.cur_a + this.gr.cur_b / 3, 22 - (this.gr.cur_b / 3 << 1), 22 - (this.gr.cur_b / 3 << 1));
                                        var4_4 = this.gr;
                                        var2_2 = var4_4.cur_b;
                                        var4_4.cur_b = (byte)(var2_2 + 1);
                                        if (var2_2 > 4) {
                                            this.gr.cur_b = 0;
                                        }
                                        Ui.i().drawYesNo_(false, true);
                                        return;
                                    }
                                }
                                break block15;
                            }
                            if (this.isAnoleType(var1_1)) break;
                            var3_3 = 6;
                            var2_2 = (byte)(var1_1 + 70);
lbl25:
                            // 3 sources

                            while (true) {
                                Ui.i().drawK0(Constants_H.WIDTH * var1_1 / 6 + 42, Constants_H.HEIGHT + 25 + 8 - this.gr.cur_a, 20, 20, var3_3);
                                Ui.i().drawUi((int)var2_2, Constants_H.WIDTH * var1_1 / 6 + 42 + 10, Constants_H.HEIGHT + 25 + 8 - this.gr.cur_a + 18, 33, 0);
                                if (this.pkey.isSelect(Constants_H.WIDTH * var1_1 / 6 + 42, Constants_H.HEIGHT + 25 + 8 - this.gr.cur_a, 20, 20)) {
                                    if (this.anoleSel != var1_1) break block16;
                                    this.pkey.setKeySoftkey1();
                                }
lbl31:
                                // 4 sources

                                while (true) {
                                    var1_1 = (byte)(var1_1 + 1);
                                    continue block0;
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        if (var1_1 != this.anoleSel) break block18;
                        var2_2 = 1;
lbl36:
                        // 2 sources

                        while (true) {
                            var3_3 = var2_2;
                            if (var1_1 != this.anole_type) break block17;
                            var2_2 = (byte)69;
                            ** GOTO lbl25
                            break;
                        }
                    }
                    var2_2 = 0;
                    ** while (true)
                }
                if (var1_1 == this.anoleSel) {
                    var2_2 = (byte)(var1_1 + 5);
lbl47:
                    // 2 sources

                    while (true) {
                        var2_2 = var2_2;
                        ** continue;
                        break;
                    }
                }
                var2_2 = var1_1;
                ** while (true)
            }
            this.anoleSel = var1_1;
            ** while (true)
        }
        if (this.isAnoleType(this.anoleSel)) {
            var2_2 = (byte)(this.anoleSel + 1);
lbl58:
            // 2 sources

            while (true) {
                var2_2 = var2_2;
                ** continue;
                break;
            }
        }
        var2_2 = (byte)6;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawBrow() {
        block6: {
            block7: {
                var2_1 = 0;
                block0: while (true) {
                    if (var2_1 >= this.npcList.length) {
                        return;
                    }
                    var3_3 = this.npcList[var2_1];
                    if (var3_3 >= -1) break;
lbl7:
                    // 5 sources

                    while (true) {
                        var2_1 = (byte)(var2_1 + 1);
                        continue block0;
                        break;
                    }
                    break;
                }
                if (var3_3 != -1) break block7;
                Map.cur_npc = this.my;
lbl12:
                // 2 sources

                while (true) {
                    if (Map.cur_npc.other[4] != 1 && Map.cur_npc.other[4] != 2 || Map.cur_npc.brow_type <= -1 && Map.cur_npc.other[6] == 0 || var3_3 > -1 && !this.isNpcSrc(Map.cur_npc.x, Map.cur_npc.y)) ** GOTO lbl7
                    if (Map.cur_npc.other[6] != 0) {
                        Map.cur_npc.brow_type = Map.cur_npc.other[6];
                    }
                    if (Map.cur_npc.brow_action >= this.brow.aLength((int)Map.cur_npc.brow_type)) {
                        if (Map.cur_npc.other[6] == 0) break block6;
                        Map.cur_npc.brow_action = 0;
                    }
                    Ui.i().drawFrameOne(this.brow, this.brow.action((int)Map.cur_npc.brow_type, (int)Map.cur_npc.brow_action, 0), this.map_x + Map.cur_npc.x + 14, this.map_y + Map.cur_npc.y - 15 - 10, 0);
                    var4_4 = Map.cur_npc;
                    var4_4.brow_time = var1_2 = (byte)(var4_4.brow_time + 1);
                    if (var1_2 <= this.brow.action((int)Map.cur_npc.brow_type, (int)Map.cur_npc.brow_action, 1)) ** GOTO lbl7
                    var4_4 = Map.cur_npc;
                    var4_4.brow_action = (byte)(var4_4.brow_action + 1);
                    Map.cur_npc.brow_time = 0;
                    ** GOTO lbl7
                    break;
                }
            }
            Map.cur_npc = this.npc[0][var3_3];
            ** while (true)
        }
        Map.cur_npc.brow_type = (byte)-1;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawCheck5(int var1_1) {
        if (this.checkNpcT == -1 || this.my.state != 0) lbl-1000:
        // 4 sources

        {
            return;
        }
        this.drawHudong();
        if (this.checkNpcT < 0 || this.npc[0][this.checkNpcT].other[6] != 0) ** GOTO lbl-1000
        this.drawHudong();
        Ui.i().drawFrameOne(this.brow, this.brow.action(var1_1, (int)this.action_5, 0), this.map_x + this.npc[0][this.checkNpcT].x + 10, this.map_y + this.npc[0][this.checkNpcT].y - 16 - 10, 0);
        this.time_5 = var2_2 = (byte)(this.time_5 + 1);
        if (var2_2 <= this.brow.action(var1_1, (int)this.action_5, 1)) ** GOTO lbl-1000
        this.action_5 = var2_2 = (byte)(this.action_5 + 1);
        if (var2_2 >= this.brow.aLength(var1_1)) {
            this.action_5 = 0;
        }
        this.time_5 = 0;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawCloud() {
        if (this.imgCloud == null) {
            return;
        }
        var1_1 = 0;
        block1: while (true) {
            if (var1_1 >= this.cloud.length) {
                var1_1 = 0;
                block2: while (true) {
                    if (var1_1 >= this.cloud.length) ** continue;
                    if (this.isNpcSrc(this.cloud[var1_1][0], this.cloud[var1_1][1])) break block1;
                    this.addCloud(var1_1);
lbl12:
                    // 2 sources

                    while (true) {
                        var1_1 = (byte)(var1_1 + 1);
                        continue block2;
                        break;
                    }
                    break;
                }
            }
            Ui.i().drawImage(this.imgCloud, this.map_x + this.cloud[var1_1][0], this.map_y + this.cloud[var1_1][1], 0);
            var1_1 = (byte)(var1_1 + 1);
        }
        var2_2 = this.cloud[var1_1];
        var2_2[0] = (short)(var2_2[0] - this.cloud[var1_1][2]);
        ** while (true)
    }

    private void drawHudong() {
        Ui.i().drawImage(this.hudong, Constants_H.WIDTH_H, Constants_H.HEIGHT - 30, 3);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void drawMapRect(byte var1_1, byte var2_2, int var3_3, boolean var4_4) {
        block5: {
            block6: {
                var5_5 = var1_1 * 6;
                var6_6 = var2_2 * 6;
                if (this.miniMapMode) {
                    var5_5 = this.mapdataMap[var3_3][6] * var1_1;
                    var6_6 = this.mapdataMap[var3_3][7] * var2_2;
                }
                if (var4_4) {
                    Ui.i().drawRectZ(12352252, this.mapdataMap[var3_3][0] * var1_1 + this.mapoffx, this.mapdataMap[var3_3][1] * var2_2 + this.mapoffy, var5_5, var6_6, 5);
lbl8:
                    // 3 sources

                    return;
                }
                if (var3_3 != this.myMiniMap) break block6;
                var12_7 /* !! */  = Ui.i();
                var7_8 = this.mapdataMap[var3_3][0];
                var9_9 = this.mapoffx;
                var8_10 = this.mapdataMap[var3_3][1];
                var12_7 /* !! */ .drawK1(var9_9 + var7_8 * var1_1, this.mapoffy + var8_10 * var2_2, var5_5, var6_6, 4);
lbl16:
                // 2 sources

                while (true) {
                    var13_11 = this.gr;
                    var12_7 /* !! */  = this.gr.getNameCity(var3_3);
                    var10_12 = this.mapdataMap[var3_3][0];
                    var11_13 = this.mapoffx;
                    var9_9 = this.mapdataMap[var3_3][1];
                    var8_10 = this.mapoffy;
                    if (var3_3 != this.myMiniMap) break block5;
                    var7_8 = 0;
lbl25:
                    // 2 sources

                    while (true) {
                        var13_11.showStringM((String)var12_7 /* !! */ , var10_12 * var1_1 + var11_13 + (var5_5 >> 1), var9_9 * var2_2 + var8_10 + (var6_6 >> 1) - 25, 4, var7_8);
                        if (var3_3 != this.myMiniMap) ** GOTO lbl8
                        Ui.i().drawUi(67, this.mapdataMap[var3_3][0] * var1_1 + this.mapoffx + (var5_5 >> 1), this.mapdataMap[var3_3][1] * var2_2 + this.mapoffy + (var6_6 >> 1), 3, 0);
                        ** continue;
                        break;
                    }
                    break;
                }
            }
            var12_7 /* !! */  = Ui.i();
            var9_9 = this.mapdataMap[var3_3][0];
            var8_10 = this.mapoffx;
            var7_8 = this.mapdataMap[var3_3][1];
            var12_7 /* !! */ .drawK0(var8_10 + var9_9 * var1_1, this.mapoffy + var7_8 * var2_2, var5_5, var6_6, 2);
            ** while (true)
        }
        var7_8 = 3;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawMapRect(Graphics var1_1) {
        var2_2 = 0;
        var1_1.setColor(0);
        block0: while (true) {
            if (var2_2 >= this.gr.mapRect.length) {
                return;
            }
            if (!Ms.i().isRect((int)this.my.x, (int)this.my.y, 19, 19, this.gr.mapRect[var2_2][0] * 20, this.gr.mapRect[var2_2][1] * 20, (this.gr.mapRect[var2_2][2] - this.gr.mapRect[var2_2][0] + 1) * 20, (this.gr.mapRect[var2_2][3] - this.gr.mapRect[var2_2][1] + 1) * 20)) break;
            while (true) {
                var2_2 = (byte)(var2_2 + 1);
                continue block0;
                break;
            }
            break;
        }
        var3_3 = 4;
        while (true) {
            if (var3_3 >= this.gr.mapRect[var2_2].length) ** continue;
            var1_1.fillRect(this.map_x + this.gr.mapRect[var2_2][var3_3] * 20, this.map_y + this.gr.mapRect[var2_2][var3_3 + 1] * 20, (this.gr.mapRect[var2_2][var3_3 + 2] - this.gr.mapRect[var2_2][var3_3] + 1) * 20, (this.gr.mapRect[var2_2][var3_3 + 3] - this.gr.mapRect[var2_2][var3_3 + 1] + 1) * 20);
            var3_3 = (byte)(var3_3 + 4);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void drawMiniMap() {
        block12: {
            block11: {
                GameRun.mc.keyxx = MainCanvas.mainxx;
                GameRun.mc.keyyy = MainCanvas.mainyy;
                Ui.i().fillRectB();
                Ui.i().drawK2(1, 2, 640 - 2, 360 - 2, 0);
                Ui.i().drawK1(6, 33, 640 - 12, 360 - 29 * 3 - 15, 1);
                Ui.i().drawK1(6, 360 - 6 - 29 * 2, 640 - 12, 29 * 2, 2);
                Ui.i().drawYesNo(false, true);
                Ui.i().drawString("\u6e38\u620f\u5730\u56fe", 320, 4, 17, 1, 2);
                if (this.showArea == -1) {
                    Ui.i().drawString("\u8be5\u533a\u57df\u6ca1\u6709\u5730\u56fe\uff01", 320, 360 - 4 - 29 * 2, 16 | 1, 3, 0);
lbl11:
                    // 2 sources

                    return;
                }
                this.gr.showStringM("\u4eba\u7269\u5f53\u524d\u4f4d\u7f6e\uff1a" + this.gr.getNameCity((int)this.myMiniMap), 320, 360 - 4 - 29 * 2, 10, 3);
                Map.g.setClip(6, 33, 640 - 12, 360 - 15 - 29 * 3);
                var3_1 = 0;
                var4_2 = this.mapdataMap[this.selectMap][0];
                if (this.miniMapMode) {
                    var2_3 = this.mapdataMap[this.selectMap][6] * 18 / 2;
lbl19:
                    // 2 sources

                    while (true) {
                        this.mapoffx = Ms.i().mathSpeedN((int)this.mapoffx, 320 - var4_2 * 18 - var2_3, 10, false);
                        var4_2 = this.littleMapClipY / 2;
                        var5_4 = this.mapdataMap[this.selectMap][1];
                        if (!this.miniMapMode) break block11;
                        var2_3 = this.mapdataMap[this.selectMap][7] * 12 / 2;
lbl25:
                        // 2 sources

                        while (true) {
                            this.mapoffy = Ms.i().mathSpeedN((int)this.mapoffy, var4_2 - var5_4 * 12 - var2_3, 10, false);
                            var2_3 = var3_1;
lbl28:
                            // 2 sources

                            while (true) {
                                if (var2_3 >= this.mapdataArea[this.showArea].length) {
                                    if (!this.miniMapMode) {
                                        this.drawMapRect((byte)18, (byte)12, this.myMiniMap, false);
                                    }
                                    this.drawMapRect((byte)18, (byte)12, this.selectMap, true);
                                    Map.g.setClip(0, 0, 640, 360);
                                    ** continue;
                                }
                                break block12;
                                break;
                            }
                            break;
                        }
                        break;
                    }
                }
                var2_3 = 25;
                ** while (true)
            }
            var2_3 = 15;
            ** while (true)
        }
        var1_5 = this.mapdataArea[this.showArea][var2_3];
        if (var1_5 < 0) lbl-1000:
        // 4 sources

        {
            while (true) {
                var2_3 = (byte)(var2_3 + 1);
                ** continue;
                break;
            }
        }
        if (this.mapdataMap[var1_5].length <= 0) ** GOTO lbl-1000
        if (this.pkey.isSelect(this.mapdataMap[var1_5][0] * 18 + this.mapoffx, this.mapdataMap[var1_5][1] * 12 + this.mapoffy, 18 * 6, 12 * 6)) {
            this.selectMap = var1_5;
        }
        if (!this.miniMapMode && var1_5 == this.myMiniMap) ** GOTO lbl-1000
        this.drawMapRect((byte)18, (byte)12, var1_5, false);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void drawMission() {
        block17: {
            block16: {
                block15: {
                    block14: {
                        block13: {
                            block12: {
                                block11: {
                                    Ui.i().fillRectB();
                                    Ui.i().drawK2(1, 6, 640 - 2, 360 - 6, 0);
                                    Ui.i().drawK1(8, 41, 640 - 26, this.gr.line_max * 29 + 10, 1);
                                    Ui.i().drawK1(8, this.gr.line_max * 29 + 59, 640 - 16, 125, 2);
                                    var3_1 = this.gr.line_max;
                                    var4_2 /* !! */  = this.gr.select[0];
                                    if (this.gr.cur_a == 0) {
                                        var2_3 = this.bMission[14] + 1;
lbl9:
                                        // 2 sources

                                        while (true) {
                                            this.drawMisstionList(8, 41 + 6, 640 - 26, 29, var3_1, var4_2 /* !! */ , var2_3);
                                            var2_3 = 0;
lbl12:
                                            // 2 sources

                                            while (true) {
                                                if (this.gr.about_a != null && var2_3 < this.gr.about_a.length) break block11;
                                                var1_4 = this.pkey.selectMenuX(2, 0, 0, 320, 40);
                                                if (var1_4 != -1) {
                                                    this.gr.cur_a = var1_4;
                                                    this.goMission(this.gr.cur_a, this.bPause);
                                                }
                                                var4_2 /* !! */  = (byte[])Ui.i();
                                                if (this.gr.cur_a != 0) break block12;
                                                var2_3 = 320 - 125;
lbl21:
                                                // 2 sources

                                                while (true) {
                                                    var4_2 /* !! */ .drawK1(var2_3, 9, 100, 29, 4);
                                                    var4_2 /* !! */  = (byte[])Ui.i();
                                                    if (this.gr.cur_a != 0) break block13;
                                                    var2_3 = 0;
lbl26:
                                                    // 2 sources

                                                    while (true) {
                                                        var4_2 /* !! */ .drawString("\u4e3b\u7ebf\u4efb\u52a1", 320 - 75, 9, 17, var2_3, 0);
                                                        var4_2 /* !! */  = (byte[])Ui.i();
                                                        if (this.gr.cur_a != 1) break block14;
                                                        var2_3 = 0;
lbl31:
                                                        // 2 sources

                                                        while (true) {
                                                            var4_2 /* !! */ .drawString("\u5206\u652f\u4efb\u52a1", 320 + 75, 9, 17, var2_3, 0);
                                                            Ui.i().drawTriangle(320, 20, 150, true, true);
                                                            var5_5 = Ui.i();
                                                            if (this.gr.cur_a != 0) break block15;
                                                            var4_2 /* !! */  = (byte[])"\u4e3b\u7ebf\u5b8c\u6210\u5ea6\uff1a";
lbl37:
                                                            // 2 sources

                                                            while (true) {
                                                                var7_6 = new StringBuilder(String.valueOf(var4_2 /* !! */ ));
                                                                var4_2 /* !! */  = (byte[])Ms.i();
                                                                var6_7 = this.bMission;
                                                                if (this.gr.cur_a != 0) break block16;
                                                                var2_3 = 14;
lbl43:
                                                                // 2 sources

                                                                while (true) {
                                                                    var3_1 = var6_7[var2_3];
                                                                    if (this.gr.cur_a == 0) {
                                                                        var2_3 = this.sMission.length - 1;
lbl47:
                                                                        // 2 sources

                                                                        while (true) {
                                                                            var5_5.drawString(var7_6.append(var4_2 /* !! */ .getPrecision(var3_1 * 1000 / var2_3)).append("%").toString(), 320, 360 - 1, 33, -1, 1);
                                                                            Ui.i().drawYesNo(false, true);
                                                                            return;
                                                                        }
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
                                            break;
                                        }
                                    }
                                    var2_3 = this.mDirect.length;
                                    ** while (true)
                                }
                                Ui.i().drawStringColor(this.gr.about_a[var2_3].toString(), 25, this.gr.line_max * 29 + 61 + var2_3 * 25, 3, 0);
                                var2_3 = (byte)(var2_3 + 1);
                                ** while (true)
                            }
                            var2_3 = 320 + 25;
                            ** while (true)
                        }
                        var2_3 = 1;
                        ** while (true)
                    }
                    var2_3 = 1;
                    ** while (true)
                }
                var4_2 /* !! */  = (byte[])"\u5206\u652f\u5b8c\u6210\u5ea6\uff1a";
                ** while (true)
            }
            var2_3 = 15;
            ** while (true)
        }
        var2_3 = this.sMission.length;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawMisstionList(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5, byte[] var6_6, int var7_7) {
        block10: {
            block9: {
                block12: {
                    block8: {
                        block11: {
                            block7: {
                                var8_8 = var6_6[1];
                                Ui.i().drawListKY(var5_5, var1_1, var2_2, var3_3, 6, var4_4, -1, var6_6[0] - var6_6[1], 4, 2);
                                block0: while (true) {
                                    if (var8_8 >= var6_6[1] + var5_5) {
                                        Ui.i().sliding(var1_1 + var3_3 + 4, var2_2, var5_5 * var4_4, (int)var6_6[0], var7_7, true);
                                        return;
                                    }
                                    if (var8_8 >= var7_7) ** GOTO lbl32
                                    if (this.gr.cur_a != 0) break;
                                    var11_11 = String.valueOf(var8_8 + 1) + "\u3001" + this.sMission[var8_8][0].toString();
lbl10:
                                    // 2 sources

                                    while (true) {
                                        Log.e((String)"sk", (String)"drawMisstionList");
                                        var12_12 = Ui.i();
                                        var10_10 = var6_6[1];
                                        if (var8_8 >= this.bMission[14]) break block7;
                                        var9_9 = -1;
lbl17:
                                        // 3 sources

                                        while (true) {
                                            var12_12.drawString(var11_11, var1_1 + 8, (var8_8 - var10_10) * (var4_4 - 1) + var2_2, 0, var9_9, 0);
                                            if (this.gr.cur_a != 0 || var8_8 == var7_7 - 1) ** GOTO lbl26
                                            var11_11 = Ui.i();
                                            var10_10 = var6_6[1];
                                            if (var8_8 >= this.bMission[14]) break block8;
                                            var9_9 = -1;
lbl24:
                                            // 3 sources

                                            while (true) {
                                                var11_11.drawString("\u5b8c\u6210", var1_1 + var3_3 - 8, var2_2 + (var8_8 - var10_10) * (var4_4 - 1), 24, var9_9, 0);
lbl26:
                                                // 2 sources

                                                if (!this.pkey.isSelect(0, (var8_8 - var6_6[1]) * (var4_4 - 1) + var2_2, 640, var4_4 - 1)) ** GOTO lbl32
                                                var6_6[0] = var8_8;
                                                if (var8_8 - var6_6[1] != 0 || var6_6[1] <= 0) break block9;
                                                var6_6[1] = (byte)(var6_6[1] - 1);
lbl30:
                                                // 3 sources

                                                while (this.gr.cur_a == 0) {
                                                    this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), 640 - 50, 0);
lbl32:
                                                    // 5 sources

                                                    while (true) {
                                                        var8_8 = (byte)(var8_8 + 1);
                                                        continue block0;
                                                        break;
                                                    }
                                                    continue block0;
                                                }
                                                break block10;
                                                break;
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                                var11_11 = String.valueOf(var8_8 + 1) + "\u3001" + this.sMission[this.mDirect[var8_8]][0].toString();
                                ** while (true)
                            }
                            if (var6_6[0] != var8_8) break block11;
                            var9_9 = 0;
                            ** GOTO lbl17
                        }
                        var9_9 = 3;
                        ** while (true)
                    }
                    if (var6_6[0] != var8_8) break block12;
                    var9_9 = 0;
                    ** GOTO lbl24
                }
                var9_9 = 3;
                ** while (true)
            }
            if (var8_8 - var6_6[1] != var5_5 - 1 || var6_6[1] + var5_5 >= var7_7) ** GOTO lbl30
            var6_6[1] = (byte)(var6_6[1] + 1);
            ** GOTO lbl30
        }
        if (this.mDirect.length <= 0) ** GOTO lbl32
        this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 640 - 50, 0);
        ** while (true)
    }

    private void drawMySave() {
        this.gr.showString("\u662f\u5426\u5b58\u76d8?", 285, 0);
        Ui.i().drawYesNo(true, true);
    }

    /*
     * Unable to fully structure code
     */
    private void drawNMAni(Npc[] var1_1) {
        block8: {
            block9: {
                if (var1_1 == null) {
                    return;
                }
                var2_2 = 0;
                block1: while (true) {
                    if (var2_2 >= this.npcList.length) ** continue;
                    var3_3 = this.npcList[var2_2];
                    if (var3_3 != -1) break;
                    if (this.my.other[4] == 1 || this.my.other[4] == 2) {
                        this.drawMyAni(this.my, 0, this.map_x + this.my.x + 10, this.map_y + this.my.y + 19, this.my.other[7]);
                    }
lbl11:
                    // 6 sources

                    while (true) {
                        var2_2 = (byte)(var2_2 + 1);
                        continue block1;
                        break;
                    }
                    break;
                }
                if (var3_3 >= -1) break block8;
                Ms.i();
                var4_4 = (byte)(Ms.abs((int)var3_3) - 2);
                if (!this.isNpcSrc(this.item[var4_4][0] * 20, this.item[var4_4][1] * 20)) ** GOTO lbl11
                var5_5 = Ui.i();
                if (this.item[var4_4][2] != 2) break block9;
                var3_3 = 55;
lbl22:
                // 2 sources

                while (true) {
                    var5_5.drawUi(var3_3, this.map_x + this.item[var4_4][0] * 20 + 10, this.map_y + this.item[var4_4][1] * 20 + 20, 33, 0);
                    ** GOTO lbl11
                    break;
                }
            }
            var3_3 = 54;
            ** while (true)
        }
        if ((var1_1[var3_3].other[4] == 1 || var1_1[var3_3].other[4] == 2) && this.isNpcSrc(var1_1[var3_3].x, var1_1[var3_3].y)) {
            if (var1_1[var3_3].other[8] != 3 && !this.npcNameData[var3_3].equals("\u8def\u4eba")) {
                Map.g.drawImage(this.imgShadow, this.map_x + var1_1[var3_3].x + 10, this.map_y + var1_1[var3_3].y + 20, 33);
            }
            this.drawNpcAniOne(var1_1, var3_3);
        }
        this.runNpcAniOne(var1_1, var3_3);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void drawNpcAni(Npc[] var1_1) {
        if (var1_1 == null) {
            return;
        }
        var2_2 = 0;
        while (true) {
            if (var2_2 >= var1_1.length) ** continue;
            if ((var1_1[var2_2].other[4] == 1 || var1_1[var2_2].other[4] == 2) && this.isNpcSrc(var1_1[var2_2].x, var1_1[var2_2].y)) {
                this.drawNpcAniOne(var1_1, var2_2);
            }
            this.runNpcAniOne(var1_1, var2_2);
            var2_2 = (byte)(var2_2 + 1);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void drawNpcAniOne(Npc[] var1_1, int var2_2) {
        block5: {
            var6_3 = (short)(var1_1[var2_2].other[3] - 1);
            var7_4 = var1_1[var2_2].other[2];
            var5_5 = var1_1[var2_2].other[7];
            var4_6 = var1_1[var2_2].now_action;
            var3_7 = var5_5;
            if (var5_5 < 0) {
                var1_1[var2_2].dir = (byte)4;
                var3_7 = (byte)(-var5_5);
            }
            if (var1_1[var2_2].now_action < Map.npcSp[var6_3][var7_4].aLength(var3_7)) break block5;
            var8_8 = var1_1[var2_2];
            var5_5 = 0;
            var8_8.now_action = 0;
            if (var1_1[var2_2].other[8] == -4) {
                var1_1[var2_2].other[8] = 0;
                var1_1[var2_2].other[4] = 0;
lbl16:
                // 3 sources

                return;
            }
            var4_6 = var5_5;
            if (var1_1[var2_2].bdir) break block5;
            var4_6 = var5_5;
            if (!this.setlastA(var1_1, var2_2)) break block5;
            this.drawNpcAniOne(var1_1, var2_2);
            ** GOTO lbl16
        }
        var9_9 = Ui.i();
        var8_8 = Map.npcSp[var6_3][var7_4];
        var3_7 = Map.npcSp[var6_3][var7_4].action(var3_7, var4_6, 0);
        var4_6 = this.map_x;
        var5_5 = var1_1[var2_2].x;
        var7_4 = this.map_y;
        var6_3 = var1_1[var2_2].y;
        if (var1_1[var2_2].dir == 4) {
            var2_2 = 1;
lbl34:
            // 2 sources

            while (true) {
                var9_9.drawFrameOne((Sprite)var8_8, var3_7, var4_6 + var5_5 + 10, var7_4 + var6_3 + 19, var2_2);
                ** continue;
                break;
            }
        }
        var2_2 = 0;
        ** while (true)
    }

    private void drawNpcFace(int n, int n2, int n3) {
        if (this.imgFace != null) {
            Ui.i().drawImage(this.imgFace, this.face_c + n, n2, n3);
        }
        this.face_c = Ms.i().mathSpeedN((int)this.face_c, 0, 20, false);
    }

    /*
     * Unable to fully structure code
     */
    private void drawSrcEffect() {
        block8: {
            var4_1 = false;
            var2_2 = Constants_H.WIDTH__;
            var1_3 = Constants_H.HEIGHT__;
            if (this.srcFlash_c > 0) {
                var3_4 = this.srcFlash_c;
                this.srcFlash_c = (byte)(var3_4 - 1);
                if (var3_4 % 2 == 0) {
                    Ui.i().fillRect(0xFFFFFF, 0, 0, var2_2, var1_3);
                }
            }
            if (this.bSrc) {
                var3_4 = Constants_H.SRC_BATTLE_H__;
                Map.g.setColor(0);
                Map.g.fillRect(0, this.black_width - var3_4 - this.bSrc_c, var2_2, var3_4);
                Map.g.fillRect(0, var1_3 - this.black_width + this.bSrc_c, var2_2, var3_4);
            }
            if (this.my.state != 22) ** GOTO lbl22
            var5_5 = Map.g;
            if (this.eventGoing != 2) break block8;
            var1_3 = var1_3 - this.gr.about_d.length * 29 >> 1;
lbl18:
            // 2 sources

            while (true) {
                if (this.eventGoing == 2) {
                    var4_1 = true;
                }
                this.drawBlackSRC(var5_5, var1_3, var4_1);
lbl22:
                // 2 sources

                return;
            }
        }
        var1_3 = 45;
        ** while (true)
    }

    private void drawStep(Graphics graphics, int n, int n2, int n3) {
        if (this.bStep > 0) {
            byte by;
            graphics.setColor(0x3C3B3B);
            graphics.drawRect(n + 1, n2, n3 - 2, n3);
            graphics.drawRect(n, n2 + 1, n3, n3 - 2);
            graphics.setColor(0xCCCCCC);
            graphics.drawRect(n + 2, n2 + 1, n3 - 4, n3 - 2);
            graphics.drawRect(n + 1, n2 + 2, n3 - 2, n3 - 4);
            Ui.i().fillRect(0xFFFFFF, n + 2, n2 + 2, n3 - 3, n3 - 3);
            Ui.i().drawUi(67, (n3 >> 1) + n, (n3 >> 1) + n2, 2 | 1, 0);
            if (this.bStep % 12 < 6) {
                Ui.i().drawLine(0xEE0000, n + n3 - 1, n2, n, n2 + n3 - 1);
                Ui.i().drawLine(0, n + n3, n2, n, n2 + n3);
                Ui.i().drawLine(0xEE0000, n + n3, n2 + 1, n + 1, n2 + n3);
            }
            this.bStep = by = (byte)(this.bStep - 1);
            if (by < 2) {
                this.bStep = (byte)100;
            }
        }
    }

    private void exitBoss(int n, int n2, int n3, int n4) {
        this.chuansong(n, 0);
        this.bExitBoss = true;
        this.my.setXY(n2, n3, 0, 0);
        this.my.dir = (byte)n4;
    }

    private void getInMap(byte by, byte[][] byArray) {
        this.my.dir = (byte)((byArray[by][2] - 1) / 2 * 2 + 1 + byArray[by][2] % 2);
        this.my.setXY((int)byArray[by][0], (int)byArray[by][1], 0, 0);
    }

    /*
     * Unable to fully structure code
     */
    private void getItem() {
        block4: {
            if (this.item[this.get_meet][2] == 2) {
                this.gr.say("\u8fd9\u4e2a\u5b9d\u7bb1\u662f\u7a7a\u7684\u3002", 0);
lbl3:
                // 2 sources

                return;
            }
            var1_1 = (byte)(this.item[this.get_meet][3] - 2);
            if (var1_1 == -2) {
                var2_2 = this.gr;
                var2_2.money += this.item[this.get_meet][4] * 100;
                this.gr.say("\u83b7\u5f97\u91d1\u94b1\uff1a" + this.item[this.get_meet][4] * 100 + "\u91d1", 0);
lbl10:
                // 3 sources

                while (true) {
                    this.item[this.get_meet][2] = 2;
                    ** continue;
                    break;
                }
            }
            if (var1_1 != -1) break block4;
            var2_3 = this.gr;
            var2_3.coin += this.item[this.get_meet][4];
            this.gr.say("\u83b7\u5f97\u5fbd\u7ae0\uff1a" + this.item[this.get_meet][4] + "\u5fbd\u7ae0", 0);
            ** GOTO lbl10
        }
        this.gr.getItem((int)var1_1, (int)this.item[this.get_meet][4]);
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private void getItemData(ByteArrayOutputStream byteArrayOutputStream, byte[][] byArray) {
        try {
            byteArrayOutputStream.write(byArray.length);
            int n = 0;
            while (true) {
                if (n >= byArray.length) {
                    return;
                }
                byteArrayOutputStream.write(byArray[n].length);
                byteArrayOutputStream.write(byArray[n]);
                ++n;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    private void getNpcData(ByteArrayOutputStream byteArrayOutputStream, Npc[] npcArray) {
        int n = 0;
        while (true) {
            try {
                if (n >= npcArray.length) {
                    return;
                }
                if (npcArray[n].other[9] == 1) {
                    byteArrayOutputStream.write(npcArray[n].other);
                }
                ++n;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return;
            }
        }
    }

    private byte[] getNpcData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.getNpcData(byteArrayOutputStream, this.npc[0]);
        this.getNpcData(byteArrayOutputStream, this.npc[1]);
        this.getNpcData(byteArrayOutputStream, this.npc[2]);
        this.getItemData(byteArrayOutputStream, this.item);
        this.getItemData(byteArrayOutputStream, this.door);
        return byteArrayOutputStream.toByteArray();
    }

    private byte getNpcId(int n) {
        return (byte)(this.npcPos[n] & 0x3F);
    }

    private byte getNpcLayer(int n) {
        return (byte)((this.npcPos[n] & 0xFF) >> 6);
    }

    /*
     * Enabled force condition propagation
     */
    private short getNpcListY(int n) {
        if (this.npcList[n] == -1) {
            return (short)(this.my.y + this.dir_select[this.my.dir][1] * this.my.speed);
        }
        if (this.npcList[n] >= -1) return this.npc[0][this.npcList[n]].y;
        byte[][] byArray = this.item;
        Ms.i();
        return (short)(byArray[Ms.abs((int)this.npcList[n]) - 2][1] * 20);
    }

    /*
     * Unable to fully structure code
     */
    private void ifEvent(int var1_1, int var2_2, int var3_3, int var4_4, boolean var5_5) {
        if (this.setSIfElse(var4_4, var5_5, true)) {
            var6_6 = this.event_now;
            var6_6[var1_1] = (short)(var6_6[var1_1] + var2_2);
            this.nextEvent(var3_3);
lbl5:
            // 3 sources

            return;
        }
        if (!this.setSIfElse(var4_4, var5_5, false)) ** GOTO lbl5
        this.setEventNow(var1_1, false);
        ** while (true)
    }

    private void init() {
        this.initBrowImage();
        this.initWalkIco();
        this.initHudong();
        this.configureNpc();
        if (npcSp[1][0] == null) {
            Map.npcSp[1][0] = new Sprite();
            this.my = new Npc(8);
            this.my.other[4] = 1;
            this.setAnole();
        }
        if (this.imgShadow == null) {
            this.imgShadow = Ms.i().createImage("data/shadow");
        }
    }

    /*
     * Unable to fully structure code
     */
    private boolean initAuto(Npc var1_1, int var2_2) {
        block5: {
            block6: {
                if (var1_1.timeMove != 0) break block6;
                if (var1_1.frame_c == -1) {
                    Ms.i();
                    if (Ms.getRandom((int)100) < 50) {
                        var3_3 = true;
lbl7:
                        // 2 sources

                        while (true) {
                            var1_1.b_auto = var3_3;
                            Ms.i();
                            if (Ms.getRandom((int)100) < 50) {
                                Ms.i();
                                var1_1.timeMove = (byte)(-(Ms.getRandom((int)var2_2) + 20));
                                var1_1.setActionNo(false);
                                var3_3 = false;
lbl17:
                                // 4 sources

                                return var3_3;
                            }
                            break block5;
                            break;
                        }
                    }
                    var3_3 = false;
                    ** continue;
                }
                var3_3 = false;
                ** GOTO lbl17
            }
            if (var1_1.timeMove >= 0) break block5;
            var1_1.timeMove = (byte)(var1_1.timeMove + 1);
            var3_3 = false;
            ** GOTO lbl17
        }
        var3_3 = true;
        ** while (true)
    }

    private void initBoat(int n) {
        this.my.state = (byte)9;
        this.anole_type = (byte)5;
        this.setAnole();
        this.boatSelect = (byte)n;
        this.gr.cur_a = 0;
        this.my.setIXY((int)this.boatCourse[this.boatSelect][this.gr.cur_a], (int)this.boatCourse[this.boatSelect][this.gr.cur_a + 1]);
    }

    /*
     * Enabled force condition propagation
     */
    private void initCloud() {
        if (this.mapNo == 24 || this.mapNo == 25 || this.mapNo == 26 || this.mapNo == 49 || this.mapNo == 50) {
            if (this.imgCloud == null) {
                this.imgCloud = Ms.i().createImage("data/cloud");
                this.cloud = null;
                this.cloud = new short[4][3];
            }
            int n = 0;
            while (true) {
                if (n >= this.cloud.length) {
                    return;
                }
                this.addCloud(n);
                n = (byte)(n + 1);
            }
        }
        this.cloud = null;
        this.imgCloud = null;
    }

    private void initHudong() {
        this.hudong = Ms.i().createImage("data/brow/hudong");
    }

    /*
     * Unable to fully structure code
     */
    private void initMissionList() {
        var1_1 = Ms.i().rmsOptions(7, null, 1);
        if (var1_1[0] == -1) {
            this.bMission = null;
lbl4:
            // 2 sources

            while (true) {
                var1_1 = null;
                if (this.bMission == null) {
                    this.bMission = new byte[20];
                }
                Ms.i();
                Ms.skip = 0;
                var1_1 = Ms.i().getStream("data/mission0.t", -1);
                this.sMission = Ms.i().createString2Array(var1_1);
                this.smissionLength = this.sMission.length - 1;
                this.sMission = null;
                return;
            }
        }
        this.bMission = var1_1;
        ** while (true)
    }

    private void initMoveMy() {
        this.my.frame_c = this.my.frame_num;
        this.my.setActionNo(true);
        if (this.my.state == 0 && this.gr.monPro.length > 0) {
            this.meetGrass();
        }
    }

    /*
     * Unable to fully structure code
     */
    private void initNpcAni_1(int var1_1, int var2_2, byte[] var3_3) {
        --var1_1;
        block0: while (true) {
            if (var1_1 <= 0) {
                return;
            }
            if (var3_3[var1_1] == 0) break;
            if (Map.npcSp[var2_2][var1_1] == null) {
                this.initNpcAniOne("" + var1_1, var1_1, var2_2);
            }
lbl8:
            // 4 sources

            while (true) {
                --var1_1;
                continue block0;
                break;
            }
            break;
        }
        Map.npcSp[var2_2][var1_1] = null;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private boolean isAnole(int var1_1, int var2_2, int var3_3) {
        block11: {
            block9: {
                block10: {
                    block7: {
                        block8: {
                            if (var3_3 == 0) {
                                var3_3 = 3;
lbl3:
                                // 3 sources

                                while (true) {
                                    var4_4 = 0;
                                    if (var1_1 % 20 != 0) {
                                        var4_4 = (byte)(0 + 1);
                                    }
                                    var5_5 = var4_4;
                                    if (var2_2 % 20 != 0) {
                                        var5_5 = (byte)(var4_4 + 1);
                                    }
                                    if ((var4_4 = (byte)(1 << var5_5)) == 4 && this.worldData[(var1_1 + 19) / 20][var2_2 / 20] == var3_3) {
                                        var6_6 = true;
lbl12:
                                        // 6 sources

                                        return var6_6;
                                    }
                                    break block7;
                                    break;
                                }
                            }
                            if (var3_3 != 2) break block8;
                            var3_3 = 4;
                            ** GOTO lbl3
                        }
                        if (var3_3 == 4) {
                            var3_3 = 2;
                            ** continue;
                        }
                        var6_6 = false;
                        ** GOTO lbl12
                    }
                    if (var4_4 <= 1) break block9;
                    if (var1_1 % 20 == 0 || this.worldData[(var1_1 + 19) / 20][(var2_2 + 19) / 20] != var3_3) break block10;
                    var6_6 = true;
                    ** GOTO lbl12
                }
                if (var2_2 % 20 == 0 || this.worldData[var1_1 / 20][var2_2 / 20] != var3_3) break block9;
                var6_6 = true;
                ** GOTO lbl12
            }
            if (this.worldData[var1_1 / 20][var2_2 / 20] != var3_3) break block11;
            var6_6 = true;
            ** GOTO lbl12
        }
        var6_6 = false;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isAnoleType(int n) {
        if ((this.gr.rmsOther[2] & 1 << n) == 0) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isAuto_canMove(Npc npc, int n, int n2) {
        if (this.checkWorld(npc.x, npc.y, n, n2, false) == 1) return false;
        if (!Ms.i().isRect(npc.x + n, npc.y + n2, 19, 19, (int)this.my.x, (int)this.my.y, 19, 19)) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isCan_not_pass(int n, int n2) {
        if (this.worldData[n][n2] == 1) {
            return true;
        }
        if (this.anole_type == 0) {
            if (this.worldData[n][n2] == 2) return true;
            if (this.worldData[n][n2] == 4) return true;
            return false;
        }
        if (this.anole_type == 2) {
            if (this.worldData[n][n2] == 3) return true;
            if (this.worldData[n][n2] == 2) return true;
            return false;
        }
        if (this.anole_type == 4) {
            if (this.worldData[n][n2] == 2) return false;
            return true;
        }
        if (this.worldData[n][n2] == 2) return true;
        if (this.worldData[n][n2] == 3) return true;
        if (this.worldData[n][n2] == 4) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isCheckAnole(int n) {
        if (this.anole_type != n && this.isAnoleType(n)) {
            this.anole_type = (byte)n;
            this.setAnole();
            return true;
        }
        if (this.isAnoleType(n)) return false;
        this.gr.say("\u6ca1\u6709" + this.gr.monsterT[n] + "\u5750\u9a91" + "\uff0c\u4e0d\u80fd\u901a\u8fc7\u8be5\u5730\u5f62", -1);
        return false;
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isCheckNpcOff() {
        if (this.checkNpcT < 0) {
            return false;
        }
        if (this.my.speed_x != 0) {
            Ms.i();
            byte by = (byte)(20 - Ms.abs((int)(this.my.y - this.npc[0][this.checkNpcT].y)));
            if (by <= 0) return false;
            if (by >= 11) return false;
            return true;
        }
        if (this.my.speed_y == 0) return false;
        Ms.i();
        byte by = (byte)(20 - Ms.abs((int)(this.my.x - this.npc[0][this.checkNpcT].x)));
        if (by <= 0) return false;
        if (by >= 11) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private byte isMapChenk(byte var1_1) {
        block23: {
            block22: {
                block31: {
                    block32: {
                        block20: {
                            block21: {
                                block19: {
                                    block29: {
                                        block30: {
                                            block17: {
                                                block18: {
                                                    block28: {
                                                        block27: {
                                                            block24: {
                                                                block16: {
                                                                    block26: {
                                                                        block25: {
                                                                            var3_2 = 0;
                                                                            var2_3 = 0;
                                                                            var5_4 = (byte)(this.my.x / 20);
                                                                            var4_5 = this.my.y / 20;
                                                                            if (this.my.speed_x != 0) break block24;
                                                                            if (this.my.x % 20 == 0) break block25;
                                                                            var2_3 = 0;
lbl8:
                                                                            // 2 sources

                                                                            while (this.my.speed_y >= 0) {
                                                                                var3_2 = 1;
lbl10:
                                                                                // 2 sources

                                                                                while (true) {
                                                                                    var3_2 = this.checkMap((var5_4 - var2_3) * 20, (var3_2 + var4_5) * 20, 0, 0);
                                                                                    if (this.my.speed_y < 0) break block16;
                                                                                    var2_3 = 1;
lbl14:
                                                                                    // 2 sources

                                                                                    while (true) {
                                                                                        var2_3 = this.checkMap((var5_4 + 1) * 20, (var2_3 + var4_5) * 20, 0, 0);
lbl16:
                                                                                        // 3 sources

                                                                                        while (var3_2 == 1 && var2_3 == 1) lbl-1000:
                                                                                        // 5 sources

                                                                                        {
                                                                                            return var1_1;
                                                                                        }
                                                                                        break block17;
                                                                                        break;
                                                                                    }
                                                                                    break;
                                                                                }
                                                                            }
                                                                            break block26;
                                                                        }
                                                                        var2_3 = 1;
                                                                        ** GOTO lbl8
                                                                    }
                                                                    var3_2 = -1;
                                                                    ** while (true)
                                                                }
                                                                var2_3 = -1;
                                                                ** while (true)
                                                            }
                                                            if (this.my.speed_y != 0) ** GOTO lbl16
                                                            if (this.my.speed_x < 0) break block27;
                                                            var2_3 = 1;
lbl34:
                                                            // 2 sources

                                                            while (this.my.y % 20 != 0) {
                                                                var3_2 = 0;
lbl36:
                                                                // 2 sources

                                                                while (true) {
                                                                    var3_2 = this.checkMap((var2_3 + var5_4) * 20, (var4_5 - var3_2) * 20, 0, 0);
                                                                    if (this.my.speed_x < 0) break block18;
                                                                    var2_3 = 1;
lbl40:
                                                                    // 2 sources

                                                                    while (true) {
                                                                        var2_3 = this.checkMap((var2_3 + var5_4) * 20, (var4_5 + 1) * 20, 0, 0);
                                                                        ** GOTO lbl16
                                                                        break;
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                            break block28;
                                                        }
                                                        var2_3 = -1;
                                                        ** GOTO lbl34
                                                    }
                                                    var3_2 = 1;
                                                    ** while (true)
                                                }
                                                var2_3 = -1;
                                                ** while (true)
                                            }
                                            if (var3_2 != 0) break block20;
                                            if (this.my.speed_x != 0) break block29;
                                            if (this.my.x % 20 == 0) break block30;
                                            var3_2 = 0;
lbl58:
                                            // 2 sources

                                            while (true) {
                                                var3_2 = var5_4 - var3_2;
lbl60:
                                                // 2 sources

                                                while (this.my.speed_y == 0) {
                                                    if (this.my.y % 20 == 0) break block19;
                                                    var6_6 = 0;
lbl63:
                                                    // 2 sources

                                                    while (true) {
                                                        var6_6 = var4_5 - var6_6;
lbl65:
                                                        // 2 sources

                                                        while (this.checkMap(var3_2 * 20, var6_6 * 20, 0, 0) == 0) {
                                                            var1_1 = (byte)-1;
                                                            ** GOTO lbl-1000
                                                        }
                                                        break block20;
                                                        break;
                                                    }
                                                }
                                                break block21;
                                                break;
                                            }
                                        }
                                        var3_2 = 1;
                                        ** while (true)
                                    }
                                    var3_2 = var5_4;
                                    ** GOTO lbl60
                                }
                                var6_6 = 1;
                                ** while (true)
                            }
                            var6_6 = var4_5;
                            ** GOTO lbl65
                        }
                        if (var2_3 != 0) ** GOTO lbl-1000
                        if (this.my.speed_x != 0) break block31;
                        if (this.my.x % 20 == 0) break block32;
                        var2_3 = 0;
lbl87:
                        // 2 sources

                        while (true) {
                            var2_3 += var5_4;
lbl89:
                            // 2 sources

                            while (this.my.speed_y == 0) {
                                if (this.my.y % 20 == 0) break block22;
                                var3_2 = 0;
lbl92:
                                // 2 sources

                                while (true) {
                                    var3_2 += var4_5;
lbl94:
                                    // 2 sources

                                    while (true) {
                                        if (this.checkMap(var2_3 * 20, var3_2 * 20, 0, 0) != 0) ** GOTO lbl-1000
                                        var1_1 = (byte)-2;
                                        ** continue;
                                        break;
                                    }
                                    break;
                                }
lbl98:
                                // 1 sources

                                ** GOTO lbl-1000
                            }
                            break block23;
                            break;
                        }
                    }
                    var2_3 = 1;
                    ** while (true)
                }
                var2_3 = var5_4;
                ** GOTO lbl89
            }
            var3_2 = 1;
            ** while (true)
        }
        var3_2 = var4_5;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isMapEvent(int n, int n2) {
        if ((this.mapInfo[n * 2 + 1] & 1 << n2) == 0) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isMission(int n) {
        byte by = (byte)(n / 8);
        if ((this.bMission[by] & 1 << (n = (int)((byte)(n % 8)))) == 0) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isNpcSrc(int n, int n2) {
        if (this.map_x + n < -80) return false;
        if (this.map_x + n > Constants_H.WIDTH + 60) return false;
        if (this.map_y + n2 < -80) return false;
        if (this.map_y + n2 > Constants_H.HEIGHT + 60) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isTrundleNpc(int n, int n2) {
        byte by = this.checkIfNpc(this.npc[0], n, n2);
        if (by != -1) {
            if (this.npc[0][by].other[4] == 1) return true;
            if (this.npc[0][by].other[4] != 3) return false;
            return true;
        }
        if (n < 0) return true;
        if (n >= this.cols) return true;
        if (n2 < 0) return true;
        if (n2 >= this.rows) return true;
        if (this.worldData[n][n2] == 1) return true;
        return false;
    }

    /*
     * Unable to fully structure code
     */
    private void keyAnoleSel() {
        block6: {
            block10: {
                block9: {
                    block8: {
                        block7: {
                            block5: {
                                if (Ms.i().key_delay()) lbl-1000:
                                // 5 sources

                                {
                                    return;
                                }
                                if (!Ms.i().key_Left_Right()) break block5;
                                this.anoleSel = Ms.i().select((int)this.anoleSel, 0, 4);
                                ** GOTO lbl-1000
                            }
                            if (!Ms.i().key_S1()) break block6;
                            if (this.isAnoleType(this.anoleSel)) break block7;
                            this.gr.say("\u8fd8\u6ca1\u6709\u83b7\u5f97\u8be5\u9a91\u5ba0", 0);
lbl11:
                            // 4 sources

                            while (true) {
                                Ms.i().keyRelease();
                                ** GOTO lbl-1000
                                break;
                            }
                        }
                        if (this.anoleSel != 4) break block8;
                        this.gr.say("\u53ea\u80fd\u5728\u6c34\u91cc\u4f7f\u7528", 0);
                        ** GOTO lbl11
                    }
                    if (this.anole_type != this.anoleSel) break block9;
                    this.anole_type = (byte)-1;
lbl21:
                    // 2 sources

                    while (this.gr.rmsSms[6] == 10 && this.anole_type == 3 && this.gr.rmsSms[0] == 0) {
                        SMSSender.i((GameRun)this.gr).go(1, true);
                        this.anole_type = (byte)-1;
                        ** GOTO lbl11
                    }
                    break block10;
                }
                this.anole_type = this.anoleSel;
                ** GOTO lbl21
            }
            if (this.anole_type == 3 && this.gr.rmsSms[0] == 0) {
                this.gr.say("\u5947\u5f02\u517d\u4e0d\u4ec5\u8dd1\u5f97\u5feb\u800c\u4e14\u53ef\u4ee5\u4e0d\u9047\u654c\uff0c\u73b0\u63d0\u4f9b\u8bd5\u9a91\u4f53\u9a8c\uff0c\u6b63\u7248\u9a8c\u8bc1\u540e\u9700\u8d2d\u4e70\uff01", -1);
            }
            this.gr.magic_id = (byte)13;
            this.gr.magic_x = this.map_x + this.my.x + 10;
            this.gr.magic_y = this.map_y + this.my.y + 19;
            this.gr.setMagic(this.gr.magic_id / 5);
            this.my.state = (byte)21;
            ** while (true)
        }
        if (!Ms.i().key_S2() && !Ms.i().key_Num9()) ** GOTO lbl-1000
        this.my.state = 0;
        Ms.i().keyRelease();
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void keyMiniMap() {
        block4: {
            block3: {
                Ms.i().keyRelease();
                if (Ms.i().key_S1_Num5()) break block3;
                if (!Ms.i().key_S2() && !Ms.i().key_Num0()) break block4;
                this.my.state = 0;
                this.mapdataArea = null;
                this.mapdataMap = null;
            }
lbl8:
            // 3 sources

            return;
        }
        if (!Ms.i().key_Left_Right() && !Ms.i().key_Up_Down() || this.mapdataMap[this.selectMap].length < 6 || this.mapdataMap[this.selectMap][Ms.abs((int)Ms.key) + 1] == -1) ** GOTO lbl8
        this.selectMap = this.mapdataMap[this.selectMap][Ms.abs((int)Ms.key) + 1];
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void keyMission() {
        block8: {
            block11: {
                block6: {
                    block9: {
                        block10: {
                            block7: {
                                if (Ms.i().key_delay()) lbl-1000:
                                // 7 sources

                                {
                                    return;
                                }
                                if (!Ms.i().key_Left_Right() && (!Ms.i().key_Num1() || this.gr.cur_a != 1) && (!Ms.i().key_Num3() || this.gr.cur_a != 0)) break block7;
                                var2_1 = this.gr;
                                var2_1.cur_a = (byte)(var2_1.cur_a ^ 1);
                                this.goMission(this.gr.cur_a, this.bPause);
                                ** GOTO lbl-1000
                            }
                            if (!Ms.i().key_Up_Down()) break block8;
                            if (this.gr.cur_a != 0) break block9;
                            if (this.bMission[14] + 1 <= this.sMission.length) break block10;
                            var1_2 = this.sMission.length;
lbl14:
                            // 2 sources

                            while (true) {
                                var1_2 = (byte)var1_2;
lbl16:
                                // 2 sources

                                while (true) {
                                    Ms.i().selectS(this.gr.select[0], 0, var1_2, (int)this.gr.line_max);
                                    if (this.gr.cur_a != 0) break block6;
                                    this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), 640 - 50, 0);
                                    ** GOTO lbl-1000
                                    break;
                                }
                                break;
                            }
                        }
                        var1_2 = this.bMission[14] + 1;
                        ** while (true)
                    }
                    var1_2 = this.mDirect.length;
                    ** while (true)
                }
                if (this.mDirect.length <= 0) break block11;
                this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 640 - 50, 0);
                ** GOTO lbl-1000
            }
            this.gr.about_a = null;
            ** GOTO lbl-1000
        }
        if (!Ms.i().key_S2() && !Ms.i().key_Num1() && !Ms.i().key_Num3()) ** GOTO lbl-1000
        this.my.state = 0;
        if (this.bPause) {
            this.gr.doPaint(0);
            GameRun.run_state = 97;
lbl40:
            // 2 sources

            while (true) {
                this.mDirect = null;
                this.sMission = null;
                this.gr.about_a = null;
                Ms.i().keyRelease();
                ** continue;
                break;
            }
        }
        GameRun.run_state = -10;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void keyMySave() {
        if (Ms.i().key_S1()) {
            this.my.state = 0;
            this.eventGoing = (byte)2;
lbl4:
            // 3 sources

            return;
        }
        if (!Ms.i().key_S2()) ** GOTO lbl4
        this.my.state = 0;
        this.eventGoing = (byte)3;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void keySelectMenu() {
        block2: {
            if (Ms.i().key_delay()) lbl-1000:
            // 4 sources

            {
                return;
            }
            if (!Ms.i().key_S1_Num5()) break block2;
            this.my.state = (byte)13;
            ** GOTO lbl-1000
        }
        if (!Ms.i().key_Up_Down()) ** GOTO lbl-1000
        this.gr.cur_a = Ms.i().select((int)this.gr.cur_a, 0, this.gr.action_str.length - 1);
        ** while (true)
    }

    /*
     * Exception decompiling
     */
    private void loadMapData(int var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.IllegalStateException: Backjump on non jumping statement @NONE, blocks:[17, 15] lbl89 : TryStatement: try { 5[TRYBLOCK]
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
    private void loadMapModuleAndImage() {
        Ms.i();
        Ms.skip = 0;
        byte[] byArray = Ms.i().getStream("data/map/area.dat", -1);
        byte[] byArray2 = Ms.i().createArray(byArray);
        byte[][] byArray3 = Ms.i().create2Array(byArray);
        byte[] byArray4 = null;
        if (this.mapImg != null && byArray2[this.lastMap] == byArray2[this.mapNo]) {
            byte[] byArray5 = null;
            byte[][] byArray6 = null;
            return;
        }
        Ms.i();
        Ms.skip = 0;
        this.moduleData = Ms.i().createShort2Array(Ms.i().getStream("data/map/" + byArray2[this.mapNo] + ".data", -1), 1);
        this.mapImg = null;
        this.mapImg = new Image[byArray3[byArray2[this.mapNo]].length];
        int n = 0;
        while (true) {
            if (n >= byArray3[byArray2[this.mapNo]].length) {
                byte[] byArray7 = null;
                byte[][] byArray8 = null;
                return;
            }
            this.mapImg[n] = Ms.i().createImage("data/map/" + byArray3[byArray2[this.mapNo]][n]);
            n = (byte)(n + 1);
        }
    }

    /*
     * Enabled force condition propagation
     */
    private int map_set(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n2 <= n3) {
            return n5 - n6 * n2 >> 1;
        }
        if (n + 1 <= n4) {
            return 0;
        }
        if (n < n2 - n4) return n5 / 2 - n * n6 - n6 / 2;
        return n5 - n2 * n6;
    }

    /*
     * Enabled force condition propagation
     */
    private void meetGrass() {
        if (this.meet_step < this.step_MEET) {
            if (this.worldData[this.my.getIx()][this.my.getIy()] != 7) {
                this.meet_step = (short)(this.meet_step + 1);
            }
            return;
        }
        if (this.gr.monPro.length > 1 && this.gr.immueEnemy == 0) {
            this.my.frame_c = 0;
            this.my.state = (byte)8;
        }
        this.notMeet(0, 0);
    }

    /*
     * Unable to fully structure code
     */
    private void moveOff(byte var1_1, byte var2_2, int var3_3) {
        block5: {
            if (this.my.speed_x == 0) {
                this.my.dir = var1_1;
lbl3:
                // 3 sources

                while (true) {
                    var5_4 = this.my;
                    if (this.my.speed_x != 0) {
                        var4_5 = 0;
lbl7:
                        // 2 sources

                        while (true) {
                            var5_4.speed_x = (byte)var4_5;
                            var5_4 = this.my;
                            if (this.my.speed_y != 0) {
                                var3_3 = 0;
                            }
                            var5_4.speed_y = (byte)var3_3;
                            this.checkMoveOff(this.checkNpcT);
                            this.initMoveMy();
                            return;
                        }
                    }
                    break block5;
                    break;
                }
            }
            if (this.my.speed_y != 0) ** GOTO lbl3
            this.my.dir = var2_2;
            ** while (true)
        }
        var4_5 = var3_3;
        ** while (true)
    }

    private void nextEvent(int n) {
        if ((n & 0x1000) != 0) {
            this.now_eV1 = 0;
            this.now_eV2 = 0;
        }
        if ((n & 0x100) != 0) {
            this.eventGoing = 0;
        }
        if ((n & 0x10) != 0) {
            this.event_state = 1;
        }
        if ((n & 1) != 0) {
            this.my.state = 0;
        }
        this.pkey.initPointer();
    }

    /*
     * Unable to fully structure code
     */
    private void oneMove(Npc var1_1, int var2_2) {
        if (var1_1.frame_c > 0) {
            if (this.srcNpcNo == var2_2) {
                this.mapMove(var1_1.x, var1_1.y, var1_1.speed_x, var1_1.speed_y);
            }
            var1_1.x = (short)(var1_1.x + var1_1.speed_x);
            var1_1.y = (short)(var1_1.y + var1_1.speed_y);
            var1_1.frame_c = (byte)(var1_1.frame_c - 1);
lbl7:
            // 3 sources

            return;
        }
        if (var1_1.frame_c == -1) ** GOTO lbl7
        var1_1.frame_c = (byte)-1;
        var1_1.setActionNo(false);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void runAutoMoveNpc(Npc var1_1, int var2_2) {
        block6: {
            block5: {
                if (this.my.state != 1 || this.get_meet != var2_2) break block5;
                var4_3 = var1_1.other;
                Ms.i();
                var3_4 = Ms.abs((int)var1_1.other[7]) / 3;
                if (this.my.dir < 4) {
                    var2_2 = this.my.dir - 1;
lbl8:
                    // 2 sources

                    while (true) {
                        var4_3[7] = (byte)(var3_4 * 3 + var2_2);
                        if (this.my.dir == 3) {
                            var1_1.other[7] = -var1_1.other[7];
lbl12:
                            // 5 sources

                            return;
                        }
                        break;
                    }
                } else {
                    var2_2 = this.my.dir - 2;
                    ** continue;
                }
                var1_1.dir = (byte)3;
                ** GOTO lbl12
            }
            if (!this.initAuto(var1_1, 10)) ** GOTO lbl12
            if (!var1_1.b_auto) break block6;
            this.runAutoX(var1_1, this.gr.mapMove[(var1_1.other[8] - 5) * 2]);
            ** GOTO lbl12
        }
        this.runAutoY(var1_1, this.gr.mapMove[(var1_1.other[8] - 5) * 2 + 1]);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void runAutoX(Npc var1_1, int var2_2) {
        block11: {
            block8: {
                block10: {
                    block9: {
                        block7: {
                            block6: {
                                if (var1_1.timeMove != 0) break block9;
                                Ms.i();
                                if (Ms.getRandom((int)100) < 50) {
                                    var3_3 = 3;
lbl6:
                                    // 2 sources

                                    while (true) {
                                        var1_1.dir = (byte)var3_3;
                                        if (var1_1.dir != 3) break block6;
                                        var2_2 = (short)(var1_1.x - var1_1.other[0] * 20);
lbl10:
                                        // 2 sources

                                        while (var2_2 <= 20) {
                                            var1_1.timeMove = (byte)(var2_2 / var1_1.speed);
lbl12:
                                            // 5 sources

                                            return;
                                        }
                                        break block7;
                                        break;
                                    }
                                }
                                var3_3 = 4;
                                ** while (true)
                            }
                            var2_2 = (short)((var1_1.other[0] + var2_2) * 20 - var1_1.x);
                            ** GOTO lbl10
                        }
                        Ms.i();
                        var1_1.timeMove = (byte)(Ms.getRandom((int)((var2_2 - 20) / var1_1.speed + 1)) + 20 / var1_1.speed);
                        ** GOTO lbl12
                    }
                    if (var1_1.timeMove <= 0 || var1_1.frame_c >= 1) ** GOTO lbl12
                    if (var1_1.dir != 3) break block10;
                    var2_2 = -var1_1.speed;
lbl29:
                    // 2 sources

                    while (this.isAuto_canMove(var1_1, var2_2, 0)) {
                        if (var1_1.dir != 3) break block8;
                        var2_2 = -var1_1.speed;
lbl32:
                        // 2 sources

                        while (true) {
                            var1_1.setSpeedXY(var2_2, 0);
                            var1_1.timeMove = (byte)(var1_1.timeMove - 1);
                            var1_1.frame_c = 1;
                            var1_1.setActionNo(true);
                            ** GOTO lbl12
                            break;
                        }
                    }
                    break block11;
                }
                var2_2 = var1_1.speed;
                ** GOTO lbl29
            }
            var2_2 = var1_1.speed;
            ** while (true)
        }
        var1_1.timeMove = (byte)-20;
        var1_1.frame_c = (byte)-1;
        var1_1.setActionNo(false);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void runAutoY(Npc var1_1, int var2_2) {
        block11: {
            block8: {
                block10: {
                    block9: {
                        block7: {
                            block6: {
                                if (var1_1.timeMove != 0 || var1_1.frame_c != -1) break block9;
                                Ms.i();
                                if (Ms.getRandom((int)100) < 50) {
                                    var3_3 = 1;
lbl6:
                                    // 2 sources

                                    while (true) {
                                        var1_1.dir = (byte)var3_3;
                                        if (var1_1.dir != 1) break block6;
                                        var2_2 = (short)(var1_1.y - var1_1.other[1] * 20);
lbl10:
                                        // 2 sources

                                        while (var2_2 <= 20) {
                                            var1_1.timeMove = (byte)(var2_2 / var1_1.speed);
lbl12:
                                            // 5 sources

                                            return;
                                        }
                                        break block7;
                                        break;
                                    }
                                }
                                var3_3 = 2;
                                ** while (true)
                            }
                            var2_2 = (short)((var1_1.other[1] + var2_2) * 20 - var1_1.y);
                            ** GOTO lbl10
                        }
                        Ms.i();
                        var1_1.timeMove = (byte)(Ms.getRandom((int)((var2_2 - 20) / var1_1.speed + 1)) + 20 / var1_1.speed);
                        ** GOTO lbl12
                    }
                    if (var1_1.timeMove <= 0 || var1_1.frame_c >= 1) ** GOTO lbl12
                    if (var1_1.dir != 1) break block10;
                    var2_2 = -var1_1.speed;
lbl29:
                    // 2 sources

                    while (this.isAuto_canMove(var1_1, 0, var2_2)) {
                        if (var1_1.dir != 1) break block8;
                        var2_2 = -var1_1.speed;
lbl32:
                        // 2 sources

                        while (true) {
                            var1_1.setSpeedXY(0, var2_2);
                            var1_1.timeMove = (byte)(var1_1.timeMove - 1);
                            var1_1.frame_c = 1;
                            var1_1.setActionNo(true);
                            ** GOTO lbl12
                            break;
                        }
                    }
                    break block11;
                }
                var2_2 = var1_1.speed;
                ** GOTO lbl29
            }
            var2_2 = var1_1.speed;
            ** while (true)
        }
        var1_1.timeMove = (byte)-20;
        var1_1.frame_c = (byte)-1;
        var1_1.setActionNo(false);
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private void runBoat() {
        byte by;
        if (this.boatSelect == -1 || this.my.ix != -1 || this.my.iy != -1) {
            return;
        }
        this.my.state = (byte)9;
        GameRun gameRun = this.gr;
        gameRun.cur_a = by = (byte)(gameRun.cur_a + 2);
        if (by >= this.boatCourse[this.boatSelect].length) {
            this.boatSelect = (byte)-1;
            this.my.state = 0;
            this.anole_type = (byte)-1;
            this.setAnole();
            return;
        }
        this.checkType = this.checkIfOther(this.door, this.my.x, this.my.y);
        if (this.checkType != -1) {
            this.my.state = (byte)5;
            this.get_meet = this.checkType;
        }
        this.my.setIXY((int)this.boatCourse[this.boatSelect][this.gr.cur_a], (int)this.boatCourse[this.boatSelect][this.gr.cur_a + 1]);
    }

    /*
     * Unable to fully structure code
     */
    private void runEvent_brow(int var1_1) {
        block4: {
            block3: {
                block2: {
                    var2_2 = this.event[var1_1][this.event_now[var1_1] + 2] - 1;
                    if (var2_2 != -1) break block2;
                    Map.cur_npc = this.my;
lbl4:
                    // 2 sources

                    while (this.event[var1_1][this.event_now[var1_1] + 4] == 0) {
                        Map.cur_npc.brow_type = this.event[var1_1][this.event_now[var1_1] + 3];
                        Map.cur_npc.brow_action = 0;
                        Map.cur_npc.brow_time = 0;
lbl8:
                        // 4 sources

                        while (true) {
                            var3_3 = this.event_now;
                            var3_3[var1_1] = (short)(var3_3[var1_1] + 5);
                            this.nextEvent(4112);
                            return;
                        }
                    }
                    break block3;
                }
                Map.cur_npc = this.npc[this.getNpcLayer(var2_2)][this.getNpcId(var2_2)];
                ** GOTO lbl4
            }
            if (this.event[var1_1][this.event_now[var1_1] + 4] != 1) break block4;
            Map.cur_npc.other[6] = this.event[var1_1][this.event_now[var1_1] + 3];
            ** GOTO lbl8
        }
        if (this.event[var1_1][this.event_now[var1_1] + 4] != 2) ** GOTO lbl8
        Map.cur_npc.brow_type = (byte)-1;
        Map.cur_npc.other[6] = 0;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void runEvent_dialog(int var1_1) {
        this.checkNpcT = (byte)-1;
        if (this.eventGoing == 0) {
            this.eventGoing = 1;
            if (this.anole_type == 1) {
                this.setAnole();
            }
            if ((var2_2 = this.event[var1_1][this.event_now[var1_1] + 2] - 1) == -1) {
                this.npcName = "\u585e\u5176";
                this.now_eV2 = 0;
lbl9:
                // 2 sources

                while (true) {
                    this.initNpcFaceOne(this.npcName);
                    Ms.i();
                    Ms.font.setSize(22);
                    this.dialog = Ms.i().groupString(Ms.i().getDialogs(this.event[var1_1], this.event_now[var1_1] + 5, (int)this.event[var1_1][this.event_now[var1_1] + 4]), Constants_H.WIDTH__ - 20);
                    if (!this.fontSizeControl) {
                        Ms.i();
                        Ms.font.setSize(26);
                    }
                    this.dialog_no = 0;
                    this.my.state = 1;
                    this.bDirTalk = false;
lbl22:
                    // 3 sources

                    return;
                }
            }
            this.now_eV1 = this.getNpcLayer(var2_2);
            this.now_eV2 = this.getNpcId(var2_2);
            this.npcName = this.npcNameData[this.now_eV2];
            if (this.npcName.equals("\u8def\u4eba")) {
                this.npcName = null;
            }
            this.now_eV2 = this.npc[this.now_eV1][this.now_eV2].other[2];
            ** continue;
        }
        if (this.eventGoing != 2) ** GOTO lbl22
        var3_3 = this.event_now;
        var3_3[var1_1] = (short)(var3_3[var1_1] + ((this.event[var1_1][this.event_now[var1_1] + 4] << 1) + 5));
        this.nextEvent(4369);
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private void runEvent_getMon(int n) {
        this.gmErr = false;
        if (this.gr.getMonster((int)this.event[n][this.event_now[n] + 2], (int)this.event[n][this.event_now[n] + 3], (int)this.event[n][this.event_now[n] + 4], -1) == -1) {
            this.gr.say("\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1\uff0c\u65e0\u6cd5\u83b7\u5f97\u65b0\u7684\u5ba0\u7269\uff0c\u8bf7\u6574\u7406\u5bc4\u5b58\u6240\u7a7a\u51fa\u4e00\u4e2a\u7a7a\u95f4\u3002", -1);
            this.gmErr = true;
            this.gr.mini_state = (byte)6;
            this.gr.view_state = 1;
            this.gr.goVIEW_MONSTER();
            return;
        }
        short[] sArray = this.event_now;
        sArray[n] = (short)(sArray[n] + (this.event[n][this.event_now[n] + 1] + 2));
        this.nextEvent(4368);
    }

    /*
     * Unable to fully structure code
     */
    private void runEvent_goShop(int var1_1) {
        block11: {
            block10: {
                block9: {
                    block7: {
                        block8: {
                            var2_2 = this.event[var1_1][this.event_now[var1_1] + 3];
                            if (var2_2 != 4) break block7;
                            if (this.inShop == 0 && this.my.state != 16) {
                                this.my.state = (byte)16;
                                this.inShop = 1;
                                this.gr.setAction_str(new String[]{"\u56de\u590d", "\u4e0d\u56de\u590d"});
                                this.gr.popMenu = 0;
                                this.gr.sell_money = 0;
                                var1_1 = 0;
                                while (true) {
                                    if (var1_1 >= this.gr.myMon_length) lbl-1000:
                                    // 6 sources

                                    {
                                        return;
                                    }
                                    var3_3 = this.gr;
                                    var3_3.sell_money += this.gr.myMonsters[var1_1].monster[4] * 20 + 40;
                                    var1_1 = (byte)(var1_1 + 1);
                                }
                            }
                            if (this.my.state != 0) ** GOTO lbl-1000
                            if (this.inShop != 1 || this.gr.popMenu != 0) break block8;
                            this.inShop = (byte)2;
                            if (!this.gr.checkMonster() && this.gr.isMoney(this.gr.sell_money, true)) {
                                this.gr.healMonster(true);
                            }
                            ** GOTO lbl-1000
                        }
                        if (this.gr.say_c != 0) ** GOTO lbl-1000
                        this.inShop = 0;
                        var3_4 = this.event_now;
                        var3_4[var1_1] = (short)(var3_4[var1_1] + 4);
                        this.nextEvent(0);
                        ** GOTO lbl-1000
                    }
                    if (var2_2 < 3) {
                        this.gr.goBUY_ITEM((int)this.event[var1_1][this.event_now[var1_1] + 2], (int)var2_2);
lbl34:
                        // 6 sources

                        while (true) {
                            var3_5 = this.event_now;
                            var3_5[var1_1] = (short)(var3_5[var1_1] + 4);
                            this.nextEvent(16);
                            ** continue;
                            break;
                        }
                    }
                    if (var2_2 != 3) break block9;
                    this.gr.goVIEW_COMPUTER(0);
                    ** GOTO lbl34
                }
                if (var2_2 != 5) break block10;
                this.gr.goNidus(0);
                ** GOTO lbl34
            }
            if (var2_2 != 6) break block11;
            this.gr.view_state = (byte)4;
            this.gr.popMenu = (byte)-1;
            ** GOTO lbl34
        }
        if (var2_2 != 7) ** GOTO lbl34
        this.gr.view_state = 1;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void runEvent_item_add_del(int var1_1) {
        block8: {
            block5: {
                block4: {
                    block7: {
                        block6: {
                            var2_2 = 0;
                            if (this.eventGoing != 0) break block5;
                            this.now_eV1 = this.event[var1_1][this.event_now[var1_1] + 2];
                            this.now_eV2 = this.event[var1_1][this.event_now[var1_1] + 3];
                            if (this.event[var1_1][this.event_now[var1_1] + 3] < 0) break block6;
                            var1_1 = this.gr.addItem((int)this.now_eV1, (int)this.now_eV2);
lbl7:
                            // 3 sources

                            while (true) {
                                if (var1_1 == -1) ** GOTO lbl17
                                var4_5 = this.gr;
                                if (this.now_eV2 < 0) break block4;
                                var3_3 = "\u83b7\u5f97\uff1a";
lbl12:
                                // 2 sources

                                while (true) {
                                    var3_3 = new StringBuilder(String.valueOf(var3_3)).append(this.gr.getNameItem((int)this.now_eV1)).append("x");
                                    Ms.i();
                                    var4_5.say(var3_3.append(Ms.abs((int)this.now_eV2)).toString(), 0);
lbl17:
                                    // 2 sources

                                    this.eventGoing = 1;
lbl18:
                                    // 4 sources

                                    return;
                                }
                                break;
                            }
                        }
                        var1_1 = this.gr.findItem(-2, (int)this.now_eV1, true);
                        Ms.i();
                        if (var1_1 < Ms.abs((int)this.now_eV2)) break block7;
                        var3_3 = this.gr;
                        var1_1 = this.now_eV1;
                        Ms.i();
                        var3_3.deleteItems(var1_1, Ms.abs((int)this.now_eV2));
                        var1_1 = var2_2;
                        ** GOTO lbl7
                    }
                    var1_1 = -1;
                    this.gr.say("\u9053\u5177\u4e0d\u8db3\uff01", 0);
                    ** while (true)
                }
                var3_3 = "\u5931\u53bb\uff1a";
                ** while (true)
            }
            if (this.gr.say_c != 0) ** GOTO lbl18
            if (-1 != 0) break block8;
            this.setEventNow(var1_1, true);
            ** GOTO lbl18
        }
        var3_4 = this.event_now;
        var3_4[var1_1] = (short)(var3_4[var1_1] + 4);
        this.nextEvent(4368);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void runEvent_miniGame_myLevel(int var1_1) {
        block12: {
            block10: {
                block11: {
                    block4: {
                        block9: {
                            block5: {
                                block6: {
                                    block8: {
                                        block7: {
                                            var2_2 = this.event[var1_1][this.event_now[var1_1] + 2];
                                            if (var2_2 > 1) {
                                                var3_3 = this.event_now;
                                                var3_3[var1_1] = (short)(var3_3[var1_1] + 3);
                                                this.nextEvent(4368);
lbl6:
                                                // 14 sources

                                                return;
                                            }
                                            if (this.eventGoing >= 2) break block4;
                                            if (var2_2 != 0) break block5;
                                            if (this.gr.magic_id != -2) break block6;
                                            if (this.gr.rmsOther[3] != 5) break block7;
                                            this.gr.magic_id = (byte)-2;
                                            this.eventGoing = (byte)2;
                                            this.gr.say("\u60a8\u5f53\u524d\u7684\u8bad\u7ec3\u5e08\u7b49\u7ea7\u5df2\u8fbe\u5230\u4e0a\u9650\uff01", 0);
                                            ** GOTO lbl6
                                        }
                                        this.gr.sell_money = this.gr.isMyLevel(true);
                                        if (this.gr.sell_money != -1) break block8;
                                        this.my.state = (byte)10;
                                        this.gr.magic_id = (byte)28;
                                        this.gr.magic_x = this.map_x + this.my.x + 10;
                                        this.gr.magic_y = this.map_y + this.my.y + 19;
                                        this.gr.setMagic(this.gr.magic_id / 5);
                                        this.gr.setMaxTakes(false);
                                        ** GOTO lbl6
                                    }
                                    this.eventGoing = (byte)2;
                                    ** GOTO lbl6
                                }
                                if (this.gr.magic_id != -1) ** GOTO lbl6
                                this.gr.magic_id = (byte)-2;
                                this.eventGoing = (byte)2;
                                this.gr.say("\u606d\u559c\u60a8\u7684\u8bad\u7ec3\u5e08\u7b49\u7ea7\u5df2\u63d0\u5347\u4e3a#7" + this.gr.rmsOther[3] + "#0\uff0c\u60a8\u968f\u8eab\u53ef\u643a\u5e26\u5ba0\u7269\u6570\u91cf#7\u66b4\u589e\u5230" + this.gr.max_takes + "#0\uff0c\u60a8\u5546\u5e97\u80fd\u5b58\u653e\u7684\u5ba0\u7269#7\u66b4\u589e\u5230" + this.gr.max_monsters, -1);
                                ** GOTO lbl6
                            }
                            if (var2_2 != 1) ** GOTO lbl6
                            if (this.eventGoing != 0 || this.gr.monInfoList[104] != 0) break block9;
                            this.gr.sell_money = 0;
                            this.eventGoing = (byte)3;
                            this.gr.say("\u6b64\u6b21\u60a8\u6ca1\u6709\u6355\u83b7\u5230\u5168\u65b0\u7684\u5ba0\u7269\uff0c\u6355\u83b7\u5e76\u4e0d\u662f\u552f\u4e00\u9014\u5f84\uff0c\u6709\u4e9b\u5ba0\u7269\u9700\u8981\u901a\u8fc7\u8fdb\u5316\u624d\u80fd\u83b7\u5f97\u54e6\u3002", -1);
                            ** GOTO lbl6
                        }
                        if (this.eventGoing != 0) ** GOTO lbl6
                        this.eventGoing = (byte)3;
                        this.gr.sell_money = this.gr.monInfoList[104];
                        this.gr.monInfoList[104] = 0;
                        this.gr.say("\u6b64\u6b21\u60a8\u6355\u83b7\u4e86" + this.gr.sell_money + "\u4e2a\u65b0\u5ba0\u7269\uff0c\u8fd9\u91cc\u662f\u738b\u56fd\u8bad\u7ec3\u5e08\u673a\u6784\u5956\u52b1\u7ed9\u60a8\u7684" + this.gr.sell_money + "\u4e2a\u5fbd\u7ae0\uff0c\u5e0c\u671b\u518d\u63a5\u518d\u5389\u54e6\u3002", -1);
                        var3_4 = this.gr;
                        var3_4.coin += this.gr.sell_money;
                        ** GOTO lbl6
                    }
                    if (this.gr.say_c != 0) ** GOTO lbl6
                    if (this.eventGoing != 2) break block10;
                    if (this.gr.rmsOther[3] != 5) break block11;
                    this.gr.say("\u60a8\u5f53\u524d\u7684\u8bad\u7ec3\u5e08\u7b49\u7ea7\u5df2\u8fbe\u5230\u4e0a\u9650\uff01", 0);
lbl56:
                    // 2 sources

                    while (true) {
                        this.eventGoing = (byte)4;
                        ** GOTO lbl6
                        break;
                    }
                }
                this.gr.sell_money = (byte)(this.gr.isMyLevel(false) - this.gr.monInfoList[103]);
                if (this.gr.sell_money < 1) {
                    this.gr.sell_money = 0;
                }
                this.gr.say("\u5f53\u524d\u8bad\u7ec3\u5e08\u7b49\u7ea7\u4e3a#7" + this.gr.rmsOther[3] + "#0\u8ddd\u79bb\u4e0b\u6b21\u5347\u7ea7\u8fd8\u9700\u8981\u6355\u6349#7" + this.gr.sell_money + "#0\u53ea\u4e0d\u540c\u7684\u5ba0\u7269\uff0c\u52aa\u529b\u83b7\u5f97\u65b0\u5ba0\u5427\u3002", -1);
                ** while (true)
            }
            if (this.eventGoing != 3 || this.gr.sell_money <= 0) break block12;
            this.gr.say("\u83b7\u5f97\uff1a\u5fbd\u7ae0x" + this.gr.sell_money, 0);
            this.eventGoing = (byte)4;
            ** GOTO lbl6
        }
        var3_5 = this.event_now;
        var3_5[var1_1] = (short)(var3_5[var1_1] + 3);
        this.nextEvent(4368);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void runEvent_select(int var1_1) {
        block4: {
            block3: {
                if (this.my.state == 12 || this.my.state == 13 || this.my.state == 14) break block3;
                this.sEvent_eV2 = this.event[var1_1][this.event_now[var1_1] + 1];
                this.sEvent_eV1 = 0;
                this.gr.action_str = null;
                this.gr.action_str = new String[this.sEvent_eV2];
                var2_2 = 0;
                while (true) {
                    if (var2_2 >= this.sEvent_eV2) {
                        if (this.sIfElse == -1) break;
                        this.event_state = 1;
                        this.gr.cur_a = this.sIfElse;
                        this.my.state = (byte)13;
                        this.gr.action_str = null;
                        this.sIfElse = (byte)-1;
lbl15:
                        // 5 sources

                        return;
                    }
                    this.gr.action_str[var2_2] = Ms.i().getDialogs(this.event[var1_1], this.event_now[var1_1] + 2 + this.sEvent_eV1 + 1, (int)this.event[var1_1][this.event_now[var1_1] + 2 + this.sEvent_eV1]);
                    this.sEvent_eV1 = (byte)(this.sEvent_eV1 + ((this.event[var1_1][this.event_now[var1_1] + 2 + this.sEvent_eV1] << 1) + 1));
                    var2_2 = (byte)(var2_2 + 1);
                }
                this.gr.cur_a = 0;
                this.my.state = (byte)12;
                ** GOTO lbl15
            }
            if (this.my.state != 13) break block4;
            this.sEvent_eV1 = (byte)(this.sEvent_eV1 + 2);
            var2_3 = (short)((this.event[var1_1][this.event_now[var1_1] + this.sEvent_eV1 + (this.gr.cur_a << 1)] & 255) << 8 | this.event[var1_1][this.event_now[var1_1] + this.sEvent_eV1 + (this.gr.cur_a << 1) + 1] & 255);
            var3_4 = this.event_now;
            var3_4[var1_1] = (short)(var3_4[var1_1] + (this.sEvent_eV1 + (this.sEvent_eV2 << 1) + var2_3));
            this.nextEvent(17);
            ** GOTO lbl15
        }
        if (this.my.state != 14) ** GOTO lbl15
        this.setEventNow(var1_1, true);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void runEvent_srcMove(int var1_1) {
        this.my.state = (byte)10;
        var3_2 = this.event[var1_1][this.event_now[var1_1] + 2] - 1;
        if (var3_2 == -1) {
            var4_3 = this.my.getIx();
            var3_2 = this.my.getIy();
            this.srcNpcNo = (byte)-1;
lbl7:
            // 2 sources

            while (true) {
                var4_3 = this.map_set(var4_3, this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20) - this.map_x;
                var3_2 = this.map_set(var3_2, this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20) - this.map_y;
                Ms.i();
                if (Ms.abs((int)var3_2) < 10) {
                    Ms.i();
                    if (Ms.abs((int)var4_3) < 10) {
                        var5_4 = this.event_now;
                        var5_4[var1_1] = (short)(var5_4[var1_1] + 3);
                        this.nextEvent(4112);
lbl19:
                        // 3 sources

                        return;
                    }
                }
                break;
            }
        } else {
            this.now_eV1 = this.getNpcLayer(var3_2);
            this.now_eV2 = this.getNpcId(var3_2);
            if (this.now_eV1 == 0) {
                var2_5 = this.now_eV2;
lbl26:
                // 2 sources

                while (true) {
                    this.srcNpcNo = var2_5;
                    var4_3 = this.npc[this.now_eV1][this.now_eV2].other[0];
                    var3_2 = this.npc[this.now_eV1][this.now_eV2].other[1];
                    ** continue;
                    break;
                }
            }
            var2_5 = 0;
            ** continue;
        }
        Ms.i();
        if (Ms.abs((int)var4_3) >= 10) {
            var1_1 = this.map_x;
            Ms.i();
            this.map_x = var1_1 + var4_3 / Ms.abs((int)var4_3) * 10;
        }
        Ms.i();
        if (Ms.abs((int)var3_2) < 10) ** GOTO lbl19
        var1_1 = this.map_y;
        Ms.i();
        this.map_y = var1_1 + var3_2 / Ms.abs((int)var3_2) * 10;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    private void runMove() {
        if (this.my.ix != -1 || this.my.iy != -1) {
            this.runSeek(this.my, false);
lbl3:
            // 2 sources

            while (true) {
                this.oneMove(this.my, -1);
                var1_1 = 0;
lbl6:
                // 2 sources

                while (true) {
                    if (var1_1 >= 3) {
                        this.insertNpc();
                        return;
                    }
                    ** GOTO lbl13
                    break;
                }
                break;
            }
        } else {
            this.runBoat();
            ** continue;
        }
lbl13:
        // 1 sources

        var2_2 = 0;
        block2: while (true) {
            if (var2_2 >= this.npc[var1_1].length) {
                var1_1 = (byte)(var1_1 + 2);
                ** continue;
            }
            if (this.npc[var1_1][var2_2].other[4] == 1 || this.npc[var1_1][var2_2].other[4] == 2) break;
lbl19:
            // 2 sources

            while (true) {
                var2_2 = (byte)(var2_2 + 1);
                continue block2;
                break;
            }
            break;
        }
        if (this.npc[var1_1][var2_2].other[8] >= 5) {
            this.runAutoMoveNpc(this.npc[var1_1][var2_2], var2_2);
lbl24:
            // 3 sources

            while (true) {
                this.oneMove(this.npc[var1_1][var2_2], var2_2);
                ** continue;
                break;
            }
        }
        if (this.npc[var1_1][var2_2].ix == -1 && this.npc[var1_1][var2_2].iy == -1) ** GOTO lbl24
        this.runSeek(this.npc[var1_1][var2_2], true);
        ** while (true)
    }

    private void runNpcAniOne(Npc[] npcArray, int n) {
        byte by;
        byte by2 = (byte)(npcArray[n].other[3] - 1);
        byte by3 = npcArray[n].other[2];
        Ms.i();
        byte by4 = (byte)Ms.abs((int)npcArray[n].other[7]);
        if (npcArray[n].now_action >= npcSp[by2][by3].aLength((int)by4)) {
            npcArray[n].now_action = 0;
            this.setlastA(npcArray, n);
        }
        Npc npc = npcArray[n];
        npc.now_time = by = (byte)(npc.now_time + 1);
        if (by >= npcSp[by2][by3].action((int)by4, (int)npcArray[n].now_action, 1)) {
            npc = npcArray[n];
            npc.now_action = (byte)(npc.now_action + 1);
            npcArray[n].now_time = 0;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void runSeek(Npc var1_1, boolean var2_2) {
        block19: {
            block26: {
                block24: {
                    block18: {
                        block17: {
                            block25: {
                                block22: {
                                    block23: {
                                        block20: {
                                            block16: {
                                                block21: {
                                                    var7_3 = var1_1.b_check;
                                                    var6_4 = (short)(var1_1.ix * 20);
                                                    var5_5 = (short)(var1_1.iy * 20);
                                                    if (var1_1.x != var6_4 || var1_1.y != var5_5) break block20;
                                                    if (var1_1.frame_c != -1) ** GOTO lbl18
                                                    var1_1.iy = (byte)-1;
                                                    var1_1.ix = (byte)-1;
                                                    if (!var2_2) break block21;
                                                    var1_1.setIxIy_npc();
lbl10:
                                                    // 2 sources

                                                    while (true) {
                                                        if (!var1_1.bdir) ** GOTO lbl18
                                                        var1_1.other[7] = var1_1.lastAction;
                                                        if (var1_1.lastAction >= 0) break block16;
                                                        var3_6 = 4;
lbl15:
                                                        // 2 sources

                                                        while (true) {
                                                            var1_1.dir = (byte)var3_6;
                                                            var1_1.setLastAction(false, 127);
lbl18:
                                                            // 5 sources

                                                            return;
                                                        }
                                                        break;
                                                    }
                                                }
                                                var1_1.speed = this.getMySpeed();
                                                ** while (true)
                                            }
                                            var3_6 = 3;
                                            ** while (true)
                                        }
                                        if (var1_1.frame_c >= 1) ** GOTO lbl18
                                        if (!var7_3) break block22;
                                        if (var1_1.x == var6_4) break block23;
                                        var4_9 = 1;
lbl31:
                                        // 4 sources

                                        while (var4_9 != 0) {
                                            if ((var1_1.x <= var6_4 || var1_1.x - var1_1.speed >= var6_4) && (var1_1.x >= var6_4 || var1_1.x + var1_1.speed <= var6_4)) break block17;
                                            var1_1.setSpeedXY(var6_4 - var1_1.x, 0);
lbl34:
                                            // 2 sources

                                            while (true) {
                                                if (var1_1.bdir) ** GOTO lbl40
                                                if (var1_1.x <= var6_4) break block18;
                                                var3_7 = 3;
lbl38:
                                                // 2 sources

                                                while (true) {
                                                    var1_1.dir = (byte)var3_7;
lbl40:
                                                    // 4 sources

                                                    while (true) {
                                                        var1_1.frame_c = var1_1.frame_num;
                                                        var1_1.setActionNo(true);
                                                        ** continue;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                break;
                                            }
lbl44:
                                            // 1 sources

                                            ** GOTO lbl18
                                        }
                                        break block24;
                                    }
                                    var4_9 = 0;
                                    ** GOTO lbl31
                                }
                                if (var1_1.y != var5_5) break block25;
                                var4_9 = 1;
                                ** GOTO lbl31
                            }
                            var4_9 = 0;
                            ** GOTO lbl31
                        }
                        if (var1_1.x > var6_4) {
                            var4_9 = -var1_1.speed;
lbl59:
                            // 2 sources

                            while (true) {
                                var1_1.setSpeedXY((int)var4_9, 0);
                                ** continue;
                                break;
                            }
                        }
                        var4_9 = var1_1.speed;
                        ** while (true)
                    }
                    var3_7 = 4;
                    ** while (true)
                }
                if ((var1_1.y <= var5_5 || var1_1.y - var1_1.speed >= var5_5) && (var1_1.y >= var5_5 || var1_1.y + var1_1.speed <= var5_5)) break block26;
                var1_1.setSpeedXY(0, var5_5 - var1_1.y);
lbl70:
                // 2 sources

                while (true) {
                    if (var1_1.bdir) ** GOTO lbl40
                    if (var1_1.y > var5_5) {
                        var3_8 = 1;
lbl74:
                        // 2 sources

                        while (true) {
                            var1_1.dir = (byte)var3_8;
                            ** continue;
                            break;
                        }
                    }
                    break block19;
                    break;
                }
            }
            if (var1_1.y > var5_5) {
                var4_9 = -var1_1.speed;
lbl81:
                // 2 sources

                while (true) {
                    var1_1.setSpeedXY(0, (int)var4_9);
                    ** continue;
                    break;
                }
            }
            var4_9 = var1_1.speed;
            ** while (true)
        }
        var3_8 = 2;
        ** while (true)
    }

    private void setEventNow(int n, boolean bl) {
        if (bl) {
            this.my.state = 0;
        }
        this.now_eV1 = 0;
        this.now_eV2 = 0;
        this.eventGoing = 0;
        this.event_now[n] = 0;
    }

    private void setMapData() {
        this.map_x = this.map_set(this.my.getIx(), this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20);
        this.map_y = this.map_set(this.my.getIy(), this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20);
        this.mapLeft_NOmove = (short)(Constants_H.WIDTH_H - 10);
        this.mapRight_NOmove = (short)(this.cols * 20 - Constants_H.WIDTH_H - 10);
        this.mapUp_NOmove = (short)(Constants_H.HEIGHT_H - 10);
        this.mapDown_NOmove = (short)(this.rows * 20 - Constants_H.HEIGHT_H - 10);
    }

    /*
     * Unable to fully structure code
     */
    private void setMapOffer() {
        block3: {
            block2: {
                if (this.map_y + this.rows * 20 < Constants_H.HEIGHT && this.rows > Constants_H.YCELLS) {
                    this.map_y = Constants_H.HEIGHT - this.rows * 20;
lbl3:
                    // 5 sources

                    return;
                }
                if (this.map_y <= 0 || this.rows <= Constants_H.YCELLS) break block2;
                this.map_y = 0;
                ** GOTO lbl3
            }
            if (this.map_x <= 0 || this.cols <= Constants_H.XCELLS) break block3;
            this.map_x = 0;
            ** GOTO lbl3
        }
        if (this.map_x + this.cols * 20 >= Constants_H.WIDTH || this.cols <= Constants_H.XCELLS) ** GOTO lbl3
        this.map_x = Constants_H.WIDTH - this.cols * 20;
        ** while (true)
    }

    private void setMoveStop_m() {
        this.my.speed_x = 0;
        this.my.speed_y = 0;
        this.my.frame_c = (byte)-1;
        this.my.setActionNo(false);
    }

    /*
     * Unable to fully structure code
     */
    private boolean setSIfElse(int var1_1, boolean var2_2, boolean var3_3) {
        block5: {
            block4: {
                if (var1_1 == 2) {
                    if (var2_2) {
                        var1_1 = 0;
lbl4:
                        // 2 sources

                        while (true) {
                            this.sIfElse = (byte)var1_1;
                            var2_2 = true;
lbl7:
                            // 4 sources

                            return var2_2;
                        }
                    }
                    var1_1 = 1;
                    ** continue;
                }
                if (!var3_3 || !var2_2) break block4;
                var2_2 = true;
                ** GOTO lbl7
            }
            if (var3_3 || var1_1 != 1) break block5;
            var2_2 = true;
            ** GOTO lbl7
        }
        var2_2 = false;
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private boolean setlastA(Npc[] npcArray, int n) {
        if (npcArray[n].lastAction == 127) return false;
        npcArray[n].other[7] = npcArray[n].lastAction;
        npcArray[n].lastAction = (byte)127;
        return true;
    }

    private void turnAround(int n) {
        this.my.dir = (byte)n;
        this.my.setActionNo(true);
    }

    /*
     * Unable to fully structure code
     */
    public void addAnole(int var1_1) {
        block6: {
            block5: {
                block4: {
                    if (var1_1 != 13 && var1_1 != 34 && var1_1 != 49 && var1_1 != 66 && var1_1 != 82) lbl-1000:
                    // 2 sources

                    {
                        return;
                    }
                    if (var1_1 == 13) {
                        var1_1 = 0;
lbl6:
                        // 5 sources

                        while (true) {
                            var2_2 = this.gr.rmsOther;
                            var2_2[2] = (byte)(var2_2[2] | 1 << var1_1);
                            ** continue;
                            break;
                        }
                    }
                    if (var1_1 != 34) break block4;
                    var1_1 = 1;
                    ** GOTO lbl6
                }
                if (var1_1 != 49) break block5;
                var1_1 = 2;
                ** GOTO lbl6
            }
            if (var1_1 != 66) break block6;
            var1_1 = 3;
            ** GOTO lbl6
        }
        var1_1 = 4;
        ** while (true)
    }

    public void bkEvent_getMon() {
        GameRun.run_state = -10;
    }

    /*
     * Unable to fully structure code
     */
    public void bkgroundToPaint(short[] var1_1, Image[] var2_2, int var3_3, int var4_4, short[][] var5_5, Graphics var6_6, int var7_7, int var8_8, int var9_9, int var10_10, boolean var11_11) {
        if (var1_1 == null) {
            return;
        }
        if (var11_11) {
            var6_6.setClip(var7_7, var8_8, var9_9 - var7_7, var10_10 - var8_8);
            var6_6.setColor(this.bgColor);
            var6_6.fillRect(var7_7, var8_8, var9_9 - var7_7, var10_10 - var8_8);
        }
        var12_12 = 0;
        block1: while (true) {
            if (var12_12 >= var1_1.length) ** continue;
            if (var1_1[var12_12 + 2] < 0) ** GOTO lbl22
            var16_16 = var1_1[var12_12 + 2] >> 3;
            var13_13 = var1_1[var12_12 + 2];
            var15_15 = var1_1[var12_12] * 20 - var3_3;
            var17_17 = var1_1[var12_12 + 1] * 20 - (var4_4 - 20);
            if ((var13_13 & 3) % 2 != 1) break;
            var13_13 = var5_5[var16_16][4];
            var14_14 = var5_5[var16_16][3];
lbl19:
            // 2 sources

            while (true) {
                if (var15_15 + var13_13 >= var7_7 && var15_15 <= var9_9 && var17_17 >= var8_8 && var17_17 - var14_14 <= var10_10) {
                    Ui.i().drawRegion(var2_2[var5_5[var16_16][0]], (int)var5_5[var16_16][1], (int)var5_5[var16_16][2], (int)var5_5[var16_16][3], (int)var5_5[var16_16][4], var15_15, var17_17, 4 | 32, var1_1[var12_12 + 2] & 7, var6_6);
                }
lbl22:
                // 4 sources

                var12_12 += 3;
                continue block1;
                break;
            }
            break;
        }
        var13_13 = var5_5[var16_16][3];
        var14_14 = var5_5[var16_16][4];
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void checkRegWhere0(int var1_1) {
        // MONITORENTER : this
        this.isNeedWait = true;
        SMSSender.i((GameRun)this.gr).go(2, true);
        SMSSender.i((GameRun)this.gr).run();
        var2_2 = this.isNeedWait;
        if (!var2_2) ** GOTO lbl-1000
        try {
            System.out.println("wait() start");
            this.wait();
lbl11:
            // 2 sources

            while (true) {
                System.out.println("wait() over");
                break;
            }
        }
        catch (Exception var3_3) {
            var3_3.printStackTrace();
            ** continue;
        }
lbl-1000:
        // 2 sources

        {
            // MONITOREXIT : this
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    public byte checkSoftKey(int var1_1, int var2_2, int var3_3, int var4_4) {
        block9: {
            block5: {
                block7: {
                    block4: {
                        block8: {
                            block6: {
                                if (var1_1 + var3_3 < 0 || var1_1 + var3_3 >= this.cols * 20 || var2_2 + var4_4 < 0 || var2_2 + var4_4 >= this.rows * 20) {
                                    var5_5 = 0;
lbl3:
                                    // 4 sources

                                    return (byte)var5_5;
                                }
                                var5_5 = this.checkIfNpc(this.npc[0], var1_1 + var3_3, var2_2 + var4_4);
                                if (this.my.state != 0 || var5_5 == -1) break block5;
                                if (this.anole_type != 1 || this.npc[0][var5_5].other[8] != 4) break block6;
                                this.npc[0][var5_5].other[8] = -4;
                                var6_6 = this.npc[0][var5_5].other;
                                var6_6[7] = (byte)(var6_6[7] + 1);
                                this.npc[0][var5_5].now_action = 0;
                                this.npc[0][var5_5].now_time = 0;
lbl13:
                                // 5 sources

                                while (true) {
                                    var5_5 = 9;
                                    ** GOTO lbl3
                                    break;
                                }
                            }
                            if (this.npc[0][var5_5].other[8] == -4) ** GOTO lbl13
                            this.my.state = (byte)2;
                            this.get_meet = (byte)var5_5;
                            if (this.npc[0][var5_5].other[8] == 2 || this.npc[0][var5_5].other[8] == 3 || this.npcNameData[var5_5].equals("\u8def\u4eba")) break block7;
                            this.bDirTalk = true;
                            this.npcDirTalk = this.npc[0][var5_5].other[7];
                            var6_7 = this.npc[0][var5_5].other;
                            Ms.i();
                            var2_2 = Ms.abs((int)this.npcDirTalk) / 3;
                            if (this.my.dir >= 4) break block8;
                            var1_1 = this.my.dir - 1;
lbl29:
                            // 2 sources

                            while (true) {
                                var6_7[7] = (byte)(var2_2 * 3 + var1_1);
                                if (this.my.dir != 3) break block4;
                                this.npc[0][var5_5].other[7] = -this.npc[0][var5_5].other[7];
                                ** GOTO lbl13
                                break;
                            }
                        }
                        var1_1 = this.my.dir - 2;
                        ** while (true)
                    }
                    this.npc[0][var5_5].dir = (byte)3;
                    ** GOTO lbl13
                }
                this.bDirTalk = false;
                ** while (true)
            }
            var5_5 = this.checkIfOther(this.item, var1_1 + var3_3, var2_2 + var4_4);
            if (var5_5 == -1 || this.item[var5_5][2] == -1) break block9;
            Ms.i().keyRelease();
            this.get_meet = (byte)var5_5;
            this.getItem();
            var5_5 = 0;
            ** GOTO lbl3
        }
        var5_5 = -1;
        ** while (true)
    }

    public void chuansong(int n, int n2) {
        this.my.state = (byte)5;
        this.mapNotemp = (byte)n;
        this.go = (byte)n2;
        this.setMoveStop_m();
    }

    /*
     * Unable to fully structure code
     */
    public void createEvent() {
        var5_1 = Ms.i().getStream("event", (int)this.mapNo);
        if (var5_1.length == 1) {
            this.eventCount = 0;
            return;
        }
        this.eventCount = var5_1[0];
        if (this.mapInfo[this.mapNo * 2] < 1) {
            this.event_now_list[this.mapNo] = null;
            this.event_now_list[this.mapNo] = new short[this.eventCount];
            while (true) {
                this.event_now = this.event_now_list[this.mapNo];
                this.event = new byte[this.eventCount][];
                var1_2 = 0;
                var2_3 = 0 + 1;
                while (true) {
                    if (var1_2 >= this.eventCount) ** continue;
                    var3_4 = var2_3 + 1;
                    var4_5 = var5_1[var2_3];
                    var2_3 = var3_4 + 1;
                    var3_4 = (short)(var4_5 << 8 | var5_1[var3_4] & 255);
                    this.event[var1_2] = new byte[var3_4];
                    System.arraycopy(var5_1, var2_3, this.event[var1_2], 0, this.event[var1_2].length);
                    var2_3 += var3_4;
                    var1_2 = (byte)(var1_2 + 1);
                }
                break;
            }
        }
        var1_2 = 0;
        while (true) {
            if (var1_2 >= this.eventCount) ** continue;
            if (this.isMapEvent(this.mapNo, var1_2)) {
                this.event_now_list[this.mapNo][var1_2] = 24224;
            }
            var1_2 = (byte)(var1_2 + 1);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    byte[][] createItem(byte[] var1_1, byte[][] var2_2) {
        var2_2 /* !! */  = null;
        if (this.mapInfo[this.mapNo * 2] > 0) {
            var1_1 = this.mapTemp[this.mapNo];
            Ms.i();
            var3_3 = Ms.skip2;
            Ms.skip2 = var3_3 + 1;
            var2_2 /* !! */  = new byte[var1_1[var3_3]][];
            var3_3 = 0;
            block0: while (true) {
                if (var3_3 >= var2_2 /* !! */ .length) {
                    return var2_2 /* !! */ ;
                }
                Ms.i();
                var4_5 = Ms.skip2;
                Ms.skip2 = var4_5 + 1;
                var2_2 /* !! */ [var3_3] = new byte[var1_1[var4_5]];
                var4_5 = 0;
                while (true) {
                    if (var4_5 >= var2_2 /* !! */ [var3_3].length) {
                        ++var3_3;
                        continue block0;
                    }
                    var6_9 = var2_2 /* !! */ [var3_3];
                    Ms.i();
                    var5_7 = Ms.skip2;
                    Ms.skip2 = var5_7 + 1;
                    var6_9[var4_5] = var1_1[var5_7];
                    ++var4_5;
                }
                break;
            }
        }
        Ms.i();
        var3_4 = Ms.skip;
        Ms.skip = var3_4 + 1;
        var6_10 = new byte[var1_1[var3_4]][];
        var3_4 = 0;
        block3: while (true) {
            var2_2 /* !! */  = var6_10;
            if (var3_4 >= var6_10.length) ** continue;
            Ms.i();
            var4_6 = Ms.skip;
            Ms.skip = var4_6 + 1;
            var6_10[var3_4] = new byte[var1_1[var4_6]];
            var4_6 = 0;
            while (true) {
                if (var4_6 >= var6_10[var3_4].length) {
                    ++var3_4;
                    continue block3;
                }
                var2_2 /* !! */  = (byte[][])var6_10[var3_4];
                Ms.i();
                var5_8 = Ms.skip;
                Ms.skip = var5_8 + 1;
                var2_2 /* !! */ [var4_6] = (byte[])var1_1[var5_8];
                ++var4_6;
            }
            break;
        }
    }

    public void createLayer() {
        this.createMap();
        this.setMapData();
    }

    /*
     * Unable to fully structure code
     */
    Npc[] createNpc(byte[] var1_1, Npc[] var2_2) {
        var2_2 = null;
        Ms.i();
        var3_3 = Ms.skip;
        Ms.skip = var3_3 + 1;
        var2_2 = new Npc[var1_1[var3_3]];
        var3_3 = 0;
        block0: while (true) {
            block8: {
                if (var3_3 < var2_2.length) break block8;
                if (this.mapInfo[this.mapNo * 2] <= 0) ** GOTO lbl14
                var3_3 = 0;
lbl12:
                // 2 sources

                while (true) {
                    if (var3_3 < var2_2.length) break block0;
lbl14:
                    // 2 sources

                    return var2_2;
                }
            }
            Ms.i();
            var4_4 = Ms.skip;
            Ms.skip = var4_4 + 1;
            var2_2[var3_3] = new Npc((int)var1_1[var4_4]);
            var4_4 = 0;
            while (true) {
                if (var4_4 >= var2_2[var3_3].other.length) {
                    var2_2[var3_3].setXY_npc();
                    ++var3_3;
                    continue block0;
                }
                var6_6 = var2_2[var3_3].other;
                Ms.i();
                var5_5 = Ms.skip;
                Ms.skip = var5_5 + 1;
                var6_6[var4_4] = var1_1[var5_5];
                ++var4_4;
            }
            break;
        }
        if (var2_2[var3_3].other[9] != 1) ** GOTO lbl40
        var4_4 = 0;
        while (true) {
            block9: {
                if (var4_4 < var2_2[var3_3].other.length) break block9;
                var2_2[var3_3].setXY_npc();
lbl40:
                // 2 sources

                ++var3_3;
                ** continue;
            }
            var1_1 = var2_2[var3_3].other;
            var6_6 = this.mapTemp[this.mapNo];
            Ms.i();
            var5_5 = Ms.skip2;
            Ms.skip2 = var5_5 + 1;
            var1_1[var4_4] = var6_6[var5_5];
            ++var4_4;
        }
    }

    public byte[] createNpcPos(byte[] byArray, byte[] byArray2) {
        byArray2 = null;
        Ms.i();
        int n = Ms.skip;
        Ms.skip = n + 1;
        byArray2 = new byte[byArray[n]];
        n = 0;
        while (n < byArray2.length) {
            Ms.i();
            int n2 = Ms.skip;
            Ms.skip = n2 + 1;
            byArray2[n] = byArray[n2];
            ++n;
        }
        return byArray2;
    }

    public void createNpcString() {
        this.npcNameData = Ms.i().loadText(this.initData(this.gr.createData(1), this.mapNo));
        this.npcStringData = Ms.i().loadText(this.initData(this.gr.createData(2), this.mapNo));
    }

    public void createOther() {
        byte[] byArray = null;
        Ms.i();
        Ms.skip = 0;
        Ms.i();
        Ms.skip2 = 0;
        byArray = this.initData(this.gr.createData(0), this.mapNo);
        this.npcPos = this.createNpcPos(byArray, this.npcPos);
        if (this.mapInfo[this.mapNo * 2] > 0 && this.mapTemp[this.mapNo] == null) {
            this.mapTemp[this.mapNo] = Ms.i().rmsOptions(this.mapNo + 14, null, 1);
        }
        this.npc[0] = this.createNpc(byArray, this.npc[0]);
        this.npc[1] = this.createNpc(byArray, this.npc[1]);
        this.npc[2] = this.createNpc(byArray, this.npc[2]);
        this.item = this.createItem(byArray, this.item);
        this.door = this.createItem(byArray, this.door);
        this.npcList = null;
        this.npcList = new byte[this.npc[0].length + 1 + this.item.length];
        byArray = null;
        this.initNpcAni();
    }

    /*
     * Unable to fully structure code
     */
    public void doKey() {
        switch (this.map_key) lbl-1000:
        // 8 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                return;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                if (this.my.dir != this.map_key) {
                    this.turnAround(this.map_key);
                }
                this.canMove(this.dir_select[this.map_key][0] * this.my.speed, this.dir_select[this.map_key][1] * this.my.speed);
                ** GOTO lbl-1000
            }
            case -53: 
            case 5: {
                if (!this.gr.isTalk) ** GOTO lbl-1000
                this.checkSoftKey(this.my.x, this.my.y, this.dir_select[this.my.dir][0] * this.my.speed, this.dir_select[this.my.dir][1] * this.my.speed);
                ** GOTO lbl-1000
            }
            case -57: {
                Ms.i().keyRelease();
                if (this.gr.rmsOther[2] <= 0) ** GOTO lbl-1000
                this.initAnoleValue();
                ** GOTO lbl-1000
            }
            case -51: {
                this.goMission(1, false);
                ** GOTO lbl-1000
            }
            case -49: {
                this.goMission(0, false);
                ** GOTO lbl-1000
            }
            case -48: 
        }
        this.goMiniMap();
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawBlackSRC(Graphics var1_1, int var2_2, boolean var3_3) {
        block12: {
            block9: {
                block10: {
                    var8_4 = Constants_H.WIDTH__;
                    var7_5 = Constants_H.HEIGHT__;
                    var9_6 = Constants_H.WIDTH__ / 2;
                    var1_1.setColor(0xFFFFFF);
                    var6_7 = 0;
                    if (this.black_0 - 5 <= 0) break block10;
                    var5_8 = this.black_0 - 5;
lbl8:
                    // 2 sources

                    while (true) {
                        var10_9 = (byte)var5_8;
                        var5_8 = var6_7;
                        if (this.gr.about_d == null) lbl-1000:
                        // 5 sources

                        {
                            return;
                        }
                        ** GOTO lbl25
                        break;
                    }
                }
                var5_8 = 0;
                ** while (true)
lbl-1000:
                // 2 sources

                {
                    block8: {
                        block11: {
                            if (var3_3) break block11;
                            if (this.black_0 == var5_8) {
                                var1_1.setClip(0, (var5_8 - var10_9) * 29 + var2_2, this.black_1 << 1, 25 + 4);
                            }
                            Ui.i().drawStringColor(this.gr.about_d[var5_8].toString(), 25, (var5_8 - var10_9) * 29 + var2_2, 0, 0);
                            var1_1.setClip(0, 0, var8_4, var7_5);
lbl23:
                            // 2 sources

                            while (true) {
                                var5_8 = (short)(var5_8 + 1);
lbl25:
                                // 2 sources

                                if (!var3_3) break block8;
                                if (var5_8 < this.gr.about_d.length) continue block2;
lbl27:
                                // 2 sources

                                while (true) {
                                    if (!var3_3) {
                                        var1_1.setColor(0);
                                        var1_1.fillRect(0, 0, var8_4, 40);
                                        var1_1.fillRect(0, var7_5 - 40, var8_4, 40);
                                    }
                                    if (this.black_0 != this.gr.about_d.length) break block9;
                                    this.gr.drawZero(var9_6, var7_5 - 25 - 4, 1 | 32, 0);
                                    ** GOTO lbl-1000
                                    break;
                                }
                                break;
                            }
                        }
                        var6_7 = (short)(Ms.i().getStringWidth(this.gr.about_d[var5_8].toString()) - this.gr.getSIndexW(this.gr.about_d[var5_8].toString()));
                        Ui.i().drawStringColor(this.gr.about_d[var5_8].toString(), var8_4 - var6_7 >> 1, var5_8 * 29 + var2_2 + 6, 0, 0);
                        ** continue;
                    }
                    if (var5_8 > this.black_0 || var5_8 >= this.gr.about_d.length) break;
                    ** while (true)
                }
                ** while (true)
            }
            if (var3_3) break block12;
            this.black_1 = var4_10 = (short)(this.black_1 + 10);
            if (var4_10 < var9_6) break block12;
            this.black_1 = 0;
            this.black_0 = (short)(this.black_0 + 1);
            ** GOTO lbl-1000
        }
        if (!var3_3) ** GOTO lbl-1000
        this.black_0 = (byte)this.gr.about_d.length;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    void drawMap(Graphics var1_1) {
        block9: {
            block8: {
                block5: {
                    block7: {
                        block6: {
                            var4_2 = this.leftCol;
                            var3_3 = this.topRow;
                            if (this.map_x < 0) break block6;
                            this.leftCol = 0;
                            this.map_left = this.map_x;
lbl6:
                            // 2 sources

                            while (this.map_y >= 0) {
                                this.topRow = 0;
                                this.map_top = this.map_y;
lbl9:
                                // 2 sources

                                while (true) {
                                    var5_4 = this.leftCol * 20;
                                    var2_5 = this.topRow * 20;
                                    if (this.firstDrawMap == 0) {
                                        this.firstDrawMap = 1;
                                        this.bkgroundToPaint(this.bottomData, this.mapImg, var5_4, var2_5, this.moduleData, var1_1, 0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
lbl15:
                                        // 5 sources

                                        while (true) {
                                            Map.g.drawImage(GameRun.scrT, this.map_left, this.map_top, 20);
                                            return;
                                        }
                                    }
                                    break block5;
                                    break;
                                }
                            }
                            break block7;
                        }
                        this.leftCol = (short)(-this.map_x / 20);
                        this.map_left = this.map_x % 20;
                        ** GOTO lbl6
                    }
                    this.topRow = (short)(-this.map_y / 20);
                    this.map_top = this.map_y % 20;
                    ** while (true)
                }
                if (this.leftCol == var4_2 && this.topRow == var3_3) ** GOTO lbl15
                var1_1.setClip(0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT);
                var1_1.copyArea(0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, (var4_2 - this.leftCol) * 20, (var3_3 - this.topRow) * 20, 20);
                if (this.leftCol >= var4_2) break block8;
                this.bkgroundToPaint(this.bottomData, this.mapImg, var5_4, var2_5, this.moduleData, var1_1, 0, 0, (var4_2 - this.leftCol) * 20, Constants_H.OFF_HEIGHT, true);
lbl34:
                // 3 sources

                while (this.topRow < var3_3) {
                    this.bkgroundToPaint(this.bottomData, this.mapImg, var5_4, var2_5, this.moduleData, var1_1, 0, 0, Constants_H.OFF_WIDTH, (var3_3 - this.topRow) * 20, true);
                    ** GOTO lbl15
                }
                break block9;
            }
            if (this.leftCol <= var4_2) ** GOTO lbl34
            this.bkgroundToPaint(this.bottomData, this.mapImg, var5_4, var2_5, this.moduleData, var1_1, Constants_H.OFF_WIDTH + (var4_2 - this.leftCol) * 20, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
            ** GOTO lbl34
        }
        if (this.topRow <= var3_3) ** GOTO lbl15
        this.bkgroundToPaint(this.bottomData, this.mapImg, var5_4, var2_5, this.moduleData, var1_1, 0, Constants_H.OFF_HEIGHT + (var3_3 - this.topRow) * 20, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void drawMyAni(Npc var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        var8_6 = (byte)var2_2;
        if (var1_1.now_action >= Map.npcSp[1][var8_6].aLength(var5_5)) {
            var1_1.now_action = 0;
        }
        if (this.anole_type != 2 && this.anole_type != 4) {
            Ui.i().drawImage(this.imgShadow, var3_3, var4_4, 33);
        }
        var9_7 = Ui.i();
        var10_8 = Map.npcSp[1][var8_6];
        var7_9 = Map.npcSp[1][var8_6].action(var5_5, (int)var1_1.now_action, 0);
        if (var1_1.dir == 4) {
            var2_2 = 1;
lbl11:
            // 2 sources

            while (true) {
                var9_7.drawFrameOne(var10_8, var7_9, var3_3, var4_4, var2_2);
                var1_1.now_time = var6_10 = (byte)(var1_1.now_time + 1);
                if (var6_10 > Map.npcSp[1][var8_6].action(var5_5, (int)var1_1.now_action, 1)) {
                    var1_1.now_action = (byte)(var1_1.now_action + 1);
                    var1_1.now_time = 0;
                }
                return;
            }
        }
        var2_2 = 0;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void eventCheck() {
        block92: {
            block91: {
                var2_1 = 0;
                block57: while (true) {
                    if (this.event == null || var2_1 >= this.event.length) {
                        return;
                    }
                    if (this.event[var2_1] != null && this.event_now[var2_1] < this.event[var2_1].length) break;
lbl6:
                    // 3 sources

                    while (true) {
                        ++var2_1;
                        continue block57;
                        break;
                    }
                    break;
                }
                block59: while (true) {
                    block90: {
                        this.event_state = 0;
                        if (this.event_now[var2_1] < this.event[var2_1].length) break block90;
                        var6_6 /* !! */  = this.mapInfo;
                        var3_3 = this.mapNo * 2 + 1;
                        var6_6 /* !! */ [var3_3] = (short)(var6_6 /* !! */ [var3_3] | 1 << var2_1);
                        ** GOTO lbl6
                    }
                    switch (this.event[var2_1][this.event_now[var2_1]]) lbl-1000:
                    // 73 sources

                    {
                        default: lbl-1000:
                        // 5 sources

                        {
                            while (true) {
                                if (this.event_state == 1) continue block59;
                                ** continue;
                                break;
                            }
                        }
                        case 28: {
                            this.runEvent_dialog(var2_1);
                            ** GOTO lbl-1000
                        }
                        case 41: {
                            var3_3 = this.event[var2_1][this.event_now[var2_1] + 2] - 1;
                            if (var3_3 != -1) ** GOTO lbl38
                            this.my.setXY((int)this.event[var2_1][this.event_now[var2_1] + 3], (int)this.event[var2_1][this.event_now[var2_1] + 4], 0, 0);
                            this.my.frame_c = (byte)-1;
                            if (this.srcNpcNo == -1) {
                                this.map_x = this.map_set(this.event[var2_1][this.event_now[var2_1] + 3], this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20);
                                this.map_y = this.map_set(this.event[var2_1][this.event_now[var2_1] + 4], this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20);
                            }
lbl33:
                            // 4 sources

                            while (true) {
                                var6_6 /* !! */  = this.event_now;
                                var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 5);
                                this.nextEvent(4112);
                                ** GOTO lbl-1000
                                break;
                            }
lbl38:
                            // 1 sources

                            this.now_eV1 = this.getNpcLayer(var3_3);
                            this.now_eV2 = this.getNpcId(var3_3);
                            this.npc[this.now_eV1][this.now_eV2].other[0] = this.event[var2_1][this.event_now[var2_1] + 3];
                            this.npc[this.now_eV1][this.now_eV2].other[1] = this.event[var2_1][this.event_now[var2_1] + 4];
                            this.npc[this.now_eV1][this.now_eV2].setXY_npc();
                            ** continue;
                        }
                        case 15: {
                            if (this.event[var2_1][this.event_now[var2_1] + 2] != 0) ** GOTO lbl50
                            var5_5 = true;
lbl47:
                            // 2 sources

                            while (true) {
                                this.setEventNow(var2_1, var5_5);
                                ** GOTO lbl-1000
                                break;
                            }
lbl50:
                            // 1 sources

                            var5_5 = false;
                            ** continue;
                        }
                        case 4: {
                            if (this.gr.monInfoList[103] < this.event[var2_1][this.event_now[var2_1] + 2]) ** GOTO lbl58
                            var5_5 = true;
lbl55:
                            // 2 sources

                            while (true) {
                                this.ifEvent(var2_1, 4, 16, this.event[var2_1][this.event_now[var2_1] + 3], var5_5);
                                ** GOTO lbl-1000
                                break;
                            }
lbl58:
                            // 1 sources

                            var5_5 = false;
                            ** continue;
                        }
                        case 24: {
                            this.initBoat(this.event[var2_1][this.event_now[var2_1] + 2]);
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 3);
                            this.nextEvent(16);
                            ** GOTO lbl-1000
                        }
                        case 25: {
                            this.gr.overMode = (byte)(this.event[var2_1][this.event_now[var2_1] + 2] + 1);
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 3);
                            ** GOTO lbl-1000
                        }
                        case 50: {
                            if (this.my.state != 24 && this.my.state != 25) ** GOTO lbl81
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 3);
                            this.nextEvent(0);
                            if (this.my.state == 24) {
                                this.gr.say("\u4fdd\u5b58\u8fdb\u5ea6\u5b8c\u6210", 1);
                                this.gr.saveGame();
                            }
                            this.my.state = 0;
                            ** GOTO lbl-1000
lbl81:
                            // 1 sources

                            if (this.my.frame_c != -1 || this.my.state == 23) ** GOTO lbl-1000
                            this.my.state = (byte)23;
                            ** GOTO lbl-1000
                        }
                        case 29: {
                            var3_3 = this.event[var2_1][this.event_now[var2_1] + 2] - 1;
                            if (var3_3 != -1) ** GOTO lbl96
                            Map.cur_npc = this.my;
lbl88:
                            // 2 sources

                            while (true) {
                                Map.cur_npc.setLastAction(false, (int)this.event[var2_1][this.event_now[var2_1] + 4]);
                                Map.cur_npc.other[7] = this.event[var2_1][this.event_now[var2_1] + 3];
                                Map.cur_npc.now_action = 0;
                                var6_6 /* !! */  = this.event_now;
                                var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 5);
                                this.nextEvent(4096);
                                ** GOTO lbl-1000
                                break;
                            }
lbl96:
                            // 1 sources

                            Map.cur_npc = this.npc[this.getNpcLayer(var3_3)][this.getNpcId(var3_3)];
                            ** continue;
                        }
                        case 39: {
                            this.now_eV1 = this.event[var2_1][this.event_now[var2_1] + 2];
                            this.now_eV2 = this.event[var2_1][this.event_now[var2_1] + 3];
                            if ((this.gr.rmsOther[this.now_eV1 * 2 + 4] & 1 << this.now_eV2) == 0) ** GOTO lbl-1000
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 4);
                            this.nextEvent(4113);
                            ** GOTO lbl-1000
                        }
                        case 42: {
                            this.now_eV1 = this.event[var2_1][this.event_now[var2_1] + 2];
                            this.now_eV2 = this.event[var2_1][this.event_now[var2_1] + 3];
                            Mg.i().go(this.gr, (int)this.now_eV1, -1, (int)this.now_eV2);
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 4);
                            this.nextEvent(4113);
                            ** GOTO lbl-1000
                        }
                        case 18: {
                            this.runEvent_item_add_del(var2_1);
                            ** GOTO lbl-1000
                        }
                        case 49: {
                            if (this.gr.magic_id != -2) ** GOTO lbl125
                            this.my.state = (byte)10;
                            this.gr.magic_id = this.event[var2_1][this.event_now[var2_1] + 2];
                            this.gr.magic_x = this.map_x + this.event[var2_1][this.event_now[var2_1] + 3] * 20 + 10;
                            this.gr.magic_y = this.map_y + this.event[var2_1][this.event_now[var2_1] + 4] * 20 + 20;
                            this.gr.setMagic(this.event[var2_1][this.event_now[var2_1] + 2] / 5);
                            ** GOTO lbl-1000
lbl125:
                            // 1 sources

                            if (this.gr.magic_id != -1) ** GOTO lbl-1000
                            this.gr.magic_id = (byte)-2;
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 5);
                            this.nextEvent(16);
                            ** GOTO lbl-1000
                        }
                        case 26: {
                            this.runEvent_getMon(var2_1);
                            ** GOTO lbl-1000
                        }
                        case 27: {
                            if (this.eventGoing != 0) ** GOTO lbl143
                            this.now_eV2 = this.gr.findMonsterMinLv((int)this.event[var2_1][this.event_now[var2_1] + 2], (int)this.event[var2_1][this.event_now[var2_1] + 3]);
                            if (this.now_eV2 == -1) ** GOTO lbl141
                            this.now_eV1 = this.gr.delMonster((int)this.now_eV2);
                            this.eventGoing = 1;
                            ** GOTO lbl-1000
lbl141:
                            // 1 sources

                            this.setEventNow(var2_1, false);
                            ** GOTO lbl-1000
lbl143:
                            // 1 sources

                            if (this.gr.say_c != 0) ** GOTO lbl-1000
                            if (this.now_eV1 != -1) ** GOTO lbl147
                            this.setEventNow(var2_1, false);
                            ** GOTO lbl-1000
lbl147:
                            // 1 sources

                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + (this.event[var2_1][this.event_now[var2_1] + 1] + 2));
                            this.nextEvent(4368);
                            ** GOTO lbl-1000
                        }
                        case 35: {
                            var3_3 = this.event[var2_1][this.event_now[var2_1] + 2] - 1;
                            if (var3_3 != -1) ** GOTO lbl168
                            this.my.other[4] = this.event[var2_1][this.event_now[var2_1] + 3];
                            switch (this.event[var2_1][this.event_now[var2_1] + 3]) lbl-1000:
                            // 2 sources

                            {
                                default: lbl-1000:
                                // 3 sources

                                {
                                    while (true) {
                                        var6_6 /* !! */  = this.event_now;
                                        var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 4);
                                        this.nextEvent(4112);
                                        ** GOTO lbl-1000
                                        break;
                                    }
                                }
                                case 0: 
                                case 2: {
                                    this.my.state = 0;
                                    ** GOTO lbl-1000
                                }
                                case 1: 
                                case 3: 
                            }
                            this.my.state = (byte)10;
                            ** GOTO lbl-1000
lbl168:
                            // 1 sources

                            this.now_eV1 = this.getNpcLayer(var3_3);
                            this.now_eV2 = this.getNpcId(var3_3);
                            this.npc[this.now_eV1][this.now_eV2].other[4] = this.event[var2_1][this.event_now[var2_1] + 3];
                            ** continue;
                        }
                        case 32: {
                            this.runEvent_miniGame_myLevel(var2_1);
                            ** GOTO lbl-1000
                        }
                        case 46: {
                            Sound.i().setMusicId((int)this.event[var2_1][this.event_now[var2_1] + 2]);
                            Sound.i().setMusic(false);
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 3);
                            this.nextEvent(16);
                            ** GOTO lbl-1000
                        }
                        case 47: {
                            this.my.state = (byte)10;
                            this.sleep_count = var1_2 = (byte)(this.sleep_count + 1);
                            if (var1_2 != this.event[var2_1][this.event_now[var2_1] + 2]) ** GOTO lbl-1000
                            this.sleep_count = 0;
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 3);
                            this.nextEvent(17);
                            ** GOTO lbl-1000
                        }
                        case 52: {
                            this.my.state = (byte)10;
                            this.xxx = this.event[var2_1][this.event_now[var2_1] + 2];
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 3);
                            this.nextEvent(16);
                            ** GOTO lbl-1000
                        }
                        case 16: {
                            this.runEvent_goShop(var2_1);
                            ** GOTO lbl-1000
                        }
                        case 53: {
                            if (!this.initSrcEffect(this.event[var2_1][this.event_now[var2_1] + 2])) ** GOTO lbl-1000
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 3);
                            this.nextEvent(16);
                            ** GOTO lbl-1000
                        }
                        case 13: {
                            if (this.eventGoing != 0) ** GOTO lbl225
                            this.eventGoing = 1;
                            if (this.event[var2_1][this.event_now[var2_1] + 3] != 0) ** GOTO lbl215
                            this.bMission[14] = this.event[var2_1][this.event_now[var2_1] + 2];
                            if (this.bMission[14] != -1) {
                                this.gr.say("#4\u4e3b\u7ebf\u4efb\u52a1#0\u5df2\u66f4\u65b0\uff0c\u70b9\u51fb#7\u5de5\u5177\u5305\u5185\u7684\u4e3b\u7ebf\u6309\u94ae#0\u53ef\u67e5\u770b\u4efb\u52a1\u8868\u3002", -1);
                            }
                            ** GOTO lbl-1000
lbl215:
                            // 1 sources

                            var3_3 = this.event[var2_1][this.event_now[var2_1] + 2];
                            if (this.event[var2_1][this.event_now[var2_1] + 3] != 2) ** GOTO lbl223
                            var5_5 = true;
lbl218:
                            // 2 sources

                            while (true) {
                                this.setMission(var3_3, var5_5);
                                if (this.event[var2_1][this.event_now[var2_1] + 3] == 2) {
                                    this.gr.say("#4\u5206\u652f\u4efb\u52a1#0\u5df2\u66f4\u65b0\uff0c\u70b9\u51fb#7\u5de5\u5177\u5305\u5185\u7684\u652f\u7ebf\u6309\u94ae#0\u53ef\u67e5\u770b\u4efb\u52a1\u8868\u3002", -1);
                                }
                                ** GOTO lbl-1000
                                break;
                            }
lbl223:
                            // 1 sources

                            var5_5 = false;
                            ** continue;
lbl225:
                            // 1 sources

                            if (this.gr.say_c != 0) ** GOTO lbl-1000
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 4);
                            this.nextEvent(272);
                            ** GOTO lbl-1000
                        }
                        case 30: {
                            this.my.state = (byte)10;
                            var3_3 = this.event[var2_1][this.event_now[var2_1] + 2] - 1;
                            if (var3_3 != -1) ** GOTO lbl248
                            Map.cur_npc = this.my;
lbl235:
                            // 2 sources

                            while (true) {
                                Map.cur_npc.setIXY((int)this.event[var2_1][this.event_now[var2_1] + 3], (int)this.event[var2_1][this.event_now[var2_1] + 4]);
                                Map.cur_npc.speed = this.event[var2_1][this.event_now[var2_1] + 5];
                                var6_6 /* !! */  = (short[])Map.cur_npc;
                                if (this.event[var2_1][this.event_now[var2_1] + 6] != 0) ** GOTO lbl250
                                var5_5 = true;
lbl241:
                                // 2 sources

                                while (true) {
                                    var6_6 /* !! */ .b_check = var5_5;
                                    Map.cur_npc.setLastAction(false, 127);
                                    var6_6 /* !! */  = this.event_now;
                                    var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 7);
                                    this.nextEvent(16);
                                    ** GOTO lbl-1000
                                    break;
                                }
                                break;
                            }
lbl248:
                            // 1 sources

                            Map.cur_npc = this.npc[this.getNpcLayer(var3_3)][this.getNpcId(var3_3)];
                            ** continue;
lbl250:
                            // 1 sources

                            var5_5 = false;
                            ** continue;
                        }
                        case 37: {
                            this.my.state = (byte)10;
                            var3_3 = this.event[var2_1][this.event_now[var2_1] + 2] - 1;
                            if (var3_3 != -1) ** GOTO lbl268
                            Map.cur_npc = this.my;
lbl257:
                            // 2 sources

                            while (true) {
                                Map.cur_npc.setLastAction(true, (int)this.event[var2_1][this.event_now[var2_1] + 6]);
                                Map.cur_npc.setIXY((int)this.event[var2_1][this.event_now[var2_1] + 3], (int)this.event[var2_1][this.event_now[var2_1] + 4]);
                                Map.cur_npc.other[7] = this.event[var2_1][this.event_now[var2_1] + 5];
                                if (this.event[var2_1][this.event_now[var2_1] + 5] < 0) {
                                    Map.cur_npc.dir = (byte)4;
                                }
                                Map.cur_npc.speed = this.event[var2_1][this.event_now[var2_1] + 7];
                                var6_6 /* !! */  = this.event_now;
                                var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 8);
                                this.nextEvent(16);
                                ** GOTO lbl-1000
                                break;
                            }
lbl268:
                            // 1 sources

                            Map.cur_npc = this.npc[this.getNpcLayer(var3_3)][this.getNpcId(var3_3)];
                            ** continue;
                        }
                        case 23: {
                            this.now_eV1 = this.event[var2_1][this.event_now[var2_1] + 2];
                            this.now_eV2 = this.event[var2_1][this.event_now[var2_1] + 3];
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 4);
                            this.setRestEvent(this.now_eV1, this.now_eV2);
                            this.nextEvent(4112);
                            ** GOTO lbl-1000
                        }
                        case 17: {
                            this.now_eV1 = this.event[var2_1][this.event_now[var2_1] + 2];
                            this.now_eV2 = this.event[var2_1][this.event_now[var2_1] + 3];
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 4);
                            this.setOverEvent(this.now_eV1, this.now_eV2);
                            this.nextEvent(4112);
                            ** GOTO lbl-1000
                        }
                        case 22: {
                            this.exitBoss(this.event[var2_1][this.event_now[var2_1] + 2], this.event[var2_1][this.event_now[var2_1] + 3], this.event[var2_1][this.event_now[var2_1] + 4], this.event[var2_1][this.event_now[var2_1] + 5]);
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 6);
                            this.nextEvent(16);
                            ** GOTO lbl-1000
                        }
                        case 36: {
                            var3_3 = this.event[var2_1][this.event_now[var2_1] + 2] - 1;
                            this.now_eV1 = this.getNpcLayer(var3_3);
                            this.now_eV2 = this.getNpcId(var3_3);
                            this.npc[this.now_eV1][this.now_eV2].other[5] = (byte)(this.event[var2_1][this.event_now[var2_1] + 3] + 1);
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 4);
                            this.nextEvent(4112);
                            ** GOTO lbl-1000
                        }
                        case 2: {
                            this.now_eV1 = this.event[var2_1][this.event_now[var2_1] + 2];
                            this.now_eV2 = this.event[var2_1][this.event_now[var2_1] + 3];
                            this.ifEvent(var2_1, 5, 4112, this.event[var2_1][this.event_now[var2_1] + 4], this.isMapEvent(this.now_eV1, this.now_eV2));
                            ** GOTO lbl-1000
                        }
                        case 45: {
                            this.runEvent_srcMove(var2_1);
                            ** GOTO lbl-1000
                        }
                        case 48: {
                            this.my.state = (byte)10;
                            this.srcFlash_c = (byte)(this.event[var2_1][this.event_now[var2_1] + 2] << 1);
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 3);
                            this.nextEvent(16);
                            ** GOTO lbl-1000
                        }
                        case 38: {
                            this.runEvent_brow(var2_1);
                            ** GOTO lbl-1000
                        }
                        case 19: {
                            Ms.i();
                            Ms.skip = 0;
                            var6_6 /* !! */  = Ms.i().getStream("data/battle/boss.d", -1);
                            var7_7 /* !! */  = Ms.i().create2Array((byte[])var6_6 /* !! */ );
                            var6_6 /* !! */  = null;
                            var3_3 = this.event[var2_1][this.event_now[var2_1] + 1] >> 1;
                            this.gr.enemyList = new byte[var3_3][5];
                            this.now_eV2 = 0;
                            while (true) {
                                if (this.now_eV2 < var3_3) ** GOTO lbl339
                                var6_6 /* !! */  = (short[])((byte[][])null);
                                Sound.i().setMusicId(6);
                                Sound.i().setMusic(false);
                                this.gr.battleType(3);
                                this.gr.goBattle();
                                var6_6 /* !! */  = this.event_now;
                                var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + (this.event[var2_1][this.event_now[var2_1] + 1] + 2));
                                ** GOTO lbl-1000
lbl339:
                                // 1 sources

                                this.now_eV1 = this.event[var2_1][this.event_now[var2_1] + 2 + this.now_eV2 * 2];
                                this.gr.enemyList[this.now_eV2][0] = var7_7 /* !! */ [this.now_eV1][0];
                                this.gr.enemyList[this.now_eV2][1] = this.event[var2_1][this.event_now[var2_1] + 3 + this.now_eV2 * 2];
                                this.gr.enemyList[this.now_eV2][2] = var7_7 /* !! */ [this.now_eV1][1];
                                this.gr.enemyList[this.now_eV2][3] = var7_7 /* !! */ [this.now_eV1][2];
                                this.gr.enemyList[this.now_eV2][4] = var7_7 /* !! */ [this.now_eV1][3];
                                this.now_eV2 = (byte)(this.now_eV2 + 1);
                            }
                        }
                        case 6: {
                            var5_5 = Ms.i().isRect((int)this.my.x, (int)this.my.y, 19, 19, this.event[var2_1][this.event_now[var2_1] + 2] * 20, this.event[var2_1][this.event_now[var2_1] + 3] * 20, (this.event[var2_1][this.event_now[var2_1] + 4] - this.event[var2_1][this.event_now[var2_1] + 2] + 1) * 20, (this.event[var2_1][this.event_now[var2_1] + 5] - this.event[var2_1][this.event_now[var2_1] + 3] + 1) * 20);
                            this.ifEvent(var2_1, 7, 16, this.event[var2_1][this.event_now[var2_1] + 6], var5_5);
                            ** GOTO lbl-1000
                        }
                        case 1: {
                            var3_3 = this.event[var2_1][this.event_now[var2_1] + 2] - 1;
                            if (var3_3 == -1) ** GOTO lbl-1000
                            this.now_eV1 = this.getNpcLayer(var3_3);
                            this.now_eV2 = this.getNpcId(var3_3);
                            if (this.my.state != 2 || this.get_meet != this.now_eV2) ** GOTO lbl361
                            var5_5 = true;
lbl358:
                            // 2 sources

                            while (true) {
                                this.ifEvent(var2_1, 4, 16, this.event[var2_1][this.event_now[var2_1] + 3], var5_5);
                                ** GOTO lbl-1000
                                break;
                            }
lbl361:
                            // 1 sources

                            var5_5 = false;
                            ** continue;
                        }
                        case 3: {
                            if (this.gr.money < this.event[var2_1][this.event_now[var2_1] + 2] * 100) ** GOTO lbl369
                            var5_5 = true;
lbl366:
                            // 2 sources

                            while (true) {
                                this.ifEvent(var2_1, 4, 16, this.event[var2_1][this.event_now[var2_1] + 3], var5_5);
                                ** GOTO lbl-1000
                                break;
                            }
lbl369:
                            // 1 sources

                            var5_5 = false;
                            ** continue;
                        }
                        case 5: {
                            var3_3 = this.gr.findItem(-2, (int)this.event[var2_1][this.event_now[var2_1] + 2], true);
                            if (this.event[var2_1][this.event_now[var2_1] + 3] != 0) ** GOTO lbl381
                            if (var3_3 != 0) ** GOTO lbl379
                            var5_5 = true;
lbl376:
                            // 4 sources

                            while (true) {
                                this.ifEvent(var2_1, 5, 16, this.event[var2_1][this.event_now[var2_1] + 4], var5_5);
                                ** GOTO lbl-1000
                                break;
                            }
lbl379:
                            // 1 sources

                            var5_5 = false;
                            ** GOTO lbl376
lbl381:
                            // 1 sources

                            if (var3_3 < this.event[var2_1][this.event_now[var2_1] + 3]) ** GOTO lbl384
                            var5_5 = true;
                            ** GOTO lbl376
lbl384:
                            // 1 sources

                            var5_5 = false;
                            ** continue;
                        }
                        case 8: {
                            if (this.gr.findMonster((int)this.event[var2_1][this.event_now[var2_1] + 2], (int)this.event[var2_1][this.event_now[var2_1] + 3]) == -1) ** GOTO lbl392
                            var5_5 = true;
lbl389:
                            // 2 sources

                            while (true) {
                                this.ifEvent(var2_1, 5, 16, this.event[var2_1][this.event_now[var2_1] + 4], var5_5);
                                ** GOTO lbl-1000
                                break;
                            }
lbl392:
                            // 1 sources

                            var5_5 = false;
                            ** continue;
                        }
                        case 12: {
                            this.runEvent_select(var2_1);
                            ** GOTO lbl-1000
                        }
                        case 11: {
                            var3_3 = this.event[var2_1][this.event_now[var2_1] + 2] - 1;
                            this.now_eV1 = this.getNpcLayer(var3_3);
                            this.now_eV2 = this.getNpcId(var3_3);
                            if (this.npc[this.now_eV1][this.now_eV2].other[8] != this.event[var2_1][this.event_now[var2_1] + 3]) ** GOTO lbl406
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 4);
                            this.nextEvent(16);
                            ** GOTO lbl-1000
lbl406:
                            // 1 sources

                            this.setEventNow(var2_1, false);
                            ** GOTO lbl-1000
                        }
                        case 40: {
                            var3_3 = this.event[var2_1][this.event_now[var2_1] + 2] - 1;
                            if (var3_3 != -1) ** GOTO lbl422
                            var6_6 /* !! */  = this.my.other;
                            Ms.i();
                            var6_6 /* !! */ [7] = (byte)Ms.abs((int)this.event[var2_1][this.event_now[var2_1] + 3]);
                            if (this.event[var2_1][this.event_now[var2_1] + 3] < 0) {
                                this.my.dir = (byte)4;
                            }
lbl417:
                            // 4 sources

                            while (true) {
                                var6_6 /* !! */  = this.event_now;
                                var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 4);
                                this.nextEvent(16);
                                ** GOTO lbl-1000
                                break;
                            }
lbl422:
                            // 1 sources

                            Map.cur_npc = this.npc[this.getNpcLayer(var3_3)][this.getNpcId(var3_3)];
                            Map.cur_npc.other[7] = this.event[var2_1][this.event_now[var2_1] + 3];
                            Map.cur_npc.setNpcNum(Map.npcSp[Map.cur_npc.other[3] - 1][Map.cur_npc.other[2]].aLength());
                            ** continue;
                        }
                        case 43: {
                            var3_3 = this.event[var2_1][this.event_now[var2_1] + 2] - 1;
                            this.now_eV1 = this.getNpcLayer(var3_3);
                            this.now_eV2 = this.getNpcId(var3_3);
                            this.npc[this.now_eV1][this.now_eV2].other[8] = this.event[var2_1][this.event_now[var2_1] + 3];
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 4);
                            this.nextEvent(16);
                            ** GOTO lbl-1000
                        }
                        case 21: {
                            if (this.eventGoing != 0) ** GOTO lbl460
                            this.eventGoing = 1;
                            var3_3 = this.event[var2_1][this.event_now[var2_1] + 2] * 100;
                            if (var3_3 < 0) {
                                var4_4 = this.gr.money;
                                Ms.i();
                                if (var4_4 < Ms.abs((int)var3_3)) {
                                    this.gr.say("\u91d1\u94b1\u4e0d\u8db3\uff01", 0);
                                    this.eventGoing = (byte)2;
                                }
                            }
                            if (this.eventGoing != 1) ** GOTO lbl-1000
                            var6_6 /* !! */  = (short[])this.gr;
                            var6_6 /* !! */ .money += var3_3;
                            var7_7 /* !! */  = (byte[][])this.gr;
                            if (var3_3 >= 0) ** GOTO lbl458
                            var6_6 /* !! */  = (short[])"\u5931\u53bb\uff1a";
lbl452:
                            // 2 sources

                            while (true) {
                                var6_6 /* !! */  = (short[])new StringBuilder(String.valueOf(var6_6 /* !! */ ));
                                Ms.i();
                                var7_7 /* !! */ .say(var6_6 /* !! */ .append(Ms.abs((int)var3_3)).append("\u91d1").toString(), 0);
                                ** GOTO lbl-1000
                                break;
                            }
lbl458:
                            // 1 sources

                            var6_6 /* !! */  = (short[])"\u83b7\u5f97\uff1a";
                            ** continue;
lbl460:
                            // 1 sources

                            if (this.gr.say_c != 0) ** GOTO lbl-1000
                            if (this.eventGoing != 2) ** GOTO lbl464
                            this.setEventNow(var2_1, true);
                            ** GOTO lbl-1000
lbl464:
                            // 1 sources

                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 3);
                            this.nextEvent(272);
                            ** GOTO lbl-1000
                        }
                        case 33: {
                            this.anole_type = (byte)(this.event[var2_1][this.event_now[var2_1] + 2] - 1);
                            this.setAnole();
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 3);
                            this.nextEvent(16);
                            ** GOTO lbl-1000
                        }
                        case 51: {
                            switch (this.event[var2_1][this.event_now[var2_1] + 2]) {
                                default: {
                                    ** GOTO lbl-1000
                                }
                                case 0: {
                                    if (this.eventGoing != 0) ** GOTO lbl484
                                    this.gr.say(Ms.i().getDialogs(this.event[var2_1], this.event_now[var2_1] + 4, (int)this.event[var2_1][this.event_now[var2_1] + 3]), -1);
                                    this.eventGoing = 1;
                                    ** GOTO lbl-1000
lbl484:
                                    // 1 sources

                                    if (this.gr.say_c != 0) ** GOTO lbl-1000
                                    var6_6 /* !! */  = this.event_now;
                                    var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + ((this.event[var2_1][this.event_now[var2_1] + 3] << 1) + 4));
                                    this.nextEvent(272);
                                    ** GOTO lbl-1000
                                }
                                case 1: 
                                case 2: 
                            }
                            if (this.eventGoing != 0) ** GOTO lbl505
                            this.my.state = (byte)22;
                            this.black_1 = 0;
                            this.black_0 = 0;
                            Ms.i();
                            Ms.font.setSize(22);
                            this.fontSizeControl = true;
                            this.gr.setStringB(Ms.i().getDialogs(this.event[var2_1], this.event_now[var2_1] + 4, (int)this.event[var2_1][this.event_now[var2_1] + 3]), Constants_H.WIDTH__ - 25 * 2, 3);
                            Ms.i();
                            Ms.font.setSize(26);
                            this.fontSizeControl = false;
                            this.eventGoing = this.event[var2_1][this.event_now[var2_1] + 2];
                            ** GOTO lbl-1000
lbl505:
                            // 1 sources

                            if (this.eventGoing != 3) ** GOTO lbl-1000
                            var6_6 /* !! */  = this.event_now;
                            var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + ((this.event[var2_1][this.event_now[var2_1] + 3] << 1) + 4));
                            this.nextEvent(272);
                            this.gr.about_d = null;
                            this.black_0 = (short)-1;
                            ** GOTO lbl-1000
                        }
                        case 31: {
                            var3_3 = this.event[var2_1][this.event_now[var2_1] + 2] - 1;
                            if (var3_3 != -1) ** GOTO lbl522
                            this.my.dir = this.now_eV1 = this.event[var2_1][this.event_now[var2_1] + 3];
                            this.my.setActionNo(false);
lbl517:
                            // 3 sources

                            while (true) {
                                var6_6 /* !! */  = this.event_now;
                                var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 4);
                                this.nextEvent(4112);
                                ** GOTO lbl-1000
                                break;
                            }
lbl522:
                            // 1 sources

                            this.now_eV1 = this.getNpcLayer(var3_3);
                            if (this.now_eV1 != 0) ** GOTO lbl517
                            this.now_eV2 = this.getNpcId(var3_3);
                            this.npc[this.now_eV1][this.now_eV2].dir = this.event[var2_1][this.event_now[var2_1] + 3];
                            this.npc[this.now_eV1][this.now_eV2].setActionNo(false);
                            ** continue;
                        }
                        case 44: 
                    }
                    break;
                }
                var3_3 = this.event[var2_1][this.event_now[var2_1] + 2];
                if (var3_3 != 0) break block91;
                this.ifEvent(var2_1, 3, 16, 2, this.gr.gameCheckRegIsOK());
                ** GOTO lbl-1000
            }
            if (var3_3 != 1) break block92;
            if (!this.gr.gameCheckRegIsOK()) {
                var6_6 /* !! */  = this.event_now;
                var6_6 /* !! */ [var2_1] = (short)(var6_6 /* !! */ [var2_1] + 3);
                this.nextEvent(0);
                this.checkRegWhere0(var2_1);
            }
            ** GOTO lbl-1000
        }
        if (var3_3 != 2) ** GOTO lbl-1000
        this.ifEvent(var2_1, 3, 16, 2, this.gr.gameCheckRegIsOK());
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public byte exitMap(byte[][] byArray) {
        byte by;
        if (byArray[this.get_meet][3] == -1) {
            by = this.mapNo;
            this.mapNo = this.lastMap;
            this.lastMap = by;
            this.lastExit = this.get_meet;
            return -1;
        }
        by = this.mapNo;
        this.mapNo = byArray[this.get_meet][4];
        this.lastMap = by;
        this.lastExit = this.get_meet;
        return byArray[this.get_meet][3];
    }

    /*
     * Enabled force condition propagation
     */
    public byte getMySpeed() {
        if (this.anole_type == 0) {
            return (byte)6;
        }
        if (this.anole_type == 1) {
            return (byte)6;
        }
        if (this.anole_type == 2) {
            return (byte)10;
        }
        if (this.anole_type == 4) {
            return (byte)5;
        }
        if (this.anole_type != 3) return (byte)5;
        return (byte)10;
    }

    /*
     * Unable to fully structure code
     */
    public void goMiniMap() {
        Ms.i().keyRelease();
        var4_1 = Ms.i().getStream("data/map.d", -1);
        Ms.skip = 0;
        this.mapdataArea = Ms.i().create2Array(var4_1);
        this.mapdataMap = Ms.i().create2Array(var4_1);
        var4_1 = null;
        this.my.state = (byte)17;
        this.showArea = (byte)-1;
        this.myMiniMap = (byte)-1;
        this.selectMap = 0;
        var1_2 = 0;
        block0: while (true) {
            if (var1_2 >= this.mapdataArea.length) lbl-1000:
            // 2 sources

            {
                return;
            }
            var2_3 = 0;
            while (true) {
                if (var2_3 >= this.mapdataArea[var1_2].length) {
                    var1_2 = (byte)(var1_2 + 1);
                    continue block0;
                }
                if (this.mapNo == this.mapdataArea[var1_2][var2_3]) {
                    this.selectMap = this.mapNo;
                    if (this.mapdataMap[this.selectMap].length > 0) {
                        this.myMiniMap = this.selectMap;
                        this.showArea = (byte)var1_2;
                        if (this.mapdataArea[this.showArea][0] > -1) {
                            var3_4 = true;
lbl28:
                            // 2 sources

                            while (true) {
                                this.miniMapMode = var3_4;
                                ** continue;
                                break;
                            }
                        }
                        var3_4 = false;
                        ** continue;
                    }
                }
                var2_3 = (byte)(var2_3 + 1);
            }
            break;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void goMission(int var1_1, boolean var2_2) {
        block7: {
            if (this.my.state != 18 && this.my.state != 0) lbl-1000:
            // 3 sources

            {
                return;
            }
            Ms.i().keyRelease();
            this.bPause = var2_2;
            GameRun.run_state = -10;
            this.my.state = (byte)18;
            this.gr.cur_a = (byte)var1_1;
            var5_3 = this.gr.select[0];
            this.gr.select[0][1] = 0;
            var5_3[0] = 0;
            Ms.i();
            Ms.skip = 0;
            var5_3 = Ms.i().getStream("data/mission" + var1_1 + ".t", -1);
            this.sMission = Ms.i().createString2Array(var5_3);
            this.gr.line_max = (byte)6;
            this.gr.about_a = null;
            if (var1_1 != 1) break block7;
            var3_4 = 0;
            var1_1 = 0;
            var5_3 = new byte[50];
            while (true) {
                block8: {
                    if (var3_4 < this.sMission.length) break block8;
                    this.mDirect = null;
                    this.mDirect = new byte[var1_1];
                    System.arraycopy(var5_3, 0, this.mDirect, 0, this.mDirect.length);
                    if (this.mDirect.length > 0) {
                        this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 640 - 50, 0);
                    }
                    var5_3 = null;
                    ** GOTO lbl-1000
                }
                var4_5 = var1_1;
                if (this.isMission(var3_4)) {
                    var4_5 = (byte)(var1_1 + 1);
                    var5_3[var1_1] = var3_4;
                }
                var3_4 = (byte)(var3_4 + 1);
                var1_1 = var4_5;
            }
        }
        this.gr.select[0][0] = this.bMission[14];
        if (this.bMission[14] >= this.gr.line_max) {
            this.gr.select[0][1] = (byte)(this.gr.select[0][0] - this.gr.line_max + 1);
lbl44:
            // 2 sources

            while (true) {
                this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), 640 - 50, 0);
                ** continue;
                break;
            }
        }
        this.gr.select[0][1] = 0;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void goNextMap() {
        this.setfmap();
        this.firstDrawMap = 0;
        this.gr.doPaint(2);
        this.saveMapBak();
        var1_1 = this.lastExit;
        if (this.go != -2) {
            this.lastMap = this.mapNo;
            this.mapNo = this.mapNotemp;
            this.mapNotemp = 0;
            this.lastExit = this.go;
        }
        this.gr.doPaint(5);
        if (this.go == -2) {
            this.go = this.exitMap(this.door);
        }
        this.gr.setNull(false);
        this.gr.doPaint(8);
        this.createOther();
        this.gr.doPaint(10);
        if (this.go == -1) {
            this.go = var1_1;
        }
        if (!this.bExitBoss) {
            this.getInMap(this.go, this.door);
        }
        this.createEvent();
        this.gr.doPaint(15);
        this.createNpcString();
        this.createLayer();
        this.gr.doPaint(20);
        if (!(this.bExitBoss || this.door[this.go][5] != 1 && this.door[this.go][5] != 2)) {
            this.my.frame_c = (byte)(20 / this.my.speed);
            this.my.speed_x = (byte)(this.dir_select[this.my.dir][0] * this.my.speed);
            this.my.speed_y = (byte)(this.dir_select[this.my.dir][1] * this.my.speed);
            this.my.setActionNo(true);
lbl32:
            // 2 sources

            while (true) {
                this.gr.b_c = 0;
                this.setMapMusic(false);
                this.go = (byte)-2;
                this.gr.initMonPro((int)this.mapNo, true);
                this.gr.cityName_c = (byte)25;
                this.srcNpcNo = (byte)-1;
                Ms.i().rmsOptions(1, null, 4);
                this.initCloud();
                this.bExitBoss = false;
                this.my.state = (byte)9;
                if (this.boatSelect == -1) {
                    this.my.state = 0;
                    this.my.setIXY(-1, -1);
                    this.my.speed = this.getMySpeed();
                }
                this.checkNpcT = (byte)-1;
                this.pkey.stopMove();
                return;
            }
        }
        this.my.setActionNo(false);
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public boolean initAnoleValue() {
        if (this.isAnole(this.my.x, this.my.y, this.anole_type)) {
            this.gr.say("\u4e0d\u80fd\u66f4\u6362\u5750\u9a91", 0);
            return false;
        }
        this.my.state = (byte)20;
        this.gr.cur_a = 0;
        this.gr.cur_b = 0;
        this.gr.setStringB("\u4e0b\u5750\u9a91#n\u690d\u7269\u5750\u9a91#n\u91d1\u5c5e\u5750\u9a91#n\u98de\u884c\u5750\u9a91#n\u91ce\u517d\u5750\u9a91#n\u6d77\u6d0b\u5750\u9a91#n\u65e0\u6b64\u5750\u9a91", Constants_H.WIDTH, 0);
        return true;
    }

    public void initBrowImage() {
        if (this.brow == null) {
            this.brow = Ms.i().createSprite("data/face/brow", true);
        }
    }

    public byte[] initData(byte[] byArray, int n) {
        int n2 = 0;
        int n3 = 1;
        while (true) {
            if (n2 >= n) {
                n = n3 + 1;
                byte[] byArray2 = new byte[(byArray[n3] & 0xFF) << 8 | byArray[n] & 0xFF];
                System.arraycopy(byArray, n + 1, byArray2, 0, byArray2.length);
                return byArray2;
            }
            int n4 = n3 + 1;
            byte by = byArray[n3];
            n3 = byArray[n4];
            ++n2;
            n3 = n4 + 1 + ((by & 0xFF) << 8 | n3 & 0xFF);
        }
    }

    public void initMap() {
        this.my.dir = (byte)4;
        this.srcNpcNo = (byte)-1;
        this.gr.loadRmsSms();
        this.gr.loadRmsNidus();
        this.notMeet(0, 0);
        this.mapInfo = Ms.i().byteArrayToShortArray(Ms.i().rmsOptions(13, null, 1));
        this.mapChange = Ms.i().rmsOptions(1, null, 1);
        int n = 0;
        while (true) {
            if (n >= this.mapChange.length) {
                System.gc();
                this.gr.createOver = (byte)33;
                this.createOther();
                this.gr.createOver = (byte)35;
                this.createLayer();
                this.gr.createOver = (byte)37;
                this.createEvent();
                this.gr.createOver = (byte)39;
                this.createNpcString();
                this.gr.createOver = (byte)40;
                Ms.i().rmsOptions(1, null, 4);
                this.gr.initMonPro((int)this.mapNo, true);
                this.initMissionList();
                this.initCloud();
                return;
            }
            if (this.mapChange[n] == 1) {
                this.mapTemp[n] = Ms.i().rmsOptions(n + 14, null, 1);
            }
            n = (short)(n + 1);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void initNpcAni() {
        block9: {
            var2_1 = 0;
            var6_2 = new byte[][]{new byte[100], new byte[5], new byte[60]};
            this.gr.initNidusMap(0);
            var3_3 = (byte)(this.npc.length - 1);
            block0: while (true) {
                if (var3_3 <= -1) {
                    this.gr.initNidusMap(1);
                    this.npcList[0] = -1;
                    var2_1 = (byte)(this.item.length + this.npc[0].length);
lbl10:
                    // 2 sources

                    while (true) {
                        if (var2_1 > this.npc[0].length) break block0;
                        this.initNpcAni_1(100, 0, var6_2[0]);
                        this.initNpcAni_1(5, 1, var6_2[1]);
                        this.initNpcAni_1(60, 2, var6_2[2]);
                        var5_6 /* !! */  = null;
                        var2_1 = (byte)(this.npc[0].length - 1);
lbl17:
                        // 2 sources

                        while (true) {
                            if (var2_1 <= -1) {
                                return;
                            }
                            break block9;
                            break;
                        }
                        break;
                    }
                }
                var1_4 = (byte)(this.npc[var3_3].length - 1);
                while (true) {
                    if (var1_4 <= -1) {
                        var3_3 = (byte)(var3_3 - 1);
                        continue block0;
                    }
                    var6_2[this.npc[var3_3][var1_4].other[3] - 1][this.npc[var3_3][var1_4].other[2]] = 1;
                    if (var3_3 == 0) {
                        this.npcList[var1_4 + 1] = var1_4;
                        if (this.npc[var3_3][var1_4].other[8] == 1) {
                            var5_6 /* !! */  = (byte[][])this.gr.nidusMap;
                            var4_5 = (byte)(var2_1 + 1);
                            var5_6 /* !! */ [var2_1] = (byte[])var1_4;
                            var2_1 = var4_5;
                        }
                    }
                    var1_4 = (byte)(var1_4 - 1);
                }
                break;
            }
            this.npcList[var2_1] = (byte)(-2 - var2_1 + this.npc[0].length + 1);
            var2_1 = (byte)(var2_1 - 1);
            ** while (true)
        }
        this.npc[0][var2_1].setNpcNum(Map.npcSp[this.npc[0][var2_1].other[3] - 1][this.npc[0][var2_1].other[2]].aLength());
        var2_1 = (byte)(var2_1 - 1);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void initNpcAniOne(String var1_1, int var2_2, int var3_3) {
        var5_4 = Map.npcSp[var3_3];
        var6_5 = Ms.i();
        var7_6 = "data/npc" + var3_3 + "/" + var1_1;
        if (var3_3 == 2) {
            var4_7 = this.gr.isNpc2ImageType(Integer.parseInt(var1_1));
lbl6:
            // 2 sources

            while (true) {
                var5_4[var2_2] = var6_5.createSprite(var7_6, var4_7);
                return;
            }
        }
        var4_7 = true;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void initNpcFaceOne(String var1_1) {
        block6: {
            block4: {
                block11: {
                    block10: {
                        block9: {
                            block8: {
                                block7: {
                                    block5: {
                                        if (var1_1 == null) lbl-1000:
                                        // 4 sources

                                        {
                                            return;
                                        }
                                        var2_2 = -1;
                                        this.faceDir = true;
                                        if (!var1_1.equals("\u585e\u5176")) break block5;
                                        var2_2 = 0;
                                        this.faceDir = false;
lbl9:
                                        // 8 sources

                                        while (var2_2 > -1) {
                                            if (this.imgFace != null && this.faceLast == var2_2) ** GOTO lbl-1000
                                            if (!this.faceDir) break block4;
                                            var3_3 = 50;
lbl13:
                                            // 2 sources

                                            while (true) {
                                                this.face_c = (short)var3_3;
                                                this.faceLast = (byte)var2_2;
                                                this.imgFace = null;
                                                this.imgFace = Ms.i().createImage("data/face/" + var2_2);
                                                ** GOTO lbl-1000
                                                break;
                                            }
                                        }
                                        break block6;
                                    }
                                    if (!var1_1.equals("\u5b89\u742a\u513f") && !var1_1.equals("\u84dd\u53d1\u5973\u5b69")) break block7;
                                    var2_2 = 1;
                                    ** GOTO lbl9
                                }
                                if (!var1_1.equals("\u5e7d\u6697\u9b3c\u738b")) break block8;
                                var2_2 = 2;
                                ** GOTO lbl9
                            }
                            if (!var1_1.equals("\u6770\u5947\u6821\u957f")) break block9;
                            var2_2 = 3;
                            ** GOTO lbl9
                        }
                        if (!var1_1.equals("\u666e\u7f57") && !var1_1.equals("\u666e\u7f57\u6821\u957f")) break block10;
                        var2_2 = 4;
                        ** GOTO lbl9
                    }
                    if (!var1_1.equals("\u795e\u79d8\u4e1c\u65b9\u7537\u5b50")) break block11;
                    var2_2 = 5;
                    ** GOTO lbl9
                }
                if (!var1_1.equals("\u5357\u5bab\u4e91")) ** GOTO lbl9
                var2_2 = 6;
                ** GOTO lbl9
            }
            var3_3 = -50;
            ** while (true)
        }
        this.nullNpcFace();
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public boolean initSrcEffect(int var1_1) {
        var3_2 = Constants_H.SRC_BATTLE_H__;
        this.my.state = (byte)10;
        switch (var1_1) {
            default: {
                while (true) {
                    var4_3 = false;
lbl7:
                    // 3 sources

                    return var4_3;
                }
            }
            case 0: 
            case 1: 
            case 2: {
                this.bSrc_c = 0;
                if (var1_1 != 1) ** GOTO lbl20
lbl12:
                // 2 sources

                while (true) {
                    this.black_width = (short)var3_2;
                    if (var1_1 != 1) ** GOTO lbl22
                    var4_3 = true;
lbl16:
                    // 2 sources

                    while (true) {
                        this.bSrc = var4_3;
                        var4_3 = true;
                        ** GOTO lbl7
                        break;
                    }
                    break;
                }
lbl20:
                // 1 sources

                var3_2 = 0;
                ** continue;
lbl22:
                // 1 sources

                var4_3 = false;
                ** continue;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: 
        }
        this.bSrc = true;
        if (this.bSrc_c != 0) ** GOTO lbl33
        if (var1_1 != 6 && var1_1 != 5) ** GOTO lbl45
        this.bSrc_c = (short)-40;
        if (var1_1 == 5) {
            var3_2 = 40;
lbl31:
            // 2 sources

            while (true) {
                this.black_width = (short)var3_2;
lbl33:
                // 3 sources

                while (true) {
                    this.bSrc_c = Ms.i().mathSpeedN((int)this.bSrc_c, 0, 12, false);
                    if (this.bSrc_c != 0) ** continue;
                    if (var1_1 != 6) {
                        var4_3 = true;
lbl38:
                        // 2 sources

                        while (true) {
                            this.bSrc = var4_3;
                            var4_3 = true;
                            ** continue;
                            break;
                        }
                    }
                    ** GOTO lbl52
                    break;
                }
                break;
            }
        } else {
            var3_2 = 0;
            ** continue;
lbl45:
            // 1 sources

            if (var1_1 == 4) lbl-1000:
            // 2 sources

            {
                while (true) {
                    this.bSrc_c = var2_4 = (short)var3_2;
                    this.black_width = var2_4;
                    ** continue;
                    break;
                }
            }
            var3_2 = 40;
            ** continue;
        }
lbl52:
        // 1 sources

        var4_3 = false;
        ** while (true)
    }

    public void initWalkIco() {
        if (this.walkIco == null) {
            this.walkIco = Ms.i().createImageArray(3, "data/brow/w");
        }
    }

    /*
     * Unable to fully structure code
     */
    public void insertNpc() {
        if (this.npc == null) {
            return;
        }
        var2_1 = 1;
        while (true) lbl-1000:
        // 2 sources

        {
            if (var2_1 >= this.npcList.length) ** continue;
            var3_3 = var2_1;
            while (true) {
                if (var3_3 <= 0) {
                    while (true) {
                        var2_1 = (byte)(var2_1 + 1);
                        ** continue;
                        break;
                    }
                }
                if ((var4_4 = this.getNpcListY(var3_3)) > (var5_5 = this.getNpcListY(var3_3 - 1))) ** continue;
                if (var4_4 != var5_5 || var4_4 == var5_5 && this.npcList[var3_3 - 1] == -1) {
                    var1_2 = this.npcList[var3_3];
                    this.npcList[var3_3] = this.npcList[var3_3 - 1];
                    this.npcList[var3_3 - 1] = var1_2;
                }
                var3_3 = (byte)(var3_3 - 1);
            }
            break;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void key_map() {
        block17: {
            block9: {
                block10: {
                    block21: {
                        block19: {
                            block20: {
                                block18: {
                                    block15: {
                                        block16: {
                                            block14: {
                                                block13: {
                                                    block12: {
                                                        block11: {
                                                            if (this.my.state == 17) {
                                                                this.keyMiniMap();
lbl3:
                                                                // 15 sources

                                                                return;
                                                            }
                                                            if (this.my.state != 18) break block11;
                                                            this.keyMission();
                                                            ** GOTO lbl3
                                                        }
                                                        if (this.my.state != 12) break block12;
                                                        this.keySelectMenu();
                                                        ** GOTO lbl3
                                                    }
                                                    if (this.my.state != 19) break block13;
                                                    this.keyMySave();
                                                    ** GOTO lbl3
                                                }
                                                if (this.my.state != 22 || this.black_0 <= -1 || this.black_0 != this.gr.about_d.length || !Ms.i().key_Num0()) break block14;
                                                this.eventGoing = (byte)3;
                                                this.black_0 = (short)-1;
                                                Ms.i().keyRelease();
                                                ** GOTO lbl3
                                            }
                                            if (this.my.state != 16) break block15;
                                            if (Ms.i().key_delay()) ** GOTO lbl3
                                            if (!Ms.i().key_Up_Down()) break block16;
                                            var1_1 = this.gr;
                                            var1_1.popMenu = (byte)(var1_1.popMenu ^ 1);
lbl28:
                                            // 3 sources

                                            while (this.my.state == 1 && Ms.i().key_S1_Num5()) {
                                                if (this.dialog_no + 2 < this.dialog.length) break block9;
                                                this.dialog_no = (byte)-1;
                                                this.dialog = null;
                                                if (this.eventGoing != 0) break block10;
                                                this.my.state = 0;
lbl34:
                                                // 2 sources

                                                while (true) {
                                                    if (!this.bDirTalk) ** GOTO lbl3
                                                    this.npc[0][this.get_meet].other[7] = this.npcDirTalk;
                                                    if (this.npc[0][this.get_meet].other[7] > -1) {
                                                        this.npc[0][this.get_meet].dir = (byte)3;
                                                    }
                                                    this.bDirTalk = false;
                                                    ** GOTO lbl3
                                                    break;
                                                }
                                            }
                                            break block17;
                                        }
                                        if (!Ms.i().key_S1_Num5() && !Ms.i().key_S2()) ** GOTO lbl28
                                        if (Ms.i().key_S2()) {
                                            this.gr.popMenu = 1;
                                        }
                                        this.my.state = 0;
                                        ** GOTO lbl3
                                    }
                                    if (this.my.state != 10) break block18;
                                    Ms.i().keyRelease();
                                    ** GOTO lbl3
                                }
                                if (this.my.state != 23) break block19;
                                if (!Ms.i().key_S2()) break block20;
                                this.my.state = (byte)25;
lbl56:
                                // 3 sources

                                while (true) {
                                    Ms.i().keyRelease();
                                    ** GOTO lbl3
                                    break;
                                }
                            }
                            if (!Ms.i().key_S1_Num5()) ** GOTO lbl56
                            this.my.state = (byte)24;
                            ** while (true)
                        }
                        if (this.my.state != 11) break block21;
                        if (Ms.i().key_S1_Num5()) {
                            this.gr.say_c = 0;
                        }
                        if (this.gr.say_c == 0) {
                            this.my.state = 0;
                        }
                        ** GOTO lbl3
                    }
                    if (this.my.state != 20) ** GOTO lbl28
                    this.keyAnoleSel();
                    ** GOTO lbl3
                }
                this.eventGoing = (byte)2;
                ** while (true)
            }
            this.dialog_no = (byte)(this.dialog_no + 2);
            Ms.i().keyRelease();
        }
        if (this.my.frame_c > 0 || this.my.state != 0) ** GOTO lbl3
        Ms.i();
        this.map_key = (byte)(-Ms.key);
        this.doKey();
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void loadDate_Rms() {
        var1_1 = Ms.i().rmsOptions(2, null, 1);
        if (var1_1[0] == -1) {
            var2_2 = new byte[16];
            var2_2[0] = 58;
            var2_2[1] = 9;
            var2_2[2] = 16;
            var2_2[3] = 2;
            var2_2[5] = 1;
            var2_2[6] = 2;
            var2_2[15] = -1;
            var1_1 = var2_2;
            Ms.i().rmsOptions(2, var2_2, 2);
            var2_2 = null;
            this.event_now_list = new short[70][];
            Ms.i().rmsOptions(12, Ms.i().getEventNowData(this.event_now_list), 2);
lbl18:
            // 2 sources

            while (true) {
                this.mapNo = var1_1[0];
                this.lastMap = var1_1[5];
                this.lastExit = var1_1[6];
                this.my.setXY((int)var1_1[1], (int)var1_1[2], 0, 0);
                this.my.dir = var1_1[3];
                this.my.setActionNo(false);
                this.gr.money = Ms.i().getInt(var1_1, 7);
                this.gr.coin = Ms.i().getInt(var1_1, 11);
                this.anole_type = var1_1[15];
                var1_1 = null;
                return;
            }
        }
        this.event_now_list = Ms.i().readEventNowData();
        ** while (true)
    }

    public void mapMove(int n, int n2, int n3, int n4) {
        if (n3 > 0 && n >= this.mapLeft_NOmove && n < this.mapRight_NOmove || n3 < 0 && n > this.mapLeft_NOmove && n <= this.mapRight_NOmove) {
            this.map_x -= n3;
        }
        if (n4 > 0 && n2 >= this.mapUp_NOmove && n2 < this.mapDown_NOmove || n4 < 0 && n2 > this.mapUp_NOmove && n2 <= this.mapDown_NOmove) {
            this.map_y -= n4;
        }
    }

    public void map_saveGame() {
        byte[] byArray = new byte[16];
        byArray[0] = this.mapNo;
        byArray[5] = this.lastMap;
        byArray[6] = this.lastExit;
        byArray[1] = (byte)(this.my.x / 20);
        byArray[2] = (byte)(this.my.y / 20);
        byArray[3] = this.my.dir;
        Ms.i().putInt(this.gr.money, byArray, 7);
        Ms.i().putInt(this.gr.coin, byArray, 11);
        byArray[15] = this.anole_type;
        Ms.i().rmsOptions(2, byArray, 2);
        byArray = null;
    }

    /*
     * Unable to fully structure code
     */
    public void notMeet(int var1_1, int var2_2) {
        if (var1_1 == 0) {
            this.notMeet = 0;
            Ms.i();
            this.step_MEET = (short)(Ms.getRandom((int)30) + 1);
            this.meet_step = (short)((this.step_MEET - 15) * (this.step_MEET - 15));
            var1_1 = this.meet_step;
            Ms.i();
            if (var1_1 <= Ms.getRandom((int)50)) lbl-1000:
            // 2 sources

            {
                while (true) {
                    this.step_MEET = (short)(this.step_MEET << 2);
                    this.meet_step = 0;
                    this.bStep = (byte)-1;
lbl15:
                    // 3 sources

                    return;
                }
            }
            Ms.i();
            var1_1 = Ms.getRandom((int)9);
            Ms.i();
            this.step_MEET = (byte)(var1_1 + 17 - Ms.getRandom((int)7));
            ** continue;
        }
        if (var1_1 != 1) ** GOTO lbl15
        this.notMeet = 1;
        this.step_MEET = (short)((var2_2 - 14 + 1) * 200);
        this.step_MEET = (short)(this.step_MEET << 2);
        this.meet_step = 0;
        this.bStep = (byte)100;
        ** while (true)
    }

    public void nullNpcFace() {
        this.imgFace = null;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void paint_map(Graphics var1_1) {
        block18: {
            block17: {
                block16: {
                    block19: {
                        block20: {
                            block15: {
                                block23: {
                                    block22: {
                                        block21: {
                                            Map.g = var1_1 /* !! */ ;
                                            if (this.my.state == 6) {
                                                this.gr.drawChangeMap(false, (int)this.gr.b_c, 30, 360 - 38, 640 - 60);
lbl4:
                                                // 5 sources

                                                return;
                                            }
                                            if (this.my.state != 17) break block21;
                                            this.drawMiniMap();
                                            ** GOTO lbl4
                                        }
                                        if (this.my.state != 18) break block22;
                                        this.drawMission();
                                        ** GOTO lbl4
                                    }
                                    Ui.i().fillRect(this.bgColor, 0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
                                    GameRun.mc.setScale(MainCanvas.mapxx, MainCanvas.mapyy);
                                    GameRun.mc.keyxx = MainCanvas.mapxx;
                                    GameRun.mc.keyyy = MainCanvas.mapyy;
                                    this.setMapOffer();
                                    if (this.xxx > 0) {
                                        this.xxx = (byte)(this.xxx - 1);
                                        var1_1 /* !! */ .translate(this.xxx % 2, this.xxx % 2);
                                    }
                                    this.drawMap(GameRun.offG);
                                    this.drawNpcAni(this.npc[2]);
                                    if (!this.pkey.isGo) ** GOTO lbl36
                                    var2_2 = this.ii;
                                    this.ii = var2_2 + 1;
                                    if (var2_2 <= 2) ** GOTO lbl35
                                    this.ii = 0;
                                    var2_2 = this.i;
                                    this.i = var2_2 + 1;
                                    if (var2_2 >= 2) break block23;
                                    var2_2 = this.i;
lbl33:
                                    // 2 sources

                                    while (true) {
                                        this.i = var2_2;
lbl35:
                                        // 2 sources

                                        Ui.i().drawImage(this.walkIco[this.i], this.pkey.gox + this.map_x, this.pkey.goy + this.map_y, 3);
lbl36:
                                        // 2 sources

                                        this.drawNMAni(this.npc[0]);
                                        this.bkgroundToPaint(this.frontData, this.mapImg, -this.map_x, -this.map_y - 1, this.moduleData, var1_1 /* !! */ , 0, 0, Constants_H.WIDTH, Constants_H.HEIGHT, false);
                                        this.drawNpcAni(this.npc[1]);
                                        this.drawMapRect(var1_1 /* !! */ );
                                        this.drawStep(var1_1 /* !! */ , Constants_H.WIDTH - 17, 0, 16);
                                        this.drawBrow();
                                        this.drawCheck5(4);
                                        this.drawCloud();
                                        if (this.gr.magic_id <= -1) ** GOTO lbl59
                                        var6_3 = this.gr;
                                        if (this.gr.magic_id / 5 <= 5) break block15;
                                        var2_2 = 5;
lbl48:
                                        // 2 sources

                                        while (this.gr.magic_id / 5 > 5) {
                                            var3_4 = 5;
lbl50:
                                            // 2 sources

                                            while (this.gr.magic_id / 5 >= 5) {
                                                var4_5 = this.gr.magic_id - 25;
lbl52:
                                                // 2 sources

                                                while (true) {
                                                    if (!var6_3.drawMagicC(var2_2, var3_4, var4_5, this.gr.magic_x, this.gr.magic_y + 16, 0)) ** GOTO lbl59
                                                    if (this.my.state != 21) break block16;
                                                    this.gr.magic_id = (byte)-2;
                                                    this.setAnole();
lbl57:
                                                    // 2 sources

                                                    while (true) {
                                                        this.my.state = 0;
lbl59:
                                                        // 3 sources

                                                        var1_1 /* !! */ .translate(-var1_1 /* !! */ .getTranslateX(), -var1_1 /* !! */ .getTranslateY());
                                                        if (this.my.state == 20) {
                                                            this.drawAnoleSel();
                                                        }
                                                        var1_1 /* !! */ .restCanvas();
                                                        if (!this.fontSizeControl) {
                                                            Ms.i();
                                                            Ms.font.setSize(22);
                                                        }
                                                        this.drawSrcEffect();
                                                        if (this.my.state == 12) {
                                                            var2_2 = Constants_H.WIDTH__ / 2;
                                                            this.gr.drawSelectMenu_((Object[])this.gr.action_str, var2_2 - 25 * 3, Constants_H.HEIGHT__ / 2 - 100 + (this.gr.action_str.length >> 1) * 25, 25 * 6, 0, 0, (int)this.gr.cur_a);
                                                        }
                                                        if (this.gr.view_state != 4) break block17;
                                                        var4_5 = Constants_H.WIDTH__;
                                                        var3_4 = Constants_H.HEIGHT__;
                                                        var2_2 = Constants_H.WIDTH__ / 2;
                                                        Ui.i().drawKuang(0, var3_4 - 25 * 3, var4_5, 25 * 3);
                                                        var6_3 = this.gr;
                                                        var1_1 /* !! */  = this.gr;
                                                        var4_5 = this.gr.cur_a;
                                                        var6_3.showStringM_(var1_1 /* !! */ .getNameMonsterInfo((int)(new byte[]{4, 25, 56})[var4_5]), var2_2, var3_4 - 25 * 2 - 8, 10, 3);
                                                        var1_1 /* !! */  = (Graphics)((byte[])null);
lbl81:
                                                        // 3 sources

                                                        while (true) {
                                                            if (this.my.state != 20) {
                                                                this.gr.drawPauseIco((int)this.my.state);
                                                            }
                                                            if (this.my.state != 19) break block18;
                                                            this.drawMySave();
                                                            ** GOTO lbl4
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                    break;
                                                }
                                            }
                                            break block19;
                                        }
                                        break block20;
                                        break;
                                    }
                                }
                                var2_2 = 0;
                                ** while (true)
                            }
                            var2_2 = this.gr.magic_id / 5;
                            ** GOTO lbl48
                        }
                        var3_4 = this.gr.magic_id / 5;
                        ** GOTO lbl50
                    }
                    var4_5 = this.gr.magic_id % 5;
                    ** while (true)
                }
                this.gr.magic_id = (byte)-1;
                ** while (true)
            }
            if (this.my.state != 16) ** GOTO lbl81
            var3_4 = Constants_H.WIDTH__;
            var2_2 = Constants_H.HEIGHT__;
            var5_6 = Constants_H.WIDTH__ / 2;
            var4_5 = Constants_H.HEIGHT__ / 2;
            Ui.i().drawKuang(0, var2_2 - 25 * 4, var3_4, 25 * 4);
            this.gr.showStringM_("\u662f\u5426\u56de\u590d\u6240\u6709\u5ba0\u7269\uff1f", var5_6, var2_2 - 25 * 4 + 4, 10, 3);
            this.gr.drawSelectMenu_((Object[])this.gr.action_str, var5_6 - 25 * 2, var4_5 - 25, 25 * 4, -1, 0, (int)this.gr.popMenu);
            this.gr.showStringM_("\u6240\u9700\u91d1\u989d\uff1a" + this.gr.sell_money, var5_6, var2_2 - 25 * 3 + 4, 10, 3);
            this.gr.drawMoney(var5_6, var2_2 - 25 + 15, 3, false);
            ** while (true)
        }
        var2_2 = this.gr.rmsOther[2];
        this.gr.drawCityName();
        if (this.my.state == 23) {
            var4_5 = Constants_H.WIDTH__;
            var2_2 = Constants_H.HEIGHT__;
            var3_4 = Constants_H.WIDTH__ / 2;
            Ui.i().drawKuang(0, var2_2 - 25 * 2, var4_5, 25 * 2);
            Ui.i().drawString("\u662f\u5426\u4fdd\u5b58\u8fdb\u5ea6\uff1f", var3_4, var2_2 - 25 * 2 + 6, 17, 3, 0);
            Ui.i().drawYesNo__(true, true);
            this.pkey.isGo = false;
        }
        if (this.dialog_no > -1) {
            this.dialog(this.npcName);
            this.pkey.isGo = false;
        }
        this.gr.map_flashString();
        Ms.i();
        Ms.font.setSize(26);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void run_map() {
        block9: {
            block8: {
                if (this.my.state != 9 && this.my.state != 6) {
                    this.eventCheck();
                }
                if (this.my.state == 5 && this.my.frame_c < 1) {
                    this.setMoveStop_m();
                    this.my.state = (byte)6;
                }
                if (this.my.state == 6) {
                    this.gr.createOver = 1;
                    this.goNextMap();
lbl9:
                    // 2 sources

                    return;
                }
                if (this.my.state != 2 || this.eventGoing != 0) break block8;
                if ((this.npc[0][this.get_meet].other[4] == 1 || this.npc[0][this.get_meet].other[4] == 3) && this.npc[0][this.get_meet].other[5] > 0) {
                    this.npcName = this.npcNameData[this.get_meet];
                    if (this.npcName.equals("\u8def\u4eba")) {
                        this.npcName = null;
                    }
                    this.initNpcFaceOne(this.npcName);
                    Ms.i();
                    Ms.font.setSize(22);
                    this.dialog = Ms.i().groupString(this.npcStringData[this.npc[0][this.get_meet].other[5] - 1], Constants_H.WIDTH__ - 20);
                    if (!this.fontSizeControl) {
                        Ms.i();
                        Ms.font.setSize(26);
                    }
                    this.dialog_no = 0;
                    this.my.state = 1;
lbl27:
                    // 5 sources

                    while (true) {
                        this.runMove();
                        ** continue;
                        break;
                    }
                }
                this.my.state = 0;
                ** GOTO lbl27
            }
            if (this.my.state != 8 || this.my.frame_c != -1) ** GOTO lbl27
            if (this.gr.immueEnemy != 0) break block9;
            Log.e((String)"sk", (String)"gr.immueEnemy==0");
            var1_1 = this.gr;
            var2_2 = this.gr.battleSay;
            Ms.i();
            var1_1.say(var2_2[Ms.getRandom((int)3)], 0);
            GameRun.mc.repaint();
            this.gr.battleType(4);
            this.gr.goBattlePVC();
            ** GOTO lbl27
        }
        this.my.state = 0;
        ** while (true)
    }

    public void save() {
        this.map_saveGame();
        this.saveNpc();
        int n = 0;
        while (true) {
            if (n >= this.mapInfo.length / 2) {
                Ms.i().rmsOptions(13, Ms.i().shortArrayToByteArray(this.mapInfo), 2);
                Ms.i().rmsOptions(12, Ms.i().getEventNowData(this.event_now_list), 2);
                Ms.i().rmsOptions(1, this.mapChange, 2);
                Ms.i().rmsOptions(7, this.bMission, 2);
                Ms.i().rmsOptions(5, this.gr.rmsSms, 2);
                Ms.i().rmsOptions(1, null, 4);
                return;
            }
            if (this.mapChange[n] == 1) {
                this.mapChange[n] = 0;
                Ms.i().rmsOptions(n + 14, this.mapTemp[n], 2);
            }
            ++n;
        }
    }

    public void saveMapBak() {
        this.saveNpc();
        this.mapChange[this.mapNo] = 1;
        Ms.i().rmsOptions(1, this.mapChange, 2);
    }

    public void saveNpc() {
        this.mapTemp[this.mapNo] = null;
        this.mapTemp[this.mapNo] = this.getNpcData();
        this.mapInfo[this.mapNo * 2] = 1;
        this.mapChange[this.mapNo] = 1;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void setAnole() {
        block6: {
            block5: {
                var3_1 /* !! */  = this.gr;
                if (this.anole_type == 3) {
                    var1_2 = true;
lbl4:
                    // 2 sources

                    while (true) {
                        var3_1 /* !! */ .immueEnemy = (byte)var1_2;
                        this.my.speed = this.getMySpeed();
                        var5_3 = Ms.i();
                        var4_4 = Map.npcSp[1][0];
                        var6_5 = new StringBuilder("data/npc1/");
                        if (this.anole_type != -1) break block5;
                        var3_1 /* !! */  = "0";
lbl12:
                        // 2 sources

                        while (true) {
                            var3_1 /* !! */  = var6_5.append((String)var3_1 /* !! */ ).toString();
                            if (this.anole_type == -1) {
                                var2_6 = true;
lbl16:
                                // 2 sources

                                while (true) {
                                    var5_3.setSprite(var4_4, (String)var3_1 /* !! */ , var2_6);
                                    this.my.setActionNo(false);
                                    return;
                                }
                            }
                            break block6;
                            break;
                        }
                        break;
                    }
                }
                var1_2 = false;
                ** while (true)
            }
            var3_1 /* !! */  = "r" + this.anole_type;
            ** while (true)
        }
        var2_6 = false;
        ** while (true)
    }

    public void setMapMusic(boolean bl) {
        Sound.i().setMusicId((int)this.gr.musicNo[this.mapNo]);
        Sound.i().setMusic(bl);
    }

    /*
     * Unable to fully structure code
     */
    public void setMission(int var1_1, boolean var2_2) {
        var3_3 = (byte)(var1_1 / 8);
        var1_1 = (byte)(var1_1 % 8);
        if (var2_2) {
            var4_4 = this.bMission;
            var4_4[var3_3] = (byte)(var4_4[var3_3] | 1 << var1_1);
lbl6:
            // 3 sources

            return;
        }
        if ((this.bMission[var3_3] & 1 << var1_1) == 0) ** GOTO lbl6
        var4_5 = this.bMission;
        var4_5[var3_3] = (byte)(var4_5[var3_3] ^ 1 << var1_1);
        var4_5 = this.bMission;
        var4_5[15] = (byte)(var4_5[15] + 1);
        ** while (true)
    }

    public void setNull() {
        this.npc[0] = null;
        this.item = null;
        this.door = null;
        this.event = null;
        this.mapImg = null;
        this.moduleData = null;
    }

    /*
     * Unable to fully structure code
     */
    public void setOverEvent(int var1_1, int var2_2) {
        if (!this.isMapEvent(var1_1, var2_2)) {
            var4_3 = this.mapInfo;
            var3_4 = var1_1 * 2 + 1;
            var4_3[var3_4] = (short)(var4_3[var3_4] | 1 << var2_2);
        }
        if (var1_1 == this.mapNo) {
            this.event_now[var2_2] = 24224;
lbl7:
            // 3 sources

            return;
        }
        if (this.event_now_list[var1_1] == null) ** GOTO lbl7
        this.event_now_list[var1_1][var2_2] = 24224;
        ** while (true)
    }

    public void setRegState(boolean bl) {
        // MONITORENTER : this
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder("setRegState() notifyAll start isSuccess= ");
        printStream.println(stringBuilder.append(bl).toString());
        this.isNeedWait = false;
        this.notifyAll();
        System.out.println("setRegState() notifyAll over");
        // MONITOREXIT : this
        return;
    }

    /*
     * Unable to fully structure code
     */
    public void setRestEvent(int var1_1, int var2_2) {
        if (this.isMapEvent(var1_1, var2_2)) {
            var4_3 = this.mapInfo;
            var3_4 = var1_1 * 2 + 1;
            var4_3[var3_4] = (short)(var4_3[var3_4] ^ 1 << var2_2);
        }
        if (var1_1 == this.mapNo) {
            this.event_now[var2_2] = 0;
lbl7:
            // 3 sources

            return;
        }
        if (this.event_now_list[var1_1] == null) ** GOTO lbl7
        this.event_now_list[var1_1][var2_2] = 0;
        ** while (true)
    }

    public void setTempNull() {
        this.mapTemp = null;
        this.mapTemp = new byte[70][];
    }

    public void setfmap() {
        this.fmap = 0;
    }
}
