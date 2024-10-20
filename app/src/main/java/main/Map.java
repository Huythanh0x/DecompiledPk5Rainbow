package main;

import dm.Sound;
import minigame.Mg;
import java.io.ByteArrayOutputStream;
import android.util.Log;
import dm.Ui;
import dm.Ms;
import javax.microedition.lcdui.Image;
import dm.Sprite;
import javax.microedition.lcdui.Graphics;
import dm.Npc;

public class Map implements Key_H
{
    private static Npc cur_npc;
    private static Graphics g;
    static Sprite[][] npcSp;
    private byte action_5;
    private byte anoleSel;
    public byte anole_temp;
    public byte anole_type;
    public boolean bDirTalk;
    boolean bExitBoss;
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
    private byte event_state;
    public String fString;
    private boolean faceDir;
    private byte faceLast;
    private short face_c;
    public byte firstDrawMap;
    public byte fmap;
    boolean fontSizeControl;
    short[] frontData;
    private byte get_meet;
    public boolean gmErr;
    private byte go;
    public GameRun gr;
    private Image hudong;
    int i;
    int ii;
    private Image imgCloud;
    private Image imgFace;
    public Image imgShadow;
    public byte inShop;
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
    public byte mapNo;
    byte mapNotemp;
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
    public byte notMeet;
    private byte now_eV1;
    private byte now_eV2;
    public Npc[][] npc;
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
    private byte sleep_count;
    public int smissionLength;
    private byte srcFlash_c;
    private byte srcNpcNo;
    private short step_MEET;
    private byte time_5;
    private short topRow;
    public Image[] walkIco;
    short[][] worldData;
    private byte xxx;
    
    static {
        Map.npcSp = new Sprite[3][];
    }
    
    public Map(final GameRun gr) {
        super();
        this.npc = new Npc[3][];
        this.srcNpcNo = -1;
        this.sleep_count = 0;
        this.step_MEET = 4;
        this.event_state = 0;
        this.mapTemp = new byte[70][];
        this.anole_temp = -1;
        this.anole_type = -1;
        this.mapNo = 0;
        this.inShop = 0;
        this.notMeet = 0;
        this.dialog_no = -1;
        this.bStep = -1;
        this.go = -2;
        this.bExitBoss = false;
        this.mapNotemp = 0;
        this.fmap = -1;
        this.sIfElse = -1;
        this.gmErr = false;
        this.xxx = 0;
        this.i = 0;
        this.ii = 0;
        this.dir_select = new byte[][] { new byte[2], { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
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
        this.gr = gr;
        System.gc();
        this.init();
    }
    
    private void addCloud(final int n) {
        final short[] array = this.cloud[n];
        final short leftCol = this.leftCol;
        final int width = Constants_H.WIDTH;
        Ms.i();
        array[0] = (short)(leftCol * 20 + width + Ms.getRandom(Constants_H.WIDTH_H));
        final short[] array2 = this.cloud[n];
        final short topRow = this.topRow;
        Ms.i();
        array2[1] = (short)(topRow * 20 + 20 + 2 + (Ms.getRandom(25) + 55) * n);
        final short[] array3 = this.cloud[n];
        Ms.i();
        array3[2] = (short)(Ms.getRandom(3) + 1);
    }
    
    private void canMove(final int n, final int n2) {
        this.my.speed_x = (byte)n;
        this.my.speed_y = (byte)n2;
        if (this.my.x + this.my.speed_x >= 0 && this.my.x + this.my.speed_x + 19 < this.cols * 20 && this.my.y + this.my.speed_y >= 0 && this.my.y + this.my.speed_y + 19 < this.rows * 20) {
            this.roadType = this.checkMap(this.my.x, this.my.y, this.my.speed_x, this.my.speed_y);
            if (this.roadType == 0) {
                this.initMoveMy();
            }
            else if (this.checkMoveOff(this.checkNpcT)) {
                this.initMoveMy();
            }
            else if (this.checkNpcT == -1 || this.isCheckNpcOff()) {
                this.roadType = this.isMapChenk(this.roadType);
                if (this.roadType == -1) {
                    this.moveOff((byte)3, (byte)1, -this.my.speed);
                }
                else if (this.roadType == -2) {
                    this.moveOff(4, (byte)2, (int)this.my.speed);
                }
                else {
                    this.checkAnole();
                }
            }
            else {
                Ms.i().keyRelease();
                this.setMoveStop_m();
            }
        }
        else {
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
        Label_0070: {
            if (this.checkType == 2) {
                if (!this.isCheckAnole(4)) {
                    break Label_0070;
                }
            }
            else if (this.checkType == 3) {
                if (!this.isCheckAnole(0)) {
                    break Label_0070;
                }
            }
            else if (this.checkType == 4) {
                if (!this.isCheckAnole(2)) {
                    break Label_0070;
                }
            }
            else {
                if (this.checkType != 0 || this.anole_type != 4) {
                    break Label_0070;
                }
                if (this.anole_type != 3 && this.isAnoleType(3)) {
                    this.anole_type = 3;
                }
                else {
                    this.anole_type = -1;
                }
                this.setAnole();
                this.initMoveMy();
            }
            return;
        }
        Ms.i().keyRelease();
        this.setMoveStop_m();
    }
    
    private byte checkIfNpc(final Npc[] array, final int n, final int n2) {
        for (byte b = (byte)(array.length - 1); b > -1; --b) {
            if (Ms.i().isRect(n, n2, 19, 19, array[b].x, array[b].y, 20, 20) && (array[b].other[4] == 1 || array[b].other[4] == 3)) {
                return b;
            }
        }
        return -1;
    }
    
    private byte checkIfOther(final byte[][] array, final int n, final int n2) {
        for (byte b = (byte)(array.length - 1); b > -1; --b) {
            if (Ms.i().isRect(n, n2, 19, 19, array[b][0] * 20, array[b][1] * 20, 20, 20)) {
                return b;
            }
        }
        return -1;
    }
    
    private byte checkMap(final int n, final int n2, final int n3, final int n4) {
        this.checkNpcT = -1;
        this.checkType = this.checkIfOther(this.item, n + n3, n2 + n4);
        byte checkWorld;
        if (this.checkType != -1) {
            this.checkNpcT = -2;
            checkWorld = 1;
        }
        else if (n + n3 < 0 || n + n3 >= this.cols * 20 || n2 + n4 < 0 || n2 + n4 >= this.rows * 20) {
            checkWorld = 1;
        }
        else {
            this.checkType = this.checkIfNpc(this.npc[0], n + n3, n2 + n4);
            if (this.checkType != -1) {
                if (!this.npcNameData[this.checkType].equals("\u8def\u4eba") || this.npc[0][this.checkType].other[5] > 0) {
                    this.checkNpcT = this.checkType;
                }
                checkWorld = 1;
            }
            else {
                this.checkType = this.checkIfOther(this.door, n + n3, n2 + n4);
                if (this.checkType != -1 && (this.door[this.checkType][5] == 2 || this.map_key == this.door[this.checkType][2])) {
                    this.my.state = 5;
                    this.get_meet = this.checkType;
                    checkWorld = 0;
                }
                else {
                    checkWorld = this.checkWorld(n, n2, n3, n4, false);
                }
            }
        }
        return checkWorld;
    }
    
    private boolean checkMoveOff(int n) {
        boolean b4;
        if (n > -1) {
            final byte b = (byte)(this.npc[0][n].x + 20 - this.my.x);
            byte speed_x = (byte)(this.npc[0][n].x - this.my.x - 20);
            final byte b2 = (byte)(this.npc[0][n].y + 20 - this.my.y);
            final byte b3 = (byte)(this.npc[0][n].y - this.my.y - 20);
            if (this.my.speed_x < 0 && b != 0) {
                final Npc my = this.my;
                byte speed_x2;
                if (b < this.my.speed_x) {
                    speed_x2 = this.my.speed_x;
                }
                else {
                    speed_x2 = b;
                }
                my.speed_x = speed_x2;
                b4 = true;
            }
            else if (this.my.speed_x > 0 && speed_x != 0) {
                final Npc my2 = this.my;
                if (speed_x >= this.my.speed_x) {
                    speed_x = this.my.speed_x;
                }
                my2.speed_x = speed_x;
                b4 = true;
            }
            else if (this.my.speed_y < 0 && b2 != 0) {
                final Npc my3 = this.my;
                byte speed_y;
                if (b2 < this.my.speed_y) {
                    speed_y = this.my.speed_y;
                }
                else {
                    speed_y = b2;
                }
                my3.speed_y = speed_y;
                b4 = true;
            }
            else {
                if (this.my.speed_y <= 0 || b3 == 0) {
                    return false;
                }
                final Npc my4 = this.my;
                byte speed_y2;
                if (b3 < this.my.speed_y) {
                    speed_y2 = b3;
                }
                else {
                    speed_y2 = this.my.speed_y;
                }
                my4.speed_y = speed_y2;
                b4 = true;
            }
        }
        else {
            final byte ix_off = this.my.getIx_off();
            final byte b5 = (byte)(20 - this.my.getIx_off());
            n = this.my.getIy_off();
            byte speed_y3 = (byte)(20 - this.my.getIy_off());
            if (this.my.speed_x != 0 && ix_off != 0) {
                if (this.my.speed_x < 0) {
                    final Npc my5 = this.my;
                    if (-ix_off < this.my.speed_x) {
                        n = this.my.speed_x;
                    }
                    else {
                        n = -ix_off;
                    }
                    my5.speed_x = (byte)n;
                }
                else {
                    final Npc my6 = this.my;
                    byte speed_x3;
                    if (b5 < this.my.speed_x) {
                        speed_x3 = b5;
                    }
                    else {
                        speed_x3 = this.my.speed_x;
                    }
                    my6.speed_x = speed_x3;
                }
                b4 = true;
            }
            else {
                if (this.my.speed_y == 0 || n == 0) {
                    return false;
                }
                if (this.my.speed_y < 0) {
                    final Npc my7 = this.my;
                    if (-n < this.my.speed_y) {
                        n = this.my.speed_y;
                    }
                    else {
                        n = -n;
                    }
                    my7.speed_y = (byte)n;
                }
                else {
                    final Npc my8 = this.my;
                    if (speed_y3 >= this.my.speed_y) {
                        speed_y3 = this.my.speed_y;
                    }
                    my8.speed_y = speed_y3;
                }
                b4 = true;
            }
        }
        return b4;
        b4 = false;
        return b4;
    }
    
    private byte checkWorld(final int n, final int n2, final int n3, final int n4, final boolean b) {
        final int n5 = 0;
        final int n6 = 1;
        while (true) {
            Label_0045: {
                if (n3 == 0 && n % 20 != 0) {
                    break Label_0045;
                }
                int n7 = n6;
                int i = n5;
                if (n4 == 0) {
                    n7 = n6;
                    i = n5;
                    if (n2 % 20 != 0) {
                        break Label_0045;
                    }
                }
                while (i < n7) {
                    int n8;
                    int n10;
                    if (n4 == 0) {
                        n8 = (byte)((i * 20 + n2) / 20);
                        int n9;
                        if (n3 >= 0) {
                            n9 = (n + n3 + 19) / 20;
                        }
                        else {
                            n9 = (n + n3) / 20;
                        }
                        n10 = (byte)n9;
                    }
                    else {
                        final byte b2 = (byte)((i * 20 + n) / 20);
                        int n11;
                        if (n4 >= 0) {
                            n11 = (n2 + n4 + 19) / 20;
                        }
                        else {
                            n11 = (n2 + n4) / 20;
                        }
                        final byte b3 = (byte)n11;
                        n10 = b2;
                        n8 = b3;
                    }
                    if (b) {
                        if (this.worldData[n10][n8] != 0) {
                            return (byte)this.worldData[n10][n8];
                        }
                    }
                    else if (this.isCan_not_pass(n10, n8)) {
                        return 1;
                    }
                    i = (byte)(i + 1);
                }
                return 0;
            }
            int n7 = 2;
            int i = n5;
            continue;
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
    
    private void dialog(final String s) {
        final int width__ = Constants_H.WIDTH__;
        final int height__ = Constants_H.HEIGHT__;
        final int n = height__ - 8 - 25 * 2;
        final int n2 = 25 * 2 + 11;
        final byte b = 0;
        Ui.i().drawKuang(4, height__ - n2 - 4, width__ - 4, n2 + 4);
        byte b2 = b;
        if (s != null) {
            int n3;
            if (this.faceDir) {
                n3 = width__ - 50;
            }
            else {
                n3 = 50;
            }
            int n4;
            if (this.faceDir) {
                n4 = height__ - n2 - 4;
            }
            else {
                n4 = height__ - n2 - 4 - 25;
            }
            this.drawNpcFace(n3, n4, 0x1 | 0x20);
            Ui.i().drawKuang(0, n - n2 + 25, Ms.i().getStringWidth(s) + 16, 25 + 8);
            Ui.i().drawString(s, 8, n - n2 + 2 + 25, 0, 9, 1);
            Log.e("sk", "dialog");
            b2 = b;
        }
        while (b2 < 2 && this.dialog_no + b2 < this.dialog.length) {
            Ui.i().drawStringColor(this.dialog[this.dialog_no + b2].toString(), 10, b2 * 25 + (n - 2), -1, 1);
            ++b2;
        }
    }
    
    private void drawAnoleSel() {
        this.gr.cur_a = (byte)Ms.i().mathSpeedN(this.gr.cur_a, 25 * 2 + 12, 8, false);
        Ui.i().drawK1(0, Constants_H.HEIGHT - this.gr.cur_a - 2, 119, 25 + 4 + 2, 2);
        Ui.i().drawK2(0, Constants_H.HEIGHT + 25 + 4 - this.gr.cur_a, Constants_H.WIDTH, 25 + 8, 0);
        for (byte anoleSel = 0; anoleSel < 5; ++anoleSel) {
            int n;
            int n2;
            if (!this.isAnoleType(anoleSel)) {
                n = 6;
                n2 = (byte)(anoleSel + 70);
            }
            else {
                int n3;
                if (anoleSel == this.anoleSel) {
                    n3 = 1;
                }
                else {
                    n3 = 0;
                }
                n = (byte)n3;
                if (anoleSel == this.anole_type) {
                    n2 = 69;
                }
                else {
                    int n4;
                    if (anoleSel == this.anoleSel) {
                        n4 = anoleSel + 5;
                    }
                    else {
                        n4 = anoleSel;
                    }
                    n2 = (byte)n4;
                }
            }
            Ui.i().drawK0(Constants_H.WIDTH * anoleSel / 6 + 42, Constants_H.HEIGHT + 25 + 8 - this.gr.cur_a, 20, 20, n);
            Ui.i().drawUi(n2, Constants_H.WIDTH * anoleSel / 6 + 42 + 10, Constants_H.HEIGHT + 25 + 8 - this.gr.cur_a + 18, 33, 0);
            if (this.pkey.isSelect(Constants_H.WIDTH * anoleSel / 6 + 42, Constants_H.HEIGHT + 25 + 8 - this.gr.cur_a, 20, 20)) {
                if (this.anoleSel == anoleSel) {
                    this.pkey.setKeySoftkey1();
                }
                else {
                    this.anoleSel = anoleSel;
                }
            }
        }
        int n5;
        if (this.anoleSel == this.anole_type) {
            n5 = 0;
        }
        else {
            int n6;
            if (this.isAnoleType(this.anoleSel)) {
                n6 = this.anoleSel + 1;
            }
            else {
                n6 = 6;
            }
            n5 = (byte)n6;
        }
        Log.e("sk", "drawAnoleSel");
        Ui.i().drawString(this.gr.about_a[n5].toString(), 60, Constants_H.HEIGHT - this.gr.cur_a - 2, 17, 1, 2);
        Ui.i().drawK4(this.anoleSel * Constants_H.WIDTH / 6 + 41 + this.gr.cur_b / 3, Constants_H.HEIGHT + 25 + 7 - this.gr.cur_a + this.gr.cur_b / 3, 22 - (this.gr.cur_b / 3 << 1), 22 - (this.gr.cur_b / 3 << 1));
        final GameRun gr = this.gr;
        final byte cur_b = gr.cur_b;
        gr.cur_b = (byte)(cur_b + 1);
        if (cur_b > 4) {
            this.gr.cur_b = 0;
        }
        Ui.i().drawYesNo_(false, true);
    }
    
    private void drawBrow() {
        for (int i = 0; i < this.npcList.length; i = (byte)(i + 1)) {
            final byte b = this.npcList[i];
            if (b >= -1) {
                if (b == -1) {
                    Map.cur_npc = this.my;
                }
                else {
                    Map.cur_npc = this.npc[0][b];
                }
                if ((Map.cur_npc.other[4] == 1 || Map.cur_npc.other[4] == 2) && (Map.cur_npc.brow_type > -1 || Map.cur_npc.other[6] != 0) && (b <= -1 || this.isNpcSrc(Map.cur_npc.x, Map.cur_npc.y))) {
                    if (Map.cur_npc.other[6] != 0) {
                        Map.cur_npc.brow_type = Map.cur_npc.other[6];
                    }
                    if (Map.cur_npc.brow_action >= this.brow.aLength(Map.cur_npc.brow_type)) {
                        if (Map.cur_npc.other[6] == 0) {
                            Map.cur_npc.brow_type = -1;
                            continue;
                        }
                        Map.cur_npc.brow_action = 0;
                    }
                    Ui.i().drawFrameOne(this.brow, this.brow.action((int)Map.cur_npc.brow_type, (int)Map.cur_npc.brow_action, 0), this.map_x + Map.cur_npc.x + 14, this.map_y + Map.cur_npc.y - 15 - 10, 0);
                    final Npc cur_npc = Map.cur_npc;
                    if (++cur_npc.brow_time > this.brow.action(Map.cur_npc.brow_type, Map.cur_npc.brow_action, 1)) {
                        final Npc cur_npc2 = Map.cur_npc;
                        ++cur_npc2.brow_action;
                        Map.cur_npc.brow_time = 0;
                    }
                }
            }
        }
    }
    
    private void drawCheck5(final int n) {
        if (this.checkNpcT != -1 && this.my.state == 0) {
            this.drawHudong();
            if (this.checkNpcT >= 0 && this.npc[0][this.checkNpcT].other[6] == 0) {
                this.drawHudong();
                Ui.i().drawFrameOne(this.brow, this.brow.action(n, (int)this.action_5, 0), this.map_x + this.npc[0][this.checkNpcT].x + 10, this.map_y + this.npc[0][this.checkNpcT].y - 16 - 10, 0);
                if (++this.time_5 > this.brow.action(n, this.action_5, 1)) {
                    if (++this.action_5 >= this.brow.aLength(n)) {
                        this.action_5 = 0;
                    }
                    this.time_5 = 0;
                }
            }
        }
    }
    
    private void drawCloud() {
        if (this.imgCloud != null) {
            for (int i = 0; i < this.cloud.length; i = (byte)(i + 1)) {
                Ui.i().drawImage(this.imgCloud, this.map_x + this.cloud[i][0], this.map_y + this.cloud[i][1], 0);
            }
            for (int j = 0; j < this.cloud.length; j = (byte)(j + 1)) {
                if (!this.isNpcSrc(this.cloud[j][0], this.cloud[j][1])) {
                    this.addCloud(j);
                }
                else {
                    final short[] array = this.cloud[j];
                    array[0] -= this.cloud[j][2];
                }
            }
        }
    }
    
    private void drawHudong() {
        Ui.i().drawImage(this.hudong, Constants_H.WIDTH_H, Constants_H.HEIGHT - 30, 3);
    }
    
    private void drawMapRect(final byte b, final byte b2, final int n, final boolean b3) {
        int n2 = b * 6;
        int n3 = b2 * 6;
        if (this.miniMapMode) {
            n2 = this.mapdataMap[n][6] * b;
            n3 = this.mapdataMap[n][7] * b2;
        }
        if (b3) {
            Ui.i().drawRectZ(12352252, this.mapdataMap[n][0] * b + this.mapoffx, this.mapdataMap[n][1] * b2 + this.mapoffy, n2, n3, 5);
        }
        else {
            if (n == this.myMiniMap) {
                Ui.i().drawK1(this.mapoffx + this.mapdataMap[n][0] * b, this.mapoffy + this.mapdataMap[n][1] * b2, n2, n3, 4);
            }
            else {
                Ui.i().drawK0(this.mapoffx + this.mapdataMap[n][0] * b, this.mapoffy + this.mapdataMap[n][1] * b2, n2, n3, 2);
            }
            final GameRun gr = this.gr;
            final String nameCity = this.gr.getNameCity(n);
            final byte b4 = this.mapdataMap[n][0];
            final short mapoffx = this.mapoffx;
            final byte b5 = this.mapdataMap[n][1];
            final short mapoffy = this.mapoffy;
            int n4;
            if (n == this.myMiniMap) {
                n4 = 0;
            }
            else {
                n4 = 3;
            }
            gr.showStringM(nameCity, b4 * b + mapoffx + (n2 >> 1), b5 * b2 + mapoffy + (n3 >> 1) - 25, 4, n4);
            if (n == this.myMiniMap) {
                Ui.i().drawUi(67, this.mapdataMap[n][0] * b + this.mapoffx + (n2 >> 1), this.mapdataMap[n][1] * b2 + this.mapoffy + (n3 >> 1), 3, 0);
            }
        }
    }
    
    private void drawMapRect(final Graphics graphics) {
        int i = 0;
        graphics.setColor(0);
        while (i < this.gr.mapRect.length) {
            if (!Ms.i().isRect(this.my.x, this.my.y, 19, 19, this.gr.mapRect[i][0] * 20, this.gr.mapRect[i][1] * 20, (this.gr.mapRect[i][2] - this.gr.mapRect[i][0] + 1) * 20, (this.gr.mapRect[i][3] - this.gr.mapRect[i][1] + 1) * 20)) {
                for (int j = 4; j < this.gr.mapRect[i].length; j = (byte)(j + 4)) {
                    graphics.fillRect(this.map_x + this.gr.mapRect[i][j] * 20, this.map_y + this.gr.mapRect[i][j + 1] * 20, (this.gr.mapRect[i][j + 2] - this.gr.mapRect[i][j] + 1) * 20, (this.gr.mapRect[i][j + 3] - this.gr.mapRect[i][j + 1] + 1) * 20);
                }
            }
            i = (byte)(i + 1);
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
        Ui.i().drawString("\u6e38\u620f\u5730\u56fe", 320, 4, 17, 1, 2);
        if (this.showArea == -1) {
            Ui.i().drawString("\u8be5\u533a\u57df\u6ca1\u6709\u5730\u56fe\uff01", 320, 360 - 4 - 29 * 2, 0x10 | 0x1, 3, 0);
        }
        else {
            this.gr.showStringM("\u4eba\u7269\u5f53\u524d\u4f4d\u7f6e\uff1a" + this.gr.getNameCity((int)this.myMiniMap), 320, 360 - 4 - 29 * 2, 10, 3);
            Map.g.setClip(6, 33, 640 - 12, 360 - 15 - 29 * 3);
            final int n = 0;
            final byte b = this.mapdataMap[this.selectMap][0];
            int n2;
            if (this.miniMapMode) {
                n2 = this.mapdataMap[this.selectMap][6] * 18 / 2;
            }
            else {
                n2 = 25;
            }
            this.mapoffx = Ms.i().mathSpeedN(this.mapoffx, 320 - b * 18 - n2, 10, false);
            final int n3 = this.littleMapClipY / 2;
            final byte b2 = this.mapdataMap[this.selectMap][1];
            int n4;
            if (this.miniMapMode) {
                n4 = this.mapdataMap[this.selectMap][7] * 12 / 2;
            }
            else {
                n4 = 15;
            }
            this.mapoffy = Ms.i().mathSpeedN(this.mapoffy, n3 - b2 * 12 - n4, 10, false);
            for (int i = n; i < this.mapdataArea[this.showArea].length; i = (byte)(i + 1)) {
                final byte selectMap = this.mapdataArea[this.showArea][i];
                if (selectMap >= 0 && this.mapdataMap[selectMap].length > 0) {
                    if (this.pkey.isSelect(this.mapdataMap[selectMap][0] * 18 + this.mapoffx, this.mapdataMap[selectMap][1] * 12 + this.mapoffy, 18 * 6, 12 * 6)) {
                        this.selectMap = selectMap;
                    }
                    if (this.miniMapMode || selectMap != this.myMiniMap) {
                        this.drawMapRect(18, (byte)12, (int)selectMap, false);
                    }
                }
            }
            if (!this.miniMapMode) {
                this.drawMapRect(18, (byte)12, (int)this.myMiniMap, false);
            }
            this.drawMapRect(18, (byte)12, (int)this.selectMap, true);
            Map.g.setClip(0, 0, 640, 360);
        }
    }
    
    private void drawMission() {
        Ui.i().fillRectB();
        Ui.i().drawK2(1, 6, 640 - 2, 360 - 6, 0);
        Ui.i().drawK1(8, 41, 640 - 26, this.gr.line_max * 29 + 10, 1);
        Ui.i().drawK1(8, this.gr.line_max * 29 + 59, 640 - 16, 125, 2);
        final byte line_max = this.gr.line_max;
        final byte[] array = this.gr.select[0];
        int length;
        if (this.gr.cur_a == 0) {
            length = this.bMission[14] + 1;
        }
        else {
            length = this.mDirect.length;
        }
        this.drawMisstionList(8, 41 + 6, 640 - 26, 29, line_max, array, length);
        for (int n = 0; this.gr.about_a != null && n < this.gr.about_a.length; n = (byte)(n + 1)) {
            Ui.i().drawStringColor(this.gr.about_a[n].toString(), 25, this.gr.line_max * 29 + 61 + n * 25, 3, 0);
        }
        final byte selectMenuX = this.pkey.selectMenuX(2, 0, 0, 320, 40);
        if (selectMenuX != -1) {
            this.goMission(this.gr.cur_a = selectMenuX, this.bPause);
        }
        final Ui i = Ui.i();
        int n2;
        if (this.gr.cur_a == 0) {
            n2 = 320 - 125;
        }
        else {
            n2 = 320 + 25;
        }
        i.drawK1(n2, 9, 100, 29, 4);
        final Ui j = Ui.i();
        int n3;
        if (this.gr.cur_a == 0) {
            n3 = 0;
        }
        else {
            n3 = 1;
        }
        j.drawString("\u4e3b\u7ebf\u4efb\u52a1", 320 - 75, 9, 17, n3, 0);
        final Ui k = Ui.i();
        int n4;
        if (this.gr.cur_a == 1) {
            n4 = 0;
        }
        else {
            n4 = 1;
        }
        k.drawString("\u5206\u652f\u4efb\u52a1", 320 + 75, 9, 17, n4, 0);
        Ui.i().drawTriangle(320, 20, 150, true, true);
        final Ui l = Ui.i();
        String obj;
        if (this.gr.cur_a == 0) {
            obj = "\u4e3b\u7ebf\u5b8c\u6210\u5ea6\uff1a";
        }
        else {
            obj = "\u5206\u652f\u5b8c\u6210\u5ea6\uff1a";
        }
        final StringBuilder sb = new StringBuilder(String.valueOf(obj));
        final Ms m = Ms.i();
        final byte[] bMission = this.bMission;
        int n5;
        if (this.gr.cur_a == 0) {
            n5 = 14;
        }
        else {
            n5 = 15;
        }
        final byte b = bMission[n5];
        int length2;
        if (this.gr.cur_a == 0) {
            length2 = this.sMission.length - 1;
        }
        else {
            length2 = this.sMission.length;
        }
        l.drawString(sb.append(m.getPrecision(b * 1000 / length2)).append("%").toString(), 320, 360 - 1, 33, -1, 1);
        Ui.i().drawYesNo(false, true);
    }
    
    private void drawMisstionList(final int n, final int n2, final int n3, final int n4, final int n5, final byte[] array, final int n6) {
        byte b = array[1];
        Ui.i().drawListKY(n5, n, n2, n3, 6, n4, -1, array[0] - array[1], 4, 2);
        while (b < array[1] + n5) {
            if (b < n6) {
                String s;
                if (this.gr.cur_a == 0) {
                    s = String.valueOf(b + 1) + "\u3001" + this.sMission[b][0].toString();
                }
                else {
                    s = String.valueOf(b + 1) + "\u3001" + this.sMission[this.mDirect[b]][0].toString();
                }
                Log.e("sk", "drawMisstionList");
                final Ui i = Ui.i();
                final byte b2 = array[1];
                int n7;
                if (b < this.bMission[14]) {
                    n7 = -1;
                }
                else if (array[0] == b) {
                    n7 = 0;
                }
                else {
                    n7 = 3;
                }
                i.drawString(s, n + 8, (b - b2) * (n4 - 1) + n2, 0, n7, 0);
                if (this.gr.cur_a == 0 && b != n6 - 1) {
                    final Ui j = Ui.i();
                    final byte b3 = array[1];
                    int n8;
                    if (b < this.bMission[14]) {
                        n8 = -1;
                    }
                    else if (array[0] == b) {
                        n8 = 0;
                    }
                    else {
                        n8 = 3;
                    }
                    j.drawString("\u5b8c\u6210", n + n3 - 8, n2 + (b - b3) * (n4 - 1), 24, n8, 0);
                }
                if (this.pkey.isSelect(0, (b - array[1]) * (n4 - 1) + n2, 640, n4 - 1)) {
                    array[0] = b;
                    if (b - array[1] == 0 && array[1] > 0) {
                        --array[1];
                    }
                    else if (b - array[1] == n5 - 1 && array[1] + n5 < n6) {
                        ++array[1];
                    }
                    if (this.gr.cur_a == 0) {
                        this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), 640 - 50, 0);
                    }
                    else if (this.mDirect.length > 0) {
                        this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 640 - 50, 0);
                    }
                }
            }
            ++b;
        }
        Ui.i().sliding(n + n3 + 4, n2, n5 * n4, array[0], n6, true);
    }
    
    private void drawMySave() {
        this.gr.showString("\u662f\u5426\u5b58\u76d8?", 285, 0);
        Ui.i().drawYesNo(true, true);
    }
    
    private void drawNMAni(final Npc[] array) {
        if (array != null) {
            for (int i = 0; i < this.npcList.length; i = (byte)(i + 1)) {
                final byte b = this.npcList[i];
                if (b == -1) {
                    if (this.my.other[4] == 1 || this.my.other[4] == 2) {
                        this.drawMyAni(this.my, 0, this.map_x + this.my.x + 10, this.map_y + this.my.y + 19, this.my.other[7]);
                    }
                }
                else if (b < -1) {
                    Ms.i();
                    final byte b2 = (byte)(Ms.abs(b) - 2);
                    if (this.isNpcSrc(this.item[b2][0] * 20, this.item[b2][1] * 20)) {
                        final Ui j = Ui.i();
                        int n;
                        if (this.item[b2][2] == 2) {
                            n = 55;
                        }
                        else {
                            n = 54;
                        }
                        j.drawUi(n, this.map_x + this.item[b2][0] * 20 + 10, this.map_y + this.item[b2][1] * 20 + 20, 33, 0);
                    }
                }
                else {
                    if ((array[b].other[4] == 1 || array[b].other[4] == 2) && this.isNpcSrc(array[b].x, array[b].y)) {
                        if (array[b].other[8] != 3 && !this.npcNameData[b].equals("\u8def\u4eba")) {
                            Map.g.drawImage(this.imgShadow, this.map_x + array[b].x + 10, this.map_y + array[b].y + 20, 33);
                        }
                        this.drawNpcAniOne(array, b);
                    }
                    this.runNpcAniOne(array, b);
                }
            }
        }
    }
    
    private void drawNpcAni(final Npc[] array) {
        if (array != null) {
            for (int i = 0; i < array.length; i = (byte)(i + 1)) {
                if ((array[i].other[4] == 1 || array[i].other[4] == 2) && this.isNpcSrc(array[i].x, array[i].y)) {
                    this.drawNpcAniOne(array, i);
                }
                this.runNpcAniOne(array, i);
            }
        }
    }
    
    private void drawNpcAniOne(final Npc[] array, int n) {
        final byte b = (byte)(array[n].other[3] - 1);
        final byte b2 = array[n].other[2];
        final byte b3 = array[n].other[7];
        int now_action = array[n].now_action;
        byte b4 = b3;
        if (b3 < 0) {
            array[n].dir = 4;
            b4 = (byte)(-b3);
        }
        Label_0167: {
            if (array[n].now_action < Map.npcSp[b][b2].aLength(b4)) {
                break Label_0167;
            }
            final Npc npc = array[n];
            final int n2 = 0;
            npc.now_action = 0;
            if (array[n].other[8] == -4) {
                array[n].other[8] = 0;
                array[n].other[4] = 0;
            }
            else {
                now_action = n2;
                if (array[n].bdir) {
                    break Label_0167;
                }
                now_action = n2;
                if (!this.setlastA(array, n)) {
                    break Label_0167;
                }
                this.drawNpcAniOne(array, n);
            }
            return;
        }
        final Ui i = Ui.i();
        final Sprite sprite = Map.npcSp[b][b2];
        final int action = Map.npcSp[b][b2].action(b4, now_action, 0);
        final int map_x = this.map_x;
        final short x = array[n].x;
        final int map_y = this.map_y;
        final short y = array[n].y;
        if (array[n].dir == 4) {
            n = 1;
        }
        else {
            n = 0;
        }
        i.drawFrameOne(sprite, action, map_x + x + 10, map_y + y + 19, n);
    }
    
    private void drawNpcFace(final int n, final int n2, final int n3) {
        if (this.imgFace != null) {
            Ui.i().drawImage(this.imgFace, this.face_c + n, n2, n3);
        }
        this.face_c = Ms.i().mathSpeedN(this.face_c, 0, 20, false);
    }
    
    private void drawSrcEffect() {
        boolean b = false;
        final int width__ = Constants_H.WIDTH__;
        final int height__ = Constants_H.HEIGHT__;
        if (this.srcFlash_c > 0) {
            final byte srcFlash_c = this.srcFlash_c;
            this.srcFlash_c = (byte)(srcFlash_c - 1);
            if (srcFlash_c % 2 == 0) {
                Ui.i().fillRect(16777215, 0, 0, width__, height__);
            }
        }
        if (this.bSrc) {
            final int src_BATTLE_H__ = Constants_H.SRC_BATTLE_H__;
            Map.g.setColor(0);
            Map.g.fillRect(0, this.black_width - src_BATTLE_H__ - this.bSrc_c, width__, src_BATTLE_H__);
            Map.g.fillRect(0, height__ - this.black_width + this.bSrc_c, width__, src_BATTLE_H__);
        }
        if (this.my.state == 22) {
            final Graphics g = Map.g;
            int n;
            if (this.eventGoing == 2) {
                n = height__ - this.gr.about_d.length * 29 >> 1;
            }
            else {
                n = 45;
            }
            if (this.eventGoing == 2) {
                b = true;
            }
            this.drawBlackSRC(g, n, b);
        }
    }
    
    private void drawStep(final Graphics graphics, final int n, final int n2, final int n3) {
        if (this.bStep > 0) {
            graphics.setColor(3947323);
            graphics.drawRect(n + 1, n2, n3 - 2, n3);
            graphics.drawRect(n, n2 + 1, n3, n3 - 2);
            graphics.setColor(13421772);
            graphics.drawRect(n + 2, n2 + 1, n3 - 4, n3 - 2);
            graphics.drawRect(n + 1, n2 + 2, n3 - 2, n3 - 4);
            Ui.i().fillRect(16777215, n + 2, n2 + 2, n3 - 3, n3 - 3);
            Ui.i().drawUi(67, (n3 >> 1) + n, (n3 >> 1) + n2, 0x2 | 0x1, 0);
            if (this.bStep % 12 < 6) {
                Ui.i().drawLine(15597568, n + n3 - 1, n2, n, n2 + n3 - 1);
                Ui.i().drawLine(0, n + n3, n2, n, n2 + n3);
                Ui.i().drawLine(15597568, n + n3, n2 + 1, n + 1, n2 + n3);
            }
            if (--this.bStep < 2) {
                this.bStep = 100;
            }
        }
    }
    
    private void exitBoss(final int n, final int n2, final int n3, final int n4) {
        this.chuansong(n, 0);
        this.bExitBoss = true;
        this.my.setXY(n2, n3, 0, 0);
        this.my.dir = (byte)n4;
    }
    
    private void getInMap(final byte b, final byte[][] array) {
        this.my.dir = (byte)((array[b][2] - 1) / 2 * 2 + 1 + array[b][2] % 2);
        this.my.setXY(array[b][0], array[b][1], 0, 0);
    }
    
    private void getItem() {
        if (this.item[this.get_meet][2] == 2) {
            this.gr.say("\u8fd9\u4e2a\u5b9d\u7bb1\u662f\u7a7a\u7684\u3002", 0);
        }
        else {
            final byte b = (byte)(this.item[this.get_meet][3] - 2);
            if (b == -2) {
                final GameRun gr = this.gr;
                gr.money += this.item[this.get_meet][4] * 100;
                this.gr.say("\u83b7\u5f97\u91d1\u94b1\uff1a" + this.item[this.get_meet][4] * 100 + "\u91d1", 0);
            }
            else if (b == -1) {
                final GameRun gr2 = this.gr;
                gr2.coin += this.item[this.get_meet][4];
                this.gr.say("\u83b7\u5f97\u5fbd\u7ae0\uff1a" + this.item[this.get_meet][4] + "\u5fbd\u7ae0", 0);
            }
            else {
                this.gr.getItem(b, this.item[this.get_meet][4]);
            }
            this.item[this.get_meet][2] = 2;
        }
    }
    
    private void getItemData(final ByteArrayOutputStream byteArrayOutputStream, final byte[][] array) {
        try {
            byteArrayOutputStream.write(array.length);
            for (int i = 0; i < array.length; ++i) {
                byteArrayOutputStream.write(array[i].length);
                byteArrayOutputStream.write(array[i]);
            }
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void getNpcData(final ByteArrayOutputStream byteArrayOutputStream, final Npc[] array) {
        int i = 0;
        try {
            while (i < array.length) {
                if (array[i].other[9] == 1) {
                    byteArrayOutputStream.write(array[i].other);
                }
                ++i;
            }
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private byte[] getNpcData() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.getNpcData(byteArrayOutputStream, this.npc[0]);
        this.getNpcData(byteArrayOutputStream, this.npc[1]);
        this.getNpcData(byteArrayOutputStream, this.npc[2]);
        this.getItemData(byteArrayOutputStream, this.item);
        this.getItemData(byteArrayOutputStream, this.door);
        return byteArrayOutputStream.toByteArray();
    }
    
    private byte getNpcId(final int n) {
        return (byte)(this.npcPos[n] & 0x3F);
    }
    
    private byte getNpcLayer(final int n) {
        return (byte)((this.npcPos[n] & 0xFF) >> 6);
    }
    
    private short getNpcListY(final int n) {
        short y;
        if (this.npcList[n] == -1) {
            y = (short)(this.my.y + this.dir_select[this.my.dir][1] * this.my.speed);
        }
        else if (this.npcList[n] < -1) {
            final byte[][] item = this.item;
            Ms.i();
            y = (short)(item[Ms.abs(this.npcList[n]) - 2][1] * 20);
        }
        else {
            y = this.npc[0][this.npcList[n]].y;
        }
        return y;
    }
    
    private void ifEvent(final int n, final int n2, final int n3, final int n4, final boolean b) {
        if (this.setSIfElse(n4, b, true)) {
            final short[] event_now = this.event_now;
            event_now[n] += (short)n2;
            this.nextEvent(n3);
        }
        else if (this.setSIfElse(n4, b, false)) {
            this.setEventNow(n, false);
        }
    }
    
    private void init() {
        this.initBrowImage();
        this.initWalkIco();
        this.initHudong();
        this.configureNpc();
        if (Map.npcSp[1][0] == null) {
            Map.npcSp[1][0] = new Sprite();
            this.my = new Npc(8);
            this.my.other[4] = 1;
            this.setAnole();
        }
        if (this.imgShadow == null) {
            this.imgShadow = Ms.i().createImage("data/shadow");
        }
    }
    
    private boolean initAuto(final Npc npc, final int n) {
        boolean b;
        if (npc.timeMove == 0) {
            if (npc.frame_c == -1) {
                Ms.i();
                npc.b_auto = (Ms.getRandom(100) < 50);
                Ms.i();
                if (Ms.getRandom(100) >= 50) {
                    return true;
                }
                Ms.i();
                npc.timeMove = (byte)(-(Ms.getRandom(n) + 20));
                npc.setActionNo(false);
                b = false;
            }
            else {
                b = false;
            }
        }
        else {
            if (npc.timeMove >= 0) {
                return true;
            }
            ++npc.timeMove;
            b = false;
        }
        return b;
        b = true;
        return b;
    }
    
    private void initBoat(final int n) {
        this.my.state = 9;
        this.anole_type = 5;
        this.setAnole();
        this.boatSelect = (byte)n;
        this.gr.cur_a = 0;
        this.my.setIXY(this.boatCourse[this.boatSelect][this.gr.cur_a], this.boatCourse[this.boatSelect][this.gr.cur_a + 1]);
    }
    
    private void initCloud() {
        if (this.mapNo == 24 || this.mapNo == 25 || this.mapNo == 26 || this.mapNo == 49 || this.mapNo == 50) {
            if (this.imgCloud == null) {
                this.imgCloud = Ms.i().createImage("data/cloud");
                this.cloud = null;
                this.cloud = new short[4][3];
            }
            for (int i = 0; i < this.cloud.length; i = (byte)(i + 1)) {
                this.addCloud(i);
            }
        }
        else {
            this.cloud = null;
            this.imgCloud = null;
        }
    }
    
    private void initHudong() {
        this.hudong = Ms.i().createImage("data/brow/hudong");
    }
    
    private void initMissionList() {
        final byte[] rmsOptions = Ms.i().rmsOptions(7, null, 1);
        if (rmsOptions[0] == -1) {
            this.bMission = null;
        }
        else {
            this.bMission = rmsOptions;
        }
        final byte[] array = (byte[])null;
        if (this.bMission == null) {
            this.bMission = new byte[20];
        }
        Ms.i();
        Ms.skip = 0;
        this.sMission = Ms.i().createString2Array(Ms.i().getStream("data/mission0.t", -1));
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
    
    private void initNpcAni_1(int i, final int n, final byte[] array) {
        --i;
        while (i > 0) {
            if (array[i] != 0) {
                if (Map.npcSp[n][i] == null) {
                    this.initNpcAniOne(new StringBuilder().append(i).toString(), i, n);
                }
            }
            else {
                Map.npcSp[n][i] = null;
            }
            --i;
        }
    }
    
    private boolean isAnole(final int n, final int n2, int n3) {
        if (n3 == 0) {
            n3 = 3;
        }
        else if (n3 == 2) {
            n3 = 4;
        }
        else {
            if (n3 != 4) {
                return false;
            }
            n3 = 2;
        }
        int n4 = 0;
        if (n % 20 != 0) {
            n4 = 0 + 1;
        }
        int n5 = n4;
        if (n2 % 20 != 0) {
            n5 = (byte)(n4 + 1);
        }
        final byte b2 = (byte)(1 << n5);
        boolean b;
        if (b2 == 4 && this.worldData[(n + 19) / 20][n2 / 20] == n3) {
            b = true;
        }
        else {
            if (b2 > 1) {
                if (n % 20 != 0 && this.worldData[(n + 19) / 20][(n2 + 19) / 20] == n3) {
                    b = true;
                    return b;
                }
                if (n2 % 20 != 0 && this.worldData[n / 20][n2 / 20] == n3) {
                    b = true;
                    return b;
                }
            }
            b = (this.worldData[n / 20][n2 / 20] == n3);
        }
        return b;
    }
    
    private boolean isAnoleType(final int n) {
        return (this.gr.rmsOther[2] & 1 << n) != 0x0;
    }
    
    private boolean isAuto_canMove(final Npc npc, final int n, final int n2) {
        return this.checkWorld(npc.x, npc.y, n, n2, false) != 1 && !Ms.i().isRect(npc.x + n, npc.y + n2, 19, 19, this.my.x, this.my.y, 19, 19);
    }
    
    private boolean isCan_not_pass(final int n, final int n2) {
        boolean b;
        if (this.worldData[n][n2] == 1) {
            b = true;
        }
        else if (this.anole_type == 0) {
            b = (this.worldData[n][n2] == 2 || this.worldData[n][n2] == 4);
        }
        else if (this.anole_type == 2) {
            b = (this.worldData[n][n2] == 3 || this.worldData[n][n2] == 2);
        }
        else if (this.anole_type == 4) {
            b = (this.worldData[n][n2] != 2);
        }
        else {
            b = (this.worldData[n][n2] == 2 || this.worldData[n][n2] == 3 || this.worldData[n][n2] == 4);
        }
        return b;
    }
    
    private boolean isCheckAnole(final int n) {
        boolean b;
        if (this.anole_type != n && this.isAnoleType(n)) {
            this.anole_type = (byte)n;
            this.setAnole();
            b = true;
        }
        else {
            if (!this.isAnoleType(n)) {
                this.gr.say("\u6ca1\u6709" + (Object)this.gr.monsterT[n] + "\u5750\u9a91" + "\uff0c\u4e0d\u80fd\u901a\u8fc7\u8be5\u5730\u5f62", -1);
            }
            b = false;
        }
        return b;
    }
    
    private boolean isCheckNpcOff() {
        boolean b;
        if (this.checkNpcT < 0) {
            b = false;
        }
        else {
            if (this.my.speed_x != 0) {
                Ms.i();
                final byte b2 = (byte)(20 - Ms.abs(this.my.y - this.npc[0][this.checkNpcT].y));
                if (b2 > 0 && b2 < 11) {
                    b = true;
                    return b;
                }
            }
            else if (this.my.speed_y != 0) {
                Ms.i();
                final byte b3 = (byte)(20 - Ms.abs(this.my.x - this.npc[0][this.checkNpcT].x));
                if (b3 > 0 && b3 < 11) {
                    b = true;
                    return b;
                }
            }
            b = false;
        }
        return b;
    }
    
    private byte isMapChenk(byte b) {
        byte b2 = 0;
        byte b3 = 0;
        final byte b4 = (byte)(this.my.x / 20);
        final byte b5 = (byte)(this.my.y / 20);
        if (this.my.speed_x == 0) {
            byte b6;
            if (this.my.x % 20 != 0) {
                b6 = 0;
            }
            else {
                b6 = 1;
            }
            byte b7;
            if (this.my.speed_y >= 0) {
                b7 = 1;
            }
            else {
                b7 = -1;
            }
            b2 = this.checkMap((b4 - b6) * 20, (b7 + b5) * 20, 0, 0);
            byte b8;
            if (this.my.speed_y >= 0) {
                b8 = 1;
            }
            else {
                b8 = -1;
            }
            b3 = this.checkMap((b4 + 1) * 20, (b8 + b5) * 20, 0, 0);
        }
        else if (this.my.speed_y == 0) {
            byte b9;
            if (this.my.speed_x >= 0) {
                b9 = 1;
            }
            else {
                b9 = -1;
            }
            byte b10;
            if (this.my.y % 20 != 0) {
                b10 = 0;
            }
            else {
                b10 = 1;
            }
            b2 = this.checkMap((b9 + b4) * 20, (b5 - b10) * 20, 0, 0);
            byte b11;
            if (this.my.speed_x >= 0) {
                b11 = 1;
            }
            else {
                b11 = -1;
            }
            b3 = this.checkMap((b11 + b4) * 20, (b5 + 1) * 20, 0, 0);
        }
        if (b2 != 1 || b3 != 1) {
            if (b2 == 0) {
                int n;
                if (this.my.speed_x == 0) {
                    byte b12;
                    if (this.my.x % 20 != 0) {
                        b12 = 0;
                    }
                    else {
                        b12 = 1;
                    }
                    n = b4 - b12;
                }
                else {
                    n = b4;
                }
                int n2;
                if (this.my.speed_y == 0) {
                    byte b13;
                    if (this.my.y % 20 != 0) {
                        b13 = 0;
                    }
                    else {
                        b13 = 1;
                    }
                    n2 = b5 - b13;
                }
                else {
                    n2 = b5;
                }
                if (this.checkMap(n * 20, n2 * 20, 0, 0) == 0) {
                    b = -1;
                    return b;
                }
            }
            if (b3 == 0) {
                int n3;
                if (this.my.speed_x == 0) {
                    byte b14;
                    if (this.my.x % 20 != 0) {
                        b14 = 0;
                    }
                    else {
                        b14 = 1;
                    }
                    n3 = b14 + b4;
                }
                else {
                    n3 = b4;
                }
                int n4;
                if (this.my.speed_y == 0) {
                    byte b15;
                    if (this.my.y % 20 != 0) {
                        b15 = 0;
                    }
                    else {
                        b15 = 1;
                    }
                    n4 = b15 + b5;
                }
                else {
                    n4 = b5;
                }
                if (this.checkMap(n3 * 20, n4 * 20, 0, 0) == 0) {
                    b = -2;
                }
            }
        }
        return b;
    }
    
    private boolean isMapEvent(final int n, final int n2) {
        return (this.mapInfo[n * 2 + 1] & 1 << n2) != 0x0;
    }
    
    private boolean isMission(int n) {
        final byte b = (byte)(n / 8);
        n = (byte)(n % 8);
        return (this.bMission[b] & 1 << n) != 0x0;
    }
    
    private boolean isNpcSrc(final int n, final int n2) {
        return this.map_x + n >= -80 && this.map_x + n <= Constants_H.WIDTH + 60 && this.map_y + n2 >= -80 && this.map_y + n2 <= Constants_H.HEIGHT + 60;
    }
    
    private boolean isTrundleNpc(final int n, final int n2) {
        final byte checkIfNpc = this.checkIfNpc(this.npc[0], n, n2);
        boolean b;
        if (checkIfNpc != -1) {
            b = (this.npc[0][checkIfNpc].other[4] == 1 || this.npc[0][checkIfNpc].other[4] == 3);
        }
        else {
            b = (n < 0 || n >= this.cols || n2 < 0 || n2 >= this.rows || this.worldData[n][n2] == 1);
        }
        return b;
    }
    
    private void keyAnoleSel() {
        if (!Ms.i().key_delay()) {
            if (Ms.i().key_Left_Right()) {
                this.anoleSel = Ms.i().select(this.anoleSel, 0, 4);
            }
            else if (Ms.i().key_S1()) {
                if (!this.isAnoleType(this.anoleSel)) {
                    this.gr.say("\u8fd8\u6ca1\u6709\u83b7\u5f97\u8be5\u9a91\u5ba0", 0);
                }
                else if (this.anoleSel == 4) {
                    this.gr.say("\u53ea\u80fd\u5728\u6c34\u91cc\u4f7f\u7528", 0);
                }
                else {
                    if (this.anole_type == this.anoleSel) {
                        this.anole_type = -1;
                    }
                    else {
                        this.anole_type = this.anoleSel;
                    }
                    if (this.gr.rmsSms[6] == 10 && this.anole_type == 3 && this.gr.rmsSms[0] == 0) {
                        SMSSender.i(this.gr).go(1, true);
                        this.anole_type = -1;
                    }
                    else {
                        if (this.anole_type == 3 && this.gr.rmsSms[0] == 0) {
                            this.gr.say("\u5947\u5f02\u517d\u4e0d\u4ec5\u8dd1\u5f97\u5feb\u800c\u4e14\u53ef\u4ee5\u4e0d\u9047\u654c\uff0c\u73b0\u63d0\u4f9b\u8bd5\u9a91\u4f53\u9a8c\uff0c\u6b63\u7248\u9a8c\u8bc1\u540e\u9700\u8d2d\u4e70\uff01", -1);
                        }
                        this.gr.magic_id = 13;
                        this.gr.magic_x = this.map_x + this.my.x + 10;
                        this.gr.magic_y = this.map_y + this.my.y + 19;
                        this.gr.setMagic(this.gr.magic_id / 5);
                        this.my.state = 21;
                    }
                }
                Ms.i().keyRelease();
            }
            else if (Ms.i().key_S2() || Ms.i().key_Num9()) {
                this.my.state = 0;
                Ms.i().keyRelease();
            }
        }
    }
    
    private void keyMiniMap() {
        Ms.i().keyRelease();
        if (!Ms.i().key_S1_Num5()) {
            if (Ms.i().key_S2() || Ms.i().key_Num0()) {
                this.my.state = 0;
                this.mapdataArea = null;
                this.mapdataMap = null;
            }
            else if ((Ms.i().key_Left_Right() || Ms.i().key_Up_Down()) && this.mapdataMap[this.selectMap].length >= 6 && this.mapdataMap[this.selectMap][Ms.abs(Ms.key) + 1] != -1) {
                this.selectMap = this.mapdataMap[this.selectMap][Ms.abs(Ms.key) + 1];
            }
        }
    }
    
    private void keyMission() {
        if (!Ms.i().key_delay()) {
            if (Ms.i().key_Left_Right() || (Ms.i().key_Num1() && this.gr.cur_a == 1) || (Ms.i().key_Num3() && this.gr.cur_a == 0)) {
                final GameRun gr = this.gr;
                gr.cur_a ^= 0x1;
                this.goMission(this.gr.cur_a, this.bPause);
            }
            else if (Ms.i().key_Up_Down()) {
                byte b;
                if (this.gr.cur_a == 0) {
                    int length;
                    if (this.bMission[14] + 1 > this.sMission.length) {
                        length = this.sMission.length;
                    }
                    else {
                        length = this.bMission[14] + 1;
                    }
                    b = (byte)length;
                }
                else {
                    b = (byte)this.mDirect.length;
                }
                Ms.i().selectS(this.gr.select[0], 0, b, this.gr.line_max);
                if (this.gr.cur_a == 0) {
                    this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), 640 - 50, 0);
                }
                else if (this.mDirect.length > 0) {
                    this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 640 - 50, 0);
                }
                else {
                    this.gr.about_a = null;
                }
            }
            else if (Ms.i().key_S2() || Ms.i().key_Num1() || Ms.i().key_Num3()) {
                this.my.state = 0;
                if (this.bPause) {
                    this.gr.doPaint(0);
                    GameRun.run_state = 97;
                }
                else {
                    GameRun.run_state = -10;
                }
                this.mDirect = null;
                this.sMission = null;
                this.gr.about_a = null;
                Ms.i().keyRelease();
            }
        }
    }
    
    private void keyMySave() {
        if (Ms.i().key_S1()) {
            this.my.state = 0;
            this.eventGoing = 2;
        }
        else if (Ms.i().key_S2()) {
            this.my.state = 0;
            this.eventGoing = 3;
        }
    }
    
    private void keySelectMenu() {
        if (!Ms.i().key_delay()) {
            if (Ms.i().key_S1_Num5()) {
                this.my.state = 13;
            }
            else if (Ms.i().key_Up_Down()) {
                this.gr.cur_a = Ms.i().select(this.gr.cur_a, 0, this.gr.action_str.length - 1);
            }
        }
    }
    
    private void loadMapData(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: newarray        B
        //     3: astore          13
        //     5: iconst_4       
        //     6: newarray        B
        //     8: astore          12
        //    10: aload_0        
        //    11: aconst_null    
        //    12: putfield        main/Map.bottomData:[S
        //    15: aload_0        
        //    16: aconst_null    
        //    17: putfield        main/Map.frontData:[S
        //    20: aload_0        
        //    21: aconst_null    
        //    22: putfield        main/Map.worldData:[[S
        //    25: new             Ljava/io/DataInputStream;
        //    28: astore          14
        //    30: new             Ljava/lang/StringBuilder;
        //    33: astore          15
        //    35: aload           15
        //    37: ldc_w           "/data/map/"
        //    40: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    43: aload           14
        //    45: aload           15
        //    47: iload_1        
        //    48: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    51: ldc_w           ".mid"
        //    54: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    57: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    60: invokestatic    com/android/Util/AndroidUtil.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //    63: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    66: aload           14
        //    68: ldc2_w          2
        //    71: invokevirtual   java/io/DataInputStream.skip:(J)J
        //    74: pop2           
        //    75: aload           14
        //    77: aload           12
        //    79: invokevirtual   java/io/DataInputStream.read:([B)I
        //    82: pop            
        //    83: invokestatic    dm/Ms.i:()Ldm/Ms;
        //    86: pop            
        //    87: aload_0        
        //    88: aload           12
        //    90: invokestatic    dm/Ms.getNum:([B)J
        //    93: l2i            
        //    94: putfield        main/Map.bgColor:I
        //    97: aload           14
        //    99: invokevirtual   java/io/DataInputStream.readByte:()B
        //   102: newarray        B
        //   104: astore          15
        //   106: aload           14
        //   108: aload           15
        //   110: invokevirtual   java/io/DataInputStream.read:([B)I
        //   113: pop            
        //   114: aload           14
        //   116: aload           15
        //   118: invokevirtual   java/io/DataInputStream.read:([B)I
        //   121: pop            
        //   122: invokestatic    dm/Ms.i:()Ldm/Ms;
        //   125: pop            
        //   126: aload_0        
        //   127: aload           15
        //   129: invokestatic    dm/Ms.getNum:([B)J
        //   132: l2i            
        //   133: i2b            
        //   134: putfield        main/Map.cols:S
        //   137: aload           14
        //   139: aload           15
        //   141: invokevirtual   java/io/DataInputStream.read:([B)I
        //   144: pop            
        //   145: invokestatic    dm/Ms.i:()Ldm/Ms;
        //   148: pop            
        //   149: aload_0        
        //   150: aload           15
        //   152: invokestatic    dm/Ms.getNum:([B)J
        //   155: l2i            
        //   156: i2b            
        //   157: putfield        main/Map.rows:S
        //   160: aload_0        
        //   161: getfield        main/Map.cols:S
        //   164: istore_3       
        //   165: aload_0        
        //   166: getfield        main/Map.rows:S
        //   169: istore_1       
        //   170: aload_0        
        //   171: iload_3        
        //   172: iload_1        
        //   173: multianewarray  [[S
        //   177: putfield        main/Map.worldData:[[S
        //   180: iconst_0       
        //   181: istore_3       
        //   182: iload_3        
        //   183: iconst_3       
        //   184: if_icmplt       211
        //   187: aload           14
        //   189: invokevirtual   java/io/DataInputStream.close:()V
        //   192: aconst_null    
        //   193: checkcast       [B
        //   196: astore          12
        //   198: aconst_null    
        //   199: checkcast       [B
        //   202: astore          12
        //   204: aconst_null    
        //   205: checkcast       [B
        //   208: astore          12
        //   210: return         
        //   211: aload           14
        //   213: invokevirtual   java/io/DataInputStream.readByte:()B
        //   216: istore          5
        //   218: iload           5
        //   220: iconst_m1      
        //   221: if_icmpne       232
        //   224: iload_3        
        //   225: iconst_1       
        //   226: iadd           
        //   227: i2b            
        //   228: istore_3       
        //   229: goto            182
        //   232: aload           14
        //   234: aload           12
        //   236: invokevirtual   java/io/DataInputStream.read:([B)I
        //   239: pop            
        //   240: invokestatic    dm/Ms.i:()Ldm/Ms;
        //   243: pop            
        //   244: aload           12
        //   246: invokestatic    dm/Ms.getNum:([B)J
        //   249: l2i            
        //   250: iconst_3       
        //   251: imul           
        //   252: istore          6
        //   254: iload           5
        //   256: tableswitch {
        //                2: 295
        //                3: 284
        //                4: 311
        //          default: 284
        //        }
        //   284: iconst_0       
        //   285: istore_1       
        //   286: iload_1        
        //   287: iload           6
        //   289: if_icmplt       322
        //   292: goto            224
        //   295: aload_0        
        //   296: iload           6
        //   298: newarray        S
        //   300: putfield        main/Map.bottomData:[S
        //   303: goto            284
        //   306: astore          12
        //   308: goto            210
        //   311: aload_0        
        //   312: iload           6
        //   314: newarray        S
        //   316: putfield        main/Map.frontData:[S
        //   319: goto            284
        //   322: aload           14
        //   324: aload           15
        //   326: invokevirtual   java/io/DataInputStream.read:([B)I
        //   329: pop            
        //   330: invokestatic    dm/Ms.i:()Ldm/Ms;
        //   333: pop            
        //   334: aload           15
        //   336: invokestatic    dm/Ms.getNum:([B)J
        //   339: l2i            
        //   340: i2s            
        //   341: istore          4
        //   343: aload           14
        //   345: aload           15
        //   347: invokevirtual   java/io/DataInputStream.read:([B)I
        //   350: pop            
        //   351: aload_0        
        //   352: getfield        main/Map.rows:S
        //   355: iconst_1       
        //   356: isub           
        //   357: i2l            
        //   358: lstore          10
        //   360: invokestatic    dm/Ms.i:()Ldm/Ms;
        //   363: pop            
        //   364: lload           10
        //   366: aload           15
        //   368: invokestatic    dm/Ms.getNum:([B)J
        //   371: lsub           
        //   372: l2i            
        //   373: i2s            
        //   374: istore          8
        //   376: aload           14
        //   378: aload           13
        //   380: invokevirtual   java/io/DataInputStream.read:([B)I
        //   383: pop            
        //   384: invokestatic    dm/Ms.i:()Ldm/Ms;
        //   387: pop            
        //   388: aload           13
        //   390: invokestatic    dm/Ms.getNum:([B)J
        //   393: l2i            
        //   394: i2s            
        //   395: istore          7
        //   397: iload           5
        //   399: tableswitch {
        //                2: 427
        //                3: 499
        //                4: 522
        //          default: 424
        //        }
        //   424: goto            286
        //   427: aload_0        
        //   428: getfield        main/Map.bottomData:[S
        //   431: astore          16
        //   433: iload_1        
        //   434: iconst_1       
        //   435: iadd           
        //   436: i2s            
        //   437: istore          9
        //   439: iload           4
        //   441: i2s            
        //   442: istore_2       
        //   443: aload           16
        //   445: iload_1        
        //   446: iload_2        
        //   447: sastore        
        //   448: aload_0        
        //   449: getfield        main/Map.bottomData:[S
        //   452: astore          16
        //   454: iload           9
        //   456: iconst_1       
        //   457: iadd           
        //   458: i2s            
        //   459: istore          4
        //   461: iload           8
        //   463: i2s            
        //   464: istore_2       
        //   465: aload           16
        //   467: iload           9
        //   469: iload_2        
        //   470: sastore        
        //   471: iload           4
        //   473: istore_1       
        //   474: aload_0        
        //   475: getfield        main/Map.bottomData:[S
        //   478: astore          16
        //   480: iload           4
        //   482: iconst_1       
        //   483: iadd           
        //   484: i2s            
        //   485: istore_1       
        //   486: iload           7
        //   488: i2s            
        //   489: istore_2       
        //   490: aload           16
        //   492: iload           4
        //   494: iload_2        
        //   495: sastore        
        //   496: goto            286
        //   499: iload_1        
        //   500: iconst_3       
        //   501: iadd           
        //   502: i2s            
        //   503: istore_1       
        //   504: aload_0        
        //   505: getfield        main/Map.worldData:[[S
        //   508: iload           4
        //   510: aaload         
        //   511: iload           8
        //   513: iload           7
        //   515: iconst_3       
        //   516: ishr           
        //   517: i2s            
        //   518: sastore        
        //   519: goto            286
        //   522: aload_0        
        //   523: getfield        main/Map.frontData:[S
        //   526: astore          16
        //   528: iload_1        
        //   529: iconst_1       
        //   530: iadd           
        //   531: i2s            
        //   532: istore          9
        //   534: iload           4
        //   536: i2s            
        //   537: istore_2       
        //   538: aload           16
        //   540: iload_1        
        //   541: iload_2        
        //   542: sastore        
        //   543: aload_0        
        //   544: getfield        main/Map.frontData:[S
        //   547: astore          16
        //   549: iload           9
        //   551: iconst_1       
        //   552: iadd           
        //   553: i2s            
        //   554: istore          4
        //   556: iload           8
        //   558: i2s            
        //   559: istore_2       
        //   560: aload           16
        //   562: iload           9
        //   564: iload_2        
        //   565: sastore        
        //   566: iload           4
        //   568: istore_1       
        //   569: aload_0        
        //   570: getfield        main/Map.frontData:[S
        //   573: astore          16
        //   575: iload           4
        //   577: iconst_1       
        //   578: iadd           
        //   579: i2s            
        //   580: istore_1       
        //   581: iload           7
        //   583: i2s            
        //   584: istore_2       
        //   585: aload           16
        //   587: iload           4
        //   589: iload_2        
        //   590: sastore        
        //   591: goto            286
        //   594: astore          12
        //   596: goto            210
        //   599: astore          12
        //   601: goto            210
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  25     180    306    311    Ljava/lang/Exception;
        //  187    210    306    311    Ljava/lang/Exception;
        //  211    218    306    311    Ljava/lang/Exception;
        //  232    254    306    311    Ljava/lang/Exception;
        //  295    303    306    311    Ljava/lang/Exception;
        //  311    319    306    311    Ljava/lang/Exception;
        //  322    397    594    599    Ljava/lang/Exception;
        //  427    433    594    599    Ljava/lang/Exception;
        //  448    454    306    311    Ljava/lang/Exception;
        //  474    480    599    604    Ljava/lang/Exception;
        //  504    519    306    311    Ljava/lang/Exception;
        //  522    528    594    599    Ljava/lang/Exception;
        //  543    549    306    311    Ljava/lang/Exception;
        //  569    575    599    604    Ljava/lang/Exception;
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void loadMapModuleAndImage() {
        Ms.i();
        Ms.skip = 0;
        final byte[] stream = Ms.i().getStream("data/map/area.dat", -1);
        final byte[] array = Ms.i().createArray(stream);
        final byte[][] create2Array = Ms.i().create2Array(stream);
        final byte[] array2 = (byte[])null;
        if (this.mapImg != null && array[this.lastMap] == array[this.mapNo]) {
            final byte[] array3 = (byte[])null;
            final byte[][] array4 = (byte[][])null;
        }
        else {
            Ms.i();
            Ms.skip = 0;
            this.moduleData = Ms.i().createShort2Array(Ms.i().getStream("data/map/" + array[this.mapNo] + ".data", -1), 1);
            this.mapImg = null;
            this.mapImg = new Image[create2Array[array[this.mapNo]].length];
            for (int i = 0; i < create2Array[array[this.mapNo]].length; i = (byte)(i + 1)) {
                this.mapImg[i] = Ms.i().createImage("data/map/" + create2Array[array[this.mapNo]][i]);
            }
            final byte[] array5 = (byte[])null;
            final byte[][] array6 = (byte[][])null;
        }
    }
    
    private int map_set(int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        if (n2 <= n3) {
            n = n5 - n6 * n2 >> 1;
        }
        else if (n + 1 <= n4) {
            n = 0;
        }
        else if (n >= n2 - n4) {
            n = n5 - n2 * n6;
        }
        else {
            n = n5 / 2 - n * n6 - n6 / 2;
        }
        return n;
    }
    
    private void meetGrass() {
        if (this.meet_step < this.step_MEET) {
            if (this.worldData[this.my.getIx()][this.my.getIy()] != 7) {
                ++this.meet_step;
            }
        }
        else {
            if (this.gr.monPro.length > 1 && this.gr.immueEnemy == 0) {
                this.my.frame_c = 0;
                this.my.state = 8;
            }
            this.notMeet(0, 0);
        }
    }
    
    private void moveOff(final byte dir, final byte dir2, int n) {
        if (this.my.speed_x == 0) {
            this.my.dir = dir;
        }
        else if (this.my.speed_y == 0) {
            this.my.dir = dir2;
        }
        final Npc my = this.my;
        int n2;
        if (this.my.speed_x != 0) {
            n2 = 0;
        }
        else {
            n2 = n;
        }
        my.speed_x = (byte)n2;
        final Npc my2 = this.my;
        if (this.my.speed_y != 0) {
            n = 0;
        }
        my2.speed_y = (byte)n;
        this.checkMoveOff(this.checkNpcT);
        this.initMoveMy();
    }
    
    private void nextEvent(final int n) {
        if ((n & 0x1000) != 0x0) {
            this.now_eV1 = 0;
            this.now_eV2 = 0;
        }
        if ((n & 0x100) != 0x0) {
            this.eventGoing = 0;
        }
        if ((n & 0x10) != 0x0) {
            this.event_state = 1;
        }
        if ((n & 0x1) != 0x0) {
            this.my.state = 0;
        }
        this.pkey.initPointer();
    }
    
    private void oneMove(final Npc npc, final int n) {
        if (npc.frame_c > 0) {
            if (this.srcNpcNo == n) {
                this.mapMove(npc.x, npc.y, npc.speed_x, npc.speed_y);
            }
            npc.x += npc.speed_x;
            npc.y += npc.speed_y;
            --npc.frame_c;
        }
        else if (npc.frame_c != -1) {
            npc.frame_c = -1;
            npc.setActionNo(false);
        }
    }
    
    private void runAutoMoveNpc(final Npc npc, int n) {
        if (this.my.state == 1 && this.get_meet == n) {
            final byte[] other = npc.other;
            Ms.i();
            final int n2 = Ms.abs(npc.other[7]) / 3;
            if (this.my.dir < 4) {
                n = this.my.dir - 1;
            }
            else {
                n = this.my.dir - 2;
            }
            other[7] = (byte)(n2 * 3 + n);
            if (this.my.dir == 3) {
                npc.other[7] = (byte)(-npc.other[7]);
            }
            else {
                npc.dir = 3;
            }
        }
        else if (this.initAuto(npc, 10)) {
            if (npc.b_auto) {
                this.runAutoX(npc, this.gr.mapMove[(npc.other[8] - 5) * 2]);
            }
            else {
                this.runAutoY(npc, this.gr.mapMove[(npc.other[8] - 5) * 2 + 1]);
            }
        }
    }
    
    private void runAutoX(final Npc npc, int n) {
        if (npc.timeMove == 0) {
            Ms.i();
            byte dir;
            if (Ms.getRandom(100) < 50) {
                dir = 3;
            }
            else {
                dir = 4;
            }
            npc.dir = dir;
            if (npc.dir == 3) {
                n = (short)(npc.x - npc.other[0] * 20);
            }
            else {
                n = (short)((npc.other[0] + n) * 20 - npc.x);
            }
            if (n <= 20) {
                npc.timeMove = (byte)(n / npc.speed);
            }
            else {
                Ms.i();
                npc.timeMove = (byte)(Ms.getRandom((n - 20) / npc.speed + 1) + 20 / npc.speed);
            }
        }
        else if (npc.timeMove > 0 && npc.frame_c < 1) {
            if (npc.dir == 3) {
                n = -npc.speed;
            }
            else {
                n = npc.speed;
            }
            if (this.isAuto_canMove(npc, n, 0)) {
                if (npc.dir == 3) {
                    n = -npc.speed;
                }
                else {
                    n = npc.speed;
                }
                npc.setSpeedXY(n, 0);
                --npc.timeMove;
                npc.frame_c = 1;
                npc.setActionNo(true);
            }
            else {
                npc.timeMove = -20;
                npc.frame_c = -1;
                npc.setActionNo(false);
            }
        }
    }
    
    private void runAutoY(final Npc npc, int n) {
        if (npc.timeMove == 0 && npc.frame_c == -1) {
            Ms.i();
            byte dir;
            if (Ms.getRandom(100) < 50) {
                dir = 1;
            }
            else {
                dir = 2;
            }
            npc.dir = dir;
            if (npc.dir == 1) {
                n = (short)(npc.y - npc.other[1] * 20);
            }
            else {
                n = (short)((npc.other[1] + n) * 20 - npc.y);
            }
            if (n <= 20) {
                npc.timeMove = (byte)(n / npc.speed);
            }
            else {
                Ms.i();
                npc.timeMove = (byte)(Ms.getRandom((n - 20) / npc.speed + 1) + 20 / npc.speed);
            }
        }
        else if (npc.timeMove > 0 && npc.frame_c < 1) {
            if (npc.dir == 1) {
                n = -npc.speed;
            }
            else {
                n = npc.speed;
            }
            if (this.isAuto_canMove(npc, 0, n)) {
                if (npc.dir == 1) {
                    n = -npc.speed;
                }
                else {
                    n = npc.speed;
                }
                npc.setSpeedXY(0, n);
                --npc.timeMove;
                npc.frame_c = 1;
                npc.setActionNo(true);
            }
            else {
                npc.timeMove = -20;
                npc.frame_c = -1;
                npc.setActionNo(false);
            }
        }
    }
    
    private void runBoat() {
        if (this.boatSelect != -1 && this.my.ix == -1 && this.my.iy == -1) {
            this.my.state = 9;
            final GameRun gr = this.gr;
            if ((gr.cur_a += 2) >= this.boatCourse[this.boatSelect].length) {
                this.boatSelect = -1;
                this.my.state = 0;
                this.anole_type = -1;
                this.setAnole();
            }
            else {
                this.checkType = this.checkIfOther(this.door, this.my.x, this.my.y);
                if (this.checkType != -1) {
                    this.my.state = 5;
                    this.get_meet = this.checkType;
                }
                this.my.setIXY(this.boatCourse[this.boatSelect][this.gr.cur_a], this.boatCourse[this.boatSelect][this.gr.cur_a + 1]);
            }
        }
    }
    
    private void runEvent_brow(final int n) {
        final int n2 = this.event[n][this.event_now[n] + 2] - 1;
        if (n2 == -1) {
            Map.cur_npc = this.my;
        }
        else {
            Map.cur_npc = this.npc[this.getNpcLayer(n2)][this.getNpcId(n2)];
        }
        if (this.event[n][this.event_now[n] + 4] == 0) {
            Map.cur_npc.brow_type = this.event[n][this.event_now[n] + 3];
            Map.cur_npc.brow_action = 0;
            Map.cur_npc.brow_time = 0;
        }
        else if (this.event[n][this.event_now[n] + 4] == 1) {
            Map.cur_npc.other[6] = this.event[n][this.event_now[n] + 3];
        }
        else if (this.event[n][this.event_now[n] + 4] == 2) {
            Map.cur_npc.brow_type = -1;
            Map.cur_npc.other[6] = 0;
        }
        final short[] event_now = this.event_now;
        event_now[n] += 5;
        this.nextEvent(4112);
    }
    
    private void runEvent_dialog(final int n) {
        this.checkNpcT = -1;
        if (this.eventGoing == 0) {
            this.eventGoing = 1;
            if (this.anole_type == 1) {
                this.setAnole();
            }
            final int n2 = this.event[n][this.event_now[n] + 2] - 1;
            if (n2 == -1) {
                this.npcName = "\u585e\u5176";
                this.now_eV2 = 0;
            }
            else {
                this.now_eV1 = this.getNpcLayer(n2);
                this.now_eV2 = this.getNpcId(n2);
                this.npcName = this.npcNameData[this.now_eV2];
                if (this.npcName.equals("\u8def\u4eba")) {
                    this.npcName = null;
                }
                this.now_eV2 = this.npc[this.now_eV1][this.now_eV2].other[2];
            }
            this.initNpcFaceOne(this.npcName);
            Ms.i();
            Ms.font.setSize(22);
            this.dialog = Ms.i().groupString(Ms.i().getDialogs(this.event[n], this.event_now[n] + 5, (int)this.event[n][this.event_now[n] + 4]), Constants_H.WIDTH__ - 20);
            if (!this.fontSizeControl) {
                Ms.i();
                Ms.font.setSize(26);
            }
            this.dialog_no = 0;
            this.my.state = 1;
            this.bDirTalk = false;
        }
        else if (this.eventGoing == 2) {
            final short[] event_now = this.event_now;
            event_now[n] += (short)((this.event[n][this.event_now[n] + 4] << 1) + 5);
            this.nextEvent(4369);
        }
    }
    
    private void runEvent_getMon(final int n) {
        this.gmErr = false;
        if (this.gr.getMonster(this.event[n][this.event_now[n] + 2], this.event[n][this.event_now[n] + 3], this.event[n][this.event_now[n] + 4], -1) == -1) {
            this.gr.say("\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1\uff0c\u65e0\u6cd5\u83b7\u5f97\u65b0\u7684\u5ba0\u7269\uff0c\u8bf7\u6574\u7406\u5bc4\u5b58\u6240\u7a7a\u51fa\u4e00\u4e2a\u7a7a\u95f4\u3002", -1);
            this.gmErr = true;
            this.gr.mini_state = 6;
            this.gr.view_state = 1;
            this.gr.goVIEW_MONSTER();
        }
        else {
            final short[] event_now = this.event_now;
            event_now[n] += (short)(this.event[n][this.event_now[n] + 1] + 2);
            this.nextEvent(4368);
        }
    }
    
    private void runEvent_goShop(int i) {
        final byte b = this.event[i][this.event_now[i] + 3];
        if (b == 4) {
            if (this.inShop == 0 && this.my.state != 16) {
                this.my.state = 16;
                this.inShop = 1;
                this.gr.setAction_str(new String[] { "\u56de\u590d", "\u4e0d\u56de\u590d" });
                this.gr.popMenu = 0;
                this.gr.sell_money = 0;
                GameRun gr;
                for (i = 0; i < this.gr.myMon_length; i = (byte)(i + 1)) {
                    gr = this.gr;
                    gr.sell_money += this.gr.myMonsters[i].monster[4] * 20 + 40;
                }
            }
            else if (this.my.state == 0) {
                if (this.inShop == 1 && this.gr.popMenu == 0) {
                    this.inShop = 2;
                    if (!this.gr.checkMonster() && this.gr.isMoney(this.gr.sell_money, true)) {
                        this.gr.healMonster(true);
                    }
                }
                else if (this.gr.say_c == 0) {
                    this.inShop = 0;
                    final short[] event_now = this.event_now;
                    event_now[i] += 4;
                    this.nextEvent(0);
                }
            }
        }
        else {
            if (b < 3) {
                this.gr.goBUY_ITEM(this.event[i][this.event_now[i] + 2], b);
            }
            else if (b == 3) {
                this.gr.goVIEW_COMPUTER(0);
            }
            else if (b == 5) {
                this.gr.goNidus(0);
            }
            else if (b == 6) {
                this.gr.view_state = 4;
                this.gr.popMenu = -1;
            }
            else if (b == 7) {
                this.gr.view_state = 1;
            }
            final short[] event_now2 = this.event_now;
            event_now2[i] += 4;
            this.nextEvent(16);
        }
    }
    
    private void runEvent_item_add_del(int n) {
        final int n2 = 0;
        if (this.eventGoing == 0) {
            this.now_eV1 = this.event[n][this.event_now[n] + 2];
            this.now_eV2 = this.event[n][this.event_now[n] + 3];
            if (this.event[n][this.event_now[n] + 3] >= 0) {
                n = this.gr.addItem(this.now_eV1, this.now_eV2);
            }
            else {
                n = this.gr.findItem(-2, this.now_eV1, true);
                Ms.i();
                if (n >= Ms.abs(this.now_eV2)) {
                    final GameRun gr = this.gr;
                    n = this.now_eV1;
                    Ms.i();
                    gr.deleteItems(n, Ms.abs((int)this.now_eV2));
                    n = n2;
                }
                else {
                    n = -1;
                    this.gr.say("\u9053\u5177\u4e0d\u8db3\uff01", 0);
                }
            }
            if (n != -1) {
                final GameRun gr2 = this.gr;
                String obj;
                if (this.now_eV2 >= 0) {
                    obj = "\u83b7\u5f97\uff1a";
                }
                else {
                    obj = "\u5931\u53bb\uff1a";
                }
                final StringBuilder append = new StringBuilder(String.valueOf(obj)).append(this.gr.getNameItem((int)this.now_eV1)).append("x");
                Ms.i();
                gr2.say(append.append(Ms.abs((int)this.now_eV2)).toString(), 0);
            }
            this.eventGoing = 1;
        }
        else if (this.gr.say_c == 0) {
            if (-1 == 0) {
                this.setEventNow(n, true);
            }
            else {
                final short[] event_now = this.event_now;
                event_now[n] += 4;
                this.nextEvent(4368);
            }
        }
    }
    
    private void runEvent_miniGame_myLevel(final int n) {
        final byte b = this.event[n][this.event_now[n] + 2];
        if (b > 1) {
            final short[] event_now = this.event_now;
            event_now[n] += 3;
            this.nextEvent(4368);
        }
        else if (this.eventGoing < 2) {
            if (b == 0) {
                if (this.gr.magic_id == -2) {
                    if (this.gr.rmsOther[3] == 5) {
                        this.gr.magic_id = -2;
                        this.eventGoing = 2;
                        this.gr.say("\u60a8\u5f53\u524d\u7684\u8bad\u7ec3\u5e08\u7b49\u7ea7\u5df2\u8fbe\u5230\u4e0a\u9650\uff01", 0);
                    }
                    else {
                        this.gr.sell_money = this.gr.isMyLevel(true);
                        if (this.gr.sell_money == -1) {
                            this.my.state = 10;
                            this.gr.magic_id = 28;
                            this.gr.magic_x = this.map_x + this.my.x + 10;
                            this.gr.magic_y = this.map_y + this.my.y + 19;
                            this.gr.setMagic(this.gr.magic_id / 5);
                            this.gr.setMaxTakes(false);
                        }
                        else {
                            this.eventGoing = 2;
                        }
                    }
                }
                else if (this.gr.magic_id == -1) {
                    this.gr.magic_id = -2;
                    this.eventGoing = 2;
                    this.gr.say("\u606d\u559c\u60a8\u7684\u8bad\u7ec3\u5e08\u7b49\u7ea7\u5df2\u63d0\u5347\u4e3a#7" + this.gr.rmsOther[3] + "#0\uff0c\u60a8\u968f\u8eab\u53ef\u643a\u5e26\u5ba0\u7269\u6570\u91cf#7\u66b4\u589e\u5230" + this.gr.max_takes + "#0\uff0c\u60a8\u5546\u5e97\u80fd\u5b58\u653e\u7684\u5ba0\u7269#7\u66b4\u589e\u5230" + this.gr.max_monsters, -1);
                }
            }
            else if (b == 1) {
                if (this.eventGoing == 0 && this.gr.monInfoList[104] == 0) {
                    this.gr.sell_money = 0;
                    this.eventGoing = 3;
                    this.gr.say("\u6b64\u6b21\u60a8\u6ca1\u6709\u6355\u83b7\u5230\u5168\u65b0\u7684\u5ba0\u7269\uff0c\u6355\u83b7\u5e76\u4e0d\u662f\u552f\u4e00\u9014\u5f84\uff0c\u6709\u4e9b\u5ba0\u7269\u9700\u8981\u901a\u8fc7\u8fdb\u5316\u624d\u80fd\u83b7\u5f97\u54e6\u3002", -1);
                }
                else if (this.eventGoing == 0) {
                    this.eventGoing = 3;
                    this.gr.sell_money = this.gr.monInfoList[104];
                    this.gr.monInfoList[104] = 0;
                    this.gr.say("\u6b64\u6b21\u60a8\u6355\u83b7\u4e86" + this.gr.sell_money + "\u4e2a\u65b0\u5ba0\u7269\uff0c\u8fd9\u91cc\u662f\u738b\u56fd\u8bad\u7ec3\u5e08\u673a\u6784\u5956\u52b1\u7ed9\u60a8\u7684" + this.gr.sell_money + "\u4e2a\u5fbd\u7ae0\uff0c\u5e0c\u671b\u518d\u63a5\u518d\u5389\u54e6\u3002", -1);
                    final GameRun gr = this.gr;
                    gr.coin += this.gr.sell_money;
                }
            }
        }
        else if (this.gr.say_c == 0) {
            if (this.eventGoing == 2) {
                if (this.gr.rmsOther[3] == 5) {
                    this.gr.say("\u60a8\u5f53\u524d\u7684\u8bad\u7ec3\u5e08\u7b49\u7ea7\u5df2\u8fbe\u5230\u4e0a\u9650\uff01", 0);
                }
                else {
                    this.gr.sell_money = (byte)(this.gr.isMyLevel(false) - this.gr.monInfoList[103]);
                    if (this.gr.sell_money < 1) {
                        this.gr.sell_money = 0;
                    }
                    this.gr.say("\u5f53\u524d\u8bad\u7ec3\u5e08\u7b49\u7ea7\u4e3a#7" + this.gr.rmsOther[3] + "#0\u8ddd\u79bb\u4e0b\u6b21\u5347\u7ea7\u8fd8\u9700\u8981\u6355\u6349#7" + this.gr.sell_money + "#0\u53ea\u4e0d\u540c\u7684\u5ba0\u7269\uff0c\u52aa\u529b\u83b7\u5f97\u65b0\u5ba0\u5427\u3002", -1);
                }
                this.eventGoing = 4;
            }
            else if (this.eventGoing == 3 && this.gr.sell_money > 0) {
                this.gr.say("\u83b7\u5f97\uff1a\u5fbd\u7ae0x" + this.gr.sell_money, 0);
                this.eventGoing = 4;
            }
            else {
                final short[] event_now2 = this.event_now;
                event_now2[n] += 3;
                this.nextEvent(4368);
            }
        }
    }
    
    private void runEvent_select(final int n) {
        if (this.my.state != 12 && this.my.state != 13 && this.my.state != 14) {
            this.sEvent_eV2 = this.event[n][this.event_now[n] + 1];
            this.sEvent_eV1 = 0;
            this.gr.action_str = null;
            this.gr.action_str = new String[this.sEvent_eV2];
            for (byte b = 0; b < this.sEvent_eV2; ++b) {
                this.gr.action_str[b] = Ms.i().getDialogs(this.event[n], this.event_now[n] + 2 + this.sEvent_eV1 + 1, this.event[n][this.event_now[n] + 2 + this.sEvent_eV1]);
                this.sEvent_eV1 += (byte)((this.event[n][this.event_now[n] + 2 + this.sEvent_eV1] << 1) + 1);
            }
            if (this.sIfElse != -1) {
                this.event_state = 1;
                this.gr.cur_a = this.sIfElse;
                this.my.state = 13;
                this.gr.action_str = null;
                this.sIfElse = -1;
            }
            else {
                this.gr.cur_a = 0;
                this.my.state = 12;
            }
        }
        else if (this.my.state == 13) {
            this.sEvent_eV1 += 2;
            final short n2 = (short)((this.event[n][this.event_now[n] + this.sEvent_eV1 + (this.gr.cur_a << 1)] & 0xFF) << 8 | (this.event[n][this.event_now[n] + this.sEvent_eV1 + (this.gr.cur_a << 1) + 1] & 0xFF));
            final short[] event_now = this.event_now;
            event_now[n] += (short)(this.sEvent_eV1 + (this.sEvent_eV2 << 1) + n2);
            this.nextEvent(17);
        }
        else if (this.my.state == 14) {
            this.setEventNow(n, true);
        }
    }
    
    private void runEvent_srcMove(int n) {
        this.my.state = 10;
        final int n2 = this.event[n][this.event_now[n] + 2] - 1;
        byte ix;
        byte iy;
        if (n2 == -1) {
            ix = this.my.getIx();
            iy = this.my.getIy();
            this.srcNpcNo = -1;
        }
        else {
            this.now_eV1 = this.getNpcLayer(n2);
            this.now_eV2 = this.getNpcId(n2);
            byte now_eV2;
            if (this.now_eV1 == 0) {
                now_eV2 = this.now_eV2;
            }
            else {
                now_eV2 = 0;
            }
            this.srcNpcNo = now_eV2;
            ix = this.npc[this.now_eV1][this.now_eV2].other[0];
            iy = this.npc[this.now_eV1][this.now_eV2].other[1];
        }
        final int n3 = this.map_set(ix, this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20) - this.map_x;
        final int n4 = this.map_set(iy, this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20) - this.map_y;
        Ms.i();
        Label_0244: {
            if (Ms.abs(n4) >= 10) {
                break Label_0244;
            }
            Ms.i();
            if (Ms.abs(n3) >= 10) {
                break Label_0244;
            }
            final short[] event_now = this.event_now;
            event_now[n] += 3;
            this.nextEvent(4112);
            return;
        }
        Ms.i();
        if (Ms.abs(n3) >= 10) {
            n = this.map_x;
            Ms.i();
            this.map_x = n + n3 / Ms.abs(n3) * 10;
        }
        Ms.i();
        if (Ms.abs(n4) >= 10) {
            n = this.map_y;
            Ms.i();
            this.map_y = n + n4 / Ms.abs(n4) * 10;
        }
    }
    
    private void runMove() {
        if (this.my.ix != -1 || this.my.iy != -1) {
            this.runSeek(this.my, false);
        }
        else {
            this.runBoat();
        }
        this.oneMove(this.my, -1);
        for (int i = 0; i < 3; i = (byte)(i + 2)) {
            for (int j = 0; j < this.npc[i].length; j = (byte)(j + 1)) {
                if (this.npc[i][j].other[4] == 1 || this.npc[i][j].other[4] == 2) {
                    if (this.npc[i][j].other[8] >= 5) {
                        this.runAutoMoveNpc(this.npc[i][j], j);
                    }
                    else if (this.npc[i][j].ix != -1 || this.npc[i][j].iy != -1) {
                        this.runSeek(this.npc[i][j], true);
                    }
                    this.oneMove(this.npc[i][j], j);
                }
            }
        }
        this.insertNpc();
    }
    
    private void runNpcAniOne(final Npc[] array, final int n) {
        final byte b = (byte)(array[n].other[3] - 1);
        final byte b2 = array[n].other[2];
        Ms.i();
        final byte b3 = (byte)Ms.abs(array[n].other[7]);
        if (array[n].now_action >= Map.npcSp[b][b2].aLength(b3)) {
            array[n].now_action = 0;
            this.setlastA(array, n);
        }
        final Npc npc = array[n];
        if (++npc.now_time >= Map.npcSp[b][b2].action(b3, array[n].now_action, 1)) {
            final Npc npc2 = array[n];
            ++npc2.now_action;
            array[n].now_time = 0;
        }
    }
    
    private void runSeek(final Npc npc, final boolean b) {
        final boolean b_check = npc.b_check;
        final short n = (short)(npc.ix * 20);
        final short n2 = (short)(npc.iy * 20);
        if (npc.x == n && npc.y == n2) {
            if (npc.frame_c == -1) {
                npc.iy = -1;
                npc.ix = -1;
                if (b) {
                    npc.setIxIy_npc();
                }
                else {
                    npc.speed = this.getMySpeed();
                }
                if (npc.bdir) {
                    npc.other[7] = npc.lastAction;
                    byte dir;
                    if (npc.lastAction < 0) {
                        dir = 4;
                    }
                    else {
                        dir = 3;
                    }
                    npc.dir = dir;
                    npc.setLastAction(false, 127);
                }
            }
        }
        else if (npc.frame_c < 1) {
            int n3;
            if (b_check) {
                if (npc.x != n) {
                    n3 = 1;
                }
                else {
                    n3 = 0;
                }
            }
            else if (npc.y == n2) {
                n3 = 1;
            }
            else {
                n3 = 0;
            }
            if (n3 != 0) {
                if ((npc.x > n && npc.x - npc.speed < n) || (npc.x < n && npc.x + npc.speed > n)) {
                    npc.setSpeedXY(n - npc.x, 0);
                }
                else {
                    byte speed;
                    if (npc.x > n) {
                        speed = (byte)(-npc.speed);
                    }
                    else {
                        speed = npc.speed;
                    }
                    npc.setSpeedXY(speed, 0);
                }
                if (!npc.bdir) {
                    byte dir2;
                    if (npc.x > n) {
                        dir2 = 3;
                    }
                    else {
                        dir2 = 4;
                    }
                    npc.dir = dir2;
                }
            }
            else {
                if ((npc.y > n2 && npc.y - npc.speed < n2) || (npc.y < n2 && npc.y + npc.speed > n2)) {
                    npc.setSpeedXY(0, n2 - npc.y);
                }
                else {
                    byte speed2;
                    if (npc.y > n2) {
                        speed2 = (byte)(-npc.speed);
                    }
                    else {
                        speed2 = npc.speed;
                    }
                    npc.setSpeedXY(0, speed2);
                }
                if (!npc.bdir) {
                    byte dir3;
                    if (npc.y > n2) {
                        dir3 = 1;
                    }
                    else {
                        dir3 = 2;
                    }
                    npc.dir = dir3;
                }
            }
            npc.frame_c = npc.frame_num;
            npc.setActionNo(true);
        }
    }
    
    private void setEventNow(final int n, final boolean b) {
        if (b) {
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
    
    private void setMapOffer() {
        if (this.map_y + this.rows * 20 < Constants_H.HEIGHT && this.rows > Constants_H.YCELLS) {
            this.map_y = Constants_H.HEIGHT - this.rows * 20;
        }
        else if (this.map_y > 0 && this.rows > Constants_H.YCELLS) {
            this.map_y = 0;
        }
        else if (this.map_x > 0 && this.cols > Constants_H.XCELLS) {
            this.map_x = 0;
        }
        else if (this.map_x + this.cols * 20 < Constants_H.WIDTH && this.cols > Constants_H.XCELLS) {
            this.map_x = Constants_H.WIDTH - this.cols * 20;
        }
    }
    
    private void setMoveStop_m() {
        this.my.speed_x = 0;
        this.my.speed_y = 0;
        this.my.frame_c = -1;
        this.my.setActionNo(false);
    }
    
    private boolean setSIfElse(int n, final boolean b, final boolean b2) {
        boolean b3;
        if (n == 2) {
            if (b) {
                n = 0;
            }
            else {
                n = 1;
            }
            this.sIfElse = (byte)n;
            b3 = true;
        }
        else {
            b3 = ((b2 && b) || (!b2 && n == 1));
        }
        return b3;
    }
    
    private boolean setlastA(final Npc[] array, final int n) {
        boolean b;
        if (array[n].lastAction != 127) {
            array[n].other[7] = array[n].lastAction;
            array[n].lastAction = 127;
            b = true;
        }
        else {
            b = false;
        }
        return b;
    }
    
    private void turnAround(final int n) {
        this.my.dir = (byte)n;
        this.my.setActionNo(true);
    }
    
    public void addAnole(int n) {
        if (n == 13 || n == 34 || n == 49 || n == 66 || n == 82) {
            if (n == 13) {
                n = 0;
            }
            else if (n == 34) {
                n = 1;
            }
            else if (n == 49) {
                n = 2;
            }
            else if (n == 66) {
                n = 3;
            }
            else {
                n = 4;
            }
            final byte[] rmsOther = this.gr.rmsOther;
            rmsOther[2] |= (byte)(1 << n);
        }
    }
    
    public void bkEvent_getMon() {
        GameRun.run_state = -10;
    }
    
    public void bkgroundToPaint(final short[] array, final Image[] array2, final int n, final int n2, final short[][] array3, final Graphics graphics, final int n3, final int n4, final int n5, final int n6, final boolean b) {
        if (array != null) {
            if (b) {
                graphics.setClip(n3, n4, n5 - n3, n6 - n4);
                graphics.setColor(this.bgColor);
                graphics.fillRect(n3, n4, n5 - n3, n6 - n4);
            }
            for (int i = 0; i < array.length; i += 3) {
                if (array[i + 2] >= 0) {
                    final int n7 = array[i + 2] >> 3;
                    final short n8 = array[i + 2];
                    final int n9 = array[i] * 20 - n;
                    final int n10 = array[i + 1] * 20 - (n2 - 20);
                    short n11;
                    short n12;
                    if ((n8 & 0x3) % 2 == 1) {
                        n11 = array3[n7][4];
                        n12 = array3[n7][3];
                    }
                    else {
                        n11 = array3[n7][3];
                        n12 = array3[n7][4];
                    }
                    if (n9 + n11 >= n3 && n9 <= n5 && n10 >= n4 && n10 - n12 <= n6) {
                        Ui.i().drawRegion(array2[array3[n7][0]], array3[n7][1], array3[n7][2], array3[n7][3], array3[n7][4], n9, n10, 0x4 | 0x20, array[i + 2] & 0x7, graphics);
                    }
                }
            }
        }
    }
    
    public void checkRegWhere0(final int n) {
        synchronized (this) {
            this.isNeedWait = true;
            SMSSender.i(this.gr).go(2, true);
            SMSSender.i(this.gr).run();
            if (!this.isNeedWait) {
                return;
            }
            try {
                System.out.println("wait() start");
                this.wait();
                System.out.println("wait() over");
            }
            catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public byte checkSoftKey(int n, int n2, final int n3, final int n4) {
        byte b;
        if (n + n3 < 0 || n + n3 >= this.cols * 20 || n2 + n4 < 0 || n2 + n4 >= this.rows * 20) {
            b = 0;
        }
        else {
            final byte checkIfNpc = this.checkIfNpc(this.npc[0], n + n3, n2 + n4);
            if (this.my.state == 0 && checkIfNpc != -1) {
                if (this.anole_type == 1 && this.npc[0][checkIfNpc].other[8] == 4) {
                    this.npc[0][checkIfNpc].other[8] = -4;
                    final byte[] other = this.npc[0][checkIfNpc].other;
                    ++other[7];
                    this.npc[0][checkIfNpc].now_action = 0;
                    this.npc[0][checkIfNpc].now_time = 0;
                }
                else if (this.npc[0][checkIfNpc].other[8] != -4) {
                    this.my.state = 2;
                    this.get_meet = checkIfNpc;
                    if (this.npc[0][checkIfNpc].other[8] != 2 && this.npc[0][checkIfNpc].other[8] != 3 && !this.npcNameData[checkIfNpc].equals("\u8def\u4eba")) {
                        this.bDirTalk = true;
                        this.npcDirTalk = this.npc[0][checkIfNpc].other[7];
                        final byte[] other2 = this.npc[0][checkIfNpc].other;
                        Ms.i();
                        n2 = Ms.abs(this.npcDirTalk) / 3;
                        if (this.my.dir < 4) {
                            n = this.my.dir - 1;
                        }
                        else {
                            n = this.my.dir - 2;
                        }
                        other2[7] = (byte)(n2 * 3 + n);
                        if (this.my.dir == 3) {
                            this.npc[0][checkIfNpc].other[7] = (byte)(-this.npc[0][checkIfNpc].other[7]);
                        }
                        else {
                            this.npc[0][checkIfNpc].dir = 3;
                        }
                    }
                    else {
                        this.bDirTalk = false;
                    }
                }
                b = 9;
            }
            else {
                final byte checkIfOther = this.checkIfOther(this.item, n + n3, n2 + n4);
                if (checkIfOther != -1 && this.item[checkIfOther][2] != -1) {
                    Ms.i().keyRelease();
                    this.get_meet = checkIfOther;
                    this.getItem();
                    b = 0;
                }
                else {
                    b = -1;
                }
            }
        }
        return b;
    }
    
    public void chuansong(final int n, final int n2) {
        this.my.state = 5;
        this.mapNotemp = (byte)n;
        this.go = (byte)n2;
        this.setMoveStop_m();
    }
    
    public void createEvent() {
        final byte[] stream = Ms.i().getStream("event", this.mapNo);
        if (stream.length == 1) {
            this.eventCount = 0;
        }
        else {
            this.eventCount = stream[0];
            if (this.mapInfo[this.mapNo * 2] < 1) {
                this.event_now_list[this.mapNo] = null;
                this.event_now_list[this.mapNo] = new short[this.eventCount];
            }
            else {
                for (int i = 0; i < this.eventCount; i = (byte)(i + 1)) {
                    if (this.isMapEvent(this.mapNo, i)) {
                        this.event_now_list[this.mapNo][i] = 24224;
                    }
                }
            }
            this.event_now = this.event_now_list[this.mapNo];
            this.event = new byte[this.eventCount][];
            int j = 0;
            int n = 0 + 1;
            while (j < this.eventCount) {
                final int n2 = n + 1;
                final byte b = stream[n];
                final int n3 = n2 + 1;
                final short n4 = (short)(b << 8 | (stream[n2] & 0xFF));
                System.arraycopy(stream, n3, this.event[j] = new byte[n4], 0, this.event[j].length);
                n = n3 + n4;
                j = (byte)(j + 1);
            }
        }
    }
    
    byte[][] createItem(byte[] array, byte[][] array2) {
        array2 = null;
        if (this.mapInfo[this.mapNo * 2] > 0) {
            array = this.mapTemp[this.mapNo];
            Ms.i();
            final int skip2 = Ms.skip2;
            Ms.skip2 = skip2 + 1;
            array2 = new byte[array[skip2]][];
            for (int i = 0; i < array2.length; ++i) {
                Ms.i();
                final int skip3 = Ms.skip2;
                Ms.skip2 = skip3 + 1;
                array2[i] = new byte[array[skip3]];
                for (int j = 0; j < array2[i].length; ++j) {
                    final byte[] array3 = array2[i];
                    Ms.i();
                    final int skip4 = Ms.skip2;
                    Ms.skip2 = skip4 + 1;
                    array3[j] = array[skip4];
                }
            }
        }
        else {
            Ms.i();
            final int skip5 = Ms.skip;
            Ms.skip = skip5 + 1;
            final byte[][] array4 = new byte[array[skip5]][];
            int n = 0;
            while (true) {
                array2 = array4;
                if (n >= array4.length) {
                    break;
                }
                Ms.i();
                final int skip6 = Ms.skip;
                Ms.skip = skip6 + 1;
                array4[n] = new byte[array[skip6]];
                for (int k = 0; k < array4[n].length; ++k) {
                    final byte[] array5 = array4[n];
                    Ms.i();
                    final int skip7 = Ms.skip;
                    Ms.skip = skip7 + 1;
                    array5[k] = array[skip7];
                }
                ++n;
            }
        }
        return array2;
    }
    
    public void createLayer() {
        this.createMap();
        this.setMapData();
    }
    
    Npc[] createNpc(byte[] other, Npc[] array) {
        array = null;
        Ms.i();
        final int skip = Ms.skip;
        Ms.skip = skip + 1;
        array = new Npc[other[skip]];
        for (int i = 0; i < array.length; ++i) {
            Ms.i();
            final int skip2 = Ms.skip;
            Ms.skip = skip2 + 1;
            array[i] = new Npc(other[skip2]);
            for (int j = 0; j < array[i].other.length; ++j) {
                final byte[] other2 = array[i].other;
                Ms.i();
                final int skip3 = Ms.skip;
                Ms.skip = skip3 + 1;
                other2[j] = other[skip3];
            }
            array[i].setXY_npc();
        }
        if (this.mapInfo[this.mapNo * 2] > 0) {
            for (int k = 0; k < array.length; ++k) {
                if (array[k].other[9] == 1) {
                    for (int l = 0; l < array[k].other.length; ++l) {
                        other = array[k].other;
                        final byte[] array2 = this.mapTemp[this.mapNo];
                        Ms.i();
                        final int skip4 = Ms.skip2;
                        Ms.skip2 = skip4 + 1;
                        other[l] = array2[skip4];
                    }
                    array[k].setXY_npc();
                }
            }
        }
        return array;
    }
    
    public byte[] createNpcPos(final byte[] array, byte[] array2) {
        array2 = null;
        Ms.i();
        final int skip = Ms.skip;
        Ms.skip = skip + 1;
        array2 = new byte[array[skip]];
        for (int i = 0; i < array2.length; ++i) {
            Ms.i();
            final int skip2 = Ms.skip;
            Ms.skip = skip2 + 1;
            array2[i] = array[skip2];
        }
        return array2;
    }
    
    public void createNpcString() {
        this.npcNameData = Ms.i().loadText(this.initData(this.gr.createData(1), (int)this.mapNo));
        this.npcStringData = Ms.i().loadText(this.initData(this.gr.createData(2), (int)this.mapNo));
    }
    
    public void createOther() {
        final byte[] array = (byte[])null;
        Ms.i();
        Ms.skip = 0;
        Ms.i();
        Ms.skip2 = 0;
        final byte[] initData = this.initData(this.gr.createData(0), this.mapNo);
        this.npcPos = this.createNpcPos(initData, this.npcPos);
        if (this.mapInfo[this.mapNo * 2] > 0 && this.mapTemp[this.mapNo] == null) {
            this.mapTemp[this.mapNo] = Ms.i().rmsOptions(this.mapNo + 14, null, 1);
        }
        this.npc[0] = this.createNpc(initData, this.npc[0]);
        this.npc[1] = this.createNpc(initData, this.npc[1]);
        this.npc[2] = this.createNpc(initData, this.npc[2]);
        this.item = this.createItem(initData, this.item);
        this.door = this.createItem(initData, this.door);
        this.npcList = null;
        this.npcList = new byte[this.npc[0].length + 1 + this.item.length];
        final byte[] array2 = (byte[])null;
        this.initNpcAni();
    }
    
    public void doKey() {
        switch (this.map_key) {
            case 1:
            case 2:
            case 3:
            case 4: {
                if (this.my.dir != this.map_key) {
                    this.turnAround(this.map_key);
                }
                this.canMove(this.dir_select[this.map_key][0] * this.my.speed, this.dir_select[this.map_key][1] * this.my.speed);
                break;
            }
            case -53:
            case 5: {
                if (this.gr.isTalk) {
                    this.checkSoftKey(this.my.x, this.my.y, this.dir_select[this.my.dir][0] * this.my.speed, this.dir_select[this.my.dir][1] * this.my.speed);
                    break;
                }
                break;
            }
            case -57: {
                Ms.i().keyRelease();
                if (this.gr.rmsOther[2] > 0) {
                    this.initAnoleValue();
                    break;
                }
                break;
            }
            case -51: {
                this.goMission(1, false);
                break;
            }
            case -49: {
                this.goMission(0, false);
                break;
            }
            case -48: {
                this.goMiniMap();
                break;
            }
        }
    }
    
    public void drawBlackSRC(final Graphics graphics, final int n, final boolean b) {
        final int width__ = Constants_H.WIDTH__;
        final int height__ = Constants_H.HEIGHT__;
        final int n2 = Constants_H.WIDTH__ / 2;
        graphics.setColor(16777215);
        final byte b2 = 0;
        int n3;
        if (this.black_0 - 5 > 0) {
            n3 = this.black_0 - 5;
        }
        else {
            n3 = 0;
        }
        final byte b3 = (byte)n3;
        short n4 = b2;
        if (this.gr.about_d != null) {
            while (true) {
                if (b) {
                    if (n4 >= this.gr.about_d.length) {
                        break;
                    }
                }
                else {
                    if (n4 > this.black_0) {
                        break;
                    }
                    if (n4 >= this.gr.about_d.length) {
                        break;
                    }
                }
                if (!b) {
                    if (this.black_0 == n4) {
                        graphics.setClip(0, (n4 - b3) * 29 + n, this.black_1 << 1, 25 + 4);
                    }
                    Ui.i().drawStringColor(this.gr.about_d[n4].toString(), 25, (n4 - b3) * 29 + n, 0, 0);
                    graphics.setClip(0, 0, width__, height__);
                }
                else {
                    Ui.i().drawStringColor(this.gr.about_d[n4].toString(), width__ - (short)(Ms.i().getStringWidth(this.gr.about_d[n4].toString()) - this.gr.getSIndexW(this.gr.about_d[n4].toString())) >> 1, n4 * 29 + n + 6, 0, 0);
                }
                ++n4;
            }
            while (true) {
                if (!b) {
                    graphics.setColor(0);
                    graphics.fillRect(0, 0, width__, 40);
                    graphics.fillRect(0, height__ - 40, width__, 40);
                }
                if (this.black_0 == this.gr.about_d.length) {
                    this.gr.drawZero(n2, height__ - 25 - 4, 0x1 | 0x20, 0);
                    return;
                }
                if (!b && (this.black_1 += 10) >= n2) {
                    this.black_1 = 0;
                    ++this.black_0;
                    return;
                }
                if (b) {
                    this.black_0 = (byte)this.gr.about_d.length;
                    return;
                }
                return;
                continue;
            }
        }
    }
    
    void drawMap(final Graphics graphics) {
        final short leftCol = this.leftCol;
        final short topRow = this.topRow;
        if (this.map_x >= 0) {
            this.leftCol = 0;
            this.map_left = this.map_x;
        }
        else {
            this.leftCol = (short)(-this.map_x / 20);
            this.map_left = this.map_x % 20;
        }
        if (this.map_y >= 0) {
            this.topRow = 0;
            this.map_top = this.map_y;
        }
        else {
            this.topRow = (short)(-this.map_y / 20);
            this.map_top = this.map_y % 20;
        }
        final int n = this.leftCol * 20;
        final int n2 = this.topRow * 20;
        if (this.firstDrawMap == 0) {
            this.firstDrawMap = 1;
            this.bkgroundToPaint(this.bottomData, this.mapImg, n, n2, this.moduleData, graphics, 0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
        }
        else if (this.leftCol != leftCol || this.topRow != topRow) {
            graphics.setClip(0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT);
            graphics.copyArea(0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, (leftCol - this.leftCol) * 20, (topRow - this.topRow) * 20, 20);
            if (this.leftCol < leftCol) {
                this.bkgroundToPaint(this.bottomData, this.mapImg, n, n2, this.moduleData, graphics, 0, 0, (leftCol - this.leftCol) * 20, Constants_H.OFF_HEIGHT, true);
            }
            else if (this.leftCol > leftCol) {
                this.bkgroundToPaint(this.bottomData, this.mapImg, n, n2, this.moduleData, graphics, Constants_H.OFF_WIDTH + (leftCol - this.leftCol) * 20, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
            }
            if (this.topRow < topRow) {
                this.bkgroundToPaint(this.bottomData, this.mapImg, n, n2, this.moduleData, graphics, 0, 0, Constants_H.OFF_WIDTH, (topRow - this.topRow) * 20, true);
            }
            else if (this.topRow > topRow) {
                this.bkgroundToPaint(this.bottomData, this.mapImg, n, n2, this.moduleData, graphics, 0, Constants_H.OFF_HEIGHT + (topRow - this.topRow) * 20, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
            }
        }
        Map.g.drawImage(GameRun.scrT, this.map_left, this.map_top, 20);
    }
    
    public void drawMyAni(final Npc npc, int n, final int n2, final int n3, final int n4) {
        final byte b = (byte)n;
        if (npc.now_action >= Map.npcSp[1][b].aLength(n4)) {
            npc.now_action = 0;
        }
        if (this.anole_type != 2 && this.anole_type != 4) {
            Ui.i().drawImage(this.imgShadow, n2, n3, 33);
        }
        final Ui i = Ui.i();
        final Sprite sprite = Map.npcSp[1][b];
        final int action = Map.npcSp[1][b].action(n4, npc.now_action, 0);
        if (npc.dir == 4) {
            n = 1;
        }
        else {
            n = 0;
        }
        i.drawFrameOne(sprite, action, n2, n3, n);
        final byte now_time = (byte)(npc.now_time + 1);
        npc.now_time = now_time;
        if (now_time > Map.npcSp[1][b].action(n4, npc.now_action, 1)) {
            ++npc.now_action;
            npc.now_time = 0;
        }
    }
    
    public void eventCheck() {
        for (int n = 0; this.event != null && n < this.event.length; ++n) {
            if (this.event[n] != null && this.event_now[n] < this.event[n].length) {
                do {
                    this.event_state = 0;
                    if (this.event_now[n] >= this.event[n].length) {
                        final short[] mapInfo = this.mapInfo;
                        final int n2 = this.mapNo * 2 + 1;
                        mapInfo[n2] |= (short)(1 << n);
                        break;
                    }
                    switch (this.event[n][this.event_now[n]]) {
                        case 28: {
                            this.runEvent_dialog(n);
                            break;
                        }
                        case 41: {
                            final int n3 = this.event[n][this.event_now[n] + 2] - 1;
                            if (n3 == -1) {
                                this.my.setXY(this.event[n][this.event_now[n] + 3], this.event[n][this.event_now[n] + 4], 0, 0);
                                this.my.frame_c = -1;
                                if (this.srcNpcNo == -1) {
                                    this.map_x = this.map_set(this.event[n][this.event_now[n] + 3], this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20);
                                    this.map_y = this.map_set(this.event[n][this.event_now[n] + 4], this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20);
                                }
                            }
                            else {
                                this.now_eV1 = this.getNpcLayer(n3);
                                this.now_eV2 = this.getNpcId(n3);
                                this.npc[this.now_eV1][this.now_eV2].other[0] = this.event[n][this.event_now[n] + 3];
                                this.npc[this.now_eV1][this.now_eV2].other[1] = this.event[n][this.event_now[n] + 4];
                                this.npc[this.now_eV1][this.now_eV2].setXY_npc();
                            }
                            final short[] event_now = this.event_now;
                            event_now[n] += 5;
                            this.nextEvent(4112);
                            break;
                        }
                        case 15: {
                            this.setEventNow(n, this.event[n][this.event_now[n] + 2] == 0);
                            break;
                        }
                        case 4: {
                            this.ifEvent(n, 4, 16, this.event[n][this.event_now[n] + 3], this.gr.monInfoList[103] >= this.event[n][this.event_now[n] + 2]);
                            break;
                        }
                        case 24: {
                            this.initBoat(this.event[n][this.event_now[n] + 2]);
                            final short[] event_now2 = this.event_now;
                            event_now2[n] += 3;
                            this.nextEvent(16);
                            break;
                        }
                        case 25: {
                            this.gr.overMode = (byte)(this.event[n][this.event_now[n] + 2] + 1);
                            final short[] event_now3 = this.event_now;
                            event_now3[n] += 3;
                            break;
                        }
                        case 50: {
                            if (this.my.state == 24 || this.my.state == 25) {
                                final short[] event_now4 = this.event_now;
                                event_now4[n] += 3;
                                this.nextEvent(0);
                                if (this.my.state == 24) {
                                    this.gr.say("\u4fdd\u5b58\u8fdb\u5ea6\u5b8c\u6210", 1);
                                    this.gr.saveGame();
                                }
                                this.my.state = 0;
                                break;
                            }
                            if (this.my.frame_c == -1 && this.my.state != 23) {
                                this.my.state = 23;
                                break;
                            }
                            break;
                        }
                        case 29: {
                            final int n4 = this.event[n][this.event_now[n] + 2] - 1;
                            if (n4 == -1) {
                                Map.cur_npc = this.my;
                            }
                            else {
                                Map.cur_npc = this.npc[this.getNpcLayer(n4)][this.getNpcId(n4)];
                            }
                            Map.cur_npc.setLastAction(false, this.event[n][this.event_now[n] + 4]);
                            Map.cur_npc.other[7] = this.event[n][this.event_now[n] + 3];
                            Map.cur_npc.now_action = 0;
                            final short[] event_now5 = this.event_now;
                            event_now5[n] += 5;
                            this.nextEvent(4096);
                            break;
                        }
                        case 39: {
                            this.now_eV1 = this.event[n][this.event_now[n] + 2];
                            this.now_eV2 = this.event[n][this.event_now[n] + 3];
                            if ((this.gr.rmsOther[this.now_eV1 * 2 + 4] & 1 << this.now_eV2) != 0x0) {
                                final short[] event_now6 = this.event_now;
                                event_now6[n] += 4;
                                this.nextEvent(4113);
                                break;
                            }
                            break;
                        }
                        case 42: {
                            this.now_eV1 = this.event[n][this.event_now[n] + 2];
                            this.now_eV2 = this.event[n][this.event_now[n] + 3];
                            Mg.i().go(this.gr, this.now_eV1, -1, this.now_eV2);
                            final short[] event_now7 = this.event_now;
                            event_now7[n] += 4;
                            this.nextEvent(4113);
                            break;
                        }
                        case 18: {
                            this.runEvent_item_add_del(n);
                            break;
                        }
                        case 49: {
                            if (this.gr.magic_id == -2) {
                                this.my.state = 10;
                                this.gr.magic_id = this.event[n][this.event_now[n] + 2];
                                this.gr.magic_x = this.map_x + this.event[n][this.event_now[n] + 3] * 20 + 10;
                                this.gr.magic_y = this.map_y + this.event[n][this.event_now[n] + 4] * 20 + 20;
                                this.gr.setMagic(this.event[n][this.event_now[n] + 2] / 5);
                                break;
                            }
                            if (this.gr.magic_id == -1) {
                                this.gr.magic_id = -2;
                                final short[] event_now8 = this.event_now;
                                event_now8[n] += 5;
                                this.nextEvent(16);
                                break;
                            }
                            break;
                        }
                        case 26: {
                            this.runEvent_getMon(n);
                            break;
                        }
                        case 27: {
                            if (this.eventGoing == 0) {
                                this.now_eV2 = this.gr.findMonsterMinLv(this.event[n][this.event_now[n] + 2], this.event[n][this.event_now[n] + 3]);
                                if (this.now_eV2 != -1) {
                                    this.now_eV1 = this.gr.delMonster(this.now_eV2);
                                    this.eventGoing = 1;
                                    break;
                                }
                                this.setEventNow(n, false);
                                break;
                            }
                            else {
                                if (this.gr.say_c != 0) {
                                    break;
                                }
                                if (this.now_eV1 == -1) {
                                    this.setEventNow(n, false);
                                    break;
                                }
                                final short[] event_now9 = this.event_now;
                                event_now9[n] += (short)(this.event[n][this.event_now[n] + 1] + 2);
                                this.nextEvent(4368);
                                break;
                            }
                            break;
                        }
                        case 35: {
                            final int n5 = this.event[n][this.event_now[n] + 2] - 1;
                            if (n5 == -1) {
                                this.my.other[4] = this.event[n][this.event_now[n] + 3];
                                switch (this.event[n][this.event_now[n] + 3]) {
                                    case 0:
                                    case 2: {
                                        this.my.state = 0;
                                        break;
                                    }
                                    case 1:
                                    case 3: {
                                        this.my.state = 10;
                                        break;
                                    }
                                }
                            }
                            else {
                                this.now_eV1 = this.getNpcLayer(n5);
                                this.now_eV2 = this.getNpcId(n5);
                                this.npc[this.now_eV1][this.now_eV2].other[4] = this.event[n][this.event_now[n] + 3];
                            }
                            final short[] event_now10 = this.event_now;
                            event_now10[n] += 4;
                            this.nextEvent(4112);
                            break;
                        }
                        case 32: {
                            this.runEvent_miniGame_myLevel(n);
                            break;
                        }
                        case 46: {
                            Sound.i().setMusicId(this.event[n][this.event_now[n] + 2]);
                            Sound.i().setMusic(false);
                            final short[] event_now11 = this.event_now;
                            event_now11[n] += 3;
                            this.nextEvent(16);
                            break;
                        }
                        case 47: {
                            this.my.state = 10;
                            final byte sleep_count = (byte)(this.sleep_count + 1);
                            this.sleep_count = sleep_count;
                            if (sleep_count == this.event[n][this.event_now[n] + 2]) {
                                this.sleep_count = 0;
                                final short[] event_now12 = this.event_now;
                                event_now12[n] += 3;
                                this.nextEvent(17);
                                break;
                            }
                            break;
                        }
                        case 52: {
                            this.my.state = 10;
                            this.xxx = this.event[n][this.event_now[n] + 2];
                            final short[] event_now13 = this.event_now;
                            event_now13[n] += 3;
                            this.nextEvent(16);
                            break;
                        }
                        case 16: {
                            this.runEvent_goShop(n);
                            break;
                        }
                        case 53: {
                            if (this.initSrcEffect(this.event[n][this.event_now[n] + 2])) {
                                final short[] event_now14 = this.event_now;
                                event_now14[n] += 3;
                                this.nextEvent(16);
                                break;
                            }
                            break;
                        }
                        case 13: {
                            if (this.eventGoing == 0) {
                                this.eventGoing = 1;
                                if (this.event[n][this.event_now[n] + 3] == 0) {
                                    this.bMission[14] = this.event[n][this.event_now[n] + 2];
                                    if (this.bMission[14] != -1) {
                                        this.gr.say("#4\u4e3b\u7ebf\u4efb\u52a1#0\u5df2\u66f4\u65b0\uff0c\u70b9\u51fb#7\u5de5\u5177\u5305\u5185\u7684\u4e3b\u7ebf\u6309\u94ae#0\u53ef\u67e5\u770b\u4efb\u52a1\u8868\u3002", -1);
                                        break;
                                    }
                                    break;
                                }
                                else {
                                    this.setMission(this.event[n][this.event_now[n] + 2], this.event[n][this.event_now[n] + 3] == 2);
                                    if (this.event[n][this.event_now[n] + 3] == 2) {
                                        this.gr.say("#4\u5206\u652f\u4efb\u52a1#0\u5df2\u66f4\u65b0\uff0c\u70b9\u51fb#7\u5de5\u5177\u5305\u5185\u7684\u652f\u7ebf\u6309\u94ae#0\u53ef\u67e5\u770b\u4efb\u52a1\u8868\u3002", -1);
                                        break;
                                    }
                                    break;
                                }
                            }
                            else {
                                if (this.gr.say_c == 0) {
                                    final short[] event_now15 = this.event_now;
                                    event_now15[n] += 4;
                                    this.nextEvent(272);
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        case 30: {
                            this.my.state = 10;
                            final int n6 = this.event[n][this.event_now[n] + 2] - 1;
                            if (n6 == -1) {
                                Map.cur_npc = this.my;
                            }
                            else {
                                Map.cur_npc = this.npc[this.getNpcLayer(n6)][this.getNpcId(n6)];
                            }
                            Map.cur_npc.setIXY(this.event[n][this.event_now[n] + 3], this.event[n][this.event_now[n] + 4]);
                            Map.cur_npc.speed = this.event[n][this.event_now[n] + 5];
                            Map.cur_npc.b_check = (this.event[n][this.event_now[n] + 6] == 0);
                            Map.cur_npc.setLastAction(false, 127);
                            final short[] event_now16 = this.event_now;
                            event_now16[n] += 7;
                            this.nextEvent(16);
                            break;
                        }
                        case 37: {
                            this.my.state = 10;
                            final int n7 = this.event[n][this.event_now[n] + 2] - 1;
                            if (n7 == -1) {
                                Map.cur_npc = this.my;
                            }
                            else {
                                Map.cur_npc = this.npc[this.getNpcLayer(n7)][this.getNpcId(n7)];
                            }
                            Map.cur_npc.setLastAction(true, this.event[n][this.event_now[n] + 6]);
                            Map.cur_npc.setIXY(this.event[n][this.event_now[n] + 3], this.event[n][this.event_now[n] + 4]);
                            Map.cur_npc.other[7] = this.event[n][this.event_now[n] + 5];
                            if (this.event[n][this.event_now[n] + 5] < 0) {
                                Map.cur_npc.dir = 4;
                            }
                            Map.cur_npc.speed = this.event[n][this.event_now[n] + 7];
                            final short[] event_now17 = this.event_now;
                            event_now17[n] += 8;
                            this.nextEvent(16);
                            break;
                        }
                        case 23: {
                            this.now_eV1 = this.event[n][this.event_now[n] + 2];
                            this.now_eV2 = this.event[n][this.event_now[n] + 3];
                            final short[] event_now18 = this.event_now;
                            event_now18[n] += 4;
                            this.setRestEvent(this.now_eV1, this.now_eV2);
                            this.nextEvent(4112);
                            break;
                        }
                        case 17: {
                            this.now_eV1 = this.event[n][this.event_now[n] + 2];
                            this.now_eV2 = this.event[n][this.event_now[n] + 3];
                            final short[] event_now19 = this.event_now;
                            event_now19[n] += 4;
                            this.setOverEvent(this.now_eV1, this.now_eV2);
                            this.nextEvent(4112);
                            break;
                        }
                        case 22: {
                            this.exitBoss(this.event[n][this.event_now[n] + 2], this.event[n][this.event_now[n] + 3], this.event[n][this.event_now[n] + 4], this.event[n][this.event_now[n] + 5]);
                            final short[] event_now20 = this.event_now;
                            event_now20[n] += 6;
                            this.nextEvent(16);
                            break;
                        }
                        case 36: {
                            final int n8 = this.event[n][this.event_now[n] + 2] - 1;
                            this.now_eV1 = this.getNpcLayer(n8);
                            this.now_eV2 = this.getNpcId(n8);
                            this.npc[this.now_eV1][this.now_eV2].other[5] = (byte)(this.event[n][this.event_now[n] + 3] + 1);
                            final short[] event_now21 = this.event_now;
                            event_now21[n] += 4;
                            this.nextEvent(4112);
                            break;
                        }
                        case 2: {
                            this.now_eV1 = this.event[n][this.event_now[n] + 2];
                            this.now_eV2 = this.event[n][this.event_now[n] + 3];
                            this.ifEvent(n, 5, 4112, this.event[n][this.event_now[n] + 4], this.isMapEvent((int)this.now_eV1, (int)this.now_eV2));
                            break;
                        }
                        case 45: {
                            this.runEvent_srcMove(n);
                            break;
                        }
                        case 48: {
                            this.my.state = 10;
                            this.srcFlash_c = (byte)(this.event[n][this.event_now[n] + 2] << 1);
                            final short[] event_now22 = this.event_now;
                            event_now22[n] += 3;
                            this.nextEvent(16);
                            break;
                        }
                        case 38: {
                            this.runEvent_brow(n);
                            break;
                        }
                        case 19: {
                            Ms.i();
                            Ms.skip = 0;
                            final byte[][] create2Array = Ms.i().create2Array(Ms.i().getStream("data/battle/boss.d", -1));
                            final byte[] array = (byte[])null;
                            final int n9 = this.event[n][this.event_now[n] + 1] >> 1;
                            this.gr.enemyList = new byte[n9][5];
                            this.now_eV2 = 0;
                            while (this.now_eV2 < n9) {
                                this.now_eV1 = this.event[n][this.event_now[n] + 2 + this.now_eV2 * 2];
                                this.gr.enemyList[this.now_eV2][0] = create2Array[this.now_eV1][0];
                                this.gr.enemyList[this.now_eV2][1] = this.event[n][this.event_now[n] + 3 + this.now_eV2 * 2];
                                this.gr.enemyList[this.now_eV2][2] = create2Array[this.now_eV1][1];
                                this.gr.enemyList[this.now_eV2][3] = create2Array[this.now_eV1][2];
                                this.gr.enemyList[this.now_eV2][4] = create2Array[this.now_eV1][3];
                                ++this.now_eV2;
                            }
                            final byte[][] array2 = (byte[][])null;
                            Sound.i().setMusicId(6);
                            Sound.i().setMusic(false);
                            this.gr.battleType(3);
                            this.gr.goBattle();
                            final short[] event_now23 = this.event_now;
                            event_now23[n] += (short)(this.event[n][this.event_now[n] + 1] + 2);
                            break;
                        }
                        case 6: {
                            this.ifEvent(n, 7, 16, this.event[n][this.event_now[n] + 6], Ms.i().isRect((int)this.my.x, (int)this.my.y, 19, 19, this.event[n][this.event_now[n] + 2] * 20, this.event[n][this.event_now[n] + 3] * 20, (this.event[n][this.event_now[n] + 4] - this.event[n][this.event_now[n] + 2] + 1) * 20, (this.event[n][this.event_now[n] + 5] - this.event[n][this.event_now[n] + 3] + 1) * 20));
                            break;
                        }
                        case 1: {
                            final int n10 = this.event[n][this.event_now[n] + 2] - 1;
                            if (n10 != -1) {
                                this.now_eV1 = this.getNpcLayer(n10);
                                this.now_eV2 = this.getNpcId(n10);
                                this.ifEvent(n, 4, 16, this.event[n][this.event_now[n] + 3], this.my.state == 2 && this.get_meet == this.now_eV2);
                                break;
                            }
                            break;
                        }
                        case 3: {
                            this.ifEvent(n, 4, 16, this.event[n][this.event_now[n] + 3], this.gr.money >= this.event[n][this.event_now[n] + 2] * 100);
                            break;
                        }
                        case 5: {
                            final byte item = this.gr.findItem(-2, this.event[n][this.event_now[n] + 2], true);
                            boolean b;
                            if (this.event[n][this.event_now[n] + 3] == 0) {
                                b = (item == 0);
                            }
                            else {
                                b = (item >= this.event[n][this.event_now[n] + 3]);
                            }
                            this.ifEvent(n, 5, 16, this.event[n][this.event_now[n] + 4], b);
                            break;
                        }
                        case 8: {
                            this.ifEvent(n, 5, 16, this.event[n][this.event_now[n] + 4], this.gr.findMonster(this.event[n][this.event_now[n] + 2], this.event[n][this.event_now[n] + 3]) != -1);
                            break;
                        }
                        case 12: {
                            this.runEvent_select(n);
                            break;
                        }
                        case 11: {
                            final int n11 = this.event[n][this.event_now[n] + 2] - 1;
                            this.now_eV1 = this.getNpcLayer(n11);
                            this.now_eV2 = this.getNpcId(n11);
                            if (this.npc[this.now_eV1][this.now_eV2].other[8] == this.event[n][this.event_now[n] + 3]) {
                                final short[] event_now24 = this.event_now;
                                event_now24[n] += 4;
                                this.nextEvent(16);
                                break;
                            }
                            this.setEventNow(n, false);
                            break;
                        }
                        case 40: {
                            final int n12 = this.event[n][this.event_now[n] + 2] - 1;
                            if (n12 == -1) {
                                final byte[] other = this.my.other;
                                Ms.i();
                                other[7] = (byte)Ms.abs(this.event[n][this.event_now[n] + 3]);
                                if (this.event[n][this.event_now[n] + 3] < 0) {
                                    this.my.dir = 4;
                                }
                            }
                            else {
                                Map.cur_npc = this.npc[this.getNpcLayer(n12)][this.getNpcId(n12)];
                                Map.cur_npc.other[7] = this.event[n][this.event_now[n] + 3];
                                Map.cur_npc.setNpcNum(Map.npcSp[Map.cur_npc.other[3] - 1][Map.cur_npc.other[2]].aLength());
                            }
                            final short[] event_now25 = this.event_now;
                            event_now25[n] += 4;
                            this.nextEvent(16);
                            break;
                        }
                        case 43: {
                            final int n13 = this.event[n][this.event_now[n] + 2] - 1;
                            this.now_eV1 = this.getNpcLayer(n13);
                            this.now_eV2 = this.getNpcId(n13);
                            this.npc[this.now_eV1][this.now_eV2].other[8] = this.event[n][this.event_now[n] + 3];
                            final short[] event_now26 = this.event_now;
                            event_now26[n] += 4;
                            this.nextEvent(16);
                            break;
                        }
                        case 21: {
                            if (this.eventGoing == 0) {
                                this.eventGoing = 1;
                                final int n14 = this.event[n][this.event_now[n] + 2] * 100;
                                if (n14 < 0) {
                                    final int money = this.gr.money;
                                    Ms.i();
                                    if (money < Ms.abs(n14)) {
                                        this.gr.say("\u91d1\u94b1\u4e0d\u8db3\uff01", 0);
                                        this.eventGoing = 2;
                                    }
                                }
                                if (this.eventGoing == 1) {
                                    final GameRun gr = this.gr;
                                    gr.money += n14;
                                    final GameRun gr2 = this.gr;
                                    String obj;
                                    if (n14 < 0) {
                                        obj = "\u5931\u53bb\uff1a";
                                    }
                                    else {
                                        obj = "\u83b7\u5f97\uff1a";
                                    }
                                    final StringBuilder sb = new StringBuilder(String.valueOf(obj));
                                    Ms.i();
                                    gr2.say(sb.append(Ms.abs(n14)).append("\u91d1").toString(), 0);
                                    break;
                                }
                                break;
                            }
                            else {
                                if (this.gr.say_c != 0) {
                                    break;
                                }
                                if (this.eventGoing == 2) {
                                    this.setEventNow(n, true);
                                    break;
                                }
                                final short[] event_now27 = this.event_now;
                                event_now27[n] += 3;
                                this.nextEvent(272);
                                break;
                            }
                            break;
                        }
                        case 33: {
                            this.anole_type = (byte)(this.event[n][this.event_now[n] + 2] - 1);
                            this.setAnole();
                            final short[] event_now28 = this.event_now;
                            event_now28[n] += 3;
                            this.nextEvent(16);
                            break;
                        }
                        case 51: {
                            switch (this.event[n][this.event_now[n] + 2]) {
                                default: {
                                    continue;
                                }
                                case 0: {
                                    if (this.eventGoing == 0) {
                                        this.gr.say(Ms.i().getDialogs(this.event[n], this.event_now[n] + 4, (int)this.event[n][this.event_now[n] + 3]), -1);
                                        this.eventGoing = 1;
                                        continue;
                                    }
                                    if (this.gr.say_c == 0) {
                                        final short[] event_now29 = this.event_now;
                                        event_now29[n] += (short)((this.event[n][this.event_now[n] + 3] << 1) + 4);
                                        this.nextEvent(272);
                                        continue;
                                    }
                                    continue;
                                }
                                case 1:
                                case 2: {
                                    if (this.eventGoing == 0) {
                                        this.my.state = 22;
                                        this.black_1 = 0;
                                        this.black_0 = 0;
                                        Ms.i();
                                        Ms.font.setSize(22);
                                        this.fontSizeControl = true;
                                        this.gr.setStringB(Ms.i().getDialogs(this.event[n], this.event_now[n] + 4, (int)this.event[n][this.event_now[n] + 3]), Constants_H.WIDTH__ - 25 * 2, 3);
                                        Ms.i();
                                        Ms.font.setSize(26);
                                        this.fontSizeControl = false;
                                        this.eventGoing = this.event[n][this.event_now[n] + 2];
                                        continue;
                                    }
                                    if (this.eventGoing == 3) {
                                        final short[] event_now30 = this.event_now;
                                        event_now30[n] += (short)((this.event[n][this.event_now[n] + 3] << 1) + 4);
                                        this.nextEvent(272);
                                        this.gr.about_d = null;
                                        this.black_0 = -1;
                                        continue;
                                    }
                                    continue;
                                }
                            }
                            break;
                        }
                        case 31: {
                            final int n15 = this.event[n][this.event_now[n] + 2] - 1;
                            if (n15 == -1) {
                                this.now_eV1 = this.event[n][this.event_now[n] + 3];
                                this.my.dir = this.now_eV1;
                                this.my.setActionNo(false);
                            }
                            else {
                                this.now_eV1 = this.getNpcLayer(n15);
                                if (this.now_eV1 == 0) {
                                    this.now_eV2 = this.getNpcId(n15);
                                    this.npc[this.now_eV1][this.now_eV2].dir = this.event[n][this.event_now[n] + 3];
                                    this.npc[this.now_eV1][this.now_eV2].setActionNo(false);
                                }
                            }
                            final short[] event_now31 = this.event_now;
                            event_now31[n] += 4;
                            this.nextEvent(4112);
                            break;
                        }
                        case 44: {
                            final byte b2 = this.event[n][this.event_now[n] + 2];
                            if (b2 == 0) {
                                this.ifEvent(n, 3, 16, 2, this.gr.gameCheckRegIsOK());
                                break;
                            }
                            if (b2 == 1) {
                                if (!this.gr.gameCheckRegIsOK()) {
                                    final short[] event_now32 = this.event_now;
                                    event_now32[n] += 3;
                                    this.nextEvent(0);
                                    this.checkRegWhere0(n);
                                    break;
                                }
                                break;
                            }
                            else {
                                if (b2 == 2) {
                                    this.ifEvent(n, 3, 16, 2, this.gr.gameCheckRegIsOK());
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                    }
                } while (this.event_state == 1);
            }
        }
    }
    
    public byte exitMap(final byte[][] array) {
        byte b;
        if (array[this.get_meet][3] == -1) {
            final byte mapNo = this.mapNo;
            this.mapNo = this.lastMap;
            this.lastMap = mapNo;
            this.lastExit = this.get_meet;
            b = -1;
        }
        else {
            final byte mapNo2 = this.mapNo;
            this.mapNo = array[this.get_meet][4];
            this.lastMap = mapNo2;
            this.lastExit = this.get_meet;
            b = array[this.get_meet][3];
        }
        return b;
    }
    
    public byte getMySpeed() {
        byte b;
        if (this.anole_type == 0) {
            b = 6;
        }
        else if (this.anole_type == 1) {
            b = 6;
        }
        else if (this.anole_type == 2) {
            b = 10;
        }
        else if (this.anole_type == 4) {
            b = 5;
        }
        else if (this.anole_type == 3) {
            b = 10;
        }
        else {
            b = 5;
        }
        return b;
    }
    
    public void goMiniMap() {
        Ms.i().keyRelease();
        final byte[] stream = Ms.i().getStream("data/map.d", -1);
        Ms.skip = 0;
        this.mapdataArea = Ms.i().create2Array(stream);
        this.mapdataMap = Ms.i().create2Array(stream);
        final byte[] array = (byte[])null;
        this.my.state = 17;
        this.showArea = -1;
        this.myMiniMap = -1;
        this.selectMap = 0;
    Label_0087:
        for (byte showArea = 0; showArea < this.mapdataArea.length; ++showArea) {
            for (int i = 0; i < this.mapdataArea[showArea].length; i = (byte)(i + 1)) {
                if (this.mapNo == this.mapdataArea[showArea][i]) {
                    this.selectMap = this.mapNo;
                    if (this.mapdataMap[this.selectMap].length > 0) {
                        this.myMiniMap = this.selectMap;
                        this.showArea = showArea;
                        this.miniMapMode = (this.mapdataArea[this.showArea][0] > -1);
                        break Label_0087;
                    }
                }
            }
        }
    }
    
    public void goMission(int i, final boolean bPause) {
        if (this.my.state == 18 || this.my.state == 0) {
            Ms.i().keyRelease();
            this.bPause = bPause;
            GameRun.run_state = -10;
            this.my.state = 18;
            this.gr.cur_a = (byte)i;
            this.gr.select[0][0] = (this.gr.select[0][1] = 0);
            Ms.i();
            Ms.skip = 0;
            this.sMission = Ms.i().createString2Array(Ms.i().getStream("data/mission" + i + ".t", -1));
            this.gr.line_max = 6;
            this.gr.about_a = null;
            if (i == 1) {
                byte b = 0;
                i = 0;
                final byte[] array = new byte[50];
                while (b < this.sMission.length) {
                    int n = i;
                    if (this.isMission(b)) {
                        n = (byte)(i + 1);
                        array[i] = b;
                    }
                    ++b;
                    i = n;
                }
                this.mDirect = null;
                System.arraycopy(array, 0, this.mDirect = new byte[i], 0, this.mDirect.length);
                if (this.mDirect.length > 0) {
                    this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 640 - 50, 0);
                }
                final byte[] array2 = (byte[])null;
            }
            else {
                this.gr.select[0][0] = this.bMission[14];
                if (this.bMission[14] >= this.gr.line_max) {
                    this.gr.select[0][1] = (byte)(this.gr.select[0][0] - this.gr.line_max + 1);
                }
                else {
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
        final byte lastExit = this.lastExit;
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
            this.go = lastExit;
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
        }
        else {
            this.my.setActionNo(false);
        }
        this.gr.b_c = 0;
        this.setMapMusic(false);
        this.go = -2;
        this.gr.initMonPro(this.mapNo, true);
        this.gr.cityName_c = 25;
        this.srcNpcNo = -1;
        Ms.i().rmsOptions(1, null, 4);
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
        boolean b;
        if (this.isAnole(this.my.x, this.my.y, this.anole_type)) {
            this.gr.say("\u4e0d\u80fd\u66f4\u6362\u5750\u9a91", 0);
            b = false;
        }
        else {
            this.my.state = 20;
            this.gr.cur_a = 0;
            this.gr.cur_b = 0;
            this.gr.setStringB("\u4e0b\u5750\u9a91#n\u690d\u7269\u5750\u9a91#n\u91d1\u5c5e\u5750\u9a91#n\u98de\u884c\u5750\u9a91#n\u91ce\u517d\u5750\u9a91#n\u6d77\u6d0b\u5750\u9a91#n\u65e0\u6b64\u5750\u9a91", Constants_H.WIDTH, 0);
            b = true;
        }
        return b;
    }
    
    public void initBrowImage() {
        if (this.brow == null) {
            this.brow = Ms.i().createSprite("data/face/brow", true);
        }
    }
    
    public byte[] initData(final byte[] array, int n) {
        int i = 0;
        int n2 = 1;
        while (i < n) {
            final int n3 = n2 + 1;
            final byte b = array[n2];
            final byte b2 = array[n3];
            ++i;
            n2 = n3 + 1 + ((b & 0xFF) << 8 | (b2 & 0xFF));
        }
        n = n2 + 1;
        final byte[] array2 = new byte[(array[n2] & 0xFF) << 8 | (array[n] & 0xFF)];
        System.arraycopy(array, n + 1, array2, 0, array2.length);
        return array2;
    }
    
    public void initMap() {
        this.my.dir = 4;
        this.srcNpcNo = -1;
        this.gr.loadRmsSms();
        this.gr.loadRmsNidus();
        this.notMeet(0, 0);
        this.mapInfo = Ms.i().byteArrayToShortArray(Ms.i().rmsOptions(13, (byte[])null, 1));
        this.mapChange = Ms.i().rmsOptions(1, null, 1);
        for (int i = 0; i < this.mapChange.length; i = (short)(i + 1)) {
            if (this.mapChange[i] == 1) {
                this.mapTemp[i] = Ms.i().rmsOptions(i + 14, null, 1);
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
        Ms.i().rmsOptions(1, null, 4);
        this.gr.initMonPro(this.mapNo, true);
        this.initMissionList();
        this.initCloud();
    }
    
    public void initNpcAni() {
        int n = 0;
        final byte[][] array = { new byte[100], new byte[5], new byte[60] };
        this.gr.initNidusMap(0);
        for (byte b = (byte)(this.npc.length - 1); b > -1; --b) {
            byte b2 = (byte)(this.npc[b].length - 1);
        Label_0260_Outer:
            while (b2 > -1) {
                array[this.npc[b][b2].other[3] - 1][this.npc[b][b2].other[2]] = 1;
                if (b == 0) {
                    this.npcList[b2 + 1] = b2;
                    if (this.npc[b][b2].other[8] == 1) {
                        final byte[] nidusMap = this.gr.nidusMap;
                        final byte b3 = (byte)(n + 1);
                        nidusMap[n] = b2;
                        n = b3;
                    }
                }
                while (true) {
                    --b2;
                    continue Label_0260_Outer;
                    continue;
                }
            }
        }
        this.gr.initNidusMap(1);
        this.npcList[0] = -1;
        for (byte b4 = (byte)(this.item.length + this.npc[0].length); b4 > this.npc[0].length; --b4) {
            this.npcList[b4] = (byte)(-2 - b4 + this.npc[0].length + 1);
        }
        this.initNpcAni_1(100, 0, array[0]);
        this.initNpcAni_1(5, 1, array[1]);
        this.initNpcAni_1(60, 2, array[2]);
        final byte[][] array2 = (byte[][])null;
        for (byte b5 = (byte)(this.npc[0].length - 1); b5 > -1; --b5) {
            this.npc[0][b5].setNpcNum(Map.npcSp[this.npc[0][b5].other[3] - 1][this.npc[0][b5].other[2]].aLength());
        }
    }
    
    public void initNpcAniOne(final String s, final int n, final int i) {
        Map.npcSp[i][n] = Ms.i().createSprite("data/npc" + i + "/" + s, i != 2 || this.gr.isNpc2ImageType(Integer.parseInt(s)));
    }
    
    public void initNpcFaceOne(final String s) {
        if (s != null) {
            byte b = -1;
            this.faceDir = true;
            if (s.equals("\u585e\u5176")) {
                b = 0;
                this.faceDir = false;
            }
            else if (s.equals("\u5b89\u742a\u513f") || s.equals("\u84dd\u53d1\u5973\u5b69")) {
                b = 1;
            }
            else if (s.equals("\u5e7d\u6697\u9b3c\u738b")) {
                b = 2;
            }
            else if (s.equals("\u6770\u5947\u6821\u957f")) {
                b = 3;
            }
            else if (s.equals("\u666e\u7f57") || s.equals("\u666e\u7f57\u6821\u957f")) {
                b = 4;
            }
            else if (s.equals("\u795e\u79d8\u4e1c\u65b9\u7537\u5b50")) {
                b = 5;
            }
            else if (s.equals("\u5357\u5bab\u4e91")) {
                b = 6;
            }
            if (b > -1) {
                if (this.imgFace == null || this.faceLast != b) {
                    int n;
                    if (this.faceDir) {
                        n = 50;
                    }
                    else {
                        n = -50;
                    }
                    this.face_c = (short)n;
                    this.faceLast = b;
                    this.imgFace = null;
                    this.imgFace = Ms.i().createImage("data/face/" + b);
                }
            }
            else {
                this.nullNpcFace();
            }
        }
    }
    
    public boolean initSrcEffect(final int n) {
        int src_BATTLE_H__ = Constants_H.SRC_BATTLE_H__;
        this.my.state = 10;
        switch (n) {
            case 0:
            case 1:
            case 2: {
                this.bSrc_c = 0;
                if (n != 1) {
                    src_BATTLE_H__ = 0;
                }
                this.black_width = (short)src_BATTLE_H__;
                this.bSrc = (n == 1);
                return true;
            }
            case 3:
            case 4:
            case 5:
            case 6: {
                this.bSrc = true;
                if (this.bSrc_c == 0) {
                    if (n == 6 || n == 5) {
                        this.bSrc_c = -40;
                        int n2;
                        if (n == 5) {
                            n2 = 40;
                        }
                        else {
                            n2 = 0;
                        }
                        this.black_width = (short)n2;
                    }
                    else {
                        if (n != 4) {
                            src_BATTLE_H__ = 40;
                        }
                        final short n3 = (short)src_BATTLE_H__;
                        this.bSrc_c = n3;
                        this.black_width = n3;
                    }
                }
                this.bSrc_c = Ms.i().mathSpeedN(this.bSrc_c, 0, 12, false);
                if (this.bSrc_c == 0) {
                    this.bSrc = (n != 6);
                    return true;
                }
                break;
            }
        }
        return false;
    }
    
    public void initWalkIco() {
        if (this.walkIco == null) {
            this.walkIco = Ms.i().createImageArray(3, "data/brow/w");
        }
    }
    
    public void insertNpc() {
        if (this.npc != null) {
            for (int i = 1; i < this.npcList.length; i = (byte)(i + 1)) {
                for (int j = i; j > 0; j = (byte)(j - 1)) {
                    final short npcListY = this.getNpcListY(j);
                    final short npcListY2 = this.getNpcListY(j - 1);
                    if (npcListY > npcListY2) {
                        break;
                    }
                    if (npcListY != npcListY2 || (npcListY == npcListY2 && this.npcList[j - 1] == -1)) {
                        final byte b = this.npcList[j];
                        this.npcList[j] = this.npcList[j - 1];
                        this.npcList[j - 1] = b;
                    }
                }
            }
        }
    }
    
    public void key_map() {
        if (this.my.state == 17) {
            this.keyMiniMap();
        }
        else if (this.my.state == 18) {
            this.keyMission();
        }
        else if (this.my.state == 12) {
            this.keySelectMenu();
        }
        else if (this.my.state == 19) {
            this.keyMySave();
        }
        else if (this.my.state == 22 && this.black_0 > -1 && this.black_0 == this.gr.about_d.length && Ms.i().key_Num0()) {
            this.eventGoing = 3;
            this.black_0 = -1;
            Ms.i().keyRelease();
        }
        else {
            if (this.my.state == 16) {
                if (Ms.i().key_delay()) {
                    return;
                }
                if (Ms.i().key_Up_Down()) {
                    final GameRun gr = this.gr;
                    gr.popMenu ^= 0x1;
                }
                else if (Ms.i().key_S1_Num5() || Ms.i().key_S2()) {
                    if (Ms.i().key_S2()) {
                        this.gr.popMenu = 1;
                    }
                    this.my.state = 0;
                    return;
                }
            }
            else {
                if (this.my.state == 10) {
                    Ms.i().keyRelease();
                    return;
                }
                if (this.my.state == 23) {
                    if (Ms.i().key_S2()) {
                        this.my.state = 25;
                    }
                    else if (Ms.i().key_S1_Num5()) {
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
                else if (this.my.state == 20) {
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
                    }
                    else {
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
                else {
                    this.dialog_no += 2;
                    Ms.i().keyRelease();
                }
            }
            if (this.my.frame_c <= 0 && this.my.state == 0) {
                Ms.i();
                this.map_key = (byte)(-Ms.key);
                this.doKey();
            }
        }
    }
    
    public void loadDate_Rms() {
        byte[] rmsOptions = Ms.i().rmsOptions(2, null, 1);
        if (rmsOptions[0] == -1) {
            Ms.i().rmsOptions(2, rmsOptions = new byte[] { 58, 9, 16, 2, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, -1 }, 2);
            final byte[] array = (byte[])null;
            this.event_now_list = new short[70][];
            Ms.i().rmsOptions(12, Ms.i().getEventNowData(this.event_now_list), 2);
        }
        else {
            this.event_now_list = Ms.i().readEventNowData();
        }
        this.mapNo = rmsOptions[0];
        this.lastMap = rmsOptions[5];
        this.lastExit = rmsOptions[6];
        this.my.setXY(rmsOptions[1], rmsOptions[2], 0, 0);
        this.my.dir = rmsOptions[3];
        this.my.setActionNo(false);
        this.gr.money = Ms.i().getInt(rmsOptions, 7);
        this.gr.coin = Ms.i().getInt(rmsOptions, 11);
        this.anole_type = rmsOptions[15];
        final byte[] array2 = (byte[])null;
    }
    
    public void mapMove(final int n, final int n2, final int n3, final int n4) {
        if ((n3 > 0 && n >= this.mapLeft_NOmove && n < this.mapRight_NOmove) || (n3 < 0 && n > this.mapLeft_NOmove && n <= this.mapRight_NOmove)) {
            this.map_x -= n3;
        }
        if ((n4 > 0 && n2 >= this.mapUp_NOmove && n2 < this.mapDown_NOmove) || (n4 < 0 && n2 > this.mapUp_NOmove && n2 <= this.mapDown_NOmove)) {
            this.map_y -= n4;
        }
    }
    
    public void map_saveGame() {
        final byte[] array = new byte[16];
        array[0] = this.mapNo;
        array[5] = this.lastMap;
        array[6] = this.lastExit;
        array[1] = (byte)(this.my.x / 20);
        array[2] = (byte)(this.my.y / 20);
        array[3] = this.my.dir;
        Ms.i().putInt(this.gr.money, array, 7);
        Ms.i().putInt(this.gr.coin, array, 11);
        array[15] = this.anole_type;
        Ms.i().rmsOptions(2, array, 2);
        final byte[] array2 = (byte[])null;
    }
    
    public void notMeet(int n, final int n2) {
        if (n == 0) {
            this.notMeet = 0;
            Ms.i();
            this.step_MEET = (short)(Ms.getRandom(30) + 1);
            this.meet_step = (short)((this.step_MEET - 15) * (this.step_MEET - 15));
            n = this.meet_step;
            Ms.i();
            if (n > Ms.getRandom(50)) {
                Ms.i();
                n = Ms.getRandom(9);
                Ms.i();
                this.step_MEET = (byte)(n + 17 - Ms.getRandom(7));
            }
            this.step_MEET <<= 2;
            this.meet_step = 0;
            this.bStep = -1;
        }
        else if (n == 1) {
            this.notMeet = 1;
            this.step_MEET = (short)((n2 - 14 + 1) * 200);
            this.step_MEET <<= 2;
            this.meet_step = 0;
            this.bStep = 100;
        }
    }
    
    public void nullNpcFace() {
        this.imgFace = null;
    }
    
    public void paint_map(final Graphics g) {
        Map.g = g;
        if (this.my.state == 6) {
            this.gr.drawChangeMap(false, this.gr.b_c, 30, 360 - 38, 640 - 60);
        }
        else if (this.my.state == 17) {
            this.drawMiniMap();
        }
        else if (this.my.state == 18) {
            this.drawMission();
        }
        else {
            Ui.i().fillRect(this.bgColor, 0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
            GameRun.mc.setScale(MainCanvas.mapxx, MainCanvas.mapyy);
            GameRun.mc.keyxx = MainCanvas.mapxx;
            GameRun.mc.keyyy = MainCanvas.mapyy;
            this.setMapOffer();
            if (this.xxx > 0) {
                --this.xxx;
                g.translate(this.xxx % 2, this.xxx % 2);
            }
            this.drawMap(GameRun.offG);
            this.drawNpcAni(this.npc[2]);
            if (this.pkey.isGo) {
                if (this.ii++ > 2) {
                    this.ii = 0;
                    int i;
                    if (this.i++ < 2) {
                        i = this.i;
                    }
                    else {
                        i = 0;
                    }
                    this.i = i;
                }
                Ui.i().drawImage(this.walkIco[this.i], this.pkey.gox + this.map_x, this.pkey.goy + this.map_y, 3);
            }
            this.drawNMAni(this.npc[0]);
            this.bkgroundToPaint(this.frontData, this.mapImg, -this.map_x, -this.map_y - 1, this.moduleData, g, 0, 0, Constants_H.WIDTH, Constants_H.HEIGHT, false);
            this.drawNpcAni(this.npc[1]);
            this.drawMapRect(g);
            this.drawStep(g, Constants_H.WIDTH - 17, 0, 16);
            this.drawBrow();
            this.drawCheck5(4);
            this.drawCloud();
            if (this.gr.magic_id > -1) {
                final GameRun gr = this.gr;
                int n;
                if (this.gr.magic_id / 5 > 5) {
                    n = 5;
                }
                else {
                    n = this.gr.magic_id / 5;
                }
                int n2;
                if (this.gr.magic_id / 5 > 5) {
                    n2 = 5;
                }
                else {
                    n2 = this.gr.magic_id / 5;
                }
                int n3;
                if (this.gr.magic_id / 5 >= 5) {
                    n3 = this.gr.magic_id - 25;
                }
                else {
                    n3 = this.gr.magic_id % 5;
                }
                if (gr.drawMagicC(n, n2, n3, this.gr.magic_x, this.gr.magic_y + 16, 0)) {
                    if (this.my.state == 21) {
                        this.gr.magic_id = -2;
                        this.setAnole();
                    }
                    else {
                        this.gr.magic_id = -1;
                    }
                    this.my.state = 0;
                }
            }
            g.translate(-g.getTranslateX(), -g.getTranslateY());
            if (this.my.state == 20) {
                this.drawAnoleSel();
            }
            g.restCanvas();
            if (!this.fontSizeControl) {
                Ms.i();
                Ms.font.setSize(22);
            }
            this.drawSrcEffect();
            if (this.my.state == 12) {
                this.gr.drawSelectMenu_(this.gr.action_str, Constants_H.WIDTH__ / 2 - 25 * 3, Constants_H.HEIGHT__ / 2 - 100 + (this.gr.action_str.length >> 1) * 25, 25 * 6, 0, 0, this.gr.cur_a);
            }
            if (this.gr.view_state == 4) {
                final int width__ = Constants_H.WIDTH__;
                final int height__ = Constants_H.HEIGHT__;
                final int n4 = Constants_H.WIDTH__ / 2;
                Ui.i().drawKuang(0, height__ - 25 * 3, width__, 25 * 3);
                this.gr.showStringM_(this.gr.getNameMonsterInfo((int)(new byte[] { 4, 25, 56 })[this.gr.cur_a]), n4, height__ - 25 * 2 - 8, 10, 3);
                final byte[] array = (byte[])null;
            }
            else if (this.my.state == 16) {
                final int width__2 = Constants_H.WIDTH__;
                final int height__2 = Constants_H.HEIGHT__;
                final int n5 = Constants_H.WIDTH__ / 2;
                final int n6 = Constants_H.HEIGHT__ / 2;
                Ui.i().drawKuang(0, height__2 - 25 * 4, width__2, 25 * 4);
                this.gr.showStringM_("\u662f\u5426\u56de\u590d\u6240\u6709\u5ba0\u7269\uff1f", n5, height__2 - 25 * 4 + 4, 10, 3);
                this.gr.drawSelectMenu_(this.gr.action_str, n5 - 25 * 2, n6 - 25, 25 * 4, -1, 0, this.gr.popMenu);
                this.gr.showStringM_("\u6240\u9700\u91d1\u989d\uff1a" + this.gr.sell_money, n5, height__2 - 25 * 3 + 4, 10, 3);
                this.gr.drawMoney(n5, height__2 - 25 + 15, 3, false);
            }
            if (this.my.state != 20) {
                this.gr.drawPauseIco(this.my.state);
            }
            if (this.my.state == 19) {
                this.drawMySave();
            }
            else {
                final byte b = this.gr.rmsOther[2];
                this.gr.drawCityName();
                if (this.my.state == 23) {
                    final int width__3 = Constants_H.WIDTH__;
                    final int height__3 = Constants_H.HEIGHT__;
                    final int n7 = Constants_H.WIDTH__ / 2;
                    Ui.i().drawKuang(0, height__3 - 25 * 2, width__3, 25 * 2);
                    Ui.i().drawString("\u662f\u5426\u4fdd\u5b58\u8fdb\u5ea6\uff1f", n7, height__3 - 25 * 2 + 6, 17, 3, 0);
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
        }
        else {
            if (this.my.state == 2 && this.eventGoing == 0) {
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
                }
                else {
                    this.my.state = 0;
                }
            }
            else if (this.my.state == 8 && this.my.frame_c == -1) {
                if (this.gr.immueEnemy == 0) {
                    Log.e("sk", "gr.immueEnemy==0");
                    final GameRun gr = this.gr;
                    final String[] battleSay = this.gr.battleSay;
                    Ms.i();
                    gr.say(battleSay[Ms.getRandom(3)], 0);
                    GameRun.mc.repaint();
                    this.gr.battleType(4);
                    this.gr.goBattlePVC();
                }
                else {
                    this.my.state = 0;
                }
            }
            this.runMove();
        }
    }
    
    public void save() {
        this.map_saveGame();
        this.saveNpc();
        for (int i = 0; i < this.mapInfo.length / 2; ++i) {
            if (this.mapChange[i] == 1) {
                this.mapChange[i] = 0;
                Ms.i().rmsOptions(i + 14, this.mapTemp[i], 2);
            }
        }
        Ms.i().rmsOptions(13, Ms.i().shortArrayToByteArray(this.mapInfo), 2);
        Ms.i().rmsOptions(12, Ms.i().getEventNowData(this.event_now_list), 2);
        Ms.i().rmsOptions(1, this.mapChange, 2);
        Ms.i().rmsOptions(7, this.bMission, 2);
        Ms.i().rmsOptions(5, this.gr.rmsSms, 2);
        Ms.i().rmsOptions(1, null, 4);
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
        final GameRun gr = this.gr;
        int n;
        if (this.anole_type == 3) {
            n = 1;
        }
        else {
            n = 0;
        }
        gr.immueEnemy = (byte)n;
        this.my.speed = this.getMySpeed();
        final Ms i = Ms.i();
        final Sprite sprite = Map.npcSp[1][0];
        final StringBuilder sb = new StringBuilder("data/npc1/");
        String string;
        if (this.anole_type == -1) {
            string = "0";
        }
        else {
            string = "r" + this.anole_type;
        }
        i.setSprite(sprite, sb.append(string).toString(), this.anole_type == -1);
        this.my.setActionNo(false);
    }
    
    public void setMapMusic(final boolean music) {
        Sound.i().setMusicId(this.gr.musicNo[this.mapNo]);
        Sound.i().setMusic(music);
    }
    
    public void setMission(int n, final boolean b) {
        final byte b2 = (byte)(n / 8);
        n = (byte)(n % 8);
        if (b) {
            final byte[] bMission = this.bMission;
            bMission[b2] |= (byte)(1 << n);
        }
        else if ((this.bMission[b2] & 1 << n) != 0x0) {
            final byte[] bMission2 = this.bMission;
            bMission2[b2] ^= (byte)(1 << n);
            final byte[] bMission3 = this.bMission;
            ++bMission3[15];
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
    
    public void setOverEvent(final int n, final int n2) {
        if (!this.isMapEvent(n, n2)) {
            final short[] mapInfo = this.mapInfo;
            final int n3 = n * 2 + 1;
            mapInfo[n3] |= (short)(1 << n2);
        }
        if (n == this.mapNo) {
            this.event_now[n2] = 24224;
        }
        else if (this.event_now_list[n] != null) {
            this.event_now_list[n][n2] = 24224;
        }
    }
    
    public void setRegState(final boolean b) {
        synchronized (this) {
            System.out.println("setRegState() notifyAll start isSuccess= " + b);
            this.isNeedWait = false;
            this.notifyAll();
            System.out.println("setRegState() notifyAll over");
        }
    }
    
    public void setRestEvent(final int n, final int n2) {
        if (this.isMapEvent(n, n2)) {
            final short[] mapInfo = this.mapInfo;
            final int n3 = n * 2 + 1;
            mapInfo[n3] ^= (short)(1 << n2);
        }
        if (n == this.mapNo) {
            this.event_now[n2] = 0;
        }
        else if (this.event_now_list[n] != null) {
            this.event_now_list[n][n2] = 0;
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
