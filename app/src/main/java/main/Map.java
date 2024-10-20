package main.Map;
import main.Key_H;
import dm.Sprite;
import main.GameRun;
import java.lang.Object;
import dm.Npc;
import java.lang.System;
import main.Constants_H;
import dm.Ms;
import java.lang.String;
import dm.Ui;
import android.util.Log;
import java.lang.StringBuffer;
import main.GameRun_F;
import main.PointerKey;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import main.MainCanvas;
import java.lang.StringBuilder;
import java.io.ByteArrayOutputStream;
import java.lang.Exception;
import java.lang.Short;
import java.lang.Class;
import java.lang.reflect.Array;
import main.SMSSender;
import java.io.DataInputStream;
import java.io.InputStream;
import com.android.Util.AndroidUtil;
import javax.microedition.lcdui.Font;
import dm.Monster;
import java.io.PrintStream;
import minigame.Mg;
import dm.Sound;
import java.lang.Byte;
import java.lang.Integer;

public class Map implements Key_H	// class@000166 from classes.dex
{
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
    private static Npc cur_npc;
    private static Graphics g;
    static Sprite[][] npcSp;

    static {
       Sprite[][] spriteArray = new Sprite[][3];
       Map.npcSp = spriteArray;
    }
    public void Map(GameRun gameRun){
       super();
       Npc[][] npcArray = new Npc[][3];
       this.npc = npcArray;
       this.srcNpcNo = -1;
       this.sleep_count = 0;
       this.step_MEET = 4;
       this.event_state = 0;
       byte[][] uobyteArray = new byte[][70];
       this.mapTemp = uobyteArray;
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
       uobyteArray = new byte[][5];
       byte[] uobyteArray1 = new byte[2];
       uobyteArray[0] = uobyteArray1;
       uobyteArray1 = new byte[2];
       uobyteArray1[1] = -1;
       uobyteArray[1] = uobyteArray1;
       uobyteArray1 = new byte[2];
       uobyteArray1[1] = 1;
       uobyteArray[2] = uobyteArray1;
       byte[] uobyteArray2 = new byte[2];
       uobyteArray2[0] = -1;
       uobyteArray[3] = uobyteArray2;
       uobyteArray2 = new byte[2];
       uobyteArray2[0] = 1;
       uobyteArray[4] = uobyteArray2;
       this.dir_select = uobyteArray;
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
    private void addCloud(int i){
       Ms.i();
       this.cloud[i][0] = (short)(((this.leftCol * 20) + Constants_H.WIDTH) + Ms.getRandom(Constants_H.WIDTH_H));
       Ms.i();
       this.cloud[i][1] = (short)((((this.topRow * 20) + 20) + 2) + ((Ms.getRandom(25) + 55) * i));
       Ms.i();
       this.cloud[i][2] = (short)(Ms.getRandom(3) + 1);
    }
    private void canMove(int temp_xspeed,int temp_yspeed){
       int i = 5;
       this.my.speed_x = (byte)temp_xspeed;
       if (((this.my.speed_y = (byte)temp_yspeed)) >= 0 && ((((this.my.x + this.my.speed_x) + 19)) < (this.cols * 20) && (((this.my.y + this.my.speed_y)) >= 0 && (((this.my.y + this.my.speed_y) + 19)) < (this.rows * 20)))) {
          this.roadType = this.checkMap(this.my.x, this.my.y, this.my.speed_x, this.my.speed_y);
          if (this.roadType == null) {
             this.initMoveMy();
          }else if(this.checkMoveOff(this.checkNpcT)){
             this.initMoveMy();
          }else if(this.checkNpcT != -1 && !this.isCheckNpcOff()){
             Ms.i().keyRelease();
             this.setMoveStop_m();
          }else {
             this.roadType = this.isMapChenk(this.roadType);
             if (this.roadType == -1) {
                this.moveOff(3, 1, (- this.my.speed));
             }else if(this.roadType == -2){
                this.moveOff(4, 2, this.my.speed);
             }else {
                this.checkAnole();
             }
          }
       }else {
          this.setMoveStop_m();
          this.checkType = this.checkIfOther(this.door, this.my.x, this.my.y);
          if (this.checkType != -1 && (!this.door[this.checkType][i] && this.map_key == this.door[this.checkType][2])) {
             this.my.state = i;
             this.get_meet = this.checkType;
          }
       }
       return;
    }
    private void checkAnole(){
       this.checkType = this.checkWorld(this.my.x, this.my.y, this.my.speed_x, this.my.speed_y, true);
       if (this.checkType == 2) {
          if (!this.isCheckAnole(4)) {
          label_0031 :
             Ms.i().keyRelease();
             this.setMoveStop_m();
          }
       }else if(this.checkType == 3){
          if (!this.isCheckAnole(0)) {
             goto label_0031 ;
          }
       }else if(this.checkType == 4){
          if (!this.isCheckAnole(2)) {
          }
       }else if(this.checkType == null && this.anole_type == 4){
          this.anole_type = (this.anole_type != 3 && this.isAnoleType(3))? 3: -1;
          this.setAnole();
          this.initMoveMy();
       }else {
          goto label_0031 ;
       }
       return;
    }
    private byte checkIfNpc(Npc[] npc,int ix,int iy){
       int b;
       byte i = (byte)(npc.length - 1);
       while (true) {
          if (i <= -1) {
             b = -1;
             break ;
          }else if(Ms.i().isRect(ix, iy, 19, 19, npc[i].x, npc[i].y, 20, 20) && (npc[i].other[4] == 1 && npc[i].other[4] != 3)){
             b = i;
             break ;
          }else {
             b = i - 1;
             i = (byte)b;
          }
       }
       return b;
    }
    private byte checkIfOther(byte[][] data,int ix,int iy){
       int b;
       byte i = (byte)(data.length - 1);
       while (true) {
          if (i <= -1) {
             b = -1;
             break ;
          }else {
             int ix = data[i][0] * 20;
             int ix1 = data[i][1] * 20;
             if (Ms.i().isRect(ix, iy, 19, 19, ix, ix1, 20, 20)) {
                b = i;
                break ;
             }else {
                b = i - 1;
                i = (byte)b;
             }
          }
       }
       return b;
    }
    private byte checkMap(int A_X,int A_Y,int _speed_x,int _speed_y){
       byte b1;
       int i = 1;
       byte b = -1;
       this.checkNpcT = b;
       this.checkType = this.checkIfOther(this.item, (A_X + _speed_x), (A_Y + _speed_y));
       if (this.checkType != b) {
          this.checkNpcT = -2;
          b1 = i;
       }else if(((A_X + _speed_x)) >= 0 && (((A_X + _speed_x)) < (this.cols * 20) && (((A_Y + _speed_y)) >= 0 && ((A_Y + _speed_y)) < (this.rows * 20)))){
          this.checkType = this.checkIfNpc(this.npc[0], (A_X + _speed_x), (A_Y + _speed_y));
          if (this.checkType != b) {
             if (!this.npcNameData[this.checkType].equals("\x8d\x02\x4e\x02") || this.npc[0][this.checkType].other[5] > 0) {
                this.checkNpcT = this.checkType;
             }
             b1 = i;
          }else {
             this.checkType = this.checkIfOther(this.door, (A_X + _speed_x), (A_Y + _speed_y));
             if (this.checkType != b && (this.door[this.checkType][5] == 2 && this.map_key != this.door[this.checkType][2])) {
                this.my.state = 5;
                this.get_meet = this.checkType;
                b1 = 0;
             }else {
                b1 = this.checkWorld(A_X, A_Y, _speed_x, _speed_y, 0);
             }
          }
       }else {
          b1 = i;
       }
       return b1;
    }
    private boolean checkMoveOff(int npcid){
       byte oxl;
       byte oxr;
       byte oyl;
       byte oyr;
       Map tmy;
       Npc speed_x;
       boolean b;
       byte b1;
       int i = 0;
       if (npcid > -1) {
          oxl = (byte)((this.npc[i][npcid].x + 20) - this.my.x);
          oxr = (byte)((this.npc[i][npcid].x - this.my.x) - 20);
          oyl = (byte)((this.npc[i][npcid].y + 20) - this.my.y);
          oyr = (byte)((this.npc[i][npcid].y - this.my.y) - 20);
          if (this.my.speed_x < null && oxl) {
             tmy = this.my;
             speed_x = (oxl < this.my.speed_x)? this.my.speed_x: oxl;
             tmy.speed_x = speed_x;
             b = true;
          }else if(this.my.speed_x > null && oxr){
             tmy = this.my;
             b1 = (oxr < this.my.speed_x)? oxr: this.my.speed_x;
             tmy.speed_x = b1;
             b = true;
          }else if(this.my.speed_y < null && oyl){
             tmy = this.my;
             speed_x = (oyl < this.my.speed_y)? this.my.speed_y: oyl;
             tmy.speed_y = speed_x;
             b = true;
          }else if(this.my.speed_y > null && oyr){
             tmy = this.my;
             b1 = (oyr < this.my.speed_y)? oyr: this.my.speed_y;
             tmy.speed_y = b1;
             b = true;
          }else {
          label_0133 :
             b = i;
          }
       }else {
          oxl = this.my.getIx_off();
          oxr = (byte)(20 - this.my.getIx_off());
          oyl = this.my.getIy_off();
          oyr = (byte)(20 - this.my.getIy_off());
          if (this.my.speed_x != null && oxl) {
             if (this.my.speed_x < null) {
                tmy = this.my;
                speed_x = (((- oxl)) < this.my.speed_x)? this.my.speed_x: - oxl;
                tmy.speed_x = (byte)speed_x;
             }else {
                tmy = this.my;
                b1 = (oxr < this.my.speed_x)? oxr: this.my.speed_x;
                tmy.speed_x = b1;
             }
             b = true;
          }else if(this.my.speed_y != null && oyl){
             if (this.my.speed_y < null) {
                tmy = this.my;
                speed_x = (((- oyl)) < this.my.speed_y)? this.my.speed_y: - oyl;
                tmy.speed_y = (byte)speed_x;
             }else {
                tmy = this.my;
                b1 = (oyr < this.my.speed_y)? oyr: this.my.speed_y;
                tmy.speed_y = b1;
             }
             b = true;
          }else {
             goto label_0133 ;
          }
       }
       return b;
    }
    private byte checkWorld(int A_X,int A_Y,int _speed_x,int _speed_y,boolean mode){
       int ix;
       byte iy;
       byte ix1;
       byte i = 0;
       byte check_n = 1;
       if (!_speed_x && ((ix = A_X % 20) || (!_speed_y && (ix = A_Y % 20)))) {
          check_n = 2;
       }
       while (true) {
          if (i >= check_n) {
             ix = 0;
             break ;
          }else if(!_speed_y){
             ix = i * 20;
             ix = ix + A_Y;
             ix = ix / 20;
             iy = (byte)ix;
             if (_speed_x >= 0) {
                ix = A_X + _speed_x;
                ix = ix + 19;
                ix = ix / 20;
             }else {
                ix = A_X + _speed_x;
                ix = ix / 20;
             }
             ix1 = (byte)ix;
          }else {
             ix = i * 20;
             ix = ix + A_X;
             ix = ix / 20;
             ix1 = (byte)ix;
             if (_speed_y >= 0) {
                ix = A_Y + _speed_y;
                ix = ix + 19;
                ix = ix / 20;
             }else {
                ix = A_Y + _speed_y;
                ix = ix / 20;
             }
             iy = (byte)ix;
          }
          if (mode) {
             if (this.worldData[ix1][iy]) {
                ix = (byte)this.worldData[ix1][iy];
                break ;
             }
          }else if(this.isCan_not_pass(ix1, iy)){
             ix = 1;
             break ;
          }
          ix = i + 1;
          i = (byte)ix;
       }
       return ix;
    }
    private void configureNpc(){
       Sprite[] spriteArray = new Sprite[100];
       Map.npcSp[0] = spriteArray;
       spriteArray = new Sprite[5];
       Map.npcSp[1] = spriteArray;
       spriteArray = new Sprite[60];
       Map.npcSp[2] = spriteArray;
    }
    private void createMap(){
       this.loadMapModuleAndImage();
       this.loadMapData(this.mapNo);
    }
    private void dialog(String npcName){
       int FONT_H = 25;
       int WIDTH = Constants_H.WIDTH__;
       int HEIGHT = Constants_H.HEIGHT__;
       byte x = 10;
       int i = HEIGHT - 8;
       int i1 = FONT_H * 2;
       int y = i - i1;
       i = FONT_H * 2;
       int height = i + 11;
       int line_c = 0;
       int i2 = HEIGHT - height;
       i2 = i2 - 4;
       i1 = WIDTH - 4;
       int i3 = height + 4;
       Ui.i().drawKuang(4, i2, i1, i3);
       if (npcName != null) {
          i = (this.faceDir != null)? WIDTH - 50: 50;
          i1 = (this.faceDir != null)? (HEIGHT - height) - 4: ((HEIGHT - height) - 4) - FONT_H;
          this.drawNpcFace(i, i1, (1 | 0x20));
          Ui.i().drawKuang(0, ((y - height) + FONT_H), (Ms.i().getStringWidth(npcName) + 16), (FONT_H + 8));
          Ui.i().drawString(npcName, 8, (((y - height) + 2) + FONT_H), 0, 9, 1);
          Log.e("sk", "dialog");
       }
       while (line_c < 2 && (i = this.dialog_no + line_c) < this.dialog.length) {
          i2 = this.dialog_no + line_c;
          i2 = y - 2;
          int i4 = line_c * FONT_H;
          i4 = i4 + i2;
          Ui.i().drawStringColor(this.dialog[i2].toString(), x, i4, -1, 1);
          line_c++;
       }
       return;
    }
    private void drawAnoleSel(){
       byte j;
       int ix;
       byte c;
       byte h = 25;
       this.gr.cur_a = (byte)Ms.i().mathSpeedN(this.gr.cur_a, ((h * 2) + 12), 8, false);
       Ui.i().drawK1(0, ((Constants_H.HEIGHT - this.gr.cur_a) - 2), 119, ((h + 4) + 2), 2);
       Ui.i().drawK2(0, (((Constants_H.HEIGHT + h) + 4) - this.gr.cur_a), Constants_H.WIDTH, (h + 8), 0);
       byte i = 0;
       while (i < 5) {
          if (!this.isAnoleType(i)) {
             c = 6;
             ix = i + 70;
             j = (byte)ix;
          }else if(i == this.anoleSel){
             ix = 1;
          }else {
             ix = 0;
          }
          c = (byte)ix;
          if (i == this.anole_type) {
             j = 69;
          }else if(i == this.anoleSel){
             ix = i + 5;
          }else {
             ix = i;
          }
          j = (byte)ix;
          int ix1 = Constants_H.WIDTH * i;
          ix1 = ix1 / 6;
          ix1 = ix1 + 42;
          int ix2 = Constants_H.HEIGHT + h;
          ix2 = ix2 + 8;
          ix2 = ix2 - this.gr.cur_a;
          Ui.i().drawK0(ix1, ix2, 20, 20, c);
          ix = Constants_H.WIDTH * i;
          ix = ix / 6;
          ix = ix + 42;
          int ix3 = ix + 10;
          ix = Constants_H.HEIGHT + h;
          ix = ix + 8;
          ix = ix - this.gr.cur_a;
          int ix4 = ix + 18;
          Ui.i().drawUi(j, ix3, ix4, 33, 0);
          ix1 = Constants_H.WIDTH * i;
          ix1 = ix1 / 6;
          ix1 = ix1 + 42;
          ix2 = Constants_H.HEIGHT + h;
          ix2 = ix2 + 8;
          ix2 = ix2 - this.gr.cur_a;
          if (this.pkey.isSelect(ix1, ix2, 20, 20)) {
             if (this.anoleSel == i) {
                this.pkey.setKeySoftkey1();
             }else {
                this.anoleSel = i;
             }
          }
          ix = i + 1;
          i = (byte)ix;
       }
       if (this.anoleSel == this.anole_type) {
          j = 0;
       }else if(this.isAnoleType(this.anoleSel)){
          ix = this.anoleSel + 1;
       }else {
          ix = 6;
       }
       j = (byte)ix;
       Log.e("sk", "drawAnoleSel");
       Ui.i().drawString(this.gr.about_a[j], 60, ((Constants_H.HEIGHT - this.gr.cur_a) - 2), 17, 1, 2);
       Ui.i().drawK4(((((this.anoleSel * Constants_H.WIDTH) / 6) + 41) + (this.gr.cur_b / 3)), ((((Constants_H.HEIGHT + h) + 7) - this.gr.cur_a) + (this.gr.cur_b / 3)), (22 - ((this.gr.cur_b / 3) << 1)), (22 - ((this.gr.cur_b / 3) << 1)));
       Map map = this.gr;
       GameRun_F cur_b = map.cur_b;
       map.cur_b = (byte)(cur_b + 1);
       if (cur_b > 4) {
          this.gr.cur_b = 0;
       }
       Ui.i().drawYesNo_(false, true);
       return;
    }
    private void drawBrow(){
       byte id;
       byte i = 0;
       while (i < this.npcList.length) {
          if ((id = this.npcList[i]) >= -1) {
             Map.cur_npc = (id == -1)? this.my: this.npc[0][id];
             if (Map.cur_npc.other[4] == 1 || (Map.cur_npc.other[4] == 2 && (Map.cur_npc.brow_type > -1 || (Map.cur_npc.other[6] && (id <= -1 || this.isNpcSrc(Map.cur_npc.x, Map.cur_npc.y)))))) {
                if (Map.cur_npc.other[6]) {
                   Map.cur_npc.brow_type = Map.cur_npc.other[6];
                }
                if (Map.cur_npc.brow_action >= this.brow.aLength(Map.cur_npc.brow_type)) {
                   if (Map.cur_npc.other[6]) {
                      Map.cur_npc.brow_action = 0;
                   }else {
                      Map.cur_npc.brow_type = -1;
                   }
                }
                int ix1 = this.map_x + Map.cur_npc.x;
                ix1 = ix1 + 14;
                int ix2 = this.map_y + Map.cur_npc.y;
                ix2 = ix2 - 15;
                ix2 = ix2 - 10;
                Ui.i().drawFrameOne(this.brow, this.brow.action(Map.cur_npc.brow_type, Map.cur_npc.brow_action, 0), ix1, ix2, 0);
                Npc cur_npc = Map.cur_npc;
                int ix3 = cur_npc.brow_time + 1;
                ix3 = (byte)ix3;
                cur_npc.brow_time = ix3;
                if (ix3 > this.brow.action(Map.cur_npc.brow_type, Map.cur_npc.brow_action, 1)) {
                   cur_npc = Map.cur_npc;
                   ix3 = cur_npc.brow_action + 1;
                   cur_npc.brow_action = (byte)ix3;
                   Map.cur_npc.brow_time = 0;
                }
             }
          }
          int ix = i + 1;
          i = (byte)ix;
       }
       return;
    }
    private void drawCheck5(int id){
       if (this.checkNpcT != -1 && this.my.state == null) {
          this.drawHudong();
          if (this.checkNpcT >= null && !this.npc[0][this.checkNpcT].other[6]) {
             this.drawHudong();
             Ui.i().drawFrameOne(this.brow, this.brow.action(id, this.action_5, 0), ((this.map_x + this.npc[0][this.checkNpcT].x) + 10), (((this.map_y + this.npc[0][this.checkNpcT].y) - 16) - 10), 0);
             byte b = (byte)(this.time_5 + 1);
             this.time_5 = b;
             if (b > this.brow.action(id, this.action_5, 1)) {
                b = (byte)(this.action_5 + 1);
                this.action_5 = b;
                if (b >= this.brow.aLength(id)) {
                   this.action_5 = 0;
                }
                this.time_5 = 0;
             }
          }
       }
       return;
    }
    private void drawCloud(){
       int ix;
       if (this.imgCloud != null) {
          byte i = 0;
          while (i < this.cloud.length) {
             int ix2 = this.map_x + this.cloud[i][0];
             int ix3 = this.map_y + this.cloud[i][1];
             Ui.i().drawImage(this.imgCloud, ix2, ix3, 0);
             ix = i + 1;
             i = (byte)ix;
          }
          i = 0;
          while (i < this.cloud.length) {
             if (!this.isNpcSrc(this.cloud[i][0], this.cloud[i][1])) {
                this.addCloud(i);
             }else {
                object oobject = this.cloud[i];
                int ix1 = oobject[0] - this.cloud[i][2];
                oobject[0] = (short)ix1;
             }
             ix = i + 1;
             i = (byte)ix;
          }
       }
       return;
    }
    private void drawHudong(){
       Ui.i().drawImage(this.hudong, Constants_H.WIDTH_H, (Constants_H.HEIGHT - 30), 3);
    }
    private void drawMapRect(byte ww,byte hh,int tmap,boolean select){
       int width = ww * 6;
       int height = hh * 6;
       if (this.miniMapMode != null) {
          width = this.mapdataMap[tmap][6] * ww;
          height = this.mapdataMap[tmap][7] * hh;
       }
       if (select) {
          Ui.i().drawRectZ(0xbc7afc, ((this.mapdataMap[tmap][0] * ww) + this.mapoffx), ((this.mapdataMap[tmap][1] * hh) + this.mapoffy), width, height, 5);
       }else if(tmap == this.myMiniMap){
          Ui.i().drawK1((this.mapoffx + (this.mapdataMap[tmap][0] * ww)), (this.mapoffy + (this.mapdataMap[tmap][1] * hh)), width, height, 4);
       }else {
          Ui.i().drawK0((this.mapoffx + (this.mapdataMap[tmap][0] * ww)), (this.mapoffy + (this.mapdataMap[tmap][1] * hh)), width, height, 2);
       }
       Map tgr = this.gr;
       String nameCity = this.gr.getNameCity(tmap);
       int i = ((this.mapdataMap[tmap][0] * ww) + this.mapoffx) + (width >> 1);
       int i1 = (((this.mapdataMap[tmap][1] * hh) + this.mapoffy) + (height >> 1)) - 25;
       int i2 = 4;
       int i3 = (tmap == this.myMiniMap)? 0: 3;
       tgr.showStringM(nameCity, i, i1, i2, i3);
       if (tmap == this.myMiniMap) {
          Ui.i().drawUi(67, (((this.mapdataMap[tmap][0] * ww) + this.mapoffx) + (width >> 1)), (((this.mapdataMap[tmap][1] * hh) + this.mapoffy) + (height >> 1)), 3, 0);
       }
       return;
    }
    private void drawMapRect(Graphics g){
       int ix5;
       byte i = 0;
       g.setColor(0);
       while (i < this.gr.mapRect.length) {
          int ix = this.gr.mapRect[i][0] * 20;
          int ix1 = this.gr.mapRect[i][1] * 20;
          int ix2 = this.gr.mapRect[i][2] - this.gr.mapRect[i][0];
          ix2 = ix2 + 1;
          int ix3 = ix2 * 20;
          ix2 = this.gr.mapRect[i][3] - this.gr.mapRect[i][1];
          ix2 = ix2 + 1;
          int ix4 = ix2 * 20;
          if (!Ms.i().isRect(this.my.x, this.my.y, 19, 19, ix, ix1, ix3, ix4)) {
             byte j = 4;
             while (j < this.gr.mapRect[i].length) {
                int ix6 = this.gr.mapRect[i][j] * 20;
                ix5 = this.map_x + ix6;
                ix2 = j + 1;
                int ix7 = this.gr.mapRect[i][ix2] * 20;
                ix6 = this.map_y + ix7;
                ix2 = j + 2;
                ix7 = this.gr.mapRect[i][ix2] - this.gr.mapRect[i][j];
                ix7 = ix7 + 1;
                ix7 = ix7 * 20;
                ix = j + 3;
                ix1 = j + 1;
                ix2 = this.gr.mapRect[i][ix] - this.gr.mapRect[i][ix1];
                ix2 = ix2 + 1;
                ix2 = ix2 * 20;
                g.fillRect(ix5, ix6, ix7, ix2);
                ix5 = j + 4;
                j = (byte)ix5;
             }
          }
          ix5 = i + 1;
          i = (byte)ix5;
       }
       return;
    }
    private void drawMiniMap(){
       byte tmap;
       GameRun.mc.keyxx = MainCanvas.mainxx;
       GameRun.mc.keyyy = MainCanvas.mainyy;
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       short x = 12;
       short fh = 29;
       Ui.i().fillRectB();
       Ui.i().drawK2(1, 2, (WIDTH - 2), (HEIGHT - 2), 0);
       Ui.i().drawK1(6, 33, (WIDTH - 12), ((HEIGHT - (fh * 3)) - 15), 1);
       Ui.i().drawK1(6, ((HEIGHT - 6) - (fh * 2)), (WIDTH - 12), (fh * 2), 2);
       Ui.i().drawYesNo(false, true);
       Ui.i().drawString("\x6e\x02\x62\x02\x57\x02\x56\x02", WIDTH_H, 4, 17, 1, 2);
       if (this.showArea == -1) {
          Ui.i().drawString("\x8b\x02\x53\x02\x57\x02\x6c\x02\x67\x02\x57\x02\x56\x02\xff\x02", WIDTH_H, ((HEIGHT - 4) - (fh * 2)), (16 | 0x01), 3, 0);
       }else {
          this.gr.showStringM("\x4e\x02\x72\x02\x5f\x02\x52\x02\x4f\x02\x7f\x02\xff\x02"+this.gr.getNameCity(this.myMiniMap), WIDTH_H, ((HEIGHT - 4) - (fh * 2)), 10, 3);
          Map.g.setClip(6, 33, (WIDTH - 12), ((HEIGHT - 15) - (fh * 3)));
          byte ww = 18;
          byte hh = 12;
          byte j = 0;
          int i = WIDTH_H - (this.mapdataMap[this.selectMap][0] * ww);
          int i1 = (this.miniMapMode != null)? (this.mapdataMap[this.selectMap][6] * ww) / 2: 25;
          int t = i - i1;
          this.mapoffx = Ms.i().mathSpeedN(this.mapoffx, t, 10, 0);
          i = (this.littleMapClipY / 2) - (this.mapdataMap[this.selectMap][1] * hh);
          i1 = (this.miniMapMode != null)? (this.mapdataMap[this.selectMap][7] * hh) / 2: 15;
          t = i - i1;
          this.mapoffy = Ms.i().mathSpeedN(this.mapoffy, t, 10, 0);
          while (j < this.mapdataArea[this.showArea].length) {
             if ((tmap = this.mapdataArea[this.showArea][j]) >= 0 && this.mapdataMap[tmap].length > 0) {
                i1 = this.mapdataMap[tmap][0] * ww;
                i1 = i1 + this.mapoffx;
                int i2 = this.mapdataMap[tmap][1] * hh;
                i2 = i2 + this.mapoffy;
                int i3 = ww * 6;
                int i4 = hh * 6;
                if (this.pkey.isSelect(i1, i2, i3, i4)) {
                   this.selectMap = tmap;
                }
                if (this.miniMapMode != null || tmap != this.myMiniMap) {
                   this.drawMapRect(ww, hh, tmap, 0);
                }
             }
             i = j + 1;
             j = (byte)i;
          }
          if (this.miniMapMode == null) {
             this.drawMapRect(ww, hh, this.myMiniMap, 0);
          }
          this.drawMapRect(ww, hh, this.selectMap, 1);
          Map.g.setClip(0, 0, WIDTH, HEIGHT);
       }
       return;
    }
    private void drawMission(){
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       Ui.i().fillRectB();
       Ui.i().drawK2(1, 6, (WIDTH - 2), (HEIGHT - 6), 0);
       int ly = 41;
       Ui.i().drawK1(8, ly, (WIDTH - 26), ((this.gr.line_max * 29) + 10), 1);
       Ui.i().drawK1(8, ((this.gr.line_max * 29) + 59), (WIDTH - 16), 125, 2);
       int i = 8;
       int i1 = ly + 6;
       int i2 = WIDTH - 26;
       int i3 = 29;
       GameRun line_max = this.gr.line_max;
       object oobject = this.gr.select[0];
       int i4 = (this.gr.cur_a == null)? this.bMission[14] + 1: this.mDirect.length;
       this.drawMisstionList(i, i1, i2, i3, line_max, oobject, i4);
       byte d = 0;
       while (this.gr.about_a != null && d < this.gr.about_a.length) {
          int i6 = ly + 20;
          i6 = this.gr.line_max * 29;
          i6 = i6 + 61;
          int i7 = d * 25;
          i2 = i6 + i7;
          Ui.i().drawStringColor(this.gr.about_a[d].toString(), 25, i2, 3, 0);
          i6 = d + 1;
          d = (byte)i6;
       }
       byte t = this.pkey.selectMenuX(2, 0, 0, WIDTH_H, 40);
       if (t != -1) {
          this.gr.cur_a = t;
          this.goMission(this.gr.cur_a, this.bPause);
       }
       Ui ui = Ui.i();
       i = (this.gr.cur_a == null)? WIDTH_H - 125: WIDTH_H + 25;
       ui.drawK1(i, 9, 100, 29, 4);
       ui = Ui.i();
       String str = "\x4e\x02\x7e\x02\x4e\x02\x52\x02";
       i1 = WIDTH_H - 75;
       i2 = 9;
       i3 = 17;
       int i5 = (this.gr.cur_a == null)? 0: 1;
       ui.drawString(str, i1, i2, i3, i5, 0);
       ui = Ui.i();
       str = "\x52\x02\x65\x02\x4e\x02\x52\x02";
       i1 = WIDTH_H + 75;
       i2 = 9;
       i3 = 17;
       i5 = (this.gr.cur_a == 1)? 0: 1;
       ui.drawString(str, i1, i2, i3, i5, 0);
       Ui.i().drawTriangle(WIDTH_H, 20, 150, true, true);
       ui = Ui.i();
       String str1 = (this.gr.cur_a == null)? "\x4e\x02\x7e\x02\x5b\x02\x62\x02\x5e\x02\xff\x02": "\x52\x02\x65\x02\x5b\x02\x62\x02\x5e\x02\xff\x02";
       String str2 = String.valueOf(str1);
       Ms ms = Ms.i();
       ly = this.bMission;
       i = (this.gr.cur_a == null)? 14: 15;
       ly = ly[i] * 1000;
       i = (this.gr.cur_a == null)? this.sMission.length - 1: this.sMission.length;
       ui.drawString(str2+ms.getPrecision((ly / i))+"%", WIDTH_H, (HEIGHT - 1), 33, -1, 1);
       Ui.i().drawYesNo(false, true);
       return;
    }
    private void drawMisstionList(int x,int y,int w,int sh,int show_num,byte[] sel,int length){
       int ix1;
       String s;
       int ix5;
       int ix7;
       int WIDTH = 640;
       byte i = sel[1];
       Ui.i().drawListKY(show_num, x, y, w, 6, sh, -1, (sel[0] - sel[1]), 4, 2);
       while (true) {
          int ix = sel[1] + show_num;
          if (i >= ix) {
             break ;
          }else if(i < length){
             if (this.gr.cur_a == null) {
                ix1 = i + 1;
                s = String.valueOf(ix1).append("\x30\x02").append(this.sMission[i][0].toString()).toString();
             }else {
                ix1 = i + 1;
                s = String.valueOf(ix1).append("\x30\x02").append(this.sMission[this.mDirect[i]][0].toString()).toString();
             }
             Log.e("sk", "drawMisstionList");
             Ui ui = Ui.i();
             int ix2 = x + 8;
             int ix3 = i - sel[1];
             int ix4 = sh - 1;
             ix3 = ix3 * ix4;
             ix3 = ix3 + y;
             ix4 = 0;
             if (i < this.bMission[14]) {
                ix5 = -1;
             }else if(sel[0] == i){
                ix5 = 0;
             }else {
                ix5 = 3;
             }
             ui.drawString(s, ix2, ix3, ix4, ix5, 0);
             if (this.gr.cur_a == null) {
                ix = length - 1;
                if (i != ix) {
                   Ui ui1 = Ui.i();
                   String str = "\x5b\x02\x62\x02";
                   ix = x + w;
                   s = 8;
                   ix4 = ix - s;
                   ix = i - sel[1];
                   ix1 = sh - 1;
                   ix = ix * ix1;
                   ix5 = y + ix;
                   int ix6 = 24;
                   if (i < this.bMission[14]) {
                      ix = -1;
                   }else if(sel[0] == i){
                      ix7 = 0;
                   }else {
                      ix7 = 3;
                   }
                   ui1.drawString(str, ix4, ix5, ix6, ix, 0);
                }
             }
             ix2 = i - sel[1];
             ix3 = sh - 1;
             ix2 = ix2 * ix3;
             ix2 = ix2 + y;
             ix3 = sh - 1;
             if (this.pkey.isSelect(0, ix2, WIDTH, ix3)) {
                sel[0] = i;
                if (!(ix = i - sel[1]) && sel[1] > 0) {
                   ix = 1;
                   ix1 = sel[ix] - 1;
                   sel[ix] = (byte)ix1;
                }else {
                   ix = i - sel[1];
                   ix1 = show_num - 1;
                   if (ix == ix1) {
                      ix = sel[1] + show_num;
                      if (ix < length) {
                         ix = 1;
                         ix1 = sel[ix] + 1;
                         sel[ix] = (byte)ix1;
                      }
                   }
                }
                if (this.gr.cur_a == null) {
                   ix2 = WIDTH - 50;
                   this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), ix2, 0);
                }else if(this.mDirect.length > 0){
                   ix2 = WIDTH - 50;
                   this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), ix2, 0);
                }
             }
          }
          ix = i + 1;
          i = (byte)ix;
       }
       Ui.i().sliding(((x + w) + 4), y, (show_num * sh), sel[0], length, true);
       return;
    }
    private void drawMySave(){
       this.gr.showString("\x66\x02\x54\x02\x5b\x02\x76\x02?", 285, 0);
       Ui.i().drawYesNo(true, true);
    }
    private void drawNMAni(Npc[] npc){
       byte id;
       int ix;
       int ix1;
       int ix2;
       int ix4;
       if (npc != null) {
          byte i = 0;
          while (i < this.npcList.length) {
             if ((id = this.npcList[i]) == -1) {
                if (this.my.other[4] == 1 || this.my.other[4] == 2) {
                   ix = this.map_x + this.my.x;
                   ix1 = ix + 10;
                   ix = this.map_y + this.my.y;
                   ix2 = ix + 19;
                   this.drawMyAni(this.my, 0, ix1, ix2, this.my.other[7]);
                }
             }else if(id < -1){
                Ms.i();
                ix = Ms.abs(id) - 2;
                id = (byte)ix;
                ix = this.item[id][0] * 20;
                int ix3 = this.item[id][1] * 20;
                if (this.isNpcSrc(ix, ix3)) {
                   Ui ui = Ui.i();
                   ix3 = (this.item[id][2] == 2)? 55: 54;
                   ix1 = this.item[id][0] * 20;
                   ix4 = this.map_x + ix1;
                   ix4 = ix4 + 10;
                   ix2 = this.item[id][1] * 20;
                   ix1 = this.map_y + ix2;
                   ix1 = ix1 + 20;
                   ui.drawUi(ix3, ix4, ix1, 33, 0);
                }
             }else if(npc[id].other[4] != 1 && (npc[id].other[4] != 2 || !this.isNpcSrc(npc[id].x, npc[id].y))){
                if (npc[id].other[8] != 3 && !this.npcNameData[id].equals("\x8d\x02\x4e\x02")) {
                   ix4 = this.map_x + npc[id].x;
                   ix4 = ix4 + 10;
                   ix1 = this.map_y + npc[id].y;
                   ix1 = ix1 + 20;
                   Map.g.drawImage(this.imgShadow, ix4, ix1, 33);
                }
                this.drawNpcAniOne(npc, id);
             }
             this.runNpcAniOne(npc, id);
             ix = i + 1;
             i = (byte)ix;
          }
       }
       return;
    }
    private void drawNpcAni(Npc[] npc){
       if (npc != null) {
          byte i = 0;
          while (i < npc.length) {
             if (npc[i].other[4] == 1 || (npc[i].other[4] == 2 && this.isNpcSrc(npc[i].x, npc[i].y))) {
                this.drawNpcAniOne(npc, i);
             }
             this.runNpcAniOne(npc, i);
             int ix = i + 1;
             i = (byte)ix;
          }
       }
       return;
    }
    private void drawNpcAniOne(Npc[] npc,int i){
       int ix = 8;
       byte type = (byte)(npc[i].other[3] - 1);
       byte id = npc[i].other[2];
       byte action_id = npc[i].other[7];
       byte now_action = npc[i].now_action;
       if (action_id < 0) {
          npc[i].dir = 4;
          action_id = (byte)(- action_id);
       }
       if (npc[i].now_action >= Map.npcSp[type][id].aLength(action_id)) {
          now_action = 0;
          if ((npc[i].now_action = now_action) == -4) {
             npc[i].other[ix] = 0;
             npc[i].other[4] = 0;
          }else if(npc[i].bdir == null && this.setlastA(npc, i)){
             this.drawNpcAniOne(npc, i);
          }else {
          label_0063 :
             Ui ui = Ui.i();
             object oobject = Map.npcSp[type][id];
             ix = Map.npcSp[type][id].action(action_id, now_action, 0);
             int ix1 = (this.map_x + npc[i].x) + 10;
             int ix2 = (this.map_y + npc[i].y) + 19;
             int ix3 = (npc[i].dir == 4)? 1: 0;
             ui.drawFrameOne(oobject, ix, ix1, ix2, ix3);
          }
       }else {
          goto label_0063 ;
       }
       return;
    }
    private void drawNpcFace(int x,int y,int dir){
       if (this.imgFace != null) {
          Ui.i().drawImage(this.imgFace, (this.face_c + x), y, dir);
       }
       this.face_c = Ms.i().mathSpeedN(this.face_c, 0, 20, 0);
       return;
    }
    private void drawSrcEffect(){
       int i = 0;
       int FONT_W = 25;
       int FONT_H = 25;
       int WIDTH = Constants_H.WIDTH__;
       int HEIGHT = Constants_H.HEIGHT__;
       if (this.srcFlash_c > null) {
          Map tsrcFlash_c = this.srcFlash_c;
          this.srcFlash_c = (byte)(tsrcFlash_c - 1);
          if (!((tsrcFlash_c % 2))) {
             Ui.i().fillRect(0xffffff, i, i, WIDTH, HEIGHT);
          }
       }
       if (this.bSrc != null) {
          int SRC_BATTLE_H = Constants_H.SRC_BATTLE_H__;
          Map.g.setColor(i);
          Map.g.fillRect(i, ((this.black_width - SRC_BATTLE_H) - this.bSrc_c), WIDTH, SRC_BATTLE_H);
          Map.g.fillRect(i, ((HEIGHT - this.black_width) + this.bSrc_c), WIDTH, SRC_BATTLE_H);
       }
       if (this.my.state == 22) {
          Graphics g = Map.g;
          int i1 = (this.eventGoing == 2)? (HEIGHT - (this.gr.about_d.length * 29)) >> 1: 45;
          if (this.eventGoing == 2) {
             i = 1;
          }
          this.drawBlackSRC(g, i1, i);
       }
       return;
    }
    private void drawStep(Graphics g,int x,int y,int h){
       int i = 4;
       int i1 = 3;
       if (this.bStep > null) {
          g.setColor(0x3c3b3b);
          g.drawRect((x + 1), y, (h - 2), h);
          g.drawRect(x, (y + 1), h, (h - 2));
          g.setColor(0xcccccc);
          g.drawRect((x + 2), (y + 1), (h - i), (h - 2));
          g.drawRect((x + 1), (y + 2), (h - 2), (h - i));
          Ui.i().fillRect(0xffffff, (x + 2), (y + 2), (h - i1), (h - i1));
          Ui.i().drawUi(67, ((h >> 1) + x), ((h >> 1) + y), (2 | 0x01), 0);
          if (((this.bStep % 12)) < 6) {
             Ui.i().drawLine(0xee0000, ((x + h) - 1), y, x, ((y + h) - 1));
             Ui.i().drawLine(0, (x + h), y, x, (y + h));
             Ui.i().drawLine(0xee0000, (x + h), (y + 1), (x + 1), (y + h));
          }
          byte b = (byte)(this.bStep - 1);
          this.bStep = b;
          if (b < 2) {
             this.bStep = 100;
          }
       }
       return;
    }
    private void exitBoss(int map_No,int zuobiao_x,int zuobiao_y,int mydir){
       this.chuansong(map_No, 0);
       this.bExitBoss = true;
       this.my.setXY(zuobiao_x, zuobiao_y, 0, 0);
       this.my.dir = (byte)mydir;
    }
    private void getInMap(byte exit_no,byte[][] door){
       this.my.dir = (byte)(((((door[exit_no][2] - 1) / 2) * 2) + 1) + (door[exit_no][2] % 2));
       this.my.setXY(door[exit_no][0], door[exit_no][1], 0, 0);
    }
    private void getItem(){
       byte id;
       Map tgr;
       if (this.item[this.get_meet][2] == 2) {
          this.gr.say("\x8f\x02\x4e\x02\x5b\x02\x7b\x02\x66\x02\x7a\x02\x76\x02\x30\x02", 0);
       }else if((id = (byte)(this.item[this.get_meet][3] - 2)) == -2){
          tgr = this.gr;
          tgr.money = tgr.money + (this.item[this.get_meet][4] * 100);
          this.gr.say("\x83\x02\x5f\x02\x91\x02\x94\x02\xff\x02"+(this.item[this.get_meet][4] * 100)+"\x91\x02", 0);
       }else if(id == -1){
          tgr = this.gr;
          tgr.coin = tgr.coin + this.item[this.get_meet][4];
          this.gr.say("\x83\x02\x5f\x02\x5f\x02\x7a\x02\xff\x02"+this.item[this.get_meet][4]+"\x5f\x02\x7a\x02", 0);
       }else {
          this.gr.getItem(id, this.item[this.get_meet][4]);
       }
       this.item[this.get_meet][2] = 2;
       return;
    }
    private void getItemData(ByteArrayOutputStream byteArray,byte[][] data){
       try{
          byteArray.write(data.length);
          for (int i = 0; i < data.length; i++) {
             byteArray.write(data[i].length);
             byteArray.write(data[i]);
          }
       }catch(java.lang.Exception e2){
          Exception ex = e2;
          ex.printStackTrace();
       }
       return;
    }
    private void getNpcData(ByteArrayOutputStream byteArray,Npc[] npc){
       int i = 0;
       try{
          while (i < npc.length) {
             if (npc[i].other[9] == 1) {
                byteArray.write(npc[i].other);
             }
             i++;
          }
       }catch(java.lang.Exception e2){
          Exception ex = e2;
          ex.printStackTrace();
       }
       return;
    }
    private byte[] getNpcData(){
       ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
       this.getNpcData(byteArray, this.npc[0]);
       this.getNpcData(byteArray, this.npc[1]);
       this.getNpcData(byteArray, this.npc[2]);
       this.getItemData(byteArray, this.item);
       this.getItemData(byteArray, this.door);
       return byteArray.toByteArray();
    }
    private byte getNpcId(int i){
       return (byte)(this.npcPos[i] & 0x3f);
    }
    private byte getNpcLayer(int i){
       return (byte)((this.npcPos[i] & 0x00ff) >> 6);
    }
    private short getNpcListY(int j){
       short y;
       int i = -1;
       if (this.npcList[j] == i) {
          y = (short)(this.my.y + (this.dir_select[this.my.dir][1] * this.my.speed));
       }else if(this.npcList[j] < i){
          Ms.i();
          y = (short)(this.item[(Ms.abs(this.npcList[j]) - 2)][1] * 20);
       }else {
          y = this.npc[0][this.npcList[j]].y;
       }
       return y;
    }
    private void ifEvent(int i,int next_id,int next_mode,int mode,boolean bt){
       boolean b = false;
       if (this.setSIfElse(mode, bt, true)) {
          Map tevent_now = this.event_now;
          tevent_now[i] = (short)(tevent_now[i] + next_id);
          this.nextEvent(next_mode);
       }else if(this.setSIfElse(mode, bt, b)){
          this.setEventNow(i, b);
       }
       return;
    }
    private void init(){
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
       return;
    }
    private boolean initAuto(Npc npc,int sleep){
       boolean b;
       if (npc.timeMove == null) {
          if (npc.frame_c == -1) {
             Ms.i();
             b = (Ms.getRandom(100) < 50)? true: false;
             npc.b_auto = b;
             Ms.i();
             if (Ms.getRandom(100) < 50) {
                Ms.i();
                npc.timeMove = (byte)(- (Ms.getRandom(sleep) + 20));
                npc.setActionNo(false);
                b = false;
             }else {
             label_0047 :
                b = true;
             }
          }else {
             b = false;
          }
       }else if(npc.timeMove < null){
          npc.timeMove = (byte)(npc.timeMove + 1);
          b = false;
       }else {
          goto label_0047 ;
       }
       return b;
    }
    private void initBoat(int _select){
       this.my.state = 9;
       this.anole_type = 5;
       this.setAnole();
       this.boatSelect = (byte)_select;
       this.gr.cur_a = 0;
       this.my.setIXY(this.boatCourse[this.boatSelect][this.gr.cur_a], this.boatCourse[this.boatSelect][(this.gr.cur_a + 1)]);
    }
    private void initCloud(){
       if (this.mapNo != 24 && (this.mapNo != 25 && (this.mapNo != 26 && (this.mapNo != 49 && this.mapNo != 50)))) {
          this.cloud = null;
          this.imgCloud = null;
       }else if(this.imgCloud == null){
          this.imgCloud = Ms.i().createImage("data/cloud");
          this.cloud = null;
          int[] ointArray = new int[]{4,3};
          this.cloud = Array.newInstance(Short.TYPE, ointArray);
       }
       byte i = 0;
       while (i < this.cloud.length) {
          this.addCloud(i);
          int ix = i + 1;
          i = (byte)ix;
       }
       return;
    }
    private void initHudong(){
       this.hudong = Ms.i().createImage("data/brow/hudong");
    }
    private void initMissionList(){
       byte[] info = Ms.i().rmsOptions(7, null, 1);
       this.bMission = (info[0] == -1)? null: info;
       info = null;
       if (this.bMission == null) {
          byte[] uobyteArray = new byte[20];
          this.bMission = uobyteArray;
       }
       Ms.i();
       Ms.skip = 0;
       byte[] data = Ms.i().getStream("data/mission0.t", -1);
       this.sMission = Ms.i().createString2Array(data);
       this.smissionLength = this.sMission.length - 1;
       this.sMission = null;
       return;
    }
    private void initMoveMy(){
       this.my.frame_c = this.my.frame_num;
       this.my.setActionNo(true);
       if (this.my.state == null && this.gr.monPro.length > 0) {
          this.meetGrass();
       }
       return;
    }
    private void initNpcAni_1(int length,int type,byte[] em){
       int i = length - 1;
       while (i > 0) {
          if (em[i]) {
             if (Map.npcSp[type][i] == null) {
                this.initNpcAniOne("".append(i).toString(), i, type);
             }
          }else {
             Map.npcSp[type][i] = null;
          }
          i--;
       }
       return;
    }
    private boolean isAnole(int _x,int _y,int _anole_type){
       int i1;
       int i = 4;
       if (!_anole_type) {
          _anole_type = 3;
       label_0006 :
          byte check_n = 0;
          if ((_x % 20)) {
             check_n = (byte)(check_n + 1);
          }
          if ((_y % 20)) {
             check_n = (byte)(check_n + 1);
          }
          if ((check_n = (byte)(1 << check_n)) == i && this.worldData[((_x + 19) / 20)][(_y / 20)] == _anole_type) {
             i1 = 1;
          }else if(check_n > 1){
             if (((_x % 20)) && this.worldData[((_x + 19) / 20)][((_y + 19) / 20)] == _anole_type) {
                i1 = 1;
             }else if(((_y % 20)) && this.worldData[(_x / 20)][(_y / 20)] == _anole_type){
                i1 = 1;
             }
          }
          if (this.worldData[(_x / 20)][(_y / 20)] == _anole_type) {
             i1 = 1;
          }else {
             i1 = false;
          }
       }else if(_anole_type == 2){
          _anole_type = 4;
          goto label_0006 ;
       }else if(_anole_type == i){
          _anole_type = 2;
          goto label_0006 ;
       }else {
          i1 = false;
       }
       return i1;
    }
    private boolean isAnoleType(int i){
       int ix = ((this.gr.rmsOther[2] & (1 << i)))? 1: false;
       return ix;
    }
    private boolean isAuto_canMove(Npc _npc,int sx,int sy){
       boolean b = (this.checkWorld(_npc.x, _npc.y, sx, sy, false) != 1 && !Ms.i().isRect((_npc.x + sx), (_npc.y + sy), 19, 19, this.my.x, this.my.y, 19, 19))? true: false;
       return b;
    }
    private boolean isCan_not_pass(int ix,int iy){
       boolean b;
       if (this.worldData[ix][iy] == 1) {
          b = true;
       }else if(this.anole_type == null){
          b = (this.worldData[ix][iy] != 2 && this.worldData[ix][iy] != 4)? false: true;
       }else if(this.anole_type == 2){
          b = (this.worldData[ix][iy] != 3 && this.worldData[ix][iy] != 2)? false: true;
       }else if(this.anole_type == 4){
          b = (this.worldData[ix][iy] != 2)? true: false;
       }else if(this.worldData[ix][iy] != 2 && (this.worldData[ix][iy] != 3 && this.worldData[ix][iy] != 4)){
          b = false;
       }else {
          b = true;
       }
       return b;
    }
    private boolean isCheckAnole(int id){
       boolean b;
       if (this.anole_type != id && this.isAnoleType(id)) {
          this.anole_type = (byte)id;
          this.setAnole();
          b = true;
       }else if(!this.isAnoleType(id)){
          this.gr.say("\x6c\x02\x67\x02"+this.gr.monsterT[id]+"\x57\x02\x9a\x02"+"\xff\x02\x4e\x02\x80\x02\x90\x02\x8f\x02\x8b\x02\x57\x02\x5f\x02", -1);
       }
       b = false;
       return b;
    }
    private boolean isCheckNpcOff(){
       boolean b;
       byte w;
       if (this.checkNpcT < null) {
          b = false;
       }else if(this.my.speed_x != null){
          Ms.i();
          if ((w = (byte)(20 - Ms.abs((this.my.y - this.npc[0][this.checkNpcT].y)))) > 0 && w < 11) {
             b = true;
          }
       }else if(this.my.speed_y != null){
          Ms.i();
          if ((w = (byte)(20 - Ms.abs((this.my.x - this.npc[0][this.checkNpcT].x)))) > 0 && w < 11) {
             b = true;
          }
       }
       b = 0;
       return b;
    }
    private byte isMapChenk(byte checkType){
       int i;
       int i1;
       byte checkLeft = 0;
       byte checkRight = 0;
       byte ix = (byte)(this.my.x / 20);
       byte iy = (byte)(this.my.y / 20);
       if (this.my.speed_x == null) {
          i = ((this.my.x % 20))? 0: 1;
          i = (ix - i) * 20;
          i1 = (this.my.speed_y >= null)? 1: -1;
          checkLeft = this.checkMap(i, ((i1 + iy) * 20), 0, 0);
          i = (ix + 1) * 20;
          i1 = (this.my.speed_y >= null)? 1: -1;
          checkRight = this.checkMap(i, ((i1 + iy) * 20), 0, 0);
       }else if(this.my.speed_y == null){
          i = (this.my.speed_x >= null)? 1: -1;
          i = (i + ix) * 20;
          i1 = ((this.my.y % 20))? 0: 1;
          checkLeft = this.checkMap(i, ((iy - i1) * 20), 0, 0);
          i = (this.my.speed_x >= null)? 1: -1;
          checkRight = this.checkMap(((i + ix) * 20), ((iy + 1) * 20), 0, 0);
       }
       if (checkLeft == 1 && checkRight == 1) {
          i = checkType;
       }else if(!checkLeft){
          if (this.my.speed_x == null) {
             i = ((this.my.x % 20))? 0: 1;
             i = ix - i;
          }else {
             i = ix;
          }
          i = i * 20;
          if (this.my.speed_y == null) {
             i1 = ((this.my.y % 20))? 0: 1;
             i1 = iy - i1;
          }else {
             i1 = iy;
          }
          if (!this.checkMap(i, (i1 * 20), 0, 0)) {
             i = -1;
          }
       }
       if (!checkRight) {
          if (this.my.speed_x == null) {
             i = ((this.my.x % 20))? 0: 1;
             i = i + ix;
          }else {
             i = ix;
          }
          i = i * 20;
          if (this.my.speed_y == null) {
             i1 = ((this.my.y % 20))? 0: 1;
             i1 = i1 + iy;
          }else {
             i1 = iy;
          }
          if (!this.checkMap(i, (i1 * 20), 0, 0)) {
             i = -2;
          }
       }
       i = checkType;
       return i;
    }
    private boolean isMapEvent(int _mapNo,int _i){
       int i = ((this.mapInfo[((_mapNo * 2) + 1)] & (1 << _i)))? 1: false;
       return i;
    }
    private boolean isMission(int id){
       byte type = (byte)(id / 8);
       id = (int)(id % 8);
       int i = ((this.bMission[type] & (1 << id)))? 1: false;
       return i;
    }
    private boolean isNpcSrc(int ax,int ay){
       boolean b = (((this.map_x + ax)) >= -80 && (((this.map_x + ax)) <= (Constants_H.WIDTH + 60) && (((this.map_y + ay)) >= -80 && ((this.map_y + ay)) <= (Constants_H.HEIGHT + 60))))? true: false;
       return b;
    }
    private boolean isTrundleNpc(int ix,int iy){
       byte type;
       boolean b;
       int i = 4;
       if ((type = this.checkIfNpc(this.npc[0], ix, iy)) != -1) {
          b = (this.npc[0][type].other[i] != 1 && this.npc[0][type].other[i] != 3)? 0: true;
       }else if(ix >= 0 && (ix < this.cols && (iy >= 0 && (iy < this.rows && this.worldData[ix][iy] != 1)))){
          b = 0;
       }else {
          b = true;
       }
       return b;
    }
    private void keyAnoleSel(){
       int i = 0;
       if (!Ms.i().key_delay()) {
          if (Ms.i().key_Left_Right()) {
             this.anoleSel = Ms.i().select(this.anoleSel, i, 4);
          }else if(Ms.i().key_S1()){
             if (!this.isAnoleType(this.anoleSel)) {
                this.gr.say("\x8f\x02\x6c\x02\x67\x02\x83\x02\x5f\x02\x8b\x02\x9a\x02\x5b\x02", i);
             }else if(this.anoleSel == 4){
                this.gr.say("\x53\x02\x80\x02\x57\x02\x6c\x02\x91\x02\x4f\x02\x75\x02", i);
             }else if(this.anole_type == this.anoleSel){
                this.anole_type = -1;
             }else {
                this.anole_type = this.anoleSel;
             }
             if (this.gr.rmsSms[6] == 10 && (this.anole_type == 3 && !this.gr.rmsSms[i])) {
                SMSSender.i(this.gr).go(1, 1);
                this.anole_type = -1;
             }else if(this.anole_type == 3 && !this.gr.rmsSms[i]){
                this.gr.say("\x59\x02\x5f\x02\x51\x02\x4e\x02\x4e\x02\x8d\x02\x5f\x02\x5f\x02\x80\x02\x4e\x02\x53\x02\x4e\x02\x4e\x02\x90\x02\x65\x02\xff\x02\x73\x02\x63\x02\x4f\x02\x8b\x02\x9a\x02\x4f\x02\x9a\x02\xff\x02\x6b\x02\x72\x02\x9a\x02\x8b\x02\x54\x02\x97\x02\x8d\x02\x4e\x02\xff\x02", -1);
             }
             this.gr.magic_id = 13;
             this.gr.magic_x = (this.map_x + this.my.x) + 10;
             this.gr.magic_y = (this.map_y + this.my.y) + 19;
             this.gr.setMagic((this.gr.magic_id / 5));
             this.my.state = 21;
             Ms.i().keyRelease();
          }else if(!Ms.i().key_S2() && !Ms.i().key_Num9()){
             this.my.state = i;
             Ms.i().keyRelease();
          }
       }
       return;
    }
    private void keyMiniMap(){
       Ms.i().keyRelease();
       if (!Ms.i().key_S1_Num5()) {
          if (!Ms.i().key_S2() && !Ms.i().key_Num0()) {
             if (Ms.i().key_Left_Right() || (Ms.i().key_Up_Down() && (this.mapdataMap[this.selectMap].length >= 6 && this.mapdataMap[this.selectMap][(Ms.abs(Ms.key) + 1)] != -1))) {
                this.selectMap = this.mapdataMap[this.selectMap][(Ms.abs(Ms.key) + 1)];
             }
          }else {
             this.my.state = 0;
             this.mapdataArea = null;
             this.mapdataMap = null;
          }
       }
       return;
    }
    private void keyMission(){
       byte length;
       int i = 14;
       StringBuffer[] stringBuffer = null;
       int WIDTH = 640;
       if (!Ms.i().key_delay()) {
          if (!Ms.i().key_Left_Right() && (!Ms.i().key_Num1() && (this.gr.cur_a == 1 && (!Ms.i().key_Num3() && this.gr.cur_a == null)))) {
             if (Ms.i().key_Up_Down()) {
                if (this.gr.cur_a == null) {
                   int len = (((this.bMission[i] + 1)) > this.sMission.length)? this.sMission.length: this.bMission[i] + 1;
                   length = (byte)len;
                }else {
                   length = (byte)this.mDirect.length;
                }
                Ms.i().selectS(this.gr.select[0], 0, length, this.gr.line_max);
                if (this.gr.cur_a == null) {
                   this.gr.setStringB(this.sMission[this.gr.select[0][0]][1], (WIDTH - 50), 0);
                }else if(this.mDirect.length > 0){
                   this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1], (WIDTH - 50), 0);
                }else {
                   this.gr.about_a = stringBuffer;
                }
             }else if(!Ms.i().key_S2() && (!Ms.i().key_Num1() && !Ms.i().key_Num3())){
                if ((this.my.state = 0) != null) {
                   this.gr.doPaint(0);
                   GameRun.run_state = 97;
                }else {
                   GameRun.run_state = -10;
                }
                this.mDirect = stringBuffer;
                this.sMission = stringBuffer;
                this.gr.about_a = stringBuffer;
                Ms.i().keyRelease();
             }
          }else {
             Map tgr = this.gr;
             tgr.cur_a = (byte)(tgr.cur_a ^ 0x01);
             this.goMission(this.gr.cur_a, this.bPause);
          }
       }
       return;
    }
    private void keyMySave(){
       if (Ms.i().key_S1()) {
          this.my.state = 0;
          this.eventGoing = 2;
       }else if(Ms.i().key_S2()){
          this.my.state = 0;
          this.eventGoing = 3;
       }
       return;
    }
    private void keySelectMenu(){
       if (!Ms.i().key_delay()) {
          if (Ms.i().key_S1_Num5()) {
             this.my.state = 13;
          }else if(Ms.i().key_Up_Down()){
             this.gr.cur_a = Ms.i().select(this.gr.cur_a, 0, (this.gr.action_str.length - 1));
          }
       }
       return;
    }
    private void loadMapData(int id){
       int ix;
       short[] oshortArray;
       Map map;
       int ix1;
       int elemNum = 0;
       int dataType = 0;
       byte[] uobyteArray = new byte[2];
       byte[] buffShort = uobyteArray;
       uobyteArray = new byte[4];
       byte[] buffInt = uobyteArray;
       byte layerType = 0;
       this.bottomData = null;
       this.frontData = null;
       this.worldData = null;
       short arrayIndex = 0;
       try{
          DataInputStream v9 = new DataInputStream(AndroidUtil.getResourceAsStream("/data/map/"+id+".mid"));
          v9.skip(2);
          v9.read(buffInt);
          Ms.i();
          this.bgColor = (int)Ms.getNum(buffInt);
          dataType = v9.readByte();
          byte[] buff = new byte[dataType];
          v9.read(buff);
          v9.read(buff);
          Ms.i();
          this.cols = (byte)(int)Ms.getNum(buff);
          v9.read(buff);
          Ms.i();
          this.rows = (byte)(int)Ms.getNum(buff);
          int[] ointArray = new int[]{this.cols,this.rows};
          id = Array.newInstance(Short.TYPE, ointArray);
          this.worldData = id;
          byte i = 0;
          try{
             while (i < 3) {
                layerType = v9.readByte();
                if (layerType != -1) {
                   v9.read(buffInt);
                   Ms.i();
                   elemNum = (int)Ms.getNum(buffInt);
                   elemNum = elemNum * 3;
                   switch (layerType){
                       case 1:
                         oshortArray = new short[elemNum];
                         this.bottomData = oshortArray;
                         break;
                       case 2:
                         break;
                       case 3:
                         oshortArray = new short[elemNum];
                         this.frontData = oshortArray;
                         break;
                   }
                   arrayIndex = 0;
                   arrayIndex = arrayIndex;
                   while (arrayIndex < elemNum) {
                      v9.read(buff);
                      Ms.i();
                      int x = (short)(int)Ms.getNum(buff);
                      v9.read(buff);
                      ix = this.rows - 1;
                      Ms.i();
                      long l = (long)ix - Ms.getNum(buff);
                      int y = (short)(int)l;
                      v9.read(buffShort);
                      Ms.i();
                      int z = (short)(int)Ms.getNum(buffShort);
                      switch (layerType){
                          case 1:
                            map = this.bottomData;
                            ix1 = arrayIndex + 1;
                            arrayIndex = (short)ix1;
                            ix1 = (short)x;
                            map[arrayIndex] = ix1;
                            map = this.bottomData;
                            ix1 = arrayIndex + 1;
                            arrayIndex = (short)ix1;
                            ix1 = (short)y;
                            map[arrayIndex] = ix1;
                            ix1 = arrayIndex + 1;
                            arrayIndex = (short)ix1;
                            this.bottomData[arrayIndex] = (short)z;
                            arrayIndex = arrayIndex;
                            break;
                          case 2:
                            ix = arrayIndex + 3;
                            arrayIndex = (short)ix;
                            ix1 = z >> 3;
                            this.worldData[x][y] = (short)ix1;
                            arrayIndex = arrayIndex;
                            break;
                          case 3:
                            map = this.frontData;
                            ix1 = arrayIndex + 1;
                            arrayIndex = (short)ix1;
                            ix1 = (short)x;
                            map[arrayIndex] = ix1;
                            map = this.frontData;
                            ix1 = arrayIndex + 1;
                            arrayIndex = (short)ix1;
                            ix1 = (short)y;
                            map[arrayIndex] = ix1;
                            ix1 = arrayIndex + 1;
                            arrayIndex = (short)ix1;
                            this.frontData[arrayIndex] = (short)z;
                            arrayIndex = arrayIndex;
                            break;
                          default:
                      }
                   }
                   arrayIndex = arrayIndex;
                }
                ix = i + 1;
                i = (byte)ix;
             }
             v9.close();
             buff = null;
             DataInputStream dis = null;
             buffShort = dis;
             buffInt = null;
             dis = 0;
          }catch(java.lang.Exception e16){
             arrayIndex = arrayIndex;
          }catch(java.lang.Exception e16){
          }catch(java.lang.Exception e16){
             arrayIndex = arrayIndex;
          }
          return;
       }catch(java.lang.Exception e16){
       }
    }
    private void loadMapModuleAndImage(){
       int ix = 0;
       Ms.i();
       Ms.skip = ix;
       byte[] data = Ms.i().getStream("data/map/area.dat", -1);
       byte[] areaMap = Ms.i().createArray(data);
       byte[][] areaPic = Ms.i().create2Array(data);
       data = null;
       if (this.mapImg != null && areaMap[this.lastMap] == areaMap[this.mapNo]) {
          areaMap = null;
          areaPic = null;
       }else {
          Ms.i();
          Ms.skip = ix;
          this.moduleData = Ms.i().createShort2Array(Ms.i().getStream("data/map/"+areaMap[this.mapNo]+".data", -1), 1);
          this.mapImg = null;
          Image[] imageArray = new Image[areaPic[areaMap[this.mapNo]].length];
          this.mapImg = imageArray;
          byte i = 0;
          while (i < areaPic[areaMap[this.mapNo]].length) {
             this.mapImg[i] = Ms.i().createImage("data/map/".append(areaPic[areaMap[this.mapNo]][i]).toString());
             int ix1 = i + 1;
             i = (byte)ix1;
          }
          areaMap = null;
          areaPic = null;
       }
       return;
    }
    private int map_set(int _my_x,int cols,int xcells,int half_xcells,int show_width,int cell_width){
       int map_x;
       if (cols <= xcells) {
          map_x = (show_width - (cell_width * cols)) >> 1;
       }else if(((_my_x + 1)) <= half_xcells){
          map_x = 0;
       }else if(_my_x >= (cols - half_xcells)){
          map_x = show_width - (cols * cell_width);
       }else {
          map_x = ((show_width / 2) - (_my_x * cell_width)) - (cell_width / 2);
       }
       return map_x;
    }
    private void meetGrass(){
       if (this.meet_step < this.step_MEET) {
          if (this.worldData[this.my.getIx()][this.my.getIy()] != 7) {
             this.meet_step = (short)(this.meet_step + 1);
          }
       }else if(this.gr.monPro.length > 1 && this.gr.immueEnemy == null){
          this.my.frame_c = 0;
          this.my.state = 8;
       }
       this.notMeet(0, 0);
       return;
    }
    private void moveOff(byte dirx,byte diry,int speed){
       if (this.my.speed_x == null) {
          this.my.dir = dirx;
       }else if(this.my.speed_y == null){
          this.my.dir = diry;
       }
       Map tmy = this.my;
       int i = (this.my.speed_x != null)? 0: speed;
       tmy.speed_x = (byte)i;
       tmy = this.my;
       i = (this.my.speed_y != null)? 0: speed;
       tmy.speed_y = (byte)i;
       this.checkMoveOff(this.checkNpcT);
       this.initMoveMy();
       return;
    }
    private void nextEvent(int mode){
       if ((mode & 0x1000)) {
          this.now_eV1 = 0;
          this.now_eV2 = 0;
       }
       if ((mode & 0x0100)) {
          this.eventGoing = 0;
       }
       if ((mode & 0x10)) {
          this.event_state = 1;
       }
       if ((mode & 0x01)) {
          this.my.state = 0;
       }
       this.pkey.initPointer();
       return;
    }
    private void oneMove(Npc npc_,int i){
       byte b = -1;
       if (npc_.frame_c > null) {
          if (this.srcNpcNo == i) {
             this.mapMove(npc_.x, npc_.y, npc_.speed_x, npc_.speed_y);
          }
          npc_.x = (short)(npc_.x + npc_.speed_x);
          npc_.y = (short)(npc_.y + npc_.speed_y);
          npc_.frame_c = (byte)(npc_.frame_c - 1);
       }else if(npc_.frame_c != b){
          npc_.frame_c = b;
          npc_.setActionNo(false);
       }
       return;
    }
    private void runAutoMoveNpc(Npc npc,int i){
       int ix = 8;
       int ix1 = 5;
       if (this.my.state == 1 && this.get_meet == i) {
          Npc other = npc.other;
          Ms.i();
          int ix2 = (Ms.abs(npc.other[7]) / 3) * 3;
          ix1 = (this.my.dir < 4)? this.my.dir - 1: this.my.dir - 2;
          if ((other[7] = (byte)(ix2 + ix1)) == 3) {
             npc.other[7] = (byte)(- npc.other[7]);
          }else {
             npc.dir = 3;
          }
       }else if(this.initAuto(npc, 10)){
          if (npc.b_auto != null) {
             this.runAutoX(npc, this.gr.mapMove[((npc.other[ix] - ix1) * 2)]);
          }else {
             this.runAutoY(npc, this.gr.mapMove[(((npc.other[ix] - ix1) * 2) + 1)]);
          }
       }
       return;
    }
    private void runAutoX(Npc _npc,int w){
       int b;
       Npc speed;
       int i = 1;
       if (_npc.timeMove == null) {
          Ms.i();
          b = (Ms.getRandom(100) < 50)? 3: 4;
          _npc.dir = b;
          short t = (_npc.dir == 3)? (short)(_npc.x - (_npc.other[0] * 20)): (short)(((_npc.other[0] + w) * 20) - _npc.x);
          if (t <= 20) {
             _npc.timeMove = (byte)(t / _npc.speed);
          }else {
             Ms.i();
             _npc.timeMove = (byte)(Ms.getRandom((((t - 20) / _npc.speed) + 1)) + (20 / _npc.speed));
          }
       }else if(_npc.timeMove > null && _npc.frame_c < i){
          b = (_npc.dir == 3)? - _npc.speed: _npc.speed;
          if (this.isAuto_canMove(_npc, b, 0)) {
             b = (_npc.dir == 3)? - _npc.speed: _npc.speed;
             _npc.setSpeedXY(b, 0);
             _npc.timeMove = (byte)(_npc.timeMove - i);
             _npc.frame_c = i;
             _npc.setActionNo(i);
          }else {
             _npc.timeMove = -20;
             _npc.frame_c = -1;
             _npc.setActionNo(0);
          }
       }
       return;
    }
    private void runAutoY(Npc _npc,int w){
       int b;
       Npc speed;
       int i = 0;
       if (_npc.timeMove == null && _npc.frame_c == -1) {
          Ms.i();
          b = (Ms.getRandom(100) < 50)? 1: 2;
          _npc.dir = b;
          short t = (_npc.dir == 1)? (short)(_npc.y - (_npc.other[1] * 20)): (short)(((_npc.other[1] + w) * 20) - _npc.y);
          if (t <= 20) {
             _npc.timeMove = (byte)(t / _npc.speed);
          }else {
             Ms.i();
             _npc.timeMove = (byte)(Ms.getRandom((((t - 20) / _npc.speed) + 1)) + (20 / _npc.speed));
          }
       }else if(_npc.timeMove > null && _npc.frame_c < 1){
          b = (_npc.dir == 1)? - _npc.speed: _npc.speed;
          if (this.isAuto_canMove(_npc, i, b)) {
             b = (_npc.dir == 1)? - _npc.speed: _npc.speed;
             _npc.setSpeedXY(i, b);
             _npc.timeMove = (byte)(_npc.timeMove - 1);
             _npc.frame_c = 1;
             _npc.setActionNo(1);
          }else {
             _npc.timeMove = -20;
             _npc.frame_c = -1;
             _npc.setActionNo(i);
          }
       }
       return;
    }
    private void runBoat(){
       byte b = -1;
       if (this.boatSelect != b && (this.my.ix == b && this.my.iy == b)) {
          this.my.state = 9;
          Map tgr = this.gr;
          byte b1 = (byte)(tgr.cur_a + 2);
          tgr.cur_a = b1;
          if (b1 >= this.boatCourse[this.boatSelect].length) {
             this.boatSelect = b;
             this.my.state = 0;
             this.anole_type = b;
             this.setAnole();
          }else {
             this.checkType = this.checkIfOther(this.door, this.my.x, this.my.y);
             if (this.checkType != b) {
                this.my.state = 5;
                this.get_meet = this.checkType;
             }
             this.my.setIXY(this.boatCourse[this.boatSelect][this.gr.cur_a], this.boatCourse[this.boatSelect][(this.gr.cur_a + 1)]);
          }
       }
       return;
    }
    private void runEvent_brow(int i){
       int event_temp;
       byte b = -1;
       Map.cur_npc = ((event_temp = this.event[i][(this.event_now[i] + 2)] - 1) == b)? this.my: this.npc[this.getNpcLayer(event_temp)][this.getNpcId(event_temp)];
       if (!this.event[i][(this.event_now[i] + 4)]) {
          Map.cur_npc.brow_type = this.event[i][(this.event_now[i] + 3)];
          Map.cur_npc.brow_action = 0;
          Map.cur_npc.brow_time = 0;
       }else if(this.event[i][(this.event_now[i] + 4)] == 1){
          Map.cur_npc.other[6] = this.event[i][(this.event_now[i] + 3)];
       }else if(this.event[i][(this.event_now[i] + 4)] == 2){
          Map.cur_npc.brow_type = b;
          Map.cur_npc.other[6] = 0;
       }
       Map tevent_now = this.event_now;
       tevent_now[i] = (short)(tevent_now[i] + 5);
       this.nextEvent(4112);
       return;
    }
    private void runEvent_dialog(int i){
       int event_temp;
       int ix = 2;
       byte b = -1;
       this.checkNpcT = b;
       if (this.eventGoing == null) {
          this.eventGoing = 1;
          if (this.anole_type == 1) {
             this.setAnole();
          }
          if ((event_temp = this.event[i][(this.event_now[i] + 2)] - 1) == b) {
             this.npcName = "\x58\x02\x51\x02";
             this.now_eV2 = 0;
          }else {
             this.now_eV1 = this.getNpcLayer(event_temp);
             this.now_eV2 = this.getNpcId(event_temp);
             this.npcName = this.npcNameData[this.now_eV2];
             if (this.npcName.equals("\x8d\x02\x4e\x02")) {
                this.npcName = null;
             }
             this.now_eV2 = this.npc[this.now_eV1][this.now_eV2].other[ix];
          }
          this.initNpcFaceOne(this.npcName);
          Ms.i();
          Ms.font.setSize(22);
          this.dialog = Ms.i().groupString(Ms.i().getDialogs(this.event[i], (this.event_now[i] + 5), this.event[i][(this.event_now[i] + 4)]), (Constants_H.WIDTH__ - 20));
          if (this.fontSizeControl == null) {
             Ms.i();
             Ms.font.setSize(26);
          }
          this.dialog_no = 0;
          this.my.state = 1;
          this.bDirTalk = false;
       }else if(this.eventGoing == ix){
          Map tevent_now = this.event_now;
          tevent_now[i] = (short)(tevent_now[i] + ((this.event[i][(this.event_now[i] + 4)] << 1) + 5));
          this.nextEvent(4369);
       }
       return;
    }
    private void runEvent_getMon(int i){
       this.gmErr = false;
       if (this.gr.getMonster(this.event[i][(this.event_now[i] + 2)], this.event[i][(this.event_now[i] + 3)], this.event[i][(this.event_now[i] + 4)], -1) == -1) {
          this.gr.say("\x5b\x02\x72\x02\x7a\x02\x95\x02\x5d\x02\x6e\x02\xff\x02\x65\x02\x6c\x02\x83\x02\x5f\x02\x65\x02\x76\x02\x5b\x02\x72\x02\xff\x02\x8b\x02\x65\x02\x74\x02\x5b\x02\x5b\x02\x62\x02\x7a\x02\x51\x02\x4e\x02\x4e\x02\x7a\x02\x95\x02\x30\x02", -1);
          this.gmErr = true;
          this.gr.mini_state = 6;
          this.gr.view_state = true;
          this.gr.goVIEW_MONSTER();
       }else {
          Map tevent_now = this.event_now;
          tevent_now[i] = (short)(tevent_now[i] + (this.event[i][(this.event_now[i] + 1)] + 2));
          this.nextEvent(4368);
       }
       return;
    }
    private void runEvent_goShop(int i){
       int event_temp;
       Map tgr;
       int ix = 2;
       if ((event_temp = this.event[i][(this.event_now[i] + 3)]) == 4) {
          if (this.inShop == null && this.my.state != 16) {
             this.my.state = 16;
             this.inShop = 1;
             String[] stringArray = new String[ix];
             stringArray[0] = "\x56\x02\x59\x02";
             stringArray[1] = "\x4e\x02\x56\x02\x59\x02";
             this.gr.setAction_str(stringArray);
             this.gr.popMenu = 0;
             this.gr.sell_money = 0;
             byte d = 0;
             while (d < this.gr.myMon_length) {
                tgr = this.gr;
                ix = this.gr.myMonsters[d].monster[4] * 20;
                ix = ix + 40;
                int ix1 = tgr.sell_money + ix;
                tgr.sell_money = ix1;
                int ix2 = d + 1;
                d = (byte)ix2;
             }
          }else if(this.my.state == null){
             if (this.inShop == 1 && this.gr.popMenu == null) {
                this.inShop = ix;
                if (!this.gr.checkMonster() && this.gr.isMoney(this.gr.sell_money, 1)) {
                   this.gr.healMonster(1);
                }
             }else if(this.gr.say_c == null){
                this.inShop = 0;
                tgr = this.event_now;
                tgr[i] = (short)(tgr[i] + 4);
                this.nextEvent(0);
             }
          }
       }else if(event_temp < 3){
          this.gr.goBUY_ITEM(this.event[i][(this.event_now[i] + 2)], event_temp);
       }else if(event_temp == 3){
          this.gr.goVIEW_COMPUTER(0);
       }else if(event_temp == 5){
          this.gr.goNidus(0);
       }else if(event_temp == 6){
          this.gr.view_state = 4;
          this.gr.popMenu = -1;
       }else if(event_temp == 7){
          this.gr.view_state = 1;
       }
       tgr = this.event_now;
       tgr[i] = (short)(tgr[i] + 4);
       this.nextEvent(16);
       return;
    }
    private void runEvent_item_add_del(int i){
       Map tgr;
       int ix = -1;
       int event_temp = 0;
       if (this.eventGoing == null) {
          this.now_eV1 = this.event[i][(this.event_now[i] + 2)];
          this.now_eV2 = this.event[i][(this.event_now[i] + 3)];
          if (this.event[i][(this.event_now[i] + 3)] >= 0) {
             event_temp = this.gr.addItem(this.now_eV1, this.now_eV2);
          }else {
             Ms.i();
             if (this.gr.findItem(-2, this.now_eV1, 1) >= Ms.abs(this.now_eV2)) {
                Ms.i();
                this.gr.deleteItems(this.now_eV1, Ms.abs(this.now_eV2));
             }else {
                event_temp = -1;
                this.gr.say("\x90\x02\x51\x02\x4e\x02\x8d\x02\xff\x02", 0);
             }
          }
          if (event_temp != ix) {
             tgr = this.gr;
             String str = (this.now_eV2 >= null)? "\x83\x02\x5f\x02\xff\x02": "\x59\x02\x53\x02\xff\x02";
             Ms.i();
             tgr.say(String.valueOf(str)+this.gr.getNameItem(this.now_eV1)+"x"+Ms.abs(this.now_eV2), 0);
          }
          this.eventGoing = 1;
       }else if(this.gr.say_c == null){
          if (event_temp == ix) {
             this.setEventNow(i, 1);
          }else {
             tgr = this.event_now;
             tgr[i] = (short)(tgr[i] + 4);
             this.nextEvent(4368);
          }
       }
       return;
    }
    private void runEvent_miniGame_myLevel(int i){
       int event_temp;
       Map tevent_now;
       byte b = 2;
       if ((event_temp = this.event[i][(this.event_now[i] + 2)]) > true) {
          tevent_now = this.event_now;
          tevent_now[i] = (short)(tevent_now[i] + 3);
          this.nextEvent(4368);
       }else if(this.eventGoing < b){
          if (!event_temp) {
             if (this.gr.magic_id == -2) {
                if (this.gr.rmsOther[3] == 5) {
                   this.gr.magic_id = -2;
                   this.eventGoing = b;
                   this.gr.say("\x60\x02\x5f\x02\x52\x02\x76\x02\x8b\x02\x7e\x02\x5e\x02\x7b\x02\x7e\x02\x5d\x02\x8f\x02\x52\x02\x4e\x02\x96\x02\xff\x02", 0);
                }else if((this.gr.sell_money = this.gr.isMyLevel(true)) == -1){
                   this.my.state = 10;
                   this.gr.magic_id = 28;
                   this.gr.magic_x = (this.map_x + this.my.x) + 10;
                   this.gr.magic_y = (this.map_y + this.my.y) + 19;
                   this.gr.setMagic((this.gr.magic_id / 5));
                   this.gr.setMaxTakes(0);
                }else {
                   this.eventGoing = b;
                }
             }else if(this.gr.magic_id == -1){
                this.gr.magic_id = -2;
                this.eventGoing = b;
                this.gr.say("\x60\x02\x55\x02\x60\x02\x76\x02\x8b\x02\x7e\x02\x5e\x02\x7b\x02\x7e\x02\x5d\x02\x63\x02\x53\x02\x4e\x02#7"+this.gr.rmsOther[3]+"#0\xff\x02\x60\x02\x96\x02\x8e\x02\x53\x02\x64\x02\x5e\x02\x5b\x02\x72\x02\x65\x02\x91\x02#7\x66\x02\x58\x02\x52\x02"+this.gr.max_takes+"#0\xff\x02\x60\x02\x55\x02\x5e\x02\x80\x02\x5b\x02\x65\x02\x76\x02\x5b\x02\x72\x02#7\x66\x02\x58\x02\x52\x02"+this.gr.max_monsters, -1);
             }
          }else if(event_temp == true){
             if (this.eventGoing == null && !this.gr.monInfoList[104]) {
                this.gr.sell_money = 0;
                this.eventGoing = 3;
                this.gr.say("\x6b\x02\x6b\x02\x60\x02\x6c\x02\x67\x02\x63\x02\x83\x02\x52\x02\x51\x02\x65\x02\x76\x02\x5b\x02\x72\x02\xff\x02\x63\x02\x83\x02\x5e\x02\x4e\x02\x66\x02\x55\x02\x4e\x02\x90\x02\x5f\x02\xff\x02\x67\x02\x4e\x02\x5b\x02\x72\x02\x97\x02\x89\x02\x90\x02\x8f\x02\x8f\x02\x53\x02\x62\x02\x80\x02\x83\x02\x5f\x02\x54\x02\x30\x02", -1);
             }else if(this.eventGoing == null){
                this.eventGoing = 3;
                this.gr.sell_money = this.gr.monInfoList[104];
                this.gr.monInfoList[104] = 0;
                this.gr.say("\x6b\x02\x6b\x02\x60\x02\x63\x02\x83\x02\x4e\x02"+this.gr.sell_money+"\x4e\x02\x65\x02\x5b\x02\x72\x02\xff\x02\x8f\x02\x91\x02\x66\x02\x73\x02\x56\x02\x8b\x02\x7e\x02\x5e\x02\x67\x02\x67\x02\x59\x02\x52\x02\x7e\x02\x60\x02\x76\x02"+this.gr.sell_money+"\x4e\x02\x5f\x02\x7a\x02\xff\x02\x5e\x02\x67\x02\x51\x02\x63\x02\x51\x02\x53\x02\x54\x02\x30\x02", -1);
                tevent_now = this.gr;
                tevent_now.coin = tevent_now.coin + this.gr.sell_money;
             }
          }
       }else if(this.gr.say_c == null){
          if (this.eventGoing == b) {
             if (this.gr.rmsOther[3] == 5) {
                this.gr.say("\x60\x02\x5f\x02\x52\x02\x76\x02\x8b\x02\x7e\x02\x5e\x02\x7b\x02\x7e\x02\x5d\x02\x8f\x02\x52\x02\x4e\x02\x96\x02\xff\x02", 0);
             }else if((this.gr.sell_money = (byte)(this.gr.isMyLevel(0) - this.gr.monInfoList[103])) < true){
                this.gr.sell_money = 0;
             }
             this.gr.say("\x5f\x02\x52\x02\x8b\x02\x7e\x02\x5e\x02\x7b\x02\x7e\x02\x4e\x02#7"+this.gr.rmsOther[3]+"#0\x8d\x02\x79\x02\x4e\x02\x6b\x02\x53\x02\x7e\x02\x8f\x02\x97\x02\x89\x02\x63\x02\x63\x02#7"+this.gr.sell_money+"#0\x53\x02\x4e\x02\x54\x02\x76\x02\x5b\x02\x72\x02\xff\x02\x52\x02\x52\x02\x83\x02\x5f\x02\x65\x02\x5b\x02\x54\x02\x30\x02", -1);
             this.eventGoing = 4;
          }else if(this.eventGoing == 3 && this.gr.sell_money > null){
             this.gr.say("\x83\x02\x5f\x02\xff\x02\x5f\x02\x7a\x02x"+this.gr.sell_money, 0);
             this.eventGoing = 4;
          }else {
             tevent_now = this.event_now;
             tevent_now[i] = (short)(tevent_now[i] + 3);
             this.nextEvent(4368);
          }
       }
       return;
    }
    private void runEvent_select(int i){
       if (this.my.state != 12 && (this.my.state != 13 && this.my.state != 14)) {
          this.sEvent_eV2 = this.event[i][(this.event_now[i] + 1)];
          this.sEvent_eV1 = 0;
          this.gr.action_str = null;
          String[] stringArray = new String[this.sEvent_eV2];
          this.gr.action_str = stringArray;
          byte j = 0;
          while (j < this.sEvent_eV2) {
             int ix = this.event_now[i] + 2;
             ix = ix + this.sEvent_eV1;
             ix = ix + 1;
             int ix1 = this.event_now[i] + 2;
             ix1 = ix1 + this.sEvent_eV1;
             this.gr.action_str[j] = Ms.i().getDialogs(this.event[i], ix, this.event[i][ix1]);
             int ix2 = this.event_now[i] + 2;
             ix2 = ix2 + this.sEvent_eV1;
             int ix3 = this.event[i][ix2] << 1;
             ix3 = ix3 + 1;
             ix = this.sEvent_eV1 + ix3;
             this.sEvent_eV1 = (byte)ix;
             int ix4 = j + 1;
             j = (byte)ix4;
          }
          if (this.sIfElse != -1) {
             this.event_state = 1;
             this.gr.cur_a = this.sIfElse;
             this.my.state = 13;
             this.gr.action_str = null;
             this.sIfElse = -1;
          }else {
             this.gr.cur_a = 0;
             this.my.state = 12;
          }
       }else if(this.my.state == 13){
          this.sEvent_eV1 = (byte)(this.sEvent_eV1 + 2);
          byte a = this.event[i][((this.event_now[i] + this.sEvent_eV1) + (this.gr.cur_a << 1))];
          byte b = this.event[i][(((this.event_now[i] + this.sEvent_eV1) + (this.gr.cur_a << 1)) + 1)];
          short d = (short)(((a & 0x00ff) << 8) | (b & 0x00ff));
          Map tevent_now = this.event_now;
          tevent_now[i] = (short)(tevent_now[i] + ((this.sEvent_eV1 + (this.sEvent_eV2 << 1)) + d));
          this.nextEvent(17);
       }else if(this.my.state == 14){
          this.setEventNow(i, true);
       }
       return;
    }
    private void runEvent_srcMove(int i){
       Map tevent_now;
       byte b;
       this.my.state = 10;
       int event_temp = this.event[i][(this.event_now[i] + 2)] - 1;
       int x = 0;
       int y = 0;
       if (event_temp == -1) {
          x = this.my.getIx();
          y = this.my.getIy();
          this.srcNpcNo = -1;
       }else {
          this.now_eV1 = this.getNpcLayer(event_temp);
          this.now_eV2 = this.getNpcId(event_temp);
          tevent_now = (this.now_eV1 == null)? this.now_eV2: 0;
          this.srcNpcNo = tevent_now;
          x = this.now_eV1;
          x = this.npc[x][this.now_eV2].other[0];
          y = this.npc[this.now_eV1][this.now_eV2].other[1];
       }
       byte step = 10;
       x = this.map_x;
       x = this.map_set(x, this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20) - x;
       y = this.map_set(y, this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20) - this.map_y;
       Ms.i();
       if (Ms.abs(y) < step) {
          Ms.i();
          if (Ms.abs(x) < step) {
             tevent_now = this.event_now;
             x = tevent_now[i];
             tevent_now[i] = (short)(x + 3);
             this.nextEvent(4112);
          }else {
          label_00a8 :
             Ms.i();
             if (Ms.abs(x) >= step) {
                Ms.i();
                x = x / Ms.abs(x);
                this.map_x = this.map_x + (x * step);
             }
             Ms.i();
             if (Ms.abs(y) >= step) {
                Ms.i();
                this.map_y = this.map_y + ((y / Ms.abs(y)) * step);
             }
          }
       }else {
          goto label_00a8 ;
       }
       return;
    }
    private void runMove(){
       int ix;
       if (this.my.ix == -1 && this.my.iy == -1) {
          this.runBoat();
       }else {
          this.runSeek(this.my, false);
       }
       this.oneMove(this.my, -1);
       byte j = 0;
       while (j < 3) {
          byte i = 0;
          while (i < this.npc[j].length) {
             if (this.npc[j][i].other[4] == true || this.npc[j][i].other[4] == 2) {
                if (this.npc[j][i].other[8] >= 5) {
                   this.runAutoMoveNpc(this.npc[j][i], i);
                }else if(this.npc[j][i].ix == -1 && this.npc[j][i].iy == -1){
                   this.runSeek(this.npc[j][i], true);
                }
                this.oneMove(this.npc[j][i], i);
             }
             ix = i + 1;
             i = (byte)ix;
          }
          ix = j + 2;
          j = (byte)ix;
       }
       this.insertNpc();
       return;
    }
    private void runNpcAniOne(Npc[] npc,int i){
       byte type = (byte)(npc[i].other[3] - 1);
       byte id = npc[i].other[2];
       Ms.i();
       byte action_id = (byte)Ms.abs(npc[i].other[7]);
       if (npc[i].now_action >= Map.npcSp[type][id].aLength(action_id)) {
          npc[i].now_action = 0;
          this.setlastA(npc, i);
       }
       object oobject = npc[i];
       byte b = (byte)(oobject.now_time + 1);
       oobject.now_time = b;
       if (b >= Map.npcSp[type][id].action(action_id, npc[i].now_action, 1)) {
          oobject = npc[i];
          oobject.now_action = (byte)(oobject.now_action + 1);
          npc[i].now_time = 0;
       }
       return;
    }
    private void runSeek(Npc npc_,boolean b_who){
       int b2;
       Npc speed;
       byte b = -1;
       boolean b1 = true;
       boolean bb = npc_.b_check;
       short x_ = (short)(npc_.ix * 20);
       short y_ = (short)(npc_.iy * 20);
       if (npc_.x == x_ && npc_.y == y_) {
          if (npc_.frame_c == b) {
             npc_.iy = b;
             npc_.ix = b;
             if (b_who) {
                npc_.setIxIy_npc();
             }else {
                npc_.speed = this.getMySpeed();
             }
             if (npc_.bdir != null) {
                b2 = ((npc_.other[7] = npc_.lastAction) < null)? 4: 3;
                npc_.dir = b2;
                npc_.setLastAction(false, 127);
             }
          }
       }else if(npc_.frame_c < b1){
          if (bb != null) {
             bb = (npc_.x != x_)? b1: false;
          }else if(npc_.y == y_){
             bb = b1;
          }else {
             bb = false;
          }
          if (bb) {
             if (npc_.x > x_ && (((npc_.x - npc_.speed)) < x_ || (npc_.x < x_ && ((npc_.x + npc_.speed)) > x_))) {
                npc_.setSpeedXY((x_ - npc_.x), false);
             }else if(npc_.x > x_){
                b2 = - npc_.speed;
             }else {
                speed = npc_.speed;
             }
             npc_.setSpeedXY(b2, false);
             if (npc_.bdir == null) {
                b2 = (npc_.x > x_)? 3: 4;
                npc_.dir = b2;
             }
          }else if(npc_.y > y_ && (((npc_.y - npc_.speed)) < y_ || (npc_.y < y_ && ((npc_.y + npc_.speed)) > y_))){
             npc_.setSpeedXY(false, (y_ - npc_.y));
          }else if(npc_.y > y_){
             b2 = - npc_.speed;
          }else {
             speed = npc_.speed;
          }
          npc_.setSpeedXY(false, b2);
          if (npc_.bdir == null) {
             b2 = (npc_.y > y_)? b1: 2;
             npc_.dir = b2;
          }
          npc_.frame_c = npc_.frame_num;
          npc_.setActionNo(b1);
       }
       return;
    }
    private void setEventNow(int i,boolean bb){
       if (bb) {
          this.my.state = 0;
       }
       this.now_eV1 = 0;
       this.now_eV2 = 0;
       this.eventGoing = 0;
       this.event_now[i] = 0;
       return;
    }
    private void setMapData(){
       this.map_x = this.map_set(this.my.getIx(), this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20);
       this.map_y = this.map_set(this.my.getIy(), this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20);
       this.mapLeft_NOmove = (short)(Constants_H.WIDTH_H - 10);
       this.mapRight_NOmove = (short)(((this.cols * 20) - Constants_H.WIDTH_H) - 10);
       this.mapUp_NOmove = (short)(Constants_H.HEIGHT_H - 10);
       this.mapDown_NOmove = (short)(((this.rows * 20) - Constants_H.HEIGHT_H) - 10);
    }
    private void setMapOffer(){
       if (((this.map_y + (this.rows * 20))) < Constants_H.HEIGHT && this.rows > Constants_H.YCELLS) {
          this.map_y = Constants_H.HEIGHT - (this.rows * 20);
       }else if(this.map_y > null && this.rows > Constants_H.YCELLS){
          this.map_y = 0;
       }else if(this.map_x > null && this.cols > Constants_H.XCELLS){
          this.map_x = 0;
       }else if(((this.map_x + (this.cols * 20))) < Constants_H.WIDTH && this.cols > Constants_H.XCELLS){
          this.map_x = Constants_H.WIDTH - (this.cols * 20);
       }
       return;
    }
    private void setMoveStop_m(){
       this.my.speed_x = 0;
       this.my.speed_y = 0;
       this.my.frame_c = -1;
       this.my.setActionNo(0);
    }
    private boolean setSIfElse(int _mode,boolean _bt,boolean _bmode){
       boolean i;
       if (_mode == 2) {
          i = (_bt)? 0: 1;
          this.sIfElse = (byte)i;
          i = true;
       }else if(_bmode && _bt){
          i = true;
       }else if(!_bmode && _mode == 1){
          i = 1;
       }else {
          i = false;
       }
       return i;
    }
    private boolean setlastA(Npc[] npc,int i){
       boolean b;
       if (npc[i].lastAction != 127) {
          npc[i].other[7] = npc[i].lastAction;
          npc[i].lastAction = 127;
          b = true;
       }else {
          b = false;
       }
       return b;
    }
    private void turnAround(int dir){
       this.my.dir = (byte)dir;
       this.my.setActionNo(true);
    }
    public void addAnole(int i){
       int ix = 49;
       int ix1 = 34;
       int ix2 = 13;
       if (i == ix2 || (i == ix1 || (i == ix || (i == 66 || i == 82)))) {
          if (i == ix2) {
             i = 0;
          }else if(i == ix1){
             i = 1;
          }else if(i == ix){
             i = 2;
          }else if(i == 66){
             i = 3;
          }else {
             i = 4;
          }
          GameRun rmsOther = this.gr.rmsOther;
          rmsOther[2] = (byte)(rmsOther[2] | (1 << i));
       }
       return;
    }
    public void bkEvent_getMon(){
       GameRun.run_state = -10;
    }
    public void bkgroundToPaint(short[] bkgroundData,Image[] img,int screen_x,int screen_y,short[][] moduleData,Graphics gtem,int x1,int y1,int x2,int y2,boolean fillBlack){
       int ix;
       if (bkgroundData != null) {
          screen_y = screen_y - 20;
          if (fillBlack) {
             gtem.setClip(x1, y1, (x2 - x1), (y2 - y1));
             gtem.setColor(this.bgColor);
             gtem.fillRect(x1, y1, (x2 - x1), (y2 - y1));
          }
          int bkdata_id = -1;
          int bkdata_trans = 0;
          int bkPic_w = 0;
          int bkPic_h = 0;
          int i = 0;
          while (i < bkgroundData.length) {
             if ((ix = i + 2) >= 0) {
                ix = i + 2;
                bkdata_id = bkgroundData[ix] >> 3;
                ix = i + 2;
                bkdata_trans = bkgroundData[ix] & 0x03;
                ix = bkgroundData[i] * 20;
                int realX = ix - screen_x;
                ix = i + 1;
                ix = bkgroundData[ix] * 20;
                int realY = ix - screen_y;
                if ((ix = bkdata_trans % 2) == 1) {
                   bkPic_w = moduleData[bkdata_id][4];
                   bkPic_h = moduleData[bkdata_id][3];
                }else {
                   bkPic_w = moduleData[bkdata_id][3];
                   bkPic_h = moduleData[bkdata_id][4];
                }
                ix = realX + bkPic_w;
                if (ix >= x1 && (realX <= x2 && realY >= y1)) {
                   ix = realY - bkPic_h;
                   if (ix <= y2) {
                      int ix1 = 4 | 0x20;
                      int ix2 = i + 2;
                      ix2 = bkgroundData[ix2] & 0x07;
                      Ui.i().drawRegion(img[moduleData[bkdata_id][0]], moduleData[bkdata_id][1], moduleData[bkdata_id][2], moduleData[bkdata_id][3], moduleData[bkdata_id][4], realX, realY, ix1, ix2, gtem);
                   }
                }
             }
             i = i + 3;
          }
       }
       return;
    }
    public synchronized void checkRegWhere0(int i){
       this.isNeedWait = true;
       SMSSender.i(this.gr).go(2, true);
       SMSSender.i(this.gr).run();
       if (this.isNeedWait != null) {
          try{
             System.out.println("wait\(\) start");
             this.wait();
          }catch(java.lang.Exception e1){
             Exception ex = e1;
             ex.printStackTrace();
          }
          System.out.println("wait\(\) over");
       }
       return;
    }
    public byte checkSoftKey(int A_X,int A_Y,int _speed_x,int _speed_y){
       byte b;
       Npc other;
       int i = 8;
       if (((A_X + _speed_x)) >= 0 && (((A_X + _speed_x)) < (this.cols * 20) && (((A_Y + _speed_y)) >= 0 && ((A_Y + _speed_y)) < (this.rows * 20)))) {
          byte type = 0;
          type = this.checkIfNpc(this.npc[0], (A_X + _speed_x), (A_Y + _speed_y));
          if (this.my.state == null && type != -1) {
             if (this.anole_type == 1 && this.npc[0][type].other[i] == 4) {
                this.npc[0][type].other[i] = -4;
                other = this.npc[0][type].other;
                other[7] = (byte)(other[7] + 1);
                this.npc[0][type].now_action = 0;
                this.npc[0][type].now_time = 0;
             }else if(this.npc[0][type].other[i] != -4){
                this.my.state = 2;
                this.get_meet = type;
                if (this.npc[0][type].other[i] != 2 && (this.npc[0][type].other[i] != 3 && !this.npcNameData[type].equals("\x8d\x02\x4e\x02"))) {
                   this.bDirTalk = true;
                   this.npcDirTalk = this.npc[0][type].other[7];
                   other = this.npc[0][type].other;
                   Ms.i();
                   int i1 = (Ms.abs(this.npcDirTalk) / 3) * 3;
                   int i2 = (this.my.dir < 4)? this.my.dir - 1: this.my.dir - 2;
                   if ((other[7] = (byte)(i1 + i2)) == 3) {
                      this.npc[0][type].other[7] = (byte)(- this.npc[0][type].other[7]);
                   }else {
                      this.npc[0][type].dir = 3;
                   }
                }else {
                   this.bDirTalk = false;
                }
             }
             b = 9;
          }else if((type = this.checkIfOther(this.item, (A_X + _speed_x), (A_Y + _speed_y))) != -1 && this.item[type][2] != -1){
             Ms.i().keyRelease();
             this.get_meet = type;
             this.getItem();
             b = 0;
          }else {
             b = -1;
          }
       }else {
          b = 0;
       }
       return b;
    }
    public void chuansong(int mapno,int door){
       this.my.state = 5;
       this.mapNotemp = (byte)mapno;
       this.go = (byte)door;
       this.setMoveStop_m();
    }
    public void createEvent(){
       byte i;
       int ix;
       byte[] data = Ms.i().getStream("event", this.mapNo);
       int start_pos = 0;
       if (data.length == 1) {
          this.eventCount = 0;
       }else {
          start_pos = start_pos + 1;
          this.eventCount = data[start_pos];
          if (this.mapInfo[(this.mapNo * 2)] < 1) {
             this.event_now_list[this.mapNo] = null;
             short[] oshortArray = new short[this.eventCount];
             this.event_now_list[this.mapNo] = oshortArray;
          }else {
             i = 0;
             while (i < this.eventCount) {
                if (this.isMapEvent(this.mapNo, i)) {
                   this.event_now_list[this.mapNo][i] = 0x5ea0;
                }
                ix = i + 1;
                i = (byte)ix;
             }
          }
          this.event_now = this.event_now_list[this.mapNo];
          byte[][] uobyteArray = new byte[][this.eventCount];
          this.event = uobyteArray;
          short length_ = 0;
          i = 0;
          start_pos = start_pos;
          while (i < this.eventCount) {
             start_pos = start_pos + 1;
             ix = data[start_pos] << 8;
             start_pos = start_pos + 1;
             int ix1 = data[start_pos] & 0x00ff;
             ix = ix | ix1;
             length_ = (short)ix;
             byte[] uobyteArray1 = new byte[length_];
             this.event[i] = uobyteArray1;
             System.arraycopy(data, start_pos, this.event[i], 0, this.event[i].length);
             start_pos = start_pos + length_;
             ix = i + 1;
             i = (byte)ix;
          }
       }
       return;
    }
    byte[][] createItem(byte[] data,byte[][] npc){
       int skip2;
       int i;
       int ix;
       byte[] uobyteArray;
       int j;
       int ix1;
       npc = null;
       if (this.mapInfo[(this.mapNo * 2)] > 0) {
          data = this.mapTemp[this.mapNo];
          Ms.i();
          skip2 = Ms.skip2;
          Ms.skip2 = skip2 + 1;
          npc = new byte[][data[skip2]];
          i = 0;
          while (i < npc.length) {
             Ms.i();
             skip2 = Ms.skip2;
             ix = skip2 + 1;
             Ms.skip2 = ix;
             uobyteArray = new byte[data[skip2]];
             npc[i] = uobyteArray;
             for (j = 0; j < npc[i].length; j++) {
                Ms.i();
                ix = Ms.skip2;
                ix1 = ix + 1;
                Ms.skip2 = ix1;
                npc[i][j] = data[ix];
             }
             i++;
          }
       }else {
          Ms.i();
          skip2 = Ms.skip;
          Ms.skip = skip2 + 1;
          npc = new byte[][data[skip2]];
          i = 0;
          while (i < npc.length) {
             Ms.i();
             skip2 = Ms.skip;
             ix = skip2 + 1;
             Ms.skip = ix;
             uobyteArray = new byte[data[skip2]];
             npc[i] = uobyteArray;
             for (j = 0; j < npc[i].length; j++) {
                Ms.i();
                ix = Ms.skip;
                ix1 = ix + 1;
                Ms.skip = ix1;
                npc[i][j] = data[ix];
             }
             i++;
          }
       }
       return npc;
    }
    public void createLayer(){
       this.createMap();
       this.setMapData();
    }
    Npc[] createNpc(byte[] data,Npc[] npc){
       int j;
       int skip2;
       npc = null;
       Ms.i();
       int skip = Ms.skip;
       Ms.skip = skip + 1;
       npc = new Npc[data[skip]];
       for (int i = 0; i < npc.length; i++) {
          Ms.i();
          int skip1 = Ms.skip;
          skip2 = skip1 + 1;
          Ms.skip = skip2;
          npc[i] = new Npc(data[skip1]);
          for (j = 0; j < npc[i].other.length; j++) {
             Ms.i();
             skip1 = Ms.skip;
             skip2 = skip1 + 1;
             Ms.skip = skip2;
             npc[i].other[j] = data[skip1];
          }
          npc[i].setXY_npc();
       }
       if (this.mapInfo[(this.mapNo * 2)] > 0) {
          i = 0;
          while (i < npc.length) {
             if (npc[i].other[9] == 1) {
                for (j = 0; j < npc[i].other.length; j++) {
                   Ms.i();
                   skip2 = Ms.skip2;
                   int ix = skip2 + 1;
                   Ms.skip2 = ix;
                   npc[i].other[j] = this.mapTemp[this.mapNo][skip2];
                }
                npc[i].setXY_npc();
             }
             i++;
          }
       }
       return npc;
    }
    public byte[] createNpcPos(byte[] data,byte[] npc){
       npc = null;
       Ms.i();
       int skip = Ms.skip;
       Ms.skip = skip + 1;
       npc = new byte[data[skip]];
       for (int i = 0; i < npc.length; i++) {
          Ms.i();
          skip = Ms.skip;
          int ix = skip + 1;
          Ms.skip = ix;
          npc[i] = data[skip];
       }
       return npc;
    }
    public void createNpcString(){
       this.npcNameData = Ms.i().loadText(this.initData(this.gr.createData(1), this.mapNo));
       this.npcStringData = Ms.i().loadText(this.initData(this.gr.createData(2), this.mapNo));
    }
    public void createOther(){
       byte[] Datas = null;
       Ms.i();
       Ms.skip = 0;
       Ms.i();
       Ms.skip2 = 0;
       Datas = this.initData(this.gr.createData(0), this.mapNo);
       this.npcPos = this.createNpcPos(Datas, this.npcPos);
       if (this.mapInfo[(this.mapNo * 2)] > 0 && this.mapTemp[this.mapNo] == null) {
          this.mapTemp[this.mapNo] = Ms.i().rmsOptions((this.mapNo + 14), null, 1);
       }
       this.npc[0] = this.createNpc(Datas, this.npc[0]);
       this.npc[1] = this.createNpc(Datas, this.npc[1]);
       this.npc[2] = this.createNpc(Datas, this.npc[2]);
       this.item = this.createItem(Datas, this.item);
       this.door = this.createItem(Datas, this.door);
       this.npcList = null;
       byte[] uobyteArray = new byte[((this.npc[0].length + 1) + this.item.length)];
       this.npcList = uobyteArray;
       Datas = null;
       this.initNpcAni();
       return;
    }
    public void doKey(){
       int i = 0;
       switch (this.map_key){
           case 0xffffffc7:
             Ms.i().keyRelease();
             if (this.gr.rmsOther[2] > 0) {
                this.initAnoleValue();
             }
             break;
           case 0xffffffc9:
           case 0xffffffcb:
           case 5:
             if (this.gr.isTalk != null) {
                this.checkSoftKey(this.my.x, this.my.y, (this.dir_select[this.my.dir][i] * this.my.speed), (this.dir_select[this.my.dir][1] * this.my.speed));
             }
             break;
           case 0xffffffcd:
             this.goMission(1, i);
             break;
           case 0xffffffcf:
             this.goMission(i, i);
             break;
           case 0xffffffd0:
             this.goMiniMap();
             break;
           case 1:
           case 3:
           case 4:
           case 2:
             if (this.my.dir != this.map_key) {
                this.turnAround(this.map_key);
             }
             this.canMove((this.dir_select[this.map_key][i] * this.my.speed), (this.dir_select[this.map_key][1] * this.my.speed));
             break;
       }
       return;
    }
    public void drawBlackSRC(Graphics g,int y,boolean mode){
       int i2;
       int i3;
       int WIDTH = Constants_H.WIDTH__;
       int HEIGHT = Constants_H.HEIGHT__;
       int WIDTH_H = Constants_H.WIDTH__ / 2;
       int FONT_W = 25;
       int FONT_H = 25;
       g.setColor(0xffffff);
       short d = 0;
       int i = (((this.black_0 - 5)) > 0)? this.black_0 - 5: 0;
       short offy = (byte)i;
       if (this.gr.about_d != null) {
          while (true) {
             if (mode) {
                if (d >= this.gr.about_d.length) {
                label_009d :
                   if (!mode) {
                      g.setColor(0);
                      FONT_W = 40;
                      g.fillRect(0, 0, WIDTH, FONT_W);
                      g.fillRect(0, (HEIGHT - 40), WIDTH, 40);
                   }
                   if (this.black_0 == this.gr.about_d.length) {
                      this.gr.drawZero(WIDTH_H, ((HEIGHT - FONT_H) - 4), (1 | 0x20), 0);
                      break ;
                   }else if(!mode){
                      i = (short)(this.black_1 + 10);
                      this.black_1 = i;
                      if (i >= WIDTH_H) {
                         this.black_1 = 0;
                         this.black_0 = (short)(this.black_0 + 1);
                         break ;
                      }
                   }
                   if (mode) {
                      this.black_0 = (byte)this.gr.about_d.length;
                      break ;
                   }
                }else if(!mode){
                   if (this.black_0 == d) {
                      int i1 = d - offy;
                      i2 = FONT_H + 4;
                      i1 = i1 * 29;
                      i1 = i1 + y;
                      i2 = this.black_1 << 1;
                      i3 = FONT_H + 4;
                      g.setClip(0, i1, i2, i3);
                   }
                   i2 = d - offy;
                   i3 = FONT_H + 4;
                   i2 = i2 * 29;
                   i2 = i2 + y;
                   Ui.i().drawStringColor(this.gr.about_d[d].toString(), FONT_W, i2, 0, 0);
                   g.setClip(0, 0, WIDTH, HEIGHT);
                }else {
                   i = Ms.i().getStringWidth(this.gr.about_d[d].toString()) - this.gr.getSIndexW(this.gr.about_d[d].toString());
                   short sw = (short)i;
                   i = WIDTH - sw;
                   int i4 = i >> 1;
                   i = FONT_H + 4;
                   i = d * 29;
                   i = i + y;
                   int i5 = i + 6;
                   Ui.i().drawStringColor(this.gr.about_d[d].toString(), i4, i5, 0, 0);
                }
                i3 = d + 1;
                d = (short)i3;
             }else if(d <= this.black_0 && d < this.gr.about_d.length){
             }else {
                goto label_009d ;
             }
          }
       }
       return;
    }
    void drawMap(Graphics g){
       int tempLeftCol = this.leftCol;
       int tempTopRow = this.topRow;
       if (this.map_x >= null) {
          this.leftCol = 0;
          this.map_left = this.map_x;
       }else {
          this.leftCol = (short)((- this.map_x) / 20);
          this.map_left = this.map_x % 20;
       }
       if (this.map_y >= null) {
          this.topRow = 0;
          this.map_top = this.map_y;
       }else {
          this.topRow = (short)((- this.map_y) / 20);
          this.map_top = this.map_y % 20;
       }
       int left = this.leftCol * 20;
       int top = this.topRow * 20;
       if (this.firstDrawMap == null) {
          this.firstDrawMap = 1;
          this.bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g, 0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
       }else if(this.leftCol == tempLeftCol && this.topRow == tempTopRow){
          g.setClip(0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT);
          g.copyArea(0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, ((tempLeftCol - this.leftCol) * 20), ((tempTopRow - this.topRow) * 20), 20);
          if (this.leftCol < tempLeftCol) {
             this.bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g, 0, 0, ((tempLeftCol - this.leftCol) * 20), Constants_H.OFF_HEIGHT, true);
          }else if(this.leftCol > tempLeftCol){
             this.bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g, (Constants_H.OFF_WIDTH + ((tempLeftCol - this.leftCol) * 20)), 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
          }
          if (this.topRow < tempTopRow) {
             this.bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g, 0, 0, Constants_H.OFF_WIDTH, ((tempTopRow - this.topRow) * 20), true);
          }else if(this.topRow > tempTopRow){
             this.bkgroundToPaint(this.bottomData, this.mapImg, left, top, this.moduleData, g, 0, (Constants_H.OFF_HEIGHT + ((tempTopRow - this.topRow) * 20)), Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
          }
       }
       left = this.map_top;
       top = 20;
       Map.g.drawImage(GameRun.scrT, this.map_left, left, top);
       return;
    }
    public void drawMyAni(Npc my,int my_id,int x,int y,int action_id){
       int i = 4;
       byte id = (byte)my_id;
       if (my.now_action >= Map.npcSp[1][id].aLength(action_id)) {
          my.now_action = 0;
       }
       if (this.anole_type != 2 && this.anole_type != i) {
          Ui.i().drawImage(this.imgShadow, x, y, 33);
       }
       Ui ui = Ui.i();
       object oobject = Map.npcSp[1][id];
       int i1 = Map.npcSp[1][id].action(action_id, my.now_action, 0);
       int i2 = (my.dir == i)? 1: 0;
       ui.drawFrameOne(oobject, i1, x, y, i2);
       byte b = (byte)(my.now_time + 1);
       my.now_time = b;
       if (b > Map.npcSp[1][id].action(action_id, my.now_action, 1)) {
          my.now_action = (byte)(my.now_action + 1);
          my.now_time = 0;
       }
       return;
    }
    public void eventCheck(){
       Map map;
       int ix;
       int ix1;
       int ix2;
       int bt;
       int ix5;
       int ix8;
       int event_temp = 0;
       int i = 0;
       while (this.event != null && i < this.event.length) {
          if (this.event[i] != null && this.event_now[i] < this.event[i].length) {
             do {
                this.event_state = 0;
                if (this.event_now[i] >= this.event[i].length) {
                   map = this.mapInfo;
                   ix = this.mapNo * 2;
                   ix = ix + 1;
                   ix1 = 1 << i;
                   ix2 = map[ix] | ix1;
                   map[ix] = (short)ix2;
                   break ;
                }else {
                   switch (this.event[i][this.event_now[i]]){
                       case 1:
                         ix = this.event_now[i] + 2;
                         event_temp = this.event[i][ix] - 1;
                         if (event_temp != -1) {
                            this.now_eV1 = this.getNpcLayer(event_temp);
                            this.now_eV2 = this.getNpcId(event_temp);
                            bt = (this.my.state == 2 && this.get_meet == this.now_eV2)? true: 0;
                            ix = this.event_now[i] + 3;
                            this.ifEvent(i, 4, 16, this.event[i][ix], bt);
                         }
                         break;
                       case 2:
                         ix = this.event_now[i] + 2;
                         this.now_eV1 = this.event[i][ix];
                         ix = this.event_now[i] + 3;
                         this.now_eV2 = this.event[i][ix];
                         ix = this.event_now[i] + 4;
                         this.ifEvent(i, 5, 4112, this.event[i][ix], this.isMapEvent(this.now_eV1, this.now_eV2));
                         break;
                       case 3:
                         ix2 = this.event_now[i] + 2;
                         ix = this.event[i][ix2] * 100;
                         bt = (this.gr.money >= ix)? true: 0;
                         ix = this.event_now[i] + 3;
                         this.ifEvent(i, 4, 16, this.event[i][ix], bt);
                         break;
                       case 4:
                         ix2 = this.event_now[i] + 2;
                         bt = (this.gr.monInfoList[103] >= this.event[i][ix2])? true: false;
                         ix = this.event_now[i] + 3;
                         this.ifEvent(i, 4, 16, this.event[i][ix], bt);
                         break;
                       case 5:
                         ix1 = this.event_now[i] + 2;
                         event_temp = this.gr.findItem(-2, this.event[i][ix1], true);
                         ix = this.event_now[i] + 3;
                         if (!this.event[i][ix]) {
                            bt = (!event_temp)? true: 0;
                         }else {
                            ix = this.event_now[i] + 3;
                            bt = (event_temp >= this.event[i][ix])? true: 0;
                         }
                         ix = this.event_now[i] + 4;
                         this.ifEvent(i, 5, 16, this.event[i][ix], bt);
                         break;
                       case 6:
                         ix = this.event_now[i] + 2;
                         int ix3 = this.event[i][ix] * 20;
                         ix = this.event_now[i] + 3;
                         int ix4 = this.event[i][ix] * 20;
                         ix = this.event_now[i] + 4;
                         ix2 = this.event_now[i] + 2;
                         ix5 = this.event[i][ix] - this.event[i][ix2];
                         ix5 = ix5 + 1;
                         int ix6 = ix5 * 20;
                         ix = this.event_now[i] + 5;
                         ix2 = this.event_now[i] + 3;
                         ix5 = this.event[i][ix] - this.event[i][ix2];
                         ix5 = ix5 + 1;
                         int ix7 = ix5 * 20;
                         bt = Ms.i().isRect(this.my.x, this.my.y, 19, 19, ix3, ix4, ix6, ix7);
                         ix = this.event_now[i] + 6;
                         this.ifEvent(i, 7, 16, this.event[i][ix], bt);
                         break;
                       case 7:
                       case 9:
                       case 10:
                       case 14:
                       case 20:
                       case 34:
                         break;
                       case 8:
                         ix2 = this.event_now[i] + 2;
                         ix1 = this.event_now[i] + 3;
                         bt = (this.gr.findMonster(this.event[i][ix2], this.event[i][ix1]) != -1)? true: 0;
                         ix = this.event_now[i] + 4;
                         this.ifEvent(i, 5, 16, this.event[i][ix], bt);
                         break;
                       case 11:
                         ix = this.event_now[i] + 2;
                         event_temp = this.event[i][ix] - 1;
                         this.now_eV1 = this.getNpcLayer(event_temp);
                         this.now_eV2 = this.getNpcId(event_temp);
                         ix2 = this.event_now[i] + 3;
                         if (this.npc[this.now_eV1][this.now_eV2].other[8] == this.event[i][ix2]) {
                            map = this.event_now;
                            ix = map[i] + 4;
                            map[i] = (short)ix;
                            this.nextEvent(16);
                         }else {
                            this.setEventNow(i, 0);
                         }
                         break;
                       case 12:
                         this.runEvent_select(i);
                         break;
                       case 13:
                         if (this.eventGoing == null) {
                            this.eventGoing = 1;
                            ix = this.event_now[i] + 3;
                            if (!this.event[i][ix]) {
                               ix1 = this.event_now[i] + 2;
                               if ((this.bMission[14] = this.event[i][ix1]) != -1) {
                                  this.gr.say("#4\x4e\x02\x7e\x02\x4e\x02\x52\x02#0\x5d\x02\x66\x02\x65\x02\xff\x02\x70\x02\x51\x02#7\x5d\x02\x51\x02\x53\x02\x51\x02\x76\x02\x4e\x02\x7e\x02\x63\x02\x94\x02#0\x53\x02\x67\x02\x77\x02\x4e\x02\x52\x02\x88\x02\x30\x02", -1);
                               }
                            }else {
                               ix = this.event_now[i] + 2;
                               ix5 = this.event[i][ix];
                               ix2 = this.event_now[i] + 3;
                               ix = (this.event[i][ix2] == 2)? 1: 0;
                               this.setMission(ix5, ix);
                               ix = this.event_now[i] + 3;
                               if (this.event[i][ix] == 2) {
                                  this.gr.say("#4\x52\x02\x65\x02\x4e\x02\x52\x02#0\x5d\x02\x66\x02\x65\x02\xff\x02\x70\x02\x51\x02#7\x5d\x02\x51\x02\x53\x02\x51\x02\x76\x02\x65\x02\x7e\x02\x63\x02\x94\x02#0\x53\x02\x67\x02\x77\x02\x4e\x02\x52\x02\x88\x02\x30\x02", -1);
                               }
                            }
                         }else if(this.gr.say_c == null){
                            map = this.event_now;
                            ix = map[i] + 4;
                            map[i] = (short)ix;
                            this.nextEvent(272);
                         }
                         break;
                       case 15:
                         ix = this.event_now[i] + 2;
                         ix5 = (!this.event[i][ix])? 1: 0;
                         this.setEventNow(i, ix5);
                         break;
                       case 16:
                         this.runEvent_goShop(i);
                         break;
                       case 17:
                         ix = this.event_now[i] + 2;
                         this.now_eV1 = this.event[i][ix];
                         ix = this.event_now[i] + 3;
                         this.now_eV2 = this.event[i][ix];
                         map = this.event_now;
                         ix = map[i] + 4;
                         map[i] = (short)ix;
                         this.setOverEvent(this.now_eV1, this.now_eV2);
                         this.nextEvent(4112);
                         break;
                       case 18:
                         this.runEvent_item_add_del(i);
                         break;
                       case 19:
                         Ms.i();
                         Ms.skip = 0;
                         byte[] data = Ms.i().getStream("data/battle/boss.d", -1);
                         byte[][] bossStream = Ms.i().create2Array(data);
                         data = null;
                         ix = this.event_now[i] + 1;
                         event_temp = this.event[i][ix] >> 1;
                         int[] ointArray = new int[]{event_temp,5};
                         this.gr.enemyList = Array.newInstance(Byte.TYPE, ointArray);
                         this.now_eV2 = 0;
                         while (this.now_eV2 < event_temp) {
                            ix = this.event_now[i] + 2;
                            ix2 = this.now_eV2 * 2;
                            ix = ix + ix2;
                            this.now_eV1 = this.event[i][ix];
                            this.gr.enemyList[this.now_eV2][0] = bossStream[this.now_eV1][0];
                            ix1 = this.event_now[i] + 3;
                            ix8 = this.now_eV2 * 2;
                            ix1 = ix1 + ix8;
                            this.gr.enemyList[this.now_eV2][1] = this.event[i][ix1];
                            this.gr.enemyList[this.now_eV2][2] = bossStream[this.now_eV1][1];
                            this.gr.enemyList[this.now_eV2][3] = bossStream[this.now_eV1][2];
                            this.gr.enemyList[this.now_eV2][4] = bossStream[this.now_eV1][3];
                            ix5 = this.now_eV2 + 1;
                            this.now_eV2 = (byte)ix5;
                         }
                         bossStream = null;
                         Sound.i().setMusicId(6);
                         Sound.i().setMusic(false);
                         this.gr.battleType(3);
                         this.gr.goBattle();
                         map = this.event_now;
                         ix1 = this.event_now[i] + 1;
                         ix2 = this.event[i][ix1] + 2;
                         ix = map[i] + ix2;
                         map[i] = (short)ix;
                         break;
                       case 21:
                         if (this.eventGoing == null) {
                            this.eventGoing = 1;
                            ix = this.event_now[i] + 2;
                            if ((event_temp = this.event[i][ix] * 100) < 0) {
                               Ms.i();
                               if (this.gr.money < Ms.abs(event_temp)) {
                                  this.gr.say("\x91\x02\x94\x02\x4e\x02\x8d\x02\xff\x02", 0);
                                  this.eventGoing = 2;
                               }
                            }
                            if (this.eventGoing == 1) {
                               map = this.gr;
                               ix = map.money + event_temp;
                               map.money = ix;
                               map = this.gr;
                               String str = (event_temp < 0)? "\x59\x02\x53\x02\xff\x02": "\x83\x02\x5f\x02\xff\x02";
                               Ms.i();
                               map.say(String.valueOf(str).append(Ms.abs(event_temp)).append("\x91\x02").toString(), 0);
                            }
                         }else if(this.gr.say_c == null){
                            if (this.eventGoing == 2) {
                               this.setEventNow(i, 1);
                            }else {
                               map = this.event_now;
                               ix = map[i] + 3;
                               map[i] = (short)ix;
                               this.nextEvent(272);
                            }
                         }
                         break;
                       case 22:
                         ix = this.event_now[i] + 2;
                         ix2 = this.event_now[i] + 3;
                         ix1 = this.event_now[i] + 4;
                         ix8 = this.event_now[i] + 5;
                         this.exitBoss(this.event[i][ix], this.event[i][ix2], this.event[i][ix1], this.event[i][ix8]);
                         map = this.event_now;
                         ix = map[i] + 6;
                         map[i] = (short)ix;
                         this.nextEvent(16);
                         break;
                       case 23:
                         ix = this.event_now[i] + 2;
                         this.now_eV1 = this.event[i][ix];
                         ix = this.event_now[i] + 3;
                         this.now_eV2 = this.event[i][ix];
                         map = this.event_now;
                         ix = map[i] + 4;
                         map[i] = (short)ix;
                         this.setRestEvent(this.now_eV1, this.now_eV2);
                         this.nextEvent(4112);
                         break;
                       case 24:
                         ix = this.event_now[i] + 2;
                         this.initBoat(this.event[i][ix]);
                         map = this.event_now;
                         ix = map[i] + 3;
                         map[i] = (short)ix;
                         this.nextEvent(16);
                         break;
                       case 25:
                         ix2 = this.event_now[i] + 2;
                         ix = this.event[i][ix2] + 1;
                         this.gr.overMode = (byte)ix;
                         map = this.event_now;
                         ix = map[i] + 3;
                         map[i] = (short)ix;
                         break;
                       case 26:
                         this.runEvent_getMon(i);
                         break;
                       case 27:
                         if (this.eventGoing == null) {
                            ix2 = this.event_now[i] + 2;
                            ix1 = this.event_now[i] + 3;
                            this.now_eV2 = this.gr.findMonsterMinLv(this.event[i][ix2], this.event[i][ix1]);
                            if (this.now_eV2 != -1) {
                               this.now_eV1 = this.gr.delMonster(this.now_eV2);
                               this.eventGoing = 1;
                            }else {
                               this.setEventNow(i, 0);
                            }
                         }else if(this.gr.say_c == null){
                            if (this.now_eV1 == -1) {
                               this.setEventNow(i, 0);
                            }else {
                               map = this.event_now;
                               ix1 = this.event_now[i] + 1;
                               ix2 = this.event[i][ix1] + 2;
                               ix = map[i] + ix2;
                               map[i] = (short)ix;
                               this.nextEvent(4368);
                            }
                         }
                         break;
                       case 28:
                         this.runEvent_dialog(i);
                         break;
                       case 29:
                         ix = this.event_now[i] + 2;
                         event_temp = this.event[i][ix] - 1;
                         Map.cur_npc = (event_temp == -1)? this.my: this.npc[this.getNpcLayer(event_temp)][this.getNpcId(event_temp)];
                         ix1 = this.event_now[i] + 4;
                         Map.cur_npc.setLastAction(false, this.event[i][ix1]);
                         ix1 = this.event_now[i] + 3;
                         Map.cur_npc.other[7] = this.event[i][ix1];
                         Map.cur_npc.now_action = 0;
                         map = this.event_now;
                         ix = map[i] + 5;
                         map[i] = (short)ix;
                         this.nextEvent(4096);
                         break;
                       case 30:
                         this.my.state = 10;
                         ix = this.event_now[i] + 2;
                         event_temp = this.event[i][ix] - 1;
                         Map.cur_npc = (event_temp == -1)? this.my: this.npc[this.getNpcLayer(event_temp)][this.getNpcId(event_temp)];
                         ix2 = this.event_now[i] + 3;
                         ix1 = this.event_now[i] + 4;
                         Map.cur_npc.setIXY(this.event[i][ix2], this.event[i][ix1]);
                         ix2 = this.event_now[i] + 5;
                         Map.cur_npc.speed = this.event[i][ix2];
                         Npc cur_npc = Map.cur_npc;
                         ix2 = this.event_now[i] + 6;
                         ix = (!this.event[i][ix2])? true: false;
                         cur_npc.b_check = ix;
                         Map.cur_npc.setLastAction(false, 127);
                         map = this.event_now;
                         ix = map[i] + 7;
                         map[i] = (short)ix;
                         this.nextEvent(16);
                         break;
                       case 31:
                         ix = this.event_now[i] + 2;
                         event_temp = this.event[i][ix] - 1;
                         if (event_temp == -1) {
                            ix = this.event_now[i] + 3;
                            this.now_eV1 = this.event[i][ix];
                            this.my.dir = this.now_eV1;
                            this.my.setActionNo(false);
                         }else {
                            this.now_eV1 = this.getNpcLayer(event_temp);
                            if (this.now_eV1 == null) {
                               this.now_eV2 = this.getNpcId(event_temp);
                               ix2 = this.event_now[i] + 3;
                               this.npc[this.now_eV1][this.now_eV2].dir = this.event[i][ix2];
                               this.npc[this.now_eV1][this.now_eV2].setActionNo(false);
                            }
                         }
                         map = this.event_now;
                         ix = map[i] + 4;
                         map[i] = (short)ix;
                         this.nextEvent(4112);
                         break;
                       case 32:
                         this.runEvent_miniGame_myLevel(i);
                         break;
                       case 33:
                         ix = this.event_now[i] + 2;
                         ix5 = this.event[i][ix] - 1;
                         this.anole_type = (byte)ix5;
                         this.setAnole();
                         map = this.event_now;
                         ix = map[i] + 3;
                         map[i] = (short)ix;
                         this.nextEvent(16);
                         break;
                       case 35:
                         ix = this.event_now[i] + 2;
                         event_temp = this.event[i][ix] - 1;
                         if (event_temp == -1) {
                            ix1 = this.event_now[i] + 3;
                            this.my.other[4] = this.event[i][ix1];
                            ix = this.event_now[i] + 3;
                            switch (this.event[i][ix]){
                                case 0:
                                case 2:
                                  this.my.state = 0;
                                  break;
                                case 1:
                                case 3:
                                  this.my.state = 10;
                                  break;
                            }
                         }else {
                            this.now_eV1 = this.getNpcLayer(event_temp);
                            this.now_eV2 = this.getNpcId(event_temp);
                            ix1 = this.event_now[i] + 3;
                            this.npc[this.now_eV1][this.now_eV2].other[4] = this.event[i][ix1];
                         }
                         map = this.event_now;
                         ix = map[i] + 4;
                         map[i] = (short)ix;
                         this.nextEvent(4112);
                         break;
                       case 36:
                         ix = this.event_now[i] + 2;
                         event_temp = this.event[i][ix] - 1;
                         this.now_eV1 = this.getNpcLayer(event_temp);
                         this.now_eV2 = this.getNpcId(event_temp);
                         ix1 = this.event_now[i] + 3;
                         ix2 = this.event[i][ix1] + 1;
                         this.npc[this.now_eV1][this.now_eV2].other[5] = (byte)ix2;
                         map = this.event_now;
                         ix = map[i] + 4;
                         map[i] = (short)ix;
                         this.nextEvent(4112);
                         break;
                       case 37:
                         this.my.state = 10;
                         ix = this.event_now[i] + 2;
                         event_temp = this.event[i][ix] - 1;
                         Map.cur_npc = (event_temp == -1)? this.my: this.npc[this.getNpcLayer(event_temp)][this.getNpcId(event_temp)];
                         ix1 = this.event_now[i] + 6;
                         Map.cur_npc.setLastAction(true, this.event[i][ix1]);
                         ix2 = this.event_now[i] + 3;
                         ix1 = this.event_now[i] + 4;
                         Map.cur_npc.setIXY(this.event[i][ix2], this.event[i][ix1]);
                         ix1 = this.event_now[i] + 5;
                         Map.cur_npc.other[7] = this.event[i][ix1];
                         ix = this.event_now[i] + 5;
                         if (this.event[i][ix] < 0) {
                            Map.cur_npc.dir = 4;
                         }
                         ix2 = this.event_now[i] + 7;
                         Map.cur_npc.speed = this.event[i][ix2];
                         map = this.event_now;
                         ix = map[i] + 8;
                         map[i] = (short)ix;
                         this.nextEvent(16);
                         break;
                       case 38:
                         this.runEvent_brow(i);
                         break;
                       case 39:
                         ix = this.event_now[i] + 2;
                         this.now_eV1 = this.event[i][ix];
                         ix = this.event_now[i] + 3;
                         this.now_eV2 = this.event[i][ix];
                         ix = this.now_eV1 * 2;
                         ix = ix + 4;
                         ix = 1 << this.now_eV2;
                         if (ix5 = this.gr.rmsOther[ix] & ix) {
                            map = this.event_now;
                            ix = map[i] + 4;
                            map[i] = (short)ix;
                            this.nextEvent(4113);
                         }
                         break;
                       case 40:
                         ix = this.event_now[i] + 2;
                         event_temp = this.event[i][ix] - 1;
                         if (event_temp == -1) {
                            Ms.i();
                            ix1 = this.event_now[i] + 3;
                            this.my.other[7] = (byte)Ms.abs(this.event[i][ix1]);
                            ix = this.event_now[i] + 3;
                            if (this.event[i][ix] < 0) {
                               this.my.dir = 4;
                            }
                         }else {
                            Map.cur_npc = this.npc[this.getNpcLayer(event_temp)][this.getNpcId(event_temp)];
                            ix1 = this.event_now[i] + 3;
                            Map.cur_npc.other[7] = this.event[i][ix1];
                            ix2 = Map.cur_npc.other[3] - 1;
                            Map.cur_npc.setNpcNum(Map.npcSp[ix2][Map.cur_npc.other[2]].aLength());
                         }
                         map = this.event_now;
                         ix = map[i] + 4;
                         map[i] = (short)ix;
                         this.nextEvent(16);
                         break;
                       case 41:
                         ix = this.event_now[i] + 2;
                         event_temp = this.event[i][ix] - 1;
                         if (event_temp == -1) {
                            ix2 = this.event_now[i] + 3;
                            ix1 = this.event_now[i] + 4;
                            this.my.setXY(this.event[i][ix2], this.event[i][ix1], 0, 0);
                            if ((this.my.frame_c = -1) == -1) {
                               ix = this.event_now[i] + 3;
                               this.map_x = this.map_set(this.event[i][ix], this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20);
                               ix = this.event_now[i] + 4;
                               this.map_y = this.map_set(this.event[i][ix], this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20);
                            }
                         }else {
                            this.now_eV1 = this.getNpcLayer(event_temp);
                            this.now_eV2 = this.getNpcId(event_temp);
                            ix1 = this.event_now[i] + 3;
                            this.npc[this.now_eV1][this.now_eV2].other[0] = this.event[i][ix1];
                            ix1 = this.event_now[i] + 4;
                            this.npc[this.now_eV1][this.now_eV2].other[1] = this.event[i][ix1];
                            this.npc[this.now_eV1][this.now_eV2].setXY_npc();
                         }
                         map = this.event_now;
                         ix = map[i] + 5;
                         map[i] = (short)ix;
                         this.nextEvent(4112);
                         break;
                       case 42:
                         ix = this.event_now[i] + 2;
                         this.now_eV1 = this.event[i][ix];
                         ix = this.event_now[i] + 3;
                         this.now_eV2 = this.event[i][ix];
                         Mg.i().go(this.gr, this.now_eV1, -1, this.now_eV2);
                         map = this.event_now;
                         ix = map[i] + 4;
                         map[i] = (short)ix;
                         this.nextEvent(4113);
                         break;
                       case 43:
                         ix = this.event_now[i] + 2;
                         event_temp = this.event[i][ix] - 1;
                         this.now_eV1 = this.getNpcLayer(event_temp);
                         this.now_eV2 = this.getNpcId(event_temp);
                         ix1 = this.event_now[i] + 3;
                         this.npc[this.now_eV1][this.now_eV2].other[8] = this.event[i][ix1];
                         map = this.event_now;
                         ix = map[i] + 4;
                         map[i] = (short)ix;
                         this.nextEvent(16);
                         break;
                       case 44:
                         ix = this.event_now[i] + 2;
                         if (!(event_temp = this.event[i][ix])) {
                            bt = this.gr.gameCheckRegIsOK();
                            this.ifEvent(i, 3, 16, 2, bt);
                         }else if(event_temp == 1){
                            if (!this.gr.gameCheckRegIsOK()) {
                               map = this.event_now;
                               ix = map[i] + 3;
                               map[i] = (short)ix;
                               this.nextEvent(0);
                               this.checkRegWhere0(i);
                            }
                         }else if(event_temp == 2){
                            this.ifEvent(i, 3, 16, 2, this.gr.gameCheckRegIsOK());
                         }
                         break;
                       case 45:
                         this.runEvent_srcMove(i);
                         break;
                       case 46:
                         ix2 = this.event_now[i] + 2;
                         Sound.i().setMusicId(this.event[i][ix2]);
                         Sound.i().setMusic(false);
                         map = this.event_now;
                         ix = map[i] + 3;
                         map[i] = (short)ix;
                         this.nextEvent(16);
                         break;
                       case 47:
                         this.my.state = 10;
                         ix5 = this.sleep_count + 1;
                         ix5 = (byte)ix5;
                         this.sleep_count = ix5;
                         ix2 = this.event_now[i] + 2;
                         if (ix5 == this.event[i][ix2]) {
                            this.sleep_count = 0;
                            map = this.event_now;
                            ix = map[i] + 3;
                            map[i] = (short)ix;
                            this.nextEvent(17);
                         }
                         break;
                       case '0':
                         this.my.state = 10;
                         ix = this.event_now[i] + 2;
                         ix5 = this.event[i][ix] << 1;
                         this.srcFlash_c = (byte)ix5;
                         map = this.event_now;
                         ix = map[i] + 3;
                         map[i] = (short)ix;
                         this.nextEvent(16);
                         break;
                       case '1':
                         if (this.gr.magic_id == -2) {
                            this.my.state = 10;
                            ix2 = this.event_now[i] + 2;
                            this.gr.magic_id = this.event[i][ix2];
                            ix1 = this.event_now[i] + 3;
                            ix2 = this.event[i][ix1] * 20;
                            ix = this.map_x + ix2;
                            ix = ix + 10;
                            this.gr.magic_x = ix;
                            ix1 = this.event_now[i] + 4;
                            ix2 = this.event[i][ix1] * 20;
                            ix = this.map_y + ix2;
                            ix = ix + 20;
                            this.gr.magic_y = ix;
                            ix2 = this.event_now[i] + 2;
                            ix = this.event[i][ix2] / 5;
                            this.gr.setMagic(ix);
                         }else if(this.gr.magic_id == -1){
                            this.gr.magic_id = -2;
                            map = this.event_now;
                            ix = map[i] + 5;
                            map[i] = (short)ix;
                            this.nextEvent(16);
                         }
                         break;
                       case '2':
                         if (this.my.state != 24 && this.my.state != 25) {
                            if (this.my.frame_c == -1 && this.my.state != 23) {
                               this.my.state = 23;
                            }
                         }else {
                            map = this.event_now;
                            ix = map[i] + 3;
                            map[i] = (short)ix;
                            this.nextEvent(0);
                            if (this.my.state == 24) {
                               this.gr.say("\x4f\x02\x5b\x02\x8f\x02\x5e\x02\x5b\x02\x62\x02", 1);
                               this.gr.saveGame();
                            }
                            this.my.state = 0;
                         }
                         break;
                       case '3':
                         ix = this.event_now[i] + 2;
                         switch (this.event[i][ix]){
                             case 0:
                               if (this.eventGoing == null) {
                                  ix1 = this.event_now[i] + 4;
                                  bt = this.event_now[i] + 3;
                                  this.gr.say(Ms.i().getDialogs(this.event[i], ix1, this.event[i][bt]), -1);
                                  this.eventGoing = 1;
                               }else if(this.gr.say_c == null){
                                  map = this.event_now;
                                  ix1 = this.event_now[i] + 3;
                                  ix2 = this.event[i][ix1] << 1;
                                  ix2 = ix2 + 4;
                                  ix = map[i] + ix2;
                                  map[i] = (short)ix;
                                  this.nextEvent(272);
                               }
                               break;
                             case 1:
                             case 2:
                               if (this.eventGoing == null) {
                                  int FONT_W = 25;
                                  this.my.state = 22;
                                  this.black_1 = 0;
                                  this.black_0 = 0;
                                  Ms.i();
                                  Ms.font.setSize(22);
                                  this.fontSizeControl = true;
                                  ix1 = this.event_now[i] + 4;
                                  bt = this.event_now[i] + 3;
                                  String dialogs = Ms.i().getDialogs(this.event[i], ix1, this.event[i][bt]);
                                  ix1 = FONT_W * 2;
                                  ix2 = Constants_H.WIDTH__ - ix1;
                                  this.gr.setStringB(dialogs, ix2, 3);
                                  Ms.i();
                                  Ms.font.setSize(26);
                                  this.fontSizeControl = false;
                                  ix = this.event_now[i] + 2;
                                  this.eventGoing = this.event[i][ix];
                               }else if(this.eventGoing == 3){
                                  map = this.event_now;
                                  ix1 = this.event_now[i] + 3;
                                  ix2 = this.event[i][ix1] << 1;
                                  ix2 = ix2 + 4;
                                  ix = map[i] + ix2;
                                  map[i] = (short)ix;
                                  this.nextEvent(272);
                                  this.gr.about_d = null;
                                  this.black_0 = -1;
                               }
                               break;
                             default:
                         }
                         break;
                       case '4':
                         this.my.state = 10;
                         ix = this.event_now[i] + 2;
                         this.xxx = this.event[i][ix];
                         map = this.event_now;
                         ix = map[i] + 3;
                         map[i] = (short)ix;
                         this.nextEvent(16);
                         break;
                       case '5':
                         ix = this.event_now[i] + 2;
                         if (this.initSrcEffect(this.event[i][ix])) {
                            map = this.event_now;
                            ix = map[i] + 3;
                            map[i] = (short)ix;
                            this.nextEvent(16);
                         }
                         break;
                   }
                }
             } while (this.event_state != 1);
          }
          i++;
       }
       return;
    }
    public byte exitMap(byte[][] door){
       byte go;
       if (door[this.get_meet][3] == -1) {
          go = this.mapNo;
          this.mapNo = this.lastMap;
          this.lastMap = go;
          this.lastExit = this.get_meet;
          go = -1;
       }else {
          go = this.mapNo;
          this.mapNo = door[this.get_meet][4];
          this.lastMap = go;
          this.lastExit = this.get_meet;
          go = door[this.get_meet][3];
       }
       return go;
    }
    public byte getMySpeed(){
       byte b;
       if (this.anole_type == null) {
          b = 6;
       }else if(this.anole_type == 1){
          b = 6;
       }else if(this.anole_type == 2){
          b = 10;
       }else if(this.anole_type == 4){
          b = 5;
       }else if(this.anole_type == 3){
          b = 10;
       }else {
          b = 5;
       }
       return b;
    }
    public void goMiniMap(){
       int ix;
       Ms.i().keyRelease();
       byte[] data = Ms.i().getStream("data/map.d", -1);
       Ms.skip = 0;
       this.mapdataArea = Ms.i().create2Array(data);
       this.mapdataMap = Ms.i().create2Array(data);
       data = null;
       this.my.state = 17;
       this.showArea = -1;
       this.myMiniMap = -1;
       this.selectMap = 0;
       byte i = 0;
       while (i < this.mapdataArea.length) {
          byte k = 0;
          while (true) {
             if (k >= this.mapdataArea[i].length) {
                ix = i + 1;
                i = (byte)ix;
             }else if(this.mapNo == this.mapdataArea[i][k]){
                this.selectMap = this.mapNo;
                if (this.mapdataMap[this.selectMap].length > 0) {
                   this.myMiniMap = this.selectMap;
                   this.showArea = i;
                   ix = (this.mapdataArea[this.showArea][0] > -1)? true: 0;
                   this.miniMapMode = ix;
                   break ;
                }
             }
             ix = k + 1;
             k = (byte)ix;
          }
          return;
       }
    }
    public void goMission(int type,boolean b){
       int ix;
       int WIDTH = 640;
       if (this.my.state == 18 || this.my.state == null) {
          Ms.i().keyRelease();
          this.bPause = b;
          GameRun.run_state = -10;
          this.my.state = 18;
          this.gr.cur_a = (byte)type;
          byte bx = 0;
          this.gr.select[0][1] = bx;
          this.gr.select[0][0] = bx;
          Ms.i();
          Ms.skip = 0;
          byte[] data = Ms.i().getStream("data/mission"+type+".t", -1);
          this.sMission = Ms.i().createString2Array(data);
          this.gr.line_max = 6;
          this.gr.about_a = null;
          if (type == 1) {
             byte i = 0;
             byte j = 0;
             byte[] tMis = new byte[50];
             while (i < this.sMission.length) {
                if (this.isMission(i)) {
                   ix = j + 1;
                   j = (byte)ix;
                   tMis[j] = i;
                   j = j;
                }
                ix = i + 1;
                i = (byte)ix;
             }
             this.mDirect = null;
             byte[] uobyteArray = new byte[j];
             this.mDirect = uobyteArray;
             System.arraycopy(tMis, 0, this.mDirect, 0, this.mDirect.length);
             if (this.mDirect.length > 0) {
                this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1], (WIDTH - 50), 0);
             }
             tMis = null;
          }else if((this.gr.select[0][0] = this.bMission[14]) >= this.gr.line_max){
             this.gr.select[0][1] = (byte)((this.gr.select[0][0] - this.gr.line_max) + 1);
          }else {
             this.gr.select[0][1] = 0;
          }
          this.gr.setStringB(this.sMission[this.gr.select[0][0]][1], (WIDTH - 50), 0);
       }
       return;
    }
    public void goNextMap(){
       int i = 5;
       this.setfmap();
       this.firstDrawMap = 0;
       this.gr.doPaint(2);
       this.saveMapBak();
       byte exit_b = this.lastExit;
       if (this.go != -2) {
          this.lastMap = this.mapNo;
          this.mapNo = this.mapNotemp;
          this.mapNotemp = 0;
          this.lastExit = this.go;
       }
       this.gr.doPaint(i);
       if (this.go == -2) {
          this.go = this.exitMap(this.door);
       }
       this.gr.setNull(0);
       this.gr.doPaint(8);
       this.createOther();
       this.gr.doPaint(10);
       if (this.go == -1) {
          this.go = exit_b;
       }
       if (this.bExitBoss == null) {
          this.getInMap(this.go, this.door);
       }
       this.createEvent();
       this.gr.doPaint(15);
       this.createNpcString();
       this.createLayer();
       this.gr.doPaint(20);
       if (this.bExitBoss == null && (this.door[this.go][i] == 1 && this.door[this.go][i] != 2)) {
          this.my.frame_c = (byte)(20 / this.my.speed);
          this.my.speed_x = (byte)(this.dir_select[this.my.dir][0] * this.my.speed);
          this.my.speed_y = (byte)(this.dir_select[this.my.dir][1] * this.my.speed);
          this.my.setActionNo(1);
       }else {
          this.my.setActionNo(0);
       }
       this.gr.b_c = 0;
       this.setMapMusic(0);
       this.go = -2;
       this.gr.initMonPro(this.mapNo, 1);
       this.gr.cityName_c = 25;
       this.srcNpcNo = -1;
       Ms.i().rmsOptions(1, null, 4);
       this.initCloud();
       this.bExitBoss = false;
       if ((this.my.state = 9) == -1) {
          this.my.state = 0;
          this.my.setIXY(-1, -1);
          this.my.speed = this.getMySpeed();
       }
       this.checkNpcT = -1;
       this.pkey.stopMove();
       return;
    }
    public boolean initAnoleValue(){
       int i;
       if (this.isAnole(this.my.x, this.my.y, this.anole_type)) {
          this.gr.say("\x4e\x02\x80\x02\x66\x02\x63\x02\x57\x02\x9a\x02", 0);
          i = 0;
       }else {
          this.my.state = 20;
          this.gr.cur_a = 0;
          this.gr.cur_b = 0;
          this.gr.setStringB("\x4e\x02\x57\x02\x9a\x02#n\x69\x02\x72\x02\x57\x02\x9a\x02#n\x91\x02\x5c\x02\x57\x02\x9a\x02#n\x98\x02\x88\x02\x57\x02\x9a\x02#n\x91\x02\x51\x02\x57\x02\x9a\x02#n\x6d\x02\x6d\x02\x57\x02\x9a\x02#n\x65\x02\x6b\x02\x57\x02\x9a\x02", Constants_H.WIDTH, 0);
          i = true;
       }
       return i;
    }
    public void initBrowImage(){
       if (this.brow == null) {
          this.brow = Ms.i().createSprite("data/face/brow", true);
       }
       return;
    }
    public byte[] initData(byte[] tempdata,int n){
       int temp;
       int len = 1;
       int i = 0;
       len = len;
       while (i < n) {
          len = len + 1;
          int ix = tempdata[len] & 0x00ff;
          ix = ix << 8;
          len = len + 1;
          int ix1 = tempdata[len] & 0x00ff;
          temp = ix | ix1;
          len = len + temp;
          i++;
          len = len;
       }
       len = len + 1;
       len = len + 1;
       temp = ((tempdata[len] & 0x00ff) << 8) | (tempdata[len] & 0x00ff);
       byte[] data = new byte[temp];
       System.arraycopy(tempdata, len, data, 0, data.length);
       return data;
    }
    public void initMap(){
       this.my.dir = 4;
       this.srcNpcNo = -1;
       this.gr.loadRmsSms();
       this.gr.loadRmsNidus();
       this.notMeet(0, 0);
       this.mapInfo = Ms.i().byteArrayToShortArray(Ms.i().rmsOptions(13, null, 1));
       this.mapChange = Ms.i().rmsOptions(1, null, 1);
       short i = 0;
       while (i < this.mapChange.length) {
          if (this.mapChange[i] == 1) {
             int ix = i + 14;
             this.mapTemp[i] = Ms.i().rmsOptions(ix, null, 1);
          }
          int ix1 = i + 1;
          i = (short)ix1;
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
       this.gr.initMonPro(this.mapNo, 1);
       this.initMissionList();
       this.initCloud();
       return;
    }
    public void initNpcAni(){
       byte j;
       int ix1;
       int ix2;
       byte k = 0;
       byte[][] em = new byte[][3];
       byte[] uobyteArray = new byte[100];
       em[0] = uobyteArray;
       uobyteArray = new byte[5];
       em[1] = uobyteArray;
       uobyteArray = new byte[60];
       em[2] = uobyteArray;
       this.gr.initNidusMap(0);
       byte i = (byte)(this.npc.length - 1);
       while (i > -1) {
          ix1 = this.npc[i].length - 1;
          j = (byte)ix1;
          k = k;
          while (j > -1) {
             ix1 = this.npc[i][j].other[3] - 1;
             em[ix1][this.npc[i][j].other[2]] = 1;
             if (!i) {
                ix2 = j + 1;
                if ((this.npcList[ix2] = j) == 1) {
                   ix2 = k + 1;
                   k = (byte)ix2;
                   this.gr.nidusMap[k] = j;
                label_00a7 :
                   ix1 = j - 1;
                   j = (byte)ix1;
                   k = k;
                }
             }
             k = k;
             goto label_00a7 ;
          }
          ix1 = i - 1;
          i = (byte)ix1;
          k = k;
       }
       this.gr.initNidusMap(1);
       this.npcList[0] = -1;
       i = (byte)(this.item.length + this.npc[0].length);
       while (i > this.npc[0].length) {
          ix2 = -2 - i;
          ix2 = ix2 + this.npc[0].length;
          ix2 = ix2 + 1;
          this.npcList[i] = (byte)ix2;
          ix1 = i - 1;
          i = (byte)ix1;
       }
       this.initNpcAni_1(100, 0, em[0]);
       this.initNpcAni_1(5, 1, em[1]);
       this.initNpcAni_1(60, 2, em[2]);
       em = null;
       j = (byte)(this.npc[0].length - 1);
       while (j > -1) {
          int ix = this.npc[0][j].other[3] - 1;
          this.npc[0][j].setNpcNum(Map.npcSp[ix][this.npc[0][j].other[2]].aLength());
          ix1 = j - 1;
          j = (byte)ix1;
       }
       return;
    }
    public void initNpcAniOne(String sid,int id,int type){
       object oobject = Map.npcSp[type];
       Ms ms = Ms.i();
       String str = "data/npc"+type+"/"+sid;
       boolean b = (type == 2)? this.gr.isNpc2ImageType(Integer.parseInt(sid)): true;
       oobject[id] = ms.createSprite(str, b);
       return;
    }
    public void initNpcFaceOne(String name){
       if (name != null) {
          byte id = -1;
          this.faceDir = true;
          if (name.equals("\x58\x02\x51\x02")) {
             id = 0;
             this.faceDir = false;
          }else if(!name.equals("\x5b\x02\x74\x02\x51\x02") && !name.equals("\x84\x02\x53\x02\x59\x02\x5b\x02")){
             if (name.equals("\x5e\x02\x66\x02\x9b\x02\x73\x02")) {
                id = 2;
             }else if(name.equals("\x67\x02\x59\x02\x68\x02\x95\x02")){
                id = 3;
             }else if(!name.equals("\x66\x02\x7f\x02") && !name.equals("\x66\x02\x7f\x02\x68\x02\x95\x02")){
                if (name.equals("\x79\x02\x79\x02\x4e\x02\x65\x02\x75\x02\x5b\x02")) {
                   id = 5;
                }else if(name.equals("\x53\x02\x5b\x02\x4e\x02")){
                   id = 6;
                }
             }else {
                id = 4;
             }
          }else {
             id = 1;
          }
          if (id > -1) {
             if (this.imgFace == null || this.faceLast != id) {
                int i = (this.faceDir != null)? 50: -50;
                this.face_c = (short)i;
                this.faceLast = id;
                this.imgFace = null;
                this.imgFace = Ms.i().createImage("data/face/"+id);
             }
          }else {
             this.nullNpcFace();
          }
       }
       return;
    }
    public boolean initSrcEffect(int mode){
       int i1;
       int i = 5;
       int SRC_BATTLE_H = Constants_H.SRC_BATTLE_H__;
       this.my.state = 10;
       switch (mode){
           case 0:
           case 2:
           case 1:
             this.bSrc_c = 0;
             i1 = (mode == 1)? SRC_BATTLE_H: 0;
             this.black_width = (short)i1;
             i1 = (mode == 1)? 1: 0;
             this.bSrc = i1;
             i1 = 1;
             break;
           case 3:
           case 5:
           case 6:
           case 4:
             this.bSrc = true;
             if (this.bSrc_c == null) {
                if (mode != 6 && mode != i) {
                   i1 = (mode == 4)? SRC_BATTLE_H: 40;
                   i1 = (short)i1;
                   this.bSrc_c = i1;
                   this.black_width = i1;
                }else {
                   this.bSrc_c = -40;
                   i1 = (mode == i)? 40: 0;
                   this.black_width = (short)i1;
                }
             }
             this.bSrc_c = Ms.i().mathSpeedN(this.bSrc_c, 0, 12, 0);
             if (this.bSrc_c == null) {
                i1 = (mode != 6)? 1: 0;
                this.bSrc = i1;
                i1 = 1;
             }else {
             }
             break;
           default:
             i1 = 0;
       }
       return i1;
    }
    public void initWalkIco(){
       if (this.walkIco == null) {
          this.walkIco = Ms.i().createImageArray(3, "data/brow/w");
       }
       return;
    }
    public void insertNpc(){
       int ix;
       if (this.npc != null) {
          byte temp = 0;
          byte i = 1;
          while (i < this.npcList.length) {
             byte j = i;
             while (j > 0) {
                short y0 = this.getNpcListY(j);
                ix = j - 1;
                short y1 = this.getNpcListY(ix);
                if (y0 <= y1) {
                   if (y0 == y1) {
                      if (y0 == y1) {
                         int ix1 = j - 1;
                         if (this.npcList[ix1] == -1) {
                         label_002d :
                            temp = this.npcList[j];
                            int ix2 = j - 1;
                            this.npcList[j] = this.npcList[ix2];
                            ix1 = j - 1;
                            this.npcList[ix1] = temp;
                         }
                      }
                   }else {
                      goto label_002d ;
                   }
                   ix = j - 1;
                   j = (byte)ix;
                }else {
                   break ;
                }
             }
             ix = i + 1;
             i = (byte)ix;
          }
       }
       return;
    }
    public void key_map(){
       if (this.my.state == 17) {
          this.keyMiniMap();
       }else if(this.my.state == 18){
          this.keyMission();
       }else if(this.my.state == 12){
          this.keySelectMenu();
       }else if(this.my.state == 19){
          this.keyMySave();
       }else if(this.my.state == 22 && (this.black_0 > -1 && (this.black_0 == this.gr.about_d.length && Ms.i().key_Num0()))){
          this.eventGoing = 3;
          this.black_0 = -1;
          Ms.i().keyRelease();
       }else if(this.my.state == 16){
          if (!Ms.i().key_delay()) {
             if (Ms.i().key_Up_Down()) {
                Map tgr = this.gr;
                tgr.popMenu = (byte)(tgr.popMenu ^ 0x01);
             }else if(!Ms.i().key_S1_Num5() && !Ms.i().key_S2()){
                if (Ms.i().key_S2()) {
                   this.gr.popMenu = 1;
                }
                this.my.state = 0;
             }
          }
       }else if(this.my.state == 10){
          Ms.i().keyRelease();
       }else if(this.my.state == 23){
          if (Ms.i().key_S2()) {
             this.my.state = 25;
          }else if(Ms.i().key_S1_Num5()){
             this.my.state = 24;
          }
          Ms.i().keyRelease();
       }else if(this.my.state == 11){
          if (Ms.i().key_S1_Num5()) {
             this.gr.say_c = 0;
          }
          if (this.gr.say_c == null) {
             this.my.state = 0;
          }
       }else if(this.my.state == 20){
          this.keyAnoleSel();
       }
       if (this.my.state == 1 && Ms.i().key_S1_Num5()) {
          if (((this.dialog_no + 2)) >= this.dialog.length) {
             this.dialog_no = -1;
             this.dialog = null;
             if (this.eventGoing == null) {
                this.my.state = 0;
             }else {
                this.eventGoing = 2;
             }
             if (this.bDirTalk != null) {
                if ((this.npc[0][this.get_meet].other[7] = this.npcDirTalk) > -1) {
                   this.npc[0][this.get_meet].dir = 3;
                }
                this.bDirTalk = false;
             }
          }else {
             this.dialog_no = (byte)(this.dialog_no + 2);
             Ms.i().keyRelease();
          }
       }
       if (this.my.frame_c <= null && this.my.state == null) {
          Ms.i();
          this.map_key = (byte)(- Ms.key);
          this.doKey();
       }
       return;
    }
    public void loadDate_Rms(){
       byte b = -1;
       byte[] info = Ms.i().rmsOptions(2, null, 1);
       if (info[0] == b) {
          byte[] uobyteArray = new byte[16];
          uobyteArray[0] = 58;
          uobyteArray[1] = 9;
          uobyteArray[2] = 16;
          uobyteArray[3] = 2;
          uobyteArray[5] = 1;
          uobyteArray[6] = 2;
          uobyteArray[15] = b;
          info = uobyteArray;
          Ms.i().rmsOptions(2, uobyteArray, 2);
          uobyteArray = null;
          short[][] oshortArray = new short[][70];
          this.event_now_list = oshortArray;
          Ms.i().rmsOptions(12, Ms.i().getEventNowData(this.event_now_list), 2);
       }else {
          this.event_now_list = Ms.i().readEventNowData();
       }
       this.mapNo = info[0];
       this.lastMap = info[5];
       this.lastExit = info[6];
       this.my.setXY(info[1], info[2], 0, 0);
       this.my.dir = info[3];
       this.my.setActionNo(0);
       this.gr.money = Ms.i().getInt(info, 7);
       this.gr.coin = Ms.i().getInt(info, 11);
       this.anole_type = info[15];
       info = null;
       return;
    }
    public void mapMove(int x,int y,int xs,int ys){
       if (xs > 0 && (x >= this.mapLeft_NOmove && (x < this.mapRight_NOmove || (xs < 0 && (x > this.mapLeft_NOmove && x <= this.mapRight_NOmove))))) {
          this.map_x = this.map_x - xs;
       }
       if (ys > 0 && (y >= this.mapUp_NOmove && (y < this.mapDown_NOmove || (ys < 0 && (y > this.mapUp_NOmove && y <= this.mapDown_NOmove))))) {
          this.map_y = this.map_y - ys;
       }
    label_0032 :
       return;
    }
    public void map_saveGame(){
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
       info = null;
    }
    public void notMeet(int kind,int id){
       int i = 1;
       if (!kind) {
          this.notMeet = 0;
          Ms.i();
          this.step_MEET = (short)(Ms.getRandom(30) + 1);
          this.meet_step = (short)((this.step_MEET - 15) * (this.step_MEET - 15));
          Ms.i();
          if (this.meet_step > Ms.getRandom(50)) {
             Ms.i();
             Ms.i();
             this.step_MEET = (byte)((Ms.getRandom(9) + 17) - Ms.getRandom(7));
          }
          this.step_MEET = (short)(this.step_MEET << 2);
          this.meet_step = 0;
          this.bStep = -1;
       }else if(kind == i){
          this.notMeet = i;
          this.step_MEET = (short)(((id - 14) + 1) * 200);
          this.step_MEET = (short)(this.step_MEET << 2);
          this.meet_step = 0;
          this.bStep = 100;
       }
       return;
    }
    public void nullNpcFace(){
       this.imgFace = null;
    }
    public void paint_map(Graphics g){
       int WIDTH;
       int HEIGHT;
       Map map;
       int i1;
       Map.g = g;
       if (this.my.state == 6) {
          WIDTH = 640;
          HEIGHT = 360;
          this.gr.drawChangeMap(false, this.gr.b_c, 30, (HEIGHT - 38), (WIDTH - 60));
       }else if(this.my.state == 17){
          this.drawMiniMap();
       }else if(this.my.state == 18){
          this.drawMission();
       }else {
          Ui.i().fillRect(this.bgColor, 0, 0, Constants_H.WIDTH, Constants_H.HEIGHT);
          GameRun.mc.setScale(MainCanvas.mapxx, MainCanvas.mapyy);
          GameRun.mc.keyxx = MainCanvas.mapxx;
          GameRun.mc.keyyy = MainCanvas.mapyy;
          this.setMapOffer();
          if (this.xxx > null) {
             this.xxx = (byte)(this.xxx - 1);
             g.translate((this.xxx % 2), (this.xxx % 2));
          }
          this.drawMap(GameRun.offG);
          this.drawNpcAni(this.npc[2]);
          if (this.pkey.isGo != null) {
             map = this.ii;
             this.ii = map + 1;
             if (map > 2) {
                this.ii = 0;
                map = this.i;
                this.i = map + 1;
                map = (map < 2)? this.i: 0;
                this.i = map;
             }
             Ui.i().drawImage(this.walkIco[this.i], (this.pkey.gox + this.map_x), (this.pkey.goy + this.map_y), 3);
          }
          this.drawNMAni(this.npc[0]);
          this.bkgroundToPaint(this.frontData, this.mapImg, (- this.map_x), ((- this.map_y) - 1), this.moduleData, g, 0, 0, Constants_H.WIDTH, Constants_H.HEIGHT, false);
          this.drawNpcAni(this.npc[1]);
          this.drawMapRect(g);
          this.drawStep(g, (Constants_H.WIDTH - 17), 0, 16);
          this.drawBrow();
          this.drawCheck5(4);
          this.drawCloud();
          if (this.gr.magic_id > -1) {
             map = this.gr;
             int i = (((this.gr.magic_id / 5)) > 5)? 5: this.gr.magic_id / 5;
             i1 = (((this.gr.magic_id / 5)) > 5)? 5: this.gr.magic_id / 5;
             int i2 = (((this.gr.magic_id / 5)) >= 5)? this.gr.magic_id - 25: this.gr.magic_id % 5;
             if (map.drawMagicC(i, i1, i2, this.gr.magic_x, (this.gr.magic_y + 16), 0)) {
                if (this.my.state == 21) {
                   map.magic_id = -2;
                   this.setAnole();
                }else {
                   map.magic_id = -1;
                }
                map.state = 0;
             }
          }
          g.translate((- g.getTranslateX()), (- g.getTranslateY()));
          if (this.my.state == 20) {
             this.drawAnoleSel();
          }
          g.restCanvas();
          if (this.fontSizeControl == null) {
             Ms.i();
             Ms.font.setSize(22);
          }
          int FONT_W = 25;
          int FONT_H = 25;
          this.drawSrcEffect();
          if (this.my.state == 12) {
             i1 = Constants_H.WIDTH__ / 2;
             i1 = i1 - (FONT_W * 3);
             this.gr.drawSelectMenu_(this.gr.action_str, i1, (((Constants_H.HEIGHT__ / 2) - 100) + ((this.gr.action_str.length >> 1) * FONT_H)), (FONT_W * 6), 0, 0, this.gr.cur_a);
          }
          if (this.gr.view_state == 4) {
             WIDTH = Constants_H.WIDTH__;
             HEIGHT = Constants_H.HEIGHT__;
             i1 = Constants_H.WIDTH__ / 2;
             byte[] uobyteArray = new byte[3];
             byte[] id = {0x04,0x19,'8'};
             Ui.i().drawKuang(0, (HEIGHT - (FONT_H * 3)), WIDTH, (FONT_H * 3));
             this.gr.showStringM_(this.gr.getNameMonsterInfo(id[this.gr.cur_a]), i1, ((HEIGHT - (FONT_H * 2)) - 8), 10, 3);
             id = null;
          }else if(this.my.state == 16){
             WIDTH = Constants_H.WIDTH__;
             HEIGHT = Constants_H.HEIGHT__;
             i1 = Constants_H.WIDTH__ / 2;
             int HEIGHT_H = Constants_H.HEIGHT__ / 2;
             Ui.i().drawKuang(0, (HEIGHT - (FONT_H * 4)), WIDTH, (FONT_H * 4));
             this.gr.showStringM_("\x66\x02\x54\x02\x56\x02\x59\x02\x62\x02\x67\x02\x5b\x02\x72\x02\xff\x02", i1, ((HEIGHT - (FONT_H * 4)) + 4), 10, 3);
             this.gr.drawSelectMenu_(this.gr.action_str, (i1 - (FONT_W * 2)), (HEIGHT_H - FONT_H), (FONT_W * 4), -1, 0, this.gr.popMenu);
             this.gr.showStringM_("\x62\x02\x97\x02\x91\x02\x98\x02\xff\x02"+this.gr.sell_money, i1, ((HEIGHT - (FONT_H * 3)) + 4), 10, 3);
             this.gr.drawMoney(i1, ((HEIGHT - FONT_H) + 15), 3, false);
          }
          if (this.my.state != 20) {
             this.gr.drawPauseIco(this.my.state);
          }
          if (this.my.state == 19) {
             this.drawMySave();
          }else {
             this.gr.drawCityName();
             if (this.my.state == 23) {
                WIDTH = Constants_H.WIDTH__;
                HEIGHT = Constants_H.HEIGHT__;
                i1 = Constants_H.WIDTH__ / 2;
                Ui.i().drawKuang(0, (HEIGHT - (FONT_H * 2)), WIDTH, (FONT_H * 2));
                Ui.i().drawString("\x66\x02\x54\x02\x4f\x02\x5b\x02\x8f\x02\x5e\x02\xff\x02", i1, ((HEIGHT - (FONT_H * 2)) + 6), 17, 3, 0);
                i1 = 1;
                Ui.i().drawYesNo__(true, i1);
                map.isGo = false;
             }
             if (this.dialog_no > -1) {
                this.dialog(this.npcName);
                map.isGo = false;
             }
             this.gr.map_flashString();
             Ms.i();
             Ms.font.setSize(26);
          }
       }
       return;
    }
    public void run_map(){
       byte b = 6;
       int i = 4;
       if (this.my.state != 9 && this.my.state != b) {
          this.eventCheck();
       }
       if (this.my.state == 5 && this.my.frame_c < 1) {
          this.setMoveStop_m();
          this.my.state = b;
       }
       if (this.my.state == b) {
          this.gr.createOver = 1;
          this.goNextMap();
       }else if(this.my.state == 2 && this.eventGoing == null){
          if (this.npc[0][this.get_meet].other[i] != 1 && (this.npc[0][this.get_meet].other[i] != 3 || this.npc[0][this.get_meet].other[5] <= 0)) {
             this.my.state = 0;
          }else {
             this.npcName = this.npcNameData[this.get_meet];
             if (this.npcName.equals("\x8d\x02\x4e\x02")) {
                this.npcName = null;
             }
             this.initNpcFaceOne(this.npcName);
             Ms.i();
             Ms.font.setSize(22);
             this.dialog = Ms.i().groupString(this.npcStringData[(this.npc[0][this.get_meet].other[5] - 1)], (Constants_H.WIDTH__ - 20));
             if (this.fontSizeControl == null) {
                Ms.i();
                Ms.font.setSize(26);
             }
             this.dialog_no = 0;
             this.my.state = 1;
          }
       }else if(this.my.state == 8 && this.my.frame_c == -1){
          if (this.gr.immueEnemy == null) {
             Log.e("sk", "gr.immueEnemy==0");
             Ms.i();
             this.gr.say(this.gr.battleSay[Ms.getRandom(3)], 0);
             GameRun.mc.repaint();
             this.gr.battleType(i);
             this.gr.goBattlePVC();
          }else {
             this.my.state = 0;
          }
       }
       this.runMove();
       return;
    }
    public void save(){
       this.map_saveGame();
       this.saveNpc();
       int i = 0;
       while (true) {
          int ix = this.mapInfo.length / 2;
          if (i >= ix) {
             break ;
          }else if(this.mapChange[i] == 1){
             this.mapChange[i] = 0;
             int ix1 = i + 14;
             Ms.i().rmsOptions(ix1, this.mapTemp[i], 2);
          }
          i++;
       }
       Ms.i().rmsOptions(13, Ms.i().shortArrayToByteArray(this.mapInfo), 2);
       Ms.i().rmsOptions(12, Ms.i().getEventNowData(this.event_now_list), 2);
       Ms.i().rmsOptions(1, this.mapChange, 2);
       Ms.i().rmsOptions(7, this.bMission, 2);
       Ms.i().rmsOptions(5, this.gr.rmsSms, 2);
       Ms.i().rmsOptions(1, null, 4);
       return;
    }
    public void saveMapBak(){
       this.saveNpc();
       this.mapChange[this.mapNo] = 1;
       Ms.i().rmsOptions(1, this.mapChange, 2);
    }
    public void saveNpc(){
       this.mapTemp[this.mapNo] = null;
       this.mapTemp[this.mapNo] = this.getNpcData();
       this.mapInfo[(this.mapNo * 2)] = 1;
       this.mapChange[this.mapNo] = 1;
    }
    public void setAnole(){
       Map tgr = this.gr;
       int i = (this.anole_type == 3)? 1: 0;
       tgr.immueEnemy = (byte)i;
       this.my.speed = this.getMySpeed();
       Ms ms = Ms.i();
       object oobject = Map.npcSp[1][0];
       String str = "data/npc1/";
       String str1 = (this.anole_type == -1)? "0": "r"+this.anole_type;
       str = str+str1;
       int i1 = (this.anole_type == -1)? 1: 0;
       ms.setSprite(oobject, str, i1);
       this.my.setActionNo(0);
       return;
    }
    public void setMapMusic(boolean bb){
       Sound.i().setMusicId(this.gr.musicNo[this.mapNo]);
       Sound.i().setMusic(bb);
    }
    public void setMission(int id,boolean bb){
       Map tbMission;
       int i = 1;
       byte type = (byte)(id / 8);
       id = (int)(id % 8);
       if (bb) {
          tbMission = this.bMission;
          tbMission[type] = (byte)(tbMission[type] | (i << id));
       }else if((this.bMission[type] & (i << id))){
          tbMission = this.bMission;
          tbMission[type] = (byte)(tbMission[type] ^ (i << id));
          tbMission = this.bMission;
          tbMission[15] = (byte)(tbMission[15] + 1);
       }
       return;
    }
    public void setNull(){
       this.npc[0] = null;
       this.item = null;
       this.door = null;
       this.event = null;
       this.mapImg = null;
       this.moduleData = null;
    }
    public void setOverEvent(int map,int id){
       if (!this.isMapEvent(map, id)) {
          Map tmapInfo = this.mapInfo;
          int i = (map * 2) + 1;
          tmapInfo[i] = (short)(tmapInfo[i] | (1 << id));
       }
       if (map == this.mapNo) {
          this.event_now[id] = 0x5ea0;
       }else if(this.event_now_list[map] != null){
          this.event_now_list[map][id] = 0x5ea0;
       }
       return;
    }
    public synchronized void setRegState(boolean isSuccess){
       System.out.println("setRegState\(\) notifyAll start isSuccess= "+isSuccess);
       this.isNeedWait = false;
       this.notifyAll();
       System.out.println("setRegState\(\) notifyAll over");
    }
    public void setRestEvent(int map,int id){
       if (this.isMapEvent(map, id)) {
          Map tmapInfo = this.mapInfo;
          int i = (map * 2) + 1;
          tmapInfo[i] = (short)(tmapInfo[i] ^ (1 << id));
       }
       if (map == this.mapNo) {
          this.event_now[id] = 0;
       }else if(this.event_now_list[map] != null){
          this.event_now_list[map][id] = 0;
       }
       return;
    }
    public void setTempNull(){
       this.mapTemp = null;
       byte[][] uobyteArray = new byte[][70];
       this.mapTemp = uobyteArray;
    }
    public void setfmap(){
       this.fmap = 0;
    }
}
