package main;

import android.util.Log;
import dm.Ms;
import dm.Npc;
import dm.Sound;
import dm.Sprite;
import dm.Ui;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.media.Player;

/* loaded from: classes.dex */
public class Map implements Key_H {
    private static Npc cur_npc;
    private static Graphics g;
    static Sprite[][] npcSp = new Sprite[3];
    private byte action_5;
    public byte[] bMission;
    public short black_0;
    public short black_1;
    private short black_width;
    public byte[][] boatCourse;
    Sprite brow;
    byte checkType;
    private short[][] cloud;
    private short cols;
    public StringBuffer[] dialog;
    private byte[][] door;
    private byte[][] event;
    private int eventCount;
    public byte eventGoing;
    public short[] event_now;
    public short[][] event_now_list;
    public String fString;
    boolean fontSizeControl;
    private byte get_meet;
    public GameRun gr;
    private Image hudong;
    private Image imgCloud;
    public Image imgShadow;
    private byte[][] item;
    private byte lastExit;
    private byte lastMap;
    private short leftCol;
    public byte[] mDirect;
    private byte[] mapChange;
    private short mapDown_NOmove;
    public short[] mapInfo;
    private short mapLeft_NOmove;
    private short mapRight_NOmove;
    private short mapUp_NOmove;
    public byte map_key;
    public int map_x;
    public int map_y;
    private byte[][] mapdataArea;
    private byte[][] mapdataMap;
    private short mapoffx;
    private short mapoffy;
    private short meet_step;
    public Npc my;
    private byte myMiniMap;
    private byte now_eV1;
    private byte now_eV2;
    private byte[] npcList;
    private String npcName;
    private String[] npcNameData;
    private byte[] npcPos;
    private String[] npcStringData;
    public PointerKey pkey;
    private short rows;
    public byte sEvent_eV1;
    public byte sEvent_eV2;
    private StringBuffer[][] sMission;
    private byte selectMap;
    public int smissionLength;
    private byte time_5;
    private short topRow;
    public Image[] walkIco;
    public Npc[][] npc = new Npc[3];
    private byte srcNpcNo = -1;
    private byte sleep_count = 0;
    private short step_MEET = 4;
    private byte event_state = 0;
    private byte[][] mapTemp = new byte[70];
    public byte anole_temp = -1;
    public byte anole_type = -1;
    public byte mapNo = 0;
    public byte inShop = 0;
    public byte notMeet = 0;
    public byte dialog_no = -1;
    private byte bStep = -1;
    private byte go = -2;
    boolean bExitBoss = false;
    byte mapNotemp = 0;
    public byte fmap = -1;
    public byte sIfElse = -1;
    public boolean gmErr = false;
    private byte xxx = 0;
    int i = 0;
    int ii = 0;
    public byte[][] dir_select = {new byte[2], new byte[]{0, -1}, new byte[]{0, 1}, new byte[]{-1}, new byte[]{1}};
    private byte anoleSel = 0;
    public byte npcDirTalk = -1;
    public boolean bDirTalk = false;
    byte checkNpcT = -1;
    private byte roadType = 0;
    private boolean miniMapMode = false;
    private byte showArea = -1;
    private short littleMapClipY = 300;
    private boolean bPause = false;
    short[][] moduleData = null;
    Image[] mapImg = null;
    int bgColor = 0;
    short[] bottomData = null;
    short[] frontData = null;
    short[][] worldData = null;
    public byte firstDrawMap = 0;
    int map_left = 0;
    int map_top = 0;
    int map_right = 0;
    int map_bottom = 0;
    int rightCol = 0;
    int bottomRow = 0;
    private Image imgFace = null;
    private boolean faceDir = false;
    private byte faceLast = -1;
    private short face_c = 0;
    private short bSrc_c = 0;
    private boolean bSrc = false;
    private byte srcFlash_c = 0;
    public byte boatSelect = -1;
    private boolean isNeedWait = true;

    public void setTempNull() {
        this.mapTemp = null;
        this.mapTemp = new byte[70];
    }

    public void notMeet(int kind, int id) {
        if (kind == 0) {
            this.notMeet = (byte) 0;
            Ms.i();
            this.step_MEET = (short) (Ms.getRandom(30) + 1);
            this.meet_step = (short) ((this.step_MEET - 15) * (this.step_MEET - 15));
            short s = this.meet_step;
            Ms.i();
            if (s > Ms.getRandom(50)) {
                Ms.i();
                int random = Ms.getRandom(9) + 17;
                Ms.i();
                this.step_MEET = (byte) (random - Ms.getRandom(7));
            }
            this.step_MEET = (short) (this.step_MEET << 2);
            this.meet_step = (short) 0;
            this.bStep = (byte) -1;
            return;
        }
        if (kind == 1) {
            this.notMeet = (byte) 1;
            this.step_MEET = (short) (((id - 14) + 1) * Player.REALIZED);
            this.step_MEET = (short) (this.step_MEET << 2);
            this.meet_step = (short) 0;
            this.bStep = (byte) 100;
        }
    }

    public Map(GameRun gameRun) {
        this.gr = gameRun;
        System.gc();
        init();
    }

    public void createNpcString() {
        this.npcNameData = Ms.i().loadText(initData(this.gr.createData(1), this.mapNo));
        this.npcStringData = Ms.i().loadText(initData(this.gr.createData(2), this.mapNo));
    }

    public void loadDate_Rms() {
        byte[] info = Ms.i().rmsOptions(2, null, 1);
        if (info[0] == -1) {
            byte[] one = new byte[16];
            one[0] = Constants_H.f27;
            one[1] = 9;
            one[2] = 16;
            one[3] = 2;
            one[5] = 1;
            one[6] = 2;
            one[15] = -1;
            info = one;
            Ms.i().rmsOptions(2, one, 2);
            this.event_now_list = new short[70];
            Ms.i().rmsOptions(12, Ms.i().getEventNowData(this.event_now_list), 2);
        } else {
            this.event_now_list = Ms.i().readEventNowData();
        }
        this.mapNo = info[0];
        this.lastMap = info[5];
        this.lastExit = info[6];
        this.my.setXY(info[1], info[2], 0, 0);
        this.my.dir = info[3];
        this.my.setActionNo(false);
        this.gr.money = Ms.i().getInt(info, 7);
        this.gr.coin = Ms.i().getInt(info, 11);
        this.anole_type = info[15];
    }

    public void map_saveGame() {
        byte[] info = new byte[16];
        info[0] = this.mapNo;
        info[5] = this.lastMap;
        info[6] = this.lastExit;
        info[1] = (byte) (this.my.x / 20);
        info[2] = (byte) (this.my.y / 20);
        info[3] = this.my.dir;
        Ms.i().putInt(this.gr.money, info, 7);
        Ms.i().putInt(this.gr.coin, info, 11);
        info[15] = this.anole_type;
        Ms.i().rmsOptions(2, info, 2);
    }

    public void save() {
        map_saveGame();
        saveNpc();
        for (int i = 0; i < this.mapInfo.length / 2; i++) {
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

    public byte[] initData(byte[] tempdata, int n) {
        int i = 0;
        int len = 1;
        while (i < n) {
            int len2 = len + 1;
            int temp = ((tempdata[len] & 255) << 8) | (tempdata[len2] & 255);
            i++;
            len = len2 + 1 + temp;
        }
        int len3 = len + 1;
        int temp2 = ((tempdata[len] & 255) << 8) | (tempdata[len3] & 255);
        byte[] data = new byte[temp2];
        System.arraycopy(tempdata, len3 + 1, data, 0, data.length);
        return data;
    }

    public void createEvent() {
        byte[] data = Ms.i().getStream("event", this.mapNo);
        if (data.length == 1) {
            this.eventCount = 0;
            return;
        }
        int start_pos = 0 + 1;
        this.eventCount = data[0];
        if (this.mapInfo[this.mapNo * 2] < 1) {
            this.event_now_list[this.mapNo] = null;
            this.event_now_list[this.mapNo] = new short[this.eventCount];
        } else {
            for (byte i = 0; i < this.eventCount; i = (byte) (i + 1)) {
                if (isMapEvent(this.mapNo, i)) {
                    this.event_now_list[this.mapNo][i] = 24224;
                }
            }
        }
        this.event_now = this.event_now_list[this.mapNo];
        this.event = new byte[this.eventCount];
        int start_pos2 = start_pos;
        for (byte i2 = 0; i2 < this.eventCount; i2 = (byte) (i2 + 1)) {
            int start_pos3 = start_pos2 + 1;
            int i3 = data[start_pos2] << 8;
            int start_pos4 = start_pos3 + 1;
            int i4 = (short) (i3 | (data[start_pos3] & 255));
            this.event[i2] = new byte[i4];
            System.arraycopy(data, start_pos4, this.event[i2], 0, this.event[i2].length);
            start_pos2 = start_pos4 + i4;
        }
    }

    private void init() {
        initBrowImage();
        initWalkIco();
        initHudong();
        configureNpc();
        if (npcSp[1][0] == null) {
            npcSp[1][0] = new Sprite();
            this.my = new Npc(8);
            this.my.other[4] = 1;
            setAnole();
        }
        if (this.imgShadow == null) {
            this.imgShadow = Ms.i().createImage("data/shadow");
        }
    }

    private void configureNpc() {
        npcSp[0] = new Sprite[100];
        npcSp[1] = new Sprite[5];
        npcSp[2] = new Sprite[60];
    }

    public void initMap() {
        this.my.dir = (byte) 4;
        this.srcNpcNo = (byte) -1;
        this.gr.loadRmsSms();
        this.gr.loadRmsNidus();
        notMeet(0, 0);
        this.mapInfo = Ms.i().byteArrayToShortArray(Ms.i().rmsOptions(13, null, 1));
        this.mapChange = Ms.i().rmsOptions(1, null, 1);
        for (short i = 0; i < this.mapChange.length; i = (short) (i + 1)) {
            if (this.mapChange[i] == 1) {
                this.mapTemp[i] = Ms.i().rmsOptions(i + 14, null, 1);
            }
        }
        System.gc();
        this.gr.createOver = (byte) 33;
        createOther();
        this.gr.createOver = (byte) 35;
        createLayer();
        this.gr.createOver = Constants_H.f78;
        createEvent();
        this.gr.createOver = Constants_H.f33;
        createNpcString();
        this.gr.createOver = (byte) 40;
        Ms.i().rmsOptions(1, null, 4);
        this.gr.initMonPro(this.mapNo, true);
        initMissionList();
        initCloud();
    }

    public void createOther() {
        Ms.i();
        Ms.skip = 0;
        Ms.i();
        Ms.skip2 = 0;
        byte[] Datas = initData(this.gr.createData(0), this.mapNo);
        this.npcPos = createNpcPos(Datas, this.npcPos);
        if (this.mapInfo[this.mapNo * 2] > 0 && this.mapTemp[this.mapNo] == null) {
            this.mapTemp[this.mapNo] = Ms.i().rmsOptions(this.mapNo + 14, null, 1);
        }
        this.npc[0] = createNpc(Datas, this.npc[0]);
        this.npc[1] = createNpc(Datas, this.npc[1]);
        this.npc[2] = createNpc(Datas, this.npc[2]);
        this.item = createItem(Datas, this.item);
        this.door = createItem(Datas, this.door);
        this.npcList = null;
        this.npcList = new byte[this.npc[0].length + 1 + this.item.length];
        initNpcAni();
    }

    Npc[] createNpc(byte[] bArr, Npc[] npc) {
        Ms.i();
        int i = Ms.skip;
        Ms.skip = i + 1;
        Npc[] npc2 = new Npc[bArr[i]];
        for (int i2 = 0; i2 < npc2.length; i2++) {
            Ms.i();
            int i3 = Ms.skip;
            Ms.skip = i3 + 1;
            npc2[i2] = new Npc(bArr[i3]);
            for (int j = 0; j < npc2[i2].other.length; j++) {
                byte[] bArr2 = npc2[i2].other;
                Ms.i();
                int i4 = Ms.skip;
                Ms.skip = i4 + 1;
                bArr2[j] = bArr[i4];
            }
            npc2[i2].setXY_npc();
        }
        if (this.mapInfo[this.mapNo * 2] > 0) {
            for (int i5 = 0; i5 < npc2.length; i5++) {
                if (npc2[i5].other[9] == 1) {
                    for (int j2 = 0; j2 < npc2[i5].other.length; j2++) {
                        byte[] bArr3 = npc2[i5].other;
                        byte[] bArr4 = this.mapTemp[this.mapNo];
                        Ms.i();
                        int i6 = Ms.skip2;
                        Ms.skip2 = i6 + 1;
                        bArr3[j2] = bArr4[i6];
                    }
                    npc2[i5].setXY_npc();
                }
            }
        }
        return npc2;
    }

    byte[][] createItem(byte[] bArr, byte[][] npc) {
        byte[][] bArr2;
        if (this.mapInfo[this.mapNo * 2] > 0) {
            byte[] bArr3 = this.mapTemp[this.mapNo];
            Ms.i();
            int i = Ms.skip2;
            Ms.skip2 = i + 1;
            bArr2 = new byte[bArr3[i]];
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                Ms.i();
                int i3 = Ms.skip2;
                Ms.skip2 = i3 + 1;
                bArr2[i2] = new byte[bArr3[i3]];
                for (int j = 0; j < bArr2[i2].length; j++) {
                    byte[] bArr4 = bArr2[i2];
                    Ms.i();
                    int i4 = Ms.skip2;
                    Ms.skip2 = i4 + 1;
                    bArr4[j] = bArr3[i4];
                }
            }
        } else {
            Ms.i();
            int i5 = Ms.skip;
            Ms.skip = i5 + 1;
            bArr2 = new byte[bArr[i5]];
            for (int i6 = 0; i6 < bArr2.length; i6++) {
                Ms.i();
                int i7 = Ms.skip;
                Ms.skip = i7 + 1;
                bArr2[i6] = new byte[bArr[i7]];
                for (int j2 = 0; j2 < bArr2[i6].length; j2++) {
                    byte[] bArr5 = bArr2[i6];
                    Ms.i();
                    int i8 = Ms.skip;
                    Ms.skip = i8 + 1;
                    bArr5[j2] = bArr[i8];
                }
            }
        }
        return bArr2;
    }

    private byte getNpcLayer(int i) {
        return (byte) ((this.npcPos[i] & 255) >> 6);
    }

    private byte getNpcId(int i) {
        return (byte) (this.npcPos[i] & 63);
    }

    public byte[] createNpcPos(byte[] bArr, byte[] npc) {
        Ms.i();
        int i = Ms.skip;
        Ms.skip = i + 1;
        byte[] bArr2 = new byte[bArr[i]];
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            Ms.i();
            int i3 = Ms.skip;
            Ms.skip = i3 + 1;
            bArr2[i2] = bArr[i3];
        }
        return bArr2;
    }

    public void saveNpc() {
        this.mapTemp[this.mapNo] = null;
        this.mapTemp[this.mapNo] = getNpcData();
        this.mapInfo[this.mapNo * 2] = 1;
        this.mapChange[this.mapNo] = 1;
    }

    private void setMapData() {
        this.map_x = map_set(this.my.getIx(), this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20);
        this.map_y = map_set(this.my.getIy(), this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20);
        this.mapLeft_NOmove = (short) (Constants_H.WIDTH_H - 10);
        this.mapRight_NOmove = (short) (((this.cols * 20) - Constants_H.WIDTH_H) - 10);
        this.mapUp_NOmove = (short) (Constants_H.HEIGHT_H - 10);
        this.mapDown_NOmove = (short) (((this.rows * 20) - Constants_H.HEIGHT_H) - 10);
    }

    public void createLayer() {
        createMap();
        setMapData();
    }

    public byte exitMap(byte[][] door) {
        if (door[this.get_meet][3] == -1) {
            byte go = this.mapNo;
            this.mapNo = this.lastMap;
            this.lastMap = go;
            this.lastExit = this.get_meet;
            return (byte) -1;
        }
        byte go2 = this.mapNo;
        this.mapNo = door[this.get_meet][4];
        this.lastMap = go2;
        this.lastExit = this.get_meet;
        byte go3 = door[this.get_meet][3];
        return go3;
    }

    public void saveMapBak() {
        saveNpc();
        this.mapChange[this.mapNo] = 1;
        Ms.i().rmsOptions(1, this.mapChange, 2);
    }

    public void goNextMap() {
        setfmap();
        this.firstDrawMap = (byte) 0;
        this.gr.doPaint(2);
        saveMapBak();
        byte exit_b = this.lastExit;
        if (this.go != -2) {
            this.lastMap = this.mapNo;
            this.mapNo = this.mapNotemp;
            this.mapNotemp = (byte) 0;
            this.lastExit = this.go;
        }
        this.gr.doPaint(5);
        if (this.go == -2) {
            this.go = exitMap(this.door);
        }
        this.gr.setNull(false);
        this.gr.doPaint(8);
        createOther();
        this.gr.doPaint(10);
        if (this.go == -1) {
            this.go = exit_b;
        }
        if (!this.bExitBoss) {
            getInMap(this.go, this.door);
        }
        createEvent();
        this.gr.doPaint(15);
        createNpcString();
        createLayer();
        this.gr.doPaint(20);
        if (!this.bExitBoss && (this.door[this.go][5] == 1 || this.door[this.go][5] == 2)) {
            this.my.frame_c = (byte) (20 / this.my.speed);
            this.my.speed_x = (byte) (this.dir_select[this.my.dir][0] * this.my.speed);
            this.my.speed_y = (byte) (this.dir_select[this.my.dir][1] * this.my.speed);
            this.my.setActionNo(true);
        } else {
            this.my.setActionNo(false);
        }
        this.gr.b_c = (byte) 0;
        setMapMusic(false);
        this.go = (byte) -2;
        this.gr.initMonPro(this.mapNo, true);
        this.gr.cityName_c = (byte) 25;
        this.srcNpcNo = (byte) -1;
        Ms.i().rmsOptions(1, null, 4);
        initCloud();
        this.bExitBoss = false;
        this.my.state = (byte) 9;
        if (this.boatSelect == -1) {
            this.my.state = (byte) 0;
            this.my.setIXY(-1, -1);
            this.my.speed = getMySpeed();
        }
        this.checkNpcT = (byte) -1;
        this.pkey.stopMove();
    }

    private void exitBoss(int map_No, int zuobiao_x, int zuobiao_y, int mydir) {
        chuansong(map_No, 0);
        this.bExitBoss = true;
        this.my.setXY(zuobiao_x, zuobiao_y, 0, 0);
        this.my.dir = (byte) mydir;
    }

    public void chuansong(int mapno, int door) {
        this.my.state = (byte) 5;
        this.mapNotemp = (byte) mapno;
        this.go = (byte) door;
        setMoveStop_m();
    }

    public void setfmap() {
        this.fmap = (byte) 0;
    }

    private void getInMap(byte exit_no, byte[][] door) {
        this.my.dir = (byte) ((((door[exit_no][2] - 1) / 2) * 2) + 1 + (door[exit_no][2] % 2));
        this.my.setXY(door[exit_no][0], door[exit_no][1], 0, 0);
    }

    private int map_set(int _my_x, int cols, int xcells, int half_xcells, int show_width, int cell_width) {
        if (cols <= xcells) {
            int map_x = (show_width - (cell_width * cols)) >> 1;
            return map_x;
        }
        if (_my_x + 1 <= half_xcells) {
            return 0;
        }
        if (_my_x >= cols - half_xcells) {
            int map_x2 = show_width - (cols * cell_width);
            return map_x2;
        }
        int map_x3 = ((show_width / 2) - (_my_x * cell_width)) - (cell_width / 2);
        return map_x3;
    }

    private boolean setSIfElse(int _mode, boolean _bt, boolean _bmode) {
        if (_mode == 2) {
            this.sIfElse = (byte) (_bt ? 0 : 1);
            return true;
        }
        if (_bmode && _bt) {
            return true;
        }
        return !_bmode && _mode == 1;
    }

    private void ifEvent(int i, int next_id, int next_mode, int mode, boolean bt) {
        if (setSIfElse(mode, bt, true)) {
            short[] sArr = this.event_now;
            sArr[i] = (short) (sArr[i] + next_id);
            nextEvent(next_mode);
        } else if (setSIfElse(mode, bt, false)) {
            setEventNow(i, false);
        }
    }

    private boolean isMapEvent(int _mapNo, int _i) {
        return (this.mapInfo[(_mapNo * 2) + 1] & (1 << _i)) != 0;
    }

    public void setRestEvent(int map, int id) {
        if (isMapEvent(map, id)) {
            short[] sArr = this.mapInfo;
            int i = (map * 2) + 1;
            sArr[i] = (short) (sArr[i] ^ (1 << id));
        }
        if (map != this.mapNo) {
            if (this.event_now_list[map] != null) {
                this.event_now_list[map][id] = 0;
                return;
            }
            return;
        }
        this.event_now[id] = 0;
    }

    public void setOverEvent(int map, int id) {
        if (!isMapEvent(map, id)) {
            short[] sArr = this.mapInfo;
            int i = (map * 2) + 1;
            sArr[i] = (short) (sArr[i] | (1 << id));
        }
        if (map != this.mapNo) {
            if (this.event_now_list[map] != null) {
                this.event_now_list[map][id] = 24224;
                return;
            }
            return;
        }
        this.event_now[id] = 24224;
    }

    private void setEventNow(int i, boolean bb) {
        if (bb) {
            this.my.state = (byte) 0;
        }
        this.now_eV1 = (byte) 0;
        this.now_eV2 = (byte) 0;
        this.eventGoing = (byte) 0;
        this.event_now[i] = 0;
    }

    private void nextEvent(int mode) {
        if ((mode & GameCanvas.GAME_D_PRESSED) != 0) {
            this.now_eV1 = (byte) 0;
            this.now_eV2 = (byte) 0;
        }
        if ((mode & GameCanvas.FIRE_PRESSED) != 0) {
            this.eventGoing = (byte) 0;
        }
        if ((mode & 16) != 0) {
            this.event_state = (byte) 1;
        }
        if ((mode & 1) != 0) {
            this.my.state = (byte) 0;
        }
        this.pkey.initPointer();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:263)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public void eventCheck() {
        /*
            Method dump skipped, instructions count: 5420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: main.Map.eventCheck():void");
    }

    private void runEvent_getMon(int i) {
        this.gmErr = false;
        if (this.gr.getMonster(this.event[i][this.event_now[i] + 2], this.event[i][this.event_now[i] + 3], this.event[i][this.event_now[i] + 4], -1) == -1) {
            this.gr.say(Constants_H.TXT_105, -1);
            this.gmErr = true;
            this.gr.mini_state = (byte) 6;
            this.gr.view_state = (byte) 1;
            this.gr.goVIEW_MONSTER();
            return;
        }
        short[] sArr = this.event_now;
        sArr[i] = (short) (sArr[i] + this.event[i][this.event_now[i] + 1] + 2);
        nextEvent(4368);
    }

    public void bkEvent_getMon() {
        GameRun.run_state = -10;
    }

    private void runEvent_brow(int i) {
        int event_temp = this.event[i][this.event_now[i] + 2] - 1;
        if (event_temp == -1) {
            cur_npc = this.my;
        } else {
            cur_npc = this.npc[getNpcLayer(event_temp)][getNpcId(event_temp)];
        }
        if (this.event[i][this.event_now[i] + 4] == 0) {
            cur_npc.brow_type = this.event[i][this.event_now[i] + 3];
            cur_npc.brow_action = (byte) 0;
            cur_npc.brow_time = (byte) 0;
        } else if (this.event[i][this.event_now[i] + 4] == 1) {
            cur_npc.other[6] = this.event[i][this.event_now[i] + 3];
        } else if (this.event[i][this.event_now[i] + 4] == 2) {
            cur_npc.brow_type = (byte) -1;
            cur_npc.other[6] = 0;
        }
        short[] sArr = this.event_now;
        sArr[i] = (short) (sArr[i] + 5);
        nextEvent(4112);
    }

    private void runEvent_srcMove(int i) {
        int x;
        int y;
        this.my.state = (byte) 10;
        int event_temp = this.event[i][this.event_now[i] + 2] - 1;
        if (event_temp == -1) {
            x = this.my.getIx();
            y = this.my.getIy();
            this.srcNpcNo = (byte) -1;
        } else {
            this.now_eV1 = getNpcLayer(event_temp);
            this.now_eV2 = getNpcId(event_temp);
            this.srcNpcNo = this.now_eV1 == 0 ? this.now_eV2 : (byte) 0;
            Npc[][] npcArr = this.npc;
            int x2 = this.now_eV1;
            x = npcArr[x2][this.now_eV2].other[0];
            y = this.npc[this.now_eV1][this.now_eV2].other[1];
        }
        int map_set = map_set(x, this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20);
        int x3 = this.map_x;
        int x4 = map_set - x3;
        int y2 = map_set(y, this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20) - this.map_y;
        Ms.i();
        if (Ms.abs(y2) < 10) {
            Ms.i();
            if (Ms.abs(x4) < 10) {
                short[] sArr = this.event_now;
                int x5 = sArr[i] + 3;
                sArr[i] = (short) x5;
                nextEvent(4112);
                return;
            }
        }
        Ms.i();
        if (Ms.abs(x4) >= 10) {
            int i2 = this.map_x;
            Ms.i();
            this.map_x = i2 + ((x4 / Ms.abs(x4)) * 10);
        }
        Ms.i();
        if (Ms.abs(y2) >= 10) {
            int i3 = this.map_y;
            Ms.i();
            this.map_y = i3 + ((y2 / Ms.abs(y2)) * 10);
        }
    }

    private void runEvent_goShop(int i) {
        int event_temp = this.event[i][this.event_now[i] + 3];
        if (event_temp == 4) {
            if (this.inShop == 0 && this.my.state != 16) {
                this.my.state = (byte) 16;
                this.inShop = (byte) 1;
                this.gr.setAction_str(new String[]{Constants_H.POP_TXT_11, Constants_H.POP_TXT_10});
                this.gr.popMenu = (byte) 0;
                this.gr.sell_money = 0;
                for (byte d = 0; d < this.gr.myMon_length; d = (byte) (d + 1)) {
                    this.gr.sell_money += (this.gr.myMonsters[d].monster[4] * 20) + 40;
                }
                return;
            }
            if (this.my.state == 0) {
                if (this.inShop == 1 && this.gr.popMenu == 0) {
                    this.inShop = (byte) 2;
                    if (!this.gr.checkMonster() && this.gr.isMoney(this.gr.sell_money, true)) {
                        this.gr.healMonster(true);
                        return;
                    }
                    return;
                }
                if (this.gr.say_c == 0) {
                    this.inShop = (byte) 0;
                    short[] sArr = this.event_now;
                    sArr[i] = (short) (sArr[i] + 4);
                    nextEvent(0);
                    return;
                }
                return;
            }
            return;
        }
        if (event_temp < 3) {
            this.gr.goBUY_ITEM(this.event[i][this.event_now[i] + 2], event_temp);
        } else if (event_temp == 3) {
            this.gr.goVIEW_COMPUTER(0);
        } else if (event_temp == 5) {
            this.gr.goNidus(0);
        } else if (event_temp == 6) {
            this.gr.view_state = (byte) 4;
            this.gr.popMenu = (byte) -1;
        } else if (event_temp == 7) {
            this.gr.view_state = (byte) 1;
        }
        short[] sArr2 = this.event_now;
        sArr2[i] = (short) (sArr2[i] + 4);
        nextEvent(16);
    }

    private void runEvent_miniGame_myLevel(int i) {
        int event_temp = this.event[i][this.event_now[i] + 2];
        if (event_temp > 1) {
            short[] sArr = this.event_now;
            sArr[i] = (short) (sArr[i] + 3);
            nextEvent(4368);
            return;
        }
        if (this.eventGoing < 2) {
            if (event_temp == 0) {
                if (this.gr.magic_id == -2) {
                    if (this.gr.rmsOther[3] == 5) {
                        this.gr.magic_id = (byte) -2;
                        this.eventGoing = (byte) 2;
                        this.gr.say(Constants_H.LEVEL_TXT_0, 0);
                        return;
                    }
                    this.gr.sell_money = this.gr.isMyLevel(true);
                    if (this.gr.sell_money == -1) {
                        this.my.state = (byte) 10;
                        this.gr.magic_id = (byte) 28;
                        this.gr.magic_x = this.map_x + this.my.x + 10;
                        this.gr.magic_y = this.map_y + this.my.y + 19;
                        this.gr.setMagic(this.gr.magic_id / 5);
                        this.gr.setMaxTakes(false);
                        return;
                    }
                    this.eventGoing = (byte) 2;
                    return;
                }
                if (this.gr.magic_id == -1) {
                    this.gr.magic_id = (byte) -2;
                    this.eventGoing = (byte) 2;
                    this.gr.say(Constants_H.LEVEL_TXT_8 + ((int) this.gr.rmsOther[3]) + Constants_H.LEVEL_TXT_9 + ((int) this.gr.max_takes) + Constants_H.LEVEL_TXT_10 + ((int) this.gr.max_monsters), -1);
                    return;
                }
                return;
            }
            if (event_temp == 1) {
                if (this.eventGoing == 0 && this.gr.monInfoList[104] == 0) {
                    this.gr.sell_money = 0;
                    this.eventGoing = (byte) 3;
                    this.gr.say(Constants_H.LEVEL_TXT_4, -1);
                    return;
                } else {
                    if (this.eventGoing == 0) {
                        this.eventGoing = (byte) 3;
                        this.gr.sell_money = this.gr.monInfoList[104];
                        this.gr.monInfoList[104] = 0;
                        this.gr.say(Constants_H.LEVEL_TXT_5 + this.gr.sell_money + Constants_H.LEVEL_TXT_6 + this.gr.sell_money + Constants_H.LEVEL_TXT_7, -1);
                        this.gr.coin += this.gr.sell_money;
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.gr.say_c == 0) {
            if (this.eventGoing == 2) {
                if (this.gr.rmsOther[3] == 5) {
                    this.gr.say(Constants_H.LEVEL_TXT_0, 0);
                } else {
                    this.gr.sell_money = (byte) (this.gr.isMyLevel(false) - this.gr.monInfoList[103]);
                    if (this.gr.sell_money < 1) {
                        this.gr.sell_money = 0;
                    }
                    this.gr.say(Constants_H.LEVEL_TXT_1 + ((int) this.gr.rmsOther[3]) + Constants_H.LEVEL_TXT_2 + this.gr.sell_money + Constants_H.LEVEL_TXT_3, -1);
                }
                this.eventGoing = (byte) 4;
                return;
            }
            if (this.eventGoing == 3 && this.gr.sell_money > 0) {
                this.gr.say("获得：徽章x" + this.gr.sell_money, 0);
                this.eventGoing = (byte) 4;
            } else {
                short[] sArr2 = this.event_now;
                sArr2[i] = (short) (sArr2[i] + 3);
                nextEvent(4368);
            }
        }
    }

    private void runEvent_item_add_del(int i) {
        int event_temp = 0;
        if (this.eventGoing == 0) {
            this.now_eV1 = this.event[i][this.event_now[i] + 2];
            this.now_eV2 = this.event[i][this.event_now[i] + 3];
            if (this.event[i][this.event_now[i] + 3] >= 0) {
                event_temp = this.gr.addItem(this.now_eV1, this.now_eV2);
            } else {
                byte findItem = this.gr.findItem(-2, this.now_eV1, true);
                Ms.i();
                if (findItem >= Ms.abs(this.now_eV2)) {
                    GameRun gameRun = this.gr;
                    byte b = this.now_eV1;
                    Ms.i();
                    gameRun.deleteItems(b, Ms.abs(this.now_eV2));
                } else {
                    event_temp = -1;
                    this.gr.say(Constants_H.TXT_58, 0);
                }
            }
            if (event_temp != -1) {
                GameRun gameRun2 = this.gr;
                StringBuilder append = new StringBuilder(String.valueOf(this.now_eV2 >= 0 ? Constants_H.MONEY_TXT_7 : Constants_H.MONEY_TXT_13)).append(this.gr.getNameItem(this.now_eV1)).append("x");
                Ms.i();
                gameRun2.say(append.append(Ms.abs(this.now_eV2)).toString(), 0);
            }
            this.eventGoing = (byte) 1;
            return;
        }
        if (this.gr.say_c == 0) {
            if (0 != -1) {
                short[] sArr = this.event_now;
                sArr[i] = (short) (sArr[i] + 4);
                nextEvent(4368);
                return;
            }
            setEventNow(i, true);
        }
    }

    private void runEvent_dialog(int i) {
        this.checkNpcT = (byte) -1;
        if (this.eventGoing == 0) {
            this.eventGoing = (byte) 1;
            if (this.anole_type == 1) {
                setAnole();
            }
            int event_temp = this.event[i][this.event_now[i] + 2] - 1;
            if (event_temp == -1) {
                this.npcName = Constants_H.NAME_TXT_0;
                this.now_eV2 = (byte) 0;
            } else {
                this.now_eV1 = getNpcLayer(event_temp);
                this.now_eV2 = getNpcId(event_temp);
                this.npcName = this.npcNameData[this.now_eV2];
                if (this.npcName.equals("路人")) {
                    this.npcName = null;
                }
                this.now_eV2 = this.npc[this.now_eV1][this.now_eV2].other[2];
            }
            initNpcFaceOne(this.npcName);
            Ms.i();
            Ms.font.setSize(22);
            this.dialog = Ms.i().groupString(Ms.i().getDialogs(this.event[i], this.event_now[i] + 5, this.event[i][this.event_now[i] + 4]), Constants_H.WIDTH__ - 20);
            if (!this.fontSizeControl) {
                Ms.i();
                Ms.font.setSize(26);
            }
            this.dialog_no = (byte) 0;
            this.my.state = (byte) 1;
            this.bDirTalk = false;
            return;
        }
        if (this.eventGoing == 2) {
            short[] sArr = this.event_now;
            sArr[i] = (short) (sArr[i] + (this.event[i][this.event_now[i] + 4] << 1) + 5);
            nextEvent(4369);
        }
    }

    private void runEvent_select(int i) {
        if (this.my.state != 12 && this.my.state != 13 && this.my.state != 14) {
            this.sEvent_eV2 = this.event[i][this.event_now[i] + 1];
            this.sEvent_eV1 = (byte) 0;
            this.gr.action_str = null;
            this.gr.action_str = new String[this.sEvent_eV2];
            for (byte j = 0; j < this.sEvent_eV2; j = (byte) (j + 1)) {
                this.gr.action_str[j] = Ms.i().getDialogs(this.event[i], this.event_now[i] + 2 + this.sEvent_eV1 + 1, this.event[i][this.event_now[i] + 2 + this.sEvent_eV1]);
                this.sEvent_eV1 = (byte) (this.sEvent_eV1 + (this.event[i][(this.event_now[i] + 2) + this.sEvent_eV1] << 1) + 1);
            }
            if (this.sIfElse != -1) {
                this.event_state = (byte) 1;
                this.gr.cur_a = this.sIfElse;
                this.my.state = (byte) 13;
                this.gr.action_str = null;
                this.sIfElse = (byte) -1;
                return;
            }
            this.gr.cur_a = (byte) 0;
            this.my.state = (byte) 12;
            return;
        }
        if (this.my.state == 13) {
            this.sEvent_eV1 = (byte) (this.sEvent_eV1 + 2);
            byte a = this.event[i][this.event_now[i] + this.sEvent_eV1 + (this.gr.cur_a << 1)];
            byte b = this.event[i][this.event_now[i] + this.sEvent_eV1 + (this.gr.cur_a << 1) + 1];
            short d = (short) (((a & 255) << 8) | (b & 255));
            short[] sArr = this.event_now;
            sArr[i] = (short) (sArr[i] + this.sEvent_eV1 + (this.sEvent_eV2 << 1) + d);
            nextEvent(17);
            return;
        }
        if (this.my.state == 14) {
            setEventNow(i, true);
        }
    }

    public void run_map() {
        if (this.my.state != 9 && this.my.state != 6) {
            eventCheck();
        }
        if (this.my.state == 5 && this.my.frame_c < 1) {
            setMoveStop_m();
            this.my.state = (byte) 6;
        }
        if (this.my.state == 6) {
            this.gr.createOver = (byte) 1;
            goNextMap();
            return;
        }
        if (this.my.state == 2 && this.eventGoing == 0) {
            if ((this.npc[0][this.get_meet].other[4] == 1 || this.npc[0][this.get_meet].other[4] == 3) && this.npc[0][this.get_meet].other[5] > 0) {
                this.npcName = this.npcNameData[this.get_meet];
                if (this.npcName.equals("路人")) {
                    this.npcName = null;
                }
                initNpcFaceOne(this.npcName);
                Ms.i();
                Ms.font.setSize(22);
                this.dialog = Ms.i().groupString(this.npcStringData[this.npc[0][this.get_meet].other[5] - 1], Constants_H.WIDTH__ - 20);
                if (!this.fontSizeControl) {
                    Ms.i();
                    Ms.font.setSize(26);
                }
                this.dialog_no = (byte) 0;
                this.my.state = (byte) 1;
            } else {
                this.my.state = (byte) 0;
            }
        } else if (this.my.state == 8 && this.my.frame_c == -1) {
            if (this.gr.immueEnemy == 0) {
                Log.e("sk", "gr.immueEnemy==0");
                GameRun gameRun = this.gr;
                String[] strArr = this.gr.battleSay;
                Ms.i();
                gameRun.say(strArr[Ms.getRandom(3)], 0);
                GameRun.mc.repaint();
                this.gr.battleType(4);
                this.gr.goBattlePVC();
            } else {
                this.my.state = (byte) 0;
            }
        }
        runMove();
    }

    public void paint_map(Graphics g2) {
        g = g2;
        if (this.my.state == 6) {
            this.gr.drawChangeMap(false, this.gr.b_c, 30, Constants_H.HEIGHT_ - 38, Constants_H.WIDTH_ - 60);
            return;
        }
        if (this.my.state == 17) {
            drawMiniMap();
            return;
        }
        if (this.my.state == 18) {
            drawMission();
            return;
        }
        Ui.i().fillRect(this.bgColor, 0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
        GameRun.mc.setScale(MainCanvas.mapxx, MainCanvas.mapyy);
        GameRun.mc.keyxx = MainCanvas.mapxx;
        GameRun.mc.keyyy = MainCanvas.mapyy;
        setMapOffer();
        if (this.xxx > 0) {
            this.xxx = (byte) (this.xxx - 1);
            g2.translate(this.xxx % 2, this.xxx % 2);
        }
        drawMap(GameRun.offG);
        drawNpcAni(this.npc[2]);
        if (this.pkey.isGo) {
            int i = this.ii;
            this.ii = i + 1;
            if (i > 2) {
                this.ii = 0;
                int i2 = this.i;
                this.i = i2 + 1;
                this.i = i2 < 2 ? this.i : 0;
            }
            Ui.i().drawImage(this.walkIco[this.i], this.pkey.gox + this.map_x, this.pkey.goy + this.map_y, 3);
        }
        drawNMAni(this.npc[0]);
        bkgroundToPaint(this.frontData, this.mapImg, -this.map_x, (-this.map_y) - 1, this.moduleData, g2, 0, 0, Constants_H.WIDTH, Constants_H.HEIGHT, false);
        drawNpcAni(this.npc[1]);
        drawMapRect(g2);
        drawStep(g2, Constants_H.WIDTH - 17, 0, 16);
        drawBrow();
        drawCheck5(4);
        drawCloud();
        if (this.gr.magic_id > -1) {
            if (this.gr.drawMagicC(this.gr.magic_id / 5 > 5 ? 5 : this.gr.magic_id / 5, this.gr.magic_id / 5 > 5 ? 5 : this.gr.magic_id / 5, this.gr.magic_id / 5 >= 5 ? this.gr.magic_id - 25 : this.gr.magic_id % 5, this.gr.magic_x, this.gr.magic_y + 16, 0)) {
                if (this.my.state == 21) {
                    this.gr.magic_id = (byte) -2;
                    setAnole();
                } else {
                    this.gr.magic_id = (byte) -1;
                }
                this.my.state = (byte) 0;
            }
        }
        g2.translate(-g2.getTranslateX(), -g2.getTranslateY());
        if (this.my.state == 20) {
            drawAnoleSel();
        }
        g2.restCanvas();
        if (!this.fontSizeControl) {
            Ms.i();
            Ms.font.setSize(22);
        }
        drawSrcEffect();
        if (this.my.state == 12) {
            this.gr.drawSelectMenu_(this.gr.action_str, (Constants_H.WIDTH__ / 2) - (25 * 3), ((Constants_H.HEIGHT__ / 2) - 100) + ((this.gr.action_str.length >> 1) * 25), 25 * 6, 0, 0, this.gr.cur_a);
        }
        if (this.gr.view_state == 4) {
            int WIDTH = Constants_H.WIDTH__;
            int HEIGHT = Constants_H.HEIGHT__;
            int WIDTH_H = Constants_H.WIDTH__ / 2;
            byte[] id = {4, 25, Key_H.KEY_NUM8};
            Ui.i().drawKuang(0, HEIGHT - (25 * 3), WIDTH, 25 * 3);
            this.gr.showStringM_(this.gr.getNameMonsterInfo(id[this.gr.cur_a]), WIDTH_H, (HEIGHT - (25 * 2)) - 8, 10, 3);
        } else if (this.my.state == 16) {
            int WIDTH2 = Constants_H.WIDTH__;
            int HEIGHT2 = Constants_H.HEIGHT__;
            int WIDTH_H2 = Constants_H.WIDTH__ / 2;
            int HEIGHT_H = Constants_H.HEIGHT__ / 2;
            Ui.i().drawKuang(0, HEIGHT2 - (25 * 4), WIDTH2, 25 * 4);
            this.gr.showStringM_(Constants_H.TXT_54, WIDTH_H2, (HEIGHT2 - (25 * 4)) + 4, 10, 3);
            this.gr.drawSelectMenu_(this.gr.action_str, WIDTH_H2 - (25 * 2), HEIGHT_H - 25, 25 * 4, -1, 0, this.gr.popMenu);
            this.gr.showStringM_(Constants_H.GAME_TXT_2 + this.gr.sell_money, WIDTH_H2, (HEIGHT2 - (25 * 3)) + 4, 10, 3);
            this.gr.drawMoney(WIDTH_H2, (HEIGHT2 - 25) + 15, 3, false);
        }
        if (this.my.state != 20) {
            this.gr.drawPauseIco(this.my.state);
        }
        if (this.my.state == 19) {
            drawMySave();
            return;
        }
        byte b = this.gr.rmsOther[2];
        this.gr.drawCityName();
        if (this.my.state == 23) {
            int WIDTH3 = Constants_H.WIDTH__;
            int HEIGHT3 = Constants_H.HEIGHT__;
            int WIDTH_H3 = Constants_H.WIDTH__ / 2;
            Ui.i().drawKuang(0, HEIGHT3 - (25 * 2), WIDTH3, 25 * 2);
            Ui.i().drawString(Constants_H.TXT_67, WIDTH_H3, (HEIGHT3 - (25 * 2)) + 6, 17, 3, 0);
            Ui.i().drawYesNo__(true, true);
            this.pkey.isGo = false;
        }
        if (this.dialog_no > -1) {
            dialog(this.npcName);
            this.pkey.isGo = false;
        }
        this.gr.map_flashString();
        Ms.i();
        Ms.font.setSize(26);
    }

    private void setMapOffer() {
        if (this.map_y + (this.rows * 20) >= Constants_H.HEIGHT || this.rows <= Constants_H.YCELLS) {
            if (this.map_y <= 0 || this.rows <= Constants_H.YCELLS) {
                if (this.map_x <= 0 || this.cols <= Constants_H.XCELLS) {
                    if (this.map_x + (this.cols * 20) >= Constants_H.WIDTH || this.cols <= Constants_H.XCELLS) {
                        return;
                    }
                    this.map_x = Constants_H.WIDTH - (this.cols * 20);
                    return;
                }
                this.map_x = 0;
                return;
            }
            this.map_y = 0;
            return;
        }
        this.map_y = Constants_H.HEIGHT - (this.rows * 20);
    }

    private void drawStep(Graphics g2, int x, int y, int h) {
        if (this.bStep > 0) {
            g2.setColor(3947323);
            g2.drawRect(x + 1, y, h - 2, h);
            g2.drawRect(x, y + 1, h, h - 2);
            g2.setColor(13421772);
            g2.drawRect(x + 2, y + 1, h - 4, h - 2);
            g2.drawRect(x + 1, y + 2, h - 2, h - 4);
            Ui.i().fillRect(16777215, x + 2, y + 2, h - 3, h - 3);
            Ui.i().drawUi(67, (h >> 1) + x, (h >> 1) + y, 2 | 1, 0);
            if (this.bStep % 12 < 6) {
                Ui.i().drawLine(15597568, (x + h) - 1, y, x, (y + h) - 1);
                Ui.i().drawLine(0, x + h, y, x, y + h);
                Ui.i().drawLine(15597568, x + h, y + 1, x + 1, y + h);
            }
            byte b = (byte) (this.bStep - 1);
            this.bStep = b;
            if (b < 2) {
                this.bStep = (byte) 100;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drawBlackSRC(javax.microedition.lcdui.Graphics r22, int r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: main.Map.drawBlackSRC(javax.microedition.lcdui.Graphics, int, boolean):void");
    }

    public void key_map() {
        if (this.my.state != 17) {
            if (this.my.state != 18) {
                if (this.my.state != 12) {
                    if (this.my.state != 19) {
                        if (this.my.state == 22 && this.black_0 > -1 && this.black_0 == this.gr.about_d.length && Ms.i().key_Num0()) {
                            this.eventGoing = (byte) 3;
                            this.black_0 = (short) -1;
                            Ms.i().keyRelease();
                            return;
                        }
                        if (this.my.state == 16) {
                            if (!Ms.i().key_delay()) {
                                if (Ms.i().key_Up_Down()) {
                                    GameRun gameRun = this.gr;
                                    gameRun.popMenu = (byte) (gameRun.popMenu ^ 1);
                                } else if (Ms.i().key_S1_Num5() || Ms.i().key_S2()) {
                                    if (Ms.i().key_S2()) {
                                        this.gr.popMenu = (byte) 1;
                                    }
                                    this.my.state = (byte) 0;
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            if (this.my.state == 10) {
                                Ms.i().keyRelease();
                                return;
                            }
                            if (this.my.state == 23) {
                                if (Ms.i().key_S2()) {
                                    this.my.state = (byte) 25;
                                } else if (Ms.i().key_S1_Num5()) {
                                    this.my.state = (byte) 24;
                                }
                                Ms.i().keyRelease();
                                return;
                            }
                            if (this.my.state == 11) {
                                if (Ms.i().key_S1_Num5()) {
                                    this.gr.say_c = (byte) 0;
                                }
                                if (this.gr.say_c == 0) {
                                    this.my.state = (byte) 0;
                                    return;
                                }
                                return;
                            }
                            if (this.my.state == 20) {
                                keyAnoleSel();
                                return;
                            }
                        }
                        if (this.my.state == 1 && Ms.i().key_S1_Num5()) {
                            if (this.dialog_no + 2 >= this.dialog.length) {
                                this.dialog_no = (byte) -1;
                                this.dialog = null;
                                if (this.eventGoing == 0) {
                                    this.my.state = (byte) 0;
                                } else {
                                    this.eventGoing = (byte) 2;
                                }
                                if (this.bDirTalk) {
                                    this.npc[0][this.get_meet].other[7] = this.npcDirTalk;
                                    if (this.npc[0][this.get_meet].other[7] > -1) {
                                        this.npc[0][this.get_meet].dir = (byte) 3;
                                    }
                                    this.bDirTalk = false;
                                    return;
                                }
                                return;
                            }
                            this.dialog_no = (byte) (this.dialog_no + 2);
                            Ms.i().keyRelease();
                        }
                        if (this.my.frame_c <= 0 && this.my.state == 0) {
                            Ms.i();
                            this.map_key = (byte) (-Ms.key);
                            doKey();
                            return;
                        }
                        return;
                    }
                    keyMySave();
                    return;
                }
                keySelectMenu();
                return;
            }
            keyMission();
            return;
        }
        keyMiniMap();
    }

    private void drawAnoleSel() {
        byte j;
        byte c;
        byte j2;
        this.gr.cur_a = (byte) Ms.i().mathSpeedN(this.gr.cur_a, (25 * 2) + 12, 8, false);
        Ui.i().drawK1(0, (Constants_H.HEIGHT - this.gr.cur_a) - 2, 119, 25 + 4 + 2, 2);
        Ui.i().drawK2(0, ((Constants_H.HEIGHT + 25) + 4) - this.gr.cur_a, Constants_H.WIDTH, 25 + 8, 0);
        byte i = 0;
        while (i < 5) {
            if (isAnoleType(i)) {
                c = (byte) (i == this.anoleSel ? 1 : 0);
                if (i == this.anole_type) {
                    j2 = Constants_H.MINI_GAME;
                } else {
                    j2 = (byte) (i == this.anoleSel ? i + 5 : i);
                }
            } else {
                c = 6;
                j2 = (byte) (i + 70);
            }
            Ui.i().drawK0(((Constants_H.WIDTH * i) / 6) + 42, ((Constants_H.HEIGHT + 25) + 8) - this.gr.cur_a, 20, 20, c);
            Ui.i().drawUi(j2, ((Constants_H.WIDTH * i) / 6) + 42 + 10, (((Constants_H.HEIGHT + 25) + 8) - this.gr.cur_a) + 18, 33, 0);
            if (this.pkey.isSelect(((Constants_H.WIDTH * i) / 6) + 42, ((Constants_H.HEIGHT + 25) + 8) - this.gr.cur_a, 20, 20)) {
                if (this.anoleSel == i) {
                    this.pkey.setKeySoftkey1();
                } else {
                    this.anoleSel = i;
                }
            }
            i = (byte) (i + 1);
        }
        if (this.anoleSel == this.anole_type) {
            j = 0;
        } else {
            j = (byte) (isAnoleType(this.anoleSel) ? this.anoleSel + 1 : 6);
        }
        Log.e("sk", "drawAnoleSel");
        Ui.i().drawString(this.gr.about_a[j].toString(), 60, (Constants_H.HEIGHT - this.gr.cur_a) - 2, 17, 1, 2);
        Ui.i().drawK4(((this.anoleSel * Constants_H.WIDTH) / 6) + 41 + (this.gr.cur_b / 3), (((Constants_H.HEIGHT + 25) + 7) - this.gr.cur_a) + (this.gr.cur_b / 3), 22 - ((this.gr.cur_b / 3) << 1), 22 - ((this.gr.cur_b / 3) << 1));
        GameRun gameRun = this.gr;
        byte b = gameRun.cur_b;
        gameRun.cur_b = (byte) (b + 1);
        if (b > 4) {
            this.gr.cur_b = (byte) 0;
        }
        Ui.i().drawYesNo_(false, true);
    }

    private void keyAnoleSel() {
        if (!Ms.i().key_delay()) {
            if (!Ms.i().key_Left_Right()) {
                if (Ms.i().key_S1()) {
                    if (!isAnoleType(this.anoleSel)) {
                        this.gr.say(Constants_H.TXT_93, 0);
                    } else if (this.anoleSel == 4) {
                        this.gr.say(Constants_H.TXT_94, 0);
                    } else {
                        if (this.anole_type == this.anoleSel) {
                            this.anole_type = (byte) -1;
                        } else {
                            this.anole_type = this.anoleSel;
                        }
                        if (this.gr.rmsSms[6] == 10 && this.anole_type == 3 && this.gr.rmsSms[0] == 0) {
                            SMSSender.i(this.gr).go(1, true);
                            this.anole_type = (byte) -1;
                        } else {
                            if (this.anole_type == 3 && this.gr.rmsSms[0] == 0) {
                                this.gr.say(Constants_H.TXT_107, -1);
                            }
                            this.gr.magic_id = (byte) 13;
                            this.gr.magic_x = this.map_x + this.my.x + 10;
                            this.gr.magic_y = this.map_y + this.my.y + 19;
                            this.gr.setMagic(this.gr.magic_id / 5);
                            this.my.state = (byte) 21;
                        }
                    }
                    Ms.i().keyRelease();
                    return;
                }
                if (Ms.i().key_S2() || Ms.i().key_Num9()) {
                    this.my.state = (byte) 0;
                    Ms.i().keyRelease();
                    return;
                }
                return;
            }
            this.anoleSel = Ms.i().select(this.anoleSel, 0, 4);
        }
    }

    public boolean initAnoleValue() {
        if (isAnole(this.my.x, this.my.y, this.anole_type)) {
            this.gr.say(Constants_H.TXT_91, 0);
            return false;
        }
        this.my.state = (byte) 20;
        this.gr.cur_a = (byte) 0;
        this.gr.cur_b = (byte) 0;
        this.gr.setStringB(Constants_H.TXT_92, Constants_H.WIDTH, 0);
        return true;
    }

    private boolean isAnoleType(int i) {
        return (this.gr.rmsOther[2] & (1 << i)) != 0;
    }

    public void addAnole(int i) {
        int i2;
        if (i == 13 || i == 34 || i == 49 || i == 66 || i == 82) {
            if (i == 13) {
                i2 = 0;
            } else if (i == 34) {
                i2 = 1;
            } else if (i == 49) {
                i2 = 2;
            } else {
                i2 = i == 66 ? 3 : 4;
            }
            byte[] bArr = this.gr.rmsOther;
            bArr[2] = (byte) (bArr[2] | (1 << i2));
        }
    }

    public void setAnole() {
        this.gr.immueEnemy = (byte) (this.anole_type == 3 ? 1 : 0);
        this.my.speed = getMySpeed();
        Ms.i().setSprite(npcSp[1][0], "data/npc1/" + (this.anole_type == -1 ? "0" : "r" + ((int) this.anole_type)), this.anole_type == -1);
        this.my.setActionNo(false);
    }

    public byte getMySpeed() {
        if (this.anole_type != 0 && this.anole_type != 1) {
            if (this.anole_type == 2) {
                return (byte) 10;
            }
            if (this.anole_type != 4 && this.anole_type == 3) {
                return (byte) 10;
            }
            return (byte) 5;
        }
        return (byte) 6;
    }

    public void doKey() {
        switch (this.map_key) {
            case -57:
                Ms.i().keyRelease();
                if (this.gr.rmsOther[2] > 0) {
                    initAnoleValue();
                    return;
                }
                return;
            case -55:
            default:
                return;
            case -53:
            case 5:
                if (this.gr.isTalk) {
                    checkSoftKey(this.my.x, this.my.y, this.dir_select[this.my.dir][0] * this.my.speed, this.dir_select[this.my.dir][1] * this.my.speed);
                    return;
                }
                return;
            case -51:
                goMission(1, false);
                return;
            case -49:
                goMission(0, false);
                return;
            case -48:
                goMiniMap();
                return;
            case 1:
            case 2:
            case 3:
            case 4:
                if (this.my.dir != this.map_key) {
                    turnAround(this.map_key);
                }
                canMove(this.dir_select[this.map_key][0] * this.my.speed, this.dir_select[this.map_key][1] * this.my.speed);
                return;
        }
    }

    private void turnAround(int dir) {
        this.my.dir = (byte) dir;
        this.my.setActionNo(true);
    }

    public void mapMove(int x, int y, int xs, int ys) {
        if ((xs > 0 && x >= this.mapLeft_NOmove && x < this.mapRight_NOmove) || (xs < 0 && x > this.mapLeft_NOmove && x <= this.mapRight_NOmove)) {
            this.map_x -= xs;
        }
        if ((ys > 0 && y >= this.mapUp_NOmove && y < this.mapDown_NOmove) || (ys < 0 && y > this.mapUp_NOmove && y <= this.mapDown_NOmove)) {
            this.map_y -= ys;
        }
    }

    private void oneMove(Npc npc_, int i) {
        if (npc_.frame_c > 0) {
            if (this.srcNpcNo == i) {
                mapMove(npc_.x, npc_.y, npc_.speed_x, npc_.speed_y);
            }
            npc_.x = (short) (npc_.x + npc_.speed_x);
            npc_.y = (short) (npc_.y + npc_.speed_y);
            npc_.frame_c = (byte) (npc_.frame_c - 1);
            return;
        }
        if (npc_.frame_c != -1) {
            npc_.frame_c = (byte) -1;
            npc_.setActionNo(false);
        }
    }

    private byte checkIfNpc(Npc[] npc, int ix, int iy) {
        byte i;
        int length = npc.length - 1;
        while (true) {
            i = (byte) length;
            if (i > -1) {
                if (!Ms.i().isRect(ix, iy, 19, 19, npc[i].x, npc[i].y, 20, 20) || (npc[i].other[4] != 1 && npc[i].other[4] != 3)) {
                    length = i - 1;
                }
            } else {
                return (byte) -1;
            }
        }
        return i;
    }

    private byte checkIfOther(byte[][] data, int ix, int iy) {
        for (byte i = (byte) (data.length - 1); i > -1; i = (byte) (i - 1)) {
            if (Ms.i().isRect(ix, iy, 19, 19, data[i][0] * 20, data[i][1] * 20, 20, 20)) {
                return i;
            }
        }
        return (byte) -1;
    }

    public byte checkSoftKey(int A_X, int A_Y, int _speed_x, int _speed_y) {
        if (A_X + _speed_x < 0 || A_X + _speed_x >= this.cols * 20 || A_Y + _speed_y < 0 || A_Y + _speed_y >= this.rows * 20) {
            return (byte) 0;
        }
        byte type = checkIfNpc(this.npc[0], A_X + _speed_x, A_Y + _speed_y);
        if (this.my.state == 0 && type != -1) {
            if (this.anole_type == 1 && this.npc[0][type].other[8] == 4) {
                this.npc[0][type].other[8] = -4;
                byte[] bArr = this.npc[0][type].other;
                bArr[7] = (byte) (bArr[7] + 1);
                this.npc[0][type].now_action = (byte) 0;
                this.npc[0][type].now_time = (byte) 0;
            } else if (this.npc[0][type].other[8] != -4) {
                this.my.state = (byte) 2;
                this.get_meet = type;
                if (this.npc[0][type].other[8] != 2 && this.npc[0][type].other[8] != 3 && !this.npcNameData[type].equals("路人")) {
                    this.bDirTalk = true;
                    this.npcDirTalk = this.npc[0][type].other[7];
                    byte[] bArr2 = this.npc[0][type].other;
                    Ms.i();
                    bArr2[7] = (byte) (((Ms.abs(this.npcDirTalk) / 3) * 3) + (this.my.dir < 4 ? this.my.dir - 1 : this.my.dir - 2));
                    if (this.my.dir == 3) {
                        this.npc[0][type].other[7] = (byte) (-this.npc[0][type].other[7]);
                    } else {
                        this.npc[0][type].dir = (byte) 3;
                    }
                } else {
                    this.bDirTalk = false;
                }
            }
            return (byte) 9;
        }
        byte type2 = checkIfOther(this.item, A_X + _speed_x, A_Y + _speed_y);
        if (type2 == -1 || this.item[type2][2] == -1) {
            return (byte) -1;
        }
        Ms.i().keyRelease();
        this.get_meet = type2;
        getItem();
        return (byte) 0;
    }

    private void getItem() {
        if (this.item[this.get_meet][2] == 2) {
            this.gr.say(Constants_H.MONEY_TXT_12, 0);
            return;
        }
        byte id = (byte) (this.item[this.get_meet][3] - 2);
        if (id == -2) {
            this.gr.money += this.item[this.get_meet][4] * 100;
            this.gr.say(Constants_H.MONEY_TXT_9 + (this.item[this.get_meet][4] * 100) + Constants_H.MONEY_TXT_0, 0);
        } else if (id == -1) {
            this.gr.coin += this.item[this.get_meet][4];
            this.gr.say(Constants_H.MONEY_TXT_11 + ((int) this.item[this.get_meet][4]) + "徽章", 0);
        } else {
            this.gr.getItem(id, this.item[this.get_meet][4]);
        }
        this.item[this.get_meet][2] = 2;
    }

    private boolean isTrundleNpc(int ix, int iy) {
        byte type = checkIfNpc(this.npc[0], ix, iy);
        return type != -1 ? this.npc[0][type].other[4] == 1 || this.npc[0][type].other[4] == 3 : ix < 0 || ix >= this.cols || iy < 0 || iy >= this.rows || this.worldData[ix][iy] == 1;
    }

    private byte checkMap(int A_X, int A_Y, int _speed_x, int _speed_y) {
        this.checkNpcT = (byte) -1;
        this.checkType = checkIfOther(this.item, A_X + _speed_x, A_Y + _speed_y);
        if (this.checkType != -1) {
            this.checkNpcT = (byte) -2;
            return (byte) 1;
        }
        if (A_X + _speed_x < 0 || A_X + _speed_x >= this.cols * 20 || A_Y + _speed_y < 0 || A_Y + _speed_y >= this.rows * 20) {
            return (byte) 1;
        }
        this.checkType = checkIfNpc(this.npc[0], A_X + _speed_x, A_Y + _speed_y);
        if (this.checkType != -1) {
            if (!this.npcNameData[this.checkType].equals("路人") || this.npc[0][this.checkType].other[5] > 0) {
                this.checkNpcT = this.checkType;
            }
            return (byte) 1;
        }
        this.checkType = checkIfOther(this.door, A_X + _speed_x, A_Y + _speed_y);
        if (this.checkType != -1 && (this.door[this.checkType][5] == 2 || this.map_key == this.door[this.checkType][2])) {
            this.my.state = (byte) 5;
            this.get_meet = this.checkType;
            return (byte) 0;
        }
        return checkWorld(A_X, A_Y, _speed_x, _speed_y, false);
    }

    private byte checkWorld(int A_X, int A_Y, int _speed_x, int _speed_y, boolean mode) {
        byte ix;
        byte iy;
        byte check_n = 1;
        if ((_speed_x == 0 && A_X % 20 != 0) || (_speed_y == 0 && A_Y % 20 != 0)) {
            check_n = 2;
        }
        for (byte i = 0; i < check_n; i = (byte) (i + 1)) {
            if (_speed_y == 0) {
                iy = (byte) (((i * 20) + A_Y) / 20);
                ix = (byte) (_speed_x >= 0 ? ((A_X + _speed_x) + 19) / 20 : (A_X + _speed_x) / 20);
            } else {
                ix = (byte) (((i * 20) + A_X) / 20);
                iy = (byte) (_speed_y >= 0 ? ((A_Y + _speed_y) + 19) / 20 : (A_Y + _speed_y) / 20);
            }
            if (mode) {
                if (this.worldData[ix][iy] != 0) {
                    return (byte) this.worldData[ix][iy];
                }
            } else if (isCan_not_pass(ix, iy)) {
                return (byte) 1;
            }
        }
        return (byte) 0;
    }

    private boolean isAnole(int _x, int _y, int _anole_type) {
        int _anole_type2;
        if (_anole_type == 0) {
            _anole_type2 = 3;
        } else if (_anole_type == 2) {
            _anole_type2 = 4;
        } else {
            if (_anole_type != 4) {
                return false;
            }
            _anole_type2 = 2;
        }
        byte check_n = _x % 20 != 0 ? (byte) (0 + 1) : (byte) 0;
        if (_y % 20 != 0) {
            check_n = (byte) (check_n + 1);
        }
        byte check_n2 = (byte) (1 << check_n);
        if (check_n2 == 4 && this.worldData[(_x + 19) / 20][_y / 20] == _anole_type2) {
            return true;
        }
        if (check_n2 > 1) {
            if (_x % 20 != 0 && this.worldData[(_x + 19) / 20][(_y + 19) / 20] == _anole_type2) {
                return true;
            }
            if (_y % 20 != 0 && this.worldData[_x / 20][_y / 20] == _anole_type2) {
                return true;
            }
        }
        return this.worldData[_x / 20][_y / 20] == _anole_type2;
    }

    private boolean isCan_not_pass(int ix, int iy) {
        if (this.worldData[ix][iy] == 1) {
            return true;
        }
        return this.anole_type == 0 ? this.worldData[ix][iy] == 2 || this.worldData[ix][iy] == 4 : this.anole_type == 2 ? this.worldData[ix][iy] == 3 || this.worldData[ix][iy] == 2 : this.anole_type == 4 ? this.worldData[ix][iy] != 2 : this.worldData[ix][iy] == 2 || this.worldData[ix][iy] == 3 || this.worldData[ix][iy] == 4;
    }

    private void meetGrass() {
        if (this.meet_step < this.step_MEET) {
            if (this.worldData[this.my.getIx()][this.my.getIy()] != 7) {
                this.meet_step = (short) (this.meet_step + 1);
            }
        } else {
            if (this.gr.monPro.length > 1 && this.gr.immueEnemy == 0) {
                this.my.frame_c = (byte) 0;
                this.my.state = (byte) 8;
            }
            notMeet(0, 0);
        }
    }

    private void canMove(int temp_xspeed, int temp_yspeed) {
        this.my.speed_x = (byte) temp_xspeed;
        this.my.speed_y = (byte) temp_yspeed;
        if (this.my.x + this.my.speed_x >= 0 && this.my.x + this.my.speed_x + 19 < this.cols * 20 && this.my.y + this.my.speed_y >= 0 && this.my.y + this.my.speed_y + 19 < this.rows * 20) {
            this.roadType = checkMap(this.my.x, this.my.y, this.my.speed_x, this.my.speed_y);
            if (this.roadType != 0) {
                if (!checkMoveOff(this.checkNpcT)) {
                    if (this.checkNpcT == -1 || isCheckNpcOff()) {
                        this.roadType = isMapChenk(this.roadType);
                        if (this.roadType == -1) {
                            moveOff((byte) 3, (byte) 1, -this.my.speed);
                            return;
                        } else if (this.roadType == -2) {
                            moveOff((byte) 4, (byte) 2, this.my.speed);
                            return;
                        } else {
                            checkAnole();
                            return;
                        }
                    }
                    Ms.i().keyRelease();
                    setMoveStop_m();
                    return;
                }
                initMoveMy();
                return;
            }
            initMoveMy();
            return;
        }
        setMoveStop_m();
        this.checkType = checkIfOther(this.door, this.my.x, this.my.y);
        if (this.checkType != -1 && this.door[this.checkType][5] == 0 && this.map_key == this.door[this.checkType][2]) {
            this.my.state = (byte) 5;
            this.get_meet = this.checkType;
        }
    }

    private boolean isCheckNpcOff() {
        if (this.checkNpcT < 0) {
            return false;
        }
        if (this.my.speed_x != 0) {
            Ms.i();
            byte w = (byte) (20 - Ms.abs(this.my.y - this.npc[0][this.checkNpcT].y));
            if (w > 0 && w < 11) {
                return true;
            }
        } else if (this.my.speed_y != 0) {
            Ms.i();
            byte w2 = (byte) (20 - Ms.abs(this.my.x - this.npc[0][this.checkNpcT].x));
            if (w2 > 0 && w2 < 11) {
                return true;
            }
        }
        return false;
    }

    private void moveOff(byte dirx, byte diry, int speed) {
        if (this.my.speed_x == 0) {
            this.my.dir = dirx;
        } else if (this.my.speed_y == 0) {
            this.my.dir = diry;
        }
        this.my.speed_x = (byte) (this.my.speed_x != 0 ? 0 : speed);
        this.my.speed_y = (byte) (this.my.speed_y != 0 ? 0 : speed);
        checkMoveOff(this.checkNpcT);
        initMoveMy();
    }

    private boolean checkMoveOff(int npcid) {
        if (npcid > -1) {
            byte oxl = (byte) ((this.npc[0][npcid].x + 20) - this.my.x);
            byte oxr = (byte) ((this.npc[0][npcid].x - this.my.x) - 20);
            byte oyl = (byte) ((this.npc[0][npcid].y + 20) - this.my.y);
            byte oyr = (byte) ((this.npc[0][npcid].y - this.my.y) - 20);
            if (this.my.speed_x < 0 && oxl != 0) {
                this.my.speed_x = oxl < this.my.speed_x ? this.my.speed_x : oxl;
                return true;
            }
            if (this.my.speed_x > 0 && oxr != 0) {
                this.my.speed_x = oxr < this.my.speed_x ? oxr : this.my.speed_x;
                return true;
            }
            if (this.my.speed_y < 0 && oyl != 0) {
                this.my.speed_y = oyl < this.my.speed_y ? this.my.speed_y : oyl;
                return true;
            }
            if (this.my.speed_y > 0 && oyr != 0) {
                this.my.speed_y = oyr < this.my.speed_y ? oyr : this.my.speed_y;
                return true;
            }
        } else {
            byte oxl2 = this.my.getIx_off();
            byte oxr2 = (byte) (20 - this.my.getIx_off());
            byte oyl2 = this.my.getIy_off();
            byte oyr2 = (byte) (20 - this.my.getIy_off());
            if (this.my.speed_x != 0 && oxl2 != 0) {
                if (this.my.speed_x < 0) {
                    this.my.speed_x = (byte) ((-oxl2) < this.my.speed_x ? this.my.speed_x : -oxl2);
                } else {
                    this.my.speed_x = oxr2 < this.my.speed_x ? oxr2 : this.my.speed_x;
                }
                return true;
            }
            if (this.my.speed_y != 0 && oyl2 != 0) {
                if (this.my.speed_y < 0) {
                    this.my.speed_y = (byte) ((-oyl2) < this.my.speed_y ? this.my.speed_y : -oyl2);
                } else {
                    this.my.speed_y = oyr2 < this.my.speed_y ? oyr2 : this.my.speed_y;
                }
                return true;
            }
        }
        return false;
    }

    private void checkAnole() {
        this.checkType = checkWorld(this.my.x, this.my.y, this.my.speed_x, this.my.speed_y, true);
        if (this.checkType == 2) {
            if (isCheckAnole(4)) {
                return;
            }
        } else if (this.checkType == 3) {
            if (isCheckAnole(0)) {
                return;
            }
        } else if (this.checkType == 4) {
            if (isCheckAnole(2)) {
                return;
            }
        } else if (this.checkType == 0 && this.anole_type == 4) {
            if (this.anole_type == 3 || !isAnoleType(3)) {
                this.anole_type = (byte) -1;
            } else {
                this.anole_type = (byte) 3;
            }
            setAnole();
            initMoveMy();
            return;
        }
        Ms.i().keyRelease();
        setMoveStop_m();
    }

    private boolean isCheckAnole(int id) {
        if (this.anole_type != id && isAnoleType(id)) {
            this.anole_type = (byte) id;
            setAnole();
            return true;
        }
        if (!isAnoleType(id)) {
            this.gr.say(Constants_H.TXT_75 + ((Object) this.gr.monsterT[id]) + Constants_H.TXT_82 + Constants_H.TXT_103, -1);
        }
        return false;
    }

    private void setMoveStop_m() {
        this.my.speed_x = (byte) 0;
        this.my.speed_y = (byte) 0;
        this.my.frame_c = (byte) -1;
        this.my.setActionNo(false);
    }

    private byte isMapChenk(byte checkType) {
        int i;
        int i2;
        int i3;
        int i4;
        byte checkLeft = 0;
        byte checkRight = 0;
        byte ix = (byte) (this.my.x / 20);
        byte iy = (byte) (this.my.y / 20);
        if (this.my.speed_x == 0) {
            checkLeft = checkMap((ix - (this.my.x % 20 != 0 ? (byte) 0 : (byte) 1)) * 20, ((this.my.speed_y >= 0 ? (byte) 1 : (byte) -1) + iy) * 20, 0, 0);
            checkRight = checkMap((ix + 1) * 20, ((this.my.speed_y >= 0 ? (byte) 1 : (byte) -1) + iy) * 20, 0, 0);
        } else if (this.my.speed_y == 0) {
            checkLeft = checkMap(((this.my.speed_x >= 0 ? (byte) 1 : (byte) -1) + ix) * 20, (iy - (this.my.y % 20 != 0 ? (byte) 0 : (byte) 1)) * 20, 0, 0);
            checkRight = checkMap(((this.my.speed_x >= 0 ? (byte) 1 : (byte) -1) + ix) * 20, (iy + 1) * 20, 0, 0);
        }
        if (checkLeft == 1 && checkRight == 1) {
            return checkType;
        }
        if (checkLeft == 0) {
            if (this.my.speed_x == 0) {
                i3 = ix - (this.my.x % 20 != 0 ? (byte) 0 : (byte) 1);
            } else {
                i3 = ix;
            }
            int i5 = i3 * 20;
            if (this.my.speed_y == 0) {
                i4 = iy - (this.my.y % 20 != 0 ? (byte) 0 : (byte) 1);
            } else {
                i4 = iy;
            }
            if (checkMap(i5, i4 * 20, 0, 0) == 0) {
                return (byte) -1;
            }
        }
        if (checkRight == 0) {
            if (this.my.speed_x == 0) {
                i = (this.my.x % 20 != 0 ? (byte) 0 : (byte) 1) + ix;
            } else {
                i = ix;
            }
            int i6 = i * 20;
            if (this.my.speed_y == 0) {
                i2 = (this.my.y % 20 != 0 ? (byte) 0 : (byte) 1) + iy;
            } else {
                i2 = iy;
            }
            if (checkMap(i6, i2 * 20, 0, 0) == 0) {
                return (byte) -2;
            }
        }
        return checkType;
    }

    private void dialog(String npcName) {
        int WIDTH = Constants_H.WIDTH__;
        int HEIGHT = Constants_H.HEIGHT__;
        int y = (HEIGHT - 8) - (25 * 2);
        int height = (25 * 2) + 11;
        Ui.i().drawKuang(4, (HEIGHT - height) - 4, WIDTH - 4, height + 4);
        if (npcName != null) {
            drawNpcFace(this.faceDir ? WIDTH - 50 : 50, this.faceDir ? (HEIGHT - height) - 4 : ((HEIGHT - height) - 4) - 25, 1 | 32);
            Ui.i().drawKuang(0, (y - height) + 25, Ms.i().getStringWidth(npcName) + 16, 25 + 8);
            Ui.i().drawString(npcName, 8, (y - height) + 2 + 25, 0, 9, 1);
            Log.e("sk", "dialog");
        }
        for (int line_c = 0; line_c < 2 && this.dialog_no + line_c < this.dialog.length; line_c++) {
            Ui.i().drawStringColor(this.dialog[this.dialog_no + line_c].toString(), 10, (line_c * 25) + (y - 2), -1, 1);
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

    private byte[] getNpcData() {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        getNpcData(byteArray, this.npc[0]);
        getNpcData(byteArray, this.npc[1]);
        getNpcData(byteArray, this.npc[2]);
        getItemData(byteArray, this.item);
        getItemData(byteArray, this.door);
        return byteArray.toByteArray();
    }

    private void getNpcData(ByteArrayOutputStream byteArray, Npc[] npc) {
        for (int i = 0; i < npc.length; i++) {
            try {
                if (npc[i].other[9] == 1) {
                    byteArray.write(npc[i].other);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return;
            }
        }
    }

    private void getItemData(ByteArrayOutputStream byteArray, byte[][] data) {
        try {
            byteArray.write(data.length);
            for (int i = 0; i < data.length; i++) {
                byteArray.write(data[i].length);
                byteArray.write(data[i]);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void drawMiniMap() {
        int i;
        GameRun.mc.keyxx = MainCanvas.mainxx;
        GameRun.mc.keyyy = MainCanvas.mainyy;
        Ui.i().fillRectB();
        Ui.i().drawK2(1, 2, Constants_H.WIDTH_ - 2, Constants_H.HEIGHT_ - 2, 0);
        Ui.i().drawK1(6, 33, Constants_H.WIDTH_ - 12, (Constants_H.HEIGHT_ - (29 * 3)) - 15, 1);
        Ui.i().drawK1(6, (Constants_H.HEIGHT_ - 6) - (29 * 2), Constants_H.WIDTH_ - 12, 29 * 2, 2);
        Ui.i().drawYesNo(false, true);
        Ui.i().drawString(Constants_H.TXT_78, Constants_H.WIDTH_H_, 4, 17, 1, 2);
        if (this.showArea == -1) {
            Ui.i().drawString(Constants_H.TXT_79, Constants_H.WIDTH_H_, (Constants_H.HEIGHT_ - 4) - (29 * 2), 16 | 1, 3, 0);
            return;
        }
        this.gr.showStringM(Constants_H.TXT_80 + this.gr.getNameCity(this.myMiniMap), Constants_H.WIDTH_H_, (Constants_H.HEIGHT_ - 4) - (29 * 2), 10, 3);
        g.setClip(6, 33, Constants_H.WIDTH_ - 12, (Constants_H.HEIGHT_ - 15) - (29 * 3));
        int i2 = Constants_H.WIDTH_H_ - (this.mapdataMap[this.selectMap][0] * 18);
        if (this.miniMapMode) {
            i = (this.mapdataMap[this.selectMap][6] * 18) / 2;
        } else {
            i = 25;
        }
        int t = i2 - i;
        this.mapoffx = Ms.i().mathSpeedN(this.mapoffx, t, 10, false);
        int t2 = ((this.littleMapClipY / 2) - (this.mapdataMap[this.selectMap][1] * 12)) - (this.miniMapMode ? (this.mapdataMap[this.selectMap][7] * 12) / 2 : 15);
        this.mapoffy = Ms.i().mathSpeedN(this.mapoffy, t2, 10, false);
        for (byte j = 0; j < this.mapdataArea[this.showArea].length; j = (byte) (j + 1)) {
            byte tmap = this.mapdataArea[this.showArea][j];
            if (tmap >= 0 && this.mapdataMap[tmap].length > 0) {
                if (this.pkey.isSelect((this.mapdataMap[tmap][0] * 18) + this.mapoffx, (this.mapdataMap[tmap][1] * 12) + this.mapoffy, 18 * 6, 12 * 6)) {
                    this.selectMap = tmap;
                }
                if (this.miniMapMode || tmap != this.myMiniMap) {
                    drawMapRect((byte) 18, (byte) 12, tmap, false);
                }
            }
        }
        if (!this.miniMapMode) {
            drawMapRect((byte) 18, (byte) 12, this.myMiniMap, false);
        }
        drawMapRect((byte) 18, (byte) 12, this.selectMap, true);
        g.setClip(0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_);
    }

    private void drawMapRect(byte ww, byte hh, int tmap, boolean select) {
        int width = ww * 6;
        int height = hh * 6;
        if (this.miniMapMode) {
            width = this.mapdataMap[tmap][6] * ww;
            height = this.mapdataMap[tmap][7] * hh;
        }
        if (select) {
            Ui.i().drawRectZ(12352252, (this.mapdataMap[tmap][0] * ww) + this.mapoffx, (this.mapdataMap[tmap][1] * hh) + this.mapoffy, width, height, 5);
            return;
        }
        if (tmap == this.myMiniMap) {
            Ui.i().drawK1(this.mapoffx + (this.mapdataMap[tmap][0] * ww), this.mapoffy + (this.mapdataMap[tmap][1] * hh), width, height, 4);
        } else {
            Ui.i().drawK0(this.mapoffx + (this.mapdataMap[tmap][0] * ww), this.mapoffy + (this.mapdataMap[tmap][1] * hh), width, height, 2);
        }
        this.gr.showStringM(this.gr.getNameCity(tmap), (this.mapdataMap[tmap][0] * ww) + this.mapoffx + (width >> 1), (((this.mapdataMap[tmap][1] * hh) + this.mapoffy) + (height >> 1)) - 25, 4, tmap == this.myMiniMap ? 0 : 3);
        if (tmap == this.myMiniMap) {
            Ui.i().drawUi(67, (this.mapdataMap[tmap][0] * ww) + this.mapoffx + (width >> 1), (this.mapdataMap[tmap][1] * hh) + this.mapoffy + (height >> 1), 3, 0);
        }
    }

    private void keyMiniMap() {
        Ms.i().keyRelease();
        if (!Ms.i().key_S1_Num5()) {
            if (Ms.i().key_S2() || Ms.i().key_Num0()) {
                this.my.state = (byte) 0;
                this.mapdataArea = null;
                this.mapdataMap = null;
            } else if ((Ms.i().key_Left_Right() || Ms.i().key_Up_Down()) && this.mapdataMap[this.selectMap].length >= 6 && this.mapdataMap[this.selectMap][Ms.abs(Ms.key) + 1] != -1) {
                this.selectMap = this.mapdataMap[this.selectMap][Ms.abs(Ms.key) + 1];
            }
        }
    }

    public void goMiniMap() {
        Ms.i().keyRelease();
        byte[] data = Ms.i().getStream("data/map.d", -1);
        Ms.skip = 0;
        this.mapdataArea = Ms.i().create2Array(data);
        this.mapdataMap = Ms.i().create2Array(data);
        this.my.state = (byte) 17;
        this.showArea = (byte) -1;
        this.myMiniMap = (byte) -1;
        this.selectMap = (byte) 0;
        for (byte i = 0; i < this.mapdataArea.length; i = (byte) (i + 1)) {
            for (byte k = 0; k < this.mapdataArea[i].length; k = (byte) (k + 1)) {
                if (this.mapNo == this.mapdataArea[i][k]) {
                    this.selectMap = this.mapNo;
                    if (this.mapdataMap[this.selectMap].length > 0) {
                        this.myMiniMap = this.selectMap;
                        this.showArea = i;
                        this.miniMapMode = this.mapdataArea[this.showArea][0] > -1;
                        return;
                    }
                }
            }
        }
    }

    private void drawMySave() {
        this.gr.showString(Constants_H.PAUSE_TXT_18, 285, 0);
        Ui.i().drawYesNo(true, true);
    }

    private void keyMySave() {
        if (Ms.i().key_S1()) {
            this.my.state = (byte) 0;
            this.eventGoing = (byte) 2;
        } else if (Ms.i().key_S2()) {
            this.my.state = (byte) 0;
            this.eventGoing = (byte) 3;
        }
    }

    private void initMissionList() {
        byte[] info = Ms.i().rmsOptions(7, null, 1);
        if (info[0] == -1) {
            this.bMission = null;
        } else {
            this.bMission = info;
        }
        if (this.bMission == null) {
            this.bMission = new byte[20];
        }
        Ms.i();
        Ms.skip = 0;
        byte[] data = Ms.i().getStream("data/mission0.t", -1);
        this.sMission = Ms.i().createString2Array(data);
        this.smissionLength = this.sMission.length - 1;
        this.sMission = null;
    }

    public void goMission(int type, boolean b) {
        if (this.my.state == 18 || this.my.state == 0) {
            Ms.i().keyRelease();
            this.bPause = b;
            GameRun.run_state = -10;
            this.my.state = (byte) 18;
            this.gr.cur_a = (byte) type;
            byte[] bArr = this.gr.select[0];
            this.gr.select[0][1] = 0;
            bArr[0] = 0;
            Ms.i();
            Ms.skip = 0;
            byte[] data = Ms.i().getStream("data/mission" + type + ".t", -1);
            this.sMission = Ms.i().createString2Array(data);
            this.gr.line_max = (byte) 6;
            this.gr.about_a = null;
            if (type == 1) {
                int i = 0;
                byte[] tMis = new byte[50];
                for (byte i2 = 0; i2 < this.sMission.length; i2 = (byte) (i2 + 1)) {
                    if (isMission(i2)) {
                        byte j = (byte) (i + 1);
                        tMis[i] = i2;
                        i = j;
                    }
                }
                this.mDirect = null;
                this.mDirect = new byte[i];
                System.arraycopy(tMis, 0, this.mDirect, 0, this.mDirect.length);
                if (this.mDirect.length > 0) {
                    this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), Constants_H.WIDTH_ - 50, 0);
                }
                return;
            }
            this.gr.select[0][0] = this.bMission[14];
            if (this.bMission[14] >= this.gr.line_max) {
                this.gr.select[0][1] = (byte) ((this.gr.select[0][0] - this.gr.line_max) + 1);
            } else {
                this.gr.select[0][1] = 0;
            }
            this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), Constants_H.WIDTH_ - 50, 0);
        }
    }

    public void setMission(int id, boolean bb) {
        byte type = (byte) (id / 8);
        int id2 = (byte) (id % 8);
        if (!bb) {
            if ((this.bMission[type] & (1 << id2)) != 0) {
                byte[] bArr = this.bMission;
                bArr[type] = (byte) (bArr[type] ^ (1 << id2));
                byte[] bArr2 = this.bMission;
                bArr2[15] = (byte) (bArr2[15] + 1);
                return;
            }
            return;
        }
        byte[] bArr3 = this.bMission;
        bArr3[type] = (byte) (bArr3[type] | (1 << id2));
    }

    private boolean isMission(int id) {
        byte type = (byte) (id / 8);
        return (this.bMission[type] & (1 << ((byte) (id % 8)))) != 0;
    }

    private void drawMission() {
        int i;
        Ui.i().fillRectB();
        Ui.i().drawK2(1, 6, Constants_H.WIDTH_ - 2, Constants_H.HEIGHT_ - 6, 0);
        Ui.i().drawK1(8, 41, Constants_H.WIDTH_ - 26, (this.gr.line_max * 29) + 10, 1);
        int i2 = 41 + 18;
        Ui.i().drawK1(8, (this.gr.line_max * 29) + 59, Constants_H.WIDTH_ - 16, 125, 2);
        drawMisstionList(8, 41 + 6, Constants_H.WIDTH_ - 26, 29, this.gr.line_max, this.gr.select[0], this.gr.cur_a == 0 ? this.bMission[14] + 1 : this.mDirect.length);
        for (byte d = 0; this.gr.about_a != null && d < this.gr.about_a.length; d = (byte) (d + 1)) {
            int i3 = 41 + 20;
            Ui.i().drawStringColor(this.gr.about_a[d].toString(), 25, (this.gr.line_max * 29) + 61 + (d * 25), 3, 0);
        }
        byte t = this.pkey.selectMenuX(2, 0, 0, Constants_H.WIDTH_H_, 40);
        if (t != -1) {
            this.gr.cur_a = t;
            goMission(this.gr.cur_a, this.bPause);
        }
        Ui i4 = Ui.i();
        if (this.gr.cur_a == 0) {
            i = Constants_H.WIDTH_H_ - 125;
        } else {
            i = Constants_H.WIDTH_H_ + 25;
        }
        i4.drawK1(i, 9, 100, 29, 4);
        Ui.i().drawString(Constants_H.MISSION_TXT_0, Constants_H.WIDTH_H_ - 75, 9, 17, this.gr.cur_a == 0 ? 0 : 1, 0);
        Ui.i().drawString(Constants_H.MISSION_TXT_1, Constants_H.WIDTH_H_ + 75, 9, 17, this.gr.cur_a == 1 ? 0 : 1, 0);
        Ui.i().drawTriangle(Constants_H.WIDTH_H_, 20, 150, true, true);
        Ui.i().drawString(String.valueOf(this.gr.cur_a == 0 ? Constants_H.MISSION_TXT_4 : Constants_H.MISSION_TXT_5) + Ms.i().getPrecision((this.bMission[this.gr.cur_a == 0 ? (char) 14 : (char) 15] * 1000) / (this.gr.cur_a == 0 ? this.sMission.length - 1 : this.sMission.length)) + "%", Constants_H.WIDTH_H_, Constants_H.HEIGHT_ - 1, 33, -1, 1);
        Ui.i().drawYesNo(false, true);
    }

    private void drawMisstionList(int x, int y, int w, int sh, int show_num, byte[] sel, int length) {
        int i;
        int i2;
        byte i3 = sel[1];
        Ui.i().drawListKY(show_num, x, y, w, 6, sh, -1, sel[0] - sel[1], 4, 2);
        while (i3 < sel[1] + show_num) {
            if (i3 < length) {
                String s = this.gr.cur_a == 0 ? String.valueOf(i3 + 1) + "、" + this.sMission[i3][0].toString() : String.valueOf(i3 + 1) + "、" + this.sMission[this.mDirect[i3]][0].toString();
                Log.e("sk", "drawMisstionList");
                Ui i4 = Ui.i();
                int i5 = x + 8;
                int i6 = ((i3 - sel[1]) * (sh - 1)) + y;
                if (i3 < this.bMission[14]) {
                    i = -1;
                } else {
                    i = sel[0] == i3 ? 0 : 3;
                }
                i4.drawString(s, i5, i6, 0, i, 0);
                if (this.gr.cur_a == 0 && i3 != length - 1) {
                    Ui i7 = Ui.i();
                    int i8 = (x + w) - 8;
                    int i9 = y + ((i3 - sel[1]) * (sh - 1));
                    if (i3 < this.bMission[14]) {
                        i2 = -1;
                    } else {
                        i2 = sel[0] == i3 ? 0 : 3;
                    }
                    i7.drawString(Constants_H.MISSION_TXT_6, i8, i9, 24, i2, 0);
                }
                if (this.pkey.isSelect(0, ((i3 - sel[1]) * (sh - 1)) + y, Constants_H.WIDTH_, sh - 1)) {
                    sel[0] = i3;
                    if (i3 - sel[1] == 0 && sel[1] > 0) {
                        sel[1] = (byte) (sel[1] - 1);
                    } else if (i3 - sel[1] == show_num - 1 && sel[1] + show_num < length) {
                        sel[1] = (byte) (sel[1] + 1);
                    }
                    if (this.gr.cur_a == 0) {
                        this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), Constants_H.WIDTH_ - 50, 0);
                    } else if (this.mDirect.length > 0) {
                        this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), Constants_H.WIDTH_ - 50, 0);
                    }
                }
            }
            i3 = (byte) (i3 + 1);
        }
        Ui.i().sliding(x + w + 4, y, show_num * sh, sel[0], length, true);
    }

    private void keyMission() {
        byte length;
        if (!Ms.i().key_delay()) {
            if (Ms.i().key_Left_Right() || ((Ms.i().key_Num1() && this.gr.cur_a == 1) || (Ms.i().key_Num3() && this.gr.cur_a == 0))) {
                GameRun gameRun = this.gr;
                gameRun.cur_a = (byte) (gameRun.cur_a ^ 1);
                goMission(this.gr.cur_a, this.bPause);
                return;
            }
            if (Ms.i().key_Up_Down()) {
                if (this.gr.cur_a == 0) {
                    length = (byte) (this.bMission[14] + 1 > this.sMission.length ? this.sMission.length : this.bMission[14] + 1);
                } else {
                    length = (byte) this.mDirect.length;
                }
                Ms.i().selectS(this.gr.select[0], 0, length, this.gr.line_max);
                if (this.gr.cur_a == 0) {
                    this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), Constants_H.WIDTH_ - 50, 0);
                    return;
                } else if (this.mDirect.length > 0) {
                    this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), Constants_H.WIDTH_ - 50, 0);
                    return;
                } else {
                    this.gr.about_a = null;
                    return;
                }
            }
            if (Ms.i().key_S2() || Ms.i().key_Num1() || Ms.i().key_Num3()) {
                this.my.state = (byte) 0;
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
        }
    }

    private void createMap() {
        loadMapModuleAndImage();
        loadMapData(this.mapNo);
    }

    private void loadMapModuleAndImage() {
        Ms.i();
        Ms.skip = 0;
        byte[] data = Ms.i().getStream("data/map/area.dat", -1);
        byte[] areaMap = Ms.i().createArray(data);
        byte[][] areaPic = Ms.i().create2Array(data);
        if (this.mapImg != null && areaMap[this.lastMap] == areaMap[this.mapNo]) {
            return;
        }
        Ms.i();
        Ms.skip = 0;
        this.moduleData = Ms.i().createShort2Array(Ms.i().getStream("data/map/" + ((int) areaMap[this.mapNo]) + ".data", -1), 1);
        this.mapImg = null;
        this.mapImg = new Image[areaPic[areaMap[this.mapNo]].length];
        for (byte i = 0; i < areaPic[areaMap[this.mapNo]].length; i = (byte) (i + 1)) {
            this.mapImg[i] = Ms.i().createImage("data/map/" + ((int) areaPic[areaMap[this.mapNo]][i]));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x010a, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x010c, code lost:
    
        if (r4 < r10) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x012a, code lost:
    
        r9.read(r5);
        dm.Ms.i();
        r0 = (short) dm.Ms.getNum(r5);
        r9.read(r5);
        r0 = r20.rows - 1;
        dm.Ms.i();
        r0 = (short) (r0 - dm.Ms.getNum(r5));
        r9.read(r0);
        dm.Ms.i();
        r0 = (short) dm.Ms.getNum(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0174, code lost:
    
        switch(r12) {
            case 1: goto L121;
            case 2: goto L122;
            case 3: goto L123;
            default: goto L125;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x017e, code lost:
    
        r0 = (short) (r4 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0188, code lost:
    
        r20.bottomData[r4] = (short) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0190, code lost:
    
        r0 = (short) (r0 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x019a, code lost:
    
        r20.bottomData[r0] = (short) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x01a2, code lost:
    
        r0 = (short) (r0 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x01ac, code lost:
    
        r20.bottomData[r0] = (short) r0;
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01b1, code lost:
    
        r0 = (short) (r4 + 3);
        r20.worldData[r0][r0] = (short) (r0 >> 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01c8, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x01d1, code lost:
    
        r0 = (short) (r4 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01db, code lost:
    
        r20.frontData[r4] = (short) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01e3, code lost:
    
        r0 = (short) (r0 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01ed, code lost:
    
        r20.frontData[r0] = (short) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01f5, code lost:
    
        r0 = (short) (r0 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01ff, code lost:
    
        r20.frontData[r0] = (short) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0201, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loadMapData(int r21) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: main.Map.loadMapData(int):void");
    }

    void drawMap(Graphics g2) {
        int tempLeftCol = this.leftCol;
        int tempTopRow = this.topRow;
        if (this.map_x >= 0) {
            this.leftCol = (short) 0;
            this.map_left = this.map_x;
        } else {
            this.leftCol = (short) ((-this.map_x) / 20);
            this.map_left = this.map_x % 20;
        }
        if (this.map_y >= 0) {
            this.topRow = (short) 0;
            this.map_top = this.map_y;
        } else {
            this.topRow = (short) ((-this.map_y) / 20);
            this.map_top = this.map_y % 20;
        }
        int left = this.leftCol * 20;
        int top = this.topRow * 20;
        if (this.firstDrawMap == 0) {
            this.firstDrawMap = (byte) 1;
            bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g2, 0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
        } else if (this.leftCol != tempLeftCol || this.topRow != tempTopRow) {
            g2.setClip(0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT);
            g2.copyArea(0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, (tempLeftCol - this.leftCol) * 20, (tempTopRow - this.topRow) * 20, 20);
            if (this.leftCol < tempLeftCol) {
                bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g2, 0, 0, (tempLeftCol - this.leftCol) * 20, Constants_H.OFF_HEIGHT, true);
            } else if (this.leftCol > tempLeftCol) {
                bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g2, Constants_H.OFF_WIDTH + ((tempLeftCol - this.leftCol) * 20), 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
            }
            if (this.topRow < tempTopRow) {
                bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g2, 0, 0, Constants_H.OFF_WIDTH, (tempTopRow - this.topRow) * 20, true);
            } else if (this.topRow > tempTopRow) {
                bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g2, 0, Constants_H.OFF_HEIGHT + ((tempTopRow - this.topRow) * 20), Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
            }
        }
        g.drawImage(GameRun.scrT, this.map_left, this.map_top, 20);
    }

    public void bkgroundToPaint(short[] bkgroundData, Image[] img, int screen_x, int screen_y, short[][] moduleData, Graphics gtem, int x1, int y1, int x2, int y2, boolean fillBlack) {
        short s;
        short s2;
        if (bkgroundData != null) {
            int screen_y2 = screen_y - 20;
            if (fillBlack) {
                gtem.setClip(x1, y1, x2 - x1, y2 - y1);
                gtem.setColor(this.bgColor);
                gtem.fillRect(x1, y1, x2 - x1, y2 - y1);
            }
            for (int i = 0; i < bkgroundData.length; i += 3) {
                if (bkgroundData[i + 2] >= 0) {
                    int bkdata_id = bkgroundData[i + 2] >> 3;
                    int bkdata_trans = bkgroundData[i + 2] & 3;
                    int realX = (bkgroundData[i] * 20) - screen_x;
                    int realY = (bkgroundData[i + 1] * 20) - screen_y2;
                    if (bkdata_trans % 2 == 1) {
                        s = moduleData[bkdata_id][4];
                        s2 = moduleData[bkdata_id][3];
                    } else {
                        s = moduleData[bkdata_id][3];
                        s2 = moduleData[bkdata_id][4];
                    }
                    if (realX + s >= x1 && realX <= x2 && realY >= y1 && realY - s2 <= y2) {
                        Ui.i().drawRegion(img[moduleData[bkdata_id][0]], moduleData[bkdata_id][1], moduleData[bkdata_id][2], moduleData[bkdata_id][3], moduleData[bkdata_id][4], realX, realY, 4 | 32, bkgroundData[i + 2] & 7, gtem);
                    }
                }
            }
        }
    }

    private void keySelectMenu() {
        if (!Ms.i().key_delay()) {
            if (Ms.i().key_S1_Num5()) {
                this.my.state = (byte) 13;
            } else if (Ms.i().key_Up_Down()) {
                this.gr.cur_a = Ms.i().select(this.gr.cur_a, 0, this.gr.action_str.length - 1);
            }
        }
    }

    private void drawNpcFace(int x, int y, int dir) {
        if (this.imgFace != null) {
            Ui.i().drawImage(this.imgFace, this.face_c + x, y, dir);
        }
        this.face_c = Ms.i().mathSpeedN(this.face_c, 0, 20, false);
    }

    public void initNpcFaceOne(String name) {
        if (name != null) {
            byte id = -1;
            this.faceDir = true;
            if (name.equals(Constants_H.NAME_TXT_0)) {
                id = 0;
                this.faceDir = false;
            } else if (name.equals(Constants_H.NAME_TXT_1) || name.equals(Constants_H.NAME_TXT_11)) {
                id = 1;
            } else if (name.equals(Constants_H.NAME_TXT_2)) {
                id = 2;
            } else if (name.equals(Constants_H.NAME_TXT_4)) {
                id = 3;
            } else if (name.equals(Constants_H.NAME_TXT_5) || name.equals(Constants_H.NAME_TXT_3)) {
                id = 4;
            } else if (name.equals(Constants_H.NAME_TXT_12)) {
                id = 5;
            } else if (name.equals(Constants_H.NAME_TXT_13)) {
                id = 6;
            }
            if (id > -1) {
                if (this.imgFace == null || this.faceLast != id) {
                    this.face_c = (short) (this.faceDir ? 50 : -50);
                    this.faceLast = id;
                    this.imgFace = null;
                    this.imgFace = Ms.i().createImage("data/face/" + ((int) id));
                    return;
                }
                return;
            }
            nullNpcFace();
        }
    }

    public void nullNpcFace() {
        this.imgFace = null;
    }

    public void initBrowImage() {
        if (this.brow == null) {
            this.brow = Ms.i().createSprite("data/face/brow", true);
        }
    }

    public void initWalkIco() {
        if (this.walkIco == null) {
            this.walkIco = Ms.i().createImageArray(3, "data/brow/w");
        }
    }

    private void drawCheck5(int id) {
        if (this.checkNpcT != -1 && this.my.state == 0) {
            drawHudong();
            if (this.checkNpcT >= 0 && this.npc[0][this.checkNpcT].other[6] == 0) {
                drawHudong();
                Ui.i().drawFrameOne(this.brow, this.brow.action(id, this.action_5, 0), this.map_x + this.npc[0][this.checkNpcT].x + 10, ((this.map_y + this.npc[0][this.checkNpcT].y) - 16) - 10, 0);
                byte b = (byte) (this.time_5 + 1);
                this.time_5 = b;
                if (b > this.brow.action(id, this.action_5, 1)) {
                    byte b2 = (byte) (this.action_5 + 1);
                    this.action_5 = b2;
                    if (b2 >= this.brow.aLength(id)) {
                        this.action_5 = (byte) 0;
                    }
                    this.time_5 = (byte) 0;
                }
            }
        }
    }

    private void initHudong() {
        this.hudong = Ms.i().createImage("data/brow/hudong");
    }

    private void drawHudong() {
        Ui.i().drawImage(this.hudong, Constants_H.WIDTH_H, Constants_H.HEIGHT - 30, 3);
    }

    private void drawBrow() {
        for (byte i = 0; i < this.npcList.length; i = (byte) (i + 1)) {
            byte id = this.npcList[i];
            if (id >= -1) {
                if (id == -1) {
                    cur_npc = this.my;
                } else {
                    cur_npc = this.npc[0][id];
                }
                if ((cur_npc.other[4] == 1 || cur_npc.other[4] == 2) && ((cur_npc.brow_type > -1 || cur_npc.other[6] != 0) && (id <= -1 || isNpcSrc(cur_npc.x, cur_npc.y)))) {
                    if (cur_npc.other[6] != 0) {
                        cur_npc.brow_type = cur_npc.other[6];
                    }
                    if (cur_npc.brow_action >= this.brow.aLength(cur_npc.brow_type)) {
                        if (cur_npc.other[6] != 0) {
                            cur_npc.brow_action = (byte) 0;
                        } else {
                            cur_npc.brow_type = (byte) -1;
                        }
                    }
                    Ui.i().drawFrameOne(this.brow, this.brow.action(cur_npc.brow_type, cur_npc.brow_action, 0), this.map_x + cur_npc.x + 14, ((this.map_y + cur_npc.y) - 15) - 10, 0);
                    Npc npc = cur_npc;
                    byte b = (byte) (npc.brow_time + 1);
                    npc.brow_time = b;
                    if (b > this.brow.action(cur_npc.brow_type, cur_npc.brow_action, 1)) {
                        Npc npc2 = cur_npc;
                        npc2.brow_action = (byte) (npc2.brow_action + 1);
                        cur_npc.brow_time = (byte) 0;
                    }
                }
            }
        }
    }

    public void initNpcAniOne(String sid, int id, int type) {
        npcSp[type][id] = Ms.i().createSprite("data/npc" + type + "/" + sid, type == 2 ? this.gr.isNpc2ImageType(Integer.parseInt(sid)) : true);
    }

    public void initNpcAni() {
        byte k;
        byte k2 = 0;
        byte[][] em = {new byte[100], new byte[5], new byte[60]};
        this.gr.initNidusMap(0);
        byte i = (byte) (this.npc.length - 1);
        while (i > -1) {
            byte j = (byte) (this.npc[i].length - 1);
            byte k3 = k2;
            while (j > -1) {
                em[this.npc[i][j].other[3] - 1][this.npc[i][j].other[2]] = 1;
                if (i == 0) {
                    this.npcList[j + 1] = j;
                    if (this.npc[i][j].other[8] == 1) {
                        k = (byte) (k3 + 1);
                        this.gr.nidusMap[k3] = j;
                        j = (byte) (j - 1);
                        k3 = k;
                    }
                }
                k = k3;
                j = (byte) (j - 1);
                k3 = k;
            }
            i = (byte) (i - 1);
            k2 = k3;
        }
        this.gr.initNidusMap(1);
        this.npcList[0] = -1;
        int length = this.item.length + this.npc[0].length;
        while (true) {
            byte i2 = (byte) length;
            if (i2 <= this.npc[0].length) {
                break;
            }
            this.npcList[i2] = (byte) (((-2) - i2) + this.npc[0].length + 1);
            length = i2 - 1;
        }
        initNpcAni_1(100, 0, em[0]);
        initNpcAni_1(5, 1, em[1]);
        initNpcAni_1(60, 2, em[2]);
        for (byte j2 = (byte) (this.npc[0].length - 1); j2 > -1; j2 = (byte) (j2 - 1)) {
            this.npc[0][j2].setNpcNum(npcSp[this.npc[0][j2].other[3] - 1][this.npc[0][j2].other[2]].aLength());
        }
    }

    private void initNpcAni_1(int length, int type, byte[] em) {
        for (int i = length - 1; i > 0; i--) {
            if (em[i] != 0) {
                if (npcSp[type][i] == null) {
                    initNpcAniOne(new StringBuilder().append(i).toString(), i, type);
                }
            } else {
                npcSp[type][i] = null;
            }
        }
    }

    private boolean isNpcSrc(int ax, int ay) {
        return this.map_x + ax >= -80 && this.map_x + ax <= Constants_H.WIDTH + 60 && this.map_y + ay >= -80 && this.map_y + ay <= Constants_H.HEIGHT + 60;
    }

    private void drawNpcAni(Npc[] npc) {
        if (npc != null) {
            for (byte i = 0; i < npc.length; i = (byte) (i + 1)) {
                if ((npc[i].other[4] == 1 || npc[i].other[4] == 2) && isNpcSrc(npc[i].x, npc[i].y)) {
                    drawNpcAniOne(npc, i);
                }
                runNpcAniOne(npc, i);
            }
        }
    }

    private void drawNMAni(Npc[] npc) {
        if (npc != null) {
            for (byte i = 0; i < this.npcList.length; i = (byte) (i + 1)) {
                byte id = this.npcList[i];
                if (id == -1) {
                    if (this.my.other[4] == 1 || this.my.other[4] == 2) {
                        drawMyAni(this.my, 0, this.map_x + this.my.x + 10, this.map_y + this.my.y + 19, this.my.other[7]);
                    }
                } else if (id < -1) {
                    Ms.i();
                    byte id2 = (byte) (Ms.abs(id) - 2);
                    if (isNpcSrc(this.item[id2][0] * 20, this.item[id2][1] * 20)) {
                        Ui.i().drawUi(this.item[id2][2] == 2 ? 55 : 54, this.map_x + (this.item[id2][0] * 20) + 10, this.map_y + (this.item[id2][1] * 20) + 20, 33, 0);
                    }
                } else {
                    if ((npc[id].other[4] == 1 || npc[id].other[4] == 2) && isNpcSrc(npc[id].x, npc[id].y)) {
                        if (npc[id].other[8] != 3 && !this.npcNameData[id].equals("路人")) {
                            g.drawImage(this.imgShadow, this.map_x + npc[id].x + 10, this.map_y + npc[id].y + 20, 33);
                        }
                        drawNpcAniOne(npc, id);
                    }
                    runNpcAniOne(npc, id);
                }
            }
        }
    }

    private void drawNpcAniOne(Npc[] npc, int i) {
        byte type = (byte) (npc[i].other[3] - 1);
        byte id = npc[i].other[2];
        byte action_id = npc[i].other[7];
        byte now_action = npc[i].now_action;
        if (action_id < 0) {
            npc[i].dir = (byte) 4;
            action_id = (byte) (-action_id);
        }
        if (npc[i].now_action >= npcSp[type][id].aLength(action_id)) {
            now_action = 0;
            npc[i].now_action = (byte) 0;
            if (npc[i].other[8] == -4) {
                npc[i].other[8] = 0;
                npc[i].other[4] = 0;
                return;
            } else if (!npc[i].bdir && setlastA(npc, i)) {
                drawNpcAniOne(npc, i);
                return;
            }
        }
        Ui.i().drawFrameOne(npcSp[type][id], npcSp[type][id].action(action_id, now_action, 0), this.map_x + npc[i].x + 10, this.map_y + npc[i].y + 19, npc[i].dir == 4 ? 1 : 0);
    }

    private void runNpcAniOne(Npc[] npc, int i) {
        byte type = (byte) (npc[i].other[3] - 1);
        byte id = npc[i].other[2];
        Ms.i();
        byte action_id = (byte) Ms.abs(npc[i].other[7]);
        if (npc[i].now_action >= npcSp[type][id].aLength(action_id)) {
            npc[i].now_action = (byte) 0;
            setlastA(npc, i);
        }
        Npc npc2 = npc[i];
        byte b = (byte) (npc2.now_time + 1);
        npc2.now_time = b;
        if (b >= npcSp[type][id].action(action_id, npc[i].now_action, 1)) {
            Npc npc3 = npc[i];
            npc3.now_action = (byte) (npc3.now_action + 1);
            npc[i].now_time = (byte) 0;
        }
    }

    private boolean setlastA(Npc[] npc, int i) {
        if (npc[i].lastAction == Byte.MAX_VALUE) {
            return false;
        }
        npc[i].other[7] = npc[i].lastAction;
        npc[i].lastAction = Byte.MAX_VALUE;
        return true;
    }

    public void drawMyAni(Npc my, int my_id, int x, int y, int action_id) {
        byte id = (byte) my_id;
        if (my.now_action >= npcSp[1][id].aLength(action_id)) {
            my.now_action = (byte) 0;
        }
        if (this.anole_type != 2 && this.anole_type != 4) {
            Ui.i().drawImage(this.imgShadow, x, y, 33);
        }
        Ui.i().drawFrameOne(npcSp[1][id], npcSp[1][id].action(action_id, my.now_action, 0), x, y, my.dir == 4 ? 1 : 0);
        byte b = (byte) (my.now_time + 1);
        my.now_time = b;
        if (b > npcSp[1][id].action(action_id, my.now_action, 1)) {
            my.now_action = (byte) (my.now_action + 1);
            my.now_time = (byte) 0;
        }
    }

    public void insertNpc() {
        if (this.npc != null) {
            for (byte i = 1; i < this.npcList.length; i = (byte) (i + 1)) {
                for (byte j = i; j > 0; j = (byte) (j - 1)) {
                    short y0 = getNpcListY(j);
                    short y1 = getNpcListY(j - 1);
                    if (y0 <= y1) {
                        if (y0 != y1 || (y0 == y1 && this.npcList[j - 1] == -1)) {
                            byte temp = this.npcList[j];
                            this.npcList[j] = this.npcList[j - 1];
                            this.npcList[j - 1] = temp;
                        }
                    }
                }
            }
        }
    }

    private short getNpcListY(int j) {
        if (this.npcList[j] != -1) {
            if (this.npcList[j] >= -1) {
                short y = this.npc[0][this.npcList[j]].y;
                return y;
            }
            byte[][] bArr = this.item;
            Ms.i();
            short y2 = (short) (bArr[Ms.abs(this.npcList[j]) - 2][1] * 20);
            return y2;
        }
        short y3 = (short) (this.my.y + (this.dir_select[this.my.dir][1] * this.my.speed));
        return y3;
    }

    private void initMoveMy() {
        this.my.frame_c = this.my.frame_num;
        this.my.setActionNo(true);
        if (this.my.state == 0 && this.gr.monPro.length > 0) {
            meetGrass();
        }
    }

    private void runMove() {
        if (this.my.ix == -1 && this.my.iy == -1) {
            runBoat();
        } else {
            runSeek(this.my, false);
        }
        oneMove(this.my, -1);
        for (byte j = 0; j < 3; j = (byte) (j + 2)) {
            for (byte i = 0; i < this.npc[j].length; i = (byte) (i + 1)) {
                if (this.npc[j][i].other[4] == 1 || this.npc[j][i].other[4] == 2) {
                    if (this.npc[j][i].other[8] >= 5) {
                        runAutoMoveNpc(this.npc[j][i], i);
                    } else if (this.npc[j][i].ix != -1 || this.npc[j][i].iy != -1) {
                        runSeek(this.npc[j][i], true);
                    }
                    oneMove(this.npc[j][i], i);
                }
            }
        }
        insertNpc();
    }

    private void runAutoMoveNpc(Npc npc, int i) {
        if (this.my.state == 1 && this.get_meet == i) {
            byte[] bArr = npc.other;
            Ms.i();
            bArr[7] = (byte) (((Ms.abs(npc.other[7]) / 3) * 3) + (this.my.dir < 4 ? this.my.dir - 1 : this.my.dir - 2));
            if (this.my.dir == 3) {
                npc.other[7] = (byte) (-npc.other[7]);
                return;
            } else {
                npc.dir = (byte) 3;
                return;
            }
        }
        if (initAuto(npc, 10)) {
            if (!npc.b_auto) {
                runAutoY(npc, this.gr.mapMove[((npc.other[8] - 5) * 2) + 1]);
            } else {
                runAutoX(npc, this.gr.mapMove[(npc.other[8] - 5) * 2]);
            }
        }
    }

    private boolean initAuto(Npc npc, int sleep) {
        if (npc.timeMove == 0) {
            if (npc.frame_c != -1) {
                return false;
            }
            Ms.i();
            npc.b_auto = Ms.getRandom(100) < 50;
            Ms.i();
            if (Ms.getRandom(100) < 50) {
                Ms.i();
                npc.timeMove = (byte) (-(Ms.getRandom(sleep) + 20));
                npc.setActionNo(false);
                return false;
            }
        } else if (npc.timeMove < 0) {
            npc.timeMove = (byte) (npc.timeMove + 1);
            return false;
        }
        return true;
    }

    private boolean isAuto_canMove(Npc _npc, int sx, int sy) {
        return (checkWorld(_npc.x, _npc.y, sx, sy, false) == 1 || Ms.i().isRect(_npc.x + sx, _npc.y + sy, 19, 19, this.my.x, this.my.y, 19, 19)) ? false : true;
    }

    private void runAutoY(Npc _npc, int w) {
        if (_npc.timeMove == 0 && _npc.frame_c == -1) {
            Ms.i();
            _npc.dir = Ms.getRandom(100) < 50 ? (byte) 1 : (byte) 2;
            short t = _npc.dir == 1 ? (short) (_npc.y - (_npc.other[1] * 20)) : (short) (((_npc.other[1] + w) * 20) - _npc.y);
            if (t > 20) {
                Ms.i();
                _npc.timeMove = (byte) (Ms.getRandom(((t - 20) / _npc.speed) + 1) + (20 / _npc.speed));
                return;
            } else {
                _npc.timeMove = (byte) (t / _npc.speed);
                return;
            }
        }
        if (_npc.timeMove <= 0 || _npc.frame_c >= 1) {
            return;
        }
        if (isAuto_canMove(_npc, 0, _npc.dir == 1 ? -_npc.speed : _npc.speed)) {
            _npc.setSpeedXY(0, _npc.dir == 1 ? -_npc.speed : _npc.speed);
            _npc.timeMove = (byte) (_npc.timeMove - 1);
            _npc.frame_c = (byte) 1;
            _npc.setActionNo(true);
            return;
        }
        _npc.timeMove = Constants_H.SMS_PAUSE;
        _npc.frame_c = (byte) -1;
        _npc.setActionNo(false);
    }

    private void runAutoX(Npc _npc, int w) {
        if (_npc.timeMove == 0) {
            Ms.i();
            _npc.dir = Ms.getRandom(100) < 50 ? (byte) 3 : (byte) 4;
            short t = _npc.dir == 3 ? (short) (_npc.x - (_npc.other[0] * 20)) : (short) (((_npc.other[0] + w) * 20) - _npc.x);
            if (t > 20) {
                Ms.i();
                _npc.timeMove = (byte) (Ms.getRandom(((t - 20) / _npc.speed) + 1) + (20 / _npc.speed));
                return;
            } else {
                _npc.timeMove = (byte) (t / _npc.speed);
                return;
            }
        }
        if (_npc.timeMove <= 0 || _npc.frame_c >= 1) {
            return;
        }
        if (isAuto_canMove(_npc, _npc.dir == 3 ? -_npc.speed : _npc.speed, 0)) {
            _npc.setSpeedXY(_npc.dir == 3 ? -_npc.speed : _npc.speed, 0);
            _npc.timeMove = (byte) (_npc.timeMove - 1);
            _npc.frame_c = (byte) 1;
            _npc.setActionNo(true);
            return;
        }
        _npc.timeMove = Constants_H.SMS_PAUSE;
        _npc.frame_c = (byte) -1;
        _npc.setActionNo(false);
    }

    private void runSeek(Npc npc_, boolean b_who) {
        boolean bb;
        boolean bb2 = npc_.b_check;
        short x_ = (short) (npc_.ix * 20);
        short y_ = (short) (npc_.iy * 20);
        if (npc_.x == x_ && npc_.y == y_) {
            if (npc_.frame_c == -1) {
                npc_.iy = (byte) -1;
                npc_.ix = (byte) -1;
                if (b_who) {
                    npc_.setIxIy_npc();
                } else {
                    npc_.speed = getMySpeed();
                }
                if (npc_.bdir) {
                    npc_.other[7] = npc_.lastAction;
                    npc_.dir = npc_.lastAction < 0 ? (byte) 4 : (byte) 3;
                    npc_.setLastAction(false, 127);
                    return;
                }
                return;
            }
            return;
        }
        if (npc_.frame_c < 1) {
            if (bb2) {
                bb = npc_.x != x_;
            } else {
                bb = npc_.y == y_;
            }
            if (bb) {
                if ((npc_.x > x_ && npc_.x - npc_.speed < x_) || (npc_.x < x_ && npc_.x + npc_.speed > x_)) {
                    npc_.setSpeedXY(x_ - npc_.x, 0);
                } else {
                    npc_.setSpeedXY(npc_.x > x_ ? -npc_.speed : npc_.speed, 0);
                }
                if (!npc_.bdir) {
                    npc_.dir = npc_.x > x_ ? (byte) 3 : (byte) 4;
                }
            } else {
                if ((npc_.y > y_ && npc_.y - npc_.speed < y_) || (npc_.y < y_ && npc_.y + npc_.speed > y_)) {
                    npc_.setSpeedXY(0, y_ - npc_.y);
                } else {
                    npc_.setSpeedXY(0, npc_.y > y_ ? -npc_.speed : npc_.speed);
                }
                if (!npc_.bdir) {
                    npc_.dir = npc_.y > y_ ? (byte) 1 : (byte) 2;
                }
            }
            npc_.frame_c = npc_.frame_num;
            npc_.setActionNo(true);
        }
    }

    private void drawSrcEffect() {
        int i;
        int WIDTH = Constants_H.WIDTH__;
        int HEIGHT = Constants_H.HEIGHT__;
        if (this.srcFlash_c > 0) {
            byte b = this.srcFlash_c;
            this.srcFlash_c = (byte) (b - 1);
            if (b % 2 == 0) {
                Ui.i().fillRect(16777215, 0, 0, WIDTH, HEIGHT);
            }
        }
        if (this.bSrc) {
            int SRC_BATTLE_H = Constants_H.SRC_BATTLE_H__;
            g.setColor(0);
            g.fillRect(0, (this.black_width - SRC_BATTLE_H) - this.bSrc_c, WIDTH, SRC_BATTLE_H);
            g.fillRect(0, (HEIGHT - this.black_width) + this.bSrc_c, WIDTH, SRC_BATTLE_H);
        }
        if (this.my.state == 22) {
            Graphics graphics = g;
            if (this.eventGoing == 2) {
                int i2 = 25 + 4;
                i = (HEIGHT - (this.gr.about_d.length * 29)) >> 1;
            } else {
                i = 45;
            }
            drawBlackSRC(graphics, i, this.eventGoing == 2);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000e. Please report as an issue. */
    public boolean initSrcEffect(int mode) {
        int SRC_BATTLE_H = Constants_H.SRC_BATTLE_H__;
        this.my.state = (byte) 10;
        switch (mode) {
            case 0:
            case 1:
            case 2:
                this.bSrc_c = (short) 0;
                this.black_width = (short) (mode == 1 ? SRC_BATTLE_H : 0);
                this.bSrc = mode == 1;
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                this.bSrc = true;
                if (this.bSrc_c == 0) {
                    if (mode == 6 || mode == 5) {
                        this.bSrc_c = (short) -40;
                        this.black_width = (short) (mode == 5 ? 40 : 0);
                    } else {
                        short s = (short) (mode == 4 ? SRC_BATTLE_H : 40);
                        this.bSrc_c = s;
                        this.black_width = s;
                    }
                }
                this.bSrc_c = Ms.i().mathSpeedN(this.bSrc_c, 0, 12, false);
                if (this.bSrc_c == 0) {
                    this.bSrc = mode != 6;
                    return true;
                }
            default:
                return false;
        }
    }

    private void initCloud() {
        if (this.mapNo == 24 || this.mapNo == 25 || this.mapNo == 26 || this.mapNo == 49 || this.mapNo == 50) {
            if (this.imgCloud == null) {
                this.imgCloud = Ms.i().createImage("data/cloud");
                this.cloud = null;
                this.cloud = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 4, 3);
            }
            for (byte i = 0; i < this.cloud.length; i = (byte) (i + 1)) {
                addCloud(i);
            }
            return;
        }
        this.cloud = null;
        this.imgCloud = null;
    }

    private void drawCloud() {
        if (this.imgCloud != null) {
            for (byte i = 0; i < this.cloud.length; i = (byte) (i + 1)) {
                Ui.i().drawImage(this.imgCloud, this.map_x + this.cloud[i][0], this.map_y + this.cloud[i][1], 0);
            }
            for (byte i2 = 0; i2 < this.cloud.length; i2 = (byte) (i2 + 1)) {
                if (isNpcSrc(this.cloud[i2][0], this.cloud[i2][1])) {
                    short[] sArr = this.cloud[i2];
                    sArr[0] = (short) (sArr[0] - this.cloud[i2][2]);
                } else {
                    addCloud(i2);
                }
            }
        }
    }

    private void addCloud(int i) {
        short[] sArr = this.cloud[i];
        int i2 = (this.leftCol * 20) + Constants_H.WIDTH;
        Ms.i();
        sArr[0] = (short) (i2 + Ms.getRandom(Constants_H.WIDTH_H));
        short[] sArr2 = this.cloud[i];
        int i3 = (this.topRow * 20) + 20 + 2;
        Ms.i();
        sArr2[1] = (short) (i3 + ((Ms.getRandom(25) + 55) * i));
        short[] sArr3 = this.cloud[i];
        Ms.i();
        sArr3[2] = (short) (Ms.getRandom(3) + 1);
    }

    private void drawMapRect(Graphics g2) {
        g2.setColor(0);
        for (byte i = 0; i < this.gr.mapRect.length; i = (byte) (i + 1)) {
            if (!Ms.i().isRect(this.my.x, this.my.y, 19, 19, this.gr.mapRect[i][0] * 20, this.gr.mapRect[i][1] * 20, ((this.gr.mapRect[i][2] - this.gr.mapRect[i][0]) + 1) * 20, ((this.gr.mapRect[i][3] - this.gr.mapRect[i][1]) + 1) * 20)) {
                for (byte j = 4; j < this.gr.mapRect[i].length; j = (byte) (j + 4)) {
                    g2.fillRect(this.map_x + (this.gr.mapRect[i][j] * 20), this.map_y + (this.gr.mapRect[i][j + 1] * 20), ((this.gr.mapRect[i][j + 2] - this.gr.mapRect[i][j]) + 1) * 20, ((this.gr.mapRect[i][j + 3] - this.gr.mapRect[i][j + 1]) + 1) * 20);
                }
            }
        }
    }

    private void initBoat(int _select) {
        this.my.state = (byte) 9;
        this.anole_type = (byte) 5;
        setAnole();
        this.boatSelect = (byte) _select;
        this.gr.cur_a = (byte) 0;
        this.my.setIXY(this.boatCourse[this.boatSelect][this.gr.cur_a], this.boatCourse[this.boatSelect][this.gr.cur_a + 1]);
    }

    private void runBoat() {
        if (this.boatSelect != -1 && this.my.ix == -1 && this.my.iy == -1) {
            this.my.state = (byte) 9;
            GameRun gameRun = this.gr;
            byte b = (byte) (gameRun.cur_a + 2);
            gameRun.cur_a = b;
            if (b >= this.boatCourse[this.boatSelect].length) {
                this.boatSelect = (byte) -1;
                this.my.state = (byte) 0;
                this.anole_type = (byte) -1;
                setAnole();
                return;
            }
            this.checkType = checkIfOther(this.door, this.my.x, this.my.y);
            if (this.checkType != -1) {
                this.my.state = (byte) 5;
                this.get_meet = this.checkType;
            }
            this.my.setIXY(this.boatCourse[this.boatSelect][this.gr.cur_a], this.boatCourse[this.boatSelect][this.gr.cur_a + 1]);
        }
    }

    public void setMapMusic(boolean bb) {
        Sound.i().setMusicId(this.gr.musicNo[this.mapNo]);
        Sound.i().setMusic(bb);
    }

    public synchronized void checkRegWhere0(int i) {
        this.isNeedWait = true;
        SMSSender.i(this.gr).go(2, true);
        SMSSender.i(this.gr).run();
        if (this.isNeedWait) {
            try {
                System.out.println("wait() start");
                wait();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("wait() over");
        }
    }

    public synchronized void setRegState(boolean isSuccess) {
        System.out.println("setRegState() notifyAll start isSuccess= " + isSuccess);
        this.isNeedWait = false;
        notifyAll();
        System.out.println("setRegState() notifyAll over");
    }
}
