package main;

import android.util.Log;
import com.android.Util.AndroidUtil;
import dm.Ms;
import dm.Npc;
import dm.Sound;
import dm.Sprite;
import dm.Ui;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.PrintStream;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import minigame.Mg;

/**
 * The Map class represents a game map and implements the Key_H interface.
 * It manages various aspects of the game map including NPCs, events, and player interactions.
 * 
 * <h2>Dependencies:</h2>
 * <ul>
 *   <li>Key_H</li>
 *   <li>Npc</li>
 *   <li>Graphics</li>
 *   <li>Sprite</li>
 *   <li>GameRun</li>
 *   <li>Image</li>
 *   <li>PointerKey</li>
 *   <li>Constants_H</li>
 *   <li>Ms</li>
 *   <li>Ui</li>
 *   <li>Log</li>
 *   <li>AndroidUtil</li>
 * </ul>
 * 
 * <h2>Fields:</h2>
 * <ul>
 *   <li>cur_npc: Current NPC being interacted with.</li>
 *   <li>g: Graphics object for rendering.</li>
 *   <li>npcSp: Array of NPC sprites.</li>
 *   <li>action_5, anoleSel, anole_temp, anole_type: Various action and selection states.</li>
 *   <li>bDirTalk, bExitBoss, bPause, bSrc, bMission, bStep: Various boolean and byte flags.</li>
 *   <li>bgColor, black_0, black_1, black_width: Color and dimension settings.</li>
 *   <li>boatCourse, boatSelect: Boat-related data.</li>
 *   <li>bottomData, bottomRow, brow, checkNpcT, checkType: Map and NPC data.</li>
 *   <li>cloud, cols, dialog, dialog_no, dir_select, door, event, eventCount, eventGoing, event_now, event_now_list, event_state: Event and dialog data.</li>
 *   <li>fString, faceDir, faceLast, face_c, firstDrawMap, fmap, fontSizeControl, frontData, get_meet, gmErr, go, gr, hudong, i, ii, imgCloud, imgFace, imgShadow, inShop, isNeedWait, item, lastExit, lastMap, leftCol, littleMapClipY, mDirect, mapChange, mapDown_NOmove, mapImg, mapInfo, mapLeft_NOmove, mapNo, mapNotemp, mapRight_NOmove, mapTemp, mapUp_NOmove, map_bottom, map_key, map_left, map_right, map_top, map_x, map_y, mapdataArea, mapdataMap, mapoffx, mapoffy, meet_step, miniMapMode, moduleData, my, myMiniMap, notMeet, now_eV1, now_eV2, npc, npcDirTalk, npcList, npcName, npcNameData, npcPos, npcStringData, pkey, rightCol, roadType, rows, sEvent_eV1, sEvent_eV2, sIfElse, sMission, selectMap, showArea, sleep_count, smissionLength, srcFlash_c, srcNpcNo, step_MEET, time_5, topRow, walkIco, worldData, xxx: Various fields for managing map state, NPCs, events, and rendering.</li>
 * </ul>
 * 
 * <h2>Constructor:</h2>
 * <ul>
 *   <li>Map(GameRun var1): Initializes the map with the given GameRun instance.</li>
 * </ul>
 * 
 * <h2>Usage:</h2>
 * <p>
 * The Map class is used to manage the game map, including NPC interactions, events, and rendering.
 * It provides methods for initializing and updating the map, handling player movement, and managing events and dialogs.
 * </p>
 */
public class Map implements Key_H {
    private static Npc cur_npc;
    private static Graphics g;
    static Sprite[][] npcSp = new Sprite[3][];
    private byte action_5;
    private byte anoleSel;
    public byte anole_temp = -1;
    public byte anole_type = -1;
    public boolean bDirTalk;
    boolean bExitBoss = false;
    public byte[] bMission;
    private boolean bPause;
    private boolean bSrc;
    private short bSrc_c;
    private byte bStep = -1;
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
    public byte dialog_no = -1;
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
    public byte fmap = -1;
    boolean fontSizeControl;
    short[] frontData;
    private byte get_meet;
    public boolean gmErr = false;
    private byte go = -2;
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
    private byte[][] mapTemp = new byte[70][];
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
    public byte sIfElse = -1;
    private StringBuffer[][] sMission;
    private byte selectMap;
    private byte showArea;
    private byte sleep_count = 0;
    public int smissionLength;
    private byte srcFlash_c;
    private byte srcNpcNo = -1;
    private short step_MEET = 4;
    private byte time_5;
    private short topRow;
    public Image[] walkIco;
    short[][] worldData;
    private byte xxx = 0;

    public Map(GameRun var1) {
        super();
        byte[] var5 = new byte[2];
        byte[] var4 = new byte[]{0, -1};
        byte[] var3 = new byte[]{0, 1};
        byte[] var6 = new byte[]{-1, 0};
        byte[] var2 = new byte[]{1, 0};
        this.dir_select = new byte[][]{var5, var4, var3, var6, var2};
        this.anoleSel = 0;
        this.npcDirTalk = -1;
        this.bDirTalk = false;
        this.checkNpcT = -1;
        this.roadType = 0;
        this.miniMapMode = false;
        this.showArea = -1;
        this.littleMapClipY = 300;
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
        this.faceLast = -1;
        this.face_c = 0;
        this.bSrc_c = 0;
        this.bSrc = false;
        this.srcFlash_c = 0;
        this.boatSelect = -1;
        this.isNeedWait = true;
        this.gr = var1;
        System.gc();
        this.init();
    }

    private void addCloud(int var1) {
        short[] var4 = this.cloud[var1];
        short var3 = this.leftCol;
        int var2 = Constants_H.WIDTH;
        Ms.i();
        var4[0] = (short)(var3 * 20 + var2 + Ms.getRandom(Constants_H.WIDTH_H));
        var4 = this.cloud[var1];
        short var5 = this.topRow;
        Ms.i();
        var4[1] = (short)(var5 * 20 + 20 + 2 + (Ms.getRandom(25) + 55) * var1);
        var4 = this.cloud[var1];
        Ms.i();
        var4[2] = (short)(Ms.getRandom(3) + 1);
    }

    private void canMove(int var1, int var2) {
        this.my.speed_x = (byte)var1;
        this.my.speed_y = (byte)var2;
        if (this.my.x + this.my.speed_x >= 0 && this.my.x + this.my.speed_x + 19 < this.cols * 20 && this.my.y + this.my.speed_y >= 0 && this.my.y + this.my.speed_y + 19 < this.rows * 20) {
            this.roadType = this.checkMap(this.my.x, this.my.y, this.my.speed_x, this.my.speed_y);
            if (this.roadType == 0) {
                this.initMoveMy();
            } else if (this.checkMoveOff(this.checkNpcT)) {
                this.initMoveMy();
            } else if (this.checkNpcT != -1 && !this.isCheckNpcOff()) {
                Ms.i().keyRelease();
                this.setMoveStop_m();
            } else {
                this.roadType = this.isMapChenk(this.roadType);
                if (this.roadType == -1) {
                    this.moveOff((byte)3, (byte)1, -this.my.speed);
                } else if (this.roadType == -2) {
                    this.moveOff((byte)4, (byte)2, this.my.speed);
                } else {
                    this.checkAnole();
                }
            }
        } else {
            this.setMoveStop_m();
            this.checkType = this.checkIfOther(this.door, this.my.x, this.my.y);
            if (this.checkType != -1 && this.door[this.checkType][5] == 0 && this.map_key == this.door[this.checkType][2]) {
                this.my.state = 5;
                this.get_meet = this.checkType;
            }
        }

    }

    private void checkAnole() {
        this.checkType = this.checkWorld(this.my.x, this.my.y, this.my.speed_x, this.my.speed_y, true);
        if (this.checkType == 2) {
            if (this.isCheckAnole(4)) {
                return;
            }
        } else if (this.checkType == 3) {
            if (this.isCheckAnole(0)) {
                return;
            }
        } else if (this.checkType == 4) {
            if (this.isCheckAnole(2)) {
                return;
            }
        } else if (this.checkType == 0 && this.anole_type == 4) {
            if (this.anole_type != 3 && this.isAnoleType(3)) {
                this.anole_type = 3;
            } else {
                this.anole_type = -1;
            }

            this.setAnole();
            this.initMoveMy();
            return;
        }

        Ms.i().keyRelease();
        this.setMoveStop_m();
    }

    private byte checkIfNpc(Npc[] var1, int var2, int var3) {
        byte var4 = (byte)(var1.length - 1);

        while(true) {
            if (var4 <= -1) {
                var4 = -1;
                break;
            }

            if (Ms.i().isRect(var2, var3, 19, 19, var1[var4].x, var1[var4].y, 20, 20) && (var1[var4].other[4] == 1 || var1[var4].other[4] == 3)) {
                break;
            }

            --var4;
        }

        return var4;
    }

    private byte checkIfOther(byte[][] var1, int var2, int var3) {
        byte var4 = (byte)(var1.length - 1);

        while(true) {
            if (var4 <= -1) {
                var4 = -1;
                break;
            }

            if (Ms.i().isRect(var2, var3, 19, 19, var1[var4][0] * 20, var1[var4][1] * 20, 20, 20)) {
                break;
            }

            --var4;
        }

        return var4;
    }

    private byte checkMap(int var1, int var2, int var3, int var4) {
        this.checkNpcT = -1;
        this.checkType = this.checkIfOther(this.item, var1 + var3, var2 + var4);
        byte var5;
        if (this.checkType != -1) {
            this.checkNpcT = -2;
            var5 = 1;
        } else if (var1 + var3 >= 0 && var1 + var3 < this.cols * 20 && var2 + var4 >= 0 && var2 + var4 < this.rows * 20) {
            this.checkType = this.checkIfNpc(this.npc[0], var1 + var3, var2 + var4);
            if (this.checkType != -1) {
                if (!this.npcNameData[this.checkType].equals("路人") || this.npc[0][this.checkType].other[5] > 0) {
                    this.checkNpcT = this.checkType;
                }

                var5 = 1;
            } else {
                this.checkType = this.checkIfOther(this.door, var1 + var3, var2 + var4);
                if (this.checkType == -1 || this.door[this.checkType][5] != 2 && this.map_key != this.door[this.checkType][2]) {
                    var5 = this.checkWorld(var1, var2, var3, var4, false);
                } else {
                    this.my.state = 5;
                    this.get_meet = this.checkType;
                    var5 = 0;
                }
            }
        } else {
            var5 = 1;
        }

        return var5;
    }

    private boolean checkMoveOff(int var1) {
        byte var2;
        byte var3;
        boolean var7;
        Npc var8;
        if (var1 > -1) {
            var2 = (byte)(this.npc[0][var1].x + 20 - this.my.x);
            var3 = (byte)(this.npc[0][var1].x - this.my.x - 20);
            byte var5 = (byte)(this.npc[0][var1].y + 20 - this.my.y);
            byte var4 = (byte)(this.npc[0][var1].y - this.my.y - 20);
            if (this.my.speed_x < 0 && var2 != 0) {
                var8 = this.my;
                if (var2 < this.my.speed_x) {
                    var2 = this.my.speed_x;
                }

                var8.speed_x = var2;
                var7 = true;
                return var7;
            }

            if (this.my.speed_x > 0 && var3 != 0) {
                var8 = this.my;
                if (var3 < this.my.speed_x) {
                    var2 = var3;
                } else {
                    var2 = this.my.speed_x;
                }

                var8.speed_x = var2;
                var7 = true;
                return var7;
            }

            if (this.my.speed_y < 0 && var5 != 0) {
                var8 = this.my;
                if (var5 < this.my.speed_y) {
                    var2 = this.my.speed_y;
                } else {
                    var2 = var5;
                }

                var8.speed_y = var2;
                var7 = true;
                return var7;
            }

            if (this.my.speed_y > 0 && var4 != 0) {
                var8 = this.my;
                if (var4 < this.my.speed_y) {
                    var2 = var4;
                } else {
                    var2 = this.my.speed_y;
                }

                var8.speed_y = var2;
                var7 = true;
                return var7;
            }
        } else {
            byte var6 = this.my.getIx_off();
            var3 = (byte)(20 - this.my.getIx_off());
            byte var9 = this.my.getIy_off();
            var2 = (byte)(20 - this.my.getIy_off());
            if (this.my.speed_x != 0 && var6 != 0) {
                if (this.my.speed_x < 0) {
                    var8 = this.my;
                    if (-var6 < this.my.speed_x) {
                        var1 = this.my.speed_x;
                    } else {
                        var1 = -var6;
                    }

                    var8.speed_x = (byte)var1;
                } else {
                    var8 = this.my;
                    if (var3 < this.my.speed_x) {
                        var2 = var3;
                    } else {
                        var2 = this.my.speed_x;
                    }

                    var8.speed_x = var2;
                }

                var7 = true;
                return var7;
            }

            if (this.my.speed_y != 0 && var9 != 0) {
                if (this.my.speed_y < 0) {
                    var8 = this.my;
                    if (-var9 < this.my.speed_y) {
                        var1 = this.my.speed_y;
                    } else {
                        var1 = -var9;
                    }

                    var8.speed_y = (byte)var1;
                } else {
                    var8 = this.my;
                    if (var2 >= this.my.speed_y) {
                        var2 = this.my.speed_y;
                    }

                    var8.speed_y = var2;
                }

                var7 = true;
                return var7;
            }
        }

        var7 = false;
        return var7;
    }

    private byte checkWorld(int var1, int var2, int var3, int var4, boolean var5) {
        byte var7;
        byte var8;
        int var9;
        label56: {
            var9 = 0;
            byte var10 = 1;
            if (var3 != 0 || var1 % 20 == 0) {
                var8 = var10;
                var7 = (byte)var9;
                if (var4 != 0) {
                    break label56;
                }

                var8 = var10;
                var7 = (byte)var9;
                if (var2 % 20 == 0) {
                    break label56;
                }
            }

            var8 = 2;
            var7 = (byte)var9;
        }

        byte var6;
        while(true) {
            if (var7 >= var8) {
                var6 = 0;
                break;
            }

            byte var12;
            byte var13;
            if (var4 == 0) {
                var12 = (byte)((var7 * 20 + var2) / 20);
                if (var3 >= 0) {
                    var9 = (var1 + var3 + 19) / 20;
                } else {
                    var9 = (var1 + var3) / 20;
                }

                var13 = (byte)var9;
            } else {
                var12 = (byte)((var7 * 20 + var1) / 20);
                if (var4 >= 0) {
                    var9 = (var2 + var4 + 19) / 20;
                } else {
                    var9 = (var2 + var4) / 20;
                }

                byte var11 = (byte)var9;
                var13 = var12;
                var12 = var11;
            }

            if (var5) {
                if (this.worldData[var13][var12] != 0) {
                    var6 = (byte)this.worldData[var13][var12];
                    break;
                }
            } else if (this.isCan_not_pass(var13, var12)) {
                var6 = 1;
                break;
            }

            ++var7;
        }

        return var6;
    }

    private void configureNpc() {
        npcSp[0] = new Sprite[100];
        npcSp[1] = new Sprite[5];
        npcSp[2] = new Sprite[60];
    }

    private void createMap() {
        this.loadMapModuleAndImage();
        this.loadMapData(this.mapNo);
    }

    private void dialog(String var1) {
        int var7 = Constants_H.WIDTH__;
        int var3 = Constants_H.HEIGHT__;
        int var5 = var3 - 8 - 25 * 2;
        int var6 = 25 * 2 + 11;
        byte var4 = 0;
        Ui.i().drawKuang(4, var3 - var6 - 4, var7 - 4, var6 + 4);
        int var2 = var4;
        if (var1 != null) {
            if (this.faceDir) {
                var2 = var7 - 50;
            } else {
                var2 = 50;
            }

            if (this.faceDir) {
                var3 = var3 - var6 - 4;
            } else {
                var3 = var3 - var6 - 4 - 25;
            }

            this.drawNpcFace(var2, var3, 1 | 32);
            Ui.i().drawKuang(0, var5 - var6 + 25, Ms.i().getStringWidth(var1) + 16, 25 + 8);
            Ui.i().drawString(var1, 8, var5 - var6 + 2 + 25, 0, 9, 1);
            Log.e("sk", "dialog");
            var2 = var4;
        }

        while(var2 < 2 && this.dialog_no + var2 < this.dialog.length) {
            Ui.i().drawStringColor(this.dialog[this.dialog_no + var2].toString(), 10, var2 * 25 + (var5 - 2), -1, 1);
            ++var2;
        }

    }

    private void drawAnoleSel() {
        this.gr.cur_a = (byte)Ms.i().mathSpeedN(this.gr.cur_a, 25 * 2 + 12, 8, false);
        Ui.i().drawK1(0, Constants_H.HEIGHT - this.gr.cur_a - 2, 119, 25 + 4 + 2, 2);
        Ui.i().drawK2(0, Constants_H.HEIGHT + 25 + 4 - this.gr.cur_a, Constants_H.WIDTH, 25 + 8, 0);

        int var2;
        for(byte var1 = 0; var1 < 5; ++var1) {
            byte var3;
            if (!this.isAnoleType(var1)) {
                var3 = 6;
                var2 = (byte)(var1 + 70);
            } else {
                if (var1 == this.anoleSel) {
                    var2 = 1;
                } else {
                    var2 = 0;
                }

                var3 = (byte)var2;
                if (var1 == this.anole_type) {
                    var2 = 69;
                } else {
                    if (var1 == this.anoleSel) {
                        var2 = var1 + 5;
                    } else {
                        var2 = var1;
                    }

                    var2 = (byte)var2;
                }
            }

            Ui.i().drawK0(Constants_H.WIDTH * var1 / 6 + 42, Constants_H.HEIGHT + 25 + 8 - this.gr.cur_a, 20, 20, var3);
            Ui.i().drawUi(var2, Constants_H.WIDTH * var1 / 6 + 42 + 10, Constants_H.HEIGHT + 25 + 8 - this.gr.cur_a + 18, 33, 0);
            if (this.pkey.isSelect(Constants_H.WIDTH * var1 / 6 + 42, Constants_H.HEIGHT + 25 + 8 - this.gr.cur_a, 20, 20)) {
                if (this.anoleSel == var1) {
                    this.pkey.setKeySoftkey1();
                } else {
                    this.anoleSel = var1;
                }
            }
        }

        byte var5;
        if (this.anoleSel == this.anole_type) {
            var5 = 0;
        } else {
            if (this.isAnoleType(this.anoleSel)) {
                var2 = this.anoleSel + 1;
            } else {
                var2 = 6;
            }

            var5 = (byte)var2;
        }

        Log.e("sk", "drawAnoleSel");
        Ui.i().drawString(this.gr.about_a[var5].toString(), 60, Constants_H.HEIGHT - this.gr.cur_a - 2, 17, 1, 2);
        Ui.i().drawK4(this.anoleSel * Constants_H.WIDTH / 6 + 41 + this.gr.cur_b / 3, Constants_H.HEIGHT + 25 + 7 - this.gr.cur_a + this.gr.cur_b / 3, 22 - (this.gr.cur_b / 3 << 1), 22 - (this.gr.cur_b / 3 << 1));
        GameRun var4 = this.gr;
        var5 = var4.cur_b;
        var4.cur_b = (byte)(var5 + 1);
        if (var5 > 4) {
            this.gr.cur_b = 0;
        }

        Ui.i().drawYesNo_(false, true);
    }

    private void drawBrow() {
        for(byte var2 = 0; var2 < this.npcList.length; ++var2) {
            byte var3 = this.npcList[var2];
            if (var3 >= -1) {
                if (var3 == -1) {
                    cur_npc = this.my;
                } else {
                    cur_npc = this.npc[0][var3];
                }

                if ((cur_npc.other[4] == 1 || cur_npc.other[4] == 2) && (cur_npc.brow_type > -1 || cur_npc.other[6] != 0) && (var3 <= -1 || this.isNpcSrc(cur_npc.x, cur_npc.y))) {
                    if (cur_npc.other[6] != 0) {
                        cur_npc.brow_type = cur_npc.other[6];
                    }

                    if (cur_npc.brow_action >= this.brow.aLength(cur_npc.brow_type)) {
                        if (cur_npc.other[6] == 0) {
                            cur_npc.brow_type = -1;
                            continue;
                        }

                        cur_npc.brow_action = 0;
                    }

                    Ui.i().drawFrameOne(this.brow, this.brow.action(cur_npc.brow_type, cur_npc.brow_action, 0), this.map_x + cur_npc.x + 14, this.map_y + cur_npc.y - 15 - 10, 0);
                    Npc var4 = cur_npc;
                    byte var1 = (byte)(var4.brow_time + 1);
                    var4.brow_time = var1;
                    if (var1 > this.brow.action(cur_npc.brow_type, cur_npc.brow_action, 1)) {
                        var4 = cur_npc;
                        ++var4.brow_action;
                        cur_npc.brow_time = 0;
                    }
                }
            }
        }

    }

    private void drawCheck5(int var1) {
        if (this.checkNpcT != -1 && this.my.state == 0) {
            this.drawHudong();
            if (this.checkNpcT >= 0 && this.npc[0][this.checkNpcT].other[6] == 0) {
                this.drawHudong();
                Ui.i().drawFrameOne(this.brow, this.brow.action(var1, this.action_5, 0), this.map_x + this.npc[0][this.checkNpcT].x + 10, this.map_y + this.npc[0][this.checkNpcT].y - 16 - 10, 0);
                byte var2 = (byte)(this.time_5 + 1);
                this.time_5 = var2;
                if (var2 > this.brow.action(var1, this.action_5, 1)) {
                    var2 = (byte)(this.action_5 + 1);
                    this.action_5 = var2;
                    if (var2 >= this.brow.aLength(var1)) {
                        this.action_5 = 0;
                    }

                    this.time_5 = 0;
                }
            }
        }

    }

    private void drawCloud() {
        if (this.imgCloud != null) {
            byte var1;
            for(var1 = 0; var1 < this.cloud.length; ++var1) {
                Ui.i().drawImage(this.imgCloud, this.map_x + this.cloud[var1][0], this.map_y + this.cloud[var1][1], 0);
            }

            for(var1 = 0; var1 < this.cloud.length; ++var1) {
                if (!this.isNpcSrc(this.cloud[var1][0], this.cloud[var1][1])) {
                    this.addCloud(var1);
                } else {
                    short[] var2 = this.cloud[var1];
                    var2[0] -= this.cloud[var1][2];
                }
            }
        }

    }

    private void drawHudong() {
        Ui.i().drawImage(this.hudong, Constants_H.WIDTH_H, Constants_H.HEIGHT - 30, 3);
    }

    private void drawMapRect(byte var1, byte var2, int var3, boolean var4) {
        int var5 = var1 * 6;
        int var6 = var2 * 6;
        if (this.miniMapMode) {
            var5 = this.mapdataMap[var3][6] * var1;
            var6 = this.mapdataMap[var3][7] * var2;
        }

        if (var4) {
            Ui.i().drawRectZ(12352252, this.mapdataMap[var3][0] * var1 + this.mapoffx, this.mapdataMap[var3][1] * var2 + this.mapoffy, var5, var6, 5);
        } else {
            byte var8;
            short var9;
            Ui var12;
            byte var14;
            if (var3 == this.myMiniMap) {
                var12 = Ui.i();
                var9 = this.mapdataMap[var3][0];
                short var7 = this.mapoffx;
                var8 = this.mapdataMap[var3][1];
                var12.drawK1(var7 + var9 * var1, this.mapoffy + var8 * var2, var5, var6, 4);
            } else {
                var12 = Ui.i();
                var8 = this.mapdataMap[var3][0];
                var9 = this.mapoffx;
                var14 = this.mapdataMap[var3][1];
                var12.drawK0(var9 + var8 * var1, this.mapoffy + var14 * var2, var5, var6, 2);
            }

            GameRun var13 = this.gr;
            String var16 = this.gr.getNameCity(var3);
            byte var15 = this.mapdataMap[var3][0];
            short var11 = this.mapoffx;
            var8 = this.mapdataMap[var3][1];
            short var10 = this.mapoffy;
            if (var3 == this.myMiniMap) {
                var14 = 0;
            } else {
                var14 = 3;
            }

            var13.showStringM(var16, var15 * var1 + var11 + (var5 >> 1), var8 * var2 + var10 + (var6 >> 1) - 25, 4, var14);
            if (var3 == this.myMiniMap) {
                Ui.i().drawUi(67, this.mapdataMap[var3][0] * var1 + this.mapoffx + (var5 >> 1), this.mapdataMap[var3][1] * var2 + this.mapoffy + (var6 >> 1), 3, 0);
            }
        }

    }

    private void drawMapRect(Graphics var1) {
        byte var2 = 0;
        var1.setColor(0);

        for(; var2 < this.gr.mapRect.length; ++var2) {
            if (!Ms.i().isRect(this.my.x, this.my.y, 19, 19, this.gr.mapRect[var2][0] * 20, this.gr.mapRect[var2][1] * 20, (this.gr.mapRect[var2][2] - this.gr.mapRect[var2][0] + 1) * 20, (this.gr.mapRect[var2][3] - this.gr.mapRect[var2][1] + 1) * 20)) {
                for(byte var3 = 4; var3 < this.gr.mapRect[var2].length; var3 = (byte)(var3 + 4)) {
                    var1.fillRect(this.map_x + this.gr.mapRect[var2][var3] * 20, this.map_y + this.gr.mapRect[var2][var3 + 1] * 20, (this.gr.mapRect[var2][var3 + 2] - this.gr.mapRect[var2][var3] + 1) * 20, (this.gr.mapRect[var2][var3 + 3] - this.gr.mapRect[var2][var3 + 1] + 1) * 20);
                }
            }
        }

    }

    private void drawMiniMap() {
        GameRun.mc.keyxx = MainCanvas.mainxx;
        GameRun.mc.keyyy = MainCanvas.mainyy;
        Ui.i().fillRectB();
        Ui.i().drawK2(1, 2, 640 - 2, 360 - 2, 0);
        Ui.i().drawK1(6, 33, 640 - 12, 360 - 29 * 3 - 15, 1);
        Ui.i().drawK1(6, 360 - 6 - 29 * 2, 640 - 12, 29 * 2, 2);
        Ui.i().drawYesNo(false, true);
        Ui.i().drawString("游戏地图", 320, 4, 17, 1, 2);
        if (this.showArea == -1) {
            Ui.i().drawString("该区域没有地图！", 320, 360 - 4 - 29 * 2, 16 | 1, 3, 0);
        } else {
            this.gr.showStringM("人物当前位置：" + this.gr.getNameCity(this.myMiniMap), 320, 360 - 4 - 29 * 2, 10, 3);
            g.setClip(6, 33, 640 - 12, 360 - 15 - 29 * 3);
            byte var3 = 0;
            int var4 = this.mapdataMap[this.selectMap][0];
            int var2;
            if (this.miniMapMode) {
                var2 = this.mapdataMap[this.selectMap][6] * 18 / 2;
            } else {
                var2 = 25;
            }

            this.mapoffx = Ms.i().mathSpeedN(this.mapoffx, 320 - var4 * 18 - var2, 10, false);
            var4 = this.littleMapClipY / 2;
            byte var5 = this.mapdataMap[this.selectMap][1];
            if (this.miniMapMode) {
                var2 = this.mapdataMap[this.selectMap][7] * 12 / 2;
            } else {
                var2 = 15;
            }

            this.mapoffy = Ms.i().mathSpeedN(this.mapoffy, var4 - var5 * 12 - var2, 10, false);

            for(byte var6 = var3; var6 < this.mapdataArea[this.showArea].length; ++var6) {
                byte var1 = this.mapdataArea[this.showArea][var6];
                if (var1 >= 0 && this.mapdataMap[var1].length > 0) {
                    if (this.pkey.isSelect(this.mapdataMap[var1][0] * 18 + this.mapoffx, this.mapdataMap[var1][1] * 12 + this.mapoffy, 18 * 6, 12 * 6)) {
                        this.selectMap = var1;
                    }

                    if (this.miniMapMode || var1 != this.myMiniMap) {
                        this.drawMapRect((byte)18, (byte)12, var1, false);
                    }
                }
            }

            if (!this.miniMapMode) {
                this.drawMapRect((byte)18, (byte)12, this.myMiniMap, false);
            }

            this.drawMapRect((byte)18, (byte)12, this.selectMap, true);
            g.setClip(0, 0, 640, 360);
        }

    }

    private void drawMission() {
        Ui.i().fillRectB();
        Ui.i().drawK2(1, 6, 640 - 2, 360 - 6, 0);
        Ui.i().drawK1(8, 41, 640 - 26, this.gr.line_max * 29 + 10, 1);
        Ui.i().drawK1(8, this.gr.line_max * 29 + 59, 640 - 16, 125, 2);
        byte var3 = this.gr.line_max;
        byte[] var4 = this.gr.select[0];
        int var2;
        if (this.gr.cur_a == 0) {
            var2 = this.bMission[14] + 1;
        } else {
            var2 = this.mDirect.length;
        }

        this.drawMisstionList(8, 41 + 6, 640 - 26, 29, var3, var4, var2);

        byte var8;
        for(var8 = 0; this.gr.about_a != null && var8 < this.gr.about_a.length; ++var8) {
            Ui.i().drawStringColor(this.gr.about_a[var8].toString(), 25, this.gr.line_max * 29 + 61 + var8 * 25, 3, 0);
        }

        byte var1 = this.pkey.selectMenuX(2, 0, 0, 320, 40);
        if (var1 != -1) {
            this.gr.cur_a = var1;
            this.goMission(this.gr.cur_a, this.bPause);
        }

        Ui var9 = Ui.i();
        if (this.gr.cur_a == 0) {
            var2 = 320 - 125;
        } else {
            var2 = 320 + 25;
        }

        var9.drawK1(var2, 9, 100, 29, 4);
        var9 = Ui.i();
        if (this.gr.cur_a == 0) {
            var8 = 0;
        } else {
            var8 = 1;
        }

        var9.drawString("主线任务", 320 - 75, 9, 17, var8, 0);
        var9 = Ui.i();
        if (this.gr.cur_a == 1) {
            var8 = 0;
        } else {
            var8 = 1;
        }

        var9.drawString("分支任务", 320 + 75, 9, 17, var8, 0);
        Ui.i().drawTriangle(320, 20, 150, true, true);
        Ui var5 = Ui.i();
        String var10;
        if (this.gr.cur_a == 0) {
            var10 = "主线完成度：";
        } else {
            var10 = "分支完成度：";
        }

        StringBuilder var7 = new StringBuilder(String.valueOf(var10));
        Ms var11 = Ms.i();
        byte[] var6 = this.bMission;
        if (this.gr.cur_a == 0) {
            var8 = 14;
        } else {
            var8 = 15;
        }

        var3 = var6[var8];
        if (this.gr.cur_a == 0) {
            var2 = this.sMission.length - 1;
        } else {
            var2 = this.sMission.length;
        }

        var5.drawString(var7.append(var11.getPrecision(var3 * 1000 / var2)).append("%").toString(), 320, 360 - 1, 33, -1, 1);
        Ui.i().drawYesNo(false, true);
    }

    private void drawMisstionList(int var1, int var2, int var3, int var4, int var5, byte[] var6, int var7) {
        byte var8 = var6[1];
        Ui.i().drawListKY(var5, var1, var2, var3, 6, var4, -1, var6[0] - var6[1], 4, 2);

        for(; var8 < var6[1] + var5; ++var8) {
            if (var8 < var7) {
                String var11;
                if (this.gr.cur_a == 0) {
                    var11 = var8 + 1 + "、" + this.sMission[var8][0].toString();
                } else {
                    var11 = var8 + 1 + "、" + this.sMission[this.mDirect[var8]][0].toString();
                }

                Log.e("sk", "drawMisstionList");
                Ui var12 = Ui.i();
                byte var10 = var6[1];
                byte var9;
                if (var8 < this.bMission[14]) {
                    var9 = -1;
                } else if (var6[0] == var8) {
                    var9 = 0;
                } else {
                    var9 = 3;
                }

                var12.drawString(var11, var1 + 8, (var8 - var10) * (var4 - 1) + var2, 0, var9, 0);
                if (this.gr.cur_a == 0 && var8 != var7 - 1) {
                    Ui var13 = Ui.i();
                    var10 = var6[1];
                    if (var8 < this.bMission[14]) {
                        var9 = -1;
                    } else if (var6[0] == var8) {
                        var9 = 0;
                    } else {
                        var9 = 3;
                    }

                    var13.drawString("完成", var1 + var3 - 8, var2 + (var8 - var10) * (var4 - 1), 24, var9, 0);
                }

                if (this.pkey.isSelect(0, (var8 - var6[1]) * (var4 - 1) + var2, 640, var4 - 1)) {
                    var6[0] = var8;
                    if (var8 - var6[1] == 0 && var6[1] > 0) {
                        --var6[1];
                    } else if (var8 - var6[1] == var5 - 1 && var6[1] + var5 < var7) {
                        ++var6[1];
                    }

                    if (this.gr.cur_a == 0) {
                        this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), 640 - 50, 0);
                    } else if (this.mDirect.length > 0) {
                        this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 640 - 50, 0);
                    }
                }
            }
        }

        Ui.i().sliding(var1 + var3 + 4, var2, var5 * var4, var6[0], var7, true);
    }

    private void drawMySave() {
        this.gr.showString("是否存盘?", 285, 0);
        Ui.i().drawYesNo(true, true);
    }

    private void drawNMAni(Npc[] var1) {
        if (var1 != null) {
            for(byte var2 = 0; var2 < this.npcList.length; ++var2) {
                byte var3 = this.npcList[var2];
                if (var3 == -1) {
                    if (this.my.other[4] == 1 || this.my.other[4] == 2) {
                        this.drawMyAni(this.my, 0, this.map_x + this.my.x + 10, this.map_y + this.my.y + 19, this.my.other[7]);
                    }
                } else if (var3 < -1) {
                    Ms.i();
                    byte var4 = (byte)(Ms.abs(var3) - 2);
                    if (this.isNpcSrc(this.item[var4][0] * 20, this.item[var4][1] * 20)) {
                        Ui var5 = Ui.i();
                        if (this.item[var4][2] == 2) {
                            var3 = 55;
                        } else {
                            var3 = 54;
                        }

                        var5.drawUi(var3, this.map_x + this.item[var4][0] * 20 + 10, this.map_y + this.item[var4][1] * 20 + 20, 33, 0);
                    }
                } else {
                    if ((var1[var3].other[4] == 1 || var1[var3].other[4] == 2) && this.isNpcSrc(var1[var3].x, var1[var3].y)) {
                        if (var1[var3].other[8] != 3 && !this.npcNameData[var3].equals("路人")) {
                            g.drawImage(this.imgShadow, this.map_x + var1[var3].x + 10, this.map_y + var1[var3].y + 20, 33);
                        }

                        this.drawNpcAniOne(var1, var3);
                    }

                    this.runNpcAniOne(var1, var3);
                }
            }
        }

    }

    private void drawNpcAni(Npc[] var1) {
        if (var1 != null) {
            for(byte var2 = 0; var2 < var1.length; ++var2) {
                if ((var1[var2].other[4] == 1 || var1[var2].other[4] == 2) && this.isNpcSrc(var1[var2].x, var1[var2].y)) {
                    this.drawNpcAniOne(var1, var2);
                }

                this.runNpcAniOne(var1, var2);
            }
        }

    }

    private void drawNpcAniOne(Npc[] var1, int var2) {
        short var6 = (byte)(var1[var2].other[3] - 1);
        int var7 = var1[var2].other[2];
        int var5 = var1[var2].other[7];
        short var4 = var1[var2].now_action;
        int var3 = var5;
        if (var5 < 0) {
            var1[var2].dir = 4;
            var3 = (byte)(-var5);
        }

        if (var1[var2].now_action >= npcSp[var6][var7].aLength(var3)) {
            Npc var8 = var1[var2];
            var5 = 0;
            var8.now_action = 0;
            if (var1[var2].other[8] == -4) {
                var1[var2].other[8] = 0;
                var1[var2].other[4] = 0;
                return;
            }

            var4 = (short)var5;
            if (!var1[var2].bdir) {
                var4 = (short)var5;
                if (this.setlastA(var1, var2)) {
                    this.drawNpcAniOne(var1, var2);
                    return;
                }
            }
        }

        Ui var11 = Ui.i();
        Sprite var9 = npcSp[var6][var7];
        var5 = npcSp[var6][var7].action(var3, var4, 0);
        var3 = this.map_x;
        var4 = var1[var2].x;
        var7 = this.map_y;
        var6 = var1[var2].y;
        byte var10;
        if (var1[var2].dir == 4) {
            var10 = 1;
        } else {
            var10 = 0;
        }

        var11.drawFrameOne(var9, var5, var3 + var4 + 10, var7 + var6 + 19, var10);
    }

    private void drawNpcFace(int var1, int var2, int var3) {
        if (this.imgFace != null) {
            Ui.i().drawImage(this.imgFace, this.face_c + var1, var2, var3);
        }

        this.face_c = Ms.i().mathSpeedN(this.face_c, 0, 20, false);
    }

    private void drawSrcEffect() {
        boolean var4 = false;
        int var1 = Constants_H.WIDTH__;
        int var2 = Constants_H.HEIGHT__;
        int var3;
        if (this.srcFlash_c > 0) {
            var3 = this.srcFlash_c;
            this.srcFlash_c = (byte)(var3 - 1);
            if (var3 % 2 == 0) {
                Ui.i().fillRect(16777215, 0, 0, var1, var2);
            }
        }

        if (this.bSrc) {
            var3 = Constants_H.SRC_BATTLE_H__;
            g.setColor(0);
            g.fillRect(0, this.black_width - var3 - this.bSrc_c, var1, var3);
            g.fillRect(0, var2 - this.black_width + this.bSrc_c, var1, var3);
        }

        if (this.my.state == 22) {
            Graphics var5 = g;
            if (this.eventGoing == 2) {
                var1 = var2 - this.gr.about_d.length * 29 >> 1;
            } else {
                var1 = 45;
            }

            if (this.eventGoing == 2) {
                var4 = true;
            }

            this.drawBlackSRC(var5, var1, var4);
        }

    }

    private void drawStep(Graphics var1, int var2, int var3, int var4) {
        if (this.bStep > 0) {
            var1.setColor(3947323);
            var1.drawRect(var2 + 1, var3, var4 - 2, var4);
            var1.drawRect(var2, var3 + 1, var4, var4 - 2);
            var1.setColor(13421772);
            var1.drawRect(var2 + 2, var3 + 1, var4 - 4, var4 - 2);
            var1.drawRect(var2 + 1, var3 + 2, var4 - 2, var4 - 4);
            Ui.i().fillRect(16777215, var2 + 2, var3 + 2, var4 - 3, var4 - 3);
            Ui.i().drawUi(67, (var4 >> 1) + var2, (var4 >> 1) + var3, 2 | 1, 0);
            if (this.bStep % 12 < 6) {
                Ui.i().drawLine(15597568, var2 + var4 - 1, var3, var2, var3 + var4 - 1);
                Ui.i().drawLine(0, var2 + var4, var3, var2, var3 + var4);
                Ui.i().drawLine(15597568, var2 + var4, var3 + 1, var2 + 1, var3 + var4);
            }

            byte var5 = (byte)(this.bStep - 1);
            this.bStep = var5;
            if (var5 < 2) {
                this.bStep = 100;
            }
        }

    }

    private void exitBoss(int var1, int var2, int var3, int var4) {
        this.chuansong(var1, 0);
        this.bExitBoss = true;
        this.my.setXY(var2, var3, 0, 0);
        this.my.dir = (byte)var4;
    }

    private void getInMap(byte var1, byte[][] var2) {
        this.my.dir = (byte)((var2[var1][2] - 1) / 2 * 2 + 1 + var2[var1][2] % 2);
        this.my.setXY(var2[var1][0], var2[var1][1], 0, 0);
    }

    private void getItem() {
        if (this.item[this.get_meet][2] == 2) {
            this.gr.say("这个宝箱是空的。", 0);
        } else {
            byte var1 = (byte)(this.item[this.get_meet][3] - 2);
            GameRun var2;
            if (var1 == -2) {
                var2 = this.gr;
                var2.money += this.item[this.get_meet][4] * 100;
                this.gr.say("获得金钱：" + this.item[this.get_meet][4] * 100 + "金", 0);
            } else if (var1 == -1) {
                var2 = this.gr;
                var2.coin += this.item[this.get_meet][4];
                this.gr.say("获得徽章：" + this.item[this.get_meet][4] + "徽章", 0);
            } else {
                this.gr.getItem(var1, this.item[this.get_meet][4]);
            }

            this.item[this.get_meet][2] = 2;
        }

    }

    private void getItemData(ByteArrayOutputStream param1, byte[][] param2) {
        // $FF: Couldn't be decompiled
    }

    private void getNpcData(ByteArrayOutputStream var1, Npc[] var2) {
        int var3 = 0;

        while(true) {
            try {
                if (var3 >= var2.length) {
                    break;
                }

                if (var2[var3].other[9] == 1) {
                    var1.write(var2[var3].other);
                }
            } catch (Exception var4) {
                var4.printStackTrace();
                break;
            }

            ++var3;
        }

    }

    private byte[] getNpcData() {
        ByteArrayOutputStream var1 = new ByteArrayOutputStream();
        this.getNpcData(var1, this.npc[0]);
        this.getNpcData(var1, this.npc[1]);
        this.getNpcData(var1, this.npc[2]);
        this.getItemData(var1, this.item);
        this.getItemData(var1, this.door);
        return var1.toByteArray();
    }

    private byte getNpcId(int var1) {
        return (byte)(this.npcPos[var1] & 63);
    }

    private byte getNpcLayer(int var1) {
        return (byte)((this.npcPos[var1] & 255) >> 6);
    }

    private short getNpcListY(int var1) {
        short var2;
        if (this.npcList[var1] == -1) {
            var2 = (short)(this.my.y + this.dir_select[this.my.dir][1] * this.my.speed);
        } else if (this.npcList[var1] < -1) {
            byte[][] var3 = this.item;
            Ms.i();
            var2 = (short)(var3[Ms.abs(this.npcList[var1]) - 2][1] * 20);
        } else {
            var2 = this.npc[0][this.npcList[var1]].y;
        }

        return var2;
    }

    private void ifEvent(int var1, int var2, int var3, int var4, boolean var5) {
        if (this.setSIfElse(var4, var5, true)) {
            short[] var6 = this.event_now;
            var6[var1] = (short)(var6[var1] + var2);
            this.nextEvent(var3);
        } else if (this.setSIfElse(var4, var5, false)) {
            this.setEventNow(var1, false);
        }

    }

    private void init() {
        this.initBrowImage();
        this.initWalkIco();
        this.initHudong();
        this.configureNpc();
        if (npcSp[1][0] == null) {
            npcSp[1][0] = new Sprite();
            this.my = new Npc(8);
            this.my.other[4] = 1;
            this.setAnole();
        }

        if (this.imgShadow == null) {
            this.imgShadow = Ms.i().createImage("data/shadow");
        }

    }

    private boolean initAuto(Npc var1, int var2) {
        boolean var3;
        if (var1.timeMove == 0) {
            if (var1.frame_c != -1) {
                var3 = false;
                return var3;
            }

            Ms.i();
            if (Ms.getRandom(100) < 50) {
                var3 = true;
            } else {
                var3 = false;
            }

            var1.b_auto = var3;
            Ms.i();
            if (Ms.getRandom(100) < 50) {
                Ms.i();
                var1.timeMove = (byte)(-(Ms.getRandom(var2) + 20));
                var1.setActionNo(false);
                var3 = false;
                return var3;
            }
        } else if (var1.timeMove < 0) {
            ++var1.timeMove;
            var3 = false;
            return var3;
        }

        var3 = true;
        return var3;
    }

    private void initBoat(int var1) {
        this.my.state = 9;
        this.anole_type = 5;
        this.setAnole();
        this.boatSelect = (byte)var1;
        this.gr.cur_a = 0;
        this.my.setIXY(this.boatCourse[this.boatSelect][this.gr.cur_a], this.boatCourse[this.boatSelect][this.gr.cur_a + 1]);
    }

    private void initCloud() {
        if (this.mapNo != 24 && this.mapNo != 25 && this.mapNo != 26 && this.mapNo != 49 && this.mapNo != 50) {
            this.cloud = null;
            this.imgCloud = null;
        } else {
            if (this.imgCloud == null) {
                this.imgCloud = Ms.i().createImage("data/cloud");
                this.cloud = null;
                this.cloud = new short[4][3];
            }

            for(byte var1 = 0; var1 < this.cloud.length; ++var1) {
                this.addCloud(var1);
            }
        }

    }

    private void initHudong() {
        this.hudong = Ms.i().createImage("data/brow/hudong");
    }

    private void initMissionList() {
        byte[] var1 = Ms.i().rmsOptions(7, (byte[])null, 1);
        if (var1[0] == -1) {
            this.bMission = null;
        } else {
            this.bMission = var1;
        }

        var1 = (byte[])null;
        if (this.bMission == null) {
            this.bMission = new byte[20];
        }

        Ms.i();
        Ms.skip = 0;
        var1 = Ms.i().getStream("data/mission0.t", -1);
        this.sMission = Ms.i().createString2Array(var1);
        this.smissionLength = this.sMission.length - 1;
        this.sMission = null;
    }

    private void initMoveMy() {
        this.my.frame_c = this.my.frame_num;
        this.my.setActionNo(true);
        if (this.my.state == 0 && this.gr.monPro.length > 0) {
            this.meetGrass();
        }

    }

    private void initNpcAni_1(int var1, int var2, byte[] var3) {
        --var1;

        for(; var1 > 0; --var1) {
            if (var3[var1] != 0) {
                if (npcSp[var2][var1] == null) {
                    this.initNpcAniOne("" + var1, var1, var2);
                }
            } else {
                npcSp[var2][var1] = null;
            }
        }

    }

    private boolean isAnole(int var1, int var2, int var3) {
        boolean var6;
        byte var7;
        if (var3 == 0) {
            var7 = 3;
        } else if (var3 == 2) {
            var7 = 4;
        } else {
            if (var3 != 4) {
                var6 = false;
                return var6;
            }

            var7 = 2;
        }

        byte var4 = 0;
        if (var1 % 20 != 0) {
            var4 = (byte)(0 + 1);
        }

        byte var5 = var4;
        if (var2 % 20 != 0) {
            var5 = (byte)(var4 + 1);
        }

        var4 = (byte)(1 << var5);
        if (var4 == 4 && this.worldData[(var1 + 19) / 20][var2 / 20] == var7) {
            var6 = true;
        } else {
            if (var4 > 1) {
                if (var1 % 20 != 0 && this.worldData[(var1 + 19) / 20][(var2 + 19) / 20] == var7) {
                    var6 = true;
                    return var6;
                }

                if (var2 % 20 != 0 && this.worldData[var1 / 20][var2 / 20] == var7) {
                    var6 = true;
                    return var6;
                }
            }

            if (this.worldData[var1 / 20][var2 / 20] == var7) {
                var6 = true;
            } else {
                var6 = false;
            }
        }

        return var6;
    }

    private boolean isAnoleType(int var1) {
        boolean var2;
        if ((this.gr.rmsOther[2] & 1 << var1) != 0) {
            var2 = true;
        } else {
            var2 = false;
        }

        return var2;
    }

    private boolean isAuto_canMove(Npc var1, int var2, int var3) {
        boolean var4;
        if (this.checkWorld(var1.x, var1.y, var2, var3, false) != 1 && !Ms.i().isRect(var1.x + var2, var1.y + var3, 19, 19, this.my.x, this.my.y, 19, 19)) {
            var4 = true;
        } else {
            var4 = false;
        }

        return var4;
    }

    private boolean isCan_not_pass(int var1, int var2) {
        boolean var3;
        if (this.worldData[var1][var2] == 1) {
            var3 = true;
        } else if (this.anole_type == 0) {
            if (this.worldData[var1][var2] != 2 && this.worldData[var1][var2] != 4) {
                var3 = false;
            } else {
                var3 = true;
            }
        } else if (this.anole_type == 2) {
            if (this.worldData[var1][var2] != 3 && this.worldData[var1][var2] != 2) {
                var3 = false;
            } else {
                var3 = true;
            }
        } else if (this.anole_type == 4) {
            if (this.worldData[var1][var2] != 2) {
                var3 = true;
            } else {
                var3 = false;
            }
        } else if (this.worldData[var1][var2] != 2 && this.worldData[var1][var2] != 3 && this.worldData[var1][var2] != 4) {
            var3 = false;
        } else {
            var3 = true;
        }

        return var3;
    }

    private boolean isCheckAnole(int var1) {
        boolean var2;
        if (this.anole_type != var1 && this.isAnoleType(var1)) {
            this.anole_type = (byte)var1;
            this.setAnole();
            var2 = true;
        } else {
            if (!this.isAnoleType(var1)) {
                this.gr.say("没有" + this.gr.monsterT[var1] + "坐骑" + "，不能通过该地形", -1);
            }

            var2 = false;
        }

        return var2;
    }

    private boolean isCheckNpcOff() {
        boolean var2;
        if (this.checkNpcT < 0) {
            var2 = false;
        } else {
            byte var1;
            if (this.my.speed_x != 0) {
                Ms.i();
                var1 = (byte)(20 - Ms.abs(this.my.y - this.npc[0][this.checkNpcT].y));
                if (var1 > 0 && var1 < 11) {
                    var2 = true;
                    return var2;
                }
            } else if (this.my.speed_y != 0) {
                Ms.i();
                var1 = (byte)(20 - Ms.abs(this.my.x - this.npc[0][this.checkNpcT].x));
                if (var1 > 0 && var1 < 11) {
                    var2 = true;
                    return var2;
                }
            }

            var2 = false;
        }

        return var2;
    }

    private byte isMapChenk(byte var1) {
        int var3 = 0;
        int var2 = 0;
        byte var5 = (byte)(this.my.x / 20);
        byte var4 = (byte)(this.my.y / 20);
        byte var7;
        if (this.my.speed_x == 0) {
            if (this.my.x % 20 != 0) {
                var2 = 0;
            } else {
                var2 = 1;
            }

            if (this.my.speed_y >= 0) {
                var3 = 1;
            } else {
                var3 = -1;
            }

            var3 = this.checkMap((var5 - var2) * 20, (var3 + var4) * 20, 0, 0);
            if (this.my.speed_y >= 0) {
                var7 = 1;
            } else {
                var7 = -1;
            }

            var2 = this.checkMap((var5 + 1) * 20, (var7 + var4) * 20, 0, 0);
        } else if (this.my.speed_y == 0) {
            if (this.my.speed_x >= 0) {
                var7 = 1;
            } else {
                var7 = -1;
            }

            if (this.my.y % 20 != 0) {
                var3 = 0;
            } else {
                var3 = 1;
            }

            var3 = this.checkMap((var7 + var5) * 20, (var4 - var3) * 20, 0, 0);
            if (this.my.speed_x >= 0) {
                var7 = 1;
            } else {
                var7 = -1;
            }

            var2 = this.checkMap((var7 + var5) * 20, (var4 + 1) * 20, 0, 0);
        }

        if (var3 != 1 || var2 != 1) {
            if (var3 == 0) {
                if (this.my.speed_x == 0) {
                    if (this.my.x % 20 != 0) {
                        var3 = 0;
                    } else {
                        var3 = 1;
                    }

                    var3 = var5 - var3;
                } else {
                    var3 = var5;
                }

                int var6;
                if (this.my.speed_y == 0) {
                    if (this.my.y % 20 != 0) {
                        var6 = 0;
                    } else {
                        var6 = 1;
                    }

                    var6 = var4 - var6;
                } else {
                    var6 = var4;
                }

                if (this.checkMap(var3 * 20, var6 * 20, 0, 0) == 0) {
                    var1 = -1;
                    return var1;
                }
            }

            if (var2 == 0) {
                if (this.my.speed_x == 0) {
                    if (this.my.x % 20 != 0) {
                        var2 = 0;
                    } else {
                        var2 = 1;
                    }

                    var2 += var5;
                } else {
                    var2 = var5;
                }

                if (this.my.speed_y == 0) {
                    byte var8;
                    if (this.my.y % 20 != 0) {
                        var8 = 0;
                    } else {
                        var8 = 1;
                    }

                    var3 = var8 + var4;
                } else {
                    var3 = var4;
                }

                if (this.checkMap(var2 * 20, var3 * 20, 0, 0) == 0) {
                    var1 = -2;
                }
            }
        }

        return var1;
    }

    private boolean isMapEvent(int var1, int var2) {
        boolean var3;
        if ((this.mapInfo[var1 * 2 + 1] & 1 << var2) != 0) {
            var3 = true;
        } else {
            var3 = false;
        }

        return var3;
    }

    private boolean isMission(int var1) {
        byte var2 = (byte)(var1 / 8);
        byte var4 = (byte)(var1 % 8);
        boolean var3;
        if ((this.bMission[var2] & 1 << var4) != 0) {
            var3 = true;
        } else {
            var3 = false;
        }

        return var3;
    }

    private boolean isNpcSrc(int var1, int var2) {
        boolean var3;
        if (this.map_x + var1 >= -80 && this.map_x + var1 <= Constants_H.WIDTH + 60 && this.map_y + var2 >= -80 && this.map_y + var2 <= Constants_H.HEIGHT + 60) {
            var3 = true;
        } else {
            var3 = false;
        }

        return var3;
    }

    private boolean isTrundleNpc(int var1, int var2) {
        byte var3 = this.checkIfNpc(this.npc[0], var1, var2);
        boolean var4;
        if (var3 != -1) {
            if (this.npc[0][var3].other[4] != 1 && this.npc[0][var3].other[4] != 3) {
                var4 = false;
            } else {
                var4 = true;
            }
        } else if (var1 >= 0 && var1 < this.cols && var2 >= 0 && var2 < this.rows && this.worldData[var1][var2] != 1) {
            var4 = false;
        } else {
            var4 = true;
        }

        return var4;
    }

    private void keyAnoleSel() {
        if (!Ms.i().key_delay()) {
            if (Ms.i().key_Left_Right()) {
                this.anoleSel = Ms.i().select(this.anoleSel, 0, 4);
            } else if (Ms.i().key_S1()) {
                if (!this.isAnoleType(this.anoleSel)) {
                    this.gr.say("还没有获得该骑宠", 0);
                } else if (this.anoleSel == 4) {
                    this.gr.say("只能在水里使用", 0);
                } else {
                    if (this.anole_type == this.anoleSel) {
                        this.anole_type = -1;
                    } else {
                        this.anole_type = this.anoleSel;
                    }

                    if (this.gr.rmsSms[6] == 10 && this.anole_type == 3 && this.gr.rmsSms[0] == 0) {
                        SMSSender.i(this.gr).go(1, true);
                        this.anole_type = -1;
                    } else {
                        if (this.anole_type == 3 && this.gr.rmsSms[0] == 0) {
                            this.gr.say("奇异兽不仅跑得快而且可以不遇敌，现提供试骑体验，正版验证后需购买！", -1);
                        }

                        this.gr.magic_id = 13;
                        this.gr.magic_x = this.map_x + this.my.x + 10;
                        this.gr.magic_y = this.map_y + this.my.y + 19;
                        this.gr.setMagic(this.gr.magic_id / 5);
                        this.my.state = 21;
                    }
                }

                Ms.i().keyRelease();
            } else if (Ms.i().key_S2() || Ms.i().key_Num9()) {
                this.my.state = 0;
                Ms.i().keyRelease();
            }
        }

    }

    private void keyMiniMap() {
        Ms.i().keyRelease();
        if (!Ms.i().key_S1_Num5()) {
            if (!Ms.i().key_S2() && !Ms.i().key_Num0()) {
                if ((Ms.i().key_Left_Right() || Ms.i().key_Up_Down()) && this.mapdataMap[this.selectMap].length >= 6 && this.mapdataMap[this.selectMap][Ms.abs(Ms.key) + 1] != -1) {
                    this.selectMap = this.mapdataMap[this.selectMap][Ms.abs(Ms.key) + 1];
                }
            } else {
                this.my.state = 0;
                this.mapdataArea = null;
                this.mapdataMap = null;
            }
        }

    }

    private void keyMission() {
        if (!Ms.i().key_delay()) {
            if (!Ms.i().key_Left_Right() && (!Ms.i().key_Num1() || this.gr.cur_a != 1) && (!Ms.i().key_Num3() || this.gr.cur_a != 0)) {
                if (Ms.i().key_Up_Down()) {
                    byte var3;
                    if (this.gr.cur_a == 0) {
                        int var1;
                        if (this.bMission[14] + 1 > this.sMission.length) {
                            var1 = this.sMission.length;
                        } else {
                            var1 = this.bMission[14] + 1;
                        }

                        var3 = (byte)var1;
                    } else {
                        var3 = (byte)this.mDirect.length;
                    }

                    Ms.i().selectS(this.gr.select[0], 0, var3, this.gr.line_max);
                    if (this.gr.cur_a == 0) {
                        this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), 640 - 50, 0);
                    } else if (this.mDirect.length > 0) {
                        this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 640 - 50, 0);
                    } else {
                        this.gr.about_a = null;
                    }
                } else if (Ms.i().key_S2() || Ms.i().key_Num1() || Ms.i().key_Num3()) {
                    this.my.state = 0;
                    if (this.bPause) {
                        this.gr.doPaint(0);
                        GameRun.run_state = 97;
                    } else {
                        GameRun.run_state = -10;
                    }

                    this.mDirect = null;
                    this.sMission = null;
                    this.gr.about_a = null;
                    Ms.i().keyRelease();
                }
            } else {
                GameRun var2 = this.gr;
                var2.cur_a = (byte)(var2.cur_a ^ 1);
                this.goMission(this.gr.cur_a, this.bPause);
            }
        }

    }

    private void keyMySave() {
        if (Ms.i().key_S1()) {
            this.my.state = 0;
            this.eventGoing = 2;
        } else if (Ms.i().key_S2()) {
            this.my.state = 0;
            this.eventGoing = 3;
        }

    }

    private void keySelectMenu() {
        if (!Ms.i().key_delay()) {
            if (Ms.i().key_S1_Num5()) {
                this.my.state = 13;
            } else if (Ms.i().key_Up_Down()) {
                this.gr.cur_a = Ms.i().select(this.gr.cur_a, 0, this.gr.action_str.length - 1);
            }
        }

    }

    private void loadMapData(int var1) {
        byte[] var12 = new byte[2];
        byte[] var13 = new byte[4];
        this.bottomData = null;
        this.frontData = null;
        this.worldData = null;

        byte[] var33;
        DataInputStream var14;
        boolean var10001;
        short var31;
        try {
            StringBuilder var15 = new StringBuilder("/data/map/");
            var14 = new DataInputStream(AndroidUtil.getResourceAsStream(var15.append(var1).append(".mid").toString()));
            var14.skip(2L);
            var14.read(var13);
            Ms.i();
            this.bgColor = (int)Ms.getNum(var13);
            var33 = new byte[var14.readByte()];
            var14.read(var33);
            var14.read(var33);
            Ms.i();
            this.cols = (byte)((int)Ms.getNum(var33));
            var14.read(var33);
            Ms.i();
            this.rows = (byte)((int)Ms.getNum(var33));
            short var3 = this.cols;
            var31 = this.rows;
            this.worldData = new short[var3][var31];
        } catch (Exception var28) {
            var10001 = false;
            return;
        }

        byte var32 = 0;

        while(true) {
            if (var32 >= 3) {
                try {
                    var14.close();
                    var12 = (byte[])null;
                    var12 = (byte[])null;
                    var12 = (byte[])null;
                } catch (Exception var17) {
                    var10001 = false;
                }
                break;
            }

            byte var6;
            try {
                var6 = var14.readByte();
            } catch (Exception var27) {
                var10001 = false;
                break;
            }

            if (var6 != -1) {
                int var5;
                try {
                    var14.read(var13);
                    Ms.i();
                    var5 = (int)Ms.getNum(var13) * 3;
                } catch (Exception var26) {
                    var10001 = false;
                    break;
                }

                switch (var6) {
                    case 1:
                        try {
                            this.bottomData = new short[var5];
                        } catch (Exception var25) {
                            var10001 = false;
                            return;
                        }
                    case 2:
                    default:
                        break;
                    case 3:
                        try {
                            this.frontData = new short[var5];
                        } catch (Exception var24) {
                            var10001 = false;
                            return;
                        }
                }

                var31 = 0;

                label123:
                while(true) {
                    short var2;
                    short var4;
                    short var7;
                    short[] var16;
                    label121:
                    while(true) {
                        if (var31 >= var5) {
                            break label123;
                        }

                        short var8;
                        try {
                            var14.read(var33);
                            Ms.i();
                            var4 = (short)((int)Ms.getNum(var33));
                            var14.read(var33);
                            long var10 = (long)(this.rows - 1);
                            Ms.i();
                            var8 = (short)((int)(var10 - Ms.getNum(var33)));
                            var14.read(var12);
                            Ms.i();
                            var7 = (short)((int)Ms.getNum(var12));
                        } catch (Exception var20) {
                            var10001 = false;
                            return;
                        }

                        short var9;
                        switch (var6) {
                            case 1:
                                try {
                                    var16 = this.bottomData;
                                } catch (Exception var19) {
                                    var10001 = false;
                                    return;
                                }

                                var9 = (short)(var31 + 1);
                                var2 = (short)var4;
                                var16[var31] = var2;

                                try {
                                    var16 = this.bottomData;
                                } catch (Exception var23) {
                                    var10001 = false;
                                    return;
                                }

                                var4 = (short)(var9 + 1);
                                var2 = (short)var8;
                                var16[var9] = var2;

                                try {
                                    var16 = this.bottomData;
                                } catch (Exception var30) {
                                    var10001 = false;
                                    return;
                                }

                                var31 = (short)(var4 + 1);
                                var2 = (short)var7;
                                var16[var4] = var2;
                                break;
                            case 2:
                                var31 = (short)(var31 + 3);

                                try {
                                    this.worldData[var4][var8] = (short)(var7 >> 3);
                                    break;
                                } catch (Exception var22) {
                                    var10001 = false;
                                    return;
                                }
                            case 3:
                                try {
                                    var16 = this.frontData;
                                } catch (Exception var18) {
                                    var10001 = false;
                                    return;
                                }

                                var9 = (short)(var31 + 1);
                                var2 = (short)var4;
                                var16[var31] = var2;

                                try {
                                    var16 = this.frontData;
                                } catch (Exception var21) {
                                    var10001 = false;
                                    return;
                                }

                                var4 = (short)(var9 + 1);
                                var2 = (short)var8;
                                var16[var9] = var2;

                                try {
                                    var16 = this.frontData;
                                    break label121;
                                } catch (Exception var29) {
                                    var10001 = false;
                                    return;
                                }
                        }
                    }

                    var31 = (short)(var4 + 1);
                    var2 = (short)var7;
                    var16[var4] = var2;
                }
            }

            ++var32;
        }

    }

    private void loadMapModuleAndImage() {
        Ms.i();
        Ms.skip = 0;
        byte[] var3 = Ms.i().getStream("data/map/area.dat", -1);
        byte[] var2 = Ms.i().createArray(var3);
        byte[][] var4 = Ms.i().create2Array(var3);
        var3 = (byte[])null;
        byte[][] var5;
        if (this.mapImg != null && var2[this.lastMap] == var2[this.mapNo]) {
            var2 = (byte[])null;
            var5 = (byte[][])null;
        } else {
            Ms.i();
            Ms.skip = 0;
            this.moduleData = Ms.i().createShort2Array(Ms.i().getStream("data/map/" + var2[this.mapNo] + ".data", -1), 1);
            this.mapImg = null;
            this.mapImg = new Image[var4[var2[this.mapNo]].length];

            for(byte var1 = 0; var1 < var4[var2[this.mapNo]].length; ++var1) {
                this.mapImg[var1] = Ms.i().createImage("data/map/" + var4[var2[this.mapNo]][var1]);
            }

            var2 = (byte[])null;
            var5 = (byte[][])null;
        }

    }

    private int map_set(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (var2 <= var3) {
            var1 = var5 - var6 * var2 >> 1;
        } else if (var1 + 1 <= var4) {
            var1 = 0;
        } else if (var1 >= var2 - var4) {
            var1 = var5 - var2 * var6;
        } else {
            var1 = var5 / 2 - var1 * var6 - var6 / 2;
        }

        return var1;
    }

    private void meetGrass() {
        if (this.meet_step < this.step_MEET) {
            if (this.worldData[this.my.getIx()][this.my.getIy()] != 7) {
                ++this.meet_step;
            }
        } else {
            if (this.gr.monPro.length > 1 && this.gr.immueEnemy == 0) {
                this.my.frame_c = 0;
                this.my.state = 8;
            }

            this.notMeet(0, 0);
        }

    }

    private void moveOff(byte var1, byte var2, int var3) {
        if (this.my.speed_x == 0) {
            this.my.dir = var1;
        } else if (this.my.speed_y == 0) {
            this.my.dir = var2;
        }

        Npc var5 = this.my;
        int var4;
        if (this.my.speed_x != 0) {
            var4 = 0;
        } else {
            var4 = var3;
        }

        var5.speed_x = (byte)var4;
        var5 = this.my;
        if (this.my.speed_y != 0) {
            var3 = 0;
        }

        var5.speed_y = (byte)var3;
        this.checkMoveOff(this.checkNpcT);
        this.initMoveMy();
    }

    private void nextEvent(int var1) {
        if ((var1 & 4096) != 0) {
            this.now_eV1 = 0;
            this.now_eV2 = 0;
        }

        if ((var1 & 256) != 0) {
            this.eventGoing = 0;
        }

        if ((var1 & 16) != 0) {
            this.event_state = 1;
        }

        if ((var1 & 1) != 0) {
            this.my.state = 0;
        }

        this.pkey.initPointer();
    }

    private void oneMove(Npc var1, int var2) {
        if (var1.frame_c > 0) {
            if (this.srcNpcNo == var2) {
                this.mapMove(var1.x, var1.y, var1.speed_x, var1.speed_y);
            }

            var1.x = (short)(var1.x + var1.speed_x);
            var1.y = (short)(var1.y + var1.speed_y);
            --var1.frame_c;
        } else if (var1.frame_c != -1) {
            var1.frame_c = -1;
            var1.setActionNo(false);
        }

    }

    private void runAutoMoveNpc(Npc var1, int var2) {
        if (this.my.state == 1 && this.get_meet == var2) {
            byte[] var4 = var1.other;
            Ms.i();
            int var3 = Ms.abs(var1.other[7]) / 3;
            if (this.my.dir < 4) {
                var2 = this.my.dir - 1;
            } else {
                var2 = this.my.dir - 2;
            }

            var4[7] = (byte)(var3 * 3 + var2);
            if (this.my.dir == 3) {
                var1.other[7] = (byte)(-var1.other[7]);
            } else {
                var1.dir = 3;
            }
        } else if (this.initAuto(var1, 10)) {
            if (var1.b_auto) {
                this.runAutoX(var1, this.gr.mapMove[(var1.other[8] - 5) * 2]);
            } else {
                this.runAutoY(var1, this.gr.mapMove[(var1.other[8] - 5) * 2 + 1]);
            }
        }

    }

    private void runAutoX(Npc var1, int var2) {
        if (var1.timeMove == 0) {
            Ms.i();
            byte var3;
            if (Ms.getRandom(100) < 50) {
                var3 = 3;
            } else {
                var3 = 4;
            }

            var1.dir = var3;
            short var4;
            if (var1.dir == 3) {
                var4 = (short)(var1.x - var1.other[0] * 20);
            } else {
                var4 = (short)((var1.other[0] + var2) * 20 - var1.x);
            }

            if (var4 <= 20) {
                var1.timeMove = (byte)(var4 / var1.speed);
            } else {
                Ms.i();
                var1.timeMove = (byte)(Ms.getRandom((var4 - 20) / var1.speed + 1) + 20 / var1.speed);
            }
        } else if (var1.timeMove > 0 && var1.frame_c < 1) {
            if (var1.dir == 3) {
                var2 = -var1.speed;
            } else {
                var2 = var1.speed;
            }

            if (this.isAuto_canMove(var1, var2, 0)) {
                if (var1.dir == 3) {
                    var2 = -var1.speed;
                } else {
                    var2 = var1.speed;
                }

                var1.setSpeedXY(var2, 0);
                --var1.timeMove;
                var1.frame_c = 1;
                var1.setActionNo(true);
            } else {
                var1.timeMove = -20;
                var1.frame_c = -1;
                var1.setActionNo(false);
            }
        }

    }

    private void runAutoY(Npc var1, int var2) {
        if (var1.timeMove == 0 && var1.frame_c == -1) {
            Ms.i();
            byte var3;
            if (Ms.getRandom(100) < 50) {
                var3 = 1;
            } else {
                var3 = 2;
            }

            var1.dir = var3;
            short var4;
            if (var1.dir == 1) {
                var4 = (short)(var1.y - var1.other[1] * 20);
            } else {
                var4 = (short)((var1.other[1] + var2) * 20 - var1.y);
            }

            if (var4 <= 20) {
                var1.timeMove = (byte)(var4 / var1.speed);
            } else {
                Ms.i();
                var1.timeMove = (byte)(Ms.getRandom((var4 - 20) / var1.speed + 1) + 20 / var1.speed);
            }
        } else if (var1.timeMove > 0 && var1.frame_c < 1) {
            if (var1.dir == 1) {
                var2 = -var1.speed;
            } else {
                var2 = var1.speed;
            }

            if (this.isAuto_canMove(var1, 0, var2)) {
                if (var1.dir == 1) {
                    var2 = -var1.speed;
                } else {
                    var2 = var1.speed;
                }

                var1.setSpeedXY(0, var2);
                --var1.timeMove;
                var1.frame_c = 1;
                var1.setActionNo(true);
            } else {
                var1.timeMove = -20;
                var1.frame_c = -1;
                var1.setActionNo(false);
            }
        }

    }

    private void runBoat() {
        if (this.boatSelect != -1 && this.my.ix == -1 && this.my.iy == -1) {
            this.my.state = 9;
            GameRun var2 = this.gr;
            byte var1 = (byte)(var2.cur_a + 2);
            var2.cur_a = var1;
            if (var1 >= this.boatCourse[this.boatSelect].length) {
                this.boatSelect = -1;
                this.my.state = 0;
                this.anole_type = -1;
                this.setAnole();
            } else {
                this.checkType = this.checkIfOther(this.door, this.my.x, this.my.y);
                if (this.checkType != -1) {
                    this.my.state = 5;
                    this.get_meet = this.checkType;
                }

                this.my.setIXY(this.boatCourse[this.boatSelect][this.gr.cur_a], this.boatCourse[this.boatSelect][this.gr.cur_a + 1]);
            }
        }

    }

    private void runEvent_brow(int var1) {
        int var2 = this.event[var1][this.event_now[var1] + 2] - 1;
        if (var2 == -1) {
            cur_npc = this.my;
        } else {
            cur_npc = this.npc[this.getNpcLayer(var2)][this.getNpcId(var2)];
        }

        if (this.event[var1][this.event_now[var1] + 4] == 0) {
            cur_npc.brow_type = this.event[var1][this.event_now[var1] + 3];
            cur_npc.brow_action = 0;
            cur_npc.brow_time = 0;
        } else if (this.event[var1][this.event_now[var1] + 4] == 1) {
            cur_npc.other[6] = this.event[var1][this.event_now[var1] + 3];
        } else if (this.event[var1][this.event_now[var1] + 4] == 2) {
            cur_npc.brow_type = -1;
            cur_npc.other[6] = 0;
        }

        short[] var3 = this.event_now;
        var3[var1] = (short)(var3[var1] + 5);
        this.nextEvent(4112);
    }

    private void runEvent_dialog(int var1) {
        this.checkNpcT = -1;
        if (this.eventGoing == 0) {
            this.eventGoing = 1;
            if (this.anole_type == 1) {
                this.setAnole();
            }

            int var2 = this.event[var1][this.event_now[var1] + 2] - 1;
            if (var2 == -1) {
                this.npcName = "塞其";
                this.now_eV2 = 0;
            } else {
                this.now_eV1 = this.getNpcLayer(var2);
                this.now_eV2 = this.getNpcId(var2);
                this.npcName = this.npcNameData[this.now_eV2];
                if (this.npcName.equals("路人")) {
                    this.npcName = null;
                }

                this.now_eV2 = this.npc[this.now_eV1][this.now_eV2].other[2];
            }

            this.initNpcFaceOne(this.npcName);
            Ms.i();
            Ms.font.setSize(22);
            this.dialog = Ms.i().groupString(Ms.i().getDialogs(this.event[var1], this.event_now[var1] + 5, this.event[var1][this.event_now[var1] + 4]), Constants_H.WIDTH__ - 20);
            if (!this.fontSizeControl) {
                Ms.i();
                Ms.font.setSize(26);
            }

            this.dialog_no = 0;
            this.my.state = 1;
            this.bDirTalk = false;
        } else if (this.eventGoing == 2) {
            short[] var3 = this.event_now;
            var3[var1] = (short)(var3[var1] + (this.event[var1][this.event_now[var1] + 4] << 1) + 5);
            this.nextEvent(4369);
        }

    }

    private void runEvent_getMon(int var1) {
        this.gmErr = false;
        if (this.gr.getMonster(this.event[var1][this.event_now[var1] + 2], this.event[var1][this.event_now[var1] + 3], this.event[var1][this.event_now[var1] + 4], -1) == -1) {
            this.gr.say("宠物空间已满，无法获得新的宠物，请整理寄存所空出一个空间。", -1);
            this.gmErr = true;
            this.gr.mini_state = 6;
            this.gr.view_state = 1;
            this.gr.goVIEW_MONSTER();
        } else {
            short[] var2 = this.event_now;
            var2[var1] = (short)(var2[var1] + this.event[var1][this.event_now[var1] + 1] + 2);
            this.nextEvent(4368);
        }

    }

    private void runEvent_goShop(int var1) {
        byte var2 = this.event[var1][this.event_now[var1] + 3];
        short[] var3;
        if (var2 == 4) {
            if (this.inShop == 0 && this.my.state != 16) {
                this.my.state = 16;
                this.inShop = 1;
                this.gr.setAction_str(new String[]{"回复", "不回复"});
                this.gr.popMenu = 0;
                this.gr.sell_money = 0;

                for(byte var4 = 0; var4 < this.gr.myMon_length; ++var4) {
                    GameRun var5 = this.gr;
                    var5.sell_money += this.gr.myMonsters[var4].monster[4] * 20 + 40;
                }
            } else if (this.my.state == 0) {
                if (this.inShop == 1 && this.gr.popMenu == 0) {
                    this.inShop = 2;
                    if (!this.gr.checkMonster() && this.gr.isMoney(this.gr.sell_money, true)) {
                        this.gr.healMonster(true);
                    }
                } else if (this.gr.say_c == 0) {
                    this.inShop = 0;
                    var3 = this.event_now;
                    var3[var1] = (short)(var3[var1] + 4);
                    this.nextEvent(0);
                }
            }
        } else {
            if (var2 < 3) {
                this.gr.goBUY_ITEM(this.event[var1][this.event_now[var1] + 2], var2);
            } else if (var2 == 3) {
                this.gr.goVIEW_COMPUTER(0);
            } else if (var2 == 5) {
                this.gr.goNidus(0);
            } else if (var2 == 6) {
                this.gr.view_state = 4;
                this.gr.popMenu = -1;
            } else if (var2 == 7) {
                this.gr.view_state = 1;
            }

            var3 = this.event_now;
            var3[var1] = (short)(var3[var1] + 4);
            this.nextEvent(16);
        }

    }

    private void runEvent_item_add_del(int var1) {
        byte var2 = 0;
        if (this.eventGoing == 0) {
            this.now_eV1 = this.event[var1][this.event_now[var1] + 2];
            this.now_eV2 = this.event[var1][this.event_now[var1] + 3];
            byte var5;
            if (this.event[var1][this.event_now[var1] + 3] >= 0) {
                var5 = this.gr.addItem(this.now_eV1, this.now_eV2);
            } else {
                var5 = this.gr.findItem(-2, this.now_eV1, true);
                Ms.i();
                if (var5 >= Ms.abs(this.now_eV2)) {
                    GameRun var3 = this.gr;
                    var5 = this.now_eV1;
                    Ms.i();
                    var3.deleteItems(var5, Ms.abs(this.now_eV2));
                    var5 = var2;
                } else {
                    var5 = -1;
                    this.gr.say("道具不足！", 0);
                }
            }

            if (var5 != -1) {
                GameRun var4 = this.gr;
                String var6;
                if (this.now_eV2 >= 0) {
                    var6 = "获得：";
                } else {
                    var6 = "失去：";
                }

                StringBuilder var7 = (new StringBuilder(String.valueOf(var6))).append(this.gr.getNameItem(this.now_eV1)).append("x");
                Ms.i();
                var4.say(var7.append(Ms.abs(this.now_eV2)).toString(), 0);
            }

            this.eventGoing = 1;
        } else if (this.gr.say_c == 0) {
            if (-1 == 0) {
                this.setEventNow(var1, true);
            } else {
                short[] var8 = this.event_now;
                var8[var1] = (short)(var8[var1] + 4);
                this.nextEvent(4368);
            }
        }

    }

    private void runEvent_miniGame_myLevel(int var1) {
        byte var2 = this.event[var1][this.event_now[var1] + 2];
        short[] var3;
        if (var2 > 1) {
            var3 = this.event_now;
            var3[var1] = (short)(var3[var1] + 3);
            this.nextEvent(4368);
        } else if (this.eventGoing < 2) {
            if (var2 == 0) {
                if (this.gr.magic_id == -2) {
                    if (this.gr.rmsOther[3] == 5) {
                        this.gr.magic_id = -2;
                        this.eventGoing = 2;
                        this.gr.say("您当前的训练师等级已达到上限！", 0);
                    } else {
                        this.gr.sell_money = this.gr.isMyLevel(true);
                        if (this.gr.sell_money == -1) {
                            this.my.state = 10;
                            this.gr.magic_id = 28;
                            this.gr.magic_x = this.map_x + this.my.x + 10;
                            this.gr.magic_y = this.map_y + this.my.y + 19;
                            this.gr.setMagic(this.gr.magic_id / 5);
                            this.gr.setMaxTakes(false);
                        } else {
                            this.eventGoing = 2;
                        }
                    }
                } else if (this.gr.magic_id == -1) {
                    this.gr.magic_id = -2;
                    this.eventGoing = 2;
                    this.gr.say("恭喜您的训练师等级已提升为#7" + this.gr.rmsOther[3] + "#0，您随身可携带宠物数量#7暴增到" + this.gr.max_takes + "#0，您商店能存放的宠物#7暴增到" + this.gr.max_monsters, -1);
                }
            } else if (var2 == 1) {
                if (this.eventGoing == 0 && this.gr.monInfoList[104] == 0) {
                    this.gr.sell_money = 0;
                    this.eventGoing = 3;
                    this.gr.say("此次您没有捕获到全新的宠物，捕获并不是唯一途径，有些宠物需要通过进化才能获得哦。", -1);
                } else if (this.eventGoing == 0) {
                    this.eventGoing = 3;
                    this.gr.sell_money = this.gr.monInfoList[104];
                    this.gr.monInfoList[104] = 0;
                    this.gr.say("此次您捕获了" + this.gr.sell_money + "个新宠物，这里是王国训练师机构奖励给您的" + this.gr.sell_money + "个徽章，希望再接再厉哦。", -1);
                    GameRun var4 = this.gr;
                    var4.coin += this.gr.sell_money;
                }
            }
        } else if (this.gr.say_c == 0) {
            if (this.eventGoing == 2) {
                if (this.gr.rmsOther[3] == 5) {
                    this.gr.say("您当前的训练师等级已达到上限！", 0);
                } else {
                    this.gr.sell_money = (byte)(this.gr.isMyLevel(false) - this.gr.monInfoList[103]);
                    if (this.gr.sell_money < 1) {
                        this.gr.sell_money = 0;
                    }

                    this.gr.say("当前训练师等级为#7" + this.gr.rmsOther[3] + "#0距离下次升级还需要捕捉#7" + this.gr.sell_money + "#0只不同的宠物，努力获得新宠吧。", -1);
                }

                this.eventGoing = 4;
            } else if (this.eventGoing == 3 && this.gr.sell_money > 0) {
                this.gr.say("获得：徽章x" + this.gr.sell_money, 0);
                this.eventGoing = 4;
            } else {
                var3 = this.event_now;
                var3[var1] = (short)(var3[var1] + 3);
                this.nextEvent(4368);
            }
        }

    }

    private void runEvent_select(int var1) {
        if (this.my.state != 12 && this.my.state != 13 && this.my.state != 14) {
            this.sEvent_eV2 = this.event[var1][this.event_now[var1] + 1];
            this.sEvent_eV1 = 0;
            this.gr.action_str = null;
            this.gr.action_str = new String[this.sEvent_eV2];

            for(byte var4 = 0; var4 < this.sEvent_eV2; ++var4) {
                this.gr.action_str[var4] = Ms.i().getDialogs(this.event[var1], this.event_now[var1] + 2 + this.sEvent_eV1 + 1, this.event[var1][this.event_now[var1] + 2 + this.sEvent_eV1]);
                this.sEvent_eV1 = (byte)(this.sEvent_eV1 + (this.event[var1][this.event_now[var1] + 2 + this.sEvent_eV1] << 1) + 1);
            }

            if (this.sIfElse != -1) {
                this.event_state = 1;
                this.gr.cur_a = this.sIfElse;
                this.my.state = 13;
                this.gr.action_str = null;
                this.sIfElse = -1;
            } else {
                this.gr.cur_a = 0;
                this.my.state = 12;
            }
        } else if (this.my.state == 13) {
            this.sEvent_eV1 = (byte)(this.sEvent_eV1 + 2);
            short var2 = (short)((this.event[var1][this.event_now[var1] + this.sEvent_eV1 + (this.gr.cur_a << 1)] & 255) << 8 | this.event[var1][this.event_now[var1] + this.sEvent_eV1 + (this.gr.cur_a << 1) + 1] & 255);
            short[] var3 = this.event_now;
            var3[var1] = (short)(var3[var1] + this.sEvent_eV1 + (this.sEvent_eV2 << 1) + var2);
            this.nextEvent(17);
        } else if (this.my.state == 14) {
            this.setEventNow(var1, true);
        }

    }

    private void runEvent_srcMove(int var1) {
        this.my.state = 10;
        int var3 = this.event[var1][this.event_now[var1] + 2] - 1;
        int var4;
        byte var6;
        if (var3 == -1) {
            var4 = this.my.getIx();
            var6 = this.my.getIy();
            this.srcNpcNo = -1;
        } else {
            this.now_eV1 = this.getNpcLayer(var3);
            this.now_eV2 = this.getNpcId(var3);
            byte var2;
            if (this.now_eV1 == 0) {
                var2 = this.now_eV2;
            } else {
                var2 = 0;
            }

            this.srcNpcNo = var2;
            var4 = this.npc[this.now_eV1][this.now_eV2].other[0];
            var6 = this.npc[this.now_eV1][this.now_eV2].other[1];
        }

        var4 = this.map_set(var4, this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20) - this.map_x;
        var3 = this.map_set(var6, this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20) - this.map_y;
        Ms.i();
        if (Ms.abs(var3) < 10) {
            Ms.i();
            if (Ms.abs(var4) < 10) {
                short[] var5 = this.event_now;
                var5[var1] = (short)(var5[var1] + 3);
                this.nextEvent(4112);
                return;
            }
        }

        Ms.i();
        if (Ms.abs(var4) >= 10) {
            var1 = this.map_x;
            Ms.i();
            this.map_x = var1 + var4 / Ms.abs(var4) * 10;
        }

        Ms.i();
        if (Ms.abs(var3) >= 10) {
            var1 = this.map_y;
            Ms.i();
            this.map_y = var1 + var3 / Ms.abs(var3) * 10;
        }

    }

    private void runMove() {
        if (this.my.ix == -1 && this.my.iy == -1) {
            this.runBoat();
        } else {
            this.runSeek(this.my, false);
        }

        this.oneMove(this.my, -1);

        for(byte var1 = 0; var1 < 3; var1 = (byte)(var1 + 2)) {
            for(byte var2 = 0; var2 < this.npc[var1].length; ++var2) {
                if (this.npc[var1][var2].other[4] == 1 || this.npc[var1][var2].other[4] == 2) {
                    if (this.npc[var1][var2].other[8] >= 5) {
                        this.runAutoMoveNpc(this.npc[var1][var2], var2);
                    } else if (this.npc[var1][var2].ix != -1 || this.npc[var1][var2].iy != -1) {
                        this.runSeek(this.npc[var1][var2], true);
                    }

                    this.oneMove(this.npc[var1][var2], var2);
                }
            }
        }

        this.insertNpc();
    }

    private void runNpcAniOne(Npc[] var1, int var2) {
        byte var5 = (byte)(var1[var2].other[3] - 1);
        byte var4 = var1[var2].other[2];
        Ms.i();
        byte var6 = (byte)Ms.abs(var1[var2].other[7]);
        if (var1[var2].now_action >= npcSp[var5][var4].aLength(var6)) {
            var1[var2].now_action = 0;
            this.setlastA(var1, var2);
        }

        Npc var7 = var1[var2];
        byte var3 = (byte)(var7.now_time + 1);
        var7.now_time = var3;
        if (var3 >= npcSp[var5][var4].action(var6, var1[var2].now_action, 1)) {
            var7 = var1[var2];
            ++var7.now_action;
            var1[var2].now_time = 0;
        }

    }

    private void runSeek(Npc var1, boolean var2) {
        boolean var7 = var1.b_check;
        short var5 = (short)(var1.ix * 20);
        short var6 = (short)(var1.iy * 20);
        byte var3;
        if (var1.x == var5 && var1.y == var6) {
            if (var1.frame_c == -1) {
                var1.iy = -1;
                var1.ix = -1;
                if (var2) {
                    var1.setIxIy_npc();
                } else {
                    var1.speed = this.getMySpeed();
                }

                if (var1.bdir) {
                    var1.other[7] = var1.lastAction;
                    if (var1.lastAction < 0) {
                        var3 = 4;
                    } else {
                        var3 = 3;
                    }

                    var1.dir = var3;
                    var1.setLastAction(false, 127);
                }
            }
        } else if (var1.frame_c < 1) {
            boolean var4;
            if (var7) {
                if (var1.x != var5) {
                    var4 = true;
                } else {
                    var4 = false;
                }
            } else if (var1.y == var6) {
                var4 = true;
            } else {
                var4 = false;
            }

            int var8;
            if (var4) {
                if (var1.x > var5 && var1.x - var1.speed < var5 || var1.x < var5 && var1.x + var1.speed > var5) {
                    var1.setSpeedXY(var5 - var1.x, 0);
                } else {
                    if (var1.x > var5) {
                        var8 = -var1.speed;
                    } else {
                        var8 = var1.speed;
                    }

                    var1.setSpeedXY(var8, 0);
                }

                if (!var1.bdir) {
                    if (var1.x > var5) {
                        var3 = 3;
                    } else {
                        var3 = 4;
                    }

                    var1.dir = var3;
                }
            } else {
                if ((var1.y <= var6 || var1.y - var1.speed >= var6) && (var1.y >= var6 || var1.y + var1.speed <= var6)) {
                    if (var1.y > var6) {
                        var8 = -var1.speed;
                    } else {
                        var8 = var1.speed;
                    }

                    var1.setSpeedXY(0, var8);
                } else {
                    var1.setSpeedXY(0, var6 - var1.y);
                }

                if (!var1.bdir) {
                    if (var1.y > var6) {
                        var3 = 1;
                    } else {
                        var3 = 2;
                    }

                    var1.dir = var3;
                }
            }

            var1.frame_c = var1.frame_num;
            var1.setActionNo(true);
        }

    }

    private void setEventNow(int var1, boolean var2) {
        if (var2) {
            this.my.state = 0;
        }

        this.now_eV1 = 0;
        this.now_eV2 = 0;
        this.eventGoing = 0;
        this.event_now[var1] = 0;
    }

    private void setMapData() {
        this.map_x = this.map_set(this.my.getIx(), this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20);
        this.map_y = this.map_set(this.my.getIy(), this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20);
        this.mapLeft_NOmove = (short)(Constants_H.WIDTH_H - 10);
        this.mapRight_NOmove = (short)(this.cols * 20 - Constants_H.WIDTH_H - 10);
        this.mapUp_NOmove = (short)(Constants_H.HEIGHT_H - 10);
        this.mapDown_NOmove = (short)(this.rows * 20 - Constants_H.HEIGHT_H - 10);
    }

    private void setMapOffer() {
        if (this.map_y + this.rows * 20 < Constants_H.HEIGHT && this.rows > Constants_H.YCELLS) {
            this.map_y = Constants_H.HEIGHT - this.rows * 20;
        } else if (this.map_y > 0 && this.rows > Constants_H.YCELLS) {
            this.map_y = 0;
        } else if (this.map_x > 0 && this.cols > Constants_H.XCELLS) {
            this.map_x = 0;
        } else if (this.map_x + this.cols * 20 < Constants_H.WIDTH && this.cols > Constants_H.XCELLS) {
            this.map_x = Constants_H.WIDTH - this.cols * 20;
        }

    }

    private void setMoveStop_m() {
        this.my.speed_x = 0;
        this.my.speed_y = 0;
        this.my.frame_c = -1;
        this.my.setActionNo(false);
    }

    private boolean setSIfElse(int var1, boolean var2, boolean var3) {
        if (var1 == 2) {
            byte var4;
            if (var2) {
                var4 = 0;
            } else {
                var4 = 1;
            }

            this.sIfElse = (byte)var4;
            var2 = true;
        } else if (var3 && var2) {
            var2 = true;
        } else if (!var3 && var1 == 1) {
            var2 = true;
        } else {
            var2 = false;
        }

        return var2;
    }

    private boolean setlastA(Npc[] var1, int var2) {
        boolean var3;
        if (var1[var2].lastAction != 127) {
            var1[var2].other[7] = var1[var2].lastAction;
            var1[var2].lastAction = 127;
            var3 = true;
        } else {
            var3 = false;
        }

        return var3;
    }

    private void turnAround(int var1) {
        this.my.dir = (byte)var1;
        this.my.setActionNo(true);
    }

    public void addAnole(int var1) {
        if (var1 == 13 || var1 == 34 || var1 == 49 || var1 == 66 || var1 == 82) {
            byte var3;
            if (var1 == 13) {
                var3 = 0;
            } else if (var1 == 34) {
                var3 = 1;
            } else if (var1 == 49) {
                var3 = 2;
            } else if (var1 == 66) {
                var3 = 3;
            } else {
                var3 = 4;
            }

            byte[] var2 = this.gr.rmsOther;
            var2[2] = (byte)(var2[2] | 1 << var3);
        }

    }

    public void bkEvent_getMon() {
        GameRun.run_state = -10;
    }

    public void bkgroundToPaint(short[] var1, Image[] var2, int var3, int var4, short[][] var5, Graphics var6, int var7, int var8, int var9, int var10, boolean var11) {
        if (var1 != null) {
            if (var11) {
                var6.setClip(var7, var8, var9 - var7, var10 - var8);
                var6.setColor(this.bgColor);
                var6.fillRect(var7, var8, var9 - var7, var10 - var8);
            }

            for(int var12 = 0; var12 < var1.length; var12 += 3) {
                if (var1[var12 + 2] >= 0) {
                    int var17 = var1[var12 + 2] >> 3;
                    short var13 = var1[var12 + 2];
                    int var16 = var1[var12] * 20 - var3;
                    int var15 = var1[var12 + 1] * 20 - (var4 - 20);
                    short var14;
                    if ((var13 & 3) % 2 == 1) {
                        var13 = var5[var17][4];
                        var14 = var5[var17][3];
                    } else {
                        var13 = var5[var17][3];
                        var14 = var5[var17][4];
                    }

                    if (var16 + var13 >= var7 && var16 <= var9 && var15 >= var8 && var15 - var14 <= var10) {
                        Ui.i().drawRegion(var2[var5[var17][0]], var5[var17][1], var5[var17][2], var5[var17][3], var5[var17][4], var16, var15, 4 | 32, var1[var12 + 2] & 7, var6);
                    }
                }
            }
        }

    }

    public void checkRegWhere0(int param1) {
        // $FF: Couldn't be decompiled
    }

    public byte checkSoftKey(int var1, int var2, int var3, int var4) {
        byte var5;
        if (var1 + var3 >= 0 && var1 + var3 < this.cols * 20 && var2 + var4 >= 0 && var2 + var4 < this.rows * 20) {
            var5 = this.checkIfNpc(this.npc[0], var1 + var3, var2 + var4);
            if (this.my.state == 0 && var5 != -1) {
                byte[] var6;
                if (this.anole_type == 1 && this.npc[0][var5].other[8] == 4) {
                    this.npc[0][var5].other[8] = -4;
                    var6 = this.npc[0][var5].other;
                    ++var6[7];
                    this.npc[0][var5].now_action = 0;
                    this.npc[0][var5].now_time = 0;
                } else if (this.npc[0][var5].other[8] != -4) {
                    this.my.state = 2;
                    this.get_meet = var5;
                    if (this.npc[0][var5].other[8] != 2 && this.npc[0][var5].other[8] != 3 && !this.npcNameData[var5].equals("路人")) {
                        this.bDirTalk = true;
                        this.npcDirTalk = this.npc[0][var5].other[7];
                        var6 = this.npc[0][var5].other;
                        Ms.i();
                        var2 = Ms.abs(this.npcDirTalk) / 3;
                        if (this.my.dir < 4) {
                            var1 = this.my.dir - 1;
                        } else {
                            var1 = this.my.dir - 2;
                        }

                        var6[7] = (byte)(var2 * 3 + var1);
                        if (this.my.dir == 3) {
                            this.npc[0][var5].other[7] = (byte)(-this.npc[0][var5].other[7]);
                        } else {
                            this.npc[0][var5].dir = 3;
                        }
                    } else {
                        this.bDirTalk = false;
                    }
                }

                var5 = 9;
            } else {
                var5 = this.checkIfOther(this.item, var1 + var3, var2 + var4);
                if (var5 != -1 && this.item[var5][2] != -1) {
                    Ms.i().keyRelease();
                    this.get_meet = var5;
                    this.getItem();
                    var5 = 0;
                } else {
                    var5 = -1;
                }
            }
        } else {
            var5 = 0;
        }

        return var5;
    }

    public void chuansong(int var1, int var2) {
        this.my.state = 5;
        this.mapNotemp = (byte)var1;
        this.go = (byte)var2;
        this.setMoveStop_m();
    }

    public void createEvent() {
        byte[] var5 = Ms.i().getStream("event", this.mapNo);
        if (var5.length == 1) {
            this.eventCount = 0;
        } else {
            this.eventCount = var5[0];
            byte var1;
            if (this.mapInfo[this.mapNo * 2] < 1) {
                this.event_now_list[this.mapNo] = null;
                this.event_now_list[this.mapNo] = new short[this.eventCount];
            } else {
                for(var1 = 0; var1 < this.eventCount; ++var1) {
                    if (this.isMapEvent(this.mapNo, var1)) {
                        this.event_now_list[this.mapNo][var1] = 24224;
                    }
                }
            }

            this.event_now = this.event_now_list[this.mapNo];
            this.event = new byte[this.eventCount][];
            var1 = 0;

            for(int var2 = 0 + 1; var1 < this.eventCount; ++var1) {
                int var3 = var2 + 1;
                byte var4 = var5[var2];
                var2 = var3 + 1;
                short var6 = (short)(var4 << 8 | var5[var3] & 255);
                this.event[var1] = new byte[var6];
                System.arraycopy(var5, var2, this.event[var1], 0, this.event[var1].length);
                var2 += var6;
            }
        }

    }

    byte[][] createItem(byte[] var1, byte[][] var2) {
        var2 = (byte[][])null;
        int var3;
        int var4;
        int var5;
        if (this.mapInfo[this.mapNo * 2] > 0) {
            var1 = this.mapTemp[this.mapNo];
            Ms.i();
            var3 = Ms.skip2++;
            var2 = new byte[var1[var3]][];

            for(var3 = 0; var3 < var2.length; ++var3) {
                Ms.i();
                var4 = Ms.skip2++;
                var2[var3] = new byte[var1[var4]];

                for(var4 = 0; var4 < var2[var3].length; ++var4) {
                    byte[] var6 = var2[var3];
                    Ms.i();
                    var5 = Ms.skip2++;
                    var6[var4] = var1[var5];
                }
            }
        } else {
            Ms.i();
            var3 = Ms.skip++;
            byte[][] var8 = new byte[var1[var3]][];
            var3 = 0;

            while(true) {
                var2 = var8;
                if (var3 >= var8.length) {
                    break;
                }

                Ms.i();
                var4 = Ms.skip++;
                var8[var3] = new byte[var1[var4]];

                for(var4 = 0; var4 < var8[var3].length; ++var4) {
                    byte[] var7 = var8[var3];
                    Ms.i();
                    var5 = Ms.skip++;
                    var7[var4] = var1[var5];
                }

                ++var3;
            }
        }

        return var2;
    }

    public void createLayer() {
        this.createMap();
        this.setMapData();
    }

    Npc[] createNpc(byte[] var1, Npc[] var2) {
        var2 = (Npc[])null;
        Ms.i();
        int var3 = Ms.skip++;
        var2 = new Npc[var1[var3]];

        int var4;
        int var5;
        byte[] var6;
        for(var3 = 0; var3 < var2.length; ++var3) {
            Ms.i();
            var4 = Ms.skip++;
            var2[var3] = new Npc(var1[var4]);

            for(var4 = 0; var4 < var2[var3].other.length; ++var4) {
                var6 = var2[var3].other;
                Ms.i();
                var5 = Ms.skip++;
                var6[var4] = var1[var5];
            }

            var2[var3].setXY_npc();
        }

        if (this.mapInfo[this.mapNo * 2] > 0) {
            for(var3 = 0; var3 < var2.length; ++var3) {
                if (var2[var3].other[9] == 1) {
                    for(var4 = 0; var4 < var2[var3].other.length; ++var4) {
                        var6 = var2[var3].other;
                        var1 = this.mapTemp[this.mapNo];
                        Ms.i();
                        var5 = Ms.skip2++;
                        var6[var4] = var1[var5];
                    }

                    var2[var3].setXY_npc();
                }
            }
        }

        return var2;
    }

    public byte[] createNpcPos(byte[] var1, byte[] var2) {
        var2 = (byte[])null;
        Ms.i();
        int var3 = Ms.skip++;
        var2 = new byte[var1[var3]];

        for(var3 = 0; var3 < var2.length; ++var3) {
            Ms.i();
            int var4 = Ms.skip++;
            var2[var3] = var1[var4];
        }

        return var2;
    }

    public void createNpcString() {
        this.npcNameData = Ms.i().loadText(this.initData(this.gr.createData(1), this.mapNo));
        this.npcStringData = Ms.i().loadText(this.initData(this.gr.createData(2), this.mapNo));
    }

    public void createOther() {
        byte[] var1 = (byte[])null;
        Ms.i();
        Ms.skip = 0;
        Ms.i();
        Ms.skip2 = 0;
        var1 = this.initData(this.gr.createData(0), this.mapNo);
        this.npcPos = this.createNpcPos(var1, this.npcPos);
        if (this.mapInfo[this.mapNo * 2] > 0 && this.mapTemp[this.mapNo] == null) {
            this.mapTemp[this.mapNo] = Ms.i().rmsOptions(this.mapNo + 14, (byte[])null, 1);
        }

        this.npc[0] = this.createNpc(var1, this.npc[0]);
        this.npc[1] = this.createNpc(var1, this.npc[1]);
        this.npc[2] = this.createNpc(var1, this.npc[2]);
        this.item = this.createItem(var1, this.item);
        this.door = this.createItem(var1, this.door);
        this.npcList = null;
        this.npcList = new byte[this.npc[0].length + 1 + this.item.length];
        var1 = (byte[])null;
        this.initNpcAni();
    }

    public void doKey() {
        switch (this.map_key) {
            case -57:
                Ms.i().keyRelease();
                if (this.gr.rmsOther[2] > 0) {
                    this.initAnoleValue();
                }
            case -55:
            default:
                break;
            case -53:
            case 5:
                if (this.gr.isTalk) {
                    this.checkSoftKey(this.my.x, this.my.y, this.dir_select[this.my.dir][0] * this.my.speed, this.dir_select[this.my.dir][1] * this.my.speed);
                }
                break;
            case -51:
                this.goMission(1, false);
                break;
            case -49:
                this.goMission(0, false);
                break;
            case -48:
                this.goMiniMap();
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                if (this.my.dir != this.map_key) {
                    this.turnAround(this.map_key);
                }

                this.canMove(this.dir_select[this.map_key][0] * this.my.speed, this.dir_select[this.map_key][1] * this.my.speed);
        }

    }

    public void drawBlackSRC(Graphics var1, int var2, boolean var3) {
        int var8 = Constants_H.WIDTH__;
        int var7 = Constants_H.HEIGHT__;
        int var9 = Constants_H.WIDTH__ / 2;
        var1.setColor(16777215);
        short var6 = 0;
        int var5;
        if (this.black_0 - 5 > 0) {
            var5 = this.black_0 - 5;
        } else {
            var5 = 0;
        }

        byte var10 = (byte)var5;
        short var11 = var6;
        if (this.gr.about_d != null) {
            while(true) {
                if (var3) {
                    if (var11 >= this.gr.about_d.length) {
                        break;
                    }
                } else if (var11 > this.black_0 || var11 >= this.gr.about_d.length) {
                    break;
                }

                if (!var3) {
                    if (this.black_0 == var11) {
                        var1.setClip(0, (var11 - var10) * 29 + var2, this.black_1 << 1, 25 + 4);
                    }

                    Ui.i().drawStringColor(this.gr.about_d[var11].toString(), 25, (var11 - var10) * 29 + var2, 0, 0);
                    var1.setClip(0, 0, var8, var7);
                } else {
                    var6 = (short)(Ms.i().getStringWidth(this.gr.about_d[var11].toString()) - this.gr.getSIndexW(this.gr.about_d[var11].toString()));
                    Ui.i().drawStringColor(this.gr.about_d[var11].toString(), var8 - var6 >> 1, var11 * 29 + var2 + 6, 0, 0);
                }

                ++var11;
            }

            if (!var3) {
                var1.setColor(0);
                var1.fillRect(0, 0, var8, 40);
                var1.fillRect(0, var7 - 40, var8, 40);
            }

            if (this.black_0 == this.gr.about_d.length) {
                this.gr.drawZero(var9, var7 - 25 - 4, 1 | 32, 0);
            } else {
                if (!var3) {
                    short var4 = (short)(this.black_1 + 10);
                    this.black_1 = var4;
                    if (var4 >= var9) {
                        this.black_1 = 0;
                        ++this.black_0;
                        return;
                    }
                }

                if (var3) {
                    this.black_0 = (byte)this.gr.about_d.length;
                }
            }
        }

    }

    void drawMap(Graphics var1) {
        short var5 = this.leftCol;
        short var3 = this.topRow;
        if (this.map_x >= 0) {
            this.leftCol = 0;
            this.map_left = this.map_x;
        } else {
            this.leftCol = (short)(-this.map_x / 20);
            this.map_left = this.map_x % 20;
        }

        if (this.map_y >= 0) {
            this.topRow = 0;
            this.map_top = this.map_y;
        } else {
            this.topRow = (short)(-this.map_y / 20);
            this.map_top = this.map_y % 20;
        }

        int var4 = this.leftCol * 20;
        int var2 = this.topRow * 20;
        if (this.firstDrawMap == 0) {
            this.firstDrawMap = 1;
            this.bkgroundToPaint(this.bottomData, this.mapImg, var4, var2, this.moduleData, var1, 0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
        } else if (this.leftCol != var5 || this.topRow != var3) {
            var1.setClip(0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT);
            var1.copyArea(0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, (var5 - this.leftCol) * 20, (var3 - this.topRow) * 20, 20);
            if (this.leftCol < var5) {
                this.bkgroundToPaint(this.bottomData, this.mapImg, var4, var2, this.moduleData, var1, 0, 0, (var5 - this.leftCol) * 20, Constants_H.OFF_HEIGHT, true);
            } else if (this.leftCol > var5) {
                this.bkgroundToPaint(this.bottomData, this.mapImg, var4, var2, this.moduleData, var1, Constants_H.OFF_WIDTH + (var5 - this.leftCol) * 20, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
            }

            if (this.topRow < var3) {
                this.bkgroundToPaint(this.bottomData, this.mapImg, var4, var2, this.moduleData, var1, 0, 0, Constants_H.OFF_WIDTH, (var3 - this.topRow) * 20, true);
            } else if (this.topRow > var3) {
                this.bkgroundToPaint(this.bottomData, this.mapImg, var4, var2, this.moduleData, var1, 0, Constants_H.OFF_HEIGHT + (var3 - this.topRow) * 20, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
            }
        }

        g.drawImage(GameRun.scrT, this.map_left, this.map_top, 20);
    }

    public void drawMyAni(Npc var1, int var2, int var3, int var4, int var5) {
        byte var8 = (byte)var2;
        if (var1.now_action >= npcSp[1][var8].aLength(var5)) {
            var1.now_action = 0;
        }

        if (this.anole_type != 2 && this.anole_type != 4) {
            Ui.i().drawImage(this.imgShadow, var3, var4, 33);
        }

        Ui var9 = Ui.i();
        Sprite var10 = npcSp[1][var8];
        int var7 = npcSp[1][var8].action(var5, var1.now_action, 0);
        byte var11;
        if (var1.dir == 4) {
            var11 = 1;
        } else {
            var11 = 0;
        }

        var9.drawFrameOne(var10, var7, var3, var4, var11);
        byte var6 = (byte)(var1.now_time + 1);
        var1.now_time = var6;
        if (var6 > npcSp[1][var8].action(var5, var1.now_action, 1)) {
            ++var1.now_action;
            var1.now_time = 0;
        }

    }

    public void eventCheck() {
        for(int var2 = 0; this.event != null && var2 < this.event.length; ++var2) {
            if (this.event[var2] != null && this.event_now[var2] < this.event[var2].length) {
                do {
                    this.event_state = 0;
                    int var3;
                    short[] var6;
                    if (this.event_now[var2] >= this.event[var2].length) {
                        var6 = this.mapInfo;
                        var3 = this.mapNo * 2 + 1;
                        var6[var3] = (short)(var6[var3] | 1 << var2);
                        break;
                    }

                    boolean var5;
                    byte var8;
                    byte[] var10;
                    switch (this.event[var2][this.event_now[var2]]) {
                        case 1:
                            var3 = this.event[var2][this.event_now[var2] + 2] - 1;
                            if (var3 == -1) {
                                break;
                            }

                            this.now_eV1 = this.getNpcLayer(var3);
                            this.now_eV2 = this.getNpcId(var3);
                            if (this.my.state == 2 && this.get_meet == this.now_eV2) {
                                var5 = true;
                            } else {
                                var5 = false;
                            }

                            this.ifEvent(var2, 4, 16, this.event[var2][this.event_now[var2] + 3], var5);
                            break;
                        case 2:
                            this.now_eV1 = this.event[var2][this.event_now[var2] + 2];
                            this.now_eV2 = this.event[var2][this.event_now[var2] + 3];
                            this.ifEvent(var2, 5, 4112, this.event[var2][this.event_now[var2] + 4], this.isMapEvent(this.now_eV1, this.now_eV2));
                            break;
                        case 3:
                            if (this.gr.money >= this.event[var2][this.event_now[var2] + 2] * 100) {
                                var5 = true;
                            } else {
                                var5 = false;
                            }

                            this.ifEvent(var2, 4, 16, this.event[var2][this.event_now[var2] + 3], var5);
                            break;
                        case 4:
                            if (this.gr.monInfoList[103] >= this.event[var2][this.event_now[var2] + 2]) {
                                var5 = true;
                            } else {
                                var5 = false;
                            }

                            this.ifEvent(var2, 4, 16, this.event[var2][this.event_now[var2] + 3], var5);
                            break;
                        case 5:
                            var8 = this.gr.findItem(-2, this.event[var2][this.event_now[var2] + 2], true);
                            if (this.event[var2][this.event_now[var2] + 3] == 0) {
                                if (var8 == 0) {
                                    var5 = true;
                                } else {
                                    var5 = false;
                                }
                            } else if (var8 >= this.event[var2][this.event_now[var2] + 3]) {
                                var5 = true;
                            } else {
                                var5 = false;
                            }

                            this.ifEvent(var2, 5, 16, this.event[var2][this.event_now[var2] + 4], var5);
                            break;
                        case 6:
                            var5 = Ms.i().isRect(this.my.x, this.my.y, 19, 19, this.event[var2][this.event_now[var2] + 2] * 20, this.event[var2][this.event_now[var2] + 3] * 20, (this.event[var2][this.event_now[var2] + 4] - this.event[var2][this.event_now[var2] + 2] + 1) * 20, (this.event[var2][this.event_now[var2] + 5] - this.event[var2][this.event_now[var2] + 3] + 1) * 20);
                            this.ifEvent(var2, 7, 16, this.event[var2][this.event_now[var2] + 6], var5);
                        case 7:
                        case 9:
                        case 10:
                        case 14:
                        case 20:
                        case 34:
                        default:
                            break;
                        case 8:
                            if (this.gr.findMonster(this.event[var2][this.event_now[var2] + 2], this.event[var2][this.event_now[var2] + 3]) != -1) {
                                var5 = true;
                            } else {
                                var5 = false;
                            }

                            this.ifEvent(var2, 5, 16, this.event[var2][this.event_now[var2] + 4], var5);
                            break;
                        case 11:
                            var3 = this.event[var2][this.event_now[var2] + 2] - 1;
                            this.now_eV1 = this.getNpcLayer(var3);
                            this.now_eV2 = this.getNpcId(var3);
                            if (this.npc[this.now_eV1][this.now_eV2].other[8] == this.event[var2][this.event_now[var2] + 3]) {
                                var6 = this.event_now;
                                var6[var2] = (short)(var6[var2] + 4);
                                this.nextEvent(16);
                            } else {
                                this.setEventNow(var2, false);
                            }
                            break;
                        case 12:
                            this.runEvent_select(var2);
                            break;
                        case 13:
                            if (this.eventGoing == 0) {
                                this.eventGoing = 1;
                                if (this.event[var2][this.event_now[var2] + 3] == 0) {
                                    this.bMission[14] = this.event[var2][this.event_now[var2] + 2];
                                    if (this.bMission[14] != -1) {
                                        this.gr.say("#4主线任务#0已更新，点击#7工具包内的主线按钮#0可查看任务表。", -1);
                                    }
                                } else {
                                    var8 = this.event[var2][this.event_now[var2] + 2];
                                    if (this.event[var2][this.event_now[var2] + 3] == 2) {
                                        var5 = true;
                                    } else {
                                        var5 = false;
                                    }

                                    this.setMission(var8, var5);
                                    if (this.event[var2][this.event_now[var2] + 3] == 2) {
                                        this.gr.say("#4分支任务#0已更新，点击#7工具包内的支线按钮#0可查看任务表。", -1);
                                    }
                                }
                            } else if (this.gr.say_c == 0) {
                                var6 = this.event_now;
                                var6[var2] = (short)(var6[var2] + 4);
                                this.nextEvent(272);
                            }
                            break;
                        case 15:
                            if (this.event[var2][this.event_now[var2] + 2] == 0) {
                                var5 = true;
                            } else {
                                var5 = false;
                            }

                            this.setEventNow(var2, var5);
                            break;
                        case 16:
                            this.runEvent_goShop(var2);
                            break;
                        case 17:
                            this.now_eV1 = this.event[var2][this.event_now[var2] + 2];
                            this.now_eV2 = this.event[var2][this.event_now[var2] + 3];
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 4);
                            this.setOverEvent(this.now_eV1, this.now_eV2);
                            this.nextEvent(4112);
                            break;
                        case 18:
                            this.runEvent_item_add_del(var2);
                            break;
                        case 19:
                            Ms.i();
                            Ms.skip = 0;
                            var10 = Ms.i().getStream("data/battle/boss.d", -1);
                            byte[][] var9 = Ms.i().create2Array(var10);
                            var10 = (byte[])null;
                            var3 = this.event[var2][this.event_now[var2] + 1] >> 1;
                            this.gr.enemyList = new byte[var3][5];

                            for(this.now_eV2 = 0; this.now_eV2 < var3; ++this.now_eV2) {
                                this.now_eV1 = this.event[var2][this.event_now[var2] + 2 + this.now_eV2 * 2];
                                this.gr.enemyList[this.now_eV2][0] = var9[this.now_eV1][0];
                                this.gr.enemyList[this.now_eV2][1] = this.event[var2][this.event_now[var2] + 3 + this.now_eV2 * 2];
                                this.gr.enemyList[this.now_eV2][2] = var9[this.now_eV1][1];
                                this.gr.enemyList[this.now_eV2][3] = var9[this.now_eV1][2];
                                this.gr.enemyList[this.now_eV2][4] = var9[this.now_eV1][3];
                            }

                            byte[][] var15 = (byte[][])null;
                            Sound.i().setMusicId(6);
                            Sound.i().setMusic(false);
                            this.gr.battleType(3);
                            this.gr.goBattle();
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + this.event[var2][this.event_now[var2] + 1] + 2);
                            break;
                        case 21:
                            if (this.eventGoing == 0) {
                                this.eventGoing = 1;
                                int var4 = this.event[var2][this.event_now[var2] + 2] * 100;
                                if (var4 < 0) {
                                    var3 = this.gr.money;
                                    Ms.i();
                                    if (var3 < Ms.abs(var4)) {
                                        this.gr.say("金钱不足！", 0);
                                        this.eventGoing = 2;
                                    }
                                }

                                if (this.eventGoing == 1) {
                                    GameRun var12 = this.gr;
                                    var12.money += var4;
                                    GameRun var7 = this.gr;
                                    String var13;
                                    if (var4 < 0) {
                                        var13 = "失去：";
                                    } else {
                                        var13 = "获得：";
                                    }

                                    StringBuilder var14 = new StringBuilder(String.valueOf(var13));
                                    Ms.i();
                                    var7.say(var14.append(Ms.abs(var4)).append("金").toString(), 0);
                                }
                            } else if (this.gr.say_c == 0) {
                                if (this.eventGoing == 2) {
                                    this.setEventNow(var2, true);
                                } else {
                                    var6 = this.event_now;
                                    var6[var2] = (short)(var6[var2] + 3);
                                    this.nextEvent(272);
                                }
                            }
                            break;
                        case 22:
                            this.exitBoss(this.event[var2][this.event_now[var2] + 2], this.event[var2][this.event_now[var2] + 3], this.event[var2][this.event_now[var2] + 4], this.event[var2][this.event_now[var2] + 5]);
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 6);
                            this.nextEvent(16);
                            break;
                        case 23:
                            this.now_eV1 = this.event[var2][this.event_now[var2] + 2];
                            this.now_eV2 = this.event[var2][this.event_now[var2] + 3];
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 4);
                            this.setRestEvent(this.now_eV1, this.now_eV2);
                            this.nextEvent(4112);
                            break;
                        case 24:
                            this.initBoat(this.event[var2][this.event_now[var2] + 2]);
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 3);
                            this.nextEvent(16);
                            break;
                        case 25:
                            this.gr.overMode = (byte)(this.event[var2][this.event_now[var2] + 2] + 1);
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 3);
                            break;
                        case 26:
                            this.runEvent_getMon(var2);
                            break;
                        case 27:
                            if (this.eventGoing == 0) {
                                this.now_eV2 = this.gr.findMonsterMinLv(this.event[var2][this.event_now[var2] + 2], this.event[var2][this.event_now[var2] + 3]);
                                if (this.now_eV2 != -1) {
                                    this.now_eV1 = this.gr.delMonster(this.now_eV2);
                                    this.eventGoing = 1;
                                } else {
                                    this.setEventNow(var2, false);
                                }
                            } else if (this.gr.say_c == 0) {
                                if (this.now_eV1 == -1) {
                                    this.setEventNow(var2, false);
                                } else {
                                    var6 = this.event_now;
                                    var6[var2] = (short)(var6[var2] + this.event[var2][this.event_now[var2] + 1] + 2);
                                    this.nextEvent(4368);
                                }
                            }
                            break;
                        case 28:
                            this.runEvent_dialog(var2);
                            break;
                        case 29:
                            var3 = this.event[var2][this.event_now[var2] + 2] - 1;
                            if (var3 == -1) {
                                cur_npc = this.my;
                            } else {
                                cur_npc = this.npc[this.getNpcLayer(var3)][this.getNpcId(var3)];
                            }

                            cur_npc.setLastAction(false, this.event[var2][this.event_now[var2] + 4]);
                            cur_npc.other[7] = this.event[var2][this.event_now[var2] + 3];
                            cur_npc.now_action = 0;
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 5);
                            this.nextEvent(4096);
                            break;
                        case 30:
                            this.my.state = 10;
                            var3 = this.event[var2][this.event_now[var2] + 2] - 1;
                            if (var3 == -1) {
                                cur_npc = this.my;
                            } else {
                                cur_npc = this.npc[this.getNpcLayer(var3)][this.getNpcId(var3)];
                            }

                            cur_npc.setIXY(this.event[var2][this.event_now[var2] + 3], this.event[var2][this.event_now[var2] + 4]);
                            cur_npc.speed = this.event[var2][this.event_now[var2] + 5];
                            Npc var11 = cur_npc;
                            if (this.event[var2][this.event_now[var2] + 6] == 0) {
                                var5 = true;
                            } else {
                                var5 = false;
                            }

                            var11.b_check = var5;
                            cur_npc.setLastAction(false, 127);
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 7);
                            this.nextEvent(16);
                            break;
                        case 31:
                            var3 = this.event[var2][this.event_now[var2] + 2] - 1;
                            if (var3 == -1) {
                                this.now_eV1 = this.event[var2][this.event_now[var2] + 3];
                                this.my.dir = this.now_eV1;
                                this.my.setActionNo(false);
                            } else {
                                this.now_eV1 = this.getNpcLayer(var3);
                                if (this.now_eV1 == 0) {
                                    this.now_eV2 = this.getNpcId(var3);
                                    this.npc[this.now_eV1][this.now_eV2].dir = this.event[var2][this.event_now[var2] + 3];
                                    this.npc[this.now_eV1][this.now_eV2].setActionNo(false);
                                }
                            }

                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 4);
                            this.nextEvent(4112);
                            break;
                        case 32:
                            this.runEvent_miniGame_myLevel(var2);
                            break;
                        case 33:
                            this.anole_type = (byte)(this.event[var2][this.event_now[var2] + 2] - 1);
                            this.setAnole();
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 3);
                            this.nextEvent(16);
                            break;
                        case 35:
                            var3 = this.event[var2][this.event_now[var2] + 2] - 1;
                            if (var3 == -1) {
                                this.my.other[4] = this.event[var2][this.event_now[var2] + 3];
                                switch (this.event[var2][this.event_now[var2] + 3]) {
                                    case 0:
                                    case 2:
                                        this.my.state = 0;
                                        break;
                                    case 1:
                                    case 3:
                                        this.my.state = 10;
                                }
                            } else {
                                this.now_eV1 = this.getNpcLayer(var3);
                                this.now_eV2 = this.getNpcId(var3);
                                this.npc[this.now_eV1][this.now_eV2].other[4] = this.event[var2][this.event_now[var2] + 3];
                            }

                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 4);
                            this.nextEvent(4112);
                            break;
                        case 36:
                            var3 = this.event[var2][this.event_now[var2] + 2] - 1;
                            this.now_eV1 = this.getNpcLayer(var3);
                            this.now_eV2 = this.getNpcId(var3);
                            this.npc[this.now_eV1][this.now_eV2].other[5] = (byte)(this.event[var2][this.event_now[var2] + 3] + 1);
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 4);
                            this.nextEvent(4112);
                            break;
                        case 37:
                            this.my.state = 10;
                            var3 = this.event[var2][this.event_now[var2] + 2] - 1;
                            if (var3 == -1) {
                                cur_npc = this.my;
                            } else {
                                cur_npc = this.npc[this.getNpcLayer(var3)][this.getNpcId(var3)];
                            }

                            cur_npc.setLastAction(true, this.event[var2][this.event_now[var2] + 6]);
                            cur_npc.setIXY(this.event[var2][this.event_now[var2] + 3], this.event[var2][this.event_now[var2] + 4]);
                            cur_npc.other[7] = this.event[var2][this.event_now[var2] + 5];
                            if (this.event[var2][this.event_now[var2] + 5] < 0) {
                                cur_npc.dir = 4;
                            }

                            cur_npc.speed = this.event[var2][this.event_now[var2] + 7];
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 8);
                            this.nextEvent(16);
                            break;
                        case 38:
                            this.runEvent_brow(var2);
                            break;
                        case 39:
                            this.now_eV1 = this.event[var2][this.event_now[var2] + 2];
                            this.now_eV2 = this.event[var2][this.event_now[var2] + 3];
                            if ((this.gr.rmsOther[this.now_eV1 * 2 + 4] & 1 << this.now_eV2) != 0) {
                                var6 = this.event_now;
                                var6[var2] = (short)(var6[var2] + 4);
                                this.nextEvent(4113);
                            }
                            break;
                        case 40:
                            var3 = this.event[var2][this.event_now[var2] + 2] - 1;
                            if (var3 == -1) {
                                var10 = this.my.other;
                                Ms.i();
                                var10[7] = (byte)Ms.abs(this.event[var2][this.event_now[var2] + 3]);
                                if (this.event[var2][this.event_now[var2] + 3] < 0) {
                                    this.my.dir = 4;
                                }
                            } else {
                                cur_npc = this.npc[this.getNpcLayer(var3)][this.getNpcId(var3)];
                                cur_npc.other[7] = this.event[var2][this.event_now[var2] + 3];
                                cur_npc.setNpcNum(npcSp[cur_npc.other[3] - 1][cur_npc.other[2]].aLength());
                            }

                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 4);
                            this.nextEvent(16);
                            break;
                        case 41:
                            var3 = this.event[var2][this.event_now[var2] + 2] - 1;
                            if (var3 == -1) {
                                this.my.setXY(this.event[var2][this.event_now[var2] + 3], this.event[var2][this.event_now[var2] + 4], 0, 0);
                                this.my.frame_c = -1;
                                if (this.srcNpcNo == -1) {
                                    this.map_x = this.map_set(this.event[var2][this.event_now[var2] + 3], this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20);
                                    this.map_y = this.map_set(this.event[var2][this.event_now[var2] + 4], this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20);
                                }
                            } else {
                                this.now_eV1 = this.getNpcLayer(var3);
                                this.now_eV2 = this.getNpcId(var3);
                                this.npc[this.now_eV1][this.now_eV2].other[0] = this.event[var2][this.event_now[var2] + 3];
                                this.npc[this.now_eV1][this.now_eV2].other[1] = this.event[var2][this.event_now[var2] + 4];
                                this.npc[this.now_eV1][this.now_eV2].setXY_npc();
                            }

                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 5);
                            this.nextEvent(4112);
                            break;
                        case 42:
                            this.now_eV1 = this.event[var2][this.event_now[var2] + 2];
                            this.now_eV2 = this.event[var2][this.event_now[var2] + 3];
                            Mg.i().go(this.gr, this.now_eV1, -1, this.now_eV2);
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 4);
                            this.nextEvent(4113);
                            break;
                        case 43:
                            var3 = this.event[var2][this.event_now[var2] + 2] - 1;
                            this.now_eV1 = this.getNpcLayer(var3);
                            this.now_eV2 = this.getNpcId(var3);
                            this.npc[this.now_eV1][this.now_eV2].other[8] = this.event[var2][this.event_now[var2] + 3];
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 4);
                            this.nextEvent(16);
                            break;
                        case 44:
                            var3 = this.event[var2][this.event_now[var2] + 2];
                            if (var3 == 0) {
                                this.ifEvent(var2, 3, 16, 2, this.gr.gameCheckRegIsOK());
                            } else if (var3 == 1) {
                                if (!this.gr.gameCheckRegIsOK()) {
                                    var6 = this.event_now;
                                    var6[var2] = (short)(var6[var2] + 3);
                                    this.nextEvent(0);
                                    this.checkRegWhere0(var2);
                                }
                            } else if (var3 == 2) {
                                this.ifEvent(var2, 3, 16, 2, this.gr.gameCheckRegIsOK());
                            }
                            break;
                        case 45:
                            this.runEvent_srcMove(var2);
                            break;
                        case 46:
                            Sound.i().setMusicId(this.event[var2][this.event_now[var2] + 2]);
                            Sound.i().setMusic(false);
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 3);
                            this.nextEvent(16);
                            break;
                        case 47:
                            this.my.state = 10;
                            byte var1 = (byte)(this.sleep_count + 1);
                            this.sleep_count = var1;
                            if (var1 == this.event[var2][this.event_now[var2] + 2]) {
                                this.sleep_count = 0;
                                var6 = this.event_now;
                                var6[var2] = (short)(var6[var2] + 3);
                                this.nextEvent(17);
                            }
                            break;
                        case 48:
                            this.my.state = 10;
                            this.srcFlash_c = (byte)(this.event[var2][this.event_now[var2] + 2] << 1);
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 3);
                            this.nextEvent(16);
                            break;
                        case 49:
                            if (this.gr.magic_id == -2) {
                                this.my.state = 10;
                                this.gr.magic_id = this.event[var2][this.event_now[var2] + 2];
                                this.gr.magic_x = this.map_x + this.event[var2][this.event_now[var2] + 3] * 20 + 10;
                                this.gr.magic_y = this.map_y + this.event[var2][this.event_now[var2] + 4] * 20 + 20;
                                this.gr.setMagic(this.event[var2][this.event_now[var2] + 2] / 5);
                            } else if (this.gr.magic_id == -1) {
                                this.gr.magic_id = -2;
                                var6 = this.event_now;
                                var6[var2] = (short)(var6[var2] + 5);
                                this.nextEvent(16);
                            }
                            break;
                        case 50:
                            if (this.my.state != 24 && this.my.state != 25) {
                                if (this.my.frame_c == -1 && this.my.state != 23) {
                                    this.my.state = 23;
                                }
                                break;
                            }

                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 3);
                            this.nextEvent(0);
                            if (this.my.state == 24) {
                                this.gr.say("保存进度完成", 1);
                                this.gr.saveGame();
                            }

                            this.my.state = 0;
                            break;
                        case 51:
                            switch (this.event[var2][this.event_now[var2] + 2]) {
                                case 0:
                                    if (this.eventGoing == 0) {
                                        this.gr.say(Ms.i().getDialogs(this.event[var2], this.event_now[var2] + 4, this.event[var2][this.event_now[var2] + 3]), -1);
                                        this.eventGoing = 1;
                                    } else if (this.gr.say_c == 0) {
                                        var6 = this.event_now;
                                        var6[var2] = (short)(var6[var2] + (this.event[var2][this.event_now[var2] + 3] << 1) + 4);
                                        this.nextEvent(272);
                                    }
                                    continue;
                                case 1:
                                case 2:
                                    if (this.eventGoing == 0) {
                                        this.my.state = 22;
                                        this.black_1 = 0;
                                        this.black_0 = 0;
                                        Ms.i();
                                        Ms.font.setSize(22);
                                        this.fontSizeControl = true;
                                        this.gr.setStringB(Ms.i().getDialogs(this.event[var2], this.event_now[var2] + 4, this.event[var2][this.event_now[var2] + 3]), Constants_H.WIDTH__ - 25 * 2, 3);
                                        Ms.i();
                                        Ms.font.setSize(26);
                                        this.fontSizeControl = false;
                                        this.eventGoing = this.event[var2][this.event_now[var2] + 2];
                                    } else if (this.eventGoing == 3) {
                                        var6 = this.event_now;
                                        var6[var2] = (short)(var6[var2] + (this.event[var2][this.event_now[var2] + 3] << 1) + 4);
                                        this.nextEvent(272);
                                        this.gr.about_d = null;
                                        this.black_0 = -1;
                                    }
                                default:
                                    continue;
                            }
                        case 52:
                            this.my.state = 10;
                            this.xxx = this.event[var2][this.event_now[var2] + 2];
                            var6 = this.event_now;
                            var6[var2] = (short)(var6[var2] + 3);
                            this.nextEvent(16);
                            break;
                        case 53:
                            if (this.initSrcEffect(this.event[var2][this.event_now[var2] + 2])) {
                                var6 = this.event_now;
                                var6[var2] = (short)(var6[var2] + 3);
                                this.nextEvent(16);
                            }
                    }
                } while(this.event_state == 1);
            }
        }

    }

    public byte exitMap(byte[][] var1) {
        byte var2;
        if (var1[this.get_meet][3] == -1) {
            var2 = this.mapNo;
            this.mapNo = this.lastMap;
            this.lastMap = var2;
            this.lastExit = this.get_meet;
            var2 = -1;
        } else {
            var2 = this.mapNo;
            this.mapNo = var1[this.get_meet][4];
            this.lastMap = var2;
            this.lastExit = this.get_meet;
            var2 = var1[this.get_meet][3];
        }

        return var2;
    }

    public byte getMySpeed() {
        byte var1;
        if (this.anole_type == 0) {
            var1 = 6;
        } else if (this.anole_type == 1) {
            var1 = 6;
        } else if (this.anole_type == 2) {
            var1 = 10;
        } else if (this.anole_type == 4) {
            var1 = 5;
        } else if (this.anole_type == 3) {
            var1 = 10;
        } else {
            var1 = 5;
        }

        return var1;
    }

    public void goMiniMap() {
        Ms.i().keyRelease();
        byte[] var4 = Ms.i().getStream("data/map.d", -1);
        Ms.skip = 0;
        this.mapdataArea = Ms.i().create2Array(var4);
        this.mapdataMap = Ms.i().create2Array(var4);
        var4 = (byte[])null;
        this.my.state = 17;
        this.showArea = -1;
        this.myMiniMap = -1;
        this.selectMap = 0;

        for(byte var1 = 0; var1 < this.mapdataArea.length; ++var1) {
            for(byte var2 = 0; var2 < this.mapdataArea[var1].length; ++var2) {
                if (this.mapNo == this.mapdataArea[var1][var2]) {
                    this.selectMap = this.mapNo;
                    if (this.mapdataMap[this.selectMap].length > 0) {
                        this.myMiniMap = this.selectMap;
                        this.showArea = var1;
                        boolean var3;
                        if (this.mapdataArea[this.showArea][0] > -1) {
                            var3 = true;
                        } else {
                            var3 = false;
                        }

                        this.miniMapMode = var3;
                        return;
                    }
                }
            }
        }

    }

    public void goMission(int var1, boolean var2) {
        if (this.my.state == 18 || this.my.state == 0) {
            Ms.i().keyRelease();
            this.bPause = var2;
            GameRun.run_state = -10;
            this.my.state = 18;
            this.gr.cur_a = (byte)var1;
            byte[] var5 = this.gr.select[0];
            this.gr.select[0][1] = 0;
            var5[0] = 0;
            Ms.i();
            Ms.skip = 0;
            var5 = Ms.i().getStream("data/mission" + var1 + ".t", -1);
            this.sMission = Ms.i().createString2Array(var5);
            this.gr.line_max = 6;
            this.gr.about_a = null;
            if (var1 == 1) {
                byte var3 = 0;
                byte var6 = 0;

                byte var4;
                for(var5 = new byte[50]; var3 < this.sMission.length; var6 = var4) {
                    var4 = var6;
                    if (this.isMission(var3)) {
                        var4 = (byte)(var6 + 1);
                        var5[var6] = var3;
                    }

                    ++var3;
                }

                this.mDirect = null;
                this.mDirect = new byte[var6];
                System.arraycopy(var5, 0, this.mDirect, 0, this.mDirect.length);
                if (this.mDirect.length > 0) {
                    this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 640 - 50, 0);
                }

                var5 = (byte[])null;
            } else {
                this.gr.select[0][0] = this.bMission[14];
                if (this.bMission[14] >= this.gr.line_max) {
                    this.gr.select[0][1] = (byte)(this.gr.select[0][0] - this.gr.line_max + 1);
                } else {
                    this.gr.select[0][1] = 0;
                }

                this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), 640 - 50, 0);
            }
        }

    }

    public void goNextMap() {
        this.setfmap();
        this.firstDrawMap = 0;
        this.gr.doPaint(2);
        this.saveMapBak();
        byte var1 = this.lastExit;
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
            this.go = var1;
        }

        if (!this.bExitBoss) {
            this.getInMap(this.go, this.door);
        }

        this.createEvent();
        this.gr.doPaint(15);
        this.createNpcString();
        this.createLayer();
        this.gr.doPaint(20);
        if (!this.bExitBoss && (this.door[this.go][5] == 1 || this.door[this.go][5] == 2)) {
            this.my.frame_c = (byte)(20 / this.my.speed);
            this.my.speed_x = (byte)(this.dir_select[this.my.dir][0] * this.my.speed);
            this.my.speed_y = (byte)(this.dir_select[this.my.dir][1] * this.my.speed);
            this.my.setActionNo(true);
        } else {
            this.my.setActionNo(false);
        }

        this.gr.b_c = 0;
        this.setMapMusic(false);
        this.go = -2;
        this.gr.initMonPro(this.mapNo, true);
        this.gr.cityName_c = 25;
        this.srcNpcNo = -1;
        Ms.i().rmsOptions(1, (byte[])null, 4);
        this.initCloud();
        this.bExitBoss = false;
        this.my.state = 9;
        if (this.boatSelect == -1) {
            this.my.state = 0;
            this.my.setIXY(-1, -1);
            this.my.speed = this.getMySpeed();
        }

        this.checkNpcT = -1;
        this.pkey.stopMove();
    }

    public boolean initAnoleValue() {
        boolean var1;
        if (this.isAnole(this.my.x, this.my.y, this.anole_type)) {
            this.gr.say("不能更换坐骑", 0);
            var1 = false;
        } else {
            this.my.state = 20;
            this.gr.cur_a = 0;
            this.gr.cur_b = 0;
            this.gr.setStringB("下坐骑#n植物坐骑#n金属坐骑#n飞行坐骑#n野兽坐骑#n海洋坐骑#n无此坐骑", Constants_H.WIDTH, 0);
            var1 = true;
        }

        return var1;
    }

    public void initBrowImage() {
        if (this.brow == null) {
            this.brow = Ms.i().createSprite("data/face/brow", true);
        }

    }

    public byte[] initData(byte[] var1, int var2) {
        int var3 = 0;

        int var4;
        int var5;
        byte var6;
        byte var8;
        for(var4 = 1; var3 < var2; var4 = var5 + 1 + ((var6 & 255) << 8 | var8 & 255)) {
            var5 = var4 + 1;
            var6 = var1[var4];
            var8 = var1[var5];
            ++var3;
        }

        var2 = var4 + 1;
        byte[] var7 = new byte[(var1[var4] & 255) << 8 | var1[var2] & 255];
        System.arraycopy(var1, var2 + 1, var7, 0, var7.length);
        return var7;
    }

    public void initMap() {
        this.my.dir = 4;
        this.srcNpcNo = -1;
        this.gr.loadRmsSms();
        this.gr.loadRmsNidus();
        this.notMeet(0, 0);
        this.mapInfo = Ms.i().byteArrayToShortArray(Ms.i().rmsOptions(13, (byte[])null, 1));
        this.mapChange = Ms.i().rmsOptions(1, (byte[])null, 1);

        for(short var1 = 0; var1 < this.mapChange.length; ++var1) {
            if (this.mapChange[var1] == 1) {
                this.mapTemp[var1] = Ms.i().rmsOptions(var1 + 14, (byte[])null, 1);
            }
        }

        System.gc();
        this.gr.createOver = 33;
        this.createOther();
        this.gr.createOver = 35;
        this.createLayer();
        this.gr.createOver = 37;
        this.createEvent();
        this.gr.createOver = 39;
        this.createNpcString();
        this.gr.createOver = 40;
        Ms.i().rmsOptions(1, (byte[])null, 4);
        this.gr.initMonPro(this.mapNo, true);
        this.initMissionList();
        this.initCloud();
    }

    public void initNpcAni() {
        byte var2 = 0;
        byte[][] var5 = new byte[][]{new byte[100], new byte[5], new byte[60]};
        this.gr.initNidusMap(0);

        for(byte var3 = (byte)(this.npc.length - 1); var3 > -1; --var3) {
            for(byte var1 = (byte)(this.npc[var3].length - 1); var1 > -1; --var1) {
                var5[this.npc[var3][var1].other[3] - 1][this.npc[var3][var1].other[2]] = 1;
                if (var3 == 0) {
                    this.npcList[var1 + 1] = var1;
                    if (this.npc[var3][var1].other[8] == 1) {
                        byte[] var6 = this.gr.nidusMap;
                        byte var4 = (byte)(var2 + 1);
                        var6[var2] = var1;
                        var2 = var4;
                    }
                }
            }
        }

        this.gr.initNidusMap(1);
        this.npcList[0] = -1;

        for(var2 = (byte)(this.item.length + this.npc[0].length); var2 > this.npc[0].length; --var2) {
            this.npcList[var2] = (byte)(-2 - var2 + this.npc[0].length + 1);
        }

        this.initNpcAni_1(100, 0, var5[0]);
        this.initNpcAni_1(5, 1, var5[1]);
        this.initNpcAni_1(60, 2, var5[2]);
        var5 = (byte[][])null;

        for(var2 = (byte)(this.npc[0].length - 1); var2 > -1; --var2) {
            this.npc[0][var2].setNpcNum(npcSp[this.npc[0][var2].other[3] - 1][this.npc[0][var2].other[2]].aLength());
        }

    }

    public void initNpcAniOne(String var1, int var2, int var3) {
        Sprite[] var7 = npcSp[var3];
        Ms var5 = Ms.i();
        String var6 = "data/npc" + var3 + "/" + var1;
        boolean var4;
        if (var3 == 2) {
            var4 = this.gr.isNpc2ImageType(Integer.parseInt(var1));
        } else {
            var4 = true;
        }

        var7[var2] = var5.createSprite(var6, var4);
    }

    public void initNpcFaceOne(String var1) {
        if (var1 != null) {
            byte var2 = -1;
            this.faceDir = true;
            if (var1.equals("塞其")) {
                var2 = 0;
                this.faceDir = false;
            } else if (!var1.equals("安琪儿") && !var1.equals("蓝发女孩")) {
                if (var1.equals("幽暗鬼王")) {
                    var2 = 2;
                } else if (var1.equals("杰奇校长")) {
                    var2 = 3;
                } else if (!var1.equals("普罗") && !var1.equals("普罗校长")) {
                    if (var1.equals("神秘东方男子")) {
                        var2 = 5;
                    } else if (var1.equals("南宫云")) {
                        var2 = 6;
                    }
                } else {
                    var2 = 4;
                }
            } else {
                var2 = 1;
            }

            if (var2 > -1) {
                if (this.imgFace == null || this.faceLast != var2) {
                    byte var3;
                    if (this.faceDir) {
                        var3 = 50;
                    } else {
                        var3 = -50;
                    }

                    this.face_c = (short)var3;
                    this.faceLast = var2;
                    this.imgFace = null;
                    this.imgFace = Ms.i().createImage("data/face/" + var2);
                }
            } else {
                this.nullNpcFace();
            }
        }

    }

    public boolean initSrcEffect(int var1) {
        int var3 = Constants_H.SRC_BATTLE_H__;
        this.my.state = 10;
        boolean var4;
        switch (var1) {
            case 0:
            case 1:
            case 2:
                this.bSrc_c = 0;
                if (var1 != 1) {
                    var3 = 0;
                }

                this.black_width = (short)var3;
                if (var1 == 1) {
                    var4 = true;
                } else {
                    var4 = false;
                }

                this.bSrc = var4;
                var4 = true;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                this.bSrc = true;
                if (this.bSrc_c == 0) {
                    if (var1 != 6 && var1 != 5) {
                        if (var1 != 4) {
                            var3 = 40;
                        }

                        short var2 = (short)var3;
                        this.bSrc_c = var2;
                        this.black_width = var2;
                    } else {
                        this.bSrc_c = -40;
                        byte var5;
                        if (var1 == 5) {
                            var5 = 40;
                        } else {
                            var5 = 0;
                        }

                        this.black_width = (short)var5;
                    }
                }

                this.bSrc_c = Ms.i().mathSpeedN(this.bSrc_c, 0, 12, false);
                if (this.bSrc_c == 0) {
                    if (var1 != 6) {
                        var4 = true;
                    } else {
                        var4 = false;
                    }

                    this.bSrc = var4;
                    var4 = true;
                    break;
                }
            default:
                var4 = false;
        }

        return var4;
    }

    public void initWalkIco() {
        if (this.walkIco == null) {
            this.walkIco = Ms.i().createImageArray(3, "data/brow/w");
        }

    }

    public void insertNpc() {
        if (this.npc != null) {
            for(byte var2 = 1; var2 < this.npcList.length; ++var2) {
                for(byte var3 = var2; var3 > 0; --var3) {
                    short var5 = this.getNpcListY(var3);
                    short var4 = this.getNpcListY(var3 - 1);
                    if (var5 > var4) {
                        break;
                    }

                    if (var5 != var4 || var5 == var4 && this.npcList[var3 - 1] == -1) {
                        byte var1 = this.npcList[var3];
                        this.npcList[var3] = this.npcList[var3 - 1];
                        this.npcList[var3 - 1] = var1;
                    }
                }
            }
        }

    }

    public void key_map() {
        if (this.my.state == 17) {
            this.keyMiniMap();
        } else if (this.my.state == 18) {
            this.keyMission();
        } else if (this.my.state == 12) {
            this.keySelectMenu();
        } else if (this.my.state == 19) {
            this.keyMySave();
        } else if (this.my.state == 22 && this.black_0 > -1 && this.black_0 == this.gr.about_d.length && Ms.i().key_Num0()) {
            this.eventGoing = 3;
            this.black_0 = -1;
            Ms.i().keyRelease();
        } else {
            if (this.my.state == 16) {
                if (Ms.i().key_delay()) {
                    return;
                }

                if (Ms.i().key_Up_Down()) {
                    GameRun var1 = this.gr;
                    var1.popMenu = (byte)(var1.popMenu ^ 1);
                } else if (Ms.i().key_S1_Num5() || Ms.i().key_S2()) {
                    if (Ms.i().key_S2()) {
                        this.gr.popMenu = 1;
                    }

                    this.my.state = 0;
                    return;
                }
            } else {
                if (this.my.state == 10) {
                    Ms.i().keyRelease();
                    return;
                }

                if (this.my.state == 23) {
                    if (Ms.i().key_S2()) {
                        this.my.state = 25;
                    } else if (Ms.i().key_S1_Num5()) {
                        this.my.state = 24;
                    }

                    Ms.i().keyRelease();
                    return;
                }

                if (this.my.state == 11) {
                    if (Ms.i().key_S1_Num5()) {
                        this.gr.say_c = 0;
                    }

                    if (this.gr.say_c == 0) {
                        this.my.state = 0;
                    }

                    return;
                }

                if (this.my.state == 20) {
                    this.keyAnoleSel();
                    return;
                }
            }

            if (this.my.state == 1 && Ms.i().key_S1_Num5()) {
                if (this.dialog_no + 2 >= this.dialog.length) {
                    this.dialog_no = -1;
                    this.dialog = null;
                    if (this.eventGoing == 0) {
                        this.my.state = 0;
                    } else {
                        this.eventGoing = 2;
                    }

                    if (this.bDirTalk) {
                        this.npc[0][this.get_meet].other[7] = this.npcDirTalk;
                        if (this.npc[0][this.get_meet].other[7] > -1) {
                            this.npc[0][this.get_meet].dir = 3;
                        }

                        this.bDirTalk = false;
                    }

                    return;
                }

                this.dialog_no = (byte)(this.dialog_no + 2);
                Ms.i().keyRelease();
            }

            if (this.my.frame_c <= 0 && this.my.state == 0) {
                Ms.i();
                this.map_key = (byte)(-Ms.key);
                this.doKey();
            }
        }

    }

    public void loadDate_Rms() {
        byte[] var1 = Ms.i().rmsOptions(2, (byte[])null, 1);
        if (var1[0] == -1) {
            byte[] var2 = new byte[16];
            var2[0] = 58;
            var2[1] = 9;
            var2[2] = 16;
            var2[3] = 2;
            var2[5] = 1;
            var2[6] = 2;
            var2[15] = -1;
            var1 = var2;
            Ms.i().rmsOptions(2, var2, 2);
            var2 = (byte[])null;
            this.event_now_list = new short[70][];
            Ms.i().rmsOptions(12, Ms.i().getEventNowData(this.event_now_list), 2);
        } else {
            this.event_now_list = Ms.i().readEventNowData();
        }

        this.mapNo = var1[0];
        this.lastMap = var1[5];
        this.lastExit = var1[6];
        this.my.setXY(var1[1], var1[2], 0, 0);
        this.my.dir = var1[3];
        this.my.setActionNo(false);
        this.gr.money = Ms.i().getInt(var1, 7);
        this.gr.coin = Ms.i().getInt(var1, 11);
        this.anole_type = var1[15];
        var1 = (byte[])null;
    }

    public void mapMove(int var1, int var2, int var3, int var4) {
        if (var3 > 0 && var1 >= this.mapLeft_NOmove && var1 < this.mapRight_NOmove || var3 < 0 && var1 > this.mapLeft_NOmove && var1 <= this.mapRight_NOmove) {
            this.map_x -= var3;
        }

        if (var4 > 0 && var2 >= this.mapUp_NOmove && var2 < this.mapDown_NOmove || var4 < 0 && var2 > this.mapUp_NOmove && var2 <= this.mapDown_NOmove) {
            this.map_y -= var4;
        }

    }

    public void map_saveGame() {
        byte[] var1 = new byte[16];
        var1[0] = this.mapNo;
        var1[5] = this.lastMap;
        var1[6] = this.lastExit;
        var1[1] = (byte)(this.my.x / 20);
        var1[2] = (byte)(this.my.y / 20);
        var1[3] = this.my.dir;
        Ms.i().putInt(this.gr.money, var1, 7);
        Ms.i().putInt(this.gr.coin, var1, 11);
        var1[15] = this.anole_type;
        Ms.i().rmsOptions(2, var1, 2);
        var1 = (byte[])null;
    }

    public void notMeet(int var1, int var2) {
        if (var1 == 0) {
            this.notMeet = 0;
            Ms.i();
            this.step_MEET = (short)(Ms.getRandom(30) + 1);
            this.meet_step = (short)((this.step_MEET - 15) * (this.step_MEET - 15));
            short var3 = this.meet_step;
            Ms.i();
            if (var3 > Ms.getRandom(50)) {
                Ms.i();
                var1 = Ms.getRandom(9);
                Ms.i();
                this.step_MEET = (byte)(var1 + 17 - Ms.getRandom(7));
            }

            this.step_MEET = (short)(this.step_MEET << 2);
            this.meet_step = 0;
            this.bStep = -1;
        } else if (var1 == 1) {
            this.notMeet = 1;
            this.step_MEET = (short)((var2 - 14 + 1) * 200);
            this.step_MEET = (short)(this.step_MEET << 2);
            this.meet_step = 0;
            this.bStep = 100;
        }

    }

    public void nullNpcFace() {
        this.imgFace = null;
    }

    public void paint_map(Graphics var1) {
        g = var1;
        if (this.my.state == 6) {
            this.gr.drawChangeMap(false, this.gr.b_c, 30, 360 - 38, 640 - 60);
        } else if (this.my.state == 17) {
            this.drawMiniMap();
        } else if (this.my.state == 18) {
            this.drawMission();
        } else {
            Ui.i().fillRect(this.bgColor, 0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
            GameRun.mc.setScale(MainCanvas.mapxx, MainCanvas.mapyy);
            GameRun.mc.keyxx = MainCanvas.mapxx;
            GameRun.mc.keyyy = MainCanvas.mapyy;
            this.setMapOffer();
            if (this.xxx > 0) {
                --this.xxx;
                var1.translate(this.xxx % 2, this.xxx % 2);
            }

            this.drawMap(GameRun.offG);
            this.drawNpcAni(this.npc[2]);
            int var2;
            if (this.pkey.isGo) {
                var2 = this.ii++;
                if (var2 > 2) {
                    this.ii = 0;
                    var2 = this.i++;
                    if (var2 < 2) {
                        var2 = this.i;
                    } else {
                        var2 = 0;
                    }

                    this.i = var2;
                }

                Ui.i().drawImage(this.walkIco[this.i], this.pkey.gox + this.map_x, this.pkey.goy + this.map_y, 3);
            }

            this.drawNMAni(this.npc[0]);
            this.bkgroundToPaint(this.frontData, this.mapImg, -this.map_x, -this.map_y - 1, this.moduleData, var1, 0, 0, Constants_H.WIDTH, Constants_H.HEIGHT, false);
            this.drawNpcAni(this.npc[1]);
            this.drawMapRect(var1);
            this.drawStep(var1, Constants_H.WIDTH - 17, 0, 16);
            this.drawBrow();
            this.drawCheck5(4);
            this.drawCloud();
            int var3;
            int var4;
            GameRun var6;
            if (this.gr.magic_id > -1) {
                var6 = this.gr;
                if (this.gr.magic_id / 5 > 5) {
                    var2 = 5;
                } else {
                    var2 = this.gr.magic_id / 5;
                }

                if (this.gr.magic_id / 5 > 5) {
                    var3 = 5;
                } else {
                    var3 = this.gr.magic_id / 5;
                }

                if (this.gr.magic_id / 5 >= 5) {
                    var4 = this.gr.magic_id - 25;
                } else {
                    var4 = this.gr.magic_id % 5;
                }

                if (var6.drawMagicC(var2, var3, var4, this.gr.magic_x, this.gr.magic_y + 16, 0)) {
                    if (this.my.state == 21) {
                        this.gr.magic_id = -2;
                        this.setAnole();
                    } else {
                        this.gr.magic_id = -1;
                    }

                    this.my.state = 0;
                }
            }

            var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
            if (this.my.state == 20) {
                this.drawAnoleSel();
            }

            var1.restCanvas();
            if (!this.fontSizeControl) {
                Ms.i();
                Ms.font.setSize(22);
            }

            this.drawSrcEffect();
            if (this.my.state == 12) {
                var2 = Constants_H.WIDTH__ / 2;
                this.gr.drawSelectMenu_(this.gr.action_str, var2 - 25 * 3, Constants_H.HEIGHT__ / 2 - 100 + (this.gr.action_str.length >> 1) * 25, 25 * 6, 0, 0, this.gr.cur_a);
            }

            if (this.gr.view_state == 4) {
                var4 = Constants_H.WIDTH__;
                var2 = Constants_H.HEIGHT__;
                var3 = Constants_H.WIDTH__ / 2;
                Ui.i().drawKuang(0, var2 - 25 * 3, var4, 25 * 3);
                GameRun var7 = this.gr;
                var6 = this.gr;
                byte var9 = this.gr.cur_a;
                var7.showStringM_(var6.getNameMonsterInfo((new byte[]{4, 25, 56})[var9]), var3, var2 - 25 * 2 - 8, 10, 3);
                byte[] var8 = (byte[])null;
            } else if (this.my.state == 16) {
                var2 = Constants_H.WIDTH__;
                var4 = Constants_H.HEIGHT__;
                var3 = Constants_H.WIDTH__ / 2;
                int var5 = Constants_H.HEIGHT__ / 2;
                Ui.i().drawKuang(0, var4 - 25 * 4, var2, 25 * 4);
                this.gr.showStringM_("是否回复所有宠物？", var3, var4 - 25 * 4 + 4, 10, 3);
                this.gr.drawSelectMenu_(this.gr.action_str, var3 - 25 * 2, var5 - 25, 25 * 4, -1, 0, this.gr.popMenu);
                this.gr.showStringM_("所需金额：" + this.gr.sell_money, var3, var4 - 25 * 3 + 4, 10, 3);
                this.gr.drawMoney(var3, var4 - 25 + 15, 3, false);
            }

            if (this.my.state != 20) {
                this.gr.drawPauseIco(this.my.state);
            }

            if (this.my.state == 19) {
                this.drawMySave();
            } else {
                byte var10 = this.gr.rmsOther[2];
                this.gr.drawCityName();
                if (this.my.state == 23) {
                    var3 = Constants_H.WIDTH__;
                    var2 = Constants_H.HEIGHT__;
                    var4 = Constants_H.WIDTH__ / 2;
                    Ui.i().drawKuang(0, var2 - 25 * 2, var3, 25 * 2);
                    Ui.i().drawString("是否保存进度？", var4, var2 - 25 * 2 + 6, 17, 3, 0);
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
            }
        }

    }

    public void run_map() {
        if (this.my.state != 9 && this.my.state != 6) {
            this.eventCheck();
        }

        if (this.my.state == 5 && this.my.frame_c < 1) {
            this.setMoveStop_m();
            this.my.state = 6;
        }

        if (this.my.state == 6) {
            this.gr.createOver = 1;
            this.goNextMap();
        } else {
            if (this.my.state == 2 && this.eventGoing == 0) {
                if ((this.npc[0][this.get_meet].other[4] == 1 || this.npc[0][this.get_meet].other[4] == 3) && this.npc[0][this.get_meet].other[5] > 0) {
                    this.npcName = this.npcNameData[this.get_meet];
                    if (this.npcName.equals("路人")) {
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
                } else {
                    this.my.state = 0;
                }
            } else if (this.my.state == 8 && this.my.frame_c == -1) {
                if (this.gr.immueEnemy == 0) {
                    Log.e("sk", "gr.immueEnemy==0");
                    GameRun var2 = this.gr;
                    String[] var1 = this.gr.battleSay;
                    Ms.i();
                    var2.say(var1[Ms.getRandom(3)], 0);
                    GameRun.mc.repaint();
                    this.gr.battleType(4);
                    this.gr.goBattlePVC();
                } else {
                    this.my.state = 0;
                }
            }

            this.runMove();
        }

    }

    public void save() {
        this.map_saveGame();
        this.saveNpc();

        for(int var1 = 0; var1 < this.mapInfo.length / 2; ++var1) {
            if (this.mapChange[var1] == 1) {
                this.mapChange[var1] = 0;
                Ms.i().rmsOptions(var1 + 14, this.mapTemp[var1], 2);
            }
        }

        Ms.i().rmsOptions(13, Ms.i().shortArrayToByteArray(this.mapInfo), 2);
        Ms.i().rmsOptions(12, Ms.i().getEventNowData(this.event_now_list), 2);
        Ms.i().rmsOptions(1, this.mapChange, 2);
        Ms.i().rmsOptions(7, this.bMission, 2);
        Ms.i().rmsOptions(5, this.gr.rmsSms, 2);
        Ms.i().rmsOptions(1, (byte[])null, 4);
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

    public void setAnole() {
        GameRun var3 = this.gr;
        byte var1;
        if (this.anole_type == 3) {
            var1 = 1;
        } else {
            var1 = 0;
        }

        var3.immueEnemy = (byte)var1;
        this.my.speed = this.getMySpeed();
        Ms var4 = Ms.i();
        Sprite var5 = npcSp[1][0];
        StringBuilder var6 = new StringBuilder("data/npc1/");
        String var7;
        if (this.anole_type == -1) {
            var7 = "0";
        } else {
            var7 = "r" + this.anole_type;
        }

        var7 = var6.append(var7).toString();
        boolean var2;
        if (this.anole_type == -1) {
            var2 = true;
        } else {
            var2 = false;
        }

        var4.setSprite(var5, var7, var2);
        this.my.setActionNo(false);
    }

    public void setMapMusic(boolean var1) {
        Sound.i().setMusicId(this.gr.musicNo[this.mapNo]);
        Sound.i().setMusic(var1);
    }

    public void setMission(int var1, boolean var2) {
        byte var3 = (byte)(var1 / 8);
        byte var5 = (byte)(var1 % 8);
        byte[] var4;
        if (var2) {
            var4 = this.bMission;
            var4[var3] = (byte)(var4[var3] | 1 << var5);
        } else if ((this.bMission[var3] & 1 << var5) != 0) {
            var4 = this.bMission;
            var4[var3] = (byte)(var4[var3] ^ 1 << var5);
            var4 = this.bMission;
            ++var4[15];
        }

    }

    public void setNull() {
        this.npc[0] = null;
        this.item = null;
        this.door = null;
        this.event = null;
        this.mapImg = null;
        this.moduleData = null;
    }

    public void setOverEvent(int var1, int var2) {
        if (!this.isMapEvent(var1, var2)) {
            short[] var4 = this.mapInfo;
            int var3 = var1 * 2 + 1;
            var4[var3] = (short)(var4[var3] | 1 << var2);
        }

        if (var1 == this.mapNo) {
            this.event_now[var2] = 24224;
        } else if (this.event_now_list[var1] != null) {
            this.event_now_list[var1][var2] = 24224;
        }

    }

    public void setRegState(boolean var1) {
        synchronized(this){}
        boolean var5 = false;

        try {
            var5 = true;
            PrintStream var2 = System.out;
            StringBuilder var3 = new StringBuilder("setRegState() notifyAll start isSuccess= ");
            var2.println(var3.append(var1).toString());
            this.isNeedWait = false;
            this.notifyAll();
            System.out.println("setRegState() notifyAll over");
            var5 = false;
        } finally {
            if (var5) {
                ;
            }
        }

    }

    public void setRestEvent(int var1, int var2) {
        if (this.isMapEvent(var1, var2)) {
            short[] var4 = this.mapInfo;
            int var3 = var1 * 2 + 1;
            var4[var3] = (short)(var4[var3] ^ 1 << var2);
        }

        if (var1 == this.mapNo) {
            this.event_now[var2] = 0;
        } else if (this.event_now_list[var1] != null) {
            this.event_now_list[var1][var2] = 0;
        }

    }

    public void setTempNull() {
        this.mapTemp = null;
        this.mapTemp = new byte[70][];
    }

    public void setfmap() {
        this.fmap = 0;
    }
}
