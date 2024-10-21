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
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import minigame.Mg;

public class Map implements Key_H {
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
    private static Npc cur_npc;
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
    private static Graphics g;
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
    static Sprite[][] npcSp;
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

    public Map(GameRun gameRun) {
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
        this.dir_select = new byte[][]{new byte[2], new byte[]{0, -1}, new byte[]{0, 1}, new byte[]{-1, 0}, new byte[]{1, 0}};
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
        this.gr = gameRun;
        System.gc();
        this.init();
    }

    public void addAnole(int i) {
        int v1;
        if(i != 13 && i != 34 && i != 49 && i != 66 && i != 82) {
            return;
        }
        if(i == 13) {
            v1 = 0;
        }
        else if(i == 34) {
            v1 = 1;
        }
        else if(i == 49) {
            v1 = 2;
        }
        else {
            v1 = i == 66 ? 3 : 4;
        }
        byte[] arr_b = this.gr.rmsOther;
        arr_b[2] = (byte)(arr_b[2] | 1 << v1);
    }

    private void addCloud(int i) {
        short[] arr_v = this.cloud[i];
        int v1 = this.leftCol * 20 + Constants_H.WIDTH;
        Ms.i();
        arr_v[0] = (short)(v1 + Ms.getRandom(Constants_H.WIDTH_H));
        short[] arr_v1 = this.cloud[i];
        int v2 = this.topRow * 20 + 22;
        Ms.i();
        arr_v1[1] = (short)(v2 + (Ms.getRandom(25) + 55) * i);
        short[] arr_v2 = this.cloud[i];
        Ms.i();
        arr_v2[2] = (short)(Ms.getRandom(3) + 1);
    }

    public void bkEvent_getMon() {
        GameRun.run_state = -10;
    }

    public void bkgroundToPaint(short[] bkgroundData, Image[] img, int screen_x, int screen_y, short[][] moduleData, Graphics gtem, int x1, int y1, int x2, int y2, boolean fillBlack) {
        int bkPic_h;
        int bkPic_w;
        if(bkgroundData != null) {
            if(fillBlack) {
                gtem.setClip(x1, y1, x2 - x1, y2 - y1);
                gtem.setColor(this.bgColor);
                gtem.fillRect(x1, y1, x2 - x1, y2 - y1);
            }
            for(int i = 0; i < bkgroundData.length; i += 3) {
                if(bkgroundData[i + 2] >= 0) {
                    int bkdata_id = bkgroundData[i + 2] >> 3;
                    int bkdata_trans = bkgroundData[i + 2] & 3;
                    int realX = bkgroundData[i] * 20 - screen_x;
                    int realY = bkgroundData[i + 1] * 20 - (screen_y - 20);
                    if(bkdata_trans % 2 == 1) {
                        bkPic_w = moduleData[bkdata_id][4];
                        bkPic_h = moduleData[bkdata_id][3];
                    }
                    else {
                        bkPic_w = moduleData[bkdata_id][3];
                        bkPic_h = moduleData[bkdata_id][4];
                    }
                    if(realX + bkPic_w >= x1 && realX <= x2 && realY >= y1 && realY - bkPic_h <= y2) {
                        Ui.i().drawRegion(img[moduleData[bkdata_id][0]], ((int)moduleData[bkdata_id][1]), ((int)moduleData[bkdata_id][2]), ((int)moduleData[bkdata_id][3]), ((int)moduleData[bkdata_id][4]), realX, realY, 36, bkgroundData[i + 2] & 7, gtem);
                    }
                }
            }
        }
    }

    private void canMove(int temp_xspeed, int temp_yspeed) {
        this.my.speed_x = (byte)temp_xspeed;
        this.my.speed_y = (byte)temp_yspeed;
        if(this.my.x + this.my.speed_x >= 0 && this.my.x + this.my.speed_x + 19 < this.cols * 20 && this.my.y + this.my.speed_y >= 0 && this.my.y + this.my.speed_y + 19 < this.rows * 20) {
            this.roadType = this.checkMap(((int)this.my.x), ((int)this.my.y), ((int)this.my.speed_x), ((int)this.my.speed_y));
            if(this.roadType == 0) {
                this.initMoveMy();
                return;
            }
            if(this.checkMoveOff(((int)this.checkNpcT))) {
                this.initMoveMy();
                return;
            }
            if(this.checkNpcT == -1 || this.isCheckNpcOff()) {
                this.roadType = this.isMapChenk(this.roadType);
                if(this.roadType == -1) {
                    this.moveOff(3, 1, -this.my.speed);
                    return;
                }
                if(this.roadType == -2) {
                    this.moveOff(4, 2, ((int)this.my.speed));
                    return;
                }
                this.checkAnole();
                return;
            }
            Ms.i().keyRelease();
            this.setMoveStop_m();
            return;
        }
        this.setMoveStop_m();
        this.checkType = this.checkIfOther(this.door, ((int)this.my.x), ((int)this.my.y));
        if(this.checkType != -1 && this.door[this.checkType][5] == 0 && this.map_key == this.door[this.checkType][2]) {
            this.my.state = 5;
            this.get_meet = this.checkType;
        }
    }

    private void checkAnole() {
        this.checkType = this.checkWorld(((int)this.my.x), ((int)this.my.y), ((int)this.my.speed_x), ((int)this.my.speed_y), true);
        if(this.checkType != 2) {
            switch(this.checkType) {
                case 0: {
                    if(this.anole_type == 4) {
                        this.anole_type = this.anole_type != 3 && this.isAnoleType(3) ? 3 : -1;
                        this.setAnole();
                        this.initMoveMy();
                        return;
                    }
                    break;
                }
                case 3: {
                    if(this.isCheckAnole(0)) {
                        return;
                    }
                    break;
                }
                case 4: {
                    if(this.isCheckAnole(2)) {
                        return;
                    }
                }
            }
        }
        else if(this.isCheckAnole(4)) {
            return;
        }
        Ms.i().keyRelease();
        this.setMoveStop_m();
    }

    private byte checkIfNpc(Npc[] npc, int ix, int iy) {
        for(byte i = (byte)(npc.length - 1); true; i = (byte)(i - 1)) {
            if(i <= -1) {
                return -1;
            }
            if(Ms.i().isRect(ix, iy, 19, 19, ((int)npc[i].x), ((int)npc[i].y), 20, 20)) {
                switch(npc[i].other[4]) {
                    case 1: 
                    case 3: {
                        return i;
                    }
                }
            }
        }
    }

    private byte checkIfOther(byte[][] data, int ix, int iy) {
        for(byte i = (byte)(data.length - 1); true; i = (byte)(i - 1)) {
            if(i <= -1) {
                return -1;
            }
            if(Ms.i().isRect(ix, iy, 19, 19, data[i][0] * 20, data[i][1] * 20, 20, 20)) {
                return i;
            }
        }
    }

    private byte checkMap(int A_X, int A_Y, int _speed_x, int _speed_y) {
        this.checkNpcT = -1;
        this.checkType = this.checkIfOther(this.item, A_X + _speed_x, A_Y + _speed_y);
        if(this.checkType != -1) {
            this.checkNpcT = -2;
            return 1;
        }
        if(A_X + _speed_x < 0 || A_X + _speed_x >= this.cols * 20 || A_Y + _speed_y < 0 || A_Y + _speed_y >= this.rows * 20) {
            return 1;
        }
        this.checkType = this.checkIfNpc(this.npc[0], A_X + _speed_x, A_Y + _speed_y);
        if(this.checkType != -1) {
            if(!this.npcNameData[this.checkType].equals("路人") || this.npc[0][this.checkType].other[5] > 0) {
                this.checkNpcT = this.checkType;
            }
            return 1;
        }
        this.checkType = this.checkIfOther(this.door, A_X + _speed_x, A_Y + _speed_y);
        if(this.checkType != -1 && (this.door[this.checkType][5] == 2 || this.map_key == this.door[this.checkType][2])) {
            this.my.state = 5;
            this.get_meet = this.checkType;
            return 0;
        }
        return this.checkWorld(A_X, A_Y, _speed_x, _speed_y, false);
    }

    private boolean checkMoveOff(int npcid) {
        if(npcid > -1) {
            byte oxl = (byte)(this.npc[0][npcid].x + 20 - this.my.x);
            byte oxr = (byte)(this.npc[0][npcid].x - this.my.x - 20);
            byte oyl = (byte)(this.npc[0][npcid].y + 20 - this.my.y);
            byte oyr = (byte)(this.npc[0][npcid].y - this.my.y - 20);
            if(this.my.speed_x < 0 && oxl != 0) {
                this.my.speed_x = oxl >= this.my.speed_x ? oxl : this.my.speed_x;
                return true;
            }
            if(this.my.speed_x > 0 && oxr != 0) {
                this.my.speed_x = oxr >= this.my.speed_x ? this.my.speed_x : oxr;
                return true;
            }
            if(this.my.speed_y < 0 && oyl != 0) {
                this.my.speed_y = oyl >= this.my.speed_y ? oyl : this.my.speed_y;
                return true;
            }
            if(this.my.speed_y > 0 && oyr != 0) {
                this.my.speed_y = oyr >= this.my.speed_y ? this.my.speed_y : oyr;
                return true;
            }
        }
        else {
            int v1 = this.my.getIx_off();
            byte oxr = (byte)(20 - this.my.getIx_off());
            int v2 = this.my.getIy_off();
            byte oyr = (byte)(20 - this.my.getIy_off());
            if(this.my.speed_x != 0 && v1 != 0) {
                if(this.my.speed_x < 0) {
                    Npc npc0 = this.my;
                    int v3 = -v1 < this.my.speed_x ? this.my.speed_x : -v1;
                    npc0.speed_x = (byte)v3;
                    return true;
                }
                this.my.speed_x = oxr >= this.my.speed_x ? this.my.speed_x : oxr;
                return true;
            }
            if(this.my.speed_y != 0 && v2 != 0) {
                if(this.my.speed_y < 0) {
                    Npc npc1 = this.my;
                    int v4 = -v2 < this.my.speed_y ? this.my.speed_y : -v2;
                    npc1.speed_y = (byte)v4;
                    return true;
                }
                this.my.speed_y = oyr >= this.my.speed_y ? this.my.speed_y : oyr;
                return true;
            }
        }
        return false;
    }

    public void checkRegWhere0(int i) {
        synchronized(this) {
            this.isNeedWait = true;
            SMSSender.i(this.gr).go(2, true);
            SMSSender.i(this.gr).run();
            try {
                System.out.println("wait() start");
                this.wait();
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
            }
            System.out.println("wait() over");
        }
    }

    public byte checkSoftKey(int A_X, int A_Y, int _speed_x, int _speed_y) {
        if(A_X + _speed_x < 0 || A_X + _speed_x >= this.cols * 20 || A_Y + _speed_y < 0 || A_Y + _speed_y >= this.rows * 20) {
            return 0;
        }
        byte type = this.checkIfNpc(this.npc[0], A_X + _speed_x, A_Y + _speed_y);
        if(this.my.state == 0 && type != -1) {
            if(this.anole_type == 1 && this.npc[0][type].other[8] == 4) {
                this.npc[0][type].other[8] = -4;
                byte[] arr_b = this.npc[0][type].other;
                arr_b[7] = (byte)(arr_b[7] + 1);
                this.npc[0][type].now_action = 0;
                this.npc[0][type].now_time = 0;
                return 9;
            }
            if(this.npc[0][type].other[8] != -4) {
                this.my.state = 2;
                this.get_meet = type;
                switch(this.npc[0][type].other[8]) {
                    case 2: 
                    case 3: {
                        break;
                    }
                    default: {
                        if(!this.npcNameData[type].equals("路人")) {
                            this.bDirTalk = true;
                            this.npcDirTalk = this.npc[0][type].other[7];
                            byte[] arr_b1 = this.npc[0][type].other;
                            Ms.i();
                            arr_b1[7] = (byte)(Ms.abs(this.npcDirTalk) / 3 * 3 + (this.my.dir >= 4 ? this.my.dir - 2 : this.my.dir - 1));
                            if(this.my.dir == 3) {
                                this.npc[0][type].other[7] = (byte)(-this.npc[0][type].other[7]);
                                return 9;
                            }
                            this.npc[0][type].dir = 3;
                            return 9;
                        }
                    }
                }
                this.bDirTalk = false;
                return 9;
            }
            return 9;
        }
        byte type = this.checkIfOther(this.item, A_X + _speed_x, A_Y + _speed_y);
        if(type != -1 && this.item[type][2] != -1) {
            Ms.i().keyRelease();
            this.get_meet = type;
            this.getItem();
            return 0;
        }
        return -1;
    }

    private byte checkWorld(int A_X, int A_Y, int _speed_x, int _speed_y, boolean mode) {
        int ix;
        int iy;
        int check_n = 1;
        if(_speed_x == 0 && A_X % 20 != 0 || _speed_y == 0 && A_Y % 20 != 0) {
            check_n = 2;
        }
        for(int i = 0; true; i = (byte)(i + 1)) {
            if(i >= check_n) {
                return 0;
            }
            if(_speed_y == 0) {
                iy = (byte)((i * 20 + A_Y) / 20);
                ix = (byte)(_speed_x < 0 ? (A_X + _speed_x) / 20 : (A_X + _speed_x + 19) / 20);
            }
            else {
                ix = (byte)((i * 20 + A_X) / 20);
                iy = (byte)(_speed_y < 0 ? (A_Y + _speed_y) / 20 : (A_Y + _speed_y + 19) / 20);
            }
            if(mode) {
                if(this.worldData[ix][iy] != 0) {
                    return (byte)this.worldData[ix][iy];
                }
            }
            else if(this.isCan_not_pass(ix, iy)) {
                return 1;
            }
        }
    }

    public void chuansong(int mapno, int door) {
        this.my.state = 5;
        this.mapNotemp = (byte)mapno;
        this.go = (byte)door;
        this.setMoveStop_m();
    }

    private void configureNpc() {
        Map.npcSp[0] = new Sprite[100];
        Map.npcSp[1] = new Sprite[5];
        Map.npcSp[2] = new Sprite[60];
    }

    public void createEvent() {
        byte[] arr_b = Ms.i().getStream("event", ((int)this.mapNo));
        if(arr_b.length == 1) {
            this.eventCount = 0;
            return;
        }
        this.eventCount = arr_b[0];
        if(this.mapInfo[this.mapNo * 2] < 1) {
            this.event_now_list[this.mapNo] = null;
            this.event_now_list[this.mapNo] = new short[this.eventCount];
        }
        else {
            for(int i = 0; i < this.eventCount; i = (byte)(i + 1)) {
                if(this.isMapEvent(((int)this.mapNo), i)) {
                    this.event_now_list[this.mapNo][i] = 0x5EA0;
                }
            }
        }
        this.event_now = this.event_now_list[this.mapNo];
        this.event = new byte[this.eventCount][];
        int start_pos = 1;
        for(int i = 0; i < this.eventCount; i = (byte)(i + 1)) {
            int length_ = (short)(arr_b[start_pos] << 8 | arr_b[start_pos + 1] & 0xFF);
            this.event[i] = new byte[length_];
            System.arraycopy(arr_b, start_pos + 2, this.event[i], 0, this.event[i].length);
            start_pos = start_pos + 2 + length_;
        }
    }

    byte[][] createItem(byte[] data, byte[][] npc) {
        byte[][] arr2_b1;
        if(this.mapInfo[this.mapNo * 2] > 0) {
            byte[] arr_b1 = this.mapTemp[this.mapNo];
            Ms.i();
            int v = Ms.skip2;
            Ms.skip2 = v + 1;
            arr2_b1 = new byte[arr_b1[v]][];
            for(int i = 0; i < arr2_b1.length; ++i) {
                Ms.i();
                int v2 = Ms.skip2;
                Ms.skip2 = v2 + 1;
                arr2_b1[i] = new byte[arr_b1[v2]];
                for(int j = 0; j < arr2_b1[i].length; ++j) {
                    byte[] arr_b2 = arr2_b1[i];
                    Ms.i();
                    int v4 = Ms.skip2;
                    Ms.skip2 = v4 + 1;
                    arr_b2[j] = arr_b1[v4];
                }
            }
            return arr2_b1;
        }
        Ms.i();
        int v5 = Ms.skip;
        Ms.skip = v5 + 1;
        arr2_b1 = new byte[data[v5]][];
        for(int i = 0; i < arr2_b1.length; ++i) {
            Ms.i();
            int v7 = Ms.skip;
            Ms.skip = v7 + 1;
            arr2_b1[i] = new byte[data[v7]];
            for(int j = 0; j < arr2_b1[i].length; ++j) {
                byte[] arr_b3 = arr2_b1[i];
                Ms.i();
                int v9 = Ms.skip;
                Ms.skip = v9 + 1;
                arr_b3[j] = data[v9];
            }
        }
        return arr2_b1;
    }

    public void createLayer() {
        this.createMap();
        this.setMapData();
    }

    private void createMap() {
        this.loadMapModuleAndImage();
        this.loadMapData(((int)this.mapNo));
    }

    Npc[] createNpc(byte[] data, Npc[] npc) {
        Ms.i();
        int v = Ms.skip;
        Ms.skip = v + 1;
        Npc[] arr_npc1 = new Npc[data[v]];
        for(int i = 0; i < arr_npc1.length; ++i) {
            Ms.i();
            int v2 = Ms.skip;
            Ms.skip = v2 + 1;
            arr_npc1[i] = new Npc(((int)data[v2]));
            for(int j = 0; j < arr_npc1[i].other.length; ++j) {
                byte[] arr_b1 = arr_npc1[i].other;
                Ms.i();
                int v4 = Ms.skip;
                Ms.skip = v4 + 1;
                arr_b1[j] = data[v4];
            }
            arr_npc1[i].setXY_npc();
        }
        if(this.mapInfo[this.mapNo * 2] > 0) {
            for(int i = 0; i < arr_npc1.length; ++i) {
                if(arr_npc1[i].other[9] == 1) {
                    for(int j = 0; j < arr_npc1[i].other.length; ++j) {
                        byte[] arr_b2 = arr_npc1[i].other;
                        byte[] arr_b3 = this.mapTemp[this.mapNo];
                        Ms.i();
                        int v7 = Ms.skip2;
                        Ms.skip2 = v7 + 1;
                        arr_b2[j] = arr_b3[v7];
                    }
                    arr_npc1[i].setXY_npc();
                }
            }
        }
        return arr_npc1;
    }

    public byte[] createNpcPos(byte[] data, byte[] npc) {
        Ms.i();
        int v = Ms.skip;
        Ms.skip = v + 1;
        byte[] arr_b2 = new byte[data[v]];
        for(int i = 0; i < arr_b2.length; ++i) {
            Ms.i();
            int v2 = Ms.skip;
            Ms.skip = v2 + 1;
            arr_b2[i] = data[v2];
        }
        return arr_b2;
    }

    public void createNpcString() {
        this.npcNameData = Ms.i().loadText(this.initData(this.gr.createData(1), ((int)this.mapNo)));
        this.npcStringData = Ms.i().loadText(this.initData(this.gr.createData(2), ((int)this.mapNo)));
    }

    public void createOther() {
        Ms.i();
        Ms.skip = 0;
        Ms.i();
        Ms.skip2 = 0;
        byte[] Datas = this.initData(this.gr.createData(0), ((int)this.mapNo));
        this.npcPos = this.createNpcPos(Datas, this.npcPos);
        if(this.mapInfo[this.mapNo * 2] > 0 && this.mapTemp[this.mapNo] == null) {
            byte[][] arr2_b = this.mapTemp;
            int v = this.mapNo;
            arr2_b[v] = Ms.i().rmsOptions(this.mapNo + 14, null, 1);
        }
        Npc[][] arr2_npc = this.npc;
        arr2_npc[0] = this.createNpc(Datas, this.npc[0]);
        Npc[][] arr2_npc1 = this.npc;
        arr2_npc1[1] = this.createNpc(Datas, this.npc[1]);
        Npc[][] arr2_npc2 = this.npc;
        arr2_npc2[2] = this.createNpc(Datas, this.npc[2]);
        this.item = this.createItem(Datas, this.item);
        this.door = this.createItem(Datas, this.door);
        this.npcList = null;
        this.npcList = new byte[this.npc[0].length + 1 + this.item.length];
        this.initNpcAni();
    }

    private void dialog(String npcName) {
        int WIDTH = Constants_H.WIDTH__;
        int HEIGHT = Constants_H.HEIGHT__;
        Ui.i().drawKuang(4, HEIGHT - 65, WIDTH - 4, 65);
        if(npcName != null) {
            this.drawNpcFace((this.faceDir ? WIDTH - 50 : 50), (this.faceDir ? HEIGHT - 65 : HEIGHT - 90), 33);
            Ui.i().drawKuang(0, HEIGHT - 94, Ms.i().getStringWidth(npcName) + 16, 33);
            Ui.i().drawString(npcName, 8, HEIGHT - 92, 0, 9, 1);
            Log.e("sk", "dialog");
        }
        for(int line_c = 0; line_c < 2 && this.dialog_no + line_c < this.dialog.length; ++line_c) {
            Ui.i().drawStringColor(this.dialog[this.dialog_no + line_c].toString(), 10, line_c * 25 + (HEIGHT - 60), -1, 1);
        }
    }

    public void doKey() {
        switch(this.map_key) {
            case -57: {
                Ms.i().keyRelease();
                if(this.gr.rmsOther[2] > 0) {
                    this.initAnoleValue();
                    return;
                }
                break;
            }
            case -51: {
                this.goMission(1, false);
                return;
            }
            case -49: {
                this.goMission(0, false);
                return;
            }
            case 0xFFFFFFD0: {
                this.goMiniMap();
                return;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                if(this.my.dir != this.map_key) {
                    this.turnAround(((int)this.map_key));
                }
                this.canMove(this.dir_select[this.map_key][0] * this.my.speed, this.dir_select[this.map_key][1] * this.my.speed);
                return;
            }
            case -53: 
            case 5: {
                if(this.gr.isTalk) {
                    this.checkSoftKey(((int)this.my.x), ((int)this.my.y), this.dir_select[this.my.dir][0] * this.my.speed, this.dir_select[this.my.dir][1] * this.my.speed);
                    return;
                }
                break;
            }
        }
    }

    private void drawAnoleSel() {
        int j;
        int c;
        GameRun gameRun0 = this.gr;
        gameRun0.cur_a = (byte)Ms.i().mathSpeedN(((int)this.gr.cur_a), 62, 8, false);
        Ui.i().drawK1(0, Constants_H.HEIGHT - this.gr.cur_a - 2, 0x77, 0x1F, 2);
        Ui.i().drawK2(0, Constants_H.HEIGHT + 29 - this.gr.cur_a, Constants_H.WIDTH, 33, 0);
        for(byte i = 0; i < 5; i = (byte)(i + 1)) {
            if(this.isAnoleType(((int)i))) {
                c = (byte)(i == this.anoleSel ? 1 : 0);
                if(i == this.anole_type) {
                    j = 69;
                }
                else {
                    int v2 = i == this.anoleSel ? i + 5 : i;
                    j = (byte)v2;
                }
            }
            else {
                c = 6;
                j = (byte)(i + 70);
            }
            Ui.i().drawK0(Constants_H.WIDTH * i / 6 + 42, Constants_H.HEIGHT + 33 - this.gr.cur_a, 20, 20, c);
            Ui.i().drawUi(j, Constants_H.WIDTH * i / 6 + 52, Constants_H.HEIGHT + 33 - this.gr.cur_a + 18, 33, 0);
            if(this.pkey.isSelect(Constants_H.WIDTH * i / 6 + 42, Constants_H.HEIGHT + 33 - this.gr.cur_a, 20, 20)) {
                if(this.anoleSel == i) {
                    this.pkey.setKeySoftkey1();
                }
                else {
                    this.anoleSel = i;
                }
            }
        }
        int j = this.anoleSel == this.anole_type ? 0 : ((byte)(this.isAnoleType(((int)this.anoleSel)) ? this.anoleSel + 1 : 6));
        Log.e("sk", "drawAnoleSel");
        Ui.i().drawString(this.gr.about_a[j].toString(), 60, Constants_H.HEIGHT - this.gr.cur_a - 2, 17, 1, 2);
        Ui.i().drawK4(this.anoleSel * Constants_H.WIDTH / 6 + 41 + this.gr.cur_b / 3, Constants_H.HEIGHT + 0x20 - this.gr.cur_a + this.gr.cur_b / 3, 22 - (this.gr.cur_b / 3 << 1), 22 - (this.gr.cur_b / 3 << 1));
        int v4 = this.gr.cur_b;
        this.gr.cur_b = (byte)(v4 + 1);
        if(v4 > 4) {
            this.gr.cur_b = 0;
        }
        Ui.i().drawYesNo_(false, true);
    }

    public void drawBlackSRC(Graphics g, int y, boolean mode) {
        int WIDTH = Constants_H.WIDTH__;
        int HEIGHT = Constants_H.HEIGHT__;
        int WIDTH_H = Constants_H.WIDTH__ / 2;
        g.setColor(0xFFFFFF);
        int d = 0;
        int v5 = this.black_0 - 5 <= 0 ? 0 : this.black_0 - 5;
        if(this.gr.about_d != null) {
            while(true) {
                if(!mode) {
                    if(d <= this.black_0 && d < this.gr.about_d.length) {
                        goto label_11;
                    }
                    break;
                }
                else if(d >= this.gr.about_d.length) {
                    break;
                }
            label_11:
                if(mode) {
                    int sw = (short)(Ms.i().getStringWidth(this.gr.about_d[d].toString()) - this.gr.getSIndexW(this.gr.about_d[d].toString()));
                    Ui.i().drawStringColor(this.gr.about_d[d].toString(), WIDTH - sw >> 1, d * 29 + y + 6, 0, 0);
                }
                else {
                    if(this.black_0 == d) {
                        g.setClip(0, (d - ((byte)v5)) * 29 + y, this.black_1 << 1, 29);
                    }
                    Ui.i().drawStringColor(this.gr.about_d[d].toString(), 25, (d - ((byte)v5)) * 29 + y, 0, 0);
                    g.setClip(0, 0, WIDTH, HEIGHT);
                }
                d = (short)(d + 1);
            }
            if(!mode) {
                g.setColor(0);
                g.fillRect(0, 0, WIDTH, 40);
                g.fillRect(0, HEIGHT - 40, WIDTH, 40);
            }
            if(this.black_0 == this.gr.about_d.length) {
                this.gr.drawZero(WIDTH_H, HEIGHT - 29, 33, 0);
                return;
            }
            if(!mode) {
                short v7 = (short)(this.black_1 + 10);
                this.black_1 = v7;
                if(v7 >= WIDTH_H) {
                    this.black_1 = 0;
                    this.black_0 = (short)(this.black_0 + 1);
                    return;
                }
            }
            if(mode) {
                this.black_0 = (byte)this.gr.about_d.length;
            }
        }
    }

    private void drawBrow() {
        for(int i = 0; i < this.npcList.length; i = (byte)(i + 1)) {
            int id = this.npcList[i];
            if(id >= -1) {
                Map.cur_npc = id == -1 ? this.my : this.npc[0][id];
                switch(Map.cur_npc.other[4]) {
                    case 1: 
                    case 2: {
                        if((Map.cur_npc.brow_type > -1 || Map.cur_npc.other[6] != 0) && (id <= -1 || this.isNpcSrc(((int)Map.cur_npc.x), ((int)Map.cur_npc.y)))) {
                            if(Map.cur_npc.other[6] != 0) {
                                Map.cur_npc.brow_type = Map.cur_npc.other[6];
                            }
                            int v2 = this.brow.aLength(((int)Map.cur_npc.brow_type));
                            if(Map.cur_npc.brow_action >= v2) {
                                if(Map.cur_npc.other[6] == 0) {
                                    Map.cur_npc.brow_type = -1;
                                    break;
                                }
                                else {
                                    Map.cur_npc.brow_action = 0;
                                }
                            }
                            Ui ui0 = Ui.i();
                            int v3 = this.brow.action(((int)Map.cur_npc.brow_type), ((int)Map.cur_npc.brow_action), 0);
                            ui0.drawFrameOne(this.brow, v3, this.map_x + Map.cur_npc.x + 14, this.map_y + Map.cur_npc.y - 25, 0);
                            byte b = (byte)(Map.cur_npc.brow_time + 1);
                            Map.cur_npc.brow_time = b;
                            if(b > this.brow.action(((int)Map.cur_npc.brow_type), ((int)Map.cur_npc.brow_action), 1)) {
                                Map.cur_npc.brow_action = (byte)(Map.cur_npc.brow_action + 1);
                                Map.cur_npc.brow_time = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    private void drawCheck5(int id) {
        if(this.checkNpcT != -1 && this.my.state == 0) {
            this.drawHudong();
            if(this.checkNpcT >= 0 && this.npc[0][this.checkNpcT].other[6] == 0) {
                this.drawHudong();
                Ui ui0 = Ui.i();
                int v1 = this.brow.action(id, ((int)this.action_5), 0);
                ui0.drawFrameOne(this.brow, v1, this.map_x + this.npc[0][this.checkNpcT].x + 10, this.map_y + this.npc[0][this.checkNpcT].y - 26, 0);
                byte b = (byte)(this.time_5 + 1);
                this.time_5 = b;
                if(b > this.brow.action(id, ((int)this.action_5), 1)) {
                    byte b1 = (byte)(this.action_5 + 1);
                    this.action_5 = b1;
                    if(b1 >= this.brow.aLength(id)) {
                        this.action_5 = 0;
                    }
                    this.time_5 = 0;
                }
            }
        }
    }

    private void drawCloud() {
        if(this.imgCloud != null) {
            for(int i = 0; i < this.cloud.length; i = (byte)(i + 1)) {
                Ui.i().drawImage(this.imgCloud, this.map_x + this.cloud[i][0], this.map_y + this.cloud[i][1], 0);
            }
            for(int i = 0; i < this.cloud.length; i = (byte)(i + 1)) {
                if(this.isNpcSrc(((int)this.cloud[i][0]), ((int)this.cloud[i][1]))) {
                    short[] arr_v = this.cloud[i];
                    arr_v[0] = (short)(arr_v[0] - this.cloud[i][2]);
                }
                else {
                    this.addCloud(i);
                }
            }
        }
    }

    private void drawHudong() {
        Ui.i().drawImage(this.hudong, Constants_H.WIDTH_H, Constants_H.HEIGHT - 30, 3);
    }

    void drawMap(Graphics g) {
        int tempLeftCol = this.leftCol;
        int tempTopRow = this.topRow;
        if(this.map_x >= 0) {
            this.leftCol = 0;
            this.map_left = this.map_x;
        }
        else {
            this.leftCol = (short)(-this.map_x / 20);
            this.map_left = this.map_x % 20;
        }
        if(this.map_y >= 0) {
            this.topRow = 0;
            this.map_top = this.map_y;
        }
        else {
            this.topRow = (short)(-this.map_y / 20);
            this.map_top = this.map_y % 20;
        }
        int left = this.leftCol * 20;
        int top = this.topRow * 20;
        if(this.firstDrawMap == 0) {
            this.firstDrawMap = 1;
            this.bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g, 0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
        }
        else if(this.leftCol != tempLeftCol || this.topRow != tempTopRow) {
            g.setClip(0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT);
            g.copyArea(0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, (tempLeftCol - this.leftCol) * 20, (tempTopRow - this.topRow) * 20, 20);
            if(this.leftCol < tempLeftCol) {
                this.bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g, 0, 0, (tempLeftCol - this.leftCol) * 20, Constants_H.OFF_HEIGHT, true);
            }
            else if(this.leftCol > tempLeftCol) {
                this.bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g, Constants_H.OFF_WIDTH + (tempLeftCol - this.leftCol) * 20, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
            }
            if(this.topRow < tempTopRow) {
                this.bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g, 0, 0, Constants_H.OFF_WIDTH, (tempTopRow - this.topRow) * 20, true);
            }
            else if(this.topRow > tempTopRow) {
                this.bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g, 0, Constants_H.OFF_HEIGHT + (tempTopRow - this.topRow) * 20, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
            }
        }
        Map.g.drawImage(GameRun.scrT, this.map_left, this.map_top, 20);
    }

    private void drawMapRect(byte ww, byte hh, int tmap, boolean select) {
        int width = ww * 6;
        int height = hh * 6;
        if(this.miniMapMode) {
            width = this.mapdataMap[tmap][6] * ww;
            height = this.mapdataMap[tmap][7] * hh;
        }
        if(select) {
            Ui.i().drawRectZ(0xBC7AFC, this.mapdataMap[tmap][0] * ww + this.mapoffx, this.mapdataMap[tmap][1] * hh + this.mapoffy, width, height, 5);
            return;
        }
        if(tmap == this.myMiniMap) {
            Ui.i().drawK1(this.mapoffx + this.mapdataMap[tmap][0] * ww, this.mapoffy + this.mapdataMap[tmap][1] * hh, width, height, 4);
        }
        else {
            Ui.i().drawK0(this.mapoffx + this.mapdataMap[tmap][0] * ww, this.mapoffy + this.mapdataMap[tmap][1] * hh, width, height, 2);
        }
        String s = this.gr.getNameCity(tmap);
        this.gr.showStringM(s, this.mapdataMap[tmap][0] * ww + this.mapoffx + (width >> 1), this.mapdataMap[tmap][1] * hh + this.mapoffy + (height >> 1) - 25, 4, (tmap == this.myMiniMap ? 0 : 3));
        if(tmap == this.myMiniMap) {
            Ui.i().drawUi(67, this.mapdataMap[tmap][0] * ww + this.mapoffx + (width >> 1), this.mapdataMap[tmap][1] * hh + this.mapoffy + (height >> 1), 3, 0);
        }
    }

    private void drawMapRect(Graphics g) {
        g.setColor(0);
        for(int i = 0; i < this.gr.mapRect.length; i = (byte)(i + 1)) {
            if(!Ms.i().isRect(((int)this.my.x), ((int)this.my.y), 19, 19, this.gr.mapRect[i][0] * 20, this.gr.mapRect[i][1] * 20, (this.gr.mapRect[i][2] - this.gr.mapRect[i][0] + 1) * 20, (this.gr.mapRect[i][3] - this.gr.mapRect[i][1] + 1) * 20)) {
                for(int j = 4; j < this.gr.mapRect[i].length; j = (byte)(j + 4)) {
                    g.fillRect(this.map_x + this.gr.mapRect[i][j] * 20, this.map_y + this.gr.mapRect[i][j + 1] * 20, (this.gr.mapRect[i][j + 2] - this.gr.mapRect[i][j] + 1) * 20, (this.gr.mapRect[i][j + 3] - this.gr.mapRect[i][j + 1] + 1) * 20);
                }
            }
        }
    }

    private void drawMiniMap() {
        GameRun.mc.keyxx = MainCanvas.mainxx;
        GameRun.mc.keyyy = MainCanvas.mainyy;
        Ui.i().fillRectB();
        Ui.i().drawK2(1, 2, 638, 358, 0);
        Ui.i().drawK1(6, 33, 628, 0x102, 1);
        Ui.i().drawK1(6, 296, 628, 58, 2);
        Ui.i().drawYesNo(false, true);
        Ui.i().drawString("游戏地图", 320, 4, 17, 1, 2);
        if(this.showArea == -1) {
            Ui.i().drawString("该区域没有地图！", 320, 298, 17, 3, 0);
            return;
        }
        this.gr.showStringM("人物当前位置：" + this.gr.getNameCity(((int)this.myMiniMap)), 320, 298, 10, 3);
        Map.g.setClip(6, 33, 628, 0x102);
        int v1 = 320 - this.mapdataMap[this.selectMap][0] * 18;
        int v2 = this.miniMapMode ? this.mapdataMap[this.selectMap][6] * 18 / 2 : 25;
        this.mapoffx = Ms.i().mathSpeedN(((int)this.mapoffx), v1 - v2, 10, false);
        int v3 = this.littleMapClipY / 2 - this.mapdataMap[this.selectMap][1] * 12;
        int v4 = this.miniMapMode ? this.mapdataMap[this.selectMap][7] * 12 / 2 : 15;
        this.mapoffy = Ms.i().mathSpeedN(((int)this.mapoffy), v3 - v4, 10, false);
        for(int j = 0; j < this.mapdataArea[this.showArea].length; j = (byte)(j + 1)) {
            byte tmap = this.mapdataArea[this.showArea][j];
            if(tmap >= 0 && this.mapdataMap[tmap].length > 0) {
                if(this.pkey.isSelect(this.mapdataMap[tmap][0] * 18 + this.mapoffx, this.mapdataMap[tmap][1] * 12 + this.mapoffy, 108, 72)) {
                    this.selectMap = tmap;
                }
                if(this.miniMapMode || tmap != this.myMiniMap) {
                    this.drawMapRect(18, 12, ((int)tmap), false);
                }
            }
        }
        if(!this.miniMapMode) {
            this.drawMapRect(18, 12, ((int)this.myMiniMap), false);
        }
        this.drawMapRect(18, 12, ((int)this.selectMap), true);
        Map.g.setClip(0, 0, 640, 360);
    }

    private void drawMission() {
        Ui.i().fillRectB();
        Ui.i().drawK2(1, 6, 638, 354, 0);
        Ui.i().drawK1(8, 41, 614, this.gr.line_max * 29 + 10, 1);
        Ui.i().drawK1(8, this.gr.line_max * 29 + 59, 0x270, 0x7D, 2);
        this.drawMisstionList(8, 0x2F, 614, 29, this.gr.line_max, this.gr.select[0], (this.gr.cur_a == 0 ? this.bMission[14] + 1 : this.mDirect.length));
        for(int d = 0; this.gr.about_a != null && d < this.gr.about_a.length; d = (byte)(d + 1)) {
            Ui.i().drawStringColor(this.gr.about_a[d].toString(), 25, this.gr.line_max * 29 + 61 + d * 25, 3, 0);
        }
        byte b = this.pkey.selectMenuX(2, 0, 0, 320, 40);
        if(b != -1) {
            this.gr.cur_a = b;
            this.goMission(((int)this.gr.cur_a), this.bPause);
        }
        Ui.i().drawK1((this.gr.cur_a == 0 ? 0xC3 : 345), 9, 100, 29, 4);
        Ui.i().drawString("主线任务", 0xF5, 9, 17, (this.gr.cur_a == 0 ? 0 : 1), 0);
        Ui.i().drawString("分支任务", 395, 9, 17, (this.gr.cur_a == 1 ? 0 : 1), 0);
        Ui.i();
        Ui.i().drawString((this.gr.cur_a == 0 ? "主线完成度：" : "分支完成度：") + Ms.i().getPrecision(this.bMission[(this.gr.cur_a == 0 ? 14 : 15)] * 1000 / (this.gr.cur_a == 0 ? this.sMission.length - 1 : this.sMission.length)) + "%", 320, 359, 33, -1, 1);
        Ui.i().drawYesNo(false, true);
    }

    private void drawMisstionList(int x, int y, int w, int sh, int show_num, byte[] sel, int length) {
        int v9;
        int v7;
        byte i = sel[1];
        Ui.i().drawListKY(show_num, x, y, w, 6, sh, -1, sel[0] - sel[1], 4, 2);
        while(i < sel[1] + show_num) {
            if(i < length) {
                String s = this.gr.cur_a == 0 ? i + 1 + "、" + this.sMission[i][0].toString() : i + 1 + "、" + this.sMission[this.mDirect[i]][0].toString();
                Log.e("sk", "drawMisstionList");
                Ui ui0 = Ui.i();
                int v6 = (i - sel[1]) * (sh - 1) + y;
                if(i < this.bMission[14]) {
                    v7 = -1;
                }
                else {
                    v7 = sel[0] == i ? 0 : 3;
                }
                ui0.drawString(s, x + 8, v6, 0, v7, 0);
                if(this.gr.cur_a == 0 && i != length - 1) {
                    Ui ui1 = Ui.i();
                    int v8 = y + (i - sel[1]) * (sh - 1);
                    if(i < this.bMission[14]) {
                        v9 = -1;
                    }
                    else {
                        v9 = sel[0] == i ? 0 : 3;
                    }
                    ui1.drawString("完成", x + w - 8, v8, 24, v9, 0);
                }
                if(this.pkey.isSelect(0, (i - sel[1]) * (sh - 1) + y, 640, sh - 1)) {
                    sel[0] = i;
                    if(i - sel[1] == 0 && sel[1] > 0) {
                        sel[1] = (byte)(sel[1] - 1);
                    }
                    else if(i - sel[1] == show_num - 1 && sel[1] + show_num < length) {
                        sel[1] = (byte)(sel[1] + 1);
                    }
                    if(this.gr.cur_a == 0) {
                        this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), 590, 0);
                    }
                    else if(this.mDirect.length > 0) {
                        this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 590, 0);
                    }
                }
            }
            i = (byte)(i + 1);
        }
        Ui.i().sliding(x + w + 4, y, show_num * sh, ((int)sel[0]), length, true);
    }

    public void drawMyAni(Npc my, int my_id, int x, int y, int action_id) {
        if(my.now_action >= Map.npcSp[1][((byte)my_id)].aLength(action_id)) {
            my.now_action = 0;
        }
        if(this.anole_type != 2 && this.anole_type != 4) {
            Ui.i().drawImage(this.imgShadow, x, y, 33);
        }
        Ui.i().drawFrameOne(Map.npcSp[1][((byte)my_id)], Map.npcSp[1][((byte)my_id)].action(action_id, ((int)my.now_action), 0), x, y, (my.dir == 4 ? 1 : 0));
        byte b = (byte)(my.now_time + 1);
        my.now_time = b;
        if(b > Map.npcSp[1][((byte)my_id)].action(action_id, ((int)my.now_action), 1)) {
            my.now_action = (byte)(my.now_action + 1);
            my.now_time = 0;
        }
    }

    private void drawMySave() {
        this.gr.showString("是否存盘?", 285, 0);
        Ui.i().drawYesNo(true, true);
    }

    private void drawNMAni(Npc[] npc) {
        if(npc != null) {
            for(int i = 0; i < this.npcList.length; i = (byte)(i + 1)) {
                int id = this.npcList[i];
                if(id == -1) {
                    switch(this.my.other[4]) {
                        case 1: 
                        case 2: {
                            this.drawMyAni(this.my, 0, this.map_x + this.my.x + 10, this.map_y + this.my.y + 19, ((int)this.my.other[7]));
                        }
                    }
                }
                else if(id < -1) {
                    Ms.i();
                    int id = (byte)(Ms.abs(id) - 2);
                    if(this.isNpcSrc(this.item[id][0] * 20, this.item[id][1] * 20)) {
                        Ui.i().drawUi((this.item[id][2] == 2 ? 55 : 54), this.map_x + this.item[id][0] * 20 + 10, this.map_y + this.item[id][1] * 20 + 20, 33, 0);
                    }
                }
                else {
                    switch(npc[id].other[4]) {
                        case 1: 
                        case 2: {
                            if(this.isNpcSrc(((int)npc[id].x), ((int)npc[id].y))) {
                                if(npc[id].other[8] != 3 && !this.npcNameData[id].equals("路人")) {
                                    Map.g.drawImage(this.imgShadow, this.map_x + npc[id].x + 10, this.map_y + npc[id].y + 20, 33);
                                }
                                this.drawNpcAniOne(npc, id);
                            }
                        }
                    }
                    this.runNpcAniOne(npc, id);
                }
            }
        }
    }

    private void drawNpcAni(Npc[] npc) {
        if(npc != null) {
            for(int i = 0; i < npc.length; i = (byte)(i + 1)) {
                switch(npc[i].other[4]) {
                    case 1: 
                    case 2: {
                        if(this.isNpcSrc(((int)npc[i].x), ((int)npc[i].y))) {
                            this.drawNpcAniOne(npc, i);
                        }
                    }
                }
                this.runNpcAniOne(npc, i);
            }
        }
    }

    private void drawNpcAniOne(Npc[] npc, int i) {
        int type = (byte)(npc[i].other[3] - 1);
        int id = npc[i].other[2];
        int action_id = npc[i].other[7];
        int now_action = npc[i].now_action;
        if(action_id < 0) {
            npc[i].dir = 4;
            action_id = (byte)(-action_id);
        }
        if(npc[i].now_action >= Map.npcSp[type][id].aLength(action_id)) {
            now_action = 0;
            npc[i].now_action = 0;
            if(npc[i].other[8] == -4) {
                npc[i].other[8] = 0;
                npc[i].other[4] = 0;
                return;
            }
            if(!npc[i].bdir && this.setlastA(npc, i)) {
                this.drawNpcAniOne(npc, i);
                return;
            }
        }
        Ui.i().drawFrameOne(Map.npcSp[type][id], Map.npcSp[type][id].action(action_id, now_action, 0), this.map_x + npc[i].x + 10, this.map_y + npc[i].y + 19, (npc[i].dir == 4 ? 1 : 0));
    }

    private void drawNpcFace(int x, int y, int dir) {
        if(this.imgFace != null) {
            Ui.i().drawImage(this.imgFace, this.face_c + x, y, dir);
        }
        this.face_c = Ms.i().mathSpeedN(((int)this.face_c), 0, 20, false);
    }

    private void drawSrcEffect() {
        boolean z = false;
        int WIDTH = Constants_H.WIDTH__;
        int HEIGHT = Constants_H.HEIGHT__;
        if(this.srcFlash_c > 0) {
            int v2 = this.srcFlash_c;
            this.srcFlash_c = (byte)(v2 - 1);
            if(v2 % 2 == 0) {
                Ui.i().fillRect(0xFFFFFF, 0, 0, WIDTH, HEIGHT);
            }
        }
        if(this.bSrc) {
            Map.g.setColor(0);
            Map.g.fillRect(0, this.black_width - Constants_H.SRC_BATTLE_H__ - this.bSrc_c, WIDTH, Constants_H.SRC_BATTLE_H__);
            Map.g.fillRect(0, HEIGHT - this.black_width + this.bSrc_c, WIDTH, Constants_H.SRC_BATTLE_H__);
        }
        if(this.my.state == 22) {
            Graphics graphics0 = Map.g;
            int v3 = this.eventGoing == 2 ? HEIGHT - this.gr.about_d.length * 29 >> 1 : 45;
            if(this.eventGoing == 2) {
                z = true;
            }
            this.drawBlackSRC(graphics0, v3, z);
        }
    }

    private void drawStep(Graphics g, int x, int y, int h) {
        if(this.bStep > 0) {
            g.setColor(0x3C3B3B);
            g.drawRect(x + 1, y, h - 2, h);
            g.drawRect(x, y + 1, h, h - 2);
            g.setColor(0xCCCCCC);
            g.drawRect(x + 2, y + 1, h - 4, h - 2);
            g.drawRect(x + 1, y + 2, h - 2, h - 4);
            Ui.i().fillRect(0xFFFFFF, x + 2, y + 2, h - 3, h - 3);
            Ui.i().drawUi(67, (h >> 1) + x, (h >> 1) + y, 3, 0);
            if(this.bStep % 12 < 6) {
                Ui.i().drawLine(0xEE0000, x + h - 1, y, x, y + h - 1);
                Ui.i().drawLine(0, x + h, y, x, y + h);
                Ui.i().drawLine(0xEE0000, x + h, y + 1, x + 1, y + h);
            }
            byte b = (byte)(this.bStep - 1);
            this.bStep = b;
            if(b < 2) {
                this.bStep = 100;
            }
        }
    }

    public void eventCheck() {
        boolean bt;
        for(int i = 0; this.event != null && i < this.event.length; ++i) {
            if(this.event[i] != null && this.event_now[i] < this.event[i].length) {
                while(true) {
                    this.event_state = 0;
                    if(this.event_now[i] >= this.event[i].length) {
                        int v1 = this.mapNo * 2 + 1;
                        this.mapInfo[v1] = (short)(this.mapInfo[v1] | 1 << i);
                        break;
                    }
                alab1:
                    switch(this.event[i][this.event_now[i]]) {
                        case 1: {
                            int event_temp = this.event[i][this.event_now[i] + 2] - 1;
                            if(event_temp != -1) {
                                this.now_eV1 = this.getNpcLayer(event_temp);
                                this.now_eV2 = this.getNpcId(event_temp);
                                this.ifEvent(i, 4, 16, ((int)this.event[i][this.event_now[i] + 3]), this.my.state == 2 && this.get_meet == this.now_eV2);
                            }
                            break;
                        }
                        case 2: {
                            this.now_eV1 = this.event[i][this.event_now[i] + 2];
                            this.now_eV2 = this.event[i][this.event_now[i] + 3];
                            boolean z = this.isMapEvent(((int)this.now_eV1), ((int)this.now_eV2));
                            this.ifEvent(i, 5, 0x1010, ((int)this.event[i][this.event_now[i] + 4]), z);
                            break;
                        }
                        case 3: {
                            this.ifEvent(i, 4, 16, ((int)this.event[i][this.event_now[i] + 3]), this.gr.money >= this.event[i][this.event_now[i] + 2] * 100);
                            break;
                        }
                        case 4: {
                            this.ifEvent(i, 4, 16, ((int)this.event[i][this.event_now[i] + 3]), this.gr.monInfoList[103] >= this.event[i][this.event_now[i] + 2]);
                            break;
                        }
                        case 5: {
                            int event_temp = this.gr.findItem(-2, ((int)this.event[i][this.event_now[i] + 2]), true);
                            if(this.event[i][this.event_now[i] + 3] != 0) {
                                bt = event_temp >= this.event[i][this.event_now[i] + 3];
                            }
                            else if(event_temp == 0) {
                                bt = true;
                            }
                            else {
                                bt = false;
                            }
                            this.ifEvent(i, 5, 16, ((int)this.event[i][this.event_now[i] + 4]), bt);
                            break;
                        }
                        case 6: {
                            Ms ms0 = Ms.i();
                            this.ifEvent(i, 7, 16, ((int)this.event[i][this.event_now[i] + 6]), ms0.isRect(((int)this.my.x), ((int)this.my.y), 19, 19, this.event[i][this.event_now[i] + 2] * 20, this.event[i][this.event_now[i] + 3] * 20, (this.event[i][this.event_now[i] + 4] - this.event[i][this.event_now[i] + 2] + 1) * 20, (this.event[i][this.event_now[i] + 5] - this.event[i][this.event_now[i] + 3] + 1) * 20));
                            break;
                        }
                        case 8: {
                            boolean bt = this.gr.findMonster(((int)this.event[i][this.event_now[i] + 2]), ((int)this.event[i][this.event_now[i] + 3])) != -1;
                            this.ifEvent(i, 5, 16, ((int)this.event[i][this.event_now[i] + 4]), bt);
                            break;
                        }
                        case 11: {
                            int event_temp = this.event[i][this.event_now[i] + 2] - 1;
                            this.now_eV1 = this.getNpcLayer(event_temp);
                            this.now_eV2 = this.getNpcId(event_temp);
                            if(this.npc[this.now_eV1][this.now_eV2].other[8] == this.event[i][this.event_now[i] + 3]) {
                                this.event_now[i] = (short)(this.event_now[i] + 4);
                                this.nextEvent(16);
                            }
                            else {
                                this.setEventNow(i, false);
                            }
                            break;
                        }
                        case 12: {
                            this.runEvent_select(i);
                            break;
                        }
                        case 13: {
                            if(this.eventGoing == 0) {
                                this.eventGoing = 1;
                                if(this.event[i][this.event_now[i] + 3] == 0) {
                                    this.bMission[14] = this.event[i][this.event_now[i] + 2];
                                    if(this.bMission[14] != -1) {
                                        this.gr.say("#4主线任务#0已更新，点击#7工具包内的主线按钮#0可查看任务表。", -1);
                                    }
                                }
                                else {
                                    this.setMission(this.event[i][this.event_now[i] + 2], this.event[i][this.event_now[i] + 3] == 2);
                                    if(this.event[i][this.event_now[i] + 3] == 2) {
                                        this.gr.say("#4分支任务#0已更新，点击#7工具包内的支线按钮#0可查看任务表。", -1);
                                    }
                                }
                            }
                            else if(this.gr.say_c == 0) {
                                this.event_now[i] = (short)(this.event_now[i] + 4);
                                this.nextEvent(0x110);
                            }
                            break;
                        }
                        case 15: {
                            this.setEventNow(i, this.event[i][this.event_now[i] + 2] == 0);
                            break;
                        }
                        case 16: {
                            this.runEvent_goShop(i);
                            break;
                        }
                        case 17: {
                            this.now_eV1 = this.event[i][this.event_now[i] + 2];
                            this.now_eV2 = this.event[i][this.event_now[i] + 3];
                            this.event_now[i] = (short)(this.event_now[i] + 4);
                            this.setOverEvent(((int)this.now_eV1), ((int)this.now_eV2));
                            this.nextEvent(0x1010);
                            break;
                        }
                        case 18: {
                            this.runEvent_item_add_del(i);
                            break;
                        }
                        case 19: {
                            Ms.i();
                            Ms.skip = 0;
                            byte[] arr_b = Ms.i().getStream("data/battle/boss.d", -1);
                            byte[][] arr2_b = Ms.i().create2Array(arr_b);
                            int event_temp = this.event[i][this.event_now[i] + 1] >> 1;
                            GameRun gameRun0 = this.gr;
                            gameRun0.enemyList = new byte[event_temp][5];
                            this.now_eV2 = 0;
                            while(this.now_eV2 < event_temp) {
                                this.now_eV1 = this.event[i][this.event_now[i] + 2 + this.now_eV2 * 2];
                                this.gr.enemyList[this.now_eV2][0] = arr2_b[this.now_eV1][0];
                                this.gr.enemyList[this.now_eV2][1] = this.event[i][this.event_now[i] + 3 + this.now_eV2 * 2];
                                this.gr.enemyList[this.now_eV2][2] = arr2_b[this.now_eV1][1];
                                this.gr.enemyList[this.now_eV2][3] = arr2_b[this.now_eV1][2];
                                this.gr.enemyList[this.now_eV2][4] = arr2_b[this.now_eV1][3];
                                this.now_eV2 = (byte)(this.now_eV2 + 1);
                            }
                            Sound.i().setMusicId(6);
                            Sound.i().setMusic(false);
                            this.gr.battleType(3);
                            this.gr.goBattle();
                            this.event_now[i] = (short)(this.event_now[i] + (this.event[i][this.event_now[i] + 1] + 2));
                            break;
                        }
                        case 21: {
                            if(this.eventGoing == 0) {
                                this.eventGoing = 1;
                                int event_temp = this.event[i][this.event_now[i] + 2] * 100;
                                if(event_temp < 0) {
                                    int v7 = this.gr.money;
                                    Ms.i();
                                    if(v7 < Ms.abs(event_temp)) {
                                        this.gr.say("金钱不足！", 0);
                                        this.eventGoing = 2;
                                    }
                                }
                                if(this.eventGoing == 1) {
                                    this.gr.money += event_temp;
                                    GameRun gameRun1 = this.gr;
                                    Ms.i();
                                    gameRun1.say(String.valueOf((event_temp >= 0 ? "获得：" : "失去：")) + Ms.abs(event_temp) + "金", 0);
                                }
                            }
                            else if(this.gr.say_c == 0) {
                                if(this.eventGoing == 2) {
                                    this.setEventNow(i, true);
                                }
                                else {
                                    this.event_now[i] = (short)(this.event_now[i] + 3);
                                    this.nextEvent(0x110);
                                }
                            }
                            break;
                        }
                        case 22: {
                            this.exitBoss(((int)this.event[i][this.event_now[i] + 2]), ((int)this.event[i][this.event_now[i] + 3]), ((int)this.event[i][this.event_now[i] + 4]), ((int)this.event[i][this.event_now[i] + 5]));
                            this.event_now[i] = (short)(this.event_now[i] + 6);
                            this.nextEvent(16);
                            break;
                        }
                        case 23: {
                            this.now_eV1 = this.event[i][this.event_now[i] + 2];
                            this.now_eV2 = this.event[i][this.event_now[i] + 3];
                            this.event_now[i] = (short)(this.event_now[i] + 4);
                            this.setRestEvent(((int)this.now_eV1), ((int)this.now_eV2));
                            this.nextEvent(0x1010);
                            break;
                        }
                        case 24: {
                            this.initBoat(((int)this.event[i][this.event_now[i] + 2]));
                            this.event_now[i] = (short)(this.event_now[i] + 3);
                            this.nextEvent(16);
                            break;
                        }
                        case 25: {
                            this.gr.overMode = (byte)(this.event[i][this.event_now[i] + 2] + 1);
                            this.event_now[i] = (short)(this.event_now[i] + 3);
                            break;
                        }
                        case 26: {
                            this.runEvent_getMon(i);
                            break;
                        }
                        case 27: {
                            if(this.eventGoing == 0) {
                                this.now_eV2 = this.gr.findMonsterMinLv(((int)this.event[i][this.event_now[i] + 2]), ((int)this.event[i][this.event_now[i] + 3]));
                                if(this.now_eV2 == -1) {
                                    this.setEventNow(i, false);
                                }
                                else {
                                    this.now_eV1 = this.gr.delMonster(((int)this.now_eV2));
                                    this.eventGoing = 1;
                                }
                            }
                            else if(this.gr.say_c == 0) {
                                if(this.now_eV1 == -1) {
                                    this.setEventNow(i, false);
                                }
                                else {
                                    this.event_now[i] = (short)(this.event_now[i] + (this.event[i][this.event_now[i] + 1] + 2));
                                    this.nextEvent(0x1110);
                                }
                            }
                            break;
                        }
                        case 28: {
                            this.runEvent_dialog(i);
                            break;
                        }
                        case 29: {
                            int event_temp = this.event[i][this.event_now[i] + 2] - 1;
                            Map.cur_npc = event_temp == -1 ? this.my : this.npc[this.getNpcLayer(event_temp)][this.getNpcId(event_temp)];
                            Map.cur_npc.setLastAction(false, ((int)this.event[i][this.event_now[i] + 4]));
                            Map.cur_npc.other[7] = this.event[i][this.event_now[i] + 3];
                            Map.cur_npc.now_action = 0;
                            this.event_now[i] = (short)(this.event_now[i] + 5);
                            this.nextEvent(0x1000);
                            break;
                        }
                        case 30: {
                            this.my.state = 10;
                            int event_temp = this.event[i][this.event_now[i] + 2] - 1;
                            Map.cur_npc = event_temp == -1 ? this.my : this.npc[this.getNpcLayer(event_temp)][this.getNpcId(event_temp)];
                            Map.cur_npc.setIXY(((int)this.event[i][this.event_now[i] + 3]), ((int)this.event[i][this.event_now[i] + 4]));
                            Map.cur_npc.speed = this.event[i][this.event_now[i] + 5];
                            Map.cur_npc.b_check = this.event[i][this.event_now[i] + 6] == 0;
                            Map.cur_npc.setLastAction(false, 0x7F);
                            this.event_now[i] = (short)(this.event_now[i] + 7);
                            this.nextEvent(16);
                            break;
                        }
                        case 0x1F: {
                            int event_temp = this.event[i][this.event_now[i] + 2] - 1;
                            if(event_temp == -1) {
                                this.now_eV1 = this.event[i][this.event_now[i] + 3];
                                this.my.dir = this.now_eV1;
                                this.my.setActionNo(false);
                            }
                            else {
                                this.now_eV1 = this.getNpcLayer(event_temp);
                                if(this.now_eV1 == 0) {
                                    this.now_eV2 = this.getNpcId(event_temp);
                                    this.npc[this.now_eV1][this.now_eV2].dir = this.event[i][this.event_now[i] + 3];
                                    this.npc[this.now_eV1][this.now_eV2].setActionNo(false);
                                }
                            }
                            this.event_now[i] = (short)(this.event_now[i] + 4);
                            this.nextEvent(0x1010);
                            break;
                        }
                        case 0x20: {
                            this.runEvent_miniGame_myLevel(i);
                            break;
                        }
                        case 33: {
                            this.anole_type = (byte)(this.event[i][this.event_now[i] + 2] - 1);
                            this.setAnole();
                            this.event_now[i] = (short)(this.event_now[i] + 3);
                            this.nextEvent(16);
                            break;
                        }
                        case 35: {
                            int event_temp = this.event[i][this.event_now[i] + 2] - 1;
                            if(event_temp == -1) {
                                this.my.other[4] = this.event[i][this.event_now[i] + 3];
                                switch(this.event[i][this.event_now[i] + 3]) {
                                    case 0: 
                                    case 2: {
                                        this.my.state = 0;
                                        break;
                                    }
                                    case 1: 
                                    case 3: {
                                        this.my.state = 10;
                                    }
                                }
                            }
                            else {
                                this.now_eV1 = this.getNpcLayer(event_temp);
                                this.now_eV2 = this.getNpcId(event_temp);
                                this.npc[this.now_eV1][this.now_eV2].other[4] = this.event[i][this.event_now[i] + 3];
                            }
                            this.event_now[i] = (short)(this.event_now[i] + 4);
                            this.nextEvent(0x1010);
                            break;
                        }
                        case 36: {
                            int event_temp = this.event[i][this.event_now[i] + 2] - 1;
                            this.now_eV1 = this.getNpcLayer(event_temp);
                            this.now_eV2 = this.getNpcId(event_temp);
                            this.npc[this.now_eV1][this.now_eV2].other[5] = (byte)(this.event[i][this.event_now[i] + 3] + 1);
                            this.event_now[i] = (short)(this.event_now[i] + 4);
                            this.nextEvent(0x1010);
                            break;
                        }
                        case 37: {
                            this.my.state = 10;
                            int event_temp = this.event[i][this.event_now[i] + 2] - 1;
                            Map.cur_npc = event_temp == -1 ? this.my : this.npc[this.getNpcLayer(event_temp)][this.getNpcId(event_temp)];
                            Map.cur_npc.setLastAction(true, ((int)this.event[i][this.event_now[i] + 6]));
                            Map.cur_npc.setIXY(((int)this.event[i][this.event_now[i] + 3]), ((int)this.event[i][this.event_now[i] + 4]));
                            Map.cur_npc.other[7] = this.event[i][this.event_now[i] + 5];
                            if(this.event[i][this.event_now[i] + 5] < 0) {
                                Map.cur_npc.dir = 4;
                            }
                            Map.cur_npc.speed = this.event[i][this.event_now[i] + 7];
                            this.event_now[i] = (short)(this.event_now[i] + 8);
                            this.nextEvent(16);
                            break;
                        }
                        case 38: {
                            this.runEvent_brow(i);
                            break;
                        }
                        case 39: {
                            this.now_eV1 = this.event[i][this.event_now[i] + 2];
                            this.now_eV2 = this.event[i][this.event_now[i] + 3];
                            if((this.gr.rmsOther[this.now_eV1 * 2 + 4] & 1 << this.now_eV2) != 0) {
                                this.event_now[i] = (short)(this.event_now[i] + 4);
                                this.nextEvent(0x1011);
                            }
                            break;
                        }
                        case 40: {
                            int event_temp = this.event[i][this.event_now[i] + 2] - 1;
                            if(event_temp == -1) {
                                byte[] arr_b1 = this.my.other;
                                Ms.i();
                                arr_b1[7] = (byte)Ms.abs(this.event[i][this.event_now[i] + 3]);
                                if(this.event[i][this.event_now[i] + 3] < 0) {
                                    this.my.dir = 4;
                                }
                            }
                            else {
                                Map.cur_npc = this.npc[this.getNpcLayer(event_temp)][this.getNpcId(event_temp)];
                                Map.cur_npc.other[7] = this.event[i][this.event_now[i] + 3];
                                Map.cur_npc.setNpcNum(Map.npcSp[Map.cur_npc.other[3] - 1][Map.cur_npc.other[2]].aLength());
                            }
                            this.event_now[i] = (short)(this.event_now[i] + 4);
                            this.nextEvent(16);
                            break;
                        }
                        case 41: {
                            int event_temp = this.event[i][this.event_now[i] + 2] - 1;
                            if(event_temp == -1) {
                                this.my.setXY(((int)this.event[i][this.event_now[i] + 3]), ((int)this.event[i][this.event_now[i] + 4]), 0, 0);
                                this.my.frame_c = -1;
                                if(this.srcNpcNo == -1) {
                                    this.map_x = this.map_set(((int)this.event[i][this.event_now[i] + 3]), ((int)this.cols), ((int)Constants_H.XCELLS), ((int)Constants_H.HALF_XCELLS), Constants_H.WIDTH, 20);
                                    this.map_y = this.map_set(((int)this.event[i][this.event_now[i] + 4]), ((int)this.rows), ((int)Constants_H.YCELLS), ((int)Constants_H.HALF_YCELLS), Constants_H.HEIGHT, 20);
                                }
                            }
                            else {
                                this.now_eV1 = this.getNpcLayer(event_temp);
                                this.now_eV2 = this.getNpcId(event_temp);
                                this.npc[this.now_eV1][this.now_eV2].other[0] = this.event[i][this.event_now[i] + 3];
                                this.npc[this.now_eV1][this.now_eV2].other[1] = this.event[i][this.event_now[i] + 4];
                                this.npc[this.now_eV1][this.now_eV2].setXY_npc();
                            }
                            this.event_now[i] = (short)(this.event_now[i] + 5);
                            this.nextEvent(0x1010);
                            break;
                        }
                        case 42: {
                            this.now_eV1 = this.event[i][this.event_now[i] + 2];
                            this.now_eV2 = this.event[i][this.event_now[i] + 3];
                            Mg.i().go(this.gr, ((int)this.now_eV1), -1, ((int)this.now_eV2));
                            this.event_now[i] = (short)(this.event_now[i] + 4);
                            this.nextEvent(0x1011);
                            break;
                        }
                        case 43: {
                            int event_temp = this.event[i][this.event_now[i] + 2] - 1;
                            this.now_eV1 = this.getNpcLayer(event_temp);
                            this.now_eV2 = this.getNpcId(event_temp);
                            this.npc[this.now_eV1][this.now_eV2].other[8] = this.event[i][this.event_now[i] + 3];
                            this.event_now[i] = (short)(this.event_now[i] + 4);
                            this.nextEvent(16);
                            break;
                        }
                        case 44: {
                            int event_temp = this.event[i][this.event_now[i] + 2];
                            if(event_temp == 0) {
                                this.ifEvent(i, 3, 16, 2, this.gr.gameCheckRegIsOK());
                            }
                            else {
                                switch(event_temp) {
                                    case 1: {
                                        if(!this.gr.gameCheckRegIsOK()) {
                                            this.event_now[i] = (short)(this.event_now[i] + 3);
                                            this.nextEvent(0);
                                            this.checkRegWhere0(i);
                                        }
                                        break;
                                    }
                                    case 2: {
                                        this.ifEvent(i, 3, 16, 2, this.gr.gameCheckRegIsOK());
                                    }
                                }
                            }
                            break;
                        }
                        case 45: {
                            this.runEvent_srcMove(i);
                            break;
                        }
                        case 46: {
                            Sound.i().setMusicId(((int)this.event[i][this.event_now[i] + 2]));
                            Sound.i().setMusic(false);
                            this.event_now[i] = (short)(this.event_now[i] + 3);
                            this.nextEvent(16);
                            break;
                        }
                        case 0x2F: {
                            this.my.state = 10;
                            byte b = (byte)(this.sleep_count + 1);
                            this.sleep_count = b;
                            if(b == this.event[i][this.event_now[i] + 2]) {
                                this.sleep_count = 0;
                                this.event_now[i] = (short)(this.event_now[i] + 3);
                                this.nextEvent(17);
                            }
                            break;
                        }
                        case 0x30: {
                            this.my.state = 10;
                            this.srcFlash_c = (byte)(this.event[i][this.event_now[i] + 2] << 1);
                            this.event_now[i] = (short)(this.event_now[i] + 3);
                            this.nextEvent(16);
                            break;
                        }
                        case 49: {
                            switch(this.gr.magic_id) {
                                case -2: {
                                    this.my.state = 10;
                                    this.gr.magic_id = this.event[i][this.event_now[i] + 2];
                                    this.gr.magic_x = this.map_x + this.event[i][this.event_now[i] + 3] * 20 + 10;
                                    this.gr.magic_y = this.map_y + this.event[i][this.event_now[i] + 4] * 20 + 20;
                                    this.gr.setMagic(this.event[i][this.event_now[i] + 2] / 5);
                                    break;
                                }
                                case -1: {
                                    this.gr.magic_id = -2;
                                    this.event_now[i] = (short)(this.event_now[i] + 5);
                                    this.nextEvent(16);
                                }
                            }
                            break;
                        }
                        case 50: {
                            if(this.my.state == 24 || this.my.state == 25) {
                                this.event_now[i] = (short)(this.event_now[i] + 3);
                                this.nextEvent(0);
                                if(this.my.state == 24) {
                                    this.gr.say("保存进度完成", 1);
                                    this.gr.saveGame();
                                }
                                this.my.state = 0;
                            }
                            else if(this.my.frame_c == -1 && this.my.state != 23) {
                                this.my.state = 23;
                            }
                            break;
                        }
                        case 51: {
                            switch(this.event[i][this.event_now[i] + 2]) {
                                case 0: {
                                    if(this.eventGoing == 0) {
                                        this.gr.say(Ms.i().getDialogs(this.event[i], this.event_now[i] + 4, ((int)this.event[i][this.event_now[i] + 3])), -1);
                                        this.eventGoing = 1;
                                    }
                                    else if(this.gr.say_c == 0) {
                                        this.event_now[i] = (short)(this.event_now[i] + ((this.event[i][this.event_now[i] + 3] << 1) + 4));
                                        this.nextEvent(0x110);
                                    }
                                    break alab1;
                                }
                                case 1: 
                                case 2: {
                                    switch(this.eventGoing) {
                                        case 0: {
                                            this.my.state = 22;
                                            this.black_1 = 0;
                                            this.black_0 = 0;
                                            Ms.i();
                                            Ms.font.setSize(22);
                                            this.fontSizeControl = true;
                                            this.gr.setStringB(Ms.i().getDialogs(this.event[i], this.event_now[i] + 4, ((int)this.event[i][this.event_now[i] + 3])), Constants_H.WIDTH__ - 50, 3);
                                            Ms.i();
                                            Ms.font.setSize(26);
                                            this.fontSizeControl = false;
                                            this.eventGoing = this.event[i][this.event_now[i] + 2];
                                            break;
                                        }
                                        case 3: {
                                            this.event_now[i] = (short)(this.event_now[i] + ((this.event[i][this.event_now[i] + 3] << 1) + 4));
                                            this.nextEvent(0x110);
                                            this.gr.about_d = null;
                                            this.black_0 = -1;
                                        }
                                    }
                                    break alab1;
                                }
                                default: {
                                    break alab1;
                                }
                            }
                        }
                        case 52: {
                            this.my.state = 10;
                            this.xxx = this.event[i][this.event_now[i] + 2];
                            this.event_now[i] = (short)(this.event_now[i] + 3);
                            this.nextEvent(16);
                            break;
                        }
                        case 53: {
                            if(this.initSrcEffect(((int)this.event[i][this.event_now[i] + 2]))) {
                                this.event_now[i] = (short)(this.event_now[i] + 3);
                                this.nextEvent(16);
                            }
                        }
                    }
                    if(this.event_state != 1) {
                        break;
                    }
                }
            }
        }
    }

    private void exitBoss(int map_No, int zuobiao_x, int zuobiao_y, int mydir) {
        this.chuansong(map_No, 0);
        this.bExitBoss = true;
        this.my.setXY(zuobiao_x, zuobiao_y, 0, 0);
        this.my.dir = (byte)mydir;
    }

    public byte exitMap(byte[][] door) {
        if(door[this.get_meet][3] == -1) {
            byte go = this.mapNo;
            this.mapNo = this.lastMap;
            this.lastMap = go;
            this.lastExit = this.get_meet;
            return -1;
        }
        byte go = this.mapNo;
        this.mapNo = door[this.get_meet][4];
        this.lastMap = go;
        this.lastExit = this.get_meet;
        return door[this.get_meet][3];
    }

    private void getInMap(byte exit_no, byte[][] door) {
        this.my.dir = (byte)((door[exit_no][2] - 1) / 2 * 2 + 1 + door[exit_no][2] % 2);
        this.my.setXY(((int)door[exit_no][0]), ((int)door[exit_no][1]), 0, 0);
    }

    private void getItem() {
        if(this.item[this.get_meet][2] == 2) {
            this.gr.say("这个宝箱是空的。", 0);
            return;
        }
        int id = (byte)(this.item[this.get_meet][3] - 2);
        if(id == -2) {
            this.gr.money += this.item[this.get_meet][4] * 100;
            this.gr.say("获得金钱：" + this.item[this.get_meet][4] * 100 + "金", 0);
        }
        else if(id == -1) {
            this.gr.coin += this.item[this.get_meet][4];
            this.gr.say("获得徽章：" + ((int)this.item[this.get_meet][4]) + "徽章", 0);
        }
        else {
            this.gr.getItem(id, ((int)this.item[this.get_meet][4]));
        }
        this.item[this.get_meet][2] = 2;
    }

    private void getItemData(ByteArrayOutputStream byteArray, byte[][] data) {
        try {
            byteArray.write(data.length);
            for(int i = 0; true; ++i) {
                if(i >= data.length) {
                    return;
                }
                byteArray.write(data[i].length);
                byteArray.write(data[i]);
            }
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
    }

    public byte getMySpeed() {
        switch(this.anole_type) {
            case 0: {
                return 6;
            }
            case 1: {
                return 6;
            }
            case 2: {
                return 10;
            }
            case 3: {
                return 10;
            }
            case 4: {
                return 5;
            }
            default: {
                return 5;
            }
        }
    }

    private void getNpcData(ByteArrayOutputStream byteArray, Npc[] npc) {
        try {
            for(int i = 0; true; ++i) {
                if(i >= npc.length) {
                    return;
                }
                if(npc[i].other[9] == 1) {
                    byteArray.write(npc[i].other);
                }
            }
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
    }

    private byte[] getNpcData() {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        this.getNpcData(byteArray, this.npc[0]);
        this.getNpcData(byteArray, this.npc[1]);
        this.getNpcData(byteArray, this.npc[2]);
        this.getItemData(byteArray, this.item);
        this.getItemData(byteArray, this.door);
        return byteArray.toByteArray();
    }

    private byte getNpcId(int i) {
        return (byte)(this.npcPos[i] & 0x3F);
    }

    private byte getNpcLayer(int i) {
        return (byte)((this.npcPos[i] & 0xFF) >> 6);
    }

    private short getNpcListY(int j) {
        if(this.npcList[j] == -1) {
            return (short)(this.my.y + this.dir_select[this.my.dir][1] * this.my.speed);
        }
        if(this.npcList[j] < -1) {
            byte[][] arr2_b = this.item;
            Ms.i();
            return (short)(arr2_b[Ms.abs(this.npcList[j]) - 2][1] * 20);
        }
        return this.npc[0][this.npcList[j]].y;
    }

    public void goMiniMap() {
        int k;
        Ms.i().keyRelease();
        byte[] arr_b = Ms.i().getStream("data/map.d", -1);
        Ms.skip = 0;
        this.mapdataArea = Ms.i().create2Array(arr_b);
        this.mapdataMap = Ms.i().create2Array(arr_b);
        this.my.state = 17;
        this.showArea = -1;
        this.myMiniMap = -1;
        this.selectMap = 0;
        byte i;
        for(i = 0; true; i = (byte)(i + 1)) {
            if(i >= this.mapdataArea.length) {
                return;
            }
            k = 0;
        label_13:
            if(k < this.mapdataArea[i].length) {
                break;
            }
        }
        if(this.mapNo == this.mapdataArea[i][k]) {
            this.selectMap = this.mapNo;
            if(this.mapdataMap[this.selectMap].length > 0) {
                this.myMiniMap = this.selectMap;
                this.showArea = i;
                this.miniMapMode = this.mapdataArea[this.showArea][0] > -1;
                return;
            }
        }
        k = (byte)(k + 1);
        goto label_13;
    }

    public void goMission(int type, boolean b) {
        if(this.my.state == 0 || this.my.state == 18) {
            Ms.i().keyRelease();
            this.bPause = b;
            GameRun.run_state = -10;
            this.my.state = 18;
            this.gr.cur_a = (byte)type;
            byte[] arr_b = this.gr.select[0];
            this.gr.select[0][1] = 0;
            arr_b[0] = 0;
            Ms.i();
            Ms.skip = 0;
            byte[] arr_b1 = Ms.i().getStream("data/mission" + type + ".t", -1);
            this.sMission = Ms.i().createString2Array(arr_b1);
            this.gr.line_max = 6;
            this.gr.about_a = null;
            if(type != 1) {
                this.gr.select[0][0] = this.bMission[14];
                this.gr.select[0][1] = this.bMission[14] >= this.gr.line_max ? ((byte)(this.gr.select[0][0] - this.gr.line_max + 1)) : 0;
                this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), 590, 0);
                return;
            }
            int j = 0;
            byte[] tMis = new byte[50];
            for(byte i = 0; i < this.sMission.length; i = (byte)(i + 1)) {
                if(this.isMission(((int)i))) {
                    tMis[j] = i;
                    j = (byte)(j + 1);
                }
            }
            this.mDirect = null;
            this.mDirect = new byte[j];
            System.arraycopy(tMis, 0, this.mDirect, 0, this.mDirect.length);
            if(this.mDirect.length > 0) {
                this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 590, 0);
            }
        }
    }

    public void goNextMap() {
        this.setfmap();
        this.firstDrawMap = 0;
        this.gr.doPaint(2);
        this.saveMapBak();
        byte exit_b = this.lastExit;
        if(this.go != -2) {
            this.lastMap = this.mapNo;
            this.mapNo = this.mapNotemp;
            this.mapNotemp = 0;
            this.lastExit = this.go;
        }
        this.gr.doPaint(5);
        if(this.go == -2) {
            this.go = this.exitMap(this.door);
        }
        this.gr.setNull(false);
        this.gr.doPaint(8);
        this.createOther();
        this.gr.doPaint(10);
        if(this.go == -1) {
            this.go = exit_b;
        }
        if(!this.bExitBoss) {
            this.getInMap(this.go, this.door);
        }
        this.createEvent();
        this.gr.doPaint(15);
        this.createNpcString();
        this.createLayer();
        this.gr.doPaint(20);
        if(this.bExitBoss) {
            this.my.setActionNo(false);
        }
        else {
            switch(this.door[this.go][5]) {
                case 1: 
                case 2: {
                    this.my.frame_c = (byte)(20 / this.my.speed);
                    this.my.speed_x = (byte)(this.dir_select[this.my.dir][0] * this.my.speed);
                    this.my.speed_y = (byte)(this.dir_select[this.my.dir][1] * this.my.speed);
                    this.my.setActionNo(true);
                    break;
                }
                default: {
                    this.my.setActionNo(false);
                }
            }
        }
        this.gr.b_c = 0;
        this.setMapMusic(false);
        this.go = -2;
        this.gr.initMonPro(((int)this.mapNo), true);
        this.gr.cityName_c = 25;
        this.srcNpcNo = -1;
        Ms.i().rmsOptions(1, null, 4);
        this.initCloud();
        this.bExitBoss = false;
        this.my.state = 9;
        if(this.boatSelect == -1) {
            this.my.state = 0;
            this.my.setIXY(-1, -1);
            this.my.speed = this.getMySpeed();
        }
        this.checkNpcT = -1;
        this.pkey.stopMove();
    }

    private void ifEvent(int i, int next_id, int next_mode, int mode, boolean bt) {
        if(this.setSIfElse(mode, bt, true)) {
            this.event_now[i] = (short)(this.event_now[i] + next_id);
            this.nextEvent(next_mode);
            return;
        }
        if(this.setSIfElse(mode, bt, false)) {
            this.setEventNow(i, false);
        }
    }

    private void init() {
        this.initBrowImage();
        this.initWalkIco();
        this.initHudong();
        this.configureNpc();
        if(Map.npcSp[1][0] == null) {
            Sprite[] arr_sprite = Map.npcSp[1];
            arr_sprite[0] = new Sprite();
            this.my = new Npc(8);
            this.my.other[4] = 1;
            this.setAnole();
        }
        if(this.imgShadow == null) {
            this.imgShadow = Ms.i().createImage("data/shadow");
        }
    }

    public boolean initAnoleValue() {
        if(this.isAnole(((int)this.my.x), ((int)this.my.y), ((int)this.anole_type))) {
            this.gr.say("不能更换坐骑", 0);
            return false;
        }
        this.my.state = 20;
        this.gr.cur_a = 0;
        this.gr.cur_b = 0;
        this.gr.setStringB("下坐骑#n植物坐骑#n金属坐骑#n飞行坐骑#n野兽坐骑#n海洋坐骑#n无此坐骑", Constants_H.WIDTH, 0);
        return true;
    }

    private boolean initAuto(Npc npc, int sleep) {
        if(npc.timeMove == 0) {
            if(npc.frame_c != -1) {
                return false;
            }
            Ms.i();
            npc.b_auto = Ms.getRandom(100) < 50;
            Ms.i();
            if(Ms.getRandom(100) < 50) {
                Ms.i();
                npc.timeMove = (byte)(-(Ms.getRandom(sleep) + 20));
                npc.setActionNo(false);
                return false;
            }
        }
        else if(npc.timeMove < 0) {
            npc.timeMove = (byte)(npc.timeMove + 1);
            return false;
        }
        return true;
    }

    private void initBoat(int _select) {
        this.my.state = 9;
        this.anole_type = 5;
        this.setAnole();
        this.boatSelect = (byte)_select;
        this.gr.cur_a = 0;
        this.my.setIXY(((int)this.boatCourse[this.boatSelect][this.gr.cur_a]), ((int)this.boatCourse[this.boatSelect][this.gr.cur_a + 1]));
    }

    public void initBrowImage() {
        if(this.brow == null) {
            this.brow = Ms.i().createSprite("data/face/brow", true);
        }
    }

    private void initCloud() {
        if(this.mapNo == 24 || this.mapNo == 25 || this.mapNo == 26 || this.mapNo == 49 || this.mapNo == 50) {
            if(this.imgCloud == null) {
                this.imgCloud = Ms.i().createImage("data/cloud");
                this.cloud = null;
                this.cloud = new short[4][3];
            }
            for(int i = 0; i < this.cloud.length; i = (byte)(i + 1)) {
                this.addCloud(i);
            }
            return;
        }
        this.cloud = null;
        this.imgCloud = null;
    }

    public byte[] initData(byte[] tempdata, int n) {
        int i = 0;
        int len;
        for(len = 1; i < n; len = len + 2 + ((tempdata[len] & 0xFF) << 8 | tempdata[len + 1] & 0xFF)) {
            ++i;
        }
        byte[] data = new byte[(tempdata[len] & 0xFF) << 8 | tempdata[len + 1] & 0xFF];
        System.arraycopy(tempdata, len + 2, data, 0, data.length);
        return data;
    }

    private void initHudong() {
        this.hudong = Ms.i().createImage("data/brow/hudong");
    }

    public void initMap() {
        this.my.dir = 4;
        this.srcNpcNo = -1;
        this.gr.loadRmsSms();
        this.gr.loadRmsNidus();
        this.notMeet(0, 0);
        this.mapInfo = Ms.i().byteArrayToShortArray(Ms.i().rmsOptions(13, null, 1));
        this.mapChange = Ms.i().rmsOptions(1, null, 1);
        for(int i = 0; i < this.mapChange.length; i = (short)(i + 1)) {
            if(this.mapChange[i] == 1) {
                byte[][] arr2_b = this.mapTemp;
                arr2_b[i] = Ms.i().rmsOptions(i + 14, null, 1);
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
        this.gr.initMonPro(((int)this.mapNo), true);
        this.initMissionList();
        this.initCloud();
    }

    private void initMissionList() {
        byte[] arr_b = Ms.i().rmsOptions(7, null, 1);
        this.bMission = arr_b[0] == -1 ? null : arr_b;
        if(this.bMission == null) {
            this.bMission = new byte[20];
        }
        Ms.i();
        Ms.skip = 0;
        byte[] arr_b1 = Ms.i().getStream("data/mission0.t", -1);
        this.sMission = Ms.i().createString2Array(arr_b1);
        this.smissionLength = this.sMission.length - 1;
        this.sMission = null;
    }

    private void initMoveMy() {
        this.my.frame_c = this.my.frame_num;
        this.my.setActionNo(true);
        if(this.my.state == 0 && this.gr.monPro.length > 0) {
            this.meetGrass();
        }
    }

    public void initNpcAni() {
        int k;
        byte[][] em = {new byte[100], new byte[5], new byte[60]};
        this.gr.initNidusMap(0);
        int i = (byte)(this.npc.length - 1);
        for(int k = 0; i > -1; k = k) {
            byte j = (byte)(this.npc[i].length - 1);
            int k;
            for(k = k; j > -1; k = k) {
                em[this.npc[i][j].other[3] - 1][this.npc[i][j].other[2]] = 1;
                if(i == 0) {
                    this.npcList[j + 1] = j;
                    if(this.npc[0][j].other[8] == 1) {
                        k = (byte)(k + 1);
                        this.gr.nidusMap[k] = j;
                    }
                }
                else {
                    k = k;
                }
                j = (byte)(j - 1);
            }
            i = (byte)(i - 1);
        }
        this.gr.initNidusMap(1);
        this.npcList[0] = -1;
        for(int i = (byte)(this.item.length + this.npc[0].length); i > this.npc[0].length; i = (byte)(i - 1)) {
            this.npcList[i] = (byte)(-2 - i + this.npc[0].length + 1);
        }
        this.initNpcAni_1(100, 0, em[0]);
        this.initNpcAni_1(5, 1, em[1]);
        this.initNpcAni_1(60, 2, em[2]);
        for(int j = (byte)(this.npc[0].length - 1); j > -1; j = (byte)(j - 1)) {
            this.npc[0][j].setNpcNum(Map.npcSp[this.npc[0][j].other[3] - 1][this.npc[0][j].other[2]].aLength());
        }
    }

    public void initNpcAniOne(String sid, int id, int type) {
        Sprite[] arr_sprite = Map.npcSp[type];
        arr_sprite[id] = Ms.i().createSprite("data/npc" + type + "/" + sid, (type == 2 ? this.gr.isNpc2ImageType(Integer.parseInt(sid)) : true));
    }

    private void initNpcAni_1(int length, int type, byte[] em) {
        for(int i = length - 1; i > 0; --i) {
            if(em[i] == 0) {
                Map.npcSp[type][i] = null;
            }
            else if(Map.npcSp[type][i] == null) {
                this.initNpcAniOne(i, i, type);
            }
        }
    }

    public void initNpcFaceOne(String name) {
        if(name != null) {
            byte id = -1;
            this.faceDir = true;
            if(name.equals("塞其")) {
                this.faceDir = false;
                id = 0;
            }
            else if(name.equals("安琪儿") || name.equals("蓝发女孩")) {
                id = 1;
            }
            else if(name.equals("幽暗鬼王")) {
                id = 2;
            }
            else if(name.equals("杰奇校长")) {
                id = 3;
            }
            else if(name.equals("普罗") || name.equals("普罗校长")) {
                id = 4;
            }
            else if(name.equals("神秘东方男子")) {
                id = 5;
            }
            else if(name.equals("南宫云")) {
                id = 6;
            }
            if(id <= -1) {
                this.nullNpcFace();
            }
            else if(this.imgFace == null || this.faceLast != id) {
                this.face_c = (short)(this.faceDir ? 50 : -50);
                this.faceLast = id;
                this.imgFace = null;
                this.imgFace = Ms.i().createImage("data/face/" + ((int)id));
            }
        }
    }

    public boolean initSrcEffect(int mode) {
        int SRC_BATTLE_H = Constants_H.SRC_BATTLE_H__;
        this.my.state = 10;
        switch(mode) {
            case 0: 
            case 1: 
            case 2: {
                this.bSrc_c = 0;
                this.black_width = (short)(mode == 1 ? SRC_BATTLE_H : 0);
                this.bSrc = mode == 1;
                return true;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                this.bSrc = true;
                if(this.bSrc_c == 0) {
                    if(mode == 5 || mode == 6) {
                        this.bSrc_c = -40;
                        this.black_width = (short)(mode == 5 ? 40 : 0);
                    }
                    else {
                        int v2 = mode == 4 ? SRC_BATTLE_H : 40;
                        this.bSrc_c = (short)v2;
                        this.black_width = (short)v2;
                    }
                }
                this.bSrc_c = Ms.i().mathSpeedN(((int)this.bSrc_c), 0, 12, false);
                if(this.bSrc_c == 0) {
                    this.bSrc = mode != 6;
                    return true;
                }
                return false;
            }
            default: {
                return false;
            }
        }
    }

    public void initWalkIco() {
        if(this.walkIco == null) {
            this.walkIco = Ms.i().createImageArray(3, "data/brow/w");
        }
    }

    public void insertNpc() {
        if(this.npc != null) {
            for(int i = 1; i < this.npcList.length; i = (byte)(i + 1)) {
                for(int j = i; j > 0; j = (byte)(j - 1)) {
                    int v2 = this.getNpcListY(j);
                    int v3 = this.getNpcListY(j - 1);
                    if(v2 > v3) {
                        break;
                    }
                    if(v2 != v3 || this.npcList[j - 1] == -1) {
                        byte temp = this.npcList[j];
                        this.npcList[j] = this.npcList[j - 1];
                        this.npcList[j - 1] = temp;
                    }
                }
            }
        }
    }

    private boolean isAnole(int _x, int _y, int _anole_type) {
        int v3;
        switch(_anole_type) {
            case 0: {
                v3 = 3;
                break;
            }
            case 2: {
                v3 = 4;
                break;
            }
            case 4: {
                v3 = 2;
                break;
            }
            default: {
                return false;
            }
        }
        int check_n = 0;
        if(_x % 20 != 0) {
            check_n = 1;
        }
        if(_y % 20 != 0) {
            check_n = (byte)(check_n + 1);
        }
        if(((byte)(1 << check_n)) == 4 && this.worldData[(_x + 19) / 20][_y / 20] == v3) {
            return true;
        }
        if(((byte)(1 << check_n)) > 1) {
            if(_x % 20 != 0 && this.worldData[(_x + 19) / 20][(_y + 19) / 20] == v3) {
                return true;
            }
            return _y % 20 == 0 || this.worldData[_x / 20][_y / 20] != v3 ? this.worldData[_x / 20][_y / 20] == v3 : true;
        }
        return this.worldData[_x / 20][_y / 20] == v3;
    }

    private boolean isAnoleType(int i) {
        return (this.gr.rmsOther[2] & 1 << i) != 0;
    }

    // Deobfuscation rating: LOW(20)
    private boolean isAuto_canMove(Npc _npc, int sx, int sy) {
        return this.checkWorld(((int)_npc.x), ((int)_npc.y), sx, sy, false) != 1 && !Ms.i().isRect(_npc.x + sx, _npc.y + sy, 19, 19, ((int)this.my.x), ((int)this.my.y), 19, 19);
    }

    private boolean isCan_not_pass(int ix, int iy) {
        if(this.worldData[ix][iy] == 1) {
            return true;
        }
        switch(this.anole_type) {
            case 0: {
                switch(this.worldData[ix][iy]) {
                    case 2: 
                    case 4: {
                        return true;
                    }
                    default: {
                        return false;
                    }
                }
            }
            case 2: {
                switch(this.worldData[ix][iy]) {
                    case 2: 
                    case 3: {
                        return true;
                    }
                    default: {
                        return false;
                    }
                }
            }
            case 4: {
                return this.worldData[ix][iy] != 2;
            }
            default: {
                switch(this.worldData[ix][iy]) {
                    case 2: 
                    case 3: 
                    case 4: {
                        return true;
                    }
                    default: {
                        return false;
                    }
                }
            }
        }
    }

    private boolean isCheckAnole(int id) {
        if(this.anole_type != id && this.isAnoleType(id)) {
            this.anole_type = (byte)id;
            this.setAnole();
            return true;
        }
        if(!this.isAnoleType(id)) {
            this.gr.say("没有" + this.gr.monsterT[id] + "坐骑" + "，不能通过该地形", -1);
        }
        return false;
    }

    private boolean isCheckNpcOff() {
        if(this.checkNpcT < 0) {
            return false;
        }
        if(this.my.speed_x != 0) {
            Ms.i();
            int w = (byte)(20 - Ms.abs(this.my.y - this.npc[0][this.checkNpcT].y));
            return w > 0 && w < 11;
        }
        if(this.my.speed_y != 0) {
            Ms.i();
            int w = (byte)(20 - Ms.abs(this.my.x - this.npc[0][this.checkNpcT].x));
            return w > 0 && w < 11;
        }
        return false;
    }

    private byte isMapChenk(byte checkType) {
        int checkLeft = 0;
        int checkRight = 0;
        int ix = (byte)(this.my.x / 20);
        int iy = (byte)(this.my.y / 20);
        if(this.my.speed_x == 0) {
            checkLeft = this.checkMap((ix - (this.my.x % 20 == 0 ? 1 : 0)) * 20, ((this.my.speed_y < 0 ? -1 : 1) + iy) * 20, 0, 0);
            checkRight = this.checkMap((ix + 1) * 20, ((this.my.speed_y < 0 ? -1 : 1) + iy) * 20, 0, 0);
        }
        else if(this.my.speed_y == 0) {
            checkLeft = this.checkMap(((this.my.speed_x < 0 ? -1 : 1) + ix) * 20, (iy - (this.my.y % 20 == 0 ? 1 : 0)) * 20, 0, 0);
            checkRight = this.checkMap(((this.my.speed_x < 0 ? -1 : 1) + ix) * 20, (iy + 1) * 20, 0, 0);
        }
        if(checkLeft == 1 && checkRight == 1) {
            return checkType;
        }
        if(checkLeft == 0 && this.checkMap((this.my.speed_x == 0 ? ix - (this.my.x % 20 == 0 ? 1 : 0) : ix) * 20, (this.my.speed_y == 0 ? iy - (this.my.y % 20 == 0 ? 1 : 0) : iy) * 20, 0, 0) == 0) {
            return -1;
        }
        if(checkRight == 0) {
            int v4 = this.my.speed_x == 0 ? (this.my.x % 20 == 0 ? 1 : 0) + ix : ix;
            if(this.my.speed_y != 0 || this.my.y % 20 != 0) {
                return this.checkMap(v4 * 20, iy * 20, 0, 0) == 0 ? -2 : checkType;
            }
            return this.checkMap(v4 * 20, (1 + iy) * 20, 0, 0) == 0 ? -2 : checkType;
        }
        return checkType;
    }

    private boolean isMapEvent(int _mapNo, int _i) {
        return (this.mapInfo[_mapNo * 2 + 1] & 1 << _i) != 0;
    }

    private boolean isMission(int id) {
        return (this.bMission[((byte)(id / 8))] & 1 << ((byte)(id % 8))) != 0;
    }

    private boolean isNpcSrc(int ax, int ay) {
        return this.map_x + ax >= -80 && this.map_x + ax <= Constants_H.WIDTH + 60 && this.map_y + ay >= -80 && this.map_y + ay <= Constants_H.HEIGHT + 60;
    }

    private boolean isTrundleNpc(int ix, int iy) {
        int v2 = this.checkIfNpc(this.npc[0], ix, iy);
        if(v2 != -1) {
            switch(this.npc[0][v2].other[4]) {
                case 1: 
                case 3: {
                    return true;
                }
                default: {
                    return false;
                }
            }
        }
        return ix < 0 || ix >= this.cols || iy < 0 || iy >= this.rows || this.worldData[ix][iy] == 1;
    }

    private void keyAnoleSel() {
        if(!Ms.i().key_delay()) {
            if(Ms.i().key_Left_Right()) {
                this.anoleSel = Ms.i().select(((int)this.anoleSel), 0, 4);
                return;
            }
            if(Ms.i().key_S1()) {
                if(!this.isAnoleType(((int)this.anoleSel))) {
                    this.gr.say("还没有获得该骑宠", 0);
                }
                else if(this.anoleSel == 4) {
                    this.gr.say("只能在水里使用", 0);
                }
                else {
                    this.anole_type = this.anole_type == this.anoleSel ? -1 : this.anoleSel;
                    if(this.gr.rmsSms[6] == 10 && this.anole_type == 3 && this.gr.rmsSms[0] == 0) {
                        SMSSender.i(this.gr).go(1, true);
                        this.anole_type = -1;
                    }
                    else {
                        if(this.anole_type == 3 && this.gr.rmsSms[0] == 0) {
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
                return;
            }
            if(Ms.i().key_S2() || Ms.i().key_Num9()) {
                this.my.state = 0;
                Ms.i().keyRelease();
            }
        }
    }

    private void keyMiniMap() {
        Ms.i().keyRelease();
        if(!Ms.i().key_S1_Num5()) {
            if(Ms.i().key_S2() || Ms.i().key_Num0()) {
                this.my.state = 0;
                this.mapdataArea = null;
                this.mapdataMap = null;
                return;
            }
            if((Ms.i().key_Left_Right() || Ms.i().key_Up_Down()) && this.mapdataMap[this.selectMap].length >= 6 && this.mapdataMap[this.selectMap][1] != -1) {
                this.selectMap = this.mapdataMap[this.selectMap][1];
            }
        }
    }

    private void keyMission() {
        if(!Ms.i().key_delay()) {
            if(Ms.i().key_Left_Right() || Ms.i().key_Num1() && this.gr.cur_a == 1 || Ms.i().key_Num3() && this.gr.cur_a == 0) {
                this.gr.cur_a = (byte)(this.gr.cur_a ^ 1);
                this.goMission(((int)this.gr.cur_a), this.bPause);
                return;
            }
            if(Ms.i().key_Up_Down()) {
                int length = this.gr.cur_a == 0 ? ((byte)(this.bMission[14] + 1 <= this.sMission.length ? this.bMission[14] + 1 : this.sMission.length)) : ((byte)this.mDirect.length);
                Ms.i().selectS(this.gr.select[0], 0, length, ((int)this.gr.line_max));
                if(this.gr.cur_a == 0) {
                    this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), 590, 0);
                    return;
                }
                if(this.mDirect.length > 0) {
                    this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 590, 0);
                    return;
                }
                this.gr.about_a = null;
                return;
            }
            if(Ms.i().key_S2() || Ms.i().key_Num1() || Ms.i().key_Num3()) {
                this.my.state = 0;
                if(this.bPause) {
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
        if(Ms.i().key_S1()) {
            this.my.state = 0;
            this.eventGoing = 2;
            return;
        }
        if(Ms.i().key_S2()) {
            this.my.state = 0;
            this.eventGoing = 3;
        }
    }

    private void keySelectMenu() {
        if(!Ms.i().key_delay()) {
            if(Ms.i().key_S1_Num5()) {
                this.my.state = 13;
                return;
            }
            if(Ms.i().key_Up_Down()) {
                GameRun gameRun0 = this.gr;
                gameRun0.cur_a = Ms.i().select(((int)this.gr.cur_a), 0, this.gr.action_str.length - 1);
            }
        }
    }

    public void key_map() {
        switch(this.my.state) {
            case 12: {
                this.keySelectMenu();
                return;
            }
            case 17: {
                this.keyMiniMap();
                return;
            }
            case 18: {
                this.keyMission();
                return;
            }
            case 19: {
                this.keyMySave();
                return;
            }
            case 22: {
                if(this.black_0 > -1 && this.black_0 == this.gr.about_d.length && Ms.i().key_Num0()) {
                    this.eventGoing = 3;
                    this.black_0 = -1;
                    Ms.i().keyRelease();
                    return;
                }
            }
        }
        switch(this.my.state) {
            case 10: {
                Ms.i().keyRelease();
                return;
            }
            case 11: {
                if(Ms.i().key_S1_Num5()) {
                    this.gr.say_c = 0;
                }
                if(this.gr.say_c == 0) {
                    this.my.state = 0;
                    return;
                }
                break;
            }
            case 16: {
                if(!Ms.i().key_delay()) {
                    if(Ms.i().key_Up_Down()) {
                        this.gr.popMenu = (byte)(this.gr.popMenu ^ 1);
                    }
                    else if(Ms.i().key_S1_Num5() || Ms.i().key_S2()) {
                        if(Ms.i().key_S2()) {
                            this.gr.popMenu = 1;
                        }
                        this.my.state = 0;
                        return;
                    }
                label_42:
                    if(this.my.state != 1 || !Ms.i().key_S1_Num5()) {
                    label_58:
                        if(this.my.frame_c <= 0 && this.my.state == 0) {
                            Ms.i();
                            this.map_key = (byte)(-Ms.key);
                            this.doKey();
                            return;
                        }
                    }
                    else if(this.dialog_no + 2 >= this.dialog.length) {
                        this.dialog_no = -1;
                        this.dialog = null;
                        if(this.eventGoing == 0) {
                            this.my.state = 0;
                        }
                        else {
                            this.eventGoing = 2;
                        }
                        if(this.bDirTalk) {
                            this.npc[0][this.get_meet].other[7] = this.npcDirTalk;
                            if(this.npc[0][this.get_meet].other[7] > -1) {
                                this.npc[0][this.get_meet].dir = 3;
                            }
                            this.bDirTalk = false;
                            return;
                        }
                    }
                    else {
                        this.dialog_no = (byte)(this.dialog_no + 2);
                        Ms.i().keyRelease();
                        goto label_58;
                    }
                }
                break;
            }
            case 20: {
                this.keyAnoleSel();
                return;
            }
            case 23: {
                if(Ms.i().key_S2()) {
                    this.my.state = 25;
                }
                else if(Ms.i().key_S1_Num5()) {
                    this.my.state = 24;
                }
                Ms.i().keyRelease();
                return;
            }
            default: {
                goto label_42;
            }
        }
    }

    public void loadDate_Rms() {
        byte[] info = Ms.i().rmsOptions(2, null, 1);
        if(info[0] == -1) {
            byte[] arr_b1 = new byte[16];
            arr_b1[0] = 58;
            arr_b1[1] = 9;
            arr_b1[2] = 16;
            arr_b1[3] = 2;
            arr_b1[5] = 1;
            arr_b1[6] = 2;
            arr_b1[15] = -1;
            info = arr_b1;
            Ms.i().rmsOptions(2, arr_b1, 2);
            this.event_now_list = new short[70][];
            Ms.i().rmsOptions(12, Ms.i().getEventNowData(this.event_now_list), 2);
        }
        else {
            this.event_now_list = Ms.i().readEventNowData();
        }
        this.mapNo = info[0];
        this.lastMap = info[5];
        this.lastExit = info[6];
        this.my.setXY(((int)info[1]), ((int)info[2]), 0, 0);
        this.my.dir = info[3];
        this.my.setActionNo(false);
        GameRun gameRun0 = this.gr;
        gameRun0.money = Ms.i().getInt(info, 7);
        GameRun gameRun1 = this.gr;
        gameRun1.coin = Ms.i().getInt(info, 11);
        this.anole_type = info[15];
    }

    private void loadMapData(int id) {
        int arrayIndex;
        int z;
        int y;
        int x;
        int arrayIndex;
        byte[] buff;
        DataInputStream dis;
        byte[] buffShort;
        try {
            buffShort = new byte[2];
            byte[] buffInt = new byte[4];
            this.bottomData = null;
            this.frontData = null;
            this.worldData = null;
            dis = new DataInputStream(AndroidUtil.getResourceAsStream(("/data/map/" + id + ".mid")));
            dis.skip(2L);
            dis.read(buffInt);
            Ms.i();
            this.bgColor = (int)Ms.getNum(buffInt);
            buff = new byte[dis.readByte()];
            dis.read(buff);
            dis.read(buff);
            Ms.i();
            this.cols = (byte)(((int)Ms.getNum(buff)));
            dis.read(buff);
            Ms.i();
            this.rows = (byte)(((int)Ms.getNum(buff)));
            this.worldData = new short[this.cols][this.rows];
            for(int i = 0; true; i = (byte)(i + 1)) {
                if(i >= 3) {
                    dis.close();
                    return;
                }
                int layerType = dis.readByte();
                if(layerType != -1) {
                    dis.read(buffInt);
                    Ms.i();
                    int elemNum = ((int)Ms.getNum(buffInt)) * 3;
                    switch(layerType) {
                        case 1: {
                            this.bottomData = new short[elemNum];
                            break;
                        }
                        case 3: {
                            this.frontData = new short[elemNum];
                        }
                    }
                    arrayIndex = 0;
                label_34:
                    if(arrayIndex >= elemNum) {
                        continue;
                    }
                    break;
                }
            }
        }
        catch(Exception unused_ex) {
            return;
        }
        try {
            dis.read(buff);
            Ms.i();
            x = (short)(((int)Ms.getNum(buff)));
            dis.read(buff);
            long v6 = (long)(this.rows - 1);
            Ms.i();
            y = (short)(((int)(v6 - Ms.getNum(buff))));
            dis.read(buffShort);
            Ms.i();
            z = (short)(((int)Ms.getNum(buffShort)));
            switch(layerType) {
                case 1: {
                    break;
                }
                case 2: {
                    this.worldData[x][y] = (short)(z >> 3);
                    arrayIndex = (short)(arrayIndex + 3);
                    goto label_34;
                }
                case 3: {
                    goto label_59;
                }
                default: {
                    goto label_34;
                }
            }
        }
        catch(Exception unused_ex) {
            return;
        }
        try {
            this.bottomData[arrayIndex] = (short)x;
            arrayIndex = (short)(((short)(arrayIndex + 1)) + 1);
        }
        catch(Exception unused_ex) {
            return;
        }
        try {
            this.bottomData[((short)(arrayIndex + 1))] = (short)y;
        }
        catch(Exception unused_ex) {
            return;
        }
        try {
            this.bottomData[arrayIndex] = (short)z;
            arrayIndex = (short)(arrayIndex + 1);
            goto label_34;
        label_59:
            this.frontData[arrayIndex] = (short)x;
            arrayIndex = (short)(((short)(arrayIndex + 1)) + 1);
        }
        catch(Exception unused_ex) {
            return;
        }
        try {
            this.frontData[((short)(arrayIndex + 1))] = (short)y;
        }
        catch(Exception unused_ex) {
            return;
        }
        try {
            this.frontData[arrayIndex] = (short)z;
            arrayIndex = (short)(arrayIndex + 1);
        }
        catch(Exception unused_ex) {
            return;
        }
        goto label_34;
    }

    private void loadMapModuleAndImage() {
        Ms.i();
        Ms.skip = 0;
        byte[] arr_b = Ms.i().getStream("data/map/area.dat", -1);
        byte[] arr_b1 = Ms.i().createArray(arr_b);
        byte[][] arr2_b = Ms.i().create2Array(arr_b);
        if(this.mapImg == null || arr_b1[this.lastMap] != arr_b1[this.mapNo]) {
            Ms.i();
            Ms.skip = 0;
            this.moduleData = Ms.i().createShort2Array(Ms.i().getStream("data/map/" + ((int)arr_b1[this.mapNo]) + ".data", -1), 1);
            this.mapImg = null;
            this.mapImg = new Image[arr2_b[arr_b1[this.mapNo]].length];
            for(int i = 0; i < arr2_b[arr_b1[this.mapNo]].length; i = (byte)(i + 1)) {
                Image[] arr_image = this.mapImg;
                arr_image[i] = Ms.i().createImage("data/map/" + ((int)arr2_b[arr_b1[this.mapNo]][i]));
            }
        }
    }

    public void mapMove(int x, int y, int xs, int ys) {
        if(xs > 0 && x >= this.mapLeft_NOmove && x < this.mapRight_NOmove || xs < 0 && x > this.mapLeft_NOmove && x <= this.mapRight_NOmove) {
            this.map_x -= xs;
        }
        if(ys > 0 && y >= this.mapUp_NOmove && y < this.mapDown_NOmove || ys < 0 && y > this.mapUp_NOmove && y <= this.mapDown_NOmove) {
            this.map_y -= ys;
        }
    }

    public void map_saveGame() {
        byte[] info = new byte[16];
        info[0] = this.mapNo;
        info[5] = this.lastMap;
        info[6] = this.lastExit;
        info[1] = (byte)(this.my.x / 20);
        info[2] = (byte)(this.my.y / 20);
        info[3] = this.my.dir;
        Ms.i().putInt(this.gr.money, info, 7);
        Ms.i().putInt(this.gr.coin, info, 11);
        info[15] = this.anole_type;
        Ms.i().rmsOptions(2, info, 2);
    }

    private int map_set(int _my_x, int cols, int xcells, int half_xcells, int show_width, int cell_width) {
        if(cols <= xcells) {
            return show_width - cell_width * cols >> 1;
        }
        if(_my_x + 1 <= half_xcells) {
            return 0;
        }
        return _my_x < cols - half_xcells ? show_width / 2 - _my_x * cell_width - cell_width / 2 : show_width - cols * cell_width;
    }

    private void meetGrass() {
        if(this.meet_step < this.step_MEET) {
            if(this.worldData[this.my.getIx()][this.my.getIy()] != 7) {
                this.meet_step = (short)(this.meet_step + 1);
            }
            return;
        }
        if(this.gr.monPro.length > 1 && this.gr.immueEnemy == 0) {
            this.my.frame_c = 0;
            this.my.state = 8;
        }
        this.notMeet(0, 0);
    }

    private void moveOff(byte dirx, byte diry, int speed) {
        if(this.my.speed_x == 0) {
            this.my.dir = dirx;
        }
        else if(this.my.speed_y == 0) {
            this.my.dir = diry;
        }
        this.my.speed_x = (byte)(this.my.speed_x == 0 ? speed : 0);
        this.my.speed_y = (byte)(this.my.speed_y == 0 ? speed : 0);
        this.checkMoveOff(((int)this.checkNpcT));
        this.initMoveMy();
    }

    private void nextEvent(int mode) {
        if((mode & 0x1000) != 0) {
            this.now_eV1 = 0;
            this.now_eV2 = 0;
        }
        if((mode & 0x100) != 0) {
            this.eventGoing = 0;
        }
        if((mode & 16) != 0) {
            this.event_state = 1;
        }
        if((mode & 1) != 0) {
            this.my.state = 0;
        }
        this.pkey.initPointer();
    }

    public void notMeet(int kind, int id) {
        switch(kind) {
            case 0: {
                this.notMeet = 0;
                Ms.i();
                this.step_MEET = (short)(Ms.getRandom(30) + 1);
                this.meet_step = (short)((this.step_MEET - 15) * (this.step_MEET - 15));
                int v2 = this.meet_step;
                Ms.i();
                if(v2 > Ms.getRandom(50)) {
                    Ms.i();
                    int v3 = Ms.getRandom(9) + 17;
                    Ms.i();
                    this.step_MEET = (byte)(v3 - Ms.getRandom(7));
                }
                this.step_MEET = (short)(this.step_MEET << 2);
                this.meet_step = 0;
                this.bStep = -1;
                return;
            }
            case 1: {
                this.notMeet = 1;
                this.step_MEET = (short)((id - 13) * 200);
                this.step_MEET = (short)(this.step_MEET << 2);
                this.meet_step = 0;
                this.bStep = 100;
            }
        }
    }

    public void nullNpcFace() {
        this.imgFace = null;
    }

    private void oneMove(Npc npc_, int i) {
        if(npc_.frame_c > 0) {
            if(this.srcNpcNo == i) {
                this.mapMove(((int)npc_.x), ((int)npc_.y), ((int)npc_.speed_x), ((int)npc_.speed_y));
            }
            npc_.x = (short)(npc_.x + npc_.speed_x);
            npc_.y = (short)(npc_.y + npc_.speed_y);
            npc_.frame_c = (byte)(npc_.frame_c - 1);
            return;
        }
        if(npc_.frame_c != -1) {
            npc_.frame_c = -1;
            npc_.setActionNo(false);
        }
    }

    public void paint_map(Graphics g) {
        Map.g = g;
        if(this.my.state == 6) {
            this.gr.drawChangeMap(false, ((int)this.gr.b_c), 30, 322, 580);
            return;
        }
        switch(this.my.state) {
            case 17: {
                this.drawMiniMap();
                return;
            }
            case 18: {
                this.drawMission();
                return;
            }
            default: {
                Ui.i().fillRect(this.bgColor, 0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
                GameRun.mc.setScale(MainCanvas.mapxx, MainCanvas.mapyy);
                GameRun.mc.keyxx = MainCanvas.mapxx;
                GameRun.mc.keyyy = MainCanvas.mapyy;
                this.setMapOffer();
                if(this.xxx > 0) {
                    this.xxx = (byte)(this.xxx - 1);
                    g.translate(this.xxx % 2, this.xxx % 2);
                }
                this.drawMap(GameRun.offG);
                this.drawNpcAni(this.npc[2]);
                if(this.pkey.isGo) {
                    int v = this.ii;
                    this.ii = v + 1;
                    if(v > 2) {
                        this.ii = 0;
                        int v1 = this.i;
                        this.i = v1 + 1;
                        this.i = v1 >= 2 ? 0 : this.i;
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
                if(this.gr.magic_id > -1 && this.gr.drawMagicC((this.gr.magic_id / 5 <= 5 ? this.gr.magic_id / 5 : 5), (this.gr.magic_id / 5 <= 5 ? this.gr.magic_id / 5 : 5), (this.gr.magic_id / 5 < 5 ? this.gr.magic_id % 5 : this.gr.magic_id - 25), this.gr.magic_x, this.gr.magic_y + 16, 0)) {
                    if(this.my.state == 21) {
                        this.gr.magic_id = -2;
                        this.setAnole();
                    }
                    else {
                        this.gr.magic_id = -1;
                    }
                    this.my.state = 0;
                }
                g.translate(-g.getTranslateX(), -g.getTranslateY());
                if(this.my.state == 20) {
                    this.drawAnoleSel();
                }
                g.restCanvas();
                if(!this.fontSizeControl) {
                    Ms.i();
                    Ms.font.setSize(22);
                }
                this.drawSrcEffect();
                if(this.my.state == 12) {
                    this.gr.drawSelectMenu_(this.gr.action_str, Constants_H.WIDTH__ / 2 - 75, Constants_H.HEIGHT__ / 2 - 100 + (this.gr.action_str.length >> 1) * 25, 150, 0, 0, ((int)this.gr.cur_a));
                }
                if(this.gr.view_state == 4) {
                    int WIDTH = Constants_H.WIDTH__;
                    int HEIGHT = Constants_H.HEIGHT__;
                    int WIDTH_H = Constants_H.WIDTH__ / 2;
                    Ui.i().drawKuang(0, HEIGHT - 75, WIDTH, 75);
                    this.gr.showStringM_(this.gr.getNameMonsterInfo(((int)new byte[]{4, 25, 56}[this.gr.cur_a])), WIDTH_H, HEIGHT - 58, 10, 3);
                }
                else if(this.my.state == 16) {
                    int WIDTH = Constants_H.WIDTH__;
                    int HEIGHT = Constants_H.HEIGHT__;
                    int WIDTH_H = Constants_H.WIDTH__ / 2;
                    int HEIGHT_H = Constants_H.HEIGHT__ / 2;
                    Ui.i().drawKuang(0, HEIGHT - 100, WIDTH, 100);
                    this.gr.showStringM_("是否回复所有宠物？", WIDTH_H, HEIGHT - 0x60, 10, 3);
                    this.gr.drawSelectMenu_(this.gr.action_str, WIDTH_H - 50, HEIGHT_H - 25, 100, -1, 0, ((int)this.gr.popMenu));
                    this.gr.showStringM_("所需金额：" + this.gr.sell_money, WIDTH_H, HEIGHT - 71, 10, 3);
                    this.gr.drawMoney(WIDTH_H, HEIGHT - 10, 3, false);
                }
                if(this.my.state != 20) {
                    this.gr.drawPauseIco(((int)this.my.state));
                }
                if(this.my.state == 19) {
                    this.drawMySave();
                    return;
                }
                int v9 = this.gr.rmsOther[2];
                this.gr.drawCityName();
                if(this.my.state == 23) {
                    int WIDTH = Constants_H.WIDTH__;
                    int HEIGHT = Constants_H.HEIGHT__;
                    int WIDTH_H = Constants_H.WIDTH__ / 2;
                    Ui.i().drawKuang(0, HEIGHT - 50, WIDTH, 50);
                    Ui.i().drawString("是否保存进度？", WIDTH_H, HEIGHT - 44, 17, 3, 0);
                    Ui.i().drawYesNo__(true, true);
                    this.pkey.isGo = false;
                }
                if(this.dialog_no > -1) {
                    this.dialog(this.npcName);
                    this.pkey.isGo = false;
                }
                this.gr.map_flashString();
                Ms.i();
                Ms.font.setSize(26);
            }
        }
    }

    private void runAutoMoveNpc(Npc npc, int i) {
        if(this.my.state == 1 && this.get_meet == i) {
            byte[] arr_b = npc.other;
            Ms.i();
            arr_b[7] = (byte)(Ms.abs(npc.other[7]) / 3 * 3 + (this.my.dir >= 4 ? this.my.dir - 2 : this.my.dir - 1));
            if(this.my.dir == 3) {
                npc.other[7] = (byte)(-npc.other[7]);
                return;
            }
            npc.dir = 3;
            return;
        }
        if(this.initAuto(npc, 10)) {
            if(npc.b_auto) {
                this.runAutoX(npc, ((int)this.gr.mapMove[(npc.other[8] - 5) * 2]));
                return;
            }
            this.runAutoY(npc, ((int)this.gr.mapMove[(npc.other[8] - 5) * 2 + 1]));
        }
    }

    private void runAutoX(Npc _npc, int w) {
        if(_npc.timeMove == 0) {
            Ms.i();
            _npc.dir = Ms.getRandom(100) >= 50 ? 4 : 3;
            int t = _npc.dir == 3 ? ((short)(_npc.x - _npc.other[0] * 20)) : ((short)((_npc.other[0] + w) * 20 - _npc.x));
            if(t <= 20) {
                _npc.timeMove = (byte)(t / _npc.speed);
                return;
            }
            Ms.i();
            _npc.timeMove = (byte)(Ms.getRandom((t - 20) / _npc.speed + 1) + 20 / _npc.speed);
            return;
        }
        if(_npc.timeMove > 0 && _npc.frame_c < 1) {
            int v2 = _npc.dir == 3 ? -_npc.speed : _npc.speed;
            if(this.isAuto_canMove(_npc, v2, 0)) {
                int v3 = _npc.dir == 3 ? -_npc.speed : _npc.speed;
                _npc.setSpeedXY(v3, 0);
                _npc.timeMove = (byte)(_npc.timeMove - 1);
                _npc.frame_c = 1;
                _npc.setActionNo(true);
                return;
            }
            _npc.timeMove = -20;
            _npc.frame_c = -1;
            _npc.setActionNo(false);
        }
    }

    private void runAutoY(Npc _npc, int w) {
        if(_npc.timeMove == 0 && _npc.frame_c == -1) {
            Ms.i();
            _npc.dir = Ms.getRandom(100) >= 50 ? 2 : 1;
            int t = _npc.dir == 1 ? ((short)(_npc.y - _npc.other[1] * 20)) : ((short)((_npc.other[1] + w) * 20 - _npc.y));
            if(t <= 20) {
                _npc.timeMove = (byte)(t / _npc.speed);
                return;
            }
            Ms.i();
            _npc.timeMove = (byte)(Ms.getRandom((t - 20) / _npc.speed + 1) + 20 / _npc.speed);
            return;
        }
        if(_npc.timeMove > 0 && _npc.frame_c < 1) {
            int v2 = _npc.dir == 1 ? -_npc.speed : _npc.speed;
            if(this.isAuto_canMove(_npc, 0, v2)) {
                int v3 = _npc.dir == 1 ? -_npc.speed : _npc.speed;
                _npc.setSpeedXY(0, v3);
                _npc.timeMove = (byte)(_npc.timeMove - 1);
                _npc.frame_c = 1;
                _npc.setActionNo(true);
                return;
            }
            _npc.timeMove = -20;
            _npc.frame_c = -1;
            _npc.setActionNo(false);
        }
    }

    private void runBoat() {
        if(this.boatSelect == -1 || this.my.ix != -1 || this.my.iy != -1) {
            return;
        }
        this.my.state = 9;
        byte b = (byte)(this.gr.cur_a + 2);
        this.gr.cur_a = b;
        if(b >= this.boatCourse[this.boatSelect].length) {
            this.boatSelect = -1;
            this.my.state = 0;
            this.anole_type = -1;
            this.setAnole();
            return;
        }
        this.checkType = this.checkIfOther(this.door, ((int)this.my.x), ((int)this.my.y));
        if(this.checkType != -1) {
            this.my.state = 5;
            this.get_meet = this.checkType;
        }
        this.my.setIXY(((int)this.boatCourse[this.boatSelect][this.gr.cur_a]), ((int)this.boatCourse[this.boatSelect][this.gr.cur_a + 1]));
    }

    private void runEvent_brow(int i) {
        int event_temp = this.event[i][this.event_now[i] + 2] - 1;
        Map.cur_npc = event_temp == -1 ? this.my : this.npc[this.getNpcLayer(event_temp)][this.getNpcId(event_temp)];
        switch(this.event[i][this.event_now[i] + 4]) {
            case 0: {
                Map.cur_npc.brow_type = this.event[i][this.event_now[i] + 3];
                Map.cur_npc.brow_action = 0;
                Map.cur_npc.brow_time = 0;
                break;
            }
            case 1: {
                Map.cur_npc.other[6] = this.event[i][this.event_now[i] + 3];
                break;
            }
            default: {
                if(this.event[i][this.event_now[i] + 4] == 2) {
                    Map.cur_npc.brow_type = -1;
                    Map.cur_npc.other[6] = 0;
                }
            }
        }
        this.event_now[i] = (short)(this.event_now[i] + 5);
        this.nextEvent(0x1010);
    }

    private void runEvent_dialog(int i) {
        this.checkNpcT = -1;
        if(this.eventGoing == 0) {
            this.eventGoing = 1;
            if(this.anole_type == 1) {
                this.setAnole();
            }
            int event_temp = this.event[i][this.event_now[i] + 2] - 1;
            if(event_temp == -1) {
                this.npcName = "塞其";
                this.now_eV2 = 0;
            }
            else {
                this.now_eV1 = this.getNpcLayer(event_temp);
                this.now_eV2 = this.getNpcId(event_temp);
                this.npcName = this.npcNameData[this.now_eV2];
                if(this.npcName.equals("路人")) {
                    this.npcName = null;
                }
                this.now_eV2 = this.npc[this.now_eV1][this.now_eV2].other[2];
            }
            this.initNpcFaceOne(this.npcName);
            Ms.i();
            Ms.font.setSize(22);
            this.dialog = Ms.i().groupString(Ms.i().getDialogs(this.event[i], this.event_now[i] + 5, ((int)this.event[i][this.event_now[i] + 4])), Constants_H.WIDTH__ - 20);
            if(!this.fontSizeControl) {
                Ms.i();
                Ms.font.setSize(26);
            }
            this.dialog_no = 0;
            this.my.state = 1;
            this.bDirTalk = false;
            return;
        }
        if(this.eventGoing == 2) {
            this.event_now[i] = (short)(this.event_now[i] + ((this.event[i][this.event_now[i] + 4] << 1) + 5));
            this.nextEvent(4369);
        }
    }

    private void runEvent_getMon(int i) {
        this.gmErr = false;
        if(this.gr.getMonster(((int)this.event[i][this.event_now[i] + 2]), ((int)this.event[i][this.event_now[i] + 3]), ((int)this.event[i][this.event_now[i] + 4]), -1) == -1) {
            this.gr.say("宠物空间已满，无法获得新的宠物，请整理寄存所空出一个空间。", -1);
            this.gmErr = true;
            this.gr.mini_state = 6;
            this.gr.view_state = 1;
            this.gr.goVIEW_MONSTER();
            return;
        }
        this.event_now[i] = (short)(this.event_now[i] + (this.event[i][this.event_now[i] + 1] + 2));
        this.nextEvent(0x1110);
    }

    private void runEvent_goShop(int i) {
        int event_temp = this.event[i][this.event_now[i] + 3];
        if(event_temp == 4) {
            if(this.inShop == 0 && this.my.state != 16) {
                this.my.state = 16;
                this.inShop = 1;
                this.gr.setAction_str(new String[]{"回复", "不回复"});
                this.gr.popMenu = 0;
                this.gr.sell_money = 0;
                for(int d = 0; d < this.gr.myMon_length; d = (byte)(d + 1)) {
                    this.gr.sell_money += this.gr.myMonsters[d].monster[4] * 20 + 40;
                }
                return;
            }
            if(this.my.state == 0) {
                if(this.inShop == 1 && this.gr.popMenu == 0) {
                    this.inShop = 2;
                    if(!this.gr.checkMonster() && this.gr.isMoney(this.gr.sell_money, true)) {
                        this.gr.healMonster(true);
                        return;
                    }
                }
                else if(this.gr.say_c == 0) {
                    this.inShop = 0;
                    this.event_now[i] = (short)(this.event_now[i] + 4);
                    this.nextEvent(0);
                    return;
                }
            }
            return;
        }
        if(event_temp < 3) {
            this.gr.goBUY_ITEM(((int)this.event[i][this.event_now[i] + 2]), event_temp);
        }
        else {
            switch(event_temp) {
                case 3: {
                    this.gr.goVIEW_COMPUTER(0);
                    break;
                }
                case 5: {
                    this.gr.goNidus(0);
                    break;
                }
                case 6: {
                    this.gr.view_state = 4;
                    this.gr.popMenu = -1;
                    break;
                }
                case 7: {
                    this.gr.view_state = 1;
                }
            }
        }
        this.event_now[i] = (short)(this.event_now[i] + 4);
        this.nextEvent(16);
    }

    private void runEvent_item_add_del(int i) {
        int event_temp = 0;
        if(this.eventGoing == 0) {
            this.now_eV1 = this.event[i][this.event_now[i] + 2];
            this.now_eV2 = this.event[i][this.event_now[i] + 3];
            if(this.event[i][this.event_now[i] + 3] >= 0) {
                event_temp = this.gr.addItem(((int)this.now_eV1), ((int)this.now_eV2));
            }
            else {
                int v2 = this.gr.findItem(-2, ((int)this.now_eV1), true);
                Ms.i();
                if(v2 >= Ms.abs(this.now_eV2)) {
                    GameRun gameRun0 = this.gr;
                    int v3 = this.now_eV1;
                    Ms.i();
                    gameRun0.deleteItems(v3, Ms.abs(this.now_eV2));
                }
                else {
                    this.gr.say("道具不足！", 0);
                    event_temp = -1;
                }
            }
            if(event_temp != -1) {
                GameRun gameRun1 = this.gr;
                String s = this.now_eV2 < 0 ? "失去：" : "获得：";
                String s1 = this.gr.getNameItem(((int)this.now_eV1));
                Ms.i();
                gameRun1.say(s + s1 + "x" + Ms.abs(this.now_eV2), 0);
            }
            this.eventGoing = 1;
            return;
        }
        if(this.gr.say_c == 0) {
            this.event_now[i] = (short)(this.event_now[i] + 4);
            this.nextEvent(0x1110);
        }
    }

    private void runEvent_miniGame_myLevel(int i) {
        int event_temp = this.event[i][this.event_now[i] + 2];
        if(event_temp > 1) {
            this.event_now[i] = (short)(this.event_now[i] + 3);
            this.nextEvent(0x1110);
            return;
        }
        if(this.eventGoing < 2) {
            if(event_temp == 0) {
                switch(this.gr.magic_id) {
                    case -2: {
                        if(this.gr.rmsOther[3] == 5) {
                            this.gr.magic_id = -2;
                            this.eventGoing = 2;
                            this.gr.say("您当前的训练师等级已达到上限！", 0);
                            return;
                        }
                        GameRun gameRun0 = this.gr;
                        gameRun0.sell_money = this.gr.isMyLevel(true);
                        if(this.gr.sell_money == -1) {
                            this.my.state = 10;
                            this.gr.magic_id = 28;
                            this.gr.magic_x = this.map_x + this.my.x + 10;
                            this.gr.magic_y = this.map_y + this.my.y + 19;
                            this.gr.setMagic(this.gr.magic_id / 5);
                            this.gr.setMaxTakes(false);
                            return;
                        }
                        this.eventGoing = 2;
                        return;
                    }
                    case -1: {
                        this.gr.magic_id = -2;
                        this.eventGoing = 2;
                        this.gr.say("恭喜您的训练师等级已提升为#7" + ((int)this.gr.rmsOther[3]) + "#0，您随身可携带宠物数量#7暴增到" + ((int)this.gr.max_takes) + "#0，您商店能存放的宠物#7暴增到" + ((int)this.gr.max_monsters), -1);
                        return;
                    }
                    default: {
                        return;
                    }
                }
            }
            if(event_temp == 1) {
                if(this.eventGoing == 0 && this.gr.monInfoList[104] == 0) {
                    this.gr.sell_money = 0;
                    this.eventGoing = 3;
                    this.gr.say("此次您没有捕获到全新的宠物，捕获并不是唯一途径，有些宠物需要通过进化才能获得哦。", -1);
                    return;
                }
                if(this.eventGoing == 0) {
                    this.eventGoing = 3;
                    this.gr.sell_money = this.gr.monInfoList[104];
                    this.gr.monInfoList[104] = 0;
                    this.gr.say("此次您捕获了" + this.gr.sell_money + "个新宠物，这里是王国训练师机构奖励给您的" + this.gr.sell_money + "个徽章，希望再接再厉哦。", -1);
                    this.gr.coin += this.gr.sell_money;
                }
            }
        }
        else if(this.gr.say_c == 0) {
            switch(this.eventGoing) {
                case 2: {
                    if(this.gr.rmsOther[3] == 5) {
                        this.gr.say("您当前的训练师等级已达到上限！", 0);
                    }
                    else {
                        GameRun gameRun1 = this.gr;
                        gameRun1.sell_money = (byte)(this.gr.isMyLevel(false) - this.gr.monInfoList[103]);
                        if(this.gr.sell_money < 1) {
                            this.gr.sell_money = 0;
                        }
                        this.gr.say("当前训练师等级为#7" + ((int)this.gr.rmsOther[3]) + "#0距离下次升级还需要捕捉#7" + this.gr.sell_money + "#0只不同的宠物，努力获得新宠吧。", -1);
                    }
                    this.eventGoing = 4;
                    return;
                }
                case 3: {
                    if(this.gr.sell_money > 0) {
                        this.gr.say("获得：徽章x" + this.gr.sell_money, 0);
                        this.eventGoing = 4;
                        return;
                    }
                }
            }
            this.event_now[i] = (short)(this.event_now[i] + 3);
            this.nextEvent(0x1110);
        }
    }

    private void runEvent_select(int i) {
        if(this.my.state != 12 && this.my.state != 13 && this.my.state != 14) {
            this.sEvent_eV2 = this.event[i][this.event_now[i] + 1];
            this.sEvent_eV1 = 0;
            this.gr.action_str = null;
            this.gr.action_str = new String[this.sEvent_eV2];
            for(int j = 0; j < this.sEvent_eV2; j = (byte)(j + 1)) {
                String[] arr_s = this.gr.action_str;
                arr_s[j] = Ms.i().getDialogs(this.event[i], this.event_now[i] + 2 + this.sEvent_eV1 + 1, ((int)this.event[i][this.event_now[i] + 2 + this.sEvent_eV1]));
                this.sEvent_eV1 = (byte)(this.sEvent_eV1 + ((this.event[i][this.event_now[i] + 2 + this.sEvent_eV1] << 1) + 1));
            }
            if(this.sIfElse != -1) {
                this.event_state = 1;
                this.gr.cur_a = this.sIfElse;
                this.my.state = 13;
                this.gr.action_str = null;
                this.sIfElse = -1;
                return;
            }
            this.gr.cur_a = 0;
            this.my.state = 12;
            return;
        }
        switch(this.my.state) {
            case 13: {
                this.sEvent_eV1 = (byte)(this.sEvent_eV1 + 2);
                this.event_now[i] = (short)(this.event_now[i] + (this.sEvent_eV1 + (this.sEvent_eV2 << 1) + ((short)((this.event[i][this.event_now[i] + this.sEvent_eV1 + (this.gr.cur_a << 1)] & 0xFF) << 8 | this.event[i][this.event_now[i] + this.sEvent_eV1 + (this.gr.cur_a << 1) + 1] & 0xFF))));
                this.nextEvent(17);
                return;
            }
            case 14: {
                this.setEventNow(i, true);
            }
        }
    }

    private void runEvent_srcMove(int i) {
        int y;
        int x;
        this.my.state = 10;
        int event_temp = this.event[i][this.event_now[i] + 2] - 1;
        if(event_temp == -1) {
            x = this.my.getIx();
            y = this.my.getIy();
            this.srcNpcNo = -1;
        }
        else {
            this.now_eV1 = this.getNpcLayer(event_temp);
            this.now_eV2 = this.getNpcId(event_temp);
            this.srcNpcNo = this.now_eV1 == 0 ? this.now_eV2 : 0;
            x = this.npc[this.now_eV1][this.now_eV2].other[0];
            y = this.npc[this.now_eV1][this.now_eV2].other[1];
        }
        int x = this.map_set(x, ((int)this.cols), ((int)Constants_H.XCELLS), ((int)Constants_H.HALF_XCELLS), Constants_H.WIDTH, 20) - this.map_x;
        int y = this.map_set(y, ((int)this.rows), ((int)Constants_H.YCELLS), ((int)Constants_H.HALF_YCELLS), Constants_H.HEIGHT, 20) - this.map_y;
        Ms.i();
        if(Ms.abs(y) < 10) {
            Ms.i();
            if(Ms.abs(x) < 10) {
                this.event_now[i] = (short)(this.event_now[i] + 3);
                this.nextEvent(0x1010);
                return;
            }
        }
        Ms.i();
        if(Ms.abs(x) >= 10) {
            int v6 = this.map_x;
            Ms.i();
            this.map_x = v6 + x / Ms.abs(x) * 10;
        }
        Ms.i();
        if(Ms.abs(y) >= 10) {
            int v7 = this.map_y;
            Ms.i();
            this.map_y = v7 + y / Ms.abs(y) * 10;
        }
    }

    private void runMove() {
        if(this.my.ix != -1 || this.my.iy != -1) {
            this.runSeek(this.my, false);
        }
        else {
            this.runBoat();
        }
        this.oneMove(this.my, -1);
        for(int j = 0; j < 3; j = (byte)(j + 2)) {
            for(int i = 0; i < this.npc[j].length; i = (byte)(i + 1)) {
                switch(this.npc[j][i].other[4]) {
                    case 1: 
                    case 2: {
                        if(this.npc[j][i].other[8] >= 5) {
                            this.runAutoMoveNpc(this.npc[j][i], i);
                        }
                        else if(this.npc[j][i].ix != -1 || this.npc[j][i].iy != -1) {
                            this.runSeek(this.npc[j][i], true);
                        }
                        this.oneMove(this.npc[j][i], i);
                    }
                }
            }
        }
        this.insertNpc();
    }

    private void runNpcAniOne(Npc[] npc, int i) {
        int type = (byte)(npc[i].other[3] - 1);
        int id = npc[i].other[2];
        Ms.i();
        int action_id = (byte)Ms.abs(npc[i].other[7]);
        if(npc[i].now_action >= Map.npcSp[type][id].aLength(action_id)) {
            npc[i].now_action = 0;
            this.setlastA(npc, i);
        }
        Npc npc0 = npc[i];
        byte b = (byte)(npc0.now_time + 1);
        npc0.now_time = b;
        if(b >= Map.npcSp[type][id].action(action_id, ((int)npc[i].now_action), 1)) {
            Npc npc1 = npc[i];
            npc1.now_action = (byte)(npc1.now_action + 1);
            npc[i].now_time = 0;
        }
    }

    private void runSeek(Npc npc_, boolean b_who) {
        boolean bb;
        boolean bb = npc_.b_check;
        int x_ = (short)(npc_.ix * 20);
        int y_ = (short)(npc_.iy * 20);
        if(npc_.x == x_ && npc_.y == y_) {
            if(npc_.frame_c == -1) {
                npc_.iy = -1;
                npc_.ix = -1;
                if(b_who) {
                    npc_.setIxIy_npc();
                }
                else {
                    npc_.speed = this.getMySpeed();
                }
                if(npc_.bdir) {
                    npc_.other[7] = npc_.lastAction;
                    npc_.dir = npc_.lastAction >= 0 ? 3 : 4;
                    npc_.setLastAction(false, 0x7F);
                }
            }
        }
        else if(npc_.frame_c < 1) {
            if(!bb) {
                bb = npc_.y == y_;
            }
            else if(npc_.x != x_) {
                bb = true;
            }
            else {
                bb = false;
            }
            if(bb) {
                if(npc_.x > x_ && npc_.x - npc_.speed < x_ || npc_.x < x_ && npc_.x + npc_.speed > x_) {
                    npc_.setSpeedXY(x_ - npc_.x, 0);
                }
                else {
                    int v2 = npc_.x > x_ ? -npc_.speed : npc_.speed;
                    npc_.setSpeedXY(v2, 0);
                }
                if(!npc_.bdir) {
                    npc_.dir = npc_.x <= x_ ? 4 : 3;
                }
            }
            else {
                if(npc_.y > y_ && npc_.y - npc_.speed < y_ || npc_.y < y_ && npc_.y + npc_.speed > y_) {
                    npc_.setSpeedXY(0, y_ - npc_.y);
                }
                else {
                    int v3 = npc_.y > y_ ? -npc_.speed : npc_.speed;
                    npc_.setSpeedXY(0, v3);
                }
                if(!npc_.bdir) {
                    npc_.dir = npc_.y <= y_ ? 2 : 1;
                }
            }
            npc_.frame_c = npc_.frame_num;
            npc_.setActionNo(true);
        }
    }

    public void run_map() {
        if(this.my.state != 6 && this.my.state != 9) {
            this.eventCheck();
        }
        if(this.my.state == 5 && this.my.frame_c < 1) {
            this.setMoveStop_m();
            this.my.state = 6;
        }
        switch(this.my.state) {
            case 2: {
                if(this.eventGoing == 0) {
                    switch(this.npc[0][this.get_meet].other[4]) {
                        case 1: 
                        case 3: {
                            if(this.npc[0][this.get_meet].other[5] > 0) {
                                this.npcName = this.npcNameData[this.get_meet];
                                if(this.npcName.equals("路人")) {
                                    this.npcName = null;
                                }
                                this.initNpcFaceOne(this.npcName);
                                Ms.i();
                                Ms.font.setSize(22);
                                this.dialog = Ms.i().groupString(this.npcStringData[this.npc[0][this.get_meet].other[5] - 1], Constants_H.WIDTH__ - 20);
                                if(!this.fontSizeControl) {
                                    Ms.i();
                                    Ms.font.setSize(26);
                                }
                                this.dialog_no = 0;
                                this.my.state = 1;
                            }
                            else {
                                this.my.state = 0;
                            }
                            break;
                        }
                        default: {
                            this.my.state = 0;
                        }
                    }
                }
                else {
                label_30:
                    if(this.my.state == 8 && this.my.frame_c == -1) {
                        if(this.gr.immueEnemy == 0) {
                            Log.e("sk", "gr.immueEnemy==0");
                            GameRun gameRun0 = this.gr;
                            String[] arr_s = this.gr.battleSay;
                            Ms.i();
                            gameRun0.say(arr_s[Ms.getRandom(3)], 0);
                            GameRun.mc.repaint();
                            this.gr.battleType(4);
                            this.gr.goBattlePVC();
                        }
                        else {
                            this.my.state = 0;
                        }
                    }
                }
                break;
            }
            case 6: {
                this.gr.createOver = 1;
                this.goNextMap();
                return;
            }
            default: {
                goto label_30;
            }
        }
        this.runMove();
    }

    public void save() {
        this.map_saveGame();
        this.saveNpc();
        for(int i = 0; i < this.mapInfo.length / 2; ++i) {
            if(this.mapChange[i] == 1) {
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
        byte[][] arr2_b = this.mapTemp;
        int v = this.mapNo;
        arr2_b[v] = this.getNpcData();
        this.mapInfo[this.mapNo * 2] = 1;
        this.mapChange[this.mapNo] = 1;
    }

    public void setAnole() {
        this.gr.immueEnemy = (byte)(this.anole_type == 3 ? 1 : 0);
        this.my.speed = this.getMySpeed();
        Ms.i().setSprite(Map.npcSp[1][0], "data/npc1/" + (this.anole_type == -1 ? "0" : "r" + ((int)this.anole_type)), this.anole_type == -1);
        this.my.setActionNo(false);
    }

    private void setEventNow(int i, boolean bb) {
        if(bb) {
            this.my.state = 0;
        }
        this.now_eV1 = 0;
        this.now_eV2 = 0;
        this.eventGoing = 0;
        this.event_now[i] = 0;
    }

    private void setMapData() {
        this.map_x = this.map_set(this.my.getIx(), ((int)this.cols), ((int)Constants_H.XCELLS), ((int)Constants_H.HALF_XCELLS), Constants_H.WIDTH, 20);
        this.map_y = this.map_set(this.my.getIy(), ((int)this.rows), ((int)Constants_H.YCELLS), ((int)Constants_H.HALF_YCELLS), Constants_H.HEIGHT, 20);
        this.mapLeft_NOmove = (short)(Constants_H.WIDTH_H - 10);
        this.mapRight_NOmove = (short)(this.cols * 20 - Constants_H.WIDTH_H - 10);
        this.mapUp_NOmove = (short)(Constants_H.HEIGHT_H - 10);
        this.mapDown_NOmove = (short)(this.rows * 20 - Constants_H.HEIGHT_H - 10);
    }

    public void setMapMusic(boolean bb) {
        Sound.i().setMusicId(((int)this.gr.musicNo[this.mapNo]));
        Sound.i().setMusic(bb);
    }

    private void setMapOffer() {
        if(this.map_y + this.rows * 20 < Constants_H.HEIGHT && this.rows > Constants_H.YCELLS) {
            this.map_y = Constants_H.HEIGHT - this.rows * 20;
            return;
        }
        if(this.map_y > 0 && this.rows > Constants_H.YCELLS) {
            this.map_y = 0;
            return;
        }
        if(this.map_x > 0 && this.cols > Constants_H.XCELLS) {
            this.map_x = 0;
            return;
        }
        if(this.map_x + this.cols * 20 < Constants_H.WIDTH && this.cols > Constants_H.XCELLS) {
            this.map_x = Constants_H.WIDTH - this.cols * 20;
        }
    }

    public void setMission(int id, boolean bb) {
        if(bb) {
            this.bMission[((byte)(id / 8))] = (byte)(this.bMission[((byte)(id / 8))] | 1 << ((byte)(id % 8)));
            return;
        }
        if((this.bMission[((byte)(id / 8))] & 1 << ((byte)(id % 8))) != 0) {
            this.bMission[((byte)(id / 8))] = (byte)(this.bMission[((byte)(id / 8))] ^ 1 << ((byte)(id % 8)));
            this.bMission[15] = (byte)(this.bMission[15] + 1);
        }
    }

    private void setMoveStop_m() {
        this.my.speed_x = 0;
        this.my.speed_y = 0;
        this.my.frame_c = -1;
        this.my.setActionNo(false);
    }

    public void setNull() {
        this.npc[0] = null;
        this.item = null;
        this.door = null;
        this.event = null;
        this.mapImg = null;
        this.moduleData = null;
    }

    public void setOverEvent(int map, int id) {
        if(!this.isMapEvent(map, id)) {
            int v2 = map * 2 + 1;
            this.mapInfo[v2] = (short)(this.mapInfo[v2] | 1 << id);
        }
        if(map == this.mapNo) {
            this.event_now[id] = 0x5EA0;
            return;
        }
        if(this.event_now_list[map] != null) {
            this.event_now_list[map][id] = 0x5EA0;
        }
    }

    public void setRegState(boolean isSuccess) {
        synchronized(this) {
            System.out.println("setRegState() notifyAll start isSuccess= " + isSuccess);
            this.isNeedWait = false;
            this.notifyAll();
            System.out.println("setRegState() notifyAll over");
        }
    }

    public void setRestEvent(int map, int id) {
        if(this.isMapEvent(map, id)) {
            int v2 = map * 2 + 1;
            this.mapInfo[v2] = (short)(this.mapInfo[v2] ^ 1 << id);
        }
        if(map == this.mapNo) {
            this.event_now[id] = 0;
            return;
        }
        if(this.event_now_list[map] != null) {
            this.event_now_list[map][id] = 0;
        }
    }

    private boolean setSIfElse(int _mode, boolean _bt, boolean _bmode) {
        if(_mode == 2) {
            this.sIfElse = (byte)(_bt ? 0 : 1);
            return true;
        }
        return !_bmode || !_bt ? !_bmode && _mode == 1 : true;
    }

    public void setTempNull() {
        this.mapTemp = null;
        this.mapTemp = new byte[70][];
    }

    public void setfmap() {
        this.fmap = 0;
    }

    private boolean setlastA(Npc[] npc, int i) {
        if(npc[i].lastAction != 0x7F) {
            npc[i].other[7] = npc[i].lastAction;
            npc[i].lastAction = 0x7F;
            return true;
        }
        return false;
    }

    private void turnAround(int dir) {
        this.my.dir = (byte)dir;
        this.my.setActionNo(true);
    }
}

